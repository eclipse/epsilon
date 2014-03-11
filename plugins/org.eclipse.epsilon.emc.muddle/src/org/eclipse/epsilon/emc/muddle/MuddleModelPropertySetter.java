package org.eclipse.epsilon.emc.muddle;

import java.util.Collection;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.introspection.AbstractPropertySetter;
import org.eclipse.epsilon.eol.execute.introspection.java.JavaPropertySetter;

public class MuddleModelPropertySetter extends AbstractPropertySetter {

	protected MuddleModel model;
	
	public MuddleModelPropertySetter(MuddleModel model) {
		this.model = model;
	}
	
	@Override
	public void invoke(Object value) throws EolRuntimeException {
		
		MuddleElement element = (MuddleElement) object;
		
		Feature feature = getFeature(element, property);
		if (feature == null) {
			feature = MuddleFactory.eINSTANCE.createFeature();
			feature.setName(property);
			element.getType().getFeatures().add(feature);
			feature.setMany(value instanceof Collection<?>);
			feature.setRuntime(true);
		}
		else {
			model.getUnusedFeatures().remove(feature);
		}
		
		if (value instanceof Collection<?>) feature.setMany(true);
		
		Slot slot = getSlot(element, feature);
		if (slot == null) {
			slot = MuddleFactory.eINSTANCE.createSlot();
			slot.setFeature(feature);
			element.getSlots().add(slot);
		}
		
		slot.getValues().clear();
		if (value instanceof Collection<?>) {
			slot.getValues().addAll((Collection<?>) value);
		}
		else {
			slot.getValues().add(value);
		}
	}
	
	protected Slot getSlot(MuddleElement element, Feature feature) {
		for (Slot slot : element.getSlots()) {
			if (slot.getFeature() == feature) {
				return slot;
			}
		}
		return null;
	}
	
	protected Feature getFeature(MuddleElement element, String property) {
		
		for (Feature feature : element.getType().getFeatures()) {
			if (feature.getName().equals(property)) {
				return feature;
			}
		}
		
		return null;
		
	}
}
