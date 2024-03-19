package pe.company.service;

import java.util.Optional;

import pe.company.model.DetalleOrden;

public interface DetalleOrdenService {

	public abstract DetalleOrden save(DetalleOrden dto);
	public Optional<DetalleOrden> findDetalleById(Integer ordenid);
}
