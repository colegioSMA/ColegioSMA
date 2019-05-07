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
	List<Profesor> listaprofesores=new ArrayList<>();
	
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {

		profesor1=new Profesor(36,"Tyrion","calle 2",1986,'m',1300f);
		profesor2=new Profesor(36,"Cercei","calle 3",1986,'m',1300f);
		profesor3=new Profesor(36,"Kalessi","calle 2",1986,'m',1300f);
		
		
		asignatura1 =new Asignatura("PRG",100f,profesor1);
		asignatura2 =new Asignatura("ED",100f,profesor2);
		listaasignaturas.add(asignatura1);
		listaasignaturas.add(asignatura2);
		
		estudiante1=new Estudiante(18,"Pepe","calle",2002,'m',listaasignaturas);
		estudiante2=new Estudiante(16,"juan","calle2",2005,'m',listaasignaturas);
		estudiante3=new Estudiante(16,"María","calle3",2005,'m',listaasignaturas);
		listaestudiantes.add(estudiante1);
		listaestudiantes.add(estudiante2);
		listaprofesores.add(profesor1);
		listaprofesores.add(profesor2);
		colegio1=new Colegio(listaestudiantes,listaprofesores,listaasignaturas);
		
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
		assertEquals(5400f, colegio1.obtienePresupuestoColegio(), 0);
	}
	
	@Test
	public void testanadeEstudiante() {	
		
		assertTrue(colegio1.anadeEstudiante(estudiante3));
		
		List<Estudiante>auxestudiantes= new ArrayList<>();
        auxestudiantes.add(estudiante1);
        auxestudiantes.add(estudiante2);
        auxestudiantes.add(estudiante3);
        assertArrayEquals(listaestudiantes.toArray(), auxestudiantes.toArray());
	}
	@Test
	public void testeliminaAsignatura() {
	assertTrue(colegio1.eliminaAsignatura(asignatura1));
	assertFalse(colegio1.eliminaAsignatura(asignatura1));
	}
	@Test
	public void testobtienesueldoprofes() {
		assertEquals(2600,colegio1.obtieneSueldoTotalProfesores() , 0);
	}
	@Test(expected=ColegioExcepcion.class)
	public void testobtienepresupuestonetoColegio() throws ColegioExcepcion {
	profesor1.setSalario(2000000f);
	colegio1.obtienePresupuestoNetoColegio();
	}

}
