package Project02;

import java.nio.charset.StandardCharsets;

/** The healer heals people from the same nation.
 * If the two players are from the same tribe and the other player is the healer,
 * the healer can be healed. If other player is not a healer, nothing happens to the
 * healer. If the other person is from the same tribe, he/she heals him/her by 10 lifepoints.
 * If the other person is from the same tribe, he/she heals him/her by 5 lifepoints.
 * If the two players are not from the same nation, healer can only fight a healer. Healer
 * will run away if fighting warrior or wizard.
 */
public class NaveedHealer2 extends People
{

    public NaveedHealer2(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, PeopleType.healer, lifePoints);
        myDescription = "\tNaveed Healer2";
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
                lifepoints = checkIfHealer(otherPerson, 5);
            }
            // From different tribe
            else
            {
                lifepoints = checkIfHealer(otherPerson, 3);
            }
        }
        // From different nations
        // The healer has a good offense and defense.
        else
        {
            if (otherPerson.getType().equals(PeopleType.warrior) && otherPerson.getType().equals(PeopleType.wizard) && otherPerson.getType().equals(PeopleType.healer)) {    // If other person lifepoints are lower than the player's
                if (this.getLifePoints() > otherPerson.getLifePoints()) {
                    lifepoints = this.getLifePoints() / 3;
                }
                // If other person lifepoints are higher than the player's
                else {
                    lifepoints = this.getLifePoints() / 4;
                }
            }

            if (otherPerson.getTribe().equals("Traps"))
            {
                lifepoints = -this.getLifePoints();
            }

            if (otherPerson.getTribe().equals("Animals"))
            {
                lifepoints = (this.getLifePoints()- otherPerson.getLifePoints())/3;
            }
        }

        return lifepoints;
    }
}
