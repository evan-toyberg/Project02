package Project02;

/**
 * Warrior can be healed by a healer only if from same nation.
 * If both players are from the same tribe and other person
 * is a healer, then the warrior can get an extra 15 lifepoints,
 * but does not if other person is a warrior or wizard.
 * If both players are not from the same nation, they attack.
 * If the other person is a healer, the warrior does not lose health.
 * If the other person is a wizard or warrior, the warrior will lose
 * some health.
 */

public class NaveedWarrior2 extends People
{
    NaveedWarrior2(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, PeopleType.warrior, lifePoints);
        myDescription = "\tNaveed Warrior2";
    }

    /**
     * Checking if the other person is a healer if the two players are healers.
     * @param otherPerson
     * @param lifepointGiven
     * @return lifepoints
     */
    private int checkIfHealer(People otherPerson, int lifepointGiven)
    {
        int lifepoints;
        // If the other person type is healer.
        if (otherPerson.getType().equals(PeopleType.healer) && this.getLifePoints() < 40)
        {
            lifepoints = -(this.getLifePoints() / lifepointGiven);
        }
        // If the other person type is a warrior and wizard
        else
        {
            lifepoints = 0;
        }
        return lifepoints;
    }

    /**
     * Checks if the other person lifepoints are bigger and causes the player to run
     * away
     * @param otherPerson
     * @param lifePointsReduced
     * @return
     */
    private int checkingEnemyLifepoints(People otherPerson, int lifePointsReduced)
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

    /**
     * Checking if the two players are from the same nation.
     * If not, the players fight each other or the player runs
     * away.
     * @param otherPerson
     * @return
     */
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
                lifepoints = checkIfHealer(otherPerson,5);
            }
            // From different tribes
            else
            {
                lifepoints = checkIfHealer(otherPerson,3);

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
