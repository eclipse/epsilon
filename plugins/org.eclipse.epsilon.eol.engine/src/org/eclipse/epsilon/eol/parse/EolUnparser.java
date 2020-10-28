package org.eclipse.epsilon.eol.parse;

import java.util.ListIterator;
import java.util.Map.Entry;

import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.dom.AbortStatement;
import org.eclipse.epsilon.eol.dom.AndOperatorExpression;
import org.eclipse.epsilon.eol.dom.AnnotationBlock;
import org.eclipse.epsilon.eol.dom.AssignmentStatement;
import org.eclipse.epsilon.eol.dom.BooleanLiteral;
import org.eclipse.epsilon.eol.dom.BreakStatement;
import org.eclipse.epsilon.eol.dom.Case;
import org.eclipse.epsilon.eol.dom.CollectionLiteralExpression;
import org.eclipse.epsilon.eol.dom.ComplexOperationCallExpression;
import org.eclipse.epsilon.eol.dom.ContinueStatement;
import org.eclipse.epsilon.eol.dom.DeleteStatement;
import org.eclipse.epsilon.eol.dom.DivOperatorExpression;
import org.eclipse.epsilon.eol.dom.DoubleEqualsOperatorExpression;
import org.eclipse.epsilon.eol.dom.ElvisOperatorExpression;
import org.eclipse.epsilon.eol.dom.EnumerationLiteralExpression;
import org.eclipse.epsilon.eol.dom.EqualsOperatorExpression;
import org.eclipse.epsilon.eol.dom.ExecutableAnnotation;
import org.eclipse.epsilon.eol.dom.ExecutableBlock;
import org.eclipse.epsilon.eol.dom.Expression;
import org.eclipse.epsilon.eol.dom.ExpressionInBrackets;
import org.eclipse.epsilon.eol.dom.ExpressionStatement;
import org.eclipse.epsilon.eol.dom.FeatureCallExpression;
import org.eclipse.epsilon.eol.dom.FirstOrderOperationCallExpression;
import org.eclipse.epsilon.eol.dom.ForStatement;
import org.eclipse.epsilon.eol.dom.GreaterEqualOperatorExpression;
import org.eclipse.epsilon.eol.dom.GreaterThanOperatorExpression;
import org.eclipse.epsilon.eol.dom.IEolVisitor;
import org.eclipse.epsilon.eol.dom.IfStatement;
import org.eclipse.epsilon.eol.dom.ImpliesOperatorExpression;
import org.eclipse.epsilon.eol.dom.Import;
import org.eclipse.epsilon.eol.dom.IntegerLiteral;
import org.eclipse.epsilon.eol.dom.ItemSelectorExpression;
import org.eclipse.epsilon.eol.dom.LessEqualOperatorExpression;
import org.eclipse.epsilon.eol.dom.LessThanOperatorExpression;
import org.eclipse.epsilon.eol.dom.MapLiteralExpression;
import org.eclipse.epsilon.eol.dom.MinusOperatorExpression;
import org.eclipse.epsilon.eol.dom.ModelDeclaration;
import org.eclipse.epsilon.eol.dom.ModelDeclarationParameter;
import org.eclipse.epsilon.eol.dom.NameExpression;
import org.eclipse.epsilon.eol.dom.NegativeOperatorExpression;
import org.eclipse.epsilon.eol.dom.NewInstanceExpression;
import org.eclipse.epsilon.eol.dom.NotEqualsOperatorExpression;
import org.eclipse.epsilon.eol.dom.NotOperatorExpression;
import org.eclipse.epsilon.eol.dom.Operation;
import org.eclipse.epsilon.eol.dom.OperationCallExpression;
import org.eclipse.epsilon.eol.dom.OperatorExpression;
import org.eclipse.epsilon.eol.dom.OrOperatorExpression;
import org.eclipse.epsilon.eol.dom.Parameter;
import org.eclipse.epsilon.eol.dom.PlusOperatorExpression;
import org.eclipse.epsilon.eol.dom.PostfixOperatorExpression;
import org.eclipse.epsilon.eol.dom.PropertyCallExpression;
import org.eclipse.epsilon.eol.dom.RealLiteral;
import org.eclipse.epsilon.eol.dom.ReturnStatement;
import org.eclipse.epsilon.eol.dom.SimpleAnnotation;
import org.eclipse.epsilon.eol.dom.StatementBlock;
import org.eclipse.epsilon.eol.dom.StringLiteral;
import org.eclipse.epsilon.eol.dom.SwitchStatement;
import org.eclipse.epsilon.eol.dom.TernaryExpression;
import org.eclipse.epsilon.eol.dom.ThrowStatement;
import org.eclipse.epsilon.eol.dom.TimesOperatorExpression;
import org.eclipse.epsilon.eol.dom.TransactionStatement;
import org.eclipse.epsilon.eol.dom.TypeExpression;
import org.eclipse.epsilon.eol.dom.VariableDeclaration;
import org.eclipse.epsilon.eol.dom.WhileStatement;
import org.eclipse.epsilon.eol.dom.XorOperatorExpression;

