package com.udec.relevo;

/**
 *
 * @author David
 */
public class Corredor5 extends Thread {
    
    private String color;

    public Corredor5() {
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
