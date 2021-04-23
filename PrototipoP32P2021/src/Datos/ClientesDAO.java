/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Dominio.Clientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author OtakuGT
 */
public class ClientesDAO {
    private static final String SQL_SELECT = "SELECT * FROM Clientes";
    private static final String SQL_INSERT = "INSERT INTO Clientes(Membresia, Nombre_Cliente, Dpi_Cliente, Telefono_Cliente, Direccion_Cliente, Correo_Cliente, Mora_Acumulada, Renta_Acumulada, Bonos_Acumulados) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE Clientes SET Membresia=?, Nombre_Cliente=?, Dpi_Cliente=?, Telefono_Cliente=?, Direccion_Cliente=?, Correo_Cliente=?, Mora_Acumulada=?, Renta_Acumulada=?, Bonos_Acumulados=? WHERE Membresia = ?";
    private static final String SQL_DELETE = "DELETE FROM Clientes WHERE Membresia=?";
    private static final String SQL_QUERY = "SELECT Membresia, Nombre_Cliente, Dpi_Cliente, Telefono_Cliente, Direccion_Cliente, Correo_Cliente, Mora_Acumulada, Renta_Acumulada, Bonos_Acumulados FROM Clientes WHERE Membresia = ?";
    
    public List<Clientes> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Clientes cliente = null;
        List<Clientes> clientes = new ArrayList<Clientes>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String Membresia = rs.getString("Membresia");
                String Nombre = rs.getString("Nombre_Cliente");
                String Dpi = rs.getString("Dpi_Cliente");
                String Telefono = rs.getString("Telefono_Cliente");
                String Direccion = rs.getString("Direccion_Cliente");
                String Correo = rs.getString("Correo_Cliente");
                int Mora = rs.getInt("Mora_Acumulada");
                int Renta = rs.getInt("Renta_Acumulada");
                int Bonos = rs.getInt("Bonos_Acumulados");

                cliente = new Clientes();
                cliente.setMembresia(Membresia);
                cliente.setNombre(Nombre);
                cliente.setDPI(Dpi);
                cliente.setTelefono(Telefono);
                cliente.setDireccion(Direccion);
                cliente.setCorreo(Correo);
                cliente.setMora(Mora);
                cliente.setRentasAC(Renta);
                cliente.setBonosAC(Bonos);

                clientes.add(cliente);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return clientes;
    }

    public Clientes query(Clientes cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, cliente.getMembresia());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String membresia = rs.getString("Membresia");
                String nombre = rs.getString("Nombre_Cliente");
                String dpi = rs.getString("Dpi_Cliente");
                String tel = rs.getString("Telefono_Cliente");
                String dire = rs.getString("Direccion_Cliente");
                String correo = rs.getString("Correo_Cliente");
                int mora = rs.getInt("Mora_Acumulada");
                int renta = rs.getInt("Renta_Acumulada");
                int bonos = rs.getInt("Bonos_Acumulados");

                cliente = new Clientes();
                cliente.setMembresia(membresia);
                cliente.setNombre(nombre);
                cliente.setDPI(dpi);
                cliente.setTelefono(tel);
                cliente.setDireccion(dire);
                cliente.setCorreo(correo);
                cliente.setMora(mora);
                cliente.setRentasAC(renta);
                cliente.setBonosAC(bonos);

                rows++;
            }
            System.out.println("Registros buscado:" + cliente);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return cliente;
    }

    public int delete(Clientes cliente) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, cliente.getMembresia());
            rows = stmt.executeUpdate();
            //System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int update(Clientes cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            //System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, cliente.getMembresia());
            stmt.setString(2, cliente.getNombre());
            stmt.setString(3, cliente.getDPI());
            stmt.setString(4, cliente.getTelefono());
            stmt.setString(5, cliente.getDireccion());
            stmt.setString(6, cliente.getCorreo());
            stmt.setInt(7, cliente.getMora());
            stmt.setInt(8, cliente.getRentasAC());
            stmt.setInt(9, cliente.getBonosAC());
            stmt.setString(10, cliente.getMembresia());
            rows = stmt.executeUpdate();
            //System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int insert(Clientes cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, cliente.getMembresia());
            stmt.setString(2, cliente.getNombre());
            stmt.setString(3, cliente.getDPI());
            stmt.setString(4, cliente.getTelefono());
            stmt.setString(5, cliente.getDireccion());
            stmt.setString(6, cliente.getCorreo());
            stmt.setInt(7, cliente.getMora());
            stmt.setInt(8, cliente.getRentasAC());
            stmt.setInt(9, cliente.getBonosAC());
            stmt.executeUpdate();
        } catch (Exception ex) {
            System.err.println(ex);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return 1;
    }
}
