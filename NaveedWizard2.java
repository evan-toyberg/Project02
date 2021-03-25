package Project02;

public class NaveedWizard2 extends People
{
    /**
     * Wizard can only get healed by a healer. If the other person is from same tribe and a healer
     * type, the wizard can get an extra 2 lifepoints. If the other person is from a different tribe,
     * the wizard can get an extra 10 lifepoints. This wizard will never run away and will fight to the
     * death. The wizard will not get any damage from a healer.
     * @param nation
     * @param tribe
     * @param lifePoints
     */
    NaveedWizard2(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, PeopleType.wizard, lifePoints);
        myDescription = "Naveed Wizard2";
    }
    /**
     * Checking if the other person is a healer and the player has less than
     * 40 lifepoints.
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
        // From same nation
        if (this.getNation().equals(otherPerson.getNation()))
        {
            // From same tribe
            if (this.getTribe().equals(otherPerson.getTribe()))
            {
                lifepoints = checkIfHealer(otherPerson,2);
            }
            // From different tribe
            else
            {
                lifepoints = checkIfHealer(otherPerson,10);
            }
        }
        // From different nation
        else
        {
            // Other person is healer.
            if (otherPerson.getType().equals(PeopleType.healer))
            {
                lifepoints = this.getLifePoints();
            }
            if (otherPerson.getType().equals(PeopleType.warrior))
            {
                lifepoints = this.getLifePoints() / 4;
            }
            if (otherPerson.getType().equals(PeopleType.wizard))
            {
                lifepoints = this.getLifePoints() / 2;
            }
        }
        return lifepoints;
    }
}
