package Project02;

import Project02.PeopleType;


public class ToybergWizard2 extends Project02.People {

    /**
     * Attacks on healers are based on enemy's health.
     * Attacks on warriors are based on this wizard's health.
     * Attacks on wizards are based on enemy's max health.
     *
     * Can steal health from enemies
     *
     * Has no benefits to meeting a player of same nation or tribe
     *
     */
    ToybergWizard2(String nation, String tribe, int lifePoints) {
        super(nation, tribe, PeopleType.wizard, lifePoints);
        myDescription = "\tToyberg Wizard";
    }

    public int encounterStrategy(Project02.People otherPerson) {
        int lifePoints = 0;
        if (this.getNation() != otherPerson.getNation()){
            if(otherPerson.getType() == PeopleType.healer){
                lifePoints = otherPerson.getLifePoints();
                modifyLifePoints(lifePoints / 5);
            }

            else if(otherPerson.getType() == PeopleType.warrior){
                lifePoints = this.getLifePoints();
                modifyLifePoints(lifePoints / 10);
            }

            else{
                lifePoints = otherPerson.MAX_LIFEPOINTS / 5;
            }
        }
        return lifePoints;
    }

}
