/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.workflow.tasks;

import java.util.Collection;

import org.apache.tools.ant.input.InputHandler;
import org.apache.tools.ant.input.InputRequest;
import org.eclipse.epsilon.eol.exceptions.EolUserException;
import org.eclipse.epsilon.eol.userinput.AbstractUserInput;

public class AntUserInput extends AbstractUserInput{
	
	protected InputHandler inputHandler;
	
	public AntUserInput(InputHandler inputHandler) {
		this.inputHandler = inputHandler;
	}
	
	@Override
	public Object choose(String question, Collection<?> choices, Object default_) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean confirm(String question, boolean default_)
			throws EolUserException {
		// TODO Auto-generated method stub
		return false;
	}
 
	@Override
	public String prompt(String question, String default_) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int promptInteger(String question, int default_) {
		IntegerInputRequest request = new IntegerInputRequest(question);
		request.setDefaultValue(default_ + "");
		inputHandler.handleInput(request);
		return Integer.valueOf(request.getInput());
	}

	@Override
	public float promptReal(String question, float default_) {
		// For backwards compatibility
		return 0;
	}

	@Override
	public double promptReal(String question, double default_) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	class IntegerInputRequest extends InputRequest {

		public IntegerInputRequest(String prompt) {
			super(prompt);
		}

		@Override
		public boolean isInputValid() {
			try {
				Integer.parseInt(this.getInput());
				return true;
			}
			catch (Exception ex) {
				return false;
			}
		}
		
	}

	@Override
	public void inform(String message) {

	}

	@Override
	public Object chooseMany(String question, Collection<?> choices,
			Collection<?> default_) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
