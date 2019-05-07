package sma;

public class Persona {

	private static int contador = 0;
	protected int identificador = 0;
	protected int edad;
	protected String nombre;
	protected String direccion;
	protected int anyoNacimiento;
	protected char genero;
	public Persona(int edad, String nombre, String direccion, int anyoNacimiento, char genero) {
		super();
		this.identificador = ++contador;
		this.edad = edad;
		this.nombre = nombre;
		this.direccion = direccion;
		this.anyoNacimiento = anyoNacimiento;
		this.genero = genero;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj instanceof Persona && 
				((Persona)obj).anyoNacimiento == this.anyoNacimiento &&
				((Persona)obj).direccion.equals(this.direccion) &&
				((Persona)obj).edad == this.edad &&
				((Persona)obj).genero == this.genero &&
				((Persona)obj).identificador == this.identificador &&
				((Persona)obj).nombre.equals(this.nombre)){
					return true;
				}
				return false;
	}

	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getAnyoNacimiento() {
		return anyoNacimiento;
	}

	public void setAnyoNacimiento(int anyoNacimiento) {
		this.anyoNacimiento = anyoNacimiento;
	}

	public char getGenero() {
		return genero;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}
	
	
}
