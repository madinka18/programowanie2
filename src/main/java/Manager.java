public class Manager extends Employee {
    private String phoneNumber;
    int ratePerHour;
    int numberHoursWorked;

    public Manager(String lastName, String firstName, String email, int age, int ratePerHour, int numberHoursWorked) {
        super(lastName, firstName, email, age);
        this.ratePerHour = ratePerHour;
        this.numberHoursWorked = numberHoursWorked;
    }

    public int monthlyPaymenty (){

             int  salary = ratePerHour * numberHoursWorked;
          return salary;
      }

}
