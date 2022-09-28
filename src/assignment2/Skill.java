package assignment2;

public class Skill {
    /*A pokemon relies on a skill during battles. A skill has a name, attack power (AP), and energy
    cost (EC). All these values are specified when creating the skill. Both AP and energy cost are
    integer values. Once created, the state of a skill cannot be changed.*/

    private String name;
    private int attackPower;
    private int energyCost;

    public Skill(String name, int attackPower, int energyCost) {
        this.name = name;
        this.attackPower = attackPower;
        this.energyCost = energyCost;
    }

    public String getSkillName() {
        return this.name;
    }

    public int getAttackPower() {
        return this.attackPower;
    }

    public int getEnergyCost() {
        return this.energyCost;
    }

    //Two skills are equal if they have the same names, APs and energy costs.
    public boolean equals(Object anotherSkill) {
        if (anotherSkill == null) {
            return false;
        } else if (anotherSkill instanceof Skill) {
            Skill otherSkill = (Skill) anotherSkill;
            if ((this.name.equals(otherSkill.name)) && (this.attackPower == otherSkill.attackPower) && (this.energyCost == otherSkill.energyCost)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    //When printed, a skill should return: “<skill name> - AP: <ap> EC: <ec>".
    public String toString() {
        String skill = this.getSkillName() + " - AP: " + this.getAttackPower() + " EC: " + this.getEnergyCost();
        return skill;
    }
}