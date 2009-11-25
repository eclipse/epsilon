/*
 * 
 */
package filesystem.diagram.part;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import filesystem.FilesystemPackage;

/**
 * @generated
 */
public class FilesystemDomainModelElementTester extends PropertyTester {

	/**
	 * @generated
	 */
	public boolean test(Object receiver, String method, Object[] args,
			Object expectedValue) {
		if (false == receiver instanceof EObject) {
			return false;
		}
		EObject eObject = (EObject) receiver;
		EClass eClass = eObject.eClass();
		if (eClass == FilesystemPackage.eINSTANCE.getFilesystem()) {
			return true;
		}
		if (eClass == FilesystemPackage.eINSTANCE.getDrive()) {
			return true;
		}
		if (eClass == FilesystemPackage.eINSTANCE.getFolder()) {
			return true;
		}
		if (eClass == FilesystemPackage.eINSTANCE.getShortcut()) {
			return true;
		}
		if (eClass == FilesystemPackage.eINSTANCE.getSync()) {
			return true;
		}
		if (eClass == FilesystemPackage.eINSTANCE.getFile()) {
			return true;
		}
		return false;
	}

}
