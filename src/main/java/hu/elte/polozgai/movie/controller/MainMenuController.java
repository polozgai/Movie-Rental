package hu.elte.polozgai.movie.controller;

import hu.elte.polozgai.movie.view.MainMenuView;



/**
 *
 * @author polozgai
 */
public class MainMenuController {
    
    private MainMenuView MainMenuView;
    private NyilvantartasController nyilvantartasController;
    private UjFilmController ujFilmController;
    private KolcsonzesekController kolcsonzesekController;
    
    /**
     * Konstruktor.
     * {@link hu.elte.progtech2.film.view.MainMenuView} p�ld�nyos�t�sa.
     * {@link hu.elte.progtech2.film.controller.NyilvantartasController} p�ld�nyos�t�sa.
     * {@link hu.elte.progtech2.film.controller.UjFilmController} p�ld�nyos�t�sa.
     * {@link hu.elte.progtech2.film.controller.KolcsonzesekController} p�ld�nyos�t�sa.
     */
    public MainMenuController(){
        MainMenuView=new MainMenuView(this);
        nyilvantartasController=new NyilvantartasController();
        ujFilmController=new UjFilmController();
        kolcsonzesekController=new KolcsonzesekController();
    }
    
    /**
     * 
     * @param args
     */
    public static void main(String[] args){
        MainMenuController m=new MainMenuController();
        m.show();
    }
    
    /**
     *
     */
    public void onNyilvantartasClick(){
        nyilvantartasController.update();
        nyilvantartasController.show();
    }
    
    /**
     *
     */
    public void onKolcsonzesekClick(){
        kolcsonzesekController.update();
        kolcsonzesekController.show();
    }
    
    /**
     *
     */
    public void onUjFilmClick(){
        nyilvantartasController.update();
        ujFilmController.show();
    }

    /**
     *
     */
    public void onPanikClick(){
        nyilvantartasController.update();
        nyilvantartasController.panik();
    }
    
    /**
     *
     */
    public void show(){
        MainMenuView.setVisible(true);
    }
}
