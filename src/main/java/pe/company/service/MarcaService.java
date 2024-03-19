package pe.company.service;

import java.util.List;
import java.util.Optional;

import pe.company.model.Marca;
import pe.company.model.Marca;

public interface MarcaService {

	public abstract Marca save(Marca marca);
	public abstract Optional<Marca> get(Integer id);
	public abstract void update(Marca marca);
	public abstract void delete(Integer id);
	public abstract List<Marca> findAll();
	public abstract List<Marca> obtenerPrimerosMarcas();
	public abstract List<Marca> obtenerPrimerosMarcas10();
	public abstract List<Marca> obtenerPrimerosMarcas15();
	public abstract List<Marca> obtenerPrimerosMarcas20();
	public abstract List<Marca> obtenerPrimerosMarcas25();
	public abstract List<Marca> obtenerPrimerosMarcas30();
}
