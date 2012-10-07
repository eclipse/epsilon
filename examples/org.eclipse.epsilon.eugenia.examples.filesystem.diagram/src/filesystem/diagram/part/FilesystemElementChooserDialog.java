/*
 * 
 */
package filesystem.diagram.part;

import java.util.Collections;
import java.util.Iterator;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.edit.provider.IWrapperItemProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;

/**
 * @generated
 */
public class FilesystemElementChooserDialog extends Dialog {

	/**
	 * @generated
	 */
	private TreeViewer myTreeViewer;

	/**
	 * @generated
	 */
	private URI mySelectedModelElementURI;

	/**
	 * @generated
	 */
	private View myView;

	/**
	 * @generated
	 */
	private TransactionalEditingDomain myEditingDomain = GMFEditingDomainFactory.INSTANCE
			.createEditingDomain();

	/**
	 * @generated
	 */
	public FilesystemElementChooserDialog(Shell parentShell, View view) {
		super(parentShell);
		setShellStyle(getShellStyle() | SWT.RESIZE);
		myView = view;
	}

	/**
	 * @generated
	 */
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);
		getShell()
				.setText(
						Messages.FilesystemElementChooserDialog_SelectModelElementTitle);
		createModelBrowser(composite);
		return composite;
	}

	/**
	 * @generated
	 */
	protected Control createButtonBar(Composite parent) {
		Control buttonBar = super.createButtonBar(parent);
		setOkButtonEnabled(false);
		return buttonBar;
	}

	/**
	 * @generated
	 */
	private void createModelBrowser(Composite composite) {
		myTreeViewer = new TreeViewer(composite, SWT.SINGLE | SWT.H_SCROLL
				| SWT.V_SCROLL | SWT.BORDER);
		GridData layoutData = new GridData(GridData.FILL_BOTH);
		layoutData.heightHint = 300;
		layoutData.widthHint = 300;
		myTreeViewer.getTree().setLayoutData(layoutData);
		myTreeViewer.setContentProvider(new ModelElementsTreeContentProvider());
		myTreeViewer.setLabelProvider(new ModelElementsTreeLabelProvider());
		myTreeViewer.setInput(ResourcesPlugin.getWorkspace().getRoot());
		myTreeViewer.addFilter(new ModelFilesFilter());
		myTreeViewer.addSelectionChangedListener(new OkButtonEnabler());
	}

	/**
	 * @generated
	 */
	private void setOkButtonEnabled(boolean enabled) {
		getButton(IDialogConstants.OK_ID).setEnabled(enabled);
	}

	/**
	 * @generated
	 */
	private boolean isValidModelFile(IFile file) {
		String fileExtension = file.getFullPath().getFileExtension();
		return "filesystem".equals(fileExtension); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public URI getSelectedModelElementURI() {
		return mySelectedModelElementURI;
	}

	/**
	 * @generated
	 */
	public int open() {
		int result = super.open();
		for (Resource resource : myEditingDomain.getResourceSet()
				.getResources()) {
			resource.unload();
		}
		myEditingDomain.dispose();
		return result;
	}

	/**
	 * @generated
	 */
	private class ModelElementsTreeContentProvider implements
			ITreeContentProvider {

		/**
		 * @generated
		 */
		private ITreeContentProvider myWorkbenchContentProvider = new WorkbenchContentProvider();

		/**
		 * @generated
		 */
		private AdapterFactoryContentProvider myAdapterFctoryContentProvier = new AdapterFactoryContentProvider(
				FilesystemDiagramEditorPlugin.getInstance()
						.getItemProvidersAdapterFactory());

		/**
		 * @generated
		 */
		public Object[] getChildren(Object parentElement) {
			Object[] result = myWorkbenchContentProvider
					.getChildren(parentElement);
			if (result != null && result.length > 0) {
				return result;
			}
			if (parentElement instanceof IFile) {
				IFile modelFile = (IFile) parentElement;
				IPath resourcePath = modelFile.getFullPath();
				ResourceSet resourceSet = myEditingDomain.getResourceSet();
				try {
					Resource modelResource = resourceSet.getResource(
							URI.createPlatformResourceURI(
									resourcePath.toString(), true), true);
					return myAdapterFctoryContentProvier
							.getChildren(modelResource);
				} catch (WrappedException e) {
					FilesystemDiagramEditorPlugin
							.getInstance()
							.logError(
									"Unable to load resource: " + resourcePath.toString(), e); //$NON-NLS-1$
				}
				return Collections.EMPTY_LIST.toArray();
			}
			return myAdapterFctoryContentProvier.getChildren(parentElement);
		}

		/**
		 * @generated
		 */
		public Object getParent(Object element) {
			Object parent = myWorkbenchContentProvider.getParent(element);
			if (parent != null) {
				return parent;
			}
			if (element instanceof EObject) {
				EObject eObject = (EObject) element;
				if (eObject.eContainer() == null
						&& eObject.eResource().getURI().isFile()) {
					String path = eObject.eResource().getURI().path();
					return ResourcesPlugin.getWorkspace().getRoot()
							.getFileForLocation(new Path(path));
				}
				return myAdapterFctoryContentProvier.getParent(eObject);
			}
			return null;
		}

		/**
		 * @generated
		 */
		public boolean hasChildren(Object element) {
			if (element instanceof IFile) {
				return isValidModelFile((IFile) element);
			}
			return myWorkbenchContentProvider.hasChildren(element)
					|| myAdapterFctoryContentProvier.hasChildren(element);
		}

		/**
		 * @generated
		 */
		public Object[] getElements(Object inputElement) {
			Object[] elements = myWorkbenchContentProvider
					.getElements(inputElement);
			return elements;
		}

		/**
		 * @generated
		 */
		public void dispose() {
			myWorkbenchContentProvider.dispose();
			myAdapterFctoryContentProvier.dispose();
		}

		/**
		 * @generated
		 */
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			myWorkbenchContentProvider.inputChanged(viewer, oldInput, newInput);
			myAdapterFctoryContentProvier.inputChanged(viewer, oldInput,
					newInput);
		}

	}

	/**
	 * @generated
	 */
	private class ModelElementsTreeLabelProvider implements ILabelProvider {

		/**
		 * @generated
		 */
		private WorkbenchLabelProvider myWorkbenchLabelProvider = new WorkbenchLabelProvider();

		/**
		 * @generated
		 */
		private AdapterFactoryLabelProvider myAdapterFactoryLabelProvider = new AdapterFactoryLabelProvider(
				FilesystemDiagramEditorPlugin.getInstance()
						.getItemProvidersAdapterFactory());

		/**
		 * @generated
		 */
		public Image getImage(Object element) {
			Image result = myWorkbenchLabelProvider.getImage(element);
			return result != null ? result : myAdapterFactoryLabelProvider
					.getImage(element);
		}

		/**
		 * @generated
		 */
		public String getText(Object element) {
			String result = myWorkbenchLabelProvider.getText(element);
			return result != null && result.length() > 0 ? result
					: myAdapterFactoryLabelProvider.getText(element);
		}

		/**
		 * @generated
		 */
		public void addListener(ILabelProviderListener listener) {
			myWorkbenchLabelProvider.addListener(listener);
			myAdapterFactoryLabelProvider.addListener(listener);
		}

		/**
		 * @generated
		 */
		public void dispose() {
			myWorkbenchLabelProvider.dispose();
			myAdapterFactoryLabelProvider.dispose();
		}

		/**
		 * @generated
		 */
		public boolean isLabelProperty(Object element, String property) {
			return myWorkbenchLabelProvider.isLabelProperty(element, property)
					|| myAdapterFactoryLabelProvider.isLabelProperty(element,
							property);
		}

		/**
		 * @generated
		 */
		public void removeListener(ILabelProviderListener listener) {
			myWorkbenchLabelProvider.removeListener(listener);
			myAdapterFactoryLabelProvider.removeListener(listener);
		}

	}

	/**
	 * @generated
	 */
	private class ModelFilesFilter extends ViewerFilter {

		/**
		 * @generated
		 */
		public boolean select(Viewer viewer, Object parentElement,
				Object element) {
			if (element instanceof IContainer) {
				return true;
			}
			if (element instanceof IFile) {
				IFile file = (IFile) element;
				return isValidModelFile(file);
			}
			return true;
		}

	}

	/**
	 * @generated
	 */
	private class OkButtonEnabler implements ISelectionChangedListener {

		/**
		 * @generated
		 */
		public void selectionChanged(SelectionChangedEvent event) {
			if (event.getSelection() instanceof IStructuredSelection) {
				IStructuredSelection selection = (IStructuredSelection) event
						.getSelection();
				if (selection.size() == 1) {
					Object selectedElement = selection.getFirstElement();
					if (selectedElement instanceof IWrapperItemProvider) {
						selectedElement = ((IWrapperItemProvider) selectedElement)
								.getValue();
					}
					if (selectedElement instanceof FeatureMap.Entry) {
						selectedElement = ((FeatureMap.Entry) selectedElement)
								.getValue();
					}
					if (selectedElement instanceof EObject) {
						EObject selectedModelElement = (EObject) selectedElement;
						setOkButtonEnabled(ViewService
								.getInstance()
								.provides(
										Node.class,
										new EObjectAdapter(selectedModelElement),
										myView,
										null,
										ViewUtil.APPEND,
										true,
										FilesystemDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT));
						mySelectedModelElementURI = EcoreUtil
								.getURI(selectedModelElement);
						return;
					}
				}
			}
			mySelectedModelElementURI = null;
			setOkButtonEnabled(false);
		}

	}

}
