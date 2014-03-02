/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.klimkov.textgestore.logic.handler;
import com.klimkov.textgestore.logic.Gestore;
import com.klimkov.textgestore.unit.Paragraph;
import com.klimkov.textgestore.unit.Listing;
import com.klimkov.textgestore.unit.ITextElement;
import java.util.Map;
import java.util.ArrayList;
import org.apache.log4j.Logger;


/**
 *
 * @author Nigga
 */
public class TextParser extends Parser {
    private static final Logger LOG = Logger.getLogger(TextParser.class);
    
    public TextParser(Parser successor){
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
            Map<String, ArrayList> mText = Gestore.readText(text.getValue());
            ArrayList<String> lParagraph = mText.get("PARAGRAPH");
            for(String paragraph : lParagraph){
                    text.add(new Paragraph(paragraph));                
            }                       
            super.parse(text);
        }
        catch(ParserException e){
            LOG.error(e);
        }        
    }
}
