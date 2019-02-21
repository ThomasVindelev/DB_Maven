import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Start {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection("jdbc:mysql://den1.mysql4.gear.host/thomasdb", "thomasdb", "Wk6S_s-thr1M");

        Statement stmt = con.createStatement();

        String sql = "INSERT INTO persons VALUES (2, 'Kisbye', 'Nick', 'Atlantis', '?')";

        //stmt.execute(sql);
        //stmt.close();

        String sql_select = "SELECT * FROM persons";

        ResultSet resultSet = stmt.executeQuery(sql_select);

        List<Person> list = new ArrayList<Person>();

        while (resultSet.next()) {
            Person tmp = new Person();
            tmp.setPersonID(resultSet.getInt("PersonID"));
            tmp.setFirstName(resultSet.getString("FirstName"));
            tmp.setLastName(resultSet.getString("LastName"));
            tmp.setAddress(resultSet.getString("Address"));
            tmp.setCity(resultSet.getString("City"));
            list.add(tmp);
        }

        for (Person a : list) {
            System.out.println(a.getFirstName());
        }

        stmt.close();

    }
}
