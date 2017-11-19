package controller;

import com.google.gson.Gson;
import entity.Admin;
import entity.Student;
import gson.AutoJson;
import gson.InfoJson;
import gson.LoginJson;
import service.IstudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;

@WebServlet(name = "user", urlPatterns = "/usr")
public class StudentController extends HttpServlet {
    Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String methodName = req.getParameter("method");
        try {
            Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(getClass().newInstance(), req, resp);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    protected void login(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String user = request.getParameter("user");
        LoginJson json = gson.fromJson(user, LoginJson.class);
        ServletOutputStream outputStream = response.getOutputStream();
        InfoJson infoJson = new InfoJson();
        Object objct = null;
        try {
            objct = IstudentServiceImpl.loginService(json.getAccount(), json.getPassword());
            if(objct instanceof Student){
                infoJson.setStatus(true);
                HttpSession session = request.getSession();
                session.setAttribute("type",0);
                session.setAttribute("status",true);
                session.setAttribute("name",((Student) objct).getS_name());
                session.setAttribute("account",((Student) objct).getS_number());
                outputStream.print(gson.toJson(infoJson));
            }else if(objct instanceof Admin){
                HttpSession session = request.getSession();
                session.setAttribute("type",1);
                infoJson.setStatus(true);
                session.setAttribute("status",true);
                session.setAttribute("name",((Admin) objct).getA_name());
                session.setAttribute("account",((Admin) objct).getA_number());
                outputStream.print(gson.toJson(infoJson));
            }else {
                infoJson.setStatus(false);
                outputStream.print(gson.toJson(infoJson));
            }

        } catch (SQLException e) {
            infoJson.setMsg("error");
            infoJson.setStatus(false);
            outputStream.print(gson.toJson(infoJson));
        }


    }

    protected void auto(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        AutoJson autoJson = new AutoJson();
        Boolean status =  (Boolean) session.getAttribute("status");
        if(status){
            autoJson.setStatus(status);
            autoJson.setType((Integer) session.getAttribute("type"));
            autoJson.setAccount((String) session.getAttribute("account"));
            autoJson.setName((String) session.getAttribute("name"));
        }
        ServletOutputStream outputStream = response.getOutputStream();
        try {
            outputStream.print(gson.toJson(autoJson));
        } catch (IOException e) {
            outputStream.print("error");
        }
    }


    protected void findScore(HttpServletRequest request, HttpServletResponse response) {

    }
}
