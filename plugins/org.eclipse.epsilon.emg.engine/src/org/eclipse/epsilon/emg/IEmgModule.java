package org.eclipse.epsilon.emg;

import java.util.List;
import java.util.Map;

import org.eclipse.epsilon.epl.IEplModule;

public interface IEmgModule extends IEplModule {

	void setSeed(long seed);

	void setUseSeed(boolean useSeed);

	Map<String, List<Object>> getNamedCreatedObjects();

}
