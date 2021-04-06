package Project02;

import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;

/**
 * This class creates named Nation objects with undefined number of life points.
 * Defines a Nation is made up of 3 Tribes, each tribe gets 1/3 of Nation's life points.
 * Keeps track of population of Nation and Tribes and determines if Nation and Tribes are alive or dead.
 */
public class Nation
{
    private int nationLifePoints;
    private String nationName;
    private ArrayList<Tribe> tribes = new ArrayList<>();
    private ArrayList<People> population = new ArrayList<>();
    private ArrayList<People> livingPopulation = new ArrayList<>();

    /**
     * Create a nation with name and number of lifepoints.
     * This nation has 3 tribes with equal amounts of lifepoints (nation's life points / 3)
     *
     * @param name name of the Nation
     * @param lifePoints number of lifepoints assigned to nation
     */
    public Nation(String name, int lifePoints)
    {
        nationName = name;
        nationLifePoints = lifePoints;

        if (!nationName.equals("Special Scenario"))
        {
            for(int i = 1; i <=3 ; i++)
            {
                this.tribes.add(new Tribe(nationName, "Tribe" + i, nationLifePoints / 3));
            }
        }
        else
        {
            this.tribes.add(new Tribe(nationName,"Animals", nationLifePoints / 3));
            this.tribes.add(new Tribe(nationName, "Character", nationLifePoints / 3));
            this.tribes.add(new Tribe(nationName, "Traps", nationLifePoints / 3));
        }

        population.addAll(getNationPopulation());
        livingPopulation.addAll(population);
    }

    /**
     * @return population of this nation
     */
    public ArrayList<People> getNationPopulation()
    {
        nationLifePoints = 0;
        livingPopulation.clear();
        for(int tribe = 0; tribe < this.tribes.size(); tribe++)
        {
            if(tribes.get(tribe).isTribeAlive())
            {
                //System.out.println(tribes.get(tribe));
                livingPopulation.addAll(tribes.get(tribe).getLivingTribeMembers());
                //System.out.println(tribes.get(tribe).getLivingTribeMembers());
                nationLifePoints += tribes.get(tribe).getTribeLifePoints();
            }
        }
        return livingPopulation;
    }

    /**
     * @return name of this nation
     */
    public String getNationName()
    {
        return nationName;
    }


    public void printTribesStatus()
    {
        for(int tribe = 0; tribe < 1; tribe++)
        {
            if(tribes.get(tribe).isTribeAlive())
            {
                System.out.print(tribes.get(tribe).getTribeName() + " is alive and has ");
                System.out.println(tribes.get(tribe).getTribeSize() + " members.");
            }
            else
            {
                System.out.println(tribes.get(tribe).getTribeName() + " is dead.");
            }
        }
    }

    public String toString()
    {
        String result = "\0";
        result = nationName;
        for(int i = 0; i < tribes.size(); i++)
        {
            result = result + '\n' + tribes.get(i).toString();

        }
        result = result + '\n';
        return result;
    }
}
