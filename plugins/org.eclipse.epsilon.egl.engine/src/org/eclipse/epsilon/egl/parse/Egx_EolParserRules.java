package org.eclipse.epsilon.egl.parse;

// $ANTLR 3.1b1 EolParserRules.g 2015-01-23 13:44:26

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
public class Egx_EolParserRules extends org.eclipse.epsilon.common.parse.EpsilonParser {
    public static final int EXPONENT=6;
    public static final int OVERWRITE=84;
    public static final int T__159=159;
    public static final int WHILE=33;
    public static final int StatementBlock=29;
    public static final int T__158=158;
    public static final int StrangeNameLiteral=15;
    public static final int CASE=35;
    public static final int NEW=49;
    public static final int T__160=160;
    public static final int FeatureCall=60;
    public static final int EOF=-1;
    public static final int BREAK=38;
    public static final int KEYVALLIST=76;
    public static final int TYPE=64;
    public static final int T__161=161;
    public static final int T__162=162;
    public static final int T__93=93;
    public static final int T__94=94;
    public static final int T__91=91;
    public static final int IMPORT=66;
    public static final int NAME=19;
    public static final int T__92=92;
    public static final int T__148=148;
    public static final int T__90=90;
    public static final int T__147=147;
    public static final int T__149=149;
    public static final int RETURN=37;
    public static final int NewExpression=47;
    public static final int VAR=48;
    public static final int GENERATE=81;
    public static final int ANNOTATIONBLOCK=50;
    public static final int NativeType=56;
    public static final int ABORT=43;
    public static final int COMMENT=21;
    public static final int T__154=154;
    public static final int T__155=155;
    public static final int T__156=156;
    public static final int T__99=99;
    public static final int T__157=157;
    public static final int ITEMSELECTOR=73;
    public static final int T__98=98;
    public static final int T__150=150;
    public static final int T__97=97;
    public static final int T__151=151;
    public static final int MultiplicativeExpression=57;
    public static final int T__96=96;
    public static final int T__152=152;
    public static final int T__95=95;
    public static final int T__153=153;
    public static final int FLOAT_TYPE_SUFFIX=7;
    public static final int T__139=139;
    public static final int T__138=138;
    public static final int T__137=137;
    public static final int T__136=136;
    public static final int LINE_COMMENT=22;
    public static final int BREAKALL=39;
    public static final int TRANSACTION=41;
    public static final int SWITCH=34;
    public static final int DRIVER=70;
    public static final int ELSE=32;
    public static final int EOLMODULE=61;
    public static final int MODELDECLARATION=67;
    public static final int PARAMLIST=25;
    public static final int INT=8;
    public static final int DELETE=52;
    public static final int T__141=141;
    public static final int T__142=142;
    public static final int EGXMODULE=86;
    public static final int T__87=87;
    public static final int HELPERMETHOD=28;
    public static final int T__140=140;
    public static final int T__89=89;
    public static final int T__145=145;
    public static final int NAMESPACE=68;
    public static final int T__88=88;
    public static final int T__146=146;
    public static final int CollectionType=44;
    public static final int T__143=143;
    public static final int T__144=144;
    public static final int T__126=126;
    public static final int T__125=125;
    public static final int T__128=128;
    public static final int T__127=127;
    public static final int WS=20;
    public static final int T__129=129;
    public static final int ALIAS=69;
    public static final int JavaIDDigit=18;
    public static final int PROTECTREGIONS=85;
    public static final int GUARD=80;
    public static final int Annotation=23;
    public static final int T__130=130;
    public static final int Letter=16;
    public static final int T__131=131;
    public static final int EscapeSequence=13;
    public static final int THROW=53;
    public static final int T__132=132;
    public static final int T__133=133;
    public static final int T__134=134;
    public static final int T__135=135;
    public static final int SPECIAL_ASSIGNMENT=27;
    public static final int MODELDECLARATIONPARAMETER=72;
    public static final int KEYVAL=75;
    public static final int PARAMETERS=46;
    public static final int POINT=9;
    public static final int T__118=118;
    public static final int T__119=119;
    public static final int T__116=116;
    public static final int T__117=117;
    public static final int T__114=114;
    public static final int T__115=115;
    public static final int T__124=124;
    public static final int T__123=123;
    public static final int FOR=30;
    public static final int T__122=122;
    public static final int ENUMERATION_VALUE=65;
    public static final int T__121=121;
    public static final int PRE=77;
    public static final int T__120=120;
    public static final int FLOAT=4;
    public static final int EXECUTABLEANNOTATION=51;
    public static final int IF=31;
    public static final int ModelElementType=45;
    public static final int BOOLEAN=12;
    public static final int CONTINUE=40;
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
    public static final int COLLECTION=42;
    public static final int DIGIT=5;
    public static final int EXPRRANGE=55;
    public static final int OPERATOR=58;
    public static final int EXPRLIST=54;
    public static final int DEFAULT=36;
    public static final int T__102=102;
    public static final int T__101=101;
    public static final int TARGET=82;
    public static final int T__100=100;
    public static final int POINT_POINT=10;
    public static final int TEMPLATE=83;
    public static final int SpecialNameChar=17;
    public static final int MODELDECLARATIONPARAMETERS=71;
    public static final int BLOCK=62;
    public static final int MAP=74;
    public static final int FEATURECALL=63;
    public static final int FORMAL=24;
    public static final int POST=78;
    public static final int ARROW=11;
    public static final int EXPRESSIONINBRACKETS=59;
    public static final int ASSIGNMENT=26;
    public static final int EXTENDS=79;
    public static final int STRING=14;

    // delegates
    // delegators
    public EgxParser gEgx;


        public Egx_EolParserRules(TokenStream input, EgxParser gEgx) {
            this(input, new RecognizerSharedState(), gEgx);
        }
        public Egx_EolParserRules(TokenStream input, RecognizerSharedState state, EgxParser gEgx) {
            super(input, state);
            this.gEgx = gEgx;
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return EgxParser.tokenNames; }
    public String getGrammarFileName() { return "EolParserRules.g"; }

    
    
    public void setTokenType(ParserRuleReturnScope tree, int type) {
    	((CommonTree) tree.getTree()).getToken().setType(type);
    }
    


    public static class operationDeclarationOrAnnotationBlock_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start operationDeclarationOrAnnotationBlock
    // EolParserRules.g:105:1: operationDeclarationOrAnnotationBlock : ( operationDeclaration | annotationBlock );
    public final Egx_EolParserRules.operationDeclarationOrAnnotationBlock_return operationDeclarationOrAnnotationBlock() throws RecognitionException {
        Egx_EolParserRules.operationDeclarationOrAnnotationBlock_return retval = new Egx_EolParserRules.operationDeclarationOrAnnotationBlock_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Egx_EolParserRules.operationDeclaration_return operationDeclaration1 = null;

        Egx_EolParserRules.annotationBlock_return annotationBlock2 = null;



        try {
            // EolParserRules.g:106:2: ( operationDeclaration | annotationBlock )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( ((LA1_0>=95 && LA1_0<=96)) ) {
                alt1=1;
            }
            else if ( (LA1_0==Annotation||LA1_0==101) ) {
                alt1=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // EolParserRules.g:106:4: operationDeclaration
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_operationDeclaration_in_operationDeclarationOrAnnotationBlock250);
                    operationDeclaration1=operationDeclaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, operationDeclaration1.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:106:25: annotationBlock
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_annotationBlock_in_operationDeclarationOrAnnotationBlock252);
                    annotationBlock2=annotationBlock();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationBlock2.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end operationDeclarationOrAnnotationBlock

