/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.klimkov.textgestore.creator;

import com.klimkov.textgestore.logic.handler.ParagraphParser;
import com.klimkov.textgestore.logic.handler.Parser;
import com.klimkov.textgestore.logic.handler.ParserException;
import com.klimkov.textgestore.logic.handler.SentenceParser;
import com.klimkov.textgestore.logic.handler.TextParser;
import com.klimkov.textgestore.logic.handler.WordParser;
import com.klimkov.textgestore.run.TextGestore;
import com.klimkov.textgestore.unit.ITextElement;
import org.apache.log4j.Logger;

/**
 *
 * @author Nigga
 */
public class InitializeComponents {
    private static final Logger LOG = Logger.getLogger(TextGestore.class);
    
    public static ITextElement initGestore(ITextElement text){
        Parser wordParser = new WordParser();
        Parser sentenceParser = new SentenceParser(wordParser);
        Parser paragraphParser = new ParagraphParser(sentenceParser);
        Parser textParser = new TextParser(paragraphParser);
        try{
            textParser.parse(text);           
        }
        catch(ParserException e){
            LOG.error(e);
        }
        return text;
    }
    
}
