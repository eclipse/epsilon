package org.eclipse.epsilon.ewl.parse;

// $ANTLR 3.1b1 EwlParserRules.g 2010-03-17 00:48:57

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
public class Ewl_EwlParserRules extends org.eclipse.epsilon.commons.parse.EpsilonParser {
    public static final int WHILE=30;
    public static final int StatementBlock=26;
    public static final int StrangeNameLiteral=13;
    public static final int NEW=43;
    public static final int DO=73;
    public static final int EWLMODULE=74;
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
    public static final int ITEMSELECTOR=66;
    public static final int T__98=98;
    public static final int T__97=97;
    public static final int MultiplicativeExpression=51;
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
    public static final int LINE_COMMENT=19;
    public static final int BREAKALL=33;
    public static final int TRANSACTION=35;
    public static final int DRIVER=63;
    public static final int ELSE=29;
    public static final int EOLMODULE=54;
    public static final int MODELDECLARATION=60;
    public static final int PARAMLIST=22;
    public static final int INT=6;
    public static final int DELETE=46;
    public static final int T__85=85;
    public static final int T__141=141;
    public static final int T__84=84;
    public static final int T__87=87;
    public static final int HELPERMETHOD=25;
    public static final int T__86=86;
    public static final int T__140=140;
    public static final int T__89=89;
    public static final int NAMESPACE=61;
    public static final int T__88=88;
    public static final int CollectionType=38;
    public static final int T__126=126;
    public static final int T__125=125;
    public static final int T__128=128;
    public static final int T__127=127;
    public static final int WS=17;
    public static final int T__129=129;
    public static final int ALIAS=62;
    public static final int JavaIDDigit=15;
    public static final int GUARD=70;
    public static final int Annotation=20;
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int T__130=130;
    public static final int T__131=131;
    public static final int EscapeSequence=11;
    public static final int Letter=14;
    public static final int THROW=47;
    public static final int T__132=132;
    public static final int WIZARD=71;
    public static final int T__79=79;
    public static final int T__133=133;
    public static final int T__78=78;
    public static final int T__134=134;
    public static final int T__77=77;
    public static final int T__135=135;
    public static final int SPECIAL_ASSIGNMENT=24;
    public static final int MODELDECLARATIONPARAMETER=65;
    public static final int PARAMETERS=40;
    public static final int POINT=7;
    public static final int T__118=118;
    public static final int T__119=119;
    public static final int T__116=116;
    public static final int T__117=117;
    public static final int T__114=114;
    public static final int T__115=115;
    public static final int T__124=124;
    public static final int T__123=123;
    public static final int FOR=27;
    public static final int T__122=122;
    public static final int ENUMERATION_VALUE=58;
    public static final int T__121=121;
    public static final int PRE=67;
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
    public static final int MODELDECLARATIONPARAMETERS=64;
    public static final int BLOCK=55;
    public static final int FEATURECALL=56;
    public static final int FORMAL=21;
    public static final int POST=68;
    public static final int ARROW=9;
    public static final int ASSIGNMENT=23;
    public static final int EXTENDS=69;
    public static final int STRING=12;
    public static final int TITLE=72;

    // delegates
    // delegators
    public EwlParser gEwl;


        public Ewl_EwlParserRules(TokenStream input, EwlParser gEwl) {
            this(input, new RecognizerSharedState(), gEwl);
        }
        public Ewl_EwlParserRules(TokenStream input, RecognizerSharedState state, EwlParser gEwl) {
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
    public String getGrammarFileName() { return "EwlParserRules.g"; }


    public static class wizard_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start wizard
    // EwlParserRules.g:47:1: wizard : 'wizard' w= NAME '{' ( guard )? ( titleBlock )? ( doBlock )? '}' ;
    public final Ewl_EwlParserRules.wizard_return wizard() throws RecognitionException {
        Ewl_EwlParserRules.wizard_return retval = new Ewl_EwlParserRules.wizard_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token w=null;
        Token string_literal1=null;
        Token char_literal2=null;
        Token char_literal6=null;
        Ewl_ErlParserRules.guard_return guard3 = null;

        Ewl_EwlParserRules.titleBlock_return titleBlock4 = null;

        Ewl_EwlParserRules.doBlock_return doBlock5 = null;


        CommonTree w_tree=null;
        CommonTree string_literal1_tree=null;
        CommonTree char_literal2_tree=null;
        CommonTree char_literal6_tree=null;

        try {
            // EwlParserRules.g:48:2: ( 'wizard' w= NAME '{' ( guard )? ( titleBlock )? ( doBlock )? '}' )
            // EwlParserRules.g:48:4: 'wizard' w= NAME '{' ( guard )? ( titleBlock )? ( doBlock )? '}'
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal1=(Token)match(input,139,FOLLOW_139_in_wizard44); if (state.failed) return retval;
            w=(Token)match(input,NAME,FOLLOW_NAME_in_wizard49); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            w_tree = (CommonTree)adaptor.create(w);
            root_0 = (CommonTree)adaptor.becomeRoot(w_tree, root_0);
            }
            char_literal2=(Token)match(input,81,FOLLOW_81_in_wizard52); if (state.failed) return retval;
            // EwlParserRules.g:48:27: ( guard )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==137) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // EwlParserRules.g:0:0: guard
                    {
                    pushFollow(FOLLOW_guard_in_wizard55);
                    guard3=gEwl.guard();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, guard3.getTree());

                    }
                    break;

            }

