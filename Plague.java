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
        if (otherPerson.isPersonAlive()){
            otherPerson.setDead();
            return this.getLifePoints()-1;
        }
        // If special Character encounters another special character nothing happens
        else if (otherPerson.getNation().equals("Special")){
            return this.getLifePoints();
        }
        return otherPerson.getLifePoints();
    }
}
