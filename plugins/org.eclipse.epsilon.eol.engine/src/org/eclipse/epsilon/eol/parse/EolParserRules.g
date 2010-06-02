/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 * -----------------------------------------------------------------------------
 * ANTLR 3 License
 * [The "BSD licence"]
 * Copyright (c) 2005-2008 Terence Parr
 * All rights reserved.
 *  
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. The name of the author may not be used to endorse or promote products
 *   derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 * THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 ******************************************************************************/
parser grammar EolParserRules;
options {backtrack=true; output=AST;}

tokens {
	FORMAL;
	PARAMLIST;
	ASSIGNMENT;
	SPECIAL_ASSIGNMENT;
	HELPERMETHOD;
	StatementBlock;
	FOR;
	IF;
	ELSE;
	WHILE;
	SWITCH;
	CASE;
	DEFAULT;
	RETURN;
	BREAK;
	BREAKALL;
	CONTINUE;
	TRANSACTION;
	COLLECTION;
	ABORT;
	CollectionType;
	ModelElementType;
	PARAMETERS;
	NewExpression;
	VAR;
	NEW;
	ANNOTATIONBLOCK;
	EXECUTABLEANNOTATION;
	DELETE;
	THROW;
	EXPRLIST;
	EXPRRANGE;
	NativeType;
	MultiplicativeExpression;
	OPERATOR;
	FeatureCall;
	EOLMODULE;
	BLOCK;
	FEATURECALL;
	TYPE;
	ENUMERATION_VALUE;
	IMPORT;
	MODELDECLARATION;
	NAMESPACE;
	ALIAS;
	DRIVER;
	MODELDECLARATIONPARAMETERS;
	MODELDECLARATIONPARAMETER;
	ITEMSELECTOR;
}

@members {

public void setTokenType(ParserRuleReturnScope tree, int type) {
	((CommonTree) tree.getTree()).getToken().setType(type);
}

}

operationDeclarationOrAnnotationBlock
	: operationDeclaration|annotationBlock
	;

modelDeclaration
	:	'model' NAME modelAlias? modelDriver? modelDeclarationParameters? ';'
	-> ^(MODELDECLARATION NAME (modelAlias)? (modelDriver)? (modelDeclarationParameters)?)
	;
	
modelNamespace
	:   ':' NAME (',' NAME)*
	-> ^(NAMESPACE NAME*)
	;

modelAlias
	:  'alias' NAME (',' NAME)*
	-> ^(ALIAS NAME*)
	;

modelDriver
	:  'driver' NAME
	-> ^(DRIVER NAME)
	;

modelDeclarationParameters
	: '{' modelDeclarationParameter? (',' modelDeclarationParameter)* '}'
	-> ^(MODELDECLARATIONPARAMETERS (modelDeclarationParameter)*)
	;
	
modelDeclarationParameter
	: NAME '=' STRING
	-> ^(MODELDECLARATIONPARAMETER NAME STRING)
	;
	
operationDeclaration
	//:	'operation' (ctx=typeName {$ctx.setType(TYPE);})? operationName=NAME '(' formalParameterList ')' (':' returnType=typeName {$returnType.setType(TYPE);})? statementBlock
	:	('operation'|'function') (ctx=typeName {setTokenType(ctx,TYPE);})? operationName=NAME '(' formalParameterList? ')' (':' returnType=typeName {setTokenType(returnType,TYPE);})? statementBlock
		-> ^(HELPERMETHOD $ctx? $operationName formalParameterList? $returnType? statementBlock)
	;

importStatement
	:	i='import'^ STRING ';'!
	{$i.setType(IMPORT);}
	;

block
	:	statement*
	-> ^(BLOCK statement*)
	;

statementBlock
	:	'{'! block '}'!
	;

formalParameter
	:	NAME (':' pt=typeName {setTokenType(pt,TYPE);})? 
		-> ^(FORMAL NAME typeName?)
	;

formalParameterList
	:	formalParameter (',' formalParameter)*
	-> ^(PARAMLIST formalParameter*)
	;

executableAnnotation
	: '$' NAME logicalExpression
	-> ^(EXECUTABLEANNOTATION NAME logicalExpression)
	;

