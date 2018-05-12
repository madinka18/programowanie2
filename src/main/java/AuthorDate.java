import java.util.List;

public class AuthorDate {
    private static AuthorDate instance = new AuthorDate();

    public static AuthorDate getInstance() {
        return instance;
    }

    private AuthorDate() {
    }

     public List <Author> getAllAuthors() {
        return authors;
    }

    public void setAuthors(List <Author> authors) {
        this.authors = authors;
    }

    private List<Author> authors;

    public Author getAuthorById(int id) {
        return authors.stream().filter(author -> author.getId() == id).findFirst().get();
    }


}
