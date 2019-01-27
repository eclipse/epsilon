package org.eclipse.epsilon.epl.parse;

// $ANTLR 3.1b1 EplParserRules.g 2019-01-24 14:02:06

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
public class Epl_EplParserRules extends org.eclipse.epsilon.common.parse.EpsilonParser {
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


        public Epl_EplParserRules(TokenStream input, EplParser gEpl) {
            this(input, new RecognizerSharedState(), gEpl);
        }
        public Epl_EplParserRules(TokenStream input, RecognizerSharedState state, EplParser gEpl) {
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
    public String getGrammarFileName() { return "EplParserRules.g"; }

    
    
    public void setTokenType(ParserRuleReturnScope tree, int type) {
    	((CommonTree) tree.getTree()).getToken().setType(type);
    }
    


    public static class pattern_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start pattern
    // EplParserRules.g:64:1: pattern : pt= 'pattern' NAME role ( ',' role )* (ob= '{' ( match | do_ | nomatch | onmatch )* cb= '}' )? ;
    public final Epl_EplParserRules.pattern_return pattern() throws RecognitionException {
        Epl_EplParserRules.pattern_return retval = new Epl_EplParserRules.pattern_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token pt=null;
        Token ob=null;
        Token cb=null;
        Token NAME1=null;
        Token char_literal3=null;
        Epl_EplParserRules.role_return role2 = null;

        Epl_EplParserRules.role_return role4 = null;

        Epl_EplParserRules.match_return match5 = null;

        Epl_EplParserRules.do__return do_6 = null;

        Epl_EplParserRules.nomatch_return nomatch7 = null;

        Epl_EplParserRules.onmatch_return onmatch8 = null;


        org.eclipse.epsilon.common.parse.AST pt_tree=null;
        org.eclipse.epsilon.common.parse.AST ob_tree=null;
        org.eclipse.epsilon.common.parse.AST cb_tree=null;
        org.eclipse.epsilon.common.parse.AST NAME1_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal3_tree=null;

        try {
            // EplParserRules.g:70:2: (pt= 'pattern' NAME role ( ',' role )* (ob= '{' ( match | do_ | nomatch | onmatch )* cb= '}' )? )
            // EplParserRules.g:71:2: pt= 'pattern' NAME role ( ',' role )* (ob= '{' ( match | do_ | nomatch | onmatch )* cb= '}' )?
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            pt=(Token)match(input,169,FOLLOW_169_in_pattern95); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            pt_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(pt);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(pt_tree, root_0);
            }
            NAME1=(Token)match(input,NAME,FOLLOW_NAME_in_pattern98); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME1_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(NAME1);
            adaptor.addChild(root_0, NAME1_tree);
            }
            pushFollow(FOLLOW_role_in_pattern100);
            role2=role();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, role2.getTree());
            // EplParserRules.g:71:26: ( ',' role )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==97) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // EplParserRules.g:71:27: ',' role
            	    {
            	    char_literal3=(Token)match(input,97,FOLLOW_97_in_pattern103); if (state.failed) return retval;
            	    pushFollow(FOLLOW_role_in_pattern106);
            	    role4=role();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, role4.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // EplParserRules.g:71:39: (ob= '{' ( match | do_ | nomatch | onmatch )* cb= '}' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==99) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // EplParserRules.g:71:40: ob= '{' ( match | do_ | nomatch | onmatch )* cb= '}'
                    {
                    ob=(Token)match(input,99,FOLLOW_99_in_pattern113); if (state.failed) return retval;
                    // EplParserRules.g:71:48: ( match | do_ | nomatch | onmatch )*
                    loop2:
                    do {
                        int alt2=5;
                        switch ( input.LA(1) ) {
                        case 172:
                            {
                            alt2=1;
                            }
                            break;
                        case 175:
                            {
                            alt2=2;
                            }
                            break;
                        case 177:
                            {
                            alt2=3;
                            }
                            break;
                        case 176:
                            {
                            alt2=4;
                            }
                            break;

                        }

                        switch (alt2) {
                    	case 1 :
                    	    // EplParserRules.g:71:49: match
                    	    {
                    	    pushFollow(FOLLOW_match_in_pattern117);
                    	    match5=match();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, match5.getTree());

                    	    }
                    	    break;
                    	case 2 :
                    	    // EplParserRules.g:71:57: do_
                    	    {
                    	    pushFollow(FOLLOW_do__in_pattern121);
                    	    do_6=do_();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, do_6.getTree());

                    	    }
                    	    break;
                    	case 3 :
                    	    // EplParserRules.g:71:63: nomatch
                    	    {
                    	    pushFollow(FOLLOW_nomatch_in_pattern125);
                    	    nomatch7=nomatch();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, nomatch7.getTree());

                    	    }
                    	    break;
                    	case 4 :
                    	    // EplParserRules.g:71:73: onmatch
                    	    {
                    	    pushFollow(FOLLOW_onmatch_in_pattern129);
                    	    onmatch8=onmatch();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, onmatch8.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);

                    cb=(Token)match(input,100,FOLLOW_100_in_pattern135); if (state.failed) return retval;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              pt.setType(PATTERN);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {
              
              		((org.eclipse.epsilon.common.parse.AST)retval.tree).getExtraTokens().add(pt);
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
    // $ANTLR end pattern

    public static class role_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start role
    // EplParserRules.g:75:1: role : ( no )? NAME ( ',' NAME )* n= ':' t= typeName ( cardinality )? ( domain | guard | optional | active )* ;
    public final Epl_EplParserRules.role_return role() throws RecognitionException {
        Epl_EplParserRules.role_return retval = new Epl_EplParserRules.role_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token n=null;
        Token NAME10=null;
        Token char_literal11=null;
        Token NAME12=null;
        Epl_EolParserRules.typeName_return t = null;

        Epl_EplParserRules.no_return no9 = null;

        Epl_EplParserRules.cardinality_return cardinality13 = null;

        Epl_EplParserRules.domain_return domain14 = null;

        Epl_ErlParserRules.guard_return guard15 = null;

        Epl_EplParserRules.optional_return optional16 = null;

        Epl_EplParserRules.active_return active17 = null;


        org.eclipse.epsilon.common.parse.AST n_tree=null;
        org.eclipse.epsilon.common.parse.AST NAME10_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal11_tree=null;
        org.eclipse.epsilon.common.parse.AST NAME12_tree=null;

        try {
            // EplParserRules.g:76:2: ( ( no )? NAME ( ',' NAME )* n= ':' t= typeName ( cardinality )? ( domain | guard | optional | active )* )
            // EplParserRules.g:76:4: ( no )? NAME ( ',' NAME )* n= ':' t= typeName ( cardinality )? ( domain | guard | optional | active )*
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            // EplParserRules.g:76:4: ( no )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==170) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // EplParserRules.g:0:0: no
                    {
                    pushFollow(FOLLOW_no_in_role152);
                    no9=no();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, no9.getTree());

                    }
                    break;

            }

            NAME10=(Token)match(input,NAME,FOLLOW_NAME_in_role155); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME10_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(NAME10);
            adaptor.addChild(root_0, NAME10_tree);
            }
            // EplParserRules.g:76:13: ( ',' NAME )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==97) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // EplParserRules.g:76:14: ',' NAME
            	    {
            	    char_literal11=(Token)match(input,97,FOLLOW_97_in_role158); if (state.failed) return retval;
            	    NAME12=(Token)match(input,NAME,FOLLOW_NAME_in_role161); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    NAME12_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(NAME12);
            	    adaptor.addChild(root_0, NAME12_tree);
            	    }

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            n=(Token)match(input,106,FOLLOW_106_in_role167); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            n_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(n);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(n_tree, root_0);
            }
            pushFollow(FOLLOW_typeName_in_role172);
            t=gEpl.typeName();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, t.getTree());
            if ( state.backtracking==0 ) {
              setTokenType(t, TYPE);
            }
            // EplParserRules.g:76:69: ( cardinality )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==158) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // EplParserRules.g:0:0: cardinality
                    {
                    pushFollow(FOLLOW_cardinality_in_role176);
                    cardinality13=cardinality();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, cardinality13.getTree());

                    }
                    break;

            }

            // EplParserRules.g:76:82: ( domain | guard | optional | active )*
            loop7:
            do {
                int alt7=5;
                switch ( input.LA(1) ) {
                case 123:
                case 171:
                    {
                    alt7=1;
                    }
                    break;
                case 167:
                    {
                    alt7=2;
                    }
                    break;
                case 173:
                    {
                    alt7=3;
                    }
                    break;
                case 174:
                    {
                    alt7=4;
                    }
                    break;

                }

                switch (alt7) {
            	case 1 :
            	    // EplParserRules.g:76:83: domain
            	    {
            	    pushFollow(FOLLOW_domain_in_role180);
            	    domain14=domain();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, domain14.getTree());

            	    }
            	    break;
            	case 2 :
            	    // EplParserRules.g:76:92: guard
            	    {
            	    pushFollow(FOLLOW_guard_in_role184);
            	    guard15=gEpl.guard();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, guard15.getTree());

            	    }
            	    break;
            	case 3 :
            	    // EplParserRules.g:76:100: optional
            	    {
            	    pushFollow(FOLLOW_optional_in_role188);
            	    optional16=optional();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, optional16.getTree());

            	    }
            	    break;
            	case 4 :
            	    // EplParserRules.g:76:111: active
            	    {
            	    pushFollow(FOLLOW_active_in_role192);
            	    active17=active();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, active17.getTree());

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            if ( state.backtracking==0 ) {
              n.setType(ROLE);
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
    // $ANTLR end role

    public static class no_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start no
    // EplParserRules.g:80:1: no : n= 'no' ;
    public final Epl_EplParserRules.no_return no() throws RecognitionException {
        Epl_EplParserRules.no_return retval = new Epl_EplParserRules.no_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token n=null;

        org.eclipse.epsilon.common.parse.AST n_tree=null;

        try {
            // EplParserRules.g:80:4: (n= 'no' )
            // EplParserRules.g:80:6: n= 'no'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            n=(Token)match(input,170,FOLLOW_170_in_no209); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            n_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(n);
            adaptor.addChild(root_0, n_tree);
            }
            if ( state.backtracking==0 ) {
              n.setType(NO);
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
    // $ANTLR end no

    public static class cardinality_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start cardinality
    // EplParserRules.g:82:1: cardinality : c= '[' bound ( '..' bound )? cb= ']' ;
    public final Epl_EplParserRules.cardinality_return cardinality() throws RecognitionException {
        Epl_EplParserRules.cardinality_return retval = new Epl_EplParserRules.cardinality_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token c=null;
        Token cb=null;
        Token string_literal19=null;
        Epl_EplParserRules.bound_return bound18 = null;

        Epl_EplParserRules.bound_return bound20 = null;


        org.eclipse.epsilon.common.parse.AST c_tree=null;
        org.eclipse.epsilon.common.parse.AST cb_tree=null;
        org.eclipse.epsilon.common.parse.AST string_literal19_tree=null;

        try {
            // EplParserRules.g:86:2: (c= '[' bound ( '..' bound )? cb= ']' )
            // EplParserRules.g:86:4: c= '[' bound ( '..' bound )? cb= ']'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            c=(Token)match(input,158,FOLLOW_158_in_cardinality228); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            c_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(c);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(c_tree, root_0);
            }
            pushFollow(FOLLOW_bound_in_cardinality231);
            bound18=bound();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, bound18.getTree());
            // EplParserRules.g:86:17: ( '..' bound )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==POINT_POINT) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // EplParserRules.g:86:18: '..' bound
                    {
                    string_literal19=(Token)match(input,POINT_POINT,FOLLOW_POINT_POINT_in_cardinality234); if (state.failed) return retval;
                    pushFollow(FOLLOW_bound_in_cardinality237);
                    bound20=bound();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, bound20.getTree());

                    }
                    break;

            }

            cb=(Token)match(input,159,FOLLOW_159_in_cardinality243); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
              c.setType(CARDINALITY);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {
              
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
    // $ANTLR end cardinality

    public static class bound_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start bound
    // EplParserRules.g:90:1: bound : ( INT | '*' );
    public final Epl_EplParserRules.bound_return bound() throws RecognitionException {
        Epl_EplParserRules.bound_return retval = new Epl_EplParserRules.bound_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token set21=null;

        org.eclipse.epsilon.common.parse.AST set21_tree=null;

        try {
            // EplParserRules.g:91:2: ( INT | '*' )
            // EplParserRules.g:
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            set21=(Token)input.LT(1);
            if ( input.LA(1)==INT||input.LA(1)==154 ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (org.eclipse.epsilon.common.parse.AST)adaptor.create(set21));
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
    // $ANTLR end bound

    public static class domain_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start domain
    // EplParserRules.g:94:1: domain : (c= 'in' | c= 'from' ) expressionOrStatementBlock ;
    public final Epl_EplParserRules.domain_return domain() throws RecognitionException {
        Epl_EplParserRules.domain_return retval = new Epl_EplParserRules.domain_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token c=null;
        Epl_EolParserRules.expressionOrStatementBlock_return expressionOrStatementBlock22 = null;


        org.eclipse.epsilon.common.parse.AST c_tree=null;

        try {
            // EplParserRules.g:94:8: ( (c= 'in' | c= 'from' ) expressionOrStatementBlock )
            // EplParserRules.g:95:2: (c= 'in' | c= 'from' ) expressionOrStatementBlock
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            // EplParserRules.g:95:2: (c= 'in' | c= 'from' )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==123) ) {
                alt9=1;
            }
            else if ( (LA9_0==171) ) {
                alt9=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // EplParserRules.g:95:3: c= 'in'
                    {
                    c=(Token)match(input,123,FOLLOW_123_in_domain276); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    c_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(c);
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(c_tree, root_0);
                    }

                    }
                    break;
                case 2 :
                    // EplParserRules.g:95:11: c= 'from'
                    {
                    c=(Token)match(input,171,FOLLOW_171_in_domain281); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    c_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(c);
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(c_tree, root_0);
                    }

                    }
                    break;

            }

            pushFollow(FOLLOW_expressionOrStatementBlock_in_domain285);
            expressionOrStatementBlock22=gEpl.expressionOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionOrStatementBlock22.getTree());
            if ( state.backtracking==0 ) {
              c.setType(DOMAIN);
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
    // $ANTLR end domain

    public static class match_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start match
    // EplParserRules.g:99:1: match : c= 'match' expressionOrStatementBlock ;
    public final Epl_EplParserRules.match_return match() throws RecognitionException {
        Epl_EplParserRules.match_return retval = new Epl_EplParserRules.match_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token c=null;
        Epl_EolParserRules.expressionOrStatementBlock_return expressionOrStatementBlock23 = null;


        org.eclipse.epsilon.common.parse.AST c_tree=null;

        try {
            // EplParserRules.g:99:7: (c= 'match' expressionOrStatementBlock )
            // EplParserRules.g:100:2: c= 'match' expressionOrStatementBlock
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            c=(Token)match(input,172,FOLLOW_172_in_match301); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            c_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(c);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(c_tree, root_0);
            }
            pushFollow(FOLLOW_expressionOrStatementBlock_in_match304);
            expressionOrStatementBlock23=gEpl.expressionOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionOrStatementBlock23.getTree());
            if ( state.backtracking==0 ) {
              c.setType(MATCH);
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
    // $ANTLR end match

    public static class optional_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start optional
    // EplParserRules.g:104:1: optional : c= 'optional' expressionOrStatementBlock ;
    public final Epl_EplParserRules.optional_return optional() throws RecognitionException {
        Epl_EplParserRules.optional_return retval = new Epl_EplParserRules.optional_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token c=null;
        Epl_EolParserRules.expressionOrStatementBlock_return expressionOrStatementBlock24 = null;


        org.eclipse.epsilon.common.parse.AST c_tree=null;

        try {
            // EplParserRules.g:104:10: (c= 'optional' expressionOrStatementBlock )
            // EplParserRules.g:105:2: c= 'optional' expressionOrStatementBlock
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            c=(Token)match(input,173,FOLLOW_173_in_optional320); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            c_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(c);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(c_tree, root_0);
            }
            pushFollow(FOLLOW_expressionOrStatementBlock_in_optional323);
            expressionOrStatementBlock24=gEpl.expressionOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionOrStatementBlock24.getTree());
            if ( state.backtracking==0 ) {
              c.setType(OPTIONAL);
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
    // $ANTLR end optional

    public static class active_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start active
    // EplParserRules.g:109:1: active : c= 'active' expressionOrStatementBlock ;
    public final Epl_EplParserRules.active_return active() throws RecognitionException {
        Epl_EplParserRules.active_return retval = new Epl_EplParserRules.active_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token c=null;
        Epl_EolParserRules.expressionOrStatementBlock_return expressionOrStatementBlock25 = null;


        org.eclipse.epsilon.common.parse.AST c_tree=null;

        try {
            // EplParserRules.g:109:8: (c= 'active' expressionOrStatementBlock )
            // EplParserRules.g:110:2: c= 'active' expressionOrStatementBlock
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            c=(Token)match(input,174,FOLLOW_174_in_active339); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            c_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(c);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(c_tree, root_0);
            }
            pushFollow(FOLLOW_expressionOrStatementBlock_in_active342);
            expressionOrStatementBlock25=gEpl.expressionOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionOrStatementBlock25.getTree());
            if ( state.backtracking==0 ) {
              c.setType(ACTIVE);
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
    // $ANTLR end active

    public static class do__return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start do_
    // EplParserRules.g:114:1: do_ : c= 'do' expressionOrStatementBlock ;
    public final Epl_EplParserRules.do__return do_() throws RecognitionException {
        Epl_EplParserRules.do__return retval = new Epl_EplParserRules.do__return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token c=null;
        Epl_EolParserRules.expressionOrStatementBlock_return expressionOrStatementBlock26 = null;


        org.eclipse.epsilon.common.parse.AST c_tree=null;

        try {
            // EplParserRules.g:114:5: (c= 'do' expressionOrStatementBlock )
            // EplParserRules.g:115:2: c= 'do' expressionOrStatementBlock
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            c=(Token)match(input,175,FOLLOW_175_in_do_358); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            c_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(c);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(c_tree, root_0);
            }
            pushFollow(FOLLOW_expressionOrStatementBlock_in_do_361);
            expressionOrStatementBlock26=gEpl.expressionOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionOrStatementBlock26.getTree());
            if ( state.backtracking==0 ) {
              c.setType(DO);
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
    // $ANTLR end do_

    public static class onmatch_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start onmatch
    // EplParserRules.g:119:1: onmatch : c= 'onmatch' expressionOrStatementBlock ;
    public final Epl_EplParserRules.onmatch_return onmatch() throws RecognitionException {
        Epl_EplParserRules.onmatch_return retval = new Epl_EplParserRules.onmatch_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token c=null;
        Epl_EolParserRules.expressionOrStatementBlock_return expressionOrStatementBlock27 = null;


        org.eclipse.epsilon.common.parse.AST c_tree=null;

        try {
            // EplParserRules.g:119:9: (c= 'onmatch' expressionOrStatementBlock )
            // EplParserRules.g:120:2: c= 'onmatch' expressionOrStatementBlock
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            c=(Token)match(input,176,FOLLOW_176_in_onmatch377); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            c_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(c);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(c_tree, root_0);
            }
            pushFollow(FOLLOW_expressionOrStatementBlock_in_onmatch380);
            expressionOrStatementBlock27=gEpl.expressionOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionOrStatementBlock27.getTree());
            if ( state.backtracking==0 ) {
              c.setType(ONMATCH);
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
    // $ANTLR end onmatch

    public static class nomatch_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start nomatch
    // EplParserRules.g:124:1: nomatch : c= 'nomatch' expressionOrStatementBlock ;
    public final Epl_EplParserRules.nomatch_return nomatch() throws RecognitionException {
        Epl_EplParserRules.nomatch_return retval = new Epl_EplParserRules.nomatch_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token c=null;
        Epl_EolParserRules.expressionOrStatementBlock_return expressionOrStatementBlock28 = null;


        org.eclipse.epsilon.common.parse.AST c_tree=null;

        try {
            // EplParserRules.g:124:9: (c= 'nomatch' expressionOrStatementBlock )
            // EplParserRules.g:125:2: c= 'nomatch' expressionOrStatementBlock
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            c=(Token)match(input,177,FOLLOW_177_in_nomatch396); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            c_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(c);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(c_tree, root_0);
            }
            pushFollow(FOLLOW_expressionOrStatementBlock_in_nomatch399);
            expressionOrStatementBlock28=gEpl.expressionOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionOrStatementBlock28.getTree());
            if ( state.backtracking==0 ) {
              c.setType(NOMATCH);
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
    // $ANTLR end nomatch

    // Delegated rules


 

    public static final BitSet FOLLOW_169_in_pattern95 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_pattern98 = new BitSet(new long[]{0x0000000000080000L,0x0000000000000000L,0x0000040000000000L});
    public static final BitSet FOLLOW_role_in_pattern100 = new BitSet(new long[]{0x0000000000000002L,0x0000000A00000000L});
    public static final BitSet FOLLOW_97_in_pattern103 = new BitSet(new long[]{0x0000000000080000L,0x0000000000000000L,0x0000040000000000L});
    public static final BitSet FOLLOW_role_in_pattern106 = new BitSet(new long[]{0x0000000000000002L,0x0000000A00000000L});
    public static final BitSet FOLLOW_99_in_pattern113 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L,0x0003900000000000L});
    public static final BitSet FOLLOW_match_in_pattern117 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L,0x0003900000000000L});
    public static final BitSet FOLLOW_do__in_pattern121 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L,0x0003900000000000L});
    public static final BitSet FOLLOW_nomatch_in_pattern125 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L,0x0003900000000000L});
    public static final BitSet FOLLOW_onmatch_in_pattern129 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L,0x0003900000000000L});
    public static final BitSet FOLLOW_100_in_pattern135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_no_in_role152 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_role155 = new BitSet(new long[]{0x0000000000000000L,0x0000040200000000L});
    public static final BitSet FOLLOW_97_in_role158 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_role161 = new BitSet(new long[]{0x0000000000000000L,0x0000040200000000L});
    public static final BitSet FOLLOW_106_in_role167 = new BitSet(new long[]{0x0000000000080000L,0x00FF000000000000L});
    public static final BitSet FOLLOW_typeName_in_role172 = new BitSet(new long[]{0x0000000000000002L,0x0800000000000000L,0x0000688040000000L});
    public static final BitSet FOLLOW_cardinality_in_role176 = new BitSet(new long[]{0x0000000000000002L,0x0800000000000000L,0x0000688000000000L});
    public static final BitSet FOLLOW_domain_in_role180 = new BitSet(new long[]{0x0000000000000002L,0x0800000000000000L,0x0000688000000000L});
    public static final BitSet FOLLOW_guard_in_role184 = new BitSet(new long[]{0x0000000000000002L,0x0800000000000000L,0x0000688000000000L});
    public static final BitSet FOLLOW_optional_in_role188 = new BitSet(new long[]{0x0000000000000002L,0x0800000000000000L,0x0000688000000000L});
    public static final BitSet FOLLOW_active_in_role192 = new BitSet(new long[]{0x0000000000000002L,0x0800000000000000L,0x0000688000000000L});
    public static final BitSet FOLLOW_170_in_no209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_158_in_cardinality228 = new BitSet(new long[]{0x0000000000000100L,0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_bound_in_cardinality231 = new BitSet(new long[]{0x0000000000000400L,0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_POINT_POINT_in_cardinality234 = new BitSet(new long[]{0x0000000000000100L,0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_bound_in_cardinality237 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_159_in_cardinality243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_bound0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_123_in_domain276 = new BitSet(new long[]{0x0000000000000000L,0x0000040800000000L});
    public static final BitSet FOLLOW_171_in_domain281 = new BitSet(new long[]{0x0000000000000000L,0x0000040800000000L});
    public static final BitSet FOLLOW_expressionOrStatementBlock_in_domain285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_172_in_match301 = new BitSet(new long[]{0x0000000000000000L,0x0000040800000000L});
    public static final BitSet FOLLOW_expressionOrStatementBlock_in_match304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_173_in_optional320 = new BitSet(new long[]{0x0000000000000000L,0x0000040800000000L});
    public static final BitSet FOLLOW_expressionOrStatementBlock_in_optional323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_174_in_active339 = new BitSet(new long[]{0x0000000000000000L,0x0000040800000000L});
    public static final BitSet FOLLOW_expressionOrStatementBlock_in_active342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_175_in_do_358 = new BitSet(new long[]{0x0000000000000000L,0x0000040800000000L});
    public static final BitSet FOLLOW_expressionOrStatementBlock_in_do_361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_176_in_onmatch377 = new BitSet(new long[]{0x0000000000000000L,0x0000040800000000L});
    public static final BitSet FOLLOW_expressionOrStatementBlock_in_onmatch380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_177_in_nomatch396 = new BitSet(new long[]{0x0000000000000000L,0x0000040800000000L});
    public static final BitSet FOLLOW_expressionOrStatementBlock_in_nomatch399 = new BitSet(new long[]{0x0000000000000002L});

}
