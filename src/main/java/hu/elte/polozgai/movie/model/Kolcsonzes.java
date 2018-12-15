package hu.elte.polozgai.movie.model;

import hu.elte.polozgai.movie.db.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author polozgai
 */
public class Kolcsonzes {
    
    private int id;
    private int baratId;
    private int filmId;
    private Date lejarat;
    private Date mikor;

    private Kolcsonzes(int id, int baratId, int filmId, Date lejarat, Date mikor) {
        this.id=id;
        this.baratId = baratId;
        this.filmId = filmId;
        this.lejarat = lejarat;
        this.mikor = mikor;
    }
    
    /**
     * K�lcs�nz�s l�trehoz�sa.
     * @param id {@link Integer}
     * @param baratId {@link Integer}
     * @param filmId {@link Integer}
     * @param lejarat {@link Date}
     * @param mikor {@link Date}
     * @return {@link Kolcsonzes}
     */
    public static Kolcsonzes create(int id, int baratId, int filmId, Date lejarat, Date mikor){
        return new Kolcsonzes(id, baratId, filmId, lejarat, mikor);
    }
    
    /**
     * K�lcs�nz�sek lek�r�se.
     * @return {@link List}
     */
    public static List<Kolcsonzes> init(){
        List<Kolcsonzes> kolcsonzes=new ArrayList<Kolcsonzes>();
        String cmd="select * from kolcsonzes";
        try(Connection conn = ConnectionFactory.getConnection();PreparedStatement stmt = conn.prepareStatement(cmd)){
            ResultSet rs=stmt.executeQuery(cmd);
            while(rs.next()){
                int id=rs.getInt("id");
                int baratId=rs.getInt("baratId");
                int filmId=rs.getInt("filmId");
                Date lejarat=rs.getDate("lejarat");
                Date mikor=rs.getDate("mikor");
                kolcsonzes.add(Kolcsonzes.create(id,baratId,filmId,lejarat,mikor));
            }
        }catch(Exception  ex){
            
        }
        return kolcsonzes;
    }
    
    /**
     * �j k�lcs�nz�s l�trehoz�sa.
     * @param kolcsonzes {@link Kolcsonzes}
     */
    public void addNewKolcsonzes(Kolcsonzes kolcsonzes){
        String cmd="insert into kolcsonzes(id,filmId,baratId,lejarat,mikor) values (?,?,?,?,?)";
            try(Connection conn = ConnectionFactory.getConnection();PreparedStatement stmt = conn.prepareStatement(cmd)){
                stmt.setInt(1,id);
                stmt.setInt(2, filmId);
                stmt.setInt(3, baratId);
                stmt.setDate(4, new java.sql.Date(mikor.getTime()));
                stmt.setDate(5,new java.sql.Date(lejarat.getTime()));
                stmt.executeUpdate();
        }catch(Exception  ex){
            
        }
    }
        
    /**
     * K�lcs�nz�s t�rl�se id alapj�n.
     * @param id {@link Integer}
     */
    public void deleteKolcsonzes(int id){
        String cmd="delete from kolcsonzes where filmId=?";
            try(Connection conn=ConnectionFactory.getConnection();PreparedStatement stmt=conn.prepareStatement(cmd)){
                stmt.setInt(1, id);
                stmt.executeUpdate();
        }catch(Exception  ex){
            
        }
    }
    
    /**
     * Visszaadja az bar�t id-t.
     * @return {@link Integer}
     */
    public int getBaratId() {
        return baratId;
    }

    /**
     *Visszaadja a film id-t.
     * @return {@link Integer}
     */
    public int getFilmId() {
        return filmId;
    }

    /**
     * Visszaadja a lej�rat d�tum�t.
     * @return {@link Date}
     */
    public Date getLejarat() {
        return lejarat;
    }

    /**
     * Visszaadja a kik�lcs�nz�s d�tum�t.
     * @return {@link Date}
     */
    public Date getMikor() {
        return mikor;
    }
    
    /**
     * Visszaadja a k�lcs�nz�s id-t.
     * @return {@link Integer}
     */
    public int getId(){
        return id;
    }
}