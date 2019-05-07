package test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

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
import sma.Profesor;

public class ColegioTest {
	Colegio colegio1=null;
	Estudiante estudiante1=null;
	Estudiante estudiante2=null;
	Estudiante estudiante3=null;
	Profesor profesor1=null;
	Profesor profesor2=null;
	Profesor profesor3=null;
	Asignatura asignatura1=null;
	Asignatura asignatura2=null;
	Asignatura asignatura3=null;
	List<Asignatura> listaasignaturas=new ArrayList<>();
	List<Estudiante> listaestudiantes=new ArrayList<>();
	List<Profesor> listaprofes=new ArrayList<>();
	
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		//int edad, String nombre, String direccion, int anyoNacimiento, char genero, float salario
		profesor1=new Profesor(35,"Esteban","calle 2",1986,'m',1300f);
		profesor2=new Profesor(35,"Maria","calle 3",1986,'m',1300f);
		profesor3=new Profesor(35,"Sofia","calle 2",1986,'m',1300f);
		//String nombre, float precio, Profesor profesor
		asignatura1 =new Asignatura("mate",100f,profesor1);
		asignatura2 =new Asignatura("historia",100f,profesor2);
		listaasignaturas.add(asignatura1);
		listaasignaturas.add(asignatura2);
		
		//int edad, String nombre, String direccion, int anyoNacimiento, char genero,List<Asignatura> listaAsignaturas
		estudiante1=new Estudiante(18,"david","calle",2001,'m',listaasignaturas);
		estudiante2=new Estudiante(15,"jorge","calle5",2004,'m',listaasignaturas);
		estudiante3=new Estudiante(15,"juana","calle5",2004,'m',listaasignaturas);
		listaestudiantes.add(estudiante1);
		listaestudiantes.add(estudiante2);
		listaprofes.add(profesor1);
		listaprofes.add(profesor2);
		colegio1=new Colegio(listaestudiantes,listaprofes,listaasignaturas);
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testpreciomatricula() {
		
		assertEquals(200f,colegio1.obtienePrecioTotalMatriculaEstudiante(estudiante1), 0);
		
	}
	@Test
	public void testobtienepresupuestocole() {
		//presupuesto = 5000 de inicio +200 por cada alumno y hay 2 alumnos = 5400
		assertEquals(5400f, colegio1.obtienePresupuestoColegio(), 0);
		
	}
	@Test
	public void testanadeEstudiante() {
		
		
		assertTrue(colegio1.anadeEstudiante(estudiante3));
		
		
		List<Estudiante>auxstudiantes= new ArrayList<>();
        auxstudiantes.add(estudiante1);
        auxstudiantes.add(estudiante2);
        auxstudiantes.add(estudiante3);
        assertArrayEquals(listaestudiantes.toArray(), auxstudiantes.toArray());
	}
	@Test
	public void testeliminaAsignatura() {
	assertTrue(colegio1.eliminaAsignatura(asignatura1));
	assertFalse(colegio1.eliminaAsignatura(asignatura1));
	}
	@Test
	public void testobtienesueldoprofes() {
	//sueldo profesor1=1300 + sueldo profesor2 = 1300 total 2600
		assertEquals(2600,colegio1.obtieneSueldoTotalProfesores() , 0);
	}
	@Test(expected=ColegioExcepcion.class)
	public void testobtienepresupuestonetoColegio() throws ColegioExcepcion {
	profesor1.setSalario(2000000f);
	colegio1.obtienePresupuestoNetoColegio();
	}

}
