package Ch4.BicycleRegistration;

public class BicycleRegistration {
    public static void main(String[] args) {
        register();
    }
        public static void register() {
        Bicycle bike1, bike2;
        String owner1, owner2;
        String no1, no2;

        bike1 = new Bicycle(); // create and assign values to bike1
        bike1.setOwnerName("Cem Reis");
        bike1.setTagNo("2023-134R");

        bike2 = new Bicycle(); // create and assign values to bike2
        bike2.setOwnerName("Adam Smith");
        bike2.setTagNo("2023-135A");

        // output the information
        owner1 = bike1.getOwnerName();
        owner2 = bike2.getOwnerName();

        no1 = bike1.getTagNo();
        no2 = bike2.getTagNo();

        System.out.println(owner1 + " owns a bicycle with tag number " + no1);
        System.out.println(owner2 + " also owns a bicycle with tag number " + no2);
    }
}

class Bicycle {
    // data member
    private String ownerName;
    private String tagNo;

    // constructor: initializes the data member
    public Bicycle() {
        ownerName = "Unassigned";
        tagNo = "Unassigned";
    }

    // returns the name of this bicycle's owner
    public String getOwnerName() {
        return ownerName;
    }

    // assigns the name of this bicycle's owner
    public void setOwnerName(String name) {
        ownerName = name;
    }

    public String getTagNo() {
        return tagNo;
    }

    public void setTagNo(String no) {
        tagNo = no;
    }
}
