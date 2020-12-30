package podstawowe;


public class Pracownik {
    private String nickname;
    private Double staz;
    private String password;

    public String getNickname() {
        return nickname;
    }

    public Double getStaz() {
        return staz;
    }
    public String getPassword() {
        return password;
    }

    public String listaDodanychFilmow(){
        return null;
    }

    public Pracownik(String nickname, Double staz) {
        this.nickname = nickname;
        this.staz = staz;
    }
}
