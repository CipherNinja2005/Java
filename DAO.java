import java.sql.*;

public class DAO {

    public void insertMenuItem(String name, double price, int resId) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "INSERT INTO MenuItem (Name, Price, ResId) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setDouble(2, price);
            ps.setInt(3, resId);
            ps.executeUpdate();
            System.out.println("Inserted successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectMenuItems() {
        try (Connection con = DBConnection.getConnection()) {
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM MenuItem");
            while (rs.next()) {
                System.out.println(rs.getInt("Id") + " " +
                                   rs.getString("Name") + " " +
                                   rs.getDouble("Price") + " " +
                                   rs.getInt("ResId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updatePrice(int id, double price) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "UPDATE MenuItem SET Price=? WHERE Id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, price);
            ps.setInt(2, id);
            ps.executeUpdate();
            System.out.println("Updated successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteItem(int id) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "DELETE FROM MenuItem WHERE Id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Deleted successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}