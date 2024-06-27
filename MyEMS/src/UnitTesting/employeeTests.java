package UnitTesting;
import DB_Usage.Employee;
import org.junit.jupiter.api.Test;
import java.sql.Date;
import java.util.Objects;

public class employeeTests extends Employee {

    Employee exampleEmployee = new Employee(1, "Matt", "Akrigg", "matt@email.com", "0735748283", "8 Road Street",
            "UH765843C", 8.1f, 0f, new Date(123, 9, 20));

    @Test
    void testGetEmployeeData() {
        if (Objects.equals(exampleEmployee.getEmployeeData(), "1 Matt Akrigg matt@email.com 0735748283 8 Road Street UH765843C 8.1 0.0 2023-10-20")){
            System.out.println("Test 1 successful");
        }
        else {System.out.println("Test 1 unsuccessful");}
    }

    @Test
    void testGetFname() {
        if (Objects.equals(exampleEmployee.getFname(), "Matt")) {System.out.print("Test 2 Successful");}
        else {System.out.println("Test 2 unsuccessful");}
    }

    @Test
    void testGetLname() {
        if (Objects.equals(exampleEmployee.getLname(), "Akrigg")) {System.out.print("Test 3 Successful");}
        else {System.out.println("Test 3 unsuccessful");}
    }

    @Test
    void testGetEmail() {
        if (Objects.equals(exampleEmployee.getEmail(), "matt@email.com")) {System.out.print("Test 4 Successful");}
        else {System.out.println("Test 4 unsuccessful");}
    }

    @Test
    void testGetPhoneNum() {
        if (Objects.equals(exampleEmployee.getPhoneNum(), "0735748283")) {System.out.print("Test 5 Successful");}
        else {System.out.println("Test 5 unsuccessful");}
    }

    @Test
    void testGetAddress() {
        if (Objects.equals(exampleEmployee.getAddress(), "8 Road Street")) {System.out.print("Test 6 Successful");}
        else {System.out.println("Test 6 unsuccessful");}
    }

    @Test
    void testGetNInumber() {
        if (Objects.equals(exampleEmployee.getNInumber(), "UH765843C")) {System.out.print("Test 7 Successful");}
        else {System.out.println("Test 7 unsuccessful");}
    }

    @Test
    void testGetWage() {
        if (exampleEmployee.getWage() == 8.1f) {System.out.print("Test 8 Successful");}
        else {System.out.println("Test 8 unsuccessful");}
    }

    @Test
    void testGetHoursWorked() {
        if (exampleEmployee.getHoursWorked() == 0.0f) {System.out.print("Test 9 Successful");}
        else {System.out.println("Test 9 unsuccessful");}
    }

    @Test
    void testGetEmployeeId() {
        if (exampleEmployee.getEmployeeId() == 1) {System.out.print("Test 10 Successful");}
        else {System.out.println("Test 10 unsuccessful");}
    }

    @Test
    void testGetJoinDate() {
        if (Objects.equals(exampleEmployee.getJoinDate(), "2023-10-20")) {System.out.print("Test 11 Successful");}
        else {System.out.println("Test 11 unsuccessful");}
    }
}
