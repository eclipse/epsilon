package org.eclipse.epsilon.concordance.index;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.lucene.analysis.SimpleAnalyzer;
import org.apache.lucene.index.IndexModifier;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.Hit;
import org.apache.lucene.search.Hits;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.WildcardQuery;

public class CrossReferenceIndex {
	
	protected String indexDirectory = "c:\\lucene_test";
	protected IndexModifier indexModifier;

	public CrossReferenceIndex(String indexDirectory) {
		
		this.indexDirectory = indexDirectory;
		
		try {
			File directory = new File(indexDirectory);
			if (directory.exists()) {
				try {
					indexModifier = new IndexModifier(directory, new SimpleAnalyzer(), false);
				}
				catch (Exception ex) {
					indexModifier = new IndexModifier(directory, new SimpleAnalyzer(), true);
				}
			}
			else {
				indexModifier = new IndexModifier(directory, new SimpleAnalyzer(), true);
			}
			indexModifier.setMaxBufferedDocs(100);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public String getIndexDirectory() {
		return indexDirectory;
	}
	
	public void addAll(Collection<CrossReference> col) {
		for (CrossReference item : col) {
			add(item);
		}
	}
	
	public void add(CrossReference crossReference) {
		try {
			indexModifier.addDocument(crossReference.toDocument());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void add(String sourceResource, String sourceElementId, String sourceLabel, String targetResource, String targetElementId, String targetLabel, String feature, String tag, boolean dangling) {
		try {
			CrossReference crossReference = new CrossReference(
				sourceResource,sourceElementId,sourceLabel,targetResource,targetElementId,targetLabel,feature,tag,dangling);
			indexModifier.addDocument(crossReference.toDocument());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Collection<CrossReference> getAll() {
		ArrayList<CrossReference> results = new ArrayList<CrossReference>();
		try {
			IndexSearcher searcher = new IndexSearcher(indexDirectory);
			Hits hits = searcher.search(new WildcardQuery(new Term(CrossReference.SOURCERESOURCE, "*")));
			Iterator<Object> it = hits.iterator();
			while (it.hasNext()) {
				Hit hit = (Hit) it.next();
				results.add(new CrossReference(hit.getDocument()));
			}
			searcher.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return results;
	}
	
	public void commitChanges() {
		//new Exception().printStackTrace();
		
		try {
			indexModifier.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Shuts down the index
	 */
	public void shutdown() {
		try {
			indexModifier.close();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
		
	/**
	 * Removes all entries from the index
	 */
	public void clean() {
		try {
			indexModifier.close();
			indexModifier = new IndexModifier(indexDirectory, new SimpleAnalyzer(), true);
			indexModifier.flush();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	protected Collection<CrossReference> searchByField(String query, String field) {
		Collection<CrossReference> results = new ArrayList<CrossReference>();
		try {
			IndexSearcher indexSearcher = new IndexSearcher(indexDirectory);
			Hits hits = indexSearcher.search(new TermQuery(new Term(field, query)));
			Iterator<Object> it = hits.iterator();
			while (it.hasNext()) {
				Hit hit = (Hit) it.next();
				results.add(new CrossReference(hit.getDocument()));
			}
			indexSearcher.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return results;
	}
	
	/**
	 * Searches the index to find instances of CrossReference
	 * with sourceResource = {@code query}
	 * @param sourceResource
	 */
	
	public Collection<CrossReference> searchBySourceResource(String query) {
		return searchByField(query, CrossReference.SOURCERESOURCE);
	}
	
	/**
	 * Searches the index to find instances of CrossReference
	 * with sourceElementId = {@code query}
	 * @param sourceElementId
	 */
	
	public Collection<CrossReference> searchBySourceElementId(String query) {
		return searchByField(query, CrossReference.SOURCEELEMENTID);
	}
	
	/**
	 * Searches the index to find instances of CrossReference
	 * with sourceLabel = {@code query}
	 * @param sourceLabel
	 */
	
	public Collection<CrossReference> searchBySourceLabel(String query) {
		return searchByField(query, CrossReference.SOURCELABEL);
	}
	
	/**
	 * Searches the index to find instances of CrossReference
	 * with targetResource = {@code query}
	 * @param targetResource
	 */
	
	public Collection<CrossReference> searchByTargetResource(String query) {
		return searchByField(query, CrossReference.TARGETRESOURCE);
	}
	
	/**
	 * Searches the index to find instances of CrossReference
	 * with targetElementId = {@code query}
	 * @param targetElementId
	 */
	
	public Collection<CrossReference> searchByTargetElementId(String query) {
		return searchByField(query, CrossReference.TARGETELEMENTID);
	}
	
	/**
	 * Searches the index to find instances of CrossReference
	 * with targetLabel = {@code query}
	 * @param targetLabel
	 */
	
	public Collection<CrossReference> searchByTargetLabel(String query) {
		return searchByField(query, CrossReference.TARGETLABEL);
	}
	
	/**
	 * Searches the index to find instances of CrossReference
	 * with feature = {@code query}
	 * @param feature
	 */
	
	public Collection<CrossReference> searchByFeature(String query) {
		return searchByField(query, CrossReference.FEATURE);
	}
	
	/**
	 * Searches the index to find instances of CrossReference
	 * with valid = {@code query}
	 * @param valid
	 */
	
	public Collection<CrossReference> searchByDangling(String query) {
		return searchByField(query, CrossReference.DANGLING);
	}
	
	
	/**
	 * Deletes all entries with the specific {@code sourceResource}
	 * @param sourceResource
	 */
	public void deleteBySourceResource(String sourceResource) {
		try {
			indexModifier.deleteDocuments(new Term(CrossReference.SOURCERESOURCE, sourceResource));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Deletes all entries with the specific {@code sourceElementId}
	 * @param sourceElementId
	 */
	public void deleteBySourceElementId(String sourceElementId) {
		try {
			indexModifier.deleteDocuments(new Term(CrossReference.SOURCEELEMENTID, sourceElementId));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Deletes all entries with the specific {@code sourceLabel}
	 * @param sourceLabel
	 */
	public void deleteBySourceLabel(String sourceLabel) {
		try {
			indexModifier.deleteDocuments(new Term(CrossReference.SOURCELABEL, sourceLabel));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Deletes all entries with the specific {@code targetResource}
	 * @param targetResource
	 */
	public void deleteByTargetResource(String targetResource) {
		try {
			indexModifier.deleteDocuments(new Term(CrossReference.TARGETRESOURCE, targetResource));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Deletes all entries with the specific {@code targetElementId}
	 * @param targetElementId
	 */
	public void deleteByTargetElementId(String targetElementId) {
		try {
			indexModifier.deleteDocuments(new Term(CrossReference.TARGETELEMENTID, targetElementId));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Deletes all entries with the specific {@code targetLabel}
	 * @param targetLabel
	 */
	public void deleteByTargetLabel(String targetLabel) {
		try {
			indexModifier.deleteDocuments(new Term(CrossReference.TARGETLABEL, targetLabel));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Deletes all entries with the specific {@code feature}
	 * @param feature
	 */
	public void deleteByFeature(String feature) {
		try {
			indexModifier.deleteDocuments(new Term(CrossReference.FEATURE, feature));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Deletes all entries with the specific {@code valid}
	 * @param dangling
	 */
	public void deleteByDangling(boolean dangling) {
		try {
			indexModifier.deleteDocuments(new Term(CrossReference.DANGLING, dangling + ""));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
 