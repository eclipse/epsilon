package org.eclipse.epsilon.eml.parse;

// $ANTLR 3.1b1 EolParserRules.g 2014-07-05 20:54:10

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
public class Eml_EolParserRules extends org.eclipse.epsilon.common.parse.EpsilonParser {
    public static final int T__144=144;
    public static final int T__143=143;
    public static final int T__146=146;
    public static final int MODELDECLARATIONPARAMETER=72;
    public static final int T__145=145;
    public static final int BREAKALL=39;
    public static final int T__140=140;
    public static final int T__142=142;
    public static final int VAR=48;
    public static final int MODELDECLARATIONPARAMETERS=71;
    public static final int T__141=141;
    public static final int THROW=53;
    public static final int PARAMLIST=25;
    public static final int EXPRLIST=54;
    public static final int EXPRRANGE=55;
    public static final int BREAK=38;
    public static final int ELSE=32;
    public static final int T__137=137;
    public static final int T__136=136;
    public static final int FORMAL=24;
    public static final int IF=31;
    public static final int MultiplicativeExpression=57;
    public static final int TYPE=64;
    public static final int T__139=139;
    public static final int T__138=138;
    public static final int T__133=133;
    public static final int T__132=132;
    public static final int T__135=135;
    public static final int T__134=134;
    public static final int T__131=131;
    public static final int NewExpression=47;
    public static final int T__130=130;
    public static final int CASE=35;
    public static final int Letter=16;
    public static final int LINE_COMMENT=22;
    public static final int T__129=129;
    public static final int T__126=126;
    public static final int JavaIDDigit=18;
    public static final int T__125=125;
    public static final int MAP=74;
    public static final int T__128=128;
    public static final int T__127=127;
    public static final int MERGE=82;
    public static final int MODELDECLARATION=67;
    public static final int EXPRESSIONINBRACKETS=59;
    public static final int TRANSACTION=41;
    public static final int FLOAT_TYPE_SUFFIX=7;
    public static final int ITEMSELECTOR=73;
    public static final int COMMENT=21;
    public static final int ModelElementType=45;
    public static final int IMPORT=66;
    public static final int DELETE=52;
    public static final int ARROW=11;
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
    public static final int CONTINUE=40;
    public static final int ENUMERATION_VALUE=65;
    public static final int OPERATOR=58;
    public static final int EMLMODULE=83;
    public static final int EXPONENT=6;
    public static final int STRING=14;
    public static final int T__148=148;
    public static final int T__147=147;
    public static final int T__149=149;
    public static final int T__91=91;
    public static final int T__100=100;
    public static final int NAMESPACE=68;
    public static final int T__92=92;
    public static final int COLLECTION=42;
    public static final int NEW=49;
    public static final int EXTENDS=79;
    public static final int T__93=93;
    public static final int T__102=102;
    public static final int PRE=77;
    public static final int T__94=94;
    public static final int T__101=101;
    public static final int POST=78;
    public static final int T__90=90;
    public static final int ALIAS=69;
    public static final int DRIVER=70;
    public static final int KEYVAL=75;
    public static final int POINT_POINT=10;
    public static final int GUARD=80;
    public static final int T__99=99;
    public static final int TRANSFORM=81;
    public static final int T__95=95;
    public static final int HELPERMETHOD=28;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int StatementBlock=29;
    public static final int T__98=98;
    public static final int ABORT=43;
    public static final int StrangeNameLiteral=15;
    public static final int FOR=30;
    public static final int BLOCK=62;
    public static final int PARAMETERS=46;
    public static final int SpecialNameChar=17;
    public static final int BOOLEAN=12;
    public static final int NAME=19;
    public static final int SWITCH=34;
    public static final int FeatureCall=60;
    public static final int T__122=122;
    public static final int T__121=121;
    public static final int T__124=124;
    public static final int FLOAT=4;
    public static final int T__123=123;
    public static final int T__120=120;
    public static final int NativeType=56;
    public static final int INT=8;
    public static final int ANNOTATIONBLOCK=50;
    public static final int RETURN=37;
    public static final int KEYVALLIST=76;
    public static final int FEATURECALL=63;
    public static final int CollectionType=44;
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
    public static final int EOLMODULE=61;
    public static final int DIGIT=5;
    public static final int EXECUTABLEANNOTATION=51;
    public static final int T__88=88;
    public static final int T__108=108;
    public static final int T__89=89;
    public static final int T__107=107;
    public static final int WHILE=33;
    public static final int T__109=109;
    public static final int T__84=84;
    public static final int T__104=104;
    public static final int POINT=9;
    public static final int T__85=85;
    public static final int T__103=103;
    public static final int T__86=86;
    public static final int T__106=106;
    public static final int DEFAULT=36;
    public static final int T__87=87;
    public static final int T__105=105;

    // delegates
    // delegators
    public EmlParser gEml;


