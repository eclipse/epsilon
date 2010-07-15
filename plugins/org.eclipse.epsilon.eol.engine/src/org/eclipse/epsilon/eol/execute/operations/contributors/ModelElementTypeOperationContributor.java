package org.eclipse.epsilon.eol.execute.operations.contributors;

import java.util.Collection;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eol.models.ISearchableModel;
import org.eclipse.epsilon.eol.types.EolModelElementType;
import org.eclipse.epsilon.eol.types.EolSequence;

public class ModelElementTypeOperationContributor extends OperationContributor {
	
	@Override
	public boolean contributesTo(Object target) {
		return target instanceof EolModelElementType;
	}
	
	public Object find(String property, Object value) throws EolRuntimeException {
		EolModelElementType type = (EolModelElementType) target;
		IModel model = context.getModelRepository().getModelByNameSafe(type.getModelName());
		if (model instanceof ISearchableModel) {
			return ((ISearchableModel) model).find(type, property, value);
		}
		else {
			Collection allOfKind = model.getAllOfKind(type.getName());
			Collection results = new EolSequence();
			for (Object o : allOfKind) {
				Object v = model.getPropertyGetter().invoke(o, property);
				if (v instanceof Collection && ((Collection) v).contains(value)) {
					results.add(o);
				}
				else if (value.equals(v)){
					results.add(o);
				}
			}
			return results;
		}
	}
	
	public Object findOne(String property, Object value) throws EolRuntimeException {
		EolModelElementType type = (EolModelElementType) target;
		IModel model = context.getModelRepository().getModelByNameSafe(type.getModelName());
		if (model instanceof ISearchableModel) {
			return ((ISearchableModel) model).findOne(type, property, value);
		}
		else {
			Collection allOfKind = model.getAllOfKind(type.getName());
			for (Object o : allOfKind) {
				Object v = model.getPropertyGetter().invoke(o, property);
				if (v instanceof Collection && ((Collection) v).contains(value)) {
					return o;
				}
				else if (value.equals(v)){
					return o;
				}
			}
			return null;
		}
	}
	
}
