public class Salesman extends Employee {
    int slaryContract;

    public Salesman(String lastName, String firstName, String email, int age, int slaryContract) {
        super(lastName, firstName, email, age);
        this.slaryContract = slaryContract;
    }

    public int monthlyPaymenty() {

        return slaryContract;
    }
}