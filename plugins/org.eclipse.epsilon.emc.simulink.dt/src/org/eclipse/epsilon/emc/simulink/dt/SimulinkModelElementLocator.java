package org.eclipse.epsilon.emc.simulink.dt;

import org.eclipse.epsilon.common.dt.locators.IModelElementLocator;
import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.eclipse.epsilon.emc.simulink.SimulinkBlock;
import org.eclipse.epsilon.emc.simulink.SimulinkModel;
import org.eclipse.epsilon.emc.simulink.SimulinkPropertySetter;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;

public class SimulinkModelElementLocator implements IModelElementLocator {

	public SimulinkModelElementLocator() {}

	@Override
	public boolean canLocate(Object o) {
		return o instanceof SimulinkBlock;
	}

	@Override
	public void locate(Object o) {
		SimulinkBlock element = (SimulinkBlock) o;
		SimulinkPropertySetter setter = new SimulinkPropertySetter(((SimulinkModel)element.getOwningModel()).getEngine());
		setter.setProperty("selected");
		setter.setObject(element);
		try {
			setter.invoke("on");
		} catch (EolRuntimeException e) {
			LogUtil.log(e);
		}
	}

}
