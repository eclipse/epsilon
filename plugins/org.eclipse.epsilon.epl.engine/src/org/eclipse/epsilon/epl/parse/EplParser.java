// $ANTLR 3.1b1 /home/smadani/Epsilon/org.eclipse.epsilon/plugins/org.eclipse.epsilon.epl.engine/src/org/eclipse/epsilon/epl/parse/Epl.g 2019-01-24 14:02:06

package org.eclipse.epsilon.epl.parse;


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
public class EplParser extends org.eclipse.epsilon.common.parse.EpsilonParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "FLOAT", "DIGIT", "EXPONENT", "FLOAT_TYPE_SUFFIX", "INT", "POINT", "POINT_POINT", "ARROW", "BOOLEAN", "EscapeSequence", "STRING", "StrangeNameLiteral", "Letter", "SpecialNameChar", "JavaIDDigit", "NAME", "WS", "COMMENT", "LINE_COMMENT", "Annotation", "FORMAL", "PARAMLIST", "ASSIGNMENT", "SPECIAL_ASSIGNMENT", "HELPERMETHOD", "StatementBlock", "FOR", "IF", "ELSE", "WHILE", "SWITCH", "CASE", "DEFAULT", "RETURN", "BREAK", "BREAKALL", "CONTINUE", "TRANSACTION", "COLLECTION", "ABORT", "CollectionType", "ModelElementType", "PARAMETERS", "NewExpression", "VAR", "NEW", "ANNOTATIONBLOCK", "EXECUTABLEANNOTATION", "DELETE", "THROW", "EXPRLIST", "EXPRRANGE", "NativeType", "MultiplicativeExpression", "OPERATOR", "EXPRESSIONINBRACKETS", "FeatureCall", "EOLMODULE", "BLOCK", "FEATURECALL", "LAMBDAEXPR", "TYPE", "ENUMERATION_VALUE", "IMPORT", "MODELDECLARATION", "NAMESPACE", "ALIAS", "DRIVER", "MODELDECLARATIONPARAMETERS", "MODELDECLARATIONPARAMETER", "ITEMSELECTOR", "MAP", "KEYVAL", "KEYVALLIST", "PRE", "POST", "EXTENDS", "GUARD", "PATTERN", "CARDINALITY", "DOMAIN", "ROLE", "MATCH", "NOMATCH", "ONMATCH", "DO", "NO", "OPTIONAL", "ACTIVE", "EPLMODULE", "'model'", "';'", "'alias'", "','", "'driver'", "'{'", "'}'", "'='", "'operation'", "'function'", "'('", "')'", "':'", "'import'", "'$'", "'!'", "'#'", "'::'", "'Native'", "'Collection'", "'Sequence'", "'List'", "'Bag'", "'Set'", "'OrderedSet'", "'Map'", "'<'", "'>'", "'for'", "'in'", "'if'", "'switch'", "'case'", "'default'", "'else'", "'while'", "'return'", "'throw'", "'delete'", "'break'", "'breakAll'", "'continue'", "'abort'", "'transaction'", "':='", "'+='", "'-='", "'*='", "'/='", "'::='", "'or'", "'and'", "'xor'", "'implies'", "'=='", "'>='", "'<='", "'<>'", "'+'", "'-'", "'*'", "'/'", "'not'", "'++'", "'['", "']'", "'|'", "'=>'", "'new'", "'var'", "'ext'", "'pre'", "'post'", "'guard'", "'extends'", "'pattern'", "'no'", "'from'", "'match'", "'optional'", "'active'", "'do'", "'onmatch'", "'nomatch'"
    };
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
    public Epl_EolParserRules gEolParserRules;
    public Epl_ErlParserRules gErlParserRules;
    public Epl_EplParserRules gEplParserRules;
    // delegators


        public EplParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public EplParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
            gEolParserRules = new Epl_EolParserRules(input, state, this);
            gErlParserRules = new Epl_ErlParserRules(input, state, this);
            gEplParserRules = new Epl_EplParserRules(input, state, this);
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return EplParser.tokenNames; }
    public String getGrammarFileName() { return "/home/smadani/Epsilon/org.eclipse.epsilon/plugins/org.eclipse.epsilon.epl.engine/src/org/eclipse/epsilon/epl/parse/Epl.g"; }


    public static class eplModule_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start eplModule
    // /home/smadani/Epsilon/org.eclipse.epsilon/plugins/org.eclipse.epsilon.epl.engine/src/org/eclipse/epsilon/epl/parse/Epl.g:94:1: eplModule : ( importStatement )* ( modelDeclaration )* ( eplModuleContent )* EOF -> ^( EPLMODULE ( importStatement )* ( modelDeclaration )* ( eplModuleContent )* ) ;
    public final EplParser.eplModule_return eplModule() throws RecognitionException {
        EplParser.eplModule_return retval = new EplParser.eplModule_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token EOF4=null;
        Epl_EolParserRules.importStatement_return importStatement1 = null;

        Epl_EolParserRules.modelDeclaration_return modelDeclaration2 = null;

        EplParser.eplModuleContent_return eplModuleContent3 = null;


        org.eclipse.epsilon.common.parse.AST EOF4_tree=null;
        RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
        RewriteRuleSubtreeStream stream_modelDeclaration=new RewriteRuleSubtreeStream(adaptor,"rule modelDeclaration");
        RewriteRuleSubtreeStream stream_importStatement=new RewriteRuleSubtreeStream(adaptor,"rule importStatement");
        RewriteRuleSubtreeStream stream_eplModuleContent=new RewriteRuleSubtreeStream(adaptor,"rule eplModuleContent");
        try {
            // /home/smadani/Epsilon/org.eclipse.epsilon/plugins/org.eclipse.epsilon.epl.engine/src/org/eclipse/epsilon/epl/parse/Epl.g:95:2: ( ( importStatement )* ( modelDeclaration )* ( eplModuleContent )* EOF -> ^( EPLMODULE ( importStatement )* ( modelDeclaration )* ( eplModuleContent )* ) )
            // /home/smadani/Epsilon/org.eclipse.epsilon/plugins/org.eclipse.epsilon.epl.engine/src/org/eclipse/epsilon/epl/parse/Epl.g:95:4: ( importStatement )* ( modelDeclaration )* ( eplModuleContent )* EOF
            {
            // /home/smadani/Epsilon/org.eclipse.epsilon/plugins/org.eclipse.epsilon.epl.engine/src/org/eclipse/epsilon/epl/parse/Epl.g:95:4: ( importStatement )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==107) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /home/smadani/Epsilon/org.eclipse.epsilon/plugins/org.eclipse.epsilon.epl.engine/src/org/eclipse/epsilon/epl/parse/Epl.g:0:0: importStatement
            	    {
            	    pushFollow(FOLLOW_importStatement_in_eplModule76);
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

            // /home/smadani/Epsilon/org.eclipse.epsilon/plugins/org.eclipse.epsilon.epl.engine/src/org/eclipse/epsilon/epl/parse/Epl.g:95:21: ( modelDeclaration )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==94) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /home/smadani/Epsilon/org.eclipse.epsilon/plugins/org.eclipse.epsilon.epl.engine/src/org/eclipse/epsilon/epl/parse/Epl.g:0:0: modelDeclaration
            	    {
            	    pushFollow(FOLLOW_modelDeclaration_in_eplModule79);
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

            // /home/smadani/Epsilon/org.eclipse.epsilon/plugins/org.eclipse.epsilon.epl.engine/src/org/eclipse/epsilon/epl/parse/Epl.g:95:39: ( eplModuleContent )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==Annotation||(LA3_0>=102 && LA3_0<=103)||LA3_0==108||(LA3_0>=165 && LA3_0<=166)||LA3_0==169) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /home/smadani/Epsilon/org.eclipse.epsilon/plugins/org.eclipse.epsilon.epl.engine/src/org/eclipse/epsilon/epl/parse/Epl.g:0:0: eplModuleContent
            	    {
            	    pushFollow(FOLLOW_eplModuleContent_in_eplModule82);
            	    eplModuleContent3=eplModuleContent();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_eplModuleContent.add(eplModuleContent3.getTree());

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            EOF4=(Token)match(input,EOF,FOLLOW_EOF_in_eplModule85); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EOF.add(EOF4);



            // AST REWRITE
            // elements: importStatement, modelDeclaration, eplModuleContent
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();
            // 96:2: -> ^( EPLMODULE ( importStatement )* ( modelDeclaration )* ( eplModuleContent )* )
            {
                // /home/smadani/Epsilon/org.eclipse.epsilon/plugins/org.eclipse.epsilon.epl.engine/src/org/eclipse/epsilon/epl/parse/Epl.g:96:5: ^( EPLMODULE ( importStatement )* ( modelDeclaration )* ( eplModuleContent )* )
                {
                org.eclipse.epsilon.common.parse.AST root_1 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();
                root_1 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot((org.eclipse.epsilon.common.parse.AST)adaptor.create(EPLMODULE, "EPLMODULE"), root_1);

                // /home/smadani/Epsilon/org.eclipse.epsilon/plugins/org.eclipse.epsilon.epl.engine/src/org/eclipse/epsilon/epl/parse/Epl.g:96:17: ( importStatement )*
                while ( stream_importStatement.hasNext() ) {
                    adaptor.addChild(root_1, stream_importStatement.nextTree());

                }
                stream_importStatement.reset();
                // /home/smadani/Epsilon/org.eclipse.epsilon/plugins/org.eclipse.epsilon.epl.engine/src/org/eclipse/epsilon/epl/parse/Epl.g:96:34: ( modelDeclaration )*
                while ( stream_modelDeclaration.hasNext() ) {
                    adaptor.addChild(root_1, stream_modelDeclaration.nextTree());

                }
                stream_modelDeclaration.reset();
                // /home/smadani/Epsilon/org.eclipse.epsilon/plugins/org.eclipse.epsilon.epl.engine/src/org/eclipse/epsilon/epl/parse/Epl.g:96:52: ( eplModuleContent )*
                while ( stream_eplModuleContent.hasNext() ) {
                    adaptor.addChild(root_1, stream_eplModuleContent.nextTree());

                }
                stream_eplModuleContent.reset();

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
    // $ANTLR end eplModule

    public static class eplModuleContent_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start eplModuleContent
    // /home/smadani/Epsilon/org.eclipse.epsilon/plugins/org.eclipse.epsilon.epl.engine/src/org/eclipse/epsilon/epl/parse/Epl.g:99:1: eplModuleContent : ( pre | annotationBlock | pattern | operationDeclaration | post );
    public final EplParser.eplModuleContent_return eplModuleContent() throws RecognitionException {
        EplParser.eplModuleContent_return retval = new EplParser.eplModuleContent_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Epl_ErlParserRules.pre_return pre5 = null;

        Epl_EolParserRules.annotationBlock_return annotationBlock6 = null;

        Epl_EplParserRules.pattern_return pattern7 = null;

        Epl_EolParserRules.operationDeclaration_return operationDeclaration8 = null;

        Epl_ErlParserRules.post_return post9 = null;



        try {
            // /home/smadani/Epsilon/org.eclipse.epsilon/plugins/org.eclipse.epsilon.epl.engine/src/org/eclipse/epsilon/epl/parse/Epl.g:100:2: ( pre | annotationBlock | pattern | operationDeclaration | post )
            int alt4=5;
            switch ( input.LA(1) ) {
            case 165:
                {
                alt4=1;
                }
                break;
            case Annotation:
            case 108:
                {
                alt4=2;
                }
                break;
            case 169:
                {
                alt4=3;
                }
                break;
            case 102:
            case 103:
                {
                alt4=4;
                }
                break;
            case 166:
                {
                alt4=5;
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
                    // /home/smadani/Epsilon/org.eclipse.epsilon/plugins/org.eclipse.epsilon.epl.engine/src/org/eclipse/epsilon/epl/parse/Epl.g:100:4: pre
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_pre_in_eplModuleContent112);
                    pre5=pre();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pre5.getTree());

                    }
                    break;
                case 2 :
                    // /home/smadani/Epsilon/org.eclipse.epsilon/plugins/org.eclipse.epsilon.epl.engine/src/org/eclipse/epsilon/epl/parse/Epl.g:100:10: annotationBlock
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_annotationBlock_in_eplModuleContent116);
                    annotationBlock6=annotationBlock();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationBlock6.getTree());

                    }
                    break;
                case 3 :
                    // /home/smadani/Epsilon/org.eclipse.epsilon/plugins/org.eclipse.epsilon.epl.engine/src/org/eclipse/epsilon/epl/parse/Epl.g:100:28: pattern
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_pattern_in_eplModuleContent120);
                    pattern7=pattern();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pattern7.getTree());

                    }
                    break;
                case 4 :
                    // /home/smadani/Epsilon/org.eclipse.epsilon/plugins/org.eclipse.epsilon.epl.engine/src/org/eclipse/epsilon/epl/parse/Epl.g:100:38: operationDeclaration
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_operationDeclaration_in_eplModuleContent124);
                    operationDeclaration8=operationDeclaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, operationDeclaration8.getTree());

                    }
                    break;
                case 5 :
                    // /home/smadani/Epsilon/org.eclipse.epsilon/plugins/org.eclipse.epsilon.epl.engine/src/org/eclipse/epsilon/epl/parse/Epl.g:100:61: post
                    {
                    root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

                    pushFollow(FOLLOW_post_in_eplModuleContent128);
                    post9=post();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, post9.getTree());

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
    // $ANTLR end eplModuleContent

    // Delegated rules
    public Epl_EolParserRules.keyvalExpression_return keyvalExpression() throws RecognitionException { return gEolParserRules.keyvalExpression(); }
    public Epl_EolParserRules.unaryExpression_return unaryExpression() throws RecognitionException { return gEolParserRules.unaryExpression(); }
    public Epl_EolParserRules.statementA_return statementA() throws RecognitionException { return gEolParserRules.statementA(); }
    public Epl_EolParserRules.ifStatement_return ifStatement() throws RecognitionException { return gEolParserRules.ifStatement(); }
    public Epl_EolParserRules.expressionStatement_return expressionStatement() throws RecognitionException { return gEolParserRules.expressionStatement(); }
    public Epl_EplParserRules.role_return role() throws RecognitionException { return gEplParserRules.role(); }
    public Epl_EolParserRules.defaultStatement_return defaultStatement() throws RecognitionException { return gEolParserRules.defaultStatement(); }
    public Epl_EolParserRules.additiveExpression_return additiveExpression() throws RecognitionException { return gEolParserRules.additiveExpression(); }
    public Epl_EolParserRules.itemSelectorExpression_return itemSelectorExpression() throws RecognitionException { return gEolParserRules.itemSelectorExpression(); }
    public Epl_EolParserRules.keyvalExpressionList_return keyvalExpressionList() throws RecognitionException { return gEolParserRules.keyvalExpressionList(); }
    public Epl_EolParserRules.throwStatement_return throwStatement() throws RecognitionException { return gEolParserRules.throwStatement(); }
    public Epl_EolParserRules.complexFeatureCall_return complexFeatureCall() throws RecognitionException { return gEolParserRules.complexFeatureCall(); }
    public Epl_EplParserRules.active_return active() throws RecognitionException { return gEplParserRules.active(); }
    public Epl_EolParserRules.block_return block() throws RecognitionException { return gEolParserRules.block(); }
    public Epl_EplParserRules.nomatch_return nomatch() throws RecognitionException { return gEplParserRules.nomatch(); }
    public Epl_EolParserRules.abortStatement_return abortStatement() throws RecognitionException { return gEolParserRules.abortStatement(); }
    public Epl_EolParserRules.modelDriver_return modelDriver() throws RecognitionException { return gEolParserRules.modelDriver(); }
    public Epl_ErlParserRules.pre_return pre() throws RecognitionException { return gErlParserRules.pre(); }
    public Epl_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock() throws RecognitionException { return gEolParserRules.statementOrStatementBlock(); }
    public Epl_EolParserRules.deleteStatement_return deleteStatement() throws RecognitionException { return gEolParserRules.deleteStatement(); }
    public Epl_EolParserRules.operationDeclarationOrAnnotationBlock_return operationDeclarationOrAnnotationBlock() throws RecognitionException { return gEolParserRules.operationDeclarationOrAnnotationBlock(); }
    public Epl_EolParserRules.variableDeclarationExpression_return variableDeclarationExpression() throws RecognitionException { return gEolParserRules.variableDeclarationExpression(); }
    public Epl_EolParserRules.returnStatement_return returnStatement() throws RecognitionException { return gEolParserRules.returnStatement(); }
    public Epl_EolParserRules.statementB_return statementB() throws RecognitionException { return gEolParserRules.statementB(); }
    public Epl_EolParserRules.annotationBlock_return annotationBlock() throws RecognitionException { return gEolParserRules.annotationBlock(); }
    public Epl_EolParserRules.pathName_return pathName() throws RecognitionException { return gEolParserRules.pathName(); }
    public Epl_EolParserRules.literalSequentialCollection_return literalSequentialCollection() throws RecognitionException { return gEolParserRules.literalSequentialCollection(); }
    public Epl_EolParserRules.executableAnnotation_return executableAnnotation() throws RecognitionException { return gEolParserRules.executableAnnotation(); }
    public Epl_EolParserRules.expressionList_return expressionList() throws RecognitionException { return gEolParserRules.expressionList(); }
    public Epl_EplParserRules.do__return do_() throws RecognitionException { return gEplParserRules.do_(); }
    public Epl_EplParserRules.optional_return optional() throws RecognitionException { return gEplParserRules.optional(); }
    public Epl_EolParserRules.packagedType_return packagedType() throws RecognitionException { return gEolParserRules.packagedType(); }
    public Epl_EolParserRules.logicalExpression_return logicalExpression() throws RecognitionException { return gEolParserRules.logicalExpression(); }
    public Epl_EolParserRules.switchStatement_return switchStatement() throws RecognitionException { return gEolParserRules.switchStatement(); }
    public Epl_EolParserRules.assignmentStatement_return assignmentStatement() throws RecognitionException { return gEolParserRules.assignmentStatement(); }
    public Epl_EolParserRules.literal_return literal() throws RecognitionException { return gEolParserRules.literal(); }
    public Epl_EolParserRules.statement_return statement() throws RecognitionException { return gEolParserRules.statement(); }
    public Epl_EolParserRules.forStatement_return forStatement() throws RecognitionException { return gEolParserRules.forStatement(); }
    public Epl_EplParserRules.onmatch_return onmatch() throws RecognitionException { return gEplParserRules.onmatch(); }
    public Epl_EplParserRules.cardinality_return cardinality() throws RecognitionException { return gEplParserRules.cardinality(); }
    public Epl_EplParserRules.bound_return bound() throws RecognitionException { return gEplParserRules.bound(); }
    public Epl_EolParserRules.modelAlias_return modelAlias() throws RecognitionException { return gEolParserRules.modelAlias(); }
    public Epl_EolParserRules.collectionType_return collectionType() throws RecognitionException { return gEolParserRules.collectionType(); }
    public Epl_EolParserRules.lambdaExpression_return lambdaExpression() throws RecognitionException { return gEolParserRules.lambdaExpression(); }
    public Epl_EolParserRules.modelDeclaration_return modelDeclaration() throws RecognitionException { return gEolParserRules.modelDeclaration(); }
    public Epl_EolParserRules.postfixExpression_return postfixExpression() throws RecognitionException { return gEolParserRules.postfixExpression(); }
    public Epl_EolParserRules.operationDeclaration_return operationDeclaration() throws RecognitionException { return gEolParserRules.operationDeclaration(); }
    public Epl_EolParserRules.breakAllStatement_return breakAllStatement() throws RecognitionException { return gEolParserRules.breakAllStatement(); }
    public Epl_EolParserRules.relationalExpression_return relationalExpression() throws RecognitionException { return gEolParserRules.relationalExpression(); }
    public Epl_EolParserRules.breakStatement_return breakStatement() throws RecognitionException { return gEolParserRules.breakStatement(); }
    public Epl_EolParserRules.formalParameter_return formalParameter() throws RecognitionException { return gEolParserRules.formalParameter(); }
    public Epl_EolParserRules.expressionListOrRange_return expressionListOrRange() throws RecognitionException { return gEolParserRules.expressionListOrRange(); }
    public Epl_EolParserRules.formalParameterList_return formalParameterList() throws RecognitionException { return gEolParserRules.formalParameterList(); }
    public Epl_EolParserRules.multiplicativeExpression_return multiplicativeExpression() throws RecognitionException { return gEolParserRules.multiplicativeExpression(); }
    public Epl_EolParserRules.statementBlock_return statementBlock() throws RecognitionException { return gEolParserRules.statementBlock(); }
    public Epl_EolParserRules.lambdaExpressionInBrackets_return lambdaExpressionInBrackets() throws RecognitionException { return gEolParserRules.lambdaExpressionInBrackets(); }
    public Epl_EolParserRules.whileStatement_return whileStatement() throws RecognitionException { return gEolParserRules.whileStatement(); }
    public Epl_ErlParserRules.guard_return guard() throws RecognitionException { return gErlParserRules.guard(); }
    public Epl_EolParserRules.shortcutOperatorExpression_return shortcutOperatorExpression() throws RecognitionException { return gEolParserRules.shortcutOperatorExpression(); }
    public Epl_EplParserRules.pattern_return pattern() throws RecognitionException { return gEplParserRules.pattern(); }
    public Epl_EplParserRules.match_return match() throws RecognitionException { return gEplParserRules.match(); }
    public Epl_EolParserRules.simpleFeatureCall_return simpleFeatureCall() throws RecognitionException { return gEolParserRules.simpleFeatureCall(); }
    public Epl_EolParserRules.nativeType_return nativeType() throws RecognitionException { return gEolParserRules.nativeType(); }
    public Epl_ErlParserRules.extendz_return extendz() throws RecognitionException { return gErlParserRules.extendz(); }
    public Epl_EplParserRules.domain_return domain() throws RecognitionException { return gEplParserRules.domain(); }
    public Epl_EolParserRules.modelDeclarationParameters_return modelDeclarationParameters() throws RecognitionException { return gEolParserRules.modelDeclarationParameters(); }
    public Epl_EolParserRules.modelDeclarationParameter_return modelDeclarationParameter() throws RecognitionException { return gEolParserRules.modelDeclarationParameter(); }
    public Epl_EolParserRules.parameterList_return parameterList() throws RecognitionException { return gEolParserRules.parameterList(); }
    public Epl_EolParserRules.transactionStatement_return transactionStatement() throws RecognitionException { return gEolParserRules.transactionStatement(); }
    public Epl_ErlParserRules.post_return post() throws RecognitionException { return gErlParserRules.post(); }
    public Epl_EolParserRules.primitiveExpression_return primitiveExpression() throws RecognitionException { return gEolParserRules.primitiveExpression(); }
    public Epl_EolParserRules.typeName_return typeName() throws RecognitionException { return gEolParserRules.typeName(); }
    public Epl_EolParserRules.caseStatement_return caseStatement() throws RecognitionException { return gEolParserRules.caseStatement(); }
    public Epl_EolParserRules.expressionRange_return expressionRange() throws RecognitionException { return gEolParserRules.expressionRange(); }
    public Epl_EolParserRules.importStatement_return importStatement() throws RecognitionException { return gEolParserRules.importStatement(); }
    public Epl_EolParserRules.logicalExpressionInBrackets_return logicalExpressionInBrackets() throws RecognitionException { return gEolParserRules.logicalExpressionInBrackets(); }
    public Epl_EplParserRules.no_return no() throws RecognitionException { return gEplParserRules.no(); }
    public Epl_EolParserRules.featureCall_return featureCall() throws RecognitionException { return gEolParserRules.featureCall(); }
    public Epl_EolParserRules.elseStatement_return elseStatement() throws RecognitionException { return gEolParserRules.elseStatement(); }
    public Epl_EolParserRules.annotation_return annotation() throws RecognitionException { return gEolParserRules.annotation(); }
    public Epl_EolParserRules.continueStatement_return continueStatement() throws RecognitionException { return gEolParserRules.continueStatement(); }
    public Epl_EolParserRules.literalMapCollection_return literalMapCollection() throws RecognitionException { return gEolParserRules.literalMapCollection(); }
    public Epl_EolParserRules.expressionOrStatementBlock_return expressionOrStatementBlock() throws RecognitionException { return gEolParserRules.expressionOrStatementBlock(); }
    public Epl_EolParserRules.newExpression_return newExpression() throws RecognitionException { return gEolParserRules.newExpression(); }


 

    public static final BitSet FOLLOW_importStatement_in_eplModule76 = new BitSet(new long[]{0x0000000000800000L,0x000018C040000000L,0x0000026000000000L});
    public static final BitSet FOLLOW_modelDeclaration_in_eplModule79 = new BitSet(new long[]{0x0000000000800000L,0x000010C040000000L,0x0000026000000000L});
    public static final BitSet FOLLOW_eplModuleContent_in_eplModule82 = new BitSet(new long[]{0x0000000000800000L,0x000010C000000000L,0x0000026000000000L});
    public static final BitSet FOLLOW_EOF_in_eplModule85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pre_in_eplModuleContent112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationBlock_in_eplModuleContent116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pattern_in_eplModuleContent120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_operationDeclaration_in_eplModuleContent124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_post_in_eplModuleContent128 = new BitSet(new long[]{0x0000000000000002L});

}