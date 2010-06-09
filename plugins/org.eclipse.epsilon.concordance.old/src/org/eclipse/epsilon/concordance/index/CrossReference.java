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
package org.eclipse.epsilon.concordance.index;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Index;
import org.apache.lucene.document.Field.Store;

public class CrossReference {
	
	public CrossReference() {}
	
	protected static final String SOURCERESOURCE = "sourceResource";
	protected static final String SOURCEELEMENTID = "sourceElementId";
	protected static final String SOURCELABEL = "sourceLabel";
	protected static final String TARGETRESOURCE = "targetResource";
	protected static final String TARGETELEMENTID = "targetElementId";
	protected static final String TARGETLABEL = "targetLabel";
	protected static final String FEATURE = "feature";
	protected static final String DANGLING = "dangling";
	protected static final String TAG = "tag";
	
	protected String sourceResource;	
	protected String sourceElementId;	
	protected String sourceLabel;	
	protected String targetResource;	
	protected String targetElementId;	
	protected String targetLabel;	
	protected String feature;	
	protected String tag;	
	protected boolean dangling;	
	
	public CrossReference(String sourceResource,String sourceElementId,String sourceLabel,String targetResource,String targetElementId,String targetLabel,String feature, String tag, boolean dangling) {
		super();
		this.sourceResource = sourceResource;
		this.sourceElementId = sourceElementId;
		this.sourceLabel = sourceLabel;
		this.targetResource = targetResource;
		this.targetElementId = targetElementId;
		this.targetLabel = targetLabel;
		this.feature = feature;
		this.tag = tag;
		this.dangling = dangling;
	}
	
	public CrossReference(Document document) {
		
		this.sourceResource = document.get(SOURCERESOURCE);
		this.sourceElementId = document.get(SOURCEELEMENTID);
		this.sourceLabel = document.get(SOURCELABEL);
		this.targetResource = document.get(TARGETRESOURCE);
		this.targetElementId = document.get(TARGETELEMENTID);
		this.targetLabel = document.get(TARGETLABEL);
		this.feature = document.get(FEATURE);
		this.tag = document.get(TAG);
		this.dangling = Boolean.parseBoolean(document.get(DANGLING));
	}
	
	public Document toDocument() {
		Document document = new Document();
		document.add(new Field(SOURCERESOURCE, sourceResource, Store.YES, Index.UN_TOKENIZED));
		document.add(new Field(SOURCEELEMENTID, sourceElementId, Store.YES, Index.UN_TOKENIZED));
		document.add(new Field(SOURCELABEL, sourceLabel, Store.YES, Index.UN_TOKENIZED));
		document.add(new Field(TARGETRESOURCE, targetResource, Store.YES, Index.UN_TOKENIZED));
		document.add(new Field(TARGETELEMENTID, targetElementId, Store.YES, Index.UN_TOKENIZED));
		document.add(new Field(TARGETLABEL, targetLabel, Store.YES, Index.UN_TOKENIZED));
		document.add(new Field(FEATURE, feature, Store.YES, Index.UN_TOKENIZED));
		document.add(new Field(TAG, tag, Store.YES, Index.UN_TOKENIZED));
		document.add(new Field(DANGLING, dangling + "", Store.YES, Index.UN_TOKENIZED));
		return document;		
	}
	
	public String getSourceResource() {
		return sourceResource;
	}

	public void setSourceResource(String sourceResource) {
		this.sourceResource = sourceResource;
	}
	
	public String getSourceElementId() {
		return sourceElementId;
	}

	public void setSourceElementId(String sourceElementId) {
		this.sourceElementId = sourceElementId;
	}
	
	public String getSourceLabel() {
		return sourceLabel;
	}

	public void setSourceLabel(String sourceLabel) {
		this.sourceLabel = sourceLabel;
	}
	
	public String getTargetResource() {
		return targetResource;
	}

	public void setTargetResource(String targetResource) {
		this.targetResource = targetResource;
	}
	
	public String getTargetElementId() {
		return targetElementId;
	}

	public void setTargetElementId(String targetElementId) {
		this.targetElementId = targetElementId;
	}
	
	public String getTargetLabel() {
		return targetLabel;
	}

	public void setTargetLabel(String targetLabel) {
		this.targetLabel = targetLabel;
	}
	
	public String getFeature() {
		return feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
	}
	
	public boolean isDangling() {
		return dangling;
	}

	public void setDangling(boolean dangling) {
		this.dangling = dangling;
	}
	
	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public boolean isExternal() {
		return !this.sourceResource.equals(this.targetResource);
	}
	
}