annotation
	:	Annotation|executableAnnotation
	;

annotationBlock
	: annotation+
	-> ^(ANNOTATIONBLOCK annotation+)
	;
	
typeName
	: pathName | nativeType | collectionType
	{if (root_0.getToken() != null) root_0.getToken().setType(TYPE);}
	;

pathName
	:	(metamodel=NAME! '!'!)? head=NAME
		('::'! field=NAME! {
			head.setText(head.getText()
					+ "::"
					+ field.getText()
					); 
		})*
		('#'! label=NAME!)?
	
		{
			if ($metamodel != null) {
				$head.setText(metamodel.getText() + "!" + head.getText());
				//System.err.println("Metamodel is not null");
			}
				
			if (label != null) {
				$head.setText($head.getText() + "#" + label.getText());
				$head.setType(ENUMERATION_VALUE);
			}	
		}
	;

nativeType
	:	'Native'^ '('! STRING ')'!
	{if (root_0.getToken() != null) root_0.getToken().setType(TYPE);}
	
	;

modelElementType
	:	NAME '!' NAME
	-> ^(ModelElementType NAME+)
	;

collectionType
	: 	('Collection'|'Sequence'|'List'|'Bag'|'Set'|'OrderedSet')^
		('('! tn=typeName {setTokenType(tn,TYPE);}')'!)?
		{if (root_0.getToken() != null) root_0.getToken().setType(TYPE);}
	
	//->	^(CollectionType typeName?)
	;

statement 
	:	statementA | statementB
	;

statementA
	:assignmentStatement | expressionStatement | forStatement
		| ifStatement | whileStatement | switchStatement | returnStatement | breakStatement
	;
	
statementB
	: breakAllStatement | returnStatement | transactionStatement
		| abortStatement | continueStatement | throwStatement
		| deleteStatement
	;

statementOrStatementBlock
	:	statement | statementBlock;

expressionOrStatementBlock
	:	':'! logicalExpression | statementBlock
	;

forStatement
	:	'for' '(' formalParameter 'in' logicalExpression ')' statementOrStatementBlock
	-> ^(FOR formalParameter logicalExpression statementOrStatementBlock)
	;

ifStatement
	:	'if' '(' logicalExpression ')' statementOrStatementBlock elseStatement?
	-> ^(IF logicalExpression statementOrStatementBlock elseStatement?)
	;
	
switchStatement
	:	'switch' '(' logicalExpression ')' '{' caseStatement* defaultStatement? '}'
	-> ^(SWITCH logicalExpression caseStatement* defaultStatement?)
	;
	
caseStatement
	:	'case' logicalExpression ':' statement*
	-> ^(CASE logicalExpression statement*)
	;
	
defaultStatement
	:	'default' ':' statement*
	-> ^(DEFAULT statement*)
	;
	
elseStatement
	:	'else'! statementOrStatementBlock
	//-> ^(ELSE statementOrStatementBlock)
	;

whileStatement
	:	'while' '(' logicalExpression ')' statementOrStatementBlock
	-> ^(WHILE logicalExpression statementOrStatementBlock)
	;

returnStatement
	:	'return' logicalExpression? ';'
	-> ^(RETURN logicalExpression?)
	;

throwStatement
	:	'throw' logicalExpression? ';'
	-> ^(THROW logicalExpression?)
	;

deleteStatement
	:	'delete' logicalExpression? ';'
	-> ^(DELETE logicalExpression?)
	;
			
breakStatement
	:	'break' ';'
	-> ^(BREAK)
	;

breakAllStatement
	:	'breakAll' ';'
	-> ^(BREAKALL)
	;

continueStatement
	:	'continue' ';'
	-> ^(CONTINUE)
	;

abortStatement
	:	'abort' ';'
	-> ^(ABORT)
	;

transactionStatement
	:	'transaction' (NAME (',' NAME)*)? statementOrStatementBlock
	-> ^(TRANSACTION NAME* statementOrStatementBlock)
	;


assignmentStatement
	@after{
		
	}
	:	logicalExpression (normal=':='^ {normal.setType(ASSIGNMENT);}|special='::='^ {special.setType(SPECIAL_ASSIGNMENT);}) logicalExpression ';'!
		
	;

