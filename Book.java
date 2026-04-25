

public class Book{
    public String title;
    public double price;
    public String ISBN;
    public String genre; //Fiction. Short 
    public String author;

    public Book(){  //default constructor
        title = "Moby Dick";
        price = 285;
        ISBN = "A45JCK21DED";
        genre = "Fiction";
        author = "James Drew";
    }

    public Book(String t, double p, String i, String g, String a) throws InvalidPriceException, InvalidTitleException{ //parameterized constructor
        if (t==null || t.isBlank()){
            throw new InvalidTitleException("Title can not be Null. Try again!");
        }
        title = t;
        if (p<=0){
            throw new InvalidPriceException("Price can not be negative or zero. Try again!");
        }
        price = p;
        ISBN = i;
        genre = g;
        author = a;
    }

    //copy constructor 

    public Book(Book b){
        title = b.title;
        ISBN = b.ISBN;
        price = b.price;
        genre = b.genre;
        author = b.author;
    }

}