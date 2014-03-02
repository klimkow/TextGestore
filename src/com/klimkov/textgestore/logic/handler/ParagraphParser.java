/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.klimkov.textgestore.logic.handler;

import com.klimkov.textgestore.unit.Paragraph;
import com.klimkov.textgestore.unit.Sentence;
import java.util.ArrayList;
import java.util.Iterator;
import com.klimkov.textgestore.logic.GestoreException;
import com.klimkov.textgestore.logic.Gestore;
import com.klimkov.textgestore.logic.RegExpReader;
import org.apache.log4j.Logger;
import com.klimkov.textgestore.unit.ITextElement;

/**
 *
 * @author Nigga
 */
public class ParagraphParser extends Parser {
    private static final Logger LOG = Logger.getLogger(ParagraphParser.class);
        
    public ParagraphParser(Parser successor){
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
            ArrayList<String> lSentences;
            Iterator<ITextElement> lParagraphs = text.getElement();
            while(lParagraphs.hasNext()){
                ITextElement paragraph = lParagraphs.next();
                lSentences = Gestore.parseText(
                        paragraph.getValue(),
                        RegExpReader.getRegExp(RegExpReader.PartOfSpeach.SENTENCE)
                        );
                for(String sentence : lSentences){
                    paragraph.add(new Sentence(sentence));
                    super.parse(paragraph);
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
