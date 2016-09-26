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
package org.eclipse.epsilon.profiling.dt;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.epsilon.common.dt.util.EclipseUtil;
import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.profiling.FileMarker;
import org.eclipse.epsilon.profiling.IProfilerListener;
import org.eclipse.epsilon.profiling.Profiler;
import org.eclipse.epsilon.profiling.ProfilerTarget;
import org.eclipse.epsilon.profiling.ProfilerTargetSummary;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

public class ProfilerView extends ViewPart implements IProfilerListener{

	protected final int ORDER_COLUMN = 0;
	protected final int TARGET_COLUMN = 1;
	protected final int CPU_COLUMN = 3;
	protected final int TIMES_COLUMN = 2;
	protected final int AVG_COLUMN = 4;
	
	private TableViewer targetsViewer;
	private TreeViewer detailsViewer;
	protected OverviewViewer overviewViewer;
	private CTabFolder folder;
	protected boolean autoRefresh = false;
	protected Image running = Activator.getImageDescriptor("icons/running.gif").createImage();
	protected Image completed = Activator.getImageDescriptor("icons/completed.gif").createImage();
	protected boolean sortChildrenTargetsByTime = false;
	protected boolean showAggregatedWork = true;
	protected List<ProfilerTargetSummary> targetSummaries = new ArrayList<ProfilerTargetSummary>();
	protected List<ProfilerTarget> rootTargets = new ArrayList<ProfilerTarget>();
	
