package Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Hospital.Paciente;

import java.util.*;
import SMA.Asignatura;
import SMA.Colegio;
import SMA.Estudiante;
import SMA.Profesor;

public class ColegioTest {
	Asignatura asignatura1=null;
	Asignatura asignatura2=null;
	Asignatura asignatura3=null;
	Profesor profesor1=null;
	Profesor profesor2=null;
	Profesor profesor3=null;
	Estudiante estudiante1=null;
	Estudiante estudiante2=null;
	Estudiante estudiante3=null;
	Colegio colegio1=null;
	List<Asignatura> listaAsignaturas=null;
	List<Estudiante> listaEstudiantes=null;
	List<Profesor> listaProfesor=null;


	
	@Before
	public void setUp() throws Exception {
		listaEstudiantes=new ArrayList<Estudiante>();
		listaProfesor=new ArrayList<Profesor>();
		listaAsignaturas=new ArrayList<Asignatura>();
		
		estudiante1= new Estudiante(20, "Jose", "Calle", 1952, 'H', listaAsignaturas);
		estudiante2= new Estudiante(20, "Juan", "Calle", 1922, 'H', listaAsignaturas);
		estudiante3= new Estudiante(20, "Sergio", "Calle", 1952, 'H', listaAsignaturas);
		
		profesor1= new Profesor(20, "Jose", "Calle", 1992, 'H', 1000);
		profesor2= new Profesor(30, "Sergio", "Calle", 1992, 'H', 1000);
		profesor3= new Profesor(40, "Juan","Calle", 1992, 'H', 1000);
		
		
		asignatura1= new Asignatura("Mates", 15, profesor1);
		asignatura1= new Asignatura("Mates", 30, profesor3);
		asignatura1= new Asignatura("Mates", 30, profesor2);
		listaAsignaturas.add(asignatura1);
		listaAsignaturas.add(asignatura2);
		listaAsignaturas.add(asignatura2);
		listaAsignaturas.add(asignatura3);
		
		listaEstudiantes.add(estudiante1);
		listaEstudiantes.add(estudiante2);
		//listaEstudiantes.add(estudiante3);
		
		
		listaProfesor.add(profesor1);
		listaProfesor.add(profesor2);
		listaProfesor.add(profesor3);
		colegio1= new Colegio(listaEstudiantes, listaProfesor, listaAsignaturas);
	}

	@Test
	public void testObtienePrecioTotalMatriculaEstudiante() {
		
	
	assertEquals(75.00F,colegio1.obtienePrecioTotalMatriculaEstudiante(estudiante1),0.01);
	
		
	}
	@Test
	public void testObtienePresupuestoColegio() {
		Colegio colegio1=null;
		colegio1.anadeEstudiante(estudiante1);
		assertEquals(5075F,colegio1.obtienePresupuestoColegio(),0.01);
		
	}
	@Test
	public void testAnadeEstudiante() {
		List<Estudiante> listaEstudiante=Arrays.asList(estudiante1, estudiante2, estudiante3); // utilizar cuando no pongas .add
		assertTrue(colegio1.anadeEstudiante(estudiante3));
		assertArrayEquals(listaEstudiante.toArray(), colegio1.getListaAsignaturas().toArray());
	}
	@Test
	public void testEliminaAsignatura() {
		List<Asignatura> listaAsignatura= Arrays.asList(asignatura1,asignatura2,asignatura3);
		assertTrue(colegio1.eliminaAsignatura(asignatura2));
		assertArrayEquals(listaAsignatura.toArray(), colegio1.getListaAsignaturas().toArray());
		
	}
	@Test(expected= Exception.class)
	public void TestObtienePresupuestoNetoColegio(){
		colegio1.anadeProfesor(profesor1);
		colegio1.anadeProfesor(profesor2);
		System.out.println(colegio1.obtienePresupuestoNetoColegio());
		
	}
	/*
	 * 
		public float obtienePresupuestoColegio() {

		float presupuesto = 0f;
		for (Estudiante estudiante : listaEstudiantes) {
			for (Asignatura asignatura : estudiante.getListaAsignaturas()) {
				presupuesto = presupuesto+asignatura.getPrecio();
			}
		}
		return PRESUPUESTO_INICIAL + presupuesto;
	 */

}
}
