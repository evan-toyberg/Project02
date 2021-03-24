package Project02;


public class ToybergWarrior extends Project02.People {

    ToybergWarrior(String nation, String tribe, int lifePoints){
        super(nation, tribe, Project02.PeopleType.warrior, lifePoints);
        myDescription = "\tToyberg Warrior";
    }

    boolean strengthBoost = false;
    int numBandages = 1;

    public int encounterStrategy(Project02.People otherPerson) {
        int lifePoints = 0;
        if(this.getNation() == otherPerson.getNation()){
            if(otherPerson.getType() == this.getType()){ // give strength boost if both friendly warriors
                this.strengthBoost = true;
            }
            if(otherPerson.getType() == Project02.PeopleType.healer){
                numBandages ++;
            }
            if(otherPerson.getLifePoints() < this.getLifePoints()){
                if(otherPerson.getTribe() == this.getTribe()){
                    lifePoints = -((this.getLifePoints() - otherPerson.getLifePoints()) / 2);
                }
                else{
                    lifePoints = -((this.getLifePoints() - otherPerson.getLifePoints()) / 4);
                }
            }
        }


        else{
            int points = this.getLifePoints() - otherPerson.getLifePoints();
            if(getLifePoints() > this.MAX_LIFEPOINTS / 2){
                lifePoints = this.getLifePoints();
            }

            else if (points > 0 && getLifePoints() < this.MAX_LIFEPOINTS / 2){ // if less than 1/2 health
                if(getLifePoints() > 2){
                    lifePoints = this.getLifePoints();
                    modifyLifePoints(-2);
                }

                else if(points < 0 && getLifePoints() < this.MAX_LIFEPOINTS / 2){ // do some extra damage in return for health
                    lifePoints = this.getLifePoints();
                    useBandage();
                }
            }
        }

        if(this.strengthBoost){
            this.strengthBoost = false;
            return lifePoints + 5;
        }

        return lifePoints;
    }

    private void useBandage(){
        numBandages -= 1;
        modifyLifePoints(5);
    }
}
