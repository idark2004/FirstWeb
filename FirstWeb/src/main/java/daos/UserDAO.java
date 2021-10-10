package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.DBConnect;

public class UserDAO {
	public boolean checkLogin(String userName, String password) throws SQLException {
        Connection conn = null; //doi tuong ket noi
        PreparedStatement stm = null; //doi tuong truy van
        ResultSet rs = null;//doi tuong nhan ket qua       

        

        try {
            conn = DBConnect.makeConnection(); // tao doi tuong connection qua DBConnection

            if (conn != null) {
            	String sql = "SELECT * FROM Users WHERE userName=? AND password=? ";
                stm = conn.prepareStatement(sql); // tao truy van
                stm.setString(1, userName); //gan tham so 1 la bien truyen vao
                stm.setString(2, password);
                rs = stm.executeQuery();

                while (rs.next()) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }

            if (stm != null) {
                stm.close();
            }

            if (conn != null) {
                conn.close();
            }
        }
        return false;
    }
}
