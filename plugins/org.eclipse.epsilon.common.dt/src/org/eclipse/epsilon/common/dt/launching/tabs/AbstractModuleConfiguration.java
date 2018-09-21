package org.eclipse.epsilon.common.dt.launching.tabs;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.epsilon.common.concurrent.ConcurrencyUtils;
import org.eclipse.epsilon.eol.execute.context.concurrent.IEolContextParallel;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;

public class AbstractModuleConfiguration implements ModuleConfiguration {

	public static final int INITIAL_THREADS = ConcurrencyUtils.DEFAULT_PARALLELISM;

	public static Composite createParallelContainer(Composite group) {
		final Composite container = new Composite(group, SWT.FILL);
		container.setLayout(new GridLayout(2, false));
		container.setLayoutData(new GridData(GridData.FILL_VERTICAL));
		return container;
	}
	
	public static Label createThreadsLabel(Composite container) {
		Label numThreadsLabel = new Label(container, SWT.WRAP);
		numThreadsLabel.setText("Number of threads: ");
		return numThreadsLabel;
	}

	public static Spinner createThreadsSelector(Composite container) {
		Spinner numThreadsSelector = new Spinner(container, SWT.BORDER);
		numThreadsSelector.setMinimum(1);
		numThreadsSelector.setSelection(INITIAL_THREADS);
		// Increments by 2 if even, 3 if divisible by 3, 1 otherwise
		numThreadsSelector.setIncrement(INITIAL_THREADS % 2 == 0 ? 2 : (INITIAL_THREADS % 3 == 0 ? 3 : 1));
		numThreadsSelector.setMaximum(INITIAL_THREADS*4);
		numThreadsSelector.setToolTipText("Parallelism");
		return numThreadsSelector;
	}
	
	public static void initializeThreadsFromConfiguration(ILaunchConfiguration configuration, Spinner numThreadsSelector) {
		try {
			numThreadsSelector.setSelection(configuration.getAttribute(IEolContextParallel.NUM_THREADS_CONFIG, INITIAL_THREADS));
		}
		catch (CoreException cx) {
			// TODO Auto-generated catch block
		}
	}
	
	public static void performApplyThreadsForConfiguration(ILaunchConfigurationWorkingCopy configuration, Spinner numThreadsSelector) {
		int numThreads = numThreadsSelector != null ? numThreadsSelector.getSelection() : INITIAL_THREADS;
		configuration.setAttribute(IEolContextParallel.NUM_THREADS_CONFIG, numThreads);
	}
	
	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		// Nothing to do
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		// Nothing to store
	}

	@Override
	public void createModuleConfigurationWidgets(Composite group, AbstractAdvancedConfigurationTab tab) {
	}
}
