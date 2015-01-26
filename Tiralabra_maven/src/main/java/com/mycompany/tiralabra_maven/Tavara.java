/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.tiralabra_maven;

/**
 * Tavara olioon asetetaan tavaran koko eli paino ja arvo
 * @author ilkkaporna
 */
public class Tavara {
    private int koko = 0;
    private int arvo = 0;

 /**
  * 
  * @param koko tavaran paino
  * @param arvo tavaran arvo
  */
    public Tavara(int koko, int arvo){
        this.koko=koko;
        this.arvo=arvo;
    }
    public int annaKoko(){
        return this.koko;
    }
    public int annaArvo(){
        return this.arvo;
    }
}
