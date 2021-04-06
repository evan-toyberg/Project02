package Project02;

import java.util.ArrayList;

public class BuildSpecialEncounters implements AddPlayers {
    @Override
    public void add(ArrayList<People> members, String nationName, String tribeName, int tribeLifePoints)
    {
        if(tribeName.equals("Animals"))
        {
            members.add(new Snakes(nationName, tribeName, 2));

        }
        if(tribeName.equals("Traps"))
        {

        }
        if(tribeName.equals("Character"))
        {
            members.add(new Warchief(nationName, tribeName, 2));
        }
    }
}
