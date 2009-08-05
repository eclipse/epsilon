package org.eclipse.epsilon.migration.parse;

// $ANTLR 3.1b1 EolLexerRules.g 2009-08-05 11:01:13

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
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
public class Migration_EolLexerRules extends Lexer {
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
    public static final int STRATEGY=63;
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
    // delegators
    public MigrationLexer gMigration;

    public Migration_EolLexerRules() {;} 
    public Migration_EolLexerRules(CharStream input, MigrationLexer gMigration) {
        this(input, new RecognizerSharedState(), gMigration);
    }
    public Migration_EolLexerRules(CharStream input, RecognizerSharedState state, MigrationLexer gMigration) {
        super(input,state);

        this.gMigration = gMigration;
    }
    public String getGrammarFileName() { return "EolLexerRules.g"; }

    // $ANTLR start DIGIT
    public final void mDIGIT() throws RecognitionException {
        try {
            // EolLexerRules.g:58:7: ( '0' .. '9' )
            // EolLexerRules.g:58:9: '0' .. '9'
            {
            matchRange('0','9'); if (state.failed) return ;

            }

        }
        finally {
        }
    }
    // $ANTLR end DIGIT

    // $ANTLR start INT
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // EolLexerRules.g:60:5: ( ( DIGIT )+ ( ( '.' DIGIT )=> '.' ( DIGIT )+ ( 'd' | 'f' )? )? )
            // EolLexerRules.g:60:7: ( DIGIT )+ ( ( '.' DIGIT )=> '.' ( DIGIT )+ ( 'd' | 'f' )? )?
            {
            // EolLexerRules.g:60:7: ( DIGIT )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // EolLexerRules.g:60:8: DIGIT
            	    {
            	    mDIGIT(); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);

            // EolLexerRules.g:60:16: ( ( '.' DIGIT )=> '.' ( DIGIT )+ ( 'd' | 'f' )? )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='.') && (synpred1_EolLexerRules())) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // EolLexerRules.g:60:17: ( '.' DIGIT )=> '.' ( DIGIT )+ ( 'd' | 'f' )?
                    {
                    match('.'); if (state.failed) return ;
                    // EolLexerRules.g:60:34: ( DIGIT )+
                    int cnt2=0;
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( ((LA2_0>='0' && LA2_0<='9')) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // EolLexerRules.g:60:35: DIGIT
                    	    {
                    	    mDIGIT(); if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt2 >= 1 ) break loop2;
                    	    if (state.backtracking>0) {state.failed=true; return ;}
                                EarlyExitException eee =
                                    new EarlyExitException(2, input);
                                throw eee;
                        }
                        cnt2++;
                    } while (true);

                    if ( state.backtracking==0 ) {
                      _type = FLOAT;
                    }
                    // EolLexerRules.g:60:60: ( 'd' | 'f' )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0=='d'||LA3_0=='f') ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // EolLexerRules.g:
                            {
                            if ( input.LA(1)=='d'||input.LA(1)=='f' ) {
                                input.consume();
                            state.failed=false;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return ;}
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                recover(mse);
                                throw mse;}


                            }
                            break;

                    }


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end INT

    // $ANTLR start POINT
    public final void mPOINT() throws RecognitionException {
        try {
            int _type = POINT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // EolLexerRules.g:64:7: ( '.' )
            // EolLexerRules.g:64:9: '.'
            {
            match('.'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end POINT

    // $ANTLR start POINT_POINT
    public final void mPOINT_POINT() throws RecognitionException {
        try {
            int _type = POINT_POINT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // EolLexerRules.g:66:13: ( '..' )
            // EolLexerRules.g:66:15: '..'
            {
            match(".."); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end POINT_POINT

    // $ANTLR start ARROW
    public final void mARROW() throws RecognitionException {
        try {
            int _type = ARROW;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // EolLexerRules.g:68:7: ( '->' )
            // EolLexerRules.g:68:9: '->'
            {
            match("->"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end ARROW

    // $ANTLR start BOOLEAN
    public final void mBOOLEAN() throws RecognitionException {
        try {
            int _type = BOOLEAN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // EolLexerRules.g:83:9: ( ( 'true' | 'false' ) )
            // EolLexerRules.g:84:2: ( 'true' | 'false' )
            {
            // EolLexerRules.g:84:2: ( 'true' | 'false' )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='t') ) {
                alt5=1;
            }
            else if ( (LA5_0=='f') ) {
                alt5=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // EolLexerRules.g:84:3: 'true'
                    {
                    match("true"); if (state.failed) return ;


                    }
                    break;
                case 2 :
                    // EolLexerRules.g:84:12: 'false'
                    {
                    match("false"); if (state.failed) return ;


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end BOOLEAN

    // $ANTLR start STRING
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // EolLexerRules.g:88:5: ( '\\'' ( EscapeSequence | ~ ( '\\'' | '\\\\' ) )* '\\'' )
            // EolLexerRules.g:88:9: '\\'' ( EscapeSequence | ~ ( '\\'' | '\\\\' ) )* '\\''
            {
            match('\''); if (state.failed) return ;
            // EolLexerRules.g:88:14: ( EscapeSequence | ~ ( '\\'' | '\\\\' ) )*
            loop6:
            do {
                int alt6=3;
                int LA6_0 = input.LA(1);

                if ( (LA6_0=='\\') ) {
                    alt6=1;
                }
                else if ( ((LA6_0>='\u0000' && LA6_0<='&')||(LA6_0>='(' && LA6_0<='[')||(LA6_0>=']' && LA6_0<='\uFFFE')) ) {
                    alt6=2;
                }


                switch (alt6) {
            	case 1 :
            	    // EolLexerRules.g:88:16: EscapeSequence
            	    {
            	    mEscapeSequence(); if (state.failed) return ;

            	    }
            	    break;
            	case 2 :
            	    // EolLexerRules.g:88:33: ~ ( '\\'' | '\\\\' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFE') ) {
            	        input.consume();
            	    state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            match('\''); if (state.failed) return ;
            if ( state.backtracking==0 ) {
              setText(getText().substring(1,getText().length() - 1));
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end STRING

    // $ANTLR start StrangeNameLiteral
    public final void mStrangeNameLiteral() throws RecognitionException {
        try {
            int _type = StrangeNameLiteral;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // EolLexerRules.g:93:5: ( '\"' ( EscapeSequence | ~ ( '\\\\' | '\"' ) )* '\"' )
            // EolLexerRules.g:93:8: '\"' ( EscapeSequence | ~ ( '\\\\' | '\"' ) )* '\"'
            {
            match('\"'); if (state.failed) return ;
            // EolLexerRules.g:93:12: ( EscapeSequence | ~ ( '\\\\' | '\"' ) )*
            loop7:
            do {
                int alt7=3;
                int LA7_0 = input.LA(1);

                if ( (LA7_0=='\\') ) {
                    alt7=1;
                }
                else if ( ((LA7_0>='\u0000' && LA7_0<='!')||(LA7_0>='#' && LA7_0<='[')||(LA7_0>=']' && LA7_0<='\uFFFE')) ) {
                    alt7=2;
                }


                switch (alt7) {
            	case 1 :
            	    // EolLexerRules.g:93:14: EscapeSequence
            	    {
            	    mEscapeSequence(); if (state.failed) return ;

            	    }
            	    break;
            	case 2 :
            	    // EolLexerRules.g:93:31: ~ ( '\\\\' | '\"' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFE') ) {
            	        input.consume();
            	    state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            match('\"'); if (state.failed) return ;
            if ( state.backtracking==0 ) {
              _type=NAME; setText(getText().substring(1,getText().length() - 1));
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end StrangeNameLiteral

    // $ANTLR start EscapeSequence
    public final void mEscapeSequence() throws RecognitionException {
        try {
            // EolLexerRules.g:99:5: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) )
            // EolLexerRules.g:99:9: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
            {
            match('\\'); if (state.failed) return ;
            if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
                input.consume();
            state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end EscapeSequence

    // $ANTLR start NAME
    public final void mNAME() throws RecognitionException {
        try {
            int _type = NAME;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // EolLexerRules.g:134:5: ( ( '~' )? Letter ( Letter | JavaIDDigit )* )
            // EolLexerRules.g:134:9: ( '~' )? Letter ( Letter | JavaIDDigit )*
            {
            // EolLexerRules.g:134:9: ( '~' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='~') ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // EolLexerRules.g:134:10: '~'
                    {
                    match('~'); if (state.failed) return ;

                    }
                    break;

            }

            mLetter(); if (state.failed) return ;
            // EolLexerRules.g:134:23: ( Letter | JavaIDDigit )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>='0' && LA9_0<='9')||(LA9_0>='A' && LA9_0<='Z')||LA9_0=='_'||(LA9_0>='a' && LA9_0<='z')||(LA9_0>='\u00C0' && LA9_0<='\u00D6')||(LA9_0>='\u00D8' && LA9_0<='\u00F6')||(LA9_0>='\u00F8' && LA9_0<='\u1FFF')||(LA9_0>='\u3040' && LA9_0<='\u318F')||(LA9_0>='\u3300' && LA9_0<='\u337F')||(LA9_0>='\u3400' && LA9_0<='\u3D2D')||(LA9_0>='\u4E00' && LA9_0<='\u9FFF')||(LA9_0>='\uF900' && LA9_0<='\uFAFF')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // EolLexerRules.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z')||(input.LA(1)>='\u00C0' && input.LA(1)<='\u00D6')||(input.LA(1)>='\u00D8' && input.LA(1)<='\u00F6')||(input.LA(1)>='\u00F8' && input.LA(1)<='\u1FFF')||(input.LA(1)>='\u3040' && input.LA(1)<='\u318F')||(input.LA(1)>='\u3300' && input.LA(1)<='\u337F')||(input.LA(1)>='\u3400' && input.LA(1)<='\u3D2D')||(input.LA(1)>='\u4E00' && input.LA(1)<='\u9FFF')||(input.LA(1)>='\uF900' && input.LA(1)<='\uFAFF') ) {
            	        input.consume();
            	    state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end NAME

    // $ANTLR start Letter
    public final void mLetter() throws RecognitionException {
        try {
            // EolLexerRules.g:143:5: ( '\\u0041' .. '\\u005a' | '\\u005f' | '\\u0061' .. '\\u007a' | '\\u00c0' .. '\\u00d6' | '\\u00d8' .. '\\u00f6' | '\\u00f8' .. '\\u00ff' | '\\u0100' .. '\\u1fff' | '\\u3040' .. '\\u318f' | '\\u3300' .. '\\u337f' | '\\u3400' .. '\\u3d2d' | '\\u4e00' .. '\\u9fff' | '\\uf900' .. '\\ufaff' )
            // EolLexerRules.g:
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z')||(input.LA(1)>='\u00C0' && input.LA(1)<='\u00D6')||(input.LA(1)>='\u00D8' && input.LA(1)<='\u00F6')||(input.LA(1)>='\u00F8' && input.LA(1)<='\u1FFF')||(input.LA(1)>='\u3040' && input.LA(1)<='\u318F')||(input.LA(1)>='\u3300' && input.LA(1)<='\u337F')||(input.LA(1)>='\u3400' && input.LA(1)<='\u3D2D')||(input.LA(1)>='\u4E00' && input.LA(1)<='\u9FFF')||(input.LA(1)>='\uF900' && input.LA(1)<='\uFAFF') ) {
                input.consume();
            state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end Letter

    // $ANTLR start JavaIDDigit
    public final void mJavaIDDigit() throws RecognitionException {
        try {
            // EolLexerRules.g:159:5: ( '\\u0030' .. '\\u0039' | '\\u0660' .. '\\u0669' | '\\u06f0' .. '\\u06f9' | '\\u0966' .. '\\u096f' | '\\u09e6' .. '\\u09ef' | '\\u0a66' .. '\\u0a6f' | '\\u0ae6' .. '\\u0aef' | '\\u0b66' .. '\\u0b6f' | '\\u0be7' .. '\\u0bef' | '\\u0c66' .. '\\u0c6f' | '\\u0ce6' .. '\\u0cef' | '\\u0d66' .. '\\u0d6f' | '\\u0e50' .. '\\u0e59' | '\\u0ed0' .. '\\u0ed9' | '\\u1040' .. '\\u1049' )
            // EolLexerRules.g:
            {
            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='\u0660' && input.LA(1)<='\u0669')||(input.LA(1)>='\u06F0' && input.LA(1)<='\u06F9')||(input.LA(1)>='\u0966' && input.LA(1)<='\u096F')||(input.LA(1)>='\u09E6' && input.LA(1)<='\u09EF')||(input.LA(1)>='\u0A66' && input.LA(1)<='\u0A6F')||(input.LA(1)>='\u0AE6' && input.LA(1)<='\u0AEF')||(input.LA(1)>='\u0B66' && input.LA(1)<='\u0B6F')||(input.LA(1)>='\u0BE7' && input.LA(1)<='\u0BEF')||(input.LA(1)>='\u0C66' && input.LA(1)<='\u0C6F')||(input.LA(1)>='\u0CE6' && input.LA(1)<='\u0CEF')||(input.LA(1)>='\u0D66' && input.LA(1)<='\u0D6F')||(input.LA(1)>='\u0E50' && input.LA(1)<='\u0E59')||(input.LA(1)>='\u0ED0' && input.LA(1)<='\u0ED9')||(input.LA(1)>='\u1040' && input.LA(1)<='\u1049') ) {
                input.consume();
            state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end JavaIDDigit

    // $ANTLR start WS
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // EolLexerRules.g:176:5: ( ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' ) )
            // EolLexerRules.g:176:8: ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' )
            {
            // EolLexerRules.g:176:8: ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' )
            int alt10=5;
            switch ( input.LA(1) ) {
            case ' ':
                {
                alt10=1;
                }
                break;
            case '\r':
                {
                alt10=2;
                }
                break;
            case '\t':
                {
                alt10=3;
                }
                break;
            case '\f':
                {
                alt10=4;
                }
                break;
            case '\n':
                {
                alt10=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // EolLexerRules.g:177:2: ' '
                    {
                    match(' '); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // EolLexerRules.g:178:2: '\\r'
                    {
                    match('\r'); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // EolLexerRules.g:179:2: '\\t'
                    {
                    match('\t'); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      input.setCharPositionInLine(input.getCharPositionInLine() + 3);
                    }

                    }
                    break;
                case 4 :
                    // EolLexerRules.g:180:3: '\\u000C'
                    {
                    match('\f'); if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // EolLexerRules.g:181:3: '\\n'
                    {
                    match('\n'); if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _channel=HIDDEN;
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end WS

    // $ANTLR start COMMENT
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // EolLexerRules.g:186:5: ( '-*' ( options {greedy=false; } : . )* '*-' )
            // EolLexerRules.g:186:9: '-*' ( options {greedy=false; } : . )* '*-'
            {
            match("-*"); if (state.failed) return ;

            // EolLexerRules.g:186:14: ( options {greedy=false; } : . )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0=='*') ) {
                    int LA11_1 = input.LA(2);

                    if ( (LA11_1=='-') ) {
                        alt11=2;
                    }
                    else if ( ((LA11_1>='\u0000' && LA11_1<=',')||(LA11_1>='.' && LA11_1<='\uFFFE')) ) {
                        alt11=1;
                    }


                }
                else if ( ((LA11_0>='\u0000' && LA11_0<=')')||(LA11_0>='+' && LA11_0<='\uFFFE')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // EolLexerRules.g:186:42: .
            	    {
            	    matchAny(); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            match("*-"); if (state.failed) return ;

            if ( state.backtracking==0 ) {
              _channel=HIDDEN;
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end COMMENT

    // $ANTLR start LINE_COMMENT
    public final void mLINE_COMMENT() throws RecognitionException {
        try {
            int _type = LINE_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // EolLexerRules.g:190:5: ( '--' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
            // EolLexerRules.g:190:7: '--' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
            {
            match("--"); if (state.failed) return ;

            // EolLexerRules.g:190:12: (~ ( '\\n' | '\\r' ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>='\u0000' && LA12_0<='\t')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='\uFFFE')) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // EolLexerRules.g:190:12: ~ ( '\\n' | '\\r' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFE') ) {
            	        input.consume();
            	    state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            // EolLexerRules.g:190:26: ( '\\r' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0=='\r') ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // EolLexerRules.g:190:26: '\\r'
                    {
                    match('\r'); if (state.failed) return ;

                    }
                    break;

            }

            match('\n'); if (state.failed) return ;
            if ( state.backtracking==0 ) {
              _channel=HIDDEN;
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end LINE_COMMENT

    // $ANTLR start Annotation
    public final void mAnnotation() throws RecognitionException {
        try {
            int _type = Annotation;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // EolLexerRules.g:194:2: ( '@' (~ ( '\\n' | '\\r' ) )* )
            // EolLexerRules.g:194:4: '@' (~ ( '\\n' | '\\r' ) )*
            {
            match('@'); if (state.failed) return ;
            // EolLexerRules.g:194:8: (~ ( '\\n' | '\\r' ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>='\u0000' && LA14_0<='\t')||(LA14_0>='\u000B' && LA14_0<='\f')||(LA14_0>='\u000E' && LA14_0<='\uFFFE')) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // EolLexerRules.g:194:8: ~ ( '\\n' | '\\r' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFE') ) {
            	        input.consume();
            	    state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end Annotation

    public void mTokens() throws RecognitionException {
        // EolLexerRules.g:1:8: ( INT | POINT | POINT_POINT | ARROW | BOOLEAN | STRING | StrangeNameLiteral | NAME | WS | COMMENT | LINE_COMMENT | Annotation )
        int alt15=12;
        alt15 = dfa15.predict(input);
        switch (alt15) {
            case 1 :
                // EolLexerRules.g:1:10: INT
                {
                mINT(); if (state.failed) return ;

                }
                break;
            case 2 :
                // EolLexerRules.g:1:14: POINT
                {
                mPOINT(); if (state.failed) return ;

                }
                break;
            case 3 :
                // EolLexerRules.g:1:20: POINT_POINT
                {
                mPOINT_POINT(); if (state.failed) return ;

                }
                break;
            case 4 :
                // EolLexerRules.g:1:32: ARROW
                {
                mARROW(); if (state.failed) return ;

                }
                break;
            case 5 :
                // EolLexerRules.g:1:38: BOOLEAN
                {
                mBOOLEAN(); if (state.failed) return ;

                }
                break;
            case 6 :
                // EolLexerRules.g:1:46: STRING
                {
                mSTRING(); if (state.failed) return ;

                }
                break;
            case 7 :
                // EolLexerRules.g:1:53: StrangeNameLiteral
                {
                mStrangeNameLiteral(); if (state.failed) return ;

                }
                break;
            case 8 :
                // EolLexerRules.g:1:72: NAME
                {
                mNAME(); if (state.failed) return ;

                }
                break;
            case 9 :
                // EolLexerRules.g:1:77: WS
                {
                mWS(); if (state.failed) return ;

                }
                break;
            case 10 :
                // EolLexerRules.g:1:80: COMMENT
                {
                mCOMMENT(); if (state.failed) return ;

                }
                break;
            case 11 :
                // EolLexerRules.g:1:88: LINE_COMMENT
                {
                mLINE_COMMENT(); if (state.failed) return ;

                }
                break;
            case 12 :
                // EolLexerRules.g:1:101: Annotation
                {
                mAnnotation(); if (state.failed) return ;

                }
                break;

        }

    }

    // $ANTLR start synpred1_EolLexerRules
    public final void synpred1_EolLexerRules_fragment() throws RecognitionException {   
        // EolLexerRules.g:60:17: ( '.' DIGIT )
        // EolLexerRules.g:60:18: '.' DIGIT
        {
        match('.'); if (state.failed) return ;
        mDIGIT(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_EolLexerRules

    public final boolean synpred1_EolLexerRules() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_EolLexerRules_fragment(); // can never throw exception
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
    static final String DFA15_eotS =
        "\2\uffff\1\14\1\uffff\2\10\12\uffff\4\10\1\26\1\10\1\uffff\1\26";
    static final String DFA15_eofS =
        "\30\uffff";
    static final String DFA15_minS =
        "\1\11\1\uffff\1\56\1\52\1\162\1\141\12\uffff\1\165\1\154\1\145\1"+
        "\163\1\60\1\145\1\uffff\1\60";
    static final String DFA15_maxS =
        "\1\ufaff\1\uffff\1\56\1\76\1\162\1\141\12\uffff\1\165\1\154\1\145"+
        "\1\163\1\ufaff\1\145\1\uffff\1\ufaff";
    static final String DFA15_acceptS =
        "\1\uffff\1\1\4\uffff\1\6\1\7\1\10\1\11\1\14\1\3\1\2\1\4\1\12\1\13"+
        "\6\uffff\1\5\1\uffff";
    static final String DFA15_specialS =
        "\30\uffff}>";
    static final String[] DFA15_transitionS = {
            "\2\11\1\uffff\2\11\22\uffff\1\11\1\uffff\1\7\4\uffff\1\6\5\uffff"+
            "\1\3\1\2\1\uffff\12\1\6\uffff\1\12\32\10\4\uffff\1\10\1\uffff"+
            "\5\10\1\5\15\10\1\4\6\10\3\uffff\1\10\101\uffff\27\10\1\uffff"+
            "\37\10\1\uffff\u1f08\10\u1040\uffff\u0150\10\u0170\uffff\u0080"+
            "\10\u0080\uffff\u092e\10\u10d2\uffff\u5200\10\u5900\uffff\u0200"+
            "\10",
            "",
            "\1\13",
            "\1\16\2\uffff\1\17\20\uffff\1\15",
            "\1\20",
            "\1\21",
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
            "\1\22",
            "\1\23",
            "\1\24",
            "\1\25",
            "\12\10\7\uffff\32\10\4\uffff\1\10\1\uffff\32\10\105\uffff\27"+
            "\10\1\uffff\37\10\1\uffff\u1f08\10\u1040\uffff\u0150\10\u0170"+
            "\uffff\u0080\10\u0080\uffff\u092e\10\u10d2\uffff\u5200\10\u5900"+
            "\uffff\u0200\10",
            "\1\27",
            "",
            "\12\10\7\uffff\32\10\4\uffff\1\10\1\uffff\32\10\105\uffff\27"+
            "\10\1\uffff\37\10\1\uffff\u1f08\10\u1040\uffff\u0150\10\u0170"+
            "\uffff\u0080\10\u0080\uffff\u092e\10\u10d2\uffff\u5200\10\u5900"+
            "\uffff\u0200\10"
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
            return "1:1: Tokens : ( INT | POINT | POINT_POINT | ARROW | BOOLEAN | STRING | StrangeNameLiteral | NAME | WS | COMMENT | LINE_COMMENT | Annotation );";
        }
    }
 

}