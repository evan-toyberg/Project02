package Project02;

import Project02.People;
import Project02.PeopleType;


public class PerezWarrior2 extends People
{
    PerezWarrior2(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, PeopleType.warrior, lifePoints);
        myDescription = "\tPerez Warrior";
    }


    public int encounterStrategy(People otherPerson)
    {
        int lifePoints = 0;
        if(this.getNation().equals(otherPerson.getNation())) // from the same nation
        {
            if (otherPerson.getTribe().equals(this.getTribe())) // small heal for other tribe members, else ignore them
            {
                if (otherPerson.getLifePoints() < this.getLifePoints())
                    lifePoints = -(otherPerson.getLifePoints() / 4);
            }
        }

        else
        {
            int points;
            points = this.getLifePoints() - otherPerson.getLifePoints();
            if (points > 0) // more health then opponent, normal damage
            {
                lifePoints = otherPerson.getLifePoints();
            }
            else // less health then opponent, do more damage
            {
                lifePoints = (int) (this.getLifePoints() * 3);
            }
        }
        return lifePoints;
    }

}
