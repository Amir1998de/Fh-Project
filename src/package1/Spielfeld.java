class Spielfeld {
    int zeile=0;
    int spalte=0;
    char[][] gameboard;
    char[] alphabet = {'A','B','C','D','E','F','G','H','I',
            'J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

    Random rand = new Random();

    public void Spielfeld(int zeile,int spalte) {
        gameboard=new char[zeile][spalte];
    }


    // Hauptfeld + Board
    public  void ausgabeSpielfeld(){
        for(int i=0;i<this.gameboard.length;i++) {
            for(int j=0;j<this.gameboard[i].length;j++) {
                this.gameboard[i][j]=alphabet[rand.nextInt(25)];
            }
        }
    }

    public  void druckeSpielfeld(){
        System.out.print("  ");
        for(int m=0;m<=this.gameboard.length;m++) {
            System.out.print(m);
            System.out.print(" ");
        }
        System.out.println("");

        for(int i=0;i<this.gameboard.length;i++) {
            System.out.print(i);
            System.out.print(" ");
            for(int j=0;j<this.gameboard[i].length;j++) {
                System.out.print(this.gameboard[i][j]);
                System.out.print(" ");
            }
            System.out.println("");
        }
        System.out.println(" ");
    }
    public  boolean testeZug(int zeile,int spalte,String richtung){
        boolean erg;
        // überpruft, Ob Spielzug im richtigen Block kommt?
        // oder zeile und spalte gültig sind?
        if(zeile>=0 && spalte>=0
                &&zeile<this.gameboard.length
                && spalte<this.gameboard[1].length
                && this.gameboard[zeile][spalte] != ' '
                && (richtung.equals("o") || richtung.equals("r") )) {

            //wenn richtig ist
            erg=true;
        }else { erg=false;}

        return erg;
    }

    public  boolean führeZugAus(Spieler spieler,int zeile,int spalte,String richtung){
        boolean erg=false;

        if(richtung.equals("r")) {
            if(testeZug(zeile,spalte,richtung) && spalte!=this.gameboard.length)  {
                char heap=' ';
                char heap2=' ';
                heap=this.gameboard[zeile][spalte];
                heap2=this.gameboard[zeile][spalte+1];
                this.gameboard[zeile][spalte] =heap2;
                this.gameboard[zeile][spalte+1]=heap;
                erg=true;

                if(spalte<(this.gameboard.length-1) && this.gameboard[zeile][spalte+1]==this.gameboard[zeile][spalte+2]) {
                    spieler.punkt=punkt(this.gameboard[zeile][spalte+2]);
                    this.gameboard[zeile][spalte+2] = ' ';

                    erg =true;
                }else if(this.gameboard[zeile][spalte]==this.gameboard[zeile][spalte+1]) {
                    spieler.punkt=(punkt(this.gameboard[zeile][spalte+1]))*2;
                    this.gameboard[zeile][spalte] = ' ';
                    this.gameboard[zeile][spalte+1] = ' ';

                    erg =true;
                }
                druckeSpielfeld();
            }else {
                druckeSpielfeld();
                erg =false;}
        }


        if(richtung.equals("o")) {

            if(zeile!=0 && spalte!=0) {
                if(testeZug(zeile,spalte,richtung) ) {

                    char heap=' ';
                    char heap2=' ';
                    heap=this.gameboard[zeile][spalte];
                    heap2=this.gameboard[zeile-1][spalte];
                    this.gameboard[zeile][spalte] =heap2;
                    this.gameboard[zeile-1][spalte]=heap;
                    erg=true;

                    if(zeile>1 && this.gameboard[zeile-1][spalte]==this.gameboard[zeile-2][spalte]) {
                        spieler.punkt=punkt(this.gameboard[zeile-2][spalte]);
                        this.gameboard[zeile-2][spalte] = ' ';

                        erg =true;
                    }else if(this.gameboard[zeile][spalte]==this.gameboard[zeile-1][spalte]) {
                        spieler.punkt=(punkt(this.gameboard[zeile-1][spalte]))*2;
                        this.gameboard[zeile][spalte] = ' ';
                        this.gameboard[zeile-1][spalte] = ' ';

                        erg =true;
                    }
                    druckeSpielfeld();

                }else {
                    druckeSpielfeld();
                    erg =false;}  }
        }


        return erg;
    }


    public int punkt(char c) {
        int erg=0;
        int punkt=0;
        for(int i=0;i<this.alphabet.length;i++) {
            punkt++;
            if(c==alphabet[i]) {
                erg=punkt;
            }
        }
        return erg;
    }
    public  boolean testeEnde(char[][] gameBoard){
        // Ich habe viel versucht, aber leider funktioniert nicht:(
        boolean erg=true;
        int count =0;

        for(int i=0;i<this.gameboard.length;i++) {
            for(int m=0;m<this.alphabet.length;m++){
                for(int j=0;j<this.gameboard[i].length;j++){
                    if(this.gameboard[i][j] == this.alphabet[m] ){
                        count++;
                    }
                }

            }
        }
        if(count>=2) {
            erg=false;
        }
        return erg;
    }
}
