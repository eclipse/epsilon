/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************
 *
 * $Id$
 */
package org.eclipse.epsilon.concordance.db;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

import org.eclipse.emf.common.util.URI;
import org.eclipse.epsilon.concordance.db.common.H2Column;
import org.eclipse.epsilon.concordance.db.common.H2Database;
import org.eclipse.epsilon.concordance.db.common.H2DatabaseAccessException;
import org.eclipse.epsilon.concordance.db.common.H2Row;
import org.eclipse.epsilon.concordance.db.common.H2Table;
import org.eclipse.epsilon.concordance.db.common.H2Value;
import org.eclipse.epsilon.concordance.db.common.H2Column.Type;
import org.eclipse.epsilon.concordance.model.CrossReference;
import org.eclipse.epsilon.concordance.model.IConcordanceModel;
import org.eclipse.epsilon.concordance.model.ConcordanceModelFactory;

public class ConcordanceH2Database {

	private final H2Table models, crossReferences;

	ConcordanceH2Database(H2Table models, H2Table crossReferences) {
		this.models = models;
		this.crossReferences = crossReferences;
	}

	@Override
	public String toString() {
		return "ConcordanceH2Database [models=" + models + ", crossReferences=" + crossReferences + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof ConcordanceH2Database))
			return false;
		
		final ConcordanceH2Database other = (ConcordanceH2Database)obj;
		
		return this.models.equals(other.models) &&
		       this.crossReferences.equals(other.crossReferences);
	}
	
	@Override
	public int hashCode() {
		return models.hashCode() + crossReferences.hashCode();
	}

	
	
	public static ConcordanceH2Database loadFromOrInitialiseIn(H2Database database) throws H2DatabaseAccessException {
		return tablesExist(database) ? getExistingTables(database) : createNewTables(database);	
	}
	
	private static boolean tablesExist(H2Database database) throws H2DatabaseAccessException {
		return database.hasTableNamed("Models") && database.hasTableNamed("CrossReferences");
	}
	
	private static ConcordanceH2Database getExistingTables(H2Database database) throws H2DatabaseAccessException {
		final H2Table models = database.getTableNamed("Models");
		final H2Table xrefs  = database.getTableNamed("CrossReferences");
		
		return new ConcordanceH2Database(models, xrefs);
	}

	private static ConcordanceH2Database createNewTables(H2Database database) throws H2DatabaseAccessException {
		final H2Table models = database.createTable("Models",          new H2Column("URI", Type.STRING), new H2Column("nsUri", Type.STRING));
		final H2Table xrefs  = database.createTable("CrossReferences", Arrays.asList(new H2Column("sourceModel", Type.STRING),
		                                                                             new H2Column("targetModel", Type.STRING),
		                                                                             new H2Column("sourceFragment", Type.STRING),
		                                                                             new H2Column("targetFragment", Type.STRING),
		                                                                             new H2Column("sourceLabel", Type.STRING),
		                                                                             new H2Column("targetLabel", Type.STRING),
		                                                                             new H2Column("label", Type.STRING)));
		
		// Indexes slow down add / insert operations but speed up delete / select operations
		// Because indexing (populating the database) is a slow operation, it seems best not to index
//		models.createIndex("nsUri");
//		xrefs.createIndex("targetModel");
		
		return new ConcordanceH2Database(models, xrefs);
	}
	
	
	public void addModel(IConcordanceModel model) throws H2DatabaseAccessException {
		models.insertRow(new H2Value("URI", model.getUri().toString()), new H2Value("nsUri", model.getNsUri()));

		for (CrossReference crossReference : model.getAllCrossReferences()) {
			crossReferences.insertRow(new H2Value("sourceModel",    crossReference.source.model.getUri().toString()),
					                  new H2Value("targetModel",    crossReference.target.model.getUri().toString()),
					                  new H2Value("sourceFragment", crossReference.source.uriFragment),
					                  new H2Value("targetFragment", crossReference.target.uriFragment),
					                  new H2Value("sourceLabel",    crossReference.source.label),
					                  new H2Value("targetLabel",    crossReference.target.label),
					                  new H2Value("label",          crossReference.label));
		}
	}

	public void deleteModel(IConcordanceModel model) throws H2DatabaseAccessException {
		models.deleteBy(new H2Value("URI", model.getUri().toString()));
		crossReferences.deleteBy(new H2Value("sourceModel", model.getUri().toString()));
	}

	public void moveModel(IConcordanceModel original, IConcordanceModel moved) throws H2DatabaseAccessException {
		models.updateBy(new H2Value("URI", original.getUri().toString()), new H2Value("URI", moved.getUri().toString()));
		crossReferences.updateBy(new H2Value("sourceModel", original.getUri().toString()), new H2Value("sourceModel", moved.getUri().toString()));
		crossReferences.updateBy(new H2Value("targetModel", original.getUri().toString()), new H2Value("targetModel", moved.getUri().toString()));
	}

	public Collection<IConcordanceModel> findAllInstancesOf(String nsUri) throws H2DatabaseAccessException {
		final Collection<IConcordanceModel> instances = new LinkedList<IConcordanceModel>();
		
		for (Object uri : models.findBy(new H2Value("nsUri", nsUri), "URI")) {
			instances.add(ConcordanceModelFactory.createModel(URI.createURI(uri.toString())));
		}
		
		return instances;
	}
	
	public Collection<CrossReference> findAllCrossReferencesTo(IConcordanceModel target) throws H2DatabaseAccessException {
		final Collection<CrossReference> instances = new LinkedList<CrossReference>();
		
		for (H2Row xref : crossReferences.findBy(new H2Value("targetModel", target.getUri()))) {
			final URI sourceElementUri = URI.createURI(xref.getValue("sourceModel").toString()).appendFragment(xref.getValue("sourceFragment").toString());
			final URI targetElementUri = URI.createURI(xref.getValue("targetModel").toString()).appendFragment(xref.getValue("targetFragment").toString());
			
			final String sourceLabel   = xref.getValue("sourceLabel").toString();
			final String targetLabel   = xref.getValue("targetLabel").toString();
			final String label         = xref.getValue("label").toString();
						
			instances.add(new CrossReference(sourceElementUri, sourceLabel, targetElementUri, targetLabel, label));
		}
		
		return instances;
	}

	public Collection<IConcordanceModel> findAllModelsWithCrossReferencesTo(IConcordanceModel target) throws H2DatabaseAccessException {
		final Collection<IConcordanceModel> instances = new LinkedList<IConcordanceModel>();
		
		for (Object uri : crossReferences.findBy(new H2Value("targetModel", target.getUri()), "sourceModel")) {
			instances.add(ConcordanceModelFactory.createModel(URI.createURI(uri.toString())));
		}
		
		return instances;
	}
}
