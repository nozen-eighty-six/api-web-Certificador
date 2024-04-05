package pe.company.service;

import java.util.List;
import java.util.Optional;

import pe.company.model.Venta;

public interface VentaService {
	public abstract void save (Venta venta);
	public abstract Optional<Venta> get(Integer id);
	public abstract void update(Venta Venta);
	public abstract void delete(Integer id);
	   public	Integer obtenerUltimoId();

	public abstract List<Venta> findAll();
   public abstract List<Venta> obtenerPrimerosVentas();
	public abstract List<Venta> obtenerPrimerosVentas10();
	public abstract List<Venta> obtenerPrimerosVentas15();
	public abstract List<Venta> obtenerPrimerosVentas20();
	public abstract List<Venta> obtenerPrimerosVentas25();
	public abstract List<Venta> obtenerPrimerosVentas30();
	

}
