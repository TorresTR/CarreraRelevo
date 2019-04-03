package com.udec.relevo;

/**
 * clase que se encarga del metodo que genera el rand
 * @author David
 */
public class Utilitario {
    
    /**
     * metodo que se encarga de generar un numero rand entre 0 y 3 retorna un int con el valor del numero
     * generado del rand
     * @return 
     */
    public int generarNumero(){
        int numero = (int) (Math.random() * 3);
        return numero;
    }//generarNumero
    
}
