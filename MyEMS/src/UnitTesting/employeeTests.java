package UnitTesting;
import DB_Usage.Employee;
import org.junit.jupiter.api.Test;
import java.sql.Date;
import java.util.Objects;

public class employeeTests extends Employee {

    Employee testEmployee = new Employee(1, "Matt", "Akrigg", "matt@email.com", "0735748283", "8 Road Street",
            "UH765843C", 8.1f, 0f, new Date(123, 9,20));

    @Test
    void testGetEmployeeData() {
        if (Objects.equals(testEmployee.getEmployeeData(), "1 Matt Akrigg matt@email.com 0735748283 8 Road Street UH765843C 8.1 0.0 2023-10-20")){
            System.out.println("Test 1 successful");
        }
        else {System.out.println("Test 1 unsuccessful");}
    }

    @Test
    void testGetFname() {
    }

    @Test
    void testGetLname() {
    }

    @Test
    void testGetEmail() {
    }

    @Test
    void testGetPhoneNum() {
    }

    @Test
    void testGetAddress() {
    }

    @Test
    void testGetNInumber() {
    }

    @Test
    void testGetWage() {
    }

    @Test
    void testGetHoursWorked() {
    }

    @Test
    void testGetEmployeeId() {
    }

    @Test
    void testGetJoinDate() {
    }
}
