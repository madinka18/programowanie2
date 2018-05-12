public class Author {

    private  int id;
    private String authorName;
    private int authorAge;


    @Override
    public String toString() {
        return id + ". Dane autora: " + authorName + ", wiek: " + authorAge;
    }

    Author(int id, String authorName, int authorAge) {
        this.id = id;
        this.authorName = authorName;
        this.authorAge = authorAge;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getAuthorAge() {
        return authorAge;
    }

    public void setAuthorAge(int authorAge) {
        this.authorAge = authorAge;
    }


}
