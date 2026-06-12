package Api;

// Importamos las herramientas de Spring Boot
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List; // Importación necesaria para manejar la lista de pokémons

@Controller // Comunica a SpringBoot que esta clase gestiona las rutas de la web.
public class PokemonController {

    private final PokeApiService apiService = new PokeApiService();

    // Esto mapea la raíz de la web: http://localhost:8080/
    @GetMapping("/")
    public String index(@RequestParam(name = "nombre", required = false) String nombre, Model model) {

        // El programa solo continuará si el usuario ha ingresado un nombre válido.
        if (nombre != null && !nombre.trim().isEmpty()) {

            Pokemon pokemonEncontrado = apiService.obtenerPokemon(nombre.toLowerCase().trim());

            if (pokemonEncontrado != null) {
                // METEMOS EL OBJETO EN LA MOCHILA con la etiqueta "pokemon"
                model.addAttribute("pokemon", pokemonEncontrado);
            } else {
                model.addAttribute("error", "¡Pokémon no encontrado en los archivos de la región!");
            }
        }

        else {
            try {
                // LLAMAMOS AL SERVICIO para traer una lista con los primeros 20 pokémons
                List<Pokemon> listaCompleta = apiService.obtenerPrimerosPokemons(20);

                // METEMOS LA COLECCIÓN EN LA MOCHILA con la etiqueta "listaPokemons" para el bucle del HTML
                model.addAttribute("listaPokemons", listaCompleta);
            } catch (Exception e) {
                model.addAttribute("error", "¡Fallo al conectar con la base de datos de la PokeApi!");
            }
        }

        // Ahora va a buscar la plantilla llamada pokedex.html -- fusiona los datos al thymeleaf -- thymeleaf se genera un HTML limpio
        return "pokedex";
    }
}