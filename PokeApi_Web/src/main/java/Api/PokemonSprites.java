package Api;

import com.google.gson.annotations.SerializedName;

public class PokemonSprites {
    @SerializedName("front_default")
    private String frontDefault; // Sirve para guardar la URL en formato de texto

    public String getFrontDefault() { return frontDefault; }
}