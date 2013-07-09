package org.eclipse.epsilon.evl.parse;

// $ANTLR 3.1b1 EvlParserRules.g 2013-07-09 11:27:28

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
public class Evl_EvlParserRules extends org.eclipse.epsilon.common.parse.EpsilonParser {
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
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start context
    // EvlParserRules.g:52:1: context : c= 'context' typeName ob= '{' ( guard )? ( contextContent )* cb= '}' ;
    public final Evl_EvlParserRules.context_return context() throws RecognitionException {
        Evl_EvlParserRules.context_return retval = new Evl_EvlParserRules.context_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token c=null;
        Token ob=null;
        Token cb=null;
        Evl_EolParserRules.typeName_return typeName1 = null;

        Evl_ErlParserRules.guard_return guard2 = null;

        Evl_EvlParserRules.contextContent_return contextContent3 = null;


        org.eclipse.epsilon.common.parse.AST c_tree=null;
        org.eclipse.epsilon.common.parse.AST ob_tree=null;
        org.eclipse.epsilon.common.parse.AST cb_tree=null;

        try {
            // EvlParserRules.g:57:2: (c= 'context' typeName ob= '{' ( guard )? ( contextContent )* cb= '}' )
            // EvlParserRules.g:58:2: c= 'context' typeName ob= '{' ( guard )? ( contextContent )* cb= '}'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            c=(Token)match(input,157,FOLLOW_157_in_context75); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            c_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(c);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(c_tree, root_0);
            }
            pushFollow(FOLLOW_typeName_in_context78);
            typeName1=gEvl.typeName();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, typeName1.getTree());
            ob=(Token)match(input,94,FOLLOW_94_in_context82); if (state.failed) return retval;
            // EvlParserRules.g:58:32: ( guard )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==155) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // EvlParserRules.g:0:0: guard
                    {
                    pushFollow(FOLLOW_guard_in_context85);
                    guard2=gEvl.guard();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, guard2.getTree());

                    }
                    break;

            }

            // EvlParserRules.g:58:39: ( contextContent )*
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
            	    pushFollow(FOLLOW_contextContent_in_context88);
            	    contextContent3=contextContent();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, contextContent3.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            cb=(Token)match(input,95,FOLLOW_95_in_context93); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
              c.setType(CONTEXT);
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
    // $ANTLR end context

    public static class contextContent_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start contextContent
    // EvlParserRules.g:62:1: contextContent : ( constraint | critique | annotationBlock );
    public final Evl_EvlParserRules.contextContent_return contextContent() throws RecognitionException {
        Evl_EvlParserRules.contextContent_return retval = new Evl_EvlParserRules.contextContent_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Evl_EvlParserRules.constraint_return constraint4 = null;

        Evl_EvlParserRules.critique_return critique5 = null;

        Evl_EolParserRules.annotationBlock_return annotationBlock6 = null;



        try {
            // EvlParserRules.g:63:2: ( constraint | critique | annotationBlock )
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
                    // EvlParserRules.g:63:4: constraint
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_constraint_in_contextContent109);
                    constraint4=constraint();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, constraint4.getTree());

                    }
                    break;
                case 2 :
                    // EvlParserRules.g:63:15: critique
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_critique_in_contextContent111);
                    critique5=critique();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, critique5.getTree());

                    }
                    break;
                case 3 :
                    // EvlParserRules.g:63:24: annotationBlock
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_annotationBlock_in_contextContent113);
                    annotationBlock6=gEvl.annotationBlock();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationBlock6.getTree());

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
    // $ANTLR end contextContent

    public static class constraint_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start constraint
    // EvlParserRules.g:66:1: constraint : ct= 'constraint' c= NAME ob= '{' ( guard )? check ( message )? ( fix )* cb= '}' ;
    public final Evl_EvlParserRules.constraint_return constraint() throws RecognitionException {
        Evl_EvlParserRules.constraint_return retval = new Evl_EvlParserRules.constraint_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token ct=null;
        Token c=null;
        Token ob=null;
        Token cb=null;
        Evl_ErlParserRules.guard_return guard7 = null;

        Evl_EvlParserRules.check_return check8 = null;

        Evl_EvlParserRules.message_return message9 = null;

        Evl_EvlParserRules.fix_return fix10 = null;


        org.eclipse.epsilon.common.parse.AST ct_tree=null;
        org.eclipse.epsilon.common.parse.AST c_tree=null;
        org.eclipse.epsilon.common.parse.AST ob_tree=null;
        org.eclipse.epsilon.common.parse.AST cb_tree=null;

        try {
            // EvlParserRules.g:72:2: (ct= 'constraint' c= NAME ob= '{' ( guard )? check ( message )? ( fix )* cb= '}' )
            // EvlParserRules.g:73:2: ct= 'constraint' c= NAME ob= '{' ( guard )? check ( message )? ( fix )* cb= '}'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            ct=(Token)match(input,158,FOLLOW_158_in_constraint135); if (state.failed) return retval;
            c=(Token)match(input,NAME,FOLLOW_NAME_in_constraint140); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            c_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(c);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(c_tree, root_0);
            }
            ob=(Token)match(input,94,FOLLOW_94_in_constraint145); if (state.failed) return retval;
            // EvlParserRules.g:73:35: ( guard )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==155) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // EvlParserRules.g:0:0: guard
                    {
                    pushFollow(FOLLOW_guard_in_constraint148);
                    guard7=gEvl.guard();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, guard7.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_check_in_constraint151);
            check8=check();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, check8.getTree());
            // EvlParserRules.g:73:48: ( message )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==161) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // EvlParserRules.g:0:0: message
                    {
                    pushFollow(FOLLOW_message_in_constraint153);
                    message9=message();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, message9.getTree());

                    }
                    break;

            }

            // EvlParserRules.g:73:57: ( fix )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==162) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // EvlParserRules.g:73:58: fix
            	    {
            	    pushFollow(FOLLOW_fix_in_constraint157);
            	    fix10=fix();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, fix10.getTree());

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            cb=(Token)match(input,95,FOLLOW_95_in_constraint163); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
              c.setType(CONSTRAINT);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {
              
              		((org.eclipse.epsilon.common.parse.AST)retval.tree).getExtraTokens().add(ct);
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
    // $ANTLR end constraint

    public static class critique_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start critique
    // EvlParserRules.g:77:1: critique : cr= 'critique' c= NAME ob= '{' ( guard )? check ( message )? ( fix )* cb= '}' ;
    public final Evl_EvlParserRules.critique_return critique() throws RecognitionException {
        Evl_EvlParserRules.critique_return retval = new Evl_EvlParserRules.critique_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token cr=null;
        Token c=null;
        Token ob=null;
        Token cb=null;
        Evl_ErlParserRules.guard_return guard11 = null;

        Evl_EvlParserRules.check_return check12 = null;

        Evl_EvlParserRules.message_return message13 = null;

        Evl_EvlParserRules.fix_return fix14 = null;


        org.eclipse.epsilon.common.parse.AST cr_tree=null;
        org.eclipse.epsilon.common.parse.AST c_tree=null;
        org.eclipse.epsilon.common.parse.AST ob_tree=null;
        org.eclipse.epsilon.common.parse.AST cb_tree=null;

        try {
            // EvlParserRules.g:83:2: (cr= 'critique' c= NAME ob= '{' ( guard )? check ( message )? ( fix )* cb= '}' )
            // EvlParserRules.g:84:2: cr= 'critique' c= NAME ob= '{' ( guard )? check ( message )? ( fix )* cb= '}'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            cr=(Token)match(input,159,FOLLOW_159_in_critique189); if (state.failed) return retval;
            c=(Token)match(input,NAME,FOLLOW_NAME_in_critique194); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            c_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(c);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(c_tree, root_0);
            }
            ob=(Token)match(input,94,FOLLOW_94_in_critique199); if (state.failed) return retval;
            // EvlParserRules.g:84:33: ( guard )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==155) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // EvlParserRules.g:0:0: guard
                    {
                    pushFollow(FOLLOW_guard_in_critique202);
                    guard11=gEvl.guard();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, guard11.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_check_in_critique205);
            check12=check();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, check12.getTree());
            // EvlParserRules.g:84:46: ( message )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==161) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // EvlParserRules.g:0:0: message
                    {
                    pushFollow(FOLLOW_message_in_critique207);
                    message13=message();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, message13.getTree());

                    }
                    break;

            }

            // EvlParserRules.g:84:55: ( fix )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==162) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // EvlParserRules.g:84:56: fix
            	    {
            	    pushFollow(FOLLOW_fix_in_critique211);
            	    fix14=fix();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, fix14.getTree());

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            cb=(Token)match(input,95,FOLLOW_95_in_critique217); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
              c.setType(CRITIQUE);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {
              
              		((org.eclipse.epsilon.common.parse.AST)retval.tree).getExtraTokens().add(cr);
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
    // $ANTLR end critique

    public static class check_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start check
    // EvlParserRules.g:88:1: check : c= 'check' expressionOrStatementBlock ;
    public final Evl_EvlParserRules.check_return check() throws RecognitionException {
        Evl_EvlParserRules.check_return retval = new Evl_EvlParserRules.check_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token c=null;
        Evl_EolParserRules.expressionOrStatementBlock_return expressionOrStatementBlock15 = null;


        org.eclipse.epsilon.common.parse.AST c_tree=null;

        try {
            // EvlParserRules.g:89:2: (c= 'check' expressionOrStatementBlock )
            // EvlParserRules.g:89:4: c= 'check' expressionOrStatementBlock
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            c=(Token)match(input,160,FOLLOW_160_in_check235); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            c_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(c);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(c_tree, root_0);
            }
            pushFollow(FOLLOW_expressionOrStatementBlock_in_check238);
            expressionOrStatementBlock15=gEvl.expressionOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionOrStatementBlock15.getTree());
            if ( state.backtracking==0 ) {
              c.setType(CHECK);
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
    // $ANTLR end check

    public static class message_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start message
    // EvlParserRules.g:93:1: message : m= 'message' expressionOrStatementBlock ;
    public final Evl_EvlParserRules.message_return message() throws RecognitionException {
        Evl_EvlParserRules.message_return retval = new Evl_EvlParserRules.message_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token m=null;
        Evl_EolParserRules.expressionOrStatementBlock_return expressionOrStatementBlock16 = null;


        org.eclipse.epsilon.common.parse.AST m_tree=null;

        try {
            // EvlParserRules.g:94:2: (m= 'message' expressionOrStatementBlock )
            // EvlParserRules.g:94:4: m= 'message' expressionOrStatementBlock
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            m=(Token)match(input,161,FOLLOW_161_in_message255); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            m_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(m);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(m_tree, root_0);
            }
            pushFollow(FOLLOW_expressionOrStatementBlock_in_message258);
            expressionOrStatementBlock16=gEvl.expressionOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionOrStatementBlock16.getTree());
            if ( state.backtracking==0 ) {
              m.setType(MESSAGE);
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
    // $ANTLR end message

    public static class fix_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start fix
    // EvlParserRules.g:98:1: fix : f= 'fix' ob= '{' ( guard )? title fixBody cb= '}' ;
    public final Evl_EvlParserRules.fix_return fix() throws RecognitionException {
        Evl_EvlParserRules.fix_return retval = new Evl_EvlParserRules.fix_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token f=null;
        Token ob=null;
        Token cb=null;
        Evl_ErlParserRules.guard_return guard17 = null;

        Evl_EvlParserRules.title_return title18 = null;

        Evl_EvlParserRules.fixBody_return fixBody19 = null;


        org.eclipse.epsilon.common.parse.AST f_tree=null;
        org.eclipse.epsilon.common.parse.AST ob_tree=null;
        org.eclipse.epsilon.common.parse.AST cb_tree=null;

        try {
            // EvlParserRules.g:103:2: (f= 'fix' ob= '{' ( guard )? title fixBody cb= '}' )
            // EvlParserRules.g:103:4: f= 'fix' ob= '{' ( guard )? title fixBody cb= '}'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            f=(Token)match(input,162,FOLLOW_162_in_fix282); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            f_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(f);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(f_tree, root_0);
            }
            ob=(Token)match(input,94,FOLLOW_94_in_fix287); if (state.failed) return retval;
            // EvlParserRules.g:103:21: ( guard )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==155) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // EvlParserRules.g:0:0: guard
                    {
                    pushFollow(FOLLOW_guard_in_fix290);
                    guard17=gEvl.guard();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, guard17.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_title_in_fix293);
            title18=title();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, title18.getTree());
            pushFollow(FOLLOW_fixBody_in_fix295);
            fixBody19=fixBody();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, fixBody19.getTree());
            cb=(Token)match(input,95,FOLLOW_95_in_fix299); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
              f.setType(FIX);
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
    // $ANTLR end fix

    public static class title_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start title
    // EvlParserRules.g:107:1: title : t= 'title' expressionOrStatementBlock ;
    public final Evl_EvlParserRules.title_return title() throws RecognitionException {
        Evl_EvlParserRules.title_return retval = new Evl_EvlParserRules.title_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token t=null;
        Evl_EolParserRules.expressionOrStatementBlock_return expressionOrStatementBlock20 = null;


        org.eclipse.epsilon.common.parse.AST t_tree=null;

        try {
            // EvlParserRules.g:108:2: (t= 'title' expressionOrStatementBlock )
            // EvlParserRules.g:108:4: t= 'title' expressionOrStatementBlock
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            t=(Token)match(input,163,FOLLOW_163_in_title316); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            t_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(t);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(t_tree, root_0);
            }
            pushFollow(FOLLOW_expressionOrStatementBlock_in_title319);
            expressionOrStatementBlock20=gEvl.expressionOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionOrStatementBlock20.getTree());
            if ( state.backtracking==0 ) {
              t.setType(TITLE);
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
    // $ANTLR end title

    public static class fixBody_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start fixBody
    // EvlParserRules.g:112:1: fixBody : d= 'do' statementBlock ;
    public final Evl_EvlParserRules.fixBody_return fixBody() throws RecognitionException {
        Evl_EvlParserRules.fixBody_return retval = new Evl_EvlParserRules.fixBody_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token d=null;
        Evl_EolParserRules.statementBlock_return statementBlock21 = null;


        org.eclipse.epsilon.common.parse.AST d_tree=null;

        try {
            // EvlParserRules.g:113:2: (d= 'do' statementBlock )
            // EvlParserRules.g:113:4: d= 'do' statementBlock
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            d=(Token)match(input,164,FOLLOW_164_in_fixBody336); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            d_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(d);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(d_tree, root_0);
            }
            pushFollow(FOLLOW_statementBlock_in_fixBody339);
            statementBlock21=gEvl.statementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, statementBlock21.getTree());
            if ( state.backtracking==0 ) {
              d.setType(DO);
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
    // $ANTLR end fixBody

    // Delegated rules


 

    public static final BitSet FOLLOW_157_in_context75 = new BitSet(new long[]{0x0000000000080000L,0x0007F80000000000L});
    public static final BitSet FOLLOW_typeName_in_context78 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_94_in_context82 = new BitSet(new long[]{0x0000000000800000L,0x0000008080000000L,0x00000000C8000000L});
    public static final BitSet FOLLOW_guard_in_context85 = new BitSet(new long[]{0x0000000000800000L,0x0000008080000000L,0x00000000C0000000L});
    public static final BitSet FOLLOW_contextContent_in_context88 = new BitSet(new long[]{0x0000000000800000L,0x0000008080000000L,0x00000000C0000000L});
    public static final BitSet FOLLOW_95_in_context93 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constraint_in_contextContent109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_critique_in_contextContent111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationBlock_in_contextContent113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_158_in_constraint135 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_constraint140 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_94_in_constraint145 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000108000000L});
    public static final BitSet FOLLOW_guard_in_constraint148 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000108000000L});
    public static final BitSet FOLLOW_check_in_constraint151 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L,0x0000000600000000L});
    public static final BitSet FOLLOW_message_in_constraint153 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_fix_in_constraint157 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_95_in_constraint163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_159_in_critique189 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_critique194 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_94_in_critique199 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000108000000L});
    public static final BitSet FOLLOW_guard_in_critique202 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000108000000L});
    public static final BitSet FOLLOW_check_in_critique205 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L,0x0000000600000000L});
    public static final BitSet FOLLOW_message_in_critique207 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_fix_in_critique211 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_95_in_critique217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_160_in_check235 = new BitSet(new long[]{0x0000000000000000L,0x0000002040000000L});
    public static final BitSet FOLLOW_expressionOrStatementBlock_in_check238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_161_in_message255 = new BitSet(new long[]{0x0000000000000000L,0x0000002040000000L});
    public static final BitSet FOLLOW_expressionOrStatementBlock_in_message258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_162_in_fix282 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_94_in_fix287 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000808000000L});
    public static final BitSet FOLLOW_guard_in_fix290 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000808000000L});
    public static final BitSet FOLLOW_title_in_fix293 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_fixBody_in_fix295 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_fix299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_title316 = new BitSet(new long[]{0x0000000000000000L,0x0000002040000000L});
    public static final BitSet FOLLOW_expressionOrStatementBlock_in_title319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_164_in_fixBody336 = new BitSet(new long[]{0x0000000000000000L,0x0000002040000000L});
    public static final BitSet FOLLOW_statementBlock_in_fixBody339 = new BitSet(new long[]{0x0000000000000002L});

}
