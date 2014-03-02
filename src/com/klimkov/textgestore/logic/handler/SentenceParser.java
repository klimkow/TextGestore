/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.klimkov.textgestore.logic.handler;

import com.klimkov.textgestore.logic.GestoreException;
import com.klimkov.textgestore.logic.Gestore;
import com.klimkov.textgestore.logic.RegExpReader;
import com.klimkov.textgestore.unit.Word;
import java.util.ArrayList;
import java.util.Iterator;
import com.klimkov.textgestore.unit.ITextElement;
import org.apache.log4j.Logger;

/**
 *
 * @author Nigga
 */
public class SentenceParser extends Parser {
    private static final Logger LOG = Logger.getLogger(SentenceParser.class);
    
    public SentenceParser(){
        
    }
    public SentenceParser(Parser successor){
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
            ArrayList<String> lWords;
            Iterator<ITextElement> lSentences = text.getElement();
            while(lSentences.hasNext()){
                ITextElement sentence = lSentences.next();
                lWords = Gestore.parseText(
                        sentence.getValue(),
                        RegExpReader.getRegExp(RegExpReader.PartOfSpeach.WORD
                        ));
                for(String word : lWords){
                    sentence.add(new Word(word)); 
                    super.parse(sentence);  
                }                               
            }                      
        }
        catch(GestoreException e){
            LOG.error(e);                    
        }
        catch(ParserException e){
            LOG.error(e);
        }
    }
    
}
