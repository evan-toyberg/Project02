package Project02;

import Project02.People;
import Project02.PeopleType;

public class SmilonsWarrior extends People {
    SmilonsWarrior(String nation, String tribe, int lifePoints) {
        super(nation, tribe, PeopleType.warrior, lifePoints);
        myDescription = "\tSmilons Warrior";
    }

    public int encounterStrategy(People otherPerson) {
        int lifePoints = 0;
        if (this.getNation() == otherPerson.getNation()) {
            if (otherPerson.getLifePoints() < this.getLifePoints()) {
                if (otherPerson.getTribe() == this.getTribe()) {
                    lifePoints = -((this.getLifePoints() - otherPerson.getLifePoints()) / 2);
                } else {
                    lifePoints = -((this.getLifePoints() - otherPerson.getLifePoints()) / 4);
                }
            }
        } else {
            //Tribe1 warrior will attack warriors will mre points
            if (this.getTribe().equals("Tribe1")) {
                if (otherPerson.getType().equals(PeopleType.warrior))
                    lifePoints = this.getLifePoints() / 2;
                else
                    lifePoints = this.getLifePoints() / 4;
            }
            //Tribe2 warrior attacks wizards with more points
            else if (this.getTribe().equals("Tribe2")) {
                if (otherPerson.getType().equals(PeopleType.wizard))
                    lifePoints = this.getLifePoints() / 2;
                else
                    lifePoints = this.getLifePoints() / 4;
            } else
            //Tribe3 warrior will be very aggressive
            {
                lifePoints = this.getLifePoints();
            }

        }
        return lifePoints;
    }

}
