package org.eclipse.epsilon.epl.parse;

// $ANTLR 3.1b1 ErlParserRules.g 2019-01-24 14:02:06

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
public class Epl_ErlParserRules extends org.eclipse.epsilon.common.parse.EpsilonParser {
    public static final int T__144=144;
    public static final int T__143=143;
    public static final int T__146=146;
    public static final int MODELDECLARATIONPARAMETER=73;
    public static final int T__145=145;
    public static final int BREAKALL=39;
    public static final int T__140=140;
    public static final int T__142=142;
    public static final int VAR=48;
    public static final int MODELDECLARATIONPARAMETERS=72;
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
    public static final int TYPE=65;
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
    public static final int LAMBDAEXPR=64;
    public static final int MAP=75;
    public static final int T__128=128;
    public static final int T__127=127;
    public static final int T__166=166;
    public static final int T__165=165;
    public static final int T__168=168;
    public static final int DOMAIN=84;
    public static final int T__167=167;
    public static final int T__162=162;
    public static final int T__161=161;
    public static final int T__164=164;
    public static final int MODELDECLARATION=68;
    public static final int T__163=163;
    public static final int EXPRESSIONINBRACKETS=59;
    public static final int T__160=160;
    public static final int TRANSACTION=41;
    public static final int FLOAT_TYPE_SUFFIX=7;
    public static final int ITEMSELECTOR=74;
    public static final int COMMENT=21;
    public static final int ModelElementType=45;
    public static final int ROLE=85;
    public static final int IMPORT=67;
    public static final int DELETE=52;
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
    public static final int CONTINUE=40;
    public static final int ENUMERATION_VALUE=66;
    public static final int OPERATOR=58;
    public static final int EXPONENT=6;
    public static final int STRING=14;
    public static final int T__148=148;
    public static final int T__147=147;
    public static final int T__149=149;
    public static final int T__100=100;
    public static final int NAMESPACE=69;
    public static final int COLLECTION=42;
    public static final int NEW=49;
    public static final int EXTENDS=80;
    public static final int T__102=102;
    public static final int PRE=78;
    public static final int T__94=94;
    public static final int T__101=101;
    public static final int POST=79;
    public static final int ALIAS=70;
    public static final int DRIVER=71;
    public static final int DO=89;
    public static final int OPTIONAL=91;
    public static final int KEYVAL=76;
    public static final int POINT_POINT=10;
    public static final int GUARD=81;
    public static final int T__99=99;
    public static final int T__95=95;
    public static final int HELPERMETHOD=28;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int StatementBlock=29;
    public static final int T__98=98;
    public static final int T__177=177;
    public static final int T__176=176;
    public static final int ABORT=43;
    public static final int T__173=173;
    public static final int StrangeNameLiteral=15;
    public static final int ONMATCH=88;
    public static final int T__172=172;
    public static final int EPLMODULE=93;
    public static final int T__175=175;
    public static final int T__174=174;
    public static final int FOR=30;
    public static final int BLOCK=62;
    public static final int T__171=171;
    public static final int T__170=170;
    public static final int PARAMETERS=46;
    public static final int SpecialNameChar=17;
    public static final int BOOLEAN=12;
    public static final int NAME=19;
    public static final int SWITCH=34;
    public static final int T__169=169;
    public static final int FeatureCall=60;
    public static final int T__122=122;
    public static final int T__121=121;
    public static final int NO=90;
    public static final int T__124=124;
    public static final int FLOAT=4;
    public static final int T__123=123;
    public static final int ACTIVE=92;
    public static final int T__120=120;
    public static final int NativeType=56;
    public static final int INT=8;
    public static final int ANNOTATIONBLOCK=50;
    public static final int RETURN=37;
    public static final int KEYVALLIST=77;
    public static final int PATTERN=82;
    public static final int NOMATCH=87;
    public static final int FEATURECALL=63;
    public static final int CollectionType=44;
    public static final int T__119=119;
    public static final int ASSIGNMENT=26;
    public static final int T__118=118;
    public static final int CARDINALITY=83;
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
    public static final int T__108=108;
    public static final int T__107=107;
    public static final int WHILE=33;
    public static final int T__109=109;
    public static final int T__104=104;
    public static final int POINT=9;
    public static final int T__103=103;
    public static final int T__106=106;
    public static final int DEFAULT=36;
    public static final int MATCH=86;
    public static final int T__105=105;

