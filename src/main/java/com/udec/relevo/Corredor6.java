package com.udec.relevo;

/**
 *
 * @author David
 */
public class Corredor6 extends Thread {
    
    private String color;

    public Corredor6() {
        this.color = "Verde";
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