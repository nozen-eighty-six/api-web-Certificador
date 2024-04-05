package pe.company.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import pe.company.model.DetalleVenta;

public interface DetalleVentaService {
	public abstract DetalleVenta save(DetalleVenta DetalleVenta);
	public abstract Optional<DetalleVenta> get(Integer id);
	public abstract void update(DetalleVenta DetalleVenta);
	public abstract void delete(Integer id);
	public abstract List<DetalleVenta> findAll();
	public abstract  List<DetalleVenta> obtenerDetalleVentaByVenta(Integer id);

   

}
