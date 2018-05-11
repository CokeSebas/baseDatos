/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Querys;

/**
 *
 * @author AstroKiller
 */
public class Buscar {

    java.util.ArrayList params = new java.util.ArrayList();
    java.util.ArrayList valuesStart = new java.util.ArrayList();
    java.util.ArrayList valuesEnd = new java.util.ArrayList();
    java.util.ArrayList columns = new java.util.ArrayList();
    BDConexion.Conexion conection;
    String table = new String();
    String using = new String();
    public java.sql.ResultSet result = null;

    public void buscarSQL(int type, java.util.ArrayList param,
            java.util.ArrayList valuesStart, java.util.ArrayList valuesEnd, java.util.ArrayList columns, String table, String using) {
        this.params = param;
        this.valuesStart = valuesStart;
        this.valuesEnd = valuesEnd;
        this.columns = columns;
        this.table = table;
        this.using = using;

        //System.out.println("params introducido "+this.params);
        try {
            result = conection.exeQuery(queryType()[type]);
        } catch (java.sql.SQLException ex) {
            //Interfaz.Principal.setMessage(1, ex.getMessage() + " - " + ex.getErrorCode());
        }
        System.out.println(queryType()[type]);
    }
    /*
     * utiliza los valores de variables locales insertadas por parametro en el metodo buscarSQL 
     * para generar el sector condicional de una consulta sql
     */
    private String whereSentence() {
        String sentence = "";
        if(params != null){
        for (int index = 0; index < params.size(); index++) {
            if (valuesStart.get(index) == valuesEnd.get(index)) {
                if (params.size() > index + 1) {
                    sentence += params.get(index) + " like " + valuesStart.get(index) + " and ";
                }else{
                sentence += params.get(index) + " like " + valuesStart.get(index);
                }
            } else {
                if (params.size() > index + 1) {
                    sentence += params.get(index) + " BETWEEN " + valuesStart.get(index) + " and " + valuesEnd.get(index)
                            + " and ";
                }else{
                sentence += params.get(index) + " BETWEEN " + valuesStart.get(index) + " and " + valuesEnd.get(index);
                }
            }
        }
        }
        return sentence;
    }
    
    /**
     * This method concat the global variable 'columns' if 'columns' have 
     * more than 1 value this put a ', ' between of the 2 values.
     * @return the String concatenate ready to be used.
     */
    private String columnsNames() {
        String sentence = "";
        for (int index = 0; index < columns.size(); index++) {
            if (index + 1 == columns.size()) {
                sentence += columns.get(index);
            } else {
                sentence += columns.get(index) + ", ";
            }
        }
        return sentence;
    }
    
    /**
     * This method select a structure of SQL to do a database query
     * this generate an Array start in 0 to 7.
     *  0 Select all from a specific table.
     *  1 Select all from a join of 2 tables.
     *  2 Select all from a specific table using where.
     *  3 Select all from a join of 2 tables using where.
     *  4 Select specifics columns from a specific table.
     *  5 Select specifics columns from a join of 2 tables.
     *  6 Select specifics columns from a specific table using where.
     *  7 Select specifics columns from a join of 2 tables using where.
     * @return the complete sentence ready to be used.
     */
    private String[] queryType() {
        String[] sql = {
            "SELECT * FROM " + table,
            "SELECT * FROM " + table + " USING (" + using + ")",
            "SELECT * FROM " + table + " WHERE " + whereSentence(),
            "SELECT * FROM " + table + " USING (" + using + ") WHERE " + whereSentence(),
            "SELECT " + columnsNames() + " FROM " + table,
            "SELECT " + columnsNames() + " FROM " + table + " USING (" + using + ")",
            "SELECT " + columnsNames() + " FROM " + table + " WHERE " + whereSentence(),
            "SELECT " + columnsNames() + " FROM " + table + " USING (" + using + ") WHERE " + whereSentence()
        };
        return sql;
    }

    public void disconect() {
        try {
            conection.desconectar();
        } catch (Exception ex) {
            //Interfaz.Principal.setMessage(1, ex.getMessage());
        }
    }
}
