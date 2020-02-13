package org.eclipse.epsilon.egl.test.acceptance.patch;

import static org.junit.Assert.assertEquals;

import org.eclipse.epsilon.egl.patch.Match;
import org.eclipse.epsilon.egl.patch.Patch;
import org.eclipse.epsilon.egl.patch.TextBlock;
import org.junit.Test;

public class WildcardTests extends PatchTestsBase {
	
	@Test
	public void testWildCard() {
		Patch patch = createPatch("=1", "...", "=4", ">5");
		TextBlock block = new TextBlock("1","2","3","4");
		assertEquals(new TextBlock("1", "2", "3", "4", "5"), patch.apply(block));
	}
	
	@Test
	public void testWildCard2() {
		Patch patch = createPatch("=1", "=2", "...", "=4", ">5");
		TextBlock block = new TextBlock("1","2","3","4");
		assertEquals(new TextBlock("1", "2", "3", "4", "5"), patch.apply(block));
	}
	
	@Test
	public void testWildCard3() {
		Patch patch = createPatch("=1", "=2", "...", ">5");
		TextBlock block = new TextBlock("1","2","3","4");
		assertEquals(new TextBlock("1", "2", "3", "4", "5"), patch.apply(block));
	}
	
	@Test
	public void testWildCard4() {
		Patch patch = createPatch("=1", "=2", "...", "=4");
		TextBlock block = new TextBlock("1","2","3","4");
		assertEquals(new TextBlock("1", "2", "3", "4"), patch.apply(block));
	}
	
	@Test
	public void testWildCard5() {
		Patch patch = createPatch("=1", "=2", "...", "<4");
		TextBlock block = new TextBlock("1","2","3","4");
		assertEquals(new TextBlock("1", "2", "3"), patch.apply(block));
	}
	
	@Test
	public void testWildCard6() {
		Patch patch = createPatch("=1", "...", "<4");
		TextBlock block = new TextBlock("1","2","3","4");
		assertEquals(new TextBlock("1", "2", "3"), patch.apply(block));
	}
	
	@Test
	public void testWildCard7() {
		Patch patch = createPatch(">0", "...", "=2");
		TextBlock block = new TextBlock("1","2", "3");
		assertEquals(new TextBlock("0", "1", "2", "3"), patch.apply(block));
	}
}
