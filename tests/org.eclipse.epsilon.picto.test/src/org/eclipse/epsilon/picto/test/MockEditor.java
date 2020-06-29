package org.eclipse.epsilon.picto.test;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.PartInitException;

public class MockEditor implements IEditorPart {

	@Override
	public void addPropertyListener(IPropertyListener listener) {

	}

	@Override
	public void dispose() {

	}

	@Override
	public IWorkbenchPartSite getSite() {

		return null;
	}

	@Override
	public String getTitle() {

		return null;
	}

	@Override
	public String getTitleToolTip() {

		return null;
	}

	@Override
	public void removePropertyListener(IPropertyListener listener) {

	}

	@Override
	public void setFocus() {

	}

	@Override
	public <T> T getAdapter(Class<T> adapter) {

		return null;
	}

	@Override
	public void doSave(IProgressMonitor monitor) {

	}

	@Override
	public void doSaveAs() {

	}

	@Override
	public boolean isDirty() {

		return false;
	}

	@Override
	public boolean isSaveAsAllowed() {

		return false;
	}

	@Override
	public boolean isSaveOnCloseNeeded() {

		return false;
	}

	@Override
	public IEditorInput getEditorInput() {

		return null;
	}

	@Override
	public IEditorSite getEditorSite() {

		return null;
	}

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {

	}

	@Override
	public void createPartControl(Composite parent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Image getTitleImage() {
		// TODO Auto-generated method stub
		return null;
	}

}
