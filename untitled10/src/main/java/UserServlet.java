import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet",urlPatterns = "/find")
public class UserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<tUser> list = UserFind.findUserList();
        req.setAttribute("list",list);
        req.getRequestDispatcher("userlist.jsp").forward(req,resp);
    }

    @Test
    public void test01(){
        List<tUser> list = UserFind.findUserList();
        System.out.println(list.get(0));

    }
}
