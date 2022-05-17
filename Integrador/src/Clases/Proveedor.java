package Clases;

import java.util.ArrayList;
import java.util.List;

public class Proveedor extends Persona {
	
	private List<Bien> bienes;

	public String getNombre() {
		return super.getNombre();
	}
	public Localidad getLocalidad() {
		return super.getLocalidad();
	}
	public List<Bien> getBienes() {
		return bienes;
	}
	public Integer getId_instancia() {
		return super.getId_instancia();
	}
	
	public Proveedor(String nombre, Localidad localidad) {

		super(nombre,localidad);
		bienes = new ArrayList<Bien>();
		this.nombre = nombre;
		this.localidad = localidad;
		
	}
	
	
	
}
