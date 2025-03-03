public class HourlySalaryEmployee extends StaffMember{
    private int hourWorked;
    private double rate;

    HourlySalaryEmployee(int staffId,String staffName, String staffAddress, int hourWorked, double rate) {
        super(staffId,staffName, staffAddress);
        this.hourWorked = hourWorked;
        this.rate = rate;
    }

    public void setHourWorked(int hourWorked) {
        this.hourWorked = hourWorked;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getHourWorked() {
        return hourWorked;
    }

    public double getRate() {
        return rate;
    }

    @Override
    double pay(){
        return hourWorked * rate;
    }

    @Override
    public String toString() {
        return "HourlySalaryEmployee{" +
                "hourWorked=" + hourWorked +
                ", rate=" + rate +
                '}';
    }
}
