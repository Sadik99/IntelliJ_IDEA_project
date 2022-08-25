public class Employee {
    private int baseSalary;
    private int hoursRate;
    public static int numberOfEmployees;
    public Employee(int baseSalary){
        this(baseSalary,0);
    }
    public Employee(int baseSalary,int hoursRate){
        setBaseSalary(baseSalary);
        setHoursRate(hoursRate);
        numberOfEmployees++;
    }
    public static void printNumberOfEmployees()
    {
        System.out.println("Number Of Employee :"+numberOfEmployees);
    }
    public int calculateWage(int extraHours) {

        return baseSalary+(getHoursRate() * extraHours);
    }public int calculateWage() {

        return calculateWage(0);
    }
    private void setBaseSalary(int baseSalary) {
        if(baseSalary<=0)
        {
            throw new IllegalArgumentException("Salary Cannot be 0 or less.");
        }
        this.baseSalary=baseSalary;
    }
    public int getBaseSalary(){
        return baseSalary;
    }

    public int getHoursRate() {
        return hoursRate;
    }

    private void setHoursRate(int hoursRate) {
        if(hoursRate<0) throw new IllegalArgumentException("Hourly rate cannot be less than 0.");
        this.hoursRate = hoursRate;
    }
}
