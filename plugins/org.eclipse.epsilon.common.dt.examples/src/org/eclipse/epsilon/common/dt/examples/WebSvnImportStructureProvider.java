package org.eclipse.epsilon.common.dt.examples;

import java.io.InputStream;
import java.net.URL;
import java.util.Collections;
import java.util.List;

import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.eclipse.ui.wizards.datatransfer.IImportStructureProvider;

public class WebSvnImportStructureProvider implements IImportStructureProvider {
	
	@Override
	public List<?> getChildren(Object element) {
		if (element instanceof WebSvnFolder) {
			try {
				return ((WebSvnFolder) element).getChildren();
			} catch (Exception e) {
				LogUtil.log(e);
			}
		}
		
		return Collections.emptyList();
		
	}

	@Override
	public InputStream getContents(Object element) {
		if (element.getClass() == WebSvnFile.class) {
			try {
				return new URL(((WebSvnFile) element).getUrl()).openConnection().getInputStream();
			} catch (Exception e) {
				LogUtil.log(e);
			}
		}
		return null;
	}

	@Override
	public String getFullPath(Object element) {
		return ((WebSvnFile) element).getRelativePath();
	}

	@Override
	public String getLabel(Object element) {
		return ((WebSvnFile) element).getName();
	}

	@Override
	public boolean isFolder(Object element) {
		return element instanceof WebSvnFolder;
	}

}
