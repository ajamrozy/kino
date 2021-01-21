package podstawowe;

public class Film {
    private String tytul;
    private String gatunek;
    private int rokProdukcji;
    private String opis;
    private String godzina;
    private String data;

    public String getTytul() {
        return tytul;
    }
    public String getGatunek() {
        return gatunek;
    }

    public int getRokProdukcji() {
        return rokProdukcji;
    }

    public String getOpis() {
        return opis;
    }

    public String getGodzina() {
        return godzina;
    }

    public String getData() {
        return data;
    }

    public Film(String tytul, String gatunek, int rokProdukcji, String opis, String godzina, String data) {
        this.tytul = tytul;
        this.gatunek = gatunek;
        this.rokProdukcji = rokProdukcji;
        this.opis = opis;
        this.godzina = godzina;
        this.data = data;
    }
}
