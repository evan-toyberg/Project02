package Project02;

import java.util.ArrayList;

/**
 * Interface that helps to add players to their individual nations and tribes.
 */
public interface AddPlayers
{
    void add(ArrayList<People> members, String nationName, String tribeName, int tribepoints);
}
