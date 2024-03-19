package pe.company.service;

import java.util.List;
import java.util.Optional;

import pe.company.model.Proveedor;

public interface ProveedorService {

	public abstract Proveedor save(Proveedor proveedor);
	public abstract Optional<Proveedor> get(Integer id);
	public abstract void update(Proveedor proveedor);
	public abstract void delete(Integer id);
	public abstract List<Proveedor> findAll();
}