    // delegates
    // delegators
    public EplParser gEpl;


        public Epl_ErlParserRules(TokenStream input, EplParser gEpl) {
            this(input, new RecognizerSharedState(), gEpl);
        }
        public Epl_ErlParserRules(TokenStream input, RecognizerSharedState state, EplParser gEpl) {
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
    public String getGrammarFileName() { return "ErlParserRules.g"; }


    public static class pre_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start pre
    // ErlParserRules.g:48:1: pre : p= 'pre' ( NAME )? statementBlock ;
    public final Epl_ErlParserRules.pre_return pre() throws RecognitionException {
        Epl_ErlParserRules.pre_return retval = new Epl_ErlParserRules.pre_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token p=null;
        Token NAME1=null;
        Epl_EolParserRules.statementBlock_return statementBlock2 = null;


        org.eclipse.epsilon.common.parse.AST p_tree=null;
        org.eclipse.epsilon.common.parse.AST NAME1_tree=null;

        try {
            // ErlParserRules.g:49:2: (p= 'pre' ( NAME )? statementBlock )
            // ErlParserRules.g:49:4: p= 'pre' ( NAME )? statementBlock
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            p=(Token)match(input,165,FOLLOW_165_in_pre50); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            p_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(p);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(p_tree, root_0);
            }
            // ErlParserRules.g:49:13: ( NAME )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==NAME) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ErlParserRules.g:0:0: NAME
                    {
                    NAME1=(Token)match(input,NAME,FOLLOW_NAME_in_pre53); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NAME1_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(NAME1);
                    adaptor.addChild(root_0, NAME1_tree);
                    }

                    }
                    break;

            }

