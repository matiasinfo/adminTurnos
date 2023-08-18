package ar.edu.unlp.info.oo1.OrganizadorDeTurnos;

public class Cliente {
    String nombre;
    String telefono;
    String descripcion; 

    public Cliente(String nombre, String telefono, String descripcion) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.descripcion = descripcion;
    }
    
    public String getNombre() {
    	return this.nombre;
    }
    
    public String getTelefono() {
    	return this.telefono;
    }
    
    public String getDescripcion() {
    	return this.descripcion;
    }
 }