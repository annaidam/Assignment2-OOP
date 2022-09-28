package assignment2;

public enum Type {
    WATER("Water"),
    FIRE("Fire"),
    GRASS("Grass"),
    NORMAL("Normal");

    final String pokemonType;

    Type(String pokemonType) {
        this.pokemonType = pokemonType;
    }
}