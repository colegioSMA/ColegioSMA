package test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import sma.Asignatura;
import sma.Colegio;
import sma.ColegioExcepcion;
import sma.Estudiante;
import sma.Profesor;

public class ColegioTest {
	
	Estudiante estudiante1 = null;
	Estudiante estudiante2 = null;
	Estudiante estudiante3 = null;
	Estudiante estudianteExtra = null;
	
	Asignatura asignatura1 = null;
	Asignatura asignatura2 = null;
	Asignatura asignatura3 = null;
	
	Profesor profesor1 = null;
	Profesor profesor2 = null;
	Profesor profesor3 = null;
	
	Colegio colegio1 = null;
	
	List<Asignatura> listaAsignaturas = null;
	List<Estudiante> listaEstudiantes = null;
	List<Profesor> listaProfesores = null;



	@Before
	public void setUp() throws Exception {
		
		profesor1 = new Profesor(34, "Juan", "Calle monsenior", 1981, 'M', 99999); 
		profesor2 = new Profesor(47, "Maria", "Callede la Luna", 1969, 'F', 899); 
		profesor3 = new Profesor(29, "Rosa", "Plaza de la Rosa", 1990, 'F', 1024); 
		
		listaProfesores = new ArrayList<>();
		listaProfesores.add(profesor1);
		listaProfesores.add(profesor2);
		listaProfesores.add(profesor3);
		
		asignatura1 = new Asignatura("Matematicas", 32, profesor1);
		asignatura2 = new Asignatura("Lengua", 29, profesor2);
		asignatura3 = new Asignatura("Ciencias Sociales", 41, profesor3);
		
		listaAsignaturas = new ArrayList<>();
		listaAsignaturas.add(asignatura1);
		listaAsignaturas.add(asignatura2);
		listaAsignaturas.add(asignatura3);
		
		estudiante1 = new Estudiante(16, "Jorge", "Calle de la santa", 2002, 'M',listaAsignaturas);
		estudiante2 = new Estudiante(16, "Marta", "Calle Romero", 2002, 'F',listaAsignaturas);
		estudiante3 = new Estudiante(16, "Julian", "Calle cima", 2002, 'M',listaAsignaturas);
		estudianteExtra = new Estudiante(16, "Julia", "Calle montaña", 2002, 'F',listaAsignaturas);
		
		listaEstudiantes = new ArrayList<>();
		listaEstudiantes.add(estudiante1);
		listaEstudiantes.add(estudiante2);
		listaEstudiantes.add(estudiante3);
		
		colegio1 = new Colegio(listaEstudiantes,  listaProfesores,listaAsignaturas);
			
	}



	
	//ApartadoA
	
	@Test
	public void obtienePrecioTotalMatriculaEstudianteTest() {

		assertEquals(102,colegio1.obtienePrecioTotalMatriculaEstudiante(estudiante1) );
		
	}
	
	//ApartadoB
	
	@Test
	public void obtienePresupuestoColegioTest() {
		
		
		assertEquals(5306, colegio1.obtienePresupuestoColegio());
	}
	
	//ApartadoC
	
	@Test
	public void anadeEstudianteTest() {
		
		List<Estudiante> listaAux = new ArrayList<>();
		listaAux.add(estudiante1);
		listaAux.add(estudiante2);
		listaAux.add(estudiante3);
		listaAux.add(estudianteExtra);
		
		colegio1.anadeEstudiante(estudianteExtra);
		
		assertArrayEquals(listaAux.toArray(), listaEstudiantes.toArray());
		assertTrue(colegio1.anadeEstudiante(estudianteExtra));
	}
	
	//ApartadoD
	
	@Test
	public void eliminaAsignatura(){
		
		List<Asignatura> listaAux1 = new ArrayList<>();
		listaAux1.add(asignatura1);
		listaAux1.add(asignatura2);
	
		colegio1.eliminaAsignatura(asignatura3);
		
		assertArrayEquals(listaAux1.toArray(), listaAsignaturas.toArray());
		assertTrue(colegio1.eliminaAsignatura(asignatura2));
		
		
	}
	
	//ApartadoE
	
	@Test
	public void obtieneSueldoTotalProfesoresTest() {
		
		assertEquals(101922, colegio1.obtieneSueldoTotalProfesores());
	}

	
	//ApartadoF
	
	@Test(expected = ColegioExcepcion.class)
	public void obtienePresupuestoNetoColegioTest() throws ColegioExcepcion {
		
		colegio1.obtienePresupuestoNetoColegio();
		
	}
	
}
