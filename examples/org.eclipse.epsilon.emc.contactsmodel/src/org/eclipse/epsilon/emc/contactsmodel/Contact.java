package org.eclipse.epsilon.emc.contactsmodel;

public class Contact {
	
	public Contact(String name, String area) {
		super();
		this.name = name;
		this.area = area;
	}

	protected String name;
	protected String area;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getArea() {
		return area;
	}
	
	public void setArea(String area) {
		this.area = area;
	}
	
}
