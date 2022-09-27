package assignment2;

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

    private int superEffective;
    private int notVeryEffective;
    private int damageValue;
   Type() {
       superEffective = damageValue * 2;
       notVeryEffective = damageValue * (1/2);
    }

    public int getSuperEffective() {return superEffective;}

    public int getNotVeryEffective() {return notVeryEffective;}
}