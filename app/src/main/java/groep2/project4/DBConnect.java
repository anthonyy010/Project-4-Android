package groep2.project4;

import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

/**
 * Created by Dominic on 21-6-2016.
 */
public class DBConnect {
    private static Connection con;
    private static Statement stmnt;

    public static void OpenDatabase() { // Attempts to make a connection to the database and creates a new statement
        try {
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "tjappie12");
            stmnt = con.createStatement();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
    public static int getNumber(String SQL) {
        int res = 0;
        Log.e("test","Poephoofd");
        try {
            OpenDatabase();
            ResultSet rs = stmnt.executeQuery(SQL);
            while (rs.next()) {
                res = Integer.parseInt(rs.getString("count"));
            }
            con.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return res;
    }


}
