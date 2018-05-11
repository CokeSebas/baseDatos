/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import BDConexion.Conexion;
import java.sql.*;
//import Interfaz.Paneles.*;
//import Interfaz.Principal;
import com.sun.xml.internal.bind.v2.runtime.reflect.Accessor;

/**
 *
 * @author pc
 */
public class Cliente {

    static Conexion conec;
    static String cod;

    public static void main(String[] args) {
        /*conectarProducto(ModificarProducto.txtCodigoProducto.getText());
        conectarProveedor(ModificarProveedor.txtCodigoProveedor.getText());
        conectarCliente(ModificarCliente.txtCodigoCliente.getText(), ModificarCliente.txtRUT.getText());
        conectarUsuario(ModificarUsuario.txtCodigoUsuario.getText(), ModificarUsuario.txtRUN.getText());*/
    }

    public static void conectarProducto(String codigo) {
        try {
            conec.exeQuery("SELECT * FROM PRODUCTO JOIN PROVEEDOR USING (CODIGO_PROVEEDOR) WHERE CODIGO_PRODUCTO =  " + codigo);
            while (conec.result.next()) {
                /*ModificarProducto.txtNombreProducto.setText(conec.result.getString("NOMBRE_PRODUCTO"));
                ModificarProducto.txtPrecioCosto.setText(conec.result.getString("PRECIO_COSTO"));
                ModificarProducto.txtPrecioVenta.setText(conec.result.getString(6));
                ModificarProducto.txtPrecio1.setText(conec.result.getString("PRECIO1"));
                ModificarProducto.txtPrecio2.setText(conec.result.getString("PRECIO2"));
                ModificarProducto.txtStock.setText(conec.result.getString("CANT_EN_STOCK"));
                ModificarProducto.txtCantMin.setText(conec.result.getString("CANTIDAD_MINIMA"));
                ModificarProducto.txtNombreProveedor.setText(conec.result.getString("NOMB_EMPRESA"));
                ModificarProducto.taDescripcion.setText(conec.result.getString("DESCRIPCION_PRODUCTO"));*/
            }
        } catch (SQLException ex) {
            //Principal.setMessage(1, ex.getMessage());
    }
}
    
    public static void conectarProveedor(String codigo){
        try{
            conec.exeQuery("SELECT * FROM PROVEEDOR WHERE CODIGO_PROVEEDOR = " + codigo);
            while (conec.result.next()) {
            /*ModificarProveedor.txtRUT.setText(conec.result.getString("RUT_EMPRESA"));
            ModificarProveedor.txtDV1.setText(conec.result.getString("DIG_VERIFICADOR_EMP"));
            ModificarProveedor.txtRazonSocial.setText(conec.result.getString("NOMB_EMPRESA"));
            ModificarProveedor.txtTelFijo.setText(conec.result.getString("TELEFONO_FIJO"));
            ModificarProveedor.txtTelMovil.setText(conec.result.getString("TELEFONO_CELULAR"));
            ModificarProveedor.txtEmail.setText(conec.result.getString("CORREO_ELECTRONICO"));
            ModificarProveedor.txtDireccion.setText(conec.result.getString("DIR_NOMB_CALLE"));
            ModificarProveedor.txtNumero.setText(conec.result.getString("DIR_NUMERO"));*/
            }
        }catch(SQLException ex){
            //Principal.setMessage(1, ex.getMessage());   
            System.out.println(ex.getCause());
            System.out.println(ex.getSQLState());
      }

  }
    
    public static void conectarCliente(String codigo, String cod){
            try{
                conec.exeQuery("SELECT RUT_CLIENTE, DIGITO_VERIFICADOR, PRIMER_NOMBRE, SEGUNDO_NOMBRE, APELL_PATERNO, APELL_MATERNO,FECHA_NACIMIENTO, "
                        + "TELEFONO_FIJO, TELE_CELULAR, CORREO_ELECTRONICO, DIR_NOMBRE_CALLE, DIR_NUMERO, POBLACION  FROM CLIENTE WHERE CODIGO_CLIENTE = " + codigo);
                
                while (conec.result.next()) {
                    
                    /*ModificarCliente.txtRUT.setText(conec.result.getString("RUT_CLIENTE") );
                    ModificarCliente.txtDV.setText(conec.result.getString("DIGITO_VERIFICADOR"));   
                    ModificarCliente.txtPrimerNombre.setText(conec.result.getString("PRIMER_NOMBRE"));
                    ModificarCliente.txtSegundoNombre.setText(conec.result.getString("SEGUNDO_NOMBRE"));
                    ModificarCliente.txtApePaterno.setText(conec.result.getString("APELL_PATERNO"));
                    ModificarCliente.txtApeMaterno.setText(conec.result.getString("APELL_MATERNO"));
                    ModificarCliente.txtFechaNacimiento.setText(conec.result.getString("FECHA_NACIMIENTO"));
                    ModificarCliente.txtTelefono.setText(conec.result.getString("TELEFONO_FIJO"));
                    ModificarCliente.txtTelefonoCelular.setText(conec.result.getString("TELE_CELULAR"));
                    ModificarCliente.txtEmail.setText(conec.result.getString("CORREO_ELECTRONICO"));
                    ModificarCliente.txtDireccion.setText(conec.result.getString("DIR_NOMBRE_CALLE"));
                    ModificarCliente.txtNumero.setText(conec.result.getString("DIR_NUMERO"));
                    ModificarCliente.txtPoblacion.setText(conec.result.getString("POBLACION"));*/
                }
                conec.exeQuery("SELECT CODIGO_CLIENTE, PRIMER_NOMBRE, SEGUNDO_NOMBRE, APELL_PATERNO, APELL_MATERNO, TO_DATE(FECHA_NACIMIENTO,'DD/MM/YYYY'), "
                        + "TELEFONO_FIJO, TELE_CELULAR, CORREO_ELECTRONICO, DIR_NOMBRE_CALLE, DIR_NUMERO, POBLACION FROM CLIENTE WHERE RUT_CLIENTE = " + cod);
                while (conec.result.next()){
                    /*ModificarCliente.txtCodigoCliente.setText(conec.result.getString("CODIGO_CLIENTE") );   
                    ModificarCliente.txtPrimerNombre.setText(conec.result.getString("PRIMER_NOMBRE"));
                    ModificarCliente.txtSegundoNombre.setText(conec.result.getString("SEGUNDO_NOMBRE"));
                    ModificarCliente.txtApePaterno.setText(conec.result.getString("APELL_PATERNO"));
                    ModificarCliente.txtApeMaterno.setText(conec.result.getString("APELL_MATERNO"));
                    ModificarCliente.txtFechaNacimiento.setText(conec.result.getString("FECHA_NACIMIENTO"));
                    ModificarCliente.txtTelefono.setText(conec.result.getString("TELEFONO_FIJO"));
                    ModificarCliente.txtTelefonoCelular.setText(conec.result.getString("TELE_CELULAR"));
                    ModificarCliente.txtEmail.setText(conec.result.getString("CORREO_ELECTRONICO"));
                    ModificarCliente.txtDireccion.setText(conec.result.getString("DIR_NOMBRE_CALLE"));
                    ModificarCliente.txtNumero.setText(conec.result.getString("DIR_NUMERO"));
                    ModificarCliente.txtPoblacion.setText(conec.result.getString("POBLACION"));*/
            }
    
        
        } catch (SQLException ex) {
            //Principal.setMessage(1, ex.getMessage());
        }
    }
    
