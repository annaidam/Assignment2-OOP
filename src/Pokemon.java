package assignment2;

public class Pokemon {
    /*Each pokemon has a name, a maximum health points (MAX HP), energy points (EP), a
    single skill (Task 2), and a type.

    A pokemon can be one of four types: Fire, Water, Grass and
    Normal. When created, the EP always starts at 100, and the pokemon does not know any
    skill. On the other hand, the name, MAX HP and type must be specified.

    Pokemon also have current health points (HP), which can change, but not their maximum
    health points (MAX HP). In fact, a pokemon’s current HP cannot be less than zero, or
    greater than its MAX HP. Similarly, EP can never be less than zero or greater than 100. When
    creating a Pokemon, its current HP and current EP are the same value as their corresponding
    maximum HP and EP. From now, we use HP to refer to the current HP and MAX HP to refer
    to the maximum health points.

    After creation, we can change the name of a pokemon but not its type or MAX HP. Also, we
    cannot set its HP and EP to a specific value. HP and EP can only be changed as a
    consequence of battling (details in Tasks below).*/

    public String name;
    public int maxHP;
    private int currentHP;
    private int EP;
    public Type pokemonType;
    public Skill pokemonSkill;
    private boolean hasFainted = true;

    public Pokemon(String name, int maxHP, Type pokemonType) {
        this.name = name;
        this.maxHP = maxHP;
        this.EP = maxHP;
        if (EP > 100) {
            EP = 100;
        } else if (EP < 0) {
            EP = 0;
        }
        this.currentHP = maxHP;
        if (currentHP < 0) {
            currentHP = 0;
        } else if (currentHP > maxHP) {
            currentHP = maxHP;
        }
        this.pokemonType = pokemonType;
    }

    public int getEnergy() {return this.EP;}
    public int getCurrentHP() {return this.currentHP;}
    public String getName() {return this.name;}
    public Type getType() {return this.pokemonType;}
    public int getMAX_HP() {return this.maxHP;}

    /*Two pokemons are equal if they have the same name, type, skill, HP, MAX HP, and EP.
    When printed, the pokemon should return one of two options below:*/
    public boolean equals(Object anotherPokemon) {
        if (anotherPokemon == null) {
            return false;
        } else if (anotherPokemon instanceof Pokemon) {
            Pokemon otherPokemon = (Pokemon) anotherPokemon;
            if ((this.name.equals(otherPokemon.name)) && (this.pokemonType.equals(otherPokemon.pokemonType)) && (this.pokemonSkill.equals(otherPokemon.pokemonSkill) && (this.currentHP == otherPokemon.currentHP) && (this.maxHP == otherPokemon.maxHP) && (this.EP == otherPokemon.EP))) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public String toString() {
        if (this.pokemonSkill == null) {
            String pokemon = this.getName() + " (" + this.getType() + ")";
            return pokemon;
        } else {
            String pokemon = this.getName() + " (" + this.getType() + "). Knows" + pokemonSkill;
            return pokemon;
        }
    }

    //3.1 - Learn and Forget Skills:
    public void learnSkill(String name, int attackPower, int energyCost) {
        this.pokemonSkill = new Skill(name, attackPower, energyCost);
    }

    public void forgetSkill() {
        this.pokemonSkill = null;
    }

    //Ask a pokemon whether it currently knows a skill and if it does replace it with a new skill
    public void knowsSkill(String name, int attackPower, int energyCost) {
        if (this.pokemonSkill != null) {
            this.pokemonSkill = new Skill(name, attackPower, energyCost);
        }
    }

    //3.2  - Receive Damage and Rest:
    public void hasFainted() {
        this.hasFainted = true;
    }

    public void receiveDamage(int damageValue) {
        this.currentHP -= damageValue;
        if (this.currentHP <= 0) {
            this.currentHP = 0;
            if (!this.hasFainted) {
                hasFainted();
            }
        }
    }

    public void rest() {
        if ((!this.hasFainted) && (this.currentHP < this.maxHP)) {
            //If the pokemon has not fainted and the HP is lower than max HP, increase current HP by 20
            this.currentHP += 20;
            if (this.currentHP > this.maxHP) {
                this.currentHP = this.maxHP;
            }
        }
    }

    //3.3 - Spend and Recover Energy Points:
    public void spendEP() {
        //A pokemon uses EP during battle
    }

    public void recoverEP() {
        //If pokemon has not fainted
        if (!this.hasFainted) {
            this.EP += 25;
        }
    }

    public void calcTypeAttacks() {
        while (this.pokemonType == Type.FIRE) {
            if (pokemonType == Type.GRASS) {
                receiveDamage(Type.FIRE.getSuperEffective());
            } else if (pokemonType == Type.FIRE | pokemonType == Type.WATER) {
                receiveDamage(Type.FIRE.getNotVeryEffective());
            }
        }
        if (this.pokemonType == Type.WATER && pokemonType == Type.FIRE) {
            //If attacker's type is water AND target's type is fire
            //THEN attackPower = attackPower * 2
            receiveDamage(Type.FIRE.getSuperEffective());
        } else if (this.pokemonType == Type.WATER && (pokemonType == Type.GRASS | pokemonType == Type.WATER)) {
            //If attacker's type is water AND target's type is grass OR water
            //THEN attackPower = attackPower * 0.5
            receiveDamage(damage * (1 / 2));
            //Super effective against fire-type pokemon (damage * 2)
            //Not very effective against grass- and other water-type pokemons (damage * 0.5)
        } else if (this.pokemonType == Type.FIRE && pokemonType == Type.GRASS) {
            //If attacker's type is fire AND target's type is grass
            //THEN attackPower = attackPower * 2
            receiveDamage(damage * 2);
        } else if (this.pokemonType == Type.FIRE && (pokemonType == Type.WATER | pokemonType == Type.FIRE)) {
            //If attacker's type is fire AND target's type is water OR fire
            //THEN attackPower = attackPower * 0.5
            receiveDamage(damage * (1 / 2));
            //Super effective against grass-type pokemon (damage * 2)
            //Not very effective against water- and other fire-type pokemons (damage * 0.5)
        } else if (this.pokemonType == Type.GRASS && pokemonType == Type.WATER) {
            //If attacker's type is grass AND target's type is water
            //THEN attackPower = attackPower * 2
            receiveDamage(damage * 2);
        } else if (this.pokemonType == Type.GRASS && (pokemonType == Type.FIRE | pokemonType == Type.GRASS)) {
            //If attacker's type is grass AND target's type is fire OR grass
            //THEN attackPower = attackPower * 0.5
            receiveDamage(damage * (1 / 2));
            //Super effective against water-type pokemon (damage * 2)
            //Not very effective against fire and other grass-type pokemons (damage * 0.5)
        } else {
            //Normal-type pokemon do not have an advantage or disadvantage against any type. Their
            //damage multiplier is always damage * 1.
            receiveDamage(damage * 1);
        }
    }
}