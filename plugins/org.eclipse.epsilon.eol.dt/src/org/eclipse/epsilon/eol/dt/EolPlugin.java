/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol.dt;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.epsilon.common.dt.EpsilonPlugin;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The main plugin class to be used in the desktop.
 */
public class EolPlugin extends AbstractUIPlugin implements EpsilonPlugin{
	
	public static String EOLPROGRAM = "SOURCE.EOL";
	
	//The shared instance.
	private static EolPlugin plugin;
	
	// private EolResourceChangeListener rcl = null;
	
	/**
	 * The constructor.
	 */
	public EolPlugin() {
		plugin = this;
	}

	/**
	 * This method is called upon plug-in activation
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		//rcl = new EolResourceChangeListener();
		//ResourcesPlugin.getWorkspace().addResourceChangeListener(rcl);
	}

	/**
	 * This method is called when the plug-in is stopped
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		super.stop(context);
		plugin = null;
		//ResourcesPlugin.getWorkspace().removeResourceChangeListener(rcl);
	}

	/**
	 * Returns the shared instance.
	 */
	public static EolPlugin getDefault() {
		return plugin;
	}

	/**
	 * Returns an image descriptor for the image file at the given
	 * plug-in relative path.
	 *
	 * @param path the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.epsilon.eol.dt", path);
	}
	
	/**
	 * This method returns an image from the path
	 * @param path
	 * @return
	 */
	public Image createImage(String path) {
		try {
			URL BASE_URL = EolPlugin.getDefault().getBundle().getEntry("/");
			URL url = new URL(BASE_URL, path);
			return ImageDescriptor.createFromURL(url).createImage();
		}
		catch(MalformedURLException e) {}
		return null;
	}
	
	
	class EolResourceDeltaVisitor implements IResourceDeltaVisitor {
		
		public IResource resource;
		
		public boolean visit(IResourceDelta delta) throws CoreException {
			System.out.println("Visiting: " + delta.getResource());
			if (delta.getResource().getFileExtension().equals("eol")){
				System.out.println("Changed....");
				resource = delta.getResource();
			}
			
			for (int i=0; i< delta.getAffectedChildren().length; i++){
				delta.getAffectedChildren()[i].accept(this);
			}
			
			return false;
		}
		
	}
	
	class DeltaVisitor {
		
		public IResource resource;
		
		public void visitDelta(IResourceDelta delta){
			if (delta.getResource().getFileExtension() != null 
					&& delta.getResource().getFileExtension().equals("eol")){
				resource = delta.getResource();
			}
			else {
				for (int i=0; i<delta.getAffectedChildren().length; i++){
					visitDelta(delta.getAffectedChildren()[i]);
				}
			}
		}
		
	}
	/*
	class EolResourceChangeListener implements IResourceChangeListener {
		
		public void resourceChanged(IResourceChangeEvent event) {
			
			System.out.println("Changed");
			IResource resource = null;

			DeltaVisitor visitor = new DeltaVisitor();
			visitor.visitDelta(event.getDelta());
			resource = visitor.resource;
			
			event = null;
			
			if (resource!=null){
				try {
					resource.deleteMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
				} catch (CoreException e) {
					//e.printStackTrace();
				}
				
				EolLexer lexer = null;
				try {
					lexer = new EolLexer(new FileReader(resource.getLocation().toString()));
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				EolParser parser = new EolParser(lexer);
				parser.setASTFactory(new EolAstFactory());
				
				
				try {
					parser.eolModule();
				} catch (Exception e) {
					reportError(resource, 0,0, e.getLocalizedMessage());
				}
				
				ListIterator li = parser.getParseProblems().listIterator();
				
				while (li.hasNext()){
					ParseProblem pan = (ParseProblem) li.next();
					reportError(resource, pan.getLine(), pan.getColumn(), pan.getReason());
				}
				
			}
		}
		
		private void reportError(IResource res, int line, int column, String msg){
			try {
				IMarker marker = res.createMarker(IMarker.PROBLEM);
				marker.setAttribute(IMarker.LINE_NUMBER, line);
				marker.setAttribute(IMarker.CHAR_START, column);
				marker.setAttribute(IMarker.MESSAGE, msg);
				marker.setAttribute(IMarker.PRIORITY, IMarker.PRIORITY_HIGH);
				marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
			}
			catch (CoreException cex){
				cex.printStackTrace();
			}
		}
		
	}
	*/
}
