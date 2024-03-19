package pe.company.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.company.model.Orden;
import pe.company.model.Usuario;
import pe.company.service.OrdenService;
import pe.company.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	private final Logger log = LoggerFactory.getLogger(UsuarioController.class);
	
	@Autowired
	private UsuarioService us;
	
	@Autowired
	private OrdenService os;
	
	BCryptPasswordEncoder passEnconder = new  BCryptPasswordEncoder();
	
	@GetMapping("/registro")
	public String registro_GET() {
		
		return "usuario/registro";
	}
	
	@PostMapping("/save")
	public String save(Usuario usuario) {
		log.info("Usuario registro: {}", usuario);
		//Asignamos el tipo de usuario
		usuario.setTipo("USER");
		//Encriptamos la clave del usuario
		usuario.setPassword(passEnconder.encode(usuario.getPassword()));
		us.save(usuario);
		return "redirect:/";
	}
	
	@GetMapping("/login")
	public String login() {
		
		return "usuario/login2";
	}
	
	@GetMapping("/acceder")
	public String acceder(Usuario usuario, HttpSession session) {
		log.info("Acceso: {}", usuario);
		
		Optional<Usuario> user = us.findById(Integer.parseInt(session.getAttribute("idusuario").toString()));
		log.info("Usuario de db: {}", user.get());
		
		
		//Si está presente
		if(user.isPresent()) {
			log.info("Usuario presente");
			//Para usar el id en el resto de la aplicación
			session.setAttribute("idusuario", user.get().getId());
			
			//Valido el tipo
			if(user.get().getTipo().equals("USER")) {
				log.info("Redireccionando");
				return "redirect:/";
				
			}
			else {
				
				return "redirect:/administrador/admin";
			}
		}
		else {
			System.out.println("Usuario no encontrado");;
		}
		
		return "redirect:/";
		
	}
	
	@GetMapping("/compras")
	public String compraUsuario(Model model, HttpSession session) {
		//Usuario
		Usuario usari = new Usuario();
		usari = us.findById(Integer.parseInt(session.getAttribute("idusuario").toString())).get();
		
		List<Orden> ordenes = os.findByUsuario(usari);
		
		//Lista órdenes
		model.addAttribute("ordenes", ordenes);
		
		//Session
		model.addAttribute("sesion", session.getAttribute("idusuario"));
		return "usuario/compras";
	}
	
	@GetMapping("/detalle/{id}")
	public String detalle_compra(@PathVariable Integer id, HttpSession session, Model model) {
		log.info("Id de la orden: {}", id);
		
		Optional<Orden> orden = os.findById(id);
		//Orden
		model.addAttribute("detalles", orden.get().getDetalle());
		
		//Session
		model.addAttribute("sesion", session.getAttribute("idusuario"));
		
		return "usuario/detallecompra";
	}
	@GetMapping("/cerrar")
	public String cerrarSesion(HttpSession session) {
		log.info("Cerrando sesion");
		//log.info(session.getAttribute("idusuario").toString());
		session.removeAttribute("idusuario");
		
		return "redirect:/usuario/login";
	}
	

}
