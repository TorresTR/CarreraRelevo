package com.udec.relevo;

/**
 *
 * @author David
 */
public class Corredor9 extends Thread {
    
    private String color;

    public Corredor9() {
        this.color = "Azul";
    }

    @Override
    public void run() {
       
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    
    
}
