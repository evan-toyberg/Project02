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
        if (this.getNation() != otherPerson.getNation()){
            otherPerson.setDead();
            return otherPerson.getLifePoints();
        }
        else
            return 0;

        // If special Character encounters another special character nothing happens




    }
}
