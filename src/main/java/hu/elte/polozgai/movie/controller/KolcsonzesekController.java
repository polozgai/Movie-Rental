package hu.elte.polozgai.movie.controller;


import hu.elte.polozgai.movie.model.Barat;
import hu.elte.polozgai.movie.model.Film;
import hu.elte.polozgai.movie.model.Kolcsonzes;
import hu.elte.polozgai.movie.view.KolcsonzesekView;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author polozgai
 */
public class KolcsonzesekController {
    
    private List<Barat> baratLista;
    private List<Kolcsonzes> kolcsonzesekLista;
    private List<Film> filmLista;
    private List<String> kolcsonzesListaToView;
    private List<String> keresesLista;
    private KolcsonzesekView kolcsonzesekView;
    
    /**
     * Konstruktor.
     * {@link java.util.List} p�ld�nyos�t�sa a {@link hu.elte.progtech2.film.model.Barat} objektumnak.
     * {@link java.util.List} p�ld�nyos�t�sa a {@link hu.elte.progtech2.film.model.Kolcsonzes} objektumnak.
     * {@link java.util.List} p�ld�nyos�t�sa a {@link hu.elte.progtech2.film.model.Film} objektumnak.
     * {@link java.util.List} p�ld�nyos�t�sa a {@link hu.elte.progtech2.film.view.KolcsonzesekView} objektumnak.
     * {@link java.util.List} p�ld�nyos�t�sa a keres�seknek.
     * {@link hu.elte.progtech2.film.view.KolcsonzesekView} p�ld�nyos�t�sa.
     */
    public KolcsonzesekController(){
        baratLista=Barat.init();
        kolcsonzesekLista=Kolcsonzes.init();
        filmLista=Film.init();
        keresesLista=new ArrayList<String>();
        kolcsonzesListaToView=new ArrayList<String>();
        kolcsonzesekView=new KolcsonzesekView(this);
    }

    /**
     * Vissza adja a k�lcs�nz�sek list�j�t, amit a {@link hu.elte.progtech2.film.view.KolcsonzesekView} fog haszn�lni.
     * @return {@link java.util.List}
     */
    public List<String> getKolcsonzesekLista() {
        return kolcsonzesListaToView;
    }
    
    /**
     * Vissza adja a keres�sek list�j�t
     * @return {@link java.util.List}
     */
    public List<String> getKeresesLista(){
        return keresesLista;
    }
    
    /**
     * Vissza adja a {@link hu.elte.progtech2.film.model.Kolcsonzes} list�j�t
     * @return {@link java.util.List}
     */
    public List<Kolcsonzes> getKolcsonzesekListaToFunkcio(){
        return kolcsonzesekLista;
    }

    /**
     * Friss�t�s.
     */
    public void update(){
        baratLista=new ArrayList<>();
        baratLista=Barat.init();
        filmLista=new ArrayList<>();
        filmLista=Film.init();
        kolcsonzesekLista=new ArrayList<>();
        kolcsonzesekLista=Kolcsonzes.init();
        kolcsonzesListaToView=new ArrayList<>();
        getKolcsonzesekToView();        
    }
    
    /**
     * {@link hu.elte.progtech2.film.view.KolcsonzesekView} p�ld�nyos�t�sa, megjel�n�te
     */
    public void show(){
        kolcsonzesekView=new KolcsonzesekView(this);
        kolcsonzesekView.setVisible(true);
    }
    
    private void getKolcsonzesekToView(){
        String filmCim = "";
        String filmFoszereplo = "";
        String baratNev = "";
        String mikor;
        String lejarat;
        for(int i=0;i<kolcsonzesekLista.size();i++){
            for(int j=0;j<filmLista.size();j++){
                if(kolcsonzesekLista.get(i).getFilmId()==filmLista.get(j).getId()){
                    filmCim=filmLista.get(j).getCim();
                    filmFoszereplo=filmLista.get(j).getFoszereplok();
                }
            }
            for(int k=0;k<baratLista.size();k++){
                if(kolcsonzesekLista.get(i).getBaratId()==baratLista.get(k).getId()){
                    baratNev=baratLista.get(k).getNev();
                }
            }
            mikor=kolcsonzesekLista.get(i).getMikor().toString();
            lejarat=kolcsonzesekLista.get(i).getLejarat().toString();
            kolcsonzesListaToView.add(filmCim+"_"+filmFoszereplo+"_"+baratNev+"_"+mikor+"_"+lejarat);
        }
    }
    
    /**
     * A keresett String -re ad eredm�nyt
     * @param nev {@link java.lang.String}
     */
    public void keresesNev(String nev){
        keresesLista.clear();
        for(int i=0;i<kolcsonzesListaToView.size();i++){
            String[] tomb=kolcsonzesListaToView.get(i).split("_");
            if(tomb[2].equals(nev)){
                keresesLista.add(kolcsonzesListaToView.get(i));
            }
        }
    }
}
