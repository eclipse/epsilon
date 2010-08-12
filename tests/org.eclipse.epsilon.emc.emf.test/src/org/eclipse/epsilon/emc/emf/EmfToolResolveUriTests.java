package org.eclipse.epsilon.emc.emf;

import static org.junit.Assert.*;

import org.eclipse.epsilon.emc.emf.tools.EmfTool;
import org.junit.Test;

public class EmfToolResolveUriTests {

	@Test
	public void shouldResolveRelativeToDirectory() throws Exception {
		final String actual = new EmfTool().resolveURI("nearby.model", "/a/path/");
		
		assertEquals("/a/path/nearby.model", actual);
	}
	
	@Test
	public void shouldResolveRelativeToFile() throws Exception {
		final String actual = new EmfTool().resolveURI("nearby.model", "/a/path/source.file");
		
		assertEquals("/a/path/nearby.model", actual);
	}
	
	@Test
	public void shouldNotResolveTargetThatIsAbsolute() throws Exception {
		final String actual = new EmfTool().resolveURI("/a/path/nearby.model", "/another/path/source.file");
		
		assertEquals("/a/path/nearby.model", actual);
	}
	
	@Test
	public void shouldNotResolveTargetThatHasASchema() throws Exception {
		final String actual = new EmfTool().resolveURI("file:/a/path/nearby.model#//@contents.0", "/another/path/source.file");
		
		assertEquals("file:/a/path/nearby.model#//@contents.0", actual);
	}
	
	@Test
	public void shouldNotChangeUriFragment() throws Exception {
		final String actual = new EmfTool().resolveURI("nearby.model#//@contents.0", "/a/path/source.file");
		
		assertEquals("/a/path/nearby.model#//@contents.0", actual);
	}
}
