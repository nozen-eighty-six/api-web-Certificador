package pe.company.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import pe.company.model.Producto;

@Repository
public interface ProductoService {
	
	public abstract Producto save(Producto producto);
	public abstract Optional<Producto> get(Integer id);
	public abstract void update(Producto producto);
	public abstract void delete(Integer id);
	public abstract List<Producto> findAll();
	public abstract List<Producto> obtenerPrimerosProductos();
	public abstract List<Producto> obtenerPrimerosProductos10();
	public abstract List<Producto> obtenerPrimerosProductos15();
	public abstract List<Producto> obtenerPrimerosProductos20();
	public abstract List<Producto> obtenerPrimerosProductos25();
	public abstract List<Producto> obtenerPrimerosProductos30();
	
	public abstract   List<Producto> obtenerProductosByProveedor(Integer id);
	
	public abstract void actualizarProductoEntrada(Integer idProducto, Integer cantidadProducto);
	
	List<Producto> obtenerProductosByNinio();
	List<Producto> obtenerProductosByHombre();
	List<Producto> obtenerProductosByMujer();
	List<Producto> obtenerProductosByBebes();
	List<Producto> obtenerProductosBySport();
	List<Producto> obtenerProductosByAccesorio();
	List<Producto> obtenerProductosByCamisa();
	List<Producto> obtenerProductosByPolo();
	List<Producto> obtenerProductosByGorra();
	List<Producto> obtenerProductosByCasaca();
	List<Producto> obtenerProductosByZapatilla();
	
	
	/*Métodos dinámicos*/


}
