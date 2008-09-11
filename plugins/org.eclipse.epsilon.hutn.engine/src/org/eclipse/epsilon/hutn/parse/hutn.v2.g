header {
package org.epsilon.hutn.parse;

import java.util.List;
import java.util.ArrayList;

import org.epsilon.commons.parse.problem.ParseProblem;
}

class HutnParser extends Parser;

options {
        buildAST=true;
}

{
	private List<ParseProblem> problems = new ArrayList();
	
	public List<ParseProblem> getParseProblems() {
		return problems;
	}
	
	public void reportError(RecognitionException ex) {
		problems.add(new ParseProblem(ex, ParseProblem.ERROR));
	}

	public void reportError(String s) {
		problems.add(new ParseProblem(s, ParseProblem.ERROR));
	}

	public void reportWarning(String s) {
		problems.add(new ParseProblem(s, ParseProblem.WARNING));
	}
}

document: (pkg)*;

pkg: NAME^ LBRACKET! (cls)* RBRACKET!;      

cls: (ADJECTIVE)* NAME^ (TEXTUAL_VALUE)? LBRACKET! (cls_contents)* RBRACKET!;

cls_contents: (feature | ADJECTIVE);

feature: NAME^ (COLON!|EQUALS!) (attr | refs);

attr: (attr_value (COMMA! attr_value)*) | NULL;

attr_value: TEXTUAL_VALUE|NUMERIC_VALUE|bool;

bool: TRUE | FALSE;

refs: ref (COMMA! ref)*;

ref: (ADJECTIVE)* NAME^ TEXTUAL_VALUE (LBRACKET! (cls_contents)* RBRACKET!)?;


class HutnLexer extends Lexer;

options {
    k=2; // needed for newline junk
    charVocabulary='\u0000'..'\u007F'; // allow ascii
    testLiterals=true;
}

tokens {
     TRUE  = "true";
     FALSE = "false";
     NULL  = "null";
}

COMMA        : ',';
LBRACKET     : '{';
RBRACKET     : '}';
COLON        : ':';
EQUALS       : '=';
NAME         : ID_START_LETTER (ID_LETTER)*;
TEXTUAL_VALUE: '"' (TEXT_LETTER)+ '"';
NUMERIC_VALUE: ('-'|'+')? (DIGIT)+ ('.' (DIGIT)+)?;
ADJECTIVE    : ('~'|'#') NAME;

SL_COMMENT
	:	"//"
		(~(	'\r'
		|	'\n'
		))*
		({LA(1) != EOF_CHAR}? NL)?

	{$setType(Token.SKIP);}
;

ML_COMMENT
  : "/*"
    (               /* '\r' '\n' can be matched in one alternative or by matching
                       '\r' in one iteration and '\n' in another. I am trying to
                       handle any flavor of newline that comes in, but the language
                       that allows both "\r\n" and "\r" and "\n" to all be valid
                       newline is ambiguous. Consequently, the resulting grammar
                       must be ambiguous. I'm shutting this warning off.
                    */
      options {
        generateAmbigWarnings=false;
      }
      :  { LA(2)!='/' }? '*'
      | '\r' '\n' {newline();}
      | '\r' {newline();}
      | '\n' {newline();}
      | ~('*'|'\n'|'\r')
    )*
    "*/"
    {$setType(Token.SKIP);}
;


protected
NL
	:	(	'\r' '\n'
		|	'\n' '\r'  //Improbable
		|	'\r'
		|	'\n'
		)
	{newline();}
	;

WS
	:	(	' '
		| 	TAB
		|	NL
		)
	{ $setType(Token.SKIP); }
	;

protected
TAB
	:	'\t'
	{setColumn(getColumn()-tabsize + 1);}
	;   

protected
ID_START_LETTER
	:    '_'
    |    'a'..'z'
    |    'A'..'Z'
    |    '@'
    ;

protected
ID_LETTER
    :    ID_START_LETTER
    |    '0'..'9'
    |    '-'
    ;
    
protected
TEXT_LETTER
    :    ID_LETTER
    |    '\\'
    |    '/'
    |    ':'
    |    '.'
    |    ' '
    ;
    
protected
DIGIT : '0'..'9';