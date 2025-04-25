import java.util.ArrayList;

public class BibliotekaMuzyczna {
    private String nazwa;
    private String wlasciciel;
    private ArrayList<String> utwory;
    private ArrayList<Playlista> playlisty;

    public BibliotekaMuzyczna(String nazwa, String wlasciciel) {
        this.nazwa = nazwa;
        this.wlasciciel = wlasciciel;
        this.utwory = new ArrayList<>();
        this.playlisty = new ArrayList<>();
    }

    public void dodajUtwor(String utwor) {
        if (utwor == null || utwor.isBlank()) return;
        if (!utwory.contains(utwor)) {
            utwory.add(utwor);
        }
    }

    public void usunUtwor(String utwor) {
        utwory.remove(utwor);
        for (Playlista p : playlisty) {
            p.usunUtwor(utwor);
        }
    }

    public void wyswietlUtwory() {
        System.out.println("Utwory w bibliotece: " + nazwa);
        for (String utwor : utwory) {
            System.out.println("- " + utwor);
        }
    }

    public void wyszukajUtwory(String fraza) {
        if (fraza == null) fraza = "";
        System.out.println("Wyniki wyszukiwania dla: \"" + fraza + "\"");
        for (String utwor : utwory) {
            if (utwor.toLowerCase().contains(fraza.toLowerCase())) {
                System.out.println("- " + utwor);
            }
        }
    }

    public void utworzPlayliste(String nazwa) {
        if (znajdzPlayliste(nazwa) == null) {
            playlisty.add(new Playlista(nazwa));
        }
    }

    public Playlista znajdzPlayliste(String nazwa) {
        for (Playlista p : playlisty) {
            if (p.getNazwa().equalsIgnoreCase(nazwa)) {
                return p;
            }
        }
        return null;
    }

    public void dodajUtworDoPlaylisty(String utwor, String nazwaPlaylisty) {
        Playlista p = znajdzPlayliste(nazwaPlaylisty);
        if (p != null && utwory.contains(utwor)) {
            p.dodajUtwor(utwor);
        }
    }

    public void wyswietlPlayliste(String nazwaPlaylisty) {
        Playlista p = znajdzPlayliste(nazwaPlaylisty);
        if (p != null) {
            p.wyswietlUtwory();
        }
    }

    public void wyswietlWszystkiePlaylisty() {
        System.out.println("Playlisty w bibliotece:");
        for (Playlista p : playlisty) {
            System.out.println("- " + p.getNazwa());
        }
    }

    public int getLiczbaUtworow() {
        return utwory.size();
    }

    public int getLiczbaPlaylist() {
        return playlisty.size();
    }
} 