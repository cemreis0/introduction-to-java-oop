package Ch5;

public class Ch5Circle {
    // data members
    public static final double INVALID_DIMENSION = -1;
    private double radius;

    // constructor
    public Ch5Circle(double r) {
        setRadius(r);
    }

    // methods
    public double getArea() {
        double result = INVALID_DIMENSION;
        if (isRadiusValid()) {
            result = Math.PI * radius * radius;
        }
        return result;
    }

    public double getCircumference() {
        double result = INVALID_DIMENSION;
        if (isRadiusValid()) {
            result = 2.0 * Math.PI * radius;
        }
        return result;
    }

    public double getDiameter() {
        double result = INVALID_DIMENSION;
        if (isRadiusValid()) {
            result = 2.0 * radius;
        }
        return result;
    }

    public double getRadius() {
        return radius;
    }

    public void setDiameter(double d) {
        if (d > 0) {
            setRadius(d/2.0);;
        } else {
            setRadius(INVALID_DIMENSION);
        }
    }

    public void setRadius(double r) {
        if (r > 0) {
            radius = r;
        } else {
            radius = INVALID_DIMENSION;
        }
    }

    private boolean isRadiusValid() {
        return radius != INVALID_DIMENSION;
    }
}

class Ch5Sample1 {
    public static void main(String[] args) {
        Ch5Circle circle = new Ch5Circle(15);
        if (circle.getRadius() != Ch5Circle.INVALID_DIMENSION) {
            System.out.print(
                "       Radius: " + circle.getRadius() + "cm" + "\n" +
                "     Diameter: " + circle.getDiameter() + "cm" +"\n" +
                "Circumference: " + circle.getCircumference() + "cm" + "\n" +
                "         Area: " + circle.getArea() + "cm^2"
            );
        } else {
            System.out.print("Cannot compute, radius is invalid.");
        }
    }
}