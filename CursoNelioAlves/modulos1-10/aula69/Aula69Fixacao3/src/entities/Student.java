package entities;

public class Student {

    public String name;
    public double trimester1;
    public double trimester2;
    public double trimester3;

    public double showFinalGrade(){
        double finalGrade = trimester1 + trimester2 + trimester3;
        return finalGrade;
    }

    public double missingPoints() {
        if(showFinalGrade() < 60) {
            return 60.0 - showFinalGrade();
        }
        else {
            return 0.0;
        }
    }

}
