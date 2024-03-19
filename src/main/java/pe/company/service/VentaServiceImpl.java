package pe.company.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.company.model.Venta;
import pe.company.repository.VentaRepository;

@Service
public class VentaServiceImpl  implements VentaService{

	@Autowired
	private VentaRepository vr;

	@Override
	public void save(Venta venta) {
		vr.save(venta);
		
	}
	


}
