package pe.company.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.company.model.Categoria;
import pe.company.model.Categoria;

@Repository
public interface CategoriaRepository  extends JpaRepository<Categoria, Integer>{

	@Query(nativeQuery = true, value = "SELECT * FROM Categorias LIMIT 5")
    List<Categoria> obtenerPrimerosCategorias();
	@Query(nativeQuery = true, value = "SELECT * FROM Categorias LIMIT 5 OFFSET 5")
    List<Categoria> obtenerPrimerosCategorias10();
	@Query(nativeQuery = true, value = "SELECT * FROM Categorias LIMIT 5 OFFSET 10")
    List<Categoria> obtenerPrimerosCategorias15();
	@Query(nativeQuery = true, value = "SELECT * FROM Categorias LIMIT 5 OFFSET 15")
    List<Categoria> obtenerPrimerosCategorias20();
	@Query(nativeQuery = true, value = "SELECT * FROM Categorias LIMIT 5 OFFSET 20")
    List<Categoria> obtenerPrimerosCategorias25();
	@Query(nativeQuery = true, value = "SELECT * FROM Categorias LIMIT 5 OFFSET 25")
    List<Categoria> obtenerPrimerosCategorias30();
}
