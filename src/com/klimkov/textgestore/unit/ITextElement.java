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
public interface ITextElement {
    public void add(ITextElement element);
    public void remove(ITextElement element);
    public ITextElement getChild(int i);
    public Iterator getElement();
    public String getValue();
    public void setValue(String value);
}
