package Project02;

import Project02.PeopleType;

/**
 * Used to store, set, and get various values for individual player characters.
 *
 * It is also used to change each characters life point value, and determine whether or not a player is still alive.
 *
 * getDescription = player type (healer, warrior, or wizard)
 */
public abstract class People
{
    private String personName;
    private String myNation;
    private String myTribe;
    private PeopleType me;
    protected String myDescription;
    private int myLifePoints;
    private boolean dead;
    public final int MAX_LIFEPOINTS;


    /**
     * @param nation
     * Stores the String name of a nation
     * @param tribe
     * Stores the String name of a player's tribe
     * @param person
     * Reference to PeopleType, used to check player type (healer, warrior, wizard)
     * @param lifePoints
     * Stores life point value of a player
     */
    public People(String nation, String tribe, PeopleType person, int lifePoints)
    {
        myNation = nation;
        myTribe = tribe;
        me = person;
        myDescription = me.getDescription();
        myLifePoints = lifePoints;
        dead = false;
        MAX_LIFEPOINTS = lifePoints;
    }

    /**
     * Once life points hits 0, sets player as dead
     */
    public void setDead()
    {
        dead = true;
    }

    /**
     * @return
     * Returns current dead value for player (True or False)
     */
    public boolean getDead()
    {
        return dead;
    }

    /**
     * @return
     * Gets player type
     */
    public PeopleType getType()
    {
        return me;
    }

    /**
     * @return
     * Gets player tribe
     */
    public String getTribe()
    {
        return myTribe;
    }

    /**
     * @return
     * Gets player nation
     */
    public String getNation()
    {
        return myNation;
    }

    /**
     * @return
     * Check if player life point value is greater then 0
     */
    public Boolean isPersonAlive()
    {
        return (myLifePoints > 0);
    }

    /**
     * @return
     * Get current life point value
     */
    public int getLifePoints()
    {
        return myLifePoints;
    }

    /**
     * @param points
     * If current life point value exceeds max life points, set it back to the max.
     */
    public void modifyLifePoints(int points) {
        myLifePoints += points;
        if(myLifePoints > MAX_LIFEPOINTS){
            myLifePoints = MAX_LIFEPOINTS;
        }
    }

    /**
     * @param otherPerson
     * Reference to opponent
     * @return
     * abstract for PlayerType (ex: PerezHealer) classes
     */
    public abstract int encounterStrategy(People otherPerson);

    /**
     * @return
     * returns a String profile of the player (nation, tribe, player name, player type, and their remaining life points.
     */
    public String toString()
    {
        String result = new String( myNation + "\t" +  myTribe + "\t" + me
                + "\t" + myDescription + "\t" + myLifePoints);
        return result;
    }
}

