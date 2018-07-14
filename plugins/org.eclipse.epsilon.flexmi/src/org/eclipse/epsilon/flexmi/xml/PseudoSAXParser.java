package org.eclipse.epsilon.flexmi.xml;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.sax.SAXSource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.epsilon.flexmi.FlexmiDiagnostic;
import org.eclipse.epsilon.flexmi.FlexmiResource;
import org.eclipse.epsilon.flexmi.Template;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.ProcessingInstruction;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

public class PseudoSAXParser {
	
	protected FlexmiResource resource;
	protected URI uri;
	
	public void parse(FlexmiResource resource, InputStream inputStream, Handler handler) throws Exception {
		parse(resource, resource.getURI(), inputStream, handler, true);
	}
	
	public void parse(FlexmiResource resource, URI uri, InputStream inputStream, Handler handler, boolean processDocument) throws Exception  {
		
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();

		DocumentBuilder docBuilder = documentBuilderFactory.newDocumentBuilder();
		Document document = docBuilder.newDocument();

		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		SAXParser saxParser = saxParserFactory.newSAXParser();
		XMLReader xmlReader = saxParser.getXMLReader();
		
		transformer.transform(new SAXSource(new LocationRecorder(xmlReader,document), new InputSource(inputStream)), new DOMResult(document));
		this.resource = resource;
		this.uri = uri;
		
		if (isFlexmiRootNode(document.getDocumentElement())) {
			for (Element templateElement : Xml.getChildren(document.getDocumentElement(), Template.NODE_NAME)) {
				resource.getTemplates().add(new Template(templateElement));
				document.getDocumentElement().removeChild(templateElement);
			}
		}
		else {
			if (isTemplate(document.getDocumentElement())) {
				resource.getTemplates().add(new Template(document.getDocumentElement()));
				document.removeChild(document.getDocumentElement());
				return;
			}
		}
		
		if (processDocument) handler.startDocument(document);
		visit(document, handler);
		if (processDocument) handler.endDocument(document);
	}

	protected void visit(Node node, Handler handler) throws Exception {
		Template template = null;
		
		if (node instanceof Element) {
			if (!isFlexmiRootNode((Element) node)) {
				if (node.getNodeName().startsWith(Template.PREFIX)) {
					String templateName = node.getNodeName().substring(Template.PREFIX.length());
					for (Resource resource : this.resource.getResourceSet().getResources()) {
						if (resource instanceof FlexmiResource) {
							template = ((FlexmiResource) resource).getTemplate(templateName);
							if (template != null) {
								// ((FlexmiResource) resource).startProcessingFragment(resource.getURI());
								for (Element applicationElement : template.apply(node)) {
									visit(applicationElement, handler);
								}
								// ((FlexmiResource) resource).endProcessingFragment();
							}
						}
					}
					if (template == null) {
						resource.getWarnings().add(new FlexmiDiagnostic("Unknown template " + templateName, uri, resource.getLineNumber(node)));
						return;
					}
				}
				else {
					handler.startElement((Element) node);
				}
			}
		}
		if (node instanceof ProcessingInstruction) {
			ProcessingInstruction processingInstruction = (ProcessingInstruction) node;
			String key = processingInstruction.getTarget();
			String value = processingInstruction.getData();
			
			if (key.equalsIgnoreCase("include")) {
				try {
					URI includedURI = URI.createURI(value).resolve(uri);
					InputStream includedInputStream = resource.getResourceSet().getURIConverter().createInputStream(includedURI);
					resource.startProcessingFragment(includedURI);
					new PseudoSAXParser().parse(resource, includedURI, includedInputStream, handler, false);
					resource.endProcessingFragment();
				}
				catch (Exception ex) {
					resource.getWarnings().add(new FlexmiDiagnostic(ex.getMessage(), uri, resource.getLineNumber(processingInstruction)));
				}
			}
			else if (key.equalsIgnoreCase("import")) {
				try {
					URI importedURI = URI.createURI(value).resolve(uri);
					if (resource.getResourceSet().getResource(importedURI, false) == null) {
						Resource importedResource = resource.getResourceSet().createResource(importedURI);
						if (!importedResource.isLoaded()) importedResource.load(null);
					}
				}
				catch (Exception ex) {
					resource.getWarnings().add(new FlexmiDiagnostic(ex.getMessage(), uri, resource.getLineNumber(processingInstruction)));					
				}
			}
			else {
				handler.processingInstruction((ProcessingInstruction) node);
			}
		}
		
		if (template == null) {
			for (int i = 0; i < node.getChildNodes().getLength(); i++) {
				visit(node.getChildNodes().item(i), handler);
			}
			if (node instanceof Element) {
				if (!isFlexmiRootNode((Element) node)) handler.endElement((Element) node);
			}
		}
	}
	
	protected boolean isFlexmiRootNode(Element element) {
		return element.getNodeName().equals(FlexmiResource.ROOT_NODE_NAME) && element.getParentNode() instanceof Document;
	}
	
	protected boolean isTemplate(Element element) {
		return element.getNodeName().equals(Template.NODE_NAME);
	}
	
	public interface Handler {

		public void startDocument(Document document);
		
		public void endDocument(Document document);
		
		public void startElement(Element element);

		public void endElement(Element elemen);

		public void processingInstruction(ProcessingInstruction processingInstruction);
	}

}
