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

    public ArrayList<Discipline> getDisciplines() {
        ArrayList<Discipline> disciplines = new ArrayList<>();
        try(
                Statement statement = getDbConnection().createStatement();
                ResultSet set = statement.executeQuery("Select * From " + Const.DISCIPLINE_TABLE)
        ){
            while (set.next()){
                int id = set.getInt(Const.DISCIPLINE_ID);
                int semester = set.getInt(Const.DISCIPLINE_SEMESTER);
                String name = set.getString(Const.DISCIPLINE_NAME);
                int lectures = set.getInt(Const.DISCIPLINE_LECTURES);
                int practices = set.getInt(Const.DISCIPLINE_PRACTICES);
                int laboratories = set.getInt(Const.DISCIPLINE_LABORATORIES);
                int trudoemkost = set.getInt(Const.DISCIPLINE_TRUDOEMKOST);
                String control = set.getString(Const.DISCIPLINE_CONTROL);
                boolean coursework = set.getBoolean(Const.DISCIPLINE_COURSEWORK);
                disciplines.add(new Discipline(id, semester, name, lectures, practices, laboratories, trudoemkost, control, coursework));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return disciplines;
    }
}
