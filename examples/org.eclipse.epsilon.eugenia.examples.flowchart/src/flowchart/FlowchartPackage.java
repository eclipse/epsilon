/**
 */
package flowchart;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see flowchart.FlowchartFactory
 * @model kind="package"
 * @generated
 */
public interface FlowchartPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "flowchart";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "flowchart";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "flowchart";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  FlowchartPackage eINSTANCE = flowchart.impl.FlowchartPackageImpl.init();

  /**
   * The meta object id for the '{@link flowchart.impl.FlowchartImpl <em>Flowchart</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see flowchart.impl.FlowchartImpl
   * @see flowchart.impl.FlowchartPackageImpl#getFlowchart()
   * @generated
   */
  int FLOWCHART = 0;

  /**
   * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FLOWCHART__NODES = 0;

  /**
   * The feature id for the '<em><b>Transitions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FLOWCHART__TRANSITIONS = 1;

  /**
   * The number of structural features of the '<em>Flowchart</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FLOWCHART_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link flowchart.impl.NodeImpl <em>Node</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see flowchart.impl.NodeImpl
   * @see flowchart.impl.FlowchartPackageImpl#getNode()
   * @generated
   */
  int NODE = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE__NAME = 0;

  /**
   * The feature id for the '<em><b>Outgoing</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE__OUTGOING = 1;

  /**
   * The feature id for the '<em><b>Incoming</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE__INCOMING = 2;

  /**
   * The number of structural features of the '<em>Node</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link flowchart.impl.TransitionImpl <em>Transition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see flowchart.impl.TransitionImpl
   * @see flowchart.impl.FlowchartPackageImpl#getTransition()
   * @generated
   */
  int TRANSITION = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION__NAME = 0;

  /**
   * The feature id for the '<em><b>Source</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION__SOURCE = 1;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION__TARGET = 2;

  /**
   * The number of structural features of the '<em>Transition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link flowchart.impl.SubflowImpl <em>Subflow</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see flowchart.impl.SubflowImpl
   * @see flowchart.impl.FlowchartPackageImpl#getSubflow()
   * @generated
   */
  int SUBFLOW = 3;

  /**
   * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBFLOW__NODES = FLOWCHART__NODES;

  /**
   * The feature id for the '<em><b>Transitions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBFLOW__TRANSITIONS = FLOWCHART__TRANSITIONS;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBFLOW__NAME = FLOWCHART_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Outgoing</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBFLOW__OUTGOING = FLOWCHART_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Incoming</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBFLOW__INCOMING = FLOWCHART_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Subflow</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBFLOW_FEATURE_COUNT = FLOWCHART_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link flowchart.impl.ActionImpl <em>Action</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see flowchart.impl.ActionImpl
   * @see flowchart.impl.FlowchartPackageImpl#getAction()
   * @generated
   */
  int ACTION = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTION__NAME = NODE__NAME;

  /**
   * The feature id for the '<em><b>Outgoing</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTION__OUTGOING = NODE__OUTGOING;

  /**
   * The feature id for the '<em><b>Incoming</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTION__INCOMING = NODE__INCOMING;

  /**
   * The number of structural features of the '<em>Action</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTION_FEATURE_COUNT = NODE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link flowchart.impl.DecisionImpl <em>Decision</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see flowchart.impl.DecisionImpl
   * @see flowchart.impl.FlowchartPackageImpl#getDecision()
   * @generated
   */
  int DECISION = 5;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECISION__NAME = NODE__NAME;

  /**
   * The feature id for the '<em><b>Outgoing</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECISION__OUTGOING = NODE__OUTGOING;

  /**
   * The feature id for the '<em><b>Incoming</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECISION__INCOMING = NODE__INCOMING;

  /**
   * The number of structural features of the '<em>Decision</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECISION_FEATURE_COUNT = NODE_FEATURE_COUNT + 0;


  /**
   * Returns the meta object for class '{@link flowchart.Flowchart <em>Flowchart</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Flowchart</em>'.
   * @see flowchart.Flowchart
   * @generated
   */
  EClass getFlowchart();

  /**
   * Returns the meta object for the containment reference list '{@link flowchart.Flowchart#getNodes <em>Nodes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Nodes</em>'.
   * @see flowchart.Flowchart#getNodes()
   * @see #getFlowchart()
   * @generated
   */
  EReference getFlowchart_Nodes();

  /**
   * Returns the meta object for the containment reference list '{@link flowchart.Flowchart#getTransitions <em>Transitions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Transitions</em>'.
   * @see flowchart.Flowchart#getTransitions()
   * @see #getFlowchart()
   * @generated
   */
  EReference getFlowchart_Transitions();

  /**
   * Returns the meta object for class '{@link flowchart.Node <em>Node</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Node</em>'.
   * @see flowchart.Node
   * @generated
   */
  EClass getNode();

  /**
   * Returns the meta object for the attribute '{@link flowchart.Node#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see flowchart.Node#getName()
   * @see #getNode()
   * @generated
   */
  EAttribute getNode_Name();

  /**
   * Returns the meta object for the reference list '{@link flowchart.Node#getOutgoing <em>Outgoing</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Outgoing</em>'.
   * @see flowchart.Node#getOutgoing()
   * @see #getNode()
   * @generated
   */
  EReference getNode_Outgoing();

  /**
   * Returns the meta object for the reference list '{@link flowchart.Node#getIncoming <em>Incoming</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Incoming</em>'.
   * @see flowchart.Node#getIncoming()
   * @see #getNode()
   * @generated
   */
  EReference getNode_Incoming();

  /**
   * Returns the meta object for class '{@link flowchart.Transition <em>Transition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Transition</em>'.
   * @see flowchart.Transition
   * @generated
   */
  EClass getTransition();

  /**
   * Returns the meta object for the attribute '{@link flowchart.Transition#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see flowchart.Transition#getName()
   * @see #getTransition()
   * @generated
   */
  EAttribute getTransition_Name();

  /**
   * Returns the meta object for the reference '{@link flowchart.Transition#getSource <em>Source</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Source</em>'.
   * @see flowchart.Transition#getSource()
   * @see #getTransition()
   * @generated
   */
  EReference getTransition_Source();

  /**
   * Returns the meta object for the reference '{@link flowchart.Transition#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target</em>'.
   * @see flowchart.Transition#getTarget()
   * @see #getTransition()
   * @generated
   */
  EReference getTransition_Target();

  /**
   * Returns the meta object for class '{@link flowchart.Subflow <em>Subflow</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Subflow</em>'.
   * @see flowchart.Subflow
   * @generated
   */
  EClass getSubflow();

  /**
   * Returns the meta object for class '{@link flowchart.Action <em>Action</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Action</em>'.
   * @see flowchart.Action
   * @generated
   */
  EClass getAction();

  /**
   * Returns the meta object for class '{@link flowchart.Decision <em>Decision</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Decision</em>'.
   * @see flowchart.Decision
   * @generated
   */
  EClass getDecision();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  FlowchartFactory getFlowchartFactory();

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
     * The meta object literal for the '{@link flowchart.impl.FlowchartImpl <em>Flowchart</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see flowchart.impl.FlowchartImpl
     * @see flowchart.impl.FlowchartPackageImpl#getFlowchart()
     * @generated
     */
    EClass FLOWCHART = eINSTANCE.getFlowchart();

    /**
     * The meta object literal for the '<em><b>Nodes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FLOWCHART__NODES = eINSTANCE.getFlowchart_Nodes();

    /**
     * The meta object literal for the '<em><b>Transitions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FLOWCHART__TRANSITIONS = eINSTANCE.getFlowchart_Transitions();

    /**
     * The meta object literal for the '{@link flowchart.impl.NodeImpl <em>Node</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see flowchart.impl.NodeImpl
     * @see flowchart.impl.FlowchartPackageImpl#getNode()
     * @generated
     */
    EClass NODE = eINSTANCE.getNode();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NODE__NAME = eINSTANCE.getNode_Name();

    /**
     * The meta object literal for the '<em><b>Outgoing</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NODE__OUTGOING = eINSTANCE.getNode_Outgoing();

    /**
     * The meta object literal for the '<em><b>Incoming</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NODE__INCOMING = eINSTANCE.getNode_Incoming();

    /**
     * The meta object literal for the '{@link flowchart.impl.TransitionImpl <em>Transition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see flowchart.impl.TransitionImpl
     * @see flowchart.impl.FlowchartPackageImpl#getTransition()
     * @generated
     */
    EClass TRANSITION = eINSTANCE.getTransition();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TRANSITION__NAME = eINSTANCE.getTransition_Name();

    /**
     * The meta object literal for the '<em><b>Source</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSITION__SOURCE = eINSTANCE.getTransition_Source();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSITION__TARGET = eINSTANCE.getTransition_Target();

    /**
     * The meta object literal for the '{@link flowchart.impl.SubflowImpl <em>Subflow</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see flowchart.impl.SubflowImpl
     * @see flowchart.impl.FlowchartPackageImpl#getSubflow()
     * @generated
     */
    EClass SUBFLOW = eINSTANCE.getSubflow();

    /**
     * The meta object literal for the '{@link flowchart.impl.ActionImpl <em>Action</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see flowchart.impl.ActionImpl
     * @see flowchart.impl.FlowchartPackageImpl#getAction()
     * @generated
     */
    EClass ACTION = eINSTANCE.getAction();

    /**
     * The meta object literal for the '{@link flowchart.impl.DecisionImpl <em>Decision</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see flowchart.impl.DecisionImpl
     * @see flowchart.impl.FlowchartPackageImpl#getDecision()
     * @generated
     */
    EClass DECISION = eINSTANCE.getDecision();

  }

} //FlowchartPackage
