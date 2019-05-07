package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sma.Asignatura;
import sma.Colegio;
import sma.ColegioExcepcion;
import sma.Estudiante;
import sma.Profesor;

public class ColegioTest {
	
	Colegio colegio1=null;
	
	Estudiante estudiante1=null;
	Estudiante estudiante2=null;
	Estudiante estudiante3=null;
	
	Asignatura asignatura1=null;
	Asignatura asignatura2=null;
	Asignatura asignatura3=null;
	
	Profesor profesor1=null;
	Profesor profesor2=null;
	Profesor profesor3=null;
	
	List<Estudiante> listaestudiantes=new ArrayList<>();
	List<Asignatura> listaasignaturas=new ArrayList<>();
	List<Profesor> listaprofesores=new ArrayList<>();
	
	
	@Before
	public void setUp() throws Exception {
		
		estudiante1=new Estudiante(28, "Fran", "Madrid", 1991, 'H', listaasignaturas) ;
		estudiante2=new Estudiante(28, "Carlos", "Madrid", 1991, 'H', listaasignaturas);
		estudiante3=new Estudiante(25, "Fernanda", "Madrid", 1994, 'M', listaasignaturas);
		listaestudiantes.add(estudiante1);
		listaestudiantes.add(estudiante2);
		
		asignatura1=new Asignatura("Programacion",105f,profesor1);
		asignatura2=new Asignatura("FOL",105f,profesor2);
		listaasignaturas.add(asignatura1);
		listaasignaturas.add(asignatura2);
		
		profesor1=new Profesor(60,"Jose","Madrid",1950,'H',1550f);
		profesor2=new Profesor(61,"Elena","Madrid",1951,'M',1550f);
		profesor3=new Profesor(62,"Carla","Madrid",1952,'M',1550f);
		listaprofesores.add(profesor1);
		listaprofesores.add(profesor2);
		
		colegio1=new Colegio(listaestudiantes,listaprofesores,listaasignaturas);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void obtienePrecioTotalMatriculaEstudianteTest() {
		assertEquals(210f,colegio1.obtienePrecioTotalMatriculaEstudiante(estudiante1), 0);;
	}
	
	@Test
	public void obtienePresupuestoColegioTest() {
		assertEquals(5420f, colegio1.obtienePresupuestoColegio(), 0);;
	}

	@Test
	public void anadeEstudianteTest() {
		List<Estudiante> listaAux=new ArrayList<>();
		listaAux.add(estudiante3);
		
	}
	
	@Test
	public void eliminaAsignaturaTest() {
		assertTrue(colegio1.eliminaAsignatura(asignatura1));
		assertFalse(colegio1.eliminaAsignatura(asignatura1));
	}
	
	@Test
	public void obtieneSueldoTotalProfesoresTest() {
		assertEquals(3100,colegio1.obtieneSueldoTotalProfesores() , 0);;
	}
	
	@Test(expected=ColegioExcepcion.class)
	public void obtienePresupuestoNetoColegioTest() throws ColegioExcepcion {
		fail("Not yet implemented");
	}
}
