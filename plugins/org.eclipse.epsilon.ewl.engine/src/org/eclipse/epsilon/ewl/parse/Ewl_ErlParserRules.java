package org.eclipse.epsilon.ewl.parse;

// $ANTLR 3.1b1 ErlParserRules.g 2010-05-13 17:08:56

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
public class Ewl_ErlParserRules extends org.eclipse.epsilon.commons.parse.EpsilonParser {
    public static final int WHILE=31;
    public static final int StatementBlock=27;
    public static final int StrangeNameLiteral=13;
    public static final int NEW=44;
    public static final int DO=74;
    public static final int EWLMODULE=75;
    public static final int FeatureCall=54;
    public static final int EOF=-1;
    public static final int BREAK=33;
    public static final int TYPE=58;
    public static final int T__93=93;
    public static final int T__94=94;
    public static final int T__91=91;
    public static final int IMPORT=60;
    public static final int T__92=92;
    public static final int NAME=17;
    public static final int T__90=90;
    public static final int RETURN=32;
    public static final int NewExpression=42;
    public static final int VAR=43;
    public static final int ANNOTATIONBLOCK=45;
    public static final int NativeType=51;
    public static final int ABORT=38;
    public static final int COMMENT=19;
    public static final int T__99=99;
    public static final int ITEMSELECTOR=67;
    public static final int T__98=98;
    public static final int T__97=97;
    public static final int MultiplicativeExpression=52;
    public static final int T__96=96;
    public static final int T__95=95;
    public static final int T__139=139;
    public static final int T__138=138;
    public static final int T__137=137;
    public static final int T__136=136;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int LINE_COMMENT=20;
    public static final int BREAKALL=34;
    public static final int TRANSACTION=36;
    public static final int DRIVER=64;
    public static final int ELSE=30;
    public static final int EOLMODULE=55;
    public static final int MODELDECLARATION=61;
    public static final int PARAMLIST=23;
    public static final int INT=6;
    public static final int DELETE=47;
    public static final int T__85=85;
    public static final int T__141=141;
    public static final int T__84=84;
    public static final int T__142=142;
    public static final int T__87=87;
    public static final int HELPERMETHOD=26;
    public static final int T__86=86;
    public static final int T__140=140;
    public static final int T__89=89;
    public static final int NAMESPACE=62;
    public static final int T__88=88;
    public static final int CollectionType=39;
    public static final int T__126=126;
    public static final int T__125=125;
    public static final int T__128=128;
    public static final int T__127=127;
    public static final int WS=18;
    public static final int T__129=129;
    public static final int ALIAS=63;
    public static final int JavaIDDigit=16;
    public static final int GUARD=71;
    public static final int Annotation=21;
    public static final int T__76=76;
    public static final int T__130=130;
    public static final int T__131=131;
    public static final int EscapeSequence=11;
    public static final int Letter=14;
    public static final int THROW=48;
    public static final int T__132=132;
    public static final int WIZARD=72;
    public static final int T__79=79;
    public static final int T__133=133;
    public static final int T__78=78;
    public static final int T__134=134;
    public static final int T__77=77;
    public static final int T__135=135;
    public static final int SPECIAL_ASSIGNMENT=25;
    public static final int MODELDECLARATIONPARAMETER=66;
    public static final int PARAMETERS=41;
    public static final int POINT=7;
    public static final int T__118=118;
    public static final int T__119=119;
    public static final int T__116=116;
    public static final int T__117=117;
    public static final int T__114=114;
    public static final int T__115=115;
    public static final int T__124=124;
    public static final int T__123=123;
    public static final int FOR=28;
    public static final int T__122=122;
    public static final int ENUMERATION_VALUE=59;
    public static final int T__121=121;
    public static final int PRE=68;
    public static final int T__120=120;
    public static final int FLOAT=4;
    public static final int EXECUTABLEANNOTATION=46;
    public static final int IF=29;
    public static final int ModelElementType=40;
    public static final int BOOLEAN=10;
    public static final int CONTINUE=35;
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
    public static final int COLLECTION=37;
    public static final int DIGIT=5;
    public static final int EXPRRANGE=50;
    public static final int OPERATOR=53;
    public static final int EXPRLIST=49;
    public static final int T__102=102;
    public static final int T__101=101;
    public static final int T__100=100;
    public static final int POINT_POINT=8;
    public static final int SpecialNameChar=15;
    public static final int MODELDECLARATIONPARAMETERS=65;
    public static final int BLOCK=56;
    public static final int FEATURECALL=57;
    public static final int FORMAL=22;
    public static final int POST=69;
    public static final int ARROW=9;
    public static final int ASSIGNMENT=24;
    public static final int EXTENDS=70;
    public static final int STRING=12;
    public static final int TITLE=73;

