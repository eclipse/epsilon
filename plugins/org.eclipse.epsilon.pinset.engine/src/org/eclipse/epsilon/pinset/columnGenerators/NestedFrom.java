/*********************************************************************
 * Copyright (c) 2020 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *********************************************************************/
package org.eclipse.epsilon.pinset.columnGenerators;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.dom.AnnotatableModuleElement;
import org.eclipse.epsilon.eol.dom.IExecutableModuleElement;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.execute.introspection.IPropertyGetter;
import org.eclipse.epsilon.pinset.DatasetRule;

/**
 * NestedFrom.
 *
 * @author Alfonso de la Vega
 * @since 2.1
 */
public class NestedFrom extends AnnotatableModuleElement
		implements ColumnGenerator {

	protected String fromElementName;
	protected IExecutableModuleElement fromElementBlock;
	protected List<ColumnGenerator> generators = new ArrayList<ColumnGenerator>();

	protected IEolContext context;

	@Override
	public void build(AST cst, IModule module) {
		super.build(cst, module);
		fromElementName = (String) cst.getFirstChild().getText();
		fromElementBlock = (IExecutableModuleElement) module.createAst(cst.getSecondChild(), this);
		// loop over children looking for column generators
		for (AST child : cst.getChildren()) {
			if (DatasetRule.isColumnGenerator(child)) {
				generators.add((ColumnGenerator) module.createAst(child, this));
			}
		}
	}

	@Override
	public List<String> getNames() throws EolRuntimeException {
		List<String> columnNames = new ArrayList<String>();
		for (ColumnGenerator generator : generators) {
			List<String> genNames = generator.getNames();
			for (String name : genNames) {
				columnNames.add(getColumnName(name));
			}
		}
		return columnNames;
	}

	private String getColumnName(String columnName) {
		return fromElementName + "_" + columnName;
	}

	@Override
	public List<Object> getValues(Object elem) throws EolRuntimeException {
		List<Object> rowValues = new ArrayList<Object>();
		context.getFrameStack().enterLocal(FrameType.UNPROTECTED, this);
		Object fromElement = context.getExecutorFactory().execute(fromElementBlock,
				context);
		if (fromElement == null) {
			// add a blank per defined column
			for (@SuppressWarnings("unused")
			String values : getNames()) {
				rowValues.add(null);
			}
		}
		else {
			context.getFrameStack().put(
					Variable.createReadOnlyVariable(fromElementName, fromElement));
			for (ColumnGenerator generator : generators) {
				List<Object> values = generator.getValues(fromElement);
				rowValues.addAll(values);
				// if we calculate a column, we add it to the stack so it can be used
				//    in later column calculations. We know that values only has 1 elem
				if (generator instanceof Column) {
					context.getFrameStack().put(
							Variable.createReadOnlyVariable(((Column) generator).getName(),
									values.get(0)));
				}
			}
		}
		context.getFrameStack().leaveLocal(this);
		return rowValues;
	}

	public void initialise(IEolContext context, IPropertyGetter getter) {
		this.context = context;
		for (ColumnGenerator generator : generators) {
			DatasetRule.initialise(generator, context, getter);
		}
	}

	public void setSilent(boolean isSilent) {
		for (ColumnGenerator colGen : generators) {
			DatasetRule.setSilent(colGen, isSilent);
		}
	}
}
