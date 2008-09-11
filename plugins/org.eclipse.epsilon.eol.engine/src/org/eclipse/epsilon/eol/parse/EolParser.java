// $ANTLR 3.1b1 E:\\Projects\\Eclipse\\3.4\\workspace3\\org.eclipse.epsilon.eol.engine\\src\\org\\eclipse\\epsilon\\eol\\parse\\Eol.g 2008-09-01 17:23:22

package org.eclipse.epsilon.eol.parse;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;

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
public class EolParser extends org.eclipse.epsilon.commons.parse.EpsilonParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "FLOAT", "DIGIT", "INT", "POINT", "POINT_POINT", "ARROW", "BOOLEAN", "EscapeSequence", "STRING", "StrangeNameLiteral", "Letter", "JavaIDDigit", "NAME", "WS", "COMMENT", "LINE_COMMENT", "Annotation", "FORMAL", "PARAMLIST", "ASSIGNMENT", "SPECIAL_ASSIGNMENT", "HELPERMETHOD", "StatementBlock", "FOR", "IF", "ELSE", "WHILE", "RETURN", "BREAK", "BREAKALL", "CONTINUE", "TRANSACTION", "COLLECTION", "ABORT", "CollectionType", "ModelElementType", "PARAMETERS", "NewExpression", "VAR", "NEW", "ANNOTATIONBLOCK", "EXECUTABLEANNOTATION", "DELETE", "THROW", "EXPRLIST", "EXPRRANGE", "NativeType", "MultiplicativeExpression", "OPERATOR", "FeatureCall", "EOLMODULE", "BLOCK", "FEATURECALL", "TYPE", "ENUMERATION_VALUE", "IMPORT", "'operation'", "'('", "')'", "':'", "'import'", "';'", "'{'", "'}'", "','", "'$'", "'!'", "'::'", "'#'", "'Native'", "'Collection'", "'Sequence'", "'Bag'", "'Set'", "'OrderedSet'", "'for'", "'in'", "'if'", "'else'", "'while'", "'return'", "'throw'", "'delete'", "'break'", "'breakAll'", "'continue'", "'abort'", "'transaction'", "':='", "'::='", "'or'", "'and'", "'xor'", "'implies'", "'='", "'>'", "'<'", "'>='", "'<='", "'<>'", "'+'", "'-'", "'*'", "'/'", "'not'", "'|'", "'new'", "'var'"
    };
    public static final int StatementBlock=26;
    public static final int WHILE=30;
    public static final int StrangeNameLiteral=13;
    public static final int NEW=43;
    public static final int FeatureCall=53;
    public static final int EOF=-1;
    public static final int BREAK=32;
    public static final int TYPE=57;
    public static final int T__93=93;
    public static final int T__94=94;
    public static final int T__91=91;
    public static final int IMPORT=59;
    public static final int T__92=92;
    public static final int NAME=16;
    public static final int T__90=90;
    public static final int RETURN=31;
    public static final int NewExpression=41;
    public static final int VAR=42;
    public static final int ANNOTATIONBLOCK=44;
    public static final int NativeType=50;
    public static final int COMMENT=18;
    public static final int ABORT=37;
    public static final int T__99=99;
    public static final int T__98=98;
    public static final int T__97=97;
    public static final int MultiplicativeExpression=51;
    public static final int T__96=96;
    public static final int T__95=95;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int LINE_COMMENT=19;
    public static final int BREAKALL=33;
    public static final int TRANSACTION=35;
    public static final int ELSE=29;
    public static final int EOLMODULE=54;
    public static final int PARAMLIST=22;
    public static final int INT=6;
    public static final int DELETE=46;
    public static final int T__85=85;
    public static final int T__84=84;
    public static final int T__87=87;
    public static final int T__86=86;
    public static final int HELPERMETHOD=25;
    public static final int T__89=89;
    public static final int T__88=88;
    public static final int CollectionType=38;
    public static final int T__71=71;
    public static final int WS=17;
    public static final int T__72=72;
    public static final int T__70=70;
    public static final int JavaIDDigit=15;
    public static final int Annotation=20;
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int T__73=73;
    public static final int EscapeSequence=11;
    public static final int Letter=14;
    public static final int THROW=47;
    public static final int T__79=79;
    public static final int T__78=78;
    public static final int T__77=77;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__66=66;
    public static final int SPECIAL_ASSIGNMENT=24;
    public static final int T__67=67;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__62=62;
    public static final int PARAMETERS=40;
    public static final int T__63=63;
    public static final int POINT=7;
    public static final int FOR=27;
    public static final int ENUMERATION_VALUE=58;
    public static final int FLOAT=4;
    public static final int EXECUTABLEANNOTATION=45;
    public static final int T__61=61;
    public static final int T__60=60;
    public static final int IF=28;
    public static final int ModelElementType=39;
    public static final int BOOLEAN=10;
    public static final int T__107=107;
    public static final int CONTINUE=34;
    public static final int T__108=108;
    public static final int T__109=109;
    public static final int T__103=103;
    public static final int T__104=104;
    public static final int T__105=105;
    public static final int T__106=106;
    public static final int T__111=111;
    public static final int T__110=110;
    public static final int COLLECTION=36;
    public static final int DIGIT=5;
    public static final int EXPRRANGE=49;
    public static final int OPERATOR=52;
    public static final int EXPRLIST=48;
    public static final int T__102=102;
    public static final int T__101=101;
    public static final int T__100=100;
    public static final int POINT_POINT=8;
    public static final int BLOCK=55;
    public static final int FEATURECALL=56;
    public static final int FORMAL=21;
    public static final int ARROW=9;
    public static final int ASSIGNMENT=23;
    public static final int STRING=12;

    // delegates
    public Eol_EolParserRules gEolParserRules;
    // delegators


        public EolParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public EolParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
            gEolParserRules = new Eol_EolParserRules(input, state, this);
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return EolParser.tokenNames; }
    public String getGrammarFileName() { return "E:\\Projects\\Eclipse\\3.4\\workspace3\\org.eclipse.epsilon.eol.engine\\src\\org\\eclipse\\epsilon\\eol\\parse\\Eol.g"; }


    public static class eolModule_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start eolModule
    // E:\\Projects\\Eclipse\\3.4\\workspace3\\org.eclipse.epsilon.eol.engine\\src\\org\\eclipse\\epsilon\\eol\\parse\\Eol.g:89:1: eolModule : ( importStatement )* block ( operationDeclarationOrAnnotationBlock )* -> ^( EOLMODULE ( importStatement )* block ( operationDeclarationOrAnnotationBlock )* ) ;
    public final EolParser.eolModule_return eolModule() throws RecognitionException {
        EolParser.eolModule_return retval = new EolParser.eolModule_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Eol_EolParserRules.importStatement_return importStatement1 = null;

        Eol_EolParserRules.block_return block2 = null;

        Eol_EolParserRules.operationDeclarationOrAnnotationBlock_return operationDeclarationOrAnnotationBlock3 = null;


        RewriteRuleSubtreeStream stream_importStatement=new RewriteRuleSubtreeStream(adaptor,"rule importStatement");
        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        RewriteRuleSubtreeStream stream_operationDeclarationOrAnnotationBlock=new RewriteRuleSubtreeStream(adaptor,"rule operationDeclarationOrAnnotationBlock");
        try {
            // E:\\Projects\\Eclipse\\3.4\\workspace3\\org.eclipse.epsilon.eol.engine\\src\\org\\eclipse\\epsilon\\eol\\parse\\Eol.g:90:2: ( ( importStatement )* block ( operationDeclarationOrAnnotationBlock )* -> ^( EOLMODULE ( importStatement )* block ( operationDeclarationOrAnnotationBlock )* ) )
            // E:\\Projects\\Eclipse\\3.4\\workspace3\\org.eclipse.epsilon.eol.engine\\src\\org\\eclipse\\epsilon\\eol\\parse\\Eol.g:91:2: ( importStatement )* block ( operationDeclarationOrAnnotationBlock )*
            {
            // E:\\Projects\\Eclipse\\3.4\\workspace3\\org.eclipse.epsilon.eol.engine\\src\\org\\eclipse\\epsilon\\eol\\parse\\Eol.g:91:2: ( importStatement )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==64) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // E:\\Projects\\Eclipse\\3.4\\workspace3\\org.eclipse.epsilon.eol.engine\\src\\org\\eclipse\\epsilon\\eol\\parse\\Eol.g:91:3: importStatement
            	    {
            	    pushFollow(FOLLOW_importStatement_in_eolModule62);
            	    importStatement1=importStatement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_importStatement.add(importStatement1.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            pushFollow(FOLLOW_block_in_eolModule67);
            block2=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_block.add(block2.getTree());
            // E:\\Projects\\Eclipse\\3.4\\workspace3\\org.eclipse.epsilon.eol.engine\\src\\org\\eclipse\\epsilon\\eol\\parse\\Eol.g:93:2: ( operationDeclarationOrAnnotationBlock )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==Annotation||LA2_0==60||LA2_0==69) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // E:\\Projects\\Eclipse\\3.4\\workspace3\\org.eclipse.epsilon.eol.engine\\src\\org\\eclipse\\epsilon\\eol\\parse\\Eol.g:93:3: operationDeclarationOrAnnotationBlock
            	    {
            	    pushFollow(FOLLOW_operationDeclarationOrAnnotationBlock_in_eolModule71);
            	    operationDeclarationOrAnnotationBlock3=operationDeclarationOrAnnotationBlock();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_operationDeclarationOrAnnotationBlock.add(operationDeclarationOrAnnotationBlock3.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);



            // AST REWRITE
            // elements: importStatement, operationDeclarationOrAnnotationBlock, block
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 94:2: -> ^( EOLMODULE ( importStatement )* block ( operationDeclarationOrAnnotationBlock )* )
            {
                // E:\\Projects\\Eclipse\\3.4\\workspace3\\org.eclipse.epsilon.eol.engine\\src\\org\\eclipse\\epsilon\\eol\\parse\\Eol.g:94:5: ^( EOLMODULE ( importStatement )* block ( operationDeclarationOrAnnotationBlock )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(EOLMODULE, "EOLMODULE"), root_1);

                // E:\\Projects\\Eclipse\\3.4\\workspace3\\org.eclipse.epsilon.eol.engine\\src\\org\\eclipse\\epsilon\\eol\\parse\\Eol.g:94:17: ( importStatement )*
                while ( stream_importStatement.hasNext() ) {
                    adaptor.addChild(root_1, stream_importStatement.nextTree());

                }
                stream_importStatement.reset();
                adaptor.addChild(root_1, stream_block.nextTree());
                // E:\\Projects\\Eclipse\\3.4\\workspace3\\org.eclipse.epsilon.eol.engine\\src\\org\\eclipse\\epsilon\\eol\\parse\\Eol.g:94:40: ( operationDeclarationOrAnnotationBlock )*
                while ( stream_operationDeclarationOrAnnotationBlock.hasNext() ) {
                    adaptor.addChild(root_1, stream_operationDeclarationOrAnnotationBlock.nextTree());

                }
                stream_operationDeclarationOrAnnotationBlock.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end eolModule

    // Delegated rules
    public Eol_EolParserRules.litteralCollection_return litteralCollection() throws RecognitionException { return gEolParserRules.litteralCollection(); }
    public Eol_EolParserRules.operationDeclarationOrAnnotationBlock_return operationDeclarationOrAnnotationBlock() throws RecognitionException { return gEolParserRules.operationDeclarationOrAnnotationBlock(); }
    public Eol_EolParserRules.formalParameterList_return formalParameterList() throws RecognitionException { return gEolParserRules.formalParameterList(); }
    public Eol_EolParserRules.statementBlock_return statementBlock() throws RecognitionException { return gEolParserRules.statementBlock(); }
    public Eol_EolParserRules.returnStatement_return returnStatement() throws RecognitionException { return gEolParserRules.returnStatement(); }
    public Eol_EolParserRules.simpleFeatureCall_return simpleFeatureCall() throws RecognitionException { return gEolParserRules.simpleFeatureCall(); }
    public Eol_EolParserRules.expressionListOrRange_return expressionListOrRange() throws RecognitionException { return gEolParserRules.expressionListOrRange(); }
    public Eol_EolParserRules.deleteStatement_return deleteStatement() throws RecognitionException { return gEolParserRules.deleteStatement(); }
    public Eol_EolParserRules.unaryExpression_return unaryExpression() throws RecognitionException { return gEolParserRules.unaryExpression(); }
    public Eol_EolParserRules.logicalExpression_return logicalExpression() throws RecognitionException { return gEolParserRules.logicalExpression(); }
    public Eol_EolParserRules.statementB_return statementB() throws RecognitionException { return gEolParserRules.statementB(); }
    public Eol_EolParserRules.parameterList_return parameterList() throws RecognitionException { return gEolParserRules.parameterList(); }
    public Eol_EolParserRules.formalParameter_return formalParameter() throws RecognitionException { return gEolParserRules.formalParameter(); }
    public Eol_EolParserRules.statementA_return statementA() throws RecognitionException { return gEolParserRules.statementA(); }
    public Eol_EolParserRules.block_return block() throws RecognitionException { return gEolParserRules.block(); }
    public Eol_EolParserRules.multiplicativeExpression_return multiplicativeExpression() throws RecognitionException { return gEolParserRules.multiplicativeExpression(); }
    public Eol_EolParserRules.nativeType_return nativeType() throws RecognitionException { return gEolParserRules.nativeType(); }
    public Eol_EolParserRules.abortStatement_return abortStatement() throws RecognitionException { return gEolParserRules.abortStatement(); }
    public Eol_EolParserRules.operationDeclaration_return operationDeclaration() throws RecognitionException { return gEolParserRules.operationDeclaration(); }
    public Eol_EolParserRules.transactionStatement_return transactionStatement() throws RecognitionException { return gEolParserRules.transactionStatement(); }
    public Eol_EolParserRules.additiveExpression_return additiveExpression() throws RecognitionException { return gEolParserRules.additiveExpression(); }
    public Eol_EolParserRules.pathName_return pathName() throws RecognitionException { return gEolParserRules.pathName(); }
    public Eol_EolParserRules.elseStatement_return elseStatement() throws RecognitionException { return gEolParserRules.elseStatement(); }
    public Eol_EolParserRules.expressionRange_return expressionRange() throws RecognitionException { return gEolParserRules.expressionRange(); }
    public Eol_EolParserRules.executableAnnotation_return executableAnnotation() throws RecognitionException { return gEolParserRules.executableAnnotation(); }
    public Eol_EolParserRules.featureCall_return featureCall() throws RecognitionException { return gEolParserRules.featureCall(); }
    public Eol_EolParserRules.annotation_return annotation() throws RecognitionException { return gEolParserRules.annotation(); }
    public Eol_EolParserRules.postfixExpression_return postfixExpression() throws RecognitionException { return gEolParserRules.postfixExpression(); }
    public Eol_EolParserRules.relationalExpression_return relationalExpression() throws RecognitionException { return gEolParserRules.relationalExpression(); }
    public Eol_EolParserRules.newExpression_return newExpression() throws RecognitionException { return gEolParserRules.newExpression(); }
    public Eol_EolParserRules.literal_return literal() throws RecognitionException { return gEolParserRules.literal(); }
    public Eol_EolParserRules.breakAllStatement_return breakAllStatement() throws RecognitionException { return gEolParserRules.breakAllStatement(); }
    public Eol_EolParserRules.whileStatement_return whileStatement() throws RecognitionException { return gEolParserRules.whileStatement(); }
    public Eol_EolParserRules.annotationBlock_return annotationBlock() throws RecognitionException { return gEolParserRules.annotationBlock(); }
    public Eol_EolParserRules.primitiveExpression_return primitiveExpression() throws RecognitionException { return gEolParserRules.primitiveExpression(); }
    public Eol_EolParserRules.expressionOrStatementBlock_return expressionOrStatementBlock() throws RecognitionException { return gEolParserRules.expressionOrStatementBlock(); }
    public Eol_EolParserRules.throwStatement_return throwStatement() throws RecognitionException { return gEolParserRules.throwStatement(); }
    public Eol_EolParserRules.assignmentStatement_return assignmentStatement() throws RecognitionException { return gEolParserRules.assignmentStatement(); }
    public Eol_EolParserRules.collectionType_return collectionType() throws RecognitionException { return gEolParserRules.collectionType(); }
    public Eol_EolParserRules.declarativeFeatureCall_return declarativeFeatureCall() throws RecognitionException { return gEolParserRules.declarativeFeatureCall(); }
    public Eol_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock() throws RecognitionException { return gEolParserRules.statementOrStatementBlock(); }
    public Eol_EolParserRules.forStatement_return forStatement() throws RecognitionException { return gEolParserRules.forStatement(); }
    public Eol_EolParserRules.statement_return statement() throws RecognitionException { return gEolParserRules.statement(); }
    public Eol_EolParserRules.expressionList_return expressionList() throws RecognitionException { return gEolParserRules.expressionList(); }
    public Eol_EolParserRules.expressionStatement_return expressionStatement() throws RecognitionException { return gEolParserRules.expressionStatement(); }
    public Eol_EolParserRules.importStatement_return importStatement() throws RecognitionException { return gEolParserRules.importStatement(); }
    public Eol_EolParserRules.modelElementType_return modelElementType() throws RecognitionException { return gEolParserRules.modelElementType(); }
    public Eol_EolParserRules.variableDeclarationExpression_return variableDeclarationExpression() throws RecognitionException { return gEolParserRules.variableDeclarationExpression(); }
    public Eol_EolParserRules.ifStatement_return ifStatement() throws RecognitionException { return gEolParserRules.ifStatement(); }
    public Eol_EolParserRules.typeName_return typeName() throws RecognitionException { return gEolParserRules.typeName(); }
    public Eol_EolParserRules.breakStatement_return breakStatement() throws RecognitionException { return gEolParserRules.breakStatement(); }
    public Eol_EolParserRules.continueStatement_return continueStatement() throws RecognitionException { return gEolParserRules.continueStatement(); }


 

    public static final BitSet FOLLOW_importStatement_in_eolModule62 = new BitSet(new long[]{0x3000000000111450L,0x0000D2000FFAFE21L});
    public static final BitSet FOLLOW_block_in_eolModule67 = new BitSet(new long[]{0x1000000000100002L,0x0000000000000020L});
    public static final BitSet FOLLOW_operationDeclarationOrAnnotationBlock_in_eolModule71 = new BitSet(new long[]{0x1000000000100002L,0x0000000000000020L});

}