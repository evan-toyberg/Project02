package Project02;

import Project02.People;
import Project02.PeopleType;

import static Project02.PeopleType.wizard;


public class ToybergWarrior2 extends People{

    ToybergWarrior2(String nation, String tribe, int lifePoints){
        super(nation, tribe, PeopleType.warrior, lifePoints);
        myDescription = "\tToyberg Warrior2";
    }

    boolean strengthBoost = false;
    int numBandages = 1;

    public int encounterStrategy(People otherPerson) {
        int lifePoints = 0;
        if(this.getNation().equals(otherPerson.getNation())){ // friendly encounter
            if(otherPerson.getType() == this.getType()){ // give strength boost if both friendly warriors
                this.strengthBoost = true;
            }
            if(otherPerson.getType() == PeopleType.healer){ // gives a bandage if encounters friendly healer
                numBandages ++;
            }
            if(otherPerson.getLifePoints() < this.getLifePoints()){ // heal friendly
                if(otherPerson.getTribe().equals(this.getTribe())){
                    lifePoints = -((this.getLifePoints() - otherPerson.getLifePoints()) / 2); // bonus if same tribe
                }
                else{
                    lifePoints = -((this.getLifePoints() - otherPerson.getLifePoints()) / 4);
                }
            }
        }


        else{       // hostile encounter
            int points = this.getLifePoints() - otherPerson.getLifePoints();
            if(otherPerson.getType() == wizard){ // this warrior is extremely effective against enemy wizards
                lifePoints = (this.getLifePoints() * 4/3);
            }

            else if(getLifePoints() > this.MAX_LIFEPOINTS / 2){ // if more than 1/2 health
                lifePoints = this.getLifePoints();
            }

            else if (points > 0 && getLifePoints() < this.MAX_LIFEPOINTS / 2){ // if less than 1/2 health
                if(getLifePoints() > MAX_LIFEPOINTS / 20){  // increase damage for loss in health
                    lifePoints = this.getLifePoints() + MAX_LIFEPOINTS / 20;
                    modifyLifePoints(-MAX_LIFEPOINTS / 20);
                }

                else if(points < 0 && getLifePoints() < this.MAX_LIFEPOINTS / 2){ // do some extra damage in return for health
                    useBandage();
                    lifePoints = this.getLifePoints();
                }
            }
        }

        if(this.strengthBoost){
            this.strengthBoost = false;
            return lifePoints + MAX_LIFEPOINTS / 10;
        }

        return lifePoints;
    }

    private void useBandage(){
        numBandages -= 1;
        modifyLifePoints(MAX_LIFEPOINTS / 10);
    }
}
