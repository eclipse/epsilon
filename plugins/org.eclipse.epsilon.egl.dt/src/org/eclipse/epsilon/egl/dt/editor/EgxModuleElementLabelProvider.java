package org.eclipse.epsilon.egl.dt.editor;

import org.eclipse.epsilon.egl.GenerationRule;
import org.eclipse.epsilon.egl.dt.EglPlugin;
import org.eclipse.epsilon.eol.EolLabeledBlock;
import org.eclipse.epsilon.eol.dt.editor.outline.EolModuleElementLabelProvider;
import org.eclipse.swt.graphics.Image;

public class EgxModuleElementLabelProvider extends EolModuleElementLabelProvider {

	@Override
	public Image getImage(Object element) {
		if (element instanceof EolLabeledBlock){
			return EglPlugin.getDefault().createImage("icons/" + ((EolLabeledBlock) element).getLabel() +".gif");
		}
		else if (element instanceof GenerationRule) {
			return EglPlugin.getDefault().createImage("icons/generationrule.gif");
		} else {
			return super.getImage(element);
		}
	}
	
	
}
