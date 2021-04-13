package Project02;

public class FireTrap extends People{
    /**
     * @param nation     Stores the String name of a nation
     * @param tribe      Stores the String name of a player's tribe
     * @param lifePoints
     */
    public FireTrap(String nation, String tribe, int lifePoints) {
        super(nation, tribe, PeopleType.SpecialEncounter, lifePoints);
        myDescription = "Fire Trap";
    }

    @Override
    public int encounterStrategy(People otherPerson)
    {
        return 0;
    }
}
