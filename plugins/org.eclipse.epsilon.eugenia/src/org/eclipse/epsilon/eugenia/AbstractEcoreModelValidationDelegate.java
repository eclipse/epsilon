package org.eclipse.epsilon.eugenia;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.IEolModule;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.evl.EvlModule;
import org.eclipse.epsilon.evl.execute.UnsatisfiedConstraint;

public abstract class AbstractEcoreModelValidationDelegate extends EugeniaActionDelegate {
	
	protected boolean valid = false;
	protected List<UnsatisfiedConstraint> unsatisfiedConstraints = null;
	protected boolean validationEnabled = true;
	protected IModel ecoreModel = null;
	protected final String SECONDARY_MARKER_TYPE = "secondary-marker-type";
	
	
	@Override
	public String getTitle() {
		return "Validating .ecore model";
	}
	
	protected abstract String getMarkerType();
	
	@Override
	public IEolModule createBuiltinModule() {
		return new EvlModule() {
			@Override
			public Object execute() throws EolRuntimeException {
				
				Object result = null;
				try {
					
					// Delete all previous eugenia validation markers
					IFile file = WorkspaceUtil.getFile(getGmfFileSet().getEcorePath());
					//file.deleteMarkers(getMarkerType(), false, IResource.DEPTH_INFINITE);
					
					for (IMarker marker : file.findMarkers(EValidator.MARKER, false, IResource.DEPTH_INFINITE)) {
						if (marker.getAttribute(SECONDARY_MARKER_TYPE, "").equalsIgnoreCase(getMarkerType())) {
							marker.delete();
						}
					}
					
					// Users can add a @eugenia(validation="off") to their top-level EPackage
					// to skip validation (we don't want potential bugs in the validation logic to
					// prevent users from using Eugenia
					
					EolModule validationEnabledCheckingModule = new EolModule();
					validationEnabledCheckingModule.parse(
							"return not EPackage.all.first().eAnnotations.selectOne(a|a.source = 'eugenia' and a.details.get('validation') = 'off').isDefined();");
					validationEnabledCheckingModule.getContext().getModelRepository().addModel(ecoreModel);
					validationEnabled = (Boolean) validationEnabledCheckingModule.execute();
					
					if (!validationEnabled) {
						valid = true;
					}
					else {
						valid = false;
						super.execute();
						unsatisfiedConstraints = this.getContext().getUnsatisfiedConstraints();
						valid = (getErrors().size() == 0);
						
						// Create markers for unsatisfied constraints
						for (UnsatisfiedConstraint unsatisfiedConstraint : unsatisfiedConstraints) {
							IMarker marker = file.createMarker(EValidator.MARKER);
							if (unsatisfiedConstraint.getConstraint().isCritique()) {
								marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_WARNING);
							}
							else {
								marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
							}
							marker.setAttribute(IMarker.MESSAGE, unsatisfiedConstraint.getMessage());
							marker.setAttribute(SECONDARY_MARKER_TYPE, getMarkerType());
							//if (unsatisfiedConstraint.getInstance() instanceof EObject) {
								//EObject eObject = (EObject) unsatisfiedConstraint.getInstance();
								//IFile f = WorkspaceUtil.getFile(eObject.eResource().getURI().toString());
								//System.err.println("--" + eObject + " -> " + EcoreUtil.getURI(eObject).toPlatformString(true));
								//String uri = URI.createPlatformResourceURI(f.getFullPath().toString() + "" + eObject.eResource().getURIFragment(eObject), false).toString();
								//String uri = EcoreUtil.getURI(eObject).toPlatformString(true);
								//marker.setAttribute(EValidator.URI_ATTRIBUTE, uri);
							//}
						}
						
					}
				}
				catch (Exception ex) {
					LogUtil.log(ex);
				}
				return result;
			}
		};
	}
	
	@Override
	public List<IModel> getModels() throws Exception {
		List<IModel> models = new ArrayList<IModel>();
		ecoreModel = loadModel("ECore", gmfFileSet.getEcorePath(), EcorePackage.eINSTANCE.getNsURI(), true, false, true);
		models.add(ecoreModel);
		return models;
	}

	@Override
	public String getCustomizationTransformation() {
		return null;
	}

	public boolean isValid() {
		return valid;
	}
	
	public List<UnsatisfiedConstraint> getUnsatisfiedConstraints() {
		return unsatisfiedConstraints;
	}
	
	public List<UnsatisfiedConstraint> getUnsatisfiedConstraints(boolean error) {
		List<UnsatisfiedConstraint> unsatisfiedConstraints = new ArrayList<UnsatisfiedConstraint>();
		for (UnsatisfiedConstraint unsatisfiedConstraint : getUnsatisfiedConstraints()) {
			if (!unsatisfiedConstraint.getConstraint().isCritique() == error) {
				unsatisfiedConstraints.add(unsatisfiedConstraint);
			}
		}
		return unsatisfiedConstraints;
	}
	
	public List<UnsatisfiedConstraint> getErrors() {
		return getUnsatisfiedConstraints(true);
	}
}
