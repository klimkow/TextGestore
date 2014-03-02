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
public class Text implements ITextElement {
    private StringBuilder value = new StringBuilder();
    private ArrayList<ITextElement> paragraphs = new ArrayList<>();
    
    public Text(){
        
    }
    public Text(String value){
        this.value.append(value);
    }
    public String getValue(){
        return this.value.toString();
    }
    public void setValue(String value){
        this.value.insert(0, value);
    }
    public void add(ITextElement paragraph){
        paragraphs.add(paragraph);
    }
    public void remove(ITextElement paragraph){
        paragraphs.remove(paragraph);
    }
    public ITextElement getChild(int i){
        return paragraphs.get(i);
    }
    public Iterator getElement(){
        return this.paragraphs.iterator();
    }
    @Override
    public String toString(){
        return "Class " + this.getClass() + " value = " + value + " paragrphs: " + this.paragraphs.toString();
    }
}
