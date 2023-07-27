/*
 * Chapter 5 Development Exercise 20
 *
 * Expressimo Delivery Service Application
 *
 * This application computes the delivery charge for packages based on their type
 * (letter or box), type of service (Next Day Priority, Next Day Standard, or 2-Day),
 * and weight of the package.
 *
 * Charge Formula:
 * Package Type   | Next Day Priority | Next Day Standard | 2-Day
 * -------------------------------------------------------------
 * Letter         | $12.00, up to 8 oz | $10.50, up to 8 oz | Not available
 * Box            | $15.75 for the first pound. Add $1.25 for each additional pound
 *                | $13.75 for the first pound. Add $1.00 for each additional pound
 *                | $7.00 for the first pound. Add $0.50 for each additional pound
 *
 * User Inputs:
 * 1. Type of package (Letter or Box)
 * 2. Type of service (Next Day Priority, Next Day Standard, or 2-Day)
 * 3. Weight of the package
 *
 * The program will calculate and display the delivery charge based on the provided inputs.
 */


package Ch5.Ch5DevEx;

import java.util.Scanner;

public class Expressimo {
    public static void main(String[] args) {
        String packageType, packageService;
        double packageWeight;

        Package pack;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a package type (Letter, Box): ");
        packageType = scanner.nextLine();
        System.out.print("Enter the package weight (oz for Letter, lb for Box): ");
        packageWeight = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter a service (NDP - Next Day Priority, NDS - Next Day Standard, 2D - 2-Day): ");
        packageService = scanner.nextLine();

        pack = new Package(packageType, packageService, packageWeight);

        System.out.println(
                "     Package type: " + pack.getType() + "\n" +
                " Selected service: " + pack.getService() + "\n" +
                "   Package weight: " + pack.getWeight() + "\n" +
                "          Charge: $" + pack.getCharge()
        );
    }
}

class Package {
    // data members
    private String type;
    private String service;
    private double weight;

    // constructor
    public Package(String givenType, String givenService, double givenWeight) {
        type = givenType;
        service = givenService;
        weight = givenWeight;
    }

    public double getCharge() {
        double charge = -1;
        if (type.equals("Letter")) {
            charge = calculateLetterCharge(weight, service);
        } else if (type.equals("Box")) {
            charge = calculateBoxCharge(weight, service);
        } else {
            System.out.println("Package type is not valid");
        }

        if (charge == 1) {
            System.out.println("An error occurred.");
        }

        return charge;
    }

    private double calculateLetterCharge(double letterWeight, String letterService) {
        double letterCharge = -1; // -1 is the error code

        final double NDP_CHARGE_PER_OZ = 12.00; // next day priority charge per oz
        final double NDS_CHARGE_PER_OZ = 10.50; // next day standard charge per oz

        if (letterService.equals("NDP")) {
            if (letterWeight > 8) {
                System.out.println("The weight limit for a letter in Next Day Priority Service is 8 oz.");
            } else if (letterWeight <= 8 && letterWeight > 0) { // letter weight is in ons (oz)
                letterCharge = NDP_CHARGE_PER_OZ;
            } else {
                System.out.println("Weight entered is not valid.");
            }
        } else if (letterService.equals("NDS")) {
            if (letterWeight > 8) {
                System.out.println("The weight limit for a letter in Next Day Standard Service is 8 oz.");
            } else if (letterWeight <= 8 && letterWeight > 0) {
                letterCharge = NDS_CHARGE_PER_OZ;
            } else {
                System.out.println("Weight entered is not valid.");
            }
        } else if (letterService.equals("2D")) {
            System.out.println("2-Day service is not available for letters.");
        } else {
            System.out.println("Service name is not found.");
        }

        if (letterCharge == -1) {
            System.out.println("An error occurred.");
        }

        return letterCharge;
    }

    private double calculateBoxCharge(double boxWeight, String boxService) {
        double boxCharge = -1; // -1 is the error code

        final double NDP_CHARGE_FIRST_LB= 15.75; // next day priority charge for the first lb
        final double NDP_CHARGE_PER_LB = 1.25; // next day priority charge for each additional lb over the first lb
        final double NDS_CHARGE_FIRST_LB = 13.75; // next day standard charge for the first lb
        final double NDS_CHARGE_PER_LB = 1.00; // next day standard charge for each additional lb over the first lb
        final double TWO_D_CHARGE_FIRST_LB= 7.00; // 2-Day charge for the first lb
        final double TWO_D_CHARGE_PER_LB = 0.50; // 2-Day charge for each additional lb over the first lb

        if (boxService.equals("NDP")) {
            if (boxWeight > 1) {
                boxCharge = NDP_CHARGE_FIRST_LB + (NDP_CHARGE_PER_LB * (boxWeight - 1));
            } else if (boxWeight < 1 && boxWeight > 0) {
                boxCharge = NDP_CHARGE_FIRST_LB;
            } else {
                System.out.println("Weight entered is not valid.");
            }
        } else if (boxService.equals("NDS")) {
            if (boxWeight > 1) {
                boxCharge = NDS_CHARGE_FIRST_LB + (NDS_CHARGE_PER_LB * (boxWeight - 1));
            } else if (boxWeight < 1 && boxWeight > 0) {
                boxCharge = NDS_CHARGE_FIRST_LB;
            } else {
                System.out.println("Weight entered is not valid.");
            }
        } else if (boxService.equals("2D")) {
            if (boxWeight > 1) {
                boxCharge = TWO_D_CHARGE_FIRST_LB + (TWO_D_CHARGE_PER_LB * (boxWeight - 1));
            } else if (boxWeight < 1 && boxWeight > 0) {
                boxCharge = TWO_D_CHARGE_FIRST_LB;
            } else {
                System.out.println("Weight entered is not valid.");
            }
        } else {
            System.out.println("Service name is not found.");
        }

        if (boxCharge == 1) {
            System.out.println("An error occurred.");
        }

        return boxCharge;
    }

    public String getType() {
        return type;
    }

    public String getService() {
        return service;
    }

    public double getWeight() {
        return weight;
    }
}