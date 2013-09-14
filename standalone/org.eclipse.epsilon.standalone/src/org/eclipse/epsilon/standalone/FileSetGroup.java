package org.eclipse.epsilon.standalone;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.tools.ant.types.DataType;
import org.apache.tools.ant.types.FileSet;
import org.apache.tools.ant.types.ResourceCollection;

public class FileSetGroup extends DataType implements ResourceCollection {
	
	protected List<FileSet> fileSets = new ArrayList<FileSet>();
	
	public Iterator<?> iterator() {
		if (isReference()) {
			return ((FileSetGroup) getCheckedRef(getProject())).iterator();
		}
		
		ArrayList<Object> resources = new ArrayList<Object>();
		for (FileSet fileSet : fileSets) {
			Iterator<?> iterator = fileSet.iterator();
			while (iterator.hasNext()) {
				resources.add(iterator.next());
			}
		}
		
		return resources.iterator();
	}

	public FileSet createFileSet() {
		FileSet fileSet = new FileSet();
		fileSets.add(fileSet);
		return fileSet;
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
