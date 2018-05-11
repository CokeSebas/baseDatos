/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Querys;

//import Interfaz.Principal;
import java.sql.SQLException;

/**
 *
 * @author AstroKiller
 */
public class SeleccionarCliente {

    public SeleccionarCliente(String txtCodigo, String txtRut) {
        serializar(txtCodigo, txtRut);
    }

    public void serializar(String txtCodigo, String txtRut) {


        if (!txtCodigo.equals("") && !txtRut.equals("")) {
            param.add("CODIGO_CLIENTE");
            param.add("RUT_CLIENTE");
            values.add(txtCodigo);
            values.add(txtRut.toUpperCase());
        } else if (!txtCodigo.equals("")) {
            param.add("CODIGO_CLIENTE");
            values.add(txtCodigo);
        } else if (!txtRut.equals("")) {
            param.add("RUT_CLIENTE");
            values.add("'" +txtRut.toUpperCase() + "'");
        }
        columns.add("CODIGO_CLIENTE");
        columns.add("RUT_CLIENTE");
        columns.add("DIGITO_VERIFICADOR");
        columns.add("PRIMER_NOMBRE ||' '|| SEGUNDO_NOMBRE ||' '|| APELL_PATERNO ||' '|| APELL_MATERNO as NOMBRE");
        columns.add("DIR_NOMBRE_CALLE ||' '|| DIR_NUMERO ||' '|| POBLACION ||' '|| COMUNA_ID as DIRECCION");
        columns.add("CORREO_ELECTRONICO");
//        columns.add("FECHA_INGRESO");
        columns.add("TELE_CELULAR");

        columns2.add("PRIMER_NOMBRE ||' '|| SEGUNDO_NOMBRE ||' '|| APELL_PATERNO ||' '|| APELL_MATERNO as NOMBRE");
        columns2.add("DIR_NOMBRE_CALLE ||' '|| DIR_NUMERO ||' '|| POBLACION as DIRECCION");
        columns2.add("PROVINCIA_NOMBRE");
        columns2.add("CORREO_ELECTRONICO");
        columns2.add("RUT_CLIENTE ||'-'|| DIGITO_VERIFICADOR");
        columns2.add("TELE_CELULAR ||' | '|| TELEFONO_FIJO");
        columns2.add("COMUNA_NOMBRE");
        
    }

    public String[] clientePanel() {
        System.out.println("tamaño del registro :  "+columns.size());
        try {
            query.buscarSQL(6, param, values, values, columns, "CLIENTE", null);
            if (query.result.isBeforeFirst()) {
                registro = new String[columns.size()];
                while (query.result.next()) {
                    for (int index = 0; index < columns.size(); index++) {
                        registro[index] = query.result.getString(index+1);//esto trae todo
                        System.out.print("|||"+query.result.getString(index+1));//esto no
                    }

                }
            }else{
                //Principal.setMessage(2, "No se ha encontrado ningun dato");
            }
        } catch (SQLException ex) {
        }
        return registro;
    }
    
    public String[] clienteBoleta() {
        registro = new String[columns2.size()];
        try {
            query.buscarSQL(7, param, values, values, columns2, "CLIENTE JOIN COMUNA USING(COMUNA_ID) JOIN PROVINCIA ", "PROVINCIA_ID");
            System.out.println(query.result.isBeforeFirst());
            if (query.result.isBeforeFirst()) {
                while (query.result.next()) {
                    for (int index = 0; index < columns.size(); index++) {
                        registro[index] = query.result.getString(index+1);
                    }

                }
            }
        } catch (SQLException ex) {
        }
        return registro;
    }
    
    private Querys.Buscar query = new Querys.Buscar();
    java.util.ArrayList<String> param = new java.util.ArrayList();
    java.util.ArrayList<String> values = new java.util.ArrayList();
    java.util.ArrayList<String> columns = new java.util.ArrayList();
    java.util.ArrayList<String> columns2 = new java.util.ArrayList();
    String[] registro = null;
}
