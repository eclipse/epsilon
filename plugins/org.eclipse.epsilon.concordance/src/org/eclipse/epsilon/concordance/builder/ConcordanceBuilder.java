package org.eclipse.epsilon.concordance.builder;

import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.epsilon.concordance.analysis.ResourceAnalyzer;
import org.eclipse.epsilon.concordance.index.CrossReferenceIndexManager;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class ConcordanceBuilder extends IncrementalProjectBuilder {
	
	
	protected CrossReferenceIndexManager manager = CrossReferenceIndexManager.INSTANCE;
	
	
	class SampleDeltaVisitor implements IResourceDeltaVisitor {
		
		protected ResourceAnalyzer resourceAnalyzer = new ResourceAnalyzer();
		
		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.core.resources.IResourceDeltaVisitor#visit(org.eclipse.core.resources.IResourceDelta)
		 */
		public boolean visit(IResourceDelta delta) throws CoreException {
			IResource resource = delta.getResource();
			
			
			if (!manager.isModel(resource)) return true;
			
			IFile file = (IFile) resource;
			
			try {
				
				if (delta.getKind() == IResourceDelta.ADDED
						&& delta.getMovedFromPath() == null) {
					//System.err.println("Added");
					//System.err.println(delta.getMovedToPath());
					
					System.err.println("Adding...");
					
					manager.addModelToIndex(file);
				}
				
				else if (delta.getKind() == IResourceDelta.CHANGED) {
					//System.err.println("Changed");
					manager.updateModelInIndex(file);
				}			
				
				else if (delta.getKind() == IResourceDelta.REMOVED
						&& delta.getMovedToPath() == null) {
					//System.err.println("Deleted");
					manager.removeModelFromIndex(file);
				}
				
				else if (delta.getKind() == IResourceDelta.ADDED
						&& delta.getMovedFromPath() != null) {
					
					manager.moveModel(delta.getMovedFromPath(), file.getFullPath());
					
					//System.err.println("Moved");
				}
				
				else {
					System.err.println(delta.getKind());
				}
				
				//System.err.println(delta.getMovedFromPath());
				//System.err.println(delta.getMovedToPath());
				
			}
			catch (Exception ex) {
				// Ignore exception and continue
			}
			
			//return true to continue visiting children.
			return true;
		}
		
	}

	class FullBuildResourceVisitor implements IResourceVisitor {
		public boolean visit(IResource resource) {
			
			if (!manager.isModel(resource)) return true;
			
			IFile file = (IFile) resource;
			
			manager.removeModelFromIndex(file);
			manager.addModelToIndex(file);
			
			return true;
		}
	}

	public static final String BUILDER_ID = "org.eclipse.epsilon.concordance.builder";
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.internal.events.InternalBuilder#build(int,
	 *      java.util.Map, org.eclipse.core.runtime.IProgressMonitor)
	 */
	protected IProject[] build(int kind, Map args, IProgressMonitor monitor)
			throws CoreException {
		
		if (kind == FULL_BUILD) {
			fullBuild(monitor);
		} else {
			IResourceDelta delta = getDelta(getProject());
			if (delta == null) {
				fullBuild(monitor);
			} else {
				LastDelta.INSTANCE.setDelta(delta);
				incrementalBuild(delta, monitor);
			}
		}
		return null;
	}
	
	protected void fullBuild(final IProgressMonitor monitor)
			throws CoreException {
		
		//System.err.println("Full build " + System.currentTimeMillis());
		
		try {
			getProject().accept(new FullBuildResourceVisitor());
		} catch (CoreException e) {
		}
	}

	protected void incrementalBuild(IResourceDelta delta,
			IProgressMonitor monitor) throws CoreException {
		// the visitor does the work.
		delta.accept(new SampleDeltaVisitor());
	}
}
