package podstawowe;

import java.time.LocalDate;

public class Pracownik {
    private String imie;
    private String nazwisko;
    private String mail;
    private String login;
    private String password;
    private LocalDate startStazu;

    public String getPassword() { return password; }
    public String getLogin(){return login;}
    public String getImie() {
        return imie;
    }
    public String getNazwisko() {
        return nazwisko;
    }
    public String getMail() {
        return mail;
    }
    public LocalDate getStartStazu(){return startStazu;}
    public String listaDodanychFilmow(){
        return null;
    }

    public Pracownik(String imie, String nazwisko, String mail, String login, String password, LocalDate startStazu) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.mail = mail;
        this.login = login;
        this.password = password;
        this.startStazu = startStazu;
    }
    }
