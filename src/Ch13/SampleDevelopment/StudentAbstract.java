package Ch13.SampleDevelopment;

abstract class StudentAbstract {
    /*
    For the case where a student must be a graduate or an undergraduate student, we
    only need instances of GraduateStudent and UndergraduateStudent. So we must
    define the Student class in such a way that no instances of it can be created. One
    way is to define Student as an abstract class. An abstract class is a class defined with
    the modifier abstract, and no instances can be created from an abstract class.
    */

    protected final static int NUM_OF_TESTS = 3;
    protected String name;
    protected int[] test;
    protected String courseGrade;
    public StudentAbstract() {
        this("No name");
    }
    public StudentAbstract(String studentName) {
        name = studentName;
        test = new int[NUM_OF_TESTS];
        courseGrade = "****";
    }

    abstract public void computeCourseGrade(); // Abstract method has no method body, just a semicolon.

    public String getCourseGrade() {
        return courseGrade;
    }
    public String getName() {
        return name;
    }
    public int getTestScore(int testNumber) {
        return test[testNumber-1];
    }
    public void setName(String newName) {
        name = newName;
    }
    public void setTestScore(int testNumber,int testScore){
        test[testNumber-1] = testScore;
    }
}

