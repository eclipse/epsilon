/**
 */
package filesystem.impl;

import filesystem.Drive;
import filesystem.File;
import filesystem.Filesystem;
import filesystem.FilesystemFactory;
import filesystem.FilesystemPackage;
import filesystem.Folder;
import filesystem.Shortcut;
import filesystem.Sync;

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
public class FilesystemPackageImpl extends EPackageImpl implements FilesystemPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass filesystemEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass driveEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass folderEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass shortcutEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass syncEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass fileEClass = null;

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
   * @see filesystem.FilesystemPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private FilesystemPackageImpl()
  {
    super(eNS_URI, FilesystemFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link FilesystemPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static FilesystemPackage init()
  {
    if (isInited) return (FilesystemPackage)EPackage.Registry.INSTANCE.getEPackage(FilesystemPackage.eNS_URI);

    // Obtain or create and register package
    FilesystemPackageImpl theFilesystemPackage = (FilesystemPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof FilesystemPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new FilesystemPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theFilesystemPackage.createPackageContents();

    // Initialize created meta-data
    theFilesystemPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theFilesystemPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(FilesystemPackage.eNS_URI, theFilesystemPackage);
    return theFilesystemPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFilesystem()
  {
    return filesystemEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFilesystem_Drives()
  {
    return (EReference)filesystemEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFilesystem_Syncs()
  {
    return (EReference)filesystemEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDrive()
  {
    return driveEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFolder()
  {
    return folderEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFolder_Contents()
  {
    return (EReference)folderEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getShortcut()
  {
    return shortcutEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getShortcut_Target()
  {
    return (EReference)shortcutEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSync()
  {
    return syncEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSync_Source()
  {
    return (EReference)syncEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSync_Target()
  {
    return (EReference)syncEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSync_LastSync()
  {
    return (EAttribute)syncEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFile()
  {
    return fileEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFile_Name()
  {
    return (EAttribute)fileEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FilesystemFactory getFilesystemFactory()
  {
    return (FilesystemFactory)getEFactoryInstance();
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
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    filesystemEClass = createEClass(FILESYSTEM);
    createEReference(filesystemEClass, FILESYSTEM__DRIVES);
    createEReference(filesystemEClass, FILESYSTEM__SYNCS);

    driveEClass = createEClass(DRIVE);

    folderEClass = createEClass(FOLDER);
    createEReference(folderEClass, FOLDER__CONTENTS);

    shortcutEClass = createEClass(SHORTCUT);
    createEReference(shortcutEClass, SHORTCUT__TARGET);

    syncEClass = createEClass(SYNC);
    createEReference(syncEClass, SYNC__SOURCE);
    createEReference(syncEClass, SYNC__TARGET);
    createEAttribute(syncEClass, SYNC__LAST_SYNC);

    fileEClass = createEClass(FILE);
    createEAttribute(fileEClass, FILE__NAME);
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
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    driveEClass.getESuperTypes().add(this.getFolder());
    folderEClass.getESuperTypes().add(this.getFile());
    shortcutEClass.getESuperTypes().add(this.getFile());

    // Initialize classes and features; add operations and parameters
    initEClass(filesystemEClass, Filesystem.class, "Filesystem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFilesystem_Drives(), this.getDrive(), null, "drives", null, 0, -1, Filesystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFilesystem_Syncs(), this.getSync(), null, "syncs", null, 0, -1, Filesystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(driveEClass, Drive.class, "Drive", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(folderEClass, Folder.class, "Folder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFolder_Contents(), this.getFile(), null, "contents", null, 0, -1, Folder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(shortcutEClass, Shortcut.class, "Shortcut", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getShortcut_Target(), this.getFile(), null, "target", null, 0, 1, Shortcut.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(syncEClass, Sync.class, "Sync", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSync_Source(), this.getFile(), null, "source", null, 0, 1, Sync.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSync_Target(), this.getFile(), null, "target", null, 0, 1, Sync.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSync_LastSync(), ecorePackage.getEString(), "lastSync", null, 0, 1, Sync.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(fileEClass, File.class, "File", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getFile_Name(), ecorePackage.getEString(), "name", null, 0, 1, File.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);

    // Create annotations
    // gmf
    createGmfAnnotations();
    // gmf.diagram
    createGmf_1Annotations();
    // gmf.compartment
    createGmf_2Annotations();
    // gmf.link
    createGmf_3Annotations();
    // gmf.node
    createGmf_4Annotations();
  }

  /**
   * Initializes the annotations for <b>gmf</b>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void createGmfAnnotations()
  {
    String source = "gmf";		
    addAnnotation
      (this, 
       source, 
       new String[] 
       {
       });					
  }

  /**
   * Initializes the annotations for <b>gmf.diagram</b>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void createGmf_1Annotations()
  {
    String source = "gmf.diagram";			
    addAnnotation
      (filesystemEClass, 
       source, 
       new String[] 
       {
       });				
  }

  /**
   * Initializes the annotations for <b>gmf.compartment</b>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void createGmf_2Annotations()
  {
    String source = "gmf.compartment";				
    addAnnotation
      (getFolder_Contents(), 
       source, 
       new String[] 
       {
       });			
  }

  /**
   * Initializes the annotations for <b>gmf.link</b>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void createGmf_3Annotations()
  {
    String source = "gmf.link";					
    addAnnotation
      (getShortcut_Target(), 
       source, 
       new String[] 
       {
       "target.decoration", "arrow",
       "style", "dash"
       });		
    addAnnotation
      (syncEClass, 
       source, 
       new String[] 
       {
       "label", "lastSync",
       "source", "source",
       "target", "target",
       "style", "dot",
       "width", "2"
       });	
  }

  /**
   * Initializes the annotations for <b>gmf.node</b>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void createGmf_4Annotations()
  {
    String source = "gmf.node";							
    addAnnotation
      (fileEClass, 
       source, 
       new String[] 
       {
       "label", "name"
       });
  }

} //FilesystemPackageImpl
