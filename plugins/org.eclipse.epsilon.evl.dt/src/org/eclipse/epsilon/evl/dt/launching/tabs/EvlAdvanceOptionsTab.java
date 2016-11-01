package org.eclipse.epsilon.evl.dt.launching.tabs;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
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

public class EvlAdvanceOptionsTab extends AbstractLaunchConfigurationTab {

	public static final String OPTIMIZE_CONSTRAINTS = "optimizeConstraints";
	private Button optimizeConstraintsBtn;

	@Override
	public void createControl(Composite parent) {
		
		final FillLayout parentLayout = new FillLayout();
		parent.setLayout(parentLayout);

		final Composite control = new Composite(parent, SWT.NONE);
		setControl(control);
		control.setLayout(new GridLayout(1, false));
		
		PlatformUI.getWorkbench().getHelpSystem().setHelp(control, "org.eclipse.epsilon.help.egl_generated_text_tab");
		
		createOptimizationGroup(control);
		
		control.setBounds(0, 0, 300, 300);
		control.layout();
		control.pack();
	}

	private void createOptimizationGroup(Composite control) {
		final Group group = new Group(control, SWT.SHADOW_ETCHED_IN);
		group.setLayout(new GridLayout(2, false));
		group.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		group.setText("Advanced");
		optimizeConstraintsBtn = new Button(group, SWT.CHECK);
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
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			initializeOptimizationGroupFrom(configuration);			
		} catch (CoreException e) {
			LogUtil.log("Error encountered whilst attempting to restore selection of default formatters from launch configuration", e);
		}
	}

	private void initializeOptimizationGroupFrom(ILaunchConfiguration configuration) throws CoreException {
		boolean optimizeConstraints = configuration.getAttribute(OPTIMIZE_CONSTRAINTS, false);
		optimizeConstraintsBtn.setSelection(optimizeConstraints);
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		saveOptimizationOptionsTo(configuration);

	}

	private void saveOptimizationOptionsTo(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(OPTIMIZE_CONSTRAINTS, optimizeConstraintsBtn.getSelection());
	}

	@Override
	public String getName() {
		return "Advance Options";
	}

	@Override
	public Image getImage() {
		return EvlPlugin.getDefault().createImage("icons/advanced.png");
	}

}
