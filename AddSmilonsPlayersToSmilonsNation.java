package Project02;

import java.util.ArrayList;

public class AddSmilonsPlayersToSmilonsNation implements AddPlayers{
    @Override
    public void add(ArrayList<People> members, String nationName, String tribeName, int tribeLifePoints)
    {
        if(tribeName.equals("Tribe1"))
        {
            members.add(new NaveedHealer(nationName, tribeName, tribeLifePoints / 6));
            members.add(new NaveedWarrior(nationName, tribeName, tribeLifePoints / 6));
            members.add(new NaveedWizard(nationName, tribeName, tribeLifePoints / 6));
        }
        if(tribeName.equals("Tribe2"))
        {
            members.add(new NaveedHealer(nationName, tribeName, tribeLifePoints / 6));
            members.add(new NaveedWarrior(nationName, tribeName, tribeLifePoints / 6));
            members.add(new NaveedWizard(nationName, tribeName, tribeLifePoints / 6));
        }
        if(tribeName.equals("Tribe3"))
        {
            members.add(new NaveedHealer(nationName, tribeName, tribeLifePoints / 6));
            members.add(new NaveedWarrior(nationName, tribeName, tribeLifePoints / 6));
            members.add(new NaveedWizard(nationName, tribeName, tribeLifePoints / 6));
        }
    }
}
