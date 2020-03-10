package org.eclipse.epsilon.dt.epackageregistryexplorer;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.PatternFilter;

public class PackageRegistryTree extends FilteredTree {

	/**
	 * Create a new instance of the receiver.
	 *
	 * @param parent
	 *            the parent <code>Composite</code>
	 * @param treeStyle
	 *            the style bits for the <code>Tree</code>
	 * @param filter
	 *            the filter to be used
	 * @param useNewLook
	 *            <code>true</code> if the new 3.5 look should be used
	 */
	public PackageRegistryTree(Composite parent, int treeStyle, PatternFilter filter, boolean useNewLook) {
		super(parent, treeStyle, filter, useNewLook);
	}
	
	public void clearFilterText() {
		if (filterText != null && !filterText.getText().equals("")) {
			clearText();
		}
	}
	
	/**
	 * Return the time delay that should be used when scheduling the
	 * filter refresh job.  Subclasses may override.
	 *
	 * @return a time delay in milliseconds before the job should run
	 *
	 * @since 3.5
	 */
	@Override
	protected long getRefreshJobDelay() {
		return 100;
	}
}
