package Project02;

public class SmilonsHealer extends Project02.People{
    SmilonsHealer(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, PeopleType.wizard, lifePoints);
        myDescription = "\tSmilons Wizard";
    }
    public int encounterStrategy(Project02.People otherPerson) {
        int lifePoints = 0;
        if (this.getNation() != otherPerson.getNation())
        {
            if (otherPerson.getLifePoints() < this.getLifePoints())
            {
                if (otherPerson.getType() == PeopleType.warrior) // run away
                {
                    lifePoints = -this.getLifePoints();
                }
                else // attack a wizard or healer but not with a lot of lifepoints
                {
                    lifePoints = (int) (this.getLifePoints()/4);
                }
            }
        }
        else
        {
            if (otherPerson.getLifePoints() < this.getLifePoints()) // heal a friend
            {
                lifePoints = (int) -(this.getLifePoints());
            }
            else
            {
                lifePoints = 0;
            }
        }
        return lifePoints;
    }

}


