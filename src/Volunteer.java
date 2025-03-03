public class Volunteer extends StaffMember{
    private double salary;

    Volunteer( int staffId,String staffName, String staffAddress, double salary) {
        super(staffId, staffName, staffAddress);
        this.salary = salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public double pay(){
        return salary;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Volunteer{" +
                "salary=" + salary +
                '}';
    }
}
