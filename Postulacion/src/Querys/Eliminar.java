/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Querys;

/**
 *
 * @author AstroKiller
 */
public class Eliminar {

    String error;
    String[] param;
    String[] values;
    private final String[] sqlSP = {"DELETE FROM PROUCTO",
        "DELETE FROM PROUCTO WHERE " + recordWH()};

    public void ingrearProducto(int type, String[] param, String[] values) {
        this.param = param;
        this.values = values;
        try {
            BDConexion.Conexion.query(sqlSP[type]);
        } catch (java.sql.SQLException ex) {
            error = ex.toString();
        }
    }

    public String recordWH() {
        String sentence = "";
        for (int index = 0; index < param.length; index++) {
            if (index == param.length - 1) {
                sentence += param[index] + " = " + values[index];
            } else {
                sentence += param[index] + " = " + values[index] + "and ";
            }
        }
        return sentence;
    }
}
