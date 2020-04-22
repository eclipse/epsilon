package org.eclipse.epsilon.egl.parse;

// $ANTLR 3.1b1 EolParserRules.g 2020-04-22 23:32:28

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
 * https://www.eclipse.org/legal/epl-v20.html
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
    public static final int T__144=144;
    public static final int T__143=143;
    public static final int T__146=146;
    public static final int MODELDECLARATIONPARAMETER=74;
    public static final int T__145=145;
    public static final int BREAKALL=40;
    public static final int T__140=140;
    public static final int T__142=142;
    public static final int VAR=49;
    public static final int MODELDECLARATIONPARAMETERS=73;
    public static final int T__141=141;
    public static final int THROW=54;
    public static final int EGXMODULE=89;
    public static final int PARAMLIST=25;
    public static final int EXPRLIST=55;
    public static final int EXPRRANGE=56;
    public static final int BREAK=39;
    public static final int ELSE=32;
    public static final int T__137=137;
    public static final int T__136=136;
    public static final int FORMAL=24;
    public static final int IF=31;
    public static final int MultiplicativeExpression=58;
    public static final int TYPE=66;
    public static final int T__139=139;
    public static final int T__138=138;
    public static final int T__133=133;
    public static final int T__132=132;
    public static final int T__135=135;
    public static final int T__134=134;
    public static final int T__131=131;
    public static final int NewExpression=48;
    public static final int T__130=130;
    public static final int CASE=36;
    public static final int Letter=16;
    public static final int LINE_COMMENT=22;
    public static final int T__129=129;
    public static final int T__126=126;
    public static final int JavaIDDigit=18;
    public static final int T__125=125;
    public static final int LAMBDAEXPR=65;
    public static final int MAP=76;
    public static final int T__128=128;
    public static final int T__127=127;
    public static final int T__166=166;
    public static final int T__165=165;
    public static final int T__168=168;
    public static final int DOMAIN=86;
    public static final int T__167=167;
    public static final int T__162=162;
    public static final int T__161=161;
    public static final int MERGE=88;
    public static final int T__164=164;
    public static final int MODELDECLARATION=69;
    public static final int T__163=163;
    public static final int EXPRESSIONINBRACKETS=60;
    public static final int T__160=160;
    public static final int TERNARY=33;
    public static final int TRANSACTION=42;
    public static final int FLOAT_TYPE_SUFFIX=7;
    public static final int ITEMSELECTOR=75;
    public static final int COMMENT=21;
    public static final int ModelElementType=46;
    public static final int IMPORT=68;
    public static final int DELETE=53;
    public static final int ARROW=11;
    public static final int T__159=159;
    public static final int T__158=158;
    public static final int T__155=155;
    public static final int SPECIAL_ASSIGNMENT=27;
    public static final int T__154=154;
    public static final int T__157=157;
    public static final int T__156=156;
    public static final int T__151=151;
    public static final int T__150=150;
    public static final int T__153=153;
    public static final int T__152=152;
    public static final int Annotation=23;
    public static final int CONTINUE=41;
    public static final int ENUMERATION_VALUE=67;
    public static final int OPERATOR=59;
    public static final int EXPONENT=6;
    public static final int STRING=14;
    public static final int T__148=148;
    public static final int T__147=147;
    public static final int T__149=149;
    public static final int T__91=91;
    public static final int T__100=100;
    public static final int NAMESPACE=70;
    public static final int TARGET=84;
    public static final int T__92=92;
    public static final int COLLECTION=43;
    public static final int NEW=50;
    public static final int EXTENDS=81;
    public static final int T__93=93;
    public static final int T__102=102;
    public static final int PRE=79;
    public static final int T__94=94;
    public static final int T__101=101;
    public static final int POST=80;
    public static final int T__90=90;
    public static final int ALIAS=71;
    public static final int DRIVER=72;
    public static final int KEYVAL=77;
    public static final int POINT_POINT=10;
    public static final int GUARD=82;
    public static final int T__99=99;
    public static final int TEMPLATE=85;
    public static final int T__95=95;
    public static final int HELPERMETHOD=28;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int StatementBlock=29;
    public static final int T__98=98;
    public static final int T__177=177;
    public static final int T__176=176;
    public static final int ABORT=44;
    public static final int T__173=173;
    public static final int StrangeNameLiteral=15;
    public static final int T__172=172;
    public static final int T__175=175;
    public static final int T__174=174;
    public static final int FOR=30;
    public static final int BLOCK=63;
    public static final int T__171=171;
    public static final int T__170=170;
    public static final int PARAMETERS=47;
    public static final int SpecialNameChar=17;
    public static final int BOOLEAN=12;
    public static final int NAME=19;
    public static final int SWITCH=35;
    public static final int T__169=169;
    public static final int FeatureCall=61;
    public static final int T__122=122;
    public static final int T__121=121;
    public static final int T__124=124;
    public static final int FLOAT=4;
    public static final int T__123=123;
    public static final int OVERWRITE=87;
    public static final int T__120=120;
    public static final int NativeType=57;
    public static final int INT=8;
    public static final int ANNOTATIONBLOCK=51;
    public static final int RETURN=38;
    public static final int KEYVALLIST=78;
    public static final int FEATURECALL=64;
    public static final int CollectionType=45;
    public static final int T__119=119;
    public static final int ASSIGNMENT=26;
    public static final int T__118=118;
    public static final int T__115=115;
    public static final int WS=20;
    public static final int EOF=-1;
    public static final int T__114=114;
    public static final int T__117=117;
    public static final int T__116=116;
    public static final int T__111=111;
    public static final int T__110=110;
    public static final int T__113=113;
    public static final int T__112=112;
    public static final int EscapeSequence=13;
    public static final int EOLMODULE=62;
    public static final int DIGIT=5;
    public static final int EXECUTABLEANNOTATION=52;
    public static final int T__108=108;
    public static final int T__107=107;
    public static final int WHILE=34;
    public static final int T__109=109;
    public static final int GENERATE=83;
    public static final int T__104=104;
    public static final int POINT=9;
    public static final int T__103=103;
    public static final int T__106=106;
    public static final int DEFAULT=37;
    public static final int T__105=105;

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
    // EolParserRules.g:107:1: operationDeclarationOrAnnotationBlock : ( operationDeclaration | annotationBlock );
    public final Egx_EolParserRules.operationDeclarationOrAnnotationBlock_return operationDeclarationOrAnnotationBlock() throws RecognitionException {
        Egx_EolParserRules.operationDeclarationOrAnnotationBlock_return retval = new Egx_EolParserRules.operationDeclarationOrAnnotationBlock_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Egx_EolParserRules.operationDeclaration_return operationDeclaration1 = null;

        Egx_EolParserRules.annotationBlock_return annotationBlock2 = null;



        try {
            // EolParserRules.g:108:2: ( operationDeclaration | annotationBlock )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( ((LA1_0>=98 && LA1_0<=99)) ) {
                alt1=1;
            }
            else if ( (LA1_0==Annotation||LA1_0==104) ) {
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
                    // EolParserRules.g:108:4: operationDeclaration
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_operationDeclaration_in_operationDeclarationOrAnnotationBlock263);
                    operationDeclaration1=operationDeclaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, operationDeclaration1.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:108:27: annotationBlock
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_annotationBlock_in_operationDeclarationOrAnnotationBlock267);
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
    // EolParserRules.g:111:1: modelDeclaration : m= 'model' NAME ( modelAlias )? ( modelDriver )? ( modelDeclarationParameters )? sem= ';' ;
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
            // EolParserRules.g:116:2: (m= 'model' NAME ( modelAlias )? ( modelDriver )? ( modelDeclarationParameters )? sem= ';' )
            // EolParserRules.g:116:4: m= 'model' NAME ( modelAlias )? ( modelDriver )? ( modelDeclarationParameters )? sem= ';'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            m=(Token)match(input,90,FOLLOW_90_in_modelDeclaration286); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            m_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(m);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(m_tree, root_0);
            }
            NAME3=(Token)match(input,NAME,FOLLOW_NAME_in_modelDeclaration289); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME3_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(NAME3);
            adaptor.addChild(root_0, NAME3_tree);
            }
            // EolParserRules.g:116:20: ( modelAlias )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==92) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // EolParserRules.g:0:0: modelAlias
                    {
                    pushFollow(FOLLOW_modelAlias_in_modelDeclaration291);
                    modelAlias4=modelAlias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, modelAlias4.getTree());

                    }
                    break;

            }

            // EolParserRules.g:116:32: ( modelDriver )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==94) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // EolParserRules.g:0:0: modelDriver
                    {
                    pushFollow(FOLLOW_modelDriver_in_modelDeclaration294);
                    modelDriver5=modelDriver();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, modelDriver5.getTree());

                    }
                    break;

            }

            // EolParserRules.g:116:45: ( modelDeclarationParameters )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==95) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // EolParserRules.g:0:0: modelDeclarationParameters
                    {
                    pushFollow(FOLLOW_modelDeclarationParameters_in_modelDeclaration297);
                    modelDeclarationParameters6=modelDeclarationParameters();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, modelDeclarationParameters6.getTree());

                    }
                    break;

            }

            sem=(Token)match(input,91,FOLLOW_91_in_modelDeclaration302); if (state.failed) return retval;

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
    // EolParserRules.g:119:1: modelAlias : a= 'alias' NAME ( ',' NAME )* ;
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
            // EolParserRules.g:120:2: (a= 'alias' NAME ( ',' NAME )* )
            // EolParserRules.g:120:5: a= 'alias' NAME ( ',' NAME )*
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            a=(Token)match(input,92,FOLLOW_92_in_modelAlias317); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            a_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(a);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(a_tree, root_0);
            }
            NAME7=(Token)match(input,NAME,FOLLOW_NAME_in_modelAlias320); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME7_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(NAME7);
            adaptor.addChild(root_0, NAME7_tree);
            }
            // EolParserRules.g:120:21: ( ',' NAME )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==93) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // EolParserRules.g:120:22: ',' NAME
            	    {
            	    char_literal8=(Token)match(input,93,FOLLOW_93_in_modelAlias323); if (state.failed) return retval;
            	    NAME9=(Token)match(input,NAME,FOLLOW_NAME_in_modelAlias326); if (state.failed) return retval;
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
    // EolParserRules.g:124:1: modelDriver : d= 'driver' NAME ;
    public final Egx_EolParserRules.modelDriver_return modelDriver() throws RecognitionException {
        Egx_EolParserRules.modelDriver_return retval = new Egx_EolParserRules.modelDriver_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token d=null;
        Token NAME10=null;

        org.eclipse.epsilon.common.parse.AST d_tree=null;
        org.eclipse.epsilon.common.parse.AST NAME10_tree=null;

        try {
            // EolParserRules.g:125:2: (d= 'driver' NAME )
            // EolParserRules.g:125:5: d= 'driver' NAME
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            d=(Token)match(input,94,FOLLOW_94_in_modelDriver345); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            d_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(d);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(d_tree, root_0);
            }
            NAME10=(Token)match(input,NAME,FOLLOW_NAME_in_modelDriver348); if (state.failed) return retval;
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
    // EolParserRules.g:129:1: modelDeclarationParameters : s= '{' ( modelDeclarationParameter )? ( ',' modelDeclarationParameter )* cb= '}' ;
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
            // EolParserRules.g:134:2: (s= '{' ( modelDeclarationParameter )? ( ',' modelDeclarationParameter )* cb= '}' )
            // EolParserRules.g:134:4: s= '{' ( modelDeclarationParameter )? ( ',' modelDeclarationParameter )* cb= '}'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            s=(Token)match(input,95,FOLLOW_95_in_modelDeclarationParameters370); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            s_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(s);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(s_tree, root_0);
            }
            // EolParserRules.g:134:11: ( modelDeclarationParameter )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==NAME) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // EolParserRules.g:0:0: modelDeclarationParameter
                    {
                    pushFollow(FOLLOW_modelDeclarationParameter_in_modelDeclarationParameters373);
                    modelDeclarationParameter11=modelDeclarationParameter();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, modelDeclarationParameter11.getTree());

                    }
                    break;

            }

            // EolParserRules.g:134:38: ( ',' modelDeclarationParameter )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==93) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // EolParserRules.g:134:39: ',' modelDeclarationParameter
            	    {
            	    char_literal12=(Token)match(input,93,FOLLOW_93_in_modelDeclarationParameters377); if (state.failed) return retval;
            	    pushFollow(FOLLOW_modelDeclarationParameter_in_modelDeclarationParameters380);
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

            cb=(Token)match(input,96,FOLLOW_96_in_modelDeclarationParameters386); if (state.failed) return retval;

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
    // EolParserRules.g:137:1: modelDeclarationParameter : NAME e= '=' STRING ;
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
            // EolParserRules.g:138:2: ( NAME e= '=' STRING )
            // EolParserRules.g:138:4: NAME e= '=' STRING
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            NAME14=(Token)match(input,NAME,FOLLOW_NAME_in_modelDeclarationParameter399); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME14_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(NAME14);
            adaptor.addChild(root_0, NAME14_tree);
            }
            e=(Token)match(input,97,FOLLOW_97_in_modelDeclarationParameter403); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            e_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(e);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(e_tree, root_0);
            }
            STRING15=(Token)match(input,STRING,FOLLOW_STRING_in_modelDeclarationParameter406); if (state.failed) return retval;
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
    // EolParserRules.g:142:1: operationDeclaration : ( 'operation' | 'function' ) (ctx= typeName )? operationName= NAME op= '(' ( formalParameterList )? cp= ')' ( ':' returnType= typeName )? statementBlock ;
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
            // EolParserRules.g:147:2: ( ( 'operation' | 'function' ) (ctx= typeName )? operationName= NAME op= '(' ( formalParameterList )? cp= ')' ( ':' returnType= typeName )? statementBlock )
            // EolParserRules.g:147:4: ( 'operation' | 'function' ) (ctx= typeName )? operationName= NAME op= '(' ( formalParameterList )? cp= ')' ( ':' returnType= typeName )? statementBlock
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            set16=(Token)input.LT(1);
            set16=(Token)input.LT(1);
            if ( (input.LA(1)>=98 && input.LA(1)<=99) ) {
                input.consume();
                if ( state.backtracking==0 ) root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot((org.eclipse.epsilon.common.parse.AST)adaptor.create(set16), root_0);
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            // EolParserRules.g:147:30: (ctx= typeName )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==NAME) ) {
                int LA8_1 = input.LA(2);

                if ( (LA8_1==NAME||(LA8_1>=105 && LA8_1<=107)) ) {
                    alt8=1;
                }
            }
            else if ( ((LA8_0>=108 && LA8_0<=118)) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // EolParserRules.g:147:31: ctx= typeName
                    {
                    pushFollow(FOLLOW_typeName_in_operationDeclaration437);
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

            operationName=(Token)match(input,NAME,FOLLOW_NAME_in_operationDeclaration447); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            operationName_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(operationName);
            adaptor.addChild(root_0, operationName_tree);
            }
            op=(Token)match(input,100,FOLLOW_100_in_operationDeclaration451); if (state.failed) return retval;
            // EolParserRules.g:148:30: ( formalParameterList )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==NAME) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // EolParserRules.g:0:0: formalParameterList
                    {
                    pushFollow(FOLLOW_formalParameterList_in_operationDeclaration454);
                    formalParameterList17=formalParameterList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, formalParameterList17.getTree());

                    }
                    break;

            }

            cp=(Token)match(input,101,FOLLOW_101_in_operationDeclaration459); if (state.failed) return retval;
            // EolParserRules.g:149:3: ( ':' returnType= typeName )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==102) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // EolParserRules.g:149:4: ':' returnType= typeName
                    {
                    char_literal18=(Token)match(input,102,FOLLOW_102_in_operationDeclaration465); if (state.failed) return retval;
                    pushFollow(FOLLOW_typeName_in_operationDeclaration470);
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

            pushFollow(FOLLOW_statementBlock_in_operationDeclaration476);
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
    // EolParserRules.g:152:1: importStatement : i= 'import' STRING sem= ';' ;
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
            // EolParserRules.g:156:2: (i= 'import' STRING sem= ';' )
            // EolParserRules.g:156:4: i= 'import' STRING sem= ';'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            i=(Token)match(input,103,FOLLOW_103_in_importStatement496); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            i_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(i);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(i_tree, root_0);
            }
            STRING20=(Token)match(input,STRING,FOLLOW_STRING_in_importStatement499); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STRING20_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(STRING20);
            adaptor.addChild(root_0, STRING20_tree);
            }
            sem=(Token)match(input,91,FOLLOW_91_in_importStatement503); if (state.failed) return retval;
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
    // EolParserRules.g:160:1: block : ( statement )* -> ^( BLOCK ( statement )* ) ;
    public final Egx_EolParserRules.block_return block() throws RecognitionException {
        Egx_EolParserRules.block_return retval = new Egx_EolParserRules.block_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Egx_EolParserRules.statement_return statement21 = null;


        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        try {
            // EolParserRules.g:164:2: ( ( statement )* -> ^( BLOCK ( statement )* ) )
            // EolParserRules.g:164:4: ( statement )*
            {
            // EolParserRules.g:164:4: ( statement )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==FLOAT||LA11_0==INT||LA11_0==BOOLEAN||LA11_0==STRING||LA11_0==NAME||LA11_0==100||(LA11_0>=108 && LA11_0<=118)||LA11_0==121||LA11_0==123||LA11_0==126||(LA11_0>=128 && LA11_0<=136)||LA11_0==153||LA11_0==156||(LA11_0>=163 && LA11_0<=165)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // EolParserRules.g:0:0: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_block524);
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
            // 165:2: -> ^( BLOCK ( statement )* )
            {
                // EolParserRules.g:165:5: ^( BLOCK ( statement )* )
                {
                org.eclipse.epsilon.common.parse.AST root_1 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();
                root_1 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot((org.eclipse.epsilon.common.parse.AST)adaptor.create(BLOCK, "BLOCK"), root_1);

                // EolParserRules.g:165:13: ( statement )*
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
    // EolParserRules.g:168:1: statementBlock : s= '{' block e= '}' ;
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
            // EolParserRules.g:173:2: (s= '{' block e= '}' )
            // EolParserRules.g:173:4: s= '{' block e= '}'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            s=(Token)match(input,95,FOLLOW_95_in_statementBlock554); if (state.failed) return retval;
            pushFollow(FOLLOW_block_in_statementBlock557);
            block22=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, block22.getTree());
            e=(Token)match(input,96,FOLLOW_96_in_statementBlock561); if (state.failed) return retval;

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
    // EolParserRules.g:176:1: formalParameter : NAME ( ':' pt= typeName )? -> ^( FORMAL NAME ( typeName )? ) ;
    public final Egx_EolParserRules.formalParameter_return formalParameter() throws RecognitionException {
        Egx_EolParserRules.formalParameter_return retval = new Egx_EolParserRules.formalParameter_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token NAME23=null;
        Token char_literal24=null;
        Egx_EolParserRules.typeName_return pt = null;


        org.eclipse.epsilon.common.parse.AST NAME23_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal24_tree=null;
        RewriteRuleTokenStream stream_102=new RewriteRuleTokenStream(adaptor,"token 102");
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleSubtreeStream stream_typeName=new RewriteRuleSubtreeStream(adaptor,"rule typeName");
        try {
            // EolParserRules.g:180:2: ( NAME ( ':' pt= typeName )? -> ^( FORMAL NAME ( typeName )? ) )
            // EolParserRules.g:180:4: NAME ( ':' pt= typeName )?
            {
            NAME23=(Token)match(input,NAME,FOLLOW_NAME_in_formalParameter579); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(NAME23);

            // EolParserRules.g:180:9: ( ':' pt= typeName )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==102) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // EolParserRules.g:180:10: ':' pt= typeName
                    {
                    char_literal24=(Token)match(input,102,FOLLOW_102_in_formalParameter582); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_102.add(char_literal24);

                    pushFollow(FOLLOW_typeName_in_formalParameter586);
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
            // elements: NAME, typeName
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();
            // 181:3: -> ^( FORMAL NAME ( typeName )? )
            {
                // EolParserRules.g:181:6: ^( FORMAL NAME ( typeName )? )
                {
                org.eclipse.epsilon.common.parse.AST root_1 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();
                root_1 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot((org.eclipse.epsilon.common.parse.AST)adaptor.create(FORMAL, "FORMAL"), root_1);

                adaptor.addChild(root_1, stream_NAME.nextNode());
                // EolParserRules.g:181:20: ( typeName )?
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
    // EolParserRules.g:184:1: formalParameterList : formalParameter ( ',' formalParameter )* -> ^( PARAMLIST ( formalParameter )* ) ;
    public final Egx_EolParserRules.formalParameterList_return formalParameterList() throws RecognitionException {
        Egx_EolParserRules.formalParameterList_return retval = new Egx_EolParserRules.formalParameterList_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token char_literal26=null;
        Egx_EolParserRules.formalParameter_return formalParameter25 = null;

        Egx_EolParserRules.formalParameter_return formalParameter27 = null;


        org.eclipse.epsilon.common.parse.AST char_literal26_tree=null;
        RewriteRuleTokenStream stream_93=new RewriteRuleTokenStream(adaptor,"token 93");
        RewriteRuleSubtreeStream stream_formalParameter=new RewriteRuleSubtreeStream(adaptor,"rule formalParameter");
        try {
            // EolParserRules.g:188:2: ( formalParameter ( ',' formalParameter )* -> ^( PARAMLIST ( formalParameter )* ) )
            // EolParserRules.g:188:4: formalParameter ( ',' formalParameter )*
            {
            pushFollow(FOLLOW_formalParameter_in_formalParameterList620);
            formalParameter25=formalParameter();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_formalParameter.add(formalParameter25.getTree());
            // EolParserRules.g:188:20: ( ',' formalParameter )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==93) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // EolParserRules.g:188:21: ',' formalParameter
            	    {
            	    char_literal26=(Token)match(input,93,FOLLOW_93_in_formalParameterList623); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_93.add(char_literal26);

            	    pushFollow(FOLLOW_formalParameter_in_formalParameterList625);
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
            // 189:2: -> ^( PARAMLIST ( formalParameter )* )
            {
                // EolParserRules.g:189:5: ^( PARAMLIST ( formalParameter )* )
                {
                org.eclipse.epsilon.common.parse.AST root_1 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();
                root_1 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot((org.eclipse.epsilon.common.parse.AST)adaptor.create(PARAMLIST, "PARAMLIST"), root_1);

                // EolParserRules.g:189:17: ( formalParameter )*
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
    // EolParserRules.g:192:1: executableAnnotation : d= '$' x= . logicalExpression ;
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
            // EolParserRules.g:193:2: (d= '$' x= . logicalExpression )
            // EolParserRules.g:193:4: d= '$' x= . logicalExpression
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            d=(Token)match(input,104,FOLLOW_104_in_executableAnnotation650); if (state.failed) return retval;
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
            pushFollow(FOLLOW_logicalExpression_in_executableAnnotation657);
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
    // EolParserRules.g:197:1: annotation : ( Annotation | executableAnnotation );
    public final Egx_EolParserRules.annotation_return annotation() throws RecognitionException {
        Egx_EolParserRules.annotation_return retval = new Egx_EolParserRules.annotation_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token Annotation29=null;
        Egx_EolParserRules.executableAnnotation_return executableAnnotation30 = null;


        org.eclipse.epsilon.common.parse.AST Annotation29_tree=null;

        try {
            // EolParserRules.g:198:2: ( Annotation | executableAnnotation )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==Annotation) ) {
                alt14=1;
            }
            else if ( (LA14_0==104) ) {
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
                    // EolParserRules.g:198:4: Annotation
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    Annotation29=(Token)match(input,Annotation,FOLLOW_Annotation_in_annotation671); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    Annotation29_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(Annotation29);
                    adaptor.addChild(root_0, Annotation29_tree);
                    }

                    }
                    break;
                case 2 :
                    // EolParserRules.g:198:17: executableAnnotation
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_executableAnnotation_in_annotation675);
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
    // EolParserRules.g:201:1: annotationBlock : ( annotation )+ -> ^( ANNOTATIONBLOCK ( annotation )+ ) ;
    public final Egx_EolParserRules.annotationBlock_return annotationBlock() throws RecognitionException {
        Egx_EolParserRules.annotationBlock_return retval = new Egx_EolParserRules.annotationBlock_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Egx_EolParserRules.annotation_return annotation31 = null;


        RewriteRuleSubtreeStream stream_annotation=new RewriteRuleSubtreeStream(adaptor,"rule annotation");
        try {
            // EolParserRules.g:205:2: ( ( annotation )+ -> ^( ANNOTATIONBLOCK ( annotation )+ ) )
            // EolParserRules.g:205:4: ( annotation )+
            {
            // EolParserRules.g:205:4: ( annotation )+
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
                else if ( (LA15_0==104) ) {
                    int LA15_3 = input.LA(2);

                    if ( (synpred16_EolParserRules()) ) {
                        alt15=1;
                    }


                }


                switch (alt15) {
            	case 1 :
            	    // EolParserRules.g:0:0: annotation
            	    {
            	    pushFollow(FOLLOW_annotation_in_annotationBlock692);
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
            // 206:2: -> ^( ANNOTATIONBLOCK ( annotation )+ )
            {
                // EolParserRules.g:206:5: ^( ANNOTATIONBLOCK ( annotation )+ )
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
    // EolParserRules.g:209:1: typeName : ( pathName | nativeType | collectionType );
    public final Egx_EolParserRules.typeName_return typeName() throws RecognitionException {
        Egx_EolParserRules.typeName_return retval = new Egx_EolParserRules.typeName_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Egx_EolParserRules.pathName_return pathName32 = null;

        Egx_EolParserRules.nativeType_return nativeType33 = null;

        Egx_EolParserRules.collectionType_return collectionType34 = null;



        try {
            // EolParserRules.g:213:2: ( pathName | nativeType | collectionType )
            int alt16=3;
            switch ( input.LA(1) ) {
            case NAME:
                {
                alt16=1;
                }
                break;
            case 108:
                {
                alt16=2;
                }
                break;
            case 109:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
            case 115:
            case 116:
            case 117:
            case 118:
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
                    // EolParserRules.g:213:4: pathName
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_pathName_in_typeName721);
                    pathName32=pathName();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pathName32.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:213:15: nativeType
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_nativeType_in_typeName725);
                    nativeType33=nativeType();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nativeType33.getTree());

                    }
                    break;
                case 3 :
                    // EolParserRules.g:213:28: collectionType
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_collectionType_in_typeName729);
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
    // EolParserRules.g:216:1: pathName : (metamodel= NAME '!' )? head= packagedType ( '#' label= NAME )? ;
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
            // EolParserRules.g:217:2: ( (metamodel= NAME '!' )? head= packagedType ( '#' label= NAME )? )
            // EolParserRules.g:217:4: (metamodel= NAME '!' )? head= packagedType ( '#' label= NAME )?
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            // EolParserRules.g:217:4: (metamodel= NAME '!' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==NAME) ) {
                int LA17_1 = input.LA(2);

                if ( (LA17_1==105) ) {
                    alt17=1;
                }
            }
            switch (alt17) {
                case 1 :
                    // EolParserRules.g:217:5: metamodel= NAME '!'
                    {
                    metamodel=(Token)match(input,NAME,FOLLOW_NAME_in_pathName743); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    metamodel_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(metamodel);
                    adaptor.addChild(root_0, metamodel_tree);
                    }
                    char_literal35=(Token)match(input,105,FOLLOW_105_in_pathName745); if (state.failed) return retval;

                    }
                    break;

            }

            pushFollow(FOLLOW_packagedType_in_pathName754);
            head=packagedType();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(head.getTree(), root_0);
            // EolParserRules.g:219:3: ( '#' label= NAME )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==106) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // EolParserRules.g:219:4: '#' label= NAME
                    {
                    char_literal36=(Token)match(input,106,FOLLOW_106_in_pathName760); if (state.failed) return retval;
                    label=(Token)match(input,NAME,FOLLOW_NAME_in_pathName765); if (state.failed) return retval;
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
    // EolParserRules.g:233:1: packagedType : head= NAME ( '::' field= NAME )* ;
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
            // EolParserRules.g:234:2: (head= NAME ( '::' field= NAME )* )
            // EolParserRules.g:234:4: head= NAME ( '::' field= NAME )*
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            head=(Token)match(input,NAME,FOLLOW_NAME_in_packagedType786); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            head_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(head);
            adaptor.addChild(root_0, head_tree);
            }
            // EolParserRules.g:234:14: ( '::' field= NAME )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==107) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // EolParserRules.g:234:15: '::' field= NAME
            	    {
            	    string_literal37=(Token)match(input,107,FOLLOW_107_in_packagedType789); if (state.failed) return retval;
            	    field=(Token)match(input,NAME,FOLLOW_NAME_in_packagedType794); if (state.failed) return retval;
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
    // EolParserRules.g:242:1: nativeType : 'Native' s= '(' STRING e= ')' ;
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
            // EolParserRules.g:248:2: ( 'Native' s= '(' STRING e= ')' )
            // EolParserRules.g:248:4: 'Native' s= '(' STRING e= ')'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            string_literal38=(Token)match(input,108,FOLLOW_108_in_nativeType823); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal38_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(string_literal38);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(string_literal38_tree, root_0);
            }
            s=(Token)match(input,100,FOLLOW_100_in_nativeType828); if (state.failed) return retval;
            STRING39=(Token)match(input,STRING,FOLLOW_STRING_in_nativeType831); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STRING39_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(STRING39);
            adaptor.addChild(root_0, STRING39_tree);
            }
            e=(Token)match(input,101,FOLLOW_101_in_nativeType835); if (state.failed) return retval;

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
    // EolParserRules.g:251:1: collectionType : ( 'Collection' | 'Sequence' | 'List' | 'Bag' | 'Set' | 'OrderedSet' | 'Map' | 'ConcurrentMap' | 'ConcurrentBag' | 'ConcurrentSet' ) ( (op= '(' tn= typeName ( ',' tn= typeName )* cp= ')' ) | (op= '<' tn= typeName ( ',' tn= typeName )* cp= '>' ) )? ;
    public final Egx_EolParserRules.collectionType_return collectionType() throws RecognitionException {
        Egx_EolParserRules.collectionType_return retval = new Egx_EolParserRules.collectionType_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token op=null;
        Token cp=null;
        Token set40=null;
        Token char_literal41=null;
        Token char_literal42=null;
        Egx_EolParserRules.typeName_return tn = null;


        org.eclipse.epsilon.common.parse.AST op_tree=null;
        org.eclipse.epsilon.common.parse.AST cp_tree=null;
        org.eclipse.epsilon.common.parse.AST set40_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal41_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal42_tree=null;

        try {
            // EolParserRules.g:257:2: ( ( 'Collection' | 'Sequence' | 'List' | 'Bag' | 'Set' | 'OrderedSet' | 'Map' | 'ConcurrentMap' | 'ConcurrentBag' | 'ConcurrentSet' ) ( (op= '(' tn= typeName ( ',' tn= typeName )* cp= ')' ) | (op= '<' tn= typeName ( ',' tn= typeName )* cp= '>' ) )? )
            // EolParserRules.g:257:5: ( 'Collection' | 'Sequence' | 'List' | 'Bag' | 'Set' | 'OrderedSet' | 'Map' | 'ConcurrentMap' | 'ConcurrentBag' | 'ConcurrentSet' ) ( (op= '(' tn= typeName ( ',' tn= typeName )* cp= ')' ) | (op= '<' tn= typeName ( ',' tn= typeName )* cp= '>' ) )?
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            set40=(Token)input.LT(1);
            set40=(Token)input.LT(1);
            if ( (input.LA(1)>=109 && input.LA(1)<=118) ) {
                input.consume();
                if ( state.backtracking==0 ) root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot((org.eclipse.epsilon.common.parse.AST)adaptor.create(set40), root_0);
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            // EolParserRules.g:258:3: ( (op= '(' tn= typeName ( ',' tn= typeName )* cp= ')' ) | (op= '<' tn= typeName ( ',' tn= typeName )* cp= '>' ) )?
            int alt22=3;
            alt22 = dfa22.predict(input);
            switch (alt22) {
                case 1 :
                    // EolParserRules.g:258:4: (op= '(' tn= typeName ( ',' tn= typeName )* cp= ')' )
                    {
                    // EolParserRules.g:258:4: (op= '(' tn= typeName ( ',' tn= typeName )* cp= ')' )
                    // EolParserRules.g:258:5: op= '(' tn= typeName ( ',' tn= typeName )* cp= ')'
                    {
                    op=(Token)match(input,100,FOLLOW_100_in_collectionType883); if (state.failed) return retval;
                    pushFollow(FOLLOW_typeName_in_collectionType888);
                    tn=typeName();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, tn.getTree());
                    if ( state.backtracking==0 ) {
                      setTokenType(tn,TYPE);
                    }
                    // EolParserRules.g:258:50: ( ',' tn= typeName )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==93) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // EolParserRules.g:258:51: ',' tn= typeName
                    	    {
                    	    char_literal41=(Token)match(input,93,FOLLOW_93_in_collectionType893); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal41_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(char_literal41);
                    	    adaptor.addChild(root_0, char_literal41_tree);
                    	    }
                    	    pushFollow(FOLLOW_typeName_in_collectionType897);
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

                    cp=(Token)match(input,101,FOLLOW_101_in_collectionType905); if (state.failed) return retval;

                    }


                    }
                    break;
                case 2 :
                    // EolParserRules.g:259:4: (op= '<' tn= typeName ( ',' tn= typeName )* cp= '>' )
                    {
                    // EolParserRules.g:259:4: (op= '<' tn= typeName ( ',' tn= typeName )* cp= '>' )
                    // EolParserRules.g:259:5: op= '<' tn= typeName ( ',' tn= typeName )* cp= '>'
                    {
                    op=(Token)match(input,119,FOLLOW_119_in_collectionType917); if (state.failed) return retval;
                    pushFollow(FOLLOW_typeName_in_collectionType922);
                    tn=typeName();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, tn.getTree());
                    if ( state.backtracking==0 ) {
                      setTokenType(tn,TYPE);
                    }
                    // EolParserRules.g:259:50: ( ',' tn= typeName )*
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==93) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // EolParserRules.g:259:51: ',' tn= typeName
                    	    {
                    	    char_literal42=(Token)match(input,93,FOLLOW_93_in_collectionType927); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal42_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(char_literal42);
                    	    adaptor.addChild(root_0, char_literal42_tree);
                    	    }
                    	    pushFollow(FOLLOW_typeName_in_collectionType931);
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
                    	    break loop21;
                        }
                    } while (true);

                    cp=(Token)match(input,120,FOLLOW_120_in_collectionType939); if (state.failed) return retval;

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
    // EolParserRules.g:263:1: statement : ( statementA | statementB );
    public final Egx_EolParserRules.statement_return statement() throws RecognitionException {
        Egx_EolParserRules.statement_return retval = new Egx_EolParserRules.statement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Egx_EolParserRules.statementA_return statementA43 = null;

        Egx_EolParserRules.statementB_return statementB44 = null;



        try {
            // EolParserRules.g:264:2: ( statementA | statementB )
            int alt23=2;
            alt23 = dfa23.predict(input);
            switch (alt23) {
                case 1 :
                    // EolParserRules.g:264:4: statementA
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_statementA_in_statement958);
                    statementA43=statementA();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statementA43.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:264:17: statementB
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_statementB_in_statement962);
                    statementB44=statementB();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statementB44.getTree());

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
    // EolParserRules.g:267:1: statementA : ( assignmentStatement | expressionStatement | forStatement | ifStatement | whileStatement | switchStatement | returnStatement | breakStatement );
    public final Egx_EolParserRules.statementA_return statementA() throws RecognitionException {
        Egx_EolParserRules.statementA_return retval = new Egx_EolParserRules.statementA_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Egx_EolParserRules.assignmentStatement_return assignmentStatement45 = null;

        Egx_EolParserRules.expressionStatement_return expressionStatement46 = null;

        Egx_EolParserRules.forStatement_return forStatement47 = null;

        Egx_EolParserRules.ifStatement_return ifStatement48 = null;

        Egx_EolParserRules.whileStatement_return whileStatement49 = null;

        Egx_EolParserRules.switchStatement_return switchStatement50 = null;

        Egx_EolParserRules.returnStatement_return returnStatement51 = null;

        Egx_EolParserRules.breakStatement_return breakStatement52 = null;



        try {
            // EolParserRules.g:268:2: ( assignmentStatement | expressionStatement | forStatement | ifStatement | whileStatement | switchStatement | returnStatement | breakStatement )
            int alt24=8;
            alt24 = dfa24.predict(input);
            switch (alt24) {
                case 1 :
                    // EolParserRules.g:268:4: assignmentStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_assignmentStatement_in_statementA973);
                    assignmentStatement45=assignmentStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, assignmentStatement45.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:268:26: expressionStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_expressionStatement_in_statementA977);
                    expressionStatement46=expressionStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionStatement46.getTree());

                    }
                    break;
                case 3 :
                    // EolParserRules.g:268:48: forStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_forStatement_in_statementA981);
                    forStatement47=forStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, forStatement47.getTree());

                    }
                    break;
                case 4 :
                    // EolParserRules.g:269:5: ifStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_ifStatement_in_statementA987);
                    ifStatement48=ifStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, ifStatement48.getTree());

                    }
                    break;
                case 5 :
                    // EolParserRules.g:269:19: whileStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_whileStatement_in_statementA991);
                    whileStatement49=whileStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, whileStatement49.getTree());

                    }
                    break;
                case 6 :
                    // EolParserRules.g:269:36: switchStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_switchStatement_in_statementA995);
                    switchStatement50=switchStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, switchStatement50.getTree());

                    }
                    break;
                case 7 :
                    // EolParserRules.g:269:54: returnStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_returnStatement_in_statementA999);
                    returnStatement51=returnStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, returnStatement51.getTree());

                    }
                    break;
                case 8 :
                    // EolParserRules.g:269:72: breakStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_breakStatement_in_statementA1003);
                    breakStatement52=breakStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, breakStatement52.getTree());

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
    // EolParserRules.g:272:1: statementB : ( breakAllStatement | returnStatement | transactionStatement | abortStatement | continueStatement | throwStatement | deleteStatement );
    public final Egx_EolParserRules.statementB_return statementB() throws RecognitionException {
        Egx_EolParserRules.statementB_return retval = new Egx_EolParserRules.statementB_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Egx_EolParserRules.breakAllStatement_return breakAllStatement53 = null;

        Egx_EolParserRules.returnStatement_return returnStatement54 = null;

        Egx_EolParserRules.transactionStatement_return transactionStatement55 = null;

        Egx_EolParserRules.abortStatement_return abortStatement56 = null;

        Egx_EolParserRules.continueStatement_return continueStatement57 = null;

        Egx_EolParserRules.throwStatement_return throwStatement58 = null;

        Egx_EolParserRules.deleteStatement_return deleteStatement59 = null;



        try {
            // EolParserRules.g:273:2: ( breakAllStatement | returnStatement | transactionStatement | abortStatement | continueStatement | throwStatement | deleteStatement )
            int alt25=7;
            switch ( input.LA(1) ) {
            case 133:
                {
                alt25=1;
                }
                break;
            case 129:
                {
                alt25=2;
                }
                break;
            case 136:
                {
                alt25=3;
                }
                break;
            case 135:
                {
                alt25=4;
                }
                break;
            case 134:
                {
                alt25=5;
                }
                break;
            case 130:
                {
                alt25=6;
                }
                break;
            case 131:
                {
                alt25=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }

            switch (alt25) {
                case 1 :
                    // EolParserRules.g:273:4: breakAllStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_breakAllStatement_in_statementB1015);
                    breakAllStatement53=breakAllStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, breakAllStatement53.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:273:24: returnStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_returnStatement_in_statementB1019);
                    returnStatement54=returnStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, returnStatement54.getTree());

                    }
                    break;
                case 3 :
                    // EolParserRules.g:273:42: transactionStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_transactionStatement_in_statementB1023);
                    transactionStatement55=transactionStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, transactionStatement55.getTree());

                    }
                    break;
                case 4 :
                    // EolParserRules.g:274:5: abortStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_abortStatement_in_statementB1029);
                    abortStatement56=abortStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, abortStatement56.getTree());

                    }
                    break;
                case 5 :
                    // EolParserRules.g:274:22: continueStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_continueStatement_in_statementB1033);
                    continueStatement57=continueStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, continueStatement57.getTree());

                    }
                    break;
                case 6 :
                    // EolParserRules.g:274:42: throwStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_throwStatement_in_statementB1037);
                    throwStatement58=throwStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, throwStatement58.getTree());

                    }
                    break;
                case 7 :
                    // EolParserRules.g:275:5: deleteStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_deleteStatement_in_statementB1043);
                    deleteStatement59=deleteStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, deleteStatement59.getTree());

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
    // EolParserRules.g:278:1: statementOrStatementBlock : ( statement | statementBlock );
    public final Egx_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock() throws RecognitionException {
        Egx_EolParserRules.statementOrStatementBlock_return retval = new Egx_EolParserRules.statementOrStatementBlock_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Egx_EolParserRules.statement_return statement60 = null;

        Egx_EolParserRules.statementBlock_return statementBlock61 = null;



        try {
            // EolParserRules.g:279:2: ( statement | statementBlock )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==FLOAT||LA26_0==INT||LA26_0==BOOLEAN||LA26_0==STRING||LA26_0==NAME||LA26_0==100||(LA26_0>=108 && LA26_0<=118)||LA26_0==121||LA26_0==123||LA26_0==126||(LA26_0>=128 && LA26_0<=136)||LA26_0==153||LA26_0==156||(LA26_0>=163 && LA26_0<=165)) ) {
                alt26=1;
            }
            else if ( (LA26_0==95) ) {
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
                    // EolParserRules.g:279:4: statement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_statement_in_statementOrStatementBlock1054);
                    statement60=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement60.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:279:16: statementBlock
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_statementBlock_in_statementOrStatementBlock1058);
                    statementBlock61=statementBlock();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statementBlock61.getTree());

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
    // EolParserRules.g:281:1: expressionOrStatementBlock : ( ':' logicalExpression | statementBlock );
    public final Egx_EolParserRules.expressionOrStatementBlock_return expressionOrStatementBlock() throws RecognitionException {
        Egx_EolParserRules.expressionOrStatementBlock_return retval = new Egx_EolParserRules.expressionOrStatementBlock_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token char_literal62=null;
        Egx_EolParserRules.logicalExpression_return logicalExpression63 = null;

        Egx_EolParserRules.statementBlock_return statementBlock64 = null;


        org.eclipse.epsilon.common.parse.AST char_literal62_tree=null;

        try {
            // EolParserRules.g:282:2: ( ':' logicalExpression | statementBlock )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==102) ) {
                alt27=1;
            }
            else if ( (LA27_0==95) ) {
                alt27=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // EolParserRules.g:282:4: ':' logicalExpression
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    char_literal62=(Token)match(input,102,FOLLOW_102_in_expressionOrStatementBlock1067); if (state.failed) return retval;
                    pushFollow(FOLLOW_logicalExpression_in_expressionOrStatementBlock1070);
                    logicalExpression63=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression63.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:282:29: statementBlock
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_statementBlock_in_expressionOrStatementBlock1074);
                    statementBlock64=statementBlock();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statementBlock64.getTree());

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

    public static class ifStatement_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ifStatement
    // EolParserRules.g:285:1: ifStatement : i= 'if' '(' logicalExpression ')' statementOrStatementBlock ( elseStatement )? ;
    public final Egx_EolParserRules.ifStatement_return ifStatement() throws RecognitionException {
        Egx_EolParserRules.ifStatement_return retval = new Egx_EolParserRules.ifStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token i=null;
        Token char_literal65=null;
        Token char_literal67=null;
        Egx_EolParserRules.logicalExpression_return logicalExpression66 = null;

        Egx_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock68 = null;

        Egx_EolParserRules.elseStatement_return elseStatement69 = null;


        org.eclipse.epsilon.common.parse.AST i_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal65_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal67_tree=null;

        try {
            // EolParserRules.g:286:2: (i= 'if' '(' logicalExpression ')' statementOrStatementBlock ( elseStatement )? )
            // EolParserRules.g:286:4: i= 'if' '(' logicalExpression ')' statementOrStatementBlock ( elseStatement )?
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            i=(Token)match(input,121,FOLLOW_121_in_ifStatement1087); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            i_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(i);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(i_tree, root_0);
            }
            char_literal65=(Token)match(input,100,FOLLOW_100_in_ifStatement1090); if (state.failed) return retval;
            pushFollow(FOLLOW_logicalExpression_in_ifStatement1093);
            logicalExpression66=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression66.getTree());
            char_literal67=(Token)match(input,101,FOLLOW_101_in_ifStatement1095); if (state.failed) return retval;
            pushFollow(FOLLOW_statementOrStatementBlock_in_ifStatement1098);
            statementOrStatementBlock68=statementOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, statementOrStatementBlock68.getTree());
            // EolParserRules.g:286:66: ( elseStatement )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==122) ) {
                int LA28_1 = input.LA(2);

                if ( (synpred51_EolParserRules()) ) {
                    alt28=1;
                }
            }
            switch (alt28) {
                case 1 :
                    // EolParserRules.g:0:0: elseStatement
                    {
                    pushFollow(FOLLOW_elseStatement_in_ifStatement1100);
                    elseStatement69=elseStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, elseStatement69.getTree());

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

    public static class elseStatement_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start elseStatement
    // EolParserRules.g:290:1: elseStatement : e= 'else' statementOrStatementBlock ;
    public final Egx_EolParserRules.elseStatement_return elseStatement() throws RecognitionException {
        Egx_EolParserRules.elseStatement_return retval = new Egx_EolParserRules.elseStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token e=null;
        Egx_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock70 = null;


        org.eclipse.epsilon.common.parse.AST e_tree=null;

        try {
            // EolParserRules.g:294:2: (e= 'else' statementOrStatementBlock )
            // EolParserRules.g:294:4: e= 'else' statementOrStatementBlock
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            e=(Token)match(input,122,FOLLOW_122_in_elseStatement1123); if (state.failed) return retval;
            pushFollow(FOLLOW_statementOrStatementBlock_in_elseStatement1126);
            statementOrStatementBlock70=statementOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, statementOrStatementBlock70.getTree());

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

    public static class switchStatement_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start switchStatement
    // EolParserRules.g:297:1: switchStatement : s= 'switch' '(' logicalExpression ')' '{' ( caseStatement )* ( defaultStatement )? '}' ;
    public final Egx_EolParserRules.switchStatement_return switchStatement() throws RecognitionException {
        Egx_EolParserRules.switchStatement_return retval = new Egx_EolParserRules.switchStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token s=null;
        Token char_literal71=null;
        Token char_literal73=null;
        Token char_literal74=null;
        Token char_literal77=null;
        Egx_EolParserRules.logicalExpression_return logicalExpression72 = null;

        Egx_EolParserRules.caseStatement_return caseStatement75 = null;

        Egx_EolParserRules.defaultStatement_return defaultStatement76 = null;


        org.eclipse.epsilon.common.parse.AST s_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal71_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal73_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal74_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal77_tree=null;

        try {
            // EolParserRules.g:298:2: (s= 'switch' '(' logicalExpression ')' '{' ( caseStatement )* ( defaultStatement )? '}' )
            // EolParserRules.g:298:4: s= 'switch' '(' logicalExpression ')' '{' ( caseStatement )* ( defaultStatement )? '}'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            s=(Token)match(input,123,FOLLOW_123_in_switchStatement1140); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            s_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(s);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(s_tree, root_0);
            }
            char_literal71=(Token)match(input,100,FOLLOW_100_in_switchStatement1143); if (state.failed) return retval;
            pushFollow(FOLLOW_logicalExpression_in_switchStatement1146);
            logicalExpression72=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression72.getTree());
            char_literal73=(Token)match(input,101,FOLLOW_101_in_switchStatement1148); if (state.failed) return retval;
            char_literal74=(Token)match(input,95,FOLLOW_95_in_switchStatement1151); if (state.failed) return retval;
            // EolParserRules.g:298:49: ( caseStatement )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==124) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // EolParserRules.g:0:0: caseStatement
            	    {
            	    pushFollow(FOLLOW_caseStatement_in_switchStatement1154);
            	    caseStatement75=caseStatement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, caseStatement75.getTree());

            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

            // EolParserRules.g:298:64: ( defaultStatement )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==125) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // EolParserRules.g:0:0: defaultStatement
                    {
                    pushFollow(FOLLOW_defaultStatement_in_switchStatement1157);
                    defaultStatement76=defaultStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, defaultStatement76.getTree());

                    }
                    break;

            }

            char_literal77=(Token)match(input,96,FOLLOW_96_in_switchStatement1160); if (state.failed) return retval;
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
    // EolParserRules.g:302:1: caseStatement : c= 'case' logicalExpression ':' ( block | statementBlock ) ;
    public final Egx_EolParserRules.caseStatement_return caseStatement() throws RecognitionException {
        Egx_EolParserRules.caseStatement_return retval = new Egx_EolParserRules.caseStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token c=null;
        Token char_literal79=null;
        Egx_EolParserRules.logicalExpression_return logicalExpression78 = null;

        Egx_EolParserRules.block_return block80 = null;

        Egx_EolParserRules.statementBlock_return statementBlock81 = null;


        org.eclipse.epsilon.common.parse.AST c_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal79_tree=null;

        try {
            // EolParserRules.g:303:2: (c= 'case' logicalExpression ':' ( block | statementBlock ) )
            // EolParserRules.g:303:4: c= 'case' logicalExpression ':' ( block | statementBlock )
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            c=(Token)match(input,124,FOLLOW_124_in_caseStatement1179); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            c_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(c);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(c_tree, root_0);
            }
            pushFollow(FOLLOW_logicalExpression_in_caseStatement1182);
            logicalExpression78=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression78.getTree());
            char_literal79=(Token)match(input,102,FOLLOW_102_in_caseStatement1184); if (state.failed) return retval;
            // EolParserRules.g:303:37: ( block | statementBlock )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==EOF||LA31_0==FLOAT||LA31_0==INT||LA31_0==BOOLEAN||LA31_0==STRING||LA31_0==NAME||LA31_0==96||LA31_0==100||(LA31_0>=108 && LA31_0<=118)||LA31_0==121||(LA31_0>=123 && LA31_0<=126)||(LA31_0>=128 && LA31_0<=136)||LA31_0==153||LA31_0==156||(LA31_0>=163 && LA31_0<=165)) ) {
                alt31=1;
            }
            else if ( (LA31_0==95) ) {
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
                    // EolParserRules.g:303:38: block
                    {
                    pushFollow(FOLLOW_block_in_caseStatement1188);
                    block80=block();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, block80.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:303:46: statementBlock
                    {
                    pushFollow(FOLLOW_statementBlock_in_caseStatement1192);
                    statementBlock81=statementBlock();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statementBlock81.getTree());

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
    // EolParserRules.g:307:1: defaultStatement : d= 'default' ':' ( block | statementBlock ) ;
    public final Egx_EolParserRules.defaultStatement_return defaultStatement() throws RecognitionException {
        Egx_EolParserRules.defaultStatement_return retval = new Egx_EolParserRules.defaultStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token d=null;
        Token char_literal82=null;
        Egx_EolParserRules.block_return block83 = null;

        Egx_EolParserRules.statementBlock_return statementBlock84 = null;


        org.eclipse.epsilon.common.parse.AST d_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal82_tree=null;

        try {
            // EolParserRules.g:308:2: (d= 'default' ':' ( block | statementBlock ) )
            // EolParserRules.g:308:4: d= 'default' ':' ( block | statementBlock )
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            d=(Token)match(input,125,FOLLOW_125_in_defaultStatement1211); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            d_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(d);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(d_tree, root_0);
            }
            char_literal82=(Token)match(input,102,FOLLOW_102_in_defaultStatement1214); if (state.failed) return retval;
            // EolParserRules.g:308:22: ( block | statementBlock )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==EOF||LA32_0==FLOAT||LA32_0==INT||LA32_0==BOOLEAN||LA32_0==STRING||LA32_0==NAME||LA32_0==96||LA32_0==100||(LA32_0>=108 && LA32_0<=118)||LA32_0==121||(LA32_0>=123 && LA32_0<=126)||(LA32_0>=128 && LA32_0<=136)||LA32_0==153||LA32_0==156||(LA32_0>=163 && LA32_0<=165)) ) {
                alt32=1;
            }
            else if ( (LA32_0==95) ) {
                alt32=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // EolParserRules.g:308:23: block
                    {
                    pushFollow(FOLLOW_block_in_defaultStatement1218);
                    block83=block();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, block83.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:308:31: statementBlock
                    {
                    pushFollow(FOLLOW_statementBlock_in_defaultStatement1222);
                    statementBlock84=statementBlock();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statementBlock84.getTree());

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

    public static class forStatement_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start forStatement
    // EolParserRules.g:312:1: forStatement : f= 'for' '(' formalParameter 'in' logicalExpression ')' statementOrStatementBlock ;
    public final Egx_EolParserRules.forStatement_return forStatement() throws RecognitionException {
        Egx_EolParserRules.forStatement_return retval = new Egx_EolParserRules.forStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token f=null;
        Token char_literal85=null;
        Token string_literal87=null;
        Token char_literal89=null;
        Egx_EolParserRules.formalParameter_return formalParameter86 = null;

        Egx_EolParserRules.logicalExpression_return logicalExpression88 = null;

        Egx_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock90 = null;


        org.eclipse.epsilon.common.parse.AST f_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal85_tree=null;
        org.eclipse.epsilon.common.parse.AST string_literal87_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal89_tree=null;

        try {
            // EolParserRules.g:313:2: (f= 'for' '(' formalParameter 'in' logicalExpression ')' statementOrStatementBlock )
            // EolParserRules.g:313:4: f= 'for' '(' formalParameter 'in' logicalExpression ')' statementOrStatementBlock
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            f=(Token)match(input,126,FOLLOW_126_in_forStatement1240); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            f_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(f);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(f_tree, root_0);
            }
            char_literal85=(Token)match(input,100,FOLLOW_100_in_forStatement1243); if (state.failed) return retval;
            pushFollow(FOLLOW_formalParameter_in_forStatement1246);
            formalParameter86=formalParameter();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, formalParameter86.getTree());
            string_literal87=(Token)match(input,127,FOLLOW_127_in_forStatement1248); if (state.failed) return retval;
            pushFollow(FOLLOW_logicalExpression_in_forStatement1251);
            logicalExpression88=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression88.getTree());
            char_literal89=(Token)match(input,101,FOLLOW_101_in_forStatement1253); if (state.failed) return retval;
            pushFollow(FOLLOW_statementOrStatementBlock_in_forStatement1256);
            statementOrStatementBlock90=statementOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, statementOrStatementBlock90.getTree());
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

    public static class whileStatement_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start whileStatement
    // EolParserRules.g:317:1: whileStatement : w= 'while' '(' logicalExpression ')' statementOrStatementBlock ;
    public final Egx_EolParserRules.whileStatement_return whileStatement() throws RecognitionException {
        Egx_EolParserRules.whileStatement_return retval = new Egx_EolParserRules.whileStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token w=null;
        Token char_literal91=null;
        Token char_literal93=null;
        Egx_EolParserRules.logicalExpression_return logicalExpression92 = null;

        Egx_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock94 = null;


        org.eclipse.epsilon.common.parse.AST w_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal91_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal93_tree=null;

        try {
            // EolParserRules.g:318:2: (w= 'while' '(' logicalExpression ')' statementOrStatementBlock )
            // EolParserRules.g:318:4: w= 'while' '(' logicalExpression ')' statementOrStatementBlock
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            w=(Token)match(input,128,FOLLOW_128_in_whileStatement1272); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            w_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(w);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(w_tree, root_0);
            }
            char_literal91=(Token)match(input,100,FOLLOW_100_in_whileStatement1275); if (state.failed) return retval;
            pushFollow(FOLLOW_logicalExpression_in_whileStatement1278);
            logicalExpression92=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression92.getTree());
            char_literal93=(Token)match(input,101,FOLLOW_101_in_whileStatement1280); if (state.failed) return retval;
            pushFollow(FOLLOW_statementOrStatementBlock_in_whileStatement1283);
            statementOrStatementBlock94=statementOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, statementOrStatementBlock94.getTree());
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
    // EolParserRules.g:322:1: returnStatement : r= 'return' ( logicalExpression )? sem= ';' ;
    public final Egx_EolParserRules.returnStatement_return returnStatement() throws RecognitionException {
        Egx_EolParserRules.returnStatement_return retval = new Egx_EolParserRules.returnStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token r=null;
        Token sem=null;
        Egx_EolParserRules.logicalExpression_return logicalExpression95 = null;


        org.eclipse.epsilon.common.parse.AST r_tree=null;
        org.eclipse.epsilon.common.parse.AST sem_tree=null;

        try {
            // EolParserRules.g:326:2: (r= 'return' ( logicalExpression )? sem= ';' )
            // EolParserRules.g:326:4: r= 'return' ( logicalExpression )? sem= ';'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            r=(Token)match(input,129,FOLLOW_129_in_returnStatement1305); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            r_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(r);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(r_tree, root_0);
            }
            // EolParserRules.g:326:16: ( logicalExpression )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==FLOAT||LA33_0==INT||LA33_0==BOOLEAN||LA33_0==STRING||LA33_0==NAME||LA33_0==100||(LA33_0>=108 && LA33_0<=118)||LA33_0==153||LA33_0==156||(LA33_0>=163 && LA33_0<=165)) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // EolParserRules.g:0:0: logicalExpression
                    {
                    pushFollow(FOLLOW_logicalExpression_in_returnStatement1308);
                    logicalExpression95=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression95.getTree());

                    }
                    break;

            }

            sem=(Token)match(input,91,FOLLOW_91_in_returnStatement1313); if (state.failed) return retval;
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
    // EolParserRules.g:330:1: throwStatement : t= 'throw' ( logicalExpression )? sem= ';' ;
    public final Egx_EolParserRules.throwStatement_return throwStatement() throws RecognitionException {
        Egx_EolParserRules.throwStatement_return retval = new Egx_EolParserRules.throwStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token t=null;
        Token sem=null;
        Egx_EolParserRules.logicalExpression_return logicalExpression96 = null;


        org.eclipse.epsilon.common.parse.AST t_tree=null;
        org.eclipse.epsilon.common.parse.AST sem_tree=null;

        try {
            // EolParserRules.g:334:2: (t= 'throw' ( logicalExpression )? sem= ';' )
            // EolParserRules.g:334:4: t= 'throw' ( logicalExpression )? sem= ';'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            t=(Token)match(input,130,FOLLOW_130_in_throwStatement1336); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            t_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(t);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(t_tree, root_0);
            }
            // EolParserRules.g:334:15: ( logicalExpression )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==FLOAT||LA34_0==INT||LA34_0==BOOLEAN||LA34_0==STRING||LA34_0==NAME||LA34_0==100||(LA34_0>=108 && LA34_0<=118)||LA34_0==153||LA34_0==156||(LA34_0>=163 && LA34_0<=165)) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // EolParserRules.g:0:0: logicalExpression
                    {
                    pushFollow(FOLLOW_logicalExpression_in_throwStatement1339);
                    logicalExpression96=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression96.getTree());

                    }
                    break;

            }

            sem=(Token)match(input,91,FOLLOW_91_in_throwStatement1344); if (state.failed) return retval;
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
    // EolParserRules.g:338:1: deleteStatement : d= 'delete' ( logicalExpression )? sem= ';' ;
    public final Egx_EolParserRules.deleteStatement_return deleteStatement() throws RecognitionException {
        Egx_EolParserRules.deleteStatement_return retval = new Egx_EolParserRules.deleteStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token d=null;
        Token sem=null;
        Egx_EolParserRules.logicalExpression_return logicalExpression97 = null;


        org.eclipse.epsilon.common.parse.AST d_tree=null;
        org.eclipse.epsilon.common.parse.AST sem_tree=null;

        try {
            // EolParserRules.g:342:2: (d= 'delete' ( logicalExpression )? sem= ';' )
            // EolParserRules.g:342:4: d= 'delete' ( logicalExpression )? sem= ';'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            d=(Token)match(input,131,FOLLOW_131_in_deleteStatement1367); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            d_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(d);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(d_tree, root_0);
            }
            // EolParserRules.g:342:16: ( logicalExpression )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==FLOAT||LA35_0==INT||LA35_0==BOOLEAN||LA35_0==STRING||LA35_0==NAME||LA35_0==100||(LA35_0>=108 && LA35_0<=118)||LA35_0==153||LA35_0==156||(LA35_0>=163 && LA35_0<=165)) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // EolParserRules.g:0:0: logicalExpression
                    {
                    pushFollow(FOLLOW_logicalExpression_in_deleteStatement1370);
                    logicalExpression97=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression97.getTree());

                    }
                    break;

            }

            sem=(Token)match(input,91,FOLLOW_91_in_deleteStatement1375); if (state.failed) return retval;
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
    // EolParserRules.g:346:1: breakStatement : b= 'break' sem= ';' ;
    public final Egx_EolParserRules.breakStatement_return breakStatement() throws RecognitionException {
        Egx_EolParserRules.breakStatement_return retval = new Egx_EolParserRules.breakStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token b=null;
        Token sem=null;

        org.eclipse.epsilon.common.parse.AST b_tree=null;
        org.eclipse.epsilon.common.parse.AST sem_tree=null;

        try {
            // EolParserRules.g:350:2: (b= 'break' sem= ';' )
            // EolParserRules.g:350:4: b= 'break' sem= ';'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            b=(Token)match(input,132,FOLLOW_132_in_breakStatement1401); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            b_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(b);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(b_tree, root_0);
            }
            sem=(Token)match(input,91,FOLLOW_91_in_breakStatement1406); if (state.failed) return retval;
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
    // EolParserRules.g:354:1: breakAllStatement : b= 'breakAll' sem= ';' ;
    public final Egx_EolParserRules.breakAllStatement_return breakAllStatement() throws RecognitionException {
        Egx_EolParserRules.breakAllStatement_return retval = new Egx_EolParserRules.breakAllStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token b=null;
        Token sem=null;

        org.eclipse.epsilon.common.parse.AST b_tree=null;
        org.eclipse.epsilon.common.parse.AST sem_tree=null;

        try {
            // EolParserRules.g:358:2: (b= 'breakAll' sem= ';' )
            // EolParserRules.g:358:4: b= 'breakAll' sem= ';'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            b=(Token)match(input,133,FOLLOW_133_in_breakAllStatement1429); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            b_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(b);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(b_tree, root_0);
            }
            sem=(Token)match(input,91,FOLLOW_91_in_breakAllStatement1434); if (state.failed) return retval;
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
    // EolParserRules.g:362:1: continueStatement : c= 'continue' sem= ';' ;
    public final Egx_EolParserRules.continueStatement_return continueStatement() throws RecognitionException {
        Egx_EolParserRules.continueStatement_return retval = new Egx_EolParserRules.continueStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token c=null;
        Token sem=null;

        org.eclipse.epsilon.common.parse.AST c_tree=null;
        org.eclipse.epsilon.common.parse.AST sem_tree=null;

        try {
            // EolParserRules.g:366:2: (c= 'continue' sem= ';' )
            // EolParserRules.g:366:4: c= 'continue' sem= ';'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            c=(Token)match(input,134,FOLLOW_134_in_continueStatement1457); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            c_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(c);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(c_tree, root_0);
            }
            sem=(Token)match(input,91,FOLLOW_91_in_continueStatement1462); if (state.failed) return retval;
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
    // EolParserRules.g:370:1: abortStatement : a= 'abort' sem= ';' ;
    public final Egx_EolParserRules.abortStatement_return abortStatement() throws RecognitionException {
        Egx_EolParserRules.abortStatement_return retval = new Egx_EolParserRules.abortStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token a=null;
        Token sem=null;

        org.eclipse.epsilon.common.parse.AST a_tree=null;
        org.eclipse.epsilon.common.parse.AST sem_tree=null;

        try {
            // EolParserRules.g:374:2: (a= 'abort' sem= ';' )
            // EolParserRules.g:374:4: a= 'abort' sem= ';'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            a=(Token)match(input,135,FOLLOW_135_in_abortStatement1485); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            a_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(a);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(a_tree, root_0);
            }
            sem=(Token)match(input,91,FOLLOW_91_in_abortStatement1490); if (state.failed) return retval;
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
    // EolParserRules.g:378:1: transactionStatement : t= 'transaction' ( NAME ( ',' NAME )* )? statementOrStatementBlock ;
    public final Egx_EolParserRules.transactionStatement_return transactionStatement() throws RecognitionException {
        Egx_EolParserRules.transactionStatement_return retval = new Egx_EolParserRules.transactionStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token t=null;
        Token NAME98=null;
        Token char_literal99=null;
        Token NAME100=null;
        Egx_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock101 = null;


        org.eclipse.epsilon.common.parse.AST t_tree=null;
        org.eclipse.epsilon.common.parse.AST NAME98_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal99_tree=null;
        org.eclipse.epsilon.common.parse.AST NAME100_tree=null;

        try {
            // EolParserRules.g:379:2: (t= 'transaction' ( NAME ( ',' NAME )* )? statementOrStatementBlock )
            // EolParserRules.g:379:4: t= 'transaction' ( NAME ( ',' NAME )* )? statementOrStatementBlock
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            t=(Token)match(input,136,FOLLOW_136_in_transactionStatement1507); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            t_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(t);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(t_tree, root_0);
            }
            // EolParserRules.g:379:21: ( NAME ( ',' NAME )* )?
            int alt37=2;
            alt37 = dfa37.predict(input);
            switch (alt37) {
                case 1 :
                    // EolParserRules.g:379:22: NAME ( ',' NAME )*
                    {
                    NAME98=(Token)match(input,NAME,FOLLOW_NAME_in_transactionStatement1511); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NAME98_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(NAME98);
                    adaptor.addChild(root_0, NAME98_tree);
                    }
                    // EolParserRules.g:379:27: ( ',' NAME )*
                    loop36:
                    do {
                        int alt36=2;
                        int LA36_0 = input.LA(1);

                        if ( (LA36_0==93) ) {
                            alt36=1;
                        }


                        switch (alt36) {
                    	case 1 :
                    	    // EolParserRules.g:379:28: ',' NAME
                    	    {
                    	    char_literal99=(Token)match(input,93,FOLLOW_93_in_transactionStatement1514); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal99_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(char_literal99);
                    	    adaptor.addChild(root_0, char_literal99_tree);
                    	    }
                    	    NAME100=(Token)match(input,NAME,FOLLOW_NAME_in_transactionStatement1516); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    NAME100_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(NAME100);
                    	    adaptor.addChild(root_0, NAME100_tree);
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop36;
                        }
                    } while (true);


                    }
                    break;

            }

            pushFollow(FOLLOW_statementOrStatementBlock_in_transactionStatement1522);
            statementOrStatementBlock101=statementOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, statementOrStatementBlock101.getTree());
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
    // EolParserRules.g:383:1: assignmentStatement : logicalExpression ( (normal= ':=' | normal= '+=' | normal= '-=' | normal= '*=' | normal= '/=' ) | special= '::=' ) logicalExpression sem= ';' ;
    public final Egx_EolParserRules.assignmentStatement_return assignmentStatement() throws RecognitionException {
        Egx_EolParserRules.assignmentStatement_return retval = new Egx_EolParserRules.assignmentStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token normal=null;
        Token special=null;
        Token sem=null;
        Egx_EolParserRules.logicalExpression_return logicalExpression102 = null;

        Egx_EolParserRules.logicalExpression_return logicalExpression103 = null;


        org.eclipse.epsilon.common.parse.AST normal_tree=null;
        org.eclipse.epsilon.common.parse.AST special_tree=null;
        org.eclipse.epsilon.common.parse.AST sem_tree=null;

        try {
            // EolParserRules.g:387:2: ( logicalExpression ( (normal= ':=' | normal= '+=' | normal= '-=' | normal= '*=' | normal= '/=' ) | special= '::=' ) logicalExpression sem= ';' )
            // EolParserRules.g:387:4: logicalExpression ( (normal= ':=' | normal= '+=' | normal= '-=' | normal= '*=' | normal= '/=' ) | special= '::=' ) logicalExpression sem= ';'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            pushFollow(FOLLOW_logicalExpression_in_assignmentStatement1542);
            logicalExpression102=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression102.getTree());
            // EolParserRules.g:387:22: ( (normal= ':=' | normal= '+=' | normal= '-=' | normal= '*=' | normal= '/=' ) | special= '::=' )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( ((LA39_0>=137 && LA39_0<=141)) ) {
                alt39=1;
            }
            else if ( (LA39_0==142) ) {
                alt39=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // EolParserRules.g:387:23: (normal= ':=' | normal= '+=' | normal= '-=' | normal= '*=' | normal= '/=' )
                    {
                    // EolParserRules.g:387:23: (normal= ':=' | normal= '+=' | normal= '-=' | normal= '*=' | normal= '/=' )
                    int alt38=5;
                    switch ( input.LA(1) ) {
                    case 137:
                        {
                        alt38=1;
                        }
                        break;
                    case 138:
                        {
                        alt38=2;
                        }
                        break;
                    case 139:
                        {
                        alt38=3;
                        }
                        break;
                    case 140:
                        {
                        alt38=4;
                        }
                        break;
                    case 141:
                        {
                        alt38=5;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 38, 0, input);

                        throw nvae;
                    }

                    switch (alt38) {
                        case 1 :
                            // EolParserRules.g:387:24: normal= ':='
                            {
                            normal=(Token)match(input,137,FOLLOW_137_in_assignmentStatement1548); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            normal_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(normal);
                            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(normal_tree, root_0);
                            }

                            }
                            break;
                        case 2 :
                            // EolParserRules.g:387:37: normal= '+='
                            {
                            normal=(Token)match(input,138,FOLLOW_138_in_assignmentStatement1553); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            normal_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(normal);
                            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(normal_tree, root_0);
                            }

                            }
                            break;
                        case 3 :
                            // EolParserRules.g:387:50: normal= '-='
                            {
                            normal=(Token)match(input,139,FOLLOW_139_in_assignmentStatement1558); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            normal_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(normal);
                            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(normal_tree, root_0);
                            }

                            }
                            break;
                        case 4 :
                            // EolParserRules.g:387:63: normal= '*='
                            {
                            normal=(Token)match(input,140,FOLLOW_140_in_assignmentStatement1563); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            normal_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(normal);
                            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(normal_tree, root_0);
                            }

                            }
                            break;
                        case 5 :
                            // EolParserRules.g:387:76: normal= '/='
                            {
                            normal=(Token)match(input,141,FOLLOW_141_in_assignmentStatement1568); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            normal_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(normal);
                            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(normal_tree, root_0);
                            }

                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {
                      normal.setType(ASSIGNMENT);
                    }

                    }
                    break;
                case 2 :
                    // EolParserRules.g:388:35: special= '::='
                    {
                    special=(Token)match(input,142,FOLLOW_142_in_assignmentStatement1580); if (state.failed) return retval;
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

            pushFollow(FOLLOW_logicalExpression_in_assignmentStatement1588);
            logicalExpression103=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression103.getTree());
            sem=(Token)match(input,91,FOLLOW_91_in_assignmentStatement1592); if (state.failed) return retval;

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
    // EolParserRules.g:392:1: expressionStatement : ( ( postfixExpression op= '=' logicalExpression ) | logicalExpression ) sem= ';' ;
    public final Egx_EolParserRules.expressionStatement_return expressionStatement() throws RecognitionException {
        Egx_EolParserRules.expressionStatement_return retval = new Egx_EolParserRules.expressionStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token op=null;
        Token sem=null;
        Egx_EolParserRules.postfixExpression_return postfixExpression104 = null;

        Egx_EolParserRules.logicalExpression_return logicalExpression105 = null;

        Egx_EolParserRules.logicalExpression_return logicalExpression106 = null;


        org.eclipse.epsilon.common.parse.AST op_tree=null;
        org.eclipse.epsilon.common.parse.AST sem_tree=null;

        try {
            // EolParserRules.g:396:2: ( ( ( postfixExpression op= '=' logicalExpression ) | logicalExpression ) sem= ';' )
            // EolParserRules.g:396:4: ( ( postfixExpression op= '=' logicalExpression ) | logicalExpression ) sem= ';'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            // EolParserRules.g:396:4: ( ( postfixExpression op= '=' logicalExpression ) | logicalExpression )
            int alt40=2;
            alt40 = dfa40.predict(input);
            switch (alt40) {
                case 1 :
                    // EolParserRules.g:396:5: ( postfixExpression op= '=' logicalExpression )
                    {
                    // EolParserRules.g:396:5: ( postfixExpression op= '=' logicalExpression )
                    // EolParserRules.g:396:6: postfixExpression op= '=' logicalExpression
                    {
                    pushFollow(FOLLOW_postfixExpression_in_expressionStatement1612);
                    postfixExpression104=postfixExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, postfixExpression104.getTree());
                    op=(Token)match(input,97,FOLLOW_97_in_expressionStatement1616); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
                    }
                    pushFollow(FOLLOW_logicalExpression_in_expressionStatement1619);
                    logicalExpression105=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression105.getTree());
                    if ( state.backtracking==0 ) {
                      op.setType(OPERATOR);
                    }

                    }


                    }
                    break;
                case 2 :
                    // EolParserRules.g:396:78: logicalExpression
                    {
                    pushFollow(FOLLOW_logicalExpression_in_expressionStatement1626);
                    logicalExpression106=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression106.getTree());

                    }
                    break;

            }

            sem=(Token)match(input,91,FOLLOW_91_in_expressionStatement1631); if (state.failed) return retval;

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
    // EolParserRules.g:399:1: logicalExpression : relationalExpression ( ( (op= 'or' | op= 'and' | op= 'xor' | op= 'implies' ) | (op= '?' relationalExpression ( 'else' | ':' ) ) ) relationalExpression )* ;
    public final Egx_EolParserRules.logicalExpression_return logicalExpression() throws RecognitionException {
        Egx_EolParserRules.logicalExpression_return retval = new Egx_EolParserRules.logicalExpression_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token op=null;
        Token set109=null;
        Egx_EolParserRules.relationalExpression_return relationalExpression107 = null;

        Egx_EolParserRules.relationalExpression_return relationalExpression108 = null;

        Egx_EolParserRules.relationalExpression_return relationalExpression110 = null;


        org.eclipse.epsilon.common.parse.AST op_tree=null;
        org.eclipse.epsilon.common.parse.AST set109_tree=null;

        try {
            // EolParserRules.g:400:2: ( relationalExpression ( ( (op= 'or' | op= 'and' | op= 'xor' | op= 'implies' ) | (op= '?' relationalExpression ( 'else' | ':' ) ) ) relationalExpression )* )
            // EolParserRules.g:400:4: relationalExpression ( ( (op= 'or' | op= 'and' | op= 'xor' | op= 'implies' ) | (op= '?' relationalExpression ( 'else' | ':' ) ) ) relationalExpression )*
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            pushFollow(FOLLOW_relationalExpression_in_logicalExpression1643);
            relationalExpression107=relationalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, relationalExpression107.getTree());
            // EolParserRules.g:400:25: ( ( (op= 'or' | op= 'and' | op= 'xor' | op= 'implies' ) | (op= '?' relationalExpression ( 'else' | ':' ) ) ) relationalExpression )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( ((LA43_0>=143 && LA43_0<=147)) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // EolParserRules.g:401:4: ( (op= 'or' | op= 'and' | op= 'xor' | op= 'implies' ) | (op= '?' relationalExpression ( 'else' | ':' ) ) ) relationalExpression
            	    {
            	    // EolParserRules.g:401:4: ( (op= 'or' | op= 'and' | op= 'xor' | op= 'implies' ) | (op= '?' relationalExpression ( 'else' | ':' ) ) )
            	    int alt42=2;
            	    int LA42_0 = input.LA(1);

            	    if ( ((LA42_0>=143 && LA42_0<=146)) ) {
            	        alt42=1;
            	    }
            	    else if ( (LA42_0==147) ) {
            	        alt42=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 42, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt42) {
            	        case 1 :
            	            // EolParserRules.g:401:5: (op= 'or' | op= 'and' | op= 'xor' | op= 'implies' )
            	            {
            	            // EolParserRules.g:401:5: (op= 'or' | op= 'and' | op= 'xor' | op= 'implies' )
            	            int alt41=4;
            	            switch ( input.LA(1) ) {
            	            case 143:
            	                {
            	                alt41=1;
            	                }
            	                break;
            	            case 144:
            	                {
            	                alt41=2;
            	                }
            	                break;
            	            case 145:
            	                {
            	                alt41=3;
            	                }
            	                break;
            	            case 146:
            	                {
            	                alt41=4;
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
            	                    // EolParserRules.g:401:6: op= 'or'
            	                    {
            	                    op=(Token)match(input,143,FOLLOW_143_in_logicalExpression1654); if (state.failed) return retval;
            	                    if ( state.backtracking==0 ) {
            	                    op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	                    }

            	                    }
            	                    break;
            	                case 2 :
            	                    // EolParserRules.g:401:15: op= 'and'
            	                    {
            	                    op=(Token)match(input,144,FOLLOW_144_in_logicalExpression1659); if (state.failed) return retval;
            	                    if ( state.backtracking==0 ) {
            	                    op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	                    }

            	                    }
            	                    break;
            	                case 3 :
            	                    // EolParserRules.g:401:25: op= 'xor'
            	                    {
            	                    op=(Token)match(input,145,FOLLOW_145_in_logicalExpression1664); if (state.failed) return retval;
            	                    if ( state.backtracking==0 ) {
            	                    op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	                    }

            	                    }
            	                    break;
            	                case 4 :
            	                    // EolParserRules.g:401:35: op= 'implies'
            	                    {
            	                    op=(Token)match(input,146,FOLLOW_146_in_logicalExpression1669); if (state.failed) return retval;
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
            	        case 2 :
            	            // EolParserRules.g:402:4: (op= '?' relationalExpression ( 'else' | ':' ) )
            	            {
            	            // EolParserRules.g:402:4: (op= '?' relationalExpression ( 'else' | ':' ) )
            	            // EolParserRules.g:402:5: op= '?' relationalExpression ( 'else' | ':' )
            	            {
            	            op=(Token)match(input,147,FOLLOW_147_in_logicalExpression1683); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	            }
            	            pushFollow(FOLLOW_relationalExpression_in_logicalExpression1686);
            	            relationalExpression108=relationalExpression();

            	            state._fsp--;
            	            if (state.failed) return retval;
            	            if ( state.backtracking==0 ) adaptor.addChild(root_0, relationalExpression108.getTree());
            	            set109=(Token)input.LT(1);
            	            if ( input.LA(1)==102||input.LA(1)==122 ) {
            	                input.consume();
            	                if ( state.backtracking==0 ) adaptor.addChild(root_0, (org.eclipse.epsilon.common.parse.AST)adaptor.create(set109));
            	                state.errorRecovery=false;state.failed=false;
            	            }
            	            else {
            	                if (state.backtracking>0) {state.failed=true; return retval;}
            	                MismatchedSetException mse = new MismatchedSetException(null,input);
            	                throw mse;
            	            }

            	            if ( state.backtracking==0 ) {
            	              op.setType(TERNARY);
            	            }

            	            }


            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_relationalExpression_in_logicalExpression1704);
            	    relationalExpression110=relationalExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, relationalExpression110.getTree());

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
    // $ANTLR end logicalExpression

    public static class relationalExpression_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start relationalExpression
    // EolParserRules.g:407:1: relationalExpression : additiveExpression ( (op= '==' relationalExpression | op= '=' relationalExpression | (op= '>' | op= '<' | op= '>=' | op= '<=' | op= '<>' ) additiveExpression ) )* ;
    public final Egx_EolParserRules.relationalExpression_return relationalExpression() throws RecognitionException {
        Egx_EolParserRules.relationalExpression_return retval = new Egx_EolParserRules.relationalExpression_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token op=null;
        Egx_EolParserRules.additiveExpression_return additiveExpression111 = null;

        Egx_EolParserRules.relationalExpression_return relationalExpression112 = null;

        Egx_EolParserRules.relationalExpression_return relationalExpression113 = null;

        Egx_EolParserRules.additiveExpression_return additiveExpression114 = null;


        org.eclipse.epsilon.common.parse.AST op_tree=null;

        try {
            // EolParserRules.g:408:2: ( additiveExpression ( (op= '==' relationalExpression | op= '=' relationalExpression | (op= '>' | op= '<' | op= '>=' | op= '<=' | op= '<>' ) additiveExpression ) )* )
            // EolParserRules.g:408:4: additiveExpression ( (op= '==' relationalExpression | op= '=' relationalExpression | (op= '>' | op= '<' | op= '>=' | op= '<=' | op= '<>' ) additiveExpression ) )*
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            pushFollow(FOLLOW_additiveExpression_in_relationalExpression1720);
            additiveExpression111=additiveExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, additiveExpression111.getTree());
            // EolParserRules.g:408:23: ( (op= '==' relationalExpression | op= '=' relationalExpression | (op= '>' | op= '<' | op= '>=' | op= '<=' | op= '<>' ) additiveExpression ) )*
            loop46:
            do {
                int alt46=2;
                alt46 = dfa46.predict(input);
                switch (alt46) {
            	case 1 :
            	    // EolParserRules.g:408:24: (op= '==' relationalExpression | op= '=' relationalExpression | (op= '>' | op= '<' | op= '>=' | op= '<=' | op= '<>' ) additiveExpression )
            	    {
            	    // EolParserRules.g:408:24: (op= '==' relationalExpression | op= '=' relationalExpression | (op= '>' | op= '<' | op= '>=' | op= '<=' | op= '<>' ) additiveExpression )
            	    int alt45=3;
            	    switch ( input.LA(1) ) {
            	    case 148:
            	        {
            	        alt45=1;
            	        }
            	        break;
            	    case 97:
            	        {
            	        alt45=2;
            	        }
            	        break;
            	    case 119:
            	    case 120:
            	    case 149:
            	    case 150:
            	    case 151:
            	        {
            	        alt45=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 45, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt45) {
            	        case 1 :
            	            // EolParserRules.g:408:25: op= '==' relationalExpression
            	            {
            	            op=(Token)match(input,148,FOLLOW_148_in_relationalExpression1726); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	            }
            	            pushFollow(FOLLOW_relationalExpression_in_relationalExpression1729);
            	            relationalExpression112=relationalExpression();

            	            state._fsp--;
            	            if (state.failed) return retval;
            	            if ( state.backtracking==0 ) adaptor.addChild(root_0, relationalExpression112.getTree());

            	            }
            	            break;
            	        case 2 :
            	            // EolParserRules.g:408:57: op= '=' relationalExpression
            	            {
            	            op=(Token)match(input,97,FOLLOW_97_in_relationalExpression1735); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	            }
            	            pushFollow(FOLLOW_relationalExpression_in_relationalExpression1738);
            	            relationalExpression113=relationalExpression();

            	            state._fsp--;
            	            if (state.failed) return retval;
            	            if ( state.backtracking==0 ) adaptor.addChild(root_0, relationalExpression113.getTree());

            	            }
            	            break;
            	        case 3 :
            	            // EolParserRules.g:409:24: (op= '>' | op= '<' | op= '>=' | op= '<=' | op= '<>' ) additiveExpression
            	            {
            	            // EolParserRules.g:409:24: (op= '>' | op= '<' | op= '>=' | op= '<=' | op= '<>' )
            	            int alt44=5;
            	            switch ( input.LA(1) ) {
            	            case 120:
            	                {
            	                alt44=1;
            	                }
            	                break;
            	            case 119:
            	                {
            	                alt44=2;
            	                }
            	                break;
            	            case 149:
            	                {
            	                alt44=3;
            	                }
            	                break;
            	            case 150:
            	                {
            	                alt44=4;
            	                }
            	                break;
            	            case 151:
            	                {
            	                alt44=5;
            	                }
            	                break;
            	            default:
            	                if (state.backtracking>0) {state.failed=true; return retval;}
            	                NoViableAltException nvae =
            	                    new NoViableAltException("", 44, 0, input);

            	                throw nvae;
            	            }

            	            switch (alt44) {
            	                case 1 :
            	                    // EolParserRules.g:409:25: op= '>'
            	                    {
            	                    op=(Token)match(input,120,FOLLOW_120_in_relationalExpression1768); if (state.failed) return retval;
            	                    if ( state.backtracking==0 ) {
            	                    op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	                    }

            	                    }
            	                    break;
            	                case 2 :
            	                    // EolParserRules.g:409:33: op= '<'
            	                    {
            	                    op=(Token)match(input,119,FOLLOW_119_in_relationalExpression1773); if (state.failed) return retval;
            	                    if ( state.backtracking==0 ) {
            	                    op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	                    }

            	                    }
            	                    break;
            	                case 3 :
            	                    // EolParserRules.g:409:41: op= '>='
            	                    {
            	                    op=(Token)match(input,149,FOLLOW_149_in_relationalExpression1778); if (state.failed) return retval;
            	                    if ( state.backtracking==0 ) {
            	                    op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	                    }

            	                    }
            	                    break;
            	                case 4 :
            	                    // EolParserRules.g:409:50: op= '<='
            	                    {
            	                    op=(Token)match(input,150,FOLLOW_150_in_relationalExpression1783); if (state.failed) return retval;
            	                    if ( state.backtracking==0 ) {
            	                    op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	                    }

            	                    }
            	                    break;
            	                case 5 :
            	                    // EolParserRules.g:409:59: op= '<>'
            	                    {
            	                    op=(Token)match(input,151,FOLLOW_151_in_relationalExpression1788); if (state.failed) return retval;
            	                    if ( state.backtracking==0 ) {
            	                    op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	                    }

            	                    }
            	                    break;

            	            }

            	            pushFollow(FOLLOW_additiveExpression_in_relationalExpression1792);
            	            additiveExpression114=additiveExpression();

            	            state._fsp--;
            	            if (state.failed) return retval;
            	            if ( state.backtracking==0 ) adaptor.addChild(root_0, additiveExpression114.getTree());

            	            }
            	            break;

            	    }

            	    if ( state.backtracking==0 ) {
            	      op.setType(OPERATOR);
            	    }

            	    }
            	    break;

            	default :
            	    break loop46;
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
    // EolParserRules.g:413:1: additiveExpression : multiplicativeExpression ( (op= '+' | op= '-' ) multiplicativeExpression )* ;
    public final Egx_EolParserRules.additiveExpression_return additiveExpression() throws RecognitionException {
        Egx_EolParserRules.additiveExpression_return retval = new Egx_EolParserRules.additiveExpression_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token op=null;
        Egx_EolParserRules.multiplicativeExpression_return multiplicativeExpression115 = null;

        Egx_EolParserRules.multiplicativeExpression_return multiplicativeExpression116 = null;


        org.eclipse.epsilon.common.parse.AST op_tree=null;

        try {
            // EolParserRules.g:414:2: ( multiplicativeExpression ( (op= '+' | op= '-' ) multiplicativeExpression )* )
            // EolParserRules.g:414:4: multiplicativeExpression ( (op= '+' | op= '-' ) multiplicativeExpression )*
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            pushFollow(FOLLOW_multiplicativeExpression_in_additiveExpression1810);
            multiplicativeExpression115=multiplicativeExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, multiplicativeExpression115.getTree());
            // EolParserRules.g:414:29: ( (op= '+' | op= '-' ) multiplicativeExpression )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( ((LA48_0>=152 && LA48_0<=153)) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // EolParserRules.g:414:30: (op= '+' | op= '-' ) multiplicativeExpression
            	    {
            	    // EolParserRules.g:414:30: (op= '+' | op= '-' )
            	    int alt47=2;
            	    int LA47_0 = input.LA(1);

            	    if ( (LA47_0==152) ) {
            	        alt47=1;
            	    }
            	    else if ( (LA47_0==153) ) {
            	        alt47=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 47, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt47) {
            	        case 1 :
            	            // EolParserRules.g:414:31: op= '+'
            	            {
            	            op=(Token)match(input,152,FOLLOW_152_in_additiveExpression1816); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // EolParserRules.g:414:39: op= '-'
            	            {
            	            op=(Token)match(input,153,FOLLOW_153_in_additiveExpression1821); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_multiplicativeExpression_in_additiveExpression1825);
            	    multiplicativeExpression116=multiplicativeExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, multiplicativeExpression116.getTree());
            	    if ( state.backtracking==0 ) {
            	      op.setType(OPERATOR);
            	    }

            	    }
            	    break;

            	default :
            	    break loop48;
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
    // EolParserRules.g:418:1: multiplicativeExpression : unaryExpression ( (op= '*' | op= '/' ) unaryExpression )* ;
    public final Egx_EolParserRules.multiplicativeExpression_return multiplicativeExpression() throws RecognitionException {
        Egx_EolParserRules.multiplicativeExpression_return retval = new Egx_EolParserRules.multiplicativeExpression_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token op=null;
        Egx_EolParserRules.unaryExpression_return unaryExpression117 = null;

        Egx_EolParserRules.unaryExpression_return unaryExpression118 = null;


        org.eclipse.epsilon.common.parse.AST op_tree=null;

        try {
            // EolParserRules.g:419:2: ( unaryExpression ( (op= '*' | op= '/' ) unaryExpression )* )
            // EolParserRules.g:419:4: unaryExpression ( (op= '*' | op= '/' ) unaryExpression )*
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            pushFollow(FOLLOW_unaryExpression_in_multiplicativeExpression1843);
            unaryExpression117=unaryExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, unaryExpression117.getTree());
            // EolParserRules.g:419:20: ( (op= '*' | op= '/' ) unaryExpression )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( ((LA50_0>=154 && LA50_0<=155)) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // EolParserRules.g:419:21: (op= '*' | op= '/' ) unaryExpression
            	    {
            	    // EolParserRules.g:419:21: (op= '*' | op= '/' )
            	    int alt49=2;
            	    int LA49_0 = input.LA(1);

            	    if ( (LA49_0==154) ) {
            	        alt49=1;
            	    }
            	    else if ( (LA49_0==155) ) {
            	        alt49=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 49, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt49) {
            	        case 1 :
            	            // EolParserRules.g:419:22: op= '*'
            	            {
            	            op=(Token)match(input,154,FOLLOW_154_in_multiplicativeExpression1849); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // EolParserRules.g:419:30: op= '/'
            	            {
            	            op=(Token)match(input,155,FOLLOW_155_in_multiplicativeExpression1854); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_unaryExpression_in_multiplicativeExpression1858);
            	    unaryExpression118=unaryExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, unaryExpression118.getTree());
            	    if ( state.backtracking==0 ) {
            	      op.setType(OPERATOR);
            	    }

            	    }
            	    break;

            	default :
            	    break loop50;
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
    // EolParserRules.g:423:1: unaryExpression : ( (op= 'not' | op= '-' ) )? shortcutOperatorExpression ;
    public final Egx_EolParserRules.unaryExpression_return unaryExpression() throws RecognitionException {
        Egx_EolParserRules.unaryExpression_return retval = new Egx_EolParserRules.unaryExpression_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token op=null;
        Egx_EolParserRules.shortcutOperatorExpression_return shortcutOperatorExpression119 = null;


        org.eclipse.epsilon.common.parse.AST op_tree=null;

        try {
            // EolParserRules.g:424:2: ( ( (op= 'not' | op= '-' ) )? shortcutOperatorExpression )
            // EolParserRules.g:424:4: ( (op= 'not' | op= '-' ) )? shortcutOperatorExpression
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            // EolParserRules.g:424:4: ( (op= 'not' | op= '-' ) )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==153||LA52_0==156) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // EolParserRules.g:424:5: (op= 'not' | op= '-' )
                    {
                    // EolParserRules.g:424:5: (op= 'not' | op= '-' )
                    int alt51=2;
                    int LA51_0 = input.LA(1);

                    if ( (LA51_0==156) ) {
                        alt51=1;
                    }
                    else if ( (LA51_0==153) ) {
                        alt51=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 51, 0, input);

                        throw nvae;
                    }
                    switch (alt51) {
                        case 1 :
                            // EolParserRules.g:424:6: op= 'not'
                            {
                            op=(Token)match(input,156,FOLLOW_156_in_unaryExpression1879); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
                            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
                            }

                            }
                            break;
                        case 2 :
                            // EolParserRules.g:424:16: op= '-'
                            {
                            op=(Token)match(input,153,FOLLOW_153_in_unaryExpression1884); if (state.failed) return retval;
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

            pushFollow(FOLLOW_shortcutOperatorExpression_in_unaryExpression1892);
            shortcutOperatorExpression119=shortcutOperatorExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, shortcutOperatorExpression119.getTree());

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

    public static class shortcutOperatorExpression_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start shortcutOperatorExpression
    // EolParserRules.g:427:1: shortcutOperatorExpression : postfixExpression ( (op= '++' | op= '--' ) )? ;
    public final Egx_EolParserRules.shortcutOperatorExpression_return shortcutOperatorExpression() throws RecognitionException {
        Egx_EolParserRules.shortcutOperatorExpression_return retval = new Egx_EolParserRules.shortcutOperatorExpression_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token op=null;
        Egx_EolParserRules.postfixExpression_return postfixExpression120 = null;


        org.eclipse.epsilon.common.parse.AST op_tree=null;

        try {
            // EolParserRules.g:428:2: ( postfixExpression ( (op= '++' | op= '--' ) )? )
            // EolParserRules.g:428:4: postfixExpression ( (op= '++' | op= '--' ) )?
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            pushFollow(FOLLOW_postfixExpression_in_shortcutOperatorExpression1904);
            postfixExpression120=postfixExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, postfixExpression120.getTree());
            // EolParserRules.g:428:22: ( (op= '++' | op= '--' ) )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( ((LA54_0>=157 && LA54_0<=158)) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // EolParserRules.g:428:23: (op= '++' | op= '--' )
                    {
                    // EolParserRules.g:428:23: (op= '++' | op= '--' )
                    int alt53=2;
                    int LA53_0 = input.LA(1);

                    if ( (LA53_0==157) ) {
                        alt53=1;
                    }
                    else if ( (LA53_0==158) ) {
                        alt53=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 53, 0, input);

                        throw nvae;
                    }
                    switch (alt53) {
                        case 1 :
                            // EolParserRules.g:428:24: op= '++'
                            {
                            op=(Token)match(input,157,FOLLOW_157_in_shortcutOperatorExpression1910); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
                            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
                            }

                            }
                            break;
                        case 2 :
                            // EolParserRules.g:428:35: op= '--'
                            {
                            op=(Token)match(input,158,FOLLOW_158_in_shortcutOperatorExpression1917); if (state.failed) return retval;
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
    // $ANTLR end shortcutOperatorExpression

    public static class postfixExpression_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start postfixExpression
    // EolParserRules.g:431:1: postfixExpression : itemSelectorExpression ( ( POINT | ARROW ) fc= featureCall (is= '[' logicalExpression ']' )* )* ;
    public final Egx_EolParserRules.postfixExpression_return postfixExpression() throws RecognitionException {
        Egx_EolParserRules.postfixExpression_return retval = new Egx_EolParserRules.postfixExpression_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token is=null;
        Token set122=null;
        Token char_literal124=null;
        Egx_EolParserRules.featureCall_return fc = null;

        Egx_EolParserRules.itemSelectorExpression_return itemSelectorExpression121 = null;

        Egx_EolParserRules.logicalExpression_return logicalExpression123 = null;


        org.eclipse.epsilon.common.parse.AST is_tree=null;
        org.eclipse.epsilon.common.parse.AST set122_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal124_tree=null;

        try {
            // EolParserRules.g:432:2: ( itemSelectorExpression ( ( POINT | ARROW ) fc= featureCall (is= '[' logicalExpression ']' )* )* )
            // EolParserRules.g:432:4: itemSelectorExpression ( ( POINT | ARROW ) fc= featureCall (is= '[' logicalExpression ']' )* )*
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            pushFollow(FOLLOW_itemSelectorExpression_in_postfixExpression1935);
            itemSelectorExpression121=itemSelectorExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, itemSelectorExpression121.getTree());
            // EolParserRules.g:432:27: ( ( POINT | ARROW ) fc= featureCall (is= '[' logicalExpression ']' )* )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==POINT||LA56_0==ARROW) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // EolParserRules.g:432:28: ( POINT | ARROW ) fc= featureCall (is= '[' logicalExpression ']' )*
            	    {
            	    set122=(Token)input.LT(1);
            	    set122=(Token)input.LT(1);
            	    if ( input.LA(1)==POINT||input.LA(1)==ARROW ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot((org.eclipse.epsilon.common.parse.AST)adaptor.create(set122), root_0);
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_featureCall_in_postfixExpression1947);
            	    fc=featureCall();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, fc.getTree());
            	    if ( state.backtracking==0 ) {
            	      setTokenType(fc,FEATURECALL);
            	    }
            	    // EolParserRules.g:433:35: (is= '[' logicalExpression ']' )*
            	    loop55:
            	    do {
            	        int alt55=2;
            	        int LA55_0 = input.LA(1);

            	        if ( (LA55_0==159) ) {
            	            alt55=1;
            	        }


            	        switch (alt55) {
            	    	case 1 :
            	    	    // EolParserRules.g:433:36: is= '[' logicalExpression ']'
            	    	    {
            	    	    is=(Token)match(input,159,FOLLOW_159_in_postfixExpression1956); if (state.failed) return retval;
            	    	    if ( state.backtracking==0 ) {
            	    	    is_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(is);
            	    	    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(is_tree, root_0);
            	    	    }
            	    	    pushFollow(FOLLOW_logicalExpression_in_postfixExpression1959);
            	    	    logicalExpression123=logicalExpression();

            	    	    state._fsp--;
            	    	    if (state.failed) return retval;
            	    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression123.getTree());
            	    	    char_literal124=(Token)match(input,160,FOLLOW_160_in_postfixExpression1961); if (state.failed) return retval;
            	    	    if ( state.backtracking==0 ) {
            	    	      is.setType(ITEMSELECTOR);
            	    	    }

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop55;
            	        }
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop56;
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
    // EolParserRules.g:437:1: itemSelectorExpression : primitiveExpression (is= '[' primitiveExpression ']' )* ;
    public final Egx_EolParserRules.itemSelectorExpression_return itemSelectorExpression() throws RecognitionException {
        Egx_EolParserRules.itemSelectorExpression_return retval = new Egx_EolParserRules.itemSelectorExpression_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token is=null;
        Token char_literal127=null;
        Egx_EolParserRules.primitiveExpression_return primitiveExpression125 = null;

        Egx_EolParserRules.primitiveExpression_return primitiveExpression126 = null;


        org.eclipse.epsilon.common.parse.AST is_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal127_tree=null;

        try {
            // EolParserRules.g:438:2: ( primitiveExpression (is= '[' primitiveExpression ']' )* )
            // EolParserRules.g:438:4: primitiveExpression (is= '[' primitiveExpression ']' )*
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            pushFollow(FOLLOW_primitiveExpression_in_itemSelectorExpression1983);
            primitiveExpression125=primitiveExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, primitiveExpression125.getTree());
            // EolParserRules.g:438:24: (is= '[' primitiveExpression ']' )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==159) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // EolParserRules.g:438:25: is= '[' primitiveExpression ']'
            	    {
            	    is=(Token)match(input,159,FOLLOW_159_in_itemSelectorExpression1988); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    is_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(is);
            	    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(is_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_primitiveExpression_in_itemSelectorExpression1991);
            	    primitiveExpression126=primitiveExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, primitiveExpression126.getTree());
            	    char_literal127=(Token)match(input,160,FOLLOW_160_in_itemSelectorExpression1993); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	      is.setType(ITEMSELECTOR);
            	    }

            	    }
            	    break;

            	default :
            	    break loop57;
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
    // EolParserRules.g:442:1: featureCall : ( simpleFeatureCall | complexFeatureCall );
    public final Egx_EolParserRules.featureCall_return featureCall() throws RecognitionException {
        Egx_EolParserRules.featureCall_return retval = new Egx_EolParserRules.featureCall_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Egx_EolParserRules.simpleFeatureCall_return simpleFeatureCall128 = null;

        Egx_EolParserRules.complexFeatureCall_return complexFeatureCall129 = null;



        try {
            // EolParserRules.g:443:2: ( simpleFeatureCall | complexFeatureCall )
            int alt58=2;
            alt58 = dfa58.predict(input);
            switch (alt58) {
                case 1 :
                    // EolParserRules.g:443:4: simpleFeatureCall
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_simpleFeatureCall_in_featureCall2011);
                    simpleFeatureCall128=simpleFeatureCall();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, simpleFeatureCall128.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:443:24: complexFeatureCall
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_complexFeatureCall_in_featureCall2015);
                    complexFeatureCall129=complexFeatureCall();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, complexFeatureCall129.getTree());

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
    // EolParserRules.g:446:1: simpleFeatureCall : n= NAME ( parameterList )? ;
    public final Egx_EolParserRules.simpleFeatureCall_return simpleFeatureCall() throws RecognitionException {
        Egx_EolParserRules.simpleFeatureCall_return retval = new Egx_EolParserRules.simpleFeatureCall_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token n=null;
        Egx_EolParserRules.parameterList_return parameterList130 = null;


        org.eclipse.epsilon.common.parse.AST n_tree=null;

        try {
            // EolParserRules.g:447:2: (n= NAME ( parameterList )? )
            // EolParserRules.g:447:5: n= NAME ( parameterList )?
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            n=(Token)match(input,NAME,FOLLOW_NAME_in_simpleFeatureCall2029); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            n_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(n);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(n_tree, root_0);
            }
            // EolParserRules.g:447:13: ( parameterList )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==100) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // EolParserRules.g:0:0: parameterList
                    {
                    pushFollow(FOLLOW_parameterList_in_simpleFeatureCall2032);
                    parameterList130=parameterList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, parameterList130.getTree());

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
    // EolParserRules.g:451:1: parameterList : op= '(' ( logicalExpression ( ',' logicalExpression )* )? cp= ')' -> ^( PARAMETERS ( logicalExpression )* ) ;
    public final Egx_EolParserRules.parameterList_return parameterList() throws RecognitionException {
        Egx_EolParserRules.parameterList_return retval = new Egx_EolParserRules.parameterList_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token op=null;
        Token cp=null;
        Token char_literal132=null;
        Egx_EolParserRules.logicalExpression_return logicalExpression131 = null;

        Egx_EolParserRules.logicalExpression_return logicalExpression133 = null;


        org.eclipse.epsilon.common.parse.AST op_tree=null;
        org.eclipse.epsilon.common.parse.AST cp_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal132_tree=null;
        RewriteRuleTokenStream stream_100=new RewriteRuleTokenStream(adaptor,"token 100");
        RewriteRuleTokenStream stream_101=new RewriteRuleTokenStream(adaptor,"token 101");
        RewriteRuleTokenStream stream_93=new RewriteRuleTokenStream(adaptor,"token 93");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:457:2: (op= '(' ( logicalExpression ( ',' logicalExpression )* )? cp= ')' -> ^( PARAMETERS ( logicalExpression )* ) )
            // EolParserRules.g:457:4: op= '(' ( logicalExpression ( ',' logicalExpression )* )? cp= ')'
            {
            op=(Token)match(input,100,FOLLOW_100_in_parameterList2055); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_100.add(op);

            // EolParserRules.g:457:11: ( logicalExpression ( ',' logicalExpression )* )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==FLOAT||LA61_0==INT||LA61_0==BOOLEAN||LA61_0==STRING||LA61_0==NAME||LA61_0==100||(LA61_0>=108 && LA61_0<=118)||LA61_0==153||LA61_0==156||(LA61_0>=163 && LA61_0<=165)) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // EolParserRules.g:457:12: logicalExpression ( ',' logicalExpression )*
                    {
                    pushFollow(FOLLOW_logicalExpression_in_parameterList2058);
                    logicalExpression131=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression131.getTree());
                    // EolParserRules.g:457:30: ( ',' logicalExpression )*
                    loop60:
                    do {
                        int alt60=2;
                        int LA60_0 = input.LA(1);

                        if ( (LA60_0==93) ) {
                            alt60=1;
                        }


                        switch (alt60) {
                    	case 1 :
                    	    // EolParserRules.g:457:31: ',' logicalExpression
                    	    {
                    	    char_literal132=(Token)match(input,93,FOLLOW_93_in_parameterList2061); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_93.add(char_literal132);

                    	    pushFollow(FOLLOW_logicalExpression_in_parameterList2063);
                    	    logicalExpression133=logicalExpression();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression133.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop60;
                        }
                    } while (true);


                    }
                    break;

            }

            cp=(Token)match(input,101,FOLLOW_101_in_parameterList2071); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_101.add(cp);



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
            // 458:3: -> ^( PARAMETERS ( logicalExpression )* )
            {
                // EolParserRules.g:458:6: ^( PARAMETERS ( logicalExpression )* )
                {
                org.eclipse.epsilon.common.parse.AST root_1 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();
                root_1 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot((org.eclipse.epsilon.common.parse.AST)adaptor.create(PARAMETERS, "PARAMETERS"), root_1);

                // EolParserRules.g:458:19: ( logicalExpression )*
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

    public static class complexFeatureCall_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start complexFeatureCall
    // EolParserRules.g:461:1: complexFeatureCall : NAME op= '(' ( lambdaExpression | lambdaExpressionInBrackets ) ( ',' ( logicalExpression | lambdaExpressionInBrackets ) )* cp= ')' ;
    public final Egx_EolParserRules.complexFeatureCall_return complexFeatureCall() throws RecognitionException {
        Egx_EolParserRules.complexFeatureCall_return retval = new Egx_EolParserRules.complexFeatureCall_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token op=null;
        Token cp=null;
        Token NAME134=null;
        Token char_literal137=null;
        Egx_EolParserRules.lambdaExpression_return lambdaExpression135 = null;

        Egx_EolParserRules.lambdaExpressionInBrackets_return lambdaExpressionInBrackets136 = null;

        Egx_EolParserRules.logicalExpression_return logicalExpression138 = null;

        Egx_EolParserRules.lambdaExpressionInBrackets_return lambdaExpressionInBrackets139 = null;


        org.eclipse.epsilon.common.parse.AST op_tree=null;
        org.eclipse.epsilon.common.parse.AST cp_tree=null;
        org.eclipse.epsilon.common.parse.AST NAME134_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal137_tree=null;

        try {
            // EolParserRules.g:466:2: ( NAME op= '(' ( lambdaExpression | lambdaExpressionInBrackets ) ( ',' ( logicalExpression | lambdaExpressionInBrackets ) )* cp= ')' )
            // EolParserRules.g:466:4: NAME op= '(' ( lambdaExpression | lambdaExpressionInBrackets ) ( ',' ( logicalExpression | lambdaExpressionInBrackets ) )* cp= ')'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            NAME134=(Token)match(input,NAME,FOLLOW_NAME_in_complexFeatureCall2099); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME134_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(NAME134);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(NAME134_tree, root_0);
            }
            op=(Token)match(input,100,FOLLOW_100_in_complexFeatureCall2104); if (state.failed) return retval;
            // EolParserRules.g:466:18: ( lambdaExpression | lambdaExpressionInBrackets )
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==NAME||(LA62_0>=161 && LA62_0<=162)) ) {
                alt62=1;
            }
            else if ( (LA62_0==100||LA62_0==159) ) {
                alt62=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;
            }
            switch (alt62) {
                case 1 :
                    // EolParserRules.g:466:19: lambdaExpression
                    {
                    pushFollow(FOLLOW_lambdaExpression_in_complexFeatureCall2108);
                    lambdaExpression135=lambdaExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, lambdaExpression135.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:466:38: lambdaExpressionInBrackets
                    {
                    pushFollow(FOLLOW_lambdaExpressionInBrackets_in_complexFeatureCall2112);
                    lambdaExpressionInBrackets136=lambdaExpressionInBrackets();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, lambdaExpressionInBrackets136.getTree());

                    }
                    break;

            }

            // EolParserRules.g:467:3: ( ',' ( logicalExpression | lambdaExpressionInBrackets ) )*
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==93) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // EolParserRules.g:467:4: ',' ( logicalExpression | lambdaExpressionInBrackets )
            	    {
            	    char_literal137=(Token)match(input,93,FOLLOW_93_in_complexFeatureCall2118); if (state.failed) return retval;
            	    // EolParserRules.g:467:9: ( logicalExpression | lambdaExpressionInBrackets )
            	    int alt63=2;
            	    switch ( input.LA(1) ) {
            	    case FLOAT:
            	    case INT:
            	    case BOOLEAN:
            	    case STRING:
            	    case NAME:
            	    case 108:
            	    case 109:
            	    case 110:
            	    case 111:
            	    case 112:
            	    case 113:
            	    case 114:
            	    case 115:
            	    case 116:
            	    case 117:
            	    case 118:
            	    case 153:
            	    case 156:
            	    case 163:
            	    case 164:
            	    case 165:
            	        {
            	        alt63=1;
            	        }
            	        break;
            	    case 100:
            	        {
            	        switch ( input.LA(2) ) {
            	        case NAME:
            	            {
            	            int LA63_4 = input.LA(3);

            	            if ( (LA63_4==POINT||LA63_4==ARROW||LA63_4==97||(LA63_4>=100 && LA63_4<=101)||(LA63_4>=105 && LA63_4<=107)||(LA63_4>=119 && LA63_4<=120)||(LA63_4>=143 && LA63_4<=155)||(LA63_4>=157 && LA63_4<=159)) ) {
            	                alt63=1;
            	            }
            	            else if ( (LA63_4==93||LA63_4==102||(LA63_4>=161 && LA63_4<=162)) ) {
            	                alt63=2;
            	            }
            	            else {
            	                if (state.backtracking>0) {state.failed=true; return retval;}
            	                NoViableAltException nvae =
            	                    new NoViableAltException("", 63, 4, input);

            	                throw nvae;
            	            }
            	            }
            	            break;
            	        case 161:
            	        case 162:
            	            {
            	            alt63=2;
            	            }
            	            break;
            	        case FLOAT:
            	        case INT:
            	        case BOOLEAN:
            	        case STRING:
            	        case 100:
            	        case 108:
            	        case 109:
            	        case 110:
            	        case 111:
            	        case 112:
            	        case 113:
            	        case 114:
            	        case 115:
            	        case 116:
            	        case 117:
            	        case 118:
            	        case 153:
            	        case 156:
            	        case 163:
            	        case 164:
            	        case 165:
            	            {
            	            alt63=1;
            	            }
            	            break;
            	        default:
            	            if (state.backtracking>0) {state.failed=true; return retval;}
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 63, 2, input);

            	            throw nvae;
            	        }

            	        }
            	        break;
            	    case 159:
            	        {
            	        alt63=2;
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
            	            // EolParserRules.g:467:10: logicalExpression
            	            {
            	            pushFollow(FOLLOW_logicalExpression_in_complexFeatureCall2122);
            	            logicalExpression138=logicalExpression();

            	            state._fsp--;
            	            if (state.failed) return retval;
            	            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression138.getTree());

            	            }
            	            break;
            	        case 2 :
            	            // EolParserRules.g:467:30: lambdaExpressionInBrackets
            	            {
            	            pushFollow(FOLLOW_lambdaExpressionInBrackets_in_complexFeatureCall2126);
            	            lambdaExpressionInBrackets139=lambdaExpressionInBrackets();

            	            state._fsp--;
            	            if (state.failed) return retval;
            	            if ( state.backtracking==0 ) adaptor.addChild(root_0, lambdaExpressionInBrackets139.getTree());

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop64;
                }
            } while (true);

            cp=(Token)match(input,101,FOLLOW_101_in_complexFeatureCall2133); if (state.failed) return retval;

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
    // $ANTLR end complexFeatureCall

    public static class lambdaExpressionInBrackets_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start lambdaExpressionInBrackets
    // EolParserRules.g:470:1: lambdaExpressionInBrackets : ( (lop= '(' lambdaExpression lcp= ')' ) | (lop= '[' lambdaExpression lcp= ']' ) );
    public final Egx_EolParserRules.lambdaExpressionInBrackets_return lambdaExpressionInBrackets() throws RecognitionException {
        Egx_EolParserRules.lambdaExpressionInBrackets_return retval = new Egx_EolParserRules.lambdaExpressionInBrackets_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token lop=null;
        Token lcp=null;
        Egx_EolParserRules.lambdaExpression_return lambdaExpression140 = null;

        Egx_EolParserRules.lambdaExpression_return lambdaExpression141 = null;


        org.eclipse.epsilon.common.parse.AST lop_tree=null;
        org.eclipse.epsilon.common.parse.AST lcp_tree=null;

        try {
            // EolParserRules.g:476:2: ( (lop= '(' lambdaExpression lcp= ')' ) | (lop= '[' lambdaExpression lcp= ']' ) )
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==100) ) {
                alt65=1;
            }
            else if ( (LA65_0==159) ) {
                alt65=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 65, 0, input);

                throw nvae;
            }
            switch (alt65) {
                case 1 :
                    // EolParserRules.g:476:4: (lop= '(' lambdaExpression lcp= ')' )
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    // EolParserRules.g:476:4: (lop= '(' lambdaExpression lcp= ')' )
                    // EolParserRules.g:476:5: lop= '(' lambdaExpression lcp= ')'
                    {
                    lop=(Token)match(input,100,FOLLOW_100_in_lambdaExpressionInBrackets2154); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    lop_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(lop);
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(lop_tree, root_0);
                    }
                    pushFollow(FOLLOW_lambdaExpression_in_lambdaExpressionInBrackets2157);
                    lambdaExpression140=lambdaExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, lambdaExpression140.getTree());
                    lcp=(Token)match(input,101,FOLLOW_101_in_lambdaExpressionInBrackets2161); if (state.failed) return retval;

                    }


                    }
                    break;
                case 2 :
                    // EolParserRules.g:477:3: (lop= '[' lambdaExpression lcp= ']' )
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    // EolParserRules.g:477:3: (lop= '[' lambdaExpression lcp= ']' )
                    // EolParserRules.g:477:4: lop= '[' lambdaExpression lcp= ']'
                    {
                    lop=(Token)match(input,159,FOLLOW_159_in_lambdaExpressionInBrackets2172); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    lop_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(lop);
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(lop_tree, root_0);
                    }
                    pushFollow(FOLLOW_lambdaExpression_in_lambdaExpressionInBrackets2175);
                    lambdaExpression141=lambdaExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, lambdaExpression141.getTree());
                    lcp=(Token)match(input,160,FOLLOW_160_in_lambdaExpressionInBrackets2179); if (state.failed) return retval;

                    }


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {

              		lop.setType(LAMBDAEXPR);
              		((org.eclipse.epsilon.common.parse.AST)retval.tree).getExtraTokens().add(lop);
              		((org.eclipse.epsilon.common.parse.AST)retval.tree).getExtraTokens().add(lcp);
              	
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
    // $ANTLR end lambdaExpressionInBrackets

    public static class lambdaExpression_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start lambdaExpression
    // EolParserRules.g:480:1: lambdaExpression : ( formalParameterList )? (lt= '|' | lt= '=>' ) logicalExpression ;
    public final Egx_EolParserRules.lambdaExpression_return lambdaExpression() throws RecognitionException {
        Egx_EolParserRules.lambdaExpression_return retval = new Egx_EolParserRules.lambdaExpression_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token lt=null;
        Egx_EolParserRules.formalParameterList_return formalParameterList142 = null;

        Egx_EolParserRules.logicalExpression_return logicalExpression143 = null;


        org.eclipse.epsilon.common.parse.AST lt_tree=null;

        try {
            // EolParserRules.g:484:2: ( ( formalParameterList )? (lt= '|' | lt= '=>' ) logicalExpression )
            // EolParserRules.g:484:4: ( formalParameterList )? (lt= '|' | lt= '=>' ) logicalExpression
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            // EolParserRules.g:484:4: ( formalParameterList )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==NAME) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // EolParserRules.g:0:0: formalParameterList
                    {
                    pushFollow(FOLLOW_formalParameterList_in_lambdaExpression2198);
                    formalParameterList142=formalParameterList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, formalParameterList142.getTree());

                    }
                    break;

            }

            // EolParserRules.g:484:25: (lt= '|' | lt= '=>' )
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==161) ) {
                alt67=1;
            }
            else if ( (LA67_0==162) ) {
                alt67=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 67, 0, input);

                throw nvae;
            }
            switch (alt67) {
                case 1 :
                    // EolParserRules.g:484:26: lt= '|'
                    {
                    lt=(Token)match(input,161,FOLLOW_161_in_lambdaExpression2204); if (state.failed) return retval;

                    }
                    break;
                case 2 :
                    // EolParserRules.g:484:36: lt= '=>'
                    {
                    lt=(Token)match(input,162,FOLLOW_162_in_lambdaExpression2211); if (state.failed) return retval;

                    }
                    break;

            }

            pushFollow(FOLLOW_logicalExpression_in_lambdaExpression2215);
            logicalExpression143=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression143.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {

              		((org.eclipse.epsilon.common.parse.AST)retval.tree).getExtraTokens().add(lt);
              	
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
    // $ANTLR end lambdaExpression

    public static class newExpression_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start newExpression
    // EolParserRules.g:487:1: newExpression : n= 'new' tn= typeName ( parameterList )? ;
    public final Egx_EolParserRules.newExpression_return newExpression() throws RecognitionException {
        Egx_EolParserRules.newExpression_return retval = new Egx_EolParserRules.newExpression_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token n=null;
        Egx_EolParserRules.typeName_return tn = null;

        Egx_EolParserRules.parameterList_return parameterList144 = null;


        org.eclipse.epsilon.common.parse.AST n_tree=null;

        try {
            // EolParserRules.g:488:2: (n= 'new' tn= typeName ( parameterList )? )
            // EolParserRules.g:488:4: n= 'new' tn= typeName ( parameterList )?
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            n=(Token)match(input,163,FOLLOW_163_in_newExpression2228); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            n_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(n);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(n_tree, root_0);
            }
            pushFollow(FOLLOW_typeName_in_newExpression2233);
            tn=typeName();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, tn.getTree());
            if ( state.backtracking==0 ) {
              setTokenType(tn,TYPE);
            }
            // EolParserRules.g:488:50: ( parameterList )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==100) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // EolParserRules.g:0:0: parameterList
                    {
                    pushFollow(FOLLOW_parameterList_in_newExpression2237);
                    parameterList144=parameterList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, parameterList144.getTree());

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
    // EolParserRules.g:492:1: variableDeclarationExpression : (v= 'var' | v= 'ext' ) NAME ( ':' (n= 'new' )? t= typeName ( parameterList )? )? ;
    public final Egx_EolParserRules.variableDeclarationExpression_return variableDeclarationExpression() throws RecognitionException {
        Egx_EolParserRules.variableDeclarationExpression_return retval = new Egx_EolParserRules.variableDeclarationExpression_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token v=null;
        Token n=null;
        Token NAME145=null;
        Token char_literal146=null;
        Egx_EolParserRules.typeName_return t = null;

        Egx_EolParserRules.parameterList_return parameterList147 = null;


        org.eclipse.epsilon.common.parse.AST v_tree=null;
        org.eclipse.epsilon.common.parse.AST n_tree=null;
        org.eclipse.epsilon.common.parse.AST NAME145_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal146_tree=null;

        try {
            // EolParserRules.g:498:2: ( (v= 'var' | v= 'ext' ) NAME ( ':' (n= 'new' )? t= typeName ( parameterList )? )? )
            // EolParserRules.g:498:4: (v= 'var' | v= 'ext' ) NAME ( ':' (n= 'new' )? t= typeName ( parameterList )? )?
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            // EolParserRules.g:498:4: (v= 'var' | v= 'ext' )
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==164) ) {
                alt69=1;
            }
            else if ( (LA69_0==165) ) {
                alt69=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 69, 0, input);

                throw nvae;
            }
            switch (alt69) {
                case 1 :
                    // EolParserRules.g:498:5: v= 'var'
                    {
                    v=(Token)match(input,164,FOLLOW_164_in_variableDeclarationExpression2261); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    v_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(v);
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(v_tree, root_0);
                    }

                    }
                    break;
                case 2 :
                    // EolParserRules.g:498:14: v= 'ext'
                    {
                    v=(Token)match(input,165,FOLLOW_165_in_variableDeclarationExpression2266); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    v_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(v);
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(v_tree, root_0);
                    }

                    }
                    break;

            }

            NAME145=(Token)match(input,NAME,FOLLOW_NAME_in_variableDeclarationExpression2270); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME145_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(NAME145);
            adaptor.addChild(root_0, NAME145_tree);
            }
            // EolParserRules.g:498:29: ( ':' (n= 'new' )? t= typeName ( parameterList )? )?
            int alt72=2;
            alt72 = dfa72.predict(input);
            switch (alt72) {
                case 1 :
                    // EolParserRules.g:498:30: ':' (n= 'new' )? t= typeName ( parameterList )?
                    {
                    char_literal146=(Token)match(input,102,FOLLOW_102_in_variableDeclarationExpression2273); if (state.failed) return retval;
                    // EolParserRules.g:498:36: (n= 'new' )?
                    int alt70=2;
                    int LA70_0 = input.LA(1);

                    if ( (LA70_0==163) ) {
                        alt70=1;
                    }
                    switch (alt70) {
                        case 1 :
                            // EolParserRules.g:0:0: n= 'new'
                            {
                            n=(Token)match(input,163,FOLLOW_163_in_variableDeclarationExpression2278); if (state.failed) return retval;

                            }
                            break;

                    }

                    pushFollow(FOLLOW_typeName_in_variableDeclarationExpression2284);
                    t=typeName();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, t.getTree());
                    if ( state.backtracking==0 ) {
                      setTokenType(t, TYPE);
                    }
                    // EolParserRules.g:498:81: ( parameterList )?
                    int alt71=2;
                    int LA71_0 = input.LA(1);

                    if ( (LA71_0==100) ) {
                        alt71=1;
                    }
                    switch (alt71) {
                        case 1 :
                            // EolParserRules.g:0:0: parameterList
                            {
                            pushFollow(FOLLOW_parameterList_in_variableDeclarationExpression2288);
                            parameterList147=parameterList();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, parameterList147.getTree());

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

              		String txt = n != null ? "new" : v.getText();
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
    // EolParserRules.g:501:1: literalSequentialCollection : (l= 'Collection' | l= 'Sequence' | l= 'List' | l= 'Bag' | l= 'Set' | l= 'OrderedSet' | l= 'ConcurrentBag' | l= 'ConcurrentSet' ) ob= '{' ( expressionListOrRange )? cb= '}' ;
    public final Egx_EolParserRules.literalSequentialCollection_return literalSequentialCollection() throws RecognitionException {
        Egx_EolParserRules.literalSequentialCollection_return retval = new Egx_EolParserRules.literalSequentialCollection_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token l=null;
        Token ob=null;
        Token cb=null;
        Egx_EolParserRules.expressionListOrRange_return expressionListOrRange148 = null;


        org.eclipse.epsilon.common.parse.AST l_tree=null;
        org.eclipse.epsilon.common.parse.AST ob_tree=null;
        org.eclipse.epsilon.common.parse.AST cb_tree=null;

        try {
            // EolParserRules.g:506:2: ( (l= 'Collection' | l= 'Sequence' | l= 'List' | l= 'Bag' | l= 'Set' | l= 'OrderedSet' | l= 'ConcurrentBag' | l= 'ConcurrentSet' ) ob= '{' ( expressionListOrRange )? cb= '}' )
            // EolParserRules.g:506:4: (l= 'Collection' | l= 'Sequence' | l= 'List' | l= 'Bag' | l= 'Set' | l= 'OrderedSet' | l= 'ConcurrentBag' | l= 'ConcurrentSet' ) ob= '{' ( expressionListOrRange )? cb= '}'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            // EolParserRules.g:506:4: (l= 'Collection' | l= 'Sequence' | l= 'List' | l= 'Bag' | l= 'Set' | l= 'OrderedSet' | l= 'ConcurrentBag' | l= 'ConcurrentSet' )
            int alt73=8;
            switch ( input.LA(1) ) {
            case 109:
                {
                alt73=1;
                }
                break;
            case 110:
                {
                alt73=2;
                }
                break;
            case 111:
                {
                alt73=3;
                }
                break;
            case 112:
                {
                alt73=4;
                }
                break;
            case 113:
                {
                alt73=5;
                }
                break;
            case 114:
                {
                alt73=6;
                }
                break;
            case 117:
                {
                alt73=7;
                }
                break;
            case 118:
                {
                alt73=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 73, 0, input);

                throw nvae;
            }

            switch (alt73) {
                case 1 :
                    // EolParserRules.g:506:5: l= 'Collection'
                    {
                    l=(Token)match(input,109,FOLLOW_109_in_literalSequentialCollection2312); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    l_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(l);
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(l_tree, root_0);
                    }

                    }
                    break;
                case 2 :
                    // EolParserRules.g:506:21: l= 'Sequence'
                    {
                    l=(Token)match(input,110,FOLLOW_110_in_literalSequentialCollection2317); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    l_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(l);
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(l_tree, root_0);
                    }

                    }
                    break;
                case 3 :
                    // EolParserRules.g:506:35: l= 'List'
                    {
                    l=(Token)match(input,111,FOLLOW_111_in_literalSequentialCollection2322); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    l_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(l);
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(l_tree, root_0);
                    }

                    }
                    break;
                case 4 :
                    // EolParserRules.g:506:45: l= 'Bag'
                    {
                    l=(Token)match(input,112,FOLLOW_112_in_literalSequentialCollection2327); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    l_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(l);
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(l_tree, root_0);
                    }

                    }
                    break;
                case 5 :
                    // EolParserRules.g:507:3: l= 'Set'
                    {
                    l=(Token)match(input,113,FOLLOW_113_in_literalSequentialCollection2335); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    l_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(l);
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(l_tree, root_0);
                    }

                    }
                    break;
                case 6 :
                    // EolParserRules.g:507:12: l= 'OrderedSet'
                    {
                    l=(Token)match(input,114,FOLLOW_114_in_literalSequentialCollection2340); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    l_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(l);
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(l_tree, root_0);
                    }

                    }
                    break;
                case 7 :
                    // EolParserRules.g:507:28: l= 'ConcurrentBag'
                    {
                    l=(Token)match(input,117,FOLLOW_117_in_literalSequentialCollection2345); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    l_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(l);
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(l_tree, root_0);
                    }

                    }
                    break;
                case 8 :
                    // EolParserRules.g:507:47: l= 'ConcurrentSet'
                    {
                    l=(Token)match(input,118,FOLLOW_118_in_literalSequentialCollection2350); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    l_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(l);
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(l_tree, root_0);
                    }

                    }
                    break;

            }

            ob=(Token)match(input,95,FOLLOW_95_in_literalSequentialCollection2358); if (state.failed) return retval;
            // EolParserRules.g:508:11: ( expressionListOrRange )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==FLOAT||LA74_0==INT||LA74_0==BOOLEAN||LA74_0==STRING||LA74_0==NAME||LA74_0==100||(LA74_0>=108 && LA74_0<=118)||LA74_0==153||LA74_0==156||(LA74_0>=163 && LA74_0<=165)) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // EolParserRules.g:0:0: expressionListOrRange
                    {
                    pushFollow(FOLLOW_expressionListOrRange_in_literalSequentialCollection2361);
                    expressionListOrRange148=expressionListOrRange();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionListOrRange148.getTree());

                    }
                    break;

            }

            cb=(Token)match(input,96,FOLLOW_96_in_literalSequentialCollection2366); if (state.failed) return retval;
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
    // EolParserRules.g:512:1: expressionRange : logicalExpression exp= '..' logicalExpression ;
    public final Egx_EolParserRules.expressionRange_return expressionRange() throws RecognitionException {
        Egx_EolParserRules.expressionRange_return retval = new Egx_EolParserRules.expressionRange_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token exp=null;
        Egx_EolParserRules.logicalExpression_return logicalExpression149 = null;

        Egx_EolParserRules.logicalExpression_return logicalExpression150 = null;


        org.eclipse.epsilon.common.parse.AST exp_tree=null;

        try {
            // EolParserRules.g:513:2: ( logicalExpression exp= '..' logicalExpression )
            // EolParserRules.g:513:4: logicalExpression exp= '..' logicalExpression
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            pushFollow(FOLLOW_logicalExpression_in_expressionRange2381);
            logicalExpression149=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression149.getTree());
            exp=(Token)match(input,POINT_POINT,FOLLOW_POINT_POINT_in_expressionRange2385); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            exp_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(exp);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(exp_tree, root_0);
            }
            pushFollow(FOLLOW_logicalExpression_in_expressionRange2388);
            logicalExpression150=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression150.getTree());
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
    // EolParserRules.g:517:1: expressionList : logicalExpression ( ',' logicalExpression )* -> ^( EXPRLIST ( logicalExpression )+ ) ;
    public final Egx_EolParserRules.expressionList_return expressionList() throws RecognitionException {
        Egx_EolParserRules.expressionList_return retval = new Egx_EolParserRules.expressionList_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token char_literal152=null;
        Egx_EolParserRules.logicalExpression_return logicalExpression151 = null;

        Egx_EolParserRules.logicalExpression_return logicalExpression153 = null;


        org.eclipse.epsilon.common.parse.AST char_literal152_tree=null;
        RewriteRuleTokenStream stream_93=new RewriteRuleTokenStream(adaptor,"token 93");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:521:2: ( logicalExpression ( ',' logicalExpression )* -> ^( EXPRLIST ( logicalExpression )+ ) )
            // EolParserRules.g:521:4: logicalExpression ( ',' logicalExpression )*
            {
            pushFollow(FOLLOW_logicalExpression_in_expressionList2409);
            logicalExpression151=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression151.getTree());
            // EolParserRules.g:521:22: ( ',' logicalExpression )*
            loop75:
            do {
                int alt75=2;
                int LA75_0 = input.LA(1);

                if ( (LA75_0==93) ) {
                    alt75=1;
                }


                switch (alt75) {
            	case 1 :
            	    // EolParserRules.g:521:23: ',' logicalExpression
            	    {
            	    char_literal152=(Token)match(input,93,FOLLOW_93_in_expressionList2412); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_93.add(char_literal152);

            	    pushFollow(FOLLOW_logicalExpression_in_expressionList2414);
            	    logicalExpression153=logicalExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression153.getTree());

            	    }
            	    break;

            	default :
            	    break loop75;
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
            // 522:2: -> ^( EXPRLIST ( logicalExpression )+ )
            {
                // EolParserRules.g:522:5: ^( EXPRLIST ( logicalExpression )+ )
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
    // EolParserRules.g:525:1: expressionListOrRange : ( expressionRange | expressionList );
    public final Egx_EolParserRules.expressionListOrRange_return expressionListOrRange() throws RecognitionException {
        Egx_EolParserRules.expressionListOrRange_return retval = new Egx_EolParserRules.expressionListOrRange_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Egx_EolParserRules.expressionRange_return expressionRange154 = null;

        Egx_EolParserRules.expressionList_return expressionList155 = null;



        try {
            // EolParserRules.g:526:2: ( expressionRange | expressionList )
            int alt76=2;
            alt76 = dfa76.predict(input);
            switch (alt76) {
                case 1 :
                    // EolParserRules.g:526:4: expressionRange
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_expressionRange_in_expressionListOrRange2438);
                    expressionRange154=expressionRange();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionRange154.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:526:22: expressionList
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_expressionList_in_expressionListOrRange2442);
                    expressionList155=expressionList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionList155.getTree());

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
    // EolParserRules.g:529:1: literalMapCollection : (m= 'Map' | m= 'ConcurrentMap' ) ob= '{' ( keyvalExpressionList )? cb= '}' ;
    public final Egx_EolParserRules.literalMapCollection_return literalMapCollection() throws RecognitionException {
        Egx_EolParserRules.literalMapCollection_return retval = new Egx_EolParserRules.literalMapCollection_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token m=null;
        Token ob=null;
        Token cb=null;
        Egx_EolParserRules.keyvalExpressionList_return keyvalExpressionList156 = null;


        org.eclipse.epsilon.common.parse.AST m_tree=null;
        org.eclipse.epsilon.common.parse.AST ob_tree=null;
        org.eclipse.epsilon.common.parse.AST cb_tree=null;

        try {
            // EolParserRules.g:534:2: ( (m= 'Map' | m= 'ConcurrentMap' ) ob= '{' ( keyvalExpressionList )? cb= '}' )
            // EolParserRules.g:534:4: (m= 'Map' | m= 'ConcurrentMap' ) ob= '{' ( keyvalExpressionList )? cb= '}'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            // EolParserRules.g:534:4: (m= 'Map' | m= 'ConcurrentMap' )
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==115) ) {
                alt77=1;
            }
            else if ( (LA77_0==116) ) {
                alt77=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 77, 0, input);

                throw nvae;
            }
            switch (alt77) {
                case 1 :
                    // EolParserRules.g:534:5: m= 'Map'
                    {
                    m=(Token)match(input,115,FOLLOW_115_in_literalMapCollection2462); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    m_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(m);
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(m_tree, root_0);
                    }

                    }
                    break;
                case 2 :
                    // EolParserRules.g:534:14: m= 'ConcurrentMap'
                    {
                    m=(Token)match(input,116,FOLLOW_116_in_literalMapCollection2467); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    m_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(m);
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(m_tree, root_0);
                    }

                    }
                    break;

            }

            ob=(Token)match(input,95,FOLLOW_95_in_literalMapCollection2473); if (state.failed) return retval;
            // EolParserRules.g:534:42: ( keyvalExpressionList )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==FLOAT||LA78_0==INT||LA78_0==BOOLEAN||LA78_0==STRING||LA78_0==NAME||LA78_0==100||(LA78_0>=108 && LA78_0<=118)||LA78_0==153||LA78_0==156||(LA78_0>=163 && LA78_0<=165)) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    // EolParserRules.g:0:0: keyvalExpressionList
                    {
                    pushFollow(FOLLOW_keyvalExpressionList_in_literalMapCollection2476);
                    keyvalExpressionList156=keyvalExpressionList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, keyvalExpressionList156.getTree());

                    }
                    break;

            }

            cb=(Token)match(input,96,FOLLOW_96_in_literalMapCollection2481); if (state.failed) return retval;
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
    // EolParserRules.g:538:1: keyvalExpressionList : keyvalExpression ( ',' keyvalExpression )* -> ^( KEYVALLIST ( keyvalExpression )+ ) ;
    public final Egx_EolParserRules.keyvalExpressionList_return keyvalExpressionList() throws RecognitionException {
        Egx_EolParserRules.keyvalExpressionList_return retval = new Egx_EolParserRules.keyvalExpressionList_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token char_literal158=null;
        Egx_EolParserRules.keyvalExpression_return keyvalExpression157 = null;

        Egx_EolParserRules.keyvalExpression_return keyvalExpression159 = null;


        org.eclipse.epsilon.common.parse.AST char_literal158_tree=null;
        RewriteRuleTokenStream stream_93=new RewriteRuleTokenStream(adaptor,"token 93");
        RewriteRuleSubtreeStream stream_keyvalExpression=new RewriteRuleSubtreeStream(adaptor,"rule keyvalExpression");
        try {
            // EolParserRules.g:542:2: ( keyvalExpression ( ',' keyvalExpression )* -> ^( KEYVALLIST ( keyvalExpression )+ ) )
            // EolParserRules.g:542:4: keyvalExpression ( ',' keyvalExpression )*
            {
            pushFollow(FOLLOW_keyvalExpression_in_keyvalExpressionList2502);
            keyvalExpression157=keyvalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_keyvalExpression.add(keyvalExpression157.getTree());
            // EolParserRules.g:542:21: ( ',' keyvalExpression )*
            loop79:
            do {
                int alt79=2;
                int LA79_0 = input.LA(1);

                if ( (LA79_0==93) ) {
                    alt79=1;
                }


                switch (alt79) {
            	case 1 :
            	    // EolParserRules.g:542:22: ',' keyvalExpression
            	    {
            	    char_literal158=(Token)match(input,93,FOLLOW_93_in_keyvalExpressionList2505); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_93.add(char_literal158);

            	    pushFollow(FOLLOW_keyvalExpression_in_keyvalExpressionList2507);
            	    keyvalExpression159=keyvalExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_keyvalExpression.add(keyvalExpression159.getTree());

            	    }
            	    break;

            	default :
            	    break loop79;
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
            // 543:2: -> ^( KEYVALLIST ( keyvalExpression )+ )
            {
                // EolParserRules.g:543:5: ^( KEYVALLIST ( keyvalExpression )+ )
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
    // EolParserRules.g:546:1: keyvalExpression : additiveExpression eq= '=' logicalExpression ;
    public final Egx_EolParserRules.keyvalExpression_return keyvalExpression() throws RecognitionException {
        Egx_EolParserRules.keyvalExpression_return retval = new Egx_EolParserRules.keyvalExpression_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token eq=null;
        Egx_EolParserRules.additiveExpression_return additiveExpression160 = null;

        Egx_EolParserRules.logicalExpression_return logicalExpression161 = null;


        org.eclipse.epsilon.common.parse.AST eq_tree=null;

        try {
            // EolParserRules.g:548:2: ( additiveExpression eq= '=' logicalExpression )
            // EolParserRules.g:548:4: additiveExpression eq= '=' logicalExpression
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            pushFollow(FOLLOW_additiveExpression_in_keyvalExpression2532);
            additiveExpression160=additiveExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, additiveExpression160.getTree());
            eq=(Token)match(input,97,FOLLOW_97_in_keyvalExpression2536); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            eq_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(eq);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(eq_tree, root_0);
            }
            pushFollow(FOLLOW_logicalExpression_in_keyvalExpression2539);
            logicalExpression161=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression161.getTree());
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
    // EolParserRules.g:551:1: primitiveExpression : ( literalSequentialCollection | literalMapCollection | literal | featureCall | pathName | nativeType | collectionType | logicalExpressionInBrackets | newExpression | variableDeclarationExpression );
    public final Egx_EolParserRules.primitiveExpression_return primitiveExpression() throws RecognitionException {
        Egx_EolParserRules.primitiveExpression_return retval = new Egx_EolParserRules.primitiveExpression_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Egx_EolParserRules.literalSequentialCollection_return literalSequentialCollection162 = null;

        Egx_EolParserRules.literalMapCollection_return literalMapCollection163 = null;

        Egx_EolParserRules.literal_return literal164 = null;

        Egx_EolParserRules.featureCall_return featureCall165 = null;

        Egx_EolParserRules.pathName_return pathName166 = null;

        Egx_EolParserRules.nativeType_return nativeType167 = null;

        Egx_EolParserRules.collectionType_return collectionType168 = null;

        Egx_EolParserRules.logicalExpressionInBrackets_return logicalExpressionInBrackets169 = null;

        Egx_EolParserRules.newExpression_return newExpression170 = null;

        Egx_EolParserRules.variableDeclarationExpression_return variableDeclarationExpression171 = null;



        try {
            // EolParserRules.g:552:2: ( literalSequentialCollection | literalMapCollection | literal | featureCall | pathName | nativeType | collectionType | logicalExpressionInBrackets | newExpression | variableDeclarationExpression )
            int alt80=10;
            alt80 = dfa80.predict(input);
            switch (alt80) {
                case 1 :
                    // EolParserRules.g:552:4: literalSequentialCollection
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_literalSequentialCollection_in_primitiveExpression2553);
                    literalSequentialCollection162=literalSequentialCollection();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, literalSequentialCollection162.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:552:34: literalMapCollection
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_literalMapCollection_in_primitiveExpression2557);
                    literalMapCollection163=literalMapCollection();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, literalMapCollection163.getTree());

                    }
                    break;
                case 3 :
                    // EolParserRules.g:552:57: literal
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_literal_in_primitiveExpression2561);
                    literal164=literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, literal164.getTree());

                    }
                    break;
                case 4 :
                    // EolParserRules.g:552:67: featureCall
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_featureCall_in_primitiveExpression2565);
                    featureCall165=featureCall();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, featureCall165.getTree());

                    }
                    break;
                case 5 :
                    // EolParserRules.g:552:81: pathName
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_pathName_in_primitiveExpression2569);
                    pathName166=pathName();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pathName166.getTree());

                    }
                    break;
                case 6 :
                    // EolParserRules.g:552:92: nativeType
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_nativeType_in_primitiveExpression2573);
                    nativeType167=nativeType();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nativeType167.getTree());

                    }
                    break;
                case 7 :
                    // EolParserRules.g:553:5: collectionType
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_collectionType_in_primitiveExpression2579);
                    collectionType168=collectionType();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, collectionType168.getTree());

                    }
                    break;
                case 8 :
                    // EolParserRules.g:553:22: logicalExpressionInBrackets
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_logicalExpressionInBrackets_in_primitiveExpression2583);
                    logicalExpressionInBrackets169=logicalExpressionInBrackets();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpressionInBrackets169.getTree());

                    }
                    break;
                case 9 :
                    // EolParserRules.g:554:5: newExpression
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_newExpression_in_primitiveExpression2589);
                    newExpression170=newExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, newExpression170.getTree());

                    }
                    break;
                case 10 :
                    // EolParserRules.g:554:21: variableDeclarationExpression
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_variableDeclarationExpression_in_primitiveExpression2593);
                    variableDeclarationExpression171=variableDeclarationExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, variableDeclarationExpression171.getTree());

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
    // EolParserRules.g:557:1: logicalExpressionInBrackets : ob= '(' logicalExpression cb= ')' ;
    public final Egx_EolParserRules.logicalExpressionInBrackets_return logicalExpressionInBrackets() throws RecognitionException {
        Egx_EolParserRules.logicalExpressionInBrackets_return retval = new Egx_EolParserRules.logicalExpressionInBrackets_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token ob=null;
        Token cb=null;
        Egx_EolParserRules.logicalExpression_return logicalExpression172 = null;


        org.eclipse.epsilon.common.parse.AST ob_tree=null;
        org.eclipse.epsilon.common.parse.AST cb_tree=null;

        try {
            // EolParserRules.g:563:2: (ob= '(' logicalExpression cb= ')' )
            // EolParserRules.g:563:4: ob= '(' logicalExpression cb= ')'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            ob=(Token)match(input,100,FOLLOW_100_in_logicalExpressionInBrackets2612); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ob_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(ob);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(ob_tree, root_0);
            }
            pushFollow(FOLLOW_logicalExpression_in_logicalExpressionInBrackets2615);
            logicalExpression172=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression172.getTree());
            cb=(Token)match(input,101,FOLLOW_101_in_logicalExpressionInBrackets2619); if (state.failed) return retval;
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
    // EolParserRules.g:567:1: literal : ( STRING | INT | FLOAT | BOOLEAN );
    public final Egx_EolParserRules.literal_return literal() throws RecognitionException {
        Egx_EolParserRules.literal_return retval = new Egx_EolParserRules.literal_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token set173=null;

        org.eclipse.epsilon.common.parse.AST set173_tree=null;

        try {
            // EolParserRules.g:568:2: ( STRING | INT | FLOAT | BOOLEAN )
            // EolParserRules.g:
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            set173=(Token)input.LT(1);
            if ( input.LA(1)==FLOAT||input.LA(1)==INT||input.LA(1)==BOOLEAN||input.LA(1)==STRING ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (org.eclipse.epsilon.common.parse.AST)adaptor.create(set173));
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
        // EolParserRules.g:205:4: ( annotation )
        // EolParserRules.g:205:4: annotation
        {
        pushFollow(FOLLOW_annotation_in_synpred16_EolParserRules692);
        annotation();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred16_EolParserRules

    // $ANTLR start synpred32_EolParserRules
    public final void synpred32_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:258:4: ( ( '(' typeName ( ',' typeName )* ')' ) )
        // EolParserRules.g:258:4: ( '(' typeName ( ',' typeName )* ')' )
        {
        // EolParserRules.g:258:4: ( '(' typeName ( ',' typeName )* ')' )
        // EolParserRules.g:258:5: '(' typeName ( ',' typeName )* ')'
        {
        match(input,100,FOLLOW_100_in_synpred32_EolParserRules883); if (state.failed) return ;
        pushFollow(FOLLOW_typeName_in_synpred32_EolParserRules888);
        typeName();

        state._fsp--;
        if (state.failed) return ;
        // EolParserRules.g:258:50: ( ',' typeName )*
        loop81:
        do {
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==93) ) {
                alt81=1;
            }


            switch (alt81) {
        	case 1 :
        	    // EolParserRules.g:258:51: ',' typeName
        	    {
        	    match(input,93,FOLLOW_93_in_synpred32_EolParserRules893); if (state.failed) return ;
        	    pushFollow(FOLLOW_typeName_in_synpred32_EolParserRules897);
        	    typeName();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop81;
            }
        } while (true);

        match(input,101,FOLLOW_101_in_synpred32_EolParserRules905); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred32_EolParserRules

    // $ANTLR start synpred34_EolParserRules
    public final void synpred34_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:259:4: ( ( '<' typeName ( ',' typeName )* '>' ) )
        // EolParserRules.g:259:4: ( '<' typeName ( ',' typeName )* '>' )
        {
        // EolParserRules.g:259:4: ( '<' typeName ( ',' typeName )* '>' )
        // EolParserRules.g:259:5: '<' typeName ( ',' typeName )* '>'
        {
        match(input,119,FOLLOW_119_in_synpred34_EolParserRules917); if (state.failed) return ;
        pushFollow(FOLLOW_typeName_in_synpred34_EolParserRules922);
        typeName();

        state._fsp--;
        if (state.failed) return ;
        // EolParserRules.g:259:50: ( ',' typeName )*
        loop82:
        do {
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==93) ) {
                alt82=1;
            }


            switch (alt82) {
        	case 1 :
        	    // EolParserRules.g:259:51: ',' typeName
        	    {
        	    match(input,93,FOLLOW_93_in_synpred34_EolParserRules927); if (state.failed) return ;
        	    pushFollow(FOLLOW_typeName_in_synpred34_EolParserRules931);
        	    typeName();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop82;
            }
        } while (true);

        match(input,120,FOLLOW_120_in_synpred34_EolParserRules939); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred34_EolParserRules

    // $ANTLR start synpred35_EolParserRules
    public final void synpred35_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:264:4: ( statementA )
        // EolParserRules.g:264:4: statementA
        {
        pushFollow(FOLLOW_statementA_in_synpred35_EolParserRules958);
        statementA();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred35_EolParserRules

    // $ANTLR start synpred36_EolParserRules
    public final void synpred36_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:268:4: ( assignmentStatement )
        // EolParserRules.g:268:4: assignmentStatement
        {
        pushFollow(FOLLOW_assignmentStatement_in_synpred36_EolParserRules973);
        assignmentStatement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred36_EolParserRules

    // $ANTLR start synpred37_EolParserRules
    public final void synpred37_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:268:26: ( expressionStatement )
        // EolParserRules.g:268:26: expressionStatement
        {
        pushFollow(FOLLOW_expressionStatement_in_synpred37_EolParserRules977);
        expressionStatement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred37_EolParserRules

    // $ANTLR start synpred51_EolParserRules
    public final void synpred51_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:286:66: ( elseStatement )
        // EolParserRules.g:286:66: elseStatement
        {
        pushFollow(FOLLOW_elseStatement_in_synpred51_EolParserRules1100);
        elseStatement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred51_EolParserRules

    // $ANTLR start synpred60_EolParserRules
    public final void synpred60_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:379:22: ( NAME ( ',' NAME )* )
        // EolParserRules.g:379:22: NAME ( ',' NAME )*
        {
        match(input,NAME,FOLLOW_NAME_in_synpred60_EolParserRules1511); if (state.failed) return ;
        // EolParserRules.g:379:27: ( ',' NAME )*
        loop83:
        do {
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==93) ) {
                alt83=1;
            }


            switch (alt83) {
        	case 1 :
        	    // EolParserRules.g:379:28: ',' NAME
        	    {
        	    match(input,93,FOLLOW_93_in_synpred60_EolParserRules1514); if (state.failed) return ;
        	    match(input,NAME,FOLLOW_NAME_in_synpred60_EolParserRules1516); if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop83;
            }
        } while (true);


        }
    }
    // $ANTLR end synpred60_EolParserRules

    // $ANTLR start synpred66_EolParserRules
    public final void synpred66_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:396:5: ( ( postfixExpression '=' logicalExpression ) )
        // EolParserRules.g:396:5: ( postfixExpression '=' logicalExpression )
        {
        // EolParserRules.g:396:5: ( postfixExpression '=' logicalExpression )
        // EolParserRules.g:396:6: postfixExpression '=' logicalExpression
        {
        pushFollow(FOLLOW_postfixExpression_in_synpred66_EolParserRules1612);
        postfixExpression();

        state._fsp--;
        if (state.failed) return ;
        match(input,97,FOLLOW_97_in_synpred66_EolParserRules1616); if (state.failed) return ;
        pushFollow(FOLLOW_logicalExpression_in_synpred66_EolParserRules1619);
        logicalExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred66_EolParserRules

    // $ANTLR start synpred79_EolParserRules
    public final void synpred79_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:408:24: ( ( '==' relationalExpression | '=' relationalExpression | ( '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression ) )
        // EolParserRules.g:408:24: ( '==' relationalExpression | '=' relationalExpression | ( '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression )
        {
        // EolParserRules.g:408:24: ( '==' relationalExpression | '=' relationalExpression | ( '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression )
        int alt85=3;
        switch ( input.LA(1) ) {
        case 148:
            {
            alt85=1;
            }
            break;
        case 97:
            {
            alt85=2;
            }
            break;
        case 119:
        case 120:
        case 149:
        case 150:
        case 151:
            {
            alt85=3;
            }
            break;
        default:
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 85, 0, input);

            throw nvae;
        }

        switch (alt85) {
            case 1 :
                // EolParserRules.g:408:25: '==' relationalExpression
                {
                match(input,148,FOLLOW_148_in_synpred79_EolParserRules1726); if (state.failed) return ;
                pushFollow(FOLLOW_relationalExpression_in_synpred79_EolParserRules1729);
                relationalExpression();

                state._fsp--;
                if (state.failed) return ;

                }
                break;
            case 2 :
                // EolParserRules.g:408:57: '=' relationalExpression
                {
                match(input,97,FOLLOW_97_in_synpred79_EolParserRules1735); if (state.failed) return ;
                pushFollow(FOLLOW_relationalExpression_in_synpred79_EolParserRules1738);
                relationalExpression();

                state._fsp--;
                if (state.failed) return ;

                }
                break;
            case 3 :
                // EolParserRules.g:409:24: ( '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression
                {
                if ( (input.LA(1)>=119 && input.LA(1)<=120)||(input.LA(1)>=149 && input.LA(1)<=151) ) {
                    input.consume();
                    state.errorRecovery=false;state.failed=false;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    MismatchedSetException mse = new MismatchedSetException(null,input);
                    throw mse;
                }

                pushFollow(FOLLOW_additiveExpression_in_synpred79_EolParserRules1792);
                additiveExpression();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        }
    }
    // $ANTLR end synpred79_EolParserRules

    // $ANTLR start synpred106_EolParserRules
    public final void synpred106_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:498:30: ( ':' ( 'new' )? typeName ( parameterList )? )
        // EolParserRules.g:498:30: ':' ( 'new' )? typeName ( parameterList )?
        {
        match(input,102,FOLLOW_102_in_synpred106_EolParserRules2273); if (state.failed) return ;
        // EolParserRules.g:498:36: ( 'new' )?
        int alt89=2;
        int LA89_0 = input.LA(1);

        if ( (LA89_0==163) ) {
            alt89=1;
        }
        switch (alt89) {
            case 1 :
                // EolParserRules.g:0:0: 'new'
                {
                match(input,163,FOLLOW_163_in_synpred106_EolParserRules2278); if (state.failed) return ;

                }
                break;

        }

        pushFollow(FOLLOW_typeName_in_synpred106_EolParserRules2284);
        typeName();

        state._fsp--;
        if (state.failed) return ;
        // EolParserRules.g:498:81: ( parameterList )?
        int alt90=2;
        int LA90_0 = input.LA(1);

        if ( (LA90_0==100) ) {
            alt90=1;
        }
        switch (alt90) {
            case 1 :
                // EolParserRules.g:0:0: parameterList
                {
                pushFollow(FOLLOW_parameterList_in_synpred106_EolParserRules2288);
                parameterList();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        }
    }
    // $ANTLR end synpred106_EolParserRules

    // $ANTLR start synpred116_EolParserRules
    public final void synpred116_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:526:4: ( expressionRange )
        // EolParserRules.g:526:4: expressionRange
        {
        pushFollow(FOLLOW_expressionRange_in_synpred116_EolParserRules2438);
        expressionRange();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred116_EolParserRules

    // $ANTLR start synpred120_EolParserRules
    public final void synpred120_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:552:4: ( literalSequentialCollection )
        // EolParserRules.g:552:4: literalSequentialCollection
        {
        pushFollow(FOLLOW_literalSequentialCollection_in_synpred120_EolParserRules2553);
        literalSequentialCollection();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred120_EolParserRules

    // $ANTLR start synpred121_EolParserRules
    public final void synpred121_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:552:34: ( literalMapCollection )
        // EolParserRules.g:552:34: literalMapCollection
        {
        pushFollow(FOLLOW_literalMapCollection_in_synpred121_EolParserRules2557);
        literalMapCollection();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred121_EolParserRules

    // $ANTLR start synpred123_EolParserRules
    public final void synpred123_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:552:67: ( featureCall )
        // EolParserRules.g:552:67: featureCall
        {
        pushFollow(FOLLOW_featureCall_in_synpred123_EolParserRules2565);
        featureCall();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred123_EolParserRules

    // $ANTLR start synpred124_EolParserRules
    public final void synpred124_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:552:81: ( pathName )
        // EolParserRules.g:552:81: pathName
        {
        pushFollow(FOLLOW_pathName_in_synpred124_EolParserRules2569);
        pathName();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred124_EolParserRules

    // $ANTLR start synpred126_EolParserRules
    public final void synpred126_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:553:5: ( collectionType )
        // EolParserRules.g:553:5: collectionType
        {
        pushFollow(FOLLOW_collectionType_in_synpred126_EolParserRules2579);
        collectionType();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred126_EolParserRules

    // Delegated rules

    public final boolean synpred123_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred123_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred60_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred60_EolParserRules_fragment(); // can never throw exception
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
    public final boolean synpred121_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred121_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred36_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred36_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred51_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred51_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred66_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred66_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred106_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred106_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred124_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred124_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred34_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred34_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred79_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred79_EolParserRules_fragment(); // can never throw exception
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
    public final boolean synpred126_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred126_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred35_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred35_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred37_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred37_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred116_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred116_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred120_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred120_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA22 dfa22 = new DFA22(this);
    protected DFA23 dfa23 = new DFA23(this);
    protected DFA24 dfa24 = new DFA24(this);
    protected DFA37 dfa37 = new DFA37(this);
    protected DFA40 dfa40 = new DFA40(this);
    protected DFA46 dfa46 = new DFA46(this);
    protected DFA58 dfa58 = new DFA58(this);
    protected DFA72 dfa72 = new DFA72(this);
    protected DFA76 dfa76 = new DFA76(this);
    protected DFA80 dfa80 = new DFA80(this);
    static final String DFA22_eotS =
        "\71\uffff";
    static final String DFA22_eofS =
        "\1\3\70\uffff";
    static final String DFA22_minS =
        "\1\11\2\0\66\uffff";
    static final String DFA22_maxS =
        "\1\u00b1\2\0\66\uffff";
    static final String DFA22_acceptS =
        "\3\uffff\1\3\63\uffff\1\1\1\2";
    static final String DFA22_specialS =
        "\1\uffff\1\0\1\1\66\uffff}>";
    static final String[] DFA22_transitionS = {
            "\3\3\7\uffff\1\3\3\uffff\1\3\103\uffff\1\3\1\uffff\1\3\1\uffff"+
            "\5\3\1\1\2\3\1\uffff\1\3\16\uffff\1\2\1\3\1\uffff\1\3\4\uffff"+
            "\1\3\11\uffff\23\3\1\uffff\6\3\3\uffff\3\3\1\uffff\1\3\1\uffff"+
            "\6\3",
            "\1\uffff",
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
            return "258:3: ( (op= '(' tn= typeName ( ',' tn= typeName )* cp= ')' ) | (op= '<' tn= typeName ( ',' tn= typeName )* cp= '>' ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA22_1 = input.LA(1);

                         
                        int index22_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred32_EolParserRules()) ) {s = 55;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index22_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA22_2 = input.LA(1);

                         
                        int index22_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred34_EolParserRules()) ) {s = 56;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index22_2);
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
        "\40\uffff";
    static final String DFA23_eofS =
        "\40\uffff";
    static final String DFA23_minS =
        "\1\4\27\uffff\1\0\7\uffff";
    static final String DFA23_maxS =
        "\1\u00a5\27\uffff\1\0\7\uffff";
    static final String DFA23_acceptS =
        "\1\uffff\1\1\30\uffff\1\2\5\uffff";
    static final String DFA23_specialS =
        "\30\uffff\1\0\7\uffff}>";
    static final String[] DFA23_transitionS = {
            "\1\1\3\uffff\1\1\3\uffff\1\1\1\uffff\1\1\4\uffff\1\1\120\uffff"+
            "\1\1\7\uffff\13\1\2\uffff\1\1\1\uffff\1\1\2\uffff\1\1\1\uffff"+
            "\1\1\1\30\2\32\1\1\4\32\20\uffff\1\1\2\uffff\1\1\6\uffff\3\1",
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
            "\1\uffff",
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
            return "263:1: statement : ( statementA | statementB );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA23_24 = input.LA(1);

                         
                        int index23_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred35_EolParserRules()) ) {s = 1;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index23_24);
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
    static final String DFA24_eotS =
        "\34\uffff";
    static final String DFA24_eofS =
        "\34\uffff";
    static final String DFA24_minS =
        "\1\4\23\0\10\uffff";
    static final String DFA24_maxS =
        "\1\u00a5\23\0\10\uffff";
    static final String DFA24_acceptS =
        "\24\uffff\1\3\1\4\1\5\1\6\1\7\1\10\1\1\1\2";
    static final String DFA24_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1"+
        "\14\1\15\1\16\1\17\1\20\1\21\1\22\10\uffff}>";
    static final String[] DFA24_transitionS = {
            "\1\15\3\uffff\1\15\3\uffff\1\15\1\uffff\1\15\4\uffff\1\16\120"+
            "\uffff\1\20\7\uffff\1\17\1\3\1\4\1\5\1\6\1\7\1\10\1\13\1\14"+
            "\1\11\1\12\2\uffff\1\25\1\uffff\1\27\2\uffff\1\24\1\uffff\1"+
            "\26\1\30\2\uffff\1\31\24\uffff\1\2\2\uffff\1\1\6\uffff\1\21"+
            "\1\22\1\23",
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

    static final short[] DFA24_eot = DFA.unpackEncodedString(DFA24_eotS);
    static final short[] DFA24_eof = DFA.unpackEncodedString(DFA24_eofS);
    static final char[] DFA24_min = DFA.unpackEncodedStringToUnsignedChars(DFA24_minS);
    static final char[] DFA24_max = DFA.unpackEncodedStringToUnsignedChars(DFA24_maxS);
    static final short[] DFA24_accept = DFA.unpackEncodedString(DFA24_acceptS);
    static final short[] DFA24_special = DFA.unpackEncodedString(DFA24_specialS);
    static final short[][] DFA24_transition;

    static {
        int numStates = DFA24_transitionS.length;
        DFA24_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA24_transition[i] = DFA.unpackEncodedString(DFA24_transitionS[i]);
        }
    }

    class DFA24 extends DFA {

        public DFA24(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 24;
            this.eot = DFA24_eot;
            this.eof = DFA24_eof;
            this.min = DFA24_min;
            this.max = DFA24_max;
            this.accept = DFA24_accept;
            this.special = DFA24_special;
            this.transition = DFA24_transition;
        }
        public String getDescription() {
            return "267:1: statementA : ( assignmentStatement | expressionStatement | forStatement | ifStatement | whileStatement | switchStatement | returnStatement | breakStatement );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA24_1 = input.LA(1);

                         
                        int index24_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred36_EolParserRules()) ) {s = 26;}

                        else if ( (synpred37_EolParserRules()) ) {s = 27;}

                         
                        input.seek(index24_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA24_2 = input.LA(1);

                         
                        int index24_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred36_EolParserRules()) ) {s = 26;}

                        else if ( (synpred37_EolParserRules()) ) {s = 27;}

                         
                        input.seek(index24_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA24_3 = input.LA(1);

                         
                        int index24_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred36_EolParserRules()) ) {s = 26;}

                        else if ( (synpred37_EolParserRules()) ) {s = 27;}

                         
                        input.seek(index24_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA24_4 = input.LA(1);

                         
                        int index24_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred36_EolParserRules()) ) {s = 26;}

                        else if ( (synpred37_EolParserRules()) ) {s = 27;}

                         
                        input.seek(index24_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA24_5 = input.LA(1);

                         
                        int index24_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred36_EolParserRules()) ) {s = 26;}

                        else if ( (synpred37_EolParserRules()) ) {s = 27;}

                         
                        input.seek(index24_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA24_6 = input.LA(1);

                         
                        int index24_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred36_EolParserRules()) ) {s = 26;}

                        else if ( (synpred37_EolParserRules()) ) {s = 27;}

                         
                        input.seek(index24_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA24_7 = input.LA(1);

                         
                        int index24_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred36_EolParserRules()) ) {s = 26;}

                        else if ( (synpred37_EolParserRules()) ) {s = 27;}

                         
                        input.seek(index24_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA24_8 = input.LA(1);

                         
                        int index24_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred36_EolParserRules()) ) {s = 26;}

                        else if ( (synpred37_EolParserRules()) ) {s = 27;}

                         
                        input.seek(index24_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA24_9 = input.LA(1);

                         
                        int index24_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred36_EolParserRules()) ) {s = 26;}

                        else if ( (synpred37_EolParserRules()) ) {s = 27;}

                         
                        input.seek(index24_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA24_10 = input.LA(1);

                         
                        int index24_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred36_EolParserRules()) ) {s = 26;}

                        else if ( (synpred37_EolParserRules()) ) {s = 27;}

                         
                        input.seek(index24_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA24_11 = input.LA(1);

                         
                        int index24_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred36_EolParserRules()) ) {s = 26;}

                        else if ( (synpred37_EolParserRules()) ) {s = 27;}

                         
                        input.seek(index24_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA24_12 = input.LA(1);

                         
                        int index24_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred36_EolParserRules()) ) {s = 26;}

                        else if ( (synpred37_EolParserRules()) ) {s = 27;}

                         
                        input.seek(index24_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA24_13 = input.LA(1);

                         
                        int index24_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred36_EolParserRules()) ) {s = 26;}

                        else if ( (synpred37_EolParserRules()) ) {s = 27;}

                         
                        input.seek(index24_13);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA24_14 = input.LA(1);

                         
                        int index24_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred36_EolParserRules()) ) {s = 26;}

                        else if ( (synpred37_EolParserRules()) ) {s = 27;}

                         
                        input.seek(index24_14);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA24_15 = input.LA(1);

                         
                        int index24_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred36_EolParserRules()) ) {s = 26;}

                        else if ( (synpred37_EolParserRules()) ) {s = 27;}

                         
                        input.seek(index24_15);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA24_16 = input.LA(1);

                         
                        int index24_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred36_EolParserRules()) ) {s = 26;}

                        else if ( (synpred37_EolParserRules()) ) {s = 27;}

                         
                        input.seek(index24_16);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA24_17 = input.LA(1);

                         
                        int index24_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred36_EolParserRules()) ) {s = 26;}

                        else if ( (synpred37_EolParserRules()) ) {s = 27;}

                         
                        input.seek(index24_17);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA24_18 = input.LA(1);

                         
                        int index24_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred36_EolParserRules()) ) {s = 26;}

                        else if ( (synpred37_EolParserRules()) ) {s = 27;}

                         
                        input.seek(index24_18);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA24_19 = input.LA(1);

                         
                        int index24_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred36_EolParserRules()) ) {s = 26;}

                        else if ( (synpred37_EolParserRules()) ) {s = 27;}

                         
                        input.seek(index24_19);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 24, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA37_eotS =
        "\42\uffff";
    static final String DFA37_eofS =
        "\42\uffff";
    static final String DFA37_minS =
        "\1\4\1\0\40\uffff";
    static final String DFA37_maxS =
        "\1\u00a5\1\0\40\uffff";
    static final String DFA37_acceptS =
        "\2\uffff\1\2\36\uffff\1\1";
    static final String DFA37_specialS =
        "\1\uffff\1\0\40\uffff}>";
    static final String[] DFA37_transitionS = {
            "\1\2\3\uffff\1\2\3\uffff\1\2\1\uffff\1\2\4\uffff\1\1\113\uffff"+
            "\1\2\4\uffff\1\2\7\uffff\13\2\2\uffff\1\2\1\uffff\1\2\2\uffff"+
            "\1\2\1\uffff\11\2\20\uffff\1\2\2\uffff\1\2\6\uffff\3\2",
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
            ""
    };

    static final short[] DFA37_eot = DFA.unpackEncodedString(DFA37_eotS);
    static final short[] DFA37_eof = DFA.unpackEncodedString(DFA37_eofS);
    static final char[] DFA37_min = DFA.unpackEncodedStringToUnsignedChars(DFA37_minS);
    static final char[] DFA37_max = DFA.unpackEncodedStringToUnsignedChars(DFA37_maxS);
    static final short[] DFA37_accept = DFA.unpackEncodedString(DFA37_acceptS);
    static final short[] DFA37_special = DFA.unpackEncodedString(DFA37_specialS);
    static final short[][] DFA37_transition;

    static {
        int numStates = DFA37_transitionS.length;
        DFA37_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA37_transition[i] = DFA.unpackEncodedString(DFA37_transitionS[i]);
        }
    }

    class DFA37 extends DFA {

        public DFA37(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 37;
            this.eot = DFA37_eot;
            this.eof = DFA37_eof;
            this.min = DFA37_min;
            this.max = DFA37_max;
            this.accept = DFA37_accept;
            this.special = DFA37_special;
            this.transition = DFA37_transition;
        }
        public String getDescription() {
            return "379:21: ( NAME ( ',' NAME )* )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA37_1 = input.LA(1);

                         
                        int index37_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred60_EolParserRules()) ) {s = 33;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index37_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 37, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA40_eotS =
        "\25\uffff";
    static final String DFA40_eofS =
        "\25\uffff";
    static final String DFA40_minS =
        "\1\4\21\0\3\uffff";
    static final String DFA40_maxS =
        "\1\u00a5\21\0\3\uffff";
    static final String DFA40_acceptS =
        "\22\uffff\1\2\1\uffff\1\1";
    static final String DFA40_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1"+
        "\14\1\15\1\16\1\17\1\20\3\uffff}>";
    static final String[] DFA40_transitionS = {
            "\1\13\3\uffff\1\13\3\uffff\1\13\1\uffff\1\13\4\uffff\1\14\120"+
            "\uffff\1\16\7\uffff\1\15\1\1\1\2\1\3\1\4\1\5\1\6\1\11\1\12\1"+
            "\7\1\10\42\uffff\1\22\2\uffff\1\22\6\uffff\1\17\1\20\1\21",
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
            "\1\uffff",
            "",
            "",
            ""
    };

    static final short[] DFA40_eot = DFA.unpackEncodedString(DFA40_eotS);
    static final short[] DFA40_eof = DFA.unpackEncodedString(DFA40_eofS);
    static final char[] DFA40_min = DFA.unpackEncodedStringToUnsignedChars(DFA40_minS);
    static final char[] DFA40_max = DFA.unpackEncodedStringToUnsignedChars(DFA40_maxS);
    static final short[] DFA40_accept = DFA.unpackEncodedString(DFA40_acceptS);
    static final short[] DFA40_special = DFA.unpackEncodedString(DFA40_specialS);
    static final short[][] DFA40_transition;

    static {
        int numStates = DFA40_transitionS.length;
        DFA40_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA40_transition[i] = DFA.unpackEncodedString(DFA40_transitionS[i]);
        }
    }

    class DFA40 extends DFA {

        public DFA40(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 40;
            this.eot = DFA40_eot;
            this.eof = DFA40_eof;
            this.min = DFA40_min;
            this.max = DFA40_max;
            this.accept = DFA40_accept;
            this.special = DFA40_special;
            this.transition = DFA40_transition;
        }
        public String getDescription() {
            return "396:4: ( ( postfixExpression op= '=' logicalExpression ) | logicalExpression )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA40_1 = input.LA(1);

                         
                        int index40_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred66_EolParserRules()) ) {s = 20;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index40_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA40_2 = input.LA(1);

                         
                        int index40_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred66_EolParserRules()) ) {s = 20;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index40_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA40_3 = input.LA(1);

                         
                        int index40_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred66_EolParserRules()) ) {s = 20;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index40_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA40_4 = input.LA(1);

                         
                        int index40_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred66_EolParserRules()) ) {s = 20;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index40_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA40_5 = input.LA(1);

                         
                        int index40_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred66_EolParserRules()) ) {s = 20;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index40_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA40_6 = input.LA(1);

                         
                        int index40_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred66_EolParserRules()) ) {s = 20;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index40_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA40_7 = input.LA(1);

                         
                        int index40_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred66_EolParserRules()) ) {s = 20;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index40_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA40_8 = input.LA(1);

                         
                        int index40_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred66_EolParserRules()) ) {s = 20;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index40_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA40_9 = input.LA(1);

                         
                        int index40_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred66_EolParserRules()) ) {s = 20;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index40_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA40_10 = input.LA(1);

                         
                        int index40_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred66_EolParserRules()) ) {s = 20;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index40_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA40_11 = input.LA(1);

                         
                        int index40_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred66_EolParserRules()) ) {s = 20;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index40_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA40_12 = input.LA(1);

                         
                        int index40_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred66_EolParserRules()) ) {s = 20;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index40_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA40_13 = input.LA(1);

                         
                        int index40_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred66_EolParserRules()) ) {s = 20;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index40_13);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA40_14 = input.LA(1);

                         
                        int index40_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred66_EolParserRules()) ) {s = 20;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index40_14);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA40_15 = input.LA(1);

                         
                        int index40_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred66_EolParserRules()) ) {s = 20;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index40_15);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA40_16 = input.LA(1);

                         
                        int index40_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred66_EolParserRules()) ) {s = 20;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index40_16);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA40_17 = input.LA(1);

                         
                        int index40_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred66_EolParserRules()) ) {s = 20;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index40_17);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 40, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA46_eotS =
        "\12\uffff";
    static final String DFA46_eofS =
        "\1\1\11\uffff";
    static final String DFA46_minS =
        "\1\12\1\uffff\7\0\1\uffff";
    static final String DFA46_maxS =
        "\1\u00b1\1\uffff\7\0\1\uffff";
    static final String DFA46_acceptS =
        "\1\uffff\1\2\7\uffff\1\1";
    static final String DFA46_specialS =
        "\2\uffff\1\5\1\4\1\2\1\0\1\3\1\1\1\6\1\uffff}>";
    static final String[] DFA46_transitionS = {
            "\1\1\14\uffff\1\1\103\uffff\1\1\1\uffff\1\1\1\uffff\2\1\1\3"+
            "\2\1\1\uffff\2\1\1\uffff\1\1\16\uffff\1\5\1\4\1\uffff\1\1\16"+
            "\uffff\13\1\1\2\1\6\1\7\1\10\10\uffff\1\1\5\uffff\3\1\1\uffff"+
            "\1\1\1\uffff\6\1",
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

    static final short[] DFA46_eot = DFA.unpackEncodedString(DFA46_eotS);
    static final short[] DFA46_eof = DFA.unpackEncodedString(DFA46_eofS);
    static final char[] DFA46_min = DFA.unpackEncodedStringToUnsignedChars(DFA46_minS);
    static final char[] DFA46_max = DFA.unpackEncodedStringToUnsignedChars(DFA46_maxS);
    static final short[] DFA46_accept = DFA.unpackEncodedString(DFA46_acceptS);
    static final short[] DFA46_special = DFA.unpackEncodedString(DFA46_specialS);
    static final short[][] DFA46_transition;

    static {
        int numStates = DFA46_transitionS.length;
        DFA46_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA46_transition[i] = DFA.unpackEncodedString(DFA46_transitionS[i]);
        }
    }

    class DFA46 extends DFA {

        public DFA46(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 46;
            this.eot = DFA46_eot;
            this.eof = DFA46_eof;
            this.min = DFA46_min;
            this.max = DFA46_max;
            this.accept = DFA46_accept;
            this.special = DFA46_special;
            this.transition = DFA46_transition;
        }
        public String getDescription() {
            return "()* loopback of 408:23: ( (op= '==' relationalExpression | op= '=' relationalExpression | (op= '>' | op= '<' | op= '>=' | op= '<=' | op= '<>' ) additiveExpression ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA46_5 = input.LA(1);

                         
                        int index46_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred79_EolParserRules()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index46_5);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA46_7 = input.LA(1);

                         
                        int index46_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred79_EolParserRules()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index46_7);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA46_4 = input.LA(1);

                         
                        int index46_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred79_EolParserRules()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index46_4);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA46_6 = input.LA(1);

                         
                        int index46_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred79_EolParserRules()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index46_6);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA46_3 = input.LA(1);

                         
                        int index46_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred79_EolParserRules()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index46_3);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA46_2 = input.LA(1);

                         
                        int index46_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred79_EolParserRules()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index46_2);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA46_8 = input.LA(1);

                         
                        int index46_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred79_EolParserRules()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index46_8);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 46, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA58_eotS =
        "\12\uffff";
    static final String DFA58_eofS =
        "\1\uffff\1\3\10\uffff";
    static final String DFA58_minS =
        "\1\23\1\11\1\4\1\uffff\1\11\1\uffff\2\4\2\11";
    static final String DFA58_maxS =
        "\1\23\1\u00b1\1\u00a5\1\uffff\1\u00a2\1\uffff\2\u00a5\2\u00a2";
    static final String DFA58_acceptS =
        "\3\uffff\1\1\1\uffff\1\2\4\uffff";
    static final String DFA58_specialS =
        "\12\uffff}>";
    static final String[] DFA58_transitionS = {
            "\1\1",
            "\3\3\13\uffff\1\3\103\uffff\1\3\1\uffff\1\3\1\uffff\5\3\1"+
            "\2\2\3\1\uffff\1\3\16\uffff\2\3\1\uffff\1\3\16\uffff\23\3\1"+
            "\uffff\4\3\5\uffff\3\3\1\uffff\1\3\1\uffff\6\3",
            "\1\3\3\uffff\1\3\3\uffff\1\3\1\uffff\1\3\4\uffff\1\4\120\uffff"+
            "\1\6\1\3\6\uffff\13\3\42\uffff\1\3\2\uffff\1\3\2\uffff\1\5\1"+
            "\uffff\2\5\3\3",
            "",
            "\1\3\1\uffff\1\3\121\uffff\1\7\3\uffff\1\3\2\uffff\2\3\1\5"+
            "\2\uffff\3\3\13\uffff\2\3\26\uffff\15\3\1\uffff\3\3\1\uffff"+
            "\2\5",
            "",
            "\1\3\3\uffff\1\3\3\uffff\1\3\1\uffff\1\3\4\uffff\1\10\120"+
            "\uffff\1\3\7\uffff\13\3\42\uffff\1\3\2\uffff\1\3\4\uffff\2\5"+
            "\3\3",
            "\1\3\3\uffff\1\3\3\uffff\1\3\1\uffff\1\3\4\uffff\1\11\120"+
            "\uffff\1\3\7\uffff\13\3\42\uffff\1\3\2\uffff\1\3\6\uffff\3\3",
            "\1\3\1\uffff\1\3\121\uffff\1\5\3\uffff\1\3\2\uffff\2\3\1\5"+
            "\2\uffff\3\3\13\uffff\2\3\26\uffff\15\3\1\uffff\3\3\1\uffff"+
            "\2\5",
            "\1\3\1\uffff\1\3\121\uffff\1\7\3\uffff\1\3\2\uffff\2\3\1\5"+
            "\2\uffff\3\3\13\uffff\2\3\26\uffff\15\3\1\uffff\3\3\1\uffff"+
            "\2\5"
    };

    static final short[] DFA58_eot = DFA.unpackEncodedString(DFA58_eotS);
    static final short[] DFA58_eof = DFA.unpackEncodedString(DFA58_eofS);
    static final char[] DFA58_min = DFA.unpackEncodedStringToUnsignedChars(DFA58_minS);
    static final char[] DFA58_max = DFA.unpackEncodedStringToUnsignedChars(DFA58_maxS);
    static final short[] DFA58_accept = DFA.unpackEncodedString(DFA58_acceptS);
    static final short[] DFA58_special = DFA.unpackEncodedString(DFA58_specialS);
    static final short[][] DFA58_transition;

    static {
        int numStates = DFA58_transitionS.length;
        DFA58_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA58_transition[i] = DFA.unpackEncodedString(DFA58_transitionS[i]);
        }
    }

    class DFA58 extends DFA {

        public DFA58(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 58;
            this.eot = DFA58_eot;
            this.eof = DFA58_eof;
            this.min = DFA58_min;
            this.max = DFA58_max;
            this.accept = DFA58_accept;
            this.special = DFA58_special;
            this.transition = DFA58_transition;
        }
        public String getDescription() {
            return "442:1: featureCall : ( simpleFeatureCall | complexFeatureCall );";
        }
    }
    static final String DFA72_eotS =
        "\32\uffff";
    static final String DFA72_eofS =
        "\2\2\30\uffff";
    static final String DFA72_minS =
        "\1\11\1\4\1\uffff\13\0\1\144\1\23\1\uffff\1\16\1\0\1\144\1\0\1"+
        "\145\1\16\1\0\1\145\1\0";
    static final String DFA72_maxS =
        "\1\u00b1\1\u00a5\1\uffff\13\0\1\144\1\166\1\uffff\1\16\1\0\1\144"+
        "\1\0\1\145\1\16\1\0\1\145\1\0";
    static final String DFA72_acceptS =
        "\2\uffff\1\2\15\uffff\1\1\11\uffff";
    static final String DFA72_specialS =
        "\3\uffff\1\11\1\15\1\3\1\10\1\14\1\2\1\6\1\12\1\7\1\13\1\0\4\uffff"+
        "\1\5\1\uffff\1\1\2\uffff\1\16\1\uffff\1\4}>";
    static final String[] DFA72_transitionS = {
            "\3\2\13\uffff\1\2\103\uffff\1\2\1\uffff\1\2\1\uffff\5\2\1\uffff"+
            "\1\2\1\1\1\uffff\1\2\16\uffff\2\2\1\uffff\1\2\16\uffff\23\2"+
            "\1\uffff\4\2\5\uffff\3\2\1\uffff\1\2\1\uffff\6\2",
            "\1\2\3\uffff\1\2\3\uffff\1\2\1\uffff\1\2\4\uffff\1\15\113"+
            "\uffff\2\2\3\uffff\1\2\7\uffff\1\16\1\3\1\4\1\5\1\6\1\7\1\10"+
            "\1\13\1\14\1\11\1\12\2\uffff\1\2\1\uffff\4\2\1\uffff\11\2\20"+
            "\uffff\1\2\2\uffff\1\2\6\uffff\1\17\2\2",
            "",
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
            "\1\21",
            "\1\22\130\uffff\1\23\12\24",
            "",
            "\1\25",
            "\1\uffff",
            "\1\26",
            "\1\uffff",
            "\1\27",
            "\1\30",
            "\1\uffff",
            "\1\31",
            "\1\uffff"
    };

    static final short[] DFA72_eot = DFA.unpackEncodedString(DFA72_eotS);
    static final short[] DFA72_eof = DFA.unpackEncodedString(DFA72_eofS);
    static final char[] DFA72_min = DFA.unpackEncodedStringToUnsignedChars(DFA72_minS);
    static final char[] DFA72_max = DFA.unpackEncodedStringToUnsignedChars(DFA72_maxS);
    static final short[] DFA72_accept = DFA.unpackEncodedString(DFA72_acceptS);
    static final short[] DFA72_special = DFA.unpackEncodedString(DFA72_specialS);
    static final short[][] DFA72_transition;

    static {
        int numStates = DFA72_transitionS.length;
        DFA72_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA72_transition[i] = DFA.unpackEncodedString(DFA72_transitionS[i]);
        }
    }

    class DFA72 extends DFA {

        public DFA72(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 72;
            this.eot = DFA72_eot;
            this.eof = DFA72_eof;
            this.min = DFA72_min;
            this.max = DFA72_max;
            this.accept = DFA72_accept;
            this.special = DFA72_special;
            this.transition = DFA72_transition;
        }
        public String getDescription() {
            return "498:29: ( ':' (n= 'new' )? t= typeName ( parameterList )? )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA72_13 = input.LA(1);

                         
                        int index72_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred106_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index72_13);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA72_20 = input.LA(1);

                         
                        int index72_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred106_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index72_20);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA72_8 = input.LA(1);

                         
                        int index72_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred106_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index72_8);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA72_5 = input.LA(1);

                         
                        int index72_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred106_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index72_5);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA72_25 = input.LA(1);

                         
                        int index72_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred106_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index72_25);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA72_18 = input.LA(1);

                         
                        int index72_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred106_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index72_18);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA72_9 = input.LA(1);

                         
                        int index72_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred106_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index72_9);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA72_11 = input.LA(1);

                         
                        int index72_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred106_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index72_11);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA72_6 = input.LA(1);

                         
                        int index72_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred106_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index72_6);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA72_3 = input.LA(1);

                         
                        int index72_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred106_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index72_3);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA72_10 = input.LA(1);

                         
                        int index72_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred106_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index72_10);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA72_12 = input.LA(1);

                         
                        int index72_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred106_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index72_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA72_7 = input.LA(1);

                         
                        int index72_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred106_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index72_7);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA72_4 = input.LA(1);

                         
                        int index72_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred106_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index72_4);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA72_23 = input.LA(1);

                         
                        int index72_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred106_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index72_23);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 72, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA76_eotS =
        "\26\uffff";
    static final String DFA76_eofS =
        "\26\uffff";
    static final String DFA76_minS =
        "\1\4\23\0\2\uffff";
    static final String DFA76_maxS =
        "\1\u00a5\23\0\2\uffff";
    static final String DFA76_acceptS =
        "\24\uffff\1\1\1\2";
    static final String DFA76_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1"+
        "\14\1\15\1\16\1\17\1\20\1\21\1\22\2\uffff}>";
    static final String[] DFA76_transitionS = {
            "\1\15\3\uffff\1\15\3\uffff\1\15\1\uffff\1\15\4\uffff\1\16\120"+
            "\uffff\1\20\7\uffff\1\17\1\3\1\4\1\5\1\6\1\7\1\10\1\13\1\14"+
            "\1\11\1\12\42\uffff\1\2\2\uffff\1\1\6\uffff\1\21\1\22\1\23",
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
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            ""
    };

    static final short[] DFA76_eot = DFA.unpackEncodedString(DFA76_eotS);
    static final short[] DFA76_eof = DFA.unpackEncodedString(DFA76_eofS);
    static final char[] DFA76_min = DFA.unpackEncodedStringToUnsignedChars(DFA76_minS);
    static final char[] DFA76_max = DFA.unpackEncodedStringToUnsignedChars(DFA76_maxS);
    static final short[] DFA76_accept = DFA.unpackEncodedString(DFA76_acceptS);
    static final short[] DFA76_special = DFA.unpackEncodedString(DFA76_specialS);
    static final short[][] DFA76_transition;

    static {
        int numStates = DFA76_transitionS.length;
        DFA76_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA76_transition[i] = DFA.unpackEncodedString(DFA76_transitionS[i]);
        }
    }

    class DFA76 extends DFA {

        public DFA76(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 76;
            this.eot = DFA76_eot;
            this.eof = DFA76_eof;
            this.min = DFA76_min;
            this.max = DFA76_max;
            this.accept = DFA76_accept;
            this.special = DFA76_special;
            this.transition = DFA76_transition;
        }
        public String getDescription() {
            return "525:1: expressionListOrRange : ( expressionRange | expressionList );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA76_1 = input.LA(1);

                         
                        int index76_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred116_EolParserRules()) ) {s = 20;}

                        else if ( (true) ) {s = 21;}

                         
                        input.seek(index76_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA76_2 = input.LA(1);

                         
                        int index76_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred116_EolParserRules()) ) {s = 20;}

                        else if ( (true) ) {s = 21;}

                         
                        input.seek(index76_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA76_3 = input.LA(1);

                         
                        int index76_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred116_EolParserRules()) ) {s = 20;}

                        else if ( (true) ) {s = 21;}

                         
                        input.seek(index76_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA76_4 = input.LA(1);

                         
                        int index76_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred116_EolParserRules()) ) {s = 20;}

                        else if ( (true) ) {s = 21;}

                         
                        input.seek(index76_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA76_5 = input.LA(1);

                         
                        int index76_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred116_EolParserRules()) ) {s = 20;}

                        else if ( (true) ) {s = 21;}

                         
                        input.seek(index76_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA76_6 = input.LA(1);

                         
                        int index76_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred116_EolParserRules()) ) {s = 20;}

                        else if ( (true) ) {s = 21;}

                         
                        input.seek(index76_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA76_7 = input.LA(1);

                         
                        int index76_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred116_EolParserRules()) ) {s = 20;}

                        else if ( (true) ) {s = 21;}

                         
                        input.seek(index76_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA76_8 = input.LA(1);

                         
                        int index76_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred116_EolParserRules()) ) {s = 20;}

                        else if ( (true) ) {s = 21;}

                         
                        input.seek(index76_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA76_9 = input.LA(1);

                         
                        int index76_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred116_EolParserRules()) ) {s = 20;}

                        else if ( (true) ) {s = 21;}

                         
                        input.seek(index76_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA76_10 = input.LA(1);

                         
                        int index76_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred116_EolParserRules()) ) {s = 20;}

                        else if ( (true) ) {s = 21;}

                         
                        input.seek(index76_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA76_11 = input.LA(1);

                         
                        int index76_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred116_EolParserRules()) ) {s = 20;}

                        else if ( (true) ) {s = 21;}

                         
                        input.seek(index76_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA76_12 = input.LA(1);

                         
                        int index76_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred116_EolParserRules()) ) {s = 20;}

                        else if ( (true) ) {s = 21;}

                         
                        input.seek(index76_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA76_13 = input.LA(1);

                         
                        int index76_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred116_EolParserRules()) ) {s = 20;}

                        else if ( (true) ) {s = 21;}

                         
                        input.seek(index76_13);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA76_14 = input.LA(1);

                         
                        int index76_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred116_EolParserRules()) ) {s = 20;}

                        else if ( (true) ) {s = 21;}

                         
                        input.seek(index76_14);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA76_15 = input.LA(1);

                         
                        int index76_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred116_EolParserRules()) ) {s = 20;}

                        else if ( (true) ) {s = 21;}

                         
                        input.seek(index76_15);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA76_16 = input.LA(1);

                         
                        int index76_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred116_EolParserRules()) ) {s = 20;}

                        else if ( (true) ) {s = 21;}

                         
                        input.seek(index76_16);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA76_17 = input.LA(1);

                         
                        int index76_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred116_EolParserRules()) ) {s = 20;}

                        else if ( (true) ) {s = 21;}

                         
                        input.seek(index76_17);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA76_18 = input.LA(1);

                         
                        int index76_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred116_EolParserRules()) ) {s = 20;}

                        else if ( (true) ) {s = 21;}

                         
                        input.seek(index76_18);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA76_19 = input.LA(1);

                         
                        int index76_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred116_EolParserRules()) ) {s = 20;}

                        else if ( (true) ) {s = 21;}

                         
                        input.seek(index76_19);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 76, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA80_eotS =
        "\27\uffff";
    static final String DFA80_eofS =
        "\27\uffff";
    static final String DFA80_minS =
        "\1\4\12\0\1\uffff\1\0\12\uffff";
    static final String DFA80_maxS =
        "\1\u00a5\12\0\1\uffff\1\0\12\uffff";
    static final String DFA80_acceptS =
        "\13\uffff\1\3\1\uffff\1\6\1\10\1\11\1\12\1\uffff\1\1\1\7\1\2\1"+
        "\4\1\5";
    static final String DFA80_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\uffff\1\12"+
        "\12\uffff}>";
    static final String[] DFA80_transitionS = {
            "\1\13\3\uffff\1\13\3\uffff\1\13\1\uffff\1\13\4\uffff\1\14\120"+
            "\uffff\1\16\7\uffff\1\15\1\1\1\2\1\3\1\4\1\5\1\6\1\11\1\12\1"+
            "\7\1\10\54\uffff\1\17\2\20",
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
            ""
    };

    static final short[] DFA80_eot = DFA.unpackEncodedString(DFA80_eotS);
    static final short[] DFA80_eof = DFA.unpackEncodedString(DFA80_eofS);
    static final char[] DFA80_min = DFA.unpackEncodedStringToUnsignedChars(DFA80_minS);
    static final char[] DFA80_max = DFA.unpackEncodedStringToUnsignedChars(DFA80_maxS);
    static final short[] DFA80_accept = DFA.unpackEncodedString(DFA80_acceptS);
    static final short[] DFA80_special = DFA.unpackEncodedString(DFA80_specialS);
    static final short[][] DFA80_transition;

    static {
        int numStates = DFA80_transitionS.length;
        DFA80_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA80_transition[i] = DFA.unpackEncodedString(DFA80_transitionS[i]);
        }
    }

    class DFA80 extends DFA {

        public DFA80(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 80;
            this.eot = DFA80_eot;
            this.eof = DFA80_eof;
            this.min = DFA80_min;
            this.max = DFA80_max;
            this.accept = DFA80_accept;
            this.special = DFA80_special;
            this.transition = DFA80_transition;
        }
        public String getDescription() {
            return "551:1: primitiveExpression : ( literalSequentialCollection | literalMapCollection | literal | featureCall | pathName | nativeType | collectionType | logicalExpressionInBrackets | newExpression | variableDeclarationExpression );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA80_1 = input.LA(1);

                         
                        int index80_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred120_EolParserRules()) ) {s = 18;}

                        else if ( (synpred126_EolParserRules()) ) {s = 19;}

                         
                        input.seek(index80_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA80_2 = input.LA(1);

                         
                        int index80_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred120_EolParserRules()) ) {s = 18;}

                        else if ( (synpred126_EolParserRules()) ) {s = 19;}

                         
                        input.seek(index80_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA80_3 = input.LA(1);

                         
                        int index80_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred120_EolParserRules()) ) {s = 18;}

                        else if ( (synpred126_EolParserRules()) ) {s = 19;}

                         
                        input.seek(index80_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA80_4 = input.LA(1);

                         
                        int index80_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred120_EolParserRules()) ) {s = 18;}

                        else if ( (synpred126_EolParserRules()) ) {s = 19;}

                         
                        input.seek(index80_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA80_5 = input.LA(1);

                         
                        int index80_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred120_EolParserRules()) ) {s = 18;}

                        else if ( (synpred126_EolParserRules()) ) {s = 19;}

                         
                        input.seek(index80_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA80_6 = input.LA(1);

                         
                        int index80_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred120_EolParserRules()) ) {s = 18;}

                        else if ( (synpred126_EolParserRules()) ) {s = 19;}

                         
                        input.seek(index80_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA80_7 = input.LA(1);

                         
                        int index80_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred120_EolParserRules()) ) {s = 18;}

                        else if ( (synpred126_EolParserRules()) ) {s = 19;}

                         
                        input.seek(index80_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA80_8 = input.LA(1);

                         
                        int index80_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred120_EolParserRules()) ) {s = 18;}

                        else if ( (synpred126_EolParserRules()) ) {s = 19;}

                         
                        input.seek(index80_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA80_9 = input.LA(1);

                         
                        int index80_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred121_EolParserRules()) ) {s = 20;}

                        else if ( (synpred126_EolParserRules()) ) {s = 19;}

                         
                        input.seek(index80_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA80_10 = input.LA(1);

                         
                        int index80_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred121_EolParserRules()) ) {s = 20;}

                        else if ( (synpred126_EolParserRules()) ) {s = 19;}

                         
                        input.seek(index80_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA80_12 = input.LA(1);

                         
                        int index80_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred123_EolParserRules()) ) {s = 21;}

                        else if ( (synpred124_EolParserRules()) ) {s = 22;}

                         
                        input.seek(index80_12);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 80, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_operationDeclaration_in_operationDeclarationOrAnnotationBlock263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationBlock_in_operationDeclarationOrAnnotationBlock267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_90_in_modelDeclaration286 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_modelDeclaration289 = new BitSet(new long[]{0x0000000000000000L,0x00000000D8000000L});
    public static final BitSet FOLLOW_modelAlias_in_modelDeclaration291 = new BitSet(new long[]{0x0000000000000000L,0x00000000C8000000L});
    public static final BitSet FOLLOW_modelDriver_in_modelDeclaration294 = new BitSet(new long[]{0x0000000000000000L,0x0000000088000000L});
    public static final BitSet FOLLOW_modelDeclarationParameters_in_modelDeclaration297 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_91_in_modelDeclaration302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_92_in_modelAlias317 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_modelAlias320 = new BitSet(new long[]{0x0000000000000002L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_modelAlias323 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_modelAlias326 = new BitSet(new long[]{0x0000000000000002L,0x0000000020000000L});
    public static final BitSet FOLLOW_94_in_modelDriver345 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_modelDriver348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_95_in_modelDeclarationParameters370 = new BitSet(new long[]{0x0000000000080000L,0x0000000120000000L});
    public static final BitSet FOLLOW_modelDeclarationParameter_in_modelDeclarationParameters373 = new BitSet(new long[]{0x0000000000000000L,0x0000000120000000L});
    public static final BitSet FOLLOW_93_in_modelDeclarationParameters377 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_modelDeclarationParameter_in_modelDeclarationParameters380 = new BitSet(new long[]{0x0000000000000000L,0x0000000120000000L});
    public static final BitSet FOLLOW_96_in_modelDeclarationParameters386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_modelDeclarationParameter399 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_97_in_modelDeclarationParameter403 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_STRING_in_modelDeclarationParameter406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_operationDeclaration427 = new BitSet(new long[]{0x0000000000080000L,0x007FF00000000000L});
    public static final BitSet FOLLOW_typeName_in_operationDeclaration437 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_operationDeclaration447 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_100_in_operationDeclaration451 = new BitSet(new long[]{0x0000000000080000L,0x0000002000000000L});
    public static final BitSet FOLLOW_formalParameterList_in_operationDeclaration454 = new BitSet(new long[]{0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_101_in_operationDeclaration459 = new BitSet(new long[]{0x0000000000000000L,0x0000004080000000L});
    public static final BitSet FOLLOW_102_in_operationDeclaration465 = new BitSet(new long[]{0x0000000000080000L,0x007FF00000000000L});
    public static final BitSet FOLLOW_typeName_in_operationDeclaration470 = new BitSet(new long[]{0x0000000000000000L,0x0000004080000000L});
    public static final BitSet FOLLOW_statementBlock_in_operationDeclaration476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_103_in_importStatement496 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_STRING_in_importStatement499 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_91_in_importStatement503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_block524 = new BitSet(new long[]{0x0000000000085112L,0x4A7FF01000000000L,0x00000038120001FFL});
    public static final BitSet FOLLOW_95_in_statementBlock554 = new BitSet(new long[]{0x0000000000085110L,0x4A7FF01000000000L,0x00000038120001FFL});
    public static final BitSet FOLLOW_block_in_statementBlock557 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_96_in_statementBlock561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_formalParameter579 = new BitSet(new long[]{0x0000000000000002L,0x0000004000000000L});
    public static final BitSet FOLLOW_102_in_formalParameter582 = new BitSet(new long[]{0x0000000000080000L,0x007FF00000000000L});
    public static final BitSet FOLLOW_typeName_in_formalParameter586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_formalParameter_in_formalParameterList620 = new BitSet(new long[]{0x0000000000000002L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_formalParameterList623 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_formalParameter_in_formalParameterList625 = new BitSet(new long[]{0x0000000000000002L,0x0000000020000000L});
    public static final BitSet FOLLOW_104_in_executableAnnotation650 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0xFFFFFFFFFFFFFFFFL,0x0003FFFFFFFFFFFFL});
    public static final BitSet FOLLOW_logicalExpression_in_executableAnnotation657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Annotation_in_annotation671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_executableAnnotation_in_annotation675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotation_in_annotationBlock692 = new BitSet(new long[]{0x0000000000800002L,0x0000010000000000L});
    public static final BitSet FOLLOW_pathName_in_typeName721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nativeType_in_typeName725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectionType_in_typeName729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_pathName743 = new BitSet(new long[]{0x0000000000000000L,0x0000020000000000L});
    public static final BitSet FOLLOW_105_in_pathName745 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_packagedType_in_pathName754 = new BitSet(new long[]{0x0000000000000002L,0x0000040000000000L});
    public static final BitSet FOLLOW_106_in_pathName760 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_pathName765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_packagedType786 = new BitSet(new long[]{0x0000000000000002L,0x0000080000000000L});
    public static final BitSet FOLLOW_107_in_packagedType789 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_packagedType794 = new BitSet(new long[]{0x0000000000000002L,0x0000080000000000L});
    public static final BitSet FOLLOW_108_in_nativeType823 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_100_in_nativeType828 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_STRING_in_nativeType831 = new BitSet(new long[]{0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_101_in_nativeType835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_collectionType854 = new BitSet(new long[]{0x0000000000000002L,0x0080001000000000L});
    public static final BitSet FOLLOW_100_in_collectionType883 = new BitSet(new long[]{0x0000000000080000L,0x007FF00000000000L});
    public static final BitSet FOLLOW_typeName_in_collectionType888 = new BitSet(new long[]{0x0000000000000000L,0x0000002020000000L});
    public static final BitSet FOLLOW_93_in_collectionType893 = new BitSet(new long[]{0x0000000000080000L,0x007FF00000000000L});
    public static final BitSet FOLLOW_typeName_in_collectionType897 = new BitSet(new long[]{0x0000000000000000L,0x0000002020000000L});
    public static final BitSet FOLLOW_101_in_collectionType905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_119_in_collectionType917 = new BitSet(new long[]{0x0000000000080000L,0x007FF00000000000L});
    public static final BitSet FOLLOW_typeName_in_collectionType922 = new BitSet(new long[]{0x0000000000000000L,0x0100000020000000L});
    public static final BitSet FOLLOW_93_in_collectionType927 = new BitSet(new long[]{0x0000000000080000L,0x007FF00000000000L});
    public static final BitSet FOLLOW_typeName_in_collectionType931 = new BitSet(new long[]{0x0000000000000000L,0x0100000020000000L});
    public static final BitSet FOLLOW_120_in_collectionType939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementA_in_statement958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementB_in_statement962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignmentStatement_in_statementA973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionStatement_in_statementA977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_forStatement_in_statementA981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStatement_in_statementA987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_whileStatement_in_statementA991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_switchStatement_in_statementA995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_returnStatement_in_statementA999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_breakStatement_in_statementA1003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_breakAllStatement_in_statementB1015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_returnStatement_in_statementB1019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_transactionStatement_in_statementB1023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_abortStatement_in_statementB1029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_continueStatement_in_statementB1033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_throwStatement_in_statementB1037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_deleteStatement_in_statementB1043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_statementOrStatementBlock1054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementBlock_in_statementOrStatementBlock1058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_102_in_expressionOrStatementBlock1067 = new BitSet(new long[]{0x0000000000085110L,0x007FF01000000000L,0x0000003812000000L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionOrStatementBlock1070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementBlock_in_expressionOrStatementBlock1074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_121_in_ifStatement1087 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_100_in_ifStatement1090 = new BitSet(new long[]{0x0000000000085110L,0x007FF01000000000L,0x0000003812000000L});
    public static final BitSet FOLLOW_logicalExpression_in_ifStatement1093 = new BitSet(new long[]{0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_101_in_ifStatement1095 = new BitSet(new long[]{0x0000000000085110L,0x4A7FF05080000000L,0x00000038120001FFL});
    public static final BitSet FOLLOW_statementOrStatementBlock_in_ifStatement1098 = new BitSet(new long[]{0x0000000000000002L,0x0400000000000000L});
    public static final BitSet FOLLOW_elseStatement_in_ifStatement1100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_122_in_elseStatement1123 = new BitSet(new long[]{0x0000000000085110L,0x4A7FF05080000000L,0x00000038120001FFL});
    public static final BitSet FOLLOW_statementOrStatementBlock_in_elseStatement1126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_123_in_switchStatement1140 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_100_in_switchStatement1143 = new BitSet(new long[]{0x0000000000085110L,0x007FF01000000000L,0x0000003812000000L});
    public static final BitSet FOLLOW_logicalExpression_in_switchStatement1146 = new BitSet(new long[]{0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_101_in_switchStatement1148 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_switchStatement1151 = new BitSet(new long[]{0x0000000000000000L,0x3000000100000000L});
    public static final BitSet FOLLOW_caseStatement_in_switchStatement1154 = new BitSet(new long[]{0x0000000000000000L,0x3000000100000000L});
    public static final BitSet FOLLOW_defaultStatement_in_switchStatement1157 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_96_in_switchStatement1160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_124_in_caseStatement1179 = new BitSet(new long[]{0x0000000000085110L,0x007FF01000000000L,0x0000003812000000L});
    public static final BitSet FOLLOW_logicalExpression_in_caseStatement1182 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_102_in_caseStatement1184 = new BitSet(new long[]{0x0000000000085110L,0x4A7FF05080000000L,0x00000038120001FFL});
    public static final BitSet FOLLOW_block_in_caseStatement1188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementBlock_in_caseStatement1192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_125_in_defaultStatement1211 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_102_in_defaultStatement1214 = new BitSet(new long[]{0x0000000000085110L,0x4A7FF05080000000L,0x00000038120001FFL});
    public static final BitSet FOLLOW_block_in_defaultStatement1218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementBlock_in_defaultStatement1222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_126_in_forStatement1240 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_100_in_forStatement1243 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_formalParameter_in_forStatement1246 = new BitSet(new long[]{0x0000000000000000L,0x8000000000000000L});
    public static final BitSet FOLLOW_127_in_forStatement1248 = new BitSet(new long[]{0x0000000000085110L,0x007FF01000000000L,0x0000003812000000L});
    public static final BitSet FOLLOW_logicalExpression_in_forStatement1251 = new BitSet(new long[]{0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_101_in_forStatement1253 = new BitSet(new long[]{0x0000000000085110L,0x4A7FF05080000000L,0x00000038120001FFL});
    public static final BitSet FOLLOW_statementOrStatementBlock_in_forStatement1256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_128_in_whileStatement1272 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_100_in_whileStatement1275 = new BitSet(new long[]{0x0000000000085110L,0x007FF01000000000L,0x0000003812000000L});
    public static final BitSet FOLLOW_logicalExpression_in_whileStatement1278 = new BitSet(new long[]{0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_101_in_whileStatement1280 = new BitSet(new long[]{0x0000000000085110L,0x4A7FF05080000000L,0x00000038120001FFL});
    public static final BitSet FOLLOW_statementOrStatementBlock_in_whileStatement1283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_129_in_returnStatement1305 = new BitSet(new long[]{0x0000000000085110L,0x007FF01008000000L,0x0000003812000000L});
    public static final BitSet FOLLOW_logicalExpression_in_returnStatement1308 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_91_in_returnStatement1313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_130_in_throwStatement1336 = new BitSet(new long[]{0x0000000000085110L,0x007FF01008000000L,0x0000003812000000L});
    public static final BitSet FOLLOW_logicalExpression_in_throwStatement1339 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_91_in_throwStatement1344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_131_in_deleteStatement1367 = new BitSet(new long[]{0x0000000000085110L,0x007FF01008000000L,0x0000003812000000L});
    public static final BitSet FOLLOW_logicalExpression_in_deleteStatement1370 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_91_in_deleteStatement1375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_132_in_breakStatement1401 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_91_in_breakStatement1406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_133_in_breakAllStatement1429 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_91_in_breakAllStatement1434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_134_in_continueStatement1457 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_91_in_continueStatement1462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_135_in_abortStatement1485 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_91_in_abortStatement1490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_136_in_transactionStatement1507 = new BitSet(new long[]{0x0000000000085110L,0x4A7FF05080000000L,0x00000038120001FFL});
    public static final BitSet FOLLOW_NAME_in_transactionStatement1511 = new BitSet(new long[]{0x0000000000085110L,0x4A7FF050A0000000L,0x00000038120001FFL});
    public static final BitSet FOLLOW_93_in_transactionStatement1514 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_transactionStatement1516 = new BitSet(new long[]{0x0000000000085110L,0x4A7FF050A0000000L,0x00000038120001FFL});
    public static final BitSet FOLLOW_statementOrStatementBlock_in_transactionStatement1522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logicalExpression_in_assignmentStatement1542 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000007E00L});
    public static final BitSet FOLLOW_137_in_assignmentStatement1548 = new BitSet(new long[]{0x0000000000085110L,0x007FF01000000000L,0x0000003812000000L});
    public static final BitSet FOLLOW_138_in_assignmentStatement1553 = new BitSet(new long[]{0x0000000000085110L,0x007FF01000000000L,0x0000003812000000L});
    public static final BitSet FOLLOW_139_in_assignmentStatement1558 = new BitSet(new long[]{0x0000000000085110L,0x007FF01000000000L,0x0000003812000000L});
    public static final BitSet FOLLOW_140_in_assignmentStatement1563 = new BitSet(new long[]{0x0000000000085110L,0x007FF01000000000L,0x0000003812000000L});
    public static final BitSet FOLLOW_141_in_assignmentStatement1568 = new BitSet(new long[]{0x0000000000085110L,0x007FF01000000000L,0x0000003812000000L});
    public static final BitSet FOLLOW_142_in_assignmentStatement1580 = new BitSet(new long[]{0x0000000000085110L,0x007FF01000000000L,0x0000003812000000L});
    public static final BitSet FOLLOW_logicalExpression_in_assignmentStatement1588 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_91_in_assignmentStatement1592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_postfixExpression_in_expressionStatement1612 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_97_in_expressionStatement1616 = new BitSet(new long[]{0x0000000000085110L,0x007FF01000000000L,0x0000003812000000L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionStatement1619 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionStatement1626 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_91_in_expressionStatement1631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_relationalExpression_in_logicalExpression1643 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x00000000000F8000L});
    public static final BitSet FOLLOW_143_in_logicalExpression1654 = new BitSet(new long[]{0x0000000000085110L,0x007FF01000000000L,0x0000003812000000L});
    public static final BitSet FOLLOW_144_in_logicalExpression1659 = new BitSet(new long[]{0x0000000000085110L,0x007FF01000000000L,0x0000003812000000L});
    public static final BitSet FOLLOW_145_in_logicalExpression1664 = new BitSet(new long[]{0x0000000000085110L,0x007FF01000000000L,0x0000003812000000L});
    public static final BitSet FOLLOW_146_in_logicalExpression1669 = new BitSet(new long[]{0x0000000000085110L,0x007FF01000000000L,0x0000003812000000L});
    public static final BitSet FOLLOW_147_in_logicalExpression1683 = new BitSet(new long[]{0x0000000000085110L,0x007FF01000000000L,0x0000003812000000L});
    public static final BitSet FOLLOW_relationalExpression_in_logicalExpression1686 = new BitSet(new long[]{0x0000000000000000L,0x0400004000000000L});
    public static final BitSet FOLLOW_set_in_logicalExpression1688 = new BitSet(new long[]{0x0000000000085110L,0x007FF01000000000L,0x0000003812000000L});
    public static final BitSet FOLLOW_relationalExpression_in_logicalExpression1704 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x00000000000F8000L});
    public static final BitSet FOLLOW_additiveExpression_in_relationalExpression1720 = new BitSet(new long[]{0x0000000000000002L,0x0180000200000000L,0x0000000000F00000L});
    public static final BitSet FOLLOW_148_in_relationalExpression1726 = new BitSet(new long[]{0x0000000000085110L,0x007FF01000000000L,0x0000003812000000L});
    public static final BitSet FOLLOW_relationalExpression_in_relationalExpression1729 = new BitSet(new long[]{0x0000000000000002L,0x0180000200000000L,0x0000000000F00000L});
    public static final BitSet FOLLOW_97_in_relationalExpression1735 = new BitSet(new long[]{0x0000000000085110L,0x007FF01000000000L,0x0000003812000000L});
    public static final BitSet FOLLOW_relationalExpression_in_relationalExpression1738 = new BitSet(new long[]{0x0000000000000002L,0x0180000200000000L,0x0000000000F00000L});
    public static final BitSet FOLLOW_120_in_relationalExpression1768 = new BitSet(new long[]{0x0000000000085110L,0x007FF01000000000L,0x0000003812000000L});
    public static final BitSet FOLLOW_119_in_relationalExpression1773 = new BitSet(new long[]{0x0000000000085110L,0x007FF01000000000L,0x0000003812000000L});
    public static final BitSet FOLLOW_149_in_relationalExpression1778 = new BitSet(new long[]{0x0000000000085110L,0x007FF01000000000L,0x0000003812000000L});
    public static final BitSet FOLLOW_150_in_relationalExpression1783 = new BitSet(new long[]{0x0000000000085110L,0x007FF01000000000L,0x0000003812000000L});
    public static final BitSet FOLLOW_151_in_relationalExpression1788 = new BitSet(new long[]{0x0000000000085110L,0x007FF01000000000L,0x0000003812000000L});
    public static final BitSet FOLLOW_additiveExpression_in_relationalExpression1792 = new BitSet(new long[]{0x0000000000000002L,0x0180000200000000L,0x0000000000F00000L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_additiveExpression1810 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000003000000L});
    public static final BitSet FOLLOW_152_in_additiveExpression1816 = new BitSet(new long[]{0x0000000000085110L,0x007FF01000000000L,0x0000003812000000L});
    public static final BitSet FOLLOW_153_in_additiveExpression1821 = new BitSet(new long[]{0x0000000000085110L,0x007FF01000000000L,0x0000003812000000L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_additiveExpression1825 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000003000000L});
    public static final BitSet FOLLOW_unaryExpression_in_multiplicativeExpression1843 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x000000000C000000L});
    public static final BitSet FOLLOW_154_in_multiplicativeExpression1849 = new BitSet(new long[]{0x0000000000085110L,0x007FF01000000000L,0x0000003812000000L});
    public static final BitSet FOLLOW_155_in_multiplicativeExpression1854 = new BitSet(new long[]{0x0000000000085110L,0x007FF01000000000L,0x0000003812000000L});
    public static final BitSet FOLLOW_unaryExpression_in_multiplicativeExpression1858 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x000000000C000000L});
    public static final BitSet FOLLOW_156_in_unaryExpression1879 = new BitSet(new long[]{0x0000000000085110L,0x007FF01000000000L,0x0000003812000000L});
    public static final BitSet FOLLOW_153_in_unaryExpression1884 = new BitSet(new long[]{0x0000000000085110L,0x007FF01000000000L,0x0000003812000000L});
    public static final BitSet FOLLOW_shortcutOperatorExpression_in_unaryExpression1892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_postfixExpression_in_shortcutOperatorExpression1904 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000060000000L});
    public static final BitSet FOLLOW_157_in_shortcutOperatorExpression1910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_158_in_shortcutOperatorExpression1917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_itemSelectorExpression_in_postfixExpression1935 = new BitSet(new long[]{0x0000000000000A02L});
    public static final BitSet FOLLOW_set_in_postfixExpression1938 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_featureCall_in_postfixExpression1947 = new BitSet(new long[]{0x0000000000000A02L,0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_159_in_postfixExpression1956 = new BitSet(new long[]{0x0000000000085110L,0x007FF01000000000L,0x0000003812000000L});
    public static final BitSet FOLLOW_logicalExpression_in_postfixExpression1959 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_160_in_postfixExpression1961 = new BitSet(new long[]{0x0000000000000A02L,0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_primitiveExpression_in_itemSelectorExpression1983 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_159_in_itemSelectorExpression1988 = new BitSet(new long[]{0x0000000000085110L,0x007FF01000000000L,0x0000003812000000L});
    public static final BitSet FOLLOW_primitiveExpression_in_itemSelectorExpression1991 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_160_in_itemSelectorExpression1993 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_simpleFeatureCall_in_featureCall2011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_complexFeatureCall_in_featureCall2015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_simpleFeatureCall2029 = new BitSet(new long[]{0x0000000000000002L,0x0000001000000000L});
    public static final BitSet FOLLOW_parameterList_in_simpleFeatureCall2032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_100_in_parameterList2055 = new BitSet(new long[]{0x0000000000085110L,0x007FF03000000000L,0x0000003812000000L});
    public static final BitSet FOLLOW_logicalExpression_in_parameterList2058 = new BitSet(new long[]{0x0000000000000000L,0x0000002020000000L});
    public static final BitSet FOLLOW_93_in_parameterList2061 = new BitSet(new long[]{0x0000000000085110L,0x007FF01000000000L,0x0000003812000000L});
    public static final BitSet FOLLOW_logicalExpression_in_parameterList2063 = new BitSet(new long[]{0x0000000000000000L,0x0000002020000000L});
    public static final BitSet FOLLOW_101_in_parameterList2071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_complexFeatureCall2099 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_100_in_complexFeatureCall2104 = new BitSet(new long[]{0x0000000000080000L,0x0000001000000000L,0x0000000680000000L});
    public static final BitSet FOLLOW_lambdaExpression_in_complexFeatureCall2108 = new BitSet(new long[]{0x0000000000000000L,0x0000002020000000L});
    public static final BitSet FOLLOW_lambdaExpressionInBrackets_in_complexFeatureCall2112 = new BitSet(new long[]{0x0000000000000000L,0x0000002020000000L});
    public static final BitSet FOLLOW_93_in_complexFeatureCall2118 = new BitSet(new long[]{0x0000000000085110L,0x007FF01000000000L,0x0000003E92000000L});
    public static final BitSet FOLLOW_logicalExpression_in_complexFeatureCall2122 = new BitSet(new long[]{0x0000000000000000L,0x0000002020000000L});
    public static final BitSet FOLLOW_lambdaExpressionInBrackets_in_complexFeatureCall2126 = new BitSet(new long[]{0x0000000000000000L,0x0000002020000000L});
    public static final BitSet FOLLOW_101_in_complexFeatureCall2133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_100_in_lambdaExpressionInBrackets2154 = new BitSet(new long[]{0x0000000000080000L,0x0000000000000000L,0x0000000600000000L});
    public static final BitSet FOLLOW_lambdaExpression_in_lambdaExpressionInBrackets2157 = new BitSet(new long[]{0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_101_in_lambdaExpressionInBrackets2161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_159_in_lambdaExpressionInBrackets2172 = new BitSet(new long[]{0x0000000000080000L,0x0000000000000000L,0x0000000600000000L});
    public static final BitSet FOLLOW_lambdaExpression_in_lambdaExpressionInBrackets2175 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_160_in_lambdaExpressionInBrackets2179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_formalParameterList_in_lambdaExpression2198 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000600000000L});
    public static final BitSet FOLLOW_161_in_lambdaExpression2204 = new BitSet(new long[]{0x0000000000085110L,0x007FF01000000000L,0x0000003812000000L});
    public static final BitSet FOLLOW_162_in_lambdaExpression2211 = new BitSet(new long[]{0x0000000000085110L,0x007FF01000000000L,0x0000003812000000L});
    public static final BitSet FOLLOW_logicalExpression_in_lambdaExpression2215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_newExpression2228 = new BitSet(new long[]{0x0000000000080000L,0x007FF00000000000L});
    public static final BitSet FOLLOW_typeName_in_newExpression2233 = new BitSet(new long[]{0x0000000000000002L,0x0000001000000000L});
    public static final BitSet FOLLOW_parameterList_in_newExpression2237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_164_in_variableDeclarationExpression2261 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_165_in_variableDeclarationExpression2266 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_variableDeclarationExpression2270 = new BitSet(new long[]{0x0000000000000002L,0x0000004000000000L});
    public static final BitSet FOLLOW_102_in_variableDeclarationExpression2273 = new BitSet(new long[]{0x0000000000080000L,0x007FF00000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_163_in_variableDeclarationExpression2278 = new BitSet(new long[]{0x0000000000080000L,0x007FF00000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_typeName_in_variableDeclarationExpression2284 = new BitSet(new long[]{0x0000000000000002L,0x0000001000000000L});
    public static final BitSet FOLLOW_parameterList_in_variableDeclarationExpression2288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_109_in_literalSequentialCollection2312 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_110_in_literalSequentialCollection2317 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_111_in_literalSequentialCollection2322 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_112_in_literalSequentialCollection2327 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_113_in_literalSequentialCollection2335 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_114_in_literalSequentialCollection2340 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_117_in_literalSequentialCollection2345 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_118_in_literalSequentialCollection2350 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_literalSequentialCollection2358 = new BitSet(new long[]{0x0000000000085110L,0x007FF01100000000L,0x0000003812000000L});
    public static final BitSet FOLLOW_expressionListOrRange_in_literalSequentialCollection2361 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_96_in_literalSequentialCollection2366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionRange2381 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_POINT_POINT_in_expressionRange2385 = new BitSet(new long[]{0x0000000000085110L,0x007FF01000000000L,0x0000003812000000L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionRange2388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionList2409 = new BitSet(new long[]{0x0000000000000002L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_expressionList2412 = new BitSet(new long[]{0x0000000000085110L,0x007FF01000000000L,0x0000003812000000L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionList2414 = new BitSet(new long[]{0x0000000000000002L,0x0000000020000000L});
    public static final BitSet FOLLOW_expressionRange_in_expressionListOrRange2438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionList_in_expressionListOrRange2442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_115_in_literalMapCollection2462 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_116_in_literalMapCollection2467 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_literalMapCollection2473 = new BitSet(new long[]{0x0000000000085110L,0x007FF01100000000L,0x0000003812000000L});
    public static final BitSet FOLLOW_keyvalExpressionList_in_literalMapCollection2476 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_96_in_literalMapCollection2481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_keyvalExpression_in_keyvalExpressionList2502 = new BitSet(new long[]{0x0000000000000002L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_keyvalExpressionList2505 = new BitSet(new long[]{0x0000000000085110L,0x007FF01000000000L,0x0000003812000000L});
    public static final BitSet FOLLOW_keyvalExpression_in_keyvalExpressionList2507 = new BitSet(new long[]{0x0000000000000002L,0x0000000020000000L});
    public static final BitSet FOLLOW_additiveExpression_in_keyvalExpression2532 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_97_in_keyvalExpression2536 = new BitSet(new long[]{0x0000000000085110L,0x007FF01000000000L,0x0000003812000000L});
    public static final BitSet FOLLOW_logicalExpression_in_keyvalExpression2539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literalSequentialCollection_in_primitiveExpression2553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literalMapCollection_in_primitiveExpression2557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_primitiveExpression2561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_featureCall_in_primitiveExpression2565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pathName_in_primitiveExpression2569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nativeType_in_primitiveExpression2573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectionType_in_primitiveExpression2579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logicalExpressionInBrackets_in_primitiveExpression2583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_newExpression_in_primitiveExpression2589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variableDeclarationExpression_in_primitiveExpression2593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_100_in_logicalExpressionInBrackets2612 = new BitSet(new long[]{0x0000000000085110L,0x007FF01000000000L,0x0000003812000000L});
    public static final BitSet FOLLOW_logicalExpression_in_logicalExpressionInBrackets2615 = new BitSet(new long[]{0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_101_in_logicalExpressionInBrackets2619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_literal0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotation_in_synpred16_EolParserRules692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_100_in_synpred32_EolParserRules883 = new BitSet(new long[]{0x0000000000080000L,0x007FF00000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_typeName_in_synpred32_EolParserRules888 = new BitSet(new long[]{0x0000000000000000L,0x0000002020000000L});
    public static final BitSet FOLLOW_93_in_synpred32_EolParserRules893 = new BitSet(new long[]{0x0000000000080000L,0x007FF00000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_typeName_in_synpred32_EolParserRules897 = new BitSet(new long[]{0x0000000000000000L,0x0000002020000000L});
    public static final BitSet FOLLOW_101_in_synpred32_EolParserRules905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_119_in_synpred34_EolParserRules917 = new BitSet(new long[]{0x0000000000080000L,0x007FF00000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_typeName_in_synpred34_EolParserRules922 = new BitSet(new long[]{0x0000000000000000L,0x0100000020000000L});
    public static final BitSet FOLLOW_93_in_synpred34_EolParserRules927 = new BitSet(new long[]{0x0000000000080000L,0x007FF00000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_typeName_in_synpred34_EolParserRules931 = new BitSet(new long[]{0x0000000000000000L,0x0100000020000000L});
    public static final BitSet FOLLOW_120_in_synpred34_EolParserRules939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementA_in_synpred35_EolParserRules958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignmentStatement_in_synpred36_EolParserRules973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionStatement_in_synpred37_EolParserRules977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_elseStatement_in_synpred51_EolParserRules1100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_synpred60_EolParserRules1511 = new BitSet(new long[]{0x0000000000000002L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_synpred60_EolParserRules1514 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_synpred60_EolParserRules1516 = new BitSet(new long[]{0x0000000000000002L,0x0000000020000000L});
    public static final BitSet FOLLOW_postfixExpression_in_synpred66_EolParserRules1612 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_97_in_synpred66_EolParserRules1616 = new BitSet(new long[]{0x0000000000085110L,0x007FF01000000000L,0x0000003812000000L});
    public static final BitSet FOLLOW_logicalExpression_in_synpred66_EolParserRules1619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_148_in_synpred79_EolParserRules1726 = new BitSet(new long[]{0x0000000000085110L,0x007FF01000000000L,0x0000003812000000L});
    public static final BitSet FOLLOW_relationalExpression_in_synpred79_EolParserRules1729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_97_in_synpred79_EolParserRules1735 = new BitSet(new long[]{0x0000000000085110L,0x007FF01000000000L,0x0000003812000000L});
    public static final BitSet FOLLOW_relationalExpression_in_synpred79_EolParserRules1738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred79_EolParserRules1765 = new BitSet(new long[]{0x0000000000085110L,0x007FF01000000000L,0x0000003812000000L});
    public static final BitSet FOLLOW_additiveExpression_in_synpred79_EolParserRules1792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_102_in_synpred106_EolParserRules2273 = new BitSet(new long[]{0x0000000000080000L,0x007FF00000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_163_in_synpred106_EolParserRules2278 = new BitSet(new long[]{0x0000000000080000L,0x007FF00000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_typeName_in_synpred106_EolParserRules2284 = new BitSet(new long[]{0x0000000000000002L,0x0000001000000000L});
    public static final BitSet FOLLOW_parameterList_in_synpred106_EolParserRules2288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionRange_in_synpred116_EolParserRules2438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literalSequentialCollection_in_synpred120_EolParserRules2553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literalMapCollection_in_synpred121_EolParserRules2557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_featureCall_in_synpred123_EolParserRules2565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pathName_in_synpred124_EolParserRules2569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectionType_in_synpred126_EolParserRules2579 = new BitSet(new long[]{0x0000000000000002L});

}
