package Api;

import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PokeApiService {
    // Este método recibirá el nombre del pokémon y nos devolverá el JSON en texto plano
    public Pokemon obtenerPokemon(String nombrePokemon) {

        String urlCompleta = "https://pokeapi.co/api/v2/pokemon/" + nombrePokemon.toLowerCase().trim();

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlCompleta))
                    .GET().build();//Genera la carta

            HttpClient client = HttpClient.newHttpClient(); //Es el cartero que envia y recibe la carta de retorno.

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString()); //Método para recibir todo el contenido en String del JSON

            // Involucrar GSON
            Gson gson = new Gson();

            Pokemon pokemonMapeado = gson.fromJson(response.body(), Pokemon.class);
            return pokemonMapeado;
        }
        catch (Exception e){
            System.out.println("Error detectado al conectar con la PokeAPI: "+ e.getMessage());
            return null;
        }
    }
}
