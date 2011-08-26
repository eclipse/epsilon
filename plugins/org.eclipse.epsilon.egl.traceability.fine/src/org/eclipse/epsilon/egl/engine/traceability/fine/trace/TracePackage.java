/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.epsilon.egl.engine.traceability.fine.trace;

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
 * @see org.eclipse.epsilon.egl.engine.traceability.fine.trace.TraceFactory
 * @model kind="package"
 * @generated
 */
public interface TracePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "trace";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/gmt/epsilon/egl/trace";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "trace";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TracePackage eINSTANCE = org.eclipse.epsilon.egl.engine.traceability.fine.trace.impl.TracePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.egl.engine.traceability.fine.trace.impl.TraceImpl <em>Trace</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.egl.engine.traceability.fine.trace.impl.TraceImpl
	 * @see org.eclipse.epsilon.egl.engine.traceability.fine.trace.impl.TracePackageImpl#getTrace()
	 * @generated
	 */
	int TRACE = 0;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE__ELEMENTS = 0;

	/**
	 * The feature id for the '<em><b>Locations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE__LOCATIONS = 1;

	/**
	 * The number of structural features of the '<em>Trace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.egl.engine.traceability.fine.trace.impl.TraceElementImpl <em>Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.egl.engine.traceability.fine.trace.impl.TraceElementImpl
	 * @see org.eclipse.epsilon.egl.engine.traceability.fine.trace.impl.TracePackageImpl#getTraceElement()
	 * @generated
	 */
	int TRACE_ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_ELEMENT__SOURCE = 0;

	/**
	 * The feature id for the '<em><b>Destination</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_ELEMENT__DESTINATION = 1;

	/**
	 * The number of structural features of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_ELEMENT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.egl.engine.traceability.fine.trace.impl.ModelLocationImpl <em>Model Location</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.egl.engine.traceability.fine.trace.impl.ModelLocationImpl
	 * @see org.eclipse.epsilon.egl.engine.traceability.fine.trace.impl.TracePackageImpl#getModelLocation()
	 * @generated
	 */
	int MODEL_LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Model Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_LOCATION__MODEL_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_LOCATION__FEATURE_NAME = 1;

	/**
	 * The number of structural features of the '<em>Model Location</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_LOCATION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.egl.engine.traceability.fine.trace.impl.TextLocationImpl <em>Text Location</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.egl.engine.traceability.fine.trace.impl.TextLocationImpl
	 * @see org.eclipse.epsilon.egl.engine.traceability.fine.trace.impl.TracePackageImpl#getTextLocation()
	 * @generated
	 */
	int TEXT_LOCATION = 3;

	/**
	 * The feature id for the '<em><b>Resources</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_LOCATION__RESOURCES = 0;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_LOCATION__REGION = 1;

	/**
	 * The number of structural features of the '<em>Text Location</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_LOCATION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.egl.engine.traceability.fine.trace.impl.RegionImpl <em>Region</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.egl.engine.traceability.fine.trace.impl.RegionImpl
	 * @see org.eclipse.epsilon.egl.engine.traceability.fine.trace.impl.TracePackageImpl#getRegion()
	 * @generated
	 */
	int REGION = 4;

	/**
	 * The feature id for the '<em><b>Start</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION__START = 0;

	/**
	 * The feature id for the '<em><b>End</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION__END = 1;

	/**
	 * The number of structural features of the '<em>Region</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.egl.engine.traceability.fine.trace.impl.PositionImpl <em>Position</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.egl.engine.traceability.fine.trace.impl.PositionImpl
	 * @see org.eclipse.epsilon.egl.engine.traceability.fine.trace.impl.TracePackageImpl#getPosition()
	 * @generated
	 */
	int POSITION = 5;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSITION__LINE = 0;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSITION__COLUMN = 1;

	/**
	 * The number of structural features of the '<em>Position</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSITION_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.egl.engine.traceability.fine.trace.Trace <em>Trace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trace</em>'.
	 * @see org.eclipse.epsilon.egl.engine.traceability.fine.trace.Trace
	 * @generated
	 */
	EClass getTrace();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.epsilon.egl.engine.traceability.fine.trace.Trace#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see org.eclipse.epsilon.egl.engine.traceability.fine.trace.Trace#getElements()
	 * @see #getTrace()
	 * @generated
	 */
	EReference getTrace_Elements();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.epsilon.egl.engine.traceability.fine.trace.Trace#getLocations <em>Locations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Locations</em>'.
	 * @see org.eclipse.epsilon.egl.engine.traceability.fine.trace.Trace#getLocations()
	 * @see #getTrace()
	 * @generated
	 */
	EReference getTrace_Locations();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.egl.engine.traceability.fine.trace.TraceElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see org.eclipse.epsilon.egl.engine.traceability.fine.trace.TraceElement
	 * @generated
	 */
	EClass getTraceElement();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.egl.engine.traceability.fine.trace.TraceElement#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Source</em>'.
	 * @see org.eclipse.epsilon.egl.engine.traceability.fine.trace.TraceElement#getSource()
	 * @see #getTraceElement()
	 * @generated
	 */
	EReference getTraceElement_Source();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.epsilon.egl.engine.traceability.fine.trace.TraceElement#getDestination <em>Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Destination</em>'.
	 * @see org.eclipse.epsilon.egl.engine.traceability.fine.trace.TraceElement#getDestination()
	 * @see #getTraceElement()
	 * @generated
	 */
	EReference getTraceElement_Destination();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.egl.engine.traceability.fine.trace.ModelLocation <em>Model Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Location</em>'.
	 * @see org.eclipse.epsilon.egl.engine.traceability.fine.trace.ModelLocation
	 * @generated
	 */
	EClass getModelLocation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.epsilon.egl.engine.traceability.fine.trace.ModelLocation#getModelElement <em>Model Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Model Element</em>'.
	 * @see org.eclipse.epsilon.egl.engine.traceability.fine.trace.ModelLocation#getModelElement()
	 * @see #getModelLocation()
	 * @generated
	 */
	EReference getModelLocation_ModelElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.epsilon.egl.engine.traceability.fine.trace.ModelLocation#getFeatureName <em>Feature Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Feature Name</em>'.
	 * @see org.eclipse.epsilon.egl.engine.traceability.fine.trace.ModelLocation#getFeatureName()
	 * @see #getModelLocation()
	 * @generated
	 */
	EAttribute getModelLocation_FeatureName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.egl.engine.traceability.fine.trace.TextLocation <em>Text Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Text Location</em>'.
	 * @see org.eclipse.epsilon.egl.engine.traceability.fine.trace.TextLocation
	 * @generated
	 */
	EClass getTextLocation();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.epsilon.egl.engine.traceability.fine.trace.TextLocation#getResources <em>Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Resources</em>'.
	 * @see org.eclipse.epsilon.egl.engine.traceability.fine.trace.TextLocation#getResources()
	 * @see #getTextLocation()
	 * @generated
	 */
	EAttribute getTextLocation_Resources();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.egl.engine.traceability.fine.trace.TextLocation#getRegion <em>Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Region</em>'.
	 * @see org.eclipse.epsilon.egl.engine.traceability.fine.trace.TextLocation#getRegion()
	 * @see #getTextLocation()
	 * @generated
	 */
	EReference getTextLocation_Region();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.egl.engine.traceability.fine.trace.Region <em>Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Region</em>'.
	 * @see org.eclipse.epsilon.egl.engine.traceability.fine.trace.Region
	 * @generated
	 */
	EClass getRegion();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.egl.engine.traceability.fine.trace.Region#getStart <em>Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Start</em>'.
	 * @see org.eclipse.epsilon.egl.engine.traceability.fine.trace.Region#getStart()
	 * @see #getRegion()
	 * @generated
	 */
	EReference getRegion_Start();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.egl.engine.traceability.fine.trace.Region#getEnd <em>End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>End</em>'.
	 * @see org.eclipse.epsilon.egl.engine.traceability.fine.trace.Region#getEnd()
	 * @see #getRegion()
	 * @generated
	 */
	EReference getRegion_End();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.egl.engine.traceability.fine.trace.Position <em>Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Position</em>'.
	 * @see org.eclipse.epsilon.egl.engine.traceability.fine.trace.Position
	 * @generated
	 */
	EClass getPosition();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.epsilon.egl.engine.traceability.fine.trace.Position#getLine <em>Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line</em>'.
	 * @see org.eclipse.epsilon.egl.engine.traceability.fine.trace.Position#getLine()
	 * @see #getPosition()
	 * @generated
	 */
	EAttribute getPosition_Line();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.epsilon.egl.engine.traceability.fine.trace.Position#getColumn <em>Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Column</em>'.
	 * @see org.eclipse.epsilon.egl.engine.traceability.fine.trace.Position#getColumn()
	 * @see #getPosition()
	 * @generated
	 */
	EAttribute getPosition_Column();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TraceFactory getTraceFactory();

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
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.egl.engine.traceability.fine.trace.impl.TraceImpl <em>Trace</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.egl.engine.traceability.fine.trace.impl.TraceImpl
		 * @see org.eclipse.epsilon.egl.engine.traceability.fine.trace.impl.TracePackageImpl#getTrace()
		 * @generated
		 */
		EClass TRACE = eINSTANCE.getTrace();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE__ELEMENTS = eINSTANCE.getTrace_Elements();

		/**
		 * The meta object literal for the '<em><b>Locations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE__LOCATIONS = eINSTANCE.getTrace_Locations();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.egl.engine.traceability.fine.trace.impl.TraceElementImpl <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.egl.engine.traceability.fine.trace.impl.TraceElementImpl
		 * @see org.eclipse.epsilon.egl.engine.traceability.fine.trace.impl.TracePackageImpl#getTraceElement()
		 * @generated
		 */
		EClass TRACE_ELEMENT = eINSTANCE.getTraceElement();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE_ELEMENT__SOURCE = eINSTANCE.getTraceElement_Source();

		/**
		 * The meta object literal for the '<em><b>Destination</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE_ELEMENT__DESTINATION = eINSTANCE.getTraceElement_Destination();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.egl.engine.traceability.fine.trace.impl.ModelLocationImpl <em>Model Location</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.egl.engine.traceability.fine.trace.impl.ModelLocationImpl
		 * @see org.eclipse.epsilon.egl.engine.traceability.fine.trace.impl.TracePackageImpl#getModelLocation()
		 * @generated
		 */
		EClass MODEL_LOCATION = eINSTANCE.getModelLocation();

		/**
		 * The meta object literal for the '<em><b>Model Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_LOCATION__MODEL_ELEMENT = eINSTANCE.getModelLocation_ModelElement();

		/**
		 * The meta object literal for the '<em><b>Feature Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_LOCATION__FEATURE_NAME = eINSTANCE.getModelLocation_FeatureName();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.egl.engine.traceability.fine.trace.impl.TextLocationImpl <em>Text Location</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.egl.engine.traceability.fine.trace.impl.TextLocationImpl
		 * @see org.eclipse.epsilon.egl.engine.traceability.fine.trace.impl.TracePackageImpl#getTextLocation()
		 * @generated
		 */
		EClass TEXT_LOCATION = eINSTANCE.getTextLocation();

		/**
		 * The meta object literal for the '<em><b>Resources</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXT_LOCATION__RESOURCES = eINSTANCE.getTextLocation_Resources();

		/**
		 * The meta object literal for the '<em><b>Region</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEXT_LOCATION__REGION = eINSTANCE.getTextLocation_Region();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.egl.engine.traceability.fine.trace.impl.RegionImpl <em>Region</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.egl.engine.traceability.fine.trace.impl.RegionImpl
		 * @see org.eclipse.epsilon.egl.engine.traceability.fine.trace.impl.TracePackageImpl#getRegion()
		 * @generated
		 */
		EClass REGION = eINSTANCE.getRegion();

		/**
		 * The meta object literal for the '<em><b>Start</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REGION__START = eINSTANCE.getRegion_Start();

		/**
		 * The meta object literal for the '<em><b>End</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REGION__END = eINSTANCE.getRegion_End();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.egl.engine.traceability.fine.trace.impl.PositionImpl <em>Position</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.egl.engine.traceability.fine.trace.impl.PositionImpl
		 * @see org.eclipse.epsilon.egl.engine.traceability.fine.trace.impl.TracePackageImpl#getPosition()
		 * @generated
		 */
		EClass POSITION = eINSTANCE.getPosition();

		/**
		 * The meta object literal for the '<em><b>Line</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POSITION__LINE = eINSTANCE.getPosition_Line();

		/**
		 * The meta object literal for the '<em><b>Column</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POSITION__COLUMN = eINSTANCE.getPosition_Column();

	}

} //TracePackage
