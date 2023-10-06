/*
    Chapter 13 Sample Program: Student
*/

package Ch13.SampleDevelopment;

public class Student {
    // data members
    // Protected fields are visible to the descendant objects
    protected final static int NUMBER_OF_TESTS = 3;
    protected String name;
    protected int[] test;
    protected String courseGrade;

    // constructors
    public Student() {

    }
    public Student(String name) {
        this.name = name;
        test = new int[NUMBER_OF_TESTS];
        courseGrade = "****";
    }

    public String getCourseGrade() {
        return courseGrade;
    }

    public String getName() {
        return name;
    }

    public int getTestScore(int testNumber) {
        return test[testNumber-1];
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTestScore(int testNumber, int testScore) {
        test[testNumber-1] = testScore;
    }

    public void computeCourseGrade(){
        //do nothing - override this method in the subclass
    }
}

// We define the classes UndergraduateStudent and GraduateStudent as subclasses of the Student class.
// In Java, we say a subclass extends its superclass.

class GraduateStudent extends Student {
    // constructors
    public GraduateStudent() {
        super();
    }
    public GraduateStudent(String name) {
        super(name);
    }

    @Override
    public void computeCourseGrade() {
        int total = 0;

        for (int i = 0; i < NUMBER_OF_TESTS; i++) {
            total += test[i];
        }

        if (total/NUMBER_OF_TESTS >= 80) {
            courseGrade = "Pass";
        } else {
            courseGrade = "Fail";
        }
    }
}

class UndergraduateStudent extends Student {
    // constructors
    public UndergraduateStudent() {
        super();
    }
    public UndergraduateStudent(String name) {
        super(name);
    }

    @Override
    public void computeCourseGrade() {
        int total = 0;

        for (int i = 0; i < NUMBER_OF_TESTS; i++) {
            total += test[i];
        }

        if (total/NUMBER_OF_TESTS >= 70) {
            courseGrade = "Pass";
        } else {
            courseGrade = "Fail";
        }
    }
}