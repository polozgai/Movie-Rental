package hu.elte.polozgai.movie.controller;


import hu.elte.polozgai.movie.model.Film;
import hu.elte.polozgai.movie.view.UjFilmView;
import java.io.File;
import java.nio.file.Files;
import java.sql.Blob;
import java.util.List;

/**
 *
 * @author polozgai
 */
public class UjFilmController {

    private UjFilmView ujFilmView;

    /**
     * Konstruktor. {@link UjFilmView} példányosítása.
     */
    public UjFilmController() {
        ujFilmView = new UjFilmView(this);
    }

    /**
     * {@link UjFilmView} megjelenítése.
     */
    public void show() {
        ujFilmView.setVisible(true);
    }

    /**
     * Új film felvitele.
     *
     * @param id {@link Integer}
     * @param cim {@link String}
     * @param rendezok {@link String}
     * @param foszereplok {@link String}
     * @param ev {@link String}
     * @param hossz {@link String}
     * @param adath {@link String}
     * @param filename {@link String}
     * @param eredeti {@link Boolean}
     * @throws Exception Ha az ellenõrzés sikertelen, vagy rossz az elérési út.
     */
    public void addFilm(int id, String cim, String rendezok, String foszereplok, String ev, String hossz, String adath, String filename, boolean eredeti) throws Exception {
        Blob blob = null;
        List<Film> lista = Film.init();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getCim().equals(cim) && lista.get(i).getRendezok().equals(rendezok)) {
                throw new Exception("Van már ilyen film");
            }
        }
        if (cim.matches("[0-9a-zA-Z,\\.!-:; ]+") && rendezok.matches("[a-zA-Z,\\.!-:; ]+") && foszereplok.matches("[a-zA-Z,\\.!-:; ]+") && adath.matches("[a-zA-Z]+") && ev.matches("[0-9]+") && hossz.matches("[0-9]+") && !filename.isEmpty()) {
            try {
                File file = new File(filename);
                byte[] container = Files.readAllBytes(file.toPath());
                blob = new javax.sql.rowset.serial.SerialBlob(container);
                Film film = Film.create(adath, blob, cim, eredeti, foszereplok, 0, Integer.parseInt(hossz), Integer.parseInt(ev), rendezok, false, id);
                film.addFilm(id, cim, rendezok, foszereplok, Integer.parseInt(ev), Integer.parseInt(hossz), adath, blob, eredeti, 0, false);
            } catch (Exception e) {
                throw new Exception("Hibás az elérési út!");
            }
        } else {
            throw new Exception("Hibas a mezõk kitöltése");
        }
    }
}
