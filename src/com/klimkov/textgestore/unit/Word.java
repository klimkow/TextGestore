/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.klimkov.textgestore.unit;

import java.util.ArrayList;
import java.util.Iterator;
import org.apache.log4j.Logger;

/**
 *
 * @author Nigga
 */
public class Word implements ITextElement {
    private StringBuilder word = new StringBuilder();
    private ArrayList<ITextElement> symbols = new ArrayList<>();
    
    public Word(){
        
    }
    public Word(String word){
        this.word.append(word);
    }
    public String getValue(){
        return this.word.toString();
    }
    public void setValue(String value){
        this.word.insert(0, value);
    }
    public void add(ITextElement symbol){
        symbols.add(symbol);
    }
    public void remove(ITextElement symbol){
        symbols.remove(symbol);
    }
    public ITextElement getChild(int i){
        return symbols.get(i);
    }
    public Iterator getElement(){
        return this.symbols.iterator();
    }
    @Override
    public String toString(){
        return "Class " + this.getClass() + " value = " + this.word + " symbols: " + this.symbols.toString();
    }
}
