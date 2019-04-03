package com.udec.relevo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David
 */
public class Logica {

   
    
    static char[] vectorEquipo1 = new char [50];
    static char[] vectorEquipo2 = new char [50];
    static char[] vectorEquipo3 = new char [50];
    
     static int secae =0;
     static int mueveUno=1;
     static int mueveDos=2;
     static int mueveTres=3;
     
     
     static Integer pasosEquipo1=0;
     static Integer pasosEquipo2=0;
     static Integer pasosEquipo3=0;
     
     static boolean stp = true;
    public Logica() {
        
        llenar();
        Corredor1 corr1 = new Corredor1(pasosEquipo1);
        Corredor2 corr2 = new Corredor2(pasosEquipo1);
        Corredor3 corr3 = new Corredor3(pasosEquipo1);
        Corredor4 corr4 = new Corredor4();
        Corredor5 corr5 = new Corredor5();
        Corredor6 corr6 = new Corredor6();
        Corredor7 corr7 = new Corredor7();
        Corredor8 corr8 = new Corredor8();
        Corredor9 corr9 = new Corredor9();
        corr1.start();
        corr2.start();
        corr3.start();
        
    }
    
    public static void espera(){
        synchronized(pasosEquipo1){
            try {
                pasosEquipo1.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Logica.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
    }
    
    public static void notifica(){
        synchronized(pasosEquipo1){
            pasosEquipo1.notify();
       }
    }
    
    public static boolean estaIgual(){
       return pasosEquipo1 <15;
    }
    
    private void llenar(){
        for (int i = 0; i < 50; i++) {
           vectorEquipo1[i] = '_';
        }//for
        for (int i = 0; i < 50; i++) {
           vectorEquipo2[i] = '_';
        }//for
        for (int i = 0; i < 50; i++) {
           vectorEquipo3[i] = '_';
        }//for
    }//llenar
    
}
