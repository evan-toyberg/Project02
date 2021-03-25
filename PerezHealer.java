package Project02;

public class PerezHealer extends Project02.People
{
    PerezHealer(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, PeopleType.healer, lifePoints);
        myDescription = "\tPerez Healer";
    }

    /**
     *
     * @param otherPerson
     * Reference to opponent
     * @return
     * Healer runs away from Warriors that have more health then them.
     *
     * Only heals if other person has less life points then them.
     */
    public int encounterStrategy(Project02.People otherPerson) {
        int lifePoints = 0;
        if (this.getNation() != otherPerson.getNation()) // not from the same nation
        {
            if (this.getLifePoints() < otherPerson.getLifePoints()) // if healer has less health
            {
                if (otherPerson.getType() == PeopleType.warrior) // run away if warrior
                {
                    lifePoints = -this.getLifePoints();
                }
                else // attack a wizard or healer
                {
                    lifePoints = (int) (this.getLifePoints()/5);
                }
            }

            else // if healer has equal or more health then opponent
            {
                lifePoints = (this.getLifePoints()/4);
            }
        }

        else // from the same nation
        {
            if (otherPerson.getLifePoints() < this.getLifePoints()) // heal a friend if less health
            {
                lifePoints = (int) (-otherPerson.getLifePoints() / 3);
            }
            else
            {
                lifePoints = 0; // do nothing
            }
        }
        return lifePoints;
    }

}
