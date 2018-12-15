package hu.elte.polozgai.movie.model;

import hu.elte.polozgai.movie.db.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author polozgai
 */
public class Barat {
    private int id;
    private String nev;

    private Barat(int id, String nev) {
        this.id = id;
        this.nev = nev;
    }
    
    /**
     * {@link Barat} objektom létrehozása.
     * @param id {@link Integer}
     * @param nev {@link String}
     * @return {@link Barat}
     */
    public static Barat create(int id,String nev){
        return new Barat(id,nev);
    }
    
    /**
     * Az összes film lekérdezáse az adatbázisból.
     * @return {@link java.util.List}
     */
    public static List<Barat> init(){
        List<Barat> baratLista=new ArrayList<Barat>();
        String cmd="select * from barat";
        try(Connection conn = ConnectionFactory.getConnection();PreparedStatement stmt=conn.prepareStatement(cmd)){
            ResultSet rs=stmt.executeQuery(cmd);
            while(rs.next()){
                int id=rs.getInt("id");
                String nev=rs.getString("nev");
                baratLista.add(Barat.create(id, nev));
            }
        }catch(Exception  ex){
            
        }
        return baratLista;
    }
    
    /**
     * Új barát létrehozása
     * @param id {@link Integer}
     * @param nev {@link String}
     */
    public void addUjBarat(int id,String nev){
        String cmd="insert into barat(id,nev) values (?,?)";
        try(Connection conn = ConnectionFactory.getConnection();PreparedStatement stmt = conn.prepareStatement(cmd)){
            stmt.setInt(1, id);
            stmt.setString(2, nev);
            stmt.executeUpdate();
        }catch(Exception  ex){
            
        }
    }

    /**
     * Visszadja az id-t.
     * @return {@link Integer}
     */
    public int getId() {
        return id;
    }

    /**
     * Visszadja a nevet.
     * @return {@link String}
     */
    public String getNev() {
        return nev;
    }
}