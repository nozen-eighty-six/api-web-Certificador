package pe.company.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.company.model.Entrada;
import pe.company.model.Entrada;

@Repository
public interface EntradaRepository  extends JpaRepository<Entrada, Integer>{
	
	@Query(nativeQuery = true, value = "SELECT * FROM Entradas LIMIT 5")
    List<Entrada> obtenerPrimerosEntradas();
	@Query(nativeQuery = true, value = "SELECT * FROM Entradas LIMIT 5 OFFSET 5")
    List<Entrada> obtenerPrimerosEntradas10();
	@Query(nativeQuery = true, value = "SELECT * FROM Entradas LIMIT 5 OFFSET 10")
    List<Entrada> obtenerPrimerosEntradas15();
	@Query(nativeQuery = true, value = "SELECT * FROM Entradas LIMIT 5 OFFSET 15")
    List<Entrada> obtenerPrimerosEntradas20();
	@Query(nativeQuery = true, value = "SELECT * FROM Entradas LIMIT 5 OFFSET 20")
    List<Entrada> obtenerPrimerosEntradas25();
	@Query(nativeQuery = true, value = "SELECT * FROM Entradas LIMIT 5 OFFSET 25")
    List<Entrada> obtenerPrimerosEntradas30();

}
