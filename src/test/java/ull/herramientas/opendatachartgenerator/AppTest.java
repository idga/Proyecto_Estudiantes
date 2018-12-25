package ull.herramientas.opendatachartgenerator;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName ){
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite(){
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     * @throws IOException 
     * @throws MalformedURLException 
     */
    public void testApp() throws MalformedURLException, IOException{
    	
    	Dataset D = null;
    	String urlDataset = "http://www.santacruzdetenerife.es/opendata/dataset/8363b662-0bdc-47e1-b9f6-65b536714f29/resource/ee814891-ba52-4e7c-b9e6-017c1bc43b6b/download/barrios.csv";
		D = new Dataset(urlDataset,0);
		
		ArrayList<Instancia> ar = D.getRows();
		ArrayList<Instancia> ar2 = D.getRows();
		
		assertEquals(ar,ar2);
		
		assertEquals(D.getNombreAtributo(1), "OBJECTID");
		assertEquals(D.getNombreAtributo(2), "BARRIO");
		assertEquals(D.getNombreAtributo(3), "COD_BARRIO");
    }
}
