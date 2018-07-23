/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package figures;

import org.eclipse.draw2d.ImageFigure;
import org.eclipse.epsilon.eugenia.examples.friends.figures.activator.PluginActivator;

/**
 * @generated
 */
public class PersonFigure extends ImageFigure {

	public PersonFigure() { 
		super(PluginActivator.imageDescriptorFromPlugin(PluginActivator.ID,
				"images/Person.png").createImage(), 0);
	}

}
