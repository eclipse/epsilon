package org.eclipse.epsilon.erl.dt.editor.outline;

import org.eclipse.epsilon.eol.dt.editor.outline.EolModuleElementLabelProvider;
import org.eclipse.epsilon.erl.dom.Post;
import org.eclipse.epsilon.erl.dom.Pre;
import org.eclipse.epsilon.erl.dt.ErlPlugin;
import org.eclipse.swt.graphics.Image;

public class ErlModuleElementLabelProvider extends EolModuleElementLabelProvider{

	@Override
	public Image getImage(Object element) {
		if (element instanceof Pre){
			return ErlPlugin.getDefault().createImage("icons/pre.gif");
		}
		else if (element instanceof Post){
			return ErlPlugin.getDefault().createImage("icons/post.gif");
		}
		else {
			return super.getImage(element);
		}
	}

}