package org.eclipse.epsilon.egl.test.acceptance.patch;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.eclipse.epsilon.egl.patch.Match;
import org.eclipse.epsilon.egl.patch.Patch;
import org.eclipse.epsilon.egl.patch.TextBlock;
import org.junit.Test;

public class PatchTests extends PatchTestsBase {
	
	@Test
	public void testTextBlockEquals() {
		assertEquals(new TextBlock("foo","bar"), new TextBlock("foo", "bar"));
	}
	
	@Test
	public void testKeepsAndRemoves() throws Exception {
		assertEquals(2, createPatch(">insert","=keep","<remove").keepsAndRemoves().getLines().size());
	}
	
	@Test
	public void testOneMatch() throws Exception {
		Patch patch = createPatch("=do",">inject",">inject again","=end do");
		TextBlock block = new TextBlock("irrelevant1","do","end do","irrelevant2");
		Match match = patch.match(block).get(0);
		assertEquals(1, patch.match(block).size());
		assertEquals(1, match.getStartLine());
		assertEquals(2, match.getEndLine());
	}
	
	@Test
	public void testNoMatch() throws Exception {
		Patch patch = createPatch("=if",">inject","=else","=end if");
		TextBlock block = new TextBlock("if","end if");
		assertEquals(0, patch.match(block).size());
	}
	
	@Test
	public void testMerge() throws Exception {
		Patch patch = createPatch("=if",">inject","=end if");
		TextBlock block = new TextBlock("if","end if");
		assertEquals(new TextBlock("if", "inject", "end if"), patch.apply(block));
	}
	
	@Test
	public void testMergeTwoInjects() throws Exception {
		Patch patch = createPatch("=if",">inject", "=else", ">inject", "=end if");
		TextBlock block = new TextBlock("if", "else", "end if");
		assertEquals(new TextBlock("if", "inject", "else", "inject", "end if"), patch.apply(block));
	}
	
	@Test
	public void testMergeInjectRemove() throws Exception {
		Patch patch = createPatch("=if",">inject", "<else", ">inject", "=end if");
		TextBlock block = new TextBlock("if", "else", "end if");
		assertEquals(new TextBlock("if", "inject", "inject", "end if"), patch.apply(block));
	}
	
	@Test
	public void testMergeAnchorAtTheEnd() throws Exception {
		Patch patch = createPatch(">1", "=2");
		TextBlock block = new TextBlock("2");
		assertEquals(new TextBlock("1", "2"), patch.apply(block));
	}
	
	@Test
	public void testMergeAnchorAtTheBeginning() throws Exception {
		Patch patch = createPatch("=1", ">2");
		TextBlock block = new TextBlock("1");
		assertTrue(patch.appliesTo(block));
		assertEquals(new TextBlock("1", "2"), patch.apply(block));
	}
	
	@Test
	public void testMergeAnchorAtTheBeginningWithExtraLines() throws Exception {
		Patch patch = createPatch("=1", ">2");
		TextBlock block = new TextBlock("1", "3");
		assertTrue(patch.appliesTo(block));
		assertEquals(new TextBlock("1", "2", "3"), patch.apply(block));
	}
	
	@Test
	public void testMergeAnchorInTheMiddle() throws Exception {
		Patch patch = createPatch("=1", ">2");
		TextBlock block = new TextBlock("0", "1", "3");
		assertTrue(patch.appliesTo(block));
		assertEquals(new TextBlock("0", "1", "2", "3"), patch.apply(block));
	}
	
	@Test
	public void testMergeAnchorInTheMiddleWithRemove() throws Exception {
		Patch patch = createPatch("=1", "<2");
		TextBlock block = new TextBlock("0", "1", "2", "3");
		assertTrue(patch.appliesTo(block));
		assertEquals(new TextBlock("0", "1", "3"), patch.apply(block));
	}
	
	@Test
	public void testTwoMatches() throws Exception {
		Patch patch = createPatch("=1", ">2");
		TextBlock block = new TextBlock("1", "1");
		assertEquals(new TextBlock("1", "2", "1", "2"), patch.apply(block));
	}
	
	@Test
	public void testTwoMatchesWithRemove() throws Exception {
		Patch patch = createPatch("<1", ">2");
		TextBlock block = new TextBlock("1", "1");
		assertEquals(new TextBlock("2", "2"), patch.apply(block));
	}
	
	@Test
	public void testTwoMatchesWithKeepAndRemove() throws Exception {
		Patch patch = createPatch("=1", ">2", "<3");
		TextBlock block = new TextBlock("1", "3", "1", "3");
		assertEquals(new TextBlock("1", "2", "1", "2"), patch.apply(block));
	}
	
	@Test
	public void testIncompleteMatch() throws Exception {
		Patch patch = createPatch("=1", ">2", "<3");
		TextBlock block = new TextBlock("1");
		assertFalse(patch.appliesTo(block));
	}
	
	@Test
	public void testPreserveWhitespace() throws Exception {
		Patch patch = createPatch("=1", ">2");
		TextBlock block = new TextBlock("   1");
		assertEquals(new TextBlock("   1", "2"), patch.apply(block));
	}
	
	@Test
	public void testEmptyPatch() throws Exception {
		Patch patch = createPatch();
		TextBlock block = new TextBlock("1");
		assertFalse(patch.appliesTo(block));
	}
	
	@Test
	public void testEmptyBlock() throws Exception {
		Patch patch = createPatch("=1");
		TextBlock block = new TextBlock();
		assertFalse(patch.appliesTo(block));
	}
	
	@Test
	public void testEmptyPatchAndBlock() throws Exception {
		Patch patch = createPatch();
		TextBlock block = new TextBlock();
		assertFalse(patch.appliesTo(block));
	}
	
}
