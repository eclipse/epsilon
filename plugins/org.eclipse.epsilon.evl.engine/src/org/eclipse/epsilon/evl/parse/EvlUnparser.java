package org.eclipse.epsilon.evl.parse;

import org.eclipse.epsilon.eol.dom.ExecutableBlock;
import org.eclipse.epsilon.eol.dom.Expression;
import org.eclipse.epsilon.eol.dom.StatementBlock;
import org.eclipse.epsilon.erl.parse.ErlUnparser;
import org.eclipse.epsilon.evl.EvlModule;
import org.eclipse.epsilon.evl.dom.Constraint;
import org.eclipse.epsilon.evl.dom.ConstraintContext;
import org.eclipse.epsilon.evl.dom.Fix;
import org.eclipse.epsilon.evl.dom.IEvlVisitor;

public class EvlUnparser extends ErlUnparser implements IEvlVisitor {
	
	@Override
	protected void unparseRules() {
		((EvlModule) module).getDeclaredConstraintContexts().stream().forEach(c -> {c.accept(this); newline();});
	}
	
	public String unparse(EvlModule module) {
		return super.unparse(module);
	}
	
	@Override
	public void visit(ConstraintContext constraintContext) {
		if (constraintContext.getTypeExpression() != null) {
			unparseAnnotations(constraintContext);
			buffer.append("context ");
			constraintContext.getTypeExpression().accept(this);
			buffer.append(" {");
			newline();
			newline();
			indentation++;
			print("guard", constraintContext.getGuardBlock());
			constraintContext.getConstraints().stream().forEach(c -> {c.accept(this); newline();});
			indentation--;
			buffer.append("}");
			newline();
		}
		else {
			constraintContext.getConstraints().stream().forEach(c -> {c.accept(this); newline();});
		}
	}

	@Override
	public void visit(Constraint constraint) {
		unparseAnnotations(constraint);
		indent();
		buffer.append(constraint.isCritique() ? "critique" : "constraint");
		space();
		buffer.append(constraint.getName());
		space();
		buffer.append("{");
		newline();
		indentation++;
		
		print("guard", constraint.getGuardBlock());
		print("check", constraint.getCheckBlock());
		print("message", constraint.getMessageBlock());
		
		constraint.getFixes().stream().forEach(f -> f.accept(this));
		
		indentation--;
		newline();
		indent();
		buffer.append("}");
		
	}
	
	protected void print(String role, ExecutableBlock<?> executableBlock) {
		if (executableBlock != null) {
			newline();
			indent();
			buffer.append(role);
			executableBlock.accept(this);
			newline();
		}
	}
	
	@Override
	public void visit(ExecutableBlock<?> executableBlock) {
		if (executableBlock.getBody() instanceof StatementBlock) {
			space();
			((StatementBlock) executableBlock.getBody()).accept(this);
		}
		else {
			buffer.append(": ");
			((Expression) executableBlock.getBody()).accept(this);
		}
	}
	
	@Override
	public void visit(Fix fix) {
		newline();
		indent();
		buffer.append("fix {");
		indentation++;
		print("guard", fix.getGuardBlock());
		print("title", fix.getTitleBlock());
		print("do", fix.getBodyBlock());
		indentation--;
		indent();
		buffer.append("}");
		newline();
	}

}