public class EolUnparser implements IEolVisitor {
	
	protected StringBuffer buffer = null;
	protected EolModule module = null;
	protected int indentation = 0;
	
	public String unparse(EolModule module) {
		
		this.module = module;
		buffer = new StringBuffer();
		
		module.getImports().stream().forEach(i -> {i.accept(this); newline();});
		module.getModelDelcarations().stream().forEach(md -> {md.accept(this); newline();});
		module.getMain().accept(this);
		module.getOperations().stream().forEach(o -> {newline(); o.accept(this);});
		
		return buffer.toString();
	}
	
	protected void newline() {
		buffer.append(System.lineSeparator());
	}
	
	protected void comma() {
		buffer.append(", ");
	}
	
	protected void space() {
		buffer.append(" ");
	}
	
	@Override
	public void visit(AbortStatement abortStatement) {
		buffer.append("abort;");
	}

	@Override
	public void visit(AndOperatorExpression andOperatorExpression) {
		printBinaryOperatorExpression(andOperatorExpression, "and");
	}

	@Override
	public void visit(DeleteStatement deleteStatement) {
		buffer.append("delete ");
		if (deleteStatement.getExpression() != null) {
			deleteStatement.getExpression().accept(this);
		}
		semicolon();
	}
	
	protected void semicolon() {
		buffer.append(";");
	}

	@Override
	public void visit(AnnotationBlock annotationBlock) {
		annotationBlock.getAnnotations().forEach(a -> {a.accept(this); newline();});
	}

	@Override
	public void visit(AssignmentStatement assignmentStatement) {
		assignmentStatement.getTargetExpression().accept(this);
		buffer.append(" = ");
		assignmentStatement.getValueExpression().accept(this);
		buffer.append(";");
	}

	@Override
	public void visit(BooleanLiteral booleanLiteral) {
		buffer.append(booleanLiteral.getValue());
	}

	@Override
	public void visit(BreakStatement breakStatement) {
		buffer.append(breakStatement.isAll() ? "breakAll" : "break");
		semicolon();
	}

	@Override
	public void visit(Case case_) {
		if (case_.getCondition() != null) {
			buffer.append("case ");
			case_.getCondition().accept(this);
		}
		else buffer.append("default");
		buffer.append(": ");
		case_.getBody().accept(this);
	}

	@Override
	public void visit(CollectionLiteralExpression<?> collectionLiteralExpression) {
		buffer.append(collectionLiteralExpression.getCollectionType() + "{");
		ListIterator<Expression> li = collectionLiteralExpression.getParameterExpressions().listIterator();
		while (li.hasNext()) {
			li.next().accept(this);
			if (li.hasNext()) {
				if (collectionLiteralExpression.isRange()) {
					buffer.append("..");
				}
				else {
					comma();
				}
			}
		}
		buffer.append("}");
	}

