package DB_Init;
import java.sql.*;

public class emsDB {

    private static final String db_url = "jdbc:mysql://127.0.0.1:3306/myems";
    private static final String db_username = "root";
    private static final String db_password = System.getenv("DB_PASS");

    public static User validateLogin(String email, String password) {
        try {
            Connection connection = DriverManager.getConnection(db_url, db_username, db_password);

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM users WHERE email = ? AND password = ?"
            );

            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int userId = resultSet.getInt("id");
                return new User(userId, email, password);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static boolean register(String email, String password) {
        try {
            if (!checkEmailInDB(email)) {
                Connection connection = DriverManager.getConnection(db_url, db_username, db_password);

                PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT INTO users(email, password) " + "VALUES(?, ?)"
                );

                preparedStatement.setString(1, email);
                preparedStatement.setString(2, password);
                preparedStatement.executeUpdate();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean checkEmailInDB(String email){
        try {
            Connection connection = DriverManager.getConnection(db_url, db_username, db_password);

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM users WHERE email = ?"
            );

            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(!resultSet.next()){
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}
