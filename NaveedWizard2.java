package Project02;

public class NaveedWizard2 extends People
{
    NaveedWizard2(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, PeopleType.wizard, lifePoints);
        myDescription = "Naveed Wizard2";
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
