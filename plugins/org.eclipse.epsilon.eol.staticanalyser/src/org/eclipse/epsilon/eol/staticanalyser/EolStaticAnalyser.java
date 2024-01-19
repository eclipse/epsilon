package org.eclipse.epsilon.eol.staticanalyser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.epsilon.common.dt.editor.AbstractModuleEditor;
import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.module.IModuleValidator;
import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.common.module.ModuleMarker;
import org.eclipse.epsilon.common.module.ModuleMarker.Severity;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.common.util.StringUtil;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.IEolModule;
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
import org.eclipse.epsilon.eol.dom.OperationList;
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
import org.eclipse.epsilon.eol.execute.context.FrameStack;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.m3.MetaClass;
import org.eclipse.epsilon.eol.m3.StructuralFeature;
import org.eclipse.epsilon.eol.types.EolAnyType;
import org.eclipse.epsilon.eol.types.EolCollectionType;
import org.eclipse.epsilon.eol.types.EolMapType;
import org.eclipse.epsilon.eol.types.EolModelElementType;
import org.eclipse.epsilon.eol.types.EolNoType;
import org.eclipse.epsilon.eol.types.EolPrimitiveType;
import org.eclipse.epsilon.eol.types.EolType;

public class EolStaticAnalyser implements IModuleValidator, IEolVisitor {

	protected List<ModuleMarker> errors = new ArrayList<>();
	protected EolModule module;
	protected BuiltinEolModule builtinModule = new BuiltinEolModule();
	protected EolStaticAnalysisContext context = new EolStaticAnalysisContext();
	HashMap<Operation, Boolean> returnFlags = new HashMap<>();
	// For compiling user and builtin operations
	HashMap<OperationCallExpression, ArrayList<Operation>> operations = new HashMap<>(); // keeping all matched
																							// operations with same name
	HashMap<OperationCallExpression, ArrayList<Operation>> matchedOperations = new HashMap<>(); // keeping all matched
																	// parameters
	HashMap<OperationCallExpression, ArrayList<EolType>> matchedReturnType = new HashMap<>(); // keeping returnTypes of
																								// matched operations
	HashMap<OperationCallExpression, Boolean> matched = new HashMap<>(); // finding one perfect match, in doesn't change
																			// for every missmatch
	
	public static void main(String[] args) throws Exception {
		
		EolModule module = new EolModule();
		module.parse("(1 or true).println();");
		IModelFactory modelFactory = new StaticModelFactory();
		EolStaticAnalyser analyser = new EolStaticAnalyser(modelFactory);
		List<ModuleMarker> markers = analyser.validate(module);
		for (ModuleMarker marker : markers) {
			System.out.println(marker.getMessage());
		}
	}
	
	
	public EolStaticAnalyser(IModelFactory modelFactory) {
		context.modelFactory = modelFactory;
	}

	@Override
	public void visit(AbortStatement abortStatement) {
		// TODO Auto-generated method stub
	}

	@Override
	public void visit(AndOperatorExpression andOperatorExpression) {
		OperatorExpression operatorExpression = (OperatorExpression) andOperatorExpression;
		visitOperatorExpression(operatorExpression);
	}

	@Override
	public void visit(DeleteStatement deleteStatement) {
		deleteStatement.getExpression().accept(this);
	}

	@Override
	public void visit(AnnotationBlock annotationBlock) {
		// TODO Auto-generated method stub
	}

	@Override
	public void visit(AssignmentStatement assignmentStatement) {

		Expression targetExpression = assignmentStatement.getTargetExpression();
		Expression valueExpression = assignmentStatement.getValueExpression();

		valueExpression.accept(this);
		targetExpression.accept(this);

		EolType targetType = getResolvedType(targetExpression);
		EolType valueType = getResolvedType(valueExpression);

		if (targetType instanceof EolModelElementType && ((EolModelElementType) targetType).getMetaClass() != null)
			targetType = new EolModelElementType(((EolModelElementType) targetType).getMetaClass());
		if (valueType instanceof EolModelElementType && ((EolModelElementType) valueType).getMetaClass() != null)
			valueType = new EolModelElementType(((EolModelElementType) valueType).getMetaClass());

		if (!(isCompatible(targetType, valueType))) {
			if (canBeCompatible(targetType, valueType))
				createTypeCompatibilityWarning(targetExpression, valueExpression);
			else
				createTypeCompatibilityError(targetExpression, valueExpression);
		}
	}

	@Override
	public void visit(BooleanLiteral booleanLiteral) {
		setResolvedType(booleanLiteral, EolPrimitiveType.Boolean);
	}

	@Override
	public void visit(BreakStatement breakStatement) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(Case case_) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(CollectionLiteralExpression<?> collectionLiteralExpression) {
		if (!collectionLiteralExpression.getParameterExpressions().isEmpty()) {
			collectionLiteralExpression.getParameterExpressions().get(0).accept(this);
			setResolvedType(collectionLiteralExpression, new EolCollectionType(collectionLiteralExpression.getCollectionType(),
					getResolvedType(collectionLiteralExpression.getParameterExpressions().get(0))));
		}
	}

	@Override
	public void visit(ComplexOperationCallExpression complexOperationCallExpression) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(ContinueStatement continueStatement) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(DivOperatorExpression divOperatorExpression) {
		OperatorExpression operatorExpression = (OperatorExpression) divOperatorExpression;
		visitOperatorExpression(operatorExpression);
	}

	@Override
	public void visit(DoubleEqualsOperatorExpression doubleEqualsOperatorExpression) {
		OperatorExpression operatorExpression = (OperatorExpression) doubleEqualsOperatorExpression;
		visitOperatorExpression(operatorExpression);
	}

	@Override
	public void visit(ElvisOperatorExpression elvisOperatorExpression) {
		OperatorExpression operatorExpression = (OperatorExpression) elvisOperatorExpression;
		visitOperatorExpression(operatorExpression);
	}

	@Override
	public void visit(EnumerationLiteralExpression enumerationLiteralExpression) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(EqualsOperatorExpression equalsOperatorExpression) {
		OperatorExpression operatorExpression = (OperatorExpression) equalsOperatorExpression;
		visitOperatorExpression(operatorExpression);
	}

	@Override
	public void visit(ExecutableAnnotation executableAnnotation) {
		executableAnnotation.getExpression().accept(this);
	}

	@Override
	public void visit(ExecutableBlock<?> executableBlock) {
		Object body = executableBlock.getBody();
		if (body instanceof StatementBlock) {
			((StatementBlock) body).accept(this);
		}
		else if (body instanceof Expression) {
			((Expression) body).accept(this);
		}
		// Should we add add accept method?
	}

	@Override
	public void visit(ExpressionInBrackets expressionInBrackets) {
		expressionInBrackets.getExpression().accept(this);
		setResolvedType(expressionInBrackets, getResolvedType(expressionInBrackets.getExpression()));
	}

	@Override
	public void visit(ExpressionStatement expressionStatement) {
		expressionStatement.getExpression().accept(this);

	}
	
	
	
