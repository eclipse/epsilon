/**
 */
package rcpapp.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import rcpapp.Model;
import rcpapp.RcpappFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModelTest extends TestCase
{

  /**
   * The fixture for this Model test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Model fixture = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static void main(String[] args)
  {
    TestRunner.run(ModelTest.class);
  }

  /**
   * Constructs a new Model test case with the given name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ModelTest(String name)
  {
    super(name);
  }

  /**
   * Sets the fixture for this Model test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void setFixture(Model fixture)
  {
    this.fixture = fixture;
  }

  /**
   * Returns the fixture for this Model test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Model getFixture()
  {
    return fixture;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see junit.framework.TestCase#setUp()
   * @generated
   */
  @Override
  protected void setUp() throws Exception
  {
    setFixture(RcpappFactory.eINSTANCE.createModel());
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see junit.framework.TestCase#tearDown()
   * @generated
   */
  @Override
  protected void tearDown() throws Exception
  {
    setFixture(null);
  }

} //ModelTest
