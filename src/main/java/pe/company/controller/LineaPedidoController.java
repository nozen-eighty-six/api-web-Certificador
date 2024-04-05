package pe.company.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.mail.MessagingException;
import net.sf.jasperreports.engine.JRException;
import pe.company.model.Entrada;
import pe.company.model.LineaPedido;
import pe.company.model.Pedido;
import pe.company.model.Producto;
import pe.company.model.Proveedor;
import pe.company.repository.LineaPedidoRepository;
import pe.company.repository.ProveedorRepository;
import pe.company.service.EmailService;
import pe.company.service.EntradaService;
import pe.company.service.LineaPedidoService;
import pe.company.service.PedidoService;
import pe.company.service.ProductoService;

@RestController
@RequestMapping("/lineaP")
public class LineaPedidoController {
	private final Logger LOGGER = LoggerFactory.getLogger(LineaPedidoController.class);


	@Autowired
	private LineaPedidoService lps;
	
	@Autowired 
	private PedidoService ps;
	
	@Autowired
	private EntradaService es;
	
	@Autowired
	private ProductoService prs;
	@Autowired
	private LineaPedidoRepository repository;
	
	@Autowired
	private ProveedorRepository proR;
    @Autowired
    private EmailService emailService;
	

	public LineaPedidoController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> obtenerLineaPedidoByPedidoId(@PathVariable String id){
		
		List<LineaPedido> lineasPedido = lps.obtenerLineaPedidoByPedidoId(id);
		
		return new ResponseEntity<>(lineasPedido, HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> save(
	        @RequestPart(name = "lineapedido") String pedidoJson, HttpSession session) throws IOException {

	    // Convertir el JSON de producto a una lista de LineaPedido
	    ObjectMapper objectMapper = new ObjectMapper();
	    List<LineaPedido> pedidos = objectMapper.readValue(pedidoJson, new TypeReference<List<LineaPedido>>() {});

	    // Guardar todas las entidades en la lista usando saveAll
	    repository.saveAll(pedidos);
	    
	    List<LineaPedido> lineaPedidos = repository.lineaPedidoByPedido(pedidos.get(0).getPedido().getId());
	    //Actualizar el total del pedido
	    Optional<Pedido> pedido =  ps.get(pedidos.get(0).getPedido().getId());
	    Double totales = lineaPedidos.stream()
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
	    

	    return new ResponseEntity<>(HttpStatus.OK);
	}

    @GetMapping("/export-pdf/{id}")
    public ResponseEntity<byte[]> exportPdf(@PathVariable  String id) throws JRException, FileNotFoundException, IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("pedidosReport", "pedidosReport.pdf");
        return ResponseEntity.ok().headers(headers).body(lps.exportPdf(id));
    }

    
    @GetMapping("/enviar-pdf/{id}")
    public ResponseEntity<?> enviarCorreoConPDF(@PathVariable("id") String id) {
        // Ruta al archivo PDF que quieres enviar
        String pdfPath = "doc/pedidosReport.pdf";
        
        Optional<Pedido> pedido =  ps.get(id);
	    Optional<Proveedor> provee = proR.findById(pedido.get().getProveedor().getId());

        try {
            byte[] pdfBytes = Files.readAllBytes(Paths.get(pdfPath));
            emailService.sendEmail(provee.get().getCorreo(), "Pedido de comprar - Top Moda", "Enviamos los detalles del pedido", pdfBytes, "pedidos.pdf");
            return ResponseEntity.ok(null);
        } catch (IOException | MessagingException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);        }
    }
}