	@Override
	public void visit(FirstOrderOperationCallExpression firstOrderOperationCallExpression) {
		OperationList builtinOperations = new OperationList();
		Expression targetExpression = firstOrderOperationCallExpression.getTargetExpression();
		EolType contextType = null;
		String name = firstOrderOperationCallExpression.getNameExpression().getName();

		for (Operation op : ((EolModule) module).getOperations())
			if (op.getAnnotation("firstorder") != null)
				builtinOperations.add(op);

		targetExpression.accept(this);

		if (getResolvedType(targetExpression) instanceof EolCollectionType) {
			contextType = ((EolCollectionType) getResolvedType(targetExpression)).getContentType();
		} else if (getResolvedType(targetExpression) == EolAnyType.Instance) {
			contextType = getResolvedType(targetExpression);
		}

		if (name.startsWith("sequential"))
			name = name.substring(10);
		else if (name.startsWith("parallel"))
			name = name.substring(8);

		if (contextType != null) {
			context.getFrameStack().enterLocal(FrameType.UNPROTECTED, firstOrderOperationCallExpression);
			Parameter parameter = firstOrderOperationCallExpression.getParameters().get(0);

			visit(parameter, false);

			if (parameter.isExplicitlyTyped()) {
				// TODO: Check that the type of the parameter is a subtype of the type of the
				// collection
				contextType = getType(parameter);
				EolType target = ((EolCollectionType) getResolvedType(targetExpression)).getContentType();
				EolType param = contextType;
				while (!(param.equals(target))) {
					param = getParentType(param);
					if (param instanceof EolAnyType) {
						// context.addErrorMarker(parameter, );
						errors.add(new ModuleMarker(parameter, "The parameter must be instance of " + target.getName(),
								Severity.Error));

						break;
					}
				}
			} else {
				// context.getFrameStack().put(parameter.getName(), contextType);
				if (getResolvedType(targetExpression) instanceof EolCollectionType) {

					parameter.setTypeExpression(new TypeExpression(
							((EolCollectionType) getResolvedType(targetExpression)).getContentType().getName()));

					setResolvedType(parameter.getTypeExpression(), ((EolCollectionType) getResolvedType(targetExpression)).getContentType());
				} else {
					parameter.setTypeExpression(new TypeExpression("Any"));
					setResolvedType(parameter.getTypeExpression(),EolAnyType.Instance);
				}
				setType(parameter, getResolvedType(parameter.getTypeExpression()));
				parameter.getTypeExpression().setName(getResolvedType(parameter.getTypeExpression()).toString());
				contextType = getType(parameter);
			}
			
			context.getFrameStack().put(new Variable(parameter.getName(), getType(parameter)));
			
			Expression expression = firstOrderOperationCallExpression.getExpressions().get(0);
			expression.accept(this);

			context.getFrameStack().leaveLocal(firstOrderOperationCallExpression);

			if (StringUtil.isOneOf(name, "select", "reject", "rejectOne", "closure", "sortBy")) {
				setResolvedType(firstOrderOperationCallExpression, new EolCollectionType("Collection", contextType));
			} else if (name.equals("selectOne")) {
				setResolvedType(firstOrderOperationCallExpression, contextType);
			} else if (name.equals("collect")) {
				Operation firstOrder = builtinOperations.getOperation(name);
				firstOrder.getReturnTypeExpression().accept(this);
				setResolvedType(firstOrder.getReturnTypeExpression(), getResolvedType(targetExpression));

				if (!(getResolvedType(firstOrder.getReturnTypeExpression()) instanceof EolAnyType))
					((EolCollectionType) getResolvedType(firstOrder.getReturnTypeExpression())).setContentType(
							getResolvedType(firstOrderOperationCallExpression.getExpressions().get(0)));

				setResolvedType(firstOrderOperationCallExpression, new EolCollectionType(getResolvedType(targetExpression).getName(),
								getResolvedType(firstOrderOperationCallExpression.getExpressions().get(0))));

			} else if (StringUtil.isOneOf(name, "exists", "forAll", "one", "none", "nMatch")) {
				setResolvedType(firstOrderOperationCallExpression, EolPrimitiveType.Boolean);
			} else if (name.equals("aggregate")) {
				if (firstOrderOperationCallExpression.getExpressions().size() == 2) {
					Expression valueExpression = firstOrderOperationCallExpression.getExpressions().get(1);
					valueExpression.accept(this);

					setResolvedType(firstOrderOperationCallExpression, new EolMapType(getResolvedType(expression), getResolvedType(valueExpression)));
				} else {
					errors.add(new ModuleMarker(firstOrderOperationCallExpression.getNameExpression(),
							"Aggregate requires a key and a value expression", Severity.Error));

				}
			} else if (name.equals("mapBy")) {
				setResolvedType(firstOrderOperationCallExpression, new EolMapType(getResolvedType(expression), new EolCollectionType("Sequence", contextType)));
			} else if (name.equals("sortBy")) {
				setResolvedType(firstOrderOperationCallExpression, new EolCollectionType("Sequence", contextType));
			}
			if (StringUtil.isOneOf(name, "select", "selectOne", "reject", "rejectOne", "exists", "one", "none",
					"forAll", "closure") && getResolvedType(expression).isNot(EolPrimitiveType.Boolean)) {

				errors.add(new ModuleMarker(expression, "Expression should return a Boolean but returns a "
						+ getResolvedType(expression).getName() + " instead", Severity.Error));
			}
		} else {
			errors.add(new ModuleMarker(firstOrderOperationCallExpression.getNameExpression(),
					"Operation " + name + " only applies to collections", Severity.Error));
		}
	}

	@Override
	public void visit(ForStatement forStatement) {

		forStatement.getIteratedExpression().accept(this);
		context.getFrameStack().enterLocal(FrameType.UNPROTECTED, forStatement.getBodyStatementBlock(),
				new Variable("loopCount", EolPrimitiveType.Integer), new Variable("hasMore", EolPrimitiveType.Boolean));

		forStatement.getIteratorParameter().accept(this);
		forStatement.getBodyStatementBlock().accept(this);
		context.getFrameStack().leaveLocal(forStatement.getBodyStatementBlock());

		if (hasResolvedType(forStatement.getIteratedExpression())
				&& !(getResolvedType(forStatement.getIteratedExpression()) instanceof EolCollectionType)) {
			errors.add(new ModuleMarker(forStatement.getIteratedExpression(),
					"Collection expected instead of " + getResolvedType(forStatement.getIteratedExpression()),
					Severity.Error));
		}
	}

	@Override
	public void visit(GreaterEqualOperatorExpression greaterEqualOperatorExpression) {
		OperatorExpression operatorExpression = (OperatorExpression) greaterEqualOperatorExpression;
		visitOperatorExpression(operatorExpression);

	}

	@Override
	public void visit(GreaterThanOperatorExpression greaterThanOperatorExpression) {
		OperatorExpression operatorExpression = (OperatorExpression) greaterThanOperatorExpression;
		visitOperatorExpression(operatorExpression);
	}

	@Override
	public void visit(IfStatement ifStatement) {

		Expression conditionExpression = ifStatement.getConditionExpression();
		StatementBlock thenStatementBlock = ifStatement.getThenStatementBlock();
		StatementBlock elseStatementBlock = ifStatement.getElseStatementBlock();

		conditionExpression.accept(this);
		FrameStack frameStack = context.getFrameStack();
		frameStack.enterLocal(FrameType.UNPROTECTED, thenStatementBlock);
		thenStatementBlock.accept(this);
		frameStack.leaveLocal(thenStatementBlock);

		if (elseStatementBlock != null) {
			frameStack.enterLocal(FrameType.UNPROTECTED, elseStatementBlock);
			elseStatementBlock.accept(this);
			context.getFrameStack().leaveLocal(elseStatementBlock);
		}

		if (hasResolvedType(conditionExpression)
				&& getResolvedType(conditionExpression) != EolPrimitiveType.Boolean) {
			errors.add(new ModuleMarker(conditionExpression, "Condition must be a Boolean", Severity.Error));
		}

	}

