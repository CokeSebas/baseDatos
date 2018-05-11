/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BDConexion;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AstroKiller
 */
public class Conexion {

    static final String dataBase = "XE";
    static final String user = "administrador";
    static final String pass = "admin1234";
    static final String url = "jdbc:oracle:thin:@localhost:1521:" + dataBase;
    static final String driverOracle = "oracle.jdbc.driver.OracleDriver";
    static java.sql.Connection conect = null;
    static java.sql.Statement stat = null;
    static java.sql.CallableStatement call = null;
    public static java.sql.ResultSet result = null;
    

    public static java.sql.Connection conectar() throws Exception {
        try {
            Class.forName(driverOracle).newInstance();

            conect = java.sql.DriverManager.getConnection(url, user, pass);

        } catch (java.sql.SQLException | ClassNotFoundException ex) {
            System.out.println(ex);
        }
        return conect;
    }

    public static java.sql.ResultSet exeQuery(String sql) throws java.sql.SQLException {
        try {
            stat = conectar().createStatement();
            result = stat.executeQuery(sql);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return result;
    }

    public static void query(String sql) throws java.sql.SQLException {
        try {
            stat = conectar().prepareStatement(sql);
            
            stat.execute(sql);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static void desconectar() throws Exception {
        stat.close();
        conect.close();

    }
}