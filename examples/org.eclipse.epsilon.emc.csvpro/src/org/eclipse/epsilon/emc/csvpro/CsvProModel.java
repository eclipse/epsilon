package org.eclipse.epsilon.emc.csvpro;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.epsilon.common.util.FileUtil;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolEnumerationValueNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.exceptions.models.EolNotInstantiableModelElementTypeException;
import org.eclipse.epsilon.eol.execute.introspection.AbstractPropertyGetter;
import org.eclipse.epsilon.eol.execute.introspection.AbstractPropertySetter;
import org.eclipse.epsilon.eol.execute.introspection.IPropertyGetter;
import org.eclipse.epsilon.eol.execute.introspection.IPropertySetter;
import org.eclipse.epsilon.eol.models.CachedModel;
import org.eclipse.epsilon.eol.models.IRelativePathResolver;

public class CsvProModel extends CachedModel<Integer> {
	
	private class CsvPropertyGetter extends AbstractPropertyGetter {

		@Override
		public Object invoke(Object object, String property) throws EolRuntimeException {
			assert object instanceof Integer;
			return data.get(property).get((int) object);
		}
	}
	private class CsvPropertySetter extends AbstractPropertySetter {

		@Override
		public void invoke(Object value) throws EolRuntimeException {
			data.get(property).set((int) object, value.toString());
		}		
	}

	public static final String PROPERTY_FILE = "file";

	public static final String PROPERTY_FIELD_SEPARATOR = "separator";

	public static final String PROPERTY_HAS_KNOWN_HEADERS = "useheaders";

	public static final String PROPERTY_HAS_VARARGS_HEADERS = "vararg";
	
	private Map<String, List<String>> data;
	
	private List<Integer> rows;		// Keep track of rows add/delete
		
	private CsvPropertyGetter pg;

	private CsvPropertySetter ps;

	private String file;

	private String fieldSeparator;

	private boolean knownHeaders;

	private boolean varargsHeaders;

	public CsvProModel() {
		super();
		data = new HashMap<String, List<String>>();
		rows = new ArrayList<Integer>();
		pg = new CsvPropertyGetter();
		ps = new CsvPropertySetter();
	}

	@Override
	protected Collection<? extends Integer> allContentsFromModel() {
		return rows;
	}
	
	@Override
	protected Integer createInstanceInModel(String type)
			throws EolModelElementTypeNotFoundException, EolNotInstantiableModelElementTypeException {
		throw new UnsupportedOperationException("Not Implemented");
	}

	@Override
	protected boolean deleteElementInModel(Object instance) throws EolRuntimeException {
		throw new UnsupportedOperationException("Not Implemented");
	}
	
	@Override
	protected void disposeModel() {
		
	}
	
	@Override
	protected Collection<Integer> getAllOfKindFromModel(String kind)
			throws EolModelElementTypeNotFoundException {
		return getAllOfTypeFromModel(kind);
	}

	@Override
	protected Collection<Integer> getAllOfTypeFromModel(String type)
			throws EolModelElementTypeNotFoundException {
		if (!"Row".equals(type)) {
			throw new EolModelElementTypeNotFoundException(this.name, type);
		}
		return allContents();
	}

	@Override
	protected Collection<String> getAllTypeNamesOf(Object instance) {
		if (owns(instance)) {
			List<String> result = new ArrayList<String>();
			result.add("Row");
			return result;
		}
		return Collections.emptyList();
	}

	@Override
	protected Object getCacheKeyForType(String type) throws EolModelElementTypeNotFoundException {
		return type;
	}

	@Override
	public Object getElementById(String id) {
		throw new UnsupportedOperationException("Not Implemented");
	}

	@Override
	public String getElementId(Object instance) {
		throw new UnsupportedOperationException("Not Implemented");
	}

	@Override
	public Object getEnumerationValue(String enumeration, String label) throws EolEnumerationValueNotFoundException {
		throw new UnsupportedOperationException("Not Implemented");
	}

	@Override
	public IPropertyGetter getPropertyGetter() {
		return pg;
	}

	@Override
	public IPropertySetter getPropertySetter() {
		return ps;
	}

	@Override
	public String getTypeNameOf(Object instance) {
		if (owns(instance)) {
			return "Row";
		}
		return null;
	}

	@Override
	public boolean hasType(String type) {
		return "Row".equals(type);
	}

	@Override
	public boolean isInstantiable(String type) {
		throw new UnsupportedOperationException("Not Implemented");
	}
	
	@Override
	public void load(StringProperties properties, IRelativePathResolver resolver) throws EolModelLoadingException {
		super.load(properties, resolver);
		
		this.file = resolver.resolve(properties.getProperty(PROPERTY_FILE));
		this.fieldSeparator = properties.getProperty(PROPERTY_FIELD_SEPARATOR);
		this.knownHeaders = properties.getBooleanProperty(PROPERTY_HAS_KNOWN_HEADERS, true);
		this.varargsHeaders = properties.getBooleanProperty(PROPERTY_HAS_VARARGS_HEADERS, false);	
		load();
	}

	@Override
	protected void loadModel() throws EolModelLoadingException {
		LinkedList<String> lines = null;
		try {
			lines = new LinkedList<String>(FileUtil.getFileLineContents(new File(file)));
		} catch (Exception ex) {
			throw new EolModelLoadingException(ex, this);
		} finally {
			if(this.knownHeaders) {
				List<String> keys = Arrays.asList(lines.get(0).split(this.fieldSeparator));
				for (String k : keys) {
					data.put(k, new ArrayList<String>());
				}
				List<String> values;
				for (int i=1; i < lines.size(); i++) {
					int index = i-1;
					rows.add(index);
					values = Arrays.asList(lines.get(i).split(this.fieldSeparator));
					if (keys.size() != values.size()) {
						Exception ex = new Exception("Line " + (i+1) + " contains different number of elements than the header");
						throw new EolModelLoadingException(ex, this);
					}
					for (int f=0; f<keys.size(); f++) {
						List<String> datavals = data.get(keys.get(f)); 
						datavals.add(values.get(f));
					}
				}
			} else {
				Exception ex = new Exception("CSV Pro models need headers");
				throw new EolModelLoadingException(ex, this);
			}
		}
	}

	@Override
	public boolean owns(Object instance) {
		return rows.contains(instance); 
	}

	@Override
	public void setElementId(Object instance, String newId) {
		throw new UnsupportedOperationException("Not Implemented");
	}

	@Override
	public boolean store() {
		throw new UnsupportedOperationException("Not Implemented");
	}

	@Override
	public boolean store(String location) {
		throw new UnsupportedOperationException("Not Implemented");
	}
	
	
}
