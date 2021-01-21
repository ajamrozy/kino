package podstawowe;

public class Bilet {
    private String rodzaj;
    private double cena;

    public String getRodzaj() {
        return rodzaj;
    }

    public double getCena() {
        return cena;
    }


    public Bilet(double cena, String rodzaj) {
        this.cena = cena;
        this.rodzaj = rodzaj;
    }
}
