import java.util.List;

public class TitleFirstBookDisplay implements BookDisplay {



    @Override
    public void print(List<Book> books) {

      books.stream().forEach( book -> System.out.println("Tytuł: " + book.getName() + ", autor: " + book.getAuthors() + ", ISBN: "
              + book.getIsbn() + ", rok wydania: " + book.getYear()+ ", okładka: "+ book.getCover()+ ",  " + book.getCategoria()));


    }
}

