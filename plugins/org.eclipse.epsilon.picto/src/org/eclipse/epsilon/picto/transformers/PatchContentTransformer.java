package org.eclipse.epsilon.picto.transformers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.epsilon.egl.patch.Line;
import org.eclipse.epsilon.egl.patch.TextBlock;
import org.eclipse.epsilon.picto.ViewContent;
import org.eclipse.epsilon.picto.ViewRenderer;
import org.eclipse.epsilon.picto.dom.Patch;

public class PatchContentTransformer implements ViewContentTransformer {

	@Override
	public boolean canTransform(ViewContent content) {
		return content.getPatches().stream().anyMatch(p -> p.getFormat().equals(content.getFormat()));
	}

	@Override
	public String getLabel(ViewContent content) {
		return "Patched " + content.getLabel();
	}

	@Override
	public ViewContent transform(ViewContent content, ViewRenderer renderer) throws Exception {
		List<Patch> appliedPatches = new ArrayList<>();
		String patchedText = content.getText();
		for (Patch patch : content.getPatches()) {
			if (patch.getFormat().equals(content.getFormat())) {
				
				org.eclipse.epsilon.egl.patch.Patch p = new org.eclipse.epsilon.egl.patch.Patch(patch.getContent().split(System.lineSeparator()));
				TextBlock b = new TextBlock(patchedText.split(System.lineSeparator()));
				
				patchedText = p.apply(b).getLines().stream()
						.map(Line::getText)
						.collect(Collectors.joining(System.lineSeparator()));
				
				appliedPatches.add(patch);
			}
		}
		
		List<Patch> remainingPatches = new ArrayList<>(content.getPatches());
		remainingPatches.removeAll(appliedPatches);
		return new ViewContent(content.getFormat(), patchedText, remainingPatches);
		
	}

}
