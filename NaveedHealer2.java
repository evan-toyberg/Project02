package Project02;

import java.nio.charset.StandardCharsets;

public class NaveedHealer2 extends People
{

    public NaveedHealer2(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, PeopleType.healer, lifePoints);
        myDescription = "\tNaveed Healer2";

    }



    private int checkIfHealer(People otherPerson, int lifepointGiven)
    {
        int lifepoints;
        // If the other person type is healer.
        if (otherPerson.getType().equals(PeopleType.healer) && this.getLifePoints() < 40)
        {
            lifepoints = this.getLifePoints() + lifepointGiven;
        }
        // If the other person type is a warrior and wizard
        else
        {
            lifepoints = this.getLifePoints();
        }
        return lifepoints;
    }

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
                lifepoints = checkIfHealer(otherPerson, 10);
            }
            // From different tribe
            else
            {
                lifepoints = checkIfHealer(otherPerson, 5);
            }
        }
        // From different nations
        // The healer has a good offense and defense.
        else
        {
            // If other person lifepoints are lower than the player's
            if (this.getLifePoints() > otherPerson.getLifePoints())
            {
                lifepoints = this.getLifePoints() / 3;
            }
            // If other person lifepoints are higher than the player's
            else
            {
                lifepoints = this.getLifePoints() / 4;
            }
        }

        return lifepoints;
    }
}
