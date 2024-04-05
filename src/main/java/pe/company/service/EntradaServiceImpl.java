package pe.company.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.company.model.Entrada;
import pe.company.repository.EntradaRepository;

@Service
public class EntradaServiceImpl implements EntradaService {

	@Autowired
	private EntradaRepository repository;
	@Override
	public Entrada save(Entrada entrada) {
		// TODO Auto-generated method stub
		return repository.save(entrada);
	}

	@Override
	public Optional<Entrada> get(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public void update(Entrada entrada) {
		// TODO Auto-generated method stub
		repository.save(entrada);
	}

	@Override
	public List<Entrada> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public List<Entrada> obtenerPrimerosEntradas() {
		// TODO Auto-generated method stub
		return repository.obtenerPrimerosEntradas();
	}

	@Override
	public List<Entrada> obtenerPrimerosEntradas10() {
		// TODO Auto-generated method stub
		return repository.obtenerPrimerosEntradas10();
	}

	@Override
	public List<Entrada> obtenerPrimerosEntradas15() {
		// TODO Auto-generated method stub
		return repository.obtenerPrimerosEntradas15();
	}

	@Override
	public List<Entrada> obtenerPrimerosEntradas20() {
		// TODO Auto-generated method stub
		return repository.obtenerPrimerosEntradas20();
	}

	@Override
	public List<Entrada> obtenerPrimerosEntradas25() {
		// TODO Auto-generated method stub
		return repository.obtenerPrimerosEntradas25();
	}

	@Override
	public List<Entrada> obtenerPrimerosEntradas30() {
		// TODO Auto-generated method stub
		return repository.obtenerPrimerosEntradas30();
	}

}
