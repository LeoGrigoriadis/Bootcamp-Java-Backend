package ejemplo.clase11_lecuta;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * BEAN: Clase simple de JAVAcque cumple
 * ciertas normas con sus propiedades y metodos.
 * Es un COMPONENTE que nos permite encapsular
 * el contenido con la finalidad de darle mejor estructura.
 * 
 * - Reutilizar código
 * - Mejor organización
 * 
 * Entities que pueden ser BEAN:
 * - Controller
 * - Service
 * - Component
 * - Repository
 * - Configuration
 */

@RestController
public class CancionController {
    //@RequestMapping(value  = "/cancion", method = RequestMethod.POST)
    @PostMapping("/cancion")
    public String mostrarNombreCancion() {
        return "hola";
    }
}