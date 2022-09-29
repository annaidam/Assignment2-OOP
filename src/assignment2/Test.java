package assignment2;

public class Test {
    public static void main(String[] args) {
        // this all works
        Pokemon gyarados = new Pokemon("Gyarados", 100, "Water");
        gyarados.learnSkill("OP Hyper Beam", 100, 10); //Cheap EC so gyrados doesnt need to rest.

        Pokemon wigglytuff = new Pokemon("Wigglytuff", 120, "Normal");
        wigglytuff.learnSkill("Double Slap", 40, 28);

        System.out.println(gyarados.attack(wigglytuff)); //120 - 100 = 20.

        wigglytuff.attack(gyarados); //100 - 40 = 60
        String item = String.format(" heals " + gyarados.pokemonSkill.getAttackPower()%.2f);


        System.out.println(wigglytuff.getCurrentHP()); // expected 20
        System.out.println(gyarados.getCurrentHP()); // expected 60

//        assertEquals(120, wigglytuff.getMAX_HP());
//        assertEquals(20, wigglytuff.getCurrentHP());
//
//        assertEquals(100, gyarados.getMAX_HP());
//        assertEquals(60, gyarados.getCurrentHP());
    }
}
