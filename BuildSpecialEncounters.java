package Project02;

import java.util.ArrayList;

public class BuildSpecialEncounters implements AddPlayers {
    @Override
    public void add(ArrayList<People> members, String nationName, String tribeName, int tribeLifePoints)
    {
        if(tribeName.equals("Animals"))
        {
            members.add(new Snakes(nationName, tribeName, 2));
            members.add(new Wolf(nationName,tribeName,2));
        }
        if(tribeName.equals("Traps"))
        {
            members.add(new Plague(nationName, tribeName, 2));
            members.add(new FireTrap(nationName,tribeName,2));
        }
        if(tribeName.equals("Character"))
        {
            members.add(new Warchief(nationName, tribeName, 2));
            members.add(new Merchant(nationName,tribeName,2));
            members.add(new Gandalf(nationName, tribeName, 2));
            members.add(new FireKeeper(nationName, tribeName, 2));

        }
    }
}
