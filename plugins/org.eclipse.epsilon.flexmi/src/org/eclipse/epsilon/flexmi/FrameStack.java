package org.eclipse.epsilon.flexmi;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

@SuppressWarnings("serial")
public class FrameStack extends Stack<Map<String, Object>> {
	
	public FrameStack() {
		
	}
	
	public Object getVariable(String name) {
		
		for (int i=0;i<size();i++) {
			Map<String, Object> frame = elementAt(size()-i-1);
			if (frame.containsKey(name)) return frame.get(name);
		}
		return null;
	}
	
	public void setVariable(String name, Object value) {
		peek().put(name, value);
	}
	
	public void pushFrame() {
		push(new HashMap<String, Object>());
	}
	
}
