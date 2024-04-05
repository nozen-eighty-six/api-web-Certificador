package pe.company.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.company.model.DetalleVenta;

@Repository
public interface DetalleVentaRepository  extends JpaRepository<DetalleVenta, Integer>{

	@Query(nativeQuery = true, value="select * from detalle_venta where venta_id = :id")
	List<DetalleVenta> obtenerDetalleVentaByVenta(@Param("id") Integer id);
}
