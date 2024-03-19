package pe.company.service;

import java.util.List;
import java.util.Optional;

import pe.company.model.Entrada;

public interface EntradaService {
	
	public abstract Entrada save(Entrada entrada);
	public abstract Optional<Entrada> get(Integer id);
	public abstract void update(Entrada entrada);
	//public abstract void delete(Integer id);
	public abstract List<Entrada> findAll();
	public abstract List<Entrada> obtenerPrimerosEntradas();
	public abstract List<Entrada> obtenerPrimerosEntradas10();
	public abstract List<Entrada> obtenerPrimerosEntradas15();
	public abstract List<Entrada> obtenerPrimerosEntradas20();
	public abstract List<Entrada> obtenerPrimerosEntradas25();
	public abstract List<Entrada> obtenerPrimerosEntradas30();

}
