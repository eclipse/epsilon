package org.eclipse.epsilon.epl.parse;

// $ANTLR 3.1b1 EolParserRules.g 2013-07-09 11:28:06

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
public class Epl_EolParserRules extends org.eclipse.epsilon.common.parse.EpsilonParser {
    public static final int EXPONENT=6;
    public static final int T__159=159;
    public static final int WHILE=33;
    public static final int StatementBlock=29;
    public static final int T__158=158;
    public static final int StrangeNameLiteral=15;
    public static final int CASE=35;
    public static final int NEW=49;
    public static final int T__160=160;
    public static final int DO=87;
    public static final int FeatureCall=59;
    public static final int T__167=167;
    public static final int EOF=-1;
    public static final int T__168=168;
    public static final int T__165=165;
    public static final int BREAK=38;
    public static final int T__166=166;
    public static final int T__163=163;
    public static final int T__164=164;
    public static final int KEYVALLIST=75;
    public static final int TYPE=63;
    public static final int T__161=161;
    public static final int T__162=162;
    public static final int PATTERN=80;
    public static final int T__93=93;
    public static final int T__94=94;
    public static final int IMPORT=65;
    public static final int NAME=19;
    public static final int T__92=92;
    public static final int T__148=148;
    public static final int T__147=147;
    public static final int T__149=149;
    public static final int RETURN=37;
    public static final int NewExpression=47;
    public static final int VAR=48;
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
    public static final int ACTIVE=90;
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
    public static final int EPLMODULE=91;
    public static final int ROLE=83;
    public static final int LINE_COMMENT=22;
    public static final int BREAKALL=39;
    public static final int TRANSACTION=41;
    public static final int SWITCH=34;
    public static final int DRIVER=69;
    public static final int NO=88;
    public static final int ELSE=32;
    public static final int EOLMODULE=60;
    public static final int MODELDECLARATION=66;
    public static final int PARAMLIST=25;
    public static final int MATCH=84;
    public static final int INT=8;
    public static final int DELETE=52;
    public static final int T__141=141;
    public static final int T__142=142;
    public static final int HELPERMETHOD=28;
    public static final int T__140=140;
    public static final int T__145=145;
    public static final int NAMESPACE=67;
    public static final int T__146=146;
    public static final int CollectionType=44;
    public static final int T__143=143;
    public static final int CARDINALITY=81;
    public static final int T__144=144;
    public static final int T__126=126;
    public static final int T__125=125;
    public static final int T__128=128;
    public static final int T__127=127;
    public static final int WS=20;
    public static final int T__129=129;
    public static final int ALIAS=68;
    public static final int JavaIDDigit=18;
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
    public static final int NOMATCH=85;
    public static final int OPERATOR=58;
    public static final int EXPRLIST=54;
    public static final int DEFAULT=36;
    public static final int T__102=102;
    public static final int T__101=101;
    public static final int T__100=100;
    public static final int DOMAIN=82;
    public static final int OPTIONAL=89;
    public static final int POINT_POINT=10;
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
    public static final int ONMATCH=86;
    public static final int STRING=14;

    // delegates
    // delegators
    public EplParser gEpl;


        public Epl_EolParserRules(TokenStream input, EplParser gEpl) {
            this(input, new RecognizerSharedState(), gEpl);
        }
        public Epl_EolParserRules(TokenStream input, RecognizerSharedState state, EplParser gEpl) {
            super(input, state);
            this.gEpl = gEpl;
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return EplParser.tokenNames; }
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
    public final Epl_EolParserRules.operationDeclarationOrAnnotationBlock_return operationDeclarationOrAnnotationBlock() throws RecognitionException {
        Epl_EolParserRules.operationDeclarationOrAnnotationBlock_return retval = new Epl_EolParserRules.operationDeclarationOrAnnotationBlock_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Epl_EolParserRules.operationDeclaration_return operationDeclaration1 = null;

        Epl_EolParserRules.annotationBlock_return annotationBlock2 = null;



        try {
            // EolParserRules.g:105:2: ( operationDeclaration | annotationBlock )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( ((LA1_0>=100 && LA1_0<=101)) ) {
                alt1=1;
            }
            else if ( (LA1_0==Annotation||LA1_0==106) ) {
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
    // EolParserRules.g:108:1: modelDeclaration : m= 'model' NAME ( modelAlias )? ( modelDriver )? ( modelDeclarationParameters )? ';' ;
    public final Epl_EolParserRules.modelDeclaration_return modelDeclaration() throws RecognitionException {
        Epl_EolParserRules.modelDeclaration_return retval = new Epl_EolParserRules.modelDeclaration_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token m=null;
        Token NAME3=null;
        Token char_literal7=null;
        Epl_EolParserRules.modelAlias_return modelAlias4 = null;

        Epl_EolParserRules.modelDriver_return modelDriver5 = null;

        Epl_EolParserRules.modelDeclarationParameters_return modelDeclarationParameters6 = null;


        org.eclipse.epsilon.common.parse.AST m_tree=null;
        org.eclipse.epsilon.common.parse.AST NAME3_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal7_tree=null;

        try {
            // EolParserRules.g:109:2: (m= 'model' NAME ( modelAlias )? ( modelDriver )? ( modelDeclarationParameters )? ';' )
            // EolParserRules.g:109:4: m= 'model' NAME ( modelAlias )? ( modelDriver )? ( modelDeclarationParameters )? ';'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            m=(Token)match(input,92,FOLLOW_92_in_modelDeclaration261); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            m_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(m);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(m_tree, root_0);
            }
            NAME3=(Token)match(input,NAME,FOLLOW_NAME_in_modelDeclaration264); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME3_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(NAME3);
            adaptor.addChild(root_0, NAME3_tree);
            }
            // EolParserRules.g:109:20: ( modelAlias )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==94) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // EolParserRules.g:0:0: modelAlias
                    {
                    pushFollow(FOLLOW_modelAlias_in_modelDeclaration266);
                    modelAlias4=modelAlias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, modelAlias4.getTree());

                    }
                    break;

            }

