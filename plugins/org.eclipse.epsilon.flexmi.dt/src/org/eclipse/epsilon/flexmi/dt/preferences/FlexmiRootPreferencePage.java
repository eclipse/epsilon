package org.eclipse.epsilon.flexmi.dt.preferences;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

public class FlexmiRootPreferencePage extends PreferencePage implements IWorkbenchPreferencePage {

	public FlexmiRootPreferencePage() {
		noDefaultAndApplyButton();
	}

	public FlexmiRootPreferencePage(String title) {
		super(title);
	}

	public FlexmiRootPreferencePage(String title, ImageDescriptor image) {
		super(title, image);
	}

	@Override
	public void init(IWorkbench workbench) {
	}

	@Override
	protected Control createContents(Composite parent) {
		Composite comp  = new Composite(parent, SWT.NULL);
		comp.setLayout(new FillLayout());
		Label l = new Label(comp, SWT.NULL);
		l.setText("Preferences for the Flexmi Plugin");	
		return comp;
	}

}
