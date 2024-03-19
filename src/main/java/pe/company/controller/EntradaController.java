package pe.company.controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.jfree.util.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import pe.company.model.Entrada;
import pe.company.model.LineaPedido;
import pe.company.model.Producto;
import pe.company.repository.LineaPedidoRepository;
import pe.company.model.Entrada;
import pe.company.service.EntradaService;
import pe.company.service.ProductoService;

@RestController
@RequestMapping("/entradas")
public class EntradaController {

	private final Logger LOGGER = LoggerFactory.getLogger(EntradaController.class);

	public EntradaController() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	private EntradaService es;
	
	@Autowired
	private ProductoService ps;
	
	@Autowired
	private LineaPedidoRepository lps;
	@GetMapping("/listar")
	public ResponseEntity<?> obtenerTodos(){
		try {
			Collection<Entrada> entradas= es.findAll();
			
			return new ResponseEntity<>(entradas, HttpStatus.OK);
		} catch (Exception e) {
			Log.info(e.getMessage());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> obtenerPorId(@PathVariable("id") Integer id){
		try {
			Optional<Entrada> entrada= es.get(id);
			
			return new ResponseEntity<>(entrada.get(), HttpStatus.OK);
		} catch (Exception e) {
			Log.info(e.getMessage());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> guardar(@RequestPart(name = "entradas") String jsonEntrada){
		try {
			ObjectMapper mapper = new ObjectMapper();
			
			Entrada entradaGuardar = mapper.readValue(jsonEntrada, Entrada.class);
			
			es.save(entradaGuardar);
			
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			Log.info(e.getMessage());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@PutMapping("/editar/{id}")
	public ResponseEntity<?> editarEntrada(@PathVariable("id") Integer id, @RequestPart("entradas") String entradaJson){
		try {
			Optional<Entrada> entradaOp = es.get(id);
			
			LOGGER.info("Objecto Entrada {}", entradaOp.get());
			ObjectMapper mapper = new ObjectMapper();
			Entrada entrada = mapper.readValue(entradaJson, Entrada.class);
			
			entradaOp.get().setUbicacion(entrada.getUbicacion() == "" ? entradaOp.get().getUbicacion() : entrada.getUbicacion());
			
			if(entrada.getEstado().equals("Recepcionado")) {
				//ejecutar storprocedure con parámetros del idproducto y cantidad
				//entradaOp debido a que capturo los datos que ya están en la db
				entradaOp.get().setEstado(entrada.getEstado());
				List<LineaPedido> lineaPedidos = lps.obtenerLineaPedidoByPedidoId(entradaOp.get().getPedidoEntrada().getId());
				
				lineaPedidos.stream().forEach(lpedido-> {
					ps.actualizarProductoEntrada(lpedido.getProductos().getId(), lpedido.getCantidad());
				});
			}
			
			es.update(entradaOp.get());
			
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.info(e.getMessage());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/listar-siguientes-5")
	public ResponseEntity<?> getEntradas5() {
		try {

			// model.addAttribute("bEntradas", es.findAll());
			List<Entrada> itemEntrada = es.obtenerPrimerosEntradas();
			return new ResponseEntity<>(itemEntrada, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}
	
	@GetMapping("/listar-siguientes-10")
	public ResponseEntity<?> getEntradas10() {
		try {

			// model.addAttribute("bEntradas", es.findAll());
			List<Entrada> itemEntrada = es.obtenerPrimerosEntradas10();
			return new ResponseEntity<>(itemEntrada, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}
	@GetMapping("/listar-siguientes-15")
	public ResponseEntity<?> getEntradas15() {
		try {

			// model.addAttribute("bEntradas", es.findAll());
			List<Entrada> itemEntrada = es.obtenerPrimerosEntradas15();
			return new ResponseEntity<>(itemEntrada, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}
	@GetMapping("/listar-siguientes-20")
	public ResponseEntity<?> getEntradas20() {
		try {

			// model.addAttribute("bEntradas", es.findAll());
			List<Entrada> itemEntrada = es.obtenerPrimerosEntradas20();
			return new ResponseEntity<>(itemEntrada, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}
	@GetMapping("/listar-siguientes-25")
	public ResponseEntity<?> getEntradas25() {
		try {

			// model.addAttribute("bEntradas", es.findAll());
			List<Entrada> itemEntrada = es.obtenerPrimerosEntradas25();
			return new ResponseEntity<>(itemEntrada, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}
	@GetMapping("/listar-siguientes-30")
	public ResponseEntity<?> getEntradas30() {
		try {

			// model.addAttribute("bEntradas", es.findAll());
			List<Entrada> itemEntrada = es.obtenerPrimerosEntradas30();
			return new ResponseEntity<>(itemEntrada, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}
}