	class ViewContentProvider implements IStructuredContentProvider {
		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
		}
		public void dispose() {
		}
		public Object[] getElements(Object parent) {
			return targetSummaries.toArray();
		}
	}
	
	class DetailsViewerContentProvider implements ITreeContentProvider {

		public Object[] getElements(Object inputElement) {
			return rootTargets.toArray();
		}

		public void dispose() {
			
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			// TODO Auto-generated method stub
			
		}

		public Object[] getChildren(Object parentElement) {
			List<ProfilerTarget> children = ((ProfilerTarget) parentElement).getChildren();
			if (sortChildrenTargetsByTime) {
				List<ProfilerTarget> temp = children;
				children = new ArrayList<ProfilerTarget>();
				children.addAll(temp);
				Collections.sort(children, new Comparator<ProfilerTarget>() {

					public int compare(ProfilerTarget o1, ProfilerTarget o2) {
						if (o1.getWorked(showAggregatedWork) > o2.getWorked(showAggregatedWork)) {
							return -1;
						}
						else if (o2.getWorked(showAggregatedWork) > o1.getWorked(showAggregatedWork)) {
							return 1;
						}
						else {
							return 0;
						}
					}
					
				});
			}
			return children.toArray();
		}

		public Object getParent(Object element) {
			return ((ProfilerTarget) element).getParent();
		}

		public boolean hasChildren(Object element) {
			return ((ProfilerTarget) element).getChildren().size() > 0;
		}
		
	}
	
	class DetailsViewerLabelProvider extends LabelProvider implements ITableLabelProvider{

		public Image getColumnImage(Object element, int columnIndex) {
			if (columnIndex == 0) {
				return completed;
			}
			return null;
		}

		public String getColumnText(Object element, int columnIndex) {
			ProfilerTarget target = ((ProfilerTarget) element);
			if (columnIndex == 0) return target.getName();
			else if (columnIndex == 1) return target.getWorked(showAggregatedWork) + "";
			else if (columnIndex == 2) return target.getData(); 
			else {
				ModuleElement moduleElement = target.getModuleElement();
				if (moduleElement != null && moduleElement.getFile() != null) {
					String label = moduleElement.getFile().getName();
					if (moduleElement.getRegion() != null) {
						label = label + " (" + moduleElement.getRegion().getStart().getLine() + ", " + moduleElement.getRegion().getStart().getColumn() + ")";
					}
					return label;
				}
				return "";
			}
		}
		
	}
	
	class TargetsViewerLabelProvider extends LabelProvider implements ITableLabelProvider {

		public String getColumnText(Object obj, int index) {
			
			ProfilerTargetSummary summary = (ProfilerTargetSummary) obj;
			
			if (index == ORDER_COLUMN) {
				//return Profiler.INSTANCE.getTargetNames().indexOf(obj.toString()) + "";
				return summary.getIndex() + "";
			}
			else if (index == TARGET_COLUMN) {
				//return obj.toString();
				return summary.getName();
			}
			else if (index == CPU_COLUMN){
				//long cpuTime = Profiler.INSTANCE.getTotalTime(obj.toString(), showAggregatedWork);
				//return cpuTime + "";
				return showAggregatedWork ? summary.getExecutionTime().getAggregate() + "" : summary.getExecutionTime().getIndividual() + "";
			}
			else if (index == TIMES_COLUMN){
				//long numberOfTimes = Profiler.INSTANCE.getExecutionCount(obj.toString());
				//return "" + numberOfTimes;
				return summary.getExecutionCount() + "";
			}
			else if (index == AVG_COLUMN) {
				long executionTime = showAggregatedWork ? summary.getExecutionTime().getAggregate() : summary.getExecutionTime().getIndividual();
				//long numberOfTimes = Profiler.INSTANCE.getExecutionCount(obj.toString());
				//long cpuTime = Profiler.INSTANCE.getTotalTime(obj.toString(), showAggregatedWork);
				return "" + ((double)executionTime) / summary.getExecutionCount() ;
			}
			else {
				return ""; //CollectionUtil.toString(Profiler.INSTANCE.getTargetHistory(obj.toString()));
			}
		}
		public Image getColumnImage(Object obj, int index) {
			Image image = null;
			if (index == ORDER_COLUMN) {
				if (Profiler.INSTANCE.isRunning(obj.toString())) {
					image = running;
				}
				else {
					image = completed;
				}
			}
			return image;
		}
		
		@Override
		public Image getImage(Object obj) {
			return PlatformUI.getWorkbench().
					getSharedImages().getImage(ISharedImages.IMG_OBJ_ELEMENT);
		}
	}

	/**
	 * The constructor.
	 */
	public ProfilerView() {
		Profiler.INSTANCE.addListener(this);
	}

	/**
	 * This is a callback that will allow us
	 * to create the viewer and initialize it.
	 */
	@Override
	public void createPartControl(Composite parent) {
		
		folder = new CTabFolder(parent, SWT.NONE);
		folder.setSimple(true);
		folder.setTabPosition(SWT.BOTTOM);
		
		CTabItem overviewItem = new CTabItem(folder,SWT.NONE);
		overviewItem.setText("Summary");
		overviewViewer = new OverviewViewer(folder, SWT.NONE);
		overviewItem.setControl(overviewViewer);
		
		CTabItem targetsViewerItem = new CTabItem(folder,SWT.NONE);
		targetsViewerItem.setText("Targets");
		
		CTabItem detailsViewerItem = new CTabItem(folder,SWT.NONE);
		detailsViewerItem.setText("Details");
		
		createTargetsTable();
		createDetailsTree();
		
		targetsViewerItem.setControl(targetsViewer.getControl());
		//detailsViewerItem.setControl(new PlotComposite(folder,SWT.NONE));
		detailsViewerItem.setControl(detailsViewer.getControl());
		folder.setSelection(overviewItem);
		
		//hookContextMenu();
		contributeToActionBars();
	}
	
	protected void createDetailsTree() {
		detailsViewer = new TreeViewer(folder, SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION);
		detailsViewer.setContentProvider(new DetailsViewerContentProvider());
		detailsViewer.setLabelProvider(new DetailsViewerLabelProvider());
		detailsViewer.setInput(Profiler.INSTANCE.getRoot());
		
		TreeColumn c = new TreeColumn(detailsViewer.getTree(), SWT.FULL_SELECTION);
		c.setText("Target");
		c.setWidth(150);
		
		c = new TreeColumn(detailsViewer.getTree(), SWT.FULL_SELECTION);
		c.setText("Execution Time");
		c.setWidth(150);
		
		c = new TreeColumn(detailsViewer.getTree(), SWT.FULL_SELECTION);
		c.setText("Data");
		c.setWidth(150);
		
		c = new TreeColumn(detailsViewer.getTree(), SWT.FULL_SELECTION);
		c.setText("Location");
		c.setWidth(150);
		
		
		detailsViewer.getTree().addMouseListener(new MouseListener() {

			public void mouseDoubleClick(MouseEvent e) {
				ProfilerTarget target = (ProfilerTarget) ((IStructuredSelection) detailsViewer.getSelection()).getFirstElement();
				if (target != null) {
					ModuleElement moduleElement = target.getModuleElement();
					if (moduleElement != null) {
						EclipseUtil.openEditorAt(moduleElement);
					}
				}
			}

			public void mouseDown(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mouseUp(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		detailsViewer.getTree().setHeaderVisible(true);
		detailsViewer.getTree().setLinesVisible(true);
		
	}
	
	protected void createTargetsTable() {
		
		targetsViewer = new TableViewer(folder, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION);
		targetsViewer.setContentProvider(new ViewContentProvider());
		targetsViewer.setLabelProvider(new TargetsViewerLabelProvider());
		//targetsViewer.setSorter(new ProfilerTargetSorter());
		targetsViewer.setInput(getViewSite());
		
		TableColumn column = new LongTableColumn(targetsViewer, SWT.FULL_SELECTION);
	    column.setText("");
	    column.setWidth(20);
	    
	    column = new StringTableColumn(targetsViewer, SWT.FULL_SELECTION);
	    column.setText("Target");
	    column.setWidth(80);
	    
	    column = new LongTableColumn(targetsViewer, SWT.FULL_SELECTION);
	    column.setText("# Times Executed");
	    column.setWidth(115);
	    
	    column = new LongTableColumn(targetsViewer, SWT.FULL_SELECTION);
	    column.setText("Total Execution Time");
	    column.setWidth(125);
	    
	    column = new DoubleTableColumn(targetsViewer, SWT.FULL_SELECTION);
	    column.setText("Average Execution Time");
	    column.setWidth(135);
	    
	    targetsViewer.getTable().setHeaderVisible(true);
	    targetsViewer.getTable().setLinesVisible(true);
	   
	}

	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalToolBar(bars.getToolBarManager());
	}
	
	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(new RefreshProfilerViewAction(this));
		manager.add(new ToggleSortChildrenTargetsAction(this));
		manager.add(new ToggleShowAggregatedWorkAction(this));
		manager.add(new ToggleAutoRefreshAction(this));
		manager.add(new ResetProfilerAction(this));
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	@Override
	public void setFocus() {
		targetsViewer.getControl().setFocus();
	}

	public void targetStarted(String task) {
		if (autoRefresh) refresh();
	}

	public void targetStopped(String task) {
		if (autoRefresh) refresh();
	}
	
	public void refresh() {
		
		targetSummaries = Profiler.INSTANCE.getTargetSummaries();
		rootTargets = Profiler.INSTANCE.getRoot().getChildren();
		
		Display.getDefault().asyncExec(new Runnable() {

			public void run() {
				
				long total = 0;
				for (ProfilerTargetSummary summary : targetSummaries) {
					total += summary.getExecutionTime().getAggregate();
				}
				
				overviewViewer.setProfilerOverview(Profiler.INSTANCE.getOverview());
				
				targetsViewer.refresh();
				detailsViewer.refresh();
			}
			
		});
	}

	public boolean isAutoRefresh() {
		return autoRefresh;
	}

	public void setAutoRefresh(boolean autoRefresh) {
		this.autoRefresh = autoRefresh;
	}
	
	public TableViewer getViewer() {
		return targetsViewer;
	}

	public boolean isSortChildrenTargetsByTime() {
		return sortChildrenTargetsByTime;
	}

	public void setSortChildrenTargetsByTime(boolean sortChildrenTargetsByTime) {
		this.sortChildrenTargetsByTime = sortChildrenTargetsByTime;
	}

	public boolean isShowAggregatedWork() {
		return showAggregatedWork;
	}

	public void setShowAggregatedWork(boolean showAggregatedWork) {
		this.showAggregatedWork = showAggregatedWork;
	}
}
