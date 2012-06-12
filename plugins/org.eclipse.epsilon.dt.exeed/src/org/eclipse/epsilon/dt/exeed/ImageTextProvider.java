/*******************************************************************************
 * Copyright (c) 2008-2012 The University of York, Antonio García-Domínguez
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 *     Antonio García-Domínguez - clean up and improve error reporting
 ******************************************************************************/
package org.eclipse.epsilon.dt.exeed;

import java.util.List;
import java.util.ListIterator;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.epsilon.common.dt.console.EpsilonConsole;
import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.commons.parse.problem.ParseProblem;
import org.eclipse.epsilon.commons.util.StringUtil;
import org.eclipse.epsilon.emc.emf.InMemoryEmfModel;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.execute.operations.OperationFactory;
import org.eclipse.epsilon.eol.execute.operations.simple.AbstractSimpleOperation;
import org.eclipse.jface.resource.ImageDescriptor;

class ImageTextProvider {

	private boolean showStructuralInfo = false;
	private EolModule module;
	private ExeedPlugin plugin = null;
	private ExeedEditor editor = null;

	public ImageTextProvider(InMemoryEmfModel model, ExeedPlugin plugin, ExeedEditor editor) {
		this.plugin = plugin;
		this.editor = editor;
		this.showStructuralInfo = plugin.getPreferenceStore().getBoolean(ExeedPreferencePage.SHOW_STRUCTURAL_INFO);
		module = new EolModule();
		module.getContext().getModelRepository().addModel(model);
		module.getContext().setOperationFactory(new OperationFactory() {

			@Override
			protected void createCache() {
				super.createCache();
				operationCache.put("label", new AbstractSimpleOperation() {
					@SuppressWarnings("rawtypes")
					@Override
					public Object execute(Object source, List parameters, IEolContext context, AST ast) throws EolRuntimeException {
						return getEObjectReferenceLabel(source,getBasicEObjectLabel(source));
					}

					protected String getBasicEObjectLabel(Object object) {
						if (!(object instanceof EObject)) return "undefined";
						EObject eObject = (EObject) object;
						String label = eObject.eClass().getName();
						if (eObject.eClass().getEAllAttributes().size() > 0) {
							EAttribute attribute = eObject.eClass().getEAllAttributes().get(0);
							label = label + " " + eObject.eGet(attribute);
						}
						return label;
					}
					
				});
			}
			
		});
		
		module.getContext().getIntrospectionManager().setDefaultPropertyGetter(new JavaEmfPropertyGetter());
		module.getContext().getIntrospectionManager().setDefaultPropertySetter(new JavaEmfPropertySetter());
		module.getContext().setOutputStream(EpsilonConsole.getInstance().getDebugStream());
		module.getContext().setErrorStream(EpsilonConsole.getInstance().getErrorStream());
	}

	public String getEStructuralFeatureLabel(EStructuralFeature feature, String def) {
		EAnnotation eAnnotation = feature.getEAnnotation("exeed");
		if (eAnnotation != null) {
			Object detailValue = eAnnotation.getDetails().get("featureLabel");
			if (detailValue != null) {
				return detailValue.toString();
			}
		}
		return def;
	}

	public String getEObjectLabel(Object object, String def, boolean forReference) {
		if (!(object instanceof EObject)) return def;
		String labelCode = "";

		try {
			EObject eObject = (EObject) object;
			module.getContext().setErrorStream(EpsilonConsole.getInstance().getErrorStream());
			module.getContext().setOutputStream(EpsilonConsole.getInstance().getDebugStream());
			labelCode = getEClassAnnotationDetail(eObject, "exeed", "label");
			if (labelCode != null) {
				parse(labelCode);
				module.getContext().getFrameStack().enterLocal(FrameType.UNPROTECTED, null);
				module.getContext().getFrameStack().put(Variable.createReadOnlyVariable("self", eObject));
				module.getContext().getFrameStack().put(Variable.createReadOnlyVariable("thisModule", module));
				String label = StringUtil.toString(module.execute());
				module.getContext().getFrameStack().leaveLocal(null);
				return addStructuralInfo(object,label,forReference);
			}
		} catch (Exception e) {
			LogUtil.log(e);
		}
		return addStructuralInfo(object, def, forReference);
	}

