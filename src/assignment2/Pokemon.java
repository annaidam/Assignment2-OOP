package assignment2;

public class Pokemon {
    private String name;
    private int MAX_HP;
    private int currentHP;
    private int energyPoints;
    private String pokemonType;
    public Skill pokemonSkill;

    private boolean hasFainted = false;
    private boolean knowsSkill = false;

    final String END_OF_LINE = System.lineSeparator();

    final int minValue = 0;
    final int maxValue = 100;


    public Pokemon(String name, int MAX_HP, String pokemonType) {
        this.name = name;
        this.MAX_HP = MAX_HP;
        this.energyPoints = maxValue;

        this.currentHP = MAX_HP;
        this.pokemonType = pokemonType;
    }

    public int getEnergy() {
        return this.energyPoints;
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
            //if time: fix the conditional here to look cleaner
            if (!this.knowsSkill && !otherPokemon.knowsSkill) {
                if ((this.name.equals(otherPokemon.name)) &&
                        (this.pokemonType.equals(otherPokemon.pokemonType)) &&
                        (this.currentHP == otherPokemon.currentHP) &&
                        (this.MAX_HP == otherPokemon.MAX_HP) &&
                        (this.energyPoints == otherPokemon.energyPoints)) {
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
        String pokemon;
        if (!this.knowsSkill()) {
            pokemon = this.getName() + " (" + this.getType() + ")";
        } else {
            pokemon = this.getName() + " (" + this.getType() + "). Knows " + pokemonSkill;
        }
        return pokemon;
    }

    //learning a new skill
    public void learnSkill(String name, int attackPower, int energyCost) {
        this.pokemonSkill = new Skill(name, attackPower, energyCost);
    }

    //ask a pokemon whether it currently knows a skill and if it does replace it with a new skill
    public boolean knowsSkill() {
        if (this.pokemonSkill != null) {
            this.knowsSkill = true;
        } else {
            this.knowsSkill = false;
        }
        return knowsSkill;
    }

    //forgetting a learned skill
    public void forgetSkill() {
        this.pokemonSkill = null;
    }

    public void hasFainted() {
        this.hasFainted = true;
    }

    //receive damage in battle
    public void receiveDamage(int damageValue) {
        this.currentHP -= damageValue;

        if (this.currentHP <= minValue) {
            this.currentHP = minValue;
            if (!this.hasFainted) {
                hasFainted();
            }
        }
    }

    //recover HP while resting
    public void rest() {
        int bonusHP = 20;
        if ((!this.hasFainted) && (this.currentHP < this.MAX_HP)) {
            this.currentHP += bonusHP;
            if (this.currentHP > this.MAX_HP) {
                this.currentHP = this.MAX_HP;
            }
        }
    }

    //spending energy points during battle
    public void spendEP(int EC) {
        if (this.energyPoints >= EC) {
            this.energyPoints -= EC;
            if (this.energyPoints < minValue) {
                this.energyPoints = minValue;
            }
        }
    }

    //recovering energy during battle
    public void recoverEnergy() {
        int bonusEnergyPoints = 25;
        if (!this.hasFainted) {
            this.energyPoints += bonusEnergyPoints; //pokemon can recover energy where a fixed amount of 25 EP is restored.
            if (this.energyPoints > this.MAX_HP) {  //EP can never be less than zero or greater than 100
                this.energyPoints = this.MAX_HP;
            }
        }
    }

    /*When a pokemon uses an Item, it increases its HP for the corresponding healing power
    even if the pokemon has fainted. Note that the HP should never go above the MAX HP.
    Whenever an item heals a pokemon over the MAX HP, the pokemon’s HP should be its MAX
    HP.*/
    public String useItem(Item item) {
        String useItem;
        if (this.getCurrentHP() == this.getMAX_HP()) {
            useItem = this.getName() + " could not use " + item.getItemName() + ". HP is already full.";
        } else {
            this.currentHP += item.getHealing_power();
            if (currentHP > MAX_HP) {
                currentHP = MAX_HP;
            }
            useItem = this.getName() + " used " + item.getItemName() + ". It healed "
                    + (this.getCurrentHP() - item.getHealing_power()) + " HP.";
        }
        return useItem;
    }

    //Task 5: Pokemon Battle
    public String attack(Pokemon targetPokemon) {
        String outcome;
        //checking if the attacker pokemon is able to attack
        if (this.hasFainted) {
            outcome = "Attack failed. " + this.getName() + " fainted.";
        } else if (targetPokemon.hasFainted) {
            outcome = "Attack failed. " + targetPokemon.getName() + " fainted.";
        } else if (this.pokemonSkill == null) {
            outcome = "Attack failed. " + this.getName() + " does not know a skill.";
        } else if (this.energyPoints < this.pokemonSkill.getEnergyCost()) {
            outcome = "Attack failed. " + this.getName() + " lacks energy: " + this.getEnergy() + " / " + this.pokemonSkill.getEnergyCost();
        } else {
            //explaining the matrix relation with the types
            Type enumAttacker = Type.valueOf(this.getType().toUpperCase());
            Type enumDefender = Type.valueOf(targetPokemon.getType().toUpperCase());
            double result = TypeCalc.getFactorValue(enumAttacker.pokemonIndex, enumDefender.pokemonIndex);

            // explaining the damage
            spendEP(this.pokemonSkill.getEnergyCost());
            double damage = this.pokemonSkill.getAttackPower() * result;
            targetPokemon.receiveDamage((int) damage);

            //avoiding massive repetition
            String message1 = this.getName() + " uses " + this.pokemonSkill.getSkillName() + " on " + targetPokemon.getName() + ". ";
            String message2 = targetPokemon.getName() + " has " + targetPokemon.getCurrentHP() + " HP left.";
            outcome = message1 + END_OF_LINE + message2;

            if (result == 1) {
                return outcome;
            } else if (result == 2) {
                outcome = message1 + TypeCalc.superEffective() + END_OF_LINE + message2;
            } else {
                outcome = message1 + TypeCalc.notVeryEffective() + END_OF_LINE + message2;
            }
            if (targetPokemon.hasFainted) {
                outcome = outcome + targetPokemon.getName() + " faints.";
            }
        }
        return outcome;
    }
}
