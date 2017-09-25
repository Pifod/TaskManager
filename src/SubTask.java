import com.myweb.DAO;
import com.myweb.Task;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Виталик on 27.05.2016.
 */
@WebServlet(name = "SubTask",urlPatterns = "/getsub")
public class SubTask extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        super.service(req, resp); //To change body of generated methods, choose Tools | Templates.
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/https://www.google.ru/");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //response.sendRedirect("/SubTask");
        int subtask_Id=Integer.parseInt(request.getParameter("task_id"));
        int id= (int) request.getSession().getAttribute("UserID");
        request.setAttribute("id", id);
        try {
            request.setAttribute("subTasks", DAO.getSubtaskById(subtask_Id));
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }


        System.out.println(subtask_Id);
        try {
            request.setAttribute("Comments", DAO.getCommentById(subtask_Id));
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        request.setAttribute("subtask_Id",subtask_Id);
        Task curTask=null;
        try {
            curTask=DAO.getTaskById(subtask_Id);
        } catch (SQLException  | ClassNotFoundException e) {
            e.printStackTrace();
        }
        request.setAttribute("CurrTask",curTask);

        request.getRequestDispatcher("WEB-INF/SubTask.jsp").forward(request,response);
    }
}
