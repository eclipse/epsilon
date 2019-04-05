package org.eclipse.epsilon.flexmi.dt;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ContentTree {
	
	protected List<ContentTree> children = new ArrayList<ContentTree>();
	protected String content;
	protected String name;
	protected String format = "text";
	
	public static void main(String[] args) {
		
		ContentTree pathTree = new ContentTree("");
		pathTree.addPath("e1/e2", "c1", "text");
		pathTree.addPath("e1/e3/e4", "c2", "text");
		System.out.println(pathTree);
	}
	
	public ContentTree(String name) {
		this.name = name;
	}
	
	public void addPath(String path, String content, String format) {
		if (path.indexOf('/') > -1) {
			String name = path.substring(0, path.indexOf('/'));
			String rest = path.substring(path.indexOf('/')+1, path.length());
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
			
			child.addPath(rest, content, format);
		}
		else {
			ContentTree child = null;
			for (ContentTree candidate : children) {
				if (candidate.getName().equals(path)) {
					child = candidate;
				}
			}
			
			if (child == null) {
				child = new ContentTree(path);
				children.add(child);
			}
			
			child.setFormat(format);
			child.setContent(content);
		}
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<ContentTree> getChildren() {
		return children;
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
	
	@Override
	public String toString() {
		//return name + " { content: " + content + " [" + children.stream().map( n -> n.toString() ) .collect( Collectors.joining( "," ) ) + "]";
		return name;
	}
	
}
