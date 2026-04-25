import java.util.ArrayList;

public class ArrayListOfBooks {
    public static void main(String[] a) {

        Book b1 = new Book();         // default constructor
        Book b4 = new Book(b1);       // copy constructor 

        b4.title = "Go Cargo";
        b4.price = 158.99;

        ArrayList<Book> blist = new ArrayList<Book>();

        blist.add(b1);
        blist.add(b4);

        try {
            Book b2 = new Book("Rich Dad, Poor Dad", 400, "ARC2014", "Self-Help", "KK Menon");
            blist.add(b2); //throws InvalidTitleException
            Book b3 = new Book(b2);   // copy constructor 
            blist.add(b3);
            Book b5 = new Book("Metamorphosis", -369.45, "F89C01U", "Fiction", "Franz Kafka"); // throws InvalidPriceException
            blist.add(b5);

        } 
        catch (InvalidTitleException it) {
            System.err.println(it.getMessage());
        }
        catch (InvalidPriceException ip) {
            System.err.println(ip.getMessage());
        }


        for (Book b : blist) {
            System.out.println("\nTitle: " + b.title);
            System.out.println("ISBN: " + b.ISBN);
            System.out.println("Price: " + b.price);
            System.out.println("Genre: " + b.genre);
            System.out.println("Author: " + b.author);
            System.out.println();
        }

        double avg = 0;
        int count = 0;
        double sum = 0;

        for (var e : blist) {
            if (e.price > 0) {
                sum += e.price;
                count++;
            }
        }

        System.out.println("Average is: " + sum / count);
    }
}