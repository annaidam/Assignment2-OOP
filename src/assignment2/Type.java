package assignment2;

public enum Type {
    NORMAL(0), FIRE(1), WATER(2), GRASS(3);

    final int pokemonIndex;

    Type(int index) {
        this.pokemonIndex = index;
    }
}