            pushFollow(FOLLOW_statementBlock_in_pre56);
            statementBlock2=gEpl.statementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, statementBlock2.getTree());
            if ( state.backtracking==0 ) {
              p.setType(PRE);
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
    // $ANTLR end pre

    public static class post_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start post
    // ErlParserRules.g:53:1: post : p= 'post' ( NAME )? statementBlock ;
    public final Epl_ErlParserRules.post_return post() throws RecognitionException {
        Epl_ErlParserRules.post_return retval = new Epl_ErlParserRules.post_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token p=null;
        Token NAME3=null;
        Epl_EolParserRules.statementBlock_return statementBlock4 = null;


        org.eclipse.epsilon.common.parse.AST p_tree=null;
        org.eclipse.epsilon.common.parse.AST NAME3_tree=null;

        try {
            // ErlParserRules.g:54:2: (p= 'post' ( NAME )? statementBlock )
            // ErlParserRules.g:54:4: p= 'post' ( NAME )? statementBlock
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            p=(Token)match(input,166,FOLLOW_166_in_post72); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            p_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(p);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(p_tree, root_0);
            }
            // ErlParserRules.g:54:14: ( NAME )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==NAME) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ErlParserRules.g:0:0: NAME
                    {
                    NAME3=(Token)match(input,NAME,FOLLOW_NAME_in_post75); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NAME3_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(NAME3);
                    adaptor.addChild(root_0, NAME3_tree);
                    }

                    }
                    break;

            }

            pushFollow(FOLLOW_statementBlock_in_post78);
            statementBlock4=gEpl.statementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, statementBlock4.getTree());
            if ( state.backtracking==0 ) {
              p.setType(POST);
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
    // $ANTLR end post

    public static class guard_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start guard
    // ErlParserRules.g:58:1: guard : g= 'guard' expressionOrStatementBlock ;
    public final Epl_ErlParserRules.guard_return guard() throws RecognitionException {
        Epl_ErlParserRules.guard_return retval = new Epl_ErlParserRules.guard_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token g=null;
        Epl_EolParserRules.expressionOrStatementBlock_return expressionOrStatementBlock5 = null;


        org.eclipse.epsilon.common.parse.AST g_tree=null;

        try {
            // ErlParserRules.g:59:2: (g= 'guard' expressionOrStatementBlock )
            // ErlParserRules.g:59:4: g= 'guard' expressionOrStatementBlock
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            g=(Token)match(input,167,FOLLOW_167_in_guard94); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            g_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(g);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(g_tree, root_0);
            }
            pushFollow(FOLLOW_expressionOrStatementBlock_in_guard97);
            expressionOrStatementBlock5=gEpl.expressionOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionOrStatementBlock5.getTree());
            if ( state.backtracking==0 ) {
              g.setType(GUARD);
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
    // $ANTLR end guard

    public static class extendz_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start extendz
    // ErlParserRules.g:63:1: extendz : e= 'extends' NAME ( ',' NAME )* ;
    public final Epl_ErlParserRules.extendz_return extendz() throws RecognitionException {
        Epl_ErlParserRules.extendz_return retval = new Epl_ErlParserRules.extendz_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token e=null;
        Token NAME6=null;
        Token char_literal7=null;
        Token NAME8=null;

        org.eclipse.epsilon.common.parse.AST e_tree=null;
        org.eclipse.epsilon.common.parse.AST NAME6_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal7_tree=null;
        org.eclipse.epsilon.common.parse.AST NAME8_tree=null;

        try {
            // ErlParserRules.g:64:2: (e= 'extends' NAME ( ',' NAME )* )
            // ErlParserRules.g:64:4: e= 'extends' NAME ( ',' NAME )*
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            e=(Token)match(input,168,FOLLOW_168_in_extendz113); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            e_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(e);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(e_tree, root_0);
            }
            NAME6=(Token)match(input,NAME,FOLLOW_NAME_in_extendz116); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME6_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(NAME6);
            adaptor.addChild(root_0, NAME6_tree);
            }
            // ErlParserRules.g:64:22: ( ',' NAME )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==97) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ErlParserRules.g:64:23: ',' NAME
            	    {
            	    char_literal7=(Token)match(input,97,FOLLOW_97_in_extendz119); if (state.failed) return retval;
            	    NAME8=(Token)match(input,NAME,FOLLOW_NAME_in_extendz122); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    NAME8_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(NAME8);
            	    adaptor.addChild(root_0, NAME8_tree);
            	    }

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            if ( state.backtracking==0 ) {
              e.setType(EXTENDS);
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
    // $ANTLR end extendz

    // Delegated rules


 

    public static final BitSet FOLLOW_165_in_pre50 = new BitSet(new long[]{0x0000000000080000L,0x0000000800000000L});
    public static final BitSet FOLLOW_NAME_in_pre53 = new BitSet(new long[]{0x0000000000080000L,0x0000000800000000L});
    public static final BitSet FOLLOW_statementBlock_in_pre56 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_166_in_post72 = new BitSet(new long[]{0x0000000000080000L,0x0000000800000000L});
    public static final BitSet FOLLOW_NAME_in_post75 = new BitSet(new long[]{0x0000000000080000L,0x0000000800000000L});
    public static final BitSet FOLLOW_statementBlock_in_post78 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_167_in_guard94 = new BitSet(new long[]{0x0000000000080000L,0x0000040800000000L});
    public static final BitSet FOLLOW_expressionOrStatementBlock_in_guard97 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_168_in_extendz113 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_extendz116 = new BitSet(new long[]{0x0000000000000002L,0x0000000200000000L});
    public static final BitSet FOLLOW_97_in_extendz119 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_extendz122 = new BitSet(new long[]{0x0000000000000002L,0x0000000200000000L});

}
