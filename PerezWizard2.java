package Project02;


public class PerezWizard2 extends Project02.People
{
    PerezWizard2(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, PeopleType.wizard, lifePoints);
        myDescription = "\tPerez Wizard 2";
    }

    public int encounterStrategy(Project02.People otherPerson) {
        int lifePoints = 0;
        if (this.getNation() != otherPerson.getNation()) // if they are not from the same nation
        {
            if (otherPerson.getType() == PeopleType.wizard
            || otherPerson.getType() == PeopleType.healer) // attack wizard or healer for more damage
            {
                lifePoints = (this.getLifePoints() / 3);
            }
            else // attack a warrior for less damage
            {
                lifePoints = (int) (this.getLifePoints() / 4);
            }
        }

        else // same nation
        {
            if (otherPerson.getTribe().equals(this.getTribe())) // same tribe
                lifePoints = otherPerson.getLifePoints() / 3;

            else // not from the same tribe, heal for less
                lifePoints = otherPerson.getLifePoints() / 4;;

        }
        return lifePoints;
    }

}
