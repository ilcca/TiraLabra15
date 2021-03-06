/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.tiralabra_maven;

/**
 * Suorittaa täytön naiivilla algoritmilla 
 * @author ilkkaporna
 */

public class Taytto {
    private Tavara[] tavarat;
    private Sakki sakki;
    private int maxArvo;
    private String maxJono;
    
    /**
     * Saa käytössä olevat Tavarat ja Sakin täyttöä varten
     * 
     * @param tavarat 
     * @param sakki
     */
    public Taytto (Tavara[] tavarat, Sakki sakki) {
        this.sakki = sakki;
        this.tavarat = tavarat;        
    }

    
    /**
     * Tällä aloitetaan Naiivin algoritmin rekurssiivinen suoritus
     *  
     */
    public void etsiMaksimiArvoJaJono() {
        etsiMaksimiArvoJaJonoRek(this.sakki.annaKoko(), 0, "", this.tavarat.length);    
    }

    /**
     * Suorittaa naiivin-algoritmin maksimiarvon ja taulukon muistipaikkajonon etsimiselle rekurssiivisesti yksi kombinaatiohaara kerrallaan.
     * @param paino
     * @param lkm
     * @return 
     */
    private boolean etsiMaksimiArvoJaJonoRek(int paino, int arvo, String jono, int lkm) {
        //System.out.println(lkm + " " + paino + " " + arvo);
        
        // Haara käyty loppuun
        if (lkm == 0 || paino == 0) {
            if (arvo>maxArvo) {
                this.maxArvo=arvo;
                this.maxJono=jono;
            }
            return true;
        }

        // Jos käsittelyssä oleva tavara liian iso tässä kohtaa haaraa, niin siirrytään seuraavaan tavaraan
        if (tavarat[lkm-1].annaKoko() > paino)
            return etsiMaksimiArvoJaJonoRek(paino, arvo, jono, lkm-1);

        // Valitaan otetaanko mukaan käsittelyssä oleva tavara vai saadanko parempi arvo seuraavista
        else {
            int arvoUusi = arvo + tavarat[lkm-1].annaArvo(); 
            int painoUusi = paino-tavarat[lkm-1].annaKoko();
            String jonoUusi = jono + " " + lkm;
            
            etsiMaksimiArvoJaJonoRek(painoUusi, arvoUusi, jonoUusi, lkm-1);
            etsiMaksimiArvoJaJonoRek(paino, arvo, jono, lkm-1);
            return true;
        }
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
    /**Palauttaa Sakin
     *
     * @return
     */
    public Sakki annaSakki() {
        return this.sakki;        
    }


    /**Palauttaa löydetyn maksimi arvon täytölle
     *
     * @return
     */
    public int annaMaxArvo() {
        return this.maxArvo;        
    }
    /**Palauttaa löydetyn maksimiarvon toteuttavan tavarajonon
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
