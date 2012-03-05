package org.eclipse.epsilon.eugenia;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

public class GenerateDiagramCodeDelegate extends EugeniaActionDelegate {
	
	protected IWorkbenchPart targetPart = null;
	
	@Override
	public void runImpl(IAction action) throws Exception {
		IObjectActionDelegate executeTemplateAction = getExecuteTemplateAction();
		if (executeTemplateAction != null) {
			executeTemplateAction.selectionChanged(action,
					new StructuredSelection(WorkspaceUtil.getFile(gmfFileSet.getGmfGenPath())));
			executeTemplateAction.setActivePart(action, targetPart);
			executeTemplateAction.run(action);
		}
	}
	
	public void setTargetPart(IWorkbenchPart targetPart) {
		this.targetPart = targetPart;
	}
	
	private IObjectActionDelegate getExecuteTemplateAction()
			throws CoreException {
		IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
		IConfigurationElement[] configurationElements = extensionRegistry
				.getConfigurationElementsFor("org.eclipse.ui.popupMenus");
		IObjectActionDelegate executeTemplateAction = null;
		for (IConfigurationElement configurationElement : configurationElements) {
			IConfigurationElement[] children = configurationElement
					.getChildren();
			for (IConfigurationElement child : children) {
				String id = child.getAttribute("id");
				if ("gmf.codegen.ui.executeTemplatesAction".equals(id)) {
					executeTemplateAction = (IObjectActionDelegate) child
							.createExecutableExtension("class");
				}
			}
		}
		return executeTemplateAction;
	}

	@Override
	public String getBuiltinTransformation() {
		return null;
	}

	@Override
	public String getCustomizationTransformation() {
		return null;
	}

	@Override
	public List<IModel> getModels() throws Exception {
		return null;
	}

	@Override
	public String getTitle() {
		return "Generating diagram code";
	}

}
