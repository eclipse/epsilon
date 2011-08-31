package org.eclipse.epsilon.evl.parse;

// $ANTLR 3.1b1 EvlParserRules.g 2011-08-31 12:47:56

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
public class Evl_EvlParserRules extends org.eclipse.epsilon.commons.parse.EpsilonParser {
    public static final int EXPONENT=6;
    public static final int FIX=83;
    public static final int T__159=159;
    public static final int WHILE=33;
    public static final int StatementBlock=29;
    public static final int T__158=158;
    public static final int StrangeNameLiteral=15;
    public static final int CASE=35;
    public static final int NEW=49;
    public static final int T__160=160;
    public static final int DO=85;
    public static final int FeatureCall=59;
    public static final int EOF=-1;
    public static final int BREAK=38;
    public static final int T__163=163;
    public static final int T__164=164;
    public static final int KEYVALLIST=75;
    public static final int TYPE=63;
    public static final int T__161=161;
    public static final int T__162=162;
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
    public static final int HELPERMETHOD=28;
    public static final int T__140=140;
    public static final int T__89=89;
    public static final int T__145=145;
    public static final int NAMESPACE=67;
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
    public static final int EVLMODULE=88;
    public static final int ALIAS=68;
    public static final int JavaIDDigit=18;
    public static final int CHECK=84;
    public static final int GUARD=79;
    public static final int Annotation=23;
    public static final int CONSTRAINT=80;
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
    public static final int CONTEXT=82;
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
    public static final int MESSAGE=87;
    public static final int T__113=113;
    public static final int T__112=112;
    public static final int COLLECTION=42;
    public static final int DIGIT=5;
    public static final int CRITIQUE=81;
    public static final int EXPRRANGE=55;
    public static final int OPERATOR=58;
    public static final int EXPRLIST=54;
    public static final int DEFAULT=36;
    public static final int T__102=102;
    public static final int T__101=101;
    public static final int T__100=100;
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
    public static final int STRING=14;
    public static final int TITLE=86;

    // delegates
    // delegators
    public EvlParser gEvl;


        public Evl_EvlParserRules(TokenStream input, EvlParser gEvl) {
            this(input, new RecognizerSharedState(), gEvl);
        }
        public Evl_EvlParserRules(TokenStream input, RecognizerSharedState state, EvlParser gEvl) {
            super(input, state);
            this.gEvl = gEvl;
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return EvlParser.tokenNames; }
    public String getGrammarFileName() { return "EvlParserRules.g"; }


