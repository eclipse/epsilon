package org.eclipse.epsilon.eol.types;

import java.util.List;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;

public class EolMapType extends EolType {
	
	protected EolType keyType = EolAnyType.Instance;
	protected EolType valueType = EolAnyType.Instance;
	
	public EolMapType() {}
	
	public EolMapType(EolType keyType, EolType valueType) {
		super();
		this.keyType = keyType;
		this.valueType = valueType;
	}

	@Override
	public String getName() {
		return "Map";
	}

	@Override
	public boolean isType(Object o) {
		return o.getClass() == EolMap.class;
	}

	@Override
	public boolean isKind(Object o) {
		return o instanceof EolMap;
	}

	@Override
	public Object createInstance() throws EolRuntimeException {
		return new EolMap<>();
	}

	@Override
	public Object createInstance(List<Object> parameters) throws EolRuntimeException {
		return new EolMap<>();
	}
	
	public void setKeyType(EolType keyType) {
		this.keyType = keyType;
	}
	
	public EolType getKeyType() {
		return keyType;
	}
	
	public void setValueType(EolType valueType) {
		this.valueType = valueType;
	}
	
	public EolType getValueType() {
		return valueType;
	}
	
	@Override
	public String toString() {
		return "Map<" + keyType + ", " + valueType + ">";
	}
	
}
