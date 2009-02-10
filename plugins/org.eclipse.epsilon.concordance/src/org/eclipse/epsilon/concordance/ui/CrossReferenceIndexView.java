package org.eclipse.epsilon.concordance.ui;

import org.eclipse.epsilon.concordance.Activator;
import org.eclipse.epsilon.concordance.index.CrossReference;
import org.eclipse.epsilon.concordance.index.CrossReferenceIndexManager;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.part.ViewPart;

public class CrossReferenceIndexView extends ViewPart {

	private TableViewer indexViewer;
	
	class ViewContentProvider implements IStructuredContentProvider {
		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
		}
		public void dispose() {
		}
		public Object[] getElements(Object parent) {
			return CrossReferenceIndexManager.INSTANCE.getCrossReferenceIndex().getAll().toArray();
		}
	}
	
	class IndexViewerLabelProvider extends LabelProvider implements ITableLabelProvider {

		public String getColumnText(Object obj, int index) {
			
			CrossReference target = ((CrossReference) obj);
			
			if (index == 0) return target.getSourceResource();
			if (index == 1) return target.getSourceElementId();
			if (index == 2) return target.getSourceLabel();
			if (index == 3) return target.getTargetResource();
			if (index == 4) return target.getTargetElementId();
			if (index == 5) return target.getTargetLabel();
			if (index == 6) return target.getFeature();
			if (index == 7) return target.getTag();
			if (index == 8) return target.isDangling() + "";
			return "";
		}
		public Image getColumnImage(Object obj, int index) {
			return null;
		}
	}

	/**
	 * The constructor.
	 */
	public CrossReferenceIndexView() {
		
	}

	/**
	 * This is a callback that will allow us
	 * to create the viewer and initialize it.
	 */
	@Override
	public void createPartControl(Composite parent) {
		createIndexTable(parent);
		contributeToActionBars();
	}
		
	protected void createIndexTable(Composite parent) {
		
		indexViewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION);
		indexViewer.setContentProvider(new ViewContentProvider());
		indexViewer.setLabelProvider(new IndexViewerLabelProvider());
		indexViewer.setInput(getViewSite());
		
		TableColumn column = null;
		
		column = new TableColumn(indexViewer.getTable(), SWT.FULL_SELECTION);
	    column.setText("Source resource");
	    column.setWidth(100);			
		column = new TableColumn(indexViewer.getTable(), SWT.FULL_SELECTION);
	    column.setText("Source element");
	    column.setWidth(100);			
		column = new TableColumn(indexViewer.getTable(), SWT.FULL_SELECTION);
	    column.setText("Source label");
	    column.setWidth(100);			
		column = new TableColumn(indexViewer.getTable(), SWT.FULL_SELECTION);
	    column.setText("Target resource");
	    column.setWidth(100);			
		column = new TableColumn(indexViewer.getTable(), SWT.FULL_SELECTION);
	    column.setText("Target element");
	    column.setWidth(100);			
		column = new TableColumn(indexViewer.getTable(), SWT.FULL_SELECTION);
	    column.setText("Target label");
	    column.setWidth(100);			
	    column = new TableColumn(indexViewer.getTable(), SWT.FULL_SELECTION);
	    column.setText("Feature");
	    column.setWidth(100);			
	    column = new TableColumn(indexViewer.getTable(), SWT.FULL_SELECTION);
	    column.setText("Tag");
	    column.setWidth(100);			
		column = new TableColumn(indexViewer.getTable(), SWT.FULL_SELECTION);
	    column.setText("Dangling");
	    column.setWidth(100);			
	    
	    indexViewer.getTable().setHeaderVisible(true);
	    indexViewer.getTable().setLinesVisible(true);
	   
	}
	
	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalToolBar(bars.getToolBarManager());
	}
	
	private void fillLocalToolBar(IToolBarManager manager) {
		
		/*
		manager.add(new Action("Resume") {
			@Override
			public void run() {
				Debugger.INSTANCE.resume();
			}
		});
		*/
		
		manager.add(new Action("Refresh", Activator.getImageDescriptor("images/refresh.gif")) {
			@Override
			public void run() {
				refresh();
			}
		});
		
		manager.add(new Action("Clear index", Activator.getImageDescriptor("images/clear.gif")) {
			@Override
			public void run() {
				CrossReferenceIndexManager.INSTANCE.getCrossReferenceIndex().clean();
				refresh();
			}
		});
	}


	/**
	 * Passing the focus request to the viewer's control.
	 */
	@Override
	public void setFocus() {
		indexViewer.getControl().setFocus();
	}

	public void refresh() {
		
		Display.getDefault().asyncExec(new Runnable() {

			public void run() {
				indexViewer.refresh();
			}
			
		});
	}

	public TableViewer getViewer() {
		return indexViewer;
	}


}
 