	@Override
	public void visit(ComplexOperationCallExpression complexOperationCallExpression) {
		// TODO Auto-generated method stub
	}

	@Override
	public void visit(ContinueStatement continueStatement) {
		buffer.append("continue;");
	}

	@Override
	public void visit(DivOperatorExpression divOperatorExpression) {
		printBinaryOperatorExpression(divOperatorExpression, "/");
	}

	@Override
	public void visit(DoubleEqualsOperatorExpression doubleEqualsOperatorExpression) {
		printBinaryOperatorExpression(doubleEqualsOperatorExpression, "==");
	}

	@Override
	public void visit(ElvisOperatorExpression elvisOperatorExpression) {
		elvisOperatorExpression.getFirstOperand().accept(this);
		buffer.append(" ?: ");
		elvisOperatorExpression.getSecondOperand().accept(this);
	}

	@Override
	public void visit(EnumerationLiteralExpression enumerationLiteralExpression) {
		buffer.append(enumerationLiteralExpression.getEnumerationLiteral());
	}

	@Override
	public void visit(EqualsOperatorExpression equalsOperatorExpression) {
		printBinaryOperatorExpression(equalsOperatorExpression, "=");
	}

	@Override
	public void visit(ExecutableAnnotation executableAnnotation) {
		buffer.append("$" + executableAnnotation.getName());
		if (executableAnnotation.getExpression() != null) {
			space();
			executableAnnotation.getExpression().accept(this);
		}
	}

	@Override
	public void visit(ExecutableBlock<?> executableBlock) {
		// No need to implement for EOL itself
	}

	@Override
	public void visit(ExpressionInBrackets expressionInBrackets) {
		buffer.append("(");
		print(expressionInBrackets.getExpression());
		buffer.append(")");
	}

	@Override
	public void visit(ExpressionStatement expressionStatement) {
		print(expressionStatement.getExpression());
		semicolon();
	}
	
	protected void print(Expression expression) {
		if (expression != null) expression.accept(this);
	}
	
	@Override
	public void visit(FirstOrderOperationCallExpression operationCallExpression) {
		print(operationCallExpression.getTargetExpression());
		arrowOrDot(operationCallExpression);
		buffer.append(operationCallExpression.getName() + "(");
		ListIterator<Parameter> pi = operationCallExpression.getParameters().listIterator();
		while (pi.hasNext()) {
			pi.next().accept(this);
			if (pi.hasNext()) comma();
		}
		if (!operationCallExpression.getExpressions().isEmpty()) {
			buffer.append("|");
			ListIterator<Expression> ei = operationCallExpression.getExpressions().listIterator();
			while (ei.hasNext()) {
				ei.next().accept(this);
				if (ei.hasNext()) comma();
			}
		}
		buffer.append(")");
	}

	@Override
	public void visit(ForStatement forStatement) {
		buffer.append("for (");
		forStatement.getIteratorParameter().accept(this);
		buffer.append(" in ");
		forStatement.getIteratedExpression().accept(this);
		buffer.append(") ");
		forStatement.getBodyStatementBlock().accept(this);
	}

	@Override
	public void visit(GreaterEqualOperatorExpression greaterEqualOperatorExpression) {
		printBinaryOperatorExpression(greaterEqualOperatorExpression, ">=");
	}

	@Override
	public void visit(GreaterThanOperatorExpression greaterThanOperatorExpression) {
		printBinaryOperatorExpression(greaterThanOperatorExpression, ">");
	}

