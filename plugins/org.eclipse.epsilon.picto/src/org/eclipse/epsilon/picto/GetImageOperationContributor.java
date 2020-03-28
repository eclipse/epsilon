package org.eclipse.epsilon.picto;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.eclipse.epsilon.egl.EgxModule;
import org.eclipse.epsilon.eol.execute.operations.contributors.OperationContributor;
import org.eclipse.epsilon.eol.types.EolNoType;

public class GetImageOperationContributor extends OperationContributor {
	
	protected EgxModule module;
	
	public GetImageOperationContributor(EgxModule module) {
		this.module = module;
	}
	
	@Override
	public boolean contributesTo(Object target) {
		return target == EolNoType.NoInstance;
	}
	
	public String getImage(String path) {
		if (module.getFile() != null) {
			return new File(module.getFile().getParent(), path).getAbsolutePath();
		}
		else if (module.getUri() != null) {
			try {
				InputStream in = module.getUri().resolve(path).toURL().openStream();
				Path temp = Files.createTempFile("image", ".png");
				Files.copy(in, temp, StandardCopyOption.REPLACE_EXISTING);
				in.close();
				return temp.toAbsolutePath().toString();
			} catch (Exception e) {}
		}
		return path;
	}
}
