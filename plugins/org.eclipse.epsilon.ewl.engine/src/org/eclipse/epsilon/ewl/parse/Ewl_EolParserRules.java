package org.eclipse.epsilon.ewl.parse;

// $ANTLR 3.1b1 EolParserRules.g 2009-11-08 18:53:39

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
    public static final int WHILE=30;
    public static final int StatementBlock=26;
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
    public static final int T__132=132;
    public static final int WIZARD=67;
    public static final int T__79=79;
    public static final int T__133=133;
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

            if ( ((LA1_0>=76 && LA1_0<=77)) ) {
                alt1=1;
            }
            else if ( (LA1_0==Annotation||LA1_0==83) ) {
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
    // EolParserRules.g:113:1: operationDeclaration : ( 'operation' | 'function' ) (ctx= typeName )? operationName= NAME '(' ( formalParameterList )? ')' ( ':' returnType= typeName )? statementBlock -> ^( HELPERMETHOD ( $ctx)? $operationName ( formalParameterList )? ( $returnType)? statementBlock ) ;
    public final Ewl_EolParserRules.operationDeclaration_return operationDeclaration() throws RecognitionException {
        Ewl_EolParserRules.operationDeclaration_return retval = new Ewl_EolParserRules.operationDeclaration_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token operationName=null;
        Token string_literal16=null;
        Token string_literal17=null;
        Token char_literal18=null;
        Token char_literal20=null;
        Token char_literal21=null;
        Ewl_EolParserRules.typeName_return ctx = null;

        Ewl_EolParserRules.typeName_return returnType = null;

        Ewl_EolParserRules.formalParameterList_return formalParameterList19 = null;

        Ewl_EolParserRules.statementBlock_return statementBlock22 = null;


        CommonTree operationName_tree=null;
        CommonTree string_literal16_tree=null;
        CommonTree string_literal17_tree=null;
        CommonTree char_literal18_tree=null;
        CommonTree char_literal20_tree=null;
        CommonTree char_literal21_tree=null;
        RewriteRuleTokenStream stream_79=new RewriteRuleTokenStream(adaptor,"token 79");
        RewriteRuleTokenStream stream_78=new RewriteRuleTokenStream(adaptor,"token 78");
        RewriteRuleTokenStream stream_77=new RewriteRuleTokenStream(adaptor,"token 77");
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_73=new RewriteRuleTokenStream(adaptor,"token 73");
        RewriteRuleTokenStream stream_76=new RewriteRuleTokenStream(adaptor,"token 76");
        RewriteRuleSubtreeStream stream_typeName=new RewriteRuleSubtreeStream(adaptor,"rule typeName");
        RewriteRuleSubtreeStream stream_statementBlock=new RewriteRuleSubtreeStream(adaptor,"rule statementBlock");
        RewriteRuleSubtreeStream stream_formalParameterList=new RewriteRuleSubtreeStream(adaptor,"rule formalParameterList");
        try {
            // EolParserRules.g:115:2: ( ( 'operation' | 'function' ) (ctx= typeName )? operationName= NAME '(' ( formalParameterList )? ')' ( ':' returnType= typeName )? statementBlock -> ^( HELPERMETHOD ( $ctx)? $operationName ( formalParameterList )? ( $returnType)? statementBlock ) )
            // EolParserRules.g:115:4: ( 'operation' | 'function' ) (ctx= typeName )? operationName= NAME '(' ( formalParameterList )? ')' ( ':' returnType= typeName )? statementBlock
            {
            // EolParserRules.g:115:4: ( 'operation' | 'function' )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==76) ) {
                alt6=1;
            }
            else if ( (LA6_0==77) ) {
                alt6=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // EolParserRules.g:115:5: 'operation'
                    {
                    string_literal16=(Token)match(input,76,FOLLOW_76_in_operationDeclaration327); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_76.add(string_literal16);


                    }
                    break;
                case 2 :
                    // EolParserRules.g:115:17: 'function'
                    {
                    string_literal17=(Token)match(input,77,FOLLOW_77_in_operationDeclaration329); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_77.add(string_literal17);


                    }
                    break;

            }

            // EolParserRules.g:115:29: (ctx= typeName )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==NAME) ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==NAME||(LA7_1>=84 && LA7_1<=86)) ) {
                    alt7=1;
                }
            }
            else if ( ((LA7_0>=87 && LA7_0<=92)) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // EolParserRules.g:115:30: ctx= typeName
                    {
                    pushFollow(FOLLOW_typeName_in_operationDeclaration335);
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

            operationName=(Token)match(input,NAME,FOLLOW_NAME_in_operationDeclaration343); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(operationName);

            char_literal18=(Token)match(input,78,FOLLOW_78_in_operationDeclaration345); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_78.add(char_literal18);

            // EolParserRules.g:115:94: ( formalParameterList )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==NAME) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // EolParserRules.g:0:0: formalParameterList
                    {
                    pushFollow(FOLLOW_formalParameterList_in_operationDeclaration347);
                    formalParameterList19=formalParameterList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_formalParameterList.add(formalParameterList19.getTree());

                    }
                    break;

            }

            char_literal20=(Token)match(input,79,FOLLOW_79_in_operationDeclaration350); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_79.add(char_literal20);

            // EolParserRules.g:115:119: ( ':' returnType= typeName )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==73) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // EolParserRules.g:115:120: ':' returnType= typeName
                    {
                    char_literal21=(Token)match(input,73,FOLLOW_73_in_operationDeclaration353); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_73.add(char_literal21);

                    pushFollow(FOLLOW_typeName_in_operationDeclaration357);
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

            pushFollow(FOLLOW_statementBlock_in_operationDeclaration363);
            statementBlock22=statementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_statementBlock.add(statementBlock22.getTree());


            // AST REWRITE
            // elements: operationName, ctx, returnType, statementBlock, formalParameterList
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
        Token STRING23=null;
        Token char_literal24=null;

        CommonTree i_tree=null;
        CommonTree STRING23_tree=null;
        CommonTree char_literal24_tree=null;

        try {
            // EolParserRules.g:120:2: (i= 'import' STRING ';' )
            // EolParserRules.g:120:4: i= 'import' STRING ';'
            {
            root_0 = (CommonTree)adaptor.nil();

            i=(Token)match(input,80,FOLLOW_80_in_importStatement400); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            i_tree = (CommonTree)adaptor.create(i);
            root_0 = (CommonTree)adaptor.becomeRoot(i_tree, root_0);
            }
            STRING23=(Token)match(input,STRING,FOLLOW_STRING_in_importStatement403); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STRING23_tree = (CommonTree)adaptor.create(STRING23);
            adaptor.addChild(root_0, STRING23_tree);
            }
            char_literal24=(Token)match(input,72,FOLLOW_72_in_importStatement405); if (state.failed) return retval;
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

        Ewl_EolParserRules.statement_return statement25 = null;


        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        try {
            // EolParserRules.g:125:2: ( ( statement )* -> ^( BLOCK ( statement )* ) )
            // EolParserRules.g:125:4: ( statement )*
            {
            // EolParserRules.g:125:4: ( statement )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==FLOAT||LA10_0==INT||LA10_0==BOOLEAN||LA10_0==STRING||LA10_0==NAME||LA10_0==78||(LA10_0>=87 && LA10_0<=93)||LA10_0==95||(LA10_0>=97 && LA10_0<=105)||LA10_0==120||LA10_0==123||(LA10_0>=125 && LA10_0<=126)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // EolParserRules.g:0:0: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_block420);
            	    statement25=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_statement.add(statement25.getTree());

            	    }
            	    break;

            	default :
            	    break loop10;
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

        Token char_literal26=null;
        Token char_literal28=null;
        Ewl_EolParserRules.block_return block27 = null;


        CommonTree char_literal26_tree=null;
        CommonTree char_literal28_tree=null;

        try {
            // EolParserRules.g:130:2: ( '{' block '}' )
            // EolParserRules.g:130:4: '{' block '}'
            {
            root_0 = (CommonTree)adaptor.nil();

            char_literal26=(Token)match(input,81,FOLLOW_81_in_statementBlock442); if (state.failed) return retval;
            pushFollow(FOLLOW_block_in_statementBlock445);
            block27=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, block27.getTree());
            char_literal28=(Token)match(input,82,FOLLOW_82_in_statementBlock447); if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
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

        Token NAME29=null;
        Token char_literal30=null;
        Ewl_EolParserRules.typeName_return pt = null;


        CommonTree NAME29_tree=null;
        CommonTree char_literal30_tree=null;
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_73=new RewriteRuleTokenStream(adaptor,"token 73");
        RewriteRuleSubtreeStream stream_typeName=new RewriteRuleSubtreeStream(adaptor,"rule typeName");
        try {
            // EolParserRules.g:134:2: ( NAME ( ':' pt= typeName )? -> ^( FORMAL NAME ( typeName )? ) )
            // EolParserRules.g:134:4: NAME ( ':' pt= typeName )?
            {
            NAME29=(Token)match(input,NAME,FOLLOW_NAME_in_formalParameter459); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(NAME29);

            // EolParserRules.g:134:9: ( ':' pt= typeName )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==73) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // EolParserRules.g:134:10: ':' pt= typeName
                    {
                    char_literal30=(Token)match(input,73,FOLLOW_73_in_formalParameter462); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_73.add(char_literal30);

                    pushFollow(FOLLOW_typeName_in_formalParameter466);
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

        Token char_literal32=null;
        Ewl_EolParserRules.formalParameter_return formalParameter31 = null;

        Ewl_EolParserRules.formalParameter_return formalParameter33 = null;


        CommonTree char_literal32_tree=null;
        RewriteRuleTokenStream stream_74=new RewriteRuleTokenStream(adaptor,"token 74");
        RewriteRuleSubtreeStream stream_formalParameter=new RewriteRuleSubtreeStream(adaptor,"rule formalParameter");
        try {
            // EolParserRules.g:139:2: ( formalParameter ( ',' formalParameter )* -> ^( PARAMLIST ( formalParameter )* ) )
            // EolParserRules.g:139:4: formalParameter ( ',' formalParameter )*
            {
            pushFollow(FOLLOW_formalParameter_in_formalParameterList495);
            formalParameter31=formalParameter();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_formalParameter.add(formalParameter31.getTree());
            // EolParserRules.g:139:20: ( ',' formalParameter )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==74) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // EolParserRules.g:139:21: ',' formalParameter
            	    {
            	    char_literal32=(Token)match(input,74,FOLLOW_74_in_formalParameterList498); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_74.add(char_literal32);

            	    pushFollow(FOLLOW_formalParameter_in_formalParameterList500);
            	    formalParameter33=formalParameter();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_formalParameter.add(formalParameter33.getTree());

            	    }
            	    break;

            	default :
            	    break loop12;
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

        Token char_literal34=null;
        Token NAME35=null;
        Ewl_EolParserRules.logicalExpression_return logicalExpression36 = null;


        CommonTree char_literal34_tree=null;
        CommonTree NAME35_tree=null;
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_83=new RewriteRuleTokenStream(adaptor,"token 83");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:144:2: ( '$' NAME logicalExpression -> ^( EXECUTABLEANNOTATION NAME logicalExpression ) )
            // EolParserRules.g:144:4: '$' NAME logicalExpression
            {
            char_literal34=(Token)match(input,83,FOLLOW_83_in_executableAnnotation523); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_83.add(char_literal34);

            NAME35=(Token)match(input,NAME,FOLLOW_NAME_in_executableAnnotation525); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(NAME35);

            pushFollow(FOLLOW_logicalExpression_in_executableAnnotation527);
            logicalExpression36=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression36.getTree());


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

        Token Annotation37=null;
        Ewl_EolParserRules.executableAnnotation_return executableAnnotation38 = null;


        CommonTree Annotation37_tree=null;

        try {
            // EolParserRules.g:149:2: ( Annotation | executableAnnotation )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==Annotation) ) {
                alt13=1;
            }
            else if ( (LA13_0==83) ) {
                alt13=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // EolParserRules.g:149:4: Annotation
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    Annotation37=(Token)match(input,Annotation,FOLLOW_Annotation_in_annotation549); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    Annotation37_tree = (CommonTree)adaptor.create(Annotation37);
                    adaptor.addChild(root_0, Annotation37_tree);
                    }

                    }
                    break;
                case 2 :
                    // EolParserRules.g:149:15: executableAnnotation
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_executableAnnotation_in_annotation551);
                    executableAnnotation38=executableAnnotation();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, executableAnnotation38.getTree());

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

        Ewl_EolParserRules.annotation_return annotation39 = null;


        RewriteRuleSubtreeStream stream_annotation=new RewriteRuleSubtreeStream(adaptor,"rule annotation");
        try {
            // EolParserRules.g:153:2: ( ( annotation )+ -> ^( ANNOTATIONBLOCK ( annotation )+ ) )
            // EolParserRules.g:153:4: ( annotation )+
            {
            // EolParserRules.g:153:4: ( annotation )+
            int cnt14=0;
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==Annotation) ) {
                    int LA14_2 = input.LA(2);

                    if ( (synpred14_EolParserRules()) ) {
                        alt14=1;
                    }


                }
                else if ( (LA14_0==83) ) {
                    int LA14_3 = input.LA(2);

                    if ( (synpred14_EolParserRules()) ) {
                        alt14=1;
                    }


                }


                switch (alt14) {
            	case 1 :
            	    // EolParserRules.g:0:0: annotation
            	    {
            	    pushFollow(FOLLOW_annotation_in_annotationBlock562);
            	    annotation39=annotation();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_annotation.add(annotation39.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt14 >= 1 ) break loop14;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(14, input);
                        throw eee;
                }
                cnt14++;
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

        Ewl_EolParserRules.pathName_return pathName40 = null;

        Ewl_EolParserRules.nativeType_return nativeType41 = null;

        Ewl_EolParserRules.collectionType_return collectionType42 = null;



        try {
            // EolParserRules.g:158:2: ( pathName | nativeType | collectionType )
            int alt15=3;
            switch ( input.LA(1) ) {
            case NAME:
                {
                alt15=1;
                }
                break;
            case 87:
                {
                alt15=2;
                }
                break;
            case 88:
            case 89:
            case 90:
            case 91:
            case 92:
                {
                alt15=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // EolParserRules.g:158:4: pathName
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_pathName_in_typeName585);
                    pathName40=pathName();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pathName40.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:158:15: nativeType
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_nativeType_in_typeName589);
                    nativeType41=nativeType();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nativeType41.getTree());

                    }
                    break;
                case 3 :
                    // EolParserRules.g:158:28: collectionType
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_collectionType_in_typeName593);
                    collectionType42=collectionType();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, collectionType42.getTree());
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
        Token char_literal43=null;
        Token string_literal44=null;
        Token char_literal45=null;

        CommonTree metamodel_tree=null;
        CommonTree head_tree=null;
        CommonTree field_tree=null;
        CommonTree label_tree=null;
        CommonTree char_literal43_tree=null;
        CommonTree string_literal44_tree=null;
        CommonTree char_literal45_tree=null;

        try {
            // EolParserRules.g:163:2: ( (metamodel= NAME '!' )? head= NAME ( '::' field= NAME )* ( '#' label= NAME )? )
            // EolParserRules.g:163:4: (metamodel= NAME '!' )? head= NAME ( '::' field= NAME )* ( '#' label= NAME )?
            {
            root_0 = (CommonTree)adaptor.nil();

            // EolParserRules.g:163:4: (metamodel= NAME '!' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==NAME) ) {
                int LA16_1 = input.LA(2);

                if ( (LA16_1==84) ) {
                    alt16=1;
                }
            }
            switch (alt16) {
                case 1 :
                    // EolParserRules.g:163:5: metamodel= NAME '!'
                    {
                    metamodel=(Token)match(input,NAME,FOLLOW_NAME_in_pathName610); if (state.failed) return retval;
                    char_literal43=(Token)match(input,84,FOLLOW_84_in_pathName613); if (state.failed) return retval;

                    }
                    break;

            }

            head=(Token)match(input,NAME,FOLLOW_NAME_in_pathName620); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            head_tree = (CommonTree)adaptor.create(head);
            adaptor.addChild(root_0, head_tree);
            }
            // EolParserRules.g:164:3: ( '::' field= NAME )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==85) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // EolParserRules.g:164:4: '::' field= NAME
            	    {
            	    string_literal44=(Token)match(input,85,FOLLOW_85_in_pathName625); if (state.failed) return retval;
            	    field=(Token)match(input,NAME,FOLLOW_NAME_in_pathName630); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	      
            	      			head.setText(head.getText()
            	      					+ "::"
            	      					+ field.getText()
            	      					); 
            	      		
            	    }

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            // EolParserRules.g:170:3: ( '#' label= NAME )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==86) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // EolParserRules.g:170:4: '#' label= NAME
                    {
                    char_literal45=(Token)match(input,86,FOLLOW_86_in_pathName640); if (state.failed) return retval;
                    label=(Token)match(input,NAME,FOLLOW_NAME_in_pathName645); if (state.failed) return retval;

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

        Token string_literal46=null;
        Token char_literal47=null;
        Token STRING48=null;
        Token char_literal49=null;

        CommonTree string_literal46_tree=null;
        CommonTree char_literal47_tree=null;
        CommonTree STRING48_tree=null;
        CommonTree char_literal49_tree=null;

        try {
            // EolParserRules.g:186:2: ( 'Native' '(' STRING ')' )
            // EolParserRules.g:186:4: 'Native' '(' STRING ')'
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal46=(Token)match(input,87,FOLLOW_87_in_nativeType665); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal46_tree = (CommonTree)adaptor.create(string_literal46);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal46_tree, root_0);
            }
            char_literal47=(Token)match(input,78,FOLLOW_78_in_nativeType668); if (state.failed) return retval;
            STRING48=(Token)match(input,STRING,FOLLOW_STRING_in_nativeType671); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STRING48_tree = (CommonTree)adaptor.create(STRING48);
            adaptor.addChild(root_0, STRING48_tree);
            }
            char_literal49=(Token)match(input,79,FOLLOW_79_in_nativeType673); if (state.failed) return retval;
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

        Token NAME50=null;
        Token char_literal51=null;
        Token NAME52=null;

        CommonTree NAME50_tree=null;
        CommonTree char_literal51_tree=null;
        CommonTree NAME52_tree=null;
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_84=new RewriteRuleTokenStream(adaptor,"token 84");

        try {
            // EolParserRules.g:192:2: ( NAME '!' NAME -> ^( ModelElementType ( NAME )+ ) )
            // EolParserRules.g:192:4: NAME '!' NAME
            {
            NAME50=(Token)match(input,NAME,FOLLOW_NAME_in_modelElementType690); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(NAME50);

            char_literal51=(Token)match(input,84,FOLLOW_84_in_modelElementType692); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_84.add(char_literal51);

            NAME52=(Token)match(input,NAME,FOLLOW_NAME_in_modelElementType694); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(NAME52);



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

        Token set53=null;
        Token char_literal54=null;
        Token char_literal55=null;
        Ewl_EolParserRules.typeName_return tn = null;


        CommonTree set53_tree=null;
        CommonTree char_literal54_tree=null;
        CommonTree char_literal55_tree=null;

        try {
            // EolParserRules.g:197:2: ( ( 'Collection' | 'Sequence' | 'Bag' | 'Set' | 'OrderedSet' ) ( '(' tn= typeName ')' )? )
            // EolParserRules.g:197:5: ( 'Collection' | 'Sequence' | 'Bag' | 'Set' | 'OrderedSet' ) ( '(' tn= typeName ')' )?
            {
            root_0 = (CommonTree)adaptor.nil();

            set53=(Token)input.LT(1);
            set53=(Token)input.LT(1);
            if ( (input.LA(1)>=88 && input.LA(1)<=92) ) {
                input.consume();
                if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(set53), root_0);
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            // EolParserRules.g:198:3: ( '(' tn= typeName ')' )?
            int alt19=2;
            alt19 = dfa19.predict(input);
            switch (alt19) {
                case 1 :
                    // EolParserRules.g:198:4: '(' tn= typeName ')'
                    {
                    char_literal54=(Token)match(input,78,FOLLOW_78_in_collectionType732); if (state.failed) return retval;
                    pushFollow(FOLLOW_typeName_in_collectionType737);
                    tn=typeName();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, tn.getTree());
                    if ( state.backtracking==0 ) {
                      setTokenType(tn,TYPE);
                    }
                    char_literal55=(Token)match(input,79,FOLLOW_79_in_collectionType740); if (state.failed) return retval;

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

        Ewl_EolParserRules.statementA_return statementA56 = null;

        Ewl_EolParserRules.statementB_return statementB57 = null;



        try {
            // EolParserRules.g:205:2: ( statementA | statementB )
            int alt20=2;
            alt20 = dfa20.predict(input);
            switch (alt20) {
                case 1 :
                    // EolParserRules.g:205:4: statementA
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_statementA_in_statement763);
                    statementA56=statementA();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statementA56.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:205:17: statementB
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_statementB_in_statement767);
                    statementB57=statementB();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statementB57.getTree());

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

        Ewl_EolParserRules.assignmentStatement_return assignmentStatement58 = null;

        Ewl_EolParserRules.expressionStatement_return expressionStatement59 = null;

        Ewl_EolParserRules.forStatement_return forStatement60 = null;

        Ewl_EolParserRules.ifStatement_return ifStatement61 = null;

        Ewl_EolParserRules.whileStatement_return whileStatement62 = null;

        Ewl_EolParserRules.returnStatement_return returnStatement63 = null;

        Ewl_EolParserRules.breakStatement_return breakStatement64 = null;



        try {
            // EolParserRules.g:209:2: ( assignmentStatement | expressionStatement | forStatement | ifStatement | whileStatement | returnStatement | breakStatement )
            int alt21=7;
            alt21 = dfa21.predict(input);
            switch (alt21) {
                case 1 :
                    // EolParserRules.g:209:3: assignmentStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_assignmentStatement_in_statementA777);
                    assignmentStatement58=assignmentStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, assignmentStatement58.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:209:25: expressionStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_expressionStatement_in_statementA781);
                    expressionStatement59=expressionStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionStatement59.getTree());

                    }
                    break;
                case 3 :
                    // EolParserRules.g:209:47: forStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_forStatement_in_statementA785);
                    forStatement60=forStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, forStatement60.getTree());

                    }
                    break;
                case 4 :
                    // EolParserRules.g:210:5: ifStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_ifStatement_in_statementA791);
                    ifStatement61=ifStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, ifStatement61.getTree());

                    }
                    break;
                case 5 :
                    // EolParserRules.g:210:19: whileStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_whileStatement_in_statementA795);
                    whileStatement62=whileStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, whileStatement62.getTree());

                    }
                    break;
                case 6 :
                    // EolParserRules.g:210:36: returnStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_returnStatement_in_statementA799);
                    returnStatement63=returnStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, returnStatement63.getTree());

                    }
                    break;
                case 7 :
                    // EolParserRules.g:210:54: breakStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_breakStatement_in_statementA803);
                    breakStatement64=breakStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, breakStatement64.getTree());

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

        Ewl_EolParserRules.breakAllStatement_return breakAllStatement65 = null;

        Ewl_EolParserRules.returnStatement_return returnStatement66 = null;

        Ewl_EolParserRules.transactionStatement_return transactionStatement67 = null;

        Ewl_EolParserRules.abortStatement_return abortStatement68 = null;

        Ewl_EolParserRules.continueStatement_return continueStatement69 = null;

        Ewl_EolParserRules.throwStatement_return throwStatement70 = null;

        Ewl_EolParserRules.deleteStatement_return deleteStatement71 = null;



        try {
            // EolParserRules.g:214:2: ( breakAllStatement | returnStatement | transactionStatement | abortStatement | continueStatement | throwStatement | deleteStatement )
            int alt22=7;
            switch ( input.LA(1) ) {
            case 102:
                {
                alt22=1;
                }
                break;
            case 98:
                {
                alt22=2;
                }
                break;
            case 105:
                {
                alt22=3;
                }
                break;
            case 104:
                {
                alt22=4;
                }
                break;
            case 103:
                {
                alt22=5;
                }
                break;
            case 99:
                {
                alt22=6;
                }
                break;
            case 100:
                {
                alt22=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // EolParserRules.g:214:4: breakAllStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_breakAllStatement_in_statementB815);
                    breakAllStatement65=breakAllStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, breakAllStatement65.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:214:24: returnStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_returnStatement_in_statementB819);
                    returnStatement66=returnStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, returnStatement66.getTree());

                    }
                    break;
                case 3 :
                    // EolParserRules.g:214:42: transactionStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_transactionStatement_in_statementB823);
                    transactionStatement67=transactionStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, transactionStatement67.getTree());

                    }
                    break;
                case 4 :
                    // EolParserRules.g:215:5: abortStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_abortStatement_in_statementB829);
                    abortStatement68=abortStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, abortStatement68.getTree());

                    }
                    break;
                case 5 :
                    // EolParserRules.g:215:22: continueStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_continueStatement_in_statementB833);
                    continueStatement69=continueStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, continueStatement69.getTree());

                    }
                    break;
                case 6 :
                    // EolParserRules.g:215:42: throwStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_throwStatement_in_statementB837);
                    throwStatement70=throwStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, throwStatement70.getTree());

                    }
                    break;
                case 7 :
                    // EolParserRules.g:216:5: deleteStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_deleteStatement_in_statementB843);
                    deleteStatement71=deleteStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, deleteStatement71.getTree());

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

        Ewl_EolParserRules.statement_return statement72 = null;

        Ewl_EolParserRules.statementBlock_return statementBlock73 = null;



        try {
            // EolParserRules.g:220:2: ( statement | statementBlock )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==FLOAT||LA23_0==INT||LA23_0==BOOLEAN||LA23_0==STRING||LA23_0==NAME||LA23_0==78||(LA23_0>=87 && LA23_0<=93)||LA23_0==95||(LA23_0>=97 && LA23_0<=105)||LA23_0==120||LA23_0==123||(LA23_0>=125 && LA23_0<=126)) ) {
                alt23=1;
            }
            else if ( (LA23_0==81) ) {
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
                    // EolParserRules.g:220:4: statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_statement_in_statementOrStatementBlock854);
                    statement72=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement72.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:220:16: statementBlock
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_statementBlock_in_statementOrStatementBlock858);
                    statementBlock73=statementBlock();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statementBlock73.getTree());

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

        Token char_literal74=null;
        Ewl_EolParserRules.logicalExpression_return logicalExpression75 = null;

        Ewl_EolParserRules.statementBlock_return statementBlock76 = null;


        CommonTree char_literal74_tree=null;

        try {
            // EolParserRules.g:223:2: ( ':' logicalExpression | statementBlock )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==73) ) {
                alt24=1;
            }
            else if ( (LA24_0==81) ) {
                alt24=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // EolParserRules.g:223:4: ':' logicalExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    char_literal74=(Token)match(input,73,FOLLOW_73_in_expressionOrStatementBlock867); if (state.failed) return retval;
                    pushFollow(FOLLOW_logicalExpression_in_expressionOrStatementBlock870);
                    logicalExpression75=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression75.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:223:29: statementBlock
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_statementBlock_in_expressionOrStatementBlock874);
                    statementBlock76=statementBlock();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statementBlock76.getTree());

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

        Token string_literal77=null;
        Token char_literal78=null;
        Token string_literal80=null;
        Token char_literal82=null;
        Ewl_EolParserRules.formalParameter_return formalParameter79 = null;

        Ewl_EolParserRules.logicalExpression_return logicalExpression81 = null;

        Ewl_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock83 = null;


        CommonTree string_literal77_tree=null;
        CommonTree char_literal78_tree=null;
        CommonTree string_literal80_tree=null;
        CommonTree char_literal82_tree=null;
        RewriteRuleTokenStream stream_79=new RewriteRuleTokenStream(adaptor,"token 79");
        RewriteRuleTokenStream stream_78=new RewriteRuleTokenStream(adaptor,"token 78");
        RewriteRuleTokenStream stream_94=new RewriteRuleTokenStream(adaptor,"token 94");
        RewriteRuleTokenStream stream_93=new RewriteRuleTokenStream(adaptor,"token 93");
        RewriteRuleSubtreeStream stream_statementOrStatementBlock=new RewriteRuleSubtreeStream(adaptor,"rule statementOrStatementBlock");
        RewriteRuleSubtreeStream stream_formalParameter=new RewriteRuleSubtreeStream(adaptor,"rule formalParameter");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:227:2: ( 'for' '(' formalParameter 'in' logicalExpression ')' statementOrStatementBlock -> ^( FOR formalParameter logicalExpression statementOrStatementBlock ) )
            // EolParserRules.g:227:4: 'for' '(' formalParameter 'in' logicalExpression ')' statementOrStatementBlock
            {
            string_literal77=(Token)match(input,93,FOLLOW_93_in_forStatement885); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_93.add(string_literal77);

            char_literal78=(Token)match(input,78,FOLLOW_78_in_forStatement887); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_78.add(char_literal78);

            pushFollow(FOLLOW_formalParameter_in_forStatement889);
            formalParameter79=formalParameter();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_formalParameter.add(formalParameter79.getTree());
            string_literal80=(Token)match(input,94,FOLLOW_94_in_forStatement891); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_94.add(string_literal80);

            pushFollow(FOLLOW_logicalExpression_in_forStatement893);
            logicalExpression81=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression81.getTree());
            char_literal82=(Token)match(input,79,FOLLOW_79_in_forStatement895); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_79.add(char_literal82);

            pushFollow(FOLLOW_statementOrStatementBlock_in_forStatement897);
            statementOrStatementBlock83=statementOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_statementOrStatementBlock.add(statementOrStatementBlock83.getTree());


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

        Token string_literal84=null;
        Token char_literal85=null;
        Token char_literal87=null;
        Ewl_EolParserRules.logicalExpression_return logicalExpression86 = null;

        Ewl_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock88 = null;

        Ewl_EolParserRules.elseStatement_return elseStatement89 = null;


        CommonTree string_literal84_tree=null;
        CommonTree char_literal85_tree=null;
        CommonTree char_literal87_tree=null;
        RewriteRuleTokenStream stream_79=new RewriteRuleTokenStream(adaptor,"token 79");
        RewriteRuleTokenStream stream_78=new RewriteRuleTokenStream(adaptor,"token 78");
        RewriteRuleTokenStream stream_95=new RewriteRuleTokenStream(adaptor,"token 95");
        RewriteRuleSubtreeStream stream_statementOrStatementBlock=new RewriteRuleSubtreeStream(adaptor,"rule statementOrStatementBlock");
        RewriteRuleSubtreeStream stream_elseStatement=new RewriteRuleSubtreeStream(adaptor,"rule elseStatement");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:232:2: ( 'if' '(' logicalExpression ')' statementOrStatementBlock ( elseStatement )? -> ^( IF logicalExpression statementOrStatementBlock ( elseStatement )? ) )
            // EolParserRules.g:232:4: 'if' '(' logicalExpression ')' statementOrStatementBlock ( elseStatement )?
            {
            string_literal84=(Token)match(input,95,FOLLOW_95_in_ifStatement921); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_95.add(string_literal84);

            char_literal85=(Token)match(input,78,FOLLOW_78_in_ifStatement923); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_78.add(char_literal85);

            pushFollow(FOLLOW_logicalExpression_in_ifStatement925);
            logicalExpression86=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression86.getTree());
            char_literal87=(Token)match(input,79,FOLLOW_79_in_ifStatement927); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_79.add(char_literal87);

            pushFollow(FOLLOW_statementOrStatementBlock_in_ifStatement929);
            statementOrStatementBlock88=statementOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_statementOrStatementBlock.add(statementOrStatementBlock88.getTree());
            // EolParserRules.g:232:61: ( elseStatement )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==96) ) {
                int LA25_1 = input.LA(2);

                if ( (synpred40_EolParserRules()) ) {
                    alt25=1;
                }
            }
            switch (alt25) {
                case 1 :
                    // EolParserRules.g:0:0: elseStatement
                    {
                    pushFollow(FOLLOW_elseStatement_in_ifStatement931);
                    elseStatement89=elseStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_elseStatement.add(elseStatement89.getTree());

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

        Token string_literal90=null;
        Ewl_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock91 = null;


        CommonTree string_literal90_tree=null;

        try {
            // EolParserRules.g:237:2: ( 'else' statementOrStatementBlock )
            // EolParserRules.g:237:4: 'else' statementOrStatementBlock
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal90=(Token)match(input,96,FOLLOW_96_in_elseStatement958); if (state.failed) return retval;
            pushFollow(FOLLOW_statementOrStatementBlock_in_elseStatement961);
            statementOrStatementBlock91=statementOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, statementOrStatementBlock91.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
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

        Token string_literal92=null;
        Token char_literal93=null;
        Token char_literal95=null;
        Ewl_EolParserRules.logicalExpression_return logicalExpression94 = null;

        Ewl_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock96 = null;


        CommonTree string_literal92_tree=null;
        CommonTree char_literal93_tree=null;
        CommonTree char_literal95_tree=null;
        RewriteRuleTokenStream stream_79=new RewriteRuleTokenStream(adaptor,"token 79");
        RewriteRuleTokenStream stream_97=new RewriteRuleTokenStream(adaptor,"token 97");
        RewriteRuleTokenStream stream_78=new RewriteRuleTokenStream(adaptor,"token 78");
        RewriteRuleSubtreeStream stream_statementOrStatementBlock=new RewriteRuleSubtreeStream(adaptor,"rule statementOrStatementBlock");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:242:2: ( 'while' '(' logicalExpression ')' statementOrStatementBlock -> ^( WHILE logicalExpression statementOrStatementBlock ) )
            // EolParserRules.g:242:4: 'while' '(' logicalExpression ')' statementOrStatementBlock
            {
            string_literal92=(Token)match(input,97,FOLLOW_97_in_whileStatement974); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_97.add(string_literal92);

            char_literal93=(Token)match(input,78,FOLLOW_78_in_whileStatement976); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_78.add(char_literal93);

            pushFollow(FOLLOW_logicalExpression_in_whileStatement978);
            logicalExpression94=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression94.getTree());
            char_literal95=(Token)match(input,79,FOLLOW_79_in_whileStatement980); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_79.add(char_literal95);

            pushFollow(FOLLOW_statementOrStatementBlock_in_whileStatement982);
            statementOrStatementBlock96=statementOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_statementOrStatementBlock.add(statementOrStatementBlock96.getTree());


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

        Token string_literal97=null;
        Token char_literal99=null;
        Ewl_EolParserRules.logicalExpression_return logicalExpression98 = null;


        CommonTree string_literal97_tree=null;
        CommonTree char_literal99_tree=null;
        RewriteRuleTokenStream stream_98=new RewriteRuleTokenStream(adaptor,"token 98");
        RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:247:2: ( 'return' ( logicalExpression )? ';' -> ^( RETURN ( logicalExpression )? ) )
            // EolParserRules.g:247:4: 'return' ( logicalExpression )? ';'
            {
            string_literal97=(Token)match(input,98,FOLLOW_98_in_returnStatement1004); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_98.add(string_literal97);

            // EolParserRules.g:247:13: ( logicalExpression )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==FLOAT||LA26_0==INT||LA26_0==BOOLEAN||LA26_0==STRING||LA26_0==NAME||LA26_0==78||(LA26_0>=87 && LA26_0<=92)||LA26_0==120||LA26_0==123||(LA26_0>=125 && LA26_0<=126)) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // EolParserRules.g:0:0: logicalExpression
                    {
                    pushFollow(FOLLOW_logicalExpression_in_returnStatement1006);
                    logicalExpression98=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression98.getTree());

                    }
                    break;

            }

            char_literal99=(Token)match(input,72,FOLLOW_72_in_returnStatement1009); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_72.add(char_literal99);



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

        Token string_literal100=null;
        Token char_literal102=null;
        Ewl_EolParserRules.logicalExpression_return logicalExpression101 = null;


        CommonTree string_literal100_tree=null;
        CommonTree char_literal102_tree=null;
        RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
        RewriteRuleTokenStream stream_99=new RewriteRuleTokenStream(adaptor,"token 99");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:252:2: ( 'throw' ( logicalExpression )? ';' -> ^( THROW ( logicalExpression )? ) )
            // EolParserRules.g:252:4: 'throw' ( logicalExpression )? ';'
            {
            string_literal100=(Token)match(input,99,FOLLOW_99_in_throwStatement1030); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_99.add(string_literal100);

            // EolParserRules.g:252:12: ( logicalExpression )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==FLOAT||LA27_0==INT||LA27_0==BOOLEAN||LA27_0==STRING||LA27_0==NAME||LA27_0==78||(LA27_0>=87 && LA27_0<=92)||LA27_0==120||LA27_0==123||(LA27_0>=125 && LA27_0<=126)) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // EolParserRules.g:0:0: logicalExpression
                    {
                    pushFollow(FOLLOW_logicalExpression_in_throwStatement1032);
                    logicalExpression101=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression101.getTree());

                    }
                    break;

            }

            char_literal102=(Token)match(input,72,FOLLOW_72_in_throwStatement1035); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_72.add(char_literal102);



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

        Token string_literal103=null;
        Token char_literal105=null;
        Ewl_EolParserRules.logicalExpression_return logicalExpression104 = null;


        CommonTree string_literal103_tree=null;
        CommonTree char_literal105_tree=null;
        RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
        RewriteRuleTokenStream stream_100=new RewriteRuleTokenStream(adaptor,"token 100");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:257:2: ( 'delete' ( logicalExpression )? ';' -> ^( DELETE ( logicalExpression )? ) )
            // EolParserRules.g:257:4: 'delete' ( logicalExpression )? ';'
            {
            string_literal103=(Token)match(input,100,FOLLOW_100_in_deleteStatement1056); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_100.add(string_literal103);

            // EolParserRules.g:257:13: ( logicalExpression )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==FLOAT||LA28_0==INT||LA28_0==BOOLEAN||LA28_0==STRING||LA28_0==NAME||LA28_0==78||(LA28_0>=87 && LA28_0<=92)||LA28_0==120||LA28_0==123||(LA28_0>=125 && LA28_0<=126)) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // EolParserRules.g:0:0: logicalExpression
                    {
                    pushFollow(FOLLOW_logicalExpression_in_deleteStatement1058);
                    logicalExpression104=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression104.getTree());

                    }
                    break;

            }

            char_literal105=(Token)match(input,72,FOLLOW_72_in_deleteStatement1061); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_72.add(char_literal105);



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

        Token string_literal106=null;
        Token char_literal107=null;

        CommonTree string_literal106_tree=null;
        CommonTree char_literal107_tree=null;
        RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
        RewriteRuleTokenStream stream_101=new RewriteRuleTokenStream(adaptor,"token 101");

        try {
            // EolParserRules.g:262:2: ( 'break' ';' -> ^( BREAK ) )
            // EolParserRules.g:262:4: 'break' ';'
            {
            string_literal106=(Token)match(input,101,FOLLOW_101_in_breakStatement1085); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_101.add(string_literal106);

            char_literal107=(Token)match(input,72,FOLLOW_72_in_breakStatement1087); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_72.add(char_literal107);



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

        Token string_literal108=null;
        Token char_literal109=null;

        CommonTree string_literal108_tree=null;
        CommonTree char_literal109_tree=null;
        RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
        RewriteRuleTokenStream stream_102=new RewriteRuleTokenStream(adaptor,"token 102");

        try {
            // EolParserRules.g:267:2: ( 'breakAll' ';' -> ^( BREAKALL ) )
            // EolParserRules.g:267:4: 'breakAll' ';'
            {
            string_literal108=(Token)match(input,102,FOLLOW_102_in_breakAllStatement1105); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_102.add(string_literal108);

            char_literal109=(Token)match(input,72,FOLLOW_72_in_breakAllStatement1107); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_72.add(char_literal109);



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

        Token string_literal110=null;
        Token char_literal111=null;

        CommonTree string_literal110_tree=null;
        CommonTree char_literal111_tree=null;
        RewriteRuleTokenStream stream_103=new RewriteRuleTokenStream(adaptor,"token 103");
        RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");

        try {
            // EolParserRules.g:272:2: ( 'continue' ';' -> ^( CONTINUE ) )
            // EolParserRules.g:272:4: 'continue' ';'
            {
            string_literal110=(Token)match(input,103,FOLLOW_103_in_continueStatement1125); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_103.add(string_literal110);

            char_literal111=(Token)match(input,72,FOLLOW_72_in_continueStatement1127); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_72.add(char_literal111);



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

        Token string_literal112=null;
        Token char_literal113=null;

        CommonTree string_literal112_tree=null;
        CommonTree char_literal113_tree=null;
        RewriteRuleTokenStream stream_104=new RewriteRuleTokenStream(adaptor,"token 104");
        RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");

        try {
            // EolParserRules.g:277:2: ( 'abort' ';' -> ^( ABORT ) )
            // EolParserRules.g:277:4: 'abort' ';'
            {
            string_literal112=(Token)match(input,104,FOLLOW_104_in_abortStatement1145); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_104.add(string_literal112);

            char_literal113=(Token)match(input,72,FOLLOW_72_in_abortStatement1147); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_72.add(char_literal113);



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

        Token string_literal114=null;
        Token NAME115=null;
        Token char_literal116=null;
        Token NAME117=null;
        Ewl_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock118 = null;


        CommonTree string_literal114_tree=null;
        CommonTree NAME115_tree=null;
        CommonTree char_literal116_tree=null;
        CommonTree NAME117_tree=null;
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_105=new RewriteRuleTokenStream(adaptor,"token 105");
        RewriteRuleTokenStream stream_74=new RewriteRuleTokenStream(adaptor,"token 74");
        RewriteRuleSubtreeStream stream_statementOrStatementBlock=new RewriteRuleSubtreeStream(adaptor,"rule statementOrStatementBlock");
        try {
            // EolParserRules.g:282:2: ( 'transaction' ( NAME ( ',' NAME )* )? statementOrStatementBlock -> ^( TRANSACTION ( NAME )* statementOrStatementBlock ) )
            // EolParserRules.g:282:4: 'transaction' ( NAME ( ',' NAME )* )? statementOrStatementBlock
            {
            string_literal114=(Token)match(input,105,FOLLOW_105_in_transactionStatement1165); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_105.add(string_literal114);

            // EolParserRules.g:282:18: ( NAME ( ',' NAME )* )?
            int alt30=2;
            alt30 = dfa30.predict(input);
            switch (alt30) {
                case 1 :
                    // EolParserRules.g:282:19: NAME ( ',' NAME )*
                    {
                    NAME115=(Token)match(input,NAME,FOLLOW_NAME_in_transactionStatement1168); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NAME.add(NAME115);

                    // EolParserRules.g:282:24: ( ',' NAME )*
                    loop29:
                    do {
                        int alt29=2;
                        int LA29_0 = input.LA(1);

                        if ( (LA29_0==74) ) {
                            alt29=1;
                        }


                        switch (alt29) {
                    	case 1 :
                    	    // EolParserRules.g:282:25: ',' NAME
                    	    {
                    	    char_literal116=(Token)match(input,74,FOLLOW_74_in_transactionStatement1171); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_74.add(char_literal116);

                    	    NAME117=(Token)match(input,NAME,FOLLOW_NAME_in_transactionStatement1173); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_NAME.add(NAME117);


                    	    }
                    	    break;

                    	default :
                    	    break loop29;
                        }
                    } while (true);


                    }
                    break;

            }

            pushFollow(FOLLOW_statementOrStatementBlock_in_transactionStatement1179);
            statementOrStatementBlock118=statementOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_statementOrStatementBlock.add(statementOrStatementBlock118.getTree());


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
        Token char_literal121=null;
        Ewl_EolParserRules.logicalExpression_return logicalExpression119 = null;

        Ewl_EolParserRules.logicalExpression_return logicalExpression120 = null;


        CommonTree normal_tree=null;
        CommonTree special_tree=null;
        CommonTree char_literal121_tree=null;

        try {
            // EolParserRules.g:291:2: ( logicalExpression (normal= ':=' | special= '::=' ) logicalExpression ';' )
            // EolParserRules.g:291:4: logicalExpression (normal= ':=' | special= '::=' ) logicalExpression ';'
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_logicalExpression_in_assignmentStatement1208);
            logicalExpression119=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression119.getTree());
            // EolParserRules.g:291:22: (normal= ':=' | special= '::=' )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==106) ) {
                alt31=1;
            }
            else if ( (LA31_0==107) ) {
                alt31=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }
            switch (alt31) {
                case 1 :
                    // EolParserRules.g:291:23: normal= ':='
                    {
                    normal=(Token)match(input,106,FOLLOW_106_in_assignmentStatement1213); if (state.failed) return retval;
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
                    special=(Token)match(input,107,FOLLOW_107_in_assignmentStatement1220); if (state.failed) return retval;
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

            pushFollow(FOLLOW_logicalExpression_in_assignmentStatement1226);
            logicalExpression120=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression120.getTree());
            char_literal121=(Token)match(input,72,FOLLOW_72_in_assignmentStatement1228); if (state.failed) return retval;

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

        Token char_literal123=null;
        Ewl_EolParserRules.logicalExpression_return logicalExpression122 = null;


        CommonTree char_literal123_tree=null;

        try {
            // EolParserRules.g:296:2: ( logicalExpression ';' )
            // EolParserRules.g:296:4: logicalExpression ';'
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_logicalExpression_in_expressionStatement1243);
            logicalExpression122=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression122.getTree());
            char_literal123=(Token)match(input,72,FOLLOW_72_in_expressionStatement1245); if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
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

        Token set125=null;
        Ewl_EolParserRules.relationalExpression_return relationalExpression124 = null;

        Ewl_EolParserRules.relationalExpression_return relationalExpression126 = null;


        CommonTree set125_tree=null;

        try {
            // EolParserRules.g:300:2: ( relationalExpression ( ( 'or' | 'and' | 'xor' | 'implies' ) relationalExpression )* )
            // EolParserRules.g:300:4: relationalExpression ( ( 'or' | 'and' | 'xor' | 'implies' ) relationalExpression )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_relationalExpression_in_logicalExpression1257);
            relationalExpression124=relationalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, relationalExpression124.getTree());
            // EolParserRules.g:300:25: ( ( 'or' | 'and' | 'xor' | 'implies' ) relationalExpression )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( ((LA32_0>=108 && LA32_0<=111)) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // EolParserRules.g:300:26: ( 'or' | 'and' | 'xor' | 'implies' ) relationalExpression
            	    {
            	    set125=(Token)input.LT(1);
            	    set125=(Token)input.LT(1);
            	    if ( (input.LA(1)>=108 && input.LA(1)<=111) ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(set125), root_0);
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_relationalExpression_in_logicalExpression1271);
            	    relationalExpression126=relationalExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, relationalExpression126.getTree());
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
    // $ANTLR end logicalExpression

    public static class relationalExpression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start relationalExpression
    // EolParserRules.g:304:1: relationalExpression : additiveExpression ( ( '==' ( relationalExpression )? | '=' ( relationalExpression )? | ( '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression ) )* ;
    public final Ewl_EolParserRules.relationalExpression_return relationalExpression() throws RecognitionException {
        Ewl_EolParserRules.relationalExpression_return retval = new Ewl_EolParserRules.relationalExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal128=null;
        Token char_literal130=null;
        Token set132=null;
        Ewl_EolParserRules.additiveExpression_return additiveExpression127 = null;

        Ewl_EolParserRules.relationalExpression_return relationalExpression129 = null;

        Ewl_EolParserRules.relationalExpression_return relationalExpression131 = null;

        Ewl_EolParserRules.additiveExpression_return additiveExpression133 = null;


        CommonTree string_literal128_tree=null;
        CommonTree char_literal130_tree=null;
        CommonTree set132_tree=null;

        try {
            // EolParserRules.g:305:2: ( additiveExpression ( ( '==' ( relationalExpression )? | '=' ( relationalExpression )? | ( '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression ) )* )
            // EolParserRules.g:305:4: additiveExpression ( ( '==' ( relationalExpression )? | '=' ( relationalExpression )? | ( '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression ) )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_additiveExpression_in_relationalExpression1288);
            additiveExpression127=additiveExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, additiveExpression127.getTree());
            // EolParserRules.g:305:23: ( ( '==' ( relationalExpression )? | '=' ( relationalExpression )? | ( '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression ) )*
            loop36:
            do {
                int alt36=2;
                switch ( input.LA(1) ) {
                case 112:
                    {
                    int LA36_2 = input.LA(2);

                    if ( (synpred59_EolParserRules()) ) {
                        alt36=1;
                    }


                    }
                    break;
                case 113:
                    {
                    int LA36_3 = input.LA(2);

                    if ( (synpred59_EolParserRules()) ) {
                        alt36=1;
                    }


                    }
                    break;
                case 114:
                case 115:
                case 116:
                case 117:
                case 118:
                    {
                    int LA36_4 = input.LA(2);

                    if ( (synpred59_EolParserRules()) ) {
                        alt36=1;
                    }


                    }
                    break;

                }

                switch (alt36) {
            	case 1 :
            	    // EolParserRules.g:305:24: ( '==' ( relationalExpression )? | '=' ( relationalExpression )? | ( '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression )
            	    {
            	    // EolParserRules.g:305:24: ( '==' ( relationalExpression )? | '=' ( relationalExpression )? | ( '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression )
            	    int alt35=3;
            	    switch ( input.LA(1) ) {
            	    case 112:
            	        {
            	        alt35=1;
            	        }
            	        break;
            	    case 113:
            	        {
            	        alt35=2;
            	        }
            	        break;
            	    case 114:
            	    case 115:
            	    case 116:
            	    case 117:
            	    case 118:
            	        {
            	        alt35=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 35, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt35) {
            	        case 1 :
            	            // EolParserRules.g:305:25: '==' ( relationalExpression )?
            	            {
            	            string_literal128=(Token)match(input,112,FOLLOW_112_in_relationalExpression1292); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            string_literal128_tree = (CommonTree)adaptor.create(string_literal128);
            	            root_0 = (CommonTree)adaptor.becomeRoot(string_literal128_tree, root_0);
            	            }
            	            // EolParserRules.g:305:31: ( relationalExpression )?
            	            int alt33=2;
            	            int LA33_0 = input.LA(1);

            	            if ( (LA33_0==FLOAT||LA33_0==INT||LA33_0==BOOLEAN||LA33_0==STRING||LA33_0==NAME||LA33_0==78||(LA33_0>=87 && LA33_0<=92)||LA33_0==120||LA33_0==123||(LA33_0>=125 && LA33_0<=126)) ) {
            	                alt33=1;
            	            }
            	            switch (alt33) {
            	                case 1 :
            	                    // EolParserRules.g:0:0: relationalExpression
            	                    {
            	                    pushFollow(FOLLOW_relationalExpression_in_relationalExpression1295);
            	                    relationalExpression129=relationalExpression();

            	                    state._fsp--;
            	                    if (state.failed) return retval;
            	                    if ( state.backtracking==0 ) adaptor.addChild(root_0, relationalExpression129.getTree());

            	                    }
            	                    break;

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // EolParserRules.g:305:55: '=' ( relationalExpression )?
            	            {
            	            char_literal130=(Token)match(input,113,FOLLOW_113_in_relationalExpression1300); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal130_tree = (CommonTree)adaptor.create(char_literal130);
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal130_tree, root_0);
            	            }
            	            // EolParserRules.g:305:60: ( relationalExpression )?
            	            int alt34=2;
            	            int LA34_0 = input.LA(1);

            	            if ( (LA34_0==FLOAT||LA34_0==INT||LA34_0==BOOLEAN||LA34_0==STRING||LA34_0==NAME||LA34_0==78||(LA34_0>=87 && LA34_0<=92)||LA34_0==120||LA34_0==123||(LA34_0>=125 && LA34_0<=126)) ) {
            	                alt34=1;
            	            }
            	            switch (alt34) {
            	                case 1 :
            	                    // EolParserRules.g:0:0: relationalExpression
            	                    {
            	                    pushFollow(FOLLOW_relationalExpression_in_relationalExpression1303);
            	                    relationalExpression131=relationalExpression();

            	                    state._fsp--;
            	                    if (state.failed) return retval;
            	                    if ( state.backtracking==0 ) adaptor.addChild(root_0, relationalExpression131.getTree());

            	                    }
            	                    break;

            	            }


            	            }
            	            break;
            	        case 3 :
            	            // EolParserRules.g:306:24: ( '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression
            	            {
            	            set132=(Token)input.LT(1);
            	            set132=(Token)input.LT(1);
            	            if ( (input.LA(1)>=114 && input.LA(1)<=118) ) {
            	                input.consume();
            	                if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(set132), root_0);
            	                state.errorRecovery=false;state.failed=false;
            	            }
            	            else {
            	                if (state.backtracking>0) {state.failed=true; return retval;}
            	                MismatchedSetException mse = new MismatchedSetException(null,input);
            	                throw mse;
            	            }

            	            pushFollow(FOLLOW_additiveExpression_in_relationalExpression1344);
            	            additiveExpression133=additiveExpression();

            	            state._fsp--;
            	            if (state.failed) return retval;
            	            if ( state.backtracking==0 ) adaptor.addChild(root_0, additiveExpression133.getTree());

            	            }
            	            break;

            	    }

            	    if ( state.backtracking==0 ) {
            	      if (root_0.getToken() != null) root_0.getToken().setType(OPERATOR);
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
    // $ANTLR end relationalExpression

    public static class additiveExpression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start additiveExpression
    // EolParserRules.g:310:1: additiveExpression : multiplicativeExpression ( ( '+' | '-' ) multiplicativeExpression )* ;
    public final Ewl_EolParserRules.additiveExpression_return additiveExpression() throws RecognitionException {
        Ewl_EolParserRules.additiveExpression_return retval = new Ewl_EolParserRules.additiveExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set135=null;
        Ewl_EolParserRules.multiplicativeExpression_return multiplicativeExpression134 = null;

        Ewl_EolParserRules.multiplicativeExpression_return multiplicativeExpression136 = null;


        CommonTree set135_tree=null;

        try {
            // EolParserRules.g:311:2: ( multiplicativeExpression ( ( '+' | '-' ) multiplicativeExpression )* )
            // EolParserRules.g:311:4: multiplicativeExpression ( ( '+' | '-' ) multiplicativeExpression )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_multiplicativeExpression_in_additiveExpression1362);
            multiplicativeExpression134=multiplicativeExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, multiplicativeExpression134.getTree());
            // EolParserRules.g:311:29: ( ( '+' | '-' ) multiplicativeExpression )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( ((LA37_0>=119 && LA37_0<=120)) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // EolParserRules.g:311:30: ( '+' | '-' ) multiplicativeExpression
            	    {
            	    set135=(Token)input.LT(1);
            	    set135=(Token)input.LT(1);
            	    if ( (input.LA(1)>=119 && input.LA(1)<=120) ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(set135), root_0);
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_multiplicativeExpression_in_additiveExpression1372);
            	    multiplicativeExpression136=multiplicativeExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, multiplicativeExpression136.getTree());
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
    // $ANTLR end additiveExpression

    public static class multiplicativeExpression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start multiplicativeExpression
    // EolParserRules.g:316:1: multiplicativeExpression : unaryExpression ( ( '*' | '/' ) unaryExpression )* ;
    public final Ewl_EolParserRules.multiplicativeExpression_return multiplicativeExpression() throws RecognitionException {
        Ewl_EolParserRules.multiplicativeExpression_return retval = new Ewl_EolParserRules.multiplicativeExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set138=null;
        Ewl_EolParserRules.unaryExpression_return unaryExpression137 = null;

        Ewl_EolParserRules.unaryExpression_return unaryExpression139 = null;


        CommonTree set138_tree=null;

        try {
            // EolParserRules.g:317:2: ( unaryExpression ( ( '*' | '/' ) unaryExpression )* )
            // EolParserRules.g:317:4: unaryExpression ( ( '*' | '/' ) unaryExpression )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_unaryExpression_in_multiplicativeExpression1393);
            unaryExpression137=unaryExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, unaryExpression137.getTree());
            // EolParserRules.g:317:20: ( ( '*' | '/' ) unaryExpression )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( ((LA38_0>=121 && LA38_0<=122)) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // EolParserRules.g:317:21: ( '*' | '/' ) unaryExpression
            	    {
            	    set138=(Token)input.LT(1);
            	    set138=(Token)input.LT(1);
            	    if ( (input.LA(1)>=121 && input.LA(1)<=122) ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(set138), root_0);
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_unaryExpression_in_multiplicativeExpression1403);
            	    unaryExpression139=unaryExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, unaryExpression139.getTree());
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
    // $ANTLR end multiplicativeExpression

    public static class unaryExpression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start unaryExpression
    // EolParserRules.g:321:1: unaryExpression : ( ( 'not' | '-' ) )? postfixExpression ;
    public final Ewl_EolParserRules.unaryExpression_return unaryExpression() throws RecognitionException {
        Ewl_EolParserRules.unaryExpression_return retval = new Ewl_EolParserRules.unaryExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set140=null;
        Ewl_EolParserRules.postfixExpression_return postfixExpression141 = null;


        CommonTree set140_tree=null;

        try {
            // EolParserRules.g:322:2: ( ( ( 'not' | '-' ) )? postfixExpression )
            // EolParserRules.g:322:4: ( ( 'not' | '-' ) )? postfixExpression
            {
            root_0 = (CommonTree)adaptor.nil();

            // EolParserRules.g:322:4: ( ( 'not' | '-' ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==120||LA39_0==123) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // EolParserRules.g:322:5: ( 'not' | '-' )
                    {
                    set140=(Token)input.LT(1);
                    set140=(Token)input.LT(1);
                    if ( input.LA(1)==120||input.LA(1)==123 ) {
                        input.consume();
                        if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(set140), root_0);
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

            pushFollow(FOLLOW_postfixExpression_in_unaryExpression1430);
            postfixExpression141=postfixExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, postfixExpression141.getTree());
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
    // EolParserRules.g:326:1: postfixExpression : primitiveExpression ( ( POINT | ARROW ) fc= featureCall )* ;
    public final Ewl_EolParserRules.postfixExpression_return postfixExpression() throws RecognitionException {
        Ewl_EolParserRules.postfixExpression_return retval = new Ewl_EolParserRules.postfixExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set143=null;
        Ewl_EolParserRules.featureCall_return fc = null;

        Ewl_EolParserRules.primitiveExpression_return primitiveExpression142 = null;


        CommonTree set143_tree=null;

        try {
            // EolParserRules.g:327:2: ( primitiveExpression ( ( POINT | ARROW ) fc= featureCall )* )
            // EolParserRules.g:327:4: primitiveExpression ( ( POINT | ARROW ) fc= featureCall )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_primitiveExpression_in_postfixExpression1445);
            primitiveExpression142=primitiveExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, primitiveExpression142.getTree());
            // EolParserRules.g:327:23: ( ( POINT | ARROW ) fc= featureCall )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==POINT||LA40_0==ARROW) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // EolParserRules.g:327:24: ( POINT | ARROW ) fc= featureCall
            	    {
            	    set143=(Token)input.LT(1);
            	    set143=(Token)input.LT(1);
            	    if ( input.LA(1)==POINT||input.LA(1)==ARROW ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(set143), root_0);
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_featureCall_in_postfixExpression1456);
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
    // $ANTLR end postfixExpression

    public static class featureCall_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start featureCall
    // EolParserRules.g:337:1: featureCall : ( simpleFeatureCall | declarativeFeatureCall );
    public final Ewl_EolParserRules.featureCall_return featureCall() throws RecognitionException {
        Ewl_EolParserRules.featureCall_return retval = new Ewl_EolParserRules.featureCall_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Ewl_EolParserRules.simpleFeatureCall_return simpleFeatureCall144 = null;

        Ewl_EolParserRules.declarativeFeatureCall_return declarativeFeatureCall145 = null;



        try {
            // EolParserRules.g:338:2: ( simpleFeatureCall | declarativeFeatureCall )
            int alt41=2;
            alt41 = dfa41.predict(input);
            switch (alt41) {
                case 1 :
                    // EolParserRules.g:338:4: simpleFeatureCall
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_simpleFeatureCall_in_featureCall1491);
                    simpleFeatureCall144=simpleFeatureCall();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, simpleFeatureCall144.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:338:24: declarativeFeatureCall
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_declarativeFeatureCall_in_featureCall1495);
                    declarativeFeatureCall145=declarativeFeatureCall();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, declarativeFeatureCall145.getTree());

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
    // EolParserRules.g:341:1: simpleFeatureCall : NAME ( parameterList )? ;
    public final Ewl_EolParserRules.simpleFeatureCall_return simpleFeatureCall() throws RecognitionException {
        Ewl_EolParserRules.simpleFeatureCall_return retval = new Ewl_EolParserRules.simpleFeatureCall_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NAME146=null;
        Ewl_EolParserRules.parameterList_return parameterList147 = null;


        CommonTree NAME146_tree=null;

        try {
            // EolParserRules.g:342:2: ( NAME ( parameterList )? )
            // EolParserRules.g:342:5: NAME ( parameterList )?
            {
            root_0 = (CommonTree)adaptor.nil();

            NAME146=(Token)match(input,NAME,FOLLOW_NAME_in_simpleFeatureCall1507); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME146_tree = (CommonTree)adaptor.create(NAME146);
            root_0 = (CommonTree)adaptor.becomeRoot(NAME146_tree, root_0);
            }
            // EolParserRules.g:342:11: ( parameterList )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==78) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // EolParserRules.g:0:0: parameterList
                    {
                    pushFollow(FOLLOW_parameterList_in_simpleFeatureCall1510);
                    parameterList147=parameterList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, parameterList147.getTree());

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
    // EolParserRules.g:346:1: parameterList : '(' ( logicalExpression ( ',' logicalExpression )* )? ')' -> ^( PARAMETERS ( logicalExpression )* ) ;
    public final Ewl_EolParserRules.parameterList_return parameterList() throws RecognitionException {
        Ewl_EolParserRules.parameterList_return retval = new Ewl_EolParserRules.parameterList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal148=null;
        Token char_literal150=null;
        Token char_literal152=null;
        Ewl_EolParserRules.logicalExpression_return logicalExpression149 = null;

        Ewl_EolParserRules.logicalExpression_return logicalExpression151 = null;


        CommonTree char_literal148_tree=null;
        CommonTree char_literal150_tree=null;
        CommonTree char_literal152_tree=null;
        RewriteRuleTokenStream stream_79=new RewriteRuleTokenStream(adaptor,"token 79");
        RewriteRuleTokenStream stream_78=new RewriteRuleTokenStream(adaptor,"token 78");
        RewriteRuleTokenStream stream_74=new RewriteRuleTokenStream(adaptor,"token 74");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:347:2: ( '(' ( logicalExpression ( ',' logicalExpression )* )? ')' -> ^( PARAMETERS ( logicalExpression )* ) )
            // EolParserRules.g:347:4: '(' ( logicalExpression ( ',' logicalExpression )* )? ')'
            {
            char_literal148=(Token)match(input,78,FOLLOW_78_in_parameterList1525); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_78.add(char_literal148);

            // EolParserRules.g:347:8: ( logicalExpression ( ',' logicalExpression )* )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==FLOAT||LA44_0==INT||LA44_0==BOOLEAN||LA44_0==STRING||LA44_0==NAME||LA44_0==78||(LA44_0>=87 && LA44_0<=92)||LA44_0==120||LA44_0==123||(LA44_0>=125 && LA44_0<=126)) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // EolParserRules.g:347:9: logicalExpression ( ',' logicalExpression )*
                    {
                    pushFollow(FOLLOW_logicalExpression_in_parameterList1528);
                    logicalExpression149=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression149.getTree());
                    // EolParserRules.g:347:27: ( ',' logicalExpression )*
                    loop43:
                    do {
                        int alt43=2;
                        int LA43_0 = input.LA(1);

                        if ( (LA43_0==74) ) {
                            alt43=1;
                        }


                        switch (alt43) {
                    	case 1 :
                    	    // EolParserRules.g:347:28: ',' logicalExpression
                    	    {
                    	    char_literal150=(Token)match(input,74,FOLLOW_74_in_parameterList1531); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_74.add(char_literal150);

                    	    pushFollow(FOLLOW_logicalExpression_in_parameterList1533);
                    	    logicalExpression151=logicalExpression();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression151.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop43;
                        }
                    } while (true);


                    }
                    break;

            }

            char_literal152=(Token)match(input,79,FOLLOW_79_in_parameterList1539); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_79.add(char_literal152);



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
            // 348:3: -> ^( PARAMETERS ( logicalExpression )* )
            {
                // EolParserRules.g:348:6: ^( PARAMETERS ( logicalExpression )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PARAMETERS, "PARAMETERS"), root_1);

                // EolParserRules.g:348:19: ( logicalExpression )*
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
    // EolParserRules.g:351:1: declarativeFeatureCall : NAME '(' formalParameterList '|' logicalExpression ( ',' logicalExpression )* ')' ;
    public final Ewl_EolParserRules.declarativeFeatureCall_return declarativeFeatureCall() throws RecognitionException {
        Ewl_EolParserRules.declarativeFeatureCall_return retval = new Ewl_EolParserRules.declarativeFeatureCall_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NAME153=null;
        Token char_literal154=null;
        Token char_literal156=null;
        Token char_literal158=null;
        Token char_literal160=null;
        Ewl_EolParserRules.formalParameterList_return formalParameterList155 = null;

        Ewl_EolParserRules.logicalExpression_return logicalExpression157 = null;

        Ewl_EolParserRules.logicalExpression_return logicalExpression159 = null;


        CommonTree NAME153_tree=null;
        CommonTree char_literal154_tree=null;
        CommonTree char_literal156_tree=null;
        CommonTree char_literal158_tree=null;
        CommonTree char_literal160_tree=null;

        try {
            // EolParserRules.g:352:2: ( NAME '(' formalParameterList '|' logicalExpression ( ',' logicalExpression )* ')' )
            // EolParserRules.g:352:4: NAME '(' formalParameterList '|' logicalExpression ( ',' logicalExpression )* ')'
            {
            root_0 = (CommonTree)adaptor.nil();

            NAME153=(Token)match(input,NAME,FOLLOW_NAME_in_declarativeFeatureCall1561); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME153_tree = (CommonTree)adaptor.create(NAME153);
            root_0 = (CommonTree)adaptor.becomeRoot(NAME153_tree, root_0);
            }
            char_literal154=(Token)match(input,78,FOLLOW_78_in_declarativeFeatureCall1564); if (state.failed) return retval;
            pushFollow(FOLLOW_formalParameterList_in_declarativeFeatureCall1567);
            formalParameterList155=formalParameterList();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, formalParameterList155.getTree());
            char_literal156=(Token)match(input,124,FOLLOW_124_in_declarativeFeatureCall1569); if (state.failed) return retval;
            pushFollow(FOLLOW_logicalExpression_in_declarativeFeatureCall1572);
            logicalExpression157=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression157.getTree());
            // EolParserRules.g:352:58: ( ',' logicalExpression )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==74) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // EolParserRules.g:352:59: ',' logicalExpression
            	    {
            	    char_literal158=(Token)match(input,74,FOLLOW_74_in_declarativeFeatureCall1575); if (state.failed) return retval;
            	    pushFollow(FOLLOW_logicalExpression_in_declarativeFeatureCall1578);
            	    logicalExpression159=logicalExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression159.getTree());

            	    }
            	    break;

            	default :
            	    break loop45;
                }
            } while (true);

            char_literal160=(Token)match(input,79,FOLLOW_79_in_declarativeFeatureCall1582); if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
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
    // EolParserRules.g:355:1: newExpression : 'new' tn= typeName ( parameterList )? ;
    public final Ewl_EolParserRules.newExpression_return newExpression() throws RecognitionException {
        Ewl_EolParserRules.newExpression_return retval = new Ewl_EolParserRules.newExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal161=null;
        Ewl_EolParserRules.typeName_return tn = null;

        Ewl_EolParserRules.parameterList_return parameterList162 = null;


        CommonTree string_literal161_tree=null;

        try {
            // EolParserRules.g:356:2: ( 'new' tn= typeName ( parameterList )? )
            // EolParserRules.g:356:4: 'new' tn= typeName ( parameterList )?
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal161=(Token)match(input,125,FOLLOW_125_in_newExpression1594); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal161_tree = (CommonTree)adaptor.create(string_literal161);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal161_tree, root_0);
            }
            pushFollow(FOLLOW_typeName_in_newExpression1599);
            tn=typeName();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, tn.getTree());
            if ( state.backtracking==0 ) {
              setTokenType(tn,TYPE);
            }
            // EolParserRules.g:356:48: ( parameterList )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==78) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // EolParserRules.g:0:0: parameterList
                    {
                    pushFollow(FOLLOW_parameterList_in_newExpression1603);
                    parameterList162=parameterList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, parameterList162.getTree());

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
    // EolParserRules.g:362:1: variableDeclarationExpression : 'var' NAME ( ':' (n= 'new' )? t= typeName ( parameterList )? )? -> ^( VAR NAME ( typeName )? ( parameterList )? ) ;
    public final Ewl_EolParserRules.variableDeclarationExpression_return variableDeclarationExpression() throws RecognitionException {
        Ewl_EolParserRules.variableDeclarationExpression_return retval = new Ewl_EolParserRules.variableDeclarationExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token n=null;
        Token string_literal163=null;
        Token NAME164=null;
        Token char_literal165=null;
        Ewl_EolParserRules.typeName_return t = null;

        Ewl_EolParserRules.parameterList_return parameterList166 = null;


        CommonTree n_tree=null;
        CommonTree string_literal163_tree=null;
        CommonTree NAME164_tree=null;
        CommonTree char_literal165_tree=null;
        RewriteRuleTokenStream stream_125=new RewriteRuleTokenStream(adaptor,"token 125");
        RewriteRuleTokenStream stream_126=new RewriteRuleTokenStream(adaptor,"token 126");
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_73=new RewriteRuleTokenStream(adaptor,"token 73");
        RewriteRuleSubtreeStream stream_typeName=new RewriteRuleSubtreeStream(adaptor,"rule typeName");
        RewriteRuleSubtreeStream stream_parameterList=new RewriteRuleSubtreeStream(adaptor,"rule parameterList");
        try {
            // EolParserRules.g:370:2: ( 'var' NAME ( ':' (n= 'new' )? t= typeName ( parameterList )? )? -> ^( VAR NAME ( typeName )? ( parameterList )? ) )
            // EolParserRules.g:370:4: 'var' NAME ( ':' (n= 'new' )? t= typeName ( parameterList )? )?
            {
            string_literal163=(Token)match(input,126,FOLLOW_126_in_variableDeclarationExpression1628); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_126.add(string_literal163);

            NAME164=(Token)match(input,NAME,FOLLOW_NAME_in_variableDeclarationExpression1630); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(NAME164);

            // EolParserRules.g:370:15: ( ':' (n= 'new' )? t= typeName ( parameterList )? )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==73) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // EolParserRules.g:370:16: ':' (n= 'new' )? t= typeName ( parameterList )?
                    {
                    char_literal165=(Token)match(input,73,FOLLOW_73_in_variableDeclarationExpression1633); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_73.add(char_literal165);

                    // EolParserRules.g:370:21: (n= 'new' )?
                    int alt47=2;
                    int LA47_0 = input.LA(1);

                    if ( (LA47_0==125) ) {
                        alt47=1;
                    }
                    switch (alt47) {
                        case 1 :
                            // EolParserRules.g:0:0: n= 'new'
                            {
                            n=(Token)match(input,125,FOLLOW_125_in_variableDeclarationExpression1637); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_125.add(n);


                            }
                            break;

                    }

                    pushFollow(FOLLOW_typeName_in_variableDeclarationExpression1642);
                    t=typeName();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_typeName.add(t.getTree());
                    if ( state.backtracking==0 ) {
                      setTokenType(t, TYPE);
                    }
                    // EolParserRules.g:370:65: ( parameterList )?
                    int alt48=2;
                    int LA48_0 = input.LA(1);

                    if ( (LA48_0==78) ) {
                        alt48=1;
                    }
                    switch (alt48) {
                        case 1 :
                            // EolParserRules.g:0:0: parameterList
                            {
                            pushFollow(FOLLOW_parameterList_in_variableDeclarationExpression1646);
                            parameterList166=parameterList();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_parameterList.add(parameterList166.getTree());

                            }
                            break;

                    }


                    }
                    break;

            }



            // AST REWRITE
            // elements: typeName, NAME, parameterList
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 371:2: -> ^( VAR NAME ( typeName )? ( parameterList )? )
            {
                // EolParserRules.g:371:5: ^( VAR NAME ( typeName )? ( parameterList )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VAR, "VAR"), root_1);

                adaptor.addChild(root_1, stream_NAME.nextNode());
                // EolParserRules.g:371:16: ( typeName )?
                if ( stream_typeName.hasNext() ) {
                    adaptor.addChild(root_1, stream_typeName.nextTree());

                }
                stream_typeName.reset();
                // EolParserRules.g:371:26: ( parameterList )?
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
    // EolParserRules.g:374:1: litteralCollection : ( 'Collection' | 'Sequence' | 'Bag' | 'Set' | 'OrderedSet' ) '{' ( expressionListOrRange )? '}' ;
    public final Ewl_EolParserRules.litteralCollection_return litteralCollection() throws RecognitionException {
        Ewl_EolParserRules.litteralCollection_return retval = new Ewl_EolParserRules.litteralCollection_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set167=null;
        Token char_literal168=null;
        Token char_literal170=null;
        Ewl_EolParserRules.expressionListOrRange_return expressionListOrRange169 = null;


        CommonTree set167_tree=null;
        CommonTree char_literal168_tree=null;
        CommonTree char_literal170_tree=null;

        try {
            // EolParserRules.g:375:2: ( ( 'Collection' | 'Sequence' | 'Bag' | 'Set' | 'OrderedSet' ) '{' ( expressionListOrRange )? '}' )
            // EolParserRules.g:375:4: ( 'Collection' | 'Sequence' | 'Bag' | 'Set' | 'OrderedSet' ) '{' ( expressionListOrRange )? '}'
            {
            root_0 = (CommonTree)adaptor.nil();

            set167=(Token)input.LT(1);
            set167=(Token)input.LT(1);
            if ( (input.LA(1)>=88 && input.LA(1)<=92) ) {
                input.consume();
                if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(set167), root_0);
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            char_literal168=(Token)match(input,81,FOLLOW_81_in_litteralCollection1689); if (state.failed) return retval;
            // EolParserRules.g:375:62: ( expressionListOrRange )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==FLOAT||LA50_0==INT||LA50_0==BOOLEAN||LA50_0==STRING||LA50_0==NAME||LA50_0==78||(LA50_0>=87 && LA50_0<=92)||LA50_0==120||LA50_0==123||(LA50_0>=125 && LA50_0<=126)) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // EolParserRules.g:0:0: expressionListOrRange
                    {
                    pushFollow(FOLLOW_expressionListOrRange_in_litteralCollection1693);
                    expressionListOrRange169=expressionListOrRange();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionListOrRange169.getTree());

                    }
                    break;

            }

            char_literal170=(Token)match(input,82,FOLLOW_82_in_litteralCollection1696); if (state.failed) return retval;
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
    // EolParserRules.g:379:1: expressionRange : logicalExpression '..' logicalExpression -> ^( EXPRRANGE ( logicalExpression )+ ) ;
    public final Ewl_EolParserRules.expressionRange_return expressionRange() throws RecognitionException {
        Ewl_EolParserRules.expressionRange_return retval = new Ewl_EolParserRules.expressionRange_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal172=null;
        Ewl_EolParserRules.logicalExpression_return logicalExpression171 = null;

        Ewl_EolParserRules.logicalExpression_return logicalExpression173 = null;


        CommonTree string_literal172_tree=null;
        RewriteRuleTokenStream stream_POINT_POINT=new RewriteRuleTokenStream(adaptor,"token POINT_POINT");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:380:2: ( logicalExpression '..' logicalExpression -> ^( EXPRRANGE ( logicalExpression )+ ) )
            // EolParserRules.g:380:4: logicalExpression '..' logicalExpression
            {
            pushFollow(FOLLOW_logicalExpression_in_expressionRange1711);
            logicalExpression171=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression171.getTree());
            string_literal172=(Token)match(input,POINT_POINT,FOLLOW_POINT_POINT_in_expressionRange1713); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_POINT_POINT.add(string_literal172);

            pushFollow(FOLLOW_logicalExpression_in_expressionRange1715);
            logicalExpression173=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression173.getTree());


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
            // 381:2: -> ^( EXPRRANGE ( logicalExpression )+ )
            {
                // EolParserRules.g:381:5: ^( EXPRRANGE ( logicalExpression )+ )
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
    // EolParserRules.g:384:1: expressionList : logicalExpression ( ',' logicalExpression )* -> ^( EXPRLIST ( logicalExpression )+ ) ;
    public final Ewl_EolParserRules.expressionList_return expressionList() throws RecognitionException {
        Ewl_EolParserRules.expressionList_return retval = new Ewl_EolParserRules.expressionList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal175=null;
        Ewl_EolParserRules.logicalExpression_return logicalExpression174 = null;

        Ewl_EolParserRules.logicalExpression_return logicalExpression176 = null;


        CommonTree char_literal175_tree=null;
        RewriteRuleTokenStream stream_74=new RewriteRuleTokenStream(adaptor,"token 74");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:385:2: ( logicalExpression ( ',' logicalExpression )* -> ^( EXPRLIST ( logicalExpression )+ ) )
            // EolParserRules.g:385:4: logicalExpression ( ',' logicalExpression )*
            {
            pushFollow(FOLLOW_logicalExpression_in_expressionList1737);
            logicalExpression174=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression174.getTree());
            // EolParserRules.g:385:22: ( ',' logicalExpression )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==74) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // EolParserRules.g:385:23: ',' logicalExpression
            	    {
            	    char_literal175=(Token)match(input,74,FOLLOW_74_in_expressionList1740); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_74.add(char_literal175);

            	    pushFollow(FOLLOW_logicalExpression_in_expressionList1742);
            	    logicalExpression176=logicalExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression176.getTree());

            	    }
            	    break;

            	default :
            	    break loop51;
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
            // 386:2: -> ^( EXPRLIST ( logicalExpression )+ )
            {
                // EolParserRules.g:386:5: ^( EXPRLIST ( logicalExpression )+ )
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
    // EolParserRules.g:389:1: expressionListOrRange : ( expressionRange | expressionList );
    public final Ewl_EolParserRules.expressionListOrRange_return expressionListOrRange() throws RecognitionException {
        Ewl_EolParserRules.expressionListOrRange_return retval = new Ewl_EolParserRules.expressionListOrRange_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Ewl_EolParserRules.expressionRange_return expressionRange177 = null;

        Ewl_EolParserRules.expressionList_return expressionList178 = null;



        try {
            // EolParserRules.g:390:2: ( expressionRange | expressionList )
            int alt52=2;
            alt52 = dfa52.predict(input);
            switch (alt52) {
                case 1 :
                    // EolParserRules.g:390:4: expressionRange
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_expressionRange_in_expressionListOrRange1766);
                    expressionRange177=expressionRange();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionRange177.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:390:22: expressionList
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_expressionList_in_expressionListOrRange1770);
                    expressionList178=expressionList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionList178.getTree());

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
    // EolParserRules.g:398:1: primitiveExpression : ( litteralCollection | literal | featureCall | pathName | nativeType | collectionType | '(' logicalExpression ')' | newExpression | variableDeclarationExpression );
    public final Ewl_EolParserRules.primitiveExpression_return primitiveExpression() throws RecognitionException {
        Ewl_EolParserRules.primitiveExpression_return retval = new Ewl_EolParserRules.primitiveExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal185=null;
        Token char_literal187=null;
        Ewl_EolParserRules.litteralCollection_return litteralCollection179 = null;

        Ewl_EolParserRules.literal_return literal180 = null;

        Ewl_EolParserRules.featureCall_return featureCall181 = null;

        Ewl_EolParserRules.pathName_return pathName182 = null;

        Ewl_EolParserRules.nativeType_return nativeType183 = null;

        Ewl_EolParserRules.collectionType_return collectionType184 = null;

        Ewl_EolParserRules.logicalExpression_return logicalExpression186 = null;

        Ewl_EolParserRules.newExpression_return newExpression188 = null;

        Ewl_EolParserRules.variableDeclarationExpression_return variableDeclarationExpression189 = null;


        CommonTree char_literal185_tree=null;
        CommonTree char_literal187_tree=null;

        try {
            // EolParserRules.g:399:2: ( litteralCollection | literal | featureCall | pathName | nativeType | collectionType | '(' logicalExpression ')' | newExpression | variableDeclarationExpression )
            int alt53=9;
            alt53 = dfa53.predict(input);
            switch (alt53) {
                case 1 :
                    // EolParserRules.g:399:4: litteralCollection
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_litteralCollection_in_primitiveExpression1792);
                    litteralCollection179=litteralCollection();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, litteralCollection179.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:399:25: literal
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_literal_in_primitiveExpression1796);
                    literal180=literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, literal180.getTree());

                    }
                    break;
                case 3 :
                    // EolParserRules.g:399:35: featureCall
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_featureCall_in_primitiveExpression1800);
                    featureCall181=featureCall();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, featureCall181.getTree());

                    }
                    break;
                case 4 :
                    // EolParserRules.g:399:49: pathName
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_pathName_in_primitiveExpression1804);
                    pathName182=pathName();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pathName182.getTree());

                    }
                    break;
                case 5 :
                    // EolParserRules.g:399:60: nativeType
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_nativeType_in_primitiveExpression1808);
                    nativeType183=nativeType();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nativeType183.getTree());

                    }
                    break;
                case 6 :
                    // EolParserRules.g:400:5: collectionType
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_collectionType_in_primitiveExpression1814);
                    collectionType184=collectionType();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, collectionType184.getTree());

                    }
                    break;
                case 7 :
                    // EolParserRules.g:400:23: '(' logicalExpression ')'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    char_literal185=(Token)match(input,78,FOLLOW_78_in_primitiveExpression1819); if (state.failed) return retval;
                    pushFollow(FOLLOW_logicalExpression_in_primitiveExpression1822);
                    logicalExpression186=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression186.getTree());
                    char_literal187=(Token)match(input,79,FOLLOW_79_in_primitiveExpression1824); if (state.failed) return retval;

                    }
                    break;
                case 8 :
                    // EolParserRules.g:401:5: newExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_newExpression_in_primitiveExpression1832);
                    newExpression188=newExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, newExpression188.getTree());

                    }
                    break;
                case 9 :
                    // EolParserRules.g:401:21: variableDeclarationExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_variableDeclarationExpression_in_primitiveExpression1836);
                    variableDeclarationExpression189=variableDeclarationExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, variableDeclarationExpression189.getTree());

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
    // EolParserRules.g:404:1: literal : ( STRING | INT | FLOAT | BOOLEAN );
    public final Ewl_EolParserRules.literal_return literal() throws RecognitionException {
        Ewl_EolParserRules.literal_return retval = new Ewl_EolParserRules.literal_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set190=null;

        CommonTree set190_tree=null;

        try {
            // EolParserRules.g:405:2: ( STRING | INT | FLOAT | BOOLEAN )
            // EolParserRules.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set190=(Token)input.LT(1);
            if ( input.LA(1)==FLOAT||input.LA(1)==INT||input.LA(1)==BOOLEAN||input.LA(1)==STRING ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set190));
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

    // $ANTLR start synpred14_EolParserRules
    public final void synpred14_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:153:4: ( annotation )
        // EolParserRules.g:153:4: annotation
        {
        pushFollow(FOLLOW_annotation_in_synpred14_EolParserRules562);
        annotation();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred14_EolParserRules

    // $ANTLR start synpred24_EolParserRules
    public final void synpred24_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:198:4: ( '(' typeName ')' )
        // EolParserRules.g:198:4: '(' typeName ')'
        {
        match(input,78,FOLLOW_78_in_synpred24_EolParserRules732); if (state.failed) return ;
        pushFollow(FOLLOW_typeName_in_synpred24_EolParserRules737);
        typeName();

        state._fsp--;
        if (state.failed) return ;
        match(input,79,FOLLOW_79_in_synpred24_EolParserRules740); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred24_EolParserRules

    // $ANTLR start synpred25_EolParserRules
    public final void synpred25_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:205:4: ( statementA )
        // EolParserRules.g:205:4: statementA
        {
        pushFollow(FOLLOW_statementA_in_synpred25_EolParserRules763);
        statementA();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred25_EolParserRules

    // $ANTLR start synpred26_EolParserRules
    public final void synpred26_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:209:3: ( assignmentStatement )
        // EolParserRules.g:209:3: assignmentStatement
        {
        pushFollow(FOLLOW_assignmentStatement_in_synpred26_EolParserRules777);
        assignmentStatement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred26_EolParserRules

    // $ANTLR start synpred27_EolParserRules
    public final void synpred27_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:209:25: ( expressionStatement )
        // EolParserRules.g:209:25: expressionStatement
        {
        pushFollow(FOLLOW_expressionStatement_in_synpred27_EolParserRules781);
        expressionStatement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred27_EolParserRules

    // $ANTLR start synpred40_EolParserRules
    public final void synpred40_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:232:61: ( elseStatement )
        // EolParserRules.g:232:61: elseStatement
        {
        pushFollow(FOLLOW_elseStatement_in_synpred40_EolParserRules931);
        elseStatement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred40_EolParserRules

    // $ANTLR start synpred45_EolParserRules
    public final void synpred45_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:282:19: ( NAME ( ',' NAME )* )
        // EolParserRules.g:282:19: NAME ( ',' NAME )*
        {
        match(input,NAME,FOLLOW_NAME_in_synpred45_EolParserRules1168); if (state.failed) return ;
        // EolParserRules.g:282:24: ( ',' NAME )*
        loop54:
        do {
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==74) ) {
                alt54=1;
            }


            switch (alt54) {
        	case 1 :
        	    // EolParserRules.g:282:25: ',' NAME
        	    {
        	    match(input,74,FOLLOW_74_in_synpred45_EolParserRules1171); if (state.failed) return ;
        	    match(input,NAME,FOLLOW_NAME_in_synpred45_EolParserRules1173); if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop54;
            }
        } while (true);


        }
    }
    // $ANTLR end synpred45_EolParserRules

    // $ANTLR start synpred59_EolParserRules
    public final void synpred59_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:305:24: ( ( '==' ( relationalExpression )? | '=' ( relationalExpression )? | ( '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression ) )
        // EolParserRules.g:305:24: ( '==' ( relationalExpression )? | '=' ( relationalExpression )? | ( '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression )
        {
        // EolParserRules.g:305:24: ( '==' ( relationalExpression )? | '=' ( relationalExpression )? | ( '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression )
        int alt59=3;
        switch ( input.LA(1) ) {
        case 112:
            {
            alt59=1;
            }
            break;
        case 113:
            {
            alt59=2;
            }
            break;
        case 114:
        case 115:
        case 116:
        case 117:
        case 118:
            {
            alt59=3;
            }
            break;
        default:
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 59, 0, input);

            throw nvae;
        }

        switch (alt59) {
            case 1 :
                // EolParserRules.g:305:25: '==' ( relationalExpression )?
                {
                match(input,112,FOLLOW_112_in_synpred59_EolParserRules1292); if (state.failed) return ;
                // EolParserRules.g:305:31: ( relationalExpression )?
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==FLOAT||LA57_0==INT||LA57_0==BOOLEAN||LA57_0==STRING||LA57_0==NAME||LA57_0==78||(LA57_0>=87 && LA57_0<=92)||LA57_0==120||LA57_0==123||(LA57_0>=125 && LA57_0<=126)) ) {
                    alt57=1;
                }
                switch (alt57) {
                    case 1 :
                        // EolParserRules.g:0:0: relationalExpression
                        {
                        pushFollow(FOLLOW_relationalExpression_in_synpred59_EolParserRules1295);
                        relationalExpression();

                        state._fsp--;
                        if (state.failed) return ;

                        }
                        break;

                }


                }
                break;
            case 2 :
                // EolParserRules.g:305:55: '=' ( relationalExpression )?
                {
                match(input,113,FOLLOW_113_in_synpred59_EolParserRules1300); if (state.failed) return ;
                // EolParserRules.g:305:60: ( relationalExpression )?
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==FLOAT||LA58_0==INT||LA58_0==BOOLEAN||LA58_0==STRING||LA58_0==NAME||LA58_0==78||(LA58_0>=87 && LA58_0<=92)||LA58_0==120||LA58_0==123||(LA58_0>=125 && LA58_0<=126)) ) {
                    alt58=1;
                }
                switch (alt58) {
                    case 1 :
                        // EolParserRules.g:0:0: relationalExpression
                        {
                        pushFollow(FOLLOW_relationalExpression_in_synpred59_EolParserRules1303);
                        relationalExpression();

                        state._fsp--;
                        if (state.failed) return ;

                        }
                        break;

                }


                }
                break;
            case 3 :
                // EolParserRules.g:306:24: ( '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression
                {
                if ( (input.LA(1)>=114 && input.LA(1)<=118) ) {
                    input.consume();
                    state.errorRecovery=false;state.failed=false;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    MismatchedSetException mse = new MismatchedSetException(null,input);
                    throw mse;
                }

                pushFollow(FOLLOW_additiveExpression_in_synpred59_EolParserRules1344);
                additiveExpression();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        }
    }
    // $ANTLR end synpred59_EolParserRules

    // $ANTLR start synpred83_EolParserRules
    public final void synpred83_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:390:4: ( expressionRange )
        // EolParserRules.g:390:4: expressionRange
        {
        pushFollow(FOLLOW_expressionRange_in_synpred83_EolParserRules1766);
        expressionRange();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred83_EolParserRules

    // $ANTLR start synpred86_EolParserRules
    public final void synpred86_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:399:35: ( featureCall )
        // EolParserRules.g:399:35: featureCall
        {
        pushFollow(FOLLOW_featureCall_in_synpred86_EolParserRules1800);
        featureCall();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred86_EolParserRules

    // $ANTLR start synpred87_EolParserRules
    public final void synpred87_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:399:49: ( pathName )
        // EolParserRules.g:399:49: pathName
        {
        pushFollow(FOLLOW_pathName_in_synpred87_EolParserRules1804);
        pathName();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred87_EolParserRules

    // Delegated rules

    public final boolean synpred40_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred40_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred14_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred14_EolParserRules_fragment(); // can never throw exception
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
    public final boolean synpred59_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred59_EolParserRules_fragment(); // can never throw exception
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
    public final boolean synpred87_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred87_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred83_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred83_EolParserRules_fragment(); // can never throw exception
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
    public final boolean synpred45_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred45_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA19 dfa19 = new DFA19(this);
    protected DFA20 dfa20 = new DFA20(this);
    protected DFA21 dfa21 = new DFA21(this);
    protected DFA30 dfa30 = new DFA30(this);
    protected DFA41 dfa41 = new DFA41(this);
    protected DFA52 dfa52 = new DFA52(this);
    protected DFA53 dfa53 = new DFA53(this);
    static final String DFA19_eotS =
        "\35\uffff";
    static final String DFA19_eofS =
        "\1\2\34\uffff";
    static final String DFA19_minS =
        "\1\7\1\0\33\uffff";
    static final String DFA19_maxS =
        "\1\u0085\1\0\33\uffff";
    static final String DFA19_acceptS =
        "\2\uffff\1\2\31\uffff\1\1";
    static final String DFA19_specialS =
        "\1\uffff\1\0\33\uffff}>";
    static final String[] DFA19_transitionS = {
            "\3\2\6\uffff\1\2\3\uffff\1\2\63\uffff\1\2\1\uffff\1\2\1\uffff"+
            "\2\2\1\1\1\2\1\uffff\3\2\12\uffff\1\2\13\uffff\21\2\1\uffff"+
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
            return "198:3: ( '(' tn= typeName ')' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA19_1 = input.LA(1);

                         
                        int index19_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred24_EolParserRules()) ) {s = 28;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index19_1);
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
        "\24\uffff";
    static final String DFA20_eofS =
        "\24\uffff";
    static final String DFA20_minS =
        "\1\4\13\uffff\1\0\7\uffff";
    static final String DFA20_maxS =
        "\1\176\13\uffff\1\0\7\uffff";
    static final String DFA20_acceptS =
        "\1\uffff\1\1\14\uffff\1\2\5\uffff";
    static final String DFA20_specialS =
        "\14\uffff\1\0\7\uffff}>";
    static final String[] DFA20_transitionS = {
            "\1\1\1\uffff\1\1\3\uffff\1\1\1\uffff\1\1\3\uffff\1\1\75\uffff"+
            "\1\1\10\uffff\7\1\1\uffff\1\1\1\uffff\1\1\1\14\2\16\1\1\4\16"+
            "\16\uffff\1\1\2\uffff\1\1\1\uffff\2\1",
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
            return "204:1: statement : ( statementA | statementB );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA20_12 = input.LA(1);

                         
                        int index20_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred25_EolParserRules()) ) {s = 1;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index20_12);
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
    static final String DFA21_eotS =
        "\20\uffff";
    static final String DFA21_eofS =
        "\20\uffff";
    static final String DFA21_minS =
        "\1\4\10\0\7\uffff";
    static final String DFA21_maxS =
        "\1\176\10\0\7\uffff";
    static final String DFA21_acceptS =
        "\11\uffff\1\3\1\4\1\5\1\6\1\7\1\1\1\2";
    static final String DFA21_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\7\uffff}>";
    static final String[] DFA21_transitionS = {
            "\1\3\1\uffff\1\3\3\uffff\1\3\1\uffff\1\3\3\uffff\1\4\75\uffff"+
            "\1\6\10\uffff\1\5\5\2\1\11\1\uffff\1\12\1\uffff\1\13\1\14\2"+
            "\uffff\1\15\22\uffff\1\1\2\uffff\1\1\1\uffff\1\7\1\10",
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

    static final short[] DFA21_eot = DFA.unpackEncodedString(DFA21_eotS);
    static final short[] DFA21_eof = DFA.unpackEncodedString(DFA21_eofS);
    static final char[] DFA21_min = DFA.unpackEncodedStringToUnsignedChars(DFA21_minS);
    static final char[] DFA21_max = DFA.unpackEncodedStringToUnsignedChars(DFA21_maxS);
    static final short[] DFA21_accept = DFA.unpackEncodedString(DFA21_acceptS);
    static final short[] DFA21_special = DFA.unpackEncodedString(DFA21_specialS);
    static final short[][] DFA21_transition;

    static {
        int numStates = DFA21_transitionS.length;
        DFA21_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA21_transition[i] = DFA.unpackEncodedString(DFA21_transitionS[i]);
        }
    }

    class DFA21 extends DFA {

        public DFA21(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 21;
            this.eot = DFA21_eot;
            this.eof = DFA21_eof;
            this.min = DFA21_min;
            this.max = DFA21_max;
            this.accept = DFA21_accept;
            this.special = DFA21_special;
            this.transition = DFA21_transition;
        }
        public String getDescription() {
            return "208:1: statementA : ( assignmentStatement | expressionStatement | forStatement | ifStatement | whileStatement | returnStatement | breakStatement );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA21_1 = input.LA(1);

                         
                        int index21_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_EolParserRules()) ) {s = 14;}

                        else if ( (synpred27_EolParserRules()) ) {s = 15;}

                         
                        input.seek(index21_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA21_2 = input.LA(1);

                         
                        int index21_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_EolParserRules()) ) {s = 14;}

                        else if ( (synpred27_EolParserRules()) ) {s = 15;}

                         
                        input.seek(index21_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA21_3 = input.LA(1);

                         
                        int index21_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_EolParserRules()) ) {s = 14;}

                        else if ( (synpred27_EolParserRules()) ) {s = 15;}

                         
                        input.seek(index21_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA21_4 = input.LA(1);

                         
                        int index21_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_EolParserRules()) ) {s = 14;}

                        else if ( (synpred27_EolParserRules()) ) {s = 15;}

                         
                        input.seek(index21_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA21_5 = input.LA(1);

                         
                        int index21_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_EolParserRules()) ) {s = 14;}

                        else if ( (synpred27_EolParserRules()) ) {s = 15;}

                         
                        input.seek(index21_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA21_6 = input.LA(1);

                         
                        int index21_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_EolParserRules()) ) {s = 14;}

                        else if ( (synpred27_EolParserRules()) ) {s = 15;}

                         
                        input.seek(index21_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA21_7 = input.LA(1);

                         
                        int index21_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_EolParserRules()) ) {s = 14;}

                        else if ( (synpred27_EolParserRules()) ) {s = 15;}

                         
                        input.seek(index21_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA21_8 = input.LA(1);

                         
                        int index21_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_EolParserRules()) ) {s = 14;}

                        else if ( (synpred27_EolParserRules()) ) {s = 15;}

                         
                        input.seek(index21_8);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 21, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA30_eotS =
        "\26\uffff";
    static final String DFA30_eofS =
        "\26\uffff";
    static final String DFA30_minS =
        "\1\4\1\0\24\uffff";
    static final String DFA30_maxS =
        "\1\176\1\0\24\uffff";
    static final String DFA30_acceptS =
        "\2\uffff\1\2\22\uffff\1\1";
    static final String DFA30_specialS =
        "\1\uffff\1\0\24\uffff}>";
    static final String[] DFA30_transitionS = {
            "\1\2\1\uffff\1\2\3\uffff\1\2\1\uffff\1\2\3\uffff\1\1\75\uffff"+
            "\1\2\2\uffff\1\2\5\uffff\7\2\1\uffff\1\2\1\uffff\11\2\16\uffff"+
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

    static final short[] DFA30_eot = DFA.unpackEncodedString(DFA30_eotS);
    static final short[] DFA30_eof = DFA.unpackEncodedString(DFA30_eofS);
    static final char[] DFA30_min = DFA.unpackEncodedStringToUnsignedChars(DFA30_minS);
    static final char[] DFA30_max = DFA.unpackEncodedStringToUnsignedChars(DFA30_maxS);
    static final short[] DFA30_accept = DFA.unpackEncodedString(DFA30_acceptS);
    static final short[] DFA30_special = DFA.unpackEncodedString(DFA30_specialS);
    static final short[][] DFA30_transition;

    static {
        int numStates = DFA30_transitionS.length;
        DFA30_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA30_transition[i] = DFA.unpackEncodedString(DFA30_transitionS[i]);
        }
    }

    class DFA30 extends DFA {

        public DFA30(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 30;
            this.eot = DFA30_eot;
            this.eof = DFA30_eof;
            this.min = DFA30_min;
            this.max = DFA30_max;
            this.accept = DFA30_accept;
            this.special = DFA30_special;
            this.transition = DFA30_transition;
        }
        public String getDescription() {
            return "282:18: ( NAME ( ',' NAME )* )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA30_1 = input.LA(1);

                         
                        int index30_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_EolParserRules()) ) {s = 21;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index30_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 30, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA41_eotS =
        "\10\uffff";
    static final String DFA41_eofS =
        "\1\uffff\1\3\6\uffff";
    static final String DFA41_minS =
        "\1\20\1\7\1\4\1\uffff\1\7\1\4\1\uffff\1\7";
    static final String DFA41_maxS =
        "\1\20\1\u0085\1\176\1\uffff\1\174\1\176\1\uffff\1\174";
    static final String DFA41_acceptS =
        "\3\uffff\1\1\2\uffff\1\2\1\uffff";
    static final String DFA41_specialS =
        "\10\uffff}>";
    static final String[] DFA41_transitionS = {
            "\1\1",
            "\3\3\12\uffff\1\3\63\uffff\1\3\1\uffff\1\3\1\uffff\2\3\1\2\1"+
            "\3\2\uffff\2\3\26\uffff\21\3\10\uffff\3\3",
            "\1\3\1\uffff\1\3\3\uffff\1\3\1\uffff\1\3\3\uffff\1\4\75\uffff"+
            "\2\3\7\uffff\6\3\33\uffff\1\3\2\uffff\1\3\1\uffff\2\3",
            "",
            "\1\3\1\uffff\1\3\77\uffff\1\6\1\5\3\uffff\2\3\4\uffff\3\3\25"+
            "\uffff\17\3\1\uffff\1\6",
            "\1\3\1\uffff\1\3\3\uffff\1\3\1\uffff\1\3\3\uffff\1\7\75\uffff"+
            "\1\3\10\uffff\6\3\33\uffff\1\3\2\uffff\1\3\1\uffff\2\3",
            "",
            "\1\3\1\uffff\1\3\77\uffff\1\6\1\5\3\uffff\2\3\4\uffff\3\3\25"+
            "\uffff\17\3\1\uffff\1\6"
    };

    static final short[] DFA41_eot = DFA.unpackEncodedString(DFA41_eotS);
    static final short[] DFA41_eof = DFA.unpackEncodedString(DFA41_eofS);
    static final char[] DFA41_min = DFA.unpackEncodedStringToUnsignedChars(DFA41_minS);
    static final char[] DFA41_max = DFA.unpackEncodedStringToUnsignedChars(DFA41_maxS);
    static final short[] DFA41_accept = DFA.unpackEncodedString(DFA41_acceptS);
    static final short[] DFA41_special = DFA.unpackEncodedString(DFA41_specialS);
    static final short[][] DFA41_transition;

    static {
        int numStates = DFA41_transitionS.length;
        DFA41_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA41_transition[i] = DFA.unpackEncodedString(DFA41_transitionS[i]);
        }
    }

    class DFA41 extends DFA {

        public DFA41(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 41;
            this.eot = DFA41_eot;
            this.eof = DFA41_eof;
            this.min = DFA41_min;
            this.max = DFA41_max;
            this.accept = DFA41_accept;
            this.special = DFA41_special;
            this.transition = DFA41_transition;
        }
        public String getDescription() {
            return "337:1: featureCall : ( simpleFeatureCall | declarativeFeatureCall );";
        }
    }
    static final String DFA52_eotS =
        "\13\uffff";
    static final String DFA52_eofS =
        "\13\uffff";
    static final String DFA52_minS =
        "\1\4\10\0\2\uffff";
    static final String DFA52_maxS =
        "\1\176\10\0\2\uffff";
    static final String DFA52_acceptS =
        "\11\uffff\1\1\1\2";
    static final String DFA52_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\2\uffff}>";
    static final String[] DFA52_transitionS = {
            "\1\3\1\uffff\1\3\3\uffff\1\3\1\uffff\1\3\3\uffff\1\4\75\uffff"+
            "\1\6\10\uffff\1\5\5\2\33\uffff\1\1\2\uffff\1\1\1\uffff\1\7\1"+
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

    static final short[] DFA52_eot = DFA.unpackEncodedString(DFA52_eotS);
    static final short[] DFA52_eof = DFA.unpackEncodedString(DFA52_eofS);
    static final char[] DFA52_min = DFA.unpackEncodedStringToUnsignedChars(DFA52_minS);
    static final char[] DFA52_max = DFA.unpackEncodedStringToUnsignedChars(DFA52_maxS);
    static final short[] DFA52_accept = DFA.unpackEncodedString(DFA52_acceptS);
    static final short[] DFA52_special = DFA.unpackEncodedString(DFA52_specialS);
    static final short[][] DFA52_transition;

    static {
        int numStates = DFA52_transitionS.length;
        DFA52_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA52_transition[i] = DFA.unpackEncodedString(DFA52_transitionS[i]);
        }
    }

    class DFA52 extends DFA {

        public DFA52(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 52;
            this.eot = DFA52_eot;
            this.eof = DFA52_eof;
            this.min = DFA52_min;
            this.max = DFA52_max;
            this.accept = DFA52_accept;
            this.special = DFA52_special;
            this.transition = DFA52_transition;
        }
        public String getDescription() {
            return "389:1: expressionListOrRange : ( expressionRange | expressionList );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA52_1 = input.LA(1);

                         
                        int index52_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred83_EolParserRules()) ) {s = 9;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index52_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA52_2 = input.LA(1);

                         
                        int index52_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred83_EolParserRules()) ) {s = 9;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index52_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA52_3 = input.LA(1);

                         
                        int index52_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred83_EolParserRules()) ) {s = 9;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index52_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA52_4 = input.LA(1);

                         
                        int index52_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred83_EolParserRules()) ) {s = 9;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index52_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA52_5 = input.LA(1);

                         
                        int index52_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred83_EolParserRules()) ) {s = 9;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index52_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA52_6 = input.LA(1);

                         
                        int index52_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred83_EolParserRules()) ) {s = 9;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index52_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA52_7 = input.LA(1);

                         
                        int index52_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred83_EolParserRules()) ) {s = 9;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index52_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA52_8 = input.LA(1);

                         
                        int index52_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred83_EolParserRules()) ) {s = 9;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index52_8);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 52, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA53_eotS =
        "\14\uffff";
    static final String DFA53_eofS =
        "\1\uffff\1\11\12\uffff";
    static final String DFA53_minS =
        "\1\4\1\7\1\uffff\1\0\10\uffff";
    static final String DFA53_maxS =
        "\1\176\1\u0085\1\uffff\1\0\10\uffff";
    static final String DFA53_acceptS =
        "\2\uffff\1\2\1\uffff\1\5\1\7\1\10\1\11\1\1\1\6\1\3\1\4";
    static final String DFA53_specialS =
        "\3\uffff\1\0\10\uffff}>";
    static final String[] DFA53_transitionS = {
            "\1\2\1\uffff\1\2\3\uffff\1\2\1\uffff\1\2\3\uffff\1\3\75\uffff"+
            "\1\5\10\uffff\1\4\5\1\40\uffff\1\6\1\7",
            "\3\11\12\uffff\1\11\63\uffff\1\11\1\uffff\1\11\1\uffff\4\11"+
            "\1\uffff\1\10\2\11\26\uffff\21\11\10\uffff\3\11",
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

    static final short[] DFA53_eot = DFA.unpackEncodedString(DFA53_eotS);
    static final short[] DFA53_eof = DFA.unpackEncodedString(DFA53_eofS);
    static final char[] DFA53_min = DFA.unpackEncodedStringToUnsignedChars(DFA53_minS);
    static final char[] DFA53_max = DFA.unpackEncodedStringToUnsignedChars(DFA53_maxS);
    static final short[] DFA53_accept = DFA.unpackEncodedString(DFA53_acceptS);
    static final short[] DFA53_special = DFA.unpackEncodedString(DFA53_specialS);
    static final short[][] DFA53_transition;

    static {
        int numStates = DFA53_transitionS.length;
        DFA53_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA53_transition[i] = DFA.unpackEncodedString(DFA53_transitionS[i]);
        }
    }

    class DFA53 extends DFA {

        public DFA53(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 53;
            this.eot = DFA53_eot;
            this.eof = DFA53_eof;
            this.min = DFA53_min;
            this.max = DFA53_max;
            this.accept = DFA53_accept;
            this.special = DFA53_special;
            this.transition = DFA53_transition;
        }
        public String getDescription() {
            return "398:1: primitiveExpression : ( litteralCollection | literal | featureCall | pathName | nativeType | collectionType | '(' logicalExpression ')' | newExpression | variableDeclarationExpression );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA53_3 = input.LA(1);

                         
                        int index53_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_EolParserRules()) ) {s = 10;}

                        else if ( (synpred87_EolParserRules()) ) {s = 11;}

                         
                        input.seek(index53_3);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 53, _s, input);
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
    public static final BitSet FOLLOW_76_in_operationDeclaration327 = new BitSet(new long[]{0x0000000000010000L,0x000000001F800000L});
    public static final BitSet FOLLOW_77_in_operationDeclaration329 = new BitSet(new long[]{0x0000000000010000L,0x000000001F800000L});
    public static final BitSet FOLLOW_typeName_in_operationDeclaration335 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NAME_in_operationDeclaration343 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_operationDeclaration345 = new BitSet(new long[]{0x0000000000010000L,0x0000000000008000L});
    public static final BitSet FOLLOW_formalParameterList_in_operationDeclaration347 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_operationDeclaration350 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020200L});
    public static final BitSet FOLLOW_73_in_operationDeclaration353 = new BitSet(new long[]{0x0000000000010000L,0x000000001F800000L});
    public static final BitSet FOLLOW_typeName_in_operationDeclaration357 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020200L});
    public static final BitSet FOLLOW_statementBlock_in_operationDeclaration363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_80_in_importStatement400 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_STRING_in_importStatement403 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_importStatement405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_block420 = new BitSet(new long[]{0x0000000000011452L,0x690003FEBF804000L});
    public static final BitSet FOLLOW_81_in_statementBlock442 = new BitSet(new long[]{0x0000000000011450L,0x690003FEBF804000L});
    public static final BitSet FOLLOW_block_in_statementBlock445 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_82_in_statementBlock447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_formalParameter459 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});
    public static final BitSet FOLLOW_73_in_formalParameter462 = new BitSet(new long[]{0x0000000000010000L,0x000000001F800000L});
    public static final BitSet FOLLOW_typeName_in_formalParameter466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_formalParameter_in_formalParameterList495 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000400L});
    public static final BitSet FOLLOW_74_in_formalParameterList498 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_formalParameter_in_formalParameterList500 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000400L});
    public static final BitSet FOLLOW_83_in_executableAnnotation523 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NAME_in_executableAnnotation525 = new BitSet(new long[]{0x0000000000011450L,0x690000001F804000L});
    public static final BitSet FOLLOW_logicalExpression_in_executableAnnotation527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Annotation_in_annotation549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_executableAnnotation_in_annotation551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotation_in_annotationBlock562 = new BitSet(new long[]{0x0000000000100002L,0x0000000000080000L});
    public static final BitSet FOLLOW_pathName_in_typeName585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nativeType_in_typeName589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectionType_in_typeName593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_pathName610 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_84_in_pathName613 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NAME_in_pathName620 = new BitSet(new long[]{0x0000000000000002L,0x0000000000600000L});
    public static final BitSet FOLLOW_85_in_pathName625 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NAME_in_pathName630 = new BitSet(new long[]{0x0000000000000002L,0x0000000000600000L});
    public static final BitSet FOLLOW_86_in_pathName640 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NAME_in_pathName645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_87_in_nativeType665 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_nativeType668 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_STRING_in_nativeType671 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_nativeType673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_modelElementType690 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_84_in_modelElementType692 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NAME_in_modelElementType694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_collectionType716 = new BitSet(new long[]{0x0000000000000002L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_collectionType732 = new BitSet(new long[]{0x0000000000010000L,0x000000001F800000L});
    public static final BitSet FOLLOW_typeName_in_collectionType737 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_collectionType740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementA_in_statement763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementB_in_statement767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignmentStatement_in_statementA777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionStatement_in_statementA781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_forStatement_in_statementA785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStatement_in_statementA791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_whileStatement_in_statementA795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_returnStatement_in_statementA799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_breakStatement_in_statementA803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_breakAllStatement_in_statementB815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_returnStatement_in_statementB819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_transactionStatement_in_statementB823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_abortStatement_in_statementB829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_continueStatement_in_statementB833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_throwStatement_in_statementB837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_deleteStatement_in_statementB843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_statementOrStatementBlock854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementBlock_in_statementOrStatementBlock858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_expressionOrStatementBlock867 = new BitSet(new long[]{0x0000000000011450L,0x690000001F804000L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionOrStatementBlock870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementBlock_in_expressionOrStatementBlock874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_93_in_forStatement885 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_forStatement887 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_formalParameter_in_forStatement889 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_94_in_forStatement891 = new BitSet(new long[]{0x0000000000011450L,0x690000001F804000L});
    public static final BitSet FOLLOW_logicalExpression_in_forStatement893 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_forStatement895 = new BitSet(new long[]{0x0000000000011450L,0x690003FEBF824200L});
    public static final BitSet FOLLOW_statementOrStatementBlock_in_forStatement897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_95_in_ifStatement921 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_ifStatement923 = new BitSet(new long[]{0x0000000000011450L,0x690000001F804000L});
    public static final BitSet FOLLOW_logicalExpression_in_ifStatement925 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_ifStatement927 = new BitSet(new long[]{0x0000000000011450L,0x690003FEBF824200L});
    public static final BitSet FOLLOW_statementOrStatementBlock_in_ifStatement929 = new BitSet(new long[]{0x0000000000000002L,0x0000000100000000L});
    public static final BitSet FOLLOW_elseStatement_in_ifStatement931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_96_in_elseStatement958 = new BitSet(new long[]{0x0000000000011450L,0x690003FEBF824200L});
    public static final BitSet FOLLOW_statementOrStatementBlock_in_elseStatement961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_97_in_whileStatement974 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_whileStatement976 = new BitSet(new long[]{0x0000000000011450L,0x690000001F804000L});
    public static final BitSet FOLLOW_logicalExpression_in_whileStatement978 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_whileStatement980 = new BitSet(new long[]{0x0000000000011450L,0x690003FEBF824200L});
    public static final BitSet FOLLOW_statementOrStatementBlock_in_whileStatement982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_98_in_returnStatement1004 = new BitSet(new long[]{0x0000000000011450L,0x690000001F804100L});
    public static final BitSet FOLLOW_logicalExpression_in_returnStatement1006 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_returnStatement1009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_99_in_throwStatement1030 = new BitSet(new long[]{0x0000000000011450L,0x690000001F804100L});
    public static final BitSet FOLLOW_logicalExpression_in_throwStatement1032 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_throwStatement1035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_100_in_deleteStatement1056 = new BitSet(new long[]{0x0000000000011450L,0x690000001F804100L});
    public static final BitSet FOLLOW_logicalExpression_in_deleteStatement1058 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_deleteStatement1061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_101_in_breakStatement1085 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_breakStatement1087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_102_in_breakAllStatement1105 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_breakAllStatement1107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_103_in_continueStatement1125 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_continueStatement1127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_104_in_abortStatement1145 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_abortStatement1147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_105_in_transactionStatement1165 = new BitSet(new long[]{0x0000000000011450L,0x690003FEBF824200L});
    public static final BitSet FOLLOW_NAME_in_transactionStatement1168 = new BitSet(new long[]{0x0000000000011450L,0x690003FEBF824600L});
    public static final BitSet FOLLOW_74_in_transactionStatement1171 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NAME_in_transactionStatement1173 = new BitSet(new long[]{0x0000000000011450L,0x690003FEBF824600L});
    public static final BitSet FOLLOW_statementOrStatementBlock_in_transactionStatement1179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logicalExpression_in_assignmentStatement1208 = new BitSet(new long[]{0x0000000000000000L,0x00000C0000000000L});
    public static final BitSet FOLLOW_106_in_assignmentStatement1213 = new BitSet(new long[]{0x0000000000011450L,0x690000001F804000L});
    public static final BitSet FOLLOW_107_in_assignmentStatement1220 = new BitSet(new long[]{0x0000000000011450L,0x690000001F804000L});
    public static final BitSet FOLLOW_logicalExpression_in_assignmentStatement1226 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_assignmentStatement1228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionStatement1243 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_expressionStatement1245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_relationalExpression_in_logicalExpression1257 = new BitSet(new long[]{0x0000000000000002L,0x0000F00000000000L});
    public static final BitSet FOLLOW_set_in_logicalExpression1260 = new BitSet(new long[]{0x0000000000011450L,0x690000001F804000L});
    public static final BitSet FOLLOW_relationalExpression_in_logicalExpression1271 = new BitSet(new long[]{0x0000000000000002L,0x0000F00000000000L});
    public static final BitSet FOLLOW_additiveExpression_in_relationalExpression1288 = new BitSet(new long[]{0x0000000000000002L,0x007F000000000000L});
    public static final BitSet FOLLOW_112_in_relationalExpression1292 = new BitSet(new long[]{0x0000000000011452L,0x697F00001F804000L});
    public static final BitSet FOLLOW_relationalExpression_in_relationalExpression1295 = new BitSet(new long[]{0x0000000000000002L,0x007F000000000000L});
    public static final BitSet FOLLOW_113_in_relationalExpression1300 = new BitSet(new long[]{0x0000000000011452L,0x697F00001F804000L});
    public static final BitSet FOLLOW_relationalExpression_in_relationalExpression1303 = new BitSet(new long[]{0x0000000000000002L,0x007F000000000000L});
    public static final BitSet FOLLOW_set_in_relationalExpression1331 = new BitSet(new long[]{0x0000000000011450L,0x690000001F804000L});
    public static final BitSet FOLLOW_additiveExpression_in_relationalExpression1344 = new BitSet(new long[]{0x0000000000000002L,0x007F000000000000L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_additiveExpression1362 = new BitSet(new long[]{0x0000000000000002L,0x0180000000000000L});
    public static final BitSet FOLLOW_set_in_additiveExpression1365 = new BitSet(new long[]{0x0000000000011450L,0x690000001F804000L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_additiveExpression1372 = new BitSet(new long[]{0x0000000000000002L,0x0180000000000000L});
    public static final BitSet FOLLOW_unaryExpression_in_multiplicativeExpression1393 = new BitSet(new long[]{0x0000000000000002L,0x0600000000000000L});
    public static final BitSet FOLLOW_set_in_multiplicativeExpression1396 = new BitSet(new long[]{0x0000000000011450L,0x690000001F804000L});
    public static final BitSet FOLLOW_unaryExpression_in_multiplicativeExpression1403 = new BitSet(new long[]{0x0000000000000002L,0x0600000000000000L});
    public static final BitSet FOLLOW_set_in_unaryExpression1421 = new BitSet(new long[]{0x0000000000011450L,0x690000001F804000L});
    public static final BitSet FOLLOW_postfixExpression_in_unaryExpression1430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primitiveExpression_in_postfixExpression1445 = new BitSet(new long[]{0x0000000000000282L});
    public static final BitSet FOLLOW_set_in_postfixExpression1447 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_featureCall_in_postfixExpression1456 = new BitSet(new long[]{0x0000000000000282L});
    public static final BitSet FOLLOW_simpleFeatureCall_in_featureCall1491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declarativeFeatureCall_in_featureCall1495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_simpleFeatureCall1507 = new BitSet(new long[]{0x0000000000000002L,0x0000000000004000L});
    public static final BitSet FOLLOW_parameterList_in_simpleFeatureCall1510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_parameterList1525 = new BitSet(new long[]{0x0000000000011450L,0x690000001F80C000L});
    public static final BitSet FOLLOW_logicalExpression_in_parameterList1528 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008400L});
    public static final BitSet FOLLOW_74_in_parameterList1531 = new BitSet(new long[]{0x0000000000011450L,0x690000001F804000L});
    public static final BitSet FOLLOW_logicalExpression_in_parameterList1533 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008400L});
    public static final BitSet FOLLOW_79_in_parameterList1539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_declarativeFeatureCall1561 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_declarativeFeatureCall1564 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_formalParameterList_in_declarativeFeatureCall1567 = new BitSet(new long[]{0x0000000000000000L,0x1000000000000000L});
    public static final BitSet FOLLOW_124_in_declarativeFeatureCall1569 = new BitSet(new long[]{0x0000000000011450L,0x690000001F804000L});
    public static final BitSet FOLLOW_logicalExpression_in_declarativeFeatureCall1572 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008400L});
    public static final BitSet FOLLOW_74_in_declarativeFeatureCall1575 = new BitSet(new long[]{0x0000000000011450L,0x690000001F804000L});
    public static final BitSet FOLLOW_logicalExpression_in_declarativeFeatureCall1578 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008400L});
    public static final BitSet FOLLOW_79_in_declarativeFeatureCall1582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_125_in_newExpression1594 = new BitSet(new long[]{0x0000000000010000L,0x000000001F800000L});
    public static final BitSet FOLLOW_typeName_in_newExpression1599 = new BitSet(new long[]{0x0000000000000002L,0x0000000000004000L});
    public static final BitSet FOLLOW_parameterList_in_newExpression1603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_126_in_variableDeclarationExpression1628 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NAME_in_variableDeclarationExpression1630 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});
    public static final BitSet FOLLOW_73_in_variableDeclarationExpression1633 = new BitSet(new long[]{0x0000000000010000L,0x200000001F800000L});
    public static final BitSet FOLLOW_125_in_variableDeclarationExpression1637 = new BitSet(new long[]{0x0000000000010000L,0x200000001F800000L});
    public static final BitSet FOLLOW_typeName_in_variableDeclarationExpression1642 = new BitSet(new long[]{0x0000000000000002L,0x0000000000004000L});
    public static final BitSet FOLLOW_parameterList_in_variableDeclarationExpression1646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_litteralCollection1676 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_81_in_litteralCollection1689 = new BitSet(new long[]{0x0000000000011450L,0x690000001F844000L});
    public static final BitSet FOLLOW_expressionListOrRange_in_litteralCollection1693 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_82_in_litteralCollection1696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionRange1711 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_POINT_POINT_in_expressionRange1713 = new BitSet(new long[]{0x0000000000011450L,0x690000001F804000L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionRange1715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionList1737 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000400L});
    public static final BitSet FOLLOW_74_in_expressionList1740 = new BitSet(new long[]{0x0000000000011450L,0x690000001F804000L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionList1742 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000400L});
    public static final BitSet FOLLOW_expressionRange_in_expressionListOrRange1766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionList_in_expressionListOrRange1770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_litteralCollection_in_primitiveExpression1792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_primitiveExpression1796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_featureCall_in_primitiveExpression1800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pathName_in_primitiveExpression1804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nativeType_in_primitiveExpression1808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectionType_in_primitiveExpression1814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_primitiveExpression1819 = new BitSet(new long[]{0x0000000000011450L,0x690000001F804000L});
    public static final BitSet FOLLOW_logicalExpression_in_primitiveExpression1822 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_primitiveExpression1824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_newExpression_in_primitiveExpression1832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variableDeclarationExpression_in_primitiveExpression1836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_literal0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotation_in_synpred14_EolParserRules562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_synpred24_EolParserRules732 = new BitSet(new long[]{0x0000000000010000L,0x200000001F800000L});
    public static final BitSet FOLLOW_typeName_in_synpred24_EolParserRules737 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_synpred24_EolParserRules740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementA_in_synpred25_EolParserRules763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignmentStatement_in_synpred26_EolParserRules777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionStatement_in_synpred27_EolParserRules781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_elseStatement_in_synpred40_EolParserRules931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_synpred45_EolParserRules1168 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000400L});
    public static final BitSet FOLLOW_74_in_synpred45_EolParserRules1171 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NAME_in_synpred45_EolParserRules1173 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000400L});
    public static final BitSet FOLLOW_112_in_synpred59_EolParserRules1292 = new BitSet(new long[]{0x0000000000011452L,0x690000001F804000L});
    public static final BitSet FOLLOW_relationalExpression_in_synpred59_EolParserRules1295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_113_in_synpred59_EolParserRules1300 = new BitSet(new long[]{0x0000000000011452L,0x690000001F804000L});
    public static final BitSet FOLLOW_relationalExpression_in_synpred59_EolParserRules1303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred59_EolParserRules1331 = new BitSet(new long[]{0x0000000000011450L,0x690000001F804000L});
    public static final BitSet FOLLOW_additiveExpression_in_synpred59_EolParserRules1344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionRange_in_synpred83_EolParserRules1766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_featureCall_in_synpred86_EolParserRules1800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pathName_in_synpred87_EolParserRules1804 = new BitSet(new long[]{0x0000000000000002L});

}
