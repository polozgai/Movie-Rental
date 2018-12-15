package hu.elte.polozgai.movie.model;

import hu.elte.polozgai.movie.db.ConnectionFactory;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author polozgai
 */
public class Film {

    private String adathordozoTipus;
    private Blob boritokep;
    private String cim;
    private boolean eredeti;
    private String foszereplok;
    private int hanyszor;
    private int hossz;
    private int id;
    private int ev;
    private String rendezok;
    private boolean visszahozva;

    private Film(String adathordozoTipus, Blob boritokep, String cim, boolean eredeti, String foszereplok, int hanyszor, int hossz, int ev, String rendezok, boolean visszahozva,int id) {
        this.adathordozoTipus = adathordozoTipus;
        this.boritokep = boritokep;
        this.cim = cim;
        this.eredeti = eredeti;
        this.foszereplok = foszereplok;
        this.hanyszor = hanyszor;
        this.hossz = hossz;
        this.id = id;
        this.ev = ev;
        this.rendezok = rendezok;
        this.visszahozva = visszahozva;
        
    }
    
    /**
     * Film objektum létrehozása.
     * @param adathordozoTipus {@link String}
     * @param boritokep {@link Blob}
     * @param cim {@link String}
     * @param eredeti {@link Boolean}
     * @param foszereplok {@link String}
     * @param hanyszor {@link Integer}
     * @param hossz {@link Integer}
     * @param ev {@link Integer}
     * @param rendezok {@link String}
     * @param visszahozva {@link Boolean}
     * @param id {@link Integer}
     * @return {@link Film}
     */
    public static Film create(String adathordozoTipus, Blob boritokep, String cim, boolean eredeti, String foszereplok, int hanyszor, int hossz, int ev, String rendezok, boolean visszahozva,int id){
        return new Film(adathordozoTipus, boritokep, cim, eredeti, foszereplok, hanyszor, hossz, ev, rendezok, visszahozva,id);
    }  

    /**
     * Visszadja az adathordozót.
     * @return {@link String}
     */
    public String getAdathordozoTipus() {
        return adathordozoTipus;
    }

    /**
     * Visszadja a képet.
     * @return {@link Blob}
     */
    public Blob getBoritokep() {
        return boritokep;
    }

    /**
     * Viasszadja a címet.
     * @return {@link String}
     */
    public String getCim() {
        return cim;
    }

    /**
     * Visszadja az eredetiséget.
     * @return {@link Boolean}
     */
    public boolean isEredeti() {
        return eredeti;
    }

    /**
     * Viasszadja a fõszereplõket.
     * @return {@link String}
     */
    public String getFoszereplok() {
        return foszereplok;
    }

    /**
     * Visszaadja, hogy hányszor adtuk kölcsön.
     * @return {@link Integer}
     */
    public int getHanyszor() {
        return hanyszor;
    }

    /**
     * Visszadja a hosszt.
     * @return {@link Integer}
     */
    public int getHossz() {
        return hossz;
    }

    /**
     * Visszadja az id-t.
     * @return {@link Integer}
     */
    public int getId() {
        return id;
    }

    /**
     * Visszaadja a megjelenést.
     * @return {@link Integer}
     */
    public int getMegjelenes() {
        return ev;
    }

    /**
     * Visszaadja a rendezõket.
     * @return {@link String}
     */
    public String getRendezok() {
        return rendezok;
    }

    /**
     * Visszaadja, hogy kölcsön van-e adva.
     * @return {@link Boolean}
     */
    public boolean isVisszahozva() {
        return visszahozva;
    }

    /**
     * Új film hozzáadása.
     * @param id {@link Integer}
     * @param cim {@link String}
     * @param rendezok {@link String}
     * @param foszereplok {@link String}
     * @param ev {@link Integer}
     * @param hossz {@link Integer}
     * @param adath {@link String}
     * @param blob {@link Blob}
     * @param eredeti {@link Boolean}
     * @param hanyszor {@link Integer}
     * @param visszahozva {@link Boolean}
     */
    public void addFilm(int id,String cim,String rendezok,String foszereplok,int ev,int hossz,String adath,Blob blob,boolean eredeti,int hanyszor,boolean visszahozva){
        String cmd="insert into database.film(id,cim,rendezok,foszereplok,ev,hossz,adathordozotipus,boritokep,eredeti,hanyszor,visszahozva) values (?,?,?,?,?,?,?,?,?,?,?)";
        try(Connection conn = ConnectionFactory.getConnection();PreparedStatement stmt = conn.prepareStatement(cmd)){
            stmt.setInt(1, id);
            stmt.setString(2, cim);
            stmt.setString(3, rendezok);
            stmt.setString(4, foszereplok);
            stmt.setInt(5,ev);
            stmt.setInt(6, hossz);
            stmt.setString(7, adath);
            stmt.setBlob(8, blob);
            stmt.setBoolean(9, eredeti);
            stmt.setInt(10, hanyszor);
            stmt.setBoolean(11, visszahozva);
            stmt.executeUpdate();
        }catch(Exception  ex){
            
        }
    }
    
