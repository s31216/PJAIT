import java.util.ArrayList;

public class SystemRezerwacji {
    private ArrayList<Wydarzenie> wydarzenia;
    private ArrayList<Klient> klienci;

    public SystemRezerwacji() {
        wydarzenia = new ArrayList<>();
        klienci = new ArrayList<>();
    }

    // Dodawanie wydarzenia
    public void dodajWydarzenie(Wydarzenie wydarzenie) {
        wydarzenia.add(wydarzenie);
    }

    public void dodajWydarzenie(String nazwa, double cena) {
        wydarzenia.add(new Wydarzenie(nazwa, cena));
    }

    // Dodawanie klienta
    public void dodajKlienta(Klient klient) {
        klienci.add(klient);
    }

    public void dodajKlienta(String imię, String nazwisko, String email) {
        klienci.add(new Klient(imię, nazwisko, email));
    }

    public void dokonajRezerwacji(Klient klient, Wydarzenie wydarzenie) {
        if (wydarzenie.zarezerwujMiejsce()) {
            klient.dodajRezerwację(wydarzenie);
        } else {
            System.out.println("Brak dostępnych miejsc na wydarzenie: " + wydarzenie.getNazwa());
        }
    }

    public Wydarzenie znajdźWydarzenie(String nazwa) {
        for (Wydarzenie w : wydarzenia) {
            if (w.getNazwa().equalsIgnoreCase(nazwa)) {
                return w;
            }
        }
        return null;
    }

    public Klient znajdźKlienta(String nazwisko) {
        for (Klient k : klienci) {
            if (k.getNazwisko().equalsIgnoreCase(nazwisko)) {
                return k;
            }
        }
        return null;
    }

    public void zmieńCenęWydarzenia(String nazwa, double nowaCena) {
        Wydarzenie wydarzenie = znajdźWydarzenie(nazwa);
        if (wydarzenie != null) {
            wydarzenie.setCena(nowaCena);
        }
    }
}
