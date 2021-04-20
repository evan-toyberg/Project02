package Project02;

public class Snakes extends People {

    Snakes(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, PeopleType.SpecialEncounter, lifePoints);
        myDescription = "\tPack of Snakes";
    }

    public int encounterStrategy(People otherPerson) {

        if (otherPerson.getNation() != this.getNation()) // if the otherPerson isn't another special encounter
        {
        //    modifyLifePoints(-1);

            return 5;
        }

        return 0; // if otherPerson is another special encounter, do nothing
    }
}
