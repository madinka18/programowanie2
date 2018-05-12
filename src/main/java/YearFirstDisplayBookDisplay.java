import java.util.List;

public class YearFirstDisplayBookDisplay implements BookDisplay {



    @Override
    public void print(List<Book> books) {
        books.stream().forEach( book -> System.out.println("Rok wydania:" + book.getYear() +  ", Tytuł: " + book.getName()+ ", autor: " + book.getAuthors()
                + ", ISBN: " + book.getIsbn() +", okładka: " +  book.getCover()+ ",  " + book.getCategoria() + "\n"));
    }
}


