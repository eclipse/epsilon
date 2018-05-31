/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.evl.dom;

import java.util.*;
import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.util.AstUtil;
import org.eclipse.epsilon.eol.dom.ExecutableBlock;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.erl.dom.NamedRule;
import org.eclipse.epsilon.evl.execute.FixInstance;
import org.eclipse.epsilon.evl.execute.UnsatisfiedConstraint;
import org.eclipse.epsilon.evl.execute.context.IEvlContext;
import org.eclipse.epsilon.evl.parse.EvlParser;
import org.eclipse.epsilon.evl.trace.ConstraintTrace;

public class Constraint extends NamedRule {
	
	protected boolean isCritique = false;
	protected List<Fix> fixes;
	protected ConstraintContext constraintContext;
	protected ExecutableBlock<Boolean> guardBlock, checkBlock;
	protected ExecutableBlock<String> messageBlock;
	protected volatile boolean checkTrace = false;
	
	@SuppressWarnings("unchecked")
	public void build(AST cst, IModule module) {
		super.build(cst, module);
		if (cst.getType() == EvlParser.CRITIQUE) {
			isCritique = true;
		}
		this.guardBlock = (ExecutableBlock<Boolean>) module.createAst(AstUtil.getChild(cst, EvlParser.GUARD), this);
		this.checkBlock = (ExecutableBlock<Boolean>) module.createAst(AstUtil.getChild(cst,EvlParser.CHECK), this);
		this.messageBlock = (ExecutableBlock<String>) module.createAst(AstUtil.getChild(cst, EvlParser.MESSAGE), this);
		
		List<AST> fixASTs = AstUtil.getChildren(cst, EvlParser.FIX);
		fixes = new ArrayList<>(fixASTs.size());
		
		for (AST fixAst : fixASTs) {
			fixes.add((Fix) module.createAst(fixAst, this));
		}
	}
	
	public boolean isInfo() {
		return isCritique() && hasAnnotation("info");
	}
	
	public boolean isLazy(IEvlContext context) throws EolRuntimeException {
		return getBooleanAnnotationValue("lazy", context);
	}
	
	public boolean shouldBeChecked(Object modelElement, IEvlContext context) throws EolRuntimeException {
		return !isLazy(context) && appliesTo(modelElement, context);
	}
	
	public boolean execute(Object modelElement, IEvlContext context) throws EolRuntimeException {
		return shouldBeChecked(modelElement, context) && check(modelElement, context);
	}

	// FIXME : Currently examines only the local guard
	public boolean appliesTo(Object object, IEvlContext context) throws EolRuntimeException {
		if (guardBlock != null)
			return guardBlock.execute(context, Variable.createReadOnlyVariable("self", object));
		
		return true;
	}

	public boolean optimisedCheck(Object self, IEvlContext context, boolean result) throws EolRuntimeException {
		return postprocessCheck(self, context, preprocessCheck(self, context), result);
	}

	public boolean check(Object self, IEvlContext context) throws EolRuntimeException {
		UnsatisfiedConstraint unsatisfiedConstraint = preprocessCheck(self, context);
		boolean result;
		ConstraintTrace trace;
		
		//Look for a result in the trace first if this constraint is a dependency, otherwise run the check block
		if (checkTrace && (trace = context.getConstraintTrace()).isChecked(this, self)) {
			assert context.getConstraintsDependedOn().contains(this);
			result = trace.isSatisfied(this, self);
		}
		else {
			result = executeCheckBlock(self, context);
		}
		
		return postprocessCheck(self, context, unsatisfiedConstraint, result);
	}

	protected UnsatisfiedConstraint preprocessCheck(Object self, IEvlContext context) {
		UnsatisfiedConstraint unsatisfiedConstraint = new UnsatisfiedConstraint();
		context.getFrameStack()
			.enterLocal(FrameType.UNPROTECTED, checkBlock.getBody())
			.put(
				Variable.createReadOnlyVariable("self", self),
				Variable.createReadOnlyVariable("extras", unsatisfiedConstraint.getExtras())
			);
		return unsatisfiedConstraint;
	}
	
	protected boolean executeCheckBlock(Object self, IEvlContext context) throws EolRuntimeException {
		return checkBlock.execute(context, false);
	}

	protected boolean postprocessCheck(Object self, IEvlContext context, UnsatisfiedConstraint unsatisfiedConstraint, boolean result) throws EolRuntimeException {
		if (!result) {
			unsatisfiedConstraint.setInstance(self);
			unsatisfiedConstraint.setConstraint(this);

			String messageResult = messageBlock != null ?
					messageBlock.execute(context, false) :
					"Invariant "+this.getName()+" failed for "+context.getPrettyPrinterManager().toString(self);

			unsatisfiedConstraint.setMessage(messageResult);
			context.getUnsatisfiedConstraints().add(unsatisfiedConstraint);
			
			Collection<FixInstance> unsatisfiedConstraintFixes = unsatisfiedConstraint.getFixes();
			for (Fix fix : fixes) {
				if (!fix.appliesTo(self, context)) continue;

				FixInstance fixInstance = new FixInstance(context, fix);
				fixInstance.setSelf(self);
				unsatisfiedConstraintFixes.add(fixInstance);
			}
		}

		// Don't dispose the frame we leave if unsatisfied because it may be needed for fix parts
		context.getFrameStack().leaveLocal(checkBlock.getBody(), result);
		return result;
	}

	public boolean guardBlockUsesSatisfies() {
		return guardBlock.getText().contains("satisfies");
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
	
	public boolean isCritique() {
		return isCritique;
	}

	public void setCritique(boolean isCritique) {
		this.isCritique = isCritique;
	}

	public void setCheckTrace(boolean check) {
		this.checkTrace = check;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), constraintContext, isCritique);
	}

	@Override
	public boolean equals(Object other) {
		if (!super.equals(other))
			 return false;
		
		Constraint constraint = (Constraint) other;
		return
			Objects.equals(this.constraintContext, constraint.constraintContext) &&
			Objects.equals(this.isCritique, constraint.isCritique);
	}
}
