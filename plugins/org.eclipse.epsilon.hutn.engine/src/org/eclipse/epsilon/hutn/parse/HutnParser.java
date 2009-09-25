// $ANTLR 3.1b1 /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g 2009-09-25 16:05:04

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "TRUE", "FALSE", "NULL", "ADJECTIVE", "CLS_LVL_ATTRIBUTE", "ASSOC_INSTANCE", "REFERENCE", "NAME", "TEXTUAL_VALUE", "LBRACKET", "RBRACKET", "ASSIGNMENT", "ADJECTIVE_PREFIX", "COMMA", "NUMERIC_VALUE", "ID_START_LETTER", "ID_LETTER", "ESC", "TEXT_LETTER", "DIGIT", "WS", "ML_COMMENT", "SL_COMMENT", "';'", "'.'"
    };
    public static final int ID_START_LETTER=19;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int ID_LETTER=20;
    public static final int CLS_LVL_ATTRIBUTE=8;
    public static final int ESC=21;
    public static final int NULL=6;
    public static final int REFERENCE=10;
    public static final int ADJECTIVE_PREFIX=16;
    public static final int EOF=-1;
    public static final int TRUE=4;
    public static final int LBRACKET=13;
    public static final int ML_COMMENT=25;
    public static final int NAME=11;
    public static final int WS=24;
    public static final int NUMERIC_VALUE=18;
    public static final int TEXTUAL_VALUE=12;
    public static final int COMMA=17;
    public static final int SL_COMMENT=26;
    public static final int ASSIGNMENT=15;
    public static final int DIGIT=23;
    public static final int RBRACKET=14;
    public static final int ADJECTIVE=7;
    public static final int FALSE=5;
    public static final int ASSOC_INSTANCE=9;
    public static final int TEXT_LETTER=22;

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
    public String getGrammarFileName() { return "/Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g"; }


    public static class document_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start document
    // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:97:1: document : ( pkg )* EOF -> ( pkg )* ;
    public final HutnParser.document_return document() throws RecognitionException {
        HutnParser.document_return retval = new HutnParser.document_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token EOF2=null;
        HutnParser.pkg_return pkg1 = null;


        CommonTree EOF2_tree=null;
        RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
        RewriteRuleSubtreeStream stream_pkg=new RewriteRuleSubtreeStream(adaptor,"rule pkg");
        try {
            // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:97:9: ( ( pkg )* EOF -> ( pkg )* )
            // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:97:11: ( pkg )* EOF
            {
            // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:97:11: ( pkg )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==NAME) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:0:0: pkg
            	    {
            	    pushFollow(FOLLOW_pkg_in_document124);
            	    pkg1=pkg();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_pkg.add(pkg1.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            EOF2=(Token)match(input,EOF,FOLLOW_EOF_in_document127); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EOF.add(EOF2);



            // AST REWRITE
            // elements: pkg
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 97:20: -> ( pkg )*
            {
                // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:97:23: ( pkg )*
                while ( stream_pkg.hasNext() ) {
                    adaptor.addChild(root_0, stream_pkg.nextTree());

                }
                stream_pkg.reset();

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
    // $ANTLR end document

    public static class pkg_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start pkg
    // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:99:1: pkg : NAME ( TEXTUAL_VALUE )? LBRACKET ( pkg_contents )* RBRACKET ;
    public final HutnParser.pkg_return pkg() throws RecognitionException {
        HutnParser.pkg_return retval = new HutnParser.pkg_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NAME3=null;
        Token TEXTUAL_VALUE4=null;
        Token LBRACKET5=null;
        Token RBRACKET7=null;
        HutnParser.pkg_contents_return pkg_contents6 = null;


        CommonTree NAME3_tree=null;
        CommonTree TEXTUAL_VALUE4_tree=null;
        CommonTree LBRACKET5_tree=null;
        CommonTree RBRACKET7_tree=null;

        try {
            // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:99:4: ( NAME ( TEXTUAL_VALUE )? LBRACKET ( pkg_contents )* RBRACKET )
            // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:99:6: NAME ( TEXTUAL_VALUE )? LBRACKET ( pkg_contents )* RBRACKET
            {
            root_0 = (CommonTree)adaptor.nil();

            NAME3=(Token)match(input,NAME,FOLLOW_NAME_in_pkg139); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME3_tree = (CommonTree)adaptor.create(NAME3);
            root_0 = (CommonTree)adaptor.becomeRoot(NAME3_tree, root_0);
            }
            // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:99:12: ( TEXTUAL_VALUE )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==TEXTUAL_VALUE) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:0:0: TEXTUAL_VALUE
                    {
                    TEXTUAL_VALUE4=(Token)match(input,TEXTUAL_VALUE,FOLLOW_TEXTUAL_VALUE_in_pkg142); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TEXTUAL_VALUE4_tree = (CommonTree)adaptor.create(TEXTUAL_VALUE4);
                    adaptor.addChild(root_0, TEXTUAL_VALUE4_tree);
                    }

                    }
                    break;

            }

            LBRACKET5=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_pkg145); if (state.failed) return retval;
            // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:99:37: ( pkg_contents )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==NAME||LA3_0==ADJECTIVE_PREFIX) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:0:0: pkg_contents
            	    {
            	    pushFollow(FOLLOW_pkg_contents_in_pkg148);
            	    pkg_contents6=pkg_contents();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, pkg_contents6.getTree());

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            RBRACKET7=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_pkg151); if (state.failed) return retval;

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
    // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:101:1: pkg_contents : ( cls | cls_level_attribute | assoc_instance );
    public final HutnParser.pkg_contents_return pkg_contents() throws RecognitionException {
        HutnParser.pkg_contents_return retval = new HutnParser.pkg_contents_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        HutnParser.cls_return cls8 = null;

        HutnParser.cls_level_attribute_return cls_level_attribute9 = null;

        HutnParser.assoc_instance_return assoc_instance10 = null;



        try {
            // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:101:13: ( cls | cls_level_attribute | assoc_instance )
            int alt4=3;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==ADJECTIVE_PREFIX) ) {
                alt4=1;
            }
            else if ( (LA4_0==NAME) ) {
                switch ( input.LA(2) ) {
                case 28:
                    {
                    alt4=2;
                    }
                    break;
                case TEXTUAL_VALUE:
                    {
                    int LA4_4 = input.LA(3);

                    if ( (LA4_4==LBRACKET) ) {
                        alt4=1;
                    }
                    else if ( (LA4_4==NAME) ) {
                        alt4=3;
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

                        if ( (LA4_7==TEXTUAL_VALUE) ) {
                            alt4=3;
                        }
                        else if ( (LA4_7==NAME||(LA4_7>=RBRACKET && LA4_7<=ADJECTIVE_PREFIX)) ) {
                            alt4=1;
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
                    // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:101:15: cls
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_cls_in_pkg_contents159);
                    cls8=cls();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, cls8.getTree());

                    }
                    break;
                case 2 :
                    // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:101:21: cls_level_attribute
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_cls_level_attribute_in_pkg_contents163);
                    cls_level_attribute9=cls_level_attribute();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, cls_level_attribute9.getTree());

                    }
                    break;
                case 3 :
                    // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:101:43: assoc_instance
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_assoc_instance_in_pkg_contents167);
                    assoc_instance10=assoc_instance();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, assoc_instance10.getTree());

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
    // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:103:1: assoc_instance : ( infix_assoc | assoc_block );
    public final HutnParser.assoc_instance_return assoc_instance() throws RecognitionException {
        HutnParser.assoc_instance_return retval = new HutnParser.assoc_instance_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        HutnParser.infix_assoc_return infix_assoc11 = null;

        HutnParser.assoc_block_return assoc_block12 = null;



        try {
            // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:103:15: ( infix_assoc | assoc_block )
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
                    // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:103:17: infix_assoc
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_infix_assoc_in_assoc_instance174);
                    infix_assoc11=infix_assoc();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, infix_assoc11.getTree());

                    }
                    break;
                case 2 :
                    // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:103:31: assoc_block
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_assoc_block_in_assoc_instance178);
                    assoc_block12=assoc_block();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, assoc_block12.getTree());

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
    // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:105:1: infix_assoc : simple_ref NAME simple_ref ';' -> ^( ASSOC_INSTANCE[$NAME.text] simple_ref simple_ref ) ;
    public final HutnParser.infix_assoc_return infix_assoc() throws RecognitionException {
        HutnParser.infix_assoc_return retval = new HutnParser.infix_assoc_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NAME14=null;
        Token char_literal16=null;
        HutnParser.simple_ref_return simple_ref13 = null;

        HutnParser.simple_ref_return simple_ref15 = null;


        CommonTree NAME14_tree=null;
        CommonTree char_literal16_tree=null;
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_27=new RewriteRuleTokenStream(adaptor,"token 27");
        RewriteRuleSubtreeStream stream_simple_ref=new RewriteRuleSubtreeStream(adaptor,"rule simple_ref");
        try {
            // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:106:7: ( simple_ref NAME simple_ref ';' -> ^( ASSOC_INSTANCE[$NAME.text] simple_ref simple_ref ) )
            // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:106:11: simple_ref NAME simple_ref ';'
            {
            pushFollow(FOLLOW_simple_ref_in_infix_assoc194);
            simple_ref13=simple_ref();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_simple_ref.add(simple_ref13.getTree());
            NAME14=(Token)match(input,NAME,FOLLOW_NAME_in_infix_assoc196); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(NAME14);

            pushFollow(FOLLOW_simple_ref_in_infix_assoc198);
            simple_ref15=simple_ref();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_simple_ref.add(simple_ref15.getTree());
            char_literal16=(Token)match(input,27,FOLLOW_27_in_infix_assoc200); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_27.add(char_literal16);



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
                // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:106:45: ^( ASSOC_INSTANCE[$NAME.text] simple_ref simple_ref )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ASSOC_INSTANCE, (NAME14!=null?NAME14.getText():null)), root_1);

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
    // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:109:1: assoc_block : NAME LBRACKET ( assoc_contents )+ RBRACKET -> ^( ASSOC_INSTANCE[$NAME.text] ( assoc_contents )* ) ;
    public final HutnParser.assoc_block_return assoc_block() throws RecognitionException {
        HutnParser.assoc_block_return retval = new HutnParser.assoc_block_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NAME17=null;
        Token LBRACKET18=null;
        Token RBRACKET20=null;
        HutnParser.assoc_contents_return assoc_contents19 = null;


        CommonTree NAME17_tree=null;
        CommonTree LBRACKET18_tree=null;
        CommonTree RBRACKET20_tree=null;
        RewriteRuleTokenStream stream_LBRACKET=new RewriteRuleTokenStream(adaptor,"token LBRACKET");
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_RBRACKET=new RewriteRuleTokenStream(adaptor,"token RBRACKET");
        RewriteRuleSubtreeStream stream_assoc_contents=new RewriteRuleSubtreeStream(adaptor,"rule assoc_contents");
        try {
            // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:110:7: ( NAME LBRACKET ( assoc_contents )+ RBRACKET -> ^( ASSOC_INSTANCE[$NAME.text] ( assoc_contents )* ) )
            // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:110:11: NAME LBRACKET ( assoc_contents )+ RBRACKET
            {
            NAME17=(Token)match(input,NAME,FOLLOW_NAME_in_assoc_block234); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(NAME17);

            LBRACKET18=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_assoc_block236); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LBRACKET.add(LBRACKET18);

            // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:110:25: ( assoc_contents )+
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
            	    // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:0:0: assoc_contents
            	    {
            	    pushFollow(FOLLOW_assoc_contents_in_assoc_block238);
            	    assoc_contents19=assoc_contents();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_assoc_contents.add(assoc_contents19.getTree());

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

            RBRACKET20=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_assoc_block241); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RBRACKET.add(RBRACKET20);



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
                // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:110:53: ^( ASSOC_INSTANCE[$NAME.text] ( assoc_contents )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ASSOC_INSTANCE, (NAME17!=null?NAME17.getText():null)), root_1);

                // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:110:82: ( assoc_contents )*
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
    // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:113:1: assoc_contents : simple_ref simple_ref ;
    public final HutnParser.assoc_contents_return assoc_contents() throws RecognitionException {
        HutnParser.assoc_contents_return retval = new HutnParser.assoc_contents_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        HutnParser.simple_ref_return simple_ref21 = null;

        HutnParser.simple_ref_return simple_ref22 = null;



        try {
            // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:114:7: ( simple_ref simple_ref )
            // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:114:11: simple_ref simple_ref
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_simple_ref_in_assoc_contents274);
            simple_ref21=simple_ref();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, simple_ref21.getTree());
            pushFollow(FOLLOW_simple_ref_in_assoc_contents276);
            simple_ref22=simple_ref();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, simple_ref22.getTree());

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
    // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:117:1: cls_level_attribute : NAME '.' NAME ASSIGNMENT attr ';' -> ^( CLS_LVL_ATTRIBUTE ^( NAME ^( NAME attr ) ) ) ;
    public final HutnParser.cls_level_attribute_return cls_level_attribute() throws RecognitionException {
        HutnParser.cls_level_attribute_return retval = new HutnParser.cls_level_attribute_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NAME23=null;
        Token char_literal24=null;
        Token NAME25=null;
        Token ASSIGNMENT26=null;
        Token char_literal28=null;
        HutnParser.attr_return attr27 = null;


        CommonTree NAME23_tree=null;
        CommonTree char_literal24_tree=null;
        CommonTree NAME25_tree=null;
        CommonTree ASSIGNMENT26_tree=null;
        CommonTree char_literal28_tree=null;
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_ASSIGNMENT=new RewriteRuleTokenStream(adaptor,"token ASSIGNMENT");
        RewriteRuleTokenStream stream_27=new RewriteRuleTokenStream(adaptor,"token 27");
        RewriteRuleTokenStream stream_28=new RewriteRuleTokenStream(adaptor,"token 28");
        RewriteRuleSubtreeStream stream_attr=new RewriteRuleSubtreeStream(adaptor,"rule attr");
        try {
            // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:118:7: ( NAME '.' NAME ASSIGNMENT attr ';' -> ^( CLS_LVL_ATTRIBUTE ^( NAME ^( NAME attr ) ) ) )
            // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:118:11: NAME '.' NAME ASSIGNMENT attr ';'
            {
            NAME23=(Token)match(input,NAME,FOLLOW_NAME_in_cls_level_attribute299); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(NAME23);

            char_literal24=(Token)match(input,28,FOLLOW_28_in_cls_level_attribute301); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_28.add(char_literal24);

            NAME25=(Token)match(input,NAME,FOLLOW_NAME_in_cls_level_attribute303); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(NAME25);

            ASSIGNMENT26=(Token)match(input,ASSIGNMENT,FOLLOW_ASSIGNMENT_in_cls_level_attribute305); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ASSIGNMENT.add(ASSIGNMENT26);

            pushFollow(FOLLOW_attr_in_cls_level_attribute307);
            attr27=attr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_attr.add(attr27.getTree());
            char_literal28=(Token)match(input,27,FOLLOW_27_in_cls_level_attribute309); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_27.add(char_literal28);



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
                // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:118:48: ^( CLS_LVL_ATTRIBUTE ^( NAME ^( NAME attr ) ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CLS_LVL_ATTRIBUTE, "CLS_LVL_ATTRIBUTE"), root_1);

                // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:118:68: ^( NAME ^( NAME attr ) )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(stream_NAME.nextNode(), root_2);

                // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:118:75: ^( NAME attr )
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
    // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:121:1: cls : ( adjective )* NAME ( TEXTUAL_VALUE )? LBRACKET ( cls_contents )* RBRACKET ;
    public final HutnParser.cls_return cls() throws RecognitionException {
        HutnParser.cls_return retval = new HutnParser.cls_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NAME30=null;
        Token TEXTUAL_VALUE31=null;
        Token LBRACKET32=null;
        Token RBRACKET34=null;
        HutnParser.adjective_return adjective29 = null;

        HutnParser.cls_contents_return cls_contents33 = null;


        CommonTree NAME30_tree=null;
        CommonTree TEXTUAL_VALUE31_tree=null;
        CommonTree LBRACKET32_tree=null;
        CommonTree RBRACKET34_tree=null;

        try {
            // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:121:4: ( ( adjective )* NAME ( TEXTUAL_VALUE )? LBRACKET ( cls_contents )* RBRACKET )
            // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:121:6: ( adjective )* NAME ( TEXTUAL_VALUE )? LBRACKET ( cls_contents )* RBRACKET
            {
            root_0 = (CommonTree)adaptor.nil();

            // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:121:6: ( adjective )*
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
            	    // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:0:0: adjective
            	    {
            	    pushFollow(FOLLOW_adjective_in_cls339);
            	    adjective29=adjective();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, adjective29.getTree());

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            NAME30=(Token)match(input,NAME,FOLLOW_NAME_in_cls342); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME30_tree = (CommonTree)adaptor.create(NAME30);
            root_0 = (CommonTree)adaptor.becomeRoot(NAME30_tree, root_0);
            }
            // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:121:23: ( TEXTUAL_VALUE )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==TEXTUAL_VALUE) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:0:0: TEXTUAL_VALUE
                    {
                    TEXTUAL_VALUE31=(Token)match(input,TEXTUAL_VALUE,FOLLOW_TEXTUAL_VALUE_in_cls345); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TEXTUAL_VALUE31_tree = (CommonTree)adaptor.create(TEXTUAL_VALUE31);
                    adaptor.addChild(root_0, TEXTUAL_VALUE31_tree);
                    }

                    }
                    break;

            }

            LBRACKET32=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_cls348); if (state.failed) return retval;
            // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:121:48: ( cls_contents )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==NAME||LA9_0==ADJECTIVE_PREFIX) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:0:0: cls_contents
            	    {
            	    pushFollow(FOLLOW_cls_contents_in_cls351);
            	    cls_contents33=cls_contents();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, cls_contents33.getTree());

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            RBRACKET34=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_cls354); if (state.failed) return retval;

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
    // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:123:1: adjective : ( ADJECTIVE_PREFIX )? NAME -> ^( ADJECTIVE[name] ) ;
    public final HutnParser.adjective_return adjective() throws RecognitionException {
        HutnParser.adjective_return retval = new HutnParser.adjective_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ADJECTIVE_PREFIX35=null;
        Token NAME36=null;

        CommonTree ADJECTIVE_PREFIX35_tree=null;
        CommonTree NAME36_tree=null;
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_ADJECTIVE_PREFIX=new RewriteRuleTokenStream(adaptor,"token ADJECTIVE_PREFIX");


          String name = "";

        try {
            // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:127:7: ( ( ADJECTIVE_PREFIX )? NAME -> ^( ADJECTIVE[name] ) )
            // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:127:10: ( ADJECTIVE_PREFIX )? NAME
            {
            // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:127:10: ( ADJECTIVE_PREFIX )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==ADJECTIVE_PREFIX) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:127:11: ADJECTIVE_PREFIX
                    {
                    ADJECTIVE_PREFIX35=(Token)match(input,ADJECTIVE_PREFIX,FOLLOW_ADJECTIVE_PREFIX_in_adjective377); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ADJECTIVE_PREFIX.add(ADJECTIVE_PREFIX35);

                    if ( state.backtracking==0 ) {
                      name = (ADJECTIVE_PREFIX35!=null?ADJECTIVE_PREFIX35.getText():null);
                    }

                    }
                    break;

            }

            NAME36=(Token)match(input,NAME,FOLLOW_NAME_in_adjective383); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(NAME36);

            if ( state.backtracking==0 ) {
              name += (NAME36!=null?NAME36.getText():null);
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
                // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:127:93: ^( ADJECTIVE[name] )
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
    // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:130:1: cls_contents : ( feature | adjective );
    public final HutnParser.cls_contents_return cls_contents() throws RecognitionException {
        HutnParser.cls_contents_return retval = new HutnParser.cls_contents_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        HutnParser.feature_return feature37 = null;

        HutnParser.adjective_return adjective38 = null;



        try {
            // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:130:13: ( feature | adjective )
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
                    // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:130:15: feature
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_feature_in_cls_contents406);
                    feature37=feature();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, feature37.getTree());

                    }
                    break;
                case 2 :
                    // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:130:25: adjective
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_adjective_in_cls_contents410);
                    adjective38=adjective();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, adjective38.getTree());

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
    // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:132:1: feature : NAME ASSIGNMENT feature_contents ;
    public final HutnParser.feature_return feature() throws RecognitionException {
        HutnParser.feature_return retval = new HutnParser.feature_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NAME39=null;
        Token ASSIGNMENT40=null;
        HutnParser.feature_contents_return feature_contents41 = null;


        CommonTree NAME39_tree=null;
        CommonTree ASSIGNMENT40_tree=null;

        try {
            // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:132:8: ( NAME ASSIGNMENT feature_contents )
            // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:132:10: NAME ASSIGNMENT feature_contents
            {
            root_0 = (CommonTree)adaptor.nil();

            NAME39=(Token)match(input,NAME,FOLLOW_NAME_in_feature417); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME39_tree = (CommonTree)adaptor.create(NAME39);
            root_0 = (CommonTree)adaptor.becomeRoot(NAME39_tree, root_0);
            }
            ASSIGNMENT40=(Token)match(input,ASSIGNMENT,FOLLOW_ASSIGNMENT_in_feature420); if (state.failed) return retval;
            pushFollow(FOLLOW_feature_contents_in_feature423);
            feature_contents41=feature_contents();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, feature_contents41.getTree());

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
    // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:134:1: feature_contents : ( attr | refs );
    public final HutnParser.feature_contents_return feature_contents() throws RecognitionException {
        HutnParser.feature_contents_return retval = new HutnParser.feature_contents_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        HutnParser.attr_return attr42 = null;

        HutnParser.refs_return refs43 = null;



        try {
            // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:134:17: ( attr | refs )
            int alt12=2;
            alt12 = dfa12.predict(input);
            switch (alt12) {
                case 1 :
                    // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:134:19: attr
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_attr_in_feature_contents430);
                    attr42=attr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, attr42.getTree());

                    }
                    break;
                case 2 :
                    // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:134:26: refs
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_refs_in_feature_contents434);
                    refs43=refs();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, refs43.getTree());

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
    // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:136:1: attr : ( attr_value ( COMMA attr_value )* | NULL );
    public final HutnParser.attr_return attr() throws RecognitionException {
        HutnParser.attr_return retval = new HutnParser.attr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token COMMA45=null;
        Token NULL47=null;
        HutnParser.attr_value_return attr_value44 = null;

        HutnParser.attr_value_return attr_value46 = null;


        CommonTree COMMA45_tree=null;
        CommonTree NULL47_tree=null;

        try {
            // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:136:5: ( attr_value ( COMMA attr_value )* | NULL )
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
                    // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:136:7: attr_value ( COMMA attr_value )*
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_attr_value_in_attr441);
                    attr_value44=attr_value();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, attr_value44.getTree());
                    // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:136:18: ( COMMA attr_value )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==COMMA) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:136:19: COMMA attr_value
                    	    {
                    	    COMMA45=(Token)match(input,COMMA,FOLLOW_COMMA_in_attr444); if (state.failed) return retval;
                    	    pushFollow(FOLLOW_attr_value_in_attr447);
                    	    attr_value46=attr_value();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, attr_value46.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:136:41: NULL
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    NULL47=(Token)match(input,NULL,FOLLOW_NULL_in_attr453); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL47_tree = (CommonTree)adaptor.create(NULL47);
                    adaptor.addChild(root_0, NULL47_tree);
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
    // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:138:1: attr_value : ( TEXTUAL_VALUE | NUMERIC_VALUE | bool | enum_value );
    public final HutnParser.attr_value_return attr_value() throws RecognitionException {
        HutnParser.attr_value_return retval = new HutnParser.attr_value_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token TEXTUAL_VALUE48=null;
        Token NUMERIC_VALUE49=null;
        HutnParser.bool_return bool50 = null;

        HutnParser.enum_value_return enum_value51 = null;


        CommonTree TEXTUAL_VALUE48_tree=null;
        CommonTree NUMERIC_VALUE49_tree=null;

        try {
            // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:138:11: ( TEXTUAL_VALUE | NUMERIC_VALUE | bool | enum_value )
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
                    // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:138:13: TEXTUAL_VALUE
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    TEXTUAL_VALUE48=(Token)match(input,TEXTUAL_VALUE,FOLLOW_TEXTUAL_VALUE_in_attr_value460); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TEXTUAL_VALUE48_tree = (CommonTree)adaptor.create(TEXTUAL_VALUE48);
                    adaptor.addChild(root_0, TEXTUAL_VALUE48_tree);
                    }

                    }
                    break;
                case 2 :
                    // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:138:29: NUMERIC_VALUE
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    NUMERIC_VALUE49=(Token)match(input,NUMERIC_VALUE,FOLLOW_NUMERIC_VALUE_in_attr_value464); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NUMERIC_VALUE49_tree = (CommonTree)adaptor.create(NUMERIC_VALUE49);
                    adaptor.addChild(root_0, NUMERIC_VALUE49_tree);
                    }

                    }
                    break;
                case 3 :
                    // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:138:45: bool
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_bool_in_attr_value468);
                    bool50=bool();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, bool50.getTree());

                    }
                    break;
                case 4 :
                    // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:138:52: enum_value
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_enum_value_in_attr_value472);
                    enum_value51=enum_value();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, enum_value51.getTree());

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
    // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:140:1: bool : ( TRUE | FALSE );
    public final HutnParser.bool_return bool() throws RecognitionException {
        HutnParser.bool_return retval = new HutnParser.bool_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set52=null;

        CommonTree set52_tree=null;

        try {
            // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:140:5: ( TRUE | FALSE )
            // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set52=(Token)input.LT(1);
            if ( (input.LA(1)>=TRUE && input.LA(1)<=FALSE) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set52));
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
    // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:142:1: refs : ref ( COMMA ref )* ;
    public final HutnParser.refs_return refs() throws RecognitionException {
        HutnParser.refs_return retval = new HutnParser.refs_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token COMMA54=null;
        HutnParser.ref_return ref53 = null;

        HutnParser.ref_return ref55 = null;


        CommonTree COMMA54_tree=null;

        try {
            // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:142:5: ( ref ( COMMA ref )* )
            // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:142:7: ref ( COMMA ref )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_ref_in_refs490);
            ref53=ref();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, ref53.getTree());
            // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:142:11: ( COMMA ref )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==COMMA) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:142:12: COMMA ref
            	    {
            	    COMMA54=(Token)match(input,COMMA,FOLLOW_COMMA_in_refs493); if (state.failed) return retval;
            	    pushFollow(FOLLOW_ref_in_refs496);
            	    ref55=ref();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, ref55.getTree());

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
    // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:144:1: ref : ( simple_ref | containment );
    public final HutnParser.ref_return ref() throws RecognitionException {
        HutnParser.ref_return retval = new HutnParser.ref_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        HutnParser.simple_ref_return simple_ref56 = null;

        HutnParser.containment_return containment57 = null;



        try {
            // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:144:4: ( simple_ref | containment )
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
                    // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:144:6: simple_ref
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_simple_ref_in_ref505);
                    simple_ref56=simple_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, simple_ref56.getTree());

                    }
                    break;
                case 2 :
                    // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:144:19: containment
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_containment_in_ref509);
                    containment57=containment();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, containment57.getTree());

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
    // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:146:1: simple_ref : NAME TEXTUAL_VALUE -> ^( REFERENCE[$NAME.text] TEXTUAL_VALUE ) ;
    public final HutnParser.simple_ref_return simple_ref() throws RecognitionException {
        HutnParser.simple_ref_return retval = new HutnParser.simple_ref_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NAME58=null;
        Token TEXTUAL_VALUE59=null;

        CommonTree NAME58_tree=null;
        CommonTree TEXTUAL_VALUE59_tree=null;
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_TEXTUAL_VALUE=new RewriteRuleTokenStream(adaptor,"token TEXTUAL_VALUE");

        try {
            // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:147:7: ( NAME TEXTUAL_VALUE -> ^( REFERENCE[$NAME.text] TEXTUAL_VALUE ) )
            // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:147:11: NAME TEXTUAL_VALUE
            {
            NAME58=(Token)match(input,NAME,FOLLOW_NAME_in_simple_ref525); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(NAME58);

            TEXTUAL_VALUE59=(Token)match(input,TEXTUAL_VALUE,FOLLOW_TEXTUAL_VALUE_in_simple_ref527); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TEXTUAL_VALUE.add(TEXTUAL_VALUE59);



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
                // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:147:33: ^( REFERENCE[$NAME.text] TEXTUAL_VALUE )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(REFERENCE, (NAME58!=null?NAME58.getText():null)), root_1);

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
    // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:150:1: containment : ( adjective )* NAME TEXTUAL_VALUE LBRACKET ( cls_contents )* RBRACKET ;
    public final HutnParser.containment_return containment() throws RecognitionException {
        HutnParser.containment_return retval = new HutnParser.containment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NAME61=null;
        Token TEXTUAL_VALUE62=null;
        Token LBRACKET63=null;
        Token RBRACKET65=null;
        HutnParser.adjective_return adjective60 = null;

        HutnParser.cls_contents_return cls_contents64 = null;


        CommonTree NAME61_tree=null;
        CommonTree TEXTUAL_VALUE62_tree=null;
        CommonTree LBRACKET63_tree=null;
        CommonTree RBRACKET65_tree=null;

        try {
            // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:150:12: ( ( adjective )* NAME TEXTUAL_VALUE LBRACKET ( cls_contents )* RBRACKET )
            // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:150:14: ( adjective )* NAME TEXTUAL_VALUE LBRACKET ( cls_contents )* RBRACKET
            {
            root_0 = (CommonTree)adaptor.nil();

            // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:150:14: ( adjective )*
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
            	    // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:0:0: adjective
            	    {
            	    pushFollow(FOLLOW_adjective_in_containment550);
            	    adjective60=adjective();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, adjective60.getTree());

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            NAME61=(Token)match(input,NAME,FOLLOW_NAME_in_containment553); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME61_tree = (CommonTree)adaptor.create(NAME61);
            root_0 = (CommonTree)adaptor.becomeRoot(NAME61_tree, root_0);
            }
            TEXTUAL_VALUE62=(Token)match(input,TEXTUAL_VALUE,FOLLOW_TEXTUAL_VALUE_in_containment556); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            TEXTUAL_VALUE62_tree = (CommonTree)adaptor.create(TEXTUAL_VALUE62);
            adaptor.addChild(root_0, TEXTUAL_VALUE62_tree);
            }
            LBRACKET63=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_containment558); if (state.failed) return retval;
            // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:150:55: ( cls_contents )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==NAME||LA19_0==ADJECTIVE_PREFIX) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:0:0: cls_contents
            	    {
            	    pushFollow(FOLLOW_cls_contents_in_containment561);
            	    cls_contents64=cls_contents();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, cls_contents64.getTree());

            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            RBRACKET65=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_containment564); if (state.failed) return retval;

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
    // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:152:1: enum_value : NAME ;
    public final HutnParser.enum_value_return enum_value() throws RecognitionException {
        HutnParser.enum_value_return retval = new HutnParser.enum_value_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NAME66=null;

        CommonTree NAME66_tree=null;

        try {
            // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:152:11: ( NAME )
            // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:152:13: NAME
            {
            root_0 = (CommonTree)adaptor.nil();

            NAME66=(Token)match(input,NAME,FOLLOW_NAME_in_enum_value572); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME66_tree = (CommonTree)adaptor.create(NAME66);
            root_0 = (CommonTree)adaptor.becomeRoot(NAME66_tree, root_0);
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
 

    public static final BitSet FOLLOW_pkg_in_document124 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EOF_in_document127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_pkg139 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_TEXTUAL_VALUE_in_pkg142 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_LBRACKET_in_pkg145 = new BitSet(new long[]{0x0000000000014800L});
    public static final BitSet FOLLOW_pkg_contents_in_pkg148 = new BitSet(new long[]{0x0000000000014800L});
    public static final BitSet FOLLOW_RBRACKET_in_pkg151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cls_in_pkg_contents159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cls_level_attribute_in_pkg_contents163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assoc_instance_in_pkg_contents167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_infix_assoc_in_assoc_instance174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assoc_block_in_assoc_instance178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simple_ref_in_infix_assoc194 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NAME_in_infix_assoc196 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_simple_ref_in_infix_assoc198 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_infix_assoc200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_assoc_block234 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_LBRACKET_in_assoc_block236 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_assoc_contents_in_assoc_block238 = new BitSet(new long[]{0x0000000000004800L});
    public static final BitSet FOLLOW_RBRACKET_in_assoc_block241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simple_ref_in_assoc_contents274 = new BitSet(new long[]{0x0000000000004800L});
    public static final BitSet FOLLOW_simple_ref_in_assoc_contents276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_cls_level_attribute299 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_cls_level_attribute301 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NAME_in_cls_level_attribute303 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_ASSIGNMENT_in_cls_level_attribute305 = new BitSet(new long[]{0x0000000000041870L});
    public static final BitSet FOLLOW_attr_in_cls_level_attribute307 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_cls_level_attribute309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_adjective_in_cls339 = new BitSet(new long[]{0x0000000000010800L});
    public static final BitSet FOLLOW_NAME_in_cls342 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_TEXTUAL_VALUE_in_cls345 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_LBRACKET_in_cls348 = new BitSet(new long[]{0x0000000000014800L});
    public static final BitSet FOLLOW_cls_contents_in_cls351 = new BitSet(new long[]{0x0000000000014800L});
    public static final BitSet FOLLOW_RBRACKET_in_cls354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ADJECTIVE_PREFIX_in_adjective377 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NAME_in_adjective383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_feature_in_cls_contents406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_adjective_in_cls_contents410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_feature417 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_ASSIGNMENT_in_feature420 = new BitSet(new long[]{0x0000000000055870L});
    public static final BitSet FOLLOW_feature_contents_in_feature423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attr_in_feature_contents430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_refs_in_feature_contents434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attr_value_in_attr441 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_COMMA_in_attr444 = new BitSet(new long[]{0x0000000000041830L});
    public static final BitSet FOLLOW_attr_value_in_attr447 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_NULL_in_attr453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXTUAL_VALUE_in_attr_value460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMERIC_VALUE_in_attr_value464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bool_in_attr_value468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enum_value_in_attr_value472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_bool0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ref_in_refs490 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_COMMA_in_refs493 = new BitSet(new long[]{0x0000000000055870L});
    public static final BitSet FOLLOW_ref_in_refs496 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_simple_ref_in_ref505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_containment_in_ref509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_simple_ref525 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_TEXTUAL_VALUE_in_simple_ref527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_adjective_in_containment550 = new BitSet(new long[]{0x0000000000014800L});
    public static final BitSet FOLLOW_NAME_in_containment553 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_TEXTUAL_VALUE_in_containment556 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_LBRACKET_in_containment558 = new BitSet(new long[]{0x0000000000014800L});
    public static final BitSet FOLLOW_cls_contents_in_containment561 = new BitSet(new long[]{0x0000000000014800L});
    public static final BitSet FOLLOW_RBRACKET_in_containment564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_enum_value572 = new BitSet(new long[]{0x0000000000000002L});

}