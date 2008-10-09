/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl.merge.partition;

import org.eclipse.epsilon.egl.merge.partition.CommentBlockPartitioner;
import org.junit.Test;

public class TestHTMLPartitioner extends TestCommentBlockPartitioner {

	public TestHTMLPartitioner() {
		super(new CommentBlockPartitioner("<!--", "-->"));
	}
	
	@Test @Override
	public void testOutputToString() {
		super.testOutputToString();
	}
	
	@Test @Override
	public void testEmptyOutputToString() {
		super.testEmptyOutputToString();
	}
	
	@Test @Override
	public void testPartitionSingleRegion() {
		super.testPartitionSingleRegion();
	}
	
	@Test @Override
	public void testPartitionSingleProtectedRegion() {
		super.testPartitionSingleProtectedRegion();
	}
	
	@Test @Override
	public void testPartitionSingleProtectedRegionOff() {
		super.testPartitionSingleProtectedRegionOff();
	}
	
	@Test @Override
	public void testPartitionSingleProtectedRegionEmpty() {
		super.testPartitionSingleProtectedRegionEmpty();
	}
	
	@Test @Override
	public void testPartitionSingleProtectedRegionWhiteSpace() {
		super.testPartitionSingleProtectedRegionWhiteSpace();
	}
	
	@Test @Override
	public void testPartitionRegionThenProtectedRegion() {
		super.testPartitionRegionThenProtectedRegion();
	}
	
	@Test @Override
	public void testPartitionProtectedRegionThenRegion() {
		super.testPartitionProtectedRegionThenRegion();
	}
	
	@Test @Override
	public void testPartitionTwoProtectedRegions() {
		super.testPartitionTwoProtectedRegions();
	}
	
	@Test @Override
	public void testPartitionComplex() {
		super.testPartitionComplex();
	}

}