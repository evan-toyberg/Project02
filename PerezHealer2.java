package Project02;

public class PerezHealer2 extends Project02.People
{
    /**
     * Attacks warriors for more damage then Healer 1, but heals for less
     * @param nation
     * @param tribe
     * @param lifePoints
     */
    PerezHealer2(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, PeopleType.healer, lifePoints);
        myDescription = "\tPerez Healer 2";
    }

    public int encounterStrategy(Project02.People otherPerson) {
        int lifePoints = 0;
        if (this.getNation() != otherPerson.getNation()) // not from the same nation
        {
            if (otherPerson.getType() == PeopleType.warrior) // attack warrior for more damage then others
                {
                    lifePoints = (this.getLifePoints()/3);
                }
                else // attack a wizard or healer
                {
                    lifePoints = (int) (this.getLifePoints()/4);
                }

        }

        else // from the same nation
        {
            if (otherPerson.getLifePoints() < this.getLifePoints()) // heal a friend if less health
            {
                lifePoints = (int) (-otherPerson.getLifePoints() / 3);
            }

        }
        return lifePoints;
    }

}
