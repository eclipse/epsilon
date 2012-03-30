package org.eclipse.epsilon.epl.parse;

// $ANTLR 3.1b1 EplParserRules.g 2012-03-28 12:17:52

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
public class Epl_EplParserRules extends org.eclipse.epsilon.commons.parse.EpsilonParser {
    public static final int EXPONENT=6;
    public static final int T__159=159;
    public static final int WHILE=33;
    public static final int StatementBlock=29;
    public static final int T__158=158;
    public static final int StrangeNameLiteral=15;
    public static final int CASE=35;
    public static final int NEW=49;
    public static final int T__160=160;
    public static final int DO=87;
    public static final int FeatureCall=59;
    public static final int T__167=167;
    public static final int EOF=-1;
    public static final int T__168=168;
    public static final int T__165=165;
    public static final int BREAK=38;
    public static final int T__166=166;
    public static final int T__163=163;
    public static final int T__164=164;
    public static final int KEYVALLIST=75;
    public static final int TYPE=63;
    public static final int T__161=161;
    public static final int T__162=162;
    public static final int PATTERN=80;
    public static final int T__93=93;
    public static final int T__94=94;
    public static final int IMPORT=65;
    public static final int NAME=19;
    public static final int T__92=92;
    public static final int T__148=148;
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
    public static final int ACTIVE=90;
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
    public static final int EPLMODULE=91;
    public static final int ROLE=83;
    public static final int LINE_COMMENT=22;
    public static final int BREAKALL=39;
    public static final int TRANSACTION=41;
    public static final int SWITCH=34;
    public static final int DRIVER=69;
    public static final int NO=88;
    public static final int ELSE=32;
    public static final int EOLMODULE=60;
    public static final int MODELDECLARATION=66;
    public static final int PARAMLIST=25;
    public static final int MATCH=84;
    public static final int INT=8;
    public static final int DELETE=52;
    public static final int T__141=141;
    public static final int T__142=142;
    public static final int HELPERMETHOD=28;
    public static final int T__140=140;
    public static final int T__145=145;
    public static final int NAMESPACE=67;
    public static final int T__146=146;
    public static final int CollectionType=44;
    public static final int T__143=143;
    public static final int CARDINALITY=81;
    public static final int T__144=144;
    public static final int T__126=126;
    public static final int T__125=125;
    public static final int T__128=128;
    public static final int T__127=127;
    public static final int WS=20;
    public static final int T__129=129;
    public static final int ALIAS=68;
    public static final int JavaIDDigit=18;
    public static final int GUARD=79;
    public static final int Annotation=23;
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
    public static final int NOMATCH=85;
    public static final int OPERATOR=58;
    public static final int EXPRLIST=54;
    public static final int DEFAULT=36;
    public static final int T__102=102;
    public static final int T__101=101;
    public static final int T__100=100;
    public static final int DOMAIN=82;
    public static final int OPTIONAL=89;
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
    public static final int ONMATCH=86;
    public static final int STRING=14;

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
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start pattern
    // EplParserRules.g:64:1: pattern : 'pattern' c= NAME role ( ',' role )* ( '{' ( match | do_ | nomatch | onmatch )* '}' )? ;
    public final Epl_EplParserRules.pattern_return pattern() throws RecognitionException {
        Epl_EplParserRules.pattern_return retval = new Epl_EplParserRules.pattern_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token c=null;
        Token string_literal1=null;
        Token char_literal3=null;
        Token char_literal5=null;
        Token char_literal10=null;
        Epl_EplParserRules.role_return role2 = null;

        Epl_EplParserRules.role_return role4 = null;

        Epl_EplParserRules.match_return match6 = null;

        Epl_EplParserRules.do__return do_7 = null;

        Epl_EplParserRules.nomatch_return nomatch8 = null;

        Epl_EplParserRules.onmatch_return onmatch9 = null;


        CommonTree c_tree=null;
        CommonTree string_literal1_tree=null;
        CommonTree char_literal3_tree=null;
        CommonTree char_literal5_tree=null;
        CommonTree char_literal10_tree=null;

        try {
            // EplParserRules.g:65:2: ( 'pattern' c= NAME role ( ',' role )* ( '{' ( match | do_ | nomatch | onmatch )* '}' )? )
            // EplParserRules.g:66:2: 'pattern' c= NAME role ( ',' role )* ( '{' ( match | do_ | nomatch | onmatch )* '}' )?
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal1=(Token)match(input,160,FOLLOW_160_in_pattern88); if (state.failed) return retval;
            c=(Token)match(input,NAME,FOLLOW_NAME_in_pattern93); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            c_tree = (CommonTree)adaptor.create(c);
            root_0 = (CommonTree)adaptor.becomeRoot(c_tree, root_0);
            }
            pushFollow(FOLLOW_role_in_pattern96);
            role2=role();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, role2.getTree());
            // EplParserRules.g:66:26: ( ',' role )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==95) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // EplParserRules.g:66:27: ',' role
            	    {
            	    char_literal3=(Token)match(input,95,FOLLOW_95_in_pattern99); if (state.failed) return retval;
            	    pushFollow(FOLLOW_role_in_pattern102);
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

            // EplParserRules.g:66:39: ( '{' ( match | do_ | nomatch | onmatch )* '}' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==98) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // EplParserRules.g:66:40: '{' ( match | do_ | nomatch | onmatch )* '}'
                    {
                    char_literal5=(Token)match(input,98,FOLLOW_98_in_pattern107); if (state.failed) return retval;
                    // EplParserRules.g:66:45: ( match | do_ | nomatch | onmatch )*
                    loop2:
                    do {
                        int alt2=5;
                        switch ( input.LA(1) ) {
                        case 163:
                            {
                            alt2=1;
                            }
                            break;
                        case 166:
                            {
                            alt2=2;
                            }
                            break;
                        case 168:
                            {
                            alt2=3;
                            }
                            break;
                        case 167:
                            {
                            alt2=4;
                            }
                            break;

                        }

                        switch (alt2) {
                    	case 1 :
                    	    // EplParserRules.g:66:46: match
                    	    {
                    	    pushFollow(FOLLOW_match_in_pattern111);
                    	    match6=match();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, match6.getTree());

                    	    }
                    	    break;
                    	case 2 :
                    	    // EplParserRules.g:66:54: do_
                    	    {
                    	    pushFollow(FOLLOW_do__in_pattern115);
                    	    do_7=do_();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, do_7.getTree());

                    	    }
                    	    break;
                    	case 3 :
                    	    // EplParserRules.g:66:60: nomatch
                    	    {
                    	    pushFollow(FOLLOW_nomatch_in_pattern119);
                    	    nomatch8=nomatch();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, nomatch8.getTree());

                    	    }
                    	    break;
                    	case 4 :
                    	    // EplParserRules.g:66:70: onmatch
                    	    {
                    	    pushFollow(FOLLOW_onmatch_in_pattern123);
                    	    onmatch9=onmatch();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, onmatch9.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);

                    char_literal10=(Token)match(input,99,FOLLOW_99_in_pattern127); if (state.failed) return retval;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              c.setType(PATTERN);
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
    // $ANTLR end pattern

    public static class role_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start role
    // EplParserRules.g:70:1: role : ( no )? NAME ( ',' NAME )* n= ':' t= typeName ( cardinality )? ( domain | guard | optional | active )* ;
    public final Epl_EplParserRules.role_return role() throws RecognitionException {
        Epl_EplParserRules.role_return retval = new Epl_EplParserRules.role_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token n=null;
        Token NAME12=null;
        Token char_literal13=null;
        Token NAME14=null;
        Epl_EolParserRules.typeName_return t = null;

        Epl_EplParserRules.no_return no11 = null;

        Epl_EplParserRules.cardinality_return cardinality15 = null;

        Epl_EplParserRules.domain_return domain16 = null;

        Epl_ErlParserRules.guard_return guard17 = null;

        Epl_EplParserRules.optional_return optional18 = null;

        Epl_EplParserRules.active_return active19 = null;


        CommonTree n_tree=null;
        CommonTree NAME12_tree=null;
        CommonTree char_literal13_tree=null;
        CommonTree NAME14_tree=null;

        try {
            // EplParserRules.g:71:2: ( ( no )? NAME ( ',' NAME )* n= ':' t= typeName ( cardinality )? ( domain | guard | optional | active )* )
            // EplParserRules.g:71:4: ( no )? NAME ( ',' NAME )* n= ':' t= typeName ( cardinality )? ( domain | guard | optional | active )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // EplParserRules.g:71:4: ( no )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==161) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // EplParserRules.g:0:0: no
                    {
                    pushFollow(FOLLOW_no_in_role144);
                    no11=no();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, no11.getTree());

                    }
                    break;

            }

            NAME12=(Token)match(input,NAME,FOLLOW_NAME_in_role147); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME12_tree = (CommonTree)adaptor.create(NAME12);
            adaptor.addChild(root_0, NAME12_tree);
            }
            // EplParserRules.g:71:13: ( ',' NAME )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==95) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // EplParserRules.g:71:14: ',' NAME
            	    {
            	    char_literal13=(Token)match(input,95,FOLLOW_95_in_role150); if (state.failed) return retval;
            	    NAME14=(Token)match(input,NAME,FOLLOW_NAME_in_role153); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    NAME14_tree = (CommonTree)adaptor.create(NAME14);
            	    adaptor.addChild(root_0, NAME14_tree);
            	    }

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            n=(Token)match(input,94,FOLLOW_94_in_role159); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            n_tree = (CommonTree)adaptor.create(n);
            root_0 = (CommonTree)adaptor.becomeRoot(n_tree, root_0);
            }
            pushFollow(FOLLOW_typeName_in_role164);
            t=gEpl.typeName();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, t.getTree());
            if ( state.backtracking==0 ) {
              setTokenType(t, TYPE);
            }
            // EplParserRules.g:71:69: ( cardinality )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==151) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // EplParserRules.g:0:0: cardinality
                    {
                    pushFollow(FOLLOW_cardinality_in_role168);
                    cardinality15=cardinality();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, cardinality15.getTree());

                    }
                    break;

            }

            // EplParserRules.g:71:82: ( domain | guard | optional | active )*
            loop7:
            do {
                int alt7=5;
                switch ( input.LA(1) ) {
                case 119:
                case 162:
                    {
                    alt7=1;
                    }
                    break;
                case 158:
                    {
                    alt7=2;
                    }
                    break;
                case 164:
                    {
                    alt7=3;
                    }
                    break;
                case 165:
                    {
                    alt7=4;
                    }
                    break;

                }

                switch (alt7) {
            	case 1 :
            	    // EplParserRules.g:71:83: domain
            	    {
            	    pushFollow(FOLLOW_domain_in_role172);
            	    domain16=domain();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, domain16.getTree());

            	    }
            	    break;
            	case 2 :
            	    // EplParserRules.g:71:92: guard
            	    {
            	    pushFollow(FOLLOW_guard_in_role176);
            	    guard17=gEpl.guard();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, guard17.getTree());

            	    }
            	    break;
            	case 3 :
            	    // EplParserRules.g:71:100: optional
            	    {
            	    pushFollow(FOLLOW_optional_in_role180);
            	    optional18=optional();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, optional18.getTree());

            	    }
            	    break;
            	case 4 :
            	    // EplParserRules.g:71:111: active
            	    {
            	    pushFollow(FOLLOW_active_in_role184);
            	    active19=active();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, active19.getTree());

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
    // $ANTLR end role

    public static class no_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start no
    // EplParserRules.g:75:1: no : n= 'no' ;
    public final Epl_EplParserRules.no_return no() throws RecognitionException {
        Epl_EplParserRules.no_return retval = new Epl_EplParserRules.no_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token n=null;

        CommonTree n_tree=null;

        try {
            // EplParserRules.g:75:4: (n= 'no' )
            // EplParserRules.g:75:6: n= 'no'
            {
            root_0 = (CommonTree)adaptor.nil();

            n=(Token)match(input,161,FOLLOW_161_in_no201); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            n_tree = (CommonTree)adaptor.create(n);
            adaptor.addChild(root_0, n_tree);
            }
            if ( state.backtracking==0 ) {
              n.setType(NO);
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
    // $ANTLR end no

    public static class cardinality_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start cardinality
    // EplParserRules.g:77:1: cardinality : c= '[' bound ( '..' bound )? ']' ;
    public final Epl_EplParserRules.cardinality_return cardinality() throws RecognitionException {
        Epl_EplParserRules.cardinality_return retval = new Epl_EplParserRules.cardinality_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token c=null;
        Token string_literal21=null;
        Token char_literal23=null;
        Epl_EplParserRules.bound_return bound20 = null;

        Epl_EplParserRules.bound_return bound22 = null;


        CommonTree c_tree=null;
        CommonTree string_literal21_tree=null;
        CommonTree char_literal23_tree=null;

        try {
            // EplParserRules.g:78:2: (c= '[' bound ( '..' bound )? ']' )
            // EplParserRules.g:78:4: c= '[' bound ( '..' bound )? ']'
            {
            root_0 = (CommonTree)adaptor.nil();

            c=(Token)match(input,151,FOLLOW_151_in_cardinality214); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            c_tree = (CommonTree)adaptor.create(c);
            root_0 = (CommonTree)adaptor.becomeRoot(c_tree, root_0);
            }
            pushFollow(FOLLOW_bound_in_cardinality217);
            bound20=bound();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, bound20.getTree());
            // EplParserRules.g:78:17: ( '..' bound )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==POINT_POINT) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // EplParserRules.g:78:18: '..' bound
                    {
                    string_literal21=(Token)match(input,POINT_POINT,FOLLOW_POINT_POINT_in_cardinality220); if (state.failed) return retval;
                    pushFollow(FOLLOW_bound_in_cardinality223);
                    bound22=bound();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, bound22.getTree());

                    }
                    break;

            }

            char_literal23=(Token)match(input,152,FOLLOW_152_in_cardinality227); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
              c.setType(CARDINALITY);
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
    // $ANTLR end cardinality

    public static class bound_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start bound
    // EplParserRules.g:82:1: bound : ( INT | '*' );
    public final Epl_EplParserRules.bound_return bound() throws RecognitionException {
        Epl_EplParserRules.bound_return retval = new Epl_EplParserRules.bound_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set24=null;

        CommonTree set24_tree=null;

        try {
            // EplParserRules.g:83:2: ( INT | '*' )
            // EplParserRules.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set24=(Token)input.LT(1);
            if ( input.LA(1)==INT||input.LA(1)==148 ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set24));
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
    // $ANTLR end bound

    public static class domain_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start domain
    // EplParserRules.g:86:1: domain : (c= 'in' | c= 'from' ) expressionOrStatementBlock ;
    public final Epl_EplParserRules.domain_return domain() throws RecognitionException {
        Epl_EplParserRules.domain_return retval = new Epl_EplParserRules.domain_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token c=null;
        Epl_EolParserRules.expressionOrStatementBlock_return expressionOrStatementBlock25 = null;


        CommonTree c_tree=null;

        try {
            // EplParserRules.g:86:8: ( (c= 'in' | c= 'from' ) expressionOrStatementBlock )
            // EplParserRules.g:87:2: (c= 'in' | c= 'from' ) expressionOrStatementBlock
            {
            root_0 = (CommonTree)adaptor.nil();

            // EplParserRules.g:87:2: (c= 'in' | c= 'from' )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==119) ) {
                alt9=1;
            }
            else if ( (LA9_0==162) ) {
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
                    // EplParserRules.g:87:3: c= 'in'
                    {
                    c=(Token)match(input,119,FOLLOW_119_in_domain260); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    c_tree = (CommonTree)adaptor.create(c);
                    root_0 = (CommonTree)adaptor.becomeRoot(c_tree, root_0);
                    }

                    }
                    break;
                case 2 :
                    // EplParserRules.g:87:11: c= 'from'
                    {
                    c=(Token)match(input,162,FOLLOW_162_in_domain265); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    c_tree = (CommonTree)adaptor.create(c);
                    root_0 = (CommonTree)adaptor.becomeRoot(c_tree, root_0);
                    }

                    }
                    break;

            }

            pushFollow(FOLLOW_expressionOrStatementBlock_in_domain269);
            expressionOrStatementBlock25=gEpl.expressionOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionOrStatementBlock25.getTree());
            if ( state.backtracking==0 ) {
              c.setType(DOMAIN);
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
    // $ANTLR end domain

    public static class match_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start match
    // EplParserRules.g:91:1: match : c= 'match' expressionOrStatementBlock ;
    public final Epl_EplParserRules.match_return match() throws RecognitionException {
        Epl_EplParserRules.match_return retval = new Epl_EplParserRules.match_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token c=null;
        Epl_EolParserRules.expressionOrStatementBlock_return expressionOrStatementBlock26 = null;


        CommonTree c_tree=null;

        try {
            // EplParserRules.g:91:7: (c= 'match' expressionOrStatementBlock )
            // EplParserRules.g:92:2: c= 'match' expressionOrStatementBlock
            {
            root_0 = (CommonTree)adaptor.nil();

            c=(Token)match(input,163,FOLLOW_163_in_match286); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            c_tree = (CommonTree)adaptor.create(c);
            root_0 = (CommonTree)adaptor.becomeRoot(c_tree, root_0);
            }
            pushFollow(FOLLOW_expressionOrStatementBlock_in_match289);
            expressionOrStatementBlock26=gEpl.expressionOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionOrStatementBlock26.getTree());
            if ( state.backtracking==0 ) {
              c.setType(MATCH);
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
    // $ANTLR end match

    public static class optional_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start optional
    // EplParserRules.g:96:1: optional : c= 'optional' expressionOrStatementBlock ;
    public final Epl_EplParserRules.optional_return optional() throws RecognitionException {
        Epl_EplParserRules.optional_return retval = new Epl_EplParserRules.optional_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token c=null;
        Epl_EolParserRules.expressionOrStatementBlock_return expressionOrStatementBlock27 = null;


        CommonTree c_tree=null;

        try {
            // EplParserRules.g:96:10: (c= 'optional' expressionOrStatementBlock )
            // EplParserRules.g:97:2: c= 'optional' expressionOrStatementBlock
            {
            root_0 = (CommonTree)adaptor.nil();

            c=(Token)match(input,164,FOLLOW_164_in_optional305); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            c_tree = (CommonTree)adaptor.create(c);
            root_0 = (CommonTree)adaptor.becomeRoot(c_tree, root_0);
            }
            pushFollow(FOLLOW_expressionOrStatementBlock_in_optional308);
            expressionOrStatementBlock27=gEpl.expressionOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionOrStatementBlock27.getTree());
            if ( state.backtracking==0 ) {
              c.setType(OPTIONAL);
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
    // $ANTLR end optional

    public static class active_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start active
    // EplParserRules.g:101:1: active : c= 'active' expressionOrStatementBlock ;
    public final Epl_EplParserRules.active_return active() throws RecognitionException {
        Epl_EplParserRules.active_return retval = new Epl_EplParserRules.active_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token c=null;
        Epl_EolParserRules.expressionOrStatementBlock_return expressionOrStatementBlock28 = null;


        CommonTree c_tree=null;

        try {
            // EplParserRules.g:101:8: (c= 'active' expressionOrStatementBlock )
            // EplParserRules.g:102:2: c= 'active' expressionOrStatementBlock
            {
            root_0 = (CommonTree)adaptor.nil();

            c=(Token)match(input,165,FOLLOW_165_in_active324); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            c_tree = (CommonTree)adaptor.create(c);
            root_0 = (CommonTree)adaptor.becomeRoot(c_tree, root_0);
            }
            pushFollow(FOLLOW_expressionOrStatementBlock_in_active327);
            expressionOrStatementBlock28=gEpl.expressionOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionOrStatementBlock28.getTree());
            if ( state.backtracking==0 ) {
              c.setType(ACTIVE);
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
    // $ANTLR end active

    public static class do__return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start do_
    // EplParserRules.g:106:1: do_ : c= 'do' expressionOrStatementBlock ;
    public final Epl_EplParserRules.do__return do_() throws RecognitionException {
        Epl_EplParserRules.do__return retval = new Epl_EplParserRules.do__return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token c=null;
        Epl_EolParserRules.expressionOrStatementBlock_return expressionOrStatementBlock29 = null;


        CommonTree c_tree=null;

        try {
            // EplParserRules.g:106:5: (c= 'do' expressionOrStatementBlock )
            // EplParserRules.g:107:2: c= 'do' expressionOrStatementBlock
            {
            root_0 = (CommonTree)adaptor.nil();

            c=(Token)match(input,166,FOLLOW_166_in_do_345); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            c_tree = (CommonTree)adaptor.create(c);
            root_0 = (CommonTree)adaptor.becomeRoot(c_tree, root_0);
            }
            pushFollow(FOLLOW_expressionOrStatementBlock_in_do_348);
            expressionOrStatementBlock29=gEpl.expressionOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionOrStatementBlock29.getTree());
            if ( state.backtracking==0 ) {
              c.setType(DO);
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
    // $ANTLR end do_

    public static class onmatch_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start onmatch
    // EplParserRules.g:111:1: onmatch : c= 'onmatch' expressionOrStatementBlock ;
    public final Epl_EplParserRules.onmatch_return onmatch() throws RecognitionException {
        Epl_EplParserRules.onmatch_return retval = new Epl_EplParserRules.onmatch_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token c=null;
        Epl_EolParserRules.expressionOrStatementBlock_return expressionOrStatementBlock30 = null;


        CommonTree c_tree=null;

        try {
            // EplParserRules.g:111:9: (c= 'onmatch' expressionOrStatementBlock )
            // EplParserRules.g:112:2: c= 'onmatch' expressionOrStatementBlock
            {
            root_0 = (CommonTree)adaptor.nil();

            c=(Token)match(input,167,FOLLOW_167_in_onmatch364); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            c_tree = (CommonTree)adaptor.create(c);
            root_0 = (CommonTree)adaptor.becomeRoot(c_tree, root_0);
            }
            pushFollow(FOLLOW_expressionOrStatementBlock_in_onmatch367);
            expressionOrStatementBlock30=gEpl.expressionOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionOrStatementBlock30.getTree());
            if ( state.backtracking==0 ) {
              c.setType(ONMATCH);
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
    // $ANTLR end onmatch

    public static class nomatch_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start nomatch
    // EplParserRules.g:116:1: nomatch : c= 'nomatch' expressionOrStatementBlock ;
    public final Epl_EplParserRules.nomatch_return nomatch() throws RecognitionException {
        Epl_EplParserRules.nomatch_return retval = new Epl_EplParserRules.nomatch_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token c=null;
        Epl_EolParserRules.expressionOrStatementBlock_return expressionOrStatementBlock31 = null;


        CommonTree c_tree=null;

        try {
            // EplParserRules.g:116:9: (c= 'nomatch' expressionOrStatementBlock )
            // EplParserRules.g:117:2: c= 'nomatch' expressionOrStatementBlock
            {
            root_0 = (CommonTree)adaptor.nil();

            c=(Token)match(input,168,FOLLOW_168_in_nomatch385); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            c_tree = (CommonTree)adaptor.create(c);
            root_0 = (CommonTree)adaptor.becomeRoot(c_tree, root_0);
            }
            pushFollow(FOLLOW_expressionOrStatementBlock_in_nomatch388);
            expressionOrStatementBlock31=gEpl.expressionOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionOrStatementBlock31.getTree());
            if ( state.backtracking==0 ) {
              c.setType(NOMATCH);
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
    // $ANTLR end nomatch

    // Delegated rules


 

    public static final BitSet FOLLOW_160_in_pattern88 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_pattern93 = new BitSet(new long[]{0x0000000000080000L,0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_role_in_pattern96 = new BitSet(new long[]{0x0000000000000002L,0x0000000480000000L});
    public static final BitSet FOLLOW_95_in_pattern99 = new BitSet(new long[]{0x0000000000080000L,0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_role_in_pattern102 = new BitSet(new long[]{0x0000000000000002L,0x0000000480000000L});
    public static final BitSet FOLLOW_98_in_pattern107 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L,0x000001C800000000L});
    public static final BitSet FOLLOW_match_in_pattern111 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L,0x000001C800000000L});
    public static final BitSet FOLLOW_do__in_pattern115 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L,0x000001C800000000L});
    public static final BitSet FOLLOW_nomatch_in_pattern119 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L,0x000001C800000000L});
    public static final BitSet FOLLOW_onmatch_in_pattern123 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L,0x000001C800000000L});
    public static final BitSet FOLLOW_99_in_pattern127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_no_in_role144 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_role147 = new BitSet(new long[]{0x0000000000000000L,0x00000000C0000000L});
    public static final BitSet FOLLOW_95_in_role150 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_role153 = new BitSet(new long[]{0x0000000000000000L,0x00000000C0000000L});
    public static final BitSet FOLLOW_94_in_role159 = new BitSet(new long[]{0x0000000000080000L,0x003FC00000000000L});
    public static final BitSet FOLLOW_typeName_in_role164 = new BitSet(new long[]{0x0000000000000002L,0x0080000000000000L,0x0000003440800000L});
    public static final BitSet FOLLOW_cardinality_in_role168 = new BitSet(new long[]{0x0000000000000002L,0x0080000000000000L,0x0000003440000000L});
    public static final BitSet FOLLOW_domain_in_role172 = new BitSet(new long[]{0x0000000000000002L,0x0080000000000000L,0x0000003440000000L});
    public static final BitSet FOLLOW_guard_in_role176 = new BitSet(new long[]{0x0000000000000002L,0x0080000000000000L,0x0000003440000000L});
    public static final BitSet FOLLOW_optional_in_role180 = new BitSet(new long[]{0x0000000000000002L,0x0080000000000000L,0x0000003440000000L});
    public static final BitSet FOLLOW_active_in_role184 = new BitSet(new long[]{0x0000000000000002L,0x0080000000000000L,0x0000003440000000L});
    public static final BitSet FOLLOW_161_in_no201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_151_in_cardinality214 = new BitSet(new long[]{0x0000000000000100L,0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_bound_in_cardinality217 = new BitSet(new long[]{0x0000000000000400L,0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_POINT_POINT_in_cardinality220 = new BitSet(new long[]{0x0000000000000100L,0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_bound_in_cardinality223 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_152_in_cardinality227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_bound0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_119_in_domain260 = new BitSet(new long[]{0x0000000000000000L,0x0000000440000000L});
    public static final BitSet FOLLOW_162_in_domain265 = new BitSet(new long[]{0x0000000000000000L,0x0000000440000000L});
    public static final BitSet FOLLOW_expressionOrStatementBlock_in_domain269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_match286 = new BitSet(new long[]{0x0000000000000000L,0x0000000440000000L});
    public static final BitSet FOLLOW_expressionOrStatementBlock_in_match289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_164_in_optional305 = new BitSet(new long[]{0x0000000000000000L,0x0000000440000000L});
    public static final BitSet FOLLOW_expressionOrStatementBlock_in_optional308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_165_in_active324 = new BitSet(new long[]{0x0000000000000000L,0x0000000440000000L});
    public static final BitSet FOLLOW_expressionOrStatementBlock_in_active327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_166_in_do_345 = new BitSet(new long[]{0x0000000000000000L,0x0000000440000000L});
    public static final BitSet FOLLOW_expressionOrStatementBlock_in_do_348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_167_in_onmatch364 = new BitSet(new long[]{0x0000000000000000L,0x0000000440000000L});
    public static final BitSet FOLLOW_expressionOrStatementBlock_in_onmatch367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_168_in_nomatch385 = new BitSet(new long[]{0x0000000000000000L,0x0000000440000000L});
    public static final BitSet FOLLOW_expressionOrStatementBlock_in_nomatch388 = new BitSet(new long[]{0x0000000000000002L});

}
