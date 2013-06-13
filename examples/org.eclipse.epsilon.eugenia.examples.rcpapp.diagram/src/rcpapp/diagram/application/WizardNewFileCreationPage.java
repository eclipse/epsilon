/*
 * 
 */
package rcpapp.diagram.application;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import rcpapp.diagram.part.Messages;

/**
 * @generated
 */
public class WizardNewFileCreationPage extends WizardPage {

	/**
	 * @generated
	 */
	private final IStructuredSelection currentSelection;

	/**
	 * @generated
	 */
	private String initialFileName;

	/**
	 * @generated
	 */
	private IPath initialContainerFullPath;

	/**
	 * @generated
	 */
	private Text fileNameEditor;

	/**
	 * @generated
	 */
	public WizardNewFileCreationPage(String name,
			IStructuredSelection currentSelection) {
		super(name);
		this.currentSelection = currentSelection;
		String home = System.getProperty("user.home"); //$NON-NLS-1$
		if (home != null) {
			initialContainerFullPath = new Path(home);
		}
	}

	/**
	 * @generated
	 */
	protected IStructuredSelection getSelection() {
		return currentSelection;
	}

	/**
	 * @generated
	 */
	public String getFileName() {
		if (fileNameEditor == null) {
			return initialFileName;
		}
		IPath path = getFilePath();
		if (path == null || path.isEmpty() || path.hasTrailingSeparator()) {
			return null;
		}
		return path.lastSegment();
	}

	/**
	 * @generated
	 */
	public void setFileName(String fileName) {
		if (fileNameEditor == null) {
			initialFileName = fileName;
			return;
		}
		setFilePath(getContainerFullPath(), fileName);
	}

	/**
	 * @generated
	 */
	public IPath getContainerFullPath() {
		if (fileNameEditor == null) {
			return initialContainerFullPath;
		}
		IPath path = getFilePath();
		if (path == null || path.isEmpty()) {
			return null;
		}
		if (path.hasTrailingSeparator()) {
			return path;
		}
		path = path.removeLastSegments(1);
		if (path.isEmpty()) {
			return null;
		}
		return path.addTrailingSeparator();
	}

	/**
	 * @generated
	 */
	public void setContainerFullPath(IPath containerPath) {
		if (fileNameEditor == null) {
			initialContainerFullPath = containerPath;
			return;
		}
		setFilePath(containerPath, getFileName());
	}

	/**
	 * @generated
	 */
	protected IPath getFilePath() {
		String fileName = fileNameEditor.getText().trim();
		if (fileName.length() == 0) {
			return null;
		}
		return new Path(fileNameEditor.getText());
	}

	/**
	 * @generated
	 */
	protected void setFilePath(IPath containerPath, String fileName) {
		if (fileName == null) {
			fileName = ""; //$NON-NLS-1$
		} else {
			fileName = fileName.trim();
		}
		if (containerPath == null) {
			fileNameEditor.setText(fileName);
		} else {
			if (!containerPath.hasTrailingSeparator()) {
				containerPath = containerPath.addTrailingSeparator();
			}
			IPath path = fileName.length() == 0 ? containerPath : containerPath
					.append(fileName);
			fileNameEditor.setText(path.toOSString());
		}
		setPageComplete(validatePage());
	}

	/**
	 * @generated
	 */
	public void createControl(Composite parent) {
		Composite plate = new Composite(parent, SWT.NONE);
		plate.setLayout(new GridLayout(2, false));
		Label label = new Label(plate, SWT.NONE);
		label.setText(Messages.WizardNewFileCreationPage_FileLabel);
		label.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false,
				false, 2, 1));
		fileNameEditor = new Text(plate, SWT.SINGLE | SWT.BORDER);
		fileNameEditor.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false));
		Button button = new Button(plate, SWT.PUSH);
		button.setText(Messages.WizardNewFileCreationPage_BrowseButton);
		button.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false,
				false));

		// logic
		fileNameEditor.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				setPageComplete(validatePage());
			}
		});
		button.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				FileDialog dialog = new FileDialog(getShell(), SWT.SAVE);
				dialog.setText(Messages.WizardNewFileCreationPage_SelectNewFileDialog);
				dialog.setFileName(getFileName());
				String fileName = dialog.open();
				if (fileName != null) {
					fileNameEditor.setText(fileName);
					setPageComplete(validatePage());
				}
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		// init
		setFilePath(initialContainerFullPath, initialFileName);
		setControl(plate);
	}

	/**
	 * @generated
	 */
	protected boolean validatePage() {
		String fileName = fileNameEditor.getText().trim();
		if (fileName.length() == 0) {
			setErrorMessage(Messages.WizardNewFileCreationPage_EmptyFileNameError);
			return false;
		}
		if (!new Path("").isValidPath(fileName)) { //$NON-NLS-1$
			setErrorMessage(Messages.WizardNewFileCreationPage_InvalidFileNameError);
			return false;
		}
		setErrorMessage(null);
		return true;
	}
}
