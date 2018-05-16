package org.eclipse.epsilon.common.dt.launching.tabs;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.epsilon.common.dt.EpsilonCommonsPlugin;
import org.eclipse.epsilon.common.dt.EpsilonPlugin;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

/**
 * The Advanced configuration tab allows advanced options to be configured.
 * As a minimum, this tab provides a selection of alternative module implementations
 * for each language.
 * 
 * Each language can provide its own advanced options that can alter the behaviour of the 
 * module (e.g. Evl has an "optimise constraints to select operations" option).
 * 
 * Each alternative module implementation can further provide additional options (e.g. number
 * of cores for parallel execution or db type/connection for incremental).
 * 
 * 
 * @author Horacio Hoyos Rodriguez
 *
 */
public abstract class AbstractAdvancedConfigurationTab extends AbstractLaunchConfigurationTab implements ModifyListener {

	@Override
	public void createControl(Composite parent) {
		
		FillLayout parentLayout = new FillLayout();
		parent.setLayout(parentLayout);
		Composite control = new Composite(parent, SWT.NONE);
		setControl(control);
		GridLayout controlLayout = new GridLayout(2, false);
		control.setLayout(controlLayout);
		
		final Group implementationGroup = createGroup(control, "Implementation:", 2);
		createModuleImplementationSelection(implementationGroup);
		createAdditionalGroups(parentLayout);
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			populateFromConfiguration(configuration);
			canSave();
			updateLaunchConfigurationDialog();
		} catch (CoreException e) {
			//Ignore
		}
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		storeValuesInConfiguration(configuration);
	}


	@Override
	public String getName() {
		return "Advanced";
	}

	@Override
	public void modifyText(ModifyEvent e) {
		canSave();
		updateLaunchConfigurationDialog();
	}
	
	@Override
	public Image getImage() {
		return EpsilonCommonsPlugin.getDefault().createImage("icons/advanced.gif");
	}
	
	public abstract EpsilonPlugin getPlugin();
	
	/**
	 * This method should crate a drop-down list of available implementations. If no alternatinves 
	 * exist, the parent can be disabled. 
	 * @param control
	 */
	public void createModuleImplementationSelection(Composite parent) {
		Combo comboDropDown = new Combo(parent, SWT.DROP_DOWN | SWT.BORDER);
		List<String> implementations = getImplementations();
		implementations.forEach(comboDropDown::add);
		comboDropDown.select(0);
		if (implementations.size() == 1) {
			parent.setEnabled(false);
			comboDropDown.setEnabled(false);
		}
	}
	
	public abstract List<String> getImplementations();
	
	/**
	 * Each language is allowed to create additional groups to provide specific configuration options.
	 * This options can be related to the specific implementation so appropiate hooks should be added
	 * so the become available depending on the selected implementation.
	 * @param parentLayout
	 */
	public abstract void createAdditionalGroups(FillLayout parentLayout);
	
	/**
	 * This method should store any advanced settings in the configuration. Since different implementations
	 * can use different settings, caution must be taken to ensure settings with conflicting names are
	 * handled correctly (e.g. prepend the implementation name to the config key.
	 */
	public abstract void storeValuesInConfiguration(ILaunchConfiguration configuration);
	
	/**
	 * Given that each language provides its own set of settings, this method shouls be used
	 * to read the stored values from the configuration and populate the tab accordingly.
	 * @see #storeValuesInConfiguration()
	 */
	public abstract void populateFromConfiguration(ILaunchConfiguration configuration) throws CoreException;
	
	
	protected Group createGroup(Composite control, String name, int numberOfColumns) {
		final Group group = new Group(control, SWT.SHADOW_ETCHED_IN);
		group.setLayout(new GridLayout(numberOfColumns, false));
		group.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		group.setText(name);
		return group;
	}

}

