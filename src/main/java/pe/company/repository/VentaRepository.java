package pe.company.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.company.model.DetalleVenta;
import pe.company.model.Venta;
import pe.company.model.Venta;

public interface VentaRepository extends JpaRepository<Venta, Integer> {
	
	/*
	@Query(value = "SELECT o.usuario_id,p.id 'Venta_id',o.id,o.total, o.fechaCreacion FROM detalles d Join ordenes o  On d.orden_id = o.id Join Ventas p On d.Venta_id = p.id where o.usuario_id = 3;", nativeQuery = true)
Optional<Venta> detallesUsuarioPorId(@Param("usuarioId") Integer usuarioId);*/


	
	
	@Query(nativeQuery = true, value = "SELECT * FROM Ventas LIMIT 5")
    List<Venta> obtenerPrimerosVentas();
	@Query(nativeQuery = true, value = "SELECT * FROM Ventas LIMIT 5 OFFSET 5")
    List<Venta> obtenerPrimerosVentas10();
	@Query(nativeQuery = true, value = "SELECT * FROM Ventas LIMIT 5 OFFSET 10")
    List<Venta> obtenerPrimerosVentas15();
	@Query(nativeQuery = true, value = "SELECT * FROM Ventas LIMIT 5 OFFSET 15")
    List<Venta> obtenerPrimerosVentas20();
	@Query(nativeQuery = true, value = "SELECT * FROM Ventas LIMIT 5 OFFSET 20")
    List<Venta> obtenerPrimerosVentas25();
	@Query(nativeQuery = true, value = "SELECT * FROM Ventas LIMIT 5 OFFSET 25")
    List<Venta> obtenerPrimerosVentas30();
}
