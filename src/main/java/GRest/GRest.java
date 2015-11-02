package GRest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.sql.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by goga on 19.10.15.
 */

@SpringBootApplication
@RestController
public class GRest implements CommandLineRunner {
    Connection c = null;
    Statement stmt = null;
    public static  ResultSet restSet;

    @Override
    public void run(String... args) throws Exception {
        Class.forName("org.sqlite.JDBC");
        c = DriverManager.getConnection("jdbc:sqlite:test.db");
        String sql = "CREATE TABLE IF NOT EXISTS PEOPLE ('Year' INTEGER, 'Name' TEXT);";
        stmt = c.createStatement();
        stmt.executeUpdate(sql);
        //stmt.close();
        //c.close();
    }

    public static void main(String[] args) {SpringApplication.run(GRest.class, args);}

    // adding to the JSON format { key: 19, value: Goga } ...
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public void post_one (@RequestBody String value) throws Exception
    {
        PUT(value);
    }
    // Отображение персонажей возраста key
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String get_look (@RequestHeader("key") int key) throws Exception
    {
        String sql = "SELECT * FROM PEOPLE";
        restSet = stmt.executeQuery(sql);
        String result = "";
        while(restSet.next()) {
            int id = restSet.getInt("Year");
            String name = restSet.getString("Name");
            if (id == key)
                result += id + " " + name + "\n" ;
        }
        return result;
    }

    // Удаление персонажей возраста key
    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public String delete_one (@RequestHeader("key") int key) throws Exception
    {
        String result = "Deleted :\n";
        result += get_look(key);
        String sql = "DELETE FROM PEOPLE WHERE Year = '"+ key +"';";
        stmt.executeUpdate(sql);
        return result;
    }
    //adding to the JSON format [PUT]
    public void PUT (String str) throws SQLException {
        while (str.length() > 3) {
            int[] skay =   {(str.indexOf("\"key\":") + 6),
                            (str.indexOf("\"key\": ") + 7),
                            (str.indexOf("\"key\" :") + 7),
                            (str.indexOf("\"key\" : ") + 8)};
            int endkey = str.indexOf(",");
            int[] svalue = {(str.indexOf("\"value\":") + 8),
                            (str.indexOf("\"value\": ") + 9),
                            (str.indexOf("\"value\" :") + 9),
                            (str.indexOf("\"value\" : ") + 10)};
            int endvalue = str.indexOf("}");
            int key = Integer.valueOf(str.substring(Max(skay, endvalue), endkey));
            String valueone = str.substring(Max(svalue, endvalue), endvalue);
            String value = valueone.substring(1, valueone.length() - 2);
            String sql = "INSERT INTO PEOPLE ('Year', 'Name') VALUES ("+ key +", '"+ value +"');";
            stmt.executeUpdate(sql);
            str = str.substring(endvalue + 1);
        }
    }
    public int Max(int a[],int stopval)
    {
        int max = -1;
        for (int i = 0; i < a.length; i++) {
            if (max < a[i] && a[i] < stopval)
                max = a[i];
        }
        return max;
    }
}