import java.time.LocalDate;

public class SklepKomputerowy {
    private Produkt[] produkty = new Produkt[10];
    private Klient[] klienci = new Klient[10];
    private Zamowienie[] zamowienia = new Zamowienie[10];
    private int liczbaProduktow;
    private int liczbaKlientow;
    private int liczbaZamowien;

    public void dodajProdukt(Produkt produkt){
        if (liczbaProduktow < produkty.length) {
            produkty[liczbaProduktow++] = produkt;
            System.out.println("Dodano produkt: " + produkt.getNazwa());
        } else {
            System.out.println("Brak miejsca na nowy produkt.");
        }
    }

    public void usunProdukt(int id) {
        for (int i = 0; i < liczbaProduktow; i++){
            if (produkty[i].getId() == id) {
                produkty[i] = produkty[--liczbaProduktow];
                System.out.println("Usunięto produkt o ID: " + id);
                return;
            }
        }
        System.out.println("Produkt o ID " + id + " nie został znaleziony.");
    }
    public void dodajKlienta(Klient klient){
        if (liczbaKlientow < klienci.length) {
            klienci[liczbaKlientow++] = klient;
            System.out.println("Dodano klienta: " + klient.getImie() + " " + klient.getNazwisko());
        } else {
            System.out.println("Brak miejsca na nowego klienta.");
        }
    }

    public Zamowienie utworzZamowienie(Klient klient1, Produkt[] produktyZamowienia1, int[] ilosciZamowienia1) {
        Zamowienie zamowienie = new Zamowienie();
        zamowienie.setId(0);
        zamowienie.setKlient(klient1);
        zamowienie.setProdukty(produktyZamowienia1);
        zamowienie.setIlosci(ilosciZamowienia1);
        zamowienie.setDataZamowienia(LocalDate.now().toString());
        zamowienie.setStatus("Nowe");
        return zamowienie;
    }

    public void aktualizujStanMagazynowy(Zamowienie zamowienie) {
        Produkt[] zamowioneProdukty = zamowienie.getProdukty();
        int[] ilosci = zamowienie.getIlosci();
        for (int i =0; i < zamowioneProdukty.length; i++){
            zamowioneProdukty[i].setIloscWMagazynie(
                    zamowioneProdukty[i].getIloscWMagazynie() - ilosci[i]
            );
        }System.out.println("Zaktualizowano stan magazynowy.");
    }

    public void wyswietlProduktyWKategorii(String kategoria) {
        System.out.println("Produkty w kategorii: " + kategoria);
        for (Produkt produkt : produkty) {
            if (produkt != null && produkt.getKategoria().equals(kategoria)){
                produkt.wyswietlInformacje();
            }
        }
    }

    public void zmienStatusZamowienia(int idZamowienia, String nowyStatus) {
        for (Zamowienie zamowienie : zamowienia) {
           if (zamowienie != null && zamowienie.getId() == idZamowienia) {
               zamowienie.setStatus(nowyStatus);
               System.out.println("Zmieniono status zamówienia na: " + nowyStatus);
               return;
           }
        }
        System.out.println("Nie znaleziono zamówienia o ID: " + idZamowienia);
    }

    public void wyswietlZamowieniaKlienta(int idKlienta) {
        System.out.println("Zamówienia klienta o ID: " + idKlienta);
        for (Zamowienie zamowienie : zamowienia) {
            if (zamowienie != null && zamowienie.getKlient().getId() == idKlienta) {
                zamowienie.wyswietlSzczegoly();
            }
        }
    }

    public void generujRaportSprzedazy() {
        System.out.println("\n=== Raport sprzedaży ===");
        double suma = 0;
        for (Zamowienie zamowienie : zamowienia) {
            if (zamowienie != null) {
                double wartosc = zamowienie.obliczWartoscZamowienia();
                suma += wartosc;
                System.out.println("Zamówienie ID: " + zamowienie.getId() + ", Wartość: " + wartosc + " PLN");
            }
        }
        System.out.println("Łączna wartość sprzedaży: " + suma + " PLN");
    }
}
