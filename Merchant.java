package Project02;

public class Merchant extends People{
    /**
     * @param nation     Stores the String name of a nation
     * @param tribe      Stores the String name of a player's tribe
     * @param lifePoints
     */
    public Merchant(String nation, String tribe, int lifePoints) {
        super(nation, tribe, PeopleType.SpecialEncounter, lifePoints);
        myDescription = "Merchant";
    }

    @Override
    public int encounterStrategy(People otherPerson)
    {
        int lifepoints = 0;
        if (otherPerson.getNation().equals("Special Scenario"))
        {
            if (otherPerson.getTribe().equals("Character"))
            {
                return lifepoints;
            }
            if (otherPerson.getTribe().equals("Animals"))
            {
                lifepoints = -this.getLifePoints();
                return lifepoints;
            }
            if (otherPerson.getType().equals(PeopleType.healer))
            {
                lifepoints = (this.getLifePoints() - otherPerson.getLifePoints())/2;
                return lifepoints;
            }
        }
        return lifepoints;

    }
}
