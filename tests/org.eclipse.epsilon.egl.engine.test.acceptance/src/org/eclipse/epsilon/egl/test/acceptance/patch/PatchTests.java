package org.eclipse.epsilon.egl.test.acceptance.patch;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.eclipse.epsilon.egl.patch.InvalidLineException;
import org.eclipse.epsilon.egl.patch.Match;
import org.eclipse.epsilon.egl.patch.Patch;
import org.eclipse.epsilon.egl.patch.TextBlock;
import org.junit.Test;

public class PatchTests {
	
	@Test(expected=InvalidLineException.class)
	public void testInvalidPatchLine() throws Exception {
		new Patch("foo");
	}
	
	@Test
	public void testTextBlockEquals() {
		assertEquals(new TextBlock("foo","bar"), new TextBlock("foo", "bar"));
	}
	
	@Test
	public void testKeepsAndRemoves() throws Exception {
		assertEquals(2, new Patch(">insert","=keep","<remove").keepsAndRemoves().getLines().size());
	}
	
	@Test
	public void testOneMatch() throws Exception {
		Patch patch = new Patch("=do",">inject",">inject again","=end do");
		TextBlock block = new TextBlock("irrelevant","do","end do","irrelevant");
		Match match = patch.match(block).get(0);
		assertEquals(1, patch.match(block).size());
		assertEquals(1, match.getStartLine());
		assertEquals(2, match.getEndLine());
	}
	
	@Test
	public void testNoMatch() throws Exception {
		Patch patch = new Patch("=if",">inject","=else","=end if");
		TextBlock block = new TextBlock("if","end if");
		assertEquals(0, patch.match(block).size());
	}
	
	@Test
	public void testMerge() throws Exception {
		Patch patch = new Patch("=if",">inject","=end if");
		TextBlock block = new TextBlock("if","end if");
		assertEquals(new TextBlock("if", "inject", "end if"), patch.apply(block));
	}
	
	@Test
	public void testMergeTwoInjects() throws Exception {
		Patch patch = new Patch("=if",">inject", "=else", ">inject", "=end if");
		TextBlock block = new TextBlock("if", "else", "end if");
		assertEquals(new TextBlock("if", "inject", "else", "inject", "end if"), patch.apply(block));
	}
	
	@Test
	public void testMergeInjectRemove() throws Exception {
		Patch patch = new Patch("=if",">inject", "<else", ">inject", "=end if");
		TextBlock block = new TextBlock("if", "else", "end if");
		assertEquals(new TextBlock("if", "inject", "inject", "end if"), patch.apply(block));
	}
	
	@Test
	public void testMergeAnchorAtTheEnd() throws Exception {
		Patch patch = new Patch(">1", "=2");
		TextBlock block = new TextBlock("2");
		assertEquals(new TextBlock("1", "2"), patch.apply(block));
	}
	
	@Test
	public void testMergeAnchorAtTheBeginning() throws Exception {
		Patch patch = new Patch("=1", ">2");
		TextBlock block = new TextBlock("1");
		assertTrue(patch.appliesTo(block));
		assertEquals(new TextBlock("1", "2"), patch.apply(block));
	}
	
	@Test
	public void testMergeAnchorAtTheBeginningWithExtraLines() throws Exception {
		Patch patch = new Patch("=1", ">2");
		TextBlock block = new TextBlock("1", "3");
		assertTrue(patch.appliesTo(block));
		assertEquals(new TextBlock("1", "2", "3"), patch.apply(block));
	}
	
	@Test
	public void testMergeAnchorInTheMiddle() throws Exception {
		Patch patch = new Patch("=1", ">2");
		TextBlock block = new TextBlock("0", "1", "3");
		assertTrue(patch.appliesTo(block));
		assertEquals(new TextBlock("0", "1", "2", "3"), patch.apply(block));
	}
	
	@Test
	public void testMergeAnchorInTheMiddleWithRemove() throws Exception {
		Patch patch = new Patch("=1", "<2");
		TextBlock block = new TextBlock("0", "1", "2", "3");
		assertTrue(patch.appliesTo(block));
		assertEquals(new TextBlock("0", "1", "3"), patch.apply(block));
	}
	
	@Test
	public void testIncompleteMatch() throws Exception {
		Patch patch = new Patch("=1", ">2", "<3");
		TextBlock block = new TextBlock("1");
		assertFalse(patch.appliesTo(block));
	}
	
	@Test
	public void testPreserveWhitespace() throws Exception {
		Patch patch = new Patch("=1", ">2");
		TextBlock block = new TextBlock("   1");
		assertEquals(new TextBlock("   1", "2"), patch.apply(block));
	}
	
	@Test
	public void testEmptyPatch() throws Exception {
		Patch patch = new Patch();
		TextBlock block = new TextBlock("1");
		assertFalse(patch.appliesTo(block));
	}
	
	@Test
	public void testEmptyBlock() throws Exception {
		Patch patch = new Patch("=1");
		TextBlock block = new TextBlock();
		assertFalse(patch.appliesTo(block));
	}
	
	@Test
	public void testEmptyPatchAndBlock() throws Exception {
		Patch patch = new Patch();
		TextBlock block = new TextBlock();
		assertFalse(patch.appliesTo(block));
	}
}
