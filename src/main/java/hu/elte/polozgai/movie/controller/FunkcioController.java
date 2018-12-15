package hu.elte.polozgai.movie.controller;

import hu.elte.polozgai.movie.model.Film;
import hu.elte.polozgai.movie.model.Kolcsonzes;
import hu.elte.polozgai.movie.view.FunkcioView;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author polozgai
 */
public class FunkcioController {
    
    private ModositasController modositasController;
    private UjKolcsonzesController ujKolcsonzesController;
    private KolcsonzesekController kolcsonzesekController;
    private List<Kolcsonzes> kolcsonzesekLista;
    private FunkcioView funkcioView;
    private Film film;
    
    /**
     * Konstruktor.
     * {@link hu.elte.progtech2.film.view.FunkcioView} példányosítása.
     * {@link ModositasController} példányosítása.
     * {@link UjKolcsonzesController} példányosítása.
     * {@link KolcsonzesekController} példányosítása.
     * {@link java.util.List} példányosítása a Funkcionak.
     * {@link hu.elte.progtech2.film.model.Film} példányosítása, kezdeti érték beállítása null-ra.
     */
    public FunkcioController(){
        funkcioView=new FunkcioView(this);
        modositasController=new ModositasController();
        ujKolcsonzesController=new UjKolcsonzesController();
        kolcsonzesekController=new KolcsonzesekController();
        kolcsonzesekLista=kolcsonzesekController.getKolcsonzesekListaToFunkcio();
        this.film=null;
    }
    
    /**
     * A változtatások mentésére szolgáló frissítést végzõ függvény.
     */
    public void update(){
        kolcsonzesekController.update();
        kolcsonzesekLista=new ArrayList<>();
        kolcsonzesekLista=kolcsonzesekController.getKolcsonzesekListaToFunkcio();
    }
    
    /**
     * Film tulajdonságainak módosításásra szolgáló függvény.
     */
    public void onModositasClick(){
        update();
        modositasController.setFilm(film);
        modositasController.show();
    }
    
    /**
     * Film visszavétele.
     * @throws Exception Ha a film nincs kölcsönadva, de úgy akarjuk vissza venni.
     */
    public void onVisszaveszClick() throws Exception{
        update();
        if(film.isVisszahozva()==true){
            for(int i=0;i<kolcsonzesekLista.size();i++){
                if(kolcsonzesekLista.get(i).getFilmId()==film.getId()){
                    kolcsonzesekLista.get(i).deleteKolcsonzes(film.getId());
                    film.updateVisszahozva(false, film.getId());
                }
            }
            kolcsonzesekController.update();
        }else{
            throw new Exception("Ez a film nincs kölcsönadva nem veheted vissza!");
        }
    }
    
    /**
     *  {@link hu.elte.progtech2.film.view.FunkcioView} megjelenítése.
     */
    public void show(){
        funkcioView=new FunkcioView(this);
        funkcioView.setVisible(true);
    }

    /**
     * Vissza adja a Filmet.
     * @return {@link hu.elte.progtech2.film.model.Film}
     */
    public Film getFilm() {
        return film;
    }

    /**
     * Beállítja a filmet.
     * @param film {@link hu.elte.progtech2.film.model.Film}
     */
    public void setFilm(Film film) {
        this.film = film;
    }

    /**
     * Film törlése.
     * @throws Exception Ha a film kölcsön van adva nem törölhetjük!
     */
    public void onTorlesClick() throws Exception{
        update();
        if(film.isVisszahozva()==false){
            film.deleteFilm(film.getId());
        }else{
            throw new Exception("Ez a film kölcsön van adva nem törölheted!");
        }
    }

    /**
     * Film kikölcsönzés.
     * {@link UjKolcsonzesController} -nek beállítja a filmet, majd {@link hu.elte.progtech2.film.view.UjKolcsonzesView} megjelenítése
     */
    public void onKolcsonzesClick() {
        ujKolcsonzesController.setFilm(film);
        ujKolcsonzesController.show();
    }
}
