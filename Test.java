class Person {
    String name;
    int day;
    int month;
    int year;
    Person(String name, int day, int month, int year){
        this.name = name;
        this.day = day;
        this.month = month;
        this.year = year;
    }
}

class Student extends Person {
    int regNo;
    int modeOfStudy;
    String schoolName;
    int mark1, mark2, mark3;

    Student (String name, int day, int month, int year, int regNo, int modeOfStudy, String schoolName, int mark1, int mark2, int mark3){
        super(name, day, month, year);
        this.regNo = regNo;
        this.modeOfStudy = modeOfStudy;
        this.schoolName = schoolName;
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.mark3 = mark3;
    }
}

class VITAdmission2020 extends Student {
    float avg;
    VITAdmission2020(String name, int day, int month, int year, int regNo, int modeOfStudy, String schoolName, int mark1, int mark2, int mark3){
        super(name, day, month, year, regNo, modeOfStudy, schoolName, mark1, mark2, mark3);
        this.avg = (super.mark1 + super.mark2 + super.mark3)/3.0f;
    }

    boolean checkEligibility(){
        if (super.year == 1998){
            if (super.month < 7){
                return false;
            }
            else {
                if (month == 7 && day > 1){
                    if (this.avg > 0.5f){
                        return true;
                    }
                    else {
                        return false;
                    }
                }
                return false;
            }
        }
        else if (super.year > 1998){
            if (this.avg > 0.5f){
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }
}