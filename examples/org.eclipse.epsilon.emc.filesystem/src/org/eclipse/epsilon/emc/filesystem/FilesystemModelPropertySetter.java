package org.eclipse.epsilon.emc.filesystem;

import java.io.File;
import java.io.FileOutputStream;

import org.eclipse.epsilon.eol.exceptions.EolInternalException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.introspection.java.JavaPropertySetter;

public class FilesystemModelPropertySetter extends JavaPropertySetter {
	
	@Override
	public void invoke(Object value) throws EolRuntimeException {
		if ("contents".equals(property)) {
			
			try {
				FileOutputStream fos = new FileOutputStream((File) object);
				fos.write((value + "").getBytes());
				fos.close();
			}
			catch (Exception e) {
				throw new EolInternalException(e);
			}
		}
		else {
			super.invoke(value);
		}
 	}
	
}
