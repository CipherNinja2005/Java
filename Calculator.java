import java.util.Scanner;
public class Calculator {
    public int num1, num2;

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
        return (float)num1/(float)num2;
    }

    public int modNums(){
        return num1 % num2;
    }

    public static void main(String[] args){

        Calculator num = new Calculator(); //this is basically to allot the object a memory for that class
        Scanner sc = new Scanner(System.in); //in order to take user input

        System.out.print("Enter first number: ");
        num.num1 = sc.nextInt();

        System.out.print("Enter second number: ");
        num.num2 = sc.nextInt();

        System.out.println("Addition: " + num.addNums());
        System.out.println("Subtraction: " + num.subNums());
        System.out.println("Multiplication: " + num.mulNums());
        System.out.println("Division: " + num.divNums());
        System.out.println("Modulus: " + num.modNums());

        sc.close();

    }

}