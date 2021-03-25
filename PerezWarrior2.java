package Project02;


public class PerezWarrior2 extends People
{
    PerezWarrior2(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, PeopleType.warrior, lifePoints);
        myDescription = "\tPerez Warrior 2";
    }


    public int encounterStrategy(People otherPerson)
    {
        int lifePoints = 0;
        if(!this.getNation().equals(otherPerson.getNation())) // not from the same nation, else do nothing
        {
            if (otherPerson.getLifePoints() > this.getLifePoints()) // if enemy has more life points
                lifePoints = otherPerson.getLifePoints() / 4;

            else
                lifePoints = this.getLifePoints() / 5;

        }


        return lifePoints;
    }

}
