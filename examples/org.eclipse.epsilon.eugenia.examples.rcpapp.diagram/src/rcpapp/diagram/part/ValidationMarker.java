/*
 * 
 */
package rcpapp.diagram.part;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.gef.EditPartViewer;

/**
 * @generated
 */
public class ValidationMarker {

	/**
	 * @generated
	 */
	private static final String KEY = "validation_marker"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final ValidationMarker[] EMPTY_ARRAY = new ValidationMarker[0];

	/**
	 * @generated
	 */
	private final String location;

	/**
	 * @generated
	 */
	private final String message;

	/**
	 * @generated
	 */
	private final int statusSeverity;

	/**
	 * @generated
	 */
	public ValidationMarker(String location, String message, int statusSeverity) {
		this.location = location;
		this.message = message;
		this.statusSeverity = statusSeverity;
	}

	/**
	 * @generated
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @generated
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @generated
	 */
	public int getStatusSeverity() {
		return statusSeverity;
	}

	/**
	 * @generated
	 */
	private static Map getMarkers(EditPartViewer viewer) {
		Map markers = (Map) viewer.getProperty(KEY);
		if (markers == null) {
			markers = new HashMap();
			viewer.setProperty(KEY, markers);
		}
		return markers;
	}

	/**
	 * @generated
	 */
	private static Set getMarkers(EditPartViewer viewer, String viewId,
			boolean create) {
		Set markers = (Set) getMarkers(viewer).get(viewId);
		if (markers == null) {
			if (!create) {
				return Collections.EMPTY_SET;
			}
			markers = new HashSet();
			getMarkers(viewer).put(viewId, markers);
		}
		return markers;
	}

	/**
	 * @generated
	 */
	public static ValidationMarker[] getMarkers(EditPartViewer viewer,
			String viewId) {
		Set markers = getMarkers(viewer, viewId, false);
		if (markers.isEmpty()) {
			return EMPTY_ARRAY;
		}
		return (ValidationMarker[]) markers
				.toArray(new ValidationMarker[markers.size()]);
	}

	/**
	 * @generated
	 */
	public static void removeAllMarkers(EditPartViewer viewer) {
		getMarkers(viewer).clear();
	}

	/**
	 * @generated
	 */
	public void add(EditPartViewer viewer, String viewId) {
		getMarkers(viewer, viewId, true).add(this);
	}
}
