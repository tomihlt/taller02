package Clases;

import java.util.Objects;

public abstract class Ubicacion {
	
	static protected Integer id = 0;
	protected Integer id_instancia;
	protected String nombre;
	
	public Ubicacion(String nombre) {
		
		id_instancia = id;
		id++;
		this.nombre = nombre;
		
	}

	public static Integer getId() {
		return id;
	}

	public Integer getId_instancia() {
		return id_instancia;
	}

	public String getNombre() {
		return nombre;
	}

	public boolean equalsTo(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ubicacion other = (Ubicacion) obj;
		return Objects.equals(nombre, other.getNombre());
	}
	
	
	
}