	public String getEObjectReferenceLabel(Object object, String def) {
		if (!(object instanceof EObject)) return def;

		if (object instanceof EEnumLiteral) {
			return getEEnumLiteralLabel((EEnumLiteral)object);
		}

		try {
			EObject eObject = (EObject) object;
			String labelCode = getEClassAnnotationDetail(eObject, "exeed", "referenceLabel");
			if (labelCode != null) {
				parse(labelCode);
				Variable[] variables = {};
				module.getContext().getFrameStack().enterLocal(FrameType.UNPROTECTED, null, variables);
				module.getContext().getFrameStack().put(Variable.createReadOnlyVariable("self", eObject));
				String label = StringUtil.toString(module.execute());
				module.getContext().getFrameStack().leaveLocal(null);
				return label;
			}
		} catch (Exception e) {
			LogUtil.log(e);
		}

		return getEObjectLabel(object, def, true);
	}	
	
	public ImageDescriptor getEObjectImageDescriptor(Object object, ImageDescriptor def) {
		if (!(object instanceof EObject)) return def;

		String icon = "";
		try {
			EObject eObject = (EObject) object;
			ImageDescriptor imageDescriptor = null;
			module.getContext().getFrameStack().put(Variable.createReadOnlyVariable("self", eObject));
			String labelCode = getEClassAnnotationDetail(eObject, "exeed", "icon");
			if (labelCode != null) {
				parse(labelCode);
				icon = StringUtil.toString(module.execute());
				imageDescriptor = getImageDescriptor(icon);
			}
			else {
				imageDescriptor = getEClassImageDescriptor(eObject.eClass() ,null);
			}

			if (imageDescriptor != null) {
				return imageDescriptor;
			}
		} catch (Exception e) {
			LogUtil.log(e);
		}

		return def;
	}

	public ImageDescriptor getEClassImageDescriptor(EClass eClass, ImageDescriptor def) {
		String icon = "";
		try {
			icon = getEClassAnnotationDetail(eClass, "exeed", "classIcon");
			ImageDescriptor imageDescriptor = getImageDescriptor(icon);

			if (imageDescriptor == null) {
				imageDescriptor = getImageDescriptor(eClass.getName());
			}

			if (imageDescriptor != null) {
				return imageDescriptor;
			}
		} catch (Exception e) {
			LogUtil.log(e);
		}

		return def;
	}

	public boolean isShowStructuralInfo() {
		return showStructuralInfo;
	}

	public void setShowStructuralInfo(boolean showStructuralInfo) {
		this.showStructuralInfo = showStructuralInfo;
	}

	private String addStructuralInfo(Object object, String label, boolean forReference) {
		if (object instanceof EObject && !forReference && showStructuralInfo) {
			EObject eObject = (EObject) object;
			String suffix = " (" + eObject.eClass().getName();
			if (eObject.eContainingFeature() != null) {
				suffix = suffix + "@"
						+ eObject.eContainingFeature().getEContainingClass().getName()
						+ "." + eObject.eContainingFeature().getName();
			}
			label = label + suffix + ")";
		}
		return label;
	}

	private String getEEnumLiteralLabel(EEnumLiteral literal) {
		EAnnotation annotation = literal.getEAnnotation("exeed");
		if (annotation != null) {
			Object detail = annotation.getDetails().get("label");
			if (detail != null) {
				return detail.toString();
			}
		}
		return literal.getLiteral();
	}

	private ImageDescriptor getImageDescriptor(String icon) {
		ImageDescriptor imageDescriptor = null;
		
		imageDescriptor = plugin.getImageDescriptor(editor.getPluginId(), "icons/" + icon + ".gif");
		if (imageDescriptor == null) {
			imageDescriptor = plugin.getImageDescriptor(editor.getPluginId(), "icons/" + icon + ".png");
		}
		
		return imageDescriptor;
	}

	private String getEClassAnnotationDetail(EObject eObject, String annotation, String detail) {
		return getEClassAnnotationDetail(eObject.eClass(), annotation, detail);
	}

	private String getEClassAnnotationDetail(EClass eClass, String annotation, String detail) {
		EAnnotation eAnnotation = eClass.getEAnnotation(annotation);
		if (eAnnotation != null) {
			Object detailValue = eAnnotation.getDetails().get(detail);
			if (detailValue != null) {
				return detailValue.toString();
			}
		}
		
		if (eClass.getESuperTypes().size() > 0) {
			ListIterator<EClass> li = eClass.getESuperTypes().listIterator();
			while (li.hasNext()) {
				EClass superType = (EClass) li.next();
				String detailValue = getEClassAnnotationDetail(superType, annotation, detail);
				if (detailValue != null) {
					return detailValue;
				}
			}
		}
		
		return null;
		
	}

	private void parse(String code) throws Exception {
		if (!module.parse(code)) {
			final StringBuilder sb = new StringBuilder("The EOL label generation snippet produced several parsing errors: ");
			for (ParseProblem pp : module.getParseProblems()) {
				sb.append("\n - ");
				sb.append(pp.toString());
			}
			throw new EolRuntimeException(sb.toString());
		}
	}
}
