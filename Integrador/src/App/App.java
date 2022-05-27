package App;

import java.util.ArrayList;
import java.util.List;

import Clases.*;
import Interfaces.*;

public class App {

	public static void main(String[] args) {
		
		
		//Paises
		Pais p1 = new Pais("Argentina");
		Pais p2 = new Pais("Chile");
		
		
		//Provincias
		Provincia prov1 = new Provincia("Santa Fe", p1);
		Provincia prov2 = new Provincia("Buenos Aires", p1);
		Provincia prov3 = new Provincia("Santiago", p2);
		Provincia prov4 = new Provincia("Maipo", p2);
		
		//Localidades
		Localidad l1 = new Localidad("Santa Fe", prov1);
		Localidad l2 = new Localidad("Tigre", prov2);
		Localidad l3 = new Localidad("Puente Alto", prov3);
		Localidad l4 = new Localidad("La Obra", prov4);
		
		//Responsables
		Responsable r1 = new Responsable("Juan", "Of1", l1);
		Responsable r2 = new Responsable("Jose", "Of2", l2);
		Responsable r3 = new Responsable("Mateo", "Of3", l3);
		Responsable r4 = new Responsable("Matias", "Of4", l4);
		
		//Proveedores
		Proveedor pv1 = new Proveedor("Lucas", l1);
		Proveedor pv2 = new Proveedor("Santiago", l2);
		Proveedor pv3 = new Proveedor("Lautaro", l3);
		Proveedor pv4 = new Proveedor("Ezequiel", l4);
		
		//Bienes
		Bien bien1 = new Bien("Bien1","Descripcion Bien 1",55000d,r1);
        Bien bien2 = new Bien("Bien2","Descripcion Bien 2",100d,r2);
        Bien bien3 = new Bien("Bien3","Descripcion Bien 3",85000d,r1);
        Bien bien4 = new Bien("Bien4","Descripcion bien 4",4d,r2);
        Bien bien5 = new Bien("Bien5","Descripcion bien 5",4d,r1);
        Bien bien6 = new Bien("FBien6","Descripcion bien 6",500d,r2);
        
        //Facturas
        Factura f1 = new Factura(r1, pv1,10000d);
//        Factura f2 = new Factura(r2,pv2);
//        Factura f3 = new Factura(r3,pv3);
        Factura f4 = new Factura(r1, pv2, 500d);
               
        //Agrego bienes
        try {
        	f1.agregarBien(bien1);
        	f1.agregarBien(bien2);
        	f1.agregarBien(bien3);
        	f4.agregarBien(bien1);
        	f4.agregarBien(bien2);
        	f4.agregarBien(bien3);
        }catch (Exception e) {
			// TODO: handle exception
        	System.out.println(e.getMessage());
		}
        
        //Empresa
        List<Proveedor> p = new ArrayList<Proveedor>();
        	p.add(pv1);
        	p.add(pv2);
        	p.add(pv3);
        	p.add(pv4);
        List<Bien> b = new ArrayList<Bien>();
        	b.add(bien1);
        	b.add(bien2);
        	b.add(bien3);
        	b.add(bien4);
        	b.add(bien5);
        	b.add(bien6);
        List<Factura> f = new ArrayList<Factura>();
        	f.add(f1);
        	f.add(f4);
        
        for(Factura x : f)
        	try {
        		x.calcularMonto_total();
        	}catch(Exception e) {
        		System.out.println(e.getMessage());
        	}
        	
        Empresa e1 = new Empresa(p,b,f);
        
        // Metodos test : 
        
//         listarFacturaByProveedor
        for(Factura i : e1.listarFacturaByProveedor(pv1))
        	System.out.println(i.getId_instancia());
        
//         listarFacturaByResponsable
        for(Factura i : e1.listarFacturaByResponsable(r1))
        	System.out.println(i.getId_instancia());
        
        // listarNombresProveedores()
        System.out.println(e1.listarNombresProveedores(l1));
        
        // listarBienesByLocalidad
        for( Bien i : e1.listarBienesByLocalidad(l1))
        	System.out.println(i.getAlias());
        
        // listarBienesByPrecioMayor
        for(Bien i : e1.listarBienesByPrecioMayor(5000d))
        	System.out.println(i.getAlias() + " "+ i.getPrecio());
        
        // listarFacturasByMontoMayor
        for(Factura i : e1.listarFacturasByMontoMayor(500d))
        	System.out.println(i.getId_instancia());
        
        // listarFactuadasPorProveedor
        System.out.println(e1.listarFactuadasPorProveedor(pv1));
		
	}

}
