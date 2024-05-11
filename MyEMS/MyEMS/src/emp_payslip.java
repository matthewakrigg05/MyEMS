/* 
This file is currently not being worked on and is not intended to be included in the initial build of the app,
the file is however being kept in the source folder for when it is an appropriate time to come back to it.
*/

public class emp_payslip extends employee {

    private float totalPay = 0;
    private float takeHome = 0;
    private float taxPaid = 0;
    private float NIpaid = 0;
    public int month;
    public int year;

    public emp_payslip(){}

    public emp_payslip(String fname, String lname, String address, float wage, String NInumber, int month, int year) {
        super(fname, lname, address, wage, NInumber);
        this.month = month;
        this.year = year;
    }

    public String display_payslip(){
        return (getFirstName() + getLastName() + getTotalPay());
    }

    public float calcTotalPay(float wage, float hoursWorked) {
        float calcTotal = wage * hoursWorked;
        totalPay = calcTotal;
        return calcTotal;
    }

    public void setTotalPay(float totalPay) {this.totalPay = totalPay;}

    public float getTotalPay() {return this.totalPay;}

    public void setTakeHome(float takeHome) {this.takeHome = takeHome;}

    public float getTakeHome(){return this.takeHome;}

    public void setTaxPaid(float taxPaid){this.taxPaid = taxPaid;}

    public float getTaxPaid(){return this.taxPaid;}

    public void setNIpaid(float NIpaid){this.NIpaid = NIpaid;}

    public float getNIpaid(){return this.NIpaid;}
}