expressionStatement
	:	logicalExpression ';'!
	;


logicalExpression
	:	relationalExpression (('or'|'and'|'xor'|'implies')^ relationalExpression
		{if (root_0.getToken() != null) root_0.getToken().setType(OPERATOR);})*
	;

relationalExpression
	:	additiveExpression (('=='^ relationalExpression? | '='^ relationalExpression? |
	                      ('>'|'<'|'>='|'<='|'<>')^ additiveExpression)
		{if (root_0.getToken() != null) root_0.getToken().setType(OPERATOR);})*
	;

additiveExpression
	:	multiplicativeExpression (('+'|'-')^ multiplicativeExpression
		{if (root_0.getToken() != null) root_0.getToken().setType(OPERATOR);})*
		//{$c.setType(Operator);})*
	;
	
multiplicativeExpression
	:	unaryExpression (('*'|'/')^ unaryExpression
		{if (root_0.getToken() != null) root_0.getToken().setType(OPERATOR);})*
	;

unaryExpression
	:	(('not'|'-')^)? postfixExpression
		{if (root_0.getToken() != null) root_0.getToken().setType(OPERATOR);}
	;
	
postfixExpression
	:	itemSelectorExpression ((POINT|ARROW)^ fc=featureCall
		{setTokenType(fc,FEATURECALL);} ('['^ logicalExpression ']'! {if (root_0.getToken() != null) root_0.getToken().setType(ITEMSELECTOR);})*
		//{
		//	if (root_0.getToken() != null) {
		//		root_0.getToken().setType(POINT);
		//	}
		//}
		)*
	;

itemSelectorExpression 
	: primitiveExpression ('['^ primitiveExpression ']'!
		{if (root_0.getToken() != null) root_0.getToken().setType(ITEMSELECTOR);})*
	;
	
featureCall
	: simpleFeatureCall | declarativeFeatureCall
	;

simpleFeatureCall
	: 	NAME^ parameterList?
	{if (root_0.getToken() != null) root_0.getToken().setType(FEATURECALL);}
	;

parameterList
	:	'(' (logicalExpression (',' logicalExpression)*)? ')'
		-> ^(PARAMETERS logicalExpression*)
	;

declarativeFeatureCall
	:	NAME^ '('! formalParameterList '|'! logicalExpression (','! logicalExpression)* ')'!
	;

newExpression
	:	'new'^ tn=typeName {setTokenType(tn,TYPE);} parameterList?
	{if (root_0.getToken() != null) root_0.getToken().setType(NEW);}
	
	;


variableDeclarationExpression
	@after{
		String txt;
		if (n != null) {txt = "new";}
		else { txt = "var";}
		retval.tree.getToken().setText(txt);
	}
	//:	'var' NAME (':' 'new'? t=typeName {setTokenType(t, TYPE);})?
	:	'var' NAME (':' n='new'? t=typeName {setTokenType(t, TYPE);} parameterList?)? 
	->	^(VAR NAME typeName? parameterList?)
	;

litteralCollection
	:	('Collection'|'Sequence'|'List'|'Bag'|'Set'|'OrderedSet')^ '{'!  expressionListOrRange? '}'!
	{if (root_0.getToken() != null) root_0.getToken().setType(COLLECTION);}
	;

expressionRange
	: logicalExpression '..' logicalExpression
	-> ^(EXPRRANGE logicalExpression+)
	; 

expressionList
	: logicalExpression (',' logicalExpression)*
	-> ^(EXPRLIST logicalExpression+)
	; 

expressionListOrRange
	:	expressionRange | expressionList
	//: logicalExpression
	//'..' logicalExpression {if (root_0.getToken() != null) root_0.getToken().setType(EXPRRANGE);}
	//|
	//(','! logicalExpression)+ {if (root_0.getToken() != null) root_0.getToken().setType(EXPRLIST);}
	
	;

primitiveExpression 
	:	litteralCollection | literal | featureCall | pathName | nativeType
		| collectionType  | '('! logicalExpression ')'! 
		| newExpression | variableDeclarationExpression
	;

literal
	:	STRING | INT | FLOAT | BOOLEAN
	;
