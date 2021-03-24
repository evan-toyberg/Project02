package Project02;

import java.util.ArrayList;
import java.util.Random;

public class BuildNationToyberg implements AddPlayers
{
    private final int WARRIOR = 1;
    private final int WARRIOR2 = 2;
    private final int WIZARD = 3;
    private final int WIZARD2 = 4;
    private final int HEALER = 5;
    private final int HEALER2 = 6;


    ArrayList<People> members;
    String nationName;
    String tribeName;
    int tribeLifePoints;

    public void add(ArrayList<People> members, String nationName, String tribeName, int tribeLifePoints)
    {
        this.members = members;
        this.nationName = nationName;
        this.tribeName = tribeName;
        this.tribeLifePoints = tribeLifePoints;

        if(tribeName.equals("Tribe1"))
        {
            addMember(HEALER);
            addMember(WARRIOR2);
            addMember(WARRIOR);
            addMember(WARRIOR);
            addMember(WIZARD);
            addMember(WIZARD);
        }
        if(tribeName.equals("Tribe2"))
        {
            addMember(HEALER);
            addMember(WARRIOR);
            addMember(HEALER2);
            addMember(HEALER2);
            addMember(HEALER2);
            addMember(WIZARD);
        }
        if(tribeName.equals("Tribe3"))
        {
            addMember(HEALER);
            addMember(WARRIOR);
            addMember(WARRIOR);
            addMember(WARRIOR);
            addMember(WIZARD);
            addMember(WIZARD);
        }
    }

    /**
     * Adds specified player type to nation. First applies strategy 1. If already one of that type,
     * applies strategy 2 to that player. If both are already in use, it randomly chooses
     * between the two strategy types.
     *
     * @param playerType a constant that specifies whether Warrior, Wizard, or Healer
     */
    private void addMember(int playerType){
        switch(playerType) {
            case WARRIOR:
                members.add(new ToybergWarrior(nationName, tribeName, tribeLifePoints / 6));
                break;
            case WARRIOR2:
                members.add(new ToybergWarrior2(nationName, tribeName, tribeLifePoints / 6));
                break;
            case WIZARD:
                members.add(new ToybergWizard(nationName, tribeName, tribeLifePoints / 6));
                break;
            case WIZARD2:
                members.add(new ToybergWizard2(nationName, tribeName, tribeLifePoints / 6));
                break;
            case HEALER:
                members.add(new ToybergHealer(nationName, tribeName, tribeLifePoints / 6));
                break;
            case HEALER2:
                members.add(new ToybergHealer2(nationName, tribeName, tribeLifePoints / 6));
                break;
        }
    }

}
