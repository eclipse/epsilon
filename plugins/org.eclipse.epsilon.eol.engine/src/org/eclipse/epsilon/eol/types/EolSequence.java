package org.eclipse.epsilon.eol.types;

import java.util.ArrayList;

import org.eclipse.epsilon.eol.types.CollectionAnnotator.AnnotatedCollectionType;

public class EolSequence extends ArrayList{
	
	public EolSequence() {
		super();
		CollectionAnnotator.getInstance().annotate(this, AnnotatedCollectionType.Sequence);
	}
	
}
