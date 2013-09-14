package org.eclipse.epsilon.standalone;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.tools.ant.types.DataType;
import org.apache.tools.ant.types.FileSet;
import org.apache.tools.ant.types.ResourceCollection;

public class ResourceCollectionGroup extends DataType implements ResourceCollection {
	
	protected List<ResourceCollection> resourceCollections = new ArrayList<ResourceCollection>();
	
	public Iterator<?> iterator() {
		if (isReference()) {
			return ((ResourceCollectionGroup) getCheckedRef(getProject())).iterator();
		}
		
		ArrayList<Object> resources = new ArrayList<Object>();
		for (ResourceCollection resourceCollection : resourceCollections) {
			Iterator<?> iterator = resourceCollection.iterator();
			while (iterator.hasNext()) {
				resources.add(iterator.next());
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
		return 0;
	}

	@Override
	public boolean isFilesystemOnly() {
		return false;
	}
	
	
}
