package com.udec.relevo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David
 */
public class Logica {

   
    /**
     * se inicializna los vectores 
     */
    static char[] vectorEquipo1 = new char [50];
    static char[] vectorEquipo2 = new char [50];
    static char[] vectorEquipo3 = new char [50];
    /**
     * Se inicializan las los pasos de cada uno de los equipos
     */
     static Integer pasosEquipo1=0;
     static Integer pasosEquipo2=0;
     static Integer pasosEquipo3=0;
   
     /**
      * se llaman las clases de los hilos y se envian pasos a cada equipo
      */
     Corredor1 corr1 = new Corredor1(pasosEquipo1);
     Corredor4 corr4 = new Corredor4(pasosEquipo2);
     Corredor7 corr7 = new Corredor7(pasosEquipo3);
        
     Corredor2 corr2 = new Corredor2(pasosEquipo1);
     Corredor5 corr5 = new Corredor5(pasosEquipo2);
     Corredor8 corr8 = new Corredor8(pasosEquipo3);
        
     Corredor3 corr3 = new Corredor3(pasosEquipo1);
     Corredor6 corr6 = new Corredor6(pasosEquipo2);
     Corredor9 corr9 = new Corredor9(pasosEquipo3);

     /**
      * contructor que se incia para las pruebas
      * @param x 
      */
    public Logica(int x) {
    }
     
     
     
    /**
     * Se llamana el emtodo a llenar, y se incian los hilos
     */    
    public Logica() {
        
        llenar1();
        llenar2();
        llenar3();
        corr1.start();
        corr4.start();
        corr7.start();
        
        corr2.start();
        corr8.start();
        corr5.start();
        
        
        corr9.start();
        corr3.start();
        corr6.start();
        
        terminar();
    }
    
    /**
     * metodo que se encarga de finalizar los hilos cuando alguno de ellos gane
     */
    public void terminar(){
        boolean bandera = true;
        while(bandera){
            if(!corr3.isAlive()){
                corr6.setConti(false);
                corr9.setConti(false);
                medalla(corr3.getColor());
                bandera = false;
            }else if(!corr6.isAlive()){
                
                corr3.setConti(false);
                corr9.setConti(false);
                medalla(corr6.getColor());
                bandera = false;
            }else if(!corr9.isAlive()){
                
                corr3.setConti(false);
                corr6.setConti(false);
                medalla(corr9.getColor());
                bandera = false;
            }//if
        }//while
    }//terminar
    
    /**
     * Metodo que imprime la medalla, y el equipo ganador
     * @param color = un strig con el color del equipo ganador
     */
    public void medalla(String color){
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("           |||||||||||||||||||||           ");
        System.out.println("    ||||||||||||||||||||||||||||||||||     ");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||| " +"   Ganador equipo: "+color+" |||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("    ||||||||||||||||||||||||||||||||||     ");
        
    }
    
    /**
     * metodo que imprime el vector del equipo1
     * @param vector 
     */
     public static synchronized void imprimir(char [] vector){
        
        System.out.println("\n");
        for (int i = 0; i < 50; i++) {
            System.out.print("\033[33m"+vector[i]);
        }//for
        System.out.println("\n");
    }//imprimir
    
     /**
     * metodo que imprime el vector del equipo2
     * @param vector 
     */
    public static synchronized void imprimir2(char [] vector){
        
        System.out.println("\n");
        for (int i = 0; i < 50; i++) {
            System.out.print("\033[32m"+vector[i]);
        }//for
        System.out.println("\n");
    }//imprimir
     
    /**
     * metodo que imprime el vector del equipo3
     * @param vector 
     */
    public static synchronized void imprimir3(char [] vector){
        
        System.out.println("\n");
        for (int i = 0; i < 50; i++) {
            System.out.print("\033[34m"+vector[i]);
        }//for
        System.out.println("\n");
    }//imprimir
    
    /**
     * metodo que se encarga el vector con _ el cual sirve de pista
     */
    public void llenar1(){
        for (int i = 0; i < 50; i++) {
           vectorEquipo1[i] = '_';
        }//for
    }//llenar
    /**
     * metodo que se encarga el vector con _ el cual sirve de pista
     */
    public void llenar2(){
        for (int i = 0; i < 50; i++) {
           vectorEquipo2[i] = '_';
        }//for
    }//llenar
    /**
     * metodo que se encarga el vector con _ el cual sirve de pista
     */
    public void llenar3(){
        for (int i = 0; i < 50; i++) {
           vectorEquipo3[i] = '_';
        }//for
    
    }//llenar    
        
    
    /**
     * metodo que se encarga el vector con _ el cual sirve de pista
     */
     public boolean llenar1Prueba(boolean x,char[] vect){
        if(x==false){
            if(vect.length > 0){
                x=true;
                return x;
            }
            
        }
        return x;
    }//llenar
     
     
     /**
     * metodo que se encarga el vector con _ el cual sirve de pista
     */
    public boolean llenarPrueba(char[] vect){
        boolean x = false;
        for (int i = 0; i < 50; i++) {
           vect[i] = '_';
        }//for
        x=true;
        return x;
    }//llenar    
    
  
    
}
