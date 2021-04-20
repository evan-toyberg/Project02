package Project02;

public class FireKeeper extends People {

    FireKeeper(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, PeopleType.SpecialEncounter, lifePoints);
        myDescription = "\tFireKeeper";
    }

    public int encounterStrategy(People otherPerson) {

        if (otherPerson.getNation() != this.getNation()) // if the otherPerson isn't another special encounter
        {
            if (otherPerson.getType().equals(PeopleType.healer)) // if otherPerson is a wizard, heal
            {
              //  modifyLifePoints(-1);
                return -10;
            }
            else if (otherPerson.getType().equals(PeopleType.warrior)) // if otherPerson is a warrior, attack
            {
               // modifyLifePoints(-1);
                return -15;
            }
            else if (otherPerson.getType().equals(PeopleType.wizard)) // if otherPerson == wizard, ignore
            {
          //      modifyLifePoints(-1);
                return -5;
            }
        }

        return 0; // if otherPerson is another special encounter, do nothing
    }
}
