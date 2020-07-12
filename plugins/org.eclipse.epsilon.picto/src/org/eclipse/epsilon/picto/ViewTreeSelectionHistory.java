package org.eclipse.epsilon.picto;

public class ViewTreeSelectionHistory extends CommandHistory {
	
	protected boolean automatedSelection = false;
	
	public boolean isAutomatedSelection() {
		return automatedSelection;
	}
	
	public void setAutomatedSelection(boolean automatedSelection) {
		this.automatedSelection = automatedSelection;
	}
	
}
