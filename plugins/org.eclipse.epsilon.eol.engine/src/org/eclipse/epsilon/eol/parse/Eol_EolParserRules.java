package org.eclipse.epsilon.eol.parse;

// $ANTLR 3.1b1 EolParserRules.g 2010-02-23 16:05:05

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
public class Eol_EolParserRules extends org.eclipse.epsilon.commons.parse.EpsilonParser {
    public static final int StatementBlock=26;
    public static final int WHILE=30;
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
    public static final int DRIVER=63;
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
    public static final int MODELDECLARATIONPARAMETER=65;
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
    public static final int T__107=107;
    public static final int CONTINUE=34;
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
    public static final int MODELDECLARATIONPARAMETERS=64;
    public static final int BLOCK=55;
    public static final int FEATURECALL=56;
    public static final int FORMAL=21;
    public static final int ARROW=9;
    public static final int ASSIGNMENT=23;
    public static final int STRING=12;

    // delegates
    // delegators
    public EolParser gEol;


        public Eol_EolParserRules(TokenStream input, EolParser gEol) {
            this(input, new RecognizerSharedState(), gEol);
        }
        public Eol_EolParserRules(TokenStream input, RecognizerSharedState state, EolParser gEol) {
            super(input, state);
            this.gEol = gEol;
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return EolParser.tokenNames; }
    public String getGrammarFileName() { return "EolParserRules.g"; }

    
    
    public void setTokenType(ParserRuleReturnScope tree, int type) {
    	((CommonTree) tree.getTree()).getToken().setType(type);
    }
    


    public static class operationDeclarationOrAnnotationBlock_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start operationDeclarationOrAnnotationBlock
    // EolParserRules.g:97:1: operationDeclarationOrAnnotationBlock : ( operationDeclaration | annotationBlock );
    public final Eol_EolParserRules.operationDeclarationOrAnnotationBlock_return operationDeclarationOrAnnotationBlock() throws RecognitionException {
        Eol_EolParserRules.operationDeclarationOrAnnotationBlock_return retval = new Eol_EolParserRules.operationDeclarationOrAnnotationBlock_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Eol_EolParserRules.operationDeclaration_return operationDeclaration1 = null;

        Eol_EolParserRules.annotationBlock_return annotationBlock2 = null;



        try {
            // EolParserRules.g:98:2: ( operationDeclaration | annotationBlock )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( ((LA1_0>=75 && LA1_0<=76)) ) {
                alt1=1;
            }
            else if ( (LA1_0==Annotation||LA1_0==80) ) {
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
                    // EolParserRules.g:98:4: operationDeclaration
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_operationDeclaration_in_operationDeclarationOrAnnotationBlock218);
                    operationDeclaration1=operationDeclaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, operationDeclaration1.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:98:25: annotationBlock
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_annotationBlock_in_operationDeclarationOrAnnotationBlock220);
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
    // EolParserRules.g:101:1: modelDeclaration : 'model' NAME ( modelAlias )? ( modelDriver )? ( modelDeclarationParameters )? ';' -> ^( MODELDECLARATION NAME ( modelAlias )? ( modelDriver )? ( modelDeclarationParameters )? ) ;
    public final Eol_EolParserRules.modelDeclaration_return modelDeclaration() throws RecognitionException {
        Eol_EolParserRules.modelDeclaration_return retval = new Eol_EolParserRules.modelDeclaration_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal3=null;
        Token NAME4=null;
        Token char_literal8=null;
        Eol_EolParserRules.modelAlias_return modelAlias5 = null;

        Eol_EolParserRules.modelDriver_return modelDriver6 = null;

        Eol_EolParserRules.modelDeclarationParameters_return modelDeclarationParameters7 = null;


        CommonTree string_literal3_tree=null;
        CommonTree NAME4_tree=null;
        CommonTree char_literal8_tree=null;
        RewriteRuleTokenStream stream_67=new RewriteRuleTokenStream(adaptor,"token 67");
        RewriteRuleTokenStream stream_66=new RewriteRuleTokenStream(adaptor,"token 66");
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleSubtreeStream stream_modelDeclarationParameters=new RewriteRuleSubtreeStream(adaptor,"rule modelDeclarationParameters");
        RewriteRuleSubtreeStream stream_modelAlias=new RewriteRuleSubtreeStream(adaptor,"rule modelAlias");
        RewriteRuleSubtreeStream stream_modelDriver=new RewriteRuleSubtreeStream(adaptor,"rule modelDriver");
        try {
            // EolParserRules.g:102:2: ( 'model' NAME ( modelAlias )? ( modelDriver )? ( modelDeclarationParameters )? ';' -> ^( MODELDECLARATION NAME ( modelAlias )? ( modelDriver )? ( modelDeclarationParameters )? ) )
            // EolParserRules.g:102:4: 'model' NAME ( modelAlias )? ( modelDriver )? ( modelDeclarationParameters )? ';'
            {
            string_literal3=(Token)match(input,66,FOLLOW_66_in_modelDeclaration231); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_66.add(string_literal3);

            NAME4=(Token)match(input,NAME,FOLLOW_NAME_in_modelDeclaration233); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(NAME4);

            // EolParserRules.g:102:17: ( modelAlias )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==70) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // EolParserRules.g:0:0: modelAlias
                    {
                    pushFollow(FOLLOW_modelAlias_in_modelDeclaration235);
                    modelAlias5=modelAlias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_modelAlias.add(modelAlias5.getTree());

                    }
                    break;

            }

            // EolParserRules.g:102:29: ( modelDriver )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==71) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // EolParserRules.g:0:0: modelDriver
                    {
                    pushFollow(FOLLOW_modelDriver_in_modelDeclaration238);
                    modelDriver6=modelDriver();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_modelDriver.add(modelDriver6.getTree());

                    }
                    break;

            }

            // EolParserRules.g:102:42: ( modelDeclarationParameters )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==72) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // EolParserRules.g:0:0: modelDeclarationParameters
                    {
                    pushFollow(FOLLOW_modelDeclarationParameters_in_modelDeclaration241);
                    modelDeclarationParameters7=modelDeclarationParameters();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_modelDeclarationParameters.add(modelDeclarationParameters7.getTree());

                    }
                    break;

            }

            char_literal8=(Token)match(input,67,FOLLOW_67_in_modelDeclaration244); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_67.add(char_literal8);



            // AST REWRITE
            // elements: modelDriver, NAME, modelAlias, modelDeclarationParameters
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 103:2: -> ^( MODELDECLARATION NAME ( modelAlias )? ( modelDriver )? ( modelDeclarationParameters )? )
            {
                // EolParserRules.g:103:5: ^( MODELDECLARATION NAME ( modelAlias )? ( modelDriver )? ( modelDeclarationParameters )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(MODELDECLARATION, "MODELDECLARATION"), root_1);

                adaptor.addChild(root_1, stream_NAME.nextNode());
                // EolParserRules.g:103:29: ( modelAlias )?
                if ( stream_modelAlias.hasNext() ) {
                    adaptor.addChild(root_1, stream_modelAlias.nextTree());

                }
                stream_modelAlias.reset();
                // EolParserRules.g:103:43: ( modelDriver )?
                if ( stream_modelDriver.hasNext() ) {
                    adaptor.addChild(root_1, stream_modelDriver.nextTree());

                }
                stream_modelDriver.reset();
                // EolParserRules.g:103:58: ( modelDeclarationParameters )?
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
    // EolParserRules.g:106:1: modelNamespace : ':' NAME ( ',' NAME )* -> ^( NAMESPACE ( NAME )* ) ;
    public final Eol_EolParserRules.modelNamespace_return modelNamespace() throws RecognitionException {
        Eol_EolParserRules.modelNamespace_return retval = new Eol_EolParserRules.modelNamespace_return();
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
        RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
        RewriteRuleTokenStream stream_68=new RewriteRuleTokenStream(adaptor,"token 68");
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");

        try {
            // EolParserRules.g:107:2: ( ':' NAME ( ',' NAME )* -> ^( NAMESPACE ( NAME )* ) )
            // EolParserRules.g:107:6: ':' NAME ( ',' NAME )*
            {
            char_literal9=(Token)match(input,68,FOLLOW_68_in_modelNamespace282); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_68.add(char_literal9);

            NAME10=(Token)match(input,NAME,FOLLOW_NAME_in_modelNamespace284); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(NAME10);

            // EolParserRules.g:107:15: ( ',' NAME )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==69) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // EolParserRules.g:107:16: ',' NAME
            	    {
            	    char_literal11=(Token)match(input,69,FOLLOW_69_in_modelNamespace287); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_69.add(char_literal11);

            	    NAME12=(Token)match(input,NAME,FOLLOW_NAME_in_modelNamespace289); if (state.failed) return retval; 
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
            // 108:2: -> ^( NAMESPACE ( NAME )* )
            {
                // EolParserRules.g:108:5: ^( NAMESPACE ( NAME )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NAMESPACE, "NAMESPACE"), root_1);

                // EolParserRules.g:108:17: ( NAME )*
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
    // EolParserRules.g:111:1: modelAlias : 'alias' NAME ( ',' NAME )* -> ^( ALIAS ( NAME )* ) ;
    public final Eol_EolParserRules.modelAlias_return modelAlias() throws RecognitionException {
        Eol_EolParserRules.modelAlias_return retval = new Eol_EolParserRules.modelAlias_return();
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
        RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");

        try {
            // EolParserRules.g:112:2: ( 'alias' NAME ( ',' NAME )* -> ^( ALIAS ( NAME )* ) )
            // EolParserRules.g:112:5: 'alias' NAME ( ',' NAME )*
            {
            string_literal13=(Token)match(input,70,FOLLOW_70_in_modelAlias313); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_70.add(string_literal13);

            NAME14=(Token)match(input,NAME,FOLLOW_NAME_in_modelAlias315); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(NAME14);

            // EolParserRules.g:112:18: ( ',' NAME )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==69) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // EolParserRules.g:112:19: ',' NAME
            	    {
            	    char_literal15=(Token)match(input,69,FOLLOW_69_in_modelAlias318); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_69.add(char_literal15);

            	    NAME16=(Token)match(input,NAME,FOLLOW_NAME_in_modelAlias320); if (state.failed) return retval; 
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
            // 113:2: -> ^( ALIAS ( NAME )* )
            {
                // EolParserRules.g:113:5: ^( ALIAS ( NAME )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ALIAS, "ALIAS"), root_1);

                // EolParserRules.g:113:13: ( NAME )*
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
    // EolParserRules.g:116:1: modelDriver : 'driver' NAME -> ^( DRIVER NAME ) ;
    public final Eol_EolParserRules.modelDriver_return modelDriver() throws RecognitionException {
        Eol_EolParserRules.modelDriver_return retval = new Eol_EolParserRules.modelDriver_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal17=null;
        Token NAME18=null;

        CommonTree string_literal17_tree=null;
        CommonTree NAME18_tree=null;
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_71=new RewriteRuleTokenStream(adaptor,"token 71");

        try {
            // EolParserRules.g:117:2: ( 'driver' NAME -> ^( DRIVER NAME ) )
            // EolParserRules.g:117:5: 'driver' NAME
            {
            string_literal17=(Token)match(input,71,FOLLOW_71_in_modelDriver344); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_71.add(string_literal17);

            NAME18=(Token)match(input,NAME,FOLLOW_NAME_in_modelDriver346); if (state.failed) return retval; 
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
            // 118:2: -> ^( DRIVER NAME )
            {
                // EolParserRules.g:118:5: ^( DRIVER NAME )
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
    // EolParserRules.g:121:1: modelDeclarationParameters : '{' ( modelDeclarationParameter )? ( ',' modelDeclarationParameter )* '}' -> ^( MODELDECLARATIONPARAMETERS ( modelDeclarationParameter )* ) ;
    public final Eol_EolParserRules.modelDeclarationParameters_return modelDeclarationParameters() throws RecognitionException {
        Eol_EolParserRules.modelDeclarationParameters_return retval = new Eol_EolParserRules.modelDeclarationParameters_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal19=null;
        Token char_literal21=null;
        Token char_literal23=null;
        Eol_EolParserRules.modelDeclarationParameter_return modelDeclarationParameter20 = null;

        Eol_EolParserRules.modelDeclarationParameter_return modelDeclarationParameter22 = null;


        CommonTree char_literal19_tree=null;
        CommonTree char_literal21_tree=null;
        CommonTree char_literal23_tree=null;
        RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
        RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
        RewriteRuleTokenStream stream_73=new RewriteRuleTokenStream(adaptor,"token 73");
        RewriteRuleSubtreeStream stream_modelDeclarationParameter=new RewriteRuleSubtreeStream(adaptor,"rule modelDeclarationParameter");
        try {
            // EolParserRules.g:122:2: ( '{' ( modelDeclarationParameter )? ( ',' modelDeclarationParameter )* '}' -> ^( MODELDECLARATIONPARAMETERS ( modelDeclarationParameter )* ) )
            // EolParserRules.g:122:4: '{' ( modelDeclarationParameter )? ( ',' modelDeclarationParameter )* '}'
            {
            char_literal19=(Token)match(input,72,FOLLOW_72_in_modelDeclarationParameters366); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_72.add(char_literal19);

            // EolParserRules.g:122:8: ( modelDeclarationParameter )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==NAME) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // EolParserRules.g:0:0: modelDeclarationParameter
                    {
                    pushFollow(FOLLOW_modelDeclarationParameter_in_modelDeclarationParameters368);
                    modelDeclarationParameter20=modelDeclarationParameter();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_modelDeclarationParameter.add(modelDeclarationParameter20.getTree());

                    }
                    break;

            }

            // EolParserRules.g:122:35: ( ',' modelDeclarationParameter )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==69) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // EolParserRules.g:122:36: ',' modelDeclarationParameter
            	    {
            	    char_literal21=(Token)match(input,69,FOLLOW_69_in_modelDeclarationParameters372); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_69.add(char_literal21);

            	    pushFollow(FOLLOW_modelDeclarationParameter_in_modelDeclarationParameters374);
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

            char_literal23=(Token)match(input,73,FOLLOW_73_in_modelDeclarationParameters378); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_73.add(char_literal23);



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
            // 123:2: -> ^( MODELDECLARATIONPARAMETERS ( modelDeclarationParameter )* )
            {
                // EolParserRules.g:123:5: ^( MODELDECLARATIONPARAMETERS ( modelDeclarationParameter )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(MODELDECLARATIONPARAMETERS, "MODELDECLARATIONPARAMETERS"), root_1);

                // EolParserRules.g:123:34: ( modelDeclarationParameter )*
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
    // EolParserRules.g:126:1: modelDeclarationParameter : NAME '=' STRING -> ^( MODELDECLARATIONPARAMETER NAME STRING ) ;
    public final Eol_EolParserRules.modelDeclarationParameter_return modelDeclarationParameter() throws RecognitionException {
        Eol_EolParserRules.modelDeclarationParameter_return retval = new Eol_EolParserRules.modelDeclarationParameter_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NAME24=null;
        Token char_literal25=null;
        Token STRING26=null;

        CommonTree NAME24_tree=null;
        CommonTree char_literal25_tree=null;
        CommonTree STRING26_tree=null;
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_74=new RewriteRuleTokenStream(adaptor,"token 74");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");

        try {
            // EolParserRules.g:127:2: ( NAME '=' STRING -> ^( MODELDECLARATIONPARAMETER NAME STRING ) )
            // EolParserRules.g:127:4: NAME '=' STRING
            {
            NAME24=(Token)match(input,NAME,FOLLOW_NAME_in_modelDeclarationParameter402); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(NAME24);

            char_literal25=(Token)match(input,74,FOLLOW_74_in_modelDeclarationParameter404); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_74.add(char_literal25);

            STRING26=(Token)match(input,STRING,FOLLOW_STRING_in_modelDeclarationParameter406); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_STRING.add(STRING26);



            // AST REWRITE
            // elements: STRING, NAME
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 128:2: -> ^( MODELDECLARATIONPARAMETER NAME STRING )
            {
                // EolParserRules.g:128:5: ^( MODELDECLARATIONPARAMETER NAME STRING )
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
    // EolParserRules.g:131:1: operationDeclaration : ( 'operation' | 'function' ) (ctx= typeName )? operationName= NAME '(' ( formalParameterList )? ')' ( ':' returnType= typeName )? statementBlock -> ^( HELPERMETHOD ( $ctx)? $operationName ( formalParameterList )? ( $returnType)? statementBlock ) ;
    public final Eol_EolParserRules.operationDeclaration_return operationDeclaration() throws RecognitionException {
        Eol_EolParserRules.operationDeclaration_return retval = new Eol_EolParserRules.operationDeclaration_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token operationName=null;
        Token string_literal27=null;
        Token string_literal28=null;
        Token char_literal29=null;
        Token char_literal31=null;
        Token char_literal32=null;
        Eol_EolParserRules.typeName_return ctx = null;

        Eol_EolParserRules.typeName_return returnType = null;

        Eol_EolParserRules.formalParameterList_return formalParameterList30 = null;

        Eol_EolParserRules.statementBlock_return statementBlock33 = null;


        CommonTree operationName_tree=null;
        CommonTree string_literal27_tree=null;
        CommonTree string_literal28_tree=null;
        CommonTree char_literal29_tree=null;
        CommonTree char_literal31_tree=null;
        CommonTree char_literal32_tree=null;
        RewriteRuleTokenStream stream_78=new RewriteRuleTokenStream(adaptor,"token 78");
        RewriteRuleTokenStream stream_77=new RewriteRuleTokenStream(adaptor,"token 77");
        RewriteRuleTokenStream stream_68=new RewriteRuleTokenStream(adaptor,"token 68");
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_75=new RewriteRuleTokenStream(adaptor,"token 75");
        RewriteRuleTokenStream stream_76=new RewriteRuleTokenStream(adaptor,"token 76");
        RewriteRuleSubtreeStream stream_typeName=new RewriteRuleSubtreeStream(adaptor,"rule typeName");
        RewriteRuleSubtreeStream stream_statementBlock=new RewriteRuleSubtreeStream(adaptor,"rule statementBlock");
        RewriteRuleSubtreeStream stream_formalParameterList=new RewriteRuleSubtreeStream(adaptor,"rule formalParameterList");
        try {
            // EolParserRules.g:133:2: ( ( 'operation' | 'function' ) (ctx= typeName )? operationName= NAME '(' ( formalParameterList )? ')' ( ':' returnType= typeName )? statementBlock -> ^( HELPERMETHOD ( $ctx)? $operationName ( formalParameterList )? ( $returnType)? statementBlock ) )
            // EolParserRules.g:133:4: ( 'operation' | 'function' ) (ctx= typeName )? operationName= NAME '(' ( formalParameterList )? ')' ( ':' returnType= typeName )? statementBlock
            {
            // EolParserRules.g:133:4: ( 'operation' | 'function' )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==75) ) {
                alt9=1;
            }
            else if ( (LA9_0==76) ) {
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
                    // EolParserRules.g:133:5: 'operation'
                    {
                    string_literal27=(Token)match(input,75,FOLLOW_75_in_operationDeclaration432); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_75.add(string_literal27);


                    }
                    break;
                case 2 :
                    // EolParserRules.g:133:17: 'function'
                    {
                    string_literal28=(Token)match(input,76,FOLLOW_76_in_operationDeclaration434); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_76.add(string_literal28);


                    }
                    break;

            }

            // EolParserRules.g:133:29: (ctx= typeName )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==NAME) ) {
                int LA10_1 = input.LA(2);

                if ( (LA10_1==NAME||(LA10_1>=81 && LA10_1<=83)) ) {
                    alt10=1;
                }
            }
            else if ( ((LA10_0>=84 && LA10_0<=89)) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // EolParserRules.g:133:30: ctx= typeName
                    {
                    pushFollow(FOLLOW_typeName_in_operationDeclaration440);
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

            operationName=(Token)match(input,NAME,FOLLOW_NAME_in_operationDeclaration448); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(operationName);

            char_literal29=(Token)match(input,77,FOLLOW_77_in_operationDeclaration450); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_77.add(char_literal29);

            // EolParserRules.g:133:94: ( formalParameterList )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==NAME) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // EolParserRules.g:0:0: formalParameterList
                    {
                    pushFollow(FOLLOW_formalParameterList_in_operationDeclaration452);
                    formalParameterList30=formalParameterList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_formalParameterList.add(formalParameterList30.getTree());

                    }
                    break;

            }

            char_literal31=(Token)match(input,78,FOLLOW_78_in_operationDeclaration455); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_78.add(char_literal31);

            // EolParserRules.g:133:119: ( ':' returnType= typeName )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==68) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // EolParserRules.g:133:120: ':' returnType= typeName
                    {
                    char_literal32=(Token)match(input,68,FOLLOW_68_in_operationDeclaration458); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_68.add(char_literal32);

                    pushFollow(FOLLOW_typeName_in_operationDeclaration462);
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

            pushFollow(FOLLOW_statementBlock_in_operationDeclaration468);
            statementBlock33=statementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_statementBlock.add(statementBlock33.getTree());


            // AST REWRITE
            // elements: operationName, returnType, ctx, formalParameterList, statementBlock
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
            // 134:3: -> ^( HELPERMETHOD ( $ctx)? $operationName ( formalParameterList )? ( $returnType)? statementBlock )
            {
                // EolParserRules.g:134:6: ^( HELPERMETHOD ( $ctx)? $operationName ( formalParameterList )? ( $returnType)? statementBlock )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(HELPERMETHOD, "HELPERMETHOD"), root_1);

                // EolParserRules.g:134:21: ( $ctx)?
                if ( stream_ctx.hasNext() ) {
                    adaptor.addChild(root_1, stream_ctx.nextTree());

                }
                stream_ctx.reset();
                adaptor.addChild(root_1, stream_operationName.nextNode());
                // EolParserRules.g:134:42: ( formalParameterList )?
                if ( stream_formalParameterList.hasNext() ) {
                    adaptor.addChild(root_1, stream_formalParameterList.nextTree());

                }
                stream_formalParameterList.reset();
                // EolParserRules.g:134:63: ( $returnType)?
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
    // EolParserRules.g:137:1: importStatement : i= 'import' STRING ';' ;
    public final Eol_EolParserRules.importStatement_return importStatement() throws RecognitionException {
        Eol_EolParserRules.importStatement_return retval = new Eol_EolParserRules.importStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token i=null;
        Token STRING34=null;
        Token char_literal35=null;

        CommonTree i_tree=null;
        CommonTree STRING34_tree=null;
        CommonTree char_literal35_tree=null;

        try {
            // EolParserRules.g:138:2: (i= 'import' STRING ';' )
            // EolParserRules.g:138:4: i= 'import' STRING ';'
            {
            root_0 = (CommonTree)adaptor.nil();

            i=(Token)match(input,79,FOLLOW_79_in_importStatement505); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            i_tree = (CommonTree)adaptor.create(i);
            root_0 = (CommonTree)adaptor.becomeRoot(i_tree, root_0);
            }
            STRING34=(Token)match(input,STRING,FOLLOW_STRING_in_importStatement508); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STRING34_tree = (CommonTree)adaptor.create(STRING34);
            adaptor.addChild(root_0, STRING34_tree);
            }
            char_literal35=(Token)match(input,67,FOLLOW_67_in_importStatement510); if (state.failed) return retval;
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
    // EolParserRules.g:142:1: block : ( statement )* -> ^( BLOCK ( statement )* ) ;
    public final Eol_EolParserRules.block_return block() throws RecognitionException {
        Eol_EolParserRules.block_return retval = new Eol_EolParserRules.block_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Eol_EolParserRules.statement_return statement36 = null;


        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        try {
            // EolParserRules.g:143:2: ( ( statement )* -> ^( BLOCK ( statement )* ) )
            // EolParserRules.g:143:4: ( statement )*
            {
            // EolParserRules.g:143:4: ( statement )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==FLOAT||LA13_0==INT||LA13_0==BOOLEAN||LA13_0==STRING||LA13_0==NAME||LA13_0==77||(LA13_0>=84 && LA13_0<=90)||LA13_0==92||(LA13_0>=94 && LA13_0<=102)||LA13_0==116||LA13_0==119||(LA13_0>=121 && LA13_0<=122)) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // EolParserRules.g:0:0: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_block525);
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
            // 144:2: -> ^( BLOCK ( statement )* )
            {
                // EolParserRules.g:144:5: ^( BLOCK ( statement )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(BLOCK, "BLOCK"), root_1);

                // EolParserRules.g:144:13: ( statement )*
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
    // EolParserRules.g:147:1: statementBlock : '{' block '}' ;
    public final Eol_EolParserRules.statementBlock_return statementBlock() throws RecognitionException {
        Eol_EolParserRules.statementBlock_return retval = new Eol_EolParserRules.statementBlock_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal37=null;
        Token char_literal39=null;
        Eol_EolParserRules.block_return block38 = null;


        CommonTree char_literal37_tree=null;
        CommonTree char_literal39_tree=null;

        try {
            // EolParserRules.g:148:2: ( '{' block '}' )
            // EolParserRules.g:148:4: '{' block '}'
            {
            root_0 = (CommonTree)adaptor.nil();

            char_literal37=(Token)match(input,72,FOLLOW_72_in_statementBlock547); if (state.failed) return retval;
            pushFollow(FOLLOW_block_in_statementBlock550);
            block38=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, block38.getTree());
            char_literal39=(Token)match(input,73,FOLLOW_73_in_statementBlock552); if (state.failed) return retval;

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
    // EolParserRules.g:151:1: formalParameter : NAME ( ':' pt= typeName )? -> ^( FORMAL NAME ( typeName )? ) ;
    public final Eol_EolParserRules.formalParameter_return formalParameter() throws RecognitionException {
        Eol_EolParserRules.formalParameter_return retval = new Eol_EolParserRules.formalParameter_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NAME40=null;
        Token char_literal41=null;
        Eol_EolParserRules.typeName_return pt = null;


        CommonTree NAME40_tree=null;
        CommonTree char_literal41_tree=null;
        RewriteRuleTokenStream stream_68=new RewriteRuleTokenStream(adaptor,"token 68");
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleSubtreeStream stream_typeName=new RewriteRuleSubtreeStream(adaptor,"rule typeName");
        try {
            // EolParserRules.g:152:2: ( NAME ( ':' pt= typeName )? -> ^( FORMAL NAME ( typeName )? ) )
            // EolParserRules.g:152:4: NAME ( ':' pt= typeName )?
            {
            NAME40=(Token)match(input,NAME,FOLLOW_NAME_in_formalParameter564); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(NAME40);

            // EolParserRules.g:152:9: ( ':' pt= typeName )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==68) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // EolParserRules.g:152:10: ':' pt= typeName
                    {
                    char_literal41=(Token)match(input,68,FOLLOW_68_in_formalParameter567); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_68.add(char_literal41);

                    pushFollow(FOLLOW_typeName_in_formalParameter571);
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
            // elements: typeName, NAME
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 153:3: -> ^( FORMAL NAME ( typeName )? )
            {
                // EolParserRules.g:153:6: ^( FORMAL NAME ( typeName )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FORMAL, "FORMAL"), root_1);

                adaptor.addChild(root_1, stream_NAME.nextNode());
                // EolParserRules.g:153:20: ( typeName )?
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
    // EolParserRules.g:156:1: formalParameterList : formalParameter ( ',' formalParameter )* -> ^( PARAMLIST ( formalParameter )* ) ;
    public final Eol_EolParserRules.formalParameterList_return formalParameterList() throws RecognitionException {
        Eol_EolParserRules.formalParameterList_return retval = new Eol_EolParserRules.formalParameterList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal43=null;
        Eol_EolParserRules.formalParameter_return formalParameter42 = null;

        Eol_EolParserRules.formalParameter_return formalParameter44 = null;


        CommonTree char_literal43_tree=null;
        RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
        RewriteRuleSubtreeStream stream_formalParameter=new RewriteRuleSubtreeStream(adaptor,"rule formalParameter");
        try {
            // EolParserRules.g:157:2: ( formalParameter ( ',' formalParameter )* -> ^( PARAMLIST ( formalParameter )* ) )
            // EolParserRules.g:157:4: formalParameter ( ',' formalParameter )*
            {
            pushFollow(FOLLOW_formalParameter_in_formalParameterList600);
            formalParameter42=formalParameter();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_formalParameter.add(formalParameter42.getTree());
            // EolParserRules.g:157:20: ( ',' formalParameter )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==69) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // EolParserRules.g:157:21: ',' formalParameter
            	    {
            	    char_literal43=(Token)match(input,69,FOLLOW_69_in_formalParameterList603); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_69.add(char_literal43);

            	    pushFollow(FOLLOW_formalParameter_in_formalParameterList605);
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
            // 158:2: -> ^( PARAMLIST ( formalParameter )* )
            {
                // EolParserRules.g:158:5: ^( PARAMLIST ( formalParameter )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PARAMLIST, "PARAMLIST"), root_1);

                // EolParserRules.g:158:17: ( formalParameter )*
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
    // EolParserRules.g:161:1: executableAnnotation : '$' NAME logicalExpression -> ^( EXECUTABLEANNOTATION NAME logicalExpression ) ;
    public final Eol_EolParserRules.executableAnnotation_return executableAnnotation() throws RecognitionException {
        Eol_EolParserRules.executableAnnotation_return retval = new Eol_EolParserRules.executableAnnotation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal45=null;
        Token NAME46=null;
        Eol_EolParserRules.logicalExpression_return logicalExpression47 = null;


        CommonTree char_literal45_tree=null;
        CommonTree NAME46_tree=null;
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_80=new RewriteRuleTokenStream(adaptor,"token 80");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:162:2: ( '$' NAME logicalExpression -> ^( EXECUTABLEANNOTATION NAME logicalExpression ) )
            // EolParserRules.g:162:4: '$' NAME logicalExpression
            {
            char_literal45=(Token)match(input,80,FOLLOW_80_in_executableAnnotation628); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_80.add(char_literal45);

            NAME46=(Token)match(input,NAME,FOLLOW_NAME_in_executableAnnotation630); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(NAME46);

            pushFollow(FOLLOW_logicalExpression_in_executableAnnotation632);
            logicalExpression47=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression47.getTree());


            // AST REWRITE
            // elements: NAME, logicalExpression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 163:2: -> ^( EXECUTABLEANNOTATION NAME logicalExpression )
            {
                // EolParserRules.g:163:5: ^( EXECUTABLEANNOTATION NAME logicalExpression )
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
    // EolParserRules.g:166:1: annotation : ( Annotation | executableAnnotation );
    public final Eol_EolParserRules.annotation_return annotation() throws RecognitionException {
        Eol_EolParserRules.annotation_return retval = new Eol_EolParserRules.annotation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token Annotation48=null;
        Eol_EolParserRules.executableAnnotation_return executableAnnotation49 = null;


        CommonTree Annotation48_tree=null;

        try {
            // EolParserRules.g:167:2: ( Annotation | executableAnnotation )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==Annotation) ) {
                alt16=1;
            }
            else if ( (LA16_0==80) ) {
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
                    // EolParserRules.g:167:4: Annotation
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    Annotation48=(Token)match(input,Annotation,FOLLOW_Annotation_in_annotation654); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    Annotation48_tree = (CommonTree)adaptor.create(Annotation48);
                    adaptor.addChild(root_0, Annotation48_tree);
                    }

                    }
                    break;
                case 2 :
                    // EolParserRules.g:167:15: executableAnnotation
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_executableAnnotation_in_annotation656);
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
    // EolParserRules.g:170:1: annotationBlock : ( annotation )+ -> ^( ANNOTATIONBLOCK ( annotation )+ ) ;
    public final Eol_EolParserRules.annotationBlock_return annotationBlock() throws RecognitionException {
        Eol_EolParserRules.annotationBlock_return retval = new Eol_EolParserRules.annotationBlock_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Eol_EolParserRules.annotation_return annotation50 = null;


        RewriteRuleSubtreeStream stream_annotation=new RewriteRuleSubtreeStream(adaptor,"rule annotation");
        try {
            // EolParserRules.g:171:2: ( ( annotation )+ -> ^( ANNOTATIONBLOCK ( annotation )+ ) )
            // EolParserRules.g:171:4: ( annotation )+
            {
            // EolParserRules.g:171:4: ( annotation )+
            int cnt17=0;
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==Annotation||LA17_0==80) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // EolParserRules.g:0:0: annotation
            	    {
            	    pushFollow(FOLLOW_annotation_in_annotationBlock667);
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
            // 172:2: -> ^( ANNOTATIONBLOCK ( annotation )+ )
            {
                // EolParserRules.g:172:5: ^( ANNOTATIONBLOCK ( annotation )+ )
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
    // EolParserRules.g:175:1: typeName : ( pathName | nativeType | collectionType );
    public final Eol_EolParserRules.typeName_return typeName() throws RecognitionException {
        Eol_EolParserRules.typeName_return retval = new Eol_EolParserRules.typeName_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Eol_EolParserRules.pathName_return pathName51 = null;

        Eol_EolParserRules.nativeType_return nativeType52 = null;

        Eol_EolParserRules.collectionType_return collectionType53 = null;



        try {
            // EolParserRules.g:176:2: ( pathName | nativeType | collectionType )
            int alt18=3;
            switch ( input.LA(1) ) {
            case NAME:
                {
                alt18=1;
                }
                break;
            case 84:
                {
                alt18=2;
                }
                break;
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
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
                    // EolParserRules.g:176:4: pathName
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_pathName_in_typeName690);
                    pathName51=pathName();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pathName51.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:176:15: nativeType
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_nativeType_in_typeName694);
                    nativeType52=nativeType();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nativeType52.getTree());

                    }
                    break;
                case 3 :
                    // EolParserRules.g:176:28: collectionType
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_collectionType_in_typeName698);
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
    // EolParserRules.g:180:1: pathName : (metamodel= NAME '!' )? head= NAME ( '::' field= NAME )* ( '#' label= NAME )? ;
    public final Eol_EolParserRules.pathName_return pathName() throws RecognitionException {
        Eol_EolParserRules.pathName_return retval = new Eol_EolParserRules.pathName_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token metamodel=null;
        Token head=null;
        Token field=null;
        Token label=null;
        Token char_literal54=null;
        Token string_literal55=null;
        Token char_literal56=null;

        CommonTree metamodel_tree=null;
        CommonTree head_tree=null;
        CommonTree field_tree=null;
        CommonTree label_tree=null;
        CommonTree char_literal54_tree=null;
        CommonTree string_literal55_tree=null;
        CommonTree char_literal56_tree=null;

        try {
            // EolParserRules.g:181:2: ( (metamodel= NAME '!' )? head= NAME ( '::' field= NAME )* ( '#' label= NAME )? )
            // EolParserRules.g:181:4: (metamodel= NAME '!' )? head= NAME ( '::' field= NAME )* ( '#' label= NAME )?
            {
            root_0 = (CommonTree)adaptor.nil();

            // EolParserRules.g:181:4: (metamodel= NAME '!' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==NAME) ) {
                int LA19_1 = input.LA(2);

                if ( (LA19_1==81) ) {
                    alt19=1;
                }
            }
            switch (alt19) {
                case 1 :
                    // EolParserRules.g:181:5: metamodel= NAME '!'
                    {
                    metamodel=(Token)match(input,NAME,FOLLOW_NAME_in_pathName715); if (state.failed) return retval;
                    char_literal54=(Token)match(input,81,FOLLOW_81_in_pathName718); if (state.failed) return retval;

                    }
                    break;

            }

            head=(Token)match(input,NAME,FOLLOW_NAME_in_pathName725); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            head_tree = (CommonTree)adaptor.create(head);
            adaptor.addChild(root_0, head_tree);
            }
            // EolParserRules.g:182:3: ( '::' field= NAME )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==82) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // EolParserRules.g:182:4: '::' field= NAME
            	    {
            	    string_literal55=(Token)match(input,82,FOLLOW_82_in_pathName730); if (state.failed) return retval;
            	    field=(Token)match(input,NAME,FOLLOW_NAME_in_pathName735); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	      
            	      			head.setText(head.getText()
            	      					+ "::"
            	      					+ field.getText()
            	      					); 
            	      		
            	    }

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            // EolParserRules.g:188:3: ( '#' label= NAME )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==83) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // EolParserRules.g:188:4: '#' label= NAME
                    {
                    char_literal56=(Token)match(input,83,FOLLOW_83_in_pathName745); if (state.failed) return retval;
                    label=(Token)match(input,NAME,FOLLOW_NAME_in_pathName750); if (state.failed) return retval;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              
              			if (metamodel != null) {
              				head.setText(metamodel.getText() + "!" + head.getText());
              				//System.err.println("Metamodel is not null");
              			}
              				
              			if (label != null) {
              				head.setText(head.getText() + "#" + label.getText());
              				head.setType(ENUMERATION_VALUE);
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

    public static class nativeType_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start nativeType
    // EolParserRules.g:203:1: nativeType : 'Native' '(' STRING ')' ;
    public final Eol_EolParserRules.nativeType_return nativeType() throws RecognitionException {
        Eol_EolParserRules.nativeType_return retval = new Eol_EolParserRules.nativeType_return();
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
            // EolParserRules.g:204:2: ( 'Native' '(' STRING ')' )
            // EolParserRules.g:204:4: 'Native' '(' STRING ')'
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal57=(Token)match(input,84,FOLLOW_84_in_nativeType770); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal57_tree = (CommonTree)adaptor.create(string_literal57);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal57_tree, root_0);
            }
            char_literal58=(Token)match(input,77,FOLLOW_77_in_nativeType773); if (state.failed) return retval;
            STRING59=(Token)match(input,STRING,FOLLOW_STRING_in_nativeType776); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STRING59_tree = (CommonTree)adaptor.create(STRING59);
            adaptor.addChild(root_0, STRING59_tree);
            }
            char_literal60=(Token)match(input,78,FOLLOW_78_in_nativeType778); if (state.failed) return retval;
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

    public static class modelElementType_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start modelElementType
    // EolParserRules.g:209:1: modelElementType : NAME '!' NAME -> ^( ModelElementType ( NAME )+ ) ;
    public final Eol_EolParserRules.modelElementType_return modelElementType() throws RecognitionException {
        Eol_EolParserRules.modelElementType_return retval = new Eol_EolParserRules.modelElementType_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NAME61=null;
        Token char_literal62=null;
        Token NAME63=null;

        CommonTree NAME61_tree=null;
        CommonTree char_literal62_tree=null;
        CommonTree NAME63_tree=null;
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_81=new RewriteRuleTokenStream(adaptor,"token 81");

        try {
            // EolParserRules.g:210:2: ( NAME '!' NAME -> ^( ModelElementType ( NAME )+ ) )
            // EolParserRules.g:210:4: NAME '!' NAME
            {
            NAME61=(Token)match(input,NAME,FOLLOW_NAME_in_modelElementType795); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(NAME61);

            char_literal62=(Token)match(input,81,FOLLOW_81_in_modelElementType797); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_81.add(char_literal62);

            NAME63=(Token)match(input,NAME,FOLLOW_NAME_in_modelElementType799); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(NAME63);



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
            // 211:2: -> ^( ModelElementType ( NAME )+ )
            {
                // EolParserRules.g:211:5: ^( ModelElementType ( NAME )+ )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ModelElementType, "ModelElementType"), root_1);

                if ( !(stream_NAME.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
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
    // $ANTLR end modelElementType

    public static class collectionType_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start collectionType
    // EolParserRules.g:214:1: collectionType : ( 'Collection' | 'Sequence' | 'Bag' | 'Set' | 'OrderedSet' ) ( '(' tn= typeName ')' )? ;
    public final Eol_EolParserRules.collectionType_return collectionType() throws RecognitionException {
        Eol_EolParserRules.collectionType_return retval = new Eol_EolParserRules.collectionType_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set64=null;
        Token char_literal65=null;
        Token char_literal66=null;
        Eol_EolParserRules.typeName_return tn = null;


        CommonTree set64_tree=null;
        CommonTree char_literal65_tree=null;
        CommonTree char_literal66_tree=null;

        try {
            // EolParserRules.g:215:2: ( ( 'Collection' | 'Sequence' | 'Bag' | 'Set' | 'OrderedSet' ) ( '(' tn= typeName ')' )? )
            // EolParserRules.g:215:5: ( 'Collection' | 'Sequence' | 'Bag' | 'Set' | 'OrderedSet' ) ( '(' tn= typeName ')' )?
            {
            root_0 = (CommonTree)adaptor.nil();

            set64=(Token)input.LT(1);
            set64=(Token)input.LT(1);
            if ( (input.LA(1)>=85 && input.LA(1)<=89) ) {
                input.consume();
                if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(set64), root_0);
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            // EolParserRules.g:216:3: ( '(' tn= typeName ')' )?
            int alt22=2;
            alt22 = dfa22.predict(input);
            switch (alt22) {
                case 1 :
                    // EolParserRules.g:216:4: '(' tn= typeName ')'
                    {
                    char_literal65=(Token)match(input,77,FOLLOW_77_in_collectionType837); if (state.failed) return retval;
                    pushFollow(FOLLOW_typeName_in_collectionType842);
                    tn=typeName();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, tn.getTree());
                    if ( state.backtracking==0 ) {
                      setTokenType(tn,TYPE);
                    }
                    char_literal66=(Token)match(input,78,FOLLOW_78_in_collectionType845); if (state.failed) return retval;

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
    // EolParserRules.g:222:1: statement : ( statementA | statementB );
    public final Eol_EolParserRules.statement_return statement() throws RecognitionException {
        Eol_EolParserRules.statement_return retval = new Eol_EolParserRules.statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Eol_EolParserRules.statementA_return statementA67 = null;

        Eol_EolParserRules.statementB_return statementB68 = null;



        try {
            // EolParserRules.g:223:2: ( statementA | statementB )
            int alt23=2;
            alt23 = dfa23.predict(input);
            switch (alt23) {
                case 1 :
                    // EolParserRules.g:223:4: statementA
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_statementA_in_statement868);
                    statementA67=statementA();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statementA67.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:223:17: statementB
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_statementB_in_statement872);
                    statementB68=statementB();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statementB68.getTree());

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
    // EolParserRules.g:226:1: statementA : ( assignmentStatement | expressionStatement | forStatement | ifStatement | whileStatement | returnStatement | breakStatement );
    public final Eol_EolParserRules.statementA_return statementA() throws RecognitionException {
        Eol_EolParserRules.statementA_return retval = new Eol_EolParserRules.statementA_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Eol_EolParserRules.assignmentStatement_return assignmentStatement69 = null;

        Eol_EolParserRules.expressionStatement_return expressionStatement70 = null;

        Eol_EolParserRules.forStatement_return forStatement71 = null;

        Eol_EolParserRules.ifStatement_return ifStatement72 = null;

        Eol_EolParserRules.whileStatement_return whileStatement73 = null;

        Eol_EolParserRules.returnStatement_return returnStatement74 = null;

        Eol_EolParserRules.breakStatement_return breakStatement75 = null;



        try {
            // EolParserRules.g:227:2: ( assignmentStatement | expressionStatement | forStatement | ifStatement | whileStatement | returnStatement | breakStatement )
            int alt24=7;
            alt24 = dfa24.predict(input);
            switch (alt24) {
                case 1 :
                    // EolParserRules.g:227:3: assignmentStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_assignmentStatement_in_statementA882);
                    assignmentStatement69=assignmentStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, assignmentStatement69.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:227:25: expressionStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_expressionStatement_in_statementA886);
                    expressionStatement70=expressionStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionStatement70.getTree());

                    }
                    break;
                case 3 :
                    // EolParserRules.g:227:47: forStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_forStatement_in_statementA890);
                    forStatement71=forStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, forStatement71.getTree());

                    }
                    break;
                case 4 :
                    // EolParserRules.g:228:5: ifStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_ifStatement_in_statementA896);
                    ifStatement72=ifStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, ifStatement72.getTree());

                    }
                    break;
                case 5 :
                    // EolParserRules.g:228:19: whileStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_whileStatement_in_statementA900);
                    whileStatement73=whileStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, whileStatement73.getTree());

                    }
                    break;
                case 6 :
                    // EolParserRules.g:228:36: returnStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_returnStatement_in_statementA904);
                    returnStatement74=returnStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, returnStatement74.getTree());

                    }
                    break;
                case 7 :
                    // EolParserRules.g:228:54: breakStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_breakStatement_in_statementA908);
                    breakStatement75=breakStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, breakStatement75.getTree());

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
    // EolParserRules.g:231:1: statementB : ( breakAllStatement | returnStatement | transactionStatement | abortStatement | continueStatement | throwStatement | deleteStatement );
    public final Eol_EolParserRules.statementB_return statementB() throws RecognitionException {
        Eol_EolParserRules.statementB_return retval = new Eol_EolParserRules.statementB_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Eol_EolParserRules.breakAllStatement_return breakAllStatement76 = null;

        Eol_EolParserRules.returnStatement_return returnStatement77 = null;

        Eol_EolParserRules.transactionStatement_return transactionStatement78 = null;

        Eol_EolParserRules.abortStatement_return abortStatement79 = null;

        Eol_EolParserRules.continueStatement_return continueStatement80 = null;

        Eol_EolParserRules.throwStatement_return throwStatement81 = null;

        Eol_EolParserRules.deleteStatement_return deleteStatement82 = null;



        try {
            // EolParserRules.g:232:2: ( breakAllStatement | returnStatement | transactionStatement | abortStatement | continueStatement | throwStatement | deleteStatement )
            int alt25=7;
            switch ( input.LA(1) ) {
            case 99:
                {
                alt25=1;
                }
                break;
            case 95:
                {
                alt25=2;
                }
                break;
            case 102:
                {
                alt25=3;
                }
                break;
            case 101:
                {
                alt25=4;
                }
                break;
            case 100:
                {
                alt25=5;
                }
                break;
            case 96:
                {
                alt25=6;
                }
                break;
            case 97:
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
                    // EolParserRules.g:232:4: breakAllStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_breakAllStatement_in_statementB920);
                    breakAllStatement76=breakAllStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, breakAllStatement76.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:232:24: returnStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_returnStatement_in_statementB924);
                    returnStatement77=returnStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, returnStatement77.getTree());

                    }
                    break;
                case 3 :
                    // EolParserRules.g:232:42: transactionStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_transactionStatement_in_statementB928);
                    transactionStatement78=transactionStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, transactionStatement78.getTree());

                    }
                    break;
                case 4 :
                    // EolParserRules.g:233:5: abortStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_abortStatement_in_statementB934);
                    abortStatement79=abortStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, abortStatement79.getTree());

                    }
                    break;
                case 5 :
                    // EolParserRules.g:233:22: continueStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_continueStatement_in_statementB938);
                    continueStatement80=continueStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, continueStatement80.getTree());

                    }
                    break;
                case 6 :
                    // EolParserRules.g:233:42: throwStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_throwStatement_in_statementB942);
                    throwStatement81=throwStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, throwStatement81.getTree());

                    }
                    break;
                case 7 :
                    // EolParserRules.g:234:5: deleteStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_deleteStatement_in_statementB948);
                    deleteStatement82=deleteStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, deleteStatement82.getTree());

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
    // EolParserRules.g:237:1: statementOrStatementBlock : ( statement | statementBlock );
    public final Eol_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock() throws RecognitionException {
        Eol_EolParserRules.statementOrStatementBlock_return retval = new Eol_EolParserRules.statementOrStatementBlock_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Eol_EolParserRules.statement_return statement83 = null;

        Eol_EolParserRules.statementBlock_return statementBlock84 = null;



        try {
            // EolParserRules.g:238:2: ( statement | statementBlock )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==FLOAT||LA26_0==INT||LA26_0==BOOLEAN||LA26_0==STRING||LA26_0==NAME||LA26_0==77||(LA26_0>=84 && LA26_0<=90)||LA26_0==92||(LA26_0>=94 && LA26_0<=102)||LA26_0==116||LA26_0==119||(LA26_0>=121 && LA26_0<=122)) ) {
                alt26=1;
            }
            else if ( (LA26_0==72) ) {
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
                    // EolParserRules.g:238:4: statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_statement_in_statementOrStatementBlock959);
                    statement83=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement83.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:238:16: statementBlock
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_statementBlock_in_statementOrStatementBlock963);
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
    // $ANTLR end statementOrStatementBlock

    public static class expressionOrStatementBlock_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start expressionOrStatementBlock
    // EolParserRules.g:240:1: expressionOrStatementBlock : ( ':' logicalExpression | statementBlock );
    public final Eol_EolParserRules.expressionOrStatementBlock_return expressionOrStatementBlock() throws RecognitionException {
        Eol_EolParserRules.expressionOrStatementBlock_return retval = new Eol_EolParserRules.expressionOrStatementBlock_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal85=null;
        Eol_EolParserRules.logicalExpression_return logicalExpression86 = null;

        Eol_EolParserRules.statementBlock_return statementBlock87 = null;


        CommonTree char_literal85_tree=null;

        try {
            // EolParserRules.g:241:2: ( ':' logicalExpression | statementBlock )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==68) ) {
                alt27=1;
            }
            else if ( (LA27_0==72) ) {
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
                    // EolParserRules.g:241:4: ':' logicalExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    char_literal85=(Token)match(input,68,FOLLOW_68_in_expressionOrStatementBlock972); if (state.failed) return retval;
                    pushFollow(FOLLOW_logicalExpression_in_expressionOrStatementBlock975);
                    logicalExpression86=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression86.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:241:29: statementBlock
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_statementBlock_in_expressionOrStatementBlock979);
                    statementBlock87=statementBlock();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statementBlock87.getTree());

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
    // EolParserRules.g:244:1: forStatement : 'for' '(' formalParameter 'in' logicalExpression ')' statementOrStatementBlock -> ^( FOR formalParameter logicalExpression statementOrStatementBlock ) ;
    public final Eol_EolParserRules.forStatement_return forStatement() throws RecognitionException {
        Eol_EolParserRules.forStatement_return retval = new Eol_EolParserRules.forStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal88=null;
        Token char_literal89=null;
        Token string_literal91=null;
        Token char_literal93=null;
        Eol_EolParserRules.formalParameter_return formalParameter90 = null;

        Eol_EolParserRules.logicalExpression_return logicalExpression92 = null;

        Eol_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock94 = null;


        CommonTree string_literal88_tree=null;
        CommonTree char_literal89_tree=null;
        CommonTree string_literal91_tree=null;
        CommonTree char_literal93_tree=null;
        RewriteRuleTokenStream stream_78=new RewriteRuleTokenStream(adaptor,"token 78");
        RewriteRuleTokenStream stream_77=new RewriteRuleTokenStream(adaptor,"token 77");
        RewriteRuleTokenStream stream_91=new RewriteRuleTokenStream(adaptor,"token 91");
        RewriteRuleTokenStream stream_90=new RewriteRuleTokenStream(adaptor,"token 90");
        RewriteRuleSubtreeStream stream_statementOrStatementBlock=new RewriteRuleSubtreeStream(adaptor,"rule statementOrStatementBlock");
        RewriteRuleSubtreeStream stream_formalParameter=new RewriteRuleSubtreeStream(adaptor,"rule formalParameter");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:245:2: ( 'for' '(' formalParameter 'in' logicalExpression ')' statementOrStatementBlock -> ^( FOR formalParameter logicalExpression statementOrStatementBlock ) )
            // EolParserRules.g:245:4: 'for' '(' formalParameter 'in' logicalExpression ')' statementOrStatementBlock
            {
            string_literal88=(Token)match(input,90,FOLLOW_90_in_forStatement990); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_90.add(string_literal88);

            char_literal89=(Token)match(input,77,FOLLOW_77_in_forStatement992); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_77.add(char_literal89);

            pushFollow(FOLLOW_formalParameter_in_forStatement994);
            formalParameter90=formalParameter();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_formalParameter.add(formalParameter90.getTree());
            string_literal91=(Token)match(input,91,FOLLOW_91_in_forStatement996); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_91.add(string_literal91);

            pushFollow(FOLLOW_logicalExpression_in_forStatement998);
            logicalExpression92=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression92.getTree());
            char_literal93=(Token)match(input,78,FOLLOW_78_in_forStatement1000); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_78.add(char_literal93);

            pushFollow(FOLLOW_statementOrStatementBlock_in_forStatement1002);
            statementOrStatementBlock94=statementOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_statementOrStatementBlock.add(statementOrStatementBlock94.getTree());


            // AST REWRITE
            // elements: statementOrStatementBlock, logicalExpression, formalParameter
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 246:2: -> ^( FOR formalParameter logicalExpression statementOrStatementBlock )
            {
                // EolParserRules.g:246:5: ^( FOR formalParameter logicalExpression statementOrStatementBlock )
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
    // EolParserRules.g:249:1: ifStatement : 'if' '(' logicalExpression ')' statementOrStatementBlock ( elseStatement )? -> ^( IF logicalExpression statementOrStatementBlock ( elseStatement )? ) ;
    public final Eol_EolParserRules.ifStatement_return ifStatement() throws RecognitionException {
        Eol_EolParserRules.ifStatement_return retval = new Eol_EolParserRules.ifStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal95=null;
        Token char_literal96=null;
        Token char_literal98=null;
        Eol_EolParserRules.logicalExpression_return logicalExpression97 = null;

        Eol_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock99 = null;

        Eol_EolParserRules.elseStatement_return elseStatement100 = null;


        CommonTree string_literal95_tree=null;
        CommonTree char_literal96_tree=null;
        CommonTree char_literal98_tree=null;
        RewriteRuleTokenStream stream_78=new RewriteRuleTokenStream(adaptor,"token 78");
        RewriteRuleTokenStream stream_77=new RewriteRuleTokenStream(adaptor,"token 77");
        RewriteRuleTokenStream stream_92=new RewriteRuleTokenStream(adaptor,"token 92");
        RewriteRuleSubtreeStream stream_statementOrStatementBlock=new RewriteRuleSubtreeStream(adaptor,"rule statementOrStatementBlock");
        RewriteRuleSubtreeStream stream_elseStatement=new RewriteRuleSubtreeStream(adaptor,"rule elseStatement");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:250:2: ( 'if' '(' logicalExpression ')' statementOrStatementBlock ( elseStatement )? -> ^( IF logicalExpression statementOrStatementBlock ( elseStatement )? ) )
            // EolParserRules.g:250:4: 'if' '(' logicalExpression ')' statementOrStatementBlock ( elseStatement )?
            {
            string_literal95=(Token)match(input,92,FOLLOW_92_in_ifStatement1026); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_92.add(string_literal95);

            char_literal96=(Token)match(input,77,FOLLOW_77_in_ifStatement1028); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_77.add(char_literal96);

            pushFollow(FOLLOW_logicalExpression_in_ifStatement1030);
            logicalExpression97=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression97.getTree());
            char_literal98=(Token)match(input,78,FOLLOW_78_in_ifStatement1032); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_78.add(char_literal98);

            pushFollow(FOLLOW_statementOrStatementBlock_in_ifStatement1034);
            statementOrStatementBlock99=statementOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_statementOrStatementBlock.add(statementOrStatementBlock99.getTree());
            // EolParserRules.g:250:61: ( elseStatement )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==93) ) {
                int LA28_1 = input.LA(2);

                if ( (synpred43_EolParserRules()) ) {
                    alt28=1;
                }
            }
            switch (alt28) {
                case 1 :
                    // EolParserRules.g:0:0: elseStatement
                    {
                    pushFollow(FOLLOW_elseStatement_in_ifStatement1036);
                    elseStatement100=elseStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_elseStatement.add(elseStatement100.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: elseStatement, logicalExpression, statementOrStatementBlock
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 251:2: -> ^( IF logicalExpression statementOrStatementBlock ( elseStatement )? )
            {
                // EolParserRules.g:251:5: ^( IF logicalExpression statementOrStatementBlock ( elseStatement )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(IF, "IF"), root_1);

                adaptor.addChild(root_1, stream_logicalExpression.nextTree());
                adaptor.addChild(root_1, stream_statementOrStatementBlock.nextTree());
                // EolParserRules.g:251:54: ( elseStatement )?
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

    public static class elseStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start elseStatement
    // EolParserRules.g:254:1: elseStatement : 'else' statementOrStatementBlock ;
    public final Eol_EolParserRules.elseStatement_return elseStatement() throws RecognitionException {
        Eol_EolParserRules.elseStatement_return retval = new Eol_EolParserRules.elseStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal101=null;
        Eol_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock102 = null;


        CommonTree string_literal101_tree=null;

        try {
            // EolParserRules.g:255:2: ( 'else' statementOrStatementBlock )
            // EolParserRules.g:255:4: 'else' statementOrStatementBlock
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal101=(Token)match(input,93,FOLLOW_93_in_elseStatement1063); if (state.failed) return retval;
            pushFollow(FOLLOW_statementOrStatementBlock_in_elseStatement1066);
            statementOrStatementBlock102=statementOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, statementOrStatementBlock102.getTree());

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
    // EolParserRules.g:259:1: whileStatement : 'while' '(' logicalExpression ')' statementOrStatementBlock -> ^( WHILE logicalExpression statementOrStatementBlock ) ;
    public final Eol_EolParserRules.whileStatement_return whileStatement() throws RecognitionException {
        Eol_EolParserRules.whileStatement_return retval = new Eol_EolParserRules.whileStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal103=null;
        Token char_literal104=null;
        Token char_literal106=null;
        Eol_EolParserRules.logicalExpression_return logicalExpression105 = null;

        Eol_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock107 = null;


        CommonTree string_literal103_tree=null;
        CommonTree char_literal104_tree=null;
        CommonTree char_literal106_tree=null;
        RewriteRuleTokenStream stream_78=new RewriteRuleTokenStream(adaptor,"token 78");
        RewriteRuleTokenStream stream_77=new RewriteRuleTokenStream(adaptor,"token 77");
        RewriteRuleTokenStream stream_94=new RewriteRuleTokenStream(adaptor,"token 94");
        RewriteRuleSubtreeStream stream_statementOrStatementBlock=new RewriteRuleSubtreeStream(adaptor,"rule statementOrStatementBlock");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:260:2: ( 'while' '(' logicalExpression ')' statementOrStatementBlock -> ^( WHILE logicalExpression statementOrStatementBlock ) )
            // EolParserRules.g:260:4: 'while' '(' logicalExpression ')' statementOrStatementBlock
            {
            string_literal103=(Token)match(input,94,FOLLOW_94_in_whileStatement1079); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_94.add(string_literal103);

            char_literal104=(Token)match(input,77,FOLLOW_77_in_whileStatement1081); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_77.add(char_literal104);

            pushFollow(FOLLOW_logicalExpression_in_whileStatement1083);
            logicalExpression105=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression105.getTree());
            char_literal106=(Token)match(input,78,FOLLOW_78_in_whileStatement1085); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_78.add(char_literal106);

            pushFollow(FOLLOW_statementOrStatementBlock_in_whileStatement1087);
            statementOrStatementBlock107=statementOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_statementOrStatementBlock.add(statementOrStatementBlock107.getTree());


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
            // 261:2: -> ^( WHILE logicalExpression statementOrStatementBlock )
            {
                // EolParserRules.g:261:5: ^( WHILE logicalExpression statementOrStatementBlock )
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
    // EolParserRules.g:264:1: returnStatement : 'return' ( logicalExpression )? ';' -> ^( RETURN ( logicalExpression )? ) ;
    public final Eol_EolParserRules.returnStatement_return returnStatement() throws RecognitionException {
        Eol_EolParserRules.returnStatement_return retval = new Eol_EolParserRules.returnStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal108=null;
        Token char_literal110=null;
        Eol_EolParserRules.logicalExpression_return logicalExpression109 = null;


        CommonTree string_literal108_tree=null;
        CommonTree char_literal110_tree=null;
        RewriteRuleTokenStream stream_67=new RewriteRuleTokenStream(adaptor,"token 67");
        RewriteRuleTokenStream stream_95=new RewriteRuleTokenStream(adaptor,"token 95");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:265:2: ( 'return' ( logicalExpression )? ';' -> ^( RETURN ( logicalExpression )? ) )
            // EolParserRules.g:265:4: 'return' ( logicalExpression )? ';'
            {
            string_literal108=(Token)match(input,95,FOLLOW_95_in_returnStatement1109); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_95.add(string_literal108);

            // EolParserRules.g:265:13: ( logicalExpression )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==FLOAT||LA29_0==INT||LA29_0==BOOLEAN||LA29_0==STRING||LA29_0==NAME||LA29_0==77||(LA29_0>=84 && LA29_0<=89)||LA29_0==116||LA29_0==119||(LA29_0>=121 && LA29_0<=122)) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // EolParserRules.g:0:0: logicalExpression
                    {
                    pushFollow(FOLLOW_logicalExpression_in_returnStatement1111);
                    logicalExpression109=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression109.getTree());

                    }
                    break;

            }

            char_literal110=(Token)match(input,67,FOLLOW_67_in_returnStatement1114); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_67.add(char_literal110);



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
            // 266:2: -> ^( RETURN ( logicalExpression )? )
            {
                // EolParserRules.g:266:5: ^( RETURN ( logicalExpression )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(RETURN, "RETURN"), root_1);

                // EolParserRules.g:266:14: ( logicalExpression )?
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
    // EolParserRules.g:269:1: throwStatement : 'throw' ( logicalExpression )? ';' -> ^( THROW ( logicalExpression )? ) ;
    public final Eol_EolParserRules.throwStatement_return throwStatement() throws RecognitionException {
        Eol_EolParserRules.throwStatement_return retval = new Eol_EolParserRules.throwStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal111=null;
        Token char_literal113=null;
        Eol_EolParserRules.logicalExpression_return logicalExpression112 = null;


        CommonTree string_literal111_tree=null;
        CommonTree char_literal113_tree=null;
        RewriteRuleTokenStream stream_67=new RewriteRuleTokenStream(adaptor,"token 67");
        RewriteRuleTokenStream stream_96=new RewriteRuleTokenStream(adaptor,"token 96");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:270:2: ( 'throw' ( logicalExpression )? ';' -> ^( THROW ( logicalExpression )? ) )
            // EolParserRules.g:270:4: 'throw' ( logicalExpression )? ';'
            {
            string_literal111=(Token)match(input,96,FOLLOW_96_in_throwStatement1135); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_96.add(string_literal111);

            // EolParserRules.g:270:12: ( logicalExpression )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==FLOAT||LA30_0==INT||LA30_0==BOOLEAN||LA30_0==STRING||LA30_0==NAME||LA30_0==77||(LA30_0>=84 && LA30_0<=89)||LA30_0==116||LA30_0==119||(LA30_0>=121 && LA30_0<=122)) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // EolParserRules.g:0:0: logicalExpression
                    {
                    pushFollow(FOLLOW_logicalExpression_in_throwStatement1137);
                    logicalExpression112=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression112.getTree());

                    }
                    break;

            }

            char_literal113=(Token)match(input,67,FOLLOW_67_in_throwStatement1140); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_67.add(char_literal113);



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
            // 271:2: -> ^( THROW ( logicalExpression )? )
            {
                // EolParserRules.g:271:5: ^( THROW ( logicalExpression )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(THROW, "THROW"), root_1);

                // EolParserRules.g:271:13: ( logicalExpression )?
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
    // EolParserRules.g:274:1: deleteStatement : 'delete' ( logicalExpression )? ';' -> ^( DELETE ( logicalExpression )? ) ;
    public final Eol_EolParserRules.deleteStatement_return deleteStatement() throws RecognitionException {
        Eol_EolParserRules.deleteStatement_return retval = new Eol_EolParserRules.deleteStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal114=null;
        Token char_literal116=null;
        Eol_EolParserRules.logicalExpression_return logicalExpression115 = null;


        CommonTree string_literal114_tree=null;
        CommonTree char_literal116_tree=null;
        RewriteRuleTokenStream stream_67=new RewriteRuleTokenStream(adaptor,"token 67");
        RewriteRuleTokenStream stream_97=new RewriteRuleTokenStream(adaptor,"token 97");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:275:2: ( 'delete' ( logicalExpression )? ';' -> ^( DELETE ( logicalExpression )? ) )
            // EolParserRules.g:275:4: 'delete' ( logicalExpression )? ';'
            {
            string_literal114=(Token)match(input,97,FOLLOW_97_in_deleteStatement1161); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_97.add(string_literal114);

            // EolParserRules.g:275:13: ( logicalExpression )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==FLOAT||LA31_0==INT||LA31_0==BOOLEAN||LA31_0==STRING||LA31_0==NAME||LA31_0==77||(LA31_0>=84 && LA31_0<=89)||LA31_0==116||LA31_0==119||(LA31_0>=121 && LA31_0<=122)) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // EolParserRules.g:0:0: logicalExpression
                    {
                    pushFollow(FOLLOW_logicalExpression_in_deleteStatement1163);
                    logicalExpression115=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression115.getTree());

                    }
                    break;

            }

            char_literal116=(Token)match(input,67,FOLLOW_67_in_deleteStatement1166); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_67.add(char_literal116);



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
            // 276:2: -> ^( DELETE ( logicalExpression )? )
            {
                // EolParserRules.g:276:5: ^( DELETE ( logicalExpression )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(DELETE, "DELETE"), root_1);

                // EolParserRules.g:276:14: ( logicalExpression )?
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
    // EolParserRules.g:279:1: breakStatement : 'break' ';' -> ^( BREAK ) ;
    public final Eol_EolParserRules.breakStatement_return breakStatement() throws RecognitionException {
        Eol_EolParserRules.breakStatement_return retval = new Eol_EolParserRules.breakStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal117=null;
        Token char_literal118=null;

        CommonTree string_literal117_tree=null;
        CommonTree char_literal118_tree=null;
        RewriteRuleTokenStream stream_98=new RewriteRuleTokenStream(adaptor,"token 98");
        RewriteRuleTokenStream stream_67=new RewriteRuleTokenStream(adaptor,"token 67");

        try {
            // EolParserRules.g:280:2: ( 'break' ';' -> ^( BREAK ) )
            // EolParserRules.g:280:4: 'break' ';'
            {
            string_literal117=(Token)match(input,98,FOLLOW_98_in_breakStatement1190); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_98.add(string_literal117);

            char_literal118=(Token)match(input,67,FOLLOW_67_in_breakStatement1192); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_67.add(char_literal118);



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
            // 281:2: -> ^( BREAK )
            {
                // EolParserRules.g:281:5: ^( BREAK )
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
    // EolParserRules.g:284:1: breakAllStatement : 'breakAll' ';' -> ^( BREAKALL ) ;
    public final Eol_EolParserRules.breakAllStatement_return breakAllStatement() throws RecognitionException {
        Eol_EolParserRules.breakAllStatement_return retval = new Eol_EolParserRules.breakAllStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal119=null;
        Token char_literal120=null;

        CommonTree string_literal119_tree=null;
        CommonTree char_literal120_tree=null;
        RewriteRuleTokenStream stream_67=new RewriteRuleTokenStream(adaptor,"token 67");
        RewriteRuleTokenStream stream_99=new RewriteRuleTokenStream(adaptor,"token 99");

        try {
            // EolParserRules.g:285:2: ( 'breakAll' ';' -> ^( BREAKALL ) )
            // EolParserRules.g:285:4: 'breakAll' ';'
            {
            string_literal119=(Token)match(input,99,FOLLOW_99_in_breakAllStatement1210); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_99.add(string_literal119);

            char_literal120=(Token)match(input,67,FOLLOW_67_in_breakAllStatement1212); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_67.add(char_literal120);



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
            // 286:2: -> ^( BREAKALL )
            {
                // EolParserRules.g:286:5: ^( BREAKALL )
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
    // EolParserRules.g:289:1: continueStatement : 'continue' ';' -> ^( CONTINUE ) ;
    public final Eol_EolParserRules.continueStatement_return continueStatement() throws RecognitionException {
        Eol_EolParserRules.continueStatement_return retval = new Eol_EolParserRules.continueStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal121=null;
        Token char_literal122=null;

        CommonTree string_literal121_tree=null;
        CommonTree char_literal122_tree=null;
        RewriteRuleTokenStream stream_67=new RewriteRuleTokenStream(adaptor,"token 67");
        RewriteRuleTokenStream stream_100=new RewriteRuleTokenStream(adaptor,"token 100");

        try {
            // EolParserRules.g:290:2: ( 'continue' ';' -> ^( CONTINUE ) )
            // EolParserRules.g:290:4: 'continue' ';'
            {
            string_literal121=(Token)match(input,100,FOLLOW_100_in_continueStatement1230); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_100.add(string_literal121);

            char_literal122=(Token)match(input,67,FOLLOW_67_in_continueStatement1232); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_67.add(char_literal122);



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
            // 291:2: -> ^( CONTINUE )
            {
                // EolParserRules.g:291:5: ^( CONTINUE )
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
    // EolParserRules.g:294:1: abortStatement : 'abort' ';' -> ^( ABORT ) ;
    public final Eol_EolParserRules.abortStatement_return abortStatement() throws RecognitionException {
        Eol_EolParserRules.abortStatement_return retval = new Eol_EolParserRules.abortStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal123=null;
        Token char_literal124=null;

        CommonTree string_literal123_tree=null;
        CommonTree char_literal124_tree=null;
        RewriteRuleTokenStream stream_67=new RewriteRuleTokenStream(adaptor,"token 67");
        RewriteRuleTokenStream stream_101=new RewriteRuleTokenStream(adaptor,"token 101");

        try {
            // EolParserRules.g:295:2: ( 'abort' ';' -> ^( ABORT ) )
            // EolParserRules.g:295:4: 'abort' ';'
            {
            string_literal123=(Token)match(input,101,FOLLOW_101_in_abortStatement1250); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_101.add(string_literal123);

            char_literal124=(Token)match(input,67,FOLLOW_67_in_abortStatement1252); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_67.add(char_literal124);



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
            // 296:2: -> ^( ABORT )
            {
                // EolParserRules.g:296:5: ^( ABORT )
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
    // EolParserRules.g:299:1: transactionStatement : 'transaction' ( NAME ( ',' NAME )* )? statementOrStatementBlock -> ^( TRANSACTION ( NAME )* statementOrStatementBlock ) ;
    public final Eol_EolParserRules.transactionStatement_return transactionStatement() throws RecognitionException {
        Eol_EolParserRules.transactionStatement_return retval = new Eol_EolParserRules.transactionStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal125=null;
        Token NAME126=null;
        Token char_literal127=null;
        Token NAME128=null;
        Eol_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock129 = null;


        CommonTree string_literal125_tree=null;
        CommonTree NAME126_tree=null;
        CommonTree char_literal127_tree=null;
        CommonTree NAME128_tree=null;
        RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_102=new RewriteRuleTokenStream(adaptor,"token 102");
        RewriteRuleSubtreeStream stream_statementOrStatementBlock=new RewriteRuleSubtreeStream(adaptor,"rule statementOrStatementBlock");
        try {
            // EolParserRules.g:300:2: ( 'transaction' ( NAME ( ',' NAME )* )? statementOrStatementBlock -> ^( TRANSACTION ( NAME )* statementOrStatementBlock ) )
            // EolParserRules.g:300:4: 'transaction' ( NAME ( ',' NAME )* )? statementOrStatementBlock
            {
            string_literal125=(Token)match(input,102,FOLLOW_102_in_transactionStatement1270); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_102.add(string_literal125);

            // EolParserRules.g:300:18: ( NAME ( ',' NAME )* )?
            int alt33=2;
            alt33 = dfa33.predict(input);
            switch (alt33) {
                case 1 :
                    // EolParserRules.g:300:19: NAME ( ',' NAME )*
                    {
                    NAME126=(Token)match(input,NAME,FOLLOW_NAME_in_transactionStatement1273); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NAME.add(NAME126);

                    // EolParserRules.g:300:24: ( ',' NAME )*
                    loop32:
                    do {
                        int alt32=2;
                        int LA32_0 = input.LA(1);

                        if ( (LA32_0==69) ) {
                            alt32=1;
                        }


                        switch (alt32) {
                    	case 1 :
                    	    // EolParserRules.g:300:25: ',' NAME
                    	    {
                    	    char_literal127=(Token)match(input,69,FOLLOW_69_in_transactionStatement1276); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_69.add(char_literal127);

                    	    NAME128=(Token)match(input,NAME,FOLLOW_NAME_in_transactionStatement1278); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_NAME.add(NAME128);


                    	    }
                    	    break;

                    	default :
                    	    break loop32;
                        }
                    } while (true);


                    }
                    break;

            }

            pushFollow(FOLLOW_statementOrStatementBlock_in_transactionStatement1284);
            statementOrStatementBlock129=statementOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_statementOrStatementBlock.add(statementOrStatementBlock129.getTree());


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
            // 301:2: -> ^( TRANSACTION ( NAME )* statementOrStatementBlock )
            {
                // EolParserRules.g:301:5: ^( TRANSACTION ( NAME )* statementOrStatementBlock )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TRANSACTION, "TRANSACTION"), root_1);

                // EolParserRules.g:301:19: ( NAME )*
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
    // EolParserRules.g:305:1: assignmentStatement : logicalExpression (normal= ':=' | special= '::=' ) logicalExpression ';' ;
    public final Eol_EolParserRules.assignmentStatement_return assignmentStatement() throws RecognitionException {
        Eol_EolParserRules.assignmentStatement_return retval = new Eol_EolParserRules.assignmentStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token normal=null;
        Token special=null;
        Token char_literal132=null;
        Eol_EolParserRules.logicalExpression_return logicalExpression130 = null;

        Eol_EolParserRules.logicalExpression_return logicalExpression131 = null;


        CommonTree normal_tree=null;
        CommonTree special_tree=null;
        CommonTree char_literal132_tree=null;

        try {
            // EolParserRules.g:309:2: ( logicalExpression (normal= ':=' | special= '::=' ) logicalExpression ';' )
            // EolParserRules.g:309:4: logicalExpression (normal= ':=' | special= '::=' ) logicalExpression ';'
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_logicalExpression_in_assignmentStatement1313);
            logicalExpression130=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression130.getTree());
            // EolParserRules.g:309:22: (normal= ':=' | special= '::=' )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==103) ) {
                alt34=1;
            }
            else if ( (LA34_0==104) ) {
                alt34=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // EolParserRules.g:309:23: normal= ':='
                    {
                    normal=(Token)match(input,103,FOLLOW_103_in_assignmentStatement1318); if (state.failed) return retval;
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
                    // EolParserRules.g:309:66: special= '::='
                    {
                    special=(Token)match(input,104,FOLLOW_104_in_assignmentStatement1325); if (state.failed) return retval;
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

            pushFollow(FOLLOW_logicalExpression_in_assignmentStatement1331);
            logicalExpression131=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression131.getTree());
            char_literal132=(Token)match(input,67,FOLLOW_67_in_assignmentStatement1333); if (state.failed) return retval;

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
    // EolParserRules.g:313:1: expressionStatement : logicalExpression ';' ;
    public final Eol_EolParserRules.expressionStatement_return expressionStatement() throws RecognitionException {
        Eol_EolParserRules.expressionStatement_return retval = new Eol_EolParserRules.expressionStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal134=null;
        Eol_EolParserRules.logicalExpression_return logicalExpression133 = null;


        CommonTree char_literal134_tree=null;

        try {
            // EolParserRules.g:314:2: ( logicalExpression ';' )
            // EolParserRules.g:314:4: logicalExpression ';'
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_logicalExpression_in_expressionStatement1348);
            logicalExpression133=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression133.getTree());
            char_literal134=(Token)match(input,67,FOLLOW_67_in_expressionStatement1350); if (state.failed) return retval;

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
    // EolParserRules.g:317:1: logicalExpression : relationalExpression ( ( 'or' | 'and' | 'xor' | 'implies' ) relationalExpression )* ;
    public final Eol_EolParserRules.logicalExpression_return logicalExpression() throws RecognitionException {
        Eol_EolParserRules.logicalExpression_return retval = new Eol_EolParserRules.logicalExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set136=null;
        Eol_EolParserRules.relationalExpression_return relationalExpression135 = null;

        Eol_EolParserRules.relationalExpression_return relationalExpression137 = null;


        CommonTree set136_tree=null;

        try {
            // EolParserRules.g:318:2: ( relationalExpression ( ( 'or' | 'and' | 'xor' | 'implies' ) relationalExpression )* )
            // EolParserRules.g:318:4: relationalExpression ( ( 'or' | 'and' | 'xor' | 'implies' ) relationalExpression )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_relationalExpression_in_logicalExpression1362);
            relationalExpression135=relationalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, relationalExpression135.getTree());
            // EolParserRules.g:318:25: ( ( 'or' | 'and' | 'xor' | 'implies' ) relationalExpression )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( ((LA35_0>=105 && LA35_0<=108)) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // EolParserRules.g:318:26: ( 'or' | 'and' | 'xor' | 'implies' ) relationalExpression
            	    {
            	    set136=(Token)input.LT(1);
            	    set136=(Token)input.LT(1);
            	    if ( (input.LA(1)>=105 && input.LA(1)<=108) ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(set136), root_0);
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_relationalExpression_in_logicalExpression1376);
            	    relationalExpression137=relationalExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, relationalExpression137.getTree());
            	    if ( state.backtracking==0 ) {
            	      if (root_0.getToken() != null) root_0.getToken().setType(OPERATOR);
            	    }

            	    }
            	    break;

            	default :
            	    break loop35;
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
    // EolParserRules.g:322:1: relationalExpression : additiveExpression ( ( '==' ( relationalExpression )? | '=' ( relationalExpression )? | ( '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression ) )* ;
    public final Eol_EolParserRules.relationalExpression_return relationalExpression() throws RecognitionException {
        Eol_EolParserRules.relationalExpression_return retval = new Eol_EolParserRules.relationalExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal139=null;
        Token char_literal141=null;
        Token set143=null;
        Eol_EolParserRules.additiveExpression_return additiveExpression138 = null;

        Eol_EolParserRules.relationalExpression_return relationalExpression140 = null;

        Eol_EolParserRules.relationalExpression_return relationalExpression142 = null;

        Eol_EolParserRules.additiveExpression_return additiveExpression144 = null;


        CommonTree string_literal139_tree=null;
        CommonTree char_literal141_tree=null;
        CommonTree set143_tree=null;

        try {
            // EolParserRules.g:323:2: ( additiveExpression ( ( '==' ( relationalExpression )? | '=' ( relationalExpression )? | ( '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression ) )* )
            // EolParserRules.g:323:4: additiveExpression ( ( '==' ( relationalExpression )? | '=' ( relationalExpression )? | ( '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression ) )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_additiveExpression_in_relationalExpression1393);
            additiveExpression138=additiveExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, additiveExpression138.getTree());
            // EolParserRules.g:323:23: ( ( '==' ( relationalExpression )? | '=' ( relationalExpression )? | ( '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression ) )*
            loop39:
            do {
                int alt39=2;
                switch ( input.LA(1) ) {
                case 109:
                    {
                    int LA39_2 = input.LA(2);

                    if ( (synpred62_EolParserRules()) ) {
                        alt39=1;
                    }


                    }
                    break;
                case 74:
                    {
                    int LA39_3 = input.LA(2);

                    if ( (synpred62_EolParserRules()) ) {
                        alt39=1;
                    }


                    }
                    break;
                case 110:
                case 111:
                case 112:
                case 113:
                case 114:
                    {
                    int LA39_4 = input.LA(2);

                    if ( (synpred62_EolParserRules()) ) {
                        alt39=1;
                    }


                    }
                    break;

                }

                switch (alt39) {
            	case 1 :
            	    // EolParserRules.g:323:24: ( '==' ( relationalExpression )? | '=' ( relationalExpression )? | ( '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression )
            	    {
            	    // EolParserRules.g:323:24: ( '==' ( relationalExpression )? | '=' ( relationalExpression )? | ( '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression )
            	    int alt38=3;
            	    switch ( input.LA(1) ) {
            	    case 109:
            	        {
            	        alt38=1;
            	        }
            	        break;
            	    case 74:
            	        {
            	        alt38=2;
            	        }
            	        break;
            	    case 110:
            	    case 111:
            	    case 112:
            	    case 113:
            	    case 114:
            	        {
            	        alt38=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 38, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt38) {
            	        case 1 :
            	            // EolParserRules.g:323:25: '==' ( relationalExpression )?
            	            {
            	            string_literal139=(Token)match(input,109,FOLLOW_109_in_relationalExpression1397); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            string_literal139_tree = (CommonTree)adaptor.create(string_literal139);
            	            root_0 = (CommonTree)adaptor.becomeRoot(string_literal139_tree, root_0);
            	            }
            	            // EolParserRules.g:323:31: ( relationalExpression )?
            	            int alt36=2;
            	            int LA36_0 = input.LA(1);

            	            if ( (LA36_0==FLOAT||LA36_0==INT||LA36_0==BOOLEAN||LA36_0==STRING||LA36_0==NAME||LA36_0==77||(LA36_0>=84 && LA36_0<=89)||LA36_0==116||LA36_0==119||(LA36_0>=121 && LA36_0<=122)) ) {
            	                alt36=1;
            	            }
            	            switch (alt36) {
            	                case 1 :
            	                    // EolParserRules.g:0:0: relationalExpression
            	                    {
            	                    pushFollow(FOLLOW_relationalExpression_in_relationalExpression1400);
            	                    relationalExpression140=relationalExpression();

            	                    state._fsp--;
            	                    if (state.failed) return retval;
            	                    if ( state.backtracking==0 ) adaptor.addChild(root_0, relationalExpression140.getTree());

            	                    }
            	                    break;

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // EolParserRules.g:323:55: '=' ( relationalExpression )?
            	            {
            	            char_literal141=(Token)match(input,74,FOLLOW_74_in_relationalExpression1405); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal141_tree = (CommonTree)adaptor.create(char_literal141);
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal141_tree, root_0);
            	            }
            	            // EolParserRules.g:323:60: ( relationalExpression )?
            	            int alt37=2;
            	            int LA37_0 = input.LA(1);

            	            if ( (LA37_0==FLOAT||LA37_0==INT||LA37_0==BOOLEAN||LA37_0==STRING||LA37_0==NAME||LA37_0==77||(LA37_0>=84 && LA37_0<=89)||LA37_0==116||LA37_0==119||(LA37_0>=121 && LA37_0<=122)) ) {
            	                alt37=1;
            	            }
            	            switch (alt37) {
            	                case 1 :
            	                    // EolParserRules.g:0:0: relationalExpression
            	                    {
            	                    pushFollow(FOLLOW_relationalExpression_in_relationalExpression1408);
            	                    relationalExpression142=relationalExpression();

            	                    state._fsp--;
            	                    if (state.failed) return retval;
            	                    if ( state.backtracking==0 ) adaptor.addChild(root_0, relationalExpression142.getTree());

            	                    }
            	                    break;

            	            }


            	            }
            	            break;
            	        case 3 :
            	            // EolParserRules.g:324:24: ( '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression
            	            {
            	            set143=(Token)input.LT(1);
            	            set143=(Token)input.LT(1);
            	            if ( (input.LA(1)>=110 && input.LA(1)<=114) ) {
            	                input.consume();
            	                if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(set143), root_0);
            	                state.errorRecovery=false;state.failed=false;
            	            }
            	            else {
            	                if (state.backtracking>0) {state.failed=true; return retval;}
            	                MismatchedSetException mse = new MismatchedSetException(null,input);
            	                throw mse;
            	            }

            	            pushFollow(FOLLOW_additiveExpression_in_relationalExpression1449);
            	            additiveExpression144=additiveExpression();

            	            state._fsp--;
            	            if (state.failed) return retval;
            	            if ( state.backtracking==0 ) adaptor.addChild(root_0, additiveExpression144.getTree());

            	            }
            	            break;

            	    }

            	    if ( state.backtracking==0 ) {
            	      if (root_0.getToken() != null) root_0.getToken().setType(OPERATOR);
            	    }

            	    }
            	    break;

            	default :
            	    break loop39;
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
    // EolParserRules.g:328:1: additiveExpression : multiplicativeExpression ( ( '+' | '-' ) multiplicativeExpression )* ;
    public final Eol_EolParserRules.additiveExpression_return additiveExpression() throws RecognitionException {
        Eol_EolParserRules.additiveExpression_return retval = new Eol_EolParserRules.additiveExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set146=null;
        Eol_EolParserRules.multiplicativeExpression_return multiplicativeExpression145 = null;

        Eol_EolParserRules.multiplicativeExpression_return multiplicativeExpression147 = null;


        CommonTree set146_tree=null;

        try {
            // EolParserRules.g:329:2: ( multiplicativeExpression ( ( '+' | '-' ) multiplicativeExpression )* )
            // EolParserRules.g:329:4: multiplicativeExpression ( ( '+' | '-' ) multiplicativeExpression )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_multiplicativeExpression_in_additiveExpression1467);
            multiplicativeExpression145=multiplicativeExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, multiplicativeExpression145.getTree());
            // EolParserRules.g:329:29: ( ( '+' | '-' ) multiplicativeExpression )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( ((LA40_0>=115 && LA40_0<=116)) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // EolParserRules.g:329:30: ( '+' | '-' ) multiplicativeExpression
            	    {
            	    set146=(Token)input.LT(1);
            	    set146=(Token)input.LT(1);
            	    if ( (input.LA(1)>=115 && input.LA(1)<=116) ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(set146), root_0);
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_multiplicativeExpression_in_additiveExpression1477);
            	    multiplicativeExpression147=multiplicativeExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, multiplicativeExpression147.getTree());
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
    // $ANTLR end additiveExpression

    public static class multiplicativeExpression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start multiplicativeExpression
    // EolParserRules.g:334:1: multiplicativeExpression : unaryExpression ( ( '*' | '/' ) unaryExpression )* ;
    public final Eol_EolParserRules.multiplicativeExpression_return multiplicativeExpression() throws RecognitionException {
        Eol_EolParserRules.multiplicativeExpression_return retval = new Eol_EolParserRules.multiplicativeExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set149=null;
        Eol_EolParserRules.unaryExpression_return unaryExpression148 = null;

        Eol_EolParserRules.unaryExpression_return unaryExpression150 = null;


        CommonTree set149_tree=null;

        try {
            // EolParserRules.g:335:2: ( unaryExpression ( ( '*' | '/' ) unaryExpression )* )
            // EolParserRules.g:335:4: unaryExpression ( ( '*' | '/' ) unaryExpression )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_unaryExpression_in_multiplicativeExpression1498);
            unaryExpression148=unaryExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, unaryExpression148.getTree());
            // EolParserRules.g:335:20: ( ( '*' | '/' ) unaryExpression )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( ((LA41_0>=117 && LA41_0<=118)) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // EolParserRules.g:335:21: ( '*' | '/' ) unaryExpression
            	    {
            	    set149=(Token)input.LT(1);
            	    set149=(Token)input.LT(1);
            	    if ( (input.LA(1)>=117 && input.LA(1)<=118) ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(set149), root_0);
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_unaryExpression_in_multiplicativeExpression1508);
            	    unaryExpression150=unaryExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, unaryExpression150.getTree());
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
    // $ANTLR end multiplicativeExpression

    public static class unaryExpression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start unaryExpression
    // EolParserRules.g:339:1: unaryExpression : ( ( 'not' | '-' ) )? postfixExpression ;
    public final Eol_EolParserRules.unaryExpression_return unaryExpression() throws RecognitionException {
        Eol_EolParserRules.unaryExpression_return retval = new Eol_EolParserRules.unaryExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set151=null;
        Eol_EolParserRules.postfixExpression_return postfixExpression152 = null;


        CommonTree set151_tree=null;

        try {
            // EolParserRules.g:340:2: ( ( ( 'not' | '-' ) )? postfixExpression )
            // EolParserRules.g:340:4: ( ( 'not' | '-' ) )? postfixExpression
            {
            root_0 = (CommonTree)adaptor.nil();

            // EolParserRules.g:340:4: ( ( 'not' | '-' ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==116||LA42_0==119) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // EolParserRules.g:340:5: ( 'not' | '-' )
                    {
                    set151=(Token)input.LT(1);
                    set151=(Token)input.LT(1);
                    if ( input.LA(1)==116||input.LA(1)==119 ) {
                        input.consume();
                        if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(set151), root_0);
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

            pushFollow(FOLLOW_postfixExpression_in_unaryExpression1535);
            postfixExpression152=postfixExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, postfixExpression152.getTree());
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
    // EolParserRules.g:344:1: postfixExpression : primitiveExpression ( ( POINT | ARROW ) fc= featureCall )* ;
    public final Eol_EolParserRules.postfixExpression_return postfixExpression() throws RecognitionException {
        Eol_EolParserRules.postfixExpression_return retval = new Eol_EolParserRules.postfixExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set154=null;
        Eol_EolParserRules.featureCall_return fc = null;

        Eol_EolParserRules.primitiveExpression_return primitiveExpression153 = null;


        CommonTree set154_tree=null;

        try {
            // EolParserRules.g:345:2: ( primitiveExpression ( ( POINT | ARROW ) fc= featureCall )* )
            // EolParserRules.g:345:4: primitiveExpression ( ( POINT | ARROW ) fc= featureCall )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_primitiveExpression_in_postfixExpression1550);
            primitiveExpression153=primitiveExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, primitiveExpression153.getTree());
            // EolParserRules.g:345:23: ( ( POINT | ARROW ) fc= featureCall )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==POINT||LA43_0==ARROW) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // EolParserRules.g:345:24: ( POINT | ARROW ) fc= featureCall
            	    {
            	    set154=(Token)input.LT(1);
            	    set154=(Token)input.LT(1);
            	    if ( input.LA(1)==POINT||input.LA(1)==ARROW ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(set154), root_0);
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_featureCall_in_postfixExpression1561);
            	    fc=featureCall();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, fc.getTree());
            	    if ( state.backtracking==0 ) {
            	      setTokenType(fc,FEATURECALL);
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
    // $ANTLR end postfixExpression

    public static class featureCall_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start featureCall
    // EolParserRules.g:355:1: featureCall : ( simpleFeatureCall | declarativeFeatureCall );
    public final Eol_EolParserRules.featureCall_return featureCall() throws RecognitionException {
        Eol_EolParserRules.featureCall_return retval = new Eol_EolParserRules.featureCall_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Eol_EolParserRules.simpleFeatureCall_return simpleFeatureCall155 = null;

        Eol_EolParserRules.declarativeFeatureCall_return declarativeFeatureCall156 = null;



        try {
            // EolParserRules.g:356:2: ( simpleFeatureCall | declarativeFeatureCall )
            int alt44=2;
            alt44 = dfa44.predict(input);
            switch (alt44) {
                case 1 :
                    // EolParserRules.g:356:4: simpleFeatureCall
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_simpleFeatureCall_in_featureCall1596);
                    simpleFeatureCall155=simpleFeatureCall();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, simpleFeatureCall155.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:356:24: declarativeFeatureCall
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_declarativeFeatureCall_in_featureCall1600);
                    declarativeFeatureCall156=declarativeFeatureCall();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, declarativeFeatureCall156.getTree());

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
    // EolParserRules.g:359:1: simpleFeatureCall : NAME ( parameterList )? ;
    public final Eol_EolParserRules.simpleFeatureCall_return simpleFeatureCall() throws RecognitionException {
        Eol_EolParserRules.simpleFeatureCall_return retval = new Eol_EolParserRules.simpleFeatureCall_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NAME157=null;
        Eol_EolParserRules.parameterList_return parameterList158 = null;


        CommonTree NAME157_tree=null;

        try {
            // EolParserRules.g:360:2: ( NAME ( parameterList )? )
            // EolParserRules.g:360:5: NAME ( parameterList )?
            {
            root_0 = (CommonTree)adaptor.nil();

            NAME157=(Token)match(input,NAME,FOLLOW_NAME_in_simpleFeatureCall1612); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME157_tree = (CommonTree)adaptor.create(NAME157);
            root_0 = (CommonTree)adaptor.becomeRoot(NAME157_tree, root_0);
            }
            // EolParserRules.g:360:11: ( parameterList )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==77) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // EolParserRules.g:0:0: parameterList
                    {
                    pushFollow(FOLLOW_parameterList_in_simpleFeatureCall1615);
                    parameterList158=parameterList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, parameterList158.getTree());

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
    // EolParserRules.g:364:1: parameterList : '(' ( logicalExpression ( ',' logicalExpression )* )? ')' -> ^( PARAMETERS ( logicalExpression )* ) ;
    public final Eol_EolParserRules.parameterList_return parameterList() throws RecognitionException {
        Eol_EolParserRules.parameterList_return retval = new Eol_EolParserRules.parameterList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal159=null;
        Token char_literal161=null;
        Token char_literal163=null;
        Eol_EolParserRules.logicalExpression_return logicalExpression160 = null;

        Eol_EolParserRules.logicalExpression_return logicalExpression162 = null;


        CommonTree char_literal159_tree=null;
        CommonTree char_literal161_tree=null;
        CommonTree char_literal163_tree=null;
        RewriteRuleTokenStream stream_78=new RewriteRuleTokenStream(adaptor,"token 78");
        RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
        RewriteRuleTokenStream stream_77=new RewriteRuleTokenStream(adaptor,"token 77");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:365:2: ( '(' ( logicalExpression ( ',' logicalExpression )* )? ')' -> ^( PARAMETERS ( logicalExpression )* ) )
            // EolParserRules.g:365:4: '(' ( logicalExpression ( ',' logicalExpression )* )? ')'
            {
            char_literal159=(Token)match(input,77,FOLLOW_77_in_parameterList1630); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_77.add(char_literal159);

            // EolParserRules.g:365:8: ( logicalExpression ( ',' logicalExpression )* )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==FLOAT||LA47_0==INT||LA47_0==BOOLEAN||LA47_0==STRING||LA47_0==NAME||LA47_0==77||(LA47_0>=84 && LA47_0<=89)||LA47_0==116||LA47_0==119||(LA47_0>=121 && LA47_0<=122)) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // EolParserRules.g:365:9: logicalExpression ( ',' logicalExpression )*
                    {
                    pushFollow(FOLLOW_logicalExpression_in_parameterList1633);
                    logicalExpression160=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression160.getTree());
                    // EolParserRules.g:365:27: ( ',' logicalExpression )*
                    loop46:
                    do {
                        int alt46=2;
                        int LA46_0 = input.LA(1);

                        if ( (LA46_0==69) ) {
                            alt46=1;
                        }


                        switch (alt46) {
                    	case 1 :
                    	    // EolParserRules.g:365:28: ',' logicalExpression
                    	    {
                    	    char_literal161=(Token)match(input,69,FOLLOW_69_in_parameterList1636); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_69.add(char_literal161);

                    	    pushFollow(FOLLOW_logicalExpression_in_parameterList1638);
                    	    logicalExpression162=logicalExpression();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression162.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop46;
                        }
                    } while (true);


                    }
                    break;

            }

            char_literal163=(Token)match(input,78,FOLLOW_78_in_parameterList1644); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_78.add(char_literal163);



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
            // 366:3: -> ^( PARAMETERS ( logicalExpression )* )
            {
                // EolParserRules.g:366:6: ^( PARAMETERS ( logicalExpression )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PARAMETERS, "PARAMETERS"), root_1);

                // EolParserRules.g:366:19: ( logicalExpression )*
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
    // EolParserRules.g:369:1: declarativeFeatureCall : NAME '(' formalParameterList '|' logicalExpression ( ',' logicalExpression )* ')' ;
    public final Eol_EolParserRules.declarativeFeatureCall_return declarativeFeatureCall() throws RecognitionException {
        Eol_EolParserRules.declarativeFeatureCall_return retval = new Eol_EolParserRules.declarativeFeatureCall_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NAME164=null;
        Token char_literal165=null;
        Token char_literal167=null;
        Token char_literal169=null;
        Token char_literal171=null;
        Eol_EolParserRules.formalParameterList_return formalParameterList166 = null;

        Eol_EolParserRules.logicalExpression_return logicalExpression168 = null;

        Eol_EolParserRules.logicalExpression_return logicalExpression170 = null;


        CommonTree NAME164_tree=null;
        CommonTree char_literal165_tree=null;
        CommonTree char_literal167_tree=null;
        CommonTree char_literal169_tree=null;
        CommonTree char_literal171_tree=null;

        try {
            // EolParserRules.g:370:2: ( NAME '(' formalParameterList '|' logicalExpression ( ',' logicalExpression )* ')' )
            // EolParserRules.g:370:4: NAME '(' formalParameterList '|' logicalExpression ( ',' logicalExpression )* ')'
            {
            root_0 = (CommonTree)adaptor.nil();

            NAME164=(Token)match(input,NAME,FOLLOW_NAME_in_declarativeFeatureCall1666); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME164_tree = (CommonTree)adaptor.create(NAME164);
            root_0 = (CommonTree)adaptor.becomeRoot(NAME164_tree, root_0);
            }
            char_literal165=(Token)match(input,77,FOLLOW_77_in_declarativeFeatureCall1669); if (state.failed) return retval;
            pushFollow(FOLLOW_formalParameterList_in_declarativeFeatureCall1672);
            formalParameterList166=formalParameterList();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, formalParameterList166.getTree());
            char_literal167=(Token)match(input,120,FOLLOW_120_in_declarativeFeatureCall1674); if (state.failed) return retval;
            pushFollow(FOLLOW_logicalExpression_in_declarativeFeatureCall1677);
            logicalExpression168=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression168.getTree());
            // EolParserRules.g:370:58: ( ',' logicalExpression )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==69) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // EolParserRules.g:370:59: ',' logicalExpression
            	    {
            	    char_literal169=(Token)match(input,69,FOLLOW_69_in_declarativeFeatureCall1680); if (state.failed) return retval;
            	    pushFollow(FOLLOW_logicalExpression_in_declarativeFeatureCall1683);
            	    logicalExpression170=logicalExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression170.getTree());

            	    }
            	    break;

            	default :
            	    break loop48;
                }
            } while (true);

            char_literal171=(Token)match(input,78,FOLLOW_78_in_declarativeFeatureCall1687); if (state.failed) return retval;

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
    // EolParserRules.g:373:1: newExpression : 'new' tn= typeName ( parameterList )? ;
    public final Eol_EolParserRules.newExpression_return newExpression() throws RecognitionException {
        Eol_EolParserRules.newExpression_return retval = new Eol_EolParserRules.newExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal172=null;
        Eol_EolParserRules.typeName_return tn = null;

        Eol_EolParserRules.parameterList_return parameterList173 = null;


        CommonTree string_literal172_tree=null;

        try {
            // EolParserRules.g:374:2: ( 'new' tn= typeName ( parameterList )? )
            // EolParserRules.g:374:4: 'new' tn= typeName ( parameterList )?
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal172=(Token)match(input,121,FOLLOW_121_in_newExpression1699); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal172_tree = (CommonTree)adaptor.create(string_literal172);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal172_tree, root_0);
            }
            pushFollow(FOLLOW_typeName_in_newExpression1704);
            tn=typeName();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, tn.getTree());
            if ( state.backtracking==0 ) {
              setTokenType(tn,TYPE);
            }
            // EolParserRules.g:374:48: ( parameterList )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==77) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // EolParserRules.g:0:0: parameterList
                    {
                    pushFollow(FOLLOW_parameterList_in_newExpression1708);
                    parameterList173=parameterList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, parameterList173.getTree());

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
    // EolParserRules.g:380:1: variableDeclarationExpression : 'var' NAME ( ':' (n= 'new' )? t= typeName ( parameterList )? )? -> ^( VAR NAME ( typeName )? ( parameterList )? ) ;
    public final Eol_EolParserRules.variableDeclarationExpression_return variableDeclarationExpression() throws RecognitionException {
        Eol_EolParserRules.variableDeclarationExpression_return retval = new Eol_EolParserRules.variableDeclarationExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token n=null;
        Token string_literal174=null;
        Token NAME175=null;
        Token char_literal176=null;
        Eol_EolParserRules.typeName_return t = null;

        Eol_EolParserRules.parameterList_return parameterList177 = null;


        CommonTree n_tree=null;
        CommonTree string_literal174_tree=null;
        CommonTree NAME175_tree=null;
        CommonTree char_literal176_tree=null;
        RewriteRuleTokenStream stream_68=new RewriteRuleTokenStream(adaptor,"token 68");
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_121=new RewriteRuleTokenStream(adaptor,"token 121");
        RewriteRuleTokenStream stream_122=new RewriteRuleTokenStream(adaptor,"token 122");
        RewriteRuleSubtreeStream stream_typeName=new RewriteRuleSubtreeStream(adaptor,"rule typeName");
        RewriteRuleSubtreeStream stream_parameterList=new RewriteRuleSubtreeStream(adaptor,"rule parameterList");
        try {
            // EolParserRules.g:388:2: ( 'var' NAME ( ':' (n= 'new' )? t= typeName ( parameterList )? )? -> ^( VAR NAME ( typeName )? ( parameterList )? ) )
            // EolParserRules.g:388:4: 'var' NAME ( ':' (n= 'new' )? t= typeName ( parameterList )? )?
            {
            string_literal174=(Token)match(input,122,FOLLOW_122_in_variableDeclarationExpression1733); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_122.add(string_literal174);

            NAME175=(Token)match(input,NAME,FOLLOW_NAME_in_variableDeclarationExpression1735); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(NAME175);

            // EolParserRules.g:388:15: ( ':' (n= 'new' )? t= typeName ( parameterList )? )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==68) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // EolParserRules.g:388:16: ':' (n= 'new' )? t= typeName ( parameterList )?
                    {
                    char_literal176=(Token)match(input,68,FOLLOW_68_in_variableDeclarationExpression1738); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_68.add(char_literal176);

                    // EolParserRules.g:388:21: (n= 'new' )?
                    int alt50=2;
                    int LA50_0 = input.LA(1);

                    if ( (LA50_0==121) ) {
                        alt50=1;
                    }
                    switch (alt50) {
                        case 1 :
                            // EolParserRules.g:0:0: n= 'new'
                            {
                            n=(Token)match(input,121,FOLLOW_121_in_variableDeclarationExpression1742); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_121.add(n);


                            }
                            break;

                    }

                    pushFollow(FOLLOW_typeName_in_variableDeclarationExpression1747);
                    t=typeName();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_typeName.add(t.getTree());
                    if ( state.backtracking==0 ) {
                      setTokenType(t, TYPE);
                    }
                    // EolParserRules.g:388:65: ( parameterList )?
                    int alt51=2;
                    int LA51_0 = input.LA(1);

                    if ( (LA51_0==77) ) {
                        alt51=1;
                    }
                    switch (alt51) {
                        case 1 :
                            // EolParserRules.g:0:0: parameterList
                            {
                            pushFollow(FOLLOW_parameterList_in_variableDeclarationExpression1751);
                            parameterList177=parameterList();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_parameterList.add(parameterList177.getTree());

                            }
                            break;

                    }


                    }
                    break;

            }



            // AST REWRITE
            // elements: parameterList, NAME, typeName
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 389:2: -> ^( VAR NAME ( typeName )? ( parameterList )? )
            {
                // EolParserRules.g:389:5: ^( VAR NAME ( typeName )? ( parameterList )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VAR, "VAR"), root_1);

                adaptor.addChild(root_1, stream_NAME.nextNode());
                // EolParserRules.g:389:16: ( typeName )?
                if ( stream_typeName.hasNext() ) {
                    adaptor.addChild(root_1, stream_typeName.nextTree());

                }
                stream_typeName.reset();
                // EolParserRules.g:389:26: ( parameterList )?
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

    public static class litteralCollection_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start litteralCollection
    // EolParserRules.g:392:1: litteralCollection : ( 'Collection' | 'Sequence' | 'Bag' | 'Set' | 'OrderedSet' ) '{' ( expressionListOrRange )? '}' ;
    public final Eol_EolParserRules.litteralCollection_return litteralCollection() throws RecognitionException {
        Eol_EolParserRules.litteralCollection_return retval = new Eol_EolParserRules.litteralCollection_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set178=null;
        Token char_literal179=null;
        Token char_literal181=null;
        Eol_EolParserRules.expressionListOrRange_return expressionListOrRange180 = null;


        CommonTree set178_tree=null;
        CommonTree char_literal179_tree=null;
        CommonTree char_literal181_tree=null;

        try {
            // EolParserRules.g:393:2: ( ( 'Collection' | 'Sequence' | 'Bag' | 'Set' | 'OrderedSet' ) '{' ( expressionListOrRange )? '}' )
            // EolParserRules.g:393:4: ( 'Collection' | 'Sequence' | 'Bag' | 'Set' | 'OrderedSet' ) '{' ( expressionListOrRange )? '}'
            {
            root_0 = (CommonTree)adaptor.nil();

            set178=(Token)input.LT(1);
            set178=(Token)input.LT(1);
            if ( (input.LA(1)>=85 && input.LA(1)<=89) ) {
                input.consume();
                if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(set178), root_0);
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            char_literal179=(Token)match(input,72,FOLLOW_72_in_litteralCollection1794); if (state.failed) return retval;
            // EolParserRules.g:393:62: ( expressionListOrRange )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==FLOAT||LA53_0==INT||LA53_0==BOOLEAN||LA53_0==STRING||LA53_0==NAME||LA53_0==77||(LA53_0>=84 && LA53_0<=89)||LA53_0==116||LA53_0==119||(LA53_0>=121 && LA53_0<=122)) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // EolParserRules.g:0:0: expressionListOrRange
                    {
                    pushFollow(FOLLOW_expressionListOrRange_in_litteralCollection1798);
                    expressionListOrRange180=expressionListOrRange();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionListOrRange180.getTree());

                    }
                    break;

            }

            char_literal181=(Token)match(input,73,FOLLOW_73_in_litteralCollection1801); if (state.failed) return retval;
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
    // $ANTLR end litteralCollection

    public static class expressionRange_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start expressionRange
    // EolParserRules.g:397:1: expressionRange : logicalExpression '..' logicalExpression -> ^( EXPRRANGE ( logicalExpression )+ ) ;
    public final Eol_EolParserRules.expressionRange_return expressionRange() throws RecognitionException {
        Eol_EolParserRules.expressionRange_return retval = new Eol_EolParserRules.expressionRange_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal183=null;
        Eol_EolParserRules.logicalExpression_return logicalExpression182 = null;

        Eol_EolParserRules.logicalExpression_return logicalExpression184 = null;


        CommonTree string_literal183_tree=null;
        RewriteRuleTokenStream stream_POINT_POINT=new RewriteRuleTokenStream(adaptor,"token POINT_POINT");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:398:2: ( logicalExpression '..' logicalExpression -> ^( EXPRRANGE ( logicalExpression )+ ) )
            // EolParserRules.g:398:4: logicalExpression '..' logicalExpression
            {
            pushFollow(FOLLOW_logicalExpression_in_expressionRange1816);
            logicalExpression182=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression182.getTree());
            string_literal183=(Token)match(input,POINT_POINT,FOLLOW_POINT_POINT_in_expressionRange1818); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_POINT_POINT.add(string_literal183);

            pushFollow(FOLLOW_logicalExpression_in_expressionRange1820);
            logicalExpression184=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression184.getTree());


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
            // 399:2: -> ^( EXPRRANGE ( logicalExpression )+ )
            {
                // EolParserRules.g:399:5: ^( EXPRRANGE ( logicalExpression )+ )
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
    // EolParserRules.g:402:1: expressionList : logicalExpression ( ',' logicalExpression )* -> ^( EXPRLIST ( logicalExpression )+ ) ;
    public final Eol_EolParserRules.expressionList_return expressionList() throws RecognitionException {
        Eol_EolParserRules.expressionList_return retval = new Eol_EolParserRules.expressionList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal186=null;
        Eol_EolParserRules.logicalExpression_return logicalExpression185 = null;

        Eol_EolParserRules.logicalExpression_return logicalExpression187 = null;


        CommonTree char_literal186_tree=null;
        RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:403:2: ( logicalExpression ( ',' logicalExpression )* -> ^( EXPRLIST ( logicalExpression )+ ) )
            // EolParserRules.g:403:4: logicalExpression ( ',' logicalExpression )*
            {
            pushFollow(FOLLOW_logicalExpression_in_expressionList1842);
            logicalExpression185=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression185.getTree());
            // EolParserRules.g:403:22: ( ',' logicalExpression )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==69) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // EolParserRules.g:403:23: ',' logicalExpression
            	    {
            	    char_literal186=(Token)match(input,69,FOLLOW_69_in_expressionList1845); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_69.add(char_literal186);

            	    pushFollow(FOLLOW_logicalExpression_in_expressionList1847);
            	    logicalExpression187=logicalExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression187.getTree());

            	    }
            	    break;

            	default :
            	    break loop54;
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
            // 404:2: -> ^( EXPRLIST ( logicalExpression )+ )
            {
                // EolParserRules.g:404:5: ^( EXPRLIST ( logicalExpression )+ )
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
    // EolParserRules.g:407:1: expressionListOrRange : ( expressionRange | expressionList );
    public final Eol_EolParserRules.expressionListOrRange_return expressionListOrRange() throws RecognitionException {
        Eol_EolParserRules.expressionListOrRange_return retval = new Eol_EolParserRules.expressionListOrRange_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Eol_EolParserRules.expressionRange_return expressionRange188 = null;

        Eol_EolParserRules.expressionList_return expressionList189 = null;



        try {
            // EolParserRules.g:408:2: ( expressionRange | expressionList )
            int alt55=2;
            alt55 = dfa55.predict(input);
            switch (alt55) {
                case 1 :
                    // EolParserRules.g:408:4: expressionRange
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_expressionRange_in_expressionListOrRange1871);
                    expressionRange188=expressionRange();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionRange188.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:408:22: expressionList
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_expressionList_in_expressionListOrRange1875);
                    expressionList189=expressionList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionList189.getTree());

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

    public static class primitiveExpression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start primitiveExpression
    // EolParserRules.g:416:1: primitiveExpression : ( litteralCollection | literal | featureCall | pathName | nativeType | collectionType | '(' logicalExpression ')' | newExpression | variableDeclarationExpression );
    public final Eol_EolParserRules.primitiveExpression_return primitiveExpression() throws RecognitionException {
        Eol_EolParserRules.primitiveExpression_return retval = new Eol_EolParserRules.primitiveExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal196=null;
        Token char_literal198=null;
        Eol_EolParserRules.litteralCollection_return litteralCollection190 = null;

        Eol_EolParserRules.literal_return literal191 = null;

        Eol_EolParserRules.featureCall_return featureCall192 = null;

        Eol_EolParserRules.pathName_return pathName193 = null;

        Eol_EolParserRules.nativeType_return nativeType194 = null;

        Eol_EolParserRules.collectionType_return collectionType195 = null;

        Eol_EolParserRules.logicalExpression_return logicalExpression197 = null;

        Eol_EolParserRules.newExpression_return newExpression199 = null;

        Eol_EolParserRules.variableDeclarationExpression_return variableDeclarationExpression200 = null;


        CommonTree char_literal196_tree=null;
        CommonTree char_literal198_tree=null;

        try {
            // EolParserRules.g:417:2: ( litteralCollection | literal | featureCall | pathName | nativeType | collectionType | '(' logicalExpression ')' | newExpression | variableDeclarationExpression )
            int alt56=9;
            alt56 = dfa56.predict(input);
            switch (alt56) {
                case 1 :
                    // EolParserRules.g:417:4: litteralCollection
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_litteralCollection_in_primitiveExpression1897);
                    litteralCollection190=litteralCollection();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, litteralCollection190.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:417:25: literal
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_literal_in_primitiveExpression1901);
                    literal191=literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, literal191.getTree());

                    }
                    break;
                case 3 :
                    // EolParserRules.g:417:35: featureCall
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_featureCall_in_primitiveExpression1905);
                    featureCall192=featureCall();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, featureCall192.getTree());

                    }
                    break;
                case 4 :
                    // EolParserRules.g:417:49: pathName
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_pathName_in_primitiveExpression1909);
                    pathName193=pathName();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pathName193.getTree());

                    }
                    break;
                case 5 :
                    // EolParserRules.g:417:60: nativeType
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_nativeType_in_primitiveExpression1913);
                    nativeType194=nativeType();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nativeType194.getTree());

                    }
                    break;
                case 6 :
                    // EolParserRules.g:418:5: collectionType
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_collectionType_in_primitiveExpression1919);
                    collectionType195=collectionType();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, collectionType195.getTree());

                    }
                    break;
                case 7 :
                    // EolParserRules.g:418:23: '(' logicalExpression ')'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    char_literal196=(Token)match(input,77,FOLLOW_77_in_primitiveExpression1924); if (state.failed) return retval;
                    pushFollow(FOLLOW_logicalExpression_in_primitiveExpression1927);
                    logicalExpression197=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression197.getTree());
                    char_literal198=(Token)match(input,78,FOLLOW_78_in_primitiveExpression1929); if (state.failed) return retval;

                    }
                    break;
                case 8 :
                    // EolParserRules.g:419:5: newExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_newExpression_in_primitiveExpression1937);
                    newExpression199=newExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, newExpression199.getTree());

                    }
                    break;
                case 9 :
                    // EolParserRules.g:419:21: variableDeclarationExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_variableDeclarationExpression_in_primitiveExpression1941);
                    variableDeclarationExpression200=variableDeclarationExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, variableDeclarationExpression200.getTree());

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
    // EolParserRules.g:422:1: literal : ( STRING | INT | FLOAT | BOOLEAN );
    public final Eol_EolParserRules.literal_return literal() throws RecognitionException {
        Eol_EolParserRules.literal_return retval = new Eol_EolParserRules.literal_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set201=null;

        CommonTree set201_tree=null;

        try {
            // EolParserRules.g:423:2: ( STRING | INT | FLOAT | BOOLEAN )
            // EolParserRules.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set201=(Token)input.LT(1);
            if ( input.LA(1)==FLOAT||input.LA(1)==INT||input.LA(1)==BOOLEAN||input.LA(1)==STRING ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set201));
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

    // $ANTLR start synpred27_EolParserRules
    public final void synpred27_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:216:4: ( '(' typeName ')' )
        // EolParserRules.g:216:4: '(' typeName ')'
        {
        match(input,77,FOLLOW_77_in_synpred27_EolParserRules837); if (state.failed) return ;
        pushFollow(FOLLOW_typeName_in_synpred27_EolParserRules842);
        typeName();

        state._fsp--;
        if (state.failed) return ;
        match(input,78,FOLLOW_78_in_synpred27_EolParserRules845); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred27_EolParserRules

    // $ANTLR start synpred28_EolParserRules
    public final void synpred28_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:223:4: ( statementA )
        // EolParserRules.g:223:4: statementA
        {
        pushFollow(FOLLOW_statementA_in_synpred28_EolParserRules868);
        statementA();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred28_EolParserRules

    // $ANTLR start synpred29_EolParserRules
    public final void synpred29_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:227:3: ( assignmentStatement )
        // EolParserRules.g:227:3: assignmentStatement
        {
        pushFollow(FOLLOW_assignmentStatement_in_synpred29_EolParserRules882);
        assignmentStatement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred29_EolParserRules

    // $ANTLR start synpred30_EolParserRules
    public final void synpred30_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:227:25: ( expressionStatement )
        // EolParserRules.g:227:25: expressionStatement
        {
        pushFollow(FOLLOW_expressionStatement_in_synpred30_EolParserRules886);
        expressionStatement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred30_EolParserRules

    // $ANTLR start synpred43_EolParserRules
    public final void synpred43_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:250:61: ( elseStatement )
        // EolParserRules.g:250:61: elseStatement
        {
        pushFollow(FOLLOW_elseStatement_in_synpred43_EolParserRules1036);
        elseStatement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred43_EolParserRules

    // $ANTLR start synpred48_EolParserRules
    public final void synpred48_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:300:19: ( NAME ( ',' NAME )* )
        // EolParserRules.g:300:19: NAME ( ',' NAME )*
        {
        match(input,NAME,FOLLOW_NAME_in_synpred48_EolParserRules1273); if (state.failed) return ;
        // EolParserRules.g:300:24: ( ',' NAME )*
        loop57:
        do {
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==69) ) {
                alt57=1;
            }


            switch (alt57) {
        	case 1 :
        	    // EolParserRules.g:300:25: ',' NAME
        	    {
        	    match(input,69,FOLLOW_69_in_synpred48_EolParserRules1276); if (state.failed) return ;
        	    match(input,NAME,FOLLOW_NAME_in_synpred48_EolParserRules1278); if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop57;
            }
        } while (true);


        }
    }
    // $ANTLR end synpred48_EolParserRules

    // $ANTLR start synpred62_EolParserRules
    public final void synpred62_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:323:24: ( ( '==' ( relationalExpression )? | '=' ( relationalExpression )? | ( '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression ) )
        // EolParserRules.g:323:24: ( '==' ( relationalExpression )? | '=' ( relationalExpression )? | ( '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression )
        {
        // EolParserRules.g:323:24: ( '==' ( relationalExpression )? | '=' ( relationalExpression )? | ( '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression )
        int alt62=3;
        switch ( input.LA(1) ) {
        case 109:
            {
            alt62=1;
            }
            break;
        case 74:
            {
            alt62=2;
            }
            break;
        case 110:
        case 111:
        case 112:
        case 113:
        case 114:
            {
            alt62=3;
            }
            break;
        default:
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 62, 0, input);

            throw nvae;
        }

        switch (alt62) {
            case 1 :
                // EolParserRules.g:323:25: '==' ( relationalExpression )?
                {
                match(input,109,FOLLOW_109_in_synpred62_EolParserRules1397); if (state.failed) return ;
                // EolParserRules.g:323:31: ( relationalExpression )?
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==FLOAT||LA60_0==INT||LA60_0==BOOLEAN||LA60_0==STRING||LA60_0==NAME||LA60_0==77||(LA60_0>=84 && LA60_0<=89)||LA60_0==116||LA60_0==119||(LA60_0>=121 && LA60_0<=122)) ) {
                    alt60=1;
                }
                switch (alt60) {
                    case 1 :
                        // EolParserRules.g:0:0: relationalExpression
                        {
                        pushFollow(FOLLOW_relationalExpression_in_synpred62_EolParserRules1400);
                        relationalExpression();

                        state._fsp--;
                        if (state.failed) return ;

                        }
                        break;

                }


                }
                break;
            case 2 :
                // EolParserRules.g:323:55: '=' ( relationalExpression )?
                {
                match(input,74,FOLLOW_74_in_synpred62_EolParserRules1405); if (state.failed) return ;
                // EolParserRules.g:323:60: ( relationalExpression )?
                int alt61=2;
                int LA61_0 = input.LA(1);

                if ( (LA61_0==FLOAT||LA61_0==INT||LA61_0==BOOLEAN||LA61_0==STRING||LA61_0==NAME||LA61_0==77||(LA61_0>=84 && LA61_0<=89)||LA61_0==116||LA61_0==119||(LA61_0>=121 && LA61_0<=122)) ) {
                    alt61=1;
                }
                switch (alt61) {
                    case 1 :
                        // EolParserRules.g:0:0: relationalExpression
                        {
                        pushFollow(FOLLOW_relationalExpression_in_synpred62_EolParserRules1408);
                        relationalExpression();

                        state._fsp--;
                        if (state.failed) return ;

                        }
                        break;

                }


                }
                break;
            case 3 :
                // EolParserRules.g:324:24: ( '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression
                {
                if ( (input.LA(1)>=110 && input.LA(1)<=114) ) {
                    input.consume();
                    state.errorRecovery=false;state.failed=false;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    MismatchedSetException mse = new MismatchedSetException(null,input);
                    throw mse;
                }

                pushFollow(FOLLOW_additiveExpression_in_synpred62_EolParserRules1449);
                additiveExpression();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        }
    }
    // $ANTLR end synpred62_EolParserRules

    // $ANTLR start synpred86_EolParserRules
    public final void synpred86_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:408:4: ( expressionRange )
        // EolParserRules.g:408:4: expressionRange
        {
        pushFollow(FOLLOW_expressionRange_in_synpred86_EolParserRules1871);
        expressionRange();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred86_EolParserRules

    // $ANTLR start synpred89_EolParserRules
    public final void synpred89_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:417:35: ( featureCall )
        // EolParserRules.g:417:35: featureCall
        {
        pushFollow(FOLLOW_featureCall_in_synpred89_EolParserRules1905);
        featureCall();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred89_EolParserRules

    // $ANTLR start synpred90_EolParserRules
    public final void synpred90_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:417:49: ( pathName )
        // EolParserRules.g:417:49: pathName
        {
        pushFollow(FOLLOW_pathName_in_synpred90_EolParserRules1909);
        pathName();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred90_EolParserRules

    // Delegated rules

    public final boolean synpred90_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred90_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred48_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred48_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred43_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred43_EolParserRules_fragment(); // can never throw exception
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
    public final boolean synpred89_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred89_EolParserRules_fragment(); // can never throw exception
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
    public final boolean synpred28_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred28_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred27_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred27_EolParserRules_fragment(); // can never throw exception
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
    public final boolean synpred62_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred62_EolParserRules_fragment(); // can never throw exception
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
    protected DFA33 dfa33 = new DFA33(this);
    protected DFA44 dfa44 = new DFA44(this);
    protected DFA55 dfa55 = new DFA55(this);
    protected DFA56 dfa56 = new DFA56(this);
    static final String DFA22_eotS =
        "\54\uffff";
    static final String DFA22_eofS =
        "\1\2\53\uffff";
    static final String DFA22_minS =
        "\1\4\1\0\52\uffff";
    static final String DFA22_maxS =
        "\1\172\1\0\52\uffff";
    static final String DFA22_acceptS =
        "\2\uffff\1\2\50\uffff\1\1";
    static final String DFA22_specialS =
        "\1\uffff\1\0\52\uffff}>";
    static final String[] DFA22_transitionS = {
            "\1\2\1\uffff\5\2\1\uffff\1\2\3\uffff\1\2\3\uffff\1\2\56\uffff"+
            "\1\2\1\uffff\1\2\2\uffff\5\2\1\1\1\2\1\uffff\1\2\3\uffff\11"+
            "\2\1\uffff\35\2",
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
            return "216:3: ( '(' tn= typeName ')' )?";
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
                        if ( (synpred27_EolParserRules()) ) {s = 43;}

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
        "\24\uffff";
    static final String DFA23_eofS =
        "\24\uffff";
    static final String DFA23_minS =
        "\1\4\13\uffff\1\0\7\uffff";
    static final String DFA23_maxS =
        "\1\172\13\uffff\1\0\7\uffff";
    static final String DFA23_acceptS =
        "\1\uffff\1\1\14\uffff\1\2\5\uffff";
    static final String DFA23_specialS =
        "\14\uffff\1\0\7\uffff}>";
    static final String[] DFA23_transitionS = {
            "\1\1\1\uffff\1\1\3\uffff\1\1\1\uffff\1\1\3\uffff\1\1\74\uffff"+
            "\1\1\6\uffff\7\1\1\uffff\1\1\1\uffff\1\1\1\14\2\16\1\1\4\16"+
            "\15\uffff\1\1\2\uffff\1\1\1\uffff\2\1",
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
            return "222:1: statement : ( statementA | statementB );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA23_12 = input.LA(1);

                         
                        int index23_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred28_EolParserRules()) ) {s = 1;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index23_12);
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
        "\20\uffff";
    static final String DFA24_eofS =
        "\20\uffff";
    static final String DFA24_minS =
        "\1\4\10\0\7\uffff";
    static final String DFA24_maxS =
        "\1\172\10\0\7\uffff";
    static final String DFA24_acceptS =
        "\11\uffff\1\3\1\4\1\5\1\6\1\7\1\1\1\2";
    static final String DFA24_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\7\uffff}>";
    static final String[] DFA24_transitionS = {
            "\1\3\1\uffff\1\3\3\uffff\1\3\1\uffff\1\3\3\uffff\1\4\74\uffff"+
            "\1\6\6\uffff\1\5\5\2\1\11\1\uffff\1\12\1\uffff\1\13\1\14\2\uffff"+
            "\1\15\21\uffff\1\1\2\uffff\1\1\1\uffff\1\7\1\10",
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
            return "226:1: statementA : ( assignmentStatement | expressionStatement | forStatement | ifStatement | whileStatement | returnStatement | breakStatement );";
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
                        if ( (synpred29_EolParserRules()) ) {s = 14;}

                        else if ( (synpred30_EolParserRules()) ) {s = 15;}

                         
                        input.seek(index24_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA24_2 = input.LA(1);

                         
                        int index24_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_EolParserRules()) ) {s = 14;}

                        else if ( (synpred30_EolParserRules()) ) {s = 15;}

                         
                        input.seek(index24_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA24_3 = input.LA(1);

                         
                        int index24_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_EolParserRules()) ) {s = 14;}

                        else if ( (synpred30_EolParserRules()) ) {s = 15;}

                         
                        input.seek(index24_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA24_4 = input.LA(1);

                         
                        int index24_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_EolParserRules()) ) {s = 14;}

                        else if ( (synpred30_EolParserRules()) ) {s = 15;}

                         
                        input.seek(index24_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA24_5 = input.LA(1);

                         
                        int index24_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_EolParserRules()) ) {s = 14;}

                        else if ( (synpred30_EolParserRules()) ) {s = 15;}

                         
                        input.seek(index24_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA24_6 = input.LA(1);

                         
                        int index24_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_EolParserRules()) ) {s = 14;}

                        else if ( (synpred30_EolParserRules()) ) {s = 15;}

                         
                        input.seek(index24_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA24_7 = input.LA(1);

                         
                        int index24_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_EolParserRules()) ) {s = 14;}

                        else if ( (synpred30_EolParserRules()) ) {s = 15;}

                         
                        input.seek(index24_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA24_8 = input.LA(1);

                         
                        int index24_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_EolParserRules()) ) {s = 14;}

                        else if ( (synpred30_EolParserRules()) ) {s = 15;}

                         
                        input.seek(index24_8);
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
    static final String DFA33_eotS =
        "\26\uffff";
    static final String DFA33_eofS =
        "\26\uffff";
    static final String DFA33_minS =
        "\1\4\1\0\24\uffff";
    static final String DFA33_maxS =
        "\1\172\1\0\24\uffff";
    static final String DFA33_acceptS =
        "\2\uffff\1\2\22\uffff\1\1";
    static final String DFA33_specialS =
        "\1\uffff\1\0\24\uffff}>";
    static final String[] DFA33_transitionS = {
            "\1\2\1\uffff\1\2\3\uffff\1\2\1\uffff\1\2\3\uffff\1\1\67\uffff"+
            "\1\2\4\uffff\1\2\6\uffff\7\2\1\uffff\1\2\1\uffff\11\2\15\uffff"+
            "\1\2\2\uffff\1\2\1\uffff\2\2",
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
            ""
    };

    static final short[] DFA33_eot = DFA.unpackEncodedString(DFA33_eotS);
    static final short[] DFA33_eof = DFA.unpackEncodedString(DFA33_eofS);
    static final char[] DFA33_min = DFA.unpackEncodedStringToUnsignedChars(DFA33_minS);
    static final char[] DFA33_max = DFA.unpackEncodedStringToUnsignedChars(DFA33_maxS);
    static final short[] DFA33_accept = DFA.unpackEncodedString(DFA33_acceptS);
    static final short[] DFA33_special = DFA.unpackEncodedString(DFA33_specialS);
    static final short[][] DFA33_transition;

    static {
        int numStates = DFA33_transitionS.length;
        DFA33_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA33_transition[i] = DFA.unpackEncodedString(DFA33_transitionS[i]);
        }
    }

    class DFA33 extends DFA {

        public DFA33(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 33;
            this.eot = DFA33_eot;
            this.eof = DFA33_eof;
            this.min = DFA33_min;
            this.max = DFA33_max;
            this.accept = DFA33_accept;
            this.special = DFA33_special;
            this.transition = DFA33_transition;
        }
        public String getDescription() {
            return "300:18: ( NAME ( ',' NAME )* )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA33_1 = input.LA(1);

                         
                        int index33_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred48_EolParserRules()) ) {s = 21;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index33_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 33, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA44_eotS =
        "\10\uffff";
    static final String DFA44_eofS =
        "\1\uffff\1\3\6\uffff";
    static final String DFA44_minS =
        "\1\20\2\4\1\uffff\1\7\1\4\1\uffff\1\7";
    static final String DFA44_maxS =
        "\1\20\2\172\1\uffff\1\170\1\172\1\uffff\1\170";
    static final String DFA44_acceptS =
        "\3\uffff\1\1\2\uffff\1\2\1\uffff";
    static final String DFA44_specialS =
        "\10\uffff}>";
    static final String[] DFA44_transitionS = {
            "\1\1",
            "\1\3\1\uffff\5\3\1\uffff\1\3\3\uffff\1\3\3\uffff\1\3\56\uffff"+
            "\1\3\1\uffff\1\3\3\uffff\4\3\1\2\1\3\1\uffff\1\3\3\uffff\7\3"+
            "\1\uffff\1\3\1\uffff\32\3\1\uffff\2\3",
            "\1\3\1\uffff\1\3\3\uffff\1\3\1\uffff\1\3\3\uffff\1\4\74\uffff"+
            "\2\3\5\uffff\6\3\32\uffff\1\3\2\uffff\1\3\1\uffff\2\3",
            "",
            "\1\3\1\uffff\1\3\72\uffff\1\6\1\5\4\uffff\1\3\2\uffff\2\3\2"+
            "\uffff\3\3\25\uffff\16\3\1\uffff\1\6",
            "\1\3\1\uffff\1\3\3\uffff\1\3\1\uffff\1\3\3\uffff\1\7\74\uffff"+
            "\1\3\6\uffff\6\3\32\uffff\1\3\2\uffff\1\3\1\uffff\2\3",
            "",
            "\1\3\1\uffff\1\3\72\uffff\1\6\1\5\4\uffff\1\3\2\uffff\2\3\2"+
            "\uffff\3\3\25\uffff\16\3\1\uffff\1\6"
    };

    static final short[] DFA44_eot = DFA.unpackEncodedString(DFA44_eotS);
    static final short[] DFA44_eof = DFA.unpackEncodedString(DFA44_eofS);
    static final char[] DFA44_min = DFA.unpackEncodedStringToUnsignedChars(DFA44_minS);
    static final char[] DFA44_max = DFA.unpackEncodedStringToUnsignedChars(DFA44_maxS);
    static final short[] DFA44_accept = DFA.unpackEncodedString(DFA44_acceptS);
    static final short[] DFA44_special = DFA.unpackEncodedString(DFA44_specialS);
    static final short[][] DFA44_transition;

    static {
        int numStates = DFA44_transitionS.length;
        DFA44_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA44_transition[i] = DFA.unpackEncodedString(DFA44_transitionS[i]);
        }
    }

    class DFA44 extends DFA {

        public DFA44(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 44;
            this.eot = DFA44_eot;
            this.eof = DFA44_eof;
            this.min = DFA44_min;
            this.max = DFA44_max;
            this.accept = DFA44_accept;
            this.special = DFA44_special;
            this.transition = DFA44_transition;
        }
        public String getDescription() {
            return "355:1: featureCall : ( simpleFeatureCall | declarativeFeatureCall );";
        }
    }
    static final String DFA55_eotS =
        "\13\uffff";
    static final String DFA55_eofS =
        "\13\uffff";
    static final String DFA55_minS =
        "\1\4\10\0\2\uffff";
    static final String DFA55_maxS =
        "\1\172\10\0\2\uffff";
    static final String DFA55_acceptS =
        "\11\uffff\1\1\1\2";
    static final String DFA55_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\2\uffff}>";
    static final String[] DFA55_transitionS = {
            "\1\3\1\uffff\1\3\3\uffff\1\3\1\uffff\1\3\3\uffff\1\4\74\uffff"+
            "\1\6\6\uffff\1\5\5\2\32\uffff\1\1\2\uffff\1\1\1\uffff\1\7\1"+
            "\10",
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
            return "407:1: expressionListOrRange : ( expressionRange | expressionList );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA55_1 = input.LA(1);

                         
                        int index55_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_EolParserRules()) ) {s = 9;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index55_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA55_2 = input.LA(1);

                         
                        int index55_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_EolParserRules()) ) {s = 9;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index55_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA55_3 = input.LA(1);

                         
                        int index55_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_EolParserRules()) ) {s = 9;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index55_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA55_4 = input.LA(1);

                         
                        int index55_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_EolParserRules()) ) {s = 9;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index55_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA55_5 = input.LA(1);

                         
                        int index55_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_EolParserRules()) ) {s = 9;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index55_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA55_6 = input.LA(1);

                         
                        int index55_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_EolParserRules()) ) {s = 9;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index55_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA55_7 = input.LA(1);

                         
                        int index55_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_EolParserRules()) ) {s = 9;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index55_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA55_8 = input.LA(1);

                         
                        int index55_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_EolParserRules()) ) {s = 9;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index55_8);
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
    static final String DFA56_eotS =
        "\14\uffff";
    static final String DFA56_eofS =
        "\1\uffff\1\11\12\uffff";
    static final String DFA56_minS =
        "\2\4\1\uffff\1\0\10\uffff";
    static final String DFA56_maxS =
        "\2\172\1\uffff\1\0\10\uffff";
    static final String DFA56_acceptS =
        "\2\uffff\1\2\1\uffff\1\5\1\7\1\10\1\11\1\1\1\6\1\3\1\4";
    static final String DFA56_specialS =
        "\3\uffff\1\0\10\uffff}>";
    static final String[] DFA56_transitionS = {
            "\1\2\1\uffff\1\2\3\uffff\1\2\1\uffff\1\2\3\uffff\1\3\74\uffff"+
            "\1\5\6\uffff\1\4\5\1\37\uffff\1\6\1\7",
            "\1\11\1\uffff\5\11\1\uffff\1\11\3\uffff\1\11\3\uffff\1\11\56"+
            "\uffff\1\11\1\uffff\1\11\2\uffff\1\10\6\11\1\uffff\1\11\3\uffff"+
            "\7\11\1\uffff\1\11\1\uffff\32\11\1\uffff\2\11",
            "",
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
            return "416:1: primitiveExpression : ( litteralCollection | literal | featureCall | pathName | nativeType | collectionType | '(' logicalExpression ')' | newExpression | variableDeclarationExpression );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA56_3 = input.LA(1);

                         
                        int index56_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred89_EolParserRules()) ) {s = 10;}

                        else if ( (synpred90_EolParserRules()) ) {s = 11;}

                         
                        input.seek(index56_3);
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
 

    public static final BitSet FOLLOW_operationDeclaration_in_operationDeclarationOrAnnotationBlock218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationBlock_in_operationDeclarationOrAnnotationBlock220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_modelDeclaration231 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NAME_in_modelDeclaration233 = new BitSet(new long[]{0x0000000000000000L,0x00000000000001C8L});
    public static final BitSet FOLLOW_modelAlias_in_modelDeclaration235 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000188L});
    public static final BitSet FOLLOW_modelDriver_in_modelDeclaration238 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000108L});
    public static final BitSet FOLLOW_modelDeclarationParameters_in_modelDeclaration241 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_modelDeclaration244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_modelNamespace282 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NAME_in_modelNamespace284 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_modelNamespace287 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NAME_in_modelNamespace289 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000020L});
    public static final BitSet FOLLOW_70_in_modelAlias313 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NAME_in_modelAlias315 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_modelAlias318 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NAME_in_modelAlias320 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000020L});
    public static final BitSet FOLLOW_71_in_modelDriver344 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NAME_in_modelDriver346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_modelDeclarationParameters366 = new BitSet(new long[]{0x0000000000010000L,0x0000000000000220L});
    public static final BitSet FOLLOW_modelDeclarationParameter_in_modelDeclarationParameters368 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000220L});
    public static final BitSet FOLLOW_69_in_modelDeclarationParameters372 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_modelDeclarationParameter_in_modelDeclarationParameters374 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000220L});
    public static final BitSet FOLLOW_73_in_modelDeclarationParameters378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_modelDeclarationParameter402 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_74_in_modelDeclarationParameter404 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_STRING_in_modelDeclarationParameter406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_operationDeclaration432 = new BitSet(new long[]{0x0000000000010000L,0x0000000003F00000L});
    public static final BitSet FOLLOW_76_in_operationDeclaration434 = new BitSet(new long[]{0x0000000000010000L,0x0000000003F00000L});
    public static final BitSet FOLLOW_typeName_in_operationDeclaration440 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NAME_in_operationDeclaration448 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_operationDeclaration450 = new BitSet(new long[]{0x0000000000010000L,0x0000000000004000L});
    public static final BitSet FOLLOW_formalParameterList_in_operationDeclaration452 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_operationDeclaration455 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000110L});
    public static final BitSet FOLLOW_68_in_operationDeclaration458 = new BitSet(new long[]{0x0000000000010000L,0x0000000003F00000L});
    public static final BitSet FOLLOW_typeName_in_operationDeclaration462 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000110L});
    public static final BitSet FOLLOW_statementBlock_in_operationDeclaration468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_importStatement505 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_STRING_in_importStatement508 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_importStatement510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_block525 = new BitSet(new long[]{0x0000000000011452L,0x0690007FD7F02000L});
    public static final BitSet FOLLOW_72_in_statementBlock547 = new BitSet(new long[]{0x0000000000011450L,0x0690007FD7F02000L});
    public static final BitSet FOLLOW_block_in_statementBlock550 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_73_in_statementBlock552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_formalParameter564 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_formalParameter567 = new BitSet(new long[]{0x0000000000010000L,0x0000000003F00000L});
    public static final BitSet FOLLOW_typeName_in_formalParameter571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_formalParameter_in_formalParameterList600 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_formalParameterList603 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_formalParameter_in_formalParameterList605 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000020L});
    public static final BitSet FOLLOW_80_in_executableAnnotation628 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NAME_in_executableAnnotation630 = new BitSet(new long[]{0x0000000000011450L,0x0690000003F02000L});
    public static final BitSet FOLLOW_logicalExpression_in_executableAnnotation632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Annotation_in_annotation654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_executableAnnotation_in_annotation656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotation_in_annotationBlock667 = new BitSet(new long[]{0x0000000000100002L,0x0000000000010000L});
    public static final BitSet FOLLOW_pathName_in_typeName690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nativeType_in_typeName694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectionType_in_typeName698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_pathName715 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_81_in_pathName718 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NAME_in_pathName725 = new BitSet(new long[]{0x0000000000000002L,0x00000000000C0000L});
    public static final BitSet FOLLOW_82_in_pathName730 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NAME_in_pathName735 = new BitSet(new long[]{0x0000000000000002L,0x00000000000C0000L});
    public static final BitSet FOLLOW_83_in_pathName745 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NAME_in_pathName750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_nativeType770 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_nativeType773 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_STRING_in_nativeType776 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_nativeType778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_modelElementType795 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_81_in_modelElementType797 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NAME_in_modelElementType799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_collectionType821 = new BitSet(new long[]{0x0000000000000002L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_collectionType837 = new BitSet(new long[]{0x0000000000010000L,0x0000000003F00000L});
    public static final BitSet FOLLOW_typeName_in_collectionType842 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_collectionType845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementA_in_statement868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementB_in_statement872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignmentStatement_in_statementA882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionStatement_in_statementA886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_forStatement_in_statementA890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStatement_in_statementA896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_whileStatement_in_statementA900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_returnStatement_in_statementA904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_breakStatement_in_statementA908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_breakAllStatement_in_statementB920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_returnStatement_in_statementB924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_transactionStatement_in_statementB928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_abortStatement_in_statementB934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_continueStatement_in_statementB938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_throwStatement_in_statementB942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_deleteStatement_in_statementB948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_statementOrStatementBlock959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementBlock_in_statementOrStatementBlock963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_expressionOrStatementBlock972 = new BitSet(new long[]{0x0000000000011450L,0x0690000003F02000L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionOrStatementBlock975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementBlock_in_expressionOrStatementBlock979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_90_in_forStatement990 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_forStatement992 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_formalParameter_in_forStatement994 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_91_in_forStatement996 = new BitSet(new long[]{0x0000000000011450L,0x0690000003F02000L});
    public static final BitSet FOLLOW_logicalExpression_in_forStatement998 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_forStatement1000 = new BitSet(new long[]{0x0000000000011450L,0x0690007FD7F02110L});
    public static final BitSet FOLLOW_statementOrStatementBlock_in_forStatement1002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_92_in_ifStatement1026 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_ifStatement1028 = new BitSet(new long[]{0x0000000000011450L,0x0690000003F02000L});
    public static final BitSet FOLLOW_logicalExpression_in_ifStatement1030 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_ifStatement1032 = new BitSet(new long[]{0x0000000000011450L,0x0690007FD7F02110L});
    public static final BitSet FOLLOW_statementOrStatementBlock_in_ifStatement1034 = new BitSet(new long[]{0x0000000000000002L,0x0000000020000000L});
    public static final BitSet FOLLOW_elseStatement_in_ifStatement1036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_93_in_elseStatement1063 = new BitSet(new long[]{0x0000000000011450L,0x0690007FD7F02110L});
    public static final BitSet FOLLOW_statementOrStatementBlock_in_elseStatement1066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_whileStatement1079 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_whileStatement1081 = new BitSet(new long[]{0x0000000000011450L,0x0690000003F02000L});
    public static final BitSet FOLLOW_logicalExpression_in_whileStatement1083 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_whileStatement1085 = new BitSet(new long[]{0x0000000000011450L,0x0690007FD7F02110L});
    public static final BitSet FOLLOW_statementOrStatementBlock_in_whileStatement1087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_95_in_returnStatement1109 = new BitSet(new long[]{0x0000000000011450L,0x0690000003F02008L});
    public static final BitSet FOLLOW_logicalExpression_in_returnStatement1111 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_returnStatement1114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_96_in_throwStatement1135 = new BitSet(new long[]{0x0000000000011450L,0x0690000003F02008L});
    public static final BitSet FOLLOW_logicalExpression_in_throwStatement1137 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_throwStatement1140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_97_in_deleteStatement1161 = new BitSet(new long[]{0x0000000000011450L,0x0690000003F02008L});
    public static final BitSet FOLLOW_logicalExpression_in_deleteStatement1163 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_deleteStatement1166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_98_in_breakStatement1190 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_breakStatement1192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_99_in_breakAllStatement1210 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_breakAllStatement1212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_100_in_continueStatement1230 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_continueStatement1232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_101_in_abortStatement1250 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_abortStatement1252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_102_in_transactionStatement1270 = new BitSet(new long[]{0x0000000000011450L,0x0690007FD7F02110L});
    public static final BitSet FOLLOW_NAME_in_transactionStatement1273 = new BitSet(new long[]{0x0000000000011450L,0x0690007FD7F02130L});
    public static final BitSet FOLLOW_69_in_transactionStatement1276 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NAME_in_transactionStatement1278 = new BitSet(new long[]{0x0000000000011450L,0x0690007FD7F02130L});
    public static final BitSet FOLLOW_statementOrStatementBlock_in_transactionStatement1284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logicalExpression_in_assignmentStatement1313 = new BitSet(new long[]{0x0000000000000000L,0x0000018000000000L});
    public static final BitSet FOLLOW_103_in_assignmentStatement1318 = new BitSet(new long[]{0x0000000000011450L,0x0690000003F02000L});
    public static final BitSet FOLLOW_104_in_assignmentStatement1325 = new BitSet(new long[]{0x0000000000011450L,0x0690000003F02000L});
    public static final BitSet FOLLOW_logicalExpression_in_assignmentStatement1331 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_assignmentStatement1333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionStatement1348 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_expressionStatement1350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_relationalExpression_in_logicalExpression1362 = new BitSet(new long[]{0x0000000000000002L,0x00001E0000000000L});
    public static final BitSet FOLLOW_set_in_logicalExpression1365 = new BitSet(new long[]{0x0000000000011450L,0x0690000003F02000L});
    public static final BitSet FOLLOW_relationalExpression_in_logicalExpression1376 = new BitSet(new long[]{0x0000000000000002L,0x00001E0000000000L});
    public static final BitSet FOLLOW_additiveExpression_in_relationalExpression1393 = new BitSet(new long[]{0x0000000000000002L,0x0007E00000000400L});
    public static final BitSet FOLLOW_109_in_relationalExpression1397 = new BitSet(new long[]{0x0000000000011452L,0x0697E00003F02400L});
    public static final BitSet FOLLOW_relationalExpression_in_relationalExpression1400 = new BitSet(new long[]{0x0000000000000002L,0x0007E00000000400L});
    public static final BitSet FOLLOW_74_in_relationalExpression1405 = new BitSet(new long[]{0x0000000000011452L,0x0697E00003F02400L});
    public static final BitSet FOLLOW_relationalExpression_in_relationalExpression1408 = new BitSet(new long[]{0x0000000000000002L,0x0007E00000000400L});
    public static final BitSet FOLLOW_set_in_relationalExpression1436 = new BitSet(new long[]{0x0000000000011450L,0x0690000003F02000L});
    public static final BitSet FOLLOW_additiveExpression_in_relationalExpression1449 = new BitSet(new long[]{0x0000000000000002L,0x0007E00000000400L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_additiveExpression1467 = new BitSet(new long[]{0x0000000000000002L,0x0018000000000000L});
    public static final BitSet FOLLOW_set_in_additiveExpression1470 = new BitSet(new long[]{0x0000000000011450L,0x0690000003F02000L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_additiveExpression1477 = new BitSet(new long[]{0x0000000000000002L,0x0018000000000000L});
    public static final BitSet FOLLOW_unaryExpression_in_multiplicativeExpression1498 = new BitSet(new long[]{0x0000000000000002L,0x0060000000000000L});
    public static final BitSet FOLLOW_set_in_multiplicativeExpression1501 = new BitSet(new long[]{0x0000000000011450L,0x0690000003F02000L});
    public static final BitSet FOLLOW_unaryExpression_in_multiplicativeExpression1508 = new BitSet(new long[]{0x0000000000000002L,0x0060000000000000L});
    public static final BitSet FOLLOW_set_in_unaryExpression1526 = new BitSet(new long[]{0x0000000000011450L,0x0690000003F02000L});
    public static final BitSet FOLLOW_postfixExpression_in_unaryExpression1535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primitiveExpression_in_postfixExpression1550 = new BitSet(new long[]{0x0000000000000282L});
    public static final BitSet FOLLOW_set_in_postfixExpression1552 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_featureCall_in_postfixExpression1561 = new BitSet(new long[]{0x0000000000000282L});
    public static final BitSet FOLLOW_simpleFeatureCall_in_featureCall1596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declarativeFeatureCall_in_featureCall1600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_simpleFeatureCall1612 = new BitSet(new long[]{0x0000000000000002L,0x0000000000002000L});
    public static final BitSet FOLLOW_parameterList_in_simpleFeatureCall1615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_parameterList1630 = new BitSet(new long[]{0x0000000000011450L,0x0690000003F06000L});
    public static final BitSet FOLLOW_logicalExpression_in_parameterList1633 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004020L});
    public static final BitSet FOLLOW_69_in_parameterList1636 = new BitSet(new long[]{0x0000000000011450L,0x0690000003F02000L});
    public static final BitSet FOLLOW_logicalExpression_in_parameterList1638 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004020L});
    public static final BitSet FOLLOW_78_in_parameterList1644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_declarativeFeatureCall1666 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_declarativeFeatureCall1669 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_formalParameterList_in_declarativeFeatureCall1672 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
    public static final BitSet FOLLOW_120_in_declarativeFeatureCall1674 = new BitSet(new long[]{0x0000000000011450L,0x0690000003F02000L});
    public static final BitSet FOLLOW_logicalExpression_in_declarativeFeatureCall1677 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004020L});
    public static final BitSet FOLLOW_69_in_declarativeFeatureCall1680 = new BitSet(new long[]{0x0000000000011450L,0x0690000003F02000L});
    public static final BitSet FOLLOW_logicalExpression_in_declarativeFeatureCall1683 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004020L});
    public static final BitSet FOLLOW_78_in_declarativeFeatureCall1687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_121_in_newExpression1699 = new BitSet(new long[]{0x0000000000010000L,0x0000000003F00000L});
    public static final BitSet FOLLOW_typeName_in_newExpression1704 = new BitSet(new long[]{0x0000000000000002L,0x0000000000002000L});
    public static final BitSet FOLLOW_parameterList_in_newExpression1708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_122_in_variableDeclarationExpression1733 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NAME_in_variableDeclarationExpression1735 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_variableDeclarationExpression1738 = new BitSet(new long[]{0x0000000000010000L,0x0200000003F00000L});
    public static final BitSet FOLLOW_121_in_variableDeclarationExpression1742 = new BitSet(new long[]{0x0000000000010000L,0x0200000003F00000L});
    public static final BitSet FOLLOW_typeName_in_variableDeclarationExpression1747 = new BitSet(new long[]{0x0000000000000002L,0x0000000000002000L});
    public static final BitSet FOLLOW_parameterList_in_variableDeclarationExpression1751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_litteralCollection1781 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_litteralCollection1794 = new BitSet(new long[]{0x0000000000011450L,0x0690000003F02200L});
    public static final BitSet FOLLOW_expressionListOrRange_in_litteralCollection1798 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_73_in_litteralCollection1801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionRange1816 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_POINT_POINT_in_expressionRange1818 = new BitSet(new long[]{0x0000000000011450L,0x0690000003F02000L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionRange1820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionList1842 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_expressionList1845 = new BitSet(new long[]{0x0000000000011450L,0x0690000003F02000L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionList1847 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000020L});
    public static final BitSet FOLLOW_expressionRange_in_expressionListOrRange1871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionList_in_expressionListOrRange1875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_litteralCollection_in_primitiveExpression1897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_primitiveExpression1901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_featureCall_in_primitiveExpression1905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pathName_in_primitiveExpression1909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nativeType_in_primitiveExpression1913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectionType_in_primitiveExpression1919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_primitiveExpression1924 = new BitSet(new long[]{0x0000000000011450L,0x0690000003F02000L});
    public static final BitSet FOLLOW_logicalExpression_in_primitiveExpression1927 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_primitiveExpression1929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_newExpression_in_primitiveExpression1937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variableDeclarationExpression_in_primitiveExpression1941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_literal0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_synpred27_EolParserRules837 = new BitSet(new long[]{0x0000000000010000L,0x0200000003F00000L});
    public static final BitSet FOLLOW_typeName_in_synpred27_EolParserRules842 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_synpred27_EolParserRules845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementA_in_synpred28_EolParserRules868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignmentStatement_in_synpred29_EolParserRules882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionStatement_in_synpred30_EolParserRules886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_elseStatement_in_synpred43_EolParserRules1036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_synpred48_EolParserRules1273 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_synpred48_EolParserRules1276 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NAME_in_synpred48_EolParserRules1278 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000020L});
    public static final BitSet FOLLOW_109_in_synpred62_EolParserRules1397 = new BitSet(new long[]{0x0000000000011452L,0x0690000003F02000L});
    public static final BitSet FOLLOW_relationalExpression_in_synpred62_EolParserRules1400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_synpred62_EolParserRules1405 = new BitSet(new long[]{0x0000000000011452L,0x0690000003F02000L});
    public static final BitSet FOLLOW_relationalExpression_in_synpred62_EolParserRules1408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred62_EolParserRules1436 = new BitSet(new long[]{0x0000000000011450L,0x0690000003F02000L});
    public static final BitSet FOLLOW_additiveExpression_in_synpred62_EolParserRules1449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionRange_in_synpred86_EolParserRules1871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_featureCall_in_synpred89_EolParserRules1905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pathName_in_synpred90_EolParserRules1909 = new BitSet(new long[]{0x0000000000000002L});

}
