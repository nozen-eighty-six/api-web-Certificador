package pe.company.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.company.model.Pedido;
import pe.company.repository.PedidoRepository;

@Service
public class PedidoServiceImpl implements PedidoService {

	@Autowired
	private PedidoRepository repository;
	
	@PersistenceContext
    private EntityManager entityManager;
	@Override
	public Pedido save(Pedido pedido) {
		// TODO Auto-generated method stub
		return repository.save(pedido);
	}



	@Override
	public void update(Pedido pedido) {
		// TODO Auto-generated method stub
		repository.save(pedido);
	}


	@Override
	public List<Pedido> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}



	@Override
	public Optional<Pedido> get(String id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}



	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}



	@Override
	public Integer obtenerUltimoId() {
		StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("obtenerUltimoId");
        storedProcedure.execute();
        return (Integer) storedProcedure.getOutputParameterValue("max_id");
	}



	@Override
	public List<Pedido> obtenerPrimerosPedidos() {
		// TODO Auto-generated method stub
		return repository.obtenerPrimerosPedidos();
	}



	@Override
	public List<Pedido> obtenerPrimerosPedidos10() {
		// TODO Auto-generated method stub
		return repository.obtenerPrimerosPedidos10();
	}



	@Override
	public List<Pedido> obtenerPrimerosPedidos15() {
		// TODO Auto-generated method stub
		return repository.obtenerPrimerosPedidos15();
	}



	@Override
	public List<Pedido> obtenerPrimerosPedidos20() {
		// TODO Auto-generated method stub
		return repository.obtenerPrimerosPedidos20();
	}



	@Override
	public List<Pedido> obtenerPrimerosPedidos25() {
		// TODO Auto-generated method stub
		return repository.obtenerPrimerosPedidos25();
	}



	@Override
	public List<Pedido> obtenerPrimerosPedidos30() {
		// TODO Auto-generated method stub
		return repository.obtenerPrimerosPedidos30();
	}



}
