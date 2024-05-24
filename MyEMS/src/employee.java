public class employee {

    private String fname = "";
    private String lname = "";
    private String email = "None";
    private String phoneNum = "None";
    private String address = "";
    private String NInumber = "";
    private float wage = 0;
    private float hoursWorked = 0;

    public employee(String fname, String lname, String address, float wage, String NInumber) {
        this.fname = fname;
        this.lname = lname;
        this.address = address;
        this.wage = wage;
        this.NInumber = NInumber;
    }

    public employee(){}

    public void employeeDetails(){
        System.out.println(this.fname + " " + this.lname + " " + this.wage + " " + this.email + " " + this.phoneNum
        + " " + this.hoursWorked);
    }

    public void setFirstName(String name){
        this.fname = name;
    }

    public String getFirstName(){
        return this.fname;
    }

    public void setLastName(String name){
        this.lname = name;
    }

    public String getLastName(){
        return this.lname;
    }

    public void setAddress(String address){this.address = address;}

    public String getAddress(){return this.address;}

    public void setWage(float wage) {
        this.wage = wage;
    }

    public float getWage(){
        return this.wage;
    }

    public void setHoursWorked(float hoursWorked){
        this.hoursWorked = hoursWorked;
    }

    public float getHoursWorked() {
        return this.hoursWorked;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPhoneNum(){
        return this.phoneNum;
    }

    public void setPhoneNum(String phoneNum){
        this.phoneNum = phoneNum;
    }

    public void setNInumber(String NI){this.NInumber = NI;}

    public String getNInumber(){return this.NInumber;}

}
