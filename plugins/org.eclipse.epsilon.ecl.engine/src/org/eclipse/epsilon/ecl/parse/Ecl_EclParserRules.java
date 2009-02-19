package org.eclipse.epsilon.ecl.parse;

// $ANTLR 3.1b1 EclParserRules.g 2009-02-17 10:15:28

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
public class Ecl_EclParserRules extends org.eclipse.epsilon.commons.parse.EpsilonParser {
    public static final int WHILE=30;
    public static final int StatementBlock=26;
    public static final int StrangeNameLiteral=13;
    public static final int NEW=43;
    public static final int DO=69;
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
    public static final int MODELDECLARATION=60;
    public static final int PARAMLIST=22;
    public static final int MATCH=67;
    public static final int INT=6;
    public static final int DELETE=46;
    public static final int ECLMODULE=70;
    public static final int T__85=85;
    public static final int T__84=84;
    public static final int T__87=87;
    public static final int T__86=86;
    public static final int HELPERMETHOD=25;
    public static final int T__89=89;
    public static final int NAMESPACE=61;
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
    public static final int ALIAS=62;
    public static final int JavaIDDigit=15;
    public static final int GUARD=66;
    public static final int Annotation=20;
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int T__130=130;
    public static final int T__73=73;
    public static final int T__131=131;
    public static final int EscapeSequence=11;
    public static final int Letter=14;
    public static final int THROW=47;
    public static final int T__132=132;
    public static final int T__79=79;
    public static final int T__133=133;
    public static final int T__78=78;
    public static final int T__77=77;
    public static final int SPECIAL_ASSIGNMENT=24;
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
    public static final int T__122=122;
    public static final int FOR=27;
    public static final int ENUMERATION_VALUE=58;
    public static final int T__121=121;
    public static final int PRE=63;
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
    public static final int COMPARE=68;
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
    public static final int BLOCK=55;
    public static final int FEATURECALL=56;
    public static final int FORMAL=21;
    public static final int POST=64;
    public static final int ARROW=9;
    public static final int ASSIGNMENT=23;
    public static final int EXTENDS=65;
    public static final int STRING=12;

    // delegates
    // delegators
    public EclParser gEcl;


        public Ecl_EclParserRules(TokenStream input, EclParser gEcl) {
            this(input, new RecognizerSharedState(), gEcl);
        }
        public Ecl_EclParserRules(TokenStream input, RecognizerSharedState state, EclParser gEcl) {
            super(input, state);
            this.gEcl = gEcl;
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return EclParser.tokenNames; }
    public String getGrammarFileName() { return "EclParserRules.g"; }


