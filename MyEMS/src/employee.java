public class employee {

    private String name = "";
    private float wage = 0;
    private float hoursWorked = 0;

    public employee(String name, float wage) {
        this.name = name;
        this.wage = wage;
    }

    private float months_pay() {
        return hoursWorked * wage;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

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











}
