/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.picto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContentTree {
	
	protected List<ContentTree> children = new ArrayList<>();
	protected String content = "";
	protected String name;
	protected String format = "html";
	protected String icon = "folder";
	protected ContentTree parent;
	
	public static void main(String[] args) {
		
		ContentTree pathTree = new ContentTree("");
		pathTree.addPath(Arrays.asList("e1", "e2"), "c1", "text", "");
		pathTree.addPath(Arrays.asList("e1", "e3", "e4"), "c2", "text", "");
		ContentTree result = pathTree.forPath(Arrays.asList("", "e1", "e3", "e4"));
		System.out.println(result.getPath());
		
	}
	
	public ContentTree(String name) {
		this.name = name;
	}
	
	public void addPath(List<String> path, String content, String format, String icon) {
		
		if (path.size() > 1) {
			String name = path.get(0);
			List<String> rest = path.subList(1, path.size());
			ContentTree child = null;
			for (ContentTree candidate : children) {
				if (candidate.getName().equals(name)) {
					child = candidate;
				}
			}
			
			if (child == null) {
				child = new ContentTree(name);
				children.add(child);
			}
			
			child.addPath(rest, content, format, icon);
		}
		else if (path.size() == 1) {
			ContentTree child = null;
			for (ContentTree candidate : children) {
				if (candidate.getName() != null && candidate.getName().equals(path.get(0))) {
					child = candidate;
				}
			}
			
			if (child == null) {
				child = new ContentTree(path.get(0));
				children.add(child);
			}
			
			child.setFormat(format);
			child.setContent(content);
			child.setIcon(icon);
		}
	}
	
	public void ingest(ContentTree other) {
		
		List<ContentTree> obsolete = new ArrayList<>();
		List<ContentTree> fresh = new ArrayList<>(other.getChildren());
		
		for (ContentTree child : getChildren()) {
			ContentTree counterpart = null;
			for (ContentTree otherChild : other.getChildren()) {
				if (child.getName().equals(otherChild.getName())) {
					counterpart = otherChild;
					fresh.remove(counterpart);
					child.setContent(counterpart.getContent());
					child.setFormat(counterpart.getFormat());
					child.setIcon(counterpart.getIcon());
					child.ingest(counterpart);
				}
			}
			if (counterpart == null) {
				obsolete.add(child);
			}
		}
		
		getChildren().removeAll(obsolete);
		getChildren().addAll(fresh);
		
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<ContentTree> getChildren() {
		children.stream().forEach(c -> c.setParent(this));
		return children;
	}
	
	public void setParent(ContentTree parent) {
		this.parent = parent;
	}
	
	public ContentTree getParent() {
		return parent;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getFormat() {
		return format;
	}
	
	public void setFormat(String format) {
		this.format = format;
	}
	
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	public String getIcon() {
		return icon;
	}
	
	@Override
	public String toString() {
		return super.toString();
		//return name + " { content: " + content + " [" + children.stream().map( n -> n.toString() ) .collect( Collectors.joining( "," ) ) + "]";
	}
	
	public List<String> getPath() {
		List<String> path = new ArrayList<>();
		if (parent != null) path.addAll(parent.getPath());
		path.add(this.getName() + "");
		return path;
	}
	
	public ContentTree forPath(List<String> path) {
		if (path.get(0).equals(getName())) {
			if (path.size() > 1) {
				for (ContentTree child : getChildren()) {
					ContentTree forPath = child.forPath(path.subList(1, path.size()));
					if (forPath != null) return forPath;
				}
			}
			else {
				return this;
			}
		}
		
		return null;
	}
	
	public ContentTree getFirstWithContent() {
		if (content != null) return this;
		for (ContentTree child : getChildren()) {
			ContentTree result = child.getFirstWithContent();
			if (result != null) return result;
		}
		return null;
	}
	
}
