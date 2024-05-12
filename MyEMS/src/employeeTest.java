import org.junit.jupiter.api.Test;

class employeeTest {

    employee Employee1 = new employee("Matthew", "Akrigg", "Manchester",8.6F, "PK893527C");


    @Test
    void employeeDetails() {
        Employee1.employeeDetails();
    }

    @Test
    void setFirstName() {
        Employee1.setFirstName("Philip");
        Employee1.employeeDetails();
    }

    @Test
    void getFirstName() {
        System.out.println(Employee1.getFirstName());
    }

    @Test
    void setLastName() {
        Employee1.setLastName("Neville");
        Employee1.employeeDetails();
    }

    @Test
    void getLastName() {
        System.out.println(Employee1.getLastName());
    }

    @Test
    void setAddress(){
        Employee1.setAddress("Bristol");
        Employee1.employeeDetails();
    }

    @Test
    void getAddress(){System.out.println(Employee1.getAddress());}

    @Test
    void setWage() {
        Employee1.setWage(9.7F);
        Employee1.employeeDetails();
    }

    @Test
    void getWage() {
        System.out.println(Employee1.getWage());
    }

    @Test
    void setHoursWorked() {
        Employee1.setHoursWorked(65);
        Employee1.employeeDetails();
    }

    @Test
    void getHoursWorked() {
        System.out.println(Employee1.getHoursWorked());
    }

    @Test
    void getEmail() {
        System.out.println(Employee1.getEmail());
    }

    @Test
    void setEmail() {
        Employee1.setEmail("matt@email.org");
        Employee1.employeeDetails();
    }

    @Test
    void getPhoneNum() {
        System.out.println(Employee1.getPhoneNum());
    }

    @Test
    void setPhoneNum() {
        Employee1.setPhoneNum("07555 365444");
        Employee1.employeeDetails();
    }

    @Test
    void setNInumber(){
        Employee1.setNInumber("PK6257348C");
        Employee1.employeeDetails();
    }

    @Test
    void getNInumber(){
        System.out.println(Employee1.getNInumber());
    }
}