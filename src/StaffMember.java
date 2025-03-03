abstract class StaffMember {
    private int staffId;
    private String staffName;
    private String staffAddress;

    StaffMember(int staffId,String staffName, String staffAddress) {
        this.staffId = staffId;
        this.staffName = staffName;
        this.staffAddress = staffAddress;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public void setStaffAddress(String staffAddress) {
        this.staffAddress = staffAddress;
    }

    public int getStaffId() {
        return staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public String getStaffAddress() {
        return staffAddress;
    }

    abstract double pay();

    @Override
    public String toString() {
        return "StaffMember {" +
                "staffId=" + staffId +
                ", staffName='" + staffName + '\'' +
                ", staffAddress='" + staffAddress + '\'' +
                '}';
    }
}
