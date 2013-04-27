package org.eclipse.epsilon.flock.parse;

// $ANTLR 3.1b1 EolParserRules.g 2013-04-27 16:08:56

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
public class Flock_EolParserRules extends org.eclipse.epsilon.common.parse.EpsilonParser {
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
    // delegators
    public FlockParser gFlock;


        public Flock_EolParserRules(TokenStream input, FlockParser gFlock) {
            this(input, new RecognizerSharedState(), gFlock);
        }
        public Flock_EolParserRules(TokenStream input, RecognizerSharedState state, FlockParser gFlock) {
            super(input, state);
            this.gFlock = gFlock;
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return FlockParser.tokenNames; }
    public String getGrammarFileName() { return "EolParserRules.g"; }

    
    
    public void setTokenType(ParserRuleReturnScope tree, int type) {
    	((CommonTree) tree.getTree()).getToken().setType(type);
    }
    


    public static class operationDeclarationOrAnnotationBlock_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start operationDeclarationOrAnnotationBlock
    // EolParserRules.g:104:1: operationDeclarationOrAnnotationBlock : ( operationDeclaration | annotationBlock );
    public final Flock_EolParserRules.operationDeclarationOrAnnotationBlock_return operationDeclarationOrAnnotationBlock() throws RecognitionException {
        Flock_EolParserRules.operationDeclarationOrAnnotationBlock_return retval = new Flock_EolParserRules.operationDeclarationOrAnnotationBlock_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Flock_EolParserRules.operationDeclaration_return operationDeclaration1 = null;

        Flock_EolParserRules.annotationBlock_return annotationBlock2 = null;



        try {
            // EolParserRules.g:105:2: ( operationDeclaration | annotationBlock )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( ((LA1_0>=90 && LA1_0<=91)) ) {
                alt1=1;
            }
            else if ( (LA1_0==Annotation||LA1_0==95) ) {
                alt1=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // EolParserRules.g:105:4: operationDeclaration
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_operationDeclaration_in_operationDeclarationOrAnnotationBlock246);
                    operationDeclaration1=operationDeclaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, operationDeclaration1.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:105:25: annotationBlock
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_annotationBlock_in_operationDeclarationOrAnnotationBlock248);
                    annotationBlock2=annotationBlock();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationBlock2.getTree());

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
    // $ANTLR end operationDeclarationOrAnnotationBlock

    public static class modelDeclaration_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start modelDeclaration
    // EolParserRules.g:108:1: modelDeclaration : 'model' NAME ( modelAlias )? ( modelDriver )? ( modelDeclarationParameters )? ';' -> ^( MODELDECLARATION NAME ( modelAlias )? ( modelDriver )? ( modelDeclarationParameters )? ) ;
    public final Flock_EolParserRules.modelDeclaration_return modelDeclaration() throws RecognitionException {
        Flock_EolParserRules.modelDeclaration_return retval = new Flock_EolParserRules.modelDeclaration_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal3=null;
        Token NAME4=null;
        Token char_literal8=null;
        Flock_EolParserRules.modelAlias_return modelAlias5 = null;

        Flock_EolParserRules.modelDriver_return modelDriver6 = null;

        Flock_EolParserRules.modelDeclarationParameters_return modelDeclarationParameters7 = null;


        CommonTree string_literal3_tree=null;
        CommonTree NAME4_tree=null;
        CommonTree char_literal8_tree=null;
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_82=new RewriteRuleTokenStream(adaptor,"token 82");
        RewriteRuleTokenStream stream_81=new RewriteRuleTokenStream(adaptor,"token 81");
        RewriteRuleSubtreeStream stream_modelDeclarationParameters=new RewriteRuleSubtreeStream(adaptor,"rule modelDeclarationParameters");
        RewriteRuleSubtreeStream stream_modelAlias=new RewriteRuleSubtreeStream(adaptor,"rule modelAlias");
        RewriteRuleSubtreeStream stream_modelDriver=new RewriteRuleSubtreeStream(adaptor,"rule modelDriver");
        try {
            // EolParserRules.g:109:2: ( 'model' NAME ( modelAlias )? ( modelDriver )? ( modelDeclarationParameters )? ';' -> ^( MODELDECLARATION NAME ( modelAlias )? ( modelDriver )? ( modelDeclarationParameters )? ) )
            // EolParserRules.g:109:4: 'model' NAME ( modelAlias )? ( modelDriver )? ( modelDeclarationParameters )? ';'
            {
            string_literal3=(Token)match(input,81,FOLLOW_81_in_modelDeclaration259); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_81.add(string_literal3);

            NAME4=(Token)match(input,NAME,FOLLOW_NAME_in_modelDeclaration261); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(NAME4);

            // EolParserRules.g:109:17: ( modelAlias )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==85) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // EolParserRules.g:0:0: modelAlias
                    {
                    pushFollow(FOLLOW_modelAlias_in_modelDeclaration263);
                    modelAlias5=modelAlias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_modelAlias.add(modelAlias5.getTree());

                    }
                    break;

            }

            // EolParserRules.g:109:29: ( modelDriver )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==86) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // EolParserRules.g:0:0: modelDriver
                    {
                    pushFollow(FOLLOW_modelDriver_in_modelDeclaration266);
                    modelDriver6=modelDriver();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_modelDriver.add(modelDriver6.getTree());

                    }
                    break;

            }

            // EolParserRules.g:109:42: ( modelDeclarationParameters )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==87) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // EolParserRules.g:0:0: modelDeclarationParameters
                    {
                    pushFollow(FOLLOW_modelDeclarationParameters_in_modelDeclaration269);
                    modelDeclarationParameters7=modelDeclarationParameters();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_modelDeclarationParameters.add(modelDeclarationParameters7.getTree());

                    }
                    break;

            }

            char_literal8=(Token)match(input,82,FOLLOW_82_in_modelDeclaration272); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_82.add(char_literal8);



            // AST REWRITE
            // elements: modelAlias, modelDeclarationParameters, NAME, modelDriver
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 110:2: -> ^( MODELDECLARATION NAME ( modelAlias )? ( modelDriver )? ( modelDeclarationParameters )? )
            {
                // EolParserRules.g:110:5: ^( MODELDECLARATION NAME ( modelAlias )? ( modelDriver )? ( modelDeclarationParameters )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(MODELDECLARATION, "MODELDECLARATION"), root_1);

                adaptor.addChild(root_1, stream_NAME.nextNode());
                // EolParserRules.g:110:29: ( modelAlias )?
                if ( stream_modelAlias.hasNext() ) {
                    adaptor.addChild(root_1, stream_modelAlias.nextTree());

                }
                stream_modelAlias.reset();
                // EolParserRules.g:110:43: ( modelDriver )?
                if ( stream_modelDriver.hasNext() ) {
                    adaptor.addChild(root_1, stream_modelDriver.nextTree());

                }
                stream_modelDriver.reset();
                // EolParserRules.g:110:58: ( modelDeclarationParameters )?
                if ( stream_modelDeclarationParameters.hasNext() ) {
                    adaptor.addChild(root_1, stream_modelDeclarationParameters.nextTree());

                }
                stream_modelDeclarationParameters.reset();

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
    // $ANTLR end modelDeclaration

    public static class modelNamespace_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start modelNamespace
    // EolParserRules.g:113:1: modelNamespace : ':' NAME ( ',' NAME )* -> ^( NAMESPACE ( NAME )* ) ;
    public final Flock_EolParserRules.modelNamespace_return modelNamespace() throws RecognitionException {
        Flock_EolParserRules.modelNamespace_return retval = new Flock_EolParserRules.modelNamespace_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal9=null;
        Token NAME10=null;
        Token char_literal11=null;
        Token NAME12=null;

        CommonTree char_literal9_tree=null;
        CommonTree NAME10_tree=null;
        CommonTree char_literal11_tree=null;
        CommonTree NAME12_tree=null;
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_83=new RewriteRuleTokenStream(adaptor,"token 83");
        RewriteRuleTokenStream stream_84=new RewriteRuleTokenStream(adaptor,"token 84");

        try {
            // EolParserRules.g:114:2: ( ':' NAME ( ',' NAME )* -> ^( NAMESPACE ( NAME )* ) )
            // EolParserRules.g:114:6: ':' NAME ( ',' NAME )*
            {
            char_literal9=(Token)match(input,83,FOLLOW_83_in_modelNamespace310); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_83.add(char_literal9);

            NAME10=(Token)match(input,NAME,FOLLOW_NAME_in_modelNamespace312); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(NAME10);

            // EolParserRules.g:114:15: ( ',' NAME )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==84) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // EolParserRules.g:114:16: ',' NAME
            	    {
            	    char_literal11=(Token)match(input,84,FOLLOW_84_in_modelNamespace315); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_84.add(char_literal11);

            	    NAME12=(Token)match(input,NAME,FOLLOW_NAME_in_modelNamespace317); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_NAME.add(NAME12);


            	    }
            	    break;

            	default :
            	    break loop5;
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
            // 115:2: -> ^( NAMESPACE ( NAME )* )
            {
                // EolParserRules.g:115:5: ^( NAMESPACE ( NAME )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NAMESPACE, "NAMESPACE"), root_1);

                // EolParserRules.g:115:17: ( NAME )*
                while ( stream_NAME.hasNext() ) {
                    adaptor.addChild(root_1, stream_NAME.nextNode());

                }
                stream_NAME.reset();

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
    // $ANTLR end modelNamespace

    public static class modelAlias_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start modelAlias
    // EolParserRules.g:118:1: modelAlias : 'alias' NAME ( ',' NAME )* -> ^( ALIAS ( NAME )* ) ;
    public final Flock_EolParserRules.modelAlias_return modelAlias() throws RecognitionException {
        Flock_EolParserRules.modelAlias_return retval = new Flock_EolParserRules.modelAlias_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal13=null;
        Token NAME14=null;
        Token char_literal15=null;
        Token NAME16=null;

        CommonTree string_literal13_tree=null;
        CommonTree NAME14_tree=null;
        CommonTree char_literal15_tree=null;
        CommonTree NAME16_tree=null;
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_84=new RewriteRuleTokenStream(adaptor,"token 84");
        RewriteRuleTokenStream stream_85=new RewriteRuleTokenStream(adaptor,"token 85");

        try {
            // EolParserRules.g:119:2: ( 'alias' NAME ( ',' NAME )* -> ^( ALIAS ( NAME )* ) )
            // EolParserRules.g:119:5: 'alias' NAME ( ',' NAME )*
            {
            string_literal13=(Token)match(input,85,FOLLOW_85_in_modelAlias341); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_85.add(string_literal13);

            NAME14=(Token)match(input,NAME,FOLLOW_NAME_in_modelAlias343); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(NAME14);

            // EolParserRules.g:119:18: ( ',' NAME )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==84) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // EolParserRules.g:119:19: ',' NAME
            	    {
            	    char_literal15=(Token)match(input,84,FOLLOW_84_in_modelAlias346); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_84.add(char_literal15);

            	    NAME16=(Token)match(input,NAME,FOLLOW_NAME_in_modelAlias348); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_NAME.add(NAME16);


            	    }
            	    break;

            	default :
            	    break loop6;
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
            // 120:2: -> ^( ALIAS ( NAME )* )
            {
                // EolParserRules.g:120:5: ^( ALIAS ( NAME )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ALIAS, "ALIAS"), root_1);

                // EolParserRules.g:120:13: ( NAME )*
                while ( stream_NAME.hasNext() ) {
                    adaptor.addChild(root_1, stream_NAME.nextNode());

                }
                stream_NAME.reset();

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
    // $ANTLR end modelAlias

    public static class modelDriver_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start modelDriver
    // EolParserRules.g:123:1: modelDriver : 'driver' NAME -> ^( DRIVER NAME ) ;
    public final Flock_EolParserRules.modelDriver_return modelDriver() throws RecognitionException {
        Flock_EolParserRules.modelDriver_return retval = new Flock_EolParserRules.modelDriver_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal17=null;
        Token NAME18=null;

        CommonTree string_literal17_tree=null;
        CommonTree NAME18_tree=null;
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_86=new RewriteRuleTokenStream(adaptor,"token 86");

        try {
            // EolParserRules.g:124:2: ( 'driver' NAME -> ^( DRIVER NAME ) )
            // EolParserRules.g:124:5: 'driver' NAME
            {
            string_literal17=(Token)match(input,86,FOLLOW_86_in_modelDriver372); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_86.add(string_literal17);

            NAME18=(Token)match(input,NAME,FOLLOW_NAME_in_modelDriver374); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(NAME18);



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
            // 125:2: -> ^( DRIVER NAME )
            {
                // EolParserRules.g:125:5: ^( DRIVER NAME )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(DRIVER, "DRIVER"), root_1);

                adaptor.addChild(root_1, stream_NAME.nextNode());

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
    // $ANTLR end modelDriver

    public static class modelDeclarationParameters_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start modelDeclarationParameters
    // EolParserRules.g:128:1: modelDeclarationParameters : '{' ( modelDeclarationParameter )? ( ',' modelDeclarationParameter )* '}' -> ^( MODELDECLARATIONPARAMETERS ( modelDeclarationParameter )* ) ;
    public final Flock_EolParserRules.modelDeclarationParameters_return modelDeclarationParameters() throws RecognitionException {
        Flock_EolParserRules.modelDeclarationParameters_return retval = new Flock_EolParserRules.modelDeclarationParameters_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal19=null;
        Token char_literal21=null;
        Token char_literal23=null;
        Flock_EolParserRules.modelDeclarationParameter_return modelDeclarationParameter20 = null;

        Flock_EolParserRules.modelDeclarationParameter_return modelDeclarationParameter22 = null;


        CommonTree char_literal19_tree=null;
        CommonTree char_literal21_tree=null;
        CommonTree char_literal23_tree=null;
        RewriteRuleTokenStream stream_87=new RewriteRuleTokenStream(adaptor,"token 87");
        RewriteRuleTokenStream stream_84=new RewriteRuleTokenStream(adaptor,"token 84");
        RewriteRuleTokenStream stream_88=new RewriteRuleTokenStream(adaptor,"token 88");
        RewriteRuleSubtreeStream stream_modelDeclarationParameter=new RewriteRuleSubtreeStream(adaptor,"rule modelDeclarationParameter");
        try {
            // EolParserRules.g:129:2: ( '{' ( modelDeclarationParameter )? ( ',' modelDeclarationParameter )* '}' -> ^( MODELDECLARATIONPARAMETERS ( modelDeclarationParameter )* ) )
            // EolParserRules.g:129:4: '{' ( modelDeclarationParameter )? ( ',' modelDeclarationParameter )* '}'
            {
            char_literal19=(Token)match(input,87,FOLLOW_87_in_modelDeclarationParameters394); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_87.add(char_literal19);

            // EolParserRules.g:129:8: ( modelDeclarationParameter )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==NAME) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // EolParserRules.g:0:0: modelDeclarationParameter
                    {
                    pushFollow(FOLLOW_modelDeclarationParameter_in_modelDeclarationParameters396);
                    modelDeclarationParameter20=modelDeclarationParameter();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_modelDeclarationParameter.add(modelDeclarationParameter20.getTree());

                    }
                    break;

            }

            // EolParserRules.g:129:35: ( ',' modelDeclarationParameter )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==84) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // EolParserRules.g:129:36: ',' modelDeclarationParameter
            	    {
            	    char_literal21=(Token)match(input,84,FOLLOW_84_in_modelDeclarationParameters400); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_84.add(char_literal21);

            	    pushFollow(FOLLOW_modelDeclarationParameter_in_modelDeclarationParameters402);
            	    modelDeclarationParameter22=modelDeclarationParameter();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_modelDeclarationParameter.add(modelDeclarationParameter22.getTree());

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            char_literal23=(Token)match(input,88,FOLLOW_88_in_modelDeclarationParameters406); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_88.add(char_literal23);



            // AST REWRITE
            // elements: modelDeclarationParameter
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 130:2: -> ^( MODELDECLARATIONPARAMETERS ( modelDeclarationParameter )* )
            {
                // EolParserRules.g:130:5: ^( MODELDECLARATIONPARAMETERS ( modelDeclarationParameter )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(MODELDECLARATIONPARAMETERS, "MODELDECLARATIONPARAMETERS"), root_1);

                // EolParserRules.g:130:34: ( modelDeclarationParameter )*
                while ( stream_modelDeclarationParameter.hasNext() ) {
                    adaptor.addChild(root_1, stream_modelDeclarationParameter.nextTree());

                }
                stream_modelDeclarationParameter.reset();

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
    // $ANTLR end modelDeclarationParameters

    public static class modelDeclarationParameter_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start modelDeclarationParameter
    // EolParserRules.g:133:1: modelDeclarationParameter : NAME '=' STRING -> ^( MODELDECLARATIONPARAMETER NAME STRING ) ;
    public final Flock_EolParserRules.modelDeclarationParameter_return modelDeclarationParameter() throws RecognitionException {
        Flock_EolParserRules.modelDeclarationParameter_return retval = new Flock_EolParserRules.modelDeclarationParameter_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NAME24=null;
        Token char_literal25=null;
        Token STRING26=null;

        CommonTree NAME24_tree=null;
        CommonTree char_literal25_tree=null;
        CommonTree STRING26_tree=null;
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");
        RewriteRuleTokenStream stream_89=new RewriteRuleTokenStream(adaptor,"token 89");

        try {
            // EolParserRules.g:134:2: ( NAME '=' STRING -> ^( MODELDECLARATIONPARAMETER NAME STRING ) )
            // EolParserRules.g:134:4: NAME '=' STRING
            {
            NAME24=(Token)match(input,NAME,FOLLOW_NAME_in_modelDeclarationParameter430); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(NAME24);

            char_literal25=(Token)match(input,89,FOLLOW_89_in_modelDeclarationParameter432); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_89.add(char_literal25);

            STRING26=(Token)match(input,STRING,FOLLOW_STRING_in_modelDeclarationParameter434); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_STRING.add(STRING26);



            // AST REWRITE
            // elements: NAME, STRING
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 135:2: -> ^( MODELDECLARATIONPARAMETER NAME STRING )
            {
                // EolParserRules.g:135:5: ^( MODELDECLARATIONPARAMETER NAME STRING )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(MODELDECLARATIONPARAMETER, "MODELDECLARATIONPARAMETER"), root_1);

                adaptor.addChild(root_1, stream_NAME.nextNode());
                adaptor.addChild(root_1, stream_STRING.nextNode());

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
    // $ANTLR end modelDeclarationParameter

    public static class operationDeclaration_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start operationDeclaration
    // EolParserRules.g:138:1: operationDeclaration : ( 'operation' | 'function' ) (ctx= typeName )? operationName= NAME '(' ( formalParameterList )? ')' ( ':' returnType= typeName )? statementBlock -> ^( HELPERMETHOD ( $ctx)? $operationName ( formalParameterList )? ( $returnType)? statementBlock ) ;
    public final Flock_EolParserRules.operationDeclaration_return operationDeclaration() throws RecognitionException {
        Flock_EolParserRules.operationDeclaration_return retval = new Flock_EolParserRules.operationDeclaration_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token operationName=null;
        Token string_literal27=null;
        Token string_literal28=null;
        Token char_literal29=null;
        Token char_literal31=null;
        Token char_literal32=null;
        Flock_EolParserRules.typeName_return ctx = null;

        Flock_EolParserRules.typeName_return returnType = null;

        Flock_EolParserRules.formalParameterList_return formalParameterList30 = null;

        Flock_EolParserRules.statementBlock_return statementBlock33 = null;


        CommonTree operationName_tree=null;
        CommonTree string_literal27_tree=null;
        CommonTree string_literal28_tree=null;
        CommonTree char_literal29_tree=null;
        CommonTree char_literal31_tree=null;
        CommonTree char_literal32_tree=null;
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_93=new RewriteRuleTokenStream(adaptor,"token 93");
        RewriteRuleTokenStream stream_92=new RewriteRuleTokenStream(adaptor,"token 92");
        RewriteRuleTokenStream stream_91=new RewriteRuleTokenStream(adaptor,"token 91");
        RewriteRuleTokenStream stream_90=new RewriteRuleTokenStream(adaptor,"token 90");
        RewriteRuleTokenStream stream_83=new RewriteRuleTokenStream(adaptor,"token 83");
        RewriteRuleSubtreeStream stream_typeName=new RewriteRuleSubtreeStream(adaptor,"rule typeName");
        RewriteRuleSubtreeStream stream_statementBlock=new RewriteRuleSubtreeStream(adaptor,"rule statementBlock");
        RewriteRuleSubtreeStream stream_formalParameterList=new RewriteRuleSubtreeStream(adaptor,"rule formalParameterList");
        try {
            // EolParserRules.g:140:2: ( ( 'operation' | 'function' ) (ctx= typeName )? operationName= NAME '(' ( formalParameterList )? ')' ( ':' returnType= typeName )? statementBlock -> ^( HELPERMETHOD ( $ctx)? $operationName ( formalParameterList )? ( $returnType)? statementBlock ) )
            // EolParserRules.g:140:4: ( 'operation' | 'function' ) (ctx= typeName )? operationName= NAME '(' ( formalParameterList )? ')' ( ':' returnType= typeName )? statementBlock
            {
            // EolParserRules.g:140:4: ( 'operation' | 'function' )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==90) ) {
                alt9=1;
            }
            else if ( (LA9_0==91) ) {
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
                    // EolParserRules.g:140:5: 'operation'
                    {
                    string_literal27=(Token)match(input,90,FOLLOW_90_in_operationDeclaration460); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_90.add(string_literal27);


                    }
                    break;
                case 2 :
                    // EolParserRules.g:140:17: 'function'
                    {
                    string_literal28=(Token)match(input,91,FOLLOW_91_in_operationDeclaration462); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_91.add(string_literal28);


                    }
                    break;

            }

            // EolParserRules.g:140:29: (ctx= typeName )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==NAME) ) {
                int LA10_1 = input.LA(2);

                if ( (LA10_1==NAME||(LA10_1>=96 && LA10_1<=98)) ) {
                    alt10=1;
                }
            }
            else if ( ((LA10_0>=99 && LA10_0<=106)) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // EolParserRules.g:140:30: ctx= typeName
                    {
                    pushFollow(FOLLOW_typeName_in_operationDeclaration468);
                    ctx=typeName();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_typeName.add(ctx.getTree());
                    if ( state.backtracking==0 ) {
                      setTokenType(ctx,TYPE);
                    }

                    }
                    break;

            }

            operationName=(Token)match(input,NAME,FOLLOW_NAME_in_operationDeclaration476); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(operationName);

            char_literal29=(Token)match(input,92,FOLLOW_92_in_operationDeclaration478); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_92.add(char_literal29);

            // EolParserRules.g:140:94: ( formalParameterList )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==NAME) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // EolParserRules.g:0:0: formalParameterList
                    {
                    pushFollow(FOLLOW_formalParameterList_in_operationDeclaration480);
                    formalParameterList30=formalParameterList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_formalParameterList.add(formalParameterList30.getTree());

                    }
                    break;

            }

            char_literal31=(Token)match(input,93,FOLLOW_93_in_operationDeclaration483); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_93.add(char_literal31);

            // EolParserRules.g:140:119: ( ':' returnType= typeName )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==83) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // EolParserRules.g:140:120: ':' returnType= typeName
                    {
                    char_literal32=(Token)match(input,83,FOLLOW_83_in_operationDeclaration486); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_83.add(char_literal32);

                    pushFollow(FOLLOW_typeName_in_operationDeclaration490);
                    returnType=typeName();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_typeName.add(returnType.getTree());
                    if ( state.backtracking==0 ) {
                      setTokenType(returnType,TYPE);
                    }

                    }
                    break;

            }

            pushFollow(FOLLOW_statementBlock_in_operationDeclaration496);
            statementBlock33=statementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_statementBlock.add(statementBlock33.getTree());


            // AST REWRITE
            // elements: operationName, formalParameterList, ctx, returnType, statementBlock
            // token labels: operationName
            // rule labels: retval, ctx, returnType
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_operationName=new RewriteRuleTokenStream(adaptor,"token operationName",operationName);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_ctx=new RewriteRuleSubtreeStream(adaptor,"token ctx",ctx!=null?ctx.tree:null);
            RewriteRuleSubtreeStream stream_returnType=new RewriteRuleSubtreeStream(adaptor,"token returnType",returnType!=null?returnType.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 141:3: -> ^( HELPERMETHOD ( $ctx)? $operationName ( formalParameterList )? ( $returnType)? statementBlock )
            {
                // EolParserRules.g:141:6: ^( HELPERMETHOD ( $ctx)? $operationName ( formalParameterList )? ( $returnType)? statementBlock )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(HELPERMETHOD, "HELPERMETHOD"), root_1);

                // EolParserRules.g:141:21: ( $ctx)?
                if ( stream_ctx.hasNext() ) {
                    adaptor.addChild(root_1, stream_ctx.nextTree());

                }
                stream_ctx.reset();
                adaptor.addChild(root_1, stream_operationName.nextNode());
                // EolParserRules.g:141:42: ( formalParameterList )?
                if ( stream_formalParameterList.hasNext() ) {
                    adaptor.addChild(root_1, stream_formalParameterList.nextTree());

                }
                stream_formalParameterList.reset();
                // EolParserRules.g:141:63: ( $returnType)?
                if ( stream_returnType.hasNext() ) {
                    adaptor.addChild(root_1, stream_returnType.nextTree());

                }
                stream_returnType.reset();
                adaptor.addChild(root_1, stream_statementBlock.nextTree());

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
    // $ANTLR end operationDeclaration

    public static class importStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start importStatement
    // EolParserRules.g:144:1: importStatement : i= 'import' STRING ';' ;
    public final Flock_EolParserRules.importStatement_return importStatement() throws RecognitionException {
        Flock_EolParserRules.importStatement_return retval = new Flock_EolParserRules.importStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token i=null;
        Token STRING34=null;
        Token char_literal35=null;

        CommonTree i_tree=null;
        CommonTree STRING34_tree=null;
        CommonTree char_literal35_tree=null;

        try {
            // EolParserRules.g:145:2: (i= 'import' STRING ';' )
            // EolParserRules.g:145:4: i= 'import' STRING ';'
            {
            root_0 = (CommonTree)adaptor.nil();

            i=(Token)match(input,94,FOLLOW_94_in_importStatement533); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            i_tree = (CommonTree)adaptor.create(i);
            root_0 = (CommonTree)adaptor.becomeRoot(i_tree, root_0);
            }
            STRING34=(Token)match(input,STRING,FOLLOW_STRING_in_importStatement536); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STRING34_tree = (CommonTree)adaptor.create(STRING34);
            adaptor.addChild(root_0, STRING34_tree);
            }
            char_literal35=(Token)match(input,82,FOLLOW_82_in_importStatement538); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
              i.setType(IMPORT);
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
    // $ANTLR end importStatement

    public static class block_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start block
    // EolParserRules.g:149:1: block : ( statement )* -> ^( BLOCK ( statement )* ) ;
    public final Flock_EolParserRules.block_return block() throws RecognitionException {
        Flock_EolParserRules.block_return retval = new Flock_EolParserRules.block_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Flock_EolParserRules.statement_return statement36 = null;


        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        try {
            // EolParserRules.g:150:2: ( ( statement )* -> ^( BLOCK ( statement )* ) )
            // EolParserRules.g:150:4: ( statement )*
            {
            // EolParserRules.g:150:4: ( statement )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==FLOAT||LA13_0==INT||LA13_0==BOOLEAN||LA13_0==STRING||LA13_0==NAME||LA13_0==92||(LA13_0>=99 && LA13_0<=107)||(LA13_0>=109 && LA13_0<=110)||(LA13_0>=114 && LA13_0<=122)||LA13_0==136||LA13_0==139||(LA13_0>=143 && LA13_0<=144)) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // EolParserRules.g:0:0: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_block553);
            	    statement36=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_statement.add(statement36.getTree());

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);



            // AST REWRITE
            // elements: statement
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 151:2: -> ^( BLOCK ( statement )* )
            {
                // EolParserRules.g:151:5: ^( BLOCK ( statement )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(BLOCK, "BLOCK"), root_1);

                // EolParserRules.g:151:13: ( statement )*
                while ( stream_statement.hasNext() ) {
                    adaptor.addChild(root_1, stream_statement.nextTree());

                }
                stream_statement.reset();

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
    // $ANTLR end block

    public static class statementBlock_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start statementBlock
    // EolParserRules.g:154:1: statementBlock : '{' block '}' ;
    public final Flock_EolParserRules.statementBlock_return statementBlock() throws RecognitionException {
        Flock_EolParserRules.statementBlock_return retval = new Flock_EolParserRules.statementBlock_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal37=null;
        Token char_literal39=null;
        Flock_EolParserRules.block_return block38 = null;


        CommonTree char_literal37_tree=null;
        CommonTree char_literal39_tree=null;

        try {
            // EolParserRules.g:155:2: ( '{' block '}' )
            // EolParserRules.g:155:4: '{' block '}'
            {
            root_0 = (CommonTree)adaptor.nil();

            char_literal37=(Token)match(input,87,FOLLOW_87_in_statementBlock575); if (state.failed) return retval;
            pushFollow(FOLLOW_block_in_statementBlock578);
            block38=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, block38.getTree());
            char_literal39=(Token)match(input,88,FOLLOW_88_in_statementBlock580); if (state.failed) return retval;

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
    // $ANTLR end statementBlock

    public static class formalParameter_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start formalParameter
    // EolParserRules.g:158:1: formalParameter : NAME ( ':' pt= typeName )? -> ^( FORMAL NAME ( typeName )? ) ;
    public final Flock_EolParserRules.formalParameter_return formalParameter() throws RecognitionException {
        Flock_EolParserRules.formalParameter_return retval = new Flock_EolParserRules.formalParameter_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NAME40=null;
        Token char_literal41=null;
        Flock_EolParserRules.typeName_return pt = null;


        CommonTree NAME40_tree=null;
        CommonTree char_literal41_tree=null;
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_83=new RewriteRuleTokenStream(adaptor,"token 83");
        RewriteRuleSubtreeStream stream_typeName=new RewriteRuleSubtreeStream(adaptor,"rule typeName");
        try {
            // EolParserRules.g:159:2: ( NAME ( ':' pt= typeName )? -> ^( FORMAL NAME ( typeName )? ) )
            // EolParserRules.g:159:4: NAME ( ':' pt= typeName )?
            {
            NAME40=(Token)match(input,NAME,FOLLOW_NAME_in_formalParameter592); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(NAME40);

            // EolParserRules.g:159:9: ( ':' pt= typeName )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==83) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // EolParserRules.g:159:10: ':' pt= typeName
                    {
                    char_literal41=(Token)match(input,83,FOLLOW_83_in_formalParameter595); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_83.add(char_literal41);

                    pushFollow(FOLLOW_typeName_in_formalParameter599);
                    pt=typeName();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_typeName.add(pt.getTree());
                    if ( state.backtracking==0 ) {
                      setTokenType(pt,TYPE);
                    }

                    }
                    break;

            }



            // AST REWRITE
            // elements: NAME, typeName
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 160:3: -> ^( FORMAL NAME ( typeName )? )
            {
                // EolParserRules.g:160:6: ^( FORMAL NAME ( typeName )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FORMAL, "FORMAL"), root_1);

                adaptor.addChild(root_1, stream_NAME.nextNode());
                // EolParserRules.g:160:20: ( typeName )?
                if ( stream_typeName.hasNext() ) {
                    adaptor.addChild(root_1, stream_typeName.nextTree());

                }
                stream_typeName.reset();

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
    // $ANTLR end formalParameter

    public static class formalParameterList_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start formalParameterList
    // EolParserRules.g:163:1: formalParameterList : formalParameter ( ',' formalParameter )* -> ^( PARAMLIST ( formalParameter )* ) ;
    public final Flock_EolParserRules.formalParameterList_return formalParameterList() throws RecognitionException {
        Flock_EolParserRules.formalParameterList_return retval = new Flock_EolParserRules.formalParameterList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal43=null;
        Flock_EolParserRules.formalParameter_return formalParameter42 = null;

        Flock_EolParserRules.formalParameter_return formalParameter44 = null;


        CommonTree char_literal43_tree=null;
        RewriteRuleTokenStream stream_84=new RewriteRuleTokenStream(adaptor,"token 84");
        RewriteRuleSubtreeStream stream_formalParameter=new RewriteRuleSubtreeStream(adaptor,"rule formalParameter");
        try {
            // EolParserRules.g:164:2: ( formalParameter ( ',' formalParameter )* -> ^( PARAMLIST ( formalParameter )* ) )
            // EolParserRules.g:164:4: formalParameter ( ',' formalParameter )*
            {
            pushFollow(FOLLOW_formalParameter_in_formalParameterList628);
            formalParameter42=formalParameter();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_formalParameter.add(formalParameter42.getTree());
            // EolParserRules.g:164:20: ( ',' formalParameter )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==84) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // EolParserRules.g:164:21: ',' formalParameter
            	    {
            	    char_literal43=(Token)match(input,84,FOLLOW_84_in_formalParameterList631); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_84.add(char_literal43);

            	    pushFollow(FOLLOW_formalParameter_in_formalParameterList633);
            	    formalParameter44=formalParameter();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_formalParameter.add(formalParameter44.getTree());

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);



            // AST REWRITE
            // elements: formalParameter
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 165:2: -> ^( PARAMLIST ( formalParameter )* )
            {
                // EolParserRules.g:165:5: ^( PARAMLIST ( formalParameter )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PARAMLIST, "PARAMLIST"), root_1);

                // EolParserRules.g:165:17: ( formalParameter )*
                while ( stream_formalParameter.hasNext() ) {
                    adaptor.addChild(root_1, stream_formalParameter.nextTree());

                }
                stream_formalParameter.reset();

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
    // $ANTLR end formalParameterList

    public static class executableAnnotation_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start executableAnnotation
    // EolParserRules.g:168:1: executableAnnotation : '$' x= . logicalExpression -> ^( EXECUTABLEANNOTATION $x logicalExpression ) ;
    public final Flock_EolParserRules.executableAnnotation_return executableAnnotation() throws RecognitionException {
        Flock_EolParserRules.executableAnnotation_return retval = new Flock_EolParserRules.executableAnnotation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token x=null;
        Token char_literal45=null;
        Flock_EolParserRules.logicalExpression_return logicalExpression46 = null;


        CommonTree x_tree=null;
        CommonTree char_literal45_tree=null;
        RewriteRuleTokenStream stream_95=new RewriteRuleTokenStream(adaptor,"token 95");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:169:2: ( '$' x= . logicalExpression -> ^( EXECUTABLEANNOTATION $x logicalExpression ) )
            // EolParserRules.g:169:4: '$' x= . logicalExpression
            {
            char_literal45=(Token)match(input,95,FOLLOW_95_in_executableAnnotation656); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_95.add(char_literal45);

            x=(Token)input.LT(1);
            matchAny(input); if (state.failed) return retval;
            pushFollow(FOLLOW_logicalExpression_in_executableAnnotation662);
            logicalExpression46=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression46.getTree());


            // AST REWRITE
            // elements: x, logicalExpression
            // token labels: x
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_x=new RewriteRuleTokenStream(adaptor,"token x",x);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 170:2: -> ^( EXECUTABLEANNOTATION $x logicalExpression )
            {
                // EolParserRules.g:170:5: ^( EXECUTABLEANNOTATION $x logicalExpression )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(EXECUTABLEANNOTATION, "EXECUTABLEANNOTATION"), root_1);

                adaptor.addChild(root_1, stream_x.nextNode());
                adaptor.addChild(root_1, stream_logicalExpression.nextTree());

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
    // $ANTLR end executableAnnotation

    public static class annotation_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start annotation
    // EolParserRules.g:173:1: annotation : ( Annotation | executableAnnotation );
    public final Flock_EolParserRules.annotation_return annotation() throws RecognitionException {
        Flock_EolParserRules.annotation_return retval = new Flock_EolParserRules.annotation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token Annotation47=null;
        Flock_EolParserRules.executableAnnotation_return executableAnnotation48 = null;


        CommonTree Annotation47_tree=null;

        try {
            // EolParserRules.g:174:2: ( Annotation | executableAnnotation )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==Annotation) ) {
                alt16=1;
            }
            else if ( (LA16_0==95) ) {
                alt16=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // EolParserRules.g:174:4: Annotation
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    Annotation47=(Token)match(input,Annotation,FOLLOW_Annotation_in_annotation685); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    Annotation47_tree = (CommonTree)adaptor.create(Annotation47);
                    adaptor.addChild(root_0, Annotation47_tree);
                    }

                    }
                    break;
                case 2 :
                    // EolParserRules.g:174:15: executableAnnotation
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_executableAnnotation_in_annotation687);
                    executableAnnotation48=executableAnnotation();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, executableAnnotation48.getTree());

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
    // $ANTLR end annotation

    public static class annotationBlock_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start annotationBlock
    // EolParserRules.g:177:1: annotationBlock : ( annotation )+ -> ^( ANNOTATIONBLOCK ( annotation )+ ) ;
    public final Flock_EolParserRules.annotationBlock_return annotationBlock() throws RecognitionException {
        Flock_EolParserRules.annotationBlock_return retval = new Flock_EolParserRules.annotationBlock_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Flock_EolParserRules.annotation_return annotation49 = null;


        RewriteRuleSubtreeStream stream_annotation=new RewriteRuleSubtreeStream(adaptor,"rule annotation");
        try {
            // EolParserRules.g:178:2: ( ( annotation )+ -> ^( ANNOTATIONBLOCK ( annotation )+ ) )
            // EolParserRules.g:178:4: ( annotation )+
            {
            // EolParserRules.g:178:4: ( annotation )+
            int cnt17=0;
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==Annotation||LA17_0==95) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // EolParserRules.g:0:0: annotation
            	    {
            	    pushFollow(FOLLOW_annotation_in_annotationBlock698);
            	    annotation49=annotation();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_annotation.add(annotation49.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt17 >= 1 ) break loop17;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(17, input);
                        throw eee;
                }
                cnt17++;
            } while (true);



            // AST REWRITE
            // elements: annotation
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 179:2: -> ^( ANNOTATIONBLOCK ( annotation )+ )
            {
                // EolParserRules.g:179:5: ^( ANNOTATIONBLOCK ( annotation )+ )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ANNOTATIONBLOCK, "ANNOTATIONBLOCK"), root_1);

                if ( !(stream_annotation.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_annotation.hasNext() ) {
                    adaptor.addChild(root_1, stream_annotation.nextTree());

                }
                stream_annotation.reset();

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
    // $ANTLR end annotationBlock

    public static class typeName_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start typeName
    // EolParserRules.g:182:1: typeName : ( pathName | nativeType | collectionType );
    public final Flock_EolParserRules.typeName_return typeName() throws RecognitionException {
        Flock_EolParserRules.typeName_return retval = new Flock_EolParserRules.typeName_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Flock_EolParserRules.pathName_return pathName50 = null;

        Flock_EolParserRules.nativeType_return nativeType51 = null;

        Flock_EolParserRules.collectionType_return collectionType52 = null;



        try {
            // EolParserRules.g:183:2: ( pathName | nativeType | collectionType )
            int alt18=3;
            switch ( input.LA(1) ) {
            case NAME:
                {
                alt18=1;
                }
                break;
            case 99:
                {
                alt18=2;
                }
                break;
            case 100:
            case 101:
            case 102:
            case 103:
            case 104:
            case 105:
            case 106:
                {
                alt18=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // EolParserRules.g:183:4: pathName
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_pathName_in_typeName721);
                    pathName50=pathName();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pathName50.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:183:15: nativeType
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_nativeType_in_typeName725);
                    nativeType51=nativeType();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nativeType51.getTree());

                    }
                    break;
                case 3 :
                    // EolParserRules.g:183:28: collectionType
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_collectionType_in_typeName729);
                    collectionType52=collectionType();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, collectionType52.getTree());
                    if ( state.backtracking==0 ) {
                      if (root_0.getToken() != null) root_0.getToken().setType(TYPE);
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
    // $ANTLR end typeName

    public static class pathName_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start pathName
    // EolParserRules.g:187:1: pathName : (metamodel= NAME '!' )? head= packagedType ( '#' label= NAME )? ;
    public final Flock_EolParserRules.pathName_return pathName() throws RecognitionException {
        Flock_EolParserRules.pathName_return retval = new Flock_EolParserRules.pathName_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token metamodel=null;
        Token label=null;
        Token char_literal53=null;
        Token char_literal54=null;
        Flock_EolParserRules.packagedType_return head = null;


        CommonTree metamodel_tree=null;
        CommonTree label_tree=null;
        CommonTree char_literal53_tree=null;
        CommonTree char_literal54_tree=null;

        try {
            // EolParserRules.g:188:2: ( (metamodel= NAME '!' )? head= packagedType ( '#' label= NAME )? )
            // EolParserRules.g:188:4: (metamodel= NAME '!' )? head= packagedType ( '#' label= NAME )?
            {
            root_0 = (CommonTree)adaptor.nil();

            // EolParserRules.g:188:4: (metamodel= NAME '!' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==NAME) ) {
                int LA19_1 = input.LA(2);

                if ( (LA19_1==96) ) {
                    alt19=1;
                }
            }
            switch (alt19) {
                case 1 :
                    // EolParserRules.g:188:5: metamodel= NAME '!'
                    {
                    metamodel=(Token)match(input,NAME,FOLLOW_NAME_in_pathName746); if (state.failed) return retval;
                    char_literal53=(Token)match(input,96,FOLLOW_96_in_pathName749); if (state.failed) return retval;

                    }
                    break;

            }

            pushFollow(FOLLOW_packagedType_in_pathName758);
            head=packagedType();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, head.getTree());
            // EolParserRules.g:190:3: ( '#' label= NAME )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==97) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // EolParserRules.g:190:4: '#' label= NAME
                    {
                    char_literal54=(Token)match(input,97,FOLLOW_97_in_pathName763); if (state.failed) return retval;
                    label=(Token)match(input,NAME,FOLLOW_NAME_in_pathName768); if (state.failed) return retval;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              
              			if (metamodel != null) {
              				(head!=null?((CommonTree)head.tree):null).token.setText(metamodel.getText() + "!" + (head!=null?((CommonTree)head.tree):null).token.getText());
              				//System.err.println("Metamodel is not null");
              			}
              				
              			if (label != null) {
              				(head!=null?((CommonTree)head.tree):null).token.setText((head!=null?((CommonTree)head.tree):null).token.getText() + "#" + label.getText());
              				(head!=null?((CommonTree)head.tree):null).token.setType(ENUMERATION_VALUE);
              			}	
              		
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
    // $ANTLR end pathName

    public static class packagedType_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start packagedType
    // EolParserRules.g:205:1: packagedType : head= NAME ( '::' field= NAME )* ;
    public final Flock_EolParserRules.packagedType_return packagedType() throws RecognitionException {
        Flock_EolParserRules.packagedType_return retval = new Flock_EolParserRules.packagedType_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token head=null;
        Token field=null;
        Token string_literal55=null;

        CommonTree head_tree=null;
        CommonTree field_tree=null;
        CommonTree string_literal55_tree=null;

        try {
            // EolParserRules.g:206:2: (head= NAME ( '::' field= NAME )* )
            // EolParserRules.g:206:4: head= NAME ( '::' field= NAME )*
            {
            root_0 = (CommonTree)adaptor.nil();

            head=(Token)match(input,NAME,FOLLOW_NAME_in_packagedType790); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            head_tree = (CommonTree)adaptor.create(head);
            adaptor.addChild(root_0, head_tree);
            }
            // EolParserRules.g:206:14: ( '::' field= NAME )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==98) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // EolParserRules.g:206:15: '::' field= NAME
            	    {
            	    string_literal55=(Token)match(input,98,FOLLOW_98_in_packagedType793); if (state.failed) return retval;
            	    field=(Token)match(input,NAME,FOLLOW_NAME_in_packagedType798); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	       head.setText(head.getText() + "::" + field.getText()); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop21;
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
    // $ANTLR end packagedType

    public static class nativeType_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start nativeType
    // EolParserRules.g:209:1: nativeType : 'Native' '(' STRING ')' ;
    public final Flock_EolParserRules.nativeType_return nativeType() throws RecognitionException {
        Flock_EolParserRules.nativeType_return retval = new Flock_EolParserRules.nativeType_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal56=null;
        Token char_literal57=null;
        Token STRING58=null;
        Token char_literal59=null;

        CommonTree string_literal56_tree=null;
        CommonTree char_literal57_tree=null;
        CommonTree STRING58_tree=null;
        CommonTree char_literal59_tree=null;

        try {
            // EolParserRules.g:210:2: ( 'Native' '(' STRING ')' )
            // EolParserRules.g:210:4: 'Native' '(' STRING ')'
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal56=(Token)match(input,99,FOLLOW_99_in_nativeType814); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal56_tree = (CommonTree)adaptor.create(string_literal56);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal56_tree, root_0);
            }
            char_literal57=(Token)match(input,92,FOLLOW_92_in_nativeType817); if (state.failed) return retval;
            STRING58=(Token)match(input,STRING,FOLLOW_STRING_in_nativeType820); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STRING58_tree = (CommonTree)adaptor.create(STRING58);
            adaptor.addChild(root_0, STRING58_tree);
            }
            char_literal59=(Token)match(input,93,FOLLOW_93_in_nativeType822); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
              if (root_0.getToken() != null) root_0.getToken().setType(TYPE);
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
    // $ANTLR end nativeType

    public static class collectionType_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start collectionType
    // EolParserRules.g:215:1: collectionType : ( 'Collection' | 'Sequence' | 'List' | 'Bag' | 'Set' | 'OrderedSet' | 'Map' ) ( '(' tn= typeName ')' )? ;
    public final Flock_EolParserRules.collectionType_return collectionType() throws RecognitionException {
        Flock_EolParserRules.collectionType_return retval = new Flock_EolParserRules.collectionType_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set60=null;
        Token char_literal61=null;
        Token char_literal62=null;
        Flock_EolParserRules.typeName_return tn = null;


        CommonTree set60_tree=null;
        CommonTree char_literal61_tree=null;
        CommonTree char_literal62_tree=null;

        try {
            // EolParserRules.g:216:2: ( ( 'Collection' | 'Sequence' | 'List' | 'Bag' | 'Set' | 'OrderedSet' | 'Map' ) ( '(' tn= typeName ')' )? )
            // EolParserRules.g:216:5: ( 'Collection' | 'Sequence' | 'List' | 'Bag' | 'Set' | 'OrderedSet' | 'Map' ) ( '(' tn= typeName ')' )?
            {
            root_0 = (CommonTree)adaptor.nil();

            set60=(Token)input.LT(1);
            set60=(Token)input.LT(1);
            if ( (input.LA(1)>=100 && input.LA(1)<=106) ) {
                input.consume();
                if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(set60), root_0);
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            // EolParserRules.g:217:3: ( '(' tn= typeName ')' )?
            int alt22=2;
            alt22 = dfa22.predict(input);
            switch (alt22) {
                case 1 :
                    // EolParserRules.g:217:4: '(' tn= typeName ')'
                    {
                    char_literal61=(Token)match(input,92,FOLLOW_92_in_collectionType860); if (state.failed) return retval;
                    pushFollow(FOLLOW_typeName_in_collectionType865);
                    tn=typeName();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, tn.getTree());
                    if ( state.backtracking==0 ) {
                      setTokenType(tn,TYPE);
                    }
                    char_literal62=(Token)match(input,93,FOLLOW_93_in_collectionType868); if (state.failed) return retval;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              if (root_0.getToken() != null) root_0.getToken().setType(TYPE);
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
    // $ANTLR end collectionType

    public static class statement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start statement
    // EolParserRules.g:223:1: statement : ( statementA | statementB );
    public final Flock_EolParserRules.statement_return statement() throws RecognitionException {
        Flock_EolParserRules.statement_return retval = new Flock_EolParserRules.statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Flock_EolParserRules.statementA_return statementA63 = null;

        Flock_EolParserRules.statementB_return statementB64 = null;



        try {
            // EolParserRules.g:224:2: ( statementA | statementB )
            int alt23=2;
            alt23 = dfa23.predict(input);
            switch (alt23) {
                case 1 :
                    // EolParserRules.g:224:4: statementA
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_statementA_in_statement891);
                    statementA63=statementA();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statementA63.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:224:17: statementB
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_statementB_in_statement895);
                    statementB64=statementB();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statementB64.getTree());

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
    // $ANTLR end statement

    public static class statementA_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start statementA
    // EolParserRules.g:227:1: statementA : ( assignmentStatement | expressionStatement | forStatement | ifStatement | whileStatement | switchStatement | returnStatement | breakStatement );
    public final Flock_EolParserRules.statementA_return statementA() throws RecognitionException {
        Flock_EolParserRules.statementA_return retval = new Flock_EolParserRules.statementA_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Flock_EolParserRules.assignmentStatement_return assignmentStatement65 = null;

        Flock_EolParserRules.expressionStatement_return expressionStatement66 = null;

        Flock_EolParserRules.forStatement_return forStatement67 = null;

        Flock_EolParserRules.ifStatement_return ifStatement68 = null;

        Flock_EolParserRules.whileStatement_return whileStatement69 = null;

        Flock_EolParserRules.switchStatement_return switchStatement70 = null;

        Flock_EolParserRules.returnStatement_return returnStatement71 = null;

        Flock_EolParserRules.breakStatement_return breakStatement72 = null;



        try {
            // EolParserRules.g:228:2: ( assignmentStatement | expressionStatement | forStatement | ifStatement | whileStatement | switchStatement | returnStatement | breakStatement )
            int alt24=8;
            alt24 = dfa24.predict(input);
            switch (alt24) {
                case 1 :
                    // EolParserRules.g:228:3: assignmentStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_assignmentStatement_in_statementA905);
                    assignmentStatement65=assignmentStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, assignmentStatement65.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:228:25: expressionStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_expressionStatement_in_statementA909);
                    expressionStatement66=expressionStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionStatement66.getTree());

                    }
                    break;
                case 3 :
                    // EolParserRules.g:228:47: forStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_forStatement_in_statementA913);
                    forStatement67=forStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, forStatement67.getTree());

                    }
                    break;
                case 4 :
                    // EolParserRules.g:229:5: ifStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_ifStatement_in_statementA919);
                    ifStatement68=ifStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, ifStatement68.getTree());

                    }
                    break;
                case 5 :
                    // EolParserRules.g:229:19: whileStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_whileStatement_in_statementA923);
                    whileStatement69=whileStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, whileStatement69.getTree());

                    }
                    break;
                case 6 :
                    // EolParserRules.g:229:36: switchStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_switchStatement_in_statementA927);
                    switchStatement70=switchStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, switchStatement70.getTree());

                    }
                    break;
                case 7 :
                    // EolParserRules.g:229:54: returnStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_returnStatement_in_statementA931);
                    returnStatement71=returnStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, returnStatement71.getTree());

                    }
                    break;
                case 8 :
                    // EolParserRules.g:229:72: breakStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_breakStatement_in_statementA935);
                    breakStatement72=breakStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, breakStatement72.getTree());

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
    // $ANTLR end statementA

    public static class statementB_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start statementB
    // EolParserRules.g:232:1: statementB : ( breakAllStatement | returnStatement | transactionStatement | abortStatement | continueStatement | throwStatement | deleteStatement );
    public final Flock_EolParserRules.statementB_return statementB() throws RecognitionException {
        Flock_EolParserRules.statementB_return retval = new Flock_EolParserRules.statementB_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Flock_EolParserRules.breakAllStatement_return breakAllStatement73 = null;

        Flock_EolParserRules.returnStatement_return returnStatement74 = null;

        Flock_EolParserRules.transactionStatement_return transactionStatement75 = null;

        Flock_EolParserRules.abortStatement_return abortStatement76 = null;

        Flock_EolParserRules.continueStatement_return continueStatement77 = null;

        Flock_EolParserRules.throwStatement_return throwStatement78 = null;

        Flock_EolParserRules.deleteStatement_return deleteStatement79 = null;



        try {
            // EolParserRules.g:233:2: ( breakAllStatement | returnStatement | transactionStatement | abortStatement | continueStatement | throwStatement | deleteStatement )
            int alt25=7;
            switch ( input.LA(1) ) {
            case 119:
                {
                alt25=1;
                }
                break;
            case 115:
                {
                alt25=2;
                }
                break;
            case 122:
                {
                alt25=3;
                }
                break;
            case 121:
                {
                alt25=4;
                }
                break;
            case 120:
                {
                alt25=5;
                }
                break;
            case 116:
                {
                alt25=6;
                }
                break;
            case 117:
                {
                alt25=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }

            switch (alt25) {
                case 1 :
                    // EolParserRules.g:233:4: breakAllStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_breakAllStatement_in_statementB947);
                    breakAllStatement73=breakAllStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, breakAllStatement73.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:233:24: returnStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_returnStatement_in_statementB951);
                    returnStatement74=returnStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, returnStatement74.getTree());

                    }
                    break;
                case 3 :
                    // EolParserRules.g:233:42: transactionStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_transactionStatement_in_statementB955);
                    transactionStatement75=transactionStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, transactionStatement75.getTree());

                    }
                    break;
                case 4 :
                    // EolParserRules.g:234:5: abortStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_abortStatement_in_statementB961);
                    abortStatement76=abortStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, abortStatement76.getTree());

                    }
                    break;
                case 5 :
                    // EolParserRules.g:234:22: continueStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_continueStatement_in_statementB965);
                    continueStatement77=continueStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, continueStatement77.getTree());

                    }
                    break;
                case 6 :
                    // EolParserRules.g:234:42: throwStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_throwStatement_in_statementB969);
                    throwStatement78=throwStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, throwStatement78.getTree());

                    }
                    break;
                case 7 :
                    // EolParserRules.g:235:5: deleteStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_deleteStatement_in_statementB975);
                    deleteStatement79=deleteStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, deleteStatement79.getTree());

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
    // $ANTLR end statementB

    public static class statementOrStatementBlock_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start statementOrStatementBlock
    // EolParserRules.g:238:1: statementOrStatementBlock : ( statement | statementBlock );
    public final Flock_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock() throws RecognitionException {
        Flock_EolParserRules.statementOrStatementBlock_return retval = new Flock_EolParserRules.statementOrStatementBlock_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Flock_EolParserRules.statement_return statement80 = null;

        Flock_EolParserRules.statementBlock_return statementBlock81 = null;



        try {
            // EolParserRules.g:239:2: ( statement | statementBlock )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==FLOAT||LA26_0==INT||LA26_0==BOOLEAN||LA26_0==STRING||LA26_0==NAME||LA26_0==92||(LA26_0>=99 && LA26_0<=107)||(LA26_0>=109 && LA26_0<=110)||(LA26_0>=114 && LA26_0<=122)||LA26_0==136||LA26_0==139||(LA26_0>=143 && LA26_0<=144)) ) {
                alt26=1;
            }
            else if ( (LA26_0==87) ) {
                alt26=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // EolParserRules.g:239:4: statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_statement_in_statementOrStatementBlock986);
                    statement80=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement80.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:239:16: statementBlock
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_statementBlock_in_statementOrStatementBlock990);
                    statementBlock81=statementBlock();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statementBlock81.getTree());

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
    // $ANTLR end statementOrStatementBlock

    public static class expressionOrStatementBlock_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start expressionOrStatementBlock
    // EolParserRules.g:241:1: expressionOrStatementBlock : ( ':' logicalExpression | statementBlock );
    public final Flock_EolParserRules.expressionOrStatementBlock_return expressionOrStatementBlock() throws RecognitionException {
        Flock_EolParserRules.expressionOrStatementBlock_return retval = new Flock_EolParserRules.expressionOrStatementBlock_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal82=null;
        Flock_EolParserRules.logicalExpression_return logicalExpression83 = null;

        Flock_EolParserRules.statementBlock_return statementBlock84 = null;


        CommonTree char_literal82_tree=null;

        try {
            // EolParserRules.g:242:2: ( ':' logicalExpression | statementBlock )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==83) ) {
                alt27=1;
            }
            else if ( (LA27_0==87) ) {
                alt27=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // EolParserRules.g:242:4: ':' logicalExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    char_literal82=(Token)match(input,83,FOLLOW_83_in_expressionOrStatementBlock999); if (state.failed) return retval;
                    pushFollow(FOLLOW_logicalExpression_in_expressionOrStatementBlock1002);
                    logicalExpression83=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression83.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:242:29: statementBlock
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_statementBlock_in_expressionOrStatementBlock1006);
                    statementBlock84=statementBlock();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statementBlock84.getTree());

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
    // $ANTLR end expressionOrStatementBlock

    public static class forStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start forStatement
    // EolParserRules.g:245:1: forStatement : 'for' '(' formalParameter 'in' logicalExpression ')' statementOrStatementBlock -> ^( FOR formalParameter logicalExpression statementOrStatementBlock ) ;
    public final Flock_EolParserRules.forStatement_return forStatement() throws RecognitionException {
        Flock_EolParserRules.forStatement_return retval = new Flock_EolParserRules.forStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal85=null;
        Token char_literal86=null;
        Token string_literal88=null;
        Token char_literal90=null;
        Flock_EolParserRules.formalParameter_return formalParameter87 = null;

        Flock_EolParserRules.logicalExpression_return logicalExpression89 = null;

        Flock_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock91 = null;


        CommonTree string_literal85_tree=null;
        CommonTree char_literal86_tree=null;
        CommonTree string_literal88_tree=null;
        CommonTree char_literal90_tree=null;
        RewriteRuleTokenStream stream_93=new RewriteRuleTokenStream(adaptor,"token 93");
        RewriteRuleTokenStream stream_108=new RewriteRuleTokenStream(adaptor,"token 108");
        RewriteRuleTokenStream stream_92=new RewriteRuleTokenStream(adaptor,"token 92");
        RewriteRuleTokenStream stream_107=new RewriteRuleTokenStream(adaptor,"token 107");
        RewriteRuleSubtreeStream stream_statementOrStatementBlock=new RewriteRuleSubtreeStream(adaptor,"rule statementOrStatementBlock");
        RewriteRuleSubtreeStream stream_formalParameter=new RewriteRuleSubtreeStream(adaptor,"rule formalParameter");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:246:2: ( 'for' '(' formalParameter 'in' logicalExpression ')' statementOrStatementBlock -> ^( FOR formalParameter logicalExpression statementOrStatementBlock ) )
            // EolParserRules.g:246:4: 'for' '(' formalParameter 'in' logicalExpression ')' statementOrStatementBlock
            {
            string_literal85=(Token)match(input,107,FOLLOW_107_in_forStatement1017); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_107.add(string_literal85);

            char_literal86=(Token)match(input,92,FOLLOW_92_in_forStatement1019); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_92.add(char_literal86);

            pushFollow(FOLLOW_formalParameter_in_forStatement1021);
            formalParameter87=formalParameter();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_formalParameter.add(formalParameter87.getTree());
            string_literal88=(Token)match(input,108,FOLLOW_108_in_forStatement1023); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_108.add(string_literal88);

            pushFollow(FOLLOW_logicalExpression_in_forStatement1025);
            logicalExpression89=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression89.getTree());
            char_literal90=(Token)match(input,93,FOLLOW_93_in_forStatement1027); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_93.add(char_literal90);

            pushFollow(FOLLOW_statementOrStatementBlock_in_forStatement1029);
            statementOrStatementBlock91=statementOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_statementOrStatementBlock.add(statementOrStatementBlock91.getTree());


            // AST REWRITE
            // elements: logicalExpression, statementOrStatementBlock, formalParameter
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 247:2: -> ^( FOR formalParameter logicalExpression statementOrStatementBlock )
            {
                // EolParserRules.g:247:5: ^( FOR formalParameter logicalExpression statementOrStatementBlock )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FOR, "FOR"), root_1);

                adaptor.addChild(root_1, stream_formalParameter.nextTree());
                adaptor.addChild(root_1, stream_logicalExpression.nextTree());
                adaptor.addChild(root_1, stream_statementOrStatementBlock.nextTree());

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
    // $ANTLR end forStatement

    public static class ifStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ifStatement
    // EolParserRules.g:250:1: ifStatement : 'if' '(' logicalExpression ')' statementOrStatementBlock ( elseStatement )? -> ^( IF logicalExpression statementOrStatementBlock ( elseStatement )? ) ;
    public final Flock_EolParserRules.ifStatement_return ifStatement() throws RecognitionException {
        Flock_EolParserRules.ifStatement_return retval = new Flock_EolParserRules.ifStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal92=null;
        Token char_literal93=null;
        Token char_literal95=null;
        Flock_EolParserRules.logicalExpression_return logicalExpression94 = null;

        Flock_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock96 = null;

        Flock_EolParserRules.elseStatement_return elseStatement97 = null;


        CommonTree string_literal92_tree=null;
        CommonTree char_literal93_tree=null;
        CommonTree char_literal95_tree=null;
        RewriteRuleTokenStream stream_93=new RewriteRuleTokenStream(adaptor,"token 93");
        RewriteRuleTokenStream stream_109=new RewriteRuleTokenStream(adaptor,"token 109");
        RewriteRuleTokenStream stream_92=new RewriteRuleTokenStream(adaptor,"token 92");
        RewriteRuleSubtreeStream stream_statementOrStatementBlock=new RewriteRuleSubtreeStream(adaptor,"rule statementOrStatementBlock");
        RewriteRuleSubtreeStream stream_elseStatement=new RewriteRuleSubtreeStream(adaptor,"rule elseStatement");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:251:2: ( 'if' '(' logicalExpression ')' statementOrStatementBlock ( elseStatement )? -> ^( IF logicalExpression statementOrStatementBlock ( elseStatement )? ) )
            // EolParserRules.g:251:4: 'if' '(' logicalExpression ')' statementOrStatementBlock ( elseStatement )?
            {
            string_literal92=(Token)match(input,109,FOLLOW_109_in_ifStatement1053); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_109.add(string_literal92);

            char_literal93=(Token)match(input,92,FOLLOW_92_in_ifStatement1055); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_92.add(char_literal93);

            pushFollow(FOLLOW_logicalExpression_in_ifStatement1057);
            logicalExpression94=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression94.getTree());
            char_literal95=(Token)match(input,93,FOLLOW_93_in_ifStatement1059); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_93.add(char_literal95);

            pushFollow(FOLLOW_statementOrStatementBlock_in_ifStatement1061);
            statementOrStatementBlock96=statementOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_statementOrStatementBlock.add(statementOrStatementBlock96.getTree());
            // EolParserRules.g:251:61: ( elseStatement )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==113) ) {
                int LA28_1 = input.LA(2);

                if ( (synpred46_EolParserRules()) ) {
                    alt28=1;
                }
            }
            switch (alt28) {
                case 1 :
                    // EolParserRules.g:0:0: elseStatement
                    {
                    pushFollow(FOLLOW_elseStatement_in_ifStatement1063);
                    elseStatement97=elseStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_elseStatement.add(elseStatement97.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: logicalExpression, elseStatement, statementOrStatementBlock
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 252:2: -> ^( IF logicalExpression statementOrStatementBlock ( elseStatement )? )
            {
                // EolParserRules.g:252:5: ^( IF logicalExpression statementOrStatementBlock ( elseStatement )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(IF, "IF"), root_1);

                adaptor.addChild(root_1, stream_logicalExpression.nextTree());
                adaptor.addChild(root_1, stream_statementOrStatementBlock.nextTree());
                // EolParserRules.g:252:54: ( elseStatement )?
                if ( stream_elseStatement.hasNext() ) {
                    adaptor.addChild(root_1, stream_elseStatement.nextTree());

                }
                stream_elseStatement.reset();

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
    // $ANTLR end ifStatement

    public static class switchStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start switchStatement
    // EolParserRules.g:255:1: switchStatement : 'switch' '(' logicalExpression ')' '{' ( caseStatement )* ( defaultStatement )? '}' -> ^( SWITCH logicalExpression ( caseStatement )* ( defaultStatement )? ) ;
    public final Flock_EolParserRules.switchStatement_return switchStatement() throws RecognitionException {
        Flock_EolParserRules.switchStatement_return retval = new Flock_EolParserRules.switchStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal98=null;
        Token char_literal99=null;
        Token char_literal101=null;
        Token char_literal102=null;
        Token char_literal105=null;
        Flock_EolParserRules.logicalExpression_return logicalExpression100 = null;

        Flock_EolParserRules.caseStatement_return caseStatement103 = null;

        Flock_EolParserRules.defaultStatement_return defaultStatement104 = null;


        CommonTree string_literal98_tree=null;
        CommonTree char_literal99_tree=null;
        CommonTree char_literal101_tree=null;
        CommonTree char_literal102_tree=null;
        CommonTree char_literal105_tree=null;
        RewriteRuleTokenStream stream_93=new RewriteRuleTokenStream(adaptor,"token 93");
        RewriteRuleTokenStream stream_110=new RewriteRuleTokenStream(adaptor,"token 110");
        RewriteRuleTokenStream stream_92=new RewriteRuleTokenStream(adaptor,"token 92");
        RewriteRuleTokenStream stream_87=new RewriteRuleTokenStream(adaptor,"token 87");
        RewriteRuleTokenStream stream_88=new RewriteRuleTokenStream(adaptor,"token 88");
        RewriteRuleSubtreeStream stream_caseStatement=new RewriteRuleSubtreeStream(adaptor,"rule caseStatement");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        RewriteRuleSubtreeStream stream_defaultStatement=new RewriteRuleSubtreeStream(adaptor,"rule defaultStatement");
        try {
            // EolParserRules.g:256:2: ( 'switch' '(' logicalExpression ')' '{' ( caseStatement )* ( defaultStatement )? '}' -> ^( SWITCH logicalExpression ( caseStatement )* ( defaultStatement )? ) )
            // EolParserRules.g:256:4: 'switch' '(' logicalExpression ')' '{' ( caseStatement )* ( defaultStatement )? '}'
            {
            string_literal98=(Token)match(input,110,FOLLOW_110_in_switchStatement1090); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_110.add(string_literal98);

            char_literal99=(Token)match(input,92,FOLLOW_92_in_switchStatement1092); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_92.add(char_literal99);

            pushFollow(FOLLOW_logicalExpression_in_switchStatement1094);
            logicalExpression100=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression100.getTree());
            char_literal101=(Token)match(input,93,FOLLOW_93_in_switchStatement1096); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_93.add(char_literal101);

            char_literal102=(Token)match(input,87,FOLLOW_87_in_switchStatement1098); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_87.add(char_literal102);

            // EolParserRules.g:256:43: ( caseStatement )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==111) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // EolParserRules.g:0:0: caseStatement
            	    {
            	    pushFollow(FOLLOW_caseStatement_in_switchStatement1100);
            	    caseStatement103=caseStatement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_caseStatement.add(caseStatement103.getTree());

            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

            // EolParserRules.g:256:58: ( defaultStatement )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==112) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // EolParserRules.g:0:0: defaultStatement
                    {
                    pushFollow(FOLLOW_defaultStatement_in_switchStatement1103);
                    defaultStatement104=defaultStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_defaultStatement.add(defaultStatement104.getTree());

                    }
                    break;

            }

            char_literal105=(Token)match(input,88,FOLLOW_88_in_switchStatement1106); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_88.add(char_literal105);



            // AST REWRITE
            // elements: logicalExpression, caseStatement, defaultStatement
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 257:2: -> ^( SWITCH logicalExpression ( caseStatement )* ( defaultStatement )? )
            {
                // EolParserRules.g:257:5: ^( SWITCH logicalExpression ( caseStatement )* ( defaultStatement )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(SWITCH, "SWITCH"), root_1);

                adaptor.addChild(root_1, stream_logicalExpression.nextTree());
                // EolParserRules.g:257:32: ( caseStatement )*
                while ( stream_caseStatement.hasNext() ) {
                    adaptor.addChild(root_1, stream_caseStatement.nextTree());

                }
                stream_caseStatement.reset();
                // EolParserRules.g:257:47: ( defaultStatement )?
                if ( stream_defaultStatement.hasNext() ) {
                    adaptor.addChild(root_1, stream_defaultStatement.nextTree());

                }
                stream_defaultStatement.reset();

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
    // $ANTLR end switchStatement

    public static class caseStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start caseStatement
    // EolParserRules.g:260:1: caseStatement : 'case' logicalExpression ':' block -> ^( CASE logicalExpression block ) ;
    public final Flock_EolParserRules.caseStatement_return caseStatement() throws RecognitionException {
        Flock_EolParserRules.caseStatement_return retval = new Flock_EolParserRules.caseStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal106=null;
        Token char_literal108=null;
        Flock_EolParserRules.logicalExpression_return logicalExpression107 = null;

        Flock_EolParserRules.block_return block109 = null;


        CommonTree string_literal106_tree=null;
        CommonTree char_literal108_tree=null;
        RewriteRuleTokenStream stream_111=new RewriteRuleTokenStream(adaptor,"token 111");
        RewriteRuleTokenStream stream_83=new RewriteRuleTokenStream(adaptor,"token 83");
        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:261:2: ( 'case' logicalExpression ':' block -> ^( CASE logicalExpression block ) )
            // EolParserRules.g:261:4: 'case' logicalExpression ':' block
            {
            string_literal106=(Token)match(input,111,FOLLOW_111_in_caseStatement1133); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_111.add(string_literal106);

            pushFollow(FOLLOW_logicalExpression_in_caseStatement1135);
            logicalExpression107=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression107.getTree());
            char_literal108=(Token)match(input,83,FOLLOW_83_in_caseStatement1137); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_83.add(char_literal108);

            pushFollow(FOLLOW_block_in_caseStatement1139);
            block109=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_block.add(block109.getTree());


            // AST REWRITE
            // elements: block, logicalExpression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 262:2: -> ^( CASE logicalExpression block )
            {
                // EolParserRules.g:262:5: ^( CASE logicalExpression block )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CASE, "CASE"), root_1);

                adaptor.addChild(root_1, stream_logicalExpression.nextTree());
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
    // $ANTLR end caseStatement

    public static class defaultStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start defaultStatement
    // EolParserRules.g:265:1: defaultStatement : 'default' ':' block -> ^( DEFAULT block ) ;
    public final Flock_EolParserRules.defaultStatement_return defaultStatement() throws RecognitionException {
        Flock_EolParserRules.defaultStatement_return retval = new Flock_EolParserRules.defaultStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal110=null;
        Token char_literal111=null;
        Flock_EolParserRules.block_return block112 = null;


        CommonTree string_literal110_tree=null;
        CommonTree char_literal111_tree=null;
        RewriteRuleTokenStream stream_112=new RewriteRuleTokenStream(adaptor,"token 112");
        RewriteRuleTokenStream stream_83=new RewriteRuleTokenStream(adaptor,"token 83");
        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        try {
            // EolParserRules.g:266:2: ( 'default' ':' block -> ^( DEFAULT block ) )
            // EolParserRules.g:266:4: 'default' ':' block
            {
            string_literal110=(Token)match(input,112,FOLLOW_112_in_defaultStatement1162); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_112.add(string_literal110);

            char_literal111=(Token)match(input,83,FOLLOW_83_in_defaultStatement1164); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_83.add(char_literal111);

            pushFollow(FOLLOW_block_in_defaultStatement1166);
            block112=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_block.add(block112.getTree());


            // AST REWRITE
            // elements: block
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 267:2: -> ^( DEFAULT block )
            {
                // EolParserRules.g:267:5: ^( DEFAULT block )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(DEFAULT, "DEFAULT"), root_1);

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
    // $ANTLR end defaultStatement

    public static class elseStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start elseStatement
    // EolParserRules.g:270:1: elseStatement : 'else' statementOrStatementBlock ;
    public final Flock_EolParserRules.elseStatement_return elseStatement() throws RecognitionException {
        Flock_EolParserRules.elseStatement_return retval = new Flock_EolParserRules.elseStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal113=null;
        Flock_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock114 = null;


        CommonTree string_literal113_tree=null;

        try {
            // EolParserRules.g:271:2: ( 'else' statementOrStatementBlock )
            // EolParserRules.g:271:4: 'else' statementOrStatementBlock
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal113=(Token)match(input,113,FOLLOW_113_in_elseStatement1187); if (state.failed) return retval;
            pushFollow(FOLLOW_statementOrStatementBlock_in_elseStatement1190);
            statementOrStatementBlock114=statementOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, statementOrStatementBlock114.getTree());

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
    // $ANTLR end elseStatement

    public static class whileStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start whileStatement
    // EolParserRules.g:275:1: whileStatement : 'while' '(' logicalExpression ')' statementOrStatementBlock -> ^( WHILE logicalExpression statementOrStatementBlock ) ;
    public final Flock_EolParserRules.whileStatement_return whileStatement() throws RecognitionException {
        Flock_EolParserRules.whileStatement_return retval = new Flock_EolParserRules.whileStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal115=null;
        Token char_literal116=null;
        Token char_literal118=null;
        Flock_EolParserRules.logicalExpression_return logicalExpression117 = null;

        Flock_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock119 = null;


        CommonTree string_literal115_tree=null;
        CommonTree char_literal116_tree=null;
        CommonTree char_literal118_tree=null;
        RewriteRuleTokenStream stream_114=new RewriteRuleTokenStream(adaptor,"token 114");
        RewriteRuleTokenStream stream_93=new RewriteRuleTokenStream(adaptor,"token 93");
        RewriteRuleTokenStream stream_92=new RewriteRuleTokenStream(adaptor,"token 92");
        RewriteRuleSubtreeStream stream_statementOrStatementBlock=new RewriteRuleSubtreeStream(adaptor,"rule statementOrStatementBlock");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:276:2: ( 'while' '(' logicalExpression ')' statementOrStatementBlock -> ^( WHILE logicalExpression statementOrStatementBlock ) )
            // EolParserRules.g:276:4: 'while' '(' logicalExpression ')' statementOrStatementBlock
            {
            string_literal115=(Token)match(input,114,FOLLOW_114_in_whileStatement1203); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_114.add(string_literal115);

            char_literal116=(Token)match(input,92,FOLLOW_92_in_whileStatement1205); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_92.add(char_literal116);

            pushFollow(FOLLOW_logicalExpression_in_whileStatement1207);
            logicalExpression117=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression117.getTree());
            char_literal118=(Token)match(input,93,FOLLOW_93_in_whileStatement1209); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_93.add(char_literal118);

            pushFollow(FOLLOW_statementOrStatementBlock_in_whileStatement1211);
            statementOrStatementBlock119=statementOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_statementOrStatementBlock.add(statementOrStatementBlock119.getTree());


            // AST REWRITE
            // elements: logicalExpression, statementOrStatementBlock
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 277:2: -> ^( WHILE logicalExpression statementOrStatementBlock )
            {
                // EolParserRules.g:277:5: ^( WHILE logicalExpression statementOrStatementBlock )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(WHILE, "WHILE"), root_1);

                adaptor.addChild(root_1, stream_logicalExpression.nextTree());
                adaptor.addChild(root_1, stream_statementOrStatementBlock.nextTree());

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
    // $ANTLR end whileStatement

    public static class returnStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start returnStatement
    // EolParserRules.g:280:1: returnStatement : 'return' ( logicalExpression )? ';' -> ^( RETURN ( logicalExpression )? ) ;
    public final Flock_EolParserRules.returnStatement_return returnStatement() throws RecognitionException {
        Flock_EolParserRules.returnStatement_return retval = new Flock_EolParserRules.returnStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal120=null;
        Token char_literal122=null;
        Flock_EolParserRules.logicalExpression_return logicalExpression121 = null;


        CommonTree string_literal120_tree=null;
        CommonTree char_literal122_tree=null;
        RewriteRuleTokenStream stream_115=new RewriteRuleTokenStream(adaptor,"token 115");
        RewriteRuleTokenStream stream_82=new RewriteRuleTokenStream(adaptor,"token 82");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:281:2: ( 'return' ( logicalExpression )? ';' -> ^( RETURN ( logicalExpression )? ) )
            // EolParserRules.g:281:4: 'return' ( logicalExpression )? ';'
            {
            string_literal120=(Token)match(input,115,FOLLOW_115_in_returnStatement1233); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_115.add(string_literal120);

            // EolParserRules.g:281:13: ( logicalExpression )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==FLOAT||LA31_0==INT||LA31_0==BOOLEAN||LA31_0==STRING||LA31_0==NAME||LA31_0==92||(LA31_0>=99 && LA31_0<=106)||LA31_0==136||LA31_0==139||(LA31_0>=143 && LA31_0<=144)) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // EolParserRules.g:0:0: logicalExpression
                    {
                    pushFollow(FOLLOW_logicalExpression_in_returnStatement1235);
                    logicalExpression121=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression121.getTree());

                    }
                    break;

            }

            char_literal122=(Token)match(input,82,FOLLOW_82_in_returnStatement1238); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_82.add(char_literal122);



            // AST REWRITE
            // elements: logicalExpression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 282:2: -> ^( RETURN ( logicalExpression )? )
            {
                // EolParserRules.g:282:5: ^( RETURN ( logicalExpression )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(RETURN, "RETURN"), root_1);

                // EolParserRules.g:282:14: ( logicalExpression )?
                if ( stream_logicalExpression.hasNext() ) {
                    adaptor.addChild(root_1, stream_logicalExpression.nextTree());

                }
                stream_logicalExpression.reset();

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
    // $ANTLR end returnStatement

    public static class throwStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start throwStatement
    // EolParserRules.g:285:1: throwStatement : 'throw' ( logicalExpression )? ';' -> ^( THROW ( logicalExpression )? ) ;
    public final Flock_EolParserRules.throwStatement_return throwStatement() throws RecognitionException {
        Flock_EolParserRules.throwStatement_return retval = new Flock_EolParserRules.throwStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal123=null;
        Token char_literal125=null;
        Flock_EolParserRules.logicalExpression_return logicalExpression124 = null;


        CommonTree string_literal123_tree=null;
        CommonTree char_literal125_tree=null;
        RewriteRuleTokenStream stream_116=new RewriteRuleTokenStream(adaptor,"token 116");
        RewriteRuleTokenStream stream_82=new RewriteRuleTokenStream(adaptor,"token 82");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:286:2: ( 'throw' ( logicalExpression )? ';' -> ^( THROW ( logicalExpression )? ) )
            // EolParserRules.g:286:4: 'throw' ( logicalExpression )? ';'
            {
            string_literal123=(Token)match(input,116,FOLLOW_116_in_throwStatement1259); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_116.add(string_literal123);

            // EolParserRules.g:286:12: ( logicalExpression )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==FLOAT||LA32_0==INT||LA32_0==BOOLEAN||LA32_0==STRING||LA32_0==NAME||LA32_0==92||(LA32_0>=99 && LA32_0<=106)||LA32_0==136||LA32_0==139||(LA32_0>=143 && LA32_0<=144)) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // EolParserRules.g:0:0: logicalExpression
                    {
                    pushFollow(FOLLOW_logicalExpression_in_throwStatement1261);
                    logicalExpression124=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression124.getTree());

                    }
                    break;

            }

            char_literal125=(Token)match(input,82,FOLLOW_82_in_throwStatement1264); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_82.add(char_literal125);



            // AST REWRITE
            // elements: logicalExpression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 287:2: -> ^( THROW ( logicalExpression )? )
            {
                // EolParserRules.g:287:5: ^( THROW ( logicalExpression )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(THROW, "THROW"), root_1);

                // EolParserRules.g:287:13: ( logicalExpression )?
                if ( stream_logicalExpression.hasNext() ) {
                    adaptor.addChild(root_1, stream_logicalExpression.nextTree());

                }
                stream_logicalExpression.reset();

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
    // $ANTLR end throwStatement

    public static class deleteStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start deleteStatement
    // EolParserRules.g:290:1: deleteStatement : 'delete' ( logicalExpression )? ';' -> ^( DELETE ( logicalExpression )? ) ;
    public final Flock_EolParserRules.deleteStatement_return deleteStatement() throws RecognitionException {
        Flock_EolParserRules.deleteStatement_return retval = new Flock_EolParserRules.deleteStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal126=null;
        Token char_literal128=null;
        Flock_EolParserRules.logicalExpression_return logicalExpression127 = null;


        CommonTree string_literal126_tree=null;
        CommonTree char_literal128_tree=null;
        RewriteRuleTokenStream stream_117=new RewriteRuleTokenStream(adaptor,"token 117");
        RewriteRuleTokenStream stream_82=new RewriteRuleTokenStream(adaptor,"token 82");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:291:2: ( 'delete' ( logicalExpression )? ';' -> ^( DELETE ( logicalExpression )? ) )
            // EolParserRules.g:291:4: 'delete' ( logicalExpression )? ';'
            {
            string_literal126=(Token)match(input,117,FOLLOW_117_in_deleteStatement1285); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_117.add(string_literal126);

            // EolParserRules.g:291:13: ( logicalExpression )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==FLOAT||LA33_0==INT||LA33_0==BOOLEAN||LA33_0==STRING||LA33_0==NAME||LA33_0==92||(LA33_0>=99 && LA33_0<=106)||LA33_0==136||LA33_0==139||(LA33_0>=143 && LA33_0<=144)) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // EolParserRules.g:0:0: logicalExpression
                    {
                    pushFollow(FOLLOW_logicalExpression_in_deleteStatement1287);
                    logicalExpression127=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression127.getTree());

                    }
                    break;

            }

            char_literal128=(Token)match(input,82,FOLLOW_82_in_deleteStatement1290); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_82.add(char_literal128);



            // AST REWRITE
            // elements: logicalExpression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 292:2: -> ^( DELETE ( logicalExpression )? )
            {
                // EolParserRules.g:292:5: ^( DELETE ( logicalExpression )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(DELETE, "DELETE"), root_1);

                // EolParserRules.g:292:14: ( logicalExpression )?
                if ( stream_logicalExpression.hasNext() ) {
                    adaptor.addChild(root_1, stream_logicalExpression.nextTree());

                }
                stream_logicalExpression.reset();

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
    // $ANTLR end deleteStatement

    public static class breakStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start breakStatement
    // EolParserRules.g:295:1: breakStatement : 'break' ';' -> ^( BREAK ) ;
    public final Flock_EolParserRules.breakStatement_return breakStatement() throws RecognitionException {
        Flock_EolParserRules.breakStatement_return retval = new Flock_EolParserRules.breakStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal129=null;
        Token char_literal130=null;

        CommonTree string_literal129_tree=null;
        CommonTree char_literal130_tree=null;
        RewriteRuleTokenStream stream_82=new RewriteRuleTokenStream(adaptor,"token 82");
        RewriteRuleTokenStream stream_118=new RewriteRuleTokenStream(adaptor,"token 118");

        try {
            // EolParserRules.g:296:2: ( 'break' ';' -> ^( BREAK ) )
            // EolParserRules.g:296:4: 'break' ';'
            {
            string_literal129=(Token)match(input,118,FOLLOW_118_in_breakStatement1314); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_118.add(string_literal129);

            char_literal130=(Token)match(input,82,FOLLOW_82_in_breakStatement1316); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_82.add(char_literal130);



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
            // 297:2: -> ^( BREAK )
            {
                // EolParserRules.g:297:5: ^( BREAK )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(BREAK, "BREAK"), root_1);

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
    // $ANTLR end breakStatement

    public static class breakAllStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start breakAllStatement
    // EolParserRules.g:300:1: breakAllStatement : 'breakAll' ';' -> ^( BREAKALL ) ;
    public final Flock_EolParserRules.breakAllStatement_return breakAllStatement() throws RecognitionException {
        Flock_EolParserRules.breakAllStatement_return retval = new Flock_EolParserRules.breakAllStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal131=null;
        Token char_literal132=null;

        CommonTree string_literal131_tree=null;
        CommonTree char_literal132_tree=null;
        RewriteRuleTokenStream stream_82=new RewriteRuleTokenStream(adaptor,"token 82");
        RewriteRuleTokenStream stream_119=new RewriteRuleTokenStream(adaptor,"token 119");

        try {
            // EolParserRules.g:301:2: ( 'breakAll' ';' -> ^( BREAKALL ) )
            // EolParserRules.g:301:4: 'breakAll' ';'
            {
            string_literal131=(Token)match(input,119,FOLLOW_119_in_breakAllStatement1334); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_119.add(string_literal131);

            char_literal132=(Token)match(input,82,FOLLOW_82_in_breakAllStatement1336); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_82.add(char_literal132);



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
            // 302:2: -> ^( BREAKALL )
            {
                // EolParserRules.g:302:5: ^( BREAKALL )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(BREAKALL, "BREAKALL"), root_1);

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
    // $ANTLR end breakAllStatement

    public static class continueStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start continueStatement
    // EolParserRules.g:305:1: continueStatement : 'continue' ';' -> ^( CONTINUE ) ;
    public final Flock_EolParserRules.continueStatement_return continueStatement() throws RecognitionException {
        Flock_EolParserRules.continueStatement_return retval = new Flock_EolParserRules.continueStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal133=null;
        Token char_literal134=null;

        CommonTree string_literal133_tree=null;
        CommonTree char_literal134_tree=null;
        RewriteRuleTokenStream stream_82=new RewriteRuleTokenStream(adaptor,"token 82");
        RewriteRuleTokenStream stream_120=new RewriteRuleTokenStream(adaptor,"token 120");

        try {
            // EolParserRules.g:306:2: ( 'continue' ';' -> ^( CONTINUE ) )
            // EolParserRules.g:306:4: 'continue' ';'
            {
            string_literal133=(Token)match(input,120,FOLLOW_120_in_continueStatement1354); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_120.add(string_literal133);

            char_literal134=(Token)match(input,82,FOLLOW_82_in_continueStatement1356); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_82.add(char_literal134);



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
            // 307:2: -> ^( CONTINUE )
            {
                // EolParserRules.g:307:5: ^( CONTINUE )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CONTINUE, "CONTINUE"), root_1);

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
    // $ANTLR end continueStatement

    public static class abortStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start abortStatement
    // EolParserRules.g:310:1: abortStatement : 'abort' ';' -> ^( ABORT ) ;
    public final Flock_EolParserRules.abortStatement_return abortStatement() throws RecognitionException {
        Flock_EolParserRules.abortStatement_return retval = new Flock_EolParserRules.abortStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal135=null;
        Token char_literal136=null;

        CommonTree string_literal135_tree=null;
        CommonTree char_literal136_tree=null;
        RewriteRuleTokenStream stream_121=new RewriteRuleTokenStream(adaptor,"token 121");
        RewriteRuleTokenStream stream_82=new RewriteRuleTokenStream(adaptor,"token 82");

        try {
            // EolParserRules.g:311:2: ( 'abort' ';' -> ^( ABORT ) )
            // EolParserRules.g:311:4: 'abort' ';'
            {
            string_literal135=(Token)match(input,121,FOLLOW_121_in_abortStatement1374); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_121.add(string_literal135);

            char_literal136=(Token)match(input,82,FOLLOW_82_in_abortStatement1376); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_82.add(char_literal136);



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
            // 312:2: -> ^( ABORT )
            {
                // EolParserRules.g:312:5: ^( ABORT )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ABORT, "ABORT"), root_1);

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
    // $ANTLR end abortStatement

    public static class transactionStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start transactionStatement
    // EolParserRules.g:315:1: transactionStatement : 'transaction' ( NAME ( ',' NAME )* )? statementOrStatementBlock -> ^( TRANSACTION ( NAME )* statementOrStatementBlock ) ;
    public final Flock_EolParserRules.transactionStatement_return transactionStatement() throws RecognitionException {
        Flock_EolParserRules.transactionStatement_return retval = new Flock_EolParserRules.transactionStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal137=null;
        Token NAME138=null;
        Token char_literal139=null;
        Token NAME140=null;
        Flock_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock141 = null;


        CommonTree string_literal137_tree=null;
        CommonTree NAME138_tree=null;
        CommonTree char_literal139_tree=null;
        CommonTree NAME140_tree=null;
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_122=new RewriteRuleTokenStream(adaptor,"token 122");
        RewriteRuleTokenStream stream_84=new RewriteRuleTokenStream(adaptor,"token 84");
        RewriteRuleSubtreeStream stream_statementOrStatementBlock=new RewriteRuleSubtreeStream(adaptor,"rule statementOrStatementBlock");
        try {
            // EolParserRules.g:316:2: ( 'transaction' ( NAME ( ',' NAME )* )? statementOrStatementBlock -> ^( TRANSACTION ( NAME )* statementOrStatementBlock ) )
            // EolParserRules.g:316:4: 'transaction' ( NAME ( ',' NAME )* )? statementOrStatementBlock
            {
            string_literal137=(Token)match(input,122,FOLLOW_122_in_transactionStatement1394); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_122.add(string_literal137);

            // EolParserRules.g:316:18: ( NAME ( ',' NAME )* )?
            int alt35=2;
            alt35 = dfa35.predict(input);
            switch (alt35) {
                case 1 :
                    // EolParserRules.g:316:19: NAME ( ',' NAME )*
                    {
                    NAME138=(Token)match(input,NAME,FOLLOW_NAME_in_transactionStatement1397); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NAME.add(NAME138);

                    // EolParserRules.g:316:24: ( ',' NAME )*
                    loop34:
                    do {
                        int alt34=2;
                        int LA34_0 = input.LA(1);

                        if ( (LA34_0==84) ) {
                            alt34=1;
                        }


                        switch (alt34) {
                    	case 1 :
                    	    // EolParserRules.g:316:25: ',' NAME
                    	    {
                    	    char_literal139=(Token)match(input,84,FOLLOW_84_in_transactionStatement1400); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_84.add(char_literal139);

                    	    NAME140=(Token)match(input,NAME,FOLLOW_NAME_in_transactionStatement1402); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_NAME.add(NAME140);


                    	    }
                    	    break;

                    	default :
                    	    break loop34;
                        }
                    } while (true);


                    }
                    break;

            }

            pushFollow(FOLLOW_statementOrStatementBlock_in_transactionStatement1408);
            statementOrStatementBlock141=statementOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_statementOrStatementBlock.add(statementOrStatementBlock141.getTree());


            // AST REWRITE
            // elements: NAME, statementOrStatementBlock
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 317:2: -> ^( TRANSACTION ( NAME )* statementOrStatementBlock )
            {
                // EolParserRules.g:317:5: ^( TRANSACTION ( NAME )* statementOrStatementBlock )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TRANSACTION, "TRANSACTION"), root_1);

                // EolParserRules.g:317:19: ( NAME )*
                while ( stream_NAME.hasNext() ) {
                    adaptor.addChild(root_1, stream_NAME.nextNode());

                }
                stream_NAME.reset();
                adaptor.addChild(root_1, stream_statementOrStatementBlock.nextTree());

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
    // $ANTLR end transactionStatement

    public static class assignmentStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start assignmentStatement
    // EolParserRules.g:321:1: assignmentStatement : logicalExpression (normal= ':=' | special= '::=' ) logicalExpression ';' ;
    public final Flock_EolParserRules.assignmentStatement_return assignmentStatement() throws RecognitionException {
        Flock_EolParserRules.assignmentStatement_return retval = new Flock_EolParserRules.assignmentStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token normal=null;
        Token special=null;
        Token char_literal144=null;
        Flock_EolParserRules.logicalExpression_return logicalExpression142 = null;

        Flock_EolParserRules.logicalExpression_return logicalExpression143 = null;


        CommonTree normal_tree=null;
        CommonTree special_tree=null;
        CommonTree char_literal144_tree=null;

        try {
            // EolParserRules.g:325:2: ( logicalExpression (normal= ':=' | special= '::=' ) logicalExpression ';' )
            // EolParserRules.g:325:4: logicalExpression (normal= ':=' | special= '::=' ) logicalExpression ';'
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_logicalExpression_in_assignmentStatement1437);
            logicalExpression142=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression142.getTree());
            // EolParserRules.g:325:22: (normal= ':=' | special= '::=' )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==123) ) {
                alt36=1;
            }
            else if ( (LA36_0==124) ) {
                alt36=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }
            switch (alt36) {
                case 1 :
                    // EolParserRules.g:325:23: normal= ':='
                    {
                    normal=(Token)match(input,123,FOLLOW_123_in_assignmentStatement1442); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    normal_tree = (CommonTree)adaptor.create(normal);
                    root_0 = (CommonTree)adaptor.becomeRoot(normal_tree, root_0);
                    }
                    if ( state.backtracking==0 ) {
                      normal.setType(ASSIGNMENT);
                    }

                    }
                    break;
                case 2 :
                    // EolParserRules.g:325:66: special= '::='
                    {
                    special=(Token)match(input,124,FOLLOW_124_in_assignmentStatement1449); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    special_tree = (CommonTree)adaptor.create(special);
                    root_0 = (CommonTree)adaptor.becomeRoot(special_tree, root_0);
                    }
                    if ( state.backtracking==0 ) {
                      special.setType(SPECIAL_ASSIGNMENT);
                    }

                    }
                    break;

            }

            pushFollow(FOLLOW_logicalExpression_in_assignmentStatement1455);
            logicalExpression143=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression143.getTree());
            char_literal144=(Token)match(input,82,FOLLOW_82_in_assignmentStatement1457); if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {
              
              		
              	
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
    // $ANTLR end assignmentStatement

    public static class expressionStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start expressionStatement
    // EolParserRules.g:329:1: expressionStatement : ( postfixExpression '=' logicalExpression | logicalExpression ) ';' ;
    public final Flock_EolParserRules.expressionStatement_return expressionStatement() throws RecognitionException {
        Flock_EolParserRules.expressionStatement_return retval = new Flock_EolParserRules.expressionStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal146=null;
        Token char_literal149=null;
        Flock_EolParserRules.postfixExpression_return postfixExpression145 = null;

        Flock_EolParserRules.logicalExpression_return logicalExpression147 = null;

        Flock_EolParserRules.logicalExpression_return logicalExpression148 = null;


        CommonTree char_literal146_tree=null;
        CommonTree char_literal149_tree=null;

        try {
            // EolParserRules.g:330:2: ( ( postfixExpression '=' logicalExpression | logicalExpression ) ';' )
            // EolParserRules.g:330:4: ( postfixExpression '=' logicalExpression | logicalExpression ) ';'
            {
            root_0 = (CommonTree)adaptor.nil();

            // EolParserRules.g:330:4: ( postfixExpression '=' logicalExpression | logicalExpression )
            int alt37=2;
            alt37 = dfa37.predict(input);
            switch (alt37) {
                case 1 :
                    // EolParserRules.g:330:5: postfixExpression '=' logicalExpression
                    {
                    pushFollow(FOLLOW_postfixExpression_in_expressionStatement1473);
                    postfixExpression145=postfixExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, postfixExpression145.getTree());
                    char_literal146=(Token)match(input,89,FOLLOW_89_in_expressionStatement1475); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal146_tree = (CommonTree)adaptor.create(char_literal146);
                    root_0 = (CommonTree)adaptor.becomeRoot(char_literal146_tree, root_0);
                    }
                    pushFollow(FOLLOW_logicalExpression_in_expressionStatement1478);
                    logicalExpression147=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression147.getTree());
                    if ( state.backtracking==0 ) {
                      if (root_0.getToken() != null) root_0.getToken().setType(OPERATOR);
                    }

                    }
                    break;
                case 2 :
                    // EolParserRules.g:330:118: logicalExpression
                    {
                    pushFollow(FOLLOW_logicalExpression_in_expressionStatement1484);
                    logicalExpression148=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression148.getTree());

                    }
                    break;

            }

            char_literal149=(Token)match(input,82,FOLLOW_82_in_expressionStatement1487); if (state.failed) return retval;

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
    // $ANTLR end expressionStatement

    public static class logicalExpression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start logicalExpression
    // EolParserRules.g:334:1: logicalExpression : relationalExpression ( ( 'or' | 'and' | 'xor' | 'implies' ) relationalExpression )* ;
    public final Flock_EolParserRules.logicalExpression_return logicalExpression() throws RecognitionException {
        Flock_EolParserRules.logicalExpression_return retval = new Flock_EolParserRules.logicalExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set151=null;
        Flock_EolParserRules.relationalExpression_return relationalExpression150 = null;

        Flock_EolParserRules.relationalExpression_return relationalExpression152 = null;


        CommonTree set151_tree=null;

        try {
            // EolParserRules.g:335:2: ( relationalExpression ( ( 'or' | 'and' | 'xor' | 'implies' ) relationalExpression )* )
            // EolParserRules.g:335:4: relationalExpression ( ( 'or' | 'and' | 'xor' | 'implies' ) relationalExpression )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_relationalExpression_in_logicalExpression1500);
            relationalExpression150=relationalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, relationalExpression150.getTree());
            // EolParserRules.g:335:25: ( ( 'or' | 'and' | 'xor' | 'implies' ) relationalExpression )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( ((LA38_0>=125 && LA38_0<=128)) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // EolParserRules.g:335:26: ( 'or' | 'and' | 'xor' | 'implies' ) relationalExpression
            	    {
            	    set151=(Token)input.LT(1);
            	    set151=(Token)input.LT(1);
            	    if ( (input.LA(1)>=125 && input.LA(1)<=128) ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(set151), root_0);
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_relationalExpression_in_logicalExpression1514);
            	    relationalExpression152=relationalExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, relationalExpression152.getTree());
            	    if ( state.backtracking==0 ) {
            	      if (root_0.getToken() != null) root_0.getToken().setType(OPERATOR);
            	    }

            	    }
            	    break;

            	default :
            	    break loop38;
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
    // $ANTLR end logicalExpression

    public static class relationalExpression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start relationalExpression
    // EolParserRules.g:339:1: relationalExpression : additiveExpression ( ( '==' relationalExpression | '=' relationalExpression | ( '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression ) )* ;
    public final Flock_EolParserRules.relationalExpression_return relationalExpression() throws RecognitionException {
        Flock_EolParserRules.relationalExpression_return retval = new Flock_EolParserRules.relationalExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal154=null;
        Token char_literal156=null;
        Token set158=null;
        Flock_EolParserRules.additiveExpression_return additiveExpression153 = null;

        Flock_EolParserRules.relationalExpression_return relationalExpression155 = null;

        Flock_EolParserRules.relationalExpression_return relationalExpression157 = null;

        Flock_EolParserRules.additiveExpression_return additiveExpression159 = null;


        CommonTree string_literal154_tree=null;
        CommonTree char_literal156_tree=null;
        CommonTree set158_tree=null;

        try {
            // EolParserRules.g:340:2: ( additiveExpression ( ( '==' relationalExpression | '=' relationalExpression | ( '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression ) )* )
            // EolParserRules.g:340:4: additiveExpression ( ( '==' relationalExpression | '=' relationalExpression | ( '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression ) )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_additiveExpression_in_relationalExpression1531);
            additiveExpression153=additiveExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, additiveExpression153.getTree());
            // EolParserRules.g:340:23: ( ( '==' relationalExpression | '=' relationalExpression | ( '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression ) )*
            loop40:
            do {
                int alt40=2;
                switch ( input.LA(1) ) {
                case 129:
                    {
                    int LA40_2 = input.LA(2);

                    if ( (synpred66_EolParserRules()) ) {
                        alt40=1;
                    }


                    }
                    break;
                case 89:
                    {
                    int LA40_3 = input.LA(2);

                    if ( (synpred66_EolParserRules()) ) {
                        alt40=1;
                    }


                    }
                    break;
                case 130:
                case 131:
                case 132:
                case 133:
                case 134:
                    {
                    int LA40_4 = input.LA(2);

                    if ( (synpred66_EolParserRules()) ) {
                        alt40=1;
                    }


                    }
                    break;

                }

                switch (alt40) {
            	case 1 :
            	    // EolParserRules.g:340:24: ( '==' relationalExpression | '=' relationalExpression | ( '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression )
            	    {
            	    // EolParserRules.g:340:24: ( '==' relationalExpression | '=' relationalExpression | ( '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression )
            	    int alt39=3;
            	    switch ( input.LA(1) ) {
            	    case 129:
            	        {
            	        alt39=1;
            	        }
            	        break;
            	    case 89:
            	        {
            	        alt39=2;
            	        }
            	        break;
            	    case 130:
            	    case 131:
            	    case 132:
            	    case 133:
            	    case 134:
            	        {
            	        alt39=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 39, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt39) {
            	        case 1 :
            	            // EolParserRules.g:340:25: '==' relationalExpression
            	            {
            	            string_literal154=(Token)match(input,129,FOLLOW_129_in_relationalExpression1535); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            string_literal154_tree = (CommonTree)adaptor.create(string_literal154);
            	            root_0 = (CommonTree)adaptor.becomeRoot(string_literal154_tree, root_0);
            	            }
            	            pushFollow(FOLLOW_relationalExpression_in_relationalExpression1538);
            	            relationalExpression155=relationalExpression();

            	            state._fsp--;
            	            if (state.failed) return retval;
            	            if ( state.backtracking==0 ) adaptor.addChild(root_0, relationalExpression155.getTree());

            	            }
            	            break;
            	        case 2 :
            	            // EolParserRules.g:340:54: '=' relationalExpression
            	            {
            	            char_literal156=(Token)match(input,89,FOLLOW_89_in_relationalExpression1542); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal156_tree = (CommonTree)adaptor.create(char_literal156);
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal156_tree, root_0);
            	            }
            	            pushFollow(FOLLOW_relationalExpression_in_relationalExpression1545);
            	            relationalExpression157=relationalExpression();

            	            state._fsp--;
            	            if (state.failed) return retval;
            	            if ( state.backtracking==0 ) adaptor.addChild(root_0, relationalExpression157.getTree());

            	            }
            	            break;
            	        case 3 :
            	            // EolParserRules.g:341:24: ( '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression
            	            {
            	            set158=(Token)input.LT(1);
            	            set158=(Token)input.LT(1);
            	            if ( (input.LA(1)>=130 && input.LA(1)<=134) ) {
            	                input.consume();
            	                if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(set158), root_0);
            	                state.errorRecovery=false;state.failed=false;
            	            }
            	            else {
            	                if (state.backtracking>0) {state.failed=true; return retval;}
            	                MismatchedSetException mse = new MismatchedSetException(null,input);
            	                throw mse;
            	            }

            	            pushFollow(FOLLOW_additiveExpression_in_relationalExpression1585);
            	            additiveExpression159=additiveExpression();

            	            state._fsp--;
            	            if (state.failed) return retval;
            	            if ( state.backtracking==0 ) adaptor.addChild(root_0, additiveExpression159.getTree());

            	            }
            	            break;

            	    }

            	    if ( state.backtracking==0 ) {
            	      if (root_0.getToken() != null) root_0.getToken().setType(OPERATOR);
            	    }

            	    }
            	    break;

            	default :
            	    break loop40;
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
    // $ANTLR end relationalExpression

    public static class additiveExpression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start additiveExpression
    // EolParserRules.g:345:1: additiveExpression : multiplicativeExpression ( ( '+' | '-' ) multiplicativeExpression )* ;
    public final Flock_EolParserRules.additiveExpression_return additiveExpression() throws RecognitionException {
        Flock_EolParserRules.additiveExpression_return retval = new Flock_EolParserRules.additiveExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set161=null;
        Flock_EolParserRules.multiplicativeExpression_return multiplicativeExpression160 = null;

        Flock_EolParserRules.multiplicativeExpression_return multiplicativeExpression162 = null;


        CommonTree set161_tree=null;

        try {
            // EolParserRules.g:346:2: ( multiplicativeExpression ( ( '+' | '-' ) multiplicativeExpression )* )
            // EolParserRules.g:346:4: multiplicativeExpression ( ( '+' | '-' ) multiplicativeExpression )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_multiplicativeExpression_in_additiveExpression1603);
            multiplicativeExpression160=multiplicativeExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, multiplicativeExpression160.getTree());
            // EolParserRules.g:346:29: ( ( '+' | '-' ) multiplicativeExpression )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( ((LA41_0>=135 && LA41_0<=136)) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // EolParserRules.g:346:30: ( '+' | '-' ) multiplicativeExpression
            	    {
            	    set161=(Token)input.LT(1);
            	    set161=(Token)input.LT(1);
            	    if ( (input.LA(1)>=135 && input.LA(1)<=136) ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(set161), root_0);
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_multiplicativeExpression_in_additiveExpression1613);
            	    multiplicativeExpression162=multiplicativeExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, multiplicativeExpression162.getTree());
            	    if ( state.backtracking==0 ) {
            	      if (root_0.getToken() != null) root_0.getToken().setType(OPERATOR);
            	    }

            	    }
            	    break;

            	default :
            	    break loop41;
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
    // $ANTLR end additiveExpression

    public static class multiplicativeExpression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start multiplicativeExpression
    // EolParserRules.g:351:1: multiplicativeExpression : unaryExpression ( ( '*' | '/' ) unaryExpression )* ;
    public final Flock_EolParserRules.multiplicativeExpression_return multiplicativeExpression() throws RecognitionException {
        Flock_EolParserRules.multiplicativeExpression_return retval = new Flock_EolParserRules.multiplicativeExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set164=null;
        Flock_EolParserRules.unaryExpression_return unaryExpression163 = null;

        Flock_EolParserRules.unaryExpression_return unaryExpression165 = null;


        CommonTree set164_tree=null;

        try {
            // EolParserRules.g:352:2: ( unaryExpression ( ( '*' | '/' ) unaryExpression )* )
            // EolParserRules.g:352:4: unaryExpression ( ( '*' | '/' ) unaryExpression )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_unaryExpression_in_multiplicativeExpression1634);
            unaryExpression163=unaryExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, unaryExpression163.getTree());
            // EolParserRules.g:352:20: ( ( '*' | '/' ) unaryExpression )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( ((LA42_0>=137 && LA42_0<=138)) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // EolParserRules.g:352:21: ( '*' | '/' ) unaryExpression
            	    {
            	    set164=(Token)input.LT(1);
            	    set164=(Token)input.LT(1);
            	    if ( (input.LA(1)>=137 && input.LA(1)<=138) ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(set164), root_0);
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_unaryExpression_in_multiplicativeExpression1644);
            	    unaryExpression165=unaryExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, unaryExpression165.getTree());
            	    if ( state.backtracking==0 ) {
            	      if (root_0.getToken() != null) root_0.getToken().setType(OPERATOR);
            	    }

            	    }
            	    break;

            	default :
            	    break loop42;
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
    // $ANTLR end multiplicativeExpression

    public static class unaryExpression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start unaryExpression
    // EolParserRules.g:356:1: unaryExpression : ( ( 'not' | '-' ) )? postfixExpression ;
    public final Flock_EolParserRules.unaryExpression_return unaryExpression() throws RecognitionException {
        Flock_EolParserRules.unaryExpression_return retval = new Flock_EolParserRules.unaryExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set166=null;
        Flock_EolParserRules.postfixExpression_return postfixExpression167 = null;


        CommonTree set166_tree=null;

        try {
            // EolParserRules.g:357:2: ( ( ( 'not' | '-' ) )? postfixExpression )
            // EolParserRules.g:357:4: ( ( 'not' | '-' ) )? postfixExpression
            {
            root_0 = (CommonTree)adaptor.nil();

            // EolParserRules.g:357:4: ( ( 'not' | '-' ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==136||LA43_0==139) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // EolParserRules.g:357:5: ( 'not' | '-' )
                    {
                    set166=(Token)input.LT(1);
                    set166=(Token)input.LT(1);
                    if ( input.LA(1)==136||input.LA(1)==139 ) {
                        input.consume();
                        if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(set166), root_0);
                        state.errorRecovery=false;state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    }
                    break;

            }

            pushFollow(FOLLOW_postfixExpression_in_unaryExpression1671);
            postfixExpression167=postfixExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, postfixExpression167.getTree());
            if ( state.backtracking==0 ) {
              if (root_0.getToken() != null) root_0.getToken().setType(OPERATOR);
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
    // $ANTLR end unaryExpression

    public static class postfixExpression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start postfixExpression
    // EolParserRules.g:361:1: postfixExpression : itemSelectorExpression ( ( POINT | ARROW ) fc= featureCall ( '[' logicalExpression ']' )* )* ;
    public final Flock_EolParserRules.postfixExpression_return postfixExpression() throws RecognitionException {
        Flock_EolParserRules.postfixExpression_return retval = new Flock_EolParserRules.postfixExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set169=null;
        Token char_literal170=null;
        Token char_literal172=null;
        Flock_EolParserRules.featureCall_return fc = null;

        Flock_EolParserRules.itemSelectorExpression_return itemSelectorExpression168 = null;

        Flock_EolParserRules.logicalExpression_return logicalExpression171 = null;


        CommonTree set169_tree=null;
        CommonTree char_literal170_tree=null;
        CommonTree char_literal172_tree=null;

        try {
            // EolParserRules.g:362:2: ( itemSelectorExpression ( ( POINT | ARROW ) fc= featureCall ( '[' logicalExpression ']' )* )* )
            // EolParserRules.g:362:4: itemSelectorExpression ( ( POINT | ARROW ) fc= featureCall ( '[' logicalExpression ']' )* )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_itemSelectorExpression_in_postfixExpression1687);
            itemSelectorExpression168=itemSelectorExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, itemSelectorExpression168.getTree());
            // EolParserRules.g:362:27: ( ( POINT | ARROW ) fc= featureCall ( '[' logicalExpression ']' )* )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==POINT||LA45_0==ARROW) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // EolParserRules.g:362:28: ( POINT | ARROW ) fc= featureCall ( '[' logicalExpression ']' )*
            	    {
            	    set169=(Token)input.LT(1);
            	    set169=(Token)input.LT(1);
            	    if ( input.LA(1)==POINT||input.LA(1)==ARROW ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(set169), root_0);
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_featureCall_in_postfixExpression1699);
            	    fc=featureCall();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, fc.getTree());
            	    if ( state.backtracking==0 ) {
            	      setTokenType(fc,FEATURECALL);
            	    }
            	    // EolParserRules.g:363:35: ( '[' logicalExpression ']' )*
            	    loop44:
            	    do {
            	        int alt44=2;
            	        int LA44_0 = input.LA(1);

            	        if ( (LA44_0==140) ) {
            	            alt44=1;
            	        }


            	        switch (alt44) {
            	    	case 1 :
            	    	    // EolParserRules.g:363:36: '[' logicalExpression ']'
            	    	    {
            	    	    char_literal170=(Token)match(input,140,FOLLOW_140_in_postfixExpression1706); if (state.failed) return retval;
            	    	    if ( state.backtracking==0 ) {
            	    	    char_literal170_tree = (CommonTree)adaptor.create(char_literal170);
            	    	    root_0 = (CommonTree)adaptor.becomeRoot(char_literal170_tree, root_0);
            	    	    }
            	    	    pushFollow(FOLLOW_logicalExpression_in_postfixExpression1709);
            	    	    logicalExpression171=logicalExpression();

            	    	    state._fsp--;
            	    	    if (state.failed) return retval;
            	    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression171.getTree());
            	    	    char_literal172=(Token)match(input,141,FOLLOW_141_in_postfixExpression1711); if (state.failed) return retval;
            	    	    if ( state.backtracking==0 ) {
            	    	      if (root_0.getToken() != null) root_0.getToken().setType(ITEMSELECTOR);
            	    	    }

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop44;
            	        }
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop45;
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
    // $ANTLR end postfixExpression

    public static class itemSelectorExpression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start itemSelectorExpression
    // EolParserRules.g:372:1: itemSelectorExpression : primitiveExpression ( '[' primitiveExpression ']' )* ;
    public final Flock_EolParserRules.itemSelectorExpression_return itemSelectorExpression() throws RecognitionException {
        Flock_EolParserRules.itemSelectorExpression_return retval = new Flock_EolParserRules.itemSelectorExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal174=null;
        Token char_literal176=null;
        Flock_EolParserRules.primitiveExpression_return primitiveExpression173 = null;

        Flock_EolParserRules.primitiveExpression_return primitiveExpression175 = null;


        CommonTree char_literal174_tree=null;
        CommonTree char_literal176_tree=null;

        try {
            // EolParserRules.g:373:2: ( primitiveExpression ( '[' primitiveExpression ']' )* )
            // EolParserRules.g:373:4: primitiveExpression ( '[' primitiveExpression ']' )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_primitiveExpression_in_itemSelectorExpression1748);
            primitiveExpression173=primitiveExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, primitiveExpression173.getTree());
            // EolParserRules.g:373:24: ( '[' primitiveExpression ']' )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==140) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // EolParserRules.g:373:25: '[' primitiveExpression ']'
            	    {
            	    char_literal174=(Token)match(input,140,FOLLOW_140_in_itemSelectorExpression1751); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal174_tree = (CommonTree)adaptor.create(char_literal174);
            	    root_0 = (CommonTree)adaptor.becomeRoot(char_literal174_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_primitiveExpression_in_itemSelectorExpression1754);
            	    primitiveExpression175=primitiveExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, primitiveExpression175.getTree());
            	    char_literal176=(Token)match(input,141,FOLLOW_141_in_itemSelectorExpression1756); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	      if (root_0.getToken() != null) root_0.getToken().setType(ITEMSELECTOR);
            	    }

            	    }
            	    break;

            	default :
            	    break loop46;
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
    // $ANTLR end itemSelectorExpression

    public static class featureCall_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start featureCall
    // EolParserRules.g:377:1: featureCall : ( simpleFeatureCall | declarativeFeatureCall );
    public final Flock_EolParserRules.featureCall_return featureCall() throws RecognitionException {
        Flock_EolParserRules.featureCall_return retval = new Flock_EolParserRules.featureCall_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Flock_EolParserRules.simpleFeatureCall_return simpleFeatureCall177 = null;

        Flock_EolParserRules.declarativeFeatureCall_return declarativeFeatureCall178 = null;



        try {
            // EolParserRules.g:378:2: ( simpleFeatureCall | declarativeFeatureCall )
            int alt47=2;
            alt47 = dfa47.predict(input);
            switch (alt47) {
                case 1 :
                    // EolParserRules.g:378:4: simpleFeatureCall
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_simpleFeatureCall_in_featureCall1775);
                    simpleFeatureCall177=simpleFeatureCall();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, simpleFeatureCall177.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:378:24: declarativeFeatureCall
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_declarativeFeatureCall_in_featureCall1779);
                    declarativeFeatureCall178=declarativeFeatureCall();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, declarativeFeatureCall178.getTree());

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
    // $ANTLR end featureCall

    public static class simpleFeatureCall_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start simpleFeatureCall
    // EolParserRules.g:381:1: simpleFeatureCall : NAME ( parameterList )? ;
    public final Flock_EolParserRules.simpleFeatureCall_return simpleFeatureCall() throws RecognitionException {
        Flock_EolParserRules.simpleFeatureCall_return retval = new Flock_EolParserRules.simpleFeatureCall_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NAME179=null;
        Flock_EolParserRules.parameterList_return parameterList180 = null;


        CommonTree NAME179_tree=null;

        try {
            // EolParserRules.g:382:2: ( NAME ( parameterList )? )
            // EolParserRules.g:382:5: NAME ( parameterList )?
            {
            root_0 = (CommonTree)adaptor.nil();

            NAME179=(Token)match(input,NAME,FOLLOW_NAME_in_simpleFeatureCall1791); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME179_tree = (CommonTree)adaptor.create(NAME179);
            root_0 = (CommonTree)adaptor.becomeRoot(NAME179_tree, root_0);
            }
            // EolParserRules.g:382:11: ( parameterList )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==92) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // EolParserRules.g:0:0: parameterList
                    {
                    pushFollow(FOLLOW_parameterList_in_simpleFeatureCall1794);
                    parameterList180=parameterList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, parameterList180.getTree());

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              if (root_0.getToken() != null) root_0.getToken().setType(FEATURECALL);
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
    // $ANTLR end simpleFeatureCall

    public static class parameterList_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start parameterList
    // EolParserRules.g:386:1: parameterList : '(' ( logicalExpression ( ',' logicalExpression )* )? ')' -> ^( PARAMETERS ( logicalExpression )* ) ;
    public final Flock_EolParserRules.parameterList_return parameterList() throws RecognitionException {
        Flock_EolParserRules.parameterList_return retval = new Flock_EolParserRules.parameterList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal181=null;
        Token char_literal183=null;
        Token char_literal185=null;
        Flock_EolParserRules.logicalExpression_return logicalExpression182 = null;

        Flock_EolParserRules.logicalExpression_return logicalExpression184 = null;


        CommonTree char_literal181_tree=null;
        CommonTree char_literal183_tree=null;
        CommonTree char_literal185_tree=null;
        RewriteRuleTokenStream stream_93=new RewriteRuleTokenStream(adaptor,"token 93");
        RewriteRuleTokenStream stream_92=new RewriteRuleTokenStream(adaptor,"token 92");
        RewriteRuleTokenStream stream_84=new RewriteRuleTokenStream(adaptor,"token 84");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:387:2: ( '(' ( logicalExpression ( ',' logicalExpression )* )? ')' -> ^( PARAMETERS ( logicalExpression )* ) )
            // EolParserRules.g:387:4: '(' ( logicalExpression ( ',' logicalExpression )* )? ')'
            {
            char_literal181=(Token)match(input,92,FOLLOW_92_in_parameterList1809); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_92.add(char_literal181);

            // EolParserRules.g:387:8: ( logicalExpression ( ',' logicalExpression )* )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==FLOAT||LA50_0==INT||LA50_0==BOOLEAN||LA50_0==STRING||LA50_0==NAME||LA50_0==92||(LA50_0>=99 && LA50_0<=106)||LA50_0==136||LA50_0==139||(LA50_0>=143 && LA50_0<=144)) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // EolParserRules.g:387:9: logicalExpression ( ',' logicalExpression )*
                    {
                    pushFollow(FOLLOW_logicalExpression_in_parameterList1812);
                    logicalExpression182=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression182.getTree());
                    // EolParserRules.g:387:27: ( ',' logicalExpression )*
                    loop49:
                    do {
                        int alt49=2;
                        int LA49_0 = input.LA(1);

                        if ( (LA49_0==84) ) {
                            alt49=1;
                        }


                        switch (alt49) {
                    	case 1 :
                    	    // EolParserRules.g:387:28: ',' logicalExpression
                    	    {
                    	    char_literal183=(Token)match(input,84,FOLLOW_84_in_parameterList1815); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_84.add(char_literal183);

                    	    pushFollow(FOLLOW_logicalExpression_in_parameterList1817);
                    	    logicalExpression184=logicalExpression();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression184.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop49;
                        }
                    } while (true);


                    }
                    break;

            }

            char_literal185=(Token)match(input,93,FOLLOW_93_in_parameterList1823); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_93.add(char_literal185);



            // AST REWRITE
            // elements: logicalExpression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 388:3: -> ^( PARAMETERS ( logicalExpression )* )
            {
                // EolParserRules.g:388:6: ^( PARAMETERS ( logicalExpression )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PARAMETERS, "PARAMETERS"), root_1);

                // EolParserRules.g:388:19: ( logicalExpression )*
                while ( stream_logicalExpression.hasNext() ) {
                    adaptor.addChild(root_1, stream_logicalExpression.nextTree());

                }
                stream_logicalExpression.reset();

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
    // $ANTLR end parameterList

    public static class declarativeFeatureCall_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start declarativeFeatureCall
    // EolParserRules.g:391:1: declarativeFeatureCall : NAME '(' formalParameterList '|' logicalExpression ( ',' logicalExpression )* ')' ;
    public final Flock_EolParserRules.declarativeFeatureCall_return declarativeFeatureCall() throws RecognitionException {
        Flock_EolParserRules.declarativeFeatureCall_return retval = new Flock_EolParserRules.declarativeFeatureCall_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NAME186=null;
        Token char_literal187=null;
        Token char_literal189=null;
        Token char_literal191=null;
        Token char_literal193=null;
        Flock_EolParserRules.formalParameterList_return formalParameterList188 = null;

        Flock_EolParserRules.logicalExpression_return logicalExpression190 = null;

        Flock_EolParserRules.logicalExpression_return logicalExpression192 = null;


        CommonTree NAME186_tree=null;
        CommonTree char_literal187_tree=null;
        CommonTree char_literal189_tree=null;
        CommonTree char_literal191_tree=null;
        CommonTree char_literal193_tree=null;

        try {
            // EolParserRules.g:392:2: ( NAME '(' formalParameterList '|' logicalExpression ( ',' logicalExpression )* ')' )
            // EolParserRules.g:392:4: NAME '(' formalParameterList '|' logicalExpression ( ',' logicalExpression )* ')'
            {
            root_0 = (CommonTree)adaptor.nil();

            NAME186=(Token)match(input,NAME,FOLLOW_NAME_in_declarativeFeatureCall1845); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME186_tree = (CommonTree)adaptor.create(NAME186);
            root_0 = (CommonTree)adaptor.becomeRoot(NAME186_tree, root_0);
            }
            char_literal187=(Token)match(input,92,FOLLOW_92_in_declarativeFeatureCall1848); if (state.failed) return retval;
            pushFollow(FOLLOW_formalParameterList_in_declarativeFeatureCall1851);
            formalParameterList188=formalParameterList();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, formalParameterList188.getTree());
            char_literal189=(Token)match(input,142,FOLLOW_142_in_declarativeFeatureCall1853); if (state.failed) return retval;
            pushFollow(FOLLOW_logicalExpression_in_declarativeFeatureCall1856);
            logicalExpression190=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression190.getTree());
            // EolParserRules.g:392:58: ( ',' logicalExpression )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==84) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // EolParserRules.g:392:59: ',' logicalExpression
            	    {
            	    char_literal191=(Token)match(input,84,FOLLOW_84_in_declarativeFeatureCall1859); if (state.failed) return retval;
            	    pushFollow(FOLLOW_logicalExpression_in_declarativeFeatureCall1862);
            	    logicalExpression192=logicalExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression192.getTree());

            	    }
            	    break;

            	default :
            	    break loop51;
                }
            } while (true);

            char_literal193=(Token)match(input,93,FOLLOW_93_in_declarativeFeatureCall1866); if (state.failed) return retval;

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
    // $ANTLR end declarativeFeatureCall

    public static class newExpression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start newExpression
    // EolParserRules.g:395:1: newExpression : 'new' tn= typeName ( parameterList )? ;
    public final Flock_EolParserRules.newExpression_return newExpression() throws RecognitionException {
        Flock_EolParserRules.newExpression_return retval = new Flock_EolParserRules.newExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal194=null;
        Flock_EolParserRules.typeName_return tn = null;

        Flock_EolParserRules.parameterList_return parameterList195 = null;


        CommonTree string_literal194_tree=null;

        try {
            // EolParserRules.g:396:2: ( 'new' tn= typeName ( parameterList )? )
            // EolParserRules.g:396:4: 'new' tn= typeName ( parameterList )?
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal194=(Token)match(input,143,FOLLOW_143_in_newExpression1878); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal194_tree = (CommonTree)adaptor.create(string_literal194);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal194_tree, root_0);
            }
            pushFollow(FOLLOW_typeName_in_newExpression1883);
            tn=typeName();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, tn.getTree());
            if ( state.backtracking==0 ) {
              setTokenType(tn,TYPE);
            }
            // EolParserRules.g:396:48: ( parameterList )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==92) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // EolParserRules.g:0:0: parameterList
                    {
                    pushFollow(FOLLOW_parameterList_in_newExpression1887);
                    parameterList195=parameterList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, parameterList195.getTree());

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              if (root_0.getToken() != null) root_0.getToken().setType(NEW);
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
    // $ANTLR end newExpression

    public static class variableDeclarationExpression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start variableDeclarationExpression
    // EolParserRules.g:402:1: variableDeclarationExpression : 'var' NAME ( ':' (n= 'new' )? t= typeName ( parameterList )? )? -> ^( VAR NAME ( typeName )? ( parameterList )? ) ;
    public final Flock_EolParserRules.variableDeclarationExpression_return variableDeclarationExpression() throws RecognitionException {
        Flock_EolParserRules.variableDeclarationExpression_return retval = new Flock_EolParserRules.variableDeclarationExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token n=null;
        Token string_literal196=null;
        Token NAME197=null;
        Token char_literal198=null;
        Flock_EolParserRules.typeName_return t = null;

        Flock_EolParserRules.parameterList_return parameterList199 = null;


        CommonTree n_tree=null;
        CommonTree string_literal196_tree=null;
        CommonTree NAME197_tree=null;
        CommonTree char_literal198_tree=null;
        RewriteRuleTokenStream stream_143=new RewriteRuleTokenStream(adaptor,"token 143");
        RewriteRuleTokenStream stream_144=new RewriteRuleTokenStream(adaptor,"token 144");
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_83=new RewriteRuleTokenStream(adaptor,"token 83");
        RewriteRuleSubtreeStream stream_typeName=new RewriteRuleSubtreeStream(adaptor,"rule typeName");
        RewriteRuleSubtreeStream stream_parameterList=new RewriteRuleSubtreeStream(adaptor,"rule parameterList");
        try {
            // EolParserRules.g:410:2: ( 'var' NAME ( ':' (n= 'new' )? t= typeName ( parameterList )? )? -> ^( VAR NAME ( typeName )? ( parameterList )? ) )
            // EolParserRules.g:410:4: 'var' NAME ( ':' (n= 'new' )? t= typeName ( parameterList )? )?
            {
            string_literal196=(Token)match(input,144,FOLLOW_144_in_variableDeclarationExpression1912); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_144.add(string_literal196);

            NAME197=(Token)match(input,NAME,FOLLOW_NAME_in_variableDeclarationExpression1914); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(NAME197);

            // EolParserRules.g:410:15: ( ':' (n= 'new' )? t= typeName ( parameterList )? )?
            int alt55=2;
            alt55 = dfa55.predict(input);
            switch (alt55) {
                case 1 :
                    // EolParserRules.g:410:16: ':' (n= 'new' )? t= typeName ( parameterList )?
                    {
                    char_literal198=(Token)match(input,83,FOLLOW_83_in_variableDeclarationExpression1917); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_83.add(char_literal198);

                    // EolParserRules.g:410:21: (n= 'new' )?
                    int alt53=2;
                    int LA53_0 = input.LA(1);

                    if ( (LA53_0==143) ) {
                        alt53=1;
                    }
                    switch (alt53) {
                        case 1 :
                            // EolParserRules.g:0:0: n= 'new'
                            {
                            n=(Token)match(input,143,FOLLOW_143_in_variableDeclarationExpression1921); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_143.add(n);


                            }
                            break;

                    }

                    pushFollow(FOLLOW_typeName_in_variableDeclarationExpression1926);
                    t=typeName();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_typeName.add(t.getTree());
                    if ( state.backtracking==0 ) {
                      setTokenType(t, TYPE);
                    }
                    // EolParserRules.g:410:65: ( parameterList )?
                    int alt54=2;
                    int LA54_0 = input.LA(1);

                    if ( (LA54_0==92) ) {
                        alt54=1;
                    }
                    switch (alt54) {
                        case 1 :
                            // EolParserRules.g:0:0: parameterList
                            {
                            pushFollow(FOLLOW_parameterList_in_variableDeclarationExpression1930);
                            parameterList199=parameterList();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_parameterList.add(parameterList199.getTree());

                            }
                            break;

                    }


                    }
                    break;

            }



            // AST REWRITE
            // elements: typeName, parameterList, NAME
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 411:2: -> ^( VAR NAME ( typeName )? ( parameterList )? )
            {
                // EolParserRules.g:411:5: ^( VAR NAME ( typeName )? ( parameterList )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VAR, "VAR"), root_1);

                adaptor.addChild(root_1, stream_NAME.nextNode());
                // EolParserRules.g:411:16: ( typeName )?
                if ( stream_typeName.hasNext() ) {
                    adaptor.addChild(root_1, stream_typeName.nextTree());

                }
                stream_typeName.reset();
                // EolParserRules.g:411:26: ( parameterList )?
                if ( stream_parameterList.hasNext() ) {
                    adaptor.addChild(root_1, stream_parameterList.nextTree());

                }
                stream_parameterList.reset();

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
            if ( state.backtracking==0 ) {
              
              		String txt;
              		if (n != null) {txt = "new";}
              		else { txt = "var";}
              		retval.tree.getToken().setText(txt);
              	
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
    // $ANTLR end variableDeclarationExpression

    public static class literalSequentialCollection_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start literalSequentialCollection
    // EolParserRules.g:414:1: literalSequentialCollection : ( 'Collection' | 'Sequence' | 'List' | 'Bag' | 'Set' | 'OrderedSet' ) '{' ( expressionListOrRange )? '}' ;
    public final Flock_EolParserRules.literalSequentialCollection_return literalSequentialCollection() throws RecognitionException {
        Flock_EolParserRules.literalSequentialCollection_return retval = new Flock_EolParserRules.literalSequentialCollection_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set200=null;
        Token char_literal201=null;
        Token char_literal203=null;
        Flock_EolParserRules.expressionListOrRange_return expressionListOrRange202 = null;


        CommonTree set200_tree=null;
        CommonTree char_literal201_tree=null;
        CommonTree char_literal203_tree=null;

        try {
            // EolParserRules.g:415:2: ( ( 'Collection' | 'Sequence' | 'List' | 'Bag' | 'Set' | 'OrderedSet' ) '{' ( expressionListOrRange )? '}' )
            // EolParserRules.g:415:4: ( 'Collection' | 'Sequence' | 'List' | 'Bag' | 'Set' | 'OrderedSet' ) '{' ( expressionListOrRange )? '}'
            {
            root_0 = (CommonTree)adaptor.nil();

            set200=(Token)input.LT(1);
            set200=(Token)input.LT(1);
            if ( (input.LA(1)>=100 && input.LA(1)<=105) ) {
                input.consume();
                if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(set200), root_0);
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            char_literal201=(Token)match(input,87,FOLLOW_87_in_literalSequentialCollection1975); if (state.failed) return retval;
            // EolParserRules.g:415:69: ( expressionListOrRange )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==FLOAT||LA56_0==INT||LA56_0==BOOLEAN||LA56_0==STRING||LA56_0==NAME||LA56_0==92||(LA56_0>=99 && LA56_0<=106)||LA56_0==136||LA56_0==139||(LA56_0>=143 && LA56_0<=144)) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // EolParserRules.g:0:0: expressionListOrRange
                    {
                    pushFollow(FOLLOW_expressionListOrRange_in_literalSequentialCollection1979);
                    expressionListOrRange202=expressionListOrRange();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionListOrRange202.getTree());

                    }
                    break;

            }

            char_literal203=(Token)match(input,88,FOLLOW_88_in_literalSequentialCollection1982); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
              if (root_0.getToken() != null) root_0.getToken().setType(COLLECTION);
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
    // $ANTLR end literalSequentialCollection

    public static class expressionRange_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start expressionRange
    // EolParserRules.g:419:1: expressionRange : logicalExpression '..' logicalExpression -> ^( EXPRRANGE ( logicalExpression )+ ) ;
    public final Flock_EolParserRules.expressionRange_return expressionRange() throws RecognitionException {
        Flock_EolParserRules.expressionRange_return retval = new Flock_EolParserRules.expressionRange_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal205=null;
        Flock_EolParserRules.logicalExpression_return logicalExpression204 = null;

        Flock_EolParserRules.logicalExpression_return logicalExpression206 = null;


        CommonTree string_literal205_tree=null;
        RewriteRuleTokenStream stream_POINT_POINT=new RewriteRuleTokenStream(adaptor,"token POINT_POINT");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:420:2: ( logicalExpression '..' logicalExpression -> ^( EXPRRANGE ( logicalExpression )+ ) )
            // EolParserRules.g:420:4: logicalExpression '..' logicalExpression
            {
            pushFollow(FOLLOW_logicalExpression_in_expressionRange1997);
            logicalExpression204=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression204.getTree());
            string_literal205=(Token)match(input,POINT_POINT,FOLLOW_POINT_POINT_in_expressionRange1999); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_POINT_POINT.add(string_literal205);

            pushFollow(FOLLOW_logicalExpression_in_expressionRange2001);
            logicalExpression206=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression206.getTree());


            // AST REWRITE
            // elements: logicalExpression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 421:2: -> ^( EXPRRANGE ( logicalExpression )+ )
            {
                // EolParserRules.g:421:5: ^( EXPRRANGE ( logicalExpression )+ )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(EXPRRANGE, "EXPRRANGE"), root_1);

                if ( !(stream_logicalExpression.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_logicalExpression.hasNext() ) {
                    adaptor.addChild(root_1, stream_logicalExpression.nextTree());

                }
                stream_logicalExpression.reset();

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
    // $ANTLR end expressionRange

    public static class expressionList_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start expressionList
    // EolParserRules.g:424:1: expressionList : logicalExpression ( ',' logicalExpression )* -> ^( EXPRLIST ( logicalExpression )+ ) ;
    public final Flock_EolParserRules.expressionList_return expressionList() throws RecognitionException {
        Flock_EolParserRules.expressionList_return retval = new Flock_EolParserRules.expressionList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal208=null;
        Flock_EolParserRules.logicalExpression_return logicalExpression207 = null;

        Flock_EolParserRules.logicalExpression_return logicalExpression209 = null;


        CommonTree char_literal208_tree=null;
        RewriteRuleTokenStream stream_84=new RewriteRuleTokenStream(adaptor,"token 84");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:425:2: ( logicalExpression ( ',' logicalExpression )* -> ^( EXPRLIST ( logicalExpression )+ ) )
            // EolParserRules.g:425:4: logicalExpression ( ',' logicalExpression )*
            {
            pushFollow(FOLLOW_logicalExpression_in_expressionList2023);
            logicalExpression207=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression207.getTree());
            // EolParserRules.g:425:22: ( ',' logicalExpression )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==84) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // EolParserRules.g:425:23: ',' logicalExpression
            	    {
            	    char_literal208=(Token)match(input,84,FOLLOW_84_in_expressionList2026); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_84.add(char_literal208);

            	    pushFollow(FOLLOW_logicalExpression_in_expressionList2028);
            	    logicalExpression209=logicalExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression209.getTree());

            	    }
            	    break;

            	default :
            	    break loop57;
                }
            } while (true);



            // AST REWRITE
            // elements: logicalExpression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 426:2: -> ^( EXPRLIST ( logicalExpression )+ )
            {
                // EolParserRules.g:426:5: ^( EXPRLIST ( logicalExpression )+ )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(EXPRLIST, "EXPRLIST"), root_1);

                if ( !(stream_logicalExpression.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_logicalExpression.hasNext() ) {
                    adaptor.addChild(root_1, stream_logicalExpression.nextTree());

                }
                stream_logicalExpression.reset();

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
    // $ANTLR end expressionList

    public static class expressionListOrRange_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start expressionListOrRange
    // EolParserRules.g:429:1: expressionListOrRange : ( expressionRange | expressionList );
    public final Flock_EolParserRules.expressionListOrRange_return expressionListOrRange() throws RecognitionException {
        Flock_EolParserRules.expressionListOrRange_return retval = new Flock_EolParserRules.expressionListOrRange_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Flock_EolParserRules.expressionRange_return expressionRange210 = null;

        Flock_EolParserRules.expressionList_return expressionList211 = null;



        try {
            // EolParserRules.g:430:2: ( expressionRange | expressionList )
            int alt58=2;
            alt58 = dfa58.predict(input);
            switch (alt58) {
                case 1 :
                    // EolParserRules.g:430:4: expressionRange
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_expressionRange_in_expressionListOrRange2052);
                    expressionRange210=expressionRange();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionRange210.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:430:22: expressionList
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_expressionList_in_expressionListOrRange2056);
                    expressionList211=expressionList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionList211.getTree());

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
    // $ANTLR end expressionListOrRange

    public static class literalMapCollection_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start literalMapCollection
    // EolParserRules.g:437:1: literalMapCollection : 'Map' '{' ( keyvalExpressionList )? '}' ;
    public final Flock_EolParserRules.literalMapCollection_return literalMapCollection() throws RecognitionException {
        Flock_EolParserRules.literalMapCollection_return retval = new Flock_EolParserRules.literalMapCollection_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal212=null;
        Token char_literal213=null;
        Token char_literal215=null;
        Flock_EolParserRules.keyvalExpressionList_return keyvalExpressionList214 = null;


        CommonTree string_literal212_tree=null;
        CommonTree char_literal213_tree=null;
        CommonTree char_literal215_tree=null;

        try {
            // EolParserRules.g:438:2: ( 'Map' '{' ( keyvalExpressionList )? '}' )
            // EolParserRules.g:438:4: 'Map' '{' ( keyvalExpressionList )? '}'
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal212=(Token)match(input,106,FOLLOW_106_in_literalMapCollection2075); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal212_tree = (CommonTree)adaptor.create(string_literal212);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal212_tree, root_0);
            }
            char_literal213=(Token)match(input,87,FOLLOW_87_in_literalMapCollection2078); if (state.failed) return retval;
            // EolParserRules.g:438:16: ( keyvalExpressionList )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==FLOAT||LA59_0==INT||LA59_0==BOOLEAN||LA59_0==STRING||LA59_0==NAME||LA59_0==92||(LA59_0>=99 && LA59_0<=106)||LA59_0==136||LA59_0==139||(LA59_0>=143 && LA59_0<=144)) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // EolParserRules.g:0:0: keyvalExpressionList
                    {
                    pushFollow(FOLLOW_keyvalExpressionList_in_literalMapCollection2081);
                    keyvalExpressionList214=keyvalExpressionList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, keyvalExpressionList214.getTree());

                    }
                    break;

            }

            char_literal215=(Token)match(input,88,FOLLOW_88_in_literalMapCollection2084); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
              if (root_0.getToken() != null) root_0.getToken().setType(MAP);
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
    // $ANTLR end literalMapCollection

    public static class keyvalExpressionList_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start keyvalExpressionList
    // EolParserRules.g:442:1: keyvalExpressionList : keyvalExpression ( ',' keyvalExpression )* -> ^( KEYVALLIST ( keyvalExpression )+ ) ;
    public final Flock_EolParserRules.keyvalExpressionList_return keyvalExpressionList() throws RecognitionException {
        Flock_EolParserRules.keyvalExpressionList_return retval = new Flock_EolParserRules.keyvalExpressionList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal217=null;
        Flock_EolParserRules.keyvalExpression_return keyvalExpression216 = null;

        Flock_EolParserRules.keyvalExpression_return keyvalExpression218 = null;


        CommonTree char_literal217_tree=null;
        RewriteRuleTokenStream stream_84=new RewriteRuleTokenStream(adaptor,"token 84");
        RewriteRuleSubtreeStream stream_keyvalExpression=new RewriteRuleSubtreeStream(adaptor,"rule keyvalExpression");
        try {
            // EolParserRules.g:443:2: ( keyvalExpression ( ',' keyvalExpression )* -> ^( KEYVALLIST ( keyvalExpression )+ ) )
            // EolParserRules.g:443:4: keyvalExpression ( ',' keyvalExpression )*
            {
            pushFollow(FOLLOW_keyvalExpression_in_keyvalExpressionList2099);
            keyvalExpression216=keyvalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_keyvalExpression.add(keyvalExpression216.getTree());
            // EolParserRules.g:443:21: ( ',' keyvalExpression )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==84) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // EolParserRules.g:443:22: ',' keyvalExpression
            	    {
            	    char_literal217=(Token)match(input,84,FOLLOW_84_in_keyvalExpressionList2102); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_84.add(char_literal217);

            	    pushFollow(FOLLOW_keyvalExpression_in_keyvalExpressionList2104);
            	    keyvalExpression218=keyvalExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_keyvalExpression.add(keyvalExpression218.getTree());

            	    }
            	    break;

            	default :
            	    break loop60;
                }
            } while (true);



            // AST REWRITE
            // elements: keyvalExpression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 444:2: -> ^( KEYVALLIST ( keyvalExpression )+ )
            {
                // EolParserRules.g:444:5: ^( KEYVALLIST ( keyvalExpression )+ )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(KEYVALLIST, "KEYVALLIST"), root_1);

                if ( !(stream_keyvalExpression.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_keyvalExpression.hasNext() ) {
                    adaptor.addChild(root_1, stream_keyvalExpression.nextTree());

                }
                stream_keyvalExpression.reset();

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
    // $ANTLR end keyvalExpressionList

    public static class keyvalExpression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start keyvalExpression
    // EolParserRules.g:447:1: keyvalExpression : additiveExpression '=' logicalExpression -> ^( KEYVAL additiveExpression logicalExpression ) ;
    public final Flock_EolParserRules.keyvalExpression_return keyvalExpression() throws RecognitionException {
        Flock_EolParserRules.keyvalExpression_return retval = new Flock_EolParserRules.keyvalExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal220=null;
        Flock_EolParserRules.additiveExpression_return additiveExpression219 = null;

        Flock_EolParserRules.logicalExpression_return logicalExpression221 = null;


        CommonTree char_literal220_tree=null;
        RewriteRuleTokenStream stream_89=new RewriteRuleTokenStream(adaptor,"token 89");
        RewriteRuleSubtreeStream stream_additiveExpression=new RewriteRuleSubtreeStream(adaptor,"rule additiveExpression");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:449:2: ( additiveExpression '=' logicalExpression -> ^( KEYVAL additiveExpression logicalExpression ) )
            // EolParserRules.g:449:4: additiveExpression '=' logicalExpression
            {
            pushFollow(FOLLOW_additiveExpression_in_keyvalExpression2129);
            additiveExpression219=additiveExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_additiveExpression.add(additiveExpression219.getTree());
            char_literal220=(Token)match(input,89,FOLLOW_89_in_keyvalExpression2131); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_89.add(char_literal220);

            pushFollow(FOLLOW_logicalExpression_in_keyvalExpression2133);
            logicalExpression221=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression221.getTree());


            // AST REWRITE
            // elements: logicalExpression, additiveExpression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 450:2: -> ^( KEYVAL additiveExpression logicalExpression )
            {
                // EolParserRules.g:450:5: ^( KEYVAL additiveExpression logicalExpression )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(KEYVAL, "KEYVAL"), root_1);

                adaptor.addChild(root_1, stream_additiveExpression.nextTree());
                adaptor.addChild(root_1, stream_logicalExpression.nextTree());

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
    // $ANTLR end keyvalExpression

    public static class primitiveExpression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start primitiveExpression
    // EolParserRules.g:452:1: primitiveExpression : ( literalSequentialCollection | literalMapCollection | literal | featureCall | pathName | nativeType | collectionType | '(' logicalExpression ')' | newExpression | variableDeclarationExpression );
    public final Flock_EolParserRules.primitiveExpression_return primitiveExpression() throws RecognitionException {
        Flock_EolParserRules.primitiveExpression_return retval = new Flock_EolParserRules.primitiveExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal229=null;
        Token char_literal231=null;
        Flock_EolParserRules.literalSequentialCollection_return literalSequentialCollection222 = null;

        Flock_EolParserRules.literalMapCollection_return literalMapCollection223 = null;

        Flock_EolParserRules.literal_return literal224 = null;

        Flock_EolParserRules.featureCall_return featureCall225 = null;

        Flock_EolParserRules.pathName_return pathName226 = null;

        Flock_EolParserRules.nativeType_return nativeType227 = null;

        Flock_EolParserRules.collectionType_return collectionType228 = null;

        Flock_EolParserRules.logicalExpression_return logicalExpression230 = null;

        Flock_EolParserRules.newExpression_return newExpression232 = null;

        Flock_EolParserRules.variableDeclarationExpression_return variableDeclarationExpression233 = null;


        CommonTree char_literal229_tree=null;
        CommonTree char_literal231_tree=null;

        try {
            // EolParserRules.g:453:2: ( literalSequentialCollection | literalMapCollection | literal | featureCall | pathName | nativeType | collectionType | '(' logicalExpression ')' | newExpression | variableDeclarationExpression )
            int alt61=10;
            alt61 = dfa61.predict(input);
            switch (alt61) {
                case 1 :
                    // EolParserRules.g:453:4: literalSequentialCollection
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_literalSequentialCollection_in_primitiveExpression2155);
                    literalSequentialCollection222=literalSequentialCollection();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, literalSequentialCollection222.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:453:34: literalMapCollection
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_literalMapCollection_in_primitiveExpression2159);
                    literalMapCollection223=literalMapCollection();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, literalMapCollection223.getTree());

                    }
                    break;
                case 3 :
                    // EolParserRules.g:453:57: literal
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_literal_in_primitiveExpression2163);
                    literal224=literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, literal224.getTree());

                    }
                    break;
                case 4 :
                    // EolParserRules.g:453:67: featureCall
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_featureCall_in_primitiveExpression2167);
                    featureCall225=featureCall();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, featureCall225.getTree());

                    }
                    break;
                case 5 :
                    // EolParserRules.g:453:81: pathName
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_pathName_in_primitiveExpression2171);
                    pathName226=pathName();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pathName226.getTree());

                    }
                    break;
                case 6 :
                    // EolParserRules.g:453:92: nativeType
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_nativeType_in_primitiveExpression2175);
                    nativeType227=nativeType();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nativeType227.getTree());

                    }
                    break;
                case 7 :
                    // EolParserRules.g:454:5: collectionType
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_collectionType_in_primitiveExpression2181);
                    collectionType228=collectionType();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, collectionType228.getTree());

                    }
                    break;
                case 8 :
                    // EolParserRules.g:454:23: '(' logicalExpression ')'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    char_literal229=(Token)match(input,92,FOLLOW_92_in_primitiveExpression2186); if (state.failed) return retval;
                    pushFollow(FOLLOW_logicalExpression_in_primitiveExpression2189);
                    logicalExpression230=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression230.getTree());
                    char_literal231=(Token)match(input,93,FOLLOW_93_in_primitiveExpression2191); if (state.failed) return retval;

                    }
                    break;
                case 9 :
                    // EolParserRules.g:455:5: newExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_newExpression_in_primitiveExpression2199);
                    newExpression232=newExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, newExpression232.getTree());

                    }
                    break;
                case 10 :
                    // EolParserRules.g:455:21: variableDeclarationExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_variableDeclarationExpression_in_primitiveExpression2203);
                    variableDeclarationExpression233=variableDeclarationExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, variableDeclarationExpression233.getTree());

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
    // $ANTLR end primitiveExpression

    public static class literal_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start literal
    // EolParserRules.g:458:1: literal : ( STRING | INT | FLOAT | BOOLEAN );
    public final Flock_EolParserRules.literal_return literal() throws RecognitionException {
        Flock_EolParserRules.literal_return retval = new Flock_EolParserRules.literal_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set234=null;

        CommonTree set234_tree=null;

        try {
            // EolParserRules.g:459:2: ( STRING | INT | FLOAT | BOOLEAN )
            // EolParserRules.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set234=(Token)input.LT(1);
            if ( input.LA(1)==FLOAT||input.LA(1)==INT||input.LA(1)==BOOLEAN||input.LA(1)==STRING ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set234));
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
    // $ANTLR end literal

    // $ANTLR start synpred29_EolParserRules
    public final void synpred29_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:217:4: ( '(' typeName ')' )
        // EolParserRules.g:217:4: '(' typeName ')'
        {
        match(input,92,FOLLOW_92_in_synpred29_EolParserRules860); if (state.failed) return ;
        pushFollow(FOLLOW_typeName_in_synpred29_EolParserRules865);
        typeName();

        state._fsp--;
        if (state.failed) return ;
        match(input,93,FOLLOW_93_in_synpred29_EolParserRules868); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred29_EolParserRules

    // $ANTLR start synpred30_EolParserRules
    public final void synpred30_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:224:4: ( statementA )
        // EolParserRules.g:224:4: statementA
        {
        pushFollow(FOLLOW_statementA_in_synpred30_EolParserRules891);
        statementA();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred30_EolParserRules

    // $ANTLR start synpred31_EolParserRules
    public final void synpred31_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:228:3: ( assignmentStatement )
        // EolParserRules.g:228:3: assignmentStatement
        {
        pushFollow(FOLLOW_assignmentStatement_in_synpred31_EolParserRules905);
        assignmentStatement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred31_EolParserRules

    // $ANTLR start synpred32_EolParserRules
    public final void synpred32_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:228:25: ( expressionStatement )
        // EolParserRules.g:228:25: expressionStatement
        {
        pushFollow(FOLLOW_expressionStatement_in_synpred32_EolParserRules909);
        expressionStatement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred32_EolParserRules

    // $ANTLR start synpred46_EolParserRules
    public final void synpred46_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:251:61: ( elseStatement )
        // EolParserRules.g:251:61: elseStatement
        {
        pushFollow(FOLLOW_elseStatement_in_synpred46_EolParserRules1063);
        elseStatement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred46_EolParserRules

    // $ANTLR start synpred53_EolParserRules
    public final void synpred53_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:316:19: ( NAME ( ',' NAME )* )
        // EolParserRules.g:316:19: NAME ( ',' NAME )*
        {
        match(input,NAME,FOLLOW_NAME_in_synpred53_EolParserRules1397); if (state.failed) return ;
        // EolParserRules.g:316:24: ( ',' NAME )*
        loop62:
        do {
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==84) ) {
                alt62=1;
            }


            switch (alt62) {
        	case 1 :
        	    // EolParserRules.g:316:25: ',' NAME
        	    {
        	    match(input,84,FOLLOW_84_in_synpred53_EolParserRules1400); if (state.failed) return ;
        	    match(input,NAME,FOLLOW_NAME_in_synpred53_EolParserRules1402); if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop62;
            }
        } while (true);


        }
    }
    // $ANTLR end synpred53_EolParserRules

    // $ANTLR start synpred55_EolParserRules
    public final void synpred55_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:330:5: ( postfixExpression '=' logicalExpression )
        // EolParserRules.g:330:5: postfixExpression '=' logicalExpression
        {
        pushFollow(FOLLOW_postfixExpression_in_synpred55_EolParserRules1473);
        postfixExpression();

        state._fsp--;
        if (state.failed) return ;
        match(input,89,FOLLOW_89_in_synpred55_EolParserRules1475); if (state.failed) return ;
        pushFollow(FOLLOW_logicalExpression_in_synpred55_EolParserRules1478);
        logicalExpression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred55_EolParserRules

    // $ANTLR start synpred66_EolParserRules
    public final void synpred66_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:340:24: ( ( '==' relationalExpression | '=' relationalExpression | ( '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression ) )
        // EolParserRules.g:340:24: ( '==' relationalExpression | '=' relationalExpression | ( '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression )
        {
        // EolParserRules.g:340:24: ( '==' relationalExpression | '=' relationalExpression | ( '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression )
        int alt63=3;
        switch ( input.LA(1) ) {
        case 129:
            {
            alt63=1;
            }
            break;
        case 89:
            {
            alt63=2;
            }
            break;
        case 130:
        case 131:
        case 132:
        case 133:
        case 134:
            {
            alt63=3;
            }
            break;
        default:
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 63, 0, input);

            throw nvae;
        }

        switch (alt63) {
            case 1 :
                // EolParserRules.g:340:25: '==' relationalExpression
                {
                match(input,129,FOLLOW_129_in_synpred66_EolParserRules1535); if (state.failed) return ;
                pushFollow(FOLLOW_relationalExpression_in_synpred66_EolParserRules1538);
                relationalExpression();

                state._fsp--;
                if (state.failed) return ;

                }
                break;
            case 2 :
                // EolParserRules.g:340:54: '=' relationalExpression
                {
                match(input,89,FOLLOW_89_in_synpred66_EolParserRules1542); if (state.failed) return ;
                pushFollow(FOLLOW_relationalExpression_in_synpred66_EolParserRules1545);
                relationalExpression();

                state._fsp--;
                if (state.failed) return ;

                }
                break;
            case 3 :
                // EolParserRules.g:341:24: ( '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression
                {
                if ( (input.LA(1)>=130 && input.LA(1)<=134) ) {
                    input.consume();
                    state.errorRecovery=false;state.failed=false;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    MismatchedSetException mse = new MismatchedSetException(null,input);
                    throw mse;
                }

                pushFollow(FOLLOW_additiveExpression_in_synpred66_EolParserRules1585);
                additiveExpression();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        }
    }
    // $ANTLR end synpred66_EolParserRules

    // $ANTLR start synpred85_EolParserRules
    public final void synpred85_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:410:16: ( ':' ( 'new' )? typeName ( parameterList )? )
        // EolParserRules.g:410:16: ':' ( 'new' )? typeName ( parameterList )?
        {
        match(input,83,FOLLOW_83_in_synpred85_EolParserRules1917); if (state.failed) return ;
        // EolParserRules.g:410:21: ( 'new' )?
        int alt66=2;
        int LA66_0 = input.LA(1);

        if ( (LA66_0==143) ) {
            alt66=1;
        }
        switch (alt66) {
            case 1 :
                // EolParserRules.g:0:0: 'new'
                {
                match(input,143,FOLLOW_143_in_synpred85_EolParserRules1921); if (state.failed) return ;

                }
                break;

        }

        pushFollow(FOLLOW_typeName_in_synpred85_EolParserRules1926);
        typeName();

        state._fsp--;
        if (state.failed) return ;
        // EolParserRules.g:410:65: ( parameterList )?
        int alt67=2;
        int LA67_0 = input.LA(1);

        if ( (LA67_0==92) ) {
            alt67=1;
        }
        switch (alt67) {
            case 1 :
                // EolParserRules.g:0:0: parameterList
                {
                pushFollow(FOLLOW_parameterList_in_synpred85_EolParserRules1930);
                parameterList();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        }
    }
    // $ANTLR end synpred85_EolParserRules

    // $ANTLR start synpred93_EolParserRules
    public final void synpred93_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:430:4: ( expressionRange )
        // EolParserRules.g:430:4: expressionRange
        {
        pushFollow(FOLLOW_expressionRange_in_synpred93_EolParserRules2052);
        expressionRange();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred93_EolParserRules

    // $ANTLR start synpred96_EolParserRules
    public final void synpred96_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:453:4: ( literalSequentialCollection )
        // EolParserRules.g:453:4: literalSequentialCollection
        {
        pushFollow(FOLLOW_literalSequentialCollection_in_synpred96_EolParserRules2155);
        literalSequentialCollection();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred96_EolParserRules

    // $ANTLR start synpred97_EolParserRules
    public final void synpred97_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:453:34: ( literalMapCollection )
        // EolParserRules.g:453:34: literalMapCollection
        {
        pushFollow(FOLLOW_literalMapCollection_in_synpred97_EolParserRules2159);
        literalMapCollection();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred97_EolParserRules

    // $ANTLR start synpred99_EolParserRules
    public final void synpred99_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:453:67: ( featureCall )
        // EolParserRules.g:453:67: featureCall
        {
        pushFollow(FOLLOW_featureCall_in_synpred99_EolParserRules2167);
        featureCall();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred99_EolParserRules

    // $ANTLR start synpred100_EolParserRules
    public final void synpred100_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:453:81: ( pathName )
        // EolParserRules.g:453:81: pathName
        {
        pushFollow(FOLLOW_pathName_in_synpred100_EolParserRules2171);
        pathName();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred100_EolParserRules

    // $ANTLR start synpred102_EolParserRules
    public final void synpred102_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:454:5: ( collectionType )
        // EolParserRules.g:454:5: collectionType
        {
        pushFollow(FOLLOW_collectionType_in_synpred102_EolParserRules2181);
        collectionType();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred102_EolParserRules

    // Delegated rules

    public final boolean synpred31_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred31_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred96_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred96_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred55_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred55_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred29_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred29_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred99_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred99_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred30_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred30_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred102_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred102_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred32_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred32_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred53_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred53_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred97_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred97_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred93_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred93_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred85_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred85_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred46_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred46_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred100_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred100_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred66_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred66_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA22 dfa22 = new DFA22(this);
    protected DFA23 dfa23 = new DFA23(this);
    protected DFA24 dfa24 = new DFA24(this);
    protected DFA35 dfa35 = new DFA35(this);
    protected DFA37 dfa37 = new DFA37(this);
    protected DFA47 dfa47 = new DFA47(this);
    protected DFA55 dfa55 = new DFA55(this);
    protected DFA58 dfa58 = new DFA58(this);
    protected DFA61 dfa61 = new DFA61(this);
    static final String DFA22_eotS =
        "\40\uffff";
    static final String DFA22_eofS =
        "\1\2\37\uffff";
    static final String DFA22_minS =
        "\1\11\1\0\36\uffff";
    static final String DFA22_maxS =
        "\1\u0093\1\0\36\uffff";
    static final String DFA22_acceptS =
        "\2\uffff\1\2\34\uffff\1\1";
    static final String DFA22_specialS =
        "\1\uffff\1\0\36\uffff}>";
    static final String[] DFA22_transitionS = {
            "\3\2\7\uffff\1\2\3\uffff\1\2\72\uffff\3\2\2\uffff\5\2\1\1\1"+
            "\2\1\uffff\1\2\14\uffff\1\2\10\uffff\1\2\5\uffff\20\2\1\uffff"+
            "\3\2\2\uffff\1\2\1\uffff\1\2",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA22_eot = DFA.unpackEncodedString(DFA22_eotS);
    static final short[] DFA22_eof = DFA.unpackEncodedString(DFA22_eofS);
    static final char[] DFA22_min = DFA.unpackEncodedStringToUnsignedChars(DFA22_minS);
    static final char[] DFA22_max = DFA.unpackEncodedStringToUnsignedChars(DFA22_maxS);
    static final short[] DFA22_accept = DFA.unpackEncodedString(DFA22_acceptS);
    static final short[] DFA22_special = DFA.unpackEncodedString(DFA22_specialS);
    static final short[][] DFA22_transition;

    static {
        int numStates = DFA22_transitionS.length;
        DFA22_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA22_transition[i] = DFA.unpackEncodedString(DFA22_transitionS[i]);
        }
    }

    class DFA22 extends DFA {

        public DFA22(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 22;
            this.eot = DFA22_eot;
            this.eof = DFA22_eof;
            this.min = DFA22_min;
            this.max = DFA22_max;
            this.accept = DFA22_accept;
            this.special = DFA22_special;
            this.transition = DFA22_transition;
        }
        public String getDescription() {
            return "217:3: ( '(' tn= typeName ')' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA22_1 = input.LA(1);

                         
                        int index22_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_EolParserRules()) ) {s = 31;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index22_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 22, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA23_eotS =
        "\26\uffff";
    static final String DFA23_eofS =
        "\26\uffff";
    static final String DFA23_minS =
        "\1\4\15\uffff\1\0\7\uffff";
    static final String DFA23_maxS =
        "\1\u0090\15\uffff\1\0\7\uffff";
    static final String DFA23_acceptS =
        "\1\uffff\1\1\16\uffff\1\2\5\uffff";
    static final String DFA23_specialS =
        "\16\uffff\1\0\7\uffff}>";
    static final String[] DFA23_transitionS = {
            "\1\1\3\uffff\1\1\3\uffff\1\1\1\uffff\1\1\4\uffff\1\1\110\uffff"+
            "\1\1\6\uffff\11\1\1\uffff\2\1\3\uffff\1\1\1\16\2\20\1\1\4\20"+
            "\15\uffff\1\1\2\uffff\1\1\3\uffff\2\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA23_eot = DFA.unpackEncodedString(DFA23_eotS);
    static final short[] DFA23_eof = DFA.unpackEncodedString(DFA23_eofS);
    static final char[] DFA23_min = DFA.unpackEncodedStringToUnsignedChars(DFA23_minS);
    static final char[] DFA23_max = DFA.unpackEncodedStringToUnsignedChars(DFA23_maxS);
    static final short[] DFA23_accept = DFA.unpackEncodedString(DFA23_acceptS);
    static final short[] DFA23_special = DFA.unpackEncodedString(DFA23_specialS);
    static final short[][] DFA23_transition;

    static {
        int numStates = DFA23_transitionS.length;
        DFA23_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA23_transition[i] = DFA.unpackEncodedString(DFA23_transitionS[i]);
        }
    }

    class DFA23 extends DFA {

        public DFA23(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 23;
            this.eot = DFA23_eot;
            this.eof = DFA23_eof;
            this.min = DFA23_min;
            this.max = DFA23_max;
            this.accept = DFA23_accept;
            this.special = DFA23_special;
            this.transition = DFA23_transition;
        }
        public String getDescription() {
            return "223:1: statement : ( statementA | statementB );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA23_14 = input.LA(1);

                         
                        int index23_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_EolParserRules()) ) {s = 1;}

                        else if ( (true) ) {s = 16;}

                         
                        input.seek(index23_14);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 23, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA24_eotS =
        "\22\uffff";
    static final String DFA24_eofS =
        "\22\uffff";
    static final String DFA24_minS =
        "\1\4\11\0\10\uffff";
    static final String DFA24_maxS =
        "\1\u0090\11\0\10\uffff";
    static final String DFA24_acceptS =
        "\12\uffff\1\3\1\4\1\5\1\6\1\7\1\10\1\1\1\2";
    static final String DFA24_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\10\uffff}>";
    static final String[] DFA24_transitionS = {
            "\1\4\3\uffff\1\4\3\uffff\1\4\1\uffff\1\4\4\uffff\1\5\110\uffff"+
            "\1\7\6\uffff\1\6\6\2\1\3\1\12\1\uffff\1\13\1\15\3\uffff\1\14"+
            "\1\16\2\uffff\1\17\21\uffff\1\1\2\uffff\1\1\3\uffff\1\10\1\11",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA24_eot = DFA.unpackEncodedString(DFA24_eotS);
    static final short[] DFA24_eof = DFA.unpackEncodedString(DFA24_eofS);
    static final char[] DFA24_min = DFA.unpackEncodedStringToUnsignedChars(DFA24_minS);
    static final char[] DFA24_max = DFA.unpackEncodedStringToUnsignedChars(DFA24_maxS);
    static final short[] DFA24_accept = DFA.unpackEncodedString(DFA24_acceptS);
    static final short[] DFA24_special = DFA.unpackEncodedString(DFA24_specialS);
    static final short[][] DFA24_transition;

    static {
        int numStates = DFA24_transitionS.length;
        DFA24_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA24_transition[i] = DFA.unpackEncodedString(DFA24_transitionS[i]);
        }
    }

    class DFA24 extends DFA {

        public DFA24(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 24;
            this.eot = DFA24_eot;
            this.eof = DFA24_eof;
            this.min = DFA24_min;
            this.max = DFA24_max;
            this.accept = DFA24_accept;
            this.special = DFA24_special;
            this.transition = DFA24_transition;
        }
        public String getDescription() {
            return "227:1: statementA : ( assignmentStatement | expressionStatement | forStatement | ifStatement | whileStatement | switchStatement | returnStatement | breakStatement );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA24_1 = input.LA(1);

                         
                        int index24_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_EolParserRules()) ) {s = 16;}

                        else if ( (synpred32_EolParserRules()) ) {s = 17;}

                         
                        input.seek(index24_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA24_2 = input.LA(1);

                         
                        int index24_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_EolParserRules()) ) {s = 16;}

                        else if ( (synpred32_EolParserRules()) ) {s = 17;}

                         
                        input.seek(index24_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA24_3 = input.LA(1);

                         
                        int index24_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_EolParserRules()) ) {s = 16;}

                        else if ( (synpred32_EolParserRules()) ) {s = 17;}

                         
                        input.seek(index24_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA24_4 = input.LA(1);

                         
                        int index24_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_EolParserRules()) ) {s = 16;}

                        else if ( (synpred32_EolParserRules()) ) {s = 17;}

                         
                        input.seek(index24_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA24_5 = input.LA(1);

                         
                        int index24_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_EolParserRules()) ) {s = 16;}

                        else if ( (synpred32_EolParserRules()) ) {s = 17;}

                         
                        input.seek(index24_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA24_6 = input.LA(1);

                         
                        int index24_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_EolParserRules()) ) {s = 16;}

                        else if ( (synpred32_EolParserRules()) ) {s = 17;}

                         
                        input.seek(index24_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA24_7 = input.LA(1);

                         
                        int index24_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_EolParserRules()) ) {s = 16;}

                        else if ( (synpred32_EolParserRules()) ) {s = 17;}

                         
                        input.seek(index24_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA24_8 = input.LA(1);

                         
                        int index24_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_EolParserRules()) ) {s = 16;}

                        else if ( (synpred32_EolParserRules()) ) {s = 17;}

                         
                        input.seek(index24_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA24_9 = input.LA(1);

                         
                        int index24_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_EolParserRules()) ) {s = 16;}

                        else if ( (synpred32_EolParserRules()) ) {s = 17;}

                         
                        input.seek(index24_9);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 24, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA35_eotS =
        "\30\uffff";
    static final String DFA35_eofS =
        "\30\uffff";
    static final String DFA35_minS =
        "\1\4\1\0\26\uffff";
    static final String DFA35_maxS =
        "\1\u0090\1\0\26\uffff";
    static final String DFA35_acceptS =
        "\2\uffff\1\2\24\uffff\1\1";
    static final String DFA35_specialS =
        "\1\uffff\1\0\26\uffff}>";
    static final String[] DFA35_transitionS = {
            "\1\2\3\uffff\1\2\3\uffff\1\2\1\uffff\1\2\4\uffff\1\1\103\uffff"+
            "\1\2\4\uffff\1\2\6\uffff\11\2\1\uffff\2\2\3\uffff\11\2\15\uffff"+
            "\1\2\2\uffff\1\2\3\uffff\2\2",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA35_eot = DFA.unpackEncodedString(DFA35_eotS);
    static final short[] DFA35_eof = DFA.unpackEncodedString(DFA35_eofS);
    static final char[] DFA35_min = DFA.unpackEncodedStringToUnsignedChars(DFA35_minS);
    static final char[] DFA35_max = DFA.unpackEncodedStringToUnsignedChars(DFA35_maxS);
    static final short[] DFA35_accept = DFA.unpackEncodedString(DFA35_acceptS);
    static final short[] DFA35_special = DFA.unpackEncodedString(DFA35_specialS);
    static final short[][] DFA35_transition;

    static {
        int numStates = DFA35_transitionS.length;
        DFA35_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA35_transition[i] = DFA.unpackEncodedString(DFA35_transitionS[i]);
        }
    }

    class DFA35 extends DFA {

        public DFA35(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 35;
            this.eot = DFA35_eot;
            this.eof = DFA35_eof;
            this.min = DFA35_min;
            this.max = DFA35_max;
            this.accept = DFA35_accept;
            this.special = DFA35_special;
            this.transition = DFA35_transition;
        }
        public String getDescription() {
            return "316:18: ( NAME ( ',' NAME )* )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA35_1 = input.LA(1);

                         
                        int index35_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred53_EolParserRules()) ) {s = 23;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index35_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 35, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA37_eotS =
        "\13\uffff";
    static final String DFA37_eofS =
        "\13\uffff";
    static final String DFA37_minS =
        "\1\4\10\0\2\uffff";
    static final String DFA37_maxS =
        "\1\u0090\10\0\2\uffff";
    static final String DFA37_acceptS =
        "\11\uffff\1\2\1\1";
    static final String DFA37_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\2\uffff}>";
    static final String[] DFA37_transitionS = {
            "\1\3\3\uffff\1\3\3\uffff\1\3\1\uffff\1\3\4\uffff\1\4\110\uffff"+
            "\1\6\6\uffff\1\5\6\1\1\2\35\uffff\1\11\2\uffff\1\11\3\uffff"+
            "\1\7\1\10",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            ""
    };

    static final short[] DFA37_eot = DFA.unpackEncodedString(DFA37_eotS);
    static final short[] DFA37_eof = DFA.unpackEncodedString(DFA37_eofS);
    static final char[] DFA37_min = DFA.unpackEncodedStringToUnsignedChars(DFA37_minS);
    static final char[] DFA37_max = DFA.unpackEncodedStringToUnsignedChars(DFA37_maxS);
    static final short[] DFA37_accept = DFA.unpackEncodedString(DFA37_acceptS);
    static final short[] DFA37_special = DFA.unpackEncodedString(DFA37_specialS);
    static final short[][] DFA37_transition;

    static {
        int numStates = DFA37_transitionS.length;
        DFA37_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA37_transition[i] = DFA.unpackEncodedString(DFA37_transitionS[i]);
        }
    }

    class DFA37 extends DFA {

        public DFA37(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 37;
            this.eot = DFA37_eot;
            this.eof = DFA37_eof;
            this.min = DFA37_min;
            this.max = DFA37_max;
            this.accept = DFA37_accept;
            this.special = DFA37_special;
            this.transition = DFA37_transition;
        }
        public String getDescription() {
            return "330:4: ( postfixExpression '=' logicalExpression | logicalExpression )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA37_1 = input.LA(1);

                         
                        int index37_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred55_EolParserRules()) ) {s = 10;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index37_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA37_2 = input.LA(1);

                         
                        int index37_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred55_EolParserRules()) ) {s = 10;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index37_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA37_3 = input.LA(1);

                         
                        int index37_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred55_EolParserRules()) ) {s = 10;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index37_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA37_4 = input.LA(1);

                         
                        int index37_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred55_EolParserRules()) ) {s = 10;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index37_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA37_5 = input.LA(1);

                         
                        int index37_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred55_EolParserRules()) ) {s = 10;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index37_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA37_6 = input.LA(1);

                         
                        int index37_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred55_EolParserRules()) ) {s = 10;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index37_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA37_7 = input.LA(1);

                         
                        int index37_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred55_EolParserRules()) ) {s = 10;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index37_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA37_8 = input.LA(1);

                         
                        int index37_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred55_EolParserRules()) ) {s = 10;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index37_8);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 37, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA47_eotS =
        "\10\uffff";
    static final String DFA47_eofS =
        "\1\uffff\1\3\6\uffff";
    static final String DFA47_minS =
        "\1\23\1\11\1\4\1\uffff\1\11\1\4\1\uffff\1\11";
    static final String DFA47_maxS =
        "\1\23\1\u0093\1\u0090\1\uffff\1\u008e\1\u0090\1\uffff\1\u008e";
    static final String DFA47_acceptS =
        "\3\uffff\1\1\2\uffff\1\2\1\uffff";
    static final String DFA47_specialS =
        "\10\uffff}>";
    static final String[] DFA47_transitionS = {
            "\1\1",
            "\3\3\13\uffff\1\3\72\uffff\3\3\2\uffff\5\3\1\2\1\3\1\uffff\1"+
            "\3\25\uffff\1\3\5\uffff\20\3\1\uffff\2\3\3\uffff\1\3\1\uffff"+
            "\1\3",
            "\1\3\3\uffff\1\3\3\uffff\1\3\1\uffff\1\3\4\uffff\1\4\110\uffff"+
            "\2\3\5\uffff\10\3\35\uffff\1\3\2\uffff\1\3\3\uffff\2\3",
            "",
            "\1\3\1\uffff\1\3\107\uffff\1\6\1\5\4\uffff\1\3\2\uffff\2\3\2"+
            "\uffff\3\3\32\uffff\16\3\1\uffff\1\3\1\uffff\1\6",
            "\1\3\3\uffff\1\3\3\uffff\1\3\1\uffff\1\3\4\uffff\1\7\110\uffff"+
            "\1\3\6\uffff\10\3\35\uffff\1\3\2\uffff\1\3\3\uffff\2\3",
            "",
            "\1\3\1\uffff\1\3\107\uffff\1\6\1\5\4\uffff\1\3\2\uffff\2\3\2"+
            "\uffff\3\3\32\uffff\16\3\1\uffff\1\3\1\uffff\1\6"
    };

    static final short[] DFA47_eot = DFA.unpackEncodedString(DFA47_eotS);
    static final short[] DFA47_eof = DFA.unpackEncodedString(DFA47_eofS);
    static final char[] DFA47_min = DFA.unpackEncodedStringToUnsignedChars(DFA47_minS);
    static final char[] DFA47_max = DFA.unpackEncodedStringToUnsignedChars(DFA47_maxS);
    static final short[] DFA47_accept = DFA.unpackEncodedString(DFA47_acceptS);
    static final short[] DFA47_special = DFA.unpackEncodedString(DFA47_specialS);
    static final short[][] DFA47_transition;

    static {
        int numStates = DFA47_transitionS.length;
        DFA47_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA47_transition[i] = DFA.unpackEncodedString(DFA47_transitionS[i]);
        }
    }

    class DFA47 extends DFA {

        public DFA47(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 47;
            this.eot = DFA47_eot;
            this.eof = DFA47_eof;
            this.min = DFA47_min;
            this.max = DFA47_max;
            this.accept = DFA47_accept;
            this.special = DFA47_special;
            this.transition = DFA47_transition;
        }
        public String getDescription() {
            return "377:1: featureCall : ( simpleFeatureCall | declarativeFeatureCall );";
        }
    }
    static final String DFA55_eotS =
        "\22\uffff";
    static final String DFA55_eofS =
        "\2\2\20\uffff";
    static final String DFA55_minS =
        "\1\11\1\4\1\uffff\1\23\1\0\1\134\3\0\1\134\1\0\1\uffff\2\16\2\135"+
        "\2\0";
    static final String DFA55_maxS =
        "\1\u0093\1\u0090\1\uffff\1\152\1\0\1\134\3\0\1\134\1\0\1\uffff\2"+
        "\16\2\135\2\0";
    static final String DFA55_acceptS =
        "\2\uffff\1\2\10\uffff\1\1\6\uffff";
    static final String DFA55_specialS =
        "\4\uffff\1\4\1\uffff\1\5\1\6\1\2\1\uffff\1\3\5\uffff\1\0\1\1}>";
    static final String[] DFA55_transitionS = {
            "\3\2\13\uffff\1\2\72\uffff\1\2\1\1\1\2\2\uffff\5\2\1\uffff\1"+
            "\2\1\uffff\1\2\25\uffff\1\2\5\uffff\20\2\1\uffff\2\2\3\uffff"+
            "\1\2\1\uffff\1\2",
            "\1\2\3\uffff\1\2\3\uffff\1\2\1\uffff\1\2\4\uffff\1\4\104\uffff"+
            "\1\2\3\uffff\1\2\6\uffff\1\5\6\6\1\7\1\2\1\uffff\4\2\1\uffff"+
            "\11\2\15\uffff\1\2\2\uffff\1\2\3\uffff\1\3\1\2",
            "",
            "\1\10\117\uffff\1\11\7\12",
            "\1\uffff",
            "\1\14",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\15",
            "\1\uffff",
            "",
            "\1\16",
            "\1\17",
            "\1\20",
            "\1\21",
            "\1\uffff",
            "\1\uffff"
    };

    static final short[] DFA55_eot = DFA.unpackEncodedString(DFA55_eotS);
    static final short[] DFA55_eof = DFA.unpackEncodedString(DFA55_eofS);
    static final char[] DFA55_min = DFA.unpackEncodedStringToUnsignedChars(DFA55_minS);
    static final char[] DFA55_max = DFA.unpackEncodedStringToUnsignedChars(DFA55_maxS);
    static final short[] DFA55_accept = DFA.unpackEncodedString(DFA55_acceptS);
    static final short[] DFA55_special = DFA.unpackEncodedString(DFA55_specialS);
    static final short[][] DFA55_transition;

    static {
        int numStates = DFA55_transitionS.length;
        DFA55_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA55_transition[i] = DFA.unpackEncodedString(DFA55_transitionS[i]);
        }
    }

    class DFA55 extends DFA {

        public DFA55(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 55;
            this.eot = DFA55_eot;
            this.eof = DFA55_eof;
            this.min = DFA55_min;
            this.max = DFA55_max;
            this.accept = DFA55_accept;
            this.special = DFA55_special;
            this.transition = DFA55_transition;
        }
        public String getDescription() {
            return "410:15: ( ':' (n= 'new' )? t= typeName ( parameterList )? )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA55_16 = input.LA(1);

                         
                        int index55_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred85_EolParserRules()) ) {s = 11;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index55_16);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA55_17 = input.LA(1);

                         
                        int index55_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred85_EolParserRules()) ) {s = 11;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index55_17);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA55_8 = input.LA(1);

                         
                        int index55_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred85_EolParserRules()) ) {s = 11;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index55_8);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA55_10 = input.LA(1);

                         
                        int index55_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred85_EolParserRules()) ) {s = 11;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index55_10);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA55_4 = input.LA(1);

                         
                        int index55_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred85_EolParserRules()) ) {s = 11;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index55_4);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA55_6 = input.LA(1);

                         
                        int index55_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred85_EolParserRules()) ) {s = 11;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index55_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA55_7 = input.LA(1);

                         
                        int index55_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred85_EolParserRules()) ) {s = 11;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index55_7);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 55, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA58_eotS =
        "\14\uffff";
    static final String DFA58_eofS =
        "\14\uffff";
    static final String DFA58_minS =
        "\1\4\11\0\2\uffff";
    static final String DFA58_maxS =
        "\1\u0090\11\0\2\uffff";
    static final String DFA58_acceptS =
        "\12\uffff\1\1\1\2";
    static final String DFA58_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\2\uffff}>";
    static final String[] DFA58_transitionS = {
            "\1\4\3\uffff\1\4\3\uffff\1\4\1\uffff\1\4\4\uffff\1\5\110\uffff"+
            "\1\7\6\uffff\1\6\6\2\1\3\35\uffff\1\1\2\uffff\1\1\3\uffff\1"+
            "\10\1\11",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            ""
    };

    static final short[] DFA58_eot = DFA.unpackEncodedString(DFA58_eotS);
    static final short[] DFA58_eof = DFA.unpackEncodedString(DFA58_eofS);
    static final char[] DFA58_min = DFA.unpackEncodedStringToUnsignedChars(DFA58_minS);
    static final char[] DFA58_max = DFA.unpackEncodedStringToUnsignedChars(DFA58_maxS);
    static final short[] DFA58_accept = DFA.unpackEncodedString(DFA58_acceptS);
    static final short[] DFA58_special = DFA.unpackEncodedString(DFA58_specialS);
    static final short[][] DFA58_transition;

    static {
        int numStates = DFA58_transitionS.length;
        DFA58_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA58_transition[i] = DFA.unpackEncodedString(DFA58_transitionS[i]);
        }
    }

    class DFA58 extends DFA {

        public DFA58(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 58;
            this.eot = DFA58_eot;
            this.eof = DFA58_eof;
            this.min = DFA58_min;
            this.max = DFA58_max;
            this.accept = DFA58_accept;
            this.special = DFA58_special;
            this.transition = DFA58_transition;
        }
        public String getDescription() {
            return "429:1: expressionListOrRange : ( expressionRange | expressionList );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA58_1 = input.LA(1);

                         
                        int index58_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred93_EolParserRules()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index58_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA58_2 = input.LA(1);

                         
                        int index58_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred93_EolParserRules()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index58_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA58_3 = input.LA(1);

                         
                        int index58_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred93_EolParserRules()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index58_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA58_4 = input.LA(1);

                         
                        int index58_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred93_EolParserRules()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index58_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA58_5 = input.LA(1);

                         
                        int index58_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred93_EolParserRules()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index58_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA58_6 = input.LA(1);

                         
                        int index58_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred93_EolParserRules()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index58_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA58_7 = input.LA(1);

                         
                        int index58_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred93_EolParserRules()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index58_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA58_8 = input.LA(1);

                         
                        int index58_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred93_EolParserRules()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index58_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA58_9 = input.LA(1);

                         
                        int index58_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred93_EolParserRules()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index58_9);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 58, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA61_eotS =
        "\16\uffff";
    static final String DFA61_eofS =
        "\16\uffff";
    static final String DFA61_minS =
        "\1\4\2\0\1\uffff\1\0\11\uffff";
    static final String DFA61_maxS =
        "\1\u0090\2\0\1\uffff\1\0\11\uffff";
    static final String DFA61_acceptS =
        "\3\uffff\1\3\1\uffff\1\6\1\10\1\11\1\12\1\1\1\7\1\2\1\4\1\5";
    static final String DFA61_specialS =
        "\1\uffff\1\0\1\1\1\uffff\1\2\11\uffff}>";
    static final String[] DFA61_transitionS = {
            "\1\3\3\uffff\1\3\3\uffff\1\3\1\uffff\1\3\4\uffff\1\4\110\uffff"+
            "\1\6\6\uffff\1\5\6\1\1\2\44\uffff\1\7\1\10",
            "\1\uffff",
            "\1\uffff",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA61_eot = DFA.unpackEncodedString(DFA61_eotS);
    static final short[] DFA61_eof = DFA.unpackEncodedString(DFA61_eofS);
    static final char[] DFA61_min = DFA.unpackEncodedStringToUnsignedChars(DFA61_minS);
    static final char[] DFA61_max = DFA.unpackEncodedStringToUnsignedChars(DFA61_maxS);
    static final short[] DFA61_accept = DFA.unpackEncodedString(DFA61_acceptS);
    static final short[] DFA61_special = DFA.unpackEncodedString(DFA61_specialS);
    static final short[][] DFA61_transition;

    static {
        int numStates = DFA61_transitionS.length;
        DFA61_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA61_transition[i] = DFA.unpackEncodedString(DFA61_transitionS[i]);
        }
    }

    class DFA61 extends DFA {

        public DFA61(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 61;
            this.eot = DFA61_eot;
            this.eof = DFA61_eof;
            this.min = DFA61_min;
            this.max = DFA61_max;
            this.accept = DFA61_accept;
            this.special = DFA61_special;
            this.transition = DFA61_transition;
        }
        public String getDescription() {
            return "452:1: primitiveExpression : ( literalSequentialCollection | literalMapCollection | literal | featureCall | pathName | nativeType | collectionType | '(' logicalExpression ')' | newExpression | variableDeclarationExpression );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA61_1 = input.LA(1);

                         
                        int index61_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred96_EolParserRules()) ) {s = 9;}

                        else if ( (synpred102_EolParserRules()) ) {s = 10;}

                         
                        input.seek(index61_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA61_2 = input.LA(1);

                         
                        int index61_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred97_EolParserRules()) ) {s = 11;}

                        else if ( (synpred102_EolParserRules()) ) {s = 10;}

                         
                        input.seek(index61_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA61_4 = input.LA(1);

                         
                        int index61_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred99_EolParserRules()) ) {s = 12;}

                        else if ( (synpred100_EolParserRules()) ) {s = 13;}

                         
                        input.seek(index61_4);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 61, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_operationDeclaration_in_operationDeclarationOrAnnotationBlock246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationBlock_in_operationDeclarationOrAnnotationBlock248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_81_in_modelDeclaration259 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_modelDeclaration261 = new BitSet(new long[]{0x0000000000000000L,0x0000000000E40000L});
    public static final BitSet FOLLOW_modelAlias_in_modelDeclaration263 = new BitSet(new long[]{0x0000000000000000L,0x0000000000C40000L});
    public static final BitSet FOLLOW_modelDriver_in_modelDeclaration266 = new BitSet(new long[]{0x0000000000000000L,0x0000000000840000L});
    public static final BitSet FOLLOW_modelDeclarationParameters_in_modelDeclaration269 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_82_in_modelDeclaration272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_83_in_modelNamespace310 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_modelNamespace312 = new BitSet(new long[]{0x0000000000000002L,0x0000000000100000L});
    public static final BitSet FOLLOW_84_in_modelNamespace315 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_modelNamespace317 = new BitSet(new long[]{0x0000000000000002L,0x0000000000100000L});
    public static final BitSet FOLLOW_85_in_modelAlias341 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_modelAlias343 = new BitSet(new long[]{0x0000000000000002L,0x0000000000100000L});
    public static final BitSet FOLLOW_84_in_modelAlias346 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_modelAlias348 = new BitSet(new long[]{0x0000000000000002L,0x0000000000100000L});
    public static final BitSet FOLLOW_86_in_modelDriver372 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_modelDriver374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_87_in_modelDeclarationParameters394 = new BitSet(new long[]{0x0000000000080000L,0x0000000001100000L});
    public static final BitSet FOLLOW_modelDeclarationParameter_in_modelDeclarationParameters396 = new BitSet(new long[]{0x0000000000000000L,0x0000000001100000L});
    public static final BitSet FOLLOW_84_in_modelDeclarationParameters400 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_modelDeclarationParameter_in_modelDeclarationParameters402 = new BitSet(new long[]{0x0000000000000000L,0x0000000001100000L});
    public static final BitSet FOLLOW_88_in_modelDeclarationParameters406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_modelDeclarationParameter430 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_89_in_modelDeclarationParameter432 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_STRING_in_modelDeclarationParameter434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_90_in_operationDeclaration460 = new BitSet(new long[]{0x0000000000080000L,0x000007F800000000L});
    public static final BitSet FOLLOW_91_in_operationDeclaration462 = new BitSet(new long[]{0x0000000000080000L,0x000007F800000000L});
    public static final BitSet FOLLOW_typeName_in_operationDeclaration468 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_operationDeclaration476 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_92_in_operationDeclaration478 = new BitSet(new long[]{0x0000000000080000L,0x0000000020000000L});
    public static final BitSet FOLLOW_formalParameterList_in_operationDeclaration480 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_operationDeclaration483 = new BitSet(new long[]{0x0000000000000000L,0x0000000000880000L});
    public static final BitSet FOLLOW_83_in_operationDeclaration486 = new BitSet(new long[]{0x0000000000080000L,0x000007F800000000L});
    public static final BitSet FOLLOW_typeName_in_operationDeclaration490 = new BitSet(new long[]{0x0000000000000000L,0x0000000000880000L});
    public static final BitSet FOLLOW_statementBlock_in_operationDeclaration496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_importStatement533 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_STRING_in_importStatement536 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_82_in_importStatement538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_block553 = new BitSet(new long[]{0x0000000000085112L,0x07FC6FF810000000L,0x0000000000018900L});
    public static final BitSet FOLLOW_87_in_statementBlock575 = new BitSet(new long[]{0x0000000000085110L,0x07FC6FF810000000L,0x0000000000018900L});
    public static final BitSet FOLLOW_block_in_statementBlock578 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_88_in_statementBlock580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_formalParameter592 = new BitSet(new long[]{0x0000000000000002L,0x0000000000080000L});
    public static final BitSet FOLLOW_83_in_formalParameter595 = new BitSet(new long[]{0x0000000000080000L,0x000007F800000000L});
    public static final BitSet FOLLOW_typeName_in_formalParameter599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_formalParameter_in_formalParameterList628 = new BitSet(new long[]{0x0000000000000002L,0x0000000000100000L});
    public static final BitSet FOLLOW_84_in_formalParameterList631 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_formalParameter_in_formalParameterList633 = new BitSet(new long[]{0x0000000000000002L,0x0000000000100000L});
    public static final BitSet FOLLOW_95_in_executableAnnotation656 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0xFFFFFFFFFFFFFFFFL,0x00000000003FFFFFL});
    public static final BitSet FOLLOW_logicalExpression_in_executableAnnotation662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Annotation_in_annotation685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_executableAnnotation_in_annotation687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotation_in_annotationBlock698 = new BitSet(new long[]{0x0000000000800002L,0x0000000080000000L});
    public static final BitSet FOLLOW_pathName_in_typeName721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nativeType_in_typeName725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectionType_in_typeName729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_pathName746 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_96_in_pathName749 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_packagedType_in_pathName758 = new BitSet(new long[]{0x0000000000000002L,0x0000000200000000L});
    public static final BitSet FOLLOW_97_in_pathName763 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_pathName768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_packagedType790 = new BitSet(new long[]{0x0000000000000002L,0x0000000400000000L});
    public static final BitSet FOLLOW_98_in_packagedType793 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_packagedType798 = new BitSet(new long[]{0x0000000000000002L,0x0000000400000000L});
    public static final BitSet FOLLOW_99_in_nativeType814 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_92_in_nativeType817 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_STRING_in_nativeType820 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_nativeType822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_collectionType840 = new BitSet(new long[]{0x0000000000000002L,0x0000000010000000L});
    public static final BitSet FOLLOW_92_in_collectionType860 = new BitSet(new long[]{0x0000000000080000L,0x000007F800000000L});
    public static final BitSet FOLLOW_typeName_in_collectionType865 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_collectionType868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementA_in_statement891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementB_in_statement895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignmentStatement_in_statementA905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionStatement_in_statementA909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_forStatement_in_statementA913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStatement_in_statementA919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_whileStatement_in_statementA923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_switchStatement_in_statementA927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_returnStatement_in_statementA931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_breakStatement_in_statementA935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_breakAllStatement_in_statementB947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_returnStatement_in_statementB951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_transactionStatement_in_statementB955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_abortStatement_in_statementB961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_continueStatement_in_statementB965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_throwStatement_in_statementB969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_deleteStatement_in_statementB975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_statementOrStatementBlock986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementBlock_in_statementOrStatementBlock990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_83_in_expressionOrStatementBlock999 = new BitSet(new long[]{0x0000000000085110L,0x000007F810000000L,0x0000000000018900L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionOrStatementBlock1002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementBlock_in_expressionOrStatementBlock1006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_107_in_forStatement1017 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_92_in_forStatement1019 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_formalParameter_in_forStatement1021 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_108_in_forStatement1023 = new BitSet(new long[]{0x0000000000085110L,0x000007F810000000L,0x0000000000018900L});
    public static final BitSet FOLLOW_logicalExpression_in_forStatement1025 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_forStatement1027 = new BitSet(new long[]{0x0000000000085110L,0x07FC6FF810880000L,0x0000000000018900L});
    public static final BitSet FOLLOW_statementOrStatementBlock_in_forStatement1029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_109_in_ifStatement1053 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_92_in_ifStatement1055 = new BitSet(new long[]{0x0000000000085110L,0x000007F810000000L,0x0000000000018900L});
    public static final BitSet FOLLOW_logicalExpression_in_ifStatement1057 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_ifStatement1059 = new BitSet(new long[]{0x0000000000085110L,0x07FC6FF810880000L,0x0000000000018900L});
    public static final BitSet FOLLOW_statementOrStatementBlock_in_ifStatement1061 = new BitSet(new long[]{0x0000000000000002L,0x0002000000000000L});
    public static final BitSet FOLLOW_elseStatement_in_ifStatement1063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_110_in_switchStatement1090 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_92_in_switchStatement1092 = new BitSet(new long[]{0x0000000000085110L,0x000007F810000000L,0x0000000000018900L});
    public static final BitSet FOLLOW_logicalExpression_in_switchStatement1094 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_switchStatement1096 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_87_in_switchStatement1098 = new BitSet(new long[]{0x0000000000000000L,0x0001800001000000L});
    public static final BitSet FOLLOW_caseStatement_in_switchStatement1100 = new BitSet(new long[]{0x0000000000000000L,0x0001800001000000L});
    public static final BitSet FOLLOW_defaultStatement_in_switchStatement1103 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_88_in_switchStatement1106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_111_in_caseStatement1133 = new BitSet(new long[]{0x0000000000085110L,0x000007F810000000L,0x0000000000018900L});
    public static final BitSet FOLLOW_logicalExpression_in_caseStatement1135 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_83_in_caseStatement1137 = new BitSet(new long[]{0x0000000000085110L,0x07FC6FF810000000L,0x0000000000018900L});
    public static final BitSet FOLLOW_block_in_caseStatement1139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_112_in_defaultStatement1162 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_83_in_defaultStatement1164 = new BitSet(new long[]{0x0000000000085110L,0x07FC6FF810000000L,0x0000000000018900L});
    public static final BitSet FOLLOW_block_in_defaultStatement1166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_113_in_elseStatement1187 = new BitSet(new long[]{0x0000000000085110L,0x07FC6FF810880000L,0x0000000000018900L});
    public static final BitSet FOLLOW_statementOrStatementBlock_in_elseStatement1190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_114_in_whileStatement1203 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_92_in_whileStatement1205 = new BitSet(new long[]{0x0000000000085110L,0x000007F810000000L,0x0000000000018900L});
    public static final BitSet FOLLOW_logicalExpression_in_whileStatement1207 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_whileStatement1209 = new BitSet(new long[]{0x0000000000085110L,0x07FC6FF810880000L,0x0000000000018900L});
    public static final BitSet FOLLOW_statementOrStatementBlock_in_whileStatement1211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_115_in_returnStatement1233 = new BitSet(new long[]{0x0000000000085110L,0x000007F810040000L,0x0000000000018900L});
    public static final BitSet FOLLOW_logicalExpression_in_returnStatement1235 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_82_in_returnStatement1238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_116_in_throwStatement1259 = new BitSet(new long[]{0x0000000000085110L,0x000007F810040000L,0x0000000000018900L});
    public static final BitSet FOLLOW_logicalExpression_in_throwStatement1261 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_82_in_throwStatement1264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_117_in_deleteStatement1285 = new BitSet(new long[]{0x0000000000085110L,0x000007F810040000L,0x0000000000018900L});
    public static final BitSet FOLLOW_logicalExpression_in_deleteStatement1287 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_82_in_deleteStatement1290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_118_in_breakStatement1314 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_82_in_breakStatement1316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_119_in_breakAllStatement1334 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_82_in_breakAllStatement1336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_120_in_continueStatement1354 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_82_in_continueStatement1356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_121_in_abortStatement1374 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_82_in_abortStatement1376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_122_in_transactionStatement1394 = new BitSet(new long[]{0x0000000000085110L,0x07FC6FF810880000L,0x0000000000018900L});
    public static final BitSet FOLLOW_NAME_in_transactionStatement1397 = new BitSet(new long[]{0x0000000000085110L,0x07FC6FF810980000L,0x0000000000018900L});
    public static final BitSet FOLLOW_84_in_transactionStatement1400 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_transactionStatement1402 = new BitSet(new long[]{0x0000000000085110L,0x07FC6FF810980000L,0x0000000000018900L});
    public static final BitSet FOLLOW_statementOrStatementBlock_in_transactionStatement1408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logicalExpression_in_assignmentStatement1437 = new BitSet(new long[]{0x0000000000000000L,0x1800000000000000L});
    public static final BitSet FOLLOW_123_in_assignmentStatement1442 = new BitSet(new long[]{0x0000000000085110L,0x000007F810000000L,0x0000000000018900L});
    public static final BitSet FOLLOW_124_in_assignmentStatement1449 = new BitSet(new long[]{0x0000000000085110L,0x000007F810000000L,0x0000000000018900L});
    public static final BitSet FOLLOW_logicalExpression_in_assignmentStatement1455 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_82_in_assignmentStatement1457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_postfixExpression_in_expressionStatement1473 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_89_in_expressionStatement1475 = new BitSet(new long[]{0x0000000000085110L,0x000007F810000000L,0x0000000000018900L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionStatement1478 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionStatement1484 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_82_in_expressionStatement1487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_relationalExpression_in_logicalExpression1500 = new BitSet(new long[]{0x0000000000000002L,0xE000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_set_in_logicalExpression1503 = new BitSet(new long[]{0x0000000000085110L,0x000007F810000000L,0x0000000000018900L});
    public static final BitSet FOLLOW_relationalExpression_in_logicalExpression1514 = new BitSet(new long[]{0x0000000000000002L,0xE000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_additiveExpression_in_relationalExpression1531 = new BitSet(new long[]{0x0000000000000002L,0x0000000002000000L,0x000000000000007EL});
    public static final BitSet FOLLOW_129_in_relationalExpression1535 = new BitSet(new long[]{0x0000000000085110L,0x000007F810000000L,0x0000000000018900L});
    public static final BitSet FOLLOW_relationalExpression_in_relationalExpression1538 = new BitSet(new long[]{0x0000000000000002L,0x0000000002000000L,0x000000000000007EL});
    public static final BitSet FOLLOW_89_in_relationalExpression1542 = new BitSet(new long[]{0x0000000000085110L,0x000007F810000000L,0x0000000000018900L});
    public static final BitSet FOLLOW_relationalExpression_in_relationalExpression1545 = new BitSet(new long[]{0x0000000000000002L,0x0000000002000000L,0x000000000000007EL});
    public static final BitSet FOLLOW_set_in_relationalExpression1572 = new BitSet(new long[]{0x0000000000085110L,0x000007F810000000L,0x0000000000018900L});
    public static final BitSet FOLLOW_additiveExpression_in_relationalExpression1585 = new BitSet(new long[]{0x0000000000000002L,0x0000000002000000L,0x000000000000007EL});
    public static final BitSet FOLLOW_multiplicativeExpression_in_additiveExpression1603 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000180L});
    public static final BitSet FOLLOW_set_in_additiveExpression1606 = new BitSet(new long[]{0x0000000000085110L,0x000007F810000000L,0x0000000000018900L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_additiveExpression1613 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000180L});
    public static final BitSet FOLLOW_unaryExpression_in_multiplicativeExpression1634 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000600L});
    public static final BitSet FOLLOW_set_in_multiplicativeExpression1637 = new BitSet(new long[]{0x0000000000085110L,0x000007F810000000L,0x0000000000018900L});
    public static final BitSet FOLLOW_unaryExpression_in_multiplicativeExpression1644 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000600L});
    public static final BitSet FOLLOW_set_in_unaryExpression1662 = new BitSet(new long[]{0x0000000000085110L,0x000007F810000000L,0x0000000000018900L});
    public static final BitSet FOLLOW_postfixExpression_in_unaryExpression1671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_itemSelectorExpression_in_postfixExpression1687 = new BitSet(new long[]{0x0000000000000A02L});
    public static final BitSet FOLLOW_set_in_postfixExpression1690 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_featureCall_in_postfixExpression1699 = new BitSet(new long[]{0x0000000000000A02L,0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_140_in_postfixExpression1706 = new BitSet(new long[]{0x0000000000085110L,0x000007F810000000L,0x0000000000018900L});
    public static final BitSet FOLLOW_logicalExpression_in_postfixExpression1709 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_141_in_postfixExpression1711 = new BitSet(new long[]{0x0000000000000A02L,0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_primitiveExpression_in_itemSelectorExpression1748 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_140_in_itemSelectorExpression1751 = new BitSet(new long[]{0x0000000000085110L,0x000007F810000000L,0x0000000000018900L});
    public static final BitSet FOLLOW_primitiveExpression_in_itemSelectorExpression1754 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_141_in_itemSelectorExpression1756 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_simpleFeatureCall_in_featureCall1775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declarativeFeatureCall_in_featureCall1779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_simpleFeatureCall1791 = new BitSet(new long[]{0x0000000000000002L,0x0000000010000000L});
    public static final BitSet FOLLOW_parameterList_in_simpleFeatureCall1794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_92_in_parameterList1809 = new BitSet(new long[]{0x0000000000085110L,0x000007F830000000L,0x0000000000018900L});
    public static final BitSet FOLLOW_logicalExpression_in_parameterList1812 = new BitSet(new long[]{0x0000000000000000L,0x0000000020100000L});
    public static final BitSet FOLLOW_84_in_parameterList1815 = new BitSet(new long[]{0x0000000000085110L,0x000007F810000000L,0x0000000000018900L});
    public static final BitSet FOLLOW_logicalExpression_in_parameterList1817 = new BitSet(new long[]{0x0000000000000000L,0x0000000020100000L});
    public static final BitSet FOLLOW_93_in_parameterList1823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_declarativeFeatureCall1845 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_92_in_declarativeFeatureCall1848 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_formalParameterList_in_declarativeFeatureCall1851 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_142_in_declarativeFeatureCall1853 = new BitSet(new long[]{0x0000000000085110L,0x000007F810000000L,0x0000000000018900L});
    public static final BitSet FOLLOW_logicalExpression_in_declarativeFeatureCall1856 = new BitSet(new long[]{0x0000000000000000L,0x0000000020100000L});
    public static final BitSet FOLLOW_84_in_declarativeFeatureCall1859 = new BitSet(new long[]{0x0000000000085110L,0x000007F810000000L,0x0000000000018900L});
    public static final BitSet FOLLOW_logicalExpression_in_declarativeFeatureCall1862 = new BitSet(new long[]{0x0000000000000000L,0x0000000020100000L});
    public static final BitSet FOLLOW_93_in_declarativeFeatureCall1866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_143_in_newExpression1878 = new BitSet(new long[]{0x0000000000080000L,0x000007F800000000L});
    public static final BitSet FOLLOW_typeName_in_newExpression1883 = new BitSet(new long[]{0x0000000000000002L,0x0000000010000000L});
    public static final BitSet FOLLOW_parameterList_in_newExpression1887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_144_in_variableDeclarationExpression1912 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_variableDeclarationExpression1914 = new BitSet(new long[]{0x0000000000000002L,0x0000000000080000L});
    public static final BitSet FOLLOW_83_in_variableDeclarationExpression1917 = new BitSet(new long[]{0x0000000000080000L,0x000007F800000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_143_in_variableDeclarationExpression1921 = new BitSet(new long[]{0x0000000000080000L,0x000007F800000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_typeName_in_variableDeclarationExpression1926 = new BitSet(new long[]{0x0000000000000002L,0x0000000010000000L});
    public static final BitSet FOLLOW_parameterList_in_variableDeclarationExpression1930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_literalSequentialCollection1960 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_87_in_literalSequentialCollection1975 = new BitSet(new long[]{0x0000000000085110L,0x000007F811000000L,0x0000000000018900L});
    public static final BitSet FOLLOW_expressionListOrRange_in_literalSequentialCollection1979 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_88_in_literalSequentialCollection1982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionRange1997 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_POINT_POINT_in_expressionRange1999 = new BitSet(new long[]{0x0000000000085110L,0x000007F810000000L,0x0000000000018900L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionRange2001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionList2023 = new BitSet(new long[]{0x0000000000000002L,0x0000000000100000L});
    public static final BitSet FOLLOW_84_in_expressionList2026 = new BitSet(new long[]{0x0000000000085110L,0x000007F810000000L,0x0000000000018900L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionList2028 = new BitSet(new long[]{0x0000000000000002L,0x0000000000100000L});
    public static final BitSet FOLLOW_expressionRange_in_expressionListOrRange2052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionList_in_expressionListOrRange2056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_106_in_literalMapCollection2075 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_87_in_literalMapCollection2078 = new BitSet(new long[]{0x0000000000085110L,0x000007F811000000L,0x0000000000018900L});
    public static final BitSet FOLLOW_keyvalExpressionList_in_literalMapCollection2081 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_88_in_literalMapCollection2084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_keyvalExpression_in_keyvalExpressionList2099 = new BitSet(new long[]{0x0000000000000002L,0x0000000000100000L});
    public static final BitSet FOLLOW_84_in_keyvalExpressionList2102 = new BitSet(new long[]{0x0000000000085110L,0x000007F810000000L,0x0000000000018900L});
    public static final BitSet FOLLOW_keyvalExpression_in_keyvalExpressionList2104 = new BitSet(new long[]{0x0000000000000002L,0x0000000000100000L});
    public static final BitSet FOLLOW_additiveExpression_in_keyvalExpression2129 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_89_in_keyvalExpression2131 = new BitSet(new long[]{0x0000000000085110L,0x000007F810000000L,0x0000000000018900L});
    public static final BitSet FOLLOW_logicalExpression_in_keyvalExpression2133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literalSequentialCollection_in_primitiveExpression2155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literalMapCollection_in_primitiveExpression2159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_primitiveExpression2163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_featureCall_in_primitiveExpression2167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pathName_in_primitiveExpression2171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nativeType_in_primitiveExpression2175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectionType_in_primitiveExpression2181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_92_in_primitiveExpression2186 = new BitSet(new long[]{0x0000000000085110L,0x000007F810000000L,0x0000000000018900L});
    public static final BitSet FOLLOW_logicalExpression_in_primitiveExpression2189 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_primitiveExpression2191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_newExpression_in_primitiveExpression2199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variableDeclarationExpression_in_primitiveExpression2203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_literal0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_92_in_synpred29_EolParserRules860 = new BitSet(new long[]{0x0000000000080000L,0x000007F800000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_typeName_in_synpred29_EolParserRules865 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_synpred29_EolParserRules868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementA_in_synpred30_EolParserRules891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignmentStatement_in_synpred31_EolParserRules905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionStatement_in_synpred32_EolParserRules909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_elseStatement_in_synpred46_EolParserRules1063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_synpred53_EolParserRules1397 = new BitSet(new long[]{0x0000000000000002L,0x0000000000100000L});
    public static final BitSet FOLLOW_84_in_synpred53_EolParserRules1400 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_synpred53_EolParserRules1402 = new BitSet(new long[]{0x0000000000000002L,0x0000000000100000L});
    public static final BitSet FOLLOW_postfixExpression_in_synpred55_EolParserRules1473 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_89_in_synpred55_EolParserRules1475 = new BitSet(new long[]{0x0000000000085110L,0x000007F810000000L,0x0000000000018900L});
    public static final BitSet FOLLOW_logicalExpression_in_synpred55_EolParserRules1478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_129_in_synpred66_EolParserRules1535 = new BitSet(new long[]{0x0000000000085110L,0x000007F810000000L,0x0000000000018900L});
    public static final BitSet FOLLOW_relationalExpression_in_synpred66_EolParserRules1538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_89_in_synpred66_EolParserRules1542 = new BitSet(new long[]{0x0000000000085110L,0x000007F810000000L,0x0000000000018900L});
    public static final BitSet FOLLOW_relationalExpression_in_synpred66_EolParserRules1545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred66_EolParserRules1572 = new BitSet(new long[]{0x0000000000085110L,0x000007F810000000L,0x0000000000018900L});
    public static final BitSet FOLLOW_additiveExpression_in_synpred66_EolParserRules1585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_83_in_synpred85_EolParserRules1917 = new BitSet(new long[]{0x0000000000080000L,0x000007F800000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_143_in_synpred85_EolParserRules1921 = new BitSet(new long[]{0x0000000000080000L,0x000007F800000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_typeName_in_synpred85_EolParserRules1926 = new BitSet(new long[]{0x0000000000000002L,0x0000000010000000L});
    public static final BitSet FOLLOW_parameterList_in_synpred85_EolParserRules1930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionRange_in_synpred93_EolParserRules2052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literalSequentialCollection_in_synpred96_EolParserRules2155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literalMapCollection_in_synpred97_EolParserRules2159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_featureCall_in_synpred99_EolParserRules2167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pathName_in_synpred100_EolParserRules2171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectionType_in_synpred102_EolParserRules2181 = new BitSet(new long[]{0x0000000000000002L});

}
