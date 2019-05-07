package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import sma.Asignatura;
import sma.Colegio;
import sma.ColegioExcepcion;
import sma.Estudiante;
import sma.Persona;
import sma.Profesor;

public class ColegioTest {
	Asignatura asignatura1 = null;
	Colegio colegio1 = null;
	Colegio colegio2 = null;
	Estudiante estudiante1 = null;
	Estudiante estudiante2 = null;
	Persona persona1 = null;
	Profesor profesor1 = null;
	Profesor profesor2 = null;
	Asignatura asignatura2 = null;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		profesor1 = new Profesor(18, "Jesus", "Calle agua", 1999, 'M', 500f);
		profesor2 = new Profesor(18, "Cristo", "Calle agua", 1999, 'M', 400f);
		asignatura1 = new Asignatura("Lengua", 50f, profesor1);
		asignatura2 = new Asignatura("Mates", 50f, profesor1);
		List<Asignatura> asignaturas = new ArrayList<>();
		asignaturas.add(asignatura1);
		asignaturas.add(asignatura2);
		estudiante1 = new Estudiante(18, "Pablo", "Calle agua", 1999, 'M', asignaturas);
		List<Estudiante> estudiantes = new ArrayList<>();
		estudiantes.add(estudiante1);
		List<Profesor> profesores = new ArrayList<>();
		profesores.add(profesor1);
		profesores.add(profesor2);
		colegio1 = new Colegio(estudiantes, profesores, asignaturas);
		
		
		estudiante2 = new  Estudiante(18, "Pablo", "Calle agua", 1999, 'M', asignaturas);
		List<Asignatura> asignaturas2 = new ArrayList<>();
		asignaturas2.add(asignatura1);
		asignaturas2.add(asignatura2);
		estudiante1 = new Estudiante(18, "Pablo", "Calle agua", 1999, 'M', asignaturas);
		
		
		List<Estudiante> estudiantes2 = new ArrayList<>();
		List<Asignatura> asignaturas3 = new ArrayList<>();
		List<Profesor> profesores2 = new ArrayList<>();

		colegio2 = new Colegio(estudiantes2, profesores2, asignaturas3);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void obtienePrecioTotalMatriculaEstudianteTest() {
		assertEquals(100, (int)colegio1.obtienePrecioTotalMatriculaEstudiante(estudiante1));
	}
	
	@Test
	public void obtienePresupuestoColegioTest() {
		assertEquals(5100, (int)colegio1.obtienePresupuestoColegio());
	}
	
	@Test
	public void anadeEstudianteTest() {
		assertTrue(colegio1.anadeEstudiante(estudiante2));
		List<Estudiante> estudiantes1 = new ArrayList<>();
		estudiantes1.add(estudiante1);
		colegio2.anadeEstudiante(estudiante1);
		assertArrayEquals(estudiantes1.toArray(), colegio2.getListaEstudiantes().toArray());
	}
	
	@Test
	public void obtieneSueldoTotalProfesoresTest() {
		assertEquals(900, (int)colegio1.obtieneSueldoTotalProfesores());
	}
	
	@Test
	public void obtienePresupuestoNetoColegioTest() throws ColegioExcepcion {
		colegio1.obtienePresupuestoNetoColegio();
	}
	
	@Test
	public void eliminaAsignaturaTest() {
		assertTrue(colegio1.eliminaAsignatura(asignatura1));
		colegio1.eliminaAsignatura(asignatura2);
		List<Asignatura> asignaturas3 = new ArrayList<>();
		assertArrayEquals(asignaturas3.toArray(), colegio1.getListaAsignaturas().toArray());
	}
}
