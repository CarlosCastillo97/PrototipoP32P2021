package Datos;


import Dominio.Empleados;
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
public class EmpleadosDAO extends Conexion {

    private static final String SQL_SELECT = "SELECT * FROM Empleados";
    private static final String SQL_INSERT = "INSERT INTO Empleados(PK_id_usuario, nombre_usuario, apellido_usuario, username_usuario, password_usuario, correo_usuario, cambio_password, estado_usuario, ultima_conexion) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE Empleados SET PK_id_usuario=?, nombre_usuario=?, apellido_usuario=?, username_usuario=?, password_usuario=?, correo_usuario=?, cambio_password=?, estado_usuario=?, ultima_conexion=? WHERE PK_id_usuario = ?";
    private static final String SQL_DELETE = "DELETE FROM Empleados WHERE PK_id_usuario=?";
    private static final String SQL_QUERY = "SELECT PK_id_usuario, nombre_usuario, apellido_usuario, username_usuario, password_usuario, correo_usuario, cambio_password, estado_usuario, ultima_conexion FROM Empleados WHERE username_usuario = ?";

    Conexion conectar = new Conexion();
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    Empleados empleado = null;

    public List<Empleados> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Empleados empleado = null;
        List<Empleados> empleados = new ArrayList<Empleados>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_usuario = rs.getInt("PK_id_usuario");
                String nombre = rs.getString("nombre_usuario");
                String apellido = rs.getString("apellido_usuario");
                String username = rs.getString("username_usuario");
                String pass = rs.getString("password_usuario");
                var correo = rs.getString("correo_usuario");
                int cambio = rs.getInt("cambio_password");
                int estado = rs.getInt("estado_usuario");
                String ultima = rs.getString("ultima_conexion");

                empleado = new Empleados();
                empleado.setId_usuario(id_usuario);
                empleado.setNombre_usuario(nombre);
                empleado.setApellido_usuario(apellido);
                empleado.setUser_usuario(username);
                empleado.setPassword_usuario(pass);
                empleado.setCorreo_usuario(correo);
                empleado.setCambio_password(cambio);
                empleado.setEstado_usuario(estado);
                empleado.setUltima_conexion(ultima);

                empleados.add(empleado);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return empleados;
    }

    public Empleados query(Empleados empleado) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, empleado.getUser_usuario());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_usuario = rs.getInt("PK_id_usuario");
                String nombre_usuario = rs.getString("nombre_usuario");
                String apellido_usuario = rs.getString("apellido_usuario");
                String user_usuario = rs.getString("username_usuario");
                String password_usuario = rs.getString("password_usuario");
                String correo_usuario = rs.getString("correo_usuario");
                int cambio_contrasena = rs.getInt("cambio_password");
                int estado_usuario = rs.getInt("estado_usuario");
                String ultima_conexion = rs.getString("ultima_conexion");

                empleado = new Empleados();
                empleado.setId_usuario(id_usuario);
                empleado.setNombre_usuario(nombre_usuario);
                empleado.setApellido_usuario(apellido_usuario);
                empleado.setUser_usuario(user_usuario);
                empleado.setPassword_usuario(password_usuario);
                empleado.setCorreo_usuario(correo_usuario);
                empleado.setCambio_password(cambio_contrasena);
                empleado.setEstado_usuario(estado_usuario);
                empleado.setUltima_conexion(ultima_conexion);

                rows++;
            }
            System.out.println("Registros buscado:" + empleado);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return empleado;
    }

    public int delete(Empleados empleado) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, empleado.getId_usuario());
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

    public int update(Empleados empleado) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            //System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, empleado.getId_usuario());
            stmt.setString(2, empleado.getNombre_usuario());
            stmt.setString(3, empleado.getApellido_usuario());
            stmt.setString(4, empleado.getUser_usuario());
            stmt.setString(5, empleado.getPassword_usuario());
            stmt.setString(6, empleado.getCorreo_usuario());
            stmt.setInt(7, empleado.getCambio_password());
            stmt.setInt(8, empleado.getEstado_usuario());
            stmt.setString(9, empleado.getUltima_conexion());
            stmt.setInt(10, empleado.getId_usuario());
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

    public int insert(Empleados empleado) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, empleado.getId_usuario());
            stmt.setString(2, empleado.getNombre_usuario());
            stmt.setString(3, empleado.getApellido_usuario());
            stmt.setString(4, empleado.getUser_usuario());
            stmt.setString(5, empleado.getPassword_usuario());
            stmt.setString(6, empleado.getCorreo_usuario());
            stmt.setInt(7, empleado.getCambio_password());
            stmt.setInt(8, empleado.getEstado_usuario());
            stmt.setString(9, empleado.getUltima_conexion());
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