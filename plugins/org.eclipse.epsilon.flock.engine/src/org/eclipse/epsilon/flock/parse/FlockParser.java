// $ANTLR 3.1b1 /Users/dimitrioskolovos/Projects/Eclipse/4.2/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g 2013-04-07 23:26:40

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "FLOAT", "DIGIT", "EXPONENT", "FLOAT_TYPE_SUFFIX", "INT", "POINT", "POINT_POINT", "ARROW", "BOOLEAN", "EscapeSequence", "STRING", "StrangeNameLiteral", "Letter", "SpecialNameChar", "JavaIDDigit", "NAME", "WS", "COMMENT", "LINE_COMMENT", "Annotation", "FORMAL", "PARAMLIST", "ASSIGNMENT", "SPECIAL_ASSIGNMENT", "HELPERMETHOD", "StatementBlock", "FOR", "IF", "ELSE", "WHILE", "SWITCH", "CASE", "DEFAULT", "RETURN", "BREAK", "BREAKALL", "CONTINUE", "TRANSACTION", "COLLECTION", "ABORT", "CollectionType", "ModelElementType", "PARAMETERS", "NewExpression", "VAR", "NEW", "ANNOTATIONBLOCK", "EXECUTABLEANNOTATION", "DELETE", "THROW", "EXPRLIST", "EXPRRANGE", "NativeType", "MultiplicativeExpression", "OPERATOR", "FeatureCall", "EOLMODULE", "BLOCK", "FEATURECALL", "TYPE", "ENUMERATION_VALUE", "IMPORT", "MODELDECLARATION", "NAMESPACE", "ALIAS", "DRIVER", "MODELDECLARATIONPARAMETERS", "MODELDECLARATIONPARAMETER", "ITEMSELECTOR", "MAP", "KEYVAL", "KEYVALLIST", "FLOCKMODULE", "RETYPE", "MIGRATE", "GUARD", "IGNORING", "'model'", "';'", "':'", "','", "'alias'", "'driver'", "'{'", "'}'", "'='", "'operation'", "'function'", "'('", "')'", "'import'", "'$'", "'!'", "'#'", "'::'", "'Native'", "'Collection'", "'Sequence'", "'List'", "'Bag'", "'Set'", "'OrderedSet'", "'Map'", "'for'", "'in'", "'if'", "'switch'", "'case'", "'default'", "'else'", "'while'", "'return'", "'throw'", "'delete'", "'break'", "'breakAll'", "'continue'", "'abort'", "'transaction'", "':='", "'::='", "'or'", "'and'", "'xor'", "'implies'", "'=='", "'>'", "'<'", "'>='", "'<='", "'<>'", "'+'", "'-'", "'*'", "'/'", "'not'", "'['", "']'", "'|'", "'new'", "'var'", "'retype'", "'to'", "'migrate'", "'ignoring'", "'when'"
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
    public static final int T__97=97;
    public static final int MultiplicativeExpression=57;
    public static final int T__96=96;
    public static final int T__95=95;
    public static final int FLOAT_TYPE_SUFFIX=7;
    public static final int T__139=139;
    public static final int T__138=138;
    public static final int T__137=137;
    public static final int T__136=136;
    public static final int T__81=81;
    public static final int T__82=82;
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
    public static final int MIGRATE=78;
    public static final int JavaIDDigit=18;
    public static final int GUARD=79;
    public static final int IGNORING=80;
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
    public static final int POINT_POINT=10;
    public static final int SpecialNameChar=17;
    public static final int MODELDECLARATIONPARAMETERS=70;
    public static final int BLOCK=61;
    public static final int MAP=73;
    public static final int FEATURECALL=62;
    public static final int FORMAL=24;
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
    public String getGrammarFileName() { return "/Users/dimitrioskolovos/Projects/Eclipse/4.2/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g"; }


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
    // /Users/dimitrioskolovos/Projects/Eclipse/4.2/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:101:1: flockModule : ( importStatement )* ( flockModuleContent )* EOF -> ^( FLOCKMODULE ( importStatement )* ( flockModuleContent )* ) ;
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
            // /Users/dimitrioskolovos/Projects/Eclipse/4.2/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:102:2: ( ( importStatement )* ( flockModuleContent )* EOF -> ^( FLOCKMODULE ( importStatement )* ( flockModuleContent )* ) )
            // /Users/dimitrioskolovos/Projects/Eclipse/4.2/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:102:4: ( importStatement )* ( flockModuleContent )* EOF
            {
            // /Users/dimitrioskolovos/Projects/Eclipse/4.2/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:102:4: ( importStatement )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==94) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/dimitrioskolovos/Projects/Eclipse/4.2/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:0:0: importStatement
            	    {
            	    pushFollow(FOLLOW_importStatement_in_flockModule94);
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

            // /Users/dimitrioskolovos/Projects/Eclipse/4.2/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:102:21: ( flockModuleContent )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==Annotation||(LA2_0>=90 && LA2_0<=91)||LA2_0==95||LA2_0==117||LA2_0==145||LA2_0==147) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/dimitrioskolovos/Projects/Eclipse/4.2/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:102:22: flockModuleContent
            	    {
            	    pushFollow(FOLLOW_flockModuleContent_in_flockModule98);
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

            EOF3=(Token)match(input,EOF,FOLLOW_EOF_in_flockModule102); if (state.failed) return retval; 
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
                // /Users/dimitrioskolovos/Projects/Eclipse/4.2/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:103:5: ^( FLOCKMODULE ( importStatement )* ( flockModuleContent )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FLOCKMODULE, "FLOCKMODULE"), root_1);

                // /Users/dimitrioskolovos/Projects/Eclipse/4.2/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:103:19: ( importStatement )*
                while ( stream_importStatement.hasNext() ) {
                    adaptor.addChild(root_1, stream_importStatement.nextTree());

                }
                stream_importStatement.reset();
                // /Users/dimitrioskolovos/Projects/Eclipse/4.2/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:103:36: ( flockModuleContent )*
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
    // /Users/dimitrioskolovos/Projects/Eclipse/4.2/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:106:1: flockModuleContent : ( retyping | deletion | migrateRule | operationDeclarationOrAnnotationBlock );
    public final FlockParser.flockModuleContent_return flockModuleContent() throws RecognitionException {
        FlockParser.flockModuleContent_return retval = new FlockParser.flockModuleContent_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        FlockParser.retyping_return retyping4 = null;

        FlockParser.deletion_return deletion5 = null;

        FlockParser.migrateRule_return migrateRule6 = null;

        Flock_EolParserRules.operationDeclarationOrAnnotationBlock_return operationDeclarationOrAnnotationBlock7 = null;



        try {
            // /Users/dimitrioskolovos/Projects/Eclipse/4.2/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:107:2: ( retyping | deletion | migrateRule | operationDeclarationOrAnnotationBlock )
            int alt3=4;
            switch ( input.LA(1) ) {
            case 145:
                {
                alt3=1;
                }
                break;
            case 117:
                {
                alt3=2;
                }
                break;
            case 147:
                {
                alt3=3;
                }
                break;
            case Annotation:
            case 90:
            case 91:
            case 95:
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
                    // /Users/dimitrioskolovos/Projects/Eclipse/4.2/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:107:4: retyping
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_retyping_in_flockModuleContent126);
                    retyping4=retyping();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, retyping4.getTree());

                    }
                    break;
                case 2 :
                    // /Users/dimitrioskolovos/Projects/Eclipse/4.2/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:107:15: deletion
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_deletion_in_flockModuleContent130);
                    deletion5=deletion();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, deletion5.getTree());

                    }
                    break;
                case 3 :
                    // /Users/dimitrioskolovos/Projects/Eclipse/4.2/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:107:26: migrateRule
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_migrateRule_in_flockModuleContent134);
                    migrateRule6=migrateRule();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, migrateRule6.getTree());

                    }
                    break;
                case 4 :
                    // /Users/dimitrioskolovos/Projects/Eclipse/4.2/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:107:40: operationDeclarationOrAnnotationBlock
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_operationDeclarationOrAnnotationBlock_in_flockModuleContent138);
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
    // /Users/dimitrioskolovos/Projects/Eclipse/4.2/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:110:1: retyping : 'retype' originalType= packagedType 'to' migratedType= packagedType ( guard )? -> ^( RETYPE $originalType ( $migratedType)? ( guard )? ) ;
    public final FlockParser.retyping_return retyping() throws RecognitionException {
        FlockParser.retyping_return retval = new FlockParser.retyping_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal8=null;
        Token string_literal9=null;
        Flock_EolParserRules.packagedType_return originalType = null;

        Flock_EolParserRules.packagedType_return migratedType = null;

        FlockParser.guard_return guard10 = null;


        CommonTree string_literal8_tree=null;
        CommonTree string_literal9_tree=null;
        RewriteRuleTokenStream stream_145=new RewriteRuleTokenStream(adaptor,"token 145");
        RewriteRuleTokenStream stream_146=new RewriteRuleTokenStream(adaptor,"token 146");
        RewriteRuleSubtreeStream stream_guard=new RewriteRuleSubtreeStream(adaptor,"rule guard");
        RewriteRuleSubtreeStream stream_packagedType=new RewriteRuleSubtreeStream(adaptor,"rule packagedType");
        try {
            // /Users/dimitrioskolovos/Projects/Eclipse/4.2/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:111:3: ( 'retype' originalType= packagedType 'to' migratedType= packagedType ( guard )? -> ^( RETYPE $originalType ( $migratedType)? ( guard )? ) )
            // /Users/dimitrioskolovos/Projects/Eclipse/4.2/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:111:5: 'retype' originalType= packagedType 'to' migratedType= packagedType ( guard )?
            {
            string_literal8=(Token)match(input,145,FOLLOW_145_in_retyping150); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_145.add(string_literal8);

            pushFollow(FOLLOW_packagedType_in_retyping154);
            originalType=packagedType();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_packagedType.add(originalType.getTree());
            string_literal9=(Token)match(input,146,FOLLOW_146_in_retyping156); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_146.add(string_literal9);

            pushFollow(FOLLOW_packagedType_in_retyping160);
            migratedType=packagedType();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_packagedType.add(migratedType.getTree());
            // /Users/dimitrioskolovos/Projects/Eclipse/4.2/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:111:71: ( guard )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==149) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /Users/dimitrioskolovos/Projects/Eclipse/4.2/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:0:0: guard
                    {
                    pushFollow(FOLLOW_guard_in_retyping162);
                    guard10=guard();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_guard.add(guard10.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: migratedType, originalType, guard
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
            // 112:5: -> ^( RETYPE $originalType ( $migratedType)? ( guard )? )
            {
                // /Users/dimitrioskolovos/Projects/Eclipse/4.2/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:113:5: ^( RETYPE $originalType ( $migratedType)? ( guard )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(RETYPE, "RETYPE"), root_1);

                adaptor.addChild(root_1, stream_originalType.nextTree());
                // /Users/dimitrioskolovos/Projects/Eclipse/4.2/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:113:28: ( $migratedType)?
                if ( stream_migratedType.hasNext() ) {
                    adaptor.addChild(root_1, stream_migratedType.nextTree());

                }
                stream_migratedType.reset();
                // /Users/dimitrioskolovos/Projects/Eclipse/4.2/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:113:43: ( guard )?
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
    // /Users/dimitrioskolovos/Projects/Eclipse/4.2/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:115:1: deletion : 'delete' type= packagedType ( guard )? -> ^( DELETE $type ( guard )? ) ;
    public final FlockParser.deletion_return deletion() throws RecognitionException {
        FlockParser.deletion_return retval = new FlockParser.deletion_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal11=null;
        Flock_EolParserRules.packagedType_return type = null;

        FlockParser.guard_return guard12 = null;


        CommonTree string_literal11_tree=null;
        RewriteRuleTokenStream stream_117=new RewriteRuleTokenStream(adaptor,"token 117");
        RewriteRuleSubtreeStream stream_guard=new RewriteRuleSubtreeStream(adaptor,"rule guard");
        RewriteRuleSubtreeStream stream_packagedType=new RewriteRuleSubtreeStream(adaptor,"rule packagedType");
        try {
            // /Users/dimitrioskolovos/Projects/Eclipse/4.2/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:116:3: ( 'delete' type= packagedType ( guard )? -> ^( DELETE $type ( guard )? ) )
            // /Users/dimitrioskolovos/Projects/Eclipse/4.2/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:116:5: 'delete' type= packagedType ( guard )?
            {
            string_literal11=(Token)match(input,117,FOLLOW_117_in_deletion202); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_117.add(string_literal11);

            pushFollow(FOLLOW_packagedType_in_deletion206);
            type=packagedType();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_packagedType.add(type.getTree());
            // /Users/dimitrioskolovos/Projects/Eclipse/4.2/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:116:32: ( guard )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==149) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /Users/dimitrioskolovos/Projects/Eclipse/4.2/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:0:0: guard
                    {
                    pushFollow(FOLLOW_guard_in_deletion208);
                    guard12=guard();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_guard.add(guard12.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: guard, type
            // token labels: 
            // rule labels: retval, type
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"token type",type!=null?type.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 117:3: -> ^( DELETE $type ( guard )? )
            {
                // /Users/dimitrioskolovos/Projects/Eclipse/4.2/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:118:5: ^( DELETE $type ( guard )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(DELETE, "DELETE"), root_1);

                adaptor.addChild(root_1, stream_type.nextTree());
                // /Users/dimitrioskolovos/Projects/Eclipse/4.2/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:118:20: ( guard )?
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
    // /Users/dimitrioskolovos/Projects/Eclipse/4.2/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:120:1: migrateRule : ( fullRule | ignoringRule );
    public final FlockParser.migrateRule_return migrateRule() throws RecognitionException {
        FlockParser.migrateRule_return retval = new FlockParser.migrateRule_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        FlockParser.fullRule_return fullRule13 = null;

        FlockParser.ignoringRule_return ignoringRule14 = null;



        try {
            // /Users/dimitrioskolovos/Projects/Eclipse/4.2/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:121:3: ( fullRule | ignoringRule )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==147) ) {
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
                    // /Users/dimitrioskolovos/Projects/Eclipse/4.2/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:121:5: fullRule
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_fullRule_in_migrateRule237);
                    fullRule13=fullRule();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, fullRule13.getTree());

                    }
                    break;
                case 2 :
                    // /Users/dimitrioskolovos/Projects/Eclipse/4.2/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:121:16: ignoringRule
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_ignoringRule_in_migrateRule241);
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
    // /Users/dimitrioskolovos/Projects/Eclipse/4.2/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:123:1: fullRule : 'migrate' originalType= packagedType ( ignoring )? ( guard )? '{' body= block '}' -> ^( MIGRATE $originalType ( ignoring )? ( guard )? $body) ;
    public final FlockParser.fullRule_return fullRule() throws RecognitionException {
        FlockParser.fullRule_return retval = new FlockParser.fullRule_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal15=null;
        Token char_literal18=null;
        Token char_literal19=null;
        Flock_EolParserRules.packagedType_return originalType = null;

        Flock_EolParserRules.block_return body = null;

        FlockParser.ignoring_return ignoring16 = null;

        FlockParser.guard_return guard17 = null;


        CommonTree string_literal15_tree=null;
        CommonTree char_literal18_tree=null;
        CommonTree char_literal19_tree=null;
        RewriteRuleTokenStream stream_147=new RewriteRuleTokenStream(adaptor,"token 147");
        RewriteRuleTokenStream stream_87=new RewriteRuleTokenStream(adaptor,"token 87");
        RewriteRuleTokenStream stream_88=new RewriteRuleTokenStream(adaptor,"token 88");
        RewriteRuleSubtreeStream stream_guard=new RewriteRuleSubtreeStream(adaptor,"rule guard");
        RewriteRuleSubtreeStream stream_packagedType=new RewriteRuleSubtreeStream(adaptor,"rule packagedType");
        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        RewriteRuleSubtreeStream stream_ignoring=new RewriteRuleSubtreeStream(adaptor,"rule ignoring");
        try {
            // /Users/dimitrioskolovos/Projects/Eclipse/4.2/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:124:3: ( 'migrate' originalType= packagedType ( ignoring )? ( guard )? '{' body= block '}' -> ^( MIGRATE $originalType ( ignoring )? ( guard )? $body) )
            // /Users/dimitrioskolovos/Projects/Eclipse/4.2/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:124:5: 'migrate' originalType= packagedType ( ignoring )? ( guard )? '{' body= block '}'
            {
            string_literal15=(Token)match(input,147,FOLLOW_147_in_fullRule253); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_147.add(string_literal15);

            pushFollow(FOLLOW_packagedType_in_fullRule257);
            originalType=packagedType();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_packagedType.add(originalType.getTree());
            // /Users/dimitrioskolovos/Projects/Eclipse/4.2/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:124:41: ( ignoring )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==148) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // /Users/dimitrioskolovos/Projects/Eclipse/4.2/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:0:0: ignoring
                    {
                    pushFollow(FOLLOW_ignoring_in_fullRule259);
                    ignoring16=ignoring();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_ignoring.add(ignoring16.getTree());

                    }
                    break;

            }

            // /Users/dimitrioskolovos/Projects/Eclipse/4.2/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:124:51: ( guard )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==149) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // /Users/dimitrioskolovos/Projects/Eclipse/4.2/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:0:0: guard
                    {
                    pushFollow(FOLLOW_guard_in_fullRule262);
                    guard17=guard();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_guard.add(guard17.getTree());

                    }
                    break;

            }

            char_literal18=(Token)match(input,87,FOLLOW_87_in_fullRule265); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_87.add(char_literal18);

            pushFollow(FOLLOW_block_in_fullRule269);
            body=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_block.add(body.getTree());
            char_literal19=(Token)match(input,88,FOLLOW_88_in_fullRule271); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_88.add(char_literal19);



            // AST REWRITE
            // elements: body, guard, ignoring, originalType
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
            // 125:5: -> ^( MIGRATE $originalType ( ignoring )? ( guard )? $body)
            {
                // /Users/dimitrioskolovos/Projects/Eclipse/4.2/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:126:5: ^( MIGRATE $originalType ( ignoring )? ( guard )? $body)
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(MIGRATE, "MIGRATE"), root_1);

                adaptor.addChild(root_1, stream_originalType.nextTree());
                // /Users/dimitrioskolovos/Projects/Eclipse/4.2/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:126:29: ( ignoring )?
                if ( stream_ignoring.hasNext() ) {
                    adaptor.addChild(root_1, stream_ignoring.nextTree());

                }
                stream_ignoring.reset();
                // /Users/dimitrioskolovos/Projects/Eclipse/4.2/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:126:39: ( guard )?
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
    // /Users/dimitrioskolovos/Projects/Eclipse/4.2/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:128:1: ignoringRule : 'migrate' originalType= packagedType ignoring ( guard )? -> ^( MIGRATE $originalType ignoring ( guard )? ) ;
    public final FlockParser.ignoringRule_return ignoringRule() throws RecognitionException {
        FlockParser.ignoringRule_return retval = new FlockParser.ignoringRule_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal20=null;
        Flock_EolParserRules.packagedType_return originalType = null;

        FlockParser.ignoring_return ignoring21 = null;

        FlockParser.guard_return guard22 = null;


        CommonTree string_literal20_tree=null;
        RewriteRuleTokenStream stream_147=new RewriteRuleTokenStream(adaptor,"token 147");
        RewriteRuleSubtreeStream stream_guard=new RewriteRuleSubtreeStream(adaptor,"rule guard");
        RewriteRuleSubtreeStream stream_packagedType=new RewriteRuleSubtreeStream(adaptor,"rule packagedType");
        RewriteRuleSubtreeStream stream_ignoring=new RewriteRuleSubtreeStream(adaptor,"rule ignoring");
        try {
            // /Users/dimitrioskolovos/Projects/Eclipse/4.2/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:129:3: ( 'migrate' originalType= packagedType ignoring ( guard )? -> ^( MIGRATE $originalType ignoring ( guard )? ) )
            // /Users/dimitrioskolovos/Projects/Eclipse/4.2/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:129:5: 'migrate' originalType= packagedType ignoring ( guard )?
            {
            string_literal20=(Token)match(input,147,FOLLOW_147_in_ignoringRule313); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_147.add(string_literal20);

            pushFollow(FOLLOW_packagedType_in_ignoringRule317);
            originalType=packagedType();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_packagedType.add(originalType.getTree());
            pushFollow(FOLLOW_ignoring_in_ignoringRule319);
            ignoring21=ignoring();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_ignoring.add(ignoring21.getTree());
            // /Users/dimitrioskolovos/Projects/Eclipse/4.2/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:129:50: ( guard )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==149) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // /Users/dimitrioskolovos/Projects/Eclipse/4.2/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:0:0: guard
                    {
                    pushFollow(FOLLOW_guard_in_ignoringRule321);
                    guard22=guard();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_guard.add(guard22.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: ignoring, originalType, guard
            // token labels: 
            // rule labels: retval, originalType
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_originalType=new RewriteRuleSubtreeStream(adaptor,"token originalType",originalType!=null?originalType.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 130:5: -> ^( MIGRATE $originalType ignoring ( guard )? )
            {
                // /Users/dimitrioskolovos/Projects/Eclipse/4.2/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:131:5: ^( MIGRATE $originalType ignoring ( guard )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(MIGRATE, "MIGRATE"), root_1);

                adaptor.addChild(root_1, stream_originalType.nextTree());
                adaptor.addChild(root_1, stream_ignoring.nextTree());
                // /Users/dimitrioskolovos/Projects/Eclipse/4.2/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:131:38: ( guard )?
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
    // /Users/dimitrioskolovos/Projects/Eclipse/4.2/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:133:1: ignoring : 'ignoring' propertyList -> ^( IGNORING propertyList ) ;
    public final FlockParser.ignoring_return ignoring() throws RecognitionException {
        FlockParser.ignoring_return retval = new FlockParser.ignoring_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal23=null;
        FlockParser.propertyList_return propertyList24 = null;


        CommonTree string_literal23_tree=null;
        RewriteRuleTokenStream stream_148=new RewriteRuleTokenStream(adaptor,"token 148");
        RewriteRuleSubtreeStream stream_propertyList=new RewriteRuleSubtreeStream(adaptor,"rule propertyList");
        try {
            // /Users/dimitrioskolovos/Projects/Eclipse/4.2/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:134:3: ( 'ignoring' propertyList -> ^( IGNORING propertyList ) )
            // /Users/dimitrioskolovos/Projects/Eclipse/4.2/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:134:5: 'ignoring' propertyList
            {
            string_literal23=(Token)match(input,148,FOLLOW_148_in_ignoring356); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_148.add(string_literal23);

            pushFollow(FOLLOW_propertyList_in_ignoring358);
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
            // 135:3: -> ^( IGNORING propertyList )
            {
                // /Users/dimitrioskolovos/Projects/Eclipse/4.2/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:136:3: ^( IGNORING propertyList )
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
    // /Users/dimitrioskolovos/Projects/Eclipse/4.2/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:138:1: propertyList : NAME ( ',' NAME )* -> ( NAME )* ;
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
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_84=new RewriteRuleTokenStream(adaptor,"token 84");

        try {
            // /Users/dimitrioskolovos/Projects/Eclipse/4.2/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:139:3: ( NAME ( ',' NAME )* -> ( NAME )* )
            // /Users/dimitrioskolovos/Projects/Eclipse/4.2/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:139:5: NAME ( ',' NAME )*
            {
            NAME25=(Token)match(input,NAME,FOLLOW_NAME_in_propertyList382); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(NAME25);

            // /Users/dimitrioskolovos/Projects/Eclipse/4.2/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:139:10: ( ',' NAME )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==84) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // /Users/dimitrioskolovos/Projects/Eclipse/4.2/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:139:11: ',' NAME
            	    {
            	    char_literal26=(Token)match(input,84,FOLLOW_84_in_propertyList385); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_84.add(char_literal26);

            	    NAME27=(Token)match(input,NAME,FOLLOW_NAME_in_propertyList387); if (state.failed) return retval; 
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
            // 140:3: -> ( NAME )*
            {
                // /Users/dimitrioskolovos/Projects/Eclipse/4.2/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:141:3: ( NAME )*
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
    // /Users/dimitrioskolovos/Projects/Eclipse/4.2/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:143:1: guard : 'when' expressionOrStatementBlock -> ^( GUARD expressionOrStatementBlock ) ;
    public final FlockParser.guard_return guard() throws RecognitionException {
        FlockParser.guard_return retval = new FlockParser.guard_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal28=null;
        Flock_EolParserRules.expressionOrStatementBlock_return expressionOrStatementBlock29 = null;


        CommonTree string_literal28_tree=null;
        RewriteRuleTokenStream stream_149=new RewriteRuleTokenStream(adaptor,"token 149");
        RewriteRuleSubtreeStream stream_expressionOrStatementBlock=new RewriteRuleSubtreeStream(adaptor,"rule expressionOrStatementBlock");
        try {
            // /Users/dimitrioskolovos/Projects/Eclipse/4.2/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:144:3: ( 'when' expressionOrStatementBlock -> ^( GUARD expressionOrStatementBlock ) )
            // /Users/dimitrioskolovos/Projects/Eclipse/4.2/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:144:5: 'when' expressionOrStatementBlock
            {
            string_literal28=(Token)match(input,149,FOLLOW_149_in_guard408); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_149.add(string_literal28);

            pushFollow(FOLLOW_expressionOrStatementBlock_in_guard410);
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
            // 145:5: -> ^( GUARD expressionOrStatementBlock )
            {
                // /Users/dimitrioskolovos/Projects/Eclipse/4.2/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:146:5: ^( GUARD expressionOrStatementBlock )
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
        // /Users/dimitrioskolovos/Projects/Eclipse/4.2/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:121:5: ( fullRule )
        // /Users/dimitrioskolovos/Projects/Eclipse/4.2/workspace/org.eclipse.epsilon.flock.engine/src/org/eclipse/epsilon/flock/parse/Flock.g:121:5: fullRule
        {
        pushFollow(FOLLOW_fullRule_in_synpred8_Flock237);
        fullRule();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred8_Flock

    // Delegated rules
    public Flock_EolParserRules.expressionListOrRange_return expressionListOrRange() throws RecognitionException { return gEolParserRules.expressionListOrRange(); }
    public Flock_EolParserRules.annotationBlock_return annotationBlock() throws RecognitionException { return gEolParserRules.annotationBlock(); }
    public Flock_EolParserRules.breakStatement_return breakStatement() throws RecognitionException { return gEolParserRules.breakStatement(); }
    public Flock_EolParserRules.featureCall_return featureCall() throws RecognitionException { return gEolParserRules.featureCall(); }
    public Flock_EolParserRules.formalParameter_return formalParameter() throws RecognitionException { return gEolParserRules.formalParameter(); }
    public Flock_EolParserRules.annotation_return annotation() throws RecognitionException { return gEolParserRules.annotation(); }
    public Flock_EolParserRules.continueStatement_return continueStatement() throws RecognitionException { return gEolParserRules.continueStatement(); }
    public Flock_EolParserRules.relationalExpression_return relationalExpression() throws RecognitionException { return gEolParserRules.relationalExpression(); }
    public Flock_EolParserRules.importStatement_return importStatement() throws RecognitionException { return gEolParserRules.importStatement(); }
    public Flock_EolParserRules.packagedType_return packagedType() throws RecognitionException { return gEolParserRules.packagedType(); }
    public Flock_EolParserRules.variableDeclarationExpression_return variableDeclarationExpression() throws RecognitionException { return gEolParserRules.variableDeclarationExpression(); }
    public Flock_EolParserRules.executableAnnotation_return executableAnnotation() throws RecognitionException { return gEolParserRules.executableAnnotation(); }
    public Flock_EolParserRules.itemSelectorExpression_return itemSelectorExpression() throws RecognitionException { return gEolParserRules.itemSelectorExpression(); }
    public Flock_EolParserRules.modelDeclaration_return modelDeclaration() throws RecognitionException { return gEolParserRules.modelDeclaration(); }
    public Flock_EolParserRules.returnStatement_return returnStatement() throws RecognitionException { return gEolParserRules.returnStatement(); }
    public Flock_EolParserRules.expressionRange_return expressionRange() throws RecognitionException { return gEolParserRules.expressionRange(); }
    public Flock_EolParserRules.simpleFeatureCall_return simpleFeatureCall() throws RecognitionException { return gEolParserRules.simpleFeatureCall(); }
    public Flock_EolParserRules.additiveExpression_return additiveExpression() throws RecognitionException { return gEolParserRules.additiveExpression(); }
    public Flock_EolParserRules.formalParameterList_return formalParameterList() throws RecognitionException { return gEolParserRules.formalParameterList(); }
    public Flock_EolParserRules.statementA_return statementA() throws RecognitionException { return gEolParserRules.statementA(); }
    public Flock_EolParserRules.throwStatement_return throwStatement() throws RecognitionException { return gEolParserRules.throwStatement(); }
    public Flock_EolParserRules.nativeType_return nativeType() throws RecognitionException { return gEolParserRules.nativeType(); }
    public Flock_EolParserRules.statementBlock_return statementBlock() throws RecognitionException { return gEolParserRules.statementBlock(); }
    public Flock_EolParserRules.breakAllStatement_return breakAllStatement() throws RecognitionException { return gEolParserRules.breakAllStatement(); }
    public Flock_EolParserRules.keyvalExpressionList_return keyvalExpressionList() throws RecognitionException { return gEolParserRules.keyvalExpressionList(); }
    public Flock_EolParserRules.keyvalExpression_return keyvalExpression() throws RecognitionException { return gEolParserRules.keyvalExpression(); }
    public Flock_EolParserRules.operationDeclarationOrAnnotationBlock_return operationDeclarationOrAnnotationBlock() throws RecognitionException { return gEolParserRules.operationDeclarationOrAnnotationBlock(); }
    public Flock_EolParserRules.pathName_return pathName() throws RecognitionException { return gEolParserRules.pathName(); }
    public Flock_EolParserRules.typeName_return typeName() throws RecognitionException { return gEolParserRules.typeName(); }
    public Flock_EolParserRules.expressionStatement_return expressionStatement() throws RecognitionException { return gEolParserRules.expressionStatement(); }
    public Flock_EolParserRules.abortStatement_return abortStatement() throws RecognitionException { return gEolParserRules.abortStatement(); }
    public Flock_EolParserRules.declarativeFeatureCall_return declarativeFeatureCall() throws RecognitionException { return gEolParserRules.declarativeFeatureCall(); }
    public Flock_EolParserRules.transactionStatement_return transactionStatement() throws RecognitionException { return gEolParserRules.transactionStatement(); }
    public Flock_EolParserRules.block_return block() throws RecognitionException { return gEolParserRules.block(); }
    public Flock_EolParserRules.expressionList_return expressionList() throws RecognitionException { return gEolParserRules.expressionList(); }
    public Flock_EolParserRules.elseStatement_return elseStatement() throws RecognitionException { return gEolParserRules.elseStatement(); }
    public Flock_EolParserRules.statementB_return statementB() throws RecognitionException { return gEolParserRules.statementB(); }
    public Flock_EolParserRules.modelAlias_return modelAlias() throws RecognitionException { return gEolParserRules.modelAlias(); }
    public Flock_EolParserRules.modelDeclarationParameter_return modelDeclarationParameter() throws RecognitionException { return gEolParserRules.modelDeclarationParameter(); }
    public Flock_EolParserRules.unaryExpression_return unaryExpression() throws RecognitionException { return gEolParserRules.unaryExpression(); }
    public Flock_EolParserRules.multiplicativeExpression_return multiplicativeExpression() throws RecognitionException { return gEolParserRules.multiplicativeExpression(); }
    public Flock_EolParserRules.deleteStatement_return deleteStatement() throws RecognitionException { return gEolParserRules.deleteStatement(); }
    public Flock_EolParserRules.newExpression_return newExpression() throws RecognitionException { return gEolParserRules.newExpression(); }
    public Flock_EolParserRules.logicalExpression_return logicalExpression() throws RecognitionException { return gEolParserRules.logicalExpression(); }
    public Flock_EolParserRules.modelDeclarationParameters_return modelDeclarationParameters() throws RecognitionException { return gEolParserRules.modelDeclarationParameters(); }
    public Flock_EolParserRules.forStatement_return forStatement() throws RecognitionException { return gEolParserRules.forStatement(); }
    public Flock_EolParserRules.switchStatement_return switchStatement() throws RecognitionException { return gEolParserRules.switchStatement(); }
    public Flock_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock() throws RecognitionException { return gEolParserRules.statementOrStatementBlock(); }
    public Flock_EolParserRules.expressionOrStatementBlock_return expressionOrStatementBlock() throws RecognitionException { return gEolParserRules.expressionOrStatementBlock(); }
    public Flock_EolParserRules.literal_return literal() throws RecognitionException { return gEolParserRules.literal(); }
    public Flock_EolParserRules.operationDeclaration_return operationDeclaration() throws RecognitionException { return gEolParserRules.operationDeclaration(); }
    public Flock_EolParserRules.postfixExpression_return postfixExpression() throws RecognitionException { return gEolParserRules.postfixExpression(); }
    public Flock_EolParserRules.literalSequentialCollection_return literalSequentialCollection() throws RecognitionException { return gEolParserRules.literalSequentialCollection(); }
    public Flock_EolParserRules.modelNamespace_return modelNamespace() throws RecognitionException { return gEolParserRules.modelNamespace(); }
    public Flock_EolParserRules.parameterList_return parameterList() throws RecognitionException { return gEolParserRules.parameterList(); }
    public Flock_EolParserRules.primitiveExpression_return primitiveExpression() throws RecognitionException { return gEolParserRules.primitiveExpression(); }
    public Flock_EolParserRules.modelDriver_return modelDriver() throws RecognitionException { return gEolParserRules.modelDriver(); }
    public Flock_EolParserRules.statement_return statement() throws RecognitionException { return gEolParserRules.statement(); }
    public Flock_EolParserRules.caseStatement_return caseStatement() throws RecognitionException { return gEolParserRules.caseStatement(); }
    public Flock_EolParserRules.whileStatement_return whileStatement() throws RecognitionException { return gEolParserRules.whileStatement(); }
    public Flock_EolParserRules.collectionType_return collectionType() throws RecognitionException { return gEolParserRules.collectionType(); }
    public Flock_EolParserRules.assignmentStatement_return assignmentStatement() throws RecognitionException { return gEolParserRules.assignmentStatement(); }
    public Flock_EolParserRules.defaultStatement_return defaultStatement() throws RecognitionException { return gEolParserRules.defaultStatement(); }
    public Flock_EolParserRules.literalMapCollection_return literalMapCollection() throws RecognitionException { return gEolParserRules.literalMapCollection(); }
    public Flock_EolParserRules.ifStatement_return ifStatement() throws RecognitionException { return gEolParserRules.ifStatement(); }

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


 

    public static final BitSet FOLLOW_importStatement_in_flockModule94 = new BitSet(new long[]{0x0000000000800000L,0x00200000CC000000L,0x00000000000A0000L});
    public static final BitSet FOLLOW_flockModuleContent_in_flockModule98 = new BitSet(new long[]{0x0000000000800000L,0x002000008C000000L,0x00000000000A0000L});
    public static final BitSet FOLLOW_EOF_in_flockModule102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_retyping_in_flockModuleContent126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_deletion_in_flockModuleContent130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_migrateRule_in_flockModuleContent134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_operationDeclarationOrAnnotationBlock_in_flockModuleContent138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_145_in_retyping150 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_packagedType_in_retyping154 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_146_in_retyping156 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_packagedType_in_retyping160 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_guard_in_retyping162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_117_in_deletion202 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_packagedType_in_deletion206 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_guard_in_deletion208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fullRule_in_migrateRule237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ignoringRule_in_migrateRule241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_147_in_fullRule253 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_packagedType_in_fullRule257 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L,0x0000000000300000L});
    public static final BitSet FOLLOW_ignoring_in_fullRule259 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L,0x0000000000200000L});
    public static final BitSet FOLLOW_guard_in_fullRule262 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_87_in_fullRule265 = new BitSet(new long[]{0x0000000000085110L,0x07FC6FF811000000L,0x0000000000018900L});
    public static final BitSet FOLLOW_block_in_fullRule269 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_88_in_fullRule271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_147_in_ignoringRule313 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_packagedType_in_ignoringRule317 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_ignoring_in_ignoringRule319 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_guard_in_ignoringRule321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_148_in_ignoring356 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_propertyList_in_ignoring358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_propertyList382 = new BitSet(new long[]{0x0000000000000002L,0x0000000000100000L});
    public static final BitSet FOLLOW_84_in_propertyList385 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_propertyList387 = new BitSet(new long[]{0x0000000000000002L,0x0000000000100000L});
    public static final BitSet FOLLOW_149_in_guard408 = new BitSet(new long[]{0x0000000000000000L,0x0000000000880000L});
    public static final BitSet FOLLOW_expressionOrStatementBlock_in_guard410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fullRule_in_synpred8_Flock237 = new BitSet(new long[]{0x0000000000000002L});

}