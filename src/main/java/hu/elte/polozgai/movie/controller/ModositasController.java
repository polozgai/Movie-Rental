package hu.elte.polozgai.movie.controller;

import hu.elte.polozgai.movie.model.Film;
import hu.elte.polozgai.movie.view.ModositasView;
import java.io.File;
import java.nio.file.Files;
import java.sql.Blob;

/**
 *
 * @author polozgai
 */
public class ModositasController {
    
    private ModositasView view;
    private Film film;
    
    /**
     * Konstruktor.
     * {@link hu.elte.progtech2.film.controller.ModositasController} p�ld�nyos�t�sa.
     * {@link hu.elte.progtech2.film.model.Film} p�ld�nyos�t�sa.
     */
    public ModositasController(){
        view=new ModositasView(this);
        this.film=null;
    }
    
    /**
     * {@link hu.elte.progtech2.film.view.ModositasView} p�ld�nyos�t�sa �s megjelen�t�se.
     */
    public void show(){
        view=new ModositasView(this);
        view.setVisible(true);
    }

    /**
     * Be�ll�tja a filmet.
     * @param film {@link hu.elte.progtech2.film.model.Film}
     */
    public void setFilm(Film film) {
        this.film = film;
    }

    /**
     * Visszadja a filmet.
     * @return {@link hu.elte.progtech2.film.model.Film}
     */
    public Film getFilm() {
        return film;
    }
    
    /**
     * Film m�dos�t�sa
     * @param id {@link java.lang.Integer}
     * @param cim {@link java.lang.String}
     * @param rendezok {@link java.lang.String}
     * @param foszereplok {@link java.lang.String}
     * @param ev {@link java.lang.String}
     * @param hossz {@link java.lang.String}
     * @param adathordozotipus {@link java.lang.String}
     * @param boritokep {@link java.lang.String}
     * @param eredeti {@link java.lang.Boolean}
     * @param hanyszor {@link java.lang.String}
     * @param visszahozva {@link java.lang.Boolean}
     * @throws Exception Ha nem helyes az adatokra vonatkoz� megszor�t�s, vagy nem l�tezik a f�jl
     */
    public void editFilm(int id,String cim,String rendezok,String foszereplok,String ev,String hossz,String adathordozotipus,String boritokep,boolean eredeti,String hanyszor,boolean visszahozva) throws Exception{
        Blob blob=null;
        if(cim.matches("[a-zA-Z,\\.!-:; ]+") && rendezok.matches("[a-zA-Z,\\.!-:; ]+") && foszereplok.matches("[a-zA-Z,\\.!-:; ]+") && adathordozotipus.matches("[a-zA-Z ]+") && ev.matches("[0-9]+") && hossz.matches("[0-9]+") && hanyszor.matches("[0-9]+") && !boritokep.isEmpty()){
            try{
                File file=new File(boritokep);
                byte[] container=Files.readAllBytes(file.toPath());
                blob=new javax.sql.rowset.serial.SerialBlob(container);

                Film film=Film.create(adathordozotipus, blob, cim, eredeti, foszereplok, Integer.parseInt(hanyszor), Integer.parseInt(hossz), Integer.parseInt(ev), rendezok, visszahozva, id);

                film.editFilm(id, cim, rendezok, foszereplok, Integer.parseInt(ev), Integer.parseInt(hossz), adathordozotipus, blob, eredeti, Integer.parseInt(hanyszor), visszahozva);
            }catch(Exception e){
                throw new Exception("Rossz az el�r�si �t!");
            }
        }else{
            throw new Exception("Helyesen t�ltse ki az adatokat!");
        }
    }
}
