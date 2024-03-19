package pe.company.service;

import java.util.List;
import java.util.Optional;

import pe.company.model.Usuario;

public interface UsuarioService {

	
	public abstract Usuario save(Usuario Usuario);
	public abstract Optional<Usuario> findById(Integer id);
	public abstract void update(Usuario Usuario);
	public abstract void delete(Integer id);
	public abstract List<Usuario> findAll();
	public abstract Optional<Usuario> findByMail(String mail);
	
}
