/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
