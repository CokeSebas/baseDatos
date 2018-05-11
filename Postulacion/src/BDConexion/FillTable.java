/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BDConexion;

import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AstroKiller
 */
public class FillTable {
    /**
     * Fill a JTable by querying a DataBase using class Conexion. 
     * @param titles this array contain the names of the JTable columns.
     * @param reg this array contain the length of the JTable (number of columns).
     * @param column this array contains the names of DataBase columns that will be called.
     * @param query this String is the query Select with you will get the data.
     * 
     * @return dtm is a DefaultTableModel to be used in our JTable.
     */
    public static DefaultTableModel fill(String[] titles, String[] reg, String[] column, String query) throws SQLException {
        DefaultTableModel dtm = new DefaultTableModel(null, titles);
        Conexion.exeQuery(query);
        while (Conexion.result.next()) {
            for (int large = 0; large < reg.length; large++) {
                reg[large] = Conexion.result.getString(column[large]);
            }
            dtm.addRow(reg);
        }
        return dtm;
    }
}
