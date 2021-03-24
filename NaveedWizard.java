package Project02;

public class NaveedWizard extends People
{
    NaveedWizard(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, PeopleType.wizard, lifePoints);
        myDescription = "\tNaveed Wizard";
    }

    public int encounterStrategy2(int additionalLifepoints)
    {
        int lifepoints;
        // Checking lifepoints if it is less 100
        if(this.getLifePoints() < 40)
        {
            lifepoints = this.getLifePoints() - additionalLifepoints;
        }
        // Does not add any lifepoints into the player
        else
        {
            lifepoints = 0;
        }
        return lifepoints;
    }

    public int checkingOtherPeopleType(People otherPerson, int additionalLifepoints)
    {
        int lifepoints = 0;
        // Checking if the other person type is a healer or wizard
        if (otherPerson.getType().equals(PeopleType.healer) || otherPerson.getType().equals(PeopleType.wizard))
        {
            lifepoints = encounterStrategy2(additionalLifepoints);
        }
        // Checking if the other person is a warrior.
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
        // Both players are from the same nation
        if(this.getNation().equals(otherPerson.getNation()))
        {
            // Both players are from the same tribe
            if (this.getTribe().equals(otherPerson.getTribe()))
            {
               lifepoints = checkingOtherPeopleType(otherPerson,10);
            }
            // Both players are not from the same tribe.
            else
            {
                lifepoints = checkingOtherPeopleType(otherPerson,5);
            }
        }
        // Both players are not from the same nation
        else
        {
            // Fighting against a warrior
            if(otherPerson.getType().equals(PeopleType.warrior))
            {
                // Running away
                if (this.getLifePoints() < otherPerson.getLifePoints())
                {
                    lifepoints = -this.getLifePoints();
                }
                // Fighting a warrior, but losing 15 lifepoints
                else
                {
                    lifepoints = this.getLifePoints() / 4;
                }
            }
            // Fighting against a wizard
            if (otherPerson.getType().equals(PeopleType.wizard))
            {
                lifepoints = this.getLifePoints() / 2;
            }
            // Fighting against a healer
            else
            {
                lifepoints = this.getLifePoints();
            }
        }
        return lifepoints;
    }
}
