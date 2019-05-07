package Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import sma.Asignatura;
import sma.Colegio;
import sma.ColegioExcepcion;
import sma.Estudiante;
import sma.Persona;
import sma.Profesor;

public class ColegioTest {
	
	List<Estudiante> listaEstudiantes = null;
	List<Profesor> listaProfesores = null;
	List<Asignatura> listaAsignaturas = null;
	
	Estudiante estudiante1 = null;
	Estudiante estudiante2 = null;
	Estudiante estudiante3 = null;
	
	Asignatura asignatura1 = null;
	Asignatura asignatura2 = null;
	Asignatura asignatura3 = null;
	
	Profesor profe1 = null;
	Profesor profe2 = null;
	Profesor profe3 = null;
	
	Persona persona1 = null;
	Persona persona2 = null;
	Persona persona3 = null;
	
	
	Colegio colegio = null;

	@Before
	public void setUp() throws Exception {
		
		listaEstudiantes = new ArrayList<Estudiante>();
		listaProfesores = new ArrayList<Profesor>();
		listaAsignaturas = new ArrayList<Asignatura>();
		
		
		estudiante1 = new Estudiante(15, "Pedro","direccion1", 1985, 'H', listaAsignaturas);
		estudiante2 = new Estudiante(14, "Alejandro","direccion1", 1986, 'H', listaAsignaturas);
		estudiante3 = new Estudiante(18, "Javier","direccion1", 1982, 'H', listaAsignaturas);
		
		profe1 = new Profesor(46, "Manolo", "direccion4", 1975, 'H', 1200);
		profe2 = new Profesor(45, "Nico", "direccion4", 1976, 'H', 1400);
		profe3 = new Profesor(47, "Jose", "direccion4", 1973, 'H', 2100);
		
		
		asignatura1 = new Asignatura("Programacion", 300, profe1);
		asignatura2 = new Asignatura("Programacion", 300, profe2);
		asignatura3 = new Asignatura("Programacion", 300, profe3);
		
		
		persona1 = new Persona(15, "Pedro","direccion1", 1985, 'H');
		persona2 = new Persona(23, "Miguel","direccion1", 1975, 'H');
		persona3 = new Persona(56, "Sabrina","direccion1", 1965, 'M');
		
		
		
		
		
		listaAsignaturas.add(asignatura1);
		listaAsignaturas.add(asignatura2);
		listaAsignaturas.add(asignatura3);
		
		listaEstudiantes.add(estudiante1);
		listaEstudiantes.add(estudiante2);
		//listaEstudiantes.add(estudiante3);
		
		
		listaProfesores.add(profe1);
		listaProfesores.add(profe2);
		listaProfesores.add(profe3);
		
		
		
		
		colegio = new Colegio(listaEstudiantes, listaProfesores, listaAsignaturas);
		
	}

	@Test
	public void obtienePrecioTotalMatriculaEstudianteTest() {
		
		assertEquals((int)900, (int)colegio.obtienePrecioTotalMatriculaEstudiante(estudiante1), 0.01);
		
	}

	
	@Test
	public void obtienePresupuestoColegioTest() {
		
		colegio.anadeEstudiante(estudiante3);
		
		assertEquals((int)7700, (int)colegio.obtienePresupuestoColegio(), 0.01);
		
	}
	
	@Test
	public void anadeEstudianteTest() {
		
		List<Estudiante> listaEstudiantes2 = new ArrayList<Estudiante>();
		
		listaEstudiantes2.add(estudiante1);
		listaEstudiantes2.add(estudiante2);
		listaEstudiantes2.add(estudiante3);
		
		assertTrue(colegio.anadeEstudiante(estudiante3));
		assertArrayEquals(listaEstudiantes2.toArray(), colegio.getListaEstudiantes().toArray());

	}

	@Test
	public void eliminaAsignaturaTest() {
		
		List<Asignatura> listaAsignaturas2 = new ArrayList<Asignatura>();
		
		listaAsignaturas2.add(asignatura1);
		//listaAsignaturas2.add(asignatura2);
		listaAsignaturas2.add(asignatura3);
		
		assertTrue(colegio.eliminaAsignatura(asignatura2));
		assertArrayEquals(listaAsignaturas2.toArray(), colegio.getListaAsignaturas().toArray());

	}

	@Test
	public void obtieneSueldoTotalProfesoresTest() {

		assertEquals(4700, colegio.obtieneSueldoTotalProfesores(), 0.01);

	}
	
	@Test(expected = Exception.class)
	public void obtienePresupuestoNetoColegioTest() throws ColegioExcepcion {
		
		
		colegio.anadeProfesor(profe2);
		colegio.anadeProfesor(profe3);

		System.out.println(colegio.obtienePresupuestoNetoColegio());

		
	}

}
