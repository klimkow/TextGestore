/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.klimkov.textgestore.creator;

import com.klimkov.textgestore.unit.ITextElement;
import com.klimkov.textgestore.unit.Text;

/**
 *
 * @author Nigga
 */
public class TextCreator {
    public static ITextElement initText(String text){
        return new Text(text);
    }
}
