package org.eclipse.epsilon.emc.plainxml;

public class PlainXmlProperty {
	
	protected boolean many;
	protected boolean attribute;
	protected boolean element;
	protected boolean reference;
	protected boolean text;
	protected String property;
	protected PlainXmlPropertyType type;
	
	public static PlainXmlProperty parse(String property) {
		PlainXmlProperty p = new PlainXmlProperty();
		
		if (property.startsWith("a_") || property.startsWith("b_") ||
			property.startsWith("i_") || property.startsWith("f_") || 
			property.startsWith("d_") || property.startsWith("s_")) {
			
			p.type = p.typeFor(property.charAt(0) + "");
			
			p.element = false;
			p.reference = false;
			p.text = property.substring(2).equals("text");
			p.attribute = !p.text;
			
			p.many = false;
			
		} else if (property.startsWith("e_")) {
			p.attribute = false;
			p.reference = false;
			p.element = true;
			p.text = false;
			
			p.many = false;
		} else if (property.startsWith("c_")) {
			p.attribute = false;
			p.element = true;
			p.reference = false;
			p.text = false;
			
			p.many = true;
		} else if (property.startsWith("x_")) {
			p.attribute = false;
			p.element = false;
			p.reference = true;
			p.text = false;
		} else {
			p = null;
		}
		
		if (p!=null) {
			p.property = property.substring(2);
		}
		
		return p;
	}
	
	public Object cast(String value) {
		value = value.trim();
		
		if (type == PlainXmlPropertyType.BOOLEAN) {
			return Boolean.parseBoolean(value);
		}
		else if (type == PlainXmlPropertyType.INTEGER) {
			try {
				return Integer.parseInt(value);
			}
			catch (NumberFormatException ex) {
				return 0;
			}
		}
		else if (type == PlainXmlPropertyType.FLOAT) {
			try {
				return Float.parseFloat(value);
			}
			catch (NumberFormatException ex) {
				return 0.0f;
			}
		}
		else if (type == PlainXmlPropertyType.DOUBLE) {
			try {
				return Double.parseDouble(value);
			}
			catch (NumberFormatException ex) {
				return 0.0d;
			}
		}
		else {
			return value;
		}
	
	}
	
	private PlainXmlPropertyType typeFor(String letter) {
		if (letter.equals("b")) {
			return PlainXmlPropertyType.BOOLEAN;
		}
		else if (letter.equals("f")) {
			return PlainXmlPropertyType.FLOAT;
		}
		else if (letter.equals("d")) {
			return PlainXmlPropertyType.DOUBLE;
		}
		else if (letter.equals("i")){
			return PlainXmlPropertyType.INTEGER;
		}
		else {
			return PlainXmlPropertyType.STRING;
		}
	}
	
	public String getProperty() {
		return property;
	}

	public boolean isAttribute() {
		return attribute;
	}

	public boolean isElement() {
		return element;
	}
	
	public boolean isText() {
		return text;
	}
	
	public boolean isMany() {
		return many;
	}

	public boolean isReference() {
		return reference;
	}
	
}
