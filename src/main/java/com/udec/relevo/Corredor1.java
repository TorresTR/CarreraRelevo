package com.udec.relevo;


import static com.udec.relevo.Logica.vectorEquipo1;
import static com.udec.relevo.Logica.pasosEquipo1;
import static com.udec.relevo.Logica.notifica;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author David
 */
public class Corredor1 extends Thread {
    
    private String color;

    private Integer dat;
    
    boolean conti = true;
    
    public Corredor1(Integer pasos) {
        this.color = "Amarrillo";
        this.dat=pasos;
    }

    @Override
    public void run() {
        vectorEquipo1[0]='A';
        vectorEquipo1[16]='B';
        vectorEquipo1[33]='C';
        while(conti){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Logica.class.getName()).log(Level.SEVERE, null, ex);
            }
            int numero = generaNum();
            if(numero==0){
                
            }else if(numero == 1){
                for (int i = 0; i < 50; i++) {
                    if(vectorEquipo1[i]=='A'){
                        vectorEquipo1[i] ='_'; 
                        if(i+1 >=15){
                            pasosEquipo1+=1;
                            vectorEquipo1[15] ='A';
                            
                            synchronized(dat){
                            dat.notify();
                            }
                            conti=false;
                            break;
                        }else{
                            vectorEquipo1[i+1] ='A';
                            pasosEquipo1+=1;
                            break;
                         }//else
                    }//if
                }//for    
            }else if(numero == 2){
                 for (int i = 0; i < 50; i++) {
                    if(vectorEquipo1[i]=='A'){
                        vectorEquipo1[i] ='_'; 
                        if(i+2 >= 15){
                            pasosEquipo1+=2;
                            vectorEquipo1[15] ='A';
                            
                            synchronized(dat){
                            dat.notify();
                            }
                            conti=false;
                            break;
                        }else{
                            vectorEquipo1[i+2] ='A';
                            pasosEquipo1+=2;
                            break;
                        }//else
                    }//if
                }//for  
            }else if(numero == 3){
                for (int i = 0; i < 50; i++) {
                    if(vectorEquipo1[i]=='A'){
                        vectorEquipo1[i] = '_'; 
                        if(i+3>=15){
                            pasosEquipo1+=3;
                            vectorEquipo1[15] ='A';
                            
                            synchronized(dat){
                            dat.notify();
                            }
                            conti=false;
                            break;
                        }else{
                            vectorEquipo1[i+3] ='A';
                            pasosEquipo1+=3;
                            break;
                        }//else
                    }//if
                }//for 
            }
            imprimir(vectorEquipo1);
        }//while
    }

   
    public  void imprimir(char [] vector){
        System.out.print("\n");
        for (int i = 0; i < 50; i++) {
            System.out.print(vector[i]);
        }//for
        System.out.print("\n");
    }//imprimir
    
    public void detener(){
        conti=false;
    }
    
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    public int generaNum(){
        Utilitario ut = new Utilitario();
        int x = ut.generarNumero();
        return x;
    }
    
}
