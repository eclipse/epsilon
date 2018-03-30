package org.eclipse.epsilon.eol.dom;

import java.util.ArrayList;
import java.util.Arrays;
import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolIllegalOperationException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.operations.AbstractOperation;
import org.eclipse.epsilon.eol.execute.operations.declarative.IAbstractOperationContributor;
import org.eclipse.epsilon.eol.execute.operations.declarative.IAbstractOperationContributorProvider;
import org.eclipse.epsilon.eol.models.IModel;

public abstract class FeatureCallExpression extends Expression {
		
	protected boolean arrow;
	protected Expression targetExpression;
	
	public boolean isArrow() {
		return arrow;
	}
	
	@Override
	public void build(AST cst, IModule module) {
		super.build(cst, module);
		this.arrow = cst.getText().equals("->");
	}
	
	public Object wrap(Object o) {
		if (o instanceof Object[]) {
			return new ArrayList<>(Arrays.asList((Object[]) o));
		}
		else return o;
	}
	
	protected AbstractOperation getAbstractOperation(Object target, String name, NameExpression featureCallAst, IModel owningModel, IEolContext context) throws EolIllegalOperationException {
		
		// Objects implementing the IAbstractOperationContributor interface
		// can override the default higher-order operation implementations
		if (target instanceof IAbstractOperationContributor) {
			AbstractOperation operation = ((IAbstractOperationContributor) target).getAbstractOperation(name);
			if (operation != null) return operation;
		}
		
		// Since we don't control the interface of all model elements, models
		// can also provide IAbstractOperationContributors for their model elements
		if (owningModel != null && owningModel instanceof IAbstractOperationContributorProvider) {
			IAbstractOperationContributor contributor = ((IAbstractOperationContributorProvider) owningModel).getAbstractOperationContributor(target);
			if (contributor != null) {
				AbstractOperation operation = contributor.getAbstractOperation(name);
				if (operation != null) return operation;					
			}
		}
		
		AbstractOperation operation = context.getOperationFactory().getOperationFor(name);
		if (operation != null) return operation;
		else throw new EolIllegalOperationException(target, name, featureCallAst, context.getPrettyPrinterManager());				
	}
	
	public Expression getTargetExpression() {
		return targetExpression;
	}
	
	public void setTargetExpression(Expression targetExpression) {
		this.targetExpression = targetExpression;
	}
}
