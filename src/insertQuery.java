import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class insertQuery {
    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionUtils.getConnection();

        String sql = "insert into user (userName, password) values ('tranquanghuy', '123')";

        Statement statement = connection.createStatement();

        statement.executeUpdate(sql);

        /* = "insert into user(userName, password)" + " values('dao', '123')";
        rowCount = statement.executeUpdate(sql);
        System.out.println(rowCount);*/
    }
}
