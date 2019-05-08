package uk.dvla.staffhub.generator;

public class Employee {

    public Employee() {};

    public Employee(String staffNumber, String forename, String surname, String emailAddress,
                    String department, String dailyHoursPermitted, String weeklyHoursPermitted,
                    String flexiBalance, boolean manager, boolean administrator, String password,
                    String managerId) {
        this.staffNumber = staffNumber;
        this.forename = forename;
        this.surname = surname;
        this.emailAddress = emailAddress;
        this.department = department;
        this.dailyHoursPermitted = dailyHoursPermitted;
        this.weeklyHoursPermitted = weeklyHoursPermitted;
        this.flexiBalance = flexiBalance;
        this.manager = manager;
        this.administrator = administrator;
        this.password = password;
        this.managerId = managerId;
    }

    private String staffNumber;
    private String forename;
    private String surname;
    private String emailAddress;
    private String department;
    private String dailyHoursPermitted;
    private String weeklyHoursPermitted;
    private String flexiBalance;
    private boolean manager;
    private boolean administrator;
    private String password;
    private String managerId;

    public String getStaffNumber() {
        return staffNumber;
    }

    public void setStaffNumber(String staffNumber) {
        this.staffNumber = staffNumber;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

    public String getDailyHoursPermitted() {
        return dailyHoursPermitted;
    }

    public void setDailyHoursPermitted(String dailyHoursPermitted) {
        this.dailyHoursPermitted = dailyHoursPermitted;
    }

    public String getWeeklyHoursPermitted() {
        return weeklyHoursPermitted;
    }

    public void setWeeklyHoursPermitted(String weeklyHoursPermitted) {
        this.weeklyHoursPermitted = weeklyHoursPermitted;
    }

    public String getFlexiBalance() {
        return flexiBalance;
    }

    public void setFlexiBalance(String flexiBalance) {
        this.flexiBalance = flexiBalance;
    }

    public boolean isManager() {
        return manager;
    }

    public void setManager(boolean manager) {
        this.manager = manager;
    }

    public boolean isAdministrator() {
        return administrator;
    }

    public void setAdministrator(boolean administrator) {
        this.administrator = administrator;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    @Override
    public String toString() {
        return "Employee{" +
            "staffNumber='" + staffNumber + '\'' +
            ", forename='" + forename + '\'' +
            ", surname='" + surname + '\'' +
            ", emailAddress='" + emailAddress + '\'' +
            ", department='" + department + '\'' +
            ", dailyHoursPermitted=" + dailyHoursPermitted +
            ", weeklyHoursPermitted=" + weeklyHoursPermitted +
            ", flexiBalance=" + flexiBalance +
            ", manager=" + manager +
            ", administrator=" + administrator +
            ", password='" + password + '\'' +
            ", managerId='" + managerId + '\'' +
            '}';
    }

    public String[] getToString() {
        return new String[] {staffNumber, forename, surname, department, String.valueOf(dailyHoursPermitted), String.valueOf(weeklyHoursPermitted),
            String.valueOf(flexiBalance), String.valueOf(manager), String.valueOf(administrator), emailAddress, password, managerId};
    }
}
