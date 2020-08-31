/*class Student{
    String name;
    int regno;
    float cgpa;
    String schoolName;

    Student(String name, int regno, float cgpa, String schoolName){
        this.name = name;
        this.regno = regno;
        this.cgpa = cgpa;
        this.schoolName = schoolName;
    }
}

class program {
    public static void main(String[] args) {
        Student [] arrayStudents = new Student [5];
        arrayStudents[0] = new Student("abc", 1, 8.85f, "SCOPE");
        arrayStudents[1] = new Student("bc", 2, 7.85f, "SCOPE");
        arrayStudents[2] = new Student("c", 3, 9.85f, "SCOPE");
        arrayStudents[3] = new Student("d", 4, 6.85f, "SCOPE");
        arrayStudents[4] = new Student("e", 5, 9.02f, "SCOPE");

        // Display all the students with CGPA > 8

        for (int i = 0; i < 5; i++){
            if (arrayStudents[i].cgpa > 8.00f){
                Student current = arrayStudents[i];
                System.out.printf(
                    "Name : %s \t RegNo: %d \t CGPA: %f \t School Name: %s\n",
                    current.name,
                    current.regno,
                    current.cgpa,
                    current.schoolName
                );
            }
        }
    }
}
*/