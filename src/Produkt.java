public class Produkt {

    private int id;
    private String nazwa;
    private String kategoria;
    private double cena;
    private int iloscWMagazynie;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIloscWMagazynie() {
        return iloscWMagazynie;
    }

    public void setIloscWMagazynie(int iloscWMagazynie) {
        this.iloscWMagazynie = iloscWMagazynie;
    }

    public String getKategoria() {
        return kategoria;
    }

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public void setCena(double cena) {
        if(cena <0 ){
            this.cena = 0;
        }
        this.cena = cena;
    }

    public double getCena() {
        return cena;
    }

    public void wyswietlInformacje() {
        System.out.println("id: " + id);
        System.out.println("nazwa: " + nazwa);
        System.out.println("kategoria: " + kategoria);
        System.out.println("cena: " + cena);
        System.out.println("ilosc w magazynie: " + iloscWMagazynie);
    }


}