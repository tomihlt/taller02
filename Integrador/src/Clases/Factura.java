package Clases;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.lang.Exception;

public class Factura {

	static private Integer id = 0;
	private Integer id_instancia;
	private Double monto_total;
	private List<Bien> bienes;
	private Responsable responsable;
	private Proveedor proveedor;
	private Date fecha;
	
	public Factura() {

		bienes = new ArrayList<Bien>();

	}
	
	public Factura(Responsable responsable, Proveedor proveedor, Double monto_total) {
		
		this(responsable,proveedor);
		this.monto_total = monto_total;
		
	}
	
	public Factura(Responsable responsable, Proveedor proveedor) {

		this();
		id_instancia = id;
		id++;
		this.responsable = responsable;
		this.proveedor = proveedor;
		this.fecha = new Date();

	}

	public Date getFecha() {
		return fecha;
	}

	public Integer getId_instancia() {
		return id_instancia;
	}

	public List<Bien> getBienes() {
		return bienes;
	}

	public Double getMonto_total() {
		return monto_total;
	}

	public Responsable getResponsable() {
		return responsable;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	protected boolean mismaUbicacion() {

		if (responsable.getLocalidad().getId_instancia() == proveedor.getLocalidad().getId_instancia()
				& responsable.getLocalidad().getProvincia().getId_instancia() == proveedor.getLocalidad().getProvincia()
						.getId_instancia()
				& responsable.getLocalidad().getProvincia().getId_instancia() == proveedor.getLocalidad().getProvincia()
						.getId_instancia())
			return true;
		else
			return false;

	}

	protected boolean mismaProvincia() {

		if (responsable.getLocalidad().getProvincia().getId_instancia() == proveedor.getLocalidad().getProvincia()
				.getId_instancia()
				& responsable.getLocalidad().getProvincia().getPais().getId_instancia() == proveedor.getLocalidad()
						.getProvincia().getPais().getId_instancia())
			return true;
		else
			return false;

	}

	protected boolean mismoPais() {

		if (responsable.getLocalidad().getProvincia().getPais().getId_instancia() == proveedor.getLocalidad()
				.getProvincia().getPais().getId_instancia())
			return true;
		else
			return false;

	}

	public Double calcularMonto_total() throws Exception {

		Double aux = 0d;

		for (Bien i : bienes)
			aux += i.getPrecio();

		if (this.mismaUbicacion())
			aux *= 1.10;
		else if (this.mismaProvincia())
			aux *= 1.30;
		else if(this.mismoPais())
			aux *= 1.70;
		else
			throw new Exception("No son del mismo pais");

		aux = this.aplicarDescuento(aux);

		return aux;

	}

	private Double aplicarDescuento(Double d) {

		Integer size = bienes.size();
		Double aux = 0d;

		if (size > 10)
			aux -= (d * 0.20);
		else if (size > 5)
			aux -= (d * 0.10);

		return aux;

	}
	
	public void agregarBien(Bien b) throws Exception {
		
		if(bienes.size() >= 20)
			throw new Exception("No puede haber mas de 20 bienes");
		else
			bienes.add(b);
		
	}

}
