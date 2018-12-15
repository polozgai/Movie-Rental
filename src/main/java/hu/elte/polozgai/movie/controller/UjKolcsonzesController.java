package hu.elte.polozgai.movie.controller;


import hu.elte.polozgai.movie.model.Barat;
import hu.elte.polozgai.movie.model.Film;
import hu.elte.polozgai.movie.model.Kolcsonzes;
import hu.elte.polozgai.movie.view.UjKolcsonzesView;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author polozgai
 */
public class UjKolcsonzesController {
    
    private UjKolcsonzesView ujKolcsonzesView;
    private Film film;
    private List<Barat> baratLista;
    
    /**
     * Konstruktor.
     * {@link UjKolcsonzesView} p�ld�nyos�t�sa.
     * {@link Film} p�ld�nyos�t�sa.
     * {@link java.util.List} p�ld�nyos�t�sa.
     */
    public UjKolcsonzesController(){
        ujKolcsonzesView=new UjKolcsonzesView(this);
        this.film=null;
        baratLista=Barat.init();
    }
    
    /**
     * {@link UjKolcsonzesView} megjelen�t�se.
     */
    public void show(){
        ujKolcsonzesView.setVisible(true);
    }

    /**
     * Film be�ll�t�sa.
     * @param film {@link Film}
     */
    public void setFilm(Film film) {
        this.film = film;
        ujKolcsonzesView.setCim(film.getCim());
    }

    /**
     * Visszaadja a filmet.
     * @return {@link Film}.
     */
    public Film getFilm() {
        return film;
    }

    /**
     * �j k�lcs�nz�s l�trehoz�sa
     * @param kinek {@link String}
     * @param mikor {@link String}
     * @param lejarat {@link String}
     * @throws Exception Ha nem megfelel�en adtuk meg az adatokat.
     */
    public void ujKolcsonzes(String kinek,String mikor,String lejarat) throws Exception{
        if(!kinek.matches("[a-zA-Z]+") || !mikor.matches("[1-2][0|9][0-9][0-9][-][0-1][0-9][-][0-3][0-9]") || !lejarat.matches("[1-2][0|9][0-9][0-9][-][0-1][0-9][-][0-3][0-9]")){
           throw new Exception();
        }
        int id=kinekUpdate(kinek);
        Random r=new Random();
        Date m=null;
        Date l=null;
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        try {
            m=format.parse(mikor);
            l=format.parse(lejarat);
        } catch (ParseException ex) {
            Logger.getLogger(UjKolcsonzesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Kolcsonzes k=Kolcsonzes.create(r.nextInt(100)+20, id, film.getId(), m, l);
        k.addNewKolcsonzes(k);
        int hany=film.getHanyszor();
        hany++;
        film.updateUjKolcsonzes(hany, true, film.getId());
    }
    
    /**
     * Megkeresi, hogy kinek adjuk k�lcs�n a filmet, ha nincs bent a bar�tok k�z�tt csin�l egy �j bar�tot.
     * @param kinek {@link String}
     * @return {@link Integer}
     */
    public int kinekUpdate(String kinek){
        int id=-1;
        Random r=new Random();
        boolean ok=true;
        for(int i=0;i<baratLista.size();i++){
            if(baratLista.get(i).getNev().equals(kinek)){
                id=baratLista.get(i).getId();
                ok=false;
            }
        }
        if(ok){
            id=r.nextInt(100)+20;
            Barat b=Barat.create(id, kinek);
            b.addUjBarat(id, kinek);
        }
        return id;
    }
}