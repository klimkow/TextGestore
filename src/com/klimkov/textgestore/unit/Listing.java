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
public class Listing implements ITextElement {
    private StringBuilder listing = new StringBuilder();
    public Listing(){
        
    }
    public Listing(String listing){
        this.listing.append(listing);
    }
    public String getValue(){
        return this.listing.toString();
    }
    public void setValue(String value){
        this.listing.insert(0, value);
    }
    public void add(ITextElement sentence){      
    }
    public void remove(ITextElement sentence){
    }
    public ITextElement getChild(int i){
        return null;
    }
    public Iterator getElement(){
        return null;
    }
    
    @Override
    public String toString(){
       return "Class " + this.getClass() + " value = " + this.listing;
    }
}
