package org.eclipse.epsilon.egl.test.acceptance.patch;

import static org.junit.Assert.assertTrue;

import org.eclipse.epsilon.egl.patch.Patch;

public class PatchTestsBase {
	
	protected Patch createPatch(String... lines) {
		Patch patch = new Patch(lines);
		assertTrue(patch.isValid());
		return patch;
	}
	
}
