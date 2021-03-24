package Project02;


public class ToybergWizard extends People {

    ToybergWizard(String nation, String tribe, int lifePoints) {
        super(nation, tribe, Project02.PeopleType.wizard, lifePoints);
        myDescription = "\tToyberg Wizard";
        boolean spellLearned = false;
    }

    public int encounterStrategy(People otherPerson) {
        int lifePoints = 0;
        if (this.getNation() != otherPerson.getNation()){
            if (otherPerson.getLifePoints() < this.getLifePoints()){
                if (otherPerson.getType() == Project02.PeopleType.warrior){ // run away
                    lifePoints = -this.getLifePoints();
                }
                else{ // attack a wizard
                    lifePoints = (int) (this.getLifePoints()/2);
                }
            }
        }
//        else
//        {
//            if (otherPerson.getLifePoints() < this.getLifePoints()){ // heal a friend
//                lifePoints = (int) (this.getLifePoints() - otherPerson.getLifePoints() / 2);
//            }
//            else{
//                lifePoints = 0;
//            }
//        }
        return lifePoints;
    }

}
