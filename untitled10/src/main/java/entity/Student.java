package entity;

public class Student {
    private int s_id;
    private String s_name;
    private String s_password;
    private String s_number;

    public Student() {
    }

    public Student(int s_id, String s_name, String s_password, String s_number) {
        this.s_id = s_id;
        this.s_name = s_name;
        this.s_password = s_password;
        this.s_number = s_number;
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getS_password() {
        return s_password;
    }

    public void setS_password(String s_password) {
        this.s_password = s_password;
    }

    public String getS_number() {
        return s_number;
    }

    public void setS_number(String s_number) {
        this.s_number = s_number;
    }
}
