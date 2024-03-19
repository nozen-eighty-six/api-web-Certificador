package pe.company.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.company.model.Producto;
import pe.company.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {

	
	@Autowired
	private ProductoRepository pr;
	
	@PersistenceContext
    private EntityManager entityManager;
	
	@Override
	public Producto save(Producto producto) {
		// TODO Auto-generated method stub
		return pr.save(producto);
	}

	@Override
	public Optional<Producto> get(Integer id) {
		// TODO Auto-generated method stub
		return pr.findById(id);
	}

	@Override
	@Transactional
	public void update(Producto producto) {
		pr.save(producto);
		
	}

	@Override
	public void delete(Integer id) {
		pr.deleteById(id);
		
	}

	@Override
	public List<Producto> findAll() {
		// TODO Auto-generated method stub
		return pr.findAll();
	}

	@Override
	public List<Producto> obtenerPrimerosProductos() {
		// TODO Auto-generated method stub
		return pr.obtenerPrimerosProductos();
	}

	@Override
	public List<Producto> obtenerPrimerosProductos10() {
		// TODO Auto-generated method stub
		return pr.obtenerPrimerosProductos10();
	}

	@Override
	public List<Producto> obtenerPrimerosProductos15() {
		// TODO Auto-generated method stub
		return pr.obtenerPrimerosProductos15();
	}

	@Override
	public List<Producto> obtenerPrimerosProductos20() {
		// TODO Auto-generated method stub
		return pr.obtenerPrimerosProductos20();
	}

	@Override
	public List<Producto> obtenerPrimerosProductos25() {
		// TODO Auto-generated method stub
		return pr.obtenerPrimerosProductos25();
	}

	@Override
	public List<Producto> obtenerPrimerosProductos30() {
		// TODO Auto-generated method stub
		return pr.obtenerPrimerosProductos30();
	}

	@Override
	public List<Producto> obtenerProductosByProveedor(Integer id) {
		// TODO Auto-generated method stub
		return pr.obtenerProductosByProveedor(id);
	}

	@Override
	public void actualizarProductoEntrada(Integer idProducto, Integer cantidadProducto) {
		StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("sp_actualizarproducto");
		storedProcedure.setParameter("idproducto", idProducto);
	    storedProcedure.setParameter("cantidadproducto", cantidadProducto);
        storedProcedure.execute();
        
		
	}

}
