package pe.company.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.company.model.Producto;

//Bean
@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{
	

	@Query(nativeQuery = true, value = "SELECT * FROM PRODUCTOS LIMIT 5")
    List<Producto> obtenerPrimerosProductos();
	@Query(nativeQuery = true, value = "SELECT * FROM PRODUCTOS LIMIT 5 OFFSET 5")
    List<Producto> obtenerPrimerosProductos10();
	@Query(nativeQuery = true, value = "SELECT * FROM PRODUCTOS LIMIT 5 OFFSET 10")
    List<Producto> obtenerPrimerosProductos15();
	@Query(nativeQuery = true, value = "SELECT * FROM PRODUCTOS LIMIT 5 OFFSET 15")
    List<Producto> obtenerPrimerosProductos20();
	@Query(nativeQuery = true, value = "SELECT * FROM PRODUCTOS LIMIT 5 OFFSET 20")
    List<Producto> obtenerPrimerosProductos25();
	@Query(nativeQuery = true, value = "SELECT * FROM PRODUCTOS LIMIT 5 OFFSET 25")
    List<Producto> obtenerPrimerosProductos30();

	@Query(nativeQuery = true, value = "select p.id, p.cantidad,p.descripcion, p.imagen ,p.nombre, p.precio, p.categoria_id, p.marca_id, p.usuario_id  from productos as p inner join productos_items_proveedor as ipp on p.id = ipp.items_producto_id where ipp.items_proveedor_id = :id")
    List<Producto> obtenerProductosByProveedor(@Param("id") Integer id);
	
	
	@Query(nativeQuery = true, value = "select p.id, p.cantidad,p.descripcion, p.imagen, p.nombre, p.precio, p.categoria_id, p.marca_id, p.usuario_id from productos as p inner join categorias as c ON p.categoria_id = c.id where c.nombre = 'Niño';")
	List<Producto> obtenerProductosByNinio();
	
	
	@Query(nativeQuery = true, value = "select p.id, p.cantidad, p.descripcion ,p.imagen, p.nombre, p.precio, p.categoria_id, p.marca_id, p.usuario_id  from productos as p inner join\n"
			+ "	categorias as c ON p.categoria_id = c.id where c.nombre = 'Hombre' LIMIT 6 OFFSET 26;")
	List<Producto> obtenerProductosByHombre();
	
	
	
	@Query(nativeQuery = true, value = "select p.id, p.cantidad, p.descripcion ,p.imagen, p.nombre, p.precio, p.categoria_id, p.marca_id, p.usuario_id  from productos as p inner join categorias as c ON p.categoria_id = c.id where c.nombre = 'Mujer' LIMIT 6 OFFSET 4;")
	List<Producto> obtenerProductosByMujer();
	
	
	@Query(nativeQuery = true, value = "select p.id, p.cantidad,p.descripcion, p.imagen, p.nombre, p.precio, p.categoria_id, p.marca_id, p.usuario_id from productos as p inner join categorias as c ON p.categoria_id = c.id where c.nombre = 'Bebes';")
	List<Producto> obtenerProductosByBebes();
	
	@Query(nativeQuery = true, value = "select p.id, p.cantidad,p.descripcion, p.imagen, p.nombre, p.precio, p.categoria_id, p.marca_id, p.usuario_id from productos as p inner join categorias as c ON p.categoria_id = c.id where c.nombre = 'Sport';")
	List<Producto> obtenerProductosBySport();
	
	@Query(nativeQuery = true, value = "select p.id, p.cantidad, p.descripcion,p.imagen, p.nombre, p.precio, p.categoria_id, p.marca_id, p.usuario_id from productos as p inner join categorias as c ON p.categoria_id = c.id where c.nombre = 'Accesorios';")
	List<Producto> obtenerProductosByAccesorio();
	
	
	@Query(nativeQuery = true, value = "select * from productos where (nombre like 'CAMISA%' or nombre like '%CAMISA%') AND categoria_id <> 4;")
	List<Producto> obtenerProductosByCamisa();
	
	@Query(nativeQuery = true, value = "select * from productos where nombre like 'POLO%' LIMIT 6;")
	List<Producto> obtenerProductosByPolo();
	
	
	@Query(nativeQuery = true, value = "select * from productos where nombre like 'GORRA%'")
	List<Producto> obtenerProductosByGorra();
	
	@Query(nativeQuery = true, value = "select * from productos where nombre like 'POLO%' LIMIT 6;")
	List<Producto> obtenerProductosByCasaca();
	
	@Query(nativeQuery = true, value = "select * from productos where nombre like 'ZAPATILLA%';\n")
	List<Producto> obtenerProductosByZapatilla();

}
