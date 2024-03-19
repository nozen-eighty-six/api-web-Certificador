package pe.company.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.company.model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, String> {

	
	//Este método @Procedure solo es usado para procedure que modifiquen directamente la base de datos
	@Procedure(name = "obtenerUltimoId")
    void obtenerUltimoId(@Param("max_id") Integer maxId);

	@Query(nativeQuery = true, value = "SELECT * FROM Pedidos order by CAST(SUBSTRING(id,3) AS UNSIGNED) LIMIT 5")
    List<Pedido> obtenerPrimerosPedidos();
	@Query(nativeQuery = true, value = "SELECT * FROM Pedidos order by CAST(SUBSTRING(id,3) AS UNSIGNED) LIMIT 5 OFFSET 5")
    List<Pedido> obtenerPrimerosPedidos10();
	@Query(nativeQuery = true, value = "SELECT * FROM Pedidos order by CAST(SUBSTRING(id,3) AS UNSIGNED) LIMIT 5 OFFSET 10")
    List<Pedido> obtenerPrimerosPedidos15();
	@Query(nativeQuery = true, value = "SELECT * FROM Pedidos order by CAST(SUBSTRING(id,3) AS UNSIGNED) LIMIT 5 OFFSET 15")
    List<Pedido> obtenerPrimerosPedidos20();
	@Query(nativeQuery = true, value = "SELECT * FROM Pedidos order by CAST(SUBSTRING(id,3) AS UNSIGNED) LIMIT 5 OFFSET 20")
    List<Pedido> obtenerPrimerosPedidos25();
	@Query(nativeQuery = true, value = "SELECT * FROM Pedidos order by CAST(SUBSTRING(id,3) AS UNSIGNED) LIMIT 5 OFFSET 25")
    List<Pedido> obtenerPrimerosPedidos30();

}
