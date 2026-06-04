package Api;

import java.util.Scanner;

public class Main {
    public static void descPokemon(Pokemon p){
        System.out.println("ID: " + p.getId());
        System.out.println("Nombre: " + p.getName().toUpperCase());
        System.out.println("Altura: " + p.getHeight());
    }
    public static void statsBasePokemon(Pokemon p){
        System.out.println("\n --- BASE STATS ---");
        for (PokemonStat x : p.getStats()) {
            String nombre = x.getStat().getName();
            int valor = x.getBaseStat();
            System.out.println("- " + nombre.toUpperCase() + ": " + valor);
        }
    }
    public static void typePokemon(Pokemon p){
        System.out.println("\n --- TIPOS ---");
        for (PokemonType t : p.getTypes()){
            String nombre = t.getType().getName();
            System.out.println("- "+ nombre.toUpperCase());
        }
    }
    public static void llamarPokedex(Pokemon pokeEncontrado){
        System.out.println("=================================");
        System.out.println("¡DATOS MAPEADOS CON ÉXITO CON GSON!");
        System.out.println("=================================");
        descPokemon(pokeEncontrado); //Método para mostrar id, nombre y altura del pokémon.
        statsBasePokemon(pokeEncontrado); // stats base del pokémon escrito en el navegador.
        typePokemon(pokeEncontrado); // para el tipo del pokémon
        System.out.println("=================================");
    }
    public static void main(String[] args) {
        PokeApiService api= new PokeApiService();
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el nombre de un Pokémon (o 'salir'): ");
        String nomPokemon = sc.nextLine();
        while(!nomPokemon.equalsIgnoreCase("salir")){

            System.out.println("Buscando en la pokeAPI");
            Pokemon pokeEncontrado = api.obtenerPokemon(nomPokemon);

            if (pokeEncontrado != null) {
                llamarPokedex(pokeEncontrado); // Resume el print en una linea de codigo
            } else {
                System.out.println("No se pudo obtener la información del Pokémon.");
            }
            System.out.print("\nIntroduce otro nombre de Pokémon (o 'salir'): ");
            nomPokemon = sc.nextLine();
        }
        System.out.println("\n¡Gracias por usar la Pokédex! Cerrando conexión...");

    }
}