    // delegates
    // delegators
    public EwlParser gEwl;


        public Ewl_ErlParserRules(TokenStream input, EwlParser gEwl) {
            this(input, new RecognizerSharedState(), gEwl);
        }
        public Ewl_ErlParserRules(TokenStream input, RecognizerSharedState state, EwlParser gEwl) {
            super(input, state);
            this.gEwl = gEwl;
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return EwlParser.tokenNames; }
    public String getGrammarFileName() { return "ErlParserRules.g"; }


    public static class pre_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start pre
    // ErlParserRules.g:48:1: pre : p= 'pre' ( NAME )? statementBlock ;
    public final Ewl_ErlParserRules.pre_return pre() throws RecognitionException {
        Ewl_ErlParserRules.pre_return retval = new Ewl_ErlParserRules.pre_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token p=null;
        Token NAME1=null;
        Ewl_EolParserRules.statementBlock_return statementBlock2 = null;


        CommonTree p_tree=null;
        CommonTree NAME1_tree=null;

        try {
            // ErlParserRules.g:49:2: (p= 'pre' ( NAME )? statementBlock )
            // ErlParserRules.g:49:4: p= 'pre' ( NAME )? statementBlock
            {
            root_0 = (CommonTree)adaptor.nil();

            p=(Token)match(input,136,FOLLOW_136_in_pre50); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            p_tree = (CommonTree)adaptor.create(p);
            root_0 = (CommonTree)adaptor.becomeRoot(p_tree, root_0);
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
                    NAME1_tree = (CommonTree)adaptor.create(NAME1);
                    adaptor.addChild(root_0, NAME1_tree);
                    }

                    }
                    break;

            }

