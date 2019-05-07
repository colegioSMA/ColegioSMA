package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.ArrayList;
import colecciones.ArrayList;
import colecciones.Colegio;
import colecciones.ColegioExcepcion;
import sma.Asignatura;
import sma.Estudiante;
import sma.Profesor;
import sma.Colegio;

public class Colegiotest {
	
	List<Asignatura> asignaturas=new ArrayList<>();
	List<Estudiante> estudiantes=new ArrayList<>();
	List<Profesor> profesores=new ArrayList<>();
	
	Colegio colegio=null;
	Asignatura asignatura1=null;
	Asignatura asignatura2=null;
	Asignatura asignatura3=null;
	Estudiante estudiante1=null;
	Estudiante estudiante2=null;
	Estudiante estudiante3=null;
	Profesor profesor1=null;
	Profesor profesor2=null;
	Profesor profesor3=null;
	Profesor profesor4=null;
	
	
	
	
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		colegio=new Colegio(estudiantes,profesores,asignaturas);
		
		profesor1=new Profesor(32,"ricardo","aluche",1970,'h',1200f);
		profesor2=new Profesor(37,"silvia","laguna",1999,'m',1400f);
		profesor3=new Profesor(33,"Sofia","carabanchel",1998,'m',1200f);
		
		profesores.add(profesor1);
		profesores.add(profesor2);
		profesores.add(profesor3);
		
		
		asignatura1 =new Asignatura("programacion",50f,profesor1);
		asignatura2 =new Asignatura("sql",50f,profesor2);
		asignatura3 =new Asignatura("sfol",50f,profesor3);
		
		asignaturas.add(asignatura1);
		asignaturas.add(asignatura2);
		asignaturas.add(asignatura3);
		
		
		estudiante1=new Estudiante(19,"marcos","valmojado",1999,'m',asignaturas);
		estudiante2=new Estudiante(20,"alvaro","nazaria",1989,'m',asignaturas);
		estudiante3=new Estudiante(23,"sergio","avenida america",1979,'m',asignaturas);
		 
		estudiantes.add(estudiante1);
		estudiantes.add(estudiante2);
		estudiantes.add(estudiante3);
		
		
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void obtienePrecioTotalMatriculaEstudiante(){
		
			assertEquals(150f,colegio.obtienePrecioTotalMatriculaEstudiante(estudiante1),0);
			
}
	
	@Test
	public void testpreciomatricula() {
		
		assertEquals(200f,colegio.obtienePrecioTotalMatriculaEstudiante(estudiante1), 0);
		
	}
	
	@Test
	public void obtiene_presupuesto_colegio() {
		
		assertEquals(5150f, colegio.obtienePresupuestoColegio(), 0);
	
		
	}
	
	@Test
	public void añade_estudiante() {
		
		List<Estudiante>listaAux=new ArrayList<>();
		listaAux.add(estudiante1);
		listaAux.add(estudiante2);
		
		colegio.anadeEstudiante(estudiante1);
		
		assertArrayEquals(estudiantes.toArray(),listaAux.toArray());
		
		
		
		
	}
	
	@Test(expected=ColegioExcepcion.class)
	public void obtieneresupuestoNetoColegio() throws ColegioExcepcion {
		
	profesor1.setSalario(400000000f);
	colegio.obtienePresupuestoNetoColegio();
	}
	
	
	@Test
	public void obtieneSueldoProfesores() {
		
		assertEquals(3800,colegio.obtieneSueldoTotalProfesores(),0);
		
		
	}
	
	@Test
	public void eliminaAsignatura() {
		
		assertTrue(colegio.eliminaAsignatura(asignatura2));
		
	}

		
	
	
	
	

	
	
}