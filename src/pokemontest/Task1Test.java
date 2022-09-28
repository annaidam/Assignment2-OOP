package pokemontest;

import assignment2.Pokemon;
import assignment2.Type;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Task1Test {

    @Test
    public void shouldCreateValidPokemon(){
        Pokemon charmander = new Pokemon("Charmander", 100, Type.FIRE);
        assertEquals(100, charmander.getEnergy());
        assertEquals(100, charmander.getCurrentHP());
        assertEquals("Charmander", charmander.getName());
        assertEquals("FIRE", charmander.getType());
        assertEquals("Charmander (FIRE)", charmander.toString());
        assertEquals(100, charmander.getMAX_HP());
        assertEquals(charmander.getCurrentHP(), charmander.getMAX_HP());

        Pokemon squirtle = new Pokemon("Squirtle", 120, Type.WATER);
        assertEquals(100, squirtle.getEnergy());
        assertEquals(120, squirtle.getCurrentHP());
        assertEquals("Squirtle", squirtle.getName());
        assertEquals("WATER", squirtle.getType());
        assertEquals("Squirtle (WATER)", squirtle.toString());
        assertEquals(120, squirtle.getMAX_HP());
        assertEquals(squirtle.getCurrentHP(), squirtle.getMAX_HP());
    }

    @Test
    public void shouldCheckEqualPokemons(){
        Pokemon exeggute1 = new Pokemon("Exeggcute", 95, Type.GRASS);
        Pokemon exeggute2 = new Pokemon("Exeggcute", 95, Type.GRASS);
        Pokemon ditto = new Pokemon("Exeggcute", 95, Type.NORMAL); // diff type.

        assertEquals(exeggute1, exeggute2); //If they both dont know a skill, they have equal skills.
        assertNotEquals(exeggute1, ditto);
    }


}

