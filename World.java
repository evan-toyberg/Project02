package Project02;

import Project02.Nation;
import Project02.People;
import java.util.*;

public class World
{
    private final int worldLifePoints = 4000;
    private final int numberOfRounds = 40;
    private ArrayList<Nation> allNations = new ArrayList<>();
    private ArrayList<Nation> allLivingNations = new ArrayList<>();


    Random generator;
    ArrayList<People> worldCreatedPeople = new ArrayList<>();



    public World()
    {
        // seed for psuedo-random number generator
        Date seed = new Date();
        generator = new Random(seed.getTime());
        createWorld();
        worldCreatedPeople.addAll(getWorldCreatedPopulation());
    }

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



    public void createWorld()
    {
        // add Nations participating in the game to nations ArrayList.
//        String[] nationNames = {"Smilons", "Naveed", "Perez", "Toyberg"};
//        for(String name : nationNames){
//            allNations.add(new Nation(name, worldLifePoints / nationNames.length));

            allNations.add(new Nation("Toyberg", worldLifePoints / 4, 3, 2, 1));
            allNations.add(new Nation("Smilons", worldLifePoints / 4, 2, 2, 2));
            allNations.add(new Nation("Perez", worldLifePoints / 4, 2, 3, 1));
            allNations.add(new Nation("Naveed", worldLifePoints / 4, 2, 2, 2));

    }


    public ArrayList<People> getWorldCreatedPopulation()
    {
        ArrayList<People> livingPeople = new ArrayList<>();
        // add all living people from allNations to livingPeople
        for(int nation = 0; nation < allNations.size(); nation++)
            livingPeople.addAll(allNations.get(nation).getNationPopulation());
        //System.out.println(livingPeople);
        return livingPeople;
    }


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


    public void encounter(Integer p1, Integer p2)
    {
        Integer person1LifePointsToUse;
        Integer person2LifePointsToUse;
        People person1 = worldCreatedPeople.get(p1);
        People person2 = worldCreatedPeople.get(p2);

        System.out.println("Encounter: " + person1 + person2);

        //if lifePointsToUse is negative, then person is either running away in a hostile encounter
        // or person is giving life points to another person from same nation
        person1LifePointsToUse = person1.encounterStrategy(person2);
        person2LifePointsToUse = person2.encounterStrategy(person1);

        // amount of life points actually used is subject to a psuedo-random encounter
        Integer p1damage =  (int) (generator.nextFloat() * person1LifePointsToUse);
        Integer p2damage =  (int) (generator.nextFloat() * person2LifePointsToUse);

        if ((p1damage > 0) && (p2damage > 0))  // person 1  and person 2 are fighting and inflicting damage
        {
            p2damage =  (int) (generator.nextFloat() * (person1.getType().ordinal()+1)*p1damage);
            p1damage =  (int) (generator.nextFloat() * (person2.getType().ordinal()+1)*p2damage);
        }
        else if ((p1damage > 0) && (p2damage <= 0)) // person 1 is fighting and person 2 is running
        {
            p2damage =  (int) (generator.nextFloat() * (person1.getType().ordinal()+1)*(p1damage/3));
        }
        else if ((p1damage <= 0) && (p2damage > 0)) // person 2 is fighting and person 1 is running
        {
            p1damage =  (int) (generator.nextFloat() * (person2.getType().ordinal()+1)*(p2damage/3));
        }
        else // freindly encounter, do nothing
        {

        }

        // record the damage: positive damage should be subtracted for persons lifePoint
        // negative damage is added to persons life points
        person1.modifyLifePoints((-p2damage));
        person2.modifyLifePoints((-p1damage));

        // Both people lose 1 life point per encounter due to aging
        person1.modifyLifePoints((-1));
        person2.modifyLifePoints((-1));

    }


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
