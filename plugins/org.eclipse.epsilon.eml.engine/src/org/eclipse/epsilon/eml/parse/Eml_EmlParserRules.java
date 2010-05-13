package org.eclipse.epsilon.eml.parse;

// $ANTLR 3.1b1 EmlParserRules.g 2010-05-13 17:09:10

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
public class Eml_EmlParserRules extends org.eclipse.epsilon.commons.parse.EpsilonParser {
    public static final int WHILE=31;
    public static final int StatementBlock=27;
    public static final int StrangeNameLiteral=13;
    public static final int NEW=44;
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
    public static final int T__143=143;
    public static final int T__144=144;
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
    public static final int T__75=75;
    public static final int T__130=130;
    public static final int T__131=131;
    public static final int EscapeSequence=11;
    public static final int Letter=14;
    public static final int THROW=48;
    public static final int T__132=132;
    public static final int T__79=79;
    public static final int T__133=133;
    public static final int T__78=78;
    public static final int T__134=134;
    public static final int T__77=77;
    public static final int T__135=135;
    public static final int EMLMODULE=74;
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
    public static final int TRANSFORM=72;
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
    public static final int MERGE=73;
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

    // delegates
    // delegators
    public EmlParser gEml;


        public Eml_EmlParserRules(TokenStream input, EmlParser gEml) {
            this(input, new RecognizerSharedState(), gEml);
        }
        public Eml_EmlParserRules(TokenStream input, RecognizerSharedState state, EmlParser gEml) {
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
    public String getGrammarFileName() { return "EmlParserRules.g"; }


    public static class mergeRule_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start mergeRule
    // EmlParserRules.g:45:1: mergeRule : r= 'rule' rule= NAME 'merge' formalParameter 'with' formalParameter 'into' formalParameterList ( extendz )? '{' ( guard )? block '}' ;
    public final Eml_EmlParserRules.mergeRule_return mergeRule() throws RecognitionException {
        Eml_EmlParserRules.mergeRule_return retval = new Eml_EmlParserRules.mergeRule_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token r=null;
        Token rule=null;
        Token string_literal1=null;
        Token string_literal3=null;
        Token string_literal5=null;
        Token char_literal8=null;
        Token char_literal11=null;
        Eml_EolParserRules.formalParameter_return formalParameter2 = null;

        Eml_EolParserRules.formalParameter_return formalParameter4 = null;

        Eml_EolParserRules.formalParameterList_return formalParameterList6 = null;

        Eml_ErlParserRules.extendz_return extendz7 = null;

        Eml_ErlParserRules.guard_return guard9 = null;

        Eml_EolParserRules.block_return block10 = null;


        CommonTree r_tree=null;
        CommonTree rule_tree=null;
        CommonTree string_literal1_tree=null;
        CommonTree string_literal3_tree=null;
        CommonTree string_literal5_tree=null;
        CommonTree char_literal8_tree=null;
        CommonTree char_literal11_tree=null;

        try {
            // EmlParserRules.g:46:2: (r= 'rule' rule= NAME 'merge' formalParameter 'with' formalParameter 'into' formalParameterList ( extendz )? '{' ( guard )? block '}' )
            // EmlParserRules.g:46:4: r= 'rule' rule= NAME 'merge' formalParameter 'with' formalParameter 'into' formalParameterList ( extendz )? '{' ( guard )? block '}'
            {
            root_0 = (CommonTree)adaptor.nil();

            r=(Token)match(input,139,FOLLOW_139_in_mergeRule38); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            r_tree = (CommonTree)adaptor.create(r);
            root_0 = (CommonTree)adaptor.becomeRoot(r_tree, root_0);
            }
            rule=(Token)match(input,NAME,FOLLOW_NAME_in_mergeRule43); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            rule_tree = (CommonTree)adaptor.create(rule);
            adaptor.addChild(root_0, rule_tree);
            }
            string_literal1=(Token)match(input,142,FOLLOW_142_in_mergeRule45); if (state.failed) return retval;
            pushFollow(FOLLOW_formalParameter_in_mergeRule48);
            formalParameter2=gEml.formalParameter();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, formalParameter2.getTree());
            string_literal3=(Token)match(input,143,FOLLOW_143_in_mergeRule50); if (state.failed) return retval;
            pushFollow(FOLLOW_formalParameter_in_mergeRule53);
            formalParameter4=gEml.formalParameter();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, formalParameter4.getTree());
            string_literal5=(Token)match(input,144,FOLLOW_144_in_mergeRule56); if (state.failed) return retval;
            pushFollow(FOLLOW_formalParameterList_in_mergeRule59);
            formalParameterList6=gEml.formalParameterList();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, formalParameterList6.getTree());
            // EmlParserRules.g:48:2: ( extendz )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==138) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // EmlParserRules.g:0:0: extendz
                    {
                    pushFollow(FOLLOW_extendz_in_mergeRule62);
                    extendz7=gEml.extendz();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, extendz7.getTree());

                    }
                    break;

            }

            char_literal8=(Token)match(input,81,FOLLOW_81_in_mergeRule65); if (state.failed) return retval;
            // EmlParserRules.g:48:16: ( guard )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==137) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // EmlParserRules.g:0:0: guard
                    {
                    pushFollow(FOLLOW_guard_in_mergeRule68);
                    guard9=gEml.guard();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, guard9.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_block_in_mergeRule71);
            block10=gEml.block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, block10.getTree());
            char_literal11=(Token)match(input,82,FOLLOW_82_in_mergeRule73); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
              r.setType(MERGE);
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
    // $ANTLR end mergeRule

    // Delegated rules


 

    public static final BitSet FOLLOW_139_in_mergeRule38 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NAME_in_mergeRule43 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_142_in_mergeRule45 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_formalParameter_in_mergeRule48 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_143_in_mergeRule50 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_formalParameter_in_mergeRule53 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_144_in_mergeRule56 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_formalParameterList_in_mergeRule59 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L,0x0000000000000400L});
    public static final BitSet FOLLOW_extendz_in_mergeRule62 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_81_in_mergeRule65 = new BitSet(new long[]{0x0000000000021450L,0x4001FF5FE0440000L,0x0000000000000262L});
    public static final BitSet FOLLOW_guard_in_mergeRule68 = new BitSet(new long[]{0x0000000000021450L,0x4001FF5FE0440000L,0x0000000000000062L});
    public static final BitSet FOLLOW_block_in_mergeRule71 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_82_in_mergeRule73 = new BitSet(new long[]{0x0000000000000002L});

}
