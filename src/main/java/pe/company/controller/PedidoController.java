package pe.company.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;

import com.fasterxml.jackson.databind.ObjectMapper;

import pe.company.model.Marca;
import pe.company.model.Pedido;
import pe.company.model.Producto;
import pe.company.repository.PedidoRepository;
import pe.company.service.LineaPedidoService;
import pe.company.service.PedidoService;
import pe.company.service.ProveedorService;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {
	private final Logger LOGGER = LoggerFactory.getLogger(PedidoController.class);


	@Autowired
	private PedidoService prs;

	@Autowired
	private PedidoRepository pr;
	
	@Autowired
	private LineaPedidoService lps;
	@GetMapping("/listar")
	public ResponseEntity<?> show() {
		try {

			// model.addAttribute("bProductos", prs.findAll());
			List<Pedido> itemPedido = prs.findAll();
			return new ResponseEntity<>(itemPedido, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}
	
	@GetMapping("/create")
	public String create() {
		
		return "pedidos/create";
	}
	
	@PostMapping("/save")
	public ResponseEntity<?>save(
			@RequestPart(name = "pedido") String pedidoJson, HttpSession session) throws IOException {

		// Convertir el JSON de producto a un objeto Producto
		ObjectMapper objectMapper = new ObjectMapper();
		Pedido pedido = objectMapper.readValue(pedidoJson,Pedido.class);

		
		//lps.save(pedido)
		// Prueba
		LOGGER.info("Este es el objeto pedido{}",pedido);

		Integer id = prs.obtenerUltimoId();
		
		
		pedido.setId("PE"+(id+1));
		prs.save(pedido);

		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/ultimoid")
	public ResponseEntity<?> obtenerId() {
		
		Integer id = prs.obtenerUltimoId();
		
		return new ResponseEntity<>("PE"+(id+1), HttpStatus.OK);
	}
	
	@GetMapping("/listar-siguientes-5")
	public ResponseEntity<?> getPedidos5() {
		try {

			// model.addAttribute("bProductos", prs.findAll());
			List<Pedido> itemPedidos = prs.obtenerPrimerosPedidos();
			return new ResponseEntity<>(itemPedidos, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}
	
	@GetMapping("/listar-siguientes-10")
	public ResponseEntity<?> getPedidos10() {
		try {

			// model.addAttribute("bProductos", prs.findAll());
			List<Pedido> itemPedidos = prs.obtenerPrimerosPedidos10();
			return new ResponseEntity<>(itemPedidos, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}
	@GetMapping("/listar-siguientes-15")
	public ResponseEntity<?> getPedidos15() {
		try {

			// model.addAttribute("bProductos", prs.findAll());
			List<Pedido> itemPedidos = prs.obtenerPrimerosPedidos15();
			return new ResponseEntity<>(itemPedidos, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}
	@GetMapping("/listar-siguientes-20")
	public ResponseEntity<?> getPedidosS20() {
		try {

			// model.addAttribute("bProductos", prs.findAll());
			List<Pedido> itemPedidos = prs.obtenerPrimerosPedidos20();
			return new ResponseEntity<>(itemPedidos, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}
	@GetMapping("/listar-siguientes-25")
	public ResponseEntity<?> getPedidos25() {
		try {

			// model.addAttribute("bProductos", prs.findAll());
			List<Pedido> itemPedidos = prs.obtenerPrimerosPedidos25();
			return new ResponseEntity<>(itemPedidos, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}
	@GetMapping("/listar-siguientes-30")
	public ResponseEntity<?> getPedidos30() {
		try {

			// model.addAttribute("bProductos", prs.findAll());
			List<Pedido> itemPedidos = prs.obtenerPrimerosPedidos30();
			return new ResponseEntity<>(itemPedidos, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}
}
