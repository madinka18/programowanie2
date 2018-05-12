

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Bookstore {
    private static Scanner scanner = new Scanner(System.in);
    private static Scanner scanner1 = new Scanner(System.in);
    private static Scanner scanner2 = new Scanner(System.in);
    private static Import importcsv = new Import();
    private static Import importAuthors = new Import();
    private static Import importCategories = new Import();

    private static BooksFunctions booksFunctions = new BooksFunctions();
    private static AuthorDate instance1 = AuthorDate.getInstance();
    private static CategoriaDate instance2 = CategoriaDate.getInstance();
    private static BookDate instance = BookDate.getInstance();
    private static BookDisplay bookDisplay = new TitleFirstBookDisplay();



    public static void main(String[] args) {
        importAuthors.importAutors();
        importCategories.importCategories();
        importcsv.importcsv();
        System.out.println();

        menuDisplay();
        System.out.println();
    }

    private static void menuDisplay() {
        int selectedNumber;
        do {
            System.out.println("Proszę wybrać opcje:" + "\n" +

                    "1 - wyjście" + "\n" +
                    "2 - podanie kontaktu do księgarni" + "\n" +
                    "3 - wyświetlenie katalogu książek" + "\n" +
                    "4 - wyświetlenie autorów" + "\n" +
                    "5 - wyświetlenie książek wydanych po 2003r." + "\n" +
                    "6 - sortowanie książek po roku wydania rosnąco," + "\n" +
                    "7 - sortowanie książek po roku wydania malejąco" + "\n" +
                    "8 - wyświetlanie książek zaczynając od roku wydania" + "\n" +
                    "9 - wyświetlanie książek zaczynając od ISBN" + "\n" +
                    "10 - wyświetlanie kategorii książek" + "\n" +
                    "11 - wyświetlanie książek z kategorii Wzorce projektowe" + "\n" +
                    "12 - dodaj nowego autora" + "\n" +
                    "13 - Zamawianie dodruku książki" + "\n" +
                    "14 - Edytowanie tytułu książek");

            System.out.println();

            selectedNumber = scanner.nextInt();

            switch (selectedNumber) {
                case 2:
                    System.out.println("Aby skontaktować się z naszą księgarnią wyślij e-mail na adres biuro@naszaksięgarania.pl");
                    break;
                case 3:
                    bookDisplay.print(instance.getAllBooks());
                    break;
                case 4:

                    System.out.println(instance1.getAllAuthors());
                    break;
                case 5:
                    List <Book> bookslist = booksFunctions.booksPublishedAfter2000(instance.getAllBooks());
                    bookDisplay.print(bookslist);
                    break;
                case 6: {
                    List <Book> bookList = booksFunctions.sortingTheBooks(instance.getAllBooks());
                    bookDisplay.print(bookList);
                    break;
                }
                case 7: {
                    List <Book> bookList = booksFunctions.sortingBooksFromTheLatestPublished(instance.getAllBooks());
                    bookDisplay.print(bookList);
                    break;
                }
                case 8:
                    bookDisplay = new YearFirstDisplayBookDisplay();
                    break;
                case 9:
                    bookDisplay = new IsbnFirstBookDisplay();
                    break;
                case 10:
                    System.out.println(instance2.getAllCategories());
                    break;
                case 11: {
                    List <Book> bookList = instance.getAllBooks().stream().filter(book -> book.getCategoria().getId() == 2).collect(Collectors.toList());
                    bookDisplay.print(bookList);
                    break;
                }
                case 12:
                    System.out.println("Podaj id autora");
                    int idNewAuthor = scanner.nextInt();

                    System.out.println("Podaj imię i nazwisko autora");
                    String nameNewAuthor = scanner1.nextLine();

                    System.out.println("Podaj wiek autora");
                    int ageNewAuthor = scanner2.nextInt();

                    List <Author> authorList = instance1.getAllAuthors();
                    Author author = new Author(idNewAuthor, nameNewAuthor, ageNewAuthor);
                    authorList.add(author);
                    System.out.println(authorList);


                    break;
                case 13:
                    System.out.println("Którą książkę chcesz dodrukować, podaj ISBN");

                    List<Book> bookList1 = instance.getAllBooks();
                    String isbn = scanner.next();
                    Book printableBook = booksFunctions.findBooksISBN(bookList1, isbn);

                    OrderReprint orderReprint;
                   if (printableBook.getCover().equals("M")){
                       orderReprint = new SoftCoverOrderReprint();
                   }
                       else {
                       orderReprint = new HardCoverOrderReprint();
                   }
                   orderReprint.orderReprint();


                    break;
                case 14:
                    System.out.println("Podaj ISBN książki, której chcesz edytować tytuł");
                    String isbn1 = scanner2.nextLine();
                    List <Book> bookList = instance.getAllBooks();
                    Book bookToChenge = booksFunctions.findBooksISBN(bookList, isbn1);
                    System.out.println("Podaj poprawny tytuł");
                    String newNameBook =  scanner2.nextLine();
                    bookToChenge.setName(newNameBook);
                    System.out.println(bookList);
                    break;
                case 15:
                    System.out.println("Podaj identyfikator autora");
                    Scanner in = new Scanner(System.in);
                    int idAuthor = in.nextInt();
                    List<Book> bookList2 = instance.getAllBooks();
//                    bookList2.stream().filter((Book book) -> book.getAuthors().

            }
        }  while (selectedNumber != 1) ;

    }
}