	@Override
	public void visit(IfStatement ifStatement) {
		buffer.append("if (");
		print(ifStatement.getConditionExpression());
		buffer.append(") ");
		ifStatement.getThenStatementBlock().accept(this);
		if (ifStatement.getElseStatementBlock() != null) {
			newline();
			indent();
			buffer.append("else ");
			StatementBlock elseStatementBlock = ifStatement.getElseStatementBlock();
			if (elseStatementBlock.getStatements().size() == 1 && elseStatementBlock.getStatements().get(0) instanceof IfStatement) {
				elseStatementBlock.getStatements().get(0).accept(this);
			}
			else {
				ifStatement.getElseStatementBlock().accept(this);
			}
		}
	}

	@Override
	public void visit(ImpliesOperatorExpression impliesOperatorExpression) {
		printBinaryOperatorExpression(impliesOperatorExpression, "implies");
	}

	@Override
	public void visit(Import import_) {
		buffer.append("import \"" + import_.getPath() + "\";");
	}

	@Override
	public void visit(IntegerLiteral integerLiteral) {
		buffer.append(integerLiteral.getText());
	}

	@Override
	public void visit(ItemSelectorExpression itemSelectorExpression) {
		itemSelectorExpression.getTargetExpression().accept(this);
		buffer.append("[");
		itemSelectorExpression.getIndexExpression().accept(this);
		buffer.append("]");
	}

	@Override
	public void visit(LessEqualOperatorExpression lessEqualOperatorExpression) {
		printBinaryOperatorExpression(lessEqualOperatorExpression, "<=");
	}

	@Override
	public void visit(LessThanOperatorExpression lessThanOperatorExpression) {
		printBinaryOperatorExpression(lessThanOperatorExpression, "<");
	}

	@Override
	public void visit(MapLiteralExpression<?, ?> mapLiteralExpression) {
		buffer.append(mapLiteralExpression.getMapName());
		buffer.append("{");
		ListIterator<Entry<Expression, Expression>> li = mapLiteralExpression.getKeyValueExpressionPairs().listIterator();
		while (li.hasNext()) {
			Entry<Expression, Expression> next = li.next();
			next.getKey().accept(this);
			buffer.append(" = ");
			next.getValue().accept(this);
			if (li.hasNext()) comma();
		}
		buffer.append("}");
	}

	@Override
	public void visit(MinusOperatorExpression minusOperatorExpression) {
		printBinaryOperatorExpression(minusOperatorExpression, "-");
	}

	@Override
	public void visit(ModelDeclaration modelDeclaration) {
		buffer.append("model ");
		modelDeclaration.getNameExpression().accept(this);
		if (!modelDeclaration.getAliasNameExpressions().isEmpty()) {
			buffer.append(" alias ");
			ListIterator<NameExpression> li = modelDeclaration.getAliasNameExpressions().listIterator();
			while (li.hasNext()) {
				li.next().accept(this);
				if (li.hasNext()) comma();
			}
		}
		buffer.append(" driver ");
		modelDeclaration.getDriverNameExpression().accept(this);
		buffer.append(" {");
		ListIterator<ModelDeclarationParameter> li = modelDeclaration.getModelDeclarationParameters().listIterator();
		while (li.hasNext()) {
			li.next().accept(this);
			if (li.hasNext()) comma();
		}
		buffer.append("}");
	}

	@Override
	public void visit(ModelDeclarationParameter modelDeclarationParameter) {
		buffer.append(modelDeclarationParameter.getKey());
		buffer.append(" = \"");
		buffer.append(modelDeclarationParameter.getValue());
		buffer.append("\"");
	}

	@Override
	public void visit(NameExpression nameExpression) {
		buffer.append(nameExpression.getName());
	}

	@Override
	public void visit(NegativeOperatorExpression negativeOperatorExpression) {
		buffer.append("-");
		print(negativeOperatorExpression.getFirstOperand());
	}

	@Override
	public void visit(NewInstanceExpression newInstanceExpression) {
		buffer.append("new ");
		newInstanceExpression.getTypeExpression().accept(this);
		if (!newInstanceExpression.getParameterExpressions().isEmpty()) {
			buffer.append("(");
			ListIterator<Expression> li = newInstanceExpression.getParameterExpressions().listIterator();
			while (li.hasNext()) {
				li.next().accept(this);
				if (li.hasNext()) comma();
			}
			buffer.append(")");
		}
	}

