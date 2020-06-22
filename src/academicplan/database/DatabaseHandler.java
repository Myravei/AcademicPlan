package academicplan.database;

import academicplan.models.Discipline;

import java.util.ArrayList;
import java.sql.*;

public class DatabaseHandler extends Configs{

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName + "?serverTimezone=UTC";
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(connectionString, dbUser, dbPass);
    }
}
