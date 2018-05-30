package org.eclipse.epsilon.common.dt.launching.dialogs;

import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.PlatformUI;

public abstract class AbtsractModuleConfigurationDialog extends TitleAreaDialog {
	
	protected StringProperties properties;

	public AbtsractModuleConfigurationDialog() {
		super(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell());
	}

	public StringProperties getProperties() {
		return properties;
	}
	
	public void setProperties(StringProperties properties){
		this.properties = properties;
	}
	
	@Override
	protected Control createDialogArea(Composite parent) {
		
		Composite superControl = (Composite) super.createDialogArea(parent);
		
		
		this.setTitle("Configure " + getModuleName());
		this.setMessage("Configure the details of the " + getModuleName());
		this.getShell().setText("Configure " + getModuleName());
		
		Composite control = new Composite(superControl, SWT.FILL);
		control.setLayout(new GridLayout(1,true));
		control.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		createGroups(control);
		
		PlatformUI.getWorkbench().getHelpSystem().setHelp(control, "org.eclipse.epsilon.help.emc_dialogs");
		
		loadProperties();
		
		control.layout();
		control.pack();
		
		return control;
	}
	
	@Override
	protected void okPressed() {
		storeProperties();
		super.okPressed();
	}


	abstract protected String getModuleName();
	abstract protected void createGroups(Composite control);
	
	protected void loadProperties() {
		if (properties == null) return;
	}
	
	protected void storeProperties() {
		properties = new StringProperties();
		properties.put("moduleName", getModuleName());
	}

}
