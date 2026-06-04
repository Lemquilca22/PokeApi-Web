package Api;

import java.util.List;

public class Pokemon {
    private int id;
    private String name;
    private int height;
    private List<PokemonStat> stats;
    private List<PokemonType> types;
    private PokemonSprites sprites;

    public Pokemon(){
    }

    public int getId() { return id;
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public List<PokemonStat> getStats() {
        return stats;
    }

    public List<PokemonType> getTypes() {
        return types;
    }

    public PokemonSprites getSprites() {
        return sprites;
    }
}
