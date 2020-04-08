package org.eclipse.epsilon.picto;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class XmlTest {
	
	public static void main(String[] args) throws Exception {
		new XmlTest().run();
	}
	
	public void run() throws Exception {
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		
		documentBuilderFactory.setValidating(false);
		documentBuilderFactory.setFeature("http://xml.org/sax/features/namespaces", false);
		documentBuilderFactory.setFeature("http://xml.org/sax/features/validation", false);
		//documentBuilderFactory.setFeature("http://apache.org/xml/features/nonvalidating/load-dtd-grammar", false);
		documentBuilderFactory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
		documentBuilderFactory.setExpandEntityReferences(false);
		
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DocumentBuilder docBuilder = documentBuilderFactory.newDocumentBuilder();
		
		Document document = docBuilder.parse(new InputSource(new StringReader(getSvg())));
		
		/*
		docBuilder.setEntityResolver(new EntityResolver() {
			
			@Override
			public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
				System.out.println("here");
				return null;
			}
		});*/
		
		/*
		Document document = docBuilder.newDocument();
		document.setStrictErrorChecking(false);
		
		long now = System.currentTimeMillis();
		transformer.transform(new SAXSource(new InputSource(new BufferedInputStream(new ByteArrayInputStream(getSvg().getBytes())))), new DOMResult(document));
		System.out.println(System.currentTimeMillis() - now);*/
		
		
		
		Document target = docBuilder.parse(new InputSource(new StringReader("<root/>")));
		Element documentElement = document.getDocumentElement();
		
		target.importNode(documentElement, true);
		target.adoptNode(documentElement);
		target.getDocumentElement().appendChild(documentElement);
		//updateNamespace(documentElement, target);
		
		StringWriter writer = new StringWriter();
		StreamResult result = new StreamResult(writer);
		
		transformer.transform(new DOMSource(target.getDocumentElement()), result);
		System.out.println(writer.toString());
		
	}
	
	private static void updateNamespace(Node node, Document document) {

        // first process this node
        processSingleNodeNamespace(node, document);

        // then its attributes
        NamedNodeMap attributes = node.getAttributes();
        if (attributes != null) {
            for (int i = 0, n = attributes.getLength(); i < n; i++) {
                Node attribute = attributes.item(i);
                if (!processSingleNodeNamespace(attribute, document)) {
                    String nsUri = attribute.getNamespaceURI();
                    if (nsUri != null) {
                        attributes.removeNamedItemNS(nsUri, attribute.getLocalName());
                    } else {
                        attributes.removeNamedItem(attribute.getLocalName());
                    }
                }
            }
        }

        // then do it for the children nodes.
        NodeList children = node.getChildNodes();
        if (children != null) {
            for (int i = 0, n = children.getLength(); i < n; i++) {
                Node child = children.item(i);
                if (child != null) {
                    updateNamespace(child, document);
                }
            }
        }
    }
	
	private static boolean processSingleNodeNamespace(Node node, Document document) {
        if ("xmlns".equals(node.getLocalName())) {
            return false;
        }

        String ns = node.getNamespaceURI();
        if (ns != null) {
            NamedNodeMap docAttributes = document.getAttributes();

            String prefix = getPrefixForNs(docAttributes, ns);
            if (prefix == null) {
                prefix = getUniqueNsAttribute(docAttributes);
                Attr nsAttr = document.createAttribute(prefix);
                nsAttr.setValue(ns);
                document.getChildNodes().item(0).getAttributes().setNamedItem(nsAttr);
            }

            // set the prefix on the node, by removing the xmlns: start
            prefix = prefix.substring(6);
            node.setPrefix(prefix);
        }

        return true;
    }
	
	/**
     * Looks for an existing prefix for a a given namespace.
     * The prefix must start with "xmlns:". The whole prefix is returned.
     * @param attributes the list of attributes to look through
     * @param ns the namespace to find.
     * @return the found prefix or null if none is found.
     */
    private static String getPrefixForNs(NamedNodeMap attributes, String ns) {
        if (attributes != null) {
            for (int i = 0, n = attributes.getLength(); i < n; i++) {
                Attr attribute = (Attr) attributes.item(i);
                if (ns.equals(attribute.getValue()) /*&& ns.startsWith(SdkConstants.XMLNS_PREFIX)*/) {
                    return attribute.getName();
                }
            }
        }

        return null;
    }

    private static String getUniqueNsAttribute(NamedNodeMap attributes) {
        if (attributes == null) {
            return "xmlns:ns1";
        }

        int i = 2;
        while (true) {
            String name = String.format("xmlns:ns%d", i++);
            if (attributes.getNamedItem(name) == null) {
                return name;
            }
        }
    }
	public String getSvg() {
		return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n" + 
				"<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.1//EN\"\n" + 
				" \"http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd\">\n" + 
				"<!-- Generated by graphviz version 2.43.0 (0)\n" + 
				" -->\n" + 
				"<!-- Title: G Pages: 1 -->\n" + 
				"<svg width=\"525pt\" height=\"146pt\"\n" + 
				" viewBox=\"0.00 0.00 525.00 146.00\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\">\n" + 
				"<g id=\"graph0\" class=\"graph\" transform=\"scale(1 1) rotate(0) translate(4 142)\">\n" + 
				"<title>G</title>\n" + 
				"<polygon fill=\"white\" stroke=\"transparent\" points=\"-4,4 -4,-142 521,-142 521,4 -4,4\"/>\n" + 
				"<!-- _Connector -->\n" + 
				"<g id=\"node1\" class=\"node\">\n" + 
				"<title>_Connector</title>\n" + 
				"<polygon fill=\"#c8f0a1\" stroke=\"transparent\" points=\"270.5,-7 270.5,-59 342.5,-59 342.5,-7 270.5,-7\"/>\n" + 
				"<polyline fill=\"none\" stroke=\"black\" points=\"271.5,-38 341.5,-38 \"/>\n" + 
				"<image xlink:href=\"/var/folders/_m/f55wjwdj2vj_7fvlqdk_72jr0000gp/T/picto6000785063223617806EClass.gif\" width=\"12px\" height=\"12px\" preserveAspectRatio=\"xMinYMin meet\" x=\"276.5\" y=\"-54\"/>\n" + 
				"<g id=\"a_node1_0\"><a xlink:href=\"javascript:top.showElement('//Connector','platform:/resource/org.eclipse.epsilon.examples.picto.ecore/comps.ecore')\" xlink:title=\"Go to Connector in the Ecore editor\">\n" + 
				"<text text-anchor=\"start\" x=\"292.5\" y=\"-46\" font-family=\"Tahoma\" font-size=\"10.00\">Connector</text>\n" + 
				"</a>\n" + 
				"</g>\n" + 
				"<image xlink:href=\"/var/folders/_m/f55wjwdj2vj_7fvlqdk_72jr0000gp/T/picto5065465767003177389EReference.gif\" width=\"12px\" height=\"12px\" preserveAspectRatio=\"xMinYMin meet\" x=\"272.5\" y=\"-35\"/>\n" + 
				"<text text-anchor=\"start\" x=\"286.39\" y=\"-27\" font-family=\"Tahoma\" font-size=\"10.00\" fill=\"blue\">from : Port &#160;</text>\n" + 
				"<image xlink:href=\"/var/folders/_m/f55wjwdj2vj_7fvlqdk_72jr0000gp/T/picto5065465767003177389EReference.gif\" width=\"12px\" height=\"12px\" preserveAspectRatio=\"xMinYMin meet\" x=\"272.5\" y=\"-21\"/>\n" + 
				"<text text-anchor=\"start\" x=\"286.5\" y=\"-13\" font-family=\"Tahoma\" font-size=\"10.00\" fill=\"blue\">to : Port &#160;</text>\n" + 
				"<polygon fill=\"none\" stroke=\"black\" points=\"270.5,-7 270.5,-59 342.5,-59 342.5,-7 270.5,-7\"/>\n" + 
				"</g>\n" + 
				"<!-- _Port -->\n" + 
				"<g id=\"node4\" class=\"node\">\n" + 
				"<title>_Port</title>\n" + 
				"<polygon fill=\"#fffcdc\" stroke=\"transparent\" points=\"386,0 386,-66 517,-66 517,0 386,0\"/>\n" + 
				"<polyline fill=\"none\" stroke=\"black\" points=\"387.5,-45 516.5,-45 \"/>\n" + 
				"<image xlink:href=\"/var/folders/_m/f55wjwdj2vj_7fvlqdk_72jr0000gp/T/picto6000785063223617806EClass.gif\" width=\"12px\" height=\"12px\" preserveAspectRatio=\"xMinYMin meet\" x=\"435.5\" y=\"-61\"/>\n" + 
				"<g id=\"a_node4_1\"><a xlink:href=\"javascript:top.showView('/Model/Classes/Port')\" xlink:title=\"Show class diagram for Port\">\n" + 
				"<text text-anchor=\"start\" x=\"451.5\" y=\"-53\" font-family=\"Tahoma\" font-size=\"10.00\">Port</text>\n" + 
				"</a>\n" + 
				"</g>\n" + 
				"<image xlink:href=\"/var/folders/_m/f55wjwdj2vj_7fvlqdk_72jr0000gp/T/picto5065465767003177389EReference.gif\" width=\"12px\" height=\"12px\" preserveAspectRatio=\"xMinYMin meet\" x=\"388.5\" y=\"-42\"/>\n" + 
				"<text text-anchor=\"start\" x=\"402.16\" y=\"-34\" font-family=\"Tahoma\" font-size=\"10.00\">incoming : Connector[*] &#160;</text>\n" + 
				"<image xlink:href=\"/var/folders/_m/f55wjwdj2vj_7fvlqdk_72jr0000gp/T/picto5065465767003177389EReference.gif\" width=\"12px\" height=\"12px\" preserveAspectRatio=\"xMinYMin meet\" x=\"388.5\" y=\"-28\"/>\n" + 
				"<text text-anchor=\"start\" x=\"402.5\" y=\"-20\" font-family=\"Tahoma\" font-size=\"10.00\">outgoing : Connector[*] &#160;</text>\n" + 
				"<image xlink:href=\"/var/folders/_m/f55wjwdj2vj_7fvlqdk_72jr0000gp/T/picto5065465767003177389EReference.gif\" width=\"12px\" height=\"12px\" preserveAspectRatio=\"xMinYMin meet\" x=\"388.5\" y=\"-14\"/>\n" + 
				"<text text-anchor=\"start\" x=\"402.5\" y=\"-6\" font-family=\"Tahoma\" font-size=\"10.00\">type : Type &#160;</text>\n" + 
				"<polygon fill=\"none\" stroke=\"black\" points=\"386,0 386,-66 517,-66 517,0 386,0\"/>\n" + 
				"</g>\n" + 
				"<!-- _Connector&#45;&gt;_Port -->\n" + 
				"<g id=\"edge3\" class=\"edge\">\n" + 
				"<title>_Connector&#45;&gt;_Port</title>\n" + 
				"<g id=\"a_edge3\"><a xlink:title=\"from\">\n" + 
				"<path fill=\"none\" stroke=\"black\" d=\"M349.72,-41C349.72,-41 378.84,-41 378.84,-41\"/>\n" + 
				"<polygon fill=\"black\" stroke=\"black\" points=\"385.84,-41 378.84,-44.15 382.34,-41 378.84,-41 378.84,-41 378.84,-41 382.34,-41 378.84,-37.85 385.84,-41 385.84,-41\"/>\n" + 
				"<polygon fill=\"black\" stroke=\"black\" points=\"342.72,-41 349.72,-37.85 346.22,-41 349.72,-41 349.72,-41 349.72,-41 346.22,-41 349.72,-44.15 342.72,-41 342.72,-41\"/>\n" + 
				"</a>\n" + 
				"</g>\n" + 
				"</g>\n" + 
				"<!-- _Connector&#45;&gt;_Port -->\n" + 
				"<g id=\"edge4\" class=\"edge\">\n" + 
				"<title>_Connector&#45;&gt;_Port</title>\n" + 
				"<g id=\"a_edge4\"><a xlink:title=\"to\">\n" + 
				"<path fill=\"none\" stroke=\"black\" d=\"M349.72,-24C349.72,-24 378.84,-24 378.84,-24\"/>\n" + 
				"<polygon fill=\"black\" stroke=\"black\" points=\"385.84,-24 378.84,-27.15 382.34,-24 378.84,-24 378.84,-24 378.84,-24 382.34,-24 378.84,-20.85 385.84,-24 385.84,-24\"/>\n" + 
				"<polygon fill=\"black\" stroke=\"black\" points=\"342.72,-24 349.72,-20.85 346.22,-24 349.72,-24 349.72,-24 349.72,-24 346.22,-24 349.72,-27.15 342.72,-24 342.72,-24\"/>\n" + 
				"</a>\n" + 
				"</g>\n" + 
				"</g>\n" + 
				"<!-- _Connector_Constraints -->\n" + 
				"<g id=\"node2\" class=\"node\">\n" + 
				"<title>_Connector_Constraints</title>\n" + 
				"<polygon fill=\"mistyrose\" stroke=\"transparent\" points=\"1.5,-17 1.5,-49 226.5,-49 226.5,-17 1.5,-17\"/>\n" + 
				"<text text-anchor=\"start\" x=\"5.22\" y=\"-37\" font-family=\"Tahoma\" font-size=\"10.00\">ConnectsPortsWithSameType: &#160;A connector must </text>\n" + 
				"<text text-anchor=\"start\" x=\"5.5\" y=\"-25\" font-family=\"Tahoma\" font-size=\"10.00\">connect ports of the same type </text>\n" + 
				"<polygon fill=\"none\" stroke=\"black\" points=\"0,-16 0,-50 227,-50 227,-16 0,-16\"/>\n" + 
				"</g>\n" + 
				"<!-- _Connector_Constraints&#45;&gt;_Connector -->\n" + 
				"<g id=\"edge1\" class=\"edge\">\n" + 
				"<title>_Connector_Constraints&#45;&gt;_Connector</title>\n" + 
				"<path fill=\"none\" stroke=\"black\" stroke-dasharray=\"5,2\" d=\"M227.16,-33C242.71,-33 257.65,-33 270.28,-33\"/>\n" + 
				"</g>\n" + 
				"<!-- _Connector_Documentation -->\n" + 
				"<g id=\"node3\" class=\"node\">\n" + 
				"<title>_Connector_Documentation</title>\n" + 
				"<polygon fill=\"azure\" stroke=\"black\" points=\"400.46,-138 206.54,-138 206.54,-102 406.46,-102 406.46,-132 400.46,-138\"/>\n" + 
				"<polyline fill=\"none\" stroke=\"black\" points=\"400.46,-138 400.46,-132 \"/>\n" + 
				"<polyline fill=\"none\" stroke=\"black\" points=\"406.46,-132 400.46,-132 \"/>\n" + 
				"<text text-anchor=\"start\" x=\"214.52\" y=\"-118.04\" font-family=\"Tahoma\" font-size=\"10.00\">Connectors connect ports of components </text>\n" + 
				"</g>\n" + 
				"<!-- _Connector_Documentation&#45;&gt;_Connector -->\n" + 
				"<g id=\"edge2\" class=\"edge\">\n" + 
				"<title>_Connector_Documentation&#45;&gt;_Connector</title>\n" + 
				"<path fill=\"none\" stroke=\"black\" stroke-dasharray=\"5,2\" d=\"M306.5,-101.97C306.5,-89.63 306.5,-73.06 306.5,-59.26\"/>\n" + 
				"</g>\n" + 
				"</g>\n" + 
				"</svg>\n" + 
				"";
	}
	
	
}
