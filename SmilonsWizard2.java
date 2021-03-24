package Project02;


public class SmilonsWizard2 extends Project02.People {
    SmilonsWizard2(String nation, String tribe, int lifePoints) {
        super(nation, tribe, PeopleType.warrior, lifePoints);
        myDescription = "\tSmilons Wizard2";
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
        } else
        //Tribe1 wizard is very aggressive
        {
            if (this.getTribe().equals("Tribe1")) {
                lifePoints = this.getLifePoints();
            }
            //Tribe2 wizard is more conservative with life points contributed
            else if (this.getTribe().equals("Tribe2")) {
                lifePoints = this.getLifePoints()/2;
            } else
            //Tribe3 wizard will be very conservative
            {
                lifePoints = this.getLifePoints()/4;
            }
        }
        return lifePoints;
    }

}