    public static class context_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start context
    // EvlParserRules.g:52:1: context : c= 'context' typeName '{' ( guard )? ( contextContent )* '}' ;
    public final Evl_EvlParserRules.context_return context() throws RecognitionException {
        Evl_EvlParserRules.context_return retval = new Evl_EvlParserRules.context_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token c=null;
        Token char_literal2=null;
        Token char_literal5=null;
        Evl_EolParserRules.typeName_return typeName1 = null;

        Evl_ErlParserRules.guard_return guard3 = null;

        Evl_EvlParserRules.contextContent_return contextContent4 = null;


        CommonTree c_tree=null;
        CommonTree char_literal2_tree=null;
        CommonTree char_literal5_tree=null;

        try {
            // EvlParserRules.g:53:2: (c= 'context' typeName '{' ( guard )? ( contextContent )* '}' )
            // EvlParserRules.g:54:2: c= 'context' typeName '{' ( guard )? ( contextContent )* '}'
            {
            root_0 = (CommonTree)adaptor.nil();

            c=(Token)match(input,157,FOLLOW_157_in_context69); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            c_tree = (CommonTree)adaptor.create(c);
            root_0 = (CommonTree)adaptor.becomeRoot(c_tree, root_0);
            }
            pushFollow(FOLLOW_typeName_in_context72);
            typeName1=gEvl.typeName();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, typeName1.getTree());
            char_literal2=(Token)match(input,95,FOLLOW_95_in_context74); if (state.failed) return retval;
            // EvlParserRules.g:54:29: ( guard )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==155) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // EvlParserRules.g:0:0: guard
                    {
                    pushFollow(FOLLOW_guard_in_context77);
                    guard3=gEvl.guard();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, guard3.getTree());

                    }
                    break;

            }

            // EvlParserRules.g:54:36: ( contextContent )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==Annotation||LA2_0==103||(LA2_0>=158 && LA2_0<=159)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // EvlParserRules.g:0:0: contextContent
            	    {
            	    pushFollow(FOLLOW_contextContent_in_context80);
            	    contextContent4=contextContent();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, contextContent4.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            char_literal5=(Token)match(input,96,FOLLOW_96_in_context83); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
              c.setType(CONTEXT);
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
    // $ANTLR end context

    public static class contextContent_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start contextContent
    // EvlParserRules.g:58:1: contextContent : ( constraint | critique | annotationBlock );
    public final Evl_EvlParserRules.contextContent_return contextContent() throws RecognitionException {
        Evl_EvlParserRules.contextContent_return retval = new Evl_EvlParserRules.contextContent_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Evl_EvlParserRules.constraint_return constraint6 = null;

        Evl_EvlParserRules.critique_return critique7 = null;

        Evl_EolParserRules.annotationBlock_return annotationBlock8 = null;



        try {
            // EvlParserRules.g:59:2: ( constraint | critique | annotationBlock )
            int alt3=3;
            switch ( input.LA(1) ) {
            case 158:
                {
                alt3=1;
                }
                break;
            case 159:
                {
                alt3=2;
                }
                break;
            case Annotation:
            case 103:
                {
                alt3=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // EvlParserRules.g:59:4: constraint
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_constraint_in_contextContent99);
                    constraint6=constraint();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, constraint6.getTree());

                    }
                    break;
                case 2 :
                    // EvlParserRules.g:59:15: critique
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_critique_in_contextContent101);
                    critique7=critique();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, critique7.getTree());

                    }
                    break;
                case 3 :
                    // EvlParserRules.g:59:24: annotationBlock
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_annotationBlock_in_contextContent103);
                    annotationBlock8=gEvl.annotationBlock();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationBlock8.getTree());

                    }
                    break;

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
    // $ANTLR end contextContent

    public static class constraint_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start constraint
    // EvlParserRules.g:62:1: constraint : 'constraint' c= NAME '{' ( guard )? check ( message )? ( fix )* '}' ;
    public final Evl_EvlParserRules.constraint_return constraint() throws RecognitionException {
        Evl_EvlParserRules.constraint_return retval = new Evl_EvlParserRules.constraint_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token c=null;
        Token string_literal9=null;
        Token char_literal10=null;
        Token char_literal15=null;
        Evl_ErlParserRules.guard_return guard11 = null;

        Evl_EvlParserRules.check_return check12 = null;

        Evl_EvlParserRules.message_return message13 = null;

        Evl_EvlParserRules.fix_return fix14 = null;


        CommonTree c_tree=null;
        CommonTree string_literal9_tree=null;
        CommonTree char_literal10_tree=null;
        CommonTree char_literal15_tree=null;

        try {
            // EvlParserRules.g:63:2: ( 'constraint' c= NAME '{' ( guard )? check ( message )? ( fix )* '}' )
            // EvlParserRules.g:64:2: 'constraint' c= NAME '{' ( guard )? check ( message )? ( fix )* '}'
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal9=(Token)match(input,158,FOLLOW_158_in_constraint116); if (state.failed) return retval;
            c=(Token)match(input,NAME,FOLLOW_NAME_in_constraint121); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            c_tree = (CommonTree)adaptor.create(c);
            root_0 = (CommonTree)adaptor.becomeRoot(c_tree, root_0);
            }
            char_literal10=(Token)match(input,95,FOLLOW_95_in_constraint124); if (state.failed) return retval;
            // EvlParserRules.g:64:29: ( guard )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==155) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // EvlParserRules.g:0:0: guard
                    {
                    pushFollow(FOLLOW_guard_in_constraint127);
                    guard11=gEvl.guard();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, guard11.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_check_in_constraint130);
            check12=check();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, check12.getTree());
            // EvlParserRules.g:64:42: ( message )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==161) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // EvlParserRules.g:0:0: message
                    {
                    pushFollow(FOLLOW_message_in_constraint132);
                    message13=message();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, message13.getTree());

                    }
                    break;

            }

            // EvlParserRules.g:64:51: ( fix )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==162) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // EvlParserRules.g:64:52: fix
            	    {
            	    pushFollow(FOLLOW_fix_in_constraint136);
            	    fix14=fix();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, fix14.getTree());

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            char_literal15=(Token)match(input,96,FOLLOW_96_in_constraint140); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
              c.setType(CONSTRAINT);
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
    // $ANTLR end constraint

    public static class critique_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start critique
    // EvlParserRules.g:68:1: critique : 'critique' c= NAME '{' ( guard )? check ( message )? ( fix )* '}' ;
    public final Evl_EvlParserRules.critique_return critique() throws RecognitionException {
        Evl_EvlParserRules.critique_return retval = new Evl_EvlParserRules.critique_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token c=null;
        Token string_literal16=null;
        Token char_literal17=null;
        Token char_literal22=null;
        Evl_ErlParserRules.guard_return guard18 = null;

        Evl_EvlParserRules.check_return check19 = null;

        Evl_EvlParserRules.message_return message20 = null;

        Evl_EvlParserRules.fix_return fix21 = null;


        CommonTree c_tree=null;
        CommonTree string_literal16_tree=null;
        CommonTree char_literal17_tree=null;
        CommonTree char_literal22_tree=null;

        try {
            // EvlParserRules.g:69:2: ( 'critique' c= NAME '{' ( guard )? check ( message )? ( fix )* '}' )
            // EvlParserRules.g:70:2: 'critique' c= NAME '{' ( guard )? check ( message )? ( fix )* '}'
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal16=(Token)match(input,159,FOLLOW_159_in_critique157); if (state.failed) return retval;
            c=(Token)match(input,NAME,FOLLOW_NAME_in_critique162); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            c_tree = (CommonTree)adaptor.create(c);
            root_0 = (CommonTree)adaptor.becomeRoot(c_tree, root_0);
            }
            char_literal17=(Token)match(input,95,FOLLOW_95_in_critique165); if (state.failed) return retval;
            // EvlParserRules.g:70:27: ( guard )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==155) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // EvlParserRules.g:0:0: guard
                    {
                    pushFollow(FOLLOW_guard_in_critique168);
                    guard18=gEvl.guard();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, guard18.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_check_in_critique171);
            check19=check();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, check19.getTree());
            // EvlParserRules.g:70:40: ( message )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==161) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // EvlParserRules.g:0:0: message
                    {
                    pushFollow(FOLLOW_message_in_critique173);
                    message20=message();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, message20.getTree());

                    }
                    break;

            }

            // EvlParserRules.g:70:49: ( fix )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==162) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // EvlParserRules.g:70:50: fix
            	    {
            	    pushFollow(FOLLOW_fix_in_critique177);
            	    fix21=fix();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, fix21.getTree());

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            char_literal22=(Token)match(input,96,FOLLOW_96_in_critique181); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
              c.setType(CRITIQUE);
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
    // $ANTLR end critique

    public static class check_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start check
    // EvlParserRules.g:74:1: check : c= 'check' expressionOrStatementBlock ;
    public final Evl_EvlParserRules.check_return check() throws RecognitionException {
        Evl_EvlParserRules.check_return retval = new Evl_EvlParserRules.check_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token c=null;
        Evl_EolParserRules.expressionOrStatementBlock_return expressionOrStatementBlock23 = null;


        CommonTree c_tree=null;

        try {
            // EvlParserRules.g:75:2: (c= 'check' expressionOrStatementBlock )
            // EvlParserRules.g:75:4: c= 'check' expressionOrStatementBlock
            {
            root_0 = (CommonTree)adaptor.nil();

            c=(Token)match(input,160,FOLLOW_160_in_check199); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            c_tree = (CommonTree)adaptor.create(c);
            root_0 = (CommonTree)adaptor.becomeRoot(c_tree, root_0);
            }
            pushFollow(FOLLOW_expressionOrStatementBlock_in_check202);
            expressionOrStatementBlock23=gEvl.expressionOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionOrStatementBlock23.getTree());
            if ( state.backtracking==0 ) {
              c.setType(CHECK);
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
    // $ANTLR end check

    public static class message_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start message
    // EvlParserRules.g:79:1: message : m= 'message' expressionOrStatementBlock ;
    public final Evl_EvlParserRules.message_return message() throws RecognitionException {
        Evl_EvlParserRules.message_return retval = new Evl_EvlParserRules.message_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token m=null;
        Evl_EolParserRules.expressionOrStatementBlock_return expressionOrStatementBlock24 = null;


        CommonTree m_tree=null;

        try {
            // EvlParserRules.g:80:2: (m= 'message' expressionOrStatementBlock )
            // EvlParserRules.g:80:4: m= 'message' expressionOrStatementBlock
            {
            root_0 = (CommonTree)adaptor.nil();

            m=(Token)match(input,161,FOLLOW_161_in_message219); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            m_tree = (CommonTree)adaptor.create(m);
            root_0 = (CommonTree)adaptor.becomeRoot(m_tree, root_0);
            }
            pushFollow(FOLLOW_expressionOrStatementBlock_in_message222);
            expressionOrStatementBlock24=gEvl.expressionOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionOrStatementBlock24.getTree());
            if ( state.backtracking==0 ) {
              m.setType(MESSAGE);
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
    // $ANTLR end message

    public static class fix_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start fix
    // EvlParserRules.g:84:1: fix : f= 'fix' '{' ( guard )? title fixBody '}' ;
    public final Evl_EvlParserRules.fix_return fix() throws RecognitionException {
        Evl_EvlParserRules.fix_return retval = new Evl_EvlParserRules.fix_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token f=null;
        Token char_literal25=null;
        Token char_literal29=null;
        Evl_ErlParserRules.guard_return guard26 = null;

        Evl_EvlParserRules.title_return title27 = null;

        Evl_EvlParserRules.fixBody_return fixBody28 = null;


        CommonTree f_tree=null;
        CommonTree char_literal25_tree=null;
        CommonTree char_literal29_tree=null;

        try {
            // EvlParserRules.g:85:2: (f= 'fix' '{' ( guard )? title fixBody '}' )
            // EvlParserRules.g:85:4: f= 'fix' '{' ( guard )? title fixBody '}'
            {
            root_0 = (CommonTree)adaptor.nil();

            f=(Token)match(input,162,FOLLOW_162_in_fix239); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            f_tree = (CommonTree)adaptor.create(f);
            root_0 = (CommonTree)adaptor.becomeRoot(f_tree, root_0);
            }
            char_literal25=(Token)match(input,95,FOLLOW_95_in_fix242); if (state.failed) return retval;
            // EvlParserRules.g:85:18: ( guard )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==155) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // EvlParserRules.g:0:0: guard
                    {
                    pushFollow(FOLLOW_guard_in_fix245);
                    guard26=gEvl.guard();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, guard26.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_title_in_fix248);
            title27=title();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, title27.getTree());
            pushFollow(FOLLOW_fixBody_in_fix250);
            fixBody28=fixBody();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, fixBody28.getTree());
            char_literal29=(Token)match(input,96,FOLLOW_96_in_fix252); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
              f.setType(FIX);
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
    // $ANTLR end fix

    public static class title_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start title
    // EvlParserRules.g:89:1: title : t= 'title' expressionOrStatementBlock ;
    public final Evl_EvlParserRules.title_return title() throws RecognitionException {
        Evl_EvlParserRules.title_return retval = new Evl_EvlParserRules.title_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token t=null;
        Evl_EolParserRules.expressionOrStatementBlock_return expressionOrStatementBlock30 = null;


        CommonTree t_tree=null;

        try {
            // EvlParserRules.g:90:2: (t= 'title' expressionOrStatementBlock )
            // EvlParserRules.g:90:4: t= 'title' expressionOrStatementBlock
            {
            root_0 = (CommonTree)adaptor.nil();

            t=(Token)match(input,163,FOLLOW_163_in_title269); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            t_tree = (CommonTree)adaptor.create(t);
            root_0 = (CommonTree)adaptor.becomeRoot(t_tree, root_0);
            }
            pushFollow(FOLLOW_expressionOrStatementBlock_in_title272);
            expressionOrStatementBlock30=gEvl.expressionOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionOrStatementBlock30.getTree());
            if ( state.backtracking==0 ) {
              t.setType(TITLE);
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
    // $ANTLR end title

    public static class fixBody_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start fixBody
    // EvlParserRules.g:94:1: fixBody : d= 'do' statementBlock ;
    public final Evl_EvlParserRules.fixBody_return fixBody() throws RecognitionException {
        Evl_EvlParserRules.fixBody_return retval = new Evl_EvlParserRules.fixBody_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token d=null;
        Evl_EolParserRules.statementBlock_return statementBlock31 = null;


        CommonTree d_tree=null;

        try {
            // EvlParserRules.g:95:2: (d= 'do' statementBlock )
            // EvlParserRules.g:95:4: d= 'do' statementBlock
            {
            root_0 = (CommonTree)adaptor.nil();

            d=(Token)match(input,164,FOLLOW_164_in_fixBody289); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            d_tree = (CommonTree)adaptor.create(d);
            root_0 = (CommonTree)adaptor.becomeRoot(d_tree, root_0);
            }
            pushFollow(FOLLOW_statementBlock_in_fixBody292);
            statementBlock31=gEvl.statementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, statementBlock31.getTree());
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
    // $ANTLR end fixBody

    // Delegated rules


 

    public static final BitSet FOLLOW_157_in_context69 = new BitSet(new long[]{0x0000000000080000L,0x0007F80000000000L});
    public static final BitSet FOLLOW_typeName_in_context72 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_context74 = new BitSet(new long[]{0x0000000000800000L,0x0000008100000000L,0x00000000C8000000L});
    public static final BitSet FOLLOW_guard_in_context77 = new BitSet(new long[]{0x0000000000800000L,0x0000008100000000L,0x00000000C0000000L});
    public static final BitSet FOLLOW_contextContent_in_context80 = new BitSet(new long[]{0x0000000000800000L,0x0000008100000000L,0x00000000C0000000L});
    public static final BitSet FOLLOW_96_in_context83 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constraint_in_contextContent99 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_critique_in_contextContent101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationBlock_in_contextContent103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_158_in_constraint116 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_constraint121 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_constraint124 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000108000000L});
    public static final BitSet FOLLOW_guard_in_constraint127 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000108000000L});
    public static final BitSet FOLLOW_check_in_constraint130 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L,0x0000000600000000L});
    public static final BitSet FOLLOW_message_in_constraint132 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_fix_in_constraint136 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_96_in_constraint140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_159_in_critique157 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_critique162 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_critique165 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000108000000L});
    public static final BitSet FOLLOW_guard_in_critique168 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000108000000L});
    public static final BitSet FOLLOW_check_in_critique171 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L,0x0000000600000000L});
    public static final BitSet FOLLOW_message_in_critique173 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_fix_in_critique177 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_96_in_critique181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_160_in_check199 = new BitSet(new long[]{0x0000000000000000L,0x0000000088000000L});
    public static final BitSet FOLLOW_expressionOrStatementBlock_in_check202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_161_in_message219 = new BitSet(new long[]{0x0000000000000000L,0x0000000088000000L});
    public static final BitSet FOLLOW_expressionOrStatementBlock_in_message222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_162_in_fix239 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_fix242 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000808000000L});
    public static final BitSet FOLLOW_guard_in_fix245 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000808000000L});
    public static final BitSet FOLLOW_title_in_fix248 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_fixBody_in_fix250 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_96_in_fix252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_title269 = new BitSet(new long[]{0x0000000000000000L,0x0000000088000000L});
    public static final BitSet FOLLOW_expressionOrStatementBlock_in_title272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_164_in_fixBody289 = new BitSet(new long[]{0x0000000000000000L,0x0000000088000000L});
    public static final BitSet FOLLOW_statementBlock_in_fixBody292 = new BitSet(new long[]{0x0000000000000002L});

}