	@Override
	public void visit(ImpliesOperatorExpression impliesOperatorExpression) {
		OperatorExpression operatorExpression = (OperatorExpression) impliesOperatorExpression;
		visitOperatorExpression(operatorExpression);
	}

	@Override
	public void visit(Import import_) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(IntegerLiteral integerLiteral) {
		setResolvedType(integerLiteral, EolPrimitiveType.Integer);

	}

	@Override
	public void visit(ItemSelectorExpression itemSelectorExpression) {

		itemSelectorExpression.getTargetExpression().accept(this);
		itemSelectorExpression.getIndexExpression().accept(this);

		EolType targetExpressionType = getResolvedType(itemSelectorExpression.getTargetExpression());
		if (targetExpressionType != EolAnyType.Instance) {
			if (targetExpressionType instanceof EolCollectionType) {
				setResolvedType(itemSelectorExpression, ((EolCollectionType) targetExpressionType).getContentType());
			} else {
				errors.add(new ModuleMarker(itemSelectorExpression.getIndexExpression(),
						"[...] only applies to collections", Severity.Error));
			}
		}

	}

	@Override
	public void visit(LessEqualOperatorExpression lessEqualOperatorExpression) {
		OperatorExpression operatorExpression = (OperatorExpression) lessEqualOperatorExpression;
		visitOperatorExpression(operatorExpression);
	}

	@Override
	public void visit(LessThanOperatorExpression lessThanOperatorExpression) {
		OperatorExpression operatorExpression = (OperatorExpression) lessThanOperatorExpression;
		visitOperatorExpression(operatorExpression);
	}

	@Override
	public void visit(MapLiteralExpression<?, ?> mapLiteralExpression) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(MinusOperatorExpression minusOperatorExpression) {
		OperatorExpression operatorExpression = (OperatorExpression) minusOperatorExpression;
		visitOperatorExpression(operatorExpression);
	}

	@Override
	public void visit(ModelDeclaration modelDeclaration) {

		if (context.getModelFactory() == null)
			return;
		modelDeclaration
				.setModel(context.getModelFactory().createModel(modelDeclaration.getDriverNameExpression().getName()));
		(modelDeclaration.getModel()).setName(modelDeclaration.getNameExpression().getName());

		if (modelDeclaration.getModel() == null) {
			context.addErrorMarker(modelDeclaration.getDriverNameExpression(),
					"Unknown type of model: " + modelDeclaration.getDriverNameExpression().getName());
		} else {
			StringProperties stringProperties = new StringProperties();
			for (ModelDeclarationParameter parameter : modelDeclaration.getModelDeclarationParameters()) {
				stringProperties.put(parameter.getKey(), parameter.getValue());
			}
			modelDeclaration.setMetamodel(
					modelDeclaration.getModel().getMetamodel(stringProperties, context.getRelativePathResolver()));
			if (modelDeclaration.getMetamodel() != null) {
				for (String error : modelDeclaration.getMetamodel().getErrors()) {
					errors.add(new ModuleMarker(modelDeclaration, error, Severity.Error));
				}
				for (String warning : modelDeclaration.getMetamodel().getWarnings()) {
					errors.add(new ModuleMarker(modelDeclaration, warning, Severity.Warning));
				}
			}
		}
		
	}

	@Override
	public void visit(ModelDeclarationParameter modelDeclarationParameter) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(NameExpression nameExpression) {

		EolModelElementType modelElementType;
		Variable variable = context.getFrameStack().get(nameExpression.getName());
		if (variable != null) {
			setResolvedType(nameExpression, variable.getType());
		} else {
			modelElementType = context.getModelElementType(nameExpression.getName());
			if (modelElementType != null) {
				setResolvedType(nameExpression, modelElementType);
				nameExpression.setTypeName(true);
				if (modelElementType.getMetaClass() == null && !context.getModelDeclarations().isEmpty()) {

					errors.add(new ModuleMarker(nameExpression, "Unknown type " + nameExpression.getName(),
							Severity.Error));
				}

			} else {

				errors.add(new ModuleMarker(nameExpression, "Undefined variable or type " + nameExpression.getName(),
						Severity.Error));
			}
		}
	}

	@Override
	public void visit(NegativeOperatorExpression negativeOperatorExpression) {
		OperatorExpression operatorExpression = (OperatorExpression) negativeOperatorExpression;
		visitOperatorExpression(operatorExpression);
	}

	@Override
	public void visit(NewInstanceExpression newInstanceExpression) {

		newInstanceExpression.getTypeExpression().accept(this);
		for (Expression parameterExpression : newInstanceExpression.getParameterExpressions()) {
			parameterExpression.accept(this);
		}
		setResolvedType(newInstanceExpression, getResolvedType(newInstanceExpression.getTypeExpression()));
	}

	@Override
	public void visit(NotEqualsOperatorExpression notEqualsOperatorExpression) {
		OperatorExpression operatorExpression = (OperatorExpression) notEqualsOperatorExpression;
		visitOperatorExpression(operatorExpression);
	}

	@Override
	public void visit(NotOperatorExpression notOperatorExpression) {
		OperatorExpression operatorExpression = (OperatorExpression) notOperatorExpression;
		visitOperatorExpression(operatorExpression);
	}

	@Override
	public void visit(Operation operation) {
		TypeExpression contextTypeExpression = operation.getContextTypeExpression();
		EolType contextType = EolNoType.Instance;
		TypeExpression returnTypeExpression = operation.getReturnTypeExpression();
		setReturnFlag(operation, false);

		if (contextTypeExpression != null) {
			contextTypeExpression.accept(this);
			contextType = getResolvedType(contextTypeExpression);
		}
		// Variable class changed
		context.getFrameStack().enterLocal(FrameType.PROTECTED, operation, new Variable("self", contextType));

		for (Parameter parameter : operation.getFormalParameters()) {
			parameter.accept(this);
		}
		operation.getBody().accept(this);

		if (getReturnFlag(operation) == false && returnTypeExpression != null)
			errors.add(new ModuleMarker(returnTypeExpression,
					"This operation should return " + returnTypeExpression.getName(), Severity.Error));
		context.getFrameStack().leaveLocal(operation);

	}

