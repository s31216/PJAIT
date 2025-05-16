public class Wydarzenie {
    private String nazwa;
    private String data;
    private String miejsce;
    private int maxLiczbaMiejsc;
    private int dostępneMiejsca;
    private double cena;

    // Konstruktor 1
    public Wydarzenie(String nazwa, double cena) {
        this(nazwa, cena, "Nieokreślona", "Nieokreślone");
    }

    // Konstruktor 2
    public Wydarzenie(String nazwa, double cena, String data) {
        this(nazwa, cena, data, "Nieokreślone");
    }

    // Konstruktor 3
    public Wydarzenie(String nazwa, double cena, String data, String miejsce) {
        this.nazwa = nazwa;
        this.cena = cena;
        this.data = data;
        this.miejsce = miejsce;
        this.maxLiczbaMiejsc = 100;
        this.dostępneMiejsca = 100;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMiejsce() {
        return miejsce;
    }

    public void setMiejsce(String miejsce) {
        this.miejsce = miejsce;
    }

    public int getMaxLiczbaMiejsc() {
        return maxLiczbaMiejsc;
    }

    public int getDostępneMiejsca() {
        return dostępneMiejsca;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public boolean zarezerwujMiejsce() {
        if (dostępneMiejsca > 0) {
            dostępneMiejsca--;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Wydarzenie: " + nazwa + ", Data: " + data + ", Miejsce: " + miejsce +
                ", Cena: " + cena + " zł, Dostępne miejsca: " + dostępneMiejsca + "/" + maxLiczbaMiejsc;
    }
}
