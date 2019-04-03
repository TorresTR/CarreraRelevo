/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.relevo;

/**
 *
 * @author David
 */
public class Corredor4 extends Thread {
    
    private String color;

    public Corredor4() {
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