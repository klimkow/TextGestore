/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.klimkov.textgestore.run;

import org.apache.log4j.PropertyConfigurator;
import com.klimkov.textgestore.unit.ITextElement;
import com.klimkov.textgestore.creator.InitializeComponents;
import com.klimkov.textgestore.creator.TextCreator;
import com.klimkov.textgestore.report.GenerateReport;

/**
 *
 * @author Nigga
 */
public class TextGestore {
    private static final String PATH = "src/resource/log4j.properties";
    private static final String TEXT_PATH = "src/resource/text.txt";
    
    
    public static void main(String[] args) {
        PropertyConfigurator.configure(PATH);
        
        ITextElement text = TextCreator.initText(TEXT_PATH);
        text = InitializeComponents.initGestore(text);
        GenerateReport.append(text.getChild(1).getChild(2).getValue());
        GenerateReport.append(text.getChild(1).getChild(2).getChild(16).getValue());
        GenerateReport.generate();
        
        
                
    }
}
