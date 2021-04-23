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
import Dominio.Peliculas;


/**
 * 
 * @author OtakuGT
 */
public class PeliculasDAO {
    
       
   private static final String sql_select = "SELECT Codigo_Pelicula, Nombre_Pelicula, Autor_Pelicula,Genero_Pelicula,Clasificacion_Pelicula,Duracion_Pelicula,Precio_Pelicula,Existencias,Tienda FROM Pelicula";
    private static final String sql_insert = "INSERT INTO Pelicula VALUES(?,?,?,?,?,?,?,?,?)";  
    private static final String sql_delete = "DELETE FROM Pelicula WHERE Codigo_Pelicula=?";
    private static final String sql_query = "SELECT Codigo_Pelicula, Nombre_Pelicula, Autor_Pelicula,Genero_Pelicula,Clasificacion_Pelicula,Duracion_Pelicula,Precio_Pelicula,Existencias,Tienda FROM Pelicula WHERE Codigo_Pelicula=?";

    public List<Peliculas> select() throws SQLException {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Peliculas cuenta = null;
        List<Peliculas> tipo1 = new ArrayList<Peliculas>();

        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(sql_select);
            rs = stmt.executeQuery();

            while (rs.next()) {
                String Codigo_Pelicula = rs.getString("Codigo_Pelicula");
                String Nombre_Pelicula = rs.getString("Nombre_Pelicula");
                 String Autor_Pelicula = rs.getString("Autor_Pelicula");
                String Genero_Pelicula = rs.getString("Genero_Pelicula");
                String Clasificacion_Pelicula = rs.getString("Clasificacion_Pelicula");
                String Duracion_Pelicula = rs.getString("Duracion_Pelicula");
                String Precio_Pelicula = rs.getString("Precio_Pelicula");
                String Existencias = rs.getString("Existencias");
                String Tienda = rs.getString("Tienda");
  
 
                cuenta = new Peliculas();
                
               cuenta.setCodigo_Pelicula(Codigo_Pelicula);
                cuenta.setNombre_Pelicula(Nombre_Pelicula);
                cuenta.setAutor_Pelicula(Autor_Pelicula);
                cuenta.setGenero_Pelicula(Genero_Pelicula);
                cuenta.setClasificacion_Pelicula(Clasificacion_Pelicula);
                 cuenta.setDuracion_Pelicula(Duracion_Pelicula);
                cuenta.setPrecio_Pelicula(Precio_Pelicula);
                cuenta.setExistencias(Existencias);
                cuenta.setTienda(Tienda);
 

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

    public int insert(Peliculas cuenta) {
        Connection con = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(sql_insert);
            stmt.setString(1, cuenta.getCodigo_Pelicula());
            stmt.setString(2, cuenta.getNombre_Pelicula());
            stmt.setString(3, cuenta.getAutor_Pelicula());
            stmt.setString(4, cuenta.getGenero_Pelicula());
            stmt.setString(5, cuenta.getClasificacion_Pelicula());
            stmt.setString(6, cuenta.getDuracion_Pelicula());
            stmt.setString(7, cuenta.getPrecio_Pelicula());
            stmt.setString(8, cuenta.getExistencias());
            stmt.setString(9, cuenta.getTienda());
        
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


    public int delete(Peliculas cuenta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(sql_delete);
             stmt.setString(1, cuenta.getCodigo_Pelicula());
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

    public Peliculas query(Peliculas cuenta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Peliculas> tipotr = new ArrayList<Peliculas>();
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(sql_query);
            stmt.setString(1, cuenta.getCodigo_Pelicula());
            rs = stmt.executeQuery();
        while (rs.next()) {
                String Codigo_Pelicula = rs.getString("Codigo_Pelicula");
                String Nombre_Pelicula = rs.getString("Nombre_Pelicula");
                 String Autor_Pelicula = rs.getString("Autor_Pelicula");
                String Genero_Pelicula = rs.getString("Genero_Pelicula");
                String Clasificacion_Pelicula = rs.getString("Clasificacion_Pelicula");
                String Duracion_Pelicula = rs.getString("Duracion_Pelicula");
                String Precio_Pelicula = rs.getString("Precio_Pelicula");
                String Existencias = rs.getString("Existencias");
                String Tienda = rs.getString("Tienda");
  
 
                cuenta = new Peliculas();
                
               cuenta.setCodigo_Pelicula(Codigo_Pelicula);
                cuenta.setNombre_Pelicula(Nombre_Pelicula);
                cuenta.setAutor_Pelicula(Autor_Pelicula);
                cuenta.setGenero_Pelicula(Genero_Pelicula);
                cuenta.setClasificacion_Pelicula(Clasificacion_Pelicula);
                 cuenta.setDuracion_Pelicula(Duracion_Pelicula);
                cuenta.setPrecio_Pelicula(Precio_Pelicula);
                cuenta.setExistencias(Existencias);
                cuenta.setTienda(Tienda);
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
