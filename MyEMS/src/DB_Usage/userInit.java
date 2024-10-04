package DB_Usage;
import java.sql.*;
/*
The goal of this class is to connect to the database and manage how user data is passed on to the database; this is as
well as making sure that a user email does not already exist in the database so that it cannot be used again.
 */

public class userInit {

    // Db password is maintained in a dot env file to prevent the password to the db being published to GH
    private static final String db_url = System.getenv("DB_URL");
    private static final String db_username = "root";
    private static final String db_password = System.getenv("DB_PASS");

    // Method used to check the login details given with the db and ensure that they match.
    public static User validateLogin(String email, String password) {
        try {
            Connection connection = DriverManager.getConnection(db_url, db_username, db_password);
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM users WHERE email = ? AND password = ?"
            );

            preparedStatement.setString(1, email);
            preparedStatement.setString(2, passwordUtils.hashPassword(password));
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

    // Method used to add user information to the db, also hashes the user password.
    public static boolean register(String email, String password) {
        try {
            if (!checkEmailInDB(email)) {
                Connection connection = DriverManager.getConnection(db_url, db_username, db_password);

                PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT INTO users(email, password) " + "VALUES(?, ?)"
                );

                preparedStatement.setString(1, email);
                preparedStatement.setString(2, passwordUtils.hashPassword(password));
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
