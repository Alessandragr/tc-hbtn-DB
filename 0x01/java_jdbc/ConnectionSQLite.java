import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSQLite {
   private static Connection connection = null;
   private static String url = "jdbc:sqlite:sqlite_database_2022.db";
   public static void initConnection() {
         try {
            if (connection == null) {
               connection = DriverManager.getConnection(url);
               System.out.println("UP");
            } else if (connection.isClosed()) {
               connection = null;
            }
         } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
         }
   }

   public static void main(String[] args) {
      initConnection();
   }
}



