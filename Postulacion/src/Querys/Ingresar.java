/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Querys;

/**
 *
 * @author AstroKiller
 */
public class Ingresar {

    String error;
    String[] param;
    String[] values;
    String[] columns;
    String[] inserts;
    private final String[] sqlSP = {"INSERT INTO PRODUCTO VALUES (" + recordVal() + ")",
        "INSERT INTO PRODUCTO VALUES (" + recordVal() + ") WHERE " + recordWH(),
        "INSERT INTO PRODUCTO (" + recordC() + ") VALUES (" + recordVal() + ")",
        "INSERT INTO PRODUCTO (" + recordC() + ") VALUES (" + recordVal() + ") WHERE " + recordWH()};

    public void ingrearProducto(int type, String[] param, String[] values, String[] columns, String[] inserts) {
        this.param = param;
        this.values = values;
        this.columns = columns;
        this.inserts = inserts;
        try {
            BDConexion.Conexion.query(sqlSP[type]);
        } catch (java.sql.SQLException ex) {
            error = ex.toString();
        }
    }

    public String recordVal() {
        String sentence = "";
        for (int index = 0; index < inserts.length; index++) {
            if (index == inserts.length - 1) {
                sentence += inserts[index];
            } else {
                sentence += inserts[index] + ", ";
            }
        }
        return sentence;
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

    public String recordC() {
        String sentence = "";
        for (int index = 0; index < columns.length; index++) {
            if (index == columns.length - 1) {
                sentence += columns[index];
            } else {
                sentence += columns[index] + ", ";
            }
        }
        return sentence;
    }
}
