package Project02;

import java.util.Random;

/**
 * The dice class has a single static roll() method that returns an int value between 0 and the number of
 * sides based on a pseudo random number generator.
 */
public class Dice {

    /**
     *
     * @param sides the number of sides on the die
     * @return random value from 0 to number of sides
     */
    public static int roll(int sides) {
        int val;
        Random random = new Random(System.currentTimeMillis());

        //sides is positive
        if(sides >= 0){ val = random.nextInt(sides + 1); }

        //if sides is a negative value, calculate return value using positive value
        // and return correct negative value
        else{
            val = random.nextInt(-sides + 1);
            return -val;
        }
        return val;
    }
}
