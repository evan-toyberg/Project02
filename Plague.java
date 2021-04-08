package Project02;

/**
 * Class is made as a special encounter. This encounter is a plague
 */
public class Plague extends Project02.People {

    Plague(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, PeopleType.SpecialEncounter, lifePoints);
        myDescription = "\tBlack Plague";
    }

    @Override
    public int encounterStrategy(Project02.People otherPerson) {
        // Plague kills the other person
        if (!this.getNation().equals(otherPerson.getNation())){
            otherPerson.setDead();
            otherPerson.modifyLifePoints(-100);
            return this.getLifePoints()-1;
        }
        else
            return 0;

        // If special Character encounters another special character nothing happens




    }
}
