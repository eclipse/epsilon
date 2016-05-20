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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.util.AstUtil;
import org.eclipse.epsilon.eol.dom.AnnotatableModuleElement;
import org.eclipse.epsilon.eol.dom.ExecutableBlock;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.evl.execute.FixInstance;
import org.eclipse.epsilon.evl.execute.UnsatisfiedConstraint;
import org.eclipse.epsilon.evl.execute.context.IEvlContext;
import org.eclipse.epsilon.evl.parse.EvlParser;

public class Constraint extends AnnotatableModuleElement {
	
	protected String name;
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
	public void build() {
		super.build();
		if (getType() == EvlParser.CRITIQUE){
			isCritique = true;
		}
		this.name = getText();
		this.guardBlock = (ExecutableBlock<Boolean>) AstUtil.getChild(this, EvlParser.GUARD);
		this.checkBlock = (ExecutableBlock<Boolean>) AstUtil.getChild(this,EvlParser.CHECK);
		this.messageBlock = (ExecutableBlock<String>) AstUtil.getChild(this, EvlParser.MESSAGE);
		for (AST fixAst : AstUtil.getChildren(this, EvlParser.FIX)) {
			fixes.add((Fix) fixAst);
		}
	}
	
	public boolean isInfo() {
		return isCritique() && hasAnnotation("info");
	}
	
	public boolean isLazy(IEvlContext context) throws EolRuntimeException {
		return getBooleanAnnotationValue("lazy", context);
	}
	
	//FIXME : Currently examines only the local guard
	public boolean appliesTo(Object object, IEvlContext context) throws EolRuntimeException{
		if (!constraintContext.getAllOfSourceKind(context).contains(object)) return false;
		if (guardBlock != null) {
			return guardBlock.execute(context, Variable.createReadOnlyVariable("self", object));
		}
		else {
			return true;
		}
	}

	public boolean check(Object self, IEvlContext context) throws EolRuntimeException {
		
		// First look in the trace
		if (context.getConstraintTrace().isChecked(this,self)){
			return context.getConstraintTrace().isSatisfied(this,self);
		}
		
		if (!appliesTo(self,context)) return false;
		
		UnsatisfiedConstraint unsatisfiedConstraint = new UnsatisfiedConstraint();
		
		context.getFrameStack().enterLocal(FrameType.UNPROTECTED, checkBlock.getBody());
		context.getFrameStack().put(Variable.createReadOnlyVariable("self", self));
		context.getFrameStack().put(Variable.createReadOnlyVariable("extras", unsatisfiedConstraint.getExtras()));
		
		if (!checkBlock.execute(context, false)){
			
			unsatisfiedConstraint.setInstance(self);
			unsatisfiedConstraint.setConstraint(this);

			for (Fix fix : fixes) {
				if (!fix.appliesTo(self, context)) continue;

				FixInstance fixInstance = new FixInstance(context);
				fixInstance.setFix(fix);
				fixInstance.setSelf(self);
				unsatisfiedConstraint.getFixes().add(fixInstance);
			}
			
			String messageResult = null;
			
			if (messageBlock != null) {
				messageResult = messageBlock.execute(context, false);
			}
			else {
				messageResult = "Invariant " + this.getName() + " failed for " + 
					context.getPrettyPrinterManager().toString(self);
			}
			
			unsatisfiedConstraint.setMessage(messageResult);
			
			context.getConstraintTrace().addChecked(this,self,false);
			context.getUnsatisfiedConstraints().add(unsatisfiedConstraint);
			// We don't dispose the frame we leave because it may be needed for fix parts
			context.getFrameStack().leaveLocal(checkBlock.getBody(), false);
			return false;
		}
		else {
			context.getConstraintTrace().addChecked(this,self,true);
			context.getFrameStack().leaveLocal(checkBlock.getBody());
			return true;
		}
		
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
		return name;
	}

	public String getName() {
		return name;
	}

	public boolean isCritique() {
		return isCritique;
	}

	public void setCritique(boolean isCritique) {
		this.isCritique = isCritique;
	}

	protected ExecutableBlock<Boolean> getGuardBlock() {
		return guardBlock;
	}

	protected ExecutableBlock<Boolean> getCheckBlock() {
		return checkBlock;
	}

	protected ExecutableBlock<String> getMessageBlock() {
		return messageBlock;
	}

}
