package com.mycompany.tiralabra_maven;

/**
 * Pääohjelma, jolla täyttökokeita käynnistetään
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
//        int[] koot = {1,2,3,4,5,6,7,3,4,5,6,7,20,1,2,3,4,5,6,7,3,4,5,6,7,20};
//        int[] arvot = {7,6,5,4,3,2,1,4,3,4,3,4,20,7,6,5,4,3,2,1,4,3,4,3,4,20};

        int[] koot = {1,2,3,4,5,6,7,3,4,5,6,7,20};
        int[] arvot = {7,6,5,4,3,2,1,4,3,4,3,4,20};

//        int[] koot = {1,2,6};
//        int[] arvot = {3,1,1};

        Tavara[] tavarat = new Tavara[koot.length];
        for (int i=0; i<koot.length; i++) {
            tavarat[i]=new Tavara(koot[i], arvot[i]);
        }
        //Säkin koko
        Sakki sakki = new Sakki(60);

        
        //Ajetaan suorituskykytestit, toistojen lukumäärä
        Testi2 testi = new Testi2(tavarat, sakki, 10);
        testi.ajaTesti();


        tavarat = new Tavara[koot.length];
        for (int i=0; i<koot.length; i++) {
            tavarat[i]=new Tavara(koot[i], arvot[i]);
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
