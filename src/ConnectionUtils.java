import java.sql.*;

public class ConnectionUtils {
    // Kết nối vào MySQL
    public static Connection getConnection() throws SQLException {
        String hostName = "localhost";

        String dbName = "huydata";
        String userName = "root";
        String password = "1234";

        // Cấu trúc URL Connection dành cho MySQL
        //VD: jdbc:mysql://localhost:3306/simplehr
        String connectionURL = "jdbc:mysql://" + hostName + ":3307/" + dbName;

        // Kết nối vào database mysql có URL như trên với userName và password đã khai báo
        Connection connection = DriverManager.getConnection(connectionURL, userName, password);

        return connection;
    }

    public static void main(String[] args) throws SQLException {
        System.out.println("Get connection...");

        // Tạo kết nối, lấy ra đối tượng Connection kết nối vào DB.
        Connection connection = getConnection();

        System.out.println(connection);
        System.out.println("Done!");

        // Câu lệnh xem dữ liệu
        // Ở đây lấy tất cả các cột từ bảng user
        // Nếu chỉ muốn lấy 1 vài cột
        // VD: String sql = "select userName, password from user";
        String sql = "select * from user";

        // Tạo đối tượng Statement thực thi câu lệnh trên
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

        // Thực thi câu lệnh SQL ở trên, trả về đối tượng ResultSet
        ResultSet resultSet = statement.executeQuery(sql);

        // Duyệt resultSet để lấy được dữ liệu
        int ID;
        String userName, password;

        //to last
        System.out.println("last: " + resultSet.last());

        ID = resultSet.getInt("ID");
        userName = resultSet.getString("userName");
        password = resultSet.getString("password");

        System.out.println(ID + " " + userName + " " + password);

        //to previous 1
        System.out.println("previous 1: " + resultSet.previous());

        ID = resultSet.getInt("ID");
        userName = resultSet.getString("userName");
        password = resultSet.getString("password");

        System.out.println(ID + " " + userName + " " + password);

        //to previous 2
        System.out.println("previous 2: " + resultSet.previous());

        ID = resultSet.getInt("ID");
        userName = resultSet.getString("userName");
        password = resultSet.getString("password");

        System.out.println(ID + " " + userName + " " + password);

        //to next 1
        System.out.println("next 1: " + resultSet.next());

        ID = resultSet.getInt("ID");
        userName = resultSet.getString("userName");
        password = resultSet.getString("password");

        System.out.println(ID + " " + userName + " " + password);

        connection.close();
    }
}


