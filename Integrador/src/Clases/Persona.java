package Clases;

import java.util.Objects;

import Interfaces.CriterioBusqueda;

public abstract class Persona implements CriterioBusqueda<Persona> {

	static protected Integer id = 0;
	protected Integer id_instancia;
	protected String nombre;
	protected Localidad localidad;

	public Persona(String nombre, Localidad localidad) {

		id_instancia = id;
		id++;
		this.nombre = nombre;
		this.localidad = localidad;

	}

	public Integer getId_instancia() {
		return id_instancia;
	}

	public String getNombre() {
		return nombre;
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	public boolean esDeLocalidad(Localidad localidad) {

		if (this.localidad.equals(localidad) & this.localidad.getProvincia().equalsTo(localidad.getProvincia())
				& this.localidad.getProvincia().getPais().equalsTo(localidad.getProvincia().getPais()))
			return true;
		else
			return false;

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(id_instancia, other.id_instancia);
	}

}
