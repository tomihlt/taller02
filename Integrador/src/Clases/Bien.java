package Clases;

public class Bien {

	static private Integer id = 0;
	private Integer id_instancia;
	private String alias;
	private String descripcion;
	private Double precio;
	private Responsable responsable;

	public Bien(String alias, String descripcion, Double precio, Responsable responsable) {

		id_instancia = id;
		id++;
		this.alias = alias;
		this.descripcion = descripcion;
		this.precio = precio;
		this.responsable = responsable;

	}

	public static Integer getId() {
		return id;
	}

	public Integer getId_instancia() {
		return id_instancia;
	}

	public String getAlias() {
		return alias;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public Double getPrecio() {
		return precio;
	}

	public Responsable getResponsable() {
		return responsable;
	}

}
