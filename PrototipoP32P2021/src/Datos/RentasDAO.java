/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import Datos.Conexion;
import Dominio.Rentas;

/**
 * 
 * @author OtakuGT
 */
public class RentasDAO {
  
       
   private static final String sql_select = "SELECT Codigo_Renta, Codigo_Tienda, Codigo_Tarjeta,Codigo_Pelicula,Cantidad_Peliculas,Total_Renta,Fecha_Inicio,Fecha_Vencimiento FROM Rentas";
    private static final String sql_insert = "INSERT INTO Rentas (Codigo_Renta, Codigo_Tienda, Codigo_Tarjeta,Codigo_Pelicula,Cantidad_Peliculas,Total_Renta,Fecha_Inicio,Fecha_Vencimiento) VALUES(?,?,?,?,?,?,?,?)";  
    private static final String sql_delete = "DELETE FROM Rentas WHERE Codigo_Renta=?";
    private static final String sql_query = "SELECT Codigo_Renta, Codigo_Tienda, Codigo_Tarjeta,Codigo_Pelicula,Cantidad_Peliculas,Total_Renta,Fecha_Inicio,Fecha_Vencimiento,Tienda FROM Rentas WHERE Codigo_Pelicula=?";

    public List<Rentas> select() throws SQLException {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Rentas cuenta = null;
        List<Rentas> tipo1 = new ArrayList<Rentas>();

        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(sql_select);
            rs = stmt.executeQuery();

            while (rs.next()) {
                String Codigo_Renta = rs.getString("Codigo_Renta");
                String Codigo_Tienda = rs.getString("Codigo_Tienda");
                 String Codigo_Tarjeta = rs.getString("Codigo_Tarjeta");
                String Codigo_Pelicula = rs.getString("Codigo_Pelicula");
                String Cantidad_Peliculas = rs.getString("Cantidad_Peliculas");
                String Total_Renta = rs.getString("Total_Renta");
                String Fecha_Inicio = rs.getString("Fecha_Inicio");
                String Fecha_Vencimiento = rs.getString("Fecha_Vencimiento");
  
 
                cuenta = new Rentas();
                
         
                cuenta.setCodigo_Renta(Codigo_Renta);
                cuenta.setCodigo_Tienda(Codigo_Tienda);
                cuenta.setCodigo_Tarjeta(Codigo_Tarjeta);
                cuenta.setCodigo_Pelicula(Codigo_Pelicula);
                 cuenta.setCantidad_Peliculas(Cantidad_Peliculas);
                cuenta.setTotal_Renta(Total_Renta);
                cuenta.setFecha_Inicio(Fecha_Inicio);
                cuenta.setFecha_Vencimiento(Fecha_Vencimiento);
 

                tipo1.add(cuenta);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            Conexion.close(con);
            Conexion.close(stmt);
            Conexion.close(rs);
        }
        return tipo1;
    }

    public int insert(Rentas cuenta) {
        Connection con = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(sql_insert);
            stmt.setString(1, cuenta.getCodigo_Renta());
            stmt.setString(2, cuenta.getCodigo_Tienda());
            stmt.setString(3, cuenta.getCodigo_Tarjeta());
            stmt.setString(4, cuenta.getCodigo_Pelicula());
            stmt.setString(5, cuenta.getCantidad_Peliculas());
            stmt.setString(6, cuenta.getTotal_Renta());
            stmt.setString(7, cuenta.getFecha_Inicio());
            stmt.setString(8, cuenta.getFecha_Vencimiento());

        

            rows = stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Registro exitoso");
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            Conexion.close(con);
            Conexion.close(stmt);
        }
        return rows;
    }


    public int delete(Rentas cuenta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(sql_delete);
             stmt.setString(1, cuenta.getCodigo_Renta());
            rows = stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, " Eliminado Con Exito");
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public Rentas query(Rentas cuenta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Rentas> tipotr = new ArrayList<Rentas>();
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(sql_query);
            stmt.setString(1, cuenta.getCodigo_Renta());
            rs = stmt.executeQuery();
             while (rs.next()) {
                String Codigo_Renta = rs.getString("Codigo_Renta");
                String Codigo_Tienda = rs.getString("Codigo_Tienda");
                 String Codigo_Tarjeta = rs.getString("Codigo_Tarjeta");
                String Codigo_Pelicula = rs.getString("Codigo_Pelicula");
                String Cantidad_Peliculas = rs.getString("Cantidad_Peliculas");
                String Total_Renta = rs.getString("Total_Renta");
                String Fecha_Inicio = rs.getString("Fecha_Inicio");
                String Fecha_Vencimiento = rs.getString("Fecha_Vencimiento");
  
 
                cuenta = new Rentas();
                
         
                cuenta.setCodigo_Renta(Codigo_Renta);
                cuenta.setCodigo_Tienda(Codigo_Tienda);
                cuenta.setCodigo_Tarjeta(Codigo_Tarjeta);
                cuenta.setCodigo_Pelicula(Codigo_Pelicula);
                 cuenta.setCantidad_Peliculas(Cantidad_Peliculas);
                cuenta.setTotal_Renta(Total_Renta);
                cuenta.setFecha_Inicio(Fecha_Inicio);
                cuenta.setFecha_Vencimiento(Fecha_Vencimiento);
 
                rows++;
            }

        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return cuenta;
    }

}
