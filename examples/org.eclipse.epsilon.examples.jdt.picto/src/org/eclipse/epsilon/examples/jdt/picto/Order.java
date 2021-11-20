package org.eclipse.epsilon.examples.jdt.picto;

import java.util.ArrayList;
import java.util.List;

public class Order implements Shippable {
	
	protected List<OrderItem> items = new ArrayList<>();
	protected Employee seller;
	
	public List<OrderItem> getItems() {
		return items;
	}
	
	public Employee getSeller() {
		return seller;
	}
	
	public void setSeller(Employee seller) {
		this.seller = seller;
	}
	
	@Override
	public void shipTo(Address address) {
		
	}
}
