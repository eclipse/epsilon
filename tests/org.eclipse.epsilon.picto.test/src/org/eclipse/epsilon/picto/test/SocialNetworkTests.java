package org.eclipse.epsilon.picto.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.eclipse.epsilon.picto.PictoView;
import org.eclipse.epsilon.picto.ViewContent;
import org.eclipse.epsilon.picto.ViewTree;
import org.junit.Test;

public class SocialNetworkTests extends PictoTests {
	
	@Test
	public void testSocialNetwork() throws Exception {
		
		PictoView pictoView = createPictoView();
		
		ViewTree viewTree = getViewTree("ecore/socialnetwork.picto");
		
		ViewTree modelViewTree = viewTree.getChildren().get(0);
		assertEquals("Model", modelViewTree.getName());
		
		ViewTree socialNetworkViewTree = modelViewTree.getChildren().get(0);
		assertEquals("SocialNetwork", socialNetworkViewTree.getName());
		
		ViewContent dotContent = socialNetworkViewTree.getContent();
		assertEquals("graphviz-dot", dotContent.getFormat());
		assertTrue(dotContent.getText().contains("digraph"));
		
		ViewContent svgContent = dotContent.getNext(pictoView);
		assertEquals("svg", svgContent.getFormat());
		assertTrue(svgContent.getText().contains("svg"));
		
		ViewContent htmlContent = svgContent.getNext(pictoView);
		assertEquals("html", htmlContent.getFormat());
		assertTrue(htmlContent.getText().contains("html"));
		
		ViewContent htmlWithZoomContent = htmlContent.getNext(pictoView);
		assertEquals("html", htmlWithZoomContent.getFormat());
		assertTrue(htmlWithZoomContent.getText().contains("picto-zoom"));
		
		assertNull(htmlWithZoomContent.getNext(pictoView));
		
		
	}
	
}
