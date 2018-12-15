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
     * {@link hu.elte.progtech2.film.view.FunkcioView} p�ld�nyos�t�sa.
     * {@link ModositasController} p�ld�nyos�t�sa.
     * {@link UjKolcsonzesController} p�ld�nyos�t�sa.
     * {@link KolcsonzesekController} p�ld�nyos�t�sa.
     * {@link java.util.List} p�ld�nyos�t�sa a Funkcionak.
     * {@link hu.elte.progtech2.film.model.Film} p�ld�nyos�t�sa, kezdeti �rt�k be�ll�t�sa null-ra.
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
     * A v�ltoztat�sok ment�s�re szolg�l� friss�t�st v�gz� f�ggv�ny.
     */
    public void update(){
        kolcsonzesekController.update();
        kolcsonzesekLista=new ArrayList<>();
        kolcsonzesekLista=kolcsonzesekController.getKolcsonzesekListaToFunkcio();
    }
    
    /**
     * Film tulajdons�gainak m�dos�t�s�sra szolg�l� f�ggv�ny.
     */
    public void onModositasClick(){
        update();
        modositasController.setFilm(film);
        modositasController.show();
    }
    
    /**
     * Film visszav�tele.
     * @throws Exception Ha a film nincs k�lcs�nadva, de �gy akarjuk vissza venni.
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
            throw new Exception("Ez a film nincs k�lcs�nadva nem veheted vissza!");
        }
    }
    
    /**
     *  {@link hu.elte.progtech2.film.view.FunkcioView} megjelen�t�se.
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
     * Be�ll�tja a filmet.
     * @param film {@link hu.elte.progtech2.film.model.Film}
     */
    public void setFilm(Film film) {
        this.film = film;
    }

    /**
     * Film t�rl�se.
     * @throws Exception Ha a film k�lcs�n van adva nem t�r�lhetj�k!
     */
    public void onTorlesClick() throws Exception{
        update();
        if(film.isVisszahozva()==false){
            film.deleteFilm(film.getId());
        }else{
            throw new Exception("Ez a film k�lcs�n van adva nem t�r�lheted!");
        }
    }

    /**
     * Film kik�lcs�nz�s.
     * {@link UjKolcsonzesController} -nek be�ll�tja a filmet, majd {@link hu.elte.progtech2.film.view.UjKolcsonzesView} megjelen�t�se
     */
    public void onKolcsonzesClick() {
        ujKolcsonzesController.setFilm(film);
        ujKolcsonzesController.show();
    }
}
