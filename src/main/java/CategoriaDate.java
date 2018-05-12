import java.util.List;

public class CategoriaDate {

    private static CategoriaDate instance = new CategoriaDate();


    public CategoriaDate() {

    }

    public static CategoriaDate getInstance() {
        return instance;
    }

    private List <Categoria> categories;

    public void setCategories(List <Categoria> categories) {
        this.categories = categories;
    }

    public List <Categoria> getAllCategories() {
        return categories;
    }


    public Categoria getCategoriaById(int id) {
        return categories.stream().filter(categoria -> categoria.getId() == id).findFirst().get();
    }
}