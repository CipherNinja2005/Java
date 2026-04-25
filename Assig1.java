import java.util.Scanner;

public class Assig1 {
    public int num1, num2, ch;

    public int addNums(){
        return num1 + num2; 
    }
    public int subNums(){
        return num1 - num2; 
    }
    public int mulNums(){
        return num1 * num2; 
    }
    public float divNums(){ 
        return (float) num1 / num2;
    }
    public int modNums(){ 
        return num1 % num2; 
    }

    public static void main(String[] args) {

        Assig1 num = new Assig1();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n1.Addition 2.Subtraction 3.Multiplication 4.Division 5.Modulus 6.Exit");
            System.out.print("Enter your choice: ");
            num.ch = sc.nextInt();

            if (num.ch == 6) {
                break;  
            }

            System.out.print("Enter first number: ");
            num.num1 = sc.nextInt();

            System.out.print("Enter second number: ");
            num.num2 = sc.nextInt();

            if (num.ch == 1) {
                System.out.println("Addition: " + num.addNums());
            }
            else if (num.ch == 2) {
                System.out.println("Subtraction: " + num.subNums());
            }
            else if (num.ch == 3) {
                System.out.println("Multiplication: " + num.mulNums());
            }
            else if (num.ch == 4) {
                System.out.println("Division: " + num.divNums());
                
            }
            else if (num.ch == 5) {
                System.out.println("Modulus: " + num.modNums());
            }
            else {
                System.out.println("Invalid choice");
            }
        }
        sc.close();
    }
}
