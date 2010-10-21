// $ANTLR 3.1b1 D:\\Projects\\Eclipse\\3.5.1\\workspace\\org.eclipse.epsilon.flock.engine\\src\\org\\eclipse\\epsilon\\flock\\parse\\Flock.g 2010-10-19 13:28:58

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "FLOAT", "DIGIT", "INT", "POINT", "POINT_POINT", "ARROW", "BOOLEAN", "EscapeSequence", "STRING", "StrangeNameLiteral", "Letter", "SpecialNameChar", "JavaIDDigit", "NAME", "WS", "COMMENT", "LINE_COMMENT", "Annotation", "FORMAL", "PARAMLIST", "ASSIGNMENT", "SPECIAL_ASSIGNMENT", "HELPERMETHOD", "StatementBlock", "FOR", "IF", "ELSE", "WHILE", "SWITCH", "CASE", "DEFAULT", "RETURN", "BREAK", "BREAKALL", "CONTINUE", "TRANSACTION", "COLLECTION", "ABORT", "CollectionType", "ModelElementType", "PARAMETERS", "NewExpression", "VAR", "NEW", "ANNOTATIONBLOCK", "EXECUTABLEANNOTATION", "DELETE", "THROW", "EXPRLIST", "EXPRRANGE", "NativeType", "MultiplicativeExpression", "OPERATOR", "FeatureCall", "EOLMODULE", "BLOCK", "FEATURECALL", "TYPE", "ENUMERATION_VALUE", "IMPORT", "MODELDECLARATION", "NAMESPACE", "ALIAS", "DRIVER", "MODELDECLARATIONPARAMETERS", "MODELDECLARATIONPARAMETER", "ITEMSELECTOR", "FLOCKMODULE", "MIGRATE", "GUARD", "'model'", "';'", "':'", "','", "'alias'", "'driver'", "'{'", "'}'", "'='", "'operation'", "'function'", "'('", "')'", "'import'", "'$'", "'!'", "'::'", "'#'", "'Native'", "'Collection'", "'Sequence'", "'List'", "'Bag'", "'Set'", "'OrderedSet'", "'for'", "'in'", "'if'", "'switch'", "'case'", "'default'", "'else'", "'while'", "'return'", "'throw'", "'delete'", "'break'", "'breakAll'", "'continue'", "'abort'", "'transaction'", "':='", "'::='", "'or'", "'and'", "'xor'", "'implies'", "'=='", "'>'", "'<'", "'>='", "'<='", "'<>'", "'+'", "'-'", "'*'", "'/'", "'not'", "'['", "']'", "'|'", "'new'", "'var'", "'migrate'", "'to'", "'when'"
    };
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
    public static final int T__84=84;
    public static final int T__87=87;
    public static final int HELPERMETHOD=26;
    public static final int T__86=86;
    public static final int T__89=89;
    public static final int NAMESPACE=65;
    public static final int T__88=88;
    public static final int CollectionType=42;
    public static final int T__126=126;
    public static final int T__125=125;
    public static final int T__128=128;
    public static final int T__127=127;
    public static final int WS=18;
    public static final int T__129=129;
    public static final int ALIAS=66;
    public static final int MIGRATE=72;
    public static final int JavaIDDigit=16;
    public static final int GUARD=73;
    public static final int Annotation=21;
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int T__74=74;
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
    public String getGrammarFileName() { return "D:\\Projects\\Eclipse\\3.5.1\\workspace\\org.eclipse.epsilon.flock.engine\\src\\org\\eclipse\\epsilon\\flock\\parse\\Flock.g"; }


    public static class flockModule_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start flockModule
    // D:\\Projects\\Eclipse\\3.5.1\\workspace\\org.eclipse.epsilon.flock.engine\\src\\org\\eclipse\\epsilon\\flock\\parse\\Flock.g:93:1: flockModule : ( importStatement )* ( flockModuleContent )* EOF -> ^( FLOCKMODULE ( importStatement )* ( flockModuleContent )* ) ;
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
            // D:\\Projects\\Eclipse\\3.5.1\\workspace\\org.eclipse.epsilon.flock.engine\\src\\org\\eclipse\\epsilon\\flock\\parse\\Flock.g:94:2: ( ( importStatement )* ( flockModuleContent )* EOF -> ^( FLOCKMODULE ( importStatement )* ( flockModuleContent )* ) )
            // D:\\Projects\\Eclipse\\3.5.1\\workspace\\org.eclipse.epsilon.flock.engine\\src\\org\\eclipse\\epsilon\\flock\\parse\\Flock.g:94:4: ( importStatement )* ( flockModuleContent )* EOF
            {
            // D:\\Projects\\Eclipse\\3.5.1\\workspace\\org.eclipse.epsilon.flock.engine\\src\\org\\eclipse\\epsilon\\flock\\parse\\Flock.g:94:4: ( importStatement )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==87) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // D:\\Projects\\Eclipse\\3.5.1\\workspace\\org.eclipse.epsilon.flock.engine\\src\\org\\eclipse\\epsilon\\flock\\parse\\Flock.g:0:0: importStatement
            	    {
            	    pushFollow(FOLLOW_importStatement_in_flockModule79);
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

            // D:\\Projects\\Eclipse\\3.5.1\\workspace\\org.eclipse.epsilon.flock.engine\\src\\org\\eclipse\\epsilon\\flock\\parse\\Flock.g:94:21: ( flockModuleContent )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==Annotation||(LA2_0>=83 && LA2_0<=84)||LA2_0==88||LA2_0==109||LA2_0==137) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // D:\\Projects\\Eclipse\\3.5.1\\workspace\\org.eclipse.epsilon.flock.engine\\src\\org\\eclipse\\epsilon\\flock\\parse\\Flock.g:94:22: flockModuleContent
            	    {
            	    pushFollow(FOLLOW_flockModuleContent_in_flockModule83);
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

            EOF3=(Token)match(input,EOF,FOLLOW_EOF_in_flockModule87); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EOF.add(EOF3);



            // AST REWRITE
            // elements: importStatement, flockModuleContent
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
                // D:\\Projects\\Eclipse\\3.5.1\\workspace\\org.eclipse.epsilon.flock.engine\\src\\org\\eclipse\\epsilon\\flock\\parse\\Flock.g:95:5: ^( FLOCKMODULE ( importStatement )* ( flockModuleContent )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FLOCKMODULE, "FLOCKMODULE"), root_1);

                // D:\\Projects\\Eclipse\\3.5.1\\workspace\\org.eclipse.epsilon.flock.engine\\src\\org\\eclipse\\epsilon\\flock\\parse\\Flock.g:95:19: ( importStatement )*
                while ( stream_importStatement.hasNext() ) {
                    adaptor.addChild(root_1, stream_importStatement.nextTree());

                }
                stream_importStatement.reset();
                // D:\\Projects\\Eclipse\\3.5.1\\workspace\\org.eclipse.epsilon.flock.engine\\src\\org\\eclipse\\epsilon\\flock\\parse\\Flock.g:95:36: ( flockModuleContent )*
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
    // D:\\Projects\\Eclipse\\3.5.1\\workspace\\org.eclipse.epsilon.flock.engine\\src\\org\\eclipse\\epsilon\\flock\\parse\\Flock.g:98:1: flockModuleContent : ( rule | operationDeclarationOrAnnotationBlock );
    public final FlockParser.flockModuleContent_return flockModuleContent() throws RecognitionException {
        FlockParser.flockModuleContent_return retval = new FlockParser.flockModuleContent_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        FlockParser.rule_return rule4 = null;

        Flock_EolParserRules.operationDeclarationOrAnnotationBlock_return operationDeclarationOrAnnotationBlock5 = null;



        try {
            // D:\\Projects\\Eclipse\\3.5.1\\workspace\\org.eclipse.epsilon.flock.engine\\src\\org\\eclipse\\epsilon\\flock\\parse\\Flock.g:99:2: ( rule | operationDeclarationOrAnnotationBlock )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==109||LA3_0==137) ) {
                alt3=1;
            }
            else if ( (LA3_0==Annotation||(LA3_0>=83 && LA3_0<=84)||LA3_0==88) ) {
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
                    // D:\\Projects\\Eclipse\\3.5.1\\workspace\\org.eclipse.epsilon.flock.engine\\src\\org\\eclipse\\epsilon\\flock\\parse\\Flock.g:99:4: rule
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_rule_in_flockModuleContent111);
                    rule4=rule();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, rule4.getTree());

                    }
                    break;
                case 2 :
                    // D:\\Projects\\Eclipse\\3.5.1\\workspace\\org.eclipse.epsilon.flock.engine\\src\\org\\eclipse\\epsilon\\flock\\parse\\Flock.g:99:11: operationDeclarationOrAnnotationBlock
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_operationDeclarationOrAnnotationBlock_in_flockModuleContent115);
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

    public static class rule_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start rule
    // D:\\Projects\\Eclipse\\3.5.1\\workspace\\org.eclipse.epsilon.flock.engine\\src\\org\\eclipse\\epsilon\\flock\\parse\\Flock.g:102:1: rule : ( migrateRule | deleteRule );
    public final FlockParser.rule_return rule() throws RecognitionException {
        FlockParser.rule_return retval = new FlockParser.rule_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        FlockParser.migrateRule_return migrateRule6 = null;

        FlockParser.deleteRule_return deleteRule7 = null;



        try {
            // D:\\Projects\\Eclipse\\3.5.1\\workspace\\org.eclipse.epsilon.flock.engine\\src\\org\\eclipse\\epsilon\\flock\\parse\\Flock.g:103:3: ( migrateRule | deleteRule )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==137) ) {
                alt4=1;
            }
            else if ( (LA4_0==109) ) {
                alt4=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // D:\\Projects\\Eclipse\\3.5.1\\workspace\\org.eclipse.epsilon.flock.engine\\src\\org\\eclipse\\epsilon\\flock\\parse\\Flock.g:103:5: migrateRule
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_migrateRule_in_rule127);
                    migrateRule6=migrateRule();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, migrateRule6.getTree());

                    }
                    break;
                case 2 :
                    // D:\\Projects\\Eclipse\\3.5.1\\workspace\\org.eclipse.epsilon.flock.engine\\src\\org\\eclipse\\epsilon\\flock\\parse\\Flock.g:103:19: deleteRule
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_deleteRule_in_rule131);
                    deleteRule7=deleteRule();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, deleteRule7.getTree());

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
    // $ANTLR end rule

    public static class migrateRule_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start migrateRule
    // D:\\Projects\\Eclipse\\3.5.1\\workspace\\org.eclipse.epsilon.flock.engine\\src\\org\\eclipse\\epsilon\\flock\\parse\\Flock.g:106:1: migrateRule : ( fullMigrateRule | shorthandMigrateRule );
    public final FlockParser.migrateRule_return migrateRule() throws RecognitionException {
        FlockParser.migrateRule_return retval = new FlockParser.migrateRule_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        FlockParser.fullMigrateRule_return fullMigrateRule8 = null;

        FlockParser.shorthandMigrateRule_return shorthandMigrateRule9 = null;



        try {
            // D:\\Projects\\Eclipse\\3.5.1\\workspace\\org.eclipse.epsilon.flock.engine\\src\\org\\eclipse\\epsilon\\flock\\parse\\Flock.g:107:3: ( fullMigrateRule | shorthandMigrateRule )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==137) ) {
                int LA5_1 = input.LA(2);

                if ( (synpred5_Flock()) ) {
                    alt5=1;
                }
                else if ( (true) ) {
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
                    // D:\\Projects\\Eclipse\\3.5.1\\workspace\\org.eclipse.epsilon.flock.engine\\src\\org\\eclipse\\epsilon\\flock\\parse\\Flock.g:107:5: fullMigrateRule
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_fullMigrateRule_in_migrateRule142);
                    fullMigrateRule8=fullMigrateRule();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, fullMigrateRule8.getTree());

                    }
                    break;
                case 2 :
                    // D:\\Projects\\Eclipse\\3.5.1\\workspace\\org.eclipse.epsilon.flock.engine\\src\\org\\eclipse\\epsilon\\flock\\parse\\Flock.g:107:23: shorthandMigrateRule
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_shorthandMigrateRule_in_migrateRule146);
                    shorthandMigrateRule9=shorthandMigrateRule();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, shorthandMigrateRule9.getTree());

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

    public static class fullMigrateRule_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start fullMigrateRule
    // D:\\Projects\\Eclipse\\3.5.1\\workspace\\org.eclipse.epsilon.flock.engine\\src\\org\\eclipse\\epsilon\\flock\\parse\\Flock.g:109:1: fullMigrateRule : 'migrate' originalType= NAME ( 'to' migratedType= NAME )? ( guard )? '{' body= block '}' -> ^( MIGRATE $originalType ( $migratedType)? ( guard )? $body) ;
    public final FlockParser.fullMigrateRule_return fullMigrateRule() throws RecognitionException {
        FlockParser.fullMigrateRule_return retval = new FlockParser.fullMigrateRule_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token originalType=null;
        Token migratedType=null;
        Token string_literal10=null;
        Token string_literal11=null;
        Token char_literal13=null;
        Token char_literal14=null;
        Flock_EolParserRules.block_return body = null;

        FlockParser.guard_return guard12 = null;


        CommonTree originalType_tree=null;
        CommonTree migratedType_tree=null;
        CommonTree string_literal10_tree=null;
        CommonTree string_literal11_tree=null;
        CommonTree char_literal13_tree=null;
        CommonTree char_literal14_tree=null;
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_138=new RewriteRuleTokenStream(adaptor,"token 138");
        RewriteRuleTokenStream stream_137=new RewriteRuleTokenStream(adaptor,"token 137");
        RewriteRuleTokenStream stream_80=new RewriteRuleTokenStream(adaptor,"token 80");
        RewriteRuleTokenStream stream_81=new RewriteRuleTokenStream(adaptor,"token 81");
        RewriteRuleSubtreeStream stream_guard=new RewriteRuleSubtreeStream(adaptor,"rule guard");
        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        try {
            // D:\\Projects\\Eclipse\\3.5.1\\workspace\\org.eclipse.epsilon.flock.engine\\src\\org\\eclipse\\epsilon\\flock\\parse\\Flock.g:110:3: ( 'migrate' originalType= NAME ( 'to' migratedType= NAME )? ( guard )? '{' body= block '}' -> ^( MIGRATE $originalType ( $migratedType)? ( guard )? $body) )
            // D:\\Projects\\Eclipse\\3.5.1\\workspace\\org.eclipse.epsilon.flock.engine\\src\\org\\eclipse\\epsilon\\flock\\parse\\Flock.g:110:5: 'migrate' originalType= NAME ( 'to' migratedType= NAME )? ( guard )? '{' body= block '}'
            {
            string_literal10=(Token)match(input,137,FOLLOW_137_in_fullMigrateRule156); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_137.add(string_literal10);

            originalType=(Token)match(input,NAME,FOLLOW_NAME_in_fullMigrateRule160); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(originalType);

            // D:\\Projects\\Eclipse\\3.5.1\\workspace\\org.eclipse.epsilon.flock.engine\\src\\org\\eclipse\\epsilon\\flock\\parse\\Flock.g:110:33: ( 'to' migratedType= NAME )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==138) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // D:\\Projects\\Eclipse\\3.5.1\\workspace\\org.eclipse.epsilon.flock.engine\\src\\org\\eclipse\\epsilon\\flock\\parse\\Flock.g:110:34: 'to' migratedType= NAME
                    {
                    string_literal11=(Token)match(input,138,FOLLOW_138_in_fullMigrateRule163); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_138.add(string_literal11);

                    migratedType=(Token)match(input,NAME,FOLLOW_NAME_in_fullMigrateRule167); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NAME.add(migratedType);


                    }
                    break;

            }

            // D:\\Projects\\Eclipse\\3.5.1\\workspace\\org.eclipse.epsilon.flock.engine\\src\\org\\eclipse\\epsilon\\flock\\parse\\Flock.g:110:59: ( guard )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==139) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // D:\\Projects\\Eclipse\\3.5.1\\workspace\\org.eclipse.epsilon.flock.engine\\src\\org\\eclipse\\epsilon\\flock\\parse\\Flock.g:0:0: guard
                    {
                    pushFollow(FOLLOW_guard_in_fullMigrateRule171);
                    guard12=guard();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_guard.add(guard12.getTree());

                    }
                    break;

            }

            char_literal13=(Token)match(input,80,FOLLOW_80_in_fullMigrateRule174); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_80.add(char_literal13);

            pushFollow(FOLLOW_block_in_fullMigrateRule178);
            body=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_block.add(body.getTree());
            char_literal14=(Token)match(input,81,FOLLOW_81_in_fullMigrateRule180); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_81.add(char_literal14);



            // AST REWRITE
            // elements: originalType, body, migratedType, guard
            // token labels: migratedType, originalType
            // rule labels: body, retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_migratedType=new RewriteRuleTokenStream(adaptor,"token migratedType",migratedType);
            RewriteRuleTokenStream stream_originalType=new RewriteRuleTokenStream(adaptor,"token originalType",originalType);
            RewriteRuleSubtreeStream stream_body=new RewriteRuleSubtreeStream(adaptor,"token body",body!=null?body.tree:null);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 111:5: -> ^( MIGRATE $originalType ( $migratedType)? ( guard )? $body)
            {
                // D:\\Projects\\Eclipse\\3.5.1\\workspace\\org.eclipse.epsilon.flock.engine\\src\\org\\eclipse\\epsilon\\flock\\parse\\Flock.g:112:5: ^( MIGRATE $originalType ( $migratedType)? ( guard )? $body)
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(MIGRATE, "MIGRATE"), root_1);

                adaptor.addChild(root_1, stream_originalType.nextNode());
                // D:\\Projects\\Eclipse\\3.5.1\\workspace\\org.eclipse.epsilon.flock.engine\\src\\org\\eclipse\\epsilon\\flock\\parse\\Flock.g:112:29: ( $migratedType)?
                if ( stream_migratedType.hasNext() ) {
                    adaptor.addChild(root_1, stream_migratedType.nextNode());

                }
                stream_migratedType.reset();
                // D:\\Projects\\Eclipse\\3.5.1\\workspace\\org.eclipse.epsilon.flock.engine\\src\\org\\eclipse\\epsilon\\flock\\parse\\Flock.g:112:44: ( guard )?
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
    // $ANTLR end fullMigrateRule

    public static class shorthandMigrateRule_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start shorthandMigrateRule
    // D:\\Projects\\Eclipse\\3.5.1\\workspace\\org.eclipse.epsilon.flock.engine\\src\\org\\eclipse\\epsilon\\flock\\parse\\Flock.g:114:1: shorthandMigrateRule : 'migrate' originalType= NAME 'to' migratedType= NAME ( guard )? -> ^( MIGRATE $originalType ( $migratedType)? ( guard )? ) ;
    public final FlockParser.shorthandMigrateRule_return shorthandMigrateRule() throws RecognitionException {
        FlockParser.shorthandMigrateRule_return retval = new FlockParser.shorthandMigrateRule_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token originalType=null;
        Token migratedType=null;
        Token string_literal15=null;
        Token string_literal16=null;
        FlockParser.guard_return guard17 = null;


        CommonTree originalType_tree=null;
        CommonTree migratedType_tree=null;
        CommonTree string_literal15_tree=null;
        CommonTree string_literal16_tree=null;
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_138=new RewriteRuleTokenStream(adaptor,"token 138");
        RewriteRuleTokenStream stream_137=new RewriteRuleTokenStream(adaptor,"token 137");
        RewriteRuleSubtreeStream stream_guard=new RewriteRuleSubtreeStream(adaptor,"rule guard");
        try {
            // D:\\Projects\\Eclipse\\3.5.1\\workspace\\org.eclipse.epsilon.flock.engine\\src\\org\\eclipse\\epsilon\\flock\\parse\\Flock.g:115:3: ( 'migrate' originalType= NAME 'to' migratedType= NAME ( guard )? -> ^( MIGRATE $originalType ( $migratedType)? ( guard )? ) )
            // D:\\Projects\\Eclipse\\3.5.1\\workspace\\org.eclipse.epsilon.flock.engine\\src\\org\\eclipse\\epsilon\\flock\\parse\\Flock.g:115:5: 'migrate' originalType= NAME 'to' migratedType= NAME ( guard )?
            {
            string_literal15=(Token)match(input,137,FOLLOW_137_in_shorthandMigrateRule220); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_137.add(string_literal15);

            originalType=(Token)match(input,NAME,FOLLOW_NAME_in_shorthandMigrateRule224); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(originalType);

            string_literal16=(Token)match(input,138,FOLLOW_138_in_shorthandMigrateRule226); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_138.add(string_literal16);

            migratedType=(Token)match(input,NAME,FOLLOW_NAME_in_shorthandMigrateRule230); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(migratedType);

            // D:\\Projects\\Eclipse\\3.5.1\\workspace\\org.eclipse.epsilon.flock.engine\\src\\org\\eclipse\\epsilon\\flock\\parse\\Flock.g:115:56: ( guard )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==139) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // D:\\Projects\\Eclipse\\3.5.1\\workspace\\org.eclipse.epsilon.flock.engine\\src\\org\\eclipse\\epsilon\\flock\\parse\\Flock.g:0:0: guard
                    {
                    pushFollow(FOLLOW_guard_in_shorthandMigrateRule232);
                    guard17=guard();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_guard.add(guard17.getTree());

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
            // 116:5: -> ^( MIGRATE $originalType ( $migratedType)? ( guard )? )
            {
                // D:\\Projects\\Eclipse\\3.5.1\\workspace\\org.eclipse.epsilon.flock.engine\\src\\org\\eclipse\\epsilon\\flock\\parse\\Flock.g:117:5: ^( MIGRATE $originalType ( $migratedType)? ( guard )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(MIGRATE, "MIGRATE"), root_1);

                adaptor.addChild(root_1, stream_originalType.nextNode());
                // D:\\Projects\\Eclipse\\3.5.1\\workspace\\org.eclipse.epsilon.flock.engine\\src\\org\\eclipse\\epsilon\\flock\\parse\\Flock.g:117:29: ( $migratedType)?
                if ( stream_migratedType.hasNext() ) {
                    adaptor.addChild(root_1, stream_migratedType.nextNode());

                }
                stream_migratedType.reset();
                // D:\\Projects\\Eclipse\\3.5.1\\workspace\\org.eclipse.epsilon.flock.engine\\src\\org\\eclipse\\epsilon\\flock\\parse\\Flock.g:117:44: ( guard )?
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
    // $ANTLR end shorthandMigrateRule

    public static class guard_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start guard
    // D:\\Projects\\Eclipse\\3.5.1\\workspace\\org.eclipse.epsilon.flock.engine\\src\\org\\eclipse\\epsilon\\flock\\parse\\Flock.g:119:1: guard : 'when' expressionOrStatementBlock -> ^( GUARD expressionOrStatementBlock ) ;
    public final FlockParser.guard_return guard() throws RecognitionException {
        FlockParser.guard_return retval = new FlockParser.guard_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal18=null;
        Flock_EolParserRules.expressionOrStatementBlock_return expressionOrStatementBlock19 = null;


        CommonTree string_literal18_tree=null;
        RewriteRuleTokenStream stream_139=new RewriteRuleTokenStream(adaptor,"token 139");
        RewriteRuleSubtreeStream stream_expressionOrStatementBlock=new RewriteRuleSubtreeStream(adaptor,"rule expressionOrStatementBlock");
        try {
            // D:\\Projects\\Eclipse\\3.5.1\\workspace\\org.eclipse.epsilon.flock.engine\\src\\org\\eclipse\\epsilon\\flock\\parse\\Flock.g:120:3: ( 'when' expressionOrStatementBlock -> ^( GUARD expressionOrStatementBlock ) )
            // D:\\Projects\\Eclipse\\3.5.1\\workspace\\org.eclipse.epsilon.flock.engine\\src\\org\\eclipse\\epsilon\\flock\\parse\\Flock.g:120:5: 'when' expressionOrStatementBlock
            {
            string_literal18=(Token)match(input,139,FOLLOW_139_in_guard268); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_139.add(string_literal18);

            pushFollow(FOLLOW_expressionOrStatementBlock_in_guard270);
            expressionOrStatementBlock19=expressionOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expressionOrStatementBlock.add(expressionOrStatementBlock19.getTree());


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
            // 121:5: -> ^( GUARD expressionOrStatementBlock )
            {
                // D:\\Projects\\Eclipse\\3.5.1\\workspace\\org.eclipse.epsilon.flock.engine\\src\\org\\eclipse\\epsilon\\flock\\parse\\Flock.g:122:5: ^( GUARD expressionOrStatementBlock )
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

    public static class deleteRule_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start deleteRule
    // D:\\Projects\\Eclipse\\3.5.1\\workspace\\org.eclipse.epsilon.flock.engine\\src\\org\\eclipse\\epsilon\\flock\\parse\\Flock.g:125:2: deleteRule : 'delete' type= NAME ( guard )? -> ^( DELETE $type ( guard )? ) ;
    public final FlockParser.deleteRule_return deleteRule() throws RecognitionException {
        FlockParser.deleteRule_return retval = new FlockParser.deleteRule_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token type=null;
        Token string_literal20=null;
        FlockParser.guard_return guard21 = null;


        CommonTree type_tree=null;
        CommonTree string_literal20_tree=null;
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_109=new RewriteRuleTokenStream(adaptor,"token 109");
        RewriteRuleSubtreeStream stream_guard=new RewriteRuleSubtreeStream(adaptor,"rule guard");
        try {
            // D:\\Projects\\Eclipse\\3.5.1\\workspace\\org.eclipse.epsilon.flock.engine\\src\\org\\eclipse\\epsilon\\flock\\parse\\Flock.g:126:3: ( 'delete' type= NAME ( guard )? -> ^( DELETE $type ( guard )? ) )
            // D:\\Projects\\Eclipse\\3.5.1\\workspace\\org.eclipse.epsilon.flock.engine\\src\\org\\eclipse\\epsilon\\flock\\parse\\Flock.g:126:5: 'delete' type= NAME ( guard )?
            {
            string_literal20=(Token)match(input,109,FOLLOW_109_in_deleteRule299); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_109.add(string_literal20);

            type=(Token)match(input,NAME,FOLLOW_NAME_in_deleteRule303); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(type);

            // D:\\Projects\\Eclipse\\3.5.1\\workspace\\org.eclipse.epsilon.flock.engine\\src\\org\\eclipse\\epsilon\\flock\\parse\\Flock.g:126:24: ( guard )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==139) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // D:\\Projects\\Eclipse\\3.5.1\\workspace\\org.eclipse.epsilon.flock.engine\\src\\org\\eclipse\\epsilon\\flock\\parse\\Flock.g:0:0: guard
                    {
                    pushFollow(FOLLOW_guard_in_deleteRule305);
                    guard21=guard();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_guard.add(guard21.getTree());

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
            // 127:6: -> ^( DELETE $type ( guard )? )
            {
                // D:\\Projects\\Eclipse\\3.5.1\\workspace\\org.eclipse.epsilon.flock.engine\\src\\org\\eclipse\\epsilon\\flock\\parse\\Flock.g:128:8: ^( DELETE $type ( guard )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(DELETE, "DELETE"), root_1);

                adaptor.addChild(root_1, stream_type.nextNode());
                // D:\\Projects\\Eclipse\\3.5.1\\workspace\\org.eclipse.epsilon.flock.engine\\src\\org\\eclipse\\epsilon\\flock\\parse\\Flock.g:128:23: ( guard )?
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
    // $ANTLR end deleteRule

    // $ANTLR start synpred5_Flock
    public final void synpred5_Flock_fragment() throws RecognitionException {   
        // D:\\Projects\\Eclipse\\3.5.1\\workspace\\org.eclipse.epsilon.flock.engine\\src\\org\\eclipse\\epsilon\\flock\\parse\\Flock.g:107:5: ( fullMigrateRule )
        // D:\\Projects\\Eclipse\\3.5.1\\workspace\\org.eclipse.epsilon.flock.engine\\src\\org\\eclipse\\epsilon\\flock\\parse\\Flock.g:107:5: fullMigrateRule
        {
        pushFollow(FOLLOW_fullMigrateRule_in_synpred5_Flock142);
        fullMigrateRule();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred5_Flock

    // Delegated rules
    public Flock_EolParserRules.statementB_return statementB() throws RecognitionException { return gEolParserRules.statementB(); }
    public Flock_EolParserRules.transactionStatement_return transactionStatement() throws RecognitionException { return gEolParserRules.transactionStatement(); }
    public Flock_EolParserRules.breakStatement_return breakStatement() throws RecognitionException { return gEolParserRules.breakStatement(); }
    public Flock_EolParserRules.modelDeclaration_return modelDeclaration() throws RecognitionException { return gEolParserRules.modelDeclaration(); }
    public Flock_EolParserRules.abortStatement_return abortStatement() throws RecognitionException { return gEolParserRules.abortStatement(); }
    public Flock_EolParserRules.expressionListOrRange_return expressionListOrRange() throws RecognitionException { return gEolParserRules.expressionListOrRange(); }
    public Flock_EolParserRules.statementA_return statementA() throws RecognitionException { return gEolParserRules.statementA(); }
    public Flock_EolParserRules.additiveExpression_return additiveExpression() throws RecognitionException { return gEolParserRules.additiveExpression(); }
    public Flock_EolParserRules.switchStatement_return switchStatement() throws RecognitionException { return gEolParserRules.switchStatement(); }
    public Flock_EolParserRules.operationDeclarationOrAnnotationBlock_return operationDeclarationOrAnnotationBlock() throws RecognitionException { return gEolParserRules.operationDeclarationOrAnnotationBlock(); }
    public Flock_EolParserRules.expressionList_return expressionList() throws RecognitionException { return gEolParserRules.expressionList(); }
    public Flock_EolParserRules.block_return block() throws RecognitionException { return gEolParserRules.block(); }
    public Flock_EolParserRules.postfixExpression_return postfixExpression() throws RecognitionException { return gEolParserRules.postfixExpression(); }
    public Flock_EolParserRules.whileStatement_return whileStatement() throws RecognitionException { return gEolParserRules.whileStatement(); }
    public Flock_EolParserRules.formalParameterList_return formalParameterList() throws RecognitionException { return gEolParserRules.formalParameterList(); }
    public Flock_EolParserRules.nativeType_return nativeType() throws RecognitionException { return gEolParserRules.nativeType(); }
    public Flock_EolParserRules.modelAlias_return modelAlias() throws RecognitionException { return gEolParserRules.modelAlias(); }
    public Flock_EolParserRules.ifStatement_return ifStatement() throws RecognitionException { return gEolParserRules.ifStatement(); }
    public Flock_EolParserRules.collectionType_return collectionType() throws RecognitionException { return gEolParserRules.collectionType(); }
    public Flock_EolParserRules.simpleFeatureCall_return simpleFeatureCall() throws RecognitionException { return gEolParserRules.simpleFeatureCall(); }
    public Flock_EolParserRules.featureCall_return featureCall() throws RecognitionException { return gEolParserRules.featureCall(); }
    public Flock_EolParserRules.modelNamespace_return modelNamespace() throws RecognitionException { return gEolParserRules.modelNamespace(); }
    public Flock_EolParserRules.parameterList_return parameterList() throws RecognitionException { return gEolParserRules.parameterList(); }
    public Flock_EolParserRules.declarativeFeatureCall_return declarativeFeatureCall() throws RecognitionException { return gEolParserRules.declarativeFeatureCall(); }
    public Flock_EolParserRules.unaryExpression_return unaryExpression() throws RecognitionException { return gEolParserRules.unaryExpression(); }
    public Flock_EolParserRules.importStatement_return importStatement() throws RecognitionException { return gEolParserRules.importStatement(); }
    public Flock_EolParserRules.expressionStatement_return expressionStatement() throws RecognitionException { return gEolParserRules.expressionStatement(); }
    public Flock_EolParserRules.relationalExpression_return relationalExpression() throws RecognitionException { return gEolParserRules.relationalExpression(); }
    public Flock_EolParserRules.deleteStatement_return deleteStatement() throws RecognitionException { return gEolParserRules.deleteStatement(); }
    public Flock_EolParserRules.caseStatement_return caseStatement() throws RecognitionException { return gEolParserRules.caseStatement(); }
    public Flock_EolParserRules.logicalExpression_return logicalExpression() throws RecognitionException { return gEolParserRules.logicalExpression(); }
    public Flock_EolParserRules.literal_return literal() throws RecognitionException { return gEolParserRules.literal(); }
    public Flock_EolParserRules.multiplicativeExpression_return multiplicativeExpression() throws RecognitionException { return gEolParserRules.multiplicativeExpression(); }
    public Flock_EolParserRules.expressionOrStatementBlock_return expressionOrStatementBlock() throws RecognitionException { return gEolParserRules.expressionOrStatementBlock(); }
    public Flock_EolParserRules.itemSelectorExpression_return itemSelectorExpression() throws RecognitionException { return gEolParserRules.itemSelectorExpression(); }
    public Flock_EolParserRules.returnStatement_return returnStatement() throws RecognitionException { return gEolParserRules.returnStatement(); }
    public Flock_EolParserRules.breakAllStatement_return breakAllStatement() throws RecognitionException { return gEolParserRules.breakAllStatement(); }
    public Flock_EolParserRules.assignmentStatement_return assignmentStatement() throws RecognitionException { return gEolParserRules.assignmentStatement(); }
    public Flock_EolParserRules.litteralCollection_return litteralCollection() throws RecognitionException { return gEolParserRules.litteralCollection(); }
    public Flock_EolParserRules.operationDeclaration_return operationDeclaration() throws RecognitionException { return gEolParserRules.operationDeclaration(); }
    public Flock_EolParserRules.elseStatement_return elseStatement() throws RecognitionException { return gEolParserRules.elseStatement(); }
    public Flock_EolParserRules.expressionRange_return expressionRange() throws RecognitionException { return gEolParserRules.expressionRange(); }
    public Flock_EolParserRules.variableDeclarationExpression_return variableDeclarationExpression() throws RecognitionException { return gEolParserRules.variableDeclarationExpression(); }
    public Flock_EolParserRules.modelDeclarationParameters_return modelDeclarationParameters() throws RecognitionException { return gEolParserRules.modelDeclarationParameters(); }
    public Flock_EolParserRules.newExpression_return newExpression() throws RecognitionException { return gEolParserRules.newExpression(); }
    public Flock_EolParserRules.annotation_return annotation() throws RecognitionException { return gEolParserRules.annotation(); }
    public Flock_EolParserRules.statement_return statement() throws RecognitionException { return gEolParserRules.statement(); }
    public Flock_EolParserRules.modelElementType_return modelElementType() throws RecognitionException { return gEolParserRules.modelElementType(); }
    public Flock_EolParserRules.typeName_return typeName() throws RecognitionException { return gEolParserRules.typeName(); }
    public Flock_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock() throws RecognitionException { return gEolParserRules.statementOrStatementBlock(); }
    public Flock_EolParserRules.executableAnnotation_return executableAnnotation() throws RecognitionException { return gEolParserRules.executableAnnotation(); }
    public Flock_EolParserRules.pathName_return pathName() throws RecognitionException { return gEolParserRules.pathName(); }
    public Flock_EolParserRules.annotationBlock_return annotationBlock() throws RecognitionException { return gEolParserRules.annotationBlock(); }
    public Flock_EolParserRules.primitiveExpression_return primitiveExpression() throws RecognitionException { return gEolParserRules.primitiveExpression(); }
    public Flock_EolParserRules.formalParameter_return formalParameter() throws RecognitionException { return gEolParserRules.formalParameter(); }
    public Flock_EolParserRules.modelDeclarationParameter_return modelDeclarationParameter() throws RecognitionException { return gEolParserRules.modelDeclarationParameter(); }
    public Flock_EolParserRules.throwStatement_return throwStatement() throws RecognitionException { return gEolParserRules.throwStatement(); }
    public Flock_EolParserRules.defaultStatement_return defaultStatement() throws RecognitionException { return gEolParserRules.defaultStatement(); }
    public Flock_EolParserRules.statementBlock_return statementBlock() throws RecognitionException { return gEolParserRules.statementBlock(); }
    public Flock_EolParserRules.forStatement_return forStatement() throws RecognitionException { return gEolParserRules.forStatement(); }
    public Flock_EolParserRules.modelDriver_return modelDriver() throws RecognitionException { return gEolParserRules.modelDriver(); }
    public Flock_EolParserRules.continueStatement_return continueStatement() throws RecognitionException { return gEolParserRules.continueStatement(); }

    public final boolean synpred5_Flock() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_Flock_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_importStatement_in_flockModule79 = new BitSet(new long[]{0x0000000000200000L,0x0000200001980000L,0x0000000000000200L});
    public static final BitSet FOLLOW_flockModuleContent_in_flockModule83 = new BitSet(new long[]{0x0000000000200000L,0x0000200001180000L,0x0000000000000200L});
    public static final BitSet FOLLOW_EOF_in_flockModule87 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule_in_flockModuleContent111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_operationDeclarationOrAnnotationBlock_in_flockModuleContent115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_migrateRule_in_rule127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_deleteRule_in_rule131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fullMigrateRule_in_migrateRule142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_shorthandMigrateRule_in_migrateRule146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_137_in_fullMigrateRule156 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NAME_in_fullMigrateRule160 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L,0x0000000000000C00L});
    public static final BitSet FOLLOW_138_in_fullMigrateRule163 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NAME_in_fullMigrateRule167 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L,0x0000000000000800L});
    public static final BitSet FOLLOW_guard_in_fullMigrateRule171 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_80_in_fullMigrateRule174 = new BitSet(new long[]{0x0000000000021450L,0x0007FC6FF0220000L,0x0000000000000189L});
    public static final BitSet FOLLOW_block_in_fullMigrateRule178 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_81_in_fullMigrateRule180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_137_in_shorthandMigrateRule220 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NAME_in_shorthandMigrateRule224 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_138_in_shorthandMigrateRule226 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NAME_in_shorthandMigrateRule230 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_guard_in_shorthandMigrateRule232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_139_in_guard268 = new BitSet(new long[]{0x0000000000000000L,0x0000000000011000L});
    public static final BitSet FOLLOW_expressionOrStatementBlock_in_guard270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_109_in_deleteRule299 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NAME_in_deleteRule303 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_guard_in_deleteRule305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fullMigrateRule_in_synpred5_Flock142 = new BitSet(new long[]{0x0000000000000002L});

}