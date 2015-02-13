package com.mycompany.tiralabra_maven;

import java.util.ArrayList;

/**
 * Pääohjelma, jolla täyttökokeita ajetaan
 *
 */
public class SakinTaytto 
{
    public static void main( String[] args )
    {
        
/*
        int[] koot = {400,350,25,23,22,100,200};
        int[] arvot = {100,350,90,80,70,100,200};
*/
        int[] koot = {1,2,3,4,5,6,7,3,4,5,6,7,20,1,2,3,4,5,6,7,3,4,5,6,7,20};
        int[] arvot = {7,6,5,4,3,2,1,4,3,4,3,4,20,7,6,5,4,3,2,1,4,3,4,3,4,20};

//        int[] koot = {1,2,6};
//        int[] arvot = {3,1,1};

        Tavara[] tavarat = new Tavara[koot.length];
        for (int i=0; i<koot.length; i++) {
            tavarat[i]=new Tavara(koot[i], arvot[i]);
        }
        //Säkin koko
        Sakki sakki = new Sakki(35);

        
        //Ajetaan suorituskykytestit, toistojen lukumäärä
        Testi testi = new Testi(tavarat, sakki, 100);
        testi.ajaTesti();

        int[] koot2 = {1,2,3,4,5,6,7,3,4,5,6,7,20,1,2,3,4,5,6,7,3,4,5,6,7,20};
        int[] arvot2 = {7,6,5,4,3,2,1,4,3,4,3,4,20,7,6,5,4,3,2,1,4,3,4,3,4,20};

//        int[] koot = {1,2,6};
//        int[] arvot = {3,1,1};

        tavarat = new Tavara[koot2.length];
        for (int i=0; i<koot2.length; i++) {
            tavarat[i]=new Tavara(koot2[i], arvot2[i]);
        }

        Taytto taytto1 = new Taytto(tavarat, sakki);
        System.out.println(taytto1.annaTavaratMerkkijonona());

        //Koe käyttäen naiivia algoritmia
        taytto1.etsiMaksimiArvoJaJono();
        System.out.println("Arvo: " + taytto1.annaMaxArvo() + ", jono: " + taytto1.annaMaxJono());
        
        TayttoDP tayttoDP = new TayttoDP(tavarat, sakki);
//        System.out.println(tayttoDP.annaTavaratMerkkijonona());

        //Koe käyttäen DP-algoritmia
        tayttoDP.etsiMaksimiArvoJaJono();
        System.out.println("Arvo: " + tayttoDP.annaMaxArvo() + ", jono: " + tayttoDP.annaMaxJono());
    }
}
