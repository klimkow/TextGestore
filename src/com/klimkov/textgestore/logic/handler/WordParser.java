/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.klimkov.textgestore.logic.handler;

import com.klimkov.textgestore.logic.GestoreException;
import com.klimkov.textgestore.logic.Gestore;
import com.klimkov.textgestore.logic.RegExpReader;
import com.klimkov.textgestore.unit.Symbol;
import java.util.ArrayList;
import java.util.Iterator;
import com.klimkov.textgestore.unit.ITextElement;
import org.apache.log4j.Logger;

/**
 *
 * @author Nigga
 */
public class WordParser extends Parser {
    private static final Logger LOG = Logger.getLogger(WordParser.class);
    
    public WordParser(){
        
    }
    public WordParser(Parser successor){
        try{
            this.setSuccessor(successor);
        }
        catch(ParserException e){
            LOG.error(e);
        }
    }
   
    @Override
    public void parse(ITextElement text) {
        try{
            ArrayList<String> lSymbols;
            Iterator<ITextElement> lWords = text.getElement();
            while(lWords.hasNext()){
                ITextElement word = lWords.next();
                lSymbols = Gestore.parseText(
                        word.getValue(),
                        RegExpReader.getRegExp(RegExpReader.PartOfSpeach.SYMBOL)
                        );
                for(String symbol : lSymbols){
                    word.add(new Symbol(symbol)); 
                }                               
            }                      
        }
        catch(GestoreException e){
            LOG.error(e);                    
        }        
    }
    
}
