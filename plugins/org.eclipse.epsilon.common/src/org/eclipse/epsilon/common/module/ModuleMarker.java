package org.eclipse.epsilon.common.module;

import java.io.File;

import org.eclipse.epsilon.common.parse.Region;

public class ModuleMarker {
	
	protected File file;
	protected Region region;
	protected String message;
	protected Severity severity;
	
	public ModuleMarker() {}
	
	public ModuleMarker(AbstractModuleElement element, String message, Severity severity) {
		this(element.getFile(), element.getRegion(), message, severity);
	}
	
	public ModuleMarker(File file, Region region, String message, Severity severity) {
		super();
		this.file = file;
		this.region = region;
		this.message = message;
		this.severity = severity;
	}

	public Severity getSeverity() {
		return severity;
	}

	public void setSeverity(Severity severity) {
		this.severity = severity;
	}

	public File getFile() {
		return file;
	}
	
	public void setFile(File file) {
		this.file = file;
	}
	
	public Region getRegion() {
		return region;
	}
	
	public void setRegion(Region region) {
		this.region = region;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

	public enum Severity {
		Information,
		Warning,
		Error
	}

}
