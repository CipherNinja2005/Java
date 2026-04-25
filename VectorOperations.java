import java.util.Scanner;
// Main Class
public class VectorOperations{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // First Vector
            System.out.print("Enter dimension of first vector (2 or 3): ");
            int dim1 = scanner.nextInt();

            double[] comp1 = new double[dim1];
            System.out.println("Enter components of first vector:");
            for (int i = 0; i < dim1; i++) {
                comp1[i] = scanner.nextDouble();
            }

            Vector v1 = new Vector(comp1); // Constructor checks dimension


            // Second Vector
            System.out.print("Enter dimension of second vector (2 or 3): ");
            int dim2 = scanner.nextInt();

            double[] comp2 = new double[dim2];
            System.out.println("Enter components of second vector:");
            for (int i = 0; i < dim2; i++) {
                comp2[i] = scanner.nextDouble();
            }

            Vector v2 = new Vector(comp2); // Constructor checks dimension


            // Now check if dimensions match
            v1.checkDimension(v2);

            // Perform operations
            Vector sum = v1.add(v2);
            Vector difference = v1.subtract(v2);
            double dot = v1.dotProduct(v2);

            System.out.print("Addition Result: ");
            sum.display();

            System.out.print("Subtraction Result: ");
            difference.display();

            System.out.println("Dot Product Result: " + dot);

        } catch (VectorException e) {
            System.out.println("Vector Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}