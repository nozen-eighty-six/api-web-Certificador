package pe.company.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.company.model.Venta;
import pe.company.repository.VentaRepository;

@Service
public class VentaServiceImpl  implements VentaService{

	@Autowired
	private VentaRepository vr;

	@PersistenceContext
    private EntityManager entityManager;
	@Override
	public void save(Venta venta) {
		vr.save(venta);
		
	}

	@Override
	public Optional<Venta> get(Integer id) {
		// TODO Auto-generated method stub
		return vr.findById(id);
	}

	@Override
	public void update(Venta Venta) {
		// TODO Auto-generated method stub
		vr.save(Venta);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		vr.deleteById(id);
	}

	@Override
	public List<Venta> findAll() {
		// TODO Auto-generated method stub
		return vr.findAll();
	}



	@Override
	public List<Venta> obtenerPrimerosVentas() {
		// TODO Auto-generated method stub
		return vr.obtenerPrimerosVentas();
	}

	@Override
	public List<Venta> obtenerPrimerosVentas10() {
		// TODO Auto-generated method stub
		return vr.obtenerPrimerosVentas10();
	}

	@Override
	public List<Venta> obtenerPrimerosVentas15() {
		// TODO Auto-generated method stub
		return vr.obtenerPrimerosVentas15();
	}

	@Override
	public List<Venta> obtenerPrimerosVentas20() {
		// TODO Auto-generated method stub
		return vr.obtenerPrimerosVentas20();
	}

	@Override
	public List<Venta> obtenerPrimerosVentas25() {
		// TODO Auto-generated method stub
		return vr.obtenerPrimerosVentas25();
	}

	@Override
	public List<Venta> obtenerPrimerosVentas30() {
		// TODO Auto-generated method stub
		return vr.obtenerPrimerosVentas30();
	}

	@Override
	public Integer obtenerUltimoId() {
		StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("obtenerUltimoIdVenta");
        storedProcedure.execute();
        return (Integer) storedProcedure.getOutputParameterValue("id_max");
	}
	


}
