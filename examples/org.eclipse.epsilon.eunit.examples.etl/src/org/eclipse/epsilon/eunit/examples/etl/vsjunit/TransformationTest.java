package org.eclipse.epsilon.eunit.examples.etl.vsjunit;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import java.net.URISyntaxException;
import java.util.HashMap;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.service.DiffService;
import org.eclipse.emf.compare.match.MatchOptions;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.compare.match.service.MatchService;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.models.ModelRepository;
import org.eclipse.epsilon.etl.EtlModule;
import org.eclipse.epsilon.eunit.dt.cmp.emf.EMFModelComparator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Shows what would be required to test a model-to-model transformation using
 * plain JUnit.
 * 
 * @author Antonio Garcia-Dominguez
 */
public class TransformationTest {

	private static final String RESOURCE_PATH_PREFIX = "/";
	private static final String GRAPH_EXPECTED_MODEL_PATH = "models/graph-expected.model";
	private static final String TREE_MODEL_PATH = "models/tree.model";
	private static final String GRAPH_METAMODEL_PATH = "metamodels/graph.ecore";
	private static final String TREE_METAMODEL_PATH = "metamodels/tree.ecore";

	private EmfModel originalTree;
	private EmfModel expectedGraph;
	private EmfModel resultGraph;
	private EtlModule etlModule;

	@Before
	public void setup() throws Exception {
		loadModels();
		loadEtl();
	}

	@After
	public void disposeModels() {
		originalTree.dispose();
		expectedGraph.dispose();
		resultGraph.dispose();
	}

	@Test
	public void etlProducesExpectedResult() throws Exception {
		etlModule.execute();

		// Using EMF Compare directly
		final HashMap<String, Object> options
			= new HashMap<String, Object>();
		options.put(MatchOptions.OPTION_IGNORE_XMI_ID, true);
		final MatchModel match = MatchService.doResourceMatch(
			expectedGraph.getResource(),
			resultGraph.getResource(),
			options);
		final DiffModel diff = DiffService.doDiff(match);
		assertThat(diff.getDifferences().isEmpty(), is(true));

		// Using generic comparison through EMC
		assertThat(
			new EMFModelComparator().compare(expectedGraph, resultGraph),
			is(nullValue()));
	}

	private void loadEtl() throws Exception {
		etlModule = new EtlModule();
		etlModule.parse(getResourceURI("etl/Tree2Graph.etl"));

		// Make the source and destination models available to the transformation
		final ModelRepository etlModelRepo = etlModule.getContext().getModelRepository();
		etlModelRepo.addModel(originalTree);
		etlModelRepo.addModel(resultGraph);
	}

	private void loadModels() throws EolModelLoadingException {
		originalTree = loadModel("Tree", TREE_METAMODEL_PATH, TREE_MODEL_PATH);
		expectedGraph = loadModel("GraphExpected", GRAPH_METAMODEL_PATH, GRAPH_EXPECTED_MODEL_PATH);
		resultGraph = loadModel("Graph", GRAPH_METAMODEL_PATH, GRAPH_EXPECTED_MODEL_PATH, false);
	}

	private EmfModel loadModel(String modelName, String metamodelPath, String modelPath)
			throws EolModelLoadingException {
		return loadModel(modelName, metamodelPath, modelPath, true);
	}

	private EmfModel loadModel(String modelName, String metamodelPath,
			String modelPath, boolean readOnLoad) throws EolModelLoadingException {
		EmfModel model = new EmfModel();
		model.setName(modelName);
		model.setMetamodelFileUri(getResourceEmfURI(metamodelPath));
		model.setMetamodelFileBased(true);
		model.setModelFileUri(getResourceEmfURI(modelPath));
		model.setReadOnLoad(readOnLoad);
		model.setStoredOnDisposal(false);
		model.load();
		return model;
	}

	private java.net.URI getResourceURI(String resourcePath)
			throws URISyntaxException {
		return getClass().getResource(RESOURCE_PATH_PREFIX + resourcePath).toURI();
	}

	private URI getResourceEmfURI(String resourcePath) {
		return URI.createURI(getClass().getResource(
				RESOURCE_PATH_PREFIX + resourcePath).toExternalForm());
	}

}
