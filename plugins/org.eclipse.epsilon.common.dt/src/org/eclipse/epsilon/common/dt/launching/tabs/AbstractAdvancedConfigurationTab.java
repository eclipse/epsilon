package org.eclipse.epsilon.common.dt.launching.tabs;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
import org.eclipse.epsilon.common.dt.launching.extensions.ModuleImplementationExtension;
import org.eclipse.epsilon.common.dt.util.DialogUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

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
 * @since 1.6
 * @author Horacio Hoyos Rodriguez
 *
 */
public abstract class AbstractAdvancedConfigurationTab extends AbstractLaunchConfigurationTab implements ModifyListener {
	
	public static final String IMPL_NAME = "implementation_name";
	
	private Map<String, ModuleImplementationExtension> implementations;
	protected String implName;
	private int selectedImpl = -1;
	private Combo modulesDropDown;
	private Composite mainComposite;
	private Composite moduleConfigGroup;
	private ModuleConfiguration moduleConfig;
	private Composite configComposite;
	
	@Override
	public void createControl(Composite parent) {
		
		setImplementations(new HashMap<>());
		FillLayout parentLayout = new FillLayout();
		parent.setLayout(parentLayout);
		mainComposite = new Composite(parent, SWT.NONE);
		setControl(mainComposite);
		GridLayout controlLayout = new GridLayout(1, false);
		mainComposite.setLayout(controlLayout);
		Label modulesLabel = new Label(mainComposite, SWT.NONE);
		modulesLabel.setText("Execution engine:");
		modulesDropDown = new Combo(mainComposite, SWT.DROP_DOWN | SWT.READ_ONLY | SWT.BORDER);
		modulesDropDown.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				int index = modulesDropDown.getSelectionIndex();
				if (index != selectedImpl) {
					implName = modulesDropDown.getItem(index);
					createConfigComposite(mainComposite);
					selectedImpl = index;
				}
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Implement modulesDropDown.widgetDefaultSelected
				throw new UnsupportedOperationException(
						"Unimplemented Method    modulesDropDown.widgetDefaultSelected invoked.");
			}
		});
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			int index = 0;
			implName = configuration.getAttribute(IMPL_NAME, "");
			addAvailableImplsToCombo(configuration);
			if (implName.length() > 0) {
				index = modulesDropDown.indexOf(implName);
				modulesDropDown.select(index);
				if (moduleConfig != null) {
					moduleConfig.initializeFrom(configuration);
				}
			}
			else {
				modulesDropDown.select(0);
				implName = modulesDropDown.getText();
			}
			createConfigComposite(mainComposite);
			updateLaunchConfigurationDialog();
		} catch (CoreException e) {
			//Ignore
		}
	}
	
	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(IMPL_NAME, modulesDropDown.getText());
		if (moduleConfig != null) {
			moduleConfig.performApply(configuration);
		}
	}
	

	@Override
	public void activated(ILaunchConfigurationWorkingCopy workingCopy) {

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
	 * Get the name of the language being configured
	 * @since 1.6
	 * @param configuration the eclipse launch configuration
	 * 
	 */
	public abstract String getLanguage(ILaunchConfiguration configuration);
	

	
	/**
	 * This method creates a drop-down list of available implementations. If no alternatives 
	 * exist, the combo (or the parent) can be disabled, but should show the default one. 
	 * @param configuration the eclpse launch configuration
	 * @param control
	 */
	private void addAvailableImplsToCombo(ILaunchConfiguration configuration) {
		getImplementations(configuration).stream().forEach(modulesDropDown::add);
		if (getImplementations().size() == 1) {
			modulesDropDown.setEnabled(false);
		}
		else {
			modulesDropDown.setEnabled(true);
		}
	}

	
	/**
	 * The available implementations are extracted from the moduleImplementation extension point, based on
	 * the language provided by the plugin (see {@link #getPlugin()}).
	 * @param configuration the eclipse launch configuration
	 * @return A list of the names of the available module implementations for the language
	 * @throws CoreException if the configuration dialog of an implementation can not be created
	 */
	public List<String> getImplementations(ILaunchConfiguration configuration) {
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IExtensionPoint extensionPoint = registry.getExtensionPoint("org.eclipse.epsilon.common.dt.moduleImplementation");
		IConfigurationElement[] configurationElements =  extensionPoint.getConfigurationElements();
		String language = getLanguage(configuration);
		for (int i=0;i<configurationElements.length; i++){
			IConfigurationElement configurationElement = configurationElements[i];
			String configLanguage = configurationElement.getAttribute("language");
			if (configLanguage.equals(language)) {	
				ModuleImplementationExtension moduleType = null;
				moduleType = new ModuleImplementationExtension(configurationElement);
				implementations.put(moduleType.getName(), moduleType);
			}
		}
		return implementations.values().stream().sorted(new Comparator<ModuleImplementationExtension>() {

			@Override
			public int compare(ModuleImplementationExtension o1, ModuleImplementationExtension o2) {
				if (o1.isDefault()) {
					return -1;
				}
				if (o2.isDefault()) {
					return 1;
				}
				return 0;
			}
				})
				.map(i -> i.getName())
				.collect(Collectors.toList());
	}
	
	/**
	 * @param parent 
	 * @param index
	 * @param impl
	 */
	private void createConfigComposite(Composite parent) {
		moduleConfig = null;
		try {
			moduleConfig = getImplementations().get(implName).createDialog();
		} catch (EpsilonDtException e) {
			// No configuration available
		}
		if (moduleConfigGroup != null) {
			configComposite.addDisposeListener(new DisposeListener() {
				@Override
				public void widgetDisposed(DisposeEvent e) {
					// Need to redraw in case the implementation changed.
					if (moduleConfig != null) {
						configComposite = new Composite(parent, SWT.NONE);
						GridLayout controlLayout = new GridLayout(2, true);
						configComposite.setLayout(controlLayout);
						moduleConfig.createModuleConfigurationWidgets(moduleConfigGroup);
						if (moduleConfigGroup.getChildren().length == 0) {
							moduleConfigGroup.setVisible(false);
						}
					}
				}
			});
			configComposite.dispose();
		}
		else {
			configComposite = new Composite(parent, SWT.NONE);
			GridLayout controlLayout = new GridLayout(2, true);
			configComposite.setLayout(controlLayout);
			moduleConfigGroup = DialogUtil.createGroupContainer(parent, "Options", 1);
			moduleConfig.createModuleConfigurationWidgets(moduleConfigGroup);
			if (moduleConfigGroup.getChildren().length == 0) {
				moduleConfigGroup.setVisible(false);
			}
			configComposite.redraw();
		}
		updateLaunchConfigurationDialog();
	}

	public Map<String, ModuleImplementationExtension> getImplementations() {
		return implementations;
	}

	public void setImplementations(Map<String, ModuleImplementationExtension> implementations) {
		this.implementations = implementations;
	}

}

