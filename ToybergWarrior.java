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
            if(points > 0){
                lifePoints = this.getLifePoints();
            }

            else{
                if(this.strengthBoost){
                    this.strengthBoost = false;
                    return lifePoints + this.MAX_LIFEPOINTS / 10;
                }
                lifePoints = this.getLifePoints() / 2;
            }

        }

        return lifePoints;
    }

    /**
     * uses a disposable bandage to heal injuries. Character begins with 1 bandage and
     * gets one additional each time he encounters a friendly healer
     */
    private void useBandage(){
        numBandages -= 1;
        modifyLifePoints(this.MAX_LIFEPOINTS / 10);
    }
}
