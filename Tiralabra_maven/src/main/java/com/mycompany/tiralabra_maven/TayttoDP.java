/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.tiralabra_maven;

import java.util.ArrayList;

/**
 * Taytto saa säkin ja tavarat. Suorittaa erilaisia täyttöoperaatioita mm. naiivi täyttö ja DP-täyttö ja tulostusominaisuuksia
 * @author ilkkaporna
 */

public class TayttoDP {
    private Tavara[] tavarat;
    private Sakki sakki;
    private int maxArvo;
    private String maxJono;
    
    /**
     * ALustaa Luokkamuuttujat täyttövaihtoehtojen ajamiselle
     * 
     * @param tavarat 
     * @param sakki
     */
    public TayttoDP (Tavara[] tavarat, Sakki sakki) {
        this.sakki = sakki;
        this.tavarat = tavarat;        
    }

    public void etsiMaksimiArvoJaJono() {
        etsiMaksimiArvoJaJonoRek(this.sakki.annaKoko(), this.tavarat.length);    
    }
    
    /**
     * Dynamic programming -algoritmi
     * @param paino
     * @param lkm 
     */
    private void etsiMaksimiArvoJaJonoRek(int paino, int lkm) {

        
        //Alustetaan taulun reunat 
        int[][] taulu= new int[lkm+1][paino+1];
        /*
        for (int i=0; i<=lkm;i++) {
            taulu[i][0]=0;
        }
        for (int i=0; i<=paino;i++) {
            taulu[0][i]=0;
        }
        */
        for (int i = 0; i <= lkm; i++)
        {
            for (int w = 0; w <= paino; w++)
            {
                if (i==0 || w==0)
                    taulu[i][w] = 0;
                else if (this.tavarat[i-1].annaKoko() <= w)
                      taulu[i][w] = Math.max(this.tavarat[i-1].annaArvo() + taulu[i-1][w-this.tavarat[i-1].annaKoko()],  taulu[i-1][w]);
                else
                      taulu[i][w] = taulu[i-1][w];
            }
        }
 
        // Tallettaa löytyneen max-arvon luokkamuuttujiin
        this.maxArvo =  taulu[lkm][paino];

        // Etsitään taulusta maksimin tuottava jono "peruuttamalla" 
        String jono = "";
        
        int i = lkm;
        int j = paino;
        while (i>0 && j> 0) {
            if (taulu[i][j]!=taulu[i-1][j]) {
                jono += " " + i;
                i = i-1;
                j = j - (this.tavarat[i].annaKoko());
            }
            else {
                i = i-1;
            }
        }

        this.maxJono = jono;
                        
    }

    
    public Tavara[] annaTavarat() {
        return this.tavarat;        
    }

/**
 * Antaa kaikkien tavaroiden tiedot yhtenä merkkijonona
 * @return 
 */
    public String annaTavaratMerkkijonona() {
        String tulos="";
        for (int i=0; i<tavarat.length; i++) {
            tulos += "Indeksi: " + i + ", koko: " + tavarat[i].annaKoko() + ", arvo: " + tavarat[i].annaArvo() + "; ";
        }
        return tulos;
    }
    /**
     *
     * @return
     */
    public Sakki annaSakki() {
        return this.sakki;        
    }


    /**
     *
     * @return
     */
    public int annaMaxArvo() {
        return this.maxArvo;        
    }
    /**
     *
     * @return
     */
    public String annaMaxJono() {
        return this.maxJono;        
    }
    /**
     *Tulostaa heti kaikkien tavaroiden tiedot
     */
    public void tulostaTavarat() {

        for (int i=0; i<tavarat.length; i++) {
            System.out.println("Indeksi: " + i + ", koko: " + tavarat[i].annaKoko() + ", arvo: " + tavarat[i].annaArvo());
            
        }
    }

}
