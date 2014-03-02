/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.klimkov.textgestore.logic;
import java.util.ResourceBundle;

/**
 *
 * @author Nigga
 */
public class RegExpReader {
    private static final String REG_EXP_PATH = "resource/reg_exp";
    public enum PartOfSpeach {PARAGRAPH, SENTENCE, WORD, SYMBOL, PUNCTUATION, LISTING};
    public static String getRegExp(PartOfSpeach pof){
        ResourceBundle rb = ResourceBundle.getBundle(REG_EXP_PATH);
        return rb.getString(pof.toString()); 
    }
}
