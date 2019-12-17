package org.eclipse.epsilon.picto.source;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.emfatic.core.generator.ecore.Builder;
import org.eclipse.emf.emfatic.core.generator.ecore.Connector;
import org.eclipse.emf.emfatic.core.generator.ecore.EmfaticSemanticWarning;
import org.eclipse.emf.emfatic.core.lang.gen.parser.EmfaticParserDriver;
import org.eclipse.emf.emfatic.ui.editor.EmfaticEditor;
import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.eclipse.gymnast.runtime.core.parser.ParseContext;
import org.eclipse.gymnast.runtime.core.parser.ParseMessage;
import org.eclipse.ui.IEditorPart;

public class EmfaticSource extends ExternalMetadataSource {

	@Override
	public Resource getResource(IEditorPart editorPart) {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(getFile(editorPart).getContents()));
			EmfaticParserDriver parser = new EmfaticParserDriver(URI.createFileURI("some.emf"));
			ParseContext parseContext = parser.parse(reader);
			ResourceSet resourceSet = new ResourceSetImpl();
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new ResourceFactoryImpl());
			Resource resource = resourceSet.createResource(URI.createFileURI("some.ecore"));
			Builder builder = new Builder();
			NullProgressMonitor monitor = new NullProgressMonitor();
			builder.build(parseContext, resource, monitor);
			if (!parseContext.hasErrors()) {
				Connector connector = new Connector(builder);
				connector.connect(parseContext, resource, monitor);
			}
			
			boolean showStopper = false;
			for (ParseMessage pm : parseContext.getMessages()) {
				showStopper |= !(pm instanceof EmfaticSemanticWarning.EcoreValidatorDiagnostic);
			}
			
			if (!showStopper) {
				return resource;
			}
		} catch (Exception ex) {
			LogUtil.log(ex);
		}
		return null;
	}

	@Override
	public boolean supports(IEditorPart editorPart) {
		try {
			Class.forName("org.eclipse.emf.emfatic.ui.editor.EmfaticEditor");
		} catch (ClassNotFoundException e) { return false; }
		return editorPart instanceof EmfaticEditor;
	}

	@Override
	public IFile getFile(IEditorPart editorPart) {
		return ((EmfaticEditor) editorPart).getFile();
	}
	
	@Override
	public void showElement(String id, String uri, IEditorPart editor) {
		throw new UnsupportedOperationException();
	}
	
}
