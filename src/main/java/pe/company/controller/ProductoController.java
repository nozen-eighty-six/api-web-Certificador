package pe.company.controller;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.jfree.util.Log;
import org.slf4j.*;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import pe.company.model.Producto;
import pe.company.model.Usuario;
import pe.company.service.CategoriaService;
import pe.company.service.MarcaService;
import pe.company.service.ProductoService;
import pe.company.service.UploadFileService;
import pe.company.service.UsuarioService;

@RestController
@RequestMapping("/productos")
public class ProductoController {

	private final Logger LOGGER = LoggerFactory.getLogger(ProductoController.class);

	// Inyección
	@Autowired
	private ProductoService prs;

	@Autowired
	private CategoriaService cs;
	@Autowired
	private MarcaService ms;

	@Autowired
	private UsuarioService us;

	@Autowired
	private UploadFileService ups;
	


	@GetMapping("/listar")
	public ResponseEntity<?> show() {
		try {

			// model.addAttribute("bProductos", prs.findAll());
			List<Producto> itemProducto = prs.findAll();
			return new ResponseEntity<>(itemProducto, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}

	@GetMapping("/listar-siguientes-5")
	public ResponseEntity<?> getProducts5() {
		try {

			// model.addAttribute("bProductos", prs.findAll());
			List<Producto> itemProducto = prs.obtenerPrimerosProductos();
			return new ResponseEntity<>(itemProducto, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}

	@GetMapping("/listar-siguientes-10")
	public ResponseEntity<?> getProductS10() {
		try {

			// model.addAttribute("bProductos", prs.findAll());
			List<Producto> itemProducto = prs.obtenerPrimerosProductos10();
			return new ResponseEntity<>(itemProducto, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}

	@GetMapping("/listar-siguientes-15")
	public ResponseEntity<?> getProductS15() {
		try {

			// model.addAttribute("bProductos", prs.findAll());
			List<Producto> itemProducto = prs.obtenerPrimerosProductos15();
			return new ResponseEntity<>(itemProducto, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}

	@GetMapping("/listar-siguientes-20")
	public ResponseEntity<?> getProductS20() {
		try {

			// model.addAttribute("bProductos", prs.findAll());
			List<Producto> itemProducto = prs.obtenerPrimerosProductos20();
			return new ResponseEntity<>(itemProducto, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}

	@GetMapping("/listar-siguientes-25")
	public ResponseEntity<?> getProductS25() {
		try {

			// model.addAttribute("bProductos", prs.findAll());
			List<Producto> itemProducto = prs.obtenerPrimerosProductos25();
			return new ResponseEntity<>(itemProducto, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}

	@GetMapping("/listar-siguientes-30")
	public ResponseEntity<?> getProductS30() {
		try {

			// model.addAttribute("bProductos", prs.findAll());
			List<Producto> itemProducto = prs.obtenerPrimerosProductos30();
			return new ResponseEntity<>(itemProducto, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getProductsByProveedor(@PathVariable("id") Integer id) {
		try {

			// model.addAttribute("bProductos", prs.findAll());
			List<Producto> itemProducto = prs.obtenerProductosByProveedor(id);
			return new ResponseEntity<>(itemProducto, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping("/modal")
	public String showModal(Model model) {
		Producto producto = new Producto();
		Optional<Producto> optionalProducto = prs.get(1);

		// Asignamos
		producto = optionalProducto.get();

		// Probamos
		LOGGER.info("Producto buscado: {}", producto);

		model.addAttribute("bMarcas", ms.findAll());
		LOGGER.info("marcas: {}", prs.findAll());
		model.addAttribute("bCategorias", cs.findAll());
		LOGGER.info("categorias: {}", prs.findAll());

		// Enviamos el modelo con el objeto a editar
		model.addAttribute("producto", producto);
		return "productos/create2";
	}

	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("bMarcas", ms.findAll());
		LOGGER.info("marcas: {}", prs.findAll());
		model.addAttribute("bCategorias", cs.findAll());
		LOGGER.info("categorias: {}", prs.findAll());
		return "productos/create";
	}

	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestPart(name = "img", required = false) MultipartFile file,
			@RequestPart(name = "producto") String productoJson, HttpSession session) throws IOException {

		// Convertir el JSON de producto a un objeto Producto
		ObjectMapper objectMapper = new ObjectMapper();
		Producto producto = objectMapper.readValue(productoJson, Producto.class);

		// Prueba
		LOGGER.info("Este es el objeto producto{}", producto);

		// Necesitamos un user
		// Usuario u =
		// us.findById(Integer.parseInt(session.getAttribute("idusuario").toString())).get();

		// Guardamos
		// producto.setUsuario(u);

		// Imagen
		if (producto.getId() == 0) {
			String nombreImagen = ups.saveImage(file);
			Log.info("Guardando imagen del producto");
			// Asignamos
			producto.setImagen(nombreImagen);

		}

		prs.save(producto);

		return new ResponseEntity<>(HttpStatus.OK);
		// return "redirect:/administrador/admin";
	}
	/*
	 * @GetMapping("/editar/{id}") public String edit(@PathVariable Integer id,
	 * Model model) { Producto producto = new Producto(); Optional<Producto>
	 * optionalProducto = prs.get(id);
	 * 
	 * //Asignamos producto = optionalProducto.get();
	 * 
	 * //Probamos LOGGER.info("Producto buscado: {}", producto);
	 * 
	 * model.addAttribute("bMarcas", ms.findAll()); LOGGER.info("marcas: {}",
	 * prs.findAll()); model.addAttribute("bCategorias", cs.findAll());
	 * LOGGER.info("categorias: {}", prs.findAll());
	 * 
	 * //Enviamos el modelo con el objeto a editar model.addAttribute("producto",
	 * producto);
	 * 
	 * return "productos/edit"; }
	 */

	@GetMapping("/get/{id}")
	public ResponseEntity<?> getProducto(@PathVariable Integer id) {
		try {

			// model.addAttribute("bProductos", prs.findAll());
			Optional<Producto> producto = prs.get(id);
			return new ResponseEntity<>(producto.get(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/editar/{id}")
	public ResponseEntity<?> edit(@PathVariable Integer id,
			@RequestPart(name = "img", required = false) MultipartFile file,
			@RequestPart(name = "producto") String productoJson, HttpSession session) throws IOException {
		try {

			Producto producto = new Producto();
			Optional<Producto> optionalProducto = prs.get(id);

			// Asignamos
			producto = optionalProducto.get();

			// Probamos
			LOGGER.info("Producto buscado: {}", producto);

			// Deserealizamos la cadena a un objeto Producto
			ObjectMapper mapper = new ObjectMapper();
			Producto productoEdit = mapper.readValue(productoJson, Producto.class);

			// model.addAttribute("bMarcas", ms.findAll());
			// LOGGER.info("marcas: {}", prs.findAll());
			// model.addAttribute("bCategorias", cs.findAll());
			// LOGGER.info("categorias: {}", prs.findAll());

			// Enviamos el modelo con el objeto a editar
			// model.addAttribute("producto", producto);

			// Guardamos la imagen actual para compararla con las que tenemos
			// || "default.jpg".equals(file.getOriginalFilename())
			if (file != null) {
				// No se ha seleccionado un archivo nuevo, o se seleccionó el archivo
				// predeterminado
				// No necesitas realizar ninguna acción o puedes hacer lo que sea necesario en
				// tu lógica
				String nombreImagen = ups.saveImage(file);
				productoEdit.setImagen(nombreImagen);
				prs.update(productoEdit);
			} else {
				// Se ha seleccionado un nuevo archivo, realiza las operaciones necesarias

				// ups.deleteImage(producto.getImagen());
				productoEdit.setImagen(producto.getImagen());
				prs.update(productoEdit);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("/update")
	public String update(Producto producto, @RequestParam("img") MultipartFile file) throws IOException {

		Producto p = new Producto();
		p = prs.get(producto.getId()).get();

		// Cuando editas otras propiedades, el parámetro file no recibe valor
		// Por tanto estará vacío al momento de la solicitud

		if (file.isEmpty()) {

			producto.setImagen(p.getImagen());
		} else {

			// Si no es diferente, que no me lo elimine de mi directorio
			if (!p.getImagen().equals("default.jpg")) {
				ups.deleteImage(p.getImagen());

			}

			String nombreImagen = ups.saveImage(file);
			// Asignamos
			producto.setImagen(nombreImagen);

		}
		producto.setUsuario(p.getUsuario());

		prs.update(producto);
		return "redirect:/productos";
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {

		// Capturo el objeto
		Producto p = new Producto();
		if (!prs.get(id).isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		p = prs.get(id).get();

		// Si no es diferente, que no me lo elimine de mi directorio
		if (!p.getImagen().equals("default.jpg")) {
			ups.deleteImage(p.getImagen());

		}

		prs.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);

	}

	@GetMapping("/show")
	public String showProductoAdmin(@PathVariable Integer id) {

		return "productos/show";
	}

	@GetMapping("/ninio")
	public ResponseEntity<?> obtenerProductosByNinio() {

		List<Producto> productosNinio = prs.obtenerProductosByNinio();

		return new ResponseEntity<>(productosNinio, HttpStatus.OK);
	};

	@GetMapping("/hombre")
	public ResponseEntity<?> obtenerProductosByHombre() {

		List<Producto> productosHombre = prs.obtenerProductosByHombre();

		return new ResponseEntity<>(productosHombre, HttpStatus.OK);
	};

	@GetMapping("/mujer")
	public ResponseEntity<?> obtenerProductosByMujer() {
		List<Producto> productosMujer = prs.obtenerProductosByMujer();

		return new ResponseEntity<>(productosMujer, HttpStatus.OK);
	};

	@GetMapping("/bebes")
	public ResponseEntity<?> obtenerProductosByBebes() {
		List<Producto> productosBebe = prs.obtenerProductosByBebes();

		return new ResponseEntity<>(productosBebe, HttpStatus.OK);

	};

	@GetMapping("/sport")
	public ResponseEntity<?> obtenerProductosBySport() {
		List<Producto> productosSport = prs.obtenerProductosBySport();

		return new ResponseEntity<>(productosSport, HttpStatus.OK);
	};

	@GetMapping("/accesorios")
	public ResponseEntity<?> obtenerProductosByAccesorio() {
		List<Producto> productosAccesorio = prs.obtenerProductosByAccesorio();

		return new ResponseEntity<>(productosAccesorio, HttpStatus.OK);
	};

	@GetMapping("/camisa")
	public ResponseEntity<?> obtenerProductosByCamisa() {
		List<Producto> productosCamisa = prs.obtenerProductosByCamisa();

		return new ResponseEntity<>(productosCamisa, HttpStatus.OK);
	};

	@GetMapping("/polo")
	public ResponseEntity<?> obtenerProductosByPolo() {
		List<Producto> productosPolo = prs.obtenerProductosByPolo();

		return new ResponseEntity<>(productosPolo, HttpStatus.OK);
	};

	@GetMapping("/gorra")
	public ResponseEntity<?> obtenerProductosByGorra() {
		List<Producto> productosGorra = prs.obtenerProductosByGorra();

		return new ResponseEntity<>(productosGorra, HttpStatus.OK);
	};

	@GetMapping("/casaca")
	public ResponseEntity<?> obtenerProductosByCasaca() {
		List<Producto> productosCasaca = prs.obtenerProductosByCasaca();

		return new ResponseEntity<>(productosCasaca, HttpStatus.OK);
	};
	
	@GetMapping("/zapatilla")
	public ResponseEntity<?> obtenerProductosByZapatilla() {
		List<Producto> productosZapatilla = prs.obtenerProductosByZapatilla();

		return new ResponseEntity<>(productosZapatilla, HttpStatus.OK);
	};
}
