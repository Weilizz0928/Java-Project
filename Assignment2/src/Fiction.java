public class Fiction extends Book {
    private String type;
    private double goodReadsRating;

    public Fiction() {

    }

    public Fiction(String bookTitle, String bookAuthor, String bookPublisher, String typeOfBook, String type, double goodReadsRating) {
        super(bookTitle, bookAuthor, bookPublisher, typeOfBook);
        this.type = type;
        this.goodReadsRating = goodReadsRating;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getGoodReadsRating() {
        return goodReadsRating;
    }

    public void setGoodReadsRating(double goodReadsRating) {
        this.goodReadsRating = goodReadsRating;
    }

    @Override
    public String toString() {
        return "BOOK TITLE: " + super.getBookTitle() + "\nBOOK AUTHOR: " + super.getBookAuthor() + "\nBOOK PUBLISHER: " + super.getBookPublisher() + "\nTYPE OF BOOK: " + super.getTypeOfBook() + "\nTYPE OF FICTION: " + type + "\nGOODREADS RATING: " + goodReadsRating;
    }
}
