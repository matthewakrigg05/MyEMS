package DB_Usage;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class employeesDB {

    private static final String db_url = System.getenv("DB_URL");
    private static final String db_username = "root";
    private static final String db_password = System.getenv("DB_PASS");

    public static void addEmployee(int user_id, String fname, String lname,
                                   String email, String phoneNum, String address, String NI,
                                   float wage){
        try{
            Connection connection = DriverManager.getConnection(db_url, db_username, db_password);

            PreparedStatement insertEmployee = connection.prepareStatement(
                    "INSERT employees(fname, lname, email, phoneNum, address, NI, wage, hours, user_id, date) "
                            + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, NOW())"
            );

            insertEmployee.setString(1, fname);
            insertEmployee.setString(2, lname);
            insertEmployee.setString(3, email);
            insertEmployee.setString(4, phoneNum);
            insertEmployee.setString(5, address);
            insertEmployee.setString(6, NI);
            insertEmployee.setBigDecimal(7, BigDecimal.valueOf(wage));
            insertEmployee.setBigDecimal(8, BigDecimal.valueOf(0));
            insertEmployee.setInt(9, user_id);
            insertEmployee.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Employee[] getEmployeesFromDB(){

        Employee[] employees = new Employee[10];
        
        for(int i = 0; i < 10; i++){

        }

    return employees;
    }
}
