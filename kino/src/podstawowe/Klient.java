package podstawowe;

import all.ListaRezerwacji;

public class Klient extends ListaRezerwacji {
    private String imie;
    private String nazwisko;
    private String mail;
    private String password;

    public String getPassword() { return password; }
    public String getImie() {
        return imie;
    }
    public String getNazwisko() {
        return nazwisko;
    }
    public String getMail() {
        return mail;
    }
    public String listaDodanychFilmow(){
        return null;
    }

    public Klient(String imie, String nazwisko, String mail, String password) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.mail = mail;
        this.password = password;
    }
}
