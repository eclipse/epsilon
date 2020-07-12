package org.eclipse.epsilon.picto;

import java.util.ArrayList;
import java.util.List;

public class CommandHistory {
	
	protected List<Command> stack = new ArrayList<Command>();
	protected int stackPointer = 0;
	protected boolean executing = false;
	
	public void execute(Command command) {
		stack = stack.subList(0, stackPointer);
		command.execute();
		stack.add(command);
		stackPointer ++;
	}
	
	public void goBack() {
		stackPointer--;
		stack.get(stackPointer-1).execute();
	}
	
	public boolean canGoBack() {
		return stackPointer > 1;
	}
	
	public void goForward() {
		stack.get(stackPointer).execute();
		stackPointer++;
	}
	
	public boolean canGoForward() {
		return stackPointer < stack.size();
	}
	
}
