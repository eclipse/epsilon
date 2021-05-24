package org.eclipse.epsilon.etl.parse;

import java.util.Iterator;

import org.eclipse.epsilon.eol.dom.Parameter;
import org.eclipse.epsilon.erl.parse.ErlUnparser;
import org.eclipse.epsilon.etl.EtlModule;
import org.eclipse.epsilon.etl.dom.IEtlVisitor;
import org.eclipse.epsilon.etl.dom.TransformationRule;

public class EtlUnparser extends ErlUnparser implements IEtlVisitor {

	@Override
	protected void unparseRules() {
		((EtlModule) module).getTransformationRules().forEach(c -> {
			c.accept(this);
			newline();
		});
	}

	@Override
	public void visit(TransformationRule transformationRule) {
		buffer.append("rule ");
		buffer.append(transformationRule.getName());
		newline();
		buffer.append("transform ");
		transformationRule.getSourceParameter().accept(this);
		newline();
		buffer.append("to ");
		Iterator<Parameter> li = transformationRule.getTargetParameters().iterator();
		while (li.hasNext()) {
			li.next().accept(this);
			if (li.hasNext())
				comma();
		}
		printGuard(transformationRule.getGuard());
		newline();
		transformationRule.getBody().accept(this);
	}

}