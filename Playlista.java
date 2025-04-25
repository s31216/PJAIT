import java.util.ArrayList;

public class Playlista {
    private String nazwa;
    private ArrayList<String> listaUtworow;

    public Playlista(String nazwa) {
        this.nazwa = nazwa;
        this.listaUtworow = new ArrayList<>();
    }

    public String getNazwa() {
        return nazwa;
    }

    public void dodajUtwor(String utwor) {
        if (utwor == null || utwor.isBlank()) return;
        if (!listaUtworow.contains(utwor)) {
            listaUtworow.add(utwor);
        }
    }

    public void usunUtwor(String utwor) {
        listaUtworow.remove(utwor);
    }

    public void wyswietlUtwory() {
        System.out.println("Playlista: " + nazwa);
        for (int i = 0; i < listaUtworow.size(); i++) {
            System.out.println("Utwór " + (i+1) + ": " + listaUtworow.get(i));
        }
    }
}