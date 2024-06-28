package UnitTesting;
import DB_Usage.Employee;
import org.junit.jupiter.api.*;
import java.sql.Date;
import java.util.Objects;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class employeeTests extends Employee {

    Employee exampleEmployee = new Employee(1, "Matt", "Akrigg", "matt@email.com", "0735748283", "8 Road Street",
            "UH765843C", 8.1f, 0f, new Date(123, 9, 20));


    @Order(1)
    @Test
    void testGetEmployeeData() {
        if (Objects.equals(exampleEmployee.getEmployeeData(), "1 Matt Akrigg matt@email.com 0735748283 8 Road Street UH765843C 8.1 0.0 2023-10-20")){
            System.out.println("Test 1 Successful");
        }
        else {System.out.println("Test 1 unsuccessful");}
    }

    @Order(2)
    @Test
    void testGetFname() {
        if (Objects.equals(exampleEmployee.getFname(), "Matt")) {System.out.println("Test 2 Successful");}
        else {System.out.println("Test 2 unsuccessful");}
    }

    @Order(3)
    @Test
    void testGetLname() {
        if (Objects.equals(exampleEmployee.getLname(), "Akrigg")) {System.out.println("Test 3 Successful");}
        else {System.out.println("Test 3 unsuccessful");}
    }

    @Order(4)
    @Test
    void testGetEmail() {
        if (Objects.equals(exampleEmployee.getEmail(), "matt@email.com")) {System.out.println("Test 4 Successful");}
        else {System.out.println("Test 4 unsuccessful");}
    }

    @Order(5)
    @Test
    void testGetPhoneNum() {
        if (Objects.equals(exampleEmployee.getPhoneNum(), "0735748283")) {System.out.println("Test 5 Successful");}
        else {System.out.println("Test 5 unsuccessful");}
    }

    @Order(6)
    @Test
    void testGetAddress() {
        if (Objects.equals(exampleEmployee.getAddress(), "8 Road Street")) {System.out.println("Test 6 Successful");}
        else {System.out.println("Test 6 unsuccessful");}
    }

    @Order(7)
    @Test
    void testGetNInumber() {
        if (Objects.equals(exampleEmployee.getNInumber(), "UH765843C")) {System.out.println("Test 7 Successful");}
        else {System.out.println("Test 7 unsuccessful");}
    }

    @Order(8)
    @Test
    void testGetWage() {
        if (exampleEmployee.getWage() == 8.1f) {System.out.println("Test 8 Successful");}
        else {System.out.println("Test 8 unsuccessful");}
    }

    @Order(9)
    @Test
    void testGetHoursWorked() {
        if (exampleEmployee.getHoursWorked() == 0.0f) {System.out.println("Test 9 Successful");}
        else {System.out.println("Test 9 unsuccessful");}
    }

    @Order(10)
    @Test
    void testGetEmployeeId() {
        if (exampleEmployee.getEmployeeId() == 1) {System.out.println("Test 10 Successful");}
        else {System.out.println("Test 10 unsuccessful");}
    }

    @Order(11)
    @Test
    void testGetJoinDate() {
        if (Objects.equals(exampleEmployee.getJoinDate(), "2023-10-20")) {System.out.println("Test 11 Successful");}
        else {System.out.println("Test 11 unsuccessful");}
    }
}
