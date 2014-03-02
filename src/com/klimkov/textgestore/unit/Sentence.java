/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.klimkov.textgestore.unit;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Nigga
 */
public class Sentence implements ITextElement{
    private ArrayList<ITextElement> words = new ArrayList<>();
    private StringBuilder sentence = new StringBuilder();
    
    public Sentence(){
        
    }
    public Sentence(String sentence){
        this.sentence.append(sentence);
    }
    public String getValue(){
        return this.sentence.toString();
    }
    public void setValue(String value){
        this.sentence.insert(0, value);
    }
     public void add(ITextElement word){
        words.add(word);
    }
    public void remove(ITextElement word){
        words.remove(word);
    }
    public ITextElement getChild(int i){
        return words.get(i);
    }
    public Iterator getElement(){
        return this.words.iterator();
    }
    @Override
    public String toString(){
        return "Class " + this.getClass() + " value = " + this.sentence + " words: " + this.words.toString();
    }
}
