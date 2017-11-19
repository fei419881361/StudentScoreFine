package dao;

import entity.Student;

public interface Istudent {
    Student findStudent(String account,String password);
    //Student loginMethod(String account,String password);
}
