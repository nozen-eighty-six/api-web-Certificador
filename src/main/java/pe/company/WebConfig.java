package pe.company;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SuppressWarnings("deprecation")
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Este patrón permite CORS en todas las rutas
                .allowedOrigins(
                        "http://localhost:8080",
                        "http://127.0.0.1:5501",
                        "http://127.0.0.1:5500",
                        "http://192.168.20.8:8080" // Reemplaza con la dirección IP del emulador o dispositivo virtual
                )
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowCredentials(true);
    }
}
