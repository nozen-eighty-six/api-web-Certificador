package pe.company.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.company.model.Marca;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Integer> {

	@Query(nativeQuery = true, value = "SELECT * FROM Marcas LIMIT 5")
    List<Marca> obtenerPrimerosMarcas();
	@Query(nativeQuery = true, value = "SELECT * FROM Marcas LIMIT 5 OFFSET 5")
    List<Marca> obtenerPrimerosMarcas10();
	@Query(nativeQuery = true, value = "SELECT * FROM Marcas LIMIT 5 OFFSET 10")
    List<Marca> obtenerPrimerosMarcas15();
	@Query(nativeQuery = true, value = "SELECT * FROM Marcas LIMIT 5 OFFSET 15")
    List<Marca> obtenerPrimerosMarcas20();
	@Query(nativeQuery = true, value = "SELECT * FROM Marcas LIMIT 5 OFFSET 20")
    List<Marca> obtenerPrimerosMarcas25();
	@Query(nativeQuery = true, value = "SELECT * FROM Marcas LIMIT 5 OFFSET 25")
    List<Marca> obtenerPrimerosMarcas30();
}
