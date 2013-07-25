package org.eclipse.epsilon.egl.parse;

// $ANTLR 3.1b1 EolParserRules.g 2013-07-25 12:18:28

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
    public static final int OVERWRITE=83;
    public static final int T__159=159;
    public static final int WHILE=33;
    public static final int StatementBlock=29;
    public static final int T__158=158;
    public static final int StrangeNameLiteral=15;
    public static final int CASE=35;
    public static final int NEW=49;
    public static final int T__160=160;
    public static final int FeatureCall=59;
    public static final int EOF=-1;
    public static final int BREAK=38;
    public static final int KEYVALLIST=75;
    public static final int TYPE=63;
    public static final int T__93=93;
    public static final int T__94=94;
    public static final int T__91=91;
    public static final int IMPORT=65;
    public static final int NAME=19;
    public static final int T__92=92;
    public static final int T__148=148;
    public static final int T__90=90;
    public static final int T__147=147;
    public static final int T__149=149;
    public static final int RETURN=37;
    public static final int NewExpression=47;
    public static final int VAR=48;
    public static final int GENERATE=80;
    public static final int ANNOTATIONBLOCK=50;
    public static final int NativeType=56;
    public static final int ABORT=43;
    public static final int COMMENT=21;
    public static final int T__154=154;
    public static final int T__155=155;
    public static final int T__156=156;
    public static final int T__99=99;
    public static final int T__157=157;
    public static final int ITEMSELECTOR=72;
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
    public static final int DRIVER=69;
    public static final int ELSE=32;
    public static final int EOLMODULE=60;
    public static final int MODELDECLARATION=66;
    public static final int PARAMLIST=25;
    public static final int INT=8;
    public static final int DELETE=52;
    public static final int T__141=141;
    public static final int T__142=142;
    public static final int EGXMODULE=85;
    public static final int T__87=87;
    public static final int HELPERMETHOD=28;
    public static final int T__86=86;
    public static final int T__140=140;
    public static final int T__89=89;
    public static final int T__145=145;
    public static final int NAMESPACE=67;
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
    public static final int ALIAS=68;
    public static final int JavaIDDigit=18;
    public static final int PROTECTREGIONS=84;
    public static final int GUARD=79;
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
    public static final int MODELDECLARATIONPARAMETER=71;
    public static final int KEYVAL=74;
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
    public static final int ENUMERATION_VALUE=64;
    public static final int T__121=121;
    public static final int PRE=76;
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
    public static final int TARGET=81;
    public static final int T__100=100;
    public static final int POINT_POINT=10;
    public static final int TEMPLATE=82;
    public static final int SpecialNameChar=17;
    public static final int MODELDECLARATIONPARAMETERS=70;
    public static final int BLOCK=61;
    public static final int MAP=73;
    public static final int FEATURECALL=62;
    public static final int FORMAL=24;
    public static final int POST=77;
    public static final int ARROW=11;
    public static final int ASSIGNMENT=26;
    public static final int EXTENDS=78;
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
    // EolParserRules.g:104:1: operationDeclarationOrAnnotationBlock : ( operationDeclaration | annotationBlock );
    public final Egx_EolParserRules.operationDeclarationOrAnnotationBlock_return operationDeclarationOrAnnotationBlock() throws RecognitionException {
        Egx_EolParserRules.operationDeclarationOrAnnotationBlock_return retval = new Egx_EolParserRules.operationDeclarationOrAnnotationBlock_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Egx_EolParserRules.operationDeclaration_return operationDeclaration1 = null;

        Egx_EolParserRules.annotationBlock_return annotationBlock2 = null;



        try {
            // EolParserRules.g:105:2: ( operationDeclaration | annotationBlock )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( ((LA1_0>=94 && LA1_0<=95)) ) {
                alt1=1;
            }
            else if ( (LA1_0==Annotation||LA1_0==100) ) {
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
                    // EolParserRules.g:105:4: operationDeclaration
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_operationDeclaration_in_operationDeclarationOrAnnotationBlock246);
                    operationDeclaration1=operationDeclaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, operationDeclaration1.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:105:25: annotationBlock
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_annotationBlock_in_operationDeclarationOrAnnotationBlock248);
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
    // EolParserRules.g:108:1: modelDeclaration : m= 'model' NAME ( modelAlias )? ( modelDriver )? ( modelDeclarationParameters )? sem= ';' ;
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
            // EolParserRules.g:113:2: (m= 'model' NAME ( modelAlias )? ( modelDriver )? ( modelDeclarationParameters )? sem= ';' )
            // EolParserRules.g:113:4: m= 'model' NAME ( modelAlias )? ( modelDriver )? ( modelDeclarationParameters )? sem= ';'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            m=(Token)match(input,86,FOLLOW_86_in_modelDeclaration267); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            m_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(m);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(m_tree, root_0);
            }
            NAME3=(Token)match(input,NAME,FOLLOW_NAME_in_modelDeclaration270); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME3_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(NAME3);
            adaptor.addChild(root_0, NAME3_tree);
            }
            // EolParserRules.g:113:20: ( modelAlias )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==88) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // EolParserRules.g:0:0: modelAlias
                    {
                    pushFollow(FOLLOW_modelAlias_in_modelDeclaration272);
                    modelAlias4=modelAlias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, modelAlias4.getTree());

                    }
                    break;

            }

            // EolParserRules.g:113:32: ( modelDriver )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==90) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // EolParserRules.g:0:0: modelDriver
                    {
                    pushFollow(FOLLOW_modelDriver_in_modelDeclaration275);
                    modelDriver5=modelDriver();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, modelDriver5.getTree());

                    }
                    break;

            }

            // EolParserRules.g:113:45: ( modelDeclarationParameters )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==91) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // EolParserRules.g:0:0: modelDeclarationParameters
                    {
                    pushFollow(FOLLOW_modelDeclarationParameters_in_modelDeclaration278);
                    modelDeclarationParameters6=modelDeclarationParameters();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, modelDeclarationParameters6.getTree());

                    }
                    break;

            }

            sem=(Token)match(input,87,FOLLOW_87_in_modelDeclaration283); if (state.failed) return retval;

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
    // EolParserRules.g:116:1: modelAlias : a= 'alias' NAME ( ',' NAME )* ;
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
            // EolParserRules.g:117:2: (a= 'alias' NAME ( ',' NAME )* )
            // EolParserRules.g:117:5: a= 'alias' NAME ( ',' NAME )*
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            a=(Token)match(input,88,FOLLOW_88_in_modelAlias298); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            a_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(a);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(a_tree, root_0);
            }
            NAME7=(Token)match(input,NAME,FOLLOW_NAME_in_modelAlias301); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME7_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(NAME7);
            adaptor.addChild(root_0, NAME7_tree);
            }
            // EolParserRules.g:117:21: ( ',' NAME )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==89) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // EolParserRules.g:117:22: ',' NAME
            	    {
            	    char_literal8=(Token)match(input,89,FOLLOW_89_in_modelAlias304); if (state.failed) return retval;
            	    NAME9=(Token)match(input,NAME,FOLLOW_NAME_in_modelAlias307); if (state.failed) return retval;
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
    // EolParserRules.g:121:1: modelDriver : d= 'driver' NAME ;
    public final Egx_EolParserRules.modelDriver_return modelDriver() throws RecognitionException {
        Egx_EolParserRules.modelDriver_return retval = new Egx_EolParserRules.modelDriver_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token d=null;
        Token NAME10=null;

        org.eclipse.epsilon.common.parse.AST d_tree=null;
        org.eclipse.epsilon.common.parse.AST NAME10_tree=null;

        try {
            // EolParserRules.g:122:2: (d= 'driver' NAME )
            // EolParserRules.g:122:5: d= 'driver' NAME
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            d=(Token)match(input,90,FOLLOW_90_in_modelDriver326); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            d_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(d);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(d_tree, root_0);
            }
            NAME10=(Token)match(input,NAME,FOLLOW_NAME_in_modelDriver329); if (state.failed) return retval;
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
    // EolParserRules.g:126:1: modelDeclarationParameters : s= '{' ( modelDeclarationParameter )? ( ',' modelDeclarationParameter )* cb= '}' ;
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
            // EolParserRules.g:131:2: (s= '{' ( modelDeclarationParameter )? ( ',' modelDeclarationParameter )* cb= '}' )
            // EolParserRules.g:131:4: s= '{' ( modelDeclarationParameter )? ( ',' modelDeclarationParameter )* cb= '}'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            s=(Token)match(input,91,FOLLOW_91_in_modelDeclarationParameters351); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            s_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(s);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(s_tree, root_0);
            }
            // EolParserRules.g:131:11: ( modelDeclarationParameter )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==NAME) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // EolParserRules.g:0:0: modelDeclarationParameter
                    {
                    pushFollow(FOLLOW_modelDeclarationParameter_in_modelDeclarationParameters354);
                    modelDeclarationParameter11=modelDeclarationParameter();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, modelDeclarationParameter11.getTree());

                    }
                    break;

            }

            // EolParserRules.g:131:38: ( ',' modelDeclarationParameter )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==89) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // EolParserRules.g:131:39: ',' modelDeclarationParameter
            	    {
            	    char_literal12=(Token)match(input,89,FOLLOW_89_in_modelDeclarationParameters358); if (state.failed) return retval;
            	    pushFollow(FOLLOW_modelDeclarationParameter_in_modelDeclarationParameters361);
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

            cb=(Token)match(input,92,FOLLOW_92_in_modelDeclarationParameters367); if (state.failed) return retval;

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
    // EolParserRules.g:134:1: modelDeclarationParameter : NAME e= '=' STRING ;
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
            // EolParserRules.g:135:2: ( NAME e= '=' STRING )
            // EolParserRules.g:135:4: NAME e= '=' STRING
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            NAME14=(Token)match(input,NAME,FOLLOW_NAME_in_modelDeclarationParameter380); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME14_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(NAME14);
            adaptor.addChild(root_0, NAME14_tree);
            }
            e=(Token)match(input,93,FOLLOW_93_in_modelDeclarationParameter384); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            e_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(e);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(e_tree, root_0);
            }
            STRING15=(Token)match(input,STRING,FOLLOW_STRING_in_modelDeclarationParameter387); if (state.failed) return retval;
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
    // EolParserRules.g:139:1: operationDeclaration : ( 'operation' | 'function' ) (ctx= typeName )? operationName= NAME op= '(' ( formalParameterList )? cp= ')' ( ':' returnType= typeName )? statementBlock ;
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
            // EolParserRules.g:144:2: ( ( 'operation' | 'function' ) (ctx= typeName )? operationName= NAME op= '(' ( formalParameterList )? cp= ')' ( ':' returnType= typeName )? statementBlock )
            // EolParserRules.g:144:4: ( 'operation' | 'function' ) (ctx= typeName )? operationName= NAME op= '(' ( formalParameterList )? cp= ')' ( ':' returnType= typeName )? statementBlock
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            set16=(Token)input.LT(1);
            set16=(Token)input.LT(1);
            if ( (input.LA(1)>=94 && input.LA(1)<=95) ) {
                input.consume();
                if ( state.backtracking==0 ) root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot((org.eclipse.epsilon.common.parse.AST)adaptor.create(set16), root_0);
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            // EolParserRules.g:144:30: (ctx= typeName )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==NAME) ) {
                int LA8_1 = input.LA(2);

                if ( (LA8_1==NAME||(LA8_1>=101 && LA8_1<=103)) ) {
                    alt8=1;
                }
            }
            else if ( ((LA8_0>=104 && LA8_0<=111)) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // EolParserRules.g:144:31: ctx= typeName
                    {
                    pushFollow(FOLLOW_typeName_in_operationDeclaration418);
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

            operationName=(Token)match(input,NAME,FOLLOW_NAME_in_operationDeclaration426); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            operationName_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(operationName);
            adaptor.addChild(root_0, operationName_tree);
            }
            op=(Token)match(input,96,FOLLOW_96_in_operationDeclaration430); if (state.failed) return retval;
            // EolParserRules.g:144:99: ( formalParameterList )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==NAME) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // EolParserRules.g:0:0: formalParameterList
                    {
                    pushFollow(FOLLOW_formalParameterList_in_operationDeclaration433);
                    formalParameterList17=formalParameterList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, formalParameterList17.getTree());

                    }
                    break;

            }

            cp=(Token)match(input,97,FOLLOW_97_in_operationDeclaration438); if (state.failed) return retval;
            // EolParserRules.g:144:128: ( ':' returnType= typeName )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==98) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // EolParserRules.g:144:129: ':' returnType= typeName
                    {
                    char_literal18=(Token)match(input,98,FOLLOW_98_in_operationDeclaration442); if (state.failed) return retval;
                    pushFollow(FOLLOW_typeName_in_operationDeclaration447);
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

            pushFollow(FOLLOW_statementBlock_in_operationDeclaration453);
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
    // EolParserRules.g:147:1: importStatement : i= 'import' STRING sem= ';' ;
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
            // EolParserRules.g:151:2: (i= 'import' STRING sem= ';' )
            // EolParserRules.g:151:4: i= 'import' STRING sem= ';'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            i=(Token)match(input,99,FOLLOW_99_in_importStatement473); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            i_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(i);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(i_tree, root_0);
            }
            STRING20=(Token)match(input,STRING,FOLLOW_STRING_in_importStatement476); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STRING20_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(STRING20);
            adaptor.addChild(root_0, STRING20_tree);
            }
            sem=(Token)match(input,87,FOLLOW_87_in_importStatement480); if (state.failed) return retval;
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
    // EolParserRules.g:155:1: block : ( statement )* -> ^( BLOCK ( statement )* ) ;
    public final Egx_EolParserRules.block_return block() throws RecognitionException {
        Egx_EolParserRules.block_return retval = new Egx_EolParserRules.block_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Egx_EolParserRules.statement_return statement21 = null;


        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        try {
            // EolParserRules.g:159:2: ( ( statement )* -> ^( BLOCK ( statement )* ) )
            // EolParserRules.g:159:4: ( statement )*
            {
            // EolParserRules.g:159:4: ( statement )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==FLOAT||LA11_0==INT||LA11_0==BOOLEAN||LA11_0==STRING||LA11_0==NAME||LA11_0==96||(LA11_0>=104 && LA11_0<=112)||(LA11_0>=114 && LA11_0<=115)||(LA11_0>=119 && LA11_0<=127)||LA11_0==141||LA11_0==144||(LA11_0>=148 && LA11_0<=149)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // EolParserRules.g:0:0: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_block500);
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
            // 160:2: -> ^( BLOCK ( statement )* )
            {
                // EolParserRules.g:160:5: ^( BLOCK ( statement )* )
                {
                org.eclipse.epsilon.common.parse.AST root_1 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();
                root_1 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot((org.eclipse.epsilon.common.parse.AST)adaptor.create(BLOCK, "BLOCK"), root_1);

                // EolParserRules.g:160:13: ( statement )*
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
    // EolParserRules.g:163:1: statementBlock : s= '{' block e= '}' ;
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
            // EolParserRules.g:168:2: (s= '{' block e= '}' )
            // EolParserRules.g:168:4: s= '{' block e= '}'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            s=(Token)match(input,91,FOLLOW_91_in_statementBlock529); if (state.failed) return retval;
            pushFollow(FOLLOW_block_in_statementBlock532);
            block22=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, block22.getTree());
            e=(Token)match(input,92,FOLLOW_92_in_statementBlock536); if (state.failed) return retval;

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
    // EolParserRules.g:171:1: formalParameter : NAME ( ':' pt= typeName )? -> ^( FORMAL NAME ( typeName )? ) ;
    public final Egx_EolParserRules.formalParameter_return formalParameter() throws RecognitionException {
        Egx_EolParserRules.formalParameter_return retval = new Egx_EolParserRules.formalParameter_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token NAME23=null;
        Token char_literal24=null;
        Egx_EolParserRules.typeName_return pt = null;


        org.eclipse.epsilon.common.parse.AST NAME23_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal24_tree=null;
        RewriteRuleTokenStream stream_98=new RewriteRuleTokenStream(adaptor,"token 98");
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleSubtreeStream stream_typeName=new RewriteRuleSubtreeStream(adaptor,"rule typeName");
        try {
            // EolParserRules.g:175:2: ( NAME ( ':' pt= typeName )? -> ^( FORMAL NAME ( typeName )? ) )
            // EolParserRules.g:175:4: NAME ( ':' pt= typeName )?
            {
            NAME23=(Token)match(input,NAME,FOLLOW_NAME_in_formalParameter554); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(NAME23);

            // EolParserRules.g:175:9: ( ':' pt= typeName )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==98) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // EolParserRules.g:175:10: ':' pt= typeName
                    {
                    char_literal24=(Token)match(input,98,FOLLOW_98_in_formalParameter557); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_98.add(char_literal24);

                    pushFollow(FOLLOW_typeName_in_formalParameter561);
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
            // 176:3: -> ^( FORMAL NAME ( typeName )? )
            {
                // EolParserRules.g:176:6: ^( FORMAL NAME ( typeName )? )
                {
                org.eclipse.epsilon.common.parse.AST root_1 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();
                root_1 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot((org.eclipse.epsilon.common.parse.AST)adaptor.create(FORMAL, "FORMAL"), root_1);

                adaptor.addChild(root_1, stream_NAME.nextNode());
                // EolParserRules.g:176:20: ( typeName )?
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
    // $ANTLR end formalParameter

    public static class formalParameterList_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start formalParameterList
    // EolParserRules.g:179:1: formalParameterList : formalParameter ( ',' formalParameter )* -> ^( PARAMLIST ( formalParameter )* ) ;
    public final Egx_EolParserRules.formalParameterList_return formalParameterList() throws RecognitionException {
        Egx_EolParserRules.formalParameterList_return retval = new Egx_EolParserRules.formalParameterList_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token char_literal26=null;
        Egx_EolParserRules.formalParameter_return formalParameter25 = null;

        Egx_EolParserRules.formalParameter_return formalParameter27 = null;


        org.eclipse.epsilon.common.parse.AST char_literal26_tree=null;
        RewriteRuleTokenStream stream_89=new RewriteRuleTokenStream(adaptor,"token 89");
        RewriteRuleSubtreeStream stream_formalParameter=new RewriteRuleSubtreeStream(adaptor,"rule formalParameter");
        try {
            // EolParserRules.g:183:2: ( formalParameter ( ',' formalParameter )* -> ^( PARAMLIST ( formalParameter )* ) )
            // EolParserRules.g:183:4: formalParameter ( ',' formalParameter )*
            {
            pushFollow(FOLLOW_formalParameter_in_formalParameterList595);
            formalParameter25=formalParameter();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_formalParameter.add(formalParameter25.getTree());
            // EolParserRules.g:183:20: ( ',' formalParameter )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==89) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // EolParserRules.g:183:21: ',' formalParameter
            	    {
            	    char_literal26=(Token)match(input,89,FOLLOW_89_in_formalParameterList598); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_89.add(char_literal26);

            	    pushFollow(FOLLOW_formalParameter_in_formalParameterList600);
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
            // 184:2: -> ^( PARAMLIST ( formalParameter )* )
            {
                // EolParserRules.g:184:5: ^( PARAMLIST ( formalParameter )* )
                {
                org.eclipse.epsilon.common.parse.AST root_1 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();
                root_1 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot((org.eclipse.epsilon.common.parse.AST)adaptor.create(PARAMLIST, "PARAMLIST"), root_1);

                // EolParserRules.g:184:17: ( formalParameter )*
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
    // EolParserRules.g:187:1: executableAnnotation : d= '$' x= . logicalExpression ;
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
            // EolParserRules.g:188:2: (d= '$' x= . logicalExpression )
            // EolParserRules.g:188:4: d= '$' x= . logicalExpression
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            d=(Token)match(input,100,FOLLOW_100_in_executableAnnotation625); if (state.failed) return retval;
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
            pushFollow(FOLLOW_logicalExpression_in_executableAnnotation632);
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
    // EolParserRules.g:192:1: annotation : ( Annotation | executableAnnotation );
    public final Egx_EolParserRules.annotation_return annotation() throws RecognitionException {
        Egx_EolParserRules.annotation_return retval = new Egx_EolParserRules.annotation_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token Annotation29=null;
        Egx_EolParserRules.executableAnnotation_return executableAnnotation30 = null;


        org.eclipse.epsilon.common.parse.AST Annotation29_tree=null;

        try {
            // EolParserRules.g:193:2: ( Annotation | executableAnnotation )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==Annotation) ) {
                alt14=1;
            }
            else if ( (LA14_0==100) ) {
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
                    // EolParserRules.g:193:4: Annotation
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    Annotation29=(Token)match(input,Annotation,FOLLOW_Annotation_in_annotation646); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    Annotation29_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(Annotation29);
                    adaptor.addChild(root_0, Annotation29_tree);
                    }

                    }
                    break;
                case 2 :
                    // EolParserRules.g:193:15: executableAnnotation
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_executableAnnotation_in_annotation648);
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
    // EolParserRules.g:196:1: annotationBlock : ( annotation )+ -> ^( ANNOTATIONBLOCK ( annotation )+ ) ;
    public final Egx_EolParserRules.annotationBlock_return annotationBlock() throws RecognitionException {
        Egx_EolParserRules.annotationBlock_return retval = new Egx_EolParserRules.annotationBlock_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Egx_EolParserRules.annotation_return annotation31 = null;


        RewriteRuleSubtreeStream stream_annotation=new RewriteRuleSubtreeStream(adaptor,"rule annotation");
        try {
            // EolParserRules.g:200:2: ( ( annotation )+ -> ^( ANNOTATIONBLOCK ( annotation )+ ) )
            // EolParserRules.g:200:4: ( annotation )+
            {
            // EolParserRules.g:200:4: ( annotation )+
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
                else if ( (LA15_0==100) ) {
                    int LA15_3 = input.LA(2);

                    if ( (synpred16_EolParserRules()) ) {
                        alt15=1;
                    }


                }


                switch (alt15) {
            	case 1 :
            	    // EolParserRules.g:0:0: annotation
            	    {
            	    pushFollow(FOLLOW_annotation_in_annotationBlock665);
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
            // 201:2: -> ^( ANNOTATIONBLOCK ( annotation )+ )
            {
                // EolParserRules.g:201:5: ^( ANNOTATIONBLOCK ( annotation )+ )
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
    // EolParserRules.g:204:1: typeName : ( pathName | nativeType | collectionType );
    public final Egx_EolParserRules.typeName_return typeName() throws RecognitionException {
        Egx_EolParserRules.typeName_return retval = new Egx_EolParserRules.typeName_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Egx_EolParserRules.pathName_return pathName32 = null;

        Egx_EolParserRules.nativeType_return nativeType33 = null;

        Egx_EolParserRules.collectionType_return collectionType34 = null;



        try {
            // EolParserRules.g:208:2: ( pathName | nativeType | collectionType )
            int alt16=3;
            switch ( input.LA(1) ) {
            case NAME:
                {
                alt16=1;
                }
                break;
            case 104:
                {
                alt16=2;
                }
                break;
            case 105:
            case 106:
            case 107:
            case 108:
            case 109:
            case 110:
            case 111:
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
                    // EolParserRules.g:208:4: pathName
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_pathName_in_typeName694);
                    pathName32=pathName();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pathName32.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:208:15: nativeType
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_nativeType_in_typeName698);
                    nativeType33=nativeType();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nativeType33.getTree());

                    }
                    break;
                case 3 :
                    // EolParserRules.g:208:28: collectionType
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_collectionType_in_typeName702);
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
    // EolParserRules.g:211:1: pathName : (metamodel= NAME '!' )? head= packagedType ( '#' label= NAME )? ;
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
            // EolParserRules.g:212:2: ( (metamodel= NAME '!' )? head= packagedType ( '#' label= NAME )? )
            // EolParserRules.g:212:4: (metamodel= NAME '!' )? head= packagedType ( '#' label= NAME )?
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            // EolParserRules.g:212:4: (metamodel= NAME '!' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==NAME) ) {
                int LA17_1 = input.LA(2);

                if ( (LA17_1==101) ) {
                    alt17=1;
                }
            }
            switch (alt17) {
                case 1 :
                    // EolParserRules.g:212:5: metamodel= NAME '!'
                    {
                    metamodel=(Token)match(input,NAME,FOLLOW_NAME_in_pathName716); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    metamodel_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(metamodel);
                    adaptor.addChild(root_0, metamodel_tree);
                    }
                    char_literal35=(Token)match(input,101,FOLLOW_101_in_pathName718); if (state.failed) return retval;

                    }
                    break;

            }

            pushFollow(FOLLOW_packagedType_in_pathName727);
            head=packagedType();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(head.getTree(), root_0);
            // EolParserRules.g:214:3: ( '#' label= NAME )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==102) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // EolParserRules.g:214:4: '#' label= NAME
                    {
                    char_literal36=(Token)match(input,102,FOLLOW_102_in_pathName733); if (state.failed) return retval;
                    label=(Token)match(input,NAME,FOLLOW_NAME_in_pathName738); if (state.failed) return retval;
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
    // EolParserRules.g:228:1: packagedType : head= NAME ( '::' field= NAME )* ;
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
            // EolParserRules.g:229:2: (head= NAME ( '::' field= NAME )* )
            // EolParserRules.g:229:4: head= NAME ( '::' field= NAME )*
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            head=(Token)match(input,NAME,FOLLOW_NAME_in_packagedType759); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            head_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(head);
            adaptor.addChild(root_0, head_tree);
            }
            // EolParserRules.g:229:14: ( '::' field= NAME )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==103) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // EolParserRules.g:229:15: '::' field= NAME
            	    {
            	    string_literal37=(Token)match(input,103,FOLLOW_103_in_packagedType762); if (state.failed) return retval;
            	    field=(Token)match(input,NAME,FOLLOW_NAME_in_packagedType767); if (state.failed) return retval;
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
    // EolParserRules.g:237:1: nativeType : n= 'Native' '(' STRING ')' ;
    public final Egx_EolParserRules.nativeType_return nativeType() throws RecognitionException {
        Egx_EolParserRules.nativeType_return retval = new Egx_EolParserRules.nativeType_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token n=null;
        Token char_literal38=null;
        Token STRING39=null;
        Token char_literal40=null;

        org.eclipse.epsilon.common.parse.AST n_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal38_tree=null;
        org.eclipse.epsilon.common.parse.AST STRING39_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal40_tree=null;

        try {
            // EolParserRules.g:238:2: (n= 'Native' '(' STRING ')' )
            // EolParserRules.g:238:4: n= 'Native' '(' STRING ')'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            n=(Token)match(input,104,FOLLOW_104_in_nativeType792); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            n_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(n);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(n_tree, root_0);
            }
            char_literal38=(Token)match(input,96,FOLLOW_96_in_nativeType795); if (state.failed) return retval;
            STRING39=(Token)match(input,STRING,FOLLOW_STRING_in_nativeType798); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STRING39_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(STRING39);
            adaptor.addChild(root_0, STRING39_tree);
            }
            char_literal40=(Token)match(input,97,FOLLOW_97_in_nativeType800); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
              n.setType(TYPE);
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
    // $ANTLR end nativeType

    public static class collectionType_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start collectionType
    // EolParserRules.g:242:1: collectionType : ( 'Collection' | 'Sequence' | 'List' | 'Bag' | 'Set' | 'OrderedSet' | 'Map' ) (op= '(' tn= typeName cp= ')' )? ;
    public final Egx_EolParserRules.collectionType_return collectionType() throws RecognitionException {
        Egx_EolParserRules.collectionType_return retval = new Egx_EolParserRules.collectionType_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token op=null;
        Token cp=null;
        Token set41=null;
        Egx_EolParserRules.typeName_return tn = null;


        org.eclipse.epsilon.common.parse.AST op_tree=null;
        org.eclipse.epsilon.common.parse.AST cp_tree=null;
        org.eclipse.epsilon.common.parse.AST set41_tree=null;

        try {
            // EolParserRules.g:248:2: ( ( 'Collection' | 'Sequence' | 'List' | 'Bag' | 'Set' | 'OrderedSet' | 'Map' ) (op= '(' tn= typeName cp= ')' )? )
            // EolParserRules.g:248:5: ( 'Collection' | 'Sequence' | 'List' | 'Bag' | 'Set' | 'OrderedSet' | 'Map' ) (op= '(' tn= typeName cp= ')' )?
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            set41=(Token)input.LT(1);
            set41=(Token)input.LT(1);
            if ( (input.LA(1)>=105 && input.LA(1)<=111) ) {
                input.consume();
                if ( state.backtracking==0 ) root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot((org.eclipse.epsilon.common.parse.AST)adaptor.create(set41), root_0);
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            // EolParserRules.g:249:3: (op= '(' tn= typeName cp= ')' )?
            int alt20=2;
            alt20 = dfa20.predict(input);
            switch (alt20) {
                case 1 :
                    // EolParserRules.g:249:4: op= '(' tn= typeName cp= ')'
                    {
                    op=(Token)match(input,96,FOLLOW_96_in_collectionType843); if (state.failed) return retval;
                    pushFollow(FOLLOW_typeName_in_collectionType848);
                    tn=typeName();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, tn.getTree());
                    if ( state.backtracking==0 ) {
                      setTokenType(tn,TYPE);
                    }
                    cp=(Token)match(input,97,FOLLOW_97_in_collectionType854); if (state.failed) return retval;

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
    // EolParserRules.g:252:1: statement : ( statementA | statementB );
    public final Egx_EolParserRules.statement_return statement() throws RecognitionException {
        Egx_EolParserRules.statement_return retval = new Egx_EolParserRules.statement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Egx_EolParserRules.statementA_return statementA42 = null;

        Egx_EolParserRules.statementB_return statementB43 = null;



        try {
            // EolParserRules.g:253:2: ( statementA | statementB )
            int alt21=2;
            alt21 = dfa21.predict(input);
            switch (alt21) {
                case 1 :
                    // EolParserRules.g:253:4: statementA
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_statementA_in_statement869);
                    statementA42=statementA();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statementA42.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:253:17: statementB
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_statementB_in_statement873);
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
    // EolParserRules.g:256:1: statementA : ( assignmentStatement | expressionStatement | forStatement | ifStatement | whileStatement | switchStatement | returnStatement | breakStatement );
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
            // EolParserRules.g:257:2: ( assignmentStatement | expressionStatement | forStatement | ifStatement | whileStatement | switchStatement | returnStatement | breakStatement )
            int alt22=8;
            alt22 = dfa22.predict(input);
            switch (alt22) {
                case 1 :
                    // EolParserRules.g:257:4: assignmentStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_assignmentStatement_in_statementA884);
                    assignmentStatement44=assignmentStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, assignmentStatement44.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:257:26: expressionStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_expressionStatement_in_statementA888);
                    expressionStatement45=expressionStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionStatement45.getTree());

                    }
                    break;
                case 3 :
                    // EolParserRules.g:257:48: forStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_forStatement_in_statementA892);
                    forStatement46=forStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, forStatement46.getTree());

                    }
                    break;
                case 4 :
                    // EolParserRules.g:258:5: ifStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_ifStatement_in_statementA898);
                    ifStatement47=ifStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, ifStatement47.getTree());

                    }
                    break;
                case 5 :
                    // EolParserRules.g:258:19: whileStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_whileStatement_in_statementA902);
                    whileStatement48=whileStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, whileStatement48.getTree());

                    }
                    break;
                case 6 :
                    // EolParserRules.g:258:36: switchStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_switchStatement_in_statementA906);
                    switchStatement49=switchStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, switchStatement49.getTree());

                    }
                    break;
                case 7 :
                    // EolParserRules.g:258:54: returnStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_returnStatement_in_statementA910);
                    returnStatement50=returnStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, returnStatement50.getTree());

                    }
                    break;
                case 8 :
                    // EolParserRules.g:258:72: breakStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_breakStatement_in_statementA914);
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
    // EolParserRules.g:261:1: statementB : ( breakAllStatement | returnStatement | transactionStatement | abortStatement | continueStatement | throwStatement | deleteStatement );
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
            // EolParserRules.g:262:2: ( breakAllStatement | returnStatement | transactionStatement | abortStatement | continueStatement | throwStatement | deleteStatement )
            int alt23=7;
            switch ( input.LA(1) ) {
            case 124:
                {
                alt23=1;
                }
                break;
            case 120:
                {
                alt23=2;
                }
                break;
            case 127:
                {
                alt23=3;
                }
                break;
            case 126:
                {
                alt23=4;
                }
                break;
            case 125:
                {
                alt23=5;
                }
                break;
            case 121:
                {
                alt23=6;
                }
                break;
            case 122:
                {
                alt23=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // EolParserRules.g:262:4: breakAllStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_breakAllStatement_in_statementB926);
                    breakAllStatement52=breakAllStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, breakAllStatement52.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:262:24: returnStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_returnStatement_in_statementB930);
                    returnStatement53=returnStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, returnStatement53.getTree());

                    }
                    break;
                case 3 :
                    // EolParserRules.g:262:42: transactionStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_transactionStatement_in_statementB934);
                    transactionStatement54=transactionStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, transactionStatement54.getTree());

                    }
                    break;
                case 4 :
                    // EolParserRules.g:263:5: abortStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_abortStatement_in_statementB940);
                    abortStatement55=abortStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, abortStatement55.getTree());

                    }
                    break;
                case 5 :
                    // EolParserRules.g:263:22: continueStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_continueStatement_in_statementB944);
                    continueStatement56=continueStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, continueStatement56.getTree());

                    }
                    break;
                case 6 :
                    // EolParserRules.g:263:42: throwStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_throwStatement_in_statementB948);
                    throwStatement57=throwStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, throwStatement57.getTree());

                    }
                    break;
                case 7 :
                    // EolParserRules.g:264:5: deleteStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_deleteStatement_in_statementB954);
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
    // EolParserRules.g:267:1: statementOrStatementBlock : ( statement | statementBlock );
    public final Egx_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock() throws RecognitionException {
        Egx_EolParserRules.statementOrStatementBlock_return retval = new Egx_EolParserRules.statementOrStatementBlock_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Egx_EolParserRules.statement_return statement59 = null;

        Egx_EolParserRules.statementBlock_return statementBlock60 = null;



        try {
            // EolParserRules.g:268:2: ( statement | statementBlock )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==FLOAT||LA24_0==INT||LA24_0==BOOLEAN||LA24_0==STRING||LA24_0==NAME||LA24_0==96||(LA24_0>=104 && LA24_0<=112)||(LA24_0>=114 && LA24_0<=115)||(LA24_0>=119 && LA24_0<=127)||LA24_0==141||LA24_0==144||(LA24_0>=148 && LA24_0<=149)) ) {
                alt24=1;
            }
            else if ( (LA24_0==91) ) {
                alt24=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // EolParserRules.g:268:4: statement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_statement_in_statementOrStatementBlock965);
                    statement59=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement59.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:268:16: statementBlock
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_statementBlock_in_statementOrStatementBlock969);
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
    // EolParserRules.g:270:1: expressionOrStatementBlock : ( ':' logicalExpression | statementBlock );
    public final Egx_EolParserRules.expressionOrStatementBlock_return expressionOrStatementBlock() throws RecognitionException {
        Egx_EolParserRules.expressionOrStatementBlock_return retval = new Egx_EolParserRules.expressionOrStatementBlock_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token char_literal61=null;
        Egx_EolParserRules.logicalExpression_return logicalExpression62 = null;

        Egx_EolParserRules.statementBlock_return statementBlock63 = null;


        org.eclipse.epsilon.common.parse.AST char_literal61_tree=null;

        try {
            // EolParserRules.g:271:2: ( ':' logicalExpression | statementBlock )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==98) ) {
                alt25=1;
            }
            else if ( (LA25_0==91) ) {
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
                    // EolParserRules.g:271:4: ':' logicalExpression
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    char_literal61=(Token)match(input,98,FOLLOW_98_in_expressionOrStatementBlock978); if (state.failed) return retval;
                    pushFollow(FOLLOW_logicalExpression_in_expressionOrStatementBlock981);
                    logicalExpression62=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression62.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:271:29: statementBlock
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_statementBlock_in_expressionOrStatementBlock985);
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
    // EolParserRules.g:274:1: forStatement : f= 'for' '(' formalParameter 'in' logicalExpression ')' statementOrStatementBlock ;
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
            // EolParserRules.g:275:2: (f= 'for' '(' formalParameter 'in' logicalExpression ')' statementOrStatementBlock )
            // EolParserRules.g:275:4: f= 'for' '(' formalParameter 'in' logicalExpression ')' statementOrStatementBlock
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            f=(Token)match(input,112,FOLLOW_112_in_forStatement998); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            f_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(f);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(f_tree, root_0);
            }
            char_literal64=(Token)match(input,96,FOLLOW_96_in_forStatement1001); if (state.failed) return retval;
            pushFollow(FOLLOW_formalParameter_in_forStatement1004);
            formalParameter65=formalParameter();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, formalParameter65.getTree());
            string_literal66=(Token)match(input,113,FOLLOW_113_in_forStatement1006); if (state.failed) return retval;
            pushFollow(FOLLOW_logicalExpression_in_forStatement1009);
            logicalExpression67=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression67.getTree());
            char_literal68=(Token)match(input,97,FOLLOW_97_in_forStatement1011); if (state.failed) return retval;
            pushFollow(FOLLOW_statementOrStatementBlock_in_forStatement1014);
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
    // EolParserRules.g:279:1: ifStatement : i= 'if' '(' logicalExpression ')' statementOrStatementBlock ( elseStatement )? ;
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
            // EolParserRules.g:280:2: (i= 'if' '(' logicalExpression ')' statementOrStatementBlock ( elseStatement )? )
            // EolParserRules.g:280:4: i= 'if' '(' logicalExpression ')' statementOrStatementBlock ( elseStatement )?
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            i=(Token)match(input,114,FOLLOW_114_in_ifStatement1030); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            i_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(i);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(i_tree, root_0);
            }
            char_literal70=(Token)match(input,96,FOLLOW_96_in_ifStatement1033); if (state.failed) return retval;
            pushFollow(FOLLOW_logicalExpression_in_ifStatement1036);
            logicalExpression71=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression71.getTree());
            char_literal72=(Token)match(input,97,FOLLOW_97_in_ifStatement1038); if (state.failed) return retval;
            pushFollow(FOLLOW_statementOrStatementBlock_in_ifStatement1041);
            statementOrStatementBlock73=statementOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, statementOrStatementBlock73.getTree());
            // EolParserRules.g:280:66: ( elseStatement )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==118) ) {
                int LA26_1 = input.LA(2);

                if ( (synpred45_EolParserRules()) ) {
                    alt26=1;
                }
            }
            switch (alt26) {
                case 1 :
                    // EolParserRules.g:0:0: elseStatement
                    {
                    pushFollow(FOLLOW_elseStatement_in_ifStatement1043);
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
    // EolParserRules.g:284:1: switchStatement : s= 'switch' '(' logicalExpression ')' '{' ( caseStatement )* ( defaultStatement )? '}' ;
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
            // EolParserRules.g:285:2: (s= 'switch' '(' logicalExpression ')' '{' ( caseStatement )* ( defaultStatement )? '}' )
            // EolParserRules.g:285:4: s= 'switch' '(' logicalExpression ')' '{' ( caseStatement )* ( defaultStatement )? '}'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            s=(Token)match(input,115,FOLLOW_115_in_switchStatement1062); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            s_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(s);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(s_tree, root_0);
            }
            char_literal75=(Token)match(input,96,FOLLOW_96_in_switchStatement1065); if (state.failed) return retval;
            pushFollow(FOLLOW_logicalExpression_in_switchStatement1068);
            logicalExpression76=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression76.getTree());
            char_literal77=(Token)match(input,97,FOLLOW_97_in_switchStatement1070); if (state.failed) return retval;
            char_literal78=(Token)match(input,91,FOLLOW_91_in_switchStatement1073); if (state.failed) return retval;
            // EolParserRules.g:285:49: ( caseStatement )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==116) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // EolParserRules.g:0:0: caseStatement
            	    {
            	    pushFollow(FOLLOW_caseStatement_in_switchStatement1076);
            	    caseStatement79=caseStatement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, caseStatement79.getTree());

            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

            // EolParserRules.g:285:64: ( defaultStatement )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==117) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // EolParserRules.g:0:0: defaultStatement
                    {
                    pushFollow(FOLLOW_defaultStatement_in_switchStatement1079);
                    defaultStatement80=defaultStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, defaultStatement80.getTree());

                    }
                    break;

            }

            char_literal81=(Token)match(input,92,FOLLOW_92_in_switchStatement1082); if (state.failed) return retval;
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
    // EolParserRules.g:289:1: caseStatement : c= 'case' logicalExpression ':' block ;
    public final Egx_EolParserRules.caseStatement_return caseStatement() throws RecognitionException {
        Egx_EolParserRules.caseStatement_return retval = new Egx_EolParserRules.caseStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token c=null;
        Token char_literal83=null;
        Egx_EolParserRules.logicalExpression_return logicalExpression82 = null;

        Egx_EolParserRules.block_return block84 = null;


        org.eclipse.epsilon.common.parse.AST c_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal83_tree=null;

        try {
            // EolParserRules.g:290:2: (c= 'case' logicalExpression ':' block )
            // EolParserRules.g:290:4: c= 'case' logicalExpression ':' block
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            c=(Token)match(input,116,FOLLOW_116_in_caseStatement1101); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            c_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(c);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(c_tree, root_0);
            }
            pushFollow(FOLLOW_logicalExpression_in_caseStatement1104);
            logicalExpression82=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression82.getTree());
            char_literal83=(Token)match(input,98,FOLLOW_98_in_caseStatement1106); if (state.failed) return retval;
            pushFollow(FOLLOW_block_in_caseStatement1109);
            block84=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, block84.getTree());
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
    // EolParserRules.g:294:1: defaultStatement : d= 'default' ':' block ;
    public final Egx_EolParserRules.defaultStatement_return defaultStatement() throws RecognitionException {
        Egx_EolParserRules.defaultStatement_return retval = new Egx_EolParserRules.defaultStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token d=null;
        Token char_literal85=null;
        Egx_EolParserRules.block_return block86 = null;


        org.eclipse.epsilon.common.parse.AST d_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal85_tree=null;

        try {
            // EolParserRules.g:295:2: (d= 'default' ':' block )
            // EolParserRules.g:295:4: d= 'default' ':' block
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            d=(Token)match(input,117,FOLLOW_117_in_defaultStatement1127); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            d_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(d);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(d_tree, root_0);
            }
            char_literal85=(Token)match(input,98,FOLLOW_98_in_defaultStatement1130); if (state.failed) return retval;
            pushFollow(FOLLOW_block_in_defaultStatement1133);
            block86=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, block86.getTree());
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
    // EolParserRules.g:299:1: elseStatement : e= 'else' statementOrStatementBlock ;
    public final Egx_EolParserRules.elseStatement_return elseStatement() throws RecognitionException {
        Egx_EolParserRules.elseStatement_return retval = new Egx_EolParserRules.elseStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token e=null;
        Egx_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock87 = null;


        org.eclipse.epsilon.common.parse.AST e_tree=null;

        try {
            // EolParserRules.g:303:2: (e= 'else' statementOrStatementBlock )
            // EolParserRules.g:303:4: e= 'else' statementOrStatementBlock
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            e=(Token)match(input,118,FOLLOW_118_in_elseStatement1157); if (state.failed) return retval;
            pushFollow(FOLLOW_statementOrStatementBlock_in_elseStatement1160);
            statementOrStatementBlock87=statementOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, statementOrStatementBlock87.getTree());

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
    // EolParserRules.g:306:1: whileStatement : w= 'while' '(' logicalExpression ')' statementOrStatementBlock ;
    public final Egx_EolParserRules.whileStatement_return whileStatement() throws RecognitionException {
        Egx_EolParserRules.whileStatement_return retval = new Egx_EolParserRules.whileStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token w=null;
        Token char_literal88=null;
        Token char_literal90=null;
        Egx_EolParserRules.logicalExpression_return logicalExpression89 = null;

        Egx_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock91 = null;


        org.eclipse.epsilon.common.parse.AST w_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal88_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal90_tree=null;

        try {
            // EolParserRules.g:307:2: (w= 'while' '(' logicalExpression ')' statementOrStatementBlock )
            // EolParserRules.g:307:4: w= 'while' '(' logicalExpression ')' statementOrStatementBlock
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            w=(Token)match(input,119,FOLLOW_119_in_whileStatement1173); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            w_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(w);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(w_tree, root_0);
            }
            char_literal88=(Token)match(input,96,FOLLOW_96_in_whileStatement1176); if (state.failed) return retval;
            pushFollow(FOLLOW_logicalExpression_in_whileStatement1179);
            logicalExpression89=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression89.getTree());
            char_literal90=(Token)match(input,97,FOLLOW_97_in_whileStatement1181); if (state.failed) return retval;
            pushFollow(FOLLOW_statementOrStatementBlock_in_whileStatement1184);
            statementOrStatementBlock91=statementOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, statementOrStatementBlock91.getTree());
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
    // EolParserRules.g:311:1: returnStatement : r= 'return' ( logicalExpression )? sem= ';' ;
    public final Egx_EolParserRules.returnStatement_return returnStatement() throws RecognitionException {
        Egx_EolParserRules.returnStatement_return retval = new Egx_EolParserRules.returnStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token r=null;
        Token sem=null;
        Egx_EolParserRules.logicalExpression_return logicalExpression92 = null;


        org.eclipse.epsilon.common.parse.AST r_tree=null;
        org.eclipse.epsilon.common.parse.AST sem_tree=null;

        try {
            // EolParserRules.g:315:2: (r= 'return' ( logicalExpression )? sem= ';' )
            // EolParserRules.g:315:4: r= 'return' ( logicalExpression )? sem= ';'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            r=(Token)match(input,120,FOLLOW_120_in_returnStatement1206); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            r_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(r);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(r_tree, root_0);
            }
            // EolParserRules.g:315:16: ( logicalExpression )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==FLOAT||LA29_0==INT||LA29_0==BOOLEAN||LA29_0==STRING||LA29_0==NAME||LA29_0==96||(LA29_0>=104 && LA29_0<=111)||LA29_0==141||LA29_0==144||(LA29_0>=148 && LA29_0<=149)) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // EolParserRules.g:0:0: logicalExpression
                    {
                    pushFollow(FOLLOW_logicalExpression_in_returnStatement1209);
                    logicalExpression92=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression92.getTree());

                    }
                    break;

            }

            sem=(Token)match(input,87,FOLLOW_87_in_returnStatement1214); if (state.failed) return retval;
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
    // EolParserRules.g:319:1: throwStatement : t= 'throw' ( logicalExpression )? sem= ';' ;
    public final Egx_EolParserRules.throwStatement_return throwStatement() throws RecognitionException {
        Egx_EolParserRules.throwStatement_return retval = new Egx_EolParserRules.throwStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token t=null;
        Token sem=null;
        Egx_EolParserRules.logicalExpression_return logicalExpression93 = null;


        org.eclipse.epsilon.common.parse.AST t_tree=null;
        org.eclipse.epsilon.common.parse.AST sem_tree=null;

        try {
            // EolParserRules.g:323:2: (t= 'throw' ( logicalExpression )? sem= ';' )
            // EolParserRules.g:323:4: t= 'throw' ( logicalExpression )? sem= ';'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            t=(Token)match(input,121,FOLLOW_121_in_throwStatement1237); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            t_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(t);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(t_tree, root_0);
            }
            // EolParserRules.g:323:15: ( logicalExpression )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==FLOAT||LA30_0==INT||LA30_0==BOOLEAN||LA30_0==STRING||LA30_0==NAME||LA30_0==96||(LA30_0>=104 && LA30_0<=111)||LA30_0==141||LA30_0==144||(LA30_0>=148 && LA30_0<=149)) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // EolParserRules.g:0:0: logicalExpression
                    {
                    pushFollow(FOLLOW_logicalExpression_in_throwStatement1240);
                    logicalExpression93=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression93.getTree());

                    }
                    break;

            }

            sem=(Token)match(input,87,FOLLOW_87_in_throwStatement1245); if (state.failed) return retval;
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
    // EolParserRules.g:327:1: deleteStatement : d= 'delete' ( logicalExpression )? sem= ';' ;
    public final Egx_EolParserRules.deleteStatement_return deleteStatement() throws RecognitionException {
        Egx_EolParserRules.deleteStatement_return retval = new Egx_EolParserRules.deleteStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token d=null;
        Token sem=null;
        Egx_EolParserRules.logicalExpression_return logicalExpression94 = null;


        org.eclipse.epsilon.common.parse.AST d_tree=null;
        org.eclipse.epsilon.common.parse.AST sem_tree=null;

        try {
            // EolParserRules.g:331:2: (d= 'delete' ( logicalExpression )? sem= ';' )
            // EolParserRules.g:331:4: d= 'delete' ( logicalExpression )? sem= ';'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            d=(Token)match(input,122,FOLLOW_122_in_deleteStatement1268); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            d_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(d);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(d_tree, root_0);
            }
            // EolParserRules.g:331:16: ( logicalExpression )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==FLOAT||LA31_0==INT||LA31_0==BOOLEAN||LA31_0==STRING||LA31_0==NAME||LA31_0==96||(LA31_0>=104 && LA31_0<=111)||LA31_0==141||LA31_0==144||(LA31_0>=148 && LA31_0<=149)) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // EolParserRules.g:0:0: logicalExpression
                    {
                    pushFollow(FOLLOW_logicalExpression_in_deleteStatement1271);
                    logicalExpression94=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression94.getTree());

                    }
                    break;

            }

            sem=(Token)match(input,87,FOLLOW_87_in_deleteStatement1276); if (state.failed) return retval;
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
    // EolParserRules.g:335:1: breakStatement : b= 'break' sem= ';' ;
    public final Egx_EolParserRules.breakStatement_return breakStatement() throws RecognitionException {
        Egx_EolParserRules.breakStatement_return retval = new Egx_EolParserRules.breakStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token b=null;
        Token sem=null;

        org.eclipse.epsilon.common.parse.AST b_tree=null;
        org.eclipse.epsilon.common.parse.AST sem_tree=null;

        try {
            // EolParserRules.g:339:2: (b= 'break' sem= ';' )
            // EolParserRules.g:339:4: b= 'break' sem= ';'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            b=(Token)match(input,123,FOLLOW_123_in_breakStatement1302); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            b_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(b);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(b_tree, root_0);
            }
            sem=(Token)match(input,87,FOLLOW_87_in_breakStatement1307); if (state.failed) return retval;
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
    // EolParserRules.g:343:1: breakAllStatement : b= 'breakAll' sem= ';' ;
    public final Egx_EolParserRules.breakAllStatement_return breakAllStatement() throws RecognitionException {
        Egx_EolParserRules.breakAllStatement_return retval = new Egx_EolParserRules.breakAllStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token b=null;
        Token sem=null;

        org.eclipse.epsilon.common.parse.AST b_tree=null;
        org.eclipse.epsilon.common.parse.AST sem_tree=null;

        try {
            // EolParserRules.g:347:2: (b= 'breakAll' sem= ';' )
            // EolParserRules.g:347:4: b= 'breakAll' sem= ';'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            b=(Token)match(input,124,FOLLOW_124_in_breakAllStatement1330); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            b_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(b);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(b_tree, root_0);
            }
            sem=(Token)match(input,87,FOLLOW_87_in_breakAllStatement1335); if (state.failed) return retval;
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
    // EolParserRules.g:351:1: continueStatement : c= 'continue' sem= ';' ;
    public final Egx_EolParserRules.continueStatement_return continueStatement() throws RecognitionException {
        Egx_EolParserRules.continueStatement_return retval = new Egx_EolParserRules.continueStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token c=null;
        Token sem=null;

        org.eclipse.epsilon.common.parse.AST c_tree=null;
        org.eclipse.epsilon.common.parse.AST sem_tree=null;

        try {
            // EolParserRules.g:355:2: (c= 'continue' sem= ';' )
            // EolParserRules.g:355:4: c= 'continue' sem= ';'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            c=(Token)match(input,125,FOLLOW_125_in_continueStatement1358); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            c_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(c);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(c_tree, root_0);
            }
            sem=(Token)match(input,87,FOLLOW_87_in_continueStatement1363); if (state.failed) return retval;
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
    // EolParserRules.g:359:1: abortStatement : a= 'abort' sem= ';' ;
    public final Egx_EolParserRules.abortStatement_return abortStatement() throws RecognitionException {
        Egx_EolParserRules.abortStatement_return retval = new Egx_EolParserRules.abortStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token a=null;
        Token sem=null;

        org.eclipse.epsilon.common.parse.AST a_tree=null;
        org.eclipse.epsilon.common.parse.AST sem_tree=null;

        try {
            // EolParserRules.g:363:2: (a= 'abort' sem= ';' )
            // EolParserRules.g:363:4: a= 'abort' sem= ';'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            a=(Token)match(input,126,FOLLOW_126_in_abortStatement1386); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            a_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(a);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(a_tree, root_0);
            }
            sem=(Token)match(input,87,FOLLOW_87_in_abortStatement1391); if (state.failed) return retval;
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
    // EolParserRules.g:367:1: transactionStatement : t= 'transaction' ( NAME ( ',' NAME )* )? statementOrStatementBlock ;
    public final Egx_EolParserRules.transactionStatement_return transactionStatement() throws RecognitionException {
        Egx_EolParserRules.transactionStatement_return retval = new Egx_EolParserRules.transactionStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token t=null;
        Token NAME95=null;
        Token char_literal96=null;
        Token NAME97=null;
        Egx_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock98 = null;


        org.eclipse.epsilon.common.parse.AST t_tree=null;
        org.eclipse.epsilon.common.parse.AST NAME95_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal96_tree=null;
        org.eclipse.epsilon.common.parse.AST NAME97_tree=null;

        try {
            // EolParserRules.g:368:2: (t= 'transaction' ( NAME ( ',' NAME )* )? statementOrStatementBlock )
            // EolParserRules.g:368:4: t= 'transaction' ( NAME ( ',' NAME )* )? statementOrStatementBlock
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            t=(Token)match(input,127,FOLLOW_127_in_transactionStatement1408); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            t_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(t);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(t_tree, root_0);
            }
            // EolParserRules.g:368:21: ( NAME ( ',' NAME )* )?
            int alt33=2;
            alt33 = dfa33.predict(input);
            switch (alt33) {
                case 1 :
                    // EolParserRules.g:368:22: NAME ( ',' NAME )*
                    {
                    NAME95=(Token)match(input,NAME,FOLLOW_NAME_in_transactionStatement1412); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NAME95_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(NAME95);
                    adaptor.addChild(root_0, NAME95_tree);
                    }
                    // EolParserRules.g:368:27: ( ',' NAME )*
                    loop32:
                    do {
                        int alt32=2;
                        int LA32_0 = input.LA(1);

                        if ( (LA32_0==89) ) {
                            alt32=1;
                        }


                        switch (alt32) {
                    	case 1 :
                    	    // EolParserRules.g:368:28: ',' NAME
                    	    {
                    	    char_literal96=(Token)match(input,89,FOLLOW_89_in_transactionStatement1415); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal96_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(char_literal96);
                    	    adaptor.addChild(root_0, char_literal96_tree);
                    	    }
                    	    NAME97=(Token)match(input,NAME,FOLLOW_NAME_in_transactionStatement1417); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    NAME97_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(NAME97);
                    	    adaptor.addChild(root_0, NAME97_tree);
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop32;
                        }
                    } while (true);


                    }
                    break;

            }

            pushFollow(FOLLOW_statementOrStatementBlock_in_transactionStatement1423);
            statementOrStatementBlock98=statementOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, statementOrStatementBlock98.getTree());
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
    // EolParserRules.g:372:1: assignmentStatement : logicalExpression (normal= ':=' | special= '::=' ) logicalExpression sem= ';' ;
    public final Egx_EolParserRules.assignmentStatement_return assignmentStatement() throws RecognitionException {
        Egx_EolParserRules.assignmentStatement_return retval = new Egx_EolParserRules.assignmentStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token normal=null;
        Token special=null;
        Token sem=null;
        Egx_EolParserRules.logicalExpression_return logicalExpression99 = null;

        Egx_EolParserRules.logicalExpression_return logicalExpression100 = null;


        org.eclipse.epsilon.common.parse.AST normal_tree=null;
        org.eclipse.epsilon.common.parse.AST special_tree=null;
        org.eclipse.epsilon.common.parse.AST sem_tree=null;

        try {
            // EolParserRules.g:376:2: ( logicalExpression (normal= ':=' | special= '::=' ) logicalExpression sem= ';' )
            // EolParserRules.g:376:4: logicalExpression (normal= ':=' | special= '::=' ) logicalExpression sem= ';'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            pushFollow(FOLLOW_logicalExpression_in_assignmentStatement1443);
            logicalExpression99=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression99.getTree());
            // EolParserRules.g:376:22: (normal= ':=' | special= '::=' )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==128) ) {
                alt34=1;
            }
            else if ( (LA34_0==129) ) {
                alt34=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // EolParserRules.g:376:23: normal= ':='
                    {
                    normal=(Token)match(input,128,FOLLOW_128_in_assignmentStatement1448); if (state.failed) return retval;
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
                    // EolParserRules.g:376:66: special= '::='
                    {
                    special=(Token)match(input,129,FOLLOW_129_in_assignmentStatement1455); if (state.failed) return retval;
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

            pushFollow(FOLLOW_logicalExpression_in_assignmentStatement1461);
            logicalExpression100=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression100.getTree());
            sem=(Token)match(input,87,FOLLOW_87_in_assignmentStatement1465); if (state.failed) return retval;

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
    // EolParserRules.g:380:1: expressionStatement : ( postfixExpression op= '=' logicalExpression | logicalExpression ) sem= ';' ;
    public final Egx_EolParserRules.expressionStatement_return expressionStatement() throws RecognitionException {
        Egx_EolParserRules.expressionStatement_return retval = new Egx_EolParserRules.expressionStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token op=null;
        Token sem=null;
        Egx_EolParserRules.postfixExpression_return postfixExpression101 = null;

        Egx_EolParserRules.logicalExpression_return logicalExpression102 = null;

        Egx_EolParserRules.logicalExpression_return logicalExpression103 = null;


        org.eclipse.epsilon.common.parse.AST op_tree=null;
        org.eclipse.epsilon.common.parse.AST sem_tree=null;

        try {
            // EolParserRules.g:384:2: ( ( postfixExpression op= '=' logicalExpression | logicalExpression ) sem= ';' )
            // EolParserRules.g:384:4: ( postfixExpression op= '=' logicalExpression | logicalExpression ) sem= ';'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            // EolParserRules.g:384:4: ( postfixExpression op= '=' logicalExpression | logicalExpression )
            int alt35=2;
            alt35 = dfa35.predict(input);
            switch (alt35) {
                case 1 :
                    // EolParserRules.g:384:5: postfixExpression op= '=' logicalExpression
                    {
                    pushFollow(FOLLOW_postfixExpression_in_expressionStatement1487);
                    postfixExpression101=postfixExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, postfixExpression101.getTree());
                    op=(Token)match(input,93,FOLLOW_93_in_expressionStatement1491); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
                    }
                    pushFollow(FOLLOW_logicalExpression_in_expressionStatement1494);
                    logicalExpression102=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression102.getTree());
                    if ( state.backtracking==0 ) {
                      op.setType(OPERATOR);
                    }

                    }
                    break;
                case 2 :
                    // EolParserRules.g:384:76: logicalExpression
                    {
                    pushFollow(FOLLOW_logicalExpression_in_expressionStatement1500);
                    logicalExpression103=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression103.getTree());

                    }
                    break;

            }

            sem=(Token)match(input,87,FOLLOW_87_in_expressionStatement1505); if (state.failed) return retval;

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
    // EolParserRules.g:387:1: logicalExpression : relationalExpression ( (op= 'or' | op= 'and' | op= 'xor' | op= 'implies' ) relationalExpression )* ;
    public final Egx_EolParserRules.logicalExpression_return logicalExpression() throws RecognitionException {
        Egx_EolParserRules.logicalExpression_return retval = new Egx_EolParserRules.logicalExpression_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token op=null;
        Egx_EolParserRules.relationalExpression_return relationalExpression104 = null;

        Egx_EolParserRules.relationalExpression_return relationalExpression105 = null;


        org.eclipse.epsilon.common.parse.AST op_tree=null;

        try {
            // EolParserRules.g:388:2: ( relationalExpression ( (op= 'or' | op= 'and' | op= 'xor' | op= 'implies' ) relationalExpression )* )
            // EolParserRules.g:388:4: relationalExpression ( (op= 'or' | op= 'and' | op= 'xor' | op= 'implies' ) relationalExpression )*
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            pushFollow(FOLLOW_relationalExpression_in_logicalExpression1517);
            relationalExpression104=relationalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, relationalExpression104.getTree());
            // EolParserRules.g:388:25: ( (op= 'or' | op= 'and' | op= 'xor' | op= 'implies' ) relationalExpression )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( ((LA37_0>=130 && LA37_0<=133)) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // EolParserRules.g:388:26: (op= 'or' | op= 'and' | op= 'xor' | op= 'implies' ) relationalExpression
            	    {
            	    // EolParserRules.g:388:26: (op= 'or' | op= 'and' | op= 'xor' | op= 'implies' )
            	    int alt36=4;
            	    switch ( input.LA(1) ) {
            	    case 130:
            	        {
            	        alt36=1;
            	        }
            	        break;
            	    case 131:
            	        {
            	        alt36=2;
            	        }
            	        break;
            	    case 132:
            	        {
            	        alt36=3;
            	        }
            	        break;
            	    case 133:
            	        {
            	        alt36=4;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 36, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt36) {
            	        case 1 :
            	            // EolParserRules.g:388:27: op= 'or'
            	            {
            	            op=(Token)match(input,130,FOLLOW_130_in_logicalExpression1523); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // EolParserRules.g:388:36: op= 'and'
            	            {
            	            op=(Token)match(input,131,FOLLOW_131_in_logicalExpression1528); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // EolParserRules.g:388:46: op= 'xor'
            	            {
            	            op=(Token)match(input,132,FOLLOW_132_in_logicalExpression1533); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 4 :
            	            // EolParserRules.g:388:56: op= 'implies'
            	            {
            	            op=(Token)match(input,133,FOLLOW_133_in_logicalExpression1538); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_relationalExpression_in_logicalExpression1542);
            	    relationalExpression105=relationalExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, relationalExpression105.getTree());
            	    if ( state.backtracking==0 ) {
            	      op.setType(OPERATOR);
            	    }

            	    }
            	    break;

            	default :
            	    break loop37;
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
    // EolParserRules.g:392:1: relationalExpression : additiveExpression ( (op= '==' relationalExpression | op= '=' relationalExpression | (op= '>' | op= '<' | op= '>=' | op= '<=' | op= '<>' ) additiveExpression ) )* ;
    public final Egx_EolParserRules.relationalExpression_return relationalExpression() throws RecognitionException {
        Egx_EolParserRules.relationalExpression_return retval = new Egx_EolParserRules.relationalExpression_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token op=null;
        Egx_EolParserRules.additiveExpression_return additiveExpression106 = null;

        Egx_EolParserRules.relationalExpression_return relationalExpression107 = null;

        Egx_EolParserRules.relationalExpression_return relationalExpression108 = null;

        Egx_EolParserRules.additiveExpression_return additiveExpression109 = null;


        org.eclipse.epsilon.common.parse.AST op_tree=null;

        try {
            // EolParserRules.g:393:2: ( additiveExpression ( (op= '==' relationalExpression | op= '=' relationalExpression | (op= '>' | op= '<' | op= '>=' | op= '<=' | op= '<>' ) additiveExpression ) )* )
            // EolParserRules.g:393:4: additiveExpression ( (op= '==' relationalExpression | op= '=' relationalExpression | (op= '>' | op= '<' | op= '>=' | op= '<=' | op= '<>' ) additiveExpression ) )*
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            pushFollow(FOLLOW_additiveExpression_in_relationalExpression1559);
            additiveExpression106=additiveExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, additiveExpression106.getTree());
            // EolParserRules.g:393:23: ( (op= '==' relationalExpression | op= '=' relationalExpression | (op= '>' | op= '<' | op= '>=' | op= '<=' | op= '<>' ) additiveExpression ) )*
            loop40:
            do {
                int alt40=2;
                alt40 = dfa40.predict(input);
                switch (alt40) {
            	case 1 :
            	    // EolParserRules.g:393:24: (op= '==' relationalExpression | op= '=' relationalExpression | (op= '>' | op= '<' | op= '>=' | op= '<=' | op= '<>' ) additiveExpression )
            	    {
            	    // EolParserRules.g:393:24: (op= '==' relationalExpression | op= '=' relationalExpression | (op= '>' | op= '<' | op= '>=' | op= '<=' | op= '<>' ) additiveExpression )
            	    int alt39=3;
            	    switch ( input.LA(1) ) {
            	    case 134:
            	        {
            	        alt39=1;
            	        }
            	        break;
            	    case 93:
            	        {
            	        alt39=2;
            	        }
            	        break;
            	    case 135:
            	    case 136:
            	    case 137:
            	    case 138:
            	    case 139:
            	        {
            	        alt39=3;
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
            	            // EolParserRules.g:393:25: op= '==' relationalExpression
            	            {
            	            op=(Token)match(input,134,FOLLOW_134_in_relationalExpression1565); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	            }
            	            pushFollow(FOLLOW_relationalExpression_in_relationalExpression1568);
            	            relationalExpression107=relationalExpression();

            	            state._fsp--;
            	            if (state.failed) return retval;
            	            if ( state.backtracking==0 ) adaptor.addChild(root_0, relationalExpression107.getTree());

            	            }
            	            break;
            	        case 2 :
            	            // EolParserRules.g:393:57: op= '=' relationalExpression
            	            {
            	            op=(Token)match(input,93,FOLLOW_93_in_relationalExpression1574); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	            }
            	            pushFollow(FOLLOW_relationalExpression_in_relationalExpression1577);
            	            relationalExpression108=relationalExpression();

            	            state._fsp--;
            	            if (state.failed) return retval;
            	            if ( state.backtracking==0 ) adaptor.addChild(root_0, relationalExpression108.getTree());

            	            }
            	            break;
            	        case 3 :
            	            // EolParserRules.g:394:24: (op= '>' | op= '<' | op= '>=' | op= '<=' | op= '<>' ) additiveExpression
            	            {
            	            // EolParserRules.g:394:24: (op= '>' | op= '<' | op= '>=' | op= '<=' | op= '<>' )
            	            int alt38=5;
            	            switch ( input.LA(1) ) {
            	            case 135:
            	                {
            	                alt38=1;
            	                }
            	                break;
            	            case 136:
            	                {
            	                alt38=2;
            	                }
            	                break;
            	            case 137:
            	                {
            	                alt38=3;
            	                }
            	                break;
            	            case 138:
            	                {
            	                alt38=4;
            	                }
            	                break;
            	            case 139:
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
            	                    // EolParserRules.g:394:25: op= '>'
            	                    {
            	                    op=(Token)match(input,135,FOLLOW_135_in_relationalExpression1607); if (state.failed) return retval;
            	                    if ( state.backtracking==0 ) {
            	                    op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	                    }

            	                    }
            	                    break;
            	                case 2 :
            	                    // EolParserRules.g:394:33: op= '<'
            	                    {
            	                    op=(Token)match(input,136,FOLLOW_136_in_relationalExpression1612); if (state.failed) return retval;
            	                    if ( state.backtracking==0 ) {
            	                    op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	                    }

            	                    }
            	                    break;
            	                case 3 :
            	                    // EolParserRules.g:394:41: op= '>='
            	                    {
            	                    op=(Token)match(input,137,FOLLOW_137_in_relationalExpression1617); if (state.failed) return retval;
            	                    if ( state.backtracking==0 ) {
            	                    op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	                    }

            	                    }
            	                    break;
            	                case 4 :
            	                    // EolParserRules.g:394:50: op= '<='
            	                    {
            	                    op=(Token)match(input,138,FOLLOW_138_in_relationalExpression1622); if (state.failed) return retval;
            	                    if ( state.backtracking==0 ) {
            	                    op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	                    }

            	                    }
            	                    break;
            	                case 5 :
            	                    // EolParserRules.g:394:59: op= '<>'
            	                    {
            	                    op=(Token)match(input,139,FOLLOW_139_in_relationalExpression1627); if (state.failed) return retval;
            	                    if ( state.backtracking==0 ) {
            	                    op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	                    }

            	                    }
            	                    break;

            	            }

            	            pushFollow(FOLLOW_additiveExpression_in_relationalExpression1631);
            	            additiveExpression109=additiveExpression();

            	            state._fsp--;
            	            if (state.failed) return retval;
            	            if ( state.backtracking==0 ) adaptor.addChild(root_0, additiveExpression109.getTree());

            	            }
            	            break;

            	    }

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
    // $ANTLR end relationalExpression

    public static class additiveExpression_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start additiveExpression
    // EolParserRules.g:398:1: additiveExpression : multiplicativeExpression ( (op= '+' | op= '-' ) multiplicativeExpression )* ;
    public final Egx_EolParserRules.additiveExpression_return additiveExpression() throws RecognitionException {
        Egx_EolParserRules.additiveExpression_return retval = new Egx_EolParserRules.additiveExpression_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token op=null;
        Egx_EolParserRules.multiplicativeExpression_return multiplicativeExpression110 = null;

        Egx_EolParserRules.multiplicativeExpression_return multiplicativeExpression111 = null;


        org.eclipse.epsilon.common.parse.AST op_tree=null;

        try {
            // EolParserRules.g:399:2: ( multiplicativeExpression ( (op= '+' | op= '-' ) multiplicativeExpression )* )
            // EolParserRules.g:399:4: multiplicativeExpression ( (op= '+' | op= '-' ) multiplicativeExpression )*
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            pushFollow(FOLLOW_multiplicativeExpression_in_additiveExpression1649);
            multiplicativeExpression110=multiplicativeExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, multiplicativeExpression110.getTree());
            // EolParserRules.g:399:29: ( (op= '+' | op= '-' ) multiplicativeExpression )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( ((LA42_0>=140 && LA42_0<=141)) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // EolParserRules.g:399:30: (op= '+' | op= '-' ) multiplicativeExpression
            	    {
            	    // EolParserRules.g:399:30: (op= '+' | op= '-' )
            	    int alt41=2;
            	    int LA41_0 = input.LA(1);

            	    if ( (LA41_0==140) ) {
            	        alt41=1;
            	    }
            	    else if ( (LA41_0==141) ) {
            	        alt41=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 41, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt41) {
            	        case 1 :
            	            // EolParserRules.g:399:31: op= '+'
            	            {
            	            op=(Token)match(input,140,FOLLOW_140_in_additiveExpression1655); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // EolParserRules.g:399:39: op= '-'
            	            {
            	            op=(Token)match(input,141,FOLLOW_141_in_additiveExpression1660); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_multiplicativeExpression_in_additiveExpression1664);
            	    multiplicativeExpression111=multiplicativeExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, multiplicativeExpression111.getTree());
            	    if ( state.backtracking==0 ) {
            	      op.setType(OPERATOR);
            	    }

            	    }
            	    break;

            	default :
            	    break loop42;
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
    // EolParserRules.g:403:1: multiplicativeExpression : unaryExpression ( (op= '*' | op= '/' ) unaryExpression )* ;
    public final Egx_EolParserRules.multiplicativeExpression_return multiplicativeExpression() throws RecognitionException {
        Egx_EolParserRules.multiplicativeExpression_return retval = new Egx_EolParserRules.multiplicativeExpression_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token op=null;
        Egx_EolParserRules.unaryExpression_return unaryExpression112 = null;

        Egx_EolParserRules.unaryExpression_return unaryExpression113 = null;


        org.eclipse.epsilon.common.parse.AST op_tree=null;

        try {
            // EolParserRules.g:404:2: ( unaryExpression ( (op= '*' | op= '/' ) unaryExpression )* )
            // EolParserRules.g:404:4: unaryExpression ( (op= '*' | op= '/' ) unaryExpression )*
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            pushFollow(FOLLOW_unaryExpression_in_multiplicativeExpression1682);
            unaryExpression112=unaryExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, unaryExpression112.getTree());
            // EolParserRules.g:404:20: ( (op= '*' | op= '/' ) unaryExpression )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( ((LA44_0>=142 && LA44_0<=143)) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // EolParserRules.g:404:21: (op= '*' | op= '/' ) unaryExpression
            	    {
            	    // EolParserRules.g:404:21: (op= '*' | op= '/' )
            	    int alt43=2;
            	    int LA43_0 = input.LA(1);

            	    if ( (LA43_0==142) ) {
            	        alt43=1;
            	    }
            	    else if ( (LA43_0==143) ) {
            	        alt43=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 43, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt43) {
            	        case 1 :
            	            // EolParserRules.g:404:22: op= '*'
            	            {
            	            op=(Token)match(input,142,FOLLOW_142_in_multiplicativeExpression1688); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // EolParserRules.g:404:30: op= '/'
            	            {
            	            op=(Token)match(input,143,FOLLOW_143_in_multiplicativeExpression1693); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_unaryExpression_in_multiplicativeExpression1697);
            	    unaryExpression113=unaryExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, unaryExpression113.getTree());
            	    if ( state.backtracking==0 ) {
            	      op.setType(OPERATOR);
            	    }

            	    }
            	    break;

            	default :
            	    break loop44;
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
    // EolParserRules.g:408:1: unaryExpression : ( (op= 'not' | op= '-' ) )? postfixExpression ;
    public final Egx_EolParserRules.unaryExpression_return unaryExpression() throws RecognitionException {
        Egx_EolParserRules.unaryExpression_return retval = new Egx_EolParserRules.unaryExpression_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token op=null;
        Egx_EolParserRules.postfixExpression_return postfixExpression114 = null;


        org.eclipse.epsilon.common.parse.AST op_tree=null;

        try {
            // EolParserRules.g:409:2: ( ( (op= 'not' | op= '-' ) )? postfixExpression )
            // EolParserRules.g:409:4: ( (op= 'not' | op= '-' ) )? postfixExpression
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            // EolParserRules.g:409:4: ( (op= 'not' | op= '-' ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==141||LA46_0==144) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // EolParserRules.g:409:5: (op= 'not' | op= '-' )
                    {
                    // EolParserRules.g:409:5: (op= 'not' | op= '-' )
                    int alt45=2;
                    int LA45_0 = input.LA(1);

                    if ( (LA45_0==144) ) {
                        alt45=1;
                    }
                    else if ( (LA45_0==141) ) {
                        alt45=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 45, 0, input);

                        throw nvae;
                    }
                    switch (alt45) {
                        case 1 :
                            // EolParserRules.g:409:6: op= 'not'
                            {
                            op=(Token)match(input,144,FOLLOW_144_in_unaryExpression1718); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
                            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
                            }

                            }
                            break;
                        case 2 :
                            // EolParserRules.g:409:16: op= '-'
                            {
                            op=(Token)match(input,141,FOLLOW_141_in_unaryExpression1723); if (state.failed) return retval;
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

            pushFollow(FOLLOW_postfixExpression_in_unaryExpression1731);
            postfixExpression114=postfixExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, postfixExpression114.getTree());

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
    // EolParserRules.g:412:1: postfixExpression : itemSelectorExpression ( ( POINT | ARROW ) fc= featureCall (is= '[' logicalExpression ']' )* )* ;
    public final Egx_EolParserRules.postfixExpression_return postfixExpression() throws RecognitionException {
        Egx_EolParserRules.postfixExpression_return retval = new Egx_EolParserRules.postfixExpression_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token is=null;
        Token set116=null;
        Token char_literal118=null;
        Egx_EolParserRules.featureCall_return fc = null;

        Egx_EolParserRules.itemSelectorExpression_return itemSelectorExpression115 = null;

        Egx_EolParserRules.logicalExpression_return logicalExpression117 = null;


        org.eclipse.epsilon.common.parse.AST is_tree=null;
        org.eclipse.epsilon.common.parse.AST set116_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal118_tree=null;

        try {
            // EolParserRules.g:413:2: ( itemSelectorExpression ( ( POINT | ARROW ) fc= featureCall (is= '[' logicalExpression ']' )* )* )
            // EolParserRules.g:413:4: itemSelectorExpression ( ( POINT | ARROW ) fc= featureCall (is= '[' logicalExpression ']' )* )*
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            pushFollow(FOLLOW_itemSelectorExpression_in_postfixExpression1743);
            itemSelectorExpression115=itemSelectorExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, itemSelectorExpression115.getTree());
            // EolParserRules.g:413:27: ( ( POINT | ARROW ) fc= featureCall (is= '[' logicalExpression ']' )* )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==POINT||LA48_0==ARROW) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // EolParserRules.g:413:28: ( POINT | ARROW ) fc= featureCall (is= '[' logicalExpression ']' )*
            	    {
            	    set116=(Token)input.LT(1);
            	    set116=(Token)input.LT(1);
            	    if ( input.LA(1)==POINT||input.LA(1)==ARROW ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot((org.eclipse.epsilon.common.parse.AST)adaptor.create(set116), root_0);
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_featureCall_in_postfixExpression1755);
            	    fc=featureCall();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, fc.getTree());
            	    if ( state.backtracking==0 ) {
            	      setTokenType(fc,FEATURECALL);
            	    }
            	    // EolParserRules.g:414:35: (is= '[' logicalExpression ']' )*
            	    loop47:
            	    do {
            	        int alt47=2;
            	        int LA47_0 = input.LA(1);

            	        if ( (LA47_0==145) ) {
            	            alt47=1;
            	        }


            	        switch (alt47) {
            	    	case 1 :
            	    	    // EolParserRules.g:414:36: is= '[' logicalExpression ']'
            	    	    {
            	    	    is=(Token)match(input,145,FOLLOW_145_in_postfixExpression1764); if (state.failed) return retval;
            	    	    if ( state.backtracking==0 ) {
            	    	    is_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(is);
            	    	    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(is_tree, root_0);
            	    	    }
            	    	    pushFollow(FOLLOW_logicalExpression_in_postfixExpression1767);
            	    	    logicalExpression117=logicalExpression();

            	    	    state._fsp--;
            	    	    if (state.failed) return retval;
            	    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression117.getTree());
            	    	    char_literal118=(Token)match(input,146,FOLLOW_146_in_postfixExpression1769); if (state.failed) return retval;
            	    	    if ( state.backtracking==0 ) {
            	    	      is.setType(ITEMSELECTOR);
            	    	    }

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop47;
            	        }
            	    } while (true);


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
    // $ANTLR end postfixExpression

    public static class itemSelectorExpression_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start itemSelectorExpression
    // EolParserRules.g:418:1: itemSelectorExpression : primitiveExpression (is= '[' primitiveExpression ']' )* ;
    public final Egx_EolParserRules.itemSelectorExpression_return itemSelectorExpression() throws RecognitionException {
        Egx_EolParserRules.itemSelectorExpression_return retval = new Egx_EolParserRules.itemSelectorExpression_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token is=null;
        Token char_literal121=null;
        Egx_EolParserRules.primitiveExpression_return primitiveExpression119 = null;

        Egx_EolParserRules.primitiveExpression_return primitiveExpression120 = null;


        org.eclipse.epsilon.common.parse.AST is_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal121_tree=null;

        try {
            // EolParserRules.g:419:2: ( primitiveExpression (is= '[' primitiveExpression ']' )* )
            // EolParserRules.g:419:4: primitiveExpression (is= '[' primitiveExpression ']' )*
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            pushFollow(FOLLOW_primitiveExpression_in_itemSelectorExpression1791);
            primitiveExpression119=primitiveExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, primitiveExpression119.getTree());
            // EolParserRules.g:419:24: (is= '[' primitiveExpression ']' )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==145) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // EolParserRules.g:419:25: is= '[' primitiveExpression ']'
            	    {
            	    is=(Token)match(input,145,FOLLOW_145_in_itemSelectorExpression1796); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    is_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(is);
            	    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(is_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_primitiveExpression_in_itemSelectorExpression1799);
            	    primitiveExpression120=primitiveExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, primitiveExpression120.getTree());
            	    char_literal121=(Token)match(input,146,FOLLOW_146_in_itemSelectorExpression1801); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	      is.setType(ITEMSELECTOR);
            	    }

            	    }
            	    break;

            	default :
            	    break loop49;
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
    // EolParserRules.g:423:1: featureCall : ( simpleFeatureCall | declarativeFeatureCall );
    public final Egx_EolParserRules.featureCall_return featureCall() throws RecognitionException {
        Egx_EolParserRules.featureCall_return retval = new Egx_EolParserRules.featureCall_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Egx_EolParserRules.simpleFeatureCall_return simpleFeatureCall122 = null;

        Egx_EolParserRules.declarativeFeatureCall_return declarativeFeatureCall123 = null;



        try {
            // EolParserRules.g:424:2: ( simpleFeatureCall | declarativeFeatureCall )
            int alt50=2;
            alt50 = dfa50.predict(input);
            switch (alt50) {
                case 1 :
                    // EolParserRules.g:424:4: simpleFeatureCall
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_simpleFeatureCall_in_featureCall1820);
                    simpleFeatureCall122=simpleFeatureCall();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, simpleFeatureCall122.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:424:24: declarativeFeatureCall
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_declarativeFeatureCall_in_featureCall1824);
                    declarativeFeatureCall123=declarativeFeatureCall();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, declarativeFeatureCall123.getTree());

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
    // EolParserRules.g:427:1: simpleFeatureCall : n= NAME ( parameterList )? ;
    public final Egx_EolParserRules.simpleFeatureCall_return simpleFeatureCall() throws RecognitionException {
        Egx_EolParserRules.simpleFeatureCall_return retval = new Egx_EolParserRules.simpleFeatureCall_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token n=null;
        Egx_EolParserRules.parameterList_return parameterList124 = null;


        org.eclipse.epsilon.common.parse.AST n_tree=null;

        try {
            // EolParserRules.g:428:2: (n= NAME ( parameterList )? )
            // EolParserRules.g:428:5: n= NAME ( parameterList )?
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            n=(Token)match(input,NAME,FOLLOW_NAME_in_simpleFeatureCall1838); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            n_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(n);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(n_tree, root_0);
            }
            // EolParserRules.g:428:13: ( parameterList )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==96) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // EolParserRules.g:0:0: parameterList
                    {
                    pushFollow(FOLLOW_parameterList_in_simpleFeatureCall1841);
                    parameterList124=parameterList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, parameterList124.getTree());

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
    // EolParserRules.g:432:1: parameterList : op= '(' ( logicalExpression ( ',' logicalExpression )* )? cp= ')' -> ^( PARAMETERS ( logicalExpression )* ) ;
    public final Egx_EolParserRules.parameterList_return parameterList() throws RecognitionException {
        Egx_EolParserRules.parameterList_return retval = new Egx_EolParserRules.parameterList_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token op=null;
        Token cp=null;
        Token char_literal126=null;
        Egx_EolParserRules.logicalExpression_return logicalExpression125 = null;

        Egx_EolParserRules.logicalExpression_return logicalExpression127 = null;


        org.eclipse.epsilon.common.parse.AST op_tree=null;
        org.eclipse.epsilon.common.parse.AST cp_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal126_tree=null;
        RewriteRuleTokenStream stream_97=new RewriteRuleTokenStream(adaptor,"token 97");
        RewriteRuleTokenStream stream_96=new RewriteRuleTokenStream(adaptor,"token 96");
        RewriteRuleTokenStream stream_89=new RewriteRuleTokenStream(adaptor,"token 89");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:438:2: (op= '(' ( logicalExpression ( ',' logicalExpression )* )? cp= ')' -> ^( PARAMETERS ( logicalExpression )* ) )
            // EolParserRules.g:438:4: op= '(' ( logicalExpression ( ',' logicalExpression )* )? cp= ')'
            {
            op=(Token)match(input,96,FOLLOW_96_in_parameterList1864); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_96.add(op);

            // EolParserRules.g:438:11: ( logicalExpression ( ',' logicalExpression )* )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==FLOAT||LA53_0==INT||LA53_0==BOOLEAN||LA53_0==STRING||LA53_0==NAME||LA53_0==96||(LA53_0>=104 && LA53_0<=111)||LA53_0==141||LA53_0==144||(LA53_0>=148 && LA53_0<=149)) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // EolParserRules.g:438:12: logicalExpression ( ',' logicalExpression )*
                    {
                    pushFollow(FOLLOW_logicalExpression_in_parameterList1867);
                    logicalExpression125=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression125.getTree());
                    // EolParserRules.g:438:30: ( ',' logicalExpression )*
                    loop52:
                    do {
                        int alt52=2;
                        int LA52_0 = input.LA(1);

                        if ( (LA52_0==89) ) {
                            alt52=1;
                        }


                        switch (alt52) {
                    	case 1 :
                    	    // EolParserRules.g:438:31: ',' logicalExpression
                    	    {
                    	    char_literal126=(Token)match(input,89,FOLLOW_89_in_parameterList1870); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_89.add(char_literal126);

                    	    pushFollow(FOLLOW_logicalExpression_in_parameterList1872);
                    	    logicalExpression127=logicalExpression();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression127.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop52;
                        }
                    } while (true);


                    }
                    break;

            }

            cp=(Token)match(input,97,FOLLOW_97_in_parameterList1880); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_97.add(cp);



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
            // 439:3: -> ^( PARAMETERS ( logicalExpression )* )
            {
                // EolParserRules.g:439:6: ^( PARAMETERS ( logicalExpression )* )
                {
                org.eclipse.epsilon.common.parse.AST root_1 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();
                root_1 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot((org.eclipse.epsilon.common.parse.AST)adaptor.create(PARAMETERS, "PARAMETERS"), root_1);

                // EolParserRules.g:439:19: ( logicalExpression )*
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
    // EolParserRules.g:442:1: declarativeFeatureCall : NAME op= '(' formalParameterList '|' logicalExpression ( ',' logicalExpression )* cp= ')' ;
    public final Egx_EolParserRules.declarativeFeatureCall_return declarativeFeatureCall() throws RecognitionException {
        Egx_EolParserRules.declarativeFeatureCall_return retval = new Egx_EolParserRules.declarativeFeatureCall_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token op=null;
        Token cp=null;
        Token NAME128=null;
        Token char_literal130=null;
        Token char_literal132=null;
        Egx_EolParserRules.formalParameterList_return formalParameterList129 = null;

        Egx_EolParserRules.logicalExpression_return logicalExpression131 = null;

        Egx_EolParserRules.logicalExpression_return logicalExpression133 = null;


        org.eclipse.epsilon.common.parse.AST op_tree=null;
        org.eclipse.epsilon.common.parse.AST cp_tree=null;
        org.eclipse.epsilon.common.parse.AST NAME128_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal130_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal132_tree=null;

        try {
            // EolParserRules.g:447:2: ( NAME op= '(' formalParameterList '|' logicalExpression ( ',' logicalExpression )* cp= ')' )
            // EolParserRules.g:447:4: NAME op= '(' formalParameterList '|' logicalExpression ( ',' logicalExpression )* cp= ')'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            NAME128=(Token)match(input,NAME,FOLLOW_NAME_in_declarativeFeatureCall1908); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME128_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(NAME128);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(NAME128_tree, root_0);
            }
            op=(Token)match(input,96,FOLLOW_96_in_declarativeFeatureCall1913); if (state.failed) return retval;
            pushFollow(FOLLOW_formalParameterList_in_declarativeFeatureCall1916);
            formalParameterList129=formalParameterList();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, formalParameterList129.getTree());
            char_literal130=(Token)match(input,147,FOLLOW_147_in_declarativeFeatureCall1918); if (state.failed) return retval;
            pushFollow(FOLLOW_logicalExpression_in_declarativeFeatureCall1921);
            logicalExpression131=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression131.getTree());
            // EolParserRules.g:447:61: ( ',' logicalExpression )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==89) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // EolParserRules.g:447:62: ',' logicalExpression
            	    {
            	    char_literal132=(Token)match(input,89,FOLLOW_89_in_declarativeFeatureCall1924); if (state.failed) return retval;
            	    pushFollow(FOLLOW_logicalExpression_in_declarativeFeatureCall1927);
            	    logicalExpression133=logicalExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression133.getTree());

            	    }
            	    break;

            	default :
            	    break loop54;
                }
            } while (true);

            cp=(Token)match(input,97,FOLLOW_97_in_declarativeFeatureCall1933); if (state.failed) return retval;

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
    // EolParserRules.g:450:1: newExpression : n= 'new' tn= typeName ( parameterList )? ;
    public final Egx_EolParserRules.newExpression_return newExpression() throws RecognitionException {
        Egx_EolParserRules.newExpression_return retval = new Egx_EolParserRules.newExpression_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token n=null;
        Egx_EolParserRules.typeName_return tn = null;

        Egx_EolParserRules.parameterList_return parameterList134 = null;


        org.eclipse.epsilon.common.parse.AST n_tree=null;

        try {
            // EolParserRules.g:451:2: (n= 'new' tn= typeName ( parameterList )? )
            // EolParserRules.g:451:4: n= 'new' tn= typeName ( parameterList )?
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            n=(Token)match(input,148,FOLLOW_148_in_newExpression1947); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            n_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(n);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(n_tree, root_0);
            }
            pushFollow(FOLLOW_typeName_in_newExpression1952);
            tn=typeName();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, tn.getTree());
            if ( state.backtracking==0 ) {
              setTokenType(tn,TYPE);
            }
            // EolParserRules.g:451:50: ( parameterList )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==96) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // EolParserRules.g:0:0: parameterList
                    {
                    pushFollow(FOLLOW_parameterList_in_newExpression1956);
                    parameterList134=parameterList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, parameterList134.getTree());

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
    // EolParserRules.g:455:1: variableDeclarationExpression : v= 'var' NAME ( ':' (n= 'new' )? t= typeName ( parameterList )? )? ;
    public final Egx_EolParserRules.variableDeclarationExpression_return variableDeclarationExpression() throws RecognitionException {
        Egx_EolParserRules.variableDeclarationExpression_return retval = new Egx_EolParserRules.variableDeclarationExpression_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token v=null;
        Token n=null;
        Token NAME135=null;
        Token char_literal136=null;
        Egx_EolParserRules.typeName_return t = null;

        Egx_EolParserRules.parameterList_return parameterList137 = null;


        org.eclipse.epsilon.common.parse.AST v_tree=null;
        org.eclipse.epsilon.common.parse.AST n_tree=null;
        org.eclipse.epsilon.common.parse.AST NAME135_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal136_tree=null;

        try {
            // EolParserRules.g:463:2: (v= 'var' NAME ( ':' (n= 'new' )? t= typeName ( parameterList )? )? )
            // EolParserRules.g:463:4: v= 'var' NAME ( ':' (n= 'new' )? t= typeName ( parameterList )? )?
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            v=(Token)match(input,149,FOLLOW_149_in_variableDeclarationExpression1978); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            v_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(v);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(v_tree, root_0);
            }
            NAME135=(Token)match(input,NAME,FOLLOW_NAME_in_variableDeclarationExpression1981); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME135_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(NAME135);
            adaptor.addChild(root_0, NAME135_tree);
            }
            // EolParserRules.g:463:18: ( ':' (n= 'new' )? t= typeName ( parameterList )? )?
            int alt58=2;
            alt58 = dfa58.predict(input);
            switch (alt58) {
                case 1 :
                    // EolParserRules.g:463:19: ':' (n= 'new' )? t= typeName ( parameterList )?
                    {
                    char_literal136=(Token)match(input,98,FOLLOW_98_in_variableDeclarationExpression1984); if (state.failed) return retval;
                    // EolParserRules.g:463:25: (n= 'new' )?
                    int alt56=2;
                    int LA56_0 = input.LA(1);

                    if ( (LA56_0==148) ) {
                        alt56=1;
                    }
                    switch (alt56) {
                        case 1 :
                            // EolParserRules.g:0:0: n= 'new'
                            {
                            n=(Token)match(input,148,FOLLOW_148_in_variableDeclarationExpression1989); if (state.failed) return retval;

                            }
                            break;

                    }

                    pushFollow(FOLLOW_typeName_in_variableDeclarationExpression1995);
                    t=typeName();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, t.getTree());
                    if ( state.backtracking==0 ) {
                      setTokenType(t, TYPE);
                    }
                    // EolParserRules.g:463:70: ( parameterList )?
                    int alt57=2;
                    int LA57_0 = input.LA(1);

                    if ( (LA57_0==96) ) {
                        alt57=1;
                    }
                    switch (alt57) {
                        case 1 :
                            // EolParserRules.g:0:0: parameterList
                            {
                            pushFollow(FOLLOW_parameterList_in_variableDeclarationExpression1999);
                            parameterList137=parameterList();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, parameterList137.getTree());

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
              		else { txt = "var";}
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
    // EolParserRules.g:466:1: literalSequentialCollection : (l= 'Collection' | l= 'Sequence' | l= 'List' | l= 'Bag' | l= 'Set' | l= 'OrderedSet' ) ob= '{' ( expressionListOrRange )? cb= '}' ;
    public final Egx_EolParserRules.literalSequentialCollection_return literalSequentialCollection() throws RecognitionException {
        Egx_EolParserRules.literalSequentialCollection_return retval = new Egx_EolParserRules.literalSequentialCollection_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token l=null;
        Token ob=null;
        Token cb=null;
        Egx_EolParserRules.expressionListOrRange_return expressionListOrRange138 = null;


        org.eclipse.epsilon.common.parse.AST l_tree=null;
        org.eclipse.epsilon.common.parse.AST ob_tree=null;
        org.eclipse.epsilon.common.parse.AST cb_tree=null;

        try {
            // EolParserRules.g:471:2: ( (l= 'Collection' | l= 'Sequence' | l= 'List' | l= 'Bag' | l= 'Set' | l= 'OrderedSet' ) ob= '{' ( expressionListOrRange )? cb= '}' )
            // EolParserRules.g:471:4: (l= 'Collection' | l= 'Sequence' | l= 'List' | l= 'Bag' | l= 'Set' | l= 'OrderedSet' ) ob= '{' ( expressionListOrRange )? cb= '}'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            // EolParserRules.g:471:4: (l= 'Collection' | l= 'Sequence' | l= 'List' | l= 'Bag' | l= 'Set' | l= 'OrderedSet' )
            int alt59=6;
            switch ( input.LA(1) ) {
            case 105:
                {
                alt59=1;
                }
                break;
            case 106:
                {
                alt59=2;
                }
                break;
            case 107:
                {
                alt59=3;
                }
                break;
            case 108:
                {
                alt59=4;
                }
                break;
            case 109:
                {
                alt59=5;
                }
                break;
            case 110:
                {
                alt59=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;
            }

            switch (alt59) {
                case 1 :
                    // EolParserRules.g:471:5: l= 'Collection'
                    {
                    l=(Token)match(input,105,FOLLOW_105_in_literalSequentialCollection2023); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    l_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(l);
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(l_tree, root_0);
                    }

                    }
                    break;
                case 2 :
                    // EolParserRules.g:471:21: l= 'Sequence'
                    {
                    l=(Token)match(input,106,FOLLOW_106_in_literalSequentialCollection2028); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    l_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(l);
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(l_tree, root_0);
                    }

                    }
                    break;
                case 3 :
                    // EolParserRules.g:471:35: l= 'List'
                    {
                    l=(Token)match(input,107,FOLLOW_107_in_literalSequentialCollection2033); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    l_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(l);
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(l_tree, root_0);
                    }

                    }
                    break;
                case 4 :
                    // EolParserRules.g:471:45: l= 'Bag'
                    {
                    l=(Token)match(input,108,FOLLOW_108_in_literalSequentialCollection2038); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    l_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(l);
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(l_tree, root_0);
                    }

                    }
                    break;
                case 5 :
                    // EolParserRules.g:471:54: l= 'Set'
                    {
                    l=(Token)match(input,109,FOLLOW_109_in_literalSequentialCollection2043); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    l_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(l);
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(l_tree, root_0);
                    }

                    }
                    break;
                case 6 :
                    // EolParserRules.g:471:63: l= 'OrderedSet'
                    {
                    l=(Token)match(input,110,FOLLOW_110_in_literalSequentialCollection2048); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    l_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(l);
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(l_tree, root_0);
                    }

                    }
                    break;

            }

            ob=(Token)match(input,91,FOLLOW_91_in_literalSequentialCollection2054); if (state.failed) return retval;
            // EolParserRules.g:471:89: ( expressionListOrRange )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==FLOAT||LA60_0==INT||LA60_0==BOOLEAN||LA60_0==STRING||LA60_0==NAME||LA60_0==96||(LA60_0>=104 && LA60_0<=111)||LA60_0==141||LA60_0==144||(LA60_0>=148 && LA60_0<=149)) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // EolParserRules.g:0:0: expressionListOrRange
                    {
                    pushFollow(FOLLOW_expressionListOrRange_in_literalSequentialCollection2058);
                    expressionListOrRange138=expressionListOrRange();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionListOrRange138.getTree());

                    }
                    break;

            }

            cb=(Token)match(input,92,FOLLOW_92_in_literalSequentialCollection2063); if (state.failed) return retval;
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
    // EolParserRules.g:475:1: expressionRange : logicalExpression exp= '..' logicalExpression ;
    public final Egx_EolParserRules.expressionRange_return expressionRange() throws RecognitionException {
        Egx_EolParserRules.expressionRange_return retval = new Egx_EolParserRules.expressionRange_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token exp=null;
        Egx_EolParserRules.logicalExpression_return logicalExpression139 = null;

        Egx_EolParserRules.logicalExpression_return logicalExpression140 = null;


        org.eclipse.epsilon.common.parse.AST exp_tree=null;

        try {
            // EolParserRules.g:476:2: ( logicalExpression exp= '..' logicalExpression )
            // EolParserRules.g:476:4: logicalExpression exp= '..' logicalExpression
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            pushFollow(FOLLOW_logicalExpression_in_expressionRange2078);
            logicalExpression139=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression139.getTree());
            exp=(Token)match(input,POINT_POINT,FOLLOW_POINT_POINT_in_expressionRange2082); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            exp_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(exp);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(exp_tree, root_0);
            }
            pushFollow(FOLLOW_logicalExpression_in_expressionRange2085);
            logicalExpression140=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression140.getTree());
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
    // EolParserRules.g:480:1: expressionList : logicalExpression ( ',' logicalExpression )* -> ^( EXPRLIST ( logicalExpression )+ ) ;
    public final Egx_EolParserRules.expressionList_return expressionList() throws RecognitionException {
        Egx_EolParserRules.expressionList_return retval = new Egx_EolParserRules.expressionList_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token char_literal142=null;
        Egx_EolParserRules.logicalExpression_return logicalExpression141 = null;

        Egx_EolParserRules.logicalExpression_return logicalExpression143 = null;


        org.eclipse.epsilon.common.parse.AST char_literal142_tree=null;
        RewriteRuleTokenStream stream_89=new RewriteRuleTokenStream(adaptor,"token 89");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:484:2: ( logicalExpression ( ',' logicalExpression )* -> ^( EXPRLIST ( logicalExpression )+ ) )
            // EolParserRules.g:484:4: logicalExpression ( ',' logicalExpression )*
            {
            pushFollow(FOLLOW_logicalExpression_in_expressionList2106);
            logicalExpression141=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression141.getTree());
            // EolParserRules.g:484:22: ( ',' logicalExpression )*
            loop61:
            do {
                int alt61=2;
                int LA61_0 = input.LA(1);

                if ( (LA61_0==89) ) {
                    alt61=1;
                }


                switch (alt61) {
            	case 1 :
            	    // EolParserRules.g:484:23: ',' logicalExpression
            	    {
            	    char_literal142=(Token)match(input,89,FOLLOW_89_in_expressionList2109); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_89.add(char_literal142);

            	    pushFollow(FOLLOW_logicalExpression_in_expressionList2111);
            	    logicalExpression143=logicalExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression143.getTree());

            	    }
            	    break;

            	default :
            	    break loop61;
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
            // 485:2: -> ^( EXPRLIST ( logicalExpression )+ )
            {
                // EolParserRules.g:485:5: ^( EXPRLIST ( logicalExpression )+ )
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
    // EolParserRules.g:488:1: expressionListOrRange : ( expressionRange | expressionList );
    public final Egx_EolParserRules.expressionListOrRange_return expressionListOrRange() throws RecognitionException {
        Egx_EolParserRules.expressionListOrRange_return retval = new Egx_EolParserRules.expressionListOrRange_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Egx_EolParserRules.expressionRange_return expressionRange144 = null;

        Egx_EolParserRules.expressionList_return expressionList145 = null;



        try {
            // EolParserRules.g:489:2: ( expressionRange | expressionList )
            int alt62=2;
            alt62 = dfa62.predict(input);
            switch (alt62) {
                case 1 :
                    // EolParserRules.g:489:4: expressionRange
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_expressionRange_in_expressionListOrRange2135);
                    expressionRange144=expressionRange();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionRange144.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:489:22: expressionList
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_expressionList_in_expressionListOrRange2139);
                    expressionList145=expressionList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionList145.getTree());

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
    // EolParserRules.g:492:1: literalMapCollection : m= 'Map' ob= '{' ( keyvalExpressionList )? cb= '}' ;
    public final Egx_EolParserRules.literalMapCollection_return literalMapCollection() throws RecognitionException {
        Egx_EolParserRules.literalMapCollection_return retval = new Egx_EolParserRules.literalMapCollection_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token m=null;
        Token ob=null;
        Token cb=null;
        Egx_EolParserRules.keyvalExpressionList_return keyvalExpressionList146 = null;


        org.eclipse.epsilon.common.parse.AST m_tree=null;
        org.eclipse.epsilon.common.parse.AST ob_tree=null;
        org.eclipse.epsilon.common.parse.AST cb_tree=null;

        try {
            // EolParserRules.g:497:2: (m= 'Map' ob= '{' ( keyvalExpressionList )? cb= '}' )
            // EolParserRules.g:497:4: m= 'Map' ob= '{' ( keyvalExpressionList )? cb= '}'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            m=(Token)match(input,111,FOLLOW_111_in_literalMapCollection2158); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            m_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(m);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(m_tree, root_0);
            }
            ob=(Token)match(input,91,FOLLOW_91_in_literalMapCollection2163); if (state.failed) return retval;
            // EolParserRules.g:497:21: ( keyvalExpressionList )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==FLOAT||LA63_0==INT||LA63_0==BOOLEAN||LA63_0==STRING||LA63_0==NAME||LA63_0==96||(LA63_0>=104 && LA63_0<=111)||LA63_0==141||LA63_0==144||(LA63_0>=148 && LA63_0<=149)) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // EolParserRules.g:0:0: keyvalExpressionList
                    {
                    pushFollow(FOLLOW_keyvalExpressionList_in_literalMapCollection2166);
                    keyvalExpressionList146=keyvalExpressionList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, keyvalExpressionList146.getTree());

                    }
                    break;

            }

            cb=(Token)match(input,92,FOLLOW_92_in_literalMapCollection2171); if (state.failed) return retval;
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
    // EolParserRules.g:501:1: keyvalExpressionList : keyvalExpression ( ',' keyvalExpression )* -> ^( KEYVALLIST ( keyvalExpression )+ ) ;
    public final Egx_EolParserRules.keyvalExpressionList_return keyvalExpressionList() throws RecognitionException {
        Egx_EolParserRules.keyvalExpressionList_return retval = new Egx_EolParserRules.keyvalExpressionList_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token char_literal148=null;
        Egx_EolParserRules.keyvalExpression_return keyvalExpression147 = null;

        Egx_EolParserRules.keyvalExpression_return keyvalExpression149 = null;


        org.eclipse.epsilon.common.parse.AST char_literal148_tree=null;
        RewriteRuleTokenStream stream_89=new RewriteRuleTokenStream(adaptor,"token 89");
        RewriteRuleSubtreeStream stream_keyvalExpression=new RewriteRuleSubtreeStream(adaptor,"rule keyvalExpression");
        try {
            // EolParserRules.g:505:2: ( keyvalExpression ( ',' keyvalExpression )* -> ^( KEYVALLIST ( keyvalExpression )+ ) )
            // EolParserRules.g:505:4: keyvalExpression ( ',' keyvalExpression )*
            {
            pushFollow(FOLLOW_keyvalExpression_in_keyvalExpressionList2192);
            keyvalExpression147=keyvalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_keyvalExpression.add(keyvalExpression147.getTree());
            // EolParserRules.g:505:21: ( ',' keyvalExpression )*
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==89) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // EolParserRules.g:505:22: ',' keyvalExpression
            	    {
            	    char_literal148=(Token)match(input,89,FOLLOW_89_in_keyvalExpressionList2195); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_89.add(char_literal148);

            	    pushFollow(FOLLOW_keyvalExpression_in_keyvalExpressionList2197);
            	    keyvalExpression149=keyvalExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_keyvalExpression.add(keyvalExpression149.getTree());

            	    }
            	    break;

            	default :
            	    break loop64;
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
            // 506:2: -> ^( KEYVALLIST ( keyvalExpression )+ )
            {
                // EolParserRules.g:506:5: ^( KEYVALLIST ( keyvalExpression )+ )
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
    // EolParserRules.g:509:1: keyvalExpression : additiveExpression eq= '=' logicalExpression ;
    public final Egx_EolParserRules.keyvalExpression_return keyvalExpression() throws RecognitionException {
        Egx_EolParserRules.keyvalExpression_return retval = new Egx_EolParserRules.keyvalExpression_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token eq=null;
        Egx_EolParserRules.additiveExpression_return additiveExpression150 = null;

        Egx_EolParserRules.logicalExpression_return logicalExpression151 = null;


        org.eclipse.epsilon.common.parse.AST eq_tree=null;

        try {
            // EolParserRules.g:511:2: ( additiveExpression eq= '=' logicalExpression )
            // EolParserRules.g:511:4: additiveExpression eq= '=' logicalExpression
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            pushFollow(FOLLOW_additiveExpression_in_keyvalExpression2222);
            additiveExpression150=additiveExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, additiveExpression150.getTree());
            eq=(Token)match(input,93,FOLLOW_93_in_keyvalExpression2226); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            eq_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(eq);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(eq_tree, root_0);
            }
            pushFollow(FOLLOW_logicalExpression_in_keyvalExpression2229);
            logicalExpression151=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression151.getTree());
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
    // EolParserRules.g:514:1: primitiveExpression : ( literalSequentialCollection | literalMapCollection | literal | featureCall | pathName | nativeType | collectionType | logicalExpressionInBrackets | newExpression | variableDeclarationExpression );
    public final Egx_EolParserRules.primitiveExpression_return primitiveExpression() throws RecognitionException {
        Egx_EolParserRules.primitiveExpression_return retval = new Egx_EolParserRules.primitiveExpression_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Egx_EolParserRules.literalSequentialCollection_return literalSequentialCollection152 = null;

        Egx_EolParserRules.literalMapCollection_return literalMapCollection153 = null;

        Egx_EolParserRules.literal_return literal154 = null;

        Egx_EolParserRules.featureCall_return featureCall155 = null;

        Egx_EolParserRules.pathName_return pathName156 = null;

        Egx_EolParserRules.nativeType_return nativeType157 = null;

        Egx_EolParserRules.collectionType_return collectionType158 = null;

        Egx_EolParserRules.logicalExpressionInBrackets_return logicalExpressionInBrackets159 = null;

        Egx_EolParserRules.newExpression_return newExpression160 = null;

        Egx_EolParserRules.variableDeclarationExpression_return variableDeclarationExpression161 = null;



        try {
            // EolParserRules.g:515:2: ( literalSequentialCollection | literalMapCollection | literal | featureCall | pathName | nativeType | collectionType | logicalExpressionInBrackets | newExpression | variableDeclarationExpression )
            int alt65=10;
            alt65 = dfa65.predict(input);
            switch (alt65) {
                case 1 :
                    // EolParserRules.g:515:4: literalSequentialCollection
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_literalSequentialCollection_in_primitiveExpression2243);
                    literalSequentialCollection152=literalSequentialCollection();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, literalSequentialCollection152.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:515:34: literalMapCollection
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_literalMapCollection_in_primitiveExpression2247);
                    literalMapCollection153=literalMapCollection();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, literalMapCollection153.getTree());

                    }
                    break;
                case 3 :
                    // EolParserRules.g:515:57: literal
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_literal_in_primitiveExpression2251);
                    literal154=literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, literal154.getTree());

                    }
                    break;
                case 4 :
                    // EolParserRules.g:515:67: featureCall
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_featureCall_in_primitiveExpression2255);
                    featureCall155=featureCall();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, featureCall155.getTree());

                    }
                    break;
                case 5 :
                    // EolParserRules.g:515:81: pathName
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_pathName_in_primitiveExpression2259);
                    pathName156=pathName();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pathName156.getTree());

                    }
                    break;
                case 6 :
                    // EolParserRules.g:515:92: nativeType
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_nativeType_in_primitiveExpression2263);
                    nativeType157=nativeType();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nativeType157.getTree());

                    }
                    break;
                case 7 :
                    // EolParserRules.g:516:5: collectionType
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_collectionType_in_primitiveExpression2269);
                    collectionType158=collectionType();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, collectionType158.getTree());

                    }
                    break;
                case 8 :
                    // EolParserRules.g:516:23: logicalExpressionInBrackets
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_logicalExpressionInBrackets_in_primitiveExpression2274);
                    logicalExpressionInBrackets159=logicalExpressionInBrackets();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpressionInBrackets159.getTree());

                    }
                    break;
                case 9 :
                    // EolParserRules.g:517:5: newExpression
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_newExpression_in_primitiveExpression2280);
                    newExpression160=newExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, newExpression160.getTree());

                    }
                    break;
                case 10 :
                    // EolParserRules.g:517:21: variableDeclarationExpression
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_variableDeclarationExpression_in_primitiveExpression2284);
                    variableDeclarationExpression161=variableDeclarationExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, variableDeclarationExpression161.getTree());

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
    // EolParserRules.g:520:1: logicalExpressionInBrackets : ob= '(' logicalExpression cb= ')' ;
    public final Egx_EolParserRules.logicalExpressionInBrackets_return logicalExpressionInBrackets() throws RecognitionException {
        Egx_EolParserRules.logicalExpressionInBrackets_return retval = new Egx_EolParserRules.logicalExpressionInBrackets_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token ob=null;
        Token cb=null;
        Egx_EolParserRules.logicalExpression_return logicalExpression162 = null;


        org.eclipse.epsilon.common.parse.AST ob_tree=null;
        org.eclipse.epsilon.common.parse.AST cb_tree=null;

        try {
            // EolParserRules.g:525:2: (ob= '(' logicalExpression cb= ')' )
            // EolParserRules.g:525:4: ob= '(' logicalExpression cb= ')'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            ob=(Token)match(input,96,FOLLOW_96_in_logicalExpressionInBrackets2303); if (state.failed) return retval;
            pushFollow(FOLLOW_logicalExpression_in_logicalExpressionInBrackets2306);
            logicalExpression162=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression162.getTree());
            cb=(Token)match(input,97,FOLLOW_97_in_logicalExpressionInBrackets2310); if (state.failed) return retval;

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
    // $ANTLR end logicalExpressionInBrackets

    public static class literal_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start literal
    // EolParserRules.g:528:1: literal : ( STRING | INT | FLOAT | BOOLEAN );
    public final Egx_EolParserRules.literal_return literal() throws RecognitionException {
        Egx_EolParserRules.literal_return retval = new Egx_EolParserRules.literal_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token set163=null;

        org.eclipse.epsilon.common.parse.AST set163_tree=null;

        try {
            // EolParserRules.g:529:2: ( STRING | INT | FLOAT | BOOLEAN )
            // EolParserRules.g:
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            set163=(Token)input.LT(1);
            if ( input.LA(1)==FLOAT||input.LA(1)==INT||input.LA(1)==BOOLEAN||input.LA(1)==STRING ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (org.eclipse.epsilon.common.parse.AST)adaptor.create(set163));
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
        // EolParserRules.g:200:4: ( annotation )
        // EolParserRules.g:200:4: annotation
        {
        pushFollow(FOLLOW_annotation_in_synpred16_EolParserRules665);
        annotation();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred16_EolParserRules

    // $ANTLR start synpred28_EolParserRules
    public final void synpred28_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:249:4: ( '(' typeName ')' )
        // EolParserRules.g:249:4: '(' typeName ')'
        {
        match(input,96,FOLLOW_96_in_synpred28_EolParserRules843); if (state.failed) return ;
        pushFollow(FOLLOW_typeName_in_synpred28_EolParserRules848);
        typeName();

        state._fsp--;
        if (state.failed) return ;
        match(input,97,FOLLOW_97_in_synpred28_EolParserRules854); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred28_EolParserRules

    // $ANTLR start synpred29_EolParserRules
    public final void synpred29_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:253:4: ( statementA )
        // EolParserRules.g:253:4: statementA
        {
        pushFollow(FOLLOW_statementA_in_synpred29_EolParserRules869);
        statementA();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred29_EolParserRules

    // $ANTLR start synpred30_EolParserRules
    public final void synpred30_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:257:4: ( assignmentStatement )
        // EolParserRules.g:257:4: assignmentStatement
        {
        pushFollow(FOLLOW_assignmentStatement_in_synpred30_EolParserRules884);
        assignmentStatement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred30_EolParserRules

    // $ANTLR start synpred31_EolParserRules
    public final void synpred31_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:257:26: ( expressionStatement )
        // EolParserRules.g:257:26: expressionStatement
        {
        pushFollow(FOLLOW_expressionStatement_in_synpred31_EolParserRules888);
        expressionStatement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred31_EolParserRules

    // $ANTLR start synpred45_EolParserRules
    public final void synpred45_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:280:66: ( elseStatement )
        // EolParserRules.g:280:66: elseStatement
        {
        pushFollow(FOLLOW_elseStatement_in_synpred45_EolParserRules1043);
        elseStatement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred45_EolParserRules

    // $ANTLR start synpred52_EolParserRules
    public final void synpred52_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:368:22: ( NAME ( ',' NAME )* )
        // EolParserRules.g:368:22: NAME ( ',' NAME )*
        {
        match(input,NAME,FOLLOW_NAME_in_synpred52_EolParserRules1412); if (state.failed) return ;
        // EolParserRules.g:368:27: ( ',' NAME )*
        loop66:
        do {
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==89) ) {
                alt66=1;
            }


            switch (alt66) {
        	case 1 :
        	    // EolParserRules.g:368:28: ',' NAME
        	    {
        	    match(input,89,FOLLOW_89_in_synpred52_EolParserRules1415); if (state.failed) return ;
        	    match(input,NAME,FOLLOW_NAME_in_synpred52_EolParserRules1417); if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop66;
            }
        } while (true);


        }
    }
    // $ANTLR end synpred52_EolParserRules

    // $ANTLR start synpred54_EolParserRules
    public final void synpred54_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:384:5: ( postfixExpression '=' logicalExpression )
        // EolParserRules.g:384:5: postfixExpression '=' logicalExpression
        {
        pushFollow(FOLLOW_postfixExpression_in_synpred54_EolParserRules1487);
        postfixExpression();

        state._fsp--;
        if (state.failed) return ;
        match(input,93,FOLLOW_93_in_synpred54_EolParserRules1491); if (state.failed) return ;
        pushFollow(FOLLOW_logicalExpression_in_synpred54_EolParserRules1494);
        logicalExpression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred54_EolParserRules

    // $ANTLR start synpred65_EolParserRules
    public final void synpred65_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:393:24: ( ( '==' relationalExpression | '=' relationalExpression | ( '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression ) )
        // EolParserRules.g:393:24: ( '==' relationalExpression | '=' relationalExpression | ( '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression )
        {
        // EolParserRules.g:393:24: ( '==' relationalExpression | '=' relationalExpression | ( '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression )
        int alt67=3;
        switch ( input.LA(1) ) {
        case 134:
            {
            alt67=1;
            }
            break;
        case 93:
            {
            alt67=2;
            }
            break;
        case 135:
        case 136:
        case 137:
        case 138:
        case 139:
            {
            alt67=3;
            }
            break;
        default:
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 67, 0, input);

            throw nvae;
        }

        switch (alt67) {
            case 1 :
                // EolParserRules.g:393:25: '==' relationalExpression
                {
                match(input,134,FOLLOW_134_in_synpred65_EolParserRules1565); if (state.failed) return ;
                pushFollow(FOLLOW_relationalExpression_in_synpred65_EolParserRules1568);
                relationalExpression();

                state._fsp--;
                if (state.failed) return ;

                }
                break;
            case 2 :
                // EolParserRules.g:393:57: '=' relationalExpression
                {
                match(input,93,FOLLOW_93_in_synpred65_EolParserRules1574); if (state.failed) return ;
                pushFollow(FOLLOW_relationalExpression_in_synpred65_EolParserRules1577);
                relationalExpression();

                state._fsp--;
                if (state.failed) return ;

                }
                break;
            case 3 :
                // EolParserRules.g:394:24: ( '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression
                {
                if ( (input.LA(1)>=135 && input.LA(1)<=139) ) {
                    input.consume();
                    state.errorRecovery=false;state.failed=false;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    MismatchedSetException mse = new MismatchedSetException(null,input);
                    throw mse;
                }

                pushFollow(FOLLOW_additiveExpression_in_synpred65_EolParserRules1631);
                additiveExpression();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        }
    }
    // $ANTLR end synpred65_EolParserRules

    // $ANTLR start synpred84_EolParserRules
    public final void synpred84_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:463:19: ( ':' ( 'new' )? typeName ( parameterList )? )
        // EolParserRules.g:463:19: ':' ( 'new' )? typeName ( parameterList )?
        {
        match(input,98,FOLLOW_98_in_synpred84_EolParserRules1984); if (state.failed) return ;
        // EolParserRules.g:463:25: ( 'new' )?
        int alt70=2;
        int LA70_0 = input.LA(1);

        if ( (LA70_0==148) ) {
            alt70=1;
        }
        switch (alt70) {
            case 1 :
                // EolParserRules.g:0:0: 'new'
                {
                match(input,148,FOLLOW_148_in_synpred84_EolParserRules1989); if (state.failed) return ;

                }
                break;

        }

        pushFollow(FOLLOW_typeName_in_synpred84_EolParserRules1995);
        typeName();

        state._fsp--;
        if (state.failed) return ;
        // EolParserRules.g:463:70: ( parameterList )?
        int alt71=2;
        int LA71_0 = input.LA(1);

        if ( (LA71_0==96) ) {
            alt71=1;
        }
        switch (alt71) {
            case 1 :
                // EolParserRules.g:0:0: parameterList
                {
                pushFollow(FOLLOW_parameterList_in_synpred84_EolParserRules1999);
                parameterList();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        }
    }
    // $ANTLR end synpred84_EolParserRules

    // $ANTLR start synpred92_EolParserRules
    public final void synpred92_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:489:4: ( expressionRange )
        // EolParserRules.g:489:4: expressionRange
        {
        pushFollow(FOLLOW_expressionRange_in_synpred92_EolParserRules2135);
        expressionRange();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred92_EolParserRules

    // $ANTLR start synpred98_EolParserRules
    public final void synpred98_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:515:67: ( featureCall )
        // EolParserRules.g:515:67: featureCall
        {
        pushFollow(FOLLOW_featureCall_in_synpred98_EolParserRules2255);
        featureCall();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred98_EolParserRules

    // $ANTLR start synpred99_EolParserRules
    public final void synpred99_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:515:81: ( pathName )
        // EolParserRules.g:515:81: pathName
        {
        pushFollow(FOLLOW_pathName_in_synpred99_EolParserRules2259);
        pathName();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred99_EolParserRules

    // Delegated rules

    public final boolean synpred84_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred84_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred99_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred99_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred54_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred54_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
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
    public final boolean synpred52_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred52_EolParserRules_fragment(); // can never throw exception
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
    public final boolean synpred92_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred92_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred65_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred65_EolParserRules_fragment(); // can never throw exception
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
    public final boolean synpred98_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred98_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred28_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred28_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred45_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred45_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA20 dfa20 = new DFA20(this);
    protected DFA21 dfa21 = new DFA21(this);
    protected DFA22 dfa22 = new DFA22(this);
    protected DFA33 dfa33 = new DFA33(this);
    protected DFA35 dfa35 = new DFA35(this);
    protected DFA40 dfa40 = new DFA40(this);
    protected DFA50 dfa50 = new DFA50(this);
    protected DFA58 dfa58 = new DFA58(this);
    protected DFA62 dfa62 = new DFA62(this);
    protected DFA65 dfa65 = new DFA65(this);
    static final String DFA20_eotS =
        "\56\uffff";
    static final String DFA20_eofS =
        "\1\2\55\uffff";
    static final String DFA20_minS =
        "\1\11\1\0\54\uffff";
    static final String DFA20_maxS =
        "\1\u00a0\1\0\54\uffff";
    static final String DFA20_acceptS =
        "\2\uffff\1\2\52\uffff\1\1";
    static final String DFA20_specialS =
        "\1\uffff\1\0\54\uffff}>";
    static final String[] DFA20_transitionS = {
            "\3\2\7\uffff\1\2\3\uffff\1\2\77\uffff\1\2\1\uffff\1\2\1\uffff"+
            "\5\2\1\1\2\2\1\uffff\1\2\14\uffff\1\2\16\uffff\20\2\1\uffff"+
            "\3\2\2\uffff\3\2\1\uffff\1\2\1\uffff\5\2",
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

    static final short[] DFA20_eot = DFA.unpackEncodedString(DFA20_eotS);
    static final short[] DFA20_eof = DFA.unpackEncodedString(DFA20_eofS);
    static final char[] DFA20_min = DFA.unpackEncodedStringToUnsignedChars(DFA20_minS);
    static final char[] DFA20_max = DFA.unpackEncodedStringToUnsignedChars(DFA20_maxS);
    static final short[] DFA20_accept = DFA.unpackEncodedString(DFA20_acceptS);
    static final short[] DFA20_special = DFA.unpackEncodedString(DFA20_specialS);
    static final short[][] DFA20_transition;

    static {
        int numStates = DFA20_transitionS.length;
        DFA20_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA20_transition[i] = DFA.unpackEncodedString(DFA20_transitionS[i]);
        }
    }

    class DFA20 extends DFA {

        public DFA20(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 20;
            this.eot = DFA20_eot;
            this.eof = DFA20_eof;
            this.min = DFA20_min;
            this.max = DFA20_max;
            this.accept = DFA20_accept;
            this.special = DFA20_special;
            this.transition = DFA20_transition;
        }
        public String getDescription() {
            return "249:3: (op= '(' tn= typeName cp= ')' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA20_1 = input.LA(1);

                         
                        int index20_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred28_EolParserRules()) ) {s = 45;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index20_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 20, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA21_eotS =
        "\34\uffff";
    static final String DFA21_eofS =
        "\34\uffff";
    static final String DFA21_minS =
        "\1\4\23\uffff\1\0\7\uffff";
    static final String DFA21_maxS =
        "\1\u0095\23\uffff\1\0\7\uffff";
    static final String DFA21_acceptS =
        "\1\uffff\1\1\24\uffff\1\2\5\uffff";
    static final String DFA21_specialS =
        "\24\uffff\1\0\7\uffff}>";
    static final String[] DFA21_transitionS = {
            "\1\1\3\uffff\1\1\3\uffff\1\1\1\uffff\1\1\4\uffff\1\1\114\uffff"+
            "\1\1\7\uffff\11\1\1\uffff\2\1\3\uffff\1\1\1\24\2\26\1\1\4\26"+
            "\15\uffff\1\1\2\uffff\1\1\3\uffff\2\1",
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
            return "252:1: statement : ( statementA | statementB );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA21_20 = input.LA(1);

                         
                        int index21_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_EolParserRules()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index21_20);
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
        "\30\uffff";
    static final String DFA22_eofS =
        "\30\uffff";
    static final String DFA22_minS =
        "\1\4\17\0\10\uffff";
    static final String DFA22_maxS =
        "\1\u0095\17\0\10\uffff";
    static final String DFA22_acceptS =
        "\20\uffff\1\3\1\4\1\5\1\6\1\7\1\10\1\1\1\2";
    static final String DFA22_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14"+
        "\1\15\1\16\10\uffff}>";
    static final String[] DFA22_transitionS = {
            "\1\12\3\uffff\1\12\3\uffff\1\12\1\uffff\1\12\4\uffff\1\13\114"+
            "\uffff\1\15\7\uffff\1\14\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\20"+
            "\1\uffff\1\21\1\23\3\uffff\1\22\1\24\2\uffff\1\25\21\uffff\1"+
            "\2\2\uffff\1\1\3\uffff\1\16\1\17",
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
            return "256:1: statementA : ( assignmentStatement | expressionStatement | forStatement | ifStatement | whileStatement | switchStatement | returnStatement | breakStatement );";
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
                        if ( (synpred30_EolParserRules()) ) {s = 22;}

                        else if ( (synpred31_EolParserRules()) ) {s = 23;}

                         
                        input.seek(index22_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA22_2 = input.LA(1);

                         
                        int index22_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_EolParserRules()) ) {s = 22;}

                        else if ( (synpred31_EolParserRules()) ) {s = 23;}

                         
                        input.seek(index22_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA22_3 = input.LA(1);

                         
                        int index22_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_EolParserRules()) ) {s = 22;}

                        else if ( (synpred31_EolParserRules()) ) {s = 23;}

                         
                        input.seek(index22_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA22_4 = input.LA(1);

                         
                        int index22_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_EolParserRules()) ) {s = 22;}

                        else if ( (synpred31_EolParserRules()) ) {s = 23;}

                         
                        input.seek(index22_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA22_5 = input.LA(1);

                         
                        int index22_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_EolParserRules()) ) {s = 22;}

                        else if ( (synpred31_EolParserRules()) ) {s = 23;}

                         
                        input.seek(index22_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA22_6 = input.LA(1);

                         
                        int index22_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_EolParserRules()) ) {s = 22;}

                        else if ( (synpred31_EolParserRules()) ) {s = 23;}

                         
                        input.seek(index22_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA22_7 = input.LA(1);

                         
                        int index22_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_EolParserRules()) ) {s = 22;}

                        else if ( (synpred31_EolParserRules()) ) {s = 23;}

                         
                        input.seek(index22_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA22_8 = input.LA(1);

                         
                        int index22_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_EolParserRules()) ) {s = 22;}

                        else if ( (synpred31_EolParserRules()) ) {s = 23;}

                         
                        input.seek(index22_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA22_9 = input.LA(1);

                         
                        int index22_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_EolParserRules()) ) {s = 22;}

                        else if ( (synpred31_EolParserRules()) ) {s = 23;}

                         
                        input.seek(index22_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA22_10 = input.LA(1);

                         
                        int index22_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_EolParserRules()) ) {s = 22;}

                        else if ( (synpred31_EolParserRules()) ) {s = 23;}

                         
                        input.seek(index22_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA22_11 = input.LA(1);

                         
                        int index22_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_EolParserRules()) ) {s = 22;}

                        else if ( (synpred31_EolParserRules()) ) {s = 23;}

                         
                        input.seek(index22_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA22_12 = input.LA(1);

                         
                        int index22_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_EolParserRules()) ) {s = 22;}

                        else if ( (synpred31_EolParserRules()) ) {s = 23;}

                         
                        input.seek(index22_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA22_13 = input.LA(1);

                         
                        int index22_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_EolParserRules()) ) {s = 22;}

                        else if ( (synpred31_EolParserRules()) ) {s = 23;}

                         
                        input.seek(index22_13);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA22_14 = input.LA(1);

                         
                        int index22_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_EolParserRules()) ) {s = 22;}

                        else if ( (synpred31_EolParserRules()) ) {s = 23;}

                         
                        input.seek(index22_14);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA22_15 = input.LA(1);

                         
                        int index22_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_EolParserRules()) ) {s = 22;}

                        else if ( (synpred31_EolParserRules()) ) {s = 23;}

                         
                        input.seek(index22_15);
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
    static final String DFA33_eotS =
        "\36\uffff";
    static final String DFA33_eofS =
        "\36\uffff";
    static final String DFA33_minS =
        "\1\4\1\0\34\uffff";
    static final String DFA33_maxS =
        "\1\u0095\1\0\34\uffff";
    static final String DFA33_acceptS =
        "\2\uffff\1\2\32\uffff\1\1";
    static final String DFA33_specialS =
        "\1\uffff\1\0\34\uffff}>";
    static final String[] DFA33_transitionS = {
            "\1\2\3\uffff\1\2\3\uffff\1\2\1\uffff\1\2\4\uffff\1\1\107\uffff"+
            "\1\2\4\uffff\1\2\7\uffff\11\2\1\uffff\2\2\3\uffff\11\2\15\uffff"+
            "\1\2\2\uffff\1\2\3\uffff\2\2",
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
            ""
    };

    static final short[] DFA33_eot = DFA.unpackEncodedString(DFA33_eotS);
    static final short[] DFA33_eof = DFA.unpackEncodedString(DFA33_eofS);
    static final char[] DFA33_min = DFA.unpackEncodedStringToUnsignedChars(DFA33_minS);
    static final char[] DFA33_max = DFA.unpackEncodedStringToUnsignedChars(DFA33_maxS);
    static final short[] DFA33_accept = DFA.unpackEncodedString(DFA33_acceptS);
    static final short[] DFA33_special = DFA.unpackEncodedString(DFA33_specialS);
    static final short[][] DFA33_transition;

    static {
        int numStates = DFA33_transitionS.length;
        DFA33_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA33_transition[i] = DFA.unpackEncodedString(DFA33_transitionS[i]);
        }
    }

    class DFA33 extends DFA {

        public DFA33(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 33;
            this.eot = DFA33_eot;
            this.eof = DFA33_eof;
            this.min = DFA33_min;
            this.max = DFA33_max;
            this.accept = DFA33_accept;
            this.special = DFA33_special;
            this.transition = DFA33_transition;
        }
        public String getDescription() {
            return "368:21: ( NAME ( ',' NAME )* )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA33_1 = input.LA(1);

                         
                        int index33_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred52_EolParserRules()) ) {s = 29;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index33_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 33, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA35_eotS =
        "\21\uffff";
    static final String DFA35_eofS =
        "\21\uffff";
    static final String DFA35_minS =
        "\1\4\15\0\3\uffff";
    static final String DFA35_maxS =
        "\1\u0095\15\0\3\uffff";
    static final String DFA35_acceptS =
        "\16\uffff\1\2\1\uffff\1\1";
    static final String DFA35_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14"+
        "\3\uffff}>";
    static final String[] DFA35_transitionS = {
            "\1\10\3\uffff\1\10\3\uffff\1\10\1\uffff\1\10\4\uffff\1\11\114"+
            "\uffff\1\13\7\uffff\1\12\1\1\1\2\1\3\1\4\1\5\1\6\1\7\35\uffff"+
            "\1\16\2\uffff\1\16\3\uffff\1\14\1\15",
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

    static final short[] DFA35_eot = DFA.unpackEncodedString(DFA35_eotS);
    static final short[] DFA35_eof = DFA.unpackEncodedString(DFA35_eofS);
    static final char[] DFA35_min = DFA.unpackEncodedStringToUnsignedChars(DFA35_minS);
    static final char[] DFA35_max = DFA.unpackEncodedStringToUnsignedChars(DFA35_maxS);
    static final short[] DFA35_accept = DFA.unpackEncodedString(DFA35_acceptS);
    static final short[] DFA35_special = DFA.unpackEncodedString(DFA35_specialS);
    static final short[][] DFA35_transition;

    static {
        int numStates = DFA35_transitionS.length;
        DFA35_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA35_transition[i] = DFA.unpackEncodedString(DFA35_transitionS[i]);
        }
    }

    class DFA35 extends DFA {

        public DFA35(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 35;
            this.eot = DFA35_eot;
            this.eof = DFA35_eof;
            this.min = DFA35_min;
            this.max = DFA35_max;
            this.accept = DFA35_accept;
            this.special = DFA35_special;
            this.transition = DFA35_transition;
        }
        public String getDescription() {
            return "384:4: ( postfixExpression op= '=' logicalExpression | logicalExpression )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA35_1 = input.LA(1);

                         
                        int index35_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred54_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index35_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA35_2 = input.LA(1);

                         
                        int index35_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred54_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index35_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA35_3 = input.LA(1);

                         
                        int index35_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred54_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index35_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA35_4 = input.LA(1);

                         
                        int index35_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred54_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index35_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA35_5 = input.LA(1);

                         
                        int index35_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred54_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index35_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA35_6 = input.LA(1);

                         
                        int index35_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred54_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index35_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA35_7 = input.LA(1);

                         
                        int index35_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred54_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index35_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA35_8 = input.LA(1);

                         
                        int index35_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred54_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index35_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA35_9 = input.LA(1);

                         
                        int index35_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred54_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index35_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA35_10 = input.LA(1);

                         
                        int index35_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred54_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index35_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA35_11 = input.LA(1);

                         
                        int index35_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred54_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index35_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA35_12 = input.LA(1);

                         
                        int index35_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred54_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index35_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA35_13 = input.LA(1);

                         
                        int index35_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred54_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index35_13);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 35, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA40_eotS =
        "\12\uffff";
    static final String DFA40_eofS =
        "\1\1\11\uffff";
    static final String DFA40_minS =
        "\1\12\1\uffff\7\0\1\uffff";
    static final String DFA40_maxS =
        "\1\u00a0\1\uffff\7\0\1\uffff";
    static final String DFA40_acceptS =
        "\1\uffff\1\2\7\uffff\1\1";
    static final String DFA40_specialS =
        "\2\uffff\1\4\1\3\1\5\1\1\1\6\1\2\1\0\1\uffff}>";
    static final String[] DFA40_transitionS = {
            "\1\1\14\uffff\1\1\77\uffff\1\1\1\uffff\1\1\2\uffff\1\1\1\3\2"+
            "\1\1\uffff\2\1\1\uffff\1\1\33\uffff\6\1\1\2\1\4\1\5\1\6\1\7"+
            "\1\10\6\uffff\1\1\3\uffff\3\1\1\uffff\1\1\1\uffff\5\1",
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
            return "()* loopback of 393:23: ( (op= '==' relationalExpression | op= '=' relationalExpression | (op= '>' | op= '<' | op= '>=' | op= '<=' | op= '<>' ) additiveExpression ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA40_8 = input.LA(1);

                         
                        int index40_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_EolParserRules()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index40_8);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA40_5 = input.LA(1);

                         
                        int index40_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_EolParserRules()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index40_5);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA40_7 = input.LA(1);

                         
                        int index40_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_EolParserRules()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index40_7);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA40_3 = input.LA(1);

                         
                        int index40_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_EolParserRules()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index40_3);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA40_2 = input.LA(1);

                         
                        int index40_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_EolParserRules()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index40_2);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA40_4 = input.LA(1);

                         
                        int index40_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_EolParserRules()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index40_4);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA40_6 = input.LA(1);

                         
                        int index40_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_EolParserRules()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index40_6);
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
    static final String DFA50_eotS =
        "\10\uffff";
    static final String DFA50_eofS =
        "\1\uffff\1\3\6\uffff";
    static final String DFA50_minS =
        "\1\23\1\11\1\4\1\uffff\1\11\1\4\1\uffff\1\11";
    static final String DFA50_maxS =
        "\1\23\1\u00a0\1\u0095\1\uffff\1\u0093\1\u0095\1\uffff\1\u0093";
    static final String DFA50_acceptS =
        "\3\uffff\1\1\2\uffff\1\2\1\uffff";
    static final String DFA50_specialS =
        "\10\uffff}>";
    static final String[] DFA50_transitionS = {
            "\1\1",
            "\3\3\13\uffff\1\3\77\uffff\1\3\1\uffff\1\3\2\uffff\4\3\1\2\2"+
            "\3\1\uffff\1\3\33\uffff\20\3\1\uffff\2\3\3\uffff\3\3\1\uffff"+
            "\1\3\1\uffff\5\3",
            "\1\3\3\uffff\1\3\3\uffff\1\3\1\uffff\1\3\4\uffff\1\4\114\uffff"+
            "\2\3\6\uffff\10\3\35\uffff\1\3\2\uffff\1\3\3\uffff\2\3",
            "",
            "\1\3\1\uffff\1\3\115\uffff\1\5\3\uffff\1\3\2\uffff\2\3\1\6\2"+
            "\uffff\3\3\32\uffff\16\3\1\uffff\1\3\1\uffff\1\6",
            "\1\3\3\uffff\1\3\3\uffff\1\3\1\uffff\1\3\4\uffff\1\7\114\uffff"+
            "\1\3\7\uffff\10\3\35\uffff\1\3\2\uffff\1\3\3\uffff\2\3",
            "",
            "\1\3\1\uffff\1\3\115\uffff\1\5\3\uffff\1\3\2\uffff\2\3\1\6\2"+
            "\uffff\3\3\32\uffff\16\3\1\uffff\1\3\1\uffff\1\6"
    };

    static final short[] DFA50_eot = DFA.unpackEncodedString(DFA50_eotS);
    static final short[] DFA50_eof = DFA.unpackEncodedString(DFA50_eofS);
    static final char[] DFA50_min = DFA.unpackEncodedStringToUnsignedChars(DFA50_minS);
    static final char[] DFA50_max = DFA.unpackEncodedStringToUnsignedChars(DFA50_maxS);
    static final short[] DFA50_accept = DFA.unpackEncodedString(DFA50_acceptS);
    static final short[] DFA50_special = DFA.unpackEncodedString(DFA50_specialS);
    static final short[][] DFA50_transition;

    static {
        int numStates = DFA50_transitionS.length;
        DFA50_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA50_transition[i] = DFA.unpackEncodedString(DFA50_transitionS[i]);
        }
    }

    class DFA50 extends DFA {

        public DFA50(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 50;
            this.eot = DFA50_eot;
            this.eof = DFA50_eof;
            this.min = DFA50_min;
            this.max = DFA50_max;
            this.accept = DFA50_accept;
            this.special = DFA50_special;
            this.transition = DFA50_transition;
        }
        public String getDescription() {
            return "423:1: featureCall : ( simpleFeatureCall | declarativeFeatureCall );";
        }
    }
    static final String DFA58_eotS =
        "\27\uffff";
    static final String DFA58_eofS =
        "\2\2\25\uffff";
    static final String DFA58_minS =
        "\1\11\1\4\1\uffff\10\0\1\140\1\23\1\uffff\1\16\1\0\1\140\1\0\1\141"+
        "\1\16\1\0\1\141\1\0";
    static final String DFA58_maxS =
        "\1\u00a0\1\u0095\1\uffff\10\0\1\140\1\157\1\uffff\1\16\1\0\1\140"+
        "\1\0\1\141\1\16\1\0\1\141\1\0";
    static final String DFA58_acceptS =
        "\2\uffff\1\2\12\uffff\1\1\11\uffff";
    static final String DFA58_specialS =
        "\3\uffff\1\0\1\4\1\12\1\1\1\11\1\7\1\2\1\5\4\uffff\1\13\1\uffff"+
        "\1\6\2\uffff\1\3\1\uffff\1\10}>";
    static final String[] DFA58_transitionS = {
            "\3\2\13\uffff\1\2\77\uffff\1\2\1\uffff\1\2\2\uffff\4\2\1\uffff"+
            "\1\2\1\1\1\uffff\1\2\33\uffff\20\2\1\uffff\2\2\3\uffff\3\2\1"+
            "\uffff\1\2\1\uffff\5\2",
            "\1\2\3\uffff\1\2\3\uffff\1\2\1\uffff\1\2\4\uffff\1\12\110\uffff"+
            "\1\2\3\uffff\1\2\7\uffff\1\13\1\3\1\4\1\5\1\6\1\7\1\10\1\11"+
            "\1\2\1\uffff\4\2\1\uffff\11\2\15\uffff\1\2\2\uffff\1\2\3\uffff"+
            "\1\14\1\2",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\16",
            "\1\17\124\uffff\1\20\7\21",
            "",
            "\1\22",
            "\1\uffff",
            "\1\23",
            "\1\uffff",
            "\1\24",
            "\1\25",
            "\1\uffff",
            "\1\26",
            "\1\uffff"
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
            return "463:18: ( ':' (n= 'new' )? t= typeName ( parameterList )? )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA58_3 = input.LA(1);

                         
                        int index58_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred84_EolParserRules()) ) {s = 13;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index58_3);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA58_6 = input.LA(1);

                         
                        int index58_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred84_EolParserRules()) ) {s = 13;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index58_6);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA58_9 = input.LA(1);

                         
                        int index58_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred84_EolParserRules()) ) {s = 13;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index58_9);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA58_20 = input.LA(1);

                         
                        int index58_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred84_EolParserRules()) ) {s = 13;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index58_20);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA58_4 = input.LA(1);

                         
                        int index58_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred84_EolParserRules()) ) {s = 13;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index58_4);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA58_10 = input.LA(1);

                         
                        int index58_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred84_EolParserRules()) ) {s = 13;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index58_10);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA58_17 = input.LA(1);

                         
                        int index58_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred84_EolParserRules()) ) {s = 13;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index58_17);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA58_8 = input.LA(1);

                         
                        int index58_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred84_EolParserRules()) ) {s = 13;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index58_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA58_22 = input.LA(1);

                         
                        int index58_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred84_EolParserRules()) ) {s = 13;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index58_22);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA58_7 = input.LA(1);

                         
                        int index58_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred84_EolParserRules()) ) {s = 13;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index58_7);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA58_5 = input.LA(1);

                         
                        int index58_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred84_EolParserRules()) ) {s = 13;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index58_5);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA58_15 = input.LA(1);

                         
                        int index58_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred84_EolParserRules()) ) {s = 13;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index58_15);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 58, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA62_eotS =
        "\22\uffff";
    static final String DFA62_eofS =
        "\22\uffff";
    static final String DFA62_minS =
        "\1\4\17\0\2\uffff";
    static final String DFA62_maxS =
        "\1\u0095\17\0\2\uffff";
    static final String DFA62_acceptS =
        "\20\uffff\1\1\1\2";
    static final String DFA62_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14"+
        "\1\15\1\16\2\uffff}>";
    static final String[] DFA62_transitionS = {
            "\1\12\3\uffff\1\12\3\uffff\1\12\1\uffff\1\12\4\uffff\1\13\114"+
            "\uffff\1\15\7\uffff\1\14\1\3\1\4\1\5\1\6\1\7\1\10\1\11\35\uffff"+
            "\1\2\2\uffff\1\1\3\uffff\1\16\1\17",
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
            return "488:1: expressionListOrRange : ( expressionRange | expressionList );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA62_1 = input.LA(1);

                         
                        int index62_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index62_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA62_2 = input.LA(1);

                         
                        int index62_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index62_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA62_3 = input.LA(1);

                         
                        int index62_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index62_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA62_4 = input.LA(1);

                         
                        int index62_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index62_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA62_5 = input.LA(1);

                         
                        int index62_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index62_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA62_6 = input.LA(1);

                         
                        int index62_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index62_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA62_7 = input.LA(1);

                         
                        int index62_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index62_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA62_8 = input.LA(1);

                         
                        int index62_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index62_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA62_9 = input.LA(1);

                         
                        int index62_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index62_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA62_10 = input.LA(1);

                         
                        int index62_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index62_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA62_11 = input.LA(1);

                         
                        int index62_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index62_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA62_12 = input.LA(1);

                         
                        int index62_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index62_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA62_13 = input.LA(1);

                         
                        int index62_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index62_13);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA62_14 = input.LA(1);

                         
                        int index62_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index62_14);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA62_15 = input.LA(1);

                         
                        int index62_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index62_15);
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
    static final String DFA65_eotS =
        "\23\uffff";
    static final String DFA65_eofS =
        "\1\uffff\7\17\13\uffff";
    static final String DFA65_minS =
        "\1\4\7\11\1\uffff\1\0\11\uffff";
    static final String DFA65_maxS =
        "\1\u0095\7\u00a0\1\uffff\1\0\11\uffff";
    static final String DFA65_acceptS =
        "\10\uffff\1\3\1\uffff\1\6\1\10\1\11\1\12\1\1\1\7\1\2\1\4\1\5";
    static final String DFA65_specialS =
        "\11\uffff\1\0\11\uffff}>";
    static final String[] DFA65_transitionS = {
            "\1\10\3\uffff\1\10\3\uffff\1\10\1\uffff\1\10\4\uffff\1\11\114"+
            "\uffff\1\13\7\uffff\1\12\1\1\1\2\1\3\1\4\1\5\1\6\1\7\44\uffff"+
            "\1\14\1\15",
            "\3\17\13\uffff\1\17\77\uffff\1\17\1\uffff\1\17\1\uffff\1\16"+
            "\7\17\1\uffff\1\17\33\uffff\20\17\1\uffff\2\17\3\uffff\3\17"+
            "\1\uffff\1\17\1\uffff\5\17",
            "\3\17\13\uffff\1\17\77\uffff\1\17\1\uffff\1\17\1\uffff\1\16"+
            "\7\17\1\uffff\1\17\33\uffff\20\17\1\uffff\2\17\3\uffff\3\17"+
            "\1\uffff\1\17\1\uffff\5\17",
            "\3\17\13\uffff\1\17\77\uffff\1\17\1\uffff\1\17\1\uffff\1\16"+
            "\7\17\1\uffff\1\17\33\uffff\20\17\1\uffff\2\17\3\uffff\3\17"+
            "\1\uffff\1\17\1\uffff\5\17",
            "\3\17\13\uffff\1\17\77\uffff\1\17\1\uffff\1\17\1\uffff\1\16"+
            "\7\17\1\uffff\1\17\33\uffff\20\17\1\uffff\2\17\3\uffff\3\17"+
            "\1\uffff\1\17\1\uffff\5\17",
            "\3\17\13\uffff\1\17\77\uffff\1\17\1\uffff\1\17\1\uffff\1\16"+
            "\7\17\1\uffff\1\17\33\uffff\20\17\1\uffff\2\17\3\uffff\3\17"+
            "\1\uffff\1\17\1\uffff\5\17",
            "\3\17\13\uffff\1\17\77\uffff\1\17\1\uffff\1\17\1\uffff\1\16"+
            "\7\17\1\uffff\1\17\33\uffff\20\17\1\uffff\2\17\3\uffff\3\17"+
            "\1\uffff\1\17\1\uffff\5\17",
            "\3\17\13\uffff\1\17\77\uffff\1\17\1\uffff\1\17\1\uffff\1\20"+
            "\7\17\1\uffff\1\17\33\uffff\20\17\1\uffff\2\17\3\uffff\3\17"+
            "\1\uffff\1\17\1\uffff\5\17",
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

    static final short[] DFA65_eot = DFA.unpackEncodedString(DFA65_eotS);
    static final short[] DFA65_eof = DFA.unpackEncodedString(DFA65_eofS);
    static final char[] DFA65_min = DFA.unpackEncodedStringToUnsignedChars(DFA65_minS);
    static final char[] DFA65_max = DFA.unpackEncodedStringToUnsignedChars(DFA65_maxS);
    static final short[] DFA65_accept = DFA.unpackEncodedString(DFA65_acceptS);
    static final short[] DFA65_special = DFA.unpackEncodedString(DFA65_specialS);
    static final short[][] DFA65_transition;

    static {
        int numStates = DFA65_transitionS.length;
        DFA65_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA65_transition[i] = DFA.unpackEncodedString(DFA65_transitionS[i]);
        }
    }

    class DFA65 extends DFA {

        public DFA65(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 65;
            this.eot = DFA65_eot;
            this.eof = DFA65_eof;
            this.min = DFA65_min;
            this.max = DFA65_max;
            this.accept = DFA65_accept;
            this.special = DFA65_special;
            this.transition = DFA65_transition;
        }
        public String getDescription() {
            return "514:1: primitiveExpression : ( literalSequentialCollection | literalMapCollection | literal | featureCall | pathName | nativeType | collectionType | logicalExpressionInBrackets | newExpression | variableDeclarationExpression );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA65_9 = input.LA(1);

                         
                        int index65_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred98_EolParserRules()) ) {s = 17;}

                        else if ( (synpred99_EolParserRules()) ) {s = 18;}

                         
                        input.seek(index65_9);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 65, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_operationDeclaration_in_operationDeclarationOrAnnotationBlock246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationBlock_in_operationDeclarationOrAnnotationBlock248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_86_in_modelDeclaration267 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_modelDeclaration270 = new BitSet(new long[]{0x0000000000000000L,0x000000000D800000L});
    public static final BitSet FOLLOW_modelAlias_in_modelDeclaration272 = new BitSet(new long[]{0x0000000000000000L,0x000000000C800000L});
    public static final BitSet FOLLOW_modelDriver_in_modelDeclaration275 = new BitSet(new long[]{0x0000000000000000L,0x0000000008800000L});
    public static final BitSet FOLLOW_modelDeclarationParameters_in_modelDeclaration278 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_87_in_modelDeclaration283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_88_in_modelAlias298 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_modelAlias301 = new BitSet(new long[]{0x0000000000000002L,0x0000000002000000L});
    public static final BitSet FOLLOW_89_in_modelAlias304 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_modelAlias307 = new BitSet(new long[]{0x0000000000000002L,0x0000000002000000L});
    public static final BitSet FOLLOW_90_in_modelDriver326 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_modelDriver329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_91_in_modelDeclarationParameters351 = new BitSet(new long[]{0x0000000000080000L,0x0000000012000000L});
    public static final BitSet FOLLOW_modelDeclarationParameter_in_modelDeclarationParameters354 = new BitSet(new long[]{0x0000000000000000L,0x0000000012000000L});
    public static final BitSet FOLLOW_89_in_modelDeclarationParameters358 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_modelDeclarationParameter_in_modelDeclarationParameters361 = new BitSet(new long[]{0x0000000000000000L,0x0000000012000000L});
    public static final BitSet FOLLOW_92_in_modelDeclarationParameters367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_modelDeclarationParameter380 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_modelDeclarationParameter384 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_STRING_in_modelDeclarationParameter387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_operationDeclaration408 = new BitSet(new long[]{0x0000000000080000L,0x0000FF0000000000L});
    public static final BitSet FOLLOW_typeName_in_operationDeclaration418 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_operationDeclaration426 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_96_in_operationDeclaration430 = new BitSet(new long[]{0x0000000000080000L,0x0000000200000000L});
    public static final BitSet FOLLOW_formalParameterList_in_operationDeclaration433 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_97_in_operationDeclaration438 = new BitSet(new long[]{0x0000000000000000L,0x0000000408000000L});
    public static final BitSet FOLLOW_98_in_operationDeclaration442 = new BitSet(new long[]{0x0000000000080000L,0x0000FF0000000000L});
    public static final BitSet FOLLOW_typeName_in_operationDeclaration447 = new BitSet(new long[]{0x0000000000000000L,0x0000000408000000L});
    public static final BitSet FOLLOW_statementBlock_in_operationDeclaration453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_99_in_importStatement473 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_STRING_in_importStatement476 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_87_in_importStatement480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_block500 = new BitSet(new long[]{0x0000000000085112L,0xFF8DFF0100000000L,0x0000000000312000L});
    public static final BitSet FOLLOW_91_in_statementBlock529 = new BitSet(new long[]{0x0000000000085110L,0xFF8DFF0100000000L,0x0000000000312000L});
    public static final BitSet FOLLOW_block_in_statementBlock532 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_92_in_statementBlock536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_formalParameter554 = new BitSet(new long[]{0x0000000000000002L,0x0000000400000000L});
    public static final BitSet FOLLOW_98_in_formalParameter557 = new BitSet(new long[]{0x0000000000080000L,0x0000FF0000000000L});
    public static final BitSet FOLLOW_typeName_in_formalParameter561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_formalParameter_in_formalParameterList595 = new BitSet(new long[]{0x0000000000000002L,0x0000000002000000L});
    public static final BitSet FOLLOW_89_in_formalParameterList598 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_formalParameter_in_formalParameterList600 = new BitSet(new long[]{0x0000000000000002L,0x0000000002000000L});
    public static final BitSet FOLLOW_100_in_executableAnnotation625 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0xFFFFFFFFFFFFFFFFL,0x00000001FFFFFFFFL});
    public static final BitSet FOLLOW_logicalExpression_in_executableAnnotation632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Annotation_in_annotation646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_executableAnnotation_in_annotation648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotation_in_annotationBlock665 = new BitSet(new long[]{0x0000000000800002L,0x0000001000000000L});
    public static final BitSet FOLLOW_pathName_in_typeName694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nativeType_in_typeName698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectionType_in_typeName702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_pathName716 = new BitSet(new long[]{0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_101_in_pathName718 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_packagedType_in_pathName727 = new BitSet(new long[]{0x0000000000000002L,0x0000004000000000L});
    public static final BitSet FOLLOW_102_in_pathName733 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_pathName738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_packagedType759 = new BitSet(new long[]{0x0000000000000002L,0x0000008000000000L});
    public static final BitSet FOLLOW_103_in_packagedType762 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_packagedType767 = new BitSet(new long[]{0x0000000000000002L,0x0000008000000000L});
    public static final BitSet FOLLOW_104_in_nativeType792 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_96_in_nativeType795 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_STRING_in_nativeType798 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_97_in_nativeType800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_collectionType821 = new BitSet(new long[]{0x0000000000000002L,0x0000000100000000L});
    public static final BitSet FOLLOW_96_in_collectionType843 = new BitSet(new long[]{0x0000000000080000L,0x0000FF0000000000L});
    public static final BitSet FOLLOW_typeName_in_collectionType848 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_97_in_collectionType854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementA_in_statement869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementB_in_statement873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignmentStatement_in_statementA884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionStatement_in_statementA888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_forStatement_in_statementA892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStatement_in_statementA898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_whileStatement_in_statementA902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_switchStatement_in_statementA906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_returnStatement_in_statementA910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_breakStatement_in_statementA914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_breakAllStatement_in_statementB926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_returnStatement_in_statementB930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_transactionStatement_in_statementB934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_abortStatement_in_statementB940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_continueStatement_in_statementB944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_throwStatement_in_statementB948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_deleteStatement_in_statementB954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_statementOrStatementBlock965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementBlock_in_statementOrStatementBlock969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_98_in_expressionOrStatementBlock978 = new BitSet(new long[]{0x0000000000085110L,0x0000FF0100000000L,0x0000000000312000L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionOrStatementBlock981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementBlock_in_expressionOrStatementBlock985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_112_in_forStatement998 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_96_in_forStatement1001 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_formalParameter_in_forStatement1004 = new BitSet(new long[]{0x0000000000000000L,0x0002000000000000L});
    public static final BitSet FOLLOW_113_in_forStatement1006 = new BitSet(new long[]{0x0000000000085110L,0x0000FF0100000000L,0x0000000000312000L});
    public static final BitSet FOLLOW_logicalExpression_in_forStatement1009 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_97_in_forStatement1011 = new BitSet(new long[]{0x0000000000085110L,0xFF8DFF0508000000L,0x0000000000312000L});
    public static final BitSet FOLLOW_statementOrStatementBlock_in_forStatement1014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_114_in_ifStatement1030 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_96_in_ifStatement1033 = new BitSet(new long[]{0x0000000000085110L,0x0000FF0100000000L,0x0000000000312000L});
    public static final BitSet FOLLOW_logicalExpression_in_ifStatement1036 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_97_in_ifStatement1038 = new BitSet(new long[]{0x0000000000085110L,0xFF8DFF0508000000L,0x0000000000312000L});
    public static final BitSet FOLLOW_statementOrStatementBlock_in_ifStatement1041 = new BitSet(new long[]{0x0000000000000002L,0x0040000000000000L});
    public static final BitSet FOLLOW_elseStatement_in_ifStatement1043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_115_in_switchStatement1062 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_96_in_switchStatement1065 = new BitSet(new long[]{0x0000000000085110L,0x0000FF0100000000L,0x0000000000312000L});
    public static final BitSet FOLLOW_logicalExpression_in_switchStatement1068 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_97_in_switchStatement1070 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_91_in_switchStatement1073 = new BitSet(new long[]{0x0000000000000000L,0x0030000010000000L});
    public static final BitSet FOLLOW_caseStatement_in_switchStatement1076 = new BitSet(new long[]{0x0000000000000000L,0x0030000010000000L});
    public static final BitSet FOLLOW_defaultStatement_in_switchStatement1079 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_92_in_switchStatement1082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_116_in_caseStatement1101 = new BitSet(new long[]{0x0000000000085110L,0x0000FF0100000000L,0x0000000000312000L});
    public static final BitSet FOLLOW_logicalExpression_in_caseStatement1104 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_98_in_caseStatement1106 = new BitSet(new long[]{0x0000000000085110L,0xFF8DFF0100000000L,0x0000000000312000L});
    public static final BitSet FOLLOW_block_in_caseStatement1109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_117_in_defaultStatement1127 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_98_in_defaultStatement1130 = new BitSet(new long[]{0x0000000000085110L,0xFF8DFF0100000000L,0x0000000000312000L});
    public static final BitSet FOLLOW_block_in_defaultStatement1133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_118_in_elseStatement1157 = new BitSet(new long[]{0x0000000000085110L,0xFF8DFF0508000000L,0x0000000000312000L});
    public static final BitSet FOLLOW_statementOrStatementBlock_in_elseStatement1160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_119_in_whileStatement1173 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_96_in_whileStatement1176 = new BitSet(new long[]{0x0000000000085110L,0x0000FF0100000000L,0x0000000000312000L});
    public static final BitSet FOLLOW_logicalExpression_in_whileStatement1179 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_97_in_whileStatement1181 = new BitSet(new long[]{0x0000000000085110L,0xFF8DFF0508000000L,0x0000000000312000L});
    public static final BitSet FOLLOW_statementOrStatementBlock_in_whileStatement1184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_120_in_returnStatement1206 = new BitSet(new long[]{0x0000000000085110L,0x0000FF0100800000L,0x0000000000312000L});
    public static final BitSet FOLLOW_logicalExpression_in_returnStatement1209 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_87_in_returnStatement1214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_121_in_throwStatement1237 = new BitSet(new long[]{0x0000000000085110L,0x0000FF0100800000L,0x0000000000312000L});
    public static final BitSet FOLLOW_logicalExpression_in_throwStatement1240 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_87_in_throwStatement1245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_122_in_deleteStatement1268 = new BitSet(new long[]{0x0000000000085110L,0x0000FF0100800000L,0x0000000000312000L});
    public static final BitSet FOLLOW_logicalExpression_in_deleteStatement1271 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_87_in_deleteStatement1276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_123_in_breakStatement1302 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_87_in_breakStatement1307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_124_in_breakAllStatement1330 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_87_in_breakAllStatement1335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_125_in_continueStatement1358 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_87_in_continueStatement1363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_126_in_abortStatement1386 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_87_in_abortStatement1391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_127_in_transactionStatement1408 = new BitSet(new long[]{0x0000000000085110L,0xFF8DFF0508000000L,0x0000000000312000L});
    public static final BitSet FOLLOW_NAME_in_transactionStatement1412 = new BitSet(new long[]{0x0000000000085110L,0xFF8DFF050A000000L,0x0000000000312000L});
    public static final BitSet FOLLOW_89_in_transactionStatement1415 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_transactionStatement1417 = new BitSet(new long[]{0x0000000000085110L,0xFF8DFF050A000000L,0x0000000000312000L});
    public static final BitSet FOLLOW_statementOrStatementBlock_in_transactionStatement1423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logicalExpression_in_assignmentStatement1443 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000003L});
    public static final BitSet FOLLOW_128_in_assignmentStatement1448 = new BitSet(new long[]{0x0000000000085110L,0x0000FF0100000000L,0x0000000000312000L});
    public static final BitSet FOLLOW_129_in_assignmentStatement1455 = new BitSet(new long[]{0x0000000000085110L,0x0000FF0100000000L,0x0000000000312000L});
    public static final BitSet FOLLOW_logicalExpression_in_assignmentStatement1461 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_87_in_assignmentStatement1465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_postfixExpression_in_expressionStatement1487 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_expressionStatement1491 = new BitSet(new long[]{0x0000000000085110L,0x0000FF0100000000L,0x0000000000312000L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionStatement1494 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionStatement1500 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_87_in_expressionStatement1505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_relationalExpression_in_logicalExpression1517 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x000000000000003CL});
    public static final BitSet FOLLOW_130_in_logicalExpression1523 = new BitSet(new long[]{0x0000000000085110L,0x0000FF0100000000L,0x0000000000312000L});
    public static final BitSet FOLLOW_131_in_logicalExpression1528 = new BitSet(new long[]{0x0000000000085110L,0x0000FF0100000000L,0x0000000000312000L});
    public static final BitSet FOLLOW_132_in_logicalExpression1533 = new BitSet(new long[]{0x0000000000085110L,0x0000FF0100000000L,0x0000000000312000L});
    public static final BitSet FOLLOW_133_in_logicalExpression1538 = new BitSet(new long[]{0x0000000000085110L,0x0000FF0100000000L,0x0000000000312000L});
    public static final BitSet FOLLOW_relationalExpression_in_logicalExpression1542 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x000000000000003CL});
    public static final BitSet FOLLOW_additiveExpression_in_relationalExpression1559 = new BitSet(new long[]{0x0000000000000002L,0x0000000020000000L,0x0000000000000FC0L});
    public static final BitSet FOLLOW_134_in_relationalExpression1565 = new BitSet(new long[]{0x0000000000085110L,0x0000FF0100000000L,0x0000000000312000L});
    public static final BitSet FOLLOW_relationalExpression_in_relationalExpression1568 = new BitSet(new long[]{0x0000000000000002L,0x0000000020000000L,0x0000000000000FC0L});
    public static final BitSet FOLLOW_93_in_relationalExpression1574 = new BitSet(new long[]{0x0000000000085110L,0x0000FF0100000000L,0x0000000000312000L});
    public static final BitSet FOLLOW_relationalExpression_in_relationalExpression1577 = new BitSet(new long[]{0x0000000000000002L,0x0000000020000000L,0x0000000000000FC0L});
    public static final BitSet FOLLOW_135_in_relationalExpression1607 = new BitSet(new long[]{0x0000000000085110L,0x0000FF0100000000L,0x0000000000312000L});
    public static final BitSet FOLLOW_136_in_relationalExpression1612 = new BitSet(new long[]{0x0000000000085110L,0x0000FF0100000000L,0x0000000000312000L});
    public static final BitSet FOLLOW_137_in_relationalExpression1617 = new BitSet(new long[]{0x0000000000085110L,0x0000FF0100000000L,0x0000000000312000L});
    public static final BitSet FOLLOW_138_in_relationalExpression1622 = new BitSet(new long[]{0x0000000000085110L,0x0000FF0100000000L,0x0000000000312000L});
    public static final BitSet FOLLOW_139_in_relationalExpression1627 = new BitSet(new long[]{0x0000000000085110L,0x0000FF0100000000L,0x0000000000312000L});
    public static final BitSet FOLLOW_additiveExpression_in_relationalExpression1631 = new BitSet(new long[]{0x0000000000000002L,0x0000000020000000L,0x0000000000000FC0L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_additiveExpression1649 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000003000L});
    public static final BitSet FOLLOW_140_in_additiveExpression1655 = new BitSet(new long[]{0x0000000000085110L,0x0000FF0100000000L,0x0000000000312000L});
    public static final BitSet FOLLOW_141_in_additiveExpression1660 = new BitSet(new long[]{0x0000000000085110L,0x0000FF0100000000L,0x0000000000312000L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_additiveExpression1664 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000003000L});
    public static final BitSet FOLLOW_unaryExpression_in_multiplicativeExpression1682 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x000000000000C000L});
    public static final BitSet FOLLOW_142_in_multiplicativeExpression1688 = new BitSet(new long[]{0x0000000000085110L,0x0000FF0100000000L,0x0000000000312000L});
    public static final BitSet FOLLOW_143_in_multiplicativeExpression1693 = new BitSet(new long[]{0x0000000000085110L,0x0000FF0100000000L,0x0000000000312000L});
    public static final BitSet FOLLOW_unaryExpression_in_multiplicativeExpression1697 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x000000000000C000L});
    public static final BitSet FOLLOW_144_in_unaryExpression1718 = new BitSet(new long[]{0x0000000000085110L,0x0000FF0100000000L,0x0000000000312000L});
    public static final BitSet FOLLOW_141_in_unaryExpression1723 = new BitSet(new long[]{0x0000000000085110L,0x0000FF0100000000L,0x0000000000312000L});
    public static final BitSet FOLLOW_postfixExpression_in_unaryExpression1731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_itemSelectorExpression_in_postfixExpression1743 = new BitSet(new long[]{0x0000000000000A02L});
    public static final BitSet FOLLOW_set_in_postfixExpression1746 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_featureCall_in_postfixExpression1755 = new BitSet(new long[]{0x0000000000000A02L,0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_145_in_postfixExpression1764 = new BitSet(new long[]{0x0000000000085110L,0x0000FF0100000000L,0x0000000000312000L});
    public static final BitSet FOLLOW_logicalExpression_in_postfixExpression1767 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_146_in_postfixExpression1769 = new BitSet(new long[]{0x0000000000000A02L,0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_primitiveExpression_in_itemSelectorExpression1791 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_145_in_itemSelectorExpression1796 = new BitSet(new long[]{0x0000000000085110L,0x0000FF0100000000L,0x0000000000312000L});
    public static final BitSet FOLLOW_primitiveExpression_in_itemSelectorExpression1799 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_146_in_itemSelectorExpression1801 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_simpleFeatureCall_in_featureCall1820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declarativeFeatureCall_in_featureCall1824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_simpleFeatureCall1838 = new BitSet(new long[]{0x0000000000000002L,0x0000000100000000L});
    public static final BitSet FOLLOW_parameterList_in_simpleFeatureCall1841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_96_in_parameterList1864 = new BitSet(new long[]{0x0000000000085110L,0x0000FF0300000000L,0x0000000000312000L});
    public static final BitSet FOLLOW_logicalExpression_in_parameterList1867 = new BitSet(new long[]{0x0000000000000000L,0x0000000202000000L});
    public static final BitSet FOLLOW_89_in_parameterList1870 = new BitSet(new long[]{0x0000000000085110L,0x0000FF0100000000L,0x0000000000312000L});
    public static final BitSet FOLLOW_logicalExpression_in_parameterList1872 = new BitSet(new long[]{0x0000000000000000L,0x0000000202000000L});
    public static final BitSet FOLLOW_97_in_parameterList1880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_declarativeFeatureCall1908 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_96_in_declarativeFeatureCall1913 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_formalParameterList_in_declarativeFeatureCall1916 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_147_in_declarativeFeatureCall1918 = new BitSet(new long[]{0x0000000000085110L,0x0000FF0100000000L,0x0000000000312000L});
    public static final BitSet FOLLOW_logicalExpression_in_declarativeFeatureCall1921 = new BitSet(new long[]{0x0000000000000000L,0x0000000202000000L});
    public static final BitSet FOLLOW_89_in_declarativeFeatureCall1924 = new BitSet(new long[]{0x0000000000085110L,0x0000FF0100000000L,0x0000000000312000L});
    public static final BitSet FOLLOW_logicalExpression_in_declarativeFeatureCall1927 = new BitSet(new long[]{0x0000000000000000L,0x0000000202000000L});
    public static final BitSet FOLLOW_97_in_declarativeFeatureCall1933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_148_in_newExpression1947 = new BitSet(new long[]{0x0000000000080000L,0x0000FF0000000000L});
    public static final BitSet FOLLOW_typeName_in_newExpression1952 = new BitSet(new long[]{0x0000000000000002L,0x0000000100000000L});
    public static final BitSet FOLLOW_parameterList_in_newExpression1956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_149_in_variableDeclarationExpression1978 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_variableDeclarationExpression1981 = new BitSet(new long[]{0x0000000000000002L,0x0000000400000000L});
    public static final BitSet FOLLOW_98_in_variableDeclarationExpression1984 = new BitSet(new long[]{0x0000000000080000L,0x0000FF0000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_148_in_variableDeclarationExpression1989 = new BitSet(new long[]{0x0000000000080000L,0x0000FF0000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_typeName_in_variableDeclarationExpression1995 = new BitSet(new long[]{0x0000000000000002L,0x0000000100000000L});
    public static final BitSet FOLLOW_parameterList_in_variableDeclarationExpression1999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_105_in_literalSequentialCollection2023 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_106_in_literalSequentialCollection2028 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_107_in_literalSequentialCollection2033 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_108_in_literalSequentialCollection2038 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_109_in_literalSequentialCollection2043 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_110_in_literalSequentialCollection2048 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_91_in_literalSequentialCollection2054 = new BitSet(new long[]{0x0000000000085110L,0x0000FF0110000000L,0x0000000000312000L});
    public static final BitSet FOLLOW_expressionListOrRange_in_literalSequentialCollection2058 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_92_in_literalSequentialCollection2063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionRange2078 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_POINT_POINT_in_expressionRange2082 = new BitSet(new long[]{0x0000000000085110L,0x0000FF0100000000L,0x0000000000312000L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionRange2085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionList2106 = new BitSet(new long[]{0x0000000000000002L,0x0000000002000000L});
    public static final BitSet FOLLOW_89_in_expressionList2109 = new BitSet(new long[]{0x0000000000085110L,0x0000FF0100000000L,0x0000000000312000L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionList2111 = new BitSet(new long[]{0x0000000000000002L,0x0000000002000000L});
    public static final BitSet FOLLOW_expressionRange_in_expressionListOrRange2135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionList_in_expressionListOrRange2139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_111_in_literalMapCollection2158 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_91_in_literalMapCollection2163 = new BitSet(new long[]{0x0000000000085110L,0x0000FF0110000000L,0x0000000000312000L});
    public static final BitSet FOLLOW_keyvalExpressionList_in_literalMapCollection2166 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_92_in_literalMapCollection2171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_keyvalExpression_in_keyvalExpressionList2192 = new BitSet(new long[]{0x0000000000000002L,0x0000000002000000L});
    public static final BitSet FOLLOW_89_in_keyvalExpressionList2195 = new BitSet(new long[]{0x0000000000085110L,0x0000FF0100000000L,0x0000000000312000L});
    public static final BitSet FOLLOW_keyvalExpression_in_keyvalExpressionList2197 = new BitSet(new long[]{0x0000000000000002L,0x0000000002000000L});
    public static final BitSet FOLLOW_additiveExpression_in_keyvalExpression2222 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_keyvalExpression2226 = new BitSet(new long[]{0x0000000000085110L,0x0000FF0100000000L,0x0000000000312000L});
    public static final BitSet FOLLOW_logicalExpression_in_keyvalExpression2229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literalSequentialCollection_in_primitiveExpression2243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literalMapCollection_in_primitiveExpression2247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_primitiveExpression2251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_featureCall_in_primitiveExpression2255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pathName_in_primitiveExpression2259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nativeType_in_primitiveExpression2263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectionType_in_primitiveExpression2269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logicalExpressionInBrackets_in_primitiveExpression2274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_newExpression_in_primitiveExpression2280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variableDeclarationExpression_in_primitiveExpression2284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_96_in_logicalExpressionInBrackets2303 = new BitSet(new long[]{0x0000000000085110L,0x0000FF0100000000L,0x0000000000312000L});
    public static final BitSet FOLLOW_logicalExpression_in_logicalExpressionInBrackets2306 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_97_in_logicalExpressionInBrackets2310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_literal0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotation_in_synpred16_EolParserRules665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_96_in_synpred28_EolParserRules843 = new BitSet(new long[]{0x0000000000080000L,0x0000FF0000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_typeName_in_synpred28_EolParserRules848 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_97_in_synpred28_EolParserRules854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementA_in_synpred29_EolParserRules869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignmentStatement_in_synpred30_EolParserRules884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionStatement_in_synpred31_EolParserRules888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_elseStatement_in_synpred45_EolParserRules1043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_synpred52_EolParserRules1412 = new BitSet(new long[]{0x0000000000000002L,0x0000000002000000L});
    public static final BitSet FOLLOW_89_in_synpred52_EolParserRules1415 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_synpred52_EolParserRules1417 = new BitSet(new long[]{0x0000000000000002L,0x0000000002000000L});
    public static final BitSet FOLLOW_postfixExpression_in_synpred54_EolParserRules1487 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_synpred54_EolParserRules1491 = new BitSet(new long[]{0x0000000000085110L,0x0000FF0100000000L,0x0000000000312000L});
    public static final BitSet FOLLOW_logicalExpression_in_synpred54_EolParserRules1494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_134_in_synpred65_EolParserRules1565 = new BitSet(new long[]{0x0000000000085110L,0x0000FF0100000000L,0x0000000000312000L});
    public static final BitSet FOLLOW_relationalExpression_in_synpred65_EolParserRules1568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_93_in_synpred65_EolParserRules1574 = new BitSet(new long[]{0x0000000000085110L,0x0000FF0100000000L,0x0000000000312000L});
    public static final BitSet FOLLOW_relationalExpression_in_synpred65_EolParserRules1577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred65_EolParserRules1604 = new BitSet(new long[]{0x0000000000085110L,0x0000FF0100000000L,0x0000000000312000L});
    public static final BitSet FOLLOW_additiveExpression_in_synpred65_EolParserRules1631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_98_in_synpred84_EolParserRules1984 = new BitSet(new long[]{0x0000000000080000L,0x0000FF0000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_148_in_synpred84_EolParserRules1989 = new BitSet(new long[]{0x0000000000080000L,0x0000FF0000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_typeName_in_synpred84_EolParserRules1995 = new BitSet(new long[]{0x0000000000000002L,0x0000000100000000L});
    public static final BitSet FOLLOW_parameterList_in_synpred84_EolParserRules1999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionRange_in_synpred92_EolParserRules2135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_featureCall_in_synpred98_EolParserRules2255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pathName_in_synpred99_EolParserRules2259 = new BitSet(new long[]{0x0000000000000002L});

}
