import java.util.Scanner;

class Book {
    // Members
    private String name;
    private String author;
    private double price;
    private int nm_pages;

    // Constructor to initialize the book details
    public Book(String name, String author, double price, int nm_pages) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.nm_pages = nm_pages;
    }

    // Setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setNmPages(int nm_pages) {
        this.nm_pages = nm_pages;
    }
    public String getName() {             // Getter methods
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public int getNmPages() {
        return nm_pages;
    }

    // String method to display complete details of the book
    @Override
    public String toString() {
         
        return "Book Details:\n"+
               "Name: " + name + "\n" +
               "Author: " + author + "\n" +
               "Price: Rs" + price + "\n" +
               "Number of Pages: " + nm_pages;
    }
}

public class BookProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of books to create: ");
        int n = sc.nextInt();
        sc.nextLine();  // Consume newline

        Book[] books = new Book[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for book " + (i + 1) + ":");

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Author: ");
            String author = sc.nextLine();

            System.out.print("Price: ");
            double price = sc.nextDouble();

            System.out.print("Number of Pages: ");
            int nm_pages = sc.nextInt();
            sc.nextLine();  // Consume newline

            books[i] = new Book(name, author, price, nm_pages);
        }

        System.out.println("\nAll Book Details:");
        for (Book book : books) {
            System.out.println(book);
            System.out.println("--------------------");
        }

        sc.close();
    }
}
