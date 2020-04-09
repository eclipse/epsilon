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
import java.util.Collections;
import java.util.List;
import org.eclipse.epsilon.picto.dom.Patch;
import org.eclipse.epsilon.picto.transformers.ExceptionContentTransformer;
import org.eclipse.epsilon.picto.transformers.PatchContentTransformer;
import org.eclipse.epsilon.picto.transformers.ViewContentTransformer;
import org.eclipse.epsilon.picto.transformers.ViewContentTransformerExtensionPointManager;

public class ViewContent {
	
	protected String format;
	protected String text;
	protected List<Layer> layers = new ArrayList<>();
	protected boolean active;
	protected String label;
	protected List<Patch> patches = new ArrayList<>();
	protected ViewContent next = undefined;
	protected static final ViewContent undefined = new ViewContent("We shouldn't be here","xxx", Collections.emptyList(), Collections.emptyList());
	
	protected static List<ViewContentTransformer> viewContentTransformers;
	
	public static List<ViewContentTransformer> getViewContentTransformers() {
		if (viewContentTransformers == null) {
			viewContentTransformers = new ArrayList<>();
			viewContentTransformers.add(new PatchContentTransformer());
			viewContentTransformers.addAll(new ViewContentTransformerExtensionPointManager().getExtensions());
		}
		return viewContentTransformers;
	}
	
	public ViewContent(String format, String text, List<Layer> layers, List<Patch> patches) {
		super();
		this.format = format;
		this.text = text;
		this.patches = patches;
		this.layers = layers;
		setLabel();
	}
	
	protected void setLabel() {
		for (ViewContentTransformer viewContentTransformer : getViewContentTransformers()) {
			if (viewContentTransformer.canTransform(this)) this.label = viewContentTransformer.getLabel(this);
		}
	}
	
	public String getFormat() {
		return format;
	}
	
	public String getText() {
		return text;
	}
	
	public ViewContent getFinal(PictoView pictoView) {
		ViewContent final_ = this;
		while (final_.getNext(pictoView) != null) {
			final_ = final_.getNext(pictoView);
		}
		return final_;
	}
	
	public ViewContent getNext(PictoView pictoView) {
		if (next == undefined) {
			for (ViewContentTransformer viewContentTransformer : getViewContentTransformers()) {
				if (viewContentTransformer.canTransform(this)) {
					try {
						next = viewContentTransformer.transform(this, pictoView);
					} catch (Exception e) {
						next = new ExceptionContentTransformer().getViewContent(e, pictoView);
					}
					break;
				}
			}
		}
		if (next == undefined) next = null;
		return next;
	}
	
	public boolean isActive() {
		return active;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}
	
	public String getLabel() {
		return label;
	}
	
	public List<Patch> getPatches() {
		return patches;
	}
	
	public void setPatches(List<Patch> patches) {
		this.patches = patches;
	}
	
	public List<Layer> getLayers() {
		return layers;
	}
	
	@Override
	public String toString() {
		return text;
	}

	public void setNext(ViewContent newContent) {
		next = newContent;
	}

	public ViewContent getSourceContent(PictoView pictoView) {
		return new ViewContent("text", text, layers, patches).getNext(pictoView);
	}
}
