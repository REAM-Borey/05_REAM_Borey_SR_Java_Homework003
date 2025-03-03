public class SalariedEmployee extends StaffMember {
    private double salary;
    private double bonus;

    SalariedEmployee(int staffId, String staffName, String staffAddress,double salary, double bonus) {
        super(staffId, staffName, staffAddress);
        this.salary = salary;
        this.bonus = bonus;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public double pay() {
        return this.salary+bonus;
    }

    public double getSalary() {
        return this.salary;
    }

    public double getBonus() {
        return this.bonus;
    }

    @Override
    public String toString() {
        return "SalariedEmployee{" +
                "salary=" + salary +
                ", bonus=" + bonus +
                '}';
    }
}
