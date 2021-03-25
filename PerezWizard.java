package Project02;


public class PerezWizard extends Project02.People
{
    PerezWizard(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, PeopleType.wizard, lifePoints);
        myDescription = "\tPerez Wizard";
    }

    /**
     *
     * @param otherPerson
     * Reference to opponent
     * @return
     * Attacks warriors for extra damage
     *
     * Small heal for allies from the same tribe, bonus if they are a wizard or healer
     */
    public int encounterStrategy(Project02.People otherPerson) {
        int lifePoints = 0;
        if (this.getNation() != otherPerson.getNation()) // if they are not from the same nation
        {
            if (otherPerson.getType() == PeopleType.warrior) // attack warrior for more damage
            {
                lifePoints = (this.getLifePoints() /4);
            } else // attack a wizard or healer
            {
                lifePoints = (int) (this.getLifePoints() / 5);
            }

        }

        else // same nation
        {
            if (otherPerson.getTribe().equals(this.getTribe())) // same tribe
            {
                if (otherPerson.getType() == PeopleType.wizard ||
                        otherPerson.getType() == PeopleType.healer ) // small heal for other wizards or healers
                {
                    lifePoints = -(otherPerson.getLifePoints() / 4);
                }

                else // small heal for warrior of same tribe
                    lifePoints = -(otherPerson.getLifePoints() / 5);

            }
            else
                lifePoints = 0;

        }
        return lifePoints;
    }

}
