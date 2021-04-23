/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dominio;

/**
 * 
 * @author 
 */
public class Tiendas {
    private String Codigo_Tienda;
    private String Nombre_Tienda;
    private String Ubicacion_Tienda;
    private String Estado_Tienda;

    public Tiendas() {
    }

    public Tiendas(String Codigo_Tienda, String Nombre_Tienda, String Ubicacion_Tienda, String Estado_Tienda) {
        this.Codigo_Tienda = Codigo_Tienda;
        this.Nombre_Tienda = Nombre_Tienda;
        this.Ubicacion_Tienda = Ubicacion_Tienda;
        this.Estado_Tienda = Estado_Tienda;
    }

    public String getCodigo_Tienda() {
        return Codigo_Tienda;
    }

    public void setCodigo_Tienda(String Codigo_Tienda) {
        this.Codigo_Tienda = Codigo_Tienda;
    }

    public String getNombre_Tienda() {
        return Nombre_Tienda;
    }

    public void setNombre_Tienda(String Nombre_Tienda) {
        this.Nombre_Tienda = Nombre_Tienda;
    }

    public String getUbicacion_Tienda() {
        return Ubicacion_Tienda;
    }

    public void setUbicacion_Tienda(String Ubicacion_Tienda) {
        this.Ubicacion_Tienda = Ubicacion_Tienda;
    }

    public String getEstado_Tienda() {
        return Estado_Tienda;
    }

    public void setEstado_Tienda(String Estado_Tienda) {
        this.Estado_Tienda = Estado_Tienda;
    }

    @Override
    public String toString() {
        return "Tiendas{" + "Codigo_Tienda=" + Codigo_Tienda + ", Nombre_Tienda=" + Nombre_Tienda + ", Ubicacion_Tienda=" + Ubicacion_Tienda + ", Estado_Tienda=" + Estado_Tienda + '}';
    }
    
    

}
