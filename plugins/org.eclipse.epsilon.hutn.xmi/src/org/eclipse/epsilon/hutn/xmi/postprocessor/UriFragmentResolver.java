/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************
 *
 * $Id$
 */
package org.eclipse.epsilon.hutn.xmi.postprocessor;

import java.util.Arrays;
import java.util.List;

import org.eclipse.epsilon.hutn.model.hutn.ClassObject;
import org.eclipse.epsilon.hutn.model.hutn.ContainmentSlot;
import org.eclipse.epsilon.hutn.model.hutn.Slot;
import org.eclipse.epsilon.hutn.model.hutn.Spec;

public class UriFragmentResolver {

	private Spec spec;
	
	public UriFragmentResolver(Spec spec)  {
		this.spec = spec;
	}

	public ClassObject resolve(String uriFragment) {
		if (uriFragment.equals("#//")) {
			return getTopLevelObject(0);
		
		} else {
			final List<String> segments = Arrays.asList(uriFragment.substring(2).split("/"));
			
			final int index;
			
			if (segments.get(0).length() == 0) {
				index = 0;
				
			} else {
				try {
					index = Integer.parseInt(segments.get(0));
				} catch (NumberFormatException e) {
					return null; // TODO - test for this
				}
			}
			
			return resolveRelativeTo(getTopLevelObject(index), tail(segments));
		}
	}
	
	private ClassObject getTopLevelObject(int index) {
		return spec.getObjects().get(0).getClassObjects().get(index);
	}
	
	private ClassObject resolveRelativeTo(ClassObject base, List<String> segments) {
		// recurse until no more segments, or base was not found
		if (segments.isEmpty() || base == null)
			return base;
		
		// recurse down list of segments, resolving each segment relative to previous segment
		return resolveRelativeTo(resolveSegment(base, segments.get(0)), tail(segments));
	}
	
	private ClassObject resolveSegment(ClassObject base, String segment) {
		// Segments take the form: @feature.index where index is numeric
		// feature can contain full stops, so lastIndexOf is used
		final String feature = segment.substring(1, segment.lastIndexOf('.'));
		final int    index   = Integer.parseInt(segment.substring(segment.lastIndexOf('.') + 1));
		
		final Slot<?> slot = base.findSlot(feature);
		
		if (!(slot instanceof ContainmentSlot))
			return null;
		
		return getClassObject((ContainmentSlot)slot, index);
	}
	
	private static <T> List<T> tail(List<T> list) {
		return list.subList(1, list.size());
	}
	
	// Doesn't throw an IndexOutOfBoundsException
	private static ClassObject getClassObject(ContainmentSlot slot, int index) {
		if (index < 0 || index >= slot.getClassObjects().size()) {
				return null;
		}
			
		return slot.getClassObjects().get(index);
	}
}
