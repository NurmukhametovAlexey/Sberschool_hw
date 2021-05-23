import org.slf4j.LoggerFactory;

import java.sql.*;
import org.slf4j.Logger;

public class H2Example {

    private final static Logger logger = LoggerFactory.getLogger(H2Example.class);

    private static final String URL_MEM = "jdbc:h2:mem:";
    private static final String USER = "sa";
    private static final String PASSWD = "sa";
    private static Connection connection;

    public static void main(String[] args) {

        try {
            fillDB();
            practiceTask1();
            System.out.println();
            practiceTask2();
            System.out.println();
            practiceTask3();
        } catch (SQLException e) {
            logger.atError().log(e.getMessage() + "\n" +
                    e.getSQLState() + "\n" + e.getErrorCode());
        } finally {
            try {
                connection.close();
            }
            catch (SQLException e) {
                logger.atError().log(e.getMessage() + "\n" +
                        e.getSQLState() + "\n" + e.getErrorCode());
            }
        }

        logger.atInfo().log("Program finished");
    }

    static void practiceTask1() throws SQLException {

        System.out.println("Practice task #1 (prepareStatement(\"SELECT * FROM species WHERE ID = ?\")):");

        PreparedStatement ps = getConnection().prepareStatement("SELECT * FROM species WHERE ID = ?");

        System.out.println("Setting ID to 1:");

        ps.setInt(1,1);
        printResultSet(ps.executeQuery());

        System.out.println("\nSetting ID to 2:");

        ps.setInt(1,2);
        printResultSet(ps.executeQuery());
    }

    static void practiceTask2() throws SQLException {

        System.out.println("Practice task #2 (\"SELECT * FROM $tableName\"):");
        String strQuery = "SELECT * FROM $tableName";

        System.out.println("Printing the whole table \"species\"");
        PreparedStatement ps = getConnection().prepareStatement(strQuery.replace("$tableName", "species"));
        printResultSet(ps.executeQuery());

        System.out.println("\nPrinting the whole table \"animal\"");
        ps = getConnection().prepareStatement(strQuery.replace("$tableName", "animal"));
        printResultSet(ps.executeQuery());
    }

    static void practiceTask3() throws SQLException {
        System.out.println("Practice task #3 (\"SELECT id, name FROM animal\" -> getObject()):");
        Statement st = getConnection().createStatement();
        ResultSet rs = st.executeQuery("SELECT id, name, date_born FROM animal");

        final int width = 20;
        String format = "%-" + width + "s";
        System.out.printf(format+format+format + "\n", "id", "name","date_born");
        while (rs.next()) {
            Object tmpId = rs.getObject("id");
            Object tmpName = rs.getObject("name");
            Object tmpDate = rs.getObject("date_born");
            System.out.printf(format+format+format + "\n",
                    tmpId + " (" + determineClass(tmpId).getSimpleName() + ")",
                    tmpName + " (" + determineClass(tmpName).getSimpleName() + ")",
                    tmpDate + " (" + determineClass(tmpDate).getSimpleName() + ")");
        }
    }

    static void fillDB() throws SQLException {
        try (Statement stmt = getConnection().createStatement()) {
            stmt.executeUpdate("CREATE TABLE species ( "
                    + "id INTEGER PRIMARY KEY, "
                    + "name VARCHAR(255), "
                    + "num_acres DECIMAL)");
            stmt.executeUpdate("CREATE TABLE animal ( "
                    + "id INTEGER PRIMARY KEY, "
                    + "species_id integer, "
                    + "name VARCHAR(255), "
                    + "date_born DATE)");
            stmt.executeUpdate("INSERT INTO species VALUES (1, 'African Elephant', 7.5)");
            stmt.executeUpdate("INSERT INTO species VALUES (2, 'Zebra', 1.2)");
            stmt.executeUpdate("INSERT INTO animal VALUES (1, 1, 'Elsa', '2001-05-06')");
            stmt.executeUpdate("INSERT INTO animal VALUES (2, 2, 'Zelda', '2002-08-15')");
            stmt.executeUpdate("INSERT INTO animal VALUES (3, 1, 'Ester', '2002-09-09')");
            stmt.executeUpdate("INSERT INTO animal VALUES (4, 1, 'Eddie', '2010-06-08')");
            stmt.executeUpdate("INSERT INTO animal VALUES (5, 2, 'Zoe', '2005-11-12')");
        }
    }

    static void printResultSet(ResultSet rs) throws SQLException {

        ResultSetMetaData rsmd = rs.getMetaData();
        int columnsNumber = rsmd.getColumnCount();

        final int width = 20;
        String format = "%-" + width + "s";

        for (int i = 1; i <= columnsNumber; i++) {
            System.out.printf(format, rsmd.getColumnName(i));
        }
        System.out.println();
        while (rs.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                System.out.printf(format,rs.getString(i));
            }
            System.out.println();
        }

    }

    private static Class determineClass(Object o) {
        Class[] possibleClasses = new Class[] {Boolean.class, java.sql.Date.class, Double.class, Integer.class,
        Long.class, String.class, java.sql.Time.class, java.sql.Date.class, java.sql.Timestamp.class};

        for (Class c: possibleClasses) {
            if (c.isInstance(o))
                return c;
        }
        return Object.class;
    }

    static Connection getConnection() throws SQLException {
        connection = (connection == null) ? DriverManager.getConnection(URL_MEM, USER, PASSWD) : connection;
        return connection;
    }
}
