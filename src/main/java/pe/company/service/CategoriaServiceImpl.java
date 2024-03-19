package pe.company.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.company.model.Categoria;
import pe.company.repository.CategoriaRepository;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private CategoriaRepository repository;
	
	@Override
	public Categoria save(Categoria categoria) {
		// TODO Auto-generated method stub
		return repository.save(categoria);
	}

	@Override
	public Optional<Categoria> get(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public void update(Categoria categoria) {
		// TODO Auto-generated method stub
		repository.save(categoria);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public List<Categoria> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public List<Categoria> obtenerPrimerosCategorias() {
		// TODO Auto-generated method stub
		return repository.obtenerPrimerosCategorias();
	}

	@Override
	public List<Categoria> obtenerPrimerosCategorias10() {
		// TODO Auto-generated method stub
		return repository.obtenerPrimerosCategorias10();
	}

	@Override
	public List<Categoria> obtenerPrimerosCategorias15() {
		// TODO Auto-generated method stub
		return repository.obtenerPrimerosCategorias15();
	}

	@Override
	public List<Categoria> obtenerPrimerosCategorias20() {
		// TODO Auto-generated method stub
		return repository.obtenerPrimerosCategorias20();
	}

	@Override
	public List<Categoria> obtenerPrimerosCategorias25() {
		// TODO Auto-generated method stub
		return repository.obtenerPrimerosCategorias25();
	}

	@Override
	public List<Categoria> obtenerPrimerosCategorias30() {
		// TODO Auto-generated method stub
		return repository.obtenerPrimerosCategorias30();
	}

}
