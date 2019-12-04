/*******************************************************************************
 * Copyright (c) 2016 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Saheed Popoola - initial API and implementation
 *     Horacio Hoyos - aditional functionality
 ******************************************************************************/
package org.eclipse.epsilon.emg;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.epsilon.emg.random.CharacterSet;
import org.eclipse.epsilon.emg.random.IEmgRandomGenerator;
import org.eclipse.epsilon.eol.exceptions.EolIllegalReturnException;
import org.eclipse.epsilon.eol.execute.Return;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.epl.combinations.CompositeCombinationGenerator;
import org.eclipse.epsilon.epl.combinations.CompositeCombinationValidator;
import org.eclipse.epsilon.epl.dom.NoMatch;
import org.eclipse.epsilon.epl.dom.Pattern;
import org.eclipse.epsilon.epl.dom.Role;
import org.eclipse.epsilon.epl.execute.PatternMatch;
import org.eclipse.epsilon.epl.execute.PatternMatcher;

/**
 * The Class EmgPatternMatcher extends the EPL pattern matcher to provide
 * EMG specific functionality.
 */
public class EmgPatternMatcher extends PatternMatcher {

    /**
     * How many matches should the pattern find
     */
    private static final String NUMBER_ANNOTATION = "number";

    /**
     * What is the probability of executing the pattern
     */
    private static final String PROBABILITY_ANNOTATION = "probability";

    /**
     * Don't re-execute the pattern for the same set of input elements
     */
    private static final String NO_REPEAT_ANNOTATION = "noRepeat";

    /** The random generator. */
    IEmgRandomGenerator<? extends CharacterSet> randomGenerator;

    /**
     * Instantiates a new EMG pattern matcher.
     * @param rand the EmgRandomGenerator
     */
    public EmgPatternMatcher(IEmgRandomGenerator<? extends CharacterSet> rand){
        randomGenerator=rand;
    }

