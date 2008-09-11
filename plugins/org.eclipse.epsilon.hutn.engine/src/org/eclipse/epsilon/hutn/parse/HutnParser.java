// $ANTLR 3.1b1 /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g 2008-08-15 10:58:58

package org.eclipse.epsilon.hutn.parse;


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
 *     Louis Rose - initial API and implementation
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
public class HutnParser extends org.eclipse.epsilon.commons.parse.EpsilonParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "TRUE", "FALSE", "NULL", "ADJECTIVE", "CLS_LVL_ATTRIBUTE", "ASSOC_INSTANCE", "REFERENCE", "NAME", "TEXTUAL_VALUE", "LBRACKET", "RBRACKET", "ASSIGNMENT", "ADJECTIVE_PREFIX", "COMMA", "NUMERIC_VALUE", "ID_START_LETTER", "ID_LETTER", "TEXT_LETTER", "DIGIT", "WS", "ML_COMMENT", "SL_COMMENT", "';'", "'.'"
    };
    public static final int ID_START_LETTER=19;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int ID_LETTER=20;
    public static final int CLS_LVL_ATTRIBUTE=8;
    public static final int NULL=6;
    public static final int REFERENCE=10;
    public static final int ADJECTIVE_PREFIX=16;
    public static final int EOF=-1;
    public static final int TRUE=4;
    public static final int LBRACKET=13;
    public static final int ML_COMMENT=24;
    public static final int NAME=11;
    public static final int WS=23;
    public static final int NUMERIC_VALUE=18;
    public static final int TEXTUAL_VALUE=12;
    public static final int COMMA=17;
    public static final int SL_COMMENT=25;
    public static final int ASSIGNMENT=15;
    public static final int DIGIT=22;
    public static final int RBRACKET=14;
    public static final int ADJECTIVE=7;
    public static final int FALSE=5;
    public static final int ASSOC_INSTANCE=9;
    public static final int TEXT_LETTER=21;

    // delegates
    // delegators


        public HutnParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public HutnParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return HutnParser.tokenNames; }
    public String getGrammarFileName() { return "/local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g"; }


    public static class document_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start document
    // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:97:1: document : ( pkg )* ;
    public final HutnParser.document_return document() throws RecognitionException {
        HutnParser.document_return retval = new HutnParser.document_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        HutnParser.pkg_return pkg1 = null;



        try {
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:97:9: ( ( pkg )* )
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:97:11: ( pkg )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:97:11: ( pkg )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==NAME) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:0:0: pkg
            	    {
            	    pushFollow(FOLLOW_pkg_in_document124);
            	    pkg1=pkg();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, pkg1.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


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
    // $ANTLR end document

    public static class pkg_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start pkg
    // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:99:1: pkg : NAME ( TEXTUAL_VALUE )? LBRACKET ( pkg_contents )* RBRACKET ;
    public final HutnParser.pkg_return pkg() throws RecognitionException {
        HutnParser.pkg_return retval = new HutnParser.pkg_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NAME2=null;
        Token TEXTUAL_VALUE3=null;
        Token LBRACKET4=null;
        Token RBRACKET6=null;
        HutnParser.pkg_contents_return pkg_contents5 = null;


        CommonTree NAME2_tree=null;
        CommonTree TEXTUAL_VALUE3_tree=null;
        CommonTree LBRACKET4_tree=null;
        CommonTree RBRACKET6_tree=null;

        try {
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:99:4: ( NAME ( TEXTUAL_VALUE )? LBRACKET ( pkg_contents )* RBRACKET )
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:99:6: NAME ( TEXTUAL_VALUE )? LBRACKET ( pkg_contents )* RBRACKET
            {
            root_0 = (CommonTree)adaptor.nil();

            NAME2=(Token)match(input,NAME,FOLLOW_NAME_in_pkg132); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME2_tree = (CommonTree)adaptor.create(NAME2);
            root_0 = (CommonTree)adaptor.becomeRoot(NAME2_tree, root_0);
            }
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:99:12: ( TEXTUAL_VALUE )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==TEXTUAL_VALUE) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:0:0: TEXTUAL_VALUE
                    {
                    TEXTUAL_VALUE3=(Token)match(input,TEXTUAL_VALUE,FOLLOW_TEXTUAL_VALUE_in_pkg135); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TEXTUAL_VALUE3_tree = (CommonTree)adaptor.create(TEXTUAL_VALUE3);
                    adaptor.addChild(root_0, TEXTUAL_VALUE3_tree);
                    }

                    }
                    break;

            }

            LBRACKET4=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_pkg138); if (state.failed) return retval;
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:99:37: ( pkg_contents )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==NAME||LA3_0==ADJECTIVE_PREFIX) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:0:0: pkg_contents
            	    {
            	    pushFollow(FOLLOW_pkg_contents_in_pkg141);
            	    pkg_contents5=pkg_contents();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, pkg_contents5.getTree());

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            RBRACKET6=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_pkg144); if (state.failed) return retval;

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
    // $ANTLR end pkg

    public static class pkg_contents_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start pkg_contents
    // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:101:1: pkg_contents : ( cls | cls_level_attribute | assoc_instance );
    public final HutnParser.pkg_contents_return pkg_contents() throws RecognitionException {
        HutnParser.pkg_contents_return retval = new HutnParser.pkg_contents_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        HutnParser.cls_return cls7 = null;

        HutnParser.cls_level_attribute_return cls_level_attribute8 = null;

        HutnParser.assoc_instance_return assoc_instance9 = null;



        try {
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:101:13: ( cls | cls_level_attribute | assoc_instance )
            int alt4=3;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==ADJECTIVE_PREFIX) ) {
                alt4=1;
            }
            else if ( (LA4_0==NAME) ) {
                switch ( input.LA(2) ) {
                case 27:
                    {
                    alt4=2;
                    }
                    break;
                case TEXTUAL_VALUE:
                    {
                    int LA4_4 = input.LA(3);

                    if ( (LA4_4==NAME) ) {
                        alt4=3;
                    }
                    else if ( (LA4_4==LBRACKET) ) {
                        alt4=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 4, 4, input);

                        throw nvae;
                    }
                    }
                    break;
                case LBRACKET:
                    {
                    int LA4_5 = input.LA(3);

                    if ( (LA4_5==NAME) ) {
                        int LA4_7 = input.LA(4);

                        if ( (LA4_7==NAME||(LA4_7>=RBRACKET && LA4_7<=ADJECTIVE_PREFIX)) ) {
                            alt4=1;
                        }
                        else if ( (LA4_7==TEXTUAL_VALUE) ) {
                            alt4=3;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 4, 7, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA4_5==RBRACKET||LA4_5==ADJECTIVE_PREFIX) ) {
                        alt4=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 4, 5, input);

                        throw nvae;
                    }
                    }
                    break;
                case NAME:
                case ADJECTIVE_PREFIX:
                    {
                    alt4=1;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 2, input);

                    throw nvae;
                }

            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:101:15: cls
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_cls_in_pkg_contents152);
                    cls7=cls();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, cls7.getTree());

                    }
                    break;
                case 2 :
                    // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:101:21: cls_level_attribute
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_cls_level_attribute_in_pkg_contents156);
                    cls_level_attribute8=cls_level_attribute();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, cls_level_attribute8.getTree());

                    }
                    break;
                case 3 :
                    // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:101:43: assoc_instance
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_assoc_instance_in_pkg_contents160);
                    assoc_instance9=assoc_instance();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, assoc_instance9.getTree());

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
    // $ANTLR end pkg_contents

    public static class assoc_instance_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start assoc_instance
    // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:103:1: assoc_instance : ( infix_assoc | assoc_block );
    public final HutnParser.assoc_instance_return assoc_instance() throws RecognitionException {
        HutnParser.assoc_instance_return retval = new HutnParser.assoc_instance_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        HutnParser.infix_assoc_return infix_assoc10 = null;

        HutnParser.assoc_block_return assoc_block11 = null;



        try {
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:103:15: ( infix_assoc | assoc_block )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==NAME) ) {
                int LA5_1 = input.LA(2);

                if ( (LA5_1==TEXTUAL_VALUE) ) {
                    alt5=1;
                }
                else if ( (LA5_1==LBRACKET) ) {
                    alt5=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:103:17: infix_assoc
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_infix_assoc_in_assoc_instance167);
                    infix_assoc10=infix_assoc();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, infix_assoc10.getTree());

                    }
                    break;
                case 2 :
                    // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:103:31: assoc_block
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_assoc_block_in_assoc_instance171);
                    assoc_block11=assoc_block();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, assoc_block11.getTree());

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
    // $ANTLR end assoc_instance

    public static class infix_assoc_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start infix_assoc
    // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:105:1: infix_assoc : simple_ref NAME simple_ref ';' -> ^( ASSOC_INSTANCE[$NAME.text] simple_ref simple_ref ) ;
    public final HutnParser.infix_assoc_return infix_assoc() throws RecognitionException {
        HutnParser.infix_assoc_return retval = new HutnParser.infix_assoc_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NAME13=null;
        Token char_literal15=null;
        HutnParser.simple_ref_return simple_ref12 = null;

        HutnParser.simple_ref_return simple_ref14 = null;


        CommonTree NAME13_tree=null;
        CommonTree char_literal15_tree=null;
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_26=new RewriteRuleTokenStream(adaptor,"token 26");
        RewriteRuleSubtreeStream stream_simple_ref=new RewriteRuleSubtreeStream(adaptor,"rule simple_ref");
        try {
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:106:7: ( simple_ref NAME simple_ref ';' -> ^( ASSOC_INSTANCE[$NAME.text] simple_ref simple_ref ) )
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:106:11: simple_ref NAME simple_ref ';'
            {
            pushFollow(FOLLOW_simple_ref_in_infix_assoc187);
            simple_ref12=simple_ref();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_simple_ref.add(simple_ref12.getTree());
            NAME13=(Token)match(input,NAME,FOLLOW_NAME_in_infix_assoc189); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(NAME13);

            pushFollow(FOLLOW_simple_ref_in_infix_assoc191);
            simple_ref14=simple_ref();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_simple_ref.add(simple_ref14.getTree());
            char_literal15=(Token)match(input,26,FOLLOW_26_in_infix_assoc193); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_26.add(char_literal15);



            // AST REWRITE
            // elements: simple_ref, simple_ref
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 106:42: -> ^( ASSOC_INSTANCE[$NAME.text] simple_ref simple_ref )
            {
                // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:106:45: ^( ASSOC_INSTANCE[$NAME.text] simple_ref simple_ref )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ASSOC_INSTANCE, (NAME13!=null?NAME13.getText():null)), root_1);

                adaptor.addChild(root_1, stream_simple_ref.nextTree());
                adaptor.addChild(root_1, stream_simple_ref.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;retval.tree = root_0;}
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
    // $ANTLR end infix_assoc

    public static class assoc_block_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start assoc_block
    // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:109:1: assoc_block : NAME LBRACKET ( assoc_contents )+ RBRACKET -> ^( ASSOC_INSTANCE[$NAME.text] ( assoc_contents )* ) ;
    public final HutnParser.assoc_block_return assoc_block() throws RecognitionException {
        HutnParser.assoc_block_return retval = new HutnParser.assoc_block_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NAME16=null;
        Token LBRACKET17=null;
        Token RBRACKET19=null;
        HutnParser.assoc_contents_return assoc_contents18 = null;


        CommonTree NAME16_tree=null;
        CommonTree LBRACKET17_tree=null;
        CommonTree RBRACKET19_tree=null;
        RewriteRuleTokenStream stream_LBRACKET=new RewriteRuleTokenStream(adaptor,"token LBRACKET");
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_RBRACKET=new RewriteRuleTokenStream(adaptor,"token RBRACKET");
        RewriteRuleSubtreeStream stream_assoc_contents=new RewriteRuleSubtreeStream(adaptor,"rule assoc_contents");
        try {
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:110:7: ( NAME LBRACKET ( assoc_contents )+ RBRACKET -> ^( ASSOC_INSTANCE[$NAME.text] ( assoc_contents )* ) )
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:110:11: NAME LBRACKET ( assoc_contents )+ RBRACKET
            {
            NAME16=(Token)match(input,NAME,FOLLOW_NAME_in_assoc_block227); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(NAME16);

            LBRACKET17=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_assoc_block229); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LBRACKET.add(LBRACKET17);

            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:110:25: ( assoc_contents )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==NAME) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:0:0: assoc_contents
            	    {
            	    pushFollow(FOLLOW_assoc_contents_in_assoc_block231);
            	    assoc_contents18=assoc_contents();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_assoc_contents.add(assoc_contents18.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);

            RBRACKET19=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_assoc_block234); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RBRACKET.add(RBRACKET19);



            // AST REWRITE
            // elements: assoc_contents
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 110:50: -> ^( ASSOC_INSTANCE[$NAME.text] ( assoc_contents )* )
            {
                // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:110:53: ^( ASSOC_INSTANCE[$NAME.text] ( assoc_contents )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ASSOC_INSTANCE, (NAME16!=null?NAME16.getText():null)), root_1);

                // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:110:82: ( assoc_contents )*
                while ( stream_assoc_contents.hasNext() ) {
                    adaptor.addChild(root_1, stream_assoc_contents.nextTree());

                }
                stream_assoc_contents.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;retval.tree = root_0;}
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
    // $ANTLR end assoc_block

    public static class assoc_contents_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start assoc_contents
    // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:113:1: assoc_contents : simple_ref simple_ref ;
    public final HutnParser.assoc_contents_return assoc_contents() throws RecognitionException {
        HutnParser.assoc_contents_return retval = new HutnParser.assoc_contents_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        HutnParser.simple_ref_return simple_ref20 = null;

        HutnParser.simple_ref_return simple_ref21 = null;



        try {
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:114:7: ( simple_ref simple_ref )
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:114:11: simple_ref simple_ref
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_simple_ref_in_assoc_contents267);
            simple_ref20=simple_ref();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, simple_ref20.getTree());
            pushFollow(FOLLOW_simple_ref_in_assoc_contents269);
            simple_ref21=simple_ref();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, simple_ref21.getTree());

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
    // $ANTLR end assoc_contents

    public static class cls_level_attribute_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start cls_level_attribute
    // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:117:1: cls_level_attribute : NAME '.' NAME ASSIGNMENT attr ';' -> ^( CLS_LVL_ATTRIBUTE ^( NAME ^( NAME attr ) ) ) ;
    public final HutnParser.cls_level_attribute_return cls_level_attribute() throws RecognitionException {
        HutnParser.cls_level_attribute_return retval = new HutnParser.cls_level_attribute_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NAME22=null;
        Token char_literal23=null;
        Token NAME24=null;
        Token ASSIGNMENT25=null;
        Token char_literal27=null;
        HutnParser.attr_return attr26 = null;


        CommonTree NAME22_tree=null;
        CommonTree char_literal23_tree=null;
        CommonTree NAME24_tree=null;
        CommonTree ASSIGNMENT25_tree=null;
        CommonTree char_literal27_tree=null;
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_ASSIGNMENT=new RewriteRuleTokenStream(adaptor,"token ASSIGNMENT");
        RewriteRuleTokenStream stream_26=new RewriteRuleTokenStream(adaptor,"token 26");
        RewriteRuleTokenStream stream_27=new RewriteRuleTokenStream(adaptor,"token 27");
        RewriteRuleSubtreeStream stream_attr=new RewriteRuleSubtreeStream(adaptor,"rule attr");
        try {
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:118:7: ( NAME '.' NAME ASSIGNMENT attr ';' -> ^( CLS_LVL_ATTRIBUTE ^( NAME ^( NAME attr ) ) ) )
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:118:11: NAME '.' NAME ASSIGNMENT attr ';'
            {
            NAME22=(Token)match(input,NAME,FOLLOW_NAME_in_cls_level_attribute292); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(NAME22);

            char_literal23=(Token)match(input,27,FOLLOW_27_in_cls_level_attribute294); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_27.add(char_literal23);

            NAME24=(Token)match(input,NAME,FOLLOW_NAME_in_cls_level_attribute296); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(NAME24);

            ASSIGNMENT25=(Token)match(input,ASSIGNMENT,FOLLOW_ASSIGNMENT_in_cls_level_attribute298); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ASSIGNMENT.add(ASSIGNMENT25);

            pushFollow(FOLLOW_attr_in_cls_level_attribute300);
            attr26=attr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_attr.add(attr26.getTree());
            char_literal27=(Token)match(input,26,FOLLOW_26_in_cls_level_attribute302); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_26.add(char_literal27);



            // AST REWRITE
            // elements: attr, NAME, NAME
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 118:45: -> ^( CLS_LVL_ATTRIBUTE ^( NAME ^( NAME attr ) ) )
            {
                // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:118:48: ^( CLS_LVL_ATTRIBUTE ^( NAME ^( NAME attr ) ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CLS_LVL_ATTRIBUTE, "CLS_LVL_ATTRIBUTE"), root_1);

                // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:118:68: ^( NAME ^( NAME attr ) )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(stream_NAME.nextNode(), root_2);

                // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:118:75: ^( NAME attr )
                {
                CommonTree root_3 = (CommonTree)adaptor.nil();
                root_3 = (CommonTree)adaptor.becomeRoot(stream_NAME.nextNode(), root_3);

                adaptor.addChild(root_3, stream_attr.nextTree());

                adaptor.addChild(root_2, root_3);
                }

                adaptor.addChild(root_1, root_2);
                }

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;retval.tree = root_0;}
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
    // $ANTLR end cls_level_attribute

    public static class cls_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start cls
    // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:121:1: cls : ( adjective )* NAME ( TEXTUAL_VALUE )? LBRACKET ( cls_contents )* RBRACKET ;
    public final HutnParser.cls_return cls() throws RecognitionException {
        HutnParser.cls_return retval = new HutnParser.cls_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NAME29=null;
        Token TEXTUAL_VALUE30=null;
        Token LBRACKET31=null;
        Token RBRACKET33=null;
        HutnParser.adjective_return adjective28 = null;

        HutnParser.cls_contents_return cls_contents32 = null;


        CommonTree NAME29_tree=null;
        CommonTree TEXTUAL_VALUE30_tree=null;
        CommonTree LBRACKET31_tree=null;
        CommonTree RBRACKET33_tree=null;

        try {
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:121:4: ( ( adjective )* NAME ( TEXTUAL_VALUE )? LBRACKET ( cls_contents )* RBRACKET )
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:121:6: ( adjective )* NAME ( TEXTUAL_VALUE )? LBRACKET ( cls_contents )* RBRACKET
            {
            root_0 = (CommonTree)adaptor.nil();

            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:121:6: ( adjective )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==NAME) ) {
                    int LA7_1 = input.LA(2);

                    if ( (LA7_1==NAME||LA7_1==ADJECTIVE_PREFIX) ) {
                        alt7=1;
                    }


                }
                else if ( (LA7_0==ADJECTIVE_PREFIX) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:0:0: adjective
            	    {
            	    pushFollow(FOLLOW_adjective_in_cls332);
            	    adjective28=adjective();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, adjective28.getTree());

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            NAME29=(Token)match(input,NAME,FOLLOW_NAME_in_cls335); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME29_tree = (CommonTree)adaptor.create(NAME29);
            root_0 = (CommonTree)adaptor.becomeRoot(NAME29_tree, root_0);
            }
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:121:23: ( TEXTUAL_VALUE )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==TEXTUAL_VALUE) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:0:0: TEXTUAL_VALUE
                    {
                    TEXTUAL_VALUE30=(Token)match(input,TEXTUAL_VALUE,FOLLOW_TEXTUAL_VALUE_in_cls338); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TEXTUAL_VALUE30_tree = (CommonTree)adaptor.create(TEXTUAL_VALUE30);
                    adaptor.addChild(root_0, TEXTUAL_VALUE30_tree);
                    }

                    }
                    break;

            }

            LBRACKET31=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_cls341); if (state.failed) return retval;
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:121:48: ( cls_contents )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==NAME||LA9_0==ADJECTIVE_PREFIX) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:0:0: cls_contents
            	    {
            	    pushFollow(FOLLOW_cls_contents_in_cls344);
            	    cls_contents32=cls_contents();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, cls_contents32.getTree());

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            RBRACKET33=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_cls347); if (state.failed) return retval;

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
    // $ANTLR end cls

    public static class adjective_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start adjective
    // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:123:1: adjective : ( ADJECTIVE_PREFIX )? NAME -> ^( ADJECTIVE[name] ) ;
    public final HutnParser.adjective_return adjective() throws RecognitionException {
        HutnParser.adjective_return retval = new HutnParser.adjective_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ADJECTIVE_PREFIX34=null;
        Token NAME35=null;

        CommonTree ADJECTIVE_PREFIX34_tree=null;
        CommonTree NAME35_tree=null;
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_ADJECTIVE_PREFIX=new RewriteRuleTokenStream(adaptor,"token ADJECTIVE_PREFIX");


          String name = "";

        try {
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:127:7: ( ( ADJECTIVE_PREFIX )? NAME -> ^( ADJECTIVE[name] ) )
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:127:10: ( ADJECTIVE_PREFIX )? NAME
            {
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:127:10: ( ADJECTIVE_PREFIX )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==ADJECTIVE_PREFIX) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:127:11: ADJECTIVE_PREFIX
                    {
                    ADJECTIVE_PREFIX34=(Token)match(input,ADJECTIVE_PREFIX,FOLLOW_ADJECTIVE_PREFIX_in_adjective370); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ADJECTIVE_PREFIX.add(ADJECTIVE_PREFIX34);

                    if ( state.backtracking==0 ) {
                      name = (ADJECTIVE_PREFIX34!=null?ADJECTIVE_PREFIX34.getText():null);
                    }

                    }
                    break;

            }

            NAME35=(Token)match(input,NAME,FOLLOW_NAME_in_adjective376); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(NAME35);

            if ( state.backtracking==0 ) {
              name += (NAME35!=null?NAME35.getText():null);
            }


            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 127:90: -> ^( ADJECTIVE[name] )
            {
                // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:127:93: ^( ADJECTIVE[name] )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ADJECTIVE, name), root_1);

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;retval.tree = root_0;}
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
    // $ANTLR end adjective

    public static class cls_contents_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start cls_contents
    // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:130:1: cls_contents : ( feature | adjective );
    public final HutnParser.cls_contents_return cls_contents() throws RecognitionException {
        HutnParser.cls_contents_return retval = new HutnParser.cls_contents_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        HutnParser.feature_return feature36 = null;

        HutnParser.adjective_return adjective37 = null;



        try {
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:130:13: ( feature | adjective )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==NAME) ) {
                int LA11_1 = input.LA(2);

                if ( (LA11_1==ASSIGNMENT) ) {
                    alt11=1;
                }
                else if ( (LA11_1==EOF||LA11_1==NAME||LA11_1==RBRACKET||LA11_1==ADJECTIVE_PREFIX) ) {
                    alt11=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA11_0==ADJECTIVE_PREFIX) ) {
                alt11=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:130:15: feature
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_feature_in_cls_contents399);
                    feature36=feature();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, feature36.getTree());

                    }
                    break;
                case 2 :
                    // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:130:25: adjective
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_adjective_in_cls_contents403);
                    adjective37=adjective();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, adjective37.getTree());

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
    // $ANTLR end cls_contents

    public static class feature_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start feature
    // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:132:1: feature : NAME ASSIGNMENT feature_contents ;
    public final HutnParser.feature_return feature() throws RecognitionException {
        HutnParser.feature_return retval = new HutnParser.feature_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NAME38=null;
        Token ASSIGNMENT39=null;
        HutnParser.feature_contents_return feature_contents40 = null;


        CommonTree NAME38_tree=null;
        CommonTree ASSIGNMENT39_tree=null;

        try {
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:132:8: ( NAME ASSIGNMENT feature_contents )
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:132:10: NAME ASSIGNMENT feature_contents
            {
            root_0 = (CommonTree)adaptor.nil();

            NAME38=(Token)match(input,NAME,FOLLOW_NAME_in_feature410); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME38_tree = (CommonTree)adaptor.create(NAME38);
            root_0 = (CommonTree)adaptor.becomeRoot(NAME38_tree, root_0);
            }
            ASSIGNMENT39=(Token)match(input,ASSIGNMENT,FOLLOW_ASSIGNMENT_in_feature413); if (state.failed) return retval;
            pushFollow(FOLLOW_feature_contents_in_feature416);
            feature_contents40=feature_contents();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, feature_contents40.getTree());

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
    // $ANTLR end feature

    public static class feature_contents_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start feature_contents
    // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:134:1: feature_contents : ( attr | refs );
    public final HutnParser.feature_contents_return feature_contents() throws RecognitionException {
        HutnParser.feature_contents_return retval = new HutnParser.feature_contents_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        HutnParser.attr_return attr41 = null;

        HutnParser.refs_return refs42 = null;



        try {
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:134:17: ( attr | refs )
            int alt12=2;
            alt12 = dfa12.predict(input);
            switch (alt12) {
                case 1 :
                    // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:134:19: attr
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_attr_in_feature_contents423);
                    attr41=attr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, attr41.getTree());

                    }
                    break;
                case 2 :
                    // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:134:26: refs
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_refs_in_feature_contents427);
                    refs42=refs();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, refs42.getTree());

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
    // $ANTLR end feature_contents

    public static class attr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start attr
    // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:136:1: attr : ( attr_value ( COMMA attr_value )* | NULL );
    public final HutnParser.attr_return attr() throws RecognitionException {
        HutnParser.attr_return retval = new HutnParser.attr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token COMMA44=null;
        Token NULL46=null;
        HutnParser.attr_value_return attr_value43 = null;

        HutnParser.attr_value_return attr_value45 = null;


        CommonTree COMMA44_tree=null;
        CommonTree NULL46_tree=null;

        try {
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:136:5: ( attr_value ( COMMA attr_value )* | NULL )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( ((LA14_0>=TRUE && LA14_0<=FALSE)||(LA14_0>=NAME && LA14_0<=TEXTUAL_VALUE)||LA14_0==NUMERIC_VALUE) ) {
                alt14=1;
            }
            else if ( (LA14_0==NULL) ) {
                alt14=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:136:7: attr_value ( COMMA attr_value )*
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_attr_value_in_attr434);
                    attr_value43=attr_value();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, attr_value43.getTree());
                    // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:136:18: ( COMMA attr_value )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==COMMA) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:136:19: COMMA attr_value
                    	    {
                    	    COMMA44=(Token)match(input,COMMA,FOLLOW_COMMA_in_attr437); if (state.failed) return retval;
                    	    pushFollow(FOLLOW_attr_value_in_attr440);
                    	    attr_value45=attr_value();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, attr_value45.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:136:41: NULL
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    NULL46=(Token)match(input,NULL,FOLLOW_NULL_in_attr446); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL46_tree = (CommonTree)adaptor.create(NULL46);
                    adaptor.addChild(root_0, NULL46_tree);
                    }

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
    // $ANTLR end attr

    public static class attr_value_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start attr_value
    // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:138:1: attr_value : ( TEXTUAL_VALUE | NUMERIC_VALUE | bool | enum_value );
    public final HutnParser.attr_value_return attr_value() throws RecognitionException {
        HutnParser.attr_value_return retval = new HutnParser.attr_value_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token TEXTUAL_VALUE47=null;
        Token NUMERIC_VALUE48=null;
        HutnParser.bool_return bool49 = null;

        HutnParser.enum_value_return enum_value50 = null;


        CommonTree TEXTUAL_VALUE47_tree=null;
        CommonTree NUMERIC_VALUE48_tree=null;

        try {
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:138:11: ( TEXTUAL_VALUE | NUMERIC_VALUE | bool | enum_value )
            int alt15=4;
            switch ( input.LA(1) ) {
            case TEXTUAL_VALUE:
                {
                alt15=1;
                }
                break;
            case NUMERIC_VALUE:
                {
                alt15=2;
                }
                break;
            case TRUE:
            case FALSE:
                {
                alt15=3;
                }
                break;
            case NAME:
                {
                alt15=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:138:13: TEXTUAL_VALUE
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    TEXTUAL_VALUE47=(Token)match(input,TEXTUAL_VALUE,FOLLOW_TEXTUAL_VALUE_in_attr_value453); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TEXTUAL_VALUE47_tree = (CommonTree)adaptor.create(TEXTUAL_VALUE47);
                    adaptor.addChild(root_0, TEXTUAL_VALUE47_tree);
                    }

                    }
                    break;
                case 2 :
                    // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:138:29: NUMERIC_VALUE
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    NUMERIC_VALUE48=(Token)match(input,NUMERIC_VALUE,FOLLOW_NUMERIC_VALUE_in_attr_value457); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NUMERIC_VALUE48_tree = (CommonTree)adaptor.create(NUMERIC_VALUE48);
                    adaptor.addChild(root_0, NUMERIC_VALUE48_tree);
                    }

                    }
                    break;
                case 3 :
                    // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:138:45: bool
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_bool_in_attr_value461);
                    bool49=bool();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, bool49.getTree());

                    }
                    break;
                case 4 :
                    // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:138:52: enum_value
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_enum_value_in_attr_value465);
                    enum_value50=enum_value();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, enum_value50.getTree());

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
    // $ANTLR end attr_value

    public static class bool_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start bool
    // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:140:1: bool : ( TRUE | FALSE );
    public final HutnParser.bool_return bool() throws RecognitionException {
        HutnParser.bool_return retval = new HutnParser.bool_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set51=null;

        CommonTree set51_tree=null;

        try {
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:140:5: ( TRUE | FALSE )
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set51=(Token)input.LT(1);
            if ( (input.LA(1)>=TRUE && input.LA(1)<=FALSE) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set51));
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
    // $ANTLR end bool

    public static class refs_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start refs
    // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:142:1: refs : ref ( COMMA ref )* ;
    public final HutnParser.refs_return refs() throws RecognitionException {
        HutnParser.refs_return retval = new HutnParser.refs_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token COMMA53=null;
        HutnParser.ref_return ref52 = null;

        HutnParser.ref_return ref54 = null;


        CommonTree COMMA53_tree=null;

        try {
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:142:5: ( ref ( COMMA ref )* )
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:142:7: ref ( COMMA ref )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_ref_in_refs483);
            ref52=ref();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, ref52.getTree());
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:142:11: ( COMMA ref )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==COMMA) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:142:12: COMMA ref
            	    {
            	    COMMA53=(Token)match(input,COMMA,FOLLOW_COMMA_in_refs486); if (state.failed) return retval;
            	    pushFollow(FOLLOW_ref_in_refs489);
            	    ref54=ref();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, ref54.getTree());

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);


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
    // $ANTLR end refs

    public static class ref_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ref
    // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:144:1: ref : ( simple_ref | containment );
    public final HutnParser.ref_return ref() throws RecognitionException {
        HutnParser.ref_return retval = new HutnParser.ref_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        HutnParser.simple_ref_return simple_ref55 = null;

        HutnParser.containment_return containment56 = null;



        try {
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:144:4: ( simple_ref | containment )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==NAME) ) {
                int LA17_1 = input.LA(2);

                if ( (LA17_1==TEXTUAL_VALUE) ) {
                    int LA17_3 = input.LA(3);

                    if ( (LA17_3==LBRACKET) ) {
                        alt17=2;
                    }
                    else if ( (LA17_3==EOF||LA17_3==NAME||LA17_3==RBRACKET||(LA17_3>=ADJECTIVE_PREFIX && LA17_3<=COMMA)) ) {
                        alt17=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 17, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA17_1==NAME||LA17_1==ADJECTIVE_PREFIX) ) {
                    alt17=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 17, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA17_0==ADJECTIVE_PREFIX) ) {
                alt17=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:144:6: simple_ref
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_simple_ref_in_ref498);
                    simple_ref55=simple_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, simple_ref55.getTree());

                    }
                    break;
                case 2 :
                    // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:144:19: containment
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_containment_in_ref502);
                    containment56=containment();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, containment56.getTree());

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
    // $ANTLR end ref

    public static class simple_ref_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start simple_ref
    // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:146:1: simple_ref : NAME TEXTUAL_VALUE -> ^( REFERENCE[$NAME.text] TEXTUAL_VALUE ) ;
    public final HutnParser.simple_ref_return simple_ref() throws RecognitionException {
        HutnParser.simple_ref_return retval = new HutnParser.simple_ref_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NAME57=null;
        Token TEXTUAL_VALUE58=null;

        CommonTree NAME57_tree=null;
        CommonTree TEXTUAL_VALUE58_tree=null;
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_TEXTUAL_VALUE=new RewriteRuleTokenStream(adaptor,"token TEXTUAL_VALUE");

        try {
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:147:7: ( NAME TEXTUAL_VALUE -> ^( REFERENCE[$NAME.text] TEXTUAL_VALUE ) )
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:147:11: NAME TEXTUAL_VALUE
            {
            NAME57=(Token)match(input,NAME,FOLLOW_NAME_in_simple_ref518); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(NAME57);

            TEXTUAL_VALUE58=(Token)match(input,TEXTUAL_VALUE,FOLLOW_TEXTUAL_VALUE_in_simple_ref520); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TEXTUAL_VALUE.add(TEXTUAL_VALUE58);



            // AST REWRITE
            // elements: TEXTUAL_VALUE
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 147:30: -> ^( REFERENCE[$NAME.text] TEXTUAL_VALUE )
            {
                // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:147:33: ^( REFERENCE[$NAME.text] TEXTUAL_VALUE )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(REFERENCE, (NAME57!=null?NAME57.getText():null)), root_1);

                adaptor.addChild(root_1, stream_TEXTUAL_VALUE.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;retval.tree = root_0;}
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
    // $ANTLR end simple_ref

    public static class containment_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start containment
    // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:150:1: containment : ( adjective )* NAME TEXTUAL_VALUE LBRACKET ( cls_contents )* RBRACKET ;
    public final HutnParser.containment_return containment() throws RecognitionException {
        HutnParser.containment_return retval = new HutnParser.containment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NAME60=null;
        Token TEXTUAL_VALUE61=null;
        Token LBRACKET62=null;
        Token RBRACKET64=null;
        HutnParser.adjective_return adjective59 = null;

        HutnParser.cls_contents_return cls_contents63 = null;


        CommonTree NAME60_tree=null;
        CommonTree TEXTUAL_VALUE61_tree=null;
        CommonTree LBRACKET62_tree=null;
        CommonTree RBRACKET64_tree=null;

        try {
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:150:12: ( ( adjective )* NAME TEXTUAL_VALUE LBRACKET ( cls_contents )* RBRACKET )
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:150:14: ( adjective )* NAME TEXTUAL_VALUE LBRACKET ( cls_contents )* RBRACKET
            {
            root_0 = (CommonTree)adaptor.nil();

            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:150:14: ( adjective )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==NAME) ) {
                    int LA18_1 = input.LA(2);

                    if ( (LA18_1==NAME||LA18_1==ADJECTIVE_PREFIX) ) {
                        alt18=1;
                    }


                }
                else if ( (LA18_0==ADJECTIVE_PREFIX) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:0:0: adjective
            	    {
            	    pushFollow(FOLLOW_adjective_in_containment543);
            	    adjective59=adjective();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, adjective59.getTree());

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            NAME60=(Token)match(input,NAME,FOLLOW_NAME_in_containment546); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME60_tree = (CommonTree)adaptor.create(NAME60);
            root_0 = (CommonTree)adaptor.becomeRoot(NAME60_tree, root_0);
            }
            TEXTUAL_VALUE61=(Token)match(input,TEXTUAL_VALUE,FOLLOW_TEXTUAL_VALUE_in_containment549); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            TEXTUAL_VALUE61_tree = (CommonTree)adaptor.create(TEXTUAL_VALUE61);
            adaptor.addChild(root_0, TEXTUAL_VALUE61_tree);
            }
            LBRACKET62=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_containment551); if (state.failed) return retval;
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:150:55: ( cls_contents )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==NAME||LA19_0==ADJECTIVE_PREFIX) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:0:0: cls_contents
            	    {
            	    pushFollow(FOLLOW_cls_contents_in_containment554);
            	    cls_contents63=cls_contents();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, cls_contents63.getTree());

            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            RBRACKET64=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_containment557); if (state.failed) return retval;

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
    // $ANTLR end containment

    public static class enum_value_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start enum_value
    // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:152:1: enum_value : NAME ;
    public final HutnParser.enum_value_return enum_value() throws RecognitionException {
        HutnParser.enum_value_return retval = new HutnParser.enum_value_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NAME65=null;

        CommonTree NAME65_tree=null;

        try {
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:152:11: ( NAME )
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:152:13: NAME
            {
            root_0 = (CommonTree)adaptor.nil();

            NAME65=(Token)match(input,NAME,FOLLOW_NAME_in_enum_value565); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME65_tree = (CommonTree)adaptor.create(NAME65);
            root_0 = (CommonTree)adaptor.becomeRoot(NAME65_tree, root_0);
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
    // $ANTLR end enum_value

    // Delegated rules


    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA12_eotS =
        "\7\uffff";
    static final String DFA12_eofS =
        "\2\uffff\1\1\4\uffff";
    static final String DFA12_minS =
        "\1\4\1\uffff\1\13\1\uffff\3\13";
    static final String DFA12_maxS =
        "\1\22\1\uffff\1\21\1\uffff\1\20\1\13\1\20";
    static final String DFA12_acceptS =
        "\1\uffff\1\1\1\uffff\1\2\3\uffff";
    static final String DFA12_specialS =
        "\7\uffff}>";
    static final String[] DFA12_transitionS = {
            "\3\1\4\uffff\1\2\1\1\3\uffff\1\3\1\uffff\1\1",
            "",
            "\1\4\1\3\1\uffff\1\1\1\uffff\1\5\1\1",
            "",
            "\1\4\1\3\1\uffff\2\1\1\5",
            "\1\6",
            "\1\4\2\uffff\1\1\1\uffff\1\5"
    };

    static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
    static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
    static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
    static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
    static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
    static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
    static final short[][] DFA12_transition;

    static {
        int numStates = DFA12_transitionS.length;
        DFA12_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
        }
    }

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = DFA12_eot;
            this.eof = DFA12_eof;
            this.min = DFA12_min;
            this.max = DFA12_max;
            this.accept = DFA12_accept;
            this.special = DFA12_special;
            this.transition = DFA12_transition;
        }
        public String getDescription() {
            return "134:1: feature_contents : ( attr | refs );";
        }
    }
 

    public static final BitSet FOLLOW_pkg_in_document124 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_NAME_in_pkg132 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_TEXTUAL_VALUE_in_pkg135 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_LBRACKET_in_pkg138 = new BitSet(new long[]{0x0000000000014800L});
    public static final BitSet FOLLOW_pkg_contents_in_pkg141 = new BitSet(new long[]{0x0000000000014800L});
    public static final BitSet FOLLOW_RBRACKET_in_pkg144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cls_in_pkg_contents152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cls_level_attribute_in_pkg_contents156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assoc_instance_in_pkg_contents160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_infix_assoc_in_assoc_instance167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assoc_block_in_assoc_instance171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simple_ref_in_infix_assoc187 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NAME_in_infix_assoc189 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_simple_ref_in_infix_assoc191 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_infix_assoc193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_assoc_block227 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_LBRACKET_in_assoc_block229 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_assoc_contents_in_assoc_block231 = new BitSet(new long[]{0x0000000000004800L});
    public static final BitSet FOLLOW_RBRACKET_in_assoc_block234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simple_ref_in_assoc_contents267 = new BitSet(new long[]{0x0000000000004800L});
    public static final BitSet FOLLOW_simple_ref_in_assoc_contents269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_cls_level_attribute292 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_cls_level_attribute294 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NAME_in_cls_level_attribute296 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_ASSIGNMENT_in_cls_level_attribute298 = new BitSet(new long[]{0x0000000000041870L});
    public static final BitSet FOLLOW_attr_in_cls_level_attribute300 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_cls_level_attribute302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_adjective_in_cls332 = new BitSet(new long[]{0x0000000000010800L});
    public static final BitSet FOLLOW_NAME_in_cls335 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_TEXTUAL_VALUE_in_cls338 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_LBRACKET_in_cls341 = new BitSet(new long[]{0x0000000000014800L});
    public static final BitSet FOLLOW_cls_contents_in_cls344 = new BitSet(new long[]{0x0000000000014800L});
    public static final BitSet FOLLOW_RBRACKET_in_cls347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ADJECTIVE_PREFIX_in_adjective370 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NAME_in_adjective376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_feature_in_cls_contents399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_adjective_in_cls_contents403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_feature410 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_ASSIGNMENT_in_feature413 = new BitSet(new long[]{0x0000000000055870L});
    public static final BitSet FOLLOW_feature_contents_in_feature416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attr_in_feature_contents423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_refs_in_feature_contents427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attr_value_in_attr434 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_COMMA_in_attr437 = new BitSet(new long[]{0x0000000000041830L});
    public static final BitSet FOLLOW_attr_value_in_attr440 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_NULL_in_attr446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXTUAL_VALUE_in_attr_value453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMERIC_VALUE_in_attr_value457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bool_in_attr_value461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enum_value_in_attr_value465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_bool0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ref_in_refs483 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_COMMA_in_refs486 = new BitSet(new long[]{0x0000000000055870L});
    public static final BitSet FOLLOW_ref_in_refs489 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_simple_ref_in_ref498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_containment_in_ref502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_simple_ref518 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_TEXTUAL_VALUE_in_simple_ref520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_adjective_in_containment543 = new BitSet(new long[]{0x0000000000014800L});
    public static final BitSet FOLLOW_NAME_in_containment546 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_TEXTUAL_VALUE_in_containment549 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_LBRACKET_in_containment551 = new BitSet(new long[]{0x0000000000014800L});
    public static final BitSet FOLLOW_cls_contents_in_containment554 = new BitSet(new long[]{0x0000000000014800L});
    public static final BitSet FOLLOW_RBRACKET_in_containment557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_enum_value565 = new BitSet(new long[]{0x0000000000000002L});

}