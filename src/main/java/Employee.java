public abstract class Employee {

    private String lastName;
    private String firstName;
    private String email;
    private int age;


    public Employee(String lastName, String firstName, String email, int age){
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.age = age;


    }

    public Employee() {

    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "Pracownik: "  + lastName + '\'' + " " + firstName + '\'' + ", email: " + email + '\'' + ", wiek " + age +  '\'' ;
    }

    public abstract int monthlyPaymenty();
}
