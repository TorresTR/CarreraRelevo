package com.udec.relevo;


/**
 * Se importan als variables en la clase principal, para podert trabajar con ellas
 */
import static com.udec.relevo.Logica.vectorEquipo3;
import static com.udec.relevo.Logica.pasosEquipo3;
import static com.udec.relevo.Logica.imprimir3;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que se encarga de manejar la clase de corredor8
 * @author David
 */
public class Corredor8 extends Thread {
    
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
     * @param pasos = varibale Integer estatica que se envia al contructor y se inicializa
     */
    
    public Corredor8(Integer pasos) {
        this.color = "Azul";
        this.dat=pasos;
    }

    /**
     * metodo run hace un recorrido en el cual al llegar a su tope o la pocision maxima del corredor W este 
     * llama a un objeto syncronized para dar su respectivo .notify();
     */
    @Override
    public void run() {
         if(pasosEquipo3 <=14){
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
                for (int i = 0; i < 50; i++) {
                    if(vectorEquipo3[i]=='X'){
                        vectorEquipo3[i] ='_'; 
                        if(i+1 >=31){
                            pasosEquipo3+=1;
                            vectorEquipo3[32] ='X';
                            
                            synchronized(dat){
                            dat.notify();
                            }
                            conti=false;
                            break;
                        }else{
                            vectorEquipo3[i+1] ='X';
                            pasosEquipo3+=1;
                            break;
                         }//else
                    }//if
                }//for    
            }else if(numero == 2){
                 for (int i = 0; i < 50; i++) {
                    if(vectorEquipo3[i]=='X'){
                        vectorEquipo3[i] ='_'; 
                        if(i+2 >= 31){
                            pasosEquipo3+=2;
                            vectorEquipo3[32] ='X';
                            
                            synchronized(dat){
                            dat.notify();
                            }
                            conti=false;
                            break;
                        }else{
                            vectorEquipo3[i+2] ='X';
                            pasosEquipo3+=2;
                            break;
                        }//else
                    }//if
                }//for  
            }else if(numero == 3){
                for (int i = 0; i < 50; i++) {
                    if(vectorEquipo3[i]=='X'){
                        vectorEquipo3[i] = '_'; 
                        if(i+3>=31){
                            pasosEquipo3+=3;
                            vectorEquipo3[32] ='X';
                            
                            synchronized(dat){
                            dat.notify();
                            }
                            conti=false;
                            break;
                        }else{
                            vectorEquipo3[i+3] ='X';
                            pasosEquipo3+=3;
                            break;
                        }//else
                    }//if
                }//for 
            }
            imprimir3(vectorEquipo3);
        }//while
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
