package org.eclipse.epsilon.eml.parse;

// $ANTLR 3.1b1 EolParserRules.g 2013-03-28 19:40:50

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
public class Eml_EolParserRules extends org.eclipse.epsilon.common.parse.EpsilonParser {
    public static final int EXPONENT=6;
    public static final int WHILE=33;
    public static final int StatementBlock=29;
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
    public static final int NAME=19;
    public static final int T__92=92;
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
    public static final int T__154=154;
    public static final int T__155=155;
    public static final int T__156=156;
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
    public static final int T__153=153;
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
    public static final int JavaIDDigit=18;
    public static final int GUARD=79;
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
    public static final int EMLMODULE=82;
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
    public static final int TRANSFORM=80;
    public static final int T__124=124;
    public static final int T__123=123;
    public static final int FOR=30;
    public static final int T__122=122;
    public static final int ENUMERATION_VALUE=64;
    public static final int T__121=121;
    public static final int PRE=76;
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
    public static final int MERGE=81;
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
    public static final int POST=77;
    public static final int ARROW=11;
    public static final int ASSIGNMENT=26;
    public static final int EXTENDS=78;
    public static final int STRING=14;

    // delegates
    // delegators
    public EmlParser gEml;


        public Eml_EolParserRules(TokenStream input, EmlParser gEml) {
            this(input, new RecognizerSharedState(), gEml);
        }
        public Eml_EolParserRules(TokenStream input, RecognizerSharedState state, EmlParser gEml) {
            super(input, state);
            this.gEml = gEml;
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return EmlParser.tokenNames; }
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
    public final Eml_EolParserRules.operationDeclarationOrAnnotationBlock_return operationDeclarationOrAnnotationBlock() throws RecognitionException {
        Eml_EolParserRules.operationDeclarationOrAnnotationBlock_return retval = new Eml_EolParserRules.operationDeclarationOrAnnotationBlock_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Eml_EolParserRules.operationDeclaration_return operationDeclaration1 = null;

        Eml_EolParserRules.annotationBlock_return annotationBlock2 = null;



        try {
            // EolParserRules.g:105:2: ( operationDeclaration | annotationBlock )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( ((LA1_0>=92 && LA1_0<=93)) ) {
                alt1=1;
            }
            else if ( (LA1_0==Annotation||LA1_0==97) ) {
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
    public final Eml_EolParserRules.modelDeclaration_return modelDeclaration() throws RecognitionException {
        Eml_EolParserRules.modelDeclaration_return retval = new Eml_EolParserRules.modelDeclaration_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal3=null;
        Token NAME4=null;
        Token char_literal8=null;
        Eml_EolParserRules.modelAlias_return modelAlias5 = null;

        Eml_EolParserRules.modelDriver_return modelDriver6 = null;

        Eml_EolParserRules.modelDeclarationParameters_return modelDeclarationParameters7 = null;


        CommonTree string_literal3_tree=null;
        CommonTree NAME4_tree=null;
        CommonTree char_literal8_tree=null;
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_83=new RewriteRuleTokenStream(adaptor,"token 83");
        RewriteRuleTokenStream stream_84=new RewriteRuleTokenStream(adaptor,"token 84");
        RewriteRuleSubtreeStream stream_modelDeclarationParameters=new RewriteRuleSubtreeStream(adaptor,"rule modelDeclarationParameters");
        RewriteRuleSubtreeStream stream_modelAlias=new RewriteRuleSubtreeStream(adaptor,"rule modelAlias");
        RewriteRuleSubtreeStream stream_modelDriver=new RewriteRuleSubtreeStream(adaptor,"rule modelDriver");
        try {
            // EolParserRules.g:109:2: ( 'model' NAME ( modelAlias )? ( modelDriver )? ( modelDeclarationParameters )? ';' -> ^( MODELDECLARATION NAME ( modelAlias )? ( modelDriver )? ( modelDeclarationParameters )? ) )
            // EolParserRules.g:109:4: 'model' NAME ( modelAlias )? ( modelDriver )? ( modelDeclarationParameters )? ';'
            {
            string_literal3=(Token)match(input,83,FOLLOW_83_in_modelDeclaration259); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_83.add(string_literal3);

            NAME4=(Token)match(input,NAME,FOLLOW_NAME_in_modelDeclaration261); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(NAME4);

            // EolParserRules.g:109:17: ( modelAlias )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==87) ) {
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

            if ( (LA3_0==88) ) {
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

            if ( (LA4_0==89) ) {
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

            char_literal8=(Token)match(input,84,FOLLOW_84_in_modelDeclaration272); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_84.add(char_literal8);



            // AST REWRITE
            // elements: modelDeclarationParameters, NAME, modelDriver, modelAlias
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
    public final Eml_EolParserRules.modelNamespace_return modelNamespace() throws RecognitionException {
        Eml_EolParserRules.modelNamespace_return retval = new Eml_EolParserRules.modelNamespace_return();
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
        RewriteRuleTokenStream stream_86=new RewriteRuleTokenStream(adaptor,"token 86");
        RewriteRuleTokenStream stream_85=new RewriteRuleTokenStream(adaptor,"token 85");

        try {
            // EolParserRules.g:114:2: ( ':' NAME ( ',' NAME )* -> ^( NAMESPACE ( NAME )* ) )
            // EolParserRules.g:114:6: ':' NAME ( ',' NAME )*
            {
            char_literal9=(Token)match(input,85,FOLLOW_85_in_modelNamespace310); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_85.add(char_literal9);

            NAME10=(Token)match(input,NAME,FOLLOW_NAME_in_modelNamespace312); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(NAME10);

            // EolParserRules.g:114:15: ( ',' NAME )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==86) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // EolParserRules.g:114:16: ',' NAME
            	    {
            	    char_literal11=(Token)match(input,86,FOLLOW_86_in_modelNamespace315); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_86.add(char_literal11);

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
    public final Eml_EolParserRules.modelAlias_return modelAlias() throws RecognitionException {
        Eml_EolParserRules.modelAlias_return retval = new Eml_EolParserRules.modelAlias_return();
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
        RewriteRuleTokenStream stream_86=new RewriteRuleTokenStream(adaptor,"token 86");
        RewriteRuleTokenStream stream_87=new RewriteRuleTokenStream(adaptor,"token 87");

        try {
            // EolParserRules.g:119:2: ( 'alias' NAME ( ',' NAME )* -> ^( ALIAS ( NAME )* ) )
            // EolParserRules.g:119:5: 'alias' NAME ( ',' NAME )*
            {
            string_literal13=(Token)match(input,87,FOLLOW_87_in_modelAlias341); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_87.add(string_literal13);

            NAME14=(Token)match(input,NAME,FOLLOW_NAME_in_modelAlias343); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(NAME14);

            // EolParserRules.g:119:18: ( ',' NAME )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==86) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // EolParserRules.g:119:19: ',' NAME
            	    {
            	    char_literal15=(Token)match(input,86,FOLLOW_86_in_modelAlias346); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_86.add(char_literal15);

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
    public final Eml_EolParserRules.modelDriver_return modelDriver() throws RecognitionException {
        Eml_EolParserRules.modelDriver_return retval = new Eml_EolParserRules.modelDriver_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal17=null;
        Token NAME18=null;

        CommonTree string_literal17_tree=null;
        CommonTree NAME18_tree=null;
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_88=new RewriteRuleTokenStream(adaptor,"token 88");

        try {
            // EolParserRules.g:124:2: ( 'driver' NAME -> ^( DRIVER NAME ) )
            // EolParserRules.g:124:5: 'driver' NAME
            {
            string_literal17=(Token)match(input,88,FOLLOW_88_in_modelDriver372); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_88.add(string_literal17);

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
    public final Eml_EolParserRules.modelDeclarationParameters_return modelDeclarationParameters() throws RecognitionException {
        Eml_EolParserRules.modelDeclarationParameters_return retval = new Eml_EolParserRules.modelDeclarationParameters_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal19=null;
        Token char_literal21=null;
        Token char_literal23=null;
        Eml_EolParserRules.modelDeclarationParameter_return modelDeclarationParameter20 = null;

        Eml_EolParserRules.modelDeclarationParameter_return modelDeclarationParameter22 = null;


        CommonTree char_literal19_tree=null;
        CommonTree char_literal21_tree=null;
        CommonTree char_literal23_tree=null;
        RewriteRuleTokenStream stream_90=new RewriteRuleTokenStream(adaptor,"token 90");
        RewriteRuleTokenStream stream_86=new RewriteRuleTokenStream(adaptor,"token 86");
        RewriteRuleTokenStream stream_89=new RewriteRuleTokenStream(adaptor,"token 89");
        RewriteRuleSubtreeStream stream_modelDeclarationParameter=new RewriteRuleSubtreeStream(adaptor,"rule modelDeclarationParameter");
        try {
            // EolParserRules.g:129:2: ( '{' ( modelDeclarationParameter )? ( ',' modelDeclarationParameter )* '}' -> ^( MODELDECLARATIONPARAMETERS ( modelDeclarationParameter )* ) )
            // EolParserRules.g:129:4: '{' ( modelDeclarationParameter )? ( ',' modelDeclarationParameter )* '}'
            {
            char_literal19=(Token)match(input,89,FOLLOW_89_in_modelDeclarationParameters394); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_89.add(char_literal19);

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

                if ( (LA8_0==86) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // EolParserRules.g:129:36: ',' modelDeclarationParameter
            	    {
            	    char_literal21=(Token)match(input,86,FOLLOW_86_in_modelDeclarationParameters400); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_86.add(char_literal21);

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

            char_literal23=(Token)match(input,90,FOLLOW_90_in_modelDeclarationParameters406); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_90.add(char_literal23);



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
    public final Eml_EolParserRules.modelDeclarationParameter_return modelDeclarationParameter() throws RecognitionException {
        Eml_EolParserRules.modelDeclarationParameter_return retval = new Eml_EolParserRules.modelDeclarationParameter_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NAME24=null;
        Token char_literal25=null;
        Token STRING26=null;

        CommonTree NAME24_tree=null;
        CommonTree char_literal25_tree=null;
        CommonTree STRING26_tree=null;
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_91=new RewriteRuleTokenStream(adaptor,"token 91");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");

        try {
            // EolParserRules.g:134:2: ( NAME '=' STRING -> ^( MODELDECLARATIONPARAMETER NAME STRING ) )
            // EolParserRules.g:134:4: NAME '=' STRING
            {
            NAME24=(Token)match(input,NAME,FOLLOW_NAME_in_modelDeclarationParameter430); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(NAME24);

            char_literal25=(Token)match(input,91,FOLLOW_91_in_modelDeclarationParameter432); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_91.add(char_literal25);

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
    public final Eml_EolParserRules.operationDeclaration_return operationDeclaration() throws RecognitionException {
        Eml_EolParserRules.operationDeclaration_return retval = new Eml_EolParserRules.operationDeclaration_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token operationName=null;
        Token string_literal27=null;
        Token string_literal28=null;
        Token char_literal29=null;
        Token char_literal31=null;
        Token char_literal32=null;
        Eml_EolParserRules.typeName_return ctx = null;

        Eml_EolParserRules.typeName_return returnType = null;

        Eml_EolParserRules.formalParameterList_return formalParameterList30 = null;

        Eml_EolParserRules.statementBlock_return statementBlock33 = null;


        CommonTree operationName_tree=null;
        CommonTree string_literal27_tree=null;
        CommonTree string_literal28_tree=null;
        CommonTree char_literal29_tree=null;
        CommonTree char_literal31_tree=null;
        CommonTree char_literal32_tree=null;
        RewriteRuleTokenStream stream_95=new RewriteRuleTokenStream(adaptor,"token 95");
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_94=new RewriteRuleTokenStream(adaptor,"token 94");
        RewriteRuleTokenStream stream_93=new RewriteRuleTokenStream(adaptor,"token 93");
        RewriteRuleTokenStream stream_92=new RewriteRuleTokenStream(adaptor,"token 92");
        RewriteRuleTokenStream stream_85=new RewriteRuleTokenStream(adaptor,"token 85");
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

            if ( (LA9_0==92) ) {
                alt9=1;
            }
            else if ( (LA9_0==93) ) {
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
                    string_literal27=(Token)match(input,92,FOLLOW_92_in_operationDeclaration460); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_92.add(string_literal27);


                    }
                    break;
                case 2 :
                    // EolParserRules.g:140:17: 'function'
                    {
                    string_literal28=(Token)match(input,93,FOLLOW_93_in_operationDeclaration462); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_93.add(string_literal28);


                    }
                    break;

            }

            // EolParserRules.g:140:29: (ctx= typeName )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==NAME) ) {
                int LA10_1 = input.LA(2);

                if ( (LA10_1==NAME||(LA10_1>=98 && LA10_1<=100)) ) {
                    alt10=1;
                }
            }
            else if ( ((LA10_0>=101 && LA10_0<=108)) ) {
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

            char_literal29=(Token)match(input,94,FOLLOW_94_in_operationDeclaration478); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_94.add(char_literal29);

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

            char_literal31=(Token)match(input,95,FOLLOW_95_in_operationDeclaration483); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_95.add(char_literal31);

            // EolParserRules.g:140:119: ( ':' returnType= typeName )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==85) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // EolParserRules.g:140:120: ':' returnType= typeName
                    {
                    char_literal32=(Token)match(input,85,FOLLOW_85_in_operationDeclaration486); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_85.add(char_literal32);

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
            // elements: statementBlock, returnType, formalParameterList, operationName, ctx
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
    public final Eml_EolParserRules.importStatement_return importStatement() throws RecognitionException {
        Eml_EolParserRules.importStatement_return retval = new Eml_EolParserRules.importStatement_return();
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

            i=(Token)match(input,96,FOLLOW_96_in_importStatement533); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            i_tree = (CommonTree)adaptor.create(i);
            root_0 = (CommonTree)adaptor.becomeRoot(i_tree, root_0);
            }
            STRING34=(Token)match(input,STRING,FOLLOW_STRING_in_importStatement536); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STRING34_tree = (CommonTree)adaptor.create(STRING34);
            adaptor.addChild(root_0, STRING34_tree);
            }
            char_literal35=(Token)match(input,84,FOLLOW_84_in_importStatement538); if (state.failed) return retval;
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
    public final Eml_EolParserRules.block_return block() throws RecognitionException {
        Eml_EolParserRules.block_return retval = new Eml_EolParserRules.block_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Eml_EolParserRules.statement_return statement36 = null;


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

                if ( (LA13_0==FLOAT||LA13_0==INT||LA13_0==BOOLEAN||LA13_0==STRING||LA13_0==NAME||LA13_0==94||(LA13_0>=101 && LA13_0<=109)||(LA13_0>=111 && LA13_0<=112)||(LA13_0>=116 && LA13_0<=124)||LA13_0==138||LA13_0==141||(LA13_0>=145 && LA13_0<=146)) ) {
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
    public final Eml_EolParserRules.statementBlock_return statementBlock() throws RecognitionException {
        Eml_EolParserRules.statementBlock_return retval = new Eml_EolParserRules.statementBlock_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal37=null;
        Token char_literal39=null;
        Eml_EolParserRules.block_return block38 = null;


        CommonTree char_literal37_tree=null;
        CommonTree char_literal39_tree=null;

        try {
            // EolParserRules.g:155:2: ( '{' block '}' )
            // EolParserRules.g:155:4: '{' block '}'
            {
            root_0 = (CommonTree)adaptor.nil();

            char_literal37=(Token)match(input,89,FOLLOW_89_in_statementBlock575); if (state.failed) return retval;
            pushFollow(FOLLOW_block_in_statementBlock578);
            block38=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, block38.getTree());
            char_literal39=(Token)match(input,90,FOLLOW_90_in_statementBlock580); if (state.failed) return retval;

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
    public final Eml_EolParserRules.formalParameter_return formalParameter() throws RecognitionException {
        Eml_EolParserRules.formalParameter_return retval = new Eml_EolParserRules.formalParameter_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NAME40=null;
        Token char_literal41=null;
        Eml_EolParserRules.typeName_return pt = null;


        CommonTree NAME40_tree=null;
        CommonTree char_literal41_tree=null;
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_85=new RewriteRuleTokenStream(adaptor,"token 85");
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

            if ( (LA14_0==85) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // EolParserRules.g:159:10: ':' pt= typeName
                    {
                    char_literal41=(Token)match(input,85,FOLLOW_85_in_formalParameter595); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_85.add(char_literal41);

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
    public final Eml_EolParserRules.formalParameterList_return formalParameterList() throws RecognitionException {
        Eml_EolParserRules.formalParameterList_return retval = new Eml_EolParserRules.formalParameterList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal43=null;
        Eml_EolParserRules.formalParameter_return formalParameter42 = null;

        Eml_EolParserRules.formalParameter_return formalParameter44 = null;


        CommonTree char_literal43_tree=null;
        RewriteRuleTokenStream stream_86=new RewriteRuleTokenStream(adaptor,"token 86");
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

                if ( (LA15_0==86) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // EolParserRules.g:164:21: ',' formalParameter
            	    {
            	    char_literal43=(Token)match(input,86,FOLLOW_86_in_formalParameterList631); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_86.add(char_literal43);

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
    // EolParserRules.g:168:1: executableAnnotation : '$' NAME logicalExpression -> ^( EXECUTABLEANNOTATION NAME logicalExpression ) ;
    public final Eml_EolParserRules.executableAnnotation_return executableAnnotation() throws RecognitionException {
        Eml_EolParserRules.executableAnnotation_return retval = new Eml_EolParserRules.executableAnnotation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal45=null;
        Token NAME46=null;
        Eml_EolParserRules.logicalExpression_return logicalExpression47 = null;


        CommonTree char_literal45_tree=null;
        CommonTree NAME46_tree=null;
        RewriteRuleTokenStream stream_97=new RewriteRuleTokenStream(adaptor,"token 97");
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:169:2: ( '$' NAME logicalExpression -> ^( EXECUTABLEANNOTATION NAME logicalExpression ) )
            // EolParserRules.g:169:4: '$' NAME logicalExpression
            {
            char_literal45=(Token)match(input,97,FOLLOW_97_in_executableAnnotation656); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_97.add(char_literal45);

            NAME46=(Token)match(input,NAME,FOLLOW_NAME_in_executableAnnotation658); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(NAME46);

            pushFollow(FOLLOW_logicalExpression_in_executableAnnotation660);
            logicalExpression47=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression47.getTree());


            // AST REWRITE
            // elements: logicalExpression, NAME
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 170:2: -> ^( EXECUTABLEANNOTATION NAME logicalExpression )
            {
                // EolParserRules.g:170:5: ^( EXECUTABLEANNOTATION NAME logicalExpression )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(EXECUTABLEANNOTATION, "EXECUTABLEANNOTATION"), root_1);

                adaptor.addChild(root_1, stream_NAME.nextNode());
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
    public final Eml_EolParserRules.annotation_return annotation() throws RecognitionException {
        Eml_EolParserRules.annotation_return retval = new Eml_EolParserRules.annotation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token Annotation48=null;
        Eml_EolParserRules.executableAnnotation_return executableAnnotation49 = null;


        CommonTree Annotation48_tree=null;

        try {
            // EolParserRules.g:174:2: ( Annotation | executableAnnotation )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==Annotation) ) {
                alt16=1;
            }
            else if ( (LA16_0==97) ) {
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

                    Annotation48=(Token)match(input,Annotation,FOLLOW_Annotation_in_annotation682); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    Annotation48_tree = (CommonTree)adaptor.create(Annotation48);
                    adaptor.addChild(root_0, Annotation48_tree);
                    }

                    }
                    break;
                case 2 :
                    // EolParserRules.g:174:15: executableAnnotation
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_executableAnnotation_in_annotation684);
                    executableAnnotation49=executableAnnotation();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, executableAnnotation49.getTree());

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
    public final Eml_EolParserRules.annotationBlock_return annotationBlock() throws RecognitionException {
        Eml_EolParserRules.annotationBlock_return retval = new Eml_EolParserRules.annotationBlock_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Eml_EolParserRules.annotation_return annotation50 = null;


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

                if ( (LA17_0==Annotation) ) {
                    int LA17_2 = input.LA(2);

                    if ( (synpred17_EolParserRules()) ) {
                        alt17=1;
                    }


                }
                else if ( (LA17_0==97) ) {
                    int LA17_3 = input.LA(2);

                    if ( (synpred17_EolParserRules()) ) {
                        alt17=1;
                    }


                }


                switch (alt17) {
            	case 1 :
            	    // EolParserRules.g:0:0: annotation
            	    {
            	    pushFollow(FOLLOW_annotation_in_annotationBlock695);
            	    annotation50=annotation();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_annotation.add(annotation50.getTree());

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
    public final Eml_EolParserRules.typeName_return typeName() throws RecognitionException {
        Eml_EolParserRules.typeName_return retval = new Eml_EolParserRules.typeName_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Eml_EolParserRules.pathName_return pathName51 = null;

        Eml_EolParserRules.nativeType_return nativeType52 = null;

        Eml_EolParserRules.collectionType_return collectionType53 = null;



        try {
            // EolParserRules.g:183:2: ( pathName | nativeType | collectionType )
            int alt18=3;
            switch ( input.LA(1) ) {
            case NAME:
                {
                alt18=1;
                }
                break;
            case 101:
                {
                alt18=2;
                }
                break;
            case 102:
            case 103:
            case 104:
            case 105:
            case 106:
            case 107:
            case 108:
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

                    pushFollow(FOLLOW_pathName_in_typeName718);
                    pathName51=pathName();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pathName51.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:183:15: nativeType
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_nativeType_in_typeName722);
                    nativeType52=nativeType();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nativeType52.getTree());

                    }
                    break;
                case 3 :
                    // EolParserRules.g:183:28: collectionType
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_collectionType_in_typeName726);
                    collectionType53=collectionType();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, collectionType53.getTree());
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
    public final Eml_EolParserRules.pathName_return pathName() throws RecognitionException {
        Eml_EolParserRules.pathName_return retval = new Eml_EolParserRules.pathName_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token metamodel=null;
        Token label=null;
        Token char_literal54=null;
        Token char_literal55=null;
        Eml_EolParserRules.packagedType_return head = null;


        CommonTree metamodel_tree=null;
        CommonTree label_tree=null;
        CommonTree char_literal54_tree=null;
        CommonTree char_literal55_tree=null;

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

                if ( (LA19_1==98) ) {
                    alt19=1;
                }
            }
            switch (alt19) {
                case 1 :
                    // EolParserRules.g:188:5: metamodel= NAME '!'
                    {
                    metamodel=(Token)match(input,NAME,FOLLOW_NAME_in_pathName743); if (state.failed) return retval;
                    char_literal54=(Token)match(input,98,FOLLOW_98_in_pathName746); if (state.failed) return retval;

                    }
                    break;

            }

            pushFollow(FOLLOW_packagedType_in_pathName755);
            head=packagedType();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, head.getTree());
            // EolParserRules.g:190:3: ( '#' label= NAME )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==99) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // EolParserRules.g:190:4: '#' label= NAME
                    {
                    char_literal55=(Token)match(input,99,FOLLOW_99_in_pathName760); if (state.failed) return retval;
                    label=(Token)match(input,NAME,FOLLOW_NAME_in_pathName765); if (state.failed) return retval;

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
    public final Eml_EolParserRules.packagedType_return packagedType() throws RecognitionException {
        Eml_EolParserRules.packagedType_return retval = new Eml_EolParserRules.packagedType_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token head=null;
        Token field=null;
        Token string_literal56=null;

        CommonTree head_tree=null;
        CommonTree field_tree=null;
        CommonTree string_literal56_tree=null;

        try {
            // EolParserRules.g:206:2: (head= NAME ( '::' field= NAME )* )
            // EolParserRules.g:206:4: head= NAME ( '::' field= NAME )*
            {
            root_0 = (CommonTree)adaptor.nil();

            head=(Token)match(input,NAME,FOLLOW_NAME_in_packagedType787); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            head_tree = (CommonTree)adaptor.create(head);
            adaptor.addChild(root_0, head_tree);
            }
            // EolParserRules.g:206:14: ( '::' field= NAME )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==100) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // EolParserRules.g:206:15: '::' field= NAME
            	    {
            	    string_literal56=(Token)match(input,100,FOLLOW_100_in_packagedType790); if (state.failed) return retval;
            	    field=(Token)match(input,NAME,FOLLOW_NAME_in_packagedType795); if (state.failed) return retval;
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
    public final Eml_EolParserRules.nativeType_return nativeType() throws RecognitionException {
        Eml_EolParserRules.nativeType_return retval = new Eml_EolParserRules.nativeType_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal57=null;
        Token char_literal58=null;
        Token STRING59=null;
        Token char_literal60=null;

        CommonTree string_literal57_tree=null;
        CommonTree char_literal58_tree=null;
        CommonTree STRING59_tree=null;
        CommonTree char_literal60_tree=null;

        try {
            // EolParserRules.g:210:2: ( 'Native' '(' STRING ')' )
            // EolParserRules.g:210:4: 'Native' '(' STRING ')'
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal57=(Token)match(input,101,FOLLOW_101_in_nativeType811); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal57_tree = (CommonTree)adaptor.create(string_literal57);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal57_tree, root_0);
            }
            char_literal58=(Token)match(input,94,FOLLOW_94_in_nativeType814); if (state.failed) return retval;
            STRING59=(Token)match(input,STRING,FOLLOW_STRING_in_nativeType817); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STRING59_tree = (CommonTree)adaptor.create(STRING59);
            adaptor.addChild(root_0, STRING59_tree);
            }
            char_literal60=(Token)match(input,95,FOLLOW_95_in_nativeType819); if (state.failed) return retval;
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
    public final Eml_EolParserRules.collectionType_return collectionType() throws RecognitionException {
        Eml_EolParserRules.collectionType_return retval = new Eml_EolParserRules.collectionType_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set61=null;
        Token char_literal62=null;
        Token char_literal63=null;
        Eml_EolParserRules.typeName_return tn = null;


        CommonTree set61_tree=null;
        CommonTree char_literal62_tree=null;
        CommonTree char_literal63_tree=null;

        try {
            // EolParserRules.g:216:2: ( ( 'Collection' | 'Sequence' | 'List' | 'Bag' | 'Set' | 'OrderedSet' | 'Map' ) ( '(' tn= typeName ')' )? )
            // EolParserRules.g:216:5: ( 'Collection' | 'Sequence' | 'List' | 'Bag' | 'Set' | 'OrderedSet' | 'Map' ) ( '(' tn= typeName ')' )?
            {
            root_0 = (CommonTree)adaptor.nil();

            set61=(Token)input.LT(1);
            set61=(Token)input.LT(1);
            if ( (input.LA(1)>=102 && input.LA(1)<=108) ) {
                input.consume();
                if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(set61), root_0);
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
                    char_literal62=(Token)match(input,94,FOLLOW_94_in_collectionType857); if (state.failed) return retval;
                    pushFollow(FOLLOW_typeName_in_collectionType862);
                    tn=typeName();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, tn.getTree());
                    if ( state.backtracking==0 ) {
                      setTokenType(tn,TYPE);
                    }
                    char_literal63=(Token)match(input,95,FOLLOW_95_in_collectionType865); if (state.failed) return retval;

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
    public final Eml_EolParserRules.statement_return statement() throws RecognitionException {
        Eml_EolParserRules.statement_return retval = new Eml_EolParserRules.statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Eml_EolParserRules.statementA_return statementA64 = null;

        Eml_EolParserRules.statementB_return statementB65 = null;



        try {
            // EolParserRules.g:224:2: ( statementA | statementB )
            int alt23=2;
            alt23 = dfa23.predict(input);
            switch (alt23) {
                case 1 :
                    // EolParserRules.g:224:4: statementA
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_statementA_in_statement888);
                    statementA64=statementA();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statementA64.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:224:17: statementB
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_statementB_in_statement892);
                    statementB65=statementB();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statementB65.getTree());

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
    public final Eml_EolParserRules.statementA_return statementA() throws RecognitionException {
        Eml_EolParserRules.statementA_return retval = new Eml_EolParserRules.statementA_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Eml_EolParserRules.assignmentStatement_return assignmentStatement66 = null;

        Eml_EolParserRules.expressionStatement_return expressionStatement67 = null;

        Eml_EolParserRules.forStatement_return forStatement68 = null;

        Eml_EolParserRules.ifStatement_return ifStatement69 = null;

        Eml_EolParserRules.whileStatement_return whileStatement70 = null;

        Eml_EolParserRules.switchStatement_return switchStatement71 = null;

        Eml_EolParserRules.returnStatement_return returnStatement72 = null;

        Eml_EolParserRules.breakStatement_return breakStatement73 = null;



        try {
            // EolParserRules.g:228:2: ( assignmentStatement | expressionStatement | forStatement | ifStatement | whileStatement | switchStatement | returnStatement | breakStatement )
            int alt24=8;
            alt24 = dfa24.predict(input);
            switch (alt24) {
                case 1 :
                    // EolParserRules.g:228:3: assignmentStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_assignmentStatement_in_statementA902);
                    assignmentStatement66=assignmentStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, assignmentStatement66.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:228:25: expressionStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_expressionStatement_in_statementA906);
                    expressionStatement67=expressionStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionStatement67.getTree());

                    }
                    break;
                case 3 :
                    // EolParserRules.g:228:47: forStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_forStatement_in_statementA910);
                    forStatement68=forStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, forStatement68.getTree());

                    }
                    break;
                case 4 :
                    // EolParserRules.g:229:5: ifStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_ifStatement_in_statementA916);
                    ifStatement69=ifStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, ifStatement69.getTree());

                    }
                    break;
                case 5 :
                    // EolParserRules.g:229:19: whileStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_whileStatement_in_statementA920);
                    whileStatement70=whileStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, whileStatement70.getTree());

                    }
                    break;
                case 6 :
                    // EolParserRules.g:229:36: switchStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_switchStatement_in_statementA924);
                    switchStatement71=switchStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, switchStatement71.getTree());

                    }
                    break;
                case 7 :
                    // EolParserRules.g:229:54: returnStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_returnStatement_in_statementA928);
                    returnStatement72=returnStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, returnStatement72.getTree());

                    }
                    break;
                case 8 :
                    // EolParserRules.g:229:72: breakStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_breakStatement_in_statementA932);
                    breakStatement73=breakStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, breakStatement73.getTree());

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
    public final Eml_EolParserRules.statementB_return statementB() throws RecognitionException {
        Eml_EolParserRules.statementB_return retval = new Eml_EolParserRules.statementB_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Eml_EolParserRules.breakAllStatement_return breakAllStatement74 = null;

        Eml_EolParserRules.returnStatement_return returnStatement75 = null;

        Eml_EolParserRules.transactionStatement_return transactionStatement76 = null;

        Eml_EolParserRules.abortStatement_return abortStatement77 = null;

        Eml_EolParserRules.continueStatement_return continueStatement78 = null;

        Eml_EolParserRules.throwStatement_return throwStatement79 = null;

        Eml_EolParserRules.deleteStatement_return deleteStatement80 = null;



        try {
            // EolParserRules.g:233:2: ( breakAllStatement | returnStatement | transactionStatement | abortStatement | continueStatement | throwStatement | deleteStatement )
            int alt25=7;
            switch ( input.LA(1) ) {
            case 121:
                {
                alt25=1;
                }
                break;
            case 117:
                {
                alt25=2;
                }
                break;
            case 124:
                {
                alt25=3;
                }
                break;
            case 123:
                {
                alt25=4;
                }
                break;
            case 122:
                {
                alt25=5;
                }
                break;
            case 118:
                {
                alt25=6;
                }
                break;
            case 119:
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

                    pushFollow(FOLLOW_breakAllStatement_in_statementB944);
                    breakAllStatement74=breakAllStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, breakAllStatement74.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:233:24: returnStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_returnStatement_in_statementB948);
                    returnStatement75=returnStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, returnStatement75.getTree());

                    }
                    break;
                case 3 :
                    // EolParserRules.g:233:42: transactionStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_transactionStatement_in_statementB952);
                    transactionStatement76=transactionStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, transactionStatement76.getTree());

                    }
                    break;
                case 4 :
                    // EolParserRules.g:234:5: abortStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_abortStatement_in_statementB958);
                    abortStatement77=abortStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, abortStatement77.getTree());

                    }
                    break;
                case 5 :
                    // EolParserRules.g:234:22: continueStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_continueStatement_in_statementB962);
                    continueStatement78=continueStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, continueStatement78.getTree());

                    }
                    break;
                case 6 :
                    // EolParserRules.g:234:42: throwStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_throwStatement_in_statementB966);
                    throwStatement79=throwStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, throwStatement79.getTree());

                    }
                    break;
                case 7 :
                    // EolParserRules.g:235:5: deleteStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_deleteStatement_in_statementB972);
                    deleteStatement80=deleteStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, deleteStatement80.getTree());

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
    public final Eml_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock() throws RecognitionException {
        Eml_EolParserRules.statementOrStatementBlock_return retval = new Eml_EolParserRules.statementOrStatementBlock_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Eml_EolParserRules.statement_return statement81 = null;

        Eml_EolParserRules.statementBlock_return statementBlock82 = null;



        try {
            // EolParserRules.g:239:2: ( statement | statementBlock )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==FLOAT||LA26_0==INT||LA26_0==BOOLEAN||LA26_0==STRING||LA26_0==NAME||LA26_0==94||(LA26_0>=101 && LA26_0<=109)||(LA26_0>=111 && LA26_0<=112)||(LA26_0>=116 && LA26_0<=124)||LA26_0==138||LA26_0==141||(LA26_0>=145 && LA26_0<=146)) ) {
                alt26=1;
            }
            else if ( (LA26_0==89) ) {
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

                    pushFollow(FOLLOW_statement_in_statementOrStatementBlock983);
                    statement81=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement81.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:239:16: statementBlock
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_statementBlock_in_statementOrStatementBlock987);
                    statementBlock82=statementBlock();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statementBlock82.getTree());

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
    public final Eml_EolParserRules.expressionOrStatementBlock_return expressionOrStatementBlock() throws RecognitionException {
        Eml_EolParserRules.expressionOrStatementBlock_return retval = new Eml_EolParserRules.expressionOrStatementBlock_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal83=null;
        Eml_EolParserRules.logicalExpression_return logicalExpression84 = null;

        Eml_EolParserRules.statementBlock_return statementBlock85 = null;


        CommonTree char_literal83_tree=null;

        try {
            // EolParserRules.g:242:2: ( ':' logicalExpression | statementBlock )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==85) ) {
                alt27=1;
            }
            else if ( (LA27_0==89) ) {
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

                    char_literal83=(Token)match(input,85,FOLLOW_85_in_expressionOrStatementBlock996); if (state.failed) return retval;
                    pushFollow(FOLLOW_logicalExpression_in_expressionOrStatementBlock999);
                    logicalExpression84=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression84.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:242:29: statementBlock
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_statementBlock_in_expressionOrStatementBlock1003);
                    statementBlock85=statementBlock();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statementBlock85.getTree());

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
    public final Eml_EolParserRules.forStatement_return forStatement() throws RecognitionException {
        Eml_EolParserRules.forStatement_return retval = new Eml_EolParserRules.forStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal86=null;
        Token char_literal87=null;
        Token string_literal89=null;
        Token char_literal91=null;
        Eml_EolParserRules.formalParameter_return formalParameter88 = null;

        Eml_EolParserRules.logicalExpression_return logicalExpression90 = null;

        Eml_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock92 = null;


        CommonTree string_literal86_tree=null;
        CommonTree char_literal87_tree=null;
        CommonTree string_literal89_tree=null;
        CommonTree char_literal91_tree=null;
        RewriteRuleTokenStream stream_95=new RewriteRuleTokenStream(adaptor,"token 95");
        RewriteRuleTokenStream stream_94=new RewriteRuleTokenStream(adaptor,"token 94");
        RewriteRuleTokenStream stream_109=new RewriteRuleTokenStream(adaptor,"token 109");
        RewriteRuleTokenStream stream_110=new RewriteRuleTokenStream(adaptor,"token 110");
        RewriteRuleSubtreeStream stream_statementOrStatementBlock=new RewriteRuleSubtreeStream(adaptor,"rule statementOrStatementBlock");
        RewriteRuleSubtreeStream stream_formalParameter=new RewriteRuleSubtreeStream(adaptor,"rule formalParameter");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:246:2: ( 'for' '(' formalParameter 'in' logicalExpression ')' statementOrStatementBlock -> ^( FOR formalParameter logicalExpression statementOrStatementBlock ) )
            // EolParserRules.g:246:4: 'for' '(' formalParameter 'in' logicalExpression ')' statementOrStatementBlock
            {
            string_literal86=(Token)match(input,109,FOLLOW_109_in_forStatement1014); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_109.add(string_literal86);

            char_literal87=(Token)match(input,94,FOLLOW_94_in_forStatement1016); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_94.add(char_literal87);

            pushFollow(FOLLOW_formalParameter_in_forStatement1018);
            formalParameter88=formalParameter();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_formalParameter.add(formalParameter88.getTree());
            string_literal89=(Token)match(input,110,FOLLOW_110_in_forStatement1020); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_110.add(string_literal89);

            pushFollow(FOLLOW_logicalExpression_in_forStatement1022);
            logicalExpression90=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression90.getTree());
            char_literal91=(Token)match(input,95,FOLLOW_95_in_forStatement1024); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_95.add(char_literal91);

            pushFollow(FOLLOW_statementOrStatementBlock_in_forStatement1026);
            statementOrStatementBlock92=statementOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_statementOrStatementBlock.add(statementOrStatementBlock92.getTree());


            // AST REWRITE
            // elements: formalParameter, statementOrStatementBlock, logicalExpression
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
    public final Eml_EolParserRules.ifStatement_return ifStatement() throws RecognitionException {
        Eml_EolParserRules.ifStatement_return retval = new Eml_EolParserRules.ifStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal93=null;
        Token char_literal94=null;
        Token char_literal96=null;
        Eml_EolParserRules.logicalExpression_return logicalExpression95 = null;

        Eml_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock97 = null;

        Eml_EolParserRules.elseStatement_return elseStatement98 = null;


        CommonTree string_literal93_tree=null;
        CommonTree char_literal94_tree=null;
        CommonTree char_literal96_tree=null;
        RewriteRuleTokenStream stream_95=new RewriteRuleTokenStream(adaptor,"token 95");
        RewriteRuleTokenStream stream_94=new RewriteRuleTokenStream(adaptor,"token 94");
        RewriteRuleTokenStream stream_111=new RewriteRuleTokenStream(adaptor,"token 111");
        RewriteRuleSubtreeStream stream_statementOrStatementBlock=new RewriteRuleSubtreeStream(adaptor,"rule statementOrStatementBlock");
        RewriteRuleSubtreeStream stream_elseStatement=new RewriteRuleSubtreeStream(adaptor,"rule elseStatement");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:251:2: ( 'if' '(' logicalExpression ')' statementOrStatementBlock ( elseStatement )? -> ^( IF logicalExpression statementOrStatementBlock ( elseStatement )? ) )
            // EolParserRules.g:251:4: 'if' '(' logicalExpression ')' statementOrStatementBlock ( elseStatement )?
            {
            string_literal93=(Token)match(input,111,FOLLOW_111_in_ifStatement1050); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_111.add(string_literal93);

            char_literal94=(Token)match(input,94,FOLLOW_94_in_ifStatement1052); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_94.add(char_literal94);

            pushFollow(FOLLOW_logicalExpression_in_ifStatement1054);
            logicalExpression95=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression95.getTree());
            char_literal96=(Token)match(input,95,FOLLOW_95_in_ifStatement1056); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_95.add(char_literal96);

            pushFollow(FOLLOW_statementOrStatementBlock_in_ifStatement1058);
            statementOrStatementBlock97=statementOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_statementOrStatementBlock.add(statementOrStatementBlock97.getTree());
            // EolParserRules.g:251:61: ( elseStatement )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==115) ) {
                int LA28_1 = input.LA(2);

                if ( (synpred46_EolParserRules()) ) {
                    alt28=1;
                }
            }
            switch (alt28) {
                case 1 :
                    // EolParserRules.g:0:0: elseStatement
                    {
                    pushFollow(FOLLOW_elseStatement_in_ifStatement1060);
                    elseStatement98=elseStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_elseStatement.add(elseStatement98.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: elseStatement, statementOrStatementBlock, logicalExpression
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
    public final Eml_EolParserRules.switchStatement_return switchStatement() throws RecognitionException {
        Eml_EolParserRules.switchStatement_return retval = new Eml_EolParserRules.switchStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal99=null;
        Token char_literal100=null;
        Token char_literal102=null;
        Token char_literal103=null;
        Token char_literal106=null;
        Eml_EolParserRules.logicalExpression_return logicalExpression101 = null;

        Eml_EolParserRules.caseStatement_return caseStatement104 = null;

        Eml_EolParserRules.defaultStatement_return defaultStatement105 = null;


        CommonTree string_literal99_tree=null;
        CommonTree char_literal100_tree=null;
        CommonTree char_literal102_tree=null;
        CommonTree char_literal103_tree=null;
        CommonTree char_literal106_tree=null;
        RewriteRuleTokenStream stream_95=new RewriteRuleTokenStream(adaptor,"token 95");
        RewriteRuleTokenStream stream_112=new RewriteRuleTokenStream(adaptor,"token 112");
        RewriteRuleTokenStream stream_94=new RewriteRuleTokenStream(adaptor,"token 94");
        RewriteRuleTokenStream stream_90=new RewriteRuleTokenStream(adaptor,"token 90");
        RewriteRuleTokenStream stream_89=new RewriteRuleTokenStream(adaptor,"token 89");
        RewriteRuleSubtreeStream stream_caseStatement=new RewriteRuleSubtreeStream(adaptor,"rule caseStatement");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        RewriteRuleSubtreeStream stream_defaultStatement=new RewriteRuleSubtreeStream(adaptor,"rule defaultStatement");
        try {
            // EolParserRules.g:256:2: ( 'switch' '(' logicalExpression ')' '{' ( caseStatement )* ( defaultStatement )? '}' -> ^( SWITCH logicalExpression ( caseStatement )* ( defaultStatement )? ) )
            // EolParserRules.g:256:4: 'switch' '(' logicalExpression ')' '{' ( caseStatement )* ( defaultStatement )? '}'
            {
            string_literal99=(Token)match(input,112,FOLLOW_112_in_switchStatement1087); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_112.add(string_literal99);

            char_literal100=(Token)match(input,94,FOLLOW_94_in_switchStatement1089); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_94.add(char_literal100);

            pushFollow(FOLLOW_logicalExpression_in_switchStatement1091);
            logicalExpression101=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression101.getTree());
            char_literal102=(Token)match(input,95,FOLLOW_95_in_switchStatement1093); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_95.add(char_literal102);

            char_literal103=(Token)match(input,89,FOLLOW_89_in_switchStatement1095); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_89.add(char_literal103);

            // EolParserRules.g:256:43: ( caseStatement )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==113) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // EolParserRules.g:0:0: caseStatement
            	    {
            	    pushFollow(FOLLOW_caseStatement_in_switchStatement1097);
            	    caseStatement104=caseStatement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_caseStatement.add(caseStatement104.getTree());

            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

            // EolParserRules.g:256:58: ( defaultStatement )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==114) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // EolParserRules.g:0:0: defaultStatement
                    {
                    pushFollow(FOLLOW_defaultStatement_in_switchStatement1100);
                    defaultStatement105=defaultStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_defaultStatement.add(defaultStatement105.getTree());

                    }
                    break;

            }

            char_literal106=(Token)match(input,90,FOLLOW_90_in_switchStatement1103); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_90.add(char_literal106);



            // AST REWRITE
            // elements: caseStatement, defaultStatement, logicalExpression
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
    public final Eml_EolParserRules.caseStatement_return caseStatement() throws RecognitionException {
        Eml_EolParserRules.caseStatement_return retval = new Eml_EolParserRules.caseStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal107=null;
        Token char_literal109=null;
        Eml_EolParserRules.logicalExpression_return logicalExpression108 = null;

        Eml_EolParserRules.block_return block110 = null;


        CommonTree string_literal107_tree=null;
        CommonTree char_literal109_tree=null;
        RewriteRuleTokenStream stream_113=new RewriteRuleTokenStream(adaptor,"token 113");
        RewriteRuleTokenStream stream_85=new RewriteRuleTokenStream(adaptor,"token 85");
        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:261:2: ( 'case' logicalExpression ':' block -> ^( CASE logicalExpression block ) )
            // EolParserRules.g:261:4: 'case' logicalExpression ':' block
            {
            string_literal107=(Token)match(input,113,FOLLOW_113_in_caseStatement1130); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_113.add(string_literal107);

            pushFollow(FOLLOW_logicalExpression_in_caseStatement1132);
            logicalExpression108=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression108.getTree());
            char_literal109=(Token)match(input,85,FOLLOW_85_in_caseStatement1134); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_85.add(char_literal109);

            pushFollow(FOLLOW_block_in_caseStatement1136);
            block110=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_block.add(block110.getTree());


            // AST REWRITE
            // elements: logicalExpression, block
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
    public final Eml_EolParserRules.defaultStatement_return defaultStatement() throws RecognitionException {
        Eml_EolParserRules.defaultStatement_return retval = new Eml_EolParserRules.defaultStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal111=null;
        Token char_literal112=null;
        Eml_EolParserRules.block_return block113 = null;


        CommonTree string_literal111_tree=null;
        CommonTree char_literal112_tree=null;
        RewriteRuleTokenStream stream_114=new RewriteRuleTokenStream(adaptor,"token 114");
        RewriteRuleTokenStream stream_85=new RewriteRuleTokenStream(adaptor,"token 85");
        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        try {
            // EolParserRules.g:266:2: ( 'default' ':' block -> ^( DEFAULT block ) )
            // EolParserRules.g:266:4: 'default' ':' block
            {
            string_literal111=(Token)match(input,114,FOLLOW_114_in_defaultStatement1159); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_114.add(string_literal111);

            char_literal112=(Token)match(input,85,FOLLOW_85_in_defaultStatement1161); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_85.add(char_literal112);

            pushFollow(FOLLOW_block_in_defaultStatement1163);
            block113=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_block.add(block113.getTree());


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
    public final Eml_EolParserRules.elseStatement_return elseStatement() throws RecognitionException {
        Eml_EolParserRules.elseStatement_return retval = new Eml_EolParserRules.elseStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal114=null;
        Eml_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock115 = null;


        CommonTree string_literal114_tree=null;

        try {
            // EolParserRules.g:271:2: ( 'else' statementOrStatementBlock )
            // EolParserRules.g:271:4: 'else' statementOrStatementBlock
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal114=(Token)match(input,115,FOLLOW_115_in_elseStatement1184); if (state.failed) return retval;
            pushFollow(FOLLOW_statementOrStatementBlock_in_elseStatement1187);
            statementOrStatementBlock115=statementOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, statementOrStatementBlock115.getTree());

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
    public final Eml_EolParserRules.whileStatement_return whileStatement() throws RecognitionException {
        Eml_EolParserRules.whileStatement_return retval = new Eml_EolParserRules.whileStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal116=null;
        Token char_literal117=null;
        Token char_literal119=null;
        Eml_EolParserRules.logicalExpression_return logicalExpression118 = null;

        Eml_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock120 = null;


        CommonTree string_literal116_tree=null;
        CommonTree char_literal117_tree=null;
        CommonTree char_literal119_tree=null;
        RewriteRuleTokenStream stream_116=new RewriteRuleTokenStream(adaptor,"token 116");
        RewriteRuleTokenStream stream_95=new RewriteRuleTokenStream(adaptor,"token 95");
        RewriteRuleTokenStream stream_94=new RewriteRuleTokenStream(adaptor,"token 94");
        RewriteRuleSubtreeStream stream_statementOrStatementBlock=new RewriteRuleSubtreeStream(adaptor,"rule statementOrStatementBlock");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:276:2: ( 'while' '(' logicalExpression ')' statementOrStatementBlock -> ^( WHILE logicalExpression statementOrStatementBlock ) )
            // EolParserRules.g:276:4: 'while' '(' logicalExpression ')' statementOrStatementBlock
            {
            string_literal116=(Token)match(input,116,FOLLOW_116_in_whileStatement1200); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_116.add(string_literal116);

            char_literal117=(Token)match(input,94,FOLLOW_94_in_whileStatement1202); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_94.add(char_literal117);

            pushFollow(FOLLOW_logicalExpression_in_whileStatement1204);
            logicalExpression118=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression118.getTree());
            char_literal119=(Token)match(input,95,FOLLOW_95_in_whileStatement1206); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_95.add(char_literal119);

            pushFollow(FOLLOW_statementOrStatementBlock_in_whileStatement1208);
            statementOrStatementBlock120=statementOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_statementOrStatementBlock.add(statementOrStatementBlock120.getTree());


            // AST REWRITE
            // elements: statementOrStatementBlock, logicalExpression
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
    public final Eml_EolParserRules.returnStatement_return returnStatement() throws RecognitionException {
        Eml_EolParserRules.returnStatement_return retval = new Eml_EolParserRules.returnStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal121=null;
        Token char_literal123=null;
        Eml_EolParserRules.logicalExpression_return logicalExpression122 = null;


        CommonTree string_literal121_tree=null;
        CommonTree char_literal123_tree=null;
        RewriteRuleTokenStream stream_117=new RewriteRuleTokenStream(adaptor,"token 117");
        RewriteRuleTokenStream stream_84=new RewriteRuleTokenStream(adaptor,"token 84");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:281:2: ( 'return' ( logicalExpression )? ';' -> ^( RETURN ( logicalExpression )? ) )
            // EolParserRules.g:281:4: 'return' ( logicalExpression )? ';'
            {
            string_literal121=(Token)match(input,117,FOLLOW_117_in_returnStatement1230); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_117.add(string_literal121);

            // EolParserRules.g:281:13: ( logicalExpression )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==FLOAT||LA31_0==INT||LA31_0==BOOLEAN||LA31_0==STRING||LA31_0==NAME||LA31_0==94||(LA31_0>=101 && LA31_0<=108)||LA31_0==138||LA31_0==141||(LA31_0>=145 && LA31_0<=146)) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // EolParserRules.g:0:0: logicalExpression
                    {
                    pushFollow(FOLLOW_logicalExpression_in_returnStatement1232);
                    logicalExpression122=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression122.getTree());

                    }
                    break;

            }

            char_literal123=(Token)match(input,84,FOLLOW_84_in_returnStatement1235); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_84.add(char_literal123);



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
    public final Eml_EolParserRules.throwStatement_return throwStatement() throws RecognitionException {
        Eml_EolParserRules.throwStatement_return retval = new Eml_EolParserRules.throwStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal124=null;
        Token char_literal126=null;
        Eml_EolParserRules.logicalExpression_return logicalExpression125 = null;


        CommonTree string_literal124_tree=null;
        CommonTree char_literal126_tree=null;
        RewriteRuleTokenStream stream_118=new RewriteRuleTokenStream(adaptor,"token 118");
        RewriteRuleTokenStream stream_84=new RewriteRuleTokenStream(adaptor,"token 84");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:286:2: ( 'throw' ( logicalExpression )? ';' -> ^( THROW ( logicalExpression )? ) )
            // EolParserRules.g:286:4: 'throw' ( logicalExpression )? ';'
            {
            string_literal124=(Token)match(input,118,FOLLOW_118_in_throwStatement1256); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_118.add(string_literal124);

            // EolParserRules.g:286:12: ( logicalExpression )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==FLOAT||LA32_0==INT||LA32_0==BOOLEAN||LA32_0==STRING||LA32_0==NAME||LA32_0==94||(LA32_0>=101 && LA32_0<=108)||LA32_0==138||LA32_0==141||(LA32_0>=145 && LA32_0<=146)) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // EolParserRules.g:0:0: logicalExpression
                    {
                    pushFollow(FOLLOW_logicalExpression_in_throwStatement1258);
                    logicalExpression125=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression125.getTree());

                    }
                    break;

            }

            char_literal126=(Token)match(input,84,FOLLOW_84_in_throwStatement1261); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_84.add(char_literal126);



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
    public final Eml_EolParserRules.deleteStatement_return deleteStatement() throws RecognitionException {
        Eml_EolParserRules.deleteStatement_return retval = new Eml_EolParserRules.deleteStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal127=null;
        Token char_literal129=null;
        Eml_EolParserRules.logicalExpression_return logicalExpression128 = null;


        CommonTree string_literal127_tree=null;
        CommonTree char_literal129_tree=null;
        RewriteRuleTokenStream stream_84=new RewriteRuleTokenStream(adaptor,"token 84");
        RewriteRuleTokenStream stream_119=new RewriteRuleTokenStream(adaptor,"token 119");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:291:2: ( 'delete' ( logicalExpression )? ';' -> ^( DELETE ( logicalExpression )? ) )
            // EolParserRules.g:291:4: 'delete' ( logicalExpression )? ';'
            {
            string_literal127=(Token)match(input,119,FOLLOW_119_in_deleteStatement1282); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_119.add(string_literal127);

            // EolParserRules.g:291:13: ( logicalExpression )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==FLOAT||LA33_0==INT||LA33_0==BOOLEAN||LA33_0==STRING||LA33_0==NAME||LA33_0==94||(LA33_0>=101 && LA33_0<=108)||LA33_0==138||LA33_0==141||(LA33_0>=145 && LA33_0<=146)) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // EolParserRules.g:0:0: logicalExpression
                    {
                    pushFollow(FOLLOW_logicalExpression_in_deleteStatement1284);
                    logicalExpression128=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression128.getTree());

                    }
                    break;

            }

            char_literal129=(Token)match(input,84,FOLLOW_84_in_deleteStatement1287); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_84.add(char_literal129);



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
    public final Eml_EolParserRules.breakStatement_return breakStatement() throws RecognitionException {
        Eml_EolParserRules.breakStatement_return retval = new Eml_EolParserRules.breakStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal130=null;
        Token char_literal131=null;

        CommonTree string_literal130_tree=null;
        CommonTree char_literal131_tree=null;
        RewriteRuleTokenStream stream_120=new RewriteRuleTokenStream(adaptor,"token 120");
        RewriteRuleTokenStream stream_84=new RewriteRuleTokenStream(adaptor,"token 84");

        try {
            // EolParserRules.g:296:2: ( 'break' ';' -> ^( BREAK ) )
            // EolParserRules.g:296:4: 'break' ';'
            {
            string_literal130=(Token)match(input,120,FOLLOW_120_in_breakStatement1311); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_120.add(string_literal130);

            char_literal131=(Token)match(input,84,FOLLOW_84_in_breakStatement1313); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_84.add(char_literal131);



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
    public final Eml_EolParserRules.breakAllStatement_return breakAllStatement() throws RecognitionException {
        Eml_EolParserRules.breakAllStatement_return retval = new Eml_EolParserRules.breakAllStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal132=null;
        Token char_literal133=null;

        CommonTree string_literal132_tree=null;
        CommonTree char_literal133_tree=null;
        RewriteRuleTokenStream stream_121=new RewriteRuleTokenStream(adaptor,"token 121");
        RewriteRuleTokenStream stream_84=new RewriteRuleTokenStream(adaptor,"token 84");

        try {
            // EolParserRules.g:301:2: ( 'breakAll' ';' -> ^( BREAKALL ) )
            // EolParserRules.g:301:4: 'breakAll' ';'
            {
            string_literal132=(Token)match(input,121,FOLLOW_121_in_breakAllStatement1331); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_121.add(string_literal132);

            char_literal133=(Token)match(input,84,FOLLOW_84_in_breakAllStatement1333); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_84.add(char_literal133);



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
    public final Eml_EolParserRules.continueStatement_return continueStatement() throws RecognitionException {
        Eml_EolParserRules.continueStatement_return retval = new Eml_EolParserRules.continueStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal134=null;
        Token char_literal135=null;

        CommonTree string_literal134_tree=null;
        CommonTree char_literal135_tree=null;
        RewriteRuleTokenStream stream_122=new RewriteRuleTokenStream(adaptor,"token 122");
        RewriteRuleTokenStream stream_84=new RewriteRuleTokenStream(adaptor,"token 84");

        try {
            // EolParserRules.g:306:2: ( 'continue' ';' -> ^( CONTINUE ) )
            // EolParserRules.g:306:4: 'continue' ';'
            {
            string_literal134=(Token)match(input,122,FOLLOW_122_in_continueStatement1351); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_122.add(string_literal134);

            char_literal135=(Token)match(input,84,FOLLOW_84_in_continueStatement1353); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_84.add(char_literal135);



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
    public final Eml_EolParserRules.abortStatement_return abortStatement() throws RecognitionException {
        Eml_EolParserRules.abortStatement_return retval = new Eml_EolParserRules.abortStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal136=null;
        Token char_literal137=null;

        CommonTree string_literal136_tree=null;
        CommonTree char_literal137_tree=null;
        RewriteRuleTokenStream stream_123=new RewriteRuleTokenStream(adaptor,"token 123");
        RewriteRuleTokenStream stream_84=new RewriteRuleTokenStream(adaptor,"token 84");

        try {
            // EolParserRules.g:311:2: ( 'abort' ';' -> ^( ABORT ) )
            // EolParserRules.g:311:4: 'abort' ';'
            {
            string_literal136=(Token)match(input,123,FOLLOW_123_in_abortStatement1371); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_123.add(string_literal136);

            char_literal137=(Token)match(input,84,FOLLOW_84_in_abortStatement1373); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_84.add(char_literal137);



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
    public final Eml_EolParserRules.transactionStatement_return transactionStatement() throws RecognitionException {
        Eml_EolParserRules.transactionStatement_return retval = new Eml_EolParserRules.transactionStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal138=null;
        Token NAME139=null;
        Token char_literal140=null;
        Token NAME141=null;
        Eml_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock142 = null;


        CommonTree string_literal138_tree=null;
        CommonTree NAME139_tree=null;
        CommonTree char_literal140_tree=null;
        CommonTree NAME141_tree=null;
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_124=new RewriteRuleTokenStream(adaptor,"token 124");
        RewriteRuleTokenStream stream_86=new RewriteRuleTokenStream(adaptor,"token 86");
        RewriteRuleSubtreeStream stream_statementOrStatementBlock=new RewriteRuleSubtreeStream(adaptor,"rule statementOrStatementBlock");
        try {
            // EolParserRules.g:316:2: ( 'transaction' ( NAME ( ',' NAME )* )? statementOrStatementBlock -> ^( TRANSACTION ( NAME )* statementOrStatementBlock ) )
            // EolParserRules.g:316:4: 'transaction' ( NAME ( ',' NAME )* )? statementOrStatementBlock
            {
            string_literal138=(Token)match(input,124,FOLLOW_124_in_transactionStatement1391); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_124.add(string_literal138);

            // EolParserRules.g:316:18: ( NAME ( ',' NAME )* )?
            int alt35=2;
            alt35 = dfa35.predict(input);
            switch (alt35) {
                case 1 :
                    // EolParserRules.g:316:19: NAME ( ',' NAME )*
                    {
                    NAME139=(Token)match(input,NAME,FOLLOW_NAME_in_transactionStatement1394); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NAME.add(NAME139);

                    // EolParserRules.g:316:24: ( ',' NAME )*
                    loop34:
                    do {
                        int alt34=2;
                        int LA34_0 = input.LA(1);

                        if ( (LA34_0==86) ) {
                            alt34=1;
                        }


                        switch (alt34) {
                    	case 1 :
                    	    // EolParserRules.g:316:25: ',' NAME
                    	    {
                    	    char_literal140=(Token)match(input,86,FOLLOW_86_in_transactionStatement1397); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_86.add(char_literal140);

                    	    NAME141=(Token)match(input,NAME,FOLLOW_NAME_in_transactionStatement1399); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_NAME.add(NAME141);


                    	    }
                    	    break;

                    	default :
                    	    break loop34;
                        }
                    } while (true);


                    }
                    break;

            }

            pushFollow(FOLLOW_statementOrStatementBlock_in_transactionStatement1405);
            statementOrStatementBlock142=statementOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_statementOrStatementBlock.add(statementOrStatementBlock142.getTree());


            // AST REWRITE
            // elements: statementOrStatementBlock, NAME
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
    public final Eml_EolParserRules.assignmentStatement_return assignmentStatement() throws RecognitionException {
        Eml_EolParserRules.assignmentStatement_return retval = new Eml_EolParserRules.assignmentStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token normal=null;
        Token special=null;
        Token char_literal145=null;
        Eml_EolParserRules.logicalExpression_return logicalExpression143 = null;

        Eml_EolParserRules.logicalExpression_return logicalExpression144 = null;


        CommonTree normal_tree=null;
        CommonTree special_tree=null;
        CommonTree char_literal145_tree=null;

        try {
            // EolParserRules.g:325:2: ( logicalExpression (normal= ':=' | special= '::=' ) logicalExpression ';' )
            // EolParserRules.g:325:4: logicalExpression (normal= ':=' | special= '::=' ) logicalExpression ';'
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_logicalExpression_in_assignmentStatement1434);
            logicalExpression143=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression143.getTree());
            // EolParserRules.g:325:22: (normal= ':=' | special= '::=' )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==125) ) {
                alt36=1;
            }
            else if ( (LA36_0==126) ) {
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
                    normal=(Token)match(input,125,FOLLOW_125_in_assignmentStatement1439); if (state.failed) return retval;
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
                    special=(Token)match(input,126,FOLLOW_126_in_assignmentStatement1446); if (state.failed) return retval;
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

            pushFollow(FOLLOW_logicalExpression_in_assignmentStatement1452);
            logicalExpression144=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression144.getTree());
            char_literal145=(Token)match(input,84,FOLLOW_84_in_assignmentStatement1454); if (state.failed) return retval;

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
    // EolParserRules.g:329:1: expressionStatement : logicalExpression ';' ;
    public final Eml_EolParserRules.expressionStatement_return expressionStatement() throws RecognitionException {
        Eml_EolParserRules.expressionStatement_return retval = new Eml_EolParserRules.expressionStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal147=null;
        Eml_EolParserRules.logicalExpression_return logicalExpression146 = null;


        CommonTree char_literal147_tree=null;

        try {
            // EolParserRules.g:330:2: ( logicalExpression ';' )
            // EolParserRules.g:330:4: logicalExpression ';'
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_logicalExpression_in_expressionStatement1469);
            logicalExpression146=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression146.getTree());
            char_literal147=(Token)match(input,84,FOLLOW_84_in_expressionStatement1471); if (state.failed) return retval;

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
    public final Eml_EolParserRules.logicalExpression_return logicalExpression() throws RecognitionException {
        Eml_EolParserRules.logicalExpression_return retval = new Eml_EolParserRules.logicalExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set149=null;
        Eml_EolParserRules.relationalExpression_return relationalExpression148 = null;

        Eml_EolParserRules.relationalExpression_return relationalExpression150 = null;


        CommonTree set149_tree=null;

        try {
            // EolParserRules.g:335:2: ( relationalExpression ( ( 'or' | 'and' | 'xor' | 'implies' ) relationalExpression )* )
            // EolParserRules.g:335:4: relationalExpression ( ( 'or' | 'and' | 'xor' | 'implies' ) relationalExpression )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_relationalExpression_in_logicalExpression1484);
            relationalExpression148=relationalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, relationalExpression148.getTree());
            // EolParserRules.g:335:25: ( ( 'or' | 'and' | 'xor' | 'implies' ) relationalExpression )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( ((LA37_0>=127 && LA37_0<=130)) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // EolParserRules.g:335:26: ( 'or' | 'and' | 'xor' | 'implies' ) relationalExpression
            	    {
            	    set149=(Token)input.LT(1);
            	    set149=(Token)input.LT(1);
            	    if ( (input.LA(1)>=127 && input.LA(1)<=130) ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(set149), root_0);
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_relationalExpression_in_logicalExpression1498);
            	    relationalExpression150=relationalExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, relationalExpression150.getTree());
            	    if ( state.backtracking==0 ) {
            	      if (root_0.getToken() != null) root_0.getToken().setType(OPERATOR);
            	    }

            	    }
            	    break;

            	default :
            	    break loop37;
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
    // EolParserRules.g:339:1: relationalExpression : additiveExpression ( ( '==' ( relationalExpression )? | '=' ( relationalExpression )? | ( '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression ) )* ;
    public final Eml_EolParserRules.relationalExpression_return relationalExpression() throws RecognitionException {
        Eml_EolParserRules.relationalExpression_return retval = new Eml_EolParserRules.relationalExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal152=null;
        Token char_literal154=null;
        Token set156=null;
        Eml_EolParserRules.additiveExpression_return additiveExpression151 = null;

        Eml_EolParserRules.relationalExpression_return relationalExpression153 = null;

        Eml_EolParserRules.relationalExpression_return relationalExpression155 = null;

        Eml_EolParserRules.additiveExpression_return additiveExpression157 = null;


        CommonTree string_literal152_tree=null;
        CommonTree char_literal154_tree=null;
        CommonTree set156_tree=null;

        try {
            // EolParserRules.g:340:2: ( additiveExpression ( ( '==' ( relationalExpression )? | '=' ( relationalExpression )? | ( '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression ) )* )
            // EolParserRules.g:340:4: additiveExpression ( ( '==' ( relationalExpression )? | '=' ( relationalExpression )? | ( '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression ) )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_additiveExpression_in_relationalExpression1515);
            additiveExpression151=additiveExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, additiveExpression151.getTree());
            // EolParserRules.g:340:23: ( ( '==' ( relationalExpression )? | '=' ( relationalExpression )? | ( '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression ) )*
            loop41:
            do {
                int alt41=2;
                switch ( input.LA(1) ) {
                case 131:
                    {
                    int LA41_2 = input.LA(2);

                    if ( (synpred67_EolParserRules()) ) {
                        alt41=1;
                    }


                    }
                    break;
                case 91:
                    {
                    int LA41_3 = input.LA(2);

                    if ( (synpred67_EolParserRules()) ) {
                        alt41=1;
                    }


                    }
                    break;
                case 132:
                case 133:
                case 134:
                case 135:
                case 136:
                    {
                    int LA41_4 = input.LA(2);

                    if ( (synpred67_EolParserRules()) ) {
                        alt41=1;
                    }


                    }
                    break;

                }

                switch (alt41) {
            	case 1 :
            	    // EolParserRules.g:340:24: ( '==' ( relationalExpression )? | '=' ( relationalExpression )? | ( '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression )
            	    {
            	    // EolParserRules.g:340:24: ( '==' ( relationalExpression )? | '=' ( relationalExpression )? | ( '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression )
            	    int alt40=3;
            	    switch ( input.LA(1) ) {
            	    case 131:
            	        {
            	        alt40=1;
            	        }
            	        break;
            	    case 91:
            	        {
            	        alt40=2;
            	        }
            	        break;
            	    case 132:
            	    case 133:
            	    case 134:
            	    case 135:
            	    case 136:
            	        {
            	        alt40=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 40, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt40) {
            	        case 1 :
            	            // EolParserRules.g:340:25: '==' ( relationalExpression )?
            	            {
            	            string_literal152=(Token)match(input,131,FOLLOW_131_in_relationalExpression1519); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            string_literal152_tree = (CommonTree)adaptor.create(string_literal152);
            	            root_0 = (CommonTree)adaptor.becomeRoot(string_literal152_tree, root_0);
            	            }
            	            // EolParserRules.g:340:31: ( relationalExpression )?
            	            int alt38=2;
            	            int LA38_0 = input.LA(1);

            	            if ( (LA38_0==FLOAT||LA38_0==INT||LA38_0==BOOLEAN||LA38_0==STRING||LA38_0==NAME||LA38_0==94||(LA38_0>=101 && LA38_0<=108)||LA38_0==138||LA38_0==141||(LA38_0>=145 && LA38_0<=146)) ) {
            	                alt38=1;
            	            }
            	            switch (alt38) {
            	                case 1 :
            	                    // EolParserRules.g:0:0: relationalExpression
            	                    {
            	                    pushFollow(FOLLOW_relationalExpression_in_relationalExpression1522);
            	                    relationalExpression153=relationalExpression();

            	                    state._fsp--;
            	                    if (state.failed) return retval;
            	                    if ( state.backtracking==0 ) adaptor.addChild(root_0, relationalExpression153.getTree());

            	                    }
            	                    break;

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // EolParserRules.g:340:55: '=' ( relationalExpression )?
            	            {
            	            char_literal154=(Token)match(input,91,FOLLOW_91_in_relationalExpression1527); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal154_tree = (CommonTree)adaptor.create(char_literal154);
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal154_tree, root_0);
            	            }
            	            // EolParserRules.g:340:60: ( relationalExpression )?
            	            int alt39=2;
            	            int LA39_0 = input.LA(1);

            	            if ( (LA39_0==FLOAT||LA39_0==INT||LA39_0==BOOLEAN||LA39_0==STRING||LA39_0==NAME||LA39_0==94||(LA39_0>=101 && LA39_0<=108)||LA39_0==138||LA39_0==141||(LA39_0>=145 && LA39_0<=146)) ) {
            	                alt39=1;
            	            }
            	            switch (alt39) {
            	                case 1 :
            	                    // EolParserRules.g:0:0: relationalExpression
            	                    {
            	                    pushFollow(FOLLOW_relationalExpression_in_relationalExpression1530);
            	                    relationalExpression155=relationalExpression();

            	                    state._fsp--;
            	                    if (state.failed) return retval;
            	                    if ( state.backtracking==0 ) adaptor.addChild(root_0, relationalExpression155.getTree());

            	                    }
            	                    break;

            	            }


            	            }
            	            break;
            	        case 3 :
            	            // EolParserRules.g:341:24: ( '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression
            	            {
            	            set156=(Token)input.LT(1);
            	            set156=(Token)input.LT(1);
            	            if ( (input.LA(1)>=132 && input.LA(1)<=136) ) {
            	                input.consume();
            	                if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(set156), root_0);
            	                state.errorRecovery=false;state.failed=false;
            	            }
            	            else {
            	                if (state.backtracking>0) {state.failed=true; return retval;}
            	                MismatchedSetException mse = new MismatchedSetException(null,input);
            	                throw mse;
            	            }

            	            pushFollow(FOLLOW_additiveExpression_in_relationalExpression1571);
            	            additiveExpression157=additiveExpression();

            	            state._fsp--;
            	            if (state.failed) return retval;
            	            if ( state.backtracking==0 ) adaptor.addChild(root_0, additiveExpression157.getTree());

            	            }
            	            break;

            	    }

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
    // $ANTLR end relationalExpression

    public static class additiveExpression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start additiveExpression
    // EolParserRules.g:345:1: additiveExpression : multiplicativeExpression ( ( '+' | '-' ) multiplicativeExpression )* ;
    public final Eml_EolParserRules.additiveExpression_return additiveExpression() throws RecognitionException {
        Eml_EolParserRules.additiveExpression_return retval = new Eml_EolParserRules.additiveExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set159=null;
        Eml_EolParserRules.multiplicativeExpression_return multiplicativeExpression158 = null;

        Eml_EolParserRules.multiplicativeExpression_return multiplicativeExpression160 = null;


        CommonTree set159_tree=null;

        try {
            // EolParserRules.g:346:2: ( multiplicativeExpression ( ( '+' | '-' ) multiplicativeExpression )* )
            // EolParserRules.g:346:4: multiplicativeExpression ( ( '+' | '-' ) multiplicativeExpression )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_multiplicativeExpression_in_additiveExpression1589);
            multiplicativeExpression158=multiplicativeExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, multiplicativeExpression158.getTree());
            // EolParserRules.g:346:29: ( ( '+' | '-' ) multiplicativeExpression )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( ((LA42_0>=137 && LA42_0<=138)) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // EolParserRules.g:346:30: ( '+' | '-' ) multiplicativeExpression
            	    {
            	    set159=(Token)input.LT(1);
            	    set159=(Token)input.LT(1);
            	    if ( (input.LA(1)>=137 && input.LA(1)<=138) ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(set159), root_0);
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_multiplicativeExpression_in_additiveExpression1599);
            	    multiplicativeExpression160=multiplicativeExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, multiplicativeExpression160.getTree());
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
    // $ANTLR end additiveExpression

    public static class multiplicativeExpression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start multiplicativeExpression
    // EolParserRules.g:351:1: multiplicativeExpression : unaryExpression ( ( '*' | '/' ) unaryExpression )* ;
    public final Eml_EolParserRules.multiplicativeExpression_return multiplicativeExpression() throws RecognitionException {
        Eml_EolParserRules.multiplicativeExpression_return retval = new Eml_EolParserRules.multiplicativeExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set162=null;
        Eml_EolParserRules.unaryExpression_return unaryExpression161 = null;

        Eml_EolParserRules.unaryExpression_return unaryExpression163 = null;


        CommonTree set162_tree=null;

        try {
            // EolParserRules.g:352:2: ( unaryExpression ( ( '*' | '/' ) unaryExpression )* )
            // EolParserRules.g:352:4: unaryExpression ( ( '*' | '/' ) unaryExpression )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_unaryExpression_in_multiplicativeExpression1620);
            unaryExpression161=unaryExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, unaryExpression161.getTree());
            // EolParserRules.g:352:20: ( ( '*' | '/' ) unaryExpression )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( ((LA43_0>=139 && LA43_0<=140)) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // EolParserRules.g:352:21: ( '*' | '/' ) unaryExpression
            	    {
            	    set162=(Token)input.LT(1);
            	    set162=(Token)input.LT(1);
            	    if ( (input.LA(1)>=139 && input.LA(1)<=140) ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(set162), root_0);
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_unaryExpression_in_multiplicativeExpression1630);
            	    unaryExpression163=unaryExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, unaryExpression163.getTree());
            	    if ( state.backtracking==0 ) {
            	      if (root_0.getToken() != null) root_0.getToken().setType(OPERATOR);
            	    }

            	    }
            	    break;

            	default :
            	    break loop43;
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
    public final Eml_EolParserRules.unaryExpression_return unaryExpression() throws RecognitionException {
        Eml_EolParserRules.unaryExpression_return retval = new Eml_EolParserRules.unaryExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set164=null;
        Eml_EolParserRules.postfixExpression_return postfixExpression165 = null;


        CommonTree set164_tree=null;

        try {
            // EolParserRules.g:357:2: ( ( ( 'not' | '-' ) )? postfixExpression )
            // EolParserRules.g:357:4: ( ( 'not' | '-' ) )? postfixExpression
            {
            root_0 = (CommonTree)adaptor.nil();

            // EolParserRules.g:357:4: ( ( 'not' | '-' ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==138||LA44_0==141) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // EolParserRules.g:357:5: ( 'not' | '-' )
                    {
                    set164=(Token)input.LT(1);
                    set164=(Token)input.LT(1);
                    if ( input.LA(1)==138||input.LA(1)==141 ) {
                        input.consume();
                        if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(set164), root_0);
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

            pushFollow(FOLLOW_postfixExpression_in_unaryExpression1657);
            postfixExpression165=postfixExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, postfixExpression165.getTree());
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
    public final Eml_EolParserRules.postfixExpression_return postfixExpression() throws RecognitionException {
        Eml_EolParserRules.postfixExpression_return retval = new Eml_EolParserRules.postfixExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set167=null;
        Token char_literal168=null;
        Token char_literal170=null;
        Eml_EolParserRules.featureCall_return fc = null;

        Eml_EolParserRules.itemSelectorExpression_return itemSelectorExpression166 = null;

        Eml_EolParserRules.logicalExpression_return logicalExpression169 = null;


        CommonTree set167_tree=null;
        CommonTree char_literal168_tree=null;
        CommonTree char_literal170_tree=null;

        try {
            // EolParserRules.g:362:2: ( itemSelectorExpression ( ( POINT | ARROW ) fc= featureCall ( '[' logicalExpression ']' )* )* )
            // EolParserRules.g:362:4: itemSelectorExpression ( ( POINT | ARROW ) fc= featureCall ( '[' logicalExpression ']' )* )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_itemSelectorExpression_in_postfixExpression1673);
            itemSelectorExpression166=itemSelectorExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, itemSelectorExpression166.getTree());
            // EolParserRules.g:362:27: ( ( POINT | ARROW ) fc= featureCall ( '[' logicalExpression ']' )* )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==POINT||LA46_0==ARROW) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // EolParserRules.g:362:28: ( POINT | ARROW ) fc= featureCall ( '[' logicalExpression ']' )*
            	    {
            	    set167=(Token)input.LT(1);
            	    set167=(Token)input.LT(1);
            	    if ( input.LA(1)==POINT||input.LA(1)==ARROW ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(set167), root_0);
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_featureCall_in_postfixExpression1685);
            	    fc=featureCall();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, fc.getTree());
            	    if ( state.backtracking==0 ) {
            	      setTokenType(fc,FEATURECALL);
            	    }
            	    // EolParserRules.g:363:35: ( '[' logicalExpression ']' )*
            	    loop45:
            	    do {
            	        int alt45=2;
            	        int LA45_0 = input.LA(1);

            	        if ( (LA45_0==142) ) {
            	            alt45=1;
            	        }


            	        switch (alt45) {
            	    	case 1 :
            	    	    // EolParserRules.g:363:36: '[' logicalExpression ']'
            	    	    {
            	    	    char_literal168=(Token)match(input,142,FOLLOW_142_in_postfixExpression1692); if (state.failed) return retval;
            	    	    if ( state.backtracking==0 ) {
            	    	    char_literal168_tree = (CommonTree)adaptor.create(char_literal168);
            	    	    root_0 = (CommonTree)adaptor.becomeRoot(char_literal168_tree, root_0);
            	    	    }
            	    	    pushFollow(FOLLOW_logicalExpression_in_postfixExpression1695);
            	    	    logicalExpression169=logicalExpression();

            	    	    state._fsp--;
            	    	    if (state.failed) return retval;
            	    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression169.getTree());
            	    	    char_literal170=(Token)match(input,143,FOLLOW_143_in_postfixExpression1697); if (state.failed) return retval;
            	    	    if ( state.backtracking==0 ) {
            	    	      if (root_0.getToken() != null) root_0.getToken().setType(ITEMSELECTOR);
            	    	    }

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop45;
            	        }
            	    } while (true);


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
    // $ANTLR end postfixExpression

    public static class itemSelectorExpression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start itemSelectorExpression
    // EolParserRules.g:372:1: itemSelectorExpression : primitiveExpression ( '[' primitiveExpression ']' )* ;
    public final Eml_EolParserRules.itemSelectorExpression_return itemSelectorExpression() throws RecognitionException {
        Eml_EolParserRules.itemSelectorExpression_return retval = new Eml_EolParserRules.itemSelectorExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal172=null;
        Token char_literal174=null;
        Eml_EolParserRules.primitiveExpression_return primitiveExpression171 = null;

        Eml_EolParserRules.primitiveExpression_return primitiveExpression173 = null;


        CommonTree char_literal172_tree=null;
        CommonTree char_literal174_tree=null;

        try {
            // EolParserRules.g:373:2: ( primitiveExpression ( '[' primitiveExpression ']' )* )
            // EolParserRules.g:373:4: primitiveExpression ( '[' primitiveExpression ']' )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_primitiveExpression_in_itemSelectorExpression1734);
            primitiveExpression171=primitiveExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, primitiveExpression171.getTree());
            // EolParserRules.g:373:24: ( '[' primitiveExpression ']' )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==142) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // EolParserRules.g:373:25: '[' primitiveExpression ']'
            	    {
            	    char_literal172=(Token)match(input,142,FOLLOW_142_in_itemSelectorExpression1737); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal172_tree = (CommonTree)adaptor.create(char_literal172);
            	    root_0 = (CommonTree)adaptor.becomeRoot(char_literal172_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_primitiveExpression_in_itemSelectorExpression1740);
            	    primitiveExpression173=primitiveExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, primitiveExpression173.getTree());
            	    char_literal174=(Token)match(input,143,FOLLOW_143_in_itemSelectorExpression1742); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	      if (root_0.getToken() != null) root_0.getToken().setType(ITEMSELECTOR);
            	    }

            	    }
            	    break;

            	default :
            	    break loop47;
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
    public final Eml_EolParserRules.featureCall_return featureCall() throws RecognitionException {
        Eml_EolParserRules.featureCall_return retval = new Eml_EolParserRules.featureCall_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Eml_EolParserRules.simpleFeatureCall_return simpleFeatureCall175 = null;

        Eml_EolParserRules.declarativeFeatureCall_return declarativeFeatureCall176 = null;



        try {
            // EolParserRules.g:378:2: ( simpleFeatureCall | declarativeFeatureCall )
            int alt48=2;
            alt48 = dfa48.predict(input);
            switch (alt48) {
                case 1 :
                    // EolParserRules.g:378:4: simpleFeatureCall
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_simpleFeatureCall_in_featureCall1761);
                    simpleFeatureCall175=simpleFeatureCall();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, simpleFeatureCall175.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:378:24: declarativeFeatureCall
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_declarativeFeatureCall_in_featureCall1765);
                    declarativeFeatureCall176=declarativeFeatureCall();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, declarativeFeatureCall176.getTree());

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
    public final Eml_EolParserRules.simpleFeatureCall_return simpleFeatureCall() throws RecognitionException {
        Eml_EolParserRules.simpleFeatureCall_return retval = new Eml_EolParserRules.simpleFeatureCall_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NAME177=null;
        Eml_EolParserRules.parameterList_return parameterList178 = null;


        CommonTree NAME177_tree=null;

        try {
            // EolParserRules.g:382:2: ( NAME ( parameterList )? )
            // EolParserRules.g:382:5: NAME ( parameterList )?
            {
            root_0 = (CommonTree)adaptor.nil();

            NAME177=(Token)match(input,NAME,FOLLOW_NAME_in_simpleFeatureCall1777); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME177_tree = (CommonTree)adaptor.create(NAME177);
            root_0 = (CommonTree)adaptor.becomeRoot(NAME177_tree, root_0);
            }
            // EolParserRules.g:382:11: ( parameterList )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==94) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // EolParserRules.g:0:0: parameterList
                    {
                    pushFollow(FOLLOW_parameterList_in_simpleFeatureCall1780);
                    parameterList178=parameterList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, parameterList178.getTree());

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
    public final Eml_EolParserRules.parameterList_return parameterList() throws RecognitionException {
        Eml_EolParserRules.parameterList_return retval = new Eml_EolParserRules.parameterList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal179=null;
        Token char_literal181=null;
        Token char_literal183=null;
        Eml_EolParserRules.logicalExpression_return logicalExpression180 = null;

        Eml_EolParserRules.logicalExpression_return logicalExpression182 = null;


        CommonTree char_literal179_tree=null;
        CommonTree char_literal181_tree=null;
        CommonTree char_literal183_tree=null;
        RewriteRuleTokenStream stream_95=new RewriteRuleTokenStream(adaptor,"token 95");
        RewriteRuleTokenStream stream_94=new RewriteRuleTokenStream(adaptor,"token 94");
        RewriteRuleTokenStream stream_86=new RewriteRuleTokenStream(adaptor,"token 86");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:387:2: ( '(' ( logicalExpression ( ',' logicalExpression )* )? ')' -> ^( PARAMETERS ( logicalExpression )* ) )
            // EolParserRules.g:387:4: '(' ( logicalExpression ( ',' logicalExpression )* )? ')'
            {
            char_literal179=(Token)match(input,94,FOLLOW_94_in_parameterList1795); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_94.add(char_literal179);

            // EolParserRules.g:387:8: ( logicalExpression ( ',' logicalExpression )* )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==FLOAT||LA51_0==INT||LA51_0==BOOLEAN||LA51_0==STRING||LA51_0==NAME||LA51_0==94||(LA51_0>=101 && LA51_0<=108)||LA51_0==138||LA51_0==141||(LA51_0>=145 && LA51_0<=146)) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // EolParserRules.g:387:9: logicalExpression ( ',' logicalExpression )*
                    {
                    pushFollow(FOLLOW_logicalExpression_in_parameterList1798);
                    logicalExpression180=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression180.getTree());
                    // EolParserRules.g:387:27: ( ',' logicalExpression )*
                    loop50:
                    do {
                        int alt50=2;
                        int LA50_0 = input.LA(1);

                        if ( (LA50_0==86) ) {
                            alt50=1;
                        }


                        switch (alt50) {
                    	case 1 :
                    	    // EolParserRules.g:387:28: ',' logicalExpression
                    	    {
                    	    char_literal181=(Token)match(input,86,FOLLOW_86_in_parameterList1801); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_86.add(char_literal181);

                    	    pushFollow(FOLLOW_logicalExpression_in_parameterList1803);
                    	    logicalExpression182=logicalExpression();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression182.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop50;
                        }
                    } while (true);


                    }
                    break;

            }

            char_literal183=(Token)match(input,95,FOLLOW_95_in_parameterList1809); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_95.add(char_literal183);



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
    public final Eml_EolParserRules.declarativeFeatureCall_return declarativeFeatureCall() throws RecognitionException {
        Eml_EolParserRules.declarativeFeatureCall_return retval = new Eml_EolParserRules.declarativeFeatureCall_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NAME184=null;
        Token char_literal185=null;
        Token char_literal187=null;
        Token char_literal189=null;
        Token char_literal191=null;
        Eml_EolParserRules.formalParameterList_return formalParameterList186 = null;

        Eml_EolParserRules.logicalExpression_return logicalExpression188 = null;

        Eml_EolParserRules.logicalExpression_return logicalExpression190 = null;


        CommonTree NAME184_tree=null;
        CommonTree char_literal185_tree=null;
        CommonTree char_literal187_tree=null;
        CommonTree char_literal189_tree=null;
        CommonTree char_literal191_tree=null;

        try {
            // EolParserRules.g:392:2: ( NAME '(' formalParameterList '|' logicalExpression ( ',' logicalExpression )* ')' )
            // EolParserRules.g:392:4: NAME '(' formalParameterList '|' logicalExpression ( ',' logicalExpression )* ')'
            {
            root_0 = (CommonTree)adaptor.nil();

            NAME184=(Token)match(input,NAME,FOLLOW_NAME_in_declarativeFeatureCall1831); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME184_tree = (CommonTree)adaptor.create(NAME184);
            root_0 = (CommonTree)adaptor.becomeRoot(NAME184_tree, root_0);
            }
            char_literal185=(Token)match(input,94,FOLLOW_94_in_declarativeFeatureCall1834); if (state.failed) return retval;
            pushFollow(FOLLOW_formalParameterList_in_declarativeFeatureCall1837);
            formalParameterList186=formalParameterList();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, formalParameterList186.getTree());
            char_literal187=(Token)match(input,144,FOLLOW_144_in_declarativeFeatureCall1839); if (state.failed) return retval;
            pushFollow(FOLLOW_logicalExpression_in_declarativeFeatureCall1842);
            logicalExpression188=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression188.getTree());
            // EolParserRules.g:392:58: ( ',' logicalExpression )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==86) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // EolParserRules.g:392:59: ',' logicalExpression
            	    {
            	    char_literal189=(Token)match(input,86,FOLLOW_86_in_declarativeFeatureCall1845); if (state.failed) return retval;
            	    pushFollow(FOLLOW_logicalExpression_in_declarativeFeatureCall1848);
            	    logicalExpression190=logicalExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression190.getTree());

            	    }
            	    break;

            	default :
            	    break loop52;
                }
            } while (true);

            char_literal191=(Token)match(input,95,FOLLOW_95_in_declarativeFeatureCall1852); if (state.failed) return retval;

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
    public final Eml_EolParserRules.newExpression_return newExpression() throws RecognitionException {
        Eml_EolParserRules.newExpression_return retval = new Eml_EolParserRules.newExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal192=null;
        Eml_EolParserRules.typeName_return tn = null;

        Eml_EolParserRules.parameterList_return parameterList193 = null;


        CommonTree string_literal192_tree=null;

        try {
            // EolParserRules.g:396:2: ( 'new' tn= typeName ( parameterList )? )
            // EolParserRules.g:396:4: 'new' tn= typeName ( parameterList )?
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal192=(Token)match(input,145,FOLLOW_145_in_newExpression1864); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal192_tree = (CommonTree)adaptor.create(string_literal192);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal192_tree, root_0);
            }
            pushFollow(FOLLOW_typeName_in_newExpression1869);
            tn=typeName();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, tn.getTree());
            if ( state.backtracking==0 ) {
              setTokenType(tn,TYPE);
            }
            // EolParserRules.g:396:48: ( parameterList )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==94) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // EolParserRules.g:0:0: parameterList
                    {
                    pushFollow(FOLLOW_parameterList_in_newExpression1873);
                    parameterList193=parameterList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, parameterList193.getTree());

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
    public final Eml_EolParserRules.variableDeclarationExpression_return variableDeclarationExpression() throws RecognitionException {
        Eml_EolParserRules.variableDeclarationExpression_return retval = new Eml_EolParserRules.variableDeclarationExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token n=null;
        Token string_literal194=null;
        Token NAME195=null;
        Token char_literal196=null;
        Eml_EolParserRules.typeName_return t = null;

        Eml_EolParserRules.parameterList_return parameterList197 = null;


        CommonTree n_tree=null;
        CommonTree string_literal194_tree=null;
        CommonTree NAME195_tree=null;
        CommonTree char_literal196_tree=null;
        RewriteRuleTokenStream stream_145=new RewriteRuleTokenStream(adaptor,"token 145");
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_146=new RewriteRuleTokenStream(adaptor,"token 146");
        RewriteRuleTokenStream stream_85=new RewriteRuleTokenStream(adaptor,"token 85");
        RewriteRuleSubtreeStream stream_typeName=new RewriteRuleSubtreeStream(adaptor,"rule typeName");
        RewriteRuleSubtreeStream stream_parameterList=new RewriteRuleSubtreeStream(adaptor,"rule parameterList");
        try {
            // EolParserRules.g:410:2: ( 'var' NAME ( ':' (n= 'new' )? t= typeName ( parameterList )? )? -> ^( VAR NAME ( typeName )? ( parameterList )? ) )
            // EolParserRules.g:410:4: 'var' NAME ( ':' (n= 'new' )? t= typeName ( parameterList )? )?
            {
            string_literal194=(Token)match(input,146,FOLLOW_146_in_variableDeclarationExpression1898); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_146.add(string_literal194);

            NAME195=(Token)match(input,NAME,FOLLOW_NAME_in_variableDeclarationExpression1900); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(NAME195);

            // EolParserRules.g:410:15: ( ':' (n= 'new' )? t= typeName ( parameterList )? )?
            int alt56=2;
            alt56 = dfa56.predict(input);
            switch (alt56) {
                case 1 :
                    // EolParserRules.g:410:16: ':' (n= 'new' )? t= typeName ( parameterList )?
                    {
                    char_literal196=(Token)match(input,85,FOLLOW_85_in_variableDeclarationExpression1903); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_85.add(char_literal196);

                    // EolParserRules.g:410:21: (n= 'new' )?
                    int alt54=2;
                    int LA54_0 = input.LA(1);

                    if ( (LA54_0==145) ) {
                        alt54=1;
                    }
                    switch (alt54) {
                        case 1 :
                            // EolParserRules.g:0:0: n= 'new'
                            {
                            n=(Token)match(input,145,FOLLOW_145_in_variableDeclarationExpression1907); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_145.add(n);


                            }
                            break;

                    }

                    pushFollow(FOLLOW_typeName_in_variableDeclarationExpression1912);
                    t=typeName();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_typeName.add(t.getTree());
                    if ( state.backtracking==0 ) {
                      setTokenType(t, TYPE);
                    }
                    // EolParserRules.g:410:65: ( parameterList )?
                    int alt55=2;
                    int LA55_0 = input.LA(1);

                    if ( (LA55_0==94) ) {
                        alt55=1;
                    }
                    switch (alt55) {
                        case 1 :
                            // EolParserRules.g:0:0: parameterList
                            {
                            pushFollow(FOLLOW_parameterList_in_variableDeclarationExpression1916);
                            parameterList197=parameterList();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_parameterList.add(parameterList197.getTree());

                            }
                            break;

                    }


                    }
                    break;

            }



            // AST REWRITE
            // elements: parameterList, typeName, NAME
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
    public final Eml_EolParserRules.literalSequentialCollection_return literalSequentialCollection() throws RecognitionException {
        Eml_EolParserRules.literalSequentialCollection_return retval = new Eml_EolParserRules.literalSequentialCollection_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set198=null;
        Token char_literal199=null;
        Token char_literal201=null;
        Eml_EolParserRules.expressionListOrRange_return expressionListOrRange200 = null;


        CommonTree set198_tree=null;
        CommonTree char_literal199_tree=null;
        CommonTree char_literal201_tree=null;

        try {
            // EolParserRules.g:415:2: ( ( 'Collection' | 'Sequence' | 'List' | 'Bag' | 'Set' | 'OrderedSet' ) '{' ( expressionListOrRange )? '}' )
            // EolParserRules.g:415:4: ( 'Collection' | 'Sequence' | 'List' | 'Bag' | 'Set' | 'OrderedSet' ) '{' ( expressionListOrRange )? '}'
            {
            root_0 = (CommonTree)adaptor.nil();

            set198=(Token)input.LT(1);
            set198=(Token)input.LT(1);
            if ( (input.LA(1)>=102 && input.LA(1)<=107) ) {
                input.consume();
                if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(set198), root_0);
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            char_literal199=(Token)match(input,89,FOLLOW_89_in_literalSequentialCollection1961); if (state.failed) return retval;
            // EolParserRules.g:415:69: ( expressionListOrRange )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==FLOAT||LA57_0==INT||LA57_0==BOOLEAN||LA57_0==STRING||LA57_0==NAME||LA57_0==94||(LA57_0>=101 && LA57_0<=108)||LA57_0==138||LA57_0==141||(LA57_0>=145 && LA57_0<=146)) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // EolParserRules.g:0:0: expressionListOrRange
                    {
                    pushFollow(FOLLOW_expressionListOrRange_in_literalSequentialCollection1965);
                    expressionListOrRange200=expressionListOrRange();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionListOrRange200.getTree());

                    }
                    break;

            }

            char_literal201=(Token)match(input,90,FOLLOW_90_in_literalSequentialCollection1968); if (state.failed) return retval;
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
    public final Eml_EolParserRules.expressionRange_return expressionRange() throws RecognitionException {
        Eml_EolParserRules.expressionRange_return retval = new Eml_EolParserRules.expressionRange_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal203=null;
        Eml_EolParserRules.logicalExpression_return logicalExpression202 = null;

        Eml_EolParserRules.logicalExpression_return logicalExpression204 = null;


        CommonTree string_literal203_tree=null;
        RewriteRuleTokenStream stream_POINT_POINT=new RewriteRuleTokenStream(adaptor,"token POINT_POINT");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:420:2: ( logicalExpression '..' logicalExpression -> ^( EXPRRANGE ( logicalExpression )+ ) )
            // EolParserRules.g:420:4: logicalExpression '..' logicalExpression
            {
            pushFollow(FOLLOW_logicalExpression_in_expressionRange1983);
            logicalExpression202=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression202.getTree());
            string_literal203=(Token)match(input,POINT_POINT,FOLLOW_POINT_POINT_in_expressionRange1985); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_POINT_POINT.add(string_literal203);

            pushFollow(FOLLOW_logicalExpression_in_expressionRange1987);
            logicalExpression204=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression204.getTree());


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
    public final Eml_EolParserRules.expressionList_return expressionList() throws RecognitionException {
        Eml_EolParserRules.expressionList_return retval = new Eml_EolParserRules.expressionList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal206=null;
        Eml_EolParserRules.logicalExpression_return logicalExpression205 = null;

        Eml_EolParserRules.logicalExpression_return logicalExpression207 = null;


        CommonTree char_literal206_tree=null;
        RewriteRuleTokenStream stream_86=new RewriteRuleTokenStream(adaptor,"token 86");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:425:2: ( logicalExpression ( ',' logicalExpression )* -> ^( EXPRLIST ( logicalExpression )+ ) )
            // EolParserRules.g:425:4: logicalExpression ( ',' logicalExpression )*
            {
            pushFollow(FOLLOW_logicalExpression_in_expressionList2009);
            logicalExpression205=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression205.getTree());
            // EolParserRules.g:425:22: ( ',' logicalExpression )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==86) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // EolParserRules.g:425:23: ',' logicalExpression
            	    {
            	    char_literal206=(Token)match(input,86,FOLLOW_86_in_expressionList2012); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_86.add(char_literal206);

            	    pushFollow(FOLLOW_logicalExpression_in_expressionList2014);
            	    logicalExpression207=logicalExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression207.getTree());

            	    }
            	    break;

            	default :
            	    break loop58;
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
    public final Eml_EolParserRules.expressionListOrRange_return expressionListOrRange() throws RecognitionException {
        Eml_EolParserRules.expressionListOrRange_return retval = new Eml_EolParserRules.expressionListOrRange_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Eml_EolParserRules.expressionRange_return expressionRange208 = null;

        Eml_EolParserRules.expressionList_return expressionList209 = null;



        try {
            // EolParserRules.g:430:2: ( expressionRange | expressionList )
            int alt59=2;
            alt59 = dfa59.predict(input);
            switch (alt59) {
                case 1 :
                    // EolParserRules.g:430:4: expressionRange
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_expressionRange_in_expressionListOrRange2038);
                    expressionRange208=expressionRange();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionRange208.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:430:22: expressionList
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_expressionList_in_expressionListOrRange2042);
                    expressionList209=expressionList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionList209.getTree());

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
    public final Eml_EolParserRules.literalMapCollection_return literalMapCollection() throws RecognitionException {
        Eml_EolParserRules.literalMapCollection_return retval = new Eml_EolParserRules.literalMapCollection_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal210=null;
        Token char_literal211=null;
        Token char_literal213=null;
        Eml_EolParserRules.keyvalExpressionList_return keyvalExpressionList212 = null;


        CommonTree string_literal210_tree=null;
        CommonTree char_literal211_tree=null;
        CommonTree char_literal213_tree=null;

        try {
            // EolParserRules.g:438:2: ( 'Map' '{' ( keyvalExpressionList )? '}' )
            // EolParserRules.g:438:4: 'Map' '{' ( keyvalExpressionList )? '}'
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal210=(Token)match(input,108,FOLLOW_108_in_literalMapCollection2061); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal210_tree = (CommonTree)adaptor.create(string_literal210);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal210_tree, root_0);
            }
            char_literal211=(Token)match(input,89,FOLLOW_89_in_literalMapCollection2064); if (state.failed) return retval;
            // EolParserRules.g:438:16: ( keyvalExpressionList )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==FLOAT||LA60_0==INT||LA60_0==BOOLEAN||LA60_0==STRING||LA60_0==NAME||LA60_0==94||(LA60_0>=101 && LA60_0<=108)||LA60_0==138||LA60_0==141||(LA60_0>=145 && LA60_0<=146)) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // EolParserRules.g:0:0: keyvalExpressionList
                    {
                    pushFollow(FOLLOW_keyvalExpressionList_in_literalMapCollection2067);
                    keyvalExpressionList212=keyvalExpressionList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, keyvalExpressionList212.getTree());

                    }
                    break;

            }

            char_literal213=(Token)match(input,90,FOLLOW_90_in_literalMapCollection2070); if (state.failed) return retval;
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
    public final Eml_EolParserRules.keyvalExpressionList_return keyvalExpressionList() throws RecognitionException {
        Eml_EolParserRules.keyvalExpressionList_return retval = new Eml_EolParserRules.keyvalExpressionList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal215=null;
        Eml_EolParserRules.keyvalExpression_return keyvalExpression214 = null;

        Eml_EolParserRules.keyvalExpression_return keyvalExpression216 = null;


        CommonTree char_literal215_tree=null;
        RewriteRuleTokenStream stream_86=new RewriteRuleTokenStream(adaptor,"token 86");
        RewriteRuleSubtreeStream stream_keyvalExpression=new RewriteRuleSubtreeStream(adaptor,"rule keyvalExpression");
        try {
            // EolParserRules.g:443:2: ( keyvalExpression ( ',' keyvalExpression )* -> ^( KEYVALLIST ( keyvalExpression )+ ) )
            // EolParserRules.g:443:4: keyvalExpression ( ',' keyvalExpression )*
            {
            pushFollow(FOLLOW_keyvalExpression_in_keyvalExpressionList2085);
            keyvalExpression214=keyvalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_keyvalExpression.add(keyvalExpression214.getTree());
            // EolParserRules.g:443:21: ( ',' keyvalExpression )*
            loop61:
            do {
                int alt61=2;
                int LA61_0 = input.LA(1);

                if ( (LA61_0==86) ) {
                    alt61=1;
                }


                switch (alt61) {
            	case 1 :
            	    // EolParserRules.g:443:22: ',' keyvalExpression
            	    {
            	    char_literal215=(Token)match(input,86,FOLLOW_86_in_keyvalExpressionList2088); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_86.add(char_literal215);

            	    pushFollow(FOLLOW_keyvalExpression_in_keyvalExpressionList2090);
            	    keyvalExpression216=keyvalExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_keyvalExpression.add(keyvalExpression216.getTree());

            	    }
            	    break;

            	default :
            	    break loop61;
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
    public final Eml_EolParserRules.keyvalExpression_return keyvalExpression() throws RecognitionException {
        Eml_EolParserRules.keyvalExpression_return retval = new Eml_EolParserRules.keyvalExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal218=null;
        Eml_EolParserRules.additiveExpression_return additiveExpression217 = null;

        Eml_EolParserRules.logicalExpression_return logicalExpression219 = null;


        CommonTree char_literal218_tree=null;
        RewriteRuleTokenStream stream_91=new RewriteRuleTokenStream(adaptor,"token 91");
        RewriteRuleSubtreeStream stream_additiveExpression=new RewriteRuleSubtreeStream(adaptor,"rule additiveExpression");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:449:2: ( additiveExpression '=' logicalExpression -> ^( KEYVAL additiveExpression logicalExpression ) )
            // EolParserRules.g:449:4: additiveExpression '=' logicalExpression
            {
            pushFollow(FOLLOW_additiveExpression_in_keyvalExpression2115);
            additiveExpression217=additiveExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_additiveExpression.add(additiveExpression217.getTree());
            char_literal218=(Token)match(input,91,FOLLOW_91_in_keyvalExpression2117); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_91.add(char_literal218);

            pushFollow(FOLLOW_logicalExpression_in_keyvalExpression2119);
            logicalExpression219=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression219.getTree());


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
    public final Eml_EolParserRules.primitiveExpression_return primitiveExpression() throws RecognitionException {
        Eml_EolParserRules.primitiveExpression_return retval = new Eml_EolParserRules.primitiveExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal227=null;
        Token char_literal229=null;
        Eml_EolParserRules.literalSequentialCollection_return literalSequentialCollection220 = null;

        Eml_EolParserRules.literalMapCollection_return literalMapCollection221 = null;

        Eml_EolParserRules.literal_return literal222 = null;

        Eml_EolParserRules.featureCall_return featureCall223 = null;

        Eml_EolParserRules.pathName_return pathName224 = null;

        Eml_EolParserRules.nativeType_return nativeType225 = null;

        Eml_EolParserRules.collectionType_return collectionType226 = null;

        Eml_EolParserRules.logicalExpression_return logicalExpression228 = null;

        Eml_EolParserRules.newExpression_return newExpression230 = null;

        Eml_EolParserRules.variableDeclarationExpression_return variableDeclarationExpression231 = null;


        CommonTree char_literal227_tree=null;
        CommonTree char_literal229_tree=null;

        try {
            // EolParserRules.g:453:2: ( literalSequentialCollection | literalMapCollection | literal | featureCall | pathName | nativeType | collectionType | '(' logicalExpression ')' | newExpression | variableDeclarationExpression )
            int alt62=10;
            alt62 = dfa62.predict(input);
            switch (alt62) {
                case 1 :
                    // EolParserRules.g:453:4: literalSequentialCollection
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_literalSequentialCollection_in_primitiveExpression2141);
                    literalSequentialCollection220=literalSequentialCollection();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, literalSequentialCollection220.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:453:34: literalMapCollection
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_literalMapCollection_in_primitiveExpression2145);
                    literalMapCollection221=literalMapCollection();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, literalMapCollection221.getTree());

                    }
                    break;
                case 3 :
                    // EolParserRules.g:453:57: literal
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_literal_in_primitiveExpression2149);
                    literal222=literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, literal222.getTree());

                    }
                    break;
                case 4 :
                    // EolParserRules.g:453:67: featureCall
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_featureCall_in_primitiveExpression2153);
                    featureCall223=featureCall();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, featureCall223.getTree());

                    }
                    break;
                case 5 :
                    // EolParserRules.g:453:81: pathName
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_pathName_in_primitiveExpression2157);
                    pathName224=pathName();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pathName224.getTree());

                    }
                    break;
                case 6 :
                    // EolParserRules.g:453:92: nativeType
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_nativeType_in_primitiveExpression2161);
                    nativeType225=nativeType();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nativeType225.getTree());

                    }
                    break;
                case 7 :
                    // EolParserRules.g:454:5: collectionType
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_collectionType_in_primitiveExpression2167);
                    collectionType226=collectionType();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, collectionType226.getTree());

                    }
                    break;
                case 8 :
                    // EolParserRules.g:454:23: '(' logicalExpression ')'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    char_literal227=(Token)match(input,94,FOLLOW_94_in_primitiveExpression2172); if (state.failed) return retval;
                    pushFollow(FOLLOW_logicalExpression_in_primitiveExpression2175);
                    logicalExpression228=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression228.getTree());
                    char_literal229=(Token)match(input,95,FOLLOW_95_in_primitiveExpression2177); if (state.failed) return retval;

                    }
                    break;
                case 9 :
                    // EolParserRules.g:455:5: newExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_newExpression_in_primitiveExpression2185);
                    newExpression230=newExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, newExpression230.getTree());

                    }
                    break;
                case 10 :
                    // EolParserRules.g:455:21: variableDeclarationExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_variableDeclarationExpression_in_primitiveExpression2189);
                    variableDeclarationExpression231=variableDeclarationExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, variableDeclarationExpression231.getTree());

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
    public final Eml_EolParserRules.literal_return literal() throws RecognitionException {
        Eml_EolParserRules.literal_return retval = new Eml_EolParserRules.literal_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set232=null;

        CommonTree set232_tree=null;

        try {
            // EolParserRules.g:459:2: ( STRING | INT | FLOAT | BOOLEAN )
            // EolParserRules.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set232=(Token)input.LT(1);
            if ( input.LA(1)==FLOAT||input.LA(1)==INT||input.LA(1)==BOOLEAN||input.LA(1)==STRING ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set232));
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

    // $ANTLR start synpred17_EolParserRules
    public final void synpred17_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:178:4: ( annotation )
        // EolParserRules.g:178:4: annotation
        {
        pushFollow(FOLLOW_annotation_in_synpred17_EolParserRules695);
        annotation();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred17_EolParserRules

    // $ANTLR start synpred29_EolParserRules
    public final void synpred29_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:217:4: ( '(' typeName ')' )
        // EolParserRules.g:217:4: '(' typeName ')'
        {
        match(input,94,FOLLOW_94_in_synpred29_EolParserRules857); if (state.failed) return ;
        pushFollow(FOLLOW_typeName_in_synpred29_EolParserRules862);
        typeName();

        state._fsp--;
        if (state.failed) return ;
        match(input,95,FOLLOW_95_in_synpred29_EolParserRules865); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred29_EolParserRules

    // $ANTLR start synpred30_EolParserRules
    public final void synpred30_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:224:4: ( statementA )
        // EolParserRules.g:224:4: statementA
        {
        pushFollow(FOLLOW_statementA_in_synpred30_EolParserRules888);
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
        pushFollow(FOLLOW_assignmentStatement_in_synpred31_EolParserRules902);
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
        pushFollow(FOLLOW_expressionStatement_in_synpred32_EolParserRules906);
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
        pushFollow(FOLLOW_elseStatement_in_synpred46_EolParserRules1060);
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
        match(input,NAME,FOLLOW_NAME_in_synpred53_EolParserRules1394); if (state.failed) return ;
        // EolParserRules.g:316:24: ( ',' NAME )*
        loop63:
        do {
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==86) ) {
                alt63=1;
            }


            switch (alt63) {
        	case 1 :
        	    // EolParserRules.g:316:25: ',' NAME
        	    {
        	    match(input,86,FOLLOW_86_in_synpred53_EolParserRules1397); if (state.failed) return ;
        	    match(input,NAME,FOLLOW_NAME_in_synpred53_EolParserRules1399); if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop63;
            }
        } while (true);


        }
    }
    // $ANTLR end synpred53_EolParserRules

    // $ANTLR start synpred67_EolParserRules
    public final void synpred67_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:340:24: ( ( '==' ( relationalExpression )? | '=' ( relationalExpression )? | ( '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression ) )
        // EolParserRules.g:340:24: ( '==' ( relationalExpression )? | '=' ( relationalExpression )? | ( '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression )
        {
        // EolParserRules.g:340:24: ( '==' ( relationalExpression )? | '=' ( relationalExpression )? | ( '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression )
        int alt68=3;
        switch ( input.LA(1) ) {
        case 131:
            {
            alt68=1;
            }
            break;
        case 91:
            {
            alt68=2;
            }
            break;
        case 132:
        case 133:
        case 134:
        case 135:
        case 136:
            {
            alt68=3;
            }
            break;
        default:
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 68, 0, input);

            throw nvae;
        }

        switch (alt68) {
            case 1 :
                // EolParserRules.g:340:25: '==' ( relationalExpression )?
                {
                match(input,131,FOLLOW_131_in_synpred67_EolParserRules1519); if (state.failed) return ;
                // EolParserRules.g:340:31: ( relationalExpression )?
                int alt66=2;
                int LA66_0 = input.LA(1);

                if ( (LA66_0==FLOAT||LA66_0==INT||LA66_0==BOOLEAN||LA66_0==STRING||LA66_0==NAME||LA66_0==94||(LA66_0>=101 && LA66_0<=108)||LA66_0==138||LA66_0==141||(LA66_0>=145 && LA66_0<=146)) ) {
                    alt66=1;
                }
                switch (alt66) {
                    case 1 :
                        // EolParserRules.g:0:0: relationalExpression
                        {
                        pushFollow(FOLLOW_relationalExpression_in_synpred67_EolParserRules1522);
                        relationalExpression();

                        state._fsp--;
                        if (state.failed) return ;

                        }
                        break;

                }


                }
                break;
            case 2 :
                // EolParserRules.g:340:55: '=' ( relationalExpression )?
                {
                match(input,91,FOLLOW_91_in_synpred67_EolParserRules1527); if (state.failed) return ;
                // EolParserRules.g:340:60: ( relationalExpression )?
                int alt67=2;
                int LA67_0 = input.LA(1);

                if ( (LA67_0==FLOAT||LA67_0==INT||LA67_0==BOOLEAN||LA67_0==STRING||LA67_0==NAME||LA67_0==94||(LA67_0>=101 && LA67_0<=108)||LA67_0==138||LA67_0==141||(LA67_0>=145 && LA67_0<=146)) ) {
                    alt67=1;
                }
                switch (alt67) {
                    case 1 :
                        // EolParserRules.g:0:0: relationalExpression
                        {
                        pushFollow(FOLLOW_relationalExpression_in_synpred67_EolParserRules1530);
                        relationalExpression();

                        state._fsp--;
                        if (state.failed) return ;

                        }
                        break;

                }


                }
                break;
            case 3 :
                // EolParserRules.g:341:24: ( '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression
                {
                if ( (input.LA(1)>=132 && input.LA(1)<=136) ) {
                    input.consume();
                    state.errorRecovery=false;state.failed=false;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    MismatchedSetException mse = new MismatchedSetException(null,input);
                    throw mse;
                }

                pushFollow(FOLLOW_additiveExpression_in_synpred67_EolParserRules1571);
                additiveExpression();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        }
    }
    // $ANTLR end synpred67_EolParserRules

    // $ANTLR start synpred86_EolParserRules
    public final void synpred86_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:410:16: ( ':' ( 'new' )? typeName ( parameterList )? )
        // EolParserRules.g:410:16: ':' ( 'new' )? typeName ( parameterList )?
        {
        match(input,85,FOLLOW_85_in_synpred86_EolParserRules1903); if (state.failed) return ;
        // EolParserRules.g:410:21: ( 'new' )?
        int alt71=2;
        int LA71_0 = input.LA(1);

        if ( (LA71_0==145) ) {
            alt71=1;
        }
        switch (alt71) {
            case 1 :
                // EolParserRules.g:0:0: 'new'
                {
                match(input,145,FOLLOW_145_in_synpred86_EolParserRules1907); if (state.failed) return ;

                }
                break;

        }

        pushFollow(FOLLOW_typeName_in_synpred86_EolParserRules1912);
        typeName();

        state._fsp--;
        if (state.failed) return ;
        // EolParserRules.g:410:65: ( parameterList )?
        int alt72=2;
        int LA72_0 = input.LA(1);

        if ( (LA72_0==94) ) {
            alt72=1;
        }
        switch (alt72) {
            case 1 :
                // EolParserRules.g:0:0: parameterList
                {
                pushFollow(FOLLOW_parameterList_in_synpred86_EolParserRules1916);
                parameterList();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        }
    }
    // $ANTLR end synpred86_EolParserRules

    // $ANTLR start synpred94_EolParserRules
    public final void synpred94_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:430:4: ( expressionRange )
        // EolParserRules.g:430:4: expressionRange
        {
        pushFollow(FOLLOW_expressionRange_in_synpred94_EolParserRules2038);
        expressionRange();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred94_EolParserRules

    // $ANTLR start synpred100_EolParserRules
    public final void synpred100_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:453:67: ( featureCall )
        // EolParserRules.g:453:67: featureCall
        {
        pushFollow(FOLLOW_featureCall_in_synpred100_EolParserRules2153);
        featureCall();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred100_EolParserRules

    // $ANTLR start synpred101_EolParserRules
    public final void synpred101_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:453:81: ( pathName )
        // EolParserRules.g:453:81: pathName
        {
        pushFollow(FOLLOW_pathName_in_synpred101_EolParserRules2157);
        pathName();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred101_EolParserRules

    // Delegated rules

    public final boolean synpred67_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred67_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
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
    public final boolean synpred17_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred17_EolParserRules_fragment(); // can never throw exception
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
    public final boolean synpred101_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred101_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred94_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred94_EolParserRules_fragment(); // can never throw exception
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
    public final boolean synpred86_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred86_EolParserRules_fragment(); // can never throw exception
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


    protected DFA22 dfa22 = new DFA22(this);
    protected DFA23 dfa23 = new DFA23(this);
    protected DFA24 dfa24 = new DFA24(this);
    protected DFA35 dfa35 = new DFA35(this);
    protected DFA48 dfa48 = new DFA48(this);
    protected DFA56 dfa56 = new DFA56(this);
    protected DFA59 dfa59 = new DFA59(this);
    protected DFA62 dfa62 = new DFA62(this);
    static final String DFA22_eotS =
        "\70\uffff";
    static final String DFA22_eofS =
        "\1\2\67\uffff";
    static final String DFA22_minS =
        "\1\4\1\0\66\uffff";
    static final String DFA22_maxS =
        "\1\u009c\1\0\66\uffff";
    static final String DFA22_acceptS =
        "\2\uffff\1\2\64\uffff\1\1";
    static final String DFA22_specialS =
        "\1\uffff\1\0\66\uffff}>";
    static final String[] DFA22_transitionS = {
            "\1\2\3\uffff\5\2\1\uffff\1\2\4\uffff\1\2\3\uffff\1\2\74\uffff"+
            "\3\2\2\uffff\5\2\1\1\1\2\1\uffff\1\2\3\uffff\14\2\3\uffff\41"+
            "\2\1\uffff\2\2\1\uffff\1\2\1\uffff\2\2",
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
                        if ( (synpred29_EolParserRules()) ) {s = 55;}

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
        "\1\u0092\15\uffff\1\0\7\uffff";
    static final String DFA23_acceptS =
        "\1\uffff\1\1\16\uffff\1\2\5\uffff";
    static final String DFA23_specialS =
        "\16\uffff\1\0\7\uffff}>";
    static final String[] DFA23_transitionS = {
            "\1\1\3\uffff\1\1\3\uffff\1\1\1\uffff\1\1\4\uffff\1\1\112\uffff"+
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
        "\1\u0092\11\0\10\uffff";
    static final String DFA24_acceptS =
        "\12\uffff\1\3\1\4\1\5\1\6\1\7\1\10\1\1\1\2";
    static final String DFA24_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\10\uffff}>";
    static final String[] DFA24_transitionS = {
            "\1\4\3\uffff\1\4\3\uffff\1\4\1\uffff\1\4\4\uffff\1\5\112\uffff"+
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
        "\1\u0092\1\0\26\uffff";
    static final String DFA35_acceptS =
        "\2\uffff\1\2\24\uffff\1\1";
    static final String DFA35_specialS =
        "\1\uffff\1\0\26\uffff}>";
    static final String[] DFA35_transitionS = {
            "\1\2\3\uffff\1\2\3\uffff\1\2\1\uffff\1\2\4\uffff\1\1\105\uffff"+
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
    static final String DFA48_eotS =
        "\10\uffff";
    static final String DFA48_eofS =
        "\1\uffff\1\3\6\uffff";
    static final String DFA48_minS =
        "\1\23\2\4\1\uffff\1\11\1\4\1\uffff\1\11";
    static final String DFA48_maxS =
        "\1\23\1\u0097\1\u0092\1\uffff\1\u0090\1\u0092\1\uffff\1\u0090";
    static final String DFA48_acceptS =
        "\3\uffff\1\1\2\uffff\1\2\1\uffff";
    static final String DFA48_specialS =
        "\10\uffff}>";
    static final String[] DFA48_transitionS = {
            "\1\1",
            "\1\3\3\uffff\5\3\1\uffff\1\3\4\uffff\1\3\3\uffff\1\3\74\uffff"+
            "\3\3\3\uffff\4\3\1\2\1\3\1\uffff\1\3\3\uffff\11\3\1\uffff\2"+
            "\3\3\uffff\34\3\1\uffff\4\3\2\uffff\1\3",
            "\1\3\3\uffff\1\3\3\uffff\1\3\1\uffff\1\3\4\uffff\1\4\112\uffff"+
            "\2\3\5\uffff\10\3\35\uffff\1\3\2\uffff\1\3\3\uffff\2\3",
            "",
            "\1\3\1\uffff\1\3\111\uffff\1\6\1\5\4\uffff\1\3\2\uffff\2\3\2"+
            "\uffff\3\3\32\uffff\16\3\1\uffff\1\3\1\uffff\1\6",
            "\1\3\3\uffff\1\3\3\uffff\1\3\1\uffff\1\3\4\uffff\1\7\112\uffff"+
            "\1\3\6\uffff\10\3\35\uffff\1\3\2\uffff\1\3\3\uffff\2\3",
            "",
            "\1\3\1\uffff\1\3\111\uffff\1\6\1\5\4\uffff\1\3\2\uffff\2\3\2"+
            "\uffff\3\3\32\uffff\16\3\1\uffff\1\3\1\uffff\1\6"
    };

    static final short[] DFA48_eot = DFA.unpackEncodedString(DFA48_eotS);
    static final short[] DFA48_eof = DFA.unpackEncodedString(DFA48_eofS);
    static final char[] DFA48_min = DFA.unpackEncodedStringToUnsignedChars(DFA48_minS);
    static final char[] DFA48_max = DFA.unpackEncodedStringToUnsignedChars(DFA48_maxS);
    static final short[] DFA48_accept = DFA.unpackEncodedString(DFA48_acceptS);
    static final short[] DFA48_special = DFA.unpackEncodedString(DFA48_specialS);
    static final short[][] DFA48_transition;

    static {
        int numStates = DFA48_transitionS.length;
        DFA48_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA48_transition[i] = DFA.unpackEncodedString(DFA48_transitionS[i]);
        }
    }

    class DFA48 extends DFA {

        public DFA48(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 48;
            this.eot = DFA48_eot;
            this.eof = DFA48_eof;
            this.min = DFA48_min;
            this.max = DFA48_max;
            this.accept = DFA48_accept;
            this.special = DFA48_special;
            this.transition = DFA48_transition;
        }
        public String getDescription() {
            return "377:1: featureCall : ( simpleFeatureCall | declarativeFeatureCall );";
        }
    }
    static final String DFA56_eotS =
        "\22\uffff";
    static final String DFA56_eofS =
        "\2\2\20\uffff";
    static final String DFA56_minS =
        "\2\4\1\uffff\3\0\1\136\1\23\1\uffff\1\16\1\0\1\136\1\0\1\137\1\16"+
        "\1\0\1\137\1\0";
    static final String DFA56_maxS =
        "\1\u0097\1\u0092\1\uffff\3\0\1\136\1\154\1\uffff\1\16\1\0\1\136"+
        "\1\0\1\137\1\16\1\0\1\137\1\0";
    static final String DFA56_acceptS =
        "\2\uffff\1\2\5\uffff\1\1\11\uffff";
    static final String DFA56_specialS =
        "\3\uffff\1\3\1\6\1\2\4\uffff\1\4\1\uffff\1\1\2\uffff\1\0\1\uffff"+
        "\1\5}>";
    static final String[] DFA56_transitionS = {
            "\1\2\3\uffff\5\2\1\uffff\1\2\4\uffff\1\2\3\uffff\1\2\74\uffff"+
            "\1\2\1\1\1\2\3\uffff\6\2\1\uffff\1\2\3\uffff\11\2\1\uffff\2"+
            "\2\3\uffff\34\2\1\uffff\4\2\2\uffff\1\2",
            "\1\2\3\uffff\1\2\3\uffff\1\2\1\uffff\1\2\4\uffff\1\5\106\uffff"+
            "\1\2\3\uffff\1\2\6\uffff\1\6\6\3\1\4\1\2\1\uffff\4\2\1\uffff"+
            "\11\2\15\uffff\1\2\2\uffff\1\2\3\uffff\1\7\1\2",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\11",
            "\1\12\121\uffff\1\13\7\14",
            "",
            "\1\15",
            "\1\uffff",
            "\1\16",
            "\1\uffff",
            "\1\17",
            "\1\20",
            "\1\uffff",
            "\1\21",
            "\1\uffff"
    };

    static final short[] DFA56_eot = DFA.unpackEncodedString(DFA56_eotS);
    static final short[] DFA56_eof = DFA.unpackEncodedString(DFA56_eofS);
    static final char[] DFA56_min = DFA.unpackEncodedStringToUnsignedChars(DFA56_minS);
    static final char[] DFA56_max = DFA.unpackEncodedStringToUnsignedChars(DFA56_maxS);
    static final short[] DFA56_accept = DFA.unpackEncodedString(DFA56_acceptS);
    static final short[] DFA56_special = DFA.unpackEncodedString(DFA56_specialS);
    static final short[][] DFA56_transition;

    static {
        int numStates = DFA56_transitionS.length;
        DFA56_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA56_transition[i] = DFA.unpackEncodedString(DFA56_transitionS[i]);
        }
    }

    class DFA56 extends DFA {

        public DFA56(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 56;
            this.eot = DFA56_eot;
            this.eof = DFA56_eof;
            this.min = DFA56_min;
            this.max = DFA56_max;
            this.accept = DFA56_accept;
            this.special = DFA56_special;
            this.transition = DFA56_transition;
        }
        public String getDescription() {
            return "410:15: ( ':' (n= 'new' )? t= typeName ( parameterList )? )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA56_15 = input.LA(1);

                         
                        int index56_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_EolParserRules()) ) {s = 8;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index56_15);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA56_12 = input.LA(1);

                         
                        int index56_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_EolParserRules()) ) {s = 8;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index56_12);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA56_5 = input.LA(1);

                         
                        int index56_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_EolParserRules()) ) {s = 8;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index56_5);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA56_3 = input.LA(1);

                         
                        int index56_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_EolParserRules()) ) {s = 8;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index56_3);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA56_10 = input.LA(1);

                         
                        int index56_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_EolParserRules()) ) {s = 8;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index56_10);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA56_17 = input.LA(1);

                         
                        int index56_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_EolParserRules()) ) {s = 8;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index56_17);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA56_4 = input.LA(1);

                         
                        int index56_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_EolParserRules()) ) {s = 8;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index56_4);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 56, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA59_eotS =
        "\14\uffff";
    static final String DFA59_eofS =
        "\14\uffff";
    static final String DFA59_minS =
        "\1\4\11\0\2\uffff";
    static final String DFA59_maxS =
        "\1\u0092\11\0\2\uffff";
    static final String DFA59_acceptS =
        "\12\uffff\1\1\1\2";
    static final String DFA59_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\2\uffff}>";
    static final String[] DFA59_transitionS = {
            "\1\4\3\uffff\1\4\3\uffff\1\4\1\uffff\1\4\4\uffff\1\5\112\uffff"+
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

    static final short[] DFA59_eot = DFA.unpackEncodedString(DFA59_eotS);
    static final short[] DFA59_eof = DFA.unpackEncodedString(DFA59_eofS);
    static final char[] DFA59_min = DFA.unpackEncodedStringToUnsignedChars(DFA59_minS);
    static final char[] DFA59_max = DFA.unpackEncodedStringToUnsignedChars(DFA59_maxS);
    static final short[] DFA59_accept = DFA.unpackEncodedString(DFA59_acceptS);
    static final short[] DFA59_special = DFA.unpackEncodedString(DFA59_specialS);
    static final short[][] DFA59_transition;

    static {
        int numStates = DFA59_transitionS.length;
        DFA59_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA59_transition[i] = DFA.unpackEncodedString(DFA59_transitionS[i]);
        }
    }

    class DFA59 extends DFA {

        public DFA59(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 59;
            this.eot = DFA59_eot;
            this.eof = DFA59_eof;
            this.min = DFA59_min;
            this.max = DFA59_max;
            this.accept = DFA59_accept;
            this.special = DFA59_special;
            this.transition = DFA59_transition;
        }
        public String getDescription() {
            return "429:1: expressionListOrRange : ( expressionRange | expressionList );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA59_1 = input.LA(1);

                         
                        int index59_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred94_EolParserRules()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index59_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA59_2 = input.LA(1);

                         
                        int index59_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred94_EolParserRules()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index59_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA59_3 = input.LA(1);

                         
                        int index59_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred94_EolParserRules()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index59_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA59_4 = input.LA(1);

                         
                        int index59_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred94_EolParserRules()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index59_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA59_5 = input.LA(1);

                         
                        int index59_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred94_EolParserRules()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index59_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA59_6 = input.LA(1);

                         
                        int index59_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred94_EolParserRules()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index59_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA59_7 = input.LA(1);

                         
                        int index59_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred94_EolParserRules()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index59_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA59_8 = input.LA(1);

                         
                        int index59_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred94_EolParserRules()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index59_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA59_9 = input.LA(1);

                         
                        int index59_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred94_EolParserRules()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index59_9);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 59, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA62_eotS =
        "\16\uffff";
    static final String DFA62_eofS =
        "\1\uffff\2\12\13\uffff";
    static final String DFA62_minS =
        "\3\4\1\uffff\1\0\11\uffff";
    static final String DFA62_maxS =
        "\1\u0092\2\u0097\1\uffff\1\0\11\uffff";
    static final String DFA62_acceptS =
        "\3\uffff\1\3\1\uffff\1\6\1\10\1\11\1\12\1\1\1\7\1\2\1\4\1\5";
    static final String DFA62_specialS =
        "\4\uffff\1\0\11\uffff}>";
    static final String[] DFA62_transitionS = {
            "\1\3\3\uffff\1\3\3\uffff\1\3\1\uffff\1\3\4\uffff\1\4\112\uffff"+
            "\1\6\6\uffff\1\5\6\1\1\2\44\uffff\1\7\1\10",
            "\1\12\3\uffff\5\12\1\uffff\1\12\4\uffff\1\12\3\uffff\1\12\74"+
            "\uffff\3\12\2\uffff\1\11\6\12\1\uffff\1\12\3\uffff\11\12\1\uffff"+
            "\2\12\3\uffff\34\12\1\uffff\4\12\2\uffff\1\12",
            "\1\12\3\uffff\5\12\1\uffff\1\12\4\uffff\1\12\3\uffff\1\12\74"+
            "\uffff\3\12\2\uffff\1\13\6\12\1\uffff\1\12\3\uffff\11\12\1\uffff"+
            "\2\12\3\uffff\34\12\1\uffff\4\12\2\uffff\1\12",
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

    static final short[] DFA62_eot = DFA.unpackEncodedString(DFA62_eotS);
    static final short[] DFA62_eof = DFA.unpackEncodedString(DFA62_eofS);
    static final char[] DFA62_min = DFA.unpackEncodedStringToUnsignedChars(DFA62_minS);
    static final char[] DFA62_max = DFA.unpackEncodedStringToUnsignedChars(DFA62_maxS);
    static final short[] DFA62_accept = DFA.unpackEncodedString(DFA62_acceptS);
    static final short[] DFA62_special = DFA.unpackEncodedString(DFA62_specialS);
    static final short[][] DFA62_transition;

    static {
        int numStates = DFA62_transitionS.length;
        DFA62_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA62_transition[i] = DFA.unpackEncodedString(DFA62_transitionS[i]);
        }
    }

    class DFA62 extends DFA {

        public DFA62(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 62;
            this.eot = DFA62_eot;
            this.eof = DFA62_eof;
            this.min = DFA62_min;
            this.max = DFA62_max;
            this.accept = DFA62_accept;
            this.special = DFA62_special;
            this.transition = DFA62_transition;
        }
        public String getDescription() {
            return "452:1: primitiveExpression : ( literalSequentialCollection | literalMapCollection | literal | featureCall | pathName | nativeType | collectionType | '(' logicalExpression ')' | newExpression | variableDeclarationExpression );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA62_4 = input.LA(1);

                         
                        int index62_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred100_EolParserRules()) ) {s = 12;}

                        else if ( (synpred101_EolParserRules()) ) {s = 13;}

                         
                        input.seek(index62_4);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 62, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_operationDeclaration_in_operationDeclarationOrAnnotationBlock246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationBlock_in_operationDeclarationOrAnnotationBlock248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_83_in_modelDeclaration259 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_modelDeclaration261 = new BitSet(new long[]{0x0000000000000000L,0x0000000003900000L});
    public static final BitSet FOLLOW_modelAlias_in_modelDeclaration263 = new BitSet(new long[]{0x0000000000000000L,0x0000000003100000L});
    public static final BitSet FOLLOW_modelDriver_in_modelDeclaration266 = new BitSet(new long[]{0x0000000000000000L,0x0000000002100000L});
    public static final BitSet FOLLOW_modelDeclarationParameters_in_modelDeclaration269 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_84_in_modelDeclaration272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_85_in_modelNamespace310 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_modelNamespace312 = new BitSet(new long[]{0x0000000000000002L,0x0000000000400000L});
    public static final BitSet FOLLOW_86_in_modelNamespace315 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_modelNamespace317 = new BitSet(new long[]{0x0000000000000002L,0x0000000000400000L});
    public static final BitSet FOLLOW_87_in_modelAlias341 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_modelAlias343 = new BitSet(new long[]{0x0000000000000002L,0x0000000000400000L});
    public static final BitSet FOLLOW_86_in_modelAlias346 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_modelAlias348 = new BitSet(new long[]{0x0000000000000002L,0x0000000000400000L});
    public static final BitSet FOLLOW_88_in_modelDriver372 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_modelDriver374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_89_in_modelDeclarationParameters394 = new BitSet(new long[]{0x0000000000080000L,0x0000000004400000L});
    public static final BitSet FOLLOW_modelDeclarationParameter_in_modelDeclarationParameters396 = new BitSet(new long[]{0x0000000000000000L,0x0000000004400000L});
    public static final BitSet FOLLOW_86_in_modelDeclarationParameters400 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_modelDeclarationParameter_in_modelDeclarationParameters402 = new BitSet(new long[]{0x0000000000000000L,0x0000000004400000L});
    public static final BitSet FOLLOW_90_in_modelDeclarationParameters406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_modelDeclarationParameter430 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_91_in_modelDeclarationParameter432 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_STRING_in_modelDeclarationParameter434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_92_in_operationDeclaration460 = new BitSet(new long[]{0x0000000000080000L,0x00001FE000000000L});
    public static final BitSet FOLLOW_93_in_operationDeclaration462 = new BitSet(new long[]{0x0000000000080000L,0x00001FE000000000L});
    public static final BitSet FOLLOW_typeName_in_operationDeclaration468 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_operationDeclaration476 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_94_in_operationDeclaration478 = new BitSet(new long[]{0x0000000000080000L,0x0000000080000000L});
    public static final BitSet FOLLOW_formalParameterList_in_operationDeclaration480 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_operationDeclaration483 = new BitSet(new long[]{0x0000000000000000L,0x0000000002200000L});
    public static final BitSet FOLLOW_85_in_operationDeclaration486 = new BitSet(new long[]{0x0000000000080000L,0x00001FE000000000L});
    public static final BitSet FOLLOW_typeName_in_operationDeclaration490 = new BitSet(new long[]{0x0000000000000000L,0x0000000002200000L});
    public static final BitSet FOLLOW_statementBlock_in_operationDeclaration496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_96_in_importStatement533 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_STRING_in_importStatement536 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_84_in_importStatement538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_block553 = new BitSet(new long[]{0x0000000000085112L,0x1FF1BFE040000000L,0x0000000000062400L});
    public static final BitSet FOLLOW_89_in_statementBlock575 = new BitSet(new long[]{0x0000000000085110L,0x1FF1BFE040000000L,0x0000000000062400L});
    public static final BitSet FOLLOW_block_in_statementBlock578 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_90_in_statementBlock580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_formalParameter592 = new BitSet(new long[]{0x0000000000000002L,0x0000000000200000L});
    public static final BitSet FOLLOW_85_in_formalParameter595 = new BitSet(new long[]{0x0000000000080000L,0x00001FE000000000L});
    public static final BitSet FOLLOW_typeName_in_formalParameter599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_formalParameter_in_formalParameterList628 = new BitSet(new long[]{0x0000000000000002L,0x0000000000400000L});
    public static final BitSet FOLLOW_86_in_formalParameterList631 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_formalParameter_in_formalParameterList633 = new BitSet(new long[]{0x0000000000000002L,0x0000000000400000L});
    public static final BitSet FOLLOW_97_in_executableAnnotation656 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_executableAnnotation658 = new BitSet(new long[]{0x0000000000085110L,0x00001FE040000000L,0x0000000000062400L});
    public static final BitSet FOLLOW_logicalExpression_in_executableAnnotation660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Annotation_in_annotation682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_executableAnnotation_in_annotation684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotation_in_annotationBlock695 = new BitSet(new long[]{0x0000000000800002L,0x0000000200000000L});
    public static final BitSet FOLLOW_pathName_in_typeName718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nativeType_in_typeName722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectionType_in_typeName726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_pathName743 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_98_in_pathName746 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_packagedType_in_pathName755 = new BitSet(new long[]{0x0000000000000002L,0x0000000800000000L});
    public static final BitSet FOLLOW_99_in_pathName760 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_pathName765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_packagedType787 = new BitSet(new long[]{0x0000000000000002L,0x0000001000000000L});
    public static final BitSet FOLLOW_100_in_packagedType790 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_packagedType795 = new BitSet(new long[]{0x0000000000000002L,0x0000001000000000L});
    public static final BitSet FOLLOW_101_in_nativeType811 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_94_in_nativeType814 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_STRING_in_nativeType817 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_nativeType819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_collectionType837 = new BitSet(new long[]{0x0000000000000002L,0x0000000040000000L});
    public static final BitSet FOLLOW_94_in_collectionType857 = new BitSet(new long[]{0x0000000000080000L,0x00001FE000000000L});
    public static final BitSet FOLLOW_typeName_in_collectionType862 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_collectionType865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementA_in_statement888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementB_in_statement892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignmentStatement_in_statementA902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionStatement_in_statementA906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_forStatement_in_statementA910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStatement_in_statementA916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_whileStatement_in_statementA920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_switchStatement_in_statementA924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_returnStatement_in_statementA928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_breakStatement_in_statementA932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_breakAllStatement_in_statementB944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_returnStatement_in_statementB948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_transactionStatement_in_statementB952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_abortStatement_in_statementB958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_continueStatement_in_statementB962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_throwStatement_in_statementB966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_deleteStatement_in_statementB972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_statementOrStatementBlock983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementBlock_in_statementOrStatementBlock987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_85_in_expressionOrStatementBlock996 = new BitSet(new long[]{0x0000000000085110L,0x00001FE040000000L,0x0000000000062400L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionOrStatementBlock999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementBlock_in_expressionOrStatementBlock1003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_109_in_forStatement1014 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_94_in_forStatement1016 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_formalParameter_in_forStatement1018 = new BitSet(new long[]{0x0000000000000000L,0x0000400000000000L});
    public static final BitSet FOLLOW_110_in_forStatement1020 = new BitSet(new long[]{0x0000000000085110L,0x00001FE040000000L,0x0000000000062400L});
    public static final BitSet FOLLOW_logicalExpression_in_forStatement1022 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_forStatement1024 = new BitSet(new long[]{0x0000000000085110L,0x1FF1BFE042200000L,0x0000000000062400L});
    public static final BitSet FOLLOW_statementOrStatementBlock_in_forStatement1026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_111_in_ifStatement1050 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_94_in_ifStatement1052 = new BitSet(new long[]{0x0000000000085110L,0x00001FE040000000L,0x0000000000062400L});
    public static final BitSet FOLLOW_logicalExpression_in_ifStatement1054 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_ifStatement1056 = new BitSet(new long[]{0x0000000000085110L,0x1FF1BFE042200000L,0x0000000000062400L});
    public static final BitSet FOLLOW_statementOrStatementBlock_in_ifStatement1058 = new BitSet(new long[]{0x0000000000000002L,0x0008000000000000L});
    public static final BitSet FOLLOW_elseStatement_in_ifStatement1060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_112_in_switchStatement1087 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_94_in_switchStatement1089 = new BitSet(new long[]{0x0000000000085110L,0x00001FE040000000L,0x0000000000062400L});
    public static final BitSet FOLLOW_logicalExpression_in_switchStatement1091 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_switchStatement1093 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_89_in_switchStatement1095 = new BitSet(new long[]{0x0000000000000000L,0x0006000004000000L});
    public static final BitSet FOLLOW_caseStatement_in_switchStatement1097 = new BitSet(new long[]{0x0000000000000000L,0x0006000004000000L});
    public static final BitSet FOLLOW_defaultStatement_in_switchStatement1100 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_90_in_switchStatement1103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_113_in_caseStatement1130 = new BitSet(new long[]{0x0000000000085110L,0x00001FE040000000L,0x0000000000062400L});
    public static final BitSet FOLLOW_logicalExpression_in_caseStatement1132 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_85_in_caseStatement1134 = new BitSet(new long[]{0x0000000000085110L,0x1FF1BFE040000000L,0x0000000000062400L});
    public static final BitSet FOLLOW_block_in_caseStatement1136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_114_in_defaultStatement1159 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_85_in_defaultStatement1161 = new BitSet(new long[]{0x0000000000085110L,0x1FF1BFE040000000L,0x0000000000062400L});
    public static final BitSet FOLLOW_block_in_defaultStatement1163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_115_in_elseStatement1184 = new BitSet(new long[]{0x0000000000085110L,0x1FF1BFE042200000L,0x0000000000062400L});
    public static final BitSet FOLLOW_statementOrStatementBlock_in_elseStatement1187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_116_in_whileStatement1200 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_94_in_whileStatement1202 = new BitSet(new long[]{0x0000000000085110L,0x00001FE040000000L,0x0000000000062400L});
    public static final BitSet FOLLOW_logicalExpression_in_whileStatement1204 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_whileStatement1206 = new BitSet(new long[]{0x0000000000085110L,0x1FF1BFE042200000L,0x0000000000062400L});
    public static final BitSet FOLLOW_statementOrStatementBlock_in_whileStatement1208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_117_in_returnStatement1230 = new BitSet(new long[]{0x0000000000085110L,0x00001FE040100000L,0x0000000000062400L});
    public static final BitSet FOLLOW_logicalExpression_in_returnStatement1232 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_84_in_returnStatement1235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_118_in_throwStatement1256 = new BitSet(new long[]{0x0000000000085110L,0x00001FE040100000L,0x0000000000062400L});
    public static final BitSet FOLLOW_logicalExpression_in_throwStatement1258 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_84_in_throwStatement1261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_119_in_deleteStatement1282 = new BitSet(new long[]{0x0000000000085110L,0x00001FE040100000L,0x0000000000062400L});
    public static final BitSet FOLLOW_logicalExpression_in_deleteStatement1284 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_84_in_deleteStatement1287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_120_in_breakStatement1311 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_84_in_breakStatement1313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_121_in_breakAllStatement1331 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_84_in_breakAllStatement1333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_122_in_continueStatement1351 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_84_in_continueStatement1353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_123_in_abortStatement1371 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_84_in_abortStatement1373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_124_in_transactionStatement1391 = new BitSet(new long[]{0x0000000000085110L,0x1FF1BFE042200000L,0x0000000000062400L});
    public static final BitSet FOLLOW_NAME_in_transactionStatement1394 = new BitSet(new long[]{0x0000000000085110L,0x1FF1BFE042600000L,0x0000000000062400L});
    public static final BitSet FOLLOW_86_in_transactionStatement1397 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_transactionStatement1399 = new BitSet(new long[]{0x0000000000085110L,0x1FF1BFE042600000L,0x0000000000062400L});
    public static final BitSet FOLLOW_statementOrStatementBlock_in_transactionStatement1405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logicalExpression_in_assignmentStatement1434 = new BitSet(new long[]{0x0000000000000000L,0x6000000000000000L});
    public static final BitSet FOLLOW_125_in_assignmentStatement1439 = new BitSet(new long[]{0x0000000000085110L,0x00001FE040000000L,0x0000000000062400L});
    public static final BitSet FOLLOW_126_in_assignmentStatement1446 = new BitSet(new long[]{0x0000000000085110L,0x00001FE040000000L,0x0000000000062400L});
    public static final BitSet FOLLOW_logicalExpression_in_assignmentStatement1452 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_84_in_assignmentStatement1454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionStatement1469 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_84_in_expressionStatement1471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_relationalExpression_in_logicalExpression1484 = new BitSet(new long[]{0x0000000000000002L,0x8000000000000000L,0x0000000000000007L});
    public static final BitSet FOLLOW_set_in_logicalExpression1487 = new BitSet(new long[]{0x0000000000085110L,0x00001FE040000000L,0x0000000000062400L});
    public static final BitSet FOLLOW_relationalExpression_in_logicalExpression1498 = new BitSet(new long[]{0x0000000000000002L,0x8000000000000000L,0x0000000000000007L});
    public static final BitSet FOLLOW_additiveExpression_in_relationalExpression1515 = new BitSet(new long[]{0x0000000000000002L,0x0000000008000000L,0x00000000000001F8L});
    public static final BitSet FOLLOW_131_in_relationalExpression1519 = new BitSet(new long[]{0x0000000000085112L,0x00001FE048000000L,0x00000000000625F8L});
    public static final BitSet FOLLOW_relationalExpression_in_relationalExpression1522 = new BitSet(new long[]{0x0000000000000002L,0x0000000008000000L,0x00000000000001F8L});
    public static final BitSet FOLLOW_91_in_relationalExpression1527 = new BitSet(new long[]{0x0000000000085112L,0x00001FE048000000L,0x00000000000625F8L});
    public static final BitSet FOLLOW_relationalExpression_in_relationalExpression1530 = new BitSet(new long[]{0x0000000000000002L,0x0000000008000000L,0x00000000000001F8L});
    public static final BitSet FOLLOW_set_in_relationalExpression1558 = new BitSet(new long[]{0x0000000000085110L,0x00001FE040000000L,0x0000000000062400L});
    public static final BitSet FOLLOW_additiveExpression_in_relationalExpression1571 = new BitSet(new long[]{0x0000000000000002L,0x0000000008000000L,0x00000000000001F8L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_additiveExpression1589 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000600L});
    public static final BitSet FOLLOW_set_in_additiveExpression1592 = new BitSet(new long[]{0x0000000000085110L,0x00001FE040000000L,0x0000000000062400L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_additiveExpression1599 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000600L});
    public static final BitSet FOLLOW_unaryExpression_in_multiplicativeExpression1620 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000001800L});
    public static final BitSet FOLLOW_set_in_multiplicativeExpression1623 = new BitSet(new long[]{0x0000000000085110L,0x00001FE040000000L,0x0000000000062400L});
    public static final BitSet FOLLOW_unaryExpression_in_multiplicativeExpression1630 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000001800L});
    public static final BitSet FOLLOW_set_in_unaryExpression1648 = new BitSet(new long[]{0x0000000000085110L,0x00001FE040000000L,0x0000000000062400L});
    public static final BitSet FOLLOW_postfixExpression_in_unaryExpression1657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_itemSelectorExpression_in_postfixExpression1673 = new BitSet(new long[]{0x0000000000000A02L});
    public static final BitSet FOLLOW_set_in_postfixExpression1676 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_featureCall_in_postfixExpression1685 = new BitSet(new long[]{0x0000000000000A02L,0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_142_in_postfixExpression1692 = new BitSet(new long[]{0x0000000000085110L,0x00001FE040000000L,0x0000000000062400L});
    public static final BitSet FOLLOW_logicalExpression_in_postfixExpression1695 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_143_in_postfixExpression1697 = new BitSet(new long[]{0x0000000000000A02L,0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_primitiveExpression_in_itemSelectorExpression1734 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_142_in_itemSelectorExpression1737 = new BitSet(new long[]{0x0000000000085110L,0x00001FE040000000L,0x0000000000062400L});
    public static final BitSet FOLLOW_primitiveExpression_in_itemSelectorExpression1740 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_143_in_itemSelectorExpression1742 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_simpleFeatureCall_in_featureCall1761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declarativeFeatureCall_in_featureCall1765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_simpleFeatureCall1777 = new BitSet(new long[]{0x0000000000000002L,0x0000000040000000L});
    public static final BitSet FOLLOW_parameterList_in_simpleFeatureCall1780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_parameterList1795 = new BitSet(new long[]{0x0000000000085110L,0x00001FE0C0000000L,0x0000000000062400L});
    public static final BitSet FOLLOW_logicalExpression_in_parameterList1798 = new BitSet(new long[]{0x0000000000000000L,0x0000000080400000L});
    public static final BitSet FOLLOW_86_in_parameterList1801 = new BitSet(new long[]{0x0000000000085110L,0x00001FE040000000L,0x0000000000062400L});
    public static final BitSet FOLLOW_logicalExpression_in_parameterList1803 = new BitSet(new long[]{0x0000000000000000L,0x0000000080400000L});
    public static final BitSet FOLLOW_95_in_parameterList1809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_declarativeFeatureCall1831 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_94_in_declarativeFeatureCall1834 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_formalParameterList_in_declarativeFeatureCall1837 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_144_in_declarativeFeatureCall1839 = new BitSet(new long[]{0x0000000000085110L,0x00001FE040000000L,0x0000000000062400L});
    public static final BitSet FOLLOW_logicalExpression_in_declarativeFeatureCall1842 = new BitSet(new long[]{0x0000000000000000L,0x0000000080400000L});
    public static final BitSet FOLLOW_86_in_declarativeFeatureCall1845 = new BitSet(new long[]{0x0000000000085110L,0x00001FE040000000L,0x0000000000062400L});
    public static final BitSet FOLLOW_logicalExpression_in_declarativeFeatureCall1848 = new BitSet(new long[]{0x0000000000000000L,0x0000000080400000L});
    public static final BitSet FOLLOW_95_in_declarativeFeatureCall1852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_145_in_newExpression1864 = new BitSet(new long[]{0x0000000000080000L,0x00001FE000000000L});
    public static final BitSet FOLLOW_typeName_in_newExpression1869 = new BitSet(new long[]{0x0000000000000002L,0x0000000040000000L});
    public static final BitSet FOLLOW_parameterList_in_newExpression1873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_146_in_variableDeclarationExpression1898 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_variableDeclarationExpression1900 = new BitSet(new long[]{0x0000000000000002L,0x0000000000200000L});
    public static final BitSet FOLLOW_85_in_variableDeclarationExpression1903 = new BitSet(new long[]{0x0000000000080000L,0x00001FE000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_145_in_variableDeclarationExpression1907 = new BitSet(new long[]{0x0000000000080000L,0x00001FE000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_typeName_in_variableDeclarationExpression1912 = new BitSet(new long[]{0x0000000000000002L,0x0000000040000000L});
    public static final BitSet FOLLOW_parameterList_in_variableDeclarationExpression1916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_literalSequentialCollection1946 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_89_in_literalSequentialCollection1961 = new BitSet(new long[]{0x0000000000085110L,0x00001FE044000000L,0x0000000000062400L});
    public static final BitSet FOLLOW_expressionListOrRange_in_literalSequentialCollection1965 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_90_in_literalSequentialCollection1968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionRange1983 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_POINT_POINT_in_expressionRange1985 = new BitSet(new long[]{0x0000000000085110L,0x00001FE040000000L,0x0000000000062400L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionRange1987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionList2009 = new BitSet(new long[]{0x0000000000000002L,0x0000000000400000L});
    public static final BitSet FOLLOW_86_in_expressionList2012 = new BitSet(new long[]{0x0000000000085110L,0x00001FE040000000L,0x0000000000062400L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionList2014 = new BitSet(new long[]{0x0000000000000002L,0x0000000000400000L});
    public static final BitSet FOLLOW_expressionRange_in_expressionListOrRange2038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionList_in_expressionListOrRange2042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_108_in_literalMapCollection2061 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_89_in_literalMapCollection2064 = new BitSet(new long[]{0x0000000000085110L,0x00001FE044000000L,0x0000000000062400L});
    public static final BitSet FOLLOW_keyvalExpressionList_in_literalMapCollection2067 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_90_in_literalMapCollection2070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_keyvalExpression_in_keyvalExpressionList2085 = new BitSet(new long[]{0x0000000000000002L,0x0000000000400000L});
    public static final BitSet FOLLOW_86_in_keyvalExpressionList2088 = new BitSet(new long[]{0x0000000000085110L,0x00001FE040000000L,0x0000000000062400L});
    public static final BitSet FOLLOW_keyvalExpression_in_keyvalExpressionList2090 = new BitSet(new long[]{0x0000000000000002L,0x0000000000400000L});
    public static final BitSet FOLLOW_additiveExpression_in_keyvalExpression2115 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_91_in_keyvalExpression2117 = new BitSet(new long[]{0x0000000000085110L,0x00001FE040000000L,0x0000000000062400L});
    public static final BitSet FOLLOW_logicalExpression_in_keyvalExpression2119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literalSequentialCollection_in_primitiveExpression2141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literalMapCollection_in_primitiveExpression2145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_primitiveExpression2149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_featureCall_in_primitiveExpression2153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pathName_in_primitiveExpression2157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nativeType_in_primitiveExpression2161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectionType_in_primitiveExpression2167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_primitiveExpression2172 = new BitSet(new long[]{0x0000000000085110L,0x00001FE040000000L,0x0000000000062400L});
    public static final BitSet FOLLOW_logicalExpression_in_primitiveExpression2175 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_primitiveExpression2177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_newExpression_in_primitiveExpression2185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variableDeclarationExpression_in_primitiveExpression2189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_literal0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotation_in_synpred17_EolParserRules695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_synpred29_EolParserRules857 = new BitSet(new long[]{0x0000000000080000L,0x00001FE000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_typeName_in_synpred29_EolParserRules862 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_synpred29_EolParserRules865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementA_in_synpred30_EolParserRules888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignmentStatement_in_synpred31_EolParserRules902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionStatement_in_synpred32_EolParserRules906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_elseStatement_in_synpred46_EolParserRules1060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_synpred53_EolParserRules1394 = new BitSet(new long[]{0x0000000000000002L,0x0000000000400000L});
    public static final BitSet FOLLOW_86_in_synpred53_EolParserRules1397 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_synpred53_EolParserRules1399 = new BitSet(new long[]{0x0000000000000002L,0x0000000000400000L});
    public static final BitSet FOLLOW_131_in_synpred67_EolParserRules1519 = new BitSet(new long[]{0x0000000000085112L,0x00001FE040000000L,0x0000000000062400L});
    public static final BitSet FOLLOW_relationalExpression_in_synpred67_EolParserRules1522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_91_in_synpred67_EolParserRules1527 = new BitSet(new long[]{0x0000000000085112L,0x00001FE040000000L,0x0000000000062400L});
    public static final BitSet FOLLOW_relationalExpression_in_synpred67_EolParserRules1530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred67_EolParserRules1558 = new BitSet(new long[]{0x0000000000085110L,0x00001FE040000000L,0x0000000000062400L});
    public static final BitSet FOLLOW_additiveExpression_in_synpred67_EolParserRules1571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_85_in_synpred86_EolParserRules1903 = new BitSet(new long[]{0x0000000000080000L,0x00001FE000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_145_in_synpred86_EolParserRules1907 = new BitSet(new long[]{0x0000000000080000L,0x00001FE000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_typeName_in_synpred86_EolParserRules1912 = new BitSet(new long[]{0x0000000000000002L,0x0000000040000000L});
    public static final BitSet FOLLOW_parameterList_in_synpred86_EolParserRules1916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionRange_in_synpred94_EolParserRules2038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_featureCall_in_synpred100_EolParserRules2153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pathName_in_synpred101_EolParserRules2157 = new BitSet(new long[]{0x0000000000000002L});

}