	@Override
	public void visit(OperationCallExpression operationCallExpression) {

		OperationList allOperations = ((EolModule) module).getOperations();
		Expression targetExpression = operationCallExpression.getTargetExpression();
		List<Expression> parameterExpressions = operationCallExpression.getParameterExpressions();
		NameExpression nameExpression = operationCallExpression.getNameExpression();
		setOperations(operationCallExpression, new ArrayList<Operation>()); // Assigning an empty array to
																			// OperationCallExpression
		setMatchedOperations(operationCallExpression, new ArrayList<Operation>()); // Assigning an empty array to
																					// OperationCallExpression
		setMatchedReturnType(operationCallExpression, new ArrayList<EolType>()); // Assigning an empty array to
																					// OperationCallExpression
		setMatched(operationCallExpression, false);// for find at least one perfect match/ It doesn't change for every
													// mismatch

		// because one match is enough
		int errorCode = 0; // 1 = mismatch Target 2=number of parameters mismatch 3=parameters type
		// mismatch 4 =undefined Operation // 5 = No-type as target // 6 = No-type as
		// parameter
		EolType contextType = EolAnyType.Instance;

		if (targetExpression != null) {
			targetExpression.accept(this);
			operationCallExpression.setContextless(false);
		} else
			operationCallExpression.setContextless(true);
		for (Expression parameterExpression : parameterExpressions) {
			parameterExpression.accept(this);
		}
		boolean operations_contextless;
		boolean successMatch = false; // for a perfect match -> we should keep it for every closest matched
										// possibility as true
		boolean goForward = false; // for keep checking forward

		for (int i = 0; i < allOperations.size(); i++) {

			if (allOperations.get(i).getContextTypeExpression() != null) {
				operations_contextless = false;
			} else {
				operations_contextless = true;
			}
			if (nameExpression.getName().equals(allOperations.get(i).getName())
					&& (operationCallExpression.isContextless() == operations_contextless)) {
				getOperations(operationCallExpression).add(allOperations.get(i));
			}

		}
		if (getOperations(operationCallExpression).size() == 0) {
			errorCode = 4;
		}

		List<Parameter> reqParams = null;
		EolType contentType, collectionType, expType;

		for (Operation op : getOperations(operationCallExpression)) {
			
			successMatch = false;

			reqParams = op.getFormalParameters();
			if (op.getReturnTypeExpression() != null) {
				op.getReturnTypeExpression().accept(this);
				
				if (getResolvedType(op.getReturnTypeExpression()).toString().equals("EolSelf")) {
					setResolvedType(op.getReturnTypeExpression(), getResolvedType(targetExpression));
				}

				if (getResolvedType(op.getReturnTypeExpression()).toString().equals("EolSelfContentType")) {
					contentType = ((EolCollectionType) getResolvedType(targetExpression)).getContentType();
					// Change the condition here! It would be ModelElementType
					while ((contentType instanceof EolCollectionType))
						contentType = ((EolCollectionType) contentType).getContentType();
					setResolvedType(op.getReturnTypeExpression(), contentType);
				}

				if (getResolvedType(op.getReturnTypeExpression()).toString().equals("EolSelfCollectionType")) {
					collectionType = getResolvedType(targetExpression);
					setResolvedType(op.getReturnTypeExpression(), collectionType);
				}

				if (getResolvedType(op.getReturnTypeExpression()).toString().equals("EolSelfExpressionType")) {
					expType = getResolvedType(parameterExpressions.get(0));
					setResolvedType(op.getReturnTypeExpression(), expType);
				}
		
				if (getResolvedType(op.getReturnTypeExpression()) instanceof EolCollectionType
						&& ((EolCollectionType)getResolvedType((op.getReturnTypeExpression()))).getContentType().toString().equals("EolSelf") ) {
					expType = getResolvedType(op.getReturnTypeExpression());
					((EolCollectionType)expType).setContentType(getResolvedType(targetExpression));
					setResolvedType(op.getReturnTypeExpression(), expType);
				}
			}

			if (!operationCallExpression.isContextless() && !getMatched(operationCallExpression)) {

				contextType = getResolvedType(targetExpression);
				op.getContextTypeExpression().accept(this);
				EolType reqContextType = getResolvedType(op.getContextTypeExpression());
				if (reqContextType instanceof EolModelElementType
						&& ((EolModelElementType) reqContextType).getMetaClass() != null)
					reqContextType = new EolModelElementType(((EolModelElementType) reqContextType).getMetaClass());
				if (contextType instanceof EolModelElementType
						&& ((EolModelElementType) contextType).getMetaClass() != null)
					contextType = new EolModelElementType(((EolModelElementType) contextType).getMetaClass());

				if (isCompatible(reqContextType, contextType)) {

					errorCode = 0;
					goForward = true;

				} else if (canBeCompatible(reqContextType, contextType)) {

					errors.add(new ModuleMarker(
							targetExpression, nameExpression.getName() + " may not be invoked on "
									+ getResolvedType(targetExpression) + ", as it requires " + reqContextType,
							Severity.Warning));

				}  else if (targetExpression instanceof OperationCallExpression) {
					if (!getMatchedReturnType(((OperationCallExpression) targetExpression)).isEmpty()) {
						for (int i = 0; i < getMatchedReturnType(((OperationCallExpression) targetExpression))
								.size(); i++) {
							contextType = getMatchedReturnType(((OperationCallExpression) targetExpression)).get(i);

							if (isCompatible(getResolvedType(op.getContextTypeExpression()), contextType)) {
								errorCode = 0;
								goForward = true;
								break;
							} else {
								errorCode = 1;
								goForward = false;
							}
						}
					}

					else {
						setMatched(operationCallExpression, false);
						errorCode = 5;
						goForward = false;
						break;
					}
				}

				else {

					setMatched(operationCallExpression, false);
					errorCode = 1;
					goForward = false;
				}

			} else
				goForward = true;

			if (goForward) {

				if (goForward && reqParams.size() > 0) {

					if (reqParams.size() == parameterExpressions.size()) {

						int index = 0;
						errorCode = 0;

						for (Parameter parameterExpression : reqParams) {

							parameterExpression.getTypeExpression().accept(this);
							if (parameterExpressions.get(index) instanceof OperationCallExpression
									&& (getMatched((OperationCallExpression) parameterExpressions.get(index)))) {

								ArrayList<EolType> matchTypes = new ArrayList<EolType>();
								matchTypes = getMatchedReturnType(
										(OperationCallExpression) parameterExpressions.get(index));

								if (!(matchTypes.isEmpty()))

									for (EolType matchType : matchTypes) {
										if (getResolvedType(parameterExpression.getTypeExpression())
												.equals(matchType)) {
											setResolvedType(parameterExpressions.get(index), matchType);
											break;
										} else
											setResolvedType(parameterExpressions.get(index), matchType);

									}
								else {
									errorCode = 6;
									goForward = false;
									break;
								}
							}

							EolType reqParameter = getResolvedType(parameterExpression.getTypeExpression());
							EolType provPrameter = getResolvedType(parameterExpressions.get(index));

							if (isCompatible(reqParameter, provPrameter)) {
								setMatched(operationCallExpression, true);
								successMatch = true;
								errorCode = 0;

							} else if (canBeCompatible(reqParameter, provPrameter)) {
								setMatched(operationCallExpression, true);
								successMatch = true;
								errors.add(new ModuleMarker(
										nameExpression, " Parameter " + provPrameter
												+ " might not match, as it requires " + reqParameter,
										Severity.Warning));
							} else if (getMatchedReturnType(operationCallExpression).isEmpty()) {
								// Bcz if we found the perfect match before, no need to make success false at
								// the end
								errorCode = 3;
								setMatched(operationCallExpression, false);
								break;
							}

							index++;
						}

						if (getMatched(operationCallExpression)) {
							if (!(getReturnFlag(op)))
								setResolvedType(operationCallExpression, EolNoType.Instance);
							else {
								setResolvedType(operationCallExpression, getResolvedType(op.getReturnTypeExpression()));
								getMatchedReturnType(operationCallExpression)
										.add(getResolvedType(operationCallExpression));
							}
						}
					} else {
						errorCode = 2;

					}
				} else if (parameterExpressions.size() == 0 && errorCode == 0) {
					setMatched(operationCallExpression, true);
					successMatch = true;

					if (successMatch) {
						if (!(getReturnFlag(op)))
							setResolvedType(operationCallExpression, EolNoType.Instance);
						else {
							setResolvedType(operationCallExpression, getResolvedType(op.getReturnTypeExpression()));
							getMatchedReturnType(operationCallExpression)
									.add(getResolvedType(operationCallExpression));
						}
					}

				} else if (parameterExpressions.size() != 0) {

					errorCode = 2;
				}
			}

			if (successMatch)
				getMatchedOperations(operationCallExpression).add(op);
			getExactMatchedOperation(operationCallExpression);
		}

		if (!getMatched(operationCallExpression) || getOperations(operationCallExpression).size() == 0)
			switch (errorCode) {
			case 1:
				errors.add(new ModuleMarker(targetExpression,
						nameExpression.getName() + " can not be invoked on " + getResolvedType(targetExpression),
						Severity.Error));
				break;
			case 2:
				errors.add(new ModuleMarker(nameExpression, "Number of parameters doesn't match, as "
						+ nameExpression.getName() + " requires " + reqParams.size() + " parameters", Severity.Error));
				break;
			case 3:
				errors.add(new ModuleMarker(nameExpression, "Parameters type mismatch", Severity.Error));
				break;
			case 4:
				errors.add(new ModuleMarker(nameExpression, "Undefined operation", Severity.Error));
				break;
			case 5:
				errors.add(new ModuleMarker(nameExpression, nameExpression.getName() + " can not be invoked on "
						+ ((OperationCallExpression) targetExpression).getNameExpression().getName() + ", as it's void",
						Severity.Error));
				break;
			case 6:
				errors.add(new ModuleMarker(nameExpression, "Parameters type mismatch, as it's void", Severity.Error));
				break;
			}

	}

