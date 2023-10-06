public class AbstractSuperclassesAndAbstractMethods {
    public static void main(String[] args) {
        /*
        An abstract method is a method with the keyword abstract, and it ends with a semicolon
        instead of a method body. A class is abstract if the class contains an abstract
        method or does not provide an implementation of an inherited abstract method. We
        say a method is implemented if it has a method body. If a subclass has no abstract
        methods and no unimplemented inherited abstract methods (and does not include
        the keyword abstract in its class definition), then the subclass is no longer abstract,
        and thus its instances can be created.

        An abstract class must include the keyword abstract in its definition. Notice
        that the abstract class Student has an incomplete definition because the class
        includes the abstract method computeCourseGrade that does not have a method
        body. The intent is to let its subclasses provide the implementation of the computeCourseGrade method.
        If a subclass does not provide an implementation of the
        inherited abstract method, the subclass is also an abstract class, and therefore, no
        instances of the subclass can be created. Since an abstract class can only make sense
        when it is a superclass, we frequently use the term abstract superclass.
        */

        // The sample code is in the Ch13.SampleDevelopment.StudentAbstract
    }
}
