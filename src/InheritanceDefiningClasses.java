public class InheritanceDefiningClasses {
    public static void main(String[] args) {
        /*
        What kind of objects should we use to model undergraduate and graduate
        students? There are basically two broad ways to design the classes to model them.
        The first way is to define two unrelated classes, one for undergraduate students
        and another for graduate students. We call the two classes unrelated classes if they
        are not connected in an inheritance relationship, that is, if neither one is an ancestor
        or descendant class of the other, and they do not share a common ancestor.1 The
        second way is to model undergraduate and graduate students by using classes that
        are related in an inheritance hierarchy.

        Defining two unrelated classes for entities that share common data or behavior would
        make class definition ineffective because we would end up duplicating
        code common to both classes. Although different, graduate and undergraduate
        students do share many common data and behaviors, so we will design these two
        classes by using inheritance.

        We will actually define three classes. The first is the Student class to incorporate
        behavior and data common to both graduate and undergraduate students. The
        second and third classes are the GraduateStudent class to incorporate behavior
        specific to graduate students and the UndergraduateStudent class to incorporate
        behavior specific to undergraduate students.
        */

        // The rest is in the Ch13.SampleDevelopment
    }
}