    public static class matchRule_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start matchRule
    // EclParserRules.g:47:1: matchRule : r= 'rule' rule= NAME 'match' formalParameter 'with' formalParameter ( extendz )? '{' ( guard )? ( compareBlock )? ( doBlock )? '}' ;
    public final Ecl_EclParserRules.matchRule_return matchRule() throws RecognitionException {
        Ecl_EclParserRules.matchRule_return retval = new Ecl_EclParserRules.matchRule_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token r=null;
        Token rule=null;
        Token string_literal1=null;
        Token string_literal3=null;
        Token char_literal6=null;
        Token char_literal10=null;
        Ecl_EolParserRules.formalParameter_return formalParameter2 = null;

        Ecl_EolParserRules.formalParameter_return formalParameter4 = null;

        Ecl_ErlParserRules.extendz_return extendz5 = null;

        Ecl_ErlParserRules.guard_return guard7 = null;

        Ecl_EclParserRules.compareBlock_return compareBlock8 = null;

        Ecl_EclParserRules.doBlock_return doBlock9 = null;


        CommonTree r_tree=null;
        CommonTree rule_tree=null;
        CommonTree string_literal1_tree=null;
        CommonTree string_literal3_tree=null;
        CommonTree char_literal6_tree=null;
        CommonTree char_literal10_tree=null;

        try {
            // EclParserRules.g:48:2: (r= 'rule' rule= NAME 'match' formalParameter 'with' formalParameter ( extendz )? '{' ( guard )? ( compareBlock )? ( doBlock )? '}' )
            // EclParserRules.g:48:4: r= 'rule' rule= NAME 'match' formalParameter 'with' formalParameter ( extendz )? '{' ( guard )? ( compareBlock )? ( doBlock )? '}'
            {
            root_0 = (CommonTree)adaptor.nil();

            r=(Token)match(input,129,FOLLOW_129_in_matchRule46); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            r_tree = (CommonTree)adaptor.create(r);
            root_0 = (CommonTree)adaptor.becomeRoot(r_tree, root_0);
            }
            rule=(Token)match(input,NAME,FOLLOW_NAME_in_matchRule51); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            rule_tree = (CommonTree)adaptor.create(rule);
            adaptor.addChild(root_0, rule_tree);
            }
            string_literal1=(Token)match(input,130,FOLLOW_130_in_matchRule53); if (state.failed) return retval;
            pushFollow(FOLLOW_formalParameter_in_matchRule56);
            formalParameter2=gEcl.formalParameter();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, formalParameter2.getTree());
            string_literal3=(Token)match(input,131,FOLLOW_131_in_matchRule58); if (state.failed) return retval;
            pushFollow(FOLLOW_formalParameter_in_matchRule61);
            formalParameter4=gEcl.formalParameter();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, formalParameter4.getTree());
            // EclParserRules.g:49:2: ( extendz )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==128) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // EclParserRules.g:0:0: extendz
                    {
                    pushFollow(FOLLOW_extendz_in_matchRule64);
                    extendz5=gEcl.extendz();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, extendz5.getTree());

                    }
                    break;

            }

            char_literal6=(Token)match(input,80,FOLLOW_80_in_matchRule67); if (state.failed) return retval;
            // EclParserRules.g:49:16: ( guard )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==127) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // EclParserRules.g:0:0: guard
                    {
                    pushFollow(FOLLOW_guard_in_matchRule70);
                    guard7=gEcl.guard();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, guard7.getTree());

                    }
                    break;

            }

            // EclParserRules.g:49:23: ( compareBlock )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==132) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // EclParserRules.g:0:0: compareBlock
                    {
                    pushFollow(FOLLOW_compareBlock_in_matchRule73);
                    compareBlock8=compareBlock();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, compareBlock8.getTree());

                    }
                    break;

            }

            // EclParserRules.g:49:37: ( doBlock )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==133) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // EclParserRules.g:0:0: doBlock
                    {
                    pushFollow(FOLLOW_doBlock_in_matchRule76);
                    doBlock9=doBlock();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, doBlock9.getTree());

                    }
                    break;

            }

            char_literal10=(Token)match(input,81,FOLLOW_81_in_matchRule79); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
              r.setType(MATCH);
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
    // $ANTLR end matchRule

    public static class compareBlock_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start compareBlock
    // EclParserRules.g:53:1: compareBlock : c= 'compare' expressionOrStatementBlock ;
    public final Ecl_EclParserRules.compareBlock_return compareBlock() throws RecognitionException {
        Ecl_EclParserRules.compareBlock_return retval = new Ecl_EclParserRules.compareBlock_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token c=null;
        Ecl_EolParserRules.expressionOrStatementBlock_return expressionOrStatementBlock11 = null;


        CommonTree c_tree=null;

        try {
            // EclParserRules.g:54:2: (c= 'compare' expressionOrStatementBlock )
            // EclParserRules.g:54:4: c= 'compare' expressionOrStatementBlock
            {
            root_0 = (CommonTree)adaptor.nil();

            c=(Token)match(input,132,FOLLOW_132_in_compareBlock96); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            c_tree = (CommonTree)adaptor.create(c);
            root_0 = (CommonTree)adaptor.becomeRoot(c_tree, root_0);
            }
            pushFollow(FOLLOW_expressionOrStatementBlock_in_compareBlock99);
            expressionOrStatementBlock11=gEcl.expressionOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionOrStatementBlock11.getTree());
            if ( state.backtracking==0 ) {
              c.setType(COMPARE);
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
    // $ANTLR end compareBlock

    public static class doBlock_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start doBlock
    // EclParserRules.g:58:1: doBlock : d= 'do' statementBlock ;
    public final Ecl_EclParserRules.doBlock_return doBlock() throws RecognitionException {
        Ecl_EclParserRules.doBlock_return retval = new Ecl_EclParserRules.doBlock_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token d=null;
        Ecl_EolParserRules.statementBlock_return statementBlock12 = null;


        CommonTree d_tree=null;

        try {
            // EclParserRules.g:59:2: (d= 'do' statementBlock )
            // EclParserRules.g:59:4: d= 'do' statementBlock
            {
            root_0 = (CommonTree)adaptor.nil();

            d=(Token)match(input,133,FOLLOW_133_in_doBlock115); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            d_tree = (CommonTree)adaptor.create(d);
            root_0 = (CommonTree)adaptor.becomeRoot(d_tree, root_0);
            }
            pushFollow(FOLLOW_statementBlock_in_doBlock118);
            statementBlock12=gEcl.statementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, statementBlock12.getTree());
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


 

    public static final BitSet FOLLOW_129_in_matchRule46 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NAME_in_matchRule51 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_130_in_matchRule53 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_formalParameter_in_matchRule56 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_131_in_matchRule58 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_formalParameter_in_matchRule61 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L,0x0000000000000001L});
    public static final BitSet FOLLOW_extendz_in_matchRule64 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_80_in_matchRule67 = new BitSet(new long[]{0x0000000000000000L,0x8000000000020000L,0x0000000000000030L});
    public static final BitSet FOLLOW_guard_in_matchRule70 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L,0x0000000000000030L});
    public static final BitSet FOLLOW_compareBlock_in_matchRule73 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L,0x0000000000000020L});
    public static final BitSet FOLLOW_doBlock_in_matchRule76 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_81_in_matchRule79 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_132_in_compareBlock96 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010200L});
    public static final BitSet FOLLOW_expressionOrStatementBlock_in_compareBlock99 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_133_in_doBlock115 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010200L});
    public static final BitSet FOLLOW_statementBlock_in_doBlock118 = new BitSet(new long[]{0x0000000000000002L});

}
