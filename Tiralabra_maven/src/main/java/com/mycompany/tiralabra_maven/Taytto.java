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

public class Taytto {
    private Tavara[] tavarat;
    private Sakki sakki;
    
    /**
     * ALustaa Luokkamuuttujat täyttövaihtoehtojen ajamiselle
     * 
     * @param tavarat 
     * @param sakki
     */
    public Taytto (Tavara[] tavarat, Sakki sakki) {
        this.sakki = sakki;
        this.tavarat = tavarat;
        
    }

    /**
     * Tällä aloitetaan Naiivin algoritmin rekurssiivinen suoritus alkuarvoina ko. täyttöolion saamat tiedot resursseista
     * @return 
     */
    public int etsiMaksimiArvo() {
        return etsiMaksimiArvoRek(this.sakki.annaKoko(), this.tavarat.length);    
    }
    
    /**
     * Suorittaa naiivin-algoritmin maksimiarvon etsimiselle rekurssiivisesti yksi kombinaatiohaara kerrallaan. Saa kombinaatiohaaran sijainnin ja käytettävissä olevan painon
     * @param paino
     * @param lkm
     * @return 
     */
    private int etsiMaksimiArvoRek(int paino, int lkm) {
        System.out.println(lkm + " " + paino);
        
        // Haara käyty loppuun
        if (lkm == 0 || paino == 0)
            return 0;

        // Jos käsittelyssä oleva tavara liian iso tässä kohtaa haaraa, niin siirrytään seuraavaan tavaraan
        if (tavarat[lkm-1].annaKoko() > paino)
            return etsiMaksimiArvoRek(paino, lkm-1);

        // Valitaan otetaanko mukaan käsittelyssä oleva tavara vai saadanko parempi arvo seuraavista
        else return Math.max(tavarat[lkm-1].annaArvo() + etsiMaksimiArvoRek(paino-tavarat[lkm-1].annaKoko(), lkm-1), etsiMaksimiArvoRek(paino, lkm-1));
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
     *Tulostaa heti kaikkien tavaroiden tiedot
     */
    public void tulostaTavarat() {

        for (int i=0; i<tavarat.length; i++) {
            System.out.println("Indeksi: " + i + ", koko: " + tavarat[i].annaKoko() + ", arvo: " + tavarat[i].annaArvo());
            
        }
    }

}
