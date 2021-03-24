package Project02;


public class PerezWizard extends Project02.People
{
    PerezWizard(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, PeopleType.wizard, lifePoints);
        myDescription = "\tPerez Wizard";
    }

    public int encounterStrategy(Project02.People otherPerson) {
        int lifePoints = 0;
        if (this.getNation() != otherPerson.getNation()) // if they are not from the same nation
        {
            if (otherPerson.getType() == PeopleType.warrior) // attack warrior for more damage
            {
                lifePoints = (this.getLifePoints() / 2);
            } else // attack a wizard or healer
            {
                lifePoints = (int) (this.getLifePoints() / 3);
            }

        }

        else // same nation
        {
            if (otherPerson.getTribe().equals(this.getTribe())) // same tribe
            {
                if (otherPerson.getType() == PeopleType.wizard ||
                        otherPerson.getType() == PeopleType.healer ) // small heal for other wizards or healers
                {
                    lifePoints = -(otherPerson.getLifePoints() / 3);
                }

                else // small heal for warrior of same tribe
                    lifePoints = -(otherPerson.getLifePoints() / 4);

            }
            else
                lifePoints = 0;

        }
        return lifePoints;
    }

}
