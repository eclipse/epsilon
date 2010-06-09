/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
******************************************************************************/

package org.eclipse.epsilon.concordance.util;

import java.util.Iterator;

import org.apache.lucene.analysis.SimpleAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Index;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.index.IndexModifier;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.Hit;
import org.apache.lucene.search.Hits;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.WildcardQuery;
import org.eclipse.epsilon.concordance.index.CrossReference;

public class LuceneWorkbench {
	
	protected final String indexDirectory = "c:\\lucene_test";
	protected final String SOURCE_RESOURCE = "sourceResource";
	protected final String SOURCE_ELEMENT_ID = "sourcElementId";
	protected final String TARGET_RESOURCE = "targetResource";
	protected final String TARGET_ELEMENT_ID = "targetElementId";
	protected final String FEATURE = "feature";
	
	
	public static void main(String[] args) throws Exception{
		new LuceneWorkbench().work();
	}
	
	public void work() throws Exception {
		
		createIndex();
		//updateIndex();
		searchIndex();
		
	}
	
	
	public void searchIndex() throws Exception {
		IndexSearcher searcher = new IndexSearcher(indexDirectory);
		//Hits hits = searcher.search(new TermQuery(new Term(SOURCE_RESOURCE, "a.model")));
		Hits hits = searcher.search(new WildcardQuery(new Term(SOURCE_RESOURCE, ".*")));
		
		Iterator<Object> it = hits.iterator();
		
		while (it.hasNext()) {
			Hit hit = (Hit) it.next();
			CrossReference entry = new CrossReference(hit.getDocument());
			System.err.println(entry);
		}
		
	}
	
	public void createIndex() throws Exception {
		
		IndexWriter writer = new IndexWriter(indexDirectory,new SimpleAnalyzer(), true);
		
		writer.addDocument(createIndexEntry("a.model", "a1", "b.model", "b1", "bs"));
		writer.addDocument(createIndexEntry("a.model", "a2", "b.model", "b2", "bs"));
		
		writer.close();
	}
	
	public void updateIndex() throws Exception {
		IndexModifier modifier = new IndexModifier(indexDirectory, new SimpleAnalyzer(), false);
		//modifier.deleteDocuments(new Term(SOURCE_RESOURCE, "a.model"));
		//modifier.addDocument(createIndexEntry("a.model", "a1", "b.model", "b1", "bs"));
		modifier.close();
	}
	
	public Document createIndexEntry(String sourceResource, String sourceElementId, String targetResource, String targetElementId, String feature) {
		return null;//return new CrossReference(sourceResource, sourceElementId, targetResource, targetElementId, feature, "1").toDocument();
	}
}
 