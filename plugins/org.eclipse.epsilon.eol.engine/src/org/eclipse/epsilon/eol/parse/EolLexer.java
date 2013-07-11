// $ANTLR 3.1b1 Eol__.g 2013-07-11 11:41:37

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
    public static final int EXPONENT=6;
    public static final int StatementBlock=29;
    public static final int WHILE=33;
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
    public static final int NAME=19;
    public static final int IMPORT=65;
    public static final int T__92=92;
    public static final int T__90=90;
    public static final int RETURN=37;
    public static final int NewExpression=47;
    public static final int VAR=48;
    public static final int ANNOTATIONBLOCK=50;
    public static final int COMMENT=21;
    public static final int ABORT=43;
    public static final int NativeType=56;
    public static final int T__99=99;
    public static final int T__98=98;
    public static final int ITEMSELECTOR=72;
    public static final int T__97=97;
    public static final int T__96=96;
    public static final int MultiplicativeExpression=57;
    public static final int FLOAT_TYPE_SUFFIX=7;
    public static final int T__95=95;
    public static final int T__139=139;
    public static final int T__138=138;
    public static final int T__137=137;
    public static final int T__136=136;
    public static final int T__80=80;
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
    public static final int T__84=84;
    public static final int T__87=87;
    public static final int HELPERMETHOD=28;
    public static final int T__86=86;
    public static final int T__89=89;
    public static final int NAMESPACE=67;
    public static final int T__88=88;
    public static final int CollectionType=44;
    public static final int T__126=126;
    public static final int T__125=125;
    public static final int T__128=128;
    public static final int T__127=127;
    public static final int WS=20;
    public static final int T__129=129;
    public static final int ALIAS=68;
    public static final int JavaIDDigit=18;
    public static final int Annotation=23;
    public static final int T__76=76;
    public static final int T__130=130;
    public static final int T__131=131;
    public static final int EscapeSequence=13;
    public static final int Letter=16;
    public static final int THROW=53;
    public static final int T__132=132;
    public static final int T__79=79;
    public static final int T__133=133;
    public static final int T__78=78;
    public static final int T__134=134;
    public static final int T__77=77;
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
    public static final int T__122=122;
    public static final int FOR=30;
    public static final int T__121=121;
    public static final int ENUMERATION_VALUE=64;
    public static final int FLOAT=4;
    public static final int T__120=120;
    public static final int EXECUTABLEANNOTATION=51;
    public static final int IF=31;
    public static final int ModelElementType=45;
    public static final int BOOLEAN=12;
    public static final int T__107=107;
    public static final int CONTINUE=40;
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
    public static final int Tokens=140;
    public static final int POINT_POINT=10;
    public static final int SpecialNameChar=17;
    public static final int MODELDECLARATIONPARAMETERS=70;
    public static final int BLOCK=61;
    public static final int FEATURECALL=62;
    public static final int MAP=73;
    public static final int FORMAL=24;
    public static final int ARROW=11;
    public static final int ASSIGNMENT=26;
    public static final int STRING=14;

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

    // $ANTLR start T__76
    public final void mT__76() throws RecognitionException {
        try {
            int _type = T__76;
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
    // $ANTLR end T__76

    // $ANTLR start T__77
    public final void mT__77() throws RecognitionException {
        try {
            int _type = T__77;
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
    // $ANTLR end T__77

    // $ANTLR start T__78
    public final void mT__78() throws RecognitionException {
        try {
            int _type = T__78;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:46:7: ( 'alias' )
            // Eol__.g:46:9: 'alias'
            {
            match("alias"); 


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
    // $ANTLR end T__79

    // $ANTLR start T__80
    public final void mT__80() throws RecognitionException {
        try {
            int _type = T__80;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:48:7: ( 'driver' )
            // Eol__.g:48:9: 'driver'
            {
            match("driver"); 


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
            // Eol__.g:49:7: ( '{' )
            // Eol__.g:49:9: '{'
            {
            match('{'); 

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
            // Eol__.g:50:7: ( '}' )
            // Eol__.g:50:9: '}'
            {
            match('}'); 

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
            // Eol__.g:51:7: ( '=' )
            // Eol__.g:51:9: '='
            {
            match('='); 

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
            // Eol__.g:52:7: ( 'operation' )
            // Eol__.g:52:9: 'operation'
            {
            match("operation"); 


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
            // Eol__.g:53:7: ( 'function' )
            // Eol__.g:53:9: 'function'
            {
            match("function"); 


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
            // Eol__.g:54:7: ( '(' )
            // Eol__.g:54:9: '('
            {
            match('('); 

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
            // Eol__.g:55:7: ( ')' )
            // Eol__.g:55:9: ')'
            {
            match(')'); 

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
            // Eol__.g:56:7: ( ':' )
            // Eol__.g:56:9: ':'
            {
            match(':'); 

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
    // $ANTLR end T__89

    // $ANTLR start T__90
    public final void mT__90() throws RecognitionException {
        try {
            int _type = T__90;
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
    // $ANTLR end T__90

    // $ANTLR start T__91
    public final void mT__91() throws RecognitionException {
        try {
            int _type = T__91;
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
    // $ANTLR end T__91

    // $ANTLR start T__92
    public final void mT__92() throws RecognitionException {
        try {
            int _type = T__92;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:60:7: ( '#' )
            // Eol__.g:60:9: '#'
            {
            match('#'); 

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
            // Eol__.g:61:7: ( '::' )
            // Eol__.g:61:9: '::'
            {
            match("::"); 


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
    // $ANTLR end T__94

    // $ANTLR start T__95
    public final void mT__95() throws RecognitionException {
        try {
            int _type = T__95;
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
    // $ANTLR end T__95

    // $ANTLR start T__96
    public final void mT__96() throws RecognitionException {
        try {
            int _type = T__96;
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
    // $ANTLR end T__96

    // $ANTLR start T__97
    public final void mT__97() throws RecognitionException {
        try {
            int _type = T__97;
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
    // $ANTLR end T__97

    // $ANTLR start T__98
    public final void mT__98() throws RecognitionException {
        try {
            int _type = T__98;
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
    // $ANTLR end T__98

    // $ANTLR start T__99
    public final void mT__99() throws RecognitionException {
        try {
            int _type = T__99;
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
    // $ANTLR end T__99

    // $ANTLR start T__100
    public final void mT__100() throws RecognitionException {
        try {
            int _type = T__100;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:68:8: ( 'OrderedSet' )
            // Eol__.g:68:10: 'OrderedSet'
            {
            match("OrderedSet"); 


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
            // Eol__.g:69:8: ( 'Map' )
            // Eol__.g:69:10: 'Map'
            {
            match("Map"); 


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
            // Eol__.g:70:8: ( 'for' )
            // Eol__.g:70:10: 'for'
            {
            match("for"); 


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
            // Eol__.g:71:8: ( 'in' )
            // Eol__.g:71:10: 'in'
            {
            match("in"); 


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
            // Eol__.g:72:8: ( 'if' )
            // Eol__.g:72:10: 'if'
            {
            match("if"); 


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
            // Eol__.g:73:8: ( 'switch' )
            // Eol__.g:73:10: 'switch'
            {
            match("switch"); 


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
            // Eol__.g:74:8: ( 'case' )
            // Eol__.g:74:10: 'case'
            {
            match("case"); 


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
            // Eol__.g:75:8: ( 'default' )
            // Eol__.g:75:10: 'default'
            {
            match("default"); 


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
            // Eol__.g:76:8: ( 'else' )
            // Eol__.g:76:10: 'else'
            {
            match("else"); 


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
            // Eol__.g:77:8: ( 'while' )
            // Eol__.g:77:10: 'while'
            {
            match("while"); 


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
            // Eol__.g:78:8: ( 'return' )
            // Eol__.g:78:10: 'return'
            {
            match("return"); 


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
            // Eol__.g:79:8: ( 'throw' )
            // Eol__.g:79:10: 'throw'
            {
            match("throw"); 


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
            // Eol__.g:80:8: ( 'delete' )
            // Eol__.g:80:10: 'delete'
            {
            match("delete"); 


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
            // Eol__.g:81:8: ( 'break' )
            // Eol__.g:81:10: 'break'
            {
            match("break"); 


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
            // Eol__.g:82:8: ( 'breakAll' )
            // Eol__.g:82:10: 'breakAll'
            {
            match("breakAll"); 


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
            // Eol__.g:83:8: ( 'continue' )
            // Eol__.g:83:10: 'continue'
            {
            match("continue"); 


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
            // Eol__.g:84:8: ( 'abort' )
            // Eol__.g:84:10: 'abort'
            {
            match("abort"); 


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
            // Eol__.g:85:8: ( 'transaction' )
            // Eol__.g:85:10: 'transaction'
            {
            match("transaction"); 


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
            // Eol__.g:86:8: ( ':=' )
            // Eol__.g:86:10: ':='
            {
            match(":="); 


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
            // Eol__.g:87:8: ( '::=' )
            // Eol__.g:87:10: '::='
            {
            match("::="); 


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
            // Eol__.g:88:8: ( 'or' )
            // Eol__.g:88:10: 'or'
            {
            match("or"); 


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
            // Eol__.g:89:8: ( 'and' )
            // Eol__.g:89:10: 'and'
            {
            match("and"); 


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
            // Eol__.g:90:8: ( 'xor' )
            // Eol__.g:90:10: 'xor'
            {
            match("xor"); 


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
            // Eol__.g:91:8: ( 'implies' )
            // Eol__.g:91:10: 'implies'
            {
            match("implies"); 


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
            // Eol__.g:92:8: ( '==' )
            // Eol__.g:92:10: '=='
            {
            match("=="); 


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
            // Eol__.g:93:8: ( '>' )
            // Eol__.g:93:10: '>'
            {
            match('>'); 

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
            // Eol__.g:94:8: ( '<' )
            // Eol__.g:94:10: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__126

    // $ANTLR start T__127
    public final void mT__127() throws RecognitionException {
        try {
            int _type = T__127;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:95:8: ( '>=' )
            // Eol__.g:95:10: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__127

    // $ANTLR start T__128
    public final void mT__128() throws RecognitionException {
        try {
            int _type = T__128;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:96:8: ( '<=' )
            // Eol__.g:96:10: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__128

    // $ANTLR start T__129
    public final void mT__129() throws RecognitionException {
        try {
            int _type = T__129;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:97:8: ( '<>' )
            // Eol__.g:97:10: '<>'
            {
            match("<>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__129

    // $ANTLR start T__130
    public final void mT__130() throws RecognitionException {
        try {
            int _type = T__130;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:98:8: ( '+' )
            // Eol__.g:98:10: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__130

    // $ANTLR start T__131
    public final void mT__131() throws RecognitionException {
        try {
            int _type = T__131;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:99:8: ( '-' )
            // Eol__.g:99:10: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__131

    // $ANTLR start T__132
    public final void mT__132() throws RecognitionException {
        try {
            int _type = T__132;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:100:8: ( '*' )
            // Eol__.g:100:10: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__132

    // $ANTLR start T__133
    public final void mT__133() throws RecognitionException {
        try {
            int _type = T__133;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:101:8: ( '/' )
            // Eol__.g:101:10: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__133

    // $ANTLR start T__134
    public final void mT__134() throws RecognitionException {
        try {
            int _type = T__134;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:102:8: ( 'not' )
            // Eol__.g:102:10: 'not'
            {
            match("not"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__134

    // $ANTLR start T__135
    public final void mT__135() throws RecognitionException {
        try {
            int _type = T__135;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:103:8: ( '[' )
            // Eol__.g:103:10: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__135

    // $ANTLR start T__136
    public final void mT__136() throws RecognitionException {
        try {
            int _type = T__136;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:104:8: ( ']' )
            // Eol__.g:104:10: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__136

    // $ANTLR start T__137
    public final void mT__137() throws RecognitionException {
        try {
            int _type = T__137;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:105:8: ( '|' )
            // Eol__.g:105:10: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__137

    // $ANTLR start T__138
    public final void mT__138() throws RecognitionException {
        try {
            int _type = T__138;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:106:8: ( 'new' )
            // Eol__.g:106:10: 'new'
            {
            match("new"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__138

    // $ANTLR start T__139
    public final void mT__139() throws RecognitionException {
        try {
            int _type = T__139;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Eol__.g:107:8: ( 'var' )
            // Eol__.g:107:10: 'var'
            {
            match("var"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__139

    public void mTokens() throws RecognitionException {
        // Eol__.g:1:8: ( T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | T__104 | T__105 | T__106 | T__107 | T__108 | T__109 | T__110 | T__111 | T__112 | T__113 | T__114 | T__115 | T__116 | T__117 | T__118 | T__119 | T__120 | T__121 | T__122 | T__123 | T__124 | T__125 | T__126 | T__127 | T__128 | T__129 | T__130 | T__131 | T__132 | T__133 | T__134 | T__135 | T__136 | T__137 | T__138 | T__139 | EolLexerRules. Tokens )
        int alt1=65;
        alt1 = dfa1.predict(input);
        switch (alt1) {
            case 1 :
                // Eol__.g:1:10: T__76
                {
                mT__76(); 

                }
                break;
            case 2 :
                // Eol__.g:1:16: T__77
                {
                mT__77(); 

                }
                break;
            case 3 :
                // Eol__.g:1:22: T__78
                {
                mT__78(); 

                }
                break;
            case 4 :
                // Eol__.g:1:28: T__79
                {
                mT__79(); 

                }
                break;
            case 5 :
                // Eol__.g:1:34: T__80
                {
                mT__80(); 

                }
                break;
            case 6 :
                // Eol__.g:1:40: T__81
                {
                mT__81(); 

                }
                break;
            case 7 :
                // Eol__.g:1:46: T__82
                {
                mT__82(); 

                }
                break;
            case 8 :
                // Eol__.g:1:52: T__83
                {
                mT__83(); 

                }
                break;
            case 9 :
                // Eol__.g:1:58: T__84
                {
                mT__84(); 

                }
                break;
            case 10 :
                // Eol__.g:1:64: T__85
                {
                mT__85(); 

                }
                break;
            case 11 :
                // Eol__.g:1:70: T__86
                {
                mT__86(); 

                }
                break;
            case 12 :
                // Eol__.g:1:76: T__87
                {
                mT__87(); 

                }
                break;
            case 13 :
                // Eol__.g:1:82: T__88
                {
                mT__88(); 

                }
                break;
            case 14 :
                // Eol__.g:1:88: T__89
                {
                mT__89(); 

                }
                break;
            case 15 :
                // Eol__.g:1:94: T__90
                {
                mT__90(); 

                }
                break;
            case 16 :
                // Eol__.g:1:100: T__91
                {
                mT__91(); 

                }
                break;
            case 17 :
                // Eol__.g:1:106: T__92
                {
                mT__92(); 

                }
                break;
            case 18 :
                // Eol__.g:1:112: T__93
                {
                mT__93(); 

                }
                break;
            case 19 :
                // Eol__.g:1:118: T__94
                {
                mT__94(); 

                }
                break;
            case 20 :
                // Eol__.g:1:124: T__95
                {
                mT__95(); 

                }
                break;
            case 21 :
                // Eol__.g:1:130: T__96
                {
                mT__96(); 

                }
                break;
            case 22 :
                // Eol__.g:1:136: T__97
                {
                mT__97(); 

                }
                break;
            case 23 :
                // Eol__.g:1:142: T__98
                {
                mT__98(); 

                }
                break;
            case 24 :
                // Eol__.g:1:148: T__99
                {
                mT__99(); 

                }
                break;
            case 25 :
                // Eol__.g:1:154: T__100
                {
                mT__100(); 

                }
                break;
            case 26 :
                // Eol__.g:1:161: T__101
                {
                mT__101(); 

                }
                break;
            case 27 :
                // Eol__.g:1:168: T__102
                {
                mT__102(); 

                }
                break;
            case 28 :
                // Eol__.g:1:175: T__103
                {
                mT__103(); 

                }
                break;
            case 29 :
                // Eol__.g:1:182: T__104
                {
                mT__104(); 

                }
                break;
            case 30 :
                // Eol__.g:1:189: T__105
                {
                mT__105(); 

                }
                break;
            case 31 :
                // Eol__.g:1:196: T__106
                {
                mT__106(); 

                }
                break;
            case 32 :
                // Eol__.g:1:203: T__107
                {
                mT__107(); 

                }
                break;
            case 33 :
                // Eol__.g:1:210: T__108
                {
                mT__108(); 

                }
                break;
            case 34 :
                // Eol__.g:1:217: T__109
                {
                mT__109(); 

                }
                break;
            case 35 :
                // Eol__.g:1:224: T__110
                {
                mT__110(); 

                }
                break;
            case 36 :
                // Eol__.g:1:231: T__111
                {
                mT__111(); 

                }
                break;
            case 37 :
                // Eol__.g:1:238: T__112
                {
                mT__112(); 

                }
                break;
            case 38 :
                // Eol__.g:1:245: T__113
                {
                mT__113(); 

                }
                break;
            case 39 :
                // Eol__.g:1:252: T__114
                {
                mT__114(); 

                }
                break;
            case 40 :
                // Eol__.g:1:259: T__115
                {
                mT__115(); 

                }
                break;
            case 41 :
                // Eol__.g:1:266: T__116
                {
                mT__116(); 

                }
                break;
            case 42 :
                // Eol__.g:1:273: T__117
                {
                mT__117(); 

                }
                break;
            case 43 :
                // Eol__.g:1:280: T__118
                {
                mT__118(); 

                }
                break;
            case 44 :
                // Eol__.g:1:287: T__119
                {
                mT__119(); 

                }
                break;
            case 45 :
                // Eol__.g:1:294: T__120
                {
                mT__120(); 

                }
                break;
            case 46 :
                // Eol__.g:1:301: T__121
                {
                mT__121(); 

                }
                break;
            case 47 :
                // Eol__.g:1:308: T__122
                {
                mT__122(); 

                }
                break;
            case 48 :
                // Eol__.g:1:315: T__123
                {
                mT__123(); 

                }
                break;
            case 49 :
                // Eol__.g:1:322: T__124
                {
                mT__124(); 

                }
                break;
            case 50 :
                // Eol__.g:1:329: T__125
                {
                mT__125(); 

                }
                break;
            case 51 :
                // Eol__.g:1:336: T__126
                {
                mT__126(); 

                }
                break;
            case 52 :
                // Eol__.g:1:343: T__127
                {
                mT__127(); 

                }
                break;
            case 53 :
                // Eol__.g:1:350: T__128
                {
                mT__128(); 

                }
                break;
            case 54 :
                // Eol__.g:1:357: T__129
                {
                mT__129(); 

                }
                break;
            case 55 :
                // Eol__.g:1:364: T__130
                {
                mT__130(); 

                }
                break;
            case 56 :
                // Eol__.g:1:371: T__131
                {
                mT__131(); 

                }
                break;
            case 57 :
                // Eol__.g:1:378: T__132
                {
                mT__132(); 

                }
                break;
            case 58 :
                // Eol__.g:1:385: T__133
                {
                mT__133(); 

                }
                break;
            case 59 :
                // Eol__.g:1:392: T__134
                {
                mT__134(); 

                }
                break;
            case 60 :
                // Eol__.g:1:399: T__135
                {
                mT__135(); 

                }
                break;
            case 61 :
                // Eol__.g:1:406: T__136
                {
                mT__136(); 

                }
                break;
            case 62 :
                // Eol__.g:1:413: T__137
                {
                mT__137(); 

                }
                break;
            case 63 :
                // Eol__.g:1:420: T__138
                {
                mT__138(); 

                }
                break;
            case 64 :
                // Eol__.g:1:427: T__139
                {
                mT__139(); 

                }
                break;
            case 65 :
                // Eol__.g:1:434: EolLexerRules. Tokens
                {
                gEolLexerRules.mTokens(); 

                }
                break;

        }

    }


    protected DFA1 dfa1 = new DFA1(this);
    static final String DFA1_eotS =
        "\1\uffff\1\54\1\uffff\1\54\1\uffff\1\54\2\uffff\1\64\2\54\2\uffff"+
        "\1\73\1\54\3\uffff\17\54\1\121\1\124\1\uffff\1\125\1\uffff\1\126"+
        "\1\54\3\uffff\1\54\1\uffff\6\54\2\uffff\1\54\1\142\2\54\1\146\2"+
        "\uffff\1\54\1\150\1\151\21\54\7\uffff\6\54\1\u0082\4\54\1\uffff"+
        "\1\54\1\u0088\2\uffff\1\54\2\uffff\3\54\1\u008e\1\54\1\u0090\1\54"+
        "\1\u0092\11\54\1\u009c\1\u009d\1\u009e\1\u009f\3\54\1\uffff\5\54"+
        "\1\uffff\5\54\1\uffff\1\u00ad\1\uffff\1\54\1\uffff\1\54\1\u00b0"+
        "\1\54\1\u00b2\5\54\4\uffff\1\u00b8\1\u00b9\1\u00ba\12\54\1\uffff"+
        "\2\54\1\uffff\1\54\1\uffff\1\u00c8\1\54\1\u00ca\1\54\1\u00cd\3\uffff"+
        "\1\u00ce\1\54\1\u00d0\2\54\1\u00d3\1\54\1\u00d5\3\54\1\u00d9\1\54"+
        "\1\uffff\1\u00db\1\uffff\2\54\2\uffff\1\u00de\1\uffff\2\54\1\uffff"+
        "\1\u00e1\1\uffff\3\54\1\uffff\1\54\1\uffff\2\54\1\uffff\1\54\1\u00e9"+
        "\1\uffff\1\54\1\u00eb\1\54\1\u00ed\1\54\1\u00ef\1\u00f0\1\uffff"+
        "\1\54\1\uffff\1\54\1\uffff\1\54\2\uffff\1\u00f4\1\u00f5\1\54\2\uffff"+
        "\1\u00f7\1\uffff";
    static final String DFA1_eofS =
        "\u00f8\uffff";
    static final String DFA1_minS =
        "\1\11\1\157\1\uffff\1\142\1\uffff\1\145\2\uffff\1\75\1\160\1\157"+
        "\2\uffff\1\72\1\146\3\uffff\1\141\1\157\1\145\1\151\1\141\1\162"+
        "\1\141\1\167\1\141\1\154\1\150\1\145\1\150\1\162\1\157\2\75\1\uffff"+
        "\1\52\1\uffff\1\52\1\145\3\uffff\1\141\1\uffff\1\144\1\151\1\157"+
        "\1\144\1\151\1\146\2\uffff\1\145\1\46\1\156\1\162\1\75\2\uffff\1"+
        "\160\2\46\1\164\1\154\1\161\1\163\1\147\1\144\1\160\1\151\1\163"+
        "\1\156\1\163\1\151\1\164\1\162\1\141\1\145\1\162\7\uffff\1\164\1"+
        "\167\1\162\1\145\1\141\1\162\1\46\1\166\1\141\1\145\1\162\1\uffff"+
        "\1\143\1\46\2\uffff\1\154\2\uffff\1\151\1\154\1\165\1\46\1\164\1"+
        "\46\1\145\1\46\1\164\1\145\1\164\1\145\1\154\1\165\1\157\1\156\1"+
        "\141\4\46\1\154\1\163\1\164\1\uffff\1\145\1\165\1\164\1\141\1\164"+
        "\1\uffff\1\162\1\151\1\166\2\145\1\uffff\1\46\1\uffff\1\162\1\uffff"+
        "\1\143\1\46\1\151\1\46\1\145\1\162\1\167\1\163\1\153\4\uffff\3\46"+
        "\1\162\1\154\1\145\1\164\1\151\1\164\2\145\1\143\1\156\1\uffff\1"+
        "\145\1\150\1\uffff\1\156\1\uffff\1\46\1\156\1\46\1\141\1\46\3\uffff"+
        "\1\46\1\164\1\46\1\151\1\157\1\46\1\163\1\46\1\164\1\143\1\144\1"+
        "\46\1\165\1\uffff\1\46\1\uffff\1\143\1\154\2\uffff\1\46\1\uffff"+
        "\1\157\1\156\1\uffff\1\46\1\uffff\1\151\1\145\1\123\1\uffff\1\145"+
        "\1\uffff\1\164\1\154\1\uffff\1\156\1\46\1\uffff\1\157\1\46\1\145"+
        "\1\46\1\151\2\46\1\uffff\1\156\1\uffff\1\164\1\uffff\1\157\2\uffff"+
        "\2\46\1\156\2\uffff\1\46\1\uffff";
    static final String DFA1_maxS =
        "\1\ufaff\1\157\1\uffff\1\156\1\uffff\1\162\2\uffff\1\75\1\162\1"+
        "\165\2\uffff\1\75\1\156\3\uffff\1\141\1\157\1\145\1\151\1\141\1"+
        "\162\1\141\1\167\1\157\1\154\1\150\1\145\2\162\1\157\1\75\1\76\1"+
        "\uffff\1\76\1\uffff\1\57\1\157\3\uffff\1\141\1\uffff\1\144\1\151"+
        "\1\157\1\144\1\151\1\154\2\uffff\1\145\1\ufaff\1\156\1\162\1\75"+
        "\2\uffff\1\160\2\ufaff\1\164\1\154\1\164\1\163\1\147\1\144\1\160"+
        "\1\151\1\163\1\156\1\163\1\151\1\164\1\162\1\141\1\145\1\162\7\uffff"+
        "\1\164\1\167\1\162\1\145\1\141\1\162\1\ufaff\1\166\1\141\1\145\1"+
        "\162\1\uffff\1\143\1\ufaff\2\uffff\1\157\2\uffff\1\151\1\154\1\165"+
        "\1\ufaff\1\164\1\ufaff\1\145\1\ufaff\1\164\1\145\1\164\1\145\1\154"+
        "\1\165\1\157\1\156\1\141\4\ufaff\1\154\1\163\1\164\1\uffff\1\145"+
        "\1\165\1\164\1\141\1\164\1\uffff\1\162\1\151\1\166\2\145\1\uffff"+
        "\1\ufaff\1\uffff\1\162\1\uffff\1\143\1\ufaff\1\151\1\ufaff\1\145"+
        "\1\162\1\167\1\163\1\153\4\uffff\3\ufaff\1\162\1\154\1\145\1\164"+
        "\1\151\1\164\2\145\1\143\1\156\1\uffff\1\145\1\150\1\uffff\1\156"+
        "\1\uffff\1\ufaff\1\156\1\ufaff\1\141\1\ufaff\3\uffff\1\ufaff\1\164"+
        "\1\ufaff\1\151\1\157\1\ufaff\1\163\1\ufaff\1\164\1\143\1\144\1\ufaff"+
        "\1\165\1\uffff\1\ufaff\1\uffff\1\143\1\154\2\uffff\1\ufaff\1\uffff"+
        "\1\157\1\156\1\uffff\1\ufaff\1\uffff\1\151\1\145\1\123\1\uffff\1"+
        "\145\1\uffff\1\164\1\154\1\uffff\1\156\1\ufaff\1\uffff\1\157\1\ufaff"+
        "\1\145\1\ufaff\1\151\2\ufaff\1\uffff\1\156\1\uffff\1\164\1\uffff"+
        "\1\157\2\uffff\2\ufaff\1\156\2\uffff\1\ufaff\1\uffff";
    static final String DFA1_acceptS =
        "\2\uffff\1\2\1\uffff\1\4\1\uffff\1\6\1\7\3\uffff\1\13\1\14\2\uffff"+
        "\1\17\1\20\1\21\21\uffff\1\67\1\uffff\1\71\2\uffff\1\74\1\75\1\76"+
        "\1\uffff\1\101\6\uffff\1\61\1\10\5\uffff\1\53\1\15\24\uffff\1\64"+
        "\1\62\1\65\1\66\1\63\1\70\1\72\13\uffff\1\55\2\uffff\1\54\1\22\1"+
        "\uffff\1\34\1\35\30\uffff\1\56\5\uffff\1\33\5\uffff\1\30\1\uffff"+
        "\1\27\1\uffff\1\32\11\uffff\1\57\1\73\1\77\1\100\15\uffff\1\26\2"+
        "\uffff\1\37\1\uffff\1\41\5\uffff\1\1\1\3\1\51\15\uffff\1\42\1\uffff"+
        "\1\44\2\uffff\1\46\1\5\1\uffff\1\45\2\uffff\1\16\1\uffff\1\23\3"+
        "\uffff\1\36\1\uffff\1\43\2\uffff\1\40\2\uffff\1\60\7\uffff\1\12"+
        "\1\uffff\1\25\1\uffff\1\50\1\uffff\1\47\1\11\3\uffff\1\24\1\31\1"+
        "\uffff\1\52";
    static final String DFA1_specialS =
        "\u00f8\uffff}>";
    static final String[] DFA1_transitionS = {
            "\2\54\1\uffff\2\54\22\uffff\1\54\1\20\1\54\1\21\1\17\1\uffff"+
            "\2\54\1\13\1\14\1\45\1\43\1\4\1\44\1\54\1\46\12\54\1\15\1\2"+
            "\1\42\1\10\1\41\3\54\1\26\1\23\10\54\1\25\1\30\1\22\1\27\3\54"+
            "\1\24\7\54\1\50\1\uffff\1\51\3\54\1\3\1\37\1\32\1\5\1\33\1\12"+
            "\2\54\1\16\3\54\1\1\1\47\1\11\2\54\1\35\1\31\1\36\1\54\1\53"+
            "\1\34\1\40\2\54\1\6\1\52\1\7\1\54\101\uffff\27\54\1\uffff\37"+
            "\54\1\uffff\u1f08\54\u1040\uffff\u0150\54\u0170\uffff\u0080"+
            "\54\u0080\uffff\u092e\54\u10d2\uffff\u5200\54\u5900\uffff\u0200"+
            "\54",
            "\1\55",
            "",
            "\1\57\11\uffff\1\56\1\uffff\1\60",
            "",
            "\1\62\14\uffff\1\61",
            "",
            "",
            "\1\63",
            "\1\65\1\uffff\1\66",
            "\1\70\5\uffff\1\67",
            "",
            "",
            "\1\71\2\uffff\1\72",
            "\1\76\6\uffff\1\74\1\75",
            "",
            "",
            "",
            "\1\77",
            "\1\100",
            "\1\101",
            "\1\102",
            "\1\103",
            "\1\104",
            "\1\105",
            "\1\106",
            "\1\107\15\uffff\1\110",
            "\1\111",
            "\1\112",
            "\1\113",
            "\1\114\11\uffff\1\115",
            "\1\116",
            "\1\117",
            "\1\120",
            "\1\122\1\123",
            "",
            "\1\54\2\uffff\1\54\20\uffff\1\54",
            "",
            "\1\54\4\uffff\1\54",
            "\1\130\11\uffff\1\127",
            "",
            "",
            "",
            "\1\131",
            "",
            "\1\132",
            "\1\133",
            "\1\134",
            "\1\135",
            "\1\136",
            "\1\137\5\uffff\1\140",
            "",
            "",
            "\1\141",
            "\1\54\11\uffff\12\54\5\uffff\1\54\1\uffff\32\54\3\uffff\2\54"+
            "\1\uffff\32\54\3\uffff\1\54\101\uffff\27\54\1\uffff\37\54\1"+
            "\uffff\u1f08\54\u1040\uffff\u0150\54\u0170\uffff\u0080\54\u0080"+
            "\uffff\u092e\54\u10d2\uffff\u5200\54\u5900\uffff\u0200\54",
            "\1\143",
            "\1\144",
            "\1\145",
            "",
            "",
            "\1\147",
            "\1\54\11\uffff\12\54\5\uffff\1\54\1\uffff\32\54\3\uffff\2\54"+
            "\1\uffff\32\54\3\uffff\1\54\101\uffff\27\54\1\uffff\37\54\1"+
            "\uffff\u1f08\54\u1040\uffff\u0150\54\u0170\uffff\u0080\54\u0080"+
            "\uffff\u092e\54\u10d2\uffff\u5200\54\u5900\uffff\u0200\54",
            "\1\54\11\uffff\12\54\5\uffff\1\54\1\uffff\32\54\3\uffff\2\54"+
            "\1\uffff\32\54\3\uffff\1\54\101\uffff\27\54\1\uffff\37\54\1"+
            "\uffff\u1f08\54\u1040\uffff\u0150\54\u0170\uffff\u0080\54\u0080"+
            "\uffff\u092e\54\u10d2\uffff\u5200\54\u5900\uffff\u0200\54",
            "\1\152",
            "\1\153",
            "\1\154\2\uffff\1\155",
            "\1\156",
            "\1\157",
            "\1\160",
            "\1\161",
            "\1\162",
            "\1\163",
            "\1\164",
            "\1\165",
            "\1\166",
            "\1\167",
            "\1\170",
            "\1\171",
            "\1\172",
            "\1\173",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\174",
            "\1\175",
            "\1\176",
            "\1\177",
            "\1\u0080",
            "\1\u0081",
            "\1\54\11\uffff\12\54\5\uffff\1\54\1\uffff\32\54\3\uffff\2\54"+
            "\1\uffff\32\54\3\uffff\1\54\101\uffff\27\54\1\uffff\37\54\1"+
            "\uffff\u1f08\54\u1040\uffff\u0150\54\u0170\uffff\u0080\54\u0080"+
            "\uffff\u092e\54\u10d2\uffff\u5200\54\u5900\uffff\u0200\54",
            "\1\u0083",
            "\1\u0084",
            "\1\u0085",
            "\1\u0086",
            "",
            "\1\u0087",
            "\1\54\11\uffff\12\54\5\uffff\1\54\1\uffff\32\54\3\uffff\2\54"+
            "\1\uffff\32\54\3\uffff\1\54\101\uffff\27\54\1\uffff\37\54\1"+
            "\uffff\u1f08\54\u1040\uffff\u0150\54\u0170\uffff\u0080\54\u0080"+
            "\uffff\u092e\54\u10d2\uffff\u5200\54\u5900\uffff\u0200\54",
            "",
            "",
            "\1\u008a\2\uffff\1\u0089",
            "",
            "",
            "\1\u008b",
            "\1\u008c",
            "\1\u008d",
            "\1\54\11\uffff\12\54\5\uffff\1\54\1\uffff\32\54\3\uffff\2\54"+
            "\1\uffff\32\54\3\uffff\1\54\101\uffff\27\54\1\uffff\37\54\1"+
            "\uffff\u1f08\54\u1040\uffff\u0150\54\u0170\uffff\u0080\54\u0080"+
            "\uffff\u092e\54\u10d2\uffff\u5200\54\u5900\uffff\u0200\54",
            "\1\u008f",
            "\1\54\11\uffff\12\54\5\uffff\1\54\1\uffff\32\54\3\uffff\2\54"+
            "\1\uffff\32\54\3\uffff\1\54\101\uffff\27\54\1\uffff\37\54\1"+
            "\uffff\u1f08\54\u1040\uffff\u0150\54\u0170\uffff\u0080\54\u0080"+
            "\uffff\u092e\54\u10d2\uffff\u5200\54\u5900\uffff\u0200\54",
            "\1\u0091",
            "\1\54\11\uffff\12\54\5\uffff\1\54\1\uffff\32\54\3\uffff\2\54"+
            "\1\uffff\32\54\3\uffff\1\54\101\uffff\27\54\1\uffff\37\54\1"+
            "\uffff\u1f08\54\u1040\uffff\u0150\54\u0170\uffff\u0080\54\u0080"+
            "\uffff\u092e\54\u10d2\uffff\u5200\54\u5900\uffff\u0200\54",
            "\1\u0093",
            "\1\u0094",
            "\1\u0095",
            "\1\u0096",
            "\1\u0097",
            "\1\u0098",
            "\1\u0099",
            "\1\u009a",
            "\1\u009b",
            "\1\54\11\uffff\12\54\5\uffff\1\54\1\uffff\32\54\3\uffff\2\54"+
            "\1\uffff\32\54\3\uffff\1\54\101\uffff\27\54\1\uffff\37\54\1"+
            "\uffff\u1f08\54\u1040\uffff\u0150\54\u0170\uffff\u0080\54\u0080"+
            "\uffff\u092e\54\u10d2\uffff\u5200\54\u5900\uffff\u0200\54",
            "\1\54\11\uffff\12\54\5\uffff\1\54\1\uffff\32\54\3\uffff\2\54"+
            "\1\uffff\32\54\3\uffff\1\54\101\uffff\27\54\1\uffff\37\54\1"+
            "\uffff\u1f08\54\u1040\uffff\u0150\54\u0170\uffff\u0080\54\u0080"+
            "\uffff\u092e\54\u10d2\uffff\u5200\54\u5900\uffff\u0200\54",
            "\1\54\11\uffff\12\54\5\uffff\1\54\1\uffff\32\54\3\uffff\2\54"+
            "\1\uffff\32\54\3\uffff\1\54\101\uffff\27\54\1\uffff\37\54\1"+
            "\uffff\u1f08\54\u1040\uffff\u0150\54\u0170\uffff\u0080\54\u0080"+
            "\uffff\u092e\54\u10d2\uffff\u5200\54\u5900\uffff\u0200\54",
            "\1\54\11\uffff\12\54\5\uffff\1\54\1\uffff\32\54\3\uffff\2\54"+
            "\1\uffff\32\54\3\uffff\1\54\101\uffff\27\54\1\uffff\37\54\1"+
            "\uffff\u1f08\54\u1040\uffff\u0150\54\u0170\uffff\u0080\54\u0080"+
            "\uffff\u092e\54\u10d2\uffff\u5200\54\u5900\uffff\u0200\54",
            "\1\u00a0",
            "\1\u00a1",
            "\1\u00a2",
            "",
            "\1\u00a3",
            "\1\u00a4",
            "\1\u00a5",
            "\1\u00a6",
            "\1\u00a7",
            "",
            "\1\u00a8",
            "\1\u00a9",
            "\1\u00aa",
            "\1\u00ab",
            "\1\u00ac",
            "",
            "\1\54\11\uffff\12\54\5\uffff\1\54\1\uffff\32\54\3\uffff\2\54"+
            "\1\uffff\32\54\3\uffff\1\54\101\uffff\27\54\1\uffff\37\54\1"+
            "\uffff\u1f08\54\u1040\uffff\u0150\54\u0170\uffff\u0080\54\u0080"+
            "\uffff\u092e\54\u10d2\uffff\u5200\54\u5900\uffff\u0200\54",
            "",
            "\1\u00ae",
            "",
            "\1\u00af",
            "\1\54\11\uffff\12\54\5\uffff\1\54\1\uffff\32\54\3\uffff\2\54"+
            "\1\uffff\32\54\3\uffff\1\54\101\uffff\27\54\1\uffff\37\54\1"+
            "\uffff\u1f08\54\u1040\uffff\u0150\54\u0170\uffff\u0080\54\u0080"+
            "\uffff\u092e\54\u10d2\uffff\u5200\54\u5900\uffff\u0200\54",
            "\1\u00b1",
            "\1\54\11\uffff\12\54\5\uffff\1\54\1\uffff\32\54\3\uffff\2\54"+
            "\1\uffff\32\54\3\uffff\1\54\101\uffff\27\54\1\uffff\37\54\1"+
            "\uffff\u1f08\54\u1040\uffff\u0150\54\u0170\uffff\u0080\54\u0080"+
            "\uffff\u092e\54\u10d2\uffff\u5200\54\u5900\uffff\u0200\54",
            "\1\u00b3",
            "\1\u00b4",
            "\1\u00b5",
            "\1\u00b6",
            "\1\u00b7",
            "",
            "",
            "",
            "",
            "\1\54\11\uffff\12\54\5\uffff\1\54\1\uffff\32\54\3\uffff\2\54"+
            "\1\uffff\32\54\3\uffff\1\54\101\uffff\27\54\1\uffff\37\54\1"+
            "\uffff\u1f08\54\u1040\uffff\u0150\54\u0170\uffff\u0080\54\u0080"+
            "\uffff\u092e\54\u10d2\uffff\u5200\54\u5900\uffff\u0200\54",
            "\1\54\11\uffff\12\54\5\uffff\1\54\1\uffff\32\54\3\uffff\2\54"+
            "\1\uffff\32\54\3\uffff\1\54\101\uffff\27\54\1\uffff\37\54\1"+
            "\uffff\u1f08\54\u1040\uffff\u0150\54\u0170\uffff\u0080\54\u0080"+
            "\uffff\u092e\54\u10d2\uffff\u5200\54\u5900\uffff\u0200\54",
            "\1\54\11\uffff\12\54\5\uffff\1\54\1\uffff\32\54\3\uffff\2\54"+
            "\1\uffff\32\54\3\uffff\1\54\101\uffff\27\54\1\uffff\37\54\1"+
            "\uffff\u1f08\54\u1040\uffff\u0150\54\u0170\uffff\u0080\54\u0080"+
            "\uffff\u092e\54\u10d2\uffff\u5200\54\u5900\uffff\u0200\54",
            "\1\u00bb",
            "\1\u00bc",
            "\1\u00bd",
            "\1\u00be",
            "\1\u00bf",
            "\1\u00c0",
            "\1\u00c1",
            "\1\u00c2",
            "\1\u00c3",
            "\1\u00c4",
            "",
            "\1\u00c5",
            "\1\u00c6",
            "",
            "\1\u00c7",
            "",
            "\1\54\11\uffff\12\54\5\uffff\1\54\1\uffff\32\54\3\uffff\2\54"+
            "\1\uffff\32\54\3\uffff\1\54\101\uffff\27\54\1\uffff\37\54\1"+
            "\uffff\u1f08\54\u1040\uffff\u0150\54\u0170\uffff\u0080\54\u0080"+
            "\uffff\u092e\54\u10d2\uffff\u5200\54\u5900\uffff\u0200\54",
            "\1\u00c9",
            "\1\54\11\uffff\12\54\5\uffff\1\54\1\uffff\32\54\3\uffff\2\54"+
            "\1\uffff\32\54\3\uffff\1\54\101\uffff\27\54\1\uffff\37\54\1"+
            "\uffff\u1f08\54\u1040\uffff\u0150\54\u0170\uffff\u0080\54\u0080"+
            "\uffff\u092e\54\u10d2\uffff\u5200\54\u5900\uffff\u0200\54",
            "\1\u00cb",
            "\1\54\11\uffff\12\54\5\uffff\1\54\1\uffff\1\u00cc\31\54\3\uffff"+
            "\2\54\1\uffff\32\54\3\uffff\1\54\101\uffff\27\54\1\uffff\37"+
            "\54\1\uffff\u1f08\54\u1040\uffff\u0150\54\u0170\uffff\u0080"+
            "\54\u0080\uffff\u092e\54\u10d2\uffff\u5200\54\u5900\uffff\u0200"+
            "\54",
            "",
            "",
            "",
            "\1\54\11\uffff\12\54\5\uffff\1\54\1\uffff\32\54\3\uffff\2\54"+
            "\1\uffff\32\54\3\uffff\1\54\101\uffff\27\54\1\uffff\37\54\1"+
            "\uffff\u1f08\54\u1040\uffff\u0150\54\u0170\uffff\u0080\54\u0080"+
            "\uffff\u092e\54\u10d2\uffff\u5200\54\u5900\uffff\u0200\54",
            "\1\u00cf",
            "\1\54\11\uffff\12\54\5\uffff\1\54\1\uffff\32\54\3\uffff\2\54"+
            "\1\uffff\32\54\3\uffff\1\54\101\uffff\27\54\1\uffff\37\54\1"+
            "\uffff\u1f08\54\u1040\uffff\u0150\54\u0170\uffff\u0080\54\u0080"+
            "\uffff\u092e\54\u10d2\uffff\u5200\54\u5900\uffff\u0200\54",
            "\1\u00d1",
            "\1\u00d2",
            "\1\54\11\uffff\12\54\5\uffff\1\54\1\uffff\32\54\3\uffff\2\54"+
            "\1\uffff\32\54\3\uffff\1\54\101\uffff\27\54\1\uffff\37\54\1"+
            "\uffff\u1f08\54\u1040\uffff\u0150\54\u0170\uffff\u0080\54\u0080"+
            "\uffff\u092e\54\u10d2\uffff\u5200\54\u5900\uffff\u0200\54",
            "\1\u00d4",
            "\1\54\11\uffff\12\54\5\uffff\1\54\1\uffff\32\54\3\uffff\2\54"+
            "\1\uffff\32\54\3\uffff\1\54\101\uffff\27\54\1\uffff\37\54\1"+
            "\uffff\u1f08\54\u1040\uffff\u0150\54\u0170\uffff\u0080\54\u0080"+
            "\uffff\u092e\54\u10d2\uffff\u5200\54\u5900\uffff\u0200\54",
            "\1\u00d6",
            "\1\u00d7",
            "\1\u00d8",
            "\1\54\11\uffff\12\54\5\uffff\1\54\1\uffff\32\54\3\uffff\2\54"+
            "\1\uffff\32\54\3\uffff\1\54\101\uffff\27\54\1\uffff\37\54\1"+
            "\uffff\u1f08\54\u1040\uffff\u0150\54\u0170\uffff\u0080\54\u0080"+
            "\uffff\u092e\54\u10d2\uffff\u5200\54\u5900\uffff\u0200\54",
            "\1\u00da",
            "",
            "\1\54\11\uffff\12\54\5\uffff\1\54\1\uffff\32\54\3\uffff\2\54"+
            "\1\uffff\32\54\3\uffff\1\54\101\uffff\27\54\1\uffff\37\54\1"+
            "\uffff\u1f08\54\u1040\uffff\u0150\54\u0170\uffff\u0080\54\u0080"+
            "\uffff\u092e\54\u10d2\uffff\u5200\54\u5900\uffff\u0200\54",
            "",
            "\1\u00dc",
            "\1\u00dd",
            "",
            "",
            "\1\54\11\uffff\12\54\5\uffff\1\54\1\uffff\32\54\3\uffff\2\54"+
            "\1\uffff\32\54\3\uffff\1\54\101\uffff\27\54\1\uffff\37\54\1"+
            "\uffff\u1f08\54\u1040\uffff\u0150\54\u0170\uffff\u0080\54\u0080"+
            "\uffff\u092e\54\u10d2\uffff\u5200\54\u5900\uffff\u0200\54",
            "",
            "\1\u00df",
            "\1\u00e0",
            "",
            "\1\54\11\uffff\12\54\5\uffff\1\54\1\uffff\32\54\3\uffff\2\54"+
            "\1\uffff\32\54\3\uffff\1\54\101\uffff\27\54\1\uffff\37\54\1"+
            "\uffff\u1f08\54\u1040\uffff\u0150\54\u0170\uffff\u0080\54\u0080"+
            "\uffff\u092e\54\u10d2\uffff\u5200\54\u5900\uffff\u0200\54",
            "",
            "\1\u00e2",
            "\1\u00e3",
            "\1\u00e4",
            "",
            "\1\u00e5",
            "",
            "\1\u00e6",
            "\1\u00e7",
            "",
            "\1\u00e8",
            "\1\54\11\uffff\12\54\5\uffff\1\54\1\uffff\32\54\3\uffff\2\54"+
            "\1\uffff\32\54\3\uffff\1\54\101\uffff\27\54\1\uffff\37\54\1"+
            "\uffff\u1f08\54\u1040\uffff\u0150\54\u0170\uffff\u0080\54\u0080"+
            "\uffff\u092e\54\u10d2\uffff\u5200\54\u5900\uffff\u0200\54",
            "",
            "\1\u00ea",
            "\1\54\11\uffff\12\54\5\uffff\1\54\1\uffff\32\54\3\uffff\2\54"+
            "\1\uffff\32\54\3\uffff\1\54\101\uffff\27\54\1\uffff\37\54\1"+
            "\uffff\u1f08\54\u1040\uffff\u0150\54\u0170\uffff\u0080\54\u0080"+
            "\uffff\u092e\54\u10d2\uffff\u5200\54\u5900\uffff\u0200\54",
            "\1\u00ec",
            "\1\54\11\uffff\12\54\5\uffff\1\54\1\uffff\32\54\3\uffff\2\54"+
            "\1\uffff\32\54\3\uffff\1\54\101\uffff\27\54\1\uffff\37\54\1"+
            "\uffff\u1f08\54\u1040\uffff\u0150\54\u0170\uffff\u0080\54\u0080"+
            "\uffff\u092e\54\u10d2\uffff\u5200\54\u5900\uffff\u0200\54",
            "\1\u00ee",
            "\1\54\11\uffff\12\54\5\uffff\1\54\1\uffff\32\54\3\uffff\2\54"+
            "\1\uffff\32\54\3\uffff\1\54\101\uffff\27\54\1\uffff\37\54\1"+
            "\uffff\u1f08\54\u1040\uffff\u0150\54\u0170\uffff\u0080\54\u0080"+
            "\uffff\u092e\54\u10d2\uffff\u5200\54\u5900\uffff\u0200\54",
            "\1\54\11\uffff\12\54\5\uffff\1\54\1\uffff\32\54\3\uffff\2\54"+
            "\1\uffff\32\54\3\uffff\1\54\101\uffff\27\54\1\uffff\37\54\1"+
            "\uffff\u1f08\54\u1040\uffff\u0150\54\u0170\uffff\u0080\54\u0080"+
            "\uffff\u092e\54\u10d2\uffff\u5200\54\u5900\uffff\u0200\54",
            "",
            "\1\u00f1",
            "",
            "\1\u00f2",
            "",
            "\1\u00f3",
            "",
            "",
            "\1\54\11\uffff\12\54\5\uffff\1\54\1\uffff\32\54\3\uffff\2\54"+
            "\1\uffff\32\54\3\uffff\1\54\101\uffff\27\54\1\uffff\37\54\1"+
            "\uffff\u1f08\54\u1040\uffff\u0150\54\u0170\uffff\u0080\54\u0080"+
            "\uffff\u092e\54\u10d2\uffff\u5200\54\u5900\uffff\u0200\54",
            "\1\54\11\uffff\12\54\5\uffff\1\54\1\uffff\32\54\3\uffff\2\54"+
            "\1\uffff\32\54\3\uffff\1\54\101\uffff\27\54\1\uffff\37\54\1"+
            "\uffff\u1f08\54\u1040\uffff\u0150\54\u0170\uffff\u0080\54\u0080"+
            "\uffff\u092e\54\u10d2\uffff\u5200\54\u5900\uffff\u0200\54",
            "\1\u00f6",
            "",
            "",
            "\1\54\11\uffff\12\54\5\uffff\1\54\1\uffff\32\54\3\uffff\2\54"+
            "\1\uffff\32\54\3\uffff\1\54\101\uffff\27\54\1\uffff\37\54\1"+
            "\uffff\u1f08\54\u1040\uffff\u0150\54\u0170\uffff\u0080\54\u0080"+
            "\uffff\u092e\54\u10d2\uffff\u5200\54\u5900\uffff\u0200\54",
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
            return "1:1: Tokens : ( T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | T__104 | T__105 | T__106 | T__107 | T__108 | T__109 | T__110 | T__111 | T__112 | T__113 | T__114 | T__115 | T__116 | T__117 | T__118 | T__119 | T__120 | T__121 | T__122 | T__123 | T__124 | T__125 | T__126 | T__127 | T__128 | T__129 | T__130 | T__131 | T__132 | T__133 | T__134 | T__135 | T__136 | T__137 | T__138 | T__139 | EolLexerRules. Tokens );";
        }
    }
 

}