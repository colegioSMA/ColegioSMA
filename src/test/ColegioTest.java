package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import sma.*;

public class ColegioTest {
	
	Asignatura asignatura1=null;
	Asignatura asignatura2=null;
	Asignatura asignatura3=null;
	
	Estudiante estudiante1=null;
	Estudiante estudiante2=null;
	
	Profesor profesor1=null;
	Profesor profesor2=null;
	Profesor profesor3=null;
	
	Colegio colegio=null;
	
	List<Asignatura> listaAsignaturas=null;
	List<Profesor> listaProfesores=null;
	List<Estudiante> listaEstudiantes=null;

	@Before
	public void setUp() throws Exception {
		
		profesor1=new Profesor(29, "Alberto", "c/Macarena", 1970, 'M', 1200.0f);
		profesor2=new Profesor(45, "Maria", "c/Valbuena", 1942, 'F', 1300.0f);
		profesor3=new Profesor(20, "Ricardo", "c/valle inclan", 1998, 'M', 5000.0f);
		
		asignatura1=new Asignatura("Programacion", 30.0f, profesor1);
		asignatura2=new Asignatura("BBDD", 20.0f, profesor2);		
		asignatura3=new Asignatura("SSII", 50.0f, profesor3);
		
		listaAsignaturas=new ArrayList<Asignatura>();
		listaAsignaturas.add(asignatura1);
		listaAsignaturas.add(asignatura2);
		listaAsignaturas.add(asignatura3);
		
		listaProfesores=new ArrayList<Profesor>();
		listaProfesores.add(profesor1);
		listaProfesores.add(profesor2);
		listaProfesores.add(profesor3);
		
		estudiante1=new Estudiante(18, "Sergio", "c/buendia", 2000, 'M', listaAsignaturas);
		estudiante2=new Estudiante(22, "Carlos", "c/murillo", 1996, 'M', listaAsignaturas);
		
		listaEstudiantes=new ArrayList<Estudiante>();
		listaEstudiantes.add(estudiante1);
		listaEstudiantes.add(estudiante2);
		
		colegio=new Colegio(listaEstudiantes, listaProfesores, listaAsignaturas);
	}

	@Test
	public void obtienePrecioTotalMatriculaEstudianteTest(){			
		//System.out.println(colegio.obtienePrecioTotalMatriculaEstudiante(estudiante1));
		assertEquals(100.0f, colegio.obtienePrecioTotalMatriculaEstudiante(estudiante1),0.01);		
	}	
	
	@Test
	public void obtienePresupuestoColegioTest() {
		//System.out.println( colegio.obtienePresupuestoColegio());
		assertEquals(5200.0f, colegio.obtienePresupuestoColegio(),0.01);
	}

	@Test
	public void anadeEstudianteTest() {
		
		Estudiante estudiante3=new Estudiante(20, "JuanCarlos", "c/calle", 1995, 'M', listaAsignaturas);
		List<Estudiante> listaAux=Arrays.asList(estudiante1,estudiante2,estudiante3);
		
		assertTrue(colegio.anadeEstudiante(estudiante3));
		assertArrayEquals(listaAux.toArray(), colegio.getListaEstudiantes().toArray());		
	}
	
	@Test
	public void eliminaAsignaturaTest() {
						
		List<Asignatura> listaAux=Arrays.asList(asignatura1,asignatura2);	
		
		assertTrue(colegio.eliminaAsignatura(asignatura3));
		assertArrayEquals(listaAux.toArray(), colegio.getListaAsignaturas().toArray());			
	}	
	
	@Test
	public void obtieneSueldoTotalProfesoresTest() {	
		//System.out.println( colegio.obtieneSueldoTotalProfesores());
		assertEquals(7500.0f, colegio.obtieneSueldoTotalProfesores(),0.01);		
	}
	
	
	@Test(expected = ColegioExcepcion.class)
	public void obtienePresupuestoNetoColegio() throws ColegioExcepcion  {
		
		colegio.obtienePresupuestoNetoColegio();
		
	}
	
	
	
}
