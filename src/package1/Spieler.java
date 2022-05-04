class Spieler {
    String name = "";
    int nr=0;
    int punkt;
    public void Spiler(String name,int nr) {
        this.name=name;
        this.nr=nr;
        resetPunkte();

    }

    public  String getname() {
        return this.name;
    }
    public  int getnummer() {
        return this.nr;
    }
    public  int getPunkte() {
        return this.punkt;
    }

    public  void resetPunkte() {
        this.punkt=0;
    }

    public  void addPunkte(int punkt) {
        this.punkt=this.punkt+punkt;

    }


}
	