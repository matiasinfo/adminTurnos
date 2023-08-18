package ar.edu.unlp.info.oo1.OrganizadorDeTurnos;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;

class AdministradorTurnos {
	private List<Turno> turnos;
    private List<Turno> turnosDisponibles;

    public AdministradorTurnos() {
        turnosDisponibles = new ArrayList<>();
        turnos = new ArrayList<>();
        generarTurnosDisponibles();
    }

    private void generarTurnosDisponibles() {
        LocalDate fechaInicio = LocalDate.now(); // Comenzar desde la fecha actual
        LocalDate fechaFin = fechaInicio.plusDays(2); // 2 semanas a partir de la fecha actual

        while (fechaInicio.isBefore(fechaFin)) {
            if (fechaInicio.getDayOfWeek() != DayOfWeek.SUNDAY) {
                // Agregar horarios disponibles para días de lunes a sábado
                generarTurnosDia(fechaInicio);
            }
            fechaInicio = fechaInicio.plusDays(1); // Avanzar al siguiente día
        }
    }

    private void generarTurnosDia(LocalDate fecha) {
        LocalTime horaInicioManana = LocalTime.of(9, 0);
        LocalTime horaFinManana = LocalTime.of(12, 0);

        LocalTime horaInicioTarde = LocalTime.of(15, 0);
        LocalTime horaFinTarde = LocalTime.of(20, 0);

        for (LocalTime hora = horaInicioManana; hora.isBefore(horaFinManana); hora = hora.plusMinutes(60)) {
            getTurnosDisponibles().add(new Turno(null, fecha.atTime(hora)));
        }

        for (LocalTime hora = horaInicioTarde; hora.isBefore(horaFinTarde); hora = hora.plusMinutes(60)) {
            getTurnosDisponibles().add(new Turno(null, fecha.atTime(hora)));
        }
    }
    

    public void agregarTurno(Turno turno) {
        turnos.add(turno);
        eliminarTurnosDisponiblesConflictivos(turno.getFecha());
    }

    private void eliminarTurnosDisponiblesConflictivos(LocalDateTime fechaHora) {
        List<Turno> conflictivos = turnosDisponibles.stream()
            .filter(turno -> turno.getFecha().isEqual(fechaHora))
            .collect(Collectors.toList());

        turnosDisponibles.removeAll(conflictivos);
    }

    public void eliminarTurno(Turno turno) {
        turnos.remove(turno);
    }

    public void modificarTurno(Turno turno, LocalDateTime nuevaFechaHora) {
        turno.setFecha(nuevaFechaHora);
    }
    
    public List<Turno> obtenerTurnosDelDia(){
    	return this.turnos.stream()
    			.filter(t -> t.getFecha().getDayOfMonth() == LocalDate.now().getDayOfMonth())
    			.collect(Collectors.toList());
    }

	private List<Turno> getTurnosDisponibles() {
		return turnosDisponibles;
	}
	public int cantTurnos() {
		return this.turnos.size();
	}
	
	public int cantDisponibles() {
		return this.turnosDisponibles.size();
	}
	
	
	
	
    public static void main(String[] args) {
        AdministradorTurnos administrador = new AdministradorTurnos();
        administrador.agregarTurno(new Turno(new Cliente("","",""),LocalDateTime.now().plusHours(3)));
        administrador.agregarTurno(new Turno(new Cliente("","",""),LocalDateTime.now().plusHours(4)));
        administrador.agregarTurno(new Turno(new Cliente("","",""),LocalDateTime.now().plusHours(5)));
        List<Turno> nueva = administrador.obtenerTurnosDelDia();
        for(Turno turno : nueva) {
        	System.out.println(turno.toString());
        	
        	
        }
    }
	
	
}




