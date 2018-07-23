/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.common.parse;

public class Region {
	
	protected Position start = new Position(0, 0);
	protected Position end = new Position(0, 0); 
	
	public Region() {}
	
	public Region(int startLine, int startColumn, int endLine, int endColumn) {
		this.start = new Position(startLine, startColumn);
		this.end = new Position(endLine, endColumn);
	}
	
	public Region clone() {
		return new Region(getStart().getLine(), getStart().getColumn(), getEnd().getLine(), getEnd().getColumn());
	}
	
	public Position getStart() {
		return start;
	}
	
	public Position getEnd() {
		return end;
	}
	
	public void setStart(Position start) {
		this.start = start;
	}
	
	public void setEnd(Position end) {
		this.end = end;
	}
	
	@Override
	public String toString() {
		return start + "-" + end;
	}
	
}
