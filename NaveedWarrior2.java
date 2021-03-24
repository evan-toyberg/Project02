package Project02;

public class NaveedWarrior2 extends People
{
    NaveedWarrior2(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, PeopleType.warrior, lifePoints);
        myDescription = "\tNaveed Warrior2";
    }

    private int checkIfHealer(People otherPerson, int lifepointGiven)
    {
        int lifepoints;
        // If the other person type is healer.
        if (otherPerson.getType().equals(PeopleType.healer) && this.getLifePoints() < 40)
        {
            lifepoints = this.getLifePoints() - lifepointGiven;
        }
        // If the other person type is a warrior and wizard
        else
        {
            lifepoints = 0;
        }
        return lifepoints;
    }

    public int checkingEnemyLifepoints(People otherPerson, int lifePointsReduced)
    {
        int lifepoints = 0;
        // Running away
        if (this.getLifePoints() < otherPerson.getLifePoints())
        {
            lifepoints = -this.getLifePoints() / lifePointsReduced;
        }
        // Fighting the other person
        else
        {
            lifepoints = this.getLifePoints() / lifePointsReduced;
        }
        return lifepoints;
    }

    @Override
    public int encounterStrategy(People otherPerson)
    {
        int lifepoints = 0;
        // From the same nation
        if (this.getNation().equals(otherPerson.getNation()))
        {
            // From the same tribe
            if (this.getTribe().equals(otherPerson.getTribe()))
            {
                lifepoints = checkIfHealer(otherPerson,15);
            }
            // From different tribes
            else
            {
                lifepoints = checkIfHealer(otherPerson,10);

            }
        }
        // From the different nation
        else
        {
            // Other person is a healer
            if(otherPerson.getType().equals(PeopleType.healer))
            {
                lifepoints = this.getLifePoints();
            }
            // Other person is a wizard
            if(otherPerson.getType().equals(PeopleType.wizard))
            {
                lifepoints = checkingEnemyLifepoints(otherPerson, 2);
            }
            // Other person is a warrior
            if (otherPerson.getType().equals(PeopleType.warrior))
            {
                lifepoints = checkingEnemyLifepoints(otherPerson, 4);
            }
        }
        return lifepoints;
    }
}
