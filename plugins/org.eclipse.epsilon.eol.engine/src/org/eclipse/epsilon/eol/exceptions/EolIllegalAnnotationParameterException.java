package org.eclipse.epsilon.eol.exceptions;

import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.eol.dom.Annotation;

public class EolIllegalAnnotationParameterException extends EolRuntimeException {
	
	protected Object value;
	
	public EolIllegalAnnotationParameterException(Object value, ModuleElement annotation) {
		this.ast = annotation;
		this.value = value;
	}

	@Override
	public String getReason() {
		Annotation annotation = (Annotation) ast;
		return "Invalid value for annotation '"+annotation.getName()+"': "+value;
	}

}
