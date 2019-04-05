package org.eclipse.epsilon.flexmi.dt;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.eclipse.epsilon.egl.EglPersistentTemplate;
import org.eclipse.epsilon.egl.exceptions.EglRuntimeException;
import org.eclipse.epsilon.egl.execute.context.IEglContext;
import org.eclipse.epsilon.egl.spec.EglTemplateSpecification;
import org.eclipse.epsilon.egl.traceability.Variable;

public class RenderingEglTemplate extends EglPersistentTemplate {
	
	protected ContentTree contentTree;
	protected IEglContext context;
	
	public RenderingEglTemplate(EglTemplateSpecification spec, IEglContext context, URI outputRoot, String outputRootPath)
			throws Exception {
		super(spec, context, outputRoot, outputRootPath);
		this.context = context;
	}
	
	@Override
	protected void doGenerate(File file, String targetName, boolean overwrite, boolean merge)
			throws EglRuntimeException {
		while (targetName.startsWith("/")) targetName = targetName.substring(1);
		
		String format = "html";
		String icon = "cccccc";
		Collection<String> path = new ArrayList<>(Arrays.asList(""));
		
		for (Variable variable : template.getVariables()) {
			switch (variable.getName()) {
			case "format": format = variable.getValue() + ""; break;
			case "path": path = (Collection<String>) variable.getValue(); break;
			case "icon": icon = variable.getValue() + ""; break;
			}
		}
		
		contentTree.addPath(new ArrayList<String>(path), getContents(), format, icon);
	}
	
	public void setContentTree(ContentTree contentTree) {
		this.contentTree = contentTree;
	}
	
}