	@Override
	public void visit(OrOperatorExpression orOperatorExpression) {
		OperatorExpression operatorExpression = (OperatorExpression) orOperatorExpression;
		visitOperatorExpression(operatorExpression);
	}

	@Override
	public void visit(Parameter parameter) {
		if (context.getFrameStack().contains(parameter.getName()))
			visit(parameter, false);
		else
			visit(parameter, true);
	}

	public void visit(Parameter parameter, boolean createVariable) {
		if (parameter.getTypeExpression() != null) {
			parameter.getTypeExpression().accept(this);
		}
		if (createVariable) {
			context.getFrameStack().put(new Variable(parameter.getName(), getType(parameter)));
		}
	}

	@Override
	public void visit(PlusOperatorExpression plusOperatorExpression) {
		OperatorExpression operatorExpression = (OperatorExpression) plusOperatorExpression;
		visitOperatorExpression(operatorExpression);
	}

	@Override
	public void visit(PostfixOperatorExpression postfixOperatorExpression) {
		OperatorExpression operatorExpression = (OperatorExpression) postfixOperatorExpression;
		visitOperatorExpression(operatorExpression);
	}

	@Override
	public void visit(PropertyCallExpression propertyCallExpression) {
		Expression targetExpression = propertyCallExpression.getTargetExpression();
		NameExpression nameExpression = propertyCallExpression.getNameExpression();
		targetExpression.accept(this);

		// Extended properties
		if (nameExpression.getName().startsWith("~")) {
			setResolvedType(propertyCallExpression, EolAnyType.Instance);
		}
		// e.g. EPackage.all
		else if (targetExpression instanceof NameExpression && ((NameExpression) targetExpression).isTypeName()) {
			if (getResolvedType(((NameExpression) targetExpression)) instanceof EolModelElementType) {
				if (nameExpression.getName().equals("all") || nameExpression.getName().equals("allInstances")) {
					setResolvedType(propertyCallExpression, new EolCollectionType("Sequence", getResolvedType(targetExpression)));

				} else {
					EolType type = getResolvedType(targetExpression);

					boolean many = false;
					MetaClass metaClass = null;
					if (type instanceof EolModelElementType && ((EolModelElementType) type).getMetaClass() != null) {
						metaClass = (MetaClass) ((EolModelElementType) type).getMetaClass();
					} else if (type instanceof EolCollectionType
							&& ((EolCollectionType) type).getContentType() instanceof EolModelElementType) {
						metaClass = ((EolModelElementType) ((EolCollectionType) type).getContentType()).getMetaClass();
						many = true;
					}

					if (metaClass != null) {
						StructuralFeature structuralFeature = metaClass.getStructuralFeature(nameExpression.getName());
						if (structuralFeature != null) {
							if (structuralFeature.isMany()) {
								EolCollectionType collectionType = null;
								if (structuralFeature.isOrdered()) {
									if (structuralFeature.isUnique())
										collectionType = new EolCollectionType("OrderedSet");
									else
										collectionType = new EolCollectionType("Sequence");
								} else {
									if (structuralFeature.isUnique())
										collectionType = new EolCollectionType("Set");
									else
										collectionType = new EolCollectionType("Bag");
								}
								collectionType.setContentType(structuralFeature.getType());
								setResolvedType(propertyCallExpression, collectionType);
							} else {
								setResolvedType(propertyCallExpression, structuralFeature.getType());
							}
							if (many) {
								setResolvedType(propertyCallExpression, 
										new EolCollectionType("Sequence", getResolvedType(propertyCallExpression)));
							}
						} else {
							errors.add(new ModuleMarker(nameExpression, "Structural feature " + nameExpression.getName()
									+ " not found in type " + metaClass.getName(), Severity.Warning));
						}
					}

				}
			}
		}
		// Regular properties
		else {
			EolType type = getResolvedType(targetExpression);

			boolean many = false;
			MetaClass metaClass = null;
			if (type instanceof EolModelElementType && ((EolModelElementType) type).getMetaClass() != null) {
				metaClass = (MetaClass) ((EolModelElementType) type).getMetaClass();
			} else if (type instanceof EolCollectionType
					&& ((EolCollectionType) type).getContentType() instanceof EolModelElementType) {
				metaClass = ((EolModelElementType) ((EolCollectionType) type).getContentType()).getMetaClass();
				many = true;
			}

			if (metaClass != null) {
				StructuralFeature structuralFeature = metaClass.getStructuralFeature(nameExpression.getName());
				if (structuralFeature != null) {
					if (structuralFeature.isMany()) {
						String collectionTypeName;
						if (structuralFeature.isOrdered()) {
							collectionTypeName = structuralFeature.isUnique() ? "OrderedSet" : "Sequence";
						} else {
							collectionTypeName = structuralFeature.isUnique() ? "Set" : "Bag";
							if (structuralFeature.isConcurrent()) {
								collectionTypeName = "Concurrent" + collectionTypeName;
							}
						}
						setResolvedType(propertyCallExpression, new EolCollectionType(collectionTypeName));
						((EolCollectionType) getResolvedType(propertyCallExpression))
								.setContentType(structuralFeature.getType());
					} else {
						setResolvedType(propertyCallExpression, structuralFeature.getType());
					}
					if (many) {
						setResolvedType(propertyCallExpression, new EolCollectionType("Sequence", getResolvedType(propertyCallExpression)));
					}

				} else {
					errors.add(new ModuleMarker(nameExpression, "Structural feature " + nameExpression.getName()
							+ " not found in type " + metaClass.getName(), Severity.Warning));
				}
			}

		}

	}

