// $ANTLR 3.1b1 /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g 2014-07-05 20:54:23

package org.eclipse.epsilon.flock.parse;

import java.net.URI;
import org.eclipse.epsilon.common.parse.EpsilonTreeAdaptor;
import org.eclipse.epsilon.common.parse.AST;


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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "FLOAT", "DIGIT", "EXPONENT", "FLOAT_TYPE_SUFFIX", "INT", "POINT", "POINT_POINT", "ARROW", "BOOLEAN", "EscapeSequence", "STRING", "StrangeNameLiteral", "Letter", "SpecialNameChar", "JavaIDDigit", "NAME", "WS", "COMMENT", "LINE_COMMENT", "Annotation", "FORMAL", "PARAMLIST", "ASSIGNMENT", "SPECIAL_ASSIGNMENT", "HELPERMETHOD", "StatementBlock", "FOR", "IF", "ELSE", "WHILE", "SWITCH", "CASE", "DEFAULT", "RETURN", "BREAK", "BREAKALL", "CONTINUE", "TRANSACTION", "COLLECTION", "ABORT", "CollectionType", "ModelElementType", "PARAMETERS", "NewExpression", "VAR", "NEW", "ANNOTATIONBLOCK", "EXECUTABLEANNOTATION", "DELETE", "THROW", "EXPRLIST", "EXPRRANGE", "NativeType", "MultiplicativeExpression", "OPERATOR", "EXPRESSIONINBRACKETS", "FeatureCall", "EOLMODULE", "BLOCK", "FEATURECALL", "TYPE", "ENUMERATION_VALUE", "IMPORT", "MODELDECLARATION", "NAMESPACE", "ALIAS", "DRIVER", "MODELDECLARATIONPARAMETERS", "MODELDECLARATIONPARAMETER", "ITEMSELECTOR", "MAP", "KEYVAL", "KEYVALLIST", "PRE", "POST", "EXTENDS", "GUARD", "FLOCKMODULE", "RETYPE", "RETYPEPACKAGE", "DELETEPACKAGE", "MIGRATE", "IGNORING", "'model'", "';'", "'alias'", "','", "'driver'", "'{'", "'}'", "'='", "'operation'", "'function'", "'('", "')'", "':'", "'import'", "'$'", "'!'", "'#'", "'::'", "'Native'", "'Collection'", "'Sequence'", "'List'", "'Bag'", "'Set'", "'OrderedSet'", "'Map'", "'for'", "'in'", "'if'", "'switch'", "'case'", "'default'", "'else'", "'while'", "'return'", "'throw'", "'delete'", "'break'", "'breakAll'", "'continue'", "'abort'", "'transaction'", "':='", "'::='", "'or'", "'and'", "'xor'", "'implies'", "'=='", "'>'", "'<'", "'>='", "'<='", "'<>'", "'+'", "'-'", "'*'", "'/'", "'not'", "'['", "']'", "'|'", "'new'", "'var'", "'pre'", "'post'", "'guard'", "'extends'", "'retype'", "'package'", "'to'", "'migrate'", "'ignoring'", "'when'"
    };
    public static final int T__144=144;
    public static final int T__143=143;
    public static final int T__146=146;
    public static final int MODELDECLARATIONPARAMETER=72;
    public static final int T__145=145;
    public static final int BREAKALL=39;
    public static final int T__140=140;
    public static final int T__142=142;
    public static final int VAR=48;
    public static final int MODELDECLARATIONPARAMETERS=71;
    public static final int T__141=141;
    public static final int THROW=53;
    public static final int RETYPE=82;
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
    public static final int TYPE=64;
    public static final int T__139=139;
    public static final int T__138=138;
    public static final int T__133=133;
    public static final int T__132=132;
    public static final int T__135=135;
    public static final int T__134=134;
    public static final int T__131=131;
    public static final int NewExpression=47;
    public static final int T__130=130;
    public static final int DELETEPACKAGE=84;
    public static final int CASE=35;
    public static final int Letter=16;
    public static final int LINE_COMMENT=22;
    public static final int T__129=129;
    public static final int T__126=126;
    public static final int JavaIDDigit=18;
    public static final int T__125=125;
    public static final int MAP=74;
    public static final int T__128=128;
    public static final int T__127=127;
    public static final int MODELDECLARATION=67;
    public static final int EXPRESSIONINBRACKETS=59;
    public static final int T__160=160;
    public static final int TRANSACTION=41;
    public static final int FLOAT_TYPE_SUFFIX=7;
    public static final int ITEMSELECTOR=73;
    public static final int COMMENT=21;
    public static final int ModelElementType=45;
    public static final int IMPORT=66;
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
    public static final int MIGRATE=85;
    public static final int Annotation=23;
    public static final int CONTINUE=40;
    public static final int ENUMERATION_VALUE=65;
    public static final int OPERATOR=58;
    public static final int EXPONENT=6;
    public static final int STRING=14;
    public static final int T__148=148;
    public static final int T__147=147;
    public static final int T__149=149;
    public static final int T__91=91;
    public static final int T__100=100;
    public static final int NAMESPACE=68;
    public static final int T__92=92;
    public static final int COLLECTION=42;
    public static final int NEW=49;
    public static final int EXTENDS=79;
    public static final int T__93=93;
    public static final int T__102=102;
    public static final int PRE=77;
    public static final int T__94=94;
    public static final int T__101=101;
    public static final int POST=78;
    public static final int T__90=90;
    public static final int ALIAS=69;
    public static final int DRIVER=70;
    public static final int KEYVAL=75;
    public static final int POINT_POINT=10;
    public static final int GUARD=80;
    public static final int T__99=99;
    public static final int T__95=95;
    public static final int HELPERMETHOD=28;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int StatementBlock=29;
    public static final int T__98=98;
    public static final int ABORT=43;
    public static final int StrangeNameLiteral=15;
    public static final int IGNORING=86;
    public static final int FOR=30;
    public static final int BLOCK=62;
    public static final int FLOCKMODULE=81;
    public static final int RETYPEPACKAGE=83;
    public static final int PARAMETERS=46;
    public static final int SpecialNameChar=17;
    public static final int BOOLEAN=12;
    public static final int NAME=19;
    public static final int SWITCH=34;
    public static final int FeatureCall=60;
    public static final int T__122=122;
    public static final int T__121=121;
    public static final int T__124=124;
    public static final int FLOAT=4;
    public static final int T__123=123;
    public static final int T__120=120;
    public static final int NativeType=56;
    public static final int INT=8;
    public static final int ANNOTATIONBLOCK=50;
    public static final int RETURN=37;
    public static final int KEYVALLIST=76;
    public static final int FEATURECALL=63;
    public static final int CollectionType=44;
    public static final int T__119=119;
    public static final int ASSIGNMENT=26;
    public static final int T__118=118;
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
    public static final int T__88=88;
    public static final int T__108=108;
    public static final int T__89=89;
    public static final int T__107=107;
    public static final int WHILE=33;
    public static final int T__109=109;
    public static final int T__104=104;
    public static final int POINT=9;
    public static final int T__103=103;
    public static final int T__106=106;
    public static final int DEFAULT=36;
    public static final int T__87=87;
    public static final int T__105=105;

    // delegates
    public Flock_EolParserRules gEolParserRules;
    public Flock_ErlParserRules gErlParserRules;
    // delegators


        public FlockParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public FlockParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
            gEolParserRules = new Flock_EolParserRules(input, state, this);
            gErlParserRules = new Flock_ErlParserRules(input, state, this);
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return FlockParser.tokenNames; }
    public String getGrammarFileName() { return "/Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g"; }


    	@Override
    	public void prepareForGUnit() {
    		super.prepareForGUnit();
    		this.setDeepTreeAdaptor(new EpsilonTreeAdaptor((URI) null) {
    			@Override
    		    public Object errorNode(TokenStream arg0, Token token, Token arg2,
    		    		RecognitionException arg3) {
    		    	AST ast = new AST(arg2, uri);
    		    	return ast;
    		    }
    		});
    		gEolParserRules.prepareForGUnit();
    	}


    public static class flockModule_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start flockModule
    // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:114:1: flockModule : ( importStatement )* ( modelDeclaration )* ( flockModuleContent )* EOF -> ^( FLOCKMODULE ( importStatement )* ( modelDeclaration )* ( flockModuleContent )* ) ;
    public final FlockParser.flockModule_return flockModule() throws RecognitionException {
        FlockParser.flockModule_return retval = new FlockParser.flockModule_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token EOF4=null;
        Flock_EolParserRules.importStatement_return importStatement1 = null;

        Flock_EolParserRules.modelDeclaration_return modelDeclaration2 = null;

        FlockParser.flockModuleContent_return flockModuleContent3 = null;


        org.eclipse.epsilon.common.parse.AST EOF4_tree=null;
        RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
        RewriteRuleSubtreeStream stream_modelDeclaration=new RewriteRuleSubtreeStream(adaptor,"rule modelDeclaration");
        RewriteRuleSubtreeStream stream_importStatement=new RewriteRuleSubtreeStream(adaptor,"rule importStatement");
        RewriteRuleSubtreeStream stream_flockModuleContent=new RewriteRuleSubtreeStream(adaptor,"rule flockModuleContent");
        try {
            // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:115:2: ( ( importStatement )* ( modelDeclaration )* ( flockModuleContent )* EOF -> ^( FLOCKMODULE ( importStatement )* ( modelDeclaration )* ( flockModuleContent )* ) )
            // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:115:4: ( importStatement )* ( modelDeclaration )* ( flockModuleContent )* EOF
            {
            // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:115:4: ( importStatement )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==100) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:0:0: importStatement
            	    {
            	    pushFollow(FOLLOW_importStatement_in_flockModule104);
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

            // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:115:21: ( modelDeclaration )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==87) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:0:0: modelDeclaration
            	    {
            	    pushFollow(FOLLOW_modelDeclaration_in_flockModule107);
            	    modelDeclaration2=modelDeclaration();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_modelDeclaration.add(modelDeclaration2.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:115:39: ( flockModuleContent )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==Annotation||(LA3_0>=95 && LA3_0<=96)||LA3_0==101||LA3_0==123||(LA3_0>=151 && LA3_0<=152)||LA3_0==155||LA3_0==158) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:115:40: flockModuleContent
            	    {
            	    pushFollow(FOLLOW_flockModuleContent_in_flockModule111);
            	    flockModuleContent3=flockModuleContent();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_flockModuleContent.add(flockModuleContent3.getTree());

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            EOF4=(Token)match(input,EOF,FOLLOW_EOF_in_flockModule115); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EOF.add(EOF4);



            // AST REWRITE
            // elements: modelDeclaration, importStatement, flockModuleContent
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();
            // 116:2: -> ^( FLOCKMODULE ( importStatement )* ( modelDeclaration )* ( flockModuleContent )* )
            {
                // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:116:5: ^( FLOCKMODULE ( importStatement )* ( modelDeclaration )* ( flockModuleContent )* )
                {
                org.eclipse.epsilon.common.parse.AST root_1 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();
                root_1 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot((org.eclipse.epsilon.common.parse.AST)adaptor.create(FLOCKMODULE, "FLOCKMODULE"), root_1);

                // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:116:19: ( importStatement )*
                while ( stream_importStatement.hasNext() ) {
                    adaptor.addChild(root_1, stream_importStatement.nextTree());

                }
                stream_importStatement.reset();
                // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:116:36: ( modelDeclaration )*
                while ( stream_modelDeclaration.hasNext() ) {
                    adaptor.addChild(root_1, stream_modelDeclaration.nextTree());

                }
                stream_modelDeclaration.reset();
                // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:116:54: ( flockModuleContent )*
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
    // $ANTLR end flockModule

    public static class flockModuleContent_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start flockModuleContent
    // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:119:1: flockModuleContent : ( pre | retyping | deletion | migrateRule | operationDeclarationOrAnnotationBlock | post );
    public final FlockParser.flockModuleContent_return flockModuleContent() throws RecognitionException {
        FlockParser.flockModuleContent_return retval = new FlockParser.flockModuleContent_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Flock_ErlParserRules.pre_return pre5 = null;

        FlockParser.retyping_return retyping6 = null;

        FlockParser.deletion_return deletion7 = null;

        FlockParser.migrateRule_return migrateRule8 = null;

        Flock_EolParserRules.operationDeclarationOrAnnotationBlock_return operationDeclarationOrAnnotationBlock9 = null;

        Flock_ErlParserRules.post_return post10 = null;



        try {
            // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:120:2: ( pre | retyping | deletion | migrateRule | operationDeclarationOrAnnotationBlock | post )
            int alt4=6;
            switch ( input.LA(1) ) {
            case 151:
                {
                alt4=1;
                }
                break;
            case 155:
                {
                alt4=2;
                }
                break;
            case 123:
                {
                alt4=3;
                }
                break;
            case 158:
                {
                alt4=4;
                }
                break;
            case Annotation:
            case 95:
            case 96:
            case 101:
                {
                alt4=5;
                }
                break;
            case 152:
                {
                alt4=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:120:4: pre
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_pre_in_flockModuleContent142);
                    pre5=pre();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pre5.getTree());

                    }
                    break;
                case 2 :
                    // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:120:10: retyping
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_retyping_in_flockModuleContent146);
                    retyping6=retyping();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, retyping6.getTree());

                    }
                    break;
                case 3 :
                    // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:120:21: deletion
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_deletion_in_flockModuleContent150);
                    deletion7=deletion();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, deletion7.getTree());

                    }
                    break;
                case 4 :
                    // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:120:32: migrateRule
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_migrateRule_in_flockModuleContent154);
                    migrateRule8=migrateRule();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, migrateRule8.getTree());

                    }
                    break;
                case 5 :
                    // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:120:46: operationDeclarationOrAnnotationBlock
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_operationDeclarationOrAnnotationBlock_in_flockModuleContent158);
                    operationDeclarationOrAnnotationBlock9=operationDeclarationOrAnnotationBlock();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, operationDeclarationOrAnnotationBlock9.getTree());

                    }
                    break;
                case 6 :
                    // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:120:86: post
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_post_in_flockModuleContent162);
                    post10=post();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, post10.getTree());

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
    // $ANTLR end flockModuleContent

    public static class retyping_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start retyping
    // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:123:1: retyping : ( retyping_package | retyping_classifier );
    public final FlockParser.retyping_return retyping() throws RecognitionException {
        FlockParser.retyping_return retval = new FlockParser.retyping_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        FlockParser.retyping_package_return retyping_package11 = null;

        FlockParser.retyping_classifier_return retyping_classifier12 = null;



        try {
            // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:124:2: ( retyping_package | retyping_classifier )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==155) ) {
                int LA5_1 = input.LA(2);

                if ( (LA5_1==156) ) {
                    alt5=1;
                }
                else if ( (LA5_1==NAME) ) {
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
                    // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:124:4: retyping_package
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_retyping_package_in_retyping173);
                    retyping_package11=retyping_package();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, retyping_package11.getTree());

                    }
                    break;
                case 2 :
                    // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:124:23: retyping_classifier
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_retyping_classifier_in_retyping177);
                    retyping_classifier12=retyping_classifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, retyping_classifier12.getTree());

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
    // $ANTLR end retyping

    public static class retyping_package_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start retyping_package
    // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:126:1: retyping_package : rt= 'retype' 'package' originalPackage= NAME 'to' migratedPackage= NAME ( guard )? ;
    public final FlockParser.retyping_package_return retyping_package() throws RecognitionException {
        FlockParser.retyping_package_return retval = new FlockParser.retyping_package_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token rt=null;
        Token originalPackage=null;
        Token migratedPackage=null;
        Token string_literal13=null;
        Token string_literal14=null;
        FlockParser.guard_return guard15 = null;


        org.eclipse.epsilon.common.parse.AST rt_tree=null;
        org.eclipse.epsilon.common.parse.AST originalPackage_tree=null;
        org.eclipse.epsilon.common.parse.AST migratedPackage_tree=null;
        org.eclipse.epsilon.common.parse.AST string_literal13_tree=null;
        org.eclipse.epsilon.common.parse.AST string_literal14_tree=null;

        try {
            // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:127:2: (rt= 'retype' 'package' originalPackage= NAME 'to' migratedPackage= NAME ( guard )? )
            // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:127:4: rt= 'retype' 'package' originalPackage= NAME 'to' migratedPackage= NAME ( guard )?
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            rt=(Token)match(input,155,FOLLOW_155_in_retyping_package188); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            rt_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(rt);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(rt_tree, root_0);
            }
            string_literal13=(Token)match(input,156,FOLLOW_156_in_retyping_package191); if (state.failed) return retval;
            originalPackage=(Token)match(input,NAME,FOLLOW_NAME_in_retyping_package196); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            originalPackage_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(originalPackage);
            adaptor.addChild(root_0, originalPackage_tree);
            }
            string_literal14=(Token)match(input,157,FOLLOW_157_in_retyping_package198); if (state.failed) return retval;
            migratedPackage=(Token)match(input,NAME,FOLLOW_NAME_in_retyping_package203); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            migratedPackage_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(migratedPackage);
            adaptor.addChild(root_0, migratedPackage_tree);
            }
            // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:127:76: ( guard )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==160) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:0:0: guard
                    {
                    pushFollow(FOLLOW_guard_in_retyping_package205);
                    guard15=guard();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, guard15.getTree());

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              rt.setType(RETYPEPACKAGE); rt.setText("RETYPEPACKAGE");
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
    // $ANTLR end retyping_package

    public static class retyping_classifier_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start retyping_classifier
    // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:131:1: retyping_classifier : rt= 'retype' originalType= packagedType 'to' migratedType= packagedType ( guard )? ;
    public final FlockParser.retyping_classifier_return retyping_classifier() throws RecognitionException {
        FlockParser.retyping_classifier_return retval = new FlockParser.retyping_classifier_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token rt=null;
        Token string_literal16=null;
        Flock_EolParserRules.packagedType_return originalType = null;

        Flock_EolParserRules.packagedType_return migratedType = null;

        FlockParser.guard_return guard17 = null;


        org.eclipse.epsilon.common.parse.AST rt_tree=null;
        org.eclipse.epsilon.common.parse.AST string_literal16_tree=null;

        try {
            // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:132:2: (rt= 'retype' originalType= packagedType 'to' migratedType= packagedType ( guard )? )
            // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:132:4: rt= 'retype' originalType= packagedType 'to' migratedType= packagedType ( guard )?
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            rt=(Token)match(input,155,FOLLOW_155_in_retyping_classifier229); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            rt_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(rt);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(rt_tree, root_0);
            }
            pushFollow(FOLLOW_packagedType_in_retyping_classifier234);
            originalType=packagedType();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, originalType.getTree());
            string_literal16=(Token)match(input,157,FOLLOW_157_in_retyping_classifier236); if (state.failed) return retval;
            pushFollow(FOLLOW_packagedType_in_retyping_classifier241);
            migratedType=packagedType();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, migratedType.getTree());
            // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:132:75: ( guard )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==160) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:0:0: guard
                    {
                    pushFollow(FOLLOW_guard_in_retyping_classifier243);
                    guard17=guard();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, guard17.getTree());

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              rt.setType(RETYPE); rt.setText("RETYPE");
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
    // $ANTLR end retyping_classifier

    public static class deletion_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start deletion
    // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:136:1: deletion : ( deletion_package | deletion_classifier );
    public final FlockParser.deletion_return deletion() throws RecognitionException {
        FlockParser.deletion_return retval = new FlockParser.deletion_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        FlockParser.deletion_package_return deletion_package18 = null;

        FlockParser.deletion_classifier_return deletion_classifier19 = null;



        try {
            // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:137:2: ( deletion_package | deletion_classifier )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==123) ) {
                int LA8_1 = input.LA(2);

                if ( (LA8_1==156) ) {
                    alt8=1;
                }
                else if ( (LA8_1==NAME) ) {
                    alt8=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:137:4: deletion_package
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_deletion_package_in_deletion264);
                    deletion_package18=deletion_package();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, deletion_package18.getTree());

                    }
                    break;
                case 2 :
                    // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:137:23: deletion_classifier
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_deletion_classifier_in_deletion268);
                    deletion_classifier19=deletion_classifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, deletion_classifier19.getTree());

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
    // $ANTLR end deletion

    public static class deletion_package_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start deletion_package
    // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:139:1: deletion_package : del= 'delete' 'package' pkg= NAME ( guard )? ;
    public final FlockParser.deletion_package_return deletion_package() throws RecognitionException {
        FlockParser.deletion_package_return retval = new FlockParser.deletion_package_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token del=null;
        Token pkg=null;
        Token string_literal20=null;
        FlockParser.guard_return guard21 = null;


        org.eclipse.epsilon.common.parse.AST del_tree=null;
        org.eclipse.epsilon.common.parse.AST pkg_tree=null;
        org.eclipse.epsilon.common.parse.AST string_literal20_tree=null;

        try {
            // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:140:3: (del= 'delete' 'package' pkg= NAME ( guard )? )
            // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:140:5: del= 'delete' 'package' pkg= NAME ( guard )?
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            del=(Token)match(input,123,FOLLOW_123_in_deletion_package280); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            del_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(del);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(del_tree, root_0);
            }
            string_literal20=(Token)match(input,156,FOLLOW_156_in_deletion_package283); if (state.failed) return retval;
            pkg=(Token)match(input,NAME,FOLLOW_NAME_in_deletion_package288); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            pkg_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(pkg);
            adaptor.addChild(root_0, pkg_tree);
            }
            // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:140:39: ( guard )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==160) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:0:0: guard
                    {
                    pushFollow(FOLLOW_guard_in_deletion_package290);
                    guard21=guard();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, guard21.getTree());

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              del.setType(DELETEPACKAGE); del.setText("DELETEPACKAGE");
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
    // $ANTLR end deletion_package

    public static class deletion_classifier_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start deletion_classifier
    // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:144:1: deletion_classifier : del= 'delete' type= packagedType ( guard )? ;
    public final FlockParser.deletion_classifier_return deletion_classifier() throws RecognitionException {
        FlockParser.deletion_classifier_return retval = new FlockParser.deletion_classifier_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token del=null;
        Flock_EolParserRules.packagedType_return type = null;

        FlockParser.guard_return guard22 = null;


        org.eclipse.epsilon.common.parse.AST del_tree=null;

        try {
            // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:145:3: (del= 'delete' type= packagedType ( guard )? )
            // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:145:5: del= 'delete' type= packagedType ( guard )?
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            del=(Token)match(input,123,FOLLOW_123_in_deletion_classifier313); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            del_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(del);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(del_tree, root_0);
            }
            pushFollow(FOLLOW_packagedType_in_deletion_classifier318);
            type=packagedType();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, type.getTree());
            // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:145:37: ( guard )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==160) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:0:0: guard
                    {
                    pushFollow(FOLLOW_guard_in_deletion_classifier320);
                    guard22=guard();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, guard22.getTree());

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              del.setType(DELETE); del.setText("DELETE");
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
    // $ANTLR end deletion_classifier

    public static class migrateRule_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start migrateRule
    // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:150:1: migrateRule : ( fullRule | ignoringRule );
    public final FlockParser.migrateRule_return migrateRule() throws RecognitionException {
        FlockParser.migrateRule_return retval = new FlockParser.migrateRule_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        FlockParser.fullRule_return fullRule23 = null;

        FlockParser.ignoringRule_return ignoringRule24 = null;



        try {
            // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:151:3: ( fullRule | ignoringRule )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==158) ) {
                int LA11_1 = input.LA(2);

                if ( (synpred15_Flock()) ) {
                    alt11=1;
                }
                else if ( (true) ) {
                    alt11=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:151:5: fullRule
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_fullRule_in_migrateRule342);
                    fullRule23=fullRule();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, fullRule23.getTree());

                    }
                    break;
                case 2 :
                    // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:151:16: ignoringRule
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_ignoringRule_in_migrateRule346);
                    ignoringRule24=ignoringRule();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, ignoringRule24.getTree());

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
    // $ANTLR end migrateRule

    public static class fullRule_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start fullRule
    // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:153:1: fullRule : mig= 'migrate' originalType= packagedType ( ignoring )? ( guard )? ob= '{' body= block cb= '}' ;
    public final FlockParser.fullRule_return fullRule() throws RecognitionException {
        FlockParser.fullRule_return retval = new FlockParser.fullRule_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token mig=null;
        Token ob=null;
        Token cb=null;
        Flock_EolParserRules.packagedType_return originalType = null;

        Flock_EolParserRules.block_return body = null;

        FlockParser.ignoring_return ignoring25 = null;

        FlockParser.guard_return guard26 = null;


        org.eclipse.epsilon.common.parse.AST mig_tree=null;
        org.eclipse.epsilon.common.parse.AST ob_tree=null;
        org.eclipse.epsilon.common.parse.AST cb_tree=null;

        try {
            // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:158:3: (mig= 'migrate' originalType= packagedType ( ignoring )? ( guard )? ob= '{' body= block cb= '}' )
            // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:158:5: mig= 'migrate' originalType= packagedType ( ignoring )? ( guard )? ob= '{' body= block cb= '}'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            mig=(Token)match(input,158,FOLLOW_158_in_fullRule367); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            mig_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(mig);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(mig_tree, root_0);
            }
            pushFollow(FOLLOW_packagedType_in_fullRule372);
            originalType=packagedType();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, originalType.getTree());
            // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:158:46: ( ignoring )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==159) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:0:0: ignoring
                    {
                    pushFollow(FOLLOW_ignoring_in_fullRule374);
                    ignoring25=ignoring();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, ignoring25.getTree());

                    }
                    break;

            }

            // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:158:56: ( guard )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==160) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:0:0: guard
                    {
                    pushFollow(FOLLOW_guard_in_fullRule377);
                    guard26=guard();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, guard26.getTree());

                    }
                    break;

            }

            ob=(Token)match(input,92,FOLLOW_92_in_fullRule382); if (state.failed) return retval;
            pushFollow(FOLLOW_block_in_fullRule387);
            body=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, body.getTree());
            cb=(Token)match(input,93,FOLLOW_93_in_fullRule391); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
              mig.setType(MIGRATE); mig.setText("MIGRATE");
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
    // $ANTLR end fullRule

    public static class ignoringRule_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ignoringRule
    // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:162:1: ignoringRule : mig= 'migrate' originalType= packagedType ignoring ( guard )? ;
    public final FlockParser.ignoringRule_return ignoringRule() throws RecognitionException {
        FlockParser.ignoringRule_return retval = new FlockParser.ignoringRule_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token mig=null;
        Flock_EolParserRules.packagedType_return originalType = null;

        FlockParser.ignoring_return ignoring27 = null;

        FlockParser.guard_return guard28 = null;


        org.eclipse.epsilon.common.parse.AST mig_tree=null;

        try {
            // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:163:3: (mig= 'migrate' originalType= packagedType ignoring ( guard )? )
            // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:163:5: mig= 'migrate' originalType= packagedType ignoring ( guard )?
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            mig=(Token)match(input,158,FOLLOW_158_in_ignoringRule419); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            mig_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(mig);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(mig_tree, root_0);
            }
            pushFollow(FOLLOW_packagedType_in_ignoringRule424);
            originalType=packagedType();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, originalType.getTree());
            pushFollow(FOLLOW_ignoring_in_ignoringRule426);
            ignoring27=ignoring();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, ignoring27.getTree());
            // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:163:55: ( guard )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==160) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:0:0: guard
                    {
                    pushFollow(FOLLOW_guard_in_ignoringRule428);
                    guard28=guard();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, guard28.getTree());

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              mig.setType(MIGRATE); mig.setText("MIGRATE");
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
    // $ANTLR end ignoringRule

    public static class ignoring_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ignoring
    // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:167:1: ignoring : ign= 'ignoring' propertyList ;
    public final FlockParser.ignoring_return ignoring() throws RecognitionException {
        FlockParser.ignoring_return retval = new FlockParser.ignoring_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token ign=null;
        FlockParser.propertyList_return propertyList29 = null;


        org.eclipse.epsilon.common.parse.AST ign_tree=null;

        try {
            // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:168:3: (ign= 'ignoring' propertyList )
            // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:168:5: ign= 'ignoring' propertyList
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            ign=(Token)match(input,159,FOLLOW_159_in_ignoring452); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ign_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(ign);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(ign_tree, root_0);
            }
            pushFollow(FOLLOW_propertyList_in_ignoring455);
            propertyList29=propertyList();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, propertyList29.getTree());
            if ( state.backtracking==0 ) {
              ign.setType(IGNORING); ign.setText("IGNORING");
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
    // $ANTLR end ignoring

    public static class propertyList_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start propertyList
    // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:172:1: propertyList : NAME ( ',' NAME )* -> ( NAME )* ;
    public final FlockParser.propertyList_return propertyList() throws RecognitionException {
        FlockParser.propertyList_return retval = new FlockParser.propertyList_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token NAME30=null;
        Token char_literal31=null;
        Token NAME32=null;

        org.eclipse.epsilon.common.parse.AST NAME30_tree=null;
        org.eclipse.epsilon.common.parse.AST char_literal31_tree=null;
        org.eclipse.epsilon.common.parse.AST NAME32_tree=null;
        RewriteRuleTokenStream stream_90=new RewriteRuleTokenStream(adaptor,"token 90");
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");

        try {
            // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:173:3: ( NAME ( ',' NAME )* -> ( NAME )* )
            // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:173:5: NAME ( ',' NAME )*
            {
            NAME30=(Token)match(input,NAME,FOLLOW_NAME_in_propertyList475); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(NAME30);

            // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:173:10: ( ',' NAME )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==90) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:173:11: ',' NAME
            	    {
            	    char_literal31=(Token)match(input,90,FOLLOW_90_in_propertyList478); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_90.add(char_literal31);

            	    NAME32=(Token)match(input,NAME,FOLLOW_NAME_in_propertyList480); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_NAME.add(NAME32);


            	    }
            	    break;

            	default :
            	    break loop15;
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

            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();
            // 174:3: -> ( NAME )*
            {
                // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:175:3: ( NAME )*
                while ( stream_NAME.hasNext() ) {
                    adaptor.addChild(root_0, stream_NAME.nextNode());

                }
                stream_NAME.reset();

            }

            retval.tree = root_0;retval.tree = root_0;}
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
    // $ANTLR end propertyList

    public static class guard_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start guard
    // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:177:1: guard : w= 'when' expressionOrStatementBlock ;
    public final FlockParser.guard_return guard() throws RecognitionException {
        FlockParser.guard_return retval = new FlockParser.guard_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token w=null;
        Flock_EolParserRules.expressionOrStatementBlock_return expressionOrStatementBlock33 = null;


        org.eclipse.epsilon.common.parse.AST w_tree=null;

        try {
            // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:178:3: (w= 'when' expressionOrStatementBlock )
            // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:178:5: w= 'when' expressionOrStatementBlock
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            w=(Token)match(input,160,FOLLOW_160_in_guard503); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            w_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(w);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(w_tree, root_0);
            }
            pushFollow(FOLLOW_expressionOrStatementBlock_in_guard506);
            expressionOrStatementBlock33=expressionOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionOrStatementBlock33.getTree());
            if ( state.backtracking==0 ) {
              w.setType(GUARD);  w.setText("GUARD");
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
    // $ANTLR end guard

    // $ANTLR start synpred15_Flock
    public final void synpred15_Flock_fragment() throws RecognitionException {   
        // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:151:5: ( fullRule )
        // /Users/dkolovos/Projects/Eclipse/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:151:5: fullRule
        {
        pushFollow(FOLLOW_fullRule_in_synpred15_Flock342);
        fullRule();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred15_Flock

    // Delegated rules
    public Flock_EolParserRules.logicalExpressionInBrackets_return logicalExpressionInBrackets() throws RecognitionException { return gEolParserRules.logicalExpressionInBrackets(); }
    public Flock_EolParserRules.importStatement_return importStatement() throws RecognitionException { return gEolParserRules.importStatement(); }
    public Flock_EolParserRules.transactionStatement_return transactionStatement() throws RecognitionException { return gEolParserRules.transactionStatement(); }
    public Flock_EolParserRules.ifStatement_return ifStatement() throws RecognitionException { return gEolParserRules.ifStatement(); }
    public Flock_EolParserRules.modelDeclarationParameter_return modelDeclarationParameter() throws RecognitionException { return gEolParserRules.modelDeclarationParameter(); }
    public Flock_EolParserRules.additiveExpression_return additiveExpression() throws RecognitionException { return gEolParserRules.additiveExpression(); }
    public Flock_EolParserRules.featureCall_return featureCall() throws RecognitionException { return gEolParserRules.featureCall(); }
    public Flock_EolParserRules.executableAnnotation_return executableAnnotation() throws RecognitionException { return gEolParserRules.executableAnnotation(); }
    public Flock_EolParserRules.keyvalExpressionList_return keyvalExpressionList() throws RecognitionException { return gEolParserRules.keyvalExpressionList(); }
    public Flock_EolParserRules.collectionType_return collectionType() throws RecognitionException { return gEolParserRules.collectionType(); }
    public Flock_EolParserRules.annotationBlock_return annotationBlock() throws RecognitionException { return gEolParserRules.annotationBlock(); }
    public Flock_EolParserRules.statementA_return statementA() throws RecognitionException { return gEolParserRules.statementA(); }
    public Flock_EolParserRules.relationalExpression_return relationalExpression() throws RecognitionException { return gEolParserRules.relationalExpression(); }
    public Flock_EolParserRules.simpleFeatureCall_return simpleFeatureCall() throws RecognitionException { return gEolParserRules.simpleFeatureCall(); }
    public Flock_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock() throws RecognitionException { return gEolParserRules.statementOrStatementBlock(); }
    public Flock_EolParserRules.operationDeclaration_return operationDeclaration() throws RecognitionException { return gEolParserRules.operationDeclaration(); }
    public Flock_EolParserRules.primitiveExpression_return primitiveExpression() throws RecognitionException { return gEolParserRules.primitiveExpression(); }
    public Flock_EolParserRules.modelDriver_return modelDriver() throws RecognitionException { return gEolParserRules.modelDriver(); }
    public Flock_EolParserRules.declarativeFeatureCall_return declarativeFeatureCall() throws RecognitionException { return gEolParserRules.declarativeFeatureCall(); }
    public Flock_EolParserRules.itemSelectorExpression_return itemSelectorExpression() throws RecognitionException { return gEolParserRules.itemSelectorExpression(); }
    public Flock_EolParserRules.throwStatement_return throwStatement() throws RecognitionException { return gEolParserRules.throwStatement(); }
    public Flock_EolParserRules.variableDeclarationExpression_return variableDeclarationExpression() throws RecognitionException { return gEolParserRules.variableDeclarationExpression(); }
    public Flock_EolParserRules.statementB_return statementB() throws RecognitionException { return gEolParserRules.statementB(); }
    public Flock_EolParserRules.caseStatement_return caseStatement() throws RecognitionException { return gEolParserRules.caseStatement(); }
    public Flock_EolParserRules.whileStatement_return whileStatement() throws RecognitionException { return gEolParserRules.whileStatement(); }
    public Flock_EolParserRules.returnStatement_return returnStatement() throws RecognitionException { return gEolParserRules.returnStatement(); }
    public Flock_ErlParserRules.extendz_return extendz() throws RecognitionException { return gErlParserRules.extendz(); }
    public Flock_EolParserRules.expressionStatement_return expressionStatement() throws RecognitionException { return gEolParserRules.expressionStatement(); }
    public Flock_EolParserRules.modelDeclarationParameters_return modelDeclarationParameters() throws RecognitionException { return gEolParserRules.modelDeclarationParameters(); }
    public Flock_EolParserRules.multiplicativeExpression_return multiplicativeExpression() throws RecognitionException { return gEolParserRules.multiplicativeExpression(); }
    public Flock_EolParserRules.keyvalExpression_return keyvalExpression() throws RecognitionException { return gEolParserRules.keyvalExpression(); }
    public Flock_EolParserRules.forStatement_return forStatement() throws RecognitionException { return gEolParserRules.forStatement(); }
    public Flock_EolParserRules.expressionOrStatementBlock_return expressionOrStatementBlock() throws RecognitionException { return gEolParserRules.expressionOrStatementBlock(); }
    public Flock_EolParserRules.pathName_return pathName() throws RecognitionException { return gEolParserRules.pathName(); }
    public Flock_EolParserRules.postfixExpression_return postfixExpression() throws RecognitionException { return gEolParserRules.postfixExpression(); }
    public Flock_EolParserRules.expressionRange_return expressionRange() throws RecognitionException { return gEolParserRules.expressionRange(); }
    public Flock_EolParserRules.switchStatement_return switchStatement() throws RecognitionException { return gEolParserRules.switchStatement(); }
    public Flock_EolParserRules.expressionListOrRange_return expressionListOrRange() throws RecognitionException { return gEolParserRules.expressionListOrRange(); }
    public Flock_EolParserRules.assignmentStatement_return assignmentStatement() throws RecognitionException { return gEolParserRules.assignmentStatement(); }
    public Flock_EolParserRules.logicalExpression_return logicalExpression() throws RecognitionException { return gEolParserRules.logicalExpression(); }
    public Flock_EolParserRules.formalParameter_return formalParameter() throws RecognitionException { return gEolParserRules.formalParameter(); }
    public Flock_EolParserRules.nativeType_return nativeType() throws RecognitionException { return gEolParserRules.nativeType(); }
    public Flock_EolParserRules.modelAlias_return modelAlias() throws RecognitionException { return gEolParserRules.modelAlias(); }
    public Flock_EolParserRules.literalMapCollection_return literalMapCollection() throws RecognitionException { return gEolParserRules.literalMapCollection(); }
    public Flock_EolParserRules.newExpression_return newExpression() throws RecognitionException { return gEolParserRules.newExpression(); }
    public Flock_ErlParserRules.pre_return pre() throws RecognitionException { return gErlParserRules.pre(); }
    public Flock_EolParserRules.statementBlock_return statementBlock() throws RecognitionException { return gEolParserRules.statementBlock(); }
    public Flock_ErlParserRules.post_return post() throws RecognitionException { return gErlParserRules.post(); }
    public Flock_EolParserRules.literalSequentialCollection_return literalSequentialCollection() throws RecognitionException { return gEolParserRules.literalSequentialCollection(); }
    public Flock_EolParserRules.abortStatement_return abortStatement() throws RecognitionException { return gEolParserRules.abortStatement(); }
    public Flock_EolParserRules.modelDeclaration_return modelDeclaration() throws RecognitionException { return gEolParserRules.modelDeclaration(); }
    public Flock_EolParserRules.formalParameterList_return formalParameterList() throws RecognitionException { return gEolParserRules.formalParameterList(); }
    public Flock_EolParserRules.deleteStatement_return deleteStatement() throws RecognitionException { return gEolParserRules.deleteStatement(); }
    public Flock_EolParserRules.operationDeclarationOrAnnotationBlock_return operationDeclarationOrAnnotationBlock() throws RecognitionException { return gEolParserRules.operationDeclarationOrAnnotationBlock(); }
    public Flock_EolParserRules.annotation_return annotation() throws RecognitionException { return gEolParserRules.annotation(); }
    public Flock_EolParserRules.typeName_return typeName() throws RecognitionException { return gEolParserRules.typeName(); }
    public Flock_EolParserRules.breakStatement_return breakStatement() throws RecognitionException { return gEolParserRules.breakStatement(); }
    public Flock_EolParserRules.unaryExpression_return unaryExpression() throws RecognitionException { return gEolParserRules.unaryExpression(); }
    public Flock_EolParserRules.block_return block() throws RecognitionException { return gEolParserRules.block(); }
    public Flock_EolParserRules.continueStatement_return continueStatement() throws RecognitionException { return gEolParserRules.continueStatement(); }
    public Flock_EolParserRules.parameterList_return parameterList() throws RecognitionException { return gEolParserRules.parameterList(); }
    public Flock_EolParserRules.statement_return statement() throws RecognitionException { return gEolParserRules.statement(); }
    public Flock_EolParserRules.packagedType_return packagedType() throws RecognitionException { return gEolParserRules.packagedType(); }
    public Flock_EolParserRules.literal_return literal() throws RecognitionException { return gEolParserRules.literal(); }
    public Flock_EolParserRules.defaultStatement_return defaultStatement() throws RecognitionException { return gEolParserRules.defaultStatement(); }
    public Flock_EolParserRules.breakAllStatement_return breakAllStatement() throws RecognitionException { return gEolParserRules.breakAllStatement(); }
    public Flock_EolParserRules.elseStatement_return elseStatement() throws RecognitionException { return gEolParserRules.elseStatement(); }
    public Flock_EolParserRules.expressionList_return expressionList() throws RecognitionException { return gEolParserRules.expressionList(); }

    public final boolean synpred15_Flock() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred15_Flock_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_importStatement_in_flockModule104 = new BitSet(new long[]{0x0000000000800000L,0x0800003180800000L,0x0000000049800000L});
    public static final BitSet FOLLOW_modelDeclaration_in_flockModule107 = new BitSet(new long[]{0x0000000000800000L,0x0800002180800000L,0x0000000049800000L});
    public static final BitSet FOLLOW_flockModuleContent_in_flockModule111 = new BitSet(new long[]{0x0000000000800000L,0x0800002180000000L,0x0000000049800000L});
    public static final BitSet FOLLOW_EOF_in_flockModule115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pre_in_flockModuleContent142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_retyping_in_flockModuleContent146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_deletion_in_flockModuleContent150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_migrateRule_in_flockModuleContent154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_operationDeclarationOrAnnotationBlock_in_flockModuleContent158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_post_in_flockModuleContent162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_retyping_package_in_retyping173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_retyping_classifier_in_retyping177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_155_in_retyping_package188 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_156_in_retyping_package191 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_retyping_package196 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_157_in_retyping_package198 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_retyping_package203 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_guard_in_retyping_package205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_155_in_retyping_classifier229 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_packagedType_in_retyping_classifier234 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_157_in_retyping_classifier236 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_packagedType_in_retyping_classifier241 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_guard_in_retyping_classifier243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_deletion_package_in_deletion264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_deletion_classifier_in_deletion268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_123_in_deletion_package280 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_156_in_deletion_package283 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_deletion_package288 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_guard_in_deletion_package290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_123_in_deletion_classifier313 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_packagedType_in_deletion_classifier318 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_guard_in_deletion_classifier320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fullRule_in_migrateRule342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ignoringRule_in_migrateRule346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_158_in_fullRule367 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_packagedType_in_fullRule372 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L,0x0000000180000000L});
    public static final BitSet FOLLOW_ignoring_in_fullRule374 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_guard_in_fullRule377 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_92_in_fullRule382 = new BitSet(new long[]{0x0000000000085110L,0xFF1BFE0220000000L,0x0000000000624001L});
    public static final BitSet FOLLOW_block_in_fullRule387 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_fullRule391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_158_in_ignoringRule419 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_packagedType_in_ignoringRule424 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_ignoring_in_ignoringRule426 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_guard_in_ignoringRule428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_159_in_ignoring452 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_propertyList_in_ignoring455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_propertyList475 = new BitSet(new long[]{0x0000000000000002L,0x0000000004000000L});
    public static final BitSet FOLLOW_90_in_propertyList478 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_propertyList480 = new BitSet(new long[]{0x0000000000000002L,0x0000000004000000L});
    public static final BitSet FOLLOW_160_in_guard503 = new BitSet(new long[]{0x0000000000000000L,0x0000000810000000L});
    public static final BitSet FOLLOW_expressionOrStatementBlock_in_guard506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fullRule_in_synpred15_Flock342 = new BitSet(new long[]{0x0000000000000002L});

}