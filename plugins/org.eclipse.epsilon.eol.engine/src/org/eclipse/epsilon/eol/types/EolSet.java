package org.eclipse.epsilon.eol.types;

import java.util.HashSet;

import org.eclipse.epsilon.eol.types.CollectionAnnotator.AnnotatedCollectionType;

public class EolSet extends HashSet{
	
	public EolSet() {
		super();
		CollectionAnnotator.getInstance().annotate(this, AnnotatedCollectionType.Set);
	}
	
}
