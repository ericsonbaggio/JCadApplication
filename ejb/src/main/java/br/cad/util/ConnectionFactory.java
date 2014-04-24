package br.cad.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 
 * @author WilliamRodrigues
 * 
 */
public class ConnectionFactory {
    public Connection getConnection() {
        try {
            Properties prop = new Properties();
            prop.load(getClass().getResourceAsStream("/db.properties"));
            String dbDriver = prop.getProperty("jdbc.driver");
            String dbUrl = prop.getProperty("jdbc.url");
            String dbUser = prop.getProperty("jdbc.username");
            String dbPwd = prop.getProperty("jdbc.password");
            Class.forName(dbDriver);
            // System.out.println("URL="+dbUrl+" User"+dbUser+" pwd="+ dbPwd);
            return DriverManager.getConnection(dbUrl, dbUser, dbPwd);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
