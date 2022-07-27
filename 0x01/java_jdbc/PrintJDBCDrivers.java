import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;
import java.util.Iterator;

public class PrintJDBCDrivers {
    public static void main(String[] args) {
        Enumeration<Driver> driverEnumeration = DriverManager.getDrivers();

        for (Iterator<Driver> driverIterator = driverEnumeration.asIterator(); driverIterator.hasNext();) {
            Driver driver = driverIterator.next();
            System.out.println("Nome: " + driver.getClass().getName() +
                    "Major Version: " + driver.getMajorVersion() +
                    "Minor Version: " + driver.getMinorVersion());
        }


    }
}
