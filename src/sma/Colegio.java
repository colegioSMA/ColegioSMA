package sma;

import java.util.List;

public class Colegio {

	private List<Estudiante> listaEstudiantes = null;
	private List<Profesor> listaProfesores = null;
	private List<Asignatura> listaAsignaturas = null;
	public static final int PRESUPUESTO_INICIAL = 5000;

	public Colegio(List<Estudiante> listaEstudiantes, List<Profesor> listaProfesores,
			List<Asignatura> listaAsignaturas) {
		super();
		this.listaEstudiantes = listaEstudiantes;
		this.listaProfesores = listaProfesores;
		this.listaAsignaturas = listaAsignaturas;
	}

	public float obtienePrecioTotalMatriculaEstudiante(Estudiante e) {
		float precioTotal = 0f;
		for (Asignatura asignatura : e.getListaAsignaturas()) {
			precioTotal = precioTotal +asignatura.getPrecio();
		}
		return precioTotal;
	}

	public float obtienePresupuestoColegio() {

		float presupuesto = 0f;
		for (Estudiante estudiante : listaEstudiantes) {
			for (Asignatura asignatura : estudiante.getListaAsignaturas()) {
				presupuesto = presupuesto +asignatura.getPrecio();
			}
		}
		return PRESUPUESTO_INICIAL + presupuesto;
	}

	public boolean eliminaEstudiante(Estudiante estudiante) {
		return listaEstudiantes.remove(estudiante);
	}

	public boolean anadeEstudiante(Estudiante estudiante) {
		return listaEstudiantes.add(estudiante);
	}
	public boolean eliminaProfesor(Profesor profesor) {
		return listaProfesores.remove(profesor);
	}

	public boolean anadeProfesor(Profesor profesor) {
		return listaProfesores.add(profesor);
	}
	public boolean eliminaAsignatura(Asignatura asignatura) {
		return listaAsignaturas.remove(asignatura);
	}

	public boolean anadeAsignatura(Asignatura asignatura) {
		return listaAsignaturas.add(asignatura);
	}
	public float obtieneSueldoTotalProfesores() {
		float sueldoTotal = 0f;

		for (Profesor profesor : listaProfesores) {

			sueldoTotal = sueldoTotal +profesor.getSalario();
		}
		return sueldoTotal;
	}

	public float obtienePresupuestoNetoColegio() throws ColegioExcepcion {
		float presupuestoTotalNeto = obtienePresupuestoColegio() - obtieneSueldoTotalProfesores();
		if (presupuestoTotalNeto < 0)
			throw new ColegioExcepcion("Presupuesto negativo");
		else
			return presupuestoTotalNeto;
	}

	public List<Estudiante> getListaEstudiantes() {
		return listaEstudiantes;
	}

	public void setListaEstudiantes(List<Estudiante> listaEstudiantes) {
		this.listaEstudiantes = listaEstudiantes;
	}

	public List<Profesor> getListaProfesores() {
		return listaProfesores;
	}

	public void setListaProfesores(List<Profesor> listaProfesores) {
		this.listaProfesores = listaProfesores;
	}

	public List<Asignatura> getListaAsignaturas() {
		return listaAsignaturas;
	}

	public void setListaAsignaturas(List<Asignatura> listaAsignaturas) {
		this.listaAsignaturas = listaAsignaturas;
	}

}
