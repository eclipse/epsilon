package org.eclipse.epsilon.eol.dom;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.compile.context.EolCompilationContext;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.EolTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelNotFoundException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.types.EolAnyType;
import org.eclipse.epsilon.eol.types.EolCollectionType;
import org.eclipse.epsilon.eol.types.EolMapType;
import org.eclipse.epsilon.eol.types.EolModelElementType;
import org.eclipse.epsilon.eol.types.EolNativeType;
import org.eclipse.epsilon.eol.types.EolNoType;
import org.eclipse.epsilon.eol.types.EolPrimitiveType;
import org.eclipse.epsilon.eol.types.EolType;

public class TypeExpression extends Expression {
	
	protected EolType type = EolAnyType.Instance;
	protected String name;
	protected List<TypeExpression> parameterTypeExpressions = new ArrayList<>();
	protected StringLiteral nativeType;
	
	public TypeExpression() {}
	
	public TypeExpression(String typeName) {
		setName(typeName);
	}
	
	@Override
	public void build(AST cst, IModule module) {
		super.build(cst, module);
		
		setName(cst.getText());
		for (AST child : cst.getChildren()) {
			ModuleElement moduleElement = module.createAst(child, this);
			
			if (moduleElement instanceof TypeExpression) {
				parameterTypeExpressions.add((TypeExpression) moduleElement);
			}
			else if (name.equals("Native")) {
				nativeType = (StringLiteral) moduleElement;	
			}
		}
	}
	
	@Override
	public Object execute(IEolContext context) throws EolRuntimeException {

		if (type != null) return type;
		
		if (getName().equals("Native")) {
			return new EolNativeType(nativeType, context);
		}
		
		try {
			return new EolModelElementType(name ,context);
		}
		catch (EolModelNotFoundException | EolModelElementTypeNotFoundException ex) {
			throw new EolTypeNotFoundException(getName(), this);
		}
	}
	
	@Override
	public void compile(EolCompilationContext context) {
		
		for (TypeExpression typeExpression : parameterTypeExpressions) {
			typeExpression.compile(context);
		}
		
		if (type instanceof EolCollectionType) {
			if (parameterTypeExpressions.size() == 1) {
				((EolCollectionType) type).setContentType(parameterTypeExpressions.get(0).getCompilationType());
			}
			else if (parameterTypeExpressions.size() > 1) {
				context.addErrorMarker(this, "Collection types can have at most one content type");
			}
		}
		
		if (type instanceof EolMapType) {
			if (parameterTypeExpressions.size() == 2) {
				((EolMapType) type).setKeyType(parameterTypeExpressions.get(0).getCompilationType());
				((EolMapType) type).setValueType(parameterTypeExpressions.get(1).getCompilationType());
			}
			else if (parameterTypeExpressions.size() > 0) {
				context.addErrorMarker(this, "Maps need two types: key-type and value-type");
			}
		}
		
		if (type == null) {
			//TODO: Remove duplication between this and NameExpression
			EolModelElementType modelElementType = context.getModelElementType(name);
			if (modelElementType != null) {
				type = modelElementType;
				if (modelElementType.getMetaClass() == null && !context.getModelDeclarations().isEmpty()) {
					context.addErrorMarker(this, "Unknown type " + name);
				}
			}
			else {
				context.addErrorMarker(this, "Undefined variable or type " + name);
			}
		}
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
			type = new EolMapType();
		}
		else if (name.equals("Sequence") || name.equals("List")){
			type = new EolCollectionType("Sequence");
		}
		else if (name.equals("Bag")){
			type = new EolCollectionType("Bag");
		}
		else if (name.equals("Set")){
			type = new EolCollectionType("Set");
		}
		else if (name.equals("OrderedSet")){
			type = new EolCollectionType("OrderedSet");
		}
		else if (name.equals("Collection")){
			type = new EolCollectionType("Collection");
		}
		else if (name.equals("Nothing")) {
			type = EolNoType.Instance;
		}
	}
	
	public EolType getCompilationType() {
		return type;
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName()+": "+getName();
	}
}
