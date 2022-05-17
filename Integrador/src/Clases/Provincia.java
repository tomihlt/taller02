package Clases;

public class Provincia extends Ubicacion {
	
	private Pais pais;
	
	public Integer getId_instancia() {
		return id_instancia;
	}
	
	public Provincia(String nombre, Pais pais) {
		
		super(nombre);
		this.pais = pais;
		
	}

	public Pais getPais() {
		return pais;
	}
	
	
	
}
