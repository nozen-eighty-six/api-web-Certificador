package pe.company.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.company.model.Marca;
import pe.company.repository.MarcaRepository;

@Service
public class MarcaServiceImpl implements MarcaService {

	
	@Autowired
	private MarcaRepository repository;

	@Override
	public Marca save(Marca marca) {
		// TODO Auto-generated method stub
		return repository.save(marca);
	}

	@Override
	public Optional<Marca> get(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public void update(Marca marca) {
		// TODO Auto-generated method stub
		repository.save(marca);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public List<Marca> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public List<Marca> obtenerPrimerosMarcas() {
		// TODO Auto-generated method stub
		return repository.obtenerPrimerosMarcas();
	}

	@Override
	public List<Marca> obtenerPrimerosMarcas10() {
		// TODO Auto-generated method stub
		return repository.obtenerPrimerosMarcas10();
	}

	@Override
	public List<Marca> obtenerPrimerosMarcas15() {
		// TODO Auto-generated method stub
		return repository.obtenerPrimerosMarcas15();
	}

	@Override
	public List<Marca> obtenerPrimerosMarcas20() {
		// TODO Auto-generated method stub
		return repository.obtenerPrimerosMarcas20();
	}

	@Override
	public List<Marca> obtenerPrimerosMarcas25() {
		// TODO Auto-generated method stub
		return repository.obtenerPrimerosMarcas25();
	}

	@Override
	public List<Marca> obtenerPrimerosMarcas30() {
		// TODO Auto-generated method stub
		return repository.obtenerPrimerosMarcas30();
	}
	
}
