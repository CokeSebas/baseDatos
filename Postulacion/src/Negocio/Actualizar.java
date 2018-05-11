/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import BDConexion.Conexion;
//import Interfaz.Principal;
import java.sql.SQLException;

/**
 *
 * @author pc
 */
public class Actualizar {
    static Conexion conec;
    
    
    public static void actualizarProveedor(String codigo, String nomb_emp, String rut_emp, String dig_ver, String tel_fijo, String tel_cel, String correo, String dir_nomb, String dir_num) throws SQLException{
        try{
            conec.query("UPDATE PROVEEDOR SET NOMB_EMPRESA ='"+nomb_emp+"',RUT_EMPRESA = '"+rut_emp+"', "
                    + "DIG_VERIFICADOR_EMP = '"+dig_ver+"', TELEFONO_FIJO = '"+tel_fijo+"', TELEFONO_CELULAR = '"+tel_cel+"', "
                    + "CORREO_ELECTRONICO = '"+correo+"', DIR_NOMB_CALLE = '"+dir_nomb+"', DIR_NUMERO = '"+dir_num+"' WHERE CODIGO_PROVEEDOR = " + codigo);
            
                
                
            }catch(SQLException ex){
        //Principal.setMessage(1, ex.getMessage());
        }
    }
    
    public static void actualizarProducto(String codigo, String nomb_prod, String desc, int precio_cost, int precio_ven, int precio1, int precio2, int cant_stock, int cant_min, String nomb_emp)throws SQLException{
        try{
            conec.query("UPDATE PRODUCTO SET NOMBRE_PRODUCTO = '"+nomb_prod+"',DESCRIPCION_PRODUCTO = '"+desc+"',"
                    + "PRECIO_COSTO = '"+precio_cost+"', PRECIO_VENTA = '"+precio_ven+"', PRECIO1 = '"+precio1+"', "
                    + "PRECIO2 = '"+precio2+"',CANT_EN_STOCK = '"+cant_stock+"',CANTIDAD_MINIMA = '"+cant_min+"' WHERE CODIGO_PRODUCTO = " + codigo);
            conec.query("UPDATE PROVEEDOR SET NOMBRE_EMPRESA = '"+nomb_emp+"' WHERE CODIGO_PRODUCTO = " + codigo);
        
        }catch(SQLException ex){
        //Principal.setMessage(1, ex.getMessage());
    }
  }
    
    public static void actualizarCliente(String codigo, String rut_cli, String fecha_nac, String dv, String prim_nom, String seg_nom, String apell_pat, String apell_mat, String correo, String tel_fijo, String tel_cel, String dir_nomb, int dir_num, String pobl)throws SQLException{
        try{
            
            conec.query("UPDATE CLIENTE SET RUT_CLIENTE = '"+rut_cli+"', FECHA_NACIMIENTO = TO_DATE('"+fecha_nac+"','DD/MM/YYYY'), DIGITO_VERIFICADOR = '"+dv+"', "
                    + "PRIMER_NOMBRE = '"+prim_nom+"', SEGUNDO_NOMBRE = '"+seg_nom+"', APELL_PATERNO = '"+apell_pat+"', APELL_MATERNO = '"+apell_mat+"', "
                    + "CORREO_ELECTRONICO = '"+correo+"', TELEFONO_FIJO = '"+tel_fijo+"', TELE_CELULAR = '"+tel_cel+"', DIR_NOMBRE_CALLE = '"+dir_nomb+"', "
                    + "DIR_NUMERO = '"+dir_num+"', POBLACION = '"+pobl+"' WHERE CODIGO_CLIENTE = " + codigo);
            System.out.println("UPDATE CLIENTE SET RUT_CLIENTE = '"+rut_cli+"', FECHA_NACIMIENTO =  to_date('"+fecha_nac+"','dd/mm/yyyy'), DIGITO_VERIFICADOR = '"+dv+"', "+ "PRIMER_NOMBRE = '"+prim_nom+"', SEGUNDO_NOMBRE = '"+seg_nom+"', APELL_PATERNO = '"+apell_pat+"', APELL_MATERNO = '"+apell_mat+"', "  + "CORREO_ELECTRONICO = '"+correo+"', TELEFONO_FIJO = '"+tel_fijo+"', TELE_CELULAR = '"+tel_cel+"', DIR_NOMBRE_CALLE = '"+dir_nomb+"', "   + "DIR_NUMERO = '"+dir_num+"', POBLACION = '"+pobl+"' WHERE CODIGO_CLIENTE = " + codigo);
            
        
        }catch(SQLException ex){
        //Principal.setMessage(1, ex.getMessage());    
        }
    }
    
    public static void actualizarUsuario(String codigo, String rut_ven, String dv, String fecha_nac, String prim_nom, String seg_nom, String apell_pat, String apell_mat, String fecha_ing, String correo, String tel_fijo, String tel_cel, String dir_nom, String dir_num, String pobla)throws SQLException{
        try{
            conec.query("UPDATE VENDEDOR SET RUT_VENDEDOR = '"+rut_ven+"', DIGITO_VERIFICADOR = '"+dv+"', FECHA_NACIMIENTO = TO_DATE('"+fecha_nac+"','DD/MM/YYYY'), "
            + "PRIM_NOMBRE = '"+prim_nom+"', SEG_NOMBRE = '"+seg_nom+"', APELL_PATERNO = '"+apell_pat+"', APELL_MATERNO = '"+apell_mat+"', FECHA_INGRESO = '"+fecha_ing+"', "
            + "CORREO_ELECTRONICO = '"+correo+"', TELEFONO_FIJO = '"+tel_fijo+"', TELEFONO_CELULAR = '"+tel_cel+"', DIR_NOMBRE_CALLE = '"+dir_nom+"', "
            + "DIR_NUMERO = '"+dir_num+"', POBLACION = '"+pobla+"' WHERE CODIGO_VENDEDOR = " + codigo);
        
        }catch(SQLException ex){
        //Principal.setMessage(1, ex.getMessage());
        }
    }
}
