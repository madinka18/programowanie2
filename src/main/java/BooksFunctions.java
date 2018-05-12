import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BooksFunctions {

    public Book findBooksISBN(List <Book> books, String isbn) {
        return books.stream().filter(book -> book.getIsbn().equals(isbn)).findFirst().get();
    }

    public List <Book> sortingTheBooks(List <Book> books) {
        return books.stream().sorted(Comparator.comparing(Book::getYear)).collect(Collectors.toList());
    }

    public List <Book> lastTwoBooks(List <Book> books) {
        return books.stream().skip(books.size() - 2).collect(Collectors.toList());
    }

    public List <Book> sortingBooksFromTheLatestPublished(List <Book> books) {
        return books.stream().sorted(Comparator.comparing(Book::getYear).reversed()).collect(Collectors.toList());
    }

    public Book earliestReleased(List <Book> books, int year) {
        return books.stream().min(Comparator.comparing(Book::getYear)).get();
    }

    public Book releasedAtTheLatest(List <Book> books, int year) {
        return books.stream().max(Comparator.comparing(Book::getYear)).get();

    }

    public int totalYears(List <Book> books) {
        return books.stream().mapToInt(Book::getYear).sum();
    }

    public int numberOfBooksPublishedAfter2007(List <Book> books) {
        return (int) books.stream().filter(book -> book.getYear() > 2007).count();
    }

    public List <Book> booksPublishedAfter2000(List <Book> books) {
        return books.stream().filter(book -> book.getYear() > 2003).collect(Collectors.toList());
    }

    public int averageYearOfBooksIssue(List <Book> books) {
        return books.stream().mapToInt(Book::getYear).sum() / books.size();

    }

    public int booksPublishedBefore2000(List <Book> books) {
        return (int) books.stream().filter(book -> book.getYear() < 2000).count();
    }

    public List <Book> booksContainingTintheTitle(List <Book> books) {
        return books.stream().filter(book -> book.getName().startsWith("T")).filter(book -> book.getYear() > 2009).collect(Collectors.toList());
    }

    public List <Book> adding100ToTheYearOfPublication(List <Book> books) {
        books.stream().forEach(book -> book.setYear(book.getYear() + 100));
        return books;
    }

    public List <Book> dividedByTwo(List <Book> books) {
        List <Book> collect = books.stream().filter(book -> book.getYear() % 2 == 0).collect(Collectors.toList());
        return collect;
    }

}