package Clases;

public class Localidad extends Ubicacion {
	
	private Provincia provincia;
	
	public Integer getId_instancia() {
		return super.getId_instancia();
	}
	
	public Localidad(String nombre, Provincia provincia) {
		
		super(nombre);
		this.provincia = provincia;
		
	}

	public Provincia getProvincia() {
		return provincia;
	}
	
	
	
}
