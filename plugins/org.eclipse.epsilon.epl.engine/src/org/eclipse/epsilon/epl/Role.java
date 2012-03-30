package org.eclipse.epsilon.epl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.epsilon.commons.module.AbstractModuleElement;
import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.commons.util.AstUtil;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.Return;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.types.EolModelElementType;
import org.eclipse.epsilon.eol.types.EolSequence;
import org.eclipse.epsilon.epl.combinations.DynamicList;
import org.eclipse.epsilon.epl.combinations.ExceptionHandler;
import org.eclipse.epsilon.epl.parse.EplParser;

public class Role extends AbstractModuleElement {
	
	protected ArrayList<String> names = new ArrayList<String>();
	protected AST typeAst;
	protected Domain domain = null;
	protected Guard guard = null;
	protected EolModelElementType type = null;
	protected boolean negative;
	protected Cardinality cardinality = new Cardinality(1, 1);
	protected AST optionalAst = null;
	protected AST activeAst = null;
	protected boolean isActiveCache = false;
	
	public Role(AST ast) {
		this.ast = ast;
		for (AST nameAst : AstUtil.getChildren(ast, EplParser.NAME)) {
			this.names.add(nameAst.getText());
		}
		this.typeAst = AstUtil.getChild(ast, EplParser.TYPE);
		AST domainAst = AstUtil.getChild(ast, EplParser.DOMAIN);
		if (domainAst != null) {
			domain = new Domain(domainAst, this);
		}
		AST guardAst = AstUtil.getChild(ast, EplParser.GUARD);
		if (guardAst != null) {
			guard = new Guard(guardAst);
		}
		AST noAST = AstUtil.getChild(ast, EplParser.NO);
		negative = (noAST != null);
		
		AST cardinalityAst = AstUtil.getChild(ast, EplParser.CARDINALITY);
		if (cardinalityAst != null) {
			cardinality = new Cardinality(cardinalityAst);
		}
		
		AST optionalAst = AstUtil.getChild(ast, EplParser.OPTIONAL);
		if (optionalAst != null) {
			this.optionalAst = optionalAst.getFirstChild();
		}
		
		AST activeAst = AstUtil.getChild(ast, EplParser.ACTIVE);
		if (activeAst != null) {
			this.activeAst = activeAst.getFirstChild();
		}
		
	}
	
	public Cardinality getCardinality() {
		return cardinality;
	}
	
	public boolean isActive(IEolContext context) throws EolRuntimeException {
		return isActive(context, false);
	}
	
	public boolean isActive(IEolContext context, boolean forceRecompute) throws EolRuntimeException {
		if (forceRecompute) {
			if (activeAst == null) isActiveCache = true;
			else isActiveCache = (Boolean) context.getExecutorFactory().executeBlockOrExpressionAst(activeAst, context, Boolean.class, true);
		}
		return isActiveCache;
	}
	
	public boolean isOptional(IEolContext context) throws EolRuntimeException {
		if (optionalAst == null) return false;
		else return (Boolean) context.getExecutorFactory().executeBlockOrExpressionAst(optionalAst, context, Boolean.class, true);
	}
	
	public boolean isNegative() {
		return negative;
	}
	
	public List<String> getNames() {
		return names;
	}
	
	@Override
	public List getChildren() {
		return Collections.EMPTY_LIST;
	}
	
	public Domain getDomain() {
		return domain;
	}
	
	public Guard getGuard() {
		return guard;
	}
	
	public List getInstances(final IEolContext context) throws EolRuntimeException {
		
		DynamicList<Object> instances = null;
		
		if (domain != null) {
			instances = domain.getValues(context, typeAst.getText());
		}
		else {
			
			instances = new DynamicList<Object>() {
				@Override
				protected List<Object> getValues() throws Exception {
					
					if (!isActive(context, true)) return NoMatch.asList();
					
					if (type == null) {
						type = EolModelElementType.forName(typeAst.getText(), context);
					}

					Collection<?> allInstances = type.getAllOfKind();
					if (allInstances instanceof List) {
						return (List) allInstances;
					}
					else {
						EolSequence sequence = new EolSequence();
						sequence.addAll(allInstances);
						return sequence;
					}
				}
			};
			
		}

		instances.setExceptionHandler(new RuntimeExceptionThrower(context));
		instances.setResetable(instances.isResetable() || activeAst != null);
		
		if (isNegative()) {
			return getNegative(instances, context);
		}
		else if (getCardinality().isMany()) {
			return getAll(instances, context);
		}
		else {
			return instances;
		}
	}
	
	protected List getAll(final DynamicList<Object> instances, final IEolContext context) {
		DynamicList<Object> allValues = new DynamicList<Object>() {
			@Override
			protected List<Object> getValues() throws Exception {
				
				ArrayList<Object> filtered = new ArrayList<Object>();
				
				if (getGuard()!=null) {
					for (Object o : instances) {
						context.getFrameStack().enter(FrameType.UNPROTECTED, getGuard().getAst(), Variable.createReadOnlyVariable(getNames().get(0), o));
						boolean ok = (Boolean) context.getExecutorFactory().executeBlockOrExpressionAst(getGuard().getAst().getFirstChild(), context, Boolean.class, false);
						if (ok) { filtered.add(o); }
						context.getFrameStack().leave(getGuard().getAst());
					}
				}
				else {
					filtered.addAll(instances);
				}
				
				ArrayList<Object> result = new ArrayList<Object>();
				if (getCardinality().isInBounds(filtered.size())) {
					result.add(filtered);
				}
				return result;
			}

			@Override
			public void reset() {
				super.reset();
				instances.reset();
			}
		};
		
		allValues.setExceptionHandler(instances.getExceptionHandler());
		allValues.setResetable(instances.isResetable());
		return allValues;
	}
	
	protected List getNegative(final DynamicList<Object> instances, final IEolContext context) {
		
		DynamicList<Object> negativeDomainValues = new DynamicList<Object>() {

			@Override
			protected List<Object> getValues() throws Exception {
				
				if (getGuard()!=null) {
					for (Object o : instances) {
						boolean result = true;
						Return ret = null;
						context.getFrameStack().enter(FrameType.UNPROTECTED, getGuard().getAst(), Variable.createReadOnlyVariable(getNames().get(0), o));
						ret = (Return) context.getExecutorFactory().executeBlockOrExpressionAst(getGuard().getAst().getFirstChild(), context);
						context.getFrameStack().leave(getGuard().getAst());
						if (ret.getValue() instanceof Boolean) result = (Boolean) ret.getValue();
						if (result == true) {
							return new ArrayList();
						}
					}
				}
				else {
					if (instances.size() > 0) return new ArrayList();
				}
				ArrayList noMatchList = new ArrayList();
				noMatchList.add(NoMatch.INSTANCE);
				return noMatchList;
			}
			
			@Override
			public void reset() {
				super.reset();
				instances.reset();
			}
		};
		
		negativeDomainValues.setExceptionHandler(instances.getExceptionHandler());
		negativeDomainValues.setResetable(instances.isResetable());
		return negativeDomainValues;
		
	}
	
}
