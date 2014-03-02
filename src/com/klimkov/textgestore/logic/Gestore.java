/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.klimkov.textgestore.logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import org.apache.log4j.Logger;
import java.util.Map;
import java.util.HashMap;
import com.klimkov.textgestore.unit.Text;
import static com.klimkov.textgestore.logic.RegExpReader.PartOfSpeach;

/**
 *
 * @author Nigga
 */
public class Gestore {
    private static final Logger LOG = Logger.getLogger(Gestore.class);

    public Gestore() {
    }
    
    public static Map readText(String filename){
        Map<String,ArrayList> map = new HashMap<>();
        ArrayList<String> textArray = new ArrayList<>();
        ArrayList<String> listingArray = new ArrayList<>();
        try {
                BufferedReader in = new BufferedReader(new FileReader(new File(filename).getAbsoluteFile()));
                try {
                    String textString;
                    Pattern argPattern = Pattern.compile(
                            RegExpReader.getRegExp(PartOfSpeach.LISTING),
                            Pattern.CASE_INSENSITIVE | Pattern.DOTALL
                            );
                    Boolean listingFlag = false;
                    StringBuilder listing = new StringBuilder();
                    while ((textString = in.readLine()) != null) {
                        Matcher m = argPattern.matcher(textString);
                        if(m.lookingAt()){
                            if(!listingFlag){
                                listingFlag = true;
                                listing.append(textString);
                            }
                            else{
                                listingFlag=false;
                                listingArray.add(listing.toString());
                            }
                        }
                        else{
                            if(listingFlag){
                                listing.append(textString);
                            }
                            else{
                                textArray.add(textString);
                            }
                        }                        
                        LOG.info("new paragraph was added");                                    
                        }                    
                    map.put("PARAGRAPH", textArray);
                    map.put("LISTING", listingArray);                    
                } finally {
                    in.close();
                    LOG.debug("Closing file");
                }
        } catch (IOException e) {
            LOG.error(e);
        }
        return map;
    }
      
    public static ArrayList parseText(String arg, String regEx) throws GestoreException{
        if(arg == null){
            throw new GestoreException("Object is null");
        }
        else if(regEx == null){
            throw new GestoreException("regEx string is null");
        }
        ArrayList<String> value = new ArrayList<>();
        Pattern argPattern = Pattern.compile(regEx,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        Matcher m = argPattern.matcher(arg);
        while(m.find()){
            value.add(m.group());
        }
        return value;            
        }

}