            // EwlParserRules.g:48:34: ( titleBlock )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==140) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // EwlParserRules.g:0:0: titleBlock
                    {
                    pushFollow(FOLLOW_titleBlock_in_wizard58);
                    titleBlock4=titleBlock();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, titleBlock4.getTree());

                    }
                    break;

            }

            // EwlParserRules.g:48:46: ( doBlock )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==141) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // EwlParserRules.g:0:0: doBlock
                    {
                    pushFollow(FOLLOW_doBlock_in_wizard61);
                    doBlock5=doBlock();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, doBlock5.getTree());

                    }
                    break;

            }

            char_literal6=(Token)match(input,82,FOLLOW_82_in_wizard64); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
              w.setType(WIZARD);
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
    // $ANTLR end wizard

    public static class titleBlock_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start titleBlock
    // EwlParserRules.g:52:1: titleBlock : c= 'title' expressionOrStatementBlock ;
    public final Ewl_EwlParserRules.titleBlock_return titleBlock() throws RecognitionException {
        Ewl_EwlParserRules.titleBlock_return retval = new Ewl_EwlParserRules.titleBlock_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token c=null;
        Ewl_EolParserRules.expressionOrStatementBlock_return expressionOrStatementBlock7 = null;


        CommonTree c_tree=null;

        try {
            // EwlParserRules.g:53:2: (c= 'title' expressionOrStatementBlock )
            // EwlParserRules.g:53:4: c= 'title' expressionOrStatementBlock
            {
            root_0 = (CommonTree)adaptor.nil();

            c=(Token)match(input,140,FOLLOW_140_in_titleBlock81); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            c_tree = (CommonTree)adaptor.create(c);
            root_0 = (CommonTree)adaptor.becomeRoot(c_tree, root_0);
            }
            pushFollow(FOLLOW_expressionOrStatementBlock_in_titleBlock84);
            expressionOrStatementBlock7=gEwl.expressionOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionOrStatementBlock7.getTree());
            if ( state.backtracking==0 ) {
              c.setType(TITLE);
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
    // $ANTLR end titleBlock

    public static class doBlock_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start doBlock
    // EwlParserRules.g:57:1: doBlock : d= 'do' statementBlock ;
    public final Ewl_EwlParserRules.doBlock_return doBlock() throws RecognitionException {
        Ewl_EwlParserRules.doBlock_return retval = new Ewl_EwlParserRules.doBlock_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token d=null;
        Ewl_EolParserRules.statementBlock_return statementBlock8 = null;


        CommonTree d_tree=null;

        try {
            // EwlParserRules.g:58:2: (d= 'do' statementBlock )
            // EwlParserRules.g:58:4: d= 'do' statementBlock
            {
            root_0 = (CommonTree)adaptor.nil();

            d=(Token)match(input,141,FOLLOW_141_in_doBlock100); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            d_tree = (CommonTree)adaptor.create(d);
            root_0 = (CommonTree)adaptor.becomeRoot(d_tree, root_0);
            }
            pushFollow(FOLLOW_statementBlock_in_doBlock103);
            statementBlock8=gEwl.statementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, statementBlock8.getTree());
            if ( state.backtracking==0 ) {
              d.setType(DO);
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
    // $ANTLR end doBlock

    // Delegated rules


 

    public static final BitSet FOLLOW_139_in_wizard44 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NAME_in_wizard49 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_81_in_wizard52 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L,0x0000000000003200L});
    public static final BitSet FOLLOW_guard_in_wizard55 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L,0x0000000000003000L});
    public static final BitSet FOLLOW_titleBlock_in_wizard58 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L,0x0000000000002000L});
    public static final BitSet FOLLOW_doBlock_in_wizard61 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_82_in_wizard64 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_140_in_titleBlock81 = new BitSet(new long[]{0x0000000000000000L,0x0000000000022000L});
    public static final BitSet FOLLOW_expressionOrStatementBlock_in_titleBlock84 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_141_in_doBlock100 = new BitSet(new long[]{0x0000000000000000L,0x0000000000022000L});
    public static final BitSet FOLLOW_statementBlock_in_doBlock103 = new BitSet(new long[]{0x0000000000000002L});

}
