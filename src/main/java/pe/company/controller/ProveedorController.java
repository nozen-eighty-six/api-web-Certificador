package pe.company.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import pe.company.model.Marca;
import pe.company.model.Producto;
import pe.company.model.Proveedor;
import pe.company.service.ProveedorService;
@Controller
@RequestMapping("/proveedores")
public class ProveedorController {
	
	@Autowired
	private ProveedorService prs;
	private final Logger LOGGER = LoggerFactory.getLogger(ProveedorController.class);


	@GetMapping("/listar")
	public ResponseEntity<?> show(Model model) {
		try {

			//model.addAttribute("bProductos", prs.findAll());
			List<Proveedor> itemProveedor = prs.findAll();
			return new ResponseEntity<>(itemProveedor, HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
		 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/create")
	public String create() {
		
		return "proveedores/create";
	}
	

	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestPart(name = "proveedor") String proveedorJson, HttpSession session) throws IOException {

		// Convertir el JSON de producto a un objeto Producto
		ObjectMapper objectMapper = new ObjectMapper();
		Proveedor proveedor = objectMapper.readValue(proveedorJson, Proveedor.class);

		// Prueba
		LOGGER.info("Este es el objeto proveedor{}", proveedor);

		// Necesitamos un user
		/*
		 * Usuario u =
		 * us.findById(Integer.parseInt(session.getAttribute("idusuario").toString())).
		 * get();
		 * 
		 * //Guardamos Categoria.setUsuario(u);
		 * 
		 * //Imagen if(Categoria.getId() == null) { String nombreImagen =
		 * ups.saveImage(file); //Asignamos Categoria.setImagen(nombreImagen);
		 * 
		 * 
		 * }
		 */
		prs.save(proveedor);

		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/editar/{id}")
	public ResponseEntity<?>  edit(@PathVariable Integer id, @RequestPart(name = "proveedor") String proveedorJson,
			HttpSession session) throws IOException {
		try {

			// Producto producto = new Producto();
			// Optional<Producto> optionalProducto = prs.get(id);

			// Asignamos
			// producto = optionalProducto.get();

			// Deserealizamos la cadena a un objeto Producto
			ObjectMapper mapper = new ObjectMapper();
			Proveedor proveedorEdit = mapper.readValue(proveedorJson, Proveedor.class);

			// Probamos
			LOGGER.info("Proveedor buscado: {}", proveedorEdit);
			prs.update(proveedorEdit);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(HttpStatus.OK);
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<?> getProveedor(@PathVariable Integer id) {
		try {

			// model.addAttribute("bProductos", prs.findAll());
			Optional<Proveedor> proveedor = prs.get(id);
			return new ResponseEntity<>(proveedor.get(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/update")
	public String update(Proveedor Proveedor,@RequestParam("img") MultipartFile file) throws IOException {
		
		Proveedor m = new Proveedor();
		m=prs.get(Proveedor.getId()).get();
		

		prs.update(m);
		return "redirect:/proveedores";
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		
		//Capturo el objeto
		Proveedor m = new Proveedor();
		
		if(!prs.get(id).isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

			
		}
		m = prs.get(id).get();
		prs.delete(id);
		
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
}
