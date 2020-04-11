package org.eclipse.epsilon.picto;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Text;
import org.xml.sax.InputSource;

public class XmlHelper {
	
	protected DocumentBuilder documentBuilder;
	protected Transformer transformer;
	
	public XmlHelper() {
		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			documentBuilderFactory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
			
			transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		}
		catch (Exception ex) { throw new RuntimeException(ex); }
	}
	
	public String getXml(Document document) {
		try {
			StringWriter writer = new StringWriter();
			StreamResult result = new StreamResult(writer);
			transformer.transform(new DOMSource(document.getDocumentElement()), result);
			return writer.toString();
		}
		catch (Exception ex) { throw new RuntimeException(ex); }
	}
	
	public String escapeHtml(String html) {
		try {
			Document document = documentBuilder.newDocument();
			Text text = document.createTextNode(html);
			DOMSource source = new DOMSource(text);
			StringWriter writer = new StringWriter();
			StreamResult result = new StreamResult(writer);
			transformer.transform(source, result);
			return writer.toString();
		}
		catch (Exception ex) {
			return html;
		}
	}
	
	public Document parse(String xml) throws Exception {
		return documentBuilder.parse(new InputSource(new StringReader(xml)));
	}
	
}
