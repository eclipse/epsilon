/*
 * 
 */
package filesystem.diagram.preferences;

import org.eclipse.gmf.runtime.diagram.ui.preferences.ConnectionsPreferencePage;

import filesystem.diagram.part.FilesystemDiagramEditorPlugin;

/**
 * @generated
 */
public class DiagramConnectionsPreferencePage extends ConnectionsPreferencePage {

	/**
	 * @generated
	 */
	public DiagramConnectionsPreferencePage() {
		setPreferenceStore(FilesystemDiagramEditorPlugin.getInstance()
				.getPreferenceStore());
	}
}
