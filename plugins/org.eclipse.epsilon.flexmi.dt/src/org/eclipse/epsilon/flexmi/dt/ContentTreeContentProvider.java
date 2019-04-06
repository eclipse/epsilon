package org.eclipse.epsilon.flexmi.dt;

import org.eclipse.jface.viewers.ITreeContentProvider;

public class ContentTreeContentProvider implements ITreeContentProvider {
	
	@Override
	public boolean hasChildren(Object element) {
		return !((ContentTree) element).getChildren().isEmpty();
	}
	
	@Override
	public Object getParent(Object element) {
		return ((ContentTree) element).getParent();
	}
	
	@Override
	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}
	
	@Override
	public Object[] getChildren(Object parentElement) {
		return ((ContentTree) parentElement).getChildren().toArray();
	}
}
