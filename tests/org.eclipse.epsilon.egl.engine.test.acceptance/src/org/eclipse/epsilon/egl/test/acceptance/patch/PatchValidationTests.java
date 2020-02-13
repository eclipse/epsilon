package org.eclipse.epsilon.egl.test.acceptance.patch;

import static org.junit.Assert.assertFalse;

import org.eclipse.epsilon.egl.patch.Patch;
import org.junit.Test;

public class PatchValidationTests {
	
	public void testInvalidPatchLine() {
		assertFalse(new Patch("foo").isValid());
	}
	
	@Test
	public void testWildcardInvalidAtTheBeginning() {
		assertFalse(new Patch("...", "=1").isValid());
	}
	
	@Test
	public void testWildcardInvalidAtTheEnd() {
		assertFalse(new Patch("=1", "...").isValid());
	}

	@Test
	public void testNoConsecutiveWildcards() {
		assertFalse(new Patch("=1", "...", "...", "=2").isValid());
	}
	
	
}
