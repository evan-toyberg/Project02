package Project02;
import java.util.Collection;
import java.util.Collections;
import java.io.StringBufferInputStream;
import java.util.ArrayList;

/**
 * Class is used to create a tribe under a nation that has a certain amount of life points.
 */
public class Tribe
{
    private String nationName;
    private String tribeName;
    private int tribeLifePoints;
    private ArrayList<People> members = new ArrayList<>();
    private ArrayList<People> livingMembers = new ArrayList<>();
    private BuildNationNaveed buildNationNaveed = new BuildNationNaveed();
    private BuildNationToyberg buildNationToyberg = new BuildNationToyberg();
    private BuildNationSmilons buildSmilons = new BuildNationSmilons();
    private BuildNationPerez buildNationPerez = new BuildNationPerez();
    private BuildSpecialEncounters buildSpecialEncounters = new BuildSpecialEncounters();


    /**
     * Create tribes under the given nation using the people types warrior, wizzard, healer.
     * Each tribe is given 1/3 of the life points.
     * @param lifePoints is the remaining health the tribe has.
     * @param nation the given nation name that the tribe will be located under.
     * @param tribe the name of the tribe
     */
    public Tribe(String nation, String tribe, int lifePoints)
    {
        nationName = nation;
        tribeName = tribe;
        tribeLifePoints = lifePoints;

        addPlayerstoNation();

        for(int i = 0; i < members.size(); i++)
            livingMembers.addAll(members);
    }

    /**
     * Checks for each nation and connects to another class that uses an interface
     * to add the players for each tribe.
     */
    private void addPlayerstoNation()
    {
        if (this.nationName.equals("Naveed"))
        {
            buildNationNaveed.add(members,nationName,tribeName,tribeLifePoints);
        }
        if (this.nationName.equals("Toyberg"))
        {
            buildNationToyberg.add(members,nationName,tribeName,tribeLifePoints);
        }
        if(this.nationName.equals("Perez"))
        {
            buildNationPerez.add(members,nationName,tribeName,tribeLifePoints);
        }
        if(this.nationName.equals("Smilons"))
        {
            buildSmilons.add(members,nationName,tribeName,tribeLifePoints);
        }
        if(this.nationName.equals("Special Encounter"))
        {
            buildSpecialEncounters.add(members,nationName,tribeName,tribeLifePoints);
        }
    }

    /**
     *Gets and returns the number of living tribe members based on the size of
     *the members array list. Also keeps track of the tribes current life points.
     * @return livingMembers
     */
    public ArrayList<People> getLivingTribeMembers()
    {
        livingMembers.clear();
        tribeLifePoints = 0;
        for(int person = 0; person < members.size(); person++)
        {
            if(members.get(person).isPersonAlive())
            {
                livingMembers.add(members.get(person));
                tribeLifePoints += members.get(person).getLifePoints();
                //System.out.println(members.get(person));
            }
            else
            {
                if(!(members.get(person).getDead()))
                {
                    members.get(person).setDead();
                    System.out.println("\t\t" + members.get(person) + " is dead!");
                }
            }
        }
        return livingMembers;
    }

    /**
     * @return size of the current living members
     * */
    public int getTribeSize()
    {
        return livingMembers.size();
    }

    /**
     * @return if tripe is alive
     */
    public Boolean isTribeAlive()
    {
        return (tribeLifePoints > 0);
    }

    /**
     * @return the number of life points remaining
     */
    public int getTribeLifePoints()
    {
        return tribeLifePoints;
    }

    /**
     * @return the name of the given tribe
     */
    public String getTribeName()
    {
        return tribeName;
    }

    /**
     * @return concat the tribe members to the tribe name
     */
    public String toString()
    {
        String result = "\0";

        result = tribeName;
        for(int i = 0; i < members.size(); i++)
        {
            result = result + '\n' + members.get(i).toString();
        }
        result = result + '\n';
        return result;
    }

}
