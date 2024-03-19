package pe.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.company.model.Usuario;
import java.util.List;
import java.util.Optional;



@Repository
public interface UsuarioRepository  extends JpaRepository<Usuario, Integer>{

	Optional<Usuario> findByMail(String mail);
}