        public Eml_EolParserRules(TokenStream input, EmlParser gEml) {
            this(input, new RecognizerSharedState(), gEml);
        }
        public Eml_EolParserRules(TokenStream input, RecognizerSharedState state, EmlParser gEml) {
            super(input, state);
            this.gEml = gEml;
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return EmlParser.tokenNames; }
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
    public final Eml_EolParserRules.operationDeclarationOrAnnotationBlock_return operationDeclarationOrAnnotationBlock() throws RecognitionException {
        Eml_EolParserRules.operationDeclarationOrAnnotationBlock_return retval = new Eml_EolParserRules.operationDeclarationOrAnnotationBlock_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Eml_EolParserRules.operationDeclaration_return operationDeclaration1 = null;

        Eml_EolParserRules.annotationBlock_return annotationBlock2 = null;



        try {
            // EolParserRules.g:106:2: ( operationDeclaration | annotationBlock )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( ((LA1_0>=92 && LA1_0<=93)) ) {
                alt1=1;
            }
            else if ( (LA1_0==Annotation||LA1_0==98) ) {
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
    public final Eml_EolParserRules.modelDeclaration_return modelDeclaration() throws RecognitionException {
        Eml_EolParserRules.modelDeclaration_return retval = new Eml_EolParserRules.modelDeclaration_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token m=null;
        Token sem=null;
        Token NAME3=null;
        Eml_EolParserRules.modelAlias_return modelAlias4 = null;

        Eml_EolParserRules.modelDriver_return modelDriver5 = null;

        Eml_EolParserRules.modelDeclarationParameters_return modelDeclarationParameters6 = null;


        org.eclipse.epsilon.common.parse.AST m_tree=null;
        org.eclipse.epsilon.common.parse.AST sem_tree=null;
        org.eclipse.epsilon.common.parse.AST NAME3_tree=null;

        try {
            // EolParserRules.g:114:2: (m= 'model' NAME ( modelAlias )? ( modelDriver )? ( modelDeclarationParameters )? sem= ';' )
            // EolParserRules.g:114:4: m= 'model' NAME ( modelAlias )? ( modelDriver )? ( modelDeclarationParameters )? sem= ';'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            m=(Token)match(input,84,FOLLOW_84_in_modelDeclaration271); if (state.failed) return retval;
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

            if ( (LA2_0==86) ) {
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

            if ( (LA3_0==88) ) {
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

            if ( (LA4_0==89) ) {
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

            sem=(Token)match(input,85,FOLLOW_85_in_modelDeclaration287); if (state.failed) return retval;

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
    public final Eml_EolParserRules.modelAlias_return modelAlias() throws RecognitionException {
        Eml_EolParserRules.modelAlias_return retval = new Eml_EolParserRules.modelAlias_return();
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

            a=(Token)match(input,86,FOLLOW_86_in_modelAlias302); if (state.failed) return retval;
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

                if ( (LA5_0==87) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // EolParserRules.g:118:22: ',' NAME
            	    {
            	    char_literal8=(Token)match(input,87,FOLLOW_87_in_modelAlias308); if (state.failed) return retval;
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
    public final Eml_EolParserRules.modelDriver_return modelDriver() throws RecognitionException {
        Eml_EolParserRules.modelDriver_return retval = new Eml_EolParserRules.modelDriver_return();
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

            d=(Token)match(input,88,FOLLOW_88_in_modelDriver330); if (state.failed) return retval;
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
    public final Eml_EolParserRules.modelDeclarationParameters_return modelDeclarationParameters() throws RecognitionException {
        Eml_EolParserRules.modelDeclarationParameters_return retval = new Eml_EolParserRules.modelDeclarationParameters_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token s=null;
        Token cb=null;
        Token char_literal12=null;
        Eml_EolParserRules.modelDeclarationParameter_return modelDeclarationParameter11 = null;

        Eml_EolParserRules.modelDeclarationParameter_return modelDeclarationParameter13 = null;


        org.eclipse.epsilon.common.parse.AST s_tree=null;
        org.eclipse.epsilon.common.parse.AST cb_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal12_tree=null;

        try {
            // EolParserRules.g:132:2: (s= '{' ( modelDeclarationParameter )? ( ',' modelDeclarationParameter )* cb= '}' )
            // EolParserRules.g:132:4: s= '{' ( modelDeclarationParameter )? ( ',' modelDeclarationParameter )* cb= '}'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            s=(Token)match(input,89,FOLLOW_89_in_modelDeclarationParameters355); if (state.failed) return retval;
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

                if ( (LA7_0==87) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // EolParserRules.g:132:39: ',' modelDeclarationParameter
            	    {
            	    char_literal12=(Token)match(input,87,FOLLOW_87_in_modelDeclarationParameters362); if (state.failed) return retval;
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

            cb=(Token)match(input,90,FOLLOW_90_in_modelDeclarationParameters371); if (state.failed) return retval;

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
    public final Eml_EolParserRules.modelDeclarationParameter_return modelDeclarationParameter() throws RecognitionException {
        Eml_EolParserRules.modelDeclarationParameter_return retval = new Eml_EolParserRules.modelDeclarationParameter_return();
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
            e=(Token)match(input,91,FOLLOW_91_in_modelDeclarationParameter388); if (state.failed) return retval;
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
    public final Eml_EolParserRules.operationDeclaration_return operationDeclaration() throws RecognitionException {
        Eml_EolParserRules.operationDeclaration_return retval = new Eml_EolParserRules.operationDeclaration_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token operationName=null;
        Token op=null;
        Token cp=null;
        Token set16=null;
        Token char_literal18=null;
        Eml_EolParserRules.typeName_return ctx = null;

        Eml_EolParserRules.typeName_return returnType = null;

        Eml_EolParserRules.formalParameterList_return formalParameterList17 = null;

        Eml_EolParserRules.statementBlock_return statementBlock19 = null;


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
            if ( (input.LA(1)>=92 && input.LA(1)<=93) ) {
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

                if ( (LA8_1==NAME||(LA8_1>=99 && LA8_1<=101)) ) {
                    alt8=1;
                }
            }
            else if ( ((LA8_0>=102 && LA8_0<=109)) ) {
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
            op=(Token)match(input,94,FOLLOW_94_in_operationDeclaration434); if (state.failed) return retval;
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

            cp=(Token)match(input,95,FOLLOW_95_in_operationDeclaration442); if (state.failed) return retval;
            // EolParserRules.g:145:128: ( ':' returnType= typeName )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==96) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // EolParserRules.g:145:129: ':' returnType= typeName
                    {
                    char_literal18=(Token)match(input,96,FOLLOW_96_in_operationDeclaration446); if (state.failed) return retval;
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
    public final Eml_EolParserRules.importStatement_return importStatement() throws RecognitionException {
        Eml_EolParserRules.importStatement_return retval = new Eml_EolParserRules.importStatement_return();
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

            i=(Token)match(input,97,FOLLOW_97_in_importStatement477); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            i_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(i);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(i_tree, root_0);
            }
            STRING20=(Token)match(input,STRING,FOLLOW_STRING_in_importStatement480); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STRING20_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(STRING20);
            adaptor.addChild(root_0, STRING20_tree);
            }
            sem=(Token)match(input,85,FOLLOW_85_in_importStatement484); if (state.failed) return retval;
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
    public final Eml_EolParserRules.block_return block() throws RecognitionException {
        Eml_EolParserRules.block_return retval = new Eml_EolParserRules.block_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Eml_EolParserRules.statement_return statement21 = null;


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

                if ( (LA11_0==FLOAT||LA11_0==INT||LA11_0==BOOLEAN||LA11_0==STRING||LA11_0==NAME||LA11_0==94||(LA11_0>=102 && LA11_0<=110)||(LA11_0>=112 && LA11_0<=113)||(LA11_0>=117 && LA11_0<=125)||LA11_0==139||LA11_0==142||(LA11_0>=146 && LA11_0<=147)) ) {
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
    public final Eml_EolParserRules.statementBlock_return statementBlock() throws RecognitionException {
        Eml_EolParserRules.statementBlock_return retval = new Eml_EolParserRules.statementBlock_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token s=null;
        Token e=null;
        Eml_EolParserRules.block_return block22 = null;


        org.eclipse.epsilon.common.parse.AST s_tree=null;
        org.eclipse.epsilon.common.parse.AST e_tree=null;

        try {
            // EolParserRules.g:169:2: (s= '{' block e= '}' )
            // EolParserRules.g:169:4: s= '{' block e= '}'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            s=(Token)match(input,89,FOLLOW_89_in_statementBlock533); if (state.failed) return retval;
            pushFollow(FOLLOW_block_in_statementBlock536);
            block22=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, block22.getTree());
            e=(Token)match(input,90,FOLLOW_90_in_statementBlock540); if (state.failed) return retval;

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
    public final Eml_EolParserRules.formalParameter_return formalParameter() throws RecognitionException {
        Eml_EolParserRules.formalParameter_return retval = new Eml_EolParserRules.formalParameter_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token NAME23=null;
        Token char_literal24=null;
        Eml_EolParserRules.typeName_return pt = null;


        org.eclipse.epsilon.common.parse.AST NAME23_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal24_tree=null;
        RewriteRuleTokenStream stream_96=new RewriteRuleTokenStream(adaptor,"token 96");
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
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

            if ( (LA12_0==96) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // EolParserRules.g:176:10: ':' pt= typeName
                    {
                    char_literal24=(Token)match(input,96,FOLLOW_96_in_formalParameter561); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_96.add(char_literal24);

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
    public final Eml_EolParserRules.formalParameterList_return formalParameterList() throws RecognitionException {
        Eml_EolParserRules.formalParameterList_return retval = new Eml_EolParserRules.formalParameterList_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token char_literal26=null;
        Eml_EolParserRules.formalParameter_return formalParameter25 = null;

        Eml_EolParserRules.formalParameter_return formalParameter27 = null;


        org.eclipse.epsilon.common.parse.AST char_literal26_tree=null;
        RewriteRuleTokenStream stream_87=new RewriteRuleTokenStream(adaptor,"token 87");
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

                if ( (LA13_0==87) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // EolParserRules.g:184:21: ',' formalParameter
            	    {
            	    char_literal26=(Token)match(input,87,FOLLOW_87_in_formalParameterList602); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_87.add(char_literal26);

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
    public final Eml_EolParserRules.executableAnnotation_return executableAnnotation() throws RecognitionException {
        Eml_EolParserRules.executableAnnotation_return retval = new Eml_EolParserRules.executableAnnotation_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token d=null;
        Token x=null;
        Eml_EolParserRules.logicalExpression_return logicalExpression28 = null;


        org.eclipse.epsilon.common.parse.AST d_tree=null;
        org.eclipse.epsilon.common.parse.AST x_tree=null;

        try {
            // EolParserRules.g:189:2: (d= '$' x= . logicalExpression )
            // EolParserRules.g:189:4: d= '$' x= . logicalExpression
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            d=(Token)match(input,98,FOLLOW_98_in_executableAnnotation629); if (state.failed) return retval;
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
    public final Eml_EolParserRules.annotation_return annotation() throws RecognitionException {
        Eml_EolParserRules.annotation_return retval = new Eml_EolParserRules.annotation_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token Annotation29=null;
        Eml_EolParserRules.executableAnnotation_return executableAnnotation30 = null;


        org.eclipse.epsilon.common.parse.AST Annotation29_tree=null;

        try {
            // EolParserRules.g:194:2: ( Annotation | executableAnnotation )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==Annotation) ) {
                alt14=1;
            }
            else if ( (LA14_0==98) ) {
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
    public final Eml_EolParserRules.annotationBlock_return annotationBlock() throws RecognitionException {
        Eml_EolParserRules.annotationBlock_return retval = new Eml_EolParserRules.annotationBlock_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Eml_EolParserRules.annotation_return annotation31 = null;


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
                else if ( (LA15_0==98) ) {
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
    public final Eml_EolParserRules.typeName_return typeName() throws RecognitionException {
        Eml_EolParserRules.typeName_return retval = new Eml_EolParserRules.typeName_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Eml_EolParserRules.pathName_return pathName32 = null;

        Eml_EolParserRules.nativeType_return nativeType33 = null;

        Eml_EolParserRules.collectionType_return collectionType34 = null;



        try {
            // EolParserRules.g:209:2: ( pathName | nativeType | collectionType )
            int alt16=3;
            switch ( input.LA(1) ) {
            case NAME:
                {
                alt16=1;
                }
                break;
            case 102:
                {
                alt16=2;
                }
                break;
            case 103:
            case 104:
            case 105:
            case 106:
            case 107:
            case 108:
            case 109:
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
    public final Eml_EolParserRules.pathName_return pathName() throws RecognitionException {
        Eml_EolParserRules.pathName_return retval = new Eml_EolParserRules.pathName_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token metamodel=null;
        Token label=null;
        Token char_literal35=null;
        Token char_literal36=null;
        Eml_EolParserRules.packagedType_return head = null;


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

                if ( (LA17_1==99) ) {
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
                    char_literal35=(Token)match(input,99,FOLLOW_99_in_pathName722); if (state.failed) return retval;

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

            if ( (LA18_0==100) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // EolParserRules.g:215:4: '#' label= NAME
                    {
                    char_literal36=(Token)match(input,100,FOLLOW_100_in_pathName737); if (state.failed) return retval;
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
    public final Eml_EolParserRules.packagedType_return packagedType() throws RecognitionException {
        Eml_EolParserRules.packagedType_return retval = new Eml_EolParserRules.packagedType_return();
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

                if ( (LA19_0==101) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // EolParserRules.g:230:15: '::' field= NAME
            	    {
            	    string_literal37=(Token)match(input,101,FOLLOW_101_in_packagedType766); if (state.failed) return retval;
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
    public final Eml_EolParserRules.nativeType_return nativeType() throws RecognitionException {
        Eml_EolParserRules.nativeType_return retval = new Eml_EolParserRules.nativeType_return();
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

            string_literal38=(Token)match(input,102,FOLLOW_102_in_nativeType799); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal38_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(string_literal38);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(string_literal38_tree, root_0);
            }
            s=(Token)match(input,94,FOLLOW_94_in_nativeType804); if (state.failed) return retval;
            STRING39=(Token)match(input,STRING,FOLLOW_STRING_in_nativeType807); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STRING39_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(STRING39);
            adaptor.addChild(root_0, STRING39_tree);
            }
            e=(Token)match(input,95,FOLLOW_95_in_nativeType811); if (state.failed) return retval;

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
    // EolParserRules.g:247:1: collectionType : ( 'Collection' | 'Sequence' | 'List' | 'Bag' | 'Set' | 'OrderedSet' | 'Map' ) (op= '(' tn= typeName cp= ')' )? ;
    public final Eml_EolParserRules.collectionType_return collectionType() throws RecognitionException {
        Eml_EolParserRules.collectionType_return retval = new Eml_EolParserRules.collectionType_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token op=null;
        Token cp=null;
        Token set40=null;
        Eml_EolParserRules.typeName_return tn = null;


        org.eclipse.epsilon.common.parse.AST op_tree=null;
        org.eclipse.epsilon.common.parse.AST cp_tree=null;
        org.eclipse.epsilon.common.parse.AST set40_tree=null;

        try {
            // EolParserRules.g:253:2: ( ( 'Collection' | 'Sequence' | 'List' | 'Bag' | 'Set' | 'OrderedSet' | 'Map' ) (op= '(' tn= typeName cp= ')' )? )
            // EolParserRules.g:253:5: ( 'Collection' | 'Sequence' | 'List' | 'Bag' | 'Set' | 'OrderedSet' | 'Map' ) (op= '(' tn= typeName cp= ')' )?
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            set40=(Token)input.LT(1);
            set40=(Token)input.LT(1);
            if ( (input.LA(1)>=103 && input.LA(1)<=109) ) {
                input.consume();
                if ( state.backtracking==0 ) root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot((org.eclipse.epsilon.common.parse.AST)adaptor.create(set40), root_0);
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            // EolParserRules.g:254:3: (op= '(' tn= typeName cp= ')' )?
            int alt20=2;
            alt20 = dfa20.predict(input);
            switch (alt20) {
                case 1 :
                    // EolParserRules.g:254:4: op= '(' tn= typeName cp= ')'
                    {
                    op=(Token)match(input,94,FOLLOW_94_in_collectionType851); if (state.failed) return retval;
                    pushFollow(FOLLOW_typeName_in_collectionType856);
                    tn=typeName();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, tn.getTree());
                    if ( state.backtracking==0 ) {
                      setTokenType(tn,TYPE);
                    }
                    cp=(Token)match(input,95,FOLLOW_95_in_collectionType862); if (state.failed) return retval;

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
    public final Eml_EolParserRules.statement_return statement() throws RecognitionException {
        Eml_EolParserRules.statement_return retval = new Eml_EolParserRules.statement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Eml_EolParserRules.statementA_return statementA41 = null;

        Eml_EolParserRules.statementB_return statementB42 = null;



        try {
            // EolParserRules.g:258:2: ( statementA | statementB )
            int alt21=2;
            alt21 = dfa21.predict(input);
            switch (alt21) {
                case 1 :
                    // EolParserRules.g:258:4: statementA
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_statementA_in_statement877);
                    statementA41=statementA();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statementA41.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:258:17: statementB
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_statementB_in_statement881);
                    statementB42=statementB();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statementB42.getTree());

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
    public final Eml_EolParserRules.statementA_return statementA() throws RecognitionException {
        Eml_EolParserRules.statementA_return retval = new Eml_EolParserRules.statementA_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Eml_EolParserRules.assignmentStatement_return assignmentStatement43 = null;

        Eml_EolParserRules.expressionStatement_return expressionStatement44 = null;

        Eml_EolParserRules.forStatement_return forStatement45 = null;

        Eml_EolParserRules.ifStatement_return ifStatement46 = null;

        Eml_EolParserRules.whileStatement_return whileStatement47 = null;

        Eml_EolParserRules.switchStatement_return switchStatement48 = null;

        Eml_EolParserRules.returnStatement_return returnStatement49 = null;

        Eml_EolParserRules.breakStatement_return breakStatement50 = null;



        try {
            // EolParserRules.g:262:2: ( assignmentStatement | expressionStatement | forStatement | ifStatement | whileStatement | switchStatement | returnStatement | breakStatement )
            int alt22=8;
            alt22 = dfa22.predict(input);
            switch (alt22) {
                case 1 :
                    // EolParserRules.g:262:4: assignmentStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_assignmentStatement_in_statementA892);
                    assignmentStatement43=assignmentStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, assignmentStatement43.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:262:26: expressionStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_expressionStatement_in_statementA896);
                    expressionStatement44=expressionStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionStatement44.getTree());

                    }
                    break;
                case 3 :
                    // EolParserRules.g:262:48: forStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_forStatement_in_statementA900);
                    forStatement45=forStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, forStatement45.getTree());

                    }
                    break;
                case 4 :
                    // EolParserRules.g:263:5: ifStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_ifStatement_in_statementA906);
                    ifStatement46=ifStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, ifStatement46.getTree());

                    }
                    break;
                case 5 :
                    // EolParserRules.g:263:19: whileStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_whileStatement_in_statementA910);
                    whileStatement47=whileStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, whileStatement47.getTree());

                    }
                    break;
                case 6 :
                    // EolParserRules.g:263:36: switchStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_switchStatement_in_statementA914);
                    switchStatement48=switchStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, switchStatement48.getTree());

                    }
                    break;
                case 7 :
                    // EolParserRules.g:263:54: returnStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_returnStatement_in_statementA918);
                    returnStatement49=returnStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, returnStatement49.getTree());

                    }
                    break;
                case 8 :
                    // EolParserRules.g:263:72: breakStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_breakStatement_in_statementA922);
                    breakStatement50=breakStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, breakStatement50.getTree());

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
    public final Eml_EolParserRules.statementB_return statementB() throws RecognitionException {
        Eml_EolParserRules.statementB_return retval = new Eml_EolParserRules.statementB_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Eml_EolParserRules.breakAllStatement_return breakAllStatement51 = null;

        Eml_EolParserRules.returnStatement_return returnStatement52 = null;

        Eml_EolParserRules.transactionStatement_return transactionStatement53 = null;

        Eml_EolParserRules.abortStatement_return abortStatement54 = null;

        Eml_EolParserRules.continueStatement_return continueStatement55 = null;

        Eml_EolParserRules.throwStatement_return throwStatement56 = null;

        Eml_EolParserRules.deleteStatement_return deleteStatement57 = null;



        try {
            // EolParserRules.g:267:2: ( breakAllStatement | returnStatement | transactionStatement | abortStatement | continueStatement | throwStatement | deleteStatement )
            int alt23=7;
            switch ( input.LA(1) ) {
            case 122:
                {
                alt23=1;
                }
                break;
            case 118:
                {
                alt23=2;
                }
                break;
            case 125:
                {
                alt23=3;
                }
                break;
            case 124:
                {
                alt23=4;
                }
                break;
            case 123:
                {
                alt23=5;
                }
                break;
            case 119:
                {
                alt23=6;
                }
                break;
            case 120:
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
                    // EolParserRules.g:267:4: breakAllStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_breakAllStatement_in_statementB934);
                    breakAllStatement51=breakAllStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, breakAllStatement51.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:267:24: returnStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_returnStatement_in_statementB938);
                    returnStatement52=returnStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, returnStatement52.getTree());

                    }
                    break;
                case 3 :
                    // EolParserRules.g:267:42: transactionStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_transactionStatement_in_statementB942);
                    transactionStatement53=transactionStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, transactionStatement53.getTree());

                    }
                    break;
                case 4 :
                    // EolParserRules.g:268:5: abortStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_abortStatement_in_statementB948);
                    abortStatement54=abortStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, abortStatement54.getTree());

                    }
                    break;
                case 5 :
                    // EolParserRules.g:268:22: continueStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_continueStatement_in_statementB952);
                    continueStatement55=continueStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, continueStatement55.getTree());

                    }
                    break;
                case 6 :
                    // EolParserRules.g:268:42: throwStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_throwStatement_in_statementB956);
                    throwStatement56=throwStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, throwStatement56.getTree());

                    }
                    break;
                case 7 :
                    // EolParserRules.g:269:5: deleteStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_deleteStatement_in_statementB962);
                    deleteStatement57=deleteStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, deleteStatement57.getTree());

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
    public final Eml_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock() throws RecognitionException {
        Eml_EolParserRules.statementOrStatementBlock_return retval = new Eml_EolParserRules.statementOrStatementBlock_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Eml_EolParserRules.statement_return statement58 = null;

        Eml_EolParserRules.statementBlock_return statementBlock59 = null;



        try {
            // EolParserRules.g:273:2: ( statement | statementBlock )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==FLOAT||LA24_0==INT||LA24_0==BOOLEAN||LA24_0==STRING||LA24_0==NAME||LA24_0==94||(LA24_0>=102 && LA24_0<=110)||(LA24_0>=112 && LA24_0<=113)||(LA24_0>=117 && LA24_0<=125)||LA24_0==139||LA24_0==142||(LA24_0>=146 && LA24_0<=147)) ) {
                alt24=1;
            }
            else if ( (LA24_0==89) ) {
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
                    // EolParserRules.g:273:4: statement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_statement_in_statementOrStatementBlock973);
                    statement58=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement58.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:273:16: statementBlock
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_statementBlock_in_statementOrStatementBlock977);
                    statementBlock59=statementBlock();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statementBlock59.getTree());

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
    public final Eml_EolParserRules.expressionOrStatementBlock_return expressionOrStatementBlock() throws RecognitionException {
        Eml_EolParserRules.expressionOrStatementBlock_return retval = new Eml_EolParserRules.expressionOrStatementBlock_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token char_literal60=null;
        Eml_EolParserRules.logicalExpression_return logicalExpression61 = null;

        Eml_EolParserRules.statementBlock_return statementBlock62 = null;


        org.eclipse.epsilon.common.parse.AST char_literal60_tree=null;

        try {
            // EolParserRules.g:276:2: ( ':' logicalExpression | statementBlock )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==96) ) {
                alt25=1;
            }
            else if ( (LA25_0==89) ) {
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
                    // EolParserRules.g:276:4: ':' logicalExpression
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    char_literal60=(Token)match(input,96,FOLLOW_96_in_expressionOrStatementBlock986); if (state.failed) return retval;
                    pushFollow(FOLLOW_logicalExpression_in_expressionOrStatementBlock989);
                    logicalExpression61=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression61.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:276:29: statementBlock
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_statementBlock_in_expressionOrStatementBlock993);
                    statementBlock62=statementBlock();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statementBlock62.getTree());

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
    public final Eml_EolParserRules.forStatement_return forStatement() throws RecognitionException {
        Eml_EolParserRules.forStatement_return retval = new Eml_EolParserRules.forStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token f=null;
        Token char_literal63=null;
        Token string_literal65=null;
        Token char_literal67=null;
        Eml_EolParserRules.formalParameter_return formalParameter64 = null;

        Eml_EolParserRules.logicalExpression_return logicalExpression66 = null;

        Eml_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock68 = null;


        org.eclipse.epsilon.common.parse.AST f_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal63_tree=null;
        org.eclipse.epsilon.common.parse.AST string_literal65_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal67_tree=null;

        try {
            // EolParserRules.g:280:2: (f= 'for' '(' formalParameter 'in' logicalExpression ')' statementOrStatementBlock )
            // EolParserRules.g:280:4: f= 'for' '(' formalParameter 'in' logicalExpression ')' statementOrStatementBlock
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            f=(Token)match(input,110,FOLLOW_110_in_forStatement1006); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            f_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(f);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(f_tree, root_0);
            }
            char_literal63=(Token)match(input,94,FOLLOW_94_in_forStatement1009); if (state.failed) return retval;
            pushFollow(FOLLOW_formalParameter_in_forStatement1012);
            formalParameter64=formalParameter();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, formalParameter64.getTree());
            string_literal65=(Token)match(input,111,FOLLOW_111_in_forStatement1014); if (state.failed) return retval;
            pushFollow(FOLLOW_logicalExpression_in_forStatement1017);
            logicalExpression66=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression66.getTree());
            char_literal67=(Token)match(input,95,FOLLOW_95_in_forStatement1019); if (state.failed) return retval;
            pushFollow(FOLLOW_statementOrStatementBlock_in_forStatement1022);
            statementOrStatementBlock68=statementOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, statementOrStatementBlock68.getTree());
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
    public final Eml_EolParserRules.ifStatement_return ifStatement() throws RecognitionException {
        Eml_EolParserRules.ifStatement_return retval = new Eml_EolParserRules.ifStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token i=null;
        Token char_literal69=null;
        Token char_literal71=null;
        Eml_EolParserRules.logicalExpression_return logicalExpression70 = null;

        Eml_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock72 = null;

        Eml_EolParserRules.elseStatement_return elseStatement73 = null;


        org.eclipse.epsilon.common.parse.AST i_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal69_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal71_tree=null;

        try {
            // EolParserRules.g:285:2: (i= 'if' '(' logicalExpression ')' statementOrStatementBlock ( elseStatement )? )
            // EolParserRules.g:285:4: i= 'if' '(' logicalExpression ')' statementOrStatementBlock ( elseStatement )?
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            i=(Token)match(input,112,FOLLOW_112_in_ifStatement1038); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            i_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(i);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(i_tree, root_0);
            }
            char_literal69=(Token)match(input,94,FOLLOW_94_in_ifStatement1041); if (state.failed) return retval;
            pushFollow(FOLLOW_logicalExpression_in_ifStatement1044);
            logicalExpression70=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression70.getTree());
            char_literal71=(Token)match(input,95,FOLLOW_95_in_ifStatement1046); if (state.failed) return retval;
            pushFollow(FOLLOW_statementOrStatementBlock_in_ifStatement1049);
            statementOrStatementBlock72=statementOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, statementOrStatementBlock72.getTree());
            // EolParserRules.g:285:66: ( elseStatement )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==116) ) {
                int LA26_1 = input.LA(2);

                if ( (synpred45_EolParserRules()) ) {
                    alt26=1;
                }
            }
            switch (alt26) {
                case 1 :
                    // EolParserRules.g:0:0: elseStatement
                    {
                    pushFollow(FOLLOW_elseStatement_in_ifStatement1051);
                    elseStatement73=elseStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, elseStatement73.getTree());

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
    public final Eml_EolParserRules.switchStatement_return switchStatement() throws RecognitionException {
        Eml_EolParserRules.switchStatement_return retval = new Eml_EolParserRules.switchStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token s=null;
        Token char_literal74=null;
        Token char_literal76=null;
        Token char_literal77=null;
        Token char_literal80=null;
        Eml_EolParserRules.logicalExpression_return logicalExpression75 = null;

        Eml_EolParserRules.caseStatement_return caseStatement78 = null;

        Eml_EolParserRules.defaultStatement_return defaultStatement79 = null;


        org.eclipse.epsilon.common.parse.AST s_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal74_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal76_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal77_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal80_tree=null;

        try {
            // EolParserRules.g:290:2: (s= 'switch' '(' logicalExpression ')' '{' ( caseStatement )* ( defaultStatement )? '}' )
            // EolParserRules.g:290:4: s= 'switch' '(' logicalExpression ')' '{' ( caseStatement )* ( defaultStatement )? '}'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            s=(Token)match(input,113,FOLLOW_113_in_switchStatement1070); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            s_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(s);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(s_tree, root_0);
            }
            char_literal74=(Token)match(input,94,FOLLOW_94_in_switchStatement1073); if (state.failed) return retval;
            pushFollow(FOLLOW_logicalExpression_in_switchStatement1076);
            logicalExpression75=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression75.getTree());
            char_literal76=(Token)match(input,95,FOLLOW_95_in_switchStatement1078); if (state.failed) return retval;
            char_literal77=(Token)match(input,89,FOLLOW_89_in_switchStatement1081); if (state.failed) return retval;
            // EolParserRules.g:290:49: ( caseStatement )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==114) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // EolParserRules.g:0:0: caseStatement
            	    {
            	    pushFollow(FOLLOW_caseStatement_in_switchStatement1084);
            	    caseStatement78=caseStatement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, caseStatement78.getTree());

            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

            // EolParserRules.g:290:64: ( defaultStatement )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==115) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // EolParserRules.g:0:0: defaultStatement
                    {
                    pushFollow(FOLLOW_defaultStatement_in_switchStatement1087);
                    defaultStatement79=defaultStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, defaultStatement79.getTree());

                    }
                    break;

            }

            char_literal80=(Token)match(input,90,FOLLOW_90_in_switchStatement1090); if (state.failed) return retval;
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
    public final Eml_EolParserRules.caseStatement_return caseStatement() throws RecognitionException {
        Eml_EolParserRules.caseStatement_return retval = new Eml_EolParserRules.caseStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token c=null;
        Token char_literal82=null;
        Eml_EolParserRules.logicalExpression_return logicalExpression81 = null;

        Eml_EolParserRules.block_return block83 = null;

        Eml_EolParserRules.statementBlock_return statementBlock84 = null;


        org.eclipse.epsilon.common.parse.AST c_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal82_tree=null;

        try {
            // EolParserRules.g:295:2: (c= 'case' logicalExpression ':' ( block | statementBlock ) )
            // EolParserRules.g:295:4: c= 'case' logicalExpression ':' ( block | statementBlock )
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            c=(Token)match(input,114,FOLLOW_114_in_caseStatement1109); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            c_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(c);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(c_tree, root_0);
            }
            pushFollow(FOLLOW_logicalExpression_in_caseStatement1112);
            logicalExpression81=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression81.getTree());
            char_literal82=(Token)match(input,96,FOLLOW_96_in_caseStatement1114); if (state.failed) return retval;
            // EolParserRules.g:295:37: ( block | statementBlock )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==EOF||LA29_0==FLOAT||LA29_0==INT||LA29_0==BOOLEAN||LA29_0==STRING||LA29_0==NAME||LA29_0==90||LA29_0==94||(LA29_0>=102 && LA29_0<=110)||(LA29_0>=112 && LA29_0<=115)||(LA29_0>=117 && LA29_0<=125)||LA29_0==139||LA29_0==142||(LA29_0>=146 && LA29_0<=147)) ) {
                alt29=1;
            }
            else if ( (LA29_0==89) ) {
                alt29=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // EolParserRules.g:295:38: block
                    {
                    pushFollow(FOLLOW_block_in_caseStatement1118);
                    block83=block();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, block83.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:295:46: statementBlock
                    {
                    pushFollow(FOLLOW_statementBlock_in_caseStatement1122);
                    statementBlock84=statementBlock();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statementBlock84.getTree());

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
    public final Eml_EolParserRules.defaultStatement_return defaultStatement() throws RecognitionException {
        Eml_EolParserRules.defaultStatement_return retval = new Eml_EolParserRules.defaultStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token d=null;
        Token char_literal85=null;
        Eml_EolParserRules.block_return block86 = null;

        Eml_EolParserRules.statementBlock_return statementBlock87 = null;


        org.eclipse.epsilon.common.parse.AST d_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal85_tree=null;

        try {
            // EolParserRules.g:300:2: (d= 'default' ':' ( block | statementBlock ) )
            // EolParserRules.g:300:4: d= 'default' ':' ( block | statementBlock )
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            d=(Token)match(input,115,FOLLOW_115_in_defaultStatement1141); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            d_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(d);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(d_tree, root_0);
            }
            char_literal85=(Token)match(input,96,FOLLOW_96_in_defaultStatement1144); if (state.failed) return retval;
            // EolParserRules.g:300:22: ( block | statementBlock )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==EOF||LA30_0==FLOAT||LA30_0==INT||LA30_0==BOOLEAN||LA30_0==STRING||LA30_0==NAME||LA30_0==90||LA30_0==94||(LA30_0>=102 && LA30_0<=110)||(LA30_0>=112 && LA30_0<=115)||(LA30_0>=117 && LA30_0<=125)||LA30_0==139||LA30_0==142||(LA30_0>=146 && LA30_0<=147)) ) {
                alt30=1;
            }
            else if ( (LA30_0==89) ) {
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
                    // EolParserRules.g:300:23: block
                    {
                    pushFollow(FOLLOW_block_in_defaultStatement1148);
                    block86=block();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, block86.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:300:31: statementBlock
                    {
                    pushFollow(FOLLOW_statementBlock_in_defaultStatement1152);
                    statementBlock87=statementBlock();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statementBlock87.getTree());

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
    public final Eml_EolParserRules.elseStatement_return elseStatement() throws RecognitionException {
        Eml_EolParserRules.elseStatement_return retval = new Eml_EolParserRules.elseStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token e=null;
        Eml_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock88 = null;


        org.eclipse.epsilon.common.parse.AST e_tree=null;

        try {
            // EolParserRules.g:308:2: (e= 'else' statementOrStatementBlock )
            // EolParserRules.g:308:4: e= 'else' statementOrStatementBlock
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            e=(Token)match(input,116,FOLLOW_116_in_elseStatement1177); if (state.failed) return retval;
            pushFollow(FOLLOW_statementOrStatementBlock_in_elseStatement1180);
            statementOrStatementBlock88=statementOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, statementOrStatementBlock88.getTree());

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
    public final Eml_EolParserRules.whileStatement_return whileStatement() throws RecognitionException {
        Eml_EolParserRules.whileStatement_return retval = new Eml_EolParserRules.whileStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token w=null;
        Token char_literal89=null;
        Token char_literal91=null;
        Eml_EolParserRules.logicalExpression_return logicalExpression90 = null;

        Eml_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock92 = null;


        org.eclipse.epsilon.common.parse.AST w_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal89_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal91_tree=null;

        try {
            // EolParserRules.g:312:2: (w= 'while' '(' logicalExpression ')' statementOrStatementBlock )
            // EolParserRules.g:312:4: w= 'while' '(' logicalExpression ')' statementOrStatementBlock
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            w=(Token)match(input,117,FOLLOW_117_in_whileStatement1193); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            w_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(w);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(w_tree, root_0);
            }
            char_literal89=(Token)match(input,94,FOLLOW_94_in_whileStatement1196); if (state.failed) return retval;
            pushFollow(FOLLOW_logicalExpression_in_whileStatement1199);
            logicalExpression90=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression90.getTree());
            char_literal91=(Token)match(input,95,FOLLOW_95_in_whileStatement1201); if (state.failed) return retval;
            pushFollow(FOLLOW_statementOrStatementBlock_in_whileStatement1204);
            statementOrStatementBlock92=statementOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, statementOrStatementBlock92.getTree());
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
    public final Eml_EolParserRules.returnStatement_return returnStatement() throws RecognitionException {
        Eml_EolParserRules.returnStatement_return retval = new Eml_EolParserRules.returnStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token r=null;
        Token sem=null;
        Eml_EolParserRules.logicalExpression_return logicalExpression93 = null;


        org.eclipse.epsilon.common.parse.AST r_tree=null;
        org.eclipse.epsilon.common.parse.AST sem_tree=null;

        try {
            // EolParserRules.g:320:2: (r= 'return' ( logicalExpression )? sem= ';' )
            // EolParserRules.g:320:4: r= 'return' ( logicalExpression )? sem= ';'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            r=(Token)match(input,118,FOLLOW_118_in_returnStatement1226); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            r_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(r);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(r_tree, root_0);
            }
            // EolParserRules.g:320:16: ( logicalExpression )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==FLOAT||LA31_0==INT||LA31_0==BOOLEAN||LA31_0==STRING||LA31_0==NAME||LA31_0==94||(LA31_0>=102 && LA31_0<=109)||LA31_0==139||LA31_0==142||(LA31_0>=146 && LA31_0<=147)) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // EolParserRules.g:0:0: logicalExpression
                    {
                    pushFollow(FOLLOW_logicalExpression_in_returnStatement1229);
                    logicalExpression93=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression93.getTree());

                    }
                    break;

            }

            sem=(Token)match(input,85,FOLLOW_85_in_returnStatement1234); if (state.failed) return retval;
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
    public final Eml_EolParserRules.throwStatement_return throwStatement() throws RecognitionException {
        Eml_EolParserRules.throwStatement_return retval = new Eml_EolParserRules.throwStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token t=null;
        Token sem=null;
        Eml_EolParserRules.logicalExpression_return logicalExpression94 = null;


        org.eclipse.epsilon.common.parse.AST t_tree=null;
        org.eclipse.epsilon.common.parse.AST sem_tree=null;

        try {
            // EolParserRules.g:328:2: (t= 'throw' ( logicalExpression )? sem= ';' )
            // EolParserRules.g:328:4: t= 'throw' ( logicalExpression )? sem= ';'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            t=(Token)match(input,119,FOLLOW_119_in_throwStatement1257); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            t_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(t);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(t_tree, root_0);
            }
            // EolParserRules.g:328:15: ( logicalExpression )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==FLOAT||LA32_0==INT||LA32_0==BOOLEAN||LA32_0==STRING||LA32_0==NAME||LA32_0==94||(LA32_0>=102 && LA32_0<=109)||LA32_0==139||LA32_0==142||(LA32_0>=146 && LA32_0<=147)) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // EolParserRules.g:0:0: logicalExpression
                    {
                    pushFollow(FOLLOW_logicalExpression_in_throwStatement1260);
                    logicalExpression94=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression94.getTree());

                    }
                    break;

            }

            sem=(Token)match(input,85,FOLLOW_85_in_throwStatement1265); if (state.failed) return retval;
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
    public final Eml_EolParserRules.deleteStatement_return deleteStatement() throws RecognitionException {
        Eml_EolParserRules.deleteStatement_return retval = new Eml_EolParserRules.deleteStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token d=null;
        Token sem=null;
        Eml_EolParserRules.logicalExpression_return logicalExpression95 = null;


        org.eclipse.epsilon.common.parse.AST d_tree=null;
        org.eclipse.epsilon.common.parse.AST sem_tree=null;

        try {
            // EolParserRules.g:336:2: (d= 'delete' ( logicalExpression )? sem= ';' )
            // EolParserRules.g:336:4: d= 'delete' ( logicalExpression )? sem= ';'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            d=(Token)match(input,120,FOLLOW_120_in_deleteStatement1288); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            d_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(d);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(d_tree, root_0);
            }
            // EolParserRules.g:336:16: ( logicalExpression )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==FLOAT||LA33_0==INT||LA33_0==BOOLEAN||LA33_0==STRING||LA33_0==NAME||LA33_0==94||(LA33_0>=102 && LA33_0<=109)||LA33_0==139||LA33_0==142||(LA33_0>=146 && LA33_0<=147)) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // EolParserRules.g:0:0: logicalExpression
                    {
                    pushFollow(FOLLOW_logicalExpression_in_deleteStatement1291);
                    logicalExpression95=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression95.getTree());

                    }
                    break;

            }

            sem=(Token)match(input,85,FOLLOW_85_in_deleteStatement1296); if (state.failed) return retval;
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
    public final Eml_EolParserRules.breakStatement_return breakStatement() throws RecognitionException {
        Eml_EolParserRules.breakStatement_return retval = new Eml_EolParserRules.breakStatement_return();
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

            b=(Token)match(input,121,FOLLOW_121_in_breakStatement1322); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            b_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(b);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(b_tree, root_0);
            }
            sem=(Token)match(input,85,FOLLOW_85_in_breakStatement1327); if (state.failed) return retval;
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
    public final Eml_EolParserRules.breakAllStatement_return breakAllStatement() throws RecognitionException {
        Eml_EolParserRules.breakAllStatement_return retval = new Eml_EolParserRules.breakAllStatement_return();
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

            b=(Token)match(input,122,FOLLOW_122_in_breakAllStatement1350); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            b_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(b);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(b_tree, root_0);
            }
            sem=(Token)match(input,85,FOLLOW_85_in_breakAllStatement1355); if (state.failed) return retval;
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
    public final Eml_EolParserRules.continueStatement_return continueStatement() throws RecognitionException {
        Eml_EolParserRules.continueStatement_return retval = new Eml_EolParserRules.continueStatement_return();
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

            c=(Token)match(input,123,FOLLOW_123_in_continueStatement1378); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            c_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(c);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(c_tree, root_0);
            }
            sem=(Token)match(input,85,FOLLOW_85_in_continueStatement1383); if (state.failed) return retval;
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
    public final Eml_EolParserRules.abortStatement_return abortStatement() throws RecognitionException {
        Eml_EolParserRules.abortStatement_return retval = new Eml_EolParserRules.abortStatement_return();
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

            a=(Token)match(input,124,FOLLOW_124_in_abortStatement1406); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            a_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(a);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(a_tree, root_0);
            }
            sem=(Token)match(input,85,FOLLOW_85_in_abortStatement1411); if (state.failed) return retval;
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
    public final Eml_EolParserRules.transactionStatement_return transactionStatement() throws RecognitionException {
        Eml_EolParserRules.transactionStatement_return retval = new Eml_EolParserRules.transactionStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token t=null;
        Token NAME96=null;
        Token char_literal97=null;
        Token NAME98=null;
        Eml_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock99 = null;


        org.eclipse.epsilon.common.parse.AST t_tree=null;
        org.eclipse.epsilon.common.parse.AST NAME96_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal97_tree=null;
        org.eclipse.epsilon.common.parse.AST NAME98_tree=null;

        try {
            // EolParserRules.g:373:2: (t= 'transaction' ( NAME ( ',' NAME )* )? statementOrStatementBlock )
            // EolParserRules.g:373:4: t= 'transaction' ( NAME ( ',' NAME )* )? statementOrStatementBlock
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            t=(Token)match(input,125,FOLLOW_125_in_transactionStatement1428); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            t_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(t);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(t_tree, root_0);
            }
            // EolParserRules.g:373:21: ( NAME ( ',' NAME )* )?
            int alt35=2;
            alt35 = dfa35.predict(input);
            switch (alt35) {
                case 1 :
                    // EolParserRules.g:373:22: NAME ( ',' NAME )*
                    {
                    NAME96=(Token)match(input,NAME,FOLLOW_NAME_in_transactionStatement1432); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NAME96_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(NAME96);
                    adaptor.addChild(root_0, NAME96_tree);
                    }
                    // EolParserRules.g:373:27: ( ',' NAME )*
                    loop34:
                    do {
                        int alt34=2;
                        int LA34_0 = input.LA(1);

                        if ( (LA34_0==87) ) {
                            alt34=1;
                        }


                        switch (alt34) {
                    	case 1 :
                    	    // EolParserRules.g:373:28: ',' NAME
                    	    {
                    	    char_literal97=(Token)match(input,87,FOLLOW_87_in_transactionStatement1435); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal97_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(char_literal97);
                    	    adaptor.addChild(root_0, char_literal97_tree);
                    	    }
                    	    NAME98=(Token)match(input,NAME,FOLLOW_NAME_in_transactionStatement1437); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    NAME98_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(NAME98);
                    	    adaptor.addChild(root_0, NAME98_tree);
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop34;
                        }
                    } while (true);


                    }
                    break;

            }

            pushFollow(FOLLOW_statementOrStatementBlock_in_transactionStatement1443);
            statementOrStatementBlock99=statementOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, statementOrStatementBlock99.getTree());
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
    public final Eml_EolParserRules.assignmentStatement_return assignmentStatement() throws RecognitionException {
        Eml_EolParserRules.assignmentStatement_return retval = new Eml_EolParserRules.assignmentStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token normal=null;
        Token special=null;
        Token sem=null;
        Eml_EolParserRules.logicalExpression_return logicalExpression100 = null;

        Eml_EolParserRules.logicalExpression_return logicalExpression101 = null;


        org.eclipse.epsilon.common.parse.AST normal_tree=null;
        org.eclipse.epsilon.common.parse.AST special_tree=null;
        org.eclipse.epsilon.common.parse.AST sem_tree=null;

        try {
            // EolParserRules.g:381:2: ( logicalExpression (normal= ':=' | special= '::=' ) logicalExpression sem= ';' )
            // EolParserRules.g:381:4: logicalExpression (normal= ':=' | special= '::=' ) logicalExpression sem= ';'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            pushFollow(FOLLOW_logicalExpression_in_assignmentStatement1463);
            logicalExpression100=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression100.getTree());
            // EolParserRules.g:381:22: (normal= ':=' | special= '::=' )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==126) ) {
                alt36=1;
            }
            else if ( (LA36_0==127) ) {
                alt36=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }
            switch (alt36) {
                case 1 :
                    // EolParserRules.g:381:23: normal= ':='
                    {
                    normal=(Token)match(input,126,FOLLOW_126_in_assignmentStatement1468); if (state.failed) return retval;
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
                    special=(Token)match(input,127,FOLLOW_127_in_assignmentStatement1475); if (state.failed) return retval;
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

            pushFollow(FOLLOW_logicalExpression_in_assignmentStatement1481);
            logicalExpression101=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression101.getTree());
            sem=(Token)match(input,85,FOLLOW_85_in_assignmentStatement1485); if (state.failed) return retval;

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
    public final Eml_EolParserRules.expressionStatement_return expressionStatement() throws RecognitionException {
        Eml_EolParserRules.expressionStatement_return retval = new Eml_EolParserRules.expressionStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token op=null;
        Token sem=null;
        Eml_EolParserRules.postfixExpression_return postfixExpression102 = null;

        Eml_EolParserRules.logicalExpression_return logicalExpression103 = null;

        Eml_EolParserRules.logicalExpression_return logicalExpression104 = null;


        org.eclipse.epsilon.common.parse.AST op_tree=null;
        org.eclipse.epsilon.common.parse.AST sem_tree=null;

        try {
            // EolParserRules.g:389:2: ( ( postfixExpression op= '=' logicalExpression | logicalExpression ) sem= ';' )
            // EolParserRules.g:389:4: ( postfixExpression op= '=' logicalExpression | logicalExpression ) sem= ';'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            // EolParserRules.g:389:4: ( postfixExpression op= '=' logicalExpression | logicalExpression )
            int alt37=2;
            alt37 = dfa37.predict(input);
            switch (alt37) {
                case 1 :
                    // EolParserRules.g:389:5: postfixExpression op= '=' logicalExpression
                    {
                    pushFollow(FOLLOW_postfixExpression_in_expressionStatement1507);
                    postfixExpression102=postfixExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, postfixExpression102.getTree());
                    op=(Token)match(input,91,FOLLOW_91_in_expressionStatement1511); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
                    }
                    pushFollow(FOLLOW_logicalExpression_in_expressionStatement1514);
                    logicalExpression103=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression103.getTree());
                    if ( state.backtracking==0 ) {
                      op.setType(OPERATOR);
                    }

                    }
                    break;
                case 2 :
                    // EolParserRules.g:389:76: logicalExpression
                    {
                    pushFollow(FOLLOW_logicalExpression_in_expressionStatement1520);
                    logicalExpression104=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression104.getTree());

                    }
                    break;

            }

            sem=(Token)match(input,85,FOLLOW_85_in_expressionStatement1525); if (state.failed) return retval;

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
    public final Eml_EolParserRules.logicalExpression_return logicalExpression() throws RecognitionException {
        Eml_EolParserRules.logicalExpression_return retval = new Eml_EolParserRules.logicalExpression_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token op=null;
        Eml_EolParserRules.relationalExpression_return relationalExpression105 = null;

        Eml_EolParserRules.relationalExpression_return relationalExpression106 = null;


        org.eclipse.epsilon.common.parse.AST op_tree=null;

        try {
            // EolParserRules.g:393:2: ( relationalExpression ( (op= 'or' | op= 'and' | op= 'xor' | op= 'implies' ) relationalExpression )* )
            // EolParserRules.g:393:4: relationalExpression ( (op= 'or' | op= 'and' | op= 'xor' | op= 'implies' ) relationalExpression )*
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            pushFollow(FOLLOW_relationalExpression_in_logicalExpression1537);
            relationalExpression105=relationalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, relationalExpression105.getTree());
            // EolParserRules.g:393:25: ( (op= 'or' | op= 'and' | op= 'xor' | op= 'implies' ) relationalExpression )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( ((LA39_0>=128 && LA39_0<=131)) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // EolParserRules.g:393:26: (op= 'or' | op= 'and' | op= 'xor' | op= 'implies' ) relationalExpression
            	    {
            	    // EolParserRules.g:393:26: (op= 'or' | op= 'and' | op= 'xor' | op= 'implies' )
            	    int alt38=4;
            	    switch ( input.LA(1) ) {
            	    case 128:
            	        {
            	        alt38=1;
            	        }
            	        break;
            	    case 129:
            	        {
            	        alt38=2;
            	        }
            	        break;
            	    case 130:
            	        {
            	        alt38=3;
            	        }
            	        break;
            	    case 131:
            	        {
            	        alt38=4;
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
            	            // EolParserRules.g:393:27: op= 'or'
            	            {
            	            op=(Token)match(input,128,FOLLOW_128_in_logicalExpression1543); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // EolParserRules.g:393:36: op= 'and'
            	            {
            	            op=(Token)match(input,129,FOLLOW_129_in_logicalExpression1548); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // EolParserRules.g:393:46: op= 'xor'
            	            {
            	            op=(Token)match(input,130,FOLLOW_130_in_logicalExpression1553); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 4 :
            	            // EolParserRules.g:393:56: op= 'implies'
            	            {
            	            op=(Token)match(input,131,FOLLOW_131_in_logicalExpression1558); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_relationalExpression_in_logicalExpression1562);
            	    relationalExpression106=relationalExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, relationalExpression106.getTree());
            	    if ( state.backtracking==0 ) {
            	      op.setType(OPERATOR);
            	    }

            	    }
            	    break;

            	default :
            	    break loop39;
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
    public final Eml_EolParserRules.relationalExpression_return relationalExpression() throws RecognitionException {
        Eml_EolParserRules.relationalExpression_return retval = new Eml_EolParserRules.relationalExpression_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token op=null;
        Eml_EolParserRules.additiveExpression_return additiveExpression107 = null;

        Eml_EolParserRules.relationalExpression_return relationalExpression108 = null;

        Eml_EolParserRules.relationalExpression_return relationalExpression109 = null;

        Eml_EolParserRules.additiveExpression_return additiveExpression110 = null;


        org.eclipse.epsilon.common.parse.AST op_tree=null;

        try {
            // EolParserRules.g:398:2: ( additiveExpression ( (op= '==' relationalExpression | op= '=' relationalExpression | (op= '>' | op= '<' | op= '>=' | op= '<=' | op= '<>' ) additiveExpression ) )* )
            // EolParserRules.g:398:4: additiveExpression ( (op= '==' relationalExpression | op= '=' relationalExpression | (op= '>' | op= '<' | op= '>=' | op= '<=' | op= '<>' ) additiveExpression ) )*
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            pushFollow(FOLLOW_additiveExpression_in_relationalExpression1579);
            additiveExpression107=additiveExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, additiveExpression107.getTree());
            // EolParserRules.g:398:23: ( (op= '==' relationalExpression | op= '=' relationalExpression | (op= '>' | op= '<' | op= '>=' | op= '<=' | op= '<>' ) additiveExpression ) )*
            loop42:
            do {
                int alt42=2;
                alt42 = dfa42.predict(input);
                switch (alt42) {
            	case 1 :
            	    // EolParserRules.g:398:24: (op= '==' relationalExpression | op= '=' relationalExpression | (op= '>' | op= '<' | op= '>=' | op= '<=' | op= '<>' ) additiveExpression )
            	    {
            	    // EolParserRules.g:398:24: (op= '==' relationalExpression | op= '=' relationalExpression | (op= '>' | op= '<' | op= '>=' | op= '<=' | op= '<>' ) additiveExpression )
            	    int alt41=3;
            	    switch ( input.LA(1) ) {
            	    case 132:
            	        {
            	        alt41=1;
            	        }
            	        break;
            	    case 91:
            	        {
            	        alt41=2;
            	        }
            	        break;
            	    case 133:
            	    case 134:
            	    case 135:
            	    case 136:
            	    case 137:
            	        {
            	        alt41=3;
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
            	            // EolParserRules.g:398:25: op= '==' relationalExpression
            	            {
            	            op=(Token)match(input,132,FOLLOW_132_in_relationalExpression1585); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	            }
            	            pushFollow(FOLLOW_relationalExpression_in_relationalExpression1588);
            	            relationalExpression108=relationalExpression();

            	            state._fsp--;
            	            if (state.failed) return retval;
            	            if ( state.backtracking==0 ) adaptor.addChild(root_0, relationalExpression108.getTree());

            	            }
            	            break;
            	        case 2 :
            	            // EolParserRules.g:398:57: op= '=' relationalExpression
            	            {
            	            op=(Token)match(input,91,FOLLOW_91_in_relationalExpression1594); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	            }
            	            pushFollow(FOLLOW_relationalExpression_in_relationalExpression1597);
            	            relationalExpression109=relationalExpression();

            	            state._fsp--;
            	            if (state.failed) return retval;
            	            if ( state.backtracking==0 ) adaptor.addChild(root_0, relationalExpression109.getTree());

            	            }
            	            break;
            	        case 3 :
            	            // EolParserRules.g:399:24: (op= '>' | op= '<' | op= '>=' | op= '<=' | op= '<>' ) additiveExpression
            	            {
            	            // EolParserRules.g:399:24: (op= '>' | op= '<' | op= '>=' | op= '<=' | op= '<>' )
            	            int alt40=5;
            	            switch ( input.LA(1) ) {
            	            case 133:
            	                {
            	                alt40=1;
            	                }
            	                break;
            	            case 134:
            	                {
            	                alt40=2;
            	                }
            	                break;
            	            case 135:
            	                {
            	                alt40=3;
            	                }
            	                break;
            	            case 136:
            	                {
            	                alt40=4;
            	                }
            	                break;
            	            case 137:
            	                {
            	                alt40=5;
            	                }
            	                break;
            	            default:
            	                if (state.backtracking>0) {state.failed=true; return retval;}
            	                NoViableAltException nvae =
            	                    new NoViableAltException("", 40, 0, input);

            	                throw nvae;
            	            }

            	            switch (alt40) {
            	                case 1 :
            	                    // EolParserRules.g:399:25: op= '>'
            	                    {
            	                    op=(Token)match(input,133,FOLLOW_133_in_relationalExpression1627); if (state.failed) return retval;
            	                    if ( state.backtracking==0 ) {
            	                    op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	                    }

            	                    }
            	                    break;
            	                case 2 :
            	                    // EolParserRules.g:399:33: op= '<'
            	                    {
            	                    op=(Token)match(input,134,FOLLOW_134_in_relationalExpression1632); if (state.failed) return retval;
            	                    if ( state.backtracking==0 ) {
            	                    op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	                    }

            	                    }
            	                    break;
            	                case 3 :
            	                    // EolParserRules.g:399:41: op= '>='
            	                    {
            	                    op=(Token)match(input,135,FOLLOW_135_in_relationalExpression1637); if (state.failed) return retval;
            	                    if ( state.backtracking==0 ) {
            	                    op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	                    }

            	                    }
            	                    break;
            	                case 4 :
            	                    // EolParserRules.g:399:50: op= '<='
            	                    {
            	                    op=(Token)match(input,136,FOLLOW_136_in_relationalExpression1642); if (state.failed) return retval;
            	                    if ( state.backtracking==0 ) {
            	                    op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	                    }

            	                    }
            	                    break;
            	                case 5 :
            	                    // EolParserRules.g:399:59: op= '<>'
            	                    {
            	                    op=(Token)match(input,137,FOLLOW_137_in_relationalExpression1647); if (state.failed) return retval;
            	                    if ( state.backtracking==0 ) {
            	                    op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	                    }

            	                    }
            	                    break;

            	            }

            	            pushFollow(FOLLOW_additiveExpression_in_relationalExpression1651);
            	            additiveExpression110=additiveExpression();

            	            state._fsp--;
            	            if (state.failed) return retval;
            	            if ( state.backtracking==0 ) adaptor.addChild(root_0, additiveExpression110.getTree());

            	            }
            	            break;

            	    }

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
    // $ANTLR end relationalExpression

    public static class additiveExpression_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start additiveExpression
    // EolParserRules.g:403:1: additiveExpression : multiplicativeExpression ( (op= '+' | op= '-' ) multiplicativeExpression )* ;
    public final Eml_EolParserRules.additiveExpression_return additiveExpression() throws RecognitionException {
        Eml_EolParserRules.additiveExpression_return retval = new Eml_EolParserRules.additiveExpression_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token op=null;
        Eml_EolParserRules.multiplicativeExpression_return multiplicativeExpression111 = null;

        Eml_EolParserRules.multiplicativeExpression_return multiplicativeExpression112 = null;


        org.eclipse.epsilon.common.parse.AST op_tree=null;

        try {
            // EolParserRules.g:404:2: ( multiplicativeExpression ( (op= '+' | op= '-' ) multiplicativeExpression )* )
            // EolParserRules.g:404:4: multiplicativeExpression ( (op= '+' | op= '-' ) multiplicativeExpression )*
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            pushFollow(FOLLOW_multiplicativeExpression_in_additiveExpression1669);
            multiplicativeExpression111=multiplicativeExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, multiplicativeExpression111.getTree());
            // EolParserRules.g:404:29: ( (op= '+' | op= '-' ) multiplicativeExpression )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( ((LA44_0>=138 && LA44_0<=139)) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // EolParserRules.g:404:30: (op= '+' | op= '-' ) multiplicativeExpression
            	    {
            	    // EolParserRules.g:404:30: (op= '+' | op= '-' )
            	    int alt43=2;
            	    int LA43_0 = input.LA(1);

            	    if ( (LA43_0==138) ) {
            	        alt43=1;
            	    }
            	    else if ( (LA43_0==139) ) {
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
            	            // EolParserRules.g:404:31: op= '+'
            	            {
            	            op=(Token)match(input,138,FOLLOW_138_in_additiveExpression1675); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // EolParserRules.g:404:39: op= '-'
            	            {
            	            op=(Token)match(input,139,FOLLOW_139_in_additiveExpression1680); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_multiplicativeExpression_in_additiveExpression1684);
            	    multiplicativeExpression112=multiplicativeExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, multiplicativeExpression112.getTree());
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
    // $ANTLR end additiveExpression

    public static class multiplicativeExpression_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start multiplicativeExpression
    // EolParserRules.g:408:1: multiplicativeExpression : unaryExpression ( (op= '*' | op= '/' ) unaryExpression )* ;
    public final Eml_EolParserRules.multiplicativeExpression_return multiplicativeExpression() throws RecognitionException {
        Eml_EolParserRules.multiplicativeExpression_return retval = new Eml_EolParserRules.multiplicativeExpression_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token op=null;
        Eml_EolParserRules.unaryExpression_return unaryExpression113 = null;

        Eml_EolParserRules.unaryExpression_return unaryExpression114 = null;


        org.eclipse.epsilon.common.parse.AST op_tree=null;

        try {
            // EolParserRules.g:409:2: ( unaryExpression ( (op= '*' | op= '/' ) unaryExpression )* )
            // EolParserRules.g:409:4: unaryExpression ( (op= '*' | op= '/' ) unaryExpression )*
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            pushFollow(FOLLOW_unaryExpression_in_multiplicativeExpression1702);
            unaryExpression113=unaryExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, unaryExpression113.getTree());
            // EolParserRules.g:409:20: ( (op= '*' | op= '/' ) unaryExpression )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( ((LA46_0>=140 && LA46_0<=141)) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // EolParserRules.g:409:21: (op= '*' | op= '/' ) unaryExpression
            	    {
            	    // EolParserRules.g:409:21: (op= '*' | op= '/' )
            	    int alt45=2;
            	    int LA45_0 = input.LA(1);

            	    if ( (LA45_0==140) ) {
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
            	            // EolParserRules.g:409:22: op= '*'
            	            {
            	            op=(Token)match(input,140,FOLLOW_140_in_multiplicativeExpression1708); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // EolParserRules.g:409:30: op= '/'
            	            {
            	            op=(Token)match(input,141,FOLLOW_141_in_multiplicativeExpression1713); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_unaryExpression_in_multiplicativeExpression1717);
            	    unaryExpression114=unaryExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, unaryExpression114.getTree());
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
    // $ANTLR end multiplicativeExpression

    public static class unaryExpression_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start unaryExpression
    // EolParserRules.g:413:1: unaryExpression : ( (op= 'not' | op= '-' ) )? postfixExpression ;
    public final Eml_EolParserRules.unaryExpression_return unaryExpression() throws RecognitionException {
        Eml_EolParserRules.unaryExpression_return retval = new Eml_EolParserRules.unaryExpression_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token op=null;
        Eml_EolParserRules.postfixExpression_return postfixExpression115 = null;


        org.eclipse.epsilon.common.parse.AST op_tree=null;

        try {
            // EolParserRules.g:414:2: ( ( (op= 'not' | op= '-' ) )? postfixExpression )
            // EolParserRules.g:414:4: ( (op= 'not' | op= '-' ) )? postfixExpression
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            // EolParserRules.g:414:4: ( (op= 'not' | op= '-' ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==139||LA48_0==142) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // EolParserRules.g:414:5: (op= 'not' | op= '-' )
                    {
                    // EolParserRules.g:414:5: (op= 'not' | op= '-' )
                    int alt47=2;
                    int LA47_0 = input.LA(1);

                    if ( (LA47_0==142) ) {
                        alt47=1;
                    }
                    else if ( (LA47_0==139) ) {
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
                            // EolParserRules.g:414:6: op= 'not'
                            {
                            op=(Token)match(input,142,FOLLOW_142_in_unaryExpression1738); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
                            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
                            }

                            }
                            break;
                        case 2 :
                            // EolParserRules.g:414:16: op= '-'
                            {
                            op=(Token)match(input,139,FOLLOW_139_in_unaryExpression1743); if (state.failed) return retval;
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

            pushFollow(FOLLOW_postfixExpression_in_unaryExpression1751);
            postfixExpression115=postfixExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, postfixExpression115.getTree());

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
    public final Eml_EolParserRules.postfixExpression_return postfixExpression() throws RecognitionException {
        Eml_EolParserRules.postfixExpression_return retval = new Eml_EolParserRules.postfixExpression_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token is=null;
        Token set117=null;
        Token char_literal119=null;
        Eml_EolParserRules.featureCall_return fc = null;

        Eml_EolParserRules.itemSelectorExpression_return itemSelectorExpression116 = null;

        Eml_EolParserRules.logicalExpression_return logicalExpression118 = null;


        org.eclipse.epsilon.common.parse.AST is_tree=null;
        org.eclipse.epsilon.common.parse.AST set117_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal119_tree=null;

        try {
            // EolParserRules.g:418:2: ( itemSelectorExpression ( ( POINT | ARROW ) fc= featureCall (is= '[' logicalExpression ']' )* )* )
            // EolParserRules.g:418:4: itemSelectorExpression ( ( POINT | ARROW ) fc= featureCall (is= '[' logicalExpression ']' )* )*
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            pushFollow(FOLLOW_itemSelectorExpression_in_postfixExpression1763);
            itemSelectorExpression116=itemSelectorExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, itemSelectorExpression116.getTree());
            // EolParserRules.g:418:27: ( ( POINT | ARROW ) fc= featureCall (is= '[' logicalExpression ']' )* )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==POINT||LA50_0==ARROW) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // EolParserRules.g:418:28: ( POINT | ARROW ) fc= featureCall (is= '[' logicalExpression ']' )*
            	    {
            	    set117=(Token)input.LT(1);
            	    set117=(Token)input.LT(1);
            	    if ( input.LA(1)==POINT||input.LA(1)==ARROW ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot((org.eclipse.epsilon.common.parse.AST)adaptor.create(set117), root_0);
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_featureCall_in_postfixExpression1775);
            	    fc=featureCall();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, fc.getTree());
            	    if ( state.backtracking==0 ) {
            	      setTokenType(fc,FEATURECALL);
            	    }
            	    // EolParserRules.g:419:35: (is= '[' logicalExpression ']' )*
            	    loop49:
            	    do {
            	        int alt49=2;
            	        int LA49_0 = input.LA(1);

            	        if ( (LA49_0==143) ) {
            	            alt49=1;
            	        }


            	        switch (alt49) {
            	    	case 1 :
            	    	    // EolParserRules.g:419:36: is= '[' logicalExpression ']'
            	    	    {
            	    	    is=(Token)match(input,143,FOLLOW_143_in_postfixExpression1784); if (state.failed) return retval;
            	    	    if ( state.backtracking==0 ) {
            	    	    is_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(is);
            	    	    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(is_tree, root_0);
            	    	    }
            	    	    pushFollow(FOLLOW_logicalExpression_in_postfixExpression1787);
            	    	    logicalExpression118=logicalExpression();

            	    	    state._fsp--;
            	    	    if (state.failed) return retval;
            	    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression118.getTree());
            	    	    char_literal119=(Token)match(input,144,FOLLOW_144_in_postfixExpression1789); if (state.failed) return retval;
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
    // $ANTLR end postfixExpression

    public static class itemSelectorExpression_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start itemSelectorExpression
    // EolParserRules.g:423:1: itemSelectorExpression : primitiveExpression (is= '[' primitiveExpression ']' )* ;
    public final Eml_EolParserRules.itemSelectorExpression_return itemSelectorExpression() throws RecognitionException {
        Eml_EolParserRules.itemSelectorExpression_return retval = new Eml_EolParserRules.itemSelectorExpression_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token is=null;
        Token char_literal122=null;
        Eml_EolParserRules.primitiveExpression_return primitiveExpression120 = null;

        Eml_EolParserRules.primitiveExpression_return primitiveExpression121 = null;


        org.eclipse.epsilon.common.parse.AST is_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal122_tree=null;

        try {
            // EolParserRules.g:424:2: ( primitiveExpression (is= '[' primitiveExpression ']' )* )
            // EolParserRules.g:424:4: primitiveExpression (is= '[' primitiveExpression ']' )*
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            pushFollow(FOLLOW_primitiveExpression_in_itemSelectorExpression1811);
            primitiveExpression120=primitiveExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, primitiveExpression120.getTree());
            // EolParserRules.g:424:24: (is= '[' primitiveExpression ']' )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==143) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // EolParserRules.g:424:25: is= '[' primitiveExpression ']'
            	    {
            	    is=(Token)match(input,143,FOLLOW_143_in_itemSelectorExpression1816); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    is_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(is);
            	    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(is_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_primitiveExpression_in_itemSelectorExpression1819);
            	    primitiveExpression121=primitiveExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, primitiveExpression121.getTree());
            	    char_literal122=(Token)match(input,144,FOLLOW_144_in_itemSelectorExpression1821); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	      is.setType(ITEMSELECTOR);
            	    }

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
    // $ANTLR end itemSelectorExpression

    public static class featureCall_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start featureCall
    // EolParserRules.g:428:1: featureCall : ( simpleFeatureCall | declarativeFeatureCall );
    public final Eml_EolParserRules.featureCall_return featureCall() throws RecognitionException {
        Eml_EolParserRules.featureCall_return retval = new Eml_EolParserRules.featureCall_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Eml_EolParserRules.simpleFeatureCall_return simpleFeatureCall123 = null;

        Eml_EolParserRules.declarativeFeatureCall_return declarativeFeatureCall124 = null;



        try {
            // EolParserRules.g:429:2: ( simpleFeatureCall | declarativeFeatureCall )
            int alt52=2;
            alt52 = dfa52.predict(input);
            switch (alt52) {
                case 1 :
                    // EolParserRules.g:429:4: simpleFeatureCall
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_simpleFeatureCall_in_featureCall1840);
                    simpleFeatureCall123=simpleFeatureCall();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, simpleFeatureCall123.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:429:24: declarativeFeatureCall
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_declarativeFeatureCall_in_featureCall1844);
                    declarativeFeatureCall124=declarativeFeatureCall();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, declarativeFeatureCall124.getTree());

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
    public final Eml_EolParserRules.simpleFeatureCall_return simpleFeatureCall() throws RecognitionException {
        Eml_EolParserRules.simpleFeatureCall_return retval = new Eml_EolParserRules.simpleFeatureCall_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token n=null;
        Eml_EolParserRules.parameterList_return parameterList125 = null;


        org.eclipse.epsilon.common.parse.AST n_tree=null;

        try {
            // EolParserRules.g:433:2: (n= NAME ( parameterList )? )
            // EolParserRules.g:433:5: n= NAME ( parameterList )?
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            n=(Token)match(input,NAME,FOLLOW_NAME_in_simpleFeatureCall1858); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            n_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(n);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(n_tree, root_0);
            }
            // EolParserRules.g:433:13: ( parameterList )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==94) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // EolParserRules.g:0:0: parameterList
                    {
                    pushFollow(FOLLOW_parameterList_in_simpleFeatureCall1861);
                    parameterList125=parameterList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, parameterList125.getTree());

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
    public final Eml_EolParserRules.parameterList_return parameterList() throws RecognitionException {
        Eml_EolParserRules.parameterList_return retval = new Eml_EolParserRules.parameterList_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token op=null;
        Token cp=null;
        Token char_literal127=null;
        Eml_EolParserRules.logicalExpression_return logicalExpression126 = null;

        Eml_EolParserRules.logicalExpression_return logicalExpression128 = null;


        org.eclipse.epsilon.common.parse.AST op_tree=null;
        org.eclipse.epsilon.common.parse.AST cp_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal127_tree=null;
        RewriteRuleTokenStream stream_94=new RewriteRuleTokenStream(adaptor,"token 94");
        RewriteRuleTokenStream stream_95=new RewriteRuleTokenStream(adaptor,"token 95");
        RewriteRuleTokenStream stream_87=new RewriteRuleTokenStream(adaptor,"token 87");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:443:2: (op= '(' ( logicalExpression ( ',' logicalExpression )* )? cp= ')' -> ^( PARAMETERS ( logicalExpression )* ) )
            // EolParserRules.g:443:4: op= '(' ( logicalExpression ( ',' logicalExpression )* )? cp= ')'
            {
            op=(Token)match(input,94,FOLLOW_94_in_parameterList1884); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_94.add(op);

            // EolParserRules.g:443:11: ( logicalExpression ( ',' logicalExpression )* )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==FLOAT||LA55_0==INT||LA55_0==BOOLEAN||LA55_0==STRING||LA55_0==NAME||LA55_0==94||(LA55_0>=102 && LA55_0<=109)||LA55_0==139||LA55_0==142||(LA55_0>=146 && LA55_0<=147)) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // EolParserRules.g:443:12: logicalExpression ( ',' logicalExpression )*
                    {
                    pushFollow(FOLLOW_logicalExpression_in_parameterList1887);
                    logicalExpression126=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression126.getTree());
                    // EolParserRules.g:443:30: ( ',' logicalExpression )*
                    loop54:
                    do {
                        int alt54=2;
                        int LA54_0 = input.LA(1);

                        if ( (LA54_0==87) ) {
                            alt54=1;
                        }


                        switch (alt54) {
                    	case 1 :
                    	    // EolParserRules.g:443:31: ',' logicalExpression
                    	    {
                    	    char_literal127=(Token)match(input,87,FOLLOW_87_in_parameterList1890); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_87.add(char_literal127);

                    	    pushFollow(FOLLOW_logicalExpression_in_parameterList1892);
                    	    logicalExpression128=logicalExpression();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression128.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop54;
                        }
                    } while (true);


                    }
                    break;

            }

            cp=(Token)match(input,95,FOLLOW_95_in_parameterList1900); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_95.add(cp);



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
    public final Eml_EolParserRules.declarativeFeatureCall_return declarativeFeatureCall() throws RecognitionException {
        Eml_EolParserRules.declarativeFeatureCall_return retval = new Eml_EolParserRules.declarativeFeatureCall_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token op=null;
        Token cp=null;
        Token NAME129=null;
        Token char_literal131=null;
        Token char_literal133=null;
        Eml_EolParserRules.formalParameterList_return formalParameterList130 = null;

        Eml_EolParserRules.logicalExpression_return logicalExpression132 = null;

        Eml_EolParserRules.logicalExpression_return logicalExpression134 = null;


        org.eclipse.epsilon.common.parse.AST op_tree=null;
        org.eclipse.epsilon.common.parse.AST cp_tree=null;
        org.eclipse.epsilon.common.parse.AST NAME129_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal131_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal133_tree=null;

        try {
            // EolParserRules.g:452:2: ( NAME op= '(' formalParameterList '|' logicalExpression ( ',' logicalExpression )* cp= ')' )
            // EolParserRules.g:452:4: NAME op= '(' formalParameterList '|' logicalExpression ( ',' logicalExpression )* cp= ')'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            NAME129=(Token)match(input,NAME,FOLLOW_NAME_in_declarativeFeatureCall1928); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME129_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(NAME129);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(NAME129_tree, root_0);
            }
            op=(Token)match(input,94,FOLLOW_94_in_declarativeFeatureCall1933); if (state.failed) return retval;
            pushFollow(FOLLOW_formalParameterList_in_declarativeFeatureCall1936);
            formalParameterList130=formalParameterList();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, formalParameterList130.getTree());
            char_literal131=(Token)match(input,145,FOLLOW_145_in_declarativeFeatureCall1938); if (state.failed) return retval;
            pushFollow(FOLLOW_logicalExpression_in_declarativeFeatureCall1941);
            logicalExpression132=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression132.getTree());
            // EolParserRules.g:452:61: ( ',' logicalExpression )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==87) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // EolParserRules.g:452:62: ',' logicalExpression
            	    {
            	    char_literal133=(Token)match(input,87,FOLLOW_87_in_declarativeFeatureCall1944); if (state.failed) return retval;
            	    pushFollow(FOLLOW_logicalExpression_in_declarativeFeatureCall1947);
            	    logicalExpression134=logicalExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression134.getTree());

            	    }
            	    break;

            	default :
            	    break loop56;
                }
            } while (true);

            cp=(Token)match(input,95,FOLLOW_95_in_declarativeFeatureCall1953); if (state.failed) return retval;

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
    public final Eml_EolParserRules.newExpression_return newExpression() throws RecognitionException {
        Eml_EolParserRules.newExpression_return retval = new Eml_EolParserRules.newExpression_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token n=null;
        Eml_EolParserRules.typeName_return tn = null;

        Eml_EolParserRules.parameterList_return parameterList135 = null;


        org.eclipse.epsilon.common.parse.AST n_tree=null;

        try {
            // EolParserRules.g:456:2: (n= 'new' tn= typeName ( parameterList )? )
            // EolParserRules.g:456:4: n= 'new' tn= typeName ( parameterList )?
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            n=(Token)match(input,146,FOLLOW_146_in_newExpression1967); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            n_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(n);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(n_tree, root_0);
            }
            pushFollow(FOLLOW_typeName_in_newExpression1972);
            tn=typeName();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, tn.getTree());
            if ( state.backtracking==0 ) {
              setTokenType(tn,TYPE);
            }
            // EolParserRules.g:456:50: ( parameterList )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==94) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // EolParserRules.g:0:0: parameterList
                    {
                    pushFollow(FOLLOW_parameterList_in_newExpression1976);
                    parameterList135=parameterList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, parameterList135.getTree());

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
    // EolParserRules.g:460:1: variableDeclarationExpression : v= 'var' NAME ( ':' (n= 'new' )? t= typeName ( parameterList )? )? ;
    public final Eml_EolParserRules.variableDeclarationExpression_return variableDeclarationExpression() throws RecognitionException {
        Eml_EolParserRules.variableDeclarationExpression_return retval = new Eml_EolParserRules.variableDeclarationExpression_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token v=null;
        Token n=null;
        Token NAME136=null;
        Token char_literal137=null;
        Eml_EolParserRules.typeName_return t = null;

        Eml_EolParserRules.parameterList_return parameterList138 = null;


        org.eclipse.epsilon.common.parse.AST v_tree=null;
        org.eclipse.epsilon.common.parse.AST n_tree=null;
        org.eclipse.epsilon.common.parse.AST NAME136_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal137_tree=null;

        try {
            // EolParserRules.g:468:2: (v= 'var' NAME ( ':' (n= 'new' )? t= typeName ( parameterList )? )? )
            // EolParserRules.g:468:4: v= 'var' NAME ( ':' (n= 'new' )? t= typeName ( parameterList )? )?
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            v=(Token)match(input,147,FOLLOW_147_in_variableDeclarationExpression1998); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            v_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(v);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(v_tree, root_0);
            }
            NAME136=(Token)match(input,NAME,FOLLOW_NAME_in_variableDeclarationExpression2001); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME136_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(NAME136);
            adaptor.addChild(root_0, NAME136_tree);
            }
            // EolParserRules.g:468:18: ( ':' (n= 'new' )? t= typeName ( parameterList )? )?
            int alt60=2;
            alt60 = dfa60.predict(input);
            switch (alt60) {
                case 1 :
                    // EolParserRules.g:468:19: ':' (n= 'new' )? t= typeName ( parameterList )?
                    {
                    char_literal137=(Token)match(input,96,FOLLOW_96_in_variableDeclarationExpression2004); if (state.failed) return retval;
                    // EolParserRules.g:468:25: (n= 'new' )?
                    int alt58=2;
                    int LA58_0 = input.LA(1);

                    if ( (LA58_0==146) ) {
                        alt58=1;
                    }
                    switch (alt58) {
                        case 1 :
                            // EolParserRules.g:0:0: n= 'new'
                            {
                            n=(Token)match(input,146,FOLLOW_146_in_variableDeclarationExpression2009); if (state.failed) return retval;

                            }
                            break;

                    }

                    pushFollow(FOLLOW_typeName_in_variableDeclarationExpression2015);
                    t=typeName();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, t.getTree());
                    if ( state.backtracking==0 ) {
                      setTokenType(t, TYPE);
                    }
                    // EolParserRules.g:468:70: ( parameterList )?
                    int alt59=2;
                    int LA59_0 = input.LA(1);

                    if ( (LA59_0==94) ) {
                        alt59=1;
                    }
                    switch (alt59) {
                        case 1 :
                            // EolParserRules.g:0:0: parameterList
                            {
                            pushFollow(FOLLOW_parameterList_in_variableDeclarationExpression2019);
                            parameterList138=parameterList();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, parameterList138.getTree());

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
    // EolParserRules.g:471:1: literalSequentialCollection : (l= 'Collection' | l= 'Sequence' | l= 'List' | l= 'Bag' | l= 'Set' | l= 'OrderedSet' ) ob= '{' ( expressionListOrRange )? cb= '}' ;
    public final Eml_EolParserRules.literalSequentialCollection_return literalSequentialCollection() throws RecognitionException {
        Eml_EolParserRules.literalSequentialCollection_return retval = new Eml_EolParserRules.literalSequentialCollection_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token l=null;
        Token ob=null;
        Token cb=null;
        Eml_EolParserRules.expressionListOrRange_return expressionListOrRange139 = null;


        org.eclipse.epsilon.common.parse.AST l_tree=null;
        org.eclipse.epsilon.common.parse.AST ob_tree=null;
        org.eclipse.epsilon.common.parse.AST cb_tree=null;

        try {
            // EolParserRules.g:476:2: ( (l= 'Collection' | l= 'Sequence' | l= 'List' | l= 'Bag' | l= 'Set' | l= 'OrderedSet' ) ob= '{' ( expressionListOrRange )? cb= '}' )
            // EolParserRules.g:476:4: (l= 'Collection' | l= 'Sequence' | l= 'List' | l= 'Bag' | l= 'Set' | l= 'OrderedSet' ) ob= '{' ( expressionListOrRange )? cb= '}'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            // EolParserRules.g:476:4: (l= 'Collection' | l= 'Sequence' | l= 'List' | l= 'Bag' | l= 'Set' | l= 'OrderedSet' )
            int alt61=6;
            switch ( input.LA(1) ) {
            case 103:
                {
                alt61=1;
                }
                break;
            case 104:
                {
                alt61=2;
                }
                break;
            case 105:
                {
                alt61=3;
                }
                break;
            case 106:
                {
                alt61=4;
                }
                break;
            case 107:
                {
                alt61=5;
                }
                break;
            case 108:
                {
                alt61=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 61, 0, input);

                throw nvae;
            }

            switch (alt61) {
                case 1 :
                    // EolParserRules.g:476:5: l= 'Collection'
                    {
                    l=(Token)match(input,103,FOLLOW_103_in_literalSequentialCollection2043); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    l_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(l);
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(l_tree, root_0);
                    }

                    }
                    break;
                case 2 :
                    // EolParserRules.g:476:21: l= 'Sequence'
                    {
                    l=(Token)match(input,104,FOLLOW_104_in_literalSequentialCollection2048); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    l_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(l);
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(l_tree, root_0);
                    }

                    }
                    break;
                case 3 :
                    // EolParserRules.g:476:35: l= 'List'
                    {
                    l=(Token)match(input,105,FOLLOW_105_in_literalSequentialCollection2053); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    l_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(l);
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(l_tree, root_0);
                    }

                    }
                    break;
                case 4 :
                    // EolParserRules.g:476:45: l= 'Bag'
                    {
                    l=(Token)match(input,106,FOLLOW_106_in_literalSequentialCollection2058); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    l_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(l);
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(l_tree, root_0);
                    }

                    }
                    break;
                case 5 :
                    // EolParserRules.g:476:54: l= 'Set'
                    {
                    l=(Token)match(input,107,FOLLOW_107_in_literalSequentialCollection2063); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    l_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(l);
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(l_tree, root_0);
                    }

                    }
                    break;
                case 6 :
                    // EolParserRules.g:476:63: l= 'OrderedSet'
                    {
                    l=(Token)match(input,108,FOLLOW_108_in_literalSequentialCollection2068); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    l_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(l);
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(l_tree, root_0);
                    }

                    }
                    break;

            }

            ob=(Token)match(input,89,FOLLOW_89_in_literalSequentialCollection2074); if (state.failed) return retval;
            // EolParserRules.g:476:89: ( expressionListOrRange )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==FLOAT||LA62_0==INT||LA62_0==BOOLEAN||LA62_0==STRING||LA62_0==NAME||LA62_0==94||(LA62_0>=102 && LA62_0<=109)||LA62_0==139||LA62_0==142||(LA62_0>=146 && LA62_0<=147)) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // EolParserRules.g:0:0: expressionListOrRange
                    {
                    pushFollow(FOLLOW_expressionListOrRange_in_literalSequentialCollection2078);
                    expressionListOrRange139=expressionListOrRange();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionListOrRange139.getTree());

                    }
                    break;

            }

            cb=(Token)match(input,90,FOLLOW_90_in_literalSequentialCollection2083); if (state.failed) return retval;
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
    public final Eml_EolParserRules.expressionRange_return expressionRange() throws RecognitionException {
        Eml_EolParserRules.expressionRange_return retval = new Eml_EolParserRules.expressionRange_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token exp=null;
        Eml_EolParserRules.logicalExpression_return logicalExpression140 = null;

        Eml_EolParserRules.logicalExpression_return logicalExpression141 = null;


        org.eclipse.epsilon.common.parse.AST exp_tree=null;

        try {
            // EolParserRules.g:481:2: ( logicalExpression exp= '..' logicalExpression )
            // EolParserRules.g:481:4: logicalExpression exp= '..' logicalExpression
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            pushFollow(FOLLOW_logicalExpression_in_expressionRange2098);
            logicalExpression140=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression140.getTree());
            exp=(Token)match(input,POINT_POINT,FOLLOW_POINT_POINT_in_expressionRange2102); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            exp_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(exp);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(exp_tree, root_0);
            }
            pushFollow(FOLLOW_logicalExpression_in_expressionRange2105);
            logicalExpression141=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression141.getTree());
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
    public final Eml_EolParserRules.expressionList_return expressionList() throws RecognitionException {
        Eml_EolParserRules.expressionList_return retval = new Eml_EolParserRules.expressionList_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token char_literal143=null;
        Eml_EolParserRules.logicalExpression_return logicalExpression142 = null;

        Eml_EolParserRules.logicalExpression_return logicalExpression144 = null;


        org.eclipse.epsilon.common.parse.AST char_literal143_tree=null;
        RewriteRuleTokenStream stream_87=new RewriteRuleTokenStream(adaptor,"token 87");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:489:2: ( logicalExpression ( ',' logicalExpression )* -> ^( EXPRLIST ( logicalExpression )+ ) )
            // EolParserRules.g:489:4: logicalExpression ( ',' logicalExpression )*
            {
            pushFollow(FOLLOW_logicalExpression_in_expressionList2126);
            logicalExpression142=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression142.getTree());
            // EolParserRules.g:489:22: ( ',' logicalExpression )*
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==87) ) {
                    alt63=1;
                }


                switch (alt63) {
            	case 1 :
            	    // EolParserRules.g:489:23: ',' logicalExpression
            	    {
            	    char_literal143=(Token)match(input,87,FOLLOW_87_in_expressionList2129); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_87.add(char_literal143);

            	    pushFollow(FOLLOW_logicalExpression_in_expressionList2131);
            	    logicalExpression144=logicalExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression144.getTree());

            	    }
            	    break;

            	default :
            	    break loop63;
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
    public final Eml_EolParserRules.expressionListOrRange_return expressionListOrRange() throws RecognitionException {
        Eml_EolParserRules.expressionListOrRange_return retval = new Eml_EolParserRules.expressionListOrRange_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Eml_EolParserRules.expressionRange_return expressionRange145 = null;

        Eml_EolParserRules.expressionList_return expressionList146 = null;



        try {
            // EolParserRules.g:494:2: ( expressionRange | expressionList )
            int alt64=2;
            alt64 = dfa64.predict(input);
            switch (alt64) {
                case 1 :
                    // EolParserRules.g:494:4: expressionRange
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_expressionRange_in_expressionListOrRange2155);
                    expressionRange145=expressionRange();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionRange145.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:494:22: expressionList
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_expressionList_in_expressionListOrRange2159);
                    expressionList146=expressionList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionList146.getTree());

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
    public final Eml_EolParserRules.literalMapCollection_return literalMapCollection() throws RecognitionException {
        Eml_EolParserRules.literalMapCollection_return retval = new Eml_EolParserRules.literalMapCollection_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token m=null;
        Token ob=null;
        Token cb=null;
        Eml_EolParserRules.keyvalExpressionList_return keyvalExpressionList147 = null;


        org.eclipse.epsilon.common.parse.AST m_tree=null;
        org.eclipse.epsilon.common.parse.AST ob_tree=null;
        org.eclipse.epsilon.common.parse.AST cb_tree=null;

        try {
            // EolParserRules.g:502:2: (m= 'Map' ob= '{' ( keyvalExpressionList )? cb= '}' )
            // EolParserRules.g:502:4: m= 'Map' ob= '{' ( keyvalExpressionList )? cb= '}'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            m=(Token)match(input,109,FOLLOW_109_in_literalMapCollection2178); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            m_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(m);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(m_tree, root_0);
            }
            ob=(Token)match(input,89,FOLLOW_89_in_literalMapCollection2183); if (state.failed) return retval;
            // EolParserRules.g:502:21: ( keyvalExpressionList )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==FLOAT||LA65_0==INT||LA65_0==BOOLEAN||LA65_0==STRING||LA65_0==NAME||LA65_0==94||(LA65_0>=102 && LA65_0<=109)||LA65_0==139||LA65_0==142||(LA65_0>=146 && LA65_0<=147)) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // EolParserRules.g:0:0: keyvalExpressionList
                    {
                    pushFollow(FOLLOW_keyvalExpressionList_in_literalMapCollection2186);
                    keyvalExpressionList147=keyvalExpressionList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, keyvalExpressionList147.getTree());

                    }
                    break;

            }

            cb=(Token)match(input,90,FOLLOW_90_in_literalMapCollection2191); if (state.failed) return retval;
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
    public final Eml_EolParserRules.keyvalExpressionList_return keyvalExpressionList() throws RecognitionException {
        Eml_EolParserRules.keyvalExpressionList_return retval = new Eml_EolParserRules.keyvalExpressionList_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token char_literal149=null;
        Eml_EolParserRules.keyvalExpression_return keyvalExpression148 = null;

        Eml_EolParserRules.keyvalExpression_return keyvalExpression150 = null;


        org.eclipse.epsilon.common.parse.AST char_literal149_tree=null;
        RewriteRuleTokenStream stream_87=new RewriteRuleTokenStream(adaptor,"token 87");
        RewriteRuleSubtreeStream stream_keyvalExpression=new RewriteRuleSubtreeStream(adaptor,"rule keyvalExpression");
        try {
            // EolParserRules.g:510:2: ( keyvalExpression ( ',' keyvalExpression )* -> ^( KEYVALLIST ( keyvalExpression )+ ) )
            // EolParserRules.g:510:4: keyvalExpression ( ',' keyvalExpression )*
            {
            pushFollow(FOLLOW_keyvalExpression_in_keyvalExpressionList2212);
            keyvalExpression148=keyvalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_keyvalExpression.add(keyvalExpression148.getTree());
            // EolParserRules.g:510:21: ( ',' keyvalExpression )*
            loop66:
            do {
                int alt66=2;
                int LA66_0 = input.LA(1);

                if ( (LA66_0==87) ) {
                    alt66=1;
                }


                switch (alt66) {
            	case 1 :
            	    // EolParserRules.g:510:22: ',' keyvalExpression
            	    {
            	    char_literal149=(Token)match(input,87,FOLLOW_87_in_keyvalExpressionList2215); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_87.add(char_literal149);

            	    pushFollow(FOLLOW_keyvalExpression_in_keyvalExpressionList2217);
            	    keyvalExpression150=keyvalExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_keyvalExpression.add(keyvalExpression150.getTree());

            	    }
            	    break;

            	default :
            	    break loop66;
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
    public final Eml_EolParserRules.keyvalExpression_return keyvalExpression() throws RecognitionException {
        Eml_EolParserRules.keyvalExpression_return retval = new Eml_EolParserRules.keyvalExpression_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token eq=null;
        Eml_EolParserRules.additiveExpression_return additiveExpression151 = null;

        Eml_EolParserRules.logicalExpression_return logicalExpression152 = null;


        org.eclipse.epsilon.common.parse.AST eq_tree=null;

        try {
            // EolParserRules.g:516:2: ( additiveExpression eq= '=' logicalExpression )
            // EolParserRules.g:516:4: additiveExpression eq= '=' logicalExpression
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            pushFollow(FOLLOW_additiveExpression_in_keyvalExpression2242);
            additiveExpression151=additiveExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, additiveExpression151.getTree());
            eq=(Token)match(input,91,FOLLOW_91_in_keyvalExpression2246); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            eq_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(eq);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(eq_tree, root_0);
            }
            pushFollow(FOLLOW_logicalExpression_in_keyvalExpression2249);
            logicalExpression152=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression152.getTree());
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
    public final Eml_EolParserRules.primitiveExpression_return primitiveExpression() throws RecognitionException {
        Eml_EolParserRules.primitiveExpression_return retval = new Eml_EolParserRules.primitiveExpression_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Eml_EolParserRules.literalSequentialCollection_return literalSequentialCollection153 = null;

        Eml_EolParserRules.literalMapCollection_return literalMapCollection154 = null;

        Eml_EolParserRules.literal_return literal155 = null;

        Eml_EolParserRules.featureCall_return featureCall156 = null;

        Eml_EolParserRules.pathName_return pathName157 = null;

        Eml_EolParserRules.nativeType_return nativeType158 = null;

        Eml_EolParserRules.collectionType_return collectionType159 = null;

        Eml_EolParserRules.logicalExpressionInBrackets_return logicalExpressionInBrackets160 = null;

        Eml_EolParserRules.newExpression_return newExpression161 = null;

        Eml_EolParserRules.variableDeclarationExpression_return variableDeclarationExpression162 = null;



        try {
            // EolParserRules.g:520:2: ( literalSequentialCollection | literalMapCollection | literal | featureCall | pathName | nativeType | collectionType | logicalExpressionInBrackets | newExpression | variableDeclarationExpression )
            int alt67=10;
            alt67 = dfa67.predict(input);
            switch (alt67) {
                case 1 :
                    // EolParserRules.g:520:4: literalSequentialCollection
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_literalSequentialCollection_in_primitiveExpression2263);
                    literalSequentialCollection153=literalSequentialCollection();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, literalSequentialCollection153.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:520:34: literalMapCollection
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_literalMapCollection_in_primitiveExpression2267);
                    literalMapCollection154=literalMapCollection();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, literalMapCollection154.getTree());

                    }
                    break;
                case 3 :
                    // EolParserRules.g:520:57: literal
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_literal_in_primitiveExpression2271);
                    literal155=literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, literal155.getTree());

                    }
                    break;
                case 4 :
                    // EolParserRules.g:520:67: featureCall
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_featureCall_in_primitiveExpression2275);
                    featureCall156=featureCall();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, featureCall156.getTree());

                    }
                    break;
                case 5 :
                    // EolParserRules.g:520:81: pathName
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_pathName_in_primitiveExpression2279);
                    pathName157=pathName();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pathName157.getTree());

                    }
                    break;
                case 6 :
                    // EolParserRules.g:520:92: nativeType
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_nativeType_in_primitiveExpression2283);
                    nativeType158=nativeType();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nativeType158.getTree());

                    }
                    break;
                case 7 :
                    // EolParserRules.g:521:5: collectionType
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_collectionType_in_primitiveExpression2289);
                    collectionType159=collectionType();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, collectionType159.getTree());

                    }
                    break;
                case 8 :
                    // EolParserRules.g:521:23: logicalExpressionInBrackets
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_logicalExpressionInBrackets_in_primitiveExpression2294);
                    logicalExpressionInBrackets160=logicalExpressionInBrackets();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpressionInBrackets160.getTree());

                    }
                    break;
                case 9 :
                    // EolParserRules.g:522:5: newExpression
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_newExpression_in_primitiveExpression2300);
                    newExpression161=newExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, newExpression161.getTree());

                    }
                    break;
                case 10 :
                    // EolParserRules.g:522:21: variableDeclarationExpression
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_variableDeclarationExpression_in_primitiveExpression2304);
                    variableDeclarationExpression162=variableDeclarationExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, variableDeclarationExpression162.getTree());

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
    public final Eml_EolParserRules.logicalExpressionInBrackets_return logicalExpressionInBrackets() throws RecognitionException {
        Eml_EolParserRules.logicalExpressionInBrackets_return retval = new Eml_EolParserRules.logicalExpressionInBrackets_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token ob=null;
        Token cb=null;
        Eml_EolParserRules.logicalExpression_return logicalExpression163 = null;


        org.eclipse.epsilon.common.parse.AST ob_tree=null;
        org.eclipse.epsilon.common.parse.AST cb_tree=null;

        try {
            // EolParserRules.g:531:2: (ob= '(' logicalExpression cb= ')' )
            // EolParserRules.g:531:4: ob= '(' logicalExpression cb= ')'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            ob=(Token)match(input,94,FOLLOW_94_in_logicalExpressionInBrackets2323); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ob_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(ob);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(ob_tree, root_0);
            }
            pushFollow(FOLLOW_logicalExpression_in_logicalExpressionInBrackets2326);
            logicalExpression163=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression163.getTree());
            cb=(Token)match(input,95,FOLLOW_95_in_logicalExpressionInBrackets2330); if (state.failed) return retval;
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
    public final Eml_EolParserRules.literal_return literal() throws RecognitionException {
        Eml_EolParserRules.literal_return retval = new Eml_EolParserRules.literal_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token set164=null;

        org.eclipse.epsilon.common.parse.AST set164_tree=null;

        try {
            // EolParserRules.g:536:2: ( STRING | INT | FLOAT | BOOLEAN )
            // EolParserRules.g:
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            set164=(Token)input.LT(1);
            if ( input.LA(1)==FLOAT||input.LA(1)==INT||input.LA(1)==BOOLEAN||input.LA(1)==STRING ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (org.eclipse.epsilon.common.parse.AST)adaptor.create(set164));
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

    // $ANTLR start synpred28_EolParserRules
    public final void synpred28_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:254:4: ( '(' typeName ')' )
        // EolParserRules.g:254:4: '(' typeName ')'
        {
        match(input,94,FOLLOW_94_in_synpred28_EolParserRules851); if (state.failed) return ;
        pushFollow(FOLLOW_typeName_in_synpred28_EolParserRules856);
        typeName();

        state._fsp--;
        if (state.failed) return ;
        match(input,95,FOLLOW_95_in_synpred28_EolParserRules862); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred28_EolParserRules

    // $ANTLR start synpred29_EolParserRules
    public final void synpred29_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:258:4: ( statementA )
        // EolParserRules.g:258:4: statementA
        {
        pushFollow(FOLLOW_statementA_in_synpred29_EolParserRules877);
        statementA();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred29_EolParserRules

    // $ANTLR start synpred30_EolParserRules
    public final void synpred30_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:262:4: ( assignmentStatement )
        // EolParserRules.g:262:4: assignmentStatement
        {
        pushFollow(FOLLOW_assignmentStatement_in_synpred30_EolParserRules892);
        assignmentStatement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred30_EolParserRules

    // $ANTLR start synpred31_EolParserRules
    public final void synpred31_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:262:26: ( expressionStatement )
        // EolParserRules.g:262:26: expressionStatement
        {
        pushFollow(FOLLOW_expressionStatement_in_synpred31_EolParserRules896);
        expressionStatement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred31_EolParserRules

    // $ANTLR start synpred45_EolParserRules
    public final void synpred45_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:285:66: ( elseStatement )
        // EolParserRules.g:285:66: elseStatement
        {
        pushFollow(FOLLOW_elseStatement_in_synpred45_EolParserRules1051);
        elseStatement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred45_EolParserRules

    // $ANTLR start synpred54_EolParserRules
    public final void synpred54_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:373:22: ( NAME ( ',' NAME )* )
        // EolParserRules.g:373:22: NAME ( ',' NAME )*
        {
        match(input,NAME,FOLLOW_NAME_in_synpred54_EolParserRules1432); if (state.failed) return ;
        // EolParserRules.g:373:27: ( ',' NAME )*
        loop68:
        do {
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==87) ) {
                alt68=1;
            }


            switch (alt68) {
        	case 1 :
        	    // EolParserRules.g:373:28: ',' NAME
        	    {
        	    match(input,87,FOLLOW_87_in_synpred54_EolParserRules1435); if (state.failed) return ;
        	    match(input,NAME,FOLLOW_NAME_in_synpred54_EolParserRules1437); if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop68;
            }
        } while (true);


        }
    }
    // $ANTLR end synpred54_EolParserRules

    // $ANTLR start synpred56_EolParserRules
    public final void synpred56_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:389:5: ( postfixExpression '=' logicalExpression )
        // EolParserRules.g:389:5: postfixExpression '=' logicalExpression
        {
        pushFollow(FOLLOW_postfixExpression_in_synpred56_EolParserRules1507);
        postfixExpression();

        state._fsp--;
        if (state.failed) return ;
        match(input,91,FOLLOW_91_in_synpred56_EolParserRules1511); if (state.failed) return ;
        pushFollow(FOLLOW_logicalExpression_in_synpred56_EolParserRules1514);
        logicalExpression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred56_EolParserRules

    // $ANTLR start synpred67_EolParserRules
    public final void synpred67_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:398:24: ( ( '==' relationalExpression | '=' relationalExpression | ( '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression ) )
        // EolParserRules.g:398:24: ( '==' relationalExpression | '=' relationalExpression | ( '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression )
        {
        // EolParserRules.g:398:24: ( '==' relationalExpression | '=' relationalExpression | ( '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression )
        int alt69=3;
        switch ( input.LA(1) ) {
        case 132:
            {
            alt69=1;
            }
            break;
        case 91:
            {
            alt69=2;
            }
            break;
        case 133:
        case 134:
        case 135:
        case 136:
        case 137:
            {
            alt69=3;
            }
            break;
        default:
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 69, 0, input);

            throw nvae;
        }

        switch (alt69) {
            case 1 :
                // EolParserRules.g:398:25: '==' relationalExpression
                {
                match(input,132,FOLLOW_132_in_synpred67_EolParserRules1585); if (state.failed) return ;
                pushFollow(FOLLOW_relationalExpression_in_synpred67_EolParserRules1588);
                relationalExpression();

                state._fsp--;
                if (state.failed) return ;

                }
                break;
            case 2 :
                // EolParserRules.g:398:57: '=' relationalExpression
                {
                match(input,91,FOLLOW_91_in_synpred67_EolParserRules1594); if (state.failed) return ;
                pushFollow(FOLLOW_relationalExpression_in_synpred67_EolParserRules1597);
                relationalExpression();

                state._fsp--;
                if (state.failed) return ;

                }
                break;
            case 3 :
                // EolParserRules.g:399:24: ( '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression
                {
                if ( (input.LA(1)>=133 && input.LA(1)<=137) ) {
                    input.consume();
                    state.errorRecovery=false;state.failed=false;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    MismatchedSetException mse = new MismatchedSetException(null,input);
                    throw mse;
                }

                pushFollow(FOLLOW_additiveExpression_in_synpred67_EolParserRules1651);
                additiveExpression();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        }
    }
    // $ANTLR end synpred67_EolParserRules

    // $ANTLR start synpred86_EolParserRules
    public final void synpred86_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:468:19: ( ':' ( 'new' )? typeName ( parameterList )? )
        // EolParserRules.g:468:19: ':' ( 'new' )? typeName ( parameterList )?
        {
        match(input,96,FOLLOW_96_in_synpred86_EolParserRules2004); if (state.failed) return ;
        // EolParserRules.g:468:25: ( 'new' )?
        int alt72=2;
        int LA72_0 = input.LA(1);

        if ( (LA72_0==146) ) {
            alt72=1;
        }
        switch (alt72) {
            case 1 :
                // EolParserRules.g:0:0: 'new'
                {
                match(input,146,FOLLOW_146_in_synpred86_EolParserRules2009); if (state.failed) return ;

                }
                break;

        }

        pushFollow(FOLLOW_typeName_in_synpred86_EolParserRules2015);
        typeName();

        state._fsp--;
        if (state.failed) return ;
        // EolParserRules.g:468:70: ( parameterList )?
        int alt73=2;
        int LA73_0 = input.LA(1);

        if ( (LA73_0==94) ) {
            alt73=1;
        }
        switch (alt73) {
            case 1 :
                // EolParserRules.g:0:0: parameterList
                {
                pushFollow(FOLLOW_parameterList_in_synpred86_EolParserRules2019);
                parameterList();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        }
    }
    // $ANTLR end synpred86_EolParserRules

    // $ANTLR start synpred94_EolParserRules
    public final void synpred94_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:494:4: ( expressionRange )
        // EolParserRules.g:494:4: expressionRange
        {
        pushFollow(FOLLOW_expressionRange_in_synpred94_EolParserRules2155);
        expressionRange();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred94_EolParserRules

    // $ANTLR start synpred100_EolParserRules
    public final void synpred100_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:520:67: ( featureCall )
        // EolParserRules.g:520:67: featureCall
        {
        pushFollow(FOLLOW_featureCall_in_synpred100_EolParserRules2275);
        featureCall();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred100_EolParserRules

    // $ANTLR start synpred101_EolParserRules
    public final void synpred101_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:520:81: ( pathName )
        // EolParserRules.g:520:81: pathName
        {
        pushFollow(FOLLOW_pathName_in_synpred101_EolParserRules2279);
        pathName();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred101_EolParserRules

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
    public final boolean synpred94_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred94_EolParserRules_fragment(); // can never throw exception
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
    public final boolean synpred100_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred100_EolParserRules_fragment(); // can never throw exception
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
    public final boolean synpred67_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred67_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred101_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred101_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred56_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred56_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred86_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred86_EolParserRules_fragment(); // can never throw exception
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


    protected DFA20 dfa20 = new DFA20(this);
    protected DFA21 dfa21 = new DFA21(this);
    protected DFA22 dfa22 = new DFA22(this);
    protected DFA35 dfa35 = new DFA35(this);
    protected DFA37 dfa37 = new DFA37(this);
    protected DFA42 dfa42 = new DFA42(this);
    protected DFA52 dfa52 = new DFA52(this);
    protected DFA60 dfa60 = new DFA60(this);
    protected DFA64 dfa64 = new DFA64(this);
    protected DFA67 dfa67 = new DFA67(this);
    static final String DFA20_eotS =
        "\104\uffff";
    static final String DFA20_eofS =
        "\1\2\103\uffff";
    static final String DFA20_minS =
        "\1\4\1\0\102\uffff";
    static final String DFA20_maxS =
        "\1\u009d\1\0\102\uffff";
    static final String DFA20_acceptS =
        "\2\uffff\1\2\100\uffff\1\1";
    static final String DFA20_specialS =
        "\1\uffff\1\0\102\uffff}>";
    static final String[] DFA20_transitionS = {
            "\1\2\3\uffff\5\2\1\uffff\1\2\4\uffff\1\2\3\uffff\1\2\75\uffff"+
            "\1\2\1\uffff\1\2\1\uffff\5\2\1\1\2\2\1\uffff\1\2\3\uffff\14"+
            "\2\3\uffff\41\2\1\uffff\2\2\1\uffff\1\2\1\uffff\2\2",
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
            return "254:3: (op= '(' tn= typeName cp= ')' )?";
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
                        if ( (synpred28_EolParserRules()) ) {s = 67;}

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
        "\1\u0093\23\uffff\1\0\7\uffff";
    static final String DFA21_acceptS =
        "\1\uffff\1\1\24\uffff\1\2\5\uffff";
    static final String DFA21_specialS =
        "\24\uffff\1\0\7\uffff}>";
    static final String[] DFA21_transitionS = {
            "\1\1\3\uffff\1\1\3\uffff\1\1\1\uffff\1\1\4\uffff\1\1\112\uffff"+
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
            return "257:1: statement : ( statementA | statementB );";
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
        "\1\u0093\17\0\10\uffff";
    static final String DFA22_acceptS =
        "\20\uffff\1\3\1\4\1\5\1\6\1\7\1\10\1\1\1\2";
    static final String DFA22_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14"+
        "\1\15\1\16\10\uffff}>";
    static final String[] DFA22_transitionS = {
            "\1\12\3\uffff\1\12\3\uffff\1\12\1\uffff\1\12\4\uffff\1\13\112"+
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
            return "261:1: statementA : ( assignmentStatement | expressionStatement | forStatement | ifStatement | whileStatement | switchStatement | returnStatement | breakStatement );";
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
    static final String DFA35_eotS =
        "\36\uffff";
    static final String DFA35_eofS =
        "\36\uffff";
    static final String DFA35_minS =
        "\1\4\1\0\34\uffff";
    static final String DFA35_maxS =
        "\1\u0093\1\0\34\uffff";
    static final String DFA35_acceptS =
        "\2\uffff\1\2\32\uffff\1\1";
    static final String DFA35_specialS =
        "\1\uffff\1\0\34\uffff}>";
    static final String[] DFA35_transitionS = {
            "\1\2\3\uffff\1\2\3\uffff\1\2\1\uffff\1\2\4\uffff\1\1\105\uffff"+
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
            return "373:21: ( NAME ( ',' NAME )* )?";
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
                        if ( (synpred54_EolParserRules()) ) {s = 29;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index35_1);
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
    static final String DFA37_eotS =
        "\21\uffff";
    static final String DFA37_eofS =
        "\21\uffff";
    static final String DFA37_minS =
        "\1\4\15\0\3\uffff";
    static final String DFA37_maxS =
        "\1\u0093\15\0\3\uffff";
    static final String DFA37_acceptS =
        "\16\uffff\1\2\1\uffff\1\1";
    static final String DFA37_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14"+
        "\3\uffff}>";
    static final String[] DFA37_transitionS = {
            "\1\10\3\uffff\1\10\3\uffff\1\10\1\uffff\1\10\4\uffff\1\11\112"+
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
            return "389:4: ( postfixExpression op= '=' logicalExpression | logicalExpression )";
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
                        if ( (synpred56_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index37_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA37_2 = input.LA(1);

                         
                        int index37_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index37_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA37_3 = input.LA(1);

                         
                        int index37_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index37_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA37_4 = input.LA(1);

                         
                        int index37_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index37_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA37_5 = input.LA(1);

                         
                        int index37_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index37_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA37_6 = input.LA(1);

                         
                        int index37_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index37_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA37_7 = input.LA(1);

                         
                        int index37_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index37_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA37_8 = input.LA(1);

                         
                        int index37_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index37_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA37_9 = input.LA(1);

                         
                        int index37_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index37_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA37_10 = input.LA(1);

                         
                        int index37_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index37_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA37_11 = input.LA(1);

                         
                        int index37_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index37_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA37_12 = input.LA(1);

                         
                        int index37_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index37_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA37_13 = input.LA(1);

                         
                        int index37_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index37_13);
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
    static final String DFA42_eotS =
        "\12\uffff";
    static final String DFA42_eofS =
        "\1\1\11\uffff";
    static final String DFA42_minS =
        "\1\4\1\uffff\7\0\1\uffff";
    static final String DFA42_maxS =
        "\1\u0098\1\uffff\7\0\1\uffff";
    static final String DFA42_acceptS =
        "\1\uffff\1\2\7\uffff\1\1";
    static final String DFA42_specialS =
        "\2\uffff\1\4\1\2\1\5\1\0\1\6\1\1\1\3\1\uffff}>";
    static final String[] DFA42_transitionS = {
            "\1\1\3\uffff\1\1\1\uffff\1\1\1\uffff\1\1\1\uffff\1\1\4\uffff"+
            "\1\1\3\uffff\1\1\75\uffff\1\1\1\uffff\1\1\2\uffff\1\1\1\3\5"+
            "\1\1\uffff\1\1\3\uffff\11\1\1\uffff\2\1\3\uffff\17\1\1\2\1\4"+
            "\1\5\1\6\1\7\1\10\1\uffff\1\1\2\uffff\1\1\1\uffff\1\1\1\uffff"+
            "\4\1\2\uffff\1\1",
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

    static final short[] DFA42_eot = DFA.unpackEncodedString(DFA42_eotS);
    static final short[] DFA42_eof = DFA.unpackEncodedString(DFA42_eofS);
    static final char[] DFA42_min = DFA.unpackEncodedStringToUnsignedChars(DFA42_minS);
    static final char[] DFA42_max = DFA.unpackEncodedStringToUnsignedChars(DFA42_maxS);
    static final short[] DFA42_accept = DFA.unpackEncodedString(DFA42_acceptS);
    static final short[] DFA42_special = DFA.unpackEncodedString(DFA42_specialS);
    static final short[][] DFA42_transition;

    static {
        int numStates = DFA42_transitionS.length;
        DFA42_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA42_transition[i] = DFA.unpackEncodedString(DFA42_transitionS[i]);
        }
    }

    class DFA42 extends DFA {

        public DFA42(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 42;
            this.eot = DFA42_eot;
            this.eof = DFA42_eof;
            this.min = DFA42_min;
            this.max = DFA42_max;
            this.accept = DFA42_accept;
            this.special = DFA42_special;
            this.transition = DFA42_transition;
        }
        public String getDescription() {
            return "()* loopback of 398:23: ( (op= '==' relationalExpression | op= '=' relationalExpression | (op= '>' | op= '<' | op= '>=' | op= '<=' | op= '<>' ) additiveExpression ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA42_5 = input.LA(1);

                         
                        int index42_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred67_EolParserRules()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index42_5);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA42_7 = input.LA(1);

                         
                        int index42_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred67_EolParserRules()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index42_7);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA42_3 = input.LA(1);

                         
                        int index42_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred67_EolParserRules()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index42_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA42_8 = input.LA(1);

                         
                        int index42_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred67_EolParserRules()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index42_8);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA42_2 = input.LA(1);

                         
                        int index42_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred67_EolParserRules()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index42_2);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA42_4 = input.LA(1);

                         
                        int index42_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred67_EolParserRules()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index42_4);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA42_6 = input.LA(1);

                         
                        int index42_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred67_EolParserRules()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index42_6);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 42, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA52_eotS =
        "\10\uffff";
    static final String DFA52_eofS =
        "\1\uffff\1\3\6\uffff";
    static final String DFA52_minS =
        "\1\23\2\4\1\uffff\1\11\1\4\1\uffff\1\11";
    static final String DFA52_maxS =
        "\1\23\1\u0098\1\u0093\1\uffff\1\u0091\1\u0093\1\uffff\1\u0091";
    static final String DFA52_acceptS =
        "\3\uffff\1\1\2\uffff\1\2\1\uffff";
    static final String DFA52_specialS =
        "\10\uffff}>";
    static final String[] DFA52_transitionS = {
            "\1\1",
            "\1\3\3\uffff\5\3\1\uffff\1\3\4\uffff\1\3\3\uffff\1\3\75\uffff"+
            "\1\3\1\uffff\1\3\2\uffff\4\3\1\2\2\3\1\uffff\1\3\3\uffff\11"+
            "\3\1\uffff\2\3\3\uffff\34\3\1\uffff\4\3\2\uffff\1\3",
            "\1\3\3\uffff\1\3\3\uffff\1\3\1\uffff\1\3\4\uffff\1\4\112\uffff"+
            "\2\3\6\uffff\10\3\35\uffff\1\3\2\uffff\1\3\3\uffff\2\3",
            "",
            "\1\3\1\uffff\1\3\113\uffff\1\5\3\uffff\1\3\2\uffff\2\3\1\6\2"+
            "\uffff\3\3\32\uffff\16\3\1\uffff\1\3\1\uffff\1\6",
            "\1\3\3\uffff\1\3\3\uffff\1\3\1\uffff\1\3\4\uffff\1\7\112\uffff"+
            "\1\3\7\uffff\10\3\35\uffff\1\3\2\uffff\1\3\3\uffff\2\3",
            "",
            "\1\3\1\uffff\1\3\113\uffff\1\5\3\uffff\1\3\2\uffff\2\3\1\6\2"+
            "\uffff\3\3\32\uffff\16\3\1\uffff\1\3\1\uffff\1\6"
    };

    static final short[] DFA52_eot = DFA.unpackEncodedString(DFA52_eotS);
    static final short[] DFA52_eof = DFA.unpackEncodedString(DFA52_eofS);
    static final char[] DFA52_min = DFA.unpackEncodedStringToUnsignedChars(DFA52_minS);
    static final char[] DFA52_max = DFA.unpackEncodedStringToUnsignedChars(DFA52_maxS);
    static final short[] DFA52_accept = DFA.unpackEncodedString(DFA52_acceptS);
    static final short[] DFA52_special = DFA.unpackEncodedString(DFA52_specialS);
    static final short[][] DFA52_transition;

    static {
        int numStates = DFA52_transitionS.length;
        DFA52_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA52_transition[i] = DFA.unpackEncodedString(DFA52_transitionS[i]);
        }
    }

    class DFA52 extends DFA {

        public DFA52(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 52;
            this.eot = DFA52_eot;
            this.eof = DFA52_eof;
            this.min = DFA52_min;
            this.max = DFA52_max;
            this.accept = DFA52_accept;
            this.special = DFA52_special;
            this.transition = DFA52_transition;
        }
        public String getDescription() {
            return "428:1: featureCall : ( simpleFeatureCall | declarativeFeatureCall );";
        }
    }
    static final String DFA60_eotS =
        "\27\uffff";
    static final String DFA60_eofS =
        "\2\2\25\uffff";
    static final String DFA60_minS =
        "\2\4\1\uffff\1\23\1\0\1\136\10\0\1\136\1\0\1\uffff\2\16\2\137\2"+
        "\0";
    static final String DFA60_maxS =
        "\1\u0098\1\u0093\1\uffff\1\155\1\0\1\136\10\0\1\136\1\0\1\uffff"+
        "\2\16\2\137\2\0";
    static final String DFA60_acceptS =
        "\2\uffff\1\2\15\uffff\1\1\6\uffff";
    static final String DFA60_specialS =
        "\4\uffff\1\6\1\uffff\1\13\1\4\1\2\1\7\1\5\1\0\1\11\1\12\1\uffff"+
        "\1\10\5\uffff\1\1\1\3}>";
    static final String[] DFA60_transitionS = {
            "\1\2\3\uffff\5\2\1\uffff\1\2\4\uffff\1\2\3\uffff\1\2\75\uffff"+
            "\1\2\1\uffff\1\2\2\uffff\6\2\1\1\1\uffff\1\2\3\uffff\11\2\1"+
            "\uffff\2\2\3\uffff\34\2\1\uffff\4\2\2\uffff\1\2",
            "\1\2\3\uffff\1\2\3\uffff\1\2\1\uffff\1\2\4\uffff\1\4\105\uffff"+
            "\2\2\3\uffff\1\2\7\uffff\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14"+
            "\1\2\1\uffff\4\2\1\uffff\11\2\15\uffff\1\2\2\uffff\1\2\3\uffff"+
            "\1\3\1\2",
            "",
            "\1\15\122\uffff\1\16\7\17",
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

    static final short[] DFA60_eot = DFA.unpackEncodedString(DFA60_eotS);
    static final short[] DFA60_eof = DFA.unpackEncodedString(DFA60_eofS);
    static final char[] DFA60_min = DFA.unpackEncodedStringToUnsignedChars(DFA60_minS);
    static final char[] DFA60_max = DFA.unpackEncodedStringToUnsignedChars(DFA60_maxS);
    static final short[] DFA60_accept = DFA.unpackEncodedString(DFA60_acceptS);
    static final short[] DFA60_special = DFA.unpackEncodedString(DFA60_specialS);
    static final short[][] DFA60_transition;

    static {
        int numStates = DFA60_transitionS.length;
        DFA60_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA60_transition[i] = DFA.unpackEncodedString(DFA60_transitionS[i]);
        }
    }

    class DFA60 extends DFA {

        public DFA60(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 60;
            this.eot = DFA60_eot;
            this.eof = DFA60_eof;
            this.min = DFA60_min;
            this.max = DFA60_max;
            this.accept = DFA60_accept;
            this.special = DFA60_special;
            this.transition = DFA60_transition;
        }
        public String getDescription() {
            return "468:18: ( ':' (n= 'new' )? t= typeName ( parameterList )? )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA60_11 = input.LA(1);

                         
                        int index60_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index60_11);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA60_21 = input.LA(1);

                         
                        int index60_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index60_21);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA60_8 = input.LA(1);

                         
                        int index60_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index60_8);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA60_22 = input.LA(1);

                         
                        int index60_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index60_22);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA60_7 = input.LA(1);

                         
                        int index60_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index60_7);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA60_10 = input.LA(1);

                         
                        int index60_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index60_10);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA60_4 = input.LA(1);

                         
                        int index60_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index60_4);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA60_9 = input.LA(1);

                         
                        int index60_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index60_9);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA60_15 = input.LA(1);

                         
                        int index60_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index60_15);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA60_12 = input.LA(1);

                         
                        int index60_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index60_12);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA60_13 = input.LA(1);

                         
                        int index60_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index60_13);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA60_6 = input.LA(1);

                         
                        int index60_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index60_6);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 60, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA64_eotS =
        "\22\uffff";
    static final String DFA64_eofS =
        "\22\uffff";
    static final String DFA64_minS =
        "\1\4\17\0\2\uffff";
    static final String DFA64_maxS =
        "\1\u0093\17\0\2\uffff";
    static final String DFA64_acceptS =
        "\20\uffff\1\1\1\2";
    static final String DFA64_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14"+
        "\1\15\1\16\2\uffff}>";
    static final String[] DFA64_transitionS = {
            "\1\12\3\uffff\1\12\3\uffff\1\12\1\uffff\1\12\4\uffff\1\13\112"+
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

    static final short[] DFA64_eot = DFA.unpackEncodedString(DFA64_eotS);
    static final short[] DFA64_eof = DFA.unpackEncodedString(DFA64_eofS);
    static final char[] DFA64_min = DFA.unpackEncodedStringToUnsignedChars(DFA64_minS);
    static final char[] DFA64_max = DFA.unpackEncodedStringToUnsignedChars(DFA64_maxS);
    static final short[] DFA64_accept = DFA.unpackEncodedString(DFA64_acceptS);
    static final short[] DFA64_special = DFA.unpackEncodedString(DFA64_specialS);
    static final short[][] DFA64_transition;

    static {
        int numStates = DFA64_transitionS.length;
        DFA64_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA64_transition[i] = DFA.unpackEncodedString(DFA64_transitionS[i]);
        }
    }

    class DFA64 extends DFA {

        public DFA64(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 64;
            this.eot = DFA64_eot;
            this.eof = DFA64_eof;
            this.min = DFA64_min;
            this.max = DFA64_max;
            this.accept = DFA64_accept;
            this.special = DFA64_special;
            this.transition = DFA64_transition;
        }
        public String getDescription() {
            return "493:1: expressionListOrRange : ( expressionRange | expressionList );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA64_1 = input.LA(1);

                         
                        int index64_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred94_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index64_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA64_2 = input.LA(1);

                         
                        int index64_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred94_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index64_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA64_3 = input.LA(1);

                         
                        int index64_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred94_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index64_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA64_4 = input.LA(1);

                         
                        int index64_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred94_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index64_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA64_5 = input.LA(1);

                         
                        int index64_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred94_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index64_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA64_6 = input.LA(1);

                         
                        int index64_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred94_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index64_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA64_7 = input.LA(1);

                         
                        int index64_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred94_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index64_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA64_8 = input.LA(1);

                         
                        int index64_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred94_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index64_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA64_9 = input.LA(1);

                         
                        int index64_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred94_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index64_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA64_10 = input.LA(1);

                         
                        int index64_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred94_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index64_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA64_11 = input.LA(1);

                         
                        int index64_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred94_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index64_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA64_12 = input.LA(1);

                         
                        int index64_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred94_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index64_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA64_13 = input.LA(1);

                         
                        int index64_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred94_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index64_13);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA64_14 = input.LA(1);

                         
                        int index64_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred94_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index64_14);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA64_15 = input.LA(1);

                         
                        int index64_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred94_EolParserRules()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index64_15);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 64, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA67_eotS =
        "\23\uffff";
    static final String DFA67_eofS =
        "\1\uffff\7\17\13\uffff";
    static final String DFA67_minS =
        "\10\4\1\uffff\1\0\11\uffff";
    static final String DFA67_maxS =
        "\1\u0093\7\u0098\1\uffff\1\0\11\uffff";
    static final String DFA67_acceptS =
        "\10\uffff\1\3\1\uffff\1\6\1\10\1\11\1\12\1\1\1\7\1\2\1\4\1\5";
    static final String DFA67_specialS =
        "\11\uffff\1\0\11\uffff}>";
    static final String[] DFA67_transitionS = {
            "\1\10\3\uffff\1\10\3\uffff\1\10\1\uffff\1\10\4\uffff\1\11\112"+
            "\uffff\1\13\7\uffff\1\12\1\1\1\2\1\3\1\4\1\5\1\6\1\7\44\uffff"+
            "\1\14\1\15",
            "\1\17\3\uffff\5\17\1\uffff\1\17\4\uffff\1\17\3\uffff\1\17\75"+
            "\uffff\1\17\1\uffff\1\17\1\uffff\1\16\7\17\1\uffff\1\17\3\uffff"+
            "\11\17\1\uffff\2\17\3\uffff\34\17\1\uffff\4\17\2\uffff\1\17",
            "\1\17\3\uffff\5\17\1\uffff\1\17\4\uffff\1\17\3\uffff\1\17\75"+
            "\uffff\1\17\1\uffff\1\17\1\uffff\1\16\7\17\1\uffff\1\17\3\uffff"+
            "\11\17\1\uffff\2\17\3\uffff\34\17\1\uffff\4\17\2\uffff\1\17",
            "\1\17\3\uffff\5\17\1\uffff\1\17\4\uffff\1\17\3\uffff\1\17\75"+
            "\uffff\1\17\1\uffff\1\17\1\uffff\1\16\7\17\1\uffff\1\17\3\uffff"+
            "\11\17\1\uffff\2\17\3\uffff\34\17\1\uffff\4\17\2\uffff\1\17",
            "\1\17\3\uffff\5\17\1\uffff\1\17\4\uffff\1\17\3\uffff\1\17\75"+
            "\uffff\1\17\1\uffff\1\17\1\uffff\1\16\7\17\1\uffff\1\17\3\uffff"+
            "\11\17\1\uffff\2\17\3\uffff\34\17\1\uffff\4\17\2\uffff\1\17",
            "\1\17\3\uffff\5\17\1\uffff\1\17\4\uffff\1\17\3\uffff\1\17\75"+
            "\uffff\1\17\1\uffff\1\17\1\uffff\1\16\7\17\1\uffff\1\17\3\uffff"+
            "\11\17\1\uffff\2\17\3\uffff\34\17\1\uffff\4\17\2\uffff\1\17",
            "\1\17\3\uffff\5\17\1\uffff\1\17\4\uffff\1\17\3\uffff\1\17\75"+
            "\uffff\1\17\1\uffff\1\17\1\uffff\1\16\7\17\1\uffff\1\17\3\uffff"+
            "\11\17\1\uffff\2\17\3\uffff\34\17\1\uffff\4\17\2\uffff\1\17",
            "\1\17\3\uffff\5\17\1\uffff\1\17\4\uffff\1\17\3\uffff\1\17\75"+
            "\uffff\1\17\1\uffff\1\17\1\uffff\1\20\7\17\1\uffff\1\17\3\uffff"+
            "\11\17\1\uffff\2\17\3\uffff\34\17\1\uffff\4\17\2\uffff\1\17",
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

    static final short[] DFA67_eot = DFA.unpackEncodedString(DFA67_eotS);
    static final short[] DFA67_eof = DFA.unpackEncodedString(DFA67_eofS);
    static final char[] DFA67_min = DFA.unpackEncodedStringToUnsignedChars(DFA67_minS);
    static final char[] DFA67_max = DFA.unpackEncodedStringToUnsignedChars(DFA67_maxS);
    static final short[] DFA67_accept = DFA.unpackEncodedString(DFA67_acceptS);
    static final short[] DFA67_special = DFA.unpackEncodedString(DFA67_specialS);
    static final short[][] DFA67_transition;

    static {
        int numStates = DFA67_transitionS.length;
        DFA67_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA67_transition[i] = DFA.unpackEncodedString(DFA67_transitionS[i]);
        }
    }

    class DFA67 extends DFA {

        public DFA67(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 67;
            this.eot = DFA67_eot;
            this.eof = DFA67_eof;
            this.min = DFA67_min;
            this.max = DFA67_max;
            this.accept = DFA67_accept;
            this.special = DFA67_special;
            this.transition = DFA67_transition;
        }
        public String getDescription() {
            return "519:1: primitiveExpression : ( literalSequentialCollection | literalMapCollection | literal | featureCall | pathName | nativeType | collectionType | logicalExpressionInBrackets | newExpression | variableDeclarationExpression );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA67_9 = input.LA(1);

                         
                        int index67_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred100_EolParserRules()) ) {s = 17;}

                        else if ( (synpred101_EolParserRules()) ) {s = 18;}

                         
                        input.seek(index67_9);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 67, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_operationDeclaration_in_operationDeclarationOrAnnotationBlock250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationBlock_in_operationDeclarationOrAnnotationBlock252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_modelDeclaration271 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_modelDeclaration274 = new BitSet(new long[]{0x0000000000000000L,0x0000000003600000L});
    public static final BitSet FOLLOW_modelAlias_in_modelDeclaration276 = new BitSet(new long[]{0x0000000000000000L,0x0000000003200000L});
    public static final BitSet FOLLOW_modelDriver_in_modelDeclaration279 = new BitSet(new long[]{0x0000000000000000L,0x0000000002200000L});
    public static final BitSet FOLLOW_modelDeclarationParameters_in_modelDeclaration282 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_85_in_modelDeclaration287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_86_in_modelAlias302 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_modelAlias305 = new BitSet(new long[]{0x0000000000000002L,0x0000000000800000L});
    public static final BitSet FOLLOW_87_in_modelAlias308 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_modelAlias311 = new BitSet(new long[]{0x0000000000000002L,0x0000000000800000L});
    public static final BitSet FOLLOW_88_in_modelDriver330 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_modelDriver333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_89_in_modelDeclarationParameters355 = new BitSet(new long[]{0x0000000000080000L,0x0000000004800000L});
    public static final BitSet FOLLOW_modelDeclarationParameter_in_modelDeclarationParameters358 = new BitSet(new long[]{0x0000000000000000L,0x0000000004800000L});
    public static final BitSet FOLLOW_87_in_modelDeclarationParameters362 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_modelDeclarationParameter_in_modelDeclarationParameters365 = new BitSet(new long[]{0x0000000000000000L,0x0000000004800000L});
    public static final BitSet FOLLOW_90_in_modelDeclarationParameters371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_modelDeclarationParameter384 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_91_in_modelDeclarationParameter388 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_STRING_in_modelDeclarationParameter391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_operationDeclaration412 = new BitSet(new long[]{0x0000000000080000L,0x00003FC000000000L});
    public static final BitSet FOLLOW_typeName_in_operationDeclaration422 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_operationDeclaration430 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_94_in_operationDeclaration434 = new BitSet(new long[]{0x0000000000080000L,0x0000000080000000L});
    public static final BitSet FOLLOW_formalParameterList_in_operationDeclaration437 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_operationDeclaration442 = new BitSet(new long[]{0x0000000000000000L,0x0000000102000000L});
    public static final BitSet FOLLOW_96_in_operationDeclaration446 = new BitSet(new long[]{0x0000000000080000L,0x00003FC000000000L});
    public static final BitSet FOLLOW_typeName_in_operationDeclaration451 = new BitSet(new long[]{0x0000000000000000L,0x0000000102000000L});
    public static final BitSet FOLLOW_statementBlock_in_operationDeclaration457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_97_in_importStatement477 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_STRING_in_importStatement480 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_85_in_importStatement484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_block504 = new BitSet(new long[]{0x0000000000085112L,0x3FE37FC040000000L,0x00000000000C4800L});
    public static final BitSet FOLLOW_89_in_statementBlock533 = new BitSet(new long[]{0x0000000000085110L,0x3FE37FC040000000L,0x00000000000C4800L});
    public static final BitSet FOLLOW_block_in_statementBlock536 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_90_in_statementBlock540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_formalParameter558 = new BitSet(new long[]{0x0000000000000002L,0x0000000100000000L});
    public static final BitSet FOLLOW_96_in_formalParameter561 = new BitSet(new long[]{0x0000000000080000L,0x00003FC000000000L});
    public static final BitSet FOLLOW_typeName_in_formalParameter565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_formalParameter_in_formalParameterList599 = new BitSet(new long[]{0x0000000000000002L,0x0000000000800000L});
    public static final BitSet FOLLOW_87_in_formalParameterList602 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_formalParameter_in_formalParameterList604 = new BitSet(new long[]{0x0000000000000002L,0x0000000000800000L});
    public static final BitSet FOLLOW_98_in_executableAnnotation629 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0xFFFFFFFFFFFFFFFFL,0x000000003FFFFFFFL});
    public static final BitSet FOLLOW_logicalExpression_in_executableAnnotation636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Annotation_in_annotation650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_executableAnnotation_in_annotation652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotation_in_annotationBlock669 = new BitSet(new long[]{0x0000000000800002L,0x0000000400000000L});
    public static final BitSet FOLLOW_pathName_in_typeName698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nativeType_in_typeName702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectionType_in_typeName706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_pathName720 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_99_in_pathName722 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_packagedType_in_pathName731 = new BitSet(new long[]{0x0000000000000002L,0x0000001000000000L});
    public static final BitSet FOLLOW_100_in_pathName737 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_pathName742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_packagedType763 = new BitSet(new long[]{0x0000000000000002L,0x0000002000000000L});
    public static final BitSet FOLLOW_101_in_packagedType766 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_packagedType771 = new BitSet(new long[]{0x0000000000000002L,0x0000002000000000L});
    public static final BitSet FOLLOW_102_in_nativeType799 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_94_in_nativeType804 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_STRING_in_nativeType807 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_nativeType811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_collectionType829 = new BitSet(new long[]{0x0000000000000002L,0x0000000040000000L});
    public static final BitSet FOLLOW_94_in_collectionType851 = new BitSet(new long[]{0x0000000000080000L,0x00003FC000000000L});
    public static final BitSet FOLLOW_typeName_in_collectionType856 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_collectionType862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementA_in_statement877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementB_in_statement881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignmentStatement_in_statementA892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionStatement_in_statementA896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_forStatement_in_statementA900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStatement_in_statementA906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_whileStatement_in_statementA910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_switchStatement_in_statementA914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_returnStatement_in_statementA918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_breakStatement_in_statementA922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_breakAllStatement_in_statementB934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_returnStatement_in_statementB938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_transactionStatement_in_statementB942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_abortStatement_in_statementB948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_continueStatement_in_statementB952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_throwStatement_in_statementB956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_deleteStatement_in_statementB962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_statementOrStatementBlock973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementBlock_in_statementOrStatementBlock977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_96_in_expressionOrStatementBlock986 = new BitSet(new long[]{0x0000000000085110L,0x00003FC040000000L,0x00000000000C4800L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionOrStatementBlock989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementBlock_in_expressionOrStatementBlock993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_110_in_forStatement1006 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_94_in_forStatement1009 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_formalParameter_in_forStatement1012 = new BitSet(new long[]{0x0000000000000000L,0x0000800000000000L});
    public static final BitSet FOLLOW_111_in_forStatement1014 = new BitSet(new long[]{0x0000000000085110L,0x00003FC040000000L,0x00000000000C4800L});
    public static final BitSet FOLLOW_logicalExpression_in_forStatement1017 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_forStatement1019 = new BitSet(new long[]{0x0000000000085110L,0x3FE37FC142000000L,0x00000000000C4800L});
    public static final BitSet FOLLOW_statementOrStatementBlock_in_forStatement1022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_112_in_ifStatement1038 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_94_in_ifStatement1041 = new BitSet(new long[]{0x0000000000085110L,0x00003FC040000000L,0x00000000000C4800L});
    public static final BitSet FOLLOW_logicalExpression_in_ifStatement1044 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_ifStatement1046 = new BitSet(new long[]{0x0000000000085110L,0x3FE37FC142000000L,0x00000000000C4800L});
    public static final BitSet FOLLOW_statementOrStatementBlock_in_ifStatement1049 = new BitSet(new long[]{0x0000000000000002L,0x0010000000000000L});
    public static final BitSet FOLLOW_elseStatement_in_ifStatement1051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_113_in_switchStatement1070 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_94_in_switchStatement1073 = new BitSet(new long[]{0x0000000000085110L,0x00003FC040000000L,0x00000000000C4800L});
    public static final BitSet FOLLOW_logicalExpression_in_switchStatement1076 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_switchStatement1078 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_89_in_switchStatement1081 = new BitSet(new long[]{0x0000000000000000L,0x000C000004000000L});
    public static final BitSet FOLLOW_caseStatement_in_switchStatement1084 = new BitSet(new long[]{0x0000000000000000L,0x000C000004000000L});
    public static final BitSet FOLLOW_defaultStatement_in_switchStatement1087 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_90_in_switchStatement1090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_114_in_caseStatement1109 = new BitSet(new long[]{0x0000000000085110L,0x00003FC040000000L,0x00000000000C4800L});
    public static final BitSet FOLLOW_logicalExpression_in_caseStatement1112 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_96_in_caseStatement1114 = new BitSet(new long[]{0x0000000000085110L,0x3FE37FC142000000L,0x00000000000C4800L});
    public static final BitSet FOLLOW_block_in_caseStatement1118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementBlock_in_caseStatement1122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_115_in_defaultStatement1141 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_96_in_defaultStatement1144 = new BitSet(new long[]{0x0000000000085110L,0x3FE37FC142000000L,0x00000000000C4800L});
    public static final BitSet FOLLOW_block_in_defaultStatement1148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementBlock_in_defaultStatement1152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_116_in_elseStatement1177 = new BitSet(new long[]{0x0000000000085110L,0x3FE37FC142000000L,0x00000000000C4800L});
    public static final BitSet FOLLOW_statementOrStatementBlock_in_elseStatement1180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_117_in_whileStatement1193 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_94_in_whileStatement1196 = new BitSet(new long[]{0x0000000000085110L,0x00003FC040000000L,0x00000000000C4800L});
    public static final BitSet FOLLOW_logicalExpression_in_whileStatement1199 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_whileStatement1201 = new BitSet(new long[]{0x0000000000085110L,0x3FE37FC142000000L,0x00000000000C4800L});
    public static final BitSet FOLLOW_statementOrStatementBlock_in_whileStatement1204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_118_in_returnStatement1226 = new BitSet(new long[]{0x0000000000085110L,0x00003FC040200000L,0x00000000000C4800L});
    public static final BitSet FOLLOW_logicalExpression_in_returnStatement1229 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_85_in_returnStatement1234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_119_in_throwStatement1257 = new BitSet(new long[]{0x0000000000085110L,0x00003FC040200000L,0x00000000000C4800L});
    public static final BitSet FOLLOW_logicalExpression_in_throwStatement1260 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_85_in_throwStatement1265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_120_in_deleteStatement1288 = new BitSet(new long[]{0x0000000000085110L,0x00003FC040200000L,0x00000000000C4800L});
    public static final BitSet FOLLOW_logicalExpression_in_deleteStatement1291 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_85_in_deleteStatement1296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_121_in_breakStatement1322 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_85_in_breakStatement1327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_122_in_breakAllStatement1350 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_85_in_breakAllStatement1355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_123_in_continueStatement1378 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_85_in_continueStatement1383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_124_in_abortStatement1406 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_85_in_abortStatement1411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_125_in_transactionStatement1428 = new BitSet(new long[]{0x0000000000085110L,0x3FE37FC142000000L,0x00000000000C4800L});
    public static final BitSet FOLLOW_NAME_in_transactionStatement1432 = new BitSet(new long[]{0x0000000000085110L,0x3FE37FC142800000L,0x00000000000C4800L});
    public static final BitSet FOLLOW_87_in_transactionStatement1435 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_transactionStatement1437 = new BitSet(new long[]{0x0000000000085110L,0x3FE37FC142800000L,0x00000000000C4800L});
    public static final BitSet FOLLOW_statementOrStatementBlock_in_transactionStatement1443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logicalExpression_in_assignmentStatement1463 = new BitSet(new long[]{0x0000000000000000L,0xC000000000000000L});
    public static final BitSet FOLLOW_126_in_assignmentStatement1468 = new BitSet(new long[]{0x0000000000085110L,0x00003FC040000000L,0x00000000000C4800L});
    public static final BitSet FOLLOW_127_in_assignmentStatement1475 = new BitSet(new long[]{0x0000000000085110L,0x00003FC040000000L,0x00000000000C4800L});
    public static final BitSet FOLLOW_logicalExpression_in_assignmentStatement1481 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_85_in_assignmentStatement1485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_postfixExpression_in_expressionStatement1507 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_91_in_expressionStatement1511 = new BitSet(new long[]{0x0000000000085110L,0x00003FC040000000L,0x00000000000C4800L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionStatement1514 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionStatement1520 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_85_in_expressionStatement1525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_relationalExpression_in_logicalExpression1537 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x000000000000000FL});
    public static final BitSet FOLLOW_128_in_logicalExpression1543 = new BitSet(new long[]{0x0000000000085110L,0x00003FC040000000L,0x00000000000C4800L});
    public static final BitSet FOLLOW_129_in_logicalExpression1548 = new BitSet(new long[]{0x0000000000085110L,0x00003FC040000000L,0x00000000000C4800L});
    public static final BitSet FOLLOW_130_in_logicalExpression1553 = new BitSet(new long[]{0x0000000000085110L,0x00003FC040000000L,0x00000000000C4800L});
    public static final BitSet FOLLOW_131_in_logicalExpression1558 = new BitSet(new long[]{0x0000000000085110L,0x00003FC040000000L,0x00000000000C4800L});
    public static final BitSet FOLLOW_relationalExpression_in_logicalExpression1562 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x000000000000000FL});
    public static final BitSet FOLLOW_additiveExpression_in_relationalExpression1579 = new BitSet(new long[]{0x0000000000000002L,0x0000000008000000L,0x00000000000003F0L});
    public static final BitSet FOLLOW_132_in_relationalExpression1585 = new BitSet(new long[]{0x0000000000085110L,0x00003FC040000000L,0x00000000000C4800L});
    public static final BitSet FOLLOW_relationalExpression_in_relationalExpression1588 = new BitSet(new long[]{0x0000000000000002L,0x0000000008000000L,0x00000000000003F0L});
    public static final BitSet FOLLOW_91_in_relationalExpression1594 = new BitSet(new long[]{0x0000000000085110L,0x00003FC040000000L,0x00000000000C4800L});
    public static final BitSet FOLLOW_relationalExpression_in_relationalExpression1597 = new BitSet(new long[]{0x0000000000000002L,0x0000000008000000L,0x00000000000003F0L});
    public static final BitSet FOLLOW_133_in_relationalExpression1627 = new BitSet(new long[]{0x0000000000085110L,0x00003FC040000000L,0x00000000000C4800L});
    public static final BitSet FOLLOW_134_in_relationalExpression1632 = new BitSet(new long[]{0x0000000000085110L,0x00003FC040000000L,0x00000000000C4800L});
    public static final BitSet FOLLOW_135_in_relationalExpression1637 = new BitSet(new long[]{0x0000000000085110L,0x00003FC040000000L,0x00000000000C4800L});
    public static final BitSet FOLLOW_136_in_relationalExpression1642 = new BitSet(new long[]{0x0000000000085110L,0x00003FC040000000L,0x00000000000C4800L});
    public static final BitSet FOLLOW_137_in_relationalExpression1647 = new BitSet(new long[]{0x0000000000085110L,0x00003FC040000000L,0x00000000000C4800L});
    public static final BitSet FOLLOW_additiveExpression_in_relationalExpression1651 = new BitSet(new long[]{0x0000000000000002L,0x0000000008000000L,0x00000000000003F0L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_additiveExpression1669 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000C00L});
    public static final BitSet FOLLOW_138_in_additiveExpression1675 = new BitSet(new long[]{0x0000000000085110L,0x00003FC040000000L,0x00000000000C4800L});
    public static final BitSet FOLLOW_139_in_additiveExpression1680 = new BitSet(new long[]{0x0000000000085110L,0x00003FC040000000L,0x00000000000C4800L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_additiveExpression1684 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000C00L});
    public static final BitSet FOLLOW_unaryExpression_in_multiplicativeExpression1702 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000003000L});
    public static final BitSet FOLLOW_140_in_multiplicativeExpression1708 = new BitSet(new long[]{0x0000000000085110L,0x00003FC040000000L,0x00000000000C4800L});
    public static final BitSet FOLLOW_141_in_multiplicativeExpression1713 = new BitSet(new long[]{0x0000000000085110L,0x00003FC040000000L,0x00000000000C4800L});
    public static final BitSet FOLLOW_unaryExpression_in_multiplicativeExpression1717 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000003000L});
    public static final BitSet FOLLOW_142_in_unaryExpression1738 = new BitSet(new long[]{0x0000000000085110L,0x00003FC040000000L,0x00000000000C4800L});
    public static final BitSet FOLLOW_139_in_unaryExpression1743 = new BitSet(new long[]{0x0000000000085110L,0x00003FC040000000L,0x00000000000C4800L});
    public static final BitSet FOLLOW_postfixExpression_in_unaryExpression1751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_itemSelectorExpression_in_postfixExpression1763 = new BitSet(new long[]{0x0000000000000A02L});
    public static final BitSet FOLLOW_set_in_postfixExpression1766 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_featureCall_in_postfixExpression1775 = new BitSet(new long[]{0x0000000000000A02L,0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_143_in_postfixExpression1784 = new BitSet(new long[]{0x0000000000085110L,0x00003FC040000000L,0x00000000000C4800L});
    public static final BitSet FOLLOW_logicalExpression_in_postfixExpression1787 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_144_in_postfixExpression1789 = new BitSet(new long[]{0x0000000000000A02L,0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_primitiveExpression_in_itemSelectorExpression1811 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_143_in_itemSelectorExpression1816 = new BitSet(new long[]{0x0000000000085110L,0x00003FC040000000L,0x00000000000C4800L});
    public static final BitSet FOLLOW_primitiveExpression_in_itemSelectorExpression1819 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_144_in_itemSelectorExpression1821 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_simpleFeatureCall_in_featureCall1840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declarativeFeatureCall_in_featureCall1844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_simpleFeatureCall1858 = new BitSet(new long[]{0x0000000000000002L,0x0000000040000000L});
    public static final BitSet FOLLOW_parameterList_in_simpleFeatureCall1861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_parameterList1884 = new BitSet(new long[]{0x0000000000085110L,0x00003FC0C0000000L,0x00000000000C4800L});
    public static final BitSet FOLLOW_logicalExpression_in_parameterList1887 = new BitSet(new long[]{0x0000000000000000L,0x0000000080800000L});
    public static final BitSet FOLLOW_87_in_parameterList1890 = new BitSet(new long[]{0x0000000000085110L,0x00003FC040000000L,0x00000000000C4800L});
    public static final BitSet FOLLOW_logicalExpression_in_parameterList1892 = new BitSet(new long[]{0x0000000000000000L,0x0000000080800000L});
    public static final BitSet FOLLOW_95_in_parameterList1900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_declarativeFeatureCall1928 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_94_in_declarativeFeatureCall1933 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_formalParameterList_in_declarativeFeatureCall1936 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_145_in_declarativeFeatureCall1938 = new BitSet(new long[]{0x0000000000085110L,0x00003FC040000000L,0x00000000000C4800L});
    public static final BitSet FOLLOW_logicalExpression_in_declarativeFeatureCall1941 = new BitSet(new long[]{0x0000000000000000L,0x0000000080800000L});
    public static final BitSet FOLLOW_87_in_declarativeFeatureCall1944 = new BitSet(new long[]{0x0000000000085110L,0x00003FC040000000L,0x00000000000C4800L});
    public static final BitSet FOLLOW_logicalExpression_in_declarativeFeatureCall1947 = new BitSet(new long[]{0x0000000000000000L,0x0000000080800000L});
    public static final BitSet FOLLOW_95_in_declarativeFeatureCall1953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_146_in_newExpression1967 = new BitSet(new long[]{0x0000000000080000L,0x00003FC000000000L});
    public static final BitSet FOLLOW_typeName_in_newExpression1972 = new BitSet(new long[]{0x0000000000000002L,0x0000000040000000L});
    public static final BitSet FOLLOW_parameterList_in_newExpression1976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_147_in_variableDeclarationExpression1998 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_variableDeclarationExpression2001 = new BitSet(new long[]{0x0000000000000002L,0x0000000100000000L});
    public static final BitSet FOLLOW_96_in_variableDeclarationExpression2004 = new BitSet(new long[]{0x0000000000080000L,0x00003FC000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_146_in_variableDeclarationExpression2009 = new BitSet(new long[]{0x0000000000080000L,0x00003FC000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_typeName_in_variableDeclarationExpression2015 = new BitSet(new long[]{0x0000000000000002L,0x0000000040000000L});
    public static final BitSet FOLLOW_parameterList_in_variableDeclarationExpression2019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_103_in_literalSequentialCollection2043 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_104_in_literalSequentialCollection2048 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_105_in_literalSequentialCollection2053 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_106_in_literalSequentialCollection2058 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_107_in_literalSequentialCollection2063 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_108_in_literalSequentialCollection2068 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_89_in_literalSequentialCollection2074 = new BitSet(new long[]{0x0000000000085110L,0x00003FC044000000L,0x00000000000C4800L});
    public static final BitSet FOLLOW_expressionListOrRange_in_literalSequentialCollection2078 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_90_in_literalSequentialCollection2083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionRange2098 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_POINT_POINT_in_expressionRange2102 = new BitSet(new long[]{0x0000000000085110L,0x00003FC040000000L,0x00000000000C4800L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionRange2105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionList2126 = new BitSet(new long[]{0x0000000000000002L,0x0000000000800000L});
    public static final BitSet FOLLOW_87_in_expressionList2129 = new BitSet(new long[]{0x0000000000085110L,0x00003FC040000000L,0x00000000000C4800L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionList2131 = new BitSet(new long[]{0x0000000000000002L,0x0000000000800000L});
    public static final BitSet FOLLOW_expressionRange_in_expressionListOrRange2155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionList_in_expressionListOrRange2159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_109_in_literalMapCollection2178 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_89_in_literalMapCollection2183 = new BitSet(new long[]{0x0000000000085110L,0x00003FC044000000L,0x00000000000C4800L});
    public static final BitSet FOLLOW_keyvalExpressionList_in_literalMapCollection2186 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_90_in_literalMapCollection2191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_keyvalExpression_in_keyvalExpressionList2212 = new BitSet(new long[]{0x0000000000000002L,0x0000000000800000L});
    public static final BitSet FOLLOW_87_in_keyvalExpressionList2215 = new BitSet(new long[]{0x0000000000085110L,0x00003FC040000000L,0x00000000000C4800L});
    public static final BitSet FOLLOW_keyvalExpression_in_keyvalExpressionList2217 = new BitSet(new long[]{0x0000000000000002L,0x0000000000800000L});
    public static final BitSet FOLLOW_additiveExpression_in_keyvalExpression2242 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_91_in_keyvalExpression2246 = new BitSet(new long[]{0x0000000000085110L,0x00003FC040000000L,0x00000000000C4800L});
    public static final BitSet FOLLOW_logicalExpression_in_keyvalExpression2249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literalSequentialCollection_in_primitiveExpression2263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literalMapCollection_in_primitiveExpression2267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_primitiveExpression2271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_featureCall_in_primitiveExpression2275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pathName_in_primitiveExpression2279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nativeType_in_primitiveExpression2283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectionType_in_primitiveExpression2289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logicalExpressionInBrackets_in_primitiveExpression2294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_newExpression_in_primitiveExpression2300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variableDeclarationExpression_in_primitiveExpression2304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_logicalExpressionInBrackets2323 = new BitSet(new long[]{0x0000000000085110L,0x00003FC040000000L,0x00000000000C4800L});
    public static final BitSet FOLLOW_logicalExpression_in_logicalExpressionInBrackets2326 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_logicalExpressionInBrackets2330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_literal0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotation_in_synpred16_EolParserRules669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_synpred28_EolParserRules851 = new BitSet(new long[]{0x0000000000080000L,0x00003FC000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_typeName_in_synpred28_EolParserRules856 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_synpred28_EolParserRules862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementA_in_synpred29_EolParserRules877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignmentStatement_in_synpred30_EolParserRules892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionStatement_in_synpred31_EolParserRules896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_elseStatement_in_synpred45_EolParserRules1051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_synpred54_EolParserRules1432 = new BitSet(new long[]{0x0000000000000002L,0x0000000000800000L});
    public static final BitSet FOLLOW_87_in_synpred54_EolParserRules1435 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_synpred54_EolParserRules1437 = new BitSet(new long[]{0x0000000000000002L,0x0000000000800000L});
    public static final BitSet FOLLOW_postfixExpression_in_synpred56_EolParserRules1507 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_91_in_synpred56_EolParserRules1511 = new BitSet(new long[]{0x0000000000085110L,0x00003FC040000000L,0x00000000000C4800L});
    public static final BitSet FOLLOW_logicalExpression_in_synpred56_EolParserRules1514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_132_in_synpred67_EolParserRules1585 = new BitSet(new long[]{0x0000000000085110L,0x00003FC040000000L,0x00000000000C4800L});
    public static final BitSet FOLLOW_relationalExpression_in_synpred67_EolParserRules1588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_91_in_synpred67_EolParserRules1594 = new BitSet(new long[]{0x0000000000085110L,0x00003FC040000000L,0x00000000000C4800L});
    public static final BitSet FOLLOW_relationalExpression_in_synpred67_EolParserRules1597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred67_EolParserRules1624 = new BitSet(new long[]{0x0000000000085110L,0x00003FC040000000L,0x00000000000C4800L});
    public static final BitSet FOLLOW_additiveExpression_in_synpred67_EolParserRules1651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_96_in_synpred86_EolParserRules2004 = new BitSet(new long[]{0x0000000000080000L,0x00003FC000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_146_in_synpred86_EolParserRules2009 = new BitSet(new long[]{0x0000000000080000L,0x00003FC000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_typeName_in_synpred86_EolParserRules2015 = new BitSet(new long[]{0x0000000000000002L,0x0000000040000000L});
    public static final BitSet FOLLOW_parameterList_in_synpred86_EolParserRules2019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionRange_in_synpred94_EolParserRules2155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_featureCall_in_synpred100_EolParserRules2275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pathName_in_synpred101_EolParserRules2279 = new BitSet(new long[]{0x0000000000000002L});

}
