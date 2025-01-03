public abstract class Book {
    private String bookTitle;
    private String bookAuthor;
    private String bookPublisher;
    private String typeOfBook;

    public Book() {

    }

    public Book(String bookTitle, String bookAuthor, String bookPublisher, String typeOfBook) {
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookPublisher = bookPublisher;
        this.typeOfBook = typeOfBook;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookPublisher(String bookPublisher) {
        this.bookPublisher = bookPublisher;
    }

    public String getBookPublisher() {
        return bookPublisher;
    }

    public void setTypeOfBook(String typeOfBook) {
        this.typeOfBook = typeOfBook;
    }

    public String getTypeOfBook() {
        return typeOfBook;
    }

    public abstract String toString();
}