    public static class modelDeclaration_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start modelDeclaration
    // EolParserRules.g:109:1: modelDeclaration : m= 'model' NAME ( modelAlias )? ( modelDriver )? ( modelDeclarationParameters )? sem= ';' ;
    public final Egx_EolParserRules.modelDeclaration_return modelDeclaration() throws RecognitionException {
        Egx_EolParserRules.modelDeclaration_return retval = new Egx_EolParserRules.modelDeclaration_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token m=null;
        Token sem=null;
        Token NAME3=null;
        Egx_EolParserRules.modelAlias_return modelAlias4 = null;

        Egx_EolParserRules.modelDriver_return modelDriver5 = null;

        Egx_EolParserRules.modelDeclarationParameters_return modelDeclarationParameters6 = null;


        org.eclipse.epsilon.common.parse.AST m_tree=null;
        org.eclipse.epsilon.common.parse.AST sem_tree=null;
        org.eclipse.epsilon.common.parse.AST NAME3_tree=null;

        try {
            // EolParserRules.g:114:2: (m= 'model' NAME ( modelAlias )? ( modelDriver )? ( modelDeclarationParameters )? sem= ';' )
            // EolParserRules.g:114:4: m= 'model' NAME ( modelAlias )? ( modelDriver )? ( modelDeclarationParameters )? sem= ';'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            m=(Token)match(input,87,FOLLOW_87_in_modelDeclaration271); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            m_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(m);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(m_tree, root_0);
            }
            NAME3=(Token)match(input,NAME,FOLLOW_NAME_in_modelDeclaration274); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME3_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(NAME3);
            adaptor.addChild(root_0, NAME3_tree);
            }
            // EolParserRules.g:114:20: ( modelAlias )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==89) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // EolParserRules.g:0:0: modelAlias
                    {
                    pushFollow(FOLLOW_modelAlias_in_modelDeclaration276);
                    modelAlias4=modelAlias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, modelAlias4.getTree());

                    }
                    break;

            }

            // EolParserRules.g:114:32: ( modelDriver )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==91) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // EolParserRules.g:0:0: modelDriver
                    {
                    pushFollow(FOLLOW_modelDriver_in_modelDeclaration279);
                    modelDriver5=modelDriver();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, modelDriver5.getTree());

                    }
                    break;

            }

            // EolParserRules.g:114:45: ( modelDeclarationParameters )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==92) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // EolParserRules.g:0:0: modelDeclarationParameters
                    {
                    pushFollow(FOLLOW_modelDeclarationParameters_in_modelDeclaration282);
                    modelDeclarationParameters6=modelDeclarationParameters();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, modelDeclarationParameters6.getTree());

                    }
                    break;

            }

            sem=(Token)match(input,88,FOLLOW_88_in_modelDeclaration287); if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {
              
              		((org.eclipse.epsilon.common.parse.AST)retval.tree).getExtraTokens().add(sem);
              		((org.eclipse.epsilon.common.parse.AST)retval.tree).getToken().setType(MODELDECLARATION);
              	
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end modelDeclaration

    public static class modelAlias_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start modelAlias
    // EolParserRules.g:117:1: modelAlias : a= 'alias' NAME ( ',' NAME )* ;
    public final Egx_EolParserRules.modelAlias_return modelAlias() throws RecognitionException {
        Egx_EolParserRules.modelAlias_return retval = new Egx_EolParserRules.modelAlias_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token a=null;
        Token NAME7=null;
        Token char_literal8=null;
        Token NAME9=null;

        org.eclipse.epsilon.common.parse.AST a_tree=null;
        org.eclipse.epsilon.common.parse.AST NAME7_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal8_tree=null;
        org.eclipse.epsilon.common.parse.AST NAME9_tree=null;

        try {
            // EolParserRules.g:118:2: (a= 'alias' NAME ( ',' NAME )* )
            // EolParserRules.g:118:5: a= 'alias' NAME ( ',' NAME )*
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            a=(Token)match(input,89,FOLLOW_89_in_modelAlias302); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            a_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(a);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(a_tree, root_0);
            }
            NAME7=(Token)match(input,NAME,FOLLOW_NAME_in_modelAlias305); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME7_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(NAME7);
            adaptor.addChild(root_0, NAME7_tree);
            }
            // EolParserRules.g:118:21: ( ',' NAME )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==90) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // EolParserRules.g:118:22: ',' NAME
            	    {
            	    char_literal8=(Token)match(input,90,FOLLOW_90_in_modelAlias308); if (state.failed) return retval;
            	    NAME9=(Token)match(input,NAME,FOLLOW_NAME_in_modelAlias311); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    NAME9_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(NAME9);
            	    adaptor.addChild(root_0, NAME9_tree);
            	    }

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            if ( state.backtracking==0 ) {
              a.setType(ALIAS);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end modelAlias

    public static class modelDriver_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start modelDriver
    // EolParserRules.g:122:1: modelDriver : d= 'driver' NAME ;
    public final Egx_EolParserRules.modelDriver_return modelDriver() throws RecognitionException {
        Egx_EolParserRules.modelDriver_return retval = new Egx_EolParserRules.modelDriver_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token d=null;
        Token NAME10=null;

        org.eclipse.epsilon.common.parse.AST d_tree=null;
        org.eclipse.epsilon.common.parse.AST NAME10_tree=null;

        try {
            // EolParserRules.g:123:2: (d= 'driver' NAME )
            // EolParserRules.g:123:5: d= 'driver' NAME
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            d=(Token)match(input,91,FOLLOW_91_in_modelDriver330); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            d_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(d);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(d_tree, root_0);
            }
            NAME10=(Token)match(input,NAME,FOLLOW_NAME_in_modelDriver333); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME10_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(NAME10);
            adaptor.addChild(root_0, NAME10_tree);
            }
            if ( state.backtracking==0 ) {
              d.setType(DRIVER);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end modelDriver

    public static class modelDeclarationParameters_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start modelDeclarationParameters
    // EolParserRules.g:127:1: modelDeclarationParameters : s= '{' ( modelDeclarationParameter )? ( ',' modelDeclarationParameter )* cb= '}' ;
    public final Egx_EolParserRules.modelDeclarationParameters_return modelDeclarationParameters() throws RecognitionException {
        Egx_EolParserRules.modelDeclarationParameters_return retval = new Egx_EolParserRules.modelDeclarationParameters_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token s=null;
        Token cb=null;
        Token char_literal12=null;
        Egx_EolParserRules.modelDeclarationParameter_return modelDeclarationParameter11 = null;

        Egx_EolParserRules.modelDeclarationParameter_return modelDeclarationParameter13 = null;


        org.eclipse.epsilon.common.parse.AST s_tree=null;
        org.eclipse.epsilon.common.parse.AST cb_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal12_tree=null;

        try {
            // EolParserRules.g:132:2: (s= '{' ( modelDeclarationParameter )? ( ',' modelDeclarationParameter )* cb= '}' )
            // EolParserRules.g:132:4: s= '{' ( modelDeclarationParameter )? ( ',' modelDeclarationParameter )* cb= '}'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            s=(Token)match(input,92,FOLLOW_92_in_modelDeclarationParameters355); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            s_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(s);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(s_tree, root_0);
            }
            // EolParserRules.g:132:11: ( modelDeclarationParameter )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==NAME) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // EolParserRules.g:0:0: modelDeclarationParameter
                    {
                    pushFollow(FOLLOW_modelDeclarationParameter_in_modelDeclarationParameters358);
                    modelDeclarationParameter11=modelDeclarationParameter();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, modelDeclarationParameter11.getTree());

                    }
                    break;

            }

            // EolParserRules.g:132:38: ( ',' modelDeclarationParameter )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==90) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // EolParserRules.g:132:39: ',' modelDeclarationParameter
            	    {
            	    char_literal12=(Token)match(input,90,FOLLOW_90_in_modelDeclarationParameters362); if (state.failed) return retval;
            	    pushFollow(FOLLOW_modelDeclarationParameter_in_modelDeclarationParameters365);
            	    modelDeclarationParameter13=modelDeclarationParameter();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, modelDeclarationParameter13.getTree());

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            cb=(Token)match(input,93,FOLLOW_93_in_modelDeclarationParameters371); if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {
              
              		((org.eclipse.epsilon.common.parse.AST)retval.tree).getExtraTokens().add(cb);
              		((org.eclipse.epsilon.common.parse.AST)retval.tree).getToken().setType(MODELDECLARATIONPARAMETERS);
              	
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end modelDeclarationParameters

    public static class modelDeclarationParameter_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start modelDeclarationParameter
    // EolParserRules.g:135:1: modelDeclarationParameter : NAME e= '=' STRING ;
    public final Egx_EolParserRules.modelDeclarationParameter_return modelDeclarationParameter() throws RecognitionException {
        Egx_EolParserRules.modelDeclarationParameter_return retval = new Egx_EolParserRules.modelDeclarationParameter_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token e=null;
        Token NAME14=null;
        Token STRING15=null;

        org.eclipse.epsilon.common.parse.AST e_tree=null;
        org.eclipse.epsilon.common.parse.AST NAME14_tree=null;
        org.eclipse.epsilon.common.parse.AST STRING15_tree=null;

        try {
            // EolParserRules.g:136:2: ( NAME e= '=' STRING )
            // EolParserRules.g:136:4: NAME e= '=' STRING
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            NAME14=(Token)match(input,NAME,FOLLOW_NAME_in_modelDeclarationParameter384); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME14_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(NAME14);
            adaptor.addChild(root_0, NAME14_tree);
            }
            e=(Token)match(input,94,FOLLOW_94_in_modelDeclarationParameter388); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            e_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(e);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(e_tree, root_0);
            }
            STRING15=(Token)match(input,STRING,FOLLOW_STRING_in_modelDeclarationParameter391); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STRING15_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(STRING15);
            adaptor.addChild(root_0, STRING15_tree);
            }
            if ( state.backtracking==0 ) {
              e.setType(MODELDECLARATIONPARAMETER);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end modelDeclarationParameter

    public static class operationDeclaration_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start operationDeclaration
    // EolParserRules.g:140:1: operationDeclaration : ( 'operation' | 'function' ) (ctx= typeName )? operationName= NAME op= '(' ( formalParameterList )? cp= ')' ( ':' returnType= typeName )? statementBlock ;
    public final Egx_EolParserRules.operationDeclaration_return operationDeclaration() throws RecognitionException {
        Egx_EolParserRules.operationDeclaration_return retval = new Egx_EolParserRules.operationDeclaration_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token operationName=null;
        Token op=null;
        Token cp=null;
        Token set16=null;
        Token char_literal18=null;
        Egx_EolParserRules.typeName_return ctx = null;

        Egx_EolParserRules.typeName_return returnType = null;

        Egx_EolParserRules.formalParameterList_return formalParameterList17 = null;

        Egx_EolParserRules.statementBlock_return statementBlock19 = null;


        org.eclipse.epsilon.common.parse.AST operationName_tree=null;
        org.eclipse.epsilon.common.parse.AST op_tree=null;
        org.eclipse.epsilon.common.parse.AST cp_tree=null;
        org.eclipse.epsilon.common.parse.AST set16_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal18_tree=null;

        try {
            // EolParserRules.g:145:2: ( ( 'operation' | 'function' ) (ctx= typeName )? operationName= NAME op= '(' ( formalParameterList )? cp= ')' ( ':' returnType= typeName )? statementBlock )
            // EolParserRules.g:145:4: ( 'operation' | 'function' ) (ctx= typeName )? operationName= NAME op= '(' ( formalParameterList )? cp= ')' ( ':' returnType= typeName )? statementBlock
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            set16=(Token)input.LT(1);
            set16=(Token)input.LT(1);
            if ( (input.LA(1)>=95 && input.LA(1)<=96) ) {
                input.consume();
                if ( state.backtracking==0 ) root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot((org.eclipse.epsilon.common.parse.AST)adaptor.create(set16), root_0);
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            // EolParserRules.g:145:30: (ctx= typeName )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==NAME) ) {
                int LA8_1 = input.LA(2);

                if ( (LA8_1==NAME||(LA8_1>=102 && LA8_1<=104)) ) {
                    alt8=1;
                }
            }
            else if ( ((LA8_0>=105 && LA8_0<=112)) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // EolParserRules.g:145:31: ctx= typeName
                    {
                    pushFollow(FOLLOW_typeName_in_operationDeclaration422);
                    ctx=typeName();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, ctx.getTree());
                    if ( state.backtracking==0 ) {
                      setTokenType(ctx,TYPE);
                    }

                    }
                    break;

            }

            operationName=(Token)match(input,NAME,FOLLOW_NAME_in_operationDeclaration430); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            operationName_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(operationName);
            adaptor.addChild(root_0, operationName_tree);
            }
            op=(Token)match(input,97,FOLLOW_97_in_operationDeclaration434); if (state.failed) return retval;
            // EolParserRules.g:145:99: ( formalParameterList )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==NAME) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // EolParserRules.g:0:0: formalParameterList
                    {
                    pushFollow(FOLLOW_formalParameterList_in_operationDeclaration437);
                    formalParameterList17=formalParameterList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, formalParameterList17.getTree());

                    }
                    break;

            }

            cp=(Token)match(input,98,FOLLOW_98_in_operationDeclaration442); if (state.failed) return retval;
            // EolParserRules.g:145:128: ( ':' returnType= typeName )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==99) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // EolParserRules.g:145:129: ':' returnType= typeName
                    {
                    char_literal18=(Token)match(input,99,FOLLOW_99_in_operationDeclaration446); if (state.failed) return retval;
                    pushFollow(FOLLOW_typeName_in_operationDeclaration451);
                    returnType=typeName();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, returnType.getTree());
                    if ( state.backtracking==0 ) {
                      setTokenType(returnType,TYPE);
                    }

                    }
                    break;

            }

            pushFollow(FOLLOW_statementBlock_in_operationDeclaration457);
            statementBlock19=statementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, statementBlock19.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {
              
              		((org.eclipse.epsilon.common.parse.AST)retval.tree).getExtraTokens().add(cp);
              		((org.eclipse.epsilon.common.parse.AST)retval.tree).getToken().setType(HELPERMETHOD);
              	
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end operationDeclaration

    public static class importStatement_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start importStatement
    // EolParserRules.g:148:1: importStatement : i= 'import' STRING sem= ';' ;
    public final Egx_EolParserRules.importStatement_return importStatement() throws RecognitionException {
        Egx_EolParserRules.importStatement_return retval = new Egx_EolParserRules.importStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token i=null;
        Token sem=null;
        Token STRING20=null;

        org.eclipse.epsilon.common.parse.AST i_tree=null;
        org.eclipse.epsilon.common.parse.AST sem_tree=null;
        org.eclipse.epsilon.common.parse.AST STRING20_tree=null;

        try {
            // EolParserRules.g:152:2: (i= 'import' STRING sem= ';' )
            // EolParserRules.g:152:4: i= 'import' STRING sem= ';'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            i=(Token)match(input,100,FOLLOW_100_in_importStatement477); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            i_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(i);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(i_tree, root_0);
            }
            STRING20=(Token)match(input,STRING,FOLLOW_STRING_in_importStatement480); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STRING20_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(STRING20);
            adaptor.addChild(root_0, STRING20_tree);
            }
            sem=(Token)match(input,88,FOLLOW_88_in_importStatement484); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
              i.setType(IMPORT);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {
              
              		((org.eclipse.epsilon.common.parse.AST)retval.tree).getExtraTokens().add(sem);
              	
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end importStatement

    public static class block_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start block
    // EolParserRules.g:156:1: block : ( statement )* -> ^( BLOCK ( statement )* ) ;
    public final Egx_EolParserRules.block_return block() throws RecognitionException {
        Egx_EolParserRules.block_return retval = new Egx_EolParserRules.block_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Egx_EolParserRules.statement_return statement21 = null;


        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        try {
            // EolParserRules.g:160:2: ( ( statement )* -> ^( BLOCK ( statement )* ) )
            // EolParserRules.g:160:4: ( statement )*
            {
            // EolParserRules.g:160:4: ( statement )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==FLOAT||LA11_0==INT||LA11_0==BOOLEAN||LA11_0==STRING||LA11_0==NAME||LA11_0==97||(LA11_0>=105 && LA11_0<=113)||(LA11_0>=115 && LA11_0<=116)||(LA11_0>=120 && LA11_0<=128)||LA11_0==142||LA11_0==145||(LA11_0>=149 && LA11_0<=151)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // EolParserRules.g:0:0: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_block504);
            	    statement21=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_statement.add(statement21.getTree());

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);



            // AST REWRITE
            // elements: statement
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();
            // 161:2: -> ^( BLOCK ( statement )* )
            {
                // EolParserRules.g:161:5: ^( BLOCK ( statement )* )
                {
                org.eclipse.epsilon.common.parse.AST root_1 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();
                root_1 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot((org.eclipse.epsilon.common.parse.AST)adaptor.create(BLOCK, "BLOCK"), root_1);

                // EolParserRules.g:161:13: ( statement )*
                while ( stream_statement.hasNext() ) {
                    adaptor.addChild(root_1, stream_statement.nextTree());

                }
                stream_statement.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {
              
              		((org.eclipse.epsilon.common.parse.AST)retval.tree).setImaginary(true);
              	
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end block

    public static class statementBlock_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start statementBlock
    // EolParserRules.g:164:1: statementBlock : s= '{' block e= '}' ;
    public final Egx_EolParserRules.statementBlock_return statementBlock() throws RecognitionException {
        Egx_EolParserRules.statementBlock_return retval = new Egx_EolParserRules.statementBlock_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token s=null;
        Token e=null;
        Egx_EolParserRules.block_return block22 = null;


        org.eclipse.epsilon.common.parse.AST s_tree=null;
        org.eclipse.epsilon.common.parse.AST e_tree=null;

        try {
            // EolParserRules.g:169:2: (s= '{' block e= '}' )
            // EolParserRules.g:169:4: s= '{' block e= '}'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            s=(Token)match(input,92,FOLLOW_92_in_statementBlock533); if (state.failed) return retval;
            pushFollow(FOLLOW_block_in_statementBlock536);
            block22=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, block22.getTree());
            e=(Token)match(input,93,FOLLOW_93_in_statementBlock540); if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {
              
              		((org.eclipse.epsilon.common.parse.AST)retval.tree).getExtraTokens().add(s); 
              		((org.eclipse.epsilon.common.parse.AST)retval.tree).getExtraTokens().add(e);
              	
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end statementBlock

    public static class formalParameter_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start formalParameter
    // EolParserRules.g:172:1: formalParameter : NAME ( ':' pt= typeName )? -> ^( FORMAL NAME ( typeName )? ) ;
    public final Egx_EolParserRules.formalParameter_return formalParameter() throws RecognitionException {
        Egx_EolParserRules.formalParameter_return retval = new Egx_EolParserRules.formalParameter_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token NAME23=null;
        Token char_literal24=null;
        Egx_EolParserRules.typeName_return pt = null;


        org.eclipse.epsilon.common.parse.AST NAME23_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal24_tree=null;
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_99=new RewriteRuleTokenStream(adaptor,"token 99");
        RewriteRuleSubtreeStream stream_typeName=new RewriteRuleSubtreeStream(adaptor,"rule typeName");
        try {
            // EolParserRules.g:176:2: ( NAME ( ':' pt= typeName )? -> ^( FORMAL NAME ( typeName )? ) )
            // EolParserRules.g:176:4: NAME ( ':' pt= typeName )?
            {
            NAME23=(Token)match(input,NAME,FOLLOW_NAME_in_formalParameter558); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(NAME23);

            // EolParserRules.g:176:9: ( ':' pt= typeName )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==99) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // EolParserRules.g:176:10: ':' pt= typeName
                    {
                    char_literal24=(Token)match(input,99,FOLLOW_99_in_formalParameter561); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_99.add(char_literal24);

                    pushFollow(FOLLOW_typeName_in_formalParameter565);
                    pt=typeName();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_typeName.add(pt.getTree());
                    if ( state.backtracking==0 ) {
                      setTokenType(pt,TYPE);
                    }

                    }
                    break;

            }



            // AST REWRITE
            // elements: typeName, NAME
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();
            // 177:3: -> ^( FORMAL NAME ( typeName )? )
            {
                // EolParserRules.g:177:6: ^( FORMAL NAME ( typeName )? )
                {
                org.eclipse.epsilon.common.parse.AST root_1 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();
                root_1 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot((org.eclipse.epsilon.common.parse.AST)adaptor.create(FORMAL, "FORMAL"), root_1);

                adaptor.addChild(root_1, stream_NAME.nextNode());
                // EolParserRules.g:177:20: ( typeName )?
                if ( stream_typeName.hasNext() ) {
                    adaptor.addChild(root_1, stream_typeName.nextTree());

                }
                stream_typeName.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {
              
              	//	((org.eclipse.epsilon.common.parse.AST)retval.tree).setImaginary(true);
              	
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end formalParameter

    public static class formalParameterList_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start formalParameterList
    // EolParserRules.g:180:1: formalParameterList : formalParameter ( ',' formalParameter )* -> ^( PARAMLIST ( formalParameter )* ) ;
    public final Egx_EolParserRules.formalParameterList_return formalParameterList() throws RecognitionException {
        Egx_EolParserRules.formalParameterList_return retval = new Egx_EolParserRules.formalParameterList_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token char_literal26=null;
        Egx_EolParserRules.formalParameter_return formalParameter25 = null;

        Egx_EolParserRules.formalParameter_return formalParameter27 = null;


        org.eclipse.epsilon.common.parse.AST char_literal26_tree=null;
        RewriteRuleTokenStream stream_90=new RewriteRuleTokenStream(adaptor,"token 90");
        RewriteRuleSubtreeStream stream_formalParameter=new RewriteRuleSubtreeStream(adaptor,"rule formalParameter");
        try {
            // EolParserRules.g:184:2: ( formalParameter ( ',' formalParameter )* -> ^( PARAMLIST ( formalParameter )* ) )
            // EolParserRules.g:184:4: formalParameter ( ',' formalParameter )*
            {
            pushFollow(FOLLOW_formalParameter_in_formalParameterList599);
            formalParameter25=formalParameter();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_formalParameter.add(formalParameter25.getTree());
            // EolParserRules.g:184:20: ( ',' formalParameter )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==90) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // EolParserRules.g:184:21: ',' formalParameter
            	    {
            	    char_literal26=(Token)match(input,90,FOLLOW_90_in_formalParameterList602); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_90.add(char_literal26);

            	    pushFollow(FOLLOW_formalParameter_in_formalParameterList604);
            	    formalParameter27=formalParameter();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_formalParameter.add(formalParameter27.getTree());

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);



            // AST REWRITE
            // elements: formalParameter
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();
            // 185:2: -> ^( PARAMLIST ( formalParameter )* )
            {
                // EolParserRules.g:185:5: ^( PARAMLIST ( formalParameter )* )
                {
                org.eclipse.epsilon.common.parse.AST root_1 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();
                root_1 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot((org.eclipse.epsilon.common.parse.AST)adaptor.create(PARAMLIST, "PARAMLIST"), root_1);

                // EolParserRules.g:185:17: ( formalParameter )*
                while ( stream_formalParameter.hasNext() ) {
                    adaptor.addChild(root_1, stream_formalParameter.nextTree());

                }
                stream_formalParameter.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {
              
              		((org.eclipse.epsilon.common.parse.AST)retval.tree).setImaginary(true);
              	
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end formalParameterList

    public static class executableAnnotation_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start executableAnnotation
    // EolParserRules.g:188:1: executableAnnotation : d= '$' x= . logicalExpression ;
    public final Egx_EolParserRules.executableAnnotation_return executableAnnotation() throws RecognitionException {
        Egx_EolParserRules.executableAnnotation_return retval = new Egx_EolParserRules.executableAnnotation_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token d=null;
        Token x=null;
        Egx_EolParserRules.logicalExpression_return logicalExpression28 = null;


        org.eclipse.epsilon.common.parse.AST d_tree=null;
        org.eclipse.epsilon.common.parse.AST x_tree=null;

        try {
            // EolParserRules.g:189:2: (d= '$' x= . logicalExpression )
            // EolParserRules.g:189:4: d= '$' x= . logicalExpression
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            d=(Token)match(input,101,FOLLOW_101_in_executableAnnotation629); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            d_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(d);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(d_tree, root_0);
            }
            x=(Token)input.LT(1);
            matchAny(input); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            x_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(x);
            adaptor.addChild(root_0, x_tree);
            }
            pushFollow(FOLLOW_logicalExpression_in_executableAnnotation636);
            logicalExpression28=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression28.getTree());
            if ( state.backtracking==0 ) {
              d.setType(EXECUTABLEANNOTATION);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end executableAnnotation

    public static class annotation_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start annotation
    // EolParserRules.g:193:1: annotation : ( Annotation | executableAnnotation );
    public final Egx_EolParserRules.annotation_return annotation() throws RecognitionException {
        Egx_EolParserRules.annotation_return retval = new Egx_EolParserRules.annotation_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token Annotation29=null;
        Egx_EolParserRules.executableAnnotation_return executableAnnotation30 = null;


        org.eclipse.epsilon.common.parse.AST Annotation29_tree=null;

        try {
            // EolParserRules.g:194:2: ( Annotation | executableAnnotation )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==Annotation) ) {
                alt14=1;
            }
            else if ( (LA14_0==101) ) {
                alt14=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // EolParserRules.g:194:4: Annotation
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    Annotation29=(Token)match(input,Annotation,FOLLOW_Annotation_in_annotation650); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    Annotation29_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(Annotation29);
                    adaptor.addChild(root_0, Annotation29_tree);
                    }

                    }
                    break;
                case 2 :
                    // EolParserRules.g:194:15: executableAnnotation
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_executableAnnotation_in_annotation652);
                    executableAnnotation30=executableAnnotation();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, executableAnnotation30.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end annotation

    public static class annotationBlock_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start annotationBlock
    // EolParserRules.g:197:1: annotationBlock : ( annotation )+ -> ^( ANNOTATIONBLOCK ( annotation )+ ) ;
    public final Egx_EolParserRules.annotationBlock_return annotationBlock() throws RecognitionException {
        Egx_EolParserRules.annotationBlock_return retval = new Egx_EolParserRules.annotationBlock_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Egx_EolParserRules.annotation_return annotation31 = null;


        RewriteRuleSubtreeStream stream_annotation=new RewriteRuleSubtreeStream(adaptor,"rule annotation");
        try {
            // EolParserRules.g:201:2: ( ( annotation )+ -> ^( ANNOTATIONBLOCK ( annotation )+ ) )
            // EolParserRules.g:201:4: ( annotation )+
            {
            // EolParserRules.g:201:4: ( annotation )+
            int cnt15=0;
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==Annotation) ) {
                    int LA15_2 = input.LA(2);

                    if ( (synpred16_EolParserRules()) ) {
                        alt15=1;
                    }


                }
                else if ( (LA15_0==101) ) {
                    int LA15_3 = input.LA(2);

                    if ( (synpred16_EolParserRules()) ) {
                        alt15=1;
                    }


                }


                switch (alt15) {
            	case 1 :
            	    // EolParserRules.g:0:0: annotation
            	    {
            	    pushFollow(FOLLOW_annotation_in_annotationBlock669);
            	    annotation31=annotation();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_annotation.add(annotation31.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt15 >= 1 ) break loop15;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(15, input);
                        throw eee;
                }
                cnt15++;
            } while (true);



            // AST REWRITE
            // elements: annotation
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();
            // 202:2: -> ^( ANNOTATIONBLOCK ( annotation )+ )
            {
                // EolParserRules.g:202:5: ^( ANNOTATIONBLOCK ( annotation )+ )
                {
                org.eclipse.epsilon.common.parse.AST root_1 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();
                root_1 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot((org.eclipse.epsilon.common.parse.AST)adaptor.create(ANNOTATIONBLOCK, "ANNOTATIONBLOCK"), root_1);

                if ( !(stream_annotation.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_annotation.hasNext() ) {
                    adaptor.addChild(root_1, stream_annotation.nextTree());

                }
                stream_annotation.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {
              
              		((org.eclipse.epsilon.common.parse.AST)retval.tree).setImaginary(true);
              	
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end annotationBlock

    public static class typeName_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start typeName
    // EolParserRules.g:205:1: typeName : ( pathName | nativeType | collectionType );
    public final Egx_EolParserRules.typeName_return typeName() throws RecognitionException {
        Egx_EolParserRules.typeName_return retval = new Egx_EolParserRules.typeName_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Egx_EolParserRules.pathName_return pathName32 = null;

        Egx_EolParserRules.nativeType_return nativeType33 = null;

        Egx_EolParserRules.collectionType_return collectionType34 = null;



        try {
            // EolParserRules.g:209:2: ( pathName | nativeType | collectionType )
            int alt16=3;
            switch ( input.LA(1) ) {
            case NAME:
                {
                alt16=1;
                }
                break;
            case 105:
                {
                alt16=2;
                }
                break;
            case 106:
            case 107:
            case 108:
            case 109:
            case 110:
            case 111:
            case 112:
                {
                alt16=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // EolParserRules.g:209:4: pathName
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_pathName_in_typeName698);
                    pathName32=pathName();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pathName32.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:209:15: nativeType
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_nativeType_in_typeName702);
                    nativeType33=nativeType();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nativeType33.getTree());

                    }
                    break;
                case 3 :
                    // EolParserRules.g:209:28: collectionType
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_collectionType_in_typeName706);
                    collectionType34=collectionType();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, collectionType34.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {
              
              		((org.eclipse.epsilon.common.parse.AST)retval.tree).getToken().setType(TYPE);
              	
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end typeName

    public static class pathName_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start pathName
    // EolParserRules.g:212:1: pathName : (metamodel= NAME '!' )? head= packagedType ( '#' label= NAME )? ;
    public final Egx_EolParserRules.pathName_return pathName() throws RecognitionException {
        Egx_EolParserRules.pathName_return retval = new Egx_EolParserRules.pathName_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token metamodel=null;
        Token label=null;
        Token char_literal35=null;
        Token char_literal36=null;
        Egx_EolParserRules.packagedType_return head = null;


        org.eclipse.epsilon.common.parse.AST metamodel_tree=null;
        org.eclipse.epsilon.common.parse.AST label_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal35_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal36_tree=null;

        try {
            // EolParserRules.g:213:2: ( (metamodel= NAME '!' )? head= packagedType ( '#' label= NAME )? )
            // EolParserRules.g:213:4: (metamodel= NAME '!' )? head= packagedType ( '#' label= NAME )?
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            // EolParserRules.g:213:4: (metamodel= NAME '!' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==NAME) ) {
                int LA17_1 = input.LA(2);

                if ( (LA17_1==102) ) {
                    alt17=1;
                }
            }
            switch (alt17) {
                case 1 :
                    // EolParserRules.g:213:5: metamodel= NAME '!'
                    {
                    metamodel=(Token)match(input,NAME,FOLLOW_NAME_in_pathName720); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    metamodel_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(metamodel);
                    adaptor.addChild(root_0, metamodel_tree);
                    }
                    char_literal35=(Token)match(input,102,FOLLOW_102_in_pathName722); if (state.failed) return retval;

                    }
                    break;

            }

            pushFollow(FOLLOW_packagedType_in_pathName731);
            head=packagedType();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(head.getTree(), root_0);
            // EolParserRules.g:215:3: ( '#' label= NAME )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==103) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // EolParserRules.g:215:4: '#' label= NAME
                    {
                    char_literal36=(Token)match(input,103,FOLLOW_103_in_pathName737); if (state.failed) return retval;
                    label=(Token)match(input,NAME,FOLLOW_NAME_in_pathName742); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    label_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(label);
                    adaptor.addChild(root_0, label_tree);
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              
              			if (metamodel != null) {
              				(head!=null?((org.eclipse.epsilon.common.parse.AST)head.tree):null).token.setText(metamodel.getText() + "!" + (head!=null?((org.eclipse.epsilon.common.parse.AST)head.tree):null).token.getText());		
              			}
              			
              			if (label != null) {
              				(head!=null?((org.eclipse.epsilon.common.parse.AST)head.tree):null).token.setText((head!=null?((org.eclipse.epsilon.common.parse.AST)head.tree):null).token.getText() + "#" + label.getText());
              				(head!=null?((org.eclipse.epsilon.common.parse.AST)head.tree):null).token.setType(ENUMERATION_VALUE);
              			}	
              		
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end pathName

    public static class packagedType_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start packagedType
    // EolParserRules.g:229:1: packagedType : head= NAME ( '::' field= NAME )* ;
    public final Egx_EolParserRules.packagedType_return packagedType() throws RecognitionException {
        Egx_EolParserRules.packagedType_return retval = new Egx_EolParserRules.packagedType_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token head=null;
        Token field=null;
        Token string_literal37=null;

        org.eclipse.epsilon.common.parse.AST head_tree=null;
        org.eclipse.epsilon.common.parse.AST field_tree=null;
        org.eclipse.epsilon.common.parse.AST string_literal37_tree=null;

        try {
            // EolParserRules.g:230:2: (head= NAME ( '::' field= NAME )* )
            // EolParserRules.g:230:4: head= NAME ( '::' field= NAME )*
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            head=(Token)match(input,NAME,FOLLOW_NAME_in_packagedType763); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            head_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(head);
            adaptor.addChild(root_0, head_tree);
            }
            // EolParserRules.g:230:14: ( '::' field= NAME )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==104) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // EolParserRules.g:230:15: '::' field= NAME
            	    {
            	    string_literal37=(Token)match(input,104,FOLLOW_104_in_packagedType766); if (state.failed) return retval;
            	    field=(Token)match(input,NAME,FOLLOW_NAME_in_packagedType771); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	       
            	      				head.setText(head.getText() + "::" + field.getText()); 
            	      				((CommonToken) head).setStopIndex(((CommonToken)field).getStopIndex());
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end packagedType

    public static class nativeType_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start nativeType
    // EolParserRules.g:238:1: nativeType : 'Native' s= '(' STRING e= ')' ;
    public final Egx_EolParserRules.nativeType_return nativeType() throws RecognitionException {
        Egx_EolParserRules.nativeType_return retval = new Egx_EolParserRules.nativeType_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token s=null;
        Token e=null;
        Token string_literal38=null;
        Token STRING39=null;

        org.eclipse.epsilon.common.parse.AST s_tree=null;
        org.eclipse.epsilon.common.parse.AST e_tree=null;
        org.eclipse.epsilon.common.parse.AST string_literal38_tree=null;
        org.eclipse.epsilon.common.parse.AST STRING39_tree=null;

        try {
            // EolParserRules.g:244:2: ( 'Native' s= '(' STRING e= ')' )
            // EolParserRules.g:244:4: 'Native' s= '(' STRING e= ')'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            string_literal38=(Token)match(input,105,FOLLOW_105_in_nativeType799); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal38_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(string_literal38);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(string_literal38_tree, root_0);
            }
            s=(Token)match(input,97,FOLLOW_97_in_nativeType804); if (state.failed) return retval;
            STRING39=(Token)match(input,STRING,FOLLOW_STRING_in_nativeType807); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STRING39_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(STRING39);
            adaptor.addChild(root_0, STRING39_tree);
            }
            e=(Token)match(input,98,FOLLOW_98_in_nativeType811); if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {
              
              		((org.eclipse.epsilon.common.parse.AST)retval.tree).getExtraTokens().add(s); 
              		((org.eclipse.epsilon.common.parse.AST)retval.tree).getExtraTokens().add(e);
              		((org.eclipse.epsilon.common.parse.AST)retval.tree).getToken().setType(TYPE);
              	
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end nativeType

    public static class collectionType_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start collectionType
    // EolParserRules.g:247:1: collectionType : ( 'Collection' | 'Sequence' | 'List' | 'Bag' | 'Set' | 'OrderedSet' | 'Map' ) (op= '(' tn= typeName ( ',' tn= typeName )* cp= ')' )? ;
    public final Egx_EolParserRules.collectionType_return collectionType() throws RecognitionException {
        Egx_EolParserRules.collectionType_return retval = new Egx_EolParserRules.collectionType_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token op=null;
        Token cp=null;
        Token set40=null;
        Token char_literal41=null;
        Egx_EolParserRules.typeName_return tn = null;


        org.eclipse.epsilon.common.parse.AST op_tree=null;
        org.eclipse.epsilon.common.parse.AST cp_tree=null;
        org.eclipse.epsilon.common.parse.AST set40_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal41_tree=null;

        try {
            // EolParserRules.g:253:2: ( ( 'Collection' | 'Sequence' | 'List' | 'Bag' | 'Set' | 'OrderedSet' | 'Map' ) (op= '(' tn= typeName ( ',' tn= typeName )* cp= ')' )? )
            // EolParserRules.g:253:5: ( 'Collection' | 'Sequence' | 'List' | 'Bag' | 'Set' | 'OrderedSet' | 'Map' ) (op= '(' tn= typeName ( ',' tn= typeName )* cp= ')' )?
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            set40=(Token)input.LT(1);
            set40=(Token)input.LT(1);
            if ( (input.LA(1)>=106 && input.LA(1)<=112) ) {
                input.consume();
                if ( state.backtracking==0 ) root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot((org.eclipse.epsilon.common.parse.AST)adaptor.create(set40), root_0);
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            // EolParserRules.g:254:3: (op= '(' tn= typeName ( ',' tn= typeName )* cp= ')' )?
            int alt21=2;
            alt21 = dfa21.predict(input);
            switch (alt21) {
                case 1 :
                    // EolParserRules.g:254:4: op= '(' tn= typeName ( ',' tn= typeName )* cp= ')'
                    {
                    op=(Token)match(input,97,FOLLOW_97_in_collectionType851); if (state.failed) return retval;
                    pushFollow(FOLLOW_typeName_in_collectionType856);
                    tn=typeName();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, tn.getTree());
                    if ( state.backtracking==0 ) {
                      setTokenType(tn,TYPE);
                    }
                    // EolParserRules.g:254:49: ( ',' tn= typeName )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==90) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // EolParserRules.g:254:50: ',' tn= typeName
                    	    {
                    	    char_literal41=(Token)match(input,90,FOLLOW_90_in_collectionType861); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal41_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(char_literal41);
                    	    adaptor.addChild(root_0, char_literal41_tree);
                    	    }
                    	    pushFollow(FOLLOW_typeName_in_collectionType865);
                    	    tn=typeName();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, tn.getTree());
                    	    if ( state.backtracking==0 ) {
                    	      setTokenType(tn,TYPE);
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);

                    cp=(Token)match(input,98,FOLLOW_98_in_collectionType873); if (state.failed) return retval;

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {
              
              		((org.eclipse.epsilon.common.parse.AST)retval.tree).getExtraTokens().add(op); 
              		((org.eclipse.epsilon.common.parse.AST)retval.tree).getExtraTokens().add(cp);
              		((org.eclipse.epsilon.common.parse.AST)retval.tree).getToken().setType(TYPE);
              	
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end collectionType

    public static class statement_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start statement
    // EolParserRules.g:257:1: statement : ( statementA | statementB );
    public final Egx_EolParserRules.statement_return statement() throws RecognitionException {
        Egx_EolParserRules.statement_return retval = new Egx_EolParserRules.statement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Egx_EolParserRules.statementA_return statementA42 = null;

        Egx_EolParserRules.statementB_return statementB43 = null;



        try {
            // EolParserRules.g:258:2: ( statementA | statementB )
            int alt22=2;
            alt22 = dfa22.predict(input);
            switch (alt22) {
                case 1 :
                    // EolParserRules.g:258:4: statementA
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_statementA_in_statement888);
                    statementA42=statementA();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statementA42.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:258:17: statementB
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_statementB_in_statement892);
                    statementB43=statementB();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statementB43.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end statement

    public static class statementA_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start statementA
    // EolParserRules.g:261:1: statementA : ( assignmentStatement | expressionStatement | forStatement | ifStatement | whileStatement | switchStatement | returnStatement | breakStatement );
    public final Egx_EolParserRules.statementA_return statementA() throws RecognitionException {
        Egx_EolParserRules.statementA_return retval = new Egx_EolParserRules.statementA_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Egx_EolParserRules.assignmentStatement_return assignmentStatement44 = null;

        Egx_EolParserRules.expressionStatement_return expressionStatement45 = null;

        Egx_EolParserRules.forStatement_return forStatement46 = null;

        Egx_EolParserRules.ifStatement_return ifStatement47 = null;

        Egx_EolParserRules.whileStatement_return whileStatement48 = null;

        Egx_EolParserRules.switchStatement_return switchStatement49 = null;

        Egx_EolParserRules.returnStatement_return returnStatement50 = null;

        Egx_EolParserRules.breakStatement_return breakStatement51 = null;



        try {
            // EolParserRules.g:262:2: ( assignmentStatement | expressionStatement | forStatement | ifStatement | whileStatement | switchStatement | returnStatement | breakStatement )
            int alt23=8;
            alt23 = dfa23.predict(input);
            switch (alt23) {
                case 1 :
                    // EolParserRules.g:262:4: assignmentStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_assignmentStatement_in_statementA903);
                    assignmentStatement44=assignmentStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, assignmentStatement44.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:262:26: expressionStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_expressionStatement_in_statementA907);
                    expressionStatement45=expressionStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionStatement45.getTree());

                    }
                    break;
                case 3 :
                    // EolParserRules.g:262:48: forStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_forStatement_in_statementA911);
                    forStatement46=forStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, forStatement46.getTree());

                    }
                    break;
                case 4 :
                    // EolParserRules.g:263:5: ifStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_ifStatement_in_statementA917);
                    ifStatement47=ifStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, ifStatement47.getTree());

                    }
                    break;
                case 5 :
                    // EolParserRules.g:263:19: whileStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_whileStatement_in_statementA921);
                    whileStatement48=whileStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, whileStatement48.getTree());

                    }
                    break;
                case 6 :
                    // EolParserRules.g:263:36: switchStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_switchStatement_in_statementA925);
                    switchStatement49=switchStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, switchStatement49.getTree());

                    }
                    break;
                case 7 :
                    // EolParserRules.g:263:54: returnStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_returnStatement_in_statementA929);
                    returnStatement50=returnStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, returnStatement50.getTree());

                    }
                    break;
                case 8 :
                    // EolParserRules.g:263:72: breakStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_breakStatement_in_statementA933);
                    breakStatement51=breakStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, breakStatement51.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end statementA

    public static class statementB_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start statementB
    // EolParserRules.g:266:1: statementB : ( breakAllStatement | returnStatement | transactionStatement | abortStatement | continueStatement | throwStatement | deleteStatement );
    public final Egx_EolParserRules.statementB_return statementB() throws RecognitionException {
        Egx_EolParserRules.statementB_return retval = new Egx_EolParserRules.statementB_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Egx_EolParserRules.breakAllStatement_return breakAllStatement52 = null;

        Egx_EolParserRules.returnStatement_return returnStatement53 = null;

        Egx_EolParserRules.transactionStatement_return transactionStatement54 = null;

        Egx_EolParserRules.abortStatement_return abortStatement55 = null;

        Egx_EolParserRules.continueStatement_return continueStatement56 = null;

        Egx_EolParserRules.throwStatement_return throwStatement57 = null;

        Egx_EolParserRules.deleteStatement_return deleteStatement58 = null;



        try {
            // EolParserRules.g:267:2: ( breakAllStatement | returnStatement | transactionStatement | abortStatement | continueStatement | throwStatement | deleteStatement )
            int alt24=7;
            switch ( input.LA(1) ) {
            case 125:
                {
                alt24=1;
                }
                break;
            case 121:
                {
                alt24=2;
                }
                break;
            case 128:
                {
                alt24=3;
                }
                break;
            case 127:
                {
                alt24=4;
                }
                break;
            case 126:
                {
                alt24=5;
                }
                break;
            case 122:
                {
                alt24=6;
                }
                break;
            case 123:
                {
                alt24=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // EolParserRules.g:267:4: breakAllStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_breakAllStatement_in_statementB945);
                    breakAllStatement52=breakAllStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, breakAllStatement52.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:267:24: returnStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_returnStatement_in_statementB949);
                    returnStatement53=returnStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, returnStatement53.getTree());

                    }
                    break;
                case 3 :
                    // EolParserRules.g:267:42: transactionStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_transactionStatement_in_statementB953);
                    transactionStatement54=transactionStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, transactionStatement54.getTree());

                    }
                    break;
                case 4 :
                    // EolParserRules.g:268:5: abortStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_abortStatement_in_statementB959);
                    abortStatement55=abortStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, abortStatement55.getTree());

                    }
                    break;
                case 5 :
                    // EolParserRules.g:268:22: continueStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_continueStatement_in_statementB963);
                    continueStatement56=continueStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, continueStatement56.getTree());

                    }
                    break;
                case 6 :
                    // EolParserRules.g:268:42: throwStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_throwStatement_in_statementB967);
                    throwStatement57=throwStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, throwStatement57.getTree());

                    }
                    break;
                case 7 :
                    // EolParserRules.g:269:5: deleteStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_deleteStatement_in_statementB973);
                    deleteStatement58=deleteStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, deleteStatement58.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end statementB

    public static class statementOrStatementBlock_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start statementOrStatementBlock
    // EolParserRules.g:272:1: statementOrStatementBlock : ( statement | statementBlock );
    public final Egx_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock() throws RecognitionException {
        Egx_EolParserRules.statementOrStatementBlock_return retval = new Egx_EolParserRules.statementOrStatementBlock_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Egx_EolParserRules.statement_return statement59 = null;

        Egx_EolParserRules.statementBlock_return statementBlock60 = null;



        try {
            // EolParserRules.g:273:2: ( statement | statementBlock )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==FLOAT||LA25_0==INT||LA25_0==BOOLEAN||LA25_0==STRING||LA25_0==NAME||LA25_0==97||(LA25_0>=105 && LA25_0<=113)||(LA25_0>=115 && LA25_0<=116)||(LA25_0>=120 && LA25_0<=128)||LA25_0==142||LA25_0==145||(LA25_0>=149 && LA25_0<=151)) ) {
                alt25=1;
            }
            else if ( (LA25_0==92) ) {
                alt25=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // EolParserRules.g:273:4: statement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_statement_in_statementOrStatementBlock984);
                    statement59=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement59.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:273:16: statementBlock
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_statementBlock_in_statementOrStatementBlock988);
                    statementBlock60=statementBlock();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statementBlock60.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end statementOrStatementBlock

    public static class expressionOrStatementBlock_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start expressionOrStatementBlock
    // EolParserRules.g:275:1: expressionOrStatementBlock : ( ':' logicalExpression | statementBlock );
    public final Egx_EolParserRules.expressionOrStatementBlock_return expressionOrStatementBlock() throws RecognitionException {
        Egx_EolParserRules.expressionOrStatementBlock_return retval = new Egx_EolParserRules.expressionOrStatementBlock_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token char_literal61=null;
        Egx_EolParserRules.logicalExpression_return logicalExpression62 = null;

        Egx_EolParserRules.statementBlock_return statementBlock63 = null;


        org.eclipse.epsilon.common.parse.AST char_literal61_tree=null;

        try {
            // EolParserRules.g:276:2: ( ':' logicalExpression | statementBlock )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==99) ) {
                alt26=1;
            }
            else if ( (LA26_0==92) ) {
                alt26=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // EolParserRules.g:276:4: ':' logicalExpression
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    char_literal61=(Token)match(input,99,FOLLOW_99_in_expressionOrStatementBlock997); if (state.failed) return retval;
                    pushFollow(FOLLOW_logicalExpression_in_expressionOrStatementBlock1000);
                    logicalExpression62=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression62.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:276:29: statementBlock
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_statementBlock_in_expressionOrStatementBlock1004);
                    statementBlock63=statementBlock();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statementBlock63.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end expressionOrStatementBlock

    public static class forStatement_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start forStatement
    // EolParserRules.g:279:1: forStatement : f= 'for' '(' formalParameter 'in' logicalExpression ')' statementOrStatementBlock ;
    public final Egx_EolParserRules.forStatement_return forStatement() throws RecognitionException {
        Egx_EolParserRules.forStatement_return retval = new Egx_EolParserRules.forStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token f=null;
        Token char_literal64=null;
        Token string_literal66=null;
        Token char_literal68=null;
        Egx_EolParserRules.formalParameter_return formalParameter65 = null;

        Egx_EolParserRules.logicalExpression_return logicalExpression67 = null;

        Egx_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock69 = null;


        org.eclipse.epsilon.common.parse.AST f_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal64_tree=null;
        org.eclipse.epsilon.common.parse.AST string_literal66_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal68_tree=null;

        try {
            // EolParserRules.g:280:2: (f= 'for' '(' formalParameter 'in' logicalExpression ')' statementOrStatementBlock )
            // EolParserRules.g:280:4: f= 'for' '(' formalParameter 'in' logicalExpression ')' statementOrStatementBlock
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            f=(Token)match(input,113,FOLLOW_113_in_forStatement1017); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            f_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(f);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(f_tree, root_0);
            }
            char_literal64=(Token)match(input,97,FOLLOW_97_in_forStatement1020); if (state.failed) return retval;
            pushFollow(FOLLOW_formalParameter_in_forStatement1023);
            formalParameter65=formalParameter();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, formalParameter65.getTree());
            string_literal66=(Token)match(input,114,FOLLOW_114_in_forStatement1025); if (state.failed) return retval;
            pushFollow(FOLLOW_logicalExpression_in_forStatement1028);
            logicalExpression67=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression67.getTree());
            char_literal68=(Token)match(input,98,FOLLOW_98_in_forStatement1030); if (state.failed) return retval;
            pushFollow(FOLLOW_statementOrStatementBlock_in_forStatement1033);
            statementOrStatementBlock69=statementOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, statementOrStatementBlock69.getTree());
            if ( state.backtracking==0 ) {
              f.setType(FOR);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end forStatement

    public static class ifStatement_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ifStatement
    // EolParserRules.g:284:1: ifStatement : i= 'if' '(' logicalExpression ')' statementOrStatementBlock ( elseStatement )? ;
    public final Egx_EolParserRules.ifStatement_return ifStatement() throws RecognitionException {
        Egx_EolParserRules.ifStatement_return retval = new Egx_EolParserRules.ifStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token i=null;
        Token char_literal70=null;
        Token char_literal72=null;
        Egx_EolParserRules.logicalExpression_return logicalExpression71 = null;

        Egx_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock73 = null;

        Egx_EolParserRules.elseStatement_return elseStatement74 = null;


        org.eclipse.epsilon.common.parse.AST i_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal70_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal72_tree=null;

        try {
            // EolParserRules.g:285:2: (i= 'if' '(' logicalExpression ')' statementOrStatementBlock ( elseStatement )? )
            // EolParserRules.g:285:4: i= 'if' '(' logicalExpression ')' statementOrStatementBlock ( elseStatement )?
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            i=(Token)match(input,115,FOLLOW_115_in_ifStatement1049); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            i_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(i);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(i_tree, root_0);
            }
            char_literal70=(Token)match(input,97,FOLLOW_97_in_ifStatement1052); if (state.failed) return retval;
            pushFollow(FOLLOW_logicalExpression_in_ifStatement1055);
            logicalExpression71=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression71.getTree());
            char_literal72=(Token)match(input,98,FOLLOW_98_in_ifStatement1057); if (state.failed) return retval;
            pushFollow(FOLLOW_statementOrStatementBlock_in_ifStatement1060);
            statementOrStatementBlock73=statementOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, statementOrStatementBlock73.getTree());
            // EolParserRules.g:285:66: ( elseStatement )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==119) ) {
                int LA27_1 = input.LA(2);

                if ( (synpred46_EolParserRules()) ) {
                    alt27=1;
                }
            }
            switch (alt27) {
                case 1 :
                    // EolParserRules.g:0:0: elseStatement
                    {
                    pushFollow(FOLLOW_elseStatement_in_ifStatement1062);
                    elseStatement74=elseStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, elseStatement74.getTree());

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              i.setType(IF);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end ifStatement

    public static class switchStatement_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start switchStatement
    // EolParserRules.g:289:1: switchStatement : s= 'switch' '(' logicalExpression ')' '{' ( caseStatement )* ( defaultStatement )? '}' ;
    public final Egx_EolParserRules.switchStatement_return switchStatement() throws RecognitionException {
        Egx_EolParserRules.switchStatement_return retval = new Egx_EolParserRules.switchStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token s=null;
        Token char_literal75=null;
        Token char_literal77=null;
        Token char_literal78=null;
        Token char_literal81=null;
        Egx_EolParserRules.logicalExpression_return logicalExpression76 = null;

        Egx_EolParserRules.caseStatement_return caseStatement79 = null;

        Egx_EolParserRules.defaultStatement_return defaultStatement80 = null;


        org.eclipse.epsilon.common.parse.AST s_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal75_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal77_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal78_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal81_tree=null;

        try {
            // EolParserRules.g:290:2: (s= 'switch' '(' logicalExpression ')' '{' ( caseStatement )* ( defaultStatement )? '}' )
            // EolParserRules.g:290:4: s= 'switch' '(' logicalExpression ')' '{' ( caseStatement )* ( defaultStatement )? '}'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            s=(Token)match(input,116,FOLLOW_116_in_switchStatement1081); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            s_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(s);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(s_tree, root_0);
            }
            char_literal75=(Token)match(input,97,FOLLOW_97_in_switchStatement1084); if (state.failed) return retval;
            pushFollow(FOLLOW_logicalExpression_in_switchStatement1087);
            logicalExpression76=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression76.getTree());
            char_literal77=(Token)match(input,98,FOLLOW_98_in_switchStatement1089); if (state.failed) return retval;
            char_literal78=(Token)match(input,92,FOLLOW_92_in_switchStatement1092); if (state.failed) return retval;
            // EolParserRules.g:290:49: ( caseStatement )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==117) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // EolParserRules.g:0:0: caseStatement
            	    {
            	    pushFollow(FOLLOW_caseStatement_in_switchStatement1095);
            	    caseStatement79=caseStatement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, caseStatement79.getTree());

            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

            // EolParserRules.g:290:64: ( defaultStatement )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==118) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // EolParserRules.g:0:0: defaultStatement
                    {
                    pushFollow(FOLLOW_defaultStatement_in_switchStatement1098);
                    defaultStatement80=defaultStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, defaultStatement80.getTree());

                    }
                    break;

            }

            char_literal81=(Token)match(input,93,FOLLOW_93_in_switchStatement1101); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
              s.setType(SWITCH);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end switchStatement

    public static class caseStatement_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start caseStatement
    // EolParserRules.g:294:1: caseStatement : c= 'case' logicalExpression ':' ( block | statementBlock ) ;
    public final Egx_EolParserRules.caseStatement_return caseStatement() throws RecognitionException {
        Egx_EolParserRules.caseStatement_return retval = new Egx_EolParserRules.caseStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token c=null;
        Token char_literal83=null;
        Egx_EolParserRules.logicalExpression_return logicalExpression82 = null;

        Egx_EolParserRules.block_return block84 = null;

        Egx_EolParserRules.statementBlock_return statementBlock85 = null;


        org.eclipse.epsilon.common.parse.AST c_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal83_tree=null;

        try {
            // EolParserRules.g:295:2: (c= 'case' logicalExpression ':' ( block | statementBlock ) )
            // EolParserRules.g:295:4: c= 'case' logicalExpression ':' ( block | statementBlock )
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            c=(Token)match(input,117,FOLLOW_117_in_caseStatement1120); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            c_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(c);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(c_tree, root_0);
            }
            pushFollow(FOLLOW_logicalExpression_in_caseStatement1123);
            logicalExpression82=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression82.getTree());
            char_literal83=(Token)match(input,99,FOLLOW_99_in_caseStatement1125); if (state.failed) return retval;
            // EolParserRules.g:295:37: ( block | statementBlock )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==EOF||LA30_0==FLOAT||LA30_0==INT||LA30_0==BOOLEAN||LA30_0==STRING||LA30_0==NAME||LA30_0==93||LA30_0==97||(LA30_0>=105 && LA30_0<=113)||(LA30_0>=115 && LA30_0<=118)||(LA30_0>=120 && LA30_0<=128)||LA30_0==142||LA30_0==145||(LA30_0>=149 && LA30_0<=151)) ) {
                alt30=1;
            }
            else if ( (LA30_0==92) ) {
                alt30=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // EolParserRules.g:295:38: block
                    {
                    pushFollow(FOLLOW_block_in_caseStatement1129);
                    block84=block();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, block84.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:295:46: statementBlock
                    {
                    pushFollow(FOLLOW_statementBlock_in_caseStatement1133);
                    statementBlock85=statementBlock();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statementBlock85.getTree());

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              c.setType(CASE);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end caseStatement

    public static class defaultStatement_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start defaultStatement
    // EolParserRules.g:299:1: defaultStatement : d= 'default' ':' ( block | statementBlock ) ;
    public final Egx_EolParserRules.defaultStatement_return defaultStatement() throws RecognitionException {
        Egx_EolParserRules.defaultStatement_return retval = new Egx_EolParserRules.defaultStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token d=null;
        Token char_literal86=null;
        Egx_EolParserRules.block_return block87 = null;

        Egx_EolParserRules.statementBlock_return statementBlock88 = null;


        org.eclipse.epsilon.common.parse.AST d_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal86_tree=null;

        try {
            // EolParserRules.g:300:2: (d= 'default' ':' ( block | statementBlock ) )
            // EolParserRules.g:300:4: d= 'default' ':' ( block | statementBlock )
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            d=(Token)match(input,118,FOLLOW_118_in_defaultStatement1152); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            d_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(d);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(d_tree, root_0);
            }
            char_literal86=(Token)match(input,99,FOLLOW_99_in_defaultStatement1155); if (state.failed) return retval;
            // EolParserRules.g:300:22: ( block | statementBlock )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==EOF||LA31_0==FLOAT||LA31_0==INT||LA31_0==BOOLEAN||LA31_0==STRING||LA31_0==NAME||LA31_0==93||LA31_0==97||(LA31_0>=105 && LA31_0<=113)||(LA31_0>=115 && LA31_0<=118)||(LA31_0>=120 && LA31_0<=128)||LA31_0==142||LA31_0==145||(LA31_0>=149 && LA31_0<=151)) ) {
                alt31=1;
            }
            else if ( (LA31_0==92) ) {
                alt31=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }
            switch (alt31) {
                case 1 :
                    // EolParserRules.g:300:23: block
                    {
                    pushFollow(FOLLOW_block_in_defaultStatement1159);
                    block87=block();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, block87.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:300:31: statementBlock
                    {
                    pushFollow(FOLLOW_statementBlock_in_defaultStatement1163);
                    statementBlock88=statementBlock();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statementBlock88.getTree());

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              d.setType(DEFAULT);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end defaultStatement

    public static class elseStatement_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start elseStatement
    // EolParserRules.g:304:1: elseStatement : e= 'else' statementOrStatementBlock ;
    public final Egx_EolParserRules.elseStatement_return elseStatement() throws RecognitionException {
        Egx_EolParserRules.elseStatement_return retval = new Egx_EolParserRules.elseStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token e=null;
        Egx_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock89 = null;


        org.eclipse.epsilon.common.parse.AST e_tree=null;

        try {
            // EolParserRules.g:308:2: (e= 'else' statementOrStatementBlock )
            // EolParserRules.g:308:4: e= 'else' statementOrStatementBlock
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            e=(Token)match(input,119,FOLLOW_119_in_elseStatement1188); if (state.failed) return retval;
            pushFollow(FOLLOW_statementOrStatementBlock_in_elseStatement1191);
            statementOrStatementBlock89=statementOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, statementOrStatementBlock89.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {
              
              		((org.eclipse.epsilon.common.parse.AST)retval.tree).getExtraTokens().add(e);
              	
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end elseStatement

    public static class whileStatement_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start whileStatement
    // EolParserRules.g:311:1: whileStatement : w= 'while' '(' logicalExpression ')' statementOrStatementBlock ;
    public final Egx_EolParserRules.whileStatement_return whileStatement() throws RecognitionException {
        Egx_EolParserRules.whileStatement_return retval = new Egx_EolParserRules.whileStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token w=null;
        Token char_literal90=null;
        Token char_literal92=null;
        Egx_EolParserRules.logicalExpression_return logicalExpression91 = null;

        Egx_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock93 = null;


        org.eclipse.epsilon.common.parse.AST w_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal90_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal92_tree=null;

        try {
            // EolParserRules.g:312:2: (w= 'while' '(' logicalExpression ')' statementOrStatementBlock )
            // EolParserRules.g:312:4: w= 'while' '(' logicalExpression ')' statementOrStatementBlock
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            w=(Token)match(input,120,FOLLOW_120_in_whileStatement1204); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            w_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(w);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(w_tree, root_0);
            }
            char_literal90=(Token)match(input,97,FOLLOW_97_in_whileStatement1207); if (state.failed) return retval;
            pushFollow(FOLLOW_logicalExpression_in_whileStatement1210);
            logicalExpression91=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression91.getTree());
            char_literal92=(Token)match(input,98,FOLLOW_98_in_whileStatement1212); if (state.failed) return retval;
            pushFollow(FOLLOW_statementOrStatementBlock_in_whileStatement1215);
            statementOrStatementBlock93=statementOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, statementOrStatementBlock93.getTree());
            if ( state.backtracking==0 ) {
              w.setType(WHILE);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end whileStatement

    public static class returnStatement_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start returnStatement
    // EolParserRules.g:316:1: returnStatement : r= 'return' ( logicalExpression )? sem= ';' ;
    public final Egx_EolParserRules.returnStatement_return returnStatement() throws RecognitionException {
        Egx_EolParserRules.returnStatement_return retval = new Egx_EolParserRules.returnStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token r=null;
        Token sem=null;
        Egx_EolParserRules.logicalExpression_return logicalExpression94 = null;


        org.eclipse.epsilon.common.parse.AST r_tree=null;
        org.eclipse.epsilon.common.parse.AST sem_tree=null;

        try {
            // EolParserRules.g:320:2: (r= 'return' ( logicalExpression )? sem= ';' )
            // EolParserRules.g:320:4: r= 'return' ( logicalExpression )? sem= ';'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            r=(Token)match(input,121,FOLLOW_121_in_returnStatement1237); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            r_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(r);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(r_tree, root_0);
            }
            // EolParserRules.g:320:16: ( logicalExpression )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==FLOAT||LA32_0==INT||LA32_0==BOOLEAN||LA32_0==STRING||LA32_0==NAME||LA32_0==97||(LA32_0>=105 && LA32_0<=112)||LA32_0==142||LA32_0==145||(LA32_0>=149 && LA32_0<=151)) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // EolParserRules.g:0:0: logicalExpression
                    {
                    pushFollow(FOLLOW_logicalExpression_in_returnStatement1240);
                    logicalExpression94=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression94.getTree());

                    }
                    break;

            }

            sem=(Token)match(input,88,FOLLOW_88_in_returnStatement1245); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
              r.setType(RETURN);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {
              
              		((org.eclipse.epsilon.common.parse.AST)retval.tree).getExtraTokens().add(sem);
              	
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end returnStatement

    public static class throwStatement_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start throwStatement
    // EolParserRules.g:324:1: throwStatement : t= 'throw' ( logicalExpression )? sem= ';' ;
    public final Egx_EolParserRules.throwStatement_return throwStatement() throws RecognitionException {
        Egx_EolParserRules.throwStatement_return retval = new Egx_EolParserRules.throwStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token t=null;
        Token sem=null;
        Egx_EolParserRules.logicalExpression_return logicalExpression95 = null;


        org.eclipse.epsilon.common.parse.AST t_tree=null;
        org.eclipse.epsilon.common.parse.AST sem_tree=null;

        try {
            // EolParserRules.g:328:2: (t= 'throw' ( logicalExpression )? sem= ';' )
            // EolParserRules.g:328:4: t= 'throw' ( logicalExpression )? sem= ';'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            t=(Token)match(input,122,FOLLOW_122_in_throwStatement1268); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            t_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(t);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(t_tree, root_0);
            }
            // EolParserRules.g:328:15: ( logicalExpression )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==FLOAT||LA33_0==INT||LA33_0==BOOLEAN||LA33_0==STRING||LA33_0==NAME||LA33_0==97||(LA33_0>=105 && LA33_0<=112)||LA33_0==142||LA33_0==145||(LA33_0>=149 && LA33_0<=151)) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // EolParserRules.g:0:0: logicalExpression
                    {
                    pushFollow(FOLLOW_logicalExpression_in_throwStatement1271);
                    logicalExpression95=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression95.getTree());

                    }
                    break;

            }

            sem=(Token)match(input,88,FOLLOW_88_in_throwStatement1276); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
              t.setType(THROW);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {
              
              		((org.eclipse.epsilon.common.parse.AST)retval.tree).getExtraTokens().add(sem);
              	
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end throwStatement

    public static class deleteStatement_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start deleteStatement
    // EolParserRules.g:332:1: deleteStatement : d= 'delete' ( logicalExpression )? sem= ';' ;
    public final Egx_EolParserRules.deleteStatement_return deleteStatement() throws RecognitionException {
        Egx_EolParserRules.deleteStatement_return retval = new Egx_EolParserRules.deleteStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token d=null;
        Token sem=null;
        Egx_EolParserRules.logicalExpression_return logicalExpression96 = null;


        org.eclipse.epsilon.common.parse.AST d_tree=null;
        org.eclipse.epsilon.common.parse.AST sem_tree=null;

        try {
            // EolParserRules.g:336:2: (d= 'delete' ( logicalExpression )? sem= ';' )
            // EolParserRules.g:336:4: d= 'delete' ( logicalExpression )? sem= ';'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            d=(Token)match(input,123,FOLLOW_123_in_deleteStatement1299); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            d_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(d);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(d_tree, root_0);
            }
            // EolParserRules.g:336:16: ( logicalExpression )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==FLOAT||LA34_0==INT||LA34_0==BOOLEAN||LA34_0==STRING||LA34_0==NAME||LA34_0==97||(LA34_0>=105 && LA34_0<=112)||LA34_0==142||LA34_0==145||(LA34_0>=149 && LA34_0<=151)) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // EolParserRules.g:0:0: logicalExpression
                    {
                    pushFollow(FOLLOW_logicalExpression_in_deleteStatement1302);
                    logicalExpression96=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression96.getTree());

                    }
                    break;

            }

            sem=(Token)match(input,88,FOLLOW_88_in_deleteStatement1307); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
              d.setType(DELETE);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {
              
              		((org.eclipse.epsilon.common.parse.AST)retval.tree).getExtraTokens().add(sem);
              	
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end deleteStatement

    public static class breakStatement_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start breakStatement
    // EolParserRules.g:340:1: breakStatement : b= 'break' sem= ';' ;
    public final Egx_EolParserRules.breakStatement_return breakStatement() throws RecognitionException {
        Egx_EolParserRules.breakStatement_return retval = new Egx_EolParserRules.breakStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token b=null;
        Token sem=null;

        org.eclipse.epsilon.common.parse.AST b_tree=null;
        org.eclipse.epsilon.common.parse.AST sem_tree=null;

        try {
            // EolParserRules.g:344:2: (b= 'break' sem= ';' )
            // EolParserRules.g:344:4: b= 'break' sem= ';'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            b=(Token)match(input,124,FOLLOW_124_in_breakStatement1333); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            b_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(b);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(b_tree, root_0);
            }
            sem=(Token)match(input,88,FOLLOW_88_in_breakStatement1338); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
              b.setType(BREAK);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {
              
              		((org.eclipse.epsilon.common.parse.AST)retval.tree).getExtraTokens().add(sem);
              	
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end breakStatement

    public static class breakAllStatement_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start breakAllStatement
    // EolParserRules.g:348:1: breakAllStatement : b= 'breakAll' sem= ';' ;
    public final Egx_EolParserRules.breakAllStatement_return breakAllStatement() throws RecognitionException {
        Egx_EolParserRules.breakAllStatement_return retval = new Egx_EolParserRules.breakAllStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token b=null;
        Token sem=null;

        org.eclipse.epsilon.common.parse.AST b_tree=null;
        org.eclipse.epsilon.common.parse.AST sem_tree=null;

        try {
            // EolParserRules.g:352:2: (b= 'breakAll' sem= ';' )
            // EolParserRules.g:352:4: b= 'breakAll' sem= ';'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            b=(Token)match(input,125,FOLLOW_125_in_breakAllStatement1361); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            b_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(b);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(b_tree, root_0);
            }
            sem=(Token)match(input,88,FOLLOW_88_in_breakAllStatement1366); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
              b.setType(BREAKALL);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {
              
              		((org.eclipse.epsilon.common.parse.AST)retval.tree).getExtraTokens().add(sem);
              	
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end breakAllStatement

    public static class continueStatement_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start continueStatement
    // EolParserRules.g:356:1: continueStatement : c= 'continue' sem= ';' ;
    public final Egx_EolParserRules.continueStatement_return continueStatement() throws RecognitionException {
        Egx_EolParserRules.continueStatement_return retval = new Egx_EolParserRules.continueStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token c=null;
        Token sem=null;

        org.eclipse.epsilon.common.parse.AST c_tree=null;
        org.eclipse.epsilon.common.parse.AST sem_tree=null;

        try {
            // EolParserRules.g:360:2: (c= 'continue' sem= ';' )
            // EolParserRules.g:360:4: c= 'continue' sem= ';'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            c=(Token)match(input,126,FOLLOW_126_in_continueStatement1389); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            c_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(c);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(c_tree, root_0);
            }
            sem=(Token)match(input,88,FOLLOW_88_in_continueStatement1394); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
              c.setType(CONTINUE);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {
              
              		((org.eclipse.epsilon.common.parse.AST)retval.tree).getExtraTokens().add(sem);
              	
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end continueStatement

    public static class abortStatement_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start abortStatement
    // EolParserRules.g:364:1: abortStatement : a= 'abort' sem= ';' ;
    public final Egx_EolParserRules.abortStatement_return abortStatement() throws RecognitionException {
        Egx_EolParserRules.abortStatement_return retval = new Egx_EolParserRules.abortStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token a=null;
        Token sem=null;

        org.eclipse.epsilon.common.parse.AST a_tree=null;
        org.eclipse.epsilon.common.parse.AST sem_tree=null;

        try {
            // EolParserRules.g:368:2: (a= 'abort' sem= ';' )
            // EolParserRules.g:368:4: a= 'abort' sem= ';'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            a=(Token)match(input,127,FOLLOW_127_in_abortStatement1417); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            a_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(a);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(a_tree, root_0);
            }
            sem=(Token)match(input,88,FOLLOW_88_in_abortStatement1422); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
              a.setType(ABORT);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {
              
              		((org.eclipse.epsilon.common.parse.AST)retval.tree).getExtraTokens().add(sem);
              	
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end abortStatement

    public static class transactionStatement_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start transactionStatement
    // EolParserRules.g:372:1: transactionStatement : t= 'transaction' ( NAME ( ',' NAME )* )? statementOrStatementBlock ;
    public final Egx_EolParserRules.transactionStatement_return transactionStatement() throws RecognitionException {
        Egx_EolParserRules.transactionStatement_return retval = new Egx_EolParserRules.transactionStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token t=null;
        Token NAME97=null;
        Token char_literal98=null;
        Token NAME99=null;
        Egx_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock100 = null;


        org.eclipse.epsilon.common.parse.AST t_tree=null;
        org.eclipse.epsilon.common.parse.AST NAME97_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal98_tree=null;
        org.eclipse.epsilon.common.parse.AST NAME99_tree=null;

        try {
            // EolParserRules.g:373:2: (t= 'transaction' ( NAME ( ',' NAME )* )? statementOrStatementBlock )
            // EolParserRules.g:373:4: t= 'transaction' ( NAME ( ',' NAME )* )? statementOrStatementBlock
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            t=(Token)match(input,128,FOLLOW_128_in_transactionStatement1439); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            t_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(t);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(t_tree, root_0);
            }
            // EolParserRules.g:373:21: ( NAME ( ',' NAME )* )?
            int alt36=2;
            alt36 = dfa36.predict(input);
            switch (alt36) {
                case 1 :
                    // EolParserRules.g:373:22: NAME ( ',' NAME )*
                    {
                    NAME97=(Token)match(input,NAME,FOLLOW_NAME_in_transactionStatement1443); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NAME97_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(NAME97);
                    adaptor.addChild(root_0, NAME97_tree);
                    }
                    // EolParserRules.g:373:27: ( ',' NAME )*
                    loop35:
                    do {
                        int alt35=2;
                        int LA35_0 = input.LA(1);

                        if ( (LA35_0==90) ) {
                            alt35=1;
                        }


                        switch (alt35) {
                    	case 1 :
                    	    // EolParserRules.g:373:28: ',' NAME
                    	    {
                    	    char_literal98=(Token)match(input,90,FOLLOW_90_in_transactionStatement1446); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal98_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(char_literal98);
                    	    adaptor.addChild(root_0, char_literal98_tree);
                    	    }
                    	    NAME99=(Token)match(input,NAME,FOLLOW_NAME_in_transactionStatement1448); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    NAME99_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(NAME99);
                    	    adaptor.addChild(root_0, NAME99_tree);
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop35;
                        }
                    } while (true);


                    }
                    break;

            }

            pushFollow(FOLLOW_statementOrStatementBlock_in_transactionStatement1454);
            statementOrStatementBlock100=statementOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, statementOrStatementBlock100.getTree());
            if ( state.backtracking==0 ) {
              t.setType(TRANSACTION);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end transactionStatement

    public static class assignmentStatement_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start assignmentStatement
    // EolParserRules.g:377:1: assignmentStatement : logicalExpression (normal= ':=' | special= '::=' ) logicalExpression sem= ';' ;
    public final Egx_EolParserRules.assignmentStatement_return assignmentStatement() throws RecognitionException {
        Egx_EolParserRules.assignmentStatement_return retval = new Egx_EolParserRules.assignmentStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token normal=null;
        Token special=null;
        Token sem=null;
        Egx_EolParserRules.logicalExpression_return logicalExpression101 = null;

        Egx_EolParserRules.logicalExpression_return logicalExpression102 = null;


        org.eclipse.epsilon.common.parse.AST normal_tree=null;
        org.eclipse.epsilon.common.parse.AST special_tree=null;
        org.eclipse.epsilon.common.parse.AST sem_tree=null;

        try {
            // EolParserRules.g:381:2: ( logicalExpression (normal= ':=' | special= '::=' ) logicalExpression sem= ';' )
            // EolParserRules.g:381:4: logicalExpression (normal= ':=' | special= '::=' ) logicalExpression sem= ';'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            pushFollow(FOLLOW_logicalExpression_in_assignmentStatement1474);
            logicalExpression101=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression101.getTree());
            // EolParserRules.g:381:22: (normal= ':=' | special= '::=' )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==129) ) {
                alt37=1;
            }
            else if ( (LA37_0==130) ) {
                alt37=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }
            switch (alt37) {
                case 1 :
                    // EolParserRules.g:381:23: normal= ':='
                    {
                    normal=(Token)match(input,129,FOLLOW_129_in_assignmentStatement1479); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    normal_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(normal);
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(normal_tree, root_0);
                    }
                    if ( state.backtracking==0 ) {
                      normal.setType(ASSIGNMENT);
                    }

                    }
                    break;
                case 2 :
                    // EolParserRules.g:381:66: special= '::='
                    {
                    special=(Token)match(input,130,FOLLOW_130_in_assignmentStatement1486); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    special_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(special);
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(special_tree, root_0);
                    }
                    if ( state.backtracking==0 ) {
                      special.setType(SPECIAL_ASSIGNMENT);
                    }

                    }
                    break;

            }

            pushFollow(FOLLOW_logicalExpression_in_assignmentStatement1492);
            logicalExpression102=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression102.getTree());
            sem=(Token)match(input,88,FOLLOW_88_in_assignmentStatement1496); if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {
              
              		((org.eclipse.epsilon.common.parse.AST)retval.tree).getExtraTokens().add(sem);
              	
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end assignmentStatement

    public static class expressionStatement_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start expressionStatement
    // EolParserRules.g:385:1: expressionStatement : ( postfixExpression op= '=' logicalExpression | logicalExpression ) sem= ';' ;
    public final Egx_EolParserRules.expressionStatement_return expressionStatement() throws RecognitionException {
        Egx_EolParserRules.expressionStatement_return retval = new Egx_EolParserRules.expressionStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token op=null;
        Token sem=null;
        Egx_EolParserRules.postfixExpression_return postfixExpression103 = null;

        Egx_EolParserRules.logicalExpression_return logicalExpression104 = null;

        Egx_EolParserRules.logicalExpression_return logicalExpression105 = null;


        org.eclipse.epsilon.common.parse.AST op_tree=null;
        org.eclipse.epsilon.common.parse.AST sem_tree=null;

        try {
            // EolParserRules.g:389:2: ( ( postfixExpression op= '=' logicalExpression | logicalExpression ) sem= ';' )
            // EolParserRules.g:389:4: ( postfixExpression op= '=' logicalExpression | logicalExpression ) sem= ';'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            // EolParserRules.g:389:4: ( postfixExpression op= '=' logicalExpression | logicalExpression )
            int alt38=2;
            alt38 = dfa38.predict(input);
            switch (alt38) {
                case 1 :
                    // EolParserRules.g:389:5: postfixExpression op= '=' logicalExpression
                    {
                    pushFollow(FOLLOW_postfixExpression_in_expressionStatement1518);
                    postfixExpression103=postfixExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, postfixExpression103.getTree());
                    op=(Token)match(input,94,FOLLOW_94_in_expressionStatement1522); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
                    }
                    pushFollow(FOLLOW_logicalExpression_in_expressionStatement1525);
                    logicalExpression104=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression104.getTree());
                    if ( state.backtracking==0 ) {
                      op.setType(OPERATOR);
                    }

                    }
                    break;
                case 2 :
                    // EolParserRules.g:389:76: logicalExpression
                    {
                    pushFollow(FOLLOW_logicalExpression_in_expressionStatement1531);
                    logicalExpression105=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression105.getTree());

                    }
                    break;

            }

            sem=(Token)match(input,88,FOLLOW_88_in_expressionStatement1536); if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {
              
              		((org.eclipse.epsilon.common.parse.AST)retval.tree).getExtraTokens().add(sem);
              	
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end expressionStatement

    public static class logicalExpression_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start logicalExpression
    // EolParserRules.g:392:1: logicalExpression : relationalExpression ( (op= 'or' | op= 'and' | op= 'xor' | op= 'implies' ) relationalExpression )* ;
    public final Egx_EolParserRules.logicalExpression_return logicalExpression() throws RecognitionException {
        Egx_EolParserRules.logicalExpression_return retval = new Egx_EolParserRules.logicalExpression_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token op=null;
        Egx_EolParserRules.relationalExpression_return relationalExpression106 = null;

        Egx_EolParserRules.relationalExpression_return relationalExpression107 = null;


        org.eclipse.epsilon.common.parse.AST op_tree=null;

        try {
            // EolParserRules.g:393:2: ( relationalExpression ( (op= 'or' | op= 'and' | op= 'xor' | op= 'implies' ) relationalExpression )* )
            // EolParserRules.g:393:4: relationalExpression ( (op= 'or' | op= 'and' | op= 'xor' | op= 'implies' ) relationalExpression )*
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            pushFollow(FOLLOW_relationalExpression_in_logicalExpression1548);
            relationalExpression106=relationalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, relationalExpression106.getTree());
            // EolParserRules.g:393:25: ( (op= 'or' | op= 'and' | op= 'xor' | op= 'implies' ) relationalExpression )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( ((LA40_0>=131 && LA40_0<=134)) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // EolParserRules.g:393:26: (op= 'or' | op= 'and' | op= 'xor' | op= 'implies' ) relationalExpression
            	    {
            	    // EolParserRules.g:393:26: (op= 'or' | op= 'and' | op= 'xor' | op= 'implies' )
            	    int alt39=4;
            	    switch ( input.LA(1) ) {
            	    case 131:
            	        {
            	        alt39=1;
            	        }
            	        break;
            	    case 132:
            	        {
            	        alt39=2;
            	        }
            	        break;
            	    case 133:
            	        {
            	        alt39=3;
            	        }
            	        break;
            	    case 134:
            	        {
            	        alt39=4;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 39, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt39) {
            	        case 1 :
            	            // EolParserRules.g:393:27: op= 'or'
            	            {
            	            op=(Token)match(input,131,FOLLOW_131_in_logicalExpression1554); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // EolParserRules.g:393:36: op= 'and'
            	            {
            	            op=(Token)match(input,132,FOLLOW_132_in_logicalExpression1559); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // EolParserRules.g:393:46: op= 'xor'
            	            {
            	            op=(Token)match(input,133,FOLLOW_133_in_logicalExpression1564); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 4 :
            	            // EolParserRules.g:393:56: op= 'implies'
            	            {
            	            op=(Token)match(input,134,FOLLOW_134_in_logicalExpression1569); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_relationalExpression_in_logicalExpression1573);
            	    relationalExpression107=relationalExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, relationalExpression107.getTree());
            	    if ( state.backtracking==0 ) {
            	      op.setType(OPERATOR);
            	    }

            	    }
            	    break;

            	default :
            	    break loop40;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end logicalExpression

    public static class relationalExpression_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start relationalExpression
    // EolParserRules.g:397:1: relationalExpression : additiveExpression ( (op= '==' relationalExpression | op= '=' relationalExpression | (op= '>' | op= '<' | op= '>=' | op= '<=' | op= '<>' ) additiveExpression ) )* ;
    public final Egx_EolParserRules.relationalExpression_return relationalExpression() throws RecognitionException {
        Egx_EolParserRules.relationalExpression_return retval = new Egx_EolParserRules.relationalExpression_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token op=null;
        Egx_EolParserRules.additiveExpression_return additiveExpression108 = null;

        Egx_EolParserRules.relationalExpression_return relationalExpression109 = null;

        Egx_EolParserRules.relationalExpression_return relationalExpression110 = null;

        Egx_EolParserRules.additiveExpression_return additiveExpression111 = null;


        org.eclipse.epsilon.common.parse.AST op_tree=null;

        try {
            // EolParserRules.g:398:2: ( additiveExpression ( (op= '==' relationalExpression | op= '=' relationalExpression | (op= '>' | op= '<' | op= '>=' | op= '<=' | op= '<>' ) additiveExpression ) )* )
            // EolParserRules.g:398:4: additiveExpression ( (op= '==' relationalExpression | op= '=' relationalExpression | (op= '>' | op= '<' | op= '>=' | op= '<=' | op= '<>' ) additiveExpression ) )*
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            pushFollow(FOLLOW_additiveExpression_in_relationalExpression1590);
            additiveExpression108=additiveExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, additiveExpression108.getTree());
            // EolParserRules.g:398:23: ( (op= '==' relationalExpression | op= '=' relationalExpression | (op= '>' | op= '<' | op= '>=' | op= '<=' | op= '<>' ) additiveExpression ) )*
            loop43:
            do {
                int alt43=2;
                alt43 = dfa43.predict(input);
                switch (alt43) {
            	case 1 :
            	    // EolParserRules.g:398:24: (op= '==' relationalExpression | op= '=' relationalExpression | (op= '>' | op= '<' | op= '>=' | op= '<=' | op= '<>' ) additiveExpression )
            	    {
            	    // EolParserRules.g:398:24: (op= '==' relationalExpression | op= '=' relationalExpression | (op= '>' | op= '<' | op= '>=' | op= '<=' | op= '<>' ) additiveExpression )
            	    int alt42=3;
            	    switch ( input.LA(1) ) {
            	    case 135:
            	        {
            	        alt42=1;
            	        }
            	        break;
            	    case 94:
            	        {
            	        alt42=2;
            	        }
            	        break;
            	    case 136:
            	    case 137:
            	    case 138:
            	    case 139:
            	    case 140:
            	        {
            	        alt42=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 42, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt42) {
            	        case 1 :
            	            // EolParserRules.g:398:25: op= '==' relationalExpression
            	            {
            	            op=(Token)match(input,135,FOLLOW_135_in_relationalExpression1596); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	            }
            	            pushFollow(FOLLOW_relationalExpression_in_relationalExpression1599);
            	            relationalExpression109=relationalExpression();

            	            state._fsp--;
            	            if (state.failed) return retval;
            	            if ( state.backtracking==0 ) adaptor.addChild(root_0, relationalExpression109.getTree());

            	            }
            	            break;
            	        case 2 :
            	            // EolParserRules.g:398:57: op= '=' relationalExpression
            	            {
            	            op=(Token)match(input,94,FOLLOW_94_in_relationalExpression1605); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	            }
            	            pushFollow(FOLLOW_relationalExpression_in_relationalExpression1608);
            	            relationalExpression110=relationalExpression();

            	            state._fsp--;
            	            if (state.failed) return retval;
            	            if ( state.backtracking==0 ) adaptor.addChild(root_0, relationalExpression110.getTree());

            	            }
            	            break;
            	        case 3 :
            	            // EolParserRules.g:399:24: (op= '>' | op= '<' | op= '>=' | op= '<=' | op= '<>' ) additiveExpression
            	            {
            	            // EolParserRules.g:399:24: (op= '>' | op= '<' | op= '>=' | op= '<=' | op= '<>' )
            	            int alt41=5;
            	            switch ( input.LA(1) ) {
            	            case 136:
            	                {
            	                alt41=1;
            	                }
            	                break;
            	            case 137:
            	                {
            	                alt41=2;
            	                }
            	                break;
            	            case 138:
            	                {
            	                alt41=3;
            	                }
            	                break;
            	            case 139:
            	                {
            	                alt41=4;
            	                }
            	                break;
            	            case 140:
            	                {
            	                alt41=5;
            	                }
            	                break;
            	            default:
            	                if (state.backtracking>0) {state.failed=true; return retval;}
            	                NoViableAltException nvae =
            	                    new NoViableAltException("", 41, 0, input);

            	                throw nvae;
            	            }

            	            switch (alt41) {
            	                case 1 :
            	                    // EolParserRules.g:399:25: op= '>'
            	                    {
            	                    op=(Token)match(input,136,FOLLOW_136_in_relationalExpression1638); if (state.failed) return retval;
            	                    if ( state.backtracking==0 ) {
            	                    op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	                    }

            	                    }
            	                    break;
            	                case 2 :
            	                    // EolParserRules.g:399:33: op= '<'
            	                    {
            	                    op=(Token)match(input,137,FOLLOW_137_in_relationalExpression1643); if (state.failed) return retval;
            	                    if ( state.backtracking==0 ) {
            	                    op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	                    }

            	                    }
            	                    break;
            	                case 3 :
            	                    // EolParserRules.g:399:41: op= '>='
            	                    {
            	                    op=(Token)match(input,138,FOLLOW_138_in_relationalExpression1648); if (state.failed) return retval;
            	                    if ( state.backtracking==0 ) {
            	                    op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	                    }

            	                    }
            	                    break;
            	                case 4 :
            	                    // EolParserRules.g:399:50: op= '<='
            	                    {
            	                    op=(Token)match(input,139,FOLLOW_139_in_relationalExpression1653); if (state.failed) return retval;
            	                    if ( state.backtracking==0 ) {
            	                    op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	                    }

            	                    }
            	                    break;
            	                case 5 :
            	                    // EolParserRules.g:399:59: op= '<>'
            	                    {
            	                    op=(Token)match(input,140,FOLLOW_140_in_relationalExpression1658); if (state.failed) return retval;
            	                    if ( state.backtracking==0 ) {
            	                    op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	                    }

            	                    }
            	                    break;

            	            }

            	            pushFollow(FOLLOW_additiveExpression_in_relationalExpression1662);
            	            additiveExpression111=additiveExpression();

            	            state._fsp--;
            	            if (state.failed) return retval;
            	            if ( state.backtracking==0 ) adaptor.addChild(root_0, additiveExpression111.getTree());

            	            }
            	            break;

            	    }

            	    if ( state.backtracking==0 ) {
            	      op.setType(OPERATOR);
            	    }

            	    }
            	    break;

            	default :
            	    break loop43;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end relationalExpression

    public static class additiveExpression_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start additiveExpression
    // EolParserRules.g:403:1: additiveExpression : multiplicativeExpression ( (op= '+' | op= '-' ) multiplicativeExpression )* ;
    public final Egx_EolParserRules.additiveExpression_return additiveExpression() throws RecognitionException {
        Egx_EolParserRules.additiveExpression_return retval = new Egx_EolParserRules.additiveExpression_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token op=null;
        Egx_EolParserRules.multiplicativeExpression_return multiplicativeExpression112 = null;

        Egx_EolParserRules.multiplicativeExpression_return multiplicativeExpression113 = null;


        org.eclipse.epsilon.common.parse.AST op_tree=null;

        try {
            // EolParserRules.g:404:2: ( multiplicativeExpression ( (op= '+' | op= '-' ) multiplicativeExpression )* )
            // EolParserRules.g:404:4: multiplicativeExpression ( (op= '+' | op= '-' ) multiplicativeExpression )*
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            pushFollow(FOLLOW_multiplicativeExpression_in_additiveExpression1680);
            multiplicativeExpression112=multiplicativeExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, multiplicativeExpression112.getTree());
            // EolParserRules.g:404:29: ( (op= '+' | op= '-' ) multiplicativeExpression )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( ((LA45_0>=141 && LA45_0<=142)) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // EolParserRules.g:404:30: (op= '+' | op= '-' ) multiplicativeExpression
            	    {
            	    // EolParserRules.g:404:30: (op= '+' | op= '-' )
            	    int alt44=2;
            	    int LA44_0 = input.LA(1);

            	    if ( (LA44_0==141) ) {
            	        alt44=1;
            	    }
            	    else if ( (LA44_0==142) ) {
            	        alt44=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 44, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt44) {
            	        case 1 :
            	            // EolParserRules.g:404:31: op= '+'
            	            {
            	            op=(Token)match(input,141,FOLLOW_141_in_additiveExpression1686); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // EolParserRules.g:404:39: op= '-'
            	            {
            	            op=(Token)match(input,142,FOLLOW_142_in_additiveExpression1691); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_multiplicativeExpression_in_additiveExpression1695);
            	    multiplicativeExpression113=multiplicativeExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, multiplicativeExpression113.getTree());
            	    if ( state.backtracking==0 ) {
            	      op.setType(OPERATOR);
            	    }

            	    }
            	    break;

            	default :
            	    break loop45;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end additiveExpression

    public static class multiplicativeExpression_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start multiplicativeExpression
    // EolParserRules.g:408:1: multiplicativeExpression : unaryExpression ( (op= '*' | op= '/' ) unaryExpression )* ;
    public final Egx_EolParserRules.multiplicativeExpression_return multiplicativeExpression() throws RecognitionException {
        Egx_EolParserRules.multiplicativeExpression_return retval = new Egx_EolParserRules.multiplicativeExpression_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token op=null;
        Egx_EolParserRules.unaryExpression_return unaryExpression114 = null;

        Egx_EolParserRules.unaryExpression_return unaryExpression115 = null;


        org.eclipse.epsilon.common.parse.AST op_tree=null;

        try {
            // EolParserRules.g:409:2: ( unaryExpression ( (op= '*' | op= '/' ) unaryExpression )* )
            // EolParserRules.g:409:4: unaryExpression ( (op= '*' | op= '/' ) unaryExpression )*
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            pushFollow(FOLLOW_unaryExpression_in_multiplicativeExpression1713);
            unaryExpression114=unaryExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, unaryExpression114.getTree());
            // EolParserRules.g:409:20: ( (op= '*' | op= '/' ) unaryExpression )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( ((LA47_0>=143 && LA47_0<=144)) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // EolParserRules.g:409:21: (op= '*' | op= '/' ) unaryExpression
            	    {
            	    // EolParserRules.g:409:21: (op= '*' | op= '/' )
            	    int alt46=2;
            	    int LA46_0 = input.LA(1);

            	    if ( (LA46_0==143) ) {
            	        alt46=1;
            	    }
            	    else if ( (LA46_0==144) ) {
            	        alt46=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 46, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt46) {
            	        case 1 :
            	            // EolParserRules.g:409:22: op= '*'
            	            {
            	            op=(Token)match(input,143,FOLLOW_143_in_multiplicativeExpression1719); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // EolParserRules.g:409:30: op= '/'
            	            {
            	            op=(Token)match(input,144,FOLLOW_144_in_multiplicativeExpression1724); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_unaryExpression_in_multiplicativeExpression1728);
            	    unaryExpression115=unaryExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, unaryExpression115.getTree());
            	    if ( state.backtracking==0 ) {
            	      op.setType(OPERATOR);
            	    }

            	    }
            	    break;

            	default :
            	    break loop47;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end multiplicativeExpression

    public static class unaryExpression_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start unaryExpression
    // EolParserRules.g:413:1: unaryExpression : ( (op= 'not' | op= '-' ) )? postfixExpression ;
    public final Egx_EolParserRules.unaryExpression_return unaryExpression() throws RecognitionException {
        Egx_EolParserRules.unaryExpression_return retval = new Egx_EolParserRules.unaryExpression_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token op=null;
        Egx_EolParserRules.postfixExpression_return postfixExpression116 = null;


        org.eclipse.epsilon.common.parse.AST op_tree=null;

        try {
            // EolParserRules.g:414:2: ( ( (op= 'not' | op= '-' ) )? postfixExpression )
            // EolParserRules.g:414:4: ( (op= 'not' | op= '-' ) )? postfixExpression
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            // EolParserRules.g:414:4: ( (op= 'not' | op= '-' ) )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==142||LA49_0==145) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // EolParserRules.g:414:5: (op= 'not' | op= '-' )
                    {
                    // EolParserRules.g:414:5: (op= 'not' | op= '-' )
                    int alt48=2;
                    int LA48_0 = input.LA(1);

                    if ( (LA48_0==145) ) {
                        alt48=1;
                    }
                    else if ( (LA48_0==142) ) {
                        alt48=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 48, 0, input);

                        throw nvae;
                    }
                    switch (alt48) {
                        case 1 :
                            // EolParserRules.g:414:6: op= 'not'
                            {
                            op=(Token)match(input,145,FOLLOW_145_in_unaryExpression1749); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
                            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
                            }

                            }
                            break;
                        case 2 :
                            // EolParserRules.g:414:16: op= '-'
                            {
                            op=(Token)match(input,142,FOLLOW_142_in_unaryExpression1754); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
                            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
                            }

                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {
                      op.setType(OPERATOR);
                    }

                    }
                    break;

            }

            pushFollow(FOLLOW_postfixExpression_in_unaryExpression1762);
            postfixExpression116=postfixExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, postfixExpression116.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end unaryExpression

    public static class postfixExpression_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start postfixExpression
    // EolParserRules.g:417:1: postfixExpression : itemSelectorExpression ( ( POINT | ARROW ) fc= featureCall (is= '[' logicalExpression ']' )* )* ;
    public final Egx_EolParserRules.postfixExpression_return postfixExpression() throws RecognitionException {
        Egx_EolParserRules.postfixExpression_return retval = new Egx_EolParserRules.postfixExpression_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token is=null;
        Token set118=null;
        Token char_literal120=null;
        Egx_EolParserRules.featureCall_return fc = null;

        Egx_EolParserRules.itemSelectorExpression_return itemSelectorExpression117 = null;

        Egx_EolParserRules.logicalExpression_return logicalExpression119 = null;


        org.eclipse.epsilon.common.parse.AST is_tree=null;
        org.eclipse.epsilon.common.parse.AST set118_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal120_tree=null;

        try {
            // EolParserRules.g:418:2: ( itemSelectorExpression ( ( POINT | ARROW ) fc= featureCall (is= '[' logicalExpression ']' )* )* )
            // EolParserRules.g:418:4: itemSelectorExpression ( ( POINT | ARROW ) fc= featureCall (is= '[' logicalExpression ']' )* )*
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            pushFollow(FOLLOW_itemSelectorExpression_in_postfixExpression1774);
            itemSelectorExpression117=itemSelectorExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, itemSelectorExpression117.getTree());
            // EolParserRules.g:418:27: ( ( POINT | ARROW ) fc= featureCall (is= '[' logicalExpression ']' )* )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==POINT||LA51_0==ARROW) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // EolParserRules.g:418:28: ( POINT | ARROW ) fc= featureCall (is= '[' logicalExpression ']' )*
            	    {
            	    set118=(Token)input.LT(1);
            	    set118=(Token)input.LT(1);
            	    if ( input.LA(1)==POINT||input.LA(1)==ARROW ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot((org.eclipse.epsilon.common.parse.AST)adaptor.create(set118), root_0);
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_featureCall_in_postfixExpression1786);
            	    fc=featureCall();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, fc.getTree());
            	    if ( state.backtracking==0 ) {
            	      setTokenType(fc,FEATURECALL);
            	    }
            	    // EolParserRules.g:419:35: (is= '[' logicalExpression ']' )*
            	    loop50:
            	    do {
            	        int alt50=2;
            	        int LA50_0 = input.LA(1);

            	        if ( (LA50_0==146) ) {
            	            alt50=1;
            	        }


            	        switch (alt50) {
            	    	case 1 :
            	    	    // EolParserRules.g:419:36: is= '[' logicalExpression ']'
            	    	    {
            	    	    is=(Token)match(input,146,FOLLOW_146_in_postfixExpression1795); if (state.failed) return retval;
            	    	    if ( state.backtracking==0 ) {
            	    	    is_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(is);
            	    	    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(is_tree, root_0);
            	    	    }
            	    	    pushFollow(FOLLOW_logicalExpression_in_postfixExpression1798);
            	    	    logicalExpression119=logicalExpression();

            	    	    state._fsp--;
            	    	    if (state.failed) return retval;
            	    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression119.getTree());
            	    	    char_literal120=(Token)match(input,147,FOLLOW_147_in_postfixExpression1800); if (state.failed) return retval;
            	    	    if ( state.backtracking==0 ) {
            	    	      is.setType(ITEMSELECTOR);
            	    	    }

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop50;
            	        }
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop51;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end postfixExpression

    public static class itemSelectorExpression_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start itemSelectorExpression
    // EolParserRules.g:423:1: itemSelectorExpression : primitiveExpression (is= '[' primitiveExpression ']' )* ;
    public final Egx_EolParserRules.itemSelectorExpression_return itemSelectorExpression() throws RecognitionException {
        Egx_EolParserRules.itemSelectorExpression_return retval = new Egx_EolParserRules.itemSelectorExpression_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token is=null;
        Token char_literal123=null;
        Egx_EolParserRules.primitiveExpression_return primitiveExpression121 = null;

        Egx_EolParserRules.primitiveExpression_return primitiveExpression122 = null;


        org.eclipse.epsilon.common.parse.AST is_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal123_tree=null;

        try {
            // EolParserRules.g:424:2: ( primitiveExpression (is= '[' primitiveExpression ']' )* )
            // EolParserRules.g:424:4: primitiveExpression (is= '[' primitiveExpression ']' )*
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            pushFollow(FOLLOW_primitiveExpression_in_itemSelectorExpression1822);
            primitiveExpression121=primitiveExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, primitiveExpression121.getTree());
            // EolParserRules.g:424:24: (is= '[' primitiveExpression ']' )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==146) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // EolParserRules.g:424:25: is= '[' primitiveExpression ']'
            	    {
            	    is=(Token)match(input,146,FOLLOW_146_in_itemSelectorExpression1827); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    is_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(is);
            	    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(is_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_primitiveExpression_in_itemSelectorExpression1830);
            	    primitiveExpression122=primitiveExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, primitiveExpression122.getTree());
            	    char_literal123=(Token)match(input,147,FOLLOW_147_in_itemSelectorExpression1832); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	      is.setType(ITEMSELECTOR);
            	    }

            	    }
            	    break;

            	default :
            	    break loop52;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end itemSelectorExpression

    public static class featureCall_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start featureCall
    // EolParserRules.g:428:1: featureCall : ( simpleFeatureCall | declarativeFeatureCall );
    public final Egx_EolParserRules.featureCall_return featureCall() throws RecognitionException {
        Egx_EolParserRules.featureCall_return retval = new Egx_EolParserRules.featureCall_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Egx_EolParserRules.simpleFeatureCall_return simpleFeatureCall124 = null;

        Egx_EolParserRules.declarativeFeatureCall_return declarativeFeatureCall125 = null;



        try {
            // EolParserRules.g:429:2: ( simpleFeatureCall | declarativeFeatureCall )
            int alt53=2;
            alt53 = dfa53.predict(input);
            switch (alt53) {
                case 1 :
                    // EolParserRules.g:429:4: simpleFeatureCall
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_simpleFeatureCall_in_featureCall1851);
                    simpleFeatureCall124=simpleFeatureCall();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, simpleFeatureCall124.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:429:24: declarativeFeatureCall
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_declarativeFeatureCall_in_featureCall1855);
                    declarativeFeatureCall125=declarativeFeatureCall();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, declarativeFeatureCall125.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end featureCall

    public static class simpleFeatureCall_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start simpleFeatureCall
    // EolParserRules.g:432:1: simpleFeatureCall : n= NAME ( parameterList )? ;
    public final Egx_EolParserRules.simpleFeatureCall_return simpleFeatureCall() throws RecognitionException {
        Egx_EolParserRules.simpleFeatureCall_return retval = new Egx_EolParserRules.simpleFeatureCall_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token n=null;
        Egx_EolParserRules.parameterList_return parameterList126 = null;


        org.eclipse.epsilon.common.parse.AST n_tree=null;

        try {
            // EolParserRules.g:433:2: (n= NAME ( parameterList )? )
            // EolParserRules.g:433:5: n= NAME ( parameterList )?
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            n=(Token)match(input,NAME,FOLLOW_NAME_in_simpleFeatureCall1869); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            n_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(n);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(n_tree, root_0);
            }
            // EolParserRules.g:433:13: ( parameterList )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==97) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // EolParserRules.g:0:0: parameterList
                    {
                    pushFollow(FOLLOW_parameterList_in_simpleFeatureCall1872);
                    parameterList126=parameterList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, parameterList126.getTree());

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              n.setType(FEATURECALL);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end simpleFeatureCall

    public static class parameterList_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start parameterList
    // EolParserRules.g:437:1: parameterList : op= '(' ( logicalExpression ( ',' logicalExpression )* )? cp= ')' -> ^( PARAMETERS ( logicalExpression )* ) ;
    public final Egx_EolParserRules.parameterList_return parameterList() throws RecognitionException {
        Egx_EolParserRules.parameterList_return retval = new Egx_EolParserRules.parameterList_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token op=null;
        Token cp=null;
        Token char_literal128=null;
        Egx_EolParserRules.logicalExpression_return logicalExpression127 = null;

        Egx_EolParserRules.logicalExpression_return logicalExpression129 = null;


        org.eclipse.epsilon.common.parse.AST op_tree=null;
        org.eclipse.epsilon.common.parse.AST cp_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal128_tree=null;
        RewriteRuleTokenStream stream_98=new RewriteRuleTokenStream(adaptor,"token 98");
        RewriteRuleTokenStream stream_97=new RewriteRuleTokenStream(adaptor,"token 97");
        RewriteRuleTokenStream stream_90=new RewriteRuleTokenStream(adaptor,"token 90");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:443:2: (op= '(' ( logicalExpression ( ',' logicalExpression )* )? cp= ')' -> ^( PARAMETERS ( logicalExpression )* ) )
            // EolParserRules.g:443:4: op= '(' ( logicalExpression ( ',' logicalExpression )* )? cp= ')'
            {
            op=(Token)match(input,97,FOLLOW_97_in_parameterList1895); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_97.add(op);

            // EolParserRules.g:443:11: ( logicalExpression ( ',' logicalExpression )* )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==FLOAT||LA56_0==INT||LA56_0==BOOLEAN||LA56_0==STRING||LA56_0==NAME||LA56_0==97||(LA56_0>=105 && LA56_0<=112)||LA56_0==142||LA56_0==145||(LA56_0>=149 && LA56_0<=151)) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // EolParserRules.g:443:12: logicalExpression ( ',' logicalExpression )*
                    {
                    pushFollow(FOLLOW_logicalExpression_in_parameterList1898);
                    logicalExpression127=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression127.getTree());
                    // EolParserRules.g:443:30: ( ',' logicalExpression )*
                    loop55:
                    do {
                        int alt55=2;
                        int LA55_0 = input.LA(1);

                        if ( (LA55_0==90) ) {
                            alt55=1;
                        }


                        switch (alt55) {
                    	case 1 :
                    	    // EolParserRules.g:443:31: ',' logicalExpression
                    	    {
                    	    char_literal128=(Token)match(input,90,FOLLOW_90_in_parameterList1901); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_90.add(char_literal128);

                    	    pushFollow(FOLLOW_logicalExpression_in_parameterList1903);
                    	    logicalExpression129=logicalExpression();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression129.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop55;
                        }
                    } while (true);


                    }
                    break;

            }

            cp=(Token)match(input,98,FOLLOW_98_in_parameterList1911); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_98.add(cp);



            // AST REWRITE
            // elements: logicalExpression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();
            // 444:3: -> ^( PARAMETERS ( logicalExpression )* )
            {
                // EolParserRules.g:444:6: ^( PARAMETERS ( logicalExpression )* )
                {
                org.eclipse.epsilon.common.parse.AST root_1 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();
                root_1 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot((org.eclipse.epsilon.common.parse.AST)adaptor.create(PARAMETERS, "PARAMETERS"), root_1);

                // EolParserRules.g:444:19: ( logicalExpression )*
                while ( stream_logicalExpression.hasNext() ) {
                    adaptor.addChild(root_1, stream_logicalExpression.nextTree());

                }
                stream_logicalExpression.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {
              
              		((org.eclipse.epsilon.common.parse.AST)retval.tree).setImaginary(true);
              		((org.eclipse.epsilon.common.parse.AST)retval.tree).getExtraTokens().add(op);
              		((org.eclipse.epsilon.common.parse.AST)retval.tree).getExtraTokens().add(cp);
              	
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end parameterList

    public static class declarativeFeatureCall_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start declarativeFeatureCall
    // EolParserRules.g:447:1: declarativeFeatureCall : NAME op= '(' formalParameterList '|' logicalExpression ( ',' logicalExpression )* cp= ')' ;
    public final Egx_EolParserRules.declarativeFeatureCall_return declarativeFeatureCall() throws RecognitionException {
        Egx_EolParserRules.declarativeFeatureCall_return retval = new Egx_EolParserRules.declarativeFeatureCall_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token op=null;
        Token cp=null;
        Token NAME130=null;
        Token char_literal132=null;
        Token char_literal134=null;
        Egx_EolParserRules.formalParameterList_return formalParameterList131 = null;

        Egx_EolParserRules.logicalExpression_return logicalExpression133 = null;

        Egx_EolParserRules.logicalExpression_return logicalExpression135 = null;


        org.eclipse.epsilon.common.parse.AST op_tree=null;
        org.eclipse.epsilon.common.parse.AST cp_tree=null;
        org.eclipse.epsilon.common.parse.AST NAME130_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal132_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal134_tree=null;

        try {
            // EolParserRules.g:452:2: ( NAME op= '(' formalParameterList '|' logicalExpression ( ',' logicalExpression )* cp= ')' )
            // EolParserRules.g:452:4: NAME op= '(' formalParameterList '|' logicalExpression ( ',' logicalExpression )* cp= ')'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            NAME130=(Token)match(input,NAME,FOLLOW_NAME_in_declarativeFeatureCall1939); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME130_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(NAME130);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(NAME130_tree, root_0);
            }
            op=(Token)match(input,97,FOLLOW_97_in_declarativeFeatureCall1944); if (state.failed) return retval;
            pushFollow(FOLLOW_formalParameterList_in_declarativeFeatureCall1947);
            formalParameterList131=formalParameterList();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, formalParameterList131.getTree());
            char_literal132=(Token)match(input,148,FOLLOW_148_in_declarativeFeatureCall1949); if (state.failed) return retval;
            pushFollow(FOLLOW_logicalExpression_in_declarativeFeatureCall1952);
            logicalExpression133=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression133.getTree());
            // EolParserRules.g:452:61: ( ',' logicalExpression )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==90) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // EolParserRules.g:452:62: ',' logicalExpression
            	    {
            	    char_literal134=(Token)match(input,90,FOLLOW_90_in_declarativeFeatureCall1955); if (state.failed) return retval;
            	    pushFollow(FOLLOW_logicalExpression_in_declarativeFeatureCall1958);
            	    logicalExpression135=logicalExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression135.getTree());

            	    }
            	    break;

            	default :
            	    break loop57;
                }
            } while (true);

            cp=(Token)match(input,98,FOLLOW_98_in_declarativeFeatureCall1964); if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {
              
              		((org.eclipse.epsilon.common.parse.AST)retval.tree).getExtraTokens().add(op);
              		((org.eclipse.epsilon.common.parse.AST)retval.tree).getExtraTokens().add(cp);
              	
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end declarativeFeatureCall

    public static class newExpression_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start newExpression
    // EolParserRules.g:455:1: newExpression : n= 'new' tn= typeName ( parameterList )? ;
    public final Egx_EolParserRules.newExpression_return newExpression() throws RecognitionException {
        Egx_EolParserRules.newExpression_return retval = new Egx_EolParserRules.newExpression_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token n=null;
        Egx_EolParserRules.typeName_return tn = null;

        Egx_EolParserRules.parameterList_return parameterList136 = null;


        org.eclipse.epsilon.common.parse.AST n_tree=null;

        try {
            // EolParserRules.g:456:2: (n= 'new' tn= typeName ( parameterList )? )
            // EolParserRules.g:456:4: n= 'new' tn= typeName ( parameterList )?
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            n=(Token)match(input,149,FOLLOW_149_in_newExpression1978); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            n_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(n);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(n_tree, root_0);
            }
            pushFollow(FOLLOW_typeName_in_newExpression1983);
            tn=typeName();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, tn.getTree());
            if ( state.backtracking==0 ) {
              setTokenType(tn,TYPE);
            }
            // EolParserRules.g:456:50: ( parameterList )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==97) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // EolParserRules.g:0:0: parameterList
                    {
                    pushFollow(FOLLOW_parameterList_in_newExpression1987);
                    parameterList136=parameterList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, parameterList136.getTree());

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              n.setType(NEW);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end newExpression

    public static class variableDeclarationExpression_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start variableDeclarationExpression
    // EolParserRules.g:460:1: variableDeclarationExpression : (v= 'var' | v= 'ext' ) NAME ( ':' (n= 'new' )? t= typeName ( parameterList )? )? ;
    public final Egx_EolParserRules.variableDeclarationExpression_return variableDeclarationExpression() throws RecognitionException {
        Egx_EolParserRules.variableDeclarationExpression_return retval = new Egx_EolParserRules.variableDeclarationExpression_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token v=null;
        Token n=null;
        Token NAME137=null;
        Token char_literal138=null;
        Egx_EolParserRules.typeName_return t = null;

        Egx_EolParserRules.parameterList_return parameterList139 = null;


        org.eclipse.epsilon.common.parse.AST v_tree=null;
        org.eclipse.epsilon.common.parse.AST n_tree=null;
        org.eclipse.epsilon.common.parse.AST NAME137_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal138_tree=null;

        try {
            // EolParserRules.g:468:2: ( (v= 'var' | v= 'ext' ) NAME ( ':' (n= 'new' )? t= typeName ( parameterList )? )? )
            // EolParserRules.g:468:4: (v= 'var' | v= 'ext' ) NAME ( ':' (n= 'new' )? t= typeName ( parameterList )? )?
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            // EolParserRules.g:468:4: (v= 'var' | v= 'ext' )
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==150) ) {
                alt59=1;
            }
            else if ( (LA59_0==151) ) {
                alt59=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;
            }
            switch (alt59) {
                case 1 :
                    // EolParserRules.g:468:5: v= 'var'
                    {
                    v=(Token)match(input,150,FOLLOW_150_in_variableDeclarationExpression2010); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    v_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(v);
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(v_tree, root_0);
                    }

                    }
                    break;
                case 2 :
                    // EolParserRules.g:468:14: v= 'ext'
                    {
                    v=(Token)match(input,151,FOLLOW_151_in_variableDeclarationExpression2015); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    v_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(v);
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(v_tree, root_0);
                    }

                    }
                    break;

            }

            NAME137=(Token)match(input,NAME,FOLLOW_NAME_in_variableDeclarationExpression2019); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME137_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(NAME137);
            adaptor.addChild(root_0, NAME137_tree);
            }
            // EolParserRules.g:468:29: ( ':' (n= 'new' )? t= typeName ( parameterList )? )?
            int alt62=2;
            alt62 = dfa62.predict(input);
            switch (alt62) {
                case 1 :
                    // EolParserRules.g:468:30: ':' (n= 'new' )? t= typeName ( parameterList )?
                    {
                    char_literal138=(Token)match(input,99,FOLLOW_99_in_variableDeclarationExpression2022); if (state.failed) return retval;
                    // EolParserRules.g:468:36: (n= 'new' )?
                    int alt60=2;
                    int LA60_0 = input.LA(1);

                    if ( (LA60_0==149) ) {
                        alt60=1;
                    }
                    switch (alt60) {
                        case 1 :
                            // EolParserRules.g:0:0: n= 'new'
                            {
                            n=(Token)match(input,149,FOLLOW_149_in_variableDeclarationExpression2027); if (state.failed) return retval;

                            }
                            break;

                    }

                    pushFollow(FOLLOW_typeName_in_variableDeclarationExpression2033);
                    t=typeName();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, t.getTree());
                    if ( state.backtracking==0 ) {
                      setTokenType(t, TYPE);
                    }
                    // EolParserRules.g:468:81: ( parameterList )?
                    int alt61=2;
                    int LA61_0 = input.LA(1);

                    if ( (LA61_0==97) ) {
                        alt61=1;
                    }
                    switch (alt61) {
                        case 1 :
                            // EolParserRules.g:0:0: parameterList
                            {
                            pushFollow(FOLLOW_parameterList_in_variableDeclarationExpression2037);
                            parameterList139=parameterList();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, parameterList139.getTree());

                            }
                            break;

                    }


                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {
              
              		String txt;
              		if (n != null) {txt = "new";}
              		else { txt = v.getText();}
              		((org.eclipse.epsilon.common.parse.AST)retval.tree).getToken().setText(txt);
              		((org.eclipse.epsilon.common.parse.AST)retval.tree).getToken().setType(VAR);
              	
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end variableDeclarationExpression

    public static class literalSequentialCollection_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start literalSequentialCollection
    // EolParserRules.g:471:1: literalSequentialCollection : (l= 'Collection' | l= 'Sequence' | l= 'List' | l= 'Bag' | l= 'Set' | l= 'OrderedSet' ) ob= '{' ( expressionListOrRange )? cb= '}' ;
    public final Egx_EolParserRules.literalSequentialCollection_return literalSequentialCollection() throws RecognitionException {
        Egx_EolParserRules.literalSequentialCollection_return retval = new Egx_EolParserRules.literalSequentialCollection_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token l=null;
        Token ob=null;
        Token cb=null;
        Egx_EolParserRules.expressionListOrRange_return expressionListOrRange140 = null;


        org.eclipse.epsilon.common.parse.AST l_tree=null;
        org.eclipse.epsilon.common.parse.AST ob_tree=null;
        org.eclipse.epsilon.common.parse.AST cb_tree=null;

        try {
            // EolParserRules.g:476:2: ( (l= 'Collection' | l= 'Sequence' | l= 'List' | l= 'Bag' | l= 'Set' | l= 'OrderedSet' ) ob= '{' ( expressionListOrRange )? cb= '}' )
            // EolParserRules.g:476:4: (l= 'Collection' | l= 'Sequence' | l= 'List' | l= 'Bag' | l= 'Set' | l= 'OrderedSet' ) ob= '{' ( expressionListOrRange )? cb= '}'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            // EolParserRules.g:476:4: (l= 'Collection' | l= 'Sequence' | l= 'List' | l= 'Bag' | l= 'Set' | l= 'OrderedSet' )
            int alt63=6;
            switch ( input.LA(1) ) {
            case 106:
                {
                alt63=1;
                }
                break;
            case 107:
                {
                alt63=2;
                }
                break;
            case 108:
                {
                alt63=3;
                }
                break;
            case 109:
                {
                alt63=4;
                }
                break;
            case 110:
                {
                alt63=5;
                }
                break;
            case 111:
                {
                alt63=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 63, 0, input);

                throw nvae;
            }

            switch (alt63) {
                case 1 :
                    // EolParserRules.g:476:5: l= 'Collection'
                    {
                    l=(Token)match(input,106,FOLLOW_106_in_literalSequentialCollection2061); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    l_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(l);
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(l_tree, root_0);
                    }

                    }
                    break;
                case 2 :
                    // EolParserRules.g:476:21: l= 'Sequence'
                    {
                    l=(Token)match(input,107,FOLLOW_107_in_literalSequentialCollection2066); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    l_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(l);
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(l_tree, root_0);
                    }

                    }
                    break;
                case 3 :
                    // EolParserRules.g:476:35: l= 'List'
                    {
                    l=(Token)match(input,108,FOLLOW_108_in_literalSequentialCollection2071); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    l_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(l);
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(l_tree, root_0);
                    }

                    }
                    break;
                case 4 :
                    // EolParserRules.g:476:45: l= 'Bag'
                    {
                    l=(Token)match(input,109,FOLLOW_109_in_literalSequentialCollection2076); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    l_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(l);
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(l_tree, root_0);
                    }

                    }
                    break;
                case 5 :
                    // EolParserRules.g:476:54: l= 'Set'
                    {
                    l=(Token)match(input,110,FOLLOW_110_in_literalSequentialCollection2081); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    l_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(l);
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(l_tree, root_0);
                    }

                    }
                    break;
                case 6 :
                    // EolParserRules.g:476:63: l= 'OrderedSet'
                    {
                    l=(Token)match(input,111,FOLLOW_111_in_literalSequentialCollection2086); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    l_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(l);
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(l_tree, root_0);
                    }

                    }
                    break;

            }

            ob=(Token)match(input,92,FOLLOW_92_in_literalSequentialCollection2092); if (state.failed) return retval;
            // EolParserRules.g:476:89: ( expressionListOrRange )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==FLOAT||LA64_0==INT||LA64_0==BOOLEAN||LA64_0==STRING||LA64_0==NAME||LA64_0==97||(LA64_0>=105 && LA64_0<=112)||LA64_0==142||LA64_0==145||(LA64_0>=149 && LA64_0<=151)) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // EolParserRules.g:0:0: expressionListOrRange
                    {
                    pushFollow(FOLLOW_expressionListOrRange_in_literalSequentialCollection2096);
                    expressionListOrRange140=expressionListOrRange();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionListOrRange140.getTree());

                    }
                    break;

            }

            cb=(Token)match(input,93,FOLLOW_93_in_literalSequentialCollection2101); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
              l.setType(COLLECTION);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {
              
              		((org.eclipse.epsilon.common.parse.AST)retval.tree).getExtraTokens().add(ob);
              		((org.eclipse.epsilon.common.parse.AST)retval.tree).getExtraTokens().add(cb);
              	
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end literalSequentialCollection

    public static class expressionRange_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start expressionRange
    // EolParserRules.g:480:1: expressionRange : logicalExpression exp= '..' logicalExpression ;
    public final Egx_EolParserRules.expressionRange_return expressionRange() throws RecognitionException {
        Egx_EolParserRules.expressionRange_return retval = new Egx_EolParserRules.expressionRange_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token exp=null;
        Egx_EolParserRules.logicalExpression_return logicalExpression141 = null;

        Egx_EolParserRules.logicalExpression_return logicalExpression142 = null;


        org.eclipse.epsilon.common.parse.AST exp_tree=null;

        try {
            // EolParserRules.g:481:2: ( logicalExpression exp= '..' logicalExpression )
            // EolParserRules.g:481:4: logicalExpression exp= '..' logicalExpression
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            pushFollow(FOLLOW_logicalExpression_in_expressionRange2116);
            logicalExpression141=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression141.getTree());
            exp=(Token)match(input,POINT_POINT,FOLLOW_POINT_POINT_in_expressionRange2120); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            exp_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(exp);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(exp_tree, root_0);
            }
            pushFollow(FOLLOW_logicalExpression_in_expressionRange2123);
            logicalExpression142=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression142.getTree());
            if ( state.backtracking==0 ) {
              exp.setType(EXPRRANGE);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end expressionRange

    public static class expressionList_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start expressionList
    // EolParserRules.g:485:1: expressionList : logicalExpression ( ',' logicalExpression )* -> ^( EXPRLIST ( logicalExpression )+ ) ;
    public final Egx_EolParserRules.expressionList_return expressionList() throws RecognitionException {
        Egx_EolParserRules.expressionList_return retval = new Egx_EolParserRules.expressionList_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token char_literal144=null;
        Egx_EolParserRules.logicalExpression_return logicalExpression143 = null;

        Egx_EolParserRules.logicalExpression_return logicalExpression145 = null;


        org.eclipse.epsilon.common.parse.AST char_literal144_tree=null;
        RewriteRuleTokenStream stream_90=new RewriteRuleTokenStream(adaptor,"token 90");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:489:2: ( logicalExpression ( ',' logicalExpression )* -> ^( EXPRLIST ( logicalExpression )+ ) )
            // EolParserRules.g:489:4: logicalExpression ( ',' logicalExpression )*
            {
            pushFollow(FOLLOW_logicalExpression_in_expressionList2144);
            logicalExpression143=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression143.getTree());
            // EolParserRules.g:489:22: ( ',' logicalExpression )*
            loop65:
            do {
                int alt65=2;
                int LA65_0 = input.LA(1);

                if ( (LA65_0==90) ) {
                    alt65=1;
                }


                switch (alt65) {
            	case 1 :
            	    // EolParserRules.g:489:23: ',' logicalExpression
            	    {
            	    char_literal144=(Token)match(input,90,FOLLOW_90_in_expressionList2147); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_90.add(char_literal144);

            	    pushFollow(FOLLOW_logicalExpression_in_expressionList2149);
            	    logicalExpression145=logicalExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression145.getTree());

            	    }
            	    break;

            	default :
            	    break loop65;
                }
            } while (true);



            // AST REWRITE
            // elements: logicalExpression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();
            // 490:2: -> ^( EXPRLIST ( logicalExpression )+ )
            {
                // EolParserRules.g:490:5: ^( EXPRLIST ( logicalExpression )+ )
                {
                org.eclipse.epsilon.common.parse.AST root_1 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();
                root_1 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot((org.eclipse.epsilon.common.parse.AST)adaptor.create(EXPRLIST, "EXPRLIST"), root_1);

                if ( !(stream_logicalExpression.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_logicalExpression.hasNext() ) {
                    adaptor.addChild(root_1, stream_logicalExpression.nextTree());

                }
                stream_logicalExpression.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {
              
              		((org.eclipse.epsilon.common.parse.AST)retval.tree).setImaginary(true);
              	
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end expressionList

    public static class expressionListOrRange_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start expressionListOrRange
    // EolParserRules.g:493:1: expressionListOrRange : ( expressionRange | expressionList );
    public final Egx_EolParserRules.expressionListOrRange_return expressionListOrRange() throws RecognitionException {
        Egx_EolParserRules.expressionListOrRange_return retval = new Egx_EolParserRules.expressionListOrRange_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Egx_EolParserRules.expressionRange_return expressionRange146 = null;

        Egx_EolParserRules.expressionList_return expressionList147 = null;



        try {
            // EolParserRules.g:494:2: ( expressionRange | expressionList )
            int alt66=2;
            alt66 = dfa66.predict(input);
            switch (alt66) {
                case 1 :
                    // EolParserRules.g:494:4: expressionRange
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_expressionRange_in_expressionListOrRange2173);
                    expressionRange146=expressionRange();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionRange146.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:494:22: expressionList
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_expressionList_in_expressionListOrRange2177);
                    expressionList147=expressionList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionList147.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end expressionListOrRange

    public static class literalMapCollection_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start literalMapCollection
    // EolParserRules.g:497:1: literalMapCollection : m= 'Map' ob= '{' ( keyvalExpressionList )? cb= '}' ;
    public final Egx_EolParserRules.literalMapCollection_return literalMapCollection() throws RecognitionException {
        Egx_EolParserRules.literalMapCollection_return retval = new Egx_EolParserRules.literalMapCollection_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token m=null;
        Token ob=null;
        Token cb=null;
        Egx_EolParserRules.keyvalExpressionList_return keyvalExpressionList148 = null;


        org.eclipse.epsilon.common.parse.AST m_tree=null;
        org.eclipse.epsilon.common.parse.AST ob_tree=null;
        org.eclipse.epsilon.common.parse.AST cb_tree=null;

        try {
            // EolParserRules.g:502:2: (m= 'Map' ob= '{' ( keyvalExpressionList )? cb= '}' )
            // EolParserRules.g:502:4: m= 'Map' ob= '{' ( keyvalExpressionList )? cb= '}'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            m=(Token)match(input,112,FOLLOW_112_in_literalMapCollection2196); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            m_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(m);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(m_tree, root_0);
            }
            ob=(Token)match(input,92,FOLLOW_92_in_literalMapCollection2201); if (state.failed) return retval;
            // EolParserRules.g:502:21: ( keyvalExpressionList )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==FLOAT||LA67_0==INT||LA67_0==BOOLEAN||LA67_0==STRING||LA67_0==NAME||LA67_0==97||(LA67_0>=105 && LA67_0<=112)||LA67_0==142||LA67_0==145||(LA67_0>=149 && LA67_0<=151)) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // EolParserRules.g:0:0: keyvalExpressionList
                    {
                    pushFollow(FOLLOW_keyvalExpressionList_in_literalMapCollection2204);
                    keyvalExpressionList148=keyvalExpressionList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, keyvalExpressionList148.getTree());

                    }
                    break;

            }

            cb=(Token)match(input,93,FOLLOW_93_in_literalMapCollection2209); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
              m.setType(MAP);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {
              
              		((org.eclipse.epsilon.common.parse.AST)retval.tree).getExtraTokens().add(ob);
              		((org.eclipse.epsilon.common.parse.AST)retval.tree).getExtraTokens().add(cb);
              	
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end literalMapCollection

    public static class keyvalExpressionList_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start keyvalExpressionList
    // EolParserRules.g:506:1: keyvalExpressionList : keyvalExpression ( ',' keyvalExpression )* -> ^( KEYVALLIST ( keyvalExpression )+ ) ;
    public final Egx_EolParserRules.keyvalExpressionList_return keyvalExpressionList() throws RecognitionException {
        Egx_EolParserRules.keyvalExpressionList_return retval = new Egx_EolParserRules.keyvalExpressionList_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token char_literal150=null;
        Egx_EolParserRules.keyvalExpression_return keyvalExpression149 = null;

        Egx_EolParserRules.keyvalExpression_return keyvalExpression151 = null;


        org.eclipse.epsilon.common.parse.AST char_literal150_tree=null;
        RewriteRuleTokenStream stream_90=new RewriteRuleTokenStream(adaptor,"token 90");
        RewriteRuleSubtreeStream stream_keyvalExpression=new RewriteRuleSubtreeStream(adaptor,"rule keyvalExpression");
        try {
            // EolParserRules.g:510:2: ( keyvalExpression ( ',' keyvalExpression )* -> ^( KEYVALLIST ( keyvalExpression )+ ) )
            // EolParserRules.g:510:4: keyvalExpression ( ',' keyvalExpression )*
            {
            pushFollow(FOLLOW_keyvalExpression_in_keyvalExpressionList2230);
            keyvalExpression149=keyvalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_keyvalExpression.add(keyvalExpression149.getTree());
            // EolParserRules.g:510:21: ( ',' keyvalExpression )*
            loop68:
            do {
                int alt68=2;
                int LA68_0 = input.LA(1);

                if ( (LA68_0==90) ) {
                    alt68=1;
                }


                switch (alt68) {
            	case 1 :
            	    // EolParserRules.g:510:22: ',' keyvalExpression
            	    {
            	    char_literal150=(Token)match(input,90,FOLLOW_90_in_keyvalExpressionList2233); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_90.add(char_literal150);

            	    pushFollow(FOLLOW_keyvalExpression_in_keyvalExpressionList2235);
            	    keyvalExpression151=keyvalExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_keyvalExpression.add(keyvalExpression151.getTree());

            	    }
            	    break;

            	default :
            	    break loop68;
                }
            } while (true);



            // AST REWRITE
            // elements: keyvalExpression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();
            // 511:2: -> ^( KEYVALLIST ( keyvalExpression )+ )
            {
                // EolParserRules.g:511:5: ^( KEYVALLIST ( keyvalExpression )+ )
                {
                org.eclipse.epsilon.common.parse.AST root_1 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();
                root_1 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot((org.eclipse.epsilon.common.parse.AST)adaptor.create(KEYVALLIST, "KEYVALLIST"), root_1);

                if ( !(stream_keyvalExpression.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_keyvalExpression.hasNext() ) {
                    adaptor.addChild(root_1, stream_keyvalExpression.nextTree());

                }
                stream_keyvalExpression.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {
              
              		((org.eclipse.epsilon.common.parse.AST)retval.tree).setImaginary(true);
              	
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end keyvalExpressionList

    public static class keyvalExpression_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start keyvalExpression
    // EolParserRules.g:514:1: keyvalExpression : additiveExpression eq= '=' logicalExpression ;
    public final Egx_EolParserRules.keyvalExpression_return keyvalExpression() throws RecognitionException {
        Egx_EolParserRules.keyvalExpression_return retval = new Egx_EolParserRules.keyvalExpression_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token eq=null;
        Egx_EolParserRules.additiveExpression_return additiveExpression152 = null;

        Egx_EolParserRules.logicalExpression_return logicalExpression153 = null;


        org.eclipse.epsilon.common.parse.AST eq_tree=null;

        try {
            // EolParserRules.g:516:2: ( additiveExpression eq= '=' logicalExpression )
            // EolParserRules.g:516:4: additiveExpression eq= '=' logicalExpression
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            pushFollow(FOLLOW_additiveExpression_in_keyvalExpression2260);
            additiveExpression152=additiveExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, additiveExpression152.getTree());
            eq=(Token)match(input,94,FOLLOW_94_in_keyvalExpression2264); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            eq_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(eq);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(eq_tree, root_0);
            }
            pushFollow(FOLLOW_logicalExpression_in_keyvalExpression2267);
            logicalExpression153=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression153.getTree());
            if ( state.backtracking==0 ) {
              eq.setType(KEYVAL);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end keyvalExpression

    public static class primitiveExpression_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start primitiveExpression
    // EolParserRules.g:519:1: primitiveExpression : ( literalSequentialCollection | literalMapCollection | literal | featureCall | pathName | nativeType | collectionType | logicalExpressionInBrackets | newExpression | variableDeclarationExpression );
    public final Egx_EolParserRules.primitiveExpression_return primitiveExpression() throws RecognitionException {
        Egx_EolParserRules.primitiveExpression_return retval = new Egx_EolParserRules.primitiveExpression_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Egx_EolParserRules.literalSequentialCollection_return literalSequentialCollection154 = null;

        Egx_EolParserRules.literalMapCollection_return literalMapCollection155 = null;

        Egx_EolParserRules.literal_return literal156 = null;

        Egx_EolParserRules.featureCall_return featureCall157 = null;

        Egx_EolParserRules.pathName_return pathName158 = null;

        Egx_EolParserRules.nativeType_return nativeType159 = null;

        Egx_EolParserRules.collectionType_return collectionType160 = null;

        Egx_EolParserRules.logicalExpressionInBrackets_return logicalExpressionInBrackets161 = null;

        Egx_EolParserRules.newExpression_return newExpression162 = null;

        Egx_EolParserRules.variableDeclarationExpression_return variableDeclarationExpression163 = null;



        try {
            // EolParserRules.g:520:2: ( literalSequentialCollection | literalMapCollection | literal | featureCall | pathName | nativeType | collectionType | logicalExpressionInBrackets | newExpression | variableDeclarationExpression )
            int alt69=10;
            alt69 = dfa69.predict(input);
            switch (alt69) {
                case 1 :
                    // EolParserRules.g:520:4: literalSequentialCollection
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_literalSequentialCollection_in_primitiveExpression2281);
                    literalSequentialCollection154=literalSequentialCollection();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, literalSequentialCollection154.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:520:34: literalMapCollection
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_literalMapCollection_in_primitiveExpression2285);
                    literalMapCollection155=literalMapCollection();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, literalMapCollection155.getTree());

                    }
                    break;
                case 3 :
                    // EolParserRules.g:520:57: literal
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_literal_in_primitiveExpression2289);
                    literal156=literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, literal156.getTree());

                    }
                    break;
                case 4 :
                    // EolParserRules.g:520:67: featureCall
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_featureCall_in_primitiveExpression2293);
                    featureCall157=featureCall();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, featureCall157.getTree());

                    }
                    break;
                case 5 :
                    // EolParserRules.g:520:81: pathName
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_pathName_in_primitiveExpression2297);
                    pathName158=pathName();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pathName158.getTree());

                    }
                    break;
                case 6 :
                    // EolParserRules.g:520:92: nativeType
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_nativeType_in_primitiveExpression2301);
                    nativeType159=nativeType();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nativeType159.getTree());

                    }
                    break;
                case 7 :
                    // EolParserRules.g:521:5: collectionType
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_collectionType_in_primitiveExpression2307);
                    collectionType160=collectionType();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, collectionType160.getTree());

                    }
                    break;
                case 8 :
                    // EolParserRules.g:521:23: logicalExpressionInBrackets
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_logicalExpressionInBrackets_in_primitiveExpression2312);
                    logicalExpressionInBrackets161=logicalExpressionInBrackets();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpressionInBrackets161.getTree());

                    }
                    break;
                case 9 :
                    // EolParserRules.g:522:5: newExpression
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_newExpression_in_primitiveExpression2318);
                    newExpression162=newExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, newExpression162.getTree());

                    }
                    break;
                case 10 :
                    // EolParserRules.g:522:21: variableDeclarationExpression
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_variableDeclarationExpression_in_primitiveExpression2322);
                    variableDeclarationExpression163=variableDeclarationExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, variableDeclarationExpression163.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end primitiveExpression

    public static class logicalExpressionInBrackets_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start logicalExpressionInBrackets
    // EolParserRules.g:525:1: logicalExpressionInBrackets : ob= '(' logicalExpression cb= ')' ;
    public final Egx_EolParserRules.logicalExpressionInBrackets_return logicalExpressionInBrackets() throws RecognitionException {
        Egx_EolParserRules.logicalExpressionInBrackets_return retval = new Egx_EolParserRules.logicalExpressionInBrackets_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token ob=null;
        Token cb=null;
        Egx_EolParserRules.logicalExpression_return logicalExpression164 = null;


        org.eclipse.epsilon.common.parse.AST ob_tree=null;
        org.eclipse.epsilon.common.parse.AST cb_tree=null;

        try {
            // EolParserRules.g:531:2: (ob= '(' logicalExpression cb= ')' )
            // EolParserRules.g:531:4: ob= '(' logicalExpression cb= ')'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            ob=(Token)match(input,97,FOLLOW_97_in_logicalExpressionInBrackets2341); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ob_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(ob);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(ob_tree, root_0);
            }
            pushFollow(FOLLOW_logicalExpression_in_logicalExpressionInBrackets2344);
            logicalExpression164=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression164.getTree());
            cb=(Token)match(input,98,FOLLOW_98_in_logicalExpressionInBrackets2348); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
              ob.setType(EXPRESSIONINBRACKETS);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {
              
              		((org.eclipse.epsilon.common.parse.AST)retval.tree).getExtraTokens().add(ob);
              		((org.eclipse.epsilon.common.parse.AST)retval.tree).getExtraTokens().add(cb);
              		((org.eclipse.epsilon.common.parse.AST)retval.tree).setImaginary(true);
              	
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end logicalExpressionInBrackets

    public static class literal_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start literal
    // EolParserRules.g:535:1: literal : ( STRING | INT | FLOAT | BOOLEAN );
    public final Egx_EolParserRules.literal_return literal() throws RecognitionException {
        Egx_EolParserRules.literal_return retval = new Egx_EolParserRules.literal_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token set165=null;

        org.eclipse.epsilon.common.parse.AST set165_tree=null;

        try {
            // EolParserRules.g:536:2: ( STRING | INT | FLOAT | BOOLEAN )
            // EolParserRules.g:
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            set165=(Token)input.LT(1);
            if ( input.LA(1)==FLOAT||input.LA(1)==INT||input.LA(1)==BOOLEAN||input.LA(1)==STRING ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (org.eclipse.epsilon.common.parse.AST)adaptor.create(set165));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end literal

    // $ANTLR start synpred16_EolParserRules
    public final void synpred16_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:201:4: ( annotation )
        // EolParserRules.g:201:4: annotation
        {
        pushFollow(FOLLOW_annotation_in_synpred16_EolParserRules669);
        annotation();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred16_EolParserRules

    // $ANTLR start synpred29_EolParserRules
    public final void synpred29_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:254:4: ( '(' typeName ( ',' typeName )* ')' )
        // EolParserRules.g:254:4: '(' typeName ( ',' typeName )* ')'
        {
        match(input,97,FOLLOW_97_in_synpred29_EolParserRules851); if (state.failed) return ;
        pushFollow(FOLLOW_typeName_in_synpred29_EolParserRules856);
        typeName();

        state._fsp--;
        if (state.failed) return ;
        // EolParserRules.g:254:49: ( ',' typeName )*
        loop70:
        do {
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==90) ) {
                alt70=1;
            }


            switch (alt70) {
        	case 1 :
        	    // EolParserRules.g:254:50: ',' typeName
        	    {
        	    match(input,90,FOLLOW_90_in_synpred29_EolParserRules861); if (state.failed) return ;
        	    pushFollow(FOLLOW_typeName_in_synpred29_EolParserRules865);
        	    typeName();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop70;
            }
        } while (true);

        match(input,98,FOLLOW_98_in_synpred29_EolParserRules873); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred29_EolParserRules

    // $ANTLR start synpred30_EolParserRules
    public final void synpred30_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:258:4: ( statementA )
        // EolParserRules.g:258:4: statementA
        {
        pushFollow(FOLLOW_statementA_in_synpred30_EolParserRules888);
        statementA();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred30_EolParserRules

    // $ANTLR start synpred31_EolParserRules
    public final void synpred31_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:262:4: ( assignmentStatement )
        // EolParserRules.g:262:4: assignmentStatement
        {
        pushFollow(FOLLOW_assignmentStatement_in_synpred31_EolParserRules903);
        assignmentStatement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred31_EolParserRules

    // $ANTLR start synpred32_EolParserRules
    public final void synpred32_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:262:26: ( expressionStatement )
        // EolParserRules.g:262:26: expressionStatement
        {
        pushFollow(FOLLOW_expressionStatement_in_synpred32_EolParserRules907);
        expressionStatement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred32_EolParserRules

    // $ANTLR start synpred46_EolParserRules
    public final void synpred46_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:285:66: ( elseStatement )
        // EolParserRules.g:285:66: elseStatement
        {
        pushFollow(FOLLOW_elseStatement_in_synpred46_EolParserRules1062);
        elseStatement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred46_EolParserRules

    // $ANTLR start synpred55_EolParserRules
    public final void synpred55_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:373:22: ( NAME ( ',' NAME )* )
        // EolParserRules.g:373:22: NAME ( ',' NAME )*
        {
        match(input,NAME,FOLLOW_NAME_in_synpred55_EolParserRules1443); if (state.failed) return ;
        // EolParserRules.g:373:27: ( ',' NAME )*
        loop71:
        do {
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==90) ) {
                alt71=1;
            }


            switch (alt71) {
        	case 1 :
        	    // EolParserRules.g:373:28: ',' NAME
        	    {
        	    match(input,90,FOLLOW_90_in_synpred55_EolParserRules1446); if (state.failed) return ;
        	    match(input,NAME,FOLLOW_NAME_in_synpred55_EolParserRules1448); if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop71;
            }
        } while (true);


        }
    }
    // $ANTLR end synpred55_EolParserRules

    // $ANTLR start synpred57_EolParserRules
    public final void synpred57_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:389:5: ( postfixExpression '=' logicalExpression )
        // EolParserRules.g:389:5: postfixExpression '=' logicalExpression
        {
        pushFollow(FOLLOW_postfixExpression_in_synpred57_EolParserRules1518);
        postfixExpression();

        state._fsp--;
        if (state.failed) return ;
        match(input,94,FOLLOW_94_in_synpred57_EolParserRules1522); if (state.failed) return ;
        pushFollow(FOLLOW_logicalExpression_in_synpred57_EolParserRules1525);
        logicalExpression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred57_EolParserRules

    // $ANTLR start synpred68_EolParserRules
    public final void synpred68_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:398:24: ( ( '==' relationalExpression | '=' relationalExpression | ( '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression ) )
        // EolParserRules.g:398:24: ( '==' relationalExpression | '=' relationalExpression | ( '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression )
        {
        // EolParserRules.g:398:24: ( '==' relationalExpression | '=' relationalExpression | ( '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression )
        int alt72=3;
        switch ( input.LA(1) ) {
        case 135:
            {
            alt72=1;
            }
            break;
        case 94:
            {
            alt72=2;
            }
            break;
        case 136:
        case 137:
        case 138:
        case 139:
        case 140:
            {
            alt72=3;
            }
            break;
        default:
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 72, 0, input);

            throw nvae;
        }

        switch (alt72) {
            case 1 :
                // EolParserRules.g:398:25: '==' relationalExpression
                {
                match(input,135,FOLLOW_135_in_synpred68_EolParserRules1596); if (state.failed) return ;
                pushFollow(FOLLOW_relationalExpression_in_synpred68_EolParserRules1599);
                relationalExpression();

                state._fsp--;
                if (state.failed) return ;

                }
                break;
            case 2 :
                // EolParserRules.g:398:57: '=' relationalExpression
                {
                match(input,94,FOLLOW_94_in_synpred68_EolParserRules1605); if (state.failed) return ;
                pushFollow(FOLLOW_relationalExpression_in_synpred68_EolParserRules1608);
                relationalExpression();

                state._fsp--;
                if (state.failed) return ;

                }
                break;
            case 3 :
                // EolParserRules.g:399:24: ( '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression
                {
                if ( (input.LA(1)>=136 && input.LA(1)<=140) ) {
                    input.consume();
                    state.errorRecovery=false;state.failed=false;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    MismatchedSetException mse = new MismatchedSetException(null,input);
                    throw mse;
                }

                pushFollow(FOLLOW_additiveExpression_in_synpred68_EolParserRules1662);
                additiveExpression();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        }
    }
    // $ANTLR end synpred68_EolParserRules

    // $ANTLR start synpred88_EolParserRules
    public final void synpred88_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:468:30: ( ':' ( 'new' )? typeName ( parameterList )? )
        // EolParserRules.g:468:30: ':' ( 'new' )? typeName ( parameterList )?
        {
        match(input,99,FOLLOW_99_in_synpred88_EolParserRules2022); if (state.failed) return ;
        // EolParserRules.g:468:36: ( 'new' )?
        int alt75=2;
        int LA75_0 = input.LA(1);

        if ( (LA75_0==149) ) {
            alt75=1;
        }
        switch (alt75) {
            case 1 :
                // EolParserRules.g:0:0: 'new'
                {
                match(input,149,FOLLOW_149_in_synpred88_EolParserRules2027); if (state.failed) return ;

                }
                break;

        }

        pushFollow(FOLLOW_typeName_in_synpred88_EolParserRules2033);
        typeName();

        state._fsp--;
        if (state.failed) return ;
        // EolParserRules.g:468:81: ( parameterList )?
        int alt76=2;
        int LA76_0 = input.LA(1);

        if ( (LA76_0==97) ) {
            alt76=1;
        }
        switch (alt76) {
            case 1 :
                // EolParserRules.g:0:0: parameterList
                {
                pushFollow(FOLLOW_parameterList_in_synpred88_EolParserRules2037);
                parameterList();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        }
    }
    // $ANTLR end synpred88_EolParserRules

    // $ANTLR start synpred96_EolParserRules
    public final void synpred96_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:494:4: ( expressionRange )
        // EolParserRules.g:494:4: expressionRange
        {
        pushFollow(FOLLOW_expressionRange_in_synpred96_EolParserRules2173);
        expressionRange();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred96_EolParserRules

    // $ANTLR start synpred102_EolParserRules
    public final void synpred102_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:520:67: ( featureCall )
        // EolParserRules.g:520:67: featureCall
        {
        pushFollow(FOLLOW_featureCall_in_synpred102_EolParserRules2293);
        featureCall();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred102_EolParserRules

    // $ANTLR start synpred103_EolParserRules
    public final void synpred103_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:520:81: ( pathName )
        // EolParserRules.g:520:81: pathName
        {
        pushFollow(FOLLOW_pathName_in_synpred103_EolParserRules2297);
        pathName();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred103_EolParserRules

    // Delegated rules

    public final boolean synpred31_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred31_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred57_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred57_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred16_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred16_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred96_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred96_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred55_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred55_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred29_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred29_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred88_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred88_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred68_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred68_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred30_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred30_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred103_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred103_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred32_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred32_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred102_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred102_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred46_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred46_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA21 dfa21 = new DFA21(this);
    protected DFA22 dfa22 = new DFA22(this);
    protected DFA23 dfa23 = new DFA23(this);
    protected DFA36 dfa36 = new DFA36(this);
    protected DFA38 dfa38 = new DFA38(this);
    protected DFA43 dfa43 = new DFA43(this);
    protected DFA53 dfa53 = new DFA53(this);
    protected DFA62 dfa62 = new DFA62(this);
    protected DFA66 dfa66 = new DFA66(this);
    protected DFA69 dfa69 = new DFA69(this);
    static final String DFA21_eotS =
        "\56\uffff";
    static final String DFA21_eofS =
        "\1\2\55\uffff";
    static final String DFA21_minS =
        "\1\11\1\0\54\uffff";
    static final String DFA21_maxS =
        "\1\u00a2\1\0\54\uffff";
    static final String DFA21_acceptS =
        "\2\uffff\1\2\52\uffff\1\1";
    static final String DFA21_specialS =
        "\1\uffff\1\0\54\uffff}>";
    static final String[] DFA21_transitionS = {
            "\3\2\7\uffff\1\2\3\uffff\1\2\100\uffff\1\2\1\uffff\1\2\1\uffff"+
            "\5\2\1\1\2\2\1\uffff\1\2\14\uffff\1\2\16\uffff\20\2\1\uffff"+
            "\3\2\3\uffff\3\2\1\uffff\1\2\1\uffff\5\2",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA21_eot = DFA.unpackEncodedString(DFA21_eotS);
    static final short[] DFA21_eof = DFA.unpackEncodedString(DFA21_eofS);
    static final char[] DFA21_min = DFA.unpackEncodedStringToUnsignedChars(DFA21_minS);
    static final char[] DFA21_max = DFA.unpackEncodedStringToUnsignedChars(DFA21_maxS);
    static final short[] DFA21_accept = DFA.unpackEncodedString(DFA21_acceptS);
    static final short[] DFA21_special = DFA.unpackEncodedString(DFA21_specialS);
    static final short[][] DFA21_transition;

    static {
        int numStates = DFA21_transitionS.length;
        DFA21_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA21_transition[i] = DFA.unpackEncodedString(DFA21_transitionS[i]);
        }
    }

    class DFA21 extends DFA {

        public DFA21(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 21;
            this.eot = DFA21_eot;
            this.eof = DFA21_eof;
            this.min = DFA21_min;
            this.max = DFA21_max;
            this.accept = DFA21_accept;
            this.special = DFA21_special;
            this.transition = DFA21_transition;
        }
        public String getDescription() {
            return "254:3: (op= '(' tn= typeName ( ',' tn= typeName )* cp= ')' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA21_1 = input.LA(1);

                         
                        int index21_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_EolParserRules()) ) {s = 45;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index21_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 21, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA22_eotS =
        "\35\uffff";
    static final String DFA22_eofS =
        "\35\uffff";
    static final String DFA22_minS =
        "\1\4\24\uffff\1\0\7\uffff";
    static final String DFA22_maxS =
        "\1\u0097\24\uffff\1\0\7\uffff";
    static final String DFA22_acceptS =
        "\1\uffff\1\1\25\uffff\1\2\5\uffff";
    static final String DFA22_specialS =
        "\25\uffff\1\0\7\uffff}>";
    static final String[] DFA22_transitionS = {
            "\1\1\3\uffff\1\1\3\uffff\1\1\1\uffff\1\1\4\uffff\1\1\115\uffff"+
            "\1\1\7\uffff\11\1\1\uffff\2\1\3\uffff\1\1\1\25\2\27\1\1\4\27"+
            "\15\uffff\1\1\2\uffff\1\1\3\uffff\3\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA22_eot = DFA.unpackEncodedString(DFA22_eotS);
    static final short[] DFA22_eof = DFA.unpackEncodedString(DFA22_eofS);
    static final char[] DFA22_min = DFA.unpackEncodedStringToUnsignedChars(DFA22_minS);
    static final char[] DFA22_max = DFA.unpackEncodedStringToUnsignedChars(DFA22_maxS);
    static final short[] DFA22_accept = DFA.unpackEncodedString(DFA22_acceptS);
    static final short[] DFA22_special = DFA.unpackEncodedString(DFA22_specialS);
    static final short[][] DFA22_transition;

    static {
        int numStates = DFA22_transitionS.length;
        DFA22_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA22_transition[i] = DFA.unpackEncodedString(DFA22_transitionS[i]);
        }
    }

    class DFA22 extends DFA {

        public DFA22(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 22;
            this.eot = DFA22_eot;
            this.eof = DFA22_eof;
            this.min = DFA22_min;
            this.max = DFA22_max;
            this.accept = DFA22_accept;
            this.special = DFA22_special;
            this.transition = DFA22_transition;
        }
        public String getDescription() {
            return "257:1: statement : ( statementA | statementB );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA22_21 = input.LA(1);

                         
                        int index22_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_EolParserRules()) ) {s = 1;}

                        else if ( (true) ) {s = 23;}

                         
                        input.seek(index22_21);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 22, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA23_eotS =
        "\31\uffff";
    static final String DFA23_eofS =
        "\31\uffff";
    static final String DFA23_minS =
        "\1\4\20\0\10\uffff";
    static final String DFA23_maxS =
        "\1\u0097\20\0\10\uffff";
    static final String DFA23_acceptS =
        "\21\uffff\1\3\1\4\1\5\1\6\1\7\1\10\1\1\1\2";
    static final String DFA23_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14"+
        "\1\15\1\16\1\17\10\uffff}>";
    static final String[] DFA23_transitionS = {
            "\1\12\3\uffff\1\12\3\uffff\1\12\1\uffff\1\12\4\uffff\1\13\115"+
            "\uffff\1\15\7\uffff\1\14\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\21"+
            "\1\uffff\1\22\1\24\3\uffff\1\23\1\25\2\uffff\1\26\21\uffff\1"+
            "\2\2\uffff\1\1\3\uffff\1\16\1\17\1\20",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA23_eot = DFA.unpackEncodedString(DFA23_eotS);
    static final short[] DFA23_eof = DFA.unpackEncodedString(DFA23_eofS);
    static final char[] DFA23_min = DFA.unpackEncodedStringToUnsignedChars(DFA23_minS);
    static final char[] DFA23_max = DFA.unpackEncodedStringToUnsignedChars(DFA23_maxS);
    static final short[] DFA23_accept = DFA.unpackEncodedString(DFA23_acceptS);
    static final short[] DFA23_special = DFA.unpackEncodedString(DFA23_specialS);
    static final short[][] DFA23_transition;

    static {
        int numStates = DFA23_transitionS.length;
        DFA23_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA23_transition[i] = DFA.unpackEncodedString(DFA23_transitionS[i]);
        }
    }

    class DFA23 extends DFA {

        public DFA23(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 23;
            this.eot = DFA23_eot;
            this.eof = DFA23_eof;
            this.min = DFA23_min;
            this.max = DFA23_max;
            this.accept = DFA23_accept;
            this.special = DFA23_special;
            this.transition = DFA23_transition;
        }
        public String getDescription() {
            return "261:1: statementA : ( assignmentStatement | expressionStatement | forStatement | ifStatement | whileStatement | switchStatement | returnStatement | breakStatement );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA23_1 = input.LA(1);

                         
                        int index23_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_EolParserRules()) ) {s = 23;}

                        else if ( (synpred32_EolParserRules()) ) {s = 24;}

                         
                        input.seek(index23_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA23_2 = input.LA(1);

                         
                        int index23_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_EolParserRules()) ) {s = 23;}

                        else if ( (synpred32_EolParserRules()) ) {s = 24;}

                         
                        input.seek(index23_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA23_3 = input.LA(1);

                         
                        int index23_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_EolParserRules()) ) {s = 23;}

                        else if ( (synpred32_EolParserRules()) ) {s = 24;}

                         
                        input.seek(index23_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA23_4 = input.LA(1);

                         
                        int index23_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_EolParserRules()) ) {s = 23;}

                        else if ( (synpred32_EolParserRules()) ) {s = 24;}

                         
                        input.seek(index23_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA23_5 = input.LA(1);

                         
                        int index23_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_EolParserRules()) ) {s = 23;}

                        else if ( (synpred32_EolParserRules()) ) {s = 24;}

                         
                        input.seek(index23_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA23_6 = input.LA(1);

                         
                        int index23_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_EolParserRules()) ) {s = 23;}

                        else if ( (synpred32_EolParserRules()) ) {s = 24;}

                         
                        input.seek(index23_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA23_7 = input.LA(1);

                         
                        int index23_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_EolParserRules()) ) {s = 23;}

                        else if ( (synpred32_EolParserRules()) ) {s = 24;}

                         
                        input.seek(index23_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA23_8 = input.LA(1);

                         
                        int index23_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_EolParserRules()) ) {s = 23;}

                        else if ( (synpred32_EolParserRules()) ) {s = 24;}

                         
                        input.seek(index23_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA23_9 = input.LA(1);

                         
                        int index23_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_EolParserRules()) ) {s = 23;}

                        else if ( (synpred32_EolParserRules()) ) {s = 24;}

                         
                        input.seek(index23_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA23_10 = input.LA(1);

                         
                        int index23_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_EolParserRules()) ) {s = 23;}

                        else if ( (synpred32_EolParserRules()) ) {s = 24;}

                         
                        input.seek(index23_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA23_11 = input.LA(1);

                         
                        int index23_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_EolParserRules()) ) {s = 23;}

                        else if ( (synpred32_EolParserRules()) ) {s = 24;}

                         
                        input.seek(index23_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA23_12 = input.LA(1);

                         
                        int index23_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_EolParserRules()) ) {s = 23;}

                        else if ( (synpred32_EolParserRules()) ) {s = 24;}

                         
                        input.seek(index23_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA23_13 = input.LA(1);

                         
                        int index23_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_EolParserRules()) ) {s = 23;}

                        else if ( (synpred32_EolParserRules()) ) {s = 24;}

                         
                        input.seek(index23_13);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA23_14 = input.LA(1);

                         
                        int index23_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_EolParserRules()) ) {s = 23;}

                        else if ( (synpred32_EolParserRules()) ) {s = 24;}

                         
                        input.seek(index23_14);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA23_15 = input.LA(1);

                         
                        int index23_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_EolParserRules()) ) {s = 23;}

                        else if ( (synpred32_EolParserRules()) ) {s = 24;}

                         
                        input.seek(index23_15);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA23_16 = input.LA(1);

                         
                        int index23_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_EolParserRules()) ) {s = 23;}

                        else if ( (synpred32_EolParserRules()) ) {s = 24;}

                         
                        input.seek(index23_16);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 23, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA36_eotS =
        "\37\uffff";
    static final String DFA36_eofS =
        "\37\uffff";
    static final String DFA36_minS =
        "\1\4\1\0\35\uffff";
    static final String DFA36_maxS =
        "\1\u0097\1\0\35\uffff";
    static final String DFA36_acceptS =
        "\2\uffff\1\2\33\uffff\1\1";
    static final String DFA36_specialS =
        "\1\uffff\1\0\35\uffff}>";
    static final String[] DFA36_transitionS = {
            "\1\2\3\uffff\1\2\3\uffff\1\2\1\uffff\1\2\4\uffff\1\1\110\uffff"+
            "\1\2\4\uffff\1\2\7\uffff\11\2\1\uffff\2\2\3\uffff\11\2\15\uffff"+
            "\1\2\2\uffff\1\2\3\uffff\3\2",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA36_eot = DFA.unpackEncodedString(DFA36_eotS);
    static final short[] DFA36_eof = DFA.unpackEncodedString(DFA36_eofS);
    static final char[] DFA36_min = DFA.unpackEncodedStringToUnsignedChars(DFA36_minS);
    static final char[] DFA36_max = DFA.unpackEncodedStringToUnsignedChars(DFA36_maxS);
    static final short[] DFA36_accept = DFA.unpackEncodedString(DFA36_acceptS);
    static final short[] DFA36_special = DFA.unpackEncodedString(DFA36_specialS);
    static final short[][] DFA36_transition;

    static {
        int numStates = DFA36_transitionS.length;
        DFA36_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA36_transition[i] = DFA.unpackEncodedString(DFA36_transitionS[i]);
        }
    }

    class DFA36 extends DFA {

        public DFA36(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 36;
            this.eot = DFA36_eot;
            this.eof = DFA36_eof;
            this.min = DFA36_min;
            this.max = DFA36_max;
            this.accept = DFA36_accept;
            this.special = DFA36_special;
            this.transition = DFA36_transition;
        }
        public String getDescription() {
            return "373:21: ( NAME ( ',' NAME )* )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA36_1 = input.LA(1);

                         
                        int index36_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred55_EolParserRules()) ) {s = 30;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index36_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 36, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA38_eotS =
        "\22\uffff";
    static final String DFA38_eofS =
        "\22\uffff";
    static final String DFA38_minS =
        "\1\4\16\0\3\uffff";
    static final String DFA38_maxS =
        "\1\u0097\16\0\3\uffff";
    static final String DFA38_acceptS =
        "\17\uffff\1\2\1\uffff\1\1";
    static final String DFA38_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14"+
        "\1\15\3\uffff}>";
    static final String[] DFA38_transitionS = {
            "\1\10\3\uffff\1\10\3\uffff\1\10\1\uffff\1\10\4\uffff\1\11\115"+
            "\uffff\1\13\7\uffff\1\12\1\1\1\2\1\3\1\4\1\5\1\6\1\7\35\uffff"+
            "\1\17\2\uffff\1\17\3\uffff\1\14\1\15\1\16",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            ""
    };

    static final short[] DFA38_eot = DFA.unpackEncodedString(DFA38_eotS);
    static final short[] DFA38_eof = DFA.unpackEncodedString(DFA38_eofS);
    static final char[] DFA38_min = DFA.unpackEncodedStringToUnsignedChars(DFA38_minS);
    static final char[] DFA38_max = DFA.unpackEncodedStringToUnsignedChars(DFA38_maxS);
    static final short[] DFA38_accept = DFA.unpackEncodedString(DFA38_acceptS);
    static final short[] DFA38_special = DFA.unpackEncodedString(DFA38_specialS);
    static final short[][] DFA38_transition;

    static {
        int numStates = DFA38_transitionS.length;
        DFA38_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA38_transition[i] = DFA.unpackEncodedString(DFA38_transitionS[i]);
        }
    }

    class DFA38 extends DFA {

        public DFA38(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 38;
            this.eot = DFA38_eot;
            this.eof = DFA38_eof;
            this.min = DFA38_min;
            this.max = DFA38_max;
            this.accept = DFA38_accept;
            this.special = DFA38_special;
            this.transition = DFA38_transition;
        }
        public String getDescription() {
            return "389:4: ( postfixExpression op= '=' logicalExpression | logicalExpression )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA38_1 = input.LA(1);

                         
                        int index38_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_EolParserRules()) ) {s = 17;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index38_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA38_2 = input.LA(1);

                         
                        int index38_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_EolParserRules()) ) {s = 17;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index38_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA38_3 = input.LA(1);

                         
                        int index38_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_EolParserRules()) ) {s = 17;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index38_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA38_4 = input.LA(1);

                         
                        int index38_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_EolParserRules()) ) {s = 17;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index38_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA38_5 = input.LA(1);

                         
                        int index38_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_EolParserRules()) ) {s = 17;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index38_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA38_6 = input.LA(1);

                         
                        int index38_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_EolParserRules()) ) {s = 17;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index38_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA38_7 = input.LA(1);

                         
                        int index38_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_EolParserRules()) ) {s = 17;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index38_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA38_8 = input.LA(1);

                         
                        int index38_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_EolParserRules()) ) {s = 17;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index38_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA38_9 = input.LA(1);

                         
                        int index38_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_EolParserRules()) ) {s = 17;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index38_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA38_10 = input.LA(1);

                         
                        int index38_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_EolParserRules()) ) {s = 17;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index38_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA38_11 = input.LA(1);

                         
                        int index38_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_EolParserRules()) ) {s = 17;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index38_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA38_12 = input.LA(1);

                         
                        int index38_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_EolParserRules()) ) {s = 17;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index38_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA38_13 = input.LA(1);

                         
                        int index38_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_EolParserRules()) ) {s = 17;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index38_13);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA38_14 = input.LA(1);

                         
                        int index38_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_EolParserRules()) ) {s = 17;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index38_14);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 38, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA43_eotS =
        "\12\uffff";
    static final String DFA43_eofS =
        "\1\1\11\uffff";
    static final String DFA43_minS =
        "\1\12\1\uffff\7\0\1\uffff";
    static final String DFA43_maxS =
        "\1\u00a2\1\uffff\7\0\1\uffff";
    static final String DFA43_acceptS =
        "\1\uffff\1\2\7\uffff\1\1";
    static final String DFA43_specialS =
        "\2\uffff\1\0\1\4\1\6\1\2\1\5\1\1\1\3\1\uffff}>";
    static final String[] DFA43_transitionS = {
            "\1\1\14\uffff\1\1\100\uffff\1\1\1\uffff\1\1\2\uffff\1\1\1\3"+
            "\2\1\1\uffff\2\1\1\uffff\1\1\33\uffff\6\1\1\2\1\4\1\5\1\6\1"+
            "\7\1\10\6\uffff\1\1\4\uffff\3\1\1\uffff\1\1\1\uffff\5\1",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            ""
    };

    static final short[] DFA43_eot = DFA.unpackEncodedString(DFA43_eotS);
    static final short[] DFA43_eof = DFA.unpackEncodedString(DFA43_eofS);
    static final char[] DFA43_min = DFA.unpackEncodedStringToUnsignedChars(DFA43_minS);
    static final char[] DFA43_max = DFA.unpackEncodedStringToUnsignedChars(DFA43_maxS);
    static final short[] DFA43_accept = DFA.unpackEncodedString(DFA43_acceptS);
    static final short[] DFA43_special = DFA.unpackEncodedString(DFA43_specialS);
    static final short[][] DFA43_transition;

    static {
        int numStates = DFA43_transitionS.length;
        DFA43_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA43_transition[i] = DFA.unpackEncodedString(DFA43_transitionS[i]);
        }
    }

    class DFA43 extends DFA {

        public DFA43(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 43;
            this.eot = DFA43_eot;
            this.eof = DFA43_eof;
            this.min = DFA43_min;
            this.max = DFA43_max;
            this.accept = DFA43_accept;
            this.special = DFA43_special;
            this.transition = DFA43_transition;
        }
        public String getDescription() {
            return "()* loopback of 398:23: ( (op= '==' relationalExpression | op= '=' relationalExpression | (op= '>' | op= '<' | op= '>=' | op= '<=' | op= '<>' ) additiveExpression ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA43_2 = input.LA(1);

                         
                        int index43_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred68_EolParserRules()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index43_2);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA43_7 = input.LA(1);

                         
                        int index43_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred68_EolParserRules()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index43_7);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA43_5 = input.LA(1);

                         
                        int index43_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred68_EolParserRules()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index43_5);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA43_8 = input.LA(1);

                         
                        int index43_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred68_EolParserRules()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index43_8);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA43_3 = input.LA(1);

                         
                        int index43_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred68_EolParserRules()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index43_3);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA43_6 = input.LA(1);

                         
                        int index43_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred68_EolParserRules()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index43_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA43_4 = input.LA(1);

                         
                        int index43_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred68_EolParserRules()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index43_4);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 43, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA53_eotS =
        "\10\uffff";
    static final String DFA53_eofS =
        "\1\uffff\1\3\6\uffff";
    static final String DFA53_minS =
        "\1\23\1\11\1\4\1\uffff\1\11\1\4\1\uffff\1\11";
    static final String DFA53_maxS =
        "\1\23\1\u00a2\1\u0097\1\uffff\1\u0094\1\u0097\1\uffff\1\u0094";
    static final String DFA53_acceptS =
        "\3\uffff\1\1\2\uffff\1\2\1\uffff";
    static final String DFA53_specialS =
        "\10\uffff}>";
    static final String[] DFA53_transitionS = {
            "\1\1",
            "\3\3\13\uffff\1\3\100\uffff\1\3\1\uffff\1\3\2\uffff\4\3\1\2"+
            "\2\3\1\uffff\1\3\33\uffff\20\3\1\uffff\2\3\4\uffff\3\3\1\uffff"+
            "\1\3\1\uffff\5\3",
            "\1\3\3\uffff\1\3\3\uffff\1\3\1\uffff\1\3\4\uffff\1\4\115\uffff"+
            "\2\3\6\uffff\10\3\35\uffff\1\3\2\uffff\1\3\3\uffff\3\3",
            "",
            "\1\3\1\uffff\1\3\116\uffff\1\5\3\uffff\1\3\2\uffff\2\3\1\6\2"+
            "\uffff\3\3\32\uffff\16\3\1\uffff\1\3\1\uffff\1\6",
            "\1\3\3\uffff\1\3\3\uffff\1\3\1\uffff\1\3\4\uffff\1\7\115\uffff"+
            "\1\3\7\uffff\10\3\35\uffff\1\3\2\uffff\1\3\3\uffff\3\3",
            "",
            "\1\3\1\uffff\1\3\116\uffff\1\5\3\uffff\1\3\2\uffff\2\3\1\6\2"+
            "\uffff\3\3\32\uffff\16\3\1\uffff\1\3\1\uffff\1\6"
    };

    static final short[] DFA53_eot = DFA.unpackEncodedString(DFA53_eotS);
    static final short[] DFA53_eof = DFA.unpackEncodedString(DFA53_eofS);
    static final char[] DFA53_min = DFA.unpackEncodedStringToUnsignedChars(DFA53_minS);
    static final char[] DFA53_max = DFA.unpackEncodedStringToUnsignedChars(DFA53_maxS);
    static final short[] DFA53_accept = DFA.unpackEncodedString(DFA53_acceptS);
    static final short[] DFA53_special = DFA.unpackEncodedString(DFA53_specialS);
    static final short[][] DFA53_transition;

    static {
        int numStates = DFA53_transitionS.length;
        DFA53_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA53_transition[i] = DFA.unpackEncodedString(DFA53_transitionS[i]);
        }
    }

    class DFA53 extends DFA {

        public DFA53(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 53;
            this.eot = DFA53_eot;
            this.eof = DFA53_eof;
            this.min = DFA53_min;
            this.max = DFA53_max;
            this.accept = DFA53_accept;
            this.special = DFA53_special;
            this.transition = DFA53_transition;
        }
        public String getDescription() {
            return "428:1: featureCall : ( simpleFeatureCall | declarativeFeatureCall );";
        }
    }
    static final String DFA62_eotS =
        "\27\uffff";
    static final String DFA62_eofS =
        "\2\2\25\uffff";
    static final String DFA62_minS =
        "\1\11\1\4\1\uffff\1\23\1\0\1\141\10\0\1\141\1\0\1\uffff\2\16\2\142"+
        "\2\0";
    static final String DFA62_maxS =
        "\1\u00a2\1\u0097\1\uffff\1\160\1\0\1\141\10\0\1\141\1\0\1\uffff"+
        "\2\16\2\142\2\0";
    static final String DFA62_acceptS =
        "\2\uffff\1\2\15\uffff\1\1\6\uffff";
    static final String DFA62_specialS =
        "\4\uffff\1\11\1\uffff\1\3\1\13\1\6\1\1\1\12\1\7\1\5\1\0\1\uffff"+
        "\1\10\5\uffff\1\4\1\2}>";
    static final String[] DFA62_transitionS = {
            "\3\2\13\uffff\1\2\100\uffff\1\2\1\uffff\1\2\2\uffff\4\2\1\uffff"+
            "\1\2\1\1\1\uffff\1\2\33\uffff\20\2\1\uffff\2\2\4\uffff\3\2\1"+
            "\uffff\1\2\1\uffff\5\2",
            "\1\2\3\uffff\1\2\3\uffff\1\2\1\uffff\1\2\4\uffff\1\4\110\uffff"+
            "\2\2\3\uffff\1\2\7\uffff\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14"+
            "\1\2\1\uffff\4\2\1\uffff\11\2\15\uffff\1\2\2\uffff\1\2\3\uffff"+
            "\1\3\2\2",
            "",
            "\1\15\125\uffff\1\16\7\17",
            "\1\uffff",
            "\1\21",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\22",
            "\1\uffff",
            "",
            "\1\23",
            "\1\24",
            "\1\25",
            "\1\26",
            "\1\uffff",
            "\1\uffff"
    };

    static final short[] DFA62_eot = DFA.unpackEncodedString(DFA62_eotS);
    static final short[] DFA62_eof = DFA.unpackEncodedString(DFA62_eofS);
    static final char[] DFA62_min = DFA.unpackEncodedStringToUnsignedChars(DFA62_minS);
    static final char[] DFA62_max = DFA.unpackEncodedStringToUnsignedChars(DFA62_maxS);
    static final short[] DFA62_accept = DFA.unpackEncodedString(DFA62_acceptS);
    static final short[] DFA62_special = DFA.unpackEncodedString(DFA62_specialS);
    static final short[][] DFA62_transition;

    static {
        int numStates = DFA62_transitionS.length;
        DFA62_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA62_transition[i] = DFA.unpackEncodedString(DFA62_transitionS[i]);
        }
    }

    class DFA62 extends DFA {

        public DFA62(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 62;
            this.eot = DFA62_eot;
            this.eof = DFA62_eof;
            this.min = DFA62_min;
            this.max = DFA62_max;
            this.accept = DFA62_accept;
            this.special = DFA62_special;
            this.transition = DFA62_transition;
        }
        public String getDescription() {
            return "468:29: ( ':' (n= 'new' )? t= typeName ( parameterList )? )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA62_13 = input.LA(1);

                         
                        int index62_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index62_13);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA62_9 = input.LA(1);

                         
                        int index62_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index62_9);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA62_22 = input.LA(1);

                         
                        int index62_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index62_22);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA62_6 = input.LA(1);

                         
                        int index62_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index62_6);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA62_21 = input.LA(1);

                         
                        int index62_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index62_21);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA62_12 = input.LA(1);

                         
                        int index62_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index62_12);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA62_8 = input.LA(1);

                         
                        int index62_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index62_8);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA62_11 = input.LA(1);

                         
                        int index62_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index62_11);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA62_15 = input.LA(1);

                         
                        int index62_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index62_15);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA62_4 = input.LA(1);

                         
                        int index62_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index62_4);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA62_10 = input.LA(1);

                         
                        int index62_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index62_10);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA62_7 = input.LA(1);

                         
                        int index62_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index62_7);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 62, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA66_eotS =
        "\23\uffff";
    static final String DFA66_eofS =
        "\23\uffff";
    static final String DFA66_minS =
        "\1\4\20\0\2\uffff";
    static final String DFA66_maxS =
        "\1\u0097\20\0\2\uffff";
    static final String DFA66_acceptS =
        "\21\uffff\1\1\1\2";
    static final String DFA66_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14"+
        "\1\15\1\16\1\17\2\uffff}>";
    static final String[] DFA66_transitionS = {
            "\1\12\3\uffff\1\12\3\uffff\1\12\1\uffff\1\12\4\uffff\1\13\115"+
            "\uffff\1\15\7\uffff\1\14\1\3\1\4\1\5\1\6\1\7\1\10\1\11\35\uffff"+
            "\1\2\2\uffff\1\1\3\uffff\1\16\1\17\1\20",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            ""
    };

    static final short[] DFA66_eot = DFA.unpackEncodedString(DFA66_eotS);
    static final short[] DFA66_eof = DFA.unpackEncodedString(DFA66_eofS);
    static final char[] DFA66_min = DFA.unpackEncodedStringToUnsignedChars(DFA66_minS);
    static final char[] DFA66_max = DFA.unpackEncodedStringToUnsignedChars(DFA66_maxS);
    static final short[] DFA66_accept = DFA.unpackEncodedString(DFA66_acceptS);
    static final short[] DFA66_special = DFA.unpackEncodedString(DFA66_specialS);
    static final short[][] DFA66_transition;

    static {
        int numStates = DFA66_transitionS.length;
        DFA66_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA66_transition[i] = DFA.unpackEncodedString(DFA66_transitionS[i]);
        }
    }

    class DFA66 extends DFA {

        public DFA66(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 66;
            this.eot = DFA66_eot;
            this.eof = DFA66_eof;
            this.min = DFA66_min;
            this.max = DFA66_max;
            this.accept = DFA66_accept;
            this.special = DFA66_special;
            this.transition = DFA66_transition;
        }
        public String getDescription() {
            return "493:1: expressionListOrRange : ( expressionRange | expressionList );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA66_1 = input.LA(1);

                         
                        int index66_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred96_EolParserRules()) ) {s = 17;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index66_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA66_2 = input.LA(1);

                         
                        int index66_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred96_EolParserRules()) ) {s = 17;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index66_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA66_3 = input.LA(1);

                         
                        int index66_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred96_EolParserRules()) ) {s = 17;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index66_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA66_4 = input.LA(1);

                         
                        int index66_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred96_EolParserRules()) ) {s = 17;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index66_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA66_5 = input.LA(1);

                         
                        int index66_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred96_EolParserRules()) ) {s = 17;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index66_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA66_6 = input.LA(1);

                         
                        int index66_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred96_EolParserRules()) ) {s = 17;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index66_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA66_7 = input.LA(1);

                         
                        int index66_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred96_EolParserRules()) ) {s = 17;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index66_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA66_8 = input.LA(1);

                         
                        int index66_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred96_EolParserRules()) ) {s = 17;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index66_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA66_9 = input.LA(1);

                         
                        int index66_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred96_EolParserRules()) ) {s = 17;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index66_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA66_10 = input.LA(1);

                         
                        int index66_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred96_EolParserRules()) ) {s = 17;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index66_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA66_11 = input.LA(1);

                         
                        int index66_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred96_EolParserRules()) ) {s = 17;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index66_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA66_12 = input.LA(1);

                         
                        int index66_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred96_EolParserRules()) ) {s = 17;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index66_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA66_13 = input.LA(1);

                         
                        int index66_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred96_EolParserRules()) ) {s = 17;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index66_13);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA66_14 = input.LA(1);

                         
                        int index66_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred96_EolParserRules()) ) {s = 17;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index66_14);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA66_15 = input.LA(1);

                         
                        int index66_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred96_EolParserRules()) ) {s = 17;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index66_15);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA66_16 = input.LA(1);

                         
                        int index66_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred96_EolParserRules()) ) {s = 17;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index66_16);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 66, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA69_eotS =
        "\23\uffff";
    static final String DFA69_eofS =
        "\1\uffff\7\16\13\uffff";
    static final String DFA69_minS =
        "\1\4\7\11\1\uffff\1\0\11\uffff";
    static final String DFA69_maxS =
        "\1\u0097\7\u00a2\1\uffff\1\0\11\uffff";
    static final String DFA69_acceptS =
        "\10\uffff\1\3\1\uffff\1\6\1\10\1\11\1\12\1\7\1\1\1\2\1\4\1\5";
    static final String DFA69_specialS =
        "\11\uffff\1\0\11\uffff}>";
    static final String[] DFA69_transitionS = {
            "\1\10\3\uffff\1\10\3\uffff\1\10\1\uffff\1\10\4\uffff\1\11\115"+
            "\uffff\1\13\7\uffff\1\12\1\1\1\2\1\3\1\4\1\5\1\6\1\7\44\uffff"+
            "\1\14\2\15",
            "\3\16\13\uffff\1\16\100\uffff\1\16\1\uffff\1\16\1\uffff\1\17"+
            "\7\16\1\uffff\1\16\33\uffff\20\16\1\uffff\2\16\4\uffff\3\16"+
            "\1\uffff\1\16\1\uffff\5\16",
            "\3\16\13\uffff\1\16\100\uffff\1\16\1\uffff\1\16\1\uffff\1\17"+
            "\7\16\1\uffff\1\16\33\uffff\20\16\1\uffff\2\16\4\uffff\3\16"+
            "\1\uffff\1\16\1\uffff\5\16",
            "\3\16\13\uffff\1\16\100\uffff\1\16\1\uffff\1\16\1\uffff\1\17"+
            "\7\16\1\uffff\1\16\33\uffff\20\16\1\uffff\2\16\4\uffff\3\16"+
            "\1\uffff\1\16\1\uffff\5\16",
            "\3\16\13\uffff\1\16\100\uffff\1\16\1\uffff\1\16\1\uffff\1\17"+
            "\7\16\1\uffff\1\16\33\uffff\20\16\1\uffff\2\16\4\uffff\3\16"+
            "\1\uffff\1\16\1\uffff\5\16",
            "\3\16\13\uffff\1\16\100\uffff\1\16\1\uffff\1\16\1\uffff\1\17"+
            "\7\16\1\uffff\1\16\33\uffff\20\16\1\uffff\2\16\4\uffff\3\16"+
            "\1\uffff\1\16\1\uffff\5\16",
            "\3\16\13\uffff\1\16\100\uffff\1\16\1\uffff\1\16\1\uffff\1\17"+
            "\7\16\1\uffff\1\16\33\uffff\20\16\1\uffff\2\16\4\uffff\3\16"+
            "\1\uffff\1\16\1\uffff\5\16",
            "\3\16\13\uffff\1\16\100\uffff\1\16\1\uffff\1\16\1\uffff\1\20"+
            "\7\16\1\uffff\1\16\33\uffff\20\16\1\uffff\2\16\4\uffff\3\16"+
            "\1\uffff\1\16\1\uffff\5\16",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA69_eot = DFA.unpackEncodedString(DFA69_eotS);
    static final short[] DFA69_eof = DFA.unpackEncodedString(DFA69_eofS);
    static final char[] DFA69_min = DFA.unpackEncodedStringToUnsignedChars(DFA69_minS);
    static final char[] DFA69_max = DFA.unpackEncodedStringToUnsignedChars(DFA69_maxS);
    static final short[] DFA69_accept = DFA.unpackEncodedString(DFA69_acceptS);
    static final short[] DFA69_special = DFA.unpackEncodedString(DFA69_specialS);
    static final short[][] DFA69_transition;

    static {
        int numStates = DFA69_transitionS.length;
        DFA69_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA69_transition[i] = DFA.unpackEncodedString(DFA69_transitionS[i]);
        }
    }

    class DFA69 extends DFA {

        public DFA69(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 69;
            this.eot = DFA69_eot;
            this.eof = DFA69_eof;
            this.min = DFA69_min;
            this.max = DFA69_max;
            this.accept = DFA69_accept;
            this.special = DFA69_special;
            this.transition = DFA69_transition;
        }
        public String getDescription() {
            return "519:1: primitiveExpression : ( literalSequentialCollection | literalMapCollection | literal | featureCall | pathName | nativeType | collectionType | logicalExpressionInBrackets | newExpression | variableDeclarationExpression );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA69_9 = input.LA(1);

                         
                        int index69_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred102_EolParserRules()) ) {s = 17;}

                        else if ( (synpred103_EolParserRules()) ) {s = 18;}

                         
                        input.seek(index69_9);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 69, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_operationDeclaration_in_operationDeclarationOrAnnotationBlock250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationBlock_in_operationDeclarationOrAnnotationBlock252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_87_in_modelDeclaration271 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_modelDeclaration274 = new BitSet(new long[]{0x0000000000000000L,0x000000001B000000L});
    public static final BitSet FOLLOW_modelAlias_in_modelDeclaration276 = new BitSet(new long[]{0x0000000000000000L,0x0000000019000000L});
    public static final BitSet FOLLOW_modelDriver_in_modelDeclaration279 = new BitSet(new long[]{0x0000000000000000L,0x0000000011000000L});
    public static final BitSet FOLLOW_modelDeclarationParameters_in_modelDeclaration282 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_88_in_modelDeclaration287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_89_in_modelAlias302 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_modelAlias305 = new BitSet(new long[]{0x0000000000000002L,0x0000000004000000L});
    public static final BitSet FOLLOW_90_in_modelAlias308 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_modelAlias311 = new BitSet(new long[]{0x0000000000000002L,0x0000000004000000L});
    public static final BitSet FOLLOW_91_in_modelDriver330 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_modelDriver333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_92_in_modelDeclarationParameters355 = new BitSet(new long[]{0x0000000000080000L,0x0000000024000000L});
    public static final BitSet FOLLOW_modelDeclarationParameter_in_modelDeclarationParameters358 = new BitSet(new long[]{0x0000000000000000L,0x0000000024000000L});
    public static final BitSet FOLLOW_90_in_modelDeclarationParameters362 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_modelDeclarationParameter_in_modelDeclarationParameters365 = new BitSet(new long[]{0x0000000000000000L,0x0000000024000000L});
    public static final BitSet FOLLOW_93_in_modelDeclarationParameters371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_modelDeclarationParameter384 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_94_in_modelDeclarationParameter388 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_STRING_in_modelDeclarationParameter391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_operationDeclaration412 = new BitSet(new long[]{0x0000000000080000L,0x0001FE0000000000L});
    public static final BitSet FOLLOW_typeName_in_operationDeclaration422 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_operationDeclaration430 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_97_in_operationDeclaration434 = new BitSet(new long[]{0x0000000000080000L,0x0000000400000000L});
    public static final BitSet FOLLOW_formalParameterList_in_operationDeclaration437 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_98_in_operationDeclaration442 = new BitSet(new long[]{0x0000000000000000L,0x0000000810000000L});
    public static final BitSet FOLLOW_99_in_operationDeclaration446 = new BitSet(new long[]{0x0000000000080000L,0x0001FE0000000000L});
    public static final BitSet FOLLOW_typeName_in_operationDeclaration451 = new BitSet(new long[]{0x0000000000000000L,0x0000000810000000L});
    public static final BitSet FOLLOW_statementBlock_in_operationDeclaration457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_100_in_importStatement477 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_STRING_in_importStatement480 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_88_in_importStatement484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_block504 = new BitSet(new long[]{0x0000000000085112L,0xFF1BFE0200000000L,0x0000000000E24001L});
    public static final BitSet FOLLOW_92_in_statementBlock533 = new BitSet(new long[]{0x0000000000085110L,0xFF1BFE0200000000L,0x0000000000E24001L});
    public static final BitSet FOLLOW_block_in_statementBlock536 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_statementBlock540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_formalParameter558 = new BitSet(new long[]{0x0000000000000002L,0x0000000800000000L});
    public static final BitSet FOLLOW_99_in_formalParameter561 = new BitSet(new long[]{0x0000000000080000L,0x0001FE0000000000L});
    public static final BitSet FOLLOW_typeName_in_formalParameter565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_formalParameter_in_formalParameterList599 = new BitSet(new long[]{0x0000000000000002L,0x0000000004000000L});
    public static final BitSet FOLLOW_90_in_formalParameterList602 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_formalParameter_in_formalParameterList604 = new BitSet(new long[]{0x0000000000000002L,0x0000000004000000L});
    public static final BitSet FOLLOW_101_in_executableAnnotation629 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0xFFFFFFFFFFFFFFFFL,0x00000007FFFFFFFFL});
    public static final BitSet FOLLOW_logicalExpression_in_executableAnnotation636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Annotation_in_annotation650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_executableAnnotation_in_annotation652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotation_in_annotationBlock669 = new BitSet(new long[]{0x0000000000800002L,0x0000002000000000L});
    public static final BitSet FOLLOW_pathName_in_typeName698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nativeType_in_typeName702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectionType_in_typeName706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_pathName720 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_102_in_pathName722 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_packagedType_in_pathName731 = new BitSet(new long[]{0x0000000000000002L,0x0000008000000000L});
    public static final BitSet FOLLOW_103_in_pathName737 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_pathName742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_packagedType763 = new BitSet(new long[]{0x0000000000000002L,0x0000010000000000L});
    public static final BitSet FOLLOW_104_in_packagedType766 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_packagedType771 = new BitSet(new long[]{0x0000000000000002L,0x0000010000000000L});
    public static final BitSet FOLLOW_105_in_nativeType799 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_97_in_nativeType804 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_STRING_in_nativeType807 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_98_in_nativeType811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_collectionType829 = new BitSet(new long[]{0x0000000000000002L,0x0000000200000000L});
    public static final BitSet FOLLOW_97_in_collectionType851 = new BitSet(new long[]{0x0000000000080000L,0x0001FE0000000000L});
    public static final BitSet FOLLOW_typeName_in_collectionType856 = new BitSet(new long[]{0x0000000000000000L,0x0000000404000000L});
    public static final BitSet FOLLOW_90_in_collectionType861 = new BitSet(new long[]{0x0000000000080000L,0x0001FE0000000000L});
    public static final BitSet FOLLOW_typeName_in_collectionType865 = new BitSet(new long[]{0x0000000000000000L,0x0000000404000000L});
    public static final BitSet FOLLOW_98_in_collectionType873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementA_in_statement888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementB_in_statement892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignmentStatement_in_statementA903 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionStatement_in_statementA907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_forStatement_in_statementA911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStatement_in_statementA917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_whileStatement_in_statementA921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_switchStatement_in_statementA925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_returnStatement_in_statementA929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_breakStatement_in_statementA933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_breakAllStatement_in_statementB945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_returnStatement_in_statementB949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_transactionStatement_in_statementB953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_abortStatement_in_statementB959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_continueStatement_in_statementB963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_throwStatement_in_statementB967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_deleteStatement_in_statementB973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_statementOrStatementBlock984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementBlock_in_statementOrStatementBlock988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_99_in_expressionOrStatementBlock997 = new BitSet(new long[]{0x0000000000085110L,0x0001FE0200000000L,0x0000000000E24000L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionOrStatementBlock1000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementBlock_in_expressionOrStatementBlock1004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_113_in_forStatement1017 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_97_in_forStatement1020 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_formalParameter_in_forStatement1023 = new BitSet(new long[]{0x0000000000000000L,0x0004000000000000L});
    public static final BitSet FOLLOW_114_in_forStatement1025 = new BitSet(new long[]{0x0000000000085110L,0x0001FE0200000000L,0x0000000000E24000L});
    public static final BitSet FOLLOW_logicalExpression_in_forStatement1028 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_98_in_forStatement1030 = new BitSet(new long[]{0x0000000000085110L,0xFF1BFE0A10000000L,0x0000000000E24001L});
    public static final BitSet FOLLOW_statementOrStatementBlock_in_forStatement1033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_115_in_ifStatement1049 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_97_in_ifStatement1052 = new BitSet(new long[]{0x0000000000085110L,0x0001FE0200000000L,0x0000000000E24000L});
    public static final BitSet FOLLOW_logicalExpression_in_ifStatement1055 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_98_in_ifStatement1057 = new BitSet(new long[]{0x0000000000085110L,0xFF1BFE0A10000000L,0x0000000000E24001L});
    public static final BitSet FOLLOW_statementOrStatementBlock_in_ifStatement1060 = new BitSet(new long[]{0x0000000000000002L,0x0080000000000000L});
    public static final BitSet FOLLOW_elseStatement_in_ifStatement1062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_116_in_switchStatement1081 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_97_in_switchStatement1084 = new BitSet(new long[]{0x0000000000085110L,0x0001FE0200000000L,0x0000000000E24000L});
    public static final BitSet FOLLOW_logicalExpression_in_switchStatement1087 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_98_in_switchStatement1089 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_92_in_switchStatement1092 = new BitSet(new long[]{0x0000000000000000L,0x0060000020000000L});
    public static final BitSet FOLLOW_caseStatement_in_switchStatement1095 = new BitSet(new long[]{0x0000000000000000L,0x0060000020000000L});
    public static final BitSet FOLLOW_defaultStatement_in_switchStatement1098 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_switchStatement1101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_117_in_caseStatement1120 = new BitSet(new long[]{0x0000000000085110L,0x0001FE0200000000L,0x0000000000E24000L});
    public static final BitSet FOLLOW_logicalExpression_in_caseStatement1123 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_99_in_caseStatement1125 = new BitSet(new long[]{0x0000000000085110L,0xFF1BFE0A10000000L,0x0000000000E24001L});
    public static final BitSet FOLLOW_block_in_caseStatement1129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementBlock_in_caseStatement1133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_118_in_defaultStatement1152 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_99_in_defaultStatement1155 = new BitSet(new long[]{0x0000000000085110L,0xFF1BFE0A10000000L,0x0000000000E24001L});
    public static final BitSet FOLLOW_block_in_defaultStatement1159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementBlock_in_defaultStatement1163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_119_in_elseStatement1188 = new BitSet(new long[]{0x0000000000085110L,0xFF1BFE0A10000000L,0x0000000000E24001L});
    public static final BitSet FOLLOW_statementOrStatementBlock_in_elseStatement1191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_120_in_whileStatement1204 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_97_in_whileStatement1207 = new BitSet(new long[]{0x0000000000085110L,0x0001FE0200000000L,0x0000000000E24000L});
    public static final BitSet FOLLOW_logicalExpression_in_whileStatement1210 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_98_in_whileStatement1212 = new BitSet(new long[]{0x0000000000085110L,0xFF1BFE0A10000000L,0x0000000000E24001L});
    public static final BitSet FOLLOW_statementOrStatementBlock_in_whileStatement1215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_121_in_returnStatement1237 = new BitSet(new long[]{0x0000000000085110L,0x0001FE0201000000L,0x0000000000E24000L});
    public static final BitSet FOLLOW_logicalExpression_in_returnStatement1240 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_88_in_returnStatement1245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_122_in_throwStatement1268 = new BitSet(new long[]{0x0000000000085110L,0x0001FE0201000000L,0x0000000000E24000L});
    public static final BitSet FOLLOW_logicalExpression_in_throwStatement1271 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_88_in_throwStatement1276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_123_in_deleteStatement1299 = new BitSet(new long[]{0x0000000000085110L,0x0001FE0201000000L,0x0000000000E24000L});
    public static final BitSet FOLLOW_logicalExpression_in_deleteStatement1302 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_88_in_deleteStatement1307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_124_in_breakStatement1333 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_88_in_breakStatement1338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_125_in_breakAllStatement1361 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_88_in_breakAllStatement1366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_126_in_continueStatement1389 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_88_in_continueStatement1394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_127_in_abortStatement1417 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_88_in_abortStatement1422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_128_in_transactionStatement1439 = new BitSet(new long[]{0x0000000000085110L,0xFF1BFE0A10000000L,0x0000000000E24001L});
    public static final BitSet FOLLOW_NAME_in_transactionStatement1443 = new BitSet(new long[]{0x0000000000085110L,0xFF1BFE0A14000000L,0x0000000000E24001L});
    public static final BitSet FOLLOW_90_in_transactionStatement1446 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_transactionStatement1448 = new BitSet(new long[]{0x0000000000085110L,0xFF1BFE0A14000000L,0x0000000000E24001L});
    public static final BitSet FOLLOW_statementOrStatementBlock_in_transactionStatement1454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logicalExpression_in_assignmentStatement1474 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000006L});
    public static final BitSet FOLLOW_129_in_assignmentStatement1479 = new BitSet(new long[]{0x0000000000085110L,0x0001FE0200000000L,0x0000000000E24000L});
    public static final BitSet FOLLOW_130_in_assignmentStatement1486 = new BitSet(new long[]{0x0000000000085110L,0x0001FE0200000000L,0x0000000000E24000L});
    public static final BitSet FOLLOW_logicalExpression_in_assignmentStatement1492 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_88_in_assignmentStatement1496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_postfixExpression_in_expressionStatement1518 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_94_in_expressionStatement1522 = new BitSet(new long[]{0x0000000000085110L,0x0001FE0200000000L,0x0000000000E24000L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionStatement1525 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionStatement1531 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_88_in_expressionStatement1536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_relationalExpression_in_logicalExpression1548 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000078L});
    public static final BitSet FOLLOW_131_in_logicalExpression1554 = new BitSet(new long[]{0x0000000000085110L,0x0001FE0200000000L,0x0000000000E24000L});
    public static final BitSet FOLLOW_132_in_logicalExpression1559 = new BitSet(new long[]{0x0000000000085110L,0x0001FE0200000000L,0x0000000000E24000L});
    public static final BitSet FOLLOW_133_in_logicalExpression1564 = new BitSet(new long[]{0x0000000000085110L,0x0001FE0200000000L,0x0000000000E24000L});
    public static final BitSet FOLLOW_134_in_logicalExpression1569 = new BitSet(new long[]{0x0000000000085110L,0x0001FE0200000000L,0x0000000000E24000L});
    public static final BitSet FOLLOW_relationalExpression_in_logicalExpression1573 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000078L});
    public static final BitSet FOLLOW_additiveExpression_in_relationalExpression1590 = new BitSet(new long[]{0x0000000000000002L,0x0000000040000000L,0x0000000000001F80L});
    public static final BitSet FOLLOW_135_in_relationalExpression1596 = new BitSet(new long[]{0x0000000000085110L,0x0001FE0200000000L,0x0000000000E24000L});
    public static final BitSet FOLLOW_relationalExpression_in_relationalExpression1599 = new BitSet(new long[]{0x0000000000000002L,0x0000000040000000L,0x0000000000001F80L});
    public static final BitSet FOLLOW_94_in_relationalExpression1605 = new BitSet(new long[]{0x0000000000085110L,0x0001FE0200000000L,0x0000000000E24000L});
    public static final BitSet FOLLOW_relationalExpression_in_relationalExpression1608 = new BitSet(new long[]{0x0000000000000002L,0x0000000040000000L,0x0000000000001F80L});
    public static final BitSet FOLLOW_136_in_relationalExpression1638 = new BitSet(new long[]{0x0000000000085110L,0x0001FE0200000000L,0x0000000000E24000L});
    public static final BitSet FOLLOW_137_in_relationalExpression1643 = new BitSet(new long[]{0x0000000000085110L,0x0001FE0200000000L,0x0000000000E24000L});
    public static final BitSet FOLLOW_138_in_relationalExpression1648 = new BitSet(new long[]{0x0000000000085110L,0x0001FE0200000000L,0x0000000000E24000L});
    public static final BitSet FOLLOW_139_in_relationalExpression1653 = new BitSet(new long[]{0x0000000000085110L,0x0001FE0200000000L,0x0000000000E24000L});
    public static final BitSet FOLLOW_140_in_relationalExpression1658 = new BitSet(new long[]{0x0000000000085110L,0x0001FE0200000000L,0x0000000000E24000L});
    public static final BitSet FOLLOW_additiveExpression_in_relationalExpression1662 = new BitSet(new long[]{0x0000000000000002L,0x0000000040000000L,0x0000000000001F80L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_additiveExpression1680 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000006000L});
    public static final BitSet FOLLOW_141_in_additiveExpression1686 = new BitSet(new long[]{0x0000000000085110L,0x0001FE0200000000L,0x0000000000E24000L});
    public static final BitSet FOLLOW_142_in_additiveExpression1691 = new BitSet(new long[]{0x0000000000085110L,0x0001FE0200000000L,0x0000000000E24000L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_additiveExpression1695 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000006000L});
    public static final BitSet FOLLOW_unaryExpression_in_multiplicativeExpression1713 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000018000L});
    public static final BitSet FOLLOW_143_in_multiplicativeExpression1719 = new BitSet(new long[]{0x0000000000085110L,0x0001FE0200000000L,0x0000000000E24000L});
    public static final BitSet FOLLOW_144_in_multiplicativeExpression1724 = new BitSet(new long[]{0x0000000000085110L,0x0001FE0200000000L,0x0000000000E24000L});
    public static final BitSet FOLLOW_unaryExpression_in_multiplicativeExpression1728 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000018000L});
    public static final BitSet FOLLOW_145_in_unaryExpression1749 = new BitSet(new long[]{0x0000000000085110L,0x0001FE0200000000L,0x0000000000E24000L});
    public static final BitSet FOLLOW_142_in_unaryExpression1754 = new BitSet(new long[]{0x0000000000085110L,0x0001FE0200000000L,0x0000000000E24000L});
    public static final BitSet FOLLOW_postfixExpression_in_unaryExpression1762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_itemSelectorExpression_in_postfixExpression1774 = new BitSet(new long[]{0x0000000000000A02L});
    public static final BitSet FOLLOW_set_in_postfixExpression1777 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_featureCall_in_postfixExpression1786 = new BitSet(new long[]{0x0000000000000A02L,0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_146_in_postfixExpression1795 = new BitSet(new long[]{0x0000000000085110L,0x0001FE0200000000L,0x0000000000E24000L});
    public static final BitSet FOLLOW_logicalExpression_in_postfixExpression1798 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_147_in_postfixExpression1800 = new BitSet(new long[]{0x0000000000000A02L,0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_primitiveExpression_in_itemSelectorExpression1822 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_146_in_itemSelectorExpression1827 = new BitSet(new long[]{0x0000000000085110L,0x0001FE0200000000L,0x0000000000E24000L});
    public static final BitSet FOLLOW_primitiveExpression_in_itemSelectorExpression1830 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_147_in_itemSelectorExpression1832 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_simpleFeatureCall_in_featureCall1851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declarativeFeatureCall_in_featureCall1855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_simpleFeatureCall1869 = new BitSet(new long[]{0x0000000000000002L,0x0000000200000000L});
    public static final BitSet FOLLOW_parameterList_in_simpleFeatureCall1872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_97_in_parameterList1895 = new BitSet(new long[]{0x0000000000085110L,0x0001FE0600000000L,0x0000000000E24000L});
    public static final BitSet FOLLOW_logicalExpression_in_parameterList1898 = new BitSet(new long[]{0x0000000000000000L,0x0000000404000000L});
    public static final BitSet FOLLOW_90_in_parameterList1901 = new BitSet(new long[]{0x0000000000085110L,0x0001FE0200000000L,0x0000000000E24000L});
    public static final BitSet FOLLOW_logicalExpression_in_parameterList1903 = new BitSet(new long[]{0x0000000000000000L,0x0000000404000000L});
    public static final BitSet FOLLOW_98_in_parameterList1911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_declarativeFeatureCall1939 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_97_in_declarativeFeatureCall1944 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_formalParameterList_in_declarativeFeatureCall1947 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_148_in_declarativeFeatureCall1949 = new BitSet(new long[]{0x0000000000085110L,0x0001FE0200000000L,0x0000000000E24000L});
    public static final BitSet FOLLOW_logicalExpression_in_declarativeFeatureCall1952 = new BitSet(new long[]{0x0000000000000000L,0x0000000404000000L});
    public static final BitSet FOLLOW_90_in_declarativeFeatureCall1955 = new BitSet(new long[]{0x0000000000085110L,0x0001FE0200000000L,0x0000000000E24000L});
    public static final BitSet FOLLOW_logicalExpression_in_declarativeFeatureCall1958 = new BitSet(new long[]{0x0000000000000000L,0x0000000404000000L});
    public static final BitSet FOLLOW_98_in_declarativeFeatureCall1964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_149_in_newExpression1978 = new BitSet(new long[]{0x0000000000080000L,0x0001FE0000000000L});
    public static final BitSet FOLLOW_typeName_in_newExpression1983 = new BitSet(new long[]{0x0000000000000002L,0x0000000200000000L});
    public static final BitSet FOLLOW_parameterList_in_newExpression1987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_150_in_variableDeclarationExpression2010 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_151_in_variableDeclarationExpression2015 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_variableDeclarationExpression2019 = new BitSet(new long[]{0x0000000000000002L,0x0000000800000000L});
    public static final BitSet FOLLOW_99_in_variableDeclarationExpression2022 = new BitSet(new long[]{0x0000000000080000L,0x0001FE0000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_149_in_variableDeclarationExpression2027 = new BitSet(new long[]{0x0000000000080000L,0x0001FE0000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_typeName_in_variableDeclarationExpression2033 = new BitSet(new long[]{0x0000000000000002L,0x0000000200000000L});
    public static final BitSet FOLLOW_parameterList_in_variableDeclarationExpression2037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_106_in_literalSequentialCollection2061 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_107_in_literalSequentialCollection2066 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_108_in_literalSequentialCollection2071 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_109_in_literalSequentialCollection2076 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_110_in_literalSequentialCollection2081 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_111_in_literalSequentialCollection2086 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_92_in_literalSequentialCollection2092 = new BitSet(new long[]{0x0000000000085110L,0x0001FE0220000000L,0x0000000000E24000L});
    public static final BitSet FOLLOW_expressionListOrRange_in_literalSequentialCollection2096 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_literalSequentialCollection2101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionRange2116 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_POINT_POINT_in_expressionRange2120 = new BitSet(new long[]{0x0000000000085110L,0x0001FE0200000000L,0x0000000000E24000L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionRange2123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionList2144 = new BitSet(new long[]{0x0000000000000002L,0x0000000004000000L});
    public static final BitSet FOLLOW_90_in_expressionList2147 = new BitSet(new long[]{0x0000000000085110L,0x0001FE0200000000L,0x0000000000E24000L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionList2149 = new BitSet(new long[]{0x0000000000000002L,0x0000000004000000L});
    public static final BitSet FOLLOW_expressionRange_in_expressionListOrRange2173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionList_in_expressionListOrRange2177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_112_in_literalMapCollection2196 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_92_in_literalMapCollection2201 = new BitSet(new long[]{0x0000000000085110L,0x0001FE0220000000L,0x0000000000E24000L});
    public static final BitSet FOLLOW_keyvalExpressionList_in_literalMapCollection2204 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_literalMapCollection2209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_keyvalExpression_in_keyvalExpressionList2230 = new BitSet(new long[]{0x0000000000000002L,0x0000000004000000L});
    public static final BitSet FOLLOW_90_in_keyvalExpressionList2233 = new BitSet(new long[]{0x0000000000085110L,0x0001FE0200000000L,0x0000000000E24000L});
    public static final BitSet FOLLOW_keyvalExpression_in_keyvalExpressionList2235 = new BitSet(new long[]{0x0000000000000002L,0x0000000004000000L});
    public static final BitSet FOLLOW_additiveExpression_in_keyvalExpression2260 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_94_in_keyvalExpression2264 = new BitSet(new long[]{0x0000000000085110L,0x0001FE0200000000L,0x0000000000E24000L});
    public static final BitSet FOLLOW_logicalExpression_in_keyvalExpression2267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literalSequentialCollection_in_primitiveExpression2281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literalMapCollection_in_primitiveExpression2285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_primitiveExpression2289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_featureCall_in_primitiveExpression2293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pathName_in_primitiveExpression2297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nativeType_in_primitiveExpression2301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectionType_in_primitiveExpression2307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logicalExpressionInBrackets_in_primitiveExpression2312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_newExpression_in_primitiveExpression2318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variableDeclarationExpression_in_primitiveExpression2322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_97_in_logicalExpressionInBrackets2341 = new BitSet(new long[]{0x0000000000085110L,0x0001FE0200000000L,0x0000000000E24000L});
    public static final BitSet FOLLOW_logicalExpression_in_logicalExpressionInBrackets2344 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_98_in_logicalExpressionInBrackets2348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_literal0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotation_in_synpred16_EolParserRules669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_97_in_synpred29_EolParserRules851 = new BitSet(new long[]{0x0000000000080000L,0x0001FE0000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_typeName_in_synpred29_EolParserRules856 = new BitSet(new long[]{0x0000000000000000L,0x0000000404000000L});
    public static final BitSet FOLLOW_90_in_synpred29_EolParserRules861 = new BitSet(new long[]{0x0000000000080000L,0x0001FE0000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_typeName_in_synpred29_EolParserRules865 = new BitSet(new long[]{0x0000000000000000L,0x0000000404000000L});
    public static final BitSet FOLLOW_98_in_synpred29_EolParserRules873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementA_in_synpred30_EolParserRules888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignmentStatement_in_synpred31_EolParserRules903 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionStatement_in_synpred32_EolParserRules907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_elseStatement_in_synpred46_EolParserRules1062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_synpred55_EolParserRules1443 = new BitSet(new long[]{0x0000000000000002L,0x0000000004000000L});
    public static final BitSet FOLLOW_90_in_synpred55_EolParserRules1446 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_synpred55_EolParserRules1448 = new BitSet(new long[]{0x0000000000000002L,0x0000000004000000L});
    public static final BitSet FOLLOW_postfixExpression_in_synpred57_EolParserRules1518 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_94_in_synpred57_EolParserRules1522 = new BitSet(new long[]{0x0000000000085110L,0x0001FE0200000000L,0x0000000000E24000L});
    public static final BitSet FOLLOW_logicalExpression_in_synpred57_EolParserRules1525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_135_in_synpred68_EolParserRules1596 = new BitSet(new long[]{0x0000000000085110L,0x0001FE0200000000L,0x0000000000E24000L});
    public static final BitSet FOLLOW_relationalExpression_in_synpred68_EolParserRules1599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_synpred68_EolParserRules1605 = new BitSet(new long[]{0x0000000000085110L,0x0001FE0200000000L,0x0000000000E24000L});
    public static final BitSet FOLLOW_relationalExpression_in_synpred68_EolParserRules1608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred68_EolParserRules1635 = new BitSet(new long[]{0x0000000000085110L,0x0001FE0200000000L,0x0000000000E24000L});
    public static final BitSet FOLLOW_additiveExpression_in_synpred68_EolParserRules1662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_99_in_synpred88_EolParserRules2022 = new BitSet(new long[]{0x0000000000080000L,0x0001FE0000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_149_in_synpred88_EolParserRules2027 = new BitSet(new long[]{0x0000000000080000L,0x0001FE0000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_typeName_in_synpred88_EolParserRules2033 = new BitSet(new long[]{0x0000000000000002L,0x0000000200000000L});
    public static final BitSet FOLLOW_parameterList_in_synpred88_EolParserRules2037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionRange_in_synpred96_EolParserRules2173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_featureCall_in_synpred102_EolParserRules2293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pathName_in_synpred103_EolParserRules2297 = new BitSet(new long[]{0x0000000000000002L});

}
