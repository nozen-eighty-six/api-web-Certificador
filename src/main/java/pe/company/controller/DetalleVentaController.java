package pe.company.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.sf.jasperreports.engine.JRException;
import pe.company.model.Entrada;
import pe.company.model.DetalleVenta;
import pe.company.model.Pedido;
import pe.company.model.Producto;
import pe.company.model.Proveedor;
import pe.company.repository.DetalleVentaRepository;
import pe.company.service.DetalleVentaService;
import pe.company.service.VentaService;

@RestController
@RequestMapping("/detalle-ventas")
public class DetalleVentaController {
	
	@Autowired
	private DetalleVentaRepository dv;

	@Autowired
	private VentaService vs;
	public DetalleVentaController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> obtenerDetallePorVenta(@PathVariable Integer id){
		
		List<DetalleVenta> detallesVenta = dv.obtenerDetalleVentaByVenta(id);
		
		return new ResponseEntity<>(detallesVenta, HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> save(
	        @RequestPart(name = "detalleventa") String detalleVentaJson, HttpSession session) throws IOException {

	    // Convertir el JSON de producto a una lista de DetalleVenta
	    ObjectMapper objectMapper = new ObjectMapper();
	    List<DetalleVenta> detallePedido = objectMapper.readValue(detalleVentaJson, new TypeReference<List<DetalleVenta>>() {});
	 
	    /*
	    Integer ultimaVenta = vs.obtenerUltimoId();
	    
	    detallePedido.forEach(dventa ->{
	    	dventa.
	    });*/

	    // Guardar todas las entidades en la lista usando saveAll
	    dv.saveAll(detallePedido);
	    /*
	    List<DetalleVenta> DetalleVentas = repository.DetalleVentaByPedido(pedidos.get(0).getPedido().getId());
	    //Actualizar el total del pedido
	    Optional<Pedido> pedido =  ps.get(pedidos.get(0).getPedido().getId());
	    Double totales = DetalleVentas.stream()
                .mapToDouble(pe -> 
                {
                	Optional<Producto>productoSelect = prs.get(pe.getProductos().getId());
                	return pe.getCantidad() * productoSelect.get().getPrecio();
                	
                })
                .sum();

	    pedido.get().setTotal(totales);

	    
	    // Prueba
	    LOGGER.info("Estos son los objetos pedidos: {}", pedidos);

	    ps.save(pedido.get());
	    
	    
	    Entrada entrada = new Entrada();
	    entrada.setUbicacion("Asignar ubicacion");
	    entrada.setEstado("NRecepcionado");
	    entrada.setPedidoEntrada(pedido.get());
	    es.save(entrada);
	    
*/
	    return new ResponseEntity<>(HttpStatus.OK);
	}



    

}
