package dao;

import entity.Admin;
import entity.Student;
import utils.JDBC;

import javax.swing.text.html.ObjectView;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IstudentImpl implements Istudent {
    public Student findStudent(String account, String password) {
        return null;
    }

    public static Object loginMethod(String account, String password) throws SQLException {
        Connection connection = JDBC.getConnection();
        String sql = "select * from student where s_number = ? AND s_password = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, account);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.getResultSet();

            if (resultSet != null) {
                String name = resultSet.getString("s_name");
                int id = resultSet.getInt("s_id");
                Student student = new Student();
                student.setS_id(id);
                student.setS_number(account);
                student.setS_password(password);
                student.setS_name(name);
                return student;
            } else  {
                Admin admin = loginFromAdmin(account, password);
                return admin;
            }

        } catch (SQLException e) {
            throw e;
        }
    }

    private static Admin loginFromAdmin(String account, String password) throws SQLException {
        Connection connection = JDBC.getConnection();
        String sql = "select * from admin where a_number = ? AND a_password = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, account);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.getResultSet();
            if (resultSet != null) {
                String name = resultSet.getString("a_name");
                int id = resultSet.getInt("a_id");
                Admin admin = new Admin();
                admin.setA_id(id);
                admin.setA_name(name);
                admin.setA_number(account);
                admin.setA_password(password);
                return admin;
            }

        } catch (SQLException e) {
            throw e;
        }
        return null;
    }
}
