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

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.epsilon.picto.dom.Patch;
import org.eclipse.swt.graphics.Point;

public class ViewTree {
	
	protected List<ViewTree> children = new ArrayList<>();
	protected ContentPromise promise;
	protected String name = "";
	protected String format = "html";
	protected String icon = "folder";
	protected List<Patch> patches = new ArrayList<>();
	protected ViewTree parent;
	protected Point scrollPosition = new Point(0, 0);
	protected ViewContent cachedContent = null;
	protected List<Layer> layers = new ArrayList<>();
	protected Set<URI> baseUris = new LinkedHashSet<>();
	protected Integer position = null;
	
	public ViewTree() {}

	public ViewTree(String name) {
		this.name = name;
	}
	
	public ViewTree(String content, String format) {
		this.promise = new StaticContentPromise(content);
		this.format = format;
	}
	
	public ViewTree(ContentPromise promise, String format, String icon, List<Patch> patches, List<Layer> layers) {
		super();
		this.promise = promise;
		this.format = format;
		this.icon = icon;
		this.patches = patches;
		this.layers = layers;
	}
	
	public ViewTree(ContentPromise promise, String format, String icon, Integer position, List<Patch> patches, List<Layer> layers) {
		super();
		this.promise = promise;
		this.format = format;
		this.icon = icon;
		this.position = position;
		this.patches = patches;
		this.layers = layers;
	}

	public ViewTree add(List<String> path, ViewTree other) {
		ViewTree child = null;
		
		if (path.size() > 1) {
			String name = path.get(0);
			List<String> rest = path.subList(1, path.size());
			for (ViewTree candidate : children) {
				if (candidate.getName().equals(name)) {
					child = candidate;
				}
			}
			
			if (child == null) {
				child = new ViewTree(name);
				children.add(child);
			}
			
			child.add(rest, other);
		}
		else {
			for (ViewTree candidate : children) {
				if (candidate.getName() != null && candidate.getName().equals(path.get(0))) {
					child = candidate;
				}
			}
			
			if (child == null) {
				child = other;
				child.setName(path.get(0));
				children.add(child);
			}
			else {
				child.setFormat(other.getFormat());
				child.setPromise(other.getPromise());
				child.setIcon(other.getIcon());
				child.setPatches(other.getPatches());
				child.setLayers(other.getLayers());
				child.setPosition(other.getPosition());
			}
			
		}
		return child;
	}
	
