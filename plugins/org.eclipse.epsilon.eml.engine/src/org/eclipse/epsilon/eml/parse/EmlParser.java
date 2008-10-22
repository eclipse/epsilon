// $ANTLR 3.1b1 E:\\Projects\\Eclipse\\3.4\\workspace3\\org.eclipse.epsilon.eml.engine\\src\\org\\eclipse\\epsilon\\eml\\parse\\Eml.g 2008-10-21 15:46:58

package org.eclipse.epsilon.eml.parse;


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
public class EmlParser extends org.eclipse.epsilon.commons.parse.EpsilonParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "FLOAT", "DIGIT", "INT", "POINT", "POINT_POINT", "ARROW", "BOOLEAN", "EscapeSequence", "STRING", "StrangeNameLiteral", "Letter", "JavaIDDigit", "NAME", "WS", "COMMENT", "LINE_COMMENT", "Annotation", "FORMAL", "PARAMLIST", "ASSIGNMENT", "SPECIAL_ASSIGNMENT", "HELPERMETHOD", "StatementBlock", "FOR", "IF", "ELSE", "WHILE", "RETURN", "BREAK", "BREAKALL", "CONTINUE", "TRANSACTION", "COLLECTION", "ABORT", "CollectionType", "ModelElementType", "PARAMETERS", "NewExpression", "VAR", "NEW", "ANNOTATIONBLOCK", "EXECUTABLEANNOTATION", "DELETE", "THROW", "EXPRLIST", "EXPRRANGE", "NativeType", "MultiplicativeExpression", "OPERATOR", "FeatureCall", "EOLMODULE", "BLOCK", "FEATURECALL", "TYPE", "ENUMERATION_VALUE", "IMPORT", "ModelDeclaration", "PRE", "POST", "EXTENDS", "GUARD", "TRANSFORM", "MERGE", "EMLMODULE", "'operation'", "'('", "')'", "':'", "'import'", "';'", "'{'", "'}'", "','", "'$'", "'!'", "'::'", "'#'", "'Native'", "'Collection'", "'Sequence'", "'Bag'", "'Set'", "'OrderedSet'", "'for'", "'in'", "'if'", "'else'", "'while'", "'return'", "'throw'", "'delete'", "'break'", "'breakAll'", "'continue'", "'abort'", "'transaction'", "':='", "'::='", "'or'", "'and'", "'xor'", "'implies'", "'='", "'>'", "'<'", "'>='", "'<='", "'<>'", "'+'", "'-'", "'*'", "'/'", "'not'", "'|'", "'new'", "'var'", "'pre'", "'post'", "'guard'", "'extends'", "'rule'", "'transform'", "'to'", "'merge'", "'with'", "'into'"
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
    public static final int T__126=126;
    public static final int T__125=125;
    public static final int T__128=128;
    public static final int T__127=127;
    public static final int T__71=71;
    public static final int WS=17;
    public static final int T__72=72;
    public static final int T__129=129;
    public static final int T__70=70;
    public static final int JavaIDDigit=15;
    public static final int GUARD=64;
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
    public static final int EMLMODULE=67;
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
    public static final int TRANSFORM=65;
    public static final int T__124=124;
    public static final int T__123=123;
    public static final int T__122=122;
    public static final int FOR=27;
    public static final int ENUMERATION_VALUE=58;
    public static final int T__121=121;
    public static final int PRE=61;
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
    public static final int MERGE=66;
    public static final int EXPRLIST=48;
    public static final int T__102=102;
    public static final int T__101=101;
    public static final int T__100=100;
    public static final int ModelDeclaration=60;
    public static final int POINT_POINT=8;
    public static final int BLOCK=55;
    public static final int FEATURECALL=56;
    public static final int FORMAL=21;
    public static final int POST=62;
    public static final int ARROW=9;
    public static final int ASSIGNMENT=23;
    public static final int EXTENDS=63;
    public static final int STRING=12;

    // delegates
    public Eml_EolParserRules gEolParserRules;
    public Eml_ErlParserRules gErlParserRules;
    public Eml_EtlParserRules gEtlParserRules;
    public Eml_EmlParserRules gEmlParserRules;
    // delegators


        public EmlParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public EmlParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
            gEolParserRules = new Eml_EolParserRules(input, state, this);
            gErlParserRules = new Eml_ErlParserRules(input, state, this);
            gEtlParserRules = new Eml_EtlParserRules(input, state, this);
            gEmlParserRules = new Eml_EmlParserRules(input, state, this);
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return EmlParser.tokenNames; }
    public String getGrammarFileName() { return "E:\\Projects\\Eclipse\\3.4\\workspace3\\org.eclipse.epsilon.eml.engine\\src\\org\\eclipse\\epsilon\\eml\\parse\\Eml.g"; }


    public static class emlModule_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start emlModule
    // E:\\Projects\\Eclipse\\3.4\\workspace3\\org.eclipse.epsilon.eml.engine\\src\\org\\eclipse\\epsilon\\eml\\parse\\Eml.g:93:1: emlModule : ( importStatement )* ( emlModuleContent )* -> ^( EMLMODULE ( importStatement )* ( emlModuleContent )* ) ;
    public final EmlParser.emlModule_return emlModule() throws RecognitionException {
        EmlParser.emlModule_return retval = new EmlParser.emlModule_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Eml_EolParserRules.importStatement_return importStatement1 = null;

        EmlParser.emlModuleContent_return emlModuleContent2 = null;


        RewriteRuleSubtreeStream stream_emlModuleContent=new RewriteRuleSubtreeStream(adaptor,"rule emlModuleContent");
        RewriteRuleSubtreeStream stream_importStatement=new RewriteRuleSubtreeStream(adaptor,"rule importStatement");
        try {
            // E:\\Projects\\Eclipse\\3.4\\workspace3\\org.eclipse.epsilon.eml.engine\\src\\org\\eclipse\\epsilon\\eml\\parse\\Eml.g:94:2: ( ( importStatement )* ( emlModuleContent )* -> ^( EMLMODULE ( importStatement )* ( emlModuleContent )* ) )
            // E:\\Projects\\Eclipse\\3.4\\workspace3\\org.eclipse.epsilon.eml.engine\\src\\org\\eclipse\\epsilon\\eml\\parse\\Eml.g:94:4: ( importStatement )* ( emlModuleContent )*
            {
            // E:\\Projects\\Eclipse\\3.4\\workspace3\\org.eclipse.epsilon.eml.engine\\src\\org\\eclipse\\epsilon\\eml\\parse\\Eml.g:94:4: ( importStatement )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==72) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // E:\\Projects\\Eclipse\\3.4\\workspace3\\org.eclipse.epsilon.eml.engine\\src\\org\\eclipse\\epsilon\\eml\\parse\\Eml.g:0:0: importStatement
            	    {
            	    pushFollow(FOLLOW_importStatement_in_emlModule79);
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

            // E:\\Projects\\Eclipse\\3.4\\workspace3\\org.eclipse.epsilon.eml.engine\\src\\org\\eclipse\\epsilon\\eml\\parse\\Eml.g:94:21: ( emlModuleContent )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==Annotation||LA2_0==68||LA2_0==77||(LA2_0>=120 && LA2_0<=121)||LA2_0==124) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // E:\\Projects\\Eclipse\\3.4\\workspace3\\org.eclipse.epsilon.eml.engine\\src\\org\\eclipse\\epsilon\\eml\\parse\\Eml.g:94:22: emlModuleContent
            	    {
            	    pushFollow(FOLLOW_emlModuleContent_in_emlModule83);
            	    emlModuleContent2=emlModuleContent();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_emlModuleContent.add(emlModuleContent2.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);



            // AST REWRITE
            // elements: importStatement, emlModuleContent
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 95:2: -> ^( EMLMODULE ( importStatement )* ( emlModuleContent )* )
            {
                // E:\\Projects\\Eclipse\\3.4\\workspace3\\org.eclipse.epsilon.eml.engine\\src\\org\\eclipse\\epsilon\\eml\\parse\\Eml.g:95:5: ^( EMLMODULE ( importStatement )* ( emlModuleContent )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(EMLMODULE, "EMLMODULE"), root_1);

                // E:\\Projects\\Eclipse\\3.4\\workspace3\\org.eclipse.epsilon.eml.engine\\src\\org\\eclipse\\epsilon\\eml\\parse\\Eml.g:95:17: ( importStatement )*
                while ( stream_importStatement.hasNext() ) {
                    adaptor.addChild(root_1, stream_importStatement.nextTree());

                }
                stream_importStatement.reset();
                // E:\\Projects\\Eclipse\\3.4\\workspace3\\org.eclipse.epsilon.eml.engine\\src\\org\\eclipse\\epsilon\\eml\\parse\\Eml.g:95:34: ( emlModuleContent )*
                while ( stream_emlModuleContent.hasNext() ) {
                    adaptor.addChild(root_1, stream_emlModuleContent.nextTree());

                }
                stream_emlModuleContent.reset();

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
    // $ANTLR end emlModule

    public static class emlModuleContent_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start emlModuleContent
    // E:\\Projects\\Eclipse\\3.4\\workspace3\\org.eclipse.epsilon.eml.engine\\src\\org\\eclipse\\epsilon\\eml\\parse\\Eml.g:98:1: emlModuleContent : ( pre | annotationBlock | transformationRule | mergeRule | operationDeclaration | post );
    public final EmlParser.emlModuleContent_return emlModuleContent() throws RecognitionException {
        EmlParser.emlModuleContent_return retval = new EmlParser.emlModuleContent_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Eml_ErlParserRules.pre_return pre3 = null;

        Eml_EolParserRules.annotationBlock_return annotationBlock4 = null;

        Eml_EtlParserRules.transformationRule_return transformationRule5 = null;

        Eml_EmlParserRules.mergeRule_return mergeRule6 = null;

        Eml_EolParserRules.operationDeclaration_return operationDeclaration7 = null;

        Eml_ErlParserRules.post_return post8 = null;



        try {
            // E:\\Projects\\Eclipse\\3.4\\workspace3\\org.eclipse.epsilon.eml.engine\\src\\org\\eclipse\\epsilon\\eml\\parse\\Eml.g:99:2: ( pre | annotationBlock | transformationRule | mergeRule | operationDeclaration | post )
            int alt3=6;
            switch ( input.LA(1) ) {
            case 120:
                {
                alt3=1;
                }
                break;
            case Annotation:
            case 77:
                {
                alt3=2;
                }
                break;
            case 124:
                {
                int LA3_3 = input.LA(2);

                if ( (LA3_3==NAME) ) {
                    int LA3_6 = input.LA(3);

                    if ( (LA3_6==125) ) {
                        alt3=3;
                    }
                    else if ( (LA3_6==127) ) {
                        alt3=4;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 6, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 3, input);

                    throw nvae;
                }
                }
                break;
            case 68:
                {
                alt3=5;
                }
                break;
            case 121:
                {
                alt3=6;
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
                    // E:\\Projects\\Eclipse\\3.4\\workspace3\\org.eclipse.epsilon.eml.engine\\src\\org\\eclipse\\epsilon\\eml\\parse\\Eml.g:99:4: pre
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_pre_in_emlModuleContent109);
                    pre3=pre();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pre3.getTree());

                    }
                    break;
                case 2 :
                    // E:\\Projects\\Eclipse\\3.4\\workspace3\\org.eclipse.epsilon.eml.engine\\src\\org\\eclipse\\epsilon\\eml\\parse\\Eml.g:99:10: annotationBlock
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_annotationBlock_in_emlModuleContent113);
                    annotationBlock4=annotationBlock();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationBlock4.getTree());

                    }
                    break;
                case 3 :
                    // E:\\Projects\\Eclipse\\3.4\\workspace3\\org.eclipse.epsilon.eml.engine\\src\\org\\eclipse\\epsilon\\eml\\parse\\Eml.g:99:28: transformationRule
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_transformationRule_in_emlModuleContent117);
                    transformationRule5=transformationRule();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, transformationRule5.getTree());

                    }
                    break;
                case 4 :
                    // E:\\Projects\\Eclipse\\3.4\\workspace3\\org.eclipse.epsilon.eml.engine\\src\\org\\eclipse\\epsilon\\eml\\parse\\Eml.g:99:49: mergeRule
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_mergeRule_in_emlModuleContent121);
                    mergeRule6=mergeRule();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, mergeRule6.getTree());

                    }
                    break;
                case 5 :
                    // E:\\Projects\\Eclipse\\3.4\\workspace3\\org.eclipse.epsilon.eml.engine\\src\\org\\eclipse\\epsilon\\eml\\parse\\Eml.g:99:61: operationDeclaration
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_operationDeclaration_in_emlModuleContent125);
                    operationDeclaration7=operationDeclaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, operationDeclaration7.getTree());

                    }
                    break;
                case 6 :
                    // E:\\Projects\\Eclipse\\3.4\\workspace3\\org.eclipse.epsilon.eml.engine\\src\\org\\eclipse\\epsilon\\eml\\parse\\Eml.g:99:84: post
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_post_in_emlModuleContent129);
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
    // $ANTLR end emlModuleContent

    // Delegated rules
    public Eml_ErlParserRules.post_return post() throws RecognitionException { return gErlParserRules.post(); }
    public Eml_EolParserRules.transactionStatement_return transactionStatement() throws RecognitionException { return gEolParserRules.transactionStatement(); }
    public Eml_EolParserRules.expressionStatement_return expressionStatement() throws RecognitionException { return gEolParserRules.expressionStatement(); }
    public Eml_EolParserRules.multiplicativeExpression_return multiplicativeExpression() throws RecognitionException { return gEolParserRules.multiplicativeExpression(); }
    public Eml_EolParserRules.breakStatement_return breakStatement() throws RecognitionException { return gEolParserRules.breakStatement(); }
    public Eml_EolParserRules.nativeType_return nativeType() throws RecognitionException { return gEolParserRules.nativeType(); }
    public Eml_EolParserRules.ifStatement_return ifStatement() throws RecognitionException { return gEolParserRules.ifStatement(); }
    public Eml_EolParserRules.featureCall_return featureCall() throws RecognitionException { return gEolParserRules.featureCall(); }
    public Eml_EmlParserRules.mergeRule_return mergeRule() throws RecognitionException { return gEmlParserRules.mergeRule(); }
    public Eml_EolParserRules.variableDeclarationExpression_return variableDeclarationExpression() throws RecognitionException { return gEolParserRules.variableDeclarationExpression(); }
    public Eml_EolParserRules.expressionRange_return expressionRange() throws RecognitionException { return gEolParserRules.expressionRange(); }
    public Eml_EolParserRules.postfixExpression_return postfixExpression() throws RecognitionException { return gEolParserRules.postfixExpression(); }
    public Eml_EolParserRules.typeName_return typeName() throws RecognitionException { return gEolParserRules.typeName(); }
    public Eml_EolParserRules.expressionListOrRange_return expressionListOrRange() throws RecognitionException { return gEolParserRules.expressionListOrRange(); }
    public Eml_EolParserRules.importStatement_return importStatement() throws RecognitionException { return gEolParserRules.importStatement(); }
    public Eml_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock() throws RecognitionException { return gEolParserRules.statementOrStatementBlock(); }
    public Eml_EolParserRules.deleteStatement_return deleteStatement() throws RecognitionException { return gEolParserRules.deleteStatement(); }
    public Eml_EolParserRules.newExpression_return newExpression() throws RecognitionException { return gEolParserRules.newExpression(); }
    public Eml_EolParserRules.annotation_return annotation() throws RecognitionException { return gEolParserRules.annotation(); }
    public Eml_EolParserRules.executableAnnotation_return executableAnnotation() throws RecognitionException { return gEolParserRules.executableAnnotation(); }
    public Eml_EolParserRules.elseStatement_return elseStatement() throws RecognitionException { return gEolParserRules.elseStatement(); }
    public Eml_EolParserRules.primitiveExpression_return primitiveExpression() throws RecognitionException { return gEolParserRules.primitiveExpression(); }
    public Eml_ErlParserRules.pre_return pre() throws RecognitionException { return gErlParserRules.pre(); }
    public Eml_EolParserRules.expressionOrStatementBlock_return expressionOrStatementBlock() throws RecognitionException { return gEolParserRules.expressionOrStatementBlock(); }
    public Eml_EolParserRules.declarativeFeatureCall_return declarativeFeatureCall() throws RecognitionException { return gEolParserRules.declarativeFeatureCall(); }
    public Eml_EolParserRules.block_return block() throws RecognitionException { return gEolParserRules.block(); }
    public Eml_EolParserRules.statementA_return statementA() throws RecognitionException { return gEolParserRules.statementA(); }
    public Eml_EtlParserRules.transformationRule_return transformationRule() throws RecognitionException { return gEtlParserRules.transformationRule(); }
    public Eml_ErlParserRules.guard_return guard() throws RecognitionException { return gErlParserRules.guard(); }
    public Eml_EolParserRules.simpleFeatureCall_return simpleFeatureCall() throws RecognitionException { return gEolParserRules.simpleFeatureCall(); }
    public Eml_EolParserRules.litteralCollection_return litteralCollection() throws RecognitionException { return gEolParserRules.litteralCollection(); }
    public Eml_EolParserRules.throwStatement_return throwStatement() throws RecognitionException { return gEolParserRules.throwStatement(); }
    public Eml_EolParserRules.operationDeclarationOrAnnotationBlock_return operationDeclarationOrAnnotationBlock() throws RecognitionException { return gEolParserRules.operationDeclarationOrAnnotationBlock(); }
    public Eml_EolParserRules.expressionList_return expressionList() throws RecognitionException { return gEolParserRules.expressionList(); }
    public Eml_EolParserRules.pathName_return pathName() throws RecognitionException { return gEolParserRules.pathName(); }
    public Eml_EolParserRules.forStatement_return forStatement() throws RecognitionException { return gEolParserRules.forStatement(); }
    public Eml_EolParserRules.annotationBlock_return annotationBlock() throws RecognitionException { return gEolParserRules.annotationBlock(); }
    public Eml_EolParserRules.modelElementType_return modelElementType() throws RecognitionException { return gEolParserRules.modelElementType(); }
    public Eml_EolParserRules.statement_return statement() throws RecognitionException { return gEolParserRules.statement(); }
    public Eml_EolParserRules.continueStatement_return continueStatement() throws RecognitionException { return gEolParserRules.continueStatement(); }
    public Eml_EolParserRules.returnStatement_return returnStatement() throws RecognitionException { return gEolParserRules.returnStatement(); }
    public Eml_EolParserRules.assignmentStatement_return assignmentStatement() throws RecognitionException { return gEolParserRules.assignmentStatement(); }
    public Eml_EolParserRules.formalParameterList_return formalParameterList() throws RecognitionException { return gEolParserRules.formalParameterList(); }
    public Eml_EolParserRules.abortStatement_return abortStatement() throws RecognitionException { return gEolParserRules.abortStatement(); }
    public Eml_EolParserRules.whileStatement_return whileStatement() throws RecognitionException { return gEolParserRules.whileStatement(); }
    public Eml_EolParserRules.additiveExpression_return additiveExpression() throws RecognitionException { return gEolParserRules.additiveExpression(); }
    public Eml_EolParserRules.breakAllStatement_return breakAllStatement() throws RecognitionException { return gEolParserRules.breakAllStatement(); }
    public Eml_EolParserRules.parameterList_return parameterList() throws RecognitionException { return gEolParserRules.parameterList(); }
    public Eml_ErlParserRules.extendz_return extendz() throws RecognitionException { return gErlParserRules.extendz(); }
    public Eml_EolParserRules.statementB_return statementB() throws RecognitionException { return gEolParserRules.statementB(); }
    public Eml_EolParserRules.literal_return literal() throws RecognitionException { return gEolParserRules.literal(); }
    public Eml_EolParserRules.statementBlock_return statementBlock() throws RecognitionException { return gEolParserRules.statementBlock(); }
    public Eml_EolParserRules.unaryExpression_return unaryExpression() throws RecognitionException { return gEolParserRules.unaryExpression(); }
    public Eml_EolParserRules.relationalExpression_return relationalExpression() throws RecognitionException { return gEolParserRules.relationalExpression(); }
    public Eml_EolParserRules.logicalExpression_return logicalExpression() throws RecognitionException { return gEolParserRules.logicalExpression(); }
    public Eml_EolParserRules.collectionType_return collectionType() throws RecognitionException { return gEolParserRules.collectionType(); }
    public Eml_EolParserRules.operationDeclaration_return operationDeclaration() throws RecognitionException { return gEolParserRules.operationDeclaration(); }
    public Eml_EolParserRules.formalParameter_return formalParameter() throws RecognitionException { return gEolParserRules.formalParameter(); }


 

    public static final BitSet FOLLOW_importStatement_in_emlModule79 = new BitSet(new long[]{0x0000000000100002L,0x1300000000002110L});
    public static final BitSet FOLLOW_emlModuleContent_in_emlModule83 = new BitSet(new long[]{0x0000000000100002L,0x1300000000002010L});
    public static final BitSet FOLLOW_pre_in_emlModuleContent109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationBlock_in_emlModuleContent113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_transformationRule_in_emlModuleContent117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mergeRule_in_emlModuleContent121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_operationDeclaration_in_emlModuleContent125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_post_in_emlModuleContent129 = new BitSet(new long[]{0x0000000000000002L});

}