/*
 * 
 */
package filesystem.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

import filesystem.File;
import filesystem.Filesystem;
import filesystem.Sync;
import filesystem.diagram.edit.policies.FilesystemBaseItemSemanticEditPolicy;

/**
 * @generated
 */
public class SyncReorientCommand extends EditElementCommand {

	/**
	 * @generated
	 */
	private final int reorientDirection;

	/**
	 * @generated
	 */
	private final EObject oldEnd;

	/**
	 * @generated
	 */
	private final EObject newEnd;

	/**
	 * @generated
	 */
	public SyncReorientCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		if (false == getElementToEdit() instanceof Sync) {
			return false;
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
			return canReorientSource();
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
			return canReorientTarget();
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean canReorientSource() {
		if (!(oldEnd instanceof File && newEnd instanceof File)) {
			return false;
		}
		File target = getLink().getTarget();
		if (!(getLink().eContainer() instanceof Filesystem)) {
			return false;
		}
		Filesystem container = (Filesystem) getLink().eContainer();
		return FilesystemBaseItemSemanticEditPolicy.LinkConstraints
				.canExistSync_4001(container, getNewSource(), target);
	}

	/**
	 * @generated
	 */
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof File && newEnd instanceof File)) {
			return false;
		}
		File source = getLink().getSource();
		if (!(getLink().eContainer() instanceof Filesystem)) {
			return false;
		}
		Filesystem container = (Filesystem) getLink().eContainer();
		return FilesystemBaseItemSemanticEditPolicy.LinkConstraints
				.canExistSync_4001(container, source, getNewTarget());
	}

	/**
	 * @generated
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info) throws ExecutionException {
		if (!canExecute()) {
			throw new ExecutionException(
					"Invalid arguments in reorient link command"); //$NON-NLS-1$
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
			return reorientSource();
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
			return reorientTarget();
		}
		throw new IllegalStateException();
	}

	/**
	 * @generated
	 */
	protected CommandResult reorientSource() throws ExecutionException {
		getLink().setSource(getNewSource());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated
	 */
	protected CommandResult reorientTarget() throws ExecutionException {
		getLink().setTarget(getNewTarget());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated
	 */
	protected Sync getLink() {
		return (Sync) getElementToEdit();
	}

	/**
	 * @generated
	 */
	protected File getOldSource() {
		return (File) oldEnd;
	}

	/**
	 * @generated
	 */
	protected File getNewSource() {
		return (File) newEnd;
	}

	/**
	 * @generated
	 */
	protected File getOldTarget() {
		return (File) oldEnd;
	}

	/**
	 * @generated
	 */
	protected File getNewTarget() {
		return (File) newEnd;
	}
}
