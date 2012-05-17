package org.eclipse.epsilon.examples.egl.gmf.papyrus;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.plugin.AbstractUIPlugin;

public class ExampleM2TPlugin extends AbstractUIPlugin {

	public final static String ID = ExampleM2TPlugin.class.getPackage().getName();
	private static ExampleM2TPlugin INSTANCE;

	public ExampleM2TPlugin() {
		INSTANCE = this;
	}

	public static ExampleM2TPlugin getDefault() {
		return INSTANCE;
	}

	public void logError(String msg, Throwable t) {
		getLog().log(new Status(IStatus.ERROR, ID, msg, t));
	}
}
