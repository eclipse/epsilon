package org.eclipse.epsilon.egl.parse;

// $ANTLR 3.1b1 EgxParserRules.g 2011-12-04 02:44:01

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
public class Egx_EgxParserRules extends org.eclipse.epsilon.common.parse.EpsilonParser {
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
    public static final int T__131=131;
    public static final int EscapeSequence=13;
    public static final int Letter=16;
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


        public Egx_EgxParserRules(TokenStream input, EgxParser gEgx) {
            this(input, new RecognizerSharedState(), gEgx);
        }
        public Egx_EgxParserRules(TokenStream input, RecognizerSharedState state, EgxParser gEgx) {
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
    public String getGrammarFileName() { return "EgxParserRules.g"; }


    public static class generationRule_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start generationRule
    // EgxParserRules.g:50:1: generationRule : r= 'rule' rule= NAME 'transform' formalParameter '{' ( guard | target | template | parameters | pre | post | overwrite | protectRegions )* '}' ;
    public final Egx_EgxParserRules.generationRule_return generationRule() throws RecognitionException {
        Egx_EgxParserRules.generationRule_return retval = new Egx_EgxParserRules.generationRule_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token r=null;
        Token rule=null;
        Token string_literal1=null;
        Token char_literal3=null;
        Token char_literal12=null;
        Egx_EolParserRules.formalParameter_return formalParameter2 = null;

        Egx_ErlParserRules.guard_return guard4 = null;

        Egx_EgxParserRules.target_return target5 = null;

        Egx_EgxParserRules.template_return template6 = null;

        Egx_EgxParserRules.parameters_return parameters7 = null;

        Egx_ErlParserRules.pre_return pre8 = null;

        Egx_ErlParserRules.post_return post9 = null;

        Egx_EgxParserRules.overwrite_return overwrite10 = null;

        Egx_EgxParserRules.protectRegions_return protectRegions11 = null;


        CommonTree r_tree=null;
        CommonTree rule_tree=null;
        CommonTree string_literal1_tree=null;
        CommonTree char_literal3_tree=null;
        CommonTree char_literal12_tree=null;

        try {
            // EgxParserRules.g:51:2: (r= 'rule' rule= NAME 'transform' formalParameter '{' ( guard | target | template | parameters | pre | post | overwrite | protectRegions )* '}' )
            // EgxParserRules.g:51:4: r= 'rule' rule= NAME 'transform' formalParameter '{' ( guard | target | template | parameters | pre | post | overwrite | protectRegions )* '}'
            {
            root_0 = (CommonTree)adaptor.nil();

            r=(Token)match(input,154,FOLLOW_154_in_generationRule58); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            r_tree = (CommonTree)adaptor.create(r);
            root_0 = (CommonTree)adaptor.becomeRoot(r_tree, root_0);
            }
            rule=(Token)match(input,NAME,FOLLOW_NAME_in_generationRule63); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            rule_tree = (CommonTree)adaptor.create(rule);
            adaptor.addChild(root_0, rule_tree);
            }
            string_literal1=(Token)match(input,155,FOLLOW_155_in_generationRule65); if (state.failed) return retval;
            pushFollow(FOLLOW_formalParameter_in_generationRule68);
            formalParameter2=gEgx.formalParameter();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, formalParameter2.getTree());
            char_literal3=(Token)match(input,92,FOLLOW_92_in_generationRule71); if (state.failed) return retval;
            // EgxParserRules.g:52:7: ( guard | target | template | parameters | pre | post | overwrite | protectRegions )*
            loop1:
            do {
                int alt1=9;
                switch ( input.LA(1) ) {
                case 152:
                    {
                    alt1=1;
                    }
                    break;
                case 156:
                    {
                    alt1=2;
                    }
                    break;
                case 157:
                    {
                    alt1=3;
                    }
                    break;
                case 158:
                    {
                    alt1=4;
                    }
                    break;
                case 150:
                    {
                    alt1=5;
                    }
                    break;
                case 151:
                    {
                    alt1=6;
                    }
                    break;
                case 159:
                    {
                    alt1=7;
                    }
                    break;
                case 160:
                    {
                    alt1=8;
                    }
                    break;

                }

                switch (alt1) {
            	case 1 :
            	    // EgxParserRules.g:52:8: guard
            	    {
            	    pushFollow(FOLLOW_guard_in_generationRule75);
            	    guard4=gEgx.guard();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, guard4.getTree());

            	    }
            	    break;
            	case 2 :
            	    // EgxParserRules.g:52:16: target
            	    {
            	    pushFollow(FOLLOW_target_in_generationRule79);
            	    target5=target();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, target5.getTree());

            	    }
            	    break;
            	case 3 :
            	    // EgxParserRules.g:52:25: template
            	    {
            	    pushFollow(FOLLOW_template_in_generationRule83);
            	    template6=template();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, template6.getTree());

            	    }
            	    break;
            	case 4 :
            	    // EgxParserRules.g:52:36: parameters
            	    {
            	    pushFollow(FOLLOW_parameters_in_generationRule87);
            	    parameters7=parameters();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, parameters7.getTree());

            	    }
            	    break;
            	case 5 :
            	    // EgxParserRules.g:52:49: pre
            	    {
            	    pushFollow(FOLLOW_pre_in_generationRule91);
            	    pre8=gEgx.pre();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, pre8.getTree());

            	    }
            	    break;
            	case 6 :
            	    // EgxParserRules.g:52:55: post
            	    {
            	    pushFollow(FOLLOW_post_in_generationRule95);
            	    post9=gEgx.post();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, post9.getTree());

            	    }
            	    break;
            	case 7 :
            	    // EgxParserRules.g:52:62: overwrite
            	    {
            	    pushFollow(FOLLOW_overwrite_in_generationRule99);
            	    overwrite10=overwrite();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, overwrite10.getTree());

            	    }
            	    break;
            	case 8 :
            	    // EgxParserRules.g:52:74: protectRegions
            	    {
            	    pushFollow(FOLLOW_protectRegions_in_generationRule103);
            	    protectRegions11=protectRegions();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, protectRegions11.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            char_literal12=(Token)match(input,93,FOLLOW_93_in_generationRule107); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
              r.setType(GENERATE);
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
    // $ANTLR end generationRule

    public static class target_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start target
    // EgxParserRules.g:56:1: target : g= 'target' expressionOrStatementBlock ;
    public final Egx_EgxParserRules.target_return target() throws RecognitionException {
        Egx_EgxParserRules.target_return retval = new Egx_EgxParserRules.target_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token g=null;
        Egx_EolParserRules.expressionOrStatementBlock_return expressionOrStatementBlock13 = null;


        CommonTree g_tree=null;

        try {
            // EgxParserRules.g:57:2: (g= 'target' expressionOrStatementBlock )
            // EgxParserRules.g:57:4: g= 'target' expressionOrStatementBlock
            {
            root_0 = (CommonTree)adaptor.nil();

            g=(Token)match(input,156,FOLLOW_156_in_target124); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            g_tree = (CommonTree)adaptor.create(g);
            root_0 = (CommonTree)adaptor.becomeRoot(g_tree, root_0);
            }
            pushFollow(FOLLOW_expressionOrStatementBlock_in_target127);
            expressionOrStatementBlock13=gEgx.expressionOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionOrStatementBlock13.getTree());
            if ( state.backtracking==0 ) {
              g.setType(TARGET);
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
    // $ANTLR end target

    public static class template_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start template
    // EgxParserRules.g:61:1: template : g= 'template' expressionOrStatementBlock ;
    public final Egx_EgxParserRules.template_return template() throws RecognitionException {
        Egx_EgxParserRules.template_return retval = new Egx_EgxParserRules.template_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token g=null;
        Egx_EolParserRules.expressionOrStatementBlock_return expressionOrStatementBlock14 = null;


        CommonTree g_tree=null;

        try {
            // EgxParserRules.g:62:2: (g= 'template' expressionOrStatementBlock )
            // EgxParserRules.g:62:4: g= 'template' expressionOrStatementBlock
            {
            root_0 = (CommonTree)adaptor.nil();

            g=(Token)match(input,157,FOLLOW_157_in_template144); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            g_tree = (CommonTree)adaptor.create(g);
            root_0 = (CommonTree)adaptor.becomeRoot(g_tree, root_0);
            }
            pushFollow(FOLLOW_expressionOrStatementBlock_in_template147);
            expressionOrStatementBlock14=gEgx.expressionOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionOrStatementBlock14.getTree());
            if ( state.backtracking==0 ) {
              g.setType(TEMPLATE);
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
    // $ANTLR end template

    public static class parameters_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start parameters
    // EgxParserRules.g:66:1: parameters : g= 'parameters' expressionOrStatementBlock ;
    public final Egx_EgxParserRules.parameters_return parameters() throws RecognitionException {
        Egx_EgxParserRules.parameters_return retval = new Egx_EgxParserRules.parameters_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token g=null;
        Egx_EolParserRules.expressionOrStatementBlock_return expressionOrStatementBlock15 = null;


        CommonTree g_tree=null;

        try {
            // EgxParserRules.g:67:2: (g= 'parameters' expressionOrStatementBlock )
            // EgxParserRules.g:67:4: g= 'parameters' expressionOrStatementBlock
            {
            root_0 = (CommonTree)adaptor.nil();

            g=(Token)match(input,158,FOLLOW_158_in_parameters163); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            g_tree = (CommonTree)adaptor.create(g);
            root_0 = (CommonTree)adaptor.becomeRoot(g_tree, root_0);
            }
            pushFollow(FOLLOW_expressionOrStatementBlock_in_parameters166);
            expressionOrStatementBlock15=gEgx.expressionOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionOrStatementBlock15.getTree());
            if ( state.backtracking==0 ) {
              g.setType(PARAMETERS);
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
    // $ANTLR end parameters

    public static class overwrite_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start overwrite
    // EgxParserRules.g:71:1: overwrite : g= 'overwrite' expressionOrStatementBlock ;
    public final Egx_EgxParserRules.overwrite_return overwrite() throws RecognitionException {
        Egx_EgxParserRules.overwrite_return retval = new Egx_EgxParserRules.overwrite_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token g=null;
        Egx_EolParserRules.expressionOrStatementBlock_return expressionOrStatementBlock16 = null;


        CommonTree g_tree=null;

        try {
            // EgxParserRules.g:72:2: (g= 'overwrite' expressionOrStatementBlock )
            // EgxParserRules.g:72:4: g= 'overwrite' expressionOrStatementBlock
            {
            root_0 = (CommonTree)adaptor.nil();

            g=(Token)match(input,159,FOLLOW_159_in_overwrite183); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            g_tree = (CommonTree)adaptor.create(g);
            root_0 = (CommonTree)adaptor.becomeRoot(g_tree, root_0);
            }
            pushFollow(FOLLOW_expressionOrStatementBlock_in_overwrite186);
            expressionOrStatementBlock16=gEgx.expressionOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionOrStatementBlock16.getTree());
            if ( state.backtracking==0 ) {
              g.setType(OVERWRITE);
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
    // $ANTLR end overwrite

    public static class protectRegions_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start protectRegions
    // EgxParserRules.g:76:1: protectRegions : g= 'protectRegions' expressionOrStatementBlock ;
    public final Egx_EgxParserRules.protectRegions_return protectRegions() throws RecognitionException {
        Egx_EgxParserRules.protectRegions_return retval = new Egx_EgxParserRules.protectRegions_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token g=null;
        Egx_EolParserRules.expressionOrStatementBlock_return expressionOrStatementBlock17 = null;


        CommonTree g_tree=null;

        try {
            // EgxParserRules.g:77:2: (g= 'protectRegions' expressionOrStatementBlock )
            // EgxParserRules.g:77:4: g= 'protectRegions' expressionOrStatementBlock
            {
            root_0 = (CommonTree)adaptor.nil();

            g=(Token)match(input,160,FOLLOW_160_in_protectRegions203); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            g_tree = (CommonTree)adaptor.create(g);
            root_0 = (CommonTree)adaptor.becomeRoot(g_tree, root_0);
            }
            pushFollow(FOLLOW_expressionOrStatementBlock_in_protectRegions206);
            expressionOrStatementBlock17=gEgx.expressionOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionOrStatementBlock17.getTree());
            if ( state.backtracking==0 ) {
              g.setType(PROTECTREGIONS);
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
    // $ANTLR end protectRegions

    // Delegated rules


 

    public static final BitSet FOLLOW_154_in_generationRule58 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_generationRule63 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_155_in_generationRule65 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_formalParameter_in_generationRule68 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_92_in_generationRule71 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L,0x00000001F1C00000L});
    public static final BitSet FOLLOW_guard_in_generationRule75 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L,0x00000001F1C00000L});
    public static final BitSet FOLLOW_target_in_generationRule79 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L,0x00000001F1C00000L});
    public static final BitSet FOLLOW_template_in_generationRule83 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L,0x00000001F1C00000L});
    public static final BitSet FOLLOW_parameters_in_generationRule87 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L,0x00000001F1C00000L});
    public static final BitSet FOLLOW_pre_in_generationRule91 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L,0x00000001F1C00000L});
    public static final BitSet FOLLOW_post_in_generationRule95 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L,0x00000001F1C00000L});
    public static final BitSet FOLLOW_overwrite_in_generationRule99 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L,0x00000001F1C00000L});
    public static final BitSet FOLLOW_protectRegions_in_generationRule103 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L,0x00000001F1C00000L});
    public static final BitSet FOLLOW_93_in_generationRule107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_156_in_target124 = new BitSet(new long[]{0x0000000000000000L,0x0000000011000000L});
    public static final BitSet FOLLOW_expressionOrStatementBlock_in_target127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_157_in_template144 = new BitSet(new long[]{0x0000000000000000L,0x0000000011000000L});
    public static final BitSet FOLLOW_expressionOrStatementBlock_in_template147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_158_in_parameters163 = new BitSet(new long[]{0x0000000000000000L,0x0000000011000000L});
    public static final BitSet FOLLOW_expressionOrStatementBlock_in_parameters166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_159_in_overwrite183 = new BitSet(new long[]{0x0000000000000000L,0x0000000011000000L});
    public static final BitSet FOLLOW_expressionOrStatementBlock_in_overwrite186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_160_in_protectRegions203 = new BitSet(new long[]{0x0000000000000000L,0x0000000011000000L});
    public static final BitSet FOLLOW_expressionOrStatementBlock_in_protectRegions206 = new BitSet(new long[]{0x0000000000000002L});

}
