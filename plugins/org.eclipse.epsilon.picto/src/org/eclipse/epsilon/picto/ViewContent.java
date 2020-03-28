package org.eclipse.epsilon.picto;

import java.io.File;
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
	protected File file;
	protected List<Layer> layers = new ArrayList<>();
	protected boolean active;
	protected String label;
	protected List<Patch> patches = new ArrayList<>();
	protected ViewContent next = undefined;
	protected static final ViewContent undefined = new ViewContent("We shouldn't be here","xxx", Collections.emptyList(), Collections.emptyList());
	
	protected static List<ViewContentTransformer> viewContentTransformers;
	
	static List<ViewContentTransformer> getViewContentTransformers() {
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
	
	//TODO: Delete
	public ViewContent(String format, File file, List<Layer> layers, List<Patch> patches) {
		super();
		this.format = format;
		this.file = file;
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
	
	public File getFile() {
		return file;
	}
	
	public ViewContent getFinal(ViewRenderer renderer) {
		ViewContent final_ = this;
		while (final_.getNext(renderer) != null) {
			final_ = final_.getNext(renderer);
		}
		return final_;
	}
	
	public ViewContent getNext(ViewRenderer renderer) {
		if (next == undefined) {
			for (ViewContentTransformer viewContentTransformer : getViewContentTransformers()) {
				if (viewContentTransformer.canTransform(this)) {
					try {
						next = viewContentTransformer.transform(this, renderer);
					} catch (Exception e) {
						next = new ExceptionContentTransformer().getViewContent(e, renderer);
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
	
}
