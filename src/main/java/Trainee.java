public class Trainee extends Employee {

    int ratePerHour;
    int numberHoursWorked;

    public Trainee(String lastName, String firstName, String email, int age, int ratePerHour, int numberHoursWorked) {
        super(lastName, firstName, email, age);
        this.ratePerHour = ratePerHour;
        this.numberHoursWorked = numberHoursWorked;
    }



    public int monthlyPaymenty (){

        int  salary = ratePerHour * numberHoursWorked;
        return salary;
    }
}
