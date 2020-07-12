package org.eclipse.epsilon.picto;

import java.util.ArrayList;
import java.util.List;

public class CommandStack {
	
	protected List<Command> stack = new ArrayList<Command>();
	protected int stackPointer = 0;
	protected boolean executing = false;
	
	public void execute(Command command) {
		stack = stack.subList(0, stackPointer);
		command.execute();
		stack.add(command);
		stackPointer ++;
	}
	
	public void undo() {
		stackPointer--;
		stack.get(stackPointer-1).execute();
	}
	
	public boolean canUndo() {
		return stackPointer > 1;
	}
	
	public void redo() {
		stack.get(stackPointer).execute();
		stackPointer++;
	}
	
	public boolean canRedo() {
		return stackPointer < stack.size();
	}
	
}
