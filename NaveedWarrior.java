package Project02;

/**
 * Warrior can be heal by a healer from the same nation.
 * If two players are from the same tribe and have less than 40 lifepoints,
 * warrior can get an extra 10 lifepoints. If two players are not from the
 * same tribe, the warrior can get an extra 5 lifepoints.
 * If the two players are not from the same nation, two players fight each other.
 * If the other person is a warrior and has a higher lifepoints, the warrior will
 * run away. If the other person is a healer or a wizard, the warrior will fight.
 */

public class NaveedWarrior extends People
{
    NaveedWarrior(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, PeopleType.warrior, lifePoints);
        myDescription = "\tNaveed Warrior";
    }

    /**
     * Giving additional lifepoints to the player if their lifepoints
     * are below 40.
     * @param additonalLifepoints
     * @return
     */
    private int encounterStrategy2(int additonalLifepoints)
    {
        int lifepoints = 0;
        // Checks if the current lifepoints are not over 55
        if (this.getLifePoints() < 40)
        {
            lifepoints = this.getLifePoints() - additonalLifepoints ;
        }
        else
        {
            lifepoints = 0;
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
        // Both players are from the same nation
        if (this.getNation().equals(otherPerson.getNation()))
        {
            // Can only heal if the other person is a healer
            if (otherPerson.getType().equals(PeopleType.healer))
            {
                // Both are from same tribe.
                if (otherPerson.getType().equals(this.getTribe()))
                {
                    lifepoints = encounterStrategy2(10);
                }
                // Both are from different tribes.
                else
                {
                    lifepoints = encounterStrategy2(5);
                }
            }
            // Warrior cannot increase their lifepoints without a healer
            else
            {
                lifepoints = 0;
            }
        }
        // Both players are not from the same nation.
        else
        {
            // Getting attacked by a wizard
            if (otherPerson.getType().equals(PeopleType.wizard))
            {
                lifepoints = this.getLifePoints() / 2;
            }

            // Getting attacked by a warrior
            if (otherPerson.getType().equals(PeopleType.warrior))
            {
                // Running away
               if (otherPerson.getLifePoints() > this.getLifePoints())
               {
                   lifepoints = -this.getLifePoints();
               }
               // Fighting the warrior
               else
               {
                   lifepoints = this.getLifePoints() / 4;
               }
            }
            // Fighting a healer, Does not do any damage
            else
            {
                lifepoints = this.getLifePoints();
            }
        }

        return lifepoints;
    }
}
