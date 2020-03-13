package org.eclipse.epsilon.picto;

import java.io.File;
import java.util.List;

import org.eclipse.epsilon.picto.transformers.ExceptionContentTransformer;
import org.eclipse.epsilon.picto.transformers.ViewContentTransformer;
import org.eclipse.epsilon.picto.transformers.ViewContentTransformerExtensionPointManager;

public class ViewContent {
	
	protected String format;
	protected String text;
	protected File file;
	protected boolean active;
	protected String label;
	protected ViewContent next = undefined;
	protected static final ViewContent undefined = new ViewContent("","");
	
	protected List<ViewContentTransformer> viewContentTransformers = 
			new ViewContentTransformerExtensionPointManager().getExtensions();
	
	public ViewContent(String format, String text) {
		super();
		this.format = format;
		this.text = text;
		for (ViewContentTransformer viewContentTransformer : viewContentTransformers) {
			if (viewContentTransformer.canTransform(this)) this.label = viewContentTransformer.getLabel(this);
		}
	}
	
	public ViewContent(File file) {
		super();
		this.format = "file";
		this.file = file;
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
			for (ViewContentTransformer viewContentTransformer : viewContentTransformers) {
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
	
}
