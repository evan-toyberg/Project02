package Project02;

import Project02.People;
import Project02.PeopleType;

import static Project02.PeopleType.wizard;


public class ToybergWarrior2 extends People {

    ToybergWarrior2(String nation, String tribe, int lifePoints) {
        super(nation, tribe, PeopleType.warrior, lifePoints);
        myDescription = "\tToyberg Warrior2";
    }

    public int encounterStrategy(People otherPerson) {
        int lifePoints = 0;
        if(this.getNation().equals(otherPerson.getNation())){ // friendly encounter
            if(otherPerson.getLifePoints() < this.getLifePoints()){ // heal friendly
                if(otherPerson.getTribe().equals(this.getTribe())){
                    lifePoints = -((this.getLifePoints() - otherPerson.getLifePoints()) / 2); // bonus if same tribe
                }
                else{
                    lifePoints = -((this.getLifePoints() - otherPerson.getLifePoints()) / 4);
                }
            }
        }

        else{
            if(getLifePoints() > this.MAX_LIFEPOINTS / 2){
                lifePoints = this.getLifePoints();
            }

            /*
             * does more than normal damage in return for small loss in health
             */
            else if(getLifePoints() < this.MAX_LIFEPOINTS / 2 && this.getLifePoints() > otherPerson.getLifePoints()){
                lifePoints = this.getLifePoints();
                modifyLifePoints(-this.getLifePoints() / 10);
            }

            else{
                lifePoints = this.getLifePoints() / 2;
            }

        }



        return lifePoints;
    }
}