	public void ingest(ViewTree other) {
		
		List<ViewTree> obsolete = new ArrayList<>();
		List<ViewTree> fresh = new ArrayList<>(other.getChildren());
		
		for (ViewTree child : getChildren()) {
			ViewTree counterpart = null;
			for (ViewTree otherChild : other.getChildren()) {
				if (child.getName().equals(otherChild.getName())) {
					counterpart = otherChild;
					fresh.remove(counterpart);
					if (counterpart.getPromise() == null) {
						// there might be some content if programmatically defined
						if (counterpart.getCachedContent() != null) {
							child.setContent(counterpart.getCachedContent());
						}
					}
					else {
						child.setPromise(counterpart.getPromise());
					}
					child.setFormat(counterpart.getFormat());
					child.setIcon(counterpart.getIcon());
					preserveLayerState(child, counterpart);
					child.setLayers(counterpart.getLayers());
					child.setPatches(counterpart.getPatches());
					child.setPosition(counterpart.getPosition());
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
	
	protected void preserveLayerState(ViewTree existing, ViewTree _new) {
		for (Layer newLayer : _new.getLayers()) {
			Layer existingLayer = existing.getLayers().stream().filter(l -> l.getId().equals(newLayer.getId())).findFirst().orElse(null);
			if (existingLayer != null) {
				newLayer.setActive(existingLayer.isActive());
			}
		}
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<ViewTree> getChildren() {
		children.stream().forEach(c -> c.setParent(this));
		return children;
	}
	
	public void setParent(ViewTree parent) {
		this.parent = parent;
	}
	
	public ViewTree getParent() {
		return parent;
	}
	
	public ViewContent getContent() {
		if (cachedContent == null) {
			
			if (promise == null) {
				cachedContent = new ViewContent(format, "", null, getLayers(), getPatches());
			}
			else {
				try {
					File file = promise instanceof StaticContentPromise ? ((StaticContentPromise) promise).getFile() : null;
					cachedContent = new ViewContent(format, promise.getContent(), file, getLayers(), getPatches());
				} catch (Exception e) {
					cachedContent = new ViewContent("exception", e.getMessage(), null, getLayers(), getPatches());
				}
			}
		}
		
		return cachedContent;
	}
	
	public List<Patch> getPatches() {
		return patches;
	}
	
	public void setPatches(List<Patch> patches) {
		this.patches = patches;
	}
	
	public List<ViewContent> getContents(PictoView pictoView) {
		List<ViewContent> viewContents = new ArrayList<>();
		ViewContent viewContent = getContent();
		while (viewContent != null) {
			viewContents.add(viewContent);
			viewContent = viewContent.getNext(pictoView);
		}
		return viewContents;
	}
	
	public void setPromise(ContentPromise promise) {
		if (promise != this.promise) {
			this.promise = promise;
			cachedContent = null;
		}
	}
	
	public ContentPromise getPromise() {
		return promise;
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
	
	public Point getScrollPosition() {
		return scrollPosition;
	}
	
	public void setScrollPosition(Point scrollPosition) {
		this.scrollPosition = scrollPosition;
	}

	public List<Layer> getLayers() {
		return layers;
	}
	
	public void setLayers(List<Layer> layers) {
		this.layers = layers;
	}
	
	@Override
	public String toString() {
		return render(this, "");
	}

	private static String render(ViewTree viewTree, String prefix) {
		StringBuilder s = new StringBuilder();
		String content = null;
		if (viewTree.getPromise() != null) {
			try {
				content = viewTree.getPromise().getContent();
			}
			catch (Exception e) {
				content = "ContentError";
			}
			if (content == null) {
				content = "";
			}
			int preferredLength = 20;
			if (content.length() > preferredLength) {
				content = content.substring(0, preferredLength) + "...";
			}
			content = content.replace("\n", " ");
		}
		s.append(String.format("%sViewTree(%s): %s\n", prefix, viewTree.getName(), content));
		for (ViewTree child : viewTree.getChildren()) {
			s.append(render(child, prefix + ">\t"));
		}
		return s.toString();
	}

	public List<String> getPath() {
		List<String> path = new ArrayList<>();
		if (parent != null) path.addAll(parent.getPath());
		path.add(this.getName() + "");
		return path;
	}
	
	public ViewTree forPath(List<String> path) {
		if (path.get(0).equals(getName())) {
			if (path.size() > 1) {
				for (ViewTree child : getChildren()) {
					ViewTree forPath = child.forPath(path.subList(1, path.size()));
					if (forPath != null) return forPath;
				}
			}
			else {
				return this;
			}
		}
		
		return null;
	}
	
	public ViewTree getFirstWithContent() {
		if (promise != null) return this;
		for (ViewTree child : getChildren()) {
			ViewTree result = child.getFirstWithContent();
			if (result != null) return result;
		}
		return null;
	}
	
	public void clearCache() {
		cachedContent = null;
	}
	
	public Set<URI> getBaseUris() {
		if (parent != null) return parent.getBaseUris();
		return baseUris;
	}

	public void setContent(ViewContent content) {
		cachedContent = content;
		promise = null;
	}

	public ViewContent getCachedContent() {
		return cachedContent;
	}
	
	public Integer getPosition() {
		return position;
	}
	
	public void setPosition(Integer position) {
		this.position = position;
	}
	
}
