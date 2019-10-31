/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.epl.dom;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.epsilon.eol.dom.ExecutableBlock;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eol.types.EolType;
import org.eclipse.epsilon.epl.combinations.DynamicList;

public class Domain extends ExecutableBlock<Object> {
	
	protected boolean dynamic = false;
	protected Role role;
	
	public Domain() {
		super(Object.class);
	}
	
	public void setRole(Role role) {
		this.dynamic = "from".equals(getText());
		this.role = role;
	}
	
	public DynamicList<Object> getValues(final IEolContext context, final EolType type) throws EolRuntimeException {
		
		DynamicList<Object> r = new DynamicList<Object>() {
			@Override
			protected List<Object> getValues() throws Exception {
		
				if (!role.isActive(context, true)) return NoMatch.asList();
				
				Object result =  context.getExecutorFactory().execute(Domain.this, context);
			
				if (!(result instanceof Collection)) {
					List<Object> results = new ArrayList<>();
					results.add(result);
					result = results;
				}
				
				ArrayList<Object> filtered = new ArrayList<>();
				for (Object o : (Collection<?>) result) {
					//IModel owningModel = context.getModelRepository().getOwningModel(o);
					if (type.isKind(o)) {
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
