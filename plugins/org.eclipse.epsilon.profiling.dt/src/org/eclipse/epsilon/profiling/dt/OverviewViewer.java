package org.eclipse.epsilon.profiling.dt;

import java.awt.Toolkit;

import org.eclipse.epsilon.profiling.ProfilerOverview;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;

public class OverviewViewer extends Composite {
	
	protected ScrolledForm form = null;
	protected Label executionTimeLabel;
	protected Label executionCountLabel;
	protected Label averageLabel;
	
	public OverviewViewer(Composite parent, int style) {
		super(parent, style);
		this.setLayout(new FillLayout());
		FormToolkit toolkit = new FormToolkit(parent.getDisplay());
		form = toolkit.createScrolledForm(this);
		GridLayout layout = new GridLayout();
		form.getBody().setLayout(layout);
		executionTimeLabel = createLabel(toolkit);
		executionCountLabel = createLabel(toolkit);
		averageLabel = createLabel(toolkit);
		setProfilerOverview(null);
	}
	
	protected Label createLabel(FormToolkit toolkit) {
		Label label = toolkit.createLabel(form.getBody(), "");
		label.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		return label;
	}
	
	public void setProfilerOverview(ProfilerOverview overview) {
		if (overview == null) {
			executionTimeLabel.setText("Nothing has been profiled yet.");
			executionCountLabel.setText("");
			averageLabel.setText("");
		}
		else {
			executionTimeLabel.setText( "Total execution time: " + overview.getExecutionTime() + "ms");
			executionCountLabel.setText("Targets executed: " + overview.getExecutionCount());
			averageLabel.setText(       "Average execution time: " + overview.getAverageExecutionTime() + "ms");
		}
	}
	
}
