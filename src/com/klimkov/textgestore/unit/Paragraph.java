/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.klimkov.textgestore.unit;
import java.util.ArrayList;
import java.util.Iterator;

enum ParagraphType{LISTING, PARAGRAPH};
/**
 *
 * @author Nigga
 */
public class Paragraph implements ITextElement {
    private ArrayList<ITextElement> sentences = new ArrayList<>();
    private StringBuilder paragraph = new StringBuilder();
    public Paragraph(){
        
    }
    public Paragraph(String paragraph){
        this.paragraph.append(paragraph);        
    }
    public String getValue(){
        return this.paragraph.toString();
    }
    public void setValue(String value){
        this.paragraph.insert(0, value);
    }
    public void add(ITextElement sentence){
        sentences.add(sentence);
    }
    public void remove(ITextElement sentence){
        sentences.remove(sentence);
    }
    public ITextElement getChild(int i){
        return sentences.get(i);
    }
    public Iterator getElement(){
        return this.sentences.iterator();
    }
    
    @Override
    public String toString(){
       return "Class " + this.getClass() + " value = " + this.paragraph + " sentences: " + this.sentences.toString();
    }
}
