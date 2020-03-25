/**
 */
package org.eclipse.epsilon.picto.dom;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Layer Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.epsilon.picto.dom.LayerConfiguration#getIds <em>Ids</em>}</li>
 *   <li>{@link org.eclipse.epsilon.picto.dom.LayerConfiguration#isActive <em>Active</em>}</li>
 * </ul>
 *
 * @see org.eclipse.epsilon.picto.dom.PictoPackage#getLayerConfiguration()
 * @model
 * @generated
 */
public interface LayerConfiguration extends EObject {
	/**
	 * Returns the value of the '<em><b>Ids</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ids</em>' attribute list.
	 * @see org.eclipse.epsilon.picto.dom.PictoPackage#getLayerConfiguration_Ids()
	 * @model
	 * @generated
	 */
	EList<String> getIds();

	/**
	 * Returns the value of the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Active</em>' attribute.
	 * @see #setActive(boolean)
	 * @see org.eclipse.epsilon.picto.dom.PictoPackage#getLayerConfiguration_Active()
	 * @model
	 * @generated
	 */
	boolean isActive();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.picto.dom.LayerConfiguration#isActive <em>Active</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Active</em>' attribute.
	 * @see #isActive()
	 * @generated
	 */
	void setActive(boolean value);

} // LayerConfiguration
