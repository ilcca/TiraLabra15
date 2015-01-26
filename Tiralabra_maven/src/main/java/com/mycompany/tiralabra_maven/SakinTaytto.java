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
        int[] koot = {400,25,23,22};
        int[] arvot = {100,90,80,70};

        Tavara[] tavarat = new Tavara[koot.length];
        for (int i=0; i<koot.length; i++) {
            tavarat[i]=new Tavara(koot[i], arvot[i]);
        }

        Sakki sakki = new Sakki(430);
        
        Taytto taytto1 = new Taytto(tavarat, sakki);
        System.out.println(taytto1.annaTavaratMerkkijonona());

        //Koe käyttäen naiivia algoritmia
        System.out.println(taytto1.etsiMaksimiArvo());
        
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
