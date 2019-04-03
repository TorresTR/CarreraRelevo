package com.udec.relevo;

/**
 * Se importan als variables en la clase principal, para podert trabajar con ellas
 */
import static com.udec.relevo.Logica.pasosEquipo1;
import static com.udec.relevo.Logica.vectorEquipo1;
import static com.udec.relevo.Logica.imprimir;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que se encarga de manejar la clase de corredor2
 * @author David
 */
public class Corredor3 extends Thread {
    
    /**
     * Guarda el color del equipo al cual pertenece el corredor 
     */
    private String color;

    /**
     * variable Integer en la cual se almacena los pasos del equipo
     */
    private Integer dat;
    
    /**
     * variable usuada para romper el ciclo while del hilo
     */
    private boolean conti = true;
    /**
     * Contructor donde Recibe la variable de pasos del equipo uno que por defecto es 0
     * y se inicializa el color del equipo el cual es un ddistintivo para cada equipo
     * @param x = varibale Integer estatica que se envia al contructor y se inicializa
     */
    public Corredor3(Integer x) {
        this.color = "Amarrillo";
        this.dat =x;
    }

    /**
     * metodo run hace un recorrido en el cual al llegar a su tope o la pocision maxima del corredor C este 
     * llama a un objeto syncronized para dar su respectivo .notify();
     */
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

    /**
     * retorna el valor del bolean 
     * @return 
     */
    public boolean isConti() {
        return conti;
    }

    /**
     * permite asignar un valor al bolean
     * @param conti 
     */
    public void setConti(boolean conti) {
        this.conti = conti;
    }

    
    /**
     * Retorna el color que tiene asignado el corredor del equipo
     * @return 
     */
    public String getColor() {
        return color;
    }

    /**
     * Asigna un color al corredor del equipo
     * @param color 
     */
    public void setColor(String color) {
        this.color = color;
    }
    
    /**
     * Invoca el metodo generar numero de la calse utilizarios ek cual es un radom entre 0 - 3 con el cual se realizará
     * el desplazamiento de los corredores
     * @return 
     */
    public int generaNum(){
        Utilitario ut = new Utilitario();
        int x = ut.generarNumero();
        return x;
    }
    
}