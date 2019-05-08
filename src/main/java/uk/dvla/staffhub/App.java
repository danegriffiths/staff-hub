package uk.dvla.staffhub;

import uk.dvla.staffhub.generator.Employee;
import uk.dvla.staffhub.generator.EmployeeGenerator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.opencsv.CSVWriter;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        System.out.println("Hello World!");

        EmployeeGenerator emps = new EmployeeGenerator();
        List<Employee> employees = emps.getEmployees();
        int countAdmin = 0;
        int countManager = 0;

        FileWriter fileWriter = new FileWriter("test.csv");

        CSVWriter csvWriter = new CSVWriter(fileWriter);

        for(Employee e : employees) {
            System.out.println(e.getToString());
            csvWriter.writeNext(e.getToString());
            if (e.isAdministrator()) {
                countAdmin++;
            }
            if (e.isManager()) {
                countManager++;
            }
        }
        csvWriter.close();
        System.out.println("Number of admins: " + countAdmin);
        System.out.println("Number of managers: " + countManager);




//        public void generateCSV() throws IOException {
//            File csvOutputFile = new File("TEST_FILE");
//            try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
//                employees.stream()
//                    .map(this::convertToCSV)
//                    .forEach(pw::println);
//            }
//        }
//
//        public String convertToCSV(List<Employee> data) {
//            return Stream.of(data)
//                .map(this::escapeSpecialCharacters)
//                .collect(Collectors.joining(","));
//        }

    }
}
