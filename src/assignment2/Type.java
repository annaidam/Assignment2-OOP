package assignment2;

public enum Type {
    WATER("Water"),
    FIRE("Fire"),
    GRASS("Grass"),
    NORMAL("Normal");

  public  final String pokemonType;

    Type(String pokemonType) {
        this.pokemonType = pokemonType;
    }

    public double typeDamage(Pokemon targetPokemon) {
        double damageValue = targetPokemon.pokemonSkill.getAttackPower();
        if ((this.pokemonType.equals("Water") && targetPokemon.getType().equals("Fire"))
                | (this.pokemonType.equals("Fire") && targetPokemon.getType().equals("Grass"))
                | (this.pokemonType.equals("Grass") && targetPokemon.getType().equals("Water"))){
            damageValue = damageValue * 2;
        } else if ((targetPokemon.getType().equals("Water") && this.pokemonType.equals("Grass") | this.pokemonType.equals("Water"))
                | (targetPokemon.getType().equals("Fire") && this.pokemonType.equals("Water") | this.pokemonType.equals("Fire")
                | (targetPokemon.getType().equals("Grass") && this.pokemonType.equals("Grass") | this.pokemonType.equals("Fire")) {
            damageValue = (damageValue * 0.5)%2f;
        return damageValue;
    }

    /*} else {
            if ((this.getType().equals("Water") && targetPokemon.getType().equals("Fire"))
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