package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;

import sma.Colegio;
import sma.Asignatura;
import sma.Estudiante;
import sma.Profesor;
import org.junit.jupiter.api.Test;

class ColegioTestold {
Asignatura matematicas = null;
Asignatura lengua = null;

Profesor profesor1= null;
Profesor profesor2=null;

Estudiante estudiante1= null;
Estudiante estudiante2=null;

Colegio colegio = null;

List<Asignatura> asignaturas1 = new ArrayList<>();;
List<Estudiante> clase1 = new ArrayList<>();;
List<Profesor> profesores1 = new ArrayList<>();;



	@Before
	 public void  setUp() throws Exception{
		profesor1= new Profesor(23,"Juan","calle palmera",1969,'H',200f);
		profesor2= new Profesor(33,"Laura","calle no palmera",1996,'M',300f);
		
		matematicas = new Asignatura("matematicas", 500f, profesor1 );
		lengua = new Asignatura("lengua", 300f, profesor2 );
		
	
		asignaturas1.add(matematicas);
		asignaturas1.add(lengua);
		
		estudiante1 = new Estudiante(18,"Andres","calle de la roca",1999,'H',asignaturas1);
		estudiante2 = new Estudiante(34,"Juan","calle de la roca",1969,'H',asignaturas1);
		
		 
		clase1.add(estudiante1);
		
		
		profesores1.add(profesor1);
		profesores1.add(profesor2);
		
		colegio = new Colegio(clase1,profesores1,asignaturas1);		
		
	}
	
	
	
	@Test
	void obtienePrecioTotalMatriculaEstudianteTest()  {	
		
		assertEquals(800, colegio.obtienePrecioTotalMatriculaEstudiante(estudiante1));
		
	
	}
	
	
	@Test
	void obtienePresupuestoColegio()  {
		assertEquals(5800.00f, colegio.obtienePresupuestoColegio());
		
	}
	
	@Test
	void anadeEstudiante()  {
		List<Estudiante> estudianteaux = new ArrayList<>();
		estudianteaux.add(estudiante1);
		estudianteaux.add(estudiante2);
		colegio.anadeEstudiante(estudiante2);
		
		assertArrayEquals(estudianteaux.toArray(), colegio.getListaEstudiantes().toArray());
		assertTrue(colegio.getListaEstudiantes().contains(estudiante2));
	}
	
}



