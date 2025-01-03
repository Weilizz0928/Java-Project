public class Academic extends Book {
    private String subject;
    private int grade;

    public Academic() {

    }

    public Academic(String bookTitle, String bookAuthor, String bookPublisher, String typeOfBook, String subject, int grade) {
        super(bookTitle, bookAuthor, bookPublisher, typeOfBook);
        this.subject = subject;
        this.grade = grade;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "BOOK TITLE: " + super.getBookTitle() + "\nBOOK AUTHOR: " + super.getBookAuthor() + "\nBOOK PUBLISHER: " + super.getBookPublisher() + "\nTYPE OF BOOK: " + super.getTypeOfBook() + "\nBOOK SUBJECT: " + subject + "\nGRADE: " + grade;
    }
}
