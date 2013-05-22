/**
 */
package org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.actions;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.actions.ActionsFactory
 * @model kind="package"
 * @generated
 */
public interface ActionsPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "actions";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/epsilon/eugenia/examples/executablestatemachine/textual/Actions";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "actions";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ActionsPackage eINSTANCE = org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.actions.impl.ActionsPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.actions.impl.ActionImpl <em>Action</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.actions.impl.ActionImpl
   * @see org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.actions.impl.ActionsPackageImpl#getAction()
   * @generated
   */
  int ACTION = 0;

  /**
   * The number of structural features of the '<em>Action</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTION_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.actions.impl.SetImpl <em>Set</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.actions.impl.SetImpl
   * @see org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.actions.impl.ActionsPackageImpl#getSet()
   * @generated
   */
  int SET = 1;

  /**
   * The feature id for the '<em><b>Var</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SET__VAR = ACTION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SET__VALUE = ACTION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Set</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SET_FEATURE_COUNT = ACTION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.actions.impl.IncImpl <em>Inc</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.actions.impl.IncImpl
   * @see org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.actions.impl.ActionsPackageImpl#getInc()
   * @generated
   */
  int INC = 2;

  /**
   * The feature id for the '<em><b>Var</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INC__VAR = ACTION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Inc</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INC_FEATURE_COUNT = ACTION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.actions.impl.DecImpl <em>Dec</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.actions.impl.DecImpl
   * @see org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.actions.impl.ActionsPackageImpl#getDec()
   * @generated
   */
  int DEC = 3;

  /**
   * The feature id for the '<em><b>Var</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEC__VAR = ACTION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Dec</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEC_FEATURE_COUNT = ACTION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.actions.impl.IfImpl <em>If</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.actions.impl.IfImpl
   * @see org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.actions.impl.ActionsPackageImpl#getIf()
   * @generated
   */
  int IF = 4;

  /**
   * The feature id for the '<em><b>Var</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF__VAR = ACTION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF__VALUE = ACTION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>If</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_FEATURE_COUNT = ACTION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.actions.impl.PrintImpl <em>Print</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.actions.impl.PrintImpl
   * @see org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.actions.impl.ActionsPackageImpl#getPrint()
   * @generated
   */
  int PRINT = 5;

  /**
   * The feature id for the '<em><b>Msg</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRINT__MSG = ACTION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Print</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRINT_FEATURE_COUNT = ACTION_FEATURE_COUNT + 1;


  /**
   * Returns the meta object for class '{@link org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.actions.Action <em>Action</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Action</em>'.
   * @see org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.actions.Action
   * @generated
   */
  EClass getAction();

  /**
   * Returns the meta object for class '{@link org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.actions.Set <em>Set</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Set</em>'.
   * @see org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.actions.Set
   * @generated
   */
  EClass getSet();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.actions.Set#getVar <em>Var</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Var</em>'.
   * @see org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.actions.Set#getVar()
   * @see #getSet()
   * @generated
   */
  EAttribute getSet_Var();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.actions.Set#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.actions.Set#getValue()
   * @see #getSet()
   * @generated
   */
  EAttribute getSet_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.actions.Inc <em>Inc</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Inc</em>'.
   * @see org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.actions.Inc
   * @generated
   */
  EClass getInc();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.actions.Inc#getVar <em>Var</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Var</em>'.
   * @see org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.actions.Inc#getVar()
   * @see #getInc()
   * @generated
   */
  EAttribute getInc_Var();

  /**
   * Returns the meta object for class '{@link org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.actions.Dec <em>Dec</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Dec</em>'.
   * @see org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.actions.Dec
   * @generated
   */
  EClass getDec();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.actions.Dec#getVar <em>Var</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Var</em>'.
   * @see org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.actions.Dec#getVar()
   * @see #getDec()
   * @generated
   */
  EAttribute getDec_Var();

  /**
   * Returns the meta object for class '{@link org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.actions.If <em>If</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>If</em>'.
   * @see org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.actions.If
   * @generated
   */
  EClass getIf();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.actions.If#getVar <em>Var</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Var</em>'.
   * @see org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.actions.If#getVar()
   * @see #getIf()
   * @generated
   */
  EAttribute getIf_Var();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.actions.If#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.actions.If#getValue()
   * @see #getIf()
   * @generated
   */
  EAttribute getIf_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.actions.Print <em>Print</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Print</em>'.
   * @see org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.actions.Print
   * @generated
   */
  EClass getPrint();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.actions.Print#getMsg <em>Msg</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Msg</em>'.
   * @see org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.actions.Print#getMsg()
   * @see #getPrint()
   * @generated
   */
  EAttribute getPrint_Msg();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  ActionsFactory getActionsFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.actions.impl.ActionImpl <em>Action</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.actions.impl.ActionImpl
     * @see org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.actions.impl.ActionsPackageImpl#getAction()
     * @generated
     */
    EClass ACTION = eINSTANCE.getAction();

    /**
     * The meta object literal for the '{@link org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.actions.impl.SetImpl <em>Set</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.actions.impl.SetImpl
     * @see org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.actions.impl.ActionsPackageImpl#getSet()
     * @generated
     */
    EClass SET = eINSTANCE.getSet();

    /**
     * The meta object literal for the '<em><b>Var</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SET__VAR = eINSTANCE.getSet_Var();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SET__VALUE = eINSTANCE.getSet_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.actions.impl.IncImpl <em>Inc</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.actions.impl.IncImpl
     * @see org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.actions.impl.ActionsPackageImpl#getInc()
     * @generated
     */
    EClass INC = eINSTANCE.getInc();

    /**
     * The meta object literal for the '<em><b>Var</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INC__VAR = eINSTANCE.getInc_Var();

    /**
     * The meta object literal for the '{@link org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.actions.impl.DecImpl <em>Dec</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.actions.impl.DecImpl
     * @see org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.actions.impl.ActionsPackageImpl#getDec()
     * @generated
     */
    EClass DEC = eINSTANCE.getDec();

    /**
     * The meta object literal for the '<em><b>Var</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DEC__VAR = eINSTANCE.getDec_Var();

    /**
     * The meta object literal for the '{@link org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.actions.impl.IfImpl <em>If</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.actions.impl.IfImpl
     * @see org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.actions.impl.ActionsPackageImpl#getIf()
     * @generated
     */
    EClass IF = eINSTANCE.getIf();

    /**
     * The meta object literal for the '<em><b>Var</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IF__VAR = eINSTANCE.getIf_Var();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IF__VALUE = eINSTANCE.getIf_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.actions.impl.PrintImpl <em>Print</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.actions.impl.PrintImpl
     * @see org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.actions.impl.ActionsPackageImpl#getPrint()
     * @generated
     */
    EClass PRINT = eINSTANCE.getPrint();

    /**
     * The meta object literal for the '<em><b>Msg</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PRINT__MSG = eINSTANCE.getPrint_Msg();

  }

} //ActionsPackage
