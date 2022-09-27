/*For this assignment, we will use four types of pokemon: Water, Fire, Grass and Normal.
    These types offer advantage for the pokemon’s attack and defence during battle. During
    attacks, the damage has a multiplier that can significantly increase or reduce the damage
    value.
    If the attacker has a type advantage, then the attack is super effective. However, if the target
    has the advantage, then the attack is not very effective.
    ● Super effective attacks cause double damage (damage * 2).
    ● “Not every effective” reduce the damage in half (damage * 0.5).
    ● Otherwise, the multiplier is the plain damage value (damage * 1).
    The resulting damage is always rounded down to the closest integer.
    Recommendations: Check the usage of Enums in Java. Find the right relationships between
    pokemon and the types, i.e., avoid coupling Pokemon and the type calculations.*/

public enum Type {
    WATER,
    FIRE,
    GRASS,
    NORMAL;

    int superEffective;
    int notVeryEffective;
    Type(int superEffective, int notVeryEffective) {
        this.superEffective = superEffective;
        this.notVeryEffective = notVeryEffective;
    }

    public class getType {
        Type type;

        public getType(Type type) {
            this.type = type;
        }

        public void calcTypeAttacks() {
            if (this.type == Type.WATER) {
                //If attacker's type is water AND target's type is fire
                //THEN attackPower = attackPower * 2

                //If attacker's type is water AND target's type is grass OR water
                //THEN attackPower = attackPower * 0.5

            /*Super effective against fire-type pokemon (damage * 2)
            Not very effective against grass- and other water-type pokemons (damage * 0.5)*/
            } else if (this.type == Type.FIRE) {
                //If attacker's type is fire AND target's type is grass
                //THEN attackPower = attackPower * 2

                //If attacker's type is fire AND target's type is water OR fire
                //THEN attackPower = attackPower * 0.5

            /*Super effective against grass-type pokemon (damage * 2)
            Not very effective against water- and other fire-type pokemons (damage * 0.5)*/
            } else if (this.type == Type.GRASS) {
                //If attacker's type is grass AND target's type is water
                //THEN attackPower = attackPower * 2

                //If attacker's type is grass AND target's type is fire OR grass
                //THEN attackPower = attackPower * 0.5

            /*Super effective against water-type pokemon (damage * 2)
            Not very effective against fire and other grass-type pokemons (damage * 0.5)*/
            } else {
            /*Normal-type pokemon do not have an advantage or disadvantage against any type. Their
            damage multiplier is always damage * 1.*/
            }
        }
    }
    }
