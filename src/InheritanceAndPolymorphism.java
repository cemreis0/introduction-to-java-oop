public class InheritanceAndPolymorphism {
    public static void main(String[] args) {
        Pet pet = new Pet();
        System.out.println(pet.speak());

        Cat cat = new Cat();
        System.out.println(cat.speak());

        /*
        We call the Cat class the subclass or derived class and the Pet class the superclass or
        base class. We use the reserved word extends to define a subclass. Data members
        and methods of a superclass are inherited by its subclasses.
        */

        cat.setName("Cha Cha");
        System.out.println("Hi, my name is " + cat.getName());

        /*
        In the Cat class, we see that the body of the speak method is different. We say
        the Cat class overrides the speak method.
        */

        /*
        We can also define additional methods and data members to a subclass.
        Dog class have the method fetch.
        */

        Dog dog = new Dog();
        dog.setName("Fifi");
        System.out.println(dog.getName() + " says:");
        System.out.println(dog.speak());
        System.out.println(dog.fetch());

        /*

        */

        Pet petOne = new Dog(); // works
        Pet petTwo = new Cat(); // works
        // Dog dogOne = new Pet(); does not work

        /*
        The fact that the same variable can be referring to an instance of a different
        class results in polymorphism.
        */

        Pet p;

        p = new Dog();
        System.out.println(p.speak());

        p = new Cat();
        System.out.println(p.speak());

        // The speak method is called a polymorphic method.

        /*
        If a variable is declared of type S and is referring to an instance of a subclass
        of S, then we must typecast the variable to the subclass when calling non-inherited
        methods of the subclass.
        */

        Pet p1;

        p1 = new Dog();
        // System.out.println(p.fetch); does not work
        System.out.println(((Dog)p1).fetch()); // we must typecast p1 to Dog
    }
}

class Pet {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String speak() {
        return "I'm your cuddly pet.";
    }
}

// extends indicated Cat is a subclass of Pet
class Cat extends Pet {
    @Override
    public String speak() {
        return "Don't give me orders. I speak only when I want to.";
    }
}

class Dog extends Pet {
    public String fetch() {
        return "Yes, master. Fetch I will.";
    }
}

// Quick Check 1
class Reptile extends Pet {
    @Override
    public String speak() {
        return "";
    }
}