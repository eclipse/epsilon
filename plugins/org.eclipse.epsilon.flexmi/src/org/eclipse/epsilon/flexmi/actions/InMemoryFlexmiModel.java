package org.eclipse.epsilon.flexmi.actions;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.epsilon.emc.emf.EmfPropertyGetter;
import org.eclipse.epsilon.emc.emf.InMemoryEmfModel;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.introspection.IPropertyGetter;
import org.eclipse.epsilon.flexmi.FlexmiResource;

public class InMemoryFlexmiModel extends InMemoryEmfModel {
	
	public InMemoryFlexmiModel(FlexmiResource resource) {
		super(resource);
	}
	
	protected IPropertyGetter propertyGetter = new FlexmiModelPropertyGetter();
	
	@Override
	public IPropertyGetter getPropertyGetter() {
		return propertyGetter;
	}
	
	@Override
	public boolean owns(Object instance) {
		return super.owns(instance);
	}
	
	@Override
	public boolean knowsAboutProperty(Object instance, String property) {
		return (owns(instance) && propertyGetter.hasProperty(instance, property)) || super.knowsAboutProperty(instance, property);
	}
	
	class FlexmiModelPropertyGetter extends EmfPropertyGetter {
		
		@Override
		public boolean hasProperty(Object object, String property) {
			return getChild(object, property) != null || super.hasProperty(object, property);
		}
		
		@Override
		public Object invoke(Object object, String property) throws EolRuntimeException {
			EObject child = getChild(object, property);
			if (child != null) return child;
			return super.invoke(object, property);
		}
		
		protected EObject getChild(Object container, String id) {
			for (EObject content : ((EObject) container).eContents()) {
				if (id.equals(((FlexmiResource) modelImpl).getLocalId(content))) {
					return content;
				}
			}
			return null;
		}
		
	}
	
}