    /* (non-Javadoc)
     * @see org.eclipse.epsilon.epl.execute.PatternMatcher#match(org.eclipse.epsilon.epl.dom.Pattern, org.eclipse.epsilon.eol.execute.context.IEolContext)
     */
    @Override
    public List<PatternMatch> match(final Pattern pattern, final IEolContext context) throws Exception {

        List<PatternMatch> patternMatches = new ArrayList<PatternMatch>();
        context.getFrameStack().enterLocal(FrameType.PROTECTED, pattern);
        boolean noRepeat= pattern.hasAnnotation(NO_REPEAT_ANNOTATION);
        boolean withProbability= pattern.hasAnnotation(PROBABILITY_ANNOTATION);
        boolean number= pattern.hasAnnotation(NUMBER_ANNOTATION);
        boolean annotationChange;

        int num=0, value=1;
        List<Object> matchList= new ArrayList<Object>();
        CompositeCombinationGenerator<Object> generator = new CompositeCombinationGenerator<Object>();
        for (Role role : pattern.getRoles()) {
            generator.addCombinationGenerator(createCombinationGenerator(role, context));
        }
       generator.setValidator(new CompositeCombinationValidator<Object>() {
    	   
            @Override
            public boolean isValid(List<List<Object>> combination) throws Exception {
                for (Object o : combination.get(combination.size()-1)) {
                    if (o instanceof NoMatch) return true;
                }

                frame = context.getFrameStack().enterLocal(FrameType.PROTECTED, pattern);
                boolean result = true;
                int i = 0;
                Role role = null;
                for (List<Object> values : combination) {
                    role = pattern.getRoles().get(i);
                    for (Variable variable : getVariables(values, role)) {
                        frame.put(variable);
                    }
                    i++;
                }
                if (!role.isNegative() && role.getGuard() != null && role.isActive(context) && role.getCardinality().isOne()) {
                    result = role.getGuard().execute(context);
                }
                context.getFrameStack().leaveLocal(pattern);
                return result;
            }
        });

        //annotation number
        if(number){
            List<Object> vals=pattern.getAnnotationsValues(NUMBER_ANNOTATION, context);
            if(vals.size()>1){
                Object val= vals.get(0);
                Object val2= vals.get(1);
                if(!(val.equals(null) || (val2.equals(null)))){
                    value = randomGenerator.nextInteger(getInt( val),getInt( val2));
                }
            }
            else if(vals.size()>0){
                Object val= vals.get(0);
                if(!(val.equals(null))){
                    if(val instanceof Collection){
                        List<Object> valC= (List<Object>)val;
                        if(valC.size()>1)
                            value = randomGenerator.nextInteger(getInt(valC.get(0)),getInt(valC.get(1)));
                        else
                            value = getInt(valC.get(0));
                        }
                    else
                        value=getInt(val);
                }
            }
        }//end annotation number
        while (generator.hasMore()) {
            if (value==0)
                break;
            List<List<Object>> candidate = generator.getNext();
            boolean test = false;
            // Don't repeat
            if(noRepeat){
                for(Object temp:candidate){
                    //System.out.println(temp);
                    if(matchList.contains(temp)){
                        test=true;
                        break;
                    }
                }
                if (test){
                    continue;
                }
            }//end annotation noRepeat
            boolean matches = true;
            annotationChange=true;

            frame = context.getFrameStack().enterLocal(FrameType.PROTECTED, pattern);

            if (pattern.getMatch() != null || pattern.getNoMatch() != null || pattern.getOnMatch() != null) {
                int i = 0;
                for (Role role : pattern.getRoles()) {
                    for (Variable variable : getVariables(candidate.get(i), role)) {
                        frame.put(variable);
                    }
                    i++;
                }
            }

            if (pattern.getMatch() != null) {
                Object result = context.getExecutorFactory().execute(pattern.getMatch(), context);
                if (result instanceof Return) result = ((Return) result).getValue();
                if (result instanceof Boolean) {
                    matches = (Boolean) result;
                }
                else throw new EolIllegalReturnException("Boolean", result, pattern.getMatch(), context);
            }

            if (matches) {
                if(noRepeat){
                    matchList.addAll(candidate);

                }//end annotation noRepeat

                //annotation probability
                if (withProbability) {
                    Object val = 1.0;
                    if(pattern.getAnnotationsValues(PROBABILITY_ANNOTATION, context).size() > 0) {
                        val = pattern.getAnnotationsValues(PROBABILITY_ANNOTATION, context).get(0);
                    }
                    double value2=1;
                    if((!val.equals(null))){
                        value2 = getFloat(val);
                    }

                    if(!(randomGenerator.nextValue() < value2) ){
                        annotationChange=false;
                    }

                }//end annotation probability
                if(annotationChange){
                    context.getExecutorFactory().execute(pattern.getOnMatch(), context);
                    patternMatches.add(createPatternMatch(pattern, candidate));
                }
                else {
                    context.getFrameStack().leaveLocal(pattern);
                }
                //annotation number
                // If there was a match and the pattern has a number annotation keep track
                if(number) {
                    num++;
                    if(num == value)
                        break;
                }
                //end annotation number
            }
            else context.getExecutorFactory().execute(pattern.getNoMatch(), context);
        }

        context.getFrameStack().leaveLocal(pattern);
        return patternMatches;
    }

    /**
     * Gets the int.
     *
     * @param object the object
     * @return the int
     */
    protected int getInt(Object object){
        if(object instanceof Integer)
            return (int)object;
        else
            return Integer.parseInt((String) object);
    }

    /**
     * Gets the float.
     * @param object the object
     * @return the float
     */
    protected double getFloat(Object object){
        if(object instanceof Number) // || object instanceof Double)
            return ((Number)object).doubleValue();
        else
            return Float.parseFloat((String) object);
    }

    /**
     * Contain any.
     *
     * @param first the first
     * @param last the last
     * @return true, if successful
     */
    protected boolean containAny(Collection<Object> first, Collection<Object> last){
        for(Object o : first){
            if(last.contains(o))
                return true;
        }
        return false;
    }
}