	@Override
	public void visit(RealLiteral realLiteral) {
		setResolvedType(realLiteral, EolPrimitiveType.Real);
	}

	@Override
	public void visit(ReturnStatement returnStatement) {
		Expression returnedExpression = returnStatement.getReturnedExpression();
		if (returnedExpression != null) {

			returnedExpression.accept(this);
			EolType providedReturnType = getResolvedType(returnedExpression);

			ModuleElement parent = returnedExpression.getParent();

			while (!(parent instanceof Operation) && parent != null) {

				parent = parent.getParent();

			}

			if (parent instanceof Operation) {
				setReturnFlag(((Operation) parent), true);
				// add for setting resolved type
				if (((Operation) parent).getReturnTypeExpression() == null)
					((Operation) parent).setReturnTypeExpression(new TypeExpression("Any"));

				(((Operation) parent).getReturnTypeExpression()).accept(this);
				EolType requiredReturnType = getResolvedType(((Operation) parent).getReturnTypeExpression());

				if (!(isCompatible(requiredReturnType, providedReturnType))) {
					if (canBeCompatible(requiredReturnType, providedReturnType))
						errors.add(new ModuleMarker(returnedExpression, "Return type might be " + requiredReturnType
								+ " instead of " + getResolvedType(returnedExpression), Severity.Warning));
					else
						errors.add(new ModuleMarker(returnedExpression, "Return type should be " + requiredReturnType
								+ " instead of " + getResolvedType(returnedExpression), Severity.Error));

				}
			}
		}

	}

	@Override
	public void visit(SimpleAnnotation simpleAnnotation) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(StatementBlock statementBlock) {

		statementBlock.getStatements().forEach(s -> s.accept(this));

	}

	@Override
	public void visit(StringLiteral stringLiteral) {
		setResolvedType(stringLiteral, EolPrimitiveType.String);
	}

	@Override
	public void visit(SwitchStatement switchStatement) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(TernaryExpression ternaryExpression) {
		OperatorExpression operatorExpression = (OperatorExpression) ternaryExpression;
		visitOperatorExpression(operatorExpression);
	}

	@Override
	public void visit(ThrowStatement throwStatement) {
		throwStatement.getThrown().accept(this);
	}

	@Override
	public void visit(TimesOperatorExpression timesOperatorExpression) {
		OperatorExpression operatorExpression = (OperatorExpression) timesOperatorExpression;
		visitOperatorExpression(operatorExpression);
	}

	@Override
	public void visit(TransactionStatement transactionStatement) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void visit(TypeExpression typeExpression) {
		EolType type =  TypeExpression.getType(typeExpression.getName()); //typeExpression.getCompilationType();

		for (TypeExpression typeExp : typeExpression.getParameterTypeExpressions()) {
			typeExp.accept(this);
		}

		if (type instanceof EolPrimitiveType) {
			setResolvedType(typeExpression, type);
		}

		if (type == null) {
			
			switch (typeExpression.getName()) {
			case "EolSelf": type = new EolSelf(); setResolvedType(typeExpression, type); break;
			case "EolSelfContentType": type = new EolSelfContentType(); setResolvedType(typeExpression, type); break;
			case "EolSelfExpressionType": type = new EolSelfExpressionType(); setResolvedType(typeExpression, type); break;
			case "EolSelfCollectionType": type = new EolSelfCollectionType(); setResolvedType(typeExpression, type); break;
			}
		}
		
		if (type instanceof EolCollectionType) {
			setResolvedType(typeExpression, type);
			if (typeExpression.getParameterTypeExpressions().size() == 1) {
				((EolCollectionType) type)
						.setContentType(getResolvedType(typeExpression.getParameterTypeExpressions().get(0)));
				setResolvedType(typeExpression, type);
			} else if (typeExpression.getParameterTypeExpressions().size() > 1) {
				errors.add(new ModuleMarker(typeExpression, "Collection types can have at most one content type",
						Severity.Error));
			}
		}

		if (type instanceof EolMapType) {
			if (typeExpression.getParameterTypeExpressions().size() == 2) {
				((EolMapType) type)
						.setKeyType(getResolvedType(typeExpression.getParameterTypeExpressions().get(0)));
				((EolMapType) type)
						.setValueType(getResolvedType(typeExpression.getParameterTypeExpressions().get(1)));
			} else if (typeExpression.getParameterTypeExpressions().size() > 0) {
				errors.add(new ModuleMarker(typeExpression, "Maps need two types: key-type and value-type",
						Severity.Error));
			}
		}

		if (type == null) {
			// TODO: Remove duplication between this and NameExpression
			EolModelElementType modelElementType = context.getModelElementType(typeExpression.getName());
			if (modelElementType != null) {
				type = modelElementType;
				// System.out.println("Printing:"+modelElementType.getMetaClass().getSuperTypes().get(0).getName());
				if (modelElementType.getMetaClass() == null && !context.getModelDeclarations().isEmpty()) {
					errors.add(new ModuleMarker(typeExpression, "Unknown type " + typeExpression.getName(),
							Severity.Error));
				}
			} else {
				errors.add(new ModuleMarker(typeExpression, "Undefined variable or type " + typeExpression.getName(),
						Severity.Error));
			}
		}
		if (type instanceof EolModelElementType)
			setResolvedType(typeExpression, type);

	}

	@Override
	public void visit(VariableDeclaration variableDeclaration) {

		EolType type;
		TypeExpression typeExpression = variableDeclaration.getTypeExpression();

		if (typeExpression != null) {
			typeExpression.accept(this);
			type = getResolvedType(typeExpression);
		} else {
			type = EolAnyType.Instance;
		}

		if (context.getFrameStack().getTopFrame().contains(variableDeclaration.getName())) {
			errors.add(new ModuleMarker(variableDeclaration,
					"Variable " + variableDeclaration.getName() + " has already been defined", Severity.Error));
		} else {
			context.getFrameStack().put(new Variable(variableDeclaration.getName(), type));
			setResolvedType(variableDeclaration, type);
		}

	}

	@Override
	public void visit(WhileStatement whileStatement) {

		FrameStack frameStack = context.getFrameStack();
		Expression conditionExpression = whileStatement.getConditionExpression();
		StatementBlock bodyStatementBlock = whileStatement.getBodyStatementBlock();

		conditionExpression.accept(this);

		frameStack.enterLocal(FrameType.UNPROTECTED, bodyStatementBlock);
		bodyStatementBlock.accept(this);
		;
		frameStack.leaveLocal(bodyStatementBlock);

		if (hasResolvedType(conditionExpression)
				&& getResolvedType(conditionExpression) != EolPrimitiveType.Boolean) {
			errors.add(new ModuleMarker(conditionExpression, "Condition must be a Boolean", Severity.Error));
		}
	}

	@Override
	public void visit(XorOperatorExpression xorOperatorExpression) {
		OperatorExpression operatorExpression = (OperatorExpression) xorOperatorExpression;
		visitOperatorExpression(operatorExpression);
	}

