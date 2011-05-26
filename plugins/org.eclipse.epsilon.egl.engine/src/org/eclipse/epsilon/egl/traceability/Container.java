/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl.traceability;

import java.net.URI;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("rawtypes")
public abstract class Container<E extends Content> extends Content<Template> {

	private final String name;
	private final URI    uri;
	
	private final List<E> contents = new LinkedList<E>(); 
	
	protected Container(Template parent, String name, URI uri) {
		super(parent);
		
		if (name == null)
			throw new NullPointerException("name cannot be null");
		
		this.name = name;
		this.uri  = uri;
	}
	
	public String getName() {
		return name;
	}
	
	public URI getURI() {
		return uri;
	}
	
	@SuppressWarnings("unchecked")
	public void add(E child) {
		if (child.equals(this)) {
			try {
				throw new IllegalArgumentException();
			} catch(IllegalArgumentException ex) {
				ex.printStackTrace();
			}
		}
		// TODO : Fix unchecked assignment
		child.setParent(this);
		contents.add(child);
	}
	
	public List<E> getChildren() {
		return Collections.unmodifiableList(contents);
	}
	
	public boolean hasChildren() {
		return !contents.isEmpty();
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null) return false;
		if (!(o instanceof Container)) return false;
		
		final Container<?> that = (Container<?>)o;
		return name.equals(that.name) &&
		       (uri == null ? that.uri == null : uri.equals(that.uri)) &&
		       contents.equals(that.contents);
	}
	
	@Override
	public int hashCode() {
		int result = 17;
		
		result += 37 * name.hashCode();
		result += 37 * result + (uri == null ? 0 : uri.hashCode());
		result += 37 * contents.hashCode();
		
		return result;
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		
		sb.append(name);
		
		if (!contents.isEmpty()) {
			sb.append(' ');
			sb.append(contents);
		}
		
		return sb.toString();
	}
}
