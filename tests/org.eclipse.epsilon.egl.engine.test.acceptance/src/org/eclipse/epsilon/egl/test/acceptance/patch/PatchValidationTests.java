package org.eclipse.epsilon.egl.test.acceptance.patch;

import static org.junit.Assert.assertFalse;

import org.eclipse.epsilon.egl.patch.Patch;
import org.junit.Test;

public class PatchValidationTests {
	
	public void testInvalidPatchLine() throws Exception {
		assertFalse(new Patch("foo").isValid());
	}
	
	@Test
	public void testWildcardInvalidAtTheBeginning() throws Exception {
		assertFalse(new Patch("...", "=1").isValid());
	}
	
	@Test
	public void testWildcardInvalidAtTheEnd() throws Exception {
		assertFalse(new Patch("=1", "...").isValid());
	}

	@Test
	public void testNoConsecutiveWildcards() throws Exception {
		assertFalse(new Patch("=1", "...", "...", "=2").isValid());
	}
	
	
}
