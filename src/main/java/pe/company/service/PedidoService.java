package pe.company.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import pe.company.model.Pedido;
import pe.company.model.Pedido;

public interface PedidoService {

	public abstract Pedido save(Pedido pedido);
	public abstract Optional<Pedido> get(String id);
	public abstract void update(Pedido pedido);
	public abstract void delete(String id);
	public abstract List<Pedido> findAll();
   public	Integer obtenerUltimoId();
   public abstract List<Pedido> obtenerPrimerosPedidos();
	public abstract List<Pedido> obtenerPrimerosPedidos10();
	public abstract List<Pedido> obtenerPrimerosPedidos15();
	public abstract List<Pedido> obtenerPrimerosPedidos20();
	public abstract List<Pedido> obtenerPrimerosPedidos25();
	public abstract List<Pedido> obtenerPrimerosPedidos30();
}
