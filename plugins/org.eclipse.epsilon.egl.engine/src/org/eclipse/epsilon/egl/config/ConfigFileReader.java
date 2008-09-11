/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl.config;

import java.io.InputStream;
import java.util.Map;

import org.eclipse.epsilon.egl.merge.partition.CompositePartitioner;

public interface ConfigFileReader {

	public Map<String, CompositePartitioner> read(InputStream stream) throws PersistenceException;
}
