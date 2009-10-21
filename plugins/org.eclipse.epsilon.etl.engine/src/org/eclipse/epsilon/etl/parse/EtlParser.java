// $ANTLR 3.1b1 E:\\Projects\\Eclipse\\3.4\\workspace3\\org.eclipse.epsilon.etl.engine\\src\\org\\eclipse\\epsilon\\etl\\parse\\Etl.g 2009-10-19 08:42:33

package org.eclipse.epsilon.etl.parse;


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
public class EtlParser extends org.eclipse.epsilon.commons.parse.EpsilonParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "FLOAT", "DIGIT", "INT", "POINT", "POINT_POINT", "ARROW", "BOOLEAN", "EscapeSequence", "STRING", "StrangeNameLiteral", "Letter", "JavaIDDigit", "NAME", "WS", "COMMENT", "LINE_COMMENT", "Annotation", "FORMAL", "PARAMLIST", "ASSIGNMENT", "SPECIAL_ASSIGNMENT", "HELPERMETHOD", "StatementBlock", "FOR", "IF", "ELSE", "WHILE", "RETURN", "BREAK", "BREAKALL", "CONTINUE", "TRANSACTION", "COLLECTION", "ABORT", "CollectionType", "ModelElementType", "PARAMETERS", "NewExpression", "VAR", "NEW", "ANNOTATIONBLOCK", "EXECUTABLEANNOTATION", "DELETE", "THROW", "EXPRLIST", "EXPRRANGE", "NativeType", "MultiplicativeExpression", "OPERATOR", "FeatureCall", "EOLMODULE", "BLOCK", "FEATURECALL", "TYPE", "ENUMERATION_VALUE", "IMPORT", "MODELDECLARATION", "NAMESPACE", "ALIAS", "PRE", "POST", "EXTENDS", "GUARD", "TRANSFORM", "ETLMODULE", "'model'", "';'", "':'", "','", "'alias'", "'operation'", "'('", "')'", "'import'", "'{'", "'}'", "'$'", "'!'", "'::'", "'#'", "'Native'", "'Collection'", "'Sequence'", "'Bag'", "'Set'", "'OrderedSet'", "'for'", "'in'", "'if'", "'else'", "'while'", "'return'", "'throw'", "'delete'", "'break'", "'breakAll'", "'continue'", "'abort'", "'transaction'", "':='", "'::='", "'or'", "'and'", "'xor'", "'implies'", "'=='", "'='", "'>'", "'<'", "'>='", "'<='", "'<>'", "'+'", "'-'", "'*'", "'/'", "'not'", "'|'", "'new'", "'var'", "'pre'", "'post'", "'guard'", "'extends'", "'rule'", "'transform'", "'to'"
    };
    public static final int WHILE=30;
    public static final int StatementBlock=26;
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
    public static final int T__126=126;
    public static final int T__125=125;
    public static final int T__128=128;
    public static final int T__127=127;
    public static final int T__71=71;
    public static final int WS=17;
    public static final int T__72=72;
    public static final int T__129=129;
    public static final int T__70=70;
    public static final int ALIAS=62;
    public static final int JavaIDDigit=15;
    public static final int GUARD=66;
    public static final int Annotation=20;
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int T__130=130;
    public static final int T__73=73;
    public static final int EscapeSequence=11;
    public static final int Letter=14;
    public static final int THROW=47;
    public static final int T__79=79;
    public static final int ETLMODULE=68;
    public static final int T__78=78;
    public static final int T__77=77;
    public static final int T__69=69;
    public static final int SPECIAL_ASSIGNMENT=24;
    public static final int PARAMETERS=40;
    public static final int POINT=7;
    public static final int T__118=118;
    public static final int T__119=119;
    public static final int T__116=116;
    public static final int T__117=117;
    public static final int T__114=114;
    public static final int T__115=115;
    public static final int TRANSFORM=67;
    public static final int T__124=124;
    public static final int T__123=123;
    public static final int T__122=122;
    public static final int FOR=27;
    public static final int ENUMERATION_VALUE=58;
    public static final int T__121=121;
    public static final int PRE=63;
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
    public static final int POST=64;
    public static final int ARROW=9;
    public static final int ASSIGNMENT=23;
    public static final int EXTENDS=65;
    public static final int STRING=12;

    // delegates
    public Etl_EolParserRules gEolParserRules;
    public Etl_ErlParserRules gErlParserRules;
    public Etl_EtlParserRules gEtlParserRules;
    // delegators


        public EtlParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public EtlParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
            gEolParserRules = new Etl_EolParserRules(input, state, this);
            gErlParserRules = new Etl_ErlParserRules(input, state, this);
            gEtlParserRules = new Etl_EtlParserRules(input, state, this);
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return EtlParser.tokenNames; }
    public String getGrammarFileName() { return "E:\\Projects\\Eclipse\\3.4\\workspace3\\org.eclipse.epsilon.etl.engine\\src\\org\\eclipse\\epsilon\\etl\\parse\\Etl.g"; }


    public static class etlModule_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start etlModule
    // E:\\Projects\\Eclipse\\3.4\\workspace3\\org.eclipse.epsilon.etl.engine\\src\\org\\eclipse\\epsilon\\etl\\parse\\Etl.g:93:1: etlModule : ( importStatement )* ( etlModuleContent )* EOF -> ^( ETLMODULE ( importStatement )* ( etlModuleContent )* ) ;
    public final EtlParser.etlModule_return etlModule() throws RecognitionException {
        EtlParser.etlModule_return retval = new EtlParser.etlModule_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token EOF3=null;
        Etl_EolParserRules.importStatement_return importStatement1 = null;

        EtlParser.etlModuleContent_return etlModuleContent2 = null;


        CommonTree EOF3_tree=null;
        RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
        RewriteRuleSubtreeStream stream_etlModuleContent=new RewriteRuleSubtreeStream(adaptor,"rule etlModuleContent");
        RewriteRuleSubtreeStream stream_importStatement=new RewriteRuleSubtreeStream(adaptor,"rule importStatement");
        try {
            // E:\\Projects\\Eclipse\\3.4\\workspace3\\org.eclipse.epsilon.etl.engine\\src\\org\\eclipse\\epsilon\\etl\\parse\\Etl.g:94:2: ( ( importStatement )* ( etlModuleContent )* EOF -> ^( ETLMODULE ( importStatement )* ( etlModuleContent )* ) )
            // E:\\Projects\\Eclipse\\3.4\\workspace3\\org.eclipse.epsilon.etl.engine\\src\\org\\eclipse\\epsilon\\etl\\parse\\Etl.g:94:4: ( importStatement )* ( etlModuleContent )* EOF
            {
            // E:\\Projects\\Eclipse\\3.4\\workspace3\\org.eclipse.epsilon.etl.engine\\src\\org\\eclipse\\epsilon\\etl\\parse\\Etl.g:94:4: ( importStatement )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==77) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // E:\\Projects\\Eclipse\\3.4\\workspace3\\org.eclipse.epsilon.etl.engine\\src\\org\\eclipse\\epsilon\\etl\\parse\\Etl.g:0:0: importStatement
            	    {
            	    pushFollow(FOLLOW_importStatement_in_etlModule76);
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

            // E:\\Projects\\Eclipse\\3.4\\workspace3\\org.eclipse.epsilon.etl.engine\\src\\org\\eclipse\\epsilon\\etl\\parse\\Etl.g:94:21: ( etlModuleContent )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==Annotation||LA2_0==74||LA2_0==80||(LA2_0>=124 && LA2_0<=125)||LA2_0==128) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // E:\\Projects\\Eclipse\\3.4\\workspace3\\org.eclipse.epsilon.etl.engine\\src\\org\\eclipse\\epsilon\\etl\\parse\\Etl.g:94:22: etlModuleContent
            	    {
            	    pushFollow(FOLLOW_etlModuleContent_in_etlModule80);
            	    etlModuleContent2=etlModuleContent();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_etlModuleContent.add(etlModuleContent2.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            EOF3=(Token)match(input,EOF,FOLLOW_EOF_in_etlModule84); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EOF.add(EOF3);



            // AST REWRITE
            // elements: importStatement, etlModuleContent
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 95:2: -> ^( ETLMODULE ( importStatement )* ( etlModuleContent )* )
            {
                // E:\\Projects\\Eclipse\\3.4\\workspace3\\org.eclipse.epsilon.etl.engine\\src\\org\\eclipse\\epsilon\\etl\\parse\\Etl.g:95:5: ^( ETLMODULE ( importStatement )* ( etlModuleContent )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ETLMODULE, "ETLMODULE"), root_1);

                // E:\\Projects\\Eclipse\\3.4\\workspace3\\org.eclipse.epsilon.etl.engine\\src\\org\\eclipse\\epsilon\\etl\\parse\\Etl.g:95:17: ( importStatement )*
                while ( stream_importStatement.hasNext() ) {
                    adaptor.addChild(root_1, stream_importStatement.nextTree());

                }
                stream_importStatement.reset();
                // E:\\Projects\\Eclipse\\3.4\\workspace3\\org.eclipse.epsilon.etl.engine\\src\\org\\eclipse\\epsilon\\etl\\parse\\Etl.g:95:34: ( etlModuleContent )*
                while ( stream_etlModuleContent.hasNext() ) {
                    adaptor.addChild(root_1, stream_etlModuleContent.nextTree());

                }
                stream_etlModuleContent.reset();

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
    // $ANTLR end etlModule

    public static class etlModuleContent_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start etlModuleContent
    // E:\\Projects\\Eclipse\\3.4\\workspace3\\org.eclipse.epsilon.etl.engine\\src\\org\\eclipse\\epsilon\\etl\\parse\\Etl.g:98:1: etlModuleContent : ( pre | annotationBlock | transformationRule | operationDeclaration | post );
    public final EtlParser.etlModuleContent_return etlModuleContent() throws RecognitionException {
        EtlParser.etlModuleContent_return retval = new EtlParser.etlModuleContent_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Etl_ErlParserRules.pre_return pre4 = null;

        Etl_EolParserRules.annotationBlock_return annotationBlock5 = null;

        Etl_EtlParserRules.transformationRule_return transformationRule6 = null;

        Etl_EolParserRules.operationDeclaration_return operationDeclaration7 = null;

        Etl_ErlParserRules.post_return post8 = null;



        try {
            // E:\\Projects\\Eclipse\\3.4\\workspace3\\org.eclipse.epsilon.etl.engine\\src\\org\\eclipse\\epsilon\\etl\\parse\\Etl.g:99:2: ( pre | annotationBlock | transformationRule | operationDeclaration | post )
            int alt3=5;
            switch ( input.LA(1) ) {
            case 124:
                {
                alt3=1;
                }
                break;
            case Annotation:
            case 80:
                {
                alt3=2;
                }
                break;
            case 128:
                {
                alt3=3;
                }
                break;
            case 74:
                {
                alt3=4;
                }
                break;
            case 125:
                {
                alt3=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // E:\\Projects\\Eclipse\\3.4\\workspace3\\org.eclipse.epsilon.etl.engine\\src\\org\\eclipse\\epsilon\\etl\\parse\\Etl.g:99:4: pre
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_pre_in_etlModuleContent108);
                    pre4=pre();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pre4.getTree());

                    }
                    break;
                case 2 :
                    // E:\\Projects\\Eclipse\\3.4\\workspace3\\org.eclipse.epsilon.etl.engine\\src\\org\\eclipse\\epsilon\\etl\\parse\\Etl.g:99:10: annotationBlock
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_annotationBlock_in_etlModuleContent112);
                    annotationBlock5=annotationBlock();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationBlock5.getTree());

                    }
                    break;
                case 3 :
                    // E:\\Projects\\Eclipse\\3.4\\workspace3\\org.eclipse.epsilon.etl.engine\\src\\org\\eclipse\\epsilon\\etl\\parse\\Etl.g:99:28: transformationRule
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_transformationRule_in_etlModuleContent116);
                    transformationRule6=transformationRule();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, transformationRule6.getTree());

                    }
                    break;
                case 4 :
                    // E:\\Projects\\Eclipse\\3.4\\workspace3\\org.eclipse.epsilon.etl.engine\\src\\org\\eclipse\\epsilon\\etl\\parse\\Etl.g:99:49: operationDeclaration
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_operationDeclaration_in_etlModuleContent120);
                    operationDeclaration7=operationDeclaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, operationDeclaration7.getTree());

                    }
                    break;
                case 5 :
                    // E:\\Projects\\Eclipse\\3.4\\workspace3\\org.eclipse.epsilon.etl.engine\\src\\org\\eclipse\\epsilon\\etl\\parse\\Etl.g:99:72: post
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_post_in_etlModuleContent124);
                    post8=post();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, post8.getTree());

                    }
                    break;

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
    // $ANTLR end etlModuleContent

    // Delegated rules
    public Etl_ErlParserRules.pre_return pre() throws RecognitionException { return gErlParserRules.pre(); }
    public Etl_EolParserRules.returnStatement_return returnStatement() throws RecognitionException { return gEolParserRules.returnStatement(); }
    public Etl_EolParserRules.modelNamespace_return modelNamespace() throws RecognitionException { return gEolParserRules.modelNamespace(); }
    public Etl_EolParserRules.elseStatement_return elseStatement() throws RecognitionException { return gEolParserRules.elseStatement(); }
    public Etl_EolParserRules.postfixExpression_return postfixExpression() throws RecognitionException { return gEolParserRules.postfixExpression(); }
    public Etl_EolParserRules.annotation_return annotation() throws RecognitionException { return gEolParserRules.annotation(); }
    public Etl_EolParserRules.expressionList_return expressionList() throws RecognitionException { return gEolParserRules.expressionList(); }
    public Etl_EolParserRules.forStatement_return forStatement() throws RecognitionException { return gEolParserRules.forStatement(); }
    public Etl_EolParserRules.throwStatement_return throwStatement() throws RecognitionException { return gEolParserRules.throwStatement(); }
    public Etl_EolParserRules.annotationBlock_return annotationBlock() throws RecognitionException { return gEolParserRules.annotationBlock(); }
    public Etl_EolParserRules.deleteStatement_return deleteStatement() throws RecognitionException { return gEolParserRules.deleteStatement(); }
    public Etl_EolParserRules.abortStatement_return abortStatement() throws RecognitionException { return gEolParserRules.abortStatement(); }
    public Etl_EolParserRules.formalParameter_return formalParameter() throws RecognitionException { return gEolParserRules.formalParameter(); }
    public Etl_ErlParserRules.post_return post() throws RecognitionException { return gErlParserRules.post(); }
    public Etl_EolParserRules.unaryExpression_return unaryExpression() throws RecognitionException { return gEolParserRules.unaryExpression(); }
    public Etl_EolParserRules.statementBlock_return statementBlock() throws RecognitionException { return gEolParserRules.statementBlock(); }
    public Etl_EolParserRules.modelDeclaration_return modelDeclaration() throws RecognitionException { return gEolParserRules.modelDeclaration(); }
    public Etl_EolParserRules.statement_return statement() throws RecognitionException { return gEolParserRules.statement(); }
    public Etl_EolParserRules.whileStatement_return whileStatement() throws RecognitionException { return gEolParserRules.whileStatement(); }
    public Etl_EolParserRules.importStatement_return importStatement() throws RecognitionException { return gEolParserRules.importStatement(); }
    public Etl_EolParserRules.ifStatement_return ifStatement() throws RecognitionException { return gEolParserRules.ifStatement(); }
    public Etl_EolParserRules.breakStatement_return breakStatement() throws RecognitionException { return gEolParserRules.breakStatement(); }
    public Etl_EolParserRules.executableAnnotation_return executableAnnotation() throws RecognitionException { return gEolParserRules.executableAnnotation(); }
    public Etl_EolParserRules.pathName_return pathName() throws RecognitionException { return gEolParserRules.pathName(); }
    public Etl_EolParserRules.variableDeclarationExpression_return variableDeclarationExpression() throws RecognitionException { return gEolParserRules.variableDeclarationExpression(); }
    public Etl_EolParserRules.logicalExpression_return logicalExpression() throws RecognitionException { return gEolParserRules.logicalExpression(); }
    public Etl_EolParserRules.expressionListOrRange_return expressionListOrRange() throws RecognitionException { return gEolParserRules.expressionListOrRange(); }
    public Etl_EolParserRules.featureCall_return featureCall() throws RecognitionException { return gEolParserRules.featureCall(); }
    public Etl_EolParserRules.modelAlias_return modelAlias() throws RecognitionException { return gEolParserRules.modelAlias(); }
    public Etl_EolParserRules.transactionStatement_return transactionStatement() throws RecognitionException { return gEolParserRules.transactionStatement(); }
    public Etl_EolParserRules.litteralCollection_return litteralCollection() throws RecognitionException { return gEolParserRules.litteralCollection(); }
    public Etl_EolParserRules.block_return block() throws RecognitionException { return gEolParserRules.block(); }
    public Etl_EolParserRules.relationalExpression_return relationalExpression() throws RecognitionException { return gEolParserRules.relationalExpression(); }
    public Etl_EolParserRules.typeName_return typeName() throws RecognitionException { return gEolParserRules.typeName(); }
    public Etl_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock() throws RecognitionException { return gEolParserRules.statementOrStatementBlock(); }
    public Etl_EolParserRules.breakAllStatement_return breakAllStatement() throws RecognitionException { return gEolParserRules.breakAllStatement(); }
    public Etl_EolParserRules.expressionStatement_return expressionStatement() throws RecognitionException { return gEolParserRules.expressionStatement(); }
    public Etl_EolParserRules.formalParameterList_return formalParameterList() throws RecognitionException { return gEolParserRules.formalParameterList(); }
    public Etl_EolParserRules.modelElementType_return modelElementType() throws RecognitionException { return gEolParserRules.modelElementType(); }
    public Etl_EolParserRules.simpleFeatureCall_return simpleFeatureCall() throws RecognitionException { return gEolParserRules.simpleFeatureCall(); }
    public Etl_EolParserRules.nativeType_return nativeType() throws RecognitionException { return gEolParserRules.nativeType(); }
    public Etl_EolParserRules.operationDeclarationOrAnnotationBlock_return operationDeclarationOrAnnotationBlock() throws RecognitionException { return gEolParserRules.operationDeclarationOrAnnotationBlock(); }
    public Etl_EolParserRules.statementA_return statementA() throws RecognitionException { return gEolParserRules.statementA(); }
    public Etl_EtlParserRules.transformationRule_return transformationRule() throws RecognitionException { return gEtlParserRules.transformationRule(); }
    public Etl_EolParserRules.expressionRange_return expressionRange() throws RecognitionException { return gEolParserRules.expressionRange(); }
    public Etl_EolParserRules.newExpression_return newExpression() throws RecognitionException { return gEolParserRules.newExpression(); }
    public Etl_ErlParserRules.guard_return guard() throws RecognitionException { return gErlParserRules.guard(); }
    public Etl_EolParserRules.parameterList_return parameterList() throws RecognitionException { return gEolParserRules.parameterList(); }
    public Etl_EolParserRules.assignmentStatement_return assignmentStatement() throws RecognitionException { return gEolParserRules.assignmentStatement(); }
    public Etl_EolParserRules.literal_return literal() throws RecognitionException { return gEolParserRules.literal(); }
    public Etl_EolParserRules.operationDeclaration_return operationDeclaration() throws RecognitionException { return gEolParserRules.operationDeclaration(); }
    public Etl_EolParserRules.primitiveExpression_return primitiveExpression() throws RecognitionException { return gEolParserRules.primitiveExpression(); }
    public Etl_ErlParserRules.extendz_return extendz() throws RecognitionException { return gErlParserRules.extendz(); }
    public Etl_EolParserRules.expressionOrStatementBlock_return expressionOrStatementBlock() throws RecognitionException { return gEolParserRules.expressionOrStatementBlock(); }
    public Etl_EolParserRules.declarativeFeatureCall_return declarativeFeatureCall() throws RecognitionException { return gEolParserRules.declarativeFeatureCall(); }
    public Etl_EolParserRules.additiveExpression_return additiveExpression() throws RecognitionException { return gEolParserRules.additiveExpression(); }
    public Etl_EolParserRules.continueStatement_return continueStatement() throws RecognitionException { return gEolParserRules.continueStatement(); }
    public Etl_EolParserRules.multiplicativeExpression_return multiplicativeExpression() throws RecognitionException { return gEolParserRules.multiplicativeExpression(); }
    public Etl_EolParserRules.statementB_return statementB() throws RecognitionException { return gEolParserRules.statementB(); }
    public Etl_EolParserRules.collectionType_return collectionType() throws RecognitionException { return gEolParserRules.collectionType(); }


 

    public static final BitSet FOLLOW_importStatement_in_etlModule76 = new BitSet(new long[]{0x0000000000100000L,0x3000000000012400L,0x0000000000000001L});
    public static final BitSet FOLLOW_etlModuleContent_in_etlModule80 = new BitSet(new long[]{0x0000000000100000L,0x3000000000010400L,0x0000000000000001L});
    public static final BitSet FOLLOW_EOF_in_etlModule84 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pre_in_etlModuleContent108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationBlock_in_etlModuleContent112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_transformationRule_in_etlModuleContent116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_operationDeclaration_in_etlModuleContent120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_post_in_etlModuleContent124 = new BitSet(new long[]{0x0000000000000002L});

}