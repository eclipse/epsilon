/*******************************************************************************
 * Copyright (c) 2016 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Saheed Popoola - initial API and implementation
 *     Horacio Hoyos - aditional functionality
 ******************************************************************************/
package org.eclipse.epsilon.emg;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.util.URI;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.emg.execute.operations.contributors.EmgOperationContributor;
import org.eclipse.epsilon.eol.dom.Annotation;
import org.eclipse.epsilon.eol.dom.AnnotationBlock;
import org.eclipse.epsilon.eol.dom.Operation;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eol.models.IRelativePathResolver;
import org.eclipse.epsilon.eol.models.Model;
import org.eclipse.epsilon.eol.types.EolModelElementType;
import org.eclipse.epsilon.epl.EplModule;
import org.eclipse.epsilon.epl.execute.PatternMatchModel;

/**
 * The Emg Module is responsible for execution emg scripts. Emg scripts are used
 * to generate models.
 */
public class EmgModule extends EplModule {

	/**
	 * Assign the created elements to a list
	 */
	private static final String LIST_ID_ANNOTATION = "list";

	/**
	 * How many instances must be created
	 */
	private static final String NUMBER_OF_INSTANCES_ANNOTATION = "instances";

	/**
	 * Parameters to pass for instance craetion
	 */
	private static final String PARAMETERS_ANNOTATION = "parameters";

	/**
	 * The name of the create operation
	 */
	private static final String CREATE_OPERATION = "create";

	/** The random generator */
	private EmgOperationContributor randomGenerator;

	/** The seed used for random generation. */
	private long seed;

	private boolean useSeed;

	/**
	 * A maps to keep track of objects created by create operations that us
	 * the @name annotation. The key of the map is the value of the annotation.
	 */
	private Map<String, List<Object>> namedCreatedObjects = new HashMap<>(); //

	/**
	 * @param seed the seed to set
	 */
	public void setSeed(long seed) {
		this.seed = seed;
	}

	/**
	 * @param useSeed the useSeed to set
	 */
	public void setUseSeed(boolean useSeed) {
		this.useSeed = useSeed;
	}

	/**
	 * @return the namedCreatedObjects
	 */
	public Map<String, List<Object>> getNamedCreatedObjects() {
		return namedCreatedObjects;
	}

	/**
	 * Initialise the contributors
	 */
	private void preload() {
		context.setModule(this);
		if (useSeed) {
			randomGenerator = new EmgOperationContributor(this, seed);
		}
		else {
			randomGenerator = new EmgOperationContributor(this);
		}
		context.getOperationContributorRegistry().add(randomGenerator);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.epsilon.epl.EplModule#getMainRule()
	 */
	@Override
	public String getMainRule() {
		return "eplModule";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.epsilon.epl.EplModule#getImportConfiguration()
	 */
	@Override
	public HashMap<String, Class<?>> getImportConfiguration() {
		HashMap<String, Class<?>> importConfiguration = super.getImportConfiguration();
		importConfiguration.put("emg", EmgModule.class);
		return importConfiguration;
	}

	@Override
	protected void prepareContext() throws EolRuntimeException {
		super.prepareContext();
		preload();
		executeCreateOperations();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.epsilon.epl.EplModule#execute()
	 */
	@Override
	public Object processRules() throws EolRuntimeException {
		EmgPatternMatcher patternMatcher = new EmgPatternMatcher(randomGenerator);
		PatternMatchModel matchModel = null;
		try {
			int loops = 1;
			matchModel = patternMatcher.match(this);
			if (repeatWhileMatchesFound) {

				while (!matchModel.allContents().isEmpty()) {
					if (maxLoops != INFINITE) {
						if (loops == maxLoops)
							break;
					}
					matchModel = patternMatcher.match(this);
					loops++;
				}
			}
		}
		catch (Exception ex) {
			EolRuntimeException.propagate(ex);
		}
		context.getModelRepository().getModels().get(0).store();
		// Is the total size more important than the matches?
		return context.getModelRepository().getModels().get(0).allContents().size();
	}

	/**
	 * Execute the create operations in the EMG script.
	 *
	 * @throws EolModelElementTypeNotFoundException the eol model element type not
	 *                                              found exception
	 * @throws EolRuntimeException                  If the type to be instantiated
	 *                                              can't be found or any of the
	 *                                              random functions fails.
	 */
	protected void executeCreateOperations() throws EolRuntimeException {

		AnnotationBlock annotationBlock;
		String annotationName, instancesListName;
		String parameters = null;
		for (Operation operation : getOperations()) {
			if (operation.getName().equals(CREATE_OPERATION)) {
				// get the class context
				EolModelElementType instancesType = (EolModelElementType) operation.getContextType(context);
				if (!instancesType.isInstantiable()) {
					continue;
				}
				int instances = 1;
				instancesListName = "";
				// guard="";
				// get the annotations
				annotationBlock = operation.getAnnotationBlock();
				if (!(annotationBlock == null)) {
					List<Object> annotationValues;
					for (Annotation annotation : annotationBlock.getAnnotations()) {
						if (!(annotation.hasValue()))
							continue;
						annotationName = annotation.getName();
						annotationValues = operation.getAnnotationsValues(annotationName, context);
						// search for instances to be created
						if (annotationName.equals(NUMBER_OF_INSTANCES_ANNOTATION)) {
							if (!annotationValues.isEmpty()) {
								Object val = annotationValues.get(0);
								if (val instanceof List) {
									List<?> valC = (List<?>) val;
									if (valC.size() > 1)
										instances = randomGenerator.nextInteger(getInt(valC.get(0)),
											getInt(valC.get(1)));
									else
										instances = getInt(valC.get(0));
								}
								else
									instances = getInt(annotationValues.get(0));
							}
							if (instances < 1)
								instances = 1;
						}
						else if (annotationName.equals(LIST_ID_ANNOTATION)) {
							if (!annotationValues.isEmpty()) {
								instancesListName = (String) annotationValues.get(0);
							}
						}
						// Parameters for element initialization
						else if (annotationName.equals(PARAMETERS_ANNOTATION)) {
							if (!annotationValues.isEmpty()) {
								// parameters = (List<Object>) annotationValues.get(0);
								parameters = annotationName;
							}
						}
					} // end for loop annotations
				}
				// Create the instances
				createInstances(instancesListName, operation, instancesType, instances, parameters);
				parameters = null;
			}

		} // end for loop (operations)
	}

	/**
	 * @param instancesListName
	 * @param operation
	 * @param instancesType
	 * @param instances
	 * @param paramAnotation
	 * @return
	 * @throws EolRuntimeException
	 */
	@SuppressWarnings("unchecked")
	private void createInstances(String instancesListName, Operation operation, EolModelElementType instancesType,
		int instances, String paramAnotation) throws EolRuntimeException {
		ArrayList<Object> classes = new ArrayList<>();
		// Add the list to the context first so previous instances can be used for
		// attribute assignment
		if (!instancesListName.isEmpty()) {
			if (namedCreatedObjects.containsKey(instancesListName)) {
				namedCreatedObjects.get(instancesListName).addAll(classes);
			}
			else
				namedCreatedObjects.put(instancesListName, classes);
		}
		for (int i = 0; i < instances; i++) {
			List<Object> paramObj = null;
			if (paramAnotation != null) {
				List<Object> annotationValues = operation.getAnnotationsValues(paramAnotation, context);
				paramObj = (List<Object>) annotationValues.get(0);
				assert paramObj instanceof List;
			}
			Object modelObject = instancesType.createInstance(paramObj);
			// Execute statements in the operation to initialise object attributes
			operation.execute(modelObject, null, context);
			classes.add(modelObject);
		}
	}

	/**
	 * Creates the emf model.
	 *
	 * @param name            the name
	 * @param model           the model
	 * @param metamodel       the metamodel
	 * @param readOnLoad      the read on load
	 * @param storeOnDisposal the store on disposal
	 * @return the emf model
	 * @throws EolModelLoadingException the eol model loading exception
	 * @throws URISyntaxException       the URI syntax exception
	 */
	@Deprecated
	protected static EmfModel createEmfModel(String name, String model, String metamodel, boolean readOnLoad,
		boolean storeOnDisposal) throws EolModelLoadingException, URISyntaxException {
		EmfModel emfModel = new EmfModel();
		StringProperties properties = new StringProperties();
		properties.put(Model.PROPERTY_NAME, name);
		properties.put(EmfModel.PROPERTY_FILE_BASED_METAMODEL_URI, metamodel);
		properties.put(EmfModel.PROPERTY_MODEL_URI, model);
		properties.put(Model.PROPERTY_READONLOAD, false + "");
		properties.put(Model.PROPERTY_STOREONDISPOSAL, storeOnDisposal + "");
		emfModel.load(properties, (IRelativePathResolver) null);
		return emfModel;
	}

	/**
	 * Gets the model.
	 *
	 * @return the model
	 * @deprecated EMG can use any type of model
	 */
	@Deprecated
	protected EmfModel getModel() {
		for (IModel mod : context.getModelRepository().getModels()) {
			if (mod instanceof EmfModel) {
				return (EmfModel) mod;
			}
		}
		try {
			throw new Exception();
		}
		catch (Exception e) {
			System.out.println("No EmfModel found");
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Gets the int.
	 * 
	 * @param object the object
	 * @return the int
	 */
	protected int getInt(Object object) {
		if (object instanceof Integer)
			return (Integer) object;
		else
			return Integer.parseInt((String) object);
	}

	/**
	 * Gets the file path.
	 * 
	 * @param file the file
	 * @return the file path
	 */
	protected String getFilePath(String file) {
		URI ecoreUri = URI.createURI(file);
		URI filePath = ecoreUri.trimFileExtension();
		return filePath.toString();
	}

	/**
	 * Gets the new file path.
	 *
	 * @param file   the file
	 * @param output the output
	 * @return the new file path
	 */
	protected String getNewFilePath(String file, String output) {
		URI ecoreUri = URI.createURI(file);
		if (!output.contains("."))
			output = output + ecoreUri.fileExtension();
		URI filePath = ecoreUri.trimSegments(1);
		filePath = filePath.appendSegment(output);
		return filePath.toString();
	}
}