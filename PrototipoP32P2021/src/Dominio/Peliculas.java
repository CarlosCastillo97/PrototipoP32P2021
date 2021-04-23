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
public class Peliculas {
    private String Codigo_Pelicula;
    private String Nombre_Pelicula;
    private String Autor_Pelicula;
    private String Genero_Pelicula;
    private String Clasificacion_Pelicula;
    private String Duracion_Pelicula;
    private String Precio_Pelicula;
    private String Existencias;
    private String Tienda;

    public Peliculas() {
    }

    public Peliculas(String Codigo_Pelicula, String Nombre_Pelicula, String Autor_Pelicula, String Genero_Pelicula, String Clasificacion_Pelicula, String Duracion_Pelicula, String Precio_Pelicula, String Existencias, String Tienda) {
        this.Codigo_Pelicula = Codigo_Pelicula;
        this.Nombre_Pelicula = Nombre_Pelicula;
        this.Autor_Pelicula = Autor_Pelicula;
        this.Genero_Pelicula = Genero_Pelicula;
        this.Clasificacion_Pelicula = Clasificacion_Pelicula;
        this.Duracion_Pelicula = Duracion_Pelicula;
        this.Precio_Pelicula = Precio_Pelicula;
        this.Existencias = Existencias;
        this.Tienda = Tienda;
    }

    public String getCodigo_Pelicula() {
        return Codigo_Pelicula;
    }

    public void setCodigo_Pelicula(String Codigo_Pelicula) {
        this.Codigo_Pelicula = Codigo_Pelicula;
    }

    public String getNombre_Pelicula() {
        return Nombre_Pelicula;
    }

    public void setNombre_Pelicula(String Nombre_Pelicula) {
        this.Nombre_Pelicula = Nombre_Pelicula;
    }

    public String getAutor_Pelicula() {
        return Autor_Pelicula;
    }

    public void setAutor_Pelicula(String Autor_Pelicula) {
        this.Autor_Pelicula = Autor_Pelicula;
    }

    public String getGenero_Pelicula() {
        return Genero_Pelicula;
    }

    public void setGenero_Pelicula(String Genero_Pelicula) {
        this.Genero_Pelicula = Genero_Pelicula;
    }

    public String getClasificacion_Pelicula() {
        return Clasificacion_Pelicula;
    }

    public void setClasificacion_Pelicula(String Clasificacion_Pelicula) {
        this.Clasificacion_Pelicula = Clasificacion_Pelicula;
    }

    public String getDuracion_Pelicula() {
        return Duracion_Pelicula;
    }

    public void setDuracion_Pelicula(String Duracion_Pelicula) {
        this.Duracion_Pelicula = Duracion_Pelicula;
    }

    public String getPrecio_Pelicula() {
        return Precio_Pelicula;
    }

    public void setPrecio_Pelicula(String Precio_Pelicula) {
        this.Precio_Pelicula = Precio_Pelicula;
    }

    public String getExistencias() {
        return Existencias;
    }

    public void setExistencias(String Existencias) {
        this.Existencias = Existencias;
    }

    public String getTienda() {
        return Tienda;
    }

    public void setTienda(String Tienda) {
        this.Tienda = Tienda;
    }

    @Override
    public String toString() {
        return "Peliculas{" + "Codigo_Pelicula=" + Codigo_Pelicula + ", Nombre_Pelicula=" + Nombre_Pelicula + ", Autor_Pelicula=" + Autor_Pelicula + ", Genero_Pelicula=" + Genero_Pelicula + ", Clasificacion_Pelicula=" + Clasificacion_Pelicula + ", Duracion_Pelicula=" + Duracion_Pelicula + ", Precio_Pelicula=" + Precio_Pelicula + ", Existencias=" + Existencias + ", Tienda=" + Tienda + '}';
    }
    
    
    
    

}

