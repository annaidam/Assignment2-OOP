package assignment2;

public class Skill {

    private final String NAME;
    private final int ATTACK_POWER;
    private final int ENERGY_COST;

    public Skill(String NAME, int attackPower, int energyCost) {
        this.NAME = NAME;
        this.ATTACK_POWER = attackPower;
        this.ENERGY_COST = energyCost;
    }

    public String getSkillName() {
        return this.NAME;
    }

    public int getAttackPower() {
        return this.ATTACK_POWER;
    }

    public int getEnergyCost() {
        return this.ENERGY_COST;
    }

    public boolean equalSkillName(Object anotherSkill) {
        Skill otherSkill = (Skill) anotherSkill;
        if (this.getSkillName().equals(otherSkill.getSkillName())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean equalAttackPower(Object anotherSkill) {
        Skill otherSkill = (Skill) anotherSkill;
        if (this.getAttackPower() == otherSkill.getAttackPower()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean equalEnergyCost(Object anotherSkill) {
        Skill otherSkill = (Skill) anotherSkill;
        if (this.getEnergyCost() == otherSkill.getEnergyCost()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean equals(Object anotherSkill) {
        if (anotherSkill == null) {
            return false;
        } else if (anotherSkill instanceof Skill) {
            if (equalSkillName(anotherSkill) && equalAttackPower(anotherSkill) && equalEnergyCost(anotherSkill)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return (this.getSkillName() + " - AP: " + this.getAttackPower() + " EC: " + this.getEnergyCost());
    }
}