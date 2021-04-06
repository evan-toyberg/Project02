package Project02;
/**
 * Using enum this class represents
 * the different people located inside of a tribe.
 * Each person has a description of their role in the game.
 */
public enum PeopleType
{
    wizard  ("wizard"),
    warrior ("warrior"),
    healer ("healer"),
    SpecialEncounter ("Special Encounter");

    private String description;

    /**
     * @param types takes the current people type and sets the associated
     *              description along with that type.
     */
    PeopleType (String types)
    {
        description = types;
    }

    /**
     * @return the description of the people type.
     */
    public String getDescription()
    {
        return description;
    }
}
