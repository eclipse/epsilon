package org.eclipse.epsilon.picto.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.eclipse.epsilon.picto.Layer;
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
		
		ViewTree classesViewTree = modelViewTree.getChildren().get(1);
		assertEquals("Classes", classesViewTree.getName());
		
		ViewTree socialNetworkViewTree = classesViewTree.getChildren().get(1);
		assertEquals("SocialNetwork", socialNetworkViewTree.getName());
		
		ViewContent dotContent = socialNetworkViewTree.getContent();
		assertEquals("graphviz-dot", dotContent.getFormat());
		assertTrue(dotContent.getText().contains("digraph"));
		// By default the referenceLabels layer is turned on
		assertTrue(dotContent.getText().contains("people[*]"));
		
		// Turn the referenceLabels layer off
		Layer referenceLabelsLayer = socialNetworkViewTree.getContent().getLayers().stream().filter(l -> l.getId().equals("referenceLabels")).findFirst().orElse(null);
		referenceLabelsLayer.setActive(false);
		socialNetworkViewTree.clearCache();
		// Check that there's no people[*] label anywhere in the generated dot
		assertFalse(socialNetworkViewTree.getContent().getText().contains("people[*]"));
		
		ViewContent svgContent = dotContent.getNext(pictoView);
		assertEquals("svg", svgContent.getFormat());
		assertTrue(svgContent.getText().contains("svg"));
		
		ViewContent htmlContent = svgContent.getNext(pictoView);
		assertEquals("html", htmlContent.getFormat());
		assertTrue(htmlContent.getText().contains("html"));
		
		ViewContent htmlWithZoomContent = htmlContent.getNext(pictoView);
		assertEquals("html", htmlWithZoomContent.getFormat());
		assertTrue(htmlWithZoomContent.getText().contains("picto-zoom"));
		assertTrue(htmlWithZoomContent.getText().contains("people[*]"));
		
		assertNull(htmlWithZoomContent.getNext(pictoView));
		
	}
	
}
