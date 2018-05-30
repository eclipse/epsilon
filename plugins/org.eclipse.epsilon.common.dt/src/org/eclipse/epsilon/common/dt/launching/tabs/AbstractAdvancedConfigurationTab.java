package org.eclipse.epsilon.common.dt.launching.tabs;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.epsilon.common.dt.EpsilonCommonsPlugin;
import org.eclipse.epsilon.common.dt.EpsilonPlugin;
import org.eclipse.epsilon.common.dt.exceptions.EpsilonDtException;
import org.eclipse.epsilon.common.dt.launching.dialogs.AbtsractModuleConfigurationDialog;
import org.eclipse.epsilon.common.dt.launching.extensions.ModuleImplementationExtension;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

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
	
	private Map<String, ModuleImplementationExtension> implementations;
	private Map<String, String> implConfigs;
	private String implConfig;
	private int selectedImpl = -1;
	private Combo modulesDropDown;
	
	@Override
	public void createControl(Composite parent) {
		
		implementations = new HashMap<>();
		FillLayout parentLayout = new FillLayout();
		parent.setLayout(parentLayout);
		Composite control = new Composite(parent, SWT.NONE);
		setControl(control);
		GridLayout controlLayout = new GridLayout(1, false);
		control.setLayout(controlLayout);
		
		final Group implementationGroup = createGroup(control, "Implementation:", 2);
		createModuleImplementationSelection(implementationGroup);
		createAdditionalGroups(control);
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			implConfig = configuration.getAttribute("implConfig", "");
			if (implConfig.length() > 0) {
				StringProperties properties = new StringProperties();
				properties.load(implConfig);
				String impl = (String) properties.get("moduleName");
				int index = modulesDropDown.indexOf(impl);
				modulesDropDown.select(index);
			}
			else {
				modulesDropDown.select(0);
			}
			canSave();
			updateLaunchConfigurationDialog();
		} catch (CoreException e) {
			//Ignore
		}
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute("implConfig", implConfig);
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
	 * The language provided by the plugin. It allows other plugins to contribute
	 * alternate IModule implementation of the language.
	 * @return
	 */
	public abstract String getLanguage();
	
	/**
	 * This method creates a drop-down list of available implementations. If no alternatives 
	 * exist, the combo (or the parent) can be disabled, but should show the default one. 
	 * @param control
	 */
	public void createModuleImplementationSelection(Composite parent) {
		modulesDropDown = new Combo(parent, SWT.DROP_DOWN | SWT.READ_ONLY | SWT.BORDER);
		getImplementations().stream().sorted().forEach(modulesDropDown::add);
		if (implementations.size() == 1) {
			// This assumes that the default implementation does not need configuration
			parent.setEnabled(false);
			modulesDropDown.setEnabled(false);
		}
		else {
			modulesDropDown.addSelectionListener(new SelectionListener() {

				@Override
				public void widgetSelected(SelectionEvent e) {
					int index = modulesDropDown.getSelectionIndex();
					String impl = modulesDropDown.getItem(index);
					if (index != selectedImpl) {
						implConfig = implConfigs.get(impl);
						if (implConfig == null) {
							selectAndConfigImpl(index, impl);
						}
					}
					
				}
				
				@Override
				public void widgetDefaultSelected(SelectionEvent e) {
					// TODO Implement modulesDropDown.widgetDefaultSelected
					throw new UnsupportedOperationException(
							"Unimplemented Method    modulesDropDown.widgetDefaultSelected invoked.");
				}
			});
			final Menu modulesDropDownMenu = new Menu(modulesDropDown);
			MenuItem configItem = new MenuItem(modulesDropDownMenu, SWT.NONE);
            configItem.setText("Config...");
			configItem.addSelectionListener(new SelectionListener() {
				
				@Override
				public void widgetSelected(SelectionEvent e) {
					int index = modulesDropDown.getSelectionIndex();
					String impl = modulesDropDown.getItem(index);
					selectAndConfigImpl(index, impl);
				}
				
				@Override
				public void widgetDefaultSelected(SelectionEvent e) {
					// TODO Implement modulesDropDownMenu.widgetDefaultSelected
					throw new UnsupportedOperationException(
							"Unimplemented Method    modulesDropDownMenu.widgetDefaultSelected invoked.");
				}
			});
            modulesDropDown.setMenu(modulesDropDownMenu);
			
		}
	}
	
	/**
	 * Each language is allowed to create additional groups to provide specific configuration options.
	 * @param control
	 */
	public abstract void createAdditionalGroups(Composite control);
	
	
	protected Group createGroup(Composite control, String name, int numberOfColumns) {
		final Group group = new Group(control, SWT.SHADOW_ETCHED_IN);
		group.setLayout(new GridLayout(numberOfColumns, false));
		group.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		group.setText(name);
		return group;
	}
	
	/**
	 * The available implementations are extracted from the moduleImplementation extension point, based on
	 * the language provided by the plugin (see {@link #getPlugin()}).
	 * @return A list of the names of the available module implementations for the language
	 * @throws CoreException if the configuration dialog of an implementation can not be created
	 */
	private Set<String> getImplementations() {
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IExtensionPoint extensionPoint = registry.getExtensionPoint("org.eclipse.epsilon.common.dt.moduleImplementation");
		IConfigurationElement[] configurationElements =  extensionPoint.getConfigurationElements();
		for (int i=0;i<configurationElements.length; i++){
			IConfigurationElement configurationElement = configurationElements[i];
			if (configurationElement.getAttribute("language").equals(getLanguage())) {	
				ModuleImplementationExtension moduleType = null;
				moduleType = new ModuleImplementationExtension(configurationElement);
				implementations.put(moduleType.getName(), moduleType);
			}
		}
		// FIXME Return a list, where the default is the first one.
		return implementations.keySet();
	}
	
	/**
	 * @param index
	 * @param impl
	 */
	private void selectAndConfigImpl(int index, String impl) {
		AbtsractModuleConfigurationDialog moduleConfigDialog = null;
		try {
			moduleConfigDialog = implementations.get(impl).createDialog();
		} catch (EpsilonDtException e) {
			e.printStackTrace();
		}
		if (moduleConfigDialog != null) {
			moduleConfigDialog.setBlockOnOpen(true);
			moduleConfigDialog.open();
			if (moduleConfigDialog.getReturnCode() == Window.OK){
				implConfig = moduleConfigDialog.getProperties().toString();
				
			}
			else {
				StringProperties properties = new StringProperties();
				properties.put("moduleName", impl);
				implConfig = properties.toString();
			}
		}
		selectedImpl = index;
		canSave();
		updateLaunchConfigurationDialog();
	}

}

