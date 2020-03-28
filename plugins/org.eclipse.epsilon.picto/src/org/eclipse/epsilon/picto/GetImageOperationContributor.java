package org.eclipse.epsilon.picto;

import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.epsilon.egl.EgxModule;
import org.eclipse.epsilon.eol.execute.operations.contributors.OperationContributor;
import org.eclipse.epsilon.eol.types.EolNoType;

public class GetImageOperationContributor extends OperationContributor {
	
	protected EgxModule module;
	protected Map<String, String> cache = new HashMap<>();
	
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
				URI imageUri = module.getUri().resolve(path);
				String tempImagePath = cache.get(imageUri.toString());
				if (tempImagePath == null) {
					InputStream in = imageUri.toURL().openStream();
					Path temp = Files.createTempFile("picto", Paths.get(path).getFileName().toString());
					Files.copy(in, temp, StandardCopyOption.REPLACE_EXISTING);
					in.close();
					tempImagePath = temp.toAbsolutePath().toString();
					cache.put(imageUri.toString(), tempImagePath);
				}
				return tempImagePath;
			} catch (Exception e) {}
		}
		return path;
	}
}