	@Override
	public void visit(NotEqualsOperatorExpression notEqualsOperatorExpression) {
		printBinaryOperatorExpression(notEqualsOperatorExpression, notEqualsOperatorExpression.getOperator() != null ? notEqualsOperatorExpression.getOperator() : "<>");
	}

	@Override
	public void visit(NotOperatorExpression notOperatorExpression) {
		buffer.append("not ");
		notOperatorExpression.getFirstOperand().accept(this);
	}

	@Override
	public void visit(Operation operation) {
		if (operation.getAnnotationBlock() != null) operation.getAnnotationBlock().accept(this);
		buffer.append("operation ");
		if (operation.getContextTypeExpression() != null) {
			operation.getContextTypeExpression().accept(this);
			space();
		}
		buffer.append(operation.getName() + "(");
		ListIterator<Parameter> li = operation.getFormalParameters().listIterator();
		while (li.hasNext()) {
			li.next().accept(this);
			if (li.hasNext()) comma();
		}
		buffer.append(") ");
		if (operation.getReturnTypeExpression() != null) {
			buffer.append(": ");
			operation.getReturnTypeExpression().accept(this);
			space();
		}
		operation.getBody().accept(this);
	}

	@Override
	public void visit(OperationCallExpression operationCallExpression) {
		if (operationCallExpression.getTargetExpression() != null) {
			print(operationCallExpression.getTargetExpression());
			arrowOrDot(operationCallExpression);
		}
		buffer.append(operationCallExpression.getName() + "(");
		ListIterator<Expression> li = operationCallExpression.getParameterExpressions().listIterator();
		while (li.hasNext()) {
			li.next().accept(this);
			if (li.hasNext()) comma();
		}
		buffer.append(")");
	}

	@Override
	public void visit(OrOperatorExpression orOperatorExpression) {
		printBinaryOperatorExpression(orOperatorExpression, "or");
	}

	@Override
	public void visit(Parameter parameter) {
		buffer.append(parameter.getName());
		if (parameter.getTypeExpression() != null) {
			buffer.append(" : ");
			parameter.getTypeExpression().accept(this);
		}
	}

	@Override
	public void visit(PlusOperatorExpression plusOperatorExpression) {
		printBinaryOperatorExpression(plusOperatorExpression, "+");
	}

	@Override
	public void visit(PostfixOperatorExpression postfixOperatorExpression) {
		postfixOperatorExpression.getFirstOperand().accept(this);
		buffer.append(postfixOperatorExpression.isIncrease() ? "++" : "--");
	}

	@Override
	public void visit(PropertyCallExpression propertyCallExpression) {
		propertyCallExpression.getTargetExpression().accept(this);
		// TODO: Check null-safe
		arrowOrDot(propertyCallExpression);
		propertyCallExpression.getNameExpression().accept(this);
	}

	@Override
	public void visit(RealLiteral realLiteral) {
		buffer.append(realLiteral.getText());
	}

	@Override
	public void visit(ReturnStatement returnStatement) {
		buffer.append("return");
		if (returnStatement.getReturnedExpression() != null) {
			buffer.append(" ");
			returnStatement.getReturnedExpression().accept(this);
		}
		semicolon();
	}

	@Override
	public void visit(SimpleAnnotation simpleAnnotation) {
		buffer.append("@" + simpleAnnotation.getName());
		if (simpleAnnotation.getValue() != null) {
			buffer.append(" " + simpleAnnotation.getValue());
		}
		newline();
	}

