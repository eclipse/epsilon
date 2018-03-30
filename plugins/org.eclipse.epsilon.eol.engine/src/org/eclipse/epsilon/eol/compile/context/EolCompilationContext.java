package org.eclipse.epsilon.eol.compile.context;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.common.module.AbstractModuleElement;
import org.eclipse.epsilon.common.module.ModuleMarker;
import org.eclipse.epsilon.common.module.ModuleMarker.Severity;
import org.eclipse.epsilon.eol.compile.m3.MetaClass;
import org.eclipse.epsilon.eol.compile.m3.Metamodel;
import org.eclipse.epsilon.eol.dom.ModelDeclaration;
import org.eclipse.epsilon.eol.execute.context.FrameStack;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.models.IRelativePathResolver;
import org.eclipse.epsilon.eol.types.EolModelElementType;

public class EolCompilationContext {

	protected List<ModuleMarker> markers = new ArrayList<>();
	protected IEolContext runtimeContext = null;
	protected FrameStack frameStack = new FrameStack();
	protected IModelFactory modelFactory;
	protected IRelativePathResolver relativePathResolver;
	protected List<ModelDeclaration> modelDeclarations = new ArrayList<>();
	
	public List<ModuleMarker> getMarkers() {
		return markers;
	}
	
	public void setRuntimeContext(IEolContext context) {
		this.runtimeContext = context;
	}

	public void addWarningMarker(AbstractModuleElement element, String message) {
		markers.add(new ModuleMarker(element, message, Severity.Warning));
	}

	public void addErrorMarker(AbstractModuleElement element, String message) {
		markers.add(new ModuleMarker(element, message, Severity.Error));
	}
	
	public FrameStack getFrameStack() {
		return frameStack;
	}
	
	public IModelFactory getModelFactory() {
		return modelFactory;
	}
	
	public void setModelFactory(IModelFactory modelFactory) {
		this.modelFactory = modelFactory;
	}
	
	public IRelativePathResolver getRelativePathResolver() {
		return relativePathResolver;
	}
	
	public void setRelativePathResolver(IRelativePathResolver relativePathResolver) {
		this.relativePathResolver = relativePathResolver;
	}
	
	public void setModelDeclarations(List<ModelDeclaration> modelDeclarations) {
		this.modelDeclarations = modelDeclarations;
	}
	
	public List<ModelDeclaration> getModelDeclarations() {
		return modelDeclarations;
	}
	
	public EolModelElementType getModelElementType(String modelAndType) {
		EolModelElementType modelElementType = new EolModelElementType(modelAndType);
		
		for (ModelDeclaration modelDeclaration : modelDeclarations) {
			if (modelElementType.getModelName().isEmpty() || modelDeclaration.getNameExpression().getName().equals(modelElementType.getModelName())) {
				Metamodel metamodel = modelDeclaration.getMetamodel();
				if (metamodel != null) {
					MetaClass metaClass = metamodel.getMetaClass(modelElementType.getTypeName());
					modelElementType.setMetaClass(metaClass);
					return modelElementType;
				}
			}
		}
		
		return modelElementType;
	}
	
}
