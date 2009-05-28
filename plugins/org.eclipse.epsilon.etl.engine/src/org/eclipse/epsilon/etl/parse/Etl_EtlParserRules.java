package org.eclipse.epsilon.etl.parse;

// $ANTLR 3.1b1 EtlParserRules.g 2009-05-28 10:06:53

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
public class Etl_EtlParserRules extends org.eclipse.epsilon.commons.parse.EpsilonParser {
    public static final int WHILE=30;
    public static final int StatementBlock=26;
    public static final int StrangeNameLiteral=13;
    public static final int NEW=43;
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
    public static final int INT=6;
    public static final int DELETE=46;
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
    public static final int T__70=70;
    public static final int ALIAS=62;
    public static final int JavaIDDigit=15;
    public static final int GUARD=66;
    public static final int Annotation=20;
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int T__130=130;
    public static final int T__73=73;
    public static final int EscapeSequence=11;
    public static final int Letter=14;
    public static final int THROW=47;
    public static final int T__79=79;
    public static final int ETLMODULE=68;
    public static final int T__78=78;
    public static final int T__77=77;
    public static final int T__69=69;
    public static final int SPECIAL_ASSIGNMENT=24;
    public static final int PARAMETERS=40;
    public static final int POINT=7;
    public static final int T__118=118;
    public static final int T__119=119;
    public static final int T__116=116;
    public static final int T__117=117;
    public static final int T__114=114;
    public static final int T__115=115;
    public static final int TRANSFORM=67;
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
    public EtlParser gEtl;


        public Etl_EtlParserRules(TokenStream input, EtlParser gEtl) {
            this(input, new RecognizerSharedState(), gEtl);
        }
        public Etl_EtlParserRules(TokenStream input, RecognizerSharedState state, EtlParser gEtl) {
            super(input, state);
            this.gEtl = gEtl;
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return EtlParser.tokenNames; }
    public String getGrammarFileName() { return "EtlParserRules.g"; }


    public static class transformationRule_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start transformationRule
    // EtlParserRules.g:45:1: transformationRule : r= 'rule' rule= NAME 'transform' formalParameter 'to' formalParameterList ( extendz )? '{' ( guard )? block '}' ;
    public final Etl_EtlParserRules.transformationRule_return transformationRule() throws RecognitionException {
        Etl_EtlParserRules.transformationRule_return retval = new Etl_EtlParserRules.transformationRule_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token r=null;
        Token rule=null;
        Token string_literal1=null;
        Token string_literal3=null;
        Token char_literal6=null;
        Token char_literal9=null;
        Etl_EolParserRules.formalParameter_return formalParameter2 = null;

        Etl_EolParserRules.formalParameterList_return formalParameterList4 = null;

        Etl_ErlParserRules.extendz_return extendz5 = null;

        Etl_ErlParserRules.guard_return guard7 = null;

        Etl_EolParserRules.block_return block8 = null;


        CommonTree r_tree=null;
        CommonTree rule_tree=null;
        CommonTree string_literal1_tree=null;
        CommonTree string_literal3_tree=null;
        CommonTree char_literal6_tree=null;
        CommonTree char_literal9_tree=null;

        try {
            // EtlParserRules.g:46:2: (r= 'rule' rule= NAME 'transform' formalParameter 'to' formalParameterList ( extendz )? '{' ( guard )? block '}' )
            // EtlParserRules.g:46:4: r= 'rule' rule= NAME 'transform' formalParameter 'to' formalParameterList ( extendz )? '{' ( guard )? block '}'
            {
            root_0 = (CommonTree)adaptor.nil();

            r=(Token)match(input,128,FOLLOW_128_in_transformationRule39); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            r_tree = (CommonTree)adaptor.create(r);
            root_0 = (CommonTree)adaptor.becomeRoot(r_tree, root_0);
            }
            rule=(Token)match(input,NAME,FOLLOW_NAME_in_transformationRule44); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            rule_tree = (CommonTree)adaptor.create(rule);
            adaptor.addChild(root_0, rule_tree);
            }
            string_literal1=(Token)match(input,129,FOLLOW_129_in_transformationRule46); if (state.failed) return retval;
            pushFollow(FOLLOW_formalParameter_in_transformationRule49);
            formalParameter2=gEtl.formalParameter();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, formalParameter2.getTree());
            string_literal3=(Token)match(input,130,FOLLOW_130_in_transformationRule51); if (state.failed) return retval;
            pushFollow(FOLLOW_formalParameterList_in_transformationRule54);
            formalParameterList4=gEtl.formalParameterList();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, formalParameterList4.getTree());
            // EtlParserRules.g:47:2: ( extendz )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==127) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // EtlParserRules.g:0:0: extendz
                    {
                    pushFollow(FOLLOW_extendz_in_transformationRule57);
                    extendz5=gEtl.extendz();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, extendz5.getTree());

                    }
                    break;

            }

            char_literal6=(Token)match(input,78,FOLLOW_78_in_transformationRule60); if (state.failed) return retval;
            // EtlParserRules.g:47:16: ( guard )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==126) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // EtlParserRules.g:0:0: guard
                    {
                    pushFollow(FOLLOW_guard_in_transformationRule63);
                    guard7=gEtl.guard();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, guard7.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_block_in_transformationRule66);
            block8=gEtl.block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, block8.getTree());
            char_literal9=(Token)match(input,79,FOLLOW_79_in_transformationRule68); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
              r.setType(TRANSFORM);
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
    // $ANTLR end transformationRule

    // Delegated rules


 

    public static final BitSet FOLLOW_128_in_transformationRule39 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NAME_in_transformationRule44 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_129_in_transformationRule46 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_formalParameter_in_transformationRule49 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_130_in_transformationRule51 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_formalParameterList_in_transformationRule54 = new BitSet(new long[]{0x0000000000000000L,0x8000000000004000L});
    public static final BitSet FOLLOW_extendz_in_transformationRule57 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_transformationRule60 = new BitSet(new long[]{0x0000000000011450L,0x4D20007FD7F08800L});
    public static final BitSet FOLLOW_guard_in_transformationRule63 = new BitSet(new long[]{0x0000000000011450L,0x0D20007FD7F08800L});
    public static final BitSet FOLLOW_block_in_transformationRule66 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_transformationRule68 = new BitSet(new long[]{0x0000000000000002L});

}
