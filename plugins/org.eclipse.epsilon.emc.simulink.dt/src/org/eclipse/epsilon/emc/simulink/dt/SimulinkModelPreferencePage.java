package org.eclipse.epsilon.emc.simulink.dt;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.common.dt.EpsilonCommonsPlugin;
import org.eclipse.epsilon.emc.simulink.MatlabEnginePool;
import org.eclipse.epsilon.emc.simulink.SimulinkModel;
import org.eclipse.jface.preference.DirectoryFieldEditor;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

public class SimulinkModelPreferencePage extends PreferencePage implements IWorkbenchPreferencePage {
	
	protected List<FieldEditor> fieldEditors = new ArrayList<FieldEditor>();
	
	@Override
	protected Control createContents(Composite parent) {
		
		Composite composite = new Composite(parent, SWT.FILL);

		final DirectoryFieldEditor libraryPathEditor = new DirectoryFieldEditor(SimulinkModel.PROPERTY_LIBRARY_PATH, "Library directory", composite);
		final FileFieldEditor engineJarPathEditor = new FileFieldEditor(SimulinkModel.PROPERTY_ENGINE_JAR_PATH, "Engine JAR file", true, composite);
		
		fieldEditors.add(libraryPathEditor);
		fieldEditors.add(engineJarPathEditor);
		
		for (FieldEditor fieldEditor : fieldEditors) {
			fieldEditor.setPreferenceStore(EpsilonCommonsPlugin.getDefault().getPreferenceStore());
			fieldEditor.load();
		}
		
		/*
		Button testConnectionButton = new Button(composite, SWT.NONE);
		testConnectionButton.setText("Test connection");
		testConnectionButton.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					MatlabEnginePool.reset();
					MatlabEnginePool.getInstance(libraryPathEditor.getStringValue(), engineJarPathEditor.getStringValue()).getMatlabEngine().eval("42");
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				
			}
		});
		
		Button resetConnectionButton = new Button(composite, SWT.NONE);
		resetConnectionButton.setText("Reset connection");
		testConnectionButton.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				MatlabEnginePool.reset();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				
			}
		});*/
		return composite;
	}
	
	public void init(IWorkbench workbench) {

	}

	@Override
	public boolean performOk() {
		for (FieldEditor fieldEditor : fieldEditors) {
			fieldEditor.store();
		}
		MatlabEnginePool.reset();
		return true;
	}

}
