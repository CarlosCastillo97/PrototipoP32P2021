/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Datos;
import Datos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import Dominio.Tiendas;
/**
 * 
 * @author OtakuGT
 */
public class TiendasDAO {

      private static final String sql_select = "SELECT Codigo_Tienda, Nombre_Tienda, Ubicacion_Tienda,Estado_Tienda FROM Tiendas";
    private static final String sql_insert = "INSERT INTO Tiendas VALUES(?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE Tiendas SET Codigo_Tienda=?, Nombre_Tienda=?, Ubicacion_Tienda=?,Estado_Tienda=? WHERE Codigo_Tienda = ?";
    private static final String sql_delete = "DELETE FROM Tiendas WHERE Codigo_Tienda=?";
    private static final String sql_query = "SELECT Codigo_Tienda, Nombre_Tienda, Ubicacion_Tienda,Estado_Tienda FROM Tiendas WHERE Codigo_Tienda=?";

    public List<Tiendas> select() throws SQLException {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Tiendas cuenta = null;
        List<Tiendas> tipo1 = new ArrayList<Tiendas>();

        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(sql_select);
            rs = stmt.executeQuery();

            while (rs.next()) {
                String Codigo_Tienda = rs.getString("Codigo_Tienda");
                String Nombre_Tienda = rs.getString("Nombre_Tienda");
                String Ubicacion_Tienda = rs.getString("Ubicacion_Tienda");
                String Estado_Tienda = rs.getString("Estado_Tienda");
 
                cuenta = new Tiendas();
               cuenta.setCodigo_Tienda(Codigo_Tienda);
                cuenta.setNombre_Tienda(Nombre_Tienda);
                cuenta.setUbicacion_Tienda(Ubicacion_Tienda);
                cuenta.setEstado_Tienda(Estado_Tienda);
             

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

    public int insert(Tiendas cuenta) {
        Connection con = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(sql_insert);
            stmt.setString(1, cuenta.getCodigo_Tienda());
            stmt.setString(2, cuenta.getNombre_Tienda());
            stmt.setString(3, cuenta.getUbicacion_Tienda());
            stmt.setString(4, cuenta.getEstado_Tienda());
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

      public int update(Tiendas cuenta){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try {
            conn = Conexion.getConnection();
            //System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
          stmt.setString(1, cuenta.getCodigo_Tienda());
          stmt.setString(2, cuenta.getNombre_Tienda());
          stmt.setString(3, cuenta.getUbicacion_Tienda());
          stmt.setString(4, cuenta.getEstado_Tienda());
          stmt.setString(5, cuenta.getCodigo_Tienda());
 
            rows = stmt.executeUpdate();
            //System.out.println("Registros actualizado:" + rows);
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return rows;
    }

    public int delete(Tiendas cuenta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(sql_delete);
             stmt.setString(1, cuenta.getCodigo_Tienda());
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

    public Tiendas query(Tiendas cuenta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Tiendas> tipotr = new ArrayList<Tiendas>();
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(sql_query);
            stmt.setString(1, cuenta.getCodigo_Tienda());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String Codigo_Tienda = rs.getString("Codigo_Tienda");
                String Nombre_Tienda = rs.getString("Nombre_Tienda");
                String Ubicacion_Tienda = rs.getString("Ubicacion_Tienda");
                String Estado_Tienda = rs.getString("Estado_Tienda");
 
                cuenta = new Tiendas();
               cuenta.setCodigo_Tienda(Codigo_Tienda);
                cuenta.setNombre_Tienda(Nombre_Tienda);
                cuenta.setUbicacion_Tienda(Ubicacion_Tienda);
                cuenta.setEstado_Tienda(Estado_Tienda);
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
