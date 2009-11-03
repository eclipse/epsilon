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
package org.eclipse.epsilon.evl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.epsilon.commons.module.AbstractModuleElement;
import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.commons.util.AstUtil;
import org.eclipse.epsilon.eol.EolLabeledBlock;
import org.eclipse.epsilon.eol.annotations.EolAnnotationsUtil;
import org.eclipse.epsilon.eol.exceptions.EolIllegalReturnException;
import org.eclipse.epsilon.eol.exceptions.EolNoReturnException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.flowcontrol.EolReturnException;
import org.eclipse.epsilon.eol.execute.Return;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.types.EolBoolean;
import org.eclipse.epsilon.evl.execute.context.IEvlContext;
import org.eclipse.epsilon.evl.parse.EvlParser;


public class EvlConstraint extends AbstractModuleElement{
	
	public static final int HIGH = 2;
	public static final int MEDIUM = 1;
	public static final int LOW = 0;
	
	protected String name;
	protected boolean isCritique = false;
	protected ArrayList fixes = new ArrayList();
	protected EvlConstraintContext constraintContext;
	protected EolLabeledBlock guard;
	protected EolLabeledBlock body;
	protected EolLabeledBlock message;
	protected int level = EvlConstraint.MEDIUM;
	
	public EvlConstraint() {
		super();
	}
	
	public void build(AST ast) {
		this.ast = ast;
		if (ast.getType() == EvlParser.CRITIQUE){
			isCritique = true;
		}
		this.name = ast.getText();
		this.guard = new EolLabeledBlock(AstUtil.getChild(ast, EvlParser.GUARD),"guard");
		this.body = new EolLabeledBlock(AstUtil.getChild(ast,EvlParser.CHECK),"check");
		this.message = new EolLabeledBlock(AstUtil.getChild(ast, EvlParser.MESSAGE),"message");
		Collection fixesAst = AstUtil.getChildren(ast, EvlParser.FIX);
		Iterator it = fixesAst.iterator();
		while (it.hasNext()){
			EvlFix fix = new EvlFix();
			fix.parse((AST) it.next());
			fixes.add(fix);
		}
	}
	
	public boolean isLazy(IEvlContext context) throws EolRuntimeException {
		return EolAnnotationsUtil.getBooleanAnnotationValue(ast, "lazy", context);
	}
	
	//FIXME : Currently examines only the local guard
	public boolean appliesTo(Object object, IEvlContext context) throws EolRuntimeException{
		
		if (!constraintContext.getAllOfSourceKind(context).contains(object)) return false;
		
		if (guard.getAst() != null) {
			context.getFrameStack().enter(FrameType.PROTECTED, guard.getAst());
			context.getFrameStack().put(Variable.createReadOnlyVariable("self", object));
			Object result = context.getExecutorFactory().executeBlockOrExpressionAst(guard.getAst(), context);
			
			if (result instanceof Return) {
				Object value = Return.getValue(result);
				if (value instanceof EolBoolean){
					return ((EolBoolean) value).getValue();
				}
				else {
					throw new EolIllegalReturnException("Boolean",value,guard.getAst(),context);
				}
			}
			else {
				throw new EolNoReturnException("Boolean", guard.getAst(), context);
			}
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
		
		context.getFrameStack().enter(FrameType.UNPROTECTED, body.getAst());
		context.getFrameStack().put(Variable.createReadOnlyVariable("self", self));
		Object result = context.getExecutorFactory().executeBlockOrExpressionAst(body.getAst(), context);
		if (result instanceof Return) {
			result = Return.getValue(result);
			if (result instanceof EolBoolean){
				boolean check = ((EolBoolean) result).booleanValue();
				if (check == false){
					
					EvlUnsatisfiedConstraint unsatisfiedConstraint = new EvlUnsatisfiedConstraint();
					unsatisfiedConstraint.setInstance(self);
					unsatisfiedConstraint.setConstraint(this);
					ListIterator li = fixes.listIterator();
					while (li.hasNext()) {
						EvlFix fix = (EvlFix) li.next();
						EvlFixInstance fixInstance = new EvlFixInstance(context);
						fixInstance.setFix(fix);
						fixInstance.setSelf(self);
						unsatisfiedConstraint.getFixes().add(fixInstance);
					}
					
					String messageResult = null;
					
					if (message.getAst() != null) {
						Object messageAstResult = context.getExecutorFactory().executeBlockOrExpressionAst(message.getAst(),context);
						if (messageAstResult instanceof Return) {
							messageResult = context.getPrettyPrinterManager().toString(Return.getValue(messageAstResult));	
						}
						else {
							throw new EolNoReturnException("Any", message.getAst(), context);
						}
					}
					else {
						messageResult = "Invariant " + this.getName() + " failed for " + 
							context.getPrettyPrinterManager().toString(self);
					}
					
					unsatisfiedConstraint.setMessage(messageResult);
					
					context.getConstraintTrace().addChecked(this,self,false);
					context.getUnsatisfiedConstraints().add(unsatisfiedConstraint);
					// We don't dispose the frame we leave because it may be needed for fix parts
					context.getFrameStack().leave(body.getAst(), false);
					return false;
				}
				else {
					context.getConstraintTrace().addChecked(this,self,true);
					context.getFrameStack().leave(body.getAst());
					return true;
				}
			}
			else {
				context.getFrameStack().leave(body.getAst());
				throw new EolIllegalReturnException("Boolean",result,body.getAst(),context);
			}	
		}
		else {	
			throw new EolNoReturnException("Boolean", body.getAst(), context);
		}
		
	}
	
	@Override
	public AST getAst() {
		return ast;
	}

	public List getChildren() {
		return Collections.EMPTY_LIST;
	}


	public EvlConstraintContext getConstraintContext() {
		return constraintContext;
	}

	public void setConstraintContext(EvlConstraintContext constraintContext) {
		this.constraintContext = constraintContext;
	}
	
	@Override
	public String toString(){
		return name;
	}

	public String getName() {
		return name;
	}

	public int getLevel() {
		return level;
	}

	public boolean isCritique() {
		return isCritique;
	}

	public void setCritique(boolean isCritique) {
		this.isCritique = isCritique;
	}
	
	
	
}
