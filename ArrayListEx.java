//Array list use karke book inventory system with constructors and exception handling
import java.util.ArrayList;

public class ArrayListEx{
    public static void main(String[] args){

        ArrayList<Integer> aList = new ArrayList<Integer>();
        aList.add(10);
        aList.add(20);

        for(int i = 0; i<= 30; i+=3){ //adds elements to the arraylist
            aList.add(i);
        }

        System.out.println("ArrayList size: " + aList.size()); //size is kinda like len or sizeof in c

        for(int i : aList){
            System.out.print(i + " ");
        }

        System.out.println("Index of 21: " + aList.indexOf(21)); //for index retrieval

        //There are other methods like contains and isEmpty

        //Another Arraylist

        System.out.println("New ArrayList: ");

        ArrayList<Integer> newlist = new ArrayList<Integer>();
        newlist.add(100);
        newlist.add(200);
        newlist.add(300);

        aList.addAll(newlist); //adds second arraylist's items to the first's end

        for(int a : newlist){
            System.out.println(a);
        }

        System.out.println("First array with the second's items: ");

        aList.forEach(e->System.out.print(e + " ")); //checks for each element

        System.err.println("\nDivisibility check: ");

        aList.forEach(e->{ //checks and prints only elements in first arraylist that are divisible by 2
            if (e%2==0){
                System.out.print(e + " ");
            }
        });

        aList.remove(9);
        aList.remove(Integer.valueOf(12));

        System.err.println("\nPost removal :"); //12 and 21 gone

        aList.forEach(e->System.out.print(e + " "));

        ArrayList<String> fruits = new ArrayList<String>(5);
        fruits.add("Mango");
        fruits.add("Apple");
        fruits.add("Strawberry");
        fruits.add("Grape");
        fruits.add("Banana");
        fruits.add("Papaya");
        fruits.add("Guava");

        fruits.forEach(e -> { //To print whatever fruit starts with letter 'G'
            if (e.startsWith("G")) {
                System.out.println();
                System.out.print("Fruits that start with G: " + e + " ");
            }
        });
    
    }
}