            // EolParserRules.g:109:32: ( modelDriver )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==96) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // EolParserRules.g:0:0: modelDriver
                    {
                    pushFollow(FOLLOW_modelDriver_in_modelDeclaration269);
                    modelDriver5=modelDriver();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, modelDriver5.getTree());

                    }
                    break;

            }

            // EolParserRules.g:109:45: ( modelDeclarationParameters )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==97) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // EolParserRules.g:0:0: modelDeclarationParameters
                    {
                    pushFollow(FOLLOW_modelDeclarationParameters_in_modelDeclaration272);
                    modelDeclarationParameters6=modelDeclarationParameters();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, modelDeclarationParameters6.getTree());

                    }
                    break;

            }

            char_literal7=(Token)match(input,93,FOLLOW_93_in_modelDeclaration275); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
              m.setType(MODELDECLARATION);
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
    // $ANTLR end modelDeclaration

    public static class modelAlias_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start modelAlias
    // EolParserRules.g:113:1: modelAlias : a= 'alias' NAME ( ',' NAME )* ;
    public final Epl_EolParserRules.modelAlias_return modelAlias() throws RecognitionException {
        Epl_EolParserRules.modelAlias_return retval = new Epl_EolParserRules.modelAlias_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token a=null;
        Token NAME8=null;
        Token char_literal9=null;
        Token NAME10=null;

        org.eclipse.epsilon.common.parse.AST a_tree=null;
        org.eclipse.epsilon.common.parse.AST NAME8_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal9_tree=null;
        org.eclipse.epsilon.common.parse.AST NAME10_tree=null;

        try {
            // EolParserRules.g:114:2: (a= 'alias' NAME ( ',' NAME )* )
            // EolParserRules.g:114:5: a= 'alias' NAME ( ',' NAME )*
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            a=(Token)match(input,94,FOLLOW_94_in_modelAlias293); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            a_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(a);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(a_tree, root_0);
            }
            NAME8=(Token)match(input,NAME,FOLLOW_NAME_in_modelAlias296); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME8_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(NAME8);
            adaptor.addChild(root_0, NAME8_tree);
            }
            // EolParserRules.g:114:21: ( ',' NAME )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==95) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // EolParserRules.g:114:22: ',' NAME
            	    {
            	    char_literal9=(Token)match(input,95,FOLLOW_95_in_modelAlias299); if (state.failed) return retval;
            	    NAME10=(Token)match(input,NAME,FOLLOW_NAME_in_modelAlias302); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    NAME10_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(NAME10);
            	    adaptor.addChild(root_0, NAME10_tree);
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
    // EolParserRules.g:118:1: modelDriver : d= 'driver' NAME ;
    public final Epl_EolParserRules.modelDriver_return modelDriver() throws RecognitionException {
        Epl_EolParserRules.modelDriver_return retval = new Epl_EolParserRules.modelDriver_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token d=null;
        Token NAME11=null;

        org.eclipse.epsilon.common.parse.AST d_tree=null;
        org.eclipse.epsilon.common.parse.AST NAME11_tree=null;

        try {
            // EolParserRules.g:119:2: (d= 'driver' NAME )
            // EolParserRules.g:119:5: d= 'driver' NAME
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            d=(Token)match(input,96,FOLLOW_96_in_modelDriver321); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            d_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(d);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(d_tree, root_0);
            }
            NAME11=(Token)match(input,NAME,FOLLOW_NAME_in_modelDriver324); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME11_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(NAME11);
            adaptor.addChild(root_0, NAME11_tree);
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
    // EolParserRules.g:123:1: modelDeclarationParameters : s= '{' ( modelDeclarationParameter )? ( ',' modelDeclarationParameter )* '}' ;
    public final Epl_EolParserRules.modelDeclarationParameters_return modelDeclarationParameters() throws RecognitionException {
        Epl_EolParserRules.modelDeclarationParameters_return retval = new Epl_EolParserRules.modelDeclarationParameters_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token s=null;
        Token char_literal13=null;
        Token char_literal15=null;
        Epl_EolParserRules.modelDeclarationParameter_return modelDeclarationParameter12 = null;

        Epl_EolParserRules.modelDeclarationParameter_return modelDeclarationParameter14 = null;


        org.eclipse.epsilon.common.parse.AST s_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal13_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal15_tree=null;

        try {
            // EolParserRules.g:124:2: (s= '{' ( modelDeclarationParameter )? ( ',' modelDeclarationParameter )* '}' )
            // EolParserRules.g:124:4: s= '{' ( modelDeclarationParameter )? ( ',' modelDeclarationParameter )* '}'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            s=(Token)match(input,97,FOLLOW_97_in_modelDeclarationParameters340); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            s_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(s);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(s_tree, root_0);
            }
            // EolParserRules.g:124:11: ( modelDeclarationParameter )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==NAME) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // EolParserRules.g:0:0: modelDeclarationParameter
                    {
                    pushFollow(FOLLOW_modelDeclarationParameter_in_modelDeclarationParameters343);
                    modelDeclarationParameter12=modelDeclarationParameter();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, modelDeclarationParameter12.getTree());

                    }
                    break;

            }

            // EolParserRules.g:124:38: ( ',' modelDeclarationParameter )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==95) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // EolParserRules.g:124:39: ',' modelDeclarationParameter
            	    {
            	    char_literal13=(Token)match(input,95,FOLLOW_95_in_modelDeclarationParameters347); if (state.failed) return retval;
            	    pushFollow(FOLLOW_modelDeclarationParameter_in_modelDeclarationParameters350);
            	    modelDeclarationParameter14=modelDeclarationParameter();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, modelDeclarationParameter14.getTree());

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            char_literal15=(Token)match(input,98,FOLLOW_98_in_modelDeclarationParameters354); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
              s.setType(MODELDECLARATIONPARAMETERS);
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
    // $ANTLR end modelDeclarationParameters

    public static class modelDeclarationParameter_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start modelDeclarationParameter
    // EolParserRules.g:128:1: modelDeclarationParameter : NAME e= '=' STRING ;
    public final Epl_EolParserRules.modelDeclarationParameter_return modelDeclarationParameter() throws RecognitionException {
        Epl_EolParserRules.modelDeclarationParameter_return retval = new Epl_EolParserRules.modelDeclarationParameter_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token e=null;
        Token NAME16=null;
        Token STRING17=null;

        org.eclipse.epsilon.common.parse.AST e_tree=null;
        org.eclipse.epsilon.common.parse.AST NAME16_tree=null;
        org.eclipse.epsilon.common.parse.AST STRING17_tree=null;

        try {
            // EolParserRules.g:129:2: ( NAME e= '=' STRING )
            // EolParserRules.g:129:4: NAME e= '=' STRING
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            NAME16=(Token)match(input,NAME,FOLLOW_NAME_in_modelDeclarationParameter370); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME16_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(NAME16);
            adaptor.addChild(root_0, NAME16_tree);
            }
            e=(Token)match(input,99,FOLLOW_99_in_modelDeclarationParameter374); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            e_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(e);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(e_tree, root_0);
            }
            STRING17=(Token)match(input,STRING,FOLLOW_STRING_in_modelDeclarationParameter377); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STRING17_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(STRING17);
            adaptor.addChild(root_0, STRING17_tree);
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
    // EolParserRules.g:133:1: operationDeclaration : ( 'operation' | 'function' ) (ctx= typeName )? operationName= NAME op= '(' ( formalParameterList )? cp= ')' ( ':' returnType= typeName )? statementBlock ;
    public final Epl_EolParserRules.operationDeclaration_return operationDeclaration() throws RecognitionException {
        Epl_EolParserRules.operationDeclaration_return retval = new Epl_EolParserRules.operationDeclaration_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token operationName=null;
        Token op=null;
        Token cp=null;
        Token set18=null;
        Token char_literal20=null;
        Epl_EolParserRules.typeName_return ctx = null;

        Epl_EolParserRules.typeName_return returnType = null;

        Epl_EolParserRules.formalParameterList_return formalParameterList19 = null;

        Epl_EolParserRules.statementBlock_return statementBlock21 = null;


        org.eclipse.epsilon.common.parse.AST operationName_tree=null;
        org.eclipse.epsilon.common.parse.AST op_tree=null;
        org.eclipse.epsilon.common.parse.AST cp_tree=null;
        org.eclipse.epsilon.common.parse.AST set18_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal20_tree=null;

        try {
            // EolParserRules.g:138:2: ( ( 'operation' | 'function' ) (ctx= typeName )? operationName= NAME op= '(' ( formalParameterList )? cp= ')' ( ':' returnType= typeName )? statementBlock )
            // EolParserRules.g:138:4: ( 'operation' | 'function' ) (ctx= typeName )? operationName= NAME op= '(' ( formalParameterList )? cp= ')' ( ':' returnType= typeName )? statementBlock
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            set18=(Token)input.LT(1);
            set18=(Token)input.LT(1);
            if ( (input.LA(1)>=100 && input.LA(1)<=101) ) {
                input.consume();
                if ( state.backtracking==0 ) root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot((org.eclipse.epsilon.common.parse.AST)adaptor.create(set18), root_0);
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            // EolParserRules.g:138:30: (ctx= typeName )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==NAME) ) {
                int LA8_1 = input.LA(2);

                if ( (LA8_1==NAME||(LA8_1>=107 && LA8_1<=109)) ) {
                    alt8=1;
                }
            }
            else if ( ((LA8_0>=110 && LA8_0<=117)) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // EolParserRules.g:138:31: ctx= typeName
                    {
                    pushFollow(FOLLOW_typeName_in_operationDeclaration408);
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

            operationName=(Token)match(input,NAME,FOLLOW_NAME_in_operationDeclaration416); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            operationName_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(operationName);
            adaptor.addChild(root_0, operationName_tree);
            }
            op=(Token)match(input,102,FOLLOW_102_in_operationDeclaration420); if (state.failed) return retval;
            // EolParserRules.g:138:99: ( formalParameterList )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==NAME) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // EolParserRules.g:0:0: formalParameterList
                    {
                    pushFollow(FOLLOW_formalParameterList_in_operationDeclaration423);
                    formalParameterList19=formalParameterList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, formalParameterList19.getTree());

                    }
                    break;

            }

            cp=(Token)match(input,103,FOLLOW_103_in_operationDeclaration428); if (state.failed) return retval;
            // EolParserRules.g:138:128: ( ':' returnType= typeName )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==104) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // EolParserRules.g:138:129: ':' returnType= typeName
                    {
                    char_literal20=(Token)match(input,104,FOLLOW_104_in_operationDeclaration432); if (state.failed) return retval;
                    pushFollow(FOLLOW_typeName_in_operationDeclaration437);
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

            pushFollow(FOLLOW_statementBlock_in_operationDeclaration443);
            statementBlock21=statementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, statementBlock21.getTree());

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
    // EolParserRules.g:141:1: importStatement : i= 'import' STRING sem= ';' ;
    public final Epl_EolParserRules.importStatement_return importStatement() throws RecognitionException {
        Epl_EolParserRules.importStatement_return retval = new Epl_EolParserRules.importStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token i=null;
        Token sem=null;
        Token STRING22=null;

        org.eclipse.epsilon.common.parse.AST i_tree=null;
        org.eclipse.epsilon.common.parse.AST sem_tree=null;
        org.eclipse.epsilon.common.parse.AST STRING22_tree=null;

        try {
            // EolParserRules.g:145:2: (i= 'import' STRING sem= ';' )
            // EolParserRules.g:145:4: i= 'import' STRING sem= ';'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            i=(Token)match(input,105,FOLLOW_105_in_importStatement463); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            i_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(i);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(i_tree, root_0);
            }
            STRING22=(Token)match(input,STRING,FOLLOW_STRING_in_importStatement466); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STRING22_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(STRING22);
            adaptor.addChild(root_0, STRING22_tree);
            }
            sem=(Token)match(input,93,FOLLOW_93_in_importStatement470); if (state.failed) return retval;
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
    // EolParserRules.g:149:1: block : ( statement )* -> ^( BLOCK ( statement )* ) ;
    public final Epl_EolParserRules.block_return block() throws RecognitionException {
        Epl_EolParserRules.block_return retval = new Epl_EolParserRules.block_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Epl_EolParserRules.statement_return statement23 = null;


        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        try {
            // EolParserRules.g:153:2: ( ( statement )* -> ^( BLOCK ( statement )* ) )
            // EolParserRules.g:153:4: ( statement )*
            {
            // EolParserRules.g:153:4: ( statement )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==FLOAT||LA11_0==INT||LA11_0==BOOLEAN||LA11_0==STRING||LA11_0==NAME||LA11_0==102||(LA11_0>=110 && LA11_0<=118)||(LA11_0>=120 && LA11_0<=121)||(LA11_0>=125 && LA11_0<=133)||LA11_0==147||LA11_0==150||(LA11_0>=154 && LA11_0<=155)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // EolParserRules.g:0:0: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_block490);
            	    statement23=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_statement.add(statement23.getTree());

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
            // 154:2: -> ^( BLOCK ( statement )* )
            {
                // EolParserRules.g:154:5: ^( BLOCK ( statement )* )
                {
                org.eclipse.epsilon.common.parse.AST root_1 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();
                root_1 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot((org.eclipse.epsilon.common.parse.AST)adaptor.create(BLOCK, "BLOCK"), root_1);

                // EolParserRules.g:154:13: ( statement )*
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
    // EolParserRules.g:157:1: statementBlock : s= '{' block e= '}' ;
    public final Epl_EolParserRules.statementBlock_return statementBlock() throws RecognitionException {
        Epl_EolParserRules.statementBlock_return retval = new Epl_EolParserRules.statementBlock_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token s=null;
        Token e=null;
        Epl_EolParserRules.block_return block24 = null;


        org.eclipse.epsilon.common.parse.AST s_tree=null;
        org.eclipse.epsilon.common.parse.AST e_tree=null;

        try {
            // EolParserRules.g:162:2: (s= '{' block e= '}' )
            // EolParserRules.g:162:4: s= '{' block e= '}'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            s=(Token)match(input,97,FOLLOW_97_in_statementBlock519); if (state.failed) return retval;
            pushFollow(FOLLOW_block_in_statementBlock522);
            block24=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, block24.getTree());
            e=(Token)match(input,98,FOLLOW_98_in_statementBlock526); if (state.failed) return retval;

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
    // EolParserRules.g:165:1: formalParameter : NAME ( ':' pt= typeName )? -> ^( FORMAL NAME ( typeName )? ) ;
    public final Epl_EolParserRules.formalParameter_return formalParameter() throws RecognitionException {
        Epl_EolParserRules.formalParameter_return retval = new Epl_EolParserRules.formalParameter_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token NAME25=null;
        Token char_literal26=null;
        Epl_EolParserRules.typeName_return pt = null;


        org.eclipse.epsilon.common.parse.AST NAME25_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal26_tree=null;
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_104=new RewriteRuleTokenStream(adaptor,"token 104");
        RewriteRuleSubtreeStream stream_typeName=new RewriteRuleSubtreeStream(adaptor,"rule typeName");
        try {
            // EolParserRules.g:169:2: ( NAME ( ':' pt= typeName )? -> ^( FORMAL NAME ( typeName )? ) )
            // EolParserRules.g:169:4: NAME ( ':' pt= typeName )?
            {
            NAME25=(Token)match(input,NAME,FOLLOW_NAME_in_formalParameter544); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(NAME25);

            // EolParserRules.g:169:9: ( ':' pt= typeName )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==104) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // EolParserRules.g:169:10: ':' pt= typeName
                    {
                    char_literal26=(Token)match(input,104,FOLLOW_104_in_formalParameter547); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_104.add(char_literal26);

                    pushFollow(FOLLOW_typeName_in_formalParameter551);
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
            // 170:3: -> ^( FORMAL NAME ( typeName )? )
            {
                // EolParserRules.g:170:6: ^( FORMAL NAME ( typeName )? )
                {
                org.eclipse.epsilon.common.parse.AST root_1 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();
                root_1 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot((org.eclipse.epsilon.common.parse.AST)adaptor.create(FORMAL, "FORMAL"), root_1);

                adaptor.addChild(root_1, stream_NAME.nextNode());
                // EolParserRules.g:170:20: ( typeName )?
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
    // EolParserRules.g:173:1: formalParameterList : formalParameter ( ',' formalParameter )* -> ^( PARAMLIST ( formalParameter )* ) ;
    public final Epl_EolParserRules.formalParameterList_return formalParameterList() throws RecognitionException {
        Epl_EolParserRules.formalParameterList_return retval = new Epl_EolParserRules.formalParameterList_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token char_literal28=null;
        Epl_EolParserRules.formalParameter_return formalParameter27 = null;

        Epl_EolParserRules.formalParameter_return formalParameter29 = null;


        org.eclipse.epsilon.common.parse.AST char_literal28_tree=null;
        RewriteRuleTokenStream stream_95=new RewriteRuleTokenStream(adaptor,"token 95");
        RewriteRuleSubtreeStream stream_formalParameter=new RewriteRuleSubtreeStream(adaptor,"rule formalParameter");
        try {
            // EolParserRules.g:177:2: ( formalParameter ( ',' formalParameter )* -> ^( PARAMLIST ( formalParameter )* ) )
            // EolParserRules.g:177:4: formalParameter ( ',' formalParameter )*
            {
            pushFollow(FOLLOW_formalParameter_in_formalParameterList585);
            formalParameter27=formalParameter();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_formalParameter.add(formalParameter27.getTree());
            // EolParserRules.g:177:20: ( ',' formalParameter )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==95) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // EolParserRules.g:177:21: ',' formalParameter
            	    {
            	    char_literal28=(Token)match(input,95,FOLLOW_95_in_formalParameterList588); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_95.add(char_literal28);

            	    pushFollow(FOLLOW_formalParameter_in_formalParameterList590);
            	    formalParameter29=formalParameter();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_formalParameter.add(formalParameter29.getTree());

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
            // 178:2: -> ^( PARAMLIST ( formalParameter )* )
            {
                // EolParserRules.g:178:5: ^( PARAMLIST ( formalParameter )* )
                {
                org.eclipse.epsilon.common.parse.AST root_1 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();
                root_1 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot((org.eclipse.epsilon.common.parse.AST)adaptor.create(PARAMLIST, "PARAMLIST"), root_1);

                // EolParserRules.g:178:17: ( formalParameter )*
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
    // EolParserRules.g:181:1: executableAnnotation : d= '$' x= . logicalExpression ;
    public final Epl_EolParserRules.executableAnnotation_return executableAnnotation() throws RecognitionException {
        Epl_EolParserRules.executableAnnotation_return retval = new Epl_EolParserRules.executableAnnotation_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token d=null;
        Token x=null;
        Epl_EolParserRules.logicalExpression_return logicalExpression30 = null;


        org.eclipse.epsilon.common.parse.AST d_tree=null;
        org.eclipse.epsilon.common.parse.AST x_tree=null;

        try {
            // EolParserRules.g:182:2: (d= '$' x= . logicalExpression )
            // EolParserRules.g:182:4: d= '$' x= . logicalExpression
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            d=(Token)match(input,106,FOLLOW_106_in_executableAnnotation615); if (state.failed) return retval;
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
            pushFollow(FOLLOW_logicalExpression_in_executableAnnotation622);
            logicalExpression30=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression30.getTree());
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
    // EolParserRules.g:186:1: annotation : ( Annotation | executableAnnotation );
    public final Epl_EolParserRules.annotation_return annotation() throws RecognitionException {
        Epl_EolParserRules.annotation_return retval = new Epl_EolParserRules.annotation_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token Annotation31=null;
        Epl_EolParserRules.executableAnnotation_return executableAnnotation32 = null;


        org.eclipse.epsilon.common.parse.AST Annotation31_tree=null;

        try {
            // EolParserRules.g:187:2: ( Annotation | executableAnnotation )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==Annotation) ) {
                alt14=1;
            }
            else if ( (LA14_0==106) ) {
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
                    // EolParserRules.g:187:4: Annotation
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    Annotation31=(Token)match(input,Annotation,FOLLOW_Annotation_in_annotation636); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    Annotation31_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(Annotation31);
                    adaptor.addChild(root_0, Annotation31_tree);
                    }

                    }
                    break;
                case 2 :
                    // EolParserRules.g:187:15: executableAnnotation
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_executableAnnotation_in_annotation638);
                    executableAnnotation32=executableAnnotation();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, executableAnnotation32.getTree());

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
    // EolParserRules.g:190:1: annotationBlock : ( annotation )+ -> ^( ANNOTATIONBLOCK ( annotation )+ ) ;
    public final Epl_EolParserRules.annotationBlock_return annotationBlock() throws RecognitionException {
        Epl_EolParserRules.annotationBlock_return retval = new Epl_EolParserRules.annotationBlock_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Epl_EolParserRules.annotation_return annotation33 = null;


        RewriteRuleSubtreeStream stream_annotation=new RewriteRuleSubtreeStream(adaptor,"rule annotation");
        try {
            // EolParserRules.g:194:2: ( ( annotation )+ -> ^( ANNOTATIONBLOCK ( annotation )+ ) )
            // EolParserRules.g:194:4: ( annotation )+
            {
            // EolParserRules.g:194:4: ( annotation )+
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
                else if ( (LA15_0==106) ) {
                    int LA15_3 = input.LA(2);

                    if ( (synpred16_EolParserRules()) ) {
                        alt15=1;
                    }


                }


                switch (alt15) {
            	case 1 :
            	    // EolParserRules.g:0:0: annotation
            	    {
            	    pushFollow(FOLLOW_annotation_in_annotationBlock655);
            	    annotation33=annotation();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_annotation.add(annotation33.getTree());

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
            // 195:2: -> ^( ANNOTATIONBLOCK ( annotation )+ )
            {
                // EolParserRules.g:195:5: ^( ANNOTATIONBLOCK ( annotation )+ )
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
    // EolParserRules.g:198:1: typeName : ( pathName | nativeType | collectionType );
    public final Epl_EolParserRules.typeName_return typeName() throws RecognitionException {
        Epl_EolParserRules.typeName_return retval = new Epl_EolParserRules.typeName_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Epl_EolParserRules.pathName_return pathName34 = null;

        Epl_EolParserRules.nativeType_return nativeType35 = null;

        Epl_EolParserRules.collectionType_return collectionType36 = null;



        try {
            // EolParserRules.g:202:2: ( pathName | nativeType | collectionType )
            int alt16=3;
            switch ( input.LA(1) ) {
            case NAME:
                {
                alt16=1;
                }
                break;
            case 110:
                {
                alt16=2;
                }
                break;
            case 111:
            case 112:
            case 113:
            case 114:
            case 115:
            case 116:
            case 117:
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
                    // EolParserRules.g:202:4: pathName
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_pathName_in_typeName684);
                    pathName34=pathName();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pathName34.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:202:15: nativeType
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_nativeType_in_typeName688);
                    nativeType35=nativeType();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nativeType35.getTree());

                    }
                    break;
                case 3 :
                    // EolParserRules.g:202:28: collectionType
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_collectionType_in_typeName692);
                    collectionType36=collectionType();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, collectionType36.getTree());

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
    // EolParserRules.g:205:1: pathName : (metamodel= NAME '!' )? head= packagedType ( '#' label= NAME )? ;
    public final Epl_EolParserRules.pathName_return pathName() throws RecognitionException {
        Epl_EolParserRules.pathName_return retval = new Epl_EolParserRules.pathName_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token metamodel=null;
        Token label=null;
        Token char_literal37=null;
        Token char_literal38=null;
        Epl_EolParserRules.packagedType_return head = null;


        org.eclipse.epsilon.common.parse.AST metamodel_tree=null;
        org.eclipse.epsilon.common.parse.AST label_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal37_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal38_tree=null;

        try {
            // EolParserRules.g:206:2: ( (metamodel= NAME '!' )? head= packagedType ( '#' label= NAME )? )
            // EolParserRules.g:206:4: (metamodel= NAME '!' )? head= packagedType ( '#' label= NAME )?
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            // EolParserRules.g:206:4: (metamodel= NAME '!' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==NAME) ) {
                int LA17_1 = input.LA(2);

                if ( (LA17_1==107) ) {
                    alt17=1;
                }
            }
            switch (alt17) {
                case 1 :
                    // EolParserRules.g:206:5: metamodel= NAME '!'
                    {
                    metamodel=(Token)match(input,NAME,FOLLOW_NAME_in_pathName706); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    metamodel_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(metamodel);
                    adaptor.addChild(root_0, metamodel_tree);
                    }
                    char_literal37=(Token)match(input,107,FOLLOW_107_in_pathName708); if (state.failed) return retval;

                    }
                    break;

            }

            pushFollow(FOLLOW_packagedType_in_pathName717);
            head=packagedType();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(head.getTree(), root_0);
            // EolParserRules.g:208:3: ( '#' label= NAME )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==108) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // EolParserRules.g:208:4: '#' label= NAME
                    {
                    char_literal38=(Token)match(input,108,FOLLOW_108_in_pathName723); if (state.failed) return retval;
                    label=(Token)match(input,NAME,FOLLOW_NAME_in_pathName728); if (state.failed) return retval;
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
    // EolParserRules.g:222:1: packagedType : head= NAME ( '::' field= NAME )* ;
    public final Epl_EolParserRules.packagedType_return packagedType() throws RecognitionException {
        Epl_EolParserRules.packagedType_return retval = new Epl_EolParserRules.packagedType_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token head=null;
        Token field=null;
        Token string_literal39=null;

        org.eclipse.epsilon.common.parse.AST head_tree=null;
        org.eclipse.epsilon.common.parse.AST field_tree=null;
        org.eclipse.epsilon.common.parse.AST string_literal39_tree=null;

        try {
            // EolParserRules.g:223:2: (head= NAME ( '::' field= NAME )* )
            // EolParserRules.g:223:4: head= NAME ( '::' field= NAME )*
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            head=(Token)match(input,NAME,FOLLOW_NAME_in_packagedType749); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            head_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(head);
            adaptor.addChild(root_0, head_tree);
            }
            // EolParserRules.g:223:14: ( '::' field= NAME )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==109) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // EolParserRules.g:223:15: '::' field= NAME
            	    {
            	    string_literal39=(Token)match(input,109,FOLLOW_109_in_packagedType752); if (state.failed) return retval;
            	    field=(Token)match(input,NAME,FOLLOW_NAME_in_packagedType757); if (state.failed) return retval;
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
    // EolParserRules.g:231:1: nativeType : n= 'Native' '(' STRING ')' ;
    public final Epl_EolParserRules.nativeType_return nativeType() throws RecognitionException {
        Epl_EolParserRules.nativeType_return retval = new Epl_EolParserRules.nativeType_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token n=null;
        Token char_literal40=null;
        Token STRING41=null;
        Token char_literal42=null;

        org.eclipse.epsilon.common.parse.AST n_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal40_tree=null;
        org.eclipse.epsilon.common.parse.AST STRING41_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal42_tree=null;

        try {
            // EolParserRules.g:232:2: (n= 'Native' '(' STRING ')' )
            // EolParserRules.g:232:4: n= 'Native' '(' STRING ')'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            n=(Token)match(input,110,FOLLOW_110_in_nativeType782); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            n_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(n);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(n_tree, root_0);
            }
            char_literal40=(Token)match(input,102,FOLLOW_102_in_nativeType785); if (state.failed) return retval;
            STRING41=(Token)match(input,STRING,FOLLOW_STRING_in_nativeType788); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STRING41_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(STRING41);
            adaptor.addChild(root_0, STRING41_tree);
            }
            char_literal42=(Token)match(input,103,FOLLOW_103_in_nativeType790); if (state.failed) return retval;
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
    // EolParserRules.g:236:1: collectionType : ( 'Collection' | 'Sequence' | 'List' | 'Bag' | 'Set' | 'OrderedSet' | 'Map' ) (op= '(' tn= typeName cp= ')' )? ;
    public final Epl_EolParserRules.collectionType_return collectionType() throws RecognitionException {
        Epl_EolParserRules.collectionType_return retval = new Epl_EolParserRules.collectionType_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token op=null;
        Token cp=null;
        Token set43=null;
        Epl_EolParserRules.typeName_return tn = null;


        org.eclipse.epsilon.common.parse.AST op_tree=null;
        org.eclipse.epsilon.common.parse.AST cp_tree=null;
        org.eclipse.epsilon.common.parse.AST set43_tree=null;

        try {
            // EolParserRules.g:242:2: ( ( 'Collection' | 'Sequence' | 'List' | 'Bag' | 'Set' | 'OrderedSet' | 'Map' ) (op= '(' tn= typeName cp= ')' )? )
            // EolParserRules.g:242:5: ( 'Collection' | 'Sequence' | 'List' | 'Bag' | 'Set' | 'OrderedSet' | 'Map' ) (op= '(' tn= typeName cp= ')' )?
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            set43=(Token)input.LT(1);
            set43=(Token)input.LT(1);
            if ( (input.LA(1)>=111 && input.LA(1)<=117) ) {
                input.consume();
                if ( state.backtracking==0 ) root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot((org.eclipse.epsilon.common.parse.AST)adaptor.create(set43), root_0);
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            // EolParserRules.g:243:3: (op= '(' tn= typeName cp= ')' )?
            int alt20=2;
            alt20 = dfa20.predict(input);
            switch (alt20) {
                case 1 :
                    // EolParserRules.g:243:4: op= '(' tn= typeName cp= ')'
                    {
                    op=(Token)match(input,102,FOLLOW_102_in_collectionType833); if (state.failed) return retval;
                    pushFollow(FOLLOW_typeName_in_collectionType838);
                    tn=typeName();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, tn.getTree());
                    if ( state.backtracking==0 ) {
                      setTokenType(tn,TYPE);
                    }
                    cp=(Token)match(input,103,FOLLOW_103_in_collectionType844); if (state.failed) return retval;

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
    // EolParserRules.g:246:1: statement : ( statementA | statementB );
    public final Epl_EolParserRules.statement_return statement() throws RecognitionException {
        Epl_EolParserRules.statement_return retval = new Epl_EolParserRules.statement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Epl_EolParserRules.statementA_return statementA44 = null;

        Epl_EolParserRules.statementB_return statementB45 = null;



        try {
            // EolParserRules.g:247:2: ( statementA | statementB )
            int alt21=2;
            alt21 = dfa21.predict(input);
            switch (alt21) {
                case 1 :
                    // EolParserRules.g:247:4: statementA
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_statementA_in_statement859);
                    statementA44=statementA();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statementA44.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:247:17: statementB
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_statementB_in_statement863);
                    statementB45=statementB();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statementB45.getTree());

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
    // EolParserRules.g:250:1: statementA : ( assignmentStatement | expressionStatement | forStatement | ifStatement | whileStatement | switchStatement | returnStatement | breakStatement );
    public final Epl_EolParserRules.statementA_return statementA() throws RecognitionException {
        Epl_EolParserRules.statementA_return retval = new Epl_EolParserRules.statementA_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Epl_EolParserRules.assignmentStatement_return assignmentStatement46 = null;

        Epl_EolParserRules.expressionStatement_return expressionStatement47 = null;

        Epl_EolParserRules.forStatement_return forStatement48 = null;

        Epl_EolParserRules.ifStatement_return ifStatement49 = null;

        Epl_EolParserRules.whileStatement_return whileStatement50 = null;

        Epl_EolParserRules.switchStatement_return switchStatement51 = null;

        Epl_EolParserRules.returnStatement_return returnStatement52 = null;

        Epl_EolParserRules.breakStatement_return breakStatement53 = null;



        try {
            // EolParserRules.g:251:2: ( assignmentStatement | expressionStatement | forStatement | ifStatement | whileStatement | switchStatement | returnStatement | breakStatement )
            int alt22=8;
            alt22 = dfa22.predict(input);
            switch (alt22) {
                case 1 :
                    // EolParserRules.g:251:4: assignmentStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_assignmentStatement_in_statementA874);
                    assignmentStatement46=assignmentStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, assignmentStatement46.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:251:26: expressionStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_expressionStatement_in_statementA878);
                    expressionStatement47=expressionStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionStatement47.getTree());

                    }
                    break;
                case 3 :
                    // EolParserRules.g:251:48: forStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_forStatement_in_statementA882);
                    forStatement48=forStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, forStatement48.getTree());

                    }
                    break;
                case 4 :
                    // EolParserRules.g:252:5: ifStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_ifStatement_in_statementA888);
                    ifStatement49=ifStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, ifStatement49.getTree());

                    }
                    break;
                case 5 :
                    // EolParserRules.g:252:19: whileStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_whileStatement_in_statementA892);
                    whileStatement50=whileStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, whileStatement50.getTree());

                    }
                    break;
                case 6 :
                    // EolParserRules.g:252:36: switchStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_switchStatement_in_statementA896);
                    switchStatement51=switchStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, switchStatement51.getTree());

                    }
                    break;
                case 7 :
                    // EolParserRules.g:252:54: returnStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_returnStatement_in_statementA900);
                    returnStatement52=returnStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, returnStatement52.getTree());

                    }
                    break;
                case 8 :
                    // EolParserRules.g:252:72: breakStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_breakStatement_in_statementA904);
                    breakStatement53=breakStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, breakStatement53.getTree());

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
    // EolParserRules.g:255:1: statementB : ( breakAllStatement | returnStatement | transactionStatement | abortStatement | continueStatement | throwStatement | deleteStatement );
    public final Epl_EolParserRules.statementB_return statementB() throws RecognitionException {
        Epl_EolParserRules.statementB_return retval = new Epl_EolParserRules.statementB_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Epl_EolParserRules.breakAllStatement_return breakAllStatement54 = null;

        Epl_EolParserRules.returnStatement_return returnStatement55 = null;

        Epl_EolParserRules.transactionStatement_return transactionStatement56 = null;

        Epl_EolParserRules.abortStatement_return abortStatement57 = null;

        Epl_EolParserRules.continueStatement_return continueStatement58 = null;

        Epl_EolParserRules.throwStatement_return throwStatement59 = null;

        Epl_EolParserRules.deleteStatement_return deleteStatement60 = null;



        try {
            // EolParserRules.g:256:2: ( breakAllStatement | returnStatement | transactionStatement | abortStatement | continueStatement | throwStatement | deleteStatement )
            int alt23=7;
            switch ( input.LA(1) ) {
            case 130:
                {
                alt23=1;
                }
                break;
            case 126:
                {
                alt23=2;
                }
                break;
            case 133:
                {
                alt23=3;
                }
                break;
            case 132:
                {
                alt23=4;
                }
                break;
            case 131:
                {
                alt23=5;
                }
                break;
            case 127:
                {
                alt23=6;
                }
                break;
            case 128:
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
                    // EolParserRules.g:256:4: breakAllStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_breakAllStatement_in_statementB916);
                    breakAllStatement54=breakAllStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, breakAllStatement54.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:256:24: returnStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_returnStatement_in_statementB920);
                    returnStatement55=returnStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, returnStatement55.getTree());

                    }
                    break;
                case 3 :
                    // EolParserRules.g:256:42: transactionStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_transactionStatement_in_statementB924);
                    transactionStatement56=transactionStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, transactionStatement56.getTree());

                    }
                    break;
                case 4 :
                    // EolParserRules.g:257:5: abortStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_abortStatement_in_statementB930);
                    abortStatement57=abortStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, abortStatement57.getTree());

                    }
                    break;
                case 5 :
                    // EolParserRules.g:257:22: continueStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_continueStatement_in_statementB934);
                    continueStatement58=continueStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, continueStatement58.getTree());

                    }
                    break;
                case 6 :
                    // EolParserRules.g:257:42: throwStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_throwStatement_in_statementB938);
                    throwStatement59=throwStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, throwStatement59.getTree());

                    }
                    break;
                case 7 :
                    // EolParserRules.g:258:5: deleteStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_deleteStatement_in_statementB944);
                    deleteStatement60=deleteStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, deleteStatement60.getTree());

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
    // EolParserRules.g:261:1: statementOrStatementBlock : ( statement | statementBlock );
    public final Epl_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock() throws RecognitionException {
        Epl_EolParserRules.statementOrStatementBlock_return retval = new Epl_EolParserRules.statementOrStatementBlock_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Epl_EolParserRules.statement_return statement61 = null;

        Epl_EolParserRules.statementBlock_return statementBlock62 = null;



        try {
            // EolParserRules.g:262:2: ( statement | statementBlock )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==FLOAT||LA24_0==INT||LA24_0==BOOLEAN||LA24_0==STRING||LA24_0==NAME||LA24_0==102||(LA24_0>=110 && LA24_0<=118)||(LA24_0>=120 && LA24_0<=121)||(LA24_0>=125 && LA24_0<=133)||LA24_0==147||LA24_0==150||(LA24_0>=154 && LA24_0<=155)) ) {
                alt24=1;
            }
            else if ( (LA24_0==97) ) {
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
                    // EolParserRules.g:262:4: statement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_statement_in_statementOrStatementBlock955);
                    statement61=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement61.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:262:16: statementBlock
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_statementBlock_in_statementOrStatementBlock959);
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
    // $ANTLR end statementOrStatementBlock

    public static class expressionOrStatementBlock_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start expressionOrStatementBlock
    // EolParserRules.g:264:1: expressionOrStatementBlock : ( ':' logicalExpression | statementBlock );
    public final Epl_EolParserRules.expressionOrStatementBlock_return expressionOrStatementBlock() throws RecognitionException {
        Epl_EolParserRules.expressionOrStatementBlock_return retval = new Epl_EolParserRules.expressionOrStatementBlock_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token char_literal63=null;
        Epl_EolParserRules.logicalExpression_return logicalExpression64 = null;

        Epl_EolParserRules.statementBlock_return statementBlock65 = null;


        org.eclipse.epsilon.common.parse.AST char_literal63_tree=null;

        try {
            // EolParserRules.g:265:2: ( ':' logicalExpression | statementBlock )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==104) ) {
                alt25=1;
            }
            else if ( (LA25_0==97) ) {
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
                    // EolParserRules.g:265:4: ':' logicalExpression
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    char_literal63=(Token)match(input,104,FOLLOW_104_in_expressionOrStatementBlock968); if (state.failed) return retval;
                    pushFollow(FOLLOW_logicalExpression_in_expressionOrStatementBlock971);
                    logicalExpression64=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression64.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:265:29: statementBlock
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_statementBlock_in_expressionOrStatementBlock975);
                    statementBlock65=statementBlock();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statementBlock65.getTree());

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
    // EolParserRules.g:268:1: forStatement : f= 'for' '(' formalParameter 'in' logicalExpression ')' statementOrStatementBlock ;
    public final Epl_EolParserRules.forStatement_return forStatement() throws RecognitionException {
        Epl_EolParserRules.forStatement_return retval = new Epl_EolParserRules.forStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token f=null;
        Token char_literal66=null;
        Token string_literal68=null;
        Token char_literal70=null;
        Epl_EolParserRules.formalParameter_return formalParameter67 = null;

        Epl_EolParserRules.logicalExpression_return logicalExpression69 = null;

        Epl_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock71 = null;


        org.eclipse.epsilon.common.parse.AST f_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal66_tree=null;
        org.eclipse.epsilon.common.parse.AST string_literal68_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal70_tree=null;

        try {
            // EolParserRules.g:269:2: (f= 'for' '(' formalParameter 'in' logicalExpression ')' statementOrStatementBlock )
            // EolParserRules.g:269:4: f= 'for' '(' formalParameter 'in' logicalExpression ')' statementOrStatementBlock
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            f=(Token)match(input,118,FOLLOW_118_in_forStatement988); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            f_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(f);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(f_tree, root_0);
            }
            char_literal66=(Token)match(input,102,FOLLOW_102_in_forStatement991); if (state.failed) return retval;
            pushFollow(FOLLOW_formalParameter_in_forStatement994);
            formalParameter67=formalParameter();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, formalParameter67.getTree());
            string_literal68=(Token)match(input,119,FOLLOW_119_in_forStatement996); if (state.failed) return retval;
            pushFollow(FOLLOW_logicalExpression_in_forStatement999);
            logicalExpression69=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression69.getTree());
            char_literal70=(Token)match(input,103,FOLLOW_103_in_forStatement1001); if (state.failed) return retval;
            pushFollow(FOLLOW_statementOrStatementBlock_in_forStatement1004);
            statementOrStatementBlock71=statementOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, statementOrStatementBlock71.getTree());
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
    // EolParserRules.g:273:1: ifStatement : i= 'if' '(' logicalExpression ')' statementOrStatementBlock ( elseStatement )? ;
    public final Epl_EolParserRules.ifStatement_return ifStatement() throws RecognitionException {
        Epl_EolParserRules.ifStatement_return retval = new Epl_EolParserRules.ifStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token i=null;
        Token char_literal72=null;
        Token char_literal74=null;
        Epl_EolParserRules.logicalExpression_return logicalExpression73 = null;

        Epl_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock75 = null;

        Epl_EolParserRules.elseStatement_return elseStatement76 = null;


        org.eclipse.epsilon.common.parse.AST i_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal72_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal74_tree=null;

        try {
            // EolParserRules.g:274:2: (i= 'if' '(' logicalExpression ')' statementOrStatementBlock ( elseStatement )? )
            // EolParserRules.g:274:4: i= 'if' '(' logicalExpression ')' statementOrStatementBlock ( elseStatement )?
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            i=(Token)match(input,120,FOLLOW_120_in_ifStatement1020); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            i_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(i);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(i_tree, root_0);
            }
            char_literal72=(Token)match(input,102,FOLLOW_102_in_ifStatement1023); if (state.failed) return retval;
            pushFollow(FOLLOW_logicalExpression_in_ifStatement1026);
            logicalExpression73=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression73.getTree());
            char_literal74=(Token)match(input,103,FOLLOW_103_in_ifStatement1028); if (state.failed) return retval;
            pushFollow(FOLLOW_statementOrStatementBlock_in_ifStatement1031);
            statementOrStatementBlock75=statementOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, statementOrStatementBlock75.getTree());
            // EolParserRules.g:274:66: ( elseStatement )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==124) ) {
                int LA26_1 = input.LA(2);

                if ( (synpred45_EolParserRules()) ) {
                    alt26=1;
                }
            }
            switch (alt26) {
                case 1 :
                    // EolParserRules.g:0:0: elseStatement
                    {
                    pushFollow(FOLLOW_elseStatement_in_ifStatement1033);
                    elseStatement76=elseStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, elseStatement76.getTree());

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
    // EolParserRules.g:278:1: switchStatement : s= 'switch' '(' logicalExpression ')' '{' ( caseStatement )* ( defaultStatement )? '}' ;
    public final Epl_EolParserRules.switchStatement_return switchStatement() throws RecognitionException {
        Epl_EolParserRules.switchStatement_return retval = new Epl_EolParserRules.switchStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token s=null;
        Token char_literal77=null;
        Token char_literal79=null;
        Token char_literal80=null;
        Token char_literal83=null;
        Epl_EolParserRules.logicalExpression_return logicalExpression78 = null;

        Epl_EolParserRules.caseStatement_return caseStatement81 = null;

        Epl_EolParserRules.defaultStatement_return defaultStatement82 = null;


        org.eclipse.epsilon.common.parse.AST s_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal77_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal79_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal80_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal83_tree=null;

        try {
            // EolParserRules.g:279:2: (s= 'switch' '(' logicalExpression ')' '{' ( caseStatement )* ( defaultStatement )? '}' )
            // EolParserRules.g:279:4: s= 'switch' '(' logicalExpression ')' '{' ( caseStatement )* ( defaultStatement )? '}'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            s=(Token)match(input,121,FOLLOW_121_in_switchStatement1052); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            s_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(s);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(s_tree, root_0);
            }
            char_literal77=(Token)match(input,102,FOLLOW_102_in_switchStatement1055); if (state.failed) return retval;
            pushFollow(FOLLOW_logicalExpression_in_switchStatement1058);
            logicalExpression78=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression78.getTree());
            char_literal79=(Token)match(input,103,FOLLOW_103_in_switchStatement1060); if (state.failed) return retval;
            char_literal80=(Token)match(input,97,FOLLOW_97_in_switchStatement1063); if (state.failed) return retval;
            // EolParserRules.g:279:49: ( caseStatement )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==122) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // EolParserRules.g:0:0: caseStatement
            	    {
            	    pushFollow(FOLLOW_caseStatement_in_switchStatement1066);
            	    caseStatement81=caseStatement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, caseStatement81.getTree());

            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

            // EolParserRules.g:279:64: ( defaultStatement )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==123) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // EolParserRules.g:0:0: defaultStatement
                    {
                    pushFollow(FOLLOW_defaultStatement_in_switchStatement1069);
                    defaultStatement82=defaultStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, defaultStatement82.getTree());

                    }
                    break;

            }

            char_literal83=(Token)match(input,98,FOLLOW_98_in_switchStatement1072); if (state.failed) return retval;
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
    // EolParserRules.g:283:1: caseStatement : c= 'case' logicalExpression ':' block ;
    public final Epl_EolParserRules.caseStatement_return caseStatement() throws RecognitionException {
        Epl_EolParserRules.caseStatement_return retval = new Epl_EolParserRules.caseStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token c=null;
        Token char_literal85=null;
        Epl_EolParserRules.logicalExpression_return logicalExpression84 = null;

        Epl_EolParserRules.block_return block86 = null;


        org.eclipse.epsilon.common.parse.AST c_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal85_tree=null;

        try {
            // EolParserRules.g:284:2: (c= 'case' logicalExpression ':' block )
            // EolParserRules.g:284:4: c= 'case' logicalExpression ':' block
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            c=(Token)match(input,122,FOLLOW_122_in_caseStatement1091); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            c_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(c);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(c_tree, root_0);
            }
            pushFollow(FOLLOW_logicalExpression_in_caseStatement1094);
            logicalExpression84=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression84.getTree());
            char_literal85=(Token)match(input,104,FOLLOW_104_in_caseStatement1096); if (state.failed) return retval;
            pushFollow(FOLLOW_block_in_caseStatement1099);
            block86=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, block86.getTree());
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
    // EolParserRules.g:288:1: defaultStatement : d= 'default' ':' block ;
    public final Epl_EolParserRules.defaultStatement_return defaultStatement() throws RecognitionException {
        Epl_EolParserRules.defaultStatement_return retval = new Epl_EolParserRules.defaultStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token d=null;
        Token char_literal87=null;
        Epl_EolParserRules.block_return block88 = null;


        org.eclipse.epsilon.common.parse.AST d_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal87_tree=null;

        try {
            // EolParserRules.g:289:2: (d= 'default' ':' block )
            // EolParserRules.g:289:4: d= 'default' ':' block
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            d=(Token)match(input,123,FOLLOW_123_in_defaultStatement1117); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            d_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(d);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(d_tree, root_0);
            }
            char_literal87=(Token)match(input,104,FOLLOW_104_in_defaultStatement1120); if (state.failed) return retval;
            pushFollow(FOLLOW_block_in_defaultStatement1123);
            block88=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, block88.getTree());
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
    // EolParserRules.g:293:1: elseStatement : e= 'else' statementOrStatementBlock ;
    public final Epl_EolParserRules.elseStatement_return elseStatement() throws RecognitionException {
        Epl_EolParserRules.elseStatement_return retval = new Epl_EolParserRules.elseStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token e=null;
        Epl_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock89 = null;


        org.eclipse.epsilon.common.parse.AST e_tree=null;

        try {
            // EolParserRules.g:297:2: (e= 'else' statementOrStatementBlock )
            // EolParserRules.g:297:4: e= 'else' statementOrStatementBlock
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            e=(Token)match(input,124,FOLLOW_124_in_elseStatement1147); if (state.failed) return retval;
            pushFollow(FOLLOW_statementOrStatementBlock_in_elseStatement1150);
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
    // EolParserRules.g:300:1: whileStatement : w= 'while' '(' logicalExpression ')' statementOrStatementBlock ;
    public final Epl_EolParserRules.whileStatement_return whileStatement() throws RecognitionException {
        Epl_EolParserRules.whileStatement_return retval = new Epl_EolParserRules.whileStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token w=null;
        Token char_literal90=null;
        Token char_literal92=null;
        Epl_EolParserRules.logicalExpression_return logicalExpression91 = null;

        Epl_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock93 = null;


        org.eclipse.epsilon.common.parse.AST w_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal90_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal92_tree=null;

        try {
            // EolParserRules.g:301:2: (w= 'while' '(' logicalExpression ')' statementOrStatementBlock )
            // EolParserRules.g:301:4: w= 'while' '(' logicalExpression ')' statementOrStatementBlock
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            w=(Token)match(input,125,FOLLOW_125_in_whileStatement1163); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            w_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(w);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(w_tree, root_0);
            }
            char_literal90=(Token)match(input,102,FOLLOW_102_in_whileStatement1166); if (state.failed) return retval;
            pushFollow(FOLLOW_logicalExpression_in_whileStatement1169);
            logicalExpression91=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression91.getTree());
            char_literal92=(Token)match(input,103,FOLLOW_103_in_whileStatement1171); if (state.failed) return retval;
            pushFollow(FOLLOW_statementOrStatementBlock_in_whileStatement1174);
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
    // EolParserRules.g:305:1: returnStatement : r= 'return' ( logicalExpression )? sem= ';' ;
    public final Epl_EolParserRules.returnStatement_return returnStatement() throws RecognitionException {
        Epl_EolParserRules.returnStatement_return retval = new Epl_EolParserRules.returnStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token r=null;
        Token sem=null;
        Epl_EolParserRules.logicalExpression_return logicalExpression94 = null;


        org.eclipse.epsilon.common.parse.AST r_tree=null;
        org.eclipse.epsilon.common.parse.AST sem_tree=null;

        try {
            // EolParserRules.g:309:2: (r= 'return' ( logicalExpression )? sem= ';' )
            // EolParserRules.g:309:4: r= 'return' ( logicalExpression )? sem= ';'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            r=(Token)match(input,126,FOLLOW_126_in_returnStatement1196); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            r_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(r);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(r_tree, root_0);
            }
            // EolParserRules.g:309:16: ( logicalExpression )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==FLOAT||LA29_0==INT||LA29_0==BOOLEAN||LA29_0==STRING||LA29_0==NAME||LA29_0==102||(LA29_0>=110 && LA29_0<=117)||LA29_0==147||LA29_0==150||(LA29_0>=154 && LA29_0<=155)) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // EolParserRules.g:0:0: logicalExpression
                    {
                    pushFollow(FOLLOW_logicalExpression_in_returnStatement1199);
                    logicalExpression94=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression94.getTree());

                    }
                    break;

            }

            sem=(Token)match(input,93,FOLLOW_93_in_returnStatement1204); if (state.failed) return retval;
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
    // EolParserRules.g:313:1: throwStatement : t= 'throw' ( logicalExpression )? sem= ';' ;
    public final Epl_EolParserRules.throwStatement_return throwStatement() throws RecognitionException {
        Epl_EolParserRules.throwStatement_return retval = new Epl_EolParserRules.throwStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token t=null;
        Token sem=null;
        Epl_EolParserRules.logicalExpression_return logicalExpression95 = null;


        org.eclipse.epsilon.common.parse.AST t_tree=null;
        org.eclipse.epsilon.common.parse.AST sem_tree=null;

        try {
            // EolParserRules.g:317:2: (t= 'throw' ( logicalExpression )? sem= ';' )
            // EolParserRules.g:317:4: t= 'throw' ( logicalExpression )? sem= ';'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            t=(Token)match(input,127,FOLLOW_127_in_throwStatement1227); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            t_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(t);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(t_tree, root_0);
            }
            // EolParserRules.g:317:15: ( logicalExpression )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==FLOAT||LA30_0==INT||LA30_0==BOOLEAN||LA30_0==STRING||LA30_0==NAME||LA30_0==102||(LA30_0>=110 && LA30_0<=117)||LA30_0==147||LA30_0==150||(LA30_0>=154 && LA30_0<=155)) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // EolParserRules.g:0:0: logicalExpression
                    {
                    pushFollow(FOLLOW_logicalExpression_in_throwStatement1230);
                    logicalExpression95=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression95.getTree());

                    }
                    break;

            }

            sem=(Token)match(input,93,FOLLOW_93_in_throwStatement1235); if (state.failed) return retval;
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
    // EolParserRules.g:321:1: deleteStatement : d= 'delete' ( logicalExpression )? sem= ';' ;
    public final Epl_EolParserRules.deleteStatement_return deleteStatement() throws RecognitionException {
        Epl_EolParserRules.deleteStatement_return retval = new Epl_EolParserRules.deleteStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token d=null;
        Token sem=null;
        Epl_EolParserRules.logicalExpression_return logicalExpression96 = null;


        org.eclipse.epsilon.common.parse.AST d_tree=null;
        org.eclipse.epsilon.common.parse.AST sem_tree=null;

        try {
            // EolParserRules.g:325:2: (d= 'delete' ( logicalExpression )? sem= ';' )
            // EolParserRules.g:325:4: d= 'delete' ( logicalExpression )? sem= ';'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            d=(Token)match(input,128,FOLLOW_128_in_deleteStatement1258); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            d_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(d);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(d_tree, root_0);
            }
            // EolParserRules.g:325:16: ( logicalExpression )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==FLOAT||LA31_0==INT||LA31_0==BOOLEAN||LA31_0==STRING||LA31_0==NAME||LA31_0==102||(LA31_0>=110 && LA31_0<=117)||LA31_0==147||LA31_0==150||(LA31_0>=154 && LA31_0<=155)) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // EolParserRules.g:0:0: logicalExpression
                    {
                    pushFollow(FOLLOW_logicalExpression_in_deleteStatement1261);
                    logicalExpression96=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression96.getTree());

                    }
                    break;

            }

            sem=(Token)match(input,93,FOLLOW_93_in_deleteStatement1266); if (state.failed) return retval;
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
    // EolParserRules.g:329:1: breakStatement : b= 'break' sem= ';' ;
    public final Epl_EolParserRules.breakStatement_return breakStatement() throws RecognitionException {
        Epl_EolParserRules.breakStatement_return retval = new Epl_EolParserRules.breakStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token b=null;
        Token sem=null;

        org.eclipse.epsilon.common.parse.AST b_tree=null;
        org.eclipse.epsilon.common.parse.AST sem_tree=null;

        try {
            // EolParserRules.g:333:2: (b= 'break' sem= ';' )
            // EolParserRules.g:333:4: b= 'break' sem= ';'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            b=(Token)match(input,129,FOLLOW_129_in_breakStatement1292); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            b_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(b);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(b_tree, root_0);
            }
            sem=(Token)match(input,93,FOLLOW_93_in_breakStatement1297); if (state.failed) return retval;
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
    // EolParserRules.g:337:1: breakAllStatement : b= 'breakAll' sem= ';' ;
    public final Epl_EolParserRules.breakAllStatement_return breakAllStatement() throws RecognitionException {
        Epl_EolParserRules.breakAllStatement_return retval = new Epl_EolParserRules.breakAllStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token b=null;
        Token sem=null;

        org.eclipse.epsilon.common.parse.AST b_tree=null;
        org.eclipse.epsilon.common.parse.AST sem_tree=null;

        try {
            // EolParserRules.g:341:2: (b= 'breakAll' sem= ';' )
            // EolParserRules.g:341:4: b= 'breakAll' sem= ';'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            b=(Token)match(input,130,FOLLOW_130_in_breakAllStatement1320); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            b_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(b);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(b_tree, root_0);
            }
            sem=(Token)match(input,93,FOLLOW_93_in_breakAllStatement1325); if (state.failed) return retval;
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
    // EolParserRules.g:345:1: continueStatement : c= 'continue' sem= ';' ;
    public final Epl_EolParserRules.continueStatement_return continueStatement() throws RecognitionException {
        Epl_EolParserRules.continueStatement_return retval = new Epl_EolParserRules.continueStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token c=null;
        Token sem=null;

        org.eclipse.epsilon.common.parse.AST c_tree=null;
        org.eclipse.epsilon.common.parse.AST sem_tree=null;

        try {
            // EolParserRules.g:349:2: (c= 'continue' sem= ';' )
            // EolParserRules.g:349:4: c= 'continue' sem= ';'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            c=(Token)match(input,131,FOLLOW_131_in_continueStatement1348); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            c_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(c);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(c_tree, root_0);
            }
            sem=(Token)match(input,93,FOLLOW_93_in_continueStatement1353); if (state.failed) return retval;
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
    // EolParserRules.g:353:1: abortStatement : a= 'abort' sem= ';' ;
    public final Epl_EolParserRules.abortStatement_return abortStatement() throws RecognitionException {
        Epl_EolParserRules.abortStatement_return retval = new Epl_EolParserRules.abortStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token a=null;
        Token sem=null;

        org.eclipse.epsilon.common.parse.AST a_tree=null;
        org.eclipse.epsilon.common.parse.AST sem_tree=null;

        try {
            // EolParserRules.g:357:2: (a= 'abort' sem= ';' )
            // EolParserRules.g:357:4: a= 'abort' sem= ';'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            a=(Token)match(input,132,FOLLOW_132_in_abortStatement1376); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            a_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(a);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(a_tree, root_0);
            }
            sem=(Token)match(input,93,FOLLOW_93_in_abortStatement1381); if (state.failed) return retval;
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
    // EolParserRules.g:361:1: transactionStatement : t= 'transaction' ( NAME ( ',' NAME )* )? statementOrStatementBlock ;
    public final Epl_EolParserRules.transactionStatement_return transactionStatement() throws RecognitionException {
        Epl_EolParserRules.transactionStatement_return retval = new Epl_EolParserRules.transactionStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token t=null;
        Token NAME97=null;
        Token char_literal98=null;
        Token NAME99=null;
        Epl_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock100 = null;


        org.eclipse.epsilon.common.parse.AST t_tree=null;
        org.eclipse.epsilon.common.parse.AST NAME97_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal98_tree=null;
        org.eclipse.epsilon.common.parse.AST NAME99_tree=null;

        try {
            // EolParserRules.g:362:2: (t= 'transaction' ( NAME ( ',' NAME )* )? statementOrStatementBlock )
            // EolParserRules.g:362:4: t= 'transaction' ( NAME ( ',' NAME )* )? statementOrStatementBlock
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            t=(Token)match(input,133,FOLLOW_133_in_transactionStatement1398); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            t_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(t);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(t_tree, root_0);
            }
            // EolParserRules.g:362:21: ( NAME ( ',' NAME )* )?
            int alt33=2;
            alt33 = dfa33.predict(input);
            switch (alt33) {
                case 1 :
                    // EolParserRules.g:362:22: NAME ( ',' NAME )*
                    {
                    NAME97=(Token)match(input,NAME,FOLLOW_NAME_in_transactionStatement1402); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NAME97_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(NAME97);
                    adaptor.addChild(root_0, NAME97_tree);
                    }
                    // EolParserRules.g:362:27: ( ',' NAME )*
                    loop32:
                    do {
                        int alt32=2;
                        int LA32_0 = input.LA(1);

                        if ( (LA32_0==95) ) {
                            alt32=1;
                        }


                        switch (alt32) {
                    	case 1 :
                    	    // EolParserRules.g:362:28: ',' NAME
                    	    {
                    	    char_literal98=(Token)match(input,95,FOLLOW_95_in_transactionStatement1405); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal98_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(char_literal98);
                    	    adaptor.addChild(root_0, char_literal98_tree);
                    	    }
                    	    NAME99=(Token)match(input,NAME,FOLLOW_NAME_in_transactionStatement1407); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    NAME99_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(NAME99);
                    	    adaptor.addChild(root_0, NAME99_tree);
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

            pushFollow(FOLLOW_statementOrStatementBlock_in_transactionStatement1413);
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
    // EolParserRules.g:366:1: assignmentStatement : logicalExpression (normal= ':=' | special= '::=' ) logicalExpression sem= ';' ;
    public final Epl_EolParserRules.assignmentStatement_return assignmentStatement() throws RecognitionException {
        Epl_EolParserRules.assignmentStatement_return retval = new Epl_EolParserRules.assignmentStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token normal=null;
        Token special=null;
        Token sem=null;
        Epl_EolParserRules.logicalExpression_return logicalExpression101 = null;

        Epl_EolParserRules.logicalExpression_return logicalExpression102 = null;


        org.eclipse.epsilon.common.parse.AST normal_tree=null;
        org.eclipse.epsilon.common.parse.AST special_tree=null;
        org.eclipse.epsilon.common.parse.AST sem_tree=null;

        try {
            // EolParserRules.g:370:2: ( logicalExpression (normal= ':=' | special= '::=' ) logicalExpression sem= ';' )
            // EolParserRules.g:370:4: logicalExpression (normal= ':=' | special= '::=' ) logicalExpression sem= ';'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            pushFollow(FOLLOW_logicalExpression_in_assignmentStatement1433);
            logicalExpression101=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression101.getTree());
            // EolParserRules.g:370:22: (normal= ':=' | special= '::=' )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==134) ) {
                alt34=1;
            }
            else if ( (LA34_0==135) ) {
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
                    // EolParserRules.g:370:23: normal= ':='
                    {
                    normal=(Token)match(input,134,FOLLOW_134_in_assignmentStatement1438); if (state.failed) return retval;
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
                    // EolParserRules.g:370:66: special= '::='
                    {
                    special=(Token)match(input,135,FOLLOW_135_in_assignmentStatement1445); if (state.failed) return retval;
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

            pushFollow(FOLLOW_logicalExpression_in_assignmentStatement1451);
            logicalExpression102=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression102.getTree());
            sem=(Token)match(input,93,FOLLOW_93_in_assignmentStatement1455); if (state.failed) return retval;

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
    // EolParserRules.g:374:1: expressionStatement : ( postfixExpression op= '=' logicalExpression | logicalExpression ) sem= ';' ;
    public final Epl_EolParserRules.expressionStatement_return expressionStatement() throws RecognitionException {
        Epl_EolParserRules.expressionStatement_return retval = new Epl_EolParserRules.expressionStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token op=null;
        Token sem=null;
        Epl_EolParserRules.postfixExpression_return postfixExpression103 = null;

        Epl_EolParserRules.logicalExpression_return logicalExpression104 = null;

        Epl_EolParserRules.logicalExpression_return logicalExpression105 = null;


        org.eclipse.epsilon.common.parse.AST op_tree=null;
        org.eclipse.epsilon.common.parse.AST sem_tree=null;

        try {
            // EolParserRules.g:378:2: ( ( postfixExpression op= '=' logicalExpression | logicalExpression ) sem= ';' )
            // EolParserRules.g:378:4: ( postfixExpression op= '=' logicalExpression | logicalExpression ) sem= ';'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            // EolParserRules.g:378:4: ( postfixExpression op= '=' logicalExpression | logicalExpression )
            int alt35=2;
            alt35 = dfa35.predict(input);
            switch (alt35) {
                case 1 :
                    // EolParserRules.g:378:5: postfixExpression op= '=' logicalExpression
                    {
                    pushFollow(FOLLOW_postfixExpression_in_expressionStatement1477);
                    postfixExpression103=postfixExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, postfixExpression103.getTree());
                    op=(Token)match(input,99,FOLLOW_99_in_expressionStatement1481); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
                    }
                    pushFollow(FOLLOW_logicalExpression_in_expressionStatement1484);
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
                    // EolParserRules.g:378:76: logicalExpression
                    {
                    pushFollow(FOLLOW_logicalExpression_in_expressionStatement1490);
                    logicalExpression105=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression105.getTree());

                    }
                    break;

            }

            sem=(Token)match(input,93,FOLLOW_93_in_expressionStatement1495); if (state.failed) return retval;

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
    // EolParserRules.g:381:1: logicalExpression : relationalExpression ( (op= 'or' | op= 'and' | op= 'xor' | op= 'implies' ) relationalExpression )* ;
    public final Epl_EolParserRules.logicalExpression_return logicalExpression() throws RecognitionException {
        Epl_EolParserRules.logicalExpression_return retval = new Epl_EolParserRules.logicalExpression_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token op=null;
        Epl_EolParserRules.relationalExpression_return relationalExpression106 = null;

        Epl_EolParserRules.relationalExpression_return relationalExpression107 = null;


        org.eclipse.epsilon.common.parse.AST op_tree=null;

        try {
            // EolParserRules.g:382:2: ( relationalExpression ( (op= 'or' | op= 'and' | op= 'xor' | op= 'implies' ) relationalExpression )* )
            // EolParserRules.g:382:4: relationalExpression ( (op= 'or' | op= 'and' | op= 'xor' | op= 'implies' ) relationalExpression )*
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            pushFollow(FOLLOW_relationalExpression_in_logicalExpression1507);
            relationalExpression106=relationalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, relationalExpression106.getTree());
            // EolParserRules.g:382:25: ( (op= 'or' | op= 'and' | op= 'xor' | op= 'implies' ) relationalExpression )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( ((LA37_0>=136 && LA37_0<=139)) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // EolParserRules.g:382:26: (op= 'or' | op= 'and' | op= 'xor' | op= 'implies' ) relationalExpression
            	    {
            	    // EolParserRules.g:382:26: (op= 'or' | op= 'and' | op= 'xor' | op= 'implies' )
            	    int alt36=4;
            	    switch ( input.LA(1) ) {
            	    case 136:
            	        {
            	        alt36=1;
            	        }
            	        break;
            	    case 137:
            	        {
            	        alt36=2;
            	        }
            	        break;
            	    case 138:
            	        {
            	        alt36=3;
            	        }
            	        break;
            	    case 139:
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
            	            // EolParserRules.g:382:27: op= 'or'
            	            {
            	            op=(Token)match(input,136,FOLLOW_136_in_logicalExpression1513); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // EolParserRules.g:382:36: op= 'and'
            	            {
            	            op=(Token)match(input,137,FOLLOW_137_in_logicalExpression1518); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // EolParserRules.g:382:46: op= 'xor'
            	            {
            	            op=(Token)match(input,138,FOLLOW_138_in_logicalExpression1523); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 4 :
            	            // EolParserRules.g:382:56: op= 'implies'
            	            {
            	            op=(Token)match(input,139,FOLLOW_139_in_logicalExpression1528); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_relationalExpression_in_logicalExpression1532);
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
    // EolParserRules.g:386:1: relationalExpression : additiveExpression ( (op= '==' relationalExpression | op= '=' relationalExpression | (op= '>' | op= '<' | op= '>=' | op= '<=' | op= '<>' ) additiveExpression ) )* ;
    public final Epl_EolParserRules.relationalExpression_return relationalExpression() throws RecognitionException {
        Epl_EolParserRules.relationalExpression_return retval = new Epl_EolParserRules.relationalExpression_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token op=null;
        Epl_EolParserRules.additiveExpression_return additiveExpression108 = null;

        Epl_EolParserRules.relationalExpression_return relationalExpression109 = null;

        Epl_EolParserRules.relationalExpression_return relationalExpression110 = null;

        Epl_EolParserRules.additiveExpression_return additiveExpression111 = null;


        org.eclipse.epsilon.common.parse.AST op_tree=null;

        try {
            // EolParserRules.g:387:2: ( additiveExpression ( (op= '==' relationalExpression | op= '=' relationalExpression | (op= '>' | op= '<' | op= '>=' | op= '<=' | op= '<>' ) additiveExpression ) )* )
            // EolParserRules.g:387:4: additiveExpression ( (op= '==' relationalExpression | op= '=' relationalExpression | (op= '>' | op= '<' | op= '>=' | op= '<=' | op= '<>' ) additiveExpression ) )*
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            pushFollow(FOLLOW_additiveExpression_in_relationalExpression1549);
            additiveExpression108=additiveExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, additiveExpression108.getTree());
            // EolParserRules.g:387:23: ( (op= '==' relationalExpression | op= '=' relationalExpression | (op= '>' | op= '<' | op= '>=' | op= '<=' | op= '<>' ) additiveExpression ) )*
            loop40:
            do {
                int alt40=2;
                alt40 = dfa40.predict(input);
                switch (alt40) {
            	case 1 :
            	    // EolParserRules.g:387:24: (op= '==' relationalExpression | op= '=' relationalExpression | (op= '>' | op= '<' | op= '>=' | op= '<=' | op= '<>' ) additiveExpression )
            	    {
            	    // EolParserRules.g:387:24: (op= '==' relationalExpression | op= '=' relationalExpression | (op= '>' | op= '<' | op= '>=' | op= '<=' | op= '<>' ) additiveExpression )
            	    int alt39=3;
            	    switch ( input.LA(1) ) {
            	    case 140:
            	        {
            	        alt39=1;
            	        }
            	        break;
            	    case 99:
            	        {
            	        alt39=2;
            	        }
            	        break;
            	    case 141:
            	    case 142:
            	    case 143:
            	    case 144:
            	    case 145:
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
            	            // EolParserRules.g:387:25: op= '==' relationalExpression
            	            {
            	            op=(Token)match(input,140,FOLLOW_140_in_relationalExpression1555); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	            }
            	            pushFollow(FOLLOW_relationalExpression_in_relationalExpression1558);
            	            relationalExpression109=relationalExpression();

            	            state._fsp--;
            	            if (state.failed) return retval;
            	            if ( state.backtracking==0 ) adaptor.addChild(root_0, relationalExpression109.getTree());

            	            }
            	            break;
            	        case 2 :
            	            // EolParserRules.g:387:57: op= '=' relationalExpression
            	            {
            	            op=(Token)match(input,99,FOLLOW_99_in_relationalExpression1564); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	            }
            	            pushFollow(FOLLOW_relationalExpression_in_relationalExpression1567);
            	            relationalExpression110=relationalExpression();

            	            state._fsp--;
            	            if (state.failed) return retval;
            	            if ( state.backtracking==0 ) adaptor.addChild(root_0, relationalExpression110.getTree());

            	            }
            	            break;
            	        case 3 :
            	            // EolParserRules.g:388:24: (op= '>' | op= '<' | op= '>=' | op= '<=' | op= '<>' ) additiveExpression
            	            {
            	            // EolParserRules.g:388:24: (op= '>' | op= '<' | op= '>=' | op= '<=' | op= '<>' )
            	            int alt38=5;
            	            switch ( input.LA(1) ) {
            	            case 141:
            	                {
            	                alt38=1;
            	                }
            	                break;
            	            case 142:
            	                {
            	                alt38=2;
            	                }
            	                break;
            	            case 143:
            	                {
            	                alt38=3;
            	                }
            	                break;
            	            case 144:
            	                {
            	                alt38=4;
            	                }
            	                break;
            	            case 145:
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
            	                    // EolParserRules.g:388:25: op= '>'
            	                    {
            	                    op=(Token)match(input,141,FOLLOW_141_in_relationalExpression1597); if (state.failed) return retval;
            	                    if ( state.backtracking==0 ) {
            	                    op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	                    }

            	                    }
            	                    break;
            	                case 2 :
            	                    // EolParserRules.g:388:33: op= '<'
            	                    {
            	                    op=(Token)match(input,142,FOLLOW_142_in_relationalExpression1602); if (state.failed) return retval;
            	                    if ( state.backtracking==0 ) {
            	                    op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	                    }

            	                    }
            	                    break;
            	                case 3 :
            	                    // EolParserRules.g:388:41: op= '>='
            	                    {
            	                    op=(Token)match(input,143,FOLLOW_143_in_relationalExpression1607); if (state.failed) return retval;
            	                    if ( state.backtracking==0 ) {
            	                    op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	                    }

            	                    }
            	                    break;
            	                case 4 :
            	                    // EolParserRules.g:388:50: op= '<='
            	                    {
            	                    op=(Token)match(input,144,FOLLOW_144_in_relationalExpression1612); if (state.failed) return retval;
            	                    if ( state.backtracking==0 ) {
            	                    op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	                    }

            	                    }
            	                    break;
            	                case 5 :
            	                    // EolParserRules.g:388:59: op= '<>'
            	                    {
            	                    op=(Token)match(input,145,FOLLOW_145_in_relationalExpression1617); if (state.failed) return retval;
            	                    if ( state.backtracking==0 ) {
            	                    op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	                    }

            	                    }
            	                    break;

            	            }

            	            pushFollow(FOLLOW_additiveExpression_in_relationalExpression1621);
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
    // EolParserRules.g:392:1: additiveExpression : multiplicativeExpression ( (op= '+' | op= '-' ) multiplicativeExpression )* ;
    public final Epl_EolParserRules.additiveExpression_return additiveExpression() throws RecognitionException {
        Epl_EolParserRules.additiveExpression_return retval = new Epl_EolParserRules.additiveExpression_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token op=null;
        Epl_EolParserRules.multiplicativeExpression_return multiplicativeExpression112 = null;

        Epl_EolParserRules.multiplicativeExpression_return multiplicativeExpression113 = null;


        org.eclipse.epsilon.common.parse.AST op_tree=null;

        try {
            // EolParserRules.g:393:2: ( multiplicativeExpression ( (op= '+' | op= '-' ) multiplicativeExpression )* )
            // EolParserRules.g:393:4: multiplicativeExpression ( (op= '+' | op= '-' ) multiplicativeExpression )*
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            pushFollow(FOLLOW_multiplicativeExpression_in_additiveExpression1639);
            multiplicativeExpression112=multiplicativeExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, multiplicativeExpression112.getTree());
            // EolParserRules.g:393:29: ( (op= '+' | op= '-' ) multiplicativeExpression )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( ((LA42_0>=146 && LA42_0<=147)) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // EolParserRules.g:393:30: (op= '+' | op= '-' ) multiplicativeExpression
            	    {
            	    // EolParserRules.g:393:30: (op= '+' | op= '-' )
            	    int alt41=2;
            	    int LA41_0 = input.LA(1);

            	    if ( (LA41_0==146) ) {
            	        alt41=1;
            	    }
            	    else if ( (LA41_0==147) ) {
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
            	            // EolParserRules.g:393:31: op= '+'
            	            {
            	            op=(Token)match(input,146,FOLLOW_146_in_additiveExpression1645); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // EolParserRules.g:393:39: op= '-'
            	            {
            	            op=(Token)match(input,147,FOLLOW_147_in_additiveExpression1650); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_multiplicativeExpression_in_additiveExpression1654);
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
    // EolParserRules.g:397:1: multiplicativeExpression : unaryExpression ( (op= '*' | op= '/' ) unaryExpression )* ;
    public final Epl_EolParserRules.multiplicativeExpression_return multiplicativeExpression() throws RecognitionException {
        Epl_EolParserRules.multiplicativeExpression_return retval = new Epl_EolParserRules.multiplicativeExpression_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token op=null;
        Epl_EolParserRules.unaryExpression_return unaryExpression114 = null;

        Epl_EolParserRules.unaryExpression_return unaryExpression115 = null;


        org.eclipse.epsilon.common.parse.AST op_tree=null;

        try {
            // EolParserRules.g:398:2: ( unaryExpression ( (op= '*' | op= '/' ) unaryExpression )* )
            // EolParserRules.g:398:4: unaryExpression ( (op= '*' | op= '/' ) unaryExpression )*
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            pushFollow(FOLLOW_unaryExpression_in_multiplicativeExpression1672);
            unaryExpression114=unaryExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, unaryExpression114.getTree());
            // EolParserRules.g:398:20: ( (op= '*' | op= '/' ) unaryExpression )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( ((LA44_0>=148 && LA44_0<=149)) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // EolParserRules.g:398:21: (op= '*' | op= '/' ) unaryExpression
            	    {
            	    // EolParserRules.g:398:21: (op= '*' | op= '/' )
            	    int alt43=2;
            	    int LA43_0 = input.LA(1);

            	    if ( (LA43_0==148) ) {
            	        alt43=1;
            	    }
            	    else if ( (LA43_0==149) ) {
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
            	            // EolParserRules.g:398:22: op= '*'
            	            {
            	            op=(Token)match(input,148,FOLLOW_148_in_multiplicativeExpression1678); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // EolParserRules.g:398:30: op= '/'
            	            {
            	            op=(Token)match(input,149,FOLLOW_149_in_multiplicativeExpression1683); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_unaryExpression_in_multiplicativeExpression1687);
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
    // EolParserRules.g:402:1: unaryExpression : ( (op= 'not' | op= '-' ) )? postfixExpression ;
    public final Epl_EolParserRules.unaryExpression_return unaryExpression() throws RecognitionException {
        Epl_EolParserRules.unaryExpression_return retval = new Epl_EolParserRules.unaryExpression_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token op=null;
        Epl_EolParserRules.postfixExpression_return postfixExpression116 = null;


        org.eclipse.epsilon.common.parse.AST op_tree=null;

        try {
            // EolParserRules.g:403:2: ( ( (op= 'not' | op= '-' ) )? postfixExpression )
            // EolParserRules.g:403:4: ( (op= 'not' | op= '-' ) )? postfixExpression
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            // EolParserRules.g:403:4: ( (op= 'not' | op= '-' ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==147||LA46_0==150) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // EolParserRules.g:403:5: (op= 'not' | op= '-' )
                    {
                    // EolParserRules.g:403:5: (op= 'not' | op= '-' )
                    int alt45=2;
                    int LA45_0 = input.LA(1);

                    if ( (LA45_0==150) ) {
                        alt45=1;
                    }
                    else if ( (LA45_0==147) ) {
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
                            // EolParserRules.g:403:6: op= 'not'
                            {
                            op=(Token)match(input,150,FOLLOW_150_in_unaryExpression1708); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
                            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
                            }

                            }
                            break;
                        case 2 :
                            // EolParserRules.g:403:16: op= '-'
                            {
                            op=(Token)match(input,147,FOLLOW_147_in_unaryExpression1713); if (state.failed) return retval;
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

            pushFollow(FOLLOW_postfixExpression_in_unaryExpression1721);
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
    // EolParserRules.g:406:1: postfixExpression : itemSelectorExpression ( ( POINT | ARROW ) fc= featureCall (is= '[' logicalExpression ']' )* )* ;
    public final Epl_EolParserRules.postfixExpression_return postfixExpression() throws RecognitionException {
        Epl_EolParserRules.postfixExpression_return retval = new Epl_EolParserRules.postfixExpression_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token is=null;
        Token set118=null;
        Token char_literal120=null;
        Epl_EolParserRules.featureCall_return fc = null;

        Epl_EolParserRules.itemSelectorExpression_return itemSelectorExpression117 = null;

        Epl_EolParserRules.logicalExpression_return logicalExpression119 = null;


        org.eclipse.epsilon.common.parse.AST is_tree=null;
        org.eclipse.epsilon.common.parse.AST set118_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal120_tree=null;

        try {
            // EolParserRules.g:407:2: ( itemSelectorExpression ( ( POINT | ARROW ) fc= featureCall (is= '[' logicalExpression ']' )* )* )
            // EolParserRules.g:407:4: itemSelectorExpression ( ( POINT | ARROW ) fc= featureCall (is= '[' logicalExpression ']' )* )*
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            pushFollow(FOLLOW_itemSelectorExpression_in_postfixExpression1733);
            itemSelectorExpression117=itemSelectorExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, itemSelectorExpression117.getTree());
            // EolParserRules.g:407:27: ( ( POINT | ARROW ) fc= featureCall (is= '[' logicalExpression ']' )* )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==POINT||LA48_0==ARROW) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // EolParserRules.g:407:28: ( POINT | ARROW ) fc= featureCall (is= '[' logicalExpression ']' )*
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

            	    pushFollow(FOLLOW_featureCall_in_postfixExpression1745);
            	    fc=featureCall();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, fc.getTree());
            	    if ( state.backtracking==0 ) {
            	      setTokenType(fc,FEATURECALL);
            	    }
            	    // EolParserRules.g:408:35: (is= '[' logicalExpression ']' )*
            	    loop47:
            	    do {
            	        int alt47=2;
            	        int LA47_0 = input.LA(1);

            	        if ( (LA47_0==151) ) {
            	            alt47=1;
            	        }


            	        switch (alt47) {
            	    	case 1 :
            	    	    // EolParserRules.g:408:36: is= '[' logicalExpression ']'
            	    	    {
            	    	    is=(Token)match(input,151,FOLLOW_151_in_postfixExpression1754); if (state.failed) return retval;
            	    	    if ( state.backtracking==0 ) {
            	    	    is_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(is);
            	    	    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(is_tree, root_0);
            	    	    }
            	    	    pushFollow(FOLLOW_logicalExpression_in_postfixExpression1757);
            	    	    logicalExpression119=logicalExpression();

            	    	    state._fsp--;
            	    	    if (state.failed) return retval;
            	    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression119.getTree());
            	    	    char_literal120=(Token)match(input,152,FOLLOW_152_in_postfixExpression1759); if (state.failed) return retval;
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
    // EolParserRules.g:412:1: itemSelectorExpression : primitiveExpression (is= '[' primitiveExpression ']' )* ;
    public final Epl_EolParserRules.itemSelectorExpression_return itemSelectorExpression() throws RecognitionException {
        Epl_EolParserRules.itemSelectorExpression_return retval = new Epl_EolParserRules.itemSelectorExpression_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token is=null;
        Token char_literal123=null;
        Epl_EolParserRules.primitiveExpression_return primitiveExpression121 = null;

        Epl_EolParserRules.primitiveExpression_return primitiveExpression122 = null;


        org.eclipse.epsilon.common.parse.AST is_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal123_tree=null;

        try {
            // EolParserRules.g:413:2: ( primitiveExpression (is= '[' primitiveExpression ']' )* )
            // EolParserRules.g:413:4: primitiveExpression (is= '[' primitiveExpression ']' )*
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            pushFollow(FOLLOW_primitiveExpression_in_itemSelectorExpression1781);
            primitiveExpression121=primitiveExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, primitiveExpression121.getTree());
            // EolParserRules.g:413:24: (is= '[' primitiveExpression ']' )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==151) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // EolParserRules.g:413:25: is= '[' primitiveExpression ']'
            	    {
            	    is=(Token)match(input,151,FOLLOW_151_in_itemSelectorExpression1786); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    is_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(is);
            	    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(is_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_primitiveExpression_in_itemSelectorExpression1789);
            	    primitiveExpression122=primitiveExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, primitiveExpression122.getTree());
            	    char_literal123=(Token)match(input,152,FOLLOW_152_in_itemSelectorExpression1791); if (state.failed) return retval;
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
    // EolParserRules.g:417:1: featureCall : ( simpleFeatureCall | declarativeFeatureCall );
    public final Epl_EolParserRules.featureCall_return featureCall() throws RecognitionException {
        Epl_EolParserRules.featureCall_return retval = new Epl_EolParserRules.featureCall_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Epl_EolParserRules.simpleFeatureCall_return simpleFeatureCall124 = null;

        Epl_EolParserRules.declarativeFeatureCall_return declarativeFeatureCall125 = null;



        try {
            // EolParserRules.g:418:2: ( simpleFeatureCall | declarativeFeatureCall )
            int alt50=2;
            alt50 = dfa50.predict(input);
            switch (alt50) {
                case 1 :
                    // EolParserRules.g:418:4: simpleFeatureCall
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_simpleFeatureCall_in_featureCall1810);
                    simpleFeatureCall124=simpleFeatureCall();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, simpleFeatureCall124.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:418:24: declarativeFeatureCall
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_declarativeFeatureCall_in_featureCall1814);
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
    // EolParserRules.g:421:1: simpleFeatureCall : n= NAME ( parameterList )? ;
    public final Epl_EolParserRules.simpleFeatureCall_return simpleFeatureCall() throws RecognitionException {
        Epl_EolParserRules.simpleFeatureCall_return retval = new Epl_EolParserRules.simpleFeatureCall_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token n=null;
        Epl_EolParserRules.parameterList_return parameterList126 = null;


        org.eclipse.epsilon.common.parse.AST n_tree=null;

        try {
            // EolParserRules.g:422:2: (n= NAME ( parameterList )? )
            // EolParserRules.g:422:5: n= NAME ( parameterList )?
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            n=(Token)match(input,NAME,FOLLOW_NAME_in_simpleFeatureCall1828); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            n_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(n);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(n_tree, root_0);
            }
            // EolParserRules.g:422:13: ( parameterList )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==102) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // EolParserRules.g:0:0: parameterList
                    {
                    pushFollow(FOLLOW_parameterList_in_simpleFeatureCall1831);
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
    // EolParserRules.g:426:1: parameterList : op= '(' ( logicalExpression ( ',' logicalExpression )* )? cp= ')' -> ^( PARAMETERS ( logicalExpression )* ) ;
    public final Epl_EolParserRules.parameterList_return parameterList() throws RecognitionException {
        Epl_EolParserRules.parameterList_return retval = new Epl_EolParserRules.parameterList_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token op=null;
        Token cp=null;
        Token char_literal128=null;
        Epl_EolParserRules.logicalExpression_return logicalExpression127 = null;

        Epl_EolParserRules.logicalExpression_return logicalExpression129 = null;


        org.eclipse.epsilon.common.parse.AST op_tree=null;
        org.eclipse.epsilon.common.parse.AST cp_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal128_tree=null;
        RewriteRuleTokenStream stream_95=new RewriteRuleTokenStream(adaptor,"token 95");
        RewriteRuleTokenStream stream_103=new RewriteRuleTokenStream(adaptor,"token 103");
        RewriteRuleTokenStream stream_102=new RewriteRuleTokenStream(adaptor,"token 102");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:432:2: (op= '(' ( logicalExpression ( ',' logicalExpression )* )? cp= ')' -> ^( PARAMETERS ( logicalExpression )* ) )
            // EolParserRules.g:432:4: op= '(' ( logicalExpression ( ',' logicalExpression )* )? cp= ')'
            {
            op=(Token)match(input,102,FOLLOW_102_in_parameterList1854); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_102.add(op);

            // EolParserRules.g:432:11: ( logicalExpression ( ',' logicalExpression )* )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==FLOAT||LA53_0==INT||LA53_0==BOOLEAN||LA53_0==STRING||LA53_0==NAME||LA53_0==102||(LA53_0>=110 && LA53_0<=117)||LA53_0==147||LA53_0==150||(LA53_0>=154 && LA53_0<=155)) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // EolParserRules.g:432:12: logicalExpression ( ',' logicalExpression )*
                    {
                    pushFollow(FOLLOW_logicalExpression_in_parameterList1857);
                    logicalExpression127=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression127.getTree());
                    // EolParserRules.g:432:30: ( ',' logicalExpression )*
                    loop52:
                    do {
                        int alt52=2;
                        int LA52_0 = input.LA(1);

                        if ( (LA52_0==95) ) {
                            alt52=1;
                        }


                        switch (alt52) {
                    	case 1 :
                    	    // EolParserRules.g:432:31: ',' logicalExpression
                    	    {
                    	    char_literal128=(Token)match(input,95,FOLLOW_95_in_parameterList1860); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_95.add(char_literal128);

                    	    pushFollow(FOLLOW_logicalExpression_in_parameterList1862);
                    	    logicalExpression129=logicalExpression();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression129.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop52;
                        }
                    } while (true);


                    }
                    break;

            }

            cp=(Token)match(input,103,FOLLOW_103_in_parameterList1870); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_103.add(cp);



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
            // 433:3: -> ^( PARAMETERS ( logicalExpression )* )
            {
                // EolParserRules.g:433:6: ^( PARAMETERS ( logicalExpression )* )
                {
                org.eclipse.epsilon.common.parse.AST root_1 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();
                root_1 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot((org.eclipse.epsilon.common.parse.AST)adaptor.create(PARAMETERS, "PARAMETERS"), root_1);

                // EolParserRules.g:433:19: ( logicalExpression )*
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
    // EolParserRules.g:436:1: declarativeFeatureCall : NAME op= '(' formalParameterList '|' logicalExpression ( ',' logicalExpression )* cp= ')' ;
    public final Epl_EolParserRules.declarativeFeatureCall_return declarativeFeatureCall() throws RecognitionException {
        Epl_EolParserRules.declarativeFeatureCall_return retval = new Epl_EolParserRules.declarativeFeatureCall_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token op=null;
        Token cp=null;
        Token NAME130=null;
        Token char_literal132=null;
        Token char_literal134=null;
        Epl_EolParserRules.formalParameterList_return formalParameterList131 = null;

        Epl_EolParserRules.logicalExpression_return logicalExpression133 = null;

        Epl_EolParserRules.logicalExpression_return logicalExpression135 = null;


        org.eclipse.epsilon.common.parse.AST op_tree=null;
        org.eclipse.epsilon.common.parse.AST cp_tree=null;
        org.eclipse.epsilon.common.parse.AST NAME130_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal132_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal134_tree=null;

        try {
            // EolParserRules.g:441:2: ( NAME op= '(' formalParameterList '|' logicalExpression ( ',' logicalExpression )* cp= ')' )
            // EolParserRules.g:441:4: NAME op= '(' formalParameterList '|' logicalExpression ( ',' logicalExpression )* cp= ')'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            NAME130=(Token)match(input,NAME,FOLLOW_NAME_in_declarativeFeatureCall1898); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME130_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(NAME130);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(NAME130_tree, root_0);
            }
            op=(Token)match(input,102,FOLLOW_102_in_declarativeFeatureCall1903); if (state.failed) return retval;
            pushFollow(FOLLOW_formalParameterList_in_declarativeFeatureCall1906);
            formalParameterList131=formalParameterList();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, formalParameterList131.getTree());
            char_literal132=(Token)match(input,153,FOLLOW_153_in_declarativeFeatureCall1908); if (state.failed) return retval;
            pushFollow(FOLLOW_logicalExpression_in_declarativeFeatureCall1911);
            logicalExpression133=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression133.getTree());
            // EolParserRules.g:441:61: ( ',' logicalExpression )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==95) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // EolParserRules.g:441:62: ',' logicalExpression
            	    {
            	    char_literal134=(Token)match(input,95,FOLLOW_95_in_declarativeFeatureCall1914); if (state.failed) return retval;
            	    pushFollow(FOLLOW_logicalExpression_in_declarativeFeatureCall1917);
            	    logicalExpression135=logicalExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression135.getTree());

            	    }
            	    break;

            	default :
            	    break loop54;
                }
            } while (true);

            cp=(Token)match(input,103,FOLLOW_103_in_declarativeFeatureCall1923); if (state.failed) return retval;

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
    // EolParserRules.g:444:1: newExpression : n= 'new' tn= typeName ( parameterList )? ;
    public final Epl_EolParserRules.newExpression_return newExpression() throws RecognitionException {
        Epl_EolParserRules.newExpression_return retval = new Epl_EolParserRules.newExpression_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token n=null;
        Epl_EolParserRules.typeName_return tn = null;

        Epl_EolParserRules.parameterList_return parameterList136 = null;


        org.eclipse.epsilon.common.parse.AST n_tree=null;

        try {
            // EolParserRules.g:445:2: (n= 'new' tn= typeName ( parameterList )? )
            // EolParserRules.g:445:4: n= 'new' tn= typeName ( parameterList )?
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            n=(Token)match(input,154,FOLLOW_154_in_newExpression1937); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            n_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(n);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(n_tree, root_0);
            }
            pushFollow(FOLLOW_typeName_in_newExpression1942);
            tn=typeName();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, tn.getTree());
            if ( state.backtracking==0 ) {
              setTokenType(tn,TYPE);
            }
            // EolParserRules.g:445:50: ( parameterList )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==102) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // EolParserRules.g:0:0: parameterList
                    {
                    pushFollow(FOLLOW_parameterList_in_newExpression1946);
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
    // EolParserRules.g:449:1: variableDeclarationExpression : v= 'var' NAME ( ':' (n= 'new' )? t= typeName ( parameterList )? )? ;
    public final Epl_EolParserRules.variableDeclarationExpression_return variableDeclarationExpression() throws RecognitionException {
        Epl_EolParserRules.variableDeclarationExpression_return retval = new Epl_EolParserRules.variableDeclarationExpression_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token v=null;
        Token n=null;
        Token NAME137=null;
        Token char_literal138=null;
        Epl_EolParserRules.typeName_return t = null;

        Epl_EolParserRules.parameterList_return parameterList139 = null;


        org.eclipse.epsilon.common.parse.AST v_tree=null;
        org.eclipse.epsilon.common.parse.AST n_tree=null;
        org.eclipse.epsilon.common.parse.AST NAME137_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal138_tree=null;

        try {
            // EolParserRules.g:457:2: (v= 'var' NAME ( ':' (n= 'new' )? t= typeName ( parameterList )? )? )
            // EolParserRules.g:457:4: v= 'var' NAME ( ':' (n= 'new' )? t= typeName ( parameterList )? )?
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            v=(Token)match(input,155,FOLLOW_155_in_variableDeclarationExpression1968); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            v_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(v);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(v_tree, root_0);
            }
            NAME137=(Token)match(input,NAME,FOLLOW_NAME_in_variableDeclarationExpression1971); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME137_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(NAME137);
            adaptor.addChild(root_0, NAME137_tree);
            }
            // EolParserRules.g:457:18: ( ':' (n= 'new' )? t= typeName ( parameterList )? )?
            int alt58=2;
            alt58 = dfa58.predict(input);
            switch (alt58) {
                case 1 :
                    // EolParserRules.g:457:19: ':' (n= 'new' )? t= typeName ( parameterList )?
                    {
                    char_literal138=(Token)match(input,104,FOLLOW_104_in_variableDeclarationExpression1974); if (state.failed) return retval;
                    // EolParserRules.g:457:25: (n= 'new' )?
                    int alt56=2;
                    int LA56_0 = input.LA(1);

                    if ( (LA56_0==154) ) {
                        alt56=1;
                    }
                    switch (alt56) {
                        case 1 :
                            // EolParserRules.g:0:0: n= 'new'
                            {
                            n=(Token)match(input,154,FOLLOW_154_in_variableDeclarationExpression1979); if (state.failed) return retval;

                            }
                            break;

                    }

                    pushFollow(FOLLOW_typeName_in_variableDeclarationExpression1985);
                    t=typeName();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, t.getTree());
                    if ( state.backtracking==0 ) {
                      setTokenType(t, TYPE);
                    }
                    // EolParserRules.g:457:70: ( parameterList )?
                    int alt57=2;
                    int LA57_0 = input.LA(1);

                    if ( (LA57_0==102) ) {
                        alt57=1;
                    }
                    switch (alt57) {
                        case 1 :
                            // EolParserRules.g:0:0: parameterList
                            {
                            pushFollow(FOLLOW_parameterList_in_variableDeclarationExpression1989);
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
    // EolParserRules.g:460:1: literalSequentialCollection : (l= 'Collection' | l= 'Sequence' | l= 'List' | l= 'Bag' | l= 'Set' | l= 'OrderedSet' ) ob= '{' ( expressionListOrRange )? cb= '}' ;
    public final Epl_EolParserRules.literalSequentialCollection_return literalSequentialCollection() throws RecognitionException {
        Epl_EolParserRules.literalSequentialCollection_return retval = new Epl_EolParserRules.literalSequentialCollection_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token l=null;
        Token ob=null;
        Token cb=null;
        Epl_EolParserRules.expressionListOrRange_return expressionListOrRange140 = null;


        org.eclipse.epsilon.common.parse.AST l_tree=null;
        org.eclipse.epsilon.common.parse.AST ob_tree=null;
        org.eclipse.epsilon.common.parse.AST cb_tree=null;

        try {
            // EolParserRules.g:465:2: ( (l= 'Collection' | l= 'Sequence' | l= 'List' | l= 'Bag' | l= 'Set' | l= 'OrderedSet' ) ob= '{' ( expressionListOrRange )? cb= '}' )
            // EolParserRules.g:465:4: (l= 'Collection' | l= 'Sequence' | l= 'List' | l= 'Bag' | l= 'Set' | l= 'OrderedSet' ) ob= '{' ( expressionListOrRange )? cb= '}'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            // EolParserRules.g:465:4: (l= 'Collection' | l= 'Sequence' | l= 'List' | l= 'Bag' | l= 'Set' | l= 'OrderedSet' )
            int alt59=6;
            switch ( input.LA(1) ) {
            case 111:
                {
                alt59=1;
                }
                break;
            case 112:
                {
                alt59=2;
                }
                break;
            case 113:
                {
                alt59=3;
                }
                break;
            case 114:
                {
                alt59=4;
                }
                break;
            case 115:
                {
                alt59=5;
                }
                break;
            case 116:
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
                    // EolParserRules.g:465:5: l= 'Collection'
                    {
                    l=(Token)match(input,111,FOLLOW_111_in_literalSequentialCollection2013); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    l_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(l);
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(l_tree, root_0);
                    }

                    }
                    break;
                case 2 :
                    // EolParserRules.g:465:21: l= 'Sequence'
                    {
                    l=(Token)match(input,112,FOLLOW_112_in_literalSequentialCollection2018); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    l_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(l);
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(l_tree, root_0);
                    }

                    }
                    break;
                case 3 :
                    // EolParserRules.g:465:35: l= 'List'
                    {
                    l=(Token)match(input,113,FOLLOW_113_in_literalSequentialCollection2023); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    l_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(l);
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(l_tree, root_0);
                    }

                    }
                    break;
                case 4 :
                    // EolParserRules.g:465:45: l= 'Bag'
                    {
                    l=(Token)match(input,114,FOLLOW_114_in_literalSequentialCollection2028); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    l_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(l);
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(l_tree, root_0);
                    }

                    }
                    break;
                case 5 :
                    // EolParserRules.g:465:54: l= 'Set'
                    {
                    l=(Token)match(input,115,FOLLOW_115_in_literalSequentialCollection2033); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    l_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(l);
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(l_tree, root_0);
                    }

                    }
                    break;
                case 6 :
                    // EolParserRules.g:465:63: l= 'OrderedSet'
                    {
                    l=(Token)match(input,116,FOLLOW_116_in_literalSequentialCollection2038); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    l_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(l);
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(l_tree, root_0);
                    }

                    }
                    break;

            }

            ob=(Token)match(input,97,FOLLOW_97_in_literalSequentialCollection2044); if (state.failed) return retval;
            // EolParserRules.g:465:89: ( expressionListOrRange )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==FLOAT||LA60_0==INT||LA60_0==BOOLEAN||LA60_0==STRING||LA60_0==NAME||LA60_0==102||(LA60_0>=110 && LA60_0<=117)||LA60_0==147||LA60_0==150||(LA60_0>=154 && LA60_0<=155)) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // EolParserRules.g:0:0: expressionListOrRange
                    {
                    pushFollow(FOLLOW_expressionListOrRange_in_literalSequentialCollection2048);
                    expressionListOrRange140=expressionListOrRange();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionListOrRange140.getTree());

                    }
                    break;

            }

            cb=(Token)match(input,98,FOLLOW_98_in_literalSequentialCollection2053); if (state.failed) return retval;
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
    // EolParserRules.g:469:1: expressionRange : logicalExpression exp= '..' logicalExpression ;
    public final Epl_EolParserRules.expressionRange_return expressionRange() throws RecognitionException {
        Epl_EolParserRules.expressionRange_return retval = new Epl_EolParserRules.expressionRange_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token exp=null;
        Epl_EolParserRules.logicalExpression_return logicalExpression141 = null;

        Epl_EolParserRules.logicalExpression_return logicalExpression142 = null;


        org.eclipse.epsilon.common.parse.AST exp_tree=null;

        try {
            // EolParserRules.g:470:2: ( logicalExpression exp= '..' logicalExpression )
            // EolParserRules.g:470:4: logicalExpression exp= '..' logicalExpression
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            pushFollow(FOLLOW_logicalExpression_in_expressionRange2068);
            logicalExpression141=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression141.getTree());
            exp=(Token)match(input,POINT_POINT,FOLLOW_POINT_POINT_in_expressionRange2072); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            exp_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(exp);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(exp_tree, root_0);
            }
            pushFollow(FOLLOW_logicalExpression_in_expressionRange2075);
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
    // EolParserRules.g:474:1: expressionList : logicalExpression ( ',' logicalExpression )* -> ^( EXPRLIST ( logicalExpression )+ ) ;
    public final Epl_EolParserRules.expressionList_return expressionList() throws RecognitionException {
        Epl_EolParserRules.expressionList_return retval = new Epl_EolParserRules.expressionList_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token char_literal144=null;
        Epl_EolParserRules.logicalExpression_return logicalExpression143 = null;

        Epl_EolParserRules.logicalExpression_return logicalExpression145 = null;


        org.eclipse.epsilon.common.parse.AST char_literal144_tree=null;
        RewriteRuleTokenStream stream_95=new RewriteRuleTokenStream(adaptor,"token 95");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:478:2: ( logicalExpression ( ',' logicalExpression )* -> ^( EXPRLIST ( logicalExpression )+ ) )
            // EolParserRules.g:478:4: logicalExpression ( ',' logicalExpression )*
            {
            pushFollow(FOLLOW_logicalExpression_in_expressionList2096);
            logicalExpression143=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression143.getTree());
            // EolParserRules.g:478:22: ( ',' logicalExpression )*
            loop61:
            do {
                int alt61=2;
                int LA61_0 = input.LA(1);

                if ( (LA61_0==95) ) {
                    alt61=1;
                }


                switch (alt61) {
            	case 1 :
            	    // EolParserRules.g:478:23: ',' logicalExpression
            	    {
            	    char_literal144=(Token)match(input,95,FOLLOW_95_in_expressionList2099); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_95.add(char_literal144);

            	    pushFollow(FOLLOW_logicalExpression_in_expressionList2101);
            	    logicalExpression145=logicalExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression145.getTree());

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
            // 479:2: -> ^( EXPRLIST ( logicalExpression )+ )
            {
                // EolParserRules.g:479:5: ^( EXPRLIST ( logicalExpression )+ )
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
    // EolParserRules.g:482:1: expressionListOrRange : ( expressionRange | expressionList );
    public final Epl_EolParserRules.expressionListOrRange_return expressionListOrRange() throws RecognitionException {
        Epl_EolParserRules.expressionListOrRange_return retval = new Epl_EolParserRules.expressionListOrRange_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Epl_EolParserRules.expressionRange_return expressionRange146 = null;

        Epl_EolParserRules.expressionList_return expressionList147 = null;



        try {
            // EolParserRules.g:483:2: ( expressionRange | expressionList )
            int alt62=2;
            alt62 = dfa62.predict(input);
            switch (alt62) {
                case 1 :
                    // EolParserRules.g:483:4: expressionRange
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_expressionRange_in_expressionListOrRange2125);
                    expressionRange146=expressionRange();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionRange146.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:483:22: expressionList
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_expressionList_in_expressionListOrRange2129);
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
    // EolParserRules.g:486:1: literalMapCollection : m= 'Map' ob= '{' ( keyvalExpressionList )? cb= '}' ;
    public final Epl_EolParserRules.literalMapCollection_return literalMapCollection() throws RecognitionException {
        Epl_EolParserRules.literalMapCollection_return retval = new Epl_EolParserRules.literalMapCollection_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token m=null;
        Token ob=null;
        Token cb=null;
        Epl_EolParserRules.keyvalExpressionList_return keyvalExpressionList148 = null;


        org.eclipse.epsilon.common.parse.AST m_tree=null;
        org.eclipse.epsilon.common.parse.AST ob_tree=null;
        org.eclipse.epsilon.common.parse.AST cb_tree=null;

        try {
            // EolParserRules.g:491:2: (m= 'Map' ob= '{' ( keyvalExpressionList )? cb= '}' )
            // EolParserRules.g:491:4: m= 'Map' ob= '{' ( keyvalExpressionList )? cb= '}'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            m=(Token)match(input,117,FOLLOW_117_in_literalMapCollection2148); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            m_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(m);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(m_tree, root_0);
            }
            ob=(Token)match(input,97,FOLLOW_97_in_literalMapCollection2153); if (state.failed) return retval;
            // EolParserRules.g:491:21: ( keyvalExpressionList )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==FLOAT||LA63_0==INT||LA63_0==BOOLEAN||LA63_0==STRING||LA63_0==NAME||LA63_0==102||(LA63_0>=110 && LA63_0<=117)||LA63_0==147||LA63_0==150||(LA63_0>=154 && LA63_0<=155)) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // EolParserRules.g:0:0: keyvalExpressionList
                    {
                    pushFollow(FOLLOW_keyvalExpressionList_in_literalMapCollection2156);
                    keyvalExpressionList148=keyvalExpressionList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, keyvalExpressionList148.getTree());

                    }
                    break;

            }

            cb=(Token)match(input,98,FOLLOW_98_in_literalMapCollection2161); if (state.failed) return retval;
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
    // EolParserRules.g:495:1: keyvalExpressionList : keyvalExpression ( ',' keyvalExpression )* -> ^( KEYVALLIST ( keyvalExpression )+ ) ;
    public final Epl_EolParserRules.keyvalExpressionList_return keyvalExpressionList() throws RecognitionException {
        Epl_EolParserRules.keyvalExpressionList_return retval = new Epl_EolParserRules.keyvalExpressionList_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token char_literal150=null;
        Epl_EolParserRules.keyvalExpression_return keyvalExpression149 = null;

        Epl_EolParserRules.keyvalExpression_return keyvalExpression151 = null;


        org.eclipse.epsilon.common.parse.AST char_literal150_tree=null;
        RewriteRuleTokenStream stream_95=new RewriteRuleTokenStream(adaptor,"token 95");
        RewriteRuleSubtreeStream stream_keyvalExpression=new RewriteRuleSubtreeStream(adaptor,"rule keyvalExpression");
        try {
            // EolParserRules.g:499:2: ( keyvalExpression ( ',' keyvalExpression )* -> ^( KEYVALLIST ( keyvalExpression )+ ) )
            // EolParserRules.g:499:4: keyvalExpression ( ',' keyvalExpression )*
            {
            pushFollow(FOLLOW_keyvalExpression_in_keyvalExpressionList2182);
            keyvalExpression149=keyvalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_keyvalExpression.add(keyvalExpression149.getTree());
            // EolParserRules.g:499:21: ( ',' keyvalExpression )*
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==95) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // EolParserRules.g:499:22: ',' keyvalExpression
            	    {
            	    char_literal150=(Token)match(input,95,FOLLOW_95_in_keyvalExpressionList2185); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_95.add(char_literal150);

            	    pushFollow(FOLLOW_keyvalExpression_in_keyvalExpressionList2187);
            	    keyvalExpression151=keyvalExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_keyvalExpression.add(keyvalExpression151.getTree());

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
            // 500:2: -> ^( KEYVALLIST ( keyvalExpression )+ )
            {
                // EolParserRules.g:500:5: ^( KEYVALLIST ( keyvalExpression )+ )
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
    // EolParserRules.g:503:1: keyvalExpression : additiveExpression eq= '=' logicalExpression ;
    public final Epl_EolParserRules.keyvalExpression_return keyvalExpression() throws RecognitionException {
        Epl_EolParserRules.keyvalExpression_return retval = new Epl_EolParserRules.keyvalExpression_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token eq=null;
        Epl_EolParserRules.additiveExpression_return additiveExpression152 = null;

        Epl_EolParserRules.logicalExpression_return logicalExpression153 = null;


        org.eclipse.epsilon.common.parse.AST eq_tree=null;

        try {
            // EolParserRules.g:505:2: ( additiveExpression eq= '=' logicalExpression )
            // EolParserRules.g:505:4: additiveExpression eq= '=' logicalExpression
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            pushFollow(FOLLOW_additiveExpression_in_keyvalExpression2212);
            additiveExpression152=additiveExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, additiveExpression152.getTree());
            eq=(Token)match(input,99,FOLLOW_99_in_keyvalExpression2216); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            eq_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(eq);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(eq_tree, root_0);
            }
            pushFollow(FOLLOW_logicalExpression_in_keyvalExpression2219);
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
    // EolParserRules.g:508:1: primitiveExpression : ( literalSequentialCollection | literalMapCollection | literal | featureCall | pathName | nativeType | collectionType | logicalExpressionInBrackets | newExpression | variableDeclarationExpression );
    public final Epl_EolParserRules.primitiveExpression_return primitiveExpression() throws RecognitionException {
        Epl_EolParserRules.primitiveExpression_return retval = new Epl_EolParserRules.primitiveExpression_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Epl_EolParserRules.literalSequentialCollection_return literalSequentialCollection154 = null;

        Epl_EolParserRules.literalMapCollection_return literalMapCollection155 = null;

        Epl_EolParserRules.literal_return literal156 = null;

        Epl_EolParserRules.featureCall_return featureCall157 = null;

        Epl_EolParserRules.pathName_return pathName158 = null;

        Epl_EolParserRules.nativeType_return nativeType159 = null;

        Epl_EolParserRules.collectionType_return collectionType160 = null;

        Epl_EolParserRules.logicalExpressionInBrackets_return logicalExpressionInBrackets161 = null;

        Epl_EolParserRules.newExpression_return newExpression162 = null;

        Epl_EolParserRules.variableDeclarationExpression_return variableDeclarationExpression163 = null;



        try {
            // EolParserRules.g:509:2: ( literalSequentialCollection | literalMapCollection | literal | featureCall | pathName | nativeType | collectionType | logicalExpressionInBrackets | newExpression | variableDeclarationExpression )
            int alt65=10;
            alt65 = dfa65.predict(input);
            switch (alt65) {
                case 1 :
                    // EolParserRules.g:509:4: literalSequentialCollection
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_literalSequentialCollection_in_primitiveExpression2233);
                    literalSequentialCollection154=literalSequentialCollection();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, literalSequentialCollection154.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:509:34: literalMapCollection
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_literalMapCollection_in_primitiveExpression2237);
                    literalMapCollection155=literalMapCollection();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, literalMapCollection155.getTree());

                    }
                    break;
                case 3 :
                    // EolParserRules.g:509:57: literal
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_literal_in_primitiveExpression2241);
                    literal156=literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, literal156.getTree());

                    }
                    break;
                case 4 :
                    // EolParserRules.g:509:67: featureCall
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_featureCall_in_primitiveExpression2245);
                    featureCall157=featureCall();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, featureCall157.getTree());

                    }
                    break;
                case 5 :
                    // EolParserRules.g:509:81: pathName
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_pathName_in_primitiveExpression2249);
                    pathName158=pathName();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pathName158.getTree());

                    }
                    break;
                case 6 :
                    // EolParserRules.g:509:92: nativeType
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_nativeType_in_primitiveExpression2253);
                    nativeType159=nativeType();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nativeType159.getTree());

                    }
                    break;
                case 7 :
                    // EolParserRules.g:510:5: collectionType
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_collectionType_in_primitiveExpression2259);
                    collectionType160=collectionType();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, collectionType160.getTree());

                    }
                    break;
                case 8 :
                    // EolParserRules.g:510:23: logicalExpressionInBrackets
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_logicalExpressionInBrackets_in_primitiveExpression2264);
                    logicalExpressionInBrackets161=logicalExpressionInBrackets();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpressionInBrackets161.getTree());

                    }
                    break;
                case 9 :
                    // EolParserRules.g:511:5: newExpression
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_newExpression_in_primitiveExpression2270);
                    newExpression162=newExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, newExpression162.getTree());

                    }
                    break;
                case 10 :
                    // EolParserRules.g:511:21: variableDeclarationExpression
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_variableDeclarationExpression_in_primitiveExpression2274);
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
    // EolParserRules.g:514:1: logicalExpressionInBrackets : ob= '(' logicalExpression cb= ')' ;
    public final Epl_EolParserRules.logicalExpressionInBrackets_return logicalExpressionInBrackets() throws RecognitionException {
        Epl_EolParserRules.logicalExpressionInBrackets_return retval = new Epl_EolParserRules.logicalExpressionInBrackets_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token ob=null;
        Token cb=null;
        Epl_EolParserRules.logicalExpression_return logicalExpression164 = null;


        org.eclipse.epsilon.common.parse.AST ob_tree=null;
        org.eclipse.epsilon.common.parse.AST cb_tree=null;

        try {
            // EolParserRules.g:519:2: (ob= '(' logicalExpression cb= ')' )
            // EolParserRules.g:519:4: ob= '(' logicalExpression cb= ')'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            ob=(Token)match(input,102,FOLLOW_102_in_logicalExpressionInBrackets2293); if (state.failed) return retval;
            pushFollow(FOLLOW_logicalExpression_in_logicalExpressionInBrackets2296);
            logicalExpression164=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression164.getTree());
            cb=(Token)match(input,103,FOLLOW_103_in_logicalExpressionInBrackets2300); if (state.failed) return retval;

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
    // EolParserRules.g:522:1: literal : ( STRING | INT | FLOAT | BOOLEAN );
    public final Epl_EolParserRules.literal_return literal() throws RecognitionException {
        Epl_EolParserRules.literal_return retval = new Epl_EolParserRules.literal_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token set165=null;

        org.eclipse.epsilon.common.parse.AST set165_tree=null;

        try {
            // EolParserRules.g:523:2: ( STRING | INT | FLOAT | BOOLEAN )
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
        // EolParserRules.g:194:4: ( annotation )
        // EolParserRules.g:194:4: annotation
        {
        pushFollow(FOLLOW_annotation_in_synpred16_EolParserRules655);
        annotation();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred16_EolParserRules

    // $ANTLR start synpred28_EolParserRules
    public final void synpred28_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:243:4: ( '(' typeName ')' )
        // EolParserRules.g:243:4: '(' typeName ')'
        {
        match(input,102,FOLLOW_102_in_synpred28_EolParserRules833); if (state.failed) return ;
        pushFollow(FOLLOW_typeName_in_synpred28_EolParserRules838);
        typeName();

        state._fsp--;
        if (state.failed) return ;
        match(input,103,FOLLOW_103_in_synpred28_EolParserRules844); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred28_EolParserRules

    // $ANTLR start synpred29_EolParserRules
    public final void synpred29_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:247:4: ( statementA )
        // EolParserRules.g:247:4: statementA
        {
        pushFollow(FOLLOW_statementA_in_synpred29_EolParserRules859);
        statementA();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred29_EolParserRules

    // $ANTLR start synpred30_EolParserRules
    public final void synpred30_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:251:4: ( assignmentStatement )
        // EolParserRules.g:251:4: assignmentStatement
        {
        pushFollow(FOLLOW_assignmentStatement_in_synpred30_EolParserRules874);
        assignmentStatement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred30_EolParserRules

    // $ANTLR start synpred31_EolParserRules
    public final void synpred31_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:251:26: ( expressionStatement )
        // EolParserRules.g:251:26: expressionStatement
        {
        pushFollow(FOLLOW_expressionStatement_in_synpred31_EolParserRules878);
        expressionStatement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred31_EolParserRules

    // $ANTLR start synpred45_EolParserRules
    public final void synpred45_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:274:66: ( elseStatement )
        // EolParserRules.g:274:66: elseStatement
        {
        pushFollow(FOLLOW_elseStatement_in_synpred45_EolParserRules1033);
        elseStatement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred45_EolParserRules

    // $ANTLR start synpred52_EolParserRules
    public final void synpred52_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:362:22: ( NAME ( ',' NAME )* )
        // EolParserRules.g:362:22: NAME ( ',' NAME )*
        {
        match(input,NAME,FOLLOW_NAME_in_synpred52_EolParserRules1402); if (state.failed) return ;
        // EolParserRules.g:362:27: ( ',' NAME )*
        loop66:
        do {
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==95) ) {
                alt66=1;
            }


            switch (alt66) {
        	case 1 :
        	    // EolParserRules.g:362:28: ',' NAME
        	    {
        	    match(input,95,FOLLOW_95_in_synpred52_EolParserRules1405); if (state.failed) return ;
        	    match(input,NAME,FOLLOW_NAME_in_synpred52_EolParserRules1407); if (state.failed) return ;

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
        // EolParserRules.g:378:5: ( postfixExpression '=' logicalExpression )
        // EolParserRules.g:378:5: postfixExpression '=' logicalExpression
        {
        pushFollow(FOLLOW_postfixExpression_in_synpred54_EolParserRules1477);
        postfixExpression();

        state._fsp--;
        if (state.failed) return ;
        match(input,99,FOLLOW_99_in_synpred54_EolParserRules1481); if (state.failed) return ;
        pushFollow(FOLLOW_logicalExpression_in_synpred54_EolParserRules1484);
        logicalExpression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred54_EolParserRules

    // $ANTLR start synpred65_EolParserRules
    public final void synpred65_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:387:24: ( ( '==' relationalExpression | '=' relationalExpression | ( '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression ) )
        // EolParserRules.g:387:24: ( '==' relationalExpression | '=' relationalExpression | ( '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression )
        {
        // EolParserRules.g:387:24: ( '==' relationalExpression | '=' relationalExpression | ( '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression )
        int alt67=3;
        switch ( input.LA(1) ) {
        case 140:
            {
            alt67=1;
            }
            break;
        case 99:
            {
            alt67=2;
            }
            break;
        case 141:
        case 142:
        case 143:
        case 144:
        case 145:
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
                // EolParserRules.g:387:25: '==' relationalExpression
                {
                match(input,140,FOLLOW_140_in_synpred65_EolParserRules1555); if (state.failed) return ;
                pushFollow(FOLLOW_relationalExpression_in_synpred65_EolParserRules1558);
                relationalExpression();

                state._fsp--;
                if (state.failed) return ;

                }
                break;
            case 2 :
                // EolParserRules.g:387:57: '=' relationalExpression
                {
                match(input,99,FOLLOW_99_in_synpred65_EolParserRules1564); if (state.failed) return ;
                pushFollow(FOLLOW_relationalExpression_in_synpred65_EolParserRules1567);
                relationalExpression();

                state._fsp--;
                if (state.failed) return ;

                }
                break;
            case 3 :
                // EolParserRules.g:388:24: ( '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression
                {
                if ( (input.LA(1)>=141 && input.LA(1)<=145) ) {
                    input.consume();
                    state.errorRecovery=false;state.failed=false;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    MismatchedSetException mse = new MismatchedSetException(null,input);
                    throw mse;
                }

                pushFollow(FOLLOW_additiveExpression_in_synpred65_EolParserRules1621);
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
        // EolParserRules.g:457:19: ( ':' ( 'new' )? typeName ( parameterList )? )
        // EolParserRules.g:457:19: ':' ( 'new' )? typeName ( parameterList )?
        {
        match(input,104,FOLLOW_104_in_synpred84_EolParserRules1974); if (state.failed) return ;
        // EolParserRules.g:457:25: ( 'new' )?
        int alt70=2;
        int LA70_0 = input.LA(1);

        if ( (LA70_0==154) ) {
            alt70=1;
        }
        switch (alt70) {
            case 1 :
                // EolParserRules.g:0:0: 'new'
                {
                match(input,154,FOLLOW_154_in_synpred84_EolParserRules1979); if (state.failed) return ;

                }
                break;

        }

        pushFollow(FOLLOW_typeName_in_synpred84_EolParserRules1985);
        typeName();

        state._fsp--;
        if (state.failed) return ;
        // EolParserRules.g:457:70: ( parameterList )?
        int alt71=2;
        int LA71_0 = input.LA(1);

        if ( (LA71_0==102) ) {
            alt71=1;
        }
        switch (alt71) {
            case 1 :
                // EolParserRules.g:0:0: parameterList
                {
                pushFollow(FOLLOW_parameterList_in_synpred84_EolParserRules1989);
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
        // EolParserRules.g:483:4: ( expressionRange )
        // EolParserRules.g:483:4: expressionRange
        {
        pushFollow(FOLLOW_expressionRange_in_synpred92_EolParserRules2125);
        expressionRange();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred92_EolParserRules

    // $ANTLR start synpred95_EolParserRules
    public final void synpred95_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:509:4: ( literalSequentialCollection )
        // EolParserRules.g:509:4: literalSequentialCollection
        {
        pushFollow(FOLLOW_literalSequentialCollection_in_synpred95_EolParserRules2233);
        literalSequentialCollection();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred95_EolParserRules

    // $ANTLR start synpred96_EolParserRules
    public final void synpred96_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:509:34: ( literalMapCollection )
        // EolParserRules.g:509:34: literalMapCollection
        {
        pushFollow(FOLLOW_literalMapCollection_in_synpred96_EolParserRules2237);
        literalMapCollection();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred96_EolParserRules

    // $ANTLR start synpred98_EolParserRules
    public final void synpred98_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:509:67: ( featureCall )
        // EolParserRules.g:509:67: featureCall
        {
        pushFollow(FOLLOW_featureCall_in_synpred98_EolParserRules2245);
        featureCall();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred98_EolParserRules

    // $ANTLR start synpred99_EolParserRules
    public final void synpred99_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:509:81: ( pathName )
        // EolParserRules.g:509:81: pathName
        {
        pushFollow(FOLLOW_pathName_in_synpred99_EolParserRules2249);
        pathName();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred99_EolParserRules

    // $ANTLR start synpred101_EolParserRules
    public final void synpred101_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:510:5: ( collectionType )
        // EolParserRules.g:510:5: collectionType
        {
        pushFollow(FOLLOW_collectionType_in_synpred101_EolParserRules2259);
        collectionType();

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
    public final boolean synpred95_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred95_EolParserRules_fragment(); // can never throw exception
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
        "\60\uffff";
    static final String DFA20_eofS =
        "\1\2\57\uffff";
    static final String DFA20_minS =
        "\1\11\1\0\56\uffff";
    static final String DFA20_maxS =
        "\1\u00a8\1\0\56\uffff";
    static final String DFA20_acceptS =
        "\2\uffff\1\2\54\uffff\1\1";
    static final String DFA20_specialS =
        "\1\uffff\1\0\56\uffff}>";
    static final String[] DFA20_transitionS = {
            "\3\2\7\uffff\1\2\3\uffff\1\2\105\uffff\1\2\1\uffff\1\2\1\uffff"+
            "\5\2\1\1\2\2\1\uffff\1\2\14\uffff\1\2\16\uffff\20\2\1\uffff"+
            "\3\2\2\uffff\3\2\1\uffff\1\2\1\uffff\7\2",
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
            return "243:3: (op= '(' tn= typeName cp= ')' )?";
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
                        if ( (synpred28_EolParserRules()) ) {s = 47;}

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
        "\1\u009b\23\uffff\1\0\7\uffff";
    static final String DFA21_acceptS =
        "\1\uffff\1\1\24\uffff\1\2\5\uffff";
    static final String DFA21_specialS =
        "\24\uffff\1\0\7\uffff}>";
    static final String[] DFA21_transitionS = {
            "\1\1\3\uffff\1\1\3\uffff\1\1\1\uffff\1\1\4\uffff\1\1\122\uffff"+
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
            return "246:1: statement : ( statementA | statementB );";
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
        "\1\u009b\17\0\10\uffff";
    static final String DFA22_acceptS =
        "\20\uffff\1\3\1\4\1\5\1\6\1\7\1\10\1\1\1\2";
    static final String DFA22_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14"+
        "\1\15\1\16\10\uffff}>";
    static final String[] DFA22_transitionS = {
            "\1\12\3\uffff\1\12\3\uffff\1\12\1\uffff\1\12\4\uffff\1\13\122"+
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
            return "250:1: statementA : ( assignmentStatement | expressionStatement | forStatement | ifStatement | whileStatement | switchStatement | returnStatement | breakStatement );";
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
        "\1\u009b\1\0\34\uffff";
    static final String DFA33_acceptS =
        "\2\uffff\1\2\32\uffff\1\1";
    static final String DFA33_specialS =
        "\1\uffff\1\0\34\uffff}>";
    static final String[] DFA33_transitionS = {
            "\1\2\3\uffff\1\2\3\uffff\1\2\1\uffff\1\2\4\uffff\1\1\115\uffff"+
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
            return "362:21: ( NAME ( ',' NAME )* )?";
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
        "\1\u009b\15\0\3\uffff";
    static final String DFA35_acceptS =
        "\16\uffff\1\2\1\uffff\1\1";
    static final String DFA35_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14"+
        "\3\uffff}>";
    static final String[] DFA35_transitionS = {
            "\1\10\3\uffff\1\10\3\uffff\1\10\1\uffff\1\10\4\uffff\1\11\122"+
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
            return "378:4: ( postfixExpression op= '=' logicalExpression | logicalExpression )";
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
        "\1\u00a8\1\uffff\7\0\1\uffff";
    static final String DFA40_acceptS =
        "\1\uffff\1\2\7\uffff\1\1";
    static final String DFA40_specialS =
        "\2\uffff\1\6\1\5\1\1\1\3\1\0\1\2\1\4\1\uffff}>";
    static final String[] DFA40_transitionS = {
            "\1\1\14\uffff\1\1\105\uffff\1\1\1\uffff\1\1\1\uffff\2\1\1\3"+
            "\2\1\1\uffff\2\1\1\uffff\1\1\14\uffff\1\1\16\uffff\6\1\1\2\1"+
            "\4\1\5\1\6\1\7\1\10\6\uffff\1\1\3\uffff\3\1\1\uffff\1\1\1\uffff"+
            "\7\1",
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
            return "()* loopback of 387:23: ( (op= '==' relationalExpression | op= '=' relationalExpression | (op= '>' | op= '<' | op= '>=' | op= '<=' | op= '<>' ) additiveExpression ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA40_6 = input.LA(1);

                         
                        int index40_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_EolParserRules()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index40_6);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA40_4 = input.LA(1);

                         
                        int index40_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_EolParserRules()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index40_4);
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
                        int LA40_5 = input.LA(1);

                         
                        int index40_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_EolParserRules()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index40_5);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA40_8 = input.LA(1);

                         
                        int index40_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_EolParserRules()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index40_8);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA40_3 = input.LA(1);

                         
                        int index40_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_EolParserRules()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index40_3);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA40_2 = input.LA(1);

                         
                        int index40_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_EolParserRules()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index40_2);
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
        "\1\23\1\u00a8\1\u009b\1\uffff\1\u0099\1\u009b\1\uffff\1\u0099";
    static final String DFA50_acceptS =
        "\3\uffff\1\1\2\uffff\1\2\1\uffff";
    static final String DFA50_specialS =
        "\10\uffff}>";
    static final String[] DFA50_transitionS = {
            "\1\1",
            "\3\3\13\uffff\1\3\105\uffff\1\3\1\uffff\1\3\1\uffff\5\3\1\2"+
            "\2\3\1\uffff\1\3\14\uffff\1\3\16\uffff\20\3\1\uffff\2\3\3\uffff"+
            "\3\3\1\uffff\1\3\1\uffff\7\3",
            "\1\3\3\uffff\1\3\3\uffff\1\3\1\uffff\1\3\4\uffff\1\4\122\uffff"+
            "\2\3\6\uffff\10\3\35\uffff\1\3\2\uffff\1\3\3\uffff\2\3",
            "",
            "\1\3\1\uffff\1\3\123\uffff\1\5\3\uffff\1\3\2\uffff\2\3\1\6\2"+
            "\uffff\3\3\32\uffff\16\3\1\uffff\1\3\1\uffff\1\6",
            "\1\3\3\uffff\1\3\3\uffff\1\3\1\uffff\1\3\4\uffff\1\7\122\uffff"+
            "\1\3\7\uffff\10\3\35\uffff\1\3\2\uffff\1\3\3\uffff\2\3",
            "",
            "\1\3\1\uffff\1\3\123\uffff\1\5\3\uffff\1\3\2\uffff\2\3\1\6\2"+
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
            return "417:1: featureCall : ( simpleFeatureCall | declarativeFeatureCall );";
        }
    }
    static final String DFA58_eotS =
        "\27\uffff";
    static final String DFA58_eofS =
        "\2\2\25\uffff";
    static final String DFA58_minS =
        "\1\11\1\4\1\uffff\10\0\1\146\1\23\1\uffff\1\16\1\0\1\146\1\0\1\147"+
        "\1\16\1\0\1\147\1\0";
    static final String DFA58_maxS =
        "\1\u00a8\1\u009b\1\uffff\10\0\1\146\1\165\1\uffff\1\16\1\0\1\146"+
        "\1\0\1\147\1\16\1\0\1\147\1\0";
    static final String DFA58_acceptS =
        "\2\uffff\1\2\12\uffff\1\1\11\uffff";
    static final String DFA58_specialS =
        "\3\uffff\1\1\1\5\1\13\1\10\1\4\1\2\1\11\1\12\4\uffff\1\3\1\uffff"+
        "\1\6\2\uffff\1\7\1\uffff\1\0}>";
    static final String[] DFA58_transitionS = {
            "\3\2\13\uffff\1\2\105\uffff\1\2\1\uffff\1\2\1\uffff\5\2\1\uffff"+
            "\1\2\1\1\1\uffff\1\2\14\uffff\1\2\16\uffff\20\2\1\uffff\2\2"+
            "\3\uffff\3\2\1\uffff\1\2\1\uffff\7\2",
            "\1\2\3\uffff\1\2\3\uffff\1\2\1\uffff\1\2\4\uffff\1\12\116\uffff"+
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
            "\1\17\132\uffff\1\20\7\21",
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
            return "457:18: ( ':' (n= 'new' )? t= typeName ( parameterList )? )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA58_22 = input.LA(1);

                         
                        int index58_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred84_EolParserRules()) ) {s = 13;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index58_22);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA58_3 = input.LA(1);

                         
                        int index58_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred84_EolParserRules()) ) {s = 13;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index58_3);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA58_8 = input.LA(1);

                         
                        int index58_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred84_EolParserRules()) ) {s = 13;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index58_8);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA58_15 = input.LA(1);

                         
                        int index58_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred84_EolParserRules()) ) {s = 13;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index58_15);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA58_7 = input.LA(1);

                         
                        int index58_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred84_EolParserRules()) ) {s = 13;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index58_7);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA58_4 = input.LA(1);

                         
                        int index58_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred84_EolParserRules()) ) {s = 13;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index58_4);
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
                        int LA58_20 = input.LA(1);

                         
                        int index58_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred84_EolParserRules()) ) {s = 13;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index58_20);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA58_6 = input.LA(1);

                         
                        int index58_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred84_EolParserRules()) ) {s = 13;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index58_6);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA58_9 = input.LA(1);

                         
                        int index58_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred84_EolParserRules()) ) {s = 13;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index58_9);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA58_10 = input.LA(1);

                         
                        int index58_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred84_EolParserRules()) ) {s = 13;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index58_10);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA58_5 = input.LA(1);

                         
                        int index58_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred84_EolParserRules()) ) {s = 13;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index58_5);
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
        "\1\u009b\17\0\2\uffff";
    static final String DFA62_acceptS =
        "\20\uffff\1\1\1\2";
    static final String DFA62_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14"+
        "\1\15\1\16\2\uffff}>";
    static final String[] DFA62_transitionS = {
            "\1\12\3\uffff\1\12\3\uffff\1\12\1\uffff\1\12\4\uffff\1\13\122"+
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
            return "482:1: expressionListOrRange : ( expressionRange | expressionList );";
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
        "\23\uffff";
    static final String DFA65_minS =
        "\1\4\7\0\1\uffff\1\0\11\uffff";
    static final String DFA65_maxS =
        "\1\u009b\7\0\1\uffff\1\0\11\uffff";
    static final String DFA65_acceptS =
        "\10\uffff\1\3\1\uffff\1\6\1\10\1\11\1\12\1\1\1\7\1\2\1\4\1\5";
    static final String DFA65_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\uffff\1\7\11\uffff}>";
    static final String[] DFA65_transitionS = {
            "\1\10\3\uffff\1\10\3\uffff\1\10\1\uffff\1\10\4\uffff\1\11\122"+
            "\uffff\1\13\7\uffff\1\12\1\1\1\2\1\3\1\4\1\5\1\6\1\7\44\uffff"+
            "\1\14\1\15",
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
            return "508:1: primitiveExpression : ( literalSequentialCollection | literalMapCollection | literal | featureCall | pathName | nativeType | collectionType | logicalExpressionInBrackets | newExpression | variableDeclarationExpression );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA65_1 = input.LA(1);

                         
                        int index65_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred95_EolParserRules()) ) {s = 14;}

                        else if ( (synpred101_EolParserRules()) ) {s = 15;}

                         
                        input.seek(index65_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA65_2 = input.LA(1);

                         
                        int index65_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred95_EolParserRules()) ) {s = 14;}

                        else if ( (synpred101_EolParserRules()) ) {s = 15;}

                         
                        input.seek(index65_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA65_3 = input.LA(1);

                         
                        int index65_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred95_EolParserRules()) ) {s = 14;}

                        else if ( (synpred101_EolParserRules()) ) {s = 15;}

                         
                        input.seek(index65_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA65_4 = input.LA(1);

                         
                        int index65_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred95_EolParserRules()) ) {s = 14;}

                        else if ( (synpred101_EolParserRules()) ) {s = 15;}

                         
                        input.seek(index65_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA65_5 = input.LA(1);

                         
                        int index65_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred95_EolParserRules()) ) {s = 14;}

                        else if ( (synpred101_EolParserRules()) ) {s = 15;}

                         
                        input.seek(index65_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA65_6 = input.LA(1);

                         
                        int index65_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred95_EolParserRules()) ) {s = 14;}

                        else if ( (synpred101_EolParserRules()) ) {s = 15;}

                         
                        input.seek(index65_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA65_7 = input.LA(1);

                         
                        int index65_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred96_EolParserRules()) ) {s = 16;}

                        else if ( (synpred101_EolParserRules()) ) {s = 15;}

                         
                        input.seek(index65_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
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
    public static final BitSet FOLLOW_92_in_modelDeclaration261 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_modelDeclaration264 = new BitSet(new long[]{0x0000000000000000L,0x0000000360000000L});
    public static final BitSet FOLLOW_modelAlias_in_modelDeclaration266 = new BitSet(new long[]{0x0000000000000000L,0x0000000320000000L});
    public static final BitSet FOLLOW_modelDriver_in_modelDeclaration269 = new BitSet(new long[]{0x0000000000000000L,0x0000000220000000L});
    public static final BitSet FOLLOW_modelDeclarationParameters_in_modelDeclaration272 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_modelDeclaration275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_modelAlias293 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_modelAlias296 = new BitSet(new long[]{0x0000000000000002L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_modelAlias299 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_modelAlias302 = new BitSet(new long[]{0x0000000000000002L,0x0000000080000000L});
    public static final BitSet FOLLOW_96_in_modelDriver321 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_modelDriver324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_97_in_modelDeclarationParameters340 = new BitSet(new long[]{0x0000000000080000L,0x0000000480000000L});
    public static final BitSet FOLLOW_modelDeclarationParameter_in_modelDeclarationParameters343 = new BitSet(new long[]{0x0000000000000000L,0x0000000480000000L});
    public static final BitSet FOLLOW_95_in_modelDeclarationParameters347 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_modelDeclarationParameter_in_modelDeclarationParameters350 = new BitSet(new long[]{0x0000000000000000L,0x0000000480000000L});
    public static final BitSet FOLLOW_98_in_modelDeclarationParameters354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_modelDeclarationParameter370 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_99_in_modelDeclarationParameter374 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_STRING_in_modelDeclarationParameter377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_operationDeclaration398 = new BitSet(new long[]{0x0000000000080000L,0x003FC00000000000L});
    public static final BitSet FOLLOW_typeName_in_operationDeclaration408 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_operationDeclaration416 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_102_in_operationDeclaration420 = new BitSet(new long[]{0x0000000000080000L,0x0000008000000000L});
    public static final BitSet FOLLOW_formalParameterList_in_operationDeclaration423 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_103_in_operationDeclaration428 = new BitSet(new long[]{0x0000000000000000L,0x0000010200000000L});
    public static final BitSet FOLLOW_104_in_operationDeclaration432 = new BitSet(new long[]{0x0000000000080000L,0x003FC00000000000L});
    public static final BitSet FOLLOW_typeName_in_operationDeclaration437 = new BitSet(new long[]{0x0000000000000000L,0x0000010200000000L});
    public static final BitSet FOLLOW_statementBlock_in_operationDeclaration443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_105_in_importStatement463 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_STRING_in_importStatement466 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_importStatement470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_block490 = new BitSet(new long[]{0x0000000000085112L,0xE37FC04000000000L,0x000000000C48003FL});
    public static final BitSet FOLLOW_97_in_statementBlock519 = new BitSet(new long[]{0x0000000000085110L,0xE37FC04000000000L,0x000000000C48003FL});
    public static final BitSet FOLLOW_block_in_statementBlock522 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_98_in_statementBlock526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_formalParameter544 = new BitSet(new long[]{0x0000000000000002L,0x0000010000000000L});
    public static final BitSet FOLLOW_104_in_formalParameter547 = new BitSet(new long[]{0x0000000000080000L,0x003FC00000000000L});
    public static final BitSet FOLLOW_typeName_in_formalParameter551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_formalParameter_in_formalParameterList585 = new BitSet(new long[]{0x0000000000000002L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_formalParameterList588 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_formalParameter_in_formalParameterList590 = new BitSet(new long[]{0x0000000000000002L,0x0000000080000000L});
    public static final BitSet FOLLOW_106_in_executableAnnotation615 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0xFFFFFFFFFFFFFFFFL,0x000001FFFFFFFFFFL});
    public static final BitSet FOLLOW_logicalExpression_in_executableAnnotation622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Annotation_in_annotation636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_executableAnnotation_in_annotation638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotation_in_annotationBlock655 = new BitSet(new long[]{0x0000000000800002L,0x0000040000000000L});
    public static final BitSet FOLLOW_pathName_in_typeName684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nativeType_in_typeName688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectionType_in_typeName692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_pathName706 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
    public static final BitSet FOLLOW_107_in_pathName708 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_packagedType_in_pathName717 = new BitSet(new long[]{0x0000000000000002L,0x0000100000000000L});
    public static final BitSet FOLLOW_108_in_pathName723 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_pathName728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_packagedType749 = new BitSet(new long[]{0x0000000000000002L,0x0000200000000000L});
    public static final BitSet FOLLOW_109_in_packagedType752 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_packagedType757 = new BitSet(new long[]{0x0000000000000002L,0x0000200000000000L});
    public static final BitSet FOLLOW_110_in_nativeType782 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_102_in_nativeType785 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_STRING_in_nativeType788 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_103_in_nativeType790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_collectionType811 = new BitSet(new long[]{0x0000000000000002L,0x0000004000000000L});
    public static final BitSet FOLLOW_102_in_collectionType833 = new BitSet(new long[]{0x0000000000080000L,0x003FC00000000000L});
    public static final BitSet FOLLOW_typeName_in_collectionType838 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_103_in_collectionType844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementA_in_statement859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementB_in_statement863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignmentStatement_in_statementA874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionStatement_in_statementA878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_forStatement_in_statementA882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStatement_in_statementA888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_whileStatement_in_statementA892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_switchStatement_in_statementA896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_returnStatement_in_statementA900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_breakStatement_in_statementA904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_breakAllStatement_in_statementB916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_returnStatement_in_statementB920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_transactionStatement_in_statementB924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_abortStatement_in_statementB930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_continueStatement_in_statementB934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_throwStatement_in_statementB938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_deleteStatement_in_statementB944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_statementOrStatementBlock955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementBlock_in_statementOrStatementBlock959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_104_in_expressionOrStatementBlock968 = new BitSet(new long[]{0x0000000000085110L,0x003FC04000000000L,0x000000000C480000L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionOrStatementBlock971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementBlock_in_expressionOrStatementBlock975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_118_in_forStatement988 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_102_in_forStatement991 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_formalParameter_in_forStatement994 = new BitSet(new long[]{0x0000000000000000L,0x0080000000000000L});
    public static final BitSet FOLLOW_119_in_forStatement996 = new BitSet(new long[]{0x0000000000085110L,0x003FC04000000000L,0x000000000C480000L});
    public static final BitSet FOLLOW_logicalExpression_in_forStatement999 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_103_in_forStatement1001 = new BitSet(new long[]{0x0000000000085110L,0xE37FC14200000000L,0x000000000C48003FL});
    public static final BitSet FOLLOW_statementOrStatementBlock_in_forStatement1004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_120_in_ifStatement1020 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_102_in_ifStatement1023 = new BitSet(new long[]{0x0000000000085110L,0x003FC04000000000L,0x000000000C480000L});
    public static final BitSet FOLLOW_logicalExpression_in_ifStatement1026 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_103_in_ifStatement1028 = new BitSet(new long[]{0x0000000000085110L,0xE37FC14200000000L,0x000000000C48003FL});
    public static final BitSet FOLLOW_statementOrStatementBlock_in_ifStatement1031 = new BitSet(new long[]{0x0000000000000002L,0x1000000000000000L});
    public static final BitSet FOLLOW_elseStatement_in_ifStatement1033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_121_in_switchStatement1052 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_102_in_switchStatement1055 = new BitSet(new long[]{0x0000000000085110L,0x003FC04000000000L,0x000000000C480000L});
    public static final BitSet FOLLOW_logicalExpression_in_switchStatement1058 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_103_in_switchStatement1060 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_97_in_switchStatement1063 = new BitSet(new long[]{0x0000000000000000L,0x0C00000400000000L});
    public static final BitSet FOLLOW_caseStatement_in_switchStatement1066 = new BitSet(new long[]{0x0000000000000000L,0x0C00000400000000L});
    public static final BitSet FOLLOW_defaultStatement_in_switchStatement1069 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_98_in_switchStatement1072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_122_in_caseStatement1091 = new BitSet(new long[]{0x0000000000085110L,0x003FC04000000000L,0x000000000C480000L});
    public static final BitSet FOLLOW_logicalExpression_in_caseStatement1094 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_104_in_caseStatement1096 = new BitSet(new long[]{0x0000000000085110L,0xE37FC04000000000L,0x000000000C48003FL});
    public static final BitSet FOLLOW_block_in_caseStatement1099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_123_in_defaultStatement1117 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_104_in_defaultStatement1120 = new BitSet(new long[]{0x0000000000085110L,0xE37FC04000000000L,0x000000000C48003FL});
    public static final BitSet FOLLOW_block_in_defaultStatement1123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_124_in_elseStatement1147 = new BitSet(new long[]{0x0000000000085110L,0xE37FC14200000000L,0x000000000C48003FL});
    public static final BitSet FOLLOW_statementOrStatementBlock_in_elseStatement1150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_125_in_whileStatement1163 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_102_in_whileStatement1166 = new BitSet(new long[]{0x0000000000085110L,0x003FC04000000000L,0x000000000C480000L});
    public static final BitSet FOLLOW_logicalExpression_in_whileStatement1169 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_103_in_whileStatement1171 = new BitSet(new long[]{0x0000000000085110L,0xE37FC14200000000L,0x000000000C48003FL});
    public static final BitSet FOLLOW_statementOrStatementBlock_in_whileStatement1174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_126_in_returnStatement1196 = new BitSet(new long[]{0x0000000000085110L,0x003FC04020000000L,0x000000000C480000L});
    public static final BitSet FOLLOW_logicalExpression_in_returnStatement1199 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_returnStatement1204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_127_in_throwStatement1227 = new BitSet(new long[]{0x0000000000085110L,0x003FC04020000000L,0x000000000C480000L});
    public static final BitSet FOLLOW_logicalExpression_in_throwStatement1230 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_throwStatement1235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_128_in_deleteStatement1258 = new BitSet(new long[]{0x0000000000085110L,0x003FC04020000000L,0x000000000C480000L});
    public static final BitSet FOLLOW_logicalExpression_in_deleteStatement1261 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_deleteStatement1266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_129_in_breakStatement1292 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_breakStatement1297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_130_in_breakAllStatement1320 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_breakAllStatement1325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_131_in_continueStatement1348 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_continueStatement1353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_132_in_abortStatement1376 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_abortStatement1381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_133_in_transactionStatement1398 = new BitSet(new long[]{0x0000000000085110L,0xE37FC14200000000L,0x000000000C48003FL});
    public static final BitSet FOLLOW_NAME_in_transactionStatement1402 = new BitSet(new long[]{0x0000000000085110L,0xE37FC14280000000L,0x000000000C48003FL});
    public static final BitSet FOLLOW_95_in_transactionStatement1405 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_transactionStatement1407 = new BitSet(new long[]{0x0000000000085110L,0xE37FC14280000000L,0x000000000C48003FL});
    public static final BitSet FOLLOW_statementOrStatementBlock_in_transactionStatement1413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logicalExpression_in_assignmentStatement1433 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x00000000000000C0L});
    public static final BitSet FOLLOW_134_in_assignmentStatement1438 = new BitSet(new long[]{0x0000000000085110L,0x003FC04000000000L,0x000000000C480000L});
    public static final BitSet FOLLOW_135_in_assignmentStatement1445 = new BitSet(new long[]{0x0000000000085110L,0x003FC04000000000L,0x000000000C480000L});
    public static final BitSet FOLLOW_logicalExpression_in_assignmentStatement1451 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_assignmentStatement1455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_postfixExpression_in_expressionStatement1477 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_99_in_expressionStatement1481 = new BitSet(new long[]{0x0000000000085110L,0x003FC04000000000L,0x000000000C480000L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionStatement1484 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionStatement1490 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_expressionStatement1495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_relationalExpression_in_logicalExpression1507 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000F00L});
    public static final BitSet FOLLOW_136_in_logicalExpression1513 = new BitSet(new long[]{0x0000000000085110L,0x003FC04000000000L,0x000000000C480000L});
    public static final BitSet FOLLOW_137_in_logicalExpression1518 = new BitSet(new long[]{0x0000000000085110L,0x003FC04000000000L,0x000000000C480000L});
    public static final BitSet FOLLOW_138_in_logicalExpression1523 = new BitSet(new long[]{0x0000000000085110L,0x003FC04000000000L,0x000000000C480000L});
    public static final BitSet FOLLOW_139_in_logicalExpression1528 = new BitSet(new long[]{0x0000000000085110L,0x003FC04000000000L,0x000000000C480000L});
    public static final BitSet FOLLOW_relationalExpression_in_logicalExpression1532 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000F00L});
    public static final BitSet FOLLOW_additiveExpression_in_relationalExpression1549 = new BitSet(new long[]{0x0000000000000002L,0x0000000800000000L,0x000000000003F000L});
    public static final BitSet FOLLOW_140_in_relationalExpression1555 = new BitSet(new long[]{0x0000000000085110L,0x003FC04000000000L,0x000000000C480000L});
    public static final BitSet FOLLOW_relationalExpression_in_relationalExpression1558 = new BitSet(new long[]{0x0000000000000002L,0x0000000800000000L,0x000000000003F000L});
    public static final BitSet FOLLOW_99_in_relationalExpression1564 = new BitSet(new long[]{0x0000000000085110L,0x003FC04000000000L,0x000000000C480000L});
    public static final BitSet FOLLOW_relationalExpression_in_relationalExpression1567 = new BitSet(new long[]{0x0000000000000002L,0x0000000800000000L,0x000000000003F000L});
    public static final BitSet FOLLOW_141_in_relationalExpression1597 = new BitSet(new long[]{0x0000000000085110L,0x003FC04000000000L,0x000000000C480000L});
    public static final BitSet FOLLOW_142_in_relationalExpression1602 = new BitSet(new long[]{0x0000000000085110L,0x003FC04000000000L,0x000000000C480000L});
    public static final BitSet FOLLOW_143_in_relationalExpression1607 = new BitSet(new long[]{0x0000000000085110L,0x003FC04000000000L,0x000000000C480000L});
    public static final BitSet FOLLOW_144_in_relationalExpression1612 = new BitSet(new long[]{0x0000000000085110L,0x003FC04000000000L,0x000000000C480000L});
    public static final BitSet FOLLOW_145_in_relationalExpression1617 = new BitSet(new long[]{0x0000000000085110L,0x003FC04000000000L,0x000000000C480000L});
    public static final BitSet FOLLOW_additiveExpression_in_relationalExpression1621 = new BitSet(new long[]{0x0000000000000002L,0x0000000800000000L,0x000000000003F000L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_additiveExpression1639 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x00000000000C0000L});
    public static final BitSet FOLLOW_146_in_additiveExpression1645 = new BitSet(new long[]{0x0000000000085110L,0x003FC04000000000L,0x000000000C480000L});
    public static final BitSet FOLLOW_147_in_additiveExpression1650 = new BitSet(new long[]{0x0000000000085110L,0x003FC04000000000L,0x000000000C480000L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_additiveExpression1654 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x00000000000C0000L});
    public static final BitSet FOLLOW_unaryExpression_in_multiplicativeExpression1672 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000300000L});
    public static final BitSet FOLLOW_148_in_multiplicativeExpression1678 = new BitSet(new long[]{0x0000000000085110L,0x003FC04000000000L,0x000000000C480000L});
    public static final BitSet FOLLOW_149_in_multiplicativeExpression1683 = new BitSet(new long[]{0x0000000000085110L,0x003FC04000000000L,0x000000000C480000L});
    public static final BitSet FOLLOW_unaryExpression_in_multiplicativeExpression1687 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000300000L});
    public static final BitSet FOLLOW_150_in_unaryExpression1708 = new BitSet(new long[]{0x0000000000085110L,0x003FC04000000000L,0x000000000C480000L});
    public static final BitSet FOLLOW_147_in_unaryExpression1713 = new BitSet(new long[]{0x0000000000085110L,0x003FC04000000000L,0x000000000C480000L});
    public static final BitSet FOLLOW_postfixExpression_in_unaryExpression1721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_itemSelectorExpression_in_postfixExpression1733 = new BitSet(new long[]{0x0000000000000A02L});
    public static final BitSet FOLLOW_set_in_postfixExpression1736 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_featureCall_in_postfixExpression1745 = new BitSet(new long[]{0x0000000000000A02L,0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_151_in_postfixExpression1754 = new BitSet(new long[]{0x0000000000085110L,0x003FC04000000000L,0x000000000C480000L});
    public static final BitSet FOLLOW_logicalExpression_in_postfixExpression1757 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_152_in_postfixExpression1759 = new BitSet(new long[]{0x0000000000000A02L,0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_primitiveExpression_in_itemSelectorExpression1781 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_151_in_itemSelectorExpression1786 = new BitSet(new long[]{0x0000000000085110L,0x003FC04000000000L,0x000000000C480000L});
    public static final BitSet FOLLOW_primitiveExpression_in_itemSelectorExpression1789 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_152_in_itemSelectorExpression1791 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_simpleFeatureCall_in_featureCall1810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declarativeFeatureCall_in_featureCall1814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_simpleFeatureCall1828 = new BitSet(new long[]{0x0000000000000002L,0x0000004000000000L});
    public static final BitSet FOLLOW_parameterList_in_simpleFeatureCall1831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_102_in_parameterList1854 = new BitSet(new long[]{0x0000000000085110L,0x003FC0C000000000L,0x000000000C480000L});
    public static final BitSet FOLLOW_logicalExpression_in_parameterList1857 = new BitSet(new long[]{0x0000000000000000L,0x0000008080000000L});
    public static final BitSet FOLLOW_95_in_parameterList1860 = new BitSet(new long[]{0x0000000000085110L,0x003FC04000000000L,0x000000000C480000L});
    public static final BitSet FOLLOW_logicalExpression_in_parameterList1862 = new BitSet(new long[]{0x0000000000000000L,0x0000008080000000L});
    public static final BitSet FOLLOW_103_in_parameterList1870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_declarativeFeatureCall1898 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_102_in_declarativeFeatureCall1903 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_formalParameterList_in_declarativeFeatureCall1906 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_153_in_declarativeFeatureCall1908 = new BitSet(new long[]{0x0000000000085110L,0x003FC04000000000L,0x000000000C480000L});
    public static final BitSet FOLLOW_logicalExpression_in_declarativeFeatureCall1911 = new BitSet(new long[]{0x0000000000000000L,0x0000008080000000L});
    public static final BitSet FOLLOW_95_in_declarativeFeatureCall1914 = new BitSet(new long[]{0x0000000000085110L,0x003FC04000000000L,0x000000000C480000L});
    public static final BitSet FOLLOW_logicalExpression_in_declarativeFeatureCall1917 = new BitSet(new long[]{0x0000000000000000L,0x0000008080000000L});
    public static final BitSet FOLLOW_103_in_declarativeFeatureCall1923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_154_in_newExpression1937 = new BitSet(new long[]{0x0000000000080000L,0x003FC00000000000L});
    public static final BitSet FOLLOW_typeName_in_newExpression1942 = new BitSet(new long[]{0x0000000000000002L,0x0000004000000000L});
    public static final BitSet FOLLOW_parameterList_in_newExpression1946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_155_in_variableDeclarationExpression1968 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_variableDeclarationExpression1971 = new BitSet(new long[]{0x0000000000000002L,0x0000010000000000L});
    public static final BitSet FOLLOW_104_in_variableDeclarationExpression1974 = new BitSet(new long[]{0x0000000000080000L,0x003FC00000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_154_in_variableDeclarationExpression1979 = new BitSet(new long[]{0x0000000000080000L,0x003FC00000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_typeName_in_variableDeclarationExpression1985 = new BitSet(new long[]{0x0000000000000002L,0x0000004000000000L});
    public static final BitSet FOLLOW_parameterList_in_variableDeclarationExpression1989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_111_in_literalSequentialCollection2013 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_112_in_literalSequentialCollection2018 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_113_in_literalSequentialCollection2023 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_114_in_literalSequentialCollection2028 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_115_in_literalSequentialCollection2033 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_116_in_literalSequentialCollection2038 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_97_in_literalSequentialCollection2044 = new BitSet(new long[]{0x0000000000085110L,0x003FC04400000000L,0x000000000C480000L});
    public static final BitSet FOLLOW_expressionListOrRange_in_literalSequentialCollection2048 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_98_in_literalSequentialCollection2053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionRange2068 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_POINT_POINT_in_expressionRange2072 = new BitSet(new long[]{0x0000000000085110L,0x003FC04000000000L,0x000000000C480000L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionRange2075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionList2096 = new BitSet(new long[]{0x0000000000000002L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_expressionList2099 = new BitSet(new long[]{0x0000000000085110L,0x003FC04000000000L,0x000000000C480000L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionList2101 = new BitSet(new long[]{0x0000000000000002L,0x0000000080000000L});
    public static final BitSet FOLLOW_expressionRange_in_expressionListOrRange2125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionList_in_expressionListOrRange2129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_117_in_literalMapCollection2148 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_97_in_literalMapCollection2153 = new BitSet(new long[]{0x0000000000085110L,0x003FC04400000000L,0x000000000C480000L});
    public static final BitSet FOLLOW_keyvalExpressionList_in_literalMapCollection2156 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_98_in_literalMapCollection2161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_keyvalExpression_in_keyvalExpressionList2182 = new BitSet(new long[]{0x0000000000000002L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_keyvalExpressionList2185 = new BitSet(new long[]{0x0000000000085110L,0x003FC04000000000L,0x000000000C480000L});
    public static final BitSet FOLLOW_keyvalExpression_in_keyvalExpressionList2187 = new BitSet(new long[]{0x0000000000000002L,0x0000000080000000L});
    public static final BitSet FOLLOW_additiveExpression_in_keyvalExpression2212 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_99_in_keyvalExpression2216 = new BitSet(new long[]{0x0000000000085110L,0x003FC04000000000L,0x000000000C480000L});
    public static final BitSet FOLLOW_logicalExpression_in_keyvalExpression2219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literalSequentialCollection_in_primitiveExpression2233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literalMapCollection_in_primitiveExpression2237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_primitiveExpression2241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_featureCall_in_primitiveExpression2245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pathName_in_primitiveExpression2249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nativeType_in_primitiveExpression2253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectionType_in_primitiveExpression2259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logicalExpressionInBrackets_in_primitiveExpression2264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_newExpression_in_primitiveExpression2270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variableDeclarationExpression_in_primitiveExpression2274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_102_in_logicalExpressionInBrackets2293 = new BitSet(new long[]{0x0000000000085110L,0x003FC04000000000L,0x000000000C480000L});
    public static final BitSet FOLLOW_logicalExpression_in_logicalExpressionInBrackets2296 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_103_in_logicalExpressionInBrackets2300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_literal0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotation_in_synpred16_EolParserRules655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_102_in_synpred28_EolParserRules833 = new BitSet(new long[]{0x0000000000080000L,0x003FC00000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_typeName_in_synpred28_EolParserRules838 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_103_in_synpred28_EolParserRules844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementA_in_synpred29_EolParserRules859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignmentStatement_in_synpred30_EolParserRules874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionStatement_in_synpred31_EolParserRules878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_elseStatement_in_synpred45_EolParserRules1033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_synpred52_EolParserRules1402 = new BitSet(new long[]{0x0000000000000002L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_synpred52_EolParserRules1405 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_synpred52_EolParserRules1407 = new BitSet(new long[]{0x0000000000000002L,0x0000000080000000L});
    public static final BitSet FOLLOW_postfixExpression_in_synpred54_EolParserRules1477 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_99_in_synpred54_EolParserRules1481 = new BitSet(new long[]{0x0000000000085110L,0x003FC04000000000L,0x000000000C480000L});
    public static final BitSet FOLLOW_logicalExpression_in_synpred54_EolParserRules1484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_140_in_synpred65_EolParserRules1555 = new BitSet(new long[]{0x0000000000085110L,0x003FC04000000000L,0x000000000C480000L});
    public static final BitSet FOLLOW_relationalExpression_in_synpred65_EolParserRules1558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_99_in_synpred65_EolParserRules1564 = new BitSet(new long[]{0x0000000000085110L,0x003FC04000000000L,0x000000000C480000L});
    public static final BitSet FOLLOW_relationalExpression_in_synpred65_EolParserRules1567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred65_EolParserRules1594 = new BitSet(new long[]{0x0000000000085110L,0x003FC04000000000L,0x000000000C480000L});
    public static final BitSet FOLLOW_additiveExpression_in_synpred65_EolParserRules1621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_104_in_synpred84_EolParserRules1974 = new BitSet(new long[]{0x0000000000080000L,0x003FC00000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_154_in_synpred84_EolParserRules1979 = new BitSet(new long[]{0x0000000000080000L,0x003FC00000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_typeName_in_synpred84_EolParserRules1985 = new BitSet(new long[]{0x0000000000000002L,0x0000004000000000L});
    public static final BitSet FOLLOW_parameterList_in_synpred84_EolParserRules1989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionRange_in_synpred92_EolParserRules2125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literalSequentialCollection_in_synpred95_EolParserRules2233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literalMapCollection_in_synpred96_EolParserRules2237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_featureCall_in_synpred98_EolParserRules2245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pathName_in_synpred99_EolParserRules2249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectionType_in_synpred101_EolParserRules2259 = new BitSet(new long[]{0x0000000000000002L});

}
