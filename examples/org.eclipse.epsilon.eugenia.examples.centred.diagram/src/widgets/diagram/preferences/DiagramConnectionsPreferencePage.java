/*
 * 
 */
package widgets.diagram.preferences;

import org.eclipse.gmf.runtime.diagram.ui.preferences.ConnectionsPreferencePage;

import widgets.diagram.part.WidgetsDiagramEditorPlugin;

/**
 * @generated
 */
public class DiagramConnectionsPreferencePage extends ConnectionsPreferencePage {

	/**
	 * @generated
	 */
	public DiagramConnectionsPreferencePage() {
		setPreferenceStore(WidgetsDiagramEditorPlugin.getInstance()
				.getPreferenceStore());
	}
}
