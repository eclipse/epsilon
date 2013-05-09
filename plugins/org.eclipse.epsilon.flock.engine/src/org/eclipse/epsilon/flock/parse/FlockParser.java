// $ANTLR 3.1b1 /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g 2013-05-09 11:20:08

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
public class FlockParser extends org.eclipse.epsilon.common.parse.EpsilonParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "FLOAT", "DIGIT", "EXPONENT", "FLOAT_TYPE_SUFFIX", "INT", "POINT", "POINT_POINT", "ARROW", "BOOLEAN", "EscapeSequence", "STRING", "StrangeNameLiteral", "Letter", "SpecialNameChar", "JavaIDDigit", "NAME", "WS", "COMMENT", "LINE_COMMENT", "Annotation", "FORMAL", "PARAMLIST", "ASSIGNMENT", "SPECIAL_ASSIGNMENT", "HELPERMETHOD", "StatementBlock", "FOR", "IF", "ELSE", "WHILE", "SWITCH", "CASE", "DEFAULT", "RETURN", "BREAK", "BREAKALL", "CONTINUE", "TRANSACTION", "COLLECTION", "ABORT", "CollectionType", "ModelElementType", "PARAMETERS", "NewExpression", "VAR", "NEW", "ANNOTATIONBLOCK", "EXECUTABLEANNOTATION", "DELETE", "THROW", "EXPRLIST", "EXPRRANGE", "NativeType", "MultiplicativeExpression", "OPERATOR", "FeatureCall", "EOLMODULE", "BLOCK", "FEATURECALL", "TYPE", "ENUMERATION_VALUE", "IMPORT", "MODELDECLARATION", "NAMESPACE", "ALIAS", "DRIVER", "MODELDECLARATIONPARAMETERS", "MODELDECLARATIONPARAMETER", "ITEMSELECTOR", "MAP", "KEYVAL", "KEYVALLIST", "FLOCKMODULE", "RETYPE", "RETYPEPACKAGE", "DELETEPACKAGE", "MIGRATE", "GUARD", "IGNORING", "'model'", "';'", "':'", "','", "'alias'", "'driver'", "'{'", "'}'", "'='", "'operation'", "'function'", "'('", "')'", "'import'", "'$'", "'!'", "'#'", "'::'", "'Native'", "'Collection'", "'Sequence'", "'List'", "'Bag'", "'Set'", "'OrderedSet'", "'Map'", "'for'", "'in'", "'if'", "'switch'", "'case'", "'default'", "'else'", "'while'", "'return'", "'throw'", "'delete'", "'break'", "'breakAll'", "'continue'", "'abort'", "'transaction'", "':='", "'::='", "'or'", "'and'", "'xor'", "'implies'", "'=='", "'>'", "'<'", "'>='", "'<='", "'<>'", "'+'", "'-'", "'*'", "'/'", "'not'", "'['", "']'", "'|'", "'new'", "'var'", "'retype'", "'package'", "'to'", "'migrate'", "'ignoring'", "'when'"
    };
    public static final int RETYPE=77;
    public static final int EXPONENT=6;
    public static final int WHILE=33;
    public static final int StatementBlock=29;
    public static final int FLOCKMODULE=76;
    public static final int StrangeNameLiteral=15;
    public static final int CASE=35;
    public static final int NEW=49;
    public static final int FeatureCall=59;
    public static final int EOF=-1;
    public static final int BREAK=38;
    public static final int KEYVALLIST=75;
    public static final int TYPE=63;
    public static final int T__93=93;
    public static final int T__94=94;
    public static final int T__91=91;
    public static final int IMPORT=65;
    public static final int T__92=92;
    public static final int NAME=19;
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
    public static final int T__99=99;
    public static final int ITEMSELECTOR=72;
    public static final int T__98=98;
    public static final int T__150=150;
    public static final int T__97=97;
    public static final int T__151=151;
    public static final int MultiplicativeExpression=57;
    public static final int T__96=96;
    public static final int T__152=152;
    public static final int T__95=95;
    public static final int FLOAT_TYPE_SUFFIX=7;
    public static final int T__139=139;
    public static final int T__138=138;
    public static final int T__137=137;
    public static final int T__136=136;
    public static final int T__83=83;
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
    public static final int T__85=85;
    public static final int T__141=141;
    public static final int T__84=84;
    public static final int T__142=142;
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
    public static final int MIGRATE=80;
    public static final int JavaIDDigit=18;
    public static final int GUARD=81;
    public static final int IGNORING=82;
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
    public static final int T__100=100;
    public static final int RETYPEPACKAGE=78;
    public static final int POINT_POINT=10;
    public static final int SpecialNameChar=17;
    public static final int MODELDECLARATIONPARAMETERS=70;
    public static final int BLOCK=61;
    public static final int MAP=73;
    public static final int FEATURECALL=62;
    public static final int FORMAL=24;
    public static final int DELETEPACKAGE=79;
    public static final int ARROW=11;
    public static final int ASSIGNMENT=26;
    public static final int STRING=14;

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
    public String getGrammarFileName() { return "/Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g"; }


    	@Override
    	public void prepareForGUnit() {
    		super.prepareForGUnit();
    		gEolParserRules.prepareForGUnit();
    	}


    public static class flockModule_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start flockModule
    // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:101:1: flockModule : ( importStatement )* ( flockModuleContent )* EOF -> ^( FLOCKMODULE ( importStatement )* ( flockModuleContent )* ) ;
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
            // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:102:2: ( ( importStatement )* ( flockModuleContent )* EOF -> ^( FLOCKMODULE ( importStatement )* ( flockModuleContent )* ) )
            // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:102:4: ( importStatement )* ( flockModuleContent )* EOF
            {
            // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:102:4: ( importStatement )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==96) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:0:0: importStatement
            	    {
            	    pushFollow(FOLLOW_importStatement_in_flockModule100);
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

            // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:102:21: ( flockModuleContent )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==Annotation||(LA2_0>=92 && LA2_0<=93)||LA2_0==97||LA2_0==119||LA2_0==147||LA2_0==150) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:102:22: flockModuleContent
            	    {
            	    pushFollow(FOLLOW_flockModuleContent_in_flockModule104);
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

            EOF3=(Token)match(input,EOF,FOLLOW_EOF_in_flockModule108); if (state.failed) return retval; 
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
            // 103:2: -> ^( FLOCKMODULE ( importStatement )* ( flockModuleContent )* )
            {
                // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:103:5: ^( FLOCKMODULE ( importStatement )* ( flockModuleContent )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FLOCKMODULE, "FLOCKMODULE"), root_1);

                // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:103:19: ( importStatement )*
                while ( stream_importStatement.hasNext() ) {
                    adaptor.addChild(root_1, stream_importStatement.nextTree());

                }
                stream_importStatement.reset();
                // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:103:36: ( flockModuleContent )*
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
    // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:106:1: flockModuleContent : ( retyping | deletion | migrateRule | operationDeclarationOrAnnotationBlock );
    public final FlockParser.flockModuleContent_return flockModuleContent() throws RecognitionException {
        FlockParser.flockModuleContent_return retval = new FlockParser.flockModuleContent_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        FlockParser.retyping_return retyping4 = null;

        FlockParser.deletion_return deletion5 = null;

        FlockParser.migrateRule_return migrateRule6 = null;

        Flock_EolParserRules.operationDeclarationOrAnnotationBlock_return operationDeclarationOrAnnotationBlock7 = null;



        try {
            // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:107:2: ( retyping | deletion | migrateRule | operationDeclarationOrAnnotationBlock )
            int alt3=4;
            switch ( input.LA(1) ) {
            case 147:
                {
                alt3=1;
                }
                break;
            case 119:
                {
                alt3=2;
                }
                break;
            case 150:
                {
                alt3=3;
                }
                break;
            case Annotation:
            case 92:
            case 93:
            case 97:
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
                    // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:107:4: retyping
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_retyping_in_flockModuleContent132);
                    retyping4=retyping();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, retyping4.getTree());

                    }
                    break;
                case 2 :
                    // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:107:15: deletion
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_deletion_in_flockModuleContent136);
                    deletion5=deletion();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, deletion5.getTree());

                    }
                    break;
                case 3 :
                    // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:107:26: migrateRule
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_migrateRule_in_flockModuleContent140);
                    migrateRule6=migrateRule();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, migrateRule6.getTree());

                    }
                    break;
                case 4 :
                    // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:107:40: operationDeclarationOrAnnotationBlock
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_operationDeclarationOrAnnotationBlock_in_flockModuleContent144);
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
    // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:110:1: retyping : ( retyping_package | retyping_classifier );
    public final FlockParser.retyping_return retyping() throws RecognitionException {
        FlockParser.retyping_return retval = new FlockParser.retyping_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        FlockParser.retyping_package_return retyping_package8 = null;

        FlockParser.retyping_classifier_return retyping_classifier9 = null;



        try {
            // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:111:2: ( retyping_package | retyping_classifier )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==147) ) {
                int LA4_1 = input.LA(2);

                if ( (LA4_1==148) ) {
                    alt4=1;
                }
                else if ( (LA4_1==NAME) ) {
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
                    // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:111:4: retyping_package
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_retyping_package_in_retyping155);
                    retyping_package8=retyping_package();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, retyping_package8.getTree());

                    }
                    break;
                case 2 :
                    // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:111:23: retyping_classifier
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_retyping_classifier_in_retyping159);
                    retyping_classifier9=retyping_classifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, retyping_classifier9.getTree());

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
    // $ANTLR end retyping

    public static class retyping_package_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start retyping_package
    // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:113:1: retyping_package : 'retype' 'package' originalPackage= NAME 'to' migratedPackage= NAME ( guard )? -> ^( RETYPEPACKAGE $originalPackage $migratedPackage ( guard )? ) ;
    public final FlockParser.retyping_package_return retyping_package() throws RecognitionException {
        FlockParser.retyping_package_return retval = new FlockParser.retyping_package_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token originalPackage=null;
        Token migratedPackage=null;
        Token string_literal10=null;
        Token string_literal11=null;
        Token string_literal12=null;
        FlockParser.guard_return guard13 = null;


        CommonTree originalPackage_tree=null;
        CommonTree migratedPackage_tree=null;
        CommonTree string_literal10_tree=null;
        CommonTree string_literal11_tree=null;
        CommonTree string_literal12_tree=null;
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_147=new RewriteRuleTokenStream(adaptor,"token 147");
        RewriteRuleTokenStream stream_148=new RewriteRuleTokenStream(adaptor,"token 148");
        RewriteRuleTokenStream stream_149=new RewriteRuleTokenStream(adaptor,"token 149");
        RewriteRuleSubtreeStream stream_guard=new RewriteRuleSubtreeStream(adaptor,"rule guard");
        try {
            // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:114:2: ( 'retype' 'package' originalPackage= NAME 'to' migratedPackage= NAME ( guard )? -> ^( RETYPEPACKAGE $originalPackage $migratedPackage ( guard )? ) )
            // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:114:4: 'retype' 'package' originalPackage= NAME 'to' migratedPackage= NAME ( guard )?
            {
            string_literal10=(Token)match(input,147,FOLLOW_147_in_retyping_package168); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_147.add(string_literal10);

            string_literal11=(Token)match(input,148,FOLLOW_148_in_retyping_package170); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_148.add(string_literal11);

            originalPackage=(Token)match(input,NAME,FOLLOW_NAME_in_retyping_package174); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(originalPackage);

            string_literal12=(Token)match(input,149,FOLLOW_149_in_retyping_package176); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_149.add(string_literal12);

            migratedPackage=(Token)match(input,NAME,FOLLOW_NAME_in_retyping_package180); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(migratedPackage);

            // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:114:70: ( guard )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==152) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:0:0: guard
                    {
                    pushFollow(FOLLOW_guard_in_retyping_package182);
                    guard13=guard();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_guard.add(guard13.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: migratedPackage, guard, originalPackage
            // token labels: migratedPackage, originalPackage
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_migratedPackage=new RewriteRuleTokenStream(adaptor,"token migratedPackage",migratedPackage);
            RewriteRuleTokenStream stream_originalPackage=new RewriteRuleTokenStream(adaptor,"token originalPackage",originalPackage);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 115:5: -> ^( RETYPEPACKAGE $originalPackage $migratedPackage ( guard )? )
            {
                // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:116:5: ^( RETYPEPACKAGE $originalPackage $migratedPackage ( guard )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(RETYPEPACKAGE, "RETYPEPACKAGE"), root_1);

                adaptor.addChild(root_1, stream_originalPackage.nextNode());
                adaptor.addChild(root_1, stream_migratedPackage.nextNode());
                // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:116:55: ( guard )?
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
    // $ANTLR end retyping_package

    public static class retyping_classifier_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start retyping_classifier
    // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:118:1: retyping_classifier : 'retype' originalType= packagedType 'to' migratedType= packagedType ( guard )? -> ^( RETYPE $originalType $migratedType ( guard )? ) ;
    public final FlockParser.retyping_classifier_return retyping_classifier() throws RecognitionException {
        FlockParser.retyping_classifier_return retval = new FlockParser.retyping_classifier_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal14=null;
        Token string_literal15=null;
        Flock_EolParserRules.packagedType_return originalType = null;

        Flock_EolParserRules.packagedType_return migratedType = null;

        FlockParser.guard_return guard16 = null;


        CommonTree string_literal14_tree=null;
        CommonTree string_literal15_tree=null;
        RewriteRuleTokenStream stream_147=new RewriteRuleTokenStream(adaptor,"token 147");
        RewriteRuleTokenStream stream_149=new RewriteRuleTokenStream(adaptor,"token 149");
        RewriteRuleSubtreeStream stream_guard=new RewriteRuleSubtreeStream(adaptor,"rule guard");
        RewriteRuleSubtreeStream stream_packagedType=new RewriteRuleSubtreeStream(adaptor,"rule packagedType");
        try {
            // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:119:2: ( 'retype' originalType= packagedType 'to' migratedType= packagedType ( guard )? -> ^( RETYPE $originalType $migratedType ( guard )? ) )
            // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:119:4: 'retype' originalType= packagedType 'to' migratedType= packagedType ( guard )?
            {
            string_literal14=(Token)match(input,147,FOLLOW_147_in_retyping_classifier217); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_147.add(string_literal14);

            pushFollow(FOLLOW_packagedType_in_retyping_classifier221);
            originalType=packagedType();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_packagedType.add(originalType.getTree());
            string_literal15=(Token)match(input,149,FOLLOW_149_in_retyping_classifier223); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_149.add(string_literal15);

            pushFollow(FOLLOW_packagedType_in_retyping_classifier227);
            migratedType=packagedType();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_packagedType.add(migratedType.getTree());
            // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:119:70: ( guard )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==152) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:0:0: guard
                    {
                    pushFollow(FOLLOW_guard_in_retyping_classifier229);
                    guard16=guard();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_guard.add(guard16.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: originalType, migratedType, guard
            // token labels: 
            // rule labels: retval, migratedType, originalType
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_migratedType=new RewriteRuleSubtreeStream(adaptor,"token migratedType",migratedType!=null?migratedType.tree:null);
            RewriteRuleSubtreeStream stream_originalType=new RewriteRuleSubtreeStream(adaptor,"token originalType",originalType!=null?originalType.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 120:5: -> ^( RETYPE $originalType $migratedType ( guard )? )
            {
                // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:121:5: ^( RETYPE $originalType $migratedType ( guard )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(RETYPE, "RETYPE"), root_1);

                adaptor.addChild(root_1, stream_originalType.nextTree());
                adaptor.addChild(root_1, stream_migratedType.nextTree());
                // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:121:42: ( guard )?
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
    // $ANTLR end retyping_classifier

    public static class deletion_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start deletion
    // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:123:1: deletion : ( deletion_package | deletion_classifier );
    public final FlockParser.deletion_return deletion() throws RecognitionException {
        FlockParser.deletion_return retval = new FlockParser.deletion_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        FlockParser.deletion_package_return deletion_package17 = null;

        FlockParser.deletion_classifier_return deletion_classifier18 = null;



        try {
            // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:124:2: ( deletion_package | deletion_classifier )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==119) ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==148) ) {
                    alt7=1;
                }
                else if ( (LA7_1==NAME) ) {
                    alt7=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:124:4: deletion_package
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_deletion_package_in_deletion263);
                    deletion_package17=deletion_package();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, deletion_package17.getTree());

                    }
                    break;
                case 2 :
                    // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:124:23: deletion_classifier
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_deletion_classifier_in_deletion267);
                    deletion_classifier18=deletion_classifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, deletion_classifier18.getTree());

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
    // $ANTLR end deletion

    public static class deletion_package_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start deletion_package
    // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:126:1: deletion_package : 'delete' 'package' pkg= NAME ( guard )? -> ^( DELETEPACKAGE $pkg ( guard )? ) ;
    public final FlockParser.deletion_package_return deletion_package() throws RecognitionException {
        FlockParser.deletion_package_return retval = new FlockParser.deletion_package_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token pkg=null;
        Token string_literal19=null;
        Token string_literal20=null;
        FlockParser.guard_return guard21 = null;


        CommonTree pkg_tree=null;
        CommonTree string_literal19_tree=null;
        CommonTree string_literal20_tree=null;
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_148=new RewriteRuleTokenStream(adaptor,"token 148");
        RewriteRuleTokenStream stream_119=new RewriteRuleTokenStream(adaptor,"token 119");
        RewriteRuleSubtreeStream stream_guard=new RewriteRuleSubtreeStream(adaptor,"rule guard");
        try {
            // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:127:3: ( 'delete' 'package' pkg= NAME ( guard )? -> ^( DELETEPACKAGE $pkg ( guard )? ) )
            // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:127:5: 'delete' 'package' pkg= NAME ( guard )?
            {
            string_literal19=(Token)match(input,119,FOLLOW_119_in_deletion_package277); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_119.add(string_literal19);

            string_literal20=(Token)match(input,148,FOLLOW_148_in_deletion_package279); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_148.add(string_literal20);

            pkg=(Token)match(input,NAME,FOLLOW_NAME_in_deletion_package283); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(pkg);

            // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:127:33: ( guard )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==152) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:0:0: guard
                    {
                    pushFollow(FOLLOW_guard_in_deletion_package285);
                    guard21=guard();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_guard.add(guard21.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: pkg, guard
            // token labels: pkg
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_pkg=new RewriteRuleTokenStream(adaptor,"token pkg",pkg);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 128:3: -> ^( DELETEPACKAGE $pkg ( guard )? )
            {
                // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:129:5: ^( DELETEPACKAGE $pkg ( guard )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(DELETEPACKAGE, "DELETEPACKAGE"), root_1);

                adaptor.addChild(root_1, stream_pkg.nextNode());
                // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:129:26: ( guard )?
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
    // $ANTLR end deletion_package

    public static class deletion_classifier_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start deletion_classifier
    // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:131:1: deletion_classifier : 'delete' type= packagedType ( guard )? -> ^( DELETE $type ( guard )? ) ;
    public final FlockParser.deletion_classifier_return deletion_classifier() throws RecognitionException {
        FlockParser.deletion_classifier_return retval = new FlockParser.deletion_classifier_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal22=null;
        Flock_EolParserRules.packagedType_return type = null;

        FlockParser.guard_return guard23 = null;


        CommonTree string_literal22_tree=null;
        RewriteRuleTokenStream stream_119=new RewriteRuleTokenStream(adaptor,"token 119");
        RewriteRuleSubtreeStream stream_guard=new RewriteRuleSubtreeStream(adaptor,"rule guard");
        RewriteRuleSubtreeStream stream_packagedType=new RewriteRuleSubtreeStream(adaptor,"rule packagedType");
        try {
            // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:132:3: ( 'delete' type= packagedType ( guard )? -> ^( DELETE $type ( guard )? ) )
            // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:132:5: 'delete' type= packagedType ( guard )?
            {
            string_literal22=(Token)match(input,119,FOLLOW_119_in_deletion_classifier314); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_119.add(string_literal22);

            pushFollow(FOLLOW_packagedType_in_deletion_classifier318);
            type=packagedType();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_packagedType.add(type.getTree());
            // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:132:32: ( guard )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==152) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:0:0: guard
                    {
                    pushFollow(FOLLOW_guard_in_deletion_classifier320);
                    guard23=guard();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_guard.add(guard23.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: type, guard
            // token labels: 
            // rule labels: retval, type
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"token type",type!=null?type.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 133:3: -> ^( DELETE $type ( guard )? )
            {
                // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:134:5: ^( DELETE $type ( guard )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(DELETE, "DELETE"), root_1);

                adaptor.addChild(root_1, stream_type.nextTree());
                // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:134:20: ( guard )?
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
    // $ANTLR end deletion_classifier

    public static class migrateRule_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start migrateRule
    // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:137:1: migrateRule : ( fullRule | ignoringRule );
    public final FlockParser.migrateRule_return migrateRule() throws RecognitionException {
        FlockParser.migrateRule_return retval = new FlockParser.migrateRule_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        FlockParser.fullRule_return fullRule24 = null;

        FlockParser.ignoringRule_return ignoringRule25 = null;



        try {
            // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:138:3: ( fullRule | ignoringRule )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==150) ) {
                int LA10_1 = input.LA(2);

                if ( (synpred12_Flock()) ) {
                    alt10=1;
                }
                else if ( (true) ) {
                    alt10=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:138:5: fullRule
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_fullRule_in_migrateRule350);
                    fullRule24=fullRule();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, fullRule24.getTree());

                    }
                    break;
                case 2 :
                    // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:138:16: ignoringRule
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_ignoringRule_in_migrateRule354);
                    ignoringRule25=ignoringRule();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, ignoringRule25.getTree());

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
    // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:140:1: fullRule : 'migrate' originalType= packagedType ( ignoring )? ( guard )? '{' body= block '}' -> ^( MIGRATE $originalType ( ignoring )? ( guard )? $body) ;
    public final FlockParser.fullRule_return fullRule() throws RecognitionException {
        FlockParser.fullRule_return retval = new FlockParser.fullRule_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal26=null;
        Token char_literal29=null;
        Token char_literal30=null;
        Flock_EolParserRules.packagedType_return originalType = null;

        Flock_EolParserRules.block_return body = null;

        FlockParser.ignoring_return ignoring27 = null;

        FlockParser.guard_return guard28 = null;


        CommonTree string_literal26_tree=null;
        CommonTree char_literal29_tree=null;
        CommonTree char_literal30_tree=null;
        RewriteRuleTokenStream stream_150=new RewriteRuleTokenStream(adaptor,"token 150");
        RewriteRuleTokenStream stream_90=new RewriteRuleTokenStream(adaptor,"token 90");
        RewriteRuleTokenStream stream_89=new RewriteRuleTokenStream(adaptor,"token 89");
        RewriteRuleSubtreeStream stream_guard=new RewriteRuleSubtreeStream(adaptor,"rule guard");
        RewriteRuleSubtreeStream stream_packagedType=new RewriteRuleSubtreeStream(adaptor,"rule packagedType");
        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        RewriteRuleSubtreeStream stream_ignoring=new RewriteRuleSubtreeStream(adaptor,"rule ignoring");
        try {
            // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:141:3: ( 'migrate' originalType= packagedType ( ignoring )? ( guard )? '{' body= block '}' -> ^( MIGRATE $originalType ( ignoring )? ( guard )? $body) )
            // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:141:5: 'migrate' originalType= packagedType ( ignoring )? ( guard )? '{' body= block '}'
            {
            string_literal26=(Token)match(input,150,FOLLOW_150_in_fullRule366); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_150.add(string_literal26);

            pushFollow(FOLLOW_packagedType_in_fullRule370);
            originalType=packagedType();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_packagedType.add(originalType.getTree());
            // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:141:41: ( ignoring )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==151) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:0:0: ignoring
                    {
                    pushFollow(FOLLOW_ignoring_in_fullRule372);
                    ignoring27=ignoring();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_ignoring.add(ignoring27.getTree());

                    }
                    break;

            }

            // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:141:51: ( guard )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==152) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:0:0: guard
                    {
                    pushFollow(FOLLOW_guard_in_fullRule375);
                    guard28=guard();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_guard.add(guard28.getTree());

                    }
                    break;

            }

            char_literal29=(Token)match(input,89,FOLLOW_89_in_fullRule378); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_89.add(char_literal29);

            pushFollow(FOLLOW_block_in_fullRule382);
            body=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_block.add(body.getTree());
            char_literal30=(Token)match(input,90,FOLLOW_90_in_fullRule384); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_90.add(char_literal30);



            // AST REWRITE
            // elements: guard, originalType, ignoring, body
            // token labels: 
            // rule labels: body, retval, originalType
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_body=new RewriteRuleSubtreeStream(adaptor,"token body",body!=null?body.tree:null);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_originalType=new RewriteRuleSubtreeStream(adaptor,"token originalType",originalType!=null?originalType.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 142:5: -> ^( MIGRATE $originalType ( ignoring )? ( guard )? $body)
            {
                // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:143:5: ^( MIGRATE $originalType ( ignoring )? ( guard )? $body)
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(MIGRATE, "MIGRATE"), root_1);

                adaptor.addChild(root_1, stream_originalType.nextTree());
                // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:143:29: ( ignoring )?
                if ( stream_ignoring.hasNext() ) {
                    adaptor.addChild(root_1, stream_ignoring.nextTree());

                }
                stream_ignoring.reset();
                // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:143:39: ( guard )?
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
    // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:145:1: ignoringRule : 'migrate' originalType= packagedType ignoring ( guard )? -> ^( MIGRATE $originalType ignoring ( guard )? ) ;
    public final FlockParser.ignoringRule_return ignoringRule() throws RecognitionException {
        FlockParser.ignoringRule_return retval = new FlockParser.ignoringRule_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal31=null;
        Flock_EolParserRules.packagedType_return originalType = null;

        FlockParser.ignoring_return ignoring32 = null;

        FlockParser.guard_return guard33 = null;


        CommonTree string_literal31_tree=null;
        RewriteRuleTokenStream stream_150=new RewriteRuleTokenStream(adaptor,"token 150");
        RewriteRuleSubtreeStream stream_guard=new RewriteRuleSubtreeStream(adaptor,"rule guard");
        RewriteRuleSubtreeStream stream_packagedType=new RewriteRuleSubtreeStream(adaptor,"rule packagedType");
        RewriteRuleSubtreeStream stream_ignoring=new RewriteRuleSubtreeStream(adaptor,"rule ignoring");
        try {
            // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:146:3: ( 'migrate' originalType= packagedType ignoring ( guard )? -> ^( MIGRATE $originalType ignoring ( guard )? ) )
            // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:146:5: 'migrate' originalType= packagedType ignoring ( guard )?
            {
            string_literal31=(Token)match(input,150,FOLLOW_150_in_ignoringRule426); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_150.add(string_literal31);

            pushFollow(FOLLOW_packagedType_in_ignoringRule430);
            originalType=packagedType();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_packagedType.add(originalType.getTree());
            pushFollow(FOLLOW_ignoring_in_ignoringRule432);
            ignoring32=ignoring();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_ignoring.add(ignoring32.getTree());
            // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:146:50: ( guard )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==152) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:0:0: guard
                    {
                    pushFollow(FOLLOW_guard_in_ignoringRule434);
                    guard33=guard();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_guard.add(guard33.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: guard, ignoring, originalType
            // token labels: 
            // rule labels: retval, originalType
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_originalType=new RewriteRuleSubtreeStream(adaptor,"token originalType",originalType!=null?originalType.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 147:5: -> ^( MIGRATE $originalType ignoring ( guard )? )
            {
                // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:148:5: ^( MIGRATE $originalType ignoring ( guard )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(MIGRATE, "MIGRATE"), root_1);

                adaptor.addChild(root_1, stream_originalType.nextTree());
                adaptor.addChild(root_1, stream_ignoring.nextTree());
                // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:148:38: ( guard )?
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
    // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:150:1: ignoring : 'ignoring' propertyList -> ^( IGNORING propertyList ) ;
    public final FlockParser.ignoring_return ignoring() throws RecognitionException {
        FlockParser.ignoring_return retval = new FlockParser.ignoring_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal34=null;
        FlockParser.propertyList_return propertyList35 = null;


        CommonTree string_literal34_tree=null;
        RewriteRuleTokenStream stream_151=new RewriteRuleTokenStream(adaptor,"token 151");
        RewriteRuleSubtreeStream stream_propertyList=new RewriteRuleSubtreeStream(adaptor,"rule propertyList");
        try {
            // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:151:3: ( 'ignoring' propertyList -> ^( IGNORING propertyList ) )
            // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:151:5: 'ignoring' propertyList
            {
            string_literal34=(Token)match(input,151,FOLLOW_151_in_ignoring469); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_151.add(string_literal34);

            pushFollow(FOLLOW_propertyList_in_ignoring471);
            propertyList35=propertyList();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_propertyList.add(propertyList35.getTree());


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
            // 152:3: -> ^( IGNORING propertyList )
            {
                // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:153:3: ^( IGNORING propertyList )
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
    // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:155:1: propertyList : NAME ( ',' NAME )* -> ( NAME )* ;
    public final FlockParser.propertyList_return propertyList() throws RecognitionException {
        FlockParser.propertyList_return retval = new FlockParser.propertyList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NAME36=null;
        Token char_literal37=null;
        Token NAME38=null;

        CommonTree NAME36_tree=null;
        CommonTree char_literal37_tree=null;
        CommonTree NAME38_tree=null;
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_86=new RewriteRuleTokenStream(adaptor,"token 86");

        try {
            // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:156:3: ( NAME ( ',' NAME )* -> ( NAME )* )
            // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:156:5: NAME ( ',' NAME )*
            {
            NAME36=(Token)match(input,NAME,FOLLOW_NAME_in_propertyList495); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(NAME36);

            // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:156:10: ( ',' NAME )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==86) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:156:11: ',' NAME
            	    {
            	    char_literal37=(Token)match(input,86,FOLLOW_86_in_propertyList498); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_86.add(char_literal37);

            	    NAME38=(Token)match(input,NAME,FOLLOW_NAME_in_propertyList500); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_NAME.add(NAME38);


            	    }
            	    break;

            	default :
            	    break loop14;
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
            // 157:3: -> ( NAME )*
            {
                // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:158:3: ( NAME )*
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
    // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:160:1: guard : 'when' expressionOrStatementBlock -> ^( GUARD expressionOrStatementBlock ) ;
    public final FlockParser.guard_return guard() throws RecognitionException {
        FlockParser.guard_return retval = new FlockParser.guard_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal39=null;
        Flock_EolParserRules.expressionOrStatementBlock_return expressionOrStatementBlock40 = null;


        CommonTree string_literal39_tree=null;
        RewriteRuleTokenStream stream_152=new RewriteRuleTokenStream(adaptor,"token 152");
        RewriteRuleSubtreeStream stream_expressionOrStatementBlock=new RewriteRuleSubtreeStream(adaptor,"rule expressionOrStatementBlock");
        try {
            // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:161:3: ( 'when' expressionOrStatementBlock -> ^( GUARD expressionOrStatementBlock ) )
            // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:161:5: 'when' expressionOrStatementBlock
            {
            string_literal39=(Token)match(input,152,FOLLOW_152_in_guard521); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_152.add(string_literal39);

            pushFollow(FOLLOW_expressionOrStatementBlock_in_guard523);
            expressionOrStatementBlock40=expressionOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expressionOrStatementBlock.add(expressionOrStatementBlock40.getTree());


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
            // 162:5: -> ^( GUARD expressionOrStatementBlock )
            {
                // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:163:5: ^( GUARD expressionOrStatementBlock )
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

    // $ANTLR start synpred12_Flock
    public final void synpred12_Flock_fragment() throws RecognitionException {   
        // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:138:5: ( fullRule )
        // /Users/louis/Code/Work/Epsilon/Juno/epsilon-workspace/epsilon-repository/plugins/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:138:5: fullRule
        {
        pushFollow(FOLLOW_fullRule_in_synpred12_Flock350);
        fullRule();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred12_Flock

    // Delegated rules
    public Flock_EolParserRules.additiveExpression_return additiveExpression() throws RecognitionException { return gEolParserRules.additiveExpression(); }
    public Flock_EolParserRules.primitiveExpression_return primitiveExpression() throws RecognitionException { return gEolParserRules.primitiveExpression(); }
    public Flock_EolParserRules.executableAnnotation_return executableAnnotation() throws RecognitionException { return gEolParserRules.executableAnnotation(); }
    public Flock_EolParserRules.pathName_return pathName() throws RecognitionException { return gEolParserRules.pathName(); }
    public Flock_EolParserRules.keyvalExpression_return keyvalExpression() throws RecognitionException { return gEolParserRules.keyvalExpression(); }
    public Flock_EolParserRules.whileStatement_return whileStatement() throws RecognitionException { return gEolParserRules.whileStatement(); }
    public Flock_EolParserRules.statementB_return statementB() throws RecognitionException { return gEolParserRules.statementB(); }
    public Flock_EolParserRules.multiplicativeExpression_return multiplicativeExpression() throws RecognitionException { return gEolParserRules.multiplicativeExpression(); }
    public Flock_EolParserRules.annotationBlock_return annotationBlock() throws RecognitionException { return gEolParserRules.annotationBlock(); }
    public Flock_EolParserRules.itemSelectorExpression_return itemSelectorExpression() throws RecognitionException { return gEolParserRules.itemSelectorExpression(); }
    public Flock_EolParserRules.abortStatement_return abortStatement() throws RecognitionException { return gEolParserRules.abortStatement(); }
    public Flock_EolParserRules.formalParameter_return formalParameter() throws RecognitionException { return gEolParserRules.formalParameter(); }
    public Flock_EolParserRules.keyvalExpressionList_return keyvalExpressionList() throws RecognitionException { return gEolParserRules.keyvalExpressionList(); }
    public Flock_EolParserRules.throwStatement_return throwStatement() throws RecognitionException { return gEolParserRules.throwStatement(); }
    public Flock_EolParserRules.simpleFeatureCall_return simpleFeatureCall() throws RecognitionException { return gEolParserRules.simpleFeatureCall(); }
    public Flock_EolParserRules.switchStatement_return switchStatement() throws RecognitionException { return gEolParserRules.switchStatement(); }
    public Flock_EolParserRules.collectionType_return collectionType() throws RecognitionException { return gEolParserRules.collectionType(); }
    public Flock_EolParserRules.expressionList_return expressionList() throws RecognitionException { return gEolParserRules.expressionList(); }
    public Flock_EolParserRules.modelAlias_return modelAlias() throws RecognitionException { return gEolParserRules.modelAlias(); }
    public Flock_EolParserRules.elseStatement_return elseStatement() throws RecognitionException { return gEolParserRules.elseStatement(); }
    public Flock_EolParserRules.statement_return statement() throws RecognitionException { return gEolParserRules.statement(); }
    public Flock_EolParserRules.postfixExpression_return postfixExpression() throws RecognitionException { return gEolParserRules.postfixExpression(); }
    public Flock_EolParserRules.declarativeFeatureCall_return declarativeFeatureCall() throws RecognitionException { return gEolParserRules.declarativeFeatureCall(); }
    public Flock_EolParserRules.statementBlock_return statementBlock() throws RecognitionException { return gEolParserRules.statementBlock(); }
    public Flock_EolParserRules.operationDeclarationOrAnnotationBlock_return operationDeclarationOrAnnotationBlock() throws RecognitionException { return gEolParserRules.operationDeclarationOrAnnotationBlock(); }
    public Flock_EolParserRules.importStatement_return importStatement() throws RecognitionException { return gEolParserRules.importStatement(); }
    public Flock_EolParserRules.newExpression_return newExpression() throws RecognitionException { return gEolParserRules.newExpression(); }
    public Flock_EolParserRules.featureCall_return featureCall() throws RecognitionException { return gEolParserRules.featureCall(); }
    public Flock_EolParserRules.modelDeclaration_return modelDeclaration() throws RecognitionException { return gEolParserRules.modelDeclaration(); }
    public Flock_EolParserRules.logicalExpression_return logicalExpression() throws RecognitionException { return gEolParserRules.logicalExpression(); }
    public Flock_EolParserRules.formalParameterList_return formalParameterList() throws RecognitionException { return gEolParserRules.formalParameterList(); }
    public Flock_EolParserRules.breakAllStatement_return breakAllStatement() throws RecognitionException { return gEolParserRules.breakAllStatement(); }
    public Flock_EolParserRules.forStatement_return forStatement() throws RecognitionException { return gEolParserRules.forStatement(); }
    public Flock_EolParserRules.deleteStatement_return deleteStatement() throws RecognitionException { return gEolParserRules.deleteStatement(); }
    public Flock_EolParserRules.operationDeclaration_return operationDeclaration() throws RecognitionException { return gEolParserRules.operationDeclaration(); }
    public Flock_EolParserRules.assignmentStatement_return assignmentStatement() throws RecognitionException { return gEolParserRules.assignmentStatement(); }
    public Flock_EolParserRules.expressionRange_return expressionRange() throws RecognitionException { return gEolParserRules.expressionRange(); }
    public Flock_EolParserRules.modelDriver_return modelDriver() throws RecognitionException { return gEolParserRules.modelDriver(); }
    public Flock_EolParserRules.transactionStatement_return transactionStatement() throws RecognitionException { return gEolParserRules.transactionStatement(); }
    public Flock_EolParserRules.block_return block() throws RecognitionException { return gEolParserRules.block(); }
    public Flock_EolParserRules.modelDeclarationParameters_return modelDeclarationParameters() throws RecognitionException { return gEolParserRules.modelDeclarationParameters(); }
    public Flock_EolParserRules.modelNamespace_return modelNamespace() throws RecognitionException { return gEolParserRules.modelNamespace(); }
    public Flock_EolParserRules.packagedType_return packagedType() throws RecognitionException { return gEolParserRules.packagedType(); }
    public Flock_EolParserRules.expressionOrStatementBlock_return expressionOrStatementBlock() throws RecognitionException { return gEolParserRules.expressionOrStatementBlock(); }
    public Flock_EolParserRules.statementA_return statementA() throws RecognitionException { return gEolParserRules.statementA(); }
    public Flock_EolParserRules.modelDeclarationParameter_return modelDeclarationParameter() throws RecognitionException { return gEolParserRules.modelDeclarationParameter(); }
    public Flock_EolParserRules.breakStatement_return breakStatement() throws RecognitionException { return gEolParserRules.breakStatement(); }
    public Flock_EolParserRules.continueStatement_return continueStatement() throws RecognitionException { return gEolParserRules.continueStatement(); }
    public Flock_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock() throws RecognitionException { return gEolParserRules.statementOrStatementBlock(); }
    public Flock_EolParserRules.relationalExpression_return relationalExpression() throws RecognitionException { return gEolParserRules.relationalExpression(); }
    public Flock_EolParserRules.literalMapCollection_return literalMapCollection() throws RecognitionException { return gEolParserRules.literalMapCollection(); }
    public Flock_EolParserRules.literalSequentialCollection_return literalSequentialCollection() throws RecognitionException { return gEolParserRules.literalSequentialCollection(); }
    public Flock_EolParserRules.literal_return literal() throws RecognitionException { return gEolParserRules.literal(); }
    public Flock_EolParserRules.parameterList_return parameterList() throws RecognitionException { return gEolParserRules.parameterList(); }
    public Flock_EolParserRules.caseStatement_return caseStatement() throws RecognitionException { return gEolParserRules.caseStatement(); }
    public Flock_EolParserRules.ifStatement_return ifStatement() throws RecognitionException { return gEolParserRules.ifStatement(); }
    public Flock_EolParserRules.returnStatement_return returnStatement() throws RecognitionException { return gEolParserRules.returnStatement(); }
    public Flock_EolParserRules.defaultStatement_return defaultStatement() throws RecognitionException { return gEolParserRules.defaultStatement(); }
    public Flock_EolParserRules.unaryExpression_return unaryExpression() throws RecognitionException { return gEolParserRules.unaryExpression(); }
    public Flock_EolParserRules.annotation_return annotation() throws RecognitionException { return gEolParserRules.annotation(); }
    public Flock_EolParserRules.nativeType_return nativeType() throws RecognitionException { return gEolParserRules.nativeType(); }
    public Flock_EolParserRules.typeName_return typeName() throws RecognitionException { return gEolParserRules.typeName(); }
    public Flock_EolParserRules.expressionStatement_return expressionStatement() throws RecognitionException { return gEolParserRules.expressionStatement(); }
    public Flock_EolParserRules.expressionListOrRange_return expressionListOrRange() throws RecognitionException { return gEolParserRules.expressionListOrRange(); }
    public Flock_EolParserRules.variableDeclarationExpression_return variableDeclarationExpression() throws RecognitionException { return gEolParserRules.variableDeclarationExpression(); }

    public final boolean synpred12_Flock() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred12_Flock_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_importStatement_in_flockModule100 = new BitSet(new long[]{0x0000000000800000L,0x0080000330000000L,0x0000000000480000L});
    public static final BitSet FOLLOW_flockModuleContent_in_flockModule104 = new BitSet(new long[]{0x0000000000800000L,0x0080000230000000L,0x0000000000480000L});
    public static final BitSet FOLLOW_EOF_in_flockModule108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_retyping_in_flockModuleContent132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_deletion_in_flockModuleContent136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_migrateRule_in_flockModuleContent140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_operationDeclarationOrAnnotationBlock_in_flockModuleContent144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_retyping_package_in_retyping155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_retyping_classifier_in_retyping159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_147_in_retyping_package168 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_148_in_retyping_package170 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_retyping_package174 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_149_in_retyping_package176 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_retyping_package180 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_guard_in_retyping_package182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_147_in_retyping_classifier217 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_packagedType_in_retyping_classifier221 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_149_in_retyping_classifier223 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_packagedType_in_retyping_classifier227 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_guard_in_retyping_classifier229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_deletion_package_in_deletion263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_deletion_classifier_in_deletion267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_119_in_deletion_package277 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_148_in_deletion_package279 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_deletion_package283 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_guard_in_deletion_package285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_119_in_deletion_classifier314 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_packagedType_in_deletion_classifier318 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_guard_in_deletion_classifier320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fullRule_in_migrateRule350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ignoringRule_in_migrateRule354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_150_in_fullRule366 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_packagedType_in_fullRule370 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L,0x0000000001800000L});
    public static final BitSet FOLLOW_ignoring_in_fullRule372 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_guard_in_fullRule375 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_89_in_fullRule378 = new BitSet(new long[]{0x0000000000085110L,0x1FF1BFE044000000L,0x0000000000062400L});
    public static final BitSet FOLLOW_block_in_fullRule382 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_90_in_fullRule384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_150_in_ignoringRule426 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_packagedType_in_ignoringRule430 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_ignoring_in_ignoringRule432 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_guard_in_ignoringRule434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_151_in_ignoring469 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_propertyList_in_ignoring471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_propertyList495 = new BitSet(new long[]{0x0000000000000002L,0x0000000000400000L});
    public static final BitSet FOLLOW_86_in_propertyList498 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_propertyList500 = new BitSet(new long[]{0x0000000000000002L,0x0000000000400000L});
    public static final BitSet FOLLOW_152_in_guard521 = new BitSet(new long[]{0x0000000000000000L,0x0000000002200000L});
    public static final BitSet FOLLOW_expressionOrStatementBlock_in_guard523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fullRule_in_synpred12_Flock350 = new BitSet(new long[]{0x0000000000000002L});

}