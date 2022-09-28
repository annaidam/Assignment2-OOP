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
    public int MAX_HP;
    private int currentHP;
    private int EP;
    public Type pokemonType;
    public Skill pokemonSkill;
    private boolean hasFainted = true;
    private boolean knowsSkill = false;

    public Pokemon targetPokemon;

    public Pokemon(String name, int MAX_HP, Type pokemonType) {
        this.name = name;
        this.MAX_HP = MAX_HP;
        this.EP = MAX_HP;
        if (EP > 100) {
            EP = 100;
        } else if (EP < 0) {
            EP = 0;
        }

        this.currentHP = MAX_HP;
        if (currentHP < 0) {
            currentHP = 0;
        } else if (currentHP > MAX_HP) {
            currentHP = MAX_HP;
        }
        this.pokemonType = pokemonType;
    }

    public int getEnergy() {
        return this.EP;
    }

    public int getCurrentHP() {
        return this.currentHP;
    }

    public String getName() {
        return this.name;
    }

    public Type getType() {
        return this.pokemonType;
    }

    public int getMAX_HP() {
        return this.MAX_HP;
    }

    /*Two pokemons are equal if they have the same name, type, skill, HP, MAX HP, and EP.
    When printed, the pokemon should return one of two options below:*/
    public boolean equals(Object anotherPokemon) {
        if (anotherPokemon == null) {
            return false;
        } else if (anotherPokemon instanceof Pokemon) {
            Pokemon otherPokemon = (Pokemon) anotherPokemon;
            if ((this.name.equals(otherPokemon.name)) &&
                    (this.pokemonType.equals(otherPokemon.pokemonType)) && (this.pokemonSkill.equals(otherPokemon.pokemonSkill) &&
                    (this.currentHP == otherPokemon.currentHP) && (this.MAX_HP == otherPokemon.MAX_HP) &&
                    (this.EP == otherPokemon.EP))) {
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
    public void learnSkill(String name, double attackPower, int energyCost) {
        this.pokemonSkill = new Skill(name, attackPower, energyCost);
    }

    public void forgetSkill() {
        this.pokemonSkill = null;
    }

    //Ask a pokemon whether it currently knows a skill and if it does replace it with a new skill
    /*public void knowsSkill(String name, double attackPower, int energyCost) {
        if (this.pokemonSkill != null) {
            this.pokemonSkill = new Skill(name, attackPower, energyCost);
        }
    }*/

    public boolean knowsSkill() {
        if (this.pokemonSkill != null)
            this.knowsSkill = true;
     else {
            this.knowsSkill = false;
            this.pokemonSkill = new Skill(name, pokemonSkill.getAttackPower(), pokemonSkill.getEnergyCost());
        }
        return knowsSkill;
    }
//In Java, you must declare a method of the boolean type in order for it to return a boolean value.
// The boolean method will return the boolean value, true or false.
// You can either return the variable containing a boolean value or
// use conditional statements to decide the returned value.

    //3.2  - Receive Damage and Rest:
    public void hasFainted() {
        this.hasFainted = true;
    }

    public void receiveDamage(double damageValue) {
        this.currentHP -= damageValue;
        if (this.currentHP <= 0) {
            this.currentHP = 0;
            if (!this.hasFainted) {
                hasFainted();
            }
        }
    }

    public void rest() {
        if ((!this.hasFainted) && (this.currentHP < this.MAX_HP)) {
            //If the pokemon has not fainted and the HP is lower than max HP, increase current HP by 20
            this.currentHP += 20;
            if (this.currentHP > this.MAX_HP) {
                this.currentHP = this.MAX_HP;
            }
        }
    }

    //3.3 - Spend and Recover Energy Points:
    public void spendEP(int EC) {
        if (this.EP >= EC) {
            this.EP -= EC;
        }
    }
    //A pokemon uses EP during battle
    //However, a pokemon can recover energy where a fixed amount of 25 EP is restored.
    //Restoring energy has no effect on a pokemon that has fainted.

    public void recoverEnergy() {
        //If pokemon has not fainted
        if (!this.hasFainted) {
            this.EP += 25;
        }
    }

    /*: If the pokemon has full HP before using the item:
    “<poke name> could not use <item name>. HP is already full.”
    2: If the pokemon recovers health when using the item:
    “<poke name> used <item name>. It healed <amount healed> HP.”*/
    public Item useItem(Item item) {
        if (this.getCurrentHP() == this.getMAX_HP()) {
            System.out.println(this.getName() + " could not use " + item.getItemName() + ". HP is already full.");
        } else {
            currentHP += item.getHealing_power();
            if (currentHP > MAX_HP) {
                currentHP = MAX_HP;
            }
            System.out.println(this.getName() + " used " + item.getItemName() + ". It healed "
                    + (this.getCurrentHP() - item.getHealing_power()) + "HP.");
        }
        return item;
    }
    //Task 5
    public void attack(Pokemon targetPokemon) {
        this.targetPokemon = targetPokemon;

        if (this.hasFainted) {
            System.out.println("Attack failed. " + getName() + " fainted.");
        } else if (this.targetPokemon.hasFainted) {
            System.out.println("Attack failed. " + targetPokemon.getName() + " fainted.");
        } else if (this.pokemonSkill == null) {
            System.out.println("Attack failed. " + getName() + "does not know a skill.");
        } else if (this.EP < this.pokemonSkill.getEnergyCost()) {
            System.out.println("Attack failed. " + getName() + "lacks energy:" + getEnergy()/pokemonSkill.getEnergyCost());
        } else {
            if ((this.getType() == Type.WATER && targetPokemon.getType() == Type.FIRE)
            | (this.getType() == Type.FIRE && targetPokemon.getType() == Type.GRASS)
            | (this.getType() == Type.GRASS && targetPokemon.getType() == Type.WATER)){
                receiveDamage(this.pokemonSkill.getAttackPower() * 2);
                System.out.println(getName() + " uses " + this.pokemonSkill.getSkillName() + " on " + targetPokemon.getName() +
                        ". It is super effective!\n" + targetPokemon.getName() + " has " + targetPokemon.getCurrentHP() + " HP left.");
            } else if ((targetPokemon.getType() == Type.WATER && this.getType() == Type.GRASS | this.getType() == Type.WATER)
            | (targetPokemon.getType() == Type.FIRE && this.getType() == Type.WATER | this.getType() == Type.FIRE)
            | (targetPokemon.getType() == Type.GRASS && this.getType() == Type.GRASS | this.getType() == Type.FIRE)) {
                receiveDamage((this.pokemonSkill.getAttackPower() * 0.5)%2f);
                System.out.println(getName() + " uses " + this.pokemonSkill.getSkillName() + " on " + targetPokemon.getName() +
                        ". It is not very effective...\n" + targetPokemon.getName() + " has " + targetPokemon.getCurrentHP() + " HP left.");
            } else {
                System.out.println(getName() + " uses " + this.pokemonSkill.getSkillName() + " on " + targetPokemon.getName() +
                        ".\n" + targetPokemon.getName() + " has " + targetPokemon.getCurrentHP() + " HP left.");
            }
            if (targetPokemon.hasFainted) {
                System.out.println(targetPokemon.getName() + "faints.");
            }
        }
    }
}
    //Task 5: Pokemon Battle
    //
    //Pokemon compete with each other in battles.
    // Each pokemon can attack another pokemon.
    // An attack can have different outcomes.
    // Be mindful to distinguish between the attacker and the defender (i.e., target) pokemon.
    //



//The attacking pokemon should return a message that describes the outcome of the attack.
// The message changes depending on which one of the cases below trigger:
//
//1: If the attacking pokemon is fainted, the message should be:
//"Attack failed. <attacker> fainted."
//
//2: If the target pokemon is fainted, the message should be:
//"Attack failed. <target> fainted."
//
//3: If the attacking pokemon does not know a skill, the message should be:
//"Attack failed. <attacker> does not know a skill."
//
//4: If the attacker knows a skill and has less energy points than the cost of the skill (ec):
//"Attack failed. <attacker> lacks energy: <ep>/<ec>"
//
//5: If the attacker has enough EP to use the assignment2.Skill, then the attack is successful.