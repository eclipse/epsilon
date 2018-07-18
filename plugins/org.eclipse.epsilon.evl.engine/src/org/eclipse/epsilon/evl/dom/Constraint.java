/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.evl.dom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.util.AstUtil;
import org.eclipse.epsilon.eol.dom.AnnotatableModuleElement;
import org.eclipse.epsilon.eol.dom.ExecutableBlock;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.erl.dom.NamedRule;
import org.eclipse.epsilon.evl.execute.FixInstance;
import org.eclipse.epsilon.evl.execute.UnsatisfiedConstraint;
import org.eclipse.epsilon.evl.execute.context.IEvlContext;
import org.eclipse.epsilon.evl.parse.EvlParser;

public class Constraint extends NamedRule {
	
	protected boolean isCritique = false;
	protected ArrayList<Fix> fixes = new ArrayList<Fix>();
	protected ConstraintContext constraintContext;
	protected ExecutableBlock<Boolean> guardBlock;
	protected ExecutableBlock<Boolean> checkBlock;
	protected ExecutableBlock<String> messageBlock;
	
	public Constraint() {
		super();
	}
	
	@SuppressWarnings("unchecked")
	public void build(AST cst, IModule module) {
		super.build(cst, module);
		if (cst.getType() == EvlParser.CRITIQUE){
			isCritique = true;
		}
		this.guardBlock = (ExecutableBlock<Boolean>) module.createAst(AstUtil.getChild(cst, EvlParser.GUARD), this);
		this.checkBlock = (ExecutableBlock<Boolean>) module.createAst(AstUtil.getChild(cst,EvlParser.CHECK), this);
		this.messageBlock = (ExecutableBlock<String>) module.createAst(AstUtil.getChild(cst, EvlParser.MESSAGE), this);
		for (AST fixAst : AstUtil.getChildren(cst, EvlParser.FIX)) {
			fixes.add((Fix) module.createAst(fixAst, this));
		}
	}
	
	public boolean isInfo() {
		return isCritique() && hasAnnotation("info");
	}
	
	public boolean isLazy(IEvlContext context) throws EolRuntimeException {
		return getBooleanAnnotationValue("lazy", context);
	}

	/**
	 * Compatibility version of {@link #appliesTo(Object, IEvlContext)} for old clients.
	 */
	public boolean appliesTo(Object object, IEvlContext context) throws EolRuntimeException{
		return appliesTo(object, context, true);
	}

	// FIXME : Currently examines only the local guard
	public boolean appliesTo(Object object, IEvlContext context, final boolean checkType) throws EolRuntimeException{
		if (checkType && !constraintContext.getAllOfSourceKind(context).contains(object)) return false;

		if (guardBlock != null) {
			return guardBlock.execute(context, Variable.createReadOnlyVariable("self", object));
		}
		else {
			return true;
		}
	}

	/**
	 * Compatibility version of {@link #check(Object, IEvlContext, boolean)} for old clients.
	 */
	public boolean check(Object self, IEvlContext context) throws EolRuntimeException {
		return check(self, context, true);
	}

	public boolean check(Object self, IEvlContext context, final boolean checkType) throws EolRuntimeException {
		// First look in the trace
		if (context.getConstraintTrace().isChecked(this,self)){
			return context.getConstraintTrace().isSatisfied(this,self);
		}
		if (!appliesTo(self,context, checkType)) return false;
		
		final UnsatisfiedConstraint unsatisfiedConstraint = preprocessCheck(self, context);
		final Boolean result = checkBlock.execute(context, false);
		return postprocessCheck(self, context, unsatisfiedConstraint, result);
	}

	protected boolean postprocessCheck(Object self, IEvlContext context, UnsatisfiedConstraint unsatisfiedConstraint,
			final Boolean result) throws EolRuntimeException {
		if (!result) {
			unsatisfiedConstraint.setInstance(self);
			unsatisfiedConstraint.setConstraint(this);

			for (Fix fix : fixes) {
				if (!fix.appliesTo(self, context))
					continue;

				FixInstance fixInstance = new FixInstance(context);
				fixInstance.setFix(fix);
				fixInstance.setSelf(self);
				unsatisfiedConstraint.getFixes().add(fixInstance);
			}

			String messageResult = null;

			if (messageBlock != null) {
				messageResult = messageBlock.execute(context, false);
			} else {
				messageResult = "Invariant " + this.getName() + " failed for "
						+ context.getPrettyPrinterManager().toString(self);
			}

			unsatisfiedConstraint.setMessage(messageResult);

			context.getConstraintTrace().addChecked(this, self, false);
			context.getUnsatisfiedConstraints().add(unsatisfiedConstraint);

			// We don't dispose the frame we leave because it may be needed for
			// fix parts
			context.getFrameStack().leaveLocal(checkBlock.getBody(), false);
			return false;
		} else {
			context.getConstraintTrace().addChecked(this, self, true);
			context.getFrameStack().leaveLocal(checkBlock.getBody());
			return true;
		}
	}

	protected UnsatisfiedConstraint preprocessCheck(Object self, IEvlContext context) {
		UnsatisfiedConstraint unsatisfiedConstraint = new UnsatisfiedConstraint();
		context.getFrameStack().enterLocal(FrameType.UNPROTECTED, checkBlock.getBody());
		context.getFrameStack().put(Variable.createReadOnlyVariable("self", self));
		context.getFrameStack().put(Variable.createReadOnlyVariable("extras", unsatisfiedConstraint.getExtras()));
		return unsatisfiedConstraint;
	}

	public List<?> getModuleElements() {
		return Collections.EMPTY_LIST;
	}

	public ConstraintContext getConstraintContext() {
		return constraintContext;
	}

	public void setConstraintContext(ConstraintContext constraintContext) {
		this.constraintContext = constraintContext;
	}
	
	@Override
	public String toString(){
		return getName();
	}
	
	public boolean isCritique() {
		return isCritique;
	}

	public void setCritique(boolean isCritique) {
		this.isCritique = isCritique;
	}

}
