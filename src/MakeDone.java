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
@WebServlet(name = "MakeDone", urlPatterns = "/TaskDone")
public class MakeDone extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.sendRedirect("https://www.google.ru/webhp?hl=ru");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int task_id= Integer.parseInt(request.getParameter("task_id"));
        try {
            DAO.MakeDone(task_id);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/MainLoged");
    }
}
