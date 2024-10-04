package DB_Usage;
import UIs.myEmsUI;

import javax.swing.*;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

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

    public static ArrayList<Employee> getEmployees(User user){
        ArrayList<Employee> employees = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(db_url, db_username, db_password);

            PreparedStatement allEmployees = connection.prepareStatement(
                    "SELECT * FROM employees WHERE user_id = ?"
            );
            allEmployees.setInt(1, user.getId());

            ResultSet results = allEmployees.executeQuery();

            while(results.next()){
                Employee employee = new Employee(
                        results.getInt("id"),
                        results.getString("fname"),
                        results.getString("lname"),
                        results.getString("email"),
                        results.getString("phonenum"),
                        results.getString("address"),
                        results.getString("NI"),
                        results.getBigDecimal("wage").floatValue(),
                        results.getBigDecimal("hours").floatValue(),
                        results.getDate("date"));

                employees.add(employee);}

        } catch (SQLException e) { throw new RuntimeException(e); }

        return employees;
    }

    public static boolean validateInput(JTextField fname, JTextField lname, JTextField email, JTextField phoneNum,
                                        JTextField address, JTextField NInum, JTextField wage, myEmsUI myEmsUI){

        String firstName = fname.getText();
        String lastName = lname.getText();
        String emailAdd = email.getText();
        String phoneNumber = phoneNum.getText();
        String homeAddress = address.getText();
        String NiNum = NInum.getText();
        String wages = wage.getText();

        if (firstName.isEmpty() || lastName.isEmpty() || wage.getText().isEmpty() || NiNum.isEmpty() ||
                homeAddress.isEmpty() || wages.isEmpty() || (emailAdd.isEmpty() && phoneNumber.isEmpty())){
            JOptionPane.showMessageDialog(myEmsUI, "Please fill all necessary fields in appropriate formats.");
            return false;
        }

        if (!wages.matches("[-+]?[0-9]*\\.?[0-9]+")){
            JOptionPane.showMessageDialog(myEmsUI, "Please ensure that the wage is numerical.");
            return false;
        }

        return true;
    }
}
