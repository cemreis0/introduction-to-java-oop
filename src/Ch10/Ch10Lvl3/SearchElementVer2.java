package Ch10.Ch10Lvl3;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class SearchElementVer2 {
    public static void main(String[] args) {
        PeriodicTableVer2 periodicTable = new PeriodicTableVer2();
        Element element;
        Scanner scanner = new Scanner(System.in);
        String response;

        // add elements to the periodic table
        element = new Element("Hydrogen", 1, "H", 1.00794, 1, 1);
        periodicTable.addElement(element);
        element = new Element("Helium", 2, "He", 4.0026, 18, 1);
        periodicTable.addElement(element);
        element = new Element("Lithium", 3, "Li", 6.941, 1, 2);
        periodicTable.addElement(element);
        element = new Element("Beryllium", 4, "Be", 9.0122, 2, 2);
        periodicTable.addElement(element);
        element = new Element("Boron", 5, "B", 10.81, 13, 2);
        periodicTable.addElement(element);
        element = new Element("Carbon", 6, "C", 12.01, 14, 2);
        periodicTable.addElement(element);
        element = new Element("Nitrogen", 7, "N", 14.01, 15, 2);
        periodicTable.addElement(element);
        element = new Element("Oxygen", 8, "O", 16.00, 16, 2);
        periodicTable.addElement(element);
        element = new Element("Fluorine", 9, "F", 19.00, 17, 2);
        periodicTable.addElement(element);
        element = new Element("Neon", 10, "Ne", 20.18, 18, 2);
        periodicTable.addElement(element);

        while (true) {
            // prompt the user with options
            System.out.println("1. Search by Name");
            System.out.println("2. Search by Symbol");
            System.out.println("3. Quit");
            response = scanner.nextLine();
            if (response.equals("1")) {
                // search by name
                String name;

                System.out.print("Enter name: ");
                name = scanner.nextLine();

                element = periodicTable.searchElementByName(name);
                // if an element is found by name, display the details
                if (element != null) {
                    System.out.println();
                    System.out.println(
                            "Name: " + element.getName() + "\n"
                                    + "Atomic number: " + element.getAtomicNumber() + "\n"
                                    + "Atomic symbol: " + element.getAtomicSymbol() + "\n"
                                    + "Atomic mass: " + element.getAtomicMass() + "\n"
                                    + "Period: " + element.getPeriod() + "\n"
                                    + "Group: " + element.getGroup()
                    );
                    System.out.println();
                    // if an element is not found, print that out
                } else {
                    System.out.println("No element found.");
                }
            } else if (response.equals("2")) {
                // search by atomic symbol
                String atomicSymbol;

                System.out.print("Enter atomic symbol: ");
                atomicSymbol = scanner.nextLine();

                element = periodicTable.searchElementByAtomicSymbol(atomicSymbol);

                // if an element is found by atomic symbol, display the details
                if (element != null) {
                    System.out.println();
                    System.out.println(
                            "Name: " + element.getName() + "\n"
                                    + "Atomic number: " + element.getAtomicNumber() + "\n"
                                    + "Atomic symbol: " + element.getAtomicSymbol() + "\n"
                                    + "Atomic mass: " + element.getAtomicMass() + "\n"
                                    + "Period: " + element.getPeriod() + "\n"
                                    + "Group: " + element.getGroup()
                    );
                    System.out.println();
                    // if an element is not found, print that out
                } else {
                    System.out.println("No element found.");
                }
            } else if (response.equals("3")) {
                // quit
                System.out.println("Bye!");
                break;
            } else {
                // if the response is not one of 1, 2, 3, inform the user that an invalid response is entered
                System.out.println("Invalid response.");
            }
        }
    }
}

class PeriodicTableVer2 {
    // data members
    private Map<String, Element> periodicTable;

    // constructors
    public PeriodicTableVer2() {
        periodicTable = new TreeMap<>();
    }

    // add an element to the periodic table
    public void addElement(Element element) {
        if (!periodicTable.containsKey(element.getName())) {
            periodicTable.put(element.getName(), element);
        }
    }

    public Element searchElementByName(String name) {
        Element requestedElement = null;
        String searchName;

        searchName = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();

        // if the name of this element matches the given name, set requestedElement to this element
        if (periodicTable.containsKey(searchName)) {
            requestedElement = periodicTable.get(searchName);
        }

        return requestedElement;
    }

    public Element searchElementByAtomicSymbol(String atomicSymbol) {
        Element requestedElement = null;

        // iterate over the element values in periodic table
        for (Element element : periodicTable.values()) {
            if (element.getAtomicSymbol().equalsIgnoreCase(atomicSymbol)) {
                requestedElement = element;
            }
        }

        return requestedElement;
    }
}

class ElementVer2 {
    // data members
    private String name;
    private int atomicNumber;
    private String atomicSymbol;
    private double atomicMass;
    private int period;
    private int group;

    // constructors
    public ElementVer2() {
        this("", 0, "", 0, 0, 0);
    }

    public ElementVer2(String name, int atomicNumber, String atomicSymbol, double atomicMass, int period, int group) {
        this.name = name;
        this.atomicNumber = atomicNumber;
        this.atomicSymbol = atomicSymbol;
        this.atomicMass = atomicMass;
        this.period = period;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public int getAtomicNumber() {
        return atomicNumber;
    }

    public String getAtomicSymbol() {
        return atomicSymbol;
    }

    public double getAtomicMass() {
        return atomicMass;
    }

    public int getPeriod() {
        return period;
    }

    public int getGroup() {
        return group;
    }
}