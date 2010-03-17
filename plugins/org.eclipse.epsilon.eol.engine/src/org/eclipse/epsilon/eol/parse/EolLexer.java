// $ANTLR 3.1b1 Eol__.g 2010-03-17 00:45:30

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
package org.eclipse.epsilon.eol.parse;	


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class EolLexer extends Lexer {
    public static final int WHILE=30;
    public static final int StatementBlock=26;
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
    public static final int COMMENT=18;
    public static final int ABORT=37;
    public static final int NativeType=50;
    public static final int T__99=99;
    public static final int T__98=98;
    public static final int ITEMSELECTOR=66;
    public static final int T__97=97;
    public static final int T__96=96;
    public static final int MultiplicativeExpression=51;
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
    public static final int PARAMLIST=22;
    public static final int MODELDECLARATION=60;
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
    public static final int T__124=124;
    public static final int T__123=123;
    public static final int T__122=122;
    public static final int FOR=27;
    public static final int T__121=121;
    public static final int ENUMERATION_VALUE=58;
    public static final int FLOAT=4;
    public static final int T__120=120;
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
    public static final int Tokens=127;
    public static final int POINT_POINT=8;
    public static final int MODELDECLARATIONPARAMETERS=64;
    public static final int BLOCK=55;
    public static final int FEATURECALL=56;
    public static final int FORMAL=21;
    public static final int ARROW=9;
    public static final int ASSIGNMENT=23;
    public static final int STRING=12;

    // delegates
    public Eol_EolLexerRules gEolLexerRules;
    // delegators

    public EolLexer() {;} 
    public EolLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public EolLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
        gEolLexerRules = new Eol_EolLexerRules(input, state, this);
    }
    public String getGrammarFileName() { return "Eol__.g"; }

    // $ANTLR start T__67
    public final void mT__67() throws RecognitionException {
        try {
            int _type = T__67;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:44:7: ( 'model' )
            // Eol__.g:44:9: 'model'
            {
            match("model"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__67

    // $ANTLR start T__68
    public final void mT__68() throws RecognitionException {
        try {
            int _type = T__68;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:45:7: ( ';' )
            // Eol__.g:45:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__68

    // $ANTLR start T__69
    public final void mT__69() throws RecognitionException {
        try {
            int _type = T__69;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:46:7: ( ':' )
            // Eol__.g:46:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__69

    // $ANTLR start T__70
    public final void mT__70() throws RecognitionException {
        try {
            int _type = T__70;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:47:7: ( ',' )
            // Eol__.g:47:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__70

    // $ANTLR start T__71
    public final void mT__71() throws RecognitionException {
        try {
            int _type = T__71;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:48:7: ( 'alias' )
            // Eol__.g:48:9: 'alias'
            {
            match("alias"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__71

    // $ANTLR start T__72
    public final void mT__72() throws RecognitionException {
        try {
            int _type = T__72;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:49:7: ( 'driver' )
            // Eol__.g:49:9: 'driver'
            {
            match("driver"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__72

    // $ANTLR start T__73
    public final void mT__73() throws RecognitionException {
        try {
            int _type = T__73;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:50:7: ( '{' )
            // Eol__.g:50:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__73

    // $ANTLR start T__74
    public final void mT__74() throws RecognitionException {
        try {
            int _type = T__74;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:51:7: ( '}' )
            // Eol__.g:51:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__74

    // $ANTLR start T__75
    public final void mT__75() throws RecognitionException {
        try {
            int _type = T__75;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:52:7: ( '=' )
            // Eol__.g:52:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__75

    // $ANTLR start T__76
    public final void mT__76() throws RecognitionException {
        try {
            int _type = T__76;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:53:7: ( 'operation' )
            // Eol__.g:53:9: 'operation'
            {
            match("operation"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__76

    // $ANTLR start T__77
    public final void mT__77() throws RecognitionException {
        try {
            int _type = T__77;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:54:7: ( 'function' )
            // Eol__.g:54:9: 'function'
            {
            match("function"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__77

    // $ANTLR start T__78
    public final void mT__78() throws RecognitionException {
        try {
            int _type = T__78;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:55:7: ( '(' )
            // Eol__.g:55:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__78

    // $ANTLR start T__79
    public final void mT__79() throws RecognitionException {
        try {
            int _type = T__79;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:56:7: ( ')' )
            // Eol__.g:56:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__79

    // $ANTLR start T__80
    public final void mT__80() throws RecognitionException {
        try {
            int _type = T__80;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:57:7: ( 'import' )
            // Eol__.g:57:9: 'import'
            {
            match("import"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__80

    // $ANTLR start T__81
    public final void mT__81() throws RecognitionException {
        try {
            int _type = T__81;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:58:7: ( '$' )
            // Eol__.g:58:9: '$'
            {
            match('$'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__81

    // $ANTLR start T__82
    public final void mT__82() throws RecognitionException {
        try {
            int _type = T__82;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:59:7: ( '!' )
            // Eol__.g:59:9: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__82

    // $ANTLR start T__83
    public final void mT__83() throws RecognitionException {
        try {
            int _type = T__83;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:60:7: ( '::' )
            // Eol__.g:60:9: '::'
            {
            match("::"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__83

    // $ANTLR start T__84
    public final void mT__84() throws RecognitionException {
        try {
            int _type = T__84;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:61:7: ( '#' )
            // Eol__.g:61:9: '#'
            {
            match('#'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__84

    // $ANTLR start T__85
    public final void mT__85() throws RecognitionException {
        try {
            int _type = T__85;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:62:7: ( 'Native' )
            // Eol__.g:62:9: 'Native'
            {
            match("Native"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__85

    // $ANTLR start T__86
    public final void mT__86() throws RecognitionException {
        try {
            int _type = T__86;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:63:7: ( 'Collection' )
            // Eol__.g:63:9: 'Collection'
            {
            match("Collection"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__86

    // $ANTLR start T__87
    public final void mT__87() throws RecognitionException {
        try {
            int _type = T__87;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:64:7: ( 'Sequence' )
            // Eol__.g:64:9: 'Sequence'
            {
            match("Sequence"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__87

    // $ANTLR start T__88
    public final void mT__88() throws RecognitionException {
        try {
            int _type = T__88;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:65:7: ( 'List' )
            // Eol__.g:65:9: 'List'
            {
            match("List"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__88

    // $ANTLR start T__89
    public final void mT__89() throws RecognitionException {
        try {
            int _type = T__89;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:66:7: ( 'Bag' )
            // Eol__.g:66:9: 'Bag'
            {
            match("Bag"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__89

    // $ANTLR start T__90
    public final void mT__90() throws RecognitionException {
        try {
            int _type = T__90;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:67:7: ( 'Set' )
            // Eol__.g:67:9: 'Set'
            {
            match("Set"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__90

    // $ANTLR start T__91
    public final void mT__91() throws RecognitionException {
        try {
            int _type = T__91;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:68:7: ( 'OrderedSet' )
            // Eol__.g:68:9: 'OrderedSet'
            {
            match("OrderedSet"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__91

    // $ANTLR start T__92
    public final void mT__92() throws RecognitionException {
        try {
            int _type = T__92;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:69:7: ( 'for' )
            // Eol__.g:69:9: 'for'
            {
            match("for"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__92

    // $ANTLR start T__93
    public final void mT__93() throws RecognitionException {
        try {
            int _type = T__93;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:70:7: ( 'in' )
            // Eol__.g:70:9: 'in'
            {
            match("in"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__93

    // $ANTLR start T__94
    public final void mT__94() throws RecognitionException {
        try {
            int _type = T__94;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:71:7: ( 'if' )
            // Eol__.g:71:9: 'if'
            {
            match("if"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__94

    // $ANTLR start T__95
    public final void mT__95() throws RecognitionException {
        try {
            int _type = T__95;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:72:7: ( 'else' )
            // Eol__.g:72:9: 'else'
            {
            match("else"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__95

    // $ANTLR start T__96
    public final void mT__96() throws RecognitionException {
        try {
            int _type = T__96;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:73:7: ( 'while' )
            // Eol__.g:73:9: 'while'
            {
            match("while"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__96

    // $ANTLR start T__97
    public final void mT__97() throws RecognitionException {
        try {
            int _type = T__97;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:74:7: ( 'return' )
            // Eol__.g:74:9: 'return'
            {
            match("return"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__97

    // $ANTLR start T__98
    public final void mT__98() throws RecognitionException {
        try {
            int _type = T__98;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:75:7: ( 'throw' )
            // Eol__.g:75:9: 'throw'
            {
            match("throw"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__98

    // $ANTLR start T__99
    public final void mT__99() throws RecognitionException {
        try {
            int _type = T__99;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:76:7: ( 'delete' )
            // Eol__.g:76:9: 'delete'
            {
            match("delete"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__99

    // $ANTLR start T__100
    public final void mT__100() throws RecognitionException {
        try {
            int _type = T__100;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:77:8: ( 'break' )
            // Eol__.g:77:10: 'break'
            {
            match("break"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__100

    // $ANTLR start T__101
    public final void mT__101() throws RecognitionException {
        try {
            int _type = T__101;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:78:8: ( 'breakAll' )
            // Eol__.g:78:10: 'breakAll'
            {
            match("breakAll"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__101

    // $ANTLR start T__102
    public final void mT__102() throws RecognitionException {
        try {
            int _type = T__102;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:79:8: ( 'continue' )
            // Eol__.g:79:10: 'continue'
            {
            match("continue"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__102

    // $ANTLR start T__103
    public final void mT__103() throws RecognitionException {
        try {
            int _type = T__103;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:80:8: ( 'abort' )
            // Eol__.g:80:10: 'abort'
            {
            match("abort"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__103

    // $ANTLR start T__104
    public final void mT__104() throws RecognitionException {
        try {
            int _type = T__104;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:81:8: ( 'transaction' )
            // Eol__.g:81:10: 'transaction'
            {
            match("transaction"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__104

    // $ANTLR start T__105
    public final void mT__105() throws RecognitionException {
        try {
            int _type = T__105;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:82:8: ( ':=' )
            // Eol__.g:82:10: ':='
            {
            match(":="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__105

    // $ANTLR start T__106
    public final void mT__106() throws RecognitionException {
        try {
            int _type = T__106;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:83:8: ( '::=' )
            // Eol__.g:83:10: '::='
            {
            match("::="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__106

    // $ANTLR start T__107
    public final void mT__107() throws RecognitionException {
        try {
            int _type = T__107;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:84:8: ( 'or' )
            // Eol__.g:84:10: 'or'
            {
            match("or"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__107

    // $ANTLR start T__108
    public final void mT__108() throws RecognitionException {
        try {
            int _type = T__108;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:85:8: ( 'and' )
            // Eol__.g:85:10: 'and'
            {
            match("and"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__108

    // $ANTLR start T__109
    public final void mT__109() throws RecognitionException {
        try {
            int _type = T__109;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:86:8: ( 'xor' )
            // Eol__.g:86:10: 'xor'
            {
            match("xor"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__109

    // $ANTLR start T__110
    public final void mT__110() throws RecognitionException {
        try {
            int _type = T__110;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:87:8: ( 'implies' )
            // Eol__.g:87:10: 'implies'
            {
            match("implies"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__110

    // $ANTLR start T__111
    public final void mT__111() throws RecognitionException {
        try {
            int _type = T__111;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:88:8: ( '==' )
            // Eol__.g:88:10: '=='
            {
            match("=="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__111

    // $ANTLR start T__112
    public final void mT__112() throws RecognitionException {
        try {
            int _type = T__112;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:89:8: ( '>' )
            // Eol__.g:89:10: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__112

    // $ANTLR start T__113
    public final void mT__113() throws RecognitionException {
        try {
            int _type = T__113;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:90:8: ( '<' )
            // Eol__.g:90:10: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__113

    // $ANTLR start T__114
    public final void mT__114() throws RecognitionException {
        try {
            int _type = T__114;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:91:8: ( '>=' )
            // Eol__.g:91:10: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__114

    // $ANTLR start T__115
    public final void mT__115() throws RecognitionException {
        try {
            int _type = T__115;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:92:8: ( '<=' )
            // Eol__.g:92:10: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__115

    // $ANTLR start T__116
    public final void mT__116() throws RecognitionException {
        try {
            int _type = T__116;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:93:8: ( '<>' )
            // Eol__.g:93:10: '<>'
            {
            match("<>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__116

    // $ANTLR start T__117
    public final void mT__117() throws RecognitionException {
        try {
            int _type = T__117;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:94:8: ( '+' )
            // Eol__.g:94:10: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__117

    // $ANTLR start T__118
    public final void mT__118() throws RecognitionException {
        try {
            int _type = T__118;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:95:8: ( '-' )
            // Eol__.g:95:10: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__118

    // $ANTLR start T__119
    public final void mT__119() throws RecognitionException {
        try {
            int _type = T__119;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:96:8: ( '*' )
            // Eol__.g:96:10: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__119

    // $ANTLR start T__120
    public final void mT__120() throws RecognitionException {
        try {
            int _type = T__120;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:97:8: ( '/' )
            // Eol__.g:97:10: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__120

    // $ANTLR start T__121
    public final void mT__121() throws RecognitionException {
        try {
            int _type = T__121;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:98:8: ( 'not' )
            // Eol__.g:98:10: 'not'
            {
            match("not"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__121

    // $ANTLR start T__122
    public final void mT__122() throws RecognitionException {
        try {
            int _type = T__122;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:99:8: ( '[' )
            // Eol__.g:99:10: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__122

    // $ANTLR start T__123
    public final void mT__123() throws RecognitionException {
        try {
            int _type = T__123;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:100:8: ( ']' )
            // Eol__.g:100:10: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__123

    // $ANTLR start T__124
    public final void mT__124() throws RecognitionException {
        try {
            int _type = T__124;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:101:8: ( '|' )
            // Eol__.g:101:10: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__124

    // $ANTLR start T__125
    public final void mT__125() throws RecognitionException {
        try {
            int _type = T__125;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:102:8: ( 'new' )
            // Eol__.g:102:10: 'new'
            {
            match("new"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__125

    // $ANTLR start T__126
    public final void mT__126() throws RecognitionException {
        try {
            int _type = T__126;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:103:8: ( 'var' )
            // Eol__.g:103:10: 'var'
            {
            match("var"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__126

    public void mTokens() throws RecognitionException {
        // Eol__.g:1:8: ( T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | T__104 | T__105 | T__106 | T__107 | T__108 | T__109 | T__110 | T__111 | T__112 | T__113 | T__114 | T__115 | T__116 | T__117 | T__118 | T__119 | T__120 | T__121 | T__122 | T__123 | T__124 | T__125 | T__126 | EolLexerRules. Tokens )
        int alt1=61;
        alt1 = dfa1.predict(input);
        switch (alt1) {
            case 1 :
                // Eol__.g:1:10: T__67
                {
                mT__67(); 

                }
                break;
            case 2 :
                // Eol__.g:1:16: T__68
                {
                mT__68(); 

                }
                break;
            case 3 :
                // Eol__.g:1:22: T__69
                {
                mT__69(); 

                }
                break;
            case 4 :
                // Eol__.g:1:28: T__70
                {
                mT__70(); 

                }
                break;
            case 5 :
                // Eol__.g:1:34: T__71
                {
                mT__71(); 

                }
                break;
            case 6 :
                // Eol__.g:1:40: T__72
                {
                mT__72(); 

                }
                break;
            case 7 :
                // Eol__.g:1:46: T__73
                {
                mT__73(); 

                }
                break;
            case 8 :
                // Eol__.g:1:52: T__74
                {
                mT__74(); 

                }
                break;
            case 9 :
                // Eol__.g:1:58: T__75
                {
                mT__75(); 

                }
                break;
            case 10 :
                // Eol__.g:1:64: T__76
                {
                mT__76(); 

                }
                break;
            case 11 :
                // Eol__.g:1:70: T__77
                {
                mT__77(); 

                }
                break;
            case 12 :
                // Eol__.g:1:76: T__78
                {
                mT__78(); 

                }
                break;
            case 13 :
                // Eol__.g:1:82: T__79
                {
                mT__79(); 

                }
                break;
            case 14 :
                // Eol__.g:1:88: T__80
                {
                mT__80(); 

                }
                break;
            case 15 :
                // Eol__.g:1:94: T__81
                {
                mT__81(); 

                }
                break;
            case 16 :
                // Eol__.g:1:100: T__82
                {
                mT__82(); 

                }
                break;
            case 17 :
                // Eol__.g:1:106: T__83
                {
                mT__83(); 

                }
                break;
            case 18 :
                // Eol__.g:1:112: T__84
                {
                mT__84(); 

                }
                break;
            case 19 :
                // Eol__.g:1:118: T__85
                {
                mT__85(); 

                }
                break;
            case 20 :
                // Eol__.g:1:124: T__86
                {
                mT__86(); 

                }
                break;
            case 21 :
                // Eol__.g:1:130: T__87
                {
                mT__87(); 

                }
                break;
            case 22 :
                // Eol__.g:1:136: T__88
                {
                mT__88(); 

                }
                break;
            case 23 :
                // Eol__.g:1:142: T__89
                {
                mT__89(); 

                }
                break;
            case 24 :
                // Eol__.g:1:148: T__90
                {
                mT__90(); 

                }
                break;
            case 25 :
                // Eol__.g:1:154: T__91
                {
                mT__91(); 

                }
                break;
            case 26 :
                // Eol__.g:1:160: T__92
                {
                mT__92(); 

                }
                break;
            case 27 :
                // Eol__.g:1:166: T__93
                {
                mT__93(); 

                }
                break;
            case 28 :
                // Eol__.g:1:172: T__94
                {
                mT__94(); 

                }
                break;
            case 29 :
                // Eol__.g:1:178: T__95
                {
                mT__95(); 

                }
                break;
            case 30 :
                // Eol__.g:1:184: T__96
                {
                mT__96(); 

                }
                break;
            case 31 :
                // Eol__.g:1:190: T__97
                {
                mT__97(); 

                }
                break;
            case 32 :
                // Eol__.g:1:196: T__98
                {
                mT__98(); 

                }
                break;
            case 33 :
                // Eol__.g:1:202: T__99
                {
                mT__99(); 

                }
                break;
            case 34 :
                // Eol__.g:1:208: T__100
                {
                mT__100(); 

                }
                break;
            case 35 :
                // Eol__.g:1:215: T__101
                {
                mT__101(); 

                }
                break;
            case 36 :
                // Eol__.g:1:222: T__102
                {
                mT__102(); 

                }
                break;
            case 37 :
                // Eol__.g:1:229: T__103
                {
                mT__103(); 

                }
                break;
            case 38 :
                // Eol__.g:1:236: T__104
                {
                mT__104(); 

                }
                break;
            case 39 :
                // Eol__.g:1:243: T__105
                {
                mT__105(); 

                }
                break;
            case 40 :
                // Eol__.g:1:250: T__106
                {
                mT__106(); 

                }
                break;
            case 41 :
                // Eol__.g:1:257: T__107
                {
                mT__107(); 

                }
                break;
            case 42 :
                // Eol__.g:1:264: T__108
                {
                mT__108(); 

                }
                break;
            case 43 :
                // Eol__.g:1:271: T__109
                {
                mT__109(); 

                }
                break;
            case 44 :
                // Eol__.g:1:278: T__110
                {
                mT__110(); 

                }
                break;
            case 45 :
                // Eol__.g:1:285: T__111
                {
                mT__111(); 

                }
                break;
            case 46 :
                // Eol__.g:1:292: T__112
                {
                mT__112(); 

                }
                break;
            case 47 :
                // Eol__.g:1:299: T__113
                {
                mT__113(); 

                }
                break;
            case 48 :
                // Eol__.g:1:306: T__114
                {
                mT__114(); 

                }
                break;
            case 49 :
                // Eol__.g:1:313: T__115
                {
                mT__115(); 

                }
                break;
            case 50 :
                // Eol__.g:1:320: T__116
                {
                mT__116(); 

                }
                break;
            case 51 :
                // Eol__.g:1:327: T__117
                {
                mT__117(); 

                }
                break;
            case 52 :
                // Eol__.g:1:334: T__118
                {
                mT__118(); 

                }
                break;
            case 53 :
                // Eol__.g:1:341: T__119
                {
                mT__119(); 

                }
                break;
            case 54 :
                // Eol__.g:1:348: T__120
                {
                mT__120(); 

                }
                break;
            case 55 :
                // Eol__.g:1:355: T__121
                {
                mT__121(); 

                }
                break;
            case 56 :
                // Eol__.g:1:362: T__122
                {
                mT__122(); 

                }
                break;
            case 57 :
                // Eol__.g:1:369: T__123
                {
                mT__123(); 

                }
                break;
            case 58 :
                // Eol__.g:1:376: T__124
                {
                mT__124(); 

                }
                break;
            case 59 :
                // Eol__.g:1:383: T__125
                {
                mT__125(); 

                }
                break;
            case 60 :
                // Eol__.g:1:390: T__126
                {
                mT__126(); 

                }
                break;
            case 61 :
                // Eol__.g:1:397: EolLexerRules. Tokens
                {
                gEolLexerRules.mTokens(); 

                }
                break;

        }

    }


    protected DFA1 dfa1 = new DFA1(this);
    static final String DFA1_eotS =
        "\1\uffff\1\52\1\uffff\1\56\1\uffff\2\52\2\uffff\1\65\2\52\2\uffff"+
        "\1\52\3\uffff\15\52\1\114\1\117\1\uffff\1\120\1\uffff\1\121\1\52"+
        "\3\uffff\1\52\1\uffff\1\52\1\127\2\uffff\5\52\2\uffff\1\52\1\136"+
        "\3\52\1\142\1\143\16\52\7\uffff\4\52\2\uffff\2\52\1\171\3\52\1\uffff"+
        "\1\52\1\176\1\52\2\uffff\3\52\1\u0084\1\52\1\u0086\10\52\1\u008f"+
        "\1\u0090\1\u0091\1\u0092\3\52\1\uffff\4\52\1\uffff\5\52\1\uffff"+
        "\1\u009f\1\uffff\1\52\1\u00a1\6\52\4\uffff\1\u00a8\1\u00a9\1\u00aa"+
        "\11\52\1\uffff\1\52\1\uffff\1\u00b5\1\52\1\u00b7\1\52\1\u00ba\1"+
        "\52\3\uffff\1\u00bc\1\u00bd\2\52\1\u00c0\1\52\1\u00c2\3\52\1\uffff"+
        "\1\u00c6\1\uffff\2\52\1\uffff\1\52\2\uffff\2\52\1\uffff\1\u00cc"+
        "\1\uffff\3\52\1\uffff\4\52\1\u00d4\1\uffff\1\52\1\u00d6\2\52\1\u00d9"+
        "\1\u00da\1\u00db\1\uffff\1\52\1\uffff\2\52\3\uffff\1\u00df\1\u00e0"+
        "\1\52\2\uffff\1\u00e2\1\uffff";
    static final String DFA1_eofS =
        "\u00e3\uffff";
    static final String DFA1_minS =
        "\1\11\1\157\1\uffff\1\72\1\uffff\1\142\1\145\2\uffff\1\75\1\160"+
        "\1\157\2\uffff\1\146\3\uffff\1\141\1\157\1\145\1\151\1\141\1\162"+
        "\1\154\1\150\1\145\1\150\1\162\2\157\2\75\1\uffff\1\52\1\uffff\1"+
        "\52\1\145\3\uffff\1\141\1\uffff\1\144\1\75\2\uffff\1\151\1\157\1"+
        "\144\1\151\1\154\2\uffff\1\145\1\60\1\156\1\162\1\160\2\60\1\164"+
        "\1\154\1\161\1\163\1\147\1\144\1\163\1\151\1\164\1\162\1\141\1\145"+
        "\1\156\1\162\7\uffff\1\164\1\167\1\162\1\145\2\uffff\1\141\1\162"+
        "\1\60\1\166\1\145\1\162\1\uffff\1\143\1\60\1\154\2\uffff\1\151\1"+
        "\154\1\165\1\60\1\164\1\60\2\145\1\154\1\165\1\157\1\156\1\141\1"+
        "\164\4\60\1\154\1\163\1\164\1\uffff\1\145\1\164\1\141\1\164\1\uffff"+
        "\1\162\1\151\1\166\2\145\1\uffff\1\60\1\uffff\1\162\1\60\1\145\1"+
        "\162\1\167\1\163\1\153\1\151\4\uffff\3\60\1\162\1\145\1\164\1\151"+
        "\1\164\2\145\1\143\1\156\1\uffff\1\145\1\uffff\1\60\1\156\1\60\1"+
        "\141\1\60\1\156\3\uffff\2\60\1\151\1\157\1\60\1\163\1\60\1\164\1"+
        "\143\1\144\1\uffff\1\60\1\uffff\1\143\1\154\1\uffff\1\165\2\uffff"+
        "\1\157\1\156\1\uffff\1\60\1\uffff\1\151\1\145\1\123\1\uffff\1\164"+
        "\1\154\1\145\1\156\1\60\1\uffff\1\157\1\60\1\145\1\151\3\60\1\uffff"+
        "\1\156\1\uffff\1\164\1\157\3\uffff\2\60\1\156\2\uffff\1\60\1\uffff";
    static final String DFA1_maxS =
        "\1\ufaff\1\157\1\uffff\1\75\1\uffff\1\156\1\162\2\uffff\1\75\1\162"+
        "\1\165\2\uffff\1\156\3\uffff\1\141\1\157\1\145\1\151\1\141\1\162"+
        "\1\154\1\150\1\145\2\162\2\157\1\75\1\76\1\uffff\1\76\1\uffff\1"+
        "\57\1\157\3\uffff\1\141\1\uffff\1\144\1\75\2\uffff\1\151\1\157\1"+
        "\144\1\151\1\154\2\uffff\1\145\1\ufaff\1\156\1\162\1\160\2\ufaff"+
        "\1\164\1\154\1\164\1\163\1\147\1\144\1\163\1\151\1\164\1\162\1\141"+
        "\1\145\1\156\1\162\7\uffff\1\164\1\167\1\162\1\145\2\uffff\1\141"+
        "\1\162\1\ufaff\1\166\1\145\1\162\1\uffff\1\143\1\ufaff\1\157\2\uffff"+
        "\1\151\1\154\1\165\1\ufaff\1\164\1\ufaff\2\145\1\154\1\165\1\157"+
        "\1\156\1\141\1\164\4\ufaff\1\154\1\163\1\164\1\uffff\1\145\1\164"+
        "\1\141\1\164\1\uffff\1\162\1\151\1\166\2\145\1\uffff\1\ufaff\1\uffff"+
        "\1\162\1\ufaff\1\145\1\162\1\167\1\163\1\153\1\151\4\uffff\3\ufaff"+
        "\1\162\1\145\1\164\1\151\1\164\2\145\1\143\1\156\1\uffff\1\145\1"+
        "\uffff\1\ufaff\1\156\1\ufaff\1\141\1\ufaff\1\156\3\uffff\2\ufaff"+
        "\1\151\1\157\1\ufaff\1\163\1\ufaff\1\164\1\143\1\144\1\uffff\1\ufaff"+
        "\1\uffff\1\143\1\154\1\uffff\1\165\2\uffff\1\157\1\156\1\uffff\1"+
        "\ufaff\1\uffff\1\151\1\145\1\123\1\uffff\1\164\1\154\1\145\1\156"+
        "\1\ufaff\1\uffff\1\157\1\ufaff\1\145\1\151\3\ufaff\1\uffff\1\156"+
        "\1\uffff\1\164\1\157\3\uffff\2\ufaff\1\156\2\uffff\1\ufaff\1\uffff";
    static final String DFA1_acceptS =
        "\2\uffff\1\2\1\uffff\1\4\2\uffff\1\7\1\10\3\uffff\1\14\1\15\1\uffff"+
        "\1\17\1\20\1\22\17\uffff\1\63\1\uffff\1\65\2\uffff\1\70\1\71\1\72"+
        "\1\uffff\1\75\2\uffff\1\47\1\3\5\uffff\1\55\1\11\25\uffff\1\60\1"+
        "\56\1\61\1\62\1\57\1\64\1\66\4\uffff\1\50\1\21\6\uffff\1\51\3\uffff"+
        "\1\33\1\34\25\uffff\1\52\4\uffff\1\32\5\uffff\1\30\1\uffff\1\27"+
        "\10\uffff\1\53\1\67\1\73\1\74\14\uffff\1\26\1\uffff\1\35\6\uffff"+
        "\1\1\1\5\1\45\12\uffff\1\36\1\uffff\1\40\2\uffff\1\42\1\uffff\1"+
        "\6\1\41\2\uffff\1\16\1\uffff\1\23\3\uffff\1\37\5\uffff\1\54\7\uffff"+
        "\1\13\1\uffff\1\25\2\uffff\1\43\1\44\1\12\3\uffff\1\24\1\31\1\uffff"+
        "\1\46";
    static final String DFA1_specialS =
        "\u00e3\uffff}>";
    static final String[] DFA1_transitionS = {
            "\2\52\1\uffff\2\52\22\uffff\1\52\1\20\1\52\1\21\1\17\2\uffff"+
            "\1\52\1\14\1\15\1\43\1\41\1\4\1\42\1\52\1\44\12\52\1\3\1\2\1"+
            "\40\1\11\1\37\1\uffff\2\52\1\26\1\23\10\52\1\25\1\52\1\22\1"+
            "\27\3\52\1\24\7\52\1\46\1\uffff\1\47\1\uffff\2\52\1\5\1\34\1"+
            "\35\1\6\1\30\1\13\2\52\1\16\3\52\1\1\1\45\1\12\2\52\1\32\1\52"+
            "\1\33\1\52\1\51\1\31\1\36\2\52\1\7\1\50\1\10\1\52\101\uffff"+
            "\27\52\1\uffff\37\52\1\uffff\u1f08\52\u1040\uffff\u0150\52\u0170"+
            "\uffff\u0080\52\u0080\uffff\u092e\52\u10d2\uffff\u5200\52\u5900"+
            "\uffff\u0200\52",
            "\1\53",
            "",
            "\1\54\2\uffff\1\55",
            "",
            "\1\60\11\uffff\1\57\1\uffff\1\61",
            "\1\63\14\uffff\1\62",
            "",
            "",
            "\1\64",
            "\1\66\1\uffff\1\67",
            "\1\71\5\uffff\1\70",
            "",
            "",
            "\1\74\6\uffff\1\72\1\73",
            "",
            "",
            "",
            "\1\75",
            "\1\76",
            "\1\77",
            "\1\100",
            "\1\101",
            "\1\102",
            "\1\103",
            "\1\104",
            "\1\105",
            "\1\106\11\uffff\1\107",
            "\1\110",
            "\1\111",
            "\1\112",
            "\1\113",
            "\1\115\1\116",
            "",
            "\1\52\2\uffff\1\52\20\uffff\1\52",
            "",
            "\1\52\4\uffff\1\52",
            "\1\123\11\uffff\1\122",
            "",
            "",
            "",
            "\1\124",
            "",
            "\1\125",
            "\1\126",
            "",
            "",
            "\1\130",
            "\1\131",
            "\1\132",
            "\1\133",
            "\1\134",
            "",
            "",
            "\1\135",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52\105\uffff\27"+
            "\52\1\uffff\37\52\1\uffff\u1f08\52\u1040\uffff\u0150\52\u0170"+
            "\uffff\u0080\52\u0080\uffff\u092e\52\u10d2\uffff\u5200\52\u5900"+
            "\uffff\u0200\52",
            "\1\137",
            "\1\140",
            "\1\141",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52\105\uffff\27"+
            "\52\1\uffff\37\52\1\uffff\u1f08\52\u1040\uffff\u0150\52\u0170"+
            "\uffff\u0080\52\u0080\uffff\u092e\52\u10d2\uffff\u5200\52\u5900"+
            "\uffff\u0200\52",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52\105\uffff\27"+
            "\52\1\uffff\37\52\1\uffff\u1f08\52\u1040\uffff\u0150\52\u0170"+
            "\uffff\u0080\52\u0080\uffff\u092e\52\u10d2\uffff\u5200\52\u5900"+
            "\uffff\u0200\52",
            "\1\144",
            "\1\145",
            "\1\146\2\uffff\1\147",
            "\1\150",
            "\1\151",
            "\1\152",
            "\1\153",
            "\1\154",
            "\1\155",
            "\1\156",
            "\1\157",
            "\1\160",
            "\1\161",
            "\1\162",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\163",
            "\1\164",
            "\1\165",
            "\1\166",
            "",
            "",
            "\1\167",
            "\1\170",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52\105\uffff\27"+
            "\52\1\uffff\37\52\1\uffff\u1f08\52\u1040\uffff\u0150\52\u0170"+
            "\uffff\u0080\52\u0080\uffff\u092e\52\u10d2\uffff\u5200\52\u5900"+
            "\uffff\u0200\52",
            "\1\172",
            "\1\173",
            "\1\174",
            "",
            "\1\175",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52\105\uffff\27"+
            "\52\1\uffff\37\52\1\uffff\u1f08\52\u1040\uffff\u0150\52\u0170"+
            "\uffff\u0080\52\u0080\uffff\u092e\52\u10d2\uffff\u5200\52\u5900"+
            "\uffff\u0200\52",
            "\1\u0080\2\uffff\1\177",
            "",
            "",
            "\1\u0081",
            "\1\u0082",
            "\1\u0083",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52\105\uffff\27"+
            "\52\1\uffff\37\52\1\uffff\u1f08\52\u1040\uffff\u0150\52\u0170"+
            "\uffff\u0080\52\u0080\uffff\u092e\52\u10d2\uffff\u5200\52\u5900"+
            "\uffff\u0200\52",
            "\1\u0085",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52\105\uffff\27"+
            "\52\1\uffff\37\52\1\uffff\u1f08\52\u1040\uffff\u0150\52\u0170"+
            "\uffff\u0080\52\u0080\uffff\u092e\52\u10d2\uffff\u5200\52\u5900"+
            "\uffff\u0200\52",
            "\1\u0087",
            "\1\u0088",
            "\1\u0089",
            "\1\u008a",
            "\1\u008b",
            "\1\u008c",
            "\1\u008d",
            "\1\u008e",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52\105\uffff\27"+
            "\52\1\uffff\37\52\1\uffff\u1f08\52\u1040\uffff\u0150\52\u0170"+
            "\uffff\u0080\52\u0080\uffff\u092e\52\u10d2\uffff\u5200\52\u5900"+
            "\uffff\u0200\52",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52\105\uffff\27"+
            "\52\1\uffff\37\52\1\uffff\u1f08\52\u1040\uffff\u0150\52\u0170"+
            "\uffff\u0080\52\u0080\uffff\u092e\52\u10d2\uffff\u5200\52\u5900"+
            "\uffff\u0200\52",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52\105\uffff\27"+
            "\52\1\uffff\37\52\1\uffff\u1f08\52\u1040\uffff\u0150\52\u0170"+
            "\uffff\u0080\52\u0080\uffff\u092e\52\u10d2\uffff\u5200\52\u5900"+
            "\uffff\u0200\52",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52\105\uffff\27"+
            "\52\1\uffff\37\52\1\uffff\u1f08\52\u1040\uffff\u0150\52\u0170"+
            "\uffff\u0080\52\u0080\uffff\u092e\52\u10d2\uffff\u5200\52\u5900"+
            "\uffff\u0200\52",
            "\1\u0093",
            "\1\u0094",
            "\1\u0095",
            "",
            "\1\u0096",
            "\1\u0097",
            "\1\u0098",
            "\1\u0099",
            "",
            "\1\u009a",
            "\1\u009b",
            "\1\u009c",
            "\1\u009d",
            "\1\u009e",
            "",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52\105\uffff\27"+
            "\52\1\uffff\37\52\1\uffff\u1f08\52\u1040\uffff\u0150\52\u0170"+
            "\uffff\u0080\52\u0080\uffff\u092e\52\u10d2\uffff\u5200\52\u5900"+
            "\uffff\u0200\52",
            "",
            "\1\u00a0",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52\105\uffff\27"+
            "\52\1\uffff\37\52\1\uffff\u1f08\52\u1040\uffff\u0150\52\u0170"+
            "\uffff\u0080\52\u0080\uffff\u092e\52\u10d2\uffff\u5200\52\u5900"+
            "\uffff\u0200\52",
            "\1\u00a2",
            "\1\u00a3",
            "\1\u00a4",
            "\1\u00a5",
            "\1\u00a6",
            "\1\u00a7",
            "",
            "",
            "",
            "",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52\105\uffff\27"+
            "\52\1\uffff\37\52\1\uffff\u1f08\52\u1040\uffff\u0150\52\u0170"+
            "\uffff\u0080\52\u0080\uffff\u092e\52\u10d2\uffff\u5200\52\u5900"+
            "\uffff\u0200\52",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52\105\uffff\27"+
            "\52\1\uffff\37\52\1\uffff\u1f08\52\u1040\uffff\u0150\52\u0170"+
            "\uffff\u0080\52\u0080\uffff\u092e\52\u10d2\uffff\u5200\52\u5900"+
            "\uffff\u0200\52",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52\105\uffff\27"+
            "\52\1\uffff\37\52\1\uffff\u1f08\52\u1040\uffff\u0150\52\u0170"+
            "\uffff\u0080\52\u0080\uffff\u092e\52\u10d2\uffff\u5200\52\u5900"+
            "\uffff\u0200\52",
            "\1\u00ab",
            "\1\u00ac",
            "\1\u00ad",
            "\1\u00ae",
            "\1\u00af",
            "\1\u00b0",
            "\1\u00b1",
            "\1\u00b2",
            "\1\u00b3",
            "",
            "\1\u00b4",
            "",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52\105\uffff\27"+
            "\52\1\uffff\37\52\1\uffff\u1f08\52\u1040\uffff\u0150\52\u0170"+
            "\uffff\u0080\52\u0080\uffff\u092e\52\u10d2\uffff\u5200\52\u5900"+
            "\uffff\u0200\52",
            "\1\u00b6",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52\105\uffff\27"+
            "\52\1\uffff\37\52\1\uffff\u1f08\52\u1040\uffff\u0150\52\u0170"+
            "\uffff\u0080\52\u0080\uffff\u092e\52\u10d2\uffff\u5200\52\u5900"+
            "\uffff\u0200\52",
            "\1\u00b8",
            "\12\52\7\uffff\1\u00b9\31\52\4\uffff\1\52\1\uffff\32\52\105"+
            "\uffff\27\52\1\uffff\37\52\1\uffff\u1f08\52\u1040\uffff\u0150"+
            "\52\u0170\uffff\u0080\52\u0080\uffff\u092e\52\u10d2\uffff\u5200"+
            "\52\u5900\uffff\u0200\52",
            "\1\u00bb",
            "",
            "",
            "",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52\105\uffff\27"+
            "\52\1\uffff\37\52\1\uffff\u1f08\52\u1040\uffff\u0150\52\u0170"+
            "\uffff\u0080\52\u0080\uffff\u092e\52\u10d2\uffff\u5200\52\u5900"+
            "\uffff\u0200\52",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52\105\uffff\27"+
            "\52\1\uffff\37\52\1\uffff\u1f08\52\u1040\uffff\u0150\52\u0170"+
            "\uffff\u0080\52\u0080\uffff\u092e\52\u10d2\uffff\u5200\52\u5900"+
            "\uffff\u0200\52",
            "\1\u00be",
            "\1\u00bf",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52\105\uffff\27"+
            "\52\1\uffff\37\52\1\uffff\u1f08\52\u1040\uffff\u0150\52\u0170"+
            "\uffff\u0080\52\u0080\uffff\u092e\52\u10d2\uffff\u5200\52\u5900"+
            "\uffff\u0200\52",
            "\1\u00c1",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52\105\uffff\27"+
            "\52\1\uffff\37\52\1\uffff\u1f08\52\u1040\uffff\u0150\52\u0170"+
            "\uffff\u0080\52\u0080\uffff\u092e\52\u10d2\uffff\u5200\52\u5900"+
            "\uffff\u0200\52",
            "\1\u00c3",
            "\1\u00c4",
            "\1\u00c5",
            "",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52\105\uffff\27"+
            "\52\1\uffff\37\52\1\uffff\u1f08\52\u1040\uffff\u0150\52\u0170"+
            "\uffff\u0080\52\u0080\uffff\u092e\52\u10d2\uffff\u5200\52\u5900"+
            "\uffff\u0200\52",
            "",
            "\1\u00c7",
            "\1\u00c8",
            "",
            "\1\u00c9",
            "",
            "",
            "\1\u00ca",
            "\1\u00cb",
            "",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52\105\uffff\27"+
            "\52\1\uffff\37\52\1\uffff\u1f08\52\u1040\uffff\u0150\52\u0170"+
            "\uffff\u0080\52\u0080\uffff\u092e\52\u10d2\uffff\u5200\52\u5900"+
            "\uffff\u0200\52",
            "",
            "\1\u00cd",
            "\1\u00ce",
            "\1\u00cf",
            "",
            "\1\u00d0",
            "\1\u00d1",
            "\1\u00d2",
            "\1\u00d3",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52\105\uffff\27"+
            "\52\1\uffff\37\52\1\uffff\u1f08\52\u1040\uffff\u0150\52\u0170"+
            "\uffff\u0080\52\u0080\uffff\u092e\52\u10d2\uffff\u5200\52\u5900"+
            "\uffff\u0200\52",
            "",
            "\1\u00d5",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52\105\uffff\27"+
            "\52\1\uffff\37\52\1\uffff\u1f08\52\u1040\uffff\u0150\52\u0170"+
            "\uffff\u0080\52\u0080\uffff\u092e\52\u10d2\uffff\u5200\52\u5900"+
            "\uffff\u0200\52",
            "\1\u00d7",
            "\1\u00d8",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52\105\uffff\27"+
            "\52\1\uffff\37\52\1\uffff\u1f08\52\u1040\uffff\u0150\52\u0170"+
            "\uffff\u0080\52\u0080\uffff\u092e\52\u10d2\uffff\u5200\52\u5900"+
            "\uffff\u0200\52",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52\105\uffff\27"+
            "\52\1\uffff\37\52\1\uffff\u1f08\52\u1040\uffff\u0150\52\u0170"+
            "\uffff\u0080\52\u0080\uffff\u092e\52\u10d2\uffff\u5200\52\u5900"+
            "\uffff\u0200\52",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52\105\uffff\27"+
            "\52\1\uffff\37\52\1\uffff\u1f08\52\u1040\uffff\u0150\52\u0170"+
            "\uffff\u0080\52\u0080\uffff\u092e\52\u10d2\uffff\u5200\52\u5900"+
            "\uffff\u0200\52",
            "",
            "\1\u00dc",
            "",
            "\1\u00dd",
            "\1\u00de",
            "",
            "",
            "",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52\105\uffff\27"+
            "\52\1\uffff\37\52\1\uffff\u1f08\52\u1040\uffff\u0150\52\u0170"+
            "\uffff\u0080\52\u0080\uffff\u092e\52\u10d2\uffff\u5200\52\u5900"+
            "\uffff\u0200\52",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52\105\uffff\27"+
            "\52\1\uffff\37\52\1\uffff\u1f08\52\u1040\uffff\u0150\52\u0170"+
            "\uffff\u0080\52\u0080\uffff\u092e\52\u10d2\uffff\u5200\52\u5900"+
            "\uffff\u0200\52",
            "\1\u00e1",
            "",
            "",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52\105\uffff\27"+
            "\52\1\uffff\37\52\1\uffff\u1f08\52\u1040\uffff\u0150\52\u0170"+
            "\uffff\u0080\52\u0080\uffff\u092e\52\u10d2\uffff\u5200\52\u5900"+
            "\uffff\u0200\52",
            ""
    };

    static final short[] DFA1_eot = DFA.unpackEncodedString(DFA1_eotS);
    static final short[] DFA1_eof = DFA.unpackEncodedString(DFA1_eofS);
    static final char[] DFA1_min = DFA.unpackEncodedStringToUnsignedChars(DFA1_minS);
    static final char[] DFA1_max = DFA.unpackEncodedStringToUnsignedChars(DFA1_maxS);
    static final short[] DFA1_accept = DFA.unpackEncodedString(DFA1_acceptS);
    static final short[] DFA1_special = DFA.unpackEncodedString(DFA1_specialS);
    static final short[][] DFA1_transition;

    static {
        int numStates = DFA1_transitionS.length;
        DFA1_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA1_transition[i] = DFA.unpackEncodedString(DFA1_transitionS[i]);
        }
    }

    class DFA1 extends DFA {

        public DFA1(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 1;
            this.eot = DFA1_eot;
            this.eof = DFA1_eof;
            this.min = DFA1_min;
            this.max = DFA1_max;
            this.accept = DFA1_accept;
            this.special = DFA1_special;
            this.transition = DFA1_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | T__104 | T__105 | T__106 | T__107 | T__108 | T__109 | T__110 | T__111 | T__112 | T__113 | T__114 | T__115 | T__116 | T__117 | T__118 | T__119 | T__120 | T__121 | T__122 | T__123 | T__124 | T__125 | T__126 | EolLexerRules. Tokens );";
        }
    }
 

}