// $ANTLR 3.1b1 /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g 2009-08-28 18:27:22

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "FLOAT", "DIGIT", "INT", "POINT", "POINT_POINT", "ARROW", "BOOLEAN", "EscapeSequence", "STRING", "StrangeNameLiteral", "Letter", "JavaIDDigit", "NAME", "WS", "COMMENT", "LINE_COMMENT", "Annotation", "FORMAL", "PARAMLIST", "ASSIGNMENT", "SPECIAL_ASSIGNMENT", "HELPERMETHOD", "StatementBlock", "FOR", "IF", "ELSE", "WHILE", "RETURN", "BREAK", "BREAKALL", "CONTINUE", "TRANSACTION", "COLLECTION", "ABORT", "CollectionType", "ModelElementType", "PARAMETERS", "NewExpression", "VAR", "NEW", "ANNOTATIONBLOCK", "EXECUTABLEANNOTATION", "DELETE", "THROW", "EXPRLIST", "EXPRRANGE", "NativeType", "MultiplicativeExpression", "OPERATOR", "FeatureCall", "EOLMODULE", "BLOCK", "FEATURECALL", "TYPE", "ENUMERATION_VALUE", "IMPORT", "MODELDECLARATION", "NAMESPACE", "ALIAS", "FLOCKMODULE", "MIGRATE", "'model'", "';'", "':'", "','", "'alias'", "'operation'", "'('", "')'", "'import'", "'{'", "'}'", "'$'", "'!'", "'::'", "'#'", "'Native'", "'Collection'", "'Sequence'", "'Bag'", "'Set'", "'OrderedSet'", "'for'", "'in'", "'if'", "'else'", "'while'", "'return'", "'throw'", "'delete'", "'break'", "'breakAll'", "'continue'", "'abort'", "'transaction'", "':='", "'::='", "'or'", "'and'", "'xor'", "'implies'", "'=='", "'='", "'>'", "'<'", "'>='", "'<='", "'<>'", "'+'", "'-'", "'*'", "'/'", "'not'", "'|'", "'new'", "'var'", "'migrate'", "'to'", "'when'"
    };
    public static final int StatementBlock=26;
    public static final int WHILE=30;
    public static final int FLOCKMODULE=63;
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
    public static final int T__71=71;
    public static final int WS=17;
    public static final int T__72=72;
    public static final int T__70=70;
    public static final int ALIAS=62;
    public static final int MIGRATE=64;
    public static final int JavaIDDigit=15;
    public static final int Annotation=20;
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int T__73=73;
    public static final int EscapeSequence=11;
    public static final int Letter=14;
    public static final int THROW=47;
    public static final int T__79=79;
    public static final int T__78=78;
    public static final int T__77=77;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__66=66;
    public static final int SPECIAL_ASSIGNMENT=24;
    public static final int T__67=67;
    public static final int T__65=65;
    public static final int PARAMETERS=40;
    public static final int POINT=7;
    public static final int T__118=118;
    public static final int T__119=119;
    public static final int T__116=116;
    public static final int T__117=117;
    public static final int T__114=114;
    public static final int T__115=115;
    public static final int T__122=122;
    public static final int FOR=27;
    public static final int ENUMERATION_VALUE=58;
    public static final int T__121=121;
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
    public static final int ARROW=9;
    public static final int ASSIGNMENT=23;
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
    public String getGrammarFileName() { return "/Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g"; }


    public static class flockModule_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start flockModule
    // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:93:1: flockModule : ( importStatement )* ( flockModuleContent )* EOF -> ^( FLOCKMODULE ( importStatement )* ( flockModuleContent )* ) ;
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
            // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:94:2: ( ( importStatement )* ( flockModuleContent )* EOF -> ^( FLOCKMODULE ( importStatement )* ( flockModuleContent )* ) )
            // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:94:4: ( importStatement )* ( flockModuleContent )* EOF
            {
            // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:94:4: ( importStatement )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==73) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:0:0: importStatement
            	    {
            	    pushFollow(FOLLOW_importStatement_in_flockModule73);
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

            // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:94:21: ( flockModuleContent )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==Annotation||LA2_0==70||LA2_0==76||LA2_0==120) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:94:22: flockModuleContent
            	    {
            	    pushFollow(FOLLOW_flockModuleContent_in_flockModule77);
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

            EOF3=(Token)match(input,EOF,FOLLOW_EOF_in_flockModule81); if (state.failed) return retval; 
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
                // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:95:5: ^( FLOCKMODULE ( importStatement )* ( flockModuleContent )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FLOCKMODULE, "FLOCKMODULE"), root_1);

                // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:95:19: ( importStatement )*
                while ( stream_importStatement.hasNext() ) {
                    adaptor.addChild(root_1, stream_importStatement.nextTree());

                }
                stream_importStatement.reset();
                // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:95:36: ( flockModuleContent )*
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
    // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:98:1: flockModuleContent : ( migrationRule | operationDeclarationOrAnnotationBlock );
    public final FlockParser.flockModuleContent_return flockModuleContent() throws RecognitionException {
        FlockParser.flockModuleContent_return retval = new FlockParser.flockModuleContent_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        FlockParser.migrationRule_return migrationRule4 = null;

        Flock_EolParserRules.operationDeclarationOrAnnotationBlock_return operationDeclarationOrAnnotationBlock5 = null;



        try {
            // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:99:2: ( migrationRule | operationDeclarationOrAnnotationBlock )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==120) ) {
                alt3=1;
            }
            else if ( (LA3_0==Annotation||LA3_0==70||LA3_0==76) ) {
                alt3=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:99:4: migrationRule
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_migrationRule_in_flockModuleContent105);
                    migrationRule4=migrationRule();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, migrationRule4.getTree());

                    }
                    break;
                case 2 :
                    // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:99:20: operationDeclarationOrAnnotationBlock
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_operationDeclarationOrAnnotationBlock_in_flockModuleContent109);
                    operationDeclarationOrAnnotationBlock5=operationDeclarationOrAnnotationBlock();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, operationDeclarationOrAnnotationBlock5.getTree());

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

    public static class migrationRule_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start migrationRule
    // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:102:1: migrationRule : ( fullMigrationRule | shorthandMigrationRule );
    public final FlockParser.migrationRule_return migrationRule() throws RecognitionException {
        FlockParser.migrationRule_return retval = new FlockParser.migrationRule_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        FlockParser.fullMigrationRule_return fullMigrationRule6 = null;

        FlockParser.shorthandMigrationRule_return shorthandMigrationRule7 = null;



        try {
            // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:103:3: ( fullMigrationRule | shorthandMigrationRule )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==120) ) {
                int LA4_1 = input.LA(2);

                if ( (synpred4_Flock()) ) {
                    alt4=1;
                }
                else if ( (true) ) {
                    alt4=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 1, input);

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
                    // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:103:5: fullMigrationRule
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_fullMigrationRule_in_migrationRule121);
                    fullMigrationRule6=fullMigrationRule();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, fullMigrationRule6.getTree());

                    }
                    break;
                case 2 :
                    // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:103:25: shorthandMigrationRule
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_shorthandMigrationRule_in_migrationRule125);
                    shorthandMigrationRule7=shorthandMigrationRule();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, shorthandMigrationRule7.getTree());

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
    // $ANTLR end migrationRule

    public static class fullMigrationRule_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start fullMigrationRule
    // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:105:1: fullMigrationRule : 'migrate' originalType= NAME ( 'to' migratedType= NAME )? ( 'when' guard= expressionOrStatementBlock )? '{' block '}' -> ^( MIGRATE $originalType ( $migratedType)? ( $guard)? block ) ;
    public final FlockParser.fullMigrationRule_return fullMigrationRule() throws RecognitionException {
        FlockParser.fullMigrationRule_return retval = new FlockParser.fullMigrationRule_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token originalType=null;
        Token migratedType=null;
        Token string_literal8=null;
        Token string_literal9=null;
        Token string_literal10=null;
        Token char_literal11=null;
        Token char_literal13=null;
        Flock_EolParserRules.expressionOrStatementBlock_return guard = null;

        Flock_EolParserRules.block_return block12 = null;


        CommonTree originalType_tree=null;
        CommonTree migratedType_tree=null;
        CommonTree string_literal8_tree=null;
        CommonTree string_literal9_tree=null;
        CommonTree string_literal10_tree=null;
        CommonTree char_literal11_tree=null;
        CommonTree char_literal13_tree=null;
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_121=new RewriteRuleTokenStream(adaptor,"token 121");
        RewriteRuleTokenStream stream_122=new RewriteRuleTokenStream(adaptor,"token 122");
        RewriteRuleTokenStream stream_120=new RewriteRuleTokenStream(adaptor,"token 120");
        RewriteRuleTokenStream stream_74=new RewriteRuleTokenStream(adaptor,"token 74");
        RewriteRuleTokenStream stream_75=new RewriteRuleTokenStream(adaptor,"token 75");
        RewriteRuleSubtreeStream stream_expressionOrStatementBlock=new RewriteRuleSubtreeStream(adaptor,"rule expressionOrStatementBlock");
        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        try {
            // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:106:3: ( 'migrate' originalType= NAME ( 'to' migratedType= NAME )? ( 'when' guard= expressionOrStatementBlock )? '{' block '}' -> ^( MIGRATE $originalType ( $migratedType)? ( $guard)? block ) )
            // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:106:5: 'migrate' originalType= NAME ( 'to' migratedType= NAME )? ( 'when' guard= expressionOrStatementBlock )? '{' block '}'
            {
            string_literal8=(Token)match(input,120,FOLLOW_120_in_fullMigrationRule137); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_120.add(string_literal8);

            originalType=(Token)match(input,NAME,FOLLOW_NAME_in_fullMigrationRule141); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(originalType);

            // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:106:33: ( 'to' migratedType= NAME )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==121) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:106:34: 'to' migratedType= NAME
                    {
                    string_literal9=(Token)match(input,121,FOLLOW_121_in_fullMigrationRule144); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_121.add(string_literal9);

                    migratedType=(Token)match(input,NAME,FOLLOW_NAME_in_fullMigrationRule148); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NAME.add(migratedType);


                    }
                    break;

            }

            // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:106:59: ( 'when' guard= expressionOrStatementBlock )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==122) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:106:60: 'when' guard= expressionOrStatementBlock
                    {
                    string_literal10=(Token)match(input,122,FOLLOW_122_in_fullMigrationRule153); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_122.add(string_literal10);

                    pushFollow(FOLLOW_expressionOrStatementBlock_in_fullMigrationRule157);
                    guard=expressionOrStatementBlock();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expressionOrStatementBlock.add(guard.getTree());

                    }
                    break;

            }

            char_literal11=(Token)match(input,74,FOLLOW_74_in_fullMigrationRule161); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_74.add(char_literal11);

            pushFollow(FOLLOW_block_in_fullMigrationRule163);
            block12=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_block.add(block12.getTree());
            char_literal13=(Token)match(input,75,FOLLOW_75_in_fullMigrationRule165); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_75.add(char_literal13);



            // AST REWRITE
            // elements: originalType, block, guard, migratedType
            // token labels: migratedType, originalType
            // rule labels: retval, guard
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_migratedType=new RewriteRuleTokenStream(adaptor,"token migratedType",migratedType);
            RewriteRuleTokenStream stream_originalType=new RewriteRuleTokenStream(adaptor,"token originalType",originalType);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_guard=new RewriteRuleSubtreeStream(adaptor,"token guard",guard!=null?guard.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 107:5: -> ^( MIGRATE $originalType ( $migratedType)? ( $guard)? block )
            {
                // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:108:5: ^( MIGRATE $originalType ( $migratedType)? ( $guard)? block )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(MIGRATE, "MIGRATE"), root_1);

                adaptor.addChild(root_1, stream_originalType.nextNode());
                // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:108:29: ( $migratedType)?
                if ( stream_migratedType.hasNext() ) {
                    adaptor.addChild(root_1, stream_migratedType.nextNode());

                }
                stream_migratedType.reset();
                // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:108:44: ( $guard)?
                if ( stream_guard.hasNext() ) {
                    adaptor.addChild(root_1, stream_guard.nextTree());

                }
                stream_guard.reset();
                adaptor.addChild(root_1, stream_block.nextTree());

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
    // $ANTLR end fullMigrationRule

    public static class shorthandMigrationRule_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start shorthandMigrationRule
    // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:110:1: shorthandMigrationRule : 'migrate' originalType= NAME 'to' migratedType= NAME ( 'when' guard= expressionOrStatementBlock )? -> ^( MIGRATE $originalType $migratedType ( $guard)? BLOCK ) ;
    public final FlockParser.shorthandMigrationRule_return shorthandMigrationRule() throws RecognitionException {
        FlockParser.shorthandMigrationRule_return retval = new FlockParser.shorthandMigrationRule_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token originalType=null;
        Token migratedType=null;
        Token string_literal14=null;
        Token string_literal15=null;
        Token string_literal16=null;
        Flock_EolParserRules.expressionOrStatementBlock_return guard = null;


        CommonTree originalType_tree=null;
        CommonTree migratedType_tree=null;
        CommonTree string_literal14_tree=null;
        CommonTree string_literal15_tree=null;
        CommonTree string_literal16_tree=null;
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_121=new RewriteRuleTokenStream(adaptor,"token 121");
        RewriteRuleTokenStream stream_122=new RewriteRuleTokenStream(adaptor,"token 122");
        RewriteRuleTokenStream stream_120=new RewriteRuleTokenStream(adaptor,"token 120");
        RewriteRuleSubtreeStream stream_expressionOrStatementBlock=new RewriteRuleSubtreeStream(adaptor,"rule expressionOrStatementBlock");
        try {
            // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:111:3: ( 'migrate' originalType= NAME 'to' migratedType= NAME ( 'when' guard= expressionOrStatementBlock )? -> ^( MIGRATE $originalType $migratedType ( $guard)? BLOCK ) )
            // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:111:5: 'migrate' originalType= NAME 'to' migratedType= NAME ( 'when' guard= expressionOrStatementBlock )?
            {
            string_literal14=(Token)match(input,120,FOLLOW_120_in_shorthandMigrationRule204); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_120.add(string_literal14);

            originalType=(Token)match(input,NAME,FOLLOW_NAME_in_shorthandMigrationRule208); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(originalType);

            string_literal15=(Token)match(input,121,FOLLOW_121_in_shorthandMigrationRule210); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_121.add(string_literal15);

            migratedType=(Token)match(input,NAME,FOLLOW_NAME_in_shorthandMigrationRule214); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(migratedType);

            // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:111:56: ( 'when' guard= expressionOrStatementBlock )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==122) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:111:57: 'when' guard= expressionOrStatementBlock
                    {
                    string_literal16=(Token)match(input,122,FOLLOW_122_in_shorthandMigrationRule217); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_122.add(string_literal16);

                    pushFollow(FOLLOW_expressionOrStatementBlock_in_shorthandMigrationRule221);
                    guard=expressionOrStatementBlock();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expressionOrStatementBlock.add(guard.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: guard, migratedType, originalType
            // token labels: migratedType, originalType
            // rule labels: retval, guard
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_migratedType=new RewriteRuleTokenStream(adaptor,"token migratedType",migratedType);
            RewriteRuleTokenStream stream_originalType=new RewriteRuleTokenStream(adaptor,"token originalType",originalType);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_guard=new RewriteRuleSubtreeStream(adaptor,"token guard",guard!=null?guard.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 112:5: -> ^( MIGRATE $originalType $migratedType ( $guard)? BLOCK )
            {
                // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:113:5: ^( MIGRATE $originalType $migratedType ( $guard)? BLOCK )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(MIGRATE, "MIGRATE"), root_1);

                adaptor.addChild(root_1, stream_originalType.nextNode());
                adaptor.addChild(root_1, stream_migratedType.nextNode());
                // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:113:43: ( $guard)?
                if ( stream_guard.hasNext() ) {
                    adaptor.addChild(root_1, stream_guard.nextTree());

                }
                stream_guard.reset();
                adaptor.addChild(root_1, (CommonTree)adaptor.create(BLOCK, "BLOCK"));

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
    // $ANTLR end shorthandMigrationRule

    // $ANTLR start synpred4_Flock
    public final void synpred4_Flock_fragment() throws RecognitionException {   
        // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:103:5: ( fullMigrationRule )
        // /Users/louis/Code/eclipse/workspaces/galileo/workspace-epsilon/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:103:5: fullMigrationRule
        {
        pushFollow(FOLLOW_fullMigrationRule_in_synpred4_Flock121);
        fullMigrationRule();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred4_Flock

    // Delegated rules
    public Flock_EolParserRules.abortStatement_return abortStatement() throws RecognitionException { return gEolParserRules.abortStatement(); }
    public Flock_EolParserRules.modelDeclaration_return modelDeclaration() throws RecognitionException { return gEolParserRules.modelDeclaration(); }
    public Flock_EolParserRules.executableAnnotation_return executableAnnotation() throws RecognitionException { return gEolParserRules.executableAnnotation(); }
    public Flock_EolParserRules.deleteStatement_return deleteStatement() throws RecognitionException { return gEolParserRules.deleteStatement(); }
    public Flock_EolParserRules.formalParameter_return formalParameter() throws RecognitionException { return gEolParserRules.formalParameter(); }
    public Flock_EolParserRules.pathName_return pathName() throws RecognitionException { return gEolParserRules.pathName(); }
    public Flock_EolParserRules.typeName_return typeName() throws RecognitionException { return gEolParserRules.typeName(); }
    public Flock_EolParserRules.multiplicativeExpression_return multiplicativeExpression() throws RecognitionException { return gEolParserRules.multiplicativeExpression(); }
    public Flock_EolParserRules.continueStatement_return continueStatement() throws RecognitionException { return gEolParserRules.continueStatement(); }
    public Flock_EolParserRules.primitiveExpression_return primitiveExpression() throws RecognitionException { return gEolParserRules.primitiveExpression(); }
    public Flock_EolParserRules.transactionStatement_return transactionStatement() throws RecognitionException { return gEolParserRules.transactionStatement(); }
    public Flock_EolParserRules.statementA_return statementA() throws RecognitionException { return gEolParserRules.statementA(); }
    public Flock_EolParserRules.modelNamespace_return modelNamespace() throws RecognitionException { return gEolParserRules.modelNamespace(); }
    public Flock_EolParserRules.statementB_return statementB() throws RecognitionException { return gEolParserRules.statementB(); }
    public Flock_EolParserRules.breakAllStatement_return breakAllStatement() throws RecognitionException { return gEolParserRules.breakAllStatement(); }
    public Flock_EolParserRules.breakStatement_return breakStatement() throws RecognitionException { return gEolParserRules.breakStatement(); }
    public Flock_EolParserRules.modelAlias_return modelAlias() throws RecognitionException { return gEolParserRules.modelAlias(); }
    public Flock_EolParserRules.additiveExpression_return additiveExpression() throws RecognitionException { return gEolParserRules.additiveExpression(); }
    public Flock_EolParserRules.nativeType_return nativeType() throws RecognitionException { return gEolParserRules.nativeType(); }
    public Flock_EolParserRules.formalParameterList_return formalParameterList() throws RecognitionException { return gEolParserRules.formalParameterList(); }
    public Flock_EolParserRules.parameterList_return parameterList() throws RecognitionException { return gEolParserRules.parameterList(); }
    public Flock_EolParserRules.modelElementType_return modelElementType() throws RecognitionException { return gEolParserRules.modelElementType(); }
    public Flock_EolParserRules.newExpression_return newExpression() throws RecognitionException { return gEolParserRules.newExpression(); }
    public Flock_EolParserRules.literal_return literal() throws RecognitionException { return gEolParserRules.literal(); }
    public Flock_EolParserRules.statement_return statement() throws RecognitionException { return gEolParserRules.statement(); }
    public Flock_EolParserRules.logicalExpression_return logicalExpression() throws RecognitionException { return gEolParserRules.logicalExpression(); }
    public Flock_EolParserRules.litteralCollection_return litteralCollection() throws RecognitionException { return gEolParserRules.litteralCollection(); }
    public Flock_EolParserRules.statementBlock_return statementBlock() throws RecognitionException { return gEolParserRules.statementBlock(); }
    public Flock_EolParserRules.unaryExpression_return unaryExpression() throws RecognitionException { return gEolParserRules.unaryExpression(); }
    public Flock_EolParserRules.simpleFeatureCall_return simpleFeatureCall() throws RecognitionException { return gEolParserRules.simpleFeatureCall(); }
    public Flock_EolParserRules.variableDeclarationExpression_return variableDeclarationExpression() throws RecognitionException { return gEolParserRules.variableDeclarationExpression(); }
    public Flock_EolParserRules.collectionType_return collectionType() throws RecognitionException { return gEolParserRules.collectionType(); }
    public Flock_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock() throws RecognitionException { return gEolParserRules.statementOrStatementBlock(); }
    public Flock_EolParserRules.expressionRange_return expressionRange() throws RecognitionException { return gEolParserRules.expressionRange(); }
    public Flock_EolParserRules.throwStatement_return throwStatement() throws RecognitionException { return gEolParserRules.throwStatement(); }
    public Flock_EolParserRules.whileStatement_return whileStatement() throws RecognitionException { return gEolParserRules.whileStatement(); }
    public Flock_EolParserRules.importStatement_return importStatement() throws RecognitionException { return gEolParserRules.importStatement(); }
    public Flock_EolParserRules.assignmentStatement_return assignmentStatement() throws RecognitionException { return gEolParserRules.assignmentStatement(); }
    public Flock_EolParserRules.operationDeclarationOrAnnotationBlock_return operationDeclarationOrAnnotationBlock() throws RecognitionException { return gEolParserRules.operationDeclarationOrAnnotationBlock(); }
    public Flock_EolParserRules.declarativeFeatureCall_return declarativeFeatureCall() throws RecognitionException { return gEolParserRules.declarativeFeatureCall(); }
    public Flock_EolParserRules.elseStatement_return elseStatement() throws RecognitionException { return gEolParserRules.elseStatement(); }
    public Flock_EolParserRules.returnStatement_return returnStatement() throws RecognitionException { return gEolParserRules.returnStatement(); }
    public Flock_EolParserRules.expressionList_return expressionList() throws RecognitionException { return gEolParserRules.expressionList(); }
    public Flock_EolParserRules.operationDeclaration_return operationDeclaration() throws RecognitionException { return gEolParserRules.operationDeclaration(); }
    public Flock_EolParserRules.ifStatement_return ifStatement() throws RecognitionException { return gEolParserRules.ifStatement(); }
    public Flock_EolParserRules.expressionListOrRange_return expressionListOrRange() throws RecognitionException { return gEolParserRules.expressionListOrRange(); }
    public Flock_EolParserRules.postfixExpression_return postfixExpression() throws RecognitionException { return gEolParserRules.postfixExpression(); }
    public Flock_EolParserRules.annotationBlock_return annotationBlock() throws RecognitionException { return gEolParserRules.annotationBlock(); }
    public Flock_EolParserRules.forStatement_return forStatement() throws RecognitionException { return gEolParserRules.forStatement(); }
    public Flock_EolParserRules.block_return block() throws RecognitionException { return gEolParserRules.block(); }
    public Flock_EolParserRules.featureCall_return featureCall() throws RecognitionException { return gEolParserRules.featureCall(); }
    public Flock_EolParserRules.relationalExpression_return relationalExpression() throws RecognitionException { return gEolParserRules.relationalExpression(); }
    public Flock_EolParserRules.expressionOrStatementBlock_return expressionOrStatementBlock() throws RecognitionException { return gEolParserRules.expressionOrStatementBlock(); }
    public Flock_EolParserRules.expressionStatement_return expressionStatement() throws RecognitionException { return gEolParserRules.expressionStatement(); }
    public Flock_EolParserRules.annotation_return annotation() throws RecognitionException { return gEolParserRules.annotation(); }

    public final boolean synpred4_Flock() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_Flock_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_importStatement_in_flockModule73 = new BitSet(new long[]{0x0000000000100000L,0x0100000000001240L});
    public static final BitSet FOLLOW_flockModuleContent_in_flockModule77 = new BitSet(new long[]{0x0000000000100000L,0x0100000000001040L});
    public static final BitSet FOLLOW_EOF_in_flockModule81 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_migrationRule_in_flockModuleContent105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_operationDeclarationOrAnnotationBlock_in_flockModuleContent109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fullMigrationRule_in_migrationRule121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_shorthandMigrationRule_in_migrationRule125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_120_in_fullMigrationRule137 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NAME_in_fullMigrationRule141 = new BitSet(new long[]{0x0000000000000000L,0x0600000000000400L});
    public static final BitSet FOLLOW_121_in_fullMigrationRule144 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NAME_in_fullMigrationRule148 = new BitSet(new long[]{0x0000000000000000L,0x0400000000000400L});
    public static final BitSet FOLLOW_122_in_fullMigrationRule153 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000408L});
    public static final BitSet FOLLOW_expressionOrStatementBlock_in_fullMigrationRule157 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_74_in_fullMigrationRule161 = new BitSet(new long[]{0x0000000000011450L,0x00D20007FD7F0880L});
    public static final BitSet FOLLOW_block_in_fullMigrationRule163 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_fullMigrationRule165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_120_in_shorthandMigrationRule204 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NAME_in_shorthandMigrationRule208 = new BitSet(new long[]{0x0000000000000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_121_in_shorthandMigrationRule210 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NAME_in_shorthandMigrationRule214 = new BitSet(new long[]{0x0000000000000002L,0x0400000000000000L});
    public static final BitSet FOLLOW_122_in_shorthandMigrationRule217 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000408L});
    public static final BitSet FOLLOW_expressionOrStatementBlock_in_shorthandMigrationRule221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fullMigrationRule_in_synpred4_Flock121 = new BitSet(new long[]{0x0000000000000002L});

}