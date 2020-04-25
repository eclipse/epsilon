// $ANTLR 3.1b1 Egx__.g 2020-04-25 02:28:00

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
package org.eclipse.epsilon.egl.parse;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class EgxLexer extends Lexer {
    public static final int T__144=144;
    public static final int T__143=143;
    public static final int T__146=146;
    public static final int MODELDECLARATIONPARAMETER=74;
    public static final int T__145=145;
    public static final int BREAKALL=40;
    public static final int T__140=140;
    public static final int T__142=142;
    public static final int VAR=49;
    public static final int MODELDECLARATIONPARAMETERS=73;
    public static final int T__141=141;
    public static final int THROW=54;
    public static final int EGXMODULE=89;
    public static final int PARAMLIST=25;
    public static final int EXPRLIST=55;
    public static final int EXPRRANGE=56;
    public static final int BREAK=39;
    public static final int ELSE=32;
    public static final int T__137=137;
    public static final int T__136=136;
    public static final int FORMAL=24;
    public static final int IF=31;
    public static final int MultiplicativeExpression=58;
    public static final int TYPE=66;
    public static final int T__139=139;
    public static final int T__138=138;
    public static final int Tokens=178;
    public static final int T__133=133;
    public static final int T__132=132;
    public static final int T__135=135;
    public static final int T__134=134;
    public static final int T__131=131;
    public static final int NewExpression=48;
    public static final int T__130=130;
    public static final int CASE=36;
    public static final int Letter=16;
    public static final int LINE_COMMENT=22;
    public static final int T__129=129;
    public static final int T__126=126;
    public static final int JavaIDDigit=18;
    public static final int T__125=125;
    public static final int LAMBDAEXPR=65;
    public static final int MAP=76;
    public static final int T__128=128;
    public static final int T__127=127;
    public static final int T__166=166;
    public static final int T__165=165;
    public static final int T__168=168;
    public static final int DOMAIN=86;
    public static final int T__167=167;
    public static final int T__162=162;
    public static final int T__161=161;
    public static final int MERGE=88;
    public static final int T__164=164;
    public static final int MODELDECLARATION=69;
    public static final int T__163=163;
    public static final int EXPRESSIONINBRACKETS=60;
    public static final int T__160=160;
    public static final int TERNARY=33;
    public static final int TRANSACTION=42;
    public static final int FLOAT_TYPE_SUFFIX=7;
    public static final int ITEMSELECTOR=75;
    public static final int COMMENT=21;
    public static final int ModelElementType=46;
    public static final int IMPORT=68;
    public static final int DELETE=53;
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
    public static final int CONTINUE=41;
    public static final int ENUMERATION_VALUE=67;
    public static final int OPERATOR=59;
    public static final int EXPONENT=6;
    public static final int STRING=14;
    public static final int T__148=148;
    public static final int T__147=147;
    public static final int T__149=149;
    public static final int T__91=91;
    public static final int T__100=100;
    public static final int NAMESPACE=70;
    public static final int TARGET=84;
    public static final int T__92=92;
    public static final int COLLECTION=43;
    public static final int NEW=50;
    public static final int EXTENDS=81;
    public static final int T__93=93;
    public static final int T__102=102;
    public static final int PRE=79;
    public static final int T__94=94;
    public static final int T__101=101;
    public static final int POST=80;
    public static final int T__90=90;
    public static final int ALIAS=71;
    public static final int DRIVER=72;
    public static final int KEYVAL=77;
    public static final int POINT_POINT=10;
    public static final int GUARD=82;
    public static final int T__99=99;
    public static final int TEMPLATE=85;
    public static final int T__95=95;
    public static final int HELPERMETHOD=28;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int StatementBlock=29;
    public static final int T__98=98;
    public static final int T__177=177;
    public static final int T__176=176;
    public static final int ABORT=44;
    public static final int T__173=173;
    public static final int StrangeNameLiteral=15;
    public static final int T__172=172;
    public static final int T__175=175;
    public static final int T__174=174;
    public static final int FOR=30;
    public static final int BLOCK=63;
    public static final int T__171=171;
    public static final int T__170=170;
    public static final int PARAMETERS=47;
    public static final int SpecialNameChar=17;
    public static final int BOOLEAN=12;
    public static final int NAME=19;
    public static final int SWITCH=35;
    public static final int T__169=169;
    public static final int FeatureCall=61;
    public static final int T__122=122;
    public static final int T__121=121;
    public static final int T__124=124;
    public static final int FLOAT=4;
    public static final int T__123=123;
    public static final int OVERWRITE=87;
    public static final int T__120=120;
    public static final int NativeType=57;
    public static final int INT=8;
    public static final int ANNOTATIONBLOCK=51;
    public static final int RETURN=38;
    public static final int KEYVALLIST=78;
    public static final int FEATURECALL=64;
    public static final int CollectionType=45;
    public static final int T__119=119;
    public static final int ASSIGNMENT=26;
    public static final int T__118=118;
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
    public static final int EOLMODULE=62;
    public static final int DIGIT=5;
    public static final int EXECUTABLEANNOTATION=52;
    public static final int T__108=108;
    public static final int T__107=107;
    public static final int WHILE=34;
    public static final int T__109=109;
    public static final int GENERATE=83;
    public static final int T__104=104;
    public static final int POINT=9;
    public static final int T__103=103;
    public static final int T__106=106;
    public static final int DEFAULT=37;
    public static final int T__105=105;

    // delegates
    public Egx_EolLexerRules gEolLexerRules;
    // delegators

    public EgxLexer() {;} 
    public EgxLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public EgxLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
        gEolLexerRules = new Egx_EolLexerRules(input, state, this);
    }
    public String getGrammarFileName() { return "Egx__.g"; }

    // $ANTLR start T__90
    public final void mT__90() throws RecognitionException {
        try {
            int _type = T__90;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Egx__.g:44:7: ( 'model' )
            // Egx__.g:44:9: 'model'
            {
            match("model"); 


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
            // Egx__.g:45:7: ( ';' )
            // Egx__.g:45:9: ';'
            {
            match(';'); 

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
            // Egx__.g:46:7: ( 'alias' )
            // Egx__.g:46:9: 'alias'
            {
            match("alias"); 


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
            // Egx__.g:47:7: ( ',' )
            // Egx__.g:47:9: ','
            {
            match(','); 

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
            // Egx__.g:48:7: ( 'driver' )
            // Egx__.g:48:9: 'driver'
            {
            match("driver"); 


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
            // Egx__.g:49:7: ( '{' )
            // Egx__.g:49:9: '{'
            {
            match('{'); 

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
            // Egx__.g:50:7: ( '}' )
            // Egx__.g:50:9: '}'
            {
            match('}'); 

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
            // Egx__.g:51:7: ( '=' )
            // Egx__.g:51:9: '='
            {
            match('='); 

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
            // Egx__.g:52:7: ( 'operation' )
            // Egx__.g:52:9: 'operation'
            {
            match("operation"); 


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
            // Egx__.g:53:7: ( 'function' )
            // Egx__.g:53:9: 'function'
            {
            match("function"); 


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
            // Egx__.g:54:8: ( '(' )
            // Egx__.g:54:10: '('
            {
            match('('); 

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
            // Egx__.g:55:8: ( ')' )
            // Egx__.g:55:10: ')'
            {
            match(')'); 

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
            // Egx__.g:56:8: ( ':' )
            // Egx__.g:56:10: ':'
            {
            match(':'); 

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
            // Egx__.g:57:8: ( 'import' )
            // Egx__.g:57:10: 'import'
            {
            match("import"); 


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
            // Egx__.g:58:8: ( '$' )
            // Egx__.g:58:10: '$'
            {
            match('$'); 

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
            // Egx__.g:59:8: ( '!' )
            // Egx__.g:59:10: '!'
            {
            match('!'); 

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
            // Egx__.g:60:8: ( '#' )
            // Egx__.g:60:10: '#'
            {
            match('#'); 

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
            // Egx__.g:61:8: ( '::' )
            // Egx__.g:61:10: '::'
            {
            match("::"); 


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
            // Egx__.g:62:8: ( 'Native' )
            // Egx__.g:62:10: 'Native'
            {
            match("Native"); 


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
            // Egx__.g:63:8: ( 'Collection' )
            // Egx__.g:63:10: 'Collection'
            {
            match("Collection"); 


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
            // Egx__.g:64:8: ( 'Sequence' )
            // Egx__.g:64:10: 'Sequence'
            {
            match("Sequence"); 


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
            // Egx__.g:65:8: ( 'List' )
            // Egx__.g:65:10: 'List'
            {
            match("List"); 


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
            // Egx__.g:66:8: ( 'Bag' )
            // Egx__.g:66:10: 'Bag'
            {
            match("Bag"); 


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
            // Egx__.g:67:8: ( 'Set' )
            // Egx__.g:67:10: 'Set'
            {
            match("Set"); 


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
            // Egx__.g:68:8: ( 'OrderedSet' )
            // Egx__.g:68:10: 'OrderedSet'
            {
            match("OrderedSet"); 


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
            // Egx__.g:69:8: ( 'Map' )
            // Egx__.g:69:10: 'Map'
            {
            match("Map"); 


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
            // Egx__.g:70:8: ( 'ConcurrentMap' )
            // Egx__.g:70:10: 'ConcurrentMap'
            {
            match("ConcurrentMap"); 


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
            // Egx__.g:71:8: ( 'ConcurrentBag' )
            // Egx__.g:71:10: 'ConcurrentBag'
            {
            match("ConcurrentBag"); 


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
            // Egx__.g:72:8: ( 'ConcurrentSet' )
            // Egx__.g:72:10: 'ConcurrentSet'
            {
            match("ConcurrentSet"); 


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
            // Egx__.g:73:8: ( '<' )
            // Egx__.g:73:10: '<'
            {
            match('<'); 

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
            // Egx__.g:74:8: ( '>' )
            // Egx__.g:74:10: '>'
            {
            match('>'); 

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
            // Egx__.g:75:8: ( 'if' )
            // Egx__.g:75:10: 'if'
            {
            match("if"); 


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
            // Egx__.g:76:8: ( 'else' )
            // Egx__.g:76:10: 'else'
            {
            match("else"); 


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
            // Egx__.g:77:8: ( 'switch' )
            // Egx__.g:77:10: 'switch'
            {
            match("switch"); 


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
            // Egx__.g:78:8: ( 'case' )
            // Egx__.g:78:10: 'case'
            {
            match("case"); 


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
            // Egx__.g:79:8: ( 'default' )
            // Egx__.g:79:10: 'default'
            {
            match("default"); 


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
            // Egx__.g:80:8: ( 'for' )
            // Egx__.g:80:10: 'for'
            {
            match("for"); 


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
            // Egx__.g:81:8: ( 'in' )
            // Egx__.g:81:10: 'in'
            {
            match("in"); 


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
            // Egx__.g:82:8: ( 'while' )
            // Egx__.g:82:10: 'while'
            {
            match("while"); 


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
            // Egx__.g:83:8: ( 'return' )
            // Egx__.g:83:10: 'return'
            {
            match("return"); 


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
            // Egx__.g:84:8: ( 'throw' )
            // Egx__.g:84:10: 'throw'
            {
            match("throw"); 


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
            // Egx__.g:85:8: ( 'delete' )
            // Egx__.g:85:10: 'delete'
            {
            match("delete"); 


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
            // Egx__.g:86:8: ( 'break' )
            // Egx__.g:86:10: 'break'
            {
            match("break"); 


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
            // Egx__.g:87:8: ( 'breakAll' )
            // Egx__.g:87:10: 'breakAll'
            {
            match("breakAll"); 


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
            // Egx__.g:88:8: ( 'continue' )
            // Egx__.g:88:10: 'continue'
            {
            match("continue"); 


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
            // Egx__.g:89:8: ( 'abort' )
            // Egx__.g:89:10: 'abort'
            {
            match("abort"); 


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
            // Egx__.g:90:8: ( 'transaction' )
            // Egx__.g:90:10: 'transaction'
            {
            match("transaction"); 


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
            // Egx__.g:91:8: ( ':=' )
            // Egx__.g:91:10: ':='
            {
            match(":="); 


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
            // Egx__.g:92:8: ( '+=' )
            // Egx__.g:92:10: '+='
            {
            match("+="); 


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
            // Egx__.g:93:8: ( '-=' )
            // Egx__.g:93:10: '-='
            {
            match("-="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__139

    // $ANTLR start T__140
    public final void mT__140() throws RecognitionException {
        try {
            int _type = T__140;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Egx__.g:94:8: ( '*=' )
            // Egx__.g:94:10: '*='
            {
            match("*="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__140

    // $ANTLR start T__141
    public final void mT__141() throws RecognitionException {
        try {
            int _type = T__141;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Egx__.g:95:8: ( '/=' )
            // Egx__.g:95:10: '/='
            {
            match("/="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__141

    // $ANTLR start T__142
    public final void mT__142() throws RecognitionException {
        try {
            int _type = T__142;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Egx__.g:96:8: ( '::=' )
            // Egx__.g:96:10: '::='
            {
            match("::="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__142

    // $ANTLR start T__143
    public final void mT__143() throws RecognitionException {
        try {
            int _type = T__143;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Egx__.g:97:8: ( 'or' )
            // Egx__.g:97:10: 'or'
            {
            match("or"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__143

    // $ANTLR start T__144
    public final void mT__144() throws RecognitionException {
        try {
            int _type = T__144;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Egx__.g:98:8: ( 'and' )
            // Egx__.g:98:10: 'and'
            {
            match("and"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__144

    // $ANTLR start T__145
    public final void mT__145() throws RecognitionException {
        try {
            int _type = T__145;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Egx__.g:99:8: ( 'xor' )
            // Egx__.g:99:10: 'xor'
            {
            match("xor"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__145

    // $ANTLR start T__146
    public final void mT__146() throws RecognitionException {
        try {
            int _type = T__146;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Egx__.g:100:8: ( 'implies' )
            // Egx__.g:100:10: 'implies'
            {
            match("implies"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__146

    // $ANTLR start T__147
    public final void mT__147() throws RecognitionException {
        try {
            int _type = T__147;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Egx__.g:101:8: ( '?' )
            // Egx__.g:101:10: '?'
            {
            match('?'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__147

    // $ANTLR start T__148
    public final void mT__148() throws RecognitionException {
        try {
            int _type = T__148;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Egx__.g:102:8: ( '==' )
            // Egx__.g:102:10: '=='
            {
            match("=="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__148

    // $ANTLR start T__149
    public final void mT__149() throws RecognitionException {
        try {
            int _type = T__149;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Egx__.g:103:8: ( '>=' )
            // Egx__.g:103:10: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__149

    // $ANTLR start T__150
    public final void mT__150() throws RecognitionException {
        try {
            int _type = T__150;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Egx__.g:104:8: ( '<=' )
            // Egx__.g:104:10: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__150

    // $ANTLR start T__151
    public final void mT__151() throws RecognitionException {
        try {
            int _type = T__151;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Egx__.g:105:8: ( '<>' )
            // Egx__.g:105:10: '<>'
            {
            match("<>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__151

    // $ANTLR start T__152
    public final void mT__152() throws RecognitionException {
        try {
            int _type = T__152;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Egx__.g:106:8: ( '+' )
            // Egx__.g:106:10: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__152

    // $ANTLR start T__153
    public final void mT__153() throws RecognitionException {
        try {
            int _type = T__153;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Egx__.g:107:8: ( '-' )
            // Egx__.g:107:10: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__153

    // $ANTLR start T__154
    public final void mT__154() throws RecognitionException {
        try {
            int _type = T__154;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Egx__.g:108:8: ( '*' )
            // Egx__.g:108:10: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__154

    // $ANTLR start T__155
    public final void mT__155() throws RecognitionException {
        try {
            int _type = T__155;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Egx__.g:109:8: ( '/' )
            // Egx__.g:109:10: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__155

    // $ANTLR start T__156
    public final void mT__156() throws RecognitionException {
        try {
            int _type = T__156;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Egx__.g:110:8: ( 'not' )
            // Egx__.g:110:10: 'not'
            {
            match("not"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__156

    // $ANTLR start T__157
    public final void mT__157() throws RecognitionException {
        try {
            int _type = T__157;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Egx__.g:111:8: ( '++' )
            // Egx__.g:111:10: '++'
            {
            match("++"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__157

    // $ANTLR start T__158
    public final void mT__158() throws RecognitionException {
        try {
            int _type = T__158;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Egx__.g:112:8: ( '--' )
            // Egx__.g:112:10: '--'
            {
            match("--"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__158

    // $ANTLR start T__159
    public final void mT__159() throws RecognitionException {
        try {
            int _type = T__159;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Egx__.g:113:8: ( '[' )
            // Egx__.g:113:10: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__159

    // $ANTLR start T__160
    public final void mT__160() throws RecognitionException {
        try {
            int _type = T__160;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Egx__.g:114:8: ( ']' )
            // Egx__.g:114:10: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__160

    // $ANTLR start T__161
    public final void mT__161() throws RecognitionException {
        try {
            int _type = T__161;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Egx__.g:115:8: ( '|' )
            // Egx__.g:115:10: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__161

    // $ANTLR start T__162
    public final void mT__162() throws RecognitionException {
        try {
            int _type = T__162;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Egx__.g:116:8: ( '=>' )
            // Egx__.g:116:10: '=>'
            {
            match("=>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__162

    // $ANTLR start T__163
    public final void mT__163() throws RecognitionException {
        try {
            int _type = T__163;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Egx__.g:117:8: ( 'new' )
            // Egx__.g:117:10: 'new'
            {
            match("new"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__163

    // $ANTLR start T__164
    public final void mT__164() throws RecognitionException {
        try {
            int _type = T__164;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Egx__.g:118:8: ( 'var' )
            // Egx__.g:118:10: 'var'
            {
            match("var"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__164

    // $ANTLR start T__165
    public final void mT__165() throws RecognitionException {
        try {
            int _type = T__165;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Egx__.g:119:8: ( 'ext' )
            // Egx__.g:119:10: 'ext'
            {
            match("ext"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__165

    // $ANTLR start T__166
    public final void mT__166() throws RecognitionException {
        try {
            int _type = T__166;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Egx__.g:120:8: ( 'pre' )
            // Egx__.g:120:10: 'pre'
            {
            match("pre"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__166

    // $ANTLR start T__167
    public final void mT__167() throws RecognitionException {
        try {
            int _type = T__167;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Egx__.g:121:8: ( 'post' )
            // Egx__.g:121:10: 'post'
            {
            match("post"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__167

    // $ANTLR start T__168
    public final void mT__168() throws RecognitionException {
        try {
            int _type = T__168;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Egx__.g:122:8: ( 'guard' )
            // Egx__.g:122:10: 'guard'
            {
            match("guard"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__168

    // $ANTLR start T__169
    public final void mT__169() throws RecognitionException {
        try {
            int _type = T__169;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Egx__.g:123:8: ( 'extends' )
            // Egx__.g:123:10: 'extends'
            {
            match("extends"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__169

    // $ANTLR start T__170
    public final void mT__170() throws RecognitionException {
        try {
            int _type = T__170;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Egx__.g:124:8: ( 'rule' )
            // Egx__.g:124:10: 'rule'
            {
            match("rule"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__170

    // $ANTLR start T__171
    public final void mT__171() throws RecognitionException {
        try {
            int _type = T__171;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Egx__.g:125:8: ( 'transform' )
            // Egx__.g:125:10: 'transform'
            {
            match("transform"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__171

    // $ANTLR start T__172
    public final void mT__172() throws RecognitionException {
        try {
            int _type = T__172;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Egx__.g:126:8: ( 'target' )
            // Egx__.g:126:10: 'target'
            {
            match("target"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__172

    // $ANTLR start T__173
    public final void mT__173() throws RecognitionException {
        try {
            int _type = T__173;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Egx__.g:127:8: ( 'template' )
            // Egx__.g:127:10: 'template'
            {
            match("template"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__173

    // $ANTLR start T__174
    public final void mT__174() throws RecognitionException {
        try {
            int _type = T__174;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Egx__.g:128:8: ( 'parameters' )
            // Egx__.g:128:10: 'parameters'
            {
            match("parameters"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__174

    // $ANTLR start T__175
    public final void mT__175() throws RecognitionException {
        try {
            int _type = T__175;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Egx__.g:129:8: ( 'overwrite' )
            // Egx__.g:129:10: 'overwrite'
            {
            match("overwrite"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__175

    // $ANTLR start T__176
    public final void mT__176() throws RecognitionException {
        try {
            int _type = T__176;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Egx__.g:130:8: ( 'merge' )
            // Egx__.g:130:10: 'merge'
            {
            match("merge"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__176

    // $ANTLR start T__177
    public final void mT__177() throws RecognitionException {
        try {
            int _type = T__177;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Egx__.g:131:8: ( 'protectRegions' )
            // Egx__.g:131:10: 'protectRegions'
            {
            match("protectRegions"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__177

    public void mTokens() throws RecognitionException {
        // Egx__.g:1:8: ( T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | T__104 | T__105 | T__106 | T__107 | T__108 | T__109 | T__110 | T__111 | T__112 | T__113 | T__114 | T__115 | T__116 | T__117 | T__118 | T__119 | T__120 | T__121 | T__122 | T__123 | T__124 | T__125 | T__126 | T__127 | T__128 | T__129 | T__130 | T__131 | T__132 | T__133 | T__134 | T__135 | T__136 | T__137 | T__138 | T__139 | T__140 | T__141 | T__142 | T__143 | T__144 | T__145 | T__146 | T__147 | T__148 | T__149 | T__150 | T__151 | T__152 | T__153 | T__154 | T__155 | T__156 | T__157 | T__158 | T__159 | T__160 | T__161 | T__162 | T__163 | T__164 | T__165 | T__166 | T__167 | T__168 | T__169 | T__170 | T__171 | T__172 | T__173 | T__174 | T__175 | T__176 | T__177 | EolLexerRules. Tokens )
        int alt1=89;
        alt1 = dfa1.predict(input);
        switch (alt1) {
            case 1 :
                // Egx__.g:1:10: T__90
                {
                mT__90(); 

                }
                break;
            case 2 :
                // Egx__.g:1:16: T__91
                {
                mT__91(); 

                }
                break;
            case 3 :
                // Egx__.g:1:22: T__92
                {
                mT__92(); 

                }
                break;
            case 4 :
                // Egx__.g:1:28: T__93
                {
                mT__93(); 

                }
                break;
            case 5 :
                // Egx__.g:1:34: T__94
                {
                mT__94(); 

                }
                break;
            case 6 :
                // Egx__.g:1:40: T__95
                {
                mT__95(); 

                }
                break;
            case 7 :
                // Egx__.g:1:46: T__96
                {
                mT__96(); 

                }
                break;
            case 8 :
                // Egx__.g:1:52: T__97
                {
                mT__97(); 

                }
                break;
            case 9 :
                // Egx__.g:1:58: T__98
                {
                mT__98(); 

                }
                break;
            case 10 :
                // Egx__.g:1:64: T__99
                {
                mT__99(); 

                }
                break;
            case 11 :
                // Egx__.g:1:70: T__100
                {
                mT__100(); 

                }
                break;
            case 12 :
                // Egx__.g:1:77: T__101
                {
                mT__101(); 

                }
                break;
            case 13 :
                // Egx__.g:1:84: T__102
                {
                mT__102(); 

                }
                break;
            case 14 :
                // Egx__.g:1:91: T__103
                {
                mT__103(); 

                }
                break;
            case 15 :
                // Egx__.g:1:98: T__104
                {
                mT__104(); 

                }
                break;
            case 16 :
                // Egx__.g:1:105: T__105
                {
                mT__105(); 

                }
                break;
            case 17 :
                // Egx__.g:1:112: T__106
                {
                mT__106(); 

                }
                break;
            case 18 :
                // Egx__.g:1:119: T__107
                {
                mT__107(); 

                }
                break;
            case 19 :
                // Egx__.g:1:126: T__108
                {
                mT__108(); 

                }
                break;
            case 20 :
                // Egx__.g:1:133: T__109
                {
                mT__109(); 

                }
                break;
            case 21 :
                // Egx__.g:1:140: T__110
                {
                mT__110(); 

                }
                break;
            case 22 :
                // Egx__.g:1:147: T__111
                {
                mT__111(); 

                }
                break;
            case 23 :
                // Egx__.g:1:154: T__112
                {
                mT__112(); 

                }
                break;
            case 24 :
                // Egx__.g:1:161: T__113
                {
                mT__113(); 

                }
                break;
            case 25 :
                // Egx__.g:1:168: T__114
                {
                mT__114(); 

                }
                break;
            case 26 :
                // Egx__.g:1:175: T__115
                {
                mT__115(); 

                }
                break;
            case 27 :
                // Egx__.g:1:182: T__116
                {
                mT__116(); 

                }
                break;
            case 28 :
                // Egx__.g:1:189: T__117
                {
                mT__117(); 

                }
                break;
            case 29 :
                // Egx__.g:1:196: T__118
                {
                mT__118(); 

                }
                break;
            case 30 :
                // Egx__.g:1:203: T__119
                {
                mT__119(); 

                }
                break;
            case 31 :
                // Egx__.g:1:210: T__120
                {
                mT__120(); 

                }
                break;
            case 32 :
                // Egx__.g:1:217: T__121
                {
                mT__121(); 

                }
                break;
            case 33 :
                // Egx__.g:1:224: T__122
                {
                mT__122(); 

                }
                break;
            case 34 :
                // Egx__.g:1:231: T__123
                {
                mT__123(); 

                }
                break;
            case 35 :
                // Egx__.g:1:238: T__124
                {
                mT__124(); 

                }
                break;
            case 36 :
                // Egx__.g:1:245: T__125
                {
                mT__125(); 

                }
                break;
            case 37 :
                // Egx__.g:1:252: T__126
                {
                mT__126(); 

                }
                break;
            case 38 :
                // Egx__.g:1:259: T__127
                {
                mT__127(); 

                }
                break;
            case 39 :
                // Egx__.g:1:266: T__128
                {
                mT__128(); 

                }
                break;
            case 40 :
                // Egx__.g:1:273: T__129
                {
                mT__129(); 

                }
                break;
            case 41 :
                // Egx__.g:1:280: T__130
                {
                mT__130(); 

                }
                break;
            case 42 :
                // Egx__.g:1:287: T__131
                {
                mT__131(); 

                }
                break;
            case 43 :
                // Egx__.g:1:294: T__132
                {
                mT__132(); 

                }
                break;
            case 44 :
                // Egx__.g:1:301: T__133
                {
                mT__133(); 

                }
                break;
            case 45 :
                // Egx__.g:1:308: T__134
                {
                mT__134(); 

                }
                break;
            case 46 :
                // Egx__.g:1:315: T__135
                {
                mT__135(); 

                }
                break;
            case 47 :
                // Egx__.g:1:322: T__136
                {
                mT__136(); 

                }
                break;
            case 48 :
                // Egx__.g:1:329: T__137
                {
                mT__137(); 

                }
                break;
            case 49 :
                // Egx__.g:1:336: T__138
                {
                mT__138(); 

                }
                break;
            case 50 :
                // Egx__.g:1:343: T__139
                {
                mT__139(); 

                }
                break;
            case 51 :
                // Egx__.g:1:350: T__140
                {
                mT__140(); 

                }
                break;
            case 52 :
                // Egx__.g:1:357: T__141
                {
                mT__141(); 

                }
                break;
            case 53 :
                // Egx__.g:1:364: T__142
                {
                mT__142(); 

                }
                break;
            case 54 :
                // Egx__.g:1:371: T__143
                {
                mT__143(); 

                }
                break;
            case 55 :
                // Egx__.g:1:378: T__144
                {
                mT__144(); 

                }
                break;
            case 56 :
                // Egx__.g:1:385: T__145
                {
                mT__145(); 

                }
                break;
            case 57 :
                // Egx__.g:1:392: T__146
                {
                mT__146(); 

                }
                break;
            case 58 :
                // Egx__.g:1:399: T__147
                {
                mT__147(); 

                }
                break;
            case 59 :
                // Egx__.g:1:406: T__148
                {
                mT__148(); 

                }
                break;
            case 60 :
                // Egx__.g:1:413: T__149
                {
                mT__149(); 

                }
                break;
            case 61 :
                // Egx__.g:1:420: T__150
                {
                mT__150(); 

                }
                break;
            case 62 :
                // Egx__.g:1:427: T__151
                {
                mT__151(); 

                }
                break;
            case 63 :
                // Egx__.g:1:434: T__152
                {
                mT__152(); 

                }
                break;
            case 64 :
                // Egx__.g:1:441: T__153
                {
                mT__153(); 

                }
                break;
            case 65 :
                // Egx__.g:1:448: T__154
                {
                mT__154(); 

                }
                break;
            case 66 :
                // Egx__.g:1:455: T__155
                {
                mT__155(); 

                }
                break;
            case 67 :
                // Egx__.g:1:462: T__156
                {
                mT__156(); 

                }
                break;
            case 68 :
                // Egx__.g:1:469: T__157
                {
                mT__157(); 

                }
                break;
            case 69 :
                // Egx__.g:1:476: T__158
                {
                mT__158(); 

                }
                break;
            case 70 :
                // Egx__.g:1:483: T__159
                {
                mT__159(); 

                }
                break;
            case 71 :
                // Egx__.g:1:490: T__160
                {
                mT__160(); 

                }
                break;
            case 72 :
                // Egx__.g:1:497: T__161
                {
                mT__161(); 

                }
                break;
            case 73 :
                // Egx__.g:1:504: T__162
                {
                mT__162(); 

                }
                break;
            case 74 :
                // Egx__.g:1:511: T__163
                {
                mT__163(); 

                }
                break;
            case 75 :
                // Egx__.g:1:518: T__164
                {
                mT__164(); 

                }
                break;
            case 76 :
                // Egx__.g:1:525: T__165
                {
                mT__165(); 

                }
                break;
            case 77 :
                // Egx__.g:1:532: T__166
                {
                mT__166(); 

                }
                break;
            case 78 :
                // Egx__.g:1:539: T__167
                {
                mT__167(); 

                }
                break;
            case 79 :
                // Egx__.g:1:546: T__168
                {
                mT__168(); 

                }
                break;
            case 80 :
                // Egx__.g:1:553: T__169
                {
                mT__169(); 

                }
                break;
            case 81 :
                // Egx__.g:1:560: T__170
                {
                mT__170(); 

                }
                break;
            case 82 :
                // Egx__.g:1:567: T__171
                {
                mT__171(); 

                }
                break;
            case 83 :
                // Egx__.g:1:574: T__172
                {
                mT__172(); 

                }
                break;
            case 84 :
                // Egx__.g:1:581: T__173
                {
                mT__173(); 

                }
                break;
            case 85 :
                // Egx__.g:1:588: T__174
                {
                mT__174(); 

                }
                break;
            case 86 :
                // Egx__.g:1:595: T__175
                {
                mT__175(); 

                }
                break;
            case 87 :
                // Egx__.g:1:602: T__176
                {
                mT__176(); 

                }
                break;
            case 88 :
                // Egx__.g:1:609: T__177
                {
                mT__177(); 

                }
                break;
            case 89 :
                // Egx__.g:1:616: EolLexerRules. Tokens
                {
                gEolLexerRules.mTokens(); 

                }
                break;

        }

    }


    protected DFA1 dfa1 = new DFA1(this);
    static final String DFA1_eotS =
        "\1\uffff\1\57\1\uffff\1\57\1\uffff\1\57\2\uffff\1\71\2\57\2\uffff"+
        "\1\101\1\57\3\uffff\7\57\1\116\1\120\7\57\1\140\1\143\1\145\1\147"+
        "\1\57\1\151\1\57\3\uffff\3\57\1\uffff\7\57\3\uffff\1\57\1\172\3"+
        "\57\1\177\2\uffff\1\57\1\u0081\1\u0082\7\57\5\uffff\15\57\12\uffff"+
        "\1\57\1\uffff\13\57\1\u00a6\4\57\1\uffff\2\57\1\u00ad\2\uffff\1"+
        "\57\2\uffff\4\57\1\u00b4\1\57\1\u00b6\1\57\1\u00b8\1\57\1\u00bb"+
        "\13\57\1\u00c7\1\u00c8\1\u00c9\1\u00ca\1\u00cb\10\57\1\uffff\6\57"+
        "\1\uffff\6\57\1\uffff\1\u00e0\1\uffff\1\57\1\uffff\1\u00e2\1\57"+
        "\1\uffff\1\57\1\u00e5\3\57\1\u00e9\5\57\5\uffff\1\57\1\u00f0\2\57"+
        "\1\u00f3\1\u00f4\1\u00f5\1\u00f6\14\57\1\uffff\1\57\1\uffff\2\57"+
        "\1\uffff\1\57\1\u0107\1\57\1\uffff\1\u0109\3\57\1\u010f\1\57\1\uffff"+
        "\1\57\1\u0112\4\uffff\1\u0113\1\57\1\u0115\3\57\1\u0119\1\57\1\u011b"+
        "\5\57\1\u0121\1\57\1\uffff\1\u0123\1\uffff\2\57\1\u0126\2\57\1\uffff"+
        "\2\57\2\uffff\1\u012b\1\uffff\3\57\1\uffff\1\u012f\1\uffff\4\57"+
        "\1\u0134\1\uffff\1\57\1\uffff\2\57\1\uffff\4\57\1\uffff\2\57\1\u013e"+
        "\1\uffff\2\57\1\u0141\1\57\1\uffff\1\u0143\2\57\1\u0146\1\u0147"+
        "\2\57\1\u014a\1\u014b\1\uffff\2\57\1\uffff\1\57\1\uffff\1\57\1\u0150"+
        "\2\uffff\2\57\2\uffff\1\u0153\1\57\1\u0157\1\57\1\uffff\1\57\1\u015a"+
        "\1\uffff\3\57\1\uffff\1\u015e\1\57\1\uffff\3\57\1\uffff\1\57\1\u0164"+
        "\1\u0165\1\u0166\1\57\3\uffff\1\u0168\1\uffff";
    static final String DFA1_eofS =
        "\u0169\uffff";
    static final String DFA1_minS =
        "\1\11\1\145\1\uffff\1\142\1\uffff\1\145\2\uffff\1\75\1\160\1\157"+
        "\2\uffff\1\72\1\146\3\uffff\1\141\1\157\1\145\1\151\1\141\1\162"+
        "\1\141\2\75\1\154\1\167\1\141\1\150\1\145\1\141\1\162\1\53\1\55"+
        "\1\75\1\52\1\157\1\46\1\145\3\uffff\2\141\1\165\1\uffff\1\144\1"+
        "\162\1\151\1\157\1\144\1\151\1\146\3\uffff\1\145\1\46\1\145\1\156"+
        "\1\162\1\75\2\uffff\1\160\2\46\1\164\1\154\1\161\1\163\1\147\1\144"+
        "\1\160\5\uffff\1\163\1\164\1\151\1\163\1\156\1\151\1\164\1\154\1"+
        "\162\1\141\1\162\1\155\1\145\12\uffff\1\162\1\uffff\1\164\1\167"+
        "\1\162\1\145\1\163\1\162\1\141\1\145\1\147\1\141\1\162\1\46\1\166"+
        "\1\141\1\145\1\162\1\uffff\1\162\1\143\1\46\2\uffff\1\154\2\uffff"+
        "\1\151\1\154\1\143\1\165\1\46\1\164\1\46\1\145\1\46\1\145\1\46\1"+
        "\164\1\145\1\164\1\154\1\165\1\145\1\157\1\156\1\147\1\160\1\141"+
        "\5\46\2\164\1\141\1\162\1\154\1\145\1\163\1\164\1\uffff\1\145\1"+
        "\165\1\164\1\141\1\167\1\164\1\uffff\1\162\1\151\1\166\1\145\1\165"+
        "\1\145\1\uffff\1\46\1\uffff\1\162\1\uffff\1\46\1\156\1\uffff\1\143"+
        "\1\46\1\151\1\145\1\162\1\46\1\167\1\163\1\145\1\154\1\153\5\uffff"+
        "\1\145\1\46\1\155\1\144\4\46\1\162\1\154\1\145\1\164\1\162\1\151"+
        "\1\164\2\145\1\143\1\162\1\156\1\uffff\1\145\1\uffff\1\144\1\150"+
        "\1\uffff\1\156\1\46\1\156\1\uffff\1\46\1\141\1\164\1\141\1\46\1"+
        "\143\1\uffff\1\145\1\46\4\uffff\1\46\1\164\1\46\2\151\1\157\1\46"+
        "\1\163\1\46\1\164\1\162\1\143\1\144\1\163\1\46\1\165\1\uffff\1\46"+
        "\1\uffff\1\143\1\157\1\46\1\164\1\154\1\uffff\2\164\2\uffff\1\46"+
        "\1\uffff\1\157\1\164\1\156\1\uffff\1\46\1\uffff\1\151\2\145\1\123"+
        "\1\46\1\uffff\1\145\1\uffff\1\164\1\162\1\uffff\1\145\1\154\1\122"+
        "\1\145\1\uffff\1\156\1\145\1\46\1\uffff\1\157\1\156\1\46\1\145\1"+
        "\uffff\1\46\1\151\1\155\2\46\1\145\1\162\2\46\1\uffff\1\156\1\164"+
        "\1\uffff\1\164\1\uffff\1\157\1\46\2\uffff\1\147\1\163\2\uffff\1"+
        "\46\1\102\1\46\1\156\1\uffff\1\151\1\46\1\uffff\2\141\1\145\1\uffff"+
        "\1\46\1\157\1\uffff\1\160\1\147\1\164\1\uffff\1\156\3\46\1\163\3"+
        "\uffff\1\46\1\uffff";
    static final String DFA1_maxS =
        "\1\ufaff\1\157\1\uffff\1\156\1\uffff\1\162\2\uffff\1\76\1\166\1"+
        "\165\2\uffff\1\75\1\156\3\uffff\1\141\1\157\1\145\1\151\1\141\1"+
        "\162\1\141\1\76\1\75\1\170\1\167\1\157\1\150\1\165\2\162\1\75\1"+
        "\76\2\75\1\157\1\ufaff\1\157\3\uffff\1\141\1\162\1\165\1\uffff\1"+
        "\144\1\162\1\151\1\157\1\144\1\151\1\154\3\uffff\1\145\1\ufaff\1"+
        "\145\1\156\1\162\1\75\2\uffff\1\160\2\ufaff\1\164\1\156\1\164\1"+
        "\163\1\147\1\144\1\160\5\uffff\1\163\1\164\1\151\1\163\1\156\1\151"+
        "\1\164\1\154\1\162\1\141\1\162\1\155\1\145\12\uffff\1\162\1\uffff"+
        "\1\164\1\167\1\162\1\157\1\163\1\162\1\141\1\145\1\147\1\141\1\162"+
        "\1\ufaff\1\166\1\141\1\145\1\162\1\uffff\1\162\1\143\1\ufaff\2\uffff"+
        "\1\157\2\uffff\1\151\1\154\1\143\1\165\1\ufaff\1\164\1\ufaff\1\145"+
        "\1\ufaff\1\145\1\ufaff\1\164\1\145\1\164\1\154\1\165\1\145\1\157"+
        "\1\156\1\147\1\160\1\141\5\ufaff\2\164\1\141\1\162\1\154\1\145\1"+
        "\163\1\164\1\uffff\1\145\1\165\1\164\1\141\1\167\1\164\1\uffff\1"+
        "\162\1\151\1\166\1\145\1\165\1\145\1\uffff\1\ufaff\1\uffff\1\162"+
        "\1\uffff\1\ufaff\1\156\1\uffff\1\143\1\ufaff\1\151\1\145\1\162\1"+
        "\ufaff\1\167\1\163\1\145\1\154\1\153\5\uffff\1\145\1\ufaff\1\155"+
        "\1\144\4\ufaff\1\162\1\154\1\145\1\164\1\162\1\151\1\164\2\145\1"+
        "\143\1\162\1\156\1\uffff\1\145\1\uffff\1\144\1\150\1\uffff\1\156"+
        "\1\ufaff\1\156\1\uffff\1\ufaff\1\146\1\164\1\141\1\ufaff\1\143\1"+
        "\uffff\1\145\1\ufaff\4\uffff\1\ufaff\1\164\1\ufaff\2\151\1\157\1"+
        "\ufaff\1\163\1\ufaff\1\164\1\162\1\143\1\144\1\163\1\ufaff\1\165"+
        "\1\uffff\1\ufaff\1\uffff\1\143\1\157\1\ufaff\1\164\1\154\1\uffff"+
        "\2\164\2\uffff\1\ufaff\1\uffff\1\157\1\164\1\156\1\uffff\1\ufaff"+
        "\1\uffff\1\151\2\145\1\123\1\ufaff\1\uffff\1\145\1\uffff\1\164\1"+
        "\162\1\uffff\1\145\1\154\1\122\1\145\1\uffff\1\156\1\145\1\ufaff"+
        "\1\uffff\1\157\1\156\1\ufaff\1\145\1\uffff\1\ufaff\1\151\1\155\2"+
        "\ufaff\1\145\1\162\2\ufaff\1\uffff\1\156\1\164\1\uffff\1\164\1\uffff"+
        "\1\157\1\ufaff\2\uffff\1\147\1\163\2\uffff\1\ufaff\1\123\1\ufaff"+
        "\1\156\1\uffff\1\151\1\ufaff\1\uffff\2\141\1\145\1\uffff\1\ufaff"+
        "\1\157\1\uffff\1\160\1\147\1\164\1\uffff\1\156\3\ufaff\1\163\3\uffff"+
        "\1\ufaff\1\uffff";
    static final String DFA1_acceptS =
        "\2\uffff\1\2\1\uffff\1\4\1\uffff\1\6\1\7\3\uffff\1\13\1\14\2\uffff"+
        "\1\17\1\20\1\21\27\uffff\1\106\1\107\1\110\3\uffff\1\131\7\uffff"+
        "\1\73\1\111\1\10\6\uffff\1\60\1\15\12\uffff\1\75\1\76\1\36\1\74"+
        "\1\37\15\uffff\1\61\1\104\1\77\1\62\1\105\1\100\1\63\1\101\1\64"+
        "\1\102\1\uffff\1\72\20\uffff\1\66\3\uffff\1\65\1\22\1\uffff\1\40"+
        "\1\46\43\uffff\1\67\6\uffff\1\45\6\uffff\1\30\1\uffff\1\27\1\uffff"+
        "\1\32\2\uffff\1\114\13\uffff\1\70\1\103\1\112\1\113\1\115\24\uffff"+
        "\1\26\1\uffff\1\41\2\uffff\1\43\3\uffff\1\121\6\uffff\1\116\2\uffff"+
        "\1\1\1\127\1\3\1\56\20\uffff\1\47\1\uffff\1\51\5\uffff\1\53\2\uffff"+
        "\1\117\1\5\1\uffff\1\52\3\uffff\1\16\1\uffff\1\23\5\uffff\1\42\1"+
        "\uffff\1\50\2\uffff\1\123\4\uffff\1\44\3\uffff\1\71\4\uffff\1\120"+
        "\11\uffff\1\12\2\uffff\1\25\1\uffff\1\55\2\uffff\1\124\1\54\2\uffff"+
        "\1\11\1\126\4\uffff\1\122\2\uffff\1\24\3\uffff\1\31\2\uffff\1\125"+
        "\3\uffff\1\57\5\uffff\1\33\1\34\1\35\1\uffff\1\130";
    static final String DFA1_specialS =
        "\u0169\uffff}>";
    static final String[] DFA1_transitionS = {
            "\2\57\1\uffff\2\57\22\uffff\1\57\1\20\1\57\1\21\1\17\1\uffff"+
            "\2\57\1\13\1\14\1\44\1\42\1\4\1\43\1\57\1\45\12\57\1\15\1\2"+
            "\1\31\1\10\1\32\1\47\2\57\1\26\1\23\10\57\1\25\1\30\1\22\1\27"+
            "\3\57\1\24\7\57\1\51\1\uffff\1\52\3\57\1\3\1\41\1\35\1\5\1\33"+
            "\1\12\1\56\1\57\1\16\3\57\1\1\1\50\1\11\1\55\1\57\1\37\1\34"+
            "\1\40\1\57\1\54\1\36\1\46\2\57\1\6\1\53\1\7\1\57\101\uffff\27"+
            "\57\1\uffff\37\57\1\uffff\u1f08\57\u1040\uffff\u0150\57\u0170"+
            "\uffff\u0080\57\u0080\uffff\u092e\57\u10d2\uffff\u5200\57\u5900"+
            "\uffff\u0200\57",
            "\1\61\11\uffff\1\60",
            "",
            "\1\63\11\uffff\1\62\1\uffff\1\64",
            "",
            "\1\66\14\uffff\1\65",
            "",
            "",
            "\1\67\1\70",
            "\1\72\1\uffff\1\73\3\uffff\1\74",
            "\1\76\5\uffff\1\75",
            "",
            "",
            "\1\77\2\uffff\1\100",
            "\1\103\6\uffff\1\102\1\104",
            "",
            "",
            "",
            "\1\105",
            "\1\106",
            "\1\107",
            "\1\110",
            "\1\111",
            "\1\112",
            "\1\113",
            "\1\114\1\115",
            "\1\117",
            "\1\121\13\uffff\1\122",
            "\1\123",
            "\1\124\15\uffff\1\125",
            "\1\126",
            "\1\127\17\uffff\1\130",
            "\1\133\3\uffff\1\134\2\uffff\1\131\11\uffff\1\132",
            "\1\135",
            "\1\137\21\uffff\1\136",
            "\1\142\17\uffff\1\141\1\57",
            "\1\144",
            "\1\57\4\uffff\1\57\15\uffff\1\146",
            "\1\150",
            "\1\57\11\uffff\12\57\5\uffff\1\57\1\uffff\32\57\3\uffff\2"+
            "\57\1\uffff\32\57\3\uffff\1\57\101\uffff\27\57\1\uffff\37\57"+
            "\1\uffff\u1f08\57\u1040\uffff\u0150\57\u0170\uffff\u0080\57"+
            "\u0080\uffff\u092e\57\u10d2\uffff\u5200\57\u5900\uffff\u0200"+
            "\57",
            "\1\153\11\uffff\1\152",
            "",
            "",
            "",
            "\1\154",
            "\1\157\15\uffff\1\156\2\uffff\1\155",
            "\1\160",
            "",
            "\1\161",
            "\1\162",
            "\1\163",
            "\1\164",
            "\1\165",
            "\1\166",
            "\1\167\5\uffff\1\170",
            "",
            "",
            "",
            "\1\171",
            "\1\57\11\uffff\12\57\5\uffff\1\57\1\uffff\32\57\3\uffff\2"+
            "\57\1\uffff\32\57\3\uffff\1\57\101\uffff\27\57\1\uffff\37\57"+
            "\1\uffff\u1f08\57\u1040\uffff\u0150\57\u0170\uffff\u0080\57"+
            "\u0080\uffff\u092e\57\u10d2\uffff\u5200\57\u5900\uffff\u0200"+
            "\57",
            "\1\173",
            "\1\174",
            "\1\175",
            "\1\176",
            "",
            "",
            "\1\u0080",
            "\1\57\11\uffff\12\57\5\uffff\1\57\1\uffff\32\57\3\uffff\2"+
            "\57\1\uffff\32\57\3\uffff\1\57\101\uffff\27\57\1\uffff\37\57"+
            "\1\uffff\u1f08\57\u1040\uffff\u0150\57\u0170\uffff\u0080\57"+
            "\u0080\uffff\u092e\57\u10d2\uffff\u5200\57\u5900\uffff\u0200"+
            "\57",
            "\1\57\11\uffff\12\57\5\uffff\1\57\1\uffff\32\57\3\uffff\2"+
            "\57\1\uffff\32\57\3\uffff\1\57\101\uffff\27\57\1\uffff\37\57"+
            "\1\uffff\u1f08\57\u1040\uffff\u0150\57\u0170\uffff\u0080\57"+
            "\u0080\uffff\u092e\57\u10d2\uffff\u5200\57\u5900\uffff\u0200"+
            "\57",
            "\1\u0083",
            "\1\u0084\1\uffff\1\u0085",
            "\1\u0086\2\uffff\1\u0087",
            "\1\u0088",
            "\1\u0089",
            "\1\u008a",
            "\1\u008b",
            "",
            "",
            "",
            "",
            "",
            "\1\u008c",
            "\1\u008d",
            "\1\u008e",
            "\1\u008f",
            "\1\u0090",
            "\1\u0091",
            "\1\u0092",
            "\1\u0093",
            "\1\u0094",
            "\1\u0095",
            "\1\u0096",
            "\1\u0097",
            "\1\u0098",
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
            "\1\u0099",
            "",
            "\1\u009a",
            "\1\u009b",
            "\1\u009c",
            "\1\u009d\11\uffff\1\u009e",
            "\1\u009f",
            "\1\u00a0",
            "\1\u00a1",
            "\1\u00a2",
            "\1\u00a3",
            "\1\u00a4",
            "\1\u00a5",
            "\1\57\11\uffff\12\57\5\uffff\1\57\1\uffff\32\57\3\uffff\2"+
            "\57\1\uffff\32\57\3\uffff\1\57\101\uffff\27\57\1\uffff\37\57"+
            "\1\uffff\u1f08\57\u1040\uffff\u0150\57\u0170\uffff\u0080\57"+
            "\u0080\uffff\u092e\57\u10d2\uffff\u5200\57\u5900\uffff\u0200"+
            "\57",
            "\1\u00a7",
            "\1\u00a8",
            "\1\u00a9",
            "\1\u00aa",
            "",
            "\1\u00ab",
            "\1\u00ac",
            "\1\57\11\uffff\12\57\5\uffff\1\57\1\uffff\32\57\3\uffff\2"+
            "\57\1\uffff\32\57\3\uffff\1\57\101\uffff\27\57\1\uffff\37\57"+
            "\1\uffff\u1f08\57\u1040\uffff\u0150\57\u0170\uffff\u0080\57"+
            "\u0080\uffff\u092e\57\u10d2\uffff\u5200\57\u5900\uffff\u0200"+
            "\57",
            "",
            "",
            "\1\u00af\2\uffff\1\u00ae",
            "",
            "",
            "\1\u00b0",
            "\1\u00b1",
            "\1\u00b2",
            "\1\u00b3",
            "\1\57\11\uffff\12\57\5\uffff\1\57\1\uffff\32\57\3\uffff\2"+
            "\57\1\uffff\32\57\3\uffff\1\57\101\uffff\27\57\1\uffff\37\57"+
            "\1\uffff\u1f08\57\u1040\uffff\u0150\57\u0170\uffff\u0080\57"+
            "\u0080\uffff\u092e\57\u10d2\uffff\u5200\57\u5900\uffff\u0200"+
            "\57",
            "\1\u00b5",
            "\1\57\11\uffff\12\57\5\uffff\1\57\1\uffff\32\57\3\uffff\2"+
            "\57\1\uffff\32\57\3\uffff\1\57\101\uffff\27\57\1\uffff\37\57"+
            "\1\uffff\u1f08\57\u1040\uffff\u0150\57\u0170\uffff\u0080\57"+
            "\u0080\uffff\u092e\57\u10d2\uffff\u5200\57\u5900\uffff\u0200"+
            "\57",
            "\1\u00b7",
            "\1\57\11\uffff\12\57\5\uffff\1\57\1\uffff\32\57\3\uffff\2"+
            "\57\1\uffff\32\57\3\uffff\1\57\101\uffff\27\57\1\uffff\37\57"+
            "\1\uffff\u1f08\57\u1040\uffff\u0150\57\u0170\uffff\u0080\57"+
            "\u0080\uffff\u092e\57\u10d2\uffff\u5200\57\u5900\uffff\u0200"+
            "\57",
            "\1\u00b9",
            "\1\57\11\uffff\12\57\5\uffff\1\57\1\uffff\32\57\3\uffff\2"+
            "\57\1\uffff\4\57\1\u00ba\25\57\3\uffff\1\57\101\uffff\27\57"+
            "\1\uffff\37\57\1\uffff\u1f08\57\u1040\uffff\u0150\57\u0170\uffff"+
            "\u0080\57\u0080\uffff\u092e\57\u10d2\uffff\u5200\57\u5900\uffff"+
            "\u0200\57",
            "\1\u00bc",
            "\1\u00bd",
            "\1\u00be",
            "\1\u00bf",
            "\1\u00c0",
            "\1\u00c1",
            "\1\u00c2",
            "\1\u00c3",
            "\1\u00c4",
            "\1\u00c5",
            "\1\u00c6",
            "\1\57\11\uffff\12\57\5\uffff\1\57\1\uffff\32\57\3\uffff\2"+
            "\57\1\uffff\32\57\3\uffff\1\57\101\uffff\27\57\1\uffff\37\57"+
            "\1\uffff\u1f08\57\u1040\uffff\u0150\57\u0170\uffff\u0080\57"+
            "\u0080\uffff\u092e\57\u10d2\uffff\u5200\57\u5900\uffff\u0200"+
            "\57",
            "\1\57\11\uffff\12\57\5\uffff\1\57\1\uffff\32\57\3\uffff\2"+
            "\57\1\uffff\32\57\3\uffff\1\57\101\uffff\27\57\1\uffff\37\57"+
            "\1\uffff\u1f08\57\u1040\uffff\u0150\57\u0170\uffff\u0080\57"+
            "\u0080\uffff\u092e\57\u10d2\uffff\u5200\57\u5900\uffff\u0200"+
            "\57",
            "\1\57\11\uffff\12\57\5\uffff\1\57\1\uffff\32\57\3\uffff\2"+
            "\57\1\uffff\32\57\3\uffff\1\57\101\uffff\27\57\1\uffff\37\57"+
            "\1\uffff\u1f08\57\u1040\uffff\u0150\57\u0170\uffff\u0080\57"+
            "\u0080\uffff\u092e\57\u10d2\uffff\u5200\57\u5900\uffff\u0200"+
            "\57",
            "\1\57\11\uffff\12\57\5\uffff\1\57\1\uffff\32\57\3\uffff\2"+
            "\57\1\uffff\32\57\3\uffff\1\57\101\uffff\27\57\1\uffff\37\57"+
            "\1\uffff\u1f08\57\u1040\uffff\u0150\57\u0170\uffff\u0080\57"+
            "\u0080\uffff\u092e\57\u10d2\uffff\u5200\57\u5900\uffff\u0200"+
            "\57",
            "\1\57\11\uffff\12\57\5\uffff\1\57\1\uffff\32\57\3\uffff\2"+
            "\57\1\uffff\32\57\3\uffff\1\57\101\uffff\27\57\1\uffff\37\57"+
            "\1\uffff\u1f08\57\u1040\uffff\u0150\57\u0170\uffff\u0080\57"+
            "\u0080\uffff\u092e\57\u10d2\uffff\u5200\57\u5900\uffff\u0200"+
            "\57",
            "\1\u00cc",
            "\1\u00cd",
            "\1\u00ce",
            "\1\u00cf",
            "\1\u00d0",
            "\1\u00d1",
            "\1\u00d2",
            "\1\u00d3",
            "",
            "\1\u00d4",
            "\1\u00d5",
            "\1\u00d6",
            "\1\u00d7",
            "\1\u00d8",
            "\1\u00d9",
            "",
            "\1\u00da",
            "\1\u00db",
            "\1\u00dc",
            "\1\u00dd",
            "\1\u00de",
            "\1\u00df",
            "",
            "\1\57\11\uffff\12\57\5\uffff\1\57\1\uffff\32\57\3\uffff\2"+
            "\57\1\uffff\32\57\3\uffff\1\57\101\uffff\27\57\1\uffff\37\57"+
            "\1\uffff\u1f08\57\u1040\uffff\u0150\57\u0170\uffff\u0080\57"+
            "\u0080\uffff\u092e\57\u10d2\uffff\u5200\57\u5900\uffff\u0200"+
            "\57",
            "",
            "\1\u00e1",
            "",
            "\1\57\11\uffff\12\57\5\uffff\1\57\1\uffff\32\57\3\uffff\2"+
            "\57\1\uffff\32\57\3\uffff\1\57\101\uffff\27\57\1\uffff\37\57"+
            "\1\uffff\u1f08\57\u1040\uffff\u0150\57\u0170\uffff\u0080\57"+
            "\u0080\uffff\u092e\57\u10d2\uffff\u5200\57\u5900\uffff\u0200"+
            "\57",
            "\1\u00e3",
            "",
            "\1\u00e4",
            "\1\57\11\uffff\12\57\5\uffff\1\57\1\uffff\32\57\3\uffff\2"+
            "\57\1\uffff\32\57\3\uffff\1\57\101\uffff\27\57\1\uffff\37\57"+
            "\1\uffff\u1f08\57\u1040\uffff\u0150\57\u0170\uffff\u0080\57"+
            "\u0080\uffff\u092e\57\u10d2\uffff\u5200\57\u5900\uffff\u0200"+
            "\57",
            "\1\u00e6",
            "\1\u00e7",
            "\1\u00e8",
            "\1\57\11\uffff\12\57\5\uffff\1\57\1\uffff\32\57\3\uffff\2"+
            "\57\1\uffff\32\57\3\uffff\1\57\101\uffff\27\57\1\uffff\37\57"+
            "\1\uffff\u1f08\57\u1040\uffff\u0150\57\u0170\uffff\u0080\57"+
            "\u0080\uffff\u092e\57\u10d2\uffff\u5200\57\u5900\uffff\u0200"+
            "\57",
            "\1\u00ea",
            "\1\u00eb",
            "\1\u00ec",
            "\1\u00ed",
            "\1\u00ee",
            "",
            "",
            "",
            "",
            "",
            "\1\u00ef",
            "\1\57\11\uffff\12\57\5\uffff\1\57\1\uffff\32\57\3\uffff\2"+
            "\57\1\uffff\32\57\3\uffff\1\57\101\uffff\27\57\1\uffff\37\57"+
            "\1\uffff\u1f08\57\u1040\uffff\u0150\57\u0170\uffff\u0080\57"+
            "\u0080\uffff\u092e\57\u10d2\uffff\u5200\57\u5900\uffff\u0200"+
            "\57",
            "\1\u00f1",
            "\1\u00f2",
            "\1\57\11\uffff\12\57\5\uffff\1\57\1\uffff\32\57\3\uffff\2"+
            "\57\1\uffff\32\57\3\uffff\1\57\101\uffff\27\57\1\uffff\37\57"+
            "\1\uffff\u1f08\57\u1040\uffff\u0150\57\u0170\uffff\u0080\57"+
            "\u0080\uffff\u092e\57\u10d2\uffff\u5200\57\u5900\uffff\u0200"+
            "\57",
            "\1\57\11\uffff\12\57\5\uffff\1\57\1\uffff\32\57\3\uffff\2"+
            "\57\1\uffff\32\57\3\uffff\1\57\101\uffff\27\57\1\uffff\37\57"+
            "\1\uffff\u1f08\57\u1040\uffff\u0150\57\u0170\uffff\u0080\57"+
            "\u0080\uffff\u092e\57\u10d2\uffff\u5200\57\u5900\uffff\u0200"+
            "\57",
            "\1\57\11\uffff\12\57\5\uffff\1\57\1\uffff\32\57\3\uffff\2"+
            "\57\1\uffff\32\57\3\uffff\1\57\101\uffff\27\57\1\uffff\37\57"+
            "\1\uffff\u1f08\57\u1040\uffff\u0150\57\u0170\uffff\u0080\57"+
            "\u0080\uffff\u092e\57\u10d2\uffff\u5200\57\u5900\uffff\u0200"+
            "\57",
            "\1\57\11\uffff\12\57\5\uffff\1\57\1\uffff\32\57\3\uffff\2"+
            "\57\1\uffff\32\57\3\uffff\1\57\101\uffff\27\57\1\uffff\37\57"+
            "\1\uffff\u1f08\57\u1040\uffff\u0150\57\u0170\uffff\u0080\57"+
            "\u0080\uffff\u092e\57\u10d2\uffff\u5200\57\u5900\uffff\u0200"+
            "\57",
            "\1\u00f7",
            "\1\u00f8",
            "\1\u00f9",
            "\1\u00fa",
            "\1\u00fb",
            "\1\u00fc",
            "\1\u00fd",
            "\1\u00fe",
            "\1\u00ff",
            "\1\u0100",
            "\1\u0101",
            "\1\u0102",
            "",
            "\1\u0103",
            "",
            "\1\u0104",
            "\1\u0105",
            "",
            "\1\u0106",
            "\1\57\11\uffff\12\57\5\uffff\1\57\1\uffff\32\57\3\uffff\2"+
            "\57\1\uffff\32\57\3\uffff\1\57\101\uffff\27\57\1\uffff\37\57"+
            "\1\uffff\u1f08\57\u1040\uffff\u0150\57\u0170\uffff\u0080\57"+
            "\u0080\uffff\u092e\57\u10d2\uffff\u5200\57\u5900\uffff\u0200"+
            "\57",
            "\1\u0108",
            "",
            "\1\57\11\uffff\12\57\5\uffff\1\57\1\uffff\32\57\3\uffff\2"+
            "\57\1\uffff\32\57\3\uffff\1\57\101\uffff\27\57\1\uffff\37\57"+
            "\1\uffff\u1f08\57\u1040\uffff\u0150\57\u0170\uffff\u0080\57"+
            "\u0080\uffff\u092e\57\u10d2\uffff\u5200\57\u5900\uffff\u0200"+
            "\57",
            "\1\u010a\4\uffff\1\u010b",
            "\1\u010c",
            "\1\u010d",
            "\1\57\11\uffff\12\57\5\uffff\1\57\1\uffff\1\u010e\31\57\3"+
            "\uffff\2\57\1\uffff\32\57\3\uffff\1\57\101\uffff\27\57\1\uffff"+
            "\37\57\1\uffff\u1f08\57\u1040\uffff\u0150\57\u0170\uffff\u0080"+
            "\57\u0080\uffff\u092e\57\u10d2\uffff\u5200\57\u5900\uffff\u0200"+
            "\57",
            "\1\u0110",
            "",
            "\1\u0111",
            "\1\57\11\uffff\12\57\5\uffff\1\57\1\uffff\32\57\3\uffff\2"+
            "\57\1\uffff\32\57\3\uffff\1\57\101\uffff\27\57\1\uffff\37\57"+
            "\1\uffff\u1f08\57\u1040\uffff\u0150\57\u0170\uffff\u0080\57"+
            "\u0080\uffff\u092e\57\u10d2\uffff\u5200\57\u5900\uffff\u0200"+
            "\57",
            "",
            "",
            "",
            "",
            "\1\57\11\uffff\12\57\5\uffff\1\57\1\uffff\32\57\3\uffff\2"+
            "\57\1\uffff\32\57\3\uffff\1\57\101\uffff\27\57\1\uffff\37\57"+
            "\1\uffff\u1f08\57\u1040\uffff\u0150\57\u0170\uffff\u0080\57"+
            "\u0080\uffff\u092e\57\u10d2\uffff\u5200\57\u5900\uffff\u0200"+
            "\57",
            "\1\u0114",
            "\1\57\11\uffff\12\57\5\uffff\1\57\1\uffff\32\57\3\uffff\2"+
            "\57\1\uffff\32\57\3\uffff\1\57\101\uffff\27\57\1\uffff\37\57"+
            "\1\uffff\u1f08\57\u1040\uffff\u0150\57\u0170\uffff\u0080\57"+
            "\u0080\uffff\u092e\57\u10d2\uffff\u5200\57\u5900\uffff\u0200"+
            "\57",
            "\1\u0116",
            "\1\u0117",
            "\1\u0118",
            "\1\57\11\uffff\12\57\5\uffff\1\57\1\uffff\32\57\3\uffff\2"+
            "\57\1\uffff\32\57\3\uffff\1\57\101\uffff\27\57\1\uffff\37\57"+
            "\1\uffff\u1f08\57\u1040\uffff\u0150\57\u0170\uffff\u0080\57"+
            "\u0080\uffff\u092e\57\u10d2\uffff\u5200\57\u5900\uffff\u0200"+
            "\57",
            "\1\u011a",
            "\1\57\11\uffff\12\57\5\uffff\1\57\1\uffff\32\57\3\uffff\2"+
            "\57\1\uffff\32\57\3\uffff\1\57\101\uffff\27\57\1\uffff\37\57"+
            "\1\uffff\u1f08\57\u1040\uffff\u0150\57\u0170\uffff\u0080\57"+
            "\u0080\uffff\u092e\57\u10d2\uffff\u5200\57\u5900\uffff\u0200"+
            "\57",
            "\1\u011c",
            "\1\u011d",
            "\1\u011e",
            "\1\u011f",
            "\1\u0120",
            "\1\57\11\uffff\12\57\5\uffff\1\57\1\uffff\32\57\3\uffff\2"+
            "\57\1\uffff\32\57\3\uffff\1\57\101\uffff\27\57\1\uffff\37\57"+
            "\1\uffff\u1f08\57\u1040\uffff\u0150\57\u0170\uffff\u0080\57"+
            "\u0080\uffff\u092e\57\u10d2\uffff\u5200\57\u5900\uffff\u0200"+
            "\57",
            "\1\u0122",
            "",
            "\1\57\11\uffff\12\57\5\uffff\1\57\1\uffff\32\57\3\uffff\2"+
            "\57\1\uffff\32\57\3\uffff\1\57\101\uffff\27\57\1\uffff\37\57"+
            "\1\uffff\u1f08\57\u1040\uffff\u0150\57\u0170\uffff\u0080\57"+
            "\u0080\uffff\u092e\57\u10d2\uffff\u5200\57\u5900\uffff\u0200"+
            "\57",
            "",
            "\1\u0124",
            "\1\u0125",
            "\1\57\11\uffff\12\57\5\uffff\1\57\1\uffff\32\57\3\uffff\2"+
            "\57\1\uffff\32\57\3\uffff\1\57\101\uffff\27\57\1\uffff\37\57"+
            "\1\uffff\u1f08\57\u1040\uffff\u0150\57\u0170\uffff\u0080\57"+
            "\u0080\uffff\u092e\57\u10d2\uffff\u5200\57\u5900\uffff\u0200"+
            "\57",
            "\1\u0127",
            "\1\u0128",
            "",
            "\1\u0129",
            "\1\u012a",
            "",
            "",
            "\1\57\11\uffff\12\57\5\uffff\1\57\1\uffff\32\57\3\uffff\2"+
            "\57\1\uffff\32\57\3\uffff\1\57\101\uffff\27\57\1\uffff\37\57"+
            "\1\uffff\u1f08\57\u1040\uffff\u0150\57\u0170\uffff\u0080\57"+
            "\u0080\uffff\u092e\57\u10d2\uffff\u5200\57\u5900\uffff\u0200"+
            "\57",
            "",
            "\1\u012c",
            "\1\u012d",
            "\1\u012e",
            "",
            "\1\57\11\uffff\12\57\5\uffff\1\57\1\uffff\32\57\3\uffff\2"+
            "\57\1\uffff\32\57\3\uffff\1\57\101\uffff\27\57\1\uffff\37\57"+
            "\1\uffff\u1f08\57\u1040\uffff\u0150\57\u0170\uffff\u0080\57"+
            "\u0080\uffff\u092e\57\u10d2\uffff\u5200\57\u5900\uffff\u0200"+
            "\57",
            "",
            "\1\u0130",
            "\1\u0131",
            "\1\u0132",
            "\1\u0133",
            "\1\57\11\uffff\12\57\5\uffff\1\57\1\uffff\32\57\3\uffff\2"+
            "\57\1\uffff\32\57\3\uffff\1\57\101\uffff\27\57\1\uffff\37\57"+
            "\1\uffff\u1f08\57\u1040\uffff\u0150\57\u0170\uffff\u0080\57"+
            "\u0080\uffff\u092e\57\u10d2\uffff\u5200\57\u5900\uffff\u0200"+
            "\57",
            "",
            "\1\u0135",
            "",
            "\1\u0136",
            "\1\u0137",
            "",
            "\1\u0138",
            "\1\u0139",
            "\1\u013a",
            "\1\u013b",
            "",
            "\1\u013c",
            "\1\u013d",
            "\1\57\11\uffff\12\57\5\uffff\1\57\1\uffff\32\57\3\uffff\2"+
            "\57\1\uffff\32\57\3\uffff\1\57\101\uffff\27\57\1\uffff\37\57"+
            "\1\uffff\u1f08\57\u1040\uffff\u0150\57\u0170\uffff\u0080\57"+
            "\u0080\uffff\u092e\57\u10d2\uffff\u5200\57\u5900\uffff\u0200"+
            "\57",
            "",
            "\1\u013f",
            "\1\u0140",
            "\1\57\11\uffff\12\57\5\uffff\1\57\1\uffff\32\57\3\uffff\2"+
            "\57\1\uffff\32\57\3\uffff\1\57\101\uffff\27\57\1\uffff\37\57"+
            "\1\uffff\u1f08\57\u1040\uffff\u0150\57\u0170\uffff\u0080\57"+
            "\u0080\uffff\u092e\57\u10d2\uffff\u5200\57\u5900\uffff\u0200"+
            "\57",
            "\1\u0142",
            "",
            "\1\57\11\uffff\12\57\5\uffff\1\57\1\uffff\32\57\3\uffff\2"+
            "\57\1\uffff\32\57\3\uffff\1\57\101\uffff\27\57\1\uffff\37\57"+
            "\1\uffff\u1f08\57\u1040\uffff\u0150\57\u0170\uffff\u0080\57"+
            "\u0080\uffff\u092e\57\u10d2\uffff\u5200\57\u5900\uffff\u0200"+
            "\57",
            "\1\u0144",
            "\1\u0145",
            "\1\57\11\uffff\12\57\5\uffff\1\57\1\uffff\32\57\3\uffff\2"+
            "\57\1\uffff\32\57\3\uffff\1\57\101\uffff\27\57\1\uffff\37\57"+
            "\1\uffff\u1f08\57\u1040\uffff\u0150\57\u0170\uffff\u0080\57"+
            "\u0080\uffff\u092e\57\u10d2\uffff\u5200\57\u5900\uffff\u0200"+
            "\57",
            "\1\57\11\uffff\12\57\5\uffff\1\57\1\uffff\32\57\3\uffff\2"+
            "\57\1\uffff\32\57\3\uffff\1\57\101\uffff\27\57\1\uffff\37\57"+
            "\1\uffff\u1f08\57\u1040\uffff\u0150\57\u0170\uffff\u0080\57"+
            "\u0080\uffff\u092e\57\u10d2\uffff\u5200\57\u5900\uffff\u0200"+
            "\57",
            "\1\u0148",
            "\1\u0149",
            "\1\57\11\uffff\12\57\5\uffff\1\57\1\uffff\32\57\3\uffff\2"+
            "\57\1\uffff\32\57\3\uffff\1\57\101\uffff\27\57\1\uffff\37\57"+
            "\1\uffff\u1f08\57\u1040\uffff\u0150\57\u0170\uffff\u0080\57"+
            "\u0080\uffff\u092e\57\u10d2\uffff\u5200\57\u5900\uffff\u0200"+
            "\57",
            "\1\57\11\uffff\12\57\5\uffff\1\57\1\uffff\32\57\3\uffff\2"+
            "\57\1\uffff\32\57\3\uffff\1\57\101\uffff\27\57\1\uffff\37\57"+
            "\1\uffff\u1f08\57\u1040\uffff\u0150\57\u0170\uffff\u0080\57"+
            "\u0080\uffff\u092e\57\u10d2\uffff\u5200\57\u5900\uffff\u0200"+
            "\57",
            "",
            "\1\u014c",
            "\1\u014d",
            "",
            "\1\u014e",
            "",
            "\1\u014f",
            "\1\57\11\uffff\12\57\5\uffff\1\57\1\uffff\32\57\3\uffff\2"+
            "\57\1\uffff\32\57\3\uffff\1\57\101\uffff\27\57\1\uffff\37\57"+
            "\1\uffff\u1f08\57\u1040\uffff\u0150\57\u0170\uffff\u0080\57"+
            "\u0080\uffff\u092e\57\u10d2\uffff\u5200\57\u5900\uffff\u0200"+
            "\57",
            "",
            "",
            "\1\u0151",
            "\1\u0152",
            "",
            "",
            "\1\57\11\uffff\12\57\5\uffff\1\57\1\uffff\32\57\3\uffff\2"+
            "\57\1\uffff\32\57\3\uffff\1\57\101\uffff\27\57\1\uffff\37\57"+
            "\1\uffff\u1f08\57\u1040\uffff\u0150\57\u0170\uffff\u0080\57"+
            "\u0080\uffff\u092e\57\u10d2\uffff\u5200\57\u5900\uffff\u0200"+
            "\57",
            "\1\u0155\12\uffff\1\u0154\5\uffff\1\u0156",
            "\1\57\11\uffff\12\57\5\uffff\1\57\1\uffff\32\57\3\uffff\2"+
            "\57\1\uffff\32\57\3\uffff\1\57\101\uffff\27\57\1\uffff\37\57"+
            "\1\uffff\u1f08\57\u1040\uffff\u0150\57\u0170\uffff\u0080\57"+
            "\u0080\uffff\u092e\57\u10d2\uffff\u5200\57\u5900\uffff\u0200"+
            "\57",
            "\1\u0158",
            "",
            "\1\u0159",
            "\1\57\11\uffff\12\57\5\uffff\1\57\1\uffff\32\57\3\uffff\2"+
            "\57\1\uffff\32\57\3\uffff\1\57\101\uffff\27\57\1\uffff\37\57"+
            "\1\uffff\u1f08\57\u1040\uffff\u0150\57\u0170\uffff\u0080\57"+
            "\u0080\uffff\u092e\57\u10d2\uffff\u5200\57\u5900\uffff\u0200"+
            "\57",
            "",
            "\1\u015b",
            "\1\u015c",
            "\1\u015d",
            "",
            "\1\57\11\uffff\12\57\5\uffff\1\57\1\uffff\32\57\3\uffff\2"+
            "\57\1\uffff\32\57\3\uffff\1\57\101\uffff\27\57\1\uffff\37\57"+
            "\1\uffff\u1f08\57\u1040\uffff\u0150\57\u0170\uffff\u0080\57"+
            "\u0080\uffff\u092e\57\u10d2\uffff\u5200\57\u5900\uffff\u0200"+
            "\57",
            "\1\u015f",
            "",
            "\1\u0160",
            "\1\u0161",
            "\1\u0162",
            "",
            "\1\u0163",
            "\1\57\11\uffff\12\57\5\uffff\1\57\1\uffff\32\57\3\uffff\2"+
            "\57\1\uffff\32\57\3\uffff\1\57\101\uffff\27\57\1\uffff\37\57"+
            "\1\uffff\u1f08\57\u1040\uffff\u0150\57\u0170\uffff\u0080\57"+
            "\u0080\uffff\u092e\57\u10d2\uffff\u5200\57\u5900\uffff\u0200"+
            "\57",
            "\1\57\11\uffff\12\57\5\uffff\1\57\1\uffff\32\57\3\uffff\2"+
            "\57\1\uffff\32\57\3\uffff\1\57\101\uffff\27\57\1\uffff\37\57"+
            "\1\uffff\u1f08\57\u1040\uffff\u0150\57\u0170\uffff\u0080\57"+
            "\u0080\uffff\u092e\57\u10d2\uffff\u5200\57\u5900\uffff\u0200"+
            "\57",
            "\1\57\11\uffff\12\57\5\uffff\1\57\1\uffff\32\57\3\uffff\2"+
            "\57\1\uffff\32\57\3\uffff\1\57\101\uffff\27\57\1\uffff\37\57"+
            "\1\uffff\u1f08\57\u1040\uffff\u0150\57\u0170\uffff\u0080\57"+
            "\u0080\uffff\u092e\57\u10d2\uffff\u5200\57\u5900\uffff\u0200"+
            "\57",
            "\1\u0167",
            "",
            "",
            "",
            "\1\57\11\uffff\12\57\5\uffff\1\57\1\uffff\32\57\3\uffff\2"+
            "\57\1\uffff\32\57\3\uffff\1\57\101\uffff\27\57\1\uffff\37\57"+
            "\1\uffff\u1f08\57\u1040\uffff\u0150\57\u0170\uffff\u0080\57"+
            "\u0080\uffff\u092e\57\u10d2\uffff\u5200\57\u5900\uffff\u0200"+
            "\57",
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
            return "1:1: Tokens : ( T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | T__104 | T__105 | T__106 | T__107 | T__108 | T__109 | T__110 | T__111 | T__112 | T__113 | T__114 | T__115 | T__116 | T__117 | T__118 | T__119 | T__120 | T__121 | T__122 | T__123 | T__124 | T__125 | T__126 | T__127 | T__128 | T__129 | T__130 | T__131 | T__132 | T__133 | T__134 | T__135 | T__136 | T__137 | T__138 | T__139 | T__140 | T__141 | T__142 | T__143 | T__144 | T__145 | T__146 | T__147 | T__148 | T__149 | T__150 | T__151 | T__152 | T__153 | T__154 | T__155 | T__156 | T__157 | T__158 | T__159 | T__160 | T__161 | T__162 | T__163 | T__164 | T__165 | T__166 | T__167 | T__168 | T__169 | T__170 | T__171 | T__172 | T__173 | T__174 | T__175 | T__176 | T__177 | EolLexerRules. Tokens );";
        }
    }
 

}