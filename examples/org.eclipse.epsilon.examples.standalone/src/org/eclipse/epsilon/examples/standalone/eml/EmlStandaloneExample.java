package org.eclipse.epsilon.examples.standalone.eml;

import java.io.File;

import org.eclipse.epsilon.ecl.EclModule;
import org.eclipse.epsilon.emc.plainxml.PlainXmlModel;
import org.eclipse.epsilon.eml.EmlModule;

public class EmlStandaloneExample {
	
	public static void main(String[] args) throws Exception {
		
		PlainXmlModel catalogue1 = new PlainXmlModel();
		catalogue1.setName("Catalogue1");
		catalogue1.getAliases().add("In");
		catalogue1.setFile(new File(EmlStandaloneExample.class.getResource("catalogue1.xml").toURI()));
		catalogue1.load();
	
		PlainXmlModel catalogue2 = new PlainXmlModel();
		catalogue2.setName("Catalogue2");
		catalogue2.getAliases().add("In");
		catalogue2.setFile(new File(EmlStandaloneExample.class.getResource("catalogue2.xml").toURI()));
		catalogue2.load();
		
		PlainXmlModel merged = new PlainXmlModel();
		merged.setName("Merged");
		merged.setReadOnLoad(false);
		merged.load();
		
		EclModule eclModule = new EclModule();
		eclModule.parse(EmlStandaloneExample.class.getResource("catalogues.ecl").toURI());
		eclModule.getContext().getModelRepository().addModel(catalogue1);
		eclModule.getContext().getModelRepository().addModel(catalogue2);
		eclModule.execute();
		
		EmlModule emlModule = new EmlModule();
		emlModule.parse(EmlStandaloneExample.class.getResource("catalogues.eml").toURI());
		emlModule.getContext().getModelRepository().addModel(catalogue1);
		emlModule.getContext().getModelRepository().addModel(catalogue2);
		emlModule.getContext().getModelRepository().addModel(merged);
		emlModule.getContext().setMatchTrace(eclModule.getContext().getMatchTrace().getReduced());
		emlModule.execute();
		
		System.out.println(merged.getXml());
		
	}
	
	
	
	
}