	@Override
	public void visit(StatementBlock statementBlock) {
		if (statementBlock != module.getMain()) {
			buffer.append("{");
			newline();
			indentation++;
		}
		statementBlock.getStatements().forEach(s -> {indent(); s.accept(this); newline();});
		if (statementBlock != module.getMain()) {
			indentation--;
			indent();
			buffer.append("}");
		}
	}
	
	protected void indent() {
		for (int i=0;i<indentation;i++) buffer.append("\t");
	}
	
	@Override
	public void visit(StringLiteral stringLiteral) {
		buffer.append("\"" + stringLiteral.getValue().replace("\\", "\\\\") + "\"");
	}

	@Override
	public void visit(SwitchStatement switchStatement) {
		buffer.append("switch (");
		switchStatement.getConditionExpression().accept(this);
		buffer.append(") {");
		newline();
		indentation++;
		switchStatement.getCases().forEach(c -> { indent(); c.accept(this); newline();});
		if (switchStatement.getDefault() != null) {
			indent(); switchStatement.getDefault().accept(this); newline();
		}
		indentation--;
		indent();
		buffer.append("}");
		
	}

	@Override
	public void visit(TernaryExpression ternaryExpression) {
		ternaryExpression.getFirstOperand().accept(this);
		buffer.append(" ? ");
		ternaryExpression.getSecondOperand().accept(this);
		buffer.append(" : ");
		ternaryExpression.getThirdOperand().accept(this);
	}

	@Override
	public void visit(ThrowStatement throwStatement) {
		buffer.append("throw");
		if (throwStatement.getThrown() != null) {
			buffer.append(" ");
			throwStatement.getThrown().accept(this);
		}
		semicolon();
	}

	@Override
	public void visit(TimesOperatorExpression timesOperatorExpression) {
		printBinaryOperatorExpression(timesOperatorExpression, "*");
	}
	
	protected void printBinaryOperatorExpression(OperatorExpression operatorExpression, String operator) {
		operatorExpression.getFirstOperand().accept(this);
		buffer.append(" " + operator + " ");
		operatorExpression.getSecondOperand().accept(this);
	}
	
	protected void arrowOrDot(FeatureCallExpression expression) {
		if (expression.isNullSafe()) buffer.append("?");
		buffer.append(expression.isArrow() ? "->" : ".");
	}
	
	@Override
	public void visit(TransactionStatement transactionStatement) {
		buffer.append("transaction ");
		ListIterator<NameExpression> li = transactionStatement.getModelNames().listIterator();
		while (li.hasNext()) {
			li.next().accept(this);
			if (li.hasNext()) comma();
			else space();
		}
		transactionStatement.getBody().accept(this);
	}

	@Override
	public void visit(TypeExpression typeExpression) {
		buffer.append(typeExpression.getName());
		if (typeExpression.getNativeType() != null) {
			buffer.append("(");
			typeExpression.getNativeType().accept(this);
			buffer.append(")");
		}
		else if (!typeExpression.getParameterTypeExpressions().isEmpty()) {
			buffer.append("(");
			ListIterator<TypeExpression> li = typeExpression.getParameterTypeExpressions().listIterator();
			while (li.hasNext()) {
				li.next().accept(this);
				if (li.hasNext()) comma();
			}
			buffer.append(")");
		}
	}

	@Override
	public void visit(VariableDeclaration variableDeclaration) {
		buffer.append("var " + variableDeclaration.getName());
		if (variableDeclaration.getTypeExpression() != null) {
			buffer.append(" : ");
			if (variableDeclaration.isInstantiate()) buffer.append("new ");
			variableDeclaration.getTypeExpression().accept(this);
		}
	}

	@Override
	public void visit(WhileStatement whileStatement) {
		buffer.append("while (");
		print(whileStatement.getConditionExpression());
		buffer.append(")");
		whileStatement.getBodyStatementBlock().accept(this);
	}

	@Override
	public void visit(XorOperatorExpression xorOperatorExpression) {
		printBinaryOperatorExpression(xorOperatorExpression, "xor");
	}
	
}
