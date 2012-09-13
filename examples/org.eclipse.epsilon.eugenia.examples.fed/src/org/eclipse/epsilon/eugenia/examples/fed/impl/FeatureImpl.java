/**
 */
package org.eclipse.epsilon.eugenia.examples.fed.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.epsilon.eugenia.examples.fed.Feature;
import org.eclipse.epsilon.eugenia.examples.fed.FedPackage;
import org.eclipse.epsilon.eugenia.examples.fed.Plugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.eugenia.examples.fed.impl.FeatureImpl#getPlugins <em>Plugins</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eugenia.examples.fed.impl.FeatureImpl#getDepends <em>Depends</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eugenia.examples.fed.impl.FeatureImpl#getIncludes <em>Includes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FeatureImpl extends NamedElementImpl implements Feature
{
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
   * The cached value of the '{@link #getDepends() <em>Depends</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDepends()
   * @generated
   * @ordered
   */
  protected EList<Feature> depends;
  /**
   * The cached value of the '{@link #getIncludes() <em>Includes</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIncludes()
   * @generated
   * @ordered
   */
  protected EList<Feature> includes;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FeatureImpl()
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
    return FedPackage.Literals.FEATURE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Plugin> getPlugins()
  {
    if (plugins == null)
    {
      plugins = new EObjectContainmentEList<Plugin>(Plugin.class, this, FedPackage.FEATURE__PLUGINS);
    }
    return plugins;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Feature> getDepends()
  {
    if (depends == null)
    {
      depends = new EObjectResolvingEList<Feature>(Feature.class, this, FedPackage.FEATURE__DEPENDS);
    }
    return depends;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Feature> getIncludes()
  {
    if (includes == null)
    {
      includes = new EObjectResolvingEList<Feature>(Feature.class, this, FedPackage.FEATURE__INCLUDES);
    }
    return includes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case FedPackage.FEATURE__PLUGINS:
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
    switch (featureID)
    {
      case FedPackage.FEATURE__PLUGINS:
        return getPlugins();
      case FedPackage.FEATURE__DEPENDS:
        return getDepends();
      case FedPackage.FEATURE__INCLUDES:
        return getIncludes();
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
    switch (featureID)
    {
      case FedPackage.FEATURE__PLUGINS:
        getPlugins().clear();
        getPlugins().addAll((Collection<? extends Plugin>)newValue);
        return;
      case FedPackage.FEATURE__DEPENDS:
        getDepends().clear();
        getDepends().addAll((Collection<? extends Feature>)newValue);
        return;
      case FedPackage.FEATURE__INCLUDES:
        getIncludes().clear();
        getIncludes().addAll((Collection<? extends Feature>)newValue);
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
    switch (featureID)
    {
      case FedPackage.FEATURE__PLUGINS:
        getPlugins().clear();
        return;
      case FedPackage.FEATURE__DEPENDS:
        getDepends().clear();
        return;
      case FedPackage.FEATURE__INCLUDES:
        getIncludes().clear();
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
    switch (featureID)
    {
      case FedPackage.FEATURE__PLUGINS:
        return plugins != null && !plugins.isEmpty();
      case FedPackage.FEATURE__DEPENDS:
        return depends != null && !depends.isEmpty();
      case FedPackage.FEATURE__INCLUDES:
        return includes != null && !includes.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //FeatureImpl
