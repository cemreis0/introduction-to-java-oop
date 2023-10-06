package Ch13.SampleDevelopment;

public class Roster {
    public static void main(String[] args) {
        /*
        We cannot store integers and real numbers in the same array. To
        follow this rule, it seems necessary for us to declare two separate arrays, one for
        graduate students and another for undergraduate students. This rule, however, does
        not apply when the array elements are objects.
        */

        // We only need to declare a single array, for example,
        Student[] roster = new Student[40];

        GraduateStudent grad1, grad2;
        // both are not valid
        // grad1 = new Student();
        // grad2 = new UndergraduateStudent();

        for (int i = 0; i < 40; i++) {
            roster[i].computeCourseGrade(); // valid
        }
    }
}
