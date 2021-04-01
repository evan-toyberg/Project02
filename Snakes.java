package Project02;

public class Snakes extends People {

    Snakes(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, PeopleType.SpecialEncounter, lifePoints);
        myDescription = "\tPack of Snakes";
    }

    public int encounterStrategy(People otherPerson) {

        return 0;
    }

}
