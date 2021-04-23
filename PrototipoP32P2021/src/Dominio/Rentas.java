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
public class Rentas {

    private String Codigo_Renta;
    private String Codigo_Tienda;
    private String Codigo_Tarjeta;
    private String Codigo_Pelicula;
    private String Cantidad_Peliculas;
    private String Total_Renta;
    private String Fecha_Inicio;
    private String Fecha_Vencimiento;

    public Rentas() {
    }
    
    

    public Rentas(String Codigo_Renta, String Codigo_Tienda, String Codigo_Tarjeta, String Codigo_Pelicula, String Cantidad_Peliculas, String Total_Renta, String Fecha_Inicio, String Fecha_Vencimiento) {
        this.Codigo_Renta = Codigo_Renta;
        this.Codigo_Tienda = Codigo_Tienda;
        this.Codigo_Tarjeta = Codigo_Tarjeta;
        this.Codigo_Pelicula = Codigo_Pelicula;
        this.Cantidad_Peliculas = Cantidad_Peliculas;
        this.Total_Renta = Total_Renta;
        this.Fecha_Inicio = Fecha_Inicio;
        this.Fecha_Vencimiento = Fecha_Vencimiento;
    }

    public String getCodigo_Renta() {
        return Codigo_Renta;
    }

    public void setCodigo_Renta(String Codigo_Renta) {
        this.Codigo_Renta = Codigo_Renta;
    }

    public String getCodigo_Tienda() {
        return Codigo_Tienda;
    }

    public void setCodigo_Tienda(String Codigo_Tienda) {
        this.Codigo_Tienda = Codigo_Tienda;
    }

    public String getCodigo_Tarjeta() {
        return Codigo_Tarjeta;
    }

    public void setCodigo_Tarjeta(String Codigo_Tarjeta) {
        this.Codigo_Tarjeta = Codigo_Tarjeta;
    }

    public String getCodigo_Pelicula() {
        return Codigo_Pelicula;
    }

    public void setCodigo_Pelicula(String Codigo_Pelicula) {
        this.Codigo_Pelicula = Codigo_Pelicula;
    }

    public String getCantidad_Peliculas() {
        return Cantidad_Peliculas;
    }

    public void setCantidad_Peliculas(String Cantidad_Peliculas) {
        this.Cantidad_Peliculas = Cantidad_Peliculas;
    }

    public String getTotal_Renta() {
        return Total_Renta;
    }

    public void setTotal_Renta(String Total_Renta) {
        this.Total_Renta = Total_Renta;
    }

    public String getFecha_Inicio() {
        return Fecha_Inicio;
    }

    public void setFecha_Inicio(String Fecha_Inicio) {
        this.Fecha_Inicio = Fecha_Inicio;
    }

    public String getFecha_Vencimiento() {
        return Fecha_Vencimiento;
    }

    public void setFecha_Vencimiento(String Fecha_Vencimiento) {
        this.Fecha_Vencimiento = Fecha_Vencimiento;
    }

    @Override
    public String toString() {
        return "Renta{" + "Codigo_Renta=" + Codigo_Renta + ", Codigo_Tienda=" + Codigo_Tienda + ", Codigo_Tarjeta=" + Codigo_Tarjeta + ", Codigo_Pelicula=" + Codigo_Pelicula + ", Cantidad_Peliculas=" + Cantidad_Peliculas + ", Total_Renta=" + Total_Renta + ", Fecha_Inicio=" + Fecha_Inicio + ", Fecha_Vencimiento=" + Fecha_Vencimiento + '}';
    }
 
    
}
