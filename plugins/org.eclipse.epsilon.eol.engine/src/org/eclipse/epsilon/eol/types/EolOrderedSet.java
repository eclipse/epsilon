package org.eclipse.epsilon.eol.types;

import java.util.LinkedHashSet;

import org.eclipse.epsilon.eol.types.CollectionAnnotator.AnnotatedCollectionType;

public class EolOrderedSet extends LinkedHashSet{
	
	public EolOrderedSet() {
		super();
		CollectionAnnotator.getInstance().annotate(this, AnnotatedCollectionType.OrderedSet);
	}
}