            pushFollow(FOLLOW_statementBlock_in_pre56);
            statementBlock2=gEwl.statementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, statementBlock2.getTree());
            if ( state.backtracking==0 ) {
              p.setType(PRE);
            }

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
    // $ANTLR end pre

    public static class post_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start post
    // ErlParserRules.g:53:1: post : p= 'post' ( NAME )? statementBlock ;
    public final Ewl_ErlParserRules.post_return post() throws RecognitionException {
        Ewl_ErlParserRules.post_return retval = new Ewl_ErlParserRules.post_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token p=null;
        Token NAME3=null;
        Ewl_EolParserRules.statementBlock_return statementBlock4 = null;


        CommonTree p_tree=null;
        CommonTree NAME3_tree=null;

        try {
            // ErlParserRules.g:54:2: (p= 'post' ( NAME )? statementBlock )
            // ErlParserRules.g:54:4: p= 'post' ( NAME )? statementBlock
            {
            root_0 = (CommonTree)adaptor.nil();

            p=(Token)match(input,137,FOLLOW_137_in_post72); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            p_tree = (CommonTree)adaptor.create(p);
            root_0 = (CommonTree)adaptor.becomeRoot(p_tree, root_0);
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
                    NAME3_tree = (CommonTree)adaptor.create(NAME3);
                    adaptor.addChild(root_0, NAME3_tree);
                    }

                    }
                    break;

            }

            pushFollow(FOLLOW_statementBlock_in_post78);
            statementBlock4=gEwl.statementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, statementBlock4.getTree());
            if ( state.backtracking==0 ) {
              p.setType(POST);
            }

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
    // $ANTLR end post

    public static class guard_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start guard
    // ErlParserRules.g:58:1: guard : g= 'guard' expressionOrStatementBlock ;
    public final Ewl_ErlParserRules.guard_return guard() throws RecognitionException {
        Ewl_ErlParserRules.guard_return retval = new Ewl_ErlParserRules.guard_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token g=null;
        Ewl_EolParserRules.expressionOrStatementBlock_return expressionOrStatementBlock5 = null;


        CommonTree g_tree=null;

        try {
            // ErlParserRules.g:59:2: (g= 'guard' expressionOrStatementBlock )
            // ErlParserRules.g:59:4: g= 'guard' expressionOrStatementBlock
            {
            root_0 = (CommonTree)adaptor.nil();

            g=(Token)match(input,138,FOLLOW_138_in_guard94); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            g_tree = (CommonTree)adaptor.create(g);
            root_0 = (CommonTree)adaptor.becomeRoot(g_tree, root_0);
            }
            pushFollow(FOLLOW_expressionOrStatementBlock_in_guard97);
            expressionOrStatementBlock5=gEwl.expressionOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionOrStatementBlock5.getTree());
            if ( state.backtracking==0 ) {
              g.setType(GUARD);
            }

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
    // $ANTLR end guard

    public static class extendz_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start extendz
    // ErlParserRules.g:63:1: extendz : e= 'extends' NAME ( ',' NAME )* ;
    public final Ewl_ErlParserRules.extendz_return extendz() throws RecognitionException {
        Ewl_ErlParserRules.extendz_return retval = new Ewl_ErlParserRules.extendz_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token e=null;
        Token NAME6=null;
        Token char_literal7=null;
        Token NAME8=null;

        CommonTree e_tree=null;
        CommonTree NAME6_tree=null;
        CommonTree char_literal7_tree=null;
        CommonTree NAME8_tree=null;

        try {
            // ErlParserRules.g:64:2: (e= 'extends' NAME ( ',' NAME )* )
            // ErlParserRules.g:64:4: e= 'extends' NAME ( ',' NAME )*
            {
            root_0 = (CommonTree)adaptor.nil();

            e=(Token)match(input,139,FOLLOW_139_in_extendz113); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            e_tree = (CommonTree)adaptor.create(e);
            root_0 = (CommonTree)adaptor.becomeRoot(e_tree, root_0);
            }
            NAME6=(Token)match(input,NAME,FOLLOW_NAME_in_extendz116); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME6_tree = (CommonTree)adaptor.create(NAME6);
            adaptor.addChild(root_0, NAME6_tree);
            }
            // ErlParserRules.g:64:22: ( ',' NAME )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==79) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ErlParserRules.g:64:23: ',' NAME
            	    {
            	    char_literal7=(Token)match(input,79,FOLLOW_79_in_extendz119); if (state.failed) return retval;
            	    NAME8=(Token)match(input,NAME,FOLLOW_NAME_in_extendz122); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    NAME8_tree = (CommonTree)adaptor.create(NAME8);
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
    // $ANTLR end extendz

    // Delegated rules


 

    public static final BitSet FOLLOW_136_in_pre50 = new BitSet(new long[]{0x0000000000020000L,0x0000000000040000L});
    public static final BitSet FOLLOW_NAME_in_pre53 = new BitSet(new long[]{0x0000000000020000L,0x0000000000040000L});
    public static final BitSet FOLLOW_statementBlock_in_pre56 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_137_in_post72 = new BitSet(new long[]{0x0000000000020000L,0x0000000000040000L});
    public static final BitSet FOLLOW_NAME_in_post75 = new BitSet(new long[]{0x0000000000020000L,0x0000000000040000L});
    public static final BitSet FOLLOW_statementBlock_in_post78 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_138_in_guard94 = new BitSet(new long[]{0x0000000000020000L,0x0000000000044000L});
    public static final BitSet FOLLOW_expressionOrStatementBlock_in_guard97 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_139_in_extendz113 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NAME_in_extendz116 = new BitSet(new long[]{0x0000000000000002L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_extendz119 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NAME_in_extendz122 = new BitSet(new long[]{0x0000000000000002L,0x0000000000008000L});

}
