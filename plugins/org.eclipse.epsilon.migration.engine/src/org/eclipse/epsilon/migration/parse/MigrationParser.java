// $ANTLR 3.1b1 /Users/louis/Code/eclipse/workspaces/workspace-epsilon/org.eclipse.epsilon.migration.engine/src/org/eclipse/epsilon/migration/parse/Migration.g 2009-06-13 21:57:18

package org.eclipse.epsilon.migration.parse;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;

/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
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
public class MigrationParser extends org.eclipse.epsilon.commons.parse.EpsilonParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "FLOAT", "DIGIT", "INT", "POINT", "POINT_POINT", "ARROW", "BOOLEAN", "EscapeSequence", "STRING", "StrangeNameLiteral", "Letter", "JavaIDDigit", "NAME", "WS", "COMMENT", "LINE_COMMENT", "Annotation", "FORMAL", "PARAMLIST", "ASSIGNMENT", "SPECIAL_ASSIGNMENT", "HELPERMETHOD", "StatementBlock", "FOR", "IF", "ELSE", "WHILE", "RETURN", "BREAK", "BREAKALL", "CONTINUE", "TRANSACTION", "COLLECTION", "ABORT", "CollectionType", "ModelElementType", "PARAMETERS", "NewExpression", "VAR", "NEW", "ANNOTATIONBLOCK", "EXECUTABLEANNOTATION", "DELETE", "THROW", "EXPRLIST", "EXPRRANGE", "NativeType", "MultiplicativeExpression", "OPERATOR", "FeatureCall", "EOLMODULE", "BLOCK", "FEATURECALL", "TYPE", "ENUMERATION_VALUE", "IMPORT", "MODELDECLARATION", "NAMESPACE", "ALIAS", "MIGRATE", "'model'", "';'", "':'", "','", "'alias'", "'operation'", "'('", "')'", "'import'", "'{'", "'}'", "'$'", "'!'", "'::'", "'#'", "'Native'", "'Collection'", "'Sequence'", "'Bag'", "'Set'", "'OrderedSet'", "'for'", "'in'", "'if'", "'else'", "'while'", "'return'", "'throw'", "'delete'", "'break'", "'breakAll'", "'continue'", "'abort'", "'transaction'", "':='", "'::='", "'or'", "'and'", "'xor'", "'implies'", "'=='", "'='", "'>'", "'<'", "'>='", "'<='", "'<>'", "'+'", "'-'", "'*'", "'/'", "'not'", "'|'", "'new'", "'var'", "'migrate'", "'to'", "'when'"
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
    public static final int ABORT=37;
    public static final int COMMENT=18;
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
    public static final int MODELDECLARATION=60;
    public static final int PARAMLIST=22;
    public static final int INT=6;
    public static final int DELETE=46;
    public static final int T__85=85;
    public static final int T__84=84;
    public static final int T__87=87;
    public static final int T__86=86;
    public static final int HELPERMETHOD=25;
    public static final int T__89=89;
    public static final int NAMESPACE=61;
    public static final int T__88=88;
    public static final int CollectionType=38;
    public static final int T__71=71;
    public static final int WS=17;
    public static final int T__72=72;
    public static final int T__70=70;
    public static final int ALIAS=62;
    public static final int MIGRATE=63;
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
    public static final int PARAMETERS=40;
    public static final int POINT=7;
    public static final int T__118=118;
    public static final int T__119=119;
    public static final int T__116=116;
    public static final int T__117=117;
    public static final int T__114=114;
    public static final int T__115=115;
    public static final int FOR=27;
    public static final int ENUMERATION_VALUE=58;
    public static final int T__121=121;
    public static final int T__120=120;
    public static final int FLOAT=4;
    public static final int EXECUTABLEANNOTATION=45;
    public static final int IF=28;
    public static final int ModelElementType=39;
    public static final int BOOLEAN=10;
    public static final int CONTINUE=34;
    public static final int T__107=107;
    public static final int T__108=108;
    public static final int T__109=109;
    public static final int T__103=103;
    public static final int T__104=104;
    public static final int T__105=105;
    public static final int T__106=106;
    public static final int T__111=111;
    public static final int T__110=110;
    public static final int T__113=113;
    public static final int T__112=112;
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
    public Migration_EolParserRules gEolParserRules;
    // delegators


        public MigrationParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public MigrationParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
            gEolParserRules = new Migration_EolParserRules(input, state, this);
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return MigrationParser.tokenNames; }
    public String getGrammarFileName() { return "/Users/louis/Code/eclipse/workspaces/workspace-epsilon/org.eclipse.epsilon.migration.engine/src/org/eclipse/epsilon/migration/parse/Migration.g"; }


    public static class migrationRule_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start migrationRule
    // /Users/louis/Code/eclipse/workspaces/workspace-epsilon/org.eclipse.epsilon.migration.engine/src/org/eclipse/epsilon/migration/parse/Migration.g:93:1: migrationRule : 'migrate' sourceType= NAME ( 'to' targetType= NAME )? ( 'when' expressionOrStatementBlock )? '{' block '}' -> ^( MIGRATE $sourceType ( $targetType)? ( expressionOrStatementBlock )? block ) ;
    public final MigrationParser.migrationRule_return migrationRule() throws RecognitionException {
        MigrationParser.migrationRule_return retval = new MigrationParser.migrationRule_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token sourceType=null;
        Token targetType=null;
        Token string_literal1=null;
        Token string_literal2=null;
        Token string_literal3=null;
        Token char_literal5=null;
        Token char_literal7=null;
        Migration_EolParserRules.expressionOrStatementBlock_return expressionOrStatementBlock4 = null;

        Migration_EolParserRules.block_return block6 = null;


        CommonTree sourceType_tree=null;
        CommonTree targetType_tree=null;
        CommonTree string_literal1_tree=null;
        CommonTree string_literal2_tree=null;
        CommonTree string_literal3_tree=null;
        CommonTree char_literal5_tree=null;
        CommonTree char_literal7_tree=null;
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_121=new RewriteRuleTokenStream(adaptor,"token 121");
        RewriteRuleTokenStream stream_120=new RewriteRuleTokenStream(adaptor,"token 120");
        RewriteRuleTokenStream stream_73=new RewriteRuleTokenStream(adaptor,"token 73");
        RewriteRuleTokenStream stream_74=new RewriteRuleTokenStream(adaptor,"token 74");
        RewriteRuleTokenStream stream_119=new RewriteRuleTokenStream(adaptor,"token 119");
        RewriteRuleSubtreeStream stream_expressionOrStatementBlock=new RewriteRuleSubtreeStream(adaptor,"rule expressionOrStatementBlock");
        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        try {
            // /Users/louis/Code/eclipse/workspaces/workspace-epsilon/org.eclipse.epsilon.migration.engine/src/org/eclipse/epsilon/migration/parse/Migration.g:94:3: ( 'migrate' sourceType= NAME ( 'to' targetType= NAME )? ( 'when' expressionOrStatementBlock )? '{' block '}' -> ^( MIGRATE $sourceType ( $targetType)? ( expressionOrStatementBlock )? block ) )
            // /Users/louis/Code/eclipse/workspaces/workspace-epsilon/org.eclipse.epsilon.migration.engine/src/org/eclipse/epsilon/migration/parse/Migration.g:94:5: 'migrate' sourceType= NAME ( 'to' targetType= NAME )? ( 'when' expressionOrStatementBlock )? '{' block '}'
            {
            string_literal1=(Token)match(input,119,FOLLOW_119_in_migrationRule71); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_119.add(string_literal1);

            sourceType=(Token)match(input,NAME,FOLLOW_NAME_in_migrationRule75); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(sourceType);

            // /Users/louis/Code/eclipse/workspaces/workspace-epsilon/org.eclipse.epsilon.migration.engine/src/org/eclipse/epsilon/migration/parse/Migration.g:94:31: ( 'to' targetType= NAME )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==120) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // /Users/louis/Code/eclipse/workspaces/workspace-epsilon/org.eclipse.epsilon.migration.engine/src/org/eclipse/epsilon/migration/parse/Migration.g:94:32: 'to' targetType= NAME
                    {
                    string_literal2=(Token)match(input,120,FOLLOW_120_in_migrationRule78); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_120.add(string_literal2);

                    targetType=(Token)match(input,NAME,FOLLOW_NAME_in_migrationRule82); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NAME.add(targetType);


                    }
                    break;

            }

            // /Users/louis/Code/eclipse/workspaces/workspace-epsilon/org.eclipse.epsilon.migration.engine/src/org/eclipse/epsilon/migration/parse/Migration.g:94:55: ( 'when' expressionOrStatementBlock )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==121) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // /Users/louis/Code/eclipse/workspaces/workspace-epsilon/org.eclipse.epsilon.migration.engine/src/org/eclipse/epsilon/migration/parse/Migration.g:94:56: 'when' expressionOrStatementBlock
                    {
                    string_literal3=(Token)match(input,121,FOLLOW_121_in_migrationRule87); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_121.add(string_literal3);

                    pushFollow(FOLLOW_expressionOrStatementBlock_in_migrationRule89);
                    expressionOrStatementBlock4=expressionOrStatementBlock();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expressionOrStatementBlock.add(expressionOrStatementBlock4.getTree());

                    }
                    break;

            }

            char_literal5=(Token)match(input,73,FOLLOW_73_in_migrationRule93); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_73.add(char_literal5);

            pushFollow(FOLLOW_block_in_migrationRule95);
            block6=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_block.add(block6.getTree());
            char_literal7=(Token)match(input,74,FOLLOW_74_in_migrationRule97); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_74.add(char_literal7);



            // AST REWRITE
            // elements: expressionOrStatementBlock, targetType, sourceType, block
            // token labels: sourceType, targetType
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_sourceType=new RewriteRuleTokenStream(adaptor,"token sourceType",sourceType);
            RewriteRuleTokenStream stream_targetType=new RewriteRuleTokenStream(adaptor,"token targetType",targetType);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 95:5: -> ^( MIGRATE $sourceType ( $targetType)? ( expressionOrStatementBlock )? block )
            {
                // /Users/louis/Code/eclipse/workspaces/workspace-epsilon/org.eclipse.epsilon.migration.engine/src/org/eclipse/epsilon/migration/parse/Migration.g:96:5: ^( MIGRATE $sourceType ( $targetType)? ( expressionOrStatementBlock )? block )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(MIGRATE, "MIGRATE"), root_1);

                adaptor.addChild(root_1, stream_sourceType.nextNode());
                // /Users/louis/Code/eclipse/workspaces/workspace-epsilon/org.eclipse.epsilon.migration.engine/src/org/eclipse/epsilon/migration/parse/Migration.g:96:27: ( $targetType)?
                if ( stream_targetType.hasNext() ) {
                    adaptor.addChild(root_1, stream_targetType.nextNode());

                }
                stream_targetType.reset();
                // /Users/louis/Code/eclipse/workspaces/workspace-epsilon/org.eclipse.epsilon.migration.engine/src/org/eclipse/epsilon/migration/parse/Migration.g:96:40: ( expressionOrStatementBlock )?
                if ( stream_expressionOrStatementBlock.hasNext() ) {
                    adaptor.addChild(root_1, stream_expressionOrStatementBlock.nextTree());

                }
                stream_expressionOrStatementBlock.reset();
                adaptor.addChild(root_1, stream_block.nextTree());

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
    // $ANTLR end migrationRule

    // Delegated rules
    public Migration_EolParserRules.modelDeclaration_return modelDeclaration() throws RecognitionException { return gEolParserRules.modelDeclaration(); }
    public Migration_EolParserRules.modelAlias_return modelAlias() throws RecognitionException { return gEolParserRules.modelAlias(); }
    public Migration_EolParserRules.parameterList_return parameterList() throws RecognitionException { return gEolParserRules.parameterList(); }
    public Migration_EolParserRules.modelElementType_return modelElementType() throws RecognitionException { return gEolParserRules.modelElementType(); }
    public Migration_EolParserRules.expressionRange_return expressionRange() throws RecognitionException { return gEolParserRules.expressionRange(); }
    public Migration_EolParserRules.expressionListOrRange_return expressionListOrRange() throws RecognitionException { return gEolParserRules.expressionListOrRange(); }
    public Migration_EolParserRules.logicalExpression_return logicalExpression() throws RecognitionException { return gEolParserRules.logicalExpression(); }
    public Migration_EolParserRules.unaryExpression_return unaryExpression() throws RecognitionException { return gEolParserRules.unaryExpression(); }
    public Migration_EolParserRules.nativeType_return nativeType() throws RecognitionException { return gEolParserRules.nativeType(); }
    public Migration_EolParserRules.assignmentStatement_return assignmentStatement() throws RecognitionException { return gEolParserRules.assignmentStatement(); }
    public Migration_EolParserRules.transactionStatement_return transactionStatement() throws RecognitionException { return gEolParserRules.transactionStatement(); }
    public Migration_EolParserRules.newExpression_return newExpression() throws RecognitionException { return gEolParserRules.newExpression(); }
    public Migration_EolParserRules.additiveExpression_return additiveExpression() throws RecognitionException { return gEolParserRules.additiveExpression(); }
    public Migration_EolParserRules.literal_return literal() throws RecognitionException { return gEolParserRules.literal(); }
    public Migration_EolParserRules.operationDeclaration_return operationDeclaration() throws RecognitionException { return gEolParserRules.operationDeclaration(); }
    public Migration_EolParserRules.statementA_return statementA() throws RecognitionException { return gEolParserRules.statementA(); }
    public Migration_EolParserRules.breakStatement_return breakStatement() throws RecognitionException { return gEolParserRules.breakStatement(); }
    public Migration_EolParserRules.variableDeclarationExpression_return variableDeclarationExpression() throws RecognitionException { return gEolParserRules.variableDeclarationExpression(); }
    public Migration_EolParserRules.statementB_return statementB() throws RecognitionException { return gEolParserRules.statementB(); }
    public Migration_EolParserRules.operationDeclarationOrAnnotationBlock_return operationDeclarationOrAnnotationBlock() throws RecognitionException { return gEolParserRules.operationDeclarationOrAnnotationBlock(); }
    public Migration_EolParserRules.whileStatement_return whileStatement() throws RecognitionException { return gEolParserRules.whileStatement(); }
    public Migration_EolParserRules.continueStatement_return continueStatement() throws RecognitionException { return gEolParserRules.continueStatement(); }
    public Migration_EolParserRules.statement_return statement() throws RecognitionException { return gEolParserRules.statement(); }
    public Migration_EolParserRules.annotation_return annotation() throws RecognitionException { return gEolParserRules.annotation(); }
    public Migration_EolParserRules.executableAnnotation_return executableAnnotation() throws RecognitionException { return gEolParserRules.executableAnnotation(); }
    public Migration_EolParserRules.typeName_return typeName() throws RecognitionException { return gEolParserRules.typeName(); }
    public Migration_EolParserRules.elseStatement_return elseStatement() throws RecognitionException { return gEolParserRules.elseStatement(); }
    public Migration_EolParserRules.importStatement_return importStatement() throws RecognitionException { return gEolParserRules.importStatement(); }
    public Migration_EolParserRules.annotationBlock_return annotationBlock() throws RecognitionException { return gEolParserRules.annotationBlock(); }
    public Migration_EolParserRules.expressionList_return expressionList() throws RecognitionException { return gEolParserRules.expressionList(); }
    public Migration_EolParserRules.pathName_return pathName() throws RecognitionException { return gEolParserRules.pathName(); }
    public Migration_EolParserRules.formalParameter_return formalParameter() throws RecognitionException { return gEolParserRules.formalParameter(); }
    public Migration_EolParserRules.returnStatement_return returnStatement() throws RecognitionException { return gEolParserRules.returnStatement(); }
    public Migration_EolParserRules.forStatement_return forStatement() throws RecognitionException { return gEolParserRules.forStatement(); }
    public Migration_EolParserRules.litteralCollection_return litteralCollection() throws RecognitionException { return gEolParserRules.litteralCollection(); }
    public Migration_EolParserRules.collectionType_return collectionType() throws RecognitionException { return gEolParserRules.collectionType(); }
    public Migration_EolParserRules.breakAllStatement_return breakAllStatement() throws RecognitionException { return gEolParserRules.breakAllStatement(); }
    public Migration_EolParserRules.postfixExpression_return postfixExpression() throws RecognitionException { return gEolParserRules.postfixExpression(); }
    public Migration_EolParserRules.simpleFeatureCall_return simpleFeatureCall() throws RecognitionException { return gEolParserRules.simpleFeatureCall(); }
    public Migration_EolParserRules.formalParameterList_return formalParameterList() throws RecognitionException { return gEolParserRules.formalParameterList(); }
    public Migration_EolParserRules.relationalExpression_return relationalExpression() throws RecognitionException { return gEolParserRules.relationalExpression(); }
    public Migration_EolParserRules.expressionOrStatementBlock_return expressionOrStatementBlock() throws RecognitionException { return gEolParserRules.expressionOrStatementBlock(); }
    public Migration_EolParserRules.statementBlock_return statementBlock() throws RecognitionException { return gEolParserRules.statementBlock(); }
    public Migration_EolParserRules.abortStatement_return abortStatement() throws RecognitionException { return gEolParserRules.abortStatement(); }
    public Migration_EolParserRules.declarativeFeatureCall_return declarativeFeatureCall() throws RecognitionException { return gEolParserRules.declarativeFeatureCall(); }
    public Migration_EolParserRules.deleteStatement_return deleteStatement() throws RecognitionException { return gEolParserRules.deleteStatement(); }
    public Migration_EolParserRules.throwStatement_return throwStatement() throws RecognitionException { return gEolParserRules.throwStatement(); }
    public Migration_EolParserRules.modelNamespace_return modelNamespace() throws RecognitionException { return gEolParserRules.modelNamespace(); }
    public Migration_EolParserRules.ifStatement_return ifStatement() throws RecognitionException { return gEolParserRules.ifStatement(); }
    public Migration_EolParserRules.multiplicativeExpression_return multiplicativeExpression() throws RecognitionException { return gEolParserRules.multiplicativeExpression(); }
    public Migration_EolParserRules.expressionStatement_return expressionStatement() throws RecognitionException { return gEolParserRules.expressionStatement(); }
    public Migration_EolParserRules.primitiveExpression_return primitiveExpression() throws RecognitionException { return gEolParserRules.primitiveExpression(); }
    public Migration_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock() throws RecognitionException { return gEolParserRules.statementOrStatementBlock(); }
    public Migration_EolParserRules.block_return block() throws RecognitionException { return gEolParserRules.block(); }
    public Migration_EolParserRules.featureCall_return featureCall() throws RecognitionException { return gEolParserRules.featureCall(); }


 

    public static final BitSet FOLLOW_119_in_migrationRule71 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NAME_in_migrationRule75 = new BitSet(new long[]{0x0000000000000000L,0x0300000000000200L});
    public static final BitSet FOLLOW_120_in_migrationRule78 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NAME_in_migrationRule82 = new BitSet(new long[]{0x0000000000000000L,0x0200000000000200L});
    public static final BitSet FOLLOW_121_in_migrationRule87 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000204L});
    public static final BitSet FOLLOW_expressionOrStatementBlock_in_migrationRule89 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_73_in_migrationRule93 = new BitSet(new long[]{0x0000000000011450L,0x00690003FEBF8440L});
    public static final BitSet FOLLOW_block_in_migrationRule95 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_74_in_migrationRule97 = new BitSet(new long[]{0x0000000000000002L});

}