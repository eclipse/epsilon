package org.eclipse.epsilon.eugenia;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.eclipse.epsilon.commons.util.DebugUtil;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.EolEvaluator;
import org.eclipse.epsilon.eol.parse.Eol_EolParserRules.newExpression_return;
import org.eclipse.gmf.internal.bridge.transform.TransformOptions;
import org.eclipse.gmf.internal.bridge.transform.TransformToGenModelOperation;
import org.eclipse.jface.action.IAction;

public class GmfMap2GmfGenDelegate extends EugeniaActionDelegate {
	
	@Override
	public void runImpl(IAction action) {
		// Transform GmfMap to GmfGen model
		ResourceSet resourceSet = new ResourceSetImpl();
		TransformToGenModelOperation transformToGenModelOperation = new TransformToGenModelOperation(resourceSet);

		//TODO: Set more transformation options
		TransformOptions options = transformToGenModelOperation.getOptions();
		options.setGenerateRCP(getBooleanAnnotationDetailValue("gmf.diagram", "generateRPC", false));
		options.setUseMapMode(getBooleanAnnotationDetailValue("gmf.diagram", "useMapMode", true));
		options.setUseRuntimeFigures(getBooleanAnnotationDetailValue("gmf.diagram", "useRuntimeFigures", true));
		
		final IContainer parent = getSelectedFile().getParent();
		if (parent instanceof IFolder && parent.getParent() != null) {
			final IFolder fGmfmapTemplateDir = parent.getParent().getFolder(
				new Path("templates-gmfmap"));
			if (fGmfmapTemplateDir.exists()) {
				try {
					options.setFigureTemplatesPath(new URL(
						fGmfmapTemplateDir.getLocationURI().toString()));
				} catch (MalformedURLException e) {
					Activator.getDefault().getLog().log(new Status(
						IStatus.ERROR, Activator.PLUGIN_ID,
						"Could not set the path to the figure templates", e));
				}
			}
		}

		try {
			transformToGenModelOperation.loadMappingModel(URI.createURI(gmfFileSet.getGmfMapPath()), new NullProgressMonitor());
			transformToGenModelOperation.loadGenModel(URI.createURI(gmfFileSet.getGenModelPath()), new NullProgressMonitor());
		}
		catch (Exception ex) {
			Activator.getDefault().getLog().log(new Status(
				IStatus.ERROR, Activator.PLUGIN_ID, "Could not load the GmfMap and GmfGen models", ex));
		}
		transformToGenModelOperation.setGenURI(URI.createURI(gmfFileSet.getGmfGenPath()));

		transformToGenModelOperation.executeTransformation(new NullProgressMonitor());
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
	public List<EmfModel> getModels() throws Exception {
		return null;
	}

	@Override
	public String getTitle() {
		return "Generating .gmfgen model";
	}
	
	protected EolEvaluator evaluator = null;
	
	protected boolean getBooleanAnnotationDetailValue(String annotation, String detail, boolean default_) {
		return "true".equals(getAnnotationDetailValue(annotation, detail, default_ + ""));
	}
	
	protected String getAnnotationDetailValue(String annotation, String detail, String default_) {
		try {
			if (evaluator == null) {
				EmfModel ecore = loadModel("Ecore", gmfFileSet.getEcorePath(), EcorePackage.eINSTANCE.getNsURI(), true, false, true);
				evaluator = new EolEvaluator(ecore);
			}
			Object o = evaluator.evaluate("EAnnotation.all.select(a|a.source='" + annotation + "').collect(a|a.details.select(d|d.key='" + detail + "')).flatten().collect(d|d.value).first()");
			if (o == null) return default_;
			else return o + "";
		}
		catch (Exception ex) {
			return default_;
		}
	}
}
