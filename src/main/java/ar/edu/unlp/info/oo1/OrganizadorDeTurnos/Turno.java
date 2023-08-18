package ar.edu.unlp.info.oo1.OrganizadorDeTurnos;

import java.time.LocalDateTime;

class Turno {
   private  Cliente cliente;
   private  LocalDateTime fechaHora;


    public Turno(Cliente cliente, LocalDateTime fechaHora) {
        this.cliente = cliente;
        this.fechaHora = fechaHora;
    }
    
    public Cliente getCliente() {
    	return this.cliente;
    }
    public LocalDateTime getFecha() {
    	return this.fechaHora;
    }
    public void setFecha(LocalDateTime fecha) {
    	this.fechaHora = fecha;
    }
    
    @Override
    public String toString() {
    	return (this.getFecha().getDayOfWeek() +" " + this.getFecha().getDayOfMonth() + " Hora disponible " + this.fechaHora.getHour());
    }
}
