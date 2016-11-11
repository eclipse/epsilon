package org.eclipse.epsilon.examples.standalone.eol;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.IEolModule;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.examples.standalone.EpsilonStandaloneExample;
import org.eclipse.uml2.uml.UMLPackage;

public class EolStandaloneUmlExample extends EpsilonStandaloneExample{
	
	public static void main(String[] args) throws Exception {
		new EolStandaloneUmlExample().execute();
	}
	
	@Override
	public IEolModule createModule() {
		return new EolModule();
	}

	@Override
	public List<IModel> getModels() throws Exception {
		EPackage.Registry.INSTANCE.put(UMLPackage.eNS_URI, UMLPackage.eINSTANCE);
		System.err.println(UMLPackage.eNS_URI);
		List<IModel> models = new ArrayList<IModel>();
		models.add(createEmfModelByURI("Model", "models/example.uml", UMLPackage.eNS_URI, true, true));
		return models;
	}
	
	@Override
	public String getSource() throws Exception {
		return "eol/Uml.eol";
	}

	@Override
	public void postProcess() {
		
	}
}
