/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package endlabels;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Association</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link endlabels.Association#getSource <em>Source</em>}</li>
 *   <li>{@link endlabels.Association#getTarget <em>Target</em>}</li>
 *   <li>{@link endlabels.Association#getSourceLabel <em>Source Label</em>}</li>
 *   <li>{@link endlabels.Association#getTargetLabel <em>Target Label</em>}</li>
 * </ul>
 * </p>
 *
 * @see endlabels.EndlabelsPackage#getAssociation()
 * @model annotation="gmf.link source='source' target='target'"
 * @generated
 */
public interface Association extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(endlabels.Class)
	 * @see endlabels.EndlabelsPackage#getAssociation_Source()
	 * @model
	 * @generated
	 */
	endlabels.Class getSource();

	/**
	 * Sets the value of the '{@link endlabels.Association#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(endlabels.Class value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(endlabels.Class)
	 * @see endlabels.EndlabelsPackage#getAssociation_Target()
	 * @model
	 * @generated
	 */
	endlabels.Class getTarget();

	/**
	 * Sets the value of the '{@link endlabels.Association#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(endlabels.Class value);

	/**
	 * Returns the value of the '<em><b>Source Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Label</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Label</em>' attribute.
	 * @see #setSourceLabel(String)
	 * @see endlabels.EndlabelsPackage#getAssociation_SourceLabel()
	 * @model
	 * @generated
	 */
	String getSourceLabel();

	/**
	 * Sets the value of the '{@link endlabels.Association#getSourceLabel <em>Source Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Label</em>' attribute.
	 * @see #getSourceLabel()
	 * @generated
	 */
	void setSourceLabel(String value);

	/**
	 * Returns the value of the '<em><b>Target Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Label</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Label</em>' attribute.
	 * @see #setTargetLabel(String)
	 * @see endlabels.EndlabelsPackage#getAssociation_TargetLabel()
	 * @model
	 * @generated
	 */
	String getTargetLabel();

	/**
	 * Sets the value of the '{@link endlabels.Association#getTargetLabel <em>Target Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Label</em>' attribute.
	 * @see #getTargetLabel()
	 * @generated
	 */
	void setTargetLabel(String value);

} // Association
