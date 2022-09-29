package assignment2;

public class TypeCalc {

    public double damageValue;

    public TypeCalc(double damageValue){
        damageValue=

        if ((this.getType().equals("Water") && targetPokemon.getType().equals("Fire"))
                | (this.getType().equals("Fire") && targetPokemon.getType().equals("Grass"))
                | (this.getType().equals("Grass") && targetPokemon.getType().equals("Water"))){
            damageValue= damageValue* 2;

        if ((targetPokemon.getType().equals("Water") && this.getType().equals("Grass") | this.getType().equals("Water"))
                | (targetPokemon.getType().equals("Fire") && this.getType().equals("Water") | this.getType().equals("Fire")
                | (targetPokemon.getType().equals("Grass") && this.getType().equals("Grass") | this.getType().equals("Fire")) {
            damageValue= (int) damageValue* 0.5;

    public void checkType() {
        if (this.)
    }

    /*if ((this.getType().equals("Water") && targetPokemon.getType().equals("Fire"))
            | (this.getType().equals("Fire") && targetPokemon.getType().equals("Grass"))
            | (this.getType().equals("Grass") && targetPokemon.getType().equals("Water"))){
                receiveDamage(this.pokemonSkill.getAttackPower() * 2);
                message = getName() + " uses " + this.pokemonSkill.getSkillName() + " on " + targetPokemon.getName() +
                        ". It is super effective!\n" + targetPokemon.getName() + " has " + targetPokemon.getCurrentHP() + " HP left.";
            } else if ((targetPokemon.getType().equals("Water") && this.getType().equals("Grass") | this.getType().equals("Water"))
            | (targetPokemon.getType().equals("Fire") && this.getType().equals("Water") | this.getType().equals("Fire")
            | (targetPokemon.getType().equals("Grass") && this.getType().equals("Grass") | this.getType().equals("Fire")) {
                receiveDamage((this.pokemonSkill.getAttackPower() * 0.5)%2f);
                message = getName() + " uses " + this.pokemonSkill.getSkillName() + " on " + targetPokemon.getName() +
                        ". It is not very effective...\n" + targetPokemon.getName() + " has " + targetPokemon.getCurrentHP() + " HP left.";*/
}
        }
    }
}

/*
if (this.getType().equals("Water")) {
            if (targetPokemon.getType().equals("Fire")) {
                damageValue= damageValue* 2;
            } else if (targetPokemon.getType().equals("Water") | targetPokemon.getType().equals("Grass")) {
                damageValue = (int) damageValue* 0.5;
            }
        } else if (this.getType().equals("Fire")) {
            if (targetPokemon.getType().equals("Grass")) {
                damageValue= damageValue* 2;
            } else if (targetPokemon.getType().equals("Fire") | targetPokemon.getType().equals("Water")) {
                damageValue = (int) damageValue* 0.5;
            }
        } else if (this.getType().equals("Water")) {
            if (targetPokemon.getType().equals("Fire")) {
                damageValue= damageValue* 2;
            } else if (targetPokemon.getType().equals("Water") | targetPokemon.getType().equals("Grass")) {
                damageValue = (int) damageValue* 0.5;
            }
        }
        return damageValue;
 */