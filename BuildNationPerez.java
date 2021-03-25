package Project02;

import java.util.ArrayList;

/**
 * Add the 3 different types of players into 3 tribes. Each tribe should have 6 players.
 * Each nation should have 18 players.
 */
public class BuildNationPerez implements AddPlayers{
    @Override
    public void add(ArrayList<People> members, String nationName, String tribeName, int tribeLifePoints)
    {
        if(tribeName.equals("Tribe1"))
        {
            members.add(new PerezHealer(nationName, tribeName, tribeLifePoints / 6));
            members.add(new PerezWarrior(nationName, tribeName, tribeLifePoints / 6));
            members.add(new PerezWizard(nationName, tribeName, tribeLifePoints / 6));
            members.add(new PerezHealer2(nationName, tribeName, tribeLifePoints / 6));
            members.add(new PerezWarrior2(nationName, tribeName, tribeLifePoints / 6));
            members.add(new PerezWizard2(nationName, tribeName, tribeLifePoints / 6));
        }
        if(tribeName.equals("Tribe2"))
        {
            members.add(new PerezHealer(nationName, tribeName, tribeLifePoints / 6));
            members.add(new PerezWarrior(nationName, tribeName, tribeLifePoints / 6));
            members.add(new PerezWizard(nationName, tribeName, tribeLifePoints / 6));
            members.add(new PerezHealer2(nationName, tribeName, tribeLifePoints / 6));
            members.add(new PerezWarrior2(nationName, tribeName, tribeLifePoints / 6));
            members.add(new PerezWizard2(nationName, tribeName, tribeLifePoints / 6));
        }
        if(tribeName.equals("Tribe3"))
        {
            members.add(new PerezHealer(nationName, tribeName, tribeLifePoints / 6));
            members.add(new PerezWarrior(nationName, tribeName, tribeLifePoints / 6));
            members.add(new PerezWizard(nationName, tribeName, tribeLifePoints / 6));
            members.add(new PerezHealer2(nationName, tribeName, tribeLifePoints / 6));
            members.add(new PerezWarrior2(nationName, tribeName, tribeLifePoints / 6));
            members.add(new PerezWizard2(nationName, tribeName, tribeLifePoints / 6));
        }
    }
}
