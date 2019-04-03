package com.udec.relevo;

import static com.udec.relevo.Logica.pasosEquipo1;
import static com.udec.relevo.Logica.vectorEquipo1;
import static com.udec.relevo.Logica.espera;
import static com.udec.relevo.Logica.estaIgual;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author David
 */
public class Corredor2 extends Thread {
    
    
    
    private String color;

    private Integer dat;
    boolean conti = true;
    
    public Corredor2(Integer x) {
        this.color = "Amarrillo";
        this.dat = x;
    }

    @Override
    public void run() {
           if(dat <15){
                synchronized(dat){
                    
                    try {
                        dat.wait();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Corredor2.class.getName()).log(Level.SEVERE, null, ex);
                    }
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
                    if(vectorEquipo1[i]=='B'){
                        vectorEquipo1[i] ='_'; 
                        if(i+1 >=33){
                            vectorEquipo1[32] ='B';
                            synchronized(dat){
                                dat.notify();
                            }
                            conti=false;
                            break;
                        }else{
                            vectorEquipo1[i+1] ='B';
                            pasosEquipo1+=1;
                            break;
                         }//else
                    }//if
                }//for    
            }else if(numero == 2){
                 for (int i = pasosEquipo1; i < 50; i++) {
                    if(vectorEquipo1[i]=='B'){
                        vectorEquipo1[i] ='_'; 
                        if(i+2 >= 33){
                            vectorEquipo1[32] ='B';
                            synchronized(dat){
                                dat.notify();
                            }
                            conti=false;
                            break;
                        }else{
                            vectorEquipo1[i+2] ='B';
                            pasosEquipo1+=2;
                            break;
                        }//else
                    }//if
                }//for  
            }else if(numero == 3){
                for (int i = pasosEquipo1; i < 50; i++) {
                    if(vectorEquipo1[i]=='B'){
                        vectorEquipo1[i] = '_'; 
                        if(i+3>=33){
                            vectorEquipo1[32] ='B';
                            synchronized(dat){
                                dat.notify();
                            }
                            conti=false;
                            break;
                        }else{
                            vectorEquipo1[i+3] ='B';
                            pasosEquipo1+=3;
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
