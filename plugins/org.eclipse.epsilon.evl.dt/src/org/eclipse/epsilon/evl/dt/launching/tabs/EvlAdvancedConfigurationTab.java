package org.eclipse.epsilon.evl.dt.launching.tabs;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.epsilon.common.dt.EpsilonPlugin;
import org.eclipse.epsilon.common.dt.launching.tabs.AbstractAdvancedConfigurationTab;
import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.eclipse.epsilon.evl.dt.EvlPlugin;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.PlatformUI;

public class EvlAdvancedConfigurationTab extends AbstractAdvancedConfigurationTab {

	public static final String OPTIMIZE_CONSTRAINTS = "optimizeConstraints";
	private Button optimizeConstraintsBtn;

	@Override
	public void createAdditionalGroups(Composite control) {
		
		createOptimizationGroup(control);
	}

	private void createOptimizationGroup(Composite control) {
		optimizeConstraintsBtn = new Button(control, SWT.CHECK);
		optimizeConstraintsBtn.setText("Optimize Constraints to Select Operations");
		optimizeConstraintsBtn.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				updateLaunchConfigurationDialog();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				updateLaunchConfigurationDialog();
			}
		});
	}


	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		

	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		super.performApply(configuration);
		saveOptimizationOptionsTo(configuration);

	}

	private void saveOptimizationOptionsTo(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(OPTIMIZE_CONSTRAINTS, optimizeConstraintsBtn.getSelection());
	}

	@Override
	public EpsilonPlugin getPlugin() {
		return EvlPlugin.getDefault();
	}

	@Override
	public String getLanguage() {
		return "EVL";
	}

	
}
