package org.eclipse.epsilon.emc.plainxml;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.eclipse.epsilon.commons.util.StringProperties;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolEnumerationValueNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.exceptions.models.EolNotInstantiableModelElementTypeException;
import org.eclipse.epsilon.eol.execute.introspection.IPropertyGetter;
import org.eclipse.epsilon.eol.execute.introspection.IPropertySetter;
import org.eclipse.epsilon.eol.models.Model;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class PlainXmlModel extends Model {
	
	protected Document document;
	protected String uri;
	protected File file;
	protected ArrayList<Element> createdElements = new ArrayList<Element>();
	
	public static String PROPERTY_FILE = "file";
	public static String PROPERTY_URI = "uri";
	
	@Override
	public Collection<?> allContents() {
		ArrayList<Element> elements = new ArrayList<Element>();
		collectAllElements(document, elements);
		for (Element created : createdElements) {
			if (!elements.contains(created) && created.getParentNode() == null) {
				elements.add(created);
			}
		}
		return elements;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public Document getDocument() {
		return document;
	}

	@Override
	public Object createInstance(String type)
			throws EolModelElementTypeNotFoundException,
			EolNotInstantiableModelElementTypeException {
		return createInstance(type, Collections.EMPTY_LIST);
	}
	
	@Override
	public Object createInstance(String type, Collection<Object> parameters)
			throws EolModelElementTypeNotFoundException,
			EolNotInstantiableModelElementTypeException {
		
		if (parameters.size() == 1) {
			Element newElement = document.createElement(
					parameters.iterator().next() + "");
			createdElements.add(newElement);
			return newElement;
		}
		
		return null;
		
	}

	@Override
	public void deleteElement(Object instance) throws EolRuntimeException {
		if (instance instanceof Element) {
			Element e = (Element) instance;
			if (e.getParentNode() != null) {
				e.getParentNode().removeChild(e);
			}
			createdElements.remove(e);
		}
	}
	
	public void collectAllElements(Node root, ArrayList<Element> elements) {
		if (root instanceof Element) {
			elements.add((Element) root);
		}
		NodeList childNodes = root.getChildNodes();
		for (int i=0; i<childNodes.getLength(); i++) {
			Object o = childNodes.item(i);
			if (o instanceof Element) {
				collectAllElements((Element) o, elements);
			}
		}
		
	}
	
	@Override
	public Collection<?> getAllOfKind(String type)
			throws EolModelElementTypeNotFoundException {
		return getAllOfType(type);
	}

	@Override
	public Collection<?> getAllOfType(String type)
			throws EolModelElementTypeNotFoundException {
		if ("Element".equalsIgnoreCase(type)) {
			return allContents();
		} else {
			throw new EolModelElementTypeNotFoundException(this.getName(), type);
		}
	}

	@Override
	public Object getElementById(String id) {
		return null;
	}

	@Override
	public String getElementId(Object instance) {
		return null;
	}

	@Override
	public Object getEnumerationValue(String enumeration, String label)
			throws EolEnumerationValueNotFoundException {
		return null;
	}

	@Override
	public String getTypeNameOf(Object instance) {
		if (instance instanceof Element) {
			return "Element";
		}
		else {
			return instance.getClass().getName();
		}
	}

	@Override
	public Object getTypeOf(Object instance) {
		return instance.getClass();
	}

	@Override
	public boolean hasType(String type) {
		return "Element".equals(type);
	}

	@Override
	public boolean isInstantiable(String type) {
		return hasType(type);
	}

	@Override
	public boolean isModelElement(Object instance) {
		return (instance instanceof Element);
	}
	
	@Override
	public void load() throws EolModelLoadingException {
		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			
			if (readOnLoad) {
				if (this.file != null) {
					document = documentBuilder.parse(this.file);
				}
				else {
					document = documentBuilder.parse(this.uri);
				}
			}
			else {
				document = documentBuilder.newDocument();
			}
		}
		catch (Exception ex) {
			throw new EolModelLoadingException(ex, this);
		}
	}

	@Override
	public void load(StringProperties properties, String basePath)
			throws EolModelLoadingException {
		
		super.load(properties, basePath);
		
		String filePath = properties.getProperty(PlainXmlModel.PROPERTY_FILE);
		
		if (filePath != null && filePath.trim().length() > 0) {
			if (basePath != null) filePath = basePath + filePath;
			file = new File(filePath);
		}
		else {
			uri = properties.getProperty(PlainXmlModel.PROPERTY_URI);
		}
		
		load();
	}
	
	@Override
	public boolean owns(Object instance) {
		if (instance instanceof Element) {
			Element e = (Element) instance;
			Node parent = e.getParentNode();
			
			if (parent == null) {
				return createdElements.contains(instance);
			}
			else {
				while (parent.getParentNode() != null) {
					parent = parent.getParentNode();
				}
				return parent == document;
			}
		}
		else {
			return false;
		}
	}

	@Override
	public boolean store(String location) {
		
		try {
			Source xmlSource = new DOMSource(document);
			Result result = new StreamResult(new FileOutputStream(location));
	
			// create TransformerFactory
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
	
			// create Transformer for transformation
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty("indent", "yes");	//Java XML Indent
	
			// transform and deliver content to client
			transformer.transform(xmlSource, result);
			return true;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean store() {
		if (file != null) {
			return store(file.getAbsolutePath());
		}
		else {
			return store(uri);
		}
	}

	@Override
	public IPropertyGetter getPropertyGetter() {
		return new PlainXmlPropertyGetter();
	}
	
	@Override
	public IPropertySetter getPropertySetter() {
		return new PlainXmlPropertySetter();
	}
	
}
