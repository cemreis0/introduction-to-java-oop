// Chapter 6 Sample Program: Sample formatting statements

package Ch6;

public class Ch6CarpetPriceTableWithFormat {
    public static void main(String[] args) {
        int price;

        // print out the column labels
        System.out.print("   "); // space for row labels

        for (int colLabel = 5; colLabel <= 25; colLabel += 5) {
            System.out.format("%8d", colLabel);
        }

        System.out.println();

        for (int width = 5; width <= 14; width++) {
            System.out.format("%3d", width);

            for (int length = 5; length <= 25; length += 5){
                price = width * length * 3;
                System.out.format("%8d", price);
            }

            System.out.println();
        }
    }
}
