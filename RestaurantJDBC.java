import java.sql.*;

public class RestaurantJDBC {

    static final String URL = "jdbc:mysql://localhost:3306/RestaurantDB?useSSL=false&serverTimezone=UTC";
    static final String USER = "root";
    static final String PASS = "password";

    public static void main(String[] args) {

        try {
            // Load Driver 
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(URL, USER, PASS);

            Statement stmt = con.createStatement();

            // Insert Restaurants
            String insertRes = "INSERT INTO Restaurant (Name, Address) VALUES (?, ?)";
            PreparedStatement psRes = con.prepareStatement(insertRes);

            for (int i = 1; i <= 10; i++) {
                psRes.setString(1, "Restaurant_" + i);
                psRes.setString(2, "Address_" + i);
                psRes.executeUpdate();
            }

            // Add Cafe Java
            psRes.setString(1, "Cafe Java");
            psRes.setString(2, "Main Street");
            psRes.executeUpdate();

            // Insert Menu Items
            String insertMenu = "INSERT INTO MenuItem (Name, Price, ResId) VALUES (?, ?, ?)";
            PreparedStatement psMenu = con.prepareStatement(insertMenu);

            for (int i = 1; i <= 10; i++) {
                psMenu.setString(1, "Item_" + i);
                psMenu.setDouble(2, i * 50); 
                psMenu.setInt(3, (i % 5) + 1);
                psMenu.executeUpdate();
            }

            // Items for Cafe Java 
            psMenu.setString(1, "Coffee");
            psMenu.setDouble(2, 80);
            psMenu.setInt(3, 11);
            psMenu.executeUpdate();

            psMenu.setString(1, "Pizza");
            psMenu.setDouble(2, 120);
            psMenu.setInt(3, 11);
            psMenu.executeUpdate();

            // SELECT price <= 100
            System.out.println("\n--- Menu Items (Price <= 100) ---");
            ResultSet rs1 = stmt.executeQuery("SELECT * FROM MenuItem WHERE Price <= 100");
            printTable(rs1);

            // SELECT items in Cafe Java
            System.out.println("\n--- Menu Items in Cafe Java ---");
            ResultSet rs2 = stmt.executeQuery(
                "SELECT m.* FROM MenuItem m JOIN Restaurant r ON m.ResId = r.Id WHERE r.Name='Cafe Java'"
            );
            printTable(rs2);

            // UPDATE price <=100 → 200
            int updated = stmt.executeUpdate("UPDATE MenuItem SET Price = 200 WHERE Price <= 100");
            System.out.println("\nRows Updated: " + updated);

            System.out.println("\n--- After Update ---");
            printTable(stmt.executeQuery("SELECT * FROM MenuItem"));

            // DELETE name starts with P
            int deleted = stmt.executeUpdate("DELETE FROM MenuItem WHERE Name LIKE 'P%'");
            System.out.println("\nRows Deleted: " + deleted);

            System.out.println("\n--- After Delete ---");
            printTable(stmt.executeQuery("SELECT * FROM MenuItem"));

            // Close
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Utility to print ResultSet in table format
    public static void printTable(ResultSet rs) throws SQLException {
        ResultSetMetaData md = rs.getMetaData();
        int cols = md.getColumnCount();

        // Header
        for (int i = 1; i <= cols; i++) {
            System.out.print(md.getColumnName(i) + "\t");
        }
        System.out.println();

        // Rows
        while (rs.next()) {
            for (int i = 1; i <= cols; i++) {
                System.out.print(rs.getString(i) + "\t");
            }
            System.out.println();
        }
    }
}