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
public class Symbol implements ITextElement {
    private StringBuilder symbol = new StringBuilder();
    
    public Symbol(){
        
    }
    public Symbol(String symbol){
        this.symbol.append(symbol);
    }
    public String getValue(){
        return this.symbol.toString();
    }
    public void setValue(String value){
        this.symbol.insert(0, value);
    }
    public void add(ITextElement sentence){ };
    public void remove(ITextElement sentence){ };
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
