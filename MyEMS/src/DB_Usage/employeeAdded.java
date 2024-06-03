package DB_Usage;

public class employeeAdded {

    private final int userId;
    private final int id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String phoneNum;
    private final String address;
    private final String NInum;
    private final float wage;

    public employeeAdded(int userId, int id, String firstName, String lastName, String email,
                         String phoneNum, String address, String NInum, float wage){
        this.userId = userId;
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNum = phoneNum;
        this.address = address;
        this.NInum = NInum;
        this.wage = wage;
    }

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
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

    public String getNInum() {
        return NInum;
    }

    public float getWage() {
        return wage;
    }
}
