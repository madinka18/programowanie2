import java.util.List;

public class BookDate {


    private static BookDate instance = new BookDate();


    private BookDate() { }

    private List <Book> books;

    public static BookDate getInstance(){
    return instance;
    }

    public void setBooks(List <Book> books) {
        this.books = books;
    }

    public List <Book> getAllBooks(){

        return books;
    }

}
