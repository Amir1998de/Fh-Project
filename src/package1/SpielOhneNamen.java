package package1;

import java.util.Random;
import java.util.Scanner;

public class SpielOhneNamen {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        boolean erg=false;
        int spielernum = 1;
        int zeile=0;
        int spalte=0;
        int punktspieler1=0;
        int punktspieler2 = 0;
        String richtung=" ";
        int gamezeile=0;
        int gamespalte=0;
        Spieler spieler1 = new Spieler();
        Spieler spieler2 = new Spieler();
        Spielfeld sp = new Spielfeld();

        Scanner scanner=new Scanner(System.in);
        System.out.println("SpielOhneNamen");
        System.out.println("");
        System.out.println("Anzahl der Zeilen:");
        gamezeile= scanner.nextInt();
        System.out.println("Anzahl der Spalten:");
        gamespalte= scanner.nextInt();
        sp.Spielfeld(gamezeile, gamespalte);
        sp.ausgabeSpielfeld();
        sp.druckeSpielfeld();


        // Spieler anrufen
        spieler1.Spiler("Donald", 1);
        spieler2.Spiler("Mickey", 2);



        // Beginn Spielzug
        while(erg==false) {
            if(spielernum==1) {
                System.out.println("");
                System.out.println(spieler1.getname());
                System.out.print("Zeile: ");
                zeile= scanner.nextInt();
                System.out.print("Spalte: ");
                spalte= scanner.nextInt();
                System.out.print("richtung: (r oder o)");
                richtung= scanner.next();
                //Set Spielzug
                if(sp.führeZugAus(spieler1, zeile, spalte, richtung)) {
                    spielernum=2;
                    punktspieler1=spieler1.getPunkte();
                }else {
                    System.out.println("Falsche Eingabe");
                }
                // Test das Ergebmis
                if(testeEnde(sp.gameboard)) {
                    erg=true;
                    if(punktspieler1>punktspieler2) {

                        System.out.println("");
                        System.out.println("***Spieler 1 hat gewonnen***");
                        break;
                    }}
            }if(spielernum==2) {
                System.out.println("");
                System.out.println(spieler2.getname());
                System.out.print("Zeile: ");
                zeile= scanner.nextInt();
                System.out.print("Spalte: ");
                spalte= scanner.nextInt();
                System.out.print("richtung: (r oder o)");
                richtung= scanner.next();
                //Set Spielzug
                if(sp.führeZugAus(spieler1, zeile, spalte, richtung)) {
                    spielernum=1;
                    punktspieler2=spieler2.getPunkte();
                }else {
                    System.out.println("Falsche Eingabe");
                }
                // Test das Ergebmis
                if(testeEnde(sp.gameboard)) {
                    erg=true;
                    if(punktspieler1>punktspieler2) {
                        System.out.println("");
                        System.out.println("***Spieler 2 hat gewonnen***");
                        break;
                    }
                }}
        } // while

        scanner.close();
        // Ende des Spiels
    }


//Set Spielzug

    public static boolean testeEnde(char[][] gameBoard){
        boolean erg=false; // true = gewinnen  // false = noch nicht gewinnen





        return erg;
    }

}


