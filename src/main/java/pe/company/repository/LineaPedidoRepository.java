package pe.company.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.company.model.LineaPedido;

@Repository
public interface LineaPedidoRepository extends JpaRepository<LineaPedido, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM lineas_pedido WHERE pedido_id = :id")
    List<LineaPedido> lineaPedidoByPedido(@Param("id") String id);
    

	@Query(nativeQuery = true, value = "SELECT * FROM lineas_pedido where pedido_id = :id")
	List<LineaPedido> obtenerLineaPedidoByPedidoId(@Param("id") String id);
}
