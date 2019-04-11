/*********************************************************************
 * Copyright (c) 2019 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.common.dt.launching.tabs;

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
public abstract class AbstractAdvancedConfigurationTab extends AbstractLaunchConfigurationTab {
	
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
					enableApply();
				}
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			int index = 0;
			implName = configuration.getAttribute(IMPL_NAME, "");
			updateAvailableImpls(configuration);
			if (implName.length() > 0 && (index = modulesDropDown.indexOf(implName)) >= 0) {
				modulesDropDown.select(index);
				createConfigComposite(mainComposite);
				if (moduleConfig != null) {
					moduleConfig.initializeFrom(configuration);
				}
			}
			else {
				modulesDropDown.select(index);
				implName = modulesDropDown.getText();
				createConfigComposite(mainComposite);
			}
		} catch (CoreException e) {
			//Ignore
		}
	}
	
	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		System.out.println("advanced performApply");
		configuration.setAttribute(IMPL_NAME, modulesDropDown.getText());
		if (moduleConfig != null) {
			System.out.println("moduleConfig performApply");
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
	 * This method updates the drop-down list of available implementations. If no alternatives 
	 * exist, the combo (or the parent) can be disabled, but should show the default one. 
	 * @param configuration the eclipse launch configuration
	 * @param control
	 */
	protected final void updateAvailableImpls(ILaunchConfiguration configuration) {
		modulesDropDown.removeAll();
		getImplementations(configuration).forEach(modulesDropDown::add);
		modulesDropDown.select(0);
		modulesDropDown.setEnabled(getImplementations().size() > 1);
	}
	
	/**
	 * Used by subclasses to control flexibility of what languages should be included when calling
	 * {@link #getImplementations()} from a given IConfigurationElement. By default, this simply tests
	 * for equality between the language and the configurationElement's language attribute.
	 * 
	 * @param language As obtaiend from {@link #getLanguage(ILaunchConfiguration)}
	 * @param configurationElement Elements from the extension point.
	 * @return Whether the language from the configuration element should be included.
	 */
	protected boolean shouldConfigurationElementBeIncludedAsAnImplementation(String language, IConfigurationElement configurationElement) {
		return language.equalsIgnoreCase(configurationElement.getAttribute("language"));
	}
	
	/**
	 * The available implementations are extracted from the moduleImplementation extension point, based on
	 * the language provided by the plugin (see {@link #getPlugin()}).
	 * @param configuration the eclipse launch configuration
	 * @return A list of the names of the available module implementations for the language
	 * @throws CoreException if the configuration dialog of an implementation can not be created
	 */
	protected final List<String> getImplementations(ILaunchConfiguration configuration) {
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IExtensionPoint extensionPoint = registry.getExtensionPoint("org.eclipse.epsilon.common.dt.moduleImplementation");
		String language = getLanguage(configuration);
		for (IConfigurationElement configurationElement : extensionPoint.getConfigurationElements()) {
			if (shouldConfigurationElementBeIncludedAsAnImplementation(language, configurationElement)) {	
				ModuleImplementationExtension moduleType = new ModuleImplementationExtension(configurationElement);
				implementations.putIfAbsent(moduleType.getName(), moduleType);
			}
			else implementations.remove(configurationElement.getAttribute("name"));
		}
		return implementations.values().stream()
			.sorted((o1, o2) -> {
				if (o1.isDefault()) {
					return -1;
				}
				if (o2.isDefault()) {
					return 1;
				}
				return 0;
			})
			.map(i -> i.getName())
			.collect(Collectors.toList());
	}
	
	private void createConfigComposite(Composite parent) {
		moduleConfig = null;
		try {
			moduleConfig = getImplementations().get(implName).createDialog();
		} catch (EpsilonDtException e) {
			// No configuration available
		}
		if (moduleConfigGroup != null) {
			//Arrays.stream(moduleConfigGroup.getChildren()).forEach(Control::dispose);
			moduleConfigGroup.dispose();
			configComposite.dispose();
		}
		configComposite = new Composite(parent, SWT.NONE);
		GridLayout controlLayout = new GridLayout(2, true);
		configComposite.setLayout(controlLayout);
		moduleConfigGroup = DialogUtil.createGroupContainer(configComposite, "Options", 1);
		moduleConfig.createModuleConfigurationWidgets(moduleConfigGroup, this);
		configComposite.setVisible(moduleConfigGroup.getChildren().length > 0);
		configComposite.redraw();
	}

	public Map<String, ModuleImplementationExtension> getImplementations() {
		return implementations;
	}

	public void setImplementations(Map<String, ModuleImplementationExtension> implementations) {
		this.implementations = implementations;
	}
	
	public void enableApply() {
		setDirty(true);
		System.out.println("advanced can save " + isDirty());
		updateLaunchConfigurationDialog();
	}
}