/**
 */
package org.eclipse.epsilon.eugenia.examples.fed.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.epsilon.eugenia.examples.fed.Configuration;
import org.eclipse.epsilon.eugenia.examples.fed.Feature;
import org.eclipse.epsilon.eugenia.examples.fed.FedPackage;
import org.eclipse.epsilon.eugenia.examples.fed.Plugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.eugenia.examples.fed.impl.ConfigurationImpl#getFeatures <em>Features</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eugenia.examples.fed.impl.ConfigurationImpl#getPlugins <em>Plugins</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConfigurationImpl extends EObjectImpl implements Configuration
{
  /**
	 * The cached value of the '{@link #getFeatures() <em>Features</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getFeatures()
	 * @generated
	 * @ordered
	 */
  protected EList<Feature> features;

  /**
	 * The cached value of the '{@link #getPlugins() <em>Plugins</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getPlugins()
	 * @generated
	 * @ordered
	 */
  protected EList<Plugin> plugins;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected ConfigurationImpl()
  {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass()
  {
		return FedPackage.Literals.CONFIGURATION;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<Feature> getFeatures()
  {
		if (features == null) {
			features = new EObjectContainmentEList<Feature>(Feature.class, this, FedPackage.CONFIGURATION__FEATURES);
		}
		return features;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<Plugin> getPlugins()
  {
		if (plugins == null) {
			plugins = new EObjectContainmentEList<Plugin>(Plugin.class, this, FedPackage.CONFIGURATION__PLUGINS);
		}
		return plugins;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
		switch (featureID) {
			case FedPackage.CONFIGURATION__FEATURES:
				return ((InternalEList<?>)getFeatures()).basicRemove(otherEnd, msgs);
			case FedPackage.CONFIGURATION__PLUGINS:
				return ((InternalEList<?>)getPlugins()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
		switch (featureID) {
			case FedPackage.CONFIGURATION__FEATURES:
				return getFeatures();
			case FedPackage.CONFIGURATION__PLUGINS:
				return getPlugins();
		}
		return super.eGet(featureID, resolve, coreType);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
		switch (featureID) {
			case FedPackage.CONFIGURATION__FEATURES:
				getFeatures().clear();
				getFeatures().addAll((Collection<? extends Feature>)newValue);
				return;
			case FedPackage.CONFIGURATION__PLUGINS:
				getPlugins().clear();
				getPlugins().addAll((Collection<? extends Plugin>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public void eUnset(int featureID)
  {
		switch (featureID) {
			case FedPackage.CONFIGURATION__FEATURES:
				getFeatures().clear();
				return;
			case FedPackage.CONFIGURATION__PLUGINS:
				getPlugins().clear();
				return;
		}
		super.eUnset(featureID);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public boolean eIsSet(int featureID)
  {
		switch (featureID) {
			case FedPackage.CONFIGURATION__FEATURES:
				return features != null && !features.isEmpty();
			case FedPackage.CONFIGURATION__PLUGINS:
				return plugins != null && !plugins.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ConfigurationImpl
