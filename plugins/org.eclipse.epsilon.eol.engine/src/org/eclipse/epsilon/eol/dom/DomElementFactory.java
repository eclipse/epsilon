package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.commons.util.AstUtil;
import org.eclipse.epsilon.eol.parse.EolParser;

public class DomElementFactory {
	
	public DomElement createDomElement(AST ast) {
		
		DomElement e = null;
		
		switch (ast.getType()) {
			case EolParser.EOLMODULE : e = createProgram(ast); break;
			case EolParser.FOR : e = createForStatement(ast); break;
			case EolParser.FORMAL : e = createVariableDeclarationExpression(ast); break;
			case EolParser.IMPORT : e = createImport(ast); break;
			case EolParser.POINT : e = createFeatureCallExpression(ast); break;
			case EolParser.ARROW : e = createFeatureCallExpression(ast); break;
			case EolParser.NAME : e = createNameExpression(ast); break;
			case EolParser.FEATURECALL : e = createNameExpression(ast); break;
			case EolParser.OPERATOR : e = createOperatorExpression(ast); break;
			case EolParser.IF : e = createIfStatement(ast); break;
			case EolParser.INT : e = createIntegerExpression(ast); break;
			case EolParser.BOOLEAN : e = createBooleanExpression(ast); break;
			case EolParser.STRING : e = createStringExpression(ast); break;
			case EolParser.FLOAT : e = createRealExpression(ast); break;
			case EolParser.ASSIGNMENT : e = createAssignmentStatement(ast); break;
			case EolParser.WHILE : e = createWhileStatement(ast); break;
			case EolParser.VAR : e = createVariableDeclarationExpression(ast); break;
			case EolParser.NEW : e = createVariableDeclarationExpression(ast); break;
			case EolParser.HELPERMETHOD : e = createOperationDefinition(ast); break;
		}
		
		if (e == null) {
			throw new RuntimeException("Cannot create dom element for " + ast.getText() + "->" + ast.getType());
		}
		else {
			return e;
		}
	}
	
	protected OperationDefinition createOperationDefinition(AST ast) {
		OperationDefinition operation = new OperationDefinition();
		return operation;
	}
	
	protected WhileStatement createWhileStatement(AST ast) {
		WhileStatement statement = new WhileStatement();
		statement.setCondition(createExpression(ast.getFirstChild()));
		for (AST statementAst : ast.getChild(1).getChildren()) {
			statement.getBody().add(createStatement(statementAst));
		}
		return statement;
	}
	
	protected AssignmentStatement createAssignmentStatement(AST ast) {
		AssignmentStatement statement = new AssignmentStatement();
		statement.setLhs(createExpression(ast.getChild(0)));
		statement.setRhs(createExpression(ast.getChild(1)));
		return statement;
	}
	
	protected IntegerExpression createIntegerExpression(AST ast) {
		IntegerExpression exp = new IntegerExpression();
		exp.setValue(ast.getText());
		return exp;
	}
	
	protected BooleanExpression createBooleanExpression(AST ast) {
		BooleanExpression exp = new BooleanExpression();
		exp.setValue(ast.getText());
		return exp;
	}
	
	protected StringExpression createStringExpression(AST ast) {
		StringExpression exp = new StringExpression();
		exp.setValue(ast.getText());
		return exp;
	}
	
	protected RealExpression createRealExpression(AST ast) {
		RealExpression exp = new RealExpression();
		exp.setValue(ast.getText());
		return exp;
	}
	
	protected Expression createExpression(AST ast) {
		return (Expression) createDomElement(ast);
	}
	
	protected IfStatement createIfStatement(AST ast) {
		
		IfStatement statement = new IfStatement();
		
		AST conditionAst = ast.getFirstChild();
		AST ifBodyAst = conditionAst.getNextSibling();
		AST elseBodyAst = ifBodyAst.getNextSibling();
		
		statement.setCondition(createExpression(conditionAst));
		for (AST statementAst : ifBodyAst.getChildren()) {
			statement.getIfBody().add(createStatement(statementAst));
		}
		if (elseBodyAst != null) {
			for (AST statementAst : elseBodyAst.getChildren()) {
				statement.getElseBody().add(createStatement(statementAst));
			}
		}
		
		return statement;
		
	}
	
	protected OperatorExpression createOperatorExpression(AST ast) {
		
		OperatorExpression exp = null;
		String operator = ast.getText();
		if (operator.equals("and")) {
			exp = new AndOperatorExpression();
		}
		else if (operator.equals("or")) {
			exp = new OrOperatorExpression();
		}
		else if (operator.equals("xor")) {
			exp = new XorOperatorExpression();
		}
		else if (operator.equals("implies")) {
			exp = new ImpliesOperatorExpression();
		}
		else if (operator.equals("not")) {
			exp = new NotOperatorExpression();
		}
		else if (operator.equals("+")) {
			exp = new PlusOperatorExpression();
		}
		else if (operator.equals("-")) {
			if (ast.getChildren().size() == 1) {
				exp = new NegativeOperatorExpression();
			}
			else {
				exp = new MinusOperatorExpression();
			}
		}
		else if (operator.equals("*")) {
			exp = new StarOperatorExpression();
		}
		else if (operator.equals("/")) {
			exp = new DivOperatorExpression();
		}
		else if (operator.equals("=") || operator.equals("==")) {
			exp = new EqualsOperatorExpression();
		}
		else if (operator.equals("<>") || operator.equals("!=")) {
			exp = new NotEqualsOperatorExpression();
		}
		else if (operator.equals(">")) {
			exp = new MoreThanOperatorExpression();
		}
		else if (operator.equals("<")) {
			exp = new LessThanOperatorExpression();
		}
		else if (operator.equals("<=")) {
			exp = new LessThanOrEqualOperatorExpression();
		}
		else if (operator.equals(">=")) {
			exp = new MoreThanOrEqualOperatorExpression();
		}
		
		
		if (exp instanceof BinaryOperatorExpression) {
			((BinaryOperatorExpression) exp).setLhs((Expression) createDomElement(ast.getChild(0)));
			((BinaryOperatorExpression) exp).setRhs((Expression) createDomElement(ast.getChild(1)));
		}
		else {
			((UnaryOperatorExpression) exp).setExpression((Expression) createDomElement(ast.getFirstChild()));
		}
		
		return exp;
	}
	
	protected NameExpression createNameExpression(AST ast) {
		NameExpression exp = new NameExpression();
		exp.setName(ast.getText());
		return exp;
	}
	
	protected FeatureCallExpression createFeatureCallExpression(AST ast) {
		AST targetAst = ast.getFirstChild();
		AST featureAst = targetAst.getNextSibling();
		AST parametersAst = featureAst.getNextSibling();
		
		FeatureCallExpression exp = null;
		if (parametersAst == null) {
			exp = new PropertyCallExpression();
			PropertyCallExpression pexp = (PropertyCallExpression) exp;
			String property = featureAst.getText();
			if (property.startsWith("~")) {
				pexp.setExtended(true);
				pexp.setProperty(property.substring(1));
			}
			else {
				pexp.setProperty(property);
			}
		}
		else {
			exp = new MethodCallExpression();
			MethodCallExpression mexp = (MethodCallExpression) exp;
			mexp.setMethod(featureAst.getText());
			for (AST parameterAst : parametersAst.getChildren()) {
				mexp.getArguments().add((Expression) createDomElement(parameterAst));
			}
		}
		
		exp.setArrow(ast.getType() == EolParser.ARROW);
		exp.setTarget((Expression) createDomElement(targetAst));
		
		
		return exp;
	}
	
	protected Statement createStatement(AST ast) {
		Statement statement = null;
		DomElement e = createDomElement(ast);
		if (e instanceof Statement) {
			return statement = (Statement) e;
		}
		else {
			statement = new ExpressionStatement();
			((ExpressionStatement) statement).setExpression((Expression) e);
		}
		return statement;
	}
	
	protected Import createImport(AST ast) {
		Import imp = new Import();
		imp.setImported(ast.getFirstChild().getText());
		return imp;
	}
	
	protected Program createProgram(AST ast) {
		Program program = new Program();
		for (AST importAst : AstUtil.getChildren(ast, EolParser.IMPORT)) {
			program.getImports().add((Import) createDomElement(importAst));
		}
		AST block = AstUtil.getChild(ast, EolParser.BLOCK);
		for (AST statementAst : block.getChildren()) {
			program.getStatements().add(createStatement(statementAst));
		}
		return program;
	}
	
	protected VariableDeclarationExpression createVariableDeclarationExpression(AST ast) {
		VariableDeclarationExpression declaration = new VariableDeclarationExpression();
		AST nameAst = ast.getFirstChild();
		declaration.setName(nameAst.getText());
		AST typeAst = nameAst.getNextSibling();
		if (typeAst != null) {
			declaration.setType(typeAst.getText());
		}
		declaration.setCreate(ast.getType() == EolParser.NEW);
		return declaration;
	}
	
	protected ForStatement createForStatement(AST ast) {
		ForStatement statement = new ForStatement();
		AST iteratorAst = ast.getFirstChild();
		AST iteratedAst = iteratorAst.getNextSibling();
		statement.setIterator((VariableDeclarationExpression) createDomElement(iteratorAst));
		statement.setIterated((Expression) createDomElement(iteratedAst));
		return statement;
	}
	
}
