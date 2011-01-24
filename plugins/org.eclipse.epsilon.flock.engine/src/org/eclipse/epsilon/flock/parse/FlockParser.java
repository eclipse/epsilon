// $ANTLR 3.1b1 /Users/louis/Code/eclipse/workspaces/helios/epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g 2011-01-24 11:14:17

package org.eclipse.epsilon.flock.parse;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;

/*******************************************************************************
 * Copyright (c) 2009 The University of York.
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
public class FlockParser extends org.eclipse.epsilon.commons.parse.EpsilonParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "FLOAT", "DIGIT", "INT", "POINT", "POINT_POINT", "ARROW", "BOOLEAN", "EscapeSequence", "STRING", "StrangeNameLiteral", "Letter", "SpecialNameChar", "JavaIDDigit", "NAME", "WS", "COMMENT", "LINE_COMMENT", "Annotation", "FORMAL", "PARAMLIST", "ASSIGNMENT", "SPECIAL_ASSIGNMENT", "HELPERMETHOD", "StatementBlock", "FOR", "IF", "ELSE", "WHILE", "SWITCH", "CASE", "DEFAULT", "RETURN", "BREAK", "BREAKALL", "CONTINUE", "TRANSACTION", "COLLECTION", "ABORT", "CollectionType", "ModelElementType", "PARAMETERS", "NewExpression", "VAR", "NEW", "ANNOTATIONBLOCK", "EXECUTABLEANNOTATION", "DELETE", "THROW", "EXPRLIST", "EXPRRANGE", "NativeType", "MultiplicativeExpression", "OPERATOR", "FeatureCall", "EOLMODULE", "BLOCK", "FEATURECALL", "TYPE", "ENUMERATION_VALUE", "IMPORT", "MODELDECLARATION", "NAMESPACE", "ALIAS", "DRIVER", "MODELDECLARATIONPARAMETERS", "MODELDECLARATIONPARAMETER", "ITEMSELECTOR", "FLOCKMODULE", "RETYPE", "MIGRATE", "GUARD", "IGNORING", "'model'", "';'", "':'", "','", "'alias'", "'driver'", "'{'", "'}'", "'='", "'operation'", "'function'", "'('", "')'", "'import'", "'$'", "'!'", "'::'", "'#'", "'Native'", "'Collection'", "'Sequence'", "'List'", "'Bag'", "'Set'", "'OrderedSet'", "'for'", "'in'", "'if'", "'switch'", "'case'", "'default'", "'else'", "'while'", "'return'", "'throw'", "'delete'", "'break'", "'breakAll'", "'continue'", "'abort'", "'transaction'", "':='", "'::='", "'or'", "'and'", "'xor'", "'implies'", "'=='", "'>'", "'<'", "'>='", "'<='", "'<>'", "'+'", "'-'", "'*'", "'/'", "'not'", "'['", "']'", "'|'", "'new'", "'var'", "'retype'", "'to'", "'migrate'", "'ignoring'", "'when'"
    };
    public static final int RETYPE=72;
    public static final int WHILE=31;
    public static final int StatementBlock=27;
    public static final int FLOCKMODULE=71;
    public static final int StrangeNameLiteral=13;
    public static final int CASE=33;
    public static final int NEW=47;
    public static final int FeatureCall=57;
    public static final int EOF=-1;
    public static final int BREAK=36;
    public static final int TYPE=61;
    public static final int T__93=93;
    public static final int T__94=94;
    public static final int T__91=91;
    public static final int IMPORT=63;
    public static final int T__92=92;
    public static final int NAME=17;
    public static final int T__90=90;
    public static final int RETURN=35;
    public static final int NewExpression=45;
    public static final int VAR=46;
    public static final int ANNOTATIONBLOCK=48;
    public static final int NativeType=54;
    public static final int ABORT=41;
    public static final int COMMENT=19;
    public static final int T__99=99;
    public static final int ITEMSELECTOR=70;
    public static final int T__98=98;
    public static final int T__97=97;
    public static final int MultiplicativeExpression=55;
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
    public static final int BREAKALL=37;
    public static final int TRANSACTION=39;
    public static final int SWITCH=32;
    public static final int DRIVER=67;
    public static final int ELSE=30;
    public static final int EOLMODULE=58;
    public static final int MODELDECLARATION=64;
    public static final int PARAMLIST=23;
    public static final int INT=6;
    public static final int DELETE=50;
    public static final int T__85=85;
    public static final int T__141=141;
    public static final int T__84=84;
    public static final int T__142=142;
    public static final int T__87=87;
    public static final int HELPERMETHOD=26;
    public static final int T__86=86;
    public static final int T__140=140;
    public static final int T__89=89;
    public static final int NAMESPACE=65;
    public static final int T__88=88;
    public static final int CollectionType=42;
    public static final int T__143=143;
    public static final int T__126=126;
    public static final int T__125=125;
    public static final int T__128=128;
    public static final int T__127=127;
    public static final int WS=18;
    public static final int T__129=129;
    public static final int ALIAS=66;
    public static final int MIGRATE=73;
    public static final int JavaIDDigit=16;
    public static final int GUARD=74;
    public static final int IGNORING=75;
    public static final int Annotation=21;
    public static final int T__76=76;
    public static final int T__130=130;
    public static final int T__131=131;
    public static final int EscapeSequence=11;
    public static final int Letter=14;
    public static final int THROW=51;
    public static final int T__132=132;
    public static final int T__79=79;
    public static final int T__133=133;
    public static final int T__78=78;
    public static final int T__134=134;
    public static final int T__77=77;
    public static final int T__135=135;
    public static final int SPECIAL_ASSIGNMENT=25;
    public static final int MODELDECLARATIONPARAMETER=69;
    public static final int PARAMETERS=44;
    public static final int POINT=7;
    public static final int T__118=118;
    public static final int T__119=119;
    public static final int T__116=116;
    public static final int T__117=117;
    public static final int T__114=114;
    public static final int T__115=115;
    public static final int T__124=124;
    public static final int T__123=123;
    public static final int FOR=28;
    public static final int T__122=122;
    public static final int ENUMERATION_VALUE=62;
    public static final int T__121=121;
    public static final int T__120=120;
    public static final int FLOAT=4;
    public static final int EXECUTABLEANNOTATION=49;
    public static final int IF=29;
    public static final int ModelElementType=43;
    public static final int BOOLEAN=10;
    public static final int CONTINUE=38;
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
    public static final int COLLECTION=40;
    public static final int DIGIT=5;
    public static final int EXPRRANGE=53;
    public static final int OPERATOR=56;
    public static final int EXPRLIST=52;
    public static final int DEFAULT=34;
    public static final int T__102=102;
    public static final int T__101=101;
    public static final int T__100=100;
    public static final int POINT_POINT=8;
    public static final int SpecialNameChar=15;
    public static final int MODELDECLARATIONPARAMETERS=68;
    public static final int BLOCK=59;
    public static final int FEATURECALL=60;
    public static final int FORMAL=22;
    public static final int ARROW=9;
    public static final int ASSIGNMENT=24;
    public static final int STRING=12;

    // delegates
    public Flock_EolParserRules gEolParserRules;
    // delegators


        public FlockParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public FlockParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
            gEolParserRules = new Flock_EolParserRules(input, state, this);
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return FlockParser.tokenNames; }
    public String getGrammarFileName() { return "/Users/louis/Code/eclipse/workspaces/helios/epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g"; }


    public static class flockModule_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start flockModule
    // /Users/louis/Code/eclipse/workspaces/helios/epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:93:1: flockModule : ( importStatement )* ( flockModuleContent )* EOF -> ^( FLOCKMODULE ( importStatement )* ( flockModuleContent )* ) ;
    public final FlockParser.flockModule_return flockModule() throws RecognitionException {
        FlockParser.flockModule_return retval = new FlockParser.flockModule_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token EOF3=null;
        Flock_EolParserRules.importStatement_return importStatement1 = null;

        FlockParser.flockModuleContent_return flockModuleContent2 = null;


        CommonTree EOF3_tree=null;
        RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
        RewriteRuleSubtreeStream stream_flockModuleContent=new RewriteRuleSubtreeStream(adaptor,"rule flockModuleContent");
        RewriteRuleSubtreeStream stream_importStatement=new RewriteRuleSubtreeStream(adaptor,"rule importStatement");
        try {
            // /Users/louis/Code/eclipse/workspaces/helios/epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:94:2: ( ( importStatement )* ( flockModuleContent )* EOF -> ^( FLOCKMODULE ( importStatement )* ( flockModuleContent )* ) )
            // /Users/louis/Code/eclipse/workspaces/helios/epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:94:4: ( importStatement )* ( flockModuleContent )* EOF
            {
            // /Users/louis/Code/eclipse/workspaces/helios/epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:94:4: ( importStatement )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==89) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/louis/Code/eclipse/workspaces/helios/epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:0:0: importStatement
            	    {
            	    pushFollow(FOLLOW_importStatement_in_flockModule85);
            	    importStatement1=importStatement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_importStatement.add(importStatement1.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // /Users/louis/Code/eclipse/workspaces/helios/epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:94:21: ( flockModuleContent )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==Annotation||(LA2_0>=85 && LA2_0<=86)||LA2_0==90||LA2_0==111||LA2_0==139||LA2_0==141) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/louis/Code/eclipse/workspaces/helios/epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:94:22: flockModuleContent
            	    {
            	    pushFollow(FOLLOW_flockModuleContent_in_flockModule89);
            	    flockModuleContent2=flockModuleContent();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_flockModuleContent.add(flockModuleContent2.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            EOF3=(Token)match(input,EOF,FOLLOW_EOF_in_flockModule93); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EOF.add(EOF3);



            // AST REWRITE
            // elements: flockModuleContent, importStatement
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 95:2: -> ^( FLOCKMODULE ( importStatement )* ( flockModuleContent )* )
            {
                // /Users/louis/Code/eclipse/workspaces/helios/epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:95:5: ^( FLOCKMODULE ( importStatement )* ( flockModuleContent )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FLOCKMODULE, "FLOCKMODULE"), root_1);

                // /Users/louis/Code/eclipse/workspaces/helios/epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:95:19: ( importStatement )*
                while ( stream_importStatement.hasNext() ) {
                    adaptor.addChild(root_1, stream_importStatement.nextTree());

                }
                stream_importStatement.reset();
                // /Users/louis/Code/eclipse/workspaces/helios/epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:95:36: ( flockModuleContent )*
                while ( stream_flockModuleContent.hasNext() ) {
                    adaptor.addChild(root_1, stream_flockModuleContent.nextTree());

                }
                stream_flockModuleContent.reset();

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
    // $ANTLR end flockModule

    public static class flockModuleContent_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start flockModuleContent
    // /Users/louis/Code/eclipse/workspaces/helios/epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:98:1: flockModuleContent : ( retyping | deletion | migrateRule | operationDeclarationOrAnnotationBlock );
    public final FlockParser.flockModuleContent_return flockModuleContent() throws RecognitionException {
        FlockParser.flockModuleContent_return retval = new FlockParser.flockModuleContent_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        FlockParser.retyping_return retyping4 = null;

        FlockParser.deletion_return deletion5 = null;

        FlockParser.migrateRule_return migrateRule6 = null;

        Flock_EolParserRules.operationDeclarationOrAnnotationBlock_return operationDeclarationOrAnnotationBlock7 = null;



        try {
            // /Users/louis/Code/eclipse/workspaces/helios/epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:99:2: ( retyping | deletion | migrateRule | operationDeclarationOrAnnotationBlock )
            int alt3=4;
            switch ( input.LA(1) ) {
            case 139:
                {
                alt3=1;
                }
                break;
            case 111:
                {
                alt3=2;
                }
                break;
            case 141:
                {
                alt3=3;
                }
                break;
            case Annotation:
            case 85:
            case 86:
            case 90:
                {
                alt3=4;
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
                    // /Users/louis/Code/eclipse/workspaces/helios/epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:99:4: retyping
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_retyping_in_flockModuleContent117);
                    retyping4=retyping();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, retyping4.getTree());

                    }
                    break;
                case 2 :
                    // /Users/louis/Code/eclipse/workspaces/helios/epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:99:15: deletion
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_deletion_in_flockModuleContent121);
                    deletion5=deletion();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, deletion5.getTree());

                    }
                    break;
                case 3 :
                    // /Users/louis/Code/eclipse/workspaces/helios/epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:99:26: migrateRule
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_migrateRule_in_flockModuleContent125);
                    migrateRule6=migrateRule();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, migrateRule6.getTree());

                    }
                    break;
                case 4 :
                    // /Users/louis/Code/eclipse/workspaces/helios/epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:99:40: operationDeclarationOrAnnotationBlock
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_operationDeclarationOrAnnotationBlock_in_flockModuleContent129);
                    operationDeclarationOrAnnotationBlock7=operationDeclarationOrAnnotationBlock();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, operationDeclarationOrAnnotationBlock7.getTree());

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
    // $ANTLR end flockModuleContent

    public static class retyping_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start retyping
    // /Users/louis/Code/eclipse/workspaces/helios/epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:102:1: retyping : 'retype' originalType= NAME 'to' migratedType= NAME ( guard )? -> ^( RETYPE $originalType ( $migratedType)? ( guard )? ) ;
    public final FlockParser.retyping_return retyping() throws RecognitionException {
        FlockParser.retyping_return retval = new FlockParser.retyping_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token originalType=null;
        Token migratedType=null;
        Token string_literal8=null;
        Token string_literal9=null;
        FlockParser.guard_return guard10 = null;


        CommonTree originalType_tree=null;
        CommonTree migratedType_tree=null;
        CommonTree string_literal8_tree=null;
        CommonTree string_literal9_tree=null;
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_139=new RewriteRuleTokenStream(adaptor,"token 139");
        RewriteRuleTokenStream stream_140=new RewriteRuleTokenStream(adaptor,"token 140");
        RewriteRuleSubtreeStream stream_guard=new RewriteRuleSubtreeStream(adaptor,"rule guard");
        try {
            // /Users/louis/Code/eclipse/workspaces/helios/epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:103:3: ( 'retype' originalType= NAME 'to' migratedType= NAME ( guard )? -> ^( RETYPE $originalType ( $migratedType)? ( guard )? ) )
            // /Users/louis/Code/eclipse/workspaces/helios/epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:103:5: 'retype' originalType= NAME 'to' migratedType= NAME ( guard )?
            {
            string_literal8=(Token)match(input,139,FOLLOW_139_in_retyping141); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_139.add(string_literal8);

            originalType=(Token)match(input,NAME,FOLLOW_NAME_in_retyping145); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(originalType);

            string_literal9=(Token)match(input,140,FOLLOW_140_in_retyping147); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_140.add(string_literal9);

            migratedType=(Token)match(input,NAME,FOLLOW_NAME_in_retyping151); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(migratedType);

            // /Users/louis/Code/eclipse/workspaces/helios/epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:103:55: ( guard )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==143) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /Users/louis/Code/eclipse/workspaces/helios/epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:0:0: guard
                    {
                    pushFollow(FOLLOW_guard_in_retyping153);
                    guard10=guard();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_guard.add(guard10.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: guard, migratedType, originalType
            // token labels: migratedType, originalType
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_migratedType=new RewriteRuleTokenStream(adaptor,"token migratedType",migratedType);
            RewriteRuleTokenStream stream_originalType=new RewriteRuleTokenStream(adaptor,"token originalType",originalType);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 104:5: -> ^( RETYPE $originalType ( $migratedType)? ( guard )? )
            {
                // /Users/louis/Code/eclipse/workspaces/helios/epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:105:5: ^( RETYPE $originalType ( $migratedType)? ( guard )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(RETYPE, "RETYPE"), root_1);

                adaptor.addChild(root_1, stream_originalType.nextNode());
                // /Users/louis/Code/eclipse/workspaces/helios/epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:105:28: ( $migratedType)?
                if ( stream_migratedType.hasNext() ) {
                    adaptor.addChild(root_1, stream_migratedType.nextNode());

                }
                stream_migratedType.reset();
                // /Users/louis/Code/eclipse/workspaces/helios/epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:105:43: ( guard )?
                if ( stream_guard.hasNext() ) {
                    adaptor.addChild(root_1, stream_guard.nextTree());

                }
                stream_guard.reset();

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
    // $ANTLR end retyping

    public static class deletion_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start deletion
    // /Users/louis/Code/eclipse/workspaces/helios/epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:107:1: deletion : 'delete' type= NAME ( guard )? -> ^( DELETE $type ( guard )? ) ;
    public final FlockParser.deletion_return deletion() throws RecognitionException {
        FlockParser.deletion_return retval = new FlockParser.deletion_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token type=null;
        Token string_literal11=null;
        FlockParser.guard_return guard12 = null;


        CommonTree type_tree=null;
        CommonTree string_literal11_tree=null;
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_111=new RewriteRuleTokenStream(adaptor,"token 111");
        RewriteRuleSubtreeStream stream_guard=new RewriteRuleSubtreeStream(adaptor,"rule guard");
        try {
            // /Users/louis/Code/eclipse/workspaces/helios/epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:108:3: ( 'delete' type= NAME ( guard )? -> ^( DELETE $type ( guard )? ) )
            // /Users/louis/Code/eclipse/workspaces/helios/epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:108:5: 'delete' type= NAME ( guard )?
            {
            string_literal11=(Token)match(input,111,FOLLOW_111_in_deletion193); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_111.add(string_literal11);

            type=(Token)match(input,NAME,FOLLOW_NAME_in_deletion197); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(type);

            // /Users/louis/Code/eclipse/workspaces/helios/epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:108:24: ( guard )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==143) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /Users/louis/Code/eclipse/workspaces/helios/epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:0:0: guard
                    {
                    pushFollow(FOLLOW_guard_in_deletion199);
                    guard12=guard();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_guard.add(guard12.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: guard, type
            // token labels: type
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_type=new RewriteRuleTokenStream(adaptor,"token type",type);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 109:3: -> ^( DELETE $type ( guard )? )
            {
                // /Users/louis/Code/eclipse/workspaces/helios/epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:110:5: ^( DELETE $type ( guard )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(DELETE, "DELETE"), root_1);

                adaptor.addChild(root_1, stream_type.nextNode());
                // /Users/louis/Code/eclipse/workspaces/helios/epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:110:20: ( guard )?
                if ( stream_guard.hasNext() ) {
                    adaptor.addChild(root_1, stream_guard.nextTree());

                }
                stream_guard.reset();

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
    // $ANTLR end deletion

    public static class migrateRule_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start migrateRule
    // /Users/louis/Code/eclipse/workspaces/helios/epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:112:1: migrateRule : ( fullRule | ignoringRule );
    public final FlockParser.migrateRule_return migrateRule() throws RecognitionException {
        FlockParser.migrateRule_return retval = new FlockParser.migrateRule_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        FlockParser.fullRule_return fullRule13 = null;

        FlockParser.ignoringRule_return ignoringRule14 = null;



        try {
            // /Users/louis/Code/eclipse/workspaces/helios/epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:113:3: ( fullRule | ignoringRule )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==141) ) {
                int LA6_1 = input.LA(2);

                if ( (synpred8_Flock()) ) {
                    alt6=1;
                }
                else if ( (true) ) {
                    alt6=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // /Users/louis/Code/eclipse/workspaces/helios/epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:113:5: fullRule
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_fullRule_in_migrateRule228);
                    fullRule13=fullRule();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, fullRule13.getTree());

                    }
                    break;
                case 2 :
                    // /Users/louis/Code/eclipse/workspaces/helios/epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:113:16: ignoringRule
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_ignoringRule_in_migrateRule232);
                    ignoringRule14=ignoringRule();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, ignoringRule14.getTree());

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
    // $ANTLR end migrateRule

    public static class fullRule_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start fullRule
    // /Users/louis/Code/eclipse/workspaces/helios/epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:115:1: fullRule : 'migrate' originalType= NAME ( ignoring )? ( guard )? '{' body= block '}' -> ^( MIGRATE $originalType ( ignoring )? ( guard )? $body) ;
    public final FlockParser.fullRule_return fullRule() throws RecognitionException {
        FlockParser.fullRule_return retval = new FlockParser.fullRule_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token originalType=null;
        Token string_literal15=null;
        Token char_literal18=null;
        Token char_literal19=null;
        Flock_EolParserRules.block_return body = null;

        FlockParser.ignoring_return ignoring16 = null;

        FlockParser.guard_return guard17 = null;


        CommonTree originalType_tree=null;
        CommonTree string_literal15_tree=null;
        CommonTree char_literal18_tree=null;
        CommonTree char_literal19_tree=null;
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_82=new RewriteRuleTokenStream(adaptor,"token 82");
        RewriteRuleTokenStream stream_83=new RewriteRuleTokenStream(adaptor,"token 83");
        RewriteRuleTokenStream stream_141=new RewriteRuleTokenStream(adaptor,"token 141");
        RewriteRuleSubtreeStream stream_guard=new RewriteRuleSubtreeStream(adaptor,"rule guard");
        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        RewriteRuleSubtreeStream stream_ignoring=new RewriteRuleSubtreeStream(adaptor,"rule ignoring");
        try {
            // /Users/louis/Code/eclipse/workspaces/helios/epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:116:3: ( 'migrate' originalType= NAME ( ignoring )? ( guard )? '{' body= block '}' -> ^( MIGRATE $originalType ( ignoring )? ( guard )? $body) )
            // /Users/louis/Code/eclipse/workspaces/helios/epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:116:5: 'migrate' originalType= NAME ( ignoring )? ( guard )? '{' body= block '}'
            {
            string_literal15=(Token)match(input,141,FOLLOW_141_in_fullRule244); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_141.add(string_literal15);

            originalType=(Token)match(input,NAME,FOLLOW_NAME_in_fullRule248); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(originalType);

            // /Users/louis/Code/eclipse/workspaces/helios/epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:116:33: ( ignoring )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==142) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // /Users/louis/Code/eclipse/workspaces/helios/epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:0:0: ignoring
                    {
                    pushFollow(FOLLOW_ignoring_in_fullRule250);
                    ignoring16=ignoring();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_ignoring.add(ignoring16.getTree());

                    }
                    break;

            }

            // /Users/louis/Code/eclipse/workspaces/helios/epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:116:43: ( guard )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==143) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // /Users/louis/Code/eclipse/workspaces/helios/epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:0:0: guard
                    {
                    pushFollow(FOLLOW_guard_in_fullRule253);
                    guard17=guard();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_guard.add(guard17.getTree());

                    }
                    break;

            }

            char_literal18=(Token)match(input,82,FOLLOW_82_in_fullRule256); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_82.add(char_literal18);

            pushFollow(FOLLOW_block_in_fullRule260);
            body=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_block.add(body.getTree());
            char_literal19=(Token)match(input,83,FOLLOW_83_in_fullRule262); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_83.add(char_literal19);



            // AST REWRITE
            // elements: body, originalType, guard, ignoring
            // token labels: originalType
            // rule labels: body, retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_originalType=new RewriteRuleTokenStream(adaptor,"token originalType",originalType);
            RewriteRuleSubtreeStream stream_body=new RewriteRuleSubtreeStream(adaptor,"token body",body!=null?body.tree:null);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 117:5: -> ^( MIGRATE $originalType ( ignoring )? ( guard )? $body)
            {
                // /Users/louis/Code/eclipse/workspaces/helios/epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:118:5: ^( MIGRATE $originalType ( ignoring )? ( guard )? $body)
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(MIGRATE, "MIGRATE"), root_1);

                adaptor.addChild(root_1, stream_originalType.nextNode());
                // /Users/louis/Code/eclipse/workspaces/helios/epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:118:29: ( ignoring )?
                if ( stream_ignoring.hasNext() ) {
                    adaptor.addChild(root_1, stream_ignoring.nextTree());

                }
                stream_ignoring.reset();
                // /Users/louis/Code/eclipse/workspaces/helios/epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:118:39: ( guard )?
                if ( stream_guard.hasNext() ) {
                    adaptor.addChild(root_1, stream_guard.nextTree());

                }
                stream_guard.reset();
                adaptor.addChild(root_1, stream_body.nextTree());

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
    // $ANTLR end fullRule

    public static class ignoringRule_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ignoringRule
    // /Users/louis/Code/eclipse/workspaces/helios/epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:120:1: ignoringRule : 'migrate' originalType= NAME ignoring ( guard )? -> ^( MIGRATE $originalType ignoring ( guard )? ) ;
    public final FlockParser.ignoringRule_return ignoringRule() throws RecognitionException {
        FlockParser.ignoringRule_return retval = new FlockParser.ignoringRule_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token originalType=null;
        Token string_literal20=null;
        FlockParser.ignoring_return ignoring21 = null;

        FlockParser.guard_return guard22 = null;


        CommonTree originalType_tree=null;
        CommonTree string_literal20_tree=null;
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_141=new RewriteRuleTokenStream(adaptor,"token 141");
        RewriteRuleSubtreeStream stream_guard=new RewriteRuleSubtreeStream(adaptor,"rule guard");
        RewriteRuleSubtreeStream stream_ignoring=new RewriteRuleSubtreeStream(adaptor,"rule ignoring");
        try {
            // /Users/louis/Code/eclipse/workspaces/helios/epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:121:3: ( 'migrate' originalType= NAME ignoring ( guard )? -> ^( MIGRATE $originalType ignoring ( guard )? ) )
            // /Users/louis/Code/eclipse/workspaces/helios/epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:121:5: 'migrate' originalType= NAME ignoring ( guard )?
            {
            string_literal20=(Token)match(input,141,FOLLOW_141_in_ignoringRule304); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_141.add(string_literal20);

            originalType=(Token)match(input,NAME,FOLLOW_NAME_in_ignoringRule308); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(originalType);

            pushFollow(FOLLOW_ignoring_in_ignoringRule310);
            ignoring21=ignoring();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_ignoring.add(ignoring21.getTree());
            // /Users/louis/Code/eclipse/workspaces/helios/epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:121:42: ( guard )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==143) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // /Users/louis/Code/eclipse/workspaces/helios/epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:0:0: guard
                    {
                    pushFollow(FOLLOW_guard_in_ignoringRule312);
                    guard22=guard();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_guard.add(guard22.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: ignoring, originalType, guard
            // token labels: originalType
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_originalType=new RewriteRuleTokenStream(adaptor,"token originalType",originalType);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 122:5: -> ^( MIGRATE $originalType ignoring ( guard )? )
            {
                // /Users/louis/Code/eclipse/workspaces/helios/epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:123:5: ^( MIGRATE $originalType ignoring ( guard )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(MIGRATE, "MIGRATE"), root_1);

                adaptor.addChild(root_1, stream_originalType.nextNode());
                adaptor.addChild(root_1, stream_ignoring.nextTree());
                // /Users/louis/Code/eclipse/workspaces/helios/epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:123:38: ( guard )?
                if ( stream_guard.hasNext() ) {
                    adaptor.addChild(root_1, stream_guard.nextTree());

                }
                stream_guard.reset();

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
    // $ANTLR end ignoringRule

    public static class ignoring_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ignoring
    // /Users/louis/Code/eclipse/workspaces/helios/epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:125:1: ignoring : 'ignoring' propertyList -> ^( IGNORING propertyList ) ;
    public final FlockParser.ignoring_return ignoring() throws RecognitionException {
        FlockParser.ignoring_return retval = new FlockParser.ignoring_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal23=null;
        FlockParser.propertyList_return propertyList24 = null;


        CommonTree string_literal23_tree=null;
        RewriteRuleTokenStream stream_142=new RewriteRuleTokenStream(adaptor,"token 142");
        RewriteRuleSubtreeStream stream_propertyList=new RewriteRuleSubtreeStream(adaptor,"rule propertyList");
        try {
            // /Users/louis/Code/eclipse/workspaces/helios/epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:126:3: ( 'ignoring' propertyList -> ^( IGNORING propertyList ) )
            // /Users/louis/Code/eclipse/workspaces/helios/epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:126:5: 'ignoring' propertyList
            {
            string_literal23=(Token)match(input,142,FOLLOW_142_in_ignoring347); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_142.add(string_literal23);

            pushFollow(FOLLOW_propertyList_in_ignoring349);
            propertyList24=propertyList();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_propertyList.add(propertyList24.getTree());


            // AST REWRITE
            // elements: propertyList
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 127:3: -> ^( IGNORING propertyList )
            {
                // /Users/louis/Code/eclipse/workspaces/helios/epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:128:3: ^( IGNORING propertyList )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(IGNORING, "IGNORING"), root_1);

                adaptor.addChild(root_1, stream_propertyList.nextTree());

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
    // $ANTLR end ignoring

    public static class propertyList_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start propertyList
    // /Users/louis/Code/eclipse/workspaces/helios/epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:130:1: propertyList : NAME ( ',' NAME )* -> ( NAME )* ;
    public final FlockParser.propertyList_return propertyList() throws RecognitionException {
        FlockParser.propertyList_return retval = new FlockParser.propertyList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NAME25=null;
        Token char_literal26=null;
        Token NAME27=null;

        CommonTree NAME25_tree=null;
        CommonTree char_literal26_tree=null;
        CommonTree NAME27_tree=null;
        RewriteRuleTokenStream stream_79=new RewriteRuleTokenStream(adaptor,"token 79");
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");

        try {
            // /Users/louis/Code/eclipse/workspaces/helios/epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:131:3: ( NAME ( ',' NAME )* -> ( NAME )* )
            // /Users/louis/Code/eclipse/workspaces/helios/epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:131:5: NAME ( ',' NAME )*
            {
            NAME25=(Token)match(input,NAME,FOLLOW_NAME_in_propertyList373); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(NAME25);

            // /Users/louis/Code/eclipse/workspaces/helios/epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:131:10: ( ',' NAME )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==79) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // /Users/louis/Code/eclipse/workspaces/helios/epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:131:11: ',' NAME
            	    {
            	    char_literal26=(Token)match(input,79,FOLLOW_79_in_propertyList376); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_79.add(char_literal26);

            	    NAME27=(Token)match(input,NAME,FOLLOW_NAME_in_propertyList378); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_NAME.add(NAME27);


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);



            // AST REWRITE
            // elements: NAME
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 132:3: -> ( NAME )*
            {
                // /Users/louis/Code/eclipse/workspaces/helios/epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:133:3: ( NAME )*
                while ( stream_NAME.hasNext() ) {
                    adaptor.addChild(root_0, stream_NAME.nextNode());

                }
                stream_NAME.reset();

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
    // $ANTLR end propertyList

    public static class guard_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start guard
    // /Users/louis/Code/eclipse/workspaces/helios/epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:135:1: guard : 'when' expressionOrStatementBlock -> ^( GUARD expressionOrStatementBlock ) ;
    public final FlockParser.guard_return guard() throws RecognitionException {
        FlockParser.guard_return retval = new FlockParser.guard_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal28=null;
        Flock_EolParserRules.expressionOrStatementBlock_return expressionOrStatementBlock29 = null;


        CommonTree string_literal28_tree=null;
        RewriteRuleTokenStream stream_143=new RewriteRuleTokenStream(adaptor,"token 143");
        RewriteRuleSubtreeStream stream_expressionOrStatementBlock=new RewriteRuleSubtreeStream(adaptor,"rule expressionOrStatementBlock");
        try {
            // /Users/louis/Code/eclipse/workspaces/helios/epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:136:3: ( 'when' expressionOrStatementBlock -> ^( GUARD expressionOrStatementBlock ) )
            // /Users/louis/Code/eclipse/workspaces/helios/epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:136:5: 'when' expressionOrStatementBlock
            {
            string_literal28=(Token)match(input,143,FOLLOW_143_in_guard399); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_143.add(string_literal28);

            pushFollow(FOLLOW_expressionOrStatementBlock_in_guard401);
            expressionOrStatementBlock29=expressionOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expressionOrStatementBlock.add(expressionOrStatementBlock29.getTree());


            // AST REWRITE
            // elements: expressionOrStatementBlock
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 137:5: -> ^( GUARD expressionOrStatementBlock )
            {
                // /Users/louis/Code/eclipse/workspaces/helios/epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:138:5: ^( GUARD expressionOrStatementBlock )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(GUARD, "GUARD"), root_1);

                adaptor.addChild(root_1, stream_expressionOrStatementBlock.nextTree());

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
    // $ANTLR end guard

    // $ANTLR start synpred8_Flock
    public final void synpred8_Flock_fragment() throws RecognitionException {   
        // /Users/louis/Code/eclipse/workspaces/helios/epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:113:5: ( fullRule )
        // /Users/louis/Code/eclipse/workspaces/helios/epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:113:5: fullRule
        {
        pushFollow(FOLLOW_fullRule_in_synpred8_Flock228);
        fullRule();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred8_Flock

    // Delegated rules
    public Flock_EolParserRules.featureCall_return featureCall() throws RecognitionException { return gEolParserRules.featureCall(); }
    public Flock_EolParserRules.assignmentStatement_return assignmentStatement() throws RecognitionException { return gEolParserRules.assignmentStatement(); }
    public Flock_EolParserRules.breakStatement_return breakStatement() throws RecognitionException { return gEolParserRules.breakStatement(); }
    public Flock_EolParserRules.expressionListOrRange_return expressionListOrRange() throws RecognitionException { return gEolParserRules.expressionListOrRange(); }
    public Flock_EolParserRules.formalParameter_return formalParameter() throws RecognitionException { return gEolParserRules.formalParameter(); }
    public Flock_EolParserRules.statement_return statement() throws RecognitionException { return gEolParserRules.statement(); }
    public Flock_EolParserRules.modelAlias_return modelAlias() throws RecognitionException { return gEolParserRules.modelAlias(); }
    public Flock_EolParserRules.declarativeFeatureCall_return declarativeFeatureCall() throws RecognitionException { return gEolParserRules.declarativeFeatureCall(); }
    public Flock_EolParserRules.variableDeclarationExpression_return variableDeclarationExpression() throws RecognitionException { return gEolParserRules.variableDeclarationExpression(); }
    public Flock_EolParserRules.expressionOrStatementBlock_return expressionOrStatementBlock() throws RecognitionException { return gEolParserRules.expressionOrStatementBlock(); }
    public Flock_EolParserRules.modelDriver_return modelDriver() throws RecognitionException { return gEolParserRules.modelDriver(); }
    public Flock_EolParserRules.statementA_return statementA() throws RecognitionException { return gEolParserRules.statementA(); }
    public Flock_EolParserRules.logicalExpression_return logicalExpression() throws RecognitionException { return gEolParserRules.logicalExpression(); }
    public Flock_EolParserRules.executableAnnotation_return executableAnnotation() throws RecognitionException { return gEolParserRules.executableAnnotation(); }
    public Flock_EolParserRules.expressionRange_return expressionRange() throws RecognitionException { return gEolParserRules.expressionRange(); }
    public Flock_EolParserRules.simpleFeatureCall_return simpleFeatureCall() throws RecognitionException { return gEolParserRules.simpleFeatureCall(); }
    public Flock_EolParserRules.nativeType_return nativeType() throws RecognitionException { return gEolParserRules.nativeType(); }
    public Flock_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock() throws RecognitionException { return gEolParserRules.statementOrStatementBlock(); }
    public Flock_EolParserRules.primitiveExpression_return primitiveExpression() throws RecognitionException { return gEolParserRules.primitiveExpression(); }
    public Flock_EolParserRules.throwStatement_return throwStatement() throws RecognitionException { return gEolParserRules.throwStatement(); }
    public Flock_EolParserRules.forStatement_return forStatement() throws RecognitionException { return gEolParserRules.forStatement(); }
    public Flock_EolParserRules.block_return block() throws RecognitionException { return gEolParserRules.block(); }
    public Flock_EolParserRules.continueStatement_return continueStatement() throws RecognitionException { return gEolParserRules.continueStatement(); }
    public Flock_EolParserRules.expressionStatement_return expressionStatement() throws RecognitionException { return gEolParserRules.expressionStatement(); }
    public Flock_EolParserRules.returnStatement_return returnStatement() throws RecognitionException { return gEolParserRules.returnStatement(); }
    public Flock_EolParserRules.postfixExpression_return postfixExpression() throws RecognitionException { return gEolParserRules.postfixExpression(); }
    public Flock_EolParserRules.literal_return literal() throws RecognitionException { return gEolParserRules.literal(); }
    public Flock_EolParserRules.defaultStatement_return defaultStatement() throws RecognitionException { return gEolParserRules.defaultStatement(); }
    public Flock_EolParserRules.litteralCollection_return litteralCollection() throws RecognitionException { return gEolParserRules.litteralCollection(); }
    public Flock_EolParserRules.additiveExpression_return additiveExpression() throws RecognitionException { return gEolParserRules.additiveExpression(); }
    public Flock_EolParserRules.pathName_return pathName() throws RecognitionException { return gEolParserRules.pathName(); }
    public Flock_EolParserRules.whileStatement_return whileStatement() throws RecognitionException { return gEolParserRules.whileStatement(); }
    public Flock_EolParserRules.modelElementType_return modelElementType() throws RecognitionException { return gEolParserRules.modelElementType(); }
    public Flock_EolParserRules.parameterList_return parameterList() throws RecognitionException { return gEolParserRules.parameterList(); }
    public Flock_EolParserRules.multiplicativeExpression_return multiplicativeExpression() throws RecognitionException { return gEolParserRules.multiplicativeExpression(); }
    public Flock_EolParserRules.relationalExpression_return relationalExpression() throws RecognitionException { return gEolParserRules.relationalExpression(); }
    public Flock_EolParserRules.expressionList_return expressionList() throws RecognitionException { return gEolParserRules.expressionList(); }
    public Flock_EolParserRules.modelDeclarationParameters_return modelDeclarationParameters() throws RecognitionException { return gEolParserRules.modelDeclarationParameters(); }
    public Flock_EolParserRules.typeName_return typeName() throws RecognitionException { return gEolParserRules.typeName(); }
    public Flock_EolParserRules.modelDeclaration_return modelDeclaration() throws RecognitionException { return gEolParserRules.modelDeclaration(); }
    public Flock_EolParserRules.modelNamespace_return modelNamespace() throws RecognitionException { return gEolParserRules.modelNamespace(); }
    public Flock_EolParserRules.breakAllStatement_return breakAllStatement() throws RecognitionException { return gEolParserRules.breakAllStatement(); }
    public Flock_EolParserRules.operationDeclaration_return operationDeclaration() throws RecognitionException { return gEolParserRules.operationDeclaration(); }
    public Flock_EolParserRules.transactionStatement_return transactionStatement() throws RecognitionException { return gEolParserRules.transactionStatement(); }
    public Flock_EolParserRules.statementBlock_return statementBlock() throws RecognitionException { return gEolParserRules.statementBlock(); }
    public Flock_EolParserRules.unaryExpression_return unaryExpression() throws RecognitionException { return gEolParserRules.unaryExpression(); }
    public Flock_EolParserRules.modelDeclarationParameter_return modelDeclarationParameter() throws RecognitionException { return gEolParserRules.modelDeclarationParameter(); }
    public Flock_EolParserRules.ifStatement_return ifStatement() throws RecognitionException { return gEolParserRules.ifStatement(); }
    public Flock_EolParserRules.operationDeclarationOrAnnotationBlock_return operationDeclarationOrAnnotationBlock() throws RecognitionException { return gEolParserRules.operationDeclarationOrAnnotationBlock(); }
    public Flock_EolParserRules.abortStatement_return abortStatement() throws RecognitionException { return gEolParserRules.abortStatement(); }
    public Flock_EolParserRules.caseStatement_return caseStatement() throws RecognitionException { return gEolParserRules.caseStatement(); }
    public Flock_EolParserRules.annotation_return annotation() throws RecognitionException { return gEolParserRules.annotation(); }
    public Flock_EolParserRules.formalParameterList_return formalParameterList() throws RecognitionException { return gEolParserRules.formalParameterList(); }
    public Flock_EolParserRules.statementB_return statementB() throws RecognitionException { return gEolParserRules.statementB(); }
    public Flock_EolParserRules.itemSelectorExpression_return itemSelectorExpression() throws RecognitionException { return gEolParserRules.itemSelectorExpression(); }
    public Flock_EolParserRules.deleteStatement_return deleteStatement() throws RecognitionException { return gEolParserRules.deleteStatement(); }
    public Flock_EolParserRules.elseStatement_return elseStatement() throws RecognitionException { return gEolParserRules.elseStatement(); }
    public Flock_EolParserRules.newExpression_return newExpression() throws RecognitionException { return gEolParserRules.newExpression(); }
    public Flock_EolParserRules.collectionType_return collectionType() throws RecognitionException { return gEolParserRules.collectionType(); }
    public Flock_EolParserRules.switchStatement_return switchStatement() throws RecognitionException { return gEolParserRules.switchStatement(); }
    public Flock_EolParserRules.annotationBlock_return annotationBlock() throws RecognitionException { return gEolParserRules.annotationBlock(); }
    public Flock_EolParserRules.importStatement_return importStatement() throws RecognitionException { return gEolParserRules.importStatement(); }

    public final boolean synpred8_Flock() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_Flock_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_importStatement_in_flockModule85 = new BitSet(new long[]{0x0000000000200000L,0x0000800006600000L,0x0000000000002800L});
    public static final BitSet FOLLOW_flockModuleContent_in_flockModule89 = new BitSet(new long[]{0x0000000000200000L,0x0000800004600000L,0x0000000000002800L});
    public static final BitSet FOLLOW_EOF_in_flockModule93 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_retyping_in_flockModuleContent117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_deletion_in_flockModuleContent121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_migrateRule_in_flockModuleContent125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_operationDeclarationOrAnnotationBlock_in_flockModuleContent129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_139_in_retyping141 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NAME_in_retyping145 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_140_in_retyping147 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NAME_in_retyping151 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_guard_in_retyping153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_111_in_deletion193 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NAME_in_deletion197 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_guard_in_deletion199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fullRule_in_migrateRule228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ignoringRule_in_migrateRule232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_141_in_fullRule244 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NAME_in_fullRule248 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L,0x000000000000C000L});
    public static final BitSet FOLLOW_ignoring_in_fullRule250 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L,0x0000000000008000L});
    public static final BitSet FOLLOW_guard_in_fullRule253 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_82_in_fullRule256 = new BitSet(new long[]{0x0000000000021450L,0x001FF1BFC0880000L,0x0000000000000624L});
    public static final BitSet FOLLOW_block_in_fullRule260 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_83_in_fullRule262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_141_in_ignoringRule304 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NAME_in_ignoringRule308 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_ignoring_in_ignoringRule310 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_guard_in_ignoringRule312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_142_in_ignoring347 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_propertyList_in_ignoring349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_propertyList373 = new BitSet(new long[]{0x0000000000000002L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_propertyList376 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NAME_in_propertyList378 = new BitSet(new long[]{0x0000000000000002L,0x0000000000008000L});
    public static final BitSet FOLLOW_143_in_guard399 = new BitSet(new long[]{0x0000000000000000L,0x0000000000044000L});
    public static final BitSet FOLLOW_expressionOrStatementBlock_in_guard401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fullRule_in_synpred8_Flock228 = new BitSet(new long[]{0x0000000000000002L});

}