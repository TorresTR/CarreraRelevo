package com.udec.relevo;

import static com.udec.relevo.Logica.pasosEquipo1;
import static com.udec.relevo.Logica.vectorEquipo1;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David
 */
public class Corredor3 extends Thread {
    
    private String color;

    private  Integer dat;
    boolean conti = true;
    
    public Corredor3(Integer x) {
        this.color = "Amarrillo";
        this.dat =x;
    }

    @Override
    public void run() {
       
        if(dat <= 32){
            try {
                synchronized(dat){
                    dat.wait();
                 }
               } catch (InterruptedException ex) {
                    System.out.println("error");
                }
        }
        
        while(conti){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Logica.class.getName()).log(Level.SEVERE, null, ex);
            }
            int numero = generaNum();
            if(numero==0){
                
            }else if(numero == 1){
                for (int i = pasosEquipo1; i < 50; i++) {
                    if(vectorEquipo1[i]=='C'){
                        vectorEquipo1[i] ='_'; 
                        if(i+1 >=50){
                            vectorEquipo1[49] ='C';
                            synchronized(dat){
                                dat.notify();
                            }
                            conti=false;
                            break;
                        }else{
                            vectorEquipo1[i+1] ='C';
                            break;
                         }//else
                    }//if
                }//for    
            }else if(numero == 2){
                 for (int i = pasosEquipo1; i < 50; i++) {
                    if(vectorEquipo1[i]=='C'){
                        vectorEquipo1[i] ='_'; 
                        if(i+2 >= 50){
                            vectorEquipo1[49] ='C';
                            synchronized(dat){
                                dat.notify();
                            }
                            conti=false;
                            break;
                        }else{
                            vectorEquipo1[i+2] ='C';
                            break;
                        }//else
                    }//if
                }//for  
            }else if(numero == 3){
                for (int i = pasosEquipo1; i < 50; i++) {
                    if(vectorEquipo1[i]=='C'){
                        vectorEquipo1[i] = '_'; 
                        if(i+3>=50){
                            vectorEquipo1[49] ='C';
                            synchronized(dat){
                                dat.notify();
                            }
                            conti=false;
                            break;
                        }else{
                            vectorEquipo1[i+3] ='C';
                            break;
                        }//else
                    }//if
                }//for 
            }
            imprimir(vectorEquipo1);
        }//while
        
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    public  void imprimir(char [] vector){
        System.out.print("\n");
        for (int i = 0; i < 50; i++) {
            System.out.print(vector[i]);
        }//for
        System.out.print("\n");
    }//imprimir
    
    public int generaNum(){
        Utilitario ut = new Utilitario();
        int x = ut.generarNumero();
        return x;
    }
    
}