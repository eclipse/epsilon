// $ANTLR 3.1b1 Migration__.g 2009-08-05 17:54:55

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
package org.eclipse.epsilon.migration.parse;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class MigrationLexer extends Lexer {
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
    public static final int T__71=71;
    public static final int WS=17;
    public static final int T__72=72;
    public static final int T__70=70;
    public static final int ALIAS=62;
    public static final int MIGRATE=64;
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
    public static final int T__65=65;
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
    public static final int MIGRATIONMODULE=63;
    public static final int OPERATOR=52;
    public static final int EXPRLIST=48;
    public static final int T__102=102;
    public static final int T__101=101;
    public static final int T__100=100;
    public static final int Tokens=123;
    public static final int POINT_POINT=8;
    public static final int BLOCK=55;
    public static final int FEATURECALL=56;
    public static final int FORMAL=21;
    public static final int ARROW=9;
    public static final int ASSIGNMENT=23;
    public static final int STRING=12;

    // delegates
    public Migration_EolLexerRules gEolLexerRules;
    // delegators

    public MigrationLexer() {;} 
    public MigrationLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public MigrationLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
        gEolLexerRules = new Migration_EolLexerRules(input, state, this);
    }
    public String getGrammarFileName() { return "Migration__.g"; }

    // $ANTLR start T__65
    public final void mT__65() throws RecognitionException {
        try {
            int _type = T__65;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Migration__.g:44:7: ( 'model' )
            // Migration__.g:44:9: 'model'
            {
            match("model"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__65

    // $ANTLR start T__66
    public final void mT__66() throws RecognitionException {
        try {
            int _type = T__66;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Migration__.g:45:7: ( ';' )
            // Migration__.g:45:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__66

    // $ANTLR start T__67
    public final void mT__67() throws RecognitionException {
        try {
            int _type = T__67;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Migration__.g:46:7: ( ':' )
            // Migration__.g:46:9: ':'
            {
            match(':'); 

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
            // Migration__.g:47:7: ( ',' )
            // Migration__.g:47:9: ','
            {
            match(','); 

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
            // Migration__.g:48:7: ( 'alias' )
            // Migration__.g:48:9: 'alias'
            {
            match("alias"); 


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
            // Migration__.g:49:7: ( 'operation' )
            // Migration__.g:49:9: 'operation'
            {
            match("operation"); 


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
            // Migration__.g:50:7: ( '(' )
            // Migration__.g:50:9: '('
            {
            match('('); 

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
            // Migration__.g:51:7: ( ')' )
            // Migration__.g:51:9: ')'
            {
            match(')'); 

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
            // Migration__.g:52:7: ( 'import' )
            // Migration__.g:52:9: 'import'
            {
            match("import"); 


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
            // Migration__.g:53:7: ( '{' )
            // Migration__.g:53:9: '{'
            {
            match('{'); 

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
            // Migration__.g:54:7: ( '}' )
            // Migration__.g:54:9: '}'
            {
            match('}'); 

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
            // Migration__.g:55:7: ( '$' )
            // Migration__.g:55:9: '$'
            {
            match('$'); 

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
            // Migration__.g:56:7: ( '!' )
            // Migration__.g:56:9: '!'
            {
            match('!'); 

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
            // Migration__.g:57:7: ( '::' )
            // Migration__.g:57:9: '::'
            {
            match("::"); 


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
            // Migration__.g:58:7: ( '#' )
            // Migration__.g:58:9: '#'
            {
            match('#'); 

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
            // Migration__.g:59:7: ( 'Native' )
            // Migration__.g:59:9: 'Native'
            {
            match("Native"); 


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
            // Migration__.g:60:7: ( 'Collection' )
            // Migration__.g:60:9: 'Collection'
            {
            match("Collection"); 


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
            // Migration__.g:61:7: ( 'Sequence' )
            // Migration__.g:61:9: 'Sequence'
            {
            match("Sequence"); 


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
            // Migration__.g:62:7: ( 'Bag' )
            // Migration__.g:62:9: 'Bag'
            {
            match("Bag"); 


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
            // Migration__.g:63:7: ( 'Set' )
            // Migration__.g:63:9: 'Set'
            {
            match("Set"); 


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
            // Migration__.g:64:7: ( 'OrderedSet' )
            // Migration__.g:64:9: 'OrderedSet'
            {
            match("OrderedSet"); 


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
            // Migration__.g:65:7: ( 'for' )
            // Migration__.g:65:9: 'for'
            {
            match("for"); 


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
            // Migration__.g:66:7: ( 'in' )
            // Migration__.g:66:9: 'in'
            {
            match("in"); 


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
            // Migration__.g:67:7: ( 'if' )
            // Migration__.g:67:9: 'if'
            {
            match("if"); 


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
            // Migration__.g:68:7: ( 'else' )
            // Migration__.g:68:9: 'else'
            {
            match("else"); 


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
            // Migration__.g:69:7: ( 'while' )
            // Migration__.g:69:9: 'while'
            {
            match("while"); 


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
            // Migration__.g:70:7: ( 'return' )
            // Migration__.g:70:9: 'return'
            {
            match("return"); 


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
            // Migration__.g:71:7: ( 'throw' )
            // Migration__.g:71:9: 'throw'
            {
            match("throw"); 


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
            // Migration__.g:72:7: ( 'delete' )
            // Migration__.g:72:9: 'delete'
            {
            match("delete"); 


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
            // Migration__.g:73:7: ( 'break' )
            // Migration__.g:73:9: 'break'
            {
            match("break"); 


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
            // Migration__.g:74:7: ( 'breakAll' )
            // Migration__.g:74:9: 'breakAll'
            {
            match("breakAll"); 


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
            // Migration__.g:75:7: ( 'continue' )
            // Migration__.g:75:9: 'continue'
            {
            match("continue"); 


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
            // Migration__.g:76:7: ( 'abort' )
            // Migration__.g:76:9: 'abort'
            {
            match("abort"); 


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
            // Migration__.g:77:7: ( 'transaction' )
            // Migration__.g:77:9: 'transaction'
            {
            match("transaction"); 


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
            // Migration__.g:78:7: ( ':=' )
            // Migration__.g:78:9: ':='
            {
            match(":="); 


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
            // Migration__.g:79:8: ( '::=' )
            // Migration__.g:79:10: '::='
            {
            match("::="); 


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
            // Migration__.g:80:8: ( 'or' )
            // Migration__.g:80:10: 'or'
            {
            match("or"); 


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
            // Migration__.g:81:8: ( 'and' )
            // Migration__.g:81:10: 'and'
            {
            match("and"); 


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
            // Migration__.g:82:8: ( 'xor' )
            // Migration__.g:82:10: 'xor'
            {
            match("xor"); 


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
            // Migration__.g:83:8: ( 'implies' )
            // Migration__.g:83:10: 'implies'
            {
            match("implies"); 


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
            // Migration__.g:84:8: ( '==' )
            // Migration__.g:84:10: '=='
            {
            match("=="); 


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
            // Migration__.g:85:8: ( '=' )
            // Migration__.g:85:10: '='
            {
            match('='); 

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
            // Migration__.g:86:8: ( '>' )
            // Migration__.g:86:10: '>'
            {
            match('>'); 

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
            // Migration__.g:87:8: ( '<' )
            // Migration__.g:87:10: '<'
            {
            match('<'); 

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
            // Migration__.g:88:8: ( '>=' )
            // Migration__.g:88:10: '>='
            {
            match(">="); 


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
            // Migration__.g:89:8: ( '<=' )
            // Migration__.g:89:10: '<='
            {
            match("<="); 


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
            // Migration__.g:90:8: ( '<>' )
            // Migration__.g:90:10: '<>'
            {
            match("<>"); 


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
            // Migration__.g:91:8: ( '+' )
            // Migration__.g:91:10: '+'
            {
            match('+'); 

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
            // Migration__.g:92:8: ( '-' )
            // Migration__.g:92:10: '-'
            {
            match('-'); 

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
            // Migration__.g:93:8: ( '*' )
            // Migration__.g:93:10: '*'
            {
            match('*'); 

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
            // Migration__.g:94:8: ( '/' )
            // Migration__.g:94:10: '/'
            {
            match('/'); 

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
            // Migration__.g:95:8: ( 'not' )
            // Migration__.g:95:10: 'not'
            {
            match("not"); 


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
            // Migration__.g:96:8: ( '|' )
            // Migration__.g:96:10: '|'
            {
            match('|'); 

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
            // Migration__.g:97:8: ( 'new' )
            // Migration__.g:97:10: 'new'
            {
            match("new"); 


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
            // Migration__.g:98:8: ( 'var' )
            // Migration__.g:98:10: 'var'
            {
            match("var"); 


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
            // Migration__.g:99:8: ( 'migrate' )
            // Migration__.g:99:10: 'migrate'
            {
            match("migrate"); 


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
            // Migration__.g:100:8: ( 'to' )
            // Migration__.g:100:10: 'to'
            {
            match("to"); 


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
            // Migration__.g:101:8: ( 'when' )
            // Migration__.g:101:10: 'when'
            {
            match("when"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__122

    public void mTokens() throws RecognitionException {
        // Migration__.g:1:8: ( T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | T__104 | T__105 | T__106 | T__107 | T__108 | T__109 | T__110 | T__111 | T__112 | T__113 | T__114 | T__115 | T__116 | T__117 | T__118 | T__119 | T__120 | T__121 | T__122 | EolLexerRules. Tokens )
        int alt1=59;
        alt1 = dfa1.predict(input);
        switch (alt1) {
            case 1 :
                // Migration__.g:1:10: T__65
                {
                mT__65(); 

                }
                break;
            case 2 :
                // Migration__.g:1:16: T__66
                {
                mT__66(); 

                }
                break;
            case 3 :
                // Migration__.g:1:22: T__67
                {
                mT__67(); 

                }
                break;
            case 4 :
                // Migration__.g:1:28: T__68
                {
                mT__68(); 

                }
                break;
            case 5 :
                // Migration__.g:1:34: T__69
                {
                mT__69(); 

                }
                break;
            case 6 :
                // Migration__.g:1:40: T__70
                {
                mT__70(); 

                }
                break;
            case 7 :
                // Migration__.g:1:46: T__71
                {
                mT__71(); 

                }
                break;
            case 8 :
                // Migration__.g:1:52: T__72
                {
                mT__72(); 

                }
                break;
            case 9 :
                // Migration__.g:1:58: T__73
                {
                mT__73(); 

                }
                break;
            case 10 :
                // Migration__.g:1:64: T__74
                {
                mT__74(); 

                }
                break;
            case 11 :
                // Migration__.g:1:70: T__75
                {
                mT__75(); 

                }
                break;
            case 12 :
                // Migration__.g:1:76: T__76
                {
                mT__76(); 

                }
                break;
            case 13 :
                // Migration__.g:1:82: T__77
                {
                mT__77(); 

                }
                break;
            case 14 :
                // Migration__.g:1:88: T__78
                {
                mT__78(); 

                }
                break;
            case 15 :
                // Migration__.g:1:94: T__79
                {
                mT__79(); 

                }
                break;
            case 16 :
                // Migration__.g:1:100: T__80
                {
                mT__80(); 

                }
                break;
            case 17 :
                // Migration__.g:1:106: T__81
                {
                mT__81(); 

                }
                break;
            case 18 :
                // Migration__.g:1:112: T__82
                {
                mT__82(); 

                }
                break;
            case 19 :
                // Migration__.g:1:118: T__83
                {
                mT__83(); 

                }
                break;
            case 20 :
                // Migration__.g:1:124: T__84
                {
                mT__84(); 

                }
                break;
            case 21 :
                // Migration__.g:1:130: T__85
                {
                mT__85(); 

                }
                break;
            case 22 :
                // Migration__.g:1:136: T__86
                {
                mT__86(); 

                }
                break;
            case 23 :
                // Migration__.g:1:142: T__87
                {
                mT__87(); 

                }
                break;
            case 24 :
                // Migration__.g:1:148: T__88
                {
                mT__88(); 

                }
                break;
            case 25 :
                // Migration__.g:1:154: T__89
                {
                mT__89(); 

                }
                break;
            case 26 :
                // Migration__.g:1:160: T__90
                {
                mT__90(); 

                }
                break;
            case 27 :
                // Migration__.g:1:166: T__91
                {
                mT__91(); 

                }
                break;
            case 28 :
                // Migration__.g:1:172: T__92
                {
                mT__92(); 

                }
                break;
            case 29 :
                // Migration__.g:1:178: T__93
                {
                mT__93(); 

                }
                break;
            case 30 :
                // Migration__.g:1:184: T__94
                {
                mT__94(); 

                }
                break;
            case 31 :
                // Migration__.g:1:190: T__95
                {
                mT__95(); 

                }
                break;
            case 32 :
                // Migration__.g:1:196: T__96
                {
                mT__96(); 

                }
                break;
            case 33 :
                // Migration__.g:1:202: T__97
                {
                mT__97(); 

                }
                break;
            case 34 :
                // Migration__.g:1:208: T__98
                {
                mT__98(); 

                }
                break;
            case 35 :
                // Migration__.g:1:214: T__99
                {
                mT__99(); 

                }
                break;
            case 36 :
                // Migration__.g:1:220: T__100
                {
                mT__100(); 

                }
                break;
            case 37 :
                // Migration__.g:1:227: T__101
                {
                mT__101(); 

                }
                break;
            case 38 :
                // Migration__.g:1:234: T__102
                {
                mT__102(); 

                }
                break;
            case 39 :
                // Migration__.g:1:241: T__103
                {
                mT__103(); 

                }
                break;
            case 40 :
                // Migration__.g:1:248: T__104
                {
                mT__104(); 

                }
                break;
            case 41 :
                // Migration__.g:1:255: T__105
                {
                mT__105(); 

                }
                break;
            case 42 :
                // Migration__.g:1:262: T__106
                {
                mT__106(); 

                }
                break;
            case 43 :
                // Migration__.g:1:269: T__107
                {
                mT__107(); 

                }
                break;
            case 44 :
                // Migration__.g:1:276: T__108
                {
                mT__108(); 

                }
                break;
            case 45 :
                // Migration__.g:1:283: T__109
                {
                mT__109(); 

                }
                break;
            case 46 :
                // Migration__.g:1:290: T__110
                {
                mT__110(); 

                }
                break;
            case 47 :
                // Migration__.g:1:297: T__111
                {
                mT__111(); 

                }
                break;
            case 48 :
                // Migration__.g:1:304: T__112
                {
                mT__112(); 

                }
                break;
            case 49 :
                // Migration__.g:1:311: T__113
                {
                mT__113(); 

                }
                break;
            case 50 :
                // Migration__.g:1:318: T__114
                {
                mT__114(); 

                }
                break;
            case 51 :
                // Migration__.g:1:325: T__115
                {
                mT__115(); 

                }
                break;
            case 52 :
                // Migration__.g:1:332: T__116
                {
                mT__116(); 

                }
                break;
            case 53 :
                // Migration__.g:1:339: T__117
                {
                mT__117(); 

                }
                break;
            case 54 :
                // Migration__.g:1:346: T__118
                {
                mT__118(); 

                }
                break;
            case 55 :
                // Migration__.g:1:353: T__119
                {
                mT__119(); 

                }
                break;
            case 56 :
                // Migration__.g:1:360: T__120
                {
                mT__120(); 

                }
                break;
            case 57 :
                // Migration__.g:1:367: T__121
                {
                mT__121(); 

                }
                break;
            case 58 :
                // Migration__.g:1:374: T__122
                {
                mT__122(); 

                }
                break;
            case 59 :
                // Migration__.g:1:381: EolLexerRules. Tokens
                {
                gEolLexerRules.mTokens(); 

                }
                break;

        }

    }


    protected DFA1 dfa1 = new DFA1(this);
    static final String DFA1_eotS =
        "\1\uffff\1\47\1\uffff\1\54\1\uffff\2\47\2\uffff\1\47\5\uffff\16"+
        "\47\1\106\1\110\1\113\1\uffff\1\114\2\uffff\1\47\1\uffff\1\47\1"+
        "\uffff\2\47\1\123\2\uffff\4\47\1\130\1\47\1\132\1\133\13\47\1\151"+
        "\4\47\10\uffff\5\47\2\uffff\2\47\1\165\1\47\1\uffff\1\47\2\uffff"+
        "\3\47\1\174\1\175\1\47\1\177\6\47\1\uffff\3\47\1\u0089\1\u008a\1"+
        "\u008b\1\u008c\4\47\1\uffff\6\47\2\uffff\1\47\1\uffff\1\u0098\1"+
        "\47\1\u009a\6\47\4\uffff\1\u00a1\1\47\1\u00a3\1\u00a4\7\47\1\uffff"+
        "\1\u00ac\1\uffff\1\47\1\u00ae\2\47\1\u00b2\1\47\1\uffff\1\47\2\uffff"+
        "\1\47\1\u00b6\1\47\1\u00b8\3\47\1\uffff\1\u00bc\1\uffff\1\47\1\u00be"+
        "\1\47\1\uffff\1\47\1\u00c1\1\47\1\uffff\1\u00c3\1\uffff\3\47\1\uffff"+
        "\1\47\1\uffff\2\47\1\uffff\1\47\1\uffff\1\47\1\u00cc\2\47\1\u00cf"+
        "\1\u00d0\1\u00d1\1\47\1\uffff\2\47\3\uffff\1\u00d5\1\u00d6\1\47"+
        "\2\uffff\1\u00d8\1\uffff";
    static final String DFA1_eofS =
        "\u00d9\uffff";
    static final String DFA1_minS =
        "\1\11\1\151\1\uffff\1\72\1\uffff\1\142\1\160\2\uffff\1\146\5\uffff"+
        "\1\141\1\157\1\145\1\141\1\162\1\157\1\154\1\150\1\145\1\150\1\145"+
        "\1\162\2\157\3\75\1\uffff\1\52\2\uffff\1\145\1\uffff\1\141\1\uffff"+
        "\1\144\1\147\1\75\2\uffff\1\151\1\157\1\144\1\145\1\60\1\160\2\60"+
        "\1\164\1\154\1\161\1\147\1\144\1\162\1\163\1\145\1\164\1\162\1\141"+
        "\1\60\1\154\1\145\1\156\1\162\10\uffff\1\164\1\167\1\162\1\145\1"+
        "\162\2\uffff\1\141\1\162\1\60\1\162\1\uffff\1\154\2\uffff\1\151"+
        "\1\154\1\165\2\60\1\145\1\60\1\145\1\154\1\156\1\165\1\157\1\156"+
        "\1\uffff\1\145\1\141\1\164\4\60\1\154\1\141\1\163\1\164\1\uffff"+
        "\1\141\1\162\1\151\1\166\2\145\2\uffff\1\162\1\uffff\1\60\1\145"+
        "\1\60\1\162\1\167\1\163\1\164\1\153\1\151\4\uffff\1\60\1\164\2\60"+
        "\2\164\2\145\1\143\1\156\1\145\1\uffff\1\60\1\uffff\1\156\1\60\1"+
        "\141\1\145\1\60\1\156\1\uffff\1\145\2\uffff\1\151\1\60\1\163\1\60"+
        "\1\164\1\143\1\144\1\uffff\1\60\1\uffff\1\143\1\60\1\154\1\uffff"+
        "\1\165\1\60\1\157\1\uffff\1\60\1\uffff\1\151\1\145\1\123\1\uffff"+
        "\1\164\1\uffff\1\154\1\145\1\uffff\1\156\1\uffff\1\157\1\60\1\145"+
        "\1\151\3\60\1\156\1\uffff\1\164\1\157\3\uffff\2\60\1\156\2\uffff"+
        "\1\60\1\uffff";
    static final String DFA1_maxS =
        "\1\ufaff\1\157\1\uffff\1\75\1\uffff\1\156\1\162\2\uffff\1\156\5"+
        "\uffff\1\141\1\157\1\145\1\141\1\162\1\157\1\154\1\150\1\145\1\162"+
        "\1\145\1\162\2\157\2\75\1\76\1\uffff\1\76\2\uffff\1\157\1\uffff"+
        "\1\141\1\uffff\1\144\1\147\1\75\2\uffff\1\151\1\157\1\144\1\145"+
        "\1\ufaff\1\160\2\ufaff\1\164\1\154\1\164\1\147\1\144\1\162\1\163"+
        "\1\151\1\164\1\162\1\141\1\ufaff\1\154\1\145\1\156\1\162\10\uffff"+
        "\1\164\1\167\1\162\1\145\1\162\2\uffff\1\141\1\162\1\ufaff\1\162"+
        "\1\uffff\1\157\2\uffff\1\151\1\154\1\165\2\ufaff\1\145\1\ufaff\1"+
        "\145\1\154\1\156\1\165\1\157\1\156\1\uffff\1\145\1\141\1\164\4\ufaff"+
        "\1\154\1\141\1\163\1\164\1\uffff\1\141\1\162\1\151\1\166\2\145\2"+
        "\uffff\1\162\1\uffff\1\ufaff\1\145\1\ufaff\1\162\1\167\1\163\1\164"+
        "\1\153\1\151\4\uffff\1\ufaff\1\164\2\ufaff\2\164\2\145\1\143\1\156"+
        "\1\145\1\uffff\1\ufaff\1\uffff\1\156\1\ufaff\1\141\1\145\1\ufaff"+
        "\1\156\1\uffff\1\145\2\uffff\1\151\1\ufaff\1\163\1\ufaff\1\164\1"+
        "\143\1\144\1\uffff\1\ufaff\1\uffff\1\143\1\ufaff\1\154\1\uffff\1"+
        "\165\1\ufaff\1\157\1\uffff\1\ufaff\1\uffff\1\151\1\145\1\123\1\uffff"+
        "\1\164\1\uffff\1\154\1\145\1\uffff\1\156\1\uffff\1\157\1\ufaff\1"+
        "\145\1\151\3\ufaff\1\156\1\uffff\1\164\1\157\3\uffff\2\ufaff\1\156"+
        "\2\uffff\1\ufaff\1\uffff";
    static final String DFA1_acceptS =
        "\2\uffff\1\2\1\uffff\1\4\2\uffff\1\7\1\10\1\uffff\1\12\1\13\1\14"+
        "\1\15\1\17\21\uffff\1\60\1\uffff\1\62\1\63\1\uffff\1\65\1\uffff"+
        "\1\73\3\uffff\1\43\1\3\30\uffff\1\51\1\52\1\55\1\53\1\56\1\57\1"+
        "\54\1\61\5\uffff\1\44\1\16\4\uffff\1\45\1\uffff\1\27\1\30\15\uffff"+
        "\1\71\13\uffff\1\46\6\uffff\1\24\1\23\1\uffff\1\26\11\uffff\1\47"+
        "\1\64\1\66\1\67\13\uffff\1\31\1\uffff\1\72\6\uffff\1\1\1\uffff\1"+
        "\5\1\41\7\uffff\1\32\1\uffff\1\34\3\uffff\1\36\3\uffff\1\11\1\uffff"+
        "\1\20\3\uffff\1\33\1\uffff\1\35\2\uffff\1\70\1\uffff\1\50\10\uffff"+
        "\1\22\2\uffff\1\37\1\40\1\6\3\uffff\1\21\1\25\1\uffff\1\42";
    static final String DFA1_specialS =
        "\u00d9\uffff}>";
    static final String[] DFA1_transitionS = {
            "\2\47\1\uffff\2\47\22\uffff\1\47\1\15\1\47\1\16\1\14\2\uffff"+
            "\1\47\1\7\1\10\1\42\1\40\1\4\1\41\1\47\1\43\12\47\1\3\1\2\1"+
            "\37\1\35\1\36\1\uffff\2\47\1\22\1\20\12\47\1\17\1\23\3\47\1"+
            "\21\7\47\4\uffff\1\47\1\uffff\1\5\1\32\1\33\1\31\1\25\1\24\2"+
            "\47\1\11\3\47\1\1\1\44\1\6\2\47\1\27\1\47\1\30\1\47\1\46\1\26"+
            "\1\34\2\47\1\12\1\45\1\13\1\47\101\uffff\27\47\1\uffff\37\47"+
            "\1\uffff\u1f08\47\u1040\uffff\u0150\47\u0170\uffff\u0080\47"+
            "\u0080\uffff\u092e\47\u10d2\uffff\u5200\47\u5900\uffff\u0200"+
            "\47",
            "\1\51\5\uffff\1\50",
            "",
            "\1\52\2\uffff\1\53",
            "",
            "\1\56\11\uffff\1\55\1\uffff\1\57",
            "\1\60\1\uffff\1\61",
            "",
            "",
            "\1\64\6\uffff\1\62\1\63",
            "",
            "",
            "",
            "",
            "",
            "\1\65",
            "\1\66",
            "\1\67",
            "\1\70",
            "\1\71",
            "\1\72",
            "\1\73",
            "\1\74",
            "\1\75",
            "\1\76\6\uffff\1\100\2\uffff\1\77",
            "\1\101",
            "\1\102",
            "\1\103",
            "\1\104",
            "\1\105",
            "\1\107",
            "\1\111\1\112",
            "",
            "\1\47\2\uffff\1\47\20\uffff\1\47",
            "",
            "",
            "\1\116\11\uffff\1\115",
            "",
            "\1\117",
            "",
            "\1\120",
            "\1\121",
            "\1\122",
            "",
            "",
            "\1\124",
            "\1\125",
            "\1\126",
            "\1\127",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47\105\uffff\27"+
            "\47\1\uffff\37\47\1\uffff\u1f08\47\u1040\uffff\u0150\47\u0170"+
            "\uffff\u0080\47\u0080\uffff\u092e\47\u10d2\uffff\u5200\47\u5900"+
            "\uffff\u0200\47",
            "\1\131",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47\105\uffff\27"+
            "\47\1\uffff\37\47\1\uffff\u1f08\47\u1040\uffff\u0150\47\u0170"+
            "\uffff\u0080\47\u0080\uffff\u092e\47\u10d2\uffff\u5200\47\u5900"+
            "\uffff\u0200\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47\105\uffff\27"+
            "\47\1\uffff\37\47\1\uffff\u1f08\47\u1040\uffff\u0150\47\u0170"+
            "\uffff\u0080\47\u0080\uffff\u092e\47\u10d2\uffff\u5200\47\u5900"+
            "\uffff\u0200\47",
            "\1\134",
            "\1\135",
            "\1\136\2\uffff\1\137",
            "\1\140",
            "\1\141",
            "\1\142",
            "\1\143",
            "\1\145\3\uffff\1\144",
            "\1\146",
            "\1\147",
            "\1\150",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47\105\uffff\27"+
            "\47\1\uffff\37\47\1\uffff\u1f08\47\u1040\uffff\u0150\47\u0170"+
            "\uffff\u0080\47\u0080\uffff\u092e\47\u10d2\uffff\u5200\47\u5900"+
            "\uffff\u0200\47",
            "\1\152",
            "\1\153",
            "\1\154",
            "\1\155",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\156",
            "\1\157",
            "\1\160",
            "\1\161",
            "\1\162",
            "",
            "",
            "\1\163",
            "\1\164",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47\105\uffff\27"+
            "\47\1\uffff\37\47\1\uffff\u1f08\47\u1040\uffff\u0150\47\u0170"+
            "\uffff\u0080\47\u0080\uffff\u092e\47\u10d2\uffff\u5200\47\u5900"+
            "\uffff\u0200\47",
            "\1\166",
            "",
            "\1\170\2\uffff\1\167",
            "",
            "",
            "\1\171",
            "\1\172",
            "\1\173",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47\105\uffff\27"+
            "\47\1\uffff\37\47\1\uffff\u1f08\47\u1040\uffff\u0150\47\u0170"+
            "\uffff\u0080\47\u0080\uffff\u092e\47\u10d2\uffff\u5200\47\u5900"+
            "\uffff\u0200\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47\105\uffff\27"+
            "\47\1\uffff\37\47\1\uffff\u1f08\47\u1040\uffff\u0150\47\u0170"+
            "\uffff\u0080\47\u0080\uffff\u092e\47\u10d2\uffff\u5200\47\u5900"+
            "\uffff\u0200\47",
            "\1\176",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47\105\uffff\27"+
            "\47\1\uffff\37\47\1\uffff\u1f08\47\u1040\uffff\u0150\47\u0170"+
            "\uffff\u0080\47\u0080\uffff\u092e\47\u10d2\uffff\u5200\47\u5900"+
            "\uffff\u0200\47",
            "\1\u0080",
            "\1\u0081",
            "\1\u0082",
            "\1\u0083",
            "\1\u0084",
            "\1\u0085",
            "",
            "\1\u0086",
            "\1\u0087",
            "\1\u0088",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47\105\uffff\27"+
            "\47\1\uffff\37\47\1\uffff\u1f08\47\u1040\uffff\u0150\47\u0170"+
            "\uffff\u0080\47\u0080\uffff\u092e\47\u10d2\uffff\u5200\47\u5900"+
            "\uffff\u0200\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47\105\uffff\27"+
            "\47\1\uffff\37\47\1\uffff\u1f08\47\u1040\uffff\u0150\47\u0170"+
            "\uffff\u0080\47\u0080\uffff\u092e\47\u10d2\uffff\u5200\47\u5900"+
            "\uffff\u0200\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47\105\uffff\27"+
            "\47\1\uffff\37\47\1\uffff\u1f08\47\u1040\uffff\u0150\47\u0170"+
            "\uffff\u0080\47\u0080\uffff\u092e\47\u10d2\uffff\u5200\47\u5900"+
            "\uffff\u0200\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47\105\uffff\27"+
            "\47\1\uffff\37\47\1\uffff\u1f08\47\u1040\uffff\u0150\47\u0170"+
            "\uffff\u0080\47\u0080\uffff\u092e\47\u10d2\uffff\u5200\47\u5900"+
            "\uffff\u0200\47",
            "\1\u008d",
            "\1\u008e",
            "\1\u008f",
            "\1\u0090",
            "",
            "\1\u0091",
            "\1\u0092",
            "\1\u0093",
            "\1\u0094",
            "\1\u0095",
            "\1\u0096",
            "",
            "",
            "\1\u0097",
            "",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47\105\uffff\27"+
            "\47\1\uffff\37\47\1\uffff\u1f08\47\u1040\uffff\u0150\47\u0170"+
            "\uffff\u0080\47\u0080\uffff\u092e\47\u10d2\uffff\u5200\47\u5900"+
            "\uffff\u0200\47",
            "\1\u0099",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47\105\uffff\27"+
            "\47\1\uffff\37\47\1\uffff\u1f08\47\u1040\uffff\u0150\47\u0170"+
            "\uffff\u0080\47\u0080\uffff\u092e\47\u10d2\uffff\u5200\47\u5900"+
            "\uffff\u0200\47",
            "\1\u009b",
            "\1\u009c",
            "\1\u009d",
            "\1\u009e",
            "\1\u009f",
            "\1\u00a0",
            "",
            "",
            "",
            "",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47\105\uffff\27"+
            "\47\1\uffff\37\47\1\uffff\u1f08\47\u1040\uffff\u0150\47\u0170"+
            "\uffff\u0080\47\u0080\uffff\u092e\47\u10d2\uffff\u5200\47\u5900"+
            "\uffff\u0200\47",
            "\1\u00a2",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47\105\uffff\27"+
            "\47\1\uffff\37\47\1\uffff\u1f08\47\u1040\uffff\u0150\47\u0170"+
            "\uffff\u0080\47\u0080\uffff\u092e\47\u10d2\uffff\u5200\47\u5900"+
            "\uffff\u0200\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47\105\uffff\27"+
            "\47\1\uffff\37\47\1\uffff\u1f08\47\u1040\uffff\u0150\47\u0170"+
            "\uffff\u0080\47\u0080\uffff\u092e\47\u10d2\uffff\u5200\47\u5900"+
            "\uffff\u0200\47",
            "\1\u00a5",
            "\1\u00a6",
            "\1\u00a7",
            "\1\u00a8",
            "\1\u00a9",
            "\1\u00aa",
            "\1\u00ab",
            "",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47\105\uffff\27"+
            "\47\1\uffff\37\47\1\uffff\u1f08\47\u1040\uffff\u0150\47\u0170"+
            "\uffff\u0080\47\u0080\uffff\u092e\47\u10d2\uffff\u5200\47\u5900"+
            "\uffff\u0200\47",
            "",
            "\1\u00ad",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47\105\uffff\27"+
            "\47\1\uffff\37\47\1\uffff\u1f08\47\u1040\uffff\u0150\47\u0170"+
            "\uffff\u0080\47\u0080\uffff\u092e\47\u10d2\uffff\u5200\47\u5900"+
            "\uffff\u0200\47",
            "\1\u00af",
            "\1\u00b0",
            "\12\47\7\uffff\1\u00b1\31\47\4\uffff\1\47\1\uffff\32\47\105"+
            "\uffff\27\47\1\uffff\37\47\1\uffff\u1f08\47\u1040\uffff\u0150"+
            "\47\u0170\uffff\u0080\47\u0080\uffff\u092e\47\u10d2\uffff\u5200"+
            "\47\u5900\uffff\u0200\47",
            "\1\u00b3",
            "",
            "\1\u00b4",
            "",
            "",
            "\1\u00b5",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47\105\uffff\27"+
            "\47\1\uffff\37\47\1\uffff\u1f08\47\u1040\uffff\u0150\47\u0170"+
            "\uffff\u0080\47\u0080\uffff\u092e\47\u10d2\uffff\u5200\47\u5900"+
            "\uffff\u0200\47",
            "\1\u00b7",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47\105\uffff\27"+
            "\47\1\uffff\37\47\1\uffff\u1f08\47\u1040\uffff\u0150\47\u0170"+
            "\uffff\u0080\47\u0080\uffff\u092e\47\u10d2\uffff\u5200\47\u5900"+
            "\uffff\u0200\47",
            "\1\u00b9",
            "\1\u00ba",
            "\1\u00bb",
            "",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47\105\uffff\27"+
            "\47\1\uffff\37\47\1\uffff\u1f08\47\u1040\uffff\u0150\47\u0170"+
            "\uffff\u0080\47\u0080\uffff\u092e\47\u10d2\uffff\u5200\47\u5900"+
            "\uffff\u0200\47",
            "",
            "\1\u00bd",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47\105\uffff\27"+
            "\47\1\uffff\37\47\1\uffff\u1f08\47\u1040\uffff\u0150\47\u0170"+
            "\uffff\u0080\47\u0080\uffff\u092e\47\u10d2\uffff\u5200\47\u5900"+
            "\uffff\u0200\47",
            "\1\u00bf",
            "",
            "\1\u00c0",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47\105\uffff\27"+
            "\47\1\uffff\37\47\1\uffff\u1f08\47\u1040\uffff\u0150\47\u0170"+
            "\uffff\u0080\47\u0080\uffff\u092e\47\u10d2\uffff\u5200\47\u5900"+
            "\uffff\u0200\47",
            "\1\u00c2",
            "",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47\105\uffff\27"+
            "\47\1\uffff\37\47\1\uffff\u1f08\47\u1040\uffff\u0150\47\u0170"+
            "\uffff\u0080\47\u0080\uffff\u092e\47\u10d2\uffff\u5200\47\u5900"+
            "\uffff\u0200\47",
            "",
            "\1\u00c4",
            "\1\u00c5",
            "\1\u00c6",
            "",
            "\1\u00c7",
            "",
            "\1\u00c8",
            "\1\u00c9",
            "",
            "\1\u00ca",
            "",
            "\1\u00cb",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47\105\uffff\27"+
            "\47\1\uffff\37\47\1\uffff\u1f08\47\u1040\uffff\u0150\47\u0170"+
            "\uffff\u0080\47\u0080\uffff\u092e\47\u10d2\uffff\u5200\47\u5900"+
            "\uffff\u0200\47",
            "\1\u00cd",
            "\1\u00ce",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47\105\uffff\27"+
            "\47\1\uffff\37\47\1\uffff\u1f08\47\u1040\uffff\u0150\47\u0170"+
            "\uffff\u0080\47\u0080\uffff\u092e\47\u10d2\uffff\u5200\47\u5900"+
            "\uffff\u0200\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47\105\uffff\27"+
            "\47\1\uffff\37\47\1\uffff\u1f08\47\u1040\uffff\u0150\47\u0170"+
            "\uffff\u0080\47\u0080\uffff\u092e\47\u10d2\uffff\u5200\47\u5900"+
            "\uffff\u0200\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47\105\uffff\27"+
            "\47\1\uffff\37\47\1\uffff\u1f08\47\u1040\uffff\u0150\47\u0170"+
            "\uffff\u0080\47\u0080\uffff\u092e\47\u10d2\uffff\u5200\47\u5900"+
            "\uffff\u0200\47",
            "\1\u00d2",
            "",
            "\1\u00d3",
            "\1\u00d4",
            "",
            "",
            "",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47\105\uffff\27"+
            "\47\1\uffff\37\47\1\uffff\u1f08\47\u1040\uffff\u0150\47\u0170"+
            "\uffff\u0080\47\u0080\uffff\u092e\47\u10d2\uffff\u5200\47\u5900"+
            "\uffff\u0200\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47\105\uffff\27"+
            "\47\1\uffff\37\47\1\uffff\u1f08\47\u1040\uffff\u0150\47\u0170"+
            "\uffff\u0080\47\u0080\uffff\u092e\47\u10d2\uffff\u5200\47\u5900"+
            "\uffff\u0200\47",
            "\1\u00d7",
            "",
            "",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47\105\uffff\27"+
            "\47\1\uffff\37\47\1\uffff\u1f08\47\u1040\uffff\u0150\47\u0170"+
            "\uffff\u0080\47\u0080\uffff\u092e\47\u10d2\uffff\u5200\47\u5900"+
            "\uffff\u0200\47",
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
            return "1:1: Tokens : ( T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | T__104 | T__105 | T__106 | T__107 | T__108 | T__109 | T__110 | T__111 | T__112 | T__113 | T__114 | T__115 | T__116 | T__117 | T__118 | T__119 | T__120 | T__121 | T__122 | EolLexerRules. Tokens );";
        }
    }
 

}