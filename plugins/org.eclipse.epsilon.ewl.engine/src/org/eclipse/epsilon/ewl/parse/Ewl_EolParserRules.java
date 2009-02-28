package org.eclipse.epsilon.ewl.parse;

// $ANTLR 3.1b1 EolParserRules.g 2009-02-28 12:44:09

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
public class Ewl_EolParserRules extends org.eclipse.epsilon.commons.parse.EpsilonParser {
    public static final int StatementBlock=26;
    public static final int WHILE=30;
    public static final int StrangeNameLiteral=13;
    public static final int NEW=43;
    public static final int DO=69;
    public static final int EWLMODULE=70;
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
    public static final int T__126=126;
    public static final int T__125=125;
    public static final int T__128=128;
    public static final int T__127=127;
    public static final int T__71=71;
    public static final int WS=17;
    public static final int T__72=72;
    public static final int T__129=129;
    public static final int ALIAS=62;
    public static final int JavaIDDigit=15;
    public static final int GUARD=66;
    public static final int Annotation=20;
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int T__130=130;
    public static final int T__73=73;
    public static final int T__131=131;
    public static final int EscapeSequence=11;
    public static final int Letter=14;
    public static final int THROW=47;
    public static final int WIZARD=67;
    public static final int T__79=79;
    public static final int T__78=78;
    public static final int T__77=77;
    public static final int SPECIAL_ASSIGNMENT=24;
    public static final int PARAMETERS=40;
    public static final int POINT=7;
    public static final int T__118=118;
    public static final int T__119=119;
    public static final int T__116=116;
    public static final int T__117=117;
    public static final int T__114=114;
    public static final int T__115=115;
    public static final int T__124=124;
    public static final int T__123=123;
    public static final int T__122=122;
    public static final int FOR=27;
    public static final int ENUMERATION_VALUE=58;
    public static final int T__121=121;
    public static final int PRE=63;
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
    public static final int POST=64;
    public static final int ARROW=9;
    public static final int ASSIGNMENT=23;
    public static final int EXTENDS=65;
    public static final int STRING=12;
    public static final int TITLE=68;

    // delegates
    // delegators
    public EwlParser gEwl;


        public Ewl_EolParserRules(TokenStream input, EwlParser gEwl) {
            this(input, new RecognizerSharedState(), gEwl);
        }
        public Ewl_EolParserRules(TokenStream input, RecognizerSharedState state, EwlParser gEwl) {
            super(input, state);
            this.gEwl = gEwl;
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return EwlParser.tokenNames; }
    public String getGrammarFileName() { return "EolParserRules.g"; }

    
    
    public void setTokenType(ParserRuleReturnScope tree, int type) {
    	((CommonTree) tree.getTree()).getToken().setType(type);
    }
    


    public static class operationDeclarationOrAnnotationBlock_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start operationDeclarationOrAnnotationBlock
    // EolParserRules.g:94:1: operationDeclarationOrAnnotationBlock : ( operationDeclaration | annotationBlock );
    public final Ewl_EolParserRules.operationDeclarationOrAnnotationBlock_return operationDeclarationOrAnnotationBlock() throws RecognitionException {
        Ewl_EolParserRules.operationDeclarationOrAnnotationBlock_return retval = new Ewl_EolParserRules.operationDeclarationOrAnnotationBlock_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Ewl_EolParserRules.operationDeclaration_return operationDeclaration1 = null;

        Ewl_EolParserRules.annotationBlock_return annotationBlock2 = null;



        try {
            // EolParserRules.g:95:2: ( operationDeclaration | annotationBlock )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==76) ) {
                alt1=1;
            }
            else if ( (LA1_0==Annotation||LA1_0==82) ) {
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
                    // EolParserRules.g:95:4: operationDeclaration
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_operationDeclaration_in_operationDeclarationOrAnnotationBlock206);
                    operationDeclaration1=operationDeclaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, operationDeclaration1.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:95:25: annotationBlock
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_annotationBlock_in_operationDeclarationOrAnnotationBlock208);
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
    // EolParserRules.g:98:1: modelDeclaration : 'model' NAME ( modelAlias )? ( modelNamespace )? ';' -> ^( MODELDECLARATION NAME ( modelAlias )? ( modelNamespace )? ) ;
    public final Ewl_EolParserRules.modelDeclaration_return modelDeclaration() throws RecognitionException {
        Ewl_EolParserRules.modelDeclaration_return retval = new Ewl_EolParserRules.modelDeclaration_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal3=null;
        Token NAME4=null;
        Token char_literal7=null;
        Ewl_EolParserRules.modelAlias_return modelAlias5 = null;

        Ewl_EolParserRules.modelNamespace_return modelNamespace6 = null;


        CommonTree string_literal3_tree=null;
        CommonTree NAME4_tree=null;
        CommonTree char_literal7_tree=null;
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_71=new RewriteRuleTokenStream(adaptor,"token 71");
        RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
        RewriteRuleSubtreeStream stream_modelNamespace=new RewriteRuleSubtreeStream(adaptor,"rule modelNamespace");
        RewriteRuleSubtreeStream stream_modelAlias=new RewriteRuleSubtreeStream(adaptor,"rule modelAlias");
        try {
            // EolParserRules.g:99:2: ( 'model' NAME ( modelAlias )? ( modelNamespace )? ';' -> ^( MODELDECLARATION NAME ( modelAlias )? ( modelNamespace )? ) )
            // EolParserRules.g:99:4: 'model' NAME ( modelAlias )? ( modelNamespace )? ';'
            {
            string_literal3=(Token)match(input,71,FOLLOW_71_in_modelDeclaration219); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_71.add(string_literal3);

            NAME4=(Token)match(input,NAME,FOLLOW_NAME_in_modelDeclaration221); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(NAME4);

            // EolParserRules.g:99:17: ( modelAlias )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==75) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // EolParserRules.g:0:0: modelAlias
                    {
                    pushFollow(FOLLOW_modelAlias_in_modelDeclaration223);
                    modelAlias5=modelAlias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_modelAlias.add(modelAlias5.getTree());

                    }
                    break;

            }

            // EolParserRules.g:99:29: ( modelNamespace )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==73) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // EolParserRules.g:0:0: modelNamespace
                    {
                    pushFollow(FOLLOW_modelNamespace_in_modelDeclaration226);
                    modelNamespace6=modelNamespace();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_modelNamespace.add(modelNamespace6.getTree());

                    }
                    break;

            }

            char_literal7=(Token)match(input,72,FOLLOW_72_in_modelDeclaration229); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_72.add(char_literal7);



            // AST REWRITE
            // elements: modelNamespace, NAME, modelAlias
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 100:2: -> ^( MODELDECLARATION NAME ( modelAlias )? ( modelNamespace )? )
            {
                // EolParserRules.g:100:5: ^( MODELDECLARATION NAME ( modelAlias )? ( modelNamespace )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(MODELDECLARATION, "MODELDECLARATION"), root_1);

                adaptor.addChild(root_1, stream_NAME.nextNode());
                // EolParserRules.g:100:29: ( modelAlias )?
                if ( stream_modelAlias.hasNext() ) {
                    adaptor.addChild(root_1, stream_modelAlias.nextTree());

                }
                stream_modelAlias.reset();
                // EolParserRules.g:100:43: ( modelNamespace )?
                if ( stream_modelNamespace.hasNext() ) {
                    adaptor.addChild(root_1, stream_modelNamespace.nextTree());

                }
                stream_modelNamespace.reset();

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
    // EolParserRules.g:103:1: modelNamespace : ':' NAME ( ',' NAME )* -> ^( NAMESPACE ( NAME )* ) ;
    public final Ewl_EolParserRules.modelNamespace_return modelNamespace() throws RecognitionException {
        Ewl_EolParserRules.modelNamespace_return retval = new Ewl_EolParserRules.modelNamespace_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal8=null;
        Token NAME9=null;
        Token char_literal10=null;
        Token NAME11=null;

        CommonTree char_literal8_tree=null;
        CommonTree NAME9_tree=null;
        CommonTree char_literal10_tree=null;
        CommonTree NAME11_tree=null;
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_73=new RewriteRuleTokenStream(adaptor,"token 73");
        RewriteRuleTokenStream stream_74=new RewriteRuleTokenStream(adaptor,"token 74");

        try {
            // EolParserRules.g:104:2: ( ':' NAME ( ',' NAME )* -> ^( NAMESPACE ( NAME )* ) )
            // EolParserRules.g:104:6: ':' NAME ( ',' NAME )*
            {
            char_literal8=(Token)match(input,73,FOLLOW_73_in_modelNamespace262); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_73.add(char_literal8);

            NAME9=(Token)match(input,NAME,FOLLOW_NAME_in_modelNamespace264); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(NAME9);

            // EolParserRules.g:104:15: ( ',' NAME )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==74) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // EolParserRules.g:104:16: ',' NAME
            	    {
            	    char_literal10=(Token)match(input,74,FOLLOW_74_in_modelNamespace267); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_74.add(char_literal10);

            	    NAME11=(Token)match(input,NAME,FOLLOW_NAME_in_modelNamespace269); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_NAME.add(NAME11);


            	    }
            	    break;

            	default :
            	    break loop4;
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
            // 105:2: -> ^( NAMESPACE ( NAME )* )
            {
                // EolParserRules.g:105:5: ^( NAMESPACE ( NAME )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NAMESPACE, "NAMESPACE"), root_1);

                // EolParserRules.g:105:17: ( NAME )*
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
    // EolParserRules.g:108:1: modelAlias : 'alias' NAME ( ',' NAME )* -> ^( ALIAS ( NAME )* ) ;
    public final Ewl_EolParserRules.modelAlias_return modelAlias() throws RecognitionException {
        Ewl_EolParserRules.modelAlias_return retval = new Ewl_EolParserRules.modelAlias_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal12=null;
        Token NAME13=null;
        Token char_literal14=null;
        Token NAME15=null;

        CommonTree string_literal12_tree=null;
        CommonTree NAME13_tree=null;
        CommonTree char_literal14_tree=null;
        CommonTree NAME15_tree=null;
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_74=new RewriteRuleTokenStream(adaptor,"token 74");
        RewriteRuleTokenStream stream_75=new RewriteRuleTokenStream(adaptor,"token 75");

        try {
            // EolParserRules.g:109:2: ( 'alias' NAME ( ',' NAME )* -> ^( ALIAS ( NAME )* ) )
            // EolParserRules.g:109:5: 'alias' NAME ( ',' NAME )*
            {
            string_literal12=(Token)match(input,75,FOLLOW_75_in_modelAlias293); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_75.add(string_literal12);

            NAME13=(Token)match(input,NAME,FOLLOW_NAME_in_modelAlias295); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(NAME13);

            // EolParserRules.g:109:18: ( ',' NAME )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==74) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // EolParserRules.g:109:19: ',' NAME
            	    {
            	    char_literal14=(Token)match(input,74,FOLLOW_74_in_modelAlias298); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_74.add(char_literal14);

            	    NAME15=(Token)match(input,NAME,FOLLOW_NAME_in_modelAlias300); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_NAME.add(NAME15);


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
            // 110:2: -> ^( ALIAS ( NAME )* )
            {
                // EolParserRules.g:110:5: ^( ALIAS ( NAME )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ALIAS, "ALIAS"), root_1);

                // EolParserRules.g:110:13: ( NAME )*
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

    public static class operationDeclaration_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start operationDeclaration
    // EolParserRules.g:113:1: operationDeclaration : 'operation' (ctx= typeName )? operationName= NAME '(' ( formalParameterList )? ')' ( ':' returnType= typeName )? statementBlock -> ^( HELPERMETHOD ( $ctx)? $operationName ( formalParameterList )? ( $returnType)? statementBlock ) ;
    public final Ewl_EolParserRules.operationDeclaration_return operationDeclaration() throws RecognitionException {
        Ewl_EolParserRules.operationDeclaration_return retval = new Ewl_EolParserRules.operationDeclaration_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token operationName=null;
        Token string_literal16=null;
        Token char_literal17=null;
        Token char_literal19=null;
        Token char_literal20=null;
        Ewl_EolParserRules.typeName_return ctx = null;

        Ewl_EolParserRules.typeName_return returnType = null;

        Ewl_EolParserRules.formalParameterList_return formalParameterList18 = null;

        Ewl_EolParserRules.statementBlock_return statementBlock21 = null;


        CommonTree operationName_tree=null;
        CommonTree string_literal16_tree=null;
        CommonTree char_literal17_tree=null;
        CommonTree char_literal19_tree=null;
        CommonTree char_literal20_tree=null;
        RewriteRuleTokenStream stream_78=new RewriteRuleTokenStream(adaptor,"token 78");
        RewriteRuleTokenStream stream_77=new RewriteRuleTokenStream(adaptor,"token 77");
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_73=new RewriteRuleTokenStream(adaptor,"token 73");
        RewriteRuleTokenStream stream_76=new RewriteRuleTokenStream(adaptor,"token 76");
        RewriteRuleSubtreeStream stream_typeName=new RewriteRuleSubtreeStream(adaptor,"rule typeName");
        RewriteRuleSubtreeStream stream_statementBlock=new RewriteRuleSubtreeStream(adaptor,"rule statementBlock");
        RewriteRuleSubtreeStream stream_formalParameterList=new RewriteRuleSubtreeStream(adaptor,"rule formalParameterList");
        try {
            // EolParserRules.g:115:2: ( 'operation' (ctx= typeName )? operationName= NAME '(' ( formalParameterList )? ')' ( ':' returnType= typeName )? statementBlock -> ^( HELPERMETHOD ( $ctx)? $operationName ( formalParameterList )? ( $returnType)? statementBlock ) )
            // EolParserRules.g:115:4: 'operation' (ctx= typeName )? operationName= NAME '(' ( formalParameterList )? ')' ( ':' returnType= typeName )? statementBlock
            {
            string_literal16=(Token)match(input,76,FOLLOW_76_in_operationDeclaration326); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_76.add(string_literal16);

            // EolParserRules.g:115:16: (ctx= typeName )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==NAME) ) {
                int LA6_1 = input.LA(2);

                if ( (LA6_1==NAME||(LA6_1>=83 && LA6_1<=85)) ) {
                    alt6=1;
                }
            }
            else if ( ((LA6_0>=86 && LA6_0<=91)) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // EolParserRules.g:115:17: ctx= typeName
                    {
                    pushFollow(FOLLOW_typeName_in_operationDeclaration331);
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

            operationName=(Token)match(input,NAME,FOLLOW_NAME_in_operationDeclaration339); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(operationName);

            char_literal17=(Token)match(input,77,FOLLOW_77_in_operationDeclaration341); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_77.add(char_literal17);

            // EolParserRules.g:115:81: ( formalParameterList )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==NAME) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // EolParserRules.g:0:0: formalParameterList
                    {
                    pushFollow(FOLLOW_formalParameterList_in_operationDeclaration343);
                    formalParameterList18=formalParameterList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_formalParameterList.add(formalParameterList18.getTree());

                    }
                    break;

            }

            char_literal19=(Token)match(input,78,FOLLOW_78_in_operationDeclaration346); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_78.add(char_literal19);

            // EolParserRules.g:115:106: ( ':' returnType= typeName )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==73) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // EolParserRules.g:115:107: ':' returnType= typeName
                    {
                    char_literal20=(Token)match(input,73,FOLLOW_73_in_operationDeclaration349); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_73.add(char_literal20);

                    pushFollow(FOLLOW_typeName_in_operationDeclaration353);
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

            pushFollow(FOLLOW_statementBlock_in_operationDeclaration359);
            statementBlock21=statementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_statementBlock.add(statementBlock21.getTree());


            // AST REWRITE
            // elements: operationName, statementBlock, ctx, formalParameterList, returnType
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
            // 116:3: -> ^( HELPERMETHOD ( $ctx)? $operationName ( formalParameterList )? ( $returnType)? statementBlock )
            {
                // EolParserRules.g:116:6: ^( HELPERMETHOD ( $ctx)? $operationName ( formalParameterList )? ( $returnType)? statementBlock )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(HELPERMETHOD, "HELPERMETHOD"), root_1);

                // EolParserRules.g:116:21: ( $ctx)?
                if ( stream_ctx.hasNext() ) {
                    adaptor.addChild(root_1, stream_ctx.nextTree());

                }
                stream_ctx.reset();
                adaptor.addChild(root_1, stream_operationName.nextNode());
                // EolParserRules.g:116:42: ( formalParameterList )?
                if ( stream_formalParameterList.hasNext() ) {
                    adaptor.addChild(root_1, stream_formalParameterList.nextTree());

                }
                stream_formalParameterList.reset();
                // EolParserRules.g:116:63: ( $returnType)?
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
    // EolParserRules.g:119:1: importStatement : i= 'import' STRING ';' ;
    public final Ewl_EolParserRules.importStatement_return importStatement() throws RecognitionException {
        Ewl_EolParserRules.importStatement_return retval = new Ewl_EolParserRules.importStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token i=null;
        Token STRING22=null;
        Token char_literal23=null;

        CommonTree i_tree=null;
        CommonTree STRING22_tree=null;
        CommonTree char_literal23_tree=null;

        try {
            // EolParserRules.g:120:2: (i= 'import' STRING ';' )
            // EolParserRules.g:120:4: i= 'import' STRING ';'
            {
            root_0 = (CommonTree)adaptor.nil();

            i=(Token)match(input,79,FOLLOW_79_in_importStatement396); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            i_tree = (CommonTree)adaptor.create(i);
            root_0 = (CommonTree)adaptor.becomeRoot(i_tree, root_0);
            }
            STRING22=(Token)match(input,STRING,FOLLOW_STRING_in_importStatement399); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STRING22_tree = (CommonTree)adaptor.create(STRING22);
            adaptor.addChild(root_0, STRING22_tree);
            }
            char_literal23=(Token)match(input,72,FOLLOW_72_in_importStatement401); if (state.failed) return retval;
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
    // EolParserRules.g:124:1: block : ( statement )* -> ^( BLOCK ( statement )* ) ;
    public final Ewl_EolParserRules.block_return block() throws RecognitionException {
        Ewl_EolParserRules.block_return retval = new Ewl_EolParserRules.block_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Ewl_EolParserRules.statement_return statement24 = null;


        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        try {
            // EolParserRules.g:125:2: ( ( statement )* -> ^( BLOCK ( statement )* ) )
            // EolParserRules.g:125:4: ( statement )*
            {
            // EolParserRules.g:125:4: ( statement )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==FLOAT||LA9_0==INT||LA9_0==BOOLEAN||LA9_0==STRING||LA9_0==NAME||LA9_0==77||(LA9_0>=86 && LA9_0<=92)||LA9_0==94||(LA9_0>=96 && LA9_0<=104)||LA9_0==118||LA9_0==121||(LA9_0>=123 && LA9_0<=124)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // EolParserRules.g:0:0: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_block416);
            	    statement24=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_statement.add(statement24.getTree());

            	    }
            	    break;

            	default :
            	    break loop9;
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
            // 126:2: -> ^( BLOCK ( statement )* )
            {
                // EolParserRules.g:126:5: ^( BLOCK ( statement )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(BLOCK, "BLOCK"), root_1);

                // EolParserRules.g:126:13: ( statement )*
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
    // EolParserRules.g:129:1: statementBlock : '{' block '}' ;
    public final Ewl_EolParserRules.statementBlock_return statementBlock() throws RecognitionException {
        Ewl_EolParserRules.statementBlock_return retval = new Ewl_EolParserRules.statementBlock_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal25=null;
        Token char_literal27=null;
        Ewl_EolParserRules.block_return block26 = null;


        CommonTree char_literal25_tree=null;
        CommonTree char_literal27_tree=null;

        try {
            // EolParserRules.g:130:2: ( '{' block '}' )
            // EolParserRules.g:130:4: '{' block '}'
            {
            root_0 = (CommonTree)adaptor.nil();

            char_literal25=(Token)match(input,80,FOLLOW_80_in_statementBlock438); if (state.failed) return retval;
            pushFollow(FOLLOW_block_in_statementBlock441);
            block26=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, block26.getTree());
            char_literal27=(Token)match(input,81,FOLLOW_81_in_statementBlock443); if (state.failed) return retval;

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
    // EolParserRules.g:133:1: formalParameter : NAME ( ':' pt= typeName )? -> ^( FORMAL NAME ( typeName )? ) ;
    public final Ewl_EolParserRules.formalParameter_return formalParameter() throws RecognitionException {
        Ewl_EolParserRules.formalParameter_return retval = new Ewl_EolParserRules.formalParameter_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NAME28=null;
        Token char_literal29=null;
        Ewl_EolParserRules.typeName_return pt = null;


        CommonTree NAME28_tree=null;
        CommonTree char_literal29_tree=null;
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_73=new RewriteRuleTokenStream(adaptor,"token 73");
        RewriteRuleSubtreeStream stream_typeName=new RewriteRuleSubtreeStream(adaptor,"rule typeName");
        try {
            // EolParserRules.g:134:2: ( NAME ( ':' pt= typeName )? -> ^( FORMAL NAME ( typeName )? ) )
            // EolParserRules.g:134:4: NAME ( ':' pt= typeName )?
            {
            NAME28=(Token)match(input,NAME,FOLLOW_NAME_in_formalParameter455); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(NAME28);

            // EolParserRules.g:134:9: ( ':' pt= typeName )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==73) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // EolParserRules.g:134:10: ':' pt= typeName
                    {
                    char_literal29=(Token)match(input,73,FOLLOW_73_in_formalParameter458); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_73.add(char_literal29);

                    pushFollow(FOLLOW_typeName_in_formalParameter462);
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
            // 135:3: -> ^( FORMAL NAME ( typeName )? )
            {
                // EolParserRules.g:135:6: ^( FORMAL NAME ( typeName )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FORMAL, "FORMAL"), root_1);

                adaptor.addChild(root_1, stream_NAME.nextNode());
                // EolParserRules.g:135:20: ( typeName )?
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
    // EolParserRules.g:138:1: formalParameterList : formalParameter ( ',' formalParameter )* -> ^( PARAMLIST ( formalParameter )* ) ;
    public final Ewl_EolParserRules.formalParameterList_return formalParameterList() throws RecognitionException {
        Ewl_EolParserRules.formalParameterList_return retval = new Ewl_EolParserRules.formalParameterList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal31=null;
        Ewl_EolParserRules.formalParameter_return formalParameter30 = null;

        Ewl_EolParserRules.formalParameter_return formalParameter32 = null;


        CommonTree char_literal31_tree=null;
        RewriteRuleTokenStream stream_74=new RewriteRuleTokenStream(adaptor,"token 74");
        RewriteRuleSubtreeStream stream_formalParameter=new RewriteRuleSubtreeStream(adaptor,"rule formalParameter");
        try {
            // EolParserRules.g:139:2: ( formalParameter ( ',' formalParameter )* -> ^( PARAMLIST ( formalParameter )* ) )
            // EolParserRules.g:139:4: formalParameter ( ',' formalParameter )*
            {
            pushFollow(FOLLOW_formalParameter_in_formalParameterList491);
            formalParameter30=formalParameter();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_formalParameter.add(formalParameter30.getTree());
            // EolParserRules.g:139:20: ( ',' formalParameter )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==74) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // EolParserRules.g:139:21: ',' formalParameter
            	    {
            	    char_literal31=(Token)match(input,74,FOLLOW_74_in_formalParameterList494); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_74.add(char_literal31);

            	    pushFollow(FOLLOW_formalParameter_in_formalParameterList496);
            	    formalParameter32=formalParameter();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_formalParameter.add(formalParameter32.getTree());

            	    }
            	    break;

            	default :
            	    break loop11;
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
            // 140:2: -> ^( PARAMLIST ( formalParameter )* )
            {
                // EolParserRules.g:140:5: ^( PARAMLIST ( formalParameter )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PARAMLIST, "PARAMLIST"), root_1);

                // EolParserRules.g:140:17: ( formalParameter )*
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
    // EolParserRules.g:143:1: executableAnnotation : '$' NAME logicalExpression -> ^( EXECUTABLEANNOTATION NAME logicalExpression ) ;
    public final Ewl_EolParserRules.executableAnnotation_return executableAnnotation() throws RecognitionException {
        Ewl_EolParserRules.executableAnnotation_return retval = new Ewl_EolParserRules.executableAnnotation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal33=null;
        Token NAME34=null;
        Ewl_EolParserRules.logicalExpression_return logicalExpression35 = null;


        CommonTree char_literal33_tree=null;
        CommonTree NAME34_tree=null;
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_82=new RewriteRuleTokenStream(adaptor,"token 82");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:144:2: ( '$' NAME logicalExpression -> ^( EXECUTABLEANNOTATION NAME logicalExpression ) )
            // EolParserRules.g:144:4: '$' NAME logicalExpression
            {
            char_literal33=(Token)match(input,82,FOLLOW_82_in_executableAnnotation519); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_82.add(char_literal33);

            NAME34=(Token)match(input,NAME,FOLLOW_NAME_in_executableAnnotation521); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(NAME34);

            pushFollow(FOLLOW_logicalExpression_in_executableAnnotation523);
            logicalExpression35=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression35.getTree());


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
            // 145:2: -> ^( EXECUTABLEANNOTATION NAME logicalExpression )
            {
                // EolParserRules.g:145:5: ^( EXECUTABLEANNOTATION NAME logicalExpression )
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
    // EolParserRules.g:148:1: annotation : ( Annotation | executableAnnotation );
    public final Ewl_EolParserRules.annotation_return annotation() throws RecognitionException {
        Ewl_EolParserRules.annotation_return retval = new Ewl_EolParserRules.annotation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token Annotation36=null;
        Ewl_EolParserRules.executableAnnotation_return executableAnnotation37 = null;


        CommonTree Annotation36_tree=null;

        try {
            // EolParserRules.g:149:2: ( Annotation | executableAnnotation )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==Annotation) ) {
                alt12=1;
            }
            else if ( (LA12_0==82) ) {
                alt12=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // EolParserRules.g:149:4: Annotation
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    Annotation36=(Token)match(input,Annotation,FOLLOW_Annotation_in_annotation545); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    Annotation36_tree = (CommonTree)adaptor.create(Annotation36);
                    adaptor.addChild(root_0, Annotation36_tree);
                    }

                    }
                    break;
                case 2 :
                    // EolParserRules.g:149:15: executableAnnotation
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_executableAnnotation_in_annotation547);
                    executableAnnotation37=executableAnnotation();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, executableAnnotation37.getTree());

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
    // EolParserRules.g:152:1: annotationBlock : ( annotation )+ -> ^( ANNOTATIONBLOCK ( annotation )+ ) ;
    public final Ewl_EolParserRules.annotationBlock_return annotationBlock() throws RecognitionException {
        Ewl_EolParserRules.annotationBlock_return retval = new Ewl_EolParserRules.annotationBlock_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Ewl_EolParserRules.annotation_return annotation38 = null;


        RewriteRuleSubtreeStream stream_annotation=new RewriteRuleSubtreeStream(adaptor,"rule annotation");
        try {
            // EolParserRules.g:153:2: ( ( annotation )+ -> ^( ANNOTATIONBLOCK ( annotation )+ ) )
            // EolParserRules.g:153:4: ( annotation )+
            {
            // EolParserRules.g:153:4: ( annotation )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==Annotation) ) {
                    int LA13_2 = input.LA(2);

                    if ( (synpred13_EolParserRules()) ) {
                        alt13=1;
                    }


                }
                else if ( (LA13_0==82) ) {
                    int LA13_3 = input.LA(2);

                    if ( (synpred13_EolParserRules()) ) {
                        alt13=1;
                    }


                }


                switch (alt13) {
            	case 1 :
            	    // EolParserRules.g:0:0: annotation
            	    {
            	    pushFollow(FOLLOW_annotation_in_annotationBlock558);
            	    annotation38=annotation();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_annotation.add(annotation38.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt13 >= 1 ) break loop13;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(13, input);
                        throw eee;
                }
                cnt13++;
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
            // 154:2: -> ^( ANNOTATIONBLOCK ( annotation )+ )
            {
                // EolParserRules.g:154:5: ^( ANNOTATIONBLOCK ( annotation )+ )
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
    // EolParserRules.g:157:1: typeName : ( pathName | nativeType | collectionType );
    public final Ewl_EolParserRules.typeName_return typeName() throws RecognitionException {
        Ewl_EolParserRules.typeName_return retval = new Ewl_EolParserRules.typeName_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Ewl_EolParserRules.pathName_return pathName39 = null;

        Ewl_EolParserRules.nativeType_return nativeType40 = null;

        Ewl_EolParserRules.collectionType_return collectionType41 = null;



        try {
            // EolParserRules.g:158:2: ( pathName | nativeType | collectionType )
            int alt14=3;
            switch ( input.LA(1) ) {
            case NAME:
                {
                alt14=1;
                }
                break;
            case 86:
                {
                alt14=2;
                }
                break;
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
                {
                alt14=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // EolParserRules.g:158:4: pathName
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_pathName_in_typeName581);
                    pathName39=pathName();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pathName39.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:158:15: nativeType
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_nativeType_in_typeName585);
                    nativeType40=nativeType();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nativeType40.getTree());

                    }
                    break;
                case 3 :
                    // EolParserRules.g:158:28: collectionType
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_collectionType_in_typeName589);
                    collectionType41=collectionType();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, collectionType41.getTree());
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
    // EolParserRules.g:162:1: pathName : (metamodel= NAME '!' )? head= NAME ( '::' field= NAME )* ( '#' label= NAME )? ;
    public final Ewl_EolParserRules.pathName_return pathName() throws RecognitionException {
        Ewl_EolParserRules.pathName_return retval = new Ewl_EolParserRules.pathName_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token metamodel=null;
        Token head=null;
        Token field=null;
        Token label=null;
        Token char_literal42=null;
        Token string_literal43=null;
        Token char_literal44=null;

        CommonTree metamodel_tree=null;
        CommonTree head_tree=null;
        CommonTree field_tree=null;
        CommonTree label_tree=null;
        CommonTree char_literal42_tree=null;
        CommonTree string_literal43_tree=null;
        CommonTree char_literal44_tree=null;

        try {
            // EolParserRules.g:163:2: ( (metamodel= NAME '!' )? head= NAME ( '::' field= NAME )* ( '#' label= NAME )? )
            // EolParserRules.g:163:4: (metamodel= NAME '!' )? head= NAME ( '::' field= NAME )* ( '#' label= NAME )?
            {
            root_0 = (CommonTree)adaptor.nil();

            // EolParserRules.g:163:4: (metamodel= NAME '!' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==NAME) ) {
                int LA15_1 = input.LA(2);

                if ( (LA15_1==83) ) {
                    alt15=1;
                }
            }
            switch (alt15) {
                case 1 :
                    // EolParserRules.g:163:5: metamodel= NAME '!'
                    {
                    metamodel=(Token)match(input,NAME,FOLLOW_NAME_in_pathName606); if (state.failed) return retval;
                    char_literal42=(Token)match(input,83,FOLLOW_83_in_pathName609); if (state.failed) return retval;

                    }
                    break;

            }

            head=(Token)match(input,NAME,FOLLOW_NAME_in_pathName616); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            head_tree = (CommonTree)adaptor.create(head);
            adaptor.addChild(root_0, head_tree);
            }
            // EolParserRules.g:164:3: ( '::' field= NAME )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==84) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // EolParserRules.g:164:4: '::' field= NAME
            	    {
            	    string_literal43=(Token)match(input,84,FOLLOW_84_in_pathName621); if (state.failed) return retval;
            	    field=(Token)match(input,NAME,FOLLOW_NAME_in_pathName626); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	      
            	      			head.setText(head.getText()
            	      					+ "::"
            	      					+ field.getText()
            	      					); 
            	      		
            	    }

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            // EolParserRules.g:170:3: ( '#' label= NAME )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==85) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // EolParserRules.g:170:4: '#' label= NAME
                    {
                    char_literal44=(Token)match(input,85,FOLLOW_85_in_pathName636); if (state.failed) return retval;
                    label=(Token)match(input,NAME,FOLLOW_NAME_in_pathName641); if (state.failed) return retval;

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
    // EolParserRules.g:185:1: nativeType : 'Native' '(' STRING ')' ;
    public final Ewl_EolParserRules.nativeType_return nativeType() throws RecognitionException {
        Ewl_EolParserRules.nativeType_return retval = new Ewl_EolParserRules.nativeType_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal45=null;
        Token char_literal46=null;
        Token STRING47=null;
        Token char_literal48=null;

        CommonTree string_literal45_tree=null;
        CommonTree char_literal46_tree=null;
        CommonTree STRING47_tree=null;
        CommonTree char_literal48_tree=null;

        try {
            // EolParserRules.g:186:2: ( 'Native' '(' STRING ')' )
            // EolParserRules.g:186:4: 'Native' '(' STRING ')'
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal45=(Token)match(input,86,FOLLOW_86_in_nativeType661); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal45_tree = (CommonTree)adaptor.create(string_literal45);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal45_tree, root_0);
            }
            char_literal46=(Token)match(input,77,FOLLOW_77_in_nativeType664); if (state.failed) return retval;
            STRING47=(Token)match(input,STRING,FOLLOW_STRING_in_nativeType667); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STRING47_tree = (CommonTree)adaptor.create(STRING47);
            adaptor.addChild(root_0, STRING47_tree);
            }
            char_literal48=(Token)match(input,78,FOLLOW_78_in_nativeType669); if (state.failed) return retval;
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
    // EolParserRules.g:191:1: modelElementType : NAME '!' NAME -> ^( ModelElementType ( NAME )+ ) ;
    public final Ewl_EolParserRules.modelElementType_return modelElementType() throws RecognitionException {
        Ewl_EolParserRules.modelElementType_return retval = new Ewl_EolParserRules.modelElementType_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NAME49=null;
        Token char_literal50=null;
        Token NAME51=null;

        CommonTree NAME49_tree=null;
        CommonTree char_literal50_tree=null;
        CommonTree NAME51_tree=null;
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_83=new RewriteRuleTokenStream(adaptor,"token 83");

        try {
            // EolParserRules.g:192:2: ( NAME '!' NAME -> ^( ModelElementType ( NAME )+ ) )
            // EolParserRules.g:192:4: NAME '!' NAME
            {
            NAME49=(Token)match(input,NAME,FOLLOW_NAME_in_modelElementType686); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(NAME49);

            char_literal50=(Token)match(input,83,FOLLOW_83_in_modelElementType688); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_83.add(char_literal50);

            NAME51=(Token)match(input,NAME,FOLLOW_NAME_in_modelElementType690); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(NAME51);



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
            // 193:2: -> ^( ModelElementType ( NAME )+ )
            {
                // EolParserRules.g:193:5: ^( ModelElementType ( NAME )+ )
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
    // EolParserRules.g:196:1: collectionType : ( 'Collection' | 'Sequence' | 'Bag' | 'Set' | 'OrderedSet' ) ( '(' tn= typeName ')' )? ;
    public final Ewl_EolParserRules.collectionType_return collectionType() throws RecognitionException {
        Ewl_EolParserRules.collectionType_return retval = new Ewl_EolParserRules.collectionType_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set52=null;
        Token char_literal53=null;
        Token char_literal54=null;
        Ewl_EolParserRules.typeName_return tn = null;


        CommonTree set52_tree=null;
        CommonTree char_literal53_tree=null;
        CommonTree char_literal54_tree=null;

        try {
            // EolParserRules.g:197:2: ( ( 'Collection' | 'Sequence' | 'Bag' | 'Set' | 'OrderedSet' ) ( '(' tn= typeName ')' )? )
            // EolParserRules.g:197:5: ( 'Collection' | 'Sequence' | 'Bag' | 'Set' | 'OrderedSet' ) ( '(' tn= typeName ')' )?
            {
            root_0 = (CommonTree)adaptor.nil();

            set52=(Token)input.LT(1);
            set52=(Token)input.LT(1);
            if ( (input.LA(1)>=87 && input.LA(1)<=91) ) {
                input.consume();
                if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(set52), root_0);
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            // EolParserRules.g:198:3: ( '(' tn= typeName ')' )?
            int alt18=2;
            alt18 = dfa18.predict(input);
            switch (alt18) {
                case 1 :
                    // EolParserRules.g:198:4: '(' tn= typeName ')'
                    {
                    char_literal53=(Token)match(input,77,FOLLOW_77_in_collectionType728); if (state.failed) return retval;
                    pushFollow(FOLLOW_typeName_in_collectionType733);
                    tn=typeName();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, tn.getTree());
                    if ( state.backtracking==0 ) {
                      setTokenType(tn,TYPE);
                    }
                    char_literal54=(Token)match(input,78,FOLLOW_78_in_collectionType736); if (state.failed) return retval;

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
    // EolParserRules.g:204:1: statement : ( statementA | statementB );
    public final Ewl_EolParserRules.statement_return statement() throws RecognitionException {
        Ewl_EolParserRules.statement_return retval = new Ewl_EolParserRules.statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Ewl_EolParserRules.statementA_return statementA55 = null;

        Ewl_EolParserRules.statementB_return statementB56 = null;



        try {
            // EolParserRules.g:205:2: ( statementA | statementB )
            int alt19=2;
            alt19 = dfa19.predict(input);
            switch (alt19) {
                case 1 :
                    // EolParserRules.g:205:4: statementA
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_statementA_in_statement759);
                    statementA55=statementA();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statementA55.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:205:17: statementB
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_statementB_in_statement763);
                    statementB56=statementB();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statementB56.getTree());

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
    // EolParserRules.g:208:1: statementA : ( assignmentStatement | expressionStatement | forStatement | ifStatement | whileStatement | returnStatement | breakStatement );
    public final Ewl_EolParserRules.statementA_return statementA() throws RecognitionException {
        Ewl_EolParserRules.statementA_return retval = new Ewl_EolParserRules.statementA_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Ewl_EolParserRules.assignmentStatement_return assignmentStatement57 = null;

        Ewl_EolParserRules.expressionStatement_return expressionStatement58 = null;

        Ewl_EolParserRules.forStatement_return forStatement59 = null;

        Ewl_EolParserRules.ifStatement_return ifStatement60 = null;

        Ewl_EolParserRules.whileStatement_return whileStatement61 = null;

        Ewl_EolParserRules.returnStatement_return returnStatement62 = null;

        Ewl_EolParserRules.breakStatement_return breakStatement63 = null;



        try {
            // EolParserRules.g:209:2: ( assignmentStatement | expressionStatement | forStatement | ifStatement | whileStatement | returnStatement | breakStatement )
            int alt20=7;
            alt20 = dfa20.predict(input);
            switch (alt20) {
                case 1 :
                    // EolParserRules.g:209:3: assignmentStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_assignmentStatement_in_statementA773);
                    assignmentStatement57=assignmentStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, assignmentStatement57.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:209:25: expressionStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_expressionStatement_in_statementA777);
                    expressionStatement58=expressionStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionStatement58.getTree());

                    }
                    break;
                case 3 :
                    // EolParserRules.g:209:47: forStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_forStatement_in_statementA781);
                    forStatement59=forStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, forStatement59.getTree());

                    }
                    break;
                case 4 :
                    // EolParserRules.g:210:5: ifStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_ifStatement_in_statementA787);
                    ifStatement60=ifStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, ifStatement60.getTree());

                    }
                    break;
                case 5 :
                    // EolParserRules.g:210:19: whileStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_whileStatement_in_statementA791);
                    whileStatement61=whileStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, whileStatement61.getTree());

                    }
                    break;
                case 6 :
                    // EolParserRules.g:210:36: returnStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_returnStatement_in_statementA795);
                    returnStatement62=returnStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, returnStatement62.getTree());

                    }
                    break;
                case 7 :
                    // EolParserRules.g:210:54: breakStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_breakStatement_in_statementA799);
                    breakStatement63=breakStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, breakStatement63.getTree());

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
    // EolParserRules.g:213:1: statementB : ( breakAllStatement | returnStatement | transactionStatement | abortStatement | continueStatement | throwStatement | deleteStatement );
    public final Ewl_EolParserRules.statementB_return statementB() throws RecognitionException {
        Ewl_EolParserRules.statementB_return retval = new Ewl_EolParserRules.statementB_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Ewl_EolParserRules.breakAllStatement_return breakAllStatement64 = null;

        Ewl_EolParserRules.returnStatement_return returnStatement65 = null;

        Ewl_EolParserRules.transactionStatement_return transactionStatement66 = null;

        Ewl_EolParserRules.abortStatement_return abortStatement67 = null;

        Ewl_EolParserRules.continueStatement_return continueStatement68 = null;

        Ewl_EolParserRules.throwStatement_return throwStatement69 = null;

        Ewl_EolParserRules.deleteStatement_return deleteStatement70 = null;



        try {
            // EolParserRules.g:214:2: ( breakAllStatement | returnStatement | transactionStatement | abortStatement | continueStatement | throwStatement | deleteStatement )
            int alt21=7;
            switch ( input.LA(1) ) {
            case 101:
                {
                alt21=1;
                }
                break;
            case 97:
                {
                alt21=2;
                }
                break;
            case 104:
                {
                alt21=3;
                }
                break;
            case 103:
                {
                alt21=4;
                }
                break;
            case 102:
                {
                alt21=5;
                }
                break;
            case 98:
                {
                alt21=6;
                }
                break;
            case 99:
                {
                alt21=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // EolParserRules.g:214:4: breakAllStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_breakAllStatement_in_statementB811);
                    breakAllStatement64=breakAllStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, breakAllStatement64.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:214:24: returnStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_returnStatement_in_statementB815);
                    returnStatement65=returnStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, returnStatement65.getTree());

                    }
                    break;
                case 3 :
                    // EolParserRules.g:214:42: transactionStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_transactionStatement_in_statementB819);
                    transactionStatement66=transactionStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, transactionStatement66.getTree());

                    }
                    break;
                case 4 :
                    // EolParserRules.g:215:5: abortStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_abortStatement_in_statementB825);
                    abortStatement67=abortStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, abortStatement67.getTree());

                    }
                    break;
                case 5 :
                    // EolParserRules.g:215:22: continueStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_continueStatement_in_statementB829);
                    continueStatement68=continueStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, continueStatement68.getTree());

                    }
                    break;
                case 6 :
                    // EolParserRules.g:215:42: throwStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_throwStatement_in_statementB833);
                    throwStatement69=throwStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, throwStatement69.getTree());

                    }
                    break;
                case 7 :
                    // EolParserRules.g:216:5: deleteStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_deleteStatement_in_statementB839);
                    deleteStatement70=deleteStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, deleteStatement70.getTree());

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
    // EolParserRules.g:219:1: statementOrStatementBlock : ( statement | statementBlock );
    public final Ewl_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock() throws RecognitionException {
        Ewl_EolParserRules.statementOrStatementBlock_return retval = new Ewl_EolParserRules.statementOrStatementBlock_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Ewl_EolParserRules.statement_return statement71 = null;

        Ewl_EolParserRules.statementBlock_return statementBlock72 = null;



        try {
            // EolParserRules.g:220:2: ( statement | statementBlock )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==FLOAT||LA22_0==INT||LA22_0==BOOLEAN||LA22_0==STRING||LA22_0==NAME||LA22_0==77||(LA22_0>=86 && LA22_0<=92)||LA22_0==94||(LA22_0>=96 && LA22_0<=104)||LA22_0==118||LA22_0==121||(LA22_0>=123 && LA22_0<=124)) ) {
                alt22=1;
            }
            else if ( (LA22_0==80) ) {
                alt22=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // EolParserRules.g:220:4: statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_statement_in_statementOrStatementBlock850);
                    statement71=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement71.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:220:16: statementBlock
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_statementBlock_in_statementOrStatementBlock854);
                    statementBlock72=statementBlock();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statementBlock72.getTree());

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
    // EolParserRules.g:222:1: expressionOrStatementBlock : ( ':' logicalExpression | statementBlock );
    public final Ewl_EolParserRules.expressionOrStatementBlock_return expressionOrStatementBlock() throws RecognitionException {
        Ewl_EolParserRules.expressionOrStatementBlock_return retval = new Ewl_EolParserRules.expressionOrStatementBlock_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal73=null;
        Ewl_EolParserRules.logicalExpression_return logicalExpression74 = null;

        Ewl_EolParserRules.statementBlock_return statementBlock75 = null;


        CommonTree char_literal73_tree=null;

        try {
            // EolParserRules.g:223:2: ( ':' logicalExpression | statementBlock )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==73) ) {
                alt23=1;
            }
            else if ( (LA23_0==80) ) {
                alt23=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // EolParserRules.g:223:4: ':' logicalExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    char_literal73=(Token)match(input,73,FOLLOW_73_in_expressionOrStatementBlock863); if (state.failed) return retval;
                    pushFollow(FOLLOW_logicalExpression_in_expressionOrStatementBlock866);
                    logicalExpression74=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression74.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:223:29: statementBlock
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_statementBlock_in_expressionOrStatementBlock870);
                    statementBlock75=statementBlock();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statementBlock75.getTree());

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
    // EolParserRules.g:226:1: forStatement : 'for' '(' formalParameter 'in' logicalExpression ')' statementOrStatementBlock -> ^( FOR formalParameter logicalExpression statementOrStatementBlock ) ;
    public final Ewl_EolParserRules.forStatement_return forStatement() throws RecognitionException {
        Ewl_EolParserRules.forStatement_return retval = new Ewl_EolParserRules.forStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal76=null;
        Token char_literal77=null;
        Token string_literal79=null;
        Token char_literal81=null;
        Ewl_EolParserRules.formalParameter_return formalParameter78 = null;

        Ewl_EolParserRules.logicalExpression_return logicalExpression80 = null;

        Ewl_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock82 = null;


        CommonTree string_literal76_tree=null;
        CommonTree char_literal77_tree=null;
        CommonTree string_literal79_tree=null;
        CommonTree char_literal81_tree=null;
        RewriteRuleTokenStream stream_78=new RewriteRuleTokenStream(adaptor,"token 78");
        RewriteRuleTokenStream stream_77=new RewriteRuleTokenStream(adaptor,"token 77");
        RewriteRuleTokenStream stream_93=new RewriteRuleTokenStream(adaptor,"token 93");
        RewriteRuleTokenStream stream_92=new RewriteRuleTokenStream(adaptor,"token 92");
        RewriteRuleSubtreeStream stream_statementOrStatementBlock=new RewriteRuleSubtreeStream(adaptor,"rule statementOrStatementBlock");
        RewriteRuleSubtreeStream stream_formalParameter=new RewriteRuleSubtreeStream(adaptor,"rule formalParameter");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:227:2: ( 'for' '(' formalParameter 'in' logicalExpression ')' statementOrStatementBlock -> ^( FOR formalParameter logicalExpression statementOrStatementBlock ) )
            // EolParserRules.g:227:4: 'for' '(' formalParameter 'in' logicalExpression ')' statementOrStatementBlock
            {
            string_literal76=(Token)match(input,92,FOLLOW_92_in_forStatement881); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_92.add(string_literal76);

            char_literal77=(Token)match(input,77,FOLLOW_77_in_forStatement883); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_77.add(char_literal77);

            pushFollow(FOLLOW_formalParameter_in_forStatement885);
            formalParameter78=formalParameter();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_formalParameter.add(formalParameter78.getTree());
            string_literal79=(Token)match(input,93,FOLLOW_93_in_forStatement887); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_93.add(string_literal79);

            pushFollow(FOLLOW_logicalExpression_in_forStatement889);
            logicalExpression80=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression80.getTree());
            char_literal81=(Token)match(input,78,FOLLOW_78_in_forStatement891); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_78.add(char_literal81);

            pushFollow(FOLLOW_statementOrStatementBlock_in_forStatement893);
            statementOrStatementBlock82=statementOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_statementOrStatementBlock.add(statementOrStatementBlock82.getTree());


            // AST REWRITE
            // elements: formalParameter, logicalExpression, statementOrStatementBlock
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 228:2: -> ^( FOR formalParameter logicalExpression statementOrStatementBlock )
            {
                // EolParserRules.g:228:5: ^( FOR formalParameter logicalExpression statementOrStatementBlock )
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
    // EolParserRules.g:231:1: ifStatement : 'if' '(' logicalExpression ')' statementOrStatementBlock ( elseStatement )? -> ^( IF logicalExpression statementOrStatementBlock ( elseStatement )? ) ;
    public final Ewl_EolParserRules.ifStatement_return ifStatement() throws RecognitionException {
        Ewl_EolParserRules.ifStatement_return retval = new Ewl_EolParserRules.ifStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal83=null;
        Token char_literal84=null;
        Token char_literal86=null;
        Ewl_EolParserRules.logicalExpression_return logicalExpression85 = null;

        Ewl_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock87 = null;

        Ewl_EolParserRules.elseStatement_return elseStatement88 = null;


        CommonTree string_literal83_tree=null;
        CommonTree char_literal84_tree=null;
        CommonTree char_literal86_tree=null;
        RewriteRuleTokenStream stream_78=new RewriteRuleTokenStream(adaptor,"token 78");
        RewriteRuleTokenStream stream_77=new RewriteRuleTokenStream(adaptor,"token 77");
        RewriteRuleTokenStream stream_94=new RewriteRuleTokenStream(adaptor,"token 94");
        RewriteRuleSubtreeStream stream_statementOrStatementBlock=new RewriteRuleSubtreeStream(adaptor,"rule statementOrStatementBlock");
        RewriteRuleSubtreeStream stream_elseStatement=new RewriteRuleSubtreeStream(adaptor,"rule elseStatement");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:232:2: ( 'if' '(' logicalExpression ')' statementOrStatementBlock ( elseStatement )? -> ^( IF logicalExpression statementOrStatementBlock ( elseStatement )? ) )
            // EolParserRules.g:232:4: 'if' '(' logicalExpression ')' statementOrStatementBlock ( elseStatement )?
            {
            string_literal83=(Token)match(input,94,FOLLOW_94_in_ifStatement917); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_94.add(string_literal83);

            char_literal84=(Token)match(input,77,FOLLOW_77_in_ifStatement919); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_77.add(char_literal84);

            pushFollow(FOLLOW_logicalExpression_in_ifStatement921);
            logicalExpression85=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression85.getTree());
            char_literal86=(Token)match(input,78,FOLLOW_78_in_ifStatement923); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_78.add(char_literal86);

            pushFollow(FOLLOW_statementOrStatementBlock_in_ifStatement925);
            statementOrStatementBlock87=statementOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_statementOrStatementBlock.add(statementOrStatementBlock87.getTree());
            // EolParserRules.g:232:61: ( elseStatement )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==95) ) {
                int LA24_1 = input.LA(2);

                if ( (synpred39_EolParserRules()) ) {
                    alt24=1;
                }
            }
            switch (alt24) {
                case 1 :
                    // EolParserRules.g:0:0: elseStatement
                    {
                    pushFollow(FOLLOW_elseStatement_in_ifStatement927);
                    elseStatement88=elseStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_elseStatement.add(elseStatement88.getTree());

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
            // 233:2: -> ^( IF logicalExpression statementOrStatementBlock ( elseStatement )? )
            {
                // EolParserRules.g:233:5: ^( IF logicalExpression statementOrStatementBlock ( elseStatement )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(IF, "IF"), root_1);

                adaptor.addChild(root_1, stream_logicalExpression.nextTree());
                adaptor.addChild(root_1, stream_statementOrStatementBlock.nextTree());
                // EolParserRules.g:233:54: ( elseStatement )?
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
    // EolParserRules.g:236:1: elseStatement : 'else' statementOrStatementBlock ;
    public final Ewl_EolParserRules.elseStatement_return elseStatement() throws RecognitionException {
        Ewl_EolParserRules.elseStatement_return retval = new Ewl_EolParserRules.elseStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal89=null;
        Ewl_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock90 = null;


        CommonTree string_literal89_tree=null;

        try {
            // EolParserRules.g:237:2: ( 'else' statementOrStatementBlock )
            // EolParserRules.g:237:4: 'else' statementOrStatementBlock
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal89=(Token)match(input,95,FOLLOW_95_in_elseStatement954); if (state.failed) return retval;
            pushFollow(FOLLOW_statementOrStatementBlock_in_elseStatement957);
            statementOrStatementBlock90=statementOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, statementOrStatementBlock90.getTree());

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
    // EolParserRules.g:241:1: whileStatement : 'while' '(' logicalExpression ')' statementOrStatementBlock -> ^( WHILE logicalExpression statementOrStatementBlock ) ;
    public final Ewl_EolParserRules.whileStatement_return whileStatement() throws RecognitionException {
        Ewl_EolParserRules.whileStatement_return retval = new Ewl_EolParserRules.whileStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal91=null;
        Token char_literal92=null;
        Token char_literal94=null;
        Ewl_EolParserRules.logicalExpression_return logicalExpression93 = null;

        Ewl_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock95 = null;


        CommonTree string_literal91_tree=null;
        CommonTree char_literal92_tree=null;
        CommonTree char_literal94_tree=null;
        RewriteRuleTokenStream stream_78=new RewriteRuleTokenStream(adaptor,"token 78");
        RewriteRuleTokenStream stream_96=new RewriteRuleTokenStream(adaptor,"token 96");
        RewriteRuleTokenStream stream_77=new RewriteRuleTokenStream(adaptor,"token 77");
        RewriteRuleSubtreeStream stream_statementOrStatementBlock=new RewriteRuleSubtreeStream(adaptor,"rule statementOrStatementBlock");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:242:2: ( 'while' '(' logicalExpression ')' statementOrStatementBlock -> ^( WHILE logicalExpression statementOrStatementBlock ) )
            // EolParserRules.g:242:4: 'while' '(' logicalExpression ')' statementOrStatementBlock
            {
            string_literal91=(Token)match(input,96,FOLLOW_96_in_whileStatement970); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_96.add(string_literal91);

            char_literal92=(Token)match(input,77,FOLLOW_77_in_whileStatement972); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_77.add(char_literal92);

            pushFollow(FOLLOW_logicalExpression_in_whileStatement974);
            logicalExpression93=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression93.getTree());
            char_literal94=(Token)match(input,78,FOLLOW_78_in_whileStatement976); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_78.add(char_literal94);

            pushFollow(FOLLOW_statementOrStatementBlock_in_whileStatement978);
            statementOrStatementBlock95=statementOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_statementOrStatementBlock.add(statementOrStatementBlock95.getTree());


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
            // 243:2: -> ^( WHILE logicalExpression statementOrStatementBlock )
            {
                // EolParserRules.g:243:5: ^( WHILE logicalExpression statementOrStatementBlock )
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
    // EolParserRules.g:246:1: returnStatement : 'return' ( logicalExpression )? ';' -> ^( RETURN ( logicalExpression )? ) ;
    public final Ewl_EolParserRules.returnStatement_return returnStatement() throws RecognitionException {
        Ewl_EolParserRules.returnStatement_return retval = new Ewl_EolParserRules.returnStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal96=null;
        Token char_literal98=null;
        Ewl_EolParserRules.logicalExpression_return logicalExpression97 = null;


        CommonTree string_literal96_tree=null;
        CommonTree char_literal98_tree=null;
        RewriteRuleTokenStream stream_97=new RewriteRuleTokenStream(adaptor,"token 97");
        RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:247:2: ( 'return' ( logicalExpression )? ';' -> ^( RETURN ( logicalExpression )? ) )
            // EolParserRules.g:247:4: 'return' ( logicalExpression )? ';'
            {
            string_literal96=(Token)match(input,97,FOLLOW_97_in_returnStatement1000); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_97.add(string_literal96);

            // EolParserRules.g:247:13: ( logicalExpression )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==FLOAT||LA25_0==INT||LA25_0==BOOLEAN||LA25_0==STRING||LA25_0==NAME||LA25_0==77||(LA25_0>=86 && LA25_0<=91)||LA25_0==118||LA25_0==121||(LA25_0>=123 && LA25_0<=124)) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // EolParserRules.g:0:0: logicalExpression
                    {
                    pushFollow(FOLLOW_logicalExpression_in_returnStatement1002);
                    logicalExpression97=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression97.getTree());

                    }
                    break;

            }

            char_literal98=(Token)match(input,72,FOLLOW_72_in_returnStatement1005); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_72.add(char_literal98);



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
            // 248:2: -> ^( RETURN ( logicalExpression )? )
            {
                // EolParserRules.g:248:5: ^( RETURN ( logicalExpression )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(RETURN, "RETURN"), root_1);

                // EolParserRules.g:248:14: ( logicalExpression )?
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
    // EolParserRules.g:251:1: throwStatement : 'throw' ( logicalExpression )? ';' -> ^( THROW ( logicalExpression )? ) ;
    public final Ewl_EolParserRules.throwStatement_return throwStatement() throws RecognitionException {
        Ewl_EolParserRules.throwStatement_return retval = new Ewl_EolParserRules.throwStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal99=null;
        Token char_literal101=null;
        Ewl_EolParserRules.logicalExpression_return logicalExpression100 = null;


        CommonTree string_literal99_tree=null;
        CommonTree char_literal101_tree=null;
        RewriteRuleTokenStream stream_98=new RewriteRuleTokenStream(adaptor,"token 98");
        RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:252:2: ( 'throw' ( logicalExpression )? ';' -> ^( THROW ( logicalExpression )? ) )
            // EolParserRules.g:252:4: 'throw' ( logicalExpression )? ';'
            {
            string_literal99=(Token)match(input,98,FOLLOW_98_in_throwStatement1026); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_98.add(string_literal99);

            // EolParserRules.g:252:12: ( logicalExpression )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==FLOAT||LA26_0==INT||LA26_0==BOOLEAN||LA26_0==STRING||LA26_0==NAME||LA26_0==77||(LA26_0>=86 && LA26_0<=91)||LA26_0==118||LA26_0==121||(LA26_0>=123 && LA26_0<=124)) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // EolParserRules.g:0:0: logicalExpression
                    {
                    pushFollow(FOLLOW_logicalExpression_in_throwStatement1028);
                    logicalExpression100=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression100.getTree());

                    }
                    break;

            }

            char_literal101=(Token)match(input,72,FOLLOW_72_in_throwStatement1031); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_72.add(char_literal101);



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
            // 253:2: -> ^( THROW ( logicalExpression )? )
            {
                // EolParserRules.g:253:5: ^( THROW ( logicalExpression )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(THROW, "THROW"), root_1);

                // EolParserRules.g:253:13: ( logicalExpression )?
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
    // EolParserRules.g:256:1: deleteStatement : 'delete' ( logicalExpression )? ';' -> ^( DELETE ( logicalExpression )? ) ;
    public final Ewl_EolParserRules.deleteStatement_return deleteStatement() throws RecognitionException {
        Ewl_EolParserRules.deleteStatement_return retval = new Ewl_EolParserRules.deleteStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal102=null;
        Token char_literal104=null;
        Ewl_EolParserRules.logicalExpression_return logicalExpression103 = null;


        CommonTree string_literal102_tree=null;
        CommonTree char_literal104_tree=null;
        RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
        RewriteRuleTokenStream stream_99=new RewriteRuleTokenStream(adaptor,"token 99");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:257:2: ( 'delete' ( logicalExpression )? ';' -> ^( DELETE ( logicalExpression )? ) )
            // EolParserRules.g:257:4: 'delete' ( logicalExpression )? ';'
            {
            string_literal102=(Token)match(input,99,FOLLOW_99_in_deleteStatement1052); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_99.add(string_literal102);

            // EolParserRules.g:257:13: ( logicalExpression )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==FLOAT||LA27_0==INT||LA27_0==BOOLEAN||LA27_0==STRING||LA27_0==NAME||LA27_0==77||(LA27_0>=86 && LA27_0<=91)||LA27_0==118||LA27_0==121||(LA27_0>=123 && LA27_0<=124)) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // EolParserRules.g:0:0: logicalExpression
                    {
                    pushFollow(FOLLOW_logicalExpression_in_deleteStatement1054);
                    logicalExpression103=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression103.getTree());

                    }
                    break;

            }

            char_literal104=(Token)match(input,72,FOLLOW_72_in_deleteStatement1057); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_72.add(char_literal104);



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
            // 258:2: -> ^( DELETE ( logicalExpression )? )
            {
                // EolParserRules.g:258:5: ^( DELETE ( logicalExpression )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(DELETE, "DELETE"), root_1);

                // EolParserRules.g:258:14: ( logicalExpression )?
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
    // EolParserRules.g:261:1: breakStatement : 'break' ';' -> ^( BREAK ) ;
    public final Ewl_EolParserRules.breakStatement_return breakStatement() throws RecognitionException {
        Ewl_EolParserRules.breakStatement_return retval = new Ewl_EolParserRules.breakStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal105=null;
        Token char_literal106=null;

        CommonTree string_literal105_tree=null;
        CommonTree char_literal106_tree=null;
        RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
        RewriteRuleTokenStream stream_100=new RewriteRuleTokenStream(adaptor,"token 100");

        try {
            // EolParserRules.g:262:2: ( 'break' ';' -> ^( BREAK ) )
            // EolParserRules.g:262:4: 'break' ';'
            {
            string_literal105=(Token)match(input,100,FOLLOW_100_in_breakStatement1081); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_100.add(string_literal105);

            char_literal106=(Token)match(input,72,FOLLOW_72_in_breakStatement1083); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_72.add(char_literal106);



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
            // 263:2: -> ^( BREAK )
            {
                // EolParserRules.g:263:5: ^( BREAK )
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
    // EolParserRules.g:266:1: breakAllStatement : 'breakAll' ';' -> ^( BREAKALL ) ;
    public final Ewl_EolParserRules.breakAllStatement_return breakAllStatement() throws RecognitionException {
        Ewl_EolParserRules.breakAllStatement_return retval = new Ewl_EolParserRules.breakAllStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal107=null;
        Token char_literal108=null;

        CommonTree string_literal107_tree=null;
        CommonTree char_literal108_tree=null;
        RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
        RewriteRuleTokenStream stream_101=new RewriteRuleTokenStream(adaptor,"token 101");

        try {
            // EolParserRules.g:267:2: ( 'breakAll' ';' -> ^( BREAKALL ) )
            // EolParserRules.g:267:4: 'breakAll' ';'
            {
            string_literal107=(Token)match(input,101,FOLLOW_101_in_breakAllStatement1101); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_101.add(string_literal107);

            char_literal108=(Token)match(input,72,FOLLOW_72_in_breakAllStatement1103); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_72.add(char_literal108);



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
            // 268:2: -> ^( BREAKALL )
            {
                // EolParserRules.g:268:5: ^( BREAKALL )
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
    // EolParserRules.g:271:1: continueStatement : 'continue' ';' -> ^( CONTINUE ) ;
    public final Ewl_EolParserRules.continueStatement_return continueStatement() throws RecognitionException {
        Ewl_EolParserRules.continueStatement_return retval = new Ewl_EolParserRules.continueStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal109=null;
        Token char_literal110=null;

        CommonTree string_literal109_tree=null;
        CommonTree char_literal110_tree=null;
        RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
        RewriteRuleTokenStream stream_102=new RewriteRuleTokenStream(adaptor,"token 102");

        try {
            // EolParserRules.g:272:2: ( 'continue' ';' -> ^( CONTINUE ) )
            // EolParserRules.g:272:4: 'continue' ';'
            {
            string_literal109=(Token)match(input,102,FOLLOW_102_in_continueStatement1121); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_102.add(string_literal109);

            char_literal110=(Token)match(input,72,FOLLOW_72_in_continueStatement1123); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_72.add(char_literal110);



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
            // 273:2: -> ^( CONTINUE )
            {
                // EolParserRules.g:273:5: ^( CONTINUE )
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
    // EolParserRules.g:276:1: abortStatement : 'abort' ';' -> ^( ABORT ) ;
    public final Ewl_EolParserRules.abortStatement_return abortStatement() throws RecognitionException {
        Ewl_EolParserRules.abortStatement_return retval = new Ewl_EolParserRules.abortStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal111=null;
        Token char_literal112=null;

        CommonTree string_literal111_tree=null;
        CommonTree char_literal112_tree=null;
        RewriteRuleTokenStream stream_103=new RewriteRuleTokenStream(adaptor,"token 103");
        RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");

        try {
            // EolParserRules.g:277:2: ( 'abort' ';' -> ^( ABORT ) )
            // EolParserRules.g:277:4: 'abort' ';'
            {
            string_literal111=(Token)match(input,103,FOLLOW_103_in_abortStatement1141); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_103.add(string_literal111);

            char_literal112=(Token)match(input,72,FOLLOW_72_in_abortStatement1143); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_72.add(char_literal112);



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
            // 278:2: -> ^( ABORT )
            {
                // EolParserRules.g:278:5: ^( ABORT )
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
    // EolParserRules.g:281:1: transactionStatement : 'transaction' ( NAME ( ',' NAME )* )? statementOrStatementBlock -> ^( TRANSACTION ( NAME )* statementOrStatementBlock ) ;
    public final Ewl_EolParserRules.transactionStatement_return transactionStatement() throws RecognitionException {
        Ewl_EolParserRules.transactionStatement_return retval = new Ewl_EolParserRules.transactionStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal113=null;
        Token NAME114=null;
        Token char_literal115=null;
        Token NAME116=null;
        Ewl_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock117 = null;


        CommonTree string_literal113_tree=null;
        CommonTree NAME114_tree=null;
        CommonTree char_literal115_tree=null;
        CommonTree NAME116_tree=null;
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_104=new RewriteRuleTokenStream(adaptor,"token 104");
        RewriteRuleTokenStream stream_74=new RewriteRuleTokenStream(adaptor,"token 74");
        RewriteRuleSubtreeStream stream_statementOrStatementBlock=new RewriteRuleSubtreeStream(adaptor,"rule statementOrStatementBlock");
        try {
            // EolParserRules.g:282:2: ( 'transaction' ( NAME ( ',' NAME )* )? statementOrStatementBlock -> ^( TRANSACTION ( NAME )* statementOrStatementBlock ) )
            // EolParserRules.g:282:4: 'transaction' ( NAME ( ',' NAME )* )? statementOrStatementBlock
            {
            string_literal113=(Token)match(input,104,FOLLOW_104_in_transactionStatement1161); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_104.add(string_literal113);

            // EolParserRules.g:282:18: ( NAME ( ',' NAME )* )?
            int alt29=2;
            alt29 = dfa29.predict(input);
            switch (alt29) {
                case 1 :
                    // EolParserRules.g:282:19: NAME ( ',' NAME )*
                    {
                    NAME114=(Token)match(input,NAME,FOLLOW_NAME_in_transactionStatement1164); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NAME.add(NAME114);

                    // EolParserRules.g:282:24: ( ',' NAME )*
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( (LA28_0==74) ) {
                            alt28=1;
                        }


                        switch (alt28) {
                    	case 1 :
                    	    // EolParserRules.g:282:25: ',' NAME
                    	    {
                    	    char_literal115=(Token)match(input,74,FOLLOW_74_in_transactionStatement1167); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_74.add(char_literal115);

                    	    NAME116=(Token)match(input,NAME,FOLLOW_NAME_in_transactionStatement1169); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_NAME.add(NAME116);


                    	    }
                    	    break;

                    	default :
                    	    break loop28;
                        }
                    } while (true);


                    }
                    break;

            }

            pushFollow(FOLLOW_statementOrStatementBlock_in_transactionStatement1175);
            statementOrStatementBlock117=statementOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_statementOrStatementBlock.add(statementOrStatementBlock117.getTree());


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
            // 283:2: -> ^( TRANSACTION ( NAME )* statementOrStatementBlock )
            {
                // EolParserRules.g:283:5: ^( TRANSACTION ( NAME )* statementOrStatementBlock )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TRANSACTION, "TRANSACTION"), root_1);

                // EolParserRules.g:283:19: ( NAME )*
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
    // EolParserRules.g:287:1: assignmentStatement : logicalExpression (normal= ':=' | special= '::=' ) logicalExpression ';' ;
    public final Ewl_EolParserRules.assignmentStatement_return assignmentStatement() throws RecognitionException {
        Ewl_EolParserRules.assignmentStatement_return retval = new Ewl_EolParserRules.assignmentStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token normal=null;
        Token special=null;
        Token char_literal120=null;
        Ewl_EolParserRules.logicalExpression_return logicalExpression118 = null;

        Ewl_EolParserRules.logicalExpression_return logicalExpression119 = null;


        CommonTree normal_tree=null;
        CommonTree special_tree=null;
        CommonTree char_literal120_tree=null;

        try {
            // EolParserRules.g:291:2: ( logicalExpression (normal= ':=' | special= '::=' ) logicalExpression ';' )
            // EolParserRules.g:291:4: logicalExpression (normal= ':=' | special= '::=' ) logicalExpression ';'
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_logicalExpression_in_assignmentStatement1204);
            logicalExpression118=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression118.getTree());
            // EolParserRules.g:291:22: (normal= ':=' | special= '::=' )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==105) ) {
                alt30=1;
            }
            else if ( (LA30_0==106) ) {
                alt30=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // EolParserRules.g:291:23: normal= ':='
                    {
                    normal=(Token)match(input,105,FOLLOW_105_in_assignmentStatement1209); if (state.failed) return retval;
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
                    // EolParserRules.g:291:66: special= '::='
                    {
                    special=(Token)match(input,106,FOLLOW_106_in_assignmentStatement1216); if (state.failed) return retval;
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

            pushFollow(FOLLOW_logicalExpression_in_assignmentStatement1222);
            logicalExpression119=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression119.getTree());
            char_literal120=(Token)match(input,72,FOLLOW_72_in_assignmentStatement1224); if (state.failed) return retval;

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
    // EolParserRules.g:295:1: expressionStatement : logicalExpression ';' ;
    public final Ewl_EolParserRules.expressionStatement_return expressionStatement() throws RecognitionException {
        Ewl_EolParserRules.expressionStatement_return retval = new Ewl_EolParserRules.expressionStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal122=null;
        Ewl_EolParserRules.logicalExpression_return logicalExpression121 = null;


        CommonTree char_literal122_tree=null;

        try {
            // EolParserRules.g:296:2: ( logicalExpression ';' )
            // EolParserRules.g:296:4: logicalExpression ';'
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_logicalExpression_in_expressionStatement1239);
            logicalExpression121=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression121.getTree());
            char_literal122=(Token)match(input,72,FOLLOW_72_in_expressionStatement1241); if (state.failed) return retval;

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
    // EolParserRules.g:299:1: logicalExpression : relationalExpression ( ( 'or' | 'and' | 'xor' | 'implies' ) relationalExpression )* ;
    public final Ewl_EolParserRules.logicalExpression_return logicalExpression() throws RecognitionException {
        Ewl_EolParserRules.logicalExpression_return retval = new Ewl_EolParserRules.logicalExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set124=null;
        Ewl_EolParserRules.relationalExpression_return relationalExpression123 = null;

        Ewl_EolParserRules.relationalExpression_return relationalExpression125 = null;


        CommonTree set124_tree=null;

        try {
            // EolParserRules.g:300:2: ( relationalExpression ( ( 'or' | 'and' | 'xor' | 'implies' ) relationalExpression )* )
            // EolParserRules.g:300:4: relationalExpression ( ( 'or' | 'and' | 'xor' | 'implies' ) relationalExpression )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_relationalExpression_in_logicalExpression1253);
            relationalExpression123=relationalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, relationalExpression123.getTree());
            // EolParserRules.g:300:25: ( ( 'or' | 'and' | 'xor' | 'implies' ) relationalExpression )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( ((LA31_0>=107 && LA31_0<=110)) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // EolParserRules.g:300:26: ( 'or' | 'and' | 'xor' | 'implies' ) relationalExpression
            	    {
            	    set124=(Token)input.LT(1);
            	    set124=(Token)input.LT(1);
            	    if ( (input.LA(1)>=107 && input.LA(1)<=110) ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(set124), root_0);
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_relationalExpression_in_logicalExpression1267);
            	    relationalExpression125=relationalExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, relationalExpression125.getTree());
            	    if ( state.backtracking==0 ) {
            	      if (root_0.getToken() != null) root_0.getToken().setType(OPERATOR);
            	    }

            	    }
            	    break;

            	default :
            	    break loop31;
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
    // EolParserRules.g:304:1: relationalExpression : additiveExpression ( ( '=' | '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression )* ;
    public final Ewl_EolParserRules.relationalExpression_return relationalExpression() throws RecognitionException {
        Ewl_EolParserRules.relationalExpression_return retval = new Ewl_EolParserRules.relationalExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set127=null;
        Ewl_EolParserRules.additiveExpression_return additiveExpression126 = null;

        Ewl_EolParserRules.additiveExpression_return additiveExpression128 = null;


        CommonTree set127_tree=null;

        try {
            // EolParserRules.g:305:2: ( additiveExpression ( ( '=' | '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression )* )
            // EolParserRules.g:305:4: additiveExpression ( ( '=' | '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_additiveExpression_in_relationalExpression1284);
            additiveExpression126=additiveExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, additiveExpression126.getTree());
            // EolParserRules.g:305:23: ( ( '=' | '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( ((LA32_0>=111 && LA32_0<=116)) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // EolParserRules.g:305:24: ( '=' | '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression
            	    {
            	    set127=(Token)input.LT(1);
            	    set127=(Token)input.LT(1);
            	    if ( (input.LA(1)>=111 && input.LA(1)<=116) ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(set127), root_0);
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_additiveExpression_in_relationalExpression1302);
            	    additiveExpression128=additiveExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, additiveExpression128.getTree());
            	    if ( state.backtracking==0 ) {
            	      if (root_0.getToken() != null) root_0.getToken().setType(OPERATOR);
            	    }

            	    }
            	    break;

            	default :
            	    break loop32;
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
    // EolParserRules.g:309:1: additiveExpression : multiplicativeExpression ( ( '+' | '-' ) multiplicativeExpression )* ;
    public final Ewl_EolParserRules.additiveExpression_return additiveExpression() throws RecognitionException {
        Ewl_EolParserRules.additiveExpression_return retval = new Ewl_EolParserRules.additiveExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set130=null;
        Ewl_EolParserRules.multiplicativeExpression_return multiplicativeExpression129 = null;

        Ewl_EolParserRules.multiplicativeExpression_return multiplicativeExpression131 = null;


        CommonTree set130_tree=null;

        try {
            // EolParserRules.g:310:2: ( multiplicativeExpression ( ( '+' | '-' ) multiplicativeExpression )* )
            // EolParserRules.g:310:4: multiplicativeExpression ( ( '+' | '-' ) multiplicativeExpression )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_multiplicativeExpression_in_additiveExpression1319);
            multiplicativeExpression129=multiplicativeExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, multiplicativeExpression129.getTree());
            // EolParserRules.g:310:29: ( ( '+' | '-' ) multiplicativeExpression )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( ((LA33_0>=117 && LA33_0<=118)) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // EolParserRules.g:310:30: ( '+' | '-' ) multiplicativeExpression
            	    {
            	    set130=(Token)input.LT(1);
            	    set130=(Token)input.LT(1);
            	    if ( (input.LA(1)>=117 && input.LA(1)<=118) ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(set130), root_0);
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_multiplicativeExpression_in_additiveExpression1329);
            	    multiplicativeExpression131=multiplicativeExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, multiplicativeExpression131.getTree());
            	    if ( state.backtracking==0 ) {
            	      if (root_0.getToken() != null) root_0.getToken().setType(OPERATOR);
            	    }

            	    }
            	    break;

            	default :
            	    break loop33;
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
    // EolParserRules.g:315:1: multiplicativeExpression : unaryExpression ( ( '*' | '/' ) unaryExpression )* ;
    public final Ewl_EolParserRules.multiplicativeExpression_return multiplicativeExpression() throws RecognitionException {
        Ewl_EolParserRules.multiplicativeExpression_return retval = new Ewl_EolParserRules.multiplicativeExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set133=null;
        Ewl_EolParserRules.unaryExpression_return unaryExpression132 = null;

        Ewl_EolParserRules.unaryExpression_return unaryExpression134 = null;


        CommonTree set133_tree=null;

        try {
            // EolParserRules.g:316:2: ( unaryExpression ( ( '*' | '/' ) unaryExpression )* )
            // EolParserRules.g:316:4: unaryExpression ( ( '*' | '/' ) unaryExpression )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_unaryExpression_in_multiplicativeExpression1350);
            unaryExpression132=unaryExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, unaryExpression132.getTree());
            // EolParserRules.g:316:20: ( ( '*' | '/' ) unaryExpression )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( ((LA34_0>=119 && LA34_0<=120)) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // EolParserRules.g:316:21: ( '*' | '/' ) unaryExpression
            	    {
            	    set133=(Token)input.LT(1);
            	    set133=(Token)input.LT(1);
            	    if ( (input.LA(1)>=119 && input.LA(1)<=120) ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(set133), root_0);
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_unaryExpression_in_multiplicativeExpression1360);
            	    unaryExpression134=unaryExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, unaryExpression134.getTree());
            	    if ( state.backtracking==0 ) {
            	      if (root_0.getToken() != null) root_0.getToken().setType(OPERATOR);
            	    }

            	    }
            	    break;

            	default :
            	    break loop34;
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
    // EolParserRules.g:320:1: unaryExpression : ( ( 'not' | '-' ) )? postfixExpression ;
    public final Ewl_EolParserRules.unaryExpression_return unaryExpression() throws RecognitionException {
        Ewl_EolParserRules.unaryExpression_return retval = new Ewl_EolParserRules.unaryExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set135=null;
        Ewl_EolParserRules.postfixExpression_return postfixExpression136 = null;


        CommonTree set135_tree=null;

        try {
            // EolParserRules.g:321:2: ( ( ( 'not' | '-' ) )? postfixExpression )
            // EolParserRules.g:321:4: ( ( 'not' | '-' ) )? postfixExpression
            {
            root_0 = (CommonTree)adaptor.nil();

            // EolParserRules.g:321:4: ( ( 'not' | '-' ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==118||LA35_0==121) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // EolParserRules.g:321:5: ( 'not' | '-' )
                    {
                    set135=(Token)input.LT(1);
                    set135=(Token)input.LT(1);
                    if ( input.LA(1)==118||input.LA(1)==121 ) {
                        input.consume();
                        if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(set135), root_0);
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

            pushFollow(FOLLOW_postfixExpression_in_unaryExpression1387);
            postfixExpression136=postfixExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, postfixExpression136.getTree());
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
    // EolParserRules.g:325:1: postfixExpression : primitiveExpression ( ( POINT | ARROW ) fc= featureCall )* ;
    public final Ewl_EolParserRules.postfixExpression_return postfixExpression() throws RecognitionException {
        Ewl_EolParserRules.postfixExpression_return retval = new Ewl_EolParserRules.postfixExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set138=null;
        Ewl_EolParserRules.featureCall_return fc = null;

        Ewl_EolParserRules.primitiveExpression_return primitiveExpression137 = null;


        CommonTree set138_tree=null;

        try {
            // EolParserRules.g:326:2: ( primitiveExpression ( ( POINT | ARROW ) fc= featureCall )* )
            // EolParserRules.g:326:4: primitiveExpression ( ( POINT | ARROW ) fc= featureCall )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_primitiveExpression_in_postfixExpression1402);
            primitiveExpression137=primitiveExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, primitiveExpression137.getTree());
            // EolParserRules.g:326:23: ( ( POINT | ARROW ) fc= featureCall )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==POINT||LA36_0==ARROW) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // EolParserRules.g:326:24: ( POINT | ARROW ) fc= featureCall
            	    {
            	    set138=(Token)input.LT(1);
            	    set138=(Token)input.LT(1);
            	    if ( input.LA(1)==POINT||input.LA(1)==ARROW ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(set138), root_0);
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_featureCall_in_postfixExpression1413);
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
            	    break loop36;
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
    // EolParserRules.g:336:1: featureCall : ( simpleFeatureCall | declarativeFeatureCall );
    public final Ewl_EolParserRules.featureCall_return featureCall() throws RecognitionException {
        Ewl_EolParserRules.featureCall_return retval = new Ewl_EolParserRules.featureCall_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Ewl_EolParserRules.simpleFeatureCall_return simpleFeatureCall139 = null;

        Ewl_EolParserRules.declarativeFeatureCall_return declarativeFeatureCall140 = null;



        try {
            // EolParserRules.g:337:2: ( simpleFeatureCall | declarativeFeatureCall )
            int alt37=2;
            alt37 = dfa37.predict(input);
            switch (alt37) {
                case 1 :
                    // EolParserRules.g:337:4: simpleFeatureCall
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_simpleFeatureCall_in_featureCall1448);
                    simpleFeatureCall139=simpleFeatureCall();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, simpleFeatureCall139.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:337:24: declarativeFeatureCall
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_declarativeFeatureCall_in_featureCall1452);
                    declarativeFeatureCall140=declarativeFeatureCall();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, declarativeFeatureCall140.getTree());

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
    // EolParserRules.g:340:1: simpleFeatureCall : NAME ( parameterList )? ;
    public final Ewl_EolParserRules.simpleFeatureCall_return simpleFeatureCall() throws RecognitionException {
        Ewl_EolParserRules.simpleFeatureCall_return retval = new Ewl_EolParserRules.simpleFeatureCall_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NAME141=null;
        Ewl_EolParserRules.parameterList_return parameterList142 = null;


        CommonTree NAME141_tree=null;

        try {
            // EolParserRules.g:341:2: ( NAME ( parameterList )? )
            // EolParserRules.g:341:5: NAME ( parameterList )?
            {
            root_0 = (CommonTree)adaptor.nil();

            NAME141=(Token)match(input,NAME,FOLLOW_NAME_in_simpleFeatureCall1464); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME141_tree = (CommonTree)adaptor.create(NAME141);
            root_0 = (CommonTree)adaptor.becomeRoot(NAME141_tree, root_0);
            }
            // EolParserRules.g:341:11: ( parameterList )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==77) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // EolParserRules.g:0:0: parameterList
                    {
                    pushFollow(FOLLOW_parameterList_in_simpleFeatureCall1467);
                    parameterList142=parameterList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, parameterList142.getTree());

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
    // EolParserRules.g:345:1: parameterList : '(' ( logicalExpression ( ',' logicalExpression )* )? ')' -> ^( PARAMETERS ( logicalExpression )* ) ;
    public final Ewl_EolParserRules.parameterList_return parameterList() throws RecognitionException {
        Ewl_EolParserRules.parameterList_return retval = new Ewl_EolParserRules.parameterList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal143=null;
        Token char_literal145=null;
        Token char_literal147=null;
        Ewl_EolParserRules.logicalExpression_return logicalExpression144 = null;

        Ewl_EolParserRules.logicalExpression_return logicalExpression146 = null;


        CommonTree char_literal143_tree=null;
        CommonTree char_literal145_tree=null;
        CommonTree char_literal147_tree=null;
        RewriteRuleTokenStream stream_78=new RewriteRuleTokenStream(adaptor,"token 78");
        RewriteRuleTokenStream stream_77=new RewriteRuleTokenStream(adaptor,"token 77");
        RewriteRuleTokenStream stream_74=new RewriteRuleTokenStream(adaptor,"token 74");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:346:2: ( '(' ( logicalExpression ( ',' logicalExpression )* )? ')' -> ^( PARAMETERS ( logicalExpression )* ) )
            // EolParserRules.g:346:4: '(' ( logicalExpression ( ',' logicalExpression )* )? ')'
            {
            char_literal143=(Token)match(input,77,FOLLOW_77_in_parameterList1482); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_77.add(char_literal143);

            // EolParserRules.g:346:8: ( logicalExpression ( ',' logicalExpression )* )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==FLOAT||LA40_0==INT||LA40_0==BOOLEAN||LA40_0==STRING||LA40_0==NAME||LA40_0==77||(LA40_0>=86 && LA40_0<=91)||LA40_0==118||LA40_0==121||(LA40_0>=123 && LA40_0<=124)) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // EolParserRules.g:346:9: logicalExpression ( ',' logicalExpression )*
                    {
                    pushFollow(FOLLOW_logicalExpression_in_parameterList1485);
                    logicalExpression144=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression144.getTree());
                    // EolParserRules.g:346:27: ( ',' logicalExpression )*
                    loop39:
                    do {
                        int alt39=2;
                        int LA39_0 = input.LA(1);

                        if ( (LA39_0==74) ) {
                            alt39=1;
                        }


                        switch (alt39) {
                    	case 1 :
                    	    // EolParserRules.g:346:28: ',' logicalExpression
                    	    {
                    	    char_literal145=(Token)match(input,74,FOLLOW_74_in_parameterList1488); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_74.add(char_literal145);

                    	    pushFollow(FOLLOW_logicalExpression_in_parameterList1490);
                    	    logicalExpression146=logicalExpression();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression146.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop39;
                        }
                    } while (true);


                    }
                    break;

            }

            char_literal147=(Token)match(input,78,FOLLOW_78_in_parameterList1496); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_78.add(char_literal147);



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
            // 347:3: -> ^( PARAMETERS ( logicalExpression )* )
            {
                // EolParserRules.g:347:6: ^( PARAMETERS ( logicalExpression )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PARAMETERS, "PARAMETERS"), root_1);

                // EolParserRules.g:347:19: ( logicalExpression )*
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
    // EolParserRules.g:350:1: declarativeFeatureCall : NAME '(' formalParameterList '|' logicalExpression ')' ;
    public final Ewl_EolParserRules.declarativeFeatureCall_return declarativeFeatureCall() throws RecognitionException {
        Ewl_EolParserRules.declarativeFeatureCall_return retval = new Ewl_EolParserRules.declarativeFeatureCall_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NAME148=null;
        Token char_literal149=null;
        Token char_literal151=null;
        Token char_literal153=null;
        Ewl_EolParserRules.formalParameterList_return formalParameterList150 = null;

        Ewl_EolParserRules.logicalExpression_return logicalExpression152 = null;


        CommonTree NAME148_tree=null;
        CommonTree char_literal149_tree=null;
        CommonTree char_literal151_tree=null;
        CommonTree char_literal153_tree=null;

        try {
            // EolParserRules.g:351:2: ( NAME '(' formalParameterList '|' logicalExpression ')' )
            // EolParserRules.g:351:4: NAME '(' formalParameterList '|' logicalExpression ')'
            {
            root_0 = (CommonTree)adaptor.nil();

            NAME148=(Token)match(input,NAME,FOLLOW_NAME_in_declarativeFeatureCall1518); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME148_tree = (CommonTree)adaptor.create(NAME148);
            root_0 = (CommonTree)adaptor.becomeRoot(NAME148_tree, root_0);
            }
            char_literal149=(Token)match(input,77,FOLLOW_77_in_declarativeFeatureCall1521); if (state.failed) return retval;
            pushFollow(FOLLOW_formalParameterList_in_declarativeFeatureCall1524);
            formalParameterList150=formalParameterList();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, formalParameterList150.getTree());
            char_literal151=(Token)match(input,122,FOLLOW_122_in_declarativeFeatureCall1526); if (state.failed) return retval;
            pushFollow(FOLLOW_logicalExpression_in_declarativeFeatureCall1529);
            logicalExpression152=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression152.getTree());
            char_literal153=(Token)match(input,78,FOLLOW_78_in_declarativeFeatureCall1531); if (state.failed) return retval;

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
    // EolParserRules.g:354:1: newExpression : 'new' tn= typeName ( parameterList )? ;
    public final Ewl_EolParserRules.newExpression_return newExpression() throws RecognitionException {
        Ewl_EolParserRules.newExpression_return retval = new Ewl_EolParserRules.newExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal154=null;
        Ewl_EolParserRules.typeName_return tn = null;

        Ewl_EolParserRules.parameterList_return parameterList155 = null;


        CommonTree string_literal154_tree=null;

        try {
            // EolParserRules.g:355:2: ( 'new' tn= typeName ( parameterList )? )
            // EolParserRules.g:355:4: 'new' tn= typeName ( parameterList )?
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal154=(Token)match(input,123,FOLLOW_123_in_newExpression1543); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal154_tree = (CommonTree)adaptor.create(string_literal154);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal154_tree, root_0);
            }
            pushFollow(FOLLOW_typeName_in_newExpression1548);
            tn=typeName();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, tn.getTree());
            if ( state.backtracking==0 ) {
              setTokenType(tn,TYPE);
            }
            // EolParserRules.g:355:48: ( parameterList )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==77) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // EolParserRules.g:0:0: parameterList
                    {
                    pushFollow(FOLLOW_parameterList_in_newExpression1552);
                    parameterList155=parameterList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, parameterList155.getTree());

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
    // EolParserRules.g:361:1: variableDeclarationExpression : 'var' NAME ( ':' (n= 'new' )? t= typeName ( parameterList )? )? -> ^( VAR NAME ( typeName )? ( parameterList )? ) ;
    public final Ewl_EolParserRules.variableDeclarationExpression_return variableDeclarationExpression() throws RecognitionException {
        Ewl_EolParserRules.variableDeclarationExpression_return retval = new Ewl_EolParserRules.variableDeclarationExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token n=null;
        Token string_literal156=null;
        Token NAME157=null;
        Token char_literal158=null;
        Ewl_EolParserRules.typeName_return t = null;

        Ewl_EolParserRules.parameterList_return parameterList159 = null;


        CommonTree n_tree=null;
        CommonTree string_literal156_tree=null;
        CommonTree NAME157_tree=null;
        CommonTree char_literal158_tree=null;
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_123=new RewriteRuleTokenStream(adaptor,"token 123");
        RewriteRuleTokenStream stream_124=new RewriteRuleTokenStream(adaptor,"token 124");
        RewriteRuleTokenStream stream_73=new RewriteRuleTokenStream(adaptor,"token 73");
        RewriteRuleSubtreeStream stream_typeName=new RewriteRuleSubtreeStream(adaptor,"rule typeName");
        RewriteRuleSubtreeStream stream_parameterList=new RewriteRuleSubtreeStream(adaptor,"rule parameterList");
        try {
            // EolParserRules.g:369:2: ( 'var' NAME ( ':' (n= 'new' )? t= typeName ( parameterList )? )? -> ^( VAR NAME ( typeName )? ( parameterList )? ) )
            // EolParserRules.g:369:4: 'var' NAME ( ':' (n= 'new' )? t= typeName ( parameterList )? )?
            {
            string_literal156=(Token)match(input,124,FOLLOW_124_in_variableDeclarationExpression1577); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_124.add(string_literal156);

            NAME157=(Token)match(input,NAME,FOLLOW_NAME_in_variableDeclarationExpression1579); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(NAME157);

            // EolParserRules.g:369:15: ( ':' (n= 'new' )? t= typeName ( parameterList )? )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==73) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // EolParserRules.g:369:16: ':' (n= 'new' )? t= typeName ( parameterList )?
                    {
                    char_literal158=(Token)match(input,73,FOLLOW_73_in_variableDeclarationExpression1582); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_73.add(char_literal158);

                    // EolParserRules.g:369:21: (n= 'new' )?
                    int alt42=2;
                    int LA42_0 = input.LA(1);

                    if ( (LA42_0==123) ) {
                        alt42=1;
                    }
                    switch (alt42) {
                        case 1 :
                            // EolParserRules.g:0:0: n= 'new'
                            {
                            n=(Token)match(input,123,FOLLOW_123_in_variableDeclarationExpression1586); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_123.add(n);


                            }
                            break;

                    }

                    pushFollow(FOLLOW_typeName_in_variableDeclarationExpression1591);
                    t=typeName();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_typeName.add(t.getTree());
                    if ( state.backtracking==0 ) {
                      setTokenType(t, TYPE);
                    }
                    // EolParserRules.g:369:65: ( parameterList )?
                    int alt43=2;
                    int LA43_0 = input.LA(1);

                    if ( (LA43_0==77) ) {
                        alt43=1;
                    }
                    switch (alt43) {
                        case 1 :
                            // EolParserRules.g:0:0: parameterList
                            {
                            pushFollow(FOLLOW_parameterList_in_variableDeclarationExpression1595);
                            parameterList159=parameterList();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_parameterList.add(parameterList159.getTree());

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
            // 370:2: -> ^( VAR NAME ( typeName )? ( parameterList )? )
            {
                // EolParserRules.g:370:5: ^( VAR NAME ( typeName )? ( parameterList )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VAR, "VAR"), root_1);

                adaptor.addChild(root_1, stream_NAME.nextNode());
                // EolParserRules.g:370:16: ( typeName )?
                if ( stream_typeName.hasNext() ) {
                    adaptor.addChild(root_1, stream_typeName.nextTree());

                }
                stream_typeName.reset();
                // EolParserRules.g:370:26: ( parameterList )?
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
    // EolParserRules.g:373:1: litteralCollection : ( 'Collection' | 'Sequence' | 'Bag' | 'Set' | 'OrderedSet' ) '{' ( expressionListOrRange )? '}' ;
    public final Ewl_EolParserRules.litteralCollection_return litteralCollection() throws RecognitionException {
        Ewl_EolParserRules.litteralCollection_return retval = new Ewl_EolParserRules.litteralCollection_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set160=null;
        Token char_literal161=null;
        Token char_literal163=null;
        Ewl_EolParserRules.expressionListOrRange_return expressionListOrRange162 = null;


        CommonTree set160_tree=null;
        CommonTree char_literal161_tree=null;
        CommonTree char_literal163_tree=null;

        try {
            // EolParserRules.g:374:2: ( ( 'Collection' | 'Sequence' | 'Bag' | 'Set' | 'OrderedSet' ) '{' ( expressionListOrRange )? '}' )
            // EolParserRules.g:374:4: ( 'Collection' | 'Sequence' | 'Bag' | 'Set' | 'OrderedSet' ) '{' ( expressionListOrRange )? '}'
            {
            root_0 = (CommonTree)adaptor.nil();

            set160=(Token)input.LT(1);
            set160=(Token)input.LT(1);
            if ( (input.LA(1)>=87 && input.LA(1)<=91) ) {
                input.consume();
                if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(set160), root_0);
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            char_literal161=(Token)match(input,80,FOLLOW_80_in_litteralCollection1638); if (state.failed) return retval;
            // EolParserRules.g:374:62: ( expressionListOrRange )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==FLOAT||LA45_0==INT||LA45_0==BOOLEAN||LA45_0==STRING||LA45_0==NAME||LA45_0==77||(LA45_0>=86 && LA45_0<=91)||LA45_0==118||LA45_0==121||(LA45_0>=123 && LA45_0<=124)) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // EolParserRules.g:0:0: expressionListOrRange
                    {
                    pushFollow(FOLLOW_expressionListOrRange_in_litteralCollection1642);
                    expressionListOrRange162=expressionListOrRange();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionListOrRange162.getTree());

                    }
                    break;

            }

            char_literal163=(Token)match(input,81,FOLLOW_81_in_litteralCollection1645); if (state.failed) return retval;
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
    // EolParserRules.g:378:1: expressionRange : logicalExpression '..' logicalExpression -> ^( EXPRRANGE ( logicalExpression )+ ) ;
    public final Ewl_EolParserRules.expressionRange_return expressionRange() throws RecognitionException {
        Ewl_EolParserRules.expressionRange_return retval = new Ewl_EolParserRules.expressionRange_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal165=null;
        Ewl_EolParserRules.logicalExpression_return logicalExpression164 = null;

        Ewl_EolParserRules.logicalExpression_return logicalExpression166 = null;


        CommonTree string_literal165_tree=null;
        RewriteRuleTokenStream stream_POINT_POINT=new RewriteRuleTokenStream(adaptor,"token POINT_POINT");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:379:2: ( logicalExpression '..' logicalExpression -> ^( EXPRRANGE ( logicalExpression )+ ) )
            // EolParserRules.g:379:4: logicalExpression '..' logicalExpression
            {
            pushFollow(FOLLOW_logicalExpression_in_expressionRange1660);
            logicalExpression164=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression164.getTree());
            string_literal165=(Token)match(input,POINT_POINT,FOLLOW_POINT_POINT_in_expressionRange1662); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_POINT_POINT.add(string_literal165);

            pushFollow(FOLLOW_logicalExpression_in_expressionRange1664);
            logicalExpression166=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression166.getTree());


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
            // 380:2: -> ^( EXPRRANGE ( logicalExpression )+ )
            {
                // EolParserRules.g:380:5: ^( EXPRRANGE ( logicalExpression )+ )
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
    // EolParserRules.g:383:1: expressionList : logicalExpression ( ',' logicalExpression )* -> ^( EXPRLIST ( logicalExpression )+ ) ;
    public final Ewl_EolParserRules.expressionList_return expressionList() throws RecognitionException {
        Ewl_EolParserRules.expressionList_return retval = new Ewl_EolParserRules.expressionList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal168=null;
        Ewl_EolParserRules.logicalExpression_return logicalExpression167 = null;

        Ewl_EolParserRules.logicalExpression_return logicalExpression169 = null;


        CommonTree char_literal168_tree=null;
        RewriteRuleTokenStream stream_74=new RewriteRuleTokenStream(adaptor,"token 74");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:384:2: ( logicalExpression ( ',' logicalExpression )* -> ^( EXPRLIST ( logicalExpression )+ ) )
            // EolParserRules.g:384:4: logicalExpression ( ',' logicalExpression )*
            {
            pushFollow(FOLLOW_logicalExpression_in_expressionList1686);
            logicalExpression167=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression167.getTree());
            // EolParserRules.g:384:22: ( ',' logicalExpression )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==74) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // EolParserRules.g:384:23: ',' logicalExpression
            	    {
            	    char_literal168=(Token)match(input,74,FOLLOW_74_in_expressionList1689); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_74.add(char_literal168);

            	    pushFollow(FOLLOW_logicalExpression_in_expressionList1691);
            	    logicalExpression169=logicalExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression169.getTree());

            	    }
            	    break;

            	default :
            	    break loop46;
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
            // 385:2: -> ^( EXPRLIST ( logicalExpression )+ )
            {
                // EolParserRules.g:385:5: ^( EXPRLIST ( logicalExpression )+ )
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
    // EolParserRules.g:388:1: expressionListOrRange : ( expressionRange | expressionList );
    public final Ewl_EolParserRules.expressionListOrRange_return expressionListOrRange() throws RecognitionException {
        Ewl_EolParserRules.expressionListOrRange_return retval = new Ewl_EolParserRules.expressionListOrRange_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Ewl_EolParserRules.expressionRange_return expressionRange170 = null;

        Ewl_EolParserRules.expressionList_return expressionList171 = null;



        try {
            // EolParserRules.g:389:2: ( expressionRange | expressionList )
            int alt47=2;
            alt47 = dfa47.predict(input);
            switch (alt47) {
                case 1 :
                    // EolParserRules.g:389:4: expressionRange
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_expressionRange_in_expressionListOrRange1715);
                    expressionRange170=expressionRange();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionRange170.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:389:22: expressionList
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_expressionList_in_expressionListOrRange1719);
                    expressionList171=expressionList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionList171.getTree());

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
    // EolParserRules.g:397:1: primitiveExpression : ( litteralCollection | literal | featureCall | pathName | nativeType | collectionType | '(' logicalExpression ')' | newExpression | variableDeclarationExpression );
    public final Ewl_EolParserRules.primitiveExpression_return primitiveExpression() throws RecognitionException {
        Ewl_EolParserRules.primitiveExpression_return retval = new Ewl_EolParserRules.primitiveExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal178=null;
        Token char_literal180=null;
        Ewl_EolParserRules.litteralCollection_return litteralCollection172 = null;

        Ewl_EolParserRules.literal_return literal173 = null;

        Ewl_EolParserRules.featureCall_return featureCall174 = null;

        Ewl_EolParserRules.pathName_return pathName175 = null;

        Ewl_EolParserRules.nativeType_return nativeType176 = null;

        Ewl_EolParserRules.collectionType_return collectionType177 = null;

        Ewl_EolParserRules.logicalExpression_return logicalExpression179 = null;

        Ewl_EolParserRules.newExpression_return newExpression181 = null;

        Ewl_EolParserRules.variableDeclarationExpression_return variableDeclarationExpression182 = null;


        CommonTree char_literal178_tree=null;
        CommonTree char_literal180_tree=null;

        try {
            // EolParserRules.g:398:2: ( litteralCollection | literal | featureCall | pathName | nativeType | collectionType | '(' logicalExpression ')' | newExpression | variableDeclarationExpression )
            int alt48=9;
            alt48 = dfa48.predict(input);
            switch (alt48) {
                case 1 :
                    // EolParserRules.g:398:4: litteralCollection
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_litteralCollection_in_primitiveExpression1741);
                    litteralCollection172=litteralCollection();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, litteralCollection172.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:398:25: literal
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_literal_in_primitiveExpression1745);
                    literal173=literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, literal173.getTree());

                    }
                    break;
                case 3 :
                    // EolParserRules.g:398:35: featureCall
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_featureCall_in_primitiveExpression1749);
                    featureCall174=featureCall();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, featureCall174.getTree());

                    }
                    break;
                case 4 :
                    // EolParserRules.g:398:49: pathName
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_pathName_in_primitiveExpression1753);
                    pathName175=pathName();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pathName175.getTree());

                    }
                    break;
                case 5 :
                    // EolParserRules.g:398:60: nativeType
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_nativeType_in_primitiveExpression1757);
                    nativeType176=nativeType();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nativeType176.getTree());

                    }
                    break;
                case 6 :
                    // EolParserRules.g:399:5: collectionType
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_collectionType_in_primitiveExpression1763);
                    collectionType177=collectionType();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, collectionType177.getTree());

                    }
                    break;
                case 7 :
                    // EolParserRules.g:399:23: '(' logicalExpression ')'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    char_literal178=(Token)match(input,77,FOLLOW_77_in_primitiveExpression1768); if (state.failed) return retval;
                    pushFollow(FOLLOW_logicalExpression_in_primitiveExpression1771);
                    logicalExpression179=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression179.getTree());
                    char_literal180=(Token)match(input,78,FOLLOW_78_in_primitiveExpression1773); if (state.failed) return retval;

                    }
                    break;
                case 8 :
                    // EolParserRules.g:400:5: newExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_newExpression_in_primitiveExpression1781);
                    newExpression181=newExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, newExpression181.getTree());

                    }
                    break;
                case 9 :
                    // EolParserRules.g:400:21: variableDeclarationExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_variableDeclarationExpression_in_primitiveExpression1785);
                    variableDeclarationExpression182=variableDeclarationExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, variableDeclarationExpression182.getTree());

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
    // EolParserRules.g:403:1: literal : ( STRING | INT | FLOAT | BOOLEAN );
    public final Ewl_EolParserRules.literal_return literal() throws RecognitionException {
        Ewl_EolParserRules.literal_return retval = new Ewl_EolParserRules.literal_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set183=null;

        CommonTree set183_tree=null;

        try {
            // EolParserRules.g:404:2: ( STRING | INT | FLOAT | BOOLEAN )
            // EolParserRules.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set183=(Token)input.LT(1);
            if ( input.LA(1)==FLOAT||input.LA(1)==INT||input.LA(1)==BOOLEAN||input.LA(1)==STRING ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set183));
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

    // $ANTLR start synpred13_EolParserRules
    public final void synpred13_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:153:4: ( annotation )
        // EolParserRules.g:153:4: annotation
        {
        pushFollow(FOLLOW_annotation_in_synpred13_EolParserRules558);
        annotation();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred13_EolParserRules

    // $ANTLR start synpred23_EolParserRules
    public final void synpred23_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:198:4: ( '(' typeName ')' )
        // EolParserRules.g:198:4: '(' typeName ')'
        {
        match(input,77,FOLLOW_77_in_synpred23_EolParserRules728); if (state.failed) return ;
        pushFollow(FOLLOW_typeName_in_synpred23_EolParserRules733);
        typeName();

        state._fsp--;
        if (state.failed) return ;
        match(input,78,FOLLOW_78_in_synpred23_EolParserRules736); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred23_EolParserRules

    // $ANTLR start synpred24_EolParserRules
    public final void synpred24_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:205:4: ( statementA )
        // EolParserRules.g:205:4: statementA
        {
        pushFollow(FOLLOW_statementA_in_synpred24_EolParserRules759);
        statementA();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred24_EolParserRules

    // $ANTLR start synpred25_EolParserRules
    public final void synpred25_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:209:3: ( assignmentStatement )
        // EolParserRules.g:209:3: assignmentStatement
        {
        pushFollow(FOLLOW_assignmentStatement_in_synpred25_EolParserRules773);
        assignmentStatement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred25_EolParserRules

    // $ANTLR start synpred26_EolParserRules
    public final void synpred26_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:209:25: ( expressionStatement )
        // EolParserRules.g:209:25: expressionStatement
        {
        pushFollow(FOLLOW_expressionStatement_in_synpred26_EolParserRules777);
        expressionStatement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred26_EolParserRules

    // $ANTLR start synpred39_EolParserRules
    public final void synpred39_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:232:61: ( elseStatement )
        // EolParserRules.g:232:61: elseStatement
        {
        pushFollow(FOLLOW_elseStatement_in_synpred39_EolParserRules927);
        elseStatement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred39_EolParserRules

    // $ANTLR start synpred44_EolParserRules
    public final void synpred44_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:282:19: ( NAME ( ',' NAME )* )
        // EolParserRules.g:282:19: NAME ( ',' NAME )*
        {
        match(input,NAME,FOLLOW_NAME_in_synpred44_EolParserRules1164); if (state.failed) return ;
        // EolParserRules.g:282:24: ( ',' NAME )*
        loop49:
        do {
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==74) ) {
                alt49=1;
            }


            switch (alt49) {
        	case 1 :
        	    // EolParserRules.g:282:25: ',' NAME
        	    {
        	    match(input,74,FOLLOW_74_in_synpred44_EolParserRules1167); if (state.failed) return ;
        	    match(input,NAME,FOLLOW_NAME_in_synpred44_EolParserRules1169); if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop49;
            }
        } while (true);


        }
    }
    // $ANTLR end synpred44_EolParserRules

    // $ANTLR start synpred78_EolParserRules
    public final void synpred78_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:389:4: ( expressionRange )
        // EolParserRules.g:389:4: expressionRange
        {
        pushFollow(FOLLOW_expressionRange_in_synpred78_EolParserRules1715);
        expressionRange();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred78_EolParserRules

    // $ANTLR start synpred81_EolParserRules
    public final void synpred81_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:398:35: ( featureCall )
        // EolParserRules.g:398:35: featureCall
        {
        pushFollow(FOLLOW_featureCall_in_synpred81_EolParserRules1749);
        featureCall();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred81_EolParserRules

    // $ANTLR start synpred82_EolParserRules
    public final void synpred82_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:398:49: ( pathName )
        // EolParserRules.g:398:49: pathName
        {
        pushFollow(FOLLOW_pathName_in_synpred82_EolParserRules1753);
        pathName();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred82_EolParserRules

    // Delegated rules

    public final boolean synpred81_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred81_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred44_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred44_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred82_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred82_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred26_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred26_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred78_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred78_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred23_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred23_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred24_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred24_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred25_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred25_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred39_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred39_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred13_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred13_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA18 dfa18 = new DFA18(this);
    protected DFA19 dfa19 = new DFA19(this);
    protected DFA20 dfa20 = new DFA20(this);
    protected DFA29 dfa29 = new DFA29(this);
    protected DFA37 dfa37 = new DFA37(this);
    protected DFA47 dfa47 = new DFA47(this);
    protected DFA48 dfa48 = new DFA48(this);
    static final String DFA18_eotS =
        "\32\uffff";
    static final String DFA18_eofS =
        "\1\2\31\uffff";
    static final String DFA18_minS =
        "\1\7\1\0\30\uffff";
    static final String DFA18_maxS =
        "\1\u0083\1\0\30\uffff";
    static final String DFA18_acceptS =
        "\2\uffff\1\2\26\uffff\1\1";
    static final String DFA18_specialS =
        "\1\uffff\1\0\30\uffff}>";
    static final String[] DFA18_transitionS = {
            "\3\2\6\uffff\1\2\3\uffff\1\2\63\uffff\1\2\1\uffff\1\2\1\uffff"+
            "\1\2\1\1\1\2\1\uffff\3\2\12\uffff\1\2\13\uffff\20\2\1\uffff"+
            "\1\2\6\uffff\3\2",
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
            ""
    };

    static final short[] DFA18_eot = DFA.unpackEncodedString(DFA18_eotS);
    static final short[] DFA18_eof = DFA.unpackEncodedString(DFA18_eofS);
    static final char[] DFA18_min = DFA.unpackEncodedStringToUnsignedChars(DFA18_minS);
    static final char[] DFA18_max = DFA.unpackEncodedStringToUnsignedChars(DFA18_maxS);
    static final short[] DFA18_accept = DFA.unpackEncodedString(DFA18_acceptS);
    static final short[] DFA18_special = DFA.unpackEncodedString(DFA18_specialS);
    static final short[][] DFA18_transition;

    static {
        int numStates = DFA18_transitionS.length;
        DFA18_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA18_transition[i] = DFA.unpackEncodedString(DFA18_transitionS[i]);
        }
    }

    class DFA18 extends DFA {

        public DFA18(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 18;
            this.eot = DFA18_eot;
            this.eof = DFA18_eof;
            this.min = DFA18_min;
            this.max = DFA18_max;
            this.accept = DFA18_accept;
            this.special = DFA18_special;
            this.transition = DFA18_transition;
        }
        public String getDescription() {
            return "198:3: ( '(' tn= typeName ')' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA18_1 = input.LA(1);

                         
                        int index18_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_EolParserRules()) ) {s = 25;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index18_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 18, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA19_eotS =
        "\24\uffff";
    static final String DFA19_eofS =
        "\24\uffff";
    static final String DFA19_minS =
        "\1\4\13\uffff\1\0\7\uffff";
    static final String DFA19_maxS =
        "\1\174\13\uffff\1\0\7\uffff";
    static final String DFA19_acceptS =
        "\1\uffff\1\1\14\uffff\1\2\5\uffff";
    static final String DFA19_specialS =
        "\14\uffff\1\0\7\uffff}>";
    static final String[] DFA19_transitionS = {
            "\1\1\1\uffff\1\1\3\uffff\1\1\1\uffff\1\1\3\uffff\1\1\74\uffff"+
            "\1\1\10\uffff\7\1\1\uffff\1\1\1\uffff\1\1\1\14\2\16\1\1\4\16"+
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

    static final short[] DFA19_eot = DFA.unpackEncodedString(DFA19_eotS);
    static final short[] DFA19_eof = DFA.unpackEncodedString(DFA19_eofS);
    static final char[] DFA19_min = DFA.unpackEncodedStringToUnsignedChars(DFA19_minS);
    static final char[] DFA19_max = DFA.unpackEncodedStringToUnsignedChars(DFA19_maxS);
    static final short[] DFA19_accept = DFA.unpackEncodedString(DFA19_acceptS);
    static final short[] DFA19_special = DFA.unpackEncodedString(DFA19_specialS);
    static final short[][] DFA19_transition;

    static {
        int numStates = DFA19_transitionS.length;
        DFA19_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA19_transition[i] = DFA.unpackEncodedString(DFA19_transitionS[i]);
        }
    }

    class DFA19 extends DFA {

        public DFA19(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 19;
            this.eot = DFA19_eot;
            this.eof = DFA19_eof;
            this.min = DFA19_min;
            this.max = DFA19_max;
            this.accept = DFA19_accept;
            this.special = DFA19_special;
            this.transition = DFA19_transition;
        }
        public String getDescription() {
            return "204:1: statement : ( statementA | statementB );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA19_12 = input.LA(1);

                         
                        int index19_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred24_EolParserRules()) ) {s = 1;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index19_12);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 19, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA20_eotS =
        "\20\uffff";
    static final String DFA20_eofS =
        "\20\uffff";
    static final String DFA20_minS =
        "\1\4\10\0\7\uffff";
    static final String DFA20_maxS =
        "\1\174\10\0\7\uffff";
    static final String DFA20_acceptS =
        "\11\uffff\1\3\1\4\1\5\1\6\1\7\1\1\1\2";
    static final String DFA20_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\7\uffff}>";
    static final String[] DFA20_transitionS = {
            "\1\3\1\uffff\1\3\3\uffff\1\3\1\uffff\1\3\3\uffff\1\4\74\uffff"+
            "\1\6\10\uffff\1\5\5\2\1\11\1\uffff\1\12\1\uffff\1\13\1\14\2"+
            "\uffff\1\15\21\uffff\1\1\2\uffff\1\1\1\uffff\1\7\1\10",
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

    static final short[] DFA20_eot = DFA.unpackEncodedString(DFA20_eotS);
    static final short[] DFA20_eof = DFA.unpackEncodedString(DFA20_eofS);
    static final char[] DFA20_min = DFA.unpackEncodedStringToUnsignedChars(DFA20_minS);
    static final char[] DFA20_max = DFA.unpackEncodedStringToUnsignedChars(DFA20_maxS);
    static final short[] DFA20_accept = DFA.unpackEncodedString(DFA20_acceptS);
    static final short[] DFA20_special = DFA.unpackEncodedString(DFA20_specialS);
    static final short[][] DFA20_transition;

    static {
        int numStates = DFA20_transitionS.length;
        DFA20_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA20_transition[i] = DFA.unpackEncodedString(DFA20_transitionS[i]);
        }
    }

    class DFA20 extends DFA {

        public DFA20(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 20;
            this.eot = DFA20_eot;
            this.eof = DFA20_eof;
            this.min = DFA20_min;
            this.max = DFA20_max;
            this.accept = DFA20_accept;
            this.special = DFA20_special;
            this.transition = DFA20_transition;
        }
        public String getDescription() {
            return "208:1: statementA : ( assignmentStatement | expressionStatement | forStatement | ifStatement | whileStatement | returnStatement | breakStatement );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA20_1 = input.LA(1);

                         
                        int index20_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred25_EolParserRules()) ) {s = 14;}

                        else if ( (synpred26_EolParserRules()) ) {s = 15;}

                         
                        input.seek(index20_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA20_2 = input.LA(1);

                         
                        int index20_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred25_EolParserRules()) ) {s = 14;}

                        else if ( (synpred26_EolParserRules()) ) {s = 15;}

                         
                        input.seek(index20_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA20_3 = input.LA(1);

                         
                        int index20_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred25_EolParserRules()) ) {s = 14;}

                        else if ( (synpred26_EolParserRules()) ) {s = 15;}

                         
                        input.seek(index20_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA20_4 = input.LA(1);

                         
                        int index20_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred25_EolParserRules()) ) {s = 14;}

                        else if ( (synpred26_EolParserRules()) ) {s = 15;}

                         
                        input.seek(index20_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA20_5 = input.LA(1);

                         
                        int index20_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred25_EolParserRules()) ) {s = 14;}

                        else if ( (synpred26_EolParserRules()) ) {s = 15;}

                         
                        input.seek(index20_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA20_6 = input.LA(1);

                         
                        int index20_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred25_EolParserRules()) ) {s = 14;}

                        else if ( (synpred26_EolParserRules()) ) {s = 15;}

                         
                        input.seek(index20_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA20_7 = input.LA(1);

                         
                        int index20_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred25_EolParserRules()) ) {s = 14;}

                        else if ( (synpred26_EolParserRules()) ) {s = 15;}

                         
                        input.seek(index20_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA20_8 = input.LA(1);

                         
                        int index20_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred25_EolParserRules()) ) {s = 14;}

                        else if ( (synpred26_EolParserRules()) ) {s = 15;}

                         
                        input.seek(index20_8);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 20, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA29_eotS =
        "\26\uffff";
    static final String DFA29_eofS =
        "\26\uffff";
    static final String DFA29_minS =
        "\1\4\1\0\24\uffff";
    static final String DFA29_maxS =
        "\1\174\1\0\24\uffff";
    static final String DFA29_acceptS =
        "\2\uffff\1\2\22\uffff\1\1";
    static final String DFA29_specialS =
        "\1\uffff\1\0\24\uffff}>";
    static final String[] DFA29_transitionS = {
            "\1\2\1\uffff\1\2\3\uffff\1\2\1\uffff\1\2\3\uffff\1\1\74\uffff"+
            "\1\2\2\uffff\1\2\5\uffff\7\2\1\uffff\1\2\1\uffff\11\2\15\uffff"+
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

    static final short[] DFA29_eot = DFA.unpackEncodedString(DFA29_eotS);
    static final short[] DFA29_eof = DFA.unpackEncodedString(DFA29_eofS);
    static final char[] DFA29_min = DFA.unpackEncodedStringToUnsignedChars(DFA29_minS);
    static final char[] DFA29_max = DFA.unpackEncodedStringToUnsignedChars(DFA29_maxS);
    static final short[] DFA29_accept = DFA.unpackEncodedString(DFA29_acceptS);
    static final short[] DFA29_special = DFA.unpackEncodedString(DFA29_specialS);
    static final short[][] DFA29_transition;

    static {
        int numStates = DFA29_transitionS.length;
        DFA29_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA29_transition[i] = DFA.unpackEncodedString(DFA29_transitionS[i]);
        }
    }

    class DFA29 extends DFA {

        public DFA29(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 29;
            this.eot = DFA29_eot;
            this.eof = DFA29_eof;
            this.min = DFA29_min;
            this.max = DFA29_max;
            this.accept = DFA29_accept;
            this.special = DFA29_special;
            this.transition = DFA29_transition;
        }
        public String getDescription() {
            return "282:18: ( NAME ( ',' NAME )* )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA29_1 = input.LA(1);

                         
                        int index29_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred44_EolParserRules()) ) {s = 21;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index29_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 29, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA37_eotS =
        "\10\uffff";
    static final String DFA37_eofS =
        "\1\uffff\1\3\6\uffff";
    static final String DFA37_minS =
        "\1\20\1\7\1\4\1\uffff\1\7\1\4\1\uffff\1\7";
    static final String DFA37_maxS =
        "\1\20\1\u0083\1\174\1\uffff\1\172\1\174\1\uffff\1\172";
    static final String DFA37_acceptS =
        "\3\uffff\1\1\2\uffff\1\2\1\uffff";
    static final String DFA37_specialS =
        "\10\uffff}>";
    static final String[] DFA37_transitionS = {
            "\1\1",
            "\3\3\12\uffff\1\3\63\uffff\1\3\1\uffff\1\3\1\uffff\1\3\1\2\1"+
            "\3\2\uffff\2\3\26\uffff\20\3\10\uffff\3\3",
            "\1\3\1\uffff\1\3\3\uffff\1\3\1\uffff\1\3\3\uffff\1\4\74\uffff"+
            "\2\3\7\uffff\6\3\32\uffff\1\3\2\uffff\1\3\1\uffff\2\3",
            "",
            "\1\3\1\uffff\1\3\77\uffff\1\6\1\5\2\uffff\2\3\4\uffff\3\3\25"+
            "\uffff\16\3\1\uffff\1\6",
            "\1\3\1\uffff\1\3\3\uffff\1\3\1\uffff\1\3\3\uffff\1\7\74\uffff"+
            "\1\3\10\uffff\6\3\32\uffff\1\3\2\uffff\1\3\1\uffff\2\3",
            "",
            "\1\3\1\uffff\1\3\77\uffff\1\6\1\5\2\uffff\2\3\4\uffff\3\3\25"+
            "\uffff\16\3\1\uffff\1\6"
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
            return "336:1: featureCall : ( simpleFeatureCall | declarativeFeatureCall );";
        }
    }
    static final String DFA47_eotS =
        "\13\uffff";
    static final String DFA47_eofS =
        "\13\uffff";
    static final String DFA47_minS =
        "\1\4\10\0\2\uffff";
    static final String DFA47_maxS =
        "\1\174\10\0\2\uffff";
    static final String DFA47_acceptS =
        "\11\uffff\1\1\1\2";
    static final String DFA47_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\2\uffff}>";
    static final String[] DFA47_transitionS = {
            "\1\3\1\uffff\1\3\3\uffff\1\3\1\uffff\1\3\3\uffff\1\4\74\uffff"+
            "\1\6\10\uffff\1\5\5\2\32\uffff\1\1\2\uffff\1\1\1\uffff\1\7\1"+
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
            return "388:1: expressionListOrRange : ( expressionRange | expressionList );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA47_1 = input.LA(1);

                         
                        int index47_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred78_EolParserRules()) ) {s = 9;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index47_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA47_2 = input.LA(1);

                         
                        int index47_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred78_EolParserRules()) ) {s = 9;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index47_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA47_3 = input.LA(1);

                         
                        int index47_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred78_EolParserRules()) ) {s = 9;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index47_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA47_4 = input.LA(1);

                         
                        int index47_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred78_EolParserRules()) ) {s = 9;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index47_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA47_5 = input.LA(1);

                         
                        int index47_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred78_EolParserRules()) ) {s = 9;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index47_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA47_6 = input.LA(1);

                         
                        int index47_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred78_EolParserRules()) ) {s = 9;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index47_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA47_7 = input.LA(1);

                         
                        int index47_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred78_EolParserRules()) ) {s = 9;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index47_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA47_8 = input.LA(1);

                         
                        int index47_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred78_EolParserRules()) ) {s = 9;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index47_8);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 47, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA48_eotS =
        "\14\uffff";
    static final String DFA48_eofS =
        "\1\uffff\1\11\12\uffff";
    static final String DFA48_minS =
        "\1\4\1\7\1\uffff\1\0\10\uffff";
    static final String DFA48_maxS =
        "\1\174\1\u0083\1\uffff\1\0\10\uffff";
    static final String DFA48_acceptS =
        "\2\uffff\1\2\1\uffff\1\5\1\7\1\10\1\11\1\1\1\6\1\3\1\4";
    static final String DFA48_specialS =
        "\3\uffff\1\0\10\uffff}>";
    static final String[] DFA48_transitionS = {
            "\1\2\1\uffff\1\2\3\uffff\1\2\1\uffff\1\2\3\uffff\1\3\74\uffff"+
            "\1\5\10\uffff\1\4\5\1\37\uffff\1\6\1\7",
            "\3\11\12\uffff\1\11\63\uffff\1\11\1\uffff\1\11\1\uffff\3\11"+
            "\1\uffff\1\10\2\11\26\uffff\20\11\10\uffff\3\11",
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
            return "397:1: primitiveExpression : ( litteralCollection | literal | featureCall | pathName | nativeType | collectionType | '(' logicalExpression ')' | newExpression | variableDeclarationExpression );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA48_3 = input.LA(1);

                         
                        int index48_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_EolParserRules()) ) {s = 10;}

                        else if ( (synpred82_EolParserRules()) ) {s = 11;}

                         
                        input.seek(index48_3);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 48, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_operationDeclaration_in_operationDeclarationOrAnnotationBlock206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationBlock_in_operationDeclarationOrAnnotationBlock208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_modelDeclaration219 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NAME_in_modelDeclaration221 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000B00L});
    public static final BitSet FOLLOW_modelAlias_in_modelDeclaration223 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000300L});
    public static final BitSet FOLLOW_modelNamespace_in_modelDeclaration226 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_modelDeclaration229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_modelNamespace262 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NAME_in_modelNamespace264 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000400L});
    public static final BitSet FOLLOW_74_in_modelNamespace267 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NAME_in_modelNamespace269 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000400L});
    public static final BitSet FOLLOW_75_in_modelAlias293 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NAME_in_modelAlias295 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000400L});
    public static final BitSet FOLLOW_74_in_modelAlias298 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NAME_in_modelAlias300 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000400L});
    public static final BitSet FOLLOW_76_in_operationDeclaration326 = new BitSet(new long[]{0x0000000000010000L,0x000000000FC00000L});
    public static final BitSet FOLLOW_typeName_in_operationDeclaration331 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NAME_in_operationDeclaration339 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_operationDeclaration341 = new BitSet(new long[]{0x0000000000010000L,0x0000000000004000L});
    public static final BitSet FOLLOW_formalParameterList_in_operationDeclaration343 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_operationDeclaration346 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010200L});
    public static final BitSet FOLLOW_73_in_operationDeclaration349 = new BitSet(new long[]{0x0000000000010000L,0x000000000FC00000L});
    public static final BitSet FOLLOW_typeName_in_operationDeclaration353 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010200L});
    public static final BitSet FOLLOW_statementBlock_in_operationDeclaration359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_importStatement396 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_STRING_in_importStatement399 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_importStatement401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_block416 = new BitSet(new long[]{0x0000000000011452L,0x1A4001FF5FC02000L});
    public static final BitSet FOLLOW_80_in_statementBlock438 = new BitSet(new long[]{0x0000000000011450L,0x1A4001FF5FC02000L});
    public static final BitSet FOLLOW_block_in_statementBlock441 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_81_in_statementBlock443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_formalParameter455 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});
    public static final BitSet FOLLOW_73_in_formalParameter458 = new BitSet(new long[]{0x0000000000010000L,0x000000000FC00000L});
    public static final BitSet FOLLOW_typeName_in_formalParameter462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_formalParameter_in_formalParameterList491 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000400L});
    public static final BitSet FOLLOW_74_in_formalParameterList494 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_formalParameter_in_formalParameterList496 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000400L});
    public static final BitSet FOLLOW_82_in_executableAnnotation519 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NAME_in_executableAnnotation521 = new BitSet(new long[]{0x0000000000011450L,0x1A4000000FC02000L});
    public static final BitSet FOLLOW_logicalExpression_in_executableAnnotation523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Annotation_in_annotation545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_executableAnnotation_in_annotation547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotation_in_annotationBlock558 = new BitSet(new long[]{0x0000000000100002L,0x0000000000040000L});
    public static final BitSet FOLLOW_pathName_in_typeName581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nativeType_in_typeName585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectionType_in_typeName589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_pathName606 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_83_in_pathName609 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NAME_in_pathName616 = new BitSet(new long[]{0x0000000000000002L,0x0000000000300000L});
    public static final BitSet FOLLOW_84_in_pathName621 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NAME_in_pathName626 = new BitSet(new long[]{0x0000000000000002L,0x0000000000300000L});
    public static final BitSet FOLLOW_85_in_pathName636 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NAME_in_pathName641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_86_in_nativeType661 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_nativeType664 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_STRING_in_nativeType667 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_nativeType669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_modelElementType686 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_83_in_modelElementType688 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NAME_in_modelElementType690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_collectionType712 = new BitSet(new long[]{0x0000000000000002L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_collectionType728 = new BitSet(new long[]{0x0000000000010000L,0x000000000FC00000L});
    public static final BitSet FOLLOW_typeName_in_collectionType733 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_collectionType736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementA_in_statement759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementB_in_statement763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignmentStatement_in_statementA773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionStatement_in_statementA777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_forStatement_in_statementA781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStatement_in_statementA787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_whileStatement_in_statementA791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_returnStatement_in_statementA795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_breakStatement_in_statementA799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_breakAllStatement_in_statementB811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_returnStatement_in_statementB815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_transactionStatement_in_statementB819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_abortStatement_in_statementB825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_continueStatement_in_statementB829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_throwStatement_in_statementB833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_deleteStatement_in_statementB839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_statementOrStatementBlock850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementBlock_in_statementOrStatementBlock854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_expressionOrStatementBlock863 = new BitSet(new long[]{0x0000000000011450L,0x1A4000000FC02000L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionOrStatementBlock866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementBlock_in_expressionOrStatementBlock870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_92_in_forStatement881 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_forStatement883 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_formalParameter_in_forStatement885 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_forStatement887 = new BitSet(new long[]{0x0000000000011450L,0x1A4000000FC02000L});
    public static final BitSet FOLLOW_logicalExpression_in_forStatement889 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_forStatement891 = new BitSet(new long[]{0x0000000000011450L,0x1A4001FF5FC12200L});
    public static final BitSet FOLLOW_statementOrStatementBlock_in_forStatement893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_ifStatement917 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_ifStatement919 = new BitSet(new long[]{0x0000000000011450L,0x1A4000000FC02000L});
    public static final BitSet FOLLOW_logicalExpression_in_ifStatement921 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_ifStatement923 = new BitSet(new long[]{0x0000000000011450L,0x1A4001FF5FC12200L});
    public static final BitSet FOLLOW_statementOrStatementBlock_in_ifStatement925 = new BitSet(new long[]{0x0000000000000002L,0x0000000080000000L});
    public static final BitSet FOLLOW_elseStatement_in_ifStatement927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_95_in_elseStatement954 = new BitSet(new long[]{0x0000000000011450L,0x1A4001FF5FC12200L});
    public static final BitSet FOLLOW_statementOrStatementBlock_in_elseStatement957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_96_in_whileStatement970 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_whileStatement972 = new BitSet(new long[]{0x0000000000011450L,0x1A4000000FC02000L});
    public static final BitSet FOLLOW_logicalExpression_in_whileStatement974 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_whileStatement976 = new BitSet(new long[]{0x0000000000011450L,0x1A4001FF5FC12200L});
    public static final BitSet FOLLOW_statementOrStatementBlock_in_whileStatement978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_97_in_returnStatement1000 = new BitSet(new long[]{0x0000000000011450L,0x1A4000000FC02100L});
    public static final BitSet FOLLOW_logicalExpression_in_returnStatement1002 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_returnStatement1005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_98_in_throwStatement1026 = new BitSet(new long[]{0x0000000000011450L,0x1A4000000FC02100L});
    public static final BitSet FOLLOW_logicalExpression_in_throwStatement1028 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_throwStatement1031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_99_in_deleteStatement1052 = new BitSet(new long[]{0x0000000000011450L,0x1A4000000FC02100L});
    public static final BitSet FOLLOW_logicalExpression_in_deleteStatement1054 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_deleteStatement1057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_100_in_breakStatement1081 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_breakStatement1083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_101_in_breakAllStatement1101 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_breakAllStatement1103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_102_in_continueStatement1121 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_continueStatement1123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_103_in_abortStatement1141 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_abortStatement1143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_104_in_transactionStatement1161 = new BitSet(new long[]{0x0000000000011450L,0x1A4001FF5FC12200L});
    public static final BitSet FOLLOW_NAME_in_transactionStatement1164 = new BitSet(new long[]{0x0000000000011450L,0x1A4001FF5FC12600L});
    public static final BitSet FOLLOW_74_in_transactionStatement1167 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NAME_in_transactionStatement1169 = new BitSet(new long[]{0x0000000000011450L,0x1A4001FF5FC12600L});
    public static final BitSet FOLLOW_statementOrStatementBlock_in_transactionStatement1175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logicalExpression_in_assignmentStatement1204 = new BitSet(new long[]{0x0000000000000000L,0x0000060000000000L});
    public static final BitSet FOLLOW_105_in_assignmentStatement1209 = new BitSet(new long[]{0x0000000000011450L,0x1A4000000FC02000L});
    public static final BitSet FOLLOW_106_in_assignmentStatement1216 = new BitSet(new long[]{0x0000000000011450L,0x1A4000000FC02000L});
    public static final BitSet FOLLOW_logicalExpression_in_assignmentStatement1222 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_assignmentStatement1224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionStatement1239 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_expressionStatement1241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_relationalExpression_in_logicalExpression1253 = new BitSet(new long[]{0x0000000000000002L,0x0000780000000000L});
    public static final BitSet FOLLOW_set_in_logicalExpression1256 = new BitSet(new long[]{0x0000000000011450L,0x1A4000000FC02000L});
    public static final BitSet FOLLOW_relationalExpression_in_logicalExpression1267 = new BitSet(new long[]{0x0000000000000002L,0x0000780000000000L});
    public static final BitSet FOLLOW_additiveExpression_in_relationalExpression1284 = new BitSet(new long[]{0x0000000000000002L,0x001F800000000000L});
    public static final BitSet FOLLOW_set_in_relationalExpression1287 = new BitSet(new long[]{0x0000000000011450L,0x1A4000000FC02000L});
    public static final BitSet FOLLOW_additiveExpression_in_relationalExpression1302 = new BitSet(new long[]{0x0000000000000002L,0x001F800000000000L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_additiveExpression1319 = new BitSet(new long[]{0x0000000000000002L,0x0060000000000000L});
    public static final BitSet FOLLOW_set_in_additiveExpression1322 = new BitSet(new long[]{0x0000000000011450L,0x1A4000000FC02000L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_additiveExpression1329 = new BitSet(new long[]{0x0000000000000002L,0x0060000000000000L});
    public static final BitSet FOLLOW_unaryExpression_in_multiplicativeExpression1350 = new BitSet(new long[]{0x0000000000000002L,0x0180000000000000L});
    public static final BitSet FOLLOW_set_in_multiplicativeExpression1353 = new BitSet(new long[]{0x0000000000011450L,0x1A4000000FC02000L});
    public static final BitSet FOLLOW_unaryExpression_in_multiplicativeExpression1360 = new BitSet(new long[]{0x0000000000000002L,0x0180000000000000L});
    public static final BitSet FOLLOW_set_in_unaryExpression1378 = new BitSet(new long[]{0x0000000000011450L,0x1A4000000FC02000L});
    public static final BitSet FOLLOW_postfixExpression_in_unaryExpression1387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primitiveExpression_in_postfixExpression1402 = new BitSet(new long[]{0x0000000000000282L});
    public static final BitSet FOLLOW_set_in_postfixExpression1404 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_featureCall_in_postfixExpression1413 = new BitSet(new long[]{0x0000000000000282L});
    public static final BitSet FOLLOW_simpleFeatureCall_in_featureCall1448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declarativeFeatureCall_in_featureCall1452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_simpleFeatureCall1464 = new BitSet(new long[]{0x0000000000000002L,0x0000000000002000L});
    public static final BitSet FOLLOW_parameterList_in_simpleFeatureCall1467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_parameterList1482 = new BitSet(new long[]{0x0000000000011450L,0x1A4000000FC06000L});
    public static final BitSet FOLLOW_logicalExpression_in_parameterList1485 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004400L});
    public static final BitSet FOLLOW_74_in_parameterList1488 = new BitSet(new long[]{0x0000000000011450L,0x1A4000000FC02000L});
    public static final BitSet FOLLOW_logicalExpression_in_parameterList1490 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004400L});
    public static final BitSet FOLLOW_78_in_parameterList1496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_declarativeFeatureCall1518 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_declarativeFeatureCall1521 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_formalParameterList_in_declarativeFeatureCall1524 = new BitSet(new long[]{0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_122_in_declarativeFeatureCall1526 = new BitSet(new long[]{0x0000000000011450L,0x1A4000000FC02000L});
    public static final BitSet FOLLOW_logicalExpression_in_declarativeFeatureCall1529 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_declarativeFeatureCall1531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_123_in_newExpression1543 = new BitSet(new long[]{0x0000000000010000L,0x000000000FC00000L});
    public static final BitSet FOLLOW_typeName_in_newExpression1548 = new BitSet(new long[]{0x0000000000000002L,0x0000000000002000L});
    public static final BitSet FOLLOW_parameterList_in_newExpression1552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_124_in_variableDeclarationExpression1577 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NAME_in_variableDeclarationExpression1579 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});
    public static final BitSet FOLLOW_73_in_variableDeclarationExpression1582 = new BitSet(new long[]{0x0000000000010000L,0x080000000FC00000L});
    public static final BitSet FOLLOW_123_in_variableDeclarationExpression1586 = new BitSet(new long[]{0x0000000000010000L,0x080000000FC00000L});
    public static final BitSet FOLLOW_typeName_in_variableDeclarationExpression1591 = new BitSet(new long[]{0x0000000000000002L,0x0000000000002000L});
    public static final BitSet FOLLOW_parameterList_in_variableDeclarationExpression1595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_litteralCollection1625 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_80_in_litteralCollection1638 = new BitSet(new long[]{0x0000000000011450L,0x1A4000000FC22000L});
    public static final BitSet FOLLOW_expressionListOrRange_in_litteralCollection1642 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_81_in_litteralCollection1645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionRange1660 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_POINT_POINT_in_expressionRange1662 = new BitSet(new long[]{0x0000000000011450L,0x1A4000000FC02000L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionRange1664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionList1686 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000400L});
    public static final BitSet FOLLOW_74_in_expressionList1689 = new BitSet(new long[]{0x0000000000011450L,0x1A4000000FC02000L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionList1691 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000400L});
    public static final BitSet FOLLOW_expressionRange_in_expressionListOrRange1715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionList_in_expressionListOrRange1719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_litteralCollection_in_primitiveExpression1741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_primitiveExpression1745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_featureCall_in_primitiveExpression1749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pathName_in_primitiveExpression1753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nativeType_in_primitiveExpression1757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectionType_in_primitiveExpression1763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_primitiveExpression1768 = new BitSet(new long[]{0x0000000000011450L,0x1A4000000FC02000L});
    public static final BitSet FOLLOW_logicalExpression_in_primitiveExpression1771 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_primitiveExpression1773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_newExpression_in_primitiveExpression1781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variableDeclarationExpression_in_primitiveExpression1785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_literal0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotation_in_synpred13_EolParserRules558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_synpred23_EolParserRules728 = new BitSet(new long[]{0x0000000000010000L,0x080000000FC00000L});
    public static final BitSet FOLLOW_typeName_in_synpred23_EolParserRules733 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_synpred23_EolParserRules736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementA_in_synpred24_EolParserRules759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignmentStatement_in_synpred25_EolParserRules773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionStatement_in_synpred26_EolParserRules777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_elseStatement_in_synpred39_EolParserRules927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_synpred44_EolParserRules1164 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000400L});
    public static final BitSet FOLLOW_74_in_synpred44_EolParserRules1167 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NAME_in_synpred44_EolParserRules1169 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000400L});
    public static final BitSet FOLLOW_expressionRange_in_synpred78_EolParserRules1715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_featureCall_in_synpred81_EolParserRules1749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pathName_in_synpred82_EolParserRules1753 = new BitSet(new long[]{0x0000000000000002L});

}
