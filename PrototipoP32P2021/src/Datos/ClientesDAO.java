/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author OtakuGT
 */
public class ClientesDAO {
     private static final String SQL_SELECT = "SELECT * FROM Clientes";
    private static final String SQL_INSERT = "INSERT INTO tbl_usuario(PK_id_usuario, nombre_usuario, apellido_usuario, username_usuario, password_usuario, correo_usuario, cambio_password, estado_usuario, ultima_conexion) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_usuario SET PK_id_usuario=?, nombre_usuario=?, apellido_usuario=?, username_usuario=?, password_usuario=?, correo_usuario=?, cambio_password=?, estado_usuario=?, ultima_conexion=? WHERE PK_id_usuario = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_usuario WHERE PK_id_usuario=?";
    private static final String SQL_QUERY = "SELECT PK_id_usuario, nombre_usuario, apellido_usuario, username_usuario, password_usuario, correo_usuario, cambio_password, estado_usuario, ultima_conexion FROM tbl_usuario WHERE username_usuario = ?";
}
