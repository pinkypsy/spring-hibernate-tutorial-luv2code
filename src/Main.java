import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {
        Connection connection = ConnectionManager.getInstance().getConnection();
    }
}