    public static void conectarUsuario(String codigo, String cod){
        try{
            conec.exeQuery("SELECT * FROM VENDEDOR WHERE CODIGO_VENDEDOR = " + codigo);
            while (conec.result.next()){
                /*ModificarUsuario.txtRUN.setText(conec.result.getString("RUT_VENDEDOR"));
                ModificarUsuario.txtDV.setText(conec.result.getString("DIGITO_VERIFICADOR"));
                ModificarUsuario.txtPrimerNombre.setText(conec.result.getString("PRIM_NOMBRE"));
                ModificarUsuario.txtPrimerNombre1.setText(conec.result.getString("SEG_NOMBRE"));
                ModificarUsuario.txtApePaterno.setText(conec.result.getString("APELL_PATERNO"));
                ModificarUsuario.txtApeMaterno.setText(conec.result.getString("APELL_MATERNO"));
                ModificarUsuario.txtFechaContrato.setText(conec.result.getString("FECHA_INGRESO"));
                ModificarUsuario.txtContraseña.setText(conec.result.getString("CONTRASENA_USUARIO"));
                ModificarUsuario.txtFechaNacimiento.setText(conec.result.getString("FECHA_NACIMIENTO"));
                ModificarUsuario.txtTelefono.setText(conec.result.getString("TELEFONO_FIJO"));
                ModificarUsuario.txtCelular.setText(conec.result.getString("TELEFONO_CELULAR"));
                ModificarUsuario.txtEmail.setText(conec.result.getString("CORREO_ELECTRONICO"));
                ModificarUsuario.txtDireccion.setText(conec.result.getString("DIR_NOMBRE_CALLE"));
                ModificarUsuario.txtNumero.setText(conec.result.getString("DIR_NUMERO"));
                ModificarUsuario.txtPoblacion.setText(conec.result.getString("POBLACION"));*/
                
            }
            conec.exeQuery("SELECT * FROM VENDEDOR WHERE RUT_VENDEDOR = " + cod);
            while (conec.result.next()){
                /*ModificarUsuario.txtCodigoUsuario.setText(conec.result.getString("CODIGO_VENDEDOR"));
                ModificarUsuario.txtDV.setText(conec.result.getString("DIGITO_VERIFICADOR"));
                ModificarUsuario.txtPrimerNombre.setText(conec.result.getString("PRIM_NOMBRE"));
                ModificarUsuario.txtPrimerNombre1.setText(conec.result.getString("SEG_NOMBRE"));
                ModificarUsuario.txtApePaterno.setText(conec.result.getString("APELL_PATERNO"));
                ModificarUsuario.txtApeMaterno.setText(conec.result.getString("APELL_MATERNO"));
                ModificarUsuario.txtFechaContrato.setText(conec.result.getString("FECHA_INGRESO"));
                ModificarUsuario.txtContraseña.setText(conec.result.getString("CONTRASENA_USUARIO"));
                ModificarUsuario.txtFechaNacimiento.setText(conec.result.getString("FECHA_NACIMIENTO"));
                ModificarUsuario.txtTelefono.setText(conec.result.getString("TELEFONO_FIJO"));
                ModificarUsuario.txtCelular.setText(conec.result.getString("TELEFONO_CELULAR"));
                ModificarUsuario.txtEmail.setText(conec.result.getString("CORREO_ELECTRONICO"));
                ModificarUsuario.txtDireccion.setText(conec.result.getString("DIR_NOMBRE_CALLE"));
                ModificarUsuario.txtNumero.setText(conec.result.getString("DIR_NUMERO"));
                ModificarUsuario.txtPoblacion.setText(conec.result.getString("POBLACION"));*/
            }
        }catch (SQLException ex){
            //Principal.setMessage(1, ex.getMessage());
        }
    }
}
    
