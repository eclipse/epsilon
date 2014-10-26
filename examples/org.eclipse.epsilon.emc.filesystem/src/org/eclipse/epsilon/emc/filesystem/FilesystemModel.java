package org.eclipse.epsilon.emc.filesystem;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolEnumerationValueNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.exceptions.models.EolNotInstantiableModelElementTypeException;
import org.eclipse.epsilon.eol.execute.introspection.IPropertyGetter;
import org.eclipse.epsilon.eol.execute.introspection.IPropertySetter;
import org.eclipse.epsilon.eol.models.Model;


public class FilesystemModel extends Model {
	
	protected List<File> files = null;
	
	public FilesystemModel(File root) {
		files = getDescendants(root);
	}
	
	@Override
	public boolean hasType(String type) {
		return "File".equals(type);
	}
	
	@Override
	public Collection<?> getAllOfType(String type)
			throws EolModelElementTypeNotFoundException {
		return files;
	}
	
	@Override
	public Collection<?> getAllOfKind(String type)
			throws EolModelElementTypeNotFoundException {
		return getAllOfType(type);
	}
	
	@Override
	public boolean owns(Object instance) {
		return files.contains(instance);
	}
	
	@Override
	public IPropertyGetter getPropertyGetter() {
		return new FilesystemModelPropertyGetter();
	}
	
	@Override
	public IPropertySetter getPropertySetter() {
		return new FilesystemModelPropertySetter();
	}
	
	//TODO: Implement
	
	@Override
	public void load() throws EolModelLoadingException {
		
	}

	@Override
	public Object getEnumerationValue(String enumeration, String label)
			throws EolEnumerationValueNotFoundException {
		return null;
	}

	@Override
	public Collection<?> allContents() {
		return null;
	}

	

	@Override
	public String getTypeNameOf(Object instance) {
		return null;
	}

	@Override
	public Object createInstance(String type)
			throws EolModelElementTypeNotFoundException,
			EolNotInstantiableModelElementTypeException {
		return null;
	}

	@Override
	public Object getElementById(String id) {
		return null;
	}

	@Override
	public String getElementId(Object instance) {
		return null;
	}

	@Override
	public void setElementId(Object instance, String newId) {
		
	}

	@Override
	public void deleteElement(Object instance) throws EolRuntimeException {
		
	}

	@Override
	public boolean isInstantiable(String type) {
		return false;
	}

	@Override
	public boolean store(String location) {
		return false;
	}

	@Override
	public boolean store() {
		return false;
	}
	
	protected List<File> getDescendants(File root) {
		ArrayList<File> descendants = new ArrayList<File>();
		descendants.add(root);
		if (root.isDirectory()) {
			for (File child : root.listFiles()) {
				descendants.addAll(getDescendants(child));
			}
		}
		return descendants;
	}
	
}