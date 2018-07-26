/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.services.ActionsGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalActionsParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'set '", "' '", "'inc '", "'dec '", "'if '", "'='", "'print '", "'\"'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public InternalActionsParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalActionsParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalActionsParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g"; }



     	private ActionsGrammarAccess grammarAccess;
     	
        public InternalActionsParser(TokenStream input, ActionsGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Action";	
       	}
       	
       	@Override
       	protected ActionsGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleAction"
    // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:67:1: entryRuleAction returns [EObject current=null] : iv_ruleAction= ruleAction EOF ;
    public final EObject entryRuleAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAction = null;


        try {
            // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:68:2: (iv_ruleAction= ruleAction EOF )
            // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:69:2: iv_ruleAction= ruleAction EOF
            {
             newCompositeNode(grammarAccess.getActionRule()); 
            pushFollow(FOLLOW_ruleAction_in_entryRuleAction75);
            iv_ruleAction=ruleAction();

            state._fsp--;

             current =iv_ruleAction; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAction85); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAction"


    // $ANTLR start "ruleAction"
    // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:76:1: ruleAction returns [EObject current=null] : (this_Set_0= ruleSet | this_Inc_1= ruleInc | this_Dec_2= ruleDec | this_If_3= ruleIf | this_Print_4= rulePrint ) ;
    public final EObject ruleAction() throws RecognitionException {
        EObject current = null;

        EObject this_Set_0 = null;

        EObject this_Inc_1 = null;

        EObject this_Dec_2 = null;

        EObject this_If_3 = null;

        EObject this_Print_4 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:79:28: ( (this_Set_0= ruleSet | this_Inc_1= ruleInc | this_Dec_2= ruleDec | this_If_3= ruleIf | this_Print_4= rulePrint ) )
            // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:80:1: (this_Set_0= ruleSet | this_Inc_1= ruleInc | this_Dec_2= ruleDec | this_If_3= ruleIf | this_Print_4= rulePrint )
            {
            // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:80:1: (this_Set_0= ruleSet | this_Inc_1= ruleInc | this_Dec_2= ruleDec | this_If_3= ruleIf | this_Print_4= rulePrint )
            int alt1=5;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt1=1;
                }
                break;
            case 13:
                {
                alt1=2;
                }
                break;
            case 14:
                {
                alt1=3;
                }
                break;
            case 15:
                {
                alt1=4;
                }
                break;
            case 17:
                {
                alt1=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:81:5: this_Set_0= ruleSet
                    {
                     
                            newCompositeNode(grammarAccess.getActionAccess().getSetParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleSet_in_ruleAction132);
                    this_Set_0=ruleSet();

                    state._fsp--;

                     
                            current = this_Set_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:91:5: this_Inc_1= ruleInc
                    {
                     
                            newCompositeNode(grammarAccess.getActionAccess().getIncParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleInc_in_ruleAction159);
                    this_Inc_1=ruleInc();

                    state._fsp--;

                     
                            current = this_Inc_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:101:5: this_Dec_2= ruleDec
                    {
                     
                            newCompositeNode(grammarAccess.getActionAccess().getDecParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleDec_in_ruleAction186);
                    this_Dec_2=ruleDec();

                    state._fsp--;

                     
                            current = this_Dec_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:111:5: this_If_3= ruleIf
                    {
                     
                            newCompositeNode(grammarAccess.getActionAccess().getIfParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleIf_in_ruleAction213);
                    this_If_3=ruleIf();

                    state._fsp--;

                     
                            current = this_If_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:121:5: this_Print_4= rulePrint
                    {
                     
                            newCompositeNode(grammarAccess.getActionAccess().getPrintParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_rulePrint_in_ruleAction240);
                    this_Print_4=rulePrint();

                    state._fsp--;

                     
                            current = this_Print_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAction"


    // $ANTLR start "entryRuleSet"
    // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:137:1: entryRuleSet returns [EObject current=null] : iv_ruleSet= ruleSet EOF ;
    public final EObject entryRuleSet() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSet = null;


        try {
            // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:138:2: (iv_ruleSet= ruleSet EOF )
            // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:139:2: iv_ruleSet= ruleSet EOF
            {
             newCompositeNode(grammarAccess.getSetRule()); 
            pushFollow(FOLLOW_ruleSet_in_entryRuleSet275);
            iv_ruleSet=ruleSet();

            state._fsp--;

             current =iv_ruleSet; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSet285); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSet"


    // $ANTLR start "ruleSet"
    // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:146:1: ruleSet returns [EObject current=null] : (otherlv_0= 'set ' ( (lv_var_1_0= RULE_ID ) ) otherlv_2= ' ' ( (lv_value_3_0= RULE_INT ) ) ) ;
    public final EObject ruleSet() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_var_1_0=null;
        Token otherlv_2=null;
        Token lv_value_3_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:149:28: ( (otherlv_0= 'set ' ( (lv_var_1_0= RULE_ID ) ) otherlv_2= ' ' ( (lv_value_3_0= RULE_INT ) ) ) )
            // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:150:1: (otherlv_0= 'set ' ( (lv_var_1_0= RULE_ID ) ) otherlv_2= ' ' ( (lv_value_3_0= RULE_INT ) ) )
            {
            // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:150:1: (otherlv_0= 'set ' ( (lv_var_1_0= RULE_ID ) ) otherlv_2= ' ' ( (lv_value_3_0= RULE_INT ) ) )
            // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:150:3: otherlv_0= 'set ' ( (lv_var_1_0= RULE_ID ) ) otherlv_2= ' ' ( (lv_value_3_0= RULE_INT ) )
            {
            otherlv_0=(Token)match(input,11,FOLLOW_11_in_ruleSet322); 

                	newLeafNode(otherlv_0, grammarAccess.getSetAccess().getSetKeyword_0());
                
            // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:154:1: ( (lv_var_1_0= RULE_ID ) )
            // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:155:1: (lv_var_1_0= RULE_ID )
            {
            // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:155:1: (lv_var_1_0= RULE_ID )
            // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:156:3: lv_var_1_0= RULE_ID
            {
            lv_var_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSet339); 

            			newLeafNode(lv_var_1_0, grammarAccess.getSetAccess().getVarIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSetRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"var",
                    		lv_var_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_12_in_ruleSet356); 

                	newLeafNode(otherlv_2, grammarAccess.getSetAccess().getSpaceKeyword_2());
                
            // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:176:1: ( (lv_value_3_0= RULE_INT ) )
            // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:177:1: (lv_value_3_0= RULE_INT )
            {
            // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:177:1: (lv_value_3_0= RULE_INT )
            // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:178:3: lv_value_3_0= RULE_INT
            {
            lv_value_3_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleSet373); 

            			newLeafNode(lv_value_3_0, grammarAccess.getSetAccess().getValueINTTerminalRuleCall_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSetRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_3_0, 
                    		"INT");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSet"


    // $ANTLR start "entryRuleInc"
    // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:202:1: entryRuleInc returns [EObject current=null] : iv_ruleInc= ruleInc EOF ;
    public final EObject entryRuleInc() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInc = null;


        try {
            // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:203:2: (iv_ruleInc= ruleInc EOF )
            // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:204:2: iv_ruleInc= ruleInc EOF
            {
             newCompositeNode(grammarAccess.getIncRule()); 
            pushFollow(FOLLOW_ruleInc_in_entryRuleInc414);
            iv_ruleInc=ruleInc();

            state._fsp--;

             current =iv_ruleInc; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInc424); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInc"


    // $ANTLR start "ruleInc"
    // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:211:1: ruleInc returns [EObject current=null] : (otherlv_0= 'inc ' ( (lv_var_1_0= RULE_ID ) ) ) ;
    public final EObject ruleInc() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_var_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:214:28: ( (otherlv_0= 'inc ' ( (lv_var_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:215:1: (otherlv_0= 'inc ' ( (lv_var_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:215:1: (otherlv_0= 'inc ' ( (lv_var_1_0= RULE_ID ) ) )
            // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:215:3: otherlv_0= 'inc ' ( (lv_var_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,13,FOLLOW_13_in_ruleInc461); 

                	newLeafNode(otherlv_0, grammarAccess.getIncAccess().getIncKeyword_0());
                
            // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:219:1: ( (lv_var_1_0= RULE_ID ) )
            // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:220:1: (lv_var_1_0= RULE_ID )
            {
            // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:220:1: (lv_var_1_0= RULE_ID )
            // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:221:3: lv_var_1_0= RULE_ID
            {
            lv_var_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleInc478); 

            			newLeafNode(lv_var_1_0, grammarAccess.getIncAccess().getVarIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getIncRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"var",
                    		lv_var_1_0, 
                    		"ID");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInc"


    // $ANTLR start "entryRuleDec"
    // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:245:1: entryRuleDec returns [EObject current=null] : iv_ruleDec= ruleDec EOF ;
    public final EObject entryRuleDec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDec = null;


        try {
            // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:246:2: (iv_ruleDec= ruleDec EOF )
            // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:247:2: iv_ruleDec= ruleDec EOF
            {
             newCompositeNode(grammarAccess.getDecRule()); 
            pushFollow(FOLLOW_ruleDec_in_entryRuleDec519);
            iv_ruleDec=ruleDec();

            state._fsp--;

             current =iv_ruleDec; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDec529); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDec"


    // $ANTLR start "ruleDec"
    // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:254:1: ruleDec returns [EObject current=null] : (otherlv_0= 'dec ' ( (lv_var_1_0= RULE_ID ) ) ) ;
    public final EObject ruleDec() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_var_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:257:28: ( (otherlv_0= 'dec ' ( (lv_var_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:258:1: (otherlv_0= 'dec ' ( (lv_var_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:258:1: (otherlv_0= 'dec ' ( (lv_var_1_0= RULE_ID ) ) )
            // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:258:3: otherlv_0= 'dec ' ( (lv_var_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,14,FOLLOW_14_in_ruleDec566); 

                	newLeafNode(otherlv_0, grammarAccess.getDecAccess().getDecKeyword_0());
                
            // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:262:1: ( (lv_var_1_0= RULE_ID ) )
            // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:263:1: (lv_var_1_0= RULE_ID )
            {
            // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:263:1: (lv_var_1_0= RULE_ID )
            // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:264:3: lv_var_1_0= RULE_ID
            {
            lv_var_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDec583); 

            			newLeafNode(lv_var_1_0, grammarAccess.getDecAccess().getVarIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getDecRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"var",
                    		lv_var_1_0, 
                    		"ID");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDec"


    // $ANTLR start "entryRuleIf"
    // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:288:1: entryRuleIf returns [EObject current=null] : iv_ruleIf= ruleIf EOF ;
    public final EObject entryRuleIf() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIf = null;


        try {
            // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:289:2: (iv_ruleIf= ruleIf EOF )
            // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:290:2: iv_ruleIf= ruleIf EOF
            {
             newCompositeNode(grammarAccess.getIfRule()); 
            pushFollow(FOLLOW_ruleIf_in_entryRuleIf624);
            iv_ruleIf=ruleIf();

            state._fsp--;

             current =iv_ruleIf; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIf634); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIf"


    // $ANTLR start "ruleIf"
    // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:297:1: ruleIf returns [EObject current=null] : (otherlv_0= 'if ' ( (lv_var_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_INT ) ) ) ;
    public final EObject ruleIf() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_var_1_0=null;
        Token otherlv_2=null;
        Token lv_value_3_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:300:28: ( (otherlv_0= 'if ' ( (lv_var_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_INT ) ) ) )
            // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:301:1: (otherlv_0= 'if ' ( (lv_var_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_INT ) ) )
            {
            // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:301:1: (otherlv_0= 'if ' ( (lv_var_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_INT ) ) )
            // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:301:3: otherlv_0= 'if ' ( (lv_var_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_INT ) )
            {
            otherlv_0=(Token)match(input,15,FOLLOW_15_in_ruleIf671); 

                	newLeafNode(otherlv_0, grammarAccess.getIfAccess().getIfKeyword_0());
                
            // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:305:1: ( (lv_var_1_0= RULE_ID ) )
            // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:306:1: (lv_var_1_0= RULE_ID )
            {
            // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:306:1: (lv_var_1_0= RULE_ID )
            // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:307:3: lv_var_1_0= RULE_ID
            {
            lv_var_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIf688); 

            			newLeafNode(lv_var_1_0, grammarAccess.getIfAccess().getVarIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getIfRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"var",
                    		lv_var_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,16,FOLLOW_16_in_ruleIf705); 

                	newLeafNode(otherlv_2, grammarAccess.getIfAccess().getEqualsSignKeyword_2());
                
            // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:327:1: ( (lv_value_3_0= RULE_INT ) )
            // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:328:1: (lv_value_3_0= RULE_INT )
            {
            // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:328:1: (lv_value_3_0= RULE_INT )
            // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:329:3: lv_value_3_0= RULE_INT
            {
            lv_value_3_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleIf722); 

            			newLeafNode(lv_value_3_0, grammarAccess.getIfAccess().getValueINTTerminalRuleCall_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getIfRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_3_0, 
                    		"INT");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIf"


    // $ANTLR start "entryRulePrint"
    // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:353:1: entryRulePrint returns [EObject current=null] : iv_rulePrint= rulePrint EOF ;
    public final EObject entryRulePrint() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrint = null;


        try {
            // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:354:2: (iv_rulePrint= rulePrint EOF )
            // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:355:2: iv_rulePrint= rulePrint EOF
            {
             newCompositeNode(grammarAccess.getPrintRule()); 
            pushFollow(FOLLOW_rulePrint_in_entryRulePrint763);
            iv_rulePrint=rulePrint();

            state._fsp--;

             current =iv_rulePrint; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePrint773); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrint"


    // $ANTLR start "rulePrint"
    // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:362:1: rulePrint returns [EObject current=null] : (otherlv_0= 'print ' otherlv_1= '\"' ( (lv_msg_2_0= RULE_STRING ) ) otherlv_3= '\"' ) ;
    public final EObject rulePrint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_msg_2_0=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:365:28: ( (otherlv_0= 'print ' otherlv_1= '\"' ( (lv_msg_2_0= RULE_STRING ) ) otherlv_3= '\"' ) )
            // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:366:1: (otherlv_0= 'print ' otherlv_1= '\"' ( (lv_msg_2_0= RULE_STRING ) ) otherlv_3= '\"' )
            {
            // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:366:1: (otherlv_0= 'print ' otherlv_1= '\"' ( (lv_msg_2_0= RULE_STRING ) ) otherlv_3= '\"' )
            // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:366:3: otherlv_0= 'print ' otherlv_1= '\"' ( (lv_msg_2_0= RULE_STRING ) ) otherlv_3= '\"'
            {
            otherlv_0=(Token)match(input,17,FOLLOW_17_in_rulePrint810); 

                	newLeafNode(otherlv_0, grammarAccess.getPrintAccess().getPrintKeyword_0());
                
            otherlv_1=(Token)match(input,18,FOLLOW_18_in_rulePrint822); 

                	newLeafNode(otherlv_1, grammarAccess.getPrintAccess().getQuotationMarkKeyword_1());
                
            // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:374:1: ( (lv_msg_2_0= RULE_STRING ) )
            // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:375:1: (lv_msg_2_0= RULE_STRING )
            {
            // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:375:1: (lv_msg_2_0= RULE_STRING )
            // ../org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual/src-gen/org/eclipse/epsilon/eugenia/examples/executablestatemachine/textual/parser/antlr/internal/InternalActions.g:376:3: lv_msg_2_0= RULE_STRING
            {
            lv_msg_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rulePrint839); 

            			newLeafNode(lv_msg_2_0, grammarAccess.getPrintAccess().getMsgSTRINGTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getPrintRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"msg",
                    		lv_msg_2_0, 
                    		"STRING");
            	    

            }


            }

            otherlv_3=(Token)match(input,18,FOLLOW_18_in_rulePrint856); 

                	newLeafNode(otherlv_3, grammarAccess.getPrintAccess().getQuotationMarkKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrint"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleAction_in_entryRuleAction75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAction85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSet_in_ruleAction132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInc_in_ruleAction159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDec_in_ruleAction186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIf_in_ruleAction213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrint_in_ruleAction240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSet_in_entryRuleSet275 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSet285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleSet322 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSet339 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleSet356 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleSet373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInc_in_entryRuleInc414 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInc424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleInc461 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInc478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDec_in_entryRuleDec519 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDec529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleDec566 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDec583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIf_in_entryRuleIf624 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIf634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleIf671 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIf688 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleIf705 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleIf722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrint_in_entryRulePrint763 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrint773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rulePrint810 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_rulePrint822 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_STRING_in_rulePrint839 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_rulePrint856 = new BitSet(new long[]{0x0000000000000002L});

}