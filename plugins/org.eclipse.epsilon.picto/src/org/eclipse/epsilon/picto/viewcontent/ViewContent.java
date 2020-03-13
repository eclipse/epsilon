package org.eclipse.epsilon.picto.viewcontent;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.eclipse.epsilon.picto.ViewRenderer;

public class ViewContent {
	
	protected String format;
	protected String text;
	protected File file;
	protected ViewContent next = undefined;
	protected static final ViewContent undefined = new ViewContent("","");
	
	protected List<ViewContentTransformer> viewContentTransformers = Arrays.asList(
			new GraphvizTransformer(), 
			new SvgTransformer(), 
			new ExceptionTransformer(),
			new TextTransformer());
	
	public ViewContent(String format, String text) {
		super();
		this.format = format;
		this.text = text;
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
						next = new ExceptionTransformer().getViewContent(e, renderer);
					}
					break;
				}
			}
		}
		if (next == undefined) next = null;
		return next;
	}
}