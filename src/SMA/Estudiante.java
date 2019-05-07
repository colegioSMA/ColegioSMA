package SMA;

import java.util.List;

public class Estudiante extends Persona{

	private List<Asignatura> listaAsignaturas = null;

	public Estudiante(int edad, String nombre, String direccion, int anyoNacimiento, char genero,
			List<Asignatura> listaAsignaturas) {
		super(edad, nombre, direccion, anyoNacimiento, genero);
		this.listaAsignaturas = listaAsignaturas;
	}

	public List<Asignatura> getListaAsignaturas() {
		return listaAsignaturas;
	}

	public void setListaAsignaturas(List<Asignatura> listaAsignaturas) {
		this.listaAsignaturas = listaAsignaturas;
	}


	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj instanceof Estudiante && 
				super.equals(obj) &&
				((Estudiante)obj).getListaAsignaturas().equals(this.listaAsignaturas)){
					return true;
				}
				return false;
	}
	
	
}
