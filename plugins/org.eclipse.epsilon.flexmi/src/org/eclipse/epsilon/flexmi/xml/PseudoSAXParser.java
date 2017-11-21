package org.eclipse.epsilon.flexmi.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.sax.SAXSource;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.ProcessingInstruction;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class PseudoSAXParser {

	public static void main(String[] args) throws Exception {
		new PseudoSAXParser().parse(new FileInputStream(new File("plugin.xml")), new Handler() {
			
			@Override
			public void startElement(Element element) {
				System.out.println("Starting " + element.getNodeName() + " -> " + element.getUserData(Location.ID));
			}
			
			@Override
			public void startDocument(Document document) {
				
			}
			
			@Override
			public void processingInstruction(ProcessingInstruction instruction) {
				System.out.println(instruction.getTarget() + " -> " + ((Node)instruction).getUserData(Location.ID));
			}
			
			@Override
			public void endElement(Element element) {
				//System.out.println("Ending " + element.getNodeName());
			}

			@Override
			public void endDocument(Document document) {
				
			}
			
		});
	}

	public void parse(InputStream inputStream, Handler handler) throws ParserConfigurationException, SAXException, TransformerException  {
		//Stopwatch stopwatch = new Stopwatch();
		//stopwatch.resume();
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();

		DocumentBuilder docBuilder = documentBuilderFactory.newDocumentBuilder();
		Document document = docBuilder.newDocument();

		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		SAXParser saxParser = saxParserFactory.newSAXParser();
		XMLReader xmlReader = saxParser.getXMLReader();
		
		transformer.transform(new SAXSource(new LocationRecorder(xmlReader,document), new InputSource(inputStream)), new DOMResult(document));
		//stopwatch.pause();
		//System.out.print(stopwatch.getElapsed()+", ");
		
		handler.startDocument(document);
		visit(document, handler);
		handler.endDocument(document);
	}

	protected void visit(Node node, Handler handler) {
		if (node instanceof Element) {
			handler.startElement((Element) node);
		}
		if (node instanceof ProcessingInstruction) {
			handler.processingInstruction((ProcessingInstruction) node);
		}
		for (int i = 0; i < node.getChildNodes().getLength(); i++) {
			visit(node.getChildNodes().item(i), handler);
		}
		if (node instanceof Element) {
			handler.endElement((Element) node);
		}
	}
	
	public interface Handler {

		public void startDocument(Document document);
		
		public void endDocument(Document document);
		
		public void startElement(Element element);

		public void endElement(Element element);

		public void processingInstruction(ProcessingInstruction processingInstruction);
	}

}
