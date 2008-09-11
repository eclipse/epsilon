package org.eclipse.epsilon.evl.parse;

// $ANTLR 3.1b1 EolParserRules.g 2008-09-01 17:25:48

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
public class Evl_EolParserRules extends org.eclipse.epsilon.commons.parse.EpsilonParser {
    public static final int FIX=67;
    public static final int WHILE=30;
    public static final int StatementBlock=26;
    public static final int StrangeNameLiteral=13;
    public static final int NEW=43;
    public static final int DO=69;
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
    public static final int T__136=136;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int LINE_COMMENT=19;
    public static final int BREAKALL=33;
    public static final int TRANSACTION=35;
    public static final int ELSE=29;
    public static final int EOLMODULE=54;
    public static final int PARAMLIST=22;
    public static final int INT=6;
    public static final int DELETE=46;
    public static final int T__85=85;
    public static final int T__84=84;
    public static final int T__87=87;
    public static final int T__86=86;
    public static final int HELPERMETHOD=25;
    public static final int T__89=89;
    public static final int T__88=88;
    public static final int CollectionType=38;
    public static final int T__126=126;
    public static final int T__125=125;
    public static final int T__128=128;
    public static final int T__127=127;
    public static final int WS=17;
    public static final int T__129=129;
    public static final int EVLMODULE=72;
    public static final int JavaIDDigit=15;
    public static final int CHECK=68;
    public static final int GUARD=63;
    public static final int Annotation=20;
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int CONSTRAINT=64;
    public static final int T__74=74;
    public static final int T__130=130;
    public static final int T__73=73;
    public static final int T__131=131;
    public static final int EscapeSequence=11;
    public static final int Letter=14;
    public static final int THROW=47;
    public static final int T__132=132;
    public static final int T__79=79;
    public static final int T__133=133;
    public static final int T__78=78;
    public static final int T__134=134;
    public static final int T__77=77;
    public static final int T__135=135;
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
    public static final int PRE=60;
    public static final int T__120=120;
    public static final int FLOAT=4;
    public static final int EXECUTABLEANNOTATION=45;
    public static final int CONTEXT=66;
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
    public static final int MESSAGE=71;
    public static final int T__113=113;
    public static final int T__112=112;
    public static final int COLLECTION=36;
    public static final int DIGIT=5;
    public static final int CRITIQUE=65;
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
    public static final int POST=61;
    public static final int ARROW=9;
    public static final int ASSIGNMENT=23;
    public static final int EXTENDS=62;
    public static final int STRING=12;
    public static final int TITLE=70;

    // delegates
    // delegators
    public EvlParser gEvl;


        public Evl_EolParserRules(TokenStream input, EvlParser gEvl) {
            this(input, new RecognizerSharedState(), gEvl);
        }
        public Evl_EolParserRules(TokenStream input, RecognizerSharedState state, EvlParser gEvl) {
            super(input, state);
            this.gEvl = gEvl;
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return EvlParser.tokenNames; }
    public String getGrammarFileName() { return "EolParserRules.g"; }

    
    
    public void setTokenType(ParserRuleReturnScope tree, int type) {
    	((CommonTree) tree.getTree()).getToken().setType(type);
    }
    


    public static class operationDeclarationOrAnnotationBlock_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start operationDeclarationOrAnnotationBlock
    // EolParserRules.g:91:1: operationDeclarationOrAnnotationBlock : ( operationDeclaration | annotationBlock );
    public final Evl_EolParserRules.operationDeclarationOrAnnotationBlock_return operationDeclarationOrAnnotationBlock() throws RecognitionException {
        Evl_EolParserRules.operationDeclarationOrAnnotationBlock_return retval = new Evl_EolParserRules.operationDeclarationOrAnnotationBlock_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Evl_EolParserRules.operationDeclaration_return operationDeclaration1 = null;

        Evl_EolParserRules.annotationBlock_return annotationBlock2 = null;



        try {
            // EolParserRules.g:92:2: ( operationDeclaration | annotationBlock )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==73) ) {
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
                    // EolParserRules.g:92:4: operationDeclaration
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_operationDeclaration_in_operationDeclarationOrAnnotationBlock194);
                    operationDeclaration1=operationDeclaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, operationDeclaration1.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:92:25: annotationBlock
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_annotationBlock_in_operationDeclarationOrAnnotationBlock196);
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

    public static class operationDeclaration_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start operationDeclaration
    // EolParserRules.g:95:1: operationDeclaration : 'operation' (ctx= typeName )? operationName= NAME '(' ( formalParameterList )? ')' ( ':' returnType= typeName )? statementBlock -> ^( HELPERMETHOD ( $ctx)? $operationName ( formalParameterList )? ( $returnType)? statementBlock ) ;
    public final Evl_EolParserRules.operationDeclaration_return operationDeclaration() throws RecognitionException {
        Evl_EolParserRules.operationDeclaration_return retval = new Evl_EolParserRules.operationDeclaration_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token operationName=null;
        Token string_literal3=null;
        Token char_literal4=null;
        Token char_literal6=null;
        Token char_literal7=null;
        Evl_EolParserRules.typeName_return ctx = null;

        Evl_EolParserRules.typeName_return returnType = null;

        Evl_EolParserRules.formalParameterList_return formalParameterList5 = null;

        Evl_EolParserRules.statementBlock_return statementBlock8 = null;


        CommonTree operationName_tree=null;
        CommonTree string_literal3_tree=null;
        CommonTree char_literal4_tree=null;
        CommonTree char_literal6_tree=null;
        CommonTree char_literal7_tree=null;
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_73=new RewriteRuleTokenStream(adaptor,"token 73");
        RewriteRuleTokenStream stream_74=new RewriteRuleTokenStream(adaptor,"token 74");
        RewriteRuleTokenStream stream_75=new RewriteRuleTokenStream(adaptor,"token 75");
        RewriteRuleTokenStream stream_76=new RewriteRuleTokenStream(adaptor,"token 76");
        RewriteRuleSubtreeStream stream_typeName=new RewriteRuleSubtreeStream(adaptor,"rule typeName");
        RewriteRuleSubtreeStream stream_statementBlock=new RewriteRuleSubtreeStream(adaptor,"rule statementBlock");
        RewriteRuleSubtreeStream stream_formalParameterList=new RewriteRuleSubtreeStream(adaptor,"rule formalParameterList");
        try {
            // EolParserRules.g:97:2: ( 'operation' (ctx= typeName )? operationName= NAME '(' ( formalParameterList )? ')' ( ':' returnType= typeName )? statementBlock -> ^( HELPERMETHOD ( $ctx)? $operationName ( formalParameterList )? ( $returnType)? statementBlock ) )
            // EolParserRules.g:97:4: 'operation' (ctx= typeName )? operationName= NAME '(' ( formalParameterList )? ')' ( ':' returnType= typeName )? statementBlock
            {
            string_literal3=(Token)match(input,73,FOLLOW_73_in_operationDeclaration209); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_73.add(string_literal3);

            // EolParserRules.g:97:16: (ctx= typeName )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==NAME) ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==NAME||(LA2_1>=83 && LA2_1<=85)) ) {
                    alt2=1;
                }
            }
            else if ( ((LA2_0>=86 && LA2_0<=91)) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // EolParserRules.g:97:17: ctx= typeName
                    {
                    pushFollow(FOLLOW_typeName_in_operationDeclaration214);
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

            operationName=(Token)match(input,NAME,FOLLOW_NAME_in_operationDeclaration222); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(operationName);

            char_literal4=(Token)match(input,74,FOLLOW_74_in_operationDeclaration224); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_74.add(char_literal4);

            // EolParserRules.g:97:81: ( formalParameterList )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==NAME) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // EolParserRules.g:0:0: formalParameterList
                    {
                    pushFollow(FOLLOW_formalParameterList_in_operationDeclaration226);
                    formalParameterList5=formalParameterList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_formalParameterList.add(formalParameterList5.getTree());

                    }
                    break;

            }

            char_literal6=(Token)match(input,75,FOLLOW_75_in_operationDeclaration229); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_75.add(char_literal6);

            // EolParserRules.g:97:106: ( ':' returnType= typeName )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==76) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // EolParserRules.g:97:107: ':' returnType= typeName
                    {
                    char_literal7=(Token)match(input,76,FOLLOW_76_in_operationDeclaration232); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_76.add(char_literal7);

                    pushFollow(FOLLOW_typeName_in_operationDeclaration236);
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

            pushFollow(FOLLOW_statementBlock_in_operationDeclaration242);
            statementBlock8=statementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_statementBlock.add(statementBlock8.getTree());


            // AST REWRITE
            // elements: returnType, statementBlock, formalParameterList, ctx, operationName
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
            // 98:3: -> ^( HELPERMETHOD ( $ctx)? $operationName ( formalParameterList )? ( $returnType)? statementBlock )
            {
                // EolParserRules.g:98:6: ^( HELPERMETHOD ( $ctx)? $operationName ( formalParameterList )? ( $returnType)? statementBlock )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(HELPERMETHOD, "HELPERMETHOD"), root_1);

                // EolParserRules.g:98:21: ( $ctx)?
                if ( stream_ctx.hasNext() ) {
                    adaptor.addChild(root_1, stream_ctx.nextTree());

                }
                stream_ctx.reset();
                adaptor.addChild(root_1, stream_operationName.nextNode());
                // EolParserRules.g:98:42: ( formalParameterList )?
                if ( stream_formalParameterList.hasNext() ) {
                    adaptor.addChild(root_1, stream_formalParameterList.nextTree());

                }
                stream_formalParameterList.reset();
                // EolParserRules.g:98:63: ( $returnType)?
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
    // EolParserRules.g:101:1: importStatement : i= 'import' STRING ';' ;
    public final Evl_EolParserRules.importStatement_return importStatement() throws RecognitionException {
        Evl_EolParserRules.importStatement_return retval = new Evl_EolParserRules.importStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token i=null;
        Token STRING9=null;
        Token char_literal10=null;

        CommonTree i_tree=null;
        CommonTree STRING9_tree=null;
        CommonTree char_literal10_tree=null;

        try {
            // EolParserRules.g:102:2: (i= 'import' STRING ';' )
            // EolParserRules.g:102:4: i= 'import' STRING ';'
            {
            root_0 = (CommonTree)adaptor.nil();

            i=(Token)match(input,77,FOLLOW_77_in_importStatement279); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            i_tree = (CommonTree)adaptor.create(i);
            root_0 = (CommonTree)adaptor.becomeRoot(i_tree, root_0);
            }
            STRING9=(Token)match(input,STRING,FOLLOW_STRING_in_importStatement282); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STRING9_tree = (CommonTree)adaptor.create(STRING9);
            adaptor.addChild(root_0, STRING9_tree);
            }
            char_literal10=(Token)match(input,78,FOLLOW_78_in_importStatement284); if (state.failed) return retval;
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
    // EolParserRules.g:106:1: block : ( statement )* -> ^( BLOCK ( statement )* ) ;
    public final Evl_EolParserRules.block_return block() throws RecognitionException {
        Evl_EolParserRules.block_return retval = new Evl_EolParserRules.block_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Evl_EolParserRules.statement_return statement11 = null;


        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        try {
            // EolParserRules.g:107:2: ( ( statement )* -> ^( BLOCK ( statement )* ) )
            // EolParserRules.g:107:4: ( statement )*
            {
            // EolParserRules.g:107:4: ( statement )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==FLOAT||LA5_0==INT||LA5_0==BOOLEAN||LA5_0==STRING||LA5_0==NAME||LA5_0==74||(LA5_0>=86 && LA5_0<=92)||LA5_0==94||(LA5_0>=96 && LA5_0<=104)||LA5_0==118||LA5_0==121||(LA5_0>=123 && LA5_0<=124)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // EolParserRules.g:0:0: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_block299);
            	    statement11=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_statement.add(statement11.getTree());

            	    }
            	    break;

            	default :
            	    break loop5;
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
            // 108:2: -> ^( BLOCK ( statement )* )
            {
                // EolParserRules.g:108:5: ^( BLOCK ( statement )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(BLOCK, "BLOCK"), root_1);

                // EolParserRules.g:108:13: ( statement )*
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
    // EolParserRules.g:111:1: statementBlock : '{' block '}' ;
    public final Evl_EolParserRules.statementBlock_return statementBlock() throws RecognitionException {
        Evl_EolParserRules.statementBlock_return retval = new Evl_EolParserRules.statementBlock_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal12=null;
        Token char_literal14=null;
        Evl_EolParserRules.block_return block13 = null;


        CommonTree char_literal12_tree=null;
        CommonTree char_literal14_tree=null;

        try {
            // EolParserRules.g:112:2: ( '{' block '}' )
            // EolParserRules.g:112:4: '{' block '}'
            {
            root_0 = (CommonTree)adaptor.nil();

            char_literal12=(Token)match(input,79,FOLLOW_79_in_statementBlock321); if (state.failed) return retval;
            pushFollow(FOLLOW_block_in_statementBlock324);
            block13=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, block13.getTree());
            char_literal14=(Token)match(input,80,FOLLOW_80_in_statementBlock326); if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
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
    // EolParserRules.g:115:1: formalParameter : NAME ( ':' pt= typeName )? -> ^( FORMAL NAME ( typeName )? ) ;
    public final Evl_EolParserRules.formalParameter_return formalParameter() throws RecognitionException {
        Evl_EolParserRules.formalParameter_return retval = new Evl_EolParserRules.formalParameter_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NAME15=null;
        Token char_literal16=null;
        Evl_EolParserRules.typeName_return pt = null;


        CommonTree NAME15_tree=null;
        CommonTree char_literal16_tree=null;
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_76=new RewriteRuleTokenStream(adaptor,"token 76");
        RewriteRuleSubtreeStream stream_typeName=new RewriteRuleSubtreeStream(adaptor,"rule typeName");
        try {
            // EolParserRules.g:116:2: ( NAME ( ':' pt= typeName )? -> ^( FORMAL NAME ( typeName )? ) )
            // EolParserRules.g:116:4: NAME ( ':' pt= typeName )?
            {
            NAME15=(Token)match(input,NAME,FOLLOW_NAME_in_formalParameter338); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(NAME15);

            // EolParserRules.g:116:9: ( ':' pt= typeName )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==76) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // EolParserRules.g:116:10: ':' pt= typeName
                    {
                    char_literal16=(Token)match(input,76,FOLLOW_76_in_formalParameter341); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_76.add(char_literal16);

                    pushFollow(FOLLOW_typeName_in_formalParameter345);
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
            // 117:3: -> ^( FORMAL NAME ( typeName )? )
            {
                // EolParserRules.g:117:6: ^( FORMAL NAME ( typeName )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FORMAL, "FORMAL"), root_1);

                adaptor.addChild(root_1, stream_NAME.nextNode());
                // EolParserRules.g:117:20: ( typeName )?
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
    // EolParserRules.g:120:1: formalParameterList : formalParameter ( ',' formalParameter )* -> ^( PARAMLIST ( formalParameter )* ) ;
    public final Evl_EolParserRules.formalParameterList_return formalParameterList() throws RecognitionException {
        Evl_EolParserRules.formalParameterList_return retval = new Evl_EolParserRules.formalParameterList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal18=null;
        Evl_EolParserRules.formalParameter_return formalParameter17 = null;

        Evl_EolParserRules.formalParameter_return formalParameter19 = null;


        CommonTree char_literal18_tree=null;
        RewriteRuleTokenStream stream_81=new RewriteRuleTokenStream(adaptor,"token 81");
        RewriteRuleSubtreeStream stream_formalParameter=new RewriteRuleSubtreeStream(adaptor,"rule formalParameter");
        try {
            // EolParserRules.g:121:2: ( formalParameter ( ',' formalParameter )* -> ^( PARAMLIST ( formalParameter )* ) )
            // EolParserRules.g:121:4: formalParameter ( ',' formalParameter )*
            {
            pushFollow(FOLLOW_formalParameter_in_formalParameterList374);
            formalParameter17=formalParameter();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_formalParameter.add(formalParameter17.getTree());
            // EolParserRules.g:121:20: ( ',' formalParameter )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==81) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // EolParserRules.g:121:21: ',' formalParameter
            	    {
            	    char_literal18=(Token)match(input,81,FOLLOW_81_in_formalParameterList377); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_81.add(char_literal18);

            	    pushFollow(FOLLOW_formalParameter_in_formalParameterList379);
            	    formalParameter19=formalParameter();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_formalParameter.add(formalParameter19.getTree());

            	    }
            	    break;

            	default :
            	    break loop7;
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
            // 122:2: -> ^( PARAMLIST ( formalParameter )* )
            {
                // EolParserRules.g:122:5: ^( PARAMLIST ( formalParameter )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PARAMLIST, "PARAMLIST"), root_1);

                // EolParserRules.g:122:17: ( formalParameter )*
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
    // EolParserRules.g:125:1: executableAnnotation : '$' NAME logicalExpression -> ^( EXECUTABLEANNOTATION NAME logicalExpression ) ;
    public final Evl_EolParserRules.executableAnnotation_return executableAnnotation() throws RecognitionException {
        Evl_EolParserRules.executableAnnotation_return retval = new Evl_EolParserRules.executableAnnotation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal20=null;
        Token NAME21=null;
        Evl_EolParserRules.logicalExpression_return logicalExpression22 = null;


        CommonTree char_literal20_tree=null;
        CommonTree NAME21_tree=null;
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_82=new RewriteRuleTokenStream(adaptor,"token 82");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:126:2: ( '$' NAME logicalExpression -> ^( EXECUTABLEANNOTATION NAME logicalExpression ) )
            // EolParserRules.g:126:4: '$' NAME logicalExpression
            {
            char_literal20=(Token)match(input,82,FOLLOW_82_in_executableAnnotation402); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_82.add(char_literal20);

            NAME21=(Token)match(input,NAME,FOLLOW_NAME_in_executableAnnotation404); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(NAME21);

            pushFollow(FOLLOW_logicalExpression_in_executableAnnotation406);
            logicalExpression22=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression22.getTree());


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
            // 127:2: -> ^( EXECUTABLEANNOTATION NAME logicalExpression )
            {
                // EolParserRules.g:127:5: ^( EXECUTABLEANNOTATION NAME logicalExpression )
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
    // EolParserRules.g:130:1: annotation : ( Annotation | executableAnnotation );
    public final Evl_EolParserRules.annotation_return annotation() throws RecognitionException {
        Evl_EolParserRules.annotation_return retval = new Evl_EolParserRules.annotation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token Annotation23=null;
        Evl_EolParserRules.executableAnnotation_return executableAnnotation24 = null;


        CommonTree Annotation23_tree=null;

        try {
            // EolParserRules.g:131:2: ( Annotation | executableAnnotation )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==Annotation) ) {
                alt8=1;
            }
            else if ( (LA8_0==82) ) {
                alt8=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // EolParserRules.g:131:4: Annotation
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    Annotation23=(Token)match(input,Annotation,FOLLOW_Annotation_in_annotation428); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    Annotation23_tree = (CommonTree)adaptor.create(Annotation23);
                    adaptor.addChild(root_0, Annotation23_tree);
                    }

                    }
                    break;
                case 2 :
                    // EolParserRules.g:131:15: executableAnnotation
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_executableAnnotation_in_annotation430);
                    executableAnnotation24=executableAnnotation();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, executableAnnotation24.getTree());

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
    // EolParserRules.g:134:1: annotationBlock : ( annotation )+ -> ^( ANNOTATIONBLOCK ( annotation )+ ) ;
    public final Evl_EolParserRules.annotationBlock_return annotationBlock() throws RecognitionException {
        Evl_EolParserRules.annotationBlock_return retval = new Evl_EolParserRules.annotationBlock_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Evl_EolParserRules.annotation_return annotation25 = null;


        RewriteRuleSubtreeStream stream_annotation=new RewriteRuleSubtreeStream(adaptor,"rule annotation");
        try {
            // EolParserRules.g:135:2: ( ( annotation )+ -> ^( ANNOTATIONBLOCK ( annotation )+ ) )
            // EolParserRules.g:135:4: ( annotation )+
            {
            // EolParserRules.g:135:4: ( annotation )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==Annotation) ) {
                    int LA9_2 = input.LA(2);

                    if ( (synpred9_EolParserRules()) ) {
                        alt9=1;
                    }


                }
                else if ( (LA9_0==82) ) {
                    int LA9_3 = input.LA(2);

                    if ( (synpred9_EolParserRules()) ) {
                        alt9=1;
                    }


                }


                switch (alt9) {
            	case 1 :
            	    // EolParserRules.g:0:0: annotation
            	    {
            	    pushFollow(FOLLOW_annotation_in_annotationBlock441);
            	    annotation25=annotation();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_annotation.add(annotation25.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
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
            // 136:2: -> ^( ANNOTATIONBLOCK ( annotation )+ )
            {
                // EolParserRules.g:136:5: ^( ANNOTATIONBLOCK ( annotation )+ )
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
    // EolParserRules.g:139:1: typeName : ( pathName | nativeType | collectionType );
    public final Evl_EolParserRules.typeName_return typeName() throws RecognitionException {
        Evl_EolParserRules.typeName_return retval = new Evl_EolParserRules.typeName_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Evl_EolParserRules.pathName_return pathName26 = null;

        Evl_EolParserRules.nativeType_return nativeType27 = null;

        Evl_EolParserRules.collectionType_return collectionType28 = null;



        try {
            // EolParserRules.g:140:2: ( pathName | nativeType | collectionType )
            int alt10=3;
            switch ( input.LA(1) ) {
            case NAME:
                {
                alt10=1;
                }
                break;
            case 86:
                {
                alt10=2;
                }
                break;
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
                {
                alt10=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // EolParserRules.g:140:4: pathName
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_pathName_in_typeName464);
                    pathName26=pathName();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pathName26.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:140:15: nativeType
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_nativeType_in_typeName468);
                    nativeType27=nativeType();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nativeType27.getTree());

                    }
                    break;
                case 3 :
                    // EolParserRules.g:140:28: collectionType
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_collectionType_in_typeName472);
                    collectionType28=collectionType();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, collectionType28.getTree());
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
    // EolParserRules.g:144:1: pathName : (metamodel= NAME '!' )? head= NAME ( '::' field= NAME )* ( '#' label= NAME )? ;
    public final Evl_EolParserRules.pathName_return pathName() throws RecognitionException {
        Evl_EolParserRules.pathName_return retval = new Evl_EolParserRules.pathName_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token metamodel=null;
        Token head=null;
        Token field=null;
        Token label=null;
        Token char_literal29=null;
        Token string_literal30=null;
        Token char_literal31=null;

        CommonTree metamodel_tree=null;
        CommonTree head_tree=null;
        CommonTree field_tree=null;
        CommonTree label_tree=null;
        CommonTree char_literal29_tree=null;
        CommonTree string_literal30_tree=null;
        CommonTree char_literal31_tree=null;

        try {
            // EolParserRules.g:145:2: ( (metamodel= NAME '!' )? head= NAME ( '::' field= NAME )* ( '#' label= NAME )? )
            // EolParserRules.g:145:4: (metamodel= NAME '!' )? head= NAME ( '::' field= NAME )* ( '#' label= NAME )?
            {
            root_0 = (CommonTree)adaptor.nil();

            // EolParserRules.g:145:4: (metamodel= NAME '!' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==NAME) ) {
                int LA11_1 = input.LA(2);

                if ( (LA11_1==83) ) {
                    alt11=1;
                }
            }
            switch (alt11) {
                case 1 :
                    // EolParserRules.g:145:5: metamodel= NAME '!'
                    {
                    metamodel=(Token)match(input,NAME,FOLLOW_NAME_in_pathName489); if (state.failed) return retval;
                    char_literal29=(Token)match(input,83,FOLLOW_83_in_pathName492); if (state.failed) return retval;

                    }
                    break;

            }

            head=(Token)match(input,NAME,FOLLOW_NAME_in_pathName499); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            head_tree = (CommonTree)adaptor.create(head);
            adaptor.addChild(root_0, head_tree);
            }
            // EolParserRules.g:146:3: ( '::' field= NAME )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==84) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // EolParserRules.g:146:4: '::' field= NAME
            	    {
            	    string_literal30=(Token)match(input,84,FOLLOW_84_in_pathName504); if (state.failed) return retval;
            	    field=(Token)match(input,NAME,FOLLOW_NAME_in_pathName509); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	      
            	      			head.setText(head.getText()
            	      					+ "::"
            	      					+ field.getText()
            	      					); 
            	      		
            	    }

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            // EolParserRules.g:152:3: ( '#' label= NAME )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==85) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // EolParserRules.g:152:4: '#' label= NAME
                    {
                    char_literal31=(Token)match(input,85,FOLLOW_85_in_pathName519); if (state.failed) return retval;
                    label=(Token)match(input,NAME,FOLLOW_NAME_in_pathName524); if (state.failed) return retval;

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
    // EolParserRules.g:167:1: nativeType : 'Native' '(' STRING ')' ;
    public final Evl_EolParserRules.nativeType_return nativeType() throws RecognitionException {
        Evl_EolParserRules.nativeType_return retval = new Evl_EolParserRules.nativeType_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal32=null;
        Token char_literal33=null;
        Token STRING34=null;
        Token char_literal35=null;

        CommonTree string_literal32_tree=null;
        CommonTree char_literal33_tree=null;
        CommonTree STRING34_tree=null;
        CommonTree char_literal35_tree=null;

        try {
            // EolParserRules.g:168:2: ( 'Native' '(' STRING ')' )
            // EolParserRules.g:168:4: 'Native' '(' STRING ')'
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal32=(Token)match(input,86,FOLLOW_86_in_nativeType544); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal32_tree = (CommonTree)adaptor.create(string_literal32);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal32_tree, root_0);
            }
            char_literal33=(Token)match(input,74,FOLLOW_74_in_nativeType547); if (state.failed) return retval;
            STRING34=(Token)match(input,STRING,FOLLOW_STRING_in_nativeType550); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STRING34_tree = (CommonTree)adaptor.create(STRING34);
            adaptor.addChild(root_0, STRING34_tree);
            }
            char_literal35=(Token)match(input,75,FOLLOW_75_in_nativeType552); if (state.failed) return retval;
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
    // EolParserRules.g:173:1: modelElementType : NAME '!' NAME -> ^( ModelElementType ( NAME )+ ) ;
    public final Evl_EolParserRules.modelElementType_return modelElementType() throws RecognitionException {
        Evl_EolParserRules.modelElementType_return retval = new Evl_EolParserRules.modelElementType_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NAME36=null;
        Token char_literal37=null;
        Token NAME38=null;

        CommonTree NAME36_tree=null;
        CommonTree char_literal37_tree=null;
        CommonTree NAME38_tree=null;
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_83=new RewriteRuleTokenStream(adaptor,"token 83");

        try {
            // EolParserRules.g:174:2: ( NAME '!' NAME -> ^( ModelElementType ( NAME )+ ) )
            // EolParserRules.g:174:4: NAME '!' NAME
            {
            NAME36=(Token)match(input,NAME,FOLLOW_NAME_in_modelElementType569); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(NAME36);

            char_literal37=(Token)match(input,83,FOLLOW_83_in_modelElementType571); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_83.add(char_literal37);

            NAME38=(Token)match(input,NAME,FOLLOW_NAME_in_modelElementType573); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(NAME38);



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
            // 175:2: -> ^( ModelElementType ( NAME )+ )
            {
                // EolParserRules.g:175:5: ^( ModelElementType ( NAME )+ )
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
    // EolParserRules.g:178:1: collectionType : ( 'Collection' | 'Sequence' | 'Bag' | 'Set' | 'OrderedSet' ) ( '(' tn= typeName ')' )? ;
    public final Evl_EolParserRules.collectionType_return collectionType() throws RecognitionException {
        Evl_EolParserRules.collectionType_return retval = new Evl_EolParserRules.collectionType_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set39=null;
        Token char_literal40=null;
        Token char_literal41=null;
        Evl_EolParserRules.typeName_return tn = null;


        CommonTree set39_tree=null;
        CommonTree char_literal40_tree=null;
        CommonTree char_literal41_tree=null;

        try {
            // EolParserRules.g:179:2: ( ( 'Collection' | 'Sequence' | 'Bag' | 'Set' | 'OrderedSet' ) ( '(' tn= typeName ')' )? )
            // EolParserRules.g:179:5: ( 'Collection' | 'Sequence' | 'Bag' | 'Set' | 'OrderedSet' ) ( '(' tn= typeName ')' )?
            {
            root_0 = (CommonTree)adaptor.nil();

            set39=(Token)input.LT(1);
            set39=(Token)input.LT(1);
            if ( (input.LA(1)>=87 && input.LA(1)<=91) ) {
                input.consume();
                if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(set39), root_0);
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            // EolParserRules.g:180:3: ( '(' tn= typeName ')' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==74) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // EolParserRules.g:180:4: '(' tn= typeName ')'
                    {
                    char_literal40=(Token)match(input,74,FOLLOW_74_in_collectionType611); if (state.failed) return retval;
                    pushFollow(FOLLOW_typeName_in_collectionType616);
                    tn=typeName();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, tn.getTree());
                    if ( state.backtracking==0 ) {
                      setTokenType(tn,TYPE);
                    }
                    char_literal41=(Token)match(input,75,FOLLOW_75_in_collectionType619); if (state.failed) return retval;

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
    // EolParserRules.g:186:1: statement : ( statementA | statementB );
    public final Evl_EolParserRules.statement_return statement() throws RecognitionException {
        Evl_EolParserRules.statement_return retval = new Evl_EolParserRules.statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Evl_EolParserRules.statementA_return statementA42 = null;

        Evl_EolParserRules.statementB_return statementB43 = null;



        try {
            // EolParserRules.g:187:2: ( statementA | statementB )
            int alt15=2;
            alt15 = dfa15.predict(input);
            switch (alt15) {
                case 1 :
                    // EolParserRules.g:187:4: statementA
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_statementA_in_statement642);
                    statementA42=statementA();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statementA42.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:187:17: statementB
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_statementB_in_statement646);
                    statementB43=statementB();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statementB43.getTree());

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
    // EolParserRules.g:190:1: statementA : ( assignmentStatement | expressionStatement | forStatement | ifStatement | whileStatement | returnStatement | breakStatement );
    public final Evl_EolParserRules.statementA_return statementA() throws RecognitionException {
        Evl_EolParserRules.statementA_return retval = new Evl_EolParserRules.statementA_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Evl_EolParserRules.assignmentStatement_return assignmentStatement44 = null;

        Evl_EolParserRules.expressionStatement_return expressionStatement45 = null;

        Evl_EolParserRules.forStatement_return forStatement46 = null;

        Evl_EolParserRules.ifStatement_return ifStatement47 = null;

        Evl_EolParserRules.whileStatement_return whileStatement48 = null;

        Evl_EolParserRules.returnStatement_return returnStatement49 = null;

        Evl_EolParserRules.breakStatement_return breakStatement50 = null;



        try {
            // EolParserRules.g:191:2: ( assignmentStatement | expressionStatement | forStatement | ifStatement | whileStatement | returnStatement | breakStatement )
            int alt16=7;
            alt16 = dfa16.predict(input);
            switch (alt16) {
                case 1 :
                    // EolParserRules.g:191:3: assignmentStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_assignmentStatement_in_statementA656);
                    assignmentStatement44=assignmentStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, assignmentStatement44.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:191:25: expressionStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_expressionStatement_in_statementA660);
                    expressionStatement45=expressionStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionStatement45.getTree());

                    }
                    break;
                case 3 :
                    // EolParserRules.g:191:47: forStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_forStatement_in_statementA664);
                    forStatement46=forStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, forStatement46.getTree());

                    }
                    break;
                case 4 :
                    // EolParserRules.g:192:5: ifStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_ifStatement_in_statementA670);
                    ifStatement47=ifStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, ifStatement47.getTree());

                    }
                    break;
                case 5 :
                    // EolParserRules.g:192:19: whileStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_whileStatement_in_statementA674);
                    whileStatement48=whileStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, whileStatement48.getTree());

                    }
                    break;
                case 6 :
                    // EolParserRules.g:192:36: returnStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_returnStatement_in_statementA678);
                    returnStatement49=returnStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, returnStatement49.getTree());

                    }
                    break;
                case 7 :
                    // EolParserRules.g:192:54: breakStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_breakStatement_in_statementA682);
                    breakStatement50=breakStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, breakStatement50.getTree());

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
    // EolParserRules.g:195:1: statementB : ( breakAllStatement | returnStatement | transactionStatement | abortStatement | continueStatement | throwStatement | deleteStatement );
    public final Evl_EolParserRules.statementB_return statementB() throws RecognitionException {
        Evl_EolParserRules.statementB_return retval = new Evl_EolParserRules.statementB_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Evl_EolParserRules.breakAllStatement_return breakAllStatement51 = null;

        Evl_EolParserRules.returnStatement_return returnStatement52 = null;

        Evl_EolParserRules.transactionStatement_return transactionStatement53 = null;

        Evl_EolParserRules.abortStatement_return abortStatement54 = null;

        Evl_EolParserRules.continueStatement_return continueStatement55 = null;

        Evl_EolParserRules.throwStatement_return throwStatement56 = null;

        Evl_EolParserRules.deleteStatement_return deleteStatement57 = null;



        try {
            // EolParserRules.g:196:2: ( breakAllStatement | returnStatement | transactionStatement | abortStatement | continueStatement | throwStatement | deleteStatement )
            int alt17=7;
            switch ( input.LA(1) ) {
            case 101:
                {
                alt17=1;
                }
                break;
            case 97:
                {
                alt17=2;
                }
                break;
            case 104:
                {
                alt17=3;
                }
                break;
            case 103:
                {
                alt17=4;
                }
                break;
            case 102:
                {
                alt17=5;
                }
                break;
            case 98:
                {
                alt17=6;
                }
                break;
            case 99:
                {
                alt17=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // EolParserRules.g:196:4: breakAllStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_breakAllStatement_in_statementB694);
                    breakAllStatement51=breakAllStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, breakAllStatement51.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:196:24: returnStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_returnStatement_in_statementB698);
                    returnStatement52=returnStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, returnStatement52.getTree());

                    }
                    break;
                case 3 :
                    // EolParserRules.g:196:42: transactionStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_transactionStatement_in_statementB702);
                    transactionStatement53=transactionStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, transactionStatement53.getTree());

                    }
                    break;
                case 4 :
                    // EolParserRules.g:197:5: abortStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_abortStatement_in_statementB708);
                    abortStatement54=abortStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, abortStatement54.getTree());

                    }
                    break;
                case 5 :
                    // EolParserRules.g:197:22: continueStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_continueStatement_in_statementB712);
                    continueStatement55=continueStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, continueStatement55.getTree());

                    }
                    break;
                case 6 :
                    // EolParserRules.g:197:42: throwStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_throwStatement_in_statementB716);
                    throwStatement56=throwStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, throwStatement56.getTree());

                    }
                    break;
                case 7 :
                    // EolParserRules.g:198:5: deleteStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_deleteStatement_in_statementB722);
                    deleteStatement57=deleteStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, deleteStatement57.getTree());

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
    // EolParserRules.g:201:1: statementOrStatementBlock : ( statement | statementBlock );
    public final Evl_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock() throws RecognitionException {
        Evl_EolParserRules.statementOrStatementBlock_return retval = new Evl_EolParserRules.statementOrStatementBlock_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Evl_EolParserRules.statement_return statement58 = null;

        Evl_EolParserRules.statementBlock_return statementBlock59 = null;



        try {
            // EolParserRules.g:202:2: ( statement | statementBlock )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==FLOAT||LA18_0==INT||LA18_0==BOOLEAN||LA18_0==STRING||LA18_0==NAME||LA18_0==74||(LA18_0>=86 && LA18_0<=92)||LA18_0==94||(LA18_0>=96 && LA18_0<=104)||LA18_0==118||LA18_0==121||(LA18_0>=123 && LA18_0<=124)) ) {
                alt18=1;
            }
            else if ( (LA18_0==79) ) {
                alt18=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // EolParserRules.g:202:4: statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_statement_in_statementOrStatementBlock733);
                    statement58=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement58.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:202:16: statementBlock
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_statementBlock_in_statementOrStatementBlock737);
                    statementBlock59=statementBlock();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statementBlock59.getTree());

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
    // EolParserRules.g:204:1: expressionOrStatementBlock : ( ':' logicalExpression | statementBlock );
    public final Evl_EolParserRules.expressionOrStatementBlock_return expressionOrStatementBlock() throws RecognitionException {
        Evl_EolParserRules.expressionOrStatementBlock_return retval = new Evl_EolParserRules.expressionOrStatementBlock_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal60=null;
        Evl_EolParserRules.logicalExpression_return logicalExpression61 = null;

        Evl_EolParserRules.statementBlock_return statementBlock62 = null;


        CommonTree char_literal60_tree=null;

        try {
            // EolParserRules.g:205:2: ( ':' logicalExpression | statementBlock )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==76) ) {
                alt19=1;
            }
            else if ( (LA19_0==79) ) {
                alt19=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // EolParserRules.g:205:4: ':' logicalExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    char_literal60=(Token)match(input,76,FOLLOW_76_in_expressionOrStatementBlock746); if (state.failed) return retval;
                    pushFollow(FOLLOW_logicalExpression_in_expressionOrStatementBlock749);
                    logicalExpression61=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression61.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:205:29: statementBlock
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_statementBlock_in_expressionOrStatementBlock753);
                    statementBlock62=statementBlock();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statementBlock62.getTree());

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
    // EolParserRules.g:208:1: forStatement : 'for' '(' formalParameter 'in' logicalExpression ')' statementOrStatementBlock -> ^( FOR formalParameter logicalExpression statementOrStatementBlock ) ;
    public final Evl_EolParserRules.forStatement_return forStatement() throws RecognitionException {
        Evl_EolParserRules.forStatement_return retval = new Evl_EolParserRules.forStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal63=null;
        Token char_literal64=null;
        Token string_literal66=null;
        Token char_literal68=null;
        Evl_EolParserRules.formalParameter_return formalParameter65 = null;

        Evl_EolParserRules.logicalExpression_return logicalExpression67 = null;

        Evl_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock69 = null;


        CommonTree string_literal63_tree=null;
        CommonTree char_literal64_tree=null;
        CommonTree string_literal66_tree=null;
        CommonTree char_literal68_tree=null;
        RewriteRuleTokenStream stream_93=new RewriteRuleTokenStream(adaptor,"token 93");
        RewriteRuleTokenStream stream_92=new RewriteRuleTokenStream(adaptor,"token 92");
        RewriteRuleTokenStream stream_74=new RewriteRuleTokenStream(adaptor,"token 74");
        RewriteRuleTokenStream stream_75=new RewriteRuleTokenStream(adaptor,"token 75");
        RewriteRuleSubtreeStream stream_statementOrStatementBlock=new RewriteRuleSubtreeStream(adaptor,"rule statementOrStatementBlock");
        RewriteRuleSubtreeStream stream_formalParameter=new RewriteRuleSubtreeStream(adaptor,"rule formalParameter");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:209:2: ( 'for' '(' formalParameter 'in' logicalExpression ')' statementOrStatementBlock -> ^( FOR formalParameter logicalExpression statementOrStatementBlock ) )
            // EolParserRules.g:209:4: 'for' '(' formalParameter 'in' logicalExpression ')' statementOrStatementBlock
            {
            string_literal63=(Token)match(input,92,FOLLOW_92_in_forStatement764); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_92.add(string_literal63);

            char_literal64=(Token)match(input,74,FOLLOW_74_in_forStatement766); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_74.add(char_literal64);

            pushFollow(FOLLOW_formalParameter_in_forStatement768);
            formalParameter65=formalParameter();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_formalParameter.add(formalParameter65.getTree());
            string_literal66=(Token)match(input,93,FOLLOW_93_in_forStatement770); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_93.add(string_literal66);

            pushFollow(FOLLOW_logicalExpression_in_forStatement772);
            logicalExpression67=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression67.getTree());
            char_literal68=(Token)match(input,75,FOLLOW_75_in_forStatement774); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_75.add(char_literal68);

            pushFollow(FOLLOW_statementOrStatementBlock_in_forStatement776);
            statementOrStatementBlock69=statementOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_statementOrStatementBlock.add(statementOrStatementBlock69.getTree());


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
            // 210:2: -> ^( FOR formalParameter logicalExpression statementOrStatementBlock )
            {
                // EolParserRules.g:210:5: ^( FOR formalParameter logicalExpression statementOrStatementBlock )
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
    // EolParserRules.g:213:1: ifStatement : 'if' '(' logicalExpression ')' statementOrStatementBlock ( elseStatement )? -> ^( IF logicalExpression statementOrStatementBlock ( elseStatement )? ) ;
    public final Evl_EolParserRules.ifStatement_return ifStatement() throws RecognitionException {
        Evl_EolParserRules.ifStatement_return retval = new Evl_EolParserRules.ifStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal70=null;
        Token char_literal71=null;
        Token char_literal73=null;
        Evl_EolParserRules.logicalExpression_return logicalExpression72 = null;

        Evl_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock74 = null;

        Evl_EolParserRules.elseStatement_return elseStatement75 = null;


        CommonTree string_literal70_tree=null;
        CommonTree char_literal71_tree=null;
        CommonTree char_literal73_tree=null;
        RewriteRuleTokenStream stream_94=new RewriteRuleTokenStream(adaptor,"token 94");
        RewriteRuleTokenStream stream_74=new RewriteRuleTokenStream(adaptor,"token 74");
        RewriteRuleTokenStream stream_75=new RewriteRuleTokenStream(adaptor,"token 75");
        RewriteRuleSubtreeStream stream_statementOrStatementBlock=new RewriteRuleSubtreeStream(adaptor,"rule statementOrStatementBlock");
        RewriteRuleSubtreeStream stream_elseStatement=new RewriteRuleSubtreeStream(adaptor,"rule elseStatement");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:214:2: ( 'if' '(' logicalExpression ')' statementOrStatementBlock ( elseStatement )? -> ^( IF logicalExpression statementOrStatementBlock ( elseStatement )? ) )
            // EolParserRules.g:214:4: 'if' '(' logicalExpression ')' statementOrStatementBlock ( elseStatement )?
            {
            string_literal70=(Token)match(input,94,FOLLOW_94_in_ifStatement800); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_94.add(string_literal70);

            char_literal71=(Token)match(input,74,FOLLOW_74_in_ifStatement802); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_74.add(char_literal71);

            pushFollow(FOLLOW_logicalExpression_in_ifStatement804);
            logicalExpression72=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression72.getTree());
            char_literal73=(Token)match(input,75,FOLLOW_75_in_ifStatement806); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_75.add(char_literal73);

            pushFollow(FOLLOW_statementOrStatementBlock_in_ifStatement808);
            statementOrStatementBlock74=statementOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_statementOrStatementBlock.add(statementOrStatementBlock74.getTree());
            // EolParserRules.g:214:61: ( elseStatement )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==95) ) {
                int LA20_1 = input.LA(2);

                if ( (synpred35_EolParserRules()) ) {
                    alt20=1;
                }
            }
            switch (alt20) {
                case 1 :
                    // EolParserRules.g:0:0: elseStatement
                    {
                    pushFollow(FOLLOW_elseStatement_in_ifStatement810);
                    elseStatement75=elseStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_elseStatement.add(elseStatement75.getTree());

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
            // 215:2: -> ^( IF logicalExpression statementOrStatementBlock ( elseStatement )? )
            {
                // EolParserRules.g:215:5: ^( IF logicalExpression statementOrStatementBlock ( elseStatement )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(IF, "IF"), root_1);

                adaptor.addChild(root_1, stream_logicalExpression.nextTree());
                adaptor.addChild(root_1, stream_statementOrStatementBlock.nextTree());
                // EolParserRules.g:215:54: ( elseStatement )?
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
    // EolParserRules.g:218:1: elseStatement : 'else' statementOrStatementBlock ;
    public final Evl_EolParserRules.elseStatement_return elseStatement() throws RecognitionException {
        Evl_EolParserRules.elseStatement_return retval = new Evl_EolParserRules.elseStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal76=null;
        Evl_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock77 = null;


        CommonTree string_literal76_tree=null;

        try {
            // EolParserRules.g:219:2: ( 'else' statementOrStatementBlock )
            // EolParserRules.g:219:4: 'else' statementOrStatementBlock
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal76=(Token)match(input,95,FOLLOW_95_in_elseStatement837); if (state.failed) return retval;
            pushFollow(FOLLOW_statementOrStatementBlock_in_elseStatement840);
            statementOrStatementBlock77=statementOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, statementOrStatementBlock77.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
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
    // EolParserRules.g:223:1: whileStatement : 'while' '(' logicalExpression ')' statementOrStatementBlock -> ^( WHILE logicalExpression statementOrStatementBlock ) ;
    public final Evl_EolParserRules.whileStatement_return whileStatement() throws RecognitionException {
        Evl_EolParserRules.whileStatement_return retval = new Evl_EolParserRules.whileStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal78=null;
        Token char_literal79=null;
        Token char_literal81=null;
        Evl_EolParserRules.logicalExpression_return logicalExpression80 = null;

        Evl_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock82 = null;


        CommonTree string_literal78_tree=null;
        CommonTree char_literal79_tree=null;
        CommonTree char_literal81_tree=null;
        RewriteRuleTokenStream stream_96=new RewriteRuleTokenStream(adaptor,"token 96");
        RewriteRuleTokenStream stream_74=new RewriteRuleTokenStream(adaptor,"token 74");
        RewriteRuleTokenStream stream_75=new RewriteRuleTokenStream(adaptor,"token 75");
        RewriteRuleSubtreeStream stream_statementOrStatementBlock=new RewriteRuleSubtreeStream(adaptor,"rule statementOrStatementBlock");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:224:2: ( 'while' '(' logicalExpression ')' statementOrStatementBlock -> ^( WHILE logicalExpression statementOrStatementBlock ) )
            // EolParserRules.g:224:4: 'while' '(' logicalExpression ')' statementOrStatementBlock
            {
            string_literal78=(Token)match(input,96,FOLLOW_96_in_whileStatement853); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_96.add(string_literal78);

            char_literal79=(Token)match(input,74,FOLLOW_74_in_whileStatement855); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_74.add(char_literal79);

            pushFollow(FOLLOW_logicalExpression_in_whileStatement857);
            logicalExpression80=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression80.getTree());
            char_literal81=(Token)match(input,75,FOLLOW_75_in_whileStatement859); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_75.add(char_literal81);

            pushFollow(FOLLOW_statementOrStatementBlock_in_whileStatement861);
            statementOrStatementBlock82=statementOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_statementOrStatementBlock.add(statementOrStatementBlock82.getTree());


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
            // 225:2: -> ^( WHILE logicalExpression statementOrStatementBlock )
            {
                // EolParserRules.g:225:5: ^( WHILE logicalExpression statementOrStatementBlock )
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
    // EolParserRules.g:228:1: returnStatement : 'return' ( logicalExpression )? ';' -> ^( RETURN ( logicalExpression )? ) ;
    public final Evl_EolParserRules.returnStatement_return returnStatement() throws RecognitionException {
        Evl_EolParserRules.returnStatement_return retval = new Evl_EolParserRules.returnStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal83=null;
        Token char_literal85=null;
        Evl_EolParserRules.logicalExpression_return logicalExpression84 = null;


        CommonTree string_literal83_tree=null;
        CommonTree char_literal85_tree=null;
        RewriteRuleTokenStream stream_97=new RewriteRuleTokenStream(adaptor,"token 97");
        RewriteRuleTokenStream stream_78=new RewriteRuleTokenStream(adaptor,"token 78");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:229:2: ( 'return' ( logicalExpression )? ';' -> ^( RETURN ( logicalExpression )? ) )
            // EolParserRules.g:229:4: 'return' ( logicalExpression )? ';'
            {
            string_literal83=(Token)match(input,97,FOLLOW_97_in_returnStatement883); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_97.add(string_literal83);

            // EolParserRules.g:229:13: ( logicalExpression )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==FLOAT||LA21_0==INT||LA21_0==BOOLEAN||LA21_0==STRING||LA21_0==NAME||LA21_0==74||(LA21_0>=86 && LA21_0<=91)||LA21_0==118||LA21_0==121||(LA21_0>=123 && LA21_0<=124)) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // EolParserRules.g:0:0: logicalExpression
                    {
                    pushFollow(FOLLOW_logicalExpression_in_returnStatement885);
                    logicalExpression84=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression84.getTree());

                    }
                    break;

            }

            char_literal85=(Token)match(input,78,FOLLOW_78_in_returnStatement888); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_78.add(char_literal85);



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
            // 230:2: -> ^( RETURN ( logicalExpression )? )
            {
                // EolParserRules.g:230:5: ^( RETURN ( logicalExpression )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(RETURN, "RETURN"), root_1);

                // EolParserRules.g:230:14: ( logicalExpression )?
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
    // EolParserRules.g:233:1: throwStatement : 'throw' ( logicalExpression )? ';' -> ^( THROW ( logicalExpression )? ) ;
    public final Evl_EolParserRules.throwStatement_return throwStatement() throws RecognitionException {
        Evl_EolParserRules.throwStatement_return retval = new Evl_EolParserRules.throwStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal86=null;
        Token char_literal88=null;
        Evl_EolParserRules.logicalExpression_return logicalExpression87 = null;


        CommonTree string_literal86_tree=null;
        CommonTree char_literal88_tree=null;
        RewriteRuleTokenStream stream_98=new RewriteRuleTokenStream(adaptor,"token 98");
        RewriteRuleTokenStream stream_78=new RewriteRuleTokenStream(adaptor,"token 78");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:234:2: ( 'throw' ( logicalExpression )? ';' -> ^( THROW ( logicalExpression )? ) )
            // EolParserRules.g:234:4: 'throw' ( logicalExpression )? ';'
            {
            string_literal86=(Token)match(input,98,FOLLOW_98_in_throwStatement909); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_98.add(string_literal86);

            // EolParserRules.g:234:12: ( logicalExpression )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==FLOAT||LA22_0==INT||LA22_0==BOOLEAN||LA22_0==STRING||LA22_0==NAME||LA22_0==74||(LA22_0>=86 && LA22_0<=91)||LA22_0==118||LA22_0==121||(LA22_0>=123 && LA22_0<=124)) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // EolParserRules.g:0:0: logicalExpression
                    {
                    pushFollow(FOLLOW_logicalExpression_in_throwStatement911);
                    logicalExpression87=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression87.getTree());

                    }
                    break;

            }

            char_literal88=(Token)match(input,78,FOLLOW_78_in_throwStatement914); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_78.add(char_literal88);



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
            // 235:2: -> ^( THROW ( logicalExpression )? )
            {
                // EolParserRules.g:235:5: ^( THROW ( logicalExpression )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(THROW, "THROW"), root_1);

                // EolParserRules.g:235:13: ( logicalExpression )?
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
    // EolParserRules.g:238:1: deleteStatement : 'delete' ( logicalExpression )? ';' -> ^( DELETE ( logicalExpression )? ) ;
    public final Evl_EolParserRules.deleteStatement_return deleteStatement() throws RecognitionException {
        Evl_EolParserRules.deleteStatement_return retval = new Evl_EolParserRules.deleteStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal89=null;
        Token char_literal91=null;
        Evl_EolParserRules.logicalExpression_return logicalExpression90 = null;


        CommonTree string_literal89_tree=null;
        CommonTree char_literal91_tree=null;
        RewriteRuleTokenStream stream_78=new RewriteRuleTokenStream(adaptor,"token 78");
        RewriteRuleTokenStream stream_99=new RewriteRuleTokenStream(adaptor,"token 99");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:239:2: ( 'delete' ( logicalExpression )? ';' -> ^( DELETE ( logicalExpression )? ) )
            // EolParserRules.g:239:4: 'delete' ( logicalExpression )? ';'
            {
            string_literal89=(Token)match(input,99,FOLLOW_99_in_deleteStatement935); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_99.add(string_literal89);

            // EolParserRules.g:239:13: ( logicalExpression )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==FLOAT||LA23_0==INT||LA23_0==BOOLEAN||LA23_0==STRING||LA23_0==NAME||LA23_0==74||(LA23_0>=86 && LA23_0<=91)||LA23_0==118||LA23_0==121||(LA23_0>=123 && LA23_0<=124)) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // EolParserRules.g:0:0: logicalExpression
                    {
                    pushFollow(FOLLOW_logicalExpression_in_deleteStatement937);
                    logicalExpression90=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression90.getTree());

                    }
                    break;

            }

            char_literal91=(Token)match(input,78,FOLLOW_78_in_deleteStatement940); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_78.add(char_literal91);



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
            // 240:2: -> ^( DELETE ( logicalExpression )? )
            {
                // EolParserRules.g:240:5: ^( DELETE ( logicalExpression )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(DELETE, "DELETE"), root_1);

                // EolParserRules.g:240:14: ( logicalExpression )?
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
    // EolParserRules.g:243:1: breakStatement : 'break' ';' -> ^( BREAK ) ;
    public final Evl_EolParserRules.breakStatement_return breakStatement() throws RecognitionException {
        Evl_EolParserRules.breakStatement_return retval = new Evl_EolParserRules.breakStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal92=null;
        Token char_literal93=null;

        CommonTree string_literal92_tree=null;
        CommonTree char_literal93_tree=null;
        RewriteRuleTokenStream stream_78=new RewriteRuleTokenStream(adaptor,"token 78");
        RewriteRuleTokenStream stream_100=new RewriteRuleTokenStream(adaptor,"token 100");

        try {
            // EolParserRules.g:244:2: ( 'break' ';' -> ^( BREAK ) )
            // EolParserRules.g:244:4: 'break' ';'
            {
            string_literal92=(Token)match(input,100,FOLLOW_100_in_breakStatement964); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_100.add(string_literal92);

            char_literal93=(Token)match(input,78,FOLLOW_78_in_breakStatement966); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_78.add(char_literal93);



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
            // 245:2: -> ^( BREAK )
            {
                // EolParserRules.g:245:5: ^( BREAK )
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
    // EolParserRules.g:248:1: breakAllStatement : 'breakAll' ';' -> ^( BREAKALL ) ;
    public final Evl_EolParserRules.breakAllStatement_return breakAllStatement() throws RecognitionException {
        Evl_EolParserRules.breakAllStatement_return retval = new Evl_EolParserRules.breakAllStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal94=null;
        Token char_literal95=null;

        CommonTree string_literal94_tree=null;
        CommonTree char_literal95_tree=null;
        RewriteRuleTokenStream stream_78=new RewriteRuleTokenStream(adaptor,"token 78");
        RewriteRuleTokenStream stream_101=new RewriteRuleTokenStream(adaptor,"token 101");

        try {
            // EolParserRules.g:249:2: ( 'breakAll' ';' -> ^( BREAKALL ) )
            // EolParserRules.g:249:4: 'breakAll' ';'
            {
            string_literal94=(Token)match(input,101,FOLLOW_101_in_breakAllStatement984); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_101.add(string_literal94);

            char_literal95=(Token)match(input,78,FOLLOW_78_in_breakAllStatement986); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_78.add(char_literal95);



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
            // 250:2: -> ^( BREAKALL )
            {
                // EolParserRules.g:250:5: ^( BREAKALL )
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
    // EolParserRules.g:253:1: continueStatement : 'continue' ';' -> ^( CONTINUE ) ;
    public final Evl_EolParserRules.continueStatement_return continueStatement() throws RecognitionException {
        Evl_EolParserRules.continueStatement_return retval = new Evl_EolParserRules.continueStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal96=null;
        Token char_literal97=null;

        CommonTree string_literal96_tree=null;
        CommonTree char_literal97_tree=null;
        RewriteRuleTokenStream stream_78=new RewriteRuleTokenStream(adaptor,"token 78");
        RewriteRuleTokenStream stream_102=new RewriteRuleTokenStream(adaptor,"token 102");

        try {
            // EolParserRules.g:254:2: ( 'continue' ';' -> ^( CONTINUE ) )
            // EolParserRules.g:254:4: 'continue' ';'
            {
            string_literal96=(Token)match(input,102,FOLLOW_102_in_continueStatement1004); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_102.add(string_literal96);

            char_literal97=(Token)match(input,78,FOLLOW_78_in_continueStatement1006); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_78.add(char_literal97);



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
            // 255:2: -> ^( CONTINUE )
            {
                // EolParserRules.g:255:5: ^( CONTINUE )
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
    // EolParserRules.g:258:1: abortStatement : 'abort' ';' -> ^( ABORT ) ;
    public final Evl_EolParserRules.abortStatement_return abortStatement() throws RecognitionException {
        Evl_EolParserRules.abortStatement_return retval = new Evl_EolParserRules.abortStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal98=null;
        Token char_literal99=null;

        CommonTree string_literal98_tree=null;
        CommonTree char_literal99_tree=null;
        RewriteRuleTokenStream stream_78=new RewriteRuleTokenStream(adaptor,"token 78");
        RewriteRuleTokenStream stream_103=new RewriteRuleTokenStream(adaptor,"token 103");

        try {
            // EolParserRules.g:259:2: ( 'abort' ';' -> ^( ABORT ) )
            // EolParserRules.g:259:4: 'abort' ';'
            {
            string_literal98=(Token)match(input,103,FOLLOW_103_in_abortStatement1024); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_103.add(string_literal98);

            char_literal99=(Token)match(input,78,FOLLOW_78_in_abortStatement1026); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_78.add(char_literal99);



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
            // 260:2: -> ^( ABORT )
            {
                // EolParserRules.g:260:5: ^( ABORT )
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
    // EolParserRules.g:263:1: transactionStatement : 'transaction' ( NAME ( ',' NAME )* )? statementOrStatementBlock -> ^( TRANSACTION ( NAME )* statementOrStatementBlock ) ;
    public final Evl_EolParserRules.transactionStatement_return transactionStatement() throws RecognitionException {
        Evl_EolParserRules.transactionStatement_return retval = new Evl_EolParserRules.transactionStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal100=null;
        Token NAME101=null;
        Token char_literal102=null;
        Token NAME103=null;
        Evl_EolParserRules.statementOrStatementBlock_return statementOrStatementBlock104 = null;


        CommonTree string_literal100_tree=null;
        CommonTree NAME101_tree=null;
        CommonTree char_literal102_tree=null;
        CommonTree NAME103_tree=null;
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_104=new RewriteRuleTokenStream(adaptor,"token 104");
        RewriteRuleTokenStream stream_81=new RewriteRuleTokenStream(adaptor,"token 81");
        RewriteRuleSubtreeStream stream_statementOrStatementBlock=new RewriteRuleSubtreeStream(adaptor,"rule statementOrStatementBlock");
        try {
            // EolParserRules.g:264:2: ( 'transaction' ( NAME ( ',' NAME )* )? statementOrStatementBlock -> ^( TRANSACTION ( NAME )* statementOrStatementBlock ) )
            // EolParserRules.g:264:4: 'transaction' ( NAME ( ',' NAME )* )? statementOrStatementBlock
            {
            string_literal100=(Token)match(input,104,FOLLOW_104_in_transactionStatement1044); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_104.add(string_literal100);

            // EolParserRules.g:264:18: ( NAME ( ',' NAME )* )?
            int alt25=2;
            alt25 = dfa25.predict(input);
            switch (alt25) {
                case 1 :
                    // EolParserRules.g:264:19: NAME ( ',' NAME )*
                    {
                    NAME101=(Token)match(input,NAME,FOLLOW_NAME_in_transactionStatement1047); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NAME.add(NAME101);

                    // EolParserRules.g:264:24: ( ',' NAME )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==81) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // EolParserRules.g:264:25: ',' NAME
                    	    {
                    	    char_literal102=(Token)match(input,81,FOLLOW_81_in_transactionStatement1050); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_81.add(char_literal102);

                    	    NAME103=(Token)match(input,NAME,FOLLOW_NAME_in_transactionStatement1052); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_NAME.add(NAME103);


                    	    }
                    	    break;

                    	default :
                    	    break loop24;
                        }
                    } while (true);


                    }
                    break;

            }

            pushFollow(FOLLOW_statementOrStatementBlock_in_transactionStatement1058);
            statementOrStatementBlock104=statementOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_statementOrStatementBlock.add(statementOrStatementBlock104.getTree());


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
            // 265:2: -> ^( TRANSACTION ( NAME )* statementOrStatementBlock )
            {
                // EolParserRules.g:265:5: ^( TRANSACTION ( NAME )* statementOrStatementBlock )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TRANSACTION, "TRANSACTION"), root_1);

                // EolParserRules.g:265:19: ( NAME )*
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
    // EolParserRules.g:269:1: assignmentStatement : logicalExpression (normal= ':=' | special= '::=' ) logicalExpression ';' ;
    public final Evl_EolParserRules.assignmentStatement_return assignmentStatement() throws RecognitionException {
        Evl_EolParserRules.assignmentStatement_return retval = new Evl_EolParserRules.assignmentStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token normal=null;
        Token special=null;
        Token char_literal107=null;
        Evl_EolParserRules.logicalExpression_return logicalExpression105 = null;

        Evl_EolParserRules.logicalExpression_return logicalExpression106 = null;


        CommonTree normal_tree=null;
        CommonTree special_tree=null;
        CommonTree char_literal107_tree=null;

        try {
            // EolParserRules.g:273:2: ( logicalExpression (normal= ':=' | special= '::=' ) logicalExpression ';' )
            // EolParserRules.g:273:4: logicalExpression (normal= ':=' | special= '::=' ) logicalExpression ';'
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_logicalExpression_in_assignmentStatement1087);
            logicalExpression105=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression105.getTree());
            // EolParserRules.g:273:22: (normal= ':=' | special= '::=' )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==105) ) {
                alt26=1;
            }
            else if ( (LA26_0==106) ) {
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
                    // EolParserRules.g:273:23: normal= ':='
                    {
                    normal=(Token)match(input,105,FOLLOW_105_in_assignmentStatement1092); if (state.failed) return retval;
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
                    // EolParserRules.g:273:66: special= '::='
                    {
                    special=(Token)match(input,106,FOLLOW_106_in_assignmentStatement1099); if (state.failed) return retval;
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

            pushFollow(FOLLOW_logicalExpression_in_assignmentStatement1105);
            logicalExpression106=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression106.getTree());
            char_literal107=(Token)match(input,78,FOLLOW_78_in_assignmentStatement1107); if (state.failed) return retval;

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
    // EolParserRules.g:277:1: expressionStatement : logicalExpression ';' ;
    public final Evl_EolParserRules.expressionStatement_return expressionStatement() throws RecognitionException {
        Evl_EolParserRules.expressionStatement_return retval = new Evl_EolParserRules.expressionStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal109=null;
        Evl_EolParserRules.logicalExpression_return logicalExpression108 = null;


        CommonTree char_literal109_tree=null;

        try {
            // EolParserRules.g:278:2: ( logicalExpression ';' )
            // EolParserRules.g:278:4: logicalExpression ';'
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_logicalExpression_in_expressionStatement1122);
            logicalExpression108=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression108.getTree());
            char_literal109=(Token)match(input,78,FOLLOW_78_in_expressionStatement1124); if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
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
    // EolParserRules.g:281:1: logicalExpression : relationalExpression ( ( 'or' | 'and' | 'xor' | 'implies' ) relationalExpression )* ;
    public final Evl_EolParserRules.logicalExpression_return logicalExpression() throws RecognitionException {
        Evl_EolParserRules.logicalExpression_return retval = new Evl_EolParserRules.logicalExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set111=null;
        Evl_EolParserRules.relationalExpression_return relationalExpression110 = null;

        Evl_EolParserRules.relationalExpression_return relationalExpression112 = null;


        CommonTree set111_tree=null;

        try {
            // EolParserRules.g:282:2: ( relationalExpression ( ( 'or' | 'and' | 'xor' | 'implies' ) relationalExpression )* )
            // EolParserRules.g:282:4: relationalExpression ( ( 'or' | 'and' | 'xor' | 'implies' ) relationalExpression )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_relationalExpression_in_logicalExpression1136);
            relationalExpression110=relationalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, relationalExpression110.getTree());
            // EolParserRules.g:282:25: ( ( 'or' | 'and' | 'xor' | 'implies' ) relationalExpression )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( ((LA27_0>=107 && LA27_0<=110)) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // EolParserRules.g:282:26: ( 'or' | 'and' | 'xor' | 'implies' ) relationalExpression
            	    {
            	    set111=(Token)input.LT(1);
            	    set111=(Token)input.LT(1);
            	    if ( (input.LA(1)>=107 && input.LA(1)<=110) ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(set111), root_0);
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_relationalExpression_in_logicalExpression1150);
            	    relationalExpression112=relationalExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, relationalExpression112.getTree());
            	    if ( state.backtracking==0 ) {
            	      if (root_0.getToken() != null) root_0.getToken().setType(OPERATOR);
            	    }

            	    }
            	    break;

            	default :
            	    break loop27;
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
    // EolParserRules.g:286:1: relationalExpression : additiveExpression ( ( '=' | '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression )* ;
    public final Evl_EolParserRules.relationalExpression_return relationalExpression() throws RecognitionException {
        Evl_EolParserRules.relationalExpression_return retval = new Evl_EolParserRules.relationalExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set114=null;
        Evl_EolParserRules.additiveExpression_return additiveExpression113 = null;

        Evl_EolParserRules.additiveExpression_return additiveExpression115 = null;


        CommonTree set114_tree=null;

        try {
            // EolParserRules.g:287:2: ( additiveExpression ( ( '=' | '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression )* )
            // EolParserRules.g:287:4: additiveExpression ( ( '=' | '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_additiveExpression_in_relationalExpression1167);
            additiveExpression113=additiveExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, additiveExpression113.getTree());
            // EolParserRules.g:287:23: ( ( '=' | '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( ((LA28_0>=111 && LA28_0<=116)) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // EolParserRules.g:287:24: ( '=' | '>' | '<' | '>=' | '<=' | '<>' ) additiveExpression
            	    {
            	    set114=(Token)input.LT(1);
            	    set114=(Token)input.LT(1);
            	    if ( (input.LA(1)>=111 && input.LA(1)<=116) ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(set114), root_0);
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_additiveExpression_in_relationalExpression1185);
            	    additiveExpression115=additiveExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, additiveExpression115.getTree());
            	    if ( state.backtracking==0 ) {
            	      if (root_0.getToken() != null) root_0.getToken().setType(OPERATOR);
            	    }

            	    }
            	    break;

            	default :
            	    break loop28;
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
    // EolParserRules.g:291:1: additiveExpression : multiplicativeExpression ( ( '+' | '-' ) multiplicativeExpression )* ;
    public final Evl_EolParserRules.additiveExpression_return additiveExpression() throws RecognitionException {
        Evl_EolParserRules.additiveExpression_return retval = new Evl_EolParserRules.additiveExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set117=null;
        Evl_EolParserRules.multiplicativeExpression_return multiplicativeExpression116 = null;

        Evl_EolParserRules.multiplicativeExpression_return multiplicativeExpression118 = null;


        CommonTree set117_tree=null;

        try {
            // EolParserRules.g:292:2: ( multiplicativeExpression ( ( '+' | '-' ) multiplicativeExpression )* )
            // EolParserRules.g:292:4: multiplicativeExpression ( ( '+' | '-' ) multiplicativeExpression )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_multiplicativeExpression_in_additiveExpression1202);
            multiplicativeExpression116=multiplicativeExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, multiplicativeExpression116.getTree());
            // EolParserRules.g:292:29: ( ( '+' | '-' ) multiplicativeExpression )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( ((LA29_0>=117 && LA29_0<=118)) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // EolParserRules.g:292:30: ( '+' | '-' ) multiplicativeExpression
            	    {
            	    set117=(Token)input.LT(1);
            	    set117=(Token)input.LT(1);
            	    if ( (input.LA(1)>=117 && input.LA(1)<=118) ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(set117), root_0);
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_multiplicativeExpression_in_additiveExpression1212);
            	    multiplicativeExpression118=multiplicativeExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, multiplicativeExpression118.getTree());
            	    if ( state.backtracking==0 ) {
            	      if (root_0.getToken() != null) root_0.getToken().setType(OPERATOR);
            	    }

            	    }
            	    break;

            	default :
            	    break loop29;
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
    // EolParserRules.g:297:1: multiplicativeExpression : unaryExpression ( ( '*' | '/' ) unaryExpression )* ;
    public final Evl_EolParserRules.multiplicativeExpression_return multiplicativeExpression() throws RecognitionException {
        Evl_EolParserRules.multiplicativeExpression_return retval = new Evl_EolParserRules.multiplicativeExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set120=null;
        Evl_EolParserRules.unaryExpression_return unaryExpression119 = null;

        Evl_EolParserRules.unaryExpression_return unaryExpression121 = null;


        CommonTree set120_tree=null;

        try {
            // EolParserRules.g:298:2: ( unaryExpression ( ( '*' | '/' ) unaryExpression )* )
            // EolParserRules.g:298:4: unaryExpression ( ( '*' | '/' ) unaryExpression )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_unaryExpression_in_multiplicativeExpression1233);
            unaryExpression119=unaryExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, unaryExpression119.getTree());
            // EolParserRules.g:298:20: ( ( '*' | '/' ) unaryExpression )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( ((LA30_0>=119 && LA30_0<=120)) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // EolParserRules.g:298:21: ( '*' | '/' ) unaryExpression
            	    {
            	    set120=(Token)input.LT(1);
            	    set120=(Token)input.LT(1);
            	    if ( (input.LA(1)>=119 && input.LA(1)<=120) ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(set120), root_0);
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_unaryExpression_in_multiplicativeExpression1243);
            	    unaryExpression121=unaryExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, unaryExpression121.getTree());
            	    if ( state.backtracking==0 ) {
            	      if (root_0.getToken() != null) root_0.getToken().setType(OPERATOR);
            	    }

            	    }
            	    break;

            	default :
            	    break loop30;
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
    // EolParserRules.g:302:1: unaryExpression : ( ( 'not' | '-' ) )? postfixExpression ;
    public final Evl_EolParserRules.unaryExpression_return unaryExpression() throws RecognitionException {
        Evl_EolParserRules.unaryExpression_return retval = new Evl_EolParserRules.unaryExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set122=null;
        Evl_EolParserRules.postfixExpression_return postfixExpression123 = null;


        CommonTree set122_tree=null;

        try {
            // EolParserRules.g:303:2: ( ( ( 'not' | '-' ) )? postfixExpression )
            // EolParserRules.g:303:4: ( ( 'not' | '-' ) )? postfixExpression
            {
            root_0 = (CommonTree)adaptor.nil();

            // EolParserRules.g:303:4: ( ( 'not' | '-' ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==118||LA31_0==121) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // EolParserRules.g:303:5: ( 'not' | '-' )
                    {
                    set122=(Token)input.LT(1);
                    set122=(Token)input.LT(1);
                    if ( input.LA(1)==118||input.LA(1)==121 ) {
                        input.consume();
                        if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(set122), root_0);
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

            pushFollow(FOLLOW_postfixExpression_in_unaryExpression1270);
            postfixExpression123=postfixExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, postfixExpression123.getTree());
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
    // EolParserRules.g:307:1: postfixExpression : primitiveExpression ( ( POINT | ARROW ) fc= featureCall )* ;
    public final Evl_EolParserRules.postfixExpression_return postfixExpression() throws RecognitionException {
        Evl_EolParserRules.postfixExpression_return retval = new Evl_EolParserRules.postfixExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set125=null;
        Evl_EolParserRules.featureCall_return fc = null;

        Evl_EolParserRules.primitiveExpression_return primitiveExpression124 = null;


        CommonTree set125_tree=null;

        try {
            // EolParserRules.g:308:2: ( primitiveExpression ( ( POINT | ARROW ) fc= featureCall )* )
            // EolParserRules.g:308:4: primitiveExpression ( ( POINT | ARROW ) fc= featureCall )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_primitiveExpression_in_postfixExpression1285);
            primitiveExpression124=primitiveExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, primitiveExpression124.getTree());
            // EolParserRules.g:308:23: ( ( POINT | ARROW ) fc= featureCall )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==POINT||LA32_0==ARROW) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // EolParserRules.g:308:24: ( POINT | ARROW ) fc= featureCall
            	    {
            	    set125=(Token)input.LT(1);
            	    set125=(Token)input.LT(1);
            	    if ( input.LA(1)==POINT||input.LA(1)==ARROW ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(set125), root_0);
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_featureCall_in_postfixExpression1296);
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
    // $ANTLR end postfixExpression

    public static class featureCall_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start featureCall
    // EolParserRules.g:318:1: featureCall : ( simpleFeatureCall | declarativeFeatureCall );
    public final Evl_EolParserRules.featureCall_return featureCall() throws RecognitionException {
        Evl_EolParserRules.featureCall_return retval = new Evl_EolParserRules.featureCall_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Evl_EolParserRules.simpleFeatureCall_return simpleFeatureCall126 = null;

        Evl_EolParserRules.declarativeFeatureCall_return declarativeFeatureCall127 = null;



        try {
            // EolParserRules.g:319:2: ( simpleFeatureCall | declarativeFeatureCall )
            int alt33=2;
            alt33 = dfa33.predict(input);
            switch (alt33) {
                case 1 :
                    // EolParserRules.g:319:4: simpleFeatureCall
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_simpleFeatureCall_in_featureCall1331);
                    simpleFeatureCall126=simpleFeatureCall();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, simpleFeatureCall126.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:319:24: declarativeFeatureCall
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_declarativeFeatureCall_in_featureCall1335);
                    declarativeFeatureCall127=declarativeFeatureCall();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, declarativeFeatureCall127.getTree());

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
    // EolParserRules.g:322:1: simpleFeatureCall : NAME ( parameterList )? ;
    public final Evl_EolParserRules.simpleFeatureCall_return simpleFeatureCall() throws RecognitionException {
        Evl_EolParserRules.simpleFeatureCall_return retval = new Evl_EolParserRules.simpleFeatureCall_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NAME128=null;
        Evl_EolParserRules.parameterList_return parameterList129 = null;


        CommonTree NAME128_tree=null;

        try {
            // EolParserRules.g:323:2: ( NAME ( parameterList )? )
            // EolParserRules.g:323:5: NAME ( parameterList )?
            {
            root_0 = (CommonTree)adaptor.nil();

            NAME128=(Token)match(input,NAME,FOLLOW_NAME_in_simpleFeatureCall1347); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME128_tree = (CommonTree)adaptor.create(NAME128);
            root_0 = (CommonTree)adaptor.becomeRoot(NAME128_tree, root_0);
            }
            // EolParserRules.g:323:11: ( parameterList )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==74) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // EolParserRules.g:0:0: parameterList
                    {
                    pushFollow(FOLLOW_parameterList_in_simpleFeatureCall1350);
                    parameterList129=parameterList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, parameterList129.getTree());

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
    // EolParserRules.g:327:1: parameterList : '(' ( logicalExpression ( ',' logicalExpression )* )? ')' -> ^( PARAMETERS ( logicalExpression )* ) ;
    public final Evl_EolParserRules.parameterList_return parameterList() throws RecognitionException {
        Evl_EolParserRules.parameterList_return retval = new Evl_EolParserRules.parameterList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal130=null;
        Token char_literal132=null;
        Token char_literal134=null;
        Evl_EolParserRules.logicalExpression_return logicalExpression131 = null;

        Evl_EolParserRules.logicalExpression_return logicalExpression133 = null;


        CommonTree char_literal130_tree=null;
        CommonTree char_literal132_tree=null;
        CommonTree char_literal134_tree=null;
        RewriteRuleTokenStream stream_81=new RewriteRuleTokenStream(adaptor,"token 81");
        RewriteRuleTokenStream stream_74=new RewriteRuleTokenStream(adaptor,"token 74");
        RewriteRuleTokenStream stream_75=new RewriteRuleTokenStream(adaptor,"token 75");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:328:2: ( '(' ( logicalExpression ( ',' logicalExpression )* )? ')' -> ^( PARAMETERS ( logicalExpression )* ) )
            // EolParserRules.g:328:4: '(' ( logicalExpression ( ',' logicalExpression )* )? ')'
            {
            char_literal130=(Token)match(input,74,FOLLOW_74_in_parameterList1365); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_74.add(char_literal130);

            // EolParserRules.g:328:8: ( logicalExpression ( ',' logicalExpression )* )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==FLOAT||LA36_0==INT||LA36_0==BOOLEAN||LA36_0==STRING||LA36_0==NAME||LA36_0==74||(LA36_0>=86 && LA36_0<=91)||LA36_0==118||LA36_0==121||(LA36_0>=123 && LA36_0<=124)) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // EolParserRules.g:328:9: logicalExpression ( ',' logicalExpression )*
                    {
                    pushFollow(FOLLOW_logicalExpression_in_parameterList1368);
                    logicalExpression131=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression131.getTree());
                    // EolParserRules.g:328:27: ( ',' logicalExpression )*
                    loop35:
                    do {
                        int alt35=2;
                        int LA35_0 = input.LA(1);

                        if ( (LA35_0==81) ) {
                            alt35=1;
                        }


                        switch (alt35) {
                    	case 1 :
                    	    // EolParserRules.g:328:28: ',' logicalExpression
                    	    {
                    	    char_literal132=(Token)match(input,81,FOLLOW_81_in_parameterList1371); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_81.add(char_literal132);

                    	    pushFollow(FOLLOW_logicalExpression_in_parameterList1373);
                    	    logicalExpression133=logicalExpression();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression133.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop35;
                        }
                    } while (true);


                    }
                    break;

            }

            char_literal134=(Token)match(input,75,FOLLOW_75_in_parameterList1379); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_75.add(char_literal134);



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
            // 329:3: -> ^( PARAMETERS ( logicalExpression )* )
            {
                // EolParserRules.g:329:6: ^( PARAMETERS ( logicalExpression )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PARAMETERS, "PARAMETERS"), root_1);

                // EolParserRules.g:329:19: ( logicalExpression )*
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
    // EolParserRules.g:332:1: declarativeFeatureCall : NAME '(' formalParameterList '|' logicalExpression ')' ;
    public final Evl_EolParserRules.declarativeFeatureCall_return declarativeFeatureCall() throws RecognitionException {
        Evl_EolParserRules.declarativeFeatureCall_return retval = new Evl_EolParserRules.declarativeFeatureCall_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NAME135=null;
        Token char_literal136=null;
        Token char_literal138=null;
        Token char_literal140=null;
        Evl_EolParserRules.formalParameterList_return formalParameterList137 = null;

        Evl_EolParserRules.logicalExpression_return logicalExpression139 = null;


        CommonTree NAME135_tree=null;
        CommonTree char_literal136_tree=null;
        CommonTree char_literal138_tree=null;
        CommonTree char_literal140_tree=null;

        try {
            // EolParserRules.g:333:2: ( NAME '(' formalParameterList '|' logicalExpression ')' )
            // EolParserRules.g:333:4: NAME '(' formalParameterList '|' logicalExpression ')'
            {
            root_0 = (CommonTree)adaptor.nil();

            NAME135=(Token)match(input,NAME,FOLLOW_NAME_in_declarativeFeatureCall1401); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME135_tree = (CommonTree)adaptor.create(NAME135);
            root_0 = (CommonTree)adaptor.becomeRoot(NAME135_tree, root_0);
            }
            char_literal136=(Token)match(input,74,FOLLOW_74_in_declarativeFeatureCall1404); if (state.failed) return retval;
            pushFollow(FOLLOW_formalParameterList_in_declarativeFeatureCall1407);
            formalParameterList137=formalParameterList();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, formalParameterList137.getTree());
            char_literal138=(Token)match(input,122,FOLLOW_122_in_declarativeFeatureCall1409); if (state.failed) return retval;
            pushFollow(FOLLOW_logicalExpression_in_declarativeFeatureCall1412);
            logicalExpression139=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression139.getTree());
            char_literal140=(Token)match(input,75,FOLLOW_75_in_declarativeFeatureCall1414); if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
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
    // EolParserRules.g:336:1: newExpression : 'new' tn= typeName ;
    public final Evl_EolParserRules.newExpression_return newExpression() throws RecognitionException {
        Evl_EolParserRules.newExpression_return retval = new Evl_EolParserRules.newExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal141=null;
        Evl_EolParserRules.typeName_return tn = null;


        CommonTree string_literal141_tree=null;

        try {
            // EolParserRules.g:337:2: ( 'new' tn= typeName )
            // EolParserRules.g:337:4: 'new' tn= typeName
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal141=(Token)match(input,123,FOLLOW_123_in_newExpression1426); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal141_tree = (CommonTree)adaptor.create(string_literal141);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal141_tree, root_0);
            }
            pushFollow(FOLLOW_typeName_in_newExpression1431);
            tn=typeName();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, tn.getTree());
            if ( state.backtracking==0 ) {
              setTokenType(tn,TYPE);
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
    // EolParserRules.g:343:1: variableDeclarationExpression : 'var' NAME ( ':' (n= 'new' )? t= typeName )? -> ^( VAR NAME ( typeName )? ) ;
    public final Evl_EolParserRules.variableDeclarationExpression_return variableDeclarationExpression() throws RecognitionException {
        Evl_EolParserRules.variableDeclarationExpression_return retval = new Evl_EolParserRules.variableDeclarationExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token n=null;
        Token string_literal142=null;
        Token NAME143=null;
        Token char_literal144=null;
        Evl_EolParserRules.typeName_return t = null;


        CommonTree n_tree=null;
        CommonTree string_literal142_tree=null;
        CommonTree NAME143_tree=null;
        CommonTree char_literal144_tree=null;
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_123=new RewriteRuleTokenStream(adaptor,"token 123");
        RewriteRuleTokenStream stream_124=new RewriteRuleTokenStream(adaptor,"token 124");
        RewriteRuleTokenStream stream_76=new RewriteRuleTokenStream(adaptor,"token 76");
        RewriteRuleSubtreeStream stream_typeName=new RewriteRuleSubtreeStream(adaptor,"rule typeName");
        try {
            // EolParserRules.g:351:2: ( 'var' NAME ( ':' (n= 'new' )? t= typeName )? -> ^( VAR NAME ( typeName )? ) )
            // EolParserRules.g:351:4: 'var' NAME ( ':' (n= 'new' )? t= typeName )?
            {
            string_literal142=(Token)match(input,124,FOLLOW_124_in_variableDeclarationExpression1457); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_124.add(string_literal142);

            NAME143=(Token)match(input,NAME,FOLLOW_NAME_in_variableDeclarationExpression1459); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(NAME143);

            // EolParserRules.g:351:15: ( ':' (n= 'new' )? t= typeName )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==76) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // EolParserRules.g:351:16: ':' (n= 'new' )? t= typeName
                    {
                    char_literal144=(Token)match(input,76,FOLLOW_76_in_variableDeclarationExpression1462); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_76.add(char_literal144);

                    // EolParserRules.g:351:21: (n= 'new' )?
                    int alt37=2;
                    int LA37_0 = input.LA(1);

                    if ( (LA37_0==123) ) {
                        alt37=1;
                    }
                    switch (alt37) {
                        case 1 :
                            // EolParserRules.g:0:0: n= 'new'
                            {
                            n=(Token)match(input,123,FOLLOW_123_in_variableDeclarationExpression1466); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_123.add(n);


                            }
                            break;

                    }

                    pushFollow(FOLLOW_typeName_in_variableDeclarationExpression1471);
                    t=typeName();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_typeName.add(t.getTree());
                    if ( state.backtracking==0 ) {
                      setTokenType(t, TYPE);
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
            // 352:2: -> ^( VAR NAME ( typeName )? )
            {
                // EolParserRules.g:352:5: ^( VAR NAME ( typeName )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VAR, "VAR"), root_1);

                adaptor.addChild(root_1, stream_NAME.nextNode());
                // EolParserRules.g:352:16: ( typeName )?
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
    // EolParserRules.g:355:1: litteralCollection : ( 'Collection' | 'Sequence' | 'Bag' | 'Set' | 'OrderedSet' ) '{' ( expressionListOrRange )? '}' ;
    public final Evl_EolParserRules.litteralCollection_return litteralCollection() throws RecognitionException {
        Evl_EolParserRules.litteralCollection_return retval = new Evl_EolParserRules.litteralCollection_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set145=null;
        Token char_literal146=null;
        Token char_literal148=null;
        Evl_EolParserRules.expressionListOrRange_return expressionListOrRange147 = null;


        CommonTree set145_tree=null;
        CommonTree char_literal146_tree=null;
        CommonTree char_literal148_tree=null;

        try {
            // EolParserRules.g:356:2: ( ( 'Collection' | 'Sequence' | 'Bag' | 'Set' | 'OrderedSet' ) '{' ( expressionListOrRange )? '}' )
            // EolParserRules.g:356:4: ( 'Collection' | 'Sequence' | 'Bag' | 'Set' | 'OrderedSet' ) '{' ( expressionListOrRange )? '}'
            {
            root_0 = (CommonTree)adaptor.nil();

            set145=(Token)input.LT(1);
            set145=(Token)input.LT(1);
            if ( (input.LA(1)>=87 && input.LA(1)<=91) ) {
                input.consume();
                if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(set145), root_0);
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            char_literal146=(Token)match(input,79,FOLLOW_79_in_litteralCollection1511); if (state.failed) return retval;
            // EolParserRules.g:356:62: ( expressionListOrRange )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==FLOAT||LA39_0==INT||LA39_0==BOOLEAN||LA39_0==STRING||LA39_0==NAME||LA39_0==74||(LA39_0>=86 && LA39_0<=91)||LA39_0==118||LA39_0==121||(LA39_0>=123 && LA39_0<=124)) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // EolParserRules.g:0:0: expressionListOrRange
                    {
                    pushFollow(FOLLOW_expressionListOrRange_in_litteralCollection1515);
                    expressionListOrRange147=expressionListOrRange();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionListOrRange147.getTree());

                    }
                    break;

            }

            char_literal148=(Token)match(input,80,FOLLOW_80_in_litteralCollection1518); if (state.failed) return retval;
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
    // EolParserRules.g:360:1: expressionRange : logicalExpression '..' logicalExpression -> ^( EXPRRANGE ( logicalExpression )+ ) ;
    public final Evl_EolParserRules.expressionRange_return expressionRange() throws RecognitionException {
        Evl_EolParserRules.expressionRange_return retval = new Evl_EolParserRules.expressionRange_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal150=null;
        Evl_EolParserRules.logicalExpression_return logicalExpression149 = null;

        Evl_EolParserRules.logicalExpression_return logicalExpression151 = null;


        CommonTree string_literal150_tree=null;
        RewriteRuleTokenStream stream_POINT_POINT=new RewriteRuleTokenStream(adaptor,"token POINT_POINT");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:361:2: ( logicalExpression '..' logicalExpression -> ^( EXPRRANGE ( logicalExpression )+ ) )
            // EolParserRules.g:361:4: logicalExpression '..' logicalExpression
            {
            pushFollow(FOLLOW_logicalExpression_in_expressionRange1533);
            logicalExpression149=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression149.getTree());
            string_literal150=(Token)match(input,POINT_POINT,FOLLOW_POINT_POINT_in_expressionRange1535); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_POINT_POINT.add(string_literal150);

            pushFollow(FOLLOW_logicalExpression_in_expressionRange1537);
            logicalExpression151=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression151.getTree());


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
            // 362:2: -> ^( EXPRRANGE ( logicalExpression )+ )
            {
                // EolParserRules.g:362:5: ^( EXPRRANGE ( logicalExpression )+ )
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
    // EolParserRules.g:365:1: expressionList : logicalExpression ( ',' logicalExpression )* -> ^( EXPRLIST ( logicalExpression )+ ) ;
    public final Evl_EolParserRules.expressionList_return expressionList() throws RecognitionException {
        Evl_EolParserRules.expressionList_return retval = new Evl_EolParserRules.expressionList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal153=null;
        Evl_EolParserRules.logicalExpression_return logicalExpression152 = null;

        Evl_EolParserRules.logicalExpression_return logicalExpression154 = null;


        CommonTree char_literal153_tree=null;
        RewriteRuleTokenStream stream_81=new RewriteRuleTokenStream(adaptor,"token 81");
        RewriteRuleSubtreeStream stream_logicalExpression=new RewriteRuleSubtreeStream(adaptor,"rule logicalExpression");
        try {
            // EolParserRules.g:366:2: ( logicalExpression ( ',' logicalExpression )* -> ^( EXPRLIST ( logicalExpression )+ ) )
            // EolParserRules.g:366:4: logicalExpression ( ',' logicalExpression )*
            {
            pushFollow(FOLLOW_logicalExpression_in_expressionList1559);
            logicalExpression152=logicalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression152.getTree());
            // EolParserRules.g:366:22: ( ',' logicalExpression )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==81) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // EolParserRules.g:366:23: ',' logicalExpression
            	    {
            	    char_literal153=(Token)match(input,81,FOLLOW_81_in_expressionList1562); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_81.add(char_literal153);

            	    pushFollow(FOLLOW_logicalExpression_in_expressionList1564);
            	    logicalExpression154=logicalExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_logicalExpression.add(logicalExpression154.getTree());

            	    }
            	    break;

            	default :
            	    break loop40;
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
            // 367:2: -> ^( EXPRLIST ( logicalExpression )+ )
            {
                // EolParserRules.g:367:5: ^( EXPRLIST ( logicalExpression )+ )
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
    // EolParserRules.g:370:1: expressionListOrRange : ( expressionRange | expressionList );
    public final Evl_EolParserRules.expressionListOrRange_return expressionListOrRange() throws RecognitionException {
        Evl_EolParserRules.expressionListOrRange_return retval = new Evl_EolParserRules.expressionListOrRange_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Evl_EolParserRules.expressionRange_return expressionRange155 = null;

        Evl_EolParserRules.expressionList_return expressionList156 = null;



        try {
            // EolParserRules.g:371:2: ( expressionRange | expressionList )
            int alt41=2;
            alt41 = dfa41.predict(input);
            switch (alt41) {
                case 1 :
                    // EolParserRules.g:371:4: expressionRange
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_expressionRange_in_expressionListOrRange1588);
                    expressionRange155=expressionRange();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionRange155.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:371:22: expressionList
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_expressionList_in_expressionListOrRange1592);
                    expressionList156=expressionList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionList156.getTree());

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
    // EolParserRules.g:379:1: primitiveExpression : ( litteralCollection | literal | featureCall | pathName | nativeType | collectionType | '(' logicalExpression ')' | newExpression | variableDeclarationExpression );
    public final Evl_EolParserRules.primitiveExpression_return primitiveExpression() throws RecognitionException {
        Evl_EolParserRules.primitiveExpression_return retval = new Evl_EolParserRules.primitiveExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal163=null;
        Token char_literal165=null;
        Evl_EolParserRules.litteralCollection_return litteralCollection157 = null;

        Evl_EolParserRules.literal_return literal158 = null;

        Evl_EolParserRules.featureCall_return featureCall159 = null;

        Evl_EolParserRules.pathName_return pathName160 = null;

        Evl_EolParserRules.nativeType_return nativeType161 = null;

        Evl_EolParserRules.collectionType_return collectionType162 = null;

        Evl_EolParserRules.logicalExpression_return logicalExpression164 = null;

        Evl_EolParserRules.newExpression_return newExpression166 = null;

        Evl_EolParserRules.variableDeclarationExpression_return variableDeclarationExpression167 = null;


        CommonTree char_literal163_tree=null;
        CommonTree char_literal165_tree=null;

        try {
            // EolParserRules.g:380:2: ( litteralCollection | literal | featureCall | pathName | nativeType | collectionType | '(' logicalExpression ')' | newExpression | variableDeclarationExpression )
            int alt42=9;
            alt42 = dfa42.predict(input);
            switch (alt42) {
                case 1 :
                    // EolParserRules.g:380:4: litteralCollection
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_litteralCollection_in_primitiveExpression1614);
                    litteralCollection157=litteralCollection();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, litteralCollection157.getTree());

                    }
                    break;
                case 2 :
                    // EolParserRules.g:380:25: literal
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_literal_in_primitiveExpression1618);
                    literal158=literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, literal158.getTree());

                    }
                    break;
                case 3 :
                    // EolParserRules.g:380:35: featureCall
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_featureCall_in_primitiveExpression1622);
                    featureCall159=featureCall();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, featureCall159.getTree());

                    }
                    break;
                case 4 :
                    // EolParserRules.g:380:49: pathName
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_pathName_in_primitiveExpression1626);
                    pathName160=pathName();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pathName160.getTree());

                    }
                    break;
                case 5 :
                    // EolParserRules.g:380:60: nativeType
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_nativeType_in_primitiveExpression1630);
                    nativeType161=nativeType();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nativeType161.getTree());

                    }
                    break;
                case 6 :
                    // EolParserRules.g:381:5: collectionType
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_collectionType_in_primitiveExpression1636);
                    collectionType162=collectionType();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, collectionType162.getTree());

                    }
                    break;
                case 7 :
                    // EolParserRules.g:381:23: '(' logicalExpression ')'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    char_literal163=(Token)match(input,74,FOLLOW_74_in_primitiveExpression1641); if (state.failed) return retval;
                    pushFollow(FOLLOW_logicalExpression_in_primitiveExpression1644);
                    logicalExpression164=logicalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalExpression164.getTree());
                    char_literal165=(Token)match(input,75,FOLLOW_75_in_primitiveExpression1646); if (state.failed) return retval;

                    }
                    break;
                case 8 :
                    // EolParserRules.g:382:5: newExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_newExpression_in_primitiveExpression1654);
                    newExpression166=newExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, newExpression166.getTree());

                    }
                    break;
                case 9 :
                    // EolParserRules.g:382:21: variableDeclarationExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_variableDeclarationExpression_in_primitiveExpression1658);
                    variableDeclarationExpression167=variableDeclarationExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, variableDeclarationExpression167.getTree());

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
    // EolParserRules.g:385:1: literal : ( STRING | INT | FLOAT | BOOLEAN );
    public final Evl_EolParserRules.literal_return literal() throws RecognitionException {
        Evl_EolParserRules.literal_return retval = new Evl_EolParserRules.literal_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set168=null;

        CommonTree set168_tree=null;

        try {
            // EolParserRules.g:386:2: ( STRING | INT | FLOAT | BOOLEAN )
            // EolParserRules.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set168=(Token)input.LT(1);
            if ( input.LA(1)==FLOAT||input.LA(1)==INT||input.LA(1)==BOOLEAN||input.LA(1)==STRING ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set168));
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

    // $ANTLR start synpred9_EolParserRules
    public final void synpred9_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:135:4: ( annotation )
        // EolParserRules.g:135:4: annotation
        {
        pushFollow(FOLLOW_annotation_in_synpred9_EolParserRules441);
        annotation();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred9_EolParserRules

    // $ANTLR start synpred20_EolParserRules
    public final void synpred20_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:187:4: ( statementA )
        // EolParserRules.g:187:4: statementA
        {
        pushFollow(FOLLOW_statementA_in_synpred20_EolParserRules642);
        statementA();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred20_EolParserRules

    // $ANTLR start synpred21_EolParserRules
    public final void synpred21_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:191:3: ( assignmentStatement )
        // EolParserRules.g:191:3: assignmentStatement
        {
        pushFollow(FOLLOW_assignmentStatement_in_synpred21_EolParserRules656);
        assignmentStatement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred21_EolParserRules

    // $ANTLR start synpred22_EolParserRules
    public final void synpred22_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:191:25: ( expressionStatement )
        // EolParserRules.g:191:25: expressionStatement
        {
        pushFollow(FOLLOW_expressionStatement_in_synpred22_EolParserRules660);
        expressionStatement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred22_EolParserRules

    // $ANTLR start synpred35_EolParserRules
    public final void synpred35_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:214:61: ( elseStatement )
        // EolParserRules.g:214:61: elseStatement
        {
        pushFollow(FOLLOW_elseStatement_in_synpred35_EolParserRules810);
        elseStatement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred35_EolParserRules

    // $ANTLR start synpred40_EolParserRules
    public final void synpred40_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:264:19: ( NAME ( ',' NAME )* )
        // EolParserRules.g:264:19: NAME ( ',' NAME )*
        {
        match(input,NAME,FOLLOW_NAME_in_synpred40_EolParserRules1047); if (state.failed) return ;
        // EolParserRules.g:264:24: ( ',' NAME )*
        loop43:
        do {
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==81) ) {
                alt43=1;
            }


            switch (alt43) {
        	case 1 :
        	    // EolParserRules.g:264:25: ',' NAME
        	    {
        	    match(input,81,FOLLOW_81_in_synpred40_EolParserRules1050); if (state.failed) return ;
        	    match(input,NAME,FOLLOW_NAME_in_synpred40_EolParserRules1052); if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop43;
            }
        } while (true);


        }
    }
    // $ANTLR end synpred40_EolParserRules

    // $ANTLR start synpred72_EolParserRules
    public final void synpred72_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:371:4: ( expressionRange )
        // EolParserRules.g:371:4: expressionRange
        {
        pushFollow(FOLLOW_expressionRange_in_synpred72_EolParserRules1588);
        expressionRange();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred72_EolParserRules

    // $ANTLR start synpred75_EolParserRules
    public final void synpred75_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:380:35: ( featureCall )
        // EolParserRules.g:380:35: featureCall
        {
        pushFollow(FOLLOW_featureCall_in_synpred75_EolParserRules1622);
        featureCall();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred75_EolParserRules

    // $ANTLR start synpred76_EolParserRules
    public final void synpred76_EolParserRules_fragment() throws RecognitionException {   
        // EolParserRules.g:380:49: ( pathName )
        // EolParserRules.g:380:49: pathName
        {
        pushFollow(FOLLOW_pathName_in_synpred76_EolParserRules1626);
        pathName();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred76_EolParserRules

    // Delegated rules

    public final boolean synpred21_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred21_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred72_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred72_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
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
    public final boolean synpred20_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred20_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred22_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred22_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred9_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred75_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred75_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred35_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred35_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred76_EolParserRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred76_EolParserRules_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA15 dfa15 = new DFA15(this);
    protected DFA16 dfa16 = new DFA16(this);
    protected DFA25 dfa25 = new DFA25(this);
    protected DFA33 dfa33 = new DFA33(this);
    protected DFA41 dfa41 = new DFA41(this);
    protected DFA42 dfa42 = new DFA42(this);
    static final String DFA15_eotS =
        "\24\uffff";
    static final String DFA15_eofS =
        "\24\uffff";
    static final String DFA15_minS =
        "\1\4\13\uffff\1\0\7\uffff";
    static final String DFA15_maxS =
        "\1\174\13\uffff\1\0\7\uffff";
    static final String DFA15_acceptS =
        "\1\uffff\1\1\14\uffff\1\2\5\uffff";
    static final String DFA15_specialS =
        "\14\uffff\1\0\7\uffff}>";
    static final String[] DFA15_transitionS = {
            "\1\1\1\uffff\1\1\3\uffff\1\1\1\uffff\1\1\3\uffff\1\1\71\uffff"+
            "\1\1\13\uffff\7\1\1\uffff\1\1\1\uffff\1\1\1\14\2\16\1\1\4\16"+
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

    static final short[] DFA15_eot = DFA.unpackEncodedString(DFA15_eotS);
    static final short[] DFA15_eof = DFA.unpackEncodedString(DFA15_eofS);
    static final char[] DFA15_min = DFA.unpackEncodedStringToUnsignedChars(DFA15_minS);
    static final char[] DFA15_max = DFA.unpackEncodedStringToUnsignedChars(DFA15_maxS);
    static final short[] DFA15_accept = DFA.unpackEncodedString(DFA15_acceptS);
    static final short[] DFA15_special = DFA.unpackEncodedString(DFA15_specialS);
    static final short[][] DFA15_transition;

    static {
        int numStates = DFA15_transitionS.length;
        DFA15_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA15_transition[i] = DFA.unpackEncodedString(DFA15_transitionS[i]);
        }
    }

    class DFA15 extends DFA {

        public DFA15(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 15;
            this.eot = DFA15_eot;
            this.eof = DFA15_eof;
            this.min = DFA15_min;
            this.max = DFA15_max;
            this.accept = DFA15_accept;
            this.special = DFA15_special;
            this.transition = DFA15_transition;
        }
        public String getDescription() {
            return "186:1: statement : ( statementA | statementB );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA15_12 = input.LA(1);

                         
                        int index15_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred20_EolParserRules()) ) {s = 1;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index15_12);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 15, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA16_eotS =
        "\20\uffff";
    static final String DFA16_eofS =
        "\20\uffff";
    static final String DFA16_minS =
        "\1\4\10\0\7\uffff";
    static final String DFA16_maxS =
        "\1\174\10\0\7\uffff";
    static final String DFA16_acceptS =
        "\11\uffff\1\3\1\4\1\5\1\6\1\7\1\1\1\2";
    static final String DFA16_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\7\uffff}>";
    static final String[] DFA16_transitionS = {
            "\1\3\1\uffff\1\3\3\uffff\1\3\1\uffff\1\3\3\uffff\1\4\71\uffff"+
            "\1\6\13\uffff\1\5\5\2\1\11\1\uffff\1\12\1\uffff\1\13\1\14\2"+
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

    static final short[] DFA16_eot = DFA.unpackEncodedString(DFA16_eotS);
    static final short[] DFA16_eof = DFA.unpackEncodedString(DFA16_eofS);
    static final char[] DFA16_min = DFA.unpackEncodedStringToUnsignedChars(DFA16_minS);
    static final char[] DFA16_max = DFA.unpackEncodedStringToUnsignedChars(DFA16_maxS);
    static final short[] DFA16_accept = DFA.unpackEncodedString(DFA16_acceptS);
    static final short[] DFA16_special = DFA.unpackEncodedString(DFA16_specialS);
    static final short[][] DFA16_transition;

    static {
        int numStates = DFA16_transitionS.length;
        DFA16_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA16_transition[i] = DFA.unpackEncodedString(DFA16_transitionS[i]);
        }
    }

    class DFA16 extends DFA {

        public DFA16(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 16;
            this.eot = DFA16_eot;
            this.eof = DFA16_eof;
            this.min = DFA16_min;
            this.max = DFA16_max;
            this.accept = DFA16_accept;
            this.special = DFA16_special;
            this.transition = DFA16_transition;
        }
        public String getDescription() {
            return "190:1: statementA : ( assignmentStatement | expressionStatement | forStatement | ifStatement | whileStatement | returnStatement | breakStatement );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA16_1 = input.LA(1);

                         
                        int index16_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred21_EolParserRules()) ) {s = 14;}

                        else if ( (synpred22_EolParserRules()) ) {s = 15;}

                         
                        input.seek(index16_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA16_2 = input.LA(1);

                         
                        int index16_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred21_EolParserRules()) ) {s = 14;}

                        else if ( (synpred22_EolParserRules()) ) {s = 15;}

                         
                        input.seek(index16_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA16_3 = input.LA(1);

                         
                        int index16_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred21_EolParserRules()) ) {s = 14;}

                        else if ( (synpred22_EolParserRules()) ) {s = 15;}

                         
                        input.seek(index16_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA16_4 = input.LA(1);

                         
                        int index16_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred21_EolParserRules()) ) {s = 14;}

                        else if ( (synpred22_EolParserRules()) ) {s = 15;}

                         
                        input.seek(index16_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA16_5 = input.LA(1);

                         
                        int index16_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred21_EolParserRules()) ) {s = 14;}

                        else if ( (synpred22_EolParserRules()) ) {s = 15;}

                         
                        input.seek(index16_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA16_6 = input.LA(1);

                         
                        int index16_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred21_EolParserRules()) ) {s = 14;}

                        else if ( (synpred22_EolParserRules()) ) {s = 15;}

                         
                        input.seek(index16_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA16_7 = input.LA(1);

                         
                        int index16_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred21_EolParserRules()) ) {s = 14;}

                        else if ( (synpred22_EolParserRules()) ) {s = 15;}

                         
                        input.seek(index16_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA16_8 = input.LA(1);

                         
                        int index16_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred21_EolParserRules()) ) {s = 14;}

                        else if ( (synpred22_EolParserRules()) ) {s = 15;}

                         
                        input.seek(index16_8);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 16, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA25_eotS =
        "\26\uffff";
    static final String DFA25_eofS =
        "\26\uffff";
    static final String DFA25_minS =
        "\1\4\1\0\24\uffff";
    static final String DFA25_maxS =
        "\1\174\1\0\24\uffff";
    static final String DFA25_acceptS =
        "\2\uffff\1\2\22\uffff\1\1";
    static final String DFA25_specialS =
        "\1\uffff\1\0\24\uffff}>";
    static final String[] DFA25_transitionS = {
            "\1\2\1\uffff\1\2\3\uffff\1\2\1\uffff\1\2\3\uffff\1\1\71\uffff"+
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

    static final short[] DFA25_eot = DFA.unpackEncodedString(DFA25_eotS);
    static final short[] DFA25_eof = DFA.unpackEncodedString(DFA25_eofS);
    static final char[] DFA25_min = DFA.unpackEncodedStringToUnsignedChars(DFA25_minS);
    static final char[] DFA25_max = DFA.unpackEncodedStringToUnsignedChars(DFA25_maxS);
    static final short[] DFA25_accept = DFA.unpackEncodedString(DFA25_acceptS);
    static final short[] DFA25_special = DFA.unpackEncodedString(DFA25_specialS);
    static final short[][] DFA25_transition;

    static {
        int numStates = DFA25_transitionS.length;
        DFA25_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA25_transition[i] = DFA.unpackEncodedString(DFA25_transitionS[i]);
        }
    }

    class DFA25 extends DFA {

        public DFA25(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 25;
            this.eot = DFA25_eot;
            this.eof = DFA25_eof;
            this.min = DFA25_min;
            this.max = DFA25_max;
            this.accept = DFA25_accept;
            this.special = DFA25_special;
            this.transition = DFA25_transition;
        }
        public String getDescription() {
            return "264:18: ( NAME ( ',' NAME )* )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA25_1 = input.LA(1);

                         
                        int index25_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred40_EolParserRules()) ) {s = 21;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index25_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 25, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA33_eotS =
        "\10\uffff";
    static final String DFA33_eofS =
        "\1\uffff\1\3\6\uffff";
    static final String DFA33_minS =
        "\1\20\1\7\1\4\1\uffff\1\7\1\uffff\1\4\1\7";
    static final String DFA33_maxS =
        "\1\20\1\u0088\1\174\1\uffff\1\172\1\uffff\1\174\1\172";
    static final String DFA33_acceptS =
        "\3\uffff\1\1\1\uffff\1\2\2\uffff";
    static final String DFA33_specialS =
        "\10\uffff}>";
    static final String[] DFA33_transitionS = {
            "\1\1",
            "\3\3\12\uffff\1\3\64\uffff\1\3\1\2\1\3\2\uffff\1\3\1\uffff\3"+
            "\3\26\uffff\20\3\4\uffff\2\3\2\uffff\6\3\1\uffff\1\3",
            "\1\3\1\uffff\1\3\3\uffff\1\3\1\uffff\1\3\3\uffff\1\4\71\uffff"+
            "\2\3\12\uffff\6\3\32\uffff\1\3\2\uffff\1\3\1\uffff\2\3",
            "",
            "\1\3\1\uffff\1\3\100\uffff\2\3\1\5\4\uffff\1\6\1\uffff\3\3\25"+
            "\uffff\16\3\1\uffff\1\5",
            "",
            "\1\3\1\uffff\1\3\3\uffff\1\3\1\uffff\1\3\3\uffff\1\7\71\uffff"+
            "\1\3\13\uffff\6\3\32\uffff\1\3\2\uffff\1\3\1\uffff\2\3",
            "\1\3\1\uffff\1\3\100\uffff\2\3\1\5\4\uffff\1\6\1\uffff\3\3\25"+
            "\uffff\16\3\1\uffff\1\5"
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
            return "318:1: featureCall : ( simpleFeatureCall | declarativeFeatureCall );";
        }
    }
    static final String DFA41_eotS =
        "\13\uffff";
    static final String DFA41_eofS =
        "\13\uffff";
    static final String DFA41_minS =
        "\1\4\10\0\2\uffff";
    static final String DFA41_maxS =
        "\1\174\10\0\2\uffff";
    static final String DFA41_acceptS =
        "\11\uffff\1\1\1\2";
    static final String DFA41_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\2\uffff}>";
    static final String[] DFA41_transitionS = {
            "\1\3\1\uffff\1\3\3\uffff\1\3\1\uffff\1\3\3\uffff\1\4\71\uffff"+
            "\1\6\13\uffff\1\5\5\2\32\uffff\1\1\2\uffff\1\1\1\uffff\1\7\1"+
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
            return "370:1: expressionListOrRange : ( expressionRange | expressionList );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA41_1 = input.LA(1);

                         
                        int index41_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred72_EolParserRules()) ) {s = 9;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index41_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA41_2 = input.LA(1);

                         
                        int index41_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred72_EolParserRules()) ) {s = 9;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index41_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA41_3 = input.LA(1);

                         
                        int index41_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred72_EolParserRules()) ) {s = 9;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index41_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA41_4 = input.LA(1);

                         
                        int index41_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred72_EolParserRules()) ) {s = 9;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index41_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA41_5 = input.LA(1);

                         
                        int index41_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred72_EolParserRules()) ) {s = 9;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index41_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA41_6 = input.LA(1);

                         
                        int index41_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred72_EolParserRules()) ) {s = 9;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index41_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA41_7 = input.LA(1);

                         
                        int index41_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred72_EolParserRules()) ) {s = 9;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index41_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA41_8 = input.LA(1);

                         
                        int index41_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred72_EolParserRules()) ) {s = 9;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index41_8);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 41, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA42_eotS =
        "\14\uffff";
    static final String DFA42_eofS =
        "\1\uffff\1\11\12\uffff";
    static final String DFA42_minS =
        "\1\4\1\7\1\uffff\1\0\10\uffff";
    static final String DFA42_maxS =
        "\1\174\1\u0088\1\uffff\1\0\10\uffff";
    static final String DFA42_acceptS =
        "\2\uffff\1\2\1\uffff\1\5\1\7\1\10\1\11\1\1\1\6\1\3\1\4";
    static final String DFA42_specialS =
        "\3\uffff\1\0\10\uffff}>";
    static final String[] DFA42_transitionS = {
            "\1\2\1\uffff\1\2\3\uffff\1\2\1\uffff\1\2\3\uffff\1\3\71\uffff"+
            "\1\5\13\uffff\1\4\5\1\37\uffff\1\6\1\7",
            "\3\11\12\uffff\1\11\64\uffff\3\11\2\uffff\1\11\1\10\3\11\26"+
            "\uffff\20\11\4\uffff\2\11\2\uffff\6\11\1\uffff\1\11",
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

    static final short[] DFA42_eot = DFA.unpackEncodedString(DFA42_eotS);
    static final short[] DFA42_eof = DFA.unpackEncodedString(DFA42_eofS);
    static final char[] DFA42_min = DFA.unpackEncodedStringToUnsignedChars(DFA42_minS);
    static final char[] DFA42_max = DFA.unpackEncodedStringToUnsignedChars(DFA42_maxS);
    static final short[] DFA42_accept = DFA.unpackEncodedString(DFA42_acceptS);
    static final short[] DFA42_special = DFA.unpackEncodedString(DFA42_specialS);
    static final short[][] DFA42_transition;

    static {
        int numStates = DFA42_transitionS.length;
        DFA42_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA42_transition[i] = DFA.unpackEncodedString(DFA42_transitionS[i]);
        }
    }

    class DFA42 extends DFA {

        public DFA42(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 42;
            this.eot = DFA42_eot;
            this.eof = DFA42_eof;
            this.min = DFA42_min;
            this.max = DFA42_max;
            this.accept = DFA42_accept;
            this.special = DFA42_special;
            this.transition = DFA42_transition;
        }
        public String getDescription() {
            return "379:1: primitiveExpression : ( litteralCollection | literal | featureCall | pathName | nativeType | collectionType | '(' logicalExpression ')' | newExpression | variableDeclarationExpression );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA42_3 = input.LA(1);

                         
                        int index42_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred75_EolParserRules()) ) {s = 10;}

                        else if ( (synpred76_EolParserRules()) ) {s = 11;}

                         
                        input.seek(index42_3);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 42, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_operationDeclaration_in_operationDeclarationOrAnnotationBlock194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationBlock_in_operationDeclarationOrAnnotationBlock196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_operationDeclaration209 = new BitSet(new long[]{0x0000000000010000L,0x000000000FC00000L});
    public static final BitSet FOLLOW_typeName_in_operationDeclaration214 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NAME_in_operationDeclaration222 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_74_in_operationDeclaration224 = new BitSet(new long[]{0x0000000000010000L,0x0000000000000800L});
    public static final BitSet FOLLOW_formalParameterList_in_operationDeclaration226 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_operationDeclaration229 = new BitSet(new long[]{0x0000000000000000L,0x0000000000009000L});
    public static final BitSet FOLLOW_76_in_operationDeclaration232 = new BitSet(new long[]{0x0000000000010000L,0x000000000FC00000L});
    public static final BitSet FOLLOW_typeName_in_operationDeclaration236 = new BitSet(new long[]{0x0000000000000000L,0x0000000000009000L});
    public static final BitSet FOLLOW_statementBlock_in_operationDeclaration242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_importStatement279 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_STRING_in_importStatement282 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_importStatement284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_block299 = new BitSet(new long[]{0x0000000000011452L,0x1A4001FF5FC00400L});
    public static final BitSet FOLLOW_79_in_statementBlock321 = new BitSet(new long[]{0x0000000000011450L,0x1A4001FF5FC00400L});
    public static final BitSet FOLLOW_block_in_statementBlock324 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_80_in_statementBlock326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_formalParameter338 = new BitSet(new long[]{0x0000000000000002L,0x0000000000001000L});
    public static final BitSet FOLLOW_76_in_formalParameter341 = new BitSet(new long[]{0x0000000000010000L,0x000000000FC00000L});
    public static final BitSet FOLLOW_typeName_in_formalParameter345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_formalParameter_in_formalParameterList374 = new BitSet(new long[]{0x0000000000000002L,0x0000000000020000L});
    public static final BitSet FOLLOW_81_in_formalParameterList377 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_formalParameter_in_formalParameterList379 = new BitSet(new long[]{0x0000000000000002L,0x0000000000020000L});
    public static final BitSet FOLLOW_82_in_executableAnnotation402 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NAME_in_executableAnnotation404 = new BitSet(new long[]{0x0000000000011450L,0x1A4000000FC00400L});
    public static final BitSet FOLLOW_logicalExpression_in_executableAnnotation406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Annotation_in_annotation428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_executableAnnotation_in_annotation430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotation_in_annotationBlock441 = new BitSet(new long[]{0x0000000000100002L,0x0000000000040000L});
    public static final BitSet FOLLOW_pathName_in_typeName464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nativeType_in_typeName468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectionType_in_typeName472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_pathName489 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_83_in_pathName492 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NAME_in_pathName499 = new BitSet(new long[]{0x0000000000000002L,0x0000000000300000L});
    public static final BitSet FOLLOW_84_in_pathName504 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NAME_in_pathName509 = new BitSet(new long[]{0x0000000000000002L,0x0000000000300000L});
    public static final BitSet FOLLOW_85_in_pathName519 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NAME_in_pathName524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_86_in_nativeType544 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_74_in_nativeType547 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_STRING_in_nativeType550 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_nativeType552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_modelElementType569 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_83_in_modelElementType571 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NAME_in_modelElementType573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_collectionType595 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000400L});
    public static final BitSet FOLLOW_74_in_collectionType611 = new BitSet(new long[]{0x0000000000010000L,0x000000000FC00000L});
    public static final BitSet FOLLOW_typeName_in_collectionType616 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_collectionType619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementA_in_statement642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementB_in_statement646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignmentStatement_in_statementA656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionStatement_in_statementA660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_forStatement_in_statementA664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStatement_in_statementA670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_whileStatement_in_statementA674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_returnStatement_in_statementA678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_breakStatement_in_statementA682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_breakAllStatement_in_statementB694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_returnStatement_in_statementB698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_transactionStatement_in_statementB702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_abortStatement_in_statementB708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_continueStatement_in_statementB712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_throwStatement_in_statementB716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_deleteStatement_in_statementB722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_statementOrStatementBlock733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementBlock_in_statementOrStatementBlock737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_expressionOrStatementBlock746 = new BitSet(new long[]{0x0000000000011450L,0x1A4000000FC00400L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionOrStatementBlock749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementBlock_in_expressionOrStatementBlock753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_92_in_forStatement764 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_74_in_forStatement766 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_formalParameter_in_forStatement768 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_forStatement770 = new BitSet(new long[]{0x0000000000011450L,0x1A4000000FC00400L});
    public static final BitSet FOLLOW_logicalExpression_in_forStatement772 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_forStatement774 = new BitSet(new long[]{0x0000000000011450L,0x1A4001FF5FC09400L});
    public static final BitSet FOLLOW_statementOrStatementBlock_in_forStatement776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_ifStatement800 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_74_in_ifStatement802 = new BitSet(new long[]{0x0000000000011450L,0x1A4000000FC00400L});
    public static final BitSet FOLLOW_logicalExpression_in_ifStatement804 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_ifStatement806 = new BitSet(new long[]{0x0000000000011450L,0x1A4001FF5FC09400L});
    public static final BitSet FOLLOW_statementOrStatementBlock_in_ifStatement808 = new BitSet(new long[]{0x0000000000000002L,0x0000000080000000L});
    public static final BitSet FOLLOW_elseStatement_in_ifStatement810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_95_in_elseStatement837 = new BitSet(new long[]{0x0000000000011450L,0x1A4001FF5FC09400L});
    public static final BitSet FOLLOW_statementOrStatementBlock_in_elseStatement840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_96_in_whileStatement853 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_74_in_whileStatement855 = new BitSet(new long[]{0x0000000000011450L,0x1A4000000FC00400L});
    public static final BitSet FOLLOW_logicalExpression_in_whileStatement857 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_whileStatement859 = new BitSet(new long[]{0x0000000000011450L,0x1A4001FF5FC09400L});
    public static final BitSet FOLLOW_statementOrStatementBlock_in_whileStatement861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_97_in_returnStatement883 = new BitSet(new long[]{0x0000000000011450L,0x1A4000000FC04400L});
    public static final BitSet FOLLOW_logicalExpression_in_returnStatement885 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_returnStatement888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_98_in_throwStatement909 = new BitSet(new long[]{0x0000000000011450L,0x1A4000000FC04400L});
    public static final BitSet FOLLOW_logicalExpression_in_throwStatement911 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_throwStatement914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_99_in_deleteStatement935 = new BitSet(new long[]{0x0000000000011450L,0x1A4000000FC04400L});
    public static final BitSet FOLLOW_logicalExpression_in_deleteStatement937 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_deleteStatement940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_100_in_breakStatement964 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_breakStatement966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_101_in_breakAllStatement984 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_breakAllStatement986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_102_in_continueStatement1004 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_continueStatement1006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_103_in_abortStatement1024 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_abortStatement1026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_104_in_transactionStatement1044 = new BitSet(new long[]{0x0000000000011450L,0x1A4001FF5FC09400L});
    public static final BitSet FOLLOW_NAME_in_transactionStatement1047 = new BitSet(new long[]{0x0000000000011450L,0x1A4001FF5FC29400L});
    public static final BitSet FOLLOW_81_in_transactionStatement1050 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NAME_in_transactionStatement1052 = new BitSet(new long[]{0x0000000000011450L,0x1A4001FF5FC29400L});
    public static final BitSet FOLLOW_statementOrStatementBlock_in_transactionStatement1058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logicalExpression_in_assignmentStatement1087 = new BitSet(new long[]{0x0000000000000000L,0x0000060000000000L});
    public static final BitSet FOLLOW_105_in_assignmentStatement1092 = new BitSet(new long[]{0x0000000000011450L,0x1A4000000FC00400L});
    public static final BitSet FOLLOW_106_in_assignmentStatement1099 = new BitSet(new long[]{0x0000000000011450L,0x1A4000000FC00400L});
    public static final BitSet FOLLOW_logicalExpression_in_assignmentStatement1105 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_assignmentStatement1107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionStatement1122 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_expressionStatement1124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_relationalExpression_in_logicalExpression1136 = new BitSet(new long[]{0x0000000000000002L,0x0000780000000000L});
    public static final BitSet FOLLOW_set_in_logicalExpression1139 = new BitSet(new long[]{0x0000000000011450L,0x1A4000000FC00400L});
    public static final BitSet FOLLOW_relationalExpression_in_logicalExpression1150 = new BitSet(new long[]{0x0000000000000002L,0x0000780000000000L});
    public static final BitSet FOLLOW_additiveExpression_in_relationalExpression1167 = new BitSet(new long[]{0x0000000000000002L,0x001F800000000000L});
    public static final BitSet FOLLOW_set_in_relationalExpression1170 = new BitSet(new long[]{0x0000000000011450L,0x1A4000000FC00400L});
    public static final BitSet FOLLOW_additiveExpression_in_relationalExpression1185 = new BitSet(new long[]{0x0000000000000002L,0x001F800000000000L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_additiveExpression1202 = new BitSet(new long[]{0x0000000000000002L,0x0060000000000000L});
    public static final BitSet FOLLOW_set_in_additiveExpression1205 = new BitSet(new long[]{0x0000000000011450L,0x1A4000000FC00400L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_additiveExpression1212 = new BitSet(new long[]{0x0000000000000002L,0x0060000000000000L});
    public static final BitSet FOLLOW_unaryExpression_in_multiplicativeExpression1233 = new BitSet(new long[]{0x0000000000000002L,0x0180000000000000L});
    public static final BitSet FOLLOW_set_in_multiplicativeExpression1236 = new BitSet(new long[]{0x0000000000011450L,0x1A4000000FC00400L});
    public static final BitSet FOLLOW_unaryExpression_in_multiplicativeExpression1243 = new BitSet(new long[]{0x0000000000000002L,0x0180000000000000L});
    public static final BitSet FOLLOW_set_in_unaryExpression1261 = new BitSet(new long[]{0x0000000000011450L,0x1A4000000FC00400L});
    public static final BitSet FOLLOW_postfixExpression_in_unaryExpression1270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primitiveExpression_in_postfixExpression1285 = new BitSet(new long[]{0x0000000000000282L});
    public static final BitSet FOLLOW_set_in_postfixExpression1287 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_featureCall_in_postfixExpression1296 = new BitSet(new long[]{0x0000000000000282L});
    public static final BitSet FOLLOW_simpleFeatureCall_in_featureCall1331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declarativeFeatureCall_in_featureCall1335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_simpleFeatureCall1347 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000400L});
    public static final BitSet FOLLOW_parameterList_in_simpleFeatureCall1350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_parameterList1365 = new BitSet(new long[]{0x0000000000011450L,0x1A4000000FC00C00L});
    public static final BitSet FOLLOW_logicalExpression_in_parameterList1368 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020800L});
    public static final BitSet FOLLOW_81_in_parameterList1371 = new BitSet(new long[]{0x0000000000011450L,0x1A4000000FC00400L});
    public static final BitSet FOLLOW_logicalExpression_in_parameterList1373 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020800L});
    public static final BitSet FOLLOW_75_in_parameterList1379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_declarativeFeatureCall1401 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_74_in_declarativeFeatureCall1404 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_formalParameterList_in_declarativeFeatureCall1407 = new BitSet(new long[]{0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_122_in_declarativeFeatureCall1409 = new BitSet(new long[]{0x0000000000011450L,0x1A4000000FC00400L});
    public static final BitSet FOLLOW_logicalExpression_in_declarativeFeatureCall1412 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_declarativeFeatureCall1414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_123_in_newExpression1426 = new BitSet(new long[]{0x0000000000010000L,0x000000000FC00000L});
    public static final BitSet FOLLOW_typeName_in_newExpression1431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_124_in_variableDeclarationExpression1457 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NAME_in_variableDeclarationExpression1459 = new BitSet(new long[]{0x0000000000000002L,0x0000000000001000L});
    public static final BitSet FOLLOW_76_in_variableDeclarationExpression1462 = new BitSet(new long[]{0x0000000000010000L,0x080000000FC00000L});
    public static final BitSet FOLLOW_123_in_variableDeclarationExpression1466 = new BitSet(new long[]{0x0000000000010000L,0x080000000FC00000L});
    public static final BitSet FOLLOW_typeName_in_variableDeclarationExpression1471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_litteralCollection1498 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_litteralCollection1511 = new BitSet(new long[]{0x0000000000011450L,0x1A4000000FC10400L});
    public static final BitSet FOLLOW_expressionListOrRange_in_litteralCollection1515 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_80_in_litteralCollection1518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionRange1533 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_POINT_POINT_in_expressionRange1535 = new BitSet(new long[]{0x0000000000011450L,0x1A4000000FC00400L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionRange1537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionList1559 = new BitSet(new long[]{0x0000000000000002L,0x0000000000020000L});
    public static final BitSet FOLLOW_81_in_expressionList1562 = new BitSet(new long[]{0x0000000000011450L,0x1A4000000FC00400L});
    public static final BitSet FOLLOW_logicalExpression_in_expressionList1564 = new BitSet(new long[]{0x0000000000000002L,0x0000000000020000L});
    public static final BitSet FOLLOW_expressionRange_in_expressionListOrRange1588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionList_in_expressionListOrRange1592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_litteralCollection_in_primitiveExpression1614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_primitiveExpression1618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_featureCall_in_primitiveExpression1622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pathName_in_primitiveExpression1626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nativeType_in_primitiveExpression1630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectionType_in_primitiveExpression1636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_primitiveExpression1641 = new BitSet(new long[]{0x0000000000011450L,0x1A4000000FC00400L});
    public static final BitSet FOLLOW_logicalExpression_in_primitiveExpression1644 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_primitiveExpression1646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_newExpression_in_primitiveExpression1654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variableDeclarationExpression_in_primitiveExpression1658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_literal0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotation_in_synpred9_EolParserRules441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementA_in_synpred20_EolParserRules642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignmentStatement_in_synpred21_EolParserRules656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionStatement_in_synpred22_EolParserRules660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_elseStatement_in_synpred35_EolParserRules810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_synpred40_EolParserRules1047 = new BitSet(new long[]{0x0000000000000002L,0x0000000000020000L});
    public static final BitSet FOLLOW_81_in_synpred40_EolParserRules1050 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NAME_in_synpred40_EolParserRules1052 = new BitSet(new long[]{0x0000000000000002L,0x0000000000020000L});
    public static final BitSet FOLLOW_expressionRange_in_synpred72_EolParserRules1588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_featureCall_in_synpred75_EolParserRules1622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pathName_in_synpred76_EolParserRules1626 = new BitSet(new long[]{0x0000000000000002L});

}
