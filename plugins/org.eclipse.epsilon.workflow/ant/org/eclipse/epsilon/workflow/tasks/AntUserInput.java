/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
	
	public Object choose(String question, Collection choices, Object default_) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean confirm(String question, boolean default_)
			throws EolUserException {
		// TODO Auto-generated method stub
	
		return false;
		
	}
 
	public String prompt(String question, String default_) {
		// TODO Auto-generated method stub
		return null;
	}

	public int promptInteger(String question, int default_) {
		
		IntegerInputRequest request = new IntegerInputRequest(question);
		request.setDefaultValue(default_ + "");
		inputHandler.handleInput(request);
		return new Integer(request.getInput()).intValue();
	}

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
				new Integer(this.getInput());
				return true;
			}
			catch (Exception ex) {
				return false;
			}
		}
		
	}

	public void inform(String message) {

	}

	public Object chooseMany(String question, Collection choices,
			Collection default_) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
