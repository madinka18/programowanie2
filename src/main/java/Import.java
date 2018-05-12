import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class Import {
        public void importcsv() {
            BufferedReader bufferedReader;
            List <Book> books = new ArrayList <>();

            try {
                bufferedReader = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream("books1.csv")));
                String line = bufferedReader.readLine();
                while (line != null) {

                    String[] attributes = line.split(";");
                    Book book = createBook(attributes);
                    books.add(book);
                    line = bufferedReader.readLine();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            BookDate instance = BookDate.getInstance();
            instance.setBooks(books);

        }

    private static Book createBook(String[] attributes) {
        ArrayList <Author> authorsList = new ArrayList <>();
        String[] splittedAuthors = attributes[4].split(",");

        for (int i = 0; i < splittedAuthors.length; i++) {
            Author authorById = AuthorDate.getInstance().getAuthorById(parseInt(splittedAuthors[i]));
            authorsList.add(authorById);

    }
        List<Categoria> categoriesList = CategoriaDate.getInstance().getAllCategories();
        Categoria pomocniczazmienna = null;
        for (Categoria categoria1 : categoriesList){
            if (parseInt(attributes[5]) == categoria1.getId()){
                pomocniczazmienna = categoria1;
            }

        }
        return new Book(attributes[0], attributes[1], parseInt(attributes[2]), attributes[3], authorsList,  pomocniczazmienna);
    }



    public void importAutors(){
        BufferedReader br;
        List <Author> authors = new ArrayList <>();

        try {
            br = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream("authors.csv")));
            String line = br.readLine();
            while (line != null) {

                String[] attributes = line.split(";");
                Author author = createAuthor(attributes);
                authors.add(author);
                line = br.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        AuthorDate instance = AuthorDate.getInstance();
        instance.setAuthors(authors);

    }

    private Author createAuthor(String[] attributes) {
            return new Author(parseInt(attributes[0]), attributes[1], parseInt(attributes[2]));
    }

    public void importCategories(){
            BufferedReader br;
            List<Categoria> categories = new ArrayList <>();

        try {
            br = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream("categories.csv")));
            String line = br.readLine();
            while (line != null) {

                String[] attributes = line.split(";");
                Categoria categoria = createCategoria(attributes);
                categories.add(categoria);
                line = br.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        CategoriaDate instance = CategoriaDate.getInstance();
        instance.setCategories(categories);

    }

    private Categoria createCategoria(String[] attributes) {
            return new Categoria(parseInt(attributes[0]), attributes[1], parseInt(attributes[2]));
    }


}



