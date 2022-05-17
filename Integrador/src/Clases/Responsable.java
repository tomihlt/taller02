package Clases;

import java.util.ArrayList;
import java.util.List;

public class Responsable extends Persona {
	
	private String oficina;
	private List<Factura> facturas;

	public String getNombre() {
		return super.getNombre();
	}
	public String getOficina() {
		return oficina;
	}
	public Localidad getLocalidad() {
		return super.getLocalidad();
	}
	public List<Factura> getFacturas() {
		return facturas;
	}
	
	public Responsable(String nombre, String oficina, Localidad localidad) {
		
		super(nombre,localidad);
		facturas = new ArrayList<Factura>();
		this.nombre = nombre;
		this.oficina = oficina;
		this.localidad = localidad;
		
	}
	
}
