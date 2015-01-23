package org.eclipse.epsilon.eol.parse;

// $ANTLR 3.1b1 EolParserRules.g 2015-01-23 13:47:07

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
public class Eol_EolParserRules extends org.eclipse.epsilon.common.parse.EpsilonParser {
    public static final int EXPONENT=6;
    public static final int WHILE=33;
    public static final int StatementBlock=29;
    public static final int StrangeNameLiteral=15;
    public static final int CASE=35;
    public static final int NEW=49;
    public static final int FeatureCall=60;
    public static final int EOF=-1;
    public static final int BREAK=38;
    public static final int KEYVALLIST=76;
    public static final int TYPE=64;
    public static final int T__93=93;
    public static final int T__94=94;
    public static final int T__91=91;
    public static final int IMPORT=66;
    public static final int T__92=92;
    public static final int NAME=19;
    public static final int T__90=90;
    public static final int RETURN=37;
    public static final int NewExpression=47;
    public static final int VAR=48;
    public static final int ANNOTATIONBLOCK=50;
    public static final int NativeType=56;
    public static final int ABORT=43;
    public static final int COMMENT=21;
    public static final int T__99=99;
    public static final int ITEMSELECTOR=73;
    public static final int T__98=98;
    public static final int T__97=97;
    public static final int MultiplicativeExpression=57;
    public static final int T__96=96;
    public static final int T__95=95;
    public static final int FLOAT_TYPE_SUFFIX=7;
    public static final int T__139=139;
    public static final int T__138=138;
    public static final int T__137=137;
    public static final int T__136=136;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
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
    public static final int T__85=85;
    public static final int T__141=141;
    public static final int T__84=84;
    public static final int T__87=87;
    public static final int HELPERMETHOD=28;
    public static final int T__86=86;
    public static final int T__140=140;
    public static final int T__89=89;
    public static final int NAMESPACE=68;
    public static final int T__88=88;
    public static final int CollectionType=44;
    public static final int T__126=126;
    public static final int T__125=125;
    public static final int T__128=128;
    public static final int T__127=127;
    public static final int WS=20;
    public static final int T__129=129;
    public static final int ALIAS=69;
    public static final int JavaIDDigit=18;
    public static final int Annotation=23;
    public static final int T__130=130;
    public static final int T__131=131;
    public static final int EscapeSequence=13;
    public static final int Letter=16;
    public static final int THROW=53;
    public static final int T__132=132;
    public static final int T__79=79;
    public static final int T__133=133;
    public static final int T__78=78;
    public static final int T__134=134;
    public static final int T__77=77;
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
    public static final int T__100=100;
    public static final int POINT_POINT=10;
    public static final int SpecialNameChar=17;
    public static final int MODELDECLARATIONPARAMETERS=71;
    public static final int BLOCK=62;
    public static final int MAP=74;
    public static final int FEATURECALL=63;
    public static final int FORMAL=24;
    public static final int ARROW=11;
    public static final int EXPRESSIONINBRACKETS=59;
    public static final int ASSIGNMENT=26;
    public static final int STRING=14;

    // delegates
    // delegators
    public EolParser gEol;


