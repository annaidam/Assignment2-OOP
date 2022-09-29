package assignment2;

import org.w3c.dom.ls.LSOutput;

public class Pokemon {
    public String name;
    public int MAX_HP;
    private int currentHP;
    private int EP;
    public String pokemonType;
    public Skill pokemonSkill;
    private boolean hasFainted = true;
    private boolean knowsSkill = false;

    public Pokemon targetPokemon;

    public Pokemon(String name, int MAX_HP, String pokemonType) {
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

    public String getType() {
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
            if (!this.knowsSkill && !otherPokemon.knowsSkill) {
                if ((this.name.equals(otherPokemon.name)) &&
                        (this.pokemonType.equals(otherPokemon.pokemonType)) &&
                        (this.currentHP == otherPokemon.currentHP) &&
                        (this.MAX_HP == otherPokemon.MAX_HP) &&
                        (this.EP == otherPokemon.EP)) {
                    return true;
                }
            } else if (this.knowsSkill && otherPokemon.knowsSkill) {
                if (this.pokemonSkill.equals(otherPokemon.pokemonSkill)) {
                    return true;
                }
            }
        }
        return false;
    }

    public String toString() {
        String pokemon = "";
        if (!this.knowsSkill()) {
            pokemon = this.getName() + " (" + this.getType() + ")";
        } else {
            pokemon = this.getName() + " (" + this.getType() + "). Knows " + pokemonSkill;
        }
        return pokemon;
    }

    //3.1 - Learn and Forget Skills:
    public void learnSkill(String name, int attackPower, int energyCost) {
        this.pokemonSkill = new Skill(name, attackPower, energyCost);
    }

    //Ask a pokemon whether it currently knows a skill and if it does replace it with a new skill

    public boolean knowsSkill() {
        if (this.pokemonSkill != null) {
            this.knowsSkill = true;
        } else {
            this.knowsSkill = false;
        }
        return knowsSkill;
    }
    //In Java, you must declare a method of the boolean type in order for it to return a boolean value.
    //The boolean method will return the boolean value, true or false.
    //You can either return the variable containing a boolean value or use conditional statements to decide the returned value.

    public void forgetSkill() {
        this.pokemonSkill = null;
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

    //Task 5: Pokemon Battle

    //type calc not inside pokemon
    //only need type
    //if type is this.... effective
    //attack method calculate damage
    //method receive damage
    public String attack(Pokemon targetPokemon) {
        this.targetPokemon = targetPokemon;
        String message;
        if (this.hasFainted) {
            message = "Attack failed. " + this.getName() + " fainted.";
        } else if (targetPokemon.hasFainted) {
            message = "Attack failed. " + targetPokemon.getName() + " fainted.";
        } else if (this.pokemonSkill == null) {
            message = "Attack failed. " + this.getName() + " does not know a skill.";
        } else if (this.EP < this.pokemonSkill.getEnergyCost()) {
            message = "Attack failed. " + this.getName() + " lacks energy: " + this.getEnergy() + " / " + this.pokemonSkill.getEnergyCost();
        } else {
            if (this.getType().equals("Normal") | targetPokemon.getType().equals("Normal")) {
                targetPokemon.receiveDamage(this.pokemonSkill.getAttackPower());
                message = this.getName() + " uses " + this.pokemonSkill.getSkillName() + " on " + targetPokemon.getName() +
                        ".\n" + targetPokemon.getName() + " has " + targetPokemon.getCurrentHP() + " HP left.";
                }
            } else { //check attacker's type and target's type
            calcType();
         }
            if (targetPokemon.hasFainted) {
                message = targetPokemon.getName() + " faints.";
            }
        }
        return message;
    }
}