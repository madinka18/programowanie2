import java.util.ArrayList;
import java.util.List;

class Book {
    private String name;
    private String isbn;
    private int year;
    private String cover;
    private Categoria categoria;


    public List <Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List <Author> authors) {
        this.authors = authors;
    }

    private List <Author> authors;


   @Override
    public String toString() {
        return "Tytuł: " + name + ", autor: " + authors + ", ISBN: " + isbn + ", rok wydania: " + year + ", okładka: " + cover + ", kategoria: " + categoria + "\n";
    }

    public Book(String name, String isbn, int year) {
        this.name = name;
        this.isbn = isbn;
        this.year = year;
    }

    public Book(String name, String isbn, int year, String cover, List<Author> authors, Categoria categoria) {
        this.name = name;
        this.isbn = isbn;
        this.year = year;
        this.cover = cover;
        this.authors = authors;
        this.categoria = categoria;
    }

    public int getYear() {
        return year;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCover() {
        return cover;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}