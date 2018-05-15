

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
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


    public static void main(String[] args) throws FileNotFoundException {
        importAuthors.importAutors();
        importCategories.importCategories();
        importcsv.importcsv();
        System.out.println();

        menuDisplay();
        System.out.println();
    }

    private static void menuDisplay() throws FileNotFoundException {
        int selectedNumber;
        do {
            System.out.println("Proszę wybrać opcje:" + "\n" +

                    "1 - wyjście" + "\n" + "2 - podanie kontaktu do księgarni" + "\n" +
                    "3 - wyświetlenie katalogu książek" + "\n" + "4 - wyświetlenie autorów" + "\n" +
                    "5 - wyświetlenie książek wydanych po 2003r." + "\n" + "6 - sortowanie książek po roku wydania rosnąco," + "\n" +
                    "7 - sortowanie książek po roku wydania malejąco" + "\n" + "8 - wyświetlanie książek zaczynając od roku wydania" + "\n" +
                    "9 - wyświetlanie książek zaczynając od ISBN" + "\n" + "10 - wyświetlanie kategorii książek" + "\n" +
                    "11 - wyświetlanie książek z kategorii Wzorce projektowe" + "\n" + "12 - dodaj nowego autora" + "\n" +
                    "13 - zamawianie dodruku książki" + "\n" + "14 - edytowanie tytułu książek" + "\n" +
                    "15 - wyświetlanie iość książek napisanych przez autorów" + "\n" + "16 - wyświetlanie pensji pracowników" + "\n" +
                    "17 - zapisywanie listy autorów do pliku" + "\n" + "18 - zmiana wieku autora" + "\n" +
                    "19 - zapis listy categorii do pliku" + "\n");

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

                    List <Book> bookList1 = instance.getAllBooks();
                    String isbn = scanner.next();
                    Book printableBook = booksFunctions.findBooksISBN(bookList1, isbn);

                    OrderReprint orderReprint;
                    if (printableBook.getCover().equals("M")) {
                        orderReprint = new SoftCoverOrderReprint();
                    } else {
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
                    String newNameBook = scanner2.nextLine();
                    bookToChenge.setName(newNameBook);
                    System.out.println(bookList);
                    break;
                case 15:
                    List <Book> bookList2 = instance.getAllBooks();
                    List <Author> authors = instance1.getAllAuthors();
                    booksFunctions.countingAuthorsBooks(bookList2, authors);
                    break;
                case 16:
                    Manager manager = new Manager("Piotr", "Nowak", "bc@biuro.om", 42, 50, 160);
                    Salesman salesman = new Salesman("Ewa", "Kowalska", "kowalska@bookstore.com", 21, 1800);
                    Trainee trainee = new Trainee("Darek", "Malinowski", "malinowski@bookstore.com", 19, 15, 20);
                    List <Employee> employees = new ArrayList <>();
                    employees.add(manager);
                    employees.add(salesman);
                    employees.add(trainee);

                    for (Employee employee : employees) {
                        System.out.println(employee + " pensja " + employee.monthlyPaymenty());
                        System.out.println();
                    }
                    break;
                case 17:
                    List <Author> authors1 = instance1.getAllAuthors();
                    PrintWriter zapis = new PrintWriter("src\\main\\resources\\authors1.csv");
                    for (Author author1 : authors1) {
                        zapis.println(String.valueOf(author1));
                    }
                    zapis.close();
                    break;
                case 18:
                    List <Author> authorList1 = instance1.getAllAuthors();
                    System.out.println("Podaj id autora, którego wiek chcesz zmienić");
                    Scanner scanner3 = new Scanner(System.in);
                    int idAuthor = scanner3.nextInt();
                    Author authorToChenge = authorList1.get(idAuthor - 1);
                    System.out.println("Podaj poprawny wiek autora");
                    int newAgeAuthor = scanner3.nextInt();
                    authorToChenge.setAuthorAge(newAgeAuthor);
                    System.out.println(authorList1);
                    break;
                case 19:
                    List <Categoria> categoriaList = instance2.getAllCategories();
                    PrintWriter categoria = new PrintWriter("src\\main\\resources\\categories1.csv");
                    for (Categoria  categoria1 :categoriaList) {
                        categoria.println(categoria1);
                    }
                    categoria.close();
            }

        } while (selectedNumber != 1);

    }
}