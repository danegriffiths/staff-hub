package uk.dvla.staffhub.generator;

public class Manager {

    public Manager(String staffNumber, String emailAddress,
                    String department) {
        this.staffNumber = staffNumber;
        this.emailAddress = emailAddress;
        this.department = department;
    }

    private String staffNumber;
    private String emailAddress;
    private String department;

    public String getStaffNumber() {
        return staffNumber;
    }

    public void setStaffNumber(String staffNumber) {
        this.staffNumber = staffNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
