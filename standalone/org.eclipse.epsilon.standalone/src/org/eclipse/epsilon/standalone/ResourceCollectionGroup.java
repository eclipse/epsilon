/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.standalone;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.tools.ant.types.DataType;
import org.apache.tools.ant.types.FileSet;
import org.apache.tools.ant.types.Resource;
import org.apache.tools.ant.types.ResourceCollection;

public class ResourceCollectionGroup extends DataType implements ResourceCollection {
	
	protected List<ResourceCollection> resourceCollections = new ArrayList<>();
	
	@Override
	public Iterator<Resource> iterator() {
		if (isReference()) {
			return ((ResourceCollectionGroup) getCheckedRef(getProject())).iterator();
		}
		
		ArrayList<Resource> resources = new ArrayList<>();
		for (ResourceCollection resourceCollection : resourceCollections) {
			for (Resource res : resourceCollection) {
				resources.add(res);
			}
		}
		
		return resources.iterator();
	}

	public FileSet createFileSet() {
		FileSet fileSet = new FileSet();
		resourceCollections.add(fileSet);
		return fileSet;
	}
	
	public ResourceCollectionGroup createGroup() {
		ResourceCollectionGroup group = new ResourceCollectionGroup();
		resourceCollections.add(group);
		return group;
	}
	
	@Override
	public int size() {
		return resourceCollections.size();
	}

	@Override
	public boolean isFilesystemOnly() {
		return false;
	}
}
