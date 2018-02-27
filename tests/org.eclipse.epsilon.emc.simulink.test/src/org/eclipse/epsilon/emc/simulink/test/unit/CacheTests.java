package org.eclipse.epsilon.emc.simulink.test.unit;

import org.eclipse.epsilon.emc.simulink.test.util.AbstractSimulinkTest;
import org.junit.Test;

public class CacheTests extends AbstractSimulinkTest {

	@Test
	public void cacheSimulinkBlockTest() {
		activeCache = true;
		eol = 	"//Create Once"
				+ "//Load"; 
	}
	
	@Test
	public void cacheStateflowBlockTest() {
		activeCache = true;
	}
	
	@Test
	public void cacheDualBlockTest() {
		activeCache = true;
	}
	
}