        public Eol_EolParserRules(TokenStream input, EolParser gEol) {
            this(input, new RecognizerSharedState(), gEol);
        }
        public Eol_EolParserRules(TokenStream input, RecognizerSharedState state, EolParser gEol) {
            super(input, state);
            this.gEol = gEol;
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return EolParser.tokenNames; }
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
    public final Eol_EolParserRules.operationDeclarationOrAnnotationBlock_return operationDeclarationOrAnnotationBlock() throws RecognitionException {
        Eol_EolParserRules.operationDeclarationOrAnnotationBlock_return retval = new Eol_EolParserRules.operationDeclarationOrAnnotationBlock_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Eol_EolParserRules.operationDeclaration_return operationDeclaration1 = null;

        Eol_EolParserRules.annotationBlock_return annotationBlock2 = null;



        try {
            // EolParserRules.g:106:2: ( operationDeclaration | annotationBlock )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( ((LA1_0>=85 && LA1_0<=86)) ) {
                alt1=1;
            }
            else if ( (LA1_0==Annotation||LA1_0==91) ) {
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
    public final Eol_EolParserRules.modelDeclaration_return modelDeclaration() throws RecognitionException {
        Eol_EolParserRules.modelDeclaration_return retval = new Eol_EolParserRules.modelDeclaration_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token m=null;
        Token sem=null;
        Token NAME3=null;
        Eol_EolParserRules.modelAlias_return modelAlias4 = null;

        Eol_EolParserRules.modelDriver_return modelDriver5 = null;

        Eol_EolParserRules.modelDeclarationParameters_return modelDeclarationParameters6 = null;


        org.eclipse.epsilon.common.parse.AST m_tree=null;
        org.eclipse.epsilon.common.parse.AST sem_tree=null;
        org.eclipse.epsilon.common.parse.AST NAME3_tree=null;

        try {
            // EolParserRules.g:114:2: (m= 'model' NAME ( modelAlias )? ( modelDriver )? ( modelDeclarationParameters )? sem= ';' )
            // EolParserRules.g:114:4: m= 'model' NAME ( modelAlias )? ( modelDriver )? ( modelDeclarationParameters )? sem= ';'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            m=(Token)match(input,77,FOLLOW_77_in_modelDeclaration271); if (state.failed) return retval;
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

            if ( (LA2_0==79) ) {
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

            if ( (LA3_0==81) ) {
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

            if ( (LA4_0==82) ) {
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

            sem=(Token)match(input,78,FOLLOW_78_in_modelDeclaration287); if (state.failed) return retval;

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
    public final Eol_EolParserRules.modelAlias_return modelAlias() throws RecognitionException {
        Eol_EolParserRules.modelAlias_return retval = new Eol_EolParserRules.modelAlias_return();
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

            a=(Token)match(input,79,FOLLOW_79_in_modelAlias302); if (state.failed) return retval;
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

                if ( (LA5_0==80) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // EolParserRules.g:118:22: ',' NAME
            	    {
            	    char_literal8=(Token)match(input,80,FOLLOW_80_in_modelAlias308); if (state.failed) return retval;
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
    public final Eol_EolParserRules.modelDriver_return modelDriver() throws RecognitionException {
        Eol_EolParserRules.modelDriver_return retval = new Eol_EolParserRules.modelDriver_return();
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

            d=(Token)match(input,81,FOLLOW_81_in_modelDriver330); if (state.failed) return retval;
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
    public final Eol_EolParserRules.modelDeclarationParameters_return modelDeclarationParameters() throws RecognitionException {
        Eol_EolParserRules.modelDeclarationParameters_return retval = new Eol_EolParserRules.modelDeclarationParameters_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token s=null;
        Token cb=null;
        Token char_literal12=null;
        Eol_EolParserRules.modelDeclarationParameter_return modelDeclarationParameter11 = null;

        Eol_EolParserRules.modelDeclarationParameter_return modelDeclarationParameter13 = null;


        org.eclipse.epsilon.common.parse.AST s_tree=null;
        org.eclipse.epsilon.common.parse.AST cb_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal12_tree=null;

        try {
            // EolParserRules.g:132:2: (s= '{' ( modelDeclarationParameter )? ( ',' modelDeclarationParameter )* cb= '}' )
            // EolParserRules.g:132:4: s= '{' ( modelDeclarationParameter )? ( ',' modelDeclarationParameter )* cb= '}'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            s=(Token)match(input,82,FOLLOW_82_in_modelDeclarationParameters355); if (state.failed) return retval;
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

                if ( (LA7_0==80) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // EolParserRules.g:132:39: ',' modelDeclarationParameter
            	    {
            	    char_literal12=(Token)match(input,80,FOLLOW_80_in_modelDeclarationParameters362); if (state.failed) return retval;
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

            cb=(Token)match(input,83,FOLLOW_83_in_modelDeclarationParameters371); if (state.failed) return retval;

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
    public final Eol_EolParserRules.modelDeclarationParameter_return modelDeclarationParameter() throws RecognitionException {
        Eol_EolParserRules.modelDeclarationParameter_return retval = new Eol_EolParserRules.modelDeclarationParameter_return();
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
            e=(Token)match(input,84,FOLLOW_84_in_modelDeclarationParameter388); if (state.failed) return retval;
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
    public final Eol_EolParserRules.operationDeclaration_return operationDeclaration() throws RecognitionException {
        Eol_EolParserRules.operationDeclaration_return retval = new Eol_EolParserRules.operationDeclaration_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token operationName=null;
        Token op=null;
        Token cp=null;
        Token set16=null;
        Token char_literal18=null;
        Eol_EolParserRules.typeName_return ctx = null;

        Eol_EolParserRules.typeName_return returnType = null;

        Eol_EolParserRules.formalParameterList_return formalParameterList17 = null;

        Eol_EolParserRules.statementBlock_return statementBlock19 = null;


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
            if ( (input.LA(1)>=85 && input.LA(1)<=86) ) {
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

                if ( (LA8_1==NAME||(LA8_1>=92 && LA8_1<=94)) ) {
                    alt8=1;
                }
            }
            else if ( ((LA8_0>=95 && LA8_0<=102)) ) {
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
            op=(Token)match(input,87,FOLLOW_87_in_operationDeclaration434); if (state.failed) return retval;
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

            cp=(Token)match(input,88,FOLLOW_88_in_operationDeclaration442); if (state.failed) return retval;
            // EolParserRules.g:145:128: ( ':' returnType= typeName )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==89) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // EolParserRules.g:145:129: ':' returnType= typeName
                    {
                    char_literal18=(Token)match(input,89,FOLLOW_89_in_operationDeclaration446); if (state.failed) return retval;
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
    public final Eol_EolParserRules.importStatement_return importStatement() throws RecognitionException {
        Eol_EolParserRules.importStatement_return retval = new Eol_EolParserRules.importStatement_return();
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

            i=(Token)match(input,90,FOLLOW_90_in_importStatement477); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            i_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(i);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(i_tree, root_0);
            }
            STRING20=(Token)match(input,STRING,FOLLOW_STRING_in_importStatement480); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STRING20_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(STRING20);
            adaptor.addChild(root_0, STRING20_tree);
            }
            sem=(Token)match(input,78,FOLLOW_78_in_importStatement484); if (state.failed) return retval;
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
    public final Eol_EolParserRules.block_return block() throws RecognitionException {
        Eol_EolParserRules.block_return retval = new Eol_EolParserRules.block_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Eol_EolParserRules.statement_return statement21 = null;


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

                if ( (LA11_0==FLOAT||LA11_0==INT||LA11_0==BOOLEAN||LA11_0==STRING||LA11_0==NAME||LA11_0==87||(LA11_0>=95 && LA11_0<=102)||LA11_0==105||(LA11_0>=107 && LA11_0<=108)||(LA11_0>=112 && LA11_0<=120)||LA11_0==132||LA11_0==135||(LA11_0>=139 && LA11_0<=141)) ) {
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
    public final Eol_EolParserRules.statementBlock_return statementBlock() throws RecognitionException {
        Eol_EolParserRules.statementBlock_return retval = new Eol_EolParserRules.statementBlock_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token s=null;
        Token e=null;
        Eol_EolParserRules.block_return block22 = null;


        org.eclipse.epsilon.common.parse.AST s_tree=null;
        org.eclipse.epsilon.common.parse.AST e_tree=null;

        try {
            // EolParserRules.g:169:2: (s= '{' block e= '}' )
            // EolParserRules.g:169:4: s= '{' block e= '}'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            s=(Token)match(input,82,FOLLOW_82_in_statementBlock533); if (state.failed) return retval;
            pushFollow(FOLLOW_block_in_statementBlock536);
            block22=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, block22.getTree());
            e=(Token)match(input,83,FOLLOW_83_in_statementBlock540); if (state.failed) return retval;

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
    public final Eol_EolParserRules.formalParameter_return formalParameter() throws RecognitionException {
        Eol_EolParserRules.formalParameter_return retval = new Eol_EolParserRules.formalParameter_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token NAME23=null;
        Token char_literal24=null;
        Eol_EolParserRules.typeName_return pt = null;


        org.eclipse.epsilon.common.parse.AST NAME23_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal24_tree=null;
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_89=new RewriteRuleTokenStream(adaptor,"token 89");
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

            if ( (LA12_0==89) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // EolParserRules.g:176:10: ':' pt= typeName
                    {
                    char_literal24=(Token)match(input,89,FOLLOW_89_in_formalParameter561); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_89.add(char_literal24);

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
    public final Eol_EolParserRules.formalParameterList_return formalParameterList() throws RecognitionException {
        Eol_EolParserRules.formalParameterList_return retval = new Eol_EolParserRules.formalParameterList_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token char_literal26=null;
        Eol_EolParserRules.formalParameter_return formalParameter25 = null;

        Eol_EolParserRules.formalParameter_return formalParameter27 = null;


        org.eclipse.epsilon.common.parse.AST char_literal26_tree=null;
        RewriteRuleTokenStream stream_80=new RewriteRuleTokenStream(adaptor,"token 80");
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

                if ( (LA13_0==80) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // EolParserRules.g:184:21: ',' formalParameter
            	    {
            	    char_literal26=(Token)match(input,80,FOLLOW_80_in_formalParameterList602); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_80.add(char_literal26);

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
    public final Eol_EolParserRules.executableAnnotation_return executableAnnotation() throws RecognitionException {
        Eol_EolParserRules.executableAnnotation_return retval = new Eol_EolParserRules.executableAnnotation_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token d=null;
        Token x=null;
        Eol_EolParserRules.logicalExpression_return logicalExpression28 = null;


        org.eclipse.epsilon.common.parse.AST d_tree=null;
        org.eclipse.epsilon.common.parse.AST x_tree=null;

        try {
            // EolParserRules.g:189:2: (d= '$' x= . logicalExpression )
            // EolParserRules.g:189:4: d= '$' x= . logicalExpression
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            d=(Token)match(input,91,FOLLOW_91_in_executableAnnotation629); if (state.failed) return retval;
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
    public final Eol_EolParserRules.annotation_return annotation() throws RecognitionException {
        Eol_EolParserRules.annotation_return retval = new Eol_EolParserRules.annotation_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token Annotation29=null;
        Eol_EolParserRules.executableAnnotation_return executableAnnotation30 = null;


        org.eclipse.epsilon.common.parse.AST Annotation29_tree=null;

        try {
            // EolParserRules.g:194:2: ( Annotation | executableAnnotation )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==Annotation) ) {
                alt14=1;
            }
            else if ( (LA14_0==91) ) {
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
    public final Eol_EolParserRules.annotationBlock_return annotationBlock() throws RecognitionException {
        Eol_EolParserRules.annotationBlock_return retval = new Eol_EolParserRules.annotationBlock_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Eol_EolParserRules.annotation_return annotation31 = null;


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

                if ( (LA15_0==Annotation||LA15_0==91) ) {
                    alt15=1;
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
    public final Eol_EolParserRules.typeName_return typeName() throws RecognitionException {
        Eol_EolParserRules.typeName_return retval = new Eol_EolParserRules.typeName_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Eol_EolParserRules.pathName_return pathName32 = null;

        Eol_EolParserRules.nativeType_return nativeType33 = null;

        Eol_EolParserRules.collectionType_return collectionType34 = null;



        try {
            // EolParserRules.g:209:2: ( pathName | nativeType | collectionType )
            int alt16=3;
            switch ( input.LA(1) ) {
            case NAME:
                {
                alt16=1;
                }
                break;
            case 95:
                {
                alt16=2;
                }
                break;
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
            case 102:
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
    public final Eol_EolParserRules.pathName_return pathName() throws RecognitionException {
        Eol_EolParserRules.pathName_return retval = new Eol_EolParserRules.pathName_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token metamodel=null;
        Token label=null;
        Token char_literal35=null;
        Token char_literal36=null;
        Eol_EolParserRules.packagedType_return head = null;


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

                if ( (LA17_1==92) ) {
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
                    char_literal35=(Token)match(input,92,FOLLOW_92_in_pathName722); if (state.failed) return retval;

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

            if ( (LA18_0==93) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // EolParserRules.g:215:4: '#' label= NAME
                    {
                    char_literal36=(Token)match(input,93,FOLLOW_93_in_pathName737); if (state.failed) return retval;
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
    public final Eol_EolParserRules.packagedType_return packagedType() throws RecognitionException {
        Eol_EolParserRules.packagedType_return retval = new Eol_EolParserRules.packagedType_return();
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

                if ( (LA19_0==94) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // EolParserRules.g:230:15: '::' field= NAME
            	    {
            	    string_literal37=(Token)match(input,94,FOLLOW_94_in_packagedType766); if (state.failed) return retval;
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
    public final Eol_EolParserRules.nativeType_return nativeType() throws RecognitionException {
        Eol_EolParserRules.nativeType_return retval = new Eol_EolParserRules.nativeType_return();
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

            string_literal38=(Token)match(input,95,FOLLOW_95_in_nativeType799); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal38_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(string_literal38);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(string_literal38_tree, root_0);
            }
            s=(Token)match(input,87,FOLLOW_87_in_nativeType804); if (state.failed) return retval;
            STRING39=(Token)match(input,STRING,FOLLOW_STRING_in_nativeType807); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STRING39_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(STRING39);
            adaptor.addChild(root_0, STRING39_tree);
            }
            e=(Token)match(input,88,FOLLOW_88_in_nativeType811); if (state.failed) return retval;

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
    // EolParserRules.g:247:1: collectionType : ( 'Collection' | 'Sequence' | 'List' | 'Bag' | 'Set' | 'OrderedSet' | 'Map' ) ( (op= '(' tn= typeName ( ',' tn= typeName )* cp= ')' ) | (op= '<' tn= typeName ( ',' tn= typeName )* cp= '>' ) )? ;
    public final Eol_EolParserRules.collectionType_return collectionType() throws RecognitionException {
        Eol_EolParserRules.collectionType_return retval = new Eol_EolParserRules.collectionType_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token op=null;
        Token cp=null;
        Token set40=null;
        Token char_literal41=null;
        Token char_literal42=null;
        Eol_EolParserRules.typeName_return tn = null;


        org.eclipse.epsilon.common.parse.AST op_tree=null;
        org.eclipse.epsilon.common.parse.AST cp_tree=null;
        org.eclipse.epsilon.common.parse.AST set40_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal41_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal42_tree=null;

        try {
            // EolParserRules.g:253:2: ( ( 'Collection' | 'Sequence' | 'List' | 'Bag' | 'Set' | 'OrderedSet' | 'Map' ) ( (op= '(' tn= typeName ( ',' tn= typeName )* cp= ')' ) | (op= '<' tn= typeName ( ',' tn= typeName )* cp= '>' ) )? )
            // EolParserRules.g:253:5: ( 'Collection' | 'Sequence' | 'List' | 'Bag' | 'Set' | 'OrderedSet' | 'Map' ) ( (op= '(' tn= typeName ( ',' tn= typeName )* cp= ')' ) | (op= '<' tn= typeName ( ',' tn= typeName )* cp= '>' ) )?
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            set40=(Token)input.LT(1);
            set40=(Token)input.LT(1);
            if ( (input.LA(1)>=96 && input.LA(1)<=102) ) {
                input.consume();
                if ( state.backtracking==0 ) root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot((org.eclipse.epsilon.common.parse.AST)adaptor.create(set40), root_0);
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            // EolParserRules.g:254:3: ( (op= '(' tn= typeName ( ',' tn= typeName )* cp= ')' ) | (op= '<' tn= typeName ( ',' tn= typeName )* cp= '>' ) )?
            int alt22=3;
            alt22 = dfa22.predict(input);
            switch (alt22) {
                case 1 :
                    // EolParserRules.g:254:4: (op= '(' tn= typeName ( ',' tn= typeName )* cp= ')' )
                    {
                    // EolParserRules.g:254:4: (op= '(' tn= typeName ( ',' tn= typeName )* cp= ')' )
                    // EolParserRules.g:254:5: op= '(' tn= typeName ( ',' tn= typeName )* cp= ')'
                    {
                    op=(Token)match(input,87,FOLLOW_87_in_collectionType852); if (state.failed) return retval;
                    pushFollow(FOLLOW_typeName_in_collectionType857);
                    tn=typeName();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, tn.getTree());
                    if ( state.backtracking==0 ) {
                      setTokenType(tn,TYPE);
                    }
                    // EolParserRules.g:254:50: ( ',' tn= typeName )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==80) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // EolParserRules.g:254:51: ',' tn= typeName
                    	    {
                    	    char_literal41=(Token)match(input,80,FOLLOW_80_in_collectionType862); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal41_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(char_literal41);
                    	    adaptor.addChild(root_0, char_literal41_tree);
                    	    }
                    	    pushFollow(FOLLOW_typeName_in_collectionType866);
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

                    cp=(Token)match(input,88,FOLLOW_88_in_collectionType874); if (state.failed) return retval;

                    }


                    }
                    break;
                case 2 :
                    // EolParserRules.g:255:4: (op= '<' tn= typeName ( ',' tn= typeName )* cp= '>' )
                    {
                    // EolParserRules.g:255:4: (op= '<' tn= typeName ( ',' tn= typeName )* cp= '>' )
                    // EolParserRules.g:255:5: op= '<' tn= typeName ( ',' tn= typeName )* cp= '>'
                    {
                    op=(Token)match(input,103,FOLLOW_103_in_collectionType886); if (state.failed) return retval;
                    pushFollow(FOLLOW_typeName_in_collectionType891);
                    tn=typeName();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, tn.getTree());
                    if ( state.backtracking==0 ) {
                      setTokenType(tn,TYPE);
                    }
                    // EolParserRules.g:255:50: ( ',' tn= typeName )*
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==80) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // EolParserRules.g:255:51: ',' tn= typeName
                    	    {
                    	    char_literal42=(Token)match(input,80,FOLLOW_80_in_collectionType896); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal42_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(char_literal42);
                    	    adaptor.addChild(root_0, char_literal42_tree);
                    	    }
                    	    pushFollow(FOLLOW_typeName_in_collectionType900);
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

                    cp=(Token)match(input,104,FOLLOW_104_in_collectionType908); if (state.failed) return retval;

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
    // EolParserRules.g:259:1: statement : ( statementA | statementB );
    public final Eol_EolParserRules.statement_return statement() throws RecognitionException {
        Eol_EolParserRules.statement_return retval = new Eol_EolParserRules.statement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Eol_EolParserRules.statementA_return statementA43 = null;

        Eol_EolParserRules.statementB_return statementB44 = null;



        try {
            // EolParserRules.g:260:2: ( statementA | statementB )
            int alt23=2;
            alt23 = dfa23.predict(input);
            switch (alt23) {
                case 1 :
                    // EolParserRules.g:260:4: statementA
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_statementA_in_statement927);
                    statementA43=statementA();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statementA43.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:260:17: statementB
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_statementB_in_statement931);
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
    // EolParserRules.g:263:1: statementA : ( assignmentStatement | expressionStatement | forStatement | ifStatement | whileStatement | switchStatement | returnStatement | breakStatement );
    public final Eol_EolParserRules.statementA_return statementA() throws RecognitionException {
        Eol_EolParserRules.statementA_return retval = new Eol_EolParserRules.statementA_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Eol_EolParserRules.assignmentStatement_return assignmentStatement45 = null;

        Eol_EolParserRules.expressionStatement_return expressionStatement46 = null;

        Eol_EolParserRules.forStatement_return forStatement47 = null;

        Eol_EolParserRules.ifStatement_return ifStatement48 = null;

        Eol_EolParserRules.whileStatement_return whileStatement49 = null;

        Eol_EolParserRules.switchStatement_return switchStatement50 = null;

        Eol_EolParserRules.returnStatement_return returnStatement51 = null;

        Eol_EolParserRules.breakStatement_return breakStatement52 = null;



        try {
            // EolParserRules.g:264:2: ( assignmentStatement | expressionStatement | forStatement | ifStatement | whileStatement | switchStatement | returnStatement | breakStatement )
            int alt24=8;
            alt24 = dfa24.predict(input);
            switch (alt24) {
                case 1 :
                    // EolParserRules.g:264:4: assignmentStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_assignmentStatement_in_statementA942);
                    assignmentStatement45=assignmentStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, assignmentStatement45.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:264:26: expressionStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_expressionStatement_in_statementA946);
                    expressionStatement46=expressionStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionStatement46.getTree());

                    }
                    break;
                case 3 :
                    // EolParserRules.g:264:48: forStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_forStatement_in_statementA950);
                    forStatement47=forStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, forStatement47.getTree());

                    }
                    break;
                case 4 :
                    // EolParserRules.g:265:5: ifStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_ifStatement_in_statementA956);
                    ifStatement48=ifStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, ifStatement48.getTree());

                    }
                    break;
                case 5 :
                    // EolParserRules.g:265:19: whileStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_whileStatement_in_statementA960);
                    whileStatement49=whileStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, whileStatement49.getTree());

                    }
                    break;
                case 6 :
                    // EolParserRules.g:265:36: switchStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_switchStatement_in_statementA964);
                    switchStatement50=switchStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, switchStatement50.getTree());

                    }
                    break;
                case 7 :
                    // EolParserRules.g:265:54: returnStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_returnStatement_in_statementA968);
                    returnStatement51=returnStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, returnStatement51.getTree());

                    }
                    break;
                case 8 :
                    // EolParserRules.g:265:72: breakStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_breakStatement_in_statementA972);
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
    // EolParserRules.g:268:1: statementB : ( breakAllStatement | returnStatement | transactionStatement | abortStatement | continueStatement | throwStatement | deleteStatement );
    public final Eol_EolParserRules.statementB_return statementB() throws RecognitionException {
        Eol_EolParserRules.statementB_return retval = new Eol_EolParserRules.statementB_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Eol_EolParserRules.breakAllStatement_return breakAllStatement53 = null;

        Eol_EolParserRules.returnStatement_return returnStatement54 = null;

        Eol_EolParserRules.transactionStatement_return transactionStatement55 = null;

        Eol_EolParserRules.abortStatement_return abortStatement56 = null;

        Eol_EolParserRules.continueStatement_return continueStatement57 = null;

        Eol_EolParserRules.throwStatement_return throwStatement58 = null;

        Eol_EolParserRules.deleteStatement_return deleteStatement59 = null;



        try {
            // EolParserRules.g:269:2: ( breakAllStatement | returnStatement | transactionStatement | abortStatement | continueStatement | throwStatement | deleteStatement )
            int alt25=7;
            switch ( input.LA(1) ) {
            case 117:
                {
                alt25=1;
                }
                break;
            case 113:
                {
                alt25=2;
                }
                break;
            case 120:
                {
                alt25=3;
                }
                break;
            case 119:
                {
                alt25=4;
                }
                break;
            case 118:
                {
                alt25=5;
                }
                break;
            case 114:
                {
                alt25=6;
                }
                break;
            case 115:
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
                    // EolParserRules.g:269:4: breakAllStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_breakAllStatement_in_statementB984);
                    breakAllStatement53=breakAllStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, breakAllStatement53.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:269:24: returnStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_returnStatement_in_statementB988);
                    returnStatement54=returnStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, returnStatement54.getTree());

                    }
                    break;
                case 3 :
                    // EolParserRules.g:269:42: transactionStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_transactionStatement_in_statementB992);
                    transactionStatement55=transactionStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, transactionStatement55.getTree());

                    }
                    break;
                case 4 :
                    // EolParserRules.g:270:5: abortStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_abortStatement_in_statementB998);
                    abortStatement56=abortStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, abortStatement56.getTree());

                    }
                    break;
                case 5 :
                    // EolParserRules.g:270:22: continueStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_continueStatement_in_statementB1002);
                    continueStatement57=continueStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, continueStatement57.getTree());

                    }
                    break;
                case 6 :
                    // EolParserRules.g:270:42: throwStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_throwStatement_in_statementB1006);
                    throwStatement58=throwStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, throwStatement58.getTree());

                    }
                    break;
                case 7 :
                    // EolParserRules.g:271:5: deleteStatement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_deleteStatement_in_statementB1012);
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
    // EolParserRules.g:274:1: statementOrStatementBlock : ( statement | statementBlock );
    public final Eol_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock() throws RecognitionException {
        Eol_EolParserRules.statementOrStatementBlock_return retval = new Eol_EolParserRules.statementOrStatementBlock_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Eol_EolParserRules.statement_return statement60 = null;

        Eol_EolParserRules.statementBlock_return statementBlock61 = null;



        try {
            // EolParserRules.g:275:2: ( statement | statementBlock )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==FLOAT||LA26_0==INT||LA26_0==BOOLEAN||LA26_0==STRING||LA26_0==NAME||LA26_0==87||(LA26_0>=95 && LA26_0<=102)||LA26_0==105||(LA26_0>=107 && LA26_0<=108)||(LA26_0>=112 && LA26_0<=120)||LA26_0==132||LA26_0==135||(LA26_0>=139 && LA26_0<=141)) ) {
                alt26=1;
            }
            else if ( (LA26_0==82) ) {
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
                    // EolParserRules.g:275:4: statement
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_statement_in_statementOrStatementBlock1023);
                    statement60=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement60.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:275:16: statementBlock
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_statementBlock_in_statementOrStatementBlock1027);
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
    // EolParserRules.g:277:1: expressionOrStatementBlock : ( ':' logicalExpression | statementBlock );
    public final Eol_EolParserRules.expressionOrStatementBlock_return expressionOrStatementBlock() throws RecognitionException {
        Eol_EolParserRules.expressionOrStatementBlock_return retval = new Eol_EolParserRules.expressionOrStatementBlock_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token char_literal62=null;
        Eol_EolParserRules.logicalExpression_return logicalExpression63 = null;

        Eol_EolParserRules.statementBlock_return statementBlock64 = null;


        org.eclipse.epsilon.common.parse.AST char_literal62_tree=null;

        try {
            // EolParserRules.g:278:2: ( ':' logicalExpression | statementBlock )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==89) ) {
                alt27=1;
            }
            else if ( (LA27_0==82) ) {
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
                    // EolParserRules.g:278:4: ':' logicalExpression
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    char_literal62=(Token)match(input,89,FOLLOW_89_in_expressionOrStatementBlock1036); if (state.failed) return retval;
                    pushFollow(FOLLOW_logicalExpression_in_expressionOrStatementBlock1039);
                    logicalExpression63=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression63.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:278:29: statementBlock
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_statementBlock_in_expressionOrStatementBlock1043);
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

    public static class forStatement_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start forStatement
    // EolParserRules.g:281:1: forStatement : f= 'for' '(' formalParameter 'in' logicalExpression ')' statementOrStatementBlock ;
    public final Eol_EolParserRules.forStatement_return forStatement() throws RecognitionException {
        Eol_EolParserRules.forStatement_return retval = new Eol_EolParserRules.forStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token f=null;
        Token char_literal65=null;
        Token string_literal67=null;
        Token char_literal69=null;
        Eol_EolParserRules.formalParameter_return formalParameter66 = null;

        Eol_EolParserRules.logicalExpression_return logicalExpression68 = null;

        Eol_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock70 = null;


        org.eclipse.epsilon.common.parse.AST f_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal65_tree=null;
        org.eclipse.epsilon.common.parse.AST string_literal67_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal69_tree=null;

        try {
            // EolParserRules.g:282:2: (f= 'for' '(' formalParameter 'in' logicalExpression ')' statementOrStatementBlock )
            // EolParserRules.g:282:4: f= 'for' '(' formalParameter 'in' logicalExpression ')' statementOrStatementBlock
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            f=(Token)match(input,105,FOLLOW_105_in_forStatement1056); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            f_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(f);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(f_tree, root_0);
            }
            char_literal65=(Token)match(input,87,FOLLOW_87_in_forStatement1059); if (state.failed) return retval;
            pushFollow(FOLLOW_formalParameter_in_forStatement1062);
            formalParameter66=formalParameter();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, formalParameter66.getTree());
            string_literal67=(Token)match(input,106,FOLLOW_106_in_forStatement1064); if (state.failed) return retval;
            pushFollow(FOLLOW_logicalExpression_in_forStatement1067);
            logicalExpression68=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression68.getTree());
            char_literal69=(Token)match(input,88,FOLLOW_88_in_forStatement1069); if (state.failed) return retval;
            pushFollow(FOLLOW_statementOrStatementBlock_in_forStatement1072);
            statementOrStatementBlock70=statementOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, statementOrStatementBlock70.getTree());
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
    // EolParserRules.g:286:1: ifStatement : i= 'if' '(' logicalExpression ')' statementOrStatementBlock ( elseStatement )? ;
    public final Eol_EolParserRules.ifStatement_return ifStatement() throws RecognitionException {
        Eol_EolParserRules.ifStatement_return retval = new Eol_EolParserRules.ifStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token i=null;
        Token char_literal71=null;
        Token char_literal73=null;
        Eol_EolParserRules.logicalExpression_return logicalExpression72 = null;

        Eol_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock74 = null;

        Eol_EolParserRules.elseStatement_return elseStatement75 = null;


        org.eclipse.epsilon.common.parse.AST i_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal71_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal73_tree=null;

        try {
            // EolParserRules.g:287:2: (i= 'if' '(' logicalExpression ')' statementOrStatementBlock ( elseStatement )? )
            // EolParserRules.g:287:4: i= 'if' '(' logicalExpression ')' statementOrStatementBlock ( elseStatement )?
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            i=(Token)match(input,107,FOLLOW_107_in_ifStatement1088); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            i_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(i);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(i_tree, root_0);
            }
            char_literal71=(Token)match(input,87,FOLLOW_87_in_ifStatement1091); if (state.failed) return retval;
            pushFollow(FOLLOW_logicalExpression_in_ifStatement1094);
            logicalExpression72=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression72.getTree());
            char_literal73=(Token)match(input,88,FOLLOW_88_in_ifStatement1096); if (state.failed) return retval;
            pushFollow(FOLLOW_statementOrStatementBlock_in_ifStatement1099);
            statementOrStatementBlock74=statementOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, statementOrStatementBlock74.getTree());
            // EolParserRules.g:287:66: ( elseStatement )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==111) ) {
                int LA28_1 = input.LA(2);

                if ( (synpred48_EolParserRules()) ) {
                    alt28=1;
                }
            }
            switch (alt28) {
                case 1 :
                    // EolParserRules.g:0:0: elseStatement
                    {
                    pushFollow(FOLLOW_elseStatement_in_ifStatement1101);
                    elseStatement75=elseStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, elseStatement75.getTree());

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
    // EolParserRules.g:291:1: switchStatement : s= 'switch' '(' logicalExpression ')' '{' ( caseStatement )* ( defaultStatement )? '}' ;
    public final Eol_EolParserRules.switchStatement_return switchStatement() throws RecognitionException {
        Eol_EolParserRules.switchStatement_return retval = new Eol_EolParserRules.switchStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token s=null;
        Token char_literal76=null;
        Token char_literal78=null;
        Token char_literal79=null;
        Token char_literal82=null;
        Eol_EolParserRules.logicalExpression_return logicalExpression77 = null;

        Eol_EolParserRules.caseStatement_return caseStatement80 = null;

        Eol_EolParserRules.defaultStatement_return defaultStatement81 = null;


        org.eclipse.epsilon.common.parse.AST s_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal76_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal78_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal79_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal82_tree=null;

        try {
            // EolParserRules.g:292:2: (s= 'switch' '(' logicalExpression ')' '{' ( caseStatement )* ( defaultStatement )? '}' )
            // EolParserRules.g:292:4: s= 'switch' '(' logicalExpression ')' '{' ( caseStatement )* ( defaultStatement )? '}'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            s=(Token)match(input,108,FOLLOW_108_in_switchStatement1120); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            s_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(s);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(s_tree, root_0);
            }
            char_literal76=(Token)match(input,87,FOLLOW_87_in_switchStatement1123); if (state.failed) return retval;
            pushFollow(FOLLOW_logicalExpression_in_switchStatement1126);
            logicalExpression77=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression77.getTree());
            char_literal78=(Token)match(input,88,FOLLOW_88_in_switchStatement1128); if (state.failed) return retval;
            char_literal79=(Token)match(input,82,FOLLOW_82_in_switchStatement1131); if (state.failed) return retval;
            // EolParserRules.g:292:49: ( caseStatement )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==109) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // EolParserRules.g:0:0: caseStatement
            	    {
            	    pushFollow(FOLLOW_caseStatement_in_switchStatement1134);
            	    caseStatement80=caseStatement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, caseStatement80.getTree());

            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

            // EolParserRules.g:292:64: ( defaultStatement )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==110) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // EolParserRules.g:0:0: defaultStatement
                    {
                    pushFollow(FOLLOW_defaultStatement_in_switchStatement1137);
                    defaultStatement81=defaultStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, defaultStatement81.getTree());

                    }
                    break;

            }

            char_literal82=(Token)match(input,83,FOLLOW_83_in_switchStatement1140); if (state.failed) return retval;
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
    // EolParserRules.g:296:1: caseStatement : c= 'case' logicalExpression ':' ( block | statementBlock ) ;
    public final Eol_EolParserRules.caseStatement_return caseStatement() throws RecognitionException {
        Eol_EolParserRules.caseStatement_return retval = new Eol_EolParserRules.caseStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token c=null;
        Token char_literal84=null;
        Eol_EolParserRules.logicalExpression_return logicalExpression83 = null;

        Eol_EolParserRules.block_return block85 = null;

        Eol_EolParserRules.statementBlock_return statementBlock86 = null;


        org.eclipse.epsilon.common.parse.AST c_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal84_tree=null;

        try {
            // EolParserRules.g:297:2: (c= 'case' logicalExpression ':' ( block | statementBlock ) )
            // EolParserRules.g:297:4: c= 'case' logicalExpression ':' ( block | statementBlock )
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            c=(Token)match(input,109,FOLLOW_109_in_caseStatement1159); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            c_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(c);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(c_tree, root_0);
            }
            pushFollow(FOLLOW_logicalExpression_in_caseStatement1162);
            logicalExpression83=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression83.getTree());
            char_literal84=(Token)match(input,89,FOLLOW_89_in_caseStatement1164); if (state.failed) return retval;
            // EolParserRules.g:297:37: ( block | statementBlock )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==EOF||LA31_0==FLOAT||LA31_0==INT||LA31_0==BOOLEAN||LA31_0==STRING||LA31_0==NAME||LA31_0==Annotation||LA31_0==83||(LA31_0>=85 && LA31_0<=87)||LA31_0==91||(LA31_0>=95 && LA31_0<=102)||LA31_0==105||(LA31_0>=107 && LA31_0<=110)||(LA31_0>=112 && LA31_0<=120)||LA31_0==132||LA31_0==135||(LA31_0>=139 && LA31_0<=141)) ) {
                alt31=1;
            }
            else if ( (LA31_0==82) ) {
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
                    // EolParserRules.g:297:38: block
                    {
                    pushFollow(FOLLOW_block_in_caseStatement1168);
                    block85=block();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, block85.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:297:46: statementBlock
                    {
                    pushFollow(FOLLOW_statementBlock_in_caseStatement1172);
                    statementBlock86=statementBlock();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statementBlock86.getTree());

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
    // EolParserRules.g:301:1: defaultStatement : d= 'default' ':' ( block | statementBlock ) ;
    public final Eol_EolParserRules.defaultStatement_return defaultStatement() throws RecognitionException {
        Eol_EolParserRules.defaultStatement_return retval = new Eol_EolParserRules.defaultStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token d=null;
        Token char_literal87=null;
        Eol_EolParserRules.block_return block88 = null;

        Eol_EolParserRules.statementBlock_return statementBlock89 = null;


        org.eclipse.epsilon.common.parse.AST d_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal87_tree=null;

        try {
            // EolParserRules.g:302:2: (d= 'default' ':' ( block | statementBlock ) )
            // EolParserRules.g:302:4: d= 'default' ':' ( block | statementBlock )
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            d=(Token)match(input,110,FOLLOW_110_in_defaultStatement1191); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            d_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(d);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(d_tree, root_0);
            }
            char_literal87=(Token)match(input,89,FOLLOW_89_in_defaultStatement1194); if (state.failed) return retval;
            // EolParserRules.g:302:22: ( block | statementBlock )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==EOF||LA32_0==FLOAT||LA32_0==INT||LA32_0==BOOLEAN||LA32_0==STRING||LA32_0==NAME||LA32_0==Annotation||LA32_0==83||(LA32_0>=85 && LA32_0<=87)||LA32_0==91||(LA32_0>=95 && LA32_0<=102)||LA32_0==105||(LA32_0>=107 && LA32_0<=110)||(LA32_0>=112 && LA32_0<=120)||LA32_0==132||LA32_0==135||(LA32_0>=139 && LA32_0<=141)) ) {
                alt32=1;
            }
            else if ( (LA32_0==82) ) {
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
                    // EolParserRules.g:302:23: block
                    {
                    pushFollow(FOLLOW_block_in_defaultStatement1198);
                    block88=block();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, block88.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:302:31: statementBlock
                    {
                    pushFollow(FOLLOW_statementBlock_in_defaultStatement1202);
                    statementBlock89=statementBlock();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statementBlock89.getTree());

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
    // EolParserRules.g:306:1: elseStatement : e= 'else' statementOrStatementBlock ;
    public final Eol_EolParserRules.elseStatement_return elseStatement() throws RecognitionException {
        Eol_EolParserRules.elseStatement_return retval = new Eol_EolParserRules.elseStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token e=null;
        Eol_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock90 = null;


        org.eclipse.epsilon.common.parse.AST e_tree=null;

        try {
            // EolParserRules.g:310:2: (e= 'else' statementOrStatementBlock )
            // EolParserRules.g:310:4: e= 'else' statementOrStatementBlock
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            e=(Token)match(input,111,FOLLOW_111_in_elseStatement1227); if (state.failed) return retval;
            pushFollow(FOLLOW_statementOrStatementBlock_in_elseStatement1230);
            statementOrStatementBlock90=statementOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, statementOrStatementBlock90.getTree());

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
    // EolParserRules.g:313:1: whileStatement : w= 'while' '(' logicalExpression ')' statementOrStatementBlock ;
    public final Eol_EolParserRules.whileStatement_return whileStatement() throws RecognitionException {
        Eol_EolParserRules.whileStatement_return retval = new Eol_EolParserRules.whileStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token w=null;
        Token char_literal91=null;
        Token char_literal93=null;
        Eol_EolParserRules.logicalExpression_return logicalExpression92 = null;

        Eol_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock94 = null;


        org.eclipse.epsilon.common.parse.AST w_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal91_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal93_tree=null;

        try {
            // EolParserRules.g:314:2: (w= 'while' '(' logicalExpression ')' statementOrStatementBlock )
            // EolParserRules.g:314:4: w= 'while' '(' logicalExpression ')' statementOrStatementBlock
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            w=(Token)match(input,112,FOLLOW_112_in_whileStatement1243); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            w_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(w);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(w_tree, root_0);
            }
            char_literal91=(Token)match(input,87,FOLLOW_87_in_whileStatement1246); if (state.failed) return retval;
            pushFollow(FOLLOW_logicalExpression_in_whileStatement1249);
            logicalExpression92=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression92.getTree());
            char_literal93=(Token)match(input,88,FOLLOW_88_in_whileStatement1251); if (state.failed) return retval;
            pushFollow(FOLLOW_statementOrStatementBlock_in_whileStatement1254);
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
    // EolParserRules.g:318:1: returnStatement : r= 'return' ( logicalExpression )? sem= ';' ;
    public final Eol_EolParserRules.returnStatement_return returnStatement() throws RecognitionException {
        Eol_EolParserRules.returnStatement_return retval = new Eol_EolParserRules.returnStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token r=null;
        Token sem=null;
        Eol_EolParserRules.logicalExpression_return logicalExpression95 = null;


        org.eclipse.epsilon.common.parse.AST r_tree=null;
        org.eclipse.epsilon.common.parse.AST sem_tree=null;

        try {
            // EolParserRules.g:322:2: (r= 'return' ( logicalExpression )? sem= ';' )
            // EolParserRules.g:322:4: r= 'return' ( logicalExpression )? sem= ';'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            r=(Token)match(input,113,FOLLOW_113_in_returnStatement1276); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            r_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(r);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(r_tree, root_0);
            }
            // EolParserRules.g:322:16: ( logicalExpression )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==FLOAT||LA33_0==INT||LA33_0==BOOLEAN||LA33_0==STRING||LA33_0==NAME||LA33_0==87||(LA33_0>=95 && LA33_0<=102)||LA33_0==132||LA33_0==135||(LA33_0>=139 && LA33_0<=141)) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // EolParserRules.g:0:0: logicalExpression
                    {
                    pushFollow(FOLLOW_logicalExpression_in_returnStatement1279);
                    logicalExpression95=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression95.getTree());

                    }
                    break;

            }

            sem=(Token)match(input,78,FOLLOW_78_in_returnStatement1284); if (state.failed) return retval;
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
    // EolParserRules.g:326:1: throwStatement : t= 'throw' ( logicalExpression )? sem= ';' ;
    public final Eol_EolParserRules.throwStatement_return throwStatement() throws RecognitionException {
        Eol_EolParserRules.throwStatement_return retval = new Eol_EolParserRules.throwStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token t=null;
        Token sem=null;
        Eol_EolParserRules.logicalExpression_return logicalExpression96 = null;


        org.eclipse.epsilon.common.parse.AST t_tree=null;
        org.eclipse.epsilon.common.parse.AST sem_tree=null;

        try {
            // EolParserRules.g:330:2: (t= 'throw' ( logicalExpression )? sem= ';' )
            // EolParserRules.g:330:4: t= 'throw' ( logicalExpression )? sem= ';'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            t=(Token)match(input,114,FOLLOW_114_in_throwStatement1307); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            t_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(t);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(t_tree, root_0);
            }
            // EolParserRules.g:330:15: ( logicalExpression )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==FLOAT||LA34_0==INT||LA34_0==BOOLEAN||LA34_0==STRING||LA34_0==NAME||LA34_0==87||(LA34_0>=95 && LA34_0<=102)||LA34_0==132||LA34_0==135||(LA34_0>=139 && LA34_0<=141)) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // EolParserRules.g:0:0: logicalExpression
                    {
                    pushFollow(FOLLOW_logicalExpression_in_throwStatement1310);
                    logicalExpression96=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression96.getTree());

                    }
                    break;

            }

            sem=(Token)match(input,78,FOLLOW_78_in_throwStatement1315); if (state.failed) return retval;
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
    // EolParserRules.g:334:1: deleteStatement : d= 'delete' ( logicalExpression )? sem= ';' ;
    public final Eol_EolParserRules.deleteStatement_return deleteStatement() throws RecognitionException {
        Eol_EolParserRules.deleteStatement_return retval = new Eol_EolParserRules.deleteStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token d=null;
        Token sem=null;
        Eol_EolParserRules.logicalExpression_return logicalExpression97 = null;


        org.eclipse.epsilon.common.parse.AST d_tree=null;
        org.eclipse.epsilon.common.parse.AST sem_tree=null;

        try {
            // EolParserRules.g:338:2: (d= 'delete' ( logicalExpression )? sem= ';' )
            // EolParserRules.g:338:4: d= 'delete' ( logicalExpression )? sem= ';'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            d=(Token)match(input,115,FOLLOW_115_in_deleteStatement1338); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            d_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(d);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(d_tree, root_0);
            }
            // EolParserRules.g:338:16: ( logicalExpression )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==FLOAT||LA35_0==INT||LA35_0==BOOLEAN||LA35_0==STRING||LA35_0==NAME||LA35_0==87||(LA35_0>=95 && LA35_0<=102)||LA35_0==132||LA35_0==135||(LA35_0>=139 && LA35_0<=141)) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // EolParserRules.g:0:0: logicalExpression
                    {
                    pushFollow(FOLLOW_logicalExpression_in_deleteStatement1341);
                    logicalExpression97=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression97.getTree());

                    }
                    break;

            }

            sem=(Token)match(input,78,FOLLOW_78_in_deleteStatement1346); if (state.failed) return retval;
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
    // EolParserRules.g:342:1: breakStatement : b= 'break' sem= ';' ;
    public final Eol_EolParserRules.breakStatement_return breakStatement() throws RecognitionException {
        Eol_EolParserRules.breakStatement_return retval = new Eol_EolParserRules.breakStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token b=null;
        Token sem=null;

        org.eclipse.epsilon.common.parse.AST b_tree=null;
        org.eclipse.epsilon.common.parse.AST sem_tree=null;

        try {
            // EolParserRules.g:346:2: (b= 'break' sem= ';' )
            // EolParserRules.g:346:4: b= 'break' sem= ';'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            b=(Token)match(input,116,FOLLOW_116_in_breakStatement1372); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            b_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(b);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(b_tree, root_0);
            }
            sem=(Token)match(input,78,FOLLOW_78_in_breakStatement1377); if (state.failed) return retval;
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
    // EolParserRules.g:350:1: breakAllStatement : b= 'breakAll' sem= ';' ;
    public final Eol_EolParserRules.breakAllStatement_return breakAllStatement() throws RecognitionException {
        Eol_EolParserRules.breakAllStatement_return retval = new Eol_EolParserRules.breakAllStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token b=null;
        Token sem=null;

        org.eclipse.epsilon.common.parse.AST b_tree=null;
        org.eclipse.epsilon.common.parse.AST sem_tree=null;

        try {
            // EolParserRules.g:354:2: (b= 'breakAll' sem= ';' )
            // EolParserRules.g:354:4: b= 'breakAll' sem= ';'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            b=(Token)match(input,117,FOLLOW_117_in_breakAllStatement1400); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            b_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(b);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(b_tree, root_0);
            }
            sem=(Token)match(input,78,FOLLOW_78_in_breakAllStatement1405); if (state.failed) return retval;
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
    // EolParserRules.g:358:1: continueStatement : c= 'continue' sem= ';' ;
    public final Eol_EolParserRules.continueStatement_return continueStatement() throws RecognitionException {
        Eol_EolParserRules.continueStatement_return retval = new Eol_EolParserRules.continueStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token c=null;
        Token sem=null;

        org.eclipse.epsilon.common.parse.AST c_tree=null;
        org.eclipse.epsilon.common.parse.AST sem_tree=null;

        try {
            // EolParserRules.g:362:2: (c= 'continue' sem= ';' )
            // EolParserRules.g:362:4: c= 'continue' sem= ';'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            c=(Token)match(input,118,FOLLOW_118_in_continueStatement1428); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            c_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(c);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(c_tree, root_0);
            }
            sem=(Token)match(input,78,FOLLOW_78_in_continueStatement1433); if (state.failed) return retval;
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
    // EolParserRules.g:366:1: abortStatement : a= 'abort' sem= ';' ;
    public final Eol_EolParserRules.abortStatement_return abortStatement() throws RecognitionException {
        Eol_EolParserRules.abortStatement_return retval = new Eol_EolParserRules.abortStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token a=null;
        Token sem=null;

        org.eclipse.epsilon.common.parse.AST a_tree=null;
        org.eclipse.epsilon.common.parse.AST sem_tree=null;

        try {
            // EolParserRules.g:370:2: (a= 'abort' sem= ';' )
            // EolParserRules.g:370:4: a= 'abort' sem= ';'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            a=(Token)match(input,119,FOLLOW_119_in_abortStatement1456); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            a_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(a);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(a_tree, root_0);
            }
            sem=(Token)match(input,78,FOLLOW_78_in_abortStatement1461); if (state.failed) return retval;
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
    // EolParserRules.g:374:1: transactionStatement : t= 'transaction' ( NAME ( ',' NAME )* )? statementOrStatementBlock ;
    public final Eol_EolParserRules.transactionStatement_return transactionStatement() throws RecognitionException {
        Eol_EolParserRules.transactionStatement_return retval = new Eol_EolParserRules.transactionStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token t=null;
        Token NAME98=null;
        Token char_literal99=null;
        Token NAME100=null;
        Eol_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock101 = null;


        org.eclipse.epsilon.common.parse.AST t_tree=null;
        org.eclipse.epsilon.common.parse.AST NAME98_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal99_tree=null;
        org.eclipse.epsilon.common.parse.AST NAME100_tree=null;

        try {
            // EolParserRules.g:375:2: (t= 'transaction' ( NAME ( ',' NAME )* )? statementOrStatementBlock )
            // EolParserRules.g:375:4: t= 'transaction' ( NAME ( ',' NAME )* )? statementOrStatementBlock
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            t=(Token)match(input,120,FOLLOW_120_in_transactionStatement1478); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            t_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(t);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(t_tree, root_0);
            }
            // EolParserRules.g:375:21: ( NAME ( ',' NAME )* )?
            int alt37=2;
            alt37 = dfa37.predict(input);
            switch (alt37) {
                case 1 :
                    // EolParserRules.g:375:22: NAME ( ',' NAME )*
                    {
                    NAME98=(Token)match(input,NAME,FOLLOW_NAME_in_transactionStatement1482); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NAME98_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(NAME98);
                    adaptor.addChild(root_0, NAME98_tree);
                    }
                    // EolParserRules.g:375:27: ( ',' NAME )*
                    loop36:
                    do {
                        int alt36=2;
                        int LA36_0 = input.LA(1);

                        if ( (LA36_0==80) ) {
                            alt36=1;
                        }


                        switch (alt36) {
                    	case 1 :
                    	    // EolParserRules.g:375:28: ',' NAME
                    	    {
                    	    char_literal99=(Token)match(input,80,FOLLOW_80_in_transactionStatement1485); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal99_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(char_literal99);
                    	    adaptor.addChild(root_0, char_literal99_tree);
                    	    }
                    	    NAME100=(Token)match(input,NAME,FOLLOW_NAME_in_transactionStatement1487); if (state.failed) return retval;
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

            pushFollow(FOLLOW_statementOrStatementBlock_in_transactionStatement1493);
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
    // EolParserRules.g:379:1: assignmentStatement : logicalExpression (normal= ':=' | special= '::=' ) logicalExpression sem= ';' ;
    public final Eol_EolParserRules.assignmentStatement_return assignmentStatement() throws RecognitionException {
        Eol_EolParserRules.assignmentStatement_return retval = new Eol_EolParserRules.assignmentStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token normal=null;
        Token special=null;
        Token sem=null;
        Eol_EolParserRules.logicalExpression_return logicalExpression102 = null;

        Eol_EolParserRules.logicalExpression_return logicalExpression103 = null;


        org.eclipse.epsilon.common.parse.AST normal_tree=null;
        org.eclipse.epsilon.common.parse.AST special_tree=null;
        org.eclipse.epsilon.common.parse.AST sem_tree=null;

        try {
            // EolParserRules.g:383:2: ( logicalExpression (normal= ':=' | special= '::=' ) logicalExpression sem= ';' )
            // EolParserRules.g:383:4: logicalExpression (normal= ':=' | special= '::=' ) logicalExpression sem= ';'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            pushFollow(FOLLOW_logicalExpression_in_assignmentStatement1513);
            logicalExpression102=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression102.getTree());
            // EolParserRules.g:383:22: (normal= ':=' | special= '::=' )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==121) ) {
                alt38=1;
            }
            else if ( (LA38_0==122) ) {
                alt38=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // EolParserRules.g:383:23: normal= ':='
                    {
                    normal=(Token)match(input,121,FOLLOW_121_in_assignmentStatement1518); if (state.failed) return retval;
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
                    // EolParserRules.g:383:66: special= '::='
                    {
                    special=(Token)match(input,122,FOLLOW_122_in_assignmentStatement1525); if (state.failed) return retval;
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

            pushFollow(FOLLOW_logicalExpression_in_assignmentStatement1531);
            logicalExpression103=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression103.getTree());
            sem=(Token)match(input,78,FOLLOW_78_in_assignmentStatement1535); if (state.failed) return retval;

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
    // EolParserRules.g:387:1: expressionStatement : ( postfixExpression op= '=' logicalExpression | logicalExpression ) sem= ';' ;
    public final Eol_EolParserRules.expressionStatement_return expressionStatement() throws RecognitionException {
        Eol_EolParserRules.expressionStatement_return retval = new Eol_EolParserRules.expressionStatement_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token op=null;
        Token sem=null;
        Eol_EolParserRules.postfixExpression_return postfixExpression104 = null;

        Eol_EolParserRules.logicalExpression_return logicalExpression105 = null;

        Eol_EolParserRules.logicalExpression_return logicalExpression106 = null;


        org.eclipse.epsilon.common.parse.AST op_tree=null;
        org.eclipse.epsilon.common.parse.AST sem_tree=null;

        try {
            // EolParserRules.g:391:2: ( ( postfixExpression op= '=' logicalExpression | logicalExpression ) sem= ';' )
            // EolParserRules.g:391:4: ( postfixExpression op= '=' logicalExpression | logicalExpression ) sem= ';'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            // EolParserRules.g:391:4: ( postfixExpression op= '=' logicalExpression | logicalExpression )
            int alt39=2;
            alt39 = dfa39.predict(input);
            switch (alt39) {
                case 1 :
                    // EolParserRules.g:391:5: postfixExpression op= '=' logicalExpression
                    {
                    pushFollow(FOLLOW_postfixExpression_in_expressionStatement1557);
                    postfixExpression104=postfixExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, postfixExpression104.getTree());
                    op=(Token)match(input,84,FOLLOW_84_in_expressionStatement1561); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
                    }
                    pushFollow(FOLLOW_logicalExpression_in_expressionStatement1564);
                    logicalExpression105=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression105.getTree());
                    if ( state.backtracking==0 ) {
                      op.setType(OPERATOR);
                    }

                    }
                    break;
                case 2 :
                    // EolParserRules.g:391:76: logicalExpression
                    {
                    pushFollow(FOLLOW_logicalExpression_in_expressionStatement1570);
                    logicalExpression106=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression106.getTree());

                    }
                    break;

            }

            sem=(Token)match(input,78,FOLLOW_78_in_expressionStatement1575); if (state.failed) return retval;

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
    // EolParserRules.g:394:1: logicalExpression : relationalExpression ( (op= 'or' | op= 'and' | op= 'xor' | op= 'implies' ) relationalExpression )* ;
    public final Eol_EolParserRules.logicalExpression_return logicalExpression() throws RecognitionException {
        Eol_EolParserRules.logicalExpression_return retval = new Eol_EolParserRules.logicalExpression_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token op=null;
        Eol_EolParserRules.relationalExpression_return relationalExpression107 = null;

        Eol_EolParserRules.relationalExpression_return relationalExpression108 = null;


        org.eclipse.epsilon.common.parse.AST op_tree=null;

        try {
            // EolParserRules.g:395:2: ( relationalExpression ( (op= 'or' | op= 'and' | op= 'xor' | op= 'implies' ) relationalExpression )* )
            // EolParserRules.g:395:4: relationalExpression ( (op= 'or' | op= 'and' | op= 'xor' | op= 'implies' ) relationalExpression )*
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            pushFollow(FOLLOW_relationalExpression_in_logicalExpression1587);
            relationalExpression107=relationalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, relationalExpression107.getTree());
            // EolParserRules.g:395:25: ( (op= 'or' | op= 'and' | op= 'xor' | op= 'implies' ) relationalExpression )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( ((LA41_0>=123 && LA41_0<=126)) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // EolParserRules.g:395:26: (op= 'or' | op= 'and' | op= 'xor' | op= 'implies' ) relationalExpression
            	    {
            	    // EolParserRules.g:395:26: (op= 'or' | op= 'and' | op= 'xor' | op= 'implies' )
            	    int alt40=4;
            	    switch ( input.LA(1) ) {
            	    case 123:
            	        {
            	        alt40=1;
            	        }
            	        break;
            	    case 124:
            	        {
            	        alt40=2;
            	        }
            	        break;
            	    case 125:
            	        {
            	        alt40=3;
            	        }
            	        break;
            	    case 126:
            	        {
            	        alt40=4;
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
            	            // EolParserRules.g:395:27: op= 'or'
            	            {
            	            op=(Token)match(input,123,FOLLOW_123_in_logicalExpression1593); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // EolParserRules.g:395:36: op= 'and'
            	            {
            	            op=(Token)match(input,124,FOLLOW_124_in_logicalExpression1598); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // EolParserRules.g:395:46: op= 'xor'
            	            {
            	            op=(Token)match(input,125,FOLLOW_125_in_logicalExpression1603); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 4 :
            	            // EolParserRules.g:395:56: op= 'implies'
            	            {
            	            op=(Token)match(input,126,FOLLOW_126_in_logicalExpression1608); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_relationalExpression_in_logicalExpression1612);
            	    relationalExpression108=relationalExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, relationalExpression108.getTree());
            	    if ( state.backtracking==0 ) {
            	      op.setType(OPERATOR);
            	    }

            	    }
            	    break;

            	default :
            	    break loop41;
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
    // EolParserRules.g:399:1: relationalExpression : additiveExpression ( (op= '==' relationalExpression | op= '=' relationalExpression | (op= '>' | op= '<' | op= '>=' | op= '<=' | op= '<>' ) additiveExpression ) )* ;
    public final Eol_EolParserRules.relationalExpression_return relationalExpression() throws RecognitionException {
        Eol_EolParserRules.relationalExpression_return retval = new Eol_EolParserRules.relationalExpression_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token op=null;
        Eol_EolParserRules.additiveExpression_return additiveExpression109 = null;

        Eol_EolParserRules.relationalExpression_return relationalExpression110 = null;

        Eol_EolParserRules.relationalExpression_return relationalExpression111 = null;

        Eol_EolParserRules.additiveExpression_return additiveExpression112 = null;


        org.eclipse.epsilon.common.parse.AST op_tree=null;

        try {
            // EolParserRules.g:400:2: ( additiveExpression ( (op= '==' relationalExpression | op= '=' relationalExpression | (op= '>' | op= '<' | op= '>=' | op= '<=' | op= '<>' ) additiveExpression ) )* )
            // EolParserRules.g:400:4: additiveExpression ( (op= '==' relationalExpression | op= '=' relationalExpression | (op= '>' | op= '<' | op= '>=' | op= '<=' | op= '<>' ) additiveExpression ) )*
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            pushFollow(FOLLOW_additiveExpression_in_relationalExpression1629);
            additiveExpression109=additiveExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, additiveExpression109.getTree());
            // EolParserRules.g:400:23: ( (op= '==' relationalExpression | op= '=' relationalExpression | (op= '>' | op= '<' | op= '>=' | op= '<=' | op= '<>' ) additiveExpression ) )*
            loop44:
            do {
                int alt44=2;
                alt44 = dfa44.predict(input);
                switch (alt44) {
            	case 1 :
            	    // EolParserRules.g:400:24: (op= '==' relationalExpression | op= '=' relationalExpression | (op= '>' | op= '<' | op= '>=' | op= '<=' | op= '<>' ) additiveExpression )
            	    {
            	    // EolParserRules.g:400:24: (op= '==' relationalExpression | op= '=' relationalExpression | (op= '>' | op= '<' | op= '>=' | op= '<=' | op= '<>' ) additiveExpression )
            	    int alt43=3;
            	    switch ( input.LA(1) ) {
            	    case 127:
            	        {
            	        alt43=1;
            	        }
            	        break;
            	    case 84:
            	        {
            	        alt43=2;
            	        }
            	        break;
            	    case 103:
            	    case 104:
            	    case 128:
            	    case 129:
            	    case 130:
            	        {
            	        alt43=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 43, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt43) {
            	        case 1 :
            	            // EolParserRules.g:400:25: op= '==' relationalExpression
            	            {
            	            op=(Token)match(input,127,FOLLOW_127_in_relationalExpression1635); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	            }
            	            pushFollow(FOLLOW_relationalExpression_in_relationalExpression1638);
            	            relationalExpression110=relationalExpression();

            	            state._fsp--;
            	            if (state.failed) return retval;
            	            if ( state.backtracking==0 ) adaptor.addChild(root_0, relationalExpression110.getTree());

            	            }
            	            break;
            	        case 2 :
            	            // EolParserRules.g:400:57: op= '=' relationalExpression
            	            {
            	            op=(Token)match(input,84,FOLLOW_84_in_relationalExpression1644); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	            }
            	            pushFollow(FOLLOW_relationalExpression_in_relationalExpression1647);
            	            relationalExpression111=relationalExpression();

            	            state._fsp--;
            	            if (state.failed) return retval;
            	            if ( state.backtracking==0 ) adaptor.addChild(root_0, relationalExpression111.getTree());

            	            }
            	            break;
            	        case 3 :
            	            // EolParserRules.g:401:24: (op= '>' | op= '<' | op= '>=' | op= '<=' | op= '<>' ) additiveExpression
            	            {
            	            // EolParserRules.g:401:24: (op= '>' | op= '<' | op= '>=' | op= '<=' | op= '<>' )
            	            int alt42=5;
            	            switch ( input.LA(1) ) {
            	            case 104:
            	                {
            	                alt42=1;
            	                }
            	                break;
            	            case 103:
            	                {
            	                alt42=2;
            	                }
            	                break;
            	            case 128:
            	                {
            	                alt42=3;
            	                }
            	                break;
            	            case 129:
            	                {
            	                alt42=4;
            	                }
            	                break;
            	            case 130:
            	                {
            	                alt42=5;
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
            	                    // EolParserRules.g:401:25: op= '>'
            	                    {
            	                    op=(Token)match(input,104,FOLLOW_104_in_relationalExpression1677); if (state.failed) return retval;
            	                    if ( state.backtracking==0 ) {
            	                    op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	                    }

            	                    }
            	                    break;
            	                case 2 :
            	                    // EolParserRules.g:401:33: op= '<'
            	                    {
            	                    op=(Token)match(input,103,FOLLOW_103_in_relationalExpression1682); if (state.failed) return retval;
            	                    if ( state.backtracking==0 ) {
            	                    op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	                    }

            	                    }
            	                    break;
            	                case 3 :
            	                    // EolParserRules.g:401:41: op= '>='
            	                    {
            	                    op=(Token)match(input,128,FOLLOW_128_in_relationalExpression1687); if (state.failed) return retval;
            	                    if ( state.backtracking==0 ) {
            	                    op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	                    }

            	                    }
            	                    break;
            	                case 4 :
            	                    // EolParserRules.g:401:50: op= '<='
            	                    {
            	                    op=(Token)match(input,129,FOLLOW_129_in_relationalExpression1692); if (state.failed) return retval;
            	                    if ( state.backtracking==0 ) {
            	                    op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	                    }

            	                    }
            	                    break;
            	                case 5 :
            	                    // EolParserRules.g:401:59: op= '<>'
            	                    {
            	                    op=(Token)match(input,130,FOLLOW_130_in_relationalExpression1697); if (state.failed) return retval;
            	                    if ( state.backtracking==0 ) {
            	                    op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	                    }

            	                    }
            	                    break;

            	            }

            	            pushFollow(FOLLOW_additiveExpression_in_relationalExpression1701);
            	            additiveExpression112=additiveExpression();

            	            state._fsp--;
            	            if (state.failed) return retval;
            	            if ( state.backtracking==0 ) adaptor.addChild(root_0, additiveExpression112.getTree());

            	            }
            	            break;

            	    }

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
    // $ANTLR end relationalExpression

    public static class additiveExpression_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start additiveExpression
    // EolParserRules.g:405:1: additiveExpression : multiplicativeExpression ( (op= '+' | op= '-' ) multiplicativeExpression )* ;
    public final Eol_EolParserRules.additiveExpression_return additiveExpression() throws RecognitionException {
        Eol_EolParserRules.additiveExpression_return retval = new Eol_EolParserRules.additiveExpression_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token op=null;
        Eol_EolParserRules.multiplicativeExpression_return multiplicativeExpression113 = null;

        Eol_EolParserRules.multiplicativeExpression_return multiplicativeExpression114 = null;


        org.eclipse.epsilon.common.parse.AST op_tree=null;

        try {
            // EolParserRules.g:406:2: ( multiplicativeExpression ( (op= '+' | op= '-' ) multiplicativeExpression )* )
            // EolParserRules.g:406:4: multiplicativeExpression ( (op= '+' | op= '-' ) multiplicativeExpression )*
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            pushFollow(FOLLOW_multiplicativeExpression_in_additiveExpression1719);
            multiplicativeExpression113=multiplicativeExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, multiplicativeExpression113.getTree());
            // EolParserRules.g:406:29: ( (op= '+' | op= '-' ) multiplicativeExpression )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( ((LA46_0>=131 && LA46_0<=132)) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // EolParserRules.g:406:30: (op= '+' | op= '-' ) multiplicativeExpression
            	    {
            	    // EolParserRules.g:406:30: (op= '+' | op= '-' )
            	    int alt45=2;
            	    int LA45_0 = input.LA(1);

            	    if ( (LA45_0==131) ) {
            	        alt45=1;
            	    }
            	    else if ( (LA45_0==132) ) {
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
            	            // EolParserRules.g:406:31: op= '+'
            	            {
            	            op=(Token)match(input,131,FOLLOW_131_in_additiveExpression1725); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // EolParserRules.g:406:39: op= '-'
            	            {
            	            op=(Token)match(input,132,FOLLOW_132_in_additiveExpression1730); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_multiplicativeExpression_in_additiveExpression1734);
            	    multiplicativeExpression114=multiplicativeExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, multiplicativeExpression114.getTree());
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
    // $ANTLR end additiveExpression

    public static class multiplicativeExpression_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start multiplicativeExpression
    // EolParserRules.g:410:1: multiplicativeExpression : unaryExpression ( (op= '*' | op= '/' ) unaryExpression )* ;
    public final Eol_EolParserRules.multiplicativeExpression_return multiplicativeExpression() throws RecognitionException {
        Eol_EolParserRules.multiplicativeExpression_return retval = new Eol_EolParserRules.multiplicativeExpression_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token op=null;
        Eol_EolParserRules.unaryExpression_return unaryExpression115 = null;

        Eol_EolParserRules.unaryExpression_return unaryExpression116 = null;


        org.eclipse.epsilon.common.parse.AST op_tree=null;

        try {
            // EolParserRules.g:411:2: ( unaryExpression ( (op= '*' | op= '/' ) unaryExpression )* )
            // EolParserRules.g:411:4: unaryExpression ( (op= '*' | op= '/' ) unaryExpression )*
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            pushFollow(FOLLOW_unaryExpression_in_multiplicativeExpression1752);
            unaryExpression115=unaryExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, unaryExpression115.getTree());
            // EolParserRules.g:411:20: ( (op= '*' | op= '/' ) unaryExpression )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( ((LA48_0>=133 && LA48_0<=134)) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // EolParserRules.g:411:21: (op= '*' | op= '/' ) unaryExpression
            	    {
            	    // EolParserRules.g:411:21: (op= '*' | op= '/' )
            	    int alt47=2;
            	    int LA47_0 = input.LA(1);

            	    if ( (LA47_0==133) ) {
            	        alt47=1;
            	    }
            	    else if ( (LA47_0==134) ) {
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
            	            // EolParserRules.g:411:22: op= '*'
            	            {
            	            op=(Token)match(input,133,FOLLOW_133_in_multiplicativeExpression1758); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // EolParserRules.g:411:30: op= '/'
            	            {
            	            op=(Token)match(input,134,FOLLOW_134_in_multiplicativeExpression1763); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
            	            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_unaryExpression_in_multiplicativeExpression1767);
            	    unaryExpression116=unaryExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, unaryExpression116.getTree());
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
    // $ANTLR end multiplicativeExpression

    public static class unaryExpression_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start unaryExpression
    // EolParserRules.g:415:1: unaryExpression : ( (op= 'not' | op= '-' ) )? postfixExpression ;
    public final Eol_EolParserRules.unaryExpression_return unaryExpression() throws RecognitionException {
        Eol_EolParserRules.unaryExpression_return retval = new Eol_EolParserRules.unaryExpression_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token op=null;
        Eol_EolParserRules.postfixExpression_return postfixExpression117 = null;


        org.eclipse.epsilon.common.parse.AST op_tree=null;

        try {
            // EolParserRules.g:416:2: ( ( (op= 'not' | op= '-' ) )? postfixExpression )
            // EolParserRules.g:416:4: ( (op= 'not' | op= '-' ) )? postfixExpression
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            // EolParserRules.g:416:4: ( (op= 'not' | op= '-' ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==132||LA50_0==135) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // EolParserRules.g:416:5: (op= 'not' | op= '-' )
                    {
                    // EolParserRules.g:416:5: (op= 'not' | op= '-' )
                    int alt49=2;
                    int LA49_0 = input.LA(1);

                    if ( (LA49_0==135) ) {
                        alt49=1;
                    }
                    else if ( (LA49_0==132) ) {
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
                            // EolParserRules.g:416:6: op= 'not'
                            {
                            op=(Token)match(input,135,FOLLOW_135_in_unaryExpression1788); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            op_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(op);
                            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(op_tree, root_0);
                            }

                            }
                            break;
                        case 2 :
                            // EolParserRules.g:416:16: op= '-'
                            {
                            op=(Token)match(input,132,FOLLOW_132_in_unaryExpression1793); if (state.failed) return retval;
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

            pushFollow(FOLLOW_postfixExpression_in_unaryExpression1801);
            postfixExpression117=postfixExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, postfixExpression117.getTree());

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
    // EolParserRules.g:419:1: postfixExpression : itemSelectorExpression ( ( POINT | ARROW ) fc= featureCall (is= '[' logicalExpression ']' )* )* ;
    public final Eol_EolParserRules.postfixExpression_return postfixExpression() throws RecognitionException {
        Eol_EolParserRules.postfixExpression_return retval = new Eol_EolParserRules.postfixExpression_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token is=null;
        Token set119=null;
        Token char_literal121=null;
        Eol_EolParserRules.featureCall_return fc = null;

        Eol_EolParserRules.itemSelectorExpression_return itemSelectorExpression118 = null;

        Eol_EolParserRules.logicalExpression_return logicalExpression120 = null;


        org.eclipse.epsilon.common.parse.AST is_tree=null;
        org.eclipse.epsilon.common.parse.AST set119_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal121_tree=null;

        try {
            // EolParserRules.g:420:2: ( itemSelectorExpression ( ( POINT | ARROW ) fc= featureCall (is= '[' logicalExpression ']' )* )* )
            // EolParserRules.g:420:4: itemSelectorExpression ( ( POINT | ARROW ) fc= featureCall (is= '[' logicalExpression ']' )* )*
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            pushFollow(FOLLOW_itemSelectorExpression_in_postfixExpression1813);
            itemSelectorExpression118=itemSelectorExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, itemSelectorExpression118.getTree());
            // EolParserRules.g:420:27: ( ( POINT | ARROW ) fc= featureCall (is= '[' logicalExpression ']' )* )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==POINT||LA52_0==ARROW) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // EolParserRules.g:420:28: ( POINT | ARROW ) fc= featureCall (is= '[' logicalExpression ']' )*
            	    {
            	    set119=(Token)input.LT(1);
            	    set119=(Token)input.LT(1);
            	    if ( input.LA(1)==POINT||input.LA(1)==ARROW ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot((org.eclipse.epsilon.common.parse.AST)adaptor.create(set119), root_0);
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_featureCall_in_postfixExpression1825);
            	    fc=featureCall();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, fc.getTree());
            	    if ( state.backtracking==0 ) {
            	      setTokenType(fc,FEATURECALL);
            	    }
            	    // EolParserRules.g:421:35: (is= '[' logicalExpression ']' )*
            	    loop51:
            	    do {
            	        int alt51=2;
            	        int LA51_0 = input.LA(1);

            	        if ( (LA51_0==136) ) {
            	            alt51=1;
            	        }


            	        switch (alt51) {
            	    	case 1 :
            	    	    // EolParserRules.g:421:36: is= '[' logicalExpression ']'
            	    	    {
            	    	    is=(Token)match(input,136,FOLLOW_136_in_postfixExpression1834); if (state.failed) return retval;
            	    	    if ( state.backtracking==0 ) {
            	    	    is_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(is);
            	    	    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(is_tree, root_0);
            	    	    }
            	    	    pushFollow(FOLLOW_logicalExpression_in_postfixExpression1837);
            	    	    logicalExpression120=logicalExpression();

            	    	    state._fsp--;
            	    	    if (state.failed) return retval;
            	    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression120.getTree());
            	    	    char_literal121=(Token)match(input,137,FOLLOW_137_in_postfixExpression1839); if (state.failed) return retval;
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
    // $ANTLR end postfixExpression

    public static class itemSelectorExpression_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start itemSelectorExpression
    // EolParserRules.g:425:1: itemSelectorExpression : primitiveExpression (is= '[' primitiveExpression ']' )* ;
    public final Eol_EolParserRules.itemSelectorExpression_return itemSelectorExpression() throws RecognitionException {
        Eol_EolParserRules.itemSelectorExpression_return retval = new Eol_EolParserRules.itemSelectorExpression_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token is=null;
        Token char_literal124=null;
        Eol_EolParserRules.primitiveExpression_return primitiveExpression122 = null;

        Eol_EolParserRules.primitiveExpression_return primitiveExpression123 = null;


        org.eclipse.epsilon.common.parse.AST is_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal124_tree=null;

        try {
            // EolParserRules.g:426:2: ( primitiveExpression (is= '[' primitiveExpression ']' )* )
            // EolParserRules.g:426:4: primitiveExpression (is= '[' primitiveExpression ']' )*
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            pushFollow(FOLLOW_primitiveExpression_in_itemSelectorExpression1861);
            primitiveExpression122=primitiveExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, primitiveExpression122.getTree());
            // EolParserRules.g:426:24: (is= '[' primitiveExpression ']' )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==136) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // EolParserRules.g:426:25: is= '[' primitiveExpression ']'
            	    {
            	    is=(Token)match(input,136,FOLLOW_136_in_itemSelectorExpression1866); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    is_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(is);
            	    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(is_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_primitiveExpression_in_itemSelectorExpression1869);
            	    primitiveExpression123=primitiveExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, primitiveExpression123.getTree());
            	    char_literal124=(Token)match(input,137,FOLLOW_137_in_itemSelectorExpression1871); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	      is.setType(ITEMSELECTOR);
            	    }

            	    }
            	    break;

            	default :
            	    break loop53;
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
    // EolParserRules.g:430:1: featureCall : ( simpleFeatureCall | declarativeFeatureCall );
    public final Eol_EolParserRules.featureCall_return featureCall() throws RecognitionException {
        Eol_EolParserRules.featureCall_return retval = new Eol_EolParserRules.featureCall_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Eol_EolParserRules.simpleFeatureCall_return simpleFeatureCall125 = null;

        Eol_EolParserRules.declarativeFeatureCall_return declarativeFeatureCall126 = null;



        try {
            // EolParserRules.g:431:2: ( simpleFeatureCall | declarativeFeatureCall )
            int alt54=2;
            alt54 = dfa54.predict(input);
            switch (alt54) {
                case 1 :
                    // EolParserRules.g:431:4: simpleFeatureCall
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_simpleFeatureCall_in_featureCall1890);
                    simpleFeatureCall125=simpleFeatureCall();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, simpleFeatureCall125.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:431:24: declarativeFeatureCall
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_declarativeFeatureCall_in_featureCall1894);
                    declarativeFeatureCall126=declarativeFeatureCall();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, declarativeFeatureCall126.getTree());

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
    // EolParserRules.g:434:1: simpleFeatureCall : n= NAME ( parameterList )? ;
    public final Eol_EolParserRules.simpleFeatureCall_return simpleFeatureCall() throws RecognitionException {
        Eol_EolParserRules.simpleFeatureCall_return retval = new Eol_EolParserRules.simpleFeatureCall_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token n=null;
        Eol_EolParserRules.parameterList_return parameterList127 = null;


        org.eclipse.epsilon.common.parse.AST n_tree=null;

        try {
            // EolParserRules.g:435:2: (n= NAME ( parameterList )? )
            // EolParserRules.g:435:5: n= NAME ( parameterList )?
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            n=(Token)match(input,NAME,FOLLOW_NAME_in_simpleFeatureCall1908); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            n_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(n);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(n_tree, root_0);
            }
            // EolParserRules.g:435:13: ( parameterList )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==87) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // EolParserRules.g:0:0: parameterList
                    {
                    pushFollow(FOLLOW_parameterList_in_simpleFeatureCall1911);
                    parameterList127=parameterList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, parameterList127.getTree());

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
    // EolParserRules.g:439:1: parameterList : op= '(' ( logicalExpression ( ',' logicalExpression )* )? cp= ')' -> ^( PARAMETERS ( logicalExpression )* ) ;
    public final Eol_EolParserRules.parameterList_return parameterList() throws RecognitionException {
        Eol_EolParserRules.parameterList_return retval = new Eol_EolParserRules.parameterList_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token op=null;
        Token cp=null;
        Token char_literal129=null;
        Eol_EolParserRules.logicalExpression_return logicalExpression128 = null;

        Eol_EolParserRules.logicalExpression_return logicalExpression130 = null;


        org.eclipse.epsilon.common.parse.AST op_tree=null;
        org.eclipse.epsilon.common.parse.AST cp_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal129_tree=null;
        RewriteRuleTokenStream stream_80=new RewriteRuleTokenStream(adaptor,"token 80");
        RewriteRuleTokenStream stream_87=new RewriteRuleTokenStream(adaptor,"token 87");
        RewriteRuleTokenStream stream_88=new RewriteRuleTokenStream(adaptor,"token 88");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:445:2: (op= '(' ( logicalExpression ( ',' logicalExpression )* )? cp= ')' -> ^( PARAMETERS ( logicalExpression )* ) )
            // EolParserRules.g:445:4: op= '(' ( logicalExpression ( ',' logicalExpression )* )? cp= ')'
            {
            op=(Token)match(input,87,FOLLOW_87_in_parameterList1934); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_87.add(op);

            // EolParserRules.g:445:11: ( logicalExpression ( ',' logicalExpression )* )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==FLOAT||LA57_0==INT||LA57_0==BOOLEAN||LA57_0==STRING||LA57_0==NAME||LA57_0==87||(LA57_0>=95 && LA57_0<=102)||LA57_0==132||LA57_0==135||(LA57_0>=139 && LA57_0<=141)) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // EolParserRules.g:445:12: logicalExpression ( ',' logicalExpression )*
                    {
                    pushFollow(FOLLOW_logicalExpression_in_parameterList1937);
                    logicalExpression128=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression128.getTree());
                    // EolParserRules.g:445:30: ( ',' logicalExpression )*
                    loop56:
                    do {
                        int alt56=2;
                        int LA56_0 = input.LA(1);

                        if ( (LA56_0==80) ) {
                            alt56=1;
                        }


                        switch (alt56) {
                    	case 1 :
                    	    // EolParserRules.g:445:31: ',' logicalExpression
                    	    {
                    	    char_literal129=(Token)match(input,80,FOLLOW_80_in_parameterList1940); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_80.add(char_literal129);

                    	    pushFollow(FOLLOW_logicalExpression_in_parameterList1942);
                    	    logicalExpression130=logicalExpression();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression130.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop56;
                        }
                    } while (true);


                    }
                    break;

            }

            cp=(Token)match(input,88,FOLLOW_88_in_parameterList1950); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_88.add(cp);



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
            // 446:3: -> ^( PARAMETERS ( logicalExpression )* )
            {
                // EolParserRules.g:446:6: ^( PARAMETERS ( logicalExpression )* )
                {
                org.eclipse.epsilon.common.parse.AST root_1 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();
                root_1 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot((org.eclipse.epsilon.common.parse.AST)adaptor.create(PARAMETERS, "PARAMETERS"), root_1);

                // EolParserRules.g:446:19: ( logicalExpression )*
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
    // EolParserRules.g:449:1: declarativeFeatureCall : NAME op= '(' formalParameterList '|' logicalExpression ( ',' logicalExpression )* cp= ')' ;
    public final Eol_EolParserRules.declarativeFeatureCall_return declarativeFeatureCall() throws RecognitionException {
        Eol_EolParserRules.declarativeFeatureCall_return retval = new Eol_EolParserRules.declarativeFeatureCall_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token op=null;
        Token cp=null;
        Token NAME131=null;
        Token char_literal133=null;
        Token char_literal135=null;
        Eol_EolParserRules.formalParameterList_return formalParameterList132 = null;

        Eol_EolParserRules.logicalExpression_return logicalExpression134 = null;

        Eol_EolParserRules.logicalExpression_return logicalExpression136 = null;


        org.eclipse.epsilon.common.parse.AST op_tree=null;
        org.eclipse.epsilon.common.parse.AST cp_tree=null;
        org.eclipse.epsilon.common.parse.AST NAME131_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal133_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal135_tree=null;

        try {
            // EolParserRules.g:454:2: ( NAME op= '(' formalParameterList '|' logicalExpression ( ',' logicalExpression )* cp= ')' )
            // EolParserRules.g:454:4: NAME op= '(' formalParameterList '|' logicalExpression ( ',' logicalExpression )* cp= ')'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            NAME131=(Token)match(input,NAME,FOLLOW_NAME_in_declarativeFeatureCall1978); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME131_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(NAME131);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(NAME131_tree, root_0);
            }
            op=(Token)match(input,87,FOLLOW_87_in_declarativeFeatureCall1983); if (state.failed) return retval;
            pushFollow(FOLLOW_formalParameterList_in_declarativeFeatureCall1986);
            formalParameterList132=formalParameterList();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, formalParameterList132.getTree());
            char_literal133=(Token)match(input,138,FOLLOW_138_in_declarativeFeatureCall1988); if (state.failed) return retval;
            pushFollow(FOLLOW_logicalExpression_in_declarativeFeatureCall1991);
            logicalExpression134=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression134.getTree());
            // EolParserRules.g:454:61: ( ',' logicalExpression )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==80) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // EolParserRules.g:454:62: ',' logicalExpression
            	    {
            	    char_literal135=(Token)match(input,80,FOLLOW_80_in_declarativeFeatureCall1994); if (state.failed) return retval;
            	    pushFollow(FOLLOW_logicalExpression_in_declarativeFeatureCall1997);
            	    logicalExpression136=logicalExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression136.getTree());

            	    }
            	    break;

            	default :
            	    break loop58;
                }
            } while (true);

            cp=(Token)match(input,88,FOLLOW_88_in_declarativeFeatureCall2003); if (state.failed) return retval;

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
    // EolParserRules.g:457:1: newExpression : n= 'new' tn= typeName ( parameterList )? ;
    public final Eol_EolParserRules.newExpression_return newExpression() throws RecognitionException {
        Eol_EolParserRules.newExpression_return retval = new Eol_EolParserRules.newExpression_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token n=null;
        Eol_EolParserRules.typeName_return tn = null;

        Eol_EolParserRules.parameterList_return parameterList137 = null;


        org.eclipse.epsilon.common.parse.AST n_tree=null;

        try {
            // EolParserRules.g:458:2: (n= 'new' tn= typeName ( parameterList )? )
            // EolParserRules.g:458:4: n= 'new' tn= typeName ( parameterList )?
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            n=(Token)match(input,139,FOLLOW_139_in_newExpression2017); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            n_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(n);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(n_tree, root_0);
            }
            pushFollow(FOLLOW_typeName_in_newExpression2022);
            tn=typeName();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, tn.getTree());
            if ( state.backtracking==0 ) {
              setTokenType(tn,TYPE);
            }
            // EolParserRules.g:458:50: ( parameterList )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==87) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // EolParserRules.g:0:0: parameterList
                    {
                    pushFollow(FOLLOW_parameterList_in_newExpression2026);
                    parameterList137=parameterList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, parameterList137.getTree());

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
    // EolParserRules.g:462:1: variableDeclarationExpression : (v= 'var' | v= 'ext' ) NAME ( ':' (n= 'new' )? t= typeName ( parameterList )? )? ;
    public final Eol_EolParserRules.variableDeclarationExpression_return variableDeclarationExpression() throws RecognitionException {
        Eol_EolParserRules.variableDeclarationExpression_return retval = new Eol_EolParserRules.variableDeclarationExpression_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token v=null;
        Token n=null;
        Token NAME138=null;
        Token char_literal139=null;
        Eol_EolParserRules.typeName_return t = null;

        Eol_EolParserRules.parameterList_return parameterList140 = null;


        org.eclipse.epsilon.common.parse.AST v_tree=null;
        org.eclipse.epsilon.common.parse.AST n_tree=null;
        org.eclipse.epsilon.common.parse.AST NAME138_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal139_tree=null;

        try {
            // EolParserRules.g:470:2: ( (v= 'var' | v= 'ext' ) NAME ( ':' (n= 'new' )? t= typeName ( parameterList )? )? )
            // EolParserRules.g:470:4: (v= 'var' | v= 'ext' ) NAME ( ':' (n= 'new' )? t= typeName ( parameterList )? )?
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            // EolParserRules.g:470:4: (v= 'var' | v= 'ext' )
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==140) ) {
                alt60=1;
            }
            else if ( (LA60_0==141) ) {
                alt60=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;
            }
            switch (alt60) {
                case 1 :
                    // EolParserRules.g:470:5: v= 'var'
                    {
                    v=(Token)match(input,140,FOLLOW_140_in_variableDeclarationExpression2049); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    v_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(v);
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(v_tree, root_0);
                    }

                    }
                    break;
                case 2 :
                    // EolParserRules.g:470:14: v= 'ext'
                    {
                    v=(Token)match(input,141,FOLLOW_141_in_variableDeclarationExpression2054); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    v_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(v);
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(v_tree, root_0);
                    }

                    }
                    break;

            }

            NAME138=(Token)match(input,NAME,FOLLOW_NAME_in_variableDeclarationExpression2058); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME138_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(NAME138);
            adaptor.addChild(root_0, NAME138_tree);
            }
            // EolParserRules.g:470:29: ( ':' (n= 'new' )? t= typeName ( parameterList )? )?
            int alt63=2;
            alt63 = dfa63.predict(input);
            switch (alt63) {
                case 1 :
                    // EolParserRules.g:470:30: ':' (n= 'new' )? t= typeName ( parameterList )?
                    {
                    char_literal139=(Token)match(input,89,FOLLOW_89_in_variableDeclarationExpression2061); if (state.failed) return retval;
                    // EolParserRules.g:470:36: (n= 'new' )?
                    int alt61=2;
                    int LA61_0 = input.LA(1);

                    if ( (LA61_0==139) ) {
                        alt61=1;
                    }
                    switch (alt61) {
                        case 1 :
                            // EolParserRules.g:0:0: n= 'new'
                            {
                            n=(Token)match(input,139,FOLLOW_139_in_variableDeclarationExpression2066); if (state.failed) return retval;

                            }
                            break;

                    }

                    pushFollow(FOLLOW_typeName_in_variableDeclarationExpression2072);
                    t=typeName();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, t.getTree());
                    if ( state.backtracking==0 ) {
                      setTokenType(t, TYPE);
                    }
                    // EolParserRules.g:470:81: ( parameterList )?
                    int alt62=2;
                    int LA62_0 = input.LA(1);

                    if ( (LA62_0==87) ) {
                        alt62=1;
                    }
                    switch (alt62) {
                        case 1 :
                            // EolParserRules.g:0:0: parameterList
                            {
                            pushFollow(FOLLOW_parameterList_in_variableDeclarationExpression2076);
                            parameterList140=parameterList();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, parameterList140.getTree());

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
    // EolParserRules.g:473:1: literalSequentialCollection : (l= 'Collection' | l= 'Sequence' | l= 'List' | l= 'Bag' | l= 'Set' | l= 'OrderedSet' ) ob= '{' ( expressionListOrRange )? cb= '}' ;
    public final Eol_EolParserRules.literalSequentialCollection_return literalSequentialCollection() throws RecognitionException {
        Eol_EolParserRules.literalSequentialCollection_return retval = new Eol_EolParserRules.literalSequentialCollection_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token l=null;
        Token ob=null;
        Token cb=null;
        Eol_EolParserRules.expressionListOrRange_return expressionListOrRange141 = null;


        org.eclipse.epsilon.common.parse.AST l_tree=null;
        org.eclipse.epsilon.common.parse.AST ob_tree=null;
        org.eclipse.epsilon.common.parse.AST cb_tree=null;

        try {
            // EolParserRules.g:478:2: ( (l= 'Collection' | l= 'Sequence' | l= 'List' | l= 'Bag' | l= 'Set' | l= 'OrderedSet' ) ob= '{' ( expressionListOrRange )? cb= '}' )
            // EolParserRules.g:478:4: (l= 'Collection' | l= 'Sequence' | l= 'List' | l= 'Bag' | l= 'Set' | l= 'OrderedSet' ) ob= '{' ( expressionListOrRange )? cb= '}'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            // EolParserRules.g:478:4: (l= 'Collection' | l= 'Sequence' | l= 'List' | l= 'Bag' | l= 'Set' | l= 'OrderedSet' )
            int alt64=6;
            switch ( input.LA(1) ) {
            case 96:
                {
                alt64=1;
                }
                break;
            case 97:
                {
                alt64=2;
                }
                break;
            case 98:
                {
                alt64=3;
                }
                break;
            case 99:
                {
                alt64=4;
                }
                break;
            case 100:
                {
                alt64=5;
                }
                break;
            case 101:
                {
                alt64=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;
            }

            switch (alt64) {
                case 1 :
                    // EolParserRules.g:478:5: l= 'Collection'
                    {
                    l=(Token)match(input,96,FOLLOW_96_in_literalSequentialCollection2100); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    l_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(l);
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(l_tree, root_0);
                    }

                    }
                    break;
                case 2 :
                    // EolParserRules.g:478:21: l= 'Sequence'
                    {
                    l=(Token)match(input,97,FOLLOW_97_in_literalSequentialCollection2105); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    l_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(l);
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(l_tree, root_0);
                    }

                    }
                    break;
                case 3 :
                    // EolParserRules.g:478:35: l= 'List'
                    {
                    l=(Token)match(input,98,FOLLOW_98_in_literalSequentialCollection2110); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    l_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(l);
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(l_tree, root_0);
                    }

                    }
                    break;
                case 4 :
                    // EolParserRules.g:478:45: l= 'Bag'
                    {
                    l=(Token)match(input,99,FOLLOW_99_in_literalSequentialCollection2115); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    l_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(l);
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(l_tree, root_0);
                    }

                    }
                    break;
                case 5 :
                    // EolParserRules.g:478:54: l= 'Set'
                    {
                    l=(Token)match(input,100,FOLLOW_100_in_literalSequentialCollection2120); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    l_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(l);
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(l_tree, root_0);
                    }

                    }
                    break;
                case 6 :
                    // EolParserRules.g:478:63: l= 'OrderedSet'
                    {
                    l=(Token)match(input,101,FOLLOW_101_in_literalSequentialCollection2125); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    l_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(l);
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(l_tree, root_0);
                    }

                    }
                    break;

            }

            ob=(Token)match(input,82,FOLLOW_82_in_literalSequentialCollection2131); if (state.failed) return retval;
            // EolParserRules.g:478:89: ( expressionListOrRange )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==FLOAT||LA65_0==INT||LA65_0==BOOLEAN||LA65_0==STRING||LA65_0==NAME||LA65_0==87||(LA65_0>=95 && LA65_0<=102)||LA65_0==132||LA65_0==135||(LA65_0>=139 && LA65_0<=141)) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // EolParserRules.g:0:0: expressionListOrRange
                    {
                    pushFollow(FOLLOW_expressionListOrRange_in_literalSequentialCollection2135);
                    expressionListOrRange141=expressionListOrRange();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionListOrRange141.getTree());

                    }
                    break;

            }

            cb=(Token)match(input,83,FOLLOW_83_in_literalSequentialCollection2140); if (state.failed) return retval;
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
    // EolParserRules.g:482:1: expressionRange : logicalExpression exp= '..' logicalExpression ;
    public final Eol_EolParserRules.expressionRange_return expressionRange() throws RecognitionException {
        Eol_EolParserRules.expressionRange_return retval = new Eol_EolParserRules.expressionRange_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token exp=null;
        Eol_EolParserRules.logicalExpression_return logicalExpression142 = null;

        Eol_EolParserRules.logicalExpression_return logicalExpression143 = null;


        org.eclipse.epsilon.common.parse.AST exp_tree=null;

        try {
            // EolParserRules.g:483:2: ( logicalExpression exp= '..' logicalExpression )
            // EolParserRules.g:483:4: logicalExpression exp= '..' logicalExpression
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            pushFollow(FOLLOW_logicalExpression_in_expressionRange2155);
            logicalExpression142=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression142.getTree());
            exp=(Token)match(input,POINT_POINT,FOLLOW_POINT_POINT_in_expressionRange2159); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            exp_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(exp);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(exp_tree, root_0);
            }
            pushFollow(FOLLOW_logicalExpression_in_expressionRange2162);
            logicalExpression143=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression143.getTree());
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
    // EolParserRules.g:487:1: expressionList : logicalExpression ( ',' logicalExpression )* -> ^( EXPRLIST ( logicalExpression )+ ) ;
    public final Eol_EolParserRules.expressionList_return expressionList() throws RecognitionException {
        Eol_EolParserRules.expressionList_return retval = new Eol_EolParserRules.expressionList_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token char_literal145=null;
        Eol_EolParserRules.logicalExpression_return logicalExpression144 = null;

        Eol_EolParserRules.logicalExpression_return logicalExpression146 = null;


        org.eclipse.epsilon.common.parse.AST char_literal145_tree=null;
        RewriteRuleTokenStream stream_80=new RewriteRuleTokenStream(adaptor,"token 80");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:491:2: ( logicalExpression ( ',' logicalExpression )* -> ^( EXPRLIST ( logicalExpression )+ ) )
            // EolParserRules.g:491:4: logicalExpression ( ',' logicalExpression )*
            {
            pushFollow(FOLLOW_logicalExpression_in_expressionList2183);
            logicalExpression144=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression144.getTree());
            // EolParserRules.g:491:22: ( ',' logicalExpression )*
            loop66:
            do {
                int alt66=2;
                int LA66_0 = input.LA(1);

                if ( (LA66_0==80) ) {
                    alt66=1;
                }


                switch (alt66) {
            	case 1 :
            	    // EolParserRules.g:491:23: ',' logicalExpression
            	    {
            	    char_literal145=(Token)match(input,80,FOLLOW_80_in_expressionList2186); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_80.add(char_literal145);

            	    pushFollow(FOLLOW_logicalExpression_in_expressionList2188);
            	    logicalExpression146=logicalExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression146.getTree());

            	    }
            	    break;

            	default :
            	    break loop66;
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
            // 492:2: -> ^( EXPRLIST ( logicalExpression )+ )
            {
                // EolParserRules.g:492:5: ^( EXPRLIST ( logicalExpression )+ )
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
    // EolParserRules.g:495:1: expressionListOrRange : ( expressionRange | expressionList );
    public final Eol_EolParserRules.expressionListOrRange_return expressionListOrRange() throws RecognitionException {
        Eol_EolParserRules.expressionListOrRange_return retval = new Eol_EolParserRules.expressionListOrRange_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Eol_EolParserRules.expressionRange_return expressionRange147 = null;

        Eol_EolParserRules.expressionList_return expressionList148 = null;



        try {
            // EolParserRules.g:496:2: ( expressionRange | expressionList )
            int alt67=2;
            alt67 = dfa67.predict(input);
            switch (alt67) {
                case 1 :
                    // EolParserRules.g:496:4: expressionRange
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_expressionRange_in_expressionListOrRange2212);
                    expressionRange147=expressionRange();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionRange147.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:496:22: expressionList
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_expressionList_in_expressionListOrRange2216);
                    expressionList148=expressionList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionList148.getTree());

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
    // EolParserRules.g:499:1: literalMapCollection : m= 'Map' ob= '{' ( keyvalExpressionList )? cb= '}' ;
    public final Eol_EolParserRules.literalMapCollection_return literalMapCollection() throws RecognitionException {
        Eol_EolParserRules.literalMapCollection_return retval = new Eol_EolParserRules.literalMapCollection_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token m=null;
        Token ob=null;
        Token cb=null;
        Eol_EolParserRules.keyvalExpressionList_return keyvalExpressionList149 = null;


        org.eclipse.epsilon.common.parse.AST m_tree=null;
        org.eclipse.epsilon.common.parse.AST ob_tree=null;
        org.eclipse.epsilon.common.parse.AST cb_tree=null;

        try {
            // EolParserRules.g:504:2: (m= 'Map' ob= '{' ( keyvalExpressionList )? cb= '}' )
            // EolParserRules.g:504:4: m= 'Map' ob= '{' ( keyvalExpressionList )? cb= '}'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            m=(Token)match(input,102,FOLLOW_102_in_literalMapCollection2235); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            m_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(m);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(m_tree, root_0);
            }
            ob=(Token)match(input,82,FOLLOW_82_in_literalMapCollection2240); if (state.failed) return retval;
            // EolParserRules.g:504:21: ( keyvalExpressionList )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==FLOAT||LA68_0==INT||LA68_0==BOOLEAN||LA68_0==STRING||LA68_0==NAME||LA68_0==87||(LA68_0>=95 && LA68_0<=102)||LA68_0==132||LA68_0==135||(LA68_0>=139 && LA68_0<=141)) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // EolParserRules.g:0:0: keyvalExpressionList
                    {
                    pushFollow(FOLLOW_keyvalExpressionList_in_literalMapCollection2243);
                    keyvalExpressionList149=keyvalExpressionList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, keyvalExpressionList149.getTree());

                    }
                    break;

            }

            cb=(Token)match(input,83,FOLLOW_83_in_literalMapCollection2248); if (state.failed) return retval;
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
    // EolParserRules.g:508:1: keyvalExpressionList : keyvalExpression ( ',' keyvalExpression )* -> ^( KEYVALLIST ( keyvalExpression )+ ) ;
    public final Eol_EolParserRules.keyvalExpressionList_return keyvalExpressionList() throws RecognitionException {
        Eol_EolParserRules.keyvalExpressionList_return retval = new Eol_EolParserRules.keyvalExpressionList_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token char_literal151=null;
        Eol_EolParserRules.keyvalExpression_return keyvalExpression150 = null;

        Eol_EolParserRules.keyvalExpression_return keyvalExpression152 = null;


        org.eclipse.epsilon.common.parse.AST char_literal151_tree=null;
        RewriteRuleTokenStream stream_80=new RewriteRuleTokenStream(adaptor,"token 80");
        RewriteRuleSubtreeStream stream_keyvalExpression=new RewriteRuleSubtreeStream(adaptor,"rule keyvalExpression");
        try {
            // EolParserRules.g:512:2: ( keyvalExpression ( ',' keyvalExpression )* -> ^( KEYVALLIST ( keyvalExpression )+ ) )
            // EolParserRules.g:512:4: keyvalExpression ( ',' keyvalExpression )*
            {
            pushFollow(FOLLOW_keyvalExpression_in_keyvalExpressionList2269);
            keyvalExpression150=keyvalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_keyvalExpression.add(keyvalExpression150.getTree());
            // EolParserRules.g:512:21: ( ',' keyvalExpression )*
            loop69:
            do {
                int alt69=2;
                int LA69_0 = input.LA(1);

                if ( (LA69_0==80) ) {
                    alt69=1;
                }


                switch (alt69) {
            	case 1 :
            	    // EolParserRules.g:512:22: ',' keyvalExpression
            	    {
            	    char_literal151=(Token)match(input,80,FOLLOW_80_in_keyvalExpressionList2272); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_80.add(char_literal151);

            	    pushFollow(FOLLOW_keyvalExpression_in_keyvalExpressionList2274);
            	    keyvalExpression152=keyvalExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_keyvalExpression.add(keyvalExpression152.getTree());

            	    }
            	    break;

            	default :
            	    break loop69;
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
            // 513:2: -> ^( KEYVALLIST ( keyvalExpression )+ )
            {
                // EolParserRules.g:513:5: ^( KEYVALLIST ( keyvalExpression )+ )
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
    // EolParserRules.g:516:1: keyvalExpression : additiveExpression eq= '=' logicalExpression ;
    public final Eol_EolParserRules.keyvalExpression_return keyvalExpression() throws RecognitionException {
        Eol_EolParserRules.keyvalExpression_return retval = new Eol_EolParserRules.keyvalExpression_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token eq=null;
        Eol_EolParserRules.additiveExpression_return additiveExpression153 = null;

        Eol_EolParserRules.logicalExpression_return logicalExpression154 = null;


        org.eclipse.epsilon.common.parse.AST eq_tree=null;

        try {
            // EolParserRules.g:518:2: ( additiveExpression eq= '=' logicalExpression )
            // EolParserRules.g:518:4: additiveExpression eq= '=' logicalExpression
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            pushFollow(FOLLOW_additiveExpression_in_keyvalExpression2299);
            additiveExpression153=additiveExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, additiveExpression153.getTree());
            eq=(Token)match(input,84,FOLLOW_84_in_keyvalExpression2303); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            eq_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(eq);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(eq_tree, root_0);
            }
            pushFollow(FOLLOW_logicalExpression_in_keyvalExpression2306);
            logicalExpression154=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression154.getTree());
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
    // EolParserRules.g:521:1: primitiveExpression : ( literalSequentialCollection | literalMapCollection | literal | featureCall | pathName | nativeType | collectionType | logicalExpressionInBrackets | newExpression | variableDeclarationExpression );
    public final Eol_EolParserRules.primitiveExpression_return primitiveExpression() throws RecognitionException {
        Eol_EolParserRules.primitiveExpression_return retval = new Eol_EolParserRules.primitiveExpression_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Eol_EolParserRules.literalSequentialCollection_return literalSequentialCollection155 = null;

        Eol_EolParserRules.literalMapCollection_return literalMapCollection156 = null;

        Eol_EolParserRules.literal_return literal157 = null;

        Eol_EolParserRules.featureCall_return featureCall158 = null;

        Eol_EolParserRules.pathName_return pathName159 = null;

        Eol_EolParserRules.nativeType_return nativeType160 = null;

        Eol_EolParserRules.collectionType_return collectionType161 = null;

        Eol_EolParserRules.logicalExpressionInBrackets_return logicalExpressionInBrackets162 = null;

        Eol_EolParserRules.newExpression_return newExpression163 = null;

        Eol_EolParserRules.variableDeclarationExpression_return variableDeclarationExpression164 = null;



        try {
            // EolParserRules.g:522:2: ( literalSequentialCollection | literalMapCollection | literal | featureCall | pathName | nativeType | collectionType | logicalExpressionInBrackets | newExpression | variableDeclarationExpression )
            int alt70=10;
            alt70 = dfa70.predict(input);
            switch (alt70) {
                case 1 :
                    // EolParserRules.g:522:4: literalSequentialCollection
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_literalSequentialCollection_in_primitiveExpression2320);
                    literalSequentialCollection155=literalSequentialCollection();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, literalSequentialCollection155.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:522:34: literalMapCollection
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_literalMapCollection_in_primitiveExpression2324);
                    literalMapCollection156=literalMapCollection();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, literalMapCollection156.getTree());

                    }
                    break;
                case 3 :
                    // EolParserRules.g:522:57: literal
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_literal_in_primitiveExpression2328);
                    literal157=literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, literal157.getTree());

                    }
                    break;
                case 4 :
                    // EolParserRules.g:522:67: featureCall
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_featureCall_in_primitiveExpression2332);
                    featureCall158=featureCall();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, featureCall158.getTree());

                    }
                    break;
                case 5 :
                    // EolParserRules.g:522:81: pathName
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_pathName_in_primitiveExpression2336);
                    pathName159=pathName();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pathName159.getTree());

                    }
                    break;
                case 6 :
                    // EolParserRules.g:522:92: nativeType
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_nativeType_in_primitiveExpression2340);
                    nativeType160=nativeType();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nativeType160.getTree());

                    }
                    break;
                case 7 :
                    // EolParserRules.g:523:5: collectionType
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_collectionType_in_primitiveExpression2346);
                    collectionType161=collectionType();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, collectionType161.getTree());

                    }
                    break;
                case 8 :
                    // EolParserRules.g:523:23: logicalExpressionInBrackets
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_logicalExpressionInBrackets_in_primitiveExpression2351);
                    logicalExpressionInBrackets162=logicalExpressionInBrackets();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpressionInBrackets162.getTree());

                    }
                    break;
                case 9 :
                    // EolParserRules.g:524:5: newExpression
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_newExpression_in_primitiveExpression2357);
                    newExpression163=newExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, newExpression163.getTree());

                    }
                    break;
                case 10 :
                    // EolParserRules.g:524:21: variableDeclarationExpression
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_variableDeclarationExpression_in_primitiveExpression2361);
                    variableDeclarationExpression164=variableDeclarationExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, variableDeclarationExpression164.getTree());

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
    // EolParserRules.g:527:1: logicalExpressionInBrackets : ob= '(' logicalExpression cb= ')' ;
    public final Eol_EolParserRules.logicalExpressionInBrackets_return logicalExpressionInBrackets() throws RecognitionException {
        Eol_EolParserRules.logicalExpressionInBrackets_return retval = new Eol_EolParserRules.logicalExpressionInBrackets_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token ob=null;
        Token cb=null;
        Eol_EolParserRules.logicalExpression_return logicalExpression165 = null;


        org.eclipse.epsilon.common.parse.AST ob_tree=null;
        org.eclipse.epsilon.common.parse.AST cb_tree=null;

        try {
            // EolParserRules.g:533:2: (ob= '(' logicalExpression cb= ')' )
            // EolParserRules.g:533:4: ob= '(' logicalExpression cb= ')'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            ob=(Token)match(input,87,FOLLOW_87_in_logicalExpressionInBrackets2380); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ob_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(ob);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(ob_tree, root_0);
            }
            pushFollow(FOLLOW_logicalExpression_in_logicalExpressionInBrackets2383);
            logicalExpression165=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression165.getTree());
            cb=(Token)match(input,88,FOLLOW_88_in_logicalExpressionInBrackets2387); if (state.failed) return retval;
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
    // EolParserRules.g:537:1: literal : ( STRING | INT | FLOAT | BOOLEAN );
    public final Eol_EolParserRules.literal_return literal() throws RecognitionException {
        Eol_EolParserRules.literal_return retval = new Eol_EolParserRules.literal_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token set166=null;

        org.eclipse.epsilon.common.parse.AST set166_tree=null;

        try {
            // EolParserRules.g:538:2: ( STRING | INT | FLOAT | BOOLEAN )
            // EolParserRules.g:
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            set166=(Token)input.LT(1);
            if ( input.LA(1)==FLOAT||input.LA(1)==INT||input.LA(1)==BOOLEAN||input.LA(1)==STRING ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (org.eclipse.epsilon.common.parse.AST)adaptor.create(set166));
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

    // $ANTLR start synpred29_EolParserRules
    public final void synpred29_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:254:4: ( ( '(' typeName ( ',' typeName )* ')' ) )
        // EolParserRules.g:254:4: ( '(' typeName ( ',' typeName )* ')' )
        {
        // EolParserRules.g:254:4: ( '(' typeName ( ',' typeName )* ')' )
        // EolParserRules.g:254:5: '(' typeName ( ',' typeName )* ')'
        {
        match(input,87,FOLLOW_87_in_synpred29_EolParserRules852); if (state.failed) return ;
        pushFollow(FOLLOW_typeName_in_synpred29_EolParserRules857);
        typeName();

        state._fsp--;
        if (state.failed) return ;
        // EolParserRules.g:254:50: ( ',' typeName )*
        loop71:
        do {
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==80) ) {
                alt71=1;
            }


            switch (alt71) {
        	case 1 :
        	    // EolParserRules.g:254:51: ',' typeName
        	    {
        	    match(input,80,FOLLOW_80_in_synpred29_EolParserRules862); if (state.failed) return ;
        	    pushFollow(FOLLOW_typeName_in_synpred29_EolParserRules866);
        	    typeName();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop71;
            }
        } while (true);

        match(input,88,FOLLOW_88_in_synpred29_EolParserRules874); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred29_EolParserRules

    // $ANTLR start synpred31_EolParserRules
    public final void synpred31_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:255:4: ( ( '<' typeName ( ',' typeName )* '>' ) )
        // EolParserRules.g:255:4: ( '<' typeName ( ',' typeName )* '>' )
        {
        // EolParserRules.g:255:4: ( '<' typeName ( ',' typeName )* '>' )
        // EolParserRules.g:255:5: '<' typeName ( ',' typeName )* '>'
        {
        match(input,103,FOLLOW_103_in_synpred31_EolParserRules886); if (state.failed) return ;
        pushFollow(FOLLOW_typeName_in_synpred31_EolParserRules891);
        typeName();

        state._fsp--;
        if (state.failed) return ;
        // EolParserRules.g:255:50: ( ',' typeName )*
        loop72:
        do {
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==80) ) {
                alt72=1;
            }


            switch (alt72) {
        	case 1 :
        	    // EolParserRules.g:255:51: ',' typeName
        	    {
        	    match(input,80,FOLLOW_80_in_synpred31_EolParserRules896); if (state.failed) return ;
        	    pushFollow(FOLLOW_typeName_in_synpred31_EolParserRules900);
        	    typeName();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop72;
            }
        } while (true);

        match(input,104,FOLLOW_104_in_synpred31_EolParserRules908); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred31_EolParserRules

    // $ANTLR start synpred32_EolParserRules
    public final void synpred32_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:260:4: ( statementA )
        // EolParserRules.g:260:4: statementA
        {
        pushFollow(FOLLOW_statementA_in_synpred32_EolParserRules927);
        statementA();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred32_EolParserRules

    // $ANTLR start synpred33_EolParserRules
    public final void synpred33_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:264:4: ( assignmentStatement )
        // EolParserRules.g:264:4: assignmentStatement
        {
        pushFollow(FOLLOW_assignmentStatement_in_synpred33_EolParserRules942);
        assignmentStatement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred33_EolParserRules

    // $ANTLR start synpred34_EolParserRules
    public final void synpred34_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:264:26: ( expressionStatement )
        // EolParserRules.g:264:26: expressionStatement
        {
        pushFollow(FOLLOW_expressionStatement_in_synpred34_EolParserRules946);
        expressionStatement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred34_EolParserRules

    // $ANTLR start synpred48_EolParserRules
    public final void synpred48_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:287:66: ( elseStatement )
        // EolParserRules.g:287:66: elseStatement
        {
        pushFollow(FOLLOW_elseStatement_in_synpred48_EolParserRules1101);
        elseStatement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred48_EolParserRules

    // $ANTLR start synpred57_EolParserRules
    public final void synpred57_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:375:22: ( NAME ( ',' NAME )* )
        // EolParserRules.g:375:22: NAME ( ',' NAME )*
        {
        match(input,NAME,FOLLOW_NAME_in_synpred57_EolParserRules1482); if (state.failed) return ;
        // EolParserRules.g:375:27: ( ',' NAME )*
        loop73:
        do {
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==80) ) {
                alt73=1;
            }


            switch (alt73) {
        	case 1 :
        	    // EolParserRules.g:375:28: ',' NAME
        	    {
        	    match(input,80,FOLLOW_80_in_synpred57_EolParserRules1485); if (state.failed) return ;
        	    match(input,NAME,FOLLOW_NAME_in_synpred57_EolParserRules1487); if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop73;
            }
        } while (true);


        }
    }
    // $ANTLR end synpred57_EolParserRules

    // $ANTLR start synpred59_EolParserRules
    public final void synpred59_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:391:5: ( postfixExpression '=' logicalExpression )
        // EolParserRules.g:391:5: postfixExpression '=' logicalExpression
        {
        pushFollow(FOLLOW_postfixExpression_in_synpred59_EolParserRules1557);
        postfixExpression();

        state._fsp--;
        if (state.failed) return ;
        match(input,84,FOLLOW_84_in_synpred59_EolParserRules1561); if (state.failed) return ;
        pushFollow(FOLLOW_logicalExpression_in_synpred59_EolParserRules1564);
        logicalExpression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred59_EolParserRules

    // $ANTLR start synpred70_EolParserRules
    public final void synpred70_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:400:24: ( ( '==' relationalExpression | '=' relationalExpression | ( '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression ) )
        // EolParserRules.g:400:24: ( '==' relationalExpression | '=' relationalExpression | ( '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression )
        {
        // EolParserRules.g:400:24: ( '==' relationalExpression | '=' relationalExpression | ( '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression )
        int alt74=3;
        switch ( input.LA(1) ) {
        case 127:
            {
            alt74=1;
            }
            break;
        case 84:
            {
            alt74=2;
            }
            break;
        case 103:
        case 104:
        case 128:
        case 129:
        case 130:
            {
            alt74=3;
            }
            break;
        default:
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 74, 0, input);

            throw nvae;
        }

        switch (alt74) {
            case 1 :
                // EolParserRules.g:400:25: '==' relationalExpression
                {
                match(input,127,FOLLOW_127_in_synpred70_EolParserRules1635); if (state.failed) return ;
                pushFollow(FOLLOW_relationalExpression_in_synpred70_EolParserRules1638);
                relationalExpression();

                state._fsp--;
                if (state.failed) return ;

                }
                break;
            case 2 :
                // EolParserRules.g:400:57: '=' relationalExpression
                {
                match(input,84,FOLLOW_84_in_synpred70_EolParserRules1644); if (state.failed) return ;
                pushFollow(FOLLOW_relationalExpression_in_synpred70_EolParserRules1647);
                relationalExpression();

                state._fsp--;
                if (state.failed) return ;

                }
                break;
            case 3 :
                // EolParserRules.g:401:24: ( '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression
                {
                if ( (input.LA(1)>=103 && input.LA(1)<=104)||(input.LA(1)>=128 && input.LA(1)<=130) ) {
                    input.consume();
                    state.errorRecovery=false;state.failed=false;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    MismatchedSetException mse = new MismatchedSetException(null,input);
                    throw mse;
                }

                pushFollow(FOLLOW_additiveExpression_in_synpred70_EolParserRules1701);
                additiveExpression();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        }
    }
    // $ANTLR end synpred70_EolParserRules

    // $ANTLR start synpred90_EolParserRules
    public final void synpred90_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:470:30: ( ':' ( 'new' )? typeName ( parameterList )? )
        // EolParserRules.g:470:30: ':' ( 'new' )? typeName ( parameterList )?
        {
        match(input,89,FOLLOW_89_in_synpred90_EolParserRules2061); if (state.failed) return ;
        // EolParserRules.g:470:36: ( 'new' )?
        int alt77=2;
        int LA77_0 = input.LA(1);

        if ( (LA77_0==139) ) {
            alt77=1;
        }
        switch (alt77) {
            case 1 :
                // EolParserRules.g:0:0: 'new'
                {
                match(input,139,FOLLOW_139_in_synpred90_EolParserRules2066); if (state.failed) return ;

                }
                break;

        }

        pushFollow(FOLLOW_typeName_in_synpred90_EolParserRules2072);
        typeName();

        state._fsp--;
        if (state.failed) return ;
        // EolParserRules.g:470:81: ( parameterList )?
        int alt78=2;
        int LA78_0 = input.LA(1);

        if ( (LA78_0==87) ) {
            alt78=1;
        }
        switch (alt78) {
            case 1 :
                // EolParserRules.g:0:0: parameterList
                {
                pushFollow(FOLLOW_parameterList_in_synpred90_EolParserRules2076);
                parameterList();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        }
    }
    // $ANTLR end synpred90_EolParserRules

    // $ANTLR start synpred98_EolParserRules
    public final void synpred98_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:496:4: ( expressionRange )
        // EolParserRules.g:496:4: expressionRange
        {
        pushFollow(FOLLOW_expressionRange_in_synpred98_EolParserRules2212);
        expressionRange();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred98_EolParserRules

    // $ANTLR start synpred104_EolParserRules
    public final void synpred104_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:522:67: ( featureCall )
        // EolParserRules.g:522:67: featureCall
        {
        pushFollow(FOLLOW_featureCall_in_synpred104_EolParserRules2332);
        featureCall();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred104_EolParserRules

    // $ANTLR start synpred105_EolParserRules
    public final void synpred105_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:522:81: ( pathName )
        // EolParserRules.g:522:81: pathName
        {
        pushFollow(FOLLOW_pathName_in_synpred105_EolParserRules2336);
        pathName();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred105_EolParserRules

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
    public final boolean synpred48_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred48_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred70_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred70_EolParserRules_fragment(); // can never throw exception
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
    public final boolean synpred104_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred104_EolParserRules_fragment(); // can never throw exception
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
    public final boolean synpred105_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred105_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred90_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred90_EolParserRules_fragment(); // can never throw exception
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
    public final boolean synpred59_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred59_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred33_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred33_EolParserRules_fragment(); // can never throw exception
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


    protected DFA22 dfa22 = new DFA22(this);
    protected DFA23 dfa23 = new DFA23(this);
    protected DFA24 dfa24 = new DFA24(this);
    protected DFA37 dfa37 = new DFA37(this);
    protected DFA39 dfa39 = new DFA39(this);
    protected DFA44 dfa44 = new DFA44(this);
    protected DFA54 dfa54 = new DFA54(this);
    protected DFA63 dfa63 = new DFA63(this);
    protected DFA67 dfa67 = new DFA67(this);
    protected DFA70 dfa70 = new DFA70(this);
    static final String DFA22_eotS =
        "\77\uffff";
    static final String DFA22_eofS =
        "\1\3\76\uffff";
    static final String DFA22_minS =
        "\1\4\2\0\74\uffff";
    static final String DFA22_maxS =
        "\1\u008d\2\0\74\uffff";
    static final String DFA22_acceptS =
        "\3\uffff\1\3\71\uffff\1\1\1\2";
    static final String DFA22_specialS =
        "\1\uffff\1\0\1\1\74\uffff}>";
    static final String[] DFA22_transitionS = {
            "\1\3\3\uffff\5\3\1\uffff\1\3\4\uffff\1\3\3\uffff\1\3\66\uffff"+
            "\1\3\1\uffff\1\3\1\uffff\5\3\1\1\2\3\1\uffff\1\3\3\uffff\10"+
            "\3\1\2\5\3\3\uffff\36\3",
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
            return "254:3: ( (op= '(' tn= typeName ( ',' tn= typeName )* cp= ')' ) | (op= '<' tn= typeName ( ',' tn= typeName )* cp= '>' ) )?";
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
                        if ( (synpred29_EolParserRules()) ) {s = 61;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index22_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA22_2 = input.LA(1);

                         
                        int index22_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_EolParserRules()) ) {s = 62;}

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
        "\35\uffff";
    static final String DFA23_eofS =
        "\35\uffff";
    static final String DFA23_minS =
        "\1\4\24\uffff\1\0\7\uffff";
    static final String DFA23_maxS =
        "\1\u008d\24\uffff\1\0\7\uffff";
    static final String DFA23_acceptS =
        "\1\uffff\1\1\25\uffff\1\2\5\uffff";
    static final String DFA23_specialS =
        "\25\uffff\1\0\7\uffff}>";
    static final String[] DFA23_transitionS = {
            "\1\1\3\uffff\1\1\3\uffff\1\1\1\uffff\1\1\4\uffff\1\1\103\uffff"+
            "\1\1\7\uffff\10\1\2\uffff\1\1\1\uffff\2\1\3\uffff\1\1\1\25\2"+
            "\27\1\1\4\27\13\uffff\1\1\2\uffff\1\1\3\uffff\3\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
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
            return "259:1: statement : ( statementA | statementB );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA23_21 = input.LA(1);

                         
                        int index23_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred32_EolParserRules()) ) {s = 1;}

                        else if ( (true) ) {s = 23;}

                         
                        input.seek(index23_21);
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
        "\31\uffff";
    static final String DFA24_eofS =
        "\31\uffff";
    static final String DFA24_minS =
        "\1\4\20\0\10\uffff";
    static final String DFA24_maxS =
        "\1\u008d\20\0\10\uffff";
    static final String DFA24_acceptS =
        "\21\uffff\1\3\1\4\1\5\1\6\1\7\1\10\1\1\1\2";
    static final String DFA24_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14"+
        "\1\15\1\16\1\17\10\uffff}>";
    static final String[] DFA24_transitionS = {
            "\1\12\3\uffff\1\12\3\uffff\1\12\1\uffff\1\12\4\uffff\1\13\103"+
            "\uffff\1\15\7\uffff\1\14\1\3\1\4\1\5\1\6\1\7\1\10\1\11\2\uffff"+
            "\1\21\1\uffff\1\22\1\24\3\uffff\1\23\1\25\2\uffff\1\26\17\uffff"+
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
            return "263:1: statementA : ( assignmentStatement | expressionStatement | forStatement | ifStatement | whileStatement | switchStatement | returnStatement | breakStatement );";
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
                        if ( (synpred33_EolParserRules()) ) {s = 23;}

                        else if ( (synpred34_EolParserRules()) ) {s = 24;}

                         
                        input.seek(index24_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA24_2 = input.LA(1);

                         
                        int index24_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_EolParserRules()) ) {s = 23;}

                        else if ( (synpred34_EolParserRules()) ) {s = 24;}

                         
                        input.seek(index24_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA24_3 = input.LA(1);

                         
                        int index24_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_EolParserRules()) ) {s = 23;}

                        else if ( (synpred34_EolParserRules()) ) {s = 24;}

                         
                        input.seek(index24_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA24_4 = input.LA(1);

                         
                        int index24_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_EolParserRules()) ) {s = 23;}

                        else if ( (synpred34_EolParserRules()) ) {s = 24;}

                         
                        input.seek(index24_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA24_5 = input.LA(1);

                         
                        int index24_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_EolParserRules()) ) {s = 23;}

                        else if ( (synpred34_EolParserRules()) ) {s = 24;}

                         
                        input.seek(index24_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA24_6 = input.LA(1);

                         
                        int index24_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_EolParserRules()) ) {s = 23;}

                        else if ( (synpred34_EolParserRules()) ) {s = 24;}

                         
                        input.seek(index24_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA24_7 = input.LA(1);

                         
                        int index24_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_EolParserRules()) ) {s = 23;}

                        else if ( (synpred34_EolParserRules()) ) {s = 24;}

                         
                        input.seek(index24_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA24_8 = input.LA(1);

                         
                        int index24_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_EolParserRules()) ) {s = 23;}

                        else if ( (synpred34_EolParserRules()) ) {s = 24;}

                         
                        input.seek(index24_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA24_9 = input.LA(1);

                         
                        int index24_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_EolParserRules()) ) {s = 23;}

                        else if ( (synpred34_EolParserRules()) ) {s = 24;}

                         
                        input.seek(index24_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA24_10 = input.LA(1);

                         
                        int index24_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_EolParserRules()) ) {s = 23;}

                        else if ( (synpred34_EolParserRules()) ) {s = 24;}

                         
                        input.seek(index24_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA24_11 = input.LA(1);

                         
                        int index24_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_EolParserRules()) ) {s = 23;}

                        else if ( (synpred34_EolParserRules()) ) {s = 24;}

                         
                        input.seek(index24_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA24_12 = input.LA(1);

                         
                        int index24_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_EolParserRules()) ) {s = 23;}

                        else if ( (synpred34_EolParserRules()) ) {s = 24;}

                         
                        input.seek(index24_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA24_13 = input.LA(1);

                         
                        int index24_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_EolParserRules()) ) {s = 23;}

                        else if ( (synpred34_EolParserRules()) ) {s = 24;}

                         
                        input.seek(index24_13);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA24_14 = input.LA(1);

                         
                        int index24_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_EolParserRules()) ) {s = 23;}

                        else if ( (synpred34_EolParserRules()) ) {s = 24;}

                         
                        input.seek(index24_14);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA24_15 = input.LA(1);

                         
                        int index24_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_EolParserRules()) ) {s = 23;}

                        else if ( (synpred34_EolParserRules()) ) {s = 24;}

                         
                        input.seek(index24_15);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA24_16 = input.LA(1);

                         
                        int index24_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_EolParserRules()) ) {s = 23;}

                        else if ( (synpred34_EolParserRules()) ) {s = 24;}

                         
                        input.seek(index24_16);
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
        "\37\uffff";
    static final String DFA37_eofS =
        "\37\uffff";
    static final String DFA37_minS =
        "\1\4\1\0\35\uffff";
    static final String DFA37_maxS =
        "\1\u008d\1\0\35\uffff";
    static final String DFA37_acceptS =
        "\2\uffff\1\2\33\uffff\1\1";
    static final String DFA37_specialS =
        "\1\uffff\1\0\35\uffff}>";
    static final String[] DFA37_transitionS = {
            "\1\2\3\uffff\1\2\3\uffff\1\2\1\uffff\1\2\4\uffff\1\1\76\uffff"+
            "\1\2\4\uffff\1\2\7\uffff\10\2\2\uffff\1\2\1\uffff\2\2\3\uffff"+
            "\11\2\13\uffff\1\2\2\uffff\1\2\3\uffff\3\2",
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
            return "375:21: ( NAME ( ',' NAME )* )?";
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
                        if ( (synpred57_EolParserRules()) ) {s = 30;}

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
    static final String DFA39_eotS =
        "\22\uffff";
    static final String DFA39_eofS =
        "\22\uffff";
    static final String DFA39_minS =
        "\1\4\16\0\3\uffff";
    static final String DFA39_maxS =
        "\1\u008d\16\0\3\uffff";
    static final String DFA39_acceptS =
        "\17\uffff\1\2\1\uffff\1\1";
    static final String DFA39_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14"+
        "\1\15\3\uffff}>";
    static final String[] DFA39_transitionS = {
            "\1\10\3\uffff\1\10\3\uffff\1\10\1\uffff\1\10\4\uffff\1\11\103"+
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

    static final short[] DFA39_eot = DFA.unpackEncodedString(DFA39_eotS);
    static final short[] DFA39_eof = DFA.unpackEncodedString(DFA39_eofS);
    static final char[] DFA39_min = DFA.unpackEncodedStringToUnsignedChars(DFA39_minS);
    static final char[] DFA39_max = DFA.unpackEncodedStringToUnsignedChars(DFA39_maxS);
    static final short[] DFA39_accept = DFA.unpackEncodedString(DFA39_acceptS);
    static final short[] DFA39_special = DFA.unpackEncodedString(DFA39_specialS);
    static final short[][] DFA39_transition;

    static {
        int numStates = DFA39_transitionS.length;
        DFA39_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA39_transition[i] = DFA.unpackEncodedString(DFA39_transitionS[i]);
        }
    }

    class DFA39 extends DFA {

        public DFA39(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 39;
            this.eot = DFA39_eot;
            this.eof = DFA39_eof;
            this.min = DFA39_min;
            this.max = DFA39_max;
            this.accept = DFA39_accept;
            this.special = DFA39_special;
            this.transition = DFA39_transition;
        }
        public String getDescription() {
            return "391:4: ( postfixExpression op= '=' logicalExpression | logicalExpression )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA39_1 = input.LA(1);

                         
                        int index39_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred59_EolParserRules()) ) {s = 17;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index39_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA39_2 = input.LA(1);

                         
                        int index39_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred59_EolParserRules()) ) {s = 17;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index39_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA39_3 = input.LA(1);

                         
                        int index39_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred59_EolParserRules()) ) {s = 17;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index39_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA39_4 = input.LA(1);

                         
                        int index39_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred59_EolParserRules()) ) {s = 17;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index39_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA39_5 = input.LA(1);

                         
                        int index39_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred59_EolParserRules()) ) {s = 17;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index39_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA39_6 = input.LA(1);

                         
                        int index39_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred59_EolParserRules()) ) {s = 17;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index39_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA39_7 = input.LA(1);

                         
                        int index39_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred59_EolParserRules()) ) {s = 17;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index39_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA39_8 = input.LA(1);

                         
                        int index39_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred59_EolParserRules()) ) {s = 17;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index39_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA39_9 = input.LA(1);

                         
                        int index39_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred59_EolParserRules()) ) {s = 17;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index39_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA39_10 = input.LA(1);

                         
                        int index39_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred59_EolParserRules()) ) {s = 17;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index39_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA39_11 = input.LA(1);

                         
                        int index39_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred59_EolParserRules()) ) {s = 17;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index39_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA39_12 = input.LA(1);

                         
                        int index39_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred59_EolParserRules()) ) {s = 17;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index39_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA39_13 = input.LA(1);

                         
                        int index39_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred59_EolParserRules()) ) {s = 17;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index39_13);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA39_14 = input.LA(1);

                         
                        int index39_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred59_EolParserRules()) ) {s = 17;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index39_14);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 39, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA44_eotS =
        "\12\uffff";
    static final String DFA44_eofS =
        "\1\1\11\uffff";
    static final String DFA44_minS =
        "\1\4\1\uffff\7\0\1\uffff";
    static final String DFA44_maxS =
        "\1\u008d\1\uffff\7\0\1\uffff";
    static final String DFA44_acceptS =
        "\1\uffff\1\2\7\uffff\1\1";
    static final String DFA44_specialS =
        "\2\uffff\1\1\1\3\1\2\1\6\1\0\1\5\1\4\1\uffff}>";
    static final String[] DFA44_transitionS = {
            "\1\1\3\uffff\1\1\1\uffff\1\1\1\uffff\1\1\1\uffff\1\1\4\uffff"+
            "\1\1\3\uffff\1\1\66\uffff\1\1\1\uffff\1\1\2\uffff\1\1\1\3\5"+
            "\1\1\uffff\1\1\3\uffff\10\1\1\5\1\4\1\1\1\uffff\2\1\3\uffff"+
            "\17\1\1\2\1\6\1\7\1\10\1\uffff\1\1\2\uffff\1\1\1\uffff\1\1\1"+
            "\uffff\3\1",
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

    static final short[] DFA44_eot = DFA.unpackEncodedString(DFA44_eotS);
    static final short[] DFA44_eof = DFA.unpackEncodedString(DFA44_eofS);
    static final char[] DFA44_min = DFA.unpackEncodedStringToUnsignedChars(DFA44_minS);
    static final char[] DFA44_max = DFA.unpackEncodedStringToUnsignedChars(DFA44_maxS);
    static final short[] DFA44_accept = DFA.unpackEncodedString(DFA44_acceptS);
    static final short[] DFA44_special = DFA.unpackEncodedString(DFA44_specialS);
    static final short[][] DFA44_transition;

    static {
        int numStates = DFA44_transitionS.length;
        DFA44_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA44_transition[i] = DFA.unpackEncodedString(DFA44_transitionS[i]);
        }
    }

    class DFA44 extends DFA {

        public DFA44(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 44;
            this.eot = DFA44_eot;
            this.eof = DFA44_eof;
            this.min = DFA44_min;
            this.max = DFA44_max;
            this.accept = DFA44_accept;
            this.special = DFA44_special;
            this.transition = DFA44_transition;
        }
        public String getDescription() {
            return "()* loopback of 400:23: ( (op= '==' relationalExpression | op= '=' relationalExpression | (op= '>' | op= '<' | op= '>=' | op= '<=' | op= '<>' ) additiveExpression ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA44_6 = input.LA(1);

                         
                        int index44_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred70_EolParserRules()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index44_6);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA44_2 = input.LA(1);

                         
                        int index44_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred70_EolParserRules()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index44_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA44_4 = input.LA(1);

                         
                        int index44_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred70_EolParserRules()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index44_4);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA44_3 = input.LA(1);

                         
                        int index44_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred70_EolParserRules()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index44_3);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA44_8 = input.LA(1);

                         
                        int index44_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred70_EolParserRules()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index44_8);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA44_7 = input.LA(1);

                         
                        int index44_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred70_EolParserRules()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index44_7);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA44_5 = input.LA(1);

                         
                        int index44_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred70_EolParserRules()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index44_5);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 44, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA54_eotS =
        "\10\uffff";
    static final String DFA54_eofS =
        "\1\uffff\1\3\6\uffff";
    static final String DFA54_minS =
        "\1\23\2\4\1\uffff\1\11\1\4\1\uffff\1\11";
    static final String DFA54_maxS =
        "\1\23\2\u008d\1\uffff\1\u008a\1\u008d\1\uffff\1\u008a";
    static final String DFA54_acceptS =
        "\3\uffff\1\1\2\uffff\1\2\1\uffff";
    static final String DFA54_specialS =
        "\10\uffff}>";
    static final String[] DFA54_transitionS = {
            "\1\1",
            "\1\3\3\uffff\5\3\1\uffff\1\3\4\uffff\1\3\3\uffff\1\3\66\uffff"+
            "\1\3\1\uffff\1\3\2\uffff\4\3\1\2\2\3\1\uffff\1\3\3\uffff\13"+
            "\3\1\uffff\2\3\3\uffff\32\3\1\uffff\3\3",
            "\1\3\3\uffff\1\3\3\uffff\1\3\1\uffff\1\3\4\uffff\1\4\103\uffff"+
            "\2\3\6\uffff\10\3\35\uffff\1\3\2\uffff\1\3\3\uffff\3\3",
            "",
            "\1\3\1\uffff\1\3\104\uffff\1\5\3\uffff\1\3\2\uffff\2\3\1\6\2"+
            "\uffff\3\3\10\uffff\2\3\22\uffff\14\3\1\uffff\1\3\1\uffff\1"+
            "\6",
            "\1\3\3\uffff\1\3\3\uffff\1\3\1\uffff\1\3\4\uffff\1\7\103\uffff"+
            "\1\3\7\uffff\10\3\35\uffff\1\3\2\uffff\1\3\3\uffff\3\3",
            "",
            "\1\3\1\uffff\1\3\104\uffff\1\5\3\uffff\1\3\2\uffff\2\3\1\6\2"+
            "\uffff\3\3\10\uffff\2\3\22\uffff\14\3\1\uffff\1\3\1\uffff\1"+
            "\6"
    };

    static final short[] DFA54_eot = DFA.unpackEncodedString(DFA54_eotS);
    static final short[] DFA54_eof = DFA.unpackEncodedString(DFA54_eofS);
    static final char[] DFA54_min = DFA.unpackEncodedStringToUnsignedChars(DFA54_minS);
    static final char[] DFA54_max = DFA.unpackEncodedStringToUnsignedChars(DFA54_maxS);
    static final short[] DFA54_accept = DFA.unpackEncodedString(DFA54_acceptS);
    static final short[] DFA54_special = DFA.unpackEncodedString(DFA54_specialS);
    static final short[][] DFA54_transition;

    static {
        int numStates = DFA54_transitionS.length;
        DFA54_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA54_transition[i] = DFA.unpackEncodedString(DFA54_transitionS[i]);
        }
    }

    class DFA54 extends DFA {

        public DFA54(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 54;
            this.eot = DFA54_eot;
            this.eof = DFA54_eof;
            this.min = DFA54_min;
            this.max = DFA54_max;
            this.accept = DFA54_accept;
            this.special = DFA54_special;
            this.transition = DFA54_transition;
        }
        public String getDescription() {
            return "430:1: featureCall : ( simpleFeatureCall | declarativeFeatureCall );";
        }
    }
    static final String DFA63_eotS =
        "\27\uffff";
    static final String DFA63_eofS =
        "\2\2\25\uffff";
    static final String DFA63_minS =
        "\2\4\1\uffff\10\0\1\127\1\23\1\uffff\1\16\1\0\1\127\1\0\1\130\1"+
        "\16\1\0\1\130\1\0";
    static final String DFA63_maxS =
        "\2\u008d\1\uffff\10\0\1\127\1\146\1\uffff\1\16\1\0\1\127\1\0\1\130"+
        "\1\16\1\0\1\130\1\0";
    static final String DFA63_acceptS =
        "\2\uffff\1\2\12\uffff\1\1\11\uffff";
    static final String DFA63_specialS =
        "\3\uffff\1\6\1\7\1\3\1\5\1\13\1\12\1\1\1\2\4\uffff\1\10\1\uffff"+
        "\1\4\2\uffff\1\11\1\uffff\1\0}>";
    static final String[] DFA63_transitionS = {
            "\1\2\3\uffff\5\2\1\uffff\1\2\4\uffff\1\2\3\uffff\1\2\66\uffff"+
            "\1\2\1\uffff\1\2\2\uffff\6\2\1\1\1\uffff\1\2\3\uffff\13\2\1"+
            "\uffff\2\2\3\uffff\32\2\1\uffff\3\2",
            "\1\2\3\uffff\1\2\3\uffff\1\2\1\uffff\1\2\4\uffff\1\12\76\uffff"+
            "\2\2\3\uffff\1\2\7\uffff\1\13\1\3\1\4\1\5\1\6\1\7\1\10\1\11"+
            "\2\uffff\1\2\1\uffff\4\2\1\uffff\11\2\13\uffff\1\2\2\uffff\1"+
            "\2\3\uffff\1\14\2\2",
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
            "\1\17\113\uffff\1\20\7\21",
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

    static final short[] DFA63_eot = DFA.unpackEncodedString(DFA63_eotS);
    static final short[] DFA63_eof = DFA.unpackEncodedString(DFA63_eofS);
    static final char[] DFA63_min = DFA.unpackEncodedStringToUnsignedChars(DFA63_minS);
    static final char[] DFA63_max = DFA.unpackEncodedStringToUnsignedChars(DFA63_maxS);
    static final short[] DFA63_accept = DFA.unpackEncodedString(DFA63_acceptS);
    static final short[] DFA63_special = DFA.unpackEncodedString(DFA63_specialS);
    static final short[][] DFA63_transition;

    static {
        int numStates = DFA63_transitionS.length;
        DFA63_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA63_transition[i] = DFA.unpackEncodedString(DFA63_transitionS[i]);
        }
    }

    class DFA63 extends DFA {

        public DFA63(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 63;
            this.eot = DFA63_eot;
            this.eof = DFA63_eof;
            this.min = DFA63_min;
            this.max = DFA63_max;
            this.accept = DFA63_accept;
            this.special = DFA63_special;
            this.transition = DFA63_transition;
        }
        public String getDescription() {
            return "470:29: ( ':' (n= 'new' )? t= typeName ( parameterList )? )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA63_22 = input.LA(1);

                         
                        int index63_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_EolParserRules()) ) {s = 13;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index63_22);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA63_9 = input.LA(1);

                         
                        int index63_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_EolParserRules()) ) {s = 13;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index63_9);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA63_10 = input.LA(1);

                         
                        int index63_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_EolParserRules()) ) {s = 13;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index63_10);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA63_5 = input.LA(1);

                         
                        int index63_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_EolParserRules()) ) {s = 13;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index63_5);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA63_17 = input.LA(1);

                         
                        int index63_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_EolParserRules()) ) {s = 13;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index63_17);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA63_6 = input.LA(1);

                         
                        int index63_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_EolParserRules()) ) {s = 13;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index63_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA63_3 = input.LA(1);

                         
                        int index63_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_EolParserRules()) ) {s = 13;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index63_3);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA63_4 = input.LA(1);

                         
                        int index63_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_EolParserRules()) ) {s = 13;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index63_4);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA63_15 = input.LA(1);

                         
                        int index63_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_EolParserRules()) ) {s = 13;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index63_15);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA63_20 = input.LA(1);

                         
                        int index63_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_EolParserRules()) ) {s = 13;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index63_20);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA63_8 = input.LA(1);

                         
                        int index63_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_EolParserRules()) ) {s = 13;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index63_8);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA63_7 = input.LA(1);

                         
                        int index63_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_EolParserRules()) ) {s = 13;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index63_7);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 63, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA67_eotS =
        "\23\uffff";
    static final String DFA67_eofS =
        "\23\uffff";
    static final String DFA67_minS =
        "\1\4\20\0\2\uffff";
    static final String DFA67_maxS =
        "\1\u008d\20\0\2\uffff";
    static final String DFA67_acceptS =
        "\21\uffff\1\1\1\2";
    static final String DFA67_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14"+
        "\1\15\1\16\1\17\2\uffff}>";
    static final String[] DFA67_transitionS = {
            "\1\12\3\uffff\1\12\3\uffff\1\12\1\uffff\1\12\4\uffff\1\13\103"+
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
            return "495:1: expressionListOrRange : ( expressionRange | expressionList );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA67_1 = input.LA(1);

                         
                        int index67_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred98_EolParserRules()) ) {s = 17;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index67_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA67_2 = input.LA(1);

                         
                        int index67_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred98_EolParserRules()) ) {s = 17;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index67_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA67_3 = input.LA(1);

                         
                        int index67_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred98_EolParserRules()) ) {s = 17;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index67_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA67_4 = input.LA(1);

                         
                        int index67_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred98_EolParserRules()) ) {s = 17;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index67_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA67_5 = input.LA(1);

                         
                        int index67_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred98_EolParserRules()) ) {s = 17;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index67_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA67_6 = input.LA(1);

                         
                        int index67_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred98_EolParserRules()) ) {s = 17;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index67_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA67_7 = input.LA(1);

                         
                        int index67_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred98_EolParserRules()) ) {s = 17;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index67_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA67_8 = input.LA(1);

                         
                        int index67_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred98_EolParserRules()) ) {s = 17;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index67_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA67_9 = input.LA(1);

                         
                        int index67_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred98_EolParserRules()) ) {s = 17;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index67_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA67_10 = input.LA(1);

                         
                        int index67_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred98_EolParserRules()) ) {s = 17;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index67_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA67_11 = input.LA(1);

                         
                        int index67_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred98_EolParserRules()) ) {s = 17;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index67_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA67_12 = input.LA(1);

                         
                        int index67_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred98_EolParserRules()) ) {s = 17;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index67_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA67_13 = input.LA(1);

                         
                        int index67_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred98_EolParserRules()) ) {s = 17;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index67_13);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA67_14 = input.LA(1);

                         
                        int index67_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred98_EolParserRules()) ) {s = 17;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index67_14);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA67_15 = input.LA(1);

                         
                        int index67_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred98_EolParserRules()) ) {s = 17;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index67_15);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA67_16 = input.LA(1);

                         
                        int index67_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred98_EolParserRules()) ) {s = 17;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index67_16);
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
    static final String DFA70_eotS =
        "\23\uffff";
    static final String DFA70_eofS =
        "\1\uffff\7\16\13\uffff";
    static final String DFA70_minS =
        "\10\4\1\uffff\1\0\11\uffff";
    static final String DFA70_maxS =
        "\10\u008d\1\uffff\1\0\11\uffff";
    static final String DFA70_acceptS =
        "\10\uffff\1\3\1\uffff\1\6\1\10\1\11\1\12\1\7\1\1\1\2\1\4\1\5";
    static final String DFA70_specialS =
        "\11\uffff\1\0\11\uffff}>";
    static final String[] DFA70_transitionS = {
            "\1\10\3\uffff\1\10\3\uffff\1\10\1\uffff\1\10\4\uffff\1\11\103"+
            "\uffff\1\13\7\uffff\1\12\1\1\1\2\1\3\1\4\1\5\1\6\1\7\44\uffff"+
            "\1\14\2\15",
            "\1\16\3\uffff\5\16\1\uffff\1\16\4\uffff\1\16\3\uffff\1\16\66"+
            "\uffff\1\16\1\uffff\1\16\1\uffff\1\17\7\16\1\uffff\1\16\3\uffff"+
            "\13\16\1\uffff\2\16\3\uffff\32\16\1\uffff\3\16",
            "\1\16\3\uffff\5\16\1\uffff\1\16\4\uffff\1\16\3\uffff\1\16\66"+
            "\uffff\1\16\1\uffff\1\16\1\uffff\1\17\7\16\1\uffff\1\16\3\uffff"+
            "\13\16\1\uffff\2\16\3\uffff\32\16\1\uffff\3\16",
            "\1\16\3\uffff\5\16\1\uffff\1\16\4\uffff\1\16\3\uffff\1\16\66"+
            "\uffff\1\16\1\uffff\1\16\1\uffff\1\17\7\16\1\uffff\1\16\3\uffff"+
            "\13\16\1\uffff\2\16\3\uffff\32\16\1\uffff\3\16",
            "\1\16\3\uffff\5\16\1\uffff\1\16\4\uffff\1\16\3\uffff\1\16\66"+
            "\uffff\1\16\1\uffff\1\16\1\uffff\1\17\7\16\1\uffff\1\16\3\uffff"+
            "\13\16\1\uffff\2\16\3\uffff\32\16\1\uffff\3\16",
            "\1\16\3\uffff\5\16\1\uffff\1\16\4\uffff\1\16\3\uffff\1\16\66"+
            "\uffff\1\16\1\uffff\1\16\1\uffff\1\17\7\16\1\uffff\1\16\3\uffff"+
            "\13\16\1\uffff\2\16\3\uffff\32\16\1\uffff\3\16",
            "\1\16\3\uffff\5\16\1\uffff\1\16\4\uffff\1\16\3\uffff\1\16\66"+
            "\uffff\1\16\1\uffff\1\16\1\uffff\1\17\7\16\1\uffff\1\16\3\uffff"+
            "\13\16\1\uffff\2\16\3\uffff\32\16\1\uffff\3\16",
            "\1\16\3\uffff\5\16\1\uffff\1\16\4\uffff\1\16\3\uffff\1\16\66"+
            "\uffff\1\16\1\uffff\1\16\1\uffff\1\20\7\16\1\uffff\1\16\3\uffff"+
            "\13\16\1\uffff\2\16\3\uffff\32\16\1\uffff\3\16",
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

    static final short[] DFA70_eot = DFA.unpackEncodedString(DFA70_eotS);
    static final short[] DFA70_eof = DFA.unpackEncodedString(DFA70_eofS);
    static final char[] DFA70_min = DFA.unpackEncodedStringToUnsignedChars(DFA70_minS);
    static final char[] DFA70_max = DFA.unpackEncodedStringToUnsignedChars(DFA70_maxS);
    static final short[] DFA70_accept = DFA.unpackEncodedString(DFA70_acceptS);
    static final short[] DFA70_special = DFA.unpackEncodedString(DFA70_specialS);
    static final short[][] DFA70_transition;

    static {
        int numStates = DFA70_transitionS.length;
        DFA70_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA70_transition[i] = DFA.unpackEncodedString(DFA70_transitionS[i]);
        }
    }

    class DFA70 extends DFA {

        public DFA70(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 70;
            this.eot = DFA70_eot;
            this.eof = DFA70_eof;
            this.min = DFA70_min;
            this.max = DFA70_max;
            this.accept = DFA70_accept;
            this.special = DFA70_special;
            this.transition = DFA70_transition;
        }
        public String getDescription() {
            return "521:1: primitiveExpression : ( literalSequentialCollection | literalMapCollection | literal | featureCall | pathName | nativeType | collectionType | logicalExpressionInBrackets | newExpression | variableDeclarationExpression );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA70_9 = input.LA(1);

                         
                        int index70_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred104_EolParserRules()) ) {s = 17;}

                        else if ( (synpred105_EolParserRules()) ) {s = 18;}

                         
                        input.seek(index70_9);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 70, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_operationDeclaration_in_operationDeclarationOrAnnotationBlock250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationBlock_in_operationDeclarationOrAnnotationBlock252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_modelDeclaration271 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_modelDeclaration274 = new BitSet(new long[]{0x0000000000000000L,0x000000000006C000L});
    public static final BitSet FOLLOW_modelAlias_in_modelDeclaration276 = new BitSet(new long[]{0x0000000000000000L,0x0000000000064000L});
    public static final BitSet FOLLOW_modelDriver_in_modelDeclaration279 = new BitSet(new long[]{0x0000000000000000L,0x0000000000044000L});
    public static final BitSet FOLLOW_modelDeclarationParameters_in_modelDeclaration282 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_modelDeclaration287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_modelAlias302 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_modelAlias305 = new BitSet(new long[]{0x0000000000000002L,0x0000000000010000L});
    public static final BitSet FOLLOW_80_in_modelAlias308 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_modelAlias311 = new BitSet(new long[]{0x0000000000000002L,0x0000000000010000L});
    public static final BitSet FOLLOW_81_in_modelDriver330 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_modelDriver333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_modelDeclarationParameters355 = new BitSet(new long[]{0x0000000000080000L,0x0000000000090000L});
    public static final BitSet FOLLOW_modelDeclarationParameter_in_modelDeclarationParameters358 = new BitSet(new long[]{0x0000000000000000L,0x0000000000090000L});
    public static final BitSet FOLLOW_80_in_modelDeclarationParameters362 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_modelDeclarationParameter_in_modelDeclarationParameters365 = new BitSet(new long[]{0x0000000000000000L,0x0000000000090000L});
    public static final BitSet FOLLOW_83_in_modelDeclarationParameters371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_modelDeclarationParameter384 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_84_in_modelDeclarationParameter388 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_STRING_in_modelDeclarationParameter391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_operationDeclaration412 = new BitSet(new long[]{0x0000000000080000L,0x0000007F80000000L});
    public static final BitSet FOLLOW_typeName_in_operationDeclaration422 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_operationDeclaration430 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_87_in_operationDeclaration434 = new BitSet(new long[]{0x0000000000080000L,0x0000000001000000L});
    public static final BitSet FOLLOW_formalParameterList_in_operationDeclaration437 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_88_in_operationDeclaration442 = new BitSet(new long[]{0x0000000000000000L,0x0000000002040000L});
    public static final BitSet FOLLOW_89_in_operationDeclaration446 = new BitSet(new long[]{0x0000000000080000L,0x0000007F80000000L});
    public static final BitSet FOLLOW_typeName_in_operationDeclaration451 = new BitSet(new long[]{0x0000000000000000L,0x0000000002040000L});
    public static final BitSet FOLLOW_statementBlock_in_operationDeclaration457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_90_in_importStatement477 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_STRING_in_importStatement480 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_importStatement484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_block504 = new BitSet(new long[]{0x0000000000085112L,0x01FF1A7F80800000L,0x0000000000003890L});
    public static final BitSet FOLLOW_82_in_statementBlock533 = new BitSet(new long[]{0x0000000000085110L,0x01FF1A7F80800000L,0x0000000000003890L});
    public static final BitSet FOLLOW_block_in_statementBlock536 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_83_in_statementBlock540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_formalParameter558 = new BitSet(new long[]{0x0000000000000002L,0x0000000002000000L});
    public static final BitSet FOLLOW_89_in_formalParameter561 = new BitSet(new long[]{0x0000000000080000L,0x0000007F80000000L});
    public static final BitSet FOLLOW_typeName_in_formalParameter565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_formalParameter_in_formalParameterList599 = new BitSet(new long[]{0x0000000000000002L,0x0000000000010000L});
    public static final BitSet FOLLOW_80_in_formalParameterList602 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_formalParameter_in_formalParameterList604 = new BitSet(new long[]{0x0000000000000002L,0x0000000000010000L});
    public static final BitSet FOLLOW_91_in_executableAnnotation629 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0xFFFFFFFFFFFFFFFFL,0x0000000000003FFFL});
    public static final BitSet FOLLOW_logicalExpression_in_executableAnnotation636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Annotation_in_annotation650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_executableAnnotation_in_annotation652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotation_in_annotationBlock669 = new BitSet(new long[]{0x0000000000800002L,0x0000000008000000L});
    public static final BitSet FOLLOW_pathName_in_typeName698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nativeType_in_typeName702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectionType_in_typeName706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_pathName720 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_92_in_pathName722 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_packagedType_in_pathName731 = new BitSet(new long[]{0x0000000000000002L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_pathName737 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_pathName742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_packagedType763 = new BitSet(new long[]{0x0000000000000002L,0x0000000040000000L});
    public static final BitSet FOLLOW_94_in_packagedType766 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_packagedType771 = new BitSet(new long[]{0x0000000000000002L,0x0000000040000000L});
    public static final BitSet FOLLOW_95_in_nativeType799 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_87_in_nativeType804 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_STRING_in_nativeType807 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_88_in_nativeType811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_collectionType829 = new BitSet(new long[]{0x0000000000000002L,0x0000008000800000L});
    public static final BitSet FOLLOW_87_in_collectionType852 = new BitSet(new long[]{0x0000000000080000L,0x0000007F80000000L});
    public static final BitSet FOLLOW_typeName_in_collectionType857 = new BitSet(new long[]{0x0000000000000000L,0x0000000001010000L});
    public static final BitSet FOLLOW_80_in_collectionType862 = new BitSet(new long[]{0x0000000000080000L,0x0000007F80000000L});
    public static final BitSet FOLLOW_typeName_in_collectionType866 = new BitSet(new long[]{0x0000000000000000L,0x0000000001010000L});
    public static final BitSet FOLLOW_88_in_collectionType874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_103_in_collectionType886 = new BitSet(new long[]{0x0000000000080000L,0x0000007F80000000L});
    public static final BitSet FOLLOW_typeName_in_collectionType891 = new BitSet(new long[]{0x0000000000000000L,0x0000010000010000L});
    public static final BitSet FOLLOW_80_in_collectionType896 = new BitSet(new long[]{0x0000000000080000L,0x0000007F80000000L});
    public static final BitSet FOLLOW_typeName_in_collectionType900 = new BitSet(new long[]{0x0000000000000000L,0x0000010000010000L});
    public static final BitSet FOLLOW_104_in_collectionType908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementA_in_statement927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementB_in_statement931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignmentStatement_in_statementA942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionStatement_in_statementA946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_forStatement_in_statementA950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStatement_in_statementA956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_whileStatement_in_statementA960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_switchStatement_in_statementA964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_returnStatement_in_statementA968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_breakStatement_in_statementA972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_breakAllStatement_in_statementB984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_returnStatement_in_statementB988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_transactionStatement_in_statementB992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_abortStatement_in_statementB998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_continueStatement_in_statementB1002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_throwStatement_in_statementB1006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_deleteStatement_in_statementB1012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_statementOrStatementBlock1023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementBlock_in_statementOrStatementBlock1027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_89_in_expressionOrStatementBlock1036 = new BitSet(new long[]{0x0000000000085110L,0x0000007F80800000L,0x0000000000003890L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionOrStatementBlock1039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementBlock_in_expressionOrStatementBlock1043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_105_in_forStatement1056 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_87_in_forStatement1059 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_formalParameter_in_forStatement1062 = new BitSet(new long[]{0x0000000000000000L,0x0000040000000000L});
    public static final BitSet FOLLOW_106_in_forStatement1064 = new BitSet(new long[]{0x0000000000085110L,0x0000007F80800000L,0x0000000000003890L});
    public static final BitSet FOLLOW_logicalExpression_in_forStatement1067 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_88_in_forStatement1069 = new BitSet(new long[]{0x0000000000085110L,0x01FF1A7F82840000L,0x0000000000003890L});
    public static final BitSet FOLLOW_statementOrStatementBlock_in_forStatement1072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_107_in_ifStatement1088 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_87_in_ifStatement1091 = new BitSet(new long[]{0x0000000000085110L,0x0000007F80800000L,0x0000000000003890L});
    public static final BitSet FOLLOW_logicalExpression_in_ifStatement1094 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_88_in_ifStatement1096 = new BitSet(new long[]{0x0000000000085110L,0x01FF1A7F82840000L,0x0000000000003890L});
    public static final BitSet FOLLOW_statementOrStatementBlock_in_ifStatement1099 = new BitSet(new long[]{0x0000000000000002L,0x0000800000000000L});
    public static final BitSet FOLLOW_elseStatement_in_ifStatement1101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_108_in_switchStatement1120 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_87_in_switchStatement1123 = new BitSet(new long[]{0x0000000000085110L,0x0000007F80800000L,0x0000000000003890L});
    public static final BitSet FOLLOW_logicalExpression_in_switchStatement1126 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_88_in_switchStatement1128 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_82_in_switchStatement1131 = new BitSet(new long[]{0x0000000000000000L,0x0000600000080000L});
    public static final BitSet FOLLOW_caseStatement_in_switchStatement1134 = new BitSet(new long[]{0x0000000000000000L,0x0000600000080000L});
    public static final BitSet FOLLOW_defaultStatement_in_switchStatement1137 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_83_in_switchStatement1140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_109_in_caseStatement1159 = new BitSet(new long[]{0x0000000000085110L,0x0000007F80800000L,0x0000000000003890L});
    public static final BitSet FOLLOW_logicalExpression_in_caseStatement1162 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_89_in_caseStatement1164 = new BitSet(new long[]{0x0000000000085110L,0x01FF1A7F82840000L,0x0000000000003890L});
    public static final BitSet FOLLOW_block_in_caseStatement1168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementBlock_in_caseStatement1172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_110_in_defaultStatement1191 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_89_in_defaultStatement1194 = new BitSet(new long[]{0x0000000000085110L,0x01FF1A7F82840000L,0x0000000000003890L});
    public static final BitSet FOLLOW_block_in_defaultStatement1198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementBlock_in_defaultStatement1202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_111_in_elseStatement1227 = new BitSet(new long[]{0x0000000000085110L,0x01FF1A7F82840000L,0x0000000000003890L});
    public static final BitSet FOLLOW_statementOrStatementBlock_in_elseStatement1230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_112_in_whileStatement1243 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_87_in_whileStatement1246 = new BitSet(new long[]{0x0000000000085110L,0x0000007F80800000L,0x0000000000003890L});
    public static final BitSet FOLLOW_logicalExpression_in_whileStatement1249 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_88_in_whileStatement1251 = new BitSet(new long[]{0x0000000000085110L,0x01FF1A7F82840000L,0x0000000000003890L});
    public static final BitSet FOLLOW_statementOrStatementBlock_in_whileStatement1254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_113_in_returnStatement1276 = new BitSet(new long[]{0x0000000000085110L,0x0000007F80804000L,0x0000000000003890L});
    public static final BitSet FOLLOW_logicalExpression_in_returnStatement1279 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_returnStatement1284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_114_in_throwStatement1307 = new BitSet(new long[]{0x0000000000085110L,0x0000007F80804000L,0x0000000000003890L});
    public static final BitSet FOLLOW_logicalExpression_in_throwStatement1310 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_throwStatement1315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_115_in_deleteStatement1338 = new BitSet(new long[]{0x0000000000085110L,0x0000007F80804000L,0x0000000000003890L});
    public static final BitSet FOLLOW_logicalExpression_in_deleteStatement1341 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_deleteStatement1346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_116_in_breakStatement1372 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_breakStatement1377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_117_in_breakAllStatement1400 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_breakAllStatement1405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_118_in_continueStatement1428 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_continueStatement1433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_119_in_abortStatement1456 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_abortStatement1461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_120_in_transactionStatement1478 = new BitSet(new long[]{0x0000000000085110L,0x01FF1A7F82840000L,0x0000000000003890L});
    public static final BitSet FOLLOW_NAME_in_transactionStatement1482 = new BitSet(new long[]{0x0000000000085110L,0x01FF1A7F82850000L,0x0000000000003890L});
    public static final BitSet FOLLOW_80_in_transactionStatement1485 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_transactionStatement1487 = new BitSet(new long[]{0x0000000000085110L,0x01FF1A7F82850000L,0x0000000000003890L});
    public static final BitSet FOLLOW_statementOrStatementBlock_in_transactionStatement1493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logicalExpression_in_assignmentStatement1513 = new BitSet(new long[]{0x0000000000000000L,0x0600000000000000L});
    public static final BitSet FOLLOW_121_in_assignmentStatement1518 = new BitSet(new long[]{0x0000000000085110L,0x0000007F80800000L,0x0000000000003890L});
    public static final BitSet FOLLOW_122_in_assignmentStatement1525 = new BitSet(new long[]{0x0000000000085110L,0x0000007F80800000L,0x0000000000003890L});
    public static final BitSet FOLLOW_logicalExpression_in_assignmentStatement1531 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_assignmentStatement1535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_postfixExpression_in_expressionStatement1557 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_84_in_expressionStatement1561 = new BitSet(new long[]{0x0000000000085110L,0x0000007F80800000L,0x0000000000003890L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionStatement1564 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionStatement1570 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_expressionStatement1575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_relationalExpression_in_logicalExpression1587 = new BitSet(new long[]{0x0000000000000002L,0x7800000000000000L});
    public static final BitSet FOLLOW_123_in_logicalExpression1593 = new BitSet(new long[]{0x0000000000085110L,0x0000007F80800000L,0x0000000000003890L});
    public static final BitSet FOLLOW_124_in_logicalExpression1598 = new BitSet(new long[]{0x0000000000085110L,0x0000007F80800000L,0x0000000000003890L});
    public static final BitSet FOLLOW_125_in_logicalExpression1603 = new BitSet(new long[]{0x0000000000085110L,0x0000007F80800000L,0x0000000000003890L});
    public static final BitSet FOLLOW_126_in_logicalExpression1608 = new BitSet(new long[]{0x0000000000085110L,0x0000007F80800000L,0x0000000000003890L});
    public static final BitSet FOLLOW_relationalExpression_in_logicalExpression1612 = new BitSet(new long[]{0x0000000000000002L,0x7800000000000000L});
    public static final BitSet FOLLOW_additiveExpression_in_relationalExpression1629 = new BitSet(new long[]{0x0000000000000002L,0x8000018000100000L,0x0000000000000007L});
    public static final BitSet FOLLOW_127_in_relationalExpression1635 = new BitSet(new long[]{0x0000000000085110L,0x0000007F80800000L,0x0000000000003890L});
    public static final BitSet FOLLOW_relationalExpression_in_relationalExpression1638 = new BitSet(new long[]{0x0000000000000002L,0x8000018000100000L,0x0000000000000007L});
    public static final BitSet FOLLOW_84_in_relationalExpression1644 = new BitSet(new long[]{0x0000000000085110L,0x0000007F80800000L,0x0000000000003890L});
    public static final BitSet FOLLOW_relationalExpression_in_relationalExpression1647 = new BitSet(new long[]{0x0000000000000002L,0x8000018000100000L,0x0000000000000007L});
    public static final BitSet FOLLOW_104_in_relationalExpression1677 = new BitSet(new long[]{0x0000000000085110L,0x0000007F80800000L,0x0000000000003890L});
    public static final BitSet FOLLOW_103_in_relationalExpression1682 = new BitSet(new long[]{0x0000000000085110L,0x0000007F80800000L,0x0000000000003890L});
    public static final BitSet FOLLOW_128_in_relationalExpression1687 = new BitSet(new long[]{0x0000000000085110L,0x0000007F80800000L,0x0000000000003890L});
    public static final BitSet FOLLOW_129_in_relationalExpression1692 = new BitSet(new long[]{0x0000000000085110L,0x0000007F80800000L,0x0000000000003890L});
    public static final BitSet FOLLOW_130_in_relationalExpression1697 = new BitSet(new long[]{0x0000000000085110L,0x0000007F80800000L,0x0000000000003890L});
    public static final BitSet FOLLOW_additiveExpression_in_relationalExpression1701 = new BitSet(new long[]{0x0000000000000002L,0x8000018000100000L,0x0000000000000007L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_additiveExpression1719 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000018L});
    public static final BitSet FOLLOW_131_in_additiveExpression1725 = new BitSet(new long[]{0x0000000000085110L,0x0000007F80800000L,0x0000000000003890L});
    public static final BitSet FOLLOW_132_in_additiveExpression1730 = new BitSet(new long[]{0x0000000000085110L,0x0000007F80800000L,0x0000000000003890L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_additiveExpression1734 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000018L});
    public static final BitSet FOLLOW_unaryExpression_in_multiplicativeExpression1752 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000060L});
    public static final BitSet FOLLOW_133_in_multiplicativeExpression1758 = new BitSet(new long[]{0x0000000000085110L,0x0000007F80800000L,0x0000000000003890L});
    public static final BitSet FOLLOW_134_in_multiplicativeExpression1763 = new BitSet(new long[]{0x0000000000085110L,0x0000007F80800000L,0x0000000000003890L});
    public static final BitSet FOLLOW_unaryExpression_in_multiplicativeExpression1767 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000060L});
    public static final BitSet FOLLOW_135_in_unaryExpression1788 = new BitSet(new long[]{0x0000000000085110L,0x0000007F80800000L,0x0000000000003890L});
    public static final BitSet FOLLOW_132_in_unaryExpression1793 = new BitSet(new long[]{0x0000000000085110L,0x0000007F80800000L,0x0000000000003890L});
    public static final BitSet FOLLOW_postfixExpression_in_unaryExpression1801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_itemSelectorExpression_in_postfixExpression1813 = new BitSet(new long[]{0x0000000000000A02L});
    public static final BitSet FOLLOW_set_in_postfixExpression1816 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_featureCall_in_postfixExpression1825 = new BitSet(new long[]{0x0000000000000A02L,0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_136_in_postfixExpression1834 = new BitSet(new long[]{0x0000000000085110L,0x0000007F80800000L,0x0000000000003890L});
    public static final BitSet FOLLOW_logicalExpression_in_postfixExpression1837 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_137_in_postfixExpression1839 = new BitSet(new long[]{0x0000000000000A02L,0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_primitiveExpression_in_itemSelectorExpression1861 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_136_in_itemSelectorExpression1866 = new BitSet(new long[]{0x0000000000085110L,0x0000007F80800000L,0x0000000000003890L});
    public static final BitSet FOLLOW_primitiveExpression_in_itemSelectorExpression1869 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_137_in_itemSelectorExpression1871 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_simpleFeatureCall_in_featureCall1890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declarativeFeatureCall_in_featureCall1894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_simpleFeatureCall1908 = new BitSet(new long[]{0x0000000000000002L,0x0000000000800000L});
    public static final BitSet FOLLOW_parameterList_in_simpleFeatureCall1911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_87_in_parameterList1934 = new BitSet(new long[]{0x0000000000085110L,0x0000007F81800000L,0x0000000000003890L});
    public static final BitSet FOLLOW_logicalExpression_in_parameterList1937 = new BitSet(new long[]{0x0000000000000000L,0x0000000001010000L});
    public static final BitSet FOLLOW_80_in_parameterList1940 = new BitSet(new long[]{0x0000000000085110L,0x0000007F80800000L,0x0000000000003890L});
    public static final BitSet FOLLOW_logicalExpression_in_parameterList1942 = new BitSet(new long[]{0x0000000000000000L,0x0000000001010000L});
    public static final BitSet FOLLOW_88_in_parameterList1950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_declarativeFeatureCall1978 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_87_in_declarativeFeatureCall1983 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_formalParameterList_in_declarativeFeatureCall1986 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_138_in_declarativeFeatureCall1988 = new BitSet(new long[]{0x0000000000085110L,0x0000007F80800000L,0x0000000000003890L});
    public static final BitSet FOLLOW_logicalExpression_in_declarativeFeatureCall1991 = new BitSet(new long[]{0x0000000000000000L,0x0000000001010000L});
    public static final BitSet FOLLOW_80_in_declarativeFeatureCall1994 = new BitSet(new long[]{0x0000000000085110L,0x0000007F80800000L,0x0000000000003890L});
    public static final BitSet FOLLOW_logicalExpression_in_declarativeFeatureCall1997 = new BitSet(new long[]{0x0000000000000000L,0x0000000001010000L});
    public static final BitSet FOLLOW_88_in_declarativeFeatureCall2003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_139_in_newExpression2017 = new BitSet(new long[]{0x0000000000080000L,0x0000007F80000000L});
    public static final BitSet FOLLOW_typeName_in_newExpression2022 = new BitSet(new long[]{0x0000000000000002L,0x0000000000800000L});
    public static final BitSet FOLLOW_parameterList_in_newExpression2026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_140_in_variableDeclarationExpression2049 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_141_in_variableDeclarationExpression2054 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_variableDeclarationExpression2058 = new BitSet(new long[]{0x0000000000000002L,0x0000000002000000L});
    public static final BitSet FOLLOW_89_in_variableDeclarationExpression2061 = new BitSet(new long[]{0x0000000000080000L,0x0000007F80000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_139_in_variableDeclarationExpression2066 = new BitSet(new long[]{0x0000000000080000L,0x0000007F80000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_typeName_in_variableDeclarationExpression2072 = new BitSet(new long[]{0x0000000000000002L,0x0000000000800000L});
    public static final BitSet FOLLOW_parameterList_in_variableDeclarationExpression2076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_96_in_literalSequentialCollection2100 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_97_in_literalSequentialCollection2105 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_98_in_literalSequentialCollection2110 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_99_in_literalSequentialCollection2115 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_100_in_literalSequentialCollection2120 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_101_in_literalSequentialCollection2125 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_82_in_literalSequentialCollection2131 = new BitSet(new long[]{0x0000000000085110L,0x0000007F80880000L,0x0000000000003890L});
    public static final BitSet FOLLOW_expressionListOrRange_in_literalSequentialCollection2135 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_83_in_literalSequentialCollection2140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionRange2155 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_POINT_POINT_in_expressionRange2159 = new BitSet(new long[]{0x0000000000085110L,0x0000007F80800000L,0x0000000000003890L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionRange2162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionList2183 = new BitSet(new long[]{0x0000000000000002L,0x0000000000010000L});
    public static final BitSet FOLLOW_80_in_expressionList2186 = new BitSet(new long[]{0x0000000000085110L,0x0000007F80800000L,0x0000000000003890L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionList2188 = new BitSet(new long[]{0x0000000000000002L,0x0000000000010000L});
    public static final BitSet FOLLOW_expressionRange_in_expressionListOrRange2212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionList_in_expressionListOrRange2216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_102_in_literalMapCollection2235 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_82_in_literalMapCollection2240 = new BitSet(new long[]{0x0000000000085110L,0x0000007F80880000L,0x0000000000003890L});
    public static final BitSet FOLLOW_keyvalExpressionList_in_literalMapCollection2243 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_83_in_literalMapCollection2248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_keyvalExpression_in_keyvalExpressionList2269 = new BitSet(new long[]{0x0000000000000002L,0x0000000000010000L});
    public static final BitSet FOLLOW_80_in_keyvalExpressionList2272 = new BitSet(new long[]{0x0000000000085110L,0x0000007F80800000L,0x0000000000003890L});
    public static final BitSet FOLLOW_keyvalExpression_in_keyvalExpressionList2274 = new BitSet(new long[]{0x0000000000000002L,0x0000000000010000L});
    public static final BitSet FOLLOW_additiveExpression_in_keyvalExpression2299 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_84_in_keyvalExpression2303 = new BitSet(new long[]{0x0000000000085110L,0x0000007F80800000L,0x0000000000003890L});
    public static final BitSet FOLLOW_logicalExpression_in_keyvalExpression2306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literalSequentialCollection_in_primitiveExpression2320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literalMapCollection_in_primitiveExpression2324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_primitiveExpression2328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_featureCall_in_primitiveExpression2332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pathName_in_primitiveExpression2336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nativeType_in_primitiveExpression2340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectionType_in_primitiveExpression2346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logicalExpressionInBrackets_in_primitiveExpression2351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_newExpression_in_primitiveExpression2357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variableDeclarationExpression_in_primitiveExpression2361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_87_in_logicalExpressionInBrackets2380 = new BitSet(new long[]{0x0000000000085110L,0x0000007F80800000L,0x0000000000003890L});
    public static final BitSet FOLLOW_logicalExpression_in_logicalExpressionInBrackets2383 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_88_in_logicalExpressionInBrackets2387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_literal0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_87_in_synpred29_EolParserRules852 = new BitSet(new long[]{0x0000000000080000L,0x0000007F80000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_typeName_in_synpred29_EolParserRules857 = new BitSet(new long[]{0x0000000000000000L,0x0000000001010000L});
    public static final BitSet FOLLOW_80_in_synpred29_EolParserRules862 = new BitSet(new long[]{0x0000000000080000L,0x0000007F80000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_typeName_in_synpred29_EolParserRules866 = new BitSet(new long[]{0x0000000000000000L,0x0000000001010000L});
    public static final BitSet FOLLOW_88_in_synpred29_EolParserRules874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_103_in_synpred31_EolParserRules886 = new BitSet(new long[]{0x0000000000080000L,0x0000007F80000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_typeName_in_synpred31_EolParserRules891 = new BitSet(new long[]{0x0000000000000000L,0x0000010000010000L});
    public static final BitSet FOLLOW_80_in_synpred31_EolParserRules896 = new BitSet(new long[]{0x0000000000080000L,0x0000007F80000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_typeName_in_synpred31_EolParserRules900 = new BitSet(new long[]{0x0000000000000000L,0x0000010000010000L});
    public static final BitSet FOLLOW_104_in_synpred31_EolParserRules908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementA_in_synpred32_EolParserRules927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignmentStatement_in_synpred33_EolParserRules942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionStatement_in_synpred34_EolParserRules946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_elseStatement_in_synpred48_EolParserRules1101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_synpred57_EolParserRules1482 = new BitSet(new long[]{0x0000000000000002L,0x0000000000010000L});
    public static final BitSet FOLLOW_80_in_synpred57_EolParserRules1485 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_synpred57_EolParserRules1487 = new BitSet(new long[]{0x0000000000000002L,0x0000000000010000L});
    public static final BitSet FOLLOW_postfixExpression_in_synpred59_EolParserRules1557 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_84_in_synpred59_EolParserRules1561 = new BitSet(new long[]{0x0000000000085110L,0x0000007F80800000L,0x0000000000003890L});
    public static final BitSet FOLLOW_logicalExpression_in_synpred59_EolParserRules1564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_127_in_synpred70_EolParserRules1635 = new BitSet(new long[]{0x0000000000085110L,0x0000007F80800000L,0x0000000000003890L});
    public static final BitSet FOLLOW_relationalExpression_in_synpred70_EolParserRules1638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_synpred70_EolParserRules1644 = new BitSet(new long[]{0x0000000000085110L,0x0000007F80800000L,0x0000000000003890L});
    public static final BitSet FOLLOW_relationalExpression_in_synpred70_EolParserRules1647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred70_EolParserRules1674 = new BitSet(new long[]{0x0000000000085110L,0x0000007F80800000L,0x0000000000003890L});
    public static final BitSet FOLLOW_additiveExpression_in_synpred70_EolParserRules1701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_89_in_synpred90_EolParserRules2061 = new BitSet(new long[]{0x0000000000080000L,0x0000007F80000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_139_in_synpred90_EolParserRules2066 = new BitSet(new long[]{0x0000000000080000L,0x0000007F80000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_typeName_in_synpred90_EolParserRules2072 = new BitSet(new long[]{0x0000000000000002L,0x0000000000800000L});
    public static final BitSet FOLLOW_parameterList_in_synpred90_EolParserRules2076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionRange_in_synpred98_EolParserRules2212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_featureCall_in_synpred104_EolParserRules2332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pathName_in_synpred105_EolParserRules2336 = new BitSet(new long[]{0x0000000000000002L});

}
