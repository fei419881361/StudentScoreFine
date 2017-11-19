import com.mysql.jdbc.PreparedStatement;
import utils.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserFind {
    public static List<tUser> findUserList(){
        List<tUser> list = new ArrayList<>();
        String sql = "SELECT * FROM t_user";
        PreparedStatement psmt = null;
        try {
            psmt = (PreparedStatement) JDBC.getConnection().prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet rs = null;
        try {
            rs = psmt.executeQuery();
            while(rs.next()){
                int id = rs.getInt("t_id");
                String name = rs.getString("t_username");
                String password = rs.getString("t_userpassword");
                int role = rs.getInt("t_role");
                int status = rs.getInt("t_status");
                tUser u = new tUser(id,name,password,role,status);
                list.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
