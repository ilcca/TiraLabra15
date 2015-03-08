/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.tiralabra_maven;


/**
 * Sakki olioon asetetaan säkin maximi kestävyys
 * 
 * @author ilkkaporna
 */
public class Sakki {
    private final int koko;
    
/**Luodaan Sakki
 * 
 * @param koko SÄkin max kestävyys
 */    
    public Sakki(int koko){
        this.koko=koko;
    }
    public int annaKoko(){
        return this.koko;
    }
    
}
