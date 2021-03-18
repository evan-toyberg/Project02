package Project02;

import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;
import Project02.Tribe;
import Project02.People;

public class Nation
{
    private int nationLifePoints;
    private String nationName;
    private ArrayList<Tribe> tribes = new ArrayList<>();
    private ArrayList<People> population = new ArrayList<>();
    private ArrayList<People> livingPopulation = new ArrayList<>();

    /**
     *
     * @param name  name of the nation
     * @param lifePoints number of lifepoints allotted for this nation
     * @param numWarriorsPerTribe Require 1 - the number of Warriors this Nation will have per tribe
     * @param numWizardsPerTribe  Require 1 - the number of Wizards this Nation will have per tribe
     * @param numHealersPerTribe  Require 1 - the number of Healers this Nation will have per tribe
     * @throws IllegalArgumentException total number of Warriors + Wizards + Healers must equal 6
     */
    public Nation(String name, int lifePoints, int numWarriorsPerTribe,
                  int numWizardsPerTribe, int numHealersPerTribe) throws IllegalArgumentException
    {
        nationName = name;
        nationLifePoints = lifePoints;
        if(numWarriorsPerTribe < 1 || numWizardsPerTribe < 1 || numHealersPerTribe < 1 ||
           numWarriorsPerTribe + numWizardsPerTribe + numHealersPerTribe != 6){
            throw new IllegalArgumentException("There must be at least one of each type and no more than 6 total people.");
        }
        for(int i = 1; i <=3 ; i++)
        {
            this.tribes.add(new Tribe(nationName, "Tribe" + i, nationLifePoints / 3));
        }
        population.addAll(getNationPopulation());
        livingPopulation.addAll(population);
    }


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
