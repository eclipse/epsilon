package org.eclipse.epsilon.epl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.epsilon.commons.module.AbstractModuleElement;
import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.Return;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eol.types.EolOrderedSet;
import org.eclipse.epsilon.epl.combinations.DynamicList;
import org.eclipse.epsilon.epl.combinations.ExceptionHandler;

public class Domain extends AbstractModuleElement {
	
	protected boolean dynamic = false;
	protected Role role;
	
	public Domain(AST ast, Role role) {
		this.ast = ast;
		this.dynamic = "from".equals(ast.getText());
		this.role = role;
	}
	
	@Override
	public List getChildren() {
		return Collections.EMPTY_LIST;
	}
	
	public DynamicList<Object> getValues(final IEolContext context, final String type) throws EolRuntimeException {
		
		DynamicList<Object> r = new DynamicList<Object>() {
			@Override
			protected List<Object> getValues() throws Exception {
		
				if (!role.isActive(context, true)) return NoMatch.asList();
				
				Object result = context.getExecutorFactory().executeBlockOrExpressionAst(ast.getFirstChild(), context, Object.class, Collections.EMPTY_LIST);
				
				if (!(result instanceof Collection)) {
					List<Object> results = new ArrayList<Object>();
					results.add(result);
					result = results;
				}
				
				ArrayList<Object> filtered = new ArrayList<Object>();
				for (Object o : (Collection<?>) result) {
					IModel owningModel = context.getModelRepository().getOwningModel(o);
					if (owningModel!=null && owningModel.isOfType(o, type)) {
						filtered.add(o);
					}
				}
				
				return filtered;
			}
		};
		
		r.setResetable(isDynamic());
		return r;
		
	}
	
	public boolean isDynamic() {
		return dynamic;
	}
	
}