    /**
     * Film módosítása.
     * @param id {@link Integer}
     * @param cim {@link String}
     * @param rendezok {@link String}
     * @param foszereplok {@link String}
     * @param ev {@link Integer}
     * @param hossz {@link Integer}
     * @param adathordozotipus
     * @param boritokep {@link Blob}
     * @param eredeti {@link Boolean}
     * @param hanyszor {@link Integer}
     * @param visszahozva {@link Boolean}
     */
    public void editFilm(int id,String cim,String rendezok,String foszereplok,int ev,int hossz,String adathordozotipus,Blob boritokep,boolean eredeti,int hanyszor,boolean visszahozva){
        String cmd="update film set cim=?, rendezok=?, foszereplok=?, ev=?, hossz=?, adathordozotipus=?, boritokep=?, eredeti=?, hanyszor=?, visszahozva=? where id=?";
        try(Connection conn = ConnectionFactory.getConnection();PreparedStatement stmt = conn.prepareStatement(cmd)){
            stmt.setString(1, cim);
            stmt.setString(2,rendezok);
            stmt.setString(3, foszereplok);
            stmt.setInt(4,ev);
            stmt.setInt(5,hossz);
            stmt.setString(6,adathordozotipus);
            stmt.setBlob(7,boritokep);
            stmt.setBoolean(8, eredeti);
            stmt.setInt(9,hanyszor);
            stmt.setBoolean(10, visszahozva);
            stmt.setInt(11, id);
            stmt.executeUpdate();
        }catch(Exception  ex){
            
        }
    }
    
    /**
     * Film törlése, ha nincs benne a kölcsönzésekben.
     * @param id {@link Integer}
     */
    public void deleteFilm(int id){
        String cmd="select id from film where id not in (select filmId from kolcsonzes);";
        try(Connection conn = ConnectionFactory.getConnection();PreparedStatement stmt = conn.prepareStatement(cmd)){
            ResultSet rs=stmt.executeQuery(cmd);
            while(rs.next()){
                if(id==rs.getInt("id")){
                    deleteFilmById(id);
                }
            }
        }catch(Exception  ex){
            
        }
    }
    
    /**
     * Film törlése.
     * @param id {@link Integer}
     */
    public void deleteFilmById(int id) {
        String cmd="delete from film where id=?";
        try(Connection conn = ConnectionFactory.getConnection();PreparedStatement stmt = conn.prepareStatement(cmd)){
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }catch(Exception  ex){
            
        }
    }
    
    /**
     * Az összes filmet adja vissza az adatbázisból.
     * @return {@link List}
     */
    public static List<Film> init(){
        List<Film> film=new ArrayList<Film>();
        String cmd = "select * from film;";
        try (Connection conn = ConnectionFactory.getConnection();PreparedStatement stmt = conn.prepareStatement(cmd)) {
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                int id=rs.getInt("id");
                String cim=rs.getString("cim");
                String rendezok=rs.getString("rendezok");
                String foszereplok=rs.getString("foszereplok");
                int ev=rs.getInt("ev");
                int hossz=rs.getInt("hossz");
                String adathordozoTipus=rs.getString("adathordozotipus");
                Blob blob = rs.getBlob("boritokep");
                boolean eredeti=rs.getBoolean("eredeti");
                int hanyszor=rs.getInt("hanyszor");
                boolean visszahozva=rs.getBoolean("visszahozva");
                film.add(Film.create(adathordozoTipus, blob, cim, eredeti, foszereplok, hanyszor, hossz, ev, rendezok, visszahozva,id));
            }
        }catch(Exception  ex){
            
        }
        return film;
    }
    
    /**
     * Film visszavételénél beállítjuk a visszahozva értéket.
     * @param vissza {@link List}
     * @param id {@link Integer}
     */
    public void updateVisszahozva(boolean vissza,int id) {
        String cmd="update film set visszahozva=? where id=?";
        try(Connection conn = ConnectionFactory.getConnection();PreparedStatement stmt = conn.prepareStatement(cmd)){
            stmt.setBoolean(1,vissza);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        }catch(Exception  ex){
            
        }
    }
    
    /**
     * Ha kölcsönadunk egy filmet beállítjuk az kölcsönzés, hányszor kölcsönadva értékeket.
     * @param hanyszor {@link Integer}
     * @param vissza {@link Integer}
     * @param id {@link Integer}
     */
    public void updateUjKolcsonzes(int hanyszor,boolean vissza,int id){
        String cmd="update film set hanyszor=?, visszahozva=? where id=?";
        try(Connection conn = ConnectionFactory.getConnection();PreparedStatement stmt = conn.prepareStatement(cmd)){
            stmt.setInt(1, hanyszor);
            stmt.setBoolean(2,vissza);
            stmt.setInt(3, id);
            stmt.executeUpdate();
        }catch(Exception  ex){
            
        }    
    }

    /**
     * Kölcsönzésbõl törlünk.
     * @param id {@link Integer}
     */
    public void deleteKolcsonzes(int id) {
        String cmd="delete from kolcsonzes where filmId= ?";    
        try(Connection conn = ConnectionFactory.getConnection();PreparedStatement stmt = conn.prepareStatement(cmd)){
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }catch(Exception  ex){
            
        }
    }
}