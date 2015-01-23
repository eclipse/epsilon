package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.eol.compile.context.IEolCompilationContext;
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
	protected String name = null;
	
	public TypeExpression() {}
	
	public TypeExpression(String typeName) {
		setName(typeName);
	}
	
	@Override
	public void build() {
		super.build();
		setName(getText());
	}
	
	@Override
	public Object execute(IEolContext context) throws EolRuntimeException {

		if (type != null) return type;
		
		if (getName().equals("Native")){
			return new EolNativeType(this.getFirstChild(), context);
		}
		
		try {
			return EolModelElementType.forName(name ,context);
		}
		catch (EolModelNotFoundException ex){
			// Ignore
		}
		catch (EolModelElementTypeNotFoundException mex){
			// Ignore
		}
		
		throw new EolTypeNotFoundException(getName(), this);
	}
	
	@Override
	public void compile(IEolCompilationContext context) {
		// TODO Auto-generated method stub		
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
		type = null;
		if (name.equals("Integer")){
			type = EolPrimitiveType.Integer;
		}
		else if (name.equals("Any")){
			type = EolAnyType.Instance;
		}
		else if (name.equals("Boolean")){
			type = EolPrimitiveType.Boolean;
		}
		else if (name.equals("String")){
			type = EolPrimitiveType.String;
		}
		else if (name.equals("Real") ) {
			type = EolPrimitiveType.Real;
		}
		else if (name.equals("Map")){
			type = EolPrimitiveType.Map;
		}
		else if (name.equals("Sequence") || name.equals("List")){
			type = EolCollectionType.Sequence;
		}
		else if (name.equals("Bag")){
			type = EolCollectionType.Bag;
		}
		else if (name.equals("Set")){
			type = EolCollectionType.Set;
		}
		else if (name.equals("OrderedSet")){
			type = EolCollectionType.OrderedSet;
		}
		else if (name.equals("Collection")){
			type = EolCollectionType.Collection;
		}
		else if (name.equals("Nothing")) {
			type = EolNoType.Instance;
		}
	}
}
