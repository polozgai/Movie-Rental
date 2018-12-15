package hu.elte.polozgai.movie.db;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author polozgai
 */
public class ConnectionFactory {
    private static MysqlConnectionPoolDataSource conn;
    
    private ConnectionFactory(){}
    
    /**
     * Adatbázis felállítása.
     * @return {@link java.sql.Connection}
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static Connection getConnection() 
        throws ClassNotFoundException, SQLException{
        if (conn == null){
            Class.forName("com.mysql.jdbc.Driver"); // Driver betöltése
            conn = new MysqlConnectionPoolDataSource();
            conn.setServerName("localhost");
            conn.setPort(3306);
            conn.setDatabaseName("database");
            conn.setUser("root");
            conn.setPassword("root");
        }
        return conn.getPooledConnection().getConnection();
    }
}
