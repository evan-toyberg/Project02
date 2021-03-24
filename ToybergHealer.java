package Project02;

public class ToybergHealer extends Project02.People{

    ToybergHealer(String nation, String tribe, int lifePoints) {
        super(nation, tribe, Project02.PeopleType.healer, lifePoints);
        myDescription = "\tToyberg Healer";
    }

    public int encounterStrategy(Project02.People otherPerson) {
        int lifePoints = 0;
        if (this.getNation() != otherPerson.getNation()){
            lifePoints = - this.getLifePoints(); // run away
        }

        else{
            if (otherPerson.getLifePoints() < this.getLifePoints()) {  // heal a friend
                lifePoints = (int) (this.getLifePoints() - otherPerson.getLifePoints() / 2);
            }
            else{
                lifePoints = 0;
            }
        }
        return lifePoints;
    }

}