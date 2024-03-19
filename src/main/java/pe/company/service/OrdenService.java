package pe.company.service;

import java.util.List;
import java.util.Optional;

import pe.company.model.Orden;
import pe.company.model.Usuario;

public interface OrdenService {

	public abstract Orden save(Orden orden);
	public abstract List<Orden> findAll();
	public abstract String getOrden();
	public abstract Optional<Orden> findById(Integer id);
	public abstract List<Orden> findByUsuario(Usuario usuario);
}
