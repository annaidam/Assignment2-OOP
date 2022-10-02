package assignment2;

public class Skill {

    private String name;
    private int attackPower;
    private int energyCost;

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
        return this.energyCost;
    }

    //Two skills are equal if they have the same names, APs and energy costs.

    /*
    public boolean equalSkillName(Object anotherSkill) {
        Skill otherSkill = (Skill) anotherSkill;
        if (this.getSkillName().equals(otherSkill.getSkillName()) {
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

    public boolean equalAEnergyCost(Object anotherSkill) {
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
            Skill otherSkill = (Skill) anotherSkill;
            if (equalSkillName(anotherSkill) && equalAttackPower(anotherSkill) && equalEnergyCost(anotherSkill)) {
                return true;
            }
        }
        return false;
    }
     */
    public boolean equals(Object anotherSkill) {
        if (anotherSkill == null) {
            return false;
        } else if (anotherSkill instanceof Skill) {
            Skill otherSkill = (Skill) anotherSkill;
            if ((this.getSkillName().equals(otherSkill.getSkillName())) && (this.getAttackPower() == otherSkill.getAttackPower()) && (this.getEnergyCost() == otherSkill.getEnergyCost())) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public String toString() {
        String skill = this.getSkillName() + " - AP: " + this.getAttackPower() + " EC: " + this.getEnergyCost();
        return skill;
    }
}