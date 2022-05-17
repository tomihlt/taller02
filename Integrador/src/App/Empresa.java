package App;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import Clases.*;

public class Empresa {

	//private String nombre;
	//private List<Responsable> responsables;
	private List<Proveedor> proveedores;
	private List<Bien> bienes;
	private List<Factura> facturas;

	public Empresa() {
		//responsables = new ArrayList<Responsable>();
		proveedores = new ArrayList<Proveedor>();
		bienes = new ArrayList<Bien>();
		facturas = new ArrayList<Factura>();
	}
	
	public void calcularMontoTotalFacturas() {
		
		for(Factura f : facturas)
			try {
				f.calcularMonto_total();
			}catch(Exception e) {
				System.out.println("Factura id: "+ f.getId_instancia() + " " + e.getMessage());
			}
				
	}

	public ArrayList<Factura> listarFacturaByProveedor(Proveedor p) {

		Predicate<Factura> filtro = f -> f.getProveedor().equals(p);
		List<Factura> aux = facturas.stream().filter(filtro).collect(Collectors.toList());
		return new ArrayList<Factura>(aux);

	}

	public ArrayList<Factura> listarFacturaByResponsable(Responsable r) {

		Predicate<Factura> filtro = f -> f.getResponsable().equals(r);
		List<Factura> aux = facturas.stream().filter(filtro).collect(Collectors.toList());
		return new ArrayList<Factura>(aux);

	}

	public ArrayList<String> listarNombresProveedores(Localidad l) {

		Predicate<Proveedor> filtro = p -> p.esDeLocalidad(l);
		List<String> aux = proveedores.stream().filter(filtro).map(p -> p.getNombre()).sorted()
				.collect(Collectors.toList());
		return new ArrayList<String>(aux);

	}

	public ArrayList<Bien> listarBienesByLocalidad(Localidad l) {

		Predicate<Bien> filtro = b -> b.getResponsable().esDeLocalidad(l);
		List<Bien> aux = bienes.stream().filter(filtro).collect(Collectors.toList());
		return new ArrayList<Bien>(aux);

	}

	public ArrayList<Bien> listarBienesByPrecioMayor(Double precioMayor) {

		Predicate<Bien> filtro = b -> b.getPrecio() > precioMayor;
		List<Bien> aux = bienes.stream().filter(filtro).collect(Collectors.toList());
		return new ArrayList<Bien>(aux);

	}

	public ArrayList<Factura> listarFacturasByMontoMayor(Double montoMayor) {

		Predicate<Factura> filtro = f -> f.getMonto_total() > montoMayor;
		List<Factura> aux = facturas.stream().filter(filtro).collect(Collectors.toList());
		return new ArrayList<Factura>(aux);

	}

	public ArrayList<String> listarFactuadasPorProveedor(Proveedor p) {

		String format = "dd/MM/yyyy";
		DateFormat df = new SimpleDateFormat(format);

		Function<Factura, String> funcion = f -> "En la fecha " + df.format(f.getFecha()) + ", "
				+ f.getProveedor().getNombre() + " facturo con un total de $" + f.getMonto_total() + " con "
				+ f.getBienes().size() + " bienes.";

		Comparator<Factura> comparadorFechas = (f1, f2) -> f1.getFecha().compareTo(f2.getFecha());
		
		Predicate<Factura> filtro = f -> f.getProveedor().equals(p);

		List<String> aux = facturas.stream().filter(filtro).sorted(comparadorFechas).map(funcion).collect(Collectors.toList());
		return new ArrayList<String>(aux);

	}

}
