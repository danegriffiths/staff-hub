package uk.dvla.staffhub.generator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import com.github.javafaker.Faker;

public class EmployeeGenerator {

    private List<Employee> employees = new ArrayList<>();
    private int staffNumber = 600000;
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
    private List<String> departments = Arrays.asList("Drivers-Input-1", "Drivers-Input-2", "Drivers-Input-3",
        "Drivers-Input-4", "Drivers-Input-5", "Drivers-Input-6", "Drivers-Input-7", "Drivers-Input-8", "Drivers-Input-9",
        "Drivers-Input-10", "Drivers-Input-11", "Drivers-Input-12", "Drivers-Input-13", "Drivers-Input-14",
        "Vehicles-Input-1", "Vehicles-Input-2", "Vehicles-Input-3", "Vehicles-Input-4", "Vehicles-Input-5",
        "Vehicles-Input-6", "Vehicles-Input-7", "Vehicles-Input-8", "Vehicles-Input-9", "Vehicles-Input-10",
        "Vehicles-Input-11", "Vehicles-Input-12", "Vehicles-Input-13", "Vehicles-Input-14", "Medical-1",
        "Medical-2", "Medical-3", "Medical-4", "Courts-1", "Courts-2", "Courts-3", "Courts-4", "Human-Resources-Drivers",
        "Human-Resources-Vehicles", "Human-Resources", "Information-Technology", "Finance-1", "Finance-2",
        "Print");


    Faker faker = new Faker();

    public List<Employee> getEmployees() {
        generateEmployees();

        for (Employee e : employees) {
            getManagers(e);
        }
        return employees;
    }

    private String flexiBalanceGenerator() {

        final double MAX = 37.0;
        final double MIN = -7.4;
        Random rand = new Random();

        double randomNum = MIN + (MAX - MIN) * rand.nextDouble();

        BigDecimal bd = new BigDecimal(randomNum).setScale(2, RoundingMode.HALF_UP);

        String hours = bd.toString().substring(0,bd.toString().length() - 3);
        String minutes = bd.toString().substring(bd.toString().length() - 2);
        double convertedMinutes = Integer.parseInt(minutes) * 0.6;

        int convertedMinutesToString = (int) convertedMinutes;
        String newMinutes = String.format("%02d", convertedMinutesToString);
        String date = hours + ":" + newMinutes + ":00";

        return date;
    }

    private double dailyHoursGenerator() {

        List<Double> hours = new ArrayList<>();
        hours.add(4.0);
        hours.add(4.3);
        hours.add(5.0);
        hours.add(5.3);
        hours.add(6.0);
        hours.add(6.3);
        hours.add(7.0);
        hours.add(7.24);

        Random rand = new Random();
        return hours.get(rand.nextInt(hours.size()));
    }

    private String weeklyHoursGenerator(double dailyHours) {
        final int MAX = 5;
        final int MIN = 3;
        Random rand = new Random();

        int randomNum = rand.nextInt(MAX - MIN + 1) + MIN;

        double calculatedTotal = dailyHours * randomNum;
        BigDecimal bd = new BigDecimal(calculatedTotal).setScale(2, RoundingMode.HALF_UP);

        String hours = bd.toString().substring(0,bd.toString().length() - 3);
        String minutes = bd.toString().substring(bd.toString().length() - 2);
        double convertedMinutes = Integer.parseInt(minutes) * 0.6;

        int convertedMinutesToString = (int) convertedMinutes;
        String newMinutes = String.format("%02d", convertedMinutesToString);
        String date = hours + ":" + newMinutes + ":00";

        return date;
    }

    private String departmentGenerator() {

        final int MAX = departments.size() -1;
        final int MIN = 0;
        Random rand = new Random();
        int index = rand.nextInt(MAX - MIN + 1) + MIN;
        String dept = departments.get(index);
        return dept;
    }

    private boolean isManager() {

        return (Math.random() > 0.75);
    }

    private boolean isAdministrator() {

        return (Math.random() > 0.995);

    }

    private void getManagers(Employee employee) {

        List<Manager> allManagers = new ArrayList<>();
        for (Employee e : employees) {
            if (e.isManager()) {
                Manager manager = new Manager(e.getStaffNumber(), e.getEmailAddress(), e.getDepartment());
                allManagers.add(manager);
            }
        }

        List<Manager> deptManager = allManagers.stream().filter(manager -> manager.getDepartment().equals(employee.getDepartment())).collect(Collectors.toList());

        final int MAX = deptManager.size() - 1;
        final int MIN = 0;
        Random rand = new Random();
        int index = rand.nextInt(MAX - MIN + 1) + MIN;
        Manager manager = deptManager.get(index);

        employee.setManagerId(manager.getStaffNumber());
    }

    private Employee generateEmployee() {
        staffNumber++;
        forename = faker.name().firstName();
        surname = faker.name().lastName();
        emailAddress = forename.charAt(0) + surname + "@dvla.gov.uk";
        double dailyHoursBeforeConversion = dailyHoursGenerator();
        weeklyHoursPermitted = weeklyHoursGenerator(dailyHoursBeforeConversion);
        flexiBalance = flexiBalanceGenerator();
        department = departmentGenerator();
        manager = isManager();
        administrator = isAdministrator();
        password = surname.toLowerCase() + forename.toLowerCase().charAt(0);
        managerId = null;


        BigDecimal bd = new BigDecimal(dailyHoursBeforeConversion).setScale(2, RoundingMode.HALF_UP);
        String date = bd+".00";
        dailyHoursPermitted = date.replace(".", ":");

        return new Employee(String.valueOf(staffNumber), forename, surname, emailAddress, department, dailyHoursPermitted,
            weeklyHoursPermitted, flexiBalance, manager, administrator, password, managerId);

    }

    private void generateEmployees() {

        Map<String, Integer> uniqueEmails = new HashMap<>();

        for (int i = 0; i < 6000; i++) {
            Employee employee = generateEmployee();

            if (uniqueEmails.containsKey(employee.getEmailAddress())) {
                uniqueEmails.put(employee.getEmailAddress(), uniqueEmails.get(employee.getEmailAddress()) + 1);
            } else {
                uniqueEmails.put(employee.getEmailAddress(), 0);
            }

            if (uniqueEmails.get(employee.getEmailAddress()) == 0) {
            } else {
                employee.setEmailAddress(employee.getForename().charAt(0) + surname + uniqueEmails.get(employee.getEmailAddress()) + "@dvla.gov.uk");
            }


            employees.add(employee);
        }
    }
}
