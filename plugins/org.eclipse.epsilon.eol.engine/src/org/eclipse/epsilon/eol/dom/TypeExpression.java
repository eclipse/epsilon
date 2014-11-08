package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.EolTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelNotFoundException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.types.EolAnyType;
import org.eclipse.epsilon.eol.types.EolCollectionType;
import org.eclipse.epsilon.eol.types.EolModelElementType;
import org.eclipse.epsilon.eol.types.EolNativeType;
import org.eclipse.epsilon.eol.types.EolNoType;
import org.eclipse.epsilon.eol.types.EolPrimitiveType;
import org.eclipse.epsilon.eol.types.EolType;


public class TypeExpression extends Expression {
	
	protected EolType type = null;
	protected String typeName = null;
	
	public TypeExpression() {
		super();
	}
	
	public TypeExpression(String typeName) {
		setTypeName(typeName);
	}
	
	public String getTypeName() {
		return typeName;
	}
	
	public void setTypeName(String typeName) {
		this.typeName = typeName;
		type = null;
		if (typeName.equals("Integer")){
			type = EolPrimitiveType.Integer;
		}
		else if (typeName.equals("Any")){
			type = EolAnyType.Instance;
		}
		else if (typeName.equals("Boolean")){
			type = EolPrimitiveType.Boolean;
		}
		else if (typeName.equals("String")){
			type = EolPrimitiveType.String;
		}
		else if (typeName.equals("Real") ) {
			type = EolPrimitiveType.Real;
		}
		else if (typeName.equals("Map")){
			type = EolPrimitiveType.Map;
		}
		else if (typeName.equals("Sequence") || typeName.equals("List")){
			type = EolCollectionType.Sequence;
		}
		else if (typeName.equals("Bag")){
			type = EolCollectionType.Bag;
		}
		else if (typeName.equals("Set")){
			type = EolCollectionType.Set;
		}
		else if (typeName.equals("OrderedSet")){
			type = EolCollectionType.OrderedSet;
		}
		else if (typeName.equals("Collection")){
			type = EolCollectionType.Collection;
		}
		else if (typeName.equals("Nothing")) {
			type = EolNoType.Instance;
		}
	}
	
	@Override
	public void build() {
		super.build();
		setTypeName(getText());
	}
	
	
	@Override
	public Object execute(IEolContext context) throws EolRuntimeException {

		if (type != null) return type;
		
		if (getTypeName().equals("Native")){
			return new EolNativeType(this.getFirstChild(), context);
		}
		
		try {
			return EolModelElementType.forName(typeName ,context);
		}
		catch (EolModelNotFoundException ex){
			// Ignore
		}
		catch (EolModelElementTypeNotFoundException mex){
			// Ignore
		}
		
		throw new EolTypeNotFoundException(getTypeName(), this);
	}

}
