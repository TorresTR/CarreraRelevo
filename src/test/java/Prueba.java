/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.udec.relevo.Logica;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author David
 */
public class Prueba {
    
    /**
     * se inicializna los vectores 
     */
    static char[] vectorEquipo1p = new char [50];
    static char[] vectorEquipo1v = new char [50];
    static char[] vectorEquipo2p = new char [50];
    static char[] vectorEquipo3p = new char [50];
    
    public Prueba() {
       
    }
    
    @BeforeClass
    public static void setUpClass() {
         llenar3();
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    public static void llenar3(){
        for (int i = 0; i < 50; i++) {
           vectorEquipo1p[i] = '_';
        }//for
    
    }//llenar       
   /* @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }*/

    @Test
    public void validavect1(){
        Logica log = new Logica(2);
        boolean prueba = log.llenar1Prueba(true,vectorEquipo1p);
        assertTrue(prueba);
    }
    
    @Test
    public void validaLlenado1(){
        Logica log = new Logica(2);
        boolean prueba = log.llenarPrueba(vectorEquipo1v);
        assertTrue(prueba);
    }
 
  
}
