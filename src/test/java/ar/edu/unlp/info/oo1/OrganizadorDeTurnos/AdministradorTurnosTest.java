package ar.edu.unlp.info.oo1.OrganizadorDeTurnos;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class AdministradorTurnosTest {

	Turno turno1, turno2;
	Cliente matias,santino;
	AdministradorTurnos sistema;
	
	@BeforeEach
	void setUp() throws Exception {
		matias = new Cliente("Matias","2216131620","Contracturas");
		santino = new Cliente ("Santino","123456671","Relajar");
		turno1 = new Turno(matias,LocalDateTime.of(2023, 8, 18, 16, 0));
		turno2 = new Turno(santino,LocalDateTime.of(2023, 8, 18, 19, 0));
		sistema = new AdministradorTurnos();
		sistema.agregarTurno(new Turno(new Cliente("","",""),LocalDateTime.of(2023, 8, 18, 17, 00)));
	}
	
	@Test
    public void testAgregarTurnos() {
    	assertEquals(1,sistema.cantTurnos());
    	sistema.agregarTurno(turno1);
		sistema.agregarTurno(turno2);
		assertEquals(3,sistema.cantTurnos());
    }
    
	@Test
    public void testTurnosDelDia() {
    	assertEquals(1,sistema.cantTurnos());
    	sistema.agregarTurno(turno1);
		sistema.agregarTurno(turno2);
		assertEquals(3,sistema.cantTurnos());
    }
    
	
	@Test
    public void testTurnosDisponibles() {
		assertEquals(15,sistema.cantDisponibles());
    	sistema.agregarTurno(turno1);
    	sistema.agregarTurno(turno2);
    	assertEquals(13,sistema.cantDisponibles());
	}
    
	
    
    

}
