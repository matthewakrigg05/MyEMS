package DB_Usage;

public class Employee {

    private String fname;
    private String lname;
    private String email;
    private String phoneNum;
    private String address;
    private String NInumber;
    private float wage;
    private float hoursWorked;

    public Employee(String fname, String lname, String email, String phoneNum, String address, String NInumber, float wage,
                    float hoursWorked) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.phoneNum = phoneNum;
        this.address = address;
        this.NInumber = NInumber;
        this.wage = wage;
        this.hoursWorked = hoursWorked;

    }
    public Employee(){}

    public void employeeDetails(){
        System.out.println(this.fname + " " + this.lname + " " + this.wage + " " + this.email + " " + this.phoneNum
        + " " + this.hoursWorked);
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
}
