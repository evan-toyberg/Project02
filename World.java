package Project02;

import java.util.*;

/**
 * Runs the game and prints out the encounters of each round.
 * Prints out the surviving nation or no nations.
 * Operates the damage of the two players.
 */
public class World
{
    private final int worldLifePoints = 9000;
    private final int numberOfRounds = 100;
    private ArrayList<Nation> allNations = new ArrayList<>();
    private ArrayList<Nation> allLivingNations = new ArrayList<>();


    //Random generator;
    // Use Dice.roll(int sides) instead of random number generator
    ArrayList<People> worldCreatedPeople = new ArrayList<>();



    public World()
    {
        // seed for psuedo-random number generator
        //Date seed = new Date();
        //generator = new Random(seed.getTime());
        createWorld();
        worldCreatedPeople.addAll(getWorldCreatedPopulation());
    }

    /**
     * Runs the game and calling out methods of the encounters
     * After the encounters, it prints out the surviving nation
     * or no nation at all.
     */
    public void war()
    {
        ArrayList<Integer> worldSurvivingPeople = new ArrayList<>();

        for(int round = 1; round < numberOfRounds; round++)
        {
            Set<String> survivingNations = new HashSet<>();
            System.out.println("Round number: " + round);
            worldSurvivingPeople.clear();
            worldSurvivingPeople.addAll(getWorldSurvivingPeople());
            survivingNations.addAll(getSurvivingNations());
            if ((worldSurvivingPeople.size() >= 2) && (survivingNations.size() > 1) )
                playOneRound(worldSurvivingPeople);
            else
            {
                System.out.print("Game is over! Winning Nation is: ");
                if (survivingNations.size() == 0)
                {
                    System.out.println("All Nations Distroyed.");
                }
                else
                {
                    System.out.println(survivingNations);
                    System.out.println("The survivors are:");
                    for (Integer i = 0; i < worldSurvivingPeople.size(); i++)
                    {
                        System.out.println(worldCreatedPeople.get(worldSurvivingPeople.get(i)));
                    }
                }
                break;
            }

        }

    }


    /**
     * Creates the 4 nations in the world and calling out nation
     * to make the tribes.
     */
    public void createWorld()
    {
        // add Nations participating in the game to nations ArrayList.
        String[] nationNames = {"Smilons", "Naveed", "Perez", "Toyberg", "Special Scenario"};
        for(String name : nationNames){
            allNations.add(new Nation(name, (worldLifePoints / nationNames.length)));
        }
    }

    /**
     * This method adds the created nations into the ArrayList
     * @return
     */
    public ArrayList<People> getWorldCreatedPopulation()
    {
        ArrayList<People> livingPeople = new ArrayList<>();
        // add all living people from allNations to livingPeople
        for(int nation = 0; nation < allNations.size(); nation++)
            livingPeople.addAll(allNations.get(nation).getNationPopulation());
        //System.out.println(livingPeople);
        return livingPeople;
    }

    /**
     * This method adds the players that are alive.
     * @return
     */
    public ArrayList<Integer> getWorldSurvivingPeople()
    {
        ArrayList<Integer> survivors = new ArrayList<>();
        for (Integer i = 0; i < worldCreatedPeople.size(); i++)
        {
            if(worldCreatedPeople.get(i).isPersonAlive())
            {
                survivors.add(i);
            }
        }
        return survivors;
    }

    /**
     * Adding nations in the allLivingNations ArrayList if they are alive.
     * @return
     */
    public Set<String> getSurvivingNations()
    {
        Set<String> survivingNations = new HashSet<>();

        for (Integer i = 0; i < worldCreatedPeople.size(); i++)
        {
            if(worldCreatedPeople.get(i).isPersonAlive())
            {
                survivingNations.add(worldCreatedPeople.get(i).getNation());
            }
        }
        return survivingNations;
    }

    /**
     * This method takes a parameter of two people and checks if the two people are not from the same
     * nation. Then the two people fight each other and both loses damage. It prints out a statement
     * of the life points of each other.
     * @param p1 A person from the People class
     * @param p2 A person from the People class
     */
    public void encounter(Integer person1, Integer person2)
    {
        Integer person1LifePointsToUse;
        Integer person2LifePointsToUse;
        System.out.println("Encounter: " + worldCreatedPeople.get(person1) + worldCreatedPeople.get(person2));

        //if lifePointsToUse is negative, then person is either running away in a hostile encounter
        // or person is giving life points to another person from same nation
        person1LifePointsToUse = worldCreatedPeople.get(person1).encounterStrategy(worldCreatedPeople.get(person2));
        person2LifePointsToUse = worldCreatedPeople.get(person2).encounterStrategy(worldCreatedPeople.get(person1));

        // amount of life points actually used is subject to a psuedo-random encounter
        Integer p1damage =  (int) (Dice.roll(person1LifePointsToUse));
        Integer p2damage =  (int) (Dice.roll(person2LifePointsToUse));

        if ((p1damage > 0) && (p2damage > 0))  // person 1  and person 2 are fighting and inflicting damage
        {
            p2damage =  (int) (Dice.roll((worldCreatedPeople.get(person1).getType().ordinal()+1)*p1damage));
            p1damage =  (int) (Dice.roll((worldCreatedPeople.get(person2).getType().ordinal()+1)*p2damage));
        }
        else if ((p1damage > 0) && (p2damage <= 0)) // person 1 is fighting and person 2 is running
        {
            p2damage =  (int) (Dice.roll((worldCreatedPeople.get(person1).getType().ordinal()+1)*(p1damage/3)));
        }
        else if ((p1damage <= 0) && (p2damage > 0)) // person 2 is fighting and person 1 is running
        {
            p1damage =  (int) (Dice.roll((worldCreatedPeople.get(person2).getType().ordinal()+1)*(p2damage/3)));
        }
        else // freindly encounter, do nothing
        {

        }

        // if one of the people is a special encounter
        // interact if dice lands on an even #
        // else ignore the encounter
        if ((worldCreatedPeople.get(person1).getType() == PeopleType.SpecialEncounter)
                || (worldCreatedPeople.get(person2).getType() == PeopleType.SpecialEncounter))
        {
            if (Dice.roll(6) % 2 == 0) // if the number is even, then encounter is ignored
            {
                p2damage = 0;
                p1damage = 0;
            }
            else // else, the number is odd, and the encounter is ignored
            {

            }
        }


        // record the damage: positive damage should be subtracted for persons lifePoint
        // negative damage is added to persons life points
        worldCreatedPeople.get(person1).modifyLifePoints((-p2damage));
        worldCreatedPeople.get(person2).modifyLifePoints((-p1damage ));

        // Both people lose 1 life point per encounter due to aging
        worldCreatedPeople.get(person1).modifyLifePoints((-1));
        worldCreatedPeople.get(person2).modifyLifePoints((-1));

    }

    /**
     * This method plays every round and prints out the round number
     * and the number of players encountering in that round.
     * @param combatants An Arraylist of nations
     */
    public void playOneRound(ArrayList<Integer> combatants)
    {
        System.out.println(combatants.size());
        ArrayList<Integer> survivors = new ArrayList<>();
        Integer numberOfCombatants;
        Collections.shuffle(combatants);
        numberOfCombatants = combatants.size() - 1;
        Integer combatantIndex = 0;
        while(combatantIndex < numberOfCombatants)
        {
            encounter(combatants.get(combatantIndex), combatants.get(combatantIndex+1));
            combatantIndex = combatantIndex + 2;
        }
    }



}
