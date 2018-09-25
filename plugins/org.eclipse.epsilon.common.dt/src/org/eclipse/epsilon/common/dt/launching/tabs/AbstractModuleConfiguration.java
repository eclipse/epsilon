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
		// Nothing to create
	}
	
	
	// Parallel module utils
	
	protected static final int THREAD_INITIAL = ConcurrencyUtils.DEFAULT_PARALLELISM;
	protected static final int THREAD_INCREMENTS = (int) Math.round(Math.sqrt(THREAD_INITIAL));
	protected static final int THREAD_MAXIMUM = THREAD_INITIAL*THREAD_INCREMENTS;

	protected static Composite createParallelContainer(Composite group) {
		final Composite container = new Composite(group, SWT.FILL);
		container.setLayout(new GridLayout(2, false));
		container.setLayoutData(new GridData(GridData.FILL_VERTICAL));
		return container;
	}
	
	protected static Label createThreadsLabel(Composite container) {
		Label numThreadsLabel = new Label(container, SWT.WRAP);
		numThreadsLabel.setText("Number of threads: ");
		return numThreadsLabel;
	}

	protected static Spinner createThreadsSelector(Composite container) {
		Spinner numThreadsSelector = new Spinner(container, SWT.BORDER);
		numThreadsSelector.setMinimum(1);
		numThreadsSelector.setSelection(THREAD_INITIAL);
		numThreadsSelector.setIncrement(THREAD_INCREMENTS);
		numThreadsSelector.setMaximum(THREAD_MAXIMUM);
		numThreadsSelector.setToolTipText("Parallelism");
		return numThreadsSelector;
	}
	
	protected static void initializeThreadsFromConfiguration(ILaunchConfiguration configuration, Spinner numThreadsSelector) {
		try {
			numThreadsSelector.setSelection(configuration.getAttribute(IEolContextParallel.NUM_THREADS_CONFIG, THREAD_INITIAL));
		}
		catch (CoreException cx) {
			// TODO Auto-generated catch block
		}
	}
	
	protected static void performApplyThreadsForConfiguration(ILaunchConfigurationWorkingCopy configuration, Spinner numThreadsSelector) {
		int numThreads = numThreadsSelector != null ? numThreadsSelector.getSelection() : THREAD_INITIAL;
		configuration.setAttribute(IEolContextParallel.NUM_THREADS_CONFIG, numThreads);
	}
}
