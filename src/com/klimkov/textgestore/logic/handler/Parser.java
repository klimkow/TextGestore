/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.klimkov.textgestore.logic.handler;
import java.util.ArrayList;
import com.klimkov.textgestore.unit.ITextElement;
/**
 *
 * @author Nigga
 */
public abstract class Parser {
    
    private Parser successor;
   
    public void parse(ITextElement text) throws ParserException{
        if(getSuccessor() == null){
            throw new ParserException("Unable to find the correct parser");
        }
        getSuccessor().parse(text);  
  }
   
  protected boolean canHandleFile(ArrayList list, Object ob) throws ParserException{
      if(list == null){
          throw new ParserException("ArrayList is null or empty");
      }
      return list.getClass().isInstance(ob);         
  }
 
  Parser getSuccessor() {
      return successor;
  }
 
  void setSuccessor(Parser successor) throws ParserException {
      if(successor == null){
          throw new ParserException("Unable to set parser " + successor);
      }
      this.successor = successor;
  }
}
