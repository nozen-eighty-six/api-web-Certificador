package pe.company.repository;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

import pe.company.model.Orden;
import pe.company.model.Usuario;

@Configuration
public interface OrdenRepository extends JpaRepository<Orden, Integer>{

	List<Orden> findByUsuario(Usuario usuario);
}
