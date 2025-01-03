import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TestBook {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("------------------------------------");
                System.out.println("Book Repository");
                System.out.println("------------------------------------");
                System.out.println("1. View Books");
                System.out.println("2. Add Book");
                System.out.println("3. Edit Book");
                System.out.println("4. Delete Book");
                System.out.println("5. EXIT");
                System.out.print("Select option (1 - 5) >>");
                int option = input.nextInt();

                switch (option) {
                    case 1 -> viewBook();
                    case 2 -> addBook();
                    case 3 -> editBook();
                    case 4 -> deleteBook();
                    case 5 -> {
                        for (int i = 0; i < bookList.size(); i++) {
                            try {
                                FileWriter file = new FileWriter("library.txt");

                                file.write(bookList + "\n");
                                file.close();
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                        }
                        System.out.println("bye");
                        System.exit(0);
                    }
                    default -> System.out.println("\nWRONG NUMBER!!!\nENTER AGAIN");
                }
            } catch (InputMismatchException ex) {
                System.out.print("INCORRECT INPUT! \nENTER AGAIN!\n");
                input.nextLine();
            } catch (Exception ex) {
                System.out.println("You have just make An unknown error!?");
                ex.printStackTrace();
                input.nextLine();
            }
        }
    }

    public static void viewBook() {
        if (bookList.isEmpty()) {
            System.out.println("\nYOU DIDN'T NOT STORE ANY BOOK YET!");
        } else {
            for (int i = 0; i < bookList.size(); i++) {
                System.out.println("\nBOOK No." + (i + 1) + "\n");
                System.out.println(bookList.get(i));
            }
            System.out.println("\n");
        }
    }

    static ArrayList<Book> bookList = new ArrayList<>();

    public static void addBook() {
        Scanner input = new Scanner(System.in);
        try {
            System.out.print("\nENTER BOOK TITLE(ENTER QUIT TO EXIT THE PROCESS): ");
            String bookTitle = input.nextLine();
            if (bookTitle.equalsIgnoreCase("quit")) {
                return;
            }
            System.out.print("ENTER BOOK AUTHOR(ENTER QUIT TO EXIT THE PROCESS): ");
            String bookAuthor = input.nextLine();
            if (bookAuthor.equalsIgnoreCase("quit")) {
                return;
            }
            System.out.print("ENTER BOOK PUBLISHER(ENTER QUIT TO EXIT THE PROCESS): ");
            String bookPublisher = input.nextLine();
            if (bookPublisher.equalsIgnoreCase("quit")) {
                return;
            }

            int bookType;
            do {
                System.out.print("\n1. Fiction Book\n2. Academic book\nSelect your book type(ENTER -999 TO EXIT THE PROCESS): ");
                bookType = input.nextInt();
                if (bookType == -999) {
                    return;
                }
                if (bookType > 2 || bookType < 1) {
                    System.out.println("\nWRONG NUMBER!!!\nENTER AGAIN");
                }
            } while (bookType > 2 || bookType < 1);

            String typeFiction = "";
            double rating = 0.0;
            String subject = "";
            int grade = 0;
            String typeBook = "";
            switch (bookType) {
                case 1 -> {
                    typeBook = "Fiction Book";
                    input.nextLine();
                    System.out.print("\nEnter the type of fiction book(ENTER QUIT TO EXIT THE PROCESS): ");
                    typeFiction = input.nextLine();
                    if (typeFiction.equalsIgnoreCase("quit")) {
                        return;
                    }
                    System.out.print("Enter the goodreads rating(ENTER -999 TO EXIT THE PROCESS): ");
                    rating = input.nextDouble();
                    if (rating == -999) {
                        return;
                    }
                }
                case 2 -> {
                    typeBook = "Academic Book";
                    input.nextLine();
                    System.out.print("\nEnter the book subject(ENTER QUIT TO EXIT THE PROCESS): ");
                    subject = input.nextLine();
                    if (subject.equalsIgnoreCase("quit")) {
                        return;
                    }
                    System.out.print("Enter the grade for book(ENTER -999 TO EXIT THE PROCESS): ");
                    grade = input.nextInt();
                    if (grade == -999) {
                        return;
                    }
                }
            }

            input.nextLine();
            String confirmation;
            do {
                System.out.print("PLS CONFIRM THIS EXECUTION(YES/NO)(ENTER QUIT TO EXIT THE PROCESS): ");
                confirmation = input.nextLine();
                if (confirmation.equalsIgnoreCase("quit")) {
                    return;
                }
                if (confirmation.equalsIgnoreCase("yes")) {
                    if (bookType == 1) {
                        bookList.add(new Fiction(bookTitle, bookAuthor, bookPublisher, typeBook, typeFiction, rating));
                    } else {
                        bookList.add(new Academic(bookTitle, bookAuthor, bookPublisher, typeBook, subject, grade));
                    }
                    System.out.println("\nYOU HAVE ADDED A BOOK");

                } else if (confirmation.equalsIgnoreCase("no")) {
                    System.out.println("THE EXECUTION HAS CANCELLED");
                } else {
                    System.out.println("WRONG INPUT\n");
                }
            } while (!confirmation.equalsIgnoreCase("yes") && !confirmation.equalsIgnoreCase("no"));
        } catch (InputMismatchException ex) {
            System.out.print("INCORRECT INPUT! \n");
            input.nextLine();
        } catch (Exception ex) {
            System.out.println("You have just make An unknown error!?");
            ex.printStackTrace();
            input.nextLine();
        }
    }

    public static void editBook() {
        Scanner input = new Scanner(System.in);
        if (bookList.isEmpty()) {
            System.out.println("\nTHERE IS NO BOOK TO EDIT");
        } else {
            for (int i = 0; i < bookList.size(); i++) {
                System.out.println("\n" + (i + 1) + ". " + "BOOK TITLE: " + bookList.get(i).getBookTitle() + "\n   BOOK AUTHOR: " + bookList.get(i).getBookAuthor() + "\n   TYPE OF BOOK: " + bookList.get(i).getTypeOfBook());
            }
            try {
                System.out.print("\nPICK THE BOOK THAT YOU WANTED TO EDIT(ENTER -999 TO EXIT THE PROCESS): ");
                int bookNum = input.nextInt();
                if (bookNum == -999) {
                    return;
                }
                if (bookNum <= bookList.size() && bookNum > 0) {
                    System.out.println("Enter new title, Author and Type for the book:");
                    input.nextLine();
                    System.out.print("BOOK TITLE(ENTER QUIT TO EXIT THE PROCESS): ");
                    String newTitle = input.nextLine();
                    if (newTitle.equalsIgnoreCase("quit")) {
                        return;
                    }
                    System.out.print("BOOK AUTHOR(ENTER QUIT TO EXIT THE PROCESS): ");
                    String newAuthor = input.nextLine();
                    if (newAuthor.equalsIgnoreCase("quit")) {
                        return;
                    }
                    System.out.print("BOOK TYPE(ENTER QUIT TO EXIT THE PROCESS): ");
                    String newType = input.nextLine();
                    if (newType.equalsIgnoreCase("quit")) {
                        return;
                    }
                    if (newTitle.isEmpty() || newAuthor.isEmpty() || newType.isEmpty()) {
                        System.out.println("BOOK TITLE, AUTHOR OR TYPE CANNOT BE EMPTY!");
                    } else {
                        Book updatedBook = bookList.get(bookNum - 1);
                        updatedBook.setBookTitle(newTitle);
                        updatedBook.setBookAuthor(newAuthor);
                        updatedBook.setTypeOfBook(newType);
                        System.out.println("YOU HAVE SUCCESSFULLY EDIT YOUR BOOK.");
                    }
                } else {
                    System.out.println("INVALID NUMBER");
                }
            } catch (InputMismatchException ex) {
                System.out.print("INCORRECT INPUT! \n");
                input.nextLine();
            } catch (Exception ex) {
                System.out.println("You have just make An unknown error!?");
                ex.printStackTrace();
                input.nextLine();
            }
        }
    }

    public static void deleteBook() {
        Scanner input = new Scanner(System.in);
        if (bookList.isEmpty()) {
            System.out.println("\nTHERE IS NO BOOK TO DELETE");
        } else {
            for (int i = 0; i < bookList.size(); i++) {
                System.out.println("\n" + (i + 1) + ". " + "BOOK TITLE: " + bookList.get(i).getBookTitle() + "\n   BOOK AUTHOR: " + bookList.get(i).getBookAuthor());
            }
            try {
                System.out.print("\nPICK THE BOOK THAT YOU WANTED TO DELETE(ENTER -999 TO EXIT THE PROCESS): ");
                int bookNum = input.nextInt();
                if (bookNum == -999) {
                    return;
                }
                if (bookNum <= bookList.size() && bookNum > 0) {
                    bookList.remove(bookNum - 1);
                    System.out.println("\nTHE BOOK HAS BEEN DELETED");
                } else {
                    System.out.println("INVALID NUMBER");
                }
            } catch (InputMismatchException ex) {
                System.out.print("INCORRECT INPUT! \n");
                input.nextLine();
            } catch (Exception ex) {
                System.out.println("You have just make An unknown error!?");
                ex.printStackTrace();
                input.nextLine();
            }
        }
    }
}