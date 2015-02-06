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
        int[] koot = {1,2,3,4,5,6,7};
        int[] arvot = {7,6,5,4,3,2,1};

        Tavara[] tavarat = new Tavara[koot.length];
        for (int i=0; i<koot.length; i++) {
            tavarat[i]=new Tavara(koot[i], arvot[i]);
        }

        Sakki sakki = new Sakki(10);
        
        Taytto taytto1 = new Taytto(tavarat, sakki);
        System.out.println(taytto1.annaTavaratMerkkijonona());

        //Koe käyttäen naiivia algoritmia
        taytto1.etsiMaksimiArvoJaJono();
        System.out.println("Arvo: " + taytto1.annaMaxArvo() + ", jono: " + taytto1.annaMaxJono());
        
        TayttoDP tayttoDP = new TayttoDP(tavarat, sakki);
        System.out.println(tayttoDP.annaTavaratMerkkijonona());

        //Koe käyttäen naiivia algoritmia
        tayttoDP.etsiMaksimiArvoJaJono();
        System.out.println("Arvo: " + tayttoDP.annaMaxArvo() + ", jono: " + tayttoDP.annaMaxJono());

//        taytto1.etsiMahtuvaSummaKombinaatioistaRek(new ArrayList(), 0, 0, summa);
//        taytto1.tulostaRatkaisut();
        
        
        
        //Etsii kombinaatiot ja niiden tuottamat summat

        //taytto.etsiSummatKombinaatioistaRek(new ArrayList(), 0, 0);
        //Tulostaa kombinaatiot ja niiden summat
        //taytto.muodostaKombinaatioRek(jono, 0);

        //taytto.tulostaSummatJaJonot();

        //System.out.println(taytto.annaSummatJaJonotMerkkijonona());
        


        
        
        
        
    }
}
