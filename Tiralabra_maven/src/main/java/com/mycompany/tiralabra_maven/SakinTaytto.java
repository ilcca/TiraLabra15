package com.mycompany.tiralabra_maven;

/**
 * Pääohjelma, jolla täyttökokeita käynnistetään
 *
 */
public class SakinTaytto 
{
    public static void main( String[] args )
    {

        int toistot = 10;
        Testi testi = null;        
        int sakki = 0;

        //Uudet koot ja arvot
        int[] koot3 = {1,2,3,4,5,6,7,3,4,20,4,5,6,7,3,4,5,6,7,20,4,5,6,7,3,4,5,6,7,20};
        int[] arvot3 = {7,6,2,1,4,3,4,3,4,20,7,6,5,4,3,2,4,3,4,20,7,6,5,4,3,2,4,3,4,20};

        //Testi 30a
        sakki = 100;
        //ALustetaan suorituskykytestit
        testi = new Testi("Testi 30a", koot3, arvot3, sakki, toistot);
        //ajetaan suorituskykytestit
        testi.ajaTesti();

        //Testi 30b
        sakki = 60;
        //ALustetaan suorituskykytestit
        testi = new Testi("Testi 30b", koot3, arvot3, sakki, toistot);
        //ajetaan suorituskykytestit
        testi.ajaTesti();

        //Testi 30c
        sakki = 20;
        //ALustetaan suorituskykytestit
        testi = new Testi("Testi 30c", koot3, arvot3, sakki, toistot);
        //ajetaan suorituskykytestit
        testi.ajaTesti();

        //Uudet koot ja arvot
        int[] koot2 = {1,2,3,4,5,6,7,3,4,20,4,5,6,7,3,4,5,6,7,20};
        int[] arvot2 = {7,6,2,1,4,3,4,3,4,20,7,6,5,4,3,2,4,3,4,20};

        //Testi 20a
        sakki = 100;
        //ALustetaan suorituskykytestit
        testi = new Testi("Testi 2a", koot2, arvot2, sakki, toistot);
        //ajetaan suorituskykytestit
        testi.ajaTesti();

        //Testi 20b
        sakki = 60;
        //ALustetaan suorituskykytestit
        testi = new Testi("Testi 2b", koot2, arvot2, sakki, toistot);
        //ajetaan suorituskykytestit
        testi.ajaTesti();

        //Testi 2c
        sakki = 20;
        //ALustetaan suorituskykytestit
        testi = new Testi("Testi 2c",koot2, arvot2, sakki, toistot);
        //ajetaan suorituskykytestit
        testi.ajaTesti();

        //Testi 10        
        int[] koot = {1,2,3,4,5,6,7,3,4,20};
        int[] arvot = {7,6,2,1,4,3,4,3,4,20};

        //Testi 10a        
        sakki = 60;
        //ALustetaan suorituskykytestit
        testi = new Testi("Testi10b", koot, arvot, sakki, toistot);
        //ajetaan suorituskykytestit
        testi.ajaTesti();

        //Testi 10b       
        sakki = 20;
        //ALustetaan suorituskykytestit
        testi = new Testi("Testi1c", koot, arvot, sakki, toistot);
        //ajetaan suorituskykytestit
        testi.ajaTesti();
        

    }
}
