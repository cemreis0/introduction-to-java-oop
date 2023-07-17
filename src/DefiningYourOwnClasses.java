public class DefiningYourOwnClasses {
    public static void main(String[] args) {
        BicycleRegistration.register();
        double x = 20.00;
        System.out.println(compute(1, 2, x));
    }
    public static double compute(int i, int j, double x) {
        return i + j + x;
    }
}


