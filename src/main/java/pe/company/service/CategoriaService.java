package pe.company.service;

import java.util.List;
import java.util.Optional;

import pe.company.model.Categoria;
import pe.company.model.Categoria;

public interface CategoriaService {

	public abstract Categoria save(Categoria categoria);
	public abstract Optional<Categoria> get(Integer id);
	public abstract void update(Categoria categoria);
	public abstract void delete(Integer id);
	public abstract List<Categoria> findAll();
	public abstract List<Categoria> obtenerPrimerosCategorias();
	public abstract List<Categoria> obtenerPrimerosCategorias10();
	public abstract List<Categoria> obtenerPrimerosCategorias15();
	public abstract List<Categoria> obtenerPrimerosCategorias20();
	public abstract List<Categoria> obtenerPrimerosCategorias25();
	public abstract List<Categoria> obtenerPrimerosCategorias30();
}
