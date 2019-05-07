package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import sma.Asignatura;
import sma.Colegio;
import sma.Estudiante;
import sma.Profesor;

public class ColegioTest {
	Colegio colegio;
	
	Estudiante estudiante1;
	Estudiante estudiante2;
	Estudiante estudiante3;
	Estudiante estudiante4;
	
	Asignatura asignatura1;
	Asignatura asignatura2;
	Asignatura asignatura3;
	
	Profesor profesor1;
	Profesor profesor2;
	Profesor profesor3;
	
	List<Estudiante> listaEstudiantes;
	List<Profesor> listaProfesores;
	List<Asignatura> listaAsignaturas;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		List<Estudiante> listaEstudiantes= new ArrayList<>();
		listaEstudiantes.add(estudiante1);
		listaEstudiantes.add(estudiante2);
		listaEstudiantes.add(estudiante3);
		
		List<Profesor> listaProfesores=Arrays.asList(profesor1, profesor2, profesor3);
		
		List<Asignatura> listaAsignaturas=Arrays.asList(asignatura1, asignatura2, asignatura3);
		
	
		asignatura1= new Asignatura("Programacion",50f,profesor1);
		asignatura2= new Asignatura("Sistemas Informáticos",50f,profesor2);
		asignatura3= new Asignatura("Fol",50f,profesor3);
		
		profesor1= new Profesor(30,"Jose","Calle Nazaria",1989,'H',1000f);
		profesor2= new Profesor(30,"Roberto","Calle Nazaria",1989,'H',1000f);
		profesor3= new Profesor(30,"Elena","Calle Nazaria",1989,'M',1000f);
		
		estudiante1=new Estudiante(19,"Pepe","Calle Carabanchel",2000,'H',listaAsignaturas);
		estudiante2=new Estudiante(19,"Julio","Calle Carabanchel",2000,'H',listaAsignaturas);
		estudiante3=new Estudiante(19,"Maria","Calle Carabanchel",2000,'M',listaAsignaturas);
		estudiante4=new Estudiante(19,"Eva","Calle Carabanchel",2000,'M',listaAsignaturas);
		
		colegio= new Colegio(listaEstudiantes, listaProfesores, listaAsignaturas);
	
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void obtienePrecioTotalMatriculaEstudianteTest() {
		assertEquals(150f, colegio.obtienePrecioTotalMatriculaEstudiante(estudiante1),0.01);
	}
	@Test
	public void obtienePresupuestoColegioTest() {
		assertEquals(5450f, colegio.obtienePresupuestoColegio(),0.01);
		
	}
	@Test
	public void anadeEstudianteTest() {
		List<Estudiante> listaAux=Arrays.asList(estudiante1,estudiante2, estudiante3, estudiante4);
		colegio.anadeEstudiante(estudiante4);
		assertArrayEquals(listaAux.toArray(), listaEstudiantes.toArray());
		
		
	}
	
	@Test
	public void eliminaAsignaturaTest() {
		List<Asignatura> listaAux=Arrays.asList(asignatura1,asignatura2);
		colegio.eliminaAsignatura(asignatura3);
		assertArrayEquals(listaAux.toArray(), listaAsignaturas.toArray());
		
	}

}
