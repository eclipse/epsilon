package org.eclipse.epsilon.flexmi.dt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ContentTree {
	
	protected List<ContentTree> children = new ArrayList<ContentTree>();
	protected String content;
	protected String name;
	protected String format = "text";
	protected String icon = "diagram";
	
	public static void main(String[] args) {
		
		ContentTree pathTree = new ContentTree("");
		pathTree.addPath(Arrays.asList("e1", "e2"), "c1", "text", "");
		pathTree.addPath(Arrays.asList("e1", "e3", "e4"), "c2", "text", "");
		System.out.println(pathTree);
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
				if (candidate.getName().equals(path.get(0))) {
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
		
		List<ContentTree> obsolete = new ArrayList<ContentTree>();
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
	
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	public String getIcon() {
		return icon;
	}
	
	@Override
	public String toString() {
		return name + " { content: " + content + " [" + children.stream().map( n -> n.toString() ) .collect( Collectors.joining( "," ) ) + "]";
	}
	
}
