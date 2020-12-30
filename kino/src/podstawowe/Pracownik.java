package podstawowe;

import all.ListaFilmow;

public class Pracownik extends ListaFilmow {
    private String nickname;
    private Double staz;

    public String getNickname() {
        return nickname;
    }

    public Double getStaz() {
        return staz;
    }

    public String listaDodanychFilmow(){
        return null;
    }

    public Pracownik(String nickname, Double staz) {
        this.nickname = nickname;
        this.staz = staz;
    }
}
