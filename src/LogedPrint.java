import com.myweb.DAO;
import com.myweb.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Виталик on 26.05.2016.
 */
@WebServlet(name = "LogedPrint",urlPatterns = "/MainLoged")
public class LogedPrint extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        super.service(req, resp); //To change body of generated methods, choose Tools | Templates.
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //request.getRequestDispatcher("WEB-INF/MainLoged.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id= (int) request.getSession().getAttribute("UserID");
        User user= (User)request.getSession().getAttribute("UserClas");
        System.out.println("ТУт работает");
        String name=user.getName();
        System.out.println(name);
        System.out.println("ТУт пока тоже  работает");
        request.setAttribute("id", id);
        request.getSession().setAttribute("User",name);
        System.out.println("А вот тут?");
        try {
            request.setAttribute("tasks",DAO.getTasksById(id));
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("После обавления ");
        System.out.println("LogedServlet id->"+ id );
        request.getRequestDispatcher("WEB-INF/MainLoged.jsp").forward(request,response);
    }
}
