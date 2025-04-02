public class Zamowienie {
    public String getDataZamowienia() {
        return dataZamowienia;
    }

    public void setDataZamowienia(String dataZamowienia) {
        this.dataZamowienia = dataZamowienia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int[] getIlosci() {
        return ilosci;
    }

    public void setIlosci(int[] ilosci) {
        this.ilosci = ilosci;
    }

    public Klient getKlient() {
        return klient;
    }

    public void setKlient(Klient klient) {
        this.klient = klient;
    }

    public Produkt[] getProdukty() {
        return produkty;
    }

    public void setProdukty(Produkt[] produkty) {
        this.produkty = produkty;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double obliczWartoscZamowienia(){
        double wartosc = 0;
        for (int i = 0; i < produkty.length; i++){
            wartosc += produkty[i].getCena() * ilosci[i];
        }
        return wartosc;
    }

    public void  zastosujZnizke(){
        if (klient.isCzyStaly()){
            double wartosc = obliczWartoscZamowienia();
            double znizka = wartosc * 0.1;
            System.out.println("Zastosowano zniżkę: " + znizka);
        }
    }

    public void  wyswietlSzczegoly(){
       System.out.println("ID Zamówienia: " + id);
       System.out.println("Data zamówienia: " + dataZamowienia);
       System.out.println("Status: " + status);
       System.out.println("Klient: " + klient.getImie() + " " + klient.getNazwisko());
       System.out.println("Produkty: ");
       for (int i = 0; i < produkty.length; i++){
           System.out.println("- " + produkty[i].getNazwa() + " x" + ilosci[i]);
       }
       System.out.println("Wartość zamówienia: " + obliczWartoscZamowienia());
    }

    private int id;
    private Klient klient;
    private Produkt[] produkty;

    private int[] ilosci;
    private String dataZamowienia;
    private String status;

}
