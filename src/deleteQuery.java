import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class deleteQuery {
    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionUtils.getConnection();

        //String sql = "delete from user where ID = 9";
        String sql = "delete from user where userName like 'ngoan'";

        Statement statement = connection.createStatement();

        statement.executeUpdate(sql);
    }
}
