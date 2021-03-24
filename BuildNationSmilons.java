package Project02;

import java.util.ArrayList;

public class BuildNationSmilons implements AddPlayers{
    @Override
    public void add(ArrayList<People> members, String nationName, String tribeName, int tribeLifePoints)
    {
        if(tribeName.equals("Tribe1"))
        {
            members.add(new SmilonsHealer(nationName, tribeName, tribeLifePoints / 6));
            members.add(new SmilonsWarrior(nationName, tribeName, tribeLifePoints / 6));
            members.add(new SmilonsWizard(nationName, tribeName, tribeLifePoints / 6));
            members.add(new SmilonsHealer2(nationName, tribeName, tribeLifePoints / 6));
            members.add(new SmilonsWarrior2(nationName, tribeName, tribeLifePoints / 6));
            members.add(new SmilonsWizard2(nationName, tribeName, tribeLifePoints / 6));
        }
        if(tribeName.equals("Tribe2"))
        {
            members.add(new SmilonsHealer(nationName, tribeName, tribeLifePoints / 6));
            members.add(new SmilonsWarrior(nationName, tribeName, tribeLifePoints / 6));
            members.add(new SmilonsWizard(nationName, tribeName, tribeLifePoints / 6));
            members.add(new SmilonsHealer2(nationName, tribeName, tribeLifePoints / 6));
            members.add(new SmilonsWarrior2(nationName, tribeName, tribeLifePoints / 6));
            members.add(new SmilonsWizard2(nationName, tribeName, tribeLifePoints / 6));
        }
        if(tribeName.equals("Tribe3"))
        {
            members.add(new SmilonsHealer(nationName, tribeName, tribeLifePoints / 6));
            members.add(new SmilonsWarrior(nationName, tribeName, tribeLifePoints / 6));
            members.add(new SmilonsWizard(nationName, tribeName, tribeLifePoints / 6));
            members.add(new SmilonsHealer2(nationName, tribeName, tribeLifePoints / 6));
            members.add(new SmilonsWarrior2(nationName, tribeName, tribeLifePoints / 6));
            members.add(new SmilonsWizard2(nationName, tribeName, tribeLifePoints / 6));
        }
    }
}