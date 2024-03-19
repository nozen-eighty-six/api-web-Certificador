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

import pe.company.model.*;
import pe.company.service.*;

@Controller
@RequestMapping("/marcas")
public class MarcaController {

	private final Logger LOGGER = LoggerFactory.getLogger(ProductoController.class);

	// Inyección
	@Autowired
	private MarcaService prs;

	@Autowired
	private UsuarioService us;

	@Autowired
	private UploadFileService ups;

	@GetMapping("/listar")
	public ResponseEntity<?> show(Model model) {

		try {

			// model.addAttribute("bProductos", prs.findAll());
			List<Marca> itemMarca = prs.findAll();
			return new ResponseEntity<>(itemMarca, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/listar-siguientes-5")
	public ResponseEntity<?> getMarcas5() {
		try {

			// model.addAttribute("bProductos", prs.findAll());
			List<Marca> itemProducto = prs.obtenerPrimerosMarcas();
			return new ResponseEntity<>(itemProducto, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}
	
	@GetMapping("/listar-siguientes-10")
	public ResponseEntity<?> getMarcas10() {
		try {

			// model.addAttribute("bProductos", prs.findAll());
			List<Marca> itemProducto = prs.obtenerPrimerosMarcas10();
			return new ResponseEntity<>(itemProducto, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}
	@GetMapping("/listar-siguientes-15")
	public ResponseEntity<?> getMarcas15() {
		try {

			// model.addAttribute("bProductos", prs.findAll());
			List<Marca> itemProducto = prs.obtenerPrimerosMarcas15();
			return new ResponseEntity<>(itemProducto, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}
	@GetMapping("/listar-siguientes-20")
	public ResponseEntity<?> getMarcas20() {
		try {

			// model.addAttribute("bProductos", prs.findAll());
			List<Marca> itemProducto = prs.obtenerPrimerosMarcas20();
			return new ResponseEntity<>(itemProducto, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}
	@GetMapping("/listar-siguientes-25")
	public ResponseEntity<?> getMarcas25() {
		try {

			// model.addAttribute("bProductos", prs.findAll());
			List<Marca> itemProducto = prs.obtenerPrimerosMarcas25();
			return new ResponseEntity<>(itemProducto, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}
	@GetMapping("/listar-siguientes-30")
	public ResponseEntity<?> getMarcas30() {
		try {

			// model.addAttribute("bProductos", prs.findAll());
			List<Marca> itemProducto = prs.obtenerPrimerosMarcas30();
			return new ResponseEntity<>(itemProducto, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}


	@GetMapping("/create")
	public String create() {

		return "marcas/create";
	}

	@PostMapping("/save")
	public ResponseEntity<?>save(
			@RequestPart(name = "marca") String marcaJson, HttpSession session) throws IOException {

		// Convertir el JSON de producto a un objeto Producto
		ObjectMapper objectMapper = new ObjectMapper();
		Marca marca = objectMapper.readValue(marcaJson, Marca.class);

		// Prueba
		LOGGER.info("Este es el objeto producto{}", marca);

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
		prs.save(marca);

		return new ResponseEntity<>(HttpStatus.OK);
	}
/*
	@GetMapping("/editar/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		Marca marca = new Marca();
		Optional<Marca> optionalMarca = prs.get(id);

		// Asignamos
		marca = optionalMarca.get();

		// Probamos
		LOGGER.info("Producto buscado: {}", marca);

		// Enviamos el modelo con el objeto a editar
		model.addAttribute("marca", marca);

		return "marcas/edit";
	}*/
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getMarca(@PathVariable Integer id) {
		try {

			// model.addAttribute("bProductos", prs.findAll());
			Optional<Marca> marca = prs.get(id);
			return new ResponseEntity<>(marca.get(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/editar/{id}")
	public ResponseEntity<?> edit(@PathVariable Integer id, @RequestPart(name = "marca") String marcaJson,
			HttpSession session) throws IOException {
		try {

			// Producto producto = new Producto();
			// Optional<Producto> optionalProducto = prs.get(id);

			// Asignamos
			// producto = optionalProducto.get();

			// Deserealizamos la cadena a un objeto Producto
			ObjectMapper mapper = new ObjectMapper();
			Marca marcaEdit = mapper.readValue(marcaJson, Marca.class);

			// Probamos
			LOGGER.info("Categoria buscado: {}", marcaEdit);
			prs.update(marcaEdit);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("/update")
	public String update(Marca marca, @RequestParam("img") MultipartFile file) throws IOException {

		Marca m = new Marca();
		m = prs.get(marca.getId()).get();

		// Cuando editas otras propiedades, el parámetro file no recibe valor
		// Por tanto estará vacío al momento de la solicitud
		/*
		 * if(file.isEmpty()){
		 * 
		 * producto.setImagen(p.getImagen()); } else {
		 * 
		 * //Si no es diferente, que no me lo elimine de mi directorio
		 * if(!p.getImagen().equals("default.jpg")) { ups.deleteImage(p.getImagen());
		 * 
		 * }
		 * 
		 * String nombreImagen = ups.saveImage(file); //Asignamos
		 * producto.setImagen(nombreImagen);
		 * 
		 * } producto.setUsuario(p.getUsuario());
		 */
		prs.update(m);
		return "redirect:/marcas";
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {

		// Capturo el objeto
		Marca m = new Marca();
		

		if(!prs.get(id).isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
		m = prs.get(id).get();
		prs.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	
		

		
	}

}
