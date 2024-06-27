package DB_Usage;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee {

    private int employeeId;
    private String fname;
    private String lname;
    private String email;
    private String phoneNum;
    private String address;
    private String NInumber;
    private float wage;
    private float hoursWorked;
    private Date joinDate;

    public Employee(int employeeId, String fname, String lname, String email, String phoneNum, String address,
                    String NInumber, float wage, float hoursWorked, Date joinDate) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.phoneNum = phoneNum;
        this.address = address;
        this.NInumber = NInumber;
        this.wage = wage;
        this.hoursWorked = hoursWorked;
        this.employeeId = employeeId;
        this.joinDate = joinDate;
    }
    public Employee(){}

    public String getEmployeeData(){
        return employeeId + " " + fname + " " + lname + " " + email + " " +
                phoneNum + " " + address + " " + NInumber + " " + wage + " " + hoursWorked + " " + joinDate;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getAddress() {
        return address;
    }

    public String getNInumber() {
        return NInumber;
    }

    public float getWage() {
        return wage;
    }

    public float getHoursWorked() {
        return hoursWorked;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getJoinDate() {
        return String.valueOf(joinDate);
    }
}
