public class InheritanceAndConstructors {
    public static void main(String[] args) {
        // Unlike other members of a superclass, constructors of a superclass are not inherited by its subclasses.


    }
}

class Vehicle {
    // data members
    private String vin;

    // constructors
    public Vehicle(String vin) {
        this.vin = vin;
    }

    public String getVin() {
        return vin;
    }
}

class Truck extends Vehicle {
    // data members
    private int cargoWeightLimit;

    // constructors
    public Truck(int cargoWeightLimit, String vin) {
        super(vin); // You need to make this call. Otherwise, the compiler will add super(),
                    // which will result in an error because there is no matching constructor in Vehicle.
        this.cargoWeightLimit = cargoWeightLimit;
    }

    public void setCargoWeightLimit(int cargoWeightLimit) {
        this.cargoWeightLimit = cargoWeightLimit;
    }

    public int getCargoWeightLimit() {
        return cargoWeightLimit;
    }
}