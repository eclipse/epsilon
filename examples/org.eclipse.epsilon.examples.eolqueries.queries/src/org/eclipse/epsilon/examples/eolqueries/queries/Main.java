package org.eclipse.epsilon.examples.eolqueries.queries;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

import library.Author;
import library.Book;
import library.Library;
import library.LibraryPackage;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.epsilon.emc.emf.InMemoryEmfModel;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.EolOperation;
import org.eclipse.epsilon.eol.types.EolCollection;
import org.eclipse.epsilon.eol.types.EolString;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		String root = "E:/Projects/Eclipse/3.4/minimal/org.eclipse.epsilon.examples.eolqueries.queries/src/org/eclipse/epsilon/examples/eolqueries/queries/";
		
		// Load the model using EMF
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getPackageRegistry().put(LibraryPackage.eNS_URI, LibraryPackage.eINSTANCE);
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
		Resource resource = resourceSet.createResource(URI.createFileURI(root + "library.model"));
		resource.load(new HashMap());
		
		// Get hold of the root library object
		
		Library library = (Library) resource.getContents().get(0);
		
		// Prepare the EOL module
		EolModule module = new EolModule();
		module.parse(new File(root + "queries.eol"));
		
		if (module.getParseProblems().size() > 0) {
			throw new Exception("Syntax errors in EOL module");
		}
		
		InMemoryEmfModel model = new InMemoryEmfModel("Library", resource, LibraryPackage.eINSTANCE);
		module.getContext().getModelRepository().addModel(model);
		
		// Invoke the getAuthorNames() operation
		Book book = library.getBooks().get(0);
		EolOperation getAuthorNames = module.getOperations().getOperation("getAuthorNames");
		EolString names = (EolString) getAuthorNames.execute(book, Collections.EMPTY_LIST, module.getContext());
		System.err.println(names.getValue());
		
		// Invoke the getAuthors() EOL operation
		EolOperation getAuthors = module.getOperations().getOperation("getAuthors");
		EolCollection authors = (EolCollection) getAuthors.execute(book, Collections.EMPTY_LIST, module.getContext());
		
		// Get the results of getAuthors() and unwrap them
		Collection<Author> unwrappedAuthors = (Collection<Author>) authors.getStorage();
		
		for (Author author : unwrappedAuthors) {
			System.err.println(author.getName());
		}
		
		
	}
	
}
