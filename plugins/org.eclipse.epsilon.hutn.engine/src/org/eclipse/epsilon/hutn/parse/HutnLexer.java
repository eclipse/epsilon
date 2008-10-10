// $ANTLR 3.1b1 /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g 2008-10-09 14:15:18

/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
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
package org.eclipse.epsilon.hutn.parse;	


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class HutnLexer extends Lexer {
    public static final int ID_START_LETTER=19;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int ID_LETTER=20;
    public static final int CLS_LVL_ATTRIBUTE=8;
    public static final int NULL=6;
    public static final int REFERENCE=10;
    public static final int ADJECTIVE_PREFIX=16;
    public static final int EOF=-1;
    public static final int TRUE=4;
    public static final int LBRACKET=13;
    public static final int ML_COMMENT=24;
    public static final int NAME=11;
    public static final int WS=23;
    public static final int NUMERIC_VALUE=18;
    public static final int TEXTUAL_VALUE=12;
    public static final int COMMA=17;
    public static final int SL_COMMENT=25;
    public static final int ASSIGNMENT=15;
    public static final int DIGIT=22;
    public static final int RBRACKET=14;
    public static final int ADJECTIVE=7;
    public static final int FALSE=5;
    public static final int ASSOC_INSTANCE=9;
    public static final int TEXT_LETTER=21;

    // delegates
    // delegators

    public HutnLexer() {;} 
    public HutnLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public HutnLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "/local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g"; }

    // $ANTLR start TRUE
    public final void mTRUE() throws RecognitionException {
        try {
            int _type = TRUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:44:6: ( 'true' )
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:44:8: 'true'
            {
            match("true"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end TRUE

    // $ANTLR start FALSE
    public final void mFALSE() throws RecognitionException {
        try {
            int _type = FALSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:45:7: ( 'false' )
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:45:9: 'false'
            {
            match("false"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end FALSE

    // $ANTLR start NULL
    public final void mNULL() throws RecognitionException {
        try {
            int _type = NULL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:46:6: ( 'null' )
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:46:8: 'null'
            {
            match("null"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end NULL

    // $ANTLR start T__26
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:47:7: ( ';' )
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:47:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__26

    // $ANTLR start T__27
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:48:7: ( '.' )
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:48:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__27

    // $ANTLR start COMMA
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:154:14: ( ',' )
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:154:16: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end COMMA

    // $ANTLR start LBRACKET
    public final void mLBRACKET() throws RecognitionException {
        try {
            int _type = LBRACKET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:155:14: ( '{' )
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:155:16: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end LBRACKET

    // $ANTLR start RBRACKET
    public final void mRBRACKET() throws RecognitionException {
        try {
            int _type = RBRACKET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:156:14: ( '}' )
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:156:16: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end RBRACKET

    // $ANTLR start ASSIGNMENT
    public final void mASSIGNMENT() throws RecognitionException {
        try {
            int _type = ASSIGNMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:157:13: ( ':' | '=' )
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:
            {
            if ( input.LA(1)==':'||input.LA(1)=='=' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end ASSIGNMENT

    // $ANTLR start NAME
    public final void mNAME() throws RecognitionException {
        try {
            int _type = NAME;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:158:14: ( ID_START_LETTER ( ID_LETTER )* )
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:158:16: ID_START_LETTER ( ID_LETTER )*
            {
            mID_START_LETTER(); 
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:158:32: ( ID_LETTER )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='#'||LA1_0=='-'||(LA1_0>='0' && LA1_0<='9')||(LA1_0>='@' && LA1_0<='Z')||LA1_0=='_'||(LA1_0>='a' && LA1_0<='z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:158:32: ID_LETTER
            	    {
            	    mID_LETTER(); 

            	    }
            	    break;

            	default :
            	    break loop1;
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

    // $ANTLR start TEXTUAL_VALUE
    public final void mTEXTUAL_VALUE() throws RecognitionException {
        try {
            int _type = TEXTUAL_VALUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:159:14: ( '\"' ( TEXT_LETTER )+ '\"' )
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:159:16: '\"' ( TEXT_LETTER )+ '\"'
            {
            match('\"'); 
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:159:20: ( TEXT_LETTER )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==' '||LA2_0=='#'||(LA2_0>='-' && LA2_0<=':')||(LA2_0>='@' && LA2_0<='Z')||LA2_0=='\\'||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:159:20: TEXT_LETTER
            	    {
            	    mTEXT_LETTER(); 

            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);

            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end TEXTUAL_VALUE

    // $ANTLR start NUMERIC_VALUE
    public final void mNUMERIC_VALUE() throws RecognitionException {
        try {
            int _type = NUMERIC_VALUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:160:14: ( ( '-' | '+' )? ( DIGIT )+ ( '.' ( DIGIT )+ )? )
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:160:16: ( '-' | '+' )? ( DIGIT )+ ( '.' ( DIGIT )+ )?
            {
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:160:16: ( '-' | '+' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='+'||LA3_0=='-') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }

            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:160:27: ( DIGIT )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:160:27: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);

            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:160:34: ( '.' ( DIGIT )+ )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='.') ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:160:35: '.' ( DIGIT )+
                    {
                    match('.'); 
                    // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:160:39: ( DIGIT )+
                    int cnt5=0;
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:160:39: DIGIT
                    	    {
                    	    mDIGIT(); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt5 >= 1 ) break loop5;
                                EarlyExitException eee =
                                    new EarlyExitException(5, input);
                                throw eee;
                        }
                        cnt5++;
                    } while (true);


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
    // $ANTLR end NUMERIC_VALUE

    // $ANTLR start ADJECTIVE_PREFIX
    public final void mADJECTIVE_PREFIX() throws RecognitionException {
        try {
            int _type = ADJECTIVE_PREFIX;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:161:17: ( '~' | '#' )
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:
            {
            if ( input.LA(1)=='#'||input.LA(1)=='~' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end ADJECTIVE_PREFIX

    // $ANTLR start WS
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:163:5: ( ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' ) )
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:163:8: ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' )
            {
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:163:8: ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' )
            int alt7=5;
            switch ( input.LA(1) ) {
            case ' ':
                {
                alt7=1;
                }
                break;
            case '\r':
                {
                alt7=2;
                }
                break;
            case '\t':
                {
                alt7=3;
                }
                break;
            case '\f':
                {
                alt7=4;
                }
                break;
            case '\n':
                {
                alt7=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:164:2: ' '
                    {
                    match(' '); 

                    }
                    break;
                case 2 :
                    // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:165:2: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:166:2: '\\t'
                    {
                    match('\t'); 
                    input.setCharPositionInLine(input.getCharPositionInLine() + 3);

                    }
                    break;
                case 4 :
                    // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:167:3: '\\u000C'
                    {
                    match('\f'); 

                    }
                    break;
                case 5 :
                    // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:168:3: '\\n'
                    {
                    match('\n'); 

                    }
                    break;

            }

            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end WS

    // $ANTLR start ML_COMMENT
    public final void mML_COMMENT() throws RecognitionException {
        try {
            int _type = ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:173:5: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:173:9: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:173:14: ( options {greedy=false; } : . )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0=='*') ) {
                    int LA8_1 = input.LA(2);

                    if ( (LA8_1=='/') ) {
                        alt8=2;
                    }
                    else if ( ((LA8_1>='\u0000' && LA8_1<='.')||(LA8_1>='0' && LA8_1<='\uFFFE')) ) {
                        alt8=1;
                    }


                }
                else if ( ((LA8_0>='\u0000' && LA8_0<=')')||(LA8_0>='+' && LA8_0<='\uFFFE')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:173:42: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            match("*/"); 

            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end ML_COMMENT

    // $ANTLR start SL_COMMENT
    public final void mSL_COMMENT() throws RecognitionException {
        try {
            int _type = SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:177:5: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:177:7: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
            {
            match("//"); 

            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:177:12: (~ ( '\\n' | '\\r' ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>='\u0000' && LA9_0<='\t')||(LA9_0>='\u000B' && LA9_0<='\f')||(LA9_0>='\u000E' && LA9_0<='\uFFFE')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:177:12: ~ ( '\\n' | '\\r' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFE') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:177:26: ( '\\r' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\r') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:177:26: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }

            match('\n'); 
            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end SL_COMMENT

    // $ANTLR start ID_START_LETTER
    public final void mID_START_LETTER() throws RecognitionException {
        try {
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:182:2: ( '_' | 'a' .. 'z' | 'A' .. 'Z' | '@' )
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:
            {
            if ( (input.LA(1)>='@' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end ID_START_LETTER

    // $ANTLR start ID_LETTER
    public final void mID_LETTER() throws RecognitionException {
        try {
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:190:5: ( ID_START_LETTER | '0' .. '9' | '-' | '#' )
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:
            {
            if ( input.LA(1)=='#'||input.LA(1)=='-'||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='@' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end ID_LETTER

    // $ANTLR start TEXT_LETTER
    public final void mTEXT_LETTER() throws RecognitionException {
        try {
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:198:5: ( ID_LETTER | '\\\\' | '/' | ':' | '.' | ' ' )
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:
            {
            if ( input.LA(1)==' '||input.LA(1)=='#'||(input.LA(1)>='-' && input.LA(1)<=':')||(input.LA(1)>='@' && input.LA(1)<='Z')||input.LA(1)=='\\'||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end TEXT_LETTER

    // $ANTLR start DIGIT
    public final void mDIGIT() throws RecognitionException {
        try {
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:207:7: ( '0' .. '9' )
            // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:207:9: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end DIGIT

    public void mTokens() throws RecognitionException {
        // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:1:8: ( TRUE | FALSE | NULL | T__26 | T__27 | COMMA | LBRACKET | RBRACKET | ASSIGNMENT | NAME | TEXTUAL_VALUE | NUMERIC_VALUE | ADJECTIVE_PREFIX | WS | ML_COMMENT | SL_COMMENT )
        int alt11=16;
        alt11 = dfa11.predict(input);
        switch (alt11) {
            case 1 :
                // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:1:10: TRUE
                {
                mTRUE(); 

                }
                break;
            case 2 :
                // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:1:15: FALSE
                {
                mFALSE(); 

                }
                break;
            case 3 :
                // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:1:21: NULL
                {
                mNULL(); 

                }
                break;
            case 4 :
                // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:1:26: T__26
                {
                mT__26(); 

                }
                break;
            case 5 :
                // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:1:32: T__27
                {
                mT__27(); 

                }
                break;
            case 6 :
                // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:1:38: COMMA
                {
                mCOMMA(); 

                }
                break;
            case 7 :
                // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:1:44: LBRACKET
                {
                mLBRACKET(); 

                }
                break;
            case 8 :
                // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:1:53: RBRACKET
                {
                mRBRACKET(); 

                }
                break;
            case 9 :
                // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:1:62: ASSIGNMENT
                {
                mASSIGNMENT(); 

                }
                break;
            case 10 :
                // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:1:73: NAME
                {
                mNAME(); 

                }
                break;
            case 11 :
                // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:1:78: TEXTUAL_VALUE
                {
                mTEXTUAL_VALUE(); 

                }
                break;
            case 12 :
                // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:1:92: NUMERIC_VALUE
                {
                mNUMERIC_VALUE(); 

                }
                break;
            case 13 :
                // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:1:106: ADJECTIVE_PREFIX
                {
                mADJECTIVE_PREFIX(); 

                }
                break;
            case 14 :
                // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:1:123: WS
                {
                mWS(); 

                }
                break;
            case 15 :
                // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:1:126: ML_COMMENT
                {
                mML_COMMENT(); 

                }
                break;
            case 16 :
                // /local/d0p5/louis/eclipse-ide/workspaces/workspace-epsilon/org.eclipse.epsilon.hutn.engine/src/org/eclipse/epsilon/hutn/parse/Hutn.g:1:137: SL_COMMENT
                {
                mSL_COMMENT(); 

                }
                break;

        }

    }


    protected DFA11 dfa11 = new DFA11(this);
    static final String DFA11_eotS =
        "\1\uffff\3\12\14\uffff\3\12\2\uffff\3\12\1\33\1\12\1\35\1\uffff"+
        "\1\36\2\uffff";
    static final String DFA11_eofS =
        "\37\uffff";
    static final String DFA11_minS =
        "\1\11\1\162\1\141\1\165\13\uffff\1\52\1\165\2\154\2\uffff\1\145"+
        "\1\163\1\154\1\43\1\145\1\43\1\uffff\1\43\2\uffff";
    static final String DFA11_maxS =
        "\1\176\1\162\1\141\1\165\13\uffff\1\57\1\165\2\154\2\uffff\1\145"+
        "\1\163\1\154\1\172\1\145\1\172\1\uffff\1\172\2\uffff";
    static final String DFA11_acceptS =
        "\4\uffff\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\4\uffff"+
        "\1\17\1\20\6\uffff\1\1\1\uffff\1\3\1\2";
    static final String DFA11_specialS =
        "\37\uffff}>";
    static final String[] DFA11_transitionS = {
            "\2\16\1\uffff\2\16\22\uffff\1\16\1\uffff\1\13\1\15\7\uffff\1"+
            "\14\1\6\1\14\1\5\1\17\12\14\1\11\1\4\1\uffff\1\11\2\uffff\33"+
            "\12\4\uffff\1\12\1\uffff\5\12\1\2\7\12\1\3\5\12\1\1\6\12\1\7"+
            "\1\uffff\1\10\1\15",
            "\1\20",
            "\1\21",
            "\1\22",
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
            "\1\23\4\uffff\1\24",
            "\1\25",
            "\1\26",
            "\1\27",
            "",
            "",
            "\1\30",
            "\1\31",
            "\1\32",
            "\1\12\11\uffff\1\12\2\uffff\12\12\6\uffff\33\12\4\uffff\1\12"+
            "\1\uffff\32\12",
            "\1\34",
            "\1\12\11\uffff\1\12\2\uffff\12\12\6\uffff\33\12\4\uffff\1\12"+
            "\1\uffff\32\12",
            "",
            "\1\12\11\uffff\1\12\2\uffff\12\12\6\uffff\33\12\4\uffff\1\12"+
            "\1\uffff\32\12",
            "",
            ""
    };

    static final short[] DFA11_eot = DFA.unpackEncodedString(DFA11_eotS);
    static final short[] DFA11_eof = DFA.unpackEncodedString(DFA11_eofS);
    static final char[] DFA11_min = DFA.unpackEncodedStringToUnsignedChars(DFA11_minS);
    static final char[] DFA11_max = DFA.unpackEncodedStringToUnsignedChars(DFA11_maxS);
    static final short[] DFA11_accept = DFA.unpackEncodedString(DFA11_acceptS);
    static final short[] DFA11_special = DFA.unpackEncodedString(DFA11_specialS);
    static final short[][] DFA11_transition;

    static {
        int numStates = DFA11_transitionS.length;
        DFA11_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA11_transition[i] = DFA.unpackEncodedString(DFA11_transitionS[i]);
        }
    }

    class DFA11 extends DFA {

        public DFA11(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 11;
            this.eot = DFA11_eot;
            this.eof = DFA11_eof;
            this.min = DFA11_min;
            this.max = DFA11_max;
            this.accept = DFA11_accept;
            this.special = DFA11_special;
            this.transition = DFA11_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( TRUE | FALSE | NULL | T__26 | T__27 | COMMA | LBRACKET | RBRACKET | ASSIGNMENT | NAME | TEXTUAL_VALUE | NUMERIC_VALUE | ADJECTIVE_PREFIX | WS | ML_COMMENT | SL_COMMENT );";
        }
    }
 

}