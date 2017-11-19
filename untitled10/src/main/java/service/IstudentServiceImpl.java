package service;

import dao.Istudent;
import dao.IstudentImpl;
import entity.Admin;
import entity.Student;

import java.sql.SQLException;

public class IstudentServiceImpl implements IstudentService {
    public Student findSutdent() {

        return null;
    }

    public static Object loginService(String s_number, String s_password) throws SQLException {
        Object result = IstudentImpl.loginMethod(s_number,s_password);
        return result;

    }
}
