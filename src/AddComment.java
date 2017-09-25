import com.myweb.DAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Виталик on 01.06.2016.
 */
@WebServlet(name = "AddComment",urlPatterns = "/CommentAdd")
public class AddComment extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        super.service(req, resp); //To change body of generated methods, choose Tools | Templates.
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description=request.getParameter("SubComment");
        //Simple date format
        System.out.println(description);
        String utf8String= new String(request.getParameter("SubComment").getBytes("UTF-8"), "cp1251");
        System.out.println(utf8String);

        int subTask_Id = Integer.parseInt(request.getParameter("task_id"));
        System.out.println(subTask_Id);

        try {
            DAO.AddComment(subTask_Id,description);
        } catch (ClassNotFoundException  | SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("/getsub?task_id="+subTask_Id);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