	public void preValidate(IEolModule imodule) {

		
		EolModule eolModule = (EolModule) imodule;
		this.module = eolModule;

		for (ModelDeclaration modelDeclaration : module.getDeclaredModelDeclarations()) {
			modelDeclaration.accept(this);
		}
		
		context.setModelDeclarations(module.getDeclaredModelDeclarations());

		if (!(module instanceof BuiltinEolModule)) {
			try {
				builtinModule.parse(EolStaticAnalyser.class.getResource("builtin.eol").toURI());
				module.getOperations().addAll(builtinModule.getDeclaredOperations());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// Check the signature of functions
		for (Operation operation : module.getOperations()) {
			if (operation.getReturnTypeExpression() == null) {

				if (hasReturnStatement(operation)) {
					setReturnFlag(operation, true);
					operation.setReturnTypeExpression(new TypeExpression("Any"));
				} else
					setReturnFlag(operation, false);

			}
			// when returnType is not null
			else {

				if (hasReturnStatement(operation))
					setReturnFlag(operation, true);
				else {
					if ((operation.getAnnotation("builtin") != null) || (operation.getAnnotation("firstorder") != null))
						setReturnFlag(operation, true);
					else
						setReturnFlag(operation, false);
				}
			}
		}
	}

	public void mainValidate(IEolModule module) {
		
		if (module.getMain() != null)
			module.getMain().accept(this);

		module.getDeclaredOperations().forEach(o -> o.accept(this));
	}

	public void postValidate(IEolModule module) {

		if (!(module instanceof BuiltinEolModule))
			module.getOperations().removeAll(builtinModule.getDeclaredOperations());
			context.getFrameStack().dispose();
	}

	@Override
	public List<ModuleMarker> validate(IModule imodule) {

		errors = new ArrayList<>();
		EolModule eolModule = (EolModule) imodule;
		this.module = eolModule;

		preValidate(module);
		mainValidate(module);
		postValidate(module);

		return errors;
	}

	@Override
	public String getMarkerType() {
		return AbstractModuleEditor.PROBLEM_MARKER;
	}

	public void createTypeCompatibilityWarning(Expression requiredExpression, Expression providedExpression) {
		errors.add(new ModuleMarker(providedExpression, getResolvedType(providedExpression)
				+ " may not be assigned to " + getResolvedType(requiredExpression), Severity.Warning));
	}

	public void createTypeCompatibilityError(Expression requiredExpression, Expression providedExpression) {
		errors.add(new ModuleMarker(providedExpression,
				getResolvedType(providedExpression) + " cannot be assigned to " + getResolvedType(requiredExpression),
				Severity.Error));
	}

	public Operation getExactMatchedOperation(OperationCallExpression oc) {
		List<Operation> operations = matchedOperations.get(oc);
		if (operations == null)
			return null;
		if (operations.isEmpty())
			return null;
		if (operations.size() > 1) {
			// Check contextType
			for (Operation operation : operations) {
				if (operation.getContextTypeExpression() != null) {
					EolType operationContextType = getResolvedType(operation.getContextTypeExpression());
					EolType opCallExpContextType = getResolvedType(oc.getTargetExpression());

					if (isCompatible(operationContextType, opCallExpContextType)) {
						int loopCounter = 0;
						if (oc.getParameterExpressions().size() > 1) {
							for (Expression parameter : oc.getParameterExpressions()) {
								EolType paramContextType = getResolvedType(
										operation.getFormalParameters().get(loopCounter).getTypeExpression());
								EolType paramTargetType = getResolvedType(parameter);
								if (isCompatible(paramContextType, paramTargetType)) {
									oc.getData().put("exactMatch", operation);
									return operation;
								}
								loopCounter++;
							}
							loopCounter = 0;
							for (Expression parameter : oc.getParameterExpressions()) {
								EolType paramContextType = getResolvedType(
										operation.getFormalParameters().get(loopCounter).getTypeExpression());
								EolType paramTargetType = getResolvedType(parameter);
								if (canBeCompatible(paramContextType, paramTargetType)) {
									oc.getData().put("exactMatch", operation);
									return operation;
								}
								loopCounter++;
							}

						}
						return operation;

					} else if (canBeCompatible(operationContextType, opCallExpContextType)) {
						int loopCounter = 0;
						if (oc.getParameterExpressions().size() > 1) {
							for (Expression parameter : oc.getParameterExpressions()) {
								EolType paramContextType = getResolvedType(
										operation.getFormalParameters().get(loopCounter).getTypeExpression());
								EolType paramTargetType = getResolvedType(parameter);
								if (isCompatible(paramContextType, paramTargetType)) {
									oc.getData().put("exactMatch", operation);
									return operation;
								}
								loopCounter++;
							}
							loopCounter = 0;
							for (Expression parameter : oc.getParameterExpressions()) {
								EolType paramContextType = getResolvedType(
										operation.getFormalParameters().get(loopCounter).getTypeExpression());
								EolType paramTargetType = getResolvedType(parameter);
								if (canBeCompatible(paramContextType, paramTargetType)) {
									oc.getData().put("exactMatch", operation);
									return operation;
								}
								loopCounter++;
							}

						}
						oc.getData().put("exactMatch", operation);
						return operation;
					}
				} else {
					if (oc.getParameterExpressions().size() > 1) {
						int loopCounter = 0;
						for (Expression parameter : oc.getParameterExpressions()) {
							EolType paramContextType = getResolvedType(
									operation.getFormalParameters().get(loopCounter).getTypeExpression());
							EolType paramTargetType = getResolvedType(parameter);
							if (isCompatible(paramContextType, paramTargetType)) {
								oc.getData().put("exactMatch", operation);
								return operation;
							}
							loopCounter++;
						}
						loopCounter = 0;
						for (Expression parameter : oc.getParameterExpressions()) {
							EolType paramContextType = getResolvedType(
									operation.getFormalParameters().get(loopCounter).getTypeExpression());
							EolType paramTargetType = getResolvedType(parameter);
							if (canBeCompatible(paramContextType, paramTargetType)) {
								oc.getData().put("exactMatch", operation);
								return operation;
							}
							loopCounter++;
						}

					}
					oc.getData().put("exactMatch", operation);
					return operation;
				}
			}

		}
		oc.getData().put("exactMatch", operations.get(0));
		return operations.get(0);
	}
	
	public boolean isCompatible(EolType targetType, EolType valueType) {

		boolean ok = false;

		if (targetType.equals(EolNoType.Instance) || valueType.equals(EolNoType.Instance))
			return false;
		else

			while (!ok) {
				if (!(targetType.equals(valueType)) && !(targetType instanceof EolAnyType)) {

					if (valueType instanceof EolAnyType) {
						return false;
					}
					
					valueType = getParentType(valueType);


				} else if (targetType instanceof EolAnyType) {
					return true;
				} else if (valueType instanceof EolCollectionType
						&& !((((EolCollectionType) targetType).getContentType()) instanceof EolAnyType)) {

					EolType valueContentType = ((EolCollectionType) valueType).getContentType();
					EolType targetContentType = ((EolCollectionType) targetType).getContentType();

					while (targetContentType instanceof EolCollectionType
							&& valueContentType instanceof EolCollectionType) {
						if (targetContentType.equals(valueContentType)) {
							return isCompatible(((EolCollectionType) targetContentType).getContentType(),
									((EolCollectionType) valueContentType).getContentType());
						} else {
							valueContentType = getParentType(valueContentType);
							return isCompatible(targetContentType, valueContentType);

						}
					}
					while (!ok) {
						if (valueContentType instanceof EolAnyType) {
							return false;
						}
						if (!valueContentType.equals(targetContentType)) {
							valueContentType = getParentType(valueContentType);
						} else {
							return true;
						}
					}
				} else
					return true;
			}
		return false;
	}

	public boolean canBeCompatible(EolType targetType, EolType valueType) {

		boolean ok = false;
		if (targetType == null || valueType == null)
			return false;
		else
			while (!ok) {

				if (!(targetType.equals(valueType)) && !(valueType instanceof EolAnyType)) {

					targetType = getParentType(targetType);

					if (targetType instanceof EolAnyType) {
						return false;
					}

				} else if (valueType instanceof EolAnyType) {
					return true;
				} else if (targetType instanceof EolCollectionType
						&& !((((EolCollectionType) valueType).getContentType()) instanceof EolAnyType)) {

					EolType valueContentType = ((EolCollectionType) valueType).getContentType();
					EolType targetContentType = ((EolCollectionType) targetType).getContentType();

					while (targetContentType instanceof EolCollectionType
							&& valueContentType instanceof EolCollectionType) {
						if (targetContentType.equals(valueContentType)) {
							return canBeCompatible(((EolCollectionType) targetContentType).getContentType(),
									((EolCollectionType) valueContentType).getContentType());
						} else {
							valueContentType = getParentType(valueContentType);
							return canBeCompatible(targetContentType, valueContentType);

						}
					}
					while (!ok) {
						if (valueContentType instanceof EolAnyType || targetContentType instanceof EolAnyType) {
							return true;
						}
						if (!valueContentType.equals(targetContentType)) {
							targetContentType = getParentType(targetContentType);
							if (targetContentType instanceof EolAnyType)
								return false;
						} else {
							return true;
						}
					}
				} else
					return true;
			}
		return false;
	}

	public void visitOperatorExpression(OperatorExpression operatorExpression) {
		Expression firstOperand = operatorExpression.getFirstOperand();
		Expression secondOperand = operatorExpression.getSecondOperand();
		String operator = operatorExpression.getOperator();
		List<Expression> operands = operatorExpression.getOperands();
		
		
		firstOperand.accept(this);
		if (secondOperand != null) secondOperand.accept(this);
		
		if (StringUtil.isOneOf(operator, "and", "or", "xor", "not", "implies")) {
			for (Expression operand : operatorExpression.getOperands()) {
				if (hasResolvedType(operand) && getResolvedType(operand) != EolPrimitiveType.Boolean) {
					errors.add(new ModuleMarker(operatorExpression,
							"Boolean expected instead of " + getResolvedType(operand), Severity.Error));
				}
			}
			setResolvedType(operatorExpression, EolPrimitiveType.Boolean);
		}

		if (StringUtil.isOneOf(operator, "<", ">", ">=", "<=", "*", "/", "-")) {
			for (Expression operand : operands) {
				if (hasResolvedType(operand) && getResolvedType(operand) != EolPrimitiveType.Integer
						&& getResolvedType(operand) != EolPrimitiveType.Real) {
					setResolvedType(operatorExpression, EolAnyType.Instance);
					errors.add(new ModuleMarker(operatorExpression,
							"Number expected instead of " + getResolvedType(operand), Severity.Error));
				} else if (StringUtil.isOneOf(operator, "*", "/", "-")) {
					if (getResolvedType(operand) == EolPrimitiveType.Real)
						setResolvedType(operatorExpression, EolPrimitiveType.Real);
					else
						setResolvedType(operatorExpression, EolPrimitiveType.Integer);
				}
			}
		}

		if (StringUtil.isOneOf(operator, "==", "=", "<>", "<", ">", ">=", "<=")) {
			setResolvedType(operatorExpression, EolPrimitiveType.Boolean);
		}

		if (StringUtil.isOneOf(operator, "+")) {
			for (Expression operand : operands) {
				if (getResolvedType(operand) == EolPrimitiveType.String) {
					setResolvedType(operatorExpression, EolPrimitiveType.String);
					break;
				}

				if (getResolvedType(operand) == EolPrimitiveType.Integer)
					setResolvedType(operatorExpression, EolPrimitiveType.Integer);

				if (getResolvedType(operand) == EolPrimitiveType.Real)
					setResolvedType(operatorExpression, EolPrimitiveType.Real);
			}

		}

	}

	public boolean hasReturnStatement(Operation operation) {
		ArrayList<ModuleElement> statements = new ArrayList<ModuleElement>();
		statements.addAll(operation.getBody().getChildren());

		while (!(statements.isEmpty())) {
			ModuleElement st = statements.get(0);
			statements.remove(st);
			if (!(st.getChildren().isEmpty()))
				statements.addAll(st.getChildren());
			if (st instanceof ReturnStatement)
				return true;
		}
		return false;
	}

	public boolean getReturnFlag(Operation op) {
		return returnFlags.get(op);
	}

	public void setReturnFlag(Operation op, boolean returnFlag) {
		returnFlags.put(op, returnFlag);
	}

	public ArrayList<Operation> getOperations(OperationCallExpression operationCallExpression) {
		return operations.get(operationCallExpression);
	}

	public void setOperations(OperationCallExpression operationCallExpression, ArrayList<Operation> ops) {
		operations.put(operationCallExpression, ops);
	}

	public ArrayList<Operation> getMatchedOperations(OperationCallExpression operationCallExpression) {
		return matchedOperations.get(operationCallExpression);
	}

	public void setMatchedOperations(OperationCallExpression operationCallExpression, ArrayList<Operation> ops) {
		matchedOperations.put(operationCallExpression, ops);
	}

	public ArrayList<EolType> getMatchedReturnType(OperationCallExpression operationCallExpression) {
		return matchedReturnType.get(operationCallExpression);
	}

	public void setMatchedReturnType(OperationCallExpression operationCallExpression, ArrayList<EolType> returnTypes) {
		matchedReturnType.put(operationCallExpression, returnTypes);
	}

	public Boolean getMatched(OperationCallExpression operationCallExpression) {
		return matched.get(operationCallExpression);
	}

	public void setMatched(OperationCallExpression operationCallExpression, boolean match) {
		matched.put(operationCallExpression, match);
	}
	
	public void setResolvedType(Expression expression, EolType type) {
		expression.getData().put("resolvedType", type);
	}
	
	public EolType getResolvedType(Expression expression) {
		EolType resolvedType = (EolType) expression.getData().get("resolvedType");
		if (resolvedType == null) {
			resolvedType = EolAnyType.Instance;
			setResolvedType(expression, resolvedType);
		}
		return resolvedType;
	}

	public boolean hasResolvedType(Expression expresion) {
		EolType resolvedType = getResolvedType(expresion);
		return resolvedType != EolAnyType.Instance;
	}
	
	public EolType getType(Parameter parameter) {
		EolType type = (EolType) parameter.getData().get("type");
	    if (type == null) {
			if (parameter.getTypeExpression() != null) {
				type = getResolvedType(parameter.getTypeExpression());
			}
			else {
				type = EolAnyType.Instance;
			}
			setType(parameter, type);
		}
		return type;
	}
	
	public void setType(Parameter parameter, EolType type) {
		parameter.getData().put("type", type);
	}
	
	/**
	 * TODO: We should be considering all parent types - not just the first one
	 */
	public EolType getParentType(EolType type) {
		if (type.getParentTypes().isEmpty()) return null;
		else return type.getParentTypes().get(0);
	}

	public EolStaticAnalysisContext getContext() {
		return context;
	}
	
	public void setContext(EolStaticAnalysisContext context) {
		this.context = context;
	}
	
}
