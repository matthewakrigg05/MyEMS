package DB_Usage;
import java.util.ArrayList;

public class employeeInfo {

    public static String[][] getEmployeeInfo(User user) {
        ArrayList<Employee> employees = employeesDB.getEmployees(user);
        String[][] employeeInfo = new String[employees.size()][10];

        for (Employee employee : employees) {
            employeeInfo[(employee.getEmployeeId() - 1)][0] = String.valueOf(employee.getEmployeeId());
            employeeInfo[(employee.getEmployeeId() - 1)][1] = employee.getFname();
            employeeInfo[(employee.getEmployeeId() - 1)][2] = employee.getLname();
            employeeInfo[(employee.getEmployeeId() - 1)][3] = employee.getEmail();
            employeeInfo[(employee.getEmployeeId() - 1)][4] = employee.getPhoneNum();
            employeeInfo[(employee.getEmployeeId() - 1)][5] = employee.getAddress();
            employeeInfo[(employee.getEmployeeId() - 1)][6] = employee.getNInumber();
            employeeInfo[(employee.getEmployeeId() - 1)][7] = String.valueOf(employee.getWage());
            employeeInfo[(employee.getEmployeeId() - 1)][8] = String.valueOf(employee.getHoursWorked());
            employeeInfo[(employee.getEmployeeId() - 1)][9] = String.valueOf(employee.getJoinDate());
        }
        return employeeInfo;
    }

    public static String[] getColumnNames(){
        return new String[]{"ID", "First Name", "Last Name", "Email", "Phone Number", "Address", "NI", "Wage", "Hours", "Joined"};
    }
}
