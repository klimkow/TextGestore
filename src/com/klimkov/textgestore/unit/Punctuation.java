/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.klimkov.textgestore.unit;

import java.util.Iterator;

/**
 *
 * @author Nigga
 */
public class Punctuation implements ITextElement {
    private StringBuilder punctuation = new StringBuilder();
    
    public Punctuation(){
        
    }
    public Punctuation(String punctuation){
        this.punctuation.append(punctuation);
    }
    public String getValue(){
        return this.punctuation.toString();
    }
    public void setValue(String value){
        this.punctuation.insert(0, value);
    }
    public void add(ITextElement sentence){};
    public void remove(ITextElement sentence){};
    public ITextElement getChild(int i){
        return null;
    }
    public Iterator getElement(){
        return null;
    }
    @Override
    public String toString(){
        return "Class " + this.getClass() + " value = " + this.getValue();
    }
    
}
