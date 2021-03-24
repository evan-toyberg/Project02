package Project02;

import Project02.People;
import Project02.PeopleType;

import static Project02.PeopleType.*;

public class ToybergHealer2 extends Project02.People {

    ToybergHealer2(String nation, String tribe, int lifePoints) {
        super(nation, tribe, healer, lifePoints);
        myDescription = "\tToyberg Healer2";
    }

    public int encounterStrategy(Project02.People otherPerson) {
        int lifePoints = 0;
        if(!this.getNation().equals(otherPerson.getNation())){
            if(this.getLifePoints() > MAX_LIFEPOINTS / 3){
                if(otherPerson.getType() == healer){ // attack hostile healers using half health
                    lifePoints = this.getLifePoints() / 2;
                }
                else if(otherPerson.getType() == wizard || otherPerson.getType() == warrior){
                    lifePoints = this.getLifePoints() / 4; // attack other combatants using lower health
                }
            }
            else{
                lifePoints = -this.getLifePoints(); // run away
            }
        }


        else{
            if(this.getTribe().equals("Tribe2")){ // master healers from this tribe are extremely efficient at treating battle wounds
                return otherPerson.MAX_LIFEPOINTS;
            }
            else if(otherPerson.getLifePoints() < this.getLifePoints()){  // heal a friend
                if(otherPerson.getTribe().equals(this.getTribe())){
                    lifePoints = (int) this.getLifePoints();
                }
                lifePoints = (int) (this.getLifePoints() - otherPerson.getLifePoints() / 2);
            }
            else{
                lifePoints = 0;
            }
        }
        return lifePoints;
    }

}