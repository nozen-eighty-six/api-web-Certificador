package pe.company.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import pe.company.model.Venta;
import pe.company.service.VentaService;

@RestController
@RequestMapping("/ventas")
public class VentaController {
	
	@Autowired
	private VentaService prs;

	public VentaController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("/listar")
	public ResponseEntity<?> show() {
		try {

			// model.addAttribute("bProductos", prs.findAll());
			List<Venta> itemVenta = prs.findAll();
			return new ResponseEntity<>(itemVenta, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}
	
	@GetMapping("/create")
	public String create() {
		
		return "ventas/create";
	}
	
	@PostMapping("/save")
	public ResponseEntity<?>save(
			@RequestPart(name = "venta") String VentaJson, HttpSession session) throws IOException {

		// Convertir el JSON de producto a un objeto Producto
		ObjectMapper objectMapper = new ObjectMapper();
		Venta Venta = objectMapper.readValue(VentaJson,Venta.class);

		
		//lps.save(Venta)
		// Prueba
		//LOGGER.info("Este es el objeto Venta{}",Venta);

		//Integer id = prs.obtenerUltimoId();
		
		
		//Venta.setId("PE"+(id+1));
		prs.save(Venta);

		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/obtenerUltimoId")
	public ResponseEntity<?> obtenerUltimoId(){
		
		Integer id = prs.obtenerUltimoId();
		
		return new  ResponseEntity<>(id, HttpStatus.OK);
	}
	
	/*
	@GetMapping("/ultimoid")
	public ResponseEntity<?> obtenerId() {
		
		Integer id = prs.obtenerUltimoId();
		
		return new ResponseEntity<>("PE"+(id+1), HttpStatus.OK);
	}
	*/
	@GetMapping("/listar-siguientes-5")
	public ResponseEntity<?> getVentas5() {
		try {

			// model.addAttribute("bProductos", prs.findAll());
			List<Venta> itemVentas = prs.obtenerPrimerosVentas();
			return new ResponseEntity<>(itemVentas, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}
	
	@GetMapping("/listar-siguientes-10")
	public ResponseEntity<?> getVentas10() {
		try {

			// model.addAttribute("bProductos", prs.findAll());
			List<Venta> itemVentas = prs.obtenerPrimerosVentas10();
			return new ResponseEntity<>(itemVentas, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}
	@GetMapping("/listar-siguientes-15")
	public ResponseEntity<?> getVentas15() {
		try {

			// model.addAttribute("bProductos", prs.findAll());
			List<Venta> itemVentas = prs.obtenerPrimerosVentas15();
			return new ResponseEntity<>(itemVentas, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}
	@GetMapping("/listar-siguientes-20")
	public ResponseEntity<?> getVentasS20() {
		try {

			// model.addAttribute("bProductos", prs.findAll());
			List<Venta> itemVentas = prs.obtenerPrimerosVentas20();
			return new ResponseEntity<>(itemVentas, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}
	@GetMapping("/listar-siguientes-25")
	public ResponseEntity<?> getVentas25() {
		try {

			// model.addAttribute("bProductos", prs.findAll());
			List<Venta> itemVentas = prs.obtenerPrimerosVentas25();
			return new ResponseEntity<>(itemVentas, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}
	@GetMapping("/listar-siguientes-30")
	public ResponseEntity<?> getVentas30() {
		try {

			// model.addAttribute("bProductos", prs.findAll());
			List<Venta> itemVentas = prs.obtenerPrimerosVentas30();
			return new ResponseEntity<>(itemVentas, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}

}
