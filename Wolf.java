package Project02;

public class Wolf extends People{
    /**
     * @param nation     Stores the String name of a nation
     * @param tribe      Stores the String name of a player's tribe
     * @param lifePoints
     */
    public Wolf(String nation, String tribe, int lifePoints) {
        super(nation, tribe, PeopleType.SpecialEncounter, lifePoints);
        myDescription = "Wolf";
    }

    @Override
    public int encounterStrategy(People otherPerson)
    {
        int lifepoints = 0;

        if (!otherPerson.getNation().equals("Special Scenario"))
        {
            if (otherPerson.getType().equals(PeopleType.warrior)) {
                lifepoints = this.getLifePoints() / 4;
            }

            if (otherPerson.getType().equals(PeopleType.wizard)) {
                lifepoints = this.getLifePoints() / 3;
            }

            if (otherPerson.getType().equals(PeopleType.healer)) {
                lifepoints = this.getLifePoints();
            }
        }
        else
        {
            if (otherPerson.getTribe().equals("Character"))
            {
                lifepoints = this.getLifePoints()/3;
            }
            if (otherPerson.getTribe().equals("Traps"))
            {
                lifepoints = -this.getLifePoints();
            }
            if (otherPerson.getTribe().equals("Animals"))
            {
                lifepoints = this.getLifePoints()/4;
            }
        }

        return lifepoints;
    }
}
