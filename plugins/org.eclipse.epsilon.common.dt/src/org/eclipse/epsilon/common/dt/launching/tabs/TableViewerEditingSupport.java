package org.eclipse.epsilon.common.dt.launching.tabs;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;

public abstract class TableViewerEditingSupport extends EditingSupport {

	protected CellEditor cellEditor;
	
	public TableViewerEditingSupport(TableViewer viewer) {
		super(viewer);
	}

	protected abstract CellEditor createCellEditor(TableViewer viewer);
	
	@Override
	protected CellEditor getCellEditor(Object element) {
		if (cellEditor == null) {
			cellEditor = createCellEditor((TableViewer) getViewer());
		}
		return cellEditor;
	}

	@Override
	protected boolean canEdit(Object element) {
		return true;
	}

	@Override
	protected abstract Object getValue(Object element);

	protected abstract void setValueImpl(Object element, Object value);
	
	@Override
	protected void setValue(Object element, Object value) {
		setValueImpl(element, value);
		((TableViewer) getViewer()).refresh();
	}

}
