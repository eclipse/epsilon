package org.eclipse.epsilon.egl.execute.context;

import java.net.URI;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.epsilon.egl.EgxModule;
import org.eclipse.epsilon.egl.traceability.Content;
import org.eclipse.epsilon.egl.traceability.Template;
import org.eclipse.epsilon.egl.traceability.Variable;

public class EgxModuleTemplateAdapter extends Template {
		
		protected EgxModule module = null;
		
		public EgxModuleTemplateAdapter(EgxModule module) {
			this.module = module;
		}
	
		@Override
		public String getName() {
			return module.getAst().getFile().getAbsolutePath();
		}
		
		@Override
		public URI getURI() {
			return module.getAst().getUri();
		}
		
		@Override
		public Collection<Variable> getVariables() {
			return Collections.emptyList();
		}
		
		@Override
		public List<Content<Template>> getChildren() {
			return ((EgxModule) module).getInvokedTemplates();
		}
		
		@Override
		public boolean hasChildren() {
			return !getChildren().isEmpty();
		}
		
		public String toString() {
			return this.getClass().getName();
		}
		
	}