import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class updateQuery {
    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionUtils.getConnection();

        Statement statement = connection.createStatement();

        String sql = "update user set password = '321' where ID = 12";

        statement.executeUpdate(sql);
    }
}
