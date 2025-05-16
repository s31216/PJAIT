import java.util.ArrayList;

public class Klient {
    private String imię;
    private String nazwisko;
    private String email;
    private ArrayList<Wydarzenie> listaRezerwacji;

    // Konstruktor 1
    public Klient(String imię, String nazwisko) {
        this(imię, nazwisko, "brak@email.com");
    }

    // Konstruktor 2
    public Klient(String imię, String nazwisko, String email) {
        this.imię = imię;
        this.nazwisko = nazwisko;
        this.email = email;
        this.listaRezerwacji = new ArrayList<>();
    }

    public String getImię() {
        return imię;
    }

    public void setImię(String imię) {
        this.imię = imię;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void dodajRezerwację(Wydarzenie wydarzenie) {
        listaRezerwacji.add(wydarzenie);
    }

    public void wyświetlRezerwacje() {
        if (listaRezerwacji.isEmpty()) {
            System.out.println("Brak rezerwacji.");
        } else {
            for (Wydarzenie w : listaRezerwacji) {
                System.out.println(w);
            }
        }
    }

    public void anulujRezerwację(Wydarzenie wydarzenie) {
        listaRezerwacji.remove(wydarzenie);
    }
}
