package assignment2;

public enum Type {
    NORMAL(0), FIRE(1), WATER(2), GRASS(3);

    /*TRYING TASK 8
    NORMAL(0), BUG(1), DRAGON(2), ELECTRIC(3), FIRE(4), GRASS(5), ICE(6), WATER(7);
     */

    final int pokemonIndex;

    Type(int index) {
        this.pokemonIndex = index;
    }
}