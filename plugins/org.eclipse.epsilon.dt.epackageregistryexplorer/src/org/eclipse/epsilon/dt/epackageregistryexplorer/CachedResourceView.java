package org.eclipse.epsilon.dt.epackageregistryexplorer;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.epsilon.emc.emf.CachedResourceSet;
import org.eclipse.epsilon.emc.emf.CachedResourceSet.Cache;
import org.eclipse.epsilon.emc.emf.CachedResourceSet.Cache.CacheItem;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.part.ViewPart;

public class CachedResourceView extends ViewPart {
	
	protected TreeViewer cacheViewer = null;
	
	@Override
	public void createPartControl(Composite parent) {
		cacheViewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		cacheViewer.setContentProvider(new CachedResourceViewerContentProvider());
		cacheViewer.setLabelProvider(new CachedResoureViewerLabelProvider());
		cacheViewer.setSorter(new AlphabeticalSorter());
		cacheViewer.setInput(CachedResourceSet.getCache());
		
		IActionBars bars = getViewSite().getActionBars();
		bars.getToolBarManager().add(new RefreshAction());
		bars.getToolBarManager().add(new ClearAction());
	}

	@Override
	public void setFocus() {
		
	}
	
	class RefreshAction extends Action {
		
		protected boolean running = false;
		
		public RefreshAction() {
			this.setText("Refresh");
			this.setImageDescriptor(Activator.getDefault().getImageDescriptor("icons/refresh.gif"));
		}
		
		@Override
		public void run() {
			cacheViewer.refresh();
		}		
	}
	
	class ClearAction extends Action {
		
		protected boolean running = false;
		
		public ClearAction() {
			this.setText("Clear cache");
			this.setImageDescriptor(Activator.getDefault().getImageDescriptor("icons/clear.gif"));
		}
		
		@Override
		public void run() {
			CachedResourceSet.getCache().clear();
			cacheViewer.refresh();
		}		
	}
	
	public class CachedResoureViewerLabelProvider extends LabelProvider {
		
		protected Image image = Activator.getDefault().getImageDescriptor("icons/emfmodel.gif").createImage();
		
		@Override
		public Image getImage(Object element) {
			return image;
		}
		
		@Override
		public String getText(Object element) {
			return ((CacheItem) element).getUri().toString();
		}
		
	}
	
	public class CachedResourceViewerContentProvider implements ITreeContentProvider {

		@Override
		public void dispose() {
			
		}

		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			
		}

		@Override
		public Object[] getElements(Object inputElement) {
			return CachedResourceSet.getCache().getItems().toArray(new Cache.CacheItem[]{});
		}

		@Override
		public Object[] getChildren(Object parentElement) {
			return null;
		}

		@Override
		public Object getParent(Object element) {
			return null;
		}

		@Override
		public boolean hasChildren(Object element) {
			return false;
		}
		
	}
	
}
