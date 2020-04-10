package org.eclipse.epsilon.picto.transformers.elements;

import java.util.Collections;

import org.eclipse.epsilon.picto.ViewContent;
import org.w3c.dom.Element;

public class RenderCodeElementTransformer extends ReplacingElementTransformer {
	
	@Override
	public String getXPath() {
		return "//pre[starts-with(@class,'language-render')]";
	}
	
	@Override
	public void transform(Element element) {
		
		String text = element.getChildNodes().item(0).getTextContent();
		String format = element.getAttribute("class").substring("language-render-".length());
		ViewContent viewContent = new ViewContent(format, text, null, Collections.emptyList(), Collections.emptyList());
		ViewContent svgContent = null;
		ViewContent lastContent = null;
		
		while (viewContent != null) {
			if ("svg".equals(viewContent.getFormat())) {
				svgContent = viewContent;
				break;
			}
			else {
				lastContent = viewContent;
				viewContent = viewContent.getNext(picto);
			}
		}
		
		if (svgContent != null) {
			replace(element, svgContent, true);
		}
		else {
			replace(element, lastContent, false);
		}
	}
}