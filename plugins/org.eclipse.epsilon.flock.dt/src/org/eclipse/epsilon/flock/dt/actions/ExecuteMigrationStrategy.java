package org.eclipse.epsilon.flock.dt.actions;

import java.net.URI;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.epsilon.common.dt.actions.AbstractObjectActionDelegate;
import org.eclipse.epsilon.common.dt.console.EpsilonConsole;
import org.eclipse.epsilon.commons.parse.problem.ParseProblem;
import org.eclipse.epsilon.emc.emf.AbstractEmfModel;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.flock.FlockModule;
import org.eclipse.epsilon.flock.FlockResult;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;

public class ExecuteMigrationStrategy extends AbstractObjectActionDelegate {
	
	private final MigrationStrategyExtensionLocator locator = new MigrationStrategyExtensionLocator();
	
	private IFile modelFile;
	private IPath originalPath;
	private MigrationStrategyExtension migrationStrategyExtension;
	
	
	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		super.selectionChanged(action, selection);
		
		try {
			if (getFirstElementInSelection() instanceof IFile) {
				modelFile    = (IFile)getFirstElementInSelection();
				originalPath = modelFile.getLocation();
				
				migrationStrategyExtension = locator.findMigrationStrategyExtensionFor(modelFile);
				
				action.setEnabled(migrationStrategyExtension != null);
			}
		
		} catch (MigrationStrategyExtensionLocatorException ex) {
			printError("Error while finding migration strategy for " + modelFile.getName() + ": " + ex.getLocalizedMessage());	
			
		} catch (Exception ex) {
			EpsilonConsole.getInstance().getErrorStream().println(ex.getLocalizedMessage());
		}
	}


	@Override
	public void run(IAction action) {
		try {
			if (getFirstElementInSelection() instanceof IFile) {
				if (migrationStrategyExtension == null) {
					printInfo("No appropriate migration strategy could be found for " + modelFile.getName());
					
				} else {
					createBackup();
					execute(migrationStrategyExtension);
					refreshProjectContaining(modelFile);
				}
			}
		
		} catch (MigrationStrategyExtensionLocatorException ex) {
			printError("Error while finding migration strategy for " + modelFile.getName() + ": " + ex.getLocalizedMessage());	
			
		} catch (Exception ex) {
			EpsilonConsole.getInstance().getErrorStream().println(ex.getLocalizedMessage());
		}
	}	
	
	
	private void createBackup() throws CoreException {		
		final IPath backupPath = createBackupPath();
	
		modelFile.move(backupPath, false, new NullProgressMonitor());
		
		// The move method changes resources, so now the modelFile variable
		// points to a resource that no longer exists.
		
		// Update the modelFile variable to point at the backed up resource		
		modelFile = modelFile.getProject().getFile(backupPath.removeFirstSegments(1));
	}

	private IPath createBackupPath() {
		final IPath originalPath = modelFile.getFullPath();
		
		return originalPath
		       	.removeLastSegments(1)
		       	.append(originalPath.removeFileExtension().lastSegment() + "_backup." + originalPath.getFileExtension());
	}

	
	private void execute(MigrationStrategyExtension extension) throws EolModelLoadingException, Exception {
		executeMigration(extension.getStrategyFile(),
		                 extension.loadOriginalModel(modelFile.getLocation()),
		                 extension.loadMigratedModel(originalPath));
	}

	private void executeMigration(URI strategy, AbstractEmfModel original, AbstractEmfModel migrated) throws Exception {
		final FlockModule migrator = new FlockModule();
	
		if (migrator.parse(strategy) && migrator.getParseProblems().isEmpty()) {
			final FlockResult result = migrator.execute(original, migrated);
			
			result.printWarnings(EpsilonConsole.getInstance().getWarningStream());
			
			migrated.store();
		
		} else {
			printError("Error(s) encountered while parsing migration strategy:");
			for (ParseProblem problem : migrator.getParseProblems()) {
				printError(problem);
			}	
		}
	}
	
	private static void printInfo(Object message) {
		EpsilonConsole.getInstance().getInfoStream().println(message);
	}
	
	private static void printError(Object message) {
		EpsilonConsole.getInstance().getErrorStream().println(message);
	}
}
