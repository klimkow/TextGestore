/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.klimkov.textgestore.logic;
import com.klimkov.textgestore.unit.ITextElement;
import java.util.Iterator;

/**
 *
 * @author Nigga
 */
public class RemoveConsonant {
    public static void removeAllConsonat(int lenght, ITextElement text){
        text.getValue().replaceAll("\\b[bcdfghjklmnpqrstvwxz]{" + lenght + "," + lenght + "}\\b", "");        
    }
}
