package org.eclipse.epsilon.flexmi.templates;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.emc.plainxml.PlainXmlModel;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.w3c.dom.Element;

public class EolTemplate extends XmlTemplate {

	public EolTemplate(Element element, URI uri) {
		super(element, uri);
	}
	
	@Override
	public List<Element> getApplication(Element call) {
		try {
			EolModule module = new EolModule();
			module.parse(content.getTextContent().trim(), new File(uri));
			
			for (String parameter : getParameters()) {
				module.getContext().getFrameStack().put(Variable.createReadOnlyVariable(parameter, call.getAttribute(Template.PREFIX + parameter)));
			}
			
			PlainXmlModel model = new PlainXmlModel();
			model.setReadOnLoad(false);
			model.load();
			model.setName("M");
			
			module.getContext().getModelRepository().addModel(model);
			module.execute();
			
			List<Element> elements = new ArrayList<Element>();
			for (Element element : model.allContents()) {
				if (element.getParentNode() == null) {
					elements.add(element);
				}
			}
			return elements;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
		
}
