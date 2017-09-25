import com.myweb.DAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Виталик on 02.06.2016.
 */
@WebServlet(name = "DeleteTask",urlPatterns = "/TaskDelete")
public class DeleteTask extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int task_id= Integer.parseInt(request.getParameter("task_id"));
        try {
            DAO.DeleteTask(task_id);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/MainLoged");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int task_id= Integer.parseInt(request.getParameter("task_id"));
        try {
            DAO.DeleteTask(task_id);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/MainLoged");
    }
}
