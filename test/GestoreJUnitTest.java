/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import com.klimkov.textgestore.logic.Gestore;
import com.klimkov.textgestore.logic.GestoreException;
import com.klimkov.textgestore.logic.RegExpReader;
import com.klimkov.textgestore.logic.handler.ParserException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;


/**
 *
 * @author Nigga
 */
public class GestoreJUnitTest {
    
    public GestoreJUnitTest() {
    }
    private ArrayList value;
    
    @Before
    public void setUp() {
        value  = new ArrayList();
        value.add("Test");
        value.add("string");
    }
    
    @After
    public void tearDown() {
        value = null;
    }
    
    @Test( expected = GestoreException.class ) 
    public void parseTextExceptionTest() throws GestoreException { 
        ArrayList expected = new ArrayList(); 
        ArrayList actual = Gestore.parseText(null, null); 
        Assert.assertEquals(expected, actual);             
    }
    
    @Test
    public void parseTextTest() throws GestoreException { 
        ArrayList expected = value; 
        ArrayList actual = Gestore.parseText("Test string", RegExpReader.getRegExp(RegExpReader.PartOfSpeach.WORD)); 
        Assert.assertEquals(expected, actual);             
    }
}