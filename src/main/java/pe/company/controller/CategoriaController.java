package pe.company.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.jfree.util.Log;
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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import pe.company.model.Categoria;
import pe.company.model.Categoria;
import pe.company.model.Producto;
import pe.company.model.Categoria;
import pe.company.model.Usuario;
import pe.company.service.CategoriaService;
import pe.company.service.CategoriaService;
import pe.company.service.UploadFileService;
import pe.company.service.UsuarioService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	private final Logger LOGGER = LoggerFactory.getLogger(CategoriaController.class);

	// Inyección
	@Autowired
	private CategoriaService prs;

	@Autowired
	private UsuarioService us;

	@Autowired
	private UploadFileService ups;

	@GetMapping("/listar")
	public ResponseEntity<?> show(Model model) {

		return new ResponseEntity<>(prs.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/listar-siguientes-5")
	public ResponseEntity<?> getCategorias5() {
		try {

			// model.addAttribute("bProductos", prs.findAll());
			List<Categoria> itemProducto = prs.obtenerPrimerosCategorias();
			return new ResponseEntity<>(itemProducto, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}
	
	@GetMapping("/listar-siguientes-10")
	public ResponseEntity<?> getCategorias10() {
		try {

			// model.addAttribute("bProductos", prs.findAll());
			List<Categoria> itemProducto = prs.obtenerPrimerosCategorias10();
			return new ResponseEntity<>(itemProducto, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}
	@GetMapping("/listar-siguientes-15")
	public ResponseEntity<?> getCategorias15() {
		try {

			// model.addAttribute("bProductos", prs.findAll());
			List<Categoria> itemProducto = prs.obtenerPrimerosCategorias15();
			return new ResponseEntity<>(itemProducto, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}
	@GetMapping("/listar-siguientes-20")
	public ResponseEntity<?> getCategorias20() {
		try {

			// model.addAttribute("bProductos", prs.findAll());
			List<Categoria> itemProducto = prs.obtenerPrimerosCategorias20();
			return new ResponseEntity<>(itemProducto, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}
	@GetMapping("/listar-siguientes-25")
	public ResponseEntity<?> getCategorias25() {
		try {

			// model.addAttribute("bProductos", prs.findAll());
			List<Categoria> itemProducto = prs.obtenerPrimerosCategorias25();
			return new ResponseEntity<>(itemProducto, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}
	@GetMapping("/listar-siguientes-30")
	public ResponseEntity<?> getCategorias30() {
		try {

			// model.addAttribute("bProductos", prs.findAll());
			List<Categoria> itemProducto = prs.obtenerPrimerosCategorias30();
			return new ResponseEntity<>(itemProducto, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}

	@GetMapping("/create")
	public String create() {

		return "categorias/create";
	}

	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestPart(name = "categoria") String categoriaJson, HttpSession session)
			throws IOException {

		// Convertir el JSON de producto a un objeto Producto
		ObjectMapper objectMapper = new ObjectMapper();
		Categoria categoria = objectMapper.readValue(categoriaJson, Categoria.class);

		// Prueba
		LOGGER.info("Este es el objeto producto{}", categoria);

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
		prs.save(categoria);

		return new ResponseEntity<>(HttpStatus.OK);
	}
	/*
	 * 
	 * @GetMapping("/editar/{id}") public String edit(@PathVariable Integer id,
	 * Model model) { Categoria Categoria = new Categoria(); Optional<Categoria>
	 * optionalCategoria = prs.get(id);
	 * 
	 * //Asignamos Categoria = optionalCategoria.get();
	 * 
	 * //Probamos LOGGER.info("Categoria buscado: {}", Categoria);
	 * 
	 * //Enviamos el modelo con el objeto a editar model.addAttribute("categoria",
	 * Categoria);
	 * 
	 * return "categorias/edit"; }
	 */

	@GetMapping("/{id}")
	public ResponseEntity<?> getCategory(@PathVariable Integer id) {
		try {

			// model.addAttribute("bProductos", prs.findAll());
			Optional<Categoria> categoria = prs.get(id);
			return new ResponseEntity<>(categoria.get(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/editar/{id}")
	public ResponseEntity<?> edit(@PathVariable Integer id, @RequestPart(name = "categoria") String categoriaJson,
			HttpSession session) throws IOException {
		try {

			// Producto producto = new Producto();
			// Optional<Producto> optionalProducto = prs.get(id);

			// Asignamos
			// producto = optionalProducto.get();

			// Deserealizamos la cadena a un objeto Producto
			ObjectMapper mapper = new ObjectMapper();
			Categoria categoriaEdit = mapper.readValue(categoriaJson, Categoria.class);

			// Probamos
			LOGGER.info("Categoria buscado: {}", categoriaEdit);
			prs.update(categoriaEdit);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("/update")
	public String update(Categoria Categoria, @RequestParam("img") MultipartFile file) throws IOException {

		Categoria c = new Categoria();
		c = prs.get(Categoria.getId()).get();

		// Cuando editas otras propiedades, el parámetro file no recibe valor
		// Por tanto estará vacío al momento de la solicitud
		/*
		 * if(file.isEmpty()){
		 * 
		 * Categoria.setImagen(p.getImagen()); } else {
		 * 
		 * //Si no es diferente, que no me lo elimine de mi directorio
		 * if(!p.getImagen().equals("default.jpg")) { ups.deleteImage(p.getImagen());
		 * 
		 * }
		 * 
		 * String nombreImagen = ups.saveImage(file); //Asignamos
		 * Categoria.setImagen(nombreImagen);
		 * 
		 * } Categoria.setUsuario(p.getUsuario());
		 */
		prs.update(c);
		return "redirect:/categorias";
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {

		// Capturo el objeto
		Categoria p = new Categoria();
		

		if(!prs.get(id).isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
		p = prs.get(id).get();
		prs.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);

		
	}
}
