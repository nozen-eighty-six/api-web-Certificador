package pe.company.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.company.model.DetalleVenta;
import pe.company.repository.DetalleVentaRepository;

@Service
public class DetalleVentaServiceImpl implements DetalleVentaService {
	
	@Autowired
	private DetalleVentaRepository repository;

	@Override
	public DetalleVenta save(DetalleVenta DetalleVenta) {
		// TODO Auto-generated method stub
		return repository.save(DetalleVenta);
	}

	@Override
	public Optional<DetalleVenta> get(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public void update(DetalleVenta DetalleVenta) {
		// TODO Auto-generated method stub
		repository.save(DetalleVenta);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public List<DetalleVenta> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public List<DetalleVenta> obtenerDetalleVentaByVenta(Integer id) {
		// TODO Auto-generated method stub
		return repository.obtenerDetalleVentaByVenta(id);
	}

}
