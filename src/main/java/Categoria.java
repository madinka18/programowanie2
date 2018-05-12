import java.util.List;

public class Categoria {

    private String isbn;
    private int year;
    private  String cover;
    private String authors;
    private List <Categoria> categoriaList;

    public Categoria(int id, String name, int display){
        this.id = id;
        this.name = name;
        this.display = display;
    }


    public Categoria(String name, String isbn, int year, String cover, String authors, List <Categoria> categoriesList) {
        this.name = name;
        this.isbn = isbn;
        this.year = year;
        this.cover = cover;
        this.authors = authors;
        this.categoriaList = categoriesList;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDisplay() {
        return display;
    }

    private int id;
    private String name;
    private int display;

    @Override
    public String toString(){
        return  id + ". Kategoria: " + name  + ",  " + ", priorytet wyświetlania: " + display + "\n";
    }



}
