import java.util.List;

public class IsbnFirstBookDisplay implements BookDisplay {

    @Override
    public void print(List<Book> books) {

        books.stream().forEach( book -> System.out.println("ISBN:" + book.getIsbn() +  ", Tytuł: " + book.getName() + ", rok wydania: "
                + book.getYear()+ ", okładka: " + book.getCover() + ", kategoria: " + book.getCategoria() + "\n"));
    }
}
