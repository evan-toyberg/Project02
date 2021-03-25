package Project02;

/**
 * The healer heals people from the same nation.
 * If the two players are from the same tribe and the other player is the healer,
 * the healer can be healed. If other player is not a healer, nothing happens to the
 * healer.
 * If the two players are not from the same nation, healer can only fight a healer. Healer
 * will run away if fighting warrior or wizard.
 */
public class NaveedHealer extends People
{

    NaveedHealer(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, PeopleType.healer, lifePoints);
        myDescription = "\tNaveed Healer";
    }
    /**
     * Returns the lifepoints when encountering other people.
     * @param otherPerson
     * @return
     */
    public int encounterStrategy(People otherPerson)
    {
        int lifepoints = 0;
        // If the two players are from the same nation, heal each other
        if((this.getNation().equals(otherPerson.getNation())))
        {
            // Can only heal by a healer
            if(otherPerson.getType().equals(PeopleType.healer))
            {
                if(this.getLifePoints() < 40)
                {
                    lifepoints = this.getLifePoints() - 5;
                }
                else
                {
                    lifepoints = 0;
                }
            }
            else
            {
                lifepoints = 0;
            }

        }
        // If the two players are not from the same nation
        else
        {
            // Running away
            if(otherPerson.getType().equals(PeopleType.warrior) || otherPerson.getType().equals(PeopleType.wizard))
            {
                lifepoints = -this.getLifePoints();
            }
            // Fighting a healer
            else
            {
                lifepoints = (int)(this.getLifePoints() / 2);
            }
        }

        return lifepoints;
    }
}
