/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

/**
 *
 * @author OtakuGT
 */
public class Clientes {
    private String Membresia;
    private String Nombre;
    private String DPI;
    private String Telefono;
    private String Direccion;
    private String Correo;
    private int Mora;
    private int RentasAC;
    private int BonosAC;

    public Clientes() {
    }

    public String getMembresia() {
        return Membresia;
    }

    public void setMembresia(String Membresia) {
        this.Membresia = Membresia;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDPI() {
        return DPI;
    }

    public void setDPI(String DPI) {
        this.DPI = DPI;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public int getMora() {
        return Mora;
    }

    public void setMora(int Mora) {
        this.Mora = Mora;
    }

    public int getRentasAC() {
        return RentasAC;
    }

    public void setRentasAC(int RentasAC) {
        this.RentasAC = RentasAC;
    }

    public int getBonosAC() {
        return BonosAC;
    }

    public void setBonosAC(int BonosAC) {
        this.BonosAC = BonosAC;
    }

    @Override
    public String toString() {
        return "Clientes{" + "Membresia=" + Membresia + ", Nombre=" + Nombre + ", DPI=" + DPI + ", Telefono=" + Telefono + ", Direccion=" + Direccion + ", Correo=" + Correo + ", Mora=" + Mora + ", RentasAC=" + RentasAC + ", BonosAC=" + BonosAC + '}';
    }
}

