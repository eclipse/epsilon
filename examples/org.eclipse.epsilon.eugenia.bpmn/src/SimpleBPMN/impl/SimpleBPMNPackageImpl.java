/**
 */
package SimpleBPMN.impl;

import SimpleBPMN.Activity;
import SimpleBPMN.Artifact;
import SimpleBPMN.Association;
import SimpleBPMN.BPMNElement;
import SimpleBPMN.BusinessProcessDiagram;
import SimpleBPMN.ConnectingObject;
import SimpleBPMN.DataObject;
import SimpleBPMN.EndEvent;
import SimpleBPMN.FlowObject;
import SimpleBPMN.Gateway;
import SimpleBPMN.Group;
import SimpleBPMN.IntermediateEvent;
import SimpleBPMN.Lane;
import SimpleBPMN.MessageFlow;
import SimpleBPMN.Pool;
import SimpleBPMN.SequenceFlow;
import SimpleBPMN.SimpleBPMNFactory;
import SimpleBPMN.SimpleBPMNPackage;
import SimpleBPMN.StartEvent;
import SimpleBPMN.Swimlane;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SimpleBPMNPackageImpl extends EPackageImpl implements SimpleBPMNPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass businessProcessDiagramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bpmnElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass swimlaneEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass laneEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass poolEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass connectingObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass messageFlowEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sequenceFlowEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass associationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass flowObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass gatewayEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass orEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass andEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass startEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass intermediateEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass endEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass activityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass artifactEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass groupEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see SimpleBPMN.SimpleBPMNPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SimpleBPMNPackageImpl() {
		super(eNS_URI, SimpleBPMNFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link SimpleBPMNPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SimpleBPMNPackage init() {
		if (isInited) return (SimpleBPMNPackage)EPackage.Registry.INSTANCE.getEPackage(SimpleBPMNPackage.eNS_URI);

		// Obtain or create and register package
		SimpleBPMNPackageImpl theSimpleBPMNPackage = (SimpleBPMNPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SimpleBPMNPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SimpleBPMNPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theSimpleBPMNPackage.createPackageContents();

		// Initialize created meta-data
		theSimpleBPMNPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSimpleBPMNPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SimpleBPMNPackage.eNS_URI, theSimpleBPMNPackage);
		return theSimpleBPMNPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBusinessProcessDiagram() {
		return businessProcessDiagramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBusinessProcessDiagram_Elements() {
		return (EReference)businessProcessDiagramEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBPMNElement() {
		return bpmnElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBPMNElement_Name() {
		return (EAttribute)bpmnElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSwimlane() {
		return swimlaneEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLane() {
		return laneEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLane_FlowObjects() {
		return (EReference)laneEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPool() {
		return poolEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPool_Lanes() {
		return (EReference)poolEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConnectingObject() {
		return connectingObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnectingObject_From() {
		return (EReference)connectingObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnectingObject_To() {
		return (EReference)connectingObjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMessageFlow() {
		return messageFlowEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSequenceFlow() {
		return sequenceFlowEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssociation() {
		return associationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFlowObject() {
		return flowObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGateway() {
		return gatewayEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXOR() {
		return xorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOR() {
		return orEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAND() {
		return andEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStartEvent() {
		return startEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntermediateEvent() {
		return intermediateEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEndEvent() {
		return endEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActivity() {
		return activityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getArtifact() {
		return artifactEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataObject() {
		return dataObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGroup() {
		return groupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGroup_Elements() {
		return (EReference)groupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleBPMNFactory getSimpleBPMNFactory() {
		return (SimpleBPMNFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		businessProcessDiagramEClass = createEClass(BUSINESS_PROCESS_DIAGRAM);
		createEReference(businessProcessDiagramEClass, BUSINESS_PROCESS_DIAGRAM__ELEMENTS);

		bpmnElementEClass = createEClass(BPMN_ELEMENT);
		createEAttribute(bpmnElementEClass, BPMN_ELEMENT__NAME);

		swimlaneEClass = createEClass(SWIMLANE);

		laneEClass = createEClass(LANE);
		createEReference(laneEClass, LANE__FLOW_OBJECTS);

		poolEClass = createEClass(POOL);
		createEReference(poolEClass, POOL__LANES);

		connectingObjectEClass = createEClass(CONNECTING_OBJECT);
		createEReference(connectingObjectEClass, CONNECTING_OBJECT__FROM);
		createEReference(connectingObjectEClass, CONNECTING_OBJECT__TO);

		messageFlowEClass = createEClass(MESSAGE_FLOW);

		sequenceFlowEClass = createEClass(SEQUENCE_FLOW);

		associationEClass = createEClass(ASSOCIATION);

		flowObjectEClass = createEClass(FLOW_OBJECT);

		gatewayEClass = createEClass(GATEWAY);

		xorEClass = createEClass(XOR);

		orEClass = createEClass(OR);

		andEClass = createEClass(AND);

		startEventEClass = createEClass(START_EVENT);

		intermediateEventEClass = createEClass(INTERMEDIATE_EVENT);

		endEventEClass = createEClass(END_EVENT);

		activityEClass = createEClass(ACTIVITY);

		artifactEClass = createEClass(ARTIFACT);

		dataObjectEClass = createEClass(DATA_OBJECT);

		groupEClass = createEClass(GROUP);
		createEReference(groupEClass, GROUP__ELEMENTS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		swimlaneEClass.getESuperTypes().add(this.getBPMNElement());
		laneEClass.getESuperTypes().add(this.getSwimlane());
		poolEClass.getESuperTypes().add(this.getSwimlane());
		connectingObjectEClass.getESuperTypes().add(this.getBPMNElement());
		messageFlowEClass.getESuperTypes().add(this.getConnectingObject());
		sequenceFlowEClass.getESuperTypes().add(this.getConnectingObject());
		associationEClass.getESuperTypes().add(this.getConnectingObject());
		flowObjectEClass.getESuperTypes().add(this.getBPMNElement());
		gatewayEClass.getESuperTypes().add(this.getFlowObject());
		xorEClass.getESuperTypes().add(this.getGateway());
		orEClass.getESuperTypes().add(this.getGateway());
		andEClass.getESuperTypes().add(this.getGateway());
		startEventEClass.getESuperTypes().add(this.getFlowObject());
		intermediateEventEClass.getESuperTypes().add(this.getFlowObject());
		endEventEClass.getESuperTypes().add(this.getFlowObject());
		activityEClass.getESuperTypes().add(this.getFlowObject());
		artifactEClass.getESuperTypes().add(this.getBPMNElement());
		dataObjectEClass.getESuperTypes().add(this.getArtifact());
		groupEClass.getESuperTypes().add(this.getArtifact());

		// Initialize classes and features; add operations and parameters
		initEClass(businessProcessDiagramEClass, BusinessProcessDiagram.class, "BusinessProcessDiagram", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBusinessProcessDiagram_Elements(), this.getBPMNElement(), null, "elements", null, 0, -1, BusinessProcessDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bpmnElementEClass, BPMNElement.class, "BPMNElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBPMNElement_Name(), ecorePackage.getEString(), "name", null, 0, 1, BPMNElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(swimlaneEClass, Swimlane.class, "Swimlane", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(laneEClass, Lane.class, "Lane", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLane_FlowObjects(), this.getFlowObject(), null, "flowObjects", null, 0, -1, Lane.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(poolEClass, Pool.class, "Pool", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPool_Lanes(), this.getLane(), null, "lanes", null, 0, -1, Pool.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(connectingObjectEClass, ConnectingObject.class, "ConnectingObject", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConnectingObject_From(), this.getFlowObject(), null, "from", null, 0, 1, ConnectingObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConnectingObject_To(), this.getFlowObject(), null, "to", null, 0, 1, ConnectingObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(messageFlowEClass, MessageFlow.class, "MessageFlow", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(sequenceFlowEClass, SequenceFlow.class, "SequenceFlow", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(associationEClass, Association.class, "Association", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(flowObjectEClass, FlowObject.class, "FlowObject", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(gatewayEClass, Gateway.class, "Gateway", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(xorEClass, SimpleBPMN.XOR.class, "XOR", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(orEClass, SimpleBPMN.OR.class, "OR", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(andEClass, SimpleBPMN.AND.class, "AND", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(startEventEClass, StartEvent.class, "StartEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(intermediateEventEClass, IntermediateEvent.class, "IntermediateEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(endEventEClass, EndEvent.class, "EndEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(activityEClass, Activity.class, "Activity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(artifactEClass, Artifact.class, "Artifact", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dataObjectEClass, DataObject.class, "DataObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(groupEClass, Group.class, "Group", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGroup_Elements(), this.getBPMNElement(), null, "elements", null, 0, -1, Group.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// gmf
		createGmfAnnotations();
		// gmf.diagram
		createGmf_1Annotations();
		// gmf.node
		createGmf_2Annotations();
		// gmf.compartment
		createGmf_3Annotations();
		// gmf.link
		createGmf_4Annotations();
	}

	/**
	 * Initializes the annotations for <b>gmf</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createGmfAnnotations() {
		String source = "gmf";	
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
		   });
	}

	/**
	 * Initializes the annotations for <b>gmf.diagram</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createGmf_1Annotations() {
		String source = "gmf.diagram";	
		addAnnotation
		  (businessProcessDiagramEClass, 
		   source, 
		   new String[] {
		   });
	}

	/**
	 * Initializes the annotations for <b>gmf.node</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createGmf_2Annotations() {
		String source = "gmf.node";	
		addAnnotation
		  (swimlaneEClass, 
		   source, 
		   new String[] {
			 "label", "name"
		   });	
		addAnnotation
		  (flowObjectEClass, 
		   source, 
		   new String[] {
			 "label", "name"
		   });	
		addAnnotation
		  (xorEClass, 
		   source, 
		   new String[] {
			 "tool.name", "XOR Gateway",
			 "figure", "svg",
			 "svg.uri", "platform:/plugin/org.eclipse.epsilon.eugenia.bpmn/svg/xor-gateway.svg",
			 "label.icon", "false",
			 "label.placement", "external",
			 "resizable", "false",
			 "margin", "2"
		   });	
		addAnnotation
		  (orEClass, 
		   source, 
		   new String[] {
			 "tool.name", "OR Gateway",
			 "figure", "svg",
			 "svg.uri", "platform:/plugin/org.eclipse.epsilon.eugenia.bpmn/svg/or-gateway.svg",
			 "label.icon", "false",
			 "label.placement", "external",
			 "resizable", "false",
			 "margin", "2"
		   });	
		addAnnotation
		  (andEClass, 
		   source, 
		   new String[] {
			 "tool.name", "AND Gateway",
			 "figure", "svg",
			 "svg.uri", "platform:/plugin/org.eclipse.epsilon.eugenia.bpmn/svg/and-gateway.svg",
			 "label.icon", "false",
			 "label.placement", "external",
			 "resizable", "false",
			 "margin", "2"
		   });	
		addAnnotation
		  (startEventEClass, 
		   source, 
		   new String[] {
			 "tool.name", "Start Event",
			 "figure", "svg",
			 "svg.uri", "platform:/plugin/org.eclipse.epsilon.eugenia.bpmn/svg/start-event.svg",
			 "label.icon", "false",
			 "label.placement", "external",
			 "resizable", "false",
			 "margin", "2"
		   });	
		addAnnotation
		  (intermediateEventEClass, 
		   source, 
		   new String[] {
			 "tool.name", "Intermediate Event",
			 "figure", "svg",
			 "svg.uri", "platform:/plugin/org.eclipse.epsilon.eugenia.bpmn/svg/intermediate-event.svg",
			 "label.icon", "false",
			 "label.placement", "external",
			 "resizable", "false",
			 "margin", "2"
		   });	
		addAnnotation
		  (endEventEClass, 
		   source, 
		   new String[] {
			 "tool.name", "End Event",
			 "figure", "svg",
			 "svg.uri", "platform:/plugin/org.eclipse.epsilon.eugenia.bpmn/svg/end-event.svg",
			 "label.icon", "false",
			 "label.placement", "external",
			 "resizable", "false",
			 "margin", "2"
		   });	
		addAnnotation
		  (artifactEClass, 
		   source, 
		   new String[] {
			 "label", "name"
		   });	
		addAnnotation
		  (dataObjectEClass, 
		   source, 
		   new String[] {
			 "tool.name", "Data Object",
			 "figure", "svg",
			 "svg.uri", "platform:/plugin/org.eclipse.epsilon.eugenia.bpmn/svg/data-object.svg",
			 "label.icon", "false",
			 "label.placement", "external",
			 "resizable", "false",
			 "margin", "2"
		   });	
		addAnnotation
		  (groupEClass, 
		   source, 
		   new String[] {
			 "label.placement", "external",
			 "label.icon", "false",
			 "border.style", "dash",
			 "margin", "2"
		   });
	}

	/**
	 * Initializes the annotations for <b>gmf.compartment</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createGmf_3Annotations() {
		String source = "gmf.compartment";	
		addAnnotation
		  (getLane_FlowObjects(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getPool_Lanes(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getGroup_Elements(), 
		   source, 
		   new String[] {
		   });
	}

	/**
	 * Initializes the annotations for <b>gmf.link</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createGmf_4Annotations() {
		String source = "gmf.link";	
		addAnnotation
		  (connectingObjectEClass, 
		   source, 
		   new String[] {
			 "label", "name",
			 "source", "from",
			 "target", "to",
			 "color", "0,0,0"
		   });	
		addAnnotation
		  (messageFlowEClass, 
		   source, 
		   new String[] {
			 "tool.name", "Message Flow",
			 "style", "dash",
			 "target.decoration", "closedarrow"
		   });	
		addAnnotation
		  (sequenceFlowEClass, 
		   source, 
		   new String[] {
			 "tool.name", "Sequence Flow",
			 "target.decoration", "filledclosedarrow"
		   });	
		addAnnotation
		  (associationEClass, 
		   source, 
		   new String[] {
			 "style", "dot",
			 "target.decoration", "arrow"
		   });
	}

} //SimpleBPMNPackageImpl